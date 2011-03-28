package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixDerivativeInstrumentAttribute extends FixGroup {
	private short hasDerivativeInstrAttribType;
	long derivativeInstrAttribType = 0;		
	private short hasDerivativeInstrAttribValue;
	byte[] derivativeInstrAttribValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixDerivativeInstrumentAttribute() {
		super(FixTags.DERIVATIVEINSTRATTRIBTYPE_INT);

		
		hasDerivativeInstrAttribType = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeInstrAttribValue = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeInstrAttribValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasDerivativeInstrAttribType()) return true;
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
            	case FixTags.DERIVATIVEINSTRATTRIBTYPE_INT:		
            		hasDerivativeInstrAttribType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEINSTRATTRIBVALUE_INT:		
            		hasDerivativeInstrAttribValue = (short) buf.position();		
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
		hasDerivativeInstrAttribType = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeInstrAttribValue = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasDerivativeInstrAttribType()) {		
			out.put(FixTags.DERIVATIVEINSTRATTRIBTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeInstrAttribType);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeInstrAttribValue()) {		
			out.put(FixTags.DERIVATIVEINSTRATTRIBVALUE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeInstrAttribValue); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasDerivativeInstrAttribType()) {		
			FixUtils.put(out, (long)derivativeInstrAttribType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeInstrAttribValue()) {		
			FixUtils.put(out,derivativeInstrAttribValue); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getDerivativeInstrAttribType() { 		
		if ( hasDerivativeInstrAttribType()) {		
			if (hasDerivativeInstrAttribType == FixUtils.TAG_HAS_VALUE) {		
				return derivativeInstrAttribType; 		
			} else {		
		
				buf.position(hasDerivativeInstrAttribType);		
		
			derivativeInstrAttribType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeInstrAttribType);		
					return 0;		
				}		
			}		
			hasDerivativeInstrAttribType = FixUtils.TAG_HAS_VALUE;		
			return derivativeInstrAttribType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeInstrAttribType() { return hasDerivativeInstrAttribType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeInstrAttribType(long src) {		
		derivativeInstrAttribType = src;
		hasDerivativeInstrAttribType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeInstrAttribType(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeInstrAttribType()) derivativeInstrAttribType = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeInstrAttribType = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeInstrAttribType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeInstrAttribType(String str) {		
		if (str == null ) return;
		if (hasDerivativeInstrAttribType()) derivativeInstrAttribType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeInstrAttribType = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeInstrAttribType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeInstrAttribValue() { 		
		if ( hasDerivativeInstrAttribValue()) {		
			if (hasDerivativeInstrAttribValue == FixUtils.TAG_HAS_VALUE) {		
				return derivativeInstrAttribValue; 		
			} else {		
		
				buf.position(hasDerivativeInstrAttribValue);		
		
			FixMessage.getTagStringValue(buf, derivativeInstrAttribValue, 0, derivativeInstrAttribValue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeInstrAttribValue);		
					return null;		
				}		
			}		
			hasDerivativeInstrAttribValue = FixUtils.TAG_HAS_VALUE;		
			return derivativeInstrAttribValue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeInstrAttribValue() { return hasDerivativeInstrAttribValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeInstrAttribValue(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeInstrAttribValue()) FixUtils.fillSpace(derivativeInstrAttribValue);		
		FixUtils.copy(derivativeInstrAttribValue, src); 		
		hasDerivativeInstrAttribValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeInstrAttribValue(String str) {		
		if (str == null ) return;
		if (hasDerivativeInstrAttribValue()) FixUtils.fillSpace(derivativeInstrAttribValue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeInstrAttribValue, src); 		
		hasDerivativeInstrAttribValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasDerivativeInstrAttribType()) s += "DerivativeInstrAttribType(1313)= " + getDerivativeInstrAttribType() + "\n" ; 
		if (hasDerivativeInstrAttribValue()) s += "DerivativeInstrAttribValue(1314)= " + new String( FixUtils.trim(getDerivativeInstrAttribValue()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDerivativeInstrumentAttribute)) return false;

		FixDerivativeInstrumentAttribute msg = (FixDerivativeInstrumentAttribute) o;

		if ((hasDerivativeInstrAttribType() && !msg.hasDerivativeInstrAttribType()) || (!hasDerivativeInstrAttribType() && msg.hasDerivativeInstrAttribType())) return false;
		if (!(!hasDerivativeInstrAttribType() && !msg.hasDerivativeInstrAttribType()) && !(getDerivativeInstrAttribType()==msg.getDerivativeInstrAttribType())) return false;
		if ((hasDerivativeInstrAttribValue() && !msg.hasDerivativeInstrAttribValue()) || (!hasDerivativeInstrAttribValue() && msg.hasDerivativeInstrAttribValue())) return false;
		if (!(!hasDerivativeInstrAttribValue() && !msg.hasDerivativeInstrAttribValue()) && !FixUtils.equals(getDerivativeInstrAttribValue(), msg.getDerivativeInstrAttribValue())) return false;
		return true;
	}
	public FixDerivativeInstrumentAttribute clone ( FixDerivativeInstrumentAttribute out ) {
		if ( hasDerivativeInstrAttribType())
			out.setDerivativeInstrAttribType(getDerivativeInstrAttribType());
		if ( hasDerivativeInstrAttribValue())
			out.setDerivativeInstrAttribValue(getDerivativeInstrAttribValue());
		return out;
	}

}
