package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRelatedAltPtysSubGrp extends FixGroup {
	private short hasRelatedPartyAltSubID;
	byte[] relatedPartyAltSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelatedPartyAltSubIDType;
	long relatedPartyAltSubIDType = 0;		
	
	public FixRelatedAltPtysSubGrp() {
		this(false);
	}

	public FixRelatedAltPtysSubGrp(boolean isRequired) {
		super(FixTags.RELATEDPARTYALTSUBID_INT);

		this.isRequired = isRequired;
		
		hasRelatedPartyAltSubID = FixUtils.TAG_HAS_NO_VALUE;		
		relatedPartyAltSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelatedPartyAltSubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRelatedPartyAltSubID()) return true;
		else return false;
	}


	/**
     * Parse FIX Group. The buffer is positioned at the value of the tag.
     */
    public int setBuffer( int tag, ByteBuffer buf, FixValidationError err)
    {

		super.err = err;
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.RELATEDPARTYALTSUBID_INT:		
            		hasRelatedPartyAltSubID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATEDPARTYALTSUBIDTYPE_INT:		
            		hasRelatedPartyAltSubIDType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

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
		hasRelatedPartyAltSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasRelatedPartyAltSubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRelatedPartyAltSubID()) {		
			out.put(FixTags.RELATEDPARTYALTSUBID);

			out.put((byte) '=');

			FixUtils.put(out,relatedPartyAltSubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelatedPartyAltSubIDType()) {		
			out.put(FixTags.RELATEDPARTYALTSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)relatedPartyAltSubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRelatedPartyAltSubID()) {		
			FixUtils.put(out,relatedPartyAltSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelatedPartyAltSubIDType()) {		
			FixUtils.put(out, (long)relatedPartyAltSubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getRelatedPartyAltSubID() { 		
		if ( hasRelatedPartyAltSubID()) {		
			if (hasRelatedPartyAltSubID == FixUtils.TAG_HAS_VALUE) {		
				return relatedPartyAltSubID; 		
			} else {		
		
				buf.position(hasRelatedPartyAltSubID);		
		
			FixUtils.getTagStringValue(buf, relatedPartyAltSubID, 0, relatedPartyAltSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedPartyAltSubID);		
					return null;		
				}		
			}		
			hasRelatedPartyAltSubID = FixUtils.TAG_HAS_VALUE;		
			return relatedPartyAltSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelatedPartyAltSubID() { return hasRelatedPartyAltSubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedPartyAltSubID(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedPartyAltSubID()) FixUtils.fillNul(relatedPartyAltSubID);		
		FixUtils.copy(relatedPartyAltSubID, src); 		
		hasRelatedPartyAltSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedPartyAltSubID(String str) {		
		if (str == null ) return;
		if (hasRelatedPartyAltSubID()) FixUtils.fillNul(relatedPartyAltSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relatedPartyAltSubID, src); 		
		hasRelatedPartyAltSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRelatedPartyAltSubIDType() { 		
		if ( hasRelatedPartyAltSubIDType()) {		
			if (hasRelatedPartyAltSubIDType == FixUtils.TAG_HAS_VALUE) {		
				return relatedPartyAltSubIDType; 		
			} else {		
		
				buf.position(hasRelatedPartyAltSubIDType);		
		
			relatedPartyAltSubIDType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedPartyAltSubIDType);		
					return 0;		
				}		
			}		
			hasRelatedPartyAltSubIDType = FixUtils.TAG_HAS_VALUE;		
			return relatedPartyAltSubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelatedPartyAltSubIDType() { return hasRelatedPartyAltSubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedPartyAltSubIDType(long src) {		
		relatedPartyAltSubIDType = src;
		hasRelatedPartyAltSubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelatedPartyAltSubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedPartyAltSubIDType()) relatedPartyAltSubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		relatedPartyAltSubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasRelatedPartyAltSubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedPartyAltSubIDType(String str) {		
		if (str == null ) return;
		if (hasRelatedPartyAltSubIDType()) relatedPartyAltSubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relatedPartyAltSubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasRelatedPartyAltSubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRelatedPartyAltSubID()) s += "RelatedPartyAltSubID(1573)= " + new String( FixUtils.trim(getRelatedPartyAltSubID()) ) + "\n" ; 
		if (hasRelatedPartyAltSubIDType()) s += "RelatedPartyAltSubIDType(1574)= " + getRelatedPartyAltSubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRelatedAltPtysSubGrp)) return false;

		FixRelatedAltPtysSubGrp msg = (FixRelatedAltPtysSubGrp) o;

		if ((hasRelatedPartyAltSubID() && !msg.hasRelatedPartyAltSubID()) || (!hasRelatedPartyAltSubID() && msg.hasRelatedPartyAltSubID())) return false;
		if (!(!hasRelatedPartyAltSubID() && !msg.hasRelatedPartyAltSubID()) && !FixUtils.equals(getRelatedPartyAltSubID(), msg.getRelatedPartyAltSubID())) return false;
		if ((hasRelatedPartyAltSubIDType() && !msg.hasRelatedPartyAltSubIDType()) || (!hasRelatedPartyAltSubIDType() && msg.hasRelatedPartyAltSubIDType())) return false;
		if (!(!hasRelatedPartyAltSubIDType() && !msg.hasRelatedPartyAltSubIDType()) && !(getRelatedPartyAltSubIDType()==msg.getRelatedPartyAltSubIDType())) return false;
		return true;
	}
	public FixRelatedAltPtysSubGrp clone ( FixRelatedAltPtysSubGrp out ) {
		if ( hasRelatedPartyAltSubID())
			out.setRelatedPartyAltSubID(getRelatedPartyAltSubID());
		if ( hasRelatedPartyAltSubIDType())
			out.setRelatedPartyAltSubIDType(getRelatedPartyAltSubIDType());
		return out;
	}

}
