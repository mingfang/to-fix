package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixYieldData extends FixGroup {
	private short hasYieldType;
	byte[] yieldType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasYield;
	long yield = 0;		
	private short hasYieldCalcDate;
	byte[] yieldCalcDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasYieldRedemptionDate;
	byte[] yieldRedemptionDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasYieldRedemptionPrice;
	long yieldRedemptionPrice = 0;		
	private short hasYieldRedemptionPriceType;
	long yieldRedemptionPriceType = 0;		
	
	public FixYieldData() {
		this(false);
	}

	public FixYieldData(boolean isRequired) {
		super(FixTags.YIELDTYPE_INT);

		this.isRequired = isRequired;
		
		hasYieldType = FixUtils.TAG_HAS_NO_VALUE;		
		yieldType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasYield = FixUtils.TAG_HAS_NO_VALUE;		
		hasYieldCalcDate = FixUtils.TAG_HAS_NO_VALUE;		
		yieldCalcDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasYieldRedemptionDate = FixUtils.TAG_HAS_NO_VALUE;		
		yieldRedemptionDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasYieldRedemptionPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasYieldRedemptionPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasYieldType()) return true;
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
            	case FixTags.YIELDTYPE_INT:		
            		hasYieldType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.YIELD_INT:		
            		hasYield = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.YIELDCALCDATE_INT:		
            		hasYieldCalcDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.YIELDREDEMPTIONDATE_INT:		
            		hasYieldRedemptionDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.YIELDREDEMPTIONPRICE_INT:		
            		hasYieldRedemptionPrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.YIELDREDEMPTIONPRICETYPE_INT:		
            		hasYieldRedemptionPriceType = (short) buf.position();		
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
		hasYieldType = FixUtils.TAG_HAS_NO_VALUE;
		hasYield = FixUtils.TAG_HAS_NO_VALUE;
		hasYieldCalcDate = FixUtils.TAG_HAS_NO_VALUE;
		hasYieldRedemptionDate = FixUtils.TAG_HAS_NO_VALUE;
		hasYieldRedemptionPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasYieldRedemptionPriceType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasYieldType()) {		
			out.put(FixTags.YIELDTYPE);

			out.put((byte) '=');

			FixUtils.put(out,yieldType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasYield()) {		
			out.put(FixTags.YIELD);

			out.put((byte) '=');

			FixUtils.put(out, (long)yield);
		
			out.put(FixUtils.SOH);

            }

		if (hasYieldCalcDate()) {		
			out.put(FixTags.YIELDCALCDATE);

			out.put((byte) '=');

			FixUtils.put(out,yieldCalcDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasYieldRedemptionDate()) {		
			out.put(FixTags.YIELDREDEMPTIONDATE);

			out.put((byte) '=');

			FixUtils.put(out,yieldRedemptionDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasYieldRedemptionPrice()) {		
			out.put(FixTags.YIELDREDEMPTIONPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)yieldRedemptionPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasYieldRedemptionPriceType()) {		
			out.put(FixTags.YIELDREDEMPTIONPRICETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)yieldRedemptionPriceType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasYieldType()) {		
			FixUtils.put(out,yieldType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasYield()) {		
			FixUtils.put(out, (long)yield);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasYieldCalcDate()) {		
			FixUtils.put(out,yieldCalcDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasYieldRedemptionDate()) {		
			FixUtils.put(out,yieldRedemptionDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasYieldRedemptionPrice()) {		
			FixUtils.put(out, (long)yieldRedemptionPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasYieldRedemptionPriceType()) {		
			FixUtils.put(out, (long)yieldRedemptionPriceType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getYieldType() { 		
		if ( hasYieldType()) {		
			if (hasYieldType == FixUtils.TAG_HAS_VALUE) {		
				return yieldType; 		
			} else {		
		
				buf.position(hasYieldType);		
		
			FixUtils.getTagStringValue(buf, yieldType, 0, yieldType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasYieldType);		
					return null;		
				}		
			}		
			hasYieldType = FixUtils.TAG_HAS_VALUE;		
			return yieldType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasYieldType() { return hasYieldType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setYieldType(byte[] src) {		
		if (src == null ) return;
		if (hasYieldType()) FixUtils.fillNul(yieldType);		
		FixUtils.copy(yieldType, src); 		
		hasYieldType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setYieldType(String str) {		
		if (str == null ) return;
		if (hasYieldType()) FixUtils.fillNul(yieldType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(yieldType, src); 		
		hasYieldType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getYield() { 		
		if ( hasYield()) {		
			if (hasYield == FixUtils.TAG_HAS_VALUE) {		
				return yield; 		
			} else {		
		
				buf.position(hasYield);		
		
			yield = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasYield);		
					return 0;		
				}		
			}		
			hasYield = FixUtils.TAG_HAS_VALUE;		
			return yield;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasYield() { return hasYield != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setYield(long src) {		
		yield = src;
		hasYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setYield(byte[] src) {		
		if (src == null ) return;
		if (hasYield()) yield = FixUtils.TAG_HAS_NO_VALUE;		
		yield = FixUtils.longValueOf(src, 0, src.length);
		hasYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setYield(String str) {		
		if (str == null ) return;
		if (hasYield()) yield = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		yield = FixUtils.longValueOf(src, 0, src.length);
		hasYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getYieldCalcDate() { 		
		if ( hasYieldCalcDate()) {		
			if (hasYieldCalcDate == FixUtils.TAG_HAS_VALUE) {		
				return yieldCalcDate; 		
			} else {		
		
				buf.position(hasYieldCalcDate);		
		
			FixUtils.getTagStringValue(buf, yieldCalcDate, 0, yieldCalcDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasYieldCalcDate);		
					return null;		
				}		
			}		
			hasYieldCalcDate = FixUtils.TAG_HAS_VALUE;		
			return yieldCalcDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasYieldCalcDate() { return hasYieldCalcDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setYieldCalcDate(byte[] src) {		
		if (src == null ) return;
		if (hasYieldCalcDate()) FixUtils.fillNul(yieldCalcDate);		
		FixUtils.copy(yieldCalcDate, src); 		
		hasYieldCalcDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setYieldCalcDate(String str) {		
		if (str == null ) return;
		if (hasYieldCalcDate()) FixUtils.fillNul(yieldCalcDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(yieldCalcDate, src); 		
		hasYieldCalcDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getYieldRedemptionDate() { 		
		if ( hasYieldRedemptionDate()) {		
			if (hasYieldRedemptionDate == FixUtils.TAG_HAS_VALUE) {		
				return yieldRedemptionDate; 		
			} else {		
		
				buf.position(hasYieldRedemptionDate);		
		
			FixUtils.getTagStringValue(buf, yieldRedemptionDate, 0, yieldRedemptionDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasYieldRedemptionDate);		
					return null;		
				}		
			}		
			hasYieldRedemptionDate = FixUtils.TAG_HAS_VALUE;		
			return yieldRedemptionDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasYieldRedemptionDate() { return hasYieldRedemptionDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setYieldRedemptionDate(byte[] src) {		
		if (src == null ) return;
		if (hasYieldRedemptionDate()) FixUtils.fillNul(yieldRedemptionDate);		
		FixUtils.copy(yieldRedemptionDate, src); 		
		hasYieldRedemptionDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setYieldRedemptionDate(String str) {		
		if (str == null ) return;
		if (hasYieldRedemptionDate()) FixUtils.fillNul(yieldRedemptionDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(yieldRedemptionDate, src); 		
		hasYieldRedemptionDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getYieldRedemptionPrice() { 		
		if ( hasYieldRedemptionPrice()) {		
			if (hasYieldRedemptionPrice == FixUtils.TAG_HAS_VALUE) {		
				return yieldRedemptionPrice; 		
			} else {		
		
				buf.position(hasYieldRedemptionPrice);		
		
			yieldRedemptionPrice = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasYieldRedemptionPrice);		
					return 0;		
				}		
			}		
			hasYieldRedemptionPrice = FixUtils.TAG_HAS_VALUE;		
			return yieldRedemptionPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasYieldRedemptionPrice() { return hasYieldRedemptionPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setYieldRedemptionPrice(long src) {		
		yieldRedemptionPrice = src;
		hasYieldRedemptionPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setYieldRedemptionPrice(byte[] src) {		
		if (src == null ) return;
		if (hasYieldRedemptionPrice()) yieldRedemptionPrice = FixUtils.TAG_HAS_NO_VALUE;		
		yieldRedemptionPrice = FixUtils.longValueOf(src, 0, src.length);
		hasYieldRedemptionPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setYieldRedemptionPrice(String str) {		
		if (str == null ) return;
		if (hasYieldRedemptionPrice()) yieldRedemptionPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		yieldRedemptionPrice = FixUtils.longValueOf(src, 0, src.length);
		hasYieldRedemptionPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getYieldRedemptionPriceType() { 		
		if ( hasYieldRedemptionPriceType()) {		
			if (hasYieldRedemptionPriceType == FixUtils.TAG_HAS_VALUE) {		
				return yieldRedemptionPriceType; 		
			} else {		
		
				buf.position(hasYieldRedemptionPriceType);		
		
			yieldRedemptionPriceType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasYieldRedemptionPriceType);		
					return 0;		
				}		
			}		
			hasYieldRedemptionPriceType = FixUtils.TAG_HAS_VALUE;		
			return yieldRedemptionPriceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasYieldRedemptionPriceType() { return hasYieldRedemptionPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setYieldRedemptionPriceType(long src) {		
		yieldRedemptionPriceType = src;
		hasYieldRedemptionPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setYieldRedemptionPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasYieldRedemptionPriceType()) yieldRedemptionPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		yieldRedemptionPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasYieldRedemptionPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setYieldRedemptionPriceType(String str) {		
		if (str == null ) return;
		if (hasYieldRedemptionPriceType()) yieldRedemptionPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		yieldRedemptionPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasYieldRedemptionPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasYieldType()) s += "YieldType(235)= " + new String( FixUtils.trim(getYieldType()) ) + "\n" ; 
		if (hasYield()) s += "Yield(236)= " + getYield() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasYieldCalcDate()) s += "YieldCalcDate(701)= " + new String( FixUtils.trim(getYieldCalcDate()) ) + "\n" ; 
		if (hasYieldRedemptionDate()) s += "YieldRedemptionDate(696)= " + new String( FixUtils.trim(getYieldRedemptionDate()) ) + "\n" ; 
		if (hasYieldRedemptionPrice()) s += "YieldRedemptionPrice(697)= " + getYieldRedemptionPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasYieldRedemptionPriceType()) s += "YieldRedemptionPriceType(698)= " + getYieldRedemptionPriceType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixYieldData)) return false;

		FixYieldData msg = (FixYieldData) o;

		if ((hasYieldType() && !msg.hasYieldType()) || (!hasYieldType() && msg.hasYieldType())) return false;
		if (!(!hasYieldType() && !msg.hasYieldType()) && !FixUtils.equals(getYieldType(), msg.getYieldType())) return false;
		if ((hasYield() && !msg.hasYield()) || (!hasYield() && msg.hasYield())) return false;
		if (!(!hasYield() && !msg.hasYield()) && !(getYield()==msg.getYield())) return false;
		if ((hasYieldCalcDate() && !msg.hasYieldCalcDate()) || (!hasYieldCalcDate() && msg.hasYieldCalcDate())) return false;
		if ((hasYieldRedemptionDate() && !msg.hasYieldRedemptionDate()) || (!hasYieldRedemptionDate() && msg.hasYieldRedemptionDate())) return false;
		if ((hasYieldRedemptionPrice() && !msg.hasYieldRedemptionPrice()) || (!hasYieldRedemptionPrice() && msg.hasYieldRedemptionPrice())) return false;
		if (!(!hasYieldRedemptionPrice() && !msg.hasYieldRedemptionPrice()) && !(getYieldRedemptionPrice()==msg.getYieldRedemptionPrice())) return false;
		if ((hasYieldRedemptionPriceType() && !msg.hasYieldRedemptionPriceType()) || (!hasYieldRedemptionPriceType() && msg.hasYieldRedemptionPriceType())) return false;
		if (!(!hasYieldRedemptionPriceType() && !msg.hasYieldRedemptionPriceType()) && !(getYieldRedemptionPriceType()==msg.getYieldRedemptionPriceType())) return false;
		return true;
	}
	public FixYieldData clone ( FixYieldData out ) {
		if ( hasYieldType())
			out.setYieldType(getYieldType());
		if ( hasYield())
			out.setYield(getYield());
		if ( hasYieldCalcDate())
			out.setYieldCalcDate(getYieldCalcDate());
		if ( hasYieldRedemptionDate())
			out.setYieldRedemptionDate(getYieldRedemptionDate());
		if ( hasYieldRedemptionPrice())
			out.setYieldRedemptionPrice(getYieldRedemptionPrice());
		if ( hasYieldRedemptionPriceType())
			out.setYieldRedemptionPriceType(getYieldRedemptionPriceType());
		return out;
	}

}
