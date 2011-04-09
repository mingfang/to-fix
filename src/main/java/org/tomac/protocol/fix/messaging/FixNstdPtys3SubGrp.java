package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixNstdPtys3SubGrp extends FixGroup {
	private short hasNested3PartySubID;
	byte[] nested3PartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNested3PartySubIDType;
	long nested3PartySubIDType = 0;		
	
	public FixNstdPtys3SubGrp() {
		this(false);
	}

	public FixNstdPtys3SubGrp(boolean isRequired) {
		super(FixTags.NESTED3PARTYSUBID_INT);

		this.isRequired = isRequired;
		
		hasNested3PartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		nested3PartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNested3PartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNested3PartySubID()) return true;
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
            	case FixTags.NESTED3PARTYSUBID_INT:		
            		hasNested3PartySubID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTED3PARTYSUBIDTYPE_INT:		
            		hasNested3PartySubIDType = (short) buf.position();		
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
		hasNested3PartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasNested3PartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNested3PartySubID()) {		
			out.put(FixTags.NESTED3PARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,nested3PartySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNested3PartySubIDType()) {		
			out.put(FixTags.NESTED3PARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)nested3PartySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNested3PartySubID()) {		
			FixUtils.put(out,nested3PartySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNested3PartySubIDType()) {		
			FixUtils.put(out, (long)nested3PartySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getNested3PartySubID() { 		
		if ( hasNested3PartySubID()) {		
			if (hasNested3PartySubID == FixUtils.TAG_HAS_VALUE) {		
				return nested3PartySubID; 		
			} else {		
		
				buf.position(hasNested3PartySubID);		
		
			FixUtils.getTagStringValue(buf, nested3PartySubID, 0, nested3PartySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNested3PartySubID);		
					return null;		
				}		
			}		
			hasNested3PartySubID = FixUtils.TAG_HAS_VALUE;		
			return nested3PartySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNested3PartySubID() { return hasNested3PartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested3PartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasNested3PartySubID()) FixUtils.fillNul(nested3PartySubID);		
		FixUtils.copy(nested3PartySubID, src); 		
		hasNested3PartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested3PartySubID(String str) {		
		if (str == null ) return;
		if (hasNested3PartySubID()) FixUtils.fillNul(nested3PartySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(nested3PartySubID, src); 		
		hasNested3PartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNested3PartySubIDType() { 		
		if ( hasNested3PartySubIDType()) {		
			if (hasNested3PartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return nested3PartySubIDType; 		
			} else {		
		
				buf.position(hasNested3PartySubIDType);		
		
			nested3PartySubIDType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNested3PartySubIDType);		
					return 0;		
				}		
			}		
			hasNested3PartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return nested3PartySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNested3PartySubIDType() { return hasNested3PartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested3PartySubIDType(long src) {		
		nested3PartySubIDType = src;
		hasNested3PartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNested3PartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasNested3PartySubIDType()) nested3PartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		nested3PartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasNested3PartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested3PartySubIDType(String str) {		
		if (str == null ) return;
		if (hasNested3PartySubIDType()) nested3PartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		nested3PartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasNested3PartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNested3PartySubID()) s += "Nested3PartySubID(953)= " + new String( FixUtils.trim(getNested3PartySubID()) ) + "\n" ; 
		if (hasNested3PartySubIDType()) s += "Nested3PartySubIDType(954)= " + getNested3PartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNstdPtys3SubGrp)) return false;

		FixNstdPtys3SubGrp msg = (FixNstdPtys3SubGrp) o;

		if ((hasNested3PartySubID() && !msg.hasNested3PartySubID()) || (!hasNested3PartySubID() && msg.hasNested3PartySubID())) return false;
		if (!(!hasNested3PartySubID() && !msg.hasNested3PartySubID()) && !FixUtils.equals(getNested3PartySubID(), msg.getNested3PartySubID())) return false;
		if ((hasNested3PartySubIDType() && !msg.hasNested3PartySubIDType()) || (!hasNested3PartySubIDType() && msg.hasNested3PartySubIDType())) return false;
		if (!(!hasNested3PartySubIDType() && !msg.hasNested3PartySubIDType()) && !(getNested3PartySubIDType()==msg.getNested3PartySubIDType())) return false;
		return true;
	}
	public FixNstdPtys3SubGrp clone ( FixNstdPtys3SubGrp out ) {
		if ( hasNested3PartySubID())
			out.setNested3PartySubID(getNested3PartySubID());
		if ( hasNested3PartySubIDType())
			out.setNested3PartySubIDType(getNested3PartySubIDType());
		return out;
	}

}
