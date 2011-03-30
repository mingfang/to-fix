package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixNestedInstrumentAttribute extends FixGroup {
	private short hasNestedInstrAttribType;
	long nestedInstrAttribType = 0;		
	private short hasNestedInstrAttribValue;
	byte[] nestedInstrAttribValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixNestedInstrumentAttribute() {
		this(false);
	}

	public FixNestedInstrumentAttribute(boolean isRequired) {
		super(FixTags.NESTEDINSTRATTRIBTYPE_INT);

		this.isRequired = isRequired;
		
		hasNestedInstrAttribType = FixUtils.TAG_HAS_NO_VALUE;		
		hasNestedInstrAttribValue = FixUtils.TAG_HAS_NO_VALUE;		
		nestedInstrAttribValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNestedInstrAttribType()) return true;
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
            	case FixTags.NESTEDINSTRATTRIBTYPE_INT:		
            		hasNestedInstrAttribType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTEDINSTRATTRIBVALUE_INT:		
            		hasNestedInstrAttribValue = (short) buf.position();		
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
		hasNestedInstrAttribType = FixUtils.TAG_HAS_NO_VALUE;
		hasNestedInstrAttribValue = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNestedInstrAttribType()) {		
			out.put(FixTags.NESTEDINSTRATTRIBTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)nestedInstrAttribType);
		
			out.put(FixUtils.SOH);

            }

		if (hasNestedInstrAttribValue()) {		
			out.put(FixTags.NESTEDINSTRATTRIBVALUE);

			out.put((byte) '=');

			FixUtils.put(out,nestedInstrAttribValue); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNestedInstrAttribType()) {		
			FixUtils.put(out, (long)nestedInstrAttribType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNestedInstrAttribValue()) {		
			FixUtils.put(out,nestedInstrAttribValue); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getNestedInstrAttribType() { 		
		if ( hasNestedInstrAttribType()) {		
			if (hasNestedInstrAttribType == FixUtils.TAG_HAS_VALUE) {		
				return nestedInstrAttribType; 		
			} else {		
		
				buf.position(hasNestedInstrAttribType);		
		
			nestedInstrAttribType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNestedInstrAttribType);		
					return 0;		
				}		
			}		
			hasNestedInstrAttribType = FixUtils.TAG_HAS_VALUE;		
			return nestedInstrAttribType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNestedInstrAttribType() { return hasNestedInstrAttribType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNestedInstrAttribType(long src) {		
		nestedInstrAttribType = src;
		hasNestedInstrAttribType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNestedInstrAttribType(byte[] src) {		
		if (src == null ) return;
		if (hasNestedInstrAttribType()) nestedInstrAttribType = FixUtils.TAG_HAS_NO_VALUE;		
		nestedInstrAttribType = FixUtils.longValueOf(src, 0, src.length);
		hasNestedInstrAttribType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNestedInstrAttribType(String str) {		
		if (str == null ) return;
		if (hasNestedInstrAttribType()) nestedInstrAttribType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		nestedInstrAttribType = FixUtils.longValueOf(src, 0, src.length);
		hasNestedInstrAttribType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getNestedInstrAttribValue() { 		
		if ( hasNestedInstrAttribValue()) {		
			if (hasNestedInstrAttribValue == FixUtils.TAG_HAS_VALUE) {		
				return nestedInstrAttribValue; 		
			} else {		
		
				buf.position(hasNestedInstrAttribValue);		
		
			FixMessage.getTagStringValue(buf, nestedInstrAttribValue, 0, nestedInstrAttribValue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNestedInstrAttribValue);		
					return null;		
				}		
			}		
			hasNestedInstrAttribValue = FixUtils.TAG_HAS_VALUE;		
			return nestedInstrAttribValue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNestedInstrAttribValue() { return hasNestedInstrAttribValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNestedInstrAttribValue(byte[] src) {		
		if (src == null ) return;
		if (hasNestedInstrAttribValue()) FixUtils.fillSpace(nestedInstrAttribValue);		
		FixUtils.copy(nestedInstrAttribValue, src); 		
		hasNestedInstrAttribValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNestedInstrAttribValue(String str) {		
		if (str == null ) return;
		if (hasNestedInstrAttribValue()) FixUtils.fillSpace(nestedInstrAttribValue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(nestedInstrAttribValue, src); 		
		hasNestedInstrAttribValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNestedInstrAttribType()) s += "NestedInstrAttribType(1210)= " + getNestedInstrAttribType() + "\n" ; 
		if (hasNestedInstrAttribValue()) s += "NestedInstrAttribValue(1211)= " + new String( FixUtils.trim(getNestedInstrAttribValue()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNestedInstrumentAttribute)) return false;

		FixNestedInstrumentAttribute msg = (FixNestedInstrumentAttribute) o;

		if ((hasNestedInstrAttribType() && !msg.hasNestedInstrAttribType()) || (!hasNestedInstrAttribType() && msg.hasNestedInstrAttribType())) return false;
		if (!(!hasNestedInstrAttribType() && !msg.hasNestedInstrAttribType()) && !(getNestedInstrAttribType()==msg.getNestedInstrAttribType())) return false;
		if ((hasNestedInstrAttribValue() && !msg.hasNestedInstrAttribValue()) || (!hasNestedInstrAttribValue() && msg.hasNestedInstrAttribValue())) return false;
		if (!(!hasNestedInstrAttribValue() && !msg.hasNestedInstrAttribValue()) && !FixUtils.equals(getNestedInstrAttribValue(), msg.getNestedInstrAttribValue())) return false;
		return true;
	}
	public FixNestedInstrumentAttribute clone ( FixNestedInstrumentAttribute out ) {
		if ( hasNestedInstrAttribType())
			out.setNestedInstrAttribType(getNestedInstrAttribType());
		if ( hasNestedInstrAttribValue())
			out.setNestedInstrAttribValue(getNestedInstrAttribValue());
		return out;
	}

}
