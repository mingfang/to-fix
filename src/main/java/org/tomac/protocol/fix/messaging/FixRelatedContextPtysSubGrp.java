package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRelatedContextPtysSubGrp extends FixGroup {
	private short hasRelatedContextPartySubID;
	byte[] relatedContextPartySubID = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasRelatedContextPartySubIDType;
	long relatedContextPartySubIDType = 0;		
	
	public FixRelatedContextPtysSubGrp() {
		this(false);
	}

	public FixRelatedContextPtysSubGrp(boolean isRequired) {
		super(FixTags.RELATEDCONTEXTPARTYSUBID_INT);

		this.isRequired = isRequired;
		
		hasRelatedContextPartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		relatedContextPartySubID = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasRelatedContextPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRelatedContextPartySubID()) return true;
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
            	case FixTags.RELATEDCONTEXTPARTYSUBID_INT:		
            		hasRelatedContextPartySubID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATEDCONTEXTPARTYSUBIDTYPE_INT:		
            		hasRelatedContextPartySubIDType = (short) buf.position();		
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
		hasRelatedContextPartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasRelatedContextPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRelatedContextPartySubID()) {		
			out.put(FixTags.RELATEDCONTEXTPARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,relatedContextPartySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelatedContextPartySubIDType()) {		
			out.put(FixTags.RELATEDCONTEXTPARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)relatedContextPartySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRelatedContextPartySubID()) {		
			FixUtils.put(out,relatedContextPartySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelatedContextPartySubIDType()) {		
			FixUtils.put(out, (long)relatedContextPartySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getRelatedContextPartySubID() { 		
		if ( hasRelatedContextPartySubID()) {		
			if (hasRelatedContextPartySubID == FixUtils.TAG_HAS_VALUE) {		
				return relatedContextPartySubID; 		
			} else {		
		
				buf.position(hasRelatedContextPartySubID);		
		
			FixUtils.getTagStringValue(buf, relatedContextPartySubID, 0, relatedContextPartySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedContextPartySubID);		
					return null;		
				}		
			}		
			hasRelatedContextPartySubID = FixUtils.TAG_HAS_VALUE;		
			return relatedContextPartySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelatedContextPartySubID() { return hasRelatedContextPartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedContextPartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedContextPartySubID()) FixUtils.fillNul(relatedContextPartySubID);		
		FixUtils.copy(relatedContextPartySubID, src); 		
		hasRelatedContextPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedContextPartySubID(String str) {		
		if (str == null ) return;
		if (hasRelatedContextPartySubID()) FixUtils.fillNul(relatedContextPartySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relatedContextPartySubID, src); 		
		hasRelatedContextPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRelatedContextPartySubIDType() { 		
		if ( hasRelatedContextPartySubIDType()) {		
			if (hasRelatedContextPartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return relatedContextPartySubIDType; 		
			} else {		
		
				buf.position(hasRelatedContextPartySubIDType);		
		
			relatedContextPartySubIDType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedContextPartySubIDType);		
					return 0;		
				}		
			}		
			hasRelatedContextPartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return relatedContextPartySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelatedContextPartySubIDType() { return hasRelatedContextPartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedContextPartySubIDType(long src) {		
		relatedContextPartySubIDType = src;
		hasRelatedContextPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelatedContextPartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedContextPartySubIDType()) relatedContextPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		relatedContextPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasRelatedContextPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedContextPartySubIDType(String str) {		
		if (str == null ) return;
		if (hasRelatedContextPartySubIDType()) relatedContextPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relatedContextPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasRelatedContextPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRelatedContextPartySubID()) s += "RelatedContextPartySubID(1580)= " + new String( FixUtils.trim(getRelatedContextPartySubID()) ) + "\n" ; 
		if (hasRelatedContextPartySubIDType()) s += "RelatedContextPartySubIDType(1581)= " + getRelatedContextPartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRelatedContextPtysSubGrp)) return false;

		FixRelatedContextPtysSubGrp msg = (FixRelatedContextPtysSubGrp) o;

		if ((hasRelatedContextPartySubID() && !msg.hasRelatedContextPartySubID()) || (!hasRelatedContextPartySubID() && msg.hasRelatedContextPartySubID())) return false;
		if (!(!hasRelatedContextPartySubID() && !msg.hasRelatedContextPartySubID()) && !FixUtils.equals(getRelatedContextPartySubID(), msg.getRelatedContextPartySubID())) return false;
		if ((hasRelatedContextPartySubIDType() && !msg.hasRelatedContextPartySubIDType()) || (!hasRelatedContextPartySubIDType() && msg.hasRelatedContextPartySubIDType())) return false;
		if (!(!hasRelatedContextPartySubIDType() && !msg.hasRelatedContextPartySubIDType()) && !(getRelatedContextPartySubIDType()==msg.getRelatedContextPartySubIDType())) return false;
		return true;
	}
	public FixRelatedContextPtysSubGrp clone ( FixRelatedContextPtysSubGrp out ) {
		if ( hasRelatedContextPartySubID())
			out.setRelatedContextPartySubID(getRelatedContextPartySubID());
		if ( hasRelatedContextPartySubIDType())
			out.setRelatedContextPartySubIDType(getRelatedContextPartySubIDType());
		return out;
	}

}
