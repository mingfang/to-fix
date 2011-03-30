package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixAltPtysSubGrp extends FixGroup {
	private short hasPartyAltSubID;
	byte[] partyAltSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPartyAltSubIDType;
	long partyAltSubIDType = 0;		
	
	public FixAltPtysSubGrp() {
		this(false);
	}

	public FixAltPtysSubGrp(boolean isRequired) {
		super(FixTags.PARTYALTSUBID_INT);

		this.isRequired = isRequired;
		
		hasPartyAltSubID = FixUtils.TAG_HAS_NO_VALUE;		
		partyAltSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPartyAltSubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasPartyAltSubID()) return true;
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
            	case FixTags.PARTYALTSUBID_INT:		
            		hasPartyAltSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PARTYALTSUBIDTYPE_INT:		
            		hasPartyAltSubIDType = (short) buf.position();		
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
		hasPartyAltSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasPartyAltSubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasPartyAltSubID()) {		
			out.put(FixTags.PARTYALTSUBID);

			out.put((byte) '=');

			FixUtils.put(out,partyAltSubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPartyAltSubIDType()) {		
			out.put(FixTags.PARTYALTSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)partyAltSubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasPartyAltSubID()) {		
			FixUtils.put(out,partyAltSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPartyAltSubIDType()) {		
			FixUtils.put(out, (long)partyAltSubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getPartyAltSubID() { 		
		if ( hasPartyAltSubID()) {		
			if (hasPartyAltSubID == FixUtils.TAG_HAS_VALUE) {		
				return partyAltSubID; 		
			} else {		
		
				buf.position(hasPartyAltSubID);		
		
			FixMessage.getTagStringValue(buf, partyAltSubID, 0, partyAltSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPartyAltSubID);		
					return null;		
				}		
			}		
			hasPartyAltSubID = FixUtils.TAG_HAS_VALUE;		
			return partyAltSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPartyAltSubID() { return hasPartyAltSubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPartyAltSubID(byte[] src) {		
		if (src == null ) return;
		if (hasPartyAltSubID()) FixUtils.fillSpace(partyAltSubID);		
		FixUtils.copy(partyAltSubID, src); 		
		hasPartyAltSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPartyAltSubID(String str) {		
		if (str == null ) return;
		if (hasPartyAltSubID()) FixUtils.fillSpace(partyAltSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(partyAltSubID, src); 		
		hasPartyAltSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPartyAltSubIDType() { 		
		if ( hasPartyAltSubIDType()) {		
			if (hasPartyAltSubIDType == FixUtils.TAG_HAS_VALUE) {		
				return partyAltSubIDType; 		
			} else {		
		
				buf.position(hasPartyAltSubIDType);		
		
			partyAltSubIDType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPartyAltSubIDType);		
					return 0;		
				}		
			}		
			hasPartyAltSubIDType = FixUtils.TAG_HAS_VALUE;		
			return partyAltSubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPartyAltSubIDType() { return hasPartyAltSubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPartyAltSubIDType(long src) {		
		partyAltSubIDType = src;
		hasPartyAltSubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPartyAltSubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasPartyAltSubIDType()) partyAltSubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		partyAltSubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasPartyAltSubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPartyAltSubIDType(String str) {		
		if (str == null ) return;
		if (hasPartyAltSubIDType()) partyAltSubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		partyAltSubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasPartyAltSubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasPartyAltSubID()) s += "PartyAltSubID(1520)= " + new String( FixUtils.trim(getPartyAltSubID()) ) + "\n" ; 
		if (hasPartyAltSubIDType()) s += "PartyAltSubIDType(1521)= " + getPartyAltSubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixAltPtysSubGrp)) return false;

		FixAltPtysSubGrp msg = (FixAltPtysSubGrp) o;

		if ((hasPartyAltSubID() && !msg.hasPartyAltSubID()) || (!hasPartyAltSubID() && msg.hasPartyAltSubID())) return false;
		if (!(!hasPartyAltSubID() && !msg.hasPartyAltSubID()) && !FixUtils.equals(getPartyAltSubID(), msg.getPartyAltSubID())) return false;
		if ((hasPartyAltSubIDType() && !msg.hasPartyAltSubIDType()) || (!hasPartyAltSubIDType() && msg.hasPartyAltSubIDType())) return false;
		if (!(!hasPartyAltSubIDType() && !msg.hasPartyAltSubIDType()) && !(getPartyAltSubIDType()==msg.getPartyAltSubIDType())) return false;
		return true;
	}
	public FixAltPtysSubGrp clone ( FixAltPtysSubGrp out ) {
		if ( hasPartyAltSubID())
			out.setPartyAltSubID(getPartyAltSubID());
		if ( hasPartyAltSubIDType())
			out.setPartyAltSubIDType(getPartyAltSubIDType());
		return out;
	}

}
