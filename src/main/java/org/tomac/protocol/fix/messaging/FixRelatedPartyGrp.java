package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRelatedPartyGrp extends FixGroup {
		FixRelatedPartyDetail relatedPartyDetail;
		FixPartyRelationships[] partyRelationships;
	
	public FixRelatedPartyGrp() {
		super(FixTags.RELATEDPARTYID_INT);

		
		relatedPartyDetail = new FixRelatedPartyDetail();
		partyRelationships = new FixPartyRelationships[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) partyRelationships[i] = new FixPartyRelationships();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (relatedPartyDetail.hasGroup()) return true;
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
        			if ( relatedPartyDetail.isKeyTag(tag)) {
        				tag = relatedPartyDetail.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOPARTYRELATIONSHIPS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !partyRelationships[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = partyRelationships[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		relatedPartyDetail.clear();
		for (FixPartyRelationships fixPartyRelationships : partyRelationships) fixPartyRelationships.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		relatedPartyDetail.encode(out);
		for (FixPartyRelationships fixPartyRelationships : partyRelationships) fixPartyRelationships.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		relatedPartyDetail.printBuffer(out);
		for (FixPartyRelationships fixPartyRelationships : partyRelationships) fixPartyRelationships.printBuffer(out);
	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		
		s += relatedPartyDetail.toString();
		for (FixPartyRelationships fixPartyRelationships : partyRelationships) fixPartyRelationships.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRelatedPartyGrp)) return false;

		FixRelatedPartyGrp msg = (FixRelatedPartyGrp) o;

		if (!relatedPartyDetail.equals(msg.relatedPartyDetail)) return false;
		for (FixPartyRelationships fixPartyRelationships : partyRelationships)
			if (!fixPartyRelationships.equals(msg.partyRelationships)) return false;
		return true;
	}
	public FixRelatedPartyGrp clone ( FixRelatedPartyGrp out ) {
		if (relatedPartyDetail.hasGroup())
			out.relatedPartyDetail = relatedPartyDetail.clone( out.relatedPartyDetail);
		int count = 0;
		count = 0;
		for (FixPartyRelationships fixPartyRelationships : partyRelationships) {
			if (!fixPartyRelationships.hasGroup()) continue;
			out.partyRelationships[count] = fixPartyRelationships.clone( out.partyRelationships[count] );
			count++;
		}
		return out;
	}

}
