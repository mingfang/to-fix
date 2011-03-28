package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixNstdPtys2SubGrp extends FixGroup {
	private short hasNested2PartySubID;
	byte[] nested2PartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNested2PartySubIDType;
	long nested2PartySubIDType = 0;		
	
	public FixNstdPtys2SubGrp() {
		super(FixTags.NESTED2PARTYSUBID_INT);

		
		hasNested2PartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		nested2PartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNested2PartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNested2PartySubID()) return true;
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
            	case FixTags.NESTED2PARTYSUBID_INT:		
            		hasNested2PartySubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTED2PARTYSUBIDTYPE_INT:		
            		hasNested2PartySubIDType = (short) buf.position();		
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
		hasNested2PartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasNested2PartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNested2PartySubID()) {		
			out.put(FixTags.NESTED2PARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,nested2PartySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNested2PartySubIDType()) {		
			out.put(FixTags.NESTED2PARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)nested2PartySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNested2PartySubID()) {		
			FixUtils.put(out,nested2PartySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNested2PartySubIDType()) {		
			FixUtils.put(out, (long)nested2PartySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getNested2PartySubID() { 		
		if ( hasNested2PartySubID()) {		
			if (hasNested2PartySubID == FixUtils.TAG_HAS_VALUE) {		
				return nested2PartySubID; 		
			} else {		
		
				buf.position(hasNested2PartySubID);		
		
			FixMessage.getTagStringValue(buf, nested2PartySubID, 0, nested2PartySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNested2PartySubID);		
					return null;		
				}		
			}		
			hasNested2PartySubID = FixUtils.TAG_HAS_VALUE;		
			return nested2PartySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNested2PartySubID() { return hasNested2PartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested2PartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasNested2PartySubID()) FixUtils.fillSpace(nested2PartySubID);		
		FixUtils.copy(nested2PartySubID, src); 		
		hasNested2PartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested2PartySubID(String str) {		
		if (str == null ) return;
		if (hasNested2PartySubID()) FixUtils.fillSpace(nested2PartySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(nested2PartySubID, src); 		
		hasNested2PartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNested2PartySubIDType() { 		
		if ( hasNested2PartySubIDType()) {		
			if (hasNested2PartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return nested2PartySubIDType; 		
			} else {		
		
				buf.position(hasNested2PartySubIDType);		
		
			nested2PartySubIDType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNested2PartySubIDType);		
					return 0;		
				}		
			}		
			hasNested2PartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return nested2PartySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNested2PartySubIDType() { return hasNested2PartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested2PartySubIDType(long src) {		
		nested2PartySubIDType = src;
		hasNested2PartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNested2PartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasNested2PartySubIDType()) nested2PartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		nested2PartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasNested2PartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested2PartySubIDType(String str) {		
		if (str == null ) return;
		if (hasNested2PartySubIDType()) nested2PartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		nested2PartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasNested2PartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNested2PartySubID()) s += "Nested2PartySubID(760)= " + new String( FixUtils.trim(getNested2PartySubID()) ) + "\n" ; 
		if (hasNested2PartySubIDType()) s += "Nested2PartySubIDType(807)= " + getNested2PartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNstdPtys2SubGrp)) return false;

		FixNstdPtys2SubGrp msg = (FixNstdPtys2SubGrp) o;

		if ((hasNested2PartySubID() && !msg.hasNested2PartySubID()) || (!hasNested2PartySubID() && msg.hasNested2PartySubID())) return false;
		if (!(!hasNested2PartySubID() && !msg.hasNested2PartySubID()) && !FixUtils.equals(getNested2PartySubID(), msg.getNested2PartySubID())) return false;
		if ((hasNested2PartySubIDType() && !msg.hasNested2PartySubIDType()) || (!hasNested2PartySubIDType() && msg.hasNested2PartySubIDType())) return false;
		if (!(!hasNested2PartySubIDType() && !msg.hasNested2PartySubIDType()) && !(getNested2PartySubIDType()==msg.getNested2PartySubIDType())) return false;
		return true;
	}
	public FixNstdPtys2SubGrp clone ( FixNstdPtys2SubGrp out ) {
		if ( hasNested2PartySubID())
			out.setNested2PartySubID(getNested2PartySubID());
		if ( hasNested2PartySubIDType())
			out.setNested2PartySubIDType(getNested2PartySubIDType());
		return out;
	}

}
