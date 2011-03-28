package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixPtysSubGrp extends FixGroup {
	private short hasPartySubID;
	byte[] partySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPartySubIDType;
	long partySubIDType = 0;		
	
	public FixPtysSubGrp() {
		super(FixTags.PARTYSUBID_INT);

		
		hasPartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		partySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasPartySubID()) return true;
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
            	case FixTags.PARTYSUBID_INT:		
            		hasPartySubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PARTYSUBIDTYPE_INT:		
            		hasPartySubIDType = (short) buf.position();		
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
		hasPartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasPartySubID()) {		
			out.put(FixTags.PARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,partySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPartySubIDType()) {		
			out.put(FixTags.PARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)partySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasPartySubID()) {		
			FixUtils.put(out,partySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPartySubIDType()) {		
			FixUtils.put(out, (long)partySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getPartySubID() { 		
		if ( hasPartySubID()) {		
			if (hasPartySubID == FixUtils.TAG_HAS_VALUE) {		
				return partySubID; 		
			} else {		
		
				buf.position(hasPartySubID);		
		
			FixMessage.getTagStringValue(buf, partySubID, 0, partySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPartySubID);		
					return null;		
				}		
			}		
			hasPartySubID = FixUtils.TAG_HAS_VALUE;		
			return partySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPartySubID() { return hasPartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasPartySubID()) FixUtils.fillSpace(partySubID);		
		FixUtils.copy(partySubID, src); 		
		hasPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPartySubID(String str) {		
		if (str == null ) return;
		if (hasPartySubID()) FixUtils.fillSpace(partySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(partySubID, src); 		
		hasPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPartySubIDType() { 		
		if ( hasPartySubIDType()) {		
			if (hasPartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return partySubIDType; 		
			} else {		
		
				buf.position(hasPartySubIDType);		
		
			partySubIDType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPartySubIDType);		
					return 0;		
				}		
			}		
			hasPartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return partySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPartySubIDType() { return hasPartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPartySubIDType(long src) {		
		partySubIDType = src;
		hasPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasPartySubIDType()) partySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		partySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPartySubIDType(String str) {		
		if (str == null ) return;
		if (hasPartySubIDType()) partySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		partySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasPartySubID()) s += "PartySubID(523)= " + new String( FixUtils.trim(getPartySubID()) ) + "\n" ; 
		if (hasPartySubIDType()) s += "PartySubIDType(803)= " + getPartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPtysSubGrp)) return false;

		FixPtysSubGrp msg = (FixPtysSubGrp) o;

		if ((hasPartySubID() && !msg.hasPartySubID()) || (!hasPartySubID() && msg.hasPartySubID())) return false;
		if (!(!hasPartySubID() && !msg.hasPartySubID()) && !FixUtils.equals(getPartySubID(), msg.getPartySubID())) return false;
		if ((hasPartySubIDType() && !msg.hasPartySubIDType()) || (!hasPartySubIDType() && msg.hasPartySubIDType())) return false;
		if (!(!hasPartySubIDType() && !msg.hasPartySubIDType()) && !(getPartySubIDType()==msg.getPartySubIDType())) return false;
		return true;
	}
	public FixPtysSubGrp clone ( FixPtysSubGrp out ) {
		if ( hasPartySubID())
			out.setPartySubID(getPartySubID());
		if ( hasPartySubIDType())
			out.setPartySubIDType(getPartySubIDType());
		return out;
	}

}
