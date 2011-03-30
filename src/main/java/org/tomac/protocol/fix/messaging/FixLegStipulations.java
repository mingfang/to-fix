package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixLegStipulations extends FixGroup {
	private short hasLegStipulationType;
	byte[] legStipulationType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegStipulationValue;
	byte[] legStipulationValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixLegStipulations() {
		this(false);
	}

	public FixLegStipulations(boolean isRequired) {
		super(FixTags.LEGSTIPULATIONTYPE_INT);

		this.isRequired = isRequired;
		
		hasLegStipulationType = FixUtils.TAG_HAS_NO_VALUE;		
		legStipulationType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegStipulationValue = FixUtils.TAG_HAS_NO_VALUE;		
		legStipulationValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasLegStipulationType()) return true;
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
            	case FixTags.LEGSTIPULATIONTYPE_INT:		
            		hasLegStipulationType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSTIPULATIONVALUE_INT:		
            		hasLegStipulationValue = (short) buf.position();		
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
		hasLegStipulationType = FixUtils.TAG_HAS_NO_VALUE;
		hasLegStipulationValue = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasLegStipulationType()) {		
			out.put(FixTags.LEGSTIPULATIONTYPE);

			out.put((byte) '=');

			FixUtils.put(out,legStipulationType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegStipulationValue()) {		
			out.put(FixTags.LEGSTIPULATIONVALUE);

			out.put((byte) '=');

			FixUtils.put(out,legStipulationValue); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasLegStipulationType()) {		
			FixUtils.put(out,legStipulationType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegStipulationValue()) {		
			FixUtils.put(out,legStipulationValue); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getLegStipulationType() { 		
		if ( hasLegStipulationType()) {		
			if (hasLegStipulationType == FixUtils.TAG_HAS_VALUE) {		
				return legStipulationType; 		
			} else {		
		
				buf.position(hasLegStipulationType);		
		
			FixMessage.getTagStringValue(buf, legStipulationType, 0, legStipulationType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegStipulationType);		
					return null;		
				}		
			}		
			hasLegStipulationType = FixUtils.TAG_HAS_VALUE;		
			return legStipulationType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegStipulationType() { return hasLegStipulationType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegStipulationType(byte[] src) {		
		if (src == null ) return;
		if (hasLegStipulationType()) FixUtils.fillSpace(legStipulationType);		
		FixUtils.copy(legStipulationType, src); 		
		hasLegStipulationType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegStipulationType(String str) {		
		if (str == null ) return;
		if (hasLegStipulationType()) FixUtils.fillSpace(legStipulationType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legStipulationType, src); 		
		hasLegStipulationType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegStipulationValue() { 		
		if ( hasLegStipulationValue()) {		
			if (hasLegStipulationValue == FixUtils.TAG_HAS_VALUE) {		
				return legStipulationValue; 		
			} else {		
		
				buf.position(hasLegStipulationValue);		
		
			FixMessage.getTagStringValue(buf, legStipulationValue, 0, legStipulationValue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegStipulationValue);		
					return null;		
				}		
			}		
			hasLegStipulationValue = FixUtils.TAG_HAS_VALUE;		
			return legStipulationValue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegStipulationValue() { return hasLegStipulationValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegStipulationValue(byte[] src) {		
		if (src == null ) return;
		if (hasLegStipulationValue()) FixUtils.fillSpace(legStipulationValue);		
		FixUtils.copy(legStipulationValue, src); 		
		hasLegStipulationValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegStipulationValue(String str) {		
		if (str == null ) return;
		if (hasLegStipulationValue()) FixUtils.fillSpace(legStipulationValue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legStipulationValue, src); 		
		hasLegStipulationValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasLegStipulationType()) s += "LegStipulationType(688)= " + new String( FixUtils.trim(getLegStipulationType()) ) + "\n" ; 
		if (hasLegStipulationValue()) s += "LegStipulationValue(689)= " + new String( FixUtils.trim(getLegStipulationValue()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixLegStipulations)) return false;

		FixLegStipulations msg = (FixLegStipulations) o;

		if ((hasLegStipulationType() && !msg.hasLegStipulationType()) || (!hasLegStipulationType() && msg.hasLegStipulationType())) return false;
		if (!(!hasLegStipulationType() && !msg.hasLegStipulationType()) && !FixUtils.equals(getLegStipulationType(), msg.getLegStipulationType())) return false;
		if ((hasLegStipulationValue() && !msg.hasLegStipulationValue()) || (!hasLegStipulationValue() && msg.hasLegStipulationValue())) return false;
		if (!(!hasLegStipulationValue() && !msg.hasLegStipulationValue()) && !FixUtils.equals(getLegStipulationValue(), msg.getLegStipulationValue())) return false;
		return true;
	}
	public FixLegStipulations clone ( FixLegStipulations out ) {
		if ( hasLegStipulationType())
			out.setLegStipulationType(getLegStipulationType());
		if ( hasLegStipulationValue())
			out.setLegStipulationValue(getLegStipulationValue());
		return out;
	}

}
