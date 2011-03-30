package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSecAltIDGrp extends FixGroup {
	private short hasSecurityAltID;
	byte[] securityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityAltIDSource;
	byte[] securityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixSecAltIDGrp() {
		this(false);
	}

	public FixSecAltIDGrp(boolean isRequired) {
		super(FixTags.SECURITYALTID_INT);

		this.isRequired = isRequired;
		
		hasSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		securityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		securityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSecurityAltID()) return true;
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
            	case FixTags.SECURITYALTID_INT:		
            		hasSecurityAltID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYALTIDSOURCE_INT:		
            		hasSecurityAltIDSource = (short) buf.position();		
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
		hasSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSecurityAltID()) {		
			out.put(FixTags.SECURITYALTID);

			out.put((byte) '=');

			FixUtils.put(out,securityAltID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecurityAltIDSource()) {		
			out.put(FixTags.SECURITYALTIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,securityAltIDSource); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSecurityAltID()) {		
			FixUtils.put(out,securityAltID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityAltIDSource()) {		
			FixUtils.put(out,securityAltIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getSecurityAltID() { 		
		if ( hasSecurityAltID()) {		
			if (hasSecurityAltID == FixUtils.TAG_HAS_VALUE) {		
				return securityAltID; 		
			} else {		
		
				buf.position(hasSecurityAltID);		
		
			FixMessage.getTagStringValue(buf, securityAltID, 0, securityAltID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityAltID);		
					return null;		
				}		
			}		
			hasSecurityAltID = FixUtils.TAG_HAS_VALUE;		
			return securityAltID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityAltID() { return hasSecurityAltID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityAltID(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityAltID()) FixUtils.fillSpace(securityAltID);		
		FixUtils.copy(securityAltID, src); 		
		hasSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityAltID(String str) {		
		if (str == null ) return;
		if (hasSecurityAltID()) FixUtils.fillSpace(securityAltID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityAltID, src); 		
		hasSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecurityAltIDSource() { 		
		if ( hasSecurityAltIDSource()) {		
			if (hasSecurityAltIDSource == FixUtils.TAG_HAS_VALUE) {		
				return securityAltIDSource; 		
			} else {		
		
				buf.position(hasSecurityAltIDSource);		
		
			FixMessage.getTagStringValue(buf, securityAltIDSource, 0, securityAltIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityAltIDSource);		
					return null;		
				}		
			}		
			hasSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
			return securityAltIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityAltIDSource() { return hasSecurityAltIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityAltIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityAltIDSource()) FixUtils.fillSpace(securityAltIDSource);		
		FixUtils.copy(securityAltIDSource, src); 		
		hasSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityAltIDSource(String str) {		
		if (str == null ) return;
		if (hasSecurityAltIDSource()) FixUtils.fillSpace(securityAltIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityAltIDSource, src); 		
		hasSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSecurityAltID()) s += "SecurityAltID(455)= " + new String( FixUtils.trim(getSecurityAltID()) ) + "\n" ; 
		if (hasSecurityAltIDSource()) s += "SecurityAltIDSource(456)= " + new String( FixUtils.trim(getSecurityAltIDSource()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSecAltIDGrp)) return false;

		FixSecAltIDGrp msg = (FixSecAltIDGrp) o;

		if ((hasSecurityAltID() && !msg.hasSecurityAltID()) || (!hasSecurityAltID() && msg.hasSecurityAltID())) return false;
		if (!(!hasSecurityAltID() && !msg.hasSecurityAltID()) && !FixUtils.equals(getSecurityAltID(), msg.getSecurityAltID())) return false;
		if ((hasSecurityAltIDSource() && !msg.hasSecurityAltIDSource()) || (!hasSecurityAltIDSource() && msg.hasSecurityAltIDSource())) return false;
		if (!(!hasSecurityAltIDSource() && !msg.hasSecurityAltIDSource()) && !FixUtils.equals(getSecurityAltIDSource(), msg.getSecurityAltIDSource())) return false;
		return true;
	}
	public FixSecAltIDGrp clone ( FixSecAltIDGrp out ) {
		if ( hasSecurityAltID())
			out.setSecurityAltID(getSecurityAltID());
		if ( hasSecurityAltIDSource())
			out.setSecurityAltIDSource(getSecurityAltIDSource());
		return out;
	}

}
