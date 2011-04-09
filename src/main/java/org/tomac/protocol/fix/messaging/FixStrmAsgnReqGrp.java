package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixStrmAsgnReqGrp extends FixGroup {
		public FixParties[] parties;
		public FixStrmAsgnReqInstrmtGrp[] strmAsgnReqInstrmtGrp;
	
	public FixStrmAsgnReqGrp() {
		this(false);
	}

	public FixStrmAsgnReqGrp(boolean isRequired) {
		super(FixTags.PARTYID_INT);

		this.isRequired = isRequired;
		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		strmAsgnReqInstrmtGrp = new FixStrmAsgnReqInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) strmAsgnReqInstrmtGrp[i] = new FixStrmAsgnReqInstrmtGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (parties[0].hasGroup()) return true;
		else return false;
	}


	/**
     * Parse FIX Group. The buffer is positioned at the value of the tag.
     */
    public int setBuffer( int tag, ByteBuffer buf, FixValidationError err)
    {

		super.err = err;
		super.err.clear();
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	default:
        			if ( tag == FixTags.NOPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !parties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NORELATEDSYM_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !strmAsgnReqInstrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = strmAsgnReqInstrmtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
            }

            tag = FixUtils.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
            if (isKeyTag(tag)) return tag; // next in repeating group
        }		
        return tag;
    }		
	public boolean hasRequiredTags(FixValidationError err) {
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		for (FixParties fixParties : parties) fixParties.clear();
		for (FixStrmAsgnReqInstrmtGrp fixStrmAsgnReqInstrmtGrp : strmAsgnReqInstrmtGrp) fixStrmAsgnReqInstrmtGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(strmAsgnReqInstrmtGrp)>0) {
			out.put(FixTags.NORELATEDSYM);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(strmAsgnReqInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixStrmAsgnReqInstrmtGrp fixStrmAsgnReqInstrmtGrp : strmAsgnReqInstrmtGrp) if (fixStrmAsgnReqInstrmtGrp.hasGroup()) fixStrmAsgnReqInstrmtGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		for (FixParties fixParties : parties) fixParties.printBuffer(out);
		for (FixStrmAsgnReqInstrmtGrp fixStrmAsgnReqInstrmtGrp : strmAsgnReqInstrmtGrp) fixStrmAsgnReqInstrmtGrp.printBuffer(out);
	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		
		for (FixParties fixParties : parties) fixParties.toString();
		for (FixStrmAsgnReqInstrmtGrp fixStrmAsgnReqInstrmtGrp : strmAsgnReqInstrmtGrp) fixStrmAsgnReqInstrmtGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStrmAsgnReqGrp)) return false;

		FixStrmAsgnReqGrp msg = (FixStrmAsgnReqGrp) o;

		for (int i = 0; i < parties.length; i++)
			if (!parties[i].equals(msg.parties[i])) return false;
		for (int i = 0; i < strmAsgnReqInstrmtGrp.length; i++)
			if (!strmAsgnReqInstrmtGrp[i].equals(msg.strmAsgnReqInstrmtGrp[i])) return false;
		return true;
	}
	public FixStrmAsgnReqGrp clone ( FixStrmAsgnReqGrp out ) {
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixStrmAsgnReqInstrmtGrp fixStrmAsgnReqInstrmtGrp : strmAsgnReqInstrmtGrp) {
			if (!fixStrmAsgnReqInstrmtGrp.hasGroup()) continue;
			out.strmAsgnReqInstrmtGrp[count] = fixStrmAsgnReqInstrmtGrp.clone( out.strmAsgnReqInstrmtGrp[count] );
			count++;
		}
		return out;
	}

}
