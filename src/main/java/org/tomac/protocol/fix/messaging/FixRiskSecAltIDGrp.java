package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRiskSecAltIDGrp extends FixGroup {
	private short hasNoRiskSecurityAltID;
	long noRiskSecurityAltID = 0;		
	private short hasRiskSecurityAltID;
	byte[] riskSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskSecurityAltIDSource;
	byte[] riskSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixRiskSecAltIDGrp() {
		this(false);
	}

	public FixRiskSecAltIDGrp(boolean isRequired) {
		super(FixTags.NORISKSECURITYALTID_INT);

		this.isRequired = isRequired;
		
		hasNoRiskSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		hasRiskSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		riskSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		riskSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNoRiskSecurityAltID()) return true;
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
            	case FixTags.NORISKSECURITYALTID_INT:		
            		hasNoRiskSecurityAltID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKSECURITYALTID_INT:		
            		hasRiskSecurityAltID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKSECURITYALTIDSOURCE_INT:		
            		hasRiskSecurityAltIDSource = (short) buf.position();		
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
		hasNoRiskSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNoRiskSecurityAltID()) {		
			out.put(FixTags.NORISKSECURITYALTID);

			out.put((byte) '=');

			FixUtils.put(out, (long)noRiskSecurityAltID);
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskSecurityAltID()) {		
			out.put(FixTags.RISKSECURITYALTID);

			out.put((byte) '=');

			FixUtils.put(out,riskSecurityAltID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskSecurityAltIDSource()) {		
			out.put(FixTags.RISKSECURITYALTIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,riskSecurityAltIDSource); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNoRiskSecurityAltID()) {		
			FixUtils.put(out, (long)noRiskSecurityAltID);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskSecurityAltID()) {		
			FixUtils.put(out,riskSecurityAltID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskSecurityAltIDSource()) {		
			FixUtils.put(out,riskSecurityAltIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getNoRiskSecurityAltID() { 		
		if ( hasNoRiskSecurityAltID()) {		
			if (hasNoRiskSecurityAltID == FixUtils.TAG_HAS_VALUE) {		
				return noRiskSecurityAltID; 		
			} else {		
		
				buf.position(hasNoRiskSecurityAltID);		
		
			noRiskSecurityAltID = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNoRiskSecurityAltID);		
					return 0;		
				}		
			}		
			hasNoRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
			return noRiskSecurityAltID;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNoRiskSecurityAltID() { return hasNoRiskSecurityAltID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNoRiskSecurityAltID(long src) {		
		noRiskSecurityAltID = src;
		hasNoRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNoRiskSecurityAltID(byte[] src) {		
		if (src == null ) return;
		if (hasNoRiskSecurityAltID()) noRiskSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		noRiskSecurityAltID = FixUtils.longValueOf(src, 0, src.length);
		hasNoRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNoRiskSecurityAltID(String str) {		
		if (str == null ) return;
		if (hasNoRiskSecurityAltID()) noRiskSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		noRiskSecurityAltID = FixUtils.longValueOf(src, 0, src.length);
		hasNoRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskSecurityAltID() { 		
		if ( hasRiskSecurityAltID()) {		
			if (hasRiskSecurityAltID == FixUtils.TAG_HAS_VALUE) {		
				return riskSecurityAltID; 		
			} else {		
		
				buf.position(hasRiskSecurityAltID);		
		
			FixMessage.getTagStringValue(buf, riskSecurityAltID, 0, riskSecurityAltID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskSecurityAltID);		
					return null;		
				}		
			}		
			hasRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
			return riskSecurityAltID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskSecurityAltID() { return hasRiskSecurityAltID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskSecurityAltID(byte[] src) {		
		if (src == null ) return;
		if (hasRiskSecurityAltID()) FixUtils.fillNul(riskSecurityAltID);		
		FixUtils.copy(riskSecurityAltID, src); 		
		hasRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskSecurityAltID(String str) {		
		if (str == null ) return;
		if (hasRiskSecurityAltID()) FixUtils.fillNul(riskSecurityAltID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskSecurityAltID, src); 		
		hasRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskSecurityAltIDSource() { 		
		if ( hasRiskSecurityAltIDSource()) {		
			if (hasRiskSecurityAltIDSource == FixUtils.TAG_HAS_VALUE) {		
				return riskSecurityAltIDSource; 		
			} else {		
		
				buf.position(hasRiskSecurityAltIDSource);		
		
			FixMessage.getTagStringValue(buf, riskSecurityAltIDSource, 0, riskSecurityAltIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskSecurityAltIDSource);		
					return null;		
				}		
			}		
			hasRiskSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
			return riskSecurityAltIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskSecurityAltIDSource() { return hasRiskSecurityAltIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskSecurityAltIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasRiskSecurityAltIDSource()) FixUtils.fillNul(riskSecurityAltIDSource);		
		FixUtils.copy(riskSecurityAltIDSource, src); 		
		hasRiskSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskSecurityAltIDSource(String str) {		
		if (str == null ) return;
		if (hasRiskSecurityAltIDSource()) FixUtils.fillNul(riskSecurityAltIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskSecurityAltIDSource, src); 		
		hasRiskSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNoRiskSecurityAltID()) s += "NoRiskSecurityAltID(1540)= " + getNoRiskSecurityAltID() + "\n" ; 
		if (hasRiskSecurityAltID()) s += "RiskSecurityAltID(1541)= " + new String( FixUtils.trim(getRiskSecurityAltID()) ) + "\n" ; 
		if (hasRiskSecurityAltIDSource()) s += "RiskSecurityAltIDSource(1542)= " + new String( FixUtils.trim(getRiskSecurityAltIDSource()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRiskSecAltIDGrp)) return false;

		FixRiskSecAltIDGrp msg = (FixRiskSecAltIDGrp) o;

		if ((hasNoRiskSecurityAltID() && !msg.hasNoRiskSecurityAltID()) || (!hasNoRiskSecurityAltID() && msg.hasNoRiskSecurityAltID())) return false;
		if (!(!hasNoRiskSecurityAltID() && !msg.hasNoRiskSecurityAltID()) && !(getNoRiskSecurityAltID()==msg.getNoRiskSecurityAltID())) return false;
		if ((hasRiskSecurityAltID() && !msg.hasRiskSecurityAltID()) || (!hasRiskSecurityAltID() && msg.hasRiskSecurityAltID())) return false;
		if (!(!hasRiskSecurityAltID() && !msg.hasRiskSecurityAltID()) && !FixUtils.equals(getRiskSecurityAltID(), msg.getRiskSecurityAltID())) return false;
		if ((hasRiskSecurityAltIDSource() && !msg.hasRiskSecurityAltIDSource()) || (!hasRiskSecurityAltIDSource() && msg.hasRiskSecurityAltIDSource())) return false;
		if (!(!hasRiskSecurityAltIDSource() && !msg.hasRiskSecurityAltIDSource()) && !FixUtils.equals(getRiskSecurityAltIDSource(), msg.getRiskSecurityAltIDSource())) return false;
		return true;
	}
	public FixRiskSecAltIDGrp clone ( FixRiskSecAltIDGrp out ) {
		if ( hasNoRiskSecurityAltID())
			out.setNoRiskSecurityAltID(getNoRiskSecurityAltID());
		if ( hasRiskSecurityAltID())
			out.setRiskSecurityAltID(getRiskSecurityAltID());
		if ( hasRiskSecurityAltIDSource())
			out.setRiskSecurityAltIDSource(getRiskSecurityAltIDSource());
		return out;
	}

}
