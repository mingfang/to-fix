package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixNstdPtys4SubGrp extends FixGroup {
	private short hasNested4PartySubID;
	byte[] nested4PartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNested4PartySubIDType;
	long nested4PartySubIDType = 0;		
	
	public FixNstdPtys4SubGrp() {
		this(false);
	}

	public FixNstdPtys4SubGrp(boolean isRequired) {
		super(FixTags.NESTED4PARTYSUBID_INT);

		this.isRequired = isRequired;
		
		hasNested4PartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		nested4PartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNested4PartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNested4PartySubID()) return true;
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
            	case FixTags.NESTED4PARTYSUBID_INT:		
            		hasNested4PartySubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTED4PARTYSUBIDTYPE_INT:		
            		hasNested4PartySubIDType = (short) buf.position();		
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
		hasNested4PartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasNested4PartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNested4PartySubID()) {		
			out.put(FixTags.NESTED4PARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,nested4PartySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNested4PartySubIDType()) {		
			out.put(FixTags.NESTED4PARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)nested4PartySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNested4PartySubID()) {		
			FixUtils.put(out,nested4PartySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNested4PartySubIDType()) {		
			FixUtils.put(out, (long)nested4PartySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getNested4PartySubID() { 		
		if ( hasNested4PartySubID()) {		
			if (hasNested4PartySubID == FixUtils.TAG_HAS_VALUE) {		
				return nested4PartySubID; 		
			} else {		
		
				buf.position(hasNested4PartySubID);		
		
			FixMessage.getTagStringValue(buf, nested4PartySubID, 0, nested4PartySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNested4PartySubID);		
					return null;		
				}		
			}		
			hasNested4PartySubID = FixUtils.TAG_HAS_VALUE;		
			return nested4PartySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNested4PartySubID() { return hasNested4PartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested4PartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasNested4PartySubID()) FixUtils.fillNul(nested4PartySubID);		
		FixUtils.copy(nested4PartySubID, src); 		
		hasNested4PartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested4PartySubID(String str) {		
		if (str == null ) return;
		if (hasNested4PartySubID()) FixUtils.fillNul(nested4PartySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(nested4PartySubID, src); 		
		hasNested4PartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNested4PartySubIDType() { 		
		if ( hasNested4PartySubIDType()) {		
			if (hasNested4PartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return nested4PartySubIDType; 		
			} else {		
		
				buf.position(hasNested4PartySubIDType);		
		
			nested4PartySubIDType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNested4PartySubIDType);		
					return 0;		
				}		
			}		
			hasNested4PartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return nested4PartySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNested4PartySubIDType() { return hasNested4PartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested4PartySubIDType(long src) {		
		nested4PartySubIDType = src;
		hasNested4PartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNested4PartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasNested4PartySubIDType()) nested4PartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		nested4PartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasNested4PartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested4PartySubIDType(String str) {		
		if (str == null ) return;
		if (hasNested4PartySubIDType()) nested4PartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		nested4PartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasNested4PartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNested4PartySubID()) s += "Nested4PartySubID(1412)= " + new String( FixUtils.trim(getNested4PartySubID()) ) + "\n" ; 
		if (hasNested4PartySubIDType()) s += "Nested4PartySubIDType(1411)= " + getNested4PartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNstdPtys4SubGrp)) return false;

		FixNstdPtys4SubGrp msg = (FixNstdPtys4SubGrp) o;

		if ((hasNested4PartySubID() && !msg.hasNested4PartySubID()) || (!hasNested4PartySubID() && msg.hasNested4PartySubID())) return false;
		if (!(!hasNested4PartySubID() && !msg.hasNested4PartySubID()) && !FixUtils.equals(getNested4PartySubID(), msg.getNested4PartySubID())) return false;
		if ((hasNested4PartySubIDType() && !msg.hasNested4PartySubIDType()) || (!hasNested4PartySubIDType() && msg.hasNested4PartySubIDType())) return false;
		if (!(!hasNested4PartySubIDType() && !msg.hasNested4PartySubIDType()) && !(getNested4PartySubIDType()==msg.getNested4PartySubIDType())) return false;
		return true;
	}
	public FixNstdPtys4SubGrp clone ( FixNstdPtys4SubGrp out ) {
		if ( hasNested4PartySubID())
			out.setNested4PartySubID(getNested4PartySubID());
		if ( hasNested4PartySubIDType())
			out.setNested4PartySubIDType(getNested4PartySubIDType());
		return out;
	}

}
