package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixUnderlyingLegSecurityAltIDGrp extends FixGroup {
	private short hasUnderlyingLegSecurityAltID;
	byte[] underlyingLegSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLegSecurityAltIDSource;
	byte[] underlyingLegSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixUnderlyingLegSecurityAltIDGrp() {
		this(false);
	}

	public FixUnderlyingLegSecurityAltIDGrp(boolean isRequired) {
		super(FixTags.UNDERLYINGLEGSECURITYALTID_INT);

		this.isRequired = isRequired;
		
		hasUnderlyingLegSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLegSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasUnderlyingLegSecurityAltID()) return true;
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
            	case FixTags.UNDERLYINGLEGSECURITYALTID_INT:		
            		hasUnderlyingLegSecurityAltID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGSECURITYALTIDSOURCE_INT:		
            		hasUnderlyingLegSecurityAltIDSource = (short) buf.position();		
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
		hasUnderlyingLegSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasUnderlyingLegSecurityAltID()) {		
			out.put(FixTags.UNDERLYINGLEGSECURITYALTID);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegSecurityAltID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegSecurityAltIDSource()) {		
			out.put(FixTags.UNDERLYINGLEGSECURITYALTIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegSecurityAltIDSource); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasUnderlyingLegSecurityAltID()) {		
			FixUtils.put(out,underlyingLegSecurityAltID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegSecurityAltIDSource()) {		
			FixUtils.put(out,underlyingLegSecurityAltIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getUnderlyingLegSecurityAltID() { 		
		if ( hasUnderlyingLegSecurityAltID()) {		
			if (hasUnderlyingLegSecurityAltID == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegSecurityAltID; 		
			} else {		
		
				buf.position(hasUnderlyingLegSecurityAltID);		
		
			FixMessage.getTagStringValue(buf, underlyingLegSecurityAltID, 0, underlyingLegSecurityAltID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegSecurityAltID);		
					return null;		
				}		
			}		
			hasUnderlyingLegSecurityAltID = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegSecurityAltID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegSecurityAltID() { return hasUnderlyingLegSecurityAltID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegSecurityAltID(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegSecurityAltID()) FixUtils.fillNul(underlyingLegSecurityAltID);		
		FixUtils.copy(underlyingLegSecurityAltID, src); 		
		hasUnderlyingLegSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegSecurityAltID(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegSecurityAltID()) FixUtils.fillNul(underlyingLegSecurityAltID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegSecurityAltID, src); 		
		hasUnderlyingLegSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLegSecurityAltIDSource() { 		
		if ( hasUnderlyingLegSecurityAltIDSource()) {		
			if (hasUnderlyingLegSecurityAltIDSource == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegSecurityAltIDSource; 		
			} else {		
		
				buf.position(hasUnderlyingLegSecurityAltIDSource);		
		
			FixMessage.getTagStringValue(buf, underlyingLegSecurityAltIDSource, 0, underlyingLegSecurityAltIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegSecurityAltIDSource);		
					return null;		
				}		
			}		
			hasUnderlyingLegSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegSecurityAltIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegSecurityAltIDSource() { return hasUnderlyingLegSecurityAltIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegSecurityAltIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegSecurityAltIDSource()) FixUtils.fillNul(underlyingLegSecurityAltIDSource);		
		FixUtils.copy(underlyingLegSecurityAltIDSource, src); 		
		hasUnderlyingLegSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegSecurityAltIDSource(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegSecurityAltIDSource()) FixUtils.fillNul(underlyingLegSecurityAltIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegSecurityAltIDSource, src); 		
		hasUnderlyingLegSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasUnderlyingLegSecurityAltID()) s += "UnderlyingLegSecurityAltID(1335)= " + new String( FixUtils.trim(getUnderlyingLegSecurityAltID()) ) + "\n" ; 
		if (hasUnderlyingLegSecurityAltIDSource()) s += "UnderlyingLegSecurityAltIDSource(1336)= " + new String( FixUtils.trim(getUnderlyingLegSecurityAltIDSource()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUnderlyingLegSecurityAltIDGrp)) return false;

		FixUnderlyingLegSecurityAltIDGrp msg = (FixUnderlyingLegSecurityAltIDGrp) o;

		if ((hasUnderlyingLegSecurityAltID() && !msg.hasUnderlyingLegSecurityAltID()) || (!hasUnderlyingLegSecurityAltID() && msg.hasUnderlyingLegSecurityAltID())) return false;
		if (!(!hasUnderlyingLegSecurityAltID() && !msg.hasUnderlyingLegSecurityAltID()) && !FixUtils.equals(getUnderlyingLegSecurityAltID(), msg.getUnderlyingLegSecurityAltID())) return false;
		if ((hasUnderlyingLegSecurityAltIDSource() && !msg.hasUnderlyingLegSecurityAltIDSource()) || (!hasUnderlyingLegSecurityAltIDSource() && msg.hasUnderlyingLegSecurityAltIDSource())) return false;
		if (!(!hasUnderlyingLegSecurityAltIDSource() && !msg.hasUnderlyingLegSecurityAltIDSource()) && !FixUtils.equals(getUnderlyingLegSecurityAltIDSource(), msg.getUnderlyingLegSecurityAltIDSource())) return false;
		return true;
	}
	public FixUnderlyingLegSecurityAltIDGrp clone ( FixUnderlyingLegSecurityAltIDGrp out ) {
		if ( hasUnderlyingLegSecurityAltID())
			out.setUnderlyingLegSecurityAltID(getUnderlyingLegSecurityAltID());
		if ( hasUnderlyingLegSecurityAltIDSource())
			out.setUnderlyingLegSecurityAltIDSource(getUnderlyingLegSecurityAltIDSource());
		return out;
	}

}
