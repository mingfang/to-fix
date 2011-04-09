package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRelatedPartyAltIDs extends FixGroup {
	private short hasRelatedPartyAltID;
	byte[] relatedPartyAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelatedPartyAltIDSource;
	byte relatedPartyAltIDSource = (byte)' ';		
		public FixRelatedAltPtysSubGrp[] relatedAltPtysSubGrp;
	
	public FixRelatedPartyAltIDs() {
		this(false);
	}

	public FixRelatedPartyAltIDs(boolean isRequired) {
		super(FixTags.RELATEDPARTYALTID_INT);

		this.isRequired = isRequired;
		
		hasRelatedPartyAltID = FixUtils.TAG_HAS_NO_VALUE;		
		relatedPartyAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelatedPartyAltIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		relatedAltPtysSubGrp = new FixRelatedAltPtysSubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) relatedAltPtysSubGrp[i] = new FixRelatedAltPtysSubGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRelatedPartyAltID()) return true;
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
            	case FixTags.RELATEDPARTYALTID_INT:		
            		hasRelatedPartyAltID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATEDPARTYALTIDSOURCE_INT:		
            		hasRelatedPartyAltIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NORELATEDPARTYALTSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !relatedAltPtysSubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = relatedAltPtysSubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasRelatedPartyAltID = FixUtils.TAG_HAS_NO_VALUE;
		hasRelatedPartyAltIDSource = FixUtils.TAG_HAS_NO_VALUE;
		for (FixRelatedAltPtysSubGrp fixRelatedAltPtysSubGrp : relatedAltPtysSubGrp) fixRelatedAltPtysSubGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRelatedPartyAltID()) {		
			out.put(FixTags.RELATEDPARTYALTID);

			out.put((byte) '=');

			FixUtils.put(out,relatedPartyAltID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelatedPartyAltIDSource()) {		
			out.put(FixTags.RELATEDPARTYALTIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,relatedPartyAltIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(relatedAltPtysSubGrp)>0) {
			out.put(FixTags.NORELATEDPARTYALTSUBIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(relatedAltPtysSubGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRelatedAltPtysSubGrp fixRelatedAltPtysSubGrp : relatedAltPtysSubGrp) if (fixRelatedAltPtysSubGrp.hasGroup()) fixRelatedAltPtysSubGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRelatedPartyAltID()) {		
			FixUtils.put(out,relatedPartyAltID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelatedPartyAltIDSource()) {		
			FixUtils.put(out,relatedPartyAltIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixRelatedAltPtysSubGrp fixRelatedAltPtysSubGrp : relatedAltPtysSubGrp) fixRelatedAltPtysSubGrp.printBuffer(out);
	}

	public byte[] getRelatedPartyAltID() { 		
		if ( hasRelatedPartyAltID()) {		
			if (hasRelatedPartyAltID == FixUtils.TAG_HAS_VALUE) {		
				return relatedPartyAltID; 		
			} else {		
		
				buf.position(hasRelatedPartyAltID);		
		
			FixUtils.getTagStringValue(buf, relatedPartyAltID, 0, relatedPartyAltID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedPartyAltID);		
					return null;		
				}		
			}		
			hasRelatedPartyAltID = FixUtils.TAG_HAS_VALUE;		
			return relatedPartyAltID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelatedPartyAltID() { return hasRelatedPartyAltID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedPartyAltID(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedPartyAltID()) FixUtils.fillNul(relatedPartyAltID);		
		FixUtils.copy(relatedPartyAltID, src); 		
		hasRelatedPartyAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedPartyAltID(String str) {		
		if (str == null ) return;
		if (hasRelatedPartyAltID()) FixUtils.fillNul(relatedPartyAltID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relatedPartyAltID, src); 		
		hasRelatedPartyAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getRelatedPartyAltIDSource() { 		
		if ( hasRelatedPartyAltIDSource()) {		
			if (hasRelatedPartyAltIDSource == FixUtils.TAG_HAS_VALUE) {		
				return relatedPartyAltIDSource; 		
			} else {		
		
				buf.position(hasRelatedPartyAltIDSource);		
		
			relatedPartyAltIDSource = FixUtils.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedPartyAltIDSource);		
					return (byte)'0';		
				}		
			}		
			hasRelatedPartyAltIDSource = FixUtils.TAG_HAS_VALUE;		
			return relatedPartyAltIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasRelatedPartyAltIDSource() { return hasRelatedPartyAltIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedPartyAltIDSource(byte src) {		
		relatedPartyAltIDSource = src;
		hasRelatedPartyAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelatedPartyAltIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedPartyAltIDSource()) relatedPartyAltIDSource = (byte)' ';		
		relatedPartyAltIDSource = src[0];		
		hasRelatedPartyAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedPartyAltIDSource(String str) {		
		if (str == null ) return;
		if (hasRelatedPartyAltIDSource()) relatedPartyAltIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		relatedPartyAltIDSource = src[0];		
		hasRelatedPartyAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRelatedPartyAltID()) s += "RelatedPartyAltID(1570)= " + new String( FixUtils.trim(getRelatedPartyAltID()) ) + "\n" ; 
		if (hasRelatedPartyAltIDSource()) s += "RelatedPartyAltIDSource(1571)= " + getRelatedPartyAltIDSource() + "\n" ; 

		for (FixRelatedAltPtysSubGrp fixRelatedAltPtysSubGrp : relatedAltPtysSubGrp) fixRelatedAltPtysSubGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRelatedPartyAltIDs)) return false;

		FixRelatedPartyAltIDs msg = (FixRelatedPartyAltIDs) o;

		for (int i = 0; i < relatedAltPtysSubGrp.length; i++)
			if (!relatedAltPtysSubGrp[i].equals(msg.relatedAltPtysSubGrp[i])) return false;
		if ((hasRelatedPartyAltID() && !msg.hasRelatedPartyAltID()) || (!hasRelatedPartyAltID() && msg.hasRelatedPartyAltID())) return false;
		if (!(!hasRelatedPartyAltID() && !msg.hasRelatedPartyAltID()) && !FixUtils.equals(getRelatedPartyAltID(), msg.getRelatedPartyAltID())) return false;
		if ((hasRelatedPartyAltIDSource() && !msg.hasRelatedPartyAltIDSource()) || (!hasRelatedPartyAltIDSource() && msg.hasRelatedPartyAltIDSource())) return false;
		if (!(!hasRelatedPartyAltIDSource() && !msg.hasRelatedPartyAltIDSource()) && !(getRelatedPartyAltIDSource()==msg.getRelatedPartyAltIDSource())) return false;
		return true;
	}
	public FixRelatedPartyAltIDs clone ( FixRelatedPartyAltIDs out ) {
		if ( hasRelatedPartyAltID())
			out.setRelatedPartyAltID(getRelatedPartyAltID());
		if ( hasRelatedPartyAltIDSource())
			out.setRelatedPartyAltIDSource(getRelatedPartyAltIDSource());
		int count = 0;
		count = 0;
		for (FixRelatedAltPtysSubGrp fixRelatedAltPtysSubGrp : relatedAltPtysSubGrp) {
			if (!fixRelatedAltPtysSubGrp.hasGroup()) continue;
			out.relatedAltPtysSubGrp[count] = fixRelatedAltPtysSubGrp.clone( out.relatedAltPtysSubGrp[count] );
			count++;
		}
		return out;
	}

}
