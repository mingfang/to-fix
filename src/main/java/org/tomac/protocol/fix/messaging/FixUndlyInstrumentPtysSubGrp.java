package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixUndlyInstrumentPtysSubGrp extends FixGroup {
	private short hasUnderlyingInstrumentPartySubID;
	byte[] underlyingInstrumentPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingInstrumentPartySubIDType;
	long underlyingInstrumentPartySubIDType = 0;		
	
	public FixUndlyInstrumentPtysSubGrp() {
		super(FixTags.UNDERLYINGINSTRUMENTPARTYSUBID_INT);

		
		hasUnderlyingInstrumentPartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingInstrumentPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingInstrumentPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasUnderlyingInstrumentPartySubID()) return true;
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
            	case FixTags.UNDERLYINGINSTRUMENTPARTYSUBID_INT:		
            		hasUnderlyingInstrumentPartySubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGINSTRUMENTPARTYSUBIDTYPE_INT:		
            		hasUnderlyingInstrumentPartySubIDType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasUnderlyingInstrumentPartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingInstrumentPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasUnderlyingInstrumentPartySubID()) {		
			out.put(FixTags.UNDERLYINGINSTRUMENTPARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,underlyingInstrumentPartySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingInstrumentPartySubIDType()) {		
			out.put(FixTags.UNDERLYINGINSTRUMENTPARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingInstrumentPartySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasUnderlyingInstrumentPartySubID()) {		
			FixUtils.put(out,underlyingInstrumentPartySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingInstrumentPartySubIDType()) {		
			FixUtils.put(out, (long)underlyingInstrumentPartySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getUnderlyingInstrumentPartySubID() { 		
		if ( hasUnderlyingInstrumentPartySubID()) {		
			if (hasUnderlyingInstrumentPartySubID == FixUtils.TAG_HAS_VALUE) {		
				return underlyingInstrumentPartySubID; 		
			} else {		
		
				buf.position(hasUnderlyingInstrumentPartySubID);		
		
			FixMessage.getTagStringValue(buf, underlyingInstrumentPartySubID, 0, underlyingInstrumentPartySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingInstrumentPartySubID);		
					return null;		
				}		
			}		
			hasUnderlyingInstrumentPartySubID = FixUtils.TAG_HAS_VALUE;		
			return underlyingInstrumentPartySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingInstrumentPartySubID() { return hasUnderlyingInstrumentPartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingInstrumentPartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingInstrumentPartySubID()) FixUtils.fillSpace(underlyingInstrumentPartySubID);		
		FixUtils.copy(underlyingInstrumentPartySubID, src); 		
		hasUnderlyingInstrumentPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingInstrumentPartySubID(String str) {		
		if (str == null ) return;
		if (hasUnderlyingInstrumentPartySubID()) FixUtils.fillSpace(underlyingInstrumentPartySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingInstrumentPartySubID, src); 		
		hasUnderlyingInstrumentPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingInstrumentPartySubIDType() { 		
		if ( hasUnderlyingInstrumentPartySubIDType()) {		
			if (hasUnderlyingInstrumentPartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingInstrumentPartySubIDType; 		
			} else {		
		
				buf.position(hasUnderlyingInstrumentPartySubIDType);		
		
			underlyingInstrumentPartySubIDType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingInstrumentPartySubIDType);		
					return 0;		
				}		
			}		
			hasUnderlyingInstrumentPartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return underlyingInstrumentPartySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingInstrumentPartySubIDType() { return hasUnderlyingInstrumentPartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingInstrumentPartySubIDType(long src) {		
		underlyingInstrumentPartySubIDType = src;
		hasUnderlyingInstrumentPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingInstrumentPartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingInstrumentPartySubIDType()) underlyingInstrumentPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingInstrumentPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingInstrumentPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingInstrumentPartySubIDType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingInstrumentPartySubIDType()) underlyingInstrumentPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingInstrumentPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingInstrumentPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasUnderlyingInstrumentPartySubID()) s += "UnderlyingInstrumentPartySubID(1063)= " + new String( FixUtils.trim(getUnderlyingInstrumentPartySubID()) ) + "\n" ; 
		if (hasUnderlyingInstrumentPartySubIDType()) s += "UnderlyingInstrumentPartySubIDType(1064)= " + getUnderlyingInstrumentPartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUndlyInstrumentPtysSubGrp)) return false;

		FixUndlyInstrumentPtysSubGrp msg = (FixUndlyInstrumentPtysSubGrp) o;

		if ((hasUnderlyingInstrumentPartySubID() && !msg.hasUnderlyingInstrumentPartySubID()) || (!hasUnderlyingInstrumentPartySubID() && msg.hasUnderlyingInstrumentPartySubID())) return false;
		if (!(!hasUnderlyingInstrumentPartySubID() && !msg.hasUnderlyingInstrumentPartySubID()) && !FixUtils.equals(getUnderlyingInstrumentPartySubID(), msg.getUnderlyingInstrumentPartySubID())) return false;
		if ((hasUnderlyingInstrumentPartySubIDType() && !msg.hasUnderlyingInstrumentPartySubIDType()) || (!hasUnderlyingInstrumentPartySubIDType() && msg.hasUnderlyingInstrumentPartySubIDType())) return false;
		if (!(!hasUnderlyingInstrumentPartySubIDType() && !msg.hasUnderlyingInstrumentPartySubIDType()) && !(getUnderlyingInstrumentPartySubIDType()==msg.getUnderlyingInstrumentPartySubIDType())) return false;
		return true;
	}
	public FixUndlyInstrumentPtysSubGrp clone ( FixUndlyInstrumentPtysSubGrp out ) {
		if ( hasUnderlyingInstrumentPartySubID())
			out.setUnderlyingInstrumentPartySubID(getUnderlyingInstrumentPartySubID());
		if ( hasUnderlyingInstrumentPartySubIDType())
			out.setUnderlyingInstrumentPartySubIDType(getUnderlyingInstrumentPartySubIDType());
		return out;
	}

}
