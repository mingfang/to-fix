package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixDerivativeSecurityAltIDGrp extends FixGroup {
	private short hasDerivativeSecurityAltID;
	byte[] derivativeSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeSecurityAltIDSource;
	byte[] derivativeSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixDerivativeSecurityAltIDGrp() {
		this(false);
	}

	public FixDerivativeSecurityAltIDGrp(boolean isRequired) {
		super(FixTags.DERIVATIVESECURITYALTID_INT);

		this.isRequired = isRequired;
		
		hasDerivativeSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasDerivativeSecurityAltID()) return true;
		else return false;
	}


	/**
     * Parse FIX Group. The buffer is positioned at the value of the tag.
     */
    public int setBuffer( int tag, ByteBuffer buf, FixValidationError err)
    {

		super.err = err;
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.DERIVATIVESECURITYALTID_INT:		
            		hasDerivativeSecurityAltID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESECURITYALTIDSOURCE_INT:		
            		hasDerivativeSecurityAltIDSource = (short) buf.position();		
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
		hasDerivativeSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasDerivativeSecurityAltID()) {		
			out.put(FixTags.DERIVATIVESECURITYALTID);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSecurityAltID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSecurityAltIDSource()) {		
			out.put(FixTags.DERIVATIVESECURITYALTIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSecurityAltIDSource); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasDerivativeSecurityAltID()) {		
			FixUtils.put(out,derivativeSecurityAltID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSecurityAltIDSource()) {		
			FixUtils.put(out,derivativeSecurityAltIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getDerivativeSecurityAltID() { 		
		if ( hasDerivativeSecurityAltID()) {		
			if (hasDerivativeSecurityAltID == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecurityAltID; 		
			} else {		
		
				buf.position(hasDerivativeSecurityAltID);		
		
			FixUtils.getTagStringValue(buf, derivativeSecurityAltID, 0, derivativeSecurityAltID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecurityAltID);		
					return null;		
				}		
			}		
			hasDerivativeSecurityAltID = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecurityAltID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSecurityAltID() { return hasDerivativeSecurityAltID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecurityAltID(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecurityAltID()) FixUtils.fillNul(derivativeSecurityAltID);		
		FixUtils.copy(derivativeSecurityAltID, src); 		
		hasDerivativeSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecurityAltID(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecurityAltID()) FixUtils.fillNul(derivativeSecurityAltID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSecurityAltID, src); 		
		hasDerivativeSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSecurityAltIDSource() { 		
		if ( hasDerivativeSecurityAltIDSource()) {		
			if (hasDerivativeSecurityAltIDSource == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecurityAltIDSource; 		
			} else {		
		
				buf.position(hasDerivativeSecurityAltIDSource);		
		
			FixUtils.getTagStringValue(buf, derivativeSecurityAltIDSource, 0, derivativeSecurityAltIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecurityAltIDSource);		
					return null;		
				}		
			}		
			hasDerivativeSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecurityAltIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSecurityAltIDSource() { return hasDerivativeSecurityAltIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecurityAltIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecurityAltIDSource()) FixUtils.fillNul(derivativeSecurityAltIDSource);		
		FixUtils.copy(derivativeSecurityAltIDSource, src); 		
		hasDerivativeSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecurityAltIDSource(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecurityAltIDSource()) FixUtils.fillNul(derivativeSecurityAltIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSecurityAltIDSource, src); 		
		hasDerivativeSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasDerivativeSecurityAltID()) s += "DerivativeSecurityAltID(1219)= " + new String( FixUtils.trim(getDerivativeSecurityAltID()) ) + "\n" ; 
		if (hasDerivativeSecurityAltIDSource()) s += "DerivativeSecurityAltIDSource(1220)= " + new String( FixUtils.trim(getDerivativeSecurityAltIDSource()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDerivativeSecurityAltIDGrp)) return false;

		FixDerivativeSecurityAltIDGrp msg = (FixDerivativeSecurityAltIDGrp) o;

		if ((hasDerivativeSecurityAltID() && !msg.hasDerivativeSecurityAltID()) || (!hasDerivativeSecurityAltID() && msg.hasDerivativeSecurityAltID())) return false;
		if (!(!hasDerivativeSecurityAltID() && !msg.hasDerivativeSecurityAltID()) && !FixUtils.equals(getDerivativeSecurityAltID(), msg.getDerivativeSecurityAltID())) return false;
		if ((hasDerivativeSecurityAltIDSource() && !msg.hasDerivativeSecurityAltIDSource()) || (!hasDerivativeSecurityAltIDSource() && msg.hasDerivativeSecurityAltIDSource())) return false;
		if (!(!hasDerivativeSecurityAltIDSource() && !msg.hasDerivativeSecurityAltIDSource()) && !FixUtils.equals(getDerivativeSecurityAltIDSource(), msg.getDerivativeSecurityAltIDSource())) return false;
		return true;
	}
	public FixDerivativeSecurityAltIDGrp clone ( FixDerivativeSecurityAltIDGrp out ) {
		if ( hasDerivativeSecurityAltID())
			out.setDerivativeSecurityAltID(getDerivativeSecurityAltID());
		if ( hasDerivativeSecurityAltIDSource())
			out.setDerivativeSecurityAltIDSource(getDerivativeSecurityAltIDSource());
		return out;
	}

}
