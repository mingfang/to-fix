package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixNstdPtysSubGrp extends FixGroup {
	private short hasNestedPartySubID;
	byte[] nestedPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNestedPartySubIDType;
	long nestedPartySubIDType = 0;		
	
	public FixNstdPtysSubGrp() {
		super(FixTags.NESTEDPARTYSUBID_INT);

		
		hasNestedPartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		nestedPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNestedPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNestedPartySubID()) return true;
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
            	case FixTags.NESTEDPARTYSUBID_INT:		
            		hasNestedPartySubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTEDPARTYSUBIDTYPE_INT:		
            		hasNestedPartySubIDType = (short) buf.position();		
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
		hasNestedPartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasNestedPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNestedPartySubID()) {		
			out.put(FixTags.NESTEDPARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,nestedPartySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNestedPartySubIDType()) {		
			out.put(FixTags.NESTEDPARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)nestedPartySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNestedPartySubID()) {		
			FixUtils.put(out,nestedPartySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNestedPartySubIDType()) {		
			FixUtils.put(out, (long)nestedPartySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getNestedPartySubID() { 		
		if ( hasNestedPartySubID()) {		
			if (hasNestedPartySubID == FixUtils.TAG_HAS_VALUE) {		
				return nestedPartySubID; 		
			} else {		
		
				buf.position(hasNestedPartySubID);		
		
			FixMessage.getTagStringValue(buf, nestedPartySubID, 0, nestedPartySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNestedPartySubID);		
					return null;		
				}		
			}		
			hasNestedPartySubID = FixUtils.TAG_HAS_VALUE;		
			return nestedPartySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNestedPartySubID() { return hasNestedPartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNestedPartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasNestedPartySubID()) FixUtils.fillSpace(nestedPartySubID);		
		FixUtils.copy(nestedPartySubID, src); 		
		hasNestedPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNestedPartySubID(String str) {		
		if (str == null ) return;
		if (hasNestedPartySubID()) FixUtils.fillSpace(nestedPartySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(nestedPartySubID, src); 		
		hasNestedPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNestedPartySubIDType() { 		
		if ( hasNestedPartySubIDType()) {		
			if (hasNestedPartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return nestedPartySubIDType; 		
			} else {		
		
				buf.position(hasNestedPartySubIDType);		
		
			nestedPartySubIDType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNestedPartySubIDType);		
					return 0;		
				}		
			}		
			hasNestedPartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return nestedPartySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNestedPartySubIDType() { return hasNestedPartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNestedPartySubIDType(long src) {		
		nestedPartySubIDType = src;
		hasNestedPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNestedPartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasNestedPartySubIDType()) nestedPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		nestedPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasNestedPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNestedPartySubIDType(String str) {		
		if (str == null ) return;
		if (hasNestedPartySubIDType()) nestedPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		nestedPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasNestedPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNestedPartySubID()) s += "NestedPartySubID(545)= " + new String( FixUtils.trim(getNestedPartySubID()) ) + "\n" ; 
		if (hasNestedPartySubIDType()) s += "NestedPartySubIDType(805)= " + getNestedPartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNstdPtysSubGrp)) return false;

		FixNstdPtysSubGrp msg = (FixNstdPtysSubGrp) o;

		if ((hasNestedPartySubID() && !msg.hasNestedPartySubID()) || (!hasNestedPartySubID() && msg.hasNestedPartySubID())) return false;
		if (!(!hasNestedPartySubID() && !msg.hasNestedPartySubID()) && !FixUtils.equals(getNestedPartySubID(), msg.getNestedPartySubID())) return false;
		if ((hasNestedPartySubIDType() && !msg.hasNestedPartySubIDType()) || (!hasNestedPartySubIDType() && msg.hasNestedPartySubIDType())) return false;
		if (!(!hasNestedPartySubIDType() && !msg.hasNestedPartySubIDType()) && !(getNestedPartySubIDType()==msg.getNestedPartySubIDType())) return false;
		return true;
	}
	public FixNstdPtysSubGrp clone ( FixNstdPtysSubGrp out ) {
		if ( hasNestedPartySubID())
			out.setNestedPartySubID(getNestedPartySubID());
		if ( hasNestedPartySubIDType())
			out.setNestedPartySubIDType(getNestedPartySubIDType());
		return out;
	}

}
