package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixPositionAmountData extends FixGroup {
	private short hasPosAmtType;
	byte[] posAmtType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPosAmt;
	long posAmt = 0;		
	private short hasPositionCurrency;
	byte[] positionCurrency = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixPositionAmountData() {
		this(false);
	}

	public FixPositionAmountData(boolean isRequired) {
		super(FixTags.POSAMTTYPE_INT);

		this.isRequired = isRequired;
		
		hasPosAmtType = FixUtils.TAG_HAS_NO_VALUE;		
		posAmtType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPosAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasPositionCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		positionCurrency = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasPosAmtType()) return true;
		else return false;
	}


	/**
     * Parse FIX Group. The buffer is positioned at the value of the tag.
     */
    public int setBuffer( int tag, ByteBuffer buf, FixValidationError err)
    {

		super.err = err;
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.POSAMTTYPE_INT:		
            		hasPosAmtType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.POSAMT_INT:		
            		hasPosAmt = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.POSITIONCURRENCY_INT:		
            		hasPositionCurrency = (short) buf.position();		
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
		hasPosAmtType = FixUtils.TAG_HAS_NO_VALUE;
		hasPosAmt = FixUtils.TAG_HAS_NO_VALUE;
		hasPositionCurrency = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasPosAmtType()) {		
			out.put(FixTags.POSAMTTYPE);

			out.put((byte) '=');

			FixUtils.put(out,posAmtType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPosAmt()) {		
			out.put(FixTags.POSAMT);

			out.put((byte) '=');

			FixUtils.put(out, (long)posAmt);
		
			out.put(FixUtils.SOH);

            }

		if (hasPositionCurrency()) {		
			out.put(FixTags.POSITIONCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,positionCurrency); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasPosAmtType()) {		
			FixUtils.put(out,posAmtType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPosAmt()) {		
			FixUtils.put(out, (long)posAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPositionCurrency()) {		
			FixUtils.put(out,positionCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getPosAmtType() { 		
		if ( hasPosAmtType()) {		
			if (hasPosAmtType == FixUtils.TAG_HAS_VALUE) {		
				return posAmtType; 		
			} else {		
		
				buf.position(hasPosAmtType);		
		
			FixUtils.getTagStringValue(buf, posAmtType, 0, posAmtType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPosAmtType);		
					return null;		
				}		
			}		
			hasPosAmtType = FixUtils.TAG_HAS_VALUE;		
			return posAmtType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPosAmtType() { return hasPosAmtType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPosAmtType(byte[] src) {		
		if (src == null ) return;
		if (hasPosAmtType()) FixUtils.fillNul(posAmtType);		
		FixUtils.copy(posAmtType, src); 		
		hasPosAmtType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPosAmtType(String str) {		
		if (str == null ) return;
		if (hasPosAmtType()) FixUtils.fillNul(posAmtType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(posAmtType, src); 		
		hasPosAmtType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPosAmt() { 		
		if ( hasPosAmt()) {		
			if (hasPosAmt == FixUtils.TAG_HAS_VALUE) {		
				return posAmt; 		
			} else {		
		
				buf.position(hasPosAmt);		
		
			posAmt = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPosAmt);		
					return 0;		
				}		
			}		
			hasPosAmt = FixUtils.TAG_HAS_VALUE;		
			return posAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPosAmt() { return hasPosAmt != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPosAmt(long src) {		
		posAmt = src;
		hasPosAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosAmt(byte[] src) {		
		if (src == null ) return;
		if (hasPosAmt()) posAmt = FixUtils.TAG_HAS_NO_VALUE;		
		posAmt = FixUtils.longValueOf(src, 0, src.length);
		hasPosAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPosAmt(String str) {		
		if (str == null ) return;
		if (hasPosAmt()) posAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		posAmt = FixUtils.longValueOf(src, 0, src.length);
		hasPosAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getPositionCurrency() { 		
		if ( hasPositionCurrency()) {		
			if (hasPositionCurrency == FixUtils.TAG_HAS_VALUE) {		
				return positionCurrency; 		
			} else {		
		
				buf.position(hasPositionCurrency);		
		
			FixUtils.getTagStringValue(buf, positionCurrency, 0, positionCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPositionCurrency);		
					return null;		
				}		
			}		
			hasPositionCurrency = FixUtils.TAG_HAS_VALUE;		
			return positionCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPositionCurrency() { return hasPositionCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPositionCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasPositionCurrency()) FixUtils.fillNul(positionCurrency);		
		FixUtils.copy(positionCurrency, src); 		
		hasPositionCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPositionCurrency(String str) {		
		if (str == null ) return;
		if (hasPositionCurrency()) FixUtils.fillNul(positionCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(positionCurrency, src); 		
		hasPositionCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasPosAmtType()) s += "PosAmtType(707)= " + new String( FixUtils.trim(getPosAmtType()) ) + "\n" ; 
		if (hasPosAmt()) s += "PosAmt(708)= " + getPosAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPositionCurrency()) s += "PositionCurrency(1055)= " + new String( FixUtils.trim(getPositionCurrency()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPositionAmountData)) return false;

		FixPositionAmountData msg = (FixPositionAmountData) o;

		if ((hasPosAmtType() && !msg.hasPosAmtType()) || (!hasPosAmtType() && msg.hasPosAmtType())) return false;
		if (!(!hasPosAmtType() && !msg.hasPosAmtType()) && !FixUtils.equals(getPosAmtType(), msg.getPosAmtType())) return false;
		if ((hasPosAmt() && !msg.hasPosAmt()) || (!hasPosAmt() && msg.hasPosAmt())) return false;
		if (!(!hasPosAmt() && !msg.hasPosAmt()) && !(getPosAmt()==msg.getPosAmt())) return false;
		if ((hasPositionCurrency() && !msg.hasPositionCurrency()) || (!hasPositionCurrency() && msg.hasPositionCurrency())) return false;
		if (!(!hasPositionCurrency() && !msg.hasPositionCurrency()) && !FixUtils.equals(getPositionCurrency(), msg.getPositionCurrency())) return false;
		return true;
	}
	public FixPositionAmountData clone ( FixPositionAmountData out ) {
		if ( hasPosAmtType())
			out.setPosAmtType(getPosAmtType());
		if ( hasPosAmt())
			out.setPosAmt(getPosAmt());
		if ( hasPositionCurrency())
			out.setPositionCurrency(getPositionCurrency());
		return out;
	}

}
