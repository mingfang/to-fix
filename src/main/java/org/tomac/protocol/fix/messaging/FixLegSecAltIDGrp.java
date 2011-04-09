package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixLegSecAltIDGrp extends FixGroup {
	private short hasNoLegSecurityAltID;
	byte[] noLegSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegSecurityAltID;
	byte[] legSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegSecurityAltIDSource;
	byte[] legSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixLegSecAltIDGrp() {
		this(false);
	}

	public FixLegSecAltIDGrp(boolean isRequired) {
		super(FixTags.NOLEGSECURITYALTID_INT);

		this.isRequired = isRequired;
		
		hasNoLegSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		noLegSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		legSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		legSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNoLegSecurityAltID()) return true;
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
            	case FixTags.NOLEGSECURITYALTID_INT:		
            		hasNoLegSecurityAltID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSECURITYALTID_INT:		
            		hasLegSecurityAltID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSECURITYALTIDSOURCE_INT:		
            		hasLegSecurityAltIDSource = (short) buf.position();		
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
		hasNoLegSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNoLegSecurityAltID()) {		
			out.put(FixTags.NOLEGSECURITYALTID);

			out.put((byte) '=');

			FixUtils.put(out,noLegSecurityAltID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSecurityAltID()) {		
			out.put(FixTags.LEGSECURITYALTID);

			out.put((byte) '=');

			FixUtils.put(out,legSecurityAltID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSecurityAltIDSource()) {		
			out.put(FixTags.LEGSECURITYALTIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,legSecurityAltIDSource); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNoLegSecurityAltID()) {		
			FixUtils.put(out,noLegSecurityAltID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSecurityAltID()) {		
			FixUtils.put(out,legSecurityAltID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSecurityAltIDSource()) {		
			FixUtils.put(out,legSecurityAltIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getNoLegSecurityAltID() { 		
		if ( hasNoLegSecurityAltID()) {		
			if (hasNoLegSecurityAltID == FixUtils.TAG_HAS_VALUE) {		
				return noLegSecurityAltID; 		
			} else {		
		
				buf.position(hasNoLegSecurityAltID);		
		
			FixUtils.getTagStringValue(buf, noLegSecurityAltID, 0, noLegSecurityAltID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNoLegSecurityAltID);		
					return null;		
				}		
			}		
			hasNoLegSecurityAltID = FixUtils.TAG_HAS_VALUE;		
			return noLegSecurityAltID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNoLegSecurityAltID() { return hasNoLegSecurityAltID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNoLegSecurityAltID(byte[] src) {		
		if (src == null ) return;
		if (hasNoLegSecurityAltID()) FixUtils.fillNul(noLegSecurityAltID);		
		FixUtils.copy(noLegSecurityAltID, src); 		
		hasNoLegSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNoLegSecurityAltID(String str) {		
		if (str == null ) return;
		if (hasNoLegSecurityAltID()) FixUtils.fillNul(noLegSecurityAltID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(noLegSecurityAltID, src); 		
		hasNoLegSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegSecurityAltID() { 		
		if ( hasLegSecurityAltID()) {		
			if (hasLegSecurityAltID == FixUtils.TAG_HAS_VALUE) {		
				return legSecurityAltID; 		
			} else {		
		
				buf.position(hasLegSecurityAltID);		
		
			FixUtils.getTagStringValue(buf, legSecurityAltID, 0, legSecurityAltID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSecurityAltID);		
					return null;		
				}		
			}		
			hasLegSecurityAltID = FixUtils.TAG_HAS_VALUE;		
			return legSecurityAltID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegSecurityAltID() { return hasLegSecurityAltID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSecurityAltID(byte[] src) {		
		if (src == null ) return;
		if (hasLegSecurityAltID()) FixUtils.fillNul(legSecurityAltID);		
		FixUtils.copy(legSecurityAltID, src); 		
		hasLegSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSecurityAltID(String str) {		
		if (str == null ) return;
		if (hasLegSecurityAltID()) FixUtils.fillNul(legSecurityAltID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSecurityAltID, src); 		
		hasLegSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegSecurityAltIDSource() { 		
		if ( hasLegSecurityAltIDSource()) {		
			if (hasLegSecurityAltIDSource == FixUtils.TAG_HAS_VALUE) {		
				return legSecurityAltIDSource; 		
			} else {		
		
				buf.position(hasLegSecurityAltIDSource);		
		
			FixUtils.getTagStringValue(buf, legSecurityAltIDSource, 0, legSecurityAltIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSecurityAltIDSource);		
					return null;		
				}		
			}		
			hasLegSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
			return legSecurityAltIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegSecurityAltIDSource() { return hasLegSecurityAltIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSecurityAltIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasLegSecurityAltIDSource()) FixUtils.fillNul(legSecurityAltIDSource);		
		FixUtils.copy(legSecurityAltIDSource, src); 		
		hasLegSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSecurityAltIDSource(String str) {		
		if (str == null ) return;
		if (hasLegSecurityAltIDSource()) FixUtils.fillNul(legSecurityAltIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSecurityAltIDSource, src); 		
		hasLegSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNoLegSecurityAltID()) s += "NoLegSecurityAltID(604)= " + new String( FixUtils.trim(getNoLegSecurityAltID()) ) + "\n" ; 
		if (hasLegSecurityAltID()) s += "LegSecurityAltID(605)= " + new String( FixUtils.trim(getLegSecurityAltID()) ) + "\n" ; 
		if (hasLegSecurityAltIDSource()) s += "LegSecurityAltIDSource(606)= " + new String( FixUtils.trim(getLegSecurityAltIDSource()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixLegSecAltIDGrp)) return false;

		FixLegSecAltIDGrp msg = (FixLegSecAltIDGrp) o;

		if ((hasNoLegSecurityAltID() && !msg.hasNoLegSecurityAltID()) || (!hasNoLegSecurityAltID() && msg.hasNoLegSecurityAltID())) return false;
		if (!(!hasNoLegSecurityAltID() && !msg.hasNoLegSecurityAltID()) && !FixUtils.equals(getNoLegSecurityAltID(), msg.getNoLegSecurityAltID())) return false;
		if ((hasLegSecurityAltID() && !msg.hasLegSecurityAltID()) || (!hasLegSecurityAltID() && msg.hasLegSecurityAltID())) return false;
		if (!(!hasLegSecurityAltID() && !msg.hasLegSecurityAltID()) && !FixUtils.equals(getLegSecurityAltID(), msg.getLegSecurityAltID())) return false;
		if ((hasLegSecurityAltIDSource() && !msg.hasLegSecurityAltIDSource()) || (!hasLegSecurityAltIDSource() && msg.hasLegSecurityAltIDSource())) return false;
		if (!(!hasLegSecurityAltIDSource() && !msg.hasLegSecurityAltIDSource()) && !FixUtils.equals(getLegSecurityAltIDSource(), msg.getLegSecurityAltIDSource())) return false;
		return true;
	}
	public FixLegSecAltIDGrp clone ( FixLegSecAltIDGrp out ) {
		if ( hasNoLegSecurityAltID())
			out.setNoLegSecurityAltID(getNoLegSecurityAltID());
		if ( hasLegSecurityAltID())
			out.setLegSecurityAltID(getLegSecurityAltID());
		if ( hasLegSecurityAltIDSource())
			out.setLegSecurityAltIDSource(getLegSecurityAltIDSource());
		return out;
	}

}
