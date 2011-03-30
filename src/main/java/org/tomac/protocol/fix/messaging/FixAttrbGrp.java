package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixAttrbGrp extends FixGroup {
	private short hasInstrAttribType;
	long instrAttribType = 0;		
	private short hasInstrAttribValue;
	byte[] instrAttribValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixAttrbGrp() {
		this(false);
	}

	public FixAttrbGrp(boolean isRequired) {
		super(FixTags.INSTRATTRIBTYPE_INT);

		this.isRequired = isRequired;
		
		hasInstrAttribType = FixUtils.TAG_HAS_NO_VALUE;		
		hasInstrAttribValue = FixUtils.TAG_HAS_NO_VALUE;		
		instrAttribValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasInstrAttribType()) return true;
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
            	case FixTags.INSTRATTRIBTYPE_INT:		
            		hasInstrAttribType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.INSTRATTRIBVALUE_INT:		
            		hasInstrAttribValue = (short) buf.position();		
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
		hasInstrAttribType = FixUtils.TAG_HAS_NO_VALUE;
		hasInstrAttribValue = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasInstrAttribType()) {		
			out.put(FixTags.INSTRATTRIBTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)instrAttribType);
		
			out.put(FixUtils.SOH);

            }

		if (hasInstrAttribValue()) {		
			out.put(FixTags.INSTRATTRIBVALUE);

			out.put((byte) '=');

			FixUtils.put(out,instrAttribValue); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasInstrAttribType()) {		
			FixUtils.put(out, (long)instrAttribType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasInstrAttribValue()) {		
			FixUtils.put(out,instrAttribValue); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getInstrAttribType() { 		
		if ( hasInstrAttribType()) {		
			if (hasInstrAttribType == FixUtils.TAG_HAS_VALUE) {		
				return instrAttribType; 		
			} else {		
		
				buf.position(hasInstrAttribType);		
		
			instrAttribType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasInstrAttribType);		
					return 0;		
				}		
			}		
			hasInstrAttribType = FixUtils.TAG_HAS_VALUE;		
			return instrAttribType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasInstrAttribType() { return hasInstrAttribType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setInstrAttribType(long src) {		
		instrAttribType = src;
		hasInstrAttribType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setInstrAttribType(byte[] src) {		
		if (src == null ) return;
		if (hasInstrAttribType()) instrAttribType = FixUtils.TAG_HAS_NO_VALUE;		
		instrAttribType = FixUtils.longValueOf(src, 0, src.length);
		hasInstrAttribType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setInstrAttribType(String str) {		
		if (str == null ) return;
		if (hasInstrAttribType()) instrAttribType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		instrAttribType = FixUtils.longValueOf(src, 0, src.length);
		hasInstrAttribType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getInstrAttribValue() { 		
		if ( hasInstrAttribValue()) {		
			if (hasInstrAttribValue == FixUtils.TAG_HAS_VALUE) {		
				return instrAttribValue; 		
			} else {		
		
				buf.position(hasInstrAttribValue);		
		
			FixMessage.getTagStringValue(buf, instrAttribValue, 0, instrAttribValue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasInstrAttribValue);		
					return null;		
				}		
			}		
			hasInstrAttribValue = FixUtils.TAG_HAS_VALUE;		
			return instrAttribValue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasInstrAttribValue() { return hasInstrAttribValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setInstrAttribValue(byte[] src) {		
		if (src == null ) return;
		if (hasInstrAttribValue()) FixUtils.fillSpace(instrAttribValue);		
		FixUtils.copy(instrAttribValue, src); 		
		hasInstrAttribValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setInstrAttribValue(String str) {		
		if (str == null ) return;
		if (hasInstrAttribValue()) FixUtils.fillSpace(instrAttribValue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(instrAttribValue, src); 		
		hasInstrAttribValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasInstrAttribType()) s += "InstrAttribType(871)= " + getInstrAttribType() + "\n" ; 
		if (hasInstrAttribValue()) s += "InstrAttribValue(872)= " + new String( FixUtils.trim(getInstrAttribValue()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixAttrbGrp)) return false;

		FixAttrbGrp msg = (FixAttrbGrp) o;

		if ((hasInstrAttribType() && !msg.hasInstrAttribType()) || (!hasInstrAttribType() && msg.hasInstrAttribType())) return false;
		if (!(!hasInstrAttribType() && !msg.hasInstrAttribType()) && !(getInstrAttribType()==msg.getInstrAttribType())) return false;
		if ((hasInstrAttribValue() && !msg.hasInstrAttribValue()) || (!hasInstrAttribValue() && msg.hasInstrAttribValue())) return false;
		if (!(!hasInstrAttribValue() && !msg.hasInstrAttribValue()) && !FixUtils.equals(getInstrAttribValue(), msg.getInstrAttribValue())) return false;
		return true;
	}
	public FixAttrbGrp clone ( FixAttrbGrp out ) {
		if ( hasInstrAttribType())
			out.setInstrAttribType(getInstrAttribType());
		if ( hasInstrAttribValue())
			out.setInstrAttribValue(getInstrAttribValue());
		return out;
	}

}
