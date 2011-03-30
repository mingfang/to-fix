package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixUnderlyingStipulations extends FixGroup {
	private short hasUnderlyingStipType;
	byte[] underlyingStipType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingStipValue;
	byte[] underlyingStipValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixUnderlyingStipulations() {
		this(false);
	}

	public FixUnderlyingStipulations(boolean isRequired) {
		super(FixTags.UNDERLYINGSTIPTYPE_INT);

		this.isRequired = isRequired;
		
		hasUnderlyingStipType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingStipType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingStipValue = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingStipValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasUnderlyingStipType()) return true;
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
            	case FixTags.UNDERLYINGSTIPTYPE_INT:		
            		hasUnderlyingStipType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSTIPVALUE_INT:		
            		hasUnderlyingStipValue = (short) buf.position();		
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
		hasUnderlyingStipType = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingStipValue = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasUnderlyingStipType()) {		
			out.put(FixTags.UNDERLYINGSTIPTYPE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingStipType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingStipValue()) {		
			out.put(FixTags.UNDERLYINGSTIPVALUE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingStipValue); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasUnderlyingStipType()) {		
			FixUtils.put(out,underlyingStipType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingStipValue()) {		
			FixUtils.put(out,underlyingStipValue); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getUnderlyingStipType() { 		
		if ( hasUnderlyingStipType()) {		
			if (hasUnderlyingStipType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingStipType; 		
			} else {		
		
				buf.position(hasUnderlyingStipType);		
		
			FixMessage.getTagStringValue(buf, underlyingStipType, 0, underlyingStipType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingStipType);		
					return null;		
				}		
			}		
			hasUnderlyingStipType = FixUtils.TAG_HAS_VALUE;		
			return underlyingStipType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingStipType() { return hasUnderlyingStipType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingStipType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingStipType()) FixUtils.fillSpace(underlyingStipType);		
		FixUtils.copy(underlyingStipType, src); 		
		hasUnderlyingStipType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingStipType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingStipType()) FixUtils.fillSpace(underlyingStipType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingStipType, src); 		
		hasUnderlyingStipType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingStipValue() { 		
		if ( hasUnderlyingStipValue()) {		
			if (hasUnderlyingStipValue == FixUtils.TAG_HAS_VALUE) {		
				return underlyingStipValue; 		
			} else {		
		
				buf.position(hasUnderlyingStipValue);		
		
			FixMessage.getTagStringValue(buf, underlyingStipValue, 0, underlyingStipValue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingStipValue);		
					return null;		
				}		
			}		
			hasUnderlyingStipValue = FixUtils.TAG_HAS_VALUE;		
			return underlyingStipValue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingStipValue() { return hasUnderlyingStipValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingStipValue(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingStipValue()) FixUtils.fillSpace(underlyingStipValue);		
		FixUtils.copy(underlyingStipValue, src); 		
		hasUnderlyingStipValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingStipValue(String str) {		
		if (str == null ) return;
		if (hasUnderlyingStipValue()) FixUtils.fillSpace(underlyingStipValue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingStipValue, src); 		
		hasUnderlyingStipValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasUnderlyingStipType()) s += "UnderlyingStipType(888)= " + new String( FixUtils.trim(getUnderlyingStipType()) ) + "\n" ; 
		if (hasUnderlyingStipValue()) s += "UnderlyingStipValue(889)= " + new String( FixUtils.trim(getUnderlyingStipValue()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUnderlyingStipulations)) return false;

		FixUnderlyingStipulations msg = (FixUnderlyingStipulations) o;

		if ((hasUnderlyingStipType() && !msg.hasUnderlyingStipType()) || (!hasUnderlyingStipType() && msg.hasUnderlyingStipType())) return false;
		if (!(!hasUnderlyingStipType() && !msg.hasUnderlyingStipType()) && !FixUtils.equals(getUnderlyingStipType(), msg.getUnderlyingStipType())) return false;
		if ((hasUnderlyingStipValue() && !msg.hasUnderlyingStipValue()) || (!hasUnderlyingStipValue() && msg.hasUnderlyingStipValue())) return false;
		if (!(!hasUnderlyingStipValue() && !msg.hasUnderlyingStipValue()) && !FixUtils.equals(getUnderlyingStipValue(), msg.getUnderlyingStipValue())) return false;
		return true;
	}
	public FixUnderlyingStipulations clone ( FixUnderlyingStipulations out ) {
		if ( hasUnderlyingStipType())
			out.setUnderlyingStipType(getUnderlyingStipType());
		if ( hasUnderlyingStipValue())
			out.setUnderlyingStipValue(getUnderlyingStipValue());
		return out;
	}

}
