package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixStipulations extends FixGroup {
	private short hasStipulationType;
	byte[] stipulationType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasStipulationValue;
	byte[] stipulationValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixStipulations() {
		this(false);
	}

	public FixStipulations(boolean isRequired) {
		super(FixTags.STIPULATIONTYPE_INT);

		this.isRequired = isRequired;
		
		hasStipulationType = FixUtils.TAG_HAS_NO_VALUE;		
		stipulationType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasStipulationValue = FixUtils.TAG_HAS_NO_VALUE;		
		stipulationValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasStipulationType()) return true;
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
            	case FixTags.STIPULATIONTYPE_INT:		
            		hasStipulationType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STIPULATIONVALUE_INT:		
            		hasStipulationValue = (short) buf.position();		
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
		hasStipulationType = FixUtils.TAG_HAS_NO_VALUE;
		hasStipulationValue = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasStipulationType()) {		
			out.put(FixTags.STIPULATIONTYPE);

			out.put((byte) '=');

			FixUtils.put(out,stipulationType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasStipulationValue()) {		
			out.put(FixTags.STIPULATIONVALUE);

			out.put((byte) '=');

			FixUtils.put(out,stipulationValue); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasStipulationType()) {		
			FixUtils.put(out,stipulationType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStipulationValue()) {		
			FixUtils.put(out,stipulationValue); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getStipulationType() { 		
		if ( hasStipulationType()) {		
			if (hasStipulationType == FixUtils.TAG_HAS_VALUE) {		
				return stipulationType; 		
			} else {		
		
				buf.position(hasStipulationType);		
		
			FixMessage.getTagStringValue(buf, stipulationType, 0, stipulationType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasStipulationType);		
					return null;		
				}		
			}		
			hasStipulationType = FixUtils.TAG_HAS_VALUE;		
			return stipulationType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStipulationType() { return hasStipulationType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStipulationType(byte[] src) {		
		if (src == null ) return;
		if (hasStipulationType()) FixUtils.fillNul(stipulationType);		
		FixUtils.copy(stipulationType, src); 		
		hasStipulationType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStipulationType(String str) {		
		if (str == null ) return;
		if (hasStipulationType()) FixUtils.fillNul(stipulationType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(stipulationType, src); 		
		hasStipulationType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getStipulationValue() { 		
		if ( hasStipulationValue()) {		
			if (hasStipulationValue == FixUtils.TAG_HAS_VALUE) {		
				return stipulationValue; 		
			} else {		
		
				buf.position(hasStipulationValue);		
		
			FixMessage.getTagStringValue(buf, stipulationValue, 0, stipulationValue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasStipulationValue);		
					return null;		
				}		
			}		
			hasStipulationValue = FixUtils.TAG_HAS_VALUE;		
			return stipulationValue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStipulationValue() { return hasStipulationValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStipulationValue(byte[] src) {		
		if (src == null ) return;
		if (hasStipulationValue()) FixUtils.fillNul(stipulationValue);		
		FixUtils.copy(stipulationValue, src); 		
		hasStipulationValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStipulationValue(String str) {		
		if (str == null ) return;
		if (hasStipulationValue()) FixUtils.fillNul(stipulationValue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(stipulationValue, src); 		
		hasStipulationValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasStipulationType()) s += "StipulationType(233)= " + new String( FixUtils.trim(getStipulationType()) ) + "\n" ; 
		if (hasStipulationValue()) s += "StipulationValue(234)= " + new String( FixUtils.trim(getStipulationValue()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStipulations)) return false;

		FixStipulations msg = (FixStipulations) o;

		if ((hasStipulationType() && !msg.hasStipulationType()) || (!hasStipulationType() && msg.hasStipulationType())) return false;
		if (!(!hasStipulationType() && !msg.hasStipulationType()) && !FixUtils.equals(getStipulationType(), msg.getStipulationType())) return false;
		if ((hasStipulationValue() && !msg.hasStipulationValue()) || (!hasStipulationValue() && msg.hasStipulationValue())) return false;
		if (!(!hasStipulationValue() && !msg.hasStipulationValue()) && !FixUtils.equals(getStipulationValue(), msg.getStipulationValue())) return false;
		return true;
	}
	public FixStipulations clone ( FixStipulations out ) {
		if ( hasStipulationType())
			out.setStipulationType(getStipulationType());
		if ( hasStipulationValue())
			out.setStipulationValue(getStipulationValue());
		return out;
	}

}
