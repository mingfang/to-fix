package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixUsernameGrp extends FixGroup {
	private short hasUsername;
	byte[] username = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixUsernameGrp() {
		this(false);
	}

	public FixUsernameGrp(boolean isRequired) {
		super(FixTags.USERNAME_INT);

		this.isRequired = isRequired;
		
		hasUsername = FixUtils.TAG_HAS_NO_VALUE;		
		username = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasUsername()) return true;
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
            	case FixTags.USERNAME_INT:		
            		hasUsername = (short) buf.position();		
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
		hasUsername = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasUsername()) {		
			out.put(FixTags.USERNAME);

			out.put((byte) '=');

			FixUtils.put(out,username); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasUsername()) {		
			FixUtils.put(out,username); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getUsername() { 		
		if ( hasUsername()) {		
			if (hasUsername == FixUtils.TAG_HAS_VALUE) {		
				return username; 		
			} else {		
		
				buf.position(hasUsername);		
		
			FixMessage.getTagStringValue(buf, username, 0, username.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUsername);		
					return null;		
				}		
			}		
			hasUsername = FixUtils.TAG_HAS_VALUE;		
			return username;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUsername() { return hasUsername != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUsername(byte[] src) {		
		if (src == null ) return;
		if (hasUsername()) FixUtils.fillNul(username);		
		FixUtils.copy(username, src); 		
		hasUsername = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUsername(String str) {		
		if (str == null ) return;
		if (hasUsername()) FixUtils.fillNul(username);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(username, src); 		
		hasUsername = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasUsername()) s += "Username(553)= " + new String( FixUtils.trim(getUsername()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUsernameGrp)) return false;

		FixUsernameGrp msg = (FixUsernameGrp) o;

		if ((hasUsername() && !msg.hasUsername()) || (!hasUsername() && msg.hasUsername())) return false;
		if (!(!hasUsername() && !msg.hasUsername()) && !FixUtils.equals(getUsername(), msg.getUsername())) return false;
		return true;
	}
	public FixUsernameGrp clone ( FixUsernameGrp out ) {
		if ( hasUsername())
			out.setUsername(getUsername());
		return out;
	}

}
