package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixDerivativeInstrumentPartySubIDsGrp extends FixGroup {
	private short hasDerivativeInstrumentPartySubID;
	byte[] derivativeInstrumentPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeInstrumentPartySubIDType;
	long derivativeInstrumentPartySubIDType = 0;		
	
	public FixDerivativeInstrumentPartySubIDsGrp() {
		this(false);
	}

	public FixDerivativeInstrumentPartySubIDsGrp(boolean isRequired) {
		super(FixTags.DERIVATIVEINSTRUMENTPARTYSUBID_INT);

		this.isRequired = isRequired;
		
		hasDerivativeInstrumentPartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeInstrumentPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeInstrumentPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasDerivativeInstrumentPartySubID()) return true;
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
            	case FixTags.DERIVATIVEINSTRUMENTPARTYSUBID_INT:		
            		hasDerivativeInstrumentPartySubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEINSTRUMENTPARTYSUBIDTYPE_INT:		
            		hasDerivativeInstrumentPartySubIDType = (short) buf.position();		
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
		hasDerivativeInstrumentPartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeInstrumentPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasDerivativeInstrumentPartySubID()) {		
			out.put(FixTags.DERIVATIVEINSTRUMENTPARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,derivativeInstrumentPartySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeInstrumentPartySubIDType()) {		
			out.put(FixTags.DERIVATIVEINSTRUMENTPARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeInstrumentPartySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasDerivativeInstrumentPartySubID()) {		
			FixUtils.put(out,derivativeInstrumentPartySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeInstrumentPartySubIDType()) {		
			FixUtils.put(out, (long)derivativeInstrumentPartySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getDerivativeInstrumentPartySubID() { 		
		if ( hasDerivativeInstrumentPartySubID()) {		
			if (hasDerivativeInstrumentPartySubID == FixUtils.TAG_HAS_VALUE) {		
				return derivativeInstrumentPartySubID; 		
			} else {		
		
				buf.position(hasDerivativeInstrumentPartySubID);		
		
			FixMessage.getTagStringValue(buf, derivativeInstrumentPartySubID, 0, derivativeInstrumentPartySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeInstrumentPartySubID);		
					return null;		
				}		
			}		
			hasDerivativeInstrumentPartySubID = FixUtils.TAG_HAS_VALUE;		
			return derivativeInstrumentPartySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeInstrumentPartySubID() { return hasDerivativeInstrumentPartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeInstrumentPartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeInstrumentPartySubID()) FixUtils.fillSpace(derivativeInstrumentPartySubID);		
		FixUtils.copy(derivativeInstrumentPartySubID, src); 		
		hasDerivativeInstrumentPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeInstrumentPartySubID(String str) {		
		if (str == null ) return;
		if (hasDerivativeInstrumentPartySubID()) FixUtils.fillSpace(derivativeInstrumentPartySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeInstrumentPartySubID, src); 		
		hasDerivativeInstrumentPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeInstrumentPartySubIDType() { 		
		if ( hasDerivativeInstrumentPartySubIDType()) {		
			if (hasDerivativeInstrumentPartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return derivativeInstrumentPartySubIDType; 		
			} else {		
		
				buf.position(hasDerivativeInstrumentPartySubIDType);		
		
			derivativeInstrumentPartySubIDType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeInstrumentPartySubIDType);		
					return 0;		
				}		
			}		
			hasDerivativeInstrumentPartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return derivativeInstrumentPartySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeInstrumentPartySubIDType() { return hasDerivativeInstrumentPartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeInstrumentPartySubIDType(long src) {		
		derivativeInstrumentPartySubIDType = src;
		hasDerivativeInstrumentPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeInstrumentPartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeInstrumentPartySubIDType()) derivativeInstrumentPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeInstrumentPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeInstrumentPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeInstrumentPartySubIDType(String str) {		
		if (str == null ) return;
		if (hasDerivativeInstrumentPartySubIDType()) derivativeInstrumentPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeInstrumentPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeInstrumentPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasDerivativeInstrumentPartySubID()) s += "DerivativeInstrumentPartySubID(1297)= " + new String( FixUtils.trim(getDerivativeInstrumentPartySubID()) ) + "\n" ; 
		if (hasDerivativeInstrumentPartySubIDType()) s += "DerivativeInstrumentPartySubIDType(1298)= " + getDerivativeInstrumentPartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDerivativeInstrumentPartySubIDsGrp)) return false;

		FixDerivativeInstrumentPartySubIDsGrp msg = (FixDerivativeInstrumentPartySubIDsGrp) o;

		if ((hasDerivativeInstrumentPartySubID() && !msg.hasDerivativeInstrumentPartySubID()) || (!hasDerivativeInstrumentPartySubID() && msg.hasDerivativeInstrumentPartySubID())) return false;
		if (!(!hasDerivativeInstrumentPartySubID() && !msg.hasDerivativeInstrumentPartySubID()) && !FixUtils.equals(getDerivativeInstrumentPartySubID(), msg.getDerivativeInstrumentPartySubID())) return false;
		if ((hasDerivativeInstrumentPartySubIDType() && !msg.hasDerivativeInstrumentPartySubIDType()) || (!hasDerivativeInstrumentPartySubIDType() && msg.hasDerivativeInstrumentPartySubIDType())) return false;
		if (!(!hasDerivativeInstrumentPartySubIDType() && !msg.hasDerivativeInstrumentPartySubIDType()) && !(getDerivativeInstrumentPartySubIDType()==msg.getDerivativeInstrumentPartySubIDType())) return false;
		return true;
	}
	public FixDerivativeInstrumentPartySubIDsGrp clone ( FixDerivativeInstrumentPartySubIDsGrp out ) {
		if ( hasDerivativeInstrumentPartySubID())
			out.setDerivativeInstrumentPartySubID(getDerivativeInstrumentPartySubID());
		if ( hasDerivativeInstrumentPartySubIDType())
			out.setDerivativeInstrumentPartySubIDType(getDerivativeInstrumentPartySubIDType());
		return out;
	}

}
