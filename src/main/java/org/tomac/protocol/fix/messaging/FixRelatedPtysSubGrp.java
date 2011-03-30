package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRelatedPtysSubGrp extends FixGroup {
	private short hasRelatedPartySubID;
	byte[] relatedPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelatedPartySubIDType;
	long relatedPartySubIDType = 0;		
	
	public FixRelatedPtysSubGrp() {
		this(false);
	}

	public FixRelatedPtysSubGrp(boolean isRequired) {
		super(FixTags.RELATEDPARTYSUBID_INT);

		this.isRequired = isRequired;
		
		hasRelatedPartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		relatedPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelatedPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRelatedPartySubID()) return true;
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
            	case FixTags.RELATEDPARTYSUBID_INT:		
            		hasRelatedPartySubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATEDPARTYSUBIDTYPE_INT:		
            		hasRelatedPartySubIDType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

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
		hasRelatedPartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasRelatedPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRelatedPartySubID()) {		
			out.put(FixTags.RELATEDPARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,relatedPartySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelatedPartySubIDType()) {		
			out.put(FixTags.RELATEDPARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)relatedPartySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRelatedPartySubID()) {		
			FixUtils.put(out,relatedPartySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelatedPartySubIDType()) {		
			FixUtils.put(out, (long)relatedPartySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getRelatedPartySubID() { 		
		if ( hasRelatedPartySubID()) {		
			if (hasRelatedPartySubID == FixUtils.TAG_HAS_VALUE) {		
				return relatedPartySubID; 		
			} else {		
		
				buf.position(hasRelatedPartySubID);		
		
			FixMessage.getTagStringValue(buf, relatedPartySubID, 0, relatedPartySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedPartySubID);		
					return null;		
				}		
			}		
			hasRelatedPartySubID = FixUtils.TAG_HAS_VALUE;		
			return relatedPartySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelatedPartySubID() { return hasRelatedPartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedPartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedPartySubID()) FixUtils.fillSpace(relatedPartySubID);		
		FixUtils.copy(relatedPartySubID, src); 		
		hasRelatedPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedPartySubID(String str) {		
		if (str == null ) return;
		if (hasRelatedPartySubID()) FixUtils.fillSpace(relatedPartySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relatedPartySubID, src); 		
		hasRelatedPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRelatedPartySubIDType() { 		
		if ( hasRelatedPartySubIDType()) {		
			if (hasRelatedPartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return relatedPartySubIDType; 		
			} else {		
		
				buf.position(hasRelatedPartySubIDType);		
		
			relatedPartySubIDType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedPartySubIDType);		
					return 0;		
				}		
			}		
			hasRelatedPartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return relatedPartySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelatedPartySubIDType() { return hasRelatedPartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedPartySubIDType(long src) {		
		relatedPartySubIDType = src;
		hasRelatedPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelatedPartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedPartySubIDType()) relatedPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		relatedPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasRelatedPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedPartySubIDType(String str) {		
		if (str == null ) return;
		if (hasRelatedPartySubIDType()) relatedPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relatedPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasRelatedPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRelatedPartySubID()) s += "RelatedPartySubID(1567)= " + new String( FixUtils.trim(getRelatedPartySubID()) ) + "\n" ; 
		if (hasRelatedPartySubIDType()) s += "RelatedPartySubIDType(1568)= " + getRelatedPartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRelatedPtysSubGrp)) return false;

		FixRelatedPtysSubGrp msg = (FixRelatedPtysSubGrp) o;

		if ((hasRelatedPartySubID() && !msg.hasRelatedPartySubID()) || (!hasRelatedPartySubID() && msg.hasRelatedPartySubID())) return false;
		if (!(!hasRelatedPartySubID() && !msg.hasRelatedPartySubID()) && !FixUtils.equals(getRelatedPartySubID(), msg.getRelatedPartySubID())) return false;
		if ((hasRelatedPartySubIDType() && !msg.hasRelatedPartySubIDType()) || (!hasRelatedPartySubIDType() && msg.hasRelatedPartySubIDType())) return false;
		if (!(!hasRelatedPartySubIDType() && !msg.hasRelatedPartySubIDType()) && !(getRelatedPartySubIDType()==msg.getRelatedPartySubIDType())) return false;
		return true;
	}
	public FixRelatedPtysSubGrp clone ( FixRelatedPtysSubGrp out ) {
		if ( hasRelatedPartySubID())
			out.setRelatedPartySubID(getRelatedPartySubID());
		if ( hasRelatedPartySubIDType())
			out.setRelatedPartySubIDType(getRelatedPartySubIDType());
		return out;
	}

}
