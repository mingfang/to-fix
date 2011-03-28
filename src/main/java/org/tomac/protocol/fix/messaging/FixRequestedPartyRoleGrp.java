package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRequestedPartyRoleGrp extends FixGroup {
	private short hasRequestedPartyRole;
	long requestedPartyRole = 0;		
	
	public FixRequestedPartyRoleGrp() {
		super(FixTags.REQUESTEDPARTYROLE_INT);

		
		hasRequestedPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRequestedPartyRole()) return true;
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
            	case FixTags.REQUESTEDPARTYROLE_INT:		
            		hasRequestedPartyRole = (short) buf.position();		
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
		hasRequestedPartyRole = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRequestedPartyRole()) {		
			out.put(FixTags.REQUESTEDPARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)requestedPartyRole);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRequestedPartyRole()) {		
			FixUtils.put(out, (long)requestedPartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getRequestedPartyRole() { 		
		if ( hasRequestedPartyRole()) {		
			if (hasRequestedPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return requestedPartyRole; 		
			} else {		
		
				buf.position(hasRequestedPartyRole);		
		
			requestedPartyRole = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRequestedPartyRole);		
					return 0;		
				}		
			}		
			hasRequestedPartyRole = FixUtils.TAG_HAS_VALUE;		
			return requestedPartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRequestedPartyRole() { return hasRequestedPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRequestedPartyRole(long src) {		
		requestedPartyRole = src;
		hasRequestedPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRequestedPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasRequestedPartyRole()) requestedPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		requestedPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasRequestedPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRequestedPartyRole(String str) {		
		if (str == null ) return;
		if (hasRequestedPartyRole()) requestedPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		requestedPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasRequestedPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRequestedPartyRole()) s += "RequestedPartyRole(1509)= " + getRequestedPartyRole() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRequestedPartyRoleGrp)) return false;

		FixRequestedPartyRoleGrp msg = (FixRequestedPartyRoleGrp) o;

		if ((hasRequestedPartyRole() && !msg.hasRequestedPartyRole()) || (!hasRequestedPartyRole() && msg.hasRequestedPartyRole())) return false;
		if (!(!hasRequestedPartyRole() && !msg.hasRequestedPartyRole()) && !(getRequestedPartyRole()==msg.getRequestedPartyRole())) return false;
		return true;
	}
	public FixRequestedPartyRoleGrp clone ( FixRequestedPartyRoleGrp out ) {
		if ( hasRequestedPartyRole())
			out.setRequestedPartyRole(getRequestedPartyRole());
		return out;
	}

}
