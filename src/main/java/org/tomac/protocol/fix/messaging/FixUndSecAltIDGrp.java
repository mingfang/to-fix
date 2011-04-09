package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixUndSecAltIDGrp extends FixGroup {
	private short hasUnderlyingSecurityAltID;
	byte[] underlyingSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingSecurityAltIDSource;
	byte[] underlyingSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixUndSecAltIDGrp() {
		this(false);
	}

	public FixUndSecAltIDGrp(boolean isRequired) {
		super(FixTags.UNDERLYINGSECURITYALTID_INT);

		this.isRequired = isRequired;
		
		hasUnderlyingSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasUnderlyingSecurityAltID()) return true;
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
            	case FixTags.UNDERLYINGSECURITYALTID_INT:		
            		hasUnderlyingSecurityAltID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSECURITYALTIDSOURCE_INT:		
            		hasUnderlyingSecurityAltIDSource = (short) buf.position();		
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
		hasUnderlyingSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasUnderlyingSecurityAltID()) {		
			out.put(FixTags.UNDERLYINGSECURITYALTID);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSecurityAltID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSecurityAltIDSource()) {		
			out.put(FixTags.UNDERLYINGSECURITYALTIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSecurityAltIDSource); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasUnderlyingSecurityAltID()) {		
			FixUtils.put(out,underlyingSecurityAltID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSecurityAltIDSource()) {		
			FixUtils.put(out,underlyingSecurityAltIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getUnderlyingSecurityAltID() { 		
		if ( hasUnderlyingSecurityAltID()) {		
			if (hasUnderlyingSecurityAltID == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSecurityAltID; 		
			} else {		
		
				buf.position(hasUnderlyingSecurityAltID);		
		
			FixUtils.getTagStringValue(buf, underlyingSecurityAltID, 0, underlyingSecurityAltID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSecurityAltID);		
					return null;		
				}		
			}		
			hasUnderlyingSecurityAltID = FixUtils.TAG_HAS_VALUE;		
			return underlyingSecurityAltID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSecurityAltID() { return hasUnderlyingSecurityAltID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSecurityAltID(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSecurityAltID()) FixUtils.fillNul(underlyingSecurityAltID);		
		FixUtils.copy(underlyingSecurityAltID, src); 		
		hasUnderlyingSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSecurityAltID(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSecurityAltID()) FixUtils.fillNul(underlyingSecurityAltID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSecurityAltID, src); 		
		hasUnderlyingSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingSecurityAltIDSource() { 		
		if ( hasUnderlyingSecurityAltIDSource()) {		
			if (hasUnderlyingSecurityAltIDSource == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSecurityAltIDSource; 		
			} else {		
		
				buf.position(hasUnderlyingSecurityAltIDSource);		
		
			FixUtils.getTagStringValue(buf, underlyingSecurityAltIDSource, 0, underlyingSecurityAltIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSecurityAltIDSource);		
					return null;		
				}		
			}		
			hasUnderlyingSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
			return underlyingSecurityAltIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSecurityAltIDSource() { return hasUnderlyingSecurityAltIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSecurityAltIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSecurityAltIDSource()) FixUtils.fillNul(underlyingSecurityAltIDSource);		
		FixUtils.copy(underlyingSecurityAltIDSource, src); 		
		hasUnderlyingSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSecurityAltIDSource(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSecurityAltIDSource()) FixUtils.fillNul(underlyingSecurityAltIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSecurityAltIDSource, src); 		
		hasUnderlyingSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasUnderlyingSecurityAltID()) s += "UnderlyingSecurityAltID(458)= " + new String( FixUtils.trim(getUnderlyingSecurityAltID()) ) + "\n" ; 
		if (hasUnderlyingSecurityAltIDSource()) s += "UnderlyingSecurityAltIDSource(459)= " + new String( FixUtils.trim(getUnderlyingSecurityAltIDSource()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUndSecAltIDGrp)) return false;

		FixUndSecAltIDGrp msg = (FixUndSecAltIDGrp) o;

		if ((hasUnderlyingSecurityAltID() && !msg.hasUnderlyingSecurityAltID()) || (!hasUnderlyingSecurityAltID() && msg.hasUnderlyingSecurityAltID())) return false;
		if (!(!hasUnderlyingSecurityAltID() && !msg.hasUnderlyingSecurityAltID()) && !FixUtils.equals(getUnderlyingSecurityAltID(), msg.getUnderlyingSecurityAltID())) return false;
		if ((hasUnderlyingSecurityAltIDSource() && !msg.hasUnderlyingSecurityAltIDSource()) || (!hasUnderlyingSecurityAltIDSource() && msg.hasUnderlyingSecurityAltIDSource())) return false;
		if (!(!hasUnderlyingSecurityAltIDSource() && !msg.hasUnderlyingSecurityAltIDSource()) && !FixUtils.equals(getUnderlyingSecurityAltIDSource(), msg.getUnderlyingSecurityAltIDSource())) return false;
		return true;
	}
	public FixUndSecAltIDGrp clone ( FixUndSecAltIDGrp out ) {
		if ( hasUnderlyingSecurityAltID())
			out.setUnderlyingSecurityAltID(getUnderlyingSecurityAltID());
		if ( hasUnderlyingSecurityAltIDSource())
			out.setUnderlyingSecurityAltIDSource(getUnderlyingSecurityAltIDSource());
		return out;
	}

}
