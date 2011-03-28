package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSettlPtysSubGrp extends FixGroup {
	private short hasSettlPartySubID;
	byte[] settlPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlPartySubIDType;
	long settlPartySubIDType = 0;		
	
	public FixSettlPtysSubGrp() {
		super(FixTags.SETTLPARTYSUBID_INT);

		
		hasSettlPartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		settlPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSettlPartySubID()) return true;
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
            	case FixTags.SETTLPARTYSUBID_INT:		
            		hasSettlPartySubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLPARTYSUBIDTYPE_INT:		
            		hasSettlPartySubIDType = (short) buf.position();		
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
		hasSettlPartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSettlPartySubID()) {		
			out.put(FixTags.SETTLPARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,settlPartySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlPartySubIDType()) {		
			out.put(FixTags.SETTLPARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)settlPartySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSettlPartySubID()) {		
			FixUtils.put(out,settlPartySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlPartySubIDType()) {		
			FixUtils.put(out, (long)settlPartySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getSettlPartySubID() { 		
		if ( hasSettlPartySubID()) {		
			if (hasSettlPartySubID == FixUtils.TAG_HAS_VALUE) {		
				return settlPartySubID; 		
			} else {		
		
				buf.position(hasSettlPartySubID);		
		
			FixMessage.getTagStringValue(buf, settlPartySubID, 0, settlPartySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlPartySubID);		
					return null;		
				}		
			}		
			hasSettlPartySubID = FixUtils.TAG_HAS_VALUE;		
			return settlPartySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlPartySubID() { return hasSettlPartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlPartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlPartySubID()) FixUtils.fillSpace(settlPartySubID);		
		FixUtils.copy(settlPartySubID, src); 		
		hasSettlPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlPartySubID(String str) {		
		if (str == null ) return;
		if (hasSettlPartySubID()) FixUtils.fillSpace(settlPartySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlPartySubID, src); 		
		hasSettlPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSettlPartySubIDType() { 		
		if ( hasSettlPartySubIDType()) {		
			if (hasSettlPartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return settlPartySubIDType; 		
			} else {		
		
				buf.position(hasSettlPartySubIDType);		
		
			settlPartySubIDType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlPartySubIDType);		
					return 0;		
				}		
			}		
			hasSettlPartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return settlPartySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlPartySubIDType() { return hasSettlPartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlPartySubIDType(long src) {		
		settlPartySubIDType = src;
		hasSettlPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlPartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasSettlPartySubIDType()) settlPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		settlPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasSettlPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlPartySubIDType(String str) {		
		if (str == null ) return;
		if (hasSettlPartySubIDType()) settlPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasSettlPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSettlPartySubID()) s += "SettlPartySubID(785)= " + new String( FixUtils.trim(getSettlPartySubID()) ) + "\n" ; 
		if (hasSettlPartySubIDType()) s += "SettlPartySubIDType(786)= " + getSettlPartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSettlPtysSubGrp)) return false;

		FixSettlPtysSubGrp msg = (FixSettlPtysSubGrp) o;

		if ((hasSettlPartySubID() && !msg.hasSettlPartySubID()) || (!hasSettlPartySubID() && msg.hasSettlPartySubID())) return false;
		if (!(!hasSettlPartySubID() && !msg.hasSettlPartySubID()) && !FixUtils.equals(getSettlPartySubID(), msg.getSettlPartySubID())) return false;
		if ((hasSettlPartySubIDType() && !msg.hasSettlPartySubIDType()) || (!hasSettlPartySubIDType() && msg.hasSettlPartySubIDType())) return false;
		if (!(!hasSettlPartySubIDType() && !msg.hasSettlPartySubIDType()) && !(getSettlPartySubIDType()==msg.getSettlPartySubIDType())) return false;
		return true;
	}
	public FixSettlPtysSubGrp clone ( FixSettlPtysSubGrp out ) {
		if ( hasSettlPartySubID())
			out.setSettlPartySubID(getSettlPartySubID());
		if ( hasSettlPartySubIDType())
			out.setSettlPartySubIDType(getSettlPartySubIDType());
		return out;
	}

}
