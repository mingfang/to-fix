package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixPartyListGrp extends FixGroup {
		public FixPartyDetail partyDetail;
		public FixRelatedPartyGrp[] relatedPartyGrp;
	
	public FixPartyListGrp() {
		this(false);
	}

	public FixPartyListGrp(boolean isRequired) {
		super(FixTags.PARTYID_INT);

		this.isRequired = isRequired;
		
		partyDetail = new FixPartyDetail();
		relatedPartyGrp = new FixRelatedPartyGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) relatedPartyGrp[i] = new FixRelatedPartyGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (partyDetail.hasGroup()) return true;
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
        			if ( partyDetail.isKeyTag(tag)) {
        				tag = partyDetail.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NORELATEDPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !relatedPartyGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = relatedPartyGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
            }

            tag = FixMessage.getTag(buf, err);
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
		partyDetail.clear();
		for (FixRelatedPartyGrp fixRelatedPartyGrp : relatedPartyGrp) fixRelatedPartyGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		partyDetail.encode(out);
		if (FixUtils.getNoInGroup(relatedPartyGrp)>0) {
			out.put(FixTags.NORELATEDPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(relatedPartyGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRelatedPartyGrp fixRelatedPartyGrp : relatedPartyGrp) if (fixRelatedPartyGrp.hasGroup()) fixRelatedPartyGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		partyDetail.printBuffer(out);
		for (FixRelatedPartyGrp fixRelatedPartyGrp : relatedPartyGrp) fixRelatedPartyGrp.printBuffer(out);
	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		
		s += partyDetail.toString();
		for (FixRelatedPartyGrp fixRelatedPartyGrp : relatedPartyGrp) fixRelatedPartyGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPartyListGrp)) return false;

		FixPartyListGrp msg = (FixPartyListGrp) o;

		if (!partyDetail.equals(msg.partyDetail)) return false;
		for (FixRelatedPartyGrp fixRelatedPartyGrp : relatedPartyGrp)
			if (!fixRelatedPartyGrp.equals(msg.relatedPartyGrp)) return false;
		return true;
	}
	public FixPartyListGrp clone ( FixPartyListGrp out ) {
		if (partyDetail.hasGroup())
			out.partyDetail = partyDetail.clone( out.partyDetail);
		int count = 0;
		count = 0;
		for (FixRelatedPartyGrp fixRelatedPartyGrp : relatedPartyGrp) {
			if (!fixRelatedPartyGrp.hasGroup()) continue;
			out.relatedPartyGrp[count] = fixRelatedPartyGrp.clone( out.relatedPartyGrp[count] );
			count++;
		}
		return out;
	}

}
