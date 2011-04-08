package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixPartyListResponseTypeGrp extends FixGroup {
	private short hasPartyListResponseType;
	long partyListResponseType = 0;		
	
	public FixPartyListResponseTypeGrp() {
		this(false);
	}

	public FixPartyListResponseTypeGrp(boolean isRequired) {
		super(FixTags.PARTYLISTRESPONSETYPE_INT);

		this.isRequired = isRequired;
		
		hasPartyListResponseType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasPartyListResponseType()) return true;
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
            	case FixTags.PARTYLISTRESPONSETYPE_INT:		
            		hasPartyListResponseType = (short) buf.position();		
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
		if (!hasPartyListResponseType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.PARTYLISTRESPONSETYPE_INT);
			return false;
		}
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasPartyListResponseType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasPartyListResponseType()) {		
			out.put(FixTags.PARTYLISTRESPONSETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)partyListResponseType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasPartyListResponseType()) {		
			FixUtils.put(out, (long)partyListResponseType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getPartyListResponseType() { 		
		if ( hasPartyListResponseType()) {		
			if (hasPartyListResponseType == FixUtils.TAG_HAS_VALUE) {		
				return partyListResponseType; 		
			} else {		
		
				buf.position(hasPartyListResponseType);		
		
			partyListResponseType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPartyListResponseType);		
					return 0;		
				}		
			}		
			hasPartyListResponseType = FixUtils.TAG_HAS_VALUE;		
			return partyListResponseType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPartyListResponseType() { return hasPartyListResponseType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPartyListResponseType(long src) {		
		partyListResponseType = src;
		hasPartyListResponseType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPartyListResponseType(byte[] src) {		
		if (src == null ) return;
		if (hasPartyListResponseType()) partyListResponseType = FixUtils.TAG_HAS_NO_VALUE;		
		partyListResponseType = FixUtils.longValueOf(src, 0, src.length);
		hasPartyListResponseType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPartyListResponseType(String str) {		
		if (str == null ) return;
		if (hasPartyListResponseType()) partyListResponseType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		partyListResponseType = FixUtils.longValueOf(src, 0, src.length);
		hasPartyListResponseType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasPartyListResponseType()) s += "PartyListResponseType(1507)= " + getPartyListResponseType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPartyListResponseTypeGrp)) return false;

		FixPartyListResponseTypeGrp msg = (FixPartyListResponseTypeGrp) o;

		if ((hasPartyListResponseType() && !msg.hasPartyListResponseType()) || (!hasPartyListResponseType() && msg.hasPartyListResponseType())) return false;
		if (!(!hasPartyListResponseType() && !msg.hasPartyListResponseType()) && !(getPartyListResponseType()==msg.getPartyListResponseType())) return false;
		return true;
	}
	public FixPartyListResponseTypeGrp clone ( FixPartyListResponseTypeGrp out ) {
		if ( hasPartyListResponseType())
			out.setPartyListResponseType(getPartyListResponseType());
		return out;
	}

}
