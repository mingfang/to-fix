package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixPriceLimits extends FixGroup {
	private short hasPriceLimitType;
	long priceLimitType = 0;		
	private short hasLowLimitPrice;
	long lowLimitPrice = 0;		
	private short hasHighLimitPrice;
	long highLimitPrice = 0;		
	private short hasTradingReferencePrice;
	long tradingReferencePrice = 0;		
	
	public FixPriceLimits() {
		this(false);
	}

	public FixPriceLimits(boolean isRequired) {
		super(FixTags.PRICELIMITTYPE_INT);

		this.isRequired = isRequired;
		
		hasPriceLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		hasLowLimitPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasHighLimitPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradingReferencePrice = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasPriceLimitType()) return true;
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
            	case FixTags.PRICELIMITTYPE_INT:		
            		hasPriceLimitType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LOWLIMITPRICE_INT:		
            		hasLowLimitPrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.HIGHLIMITPRICE_INT:		
            		hasHighLimitPrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADINGREFERENCEPRICE_INT:		
            		hasTradingReferencePrice = (short) buf.position();		
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
		hasPriceLimitType = FixUtils.TAG_HAS_NO_VALUE;
		hasLowLimitPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasHighLimitPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasTradingReferencePrice = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasPriceLimitType()) {		
			out.put(FixTags.PRICELIMITTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)priceLimitType);
		
			out.put(FixUtils.SOH);

            }

		if (hasLowLimitPrice()) {		
			out.put(FixTags.LOWLIMITPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)lowLimitPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasHighLimitPrice()) {		
			out.put(FixTags.HIGHLIMITPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)highLimitPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasTradingReferencePrice()) {		
			out.put(FixTags.TRADINGREFERENCEPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)tradingReferencePrice);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasPriceLimitType()) {		
			FixUtils.put(out, (long)priceLimitType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLowLimitPrice()) {		
			FixUtils.put(out, (long)lowLimitPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHighLimitPrice()) {		
			FixUtils.put(out, (long)highLimitPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingReferencePrice()) {		
			FixUtils.put(out, (long)tradingReferencePrice);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getPriceLimitType() { 		
		if ( hasPriceLimitType()) {		
			if (hasPriceLimitType == FixUtils.TAG_HAS_VALUE) {		
				return priceLimitType; 		
			} else {		
		
				buf.position(hasPriceLimitType);		
		
			priceLimitType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPriceLimitType);		
					return 0;		
				}		
			}		
			hasPriceLimitType = FixUtils.TAG_HAS_VALUE;		
			return priceLimitType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriceLimitType() { return hasPriceLimitType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPriceLimitType(long src) {		
		priceLimitType = src;
		hasPriceLimitType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceLimitType(byte[] src) {		
		if (src == null ) return;
		if (hasPriceLimitType()) priceLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		priceLimitType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceLimitType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPriceLimitType(String str) {		
		if (str == null ) return;
		if (hasPriceLimitType()) priceLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priceLimitType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceLimitType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLowLimitPrice() { 		
		if ( hasLowLimitPrice()) {		
			if (hasLowLimitPrice == FixUtils.TAG_HAS_VALUE) {		
				return lowLimitPrice; 		
			} else {		
		
				buf.position(hasLowLimitPrice);		
		
			lowLimitPrice = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLowLimitPrice);		
					return 0;		
				}		
			}		
			hasLowLimitPrice = FixUtils.TAG_HAS_VALUE;		
			return lowLimitPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLowLimitPrice() { return hasLowLimitPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLowLimitPrice(long src) {		
		lowLimitPrice = src;
		hasLowLimitPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLowLimitPrice(byte[] src) {		
		if (src == null ) return;
		if (hasLowLimitPrice()) lowLimitPrice = FixUtils.TAG_HAS_NO_VALUE;		
		lowLimitPrice = FixUtils.longValueOf(src, 0, src.length);
		hasLowLimitPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLowLimitPrice(String str) {		
		if (str == null ) return;
		if (hasLowLimitPrice()) lowLimitPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lowLimitPrice = FixUtils.longValueOf(src, 0, src.length);
		hasLowLimitPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getHighLimitPrice() { 		
		if ( hasHighLimitPrice()) {		
			if (hasHighLimitPrice == FixUtils.TAG_HAS_VALUE) {		
				return highLimitPrice; 		
			} else {		
		
				buf.position(hasHighLimitPrice);		
		
			highLimitPrice = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasHighLimitPrice);		
					return 0;		
				}		
			}		
			hasHighLimitPrice = FixUtils.TAG_HAS_VALUE;		
			return highLimitPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasHighLimitPrice() { return hasHighLimitPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setHighLimitPrice(long src) {		
		highLimitPrice = src;
		hasHighLimitPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHighLimitPrice(byte[] src) {		
		if (src == null ) return;
		if (hasHighLimitPrice()) highLimitPrice = FixUtils.TAG_HAS_NO_VALUE;		
		highLimitPrice = FixUtils.longValueOf(src, 0, src.length);
		hasHighLimitPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setHighLimitPrice(String str) {		
		if (str == null ) return;
		if (hasHighLimitPrice()) highLimitPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		highLimitPrice = FixUtils.longValueOf(src, 0, src.length);
		hasHighLimitPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTradingReferencePrice() { 		
		if ( hasTradingReferencePrice()) {		
			if (hasTradingReferencePrice == FixUtils.TAG_HAS_VALUE) {		
				return tradingReferencePrice; 		
			} else {		
		
				buf.position(hasTradingReferencePrice);		
		
			tradingReferencePrice = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTradingReferencePrice);		
					return 0;		
				}		
			}		
			hasTradingReferencePrice = FixUtils.TAG_HAS_VALUE;		
			return tradingReferencePrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradingReferencePrice() { return hasTradingReferencePrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradingReferencePrice(long src) {		
		tradingReferencePrice = src;
		hasTradingReferencePrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradingReferencePrice(byte[] src) {		
		if (src == null ) return;
		if (hasTradingReferencePrice()) tradingReferencePrice = FixUtils.TAG_HAS_NO_VALUE;		
		tradingReferencePrice = FixUtils.longValueOf(src, 0, src.length);
		hasTradingReferencePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradingReferencePrice(String str) {		
		if (str == null ) return;
		if (hasTradingReferencePrice()) tradingReferencePrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradingReferencePrice = FixUtils.longValueOf(src, 0, src.length);
		hasTradingReferencePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasPriceLimitType()) s += "PriceLimitType(1306)= " + getPriceLimitType() + "\n" ; 
		if (hasLowLimitPrice()) s += "LowLimitPrice(1148)= " + getLowLimitPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasHighLimitPrice()) s += "HighLimitPrice(1149)= " + getHighLimitPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTradingReferencePrice()) s += "TradingReferencePrice(1150)= " + getTradingReferencePrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPriceLimits)) return false;

		FixPriceLimits msg = (FixPriceLimits) o;

		if ((hasPriceLimitType() && !msg.hasPriceLimitType()) || (!hasPriceLimitType() && msg.hasPriceLimitType())) return false;
		if (!(!hasPriceLimitType() && !msg.hasPriceLimitType()) && !(getPriceLimitType()==msg.getPriceLimitType())) return false;
		if ((hasLowLimitPrice() && !msg.hasLowLimitPrice()) || (!hasLowLimitPrice() && msg.hasLowLimitPrice())) return false;
		if (!(!hasLowLimitPrice() && !msg.hasLowLimitPrice()) && !(getLowLimitPrice()==msg.getLowLimitPrice())) return false;
		if ((hasHighLimitPrice() && !msg.hasHighLimitPrice()) || (!hasHighLimitPrice() && msg.hasHighLimitPrice())) return false;
		if (!(!hasHighLimitPrice() && !msg.hasHighLimitPrice()) && !(getHighLimitPrice()==msg.getHighLimitPrice())) return false;
		if ((hasTradingReferencePrice() && !msg.hasTradingReferencePrice()) || (!hasTradingReferencePrice() && msg.hasTradingReferencePrice())) return false;
		if (!(!hasTradingReferencePrice() && !msg.hasTradingReferencePrice()) && !(getTradingReferencePrice()==msg.getTradingReferencePrice())) return false;
		return true;
	}
	public FixPriceLimits clone ( FixPriceLimits out ) {
		if ( hasPriceLimitType())
			out.setPriceLimitType(getPriceLimitType());
		if ( hasLowLimitPrice())
			out.setLowLimitPrice(getLowLimitPrice());
		if ( hasHighLimitPrice())
			out.setHighLimitPrice(getHighLimitPrice());
		if ( hasTradingReferencePrice())
			out.setTradingReferencePrice(getTradingReferencePrice());
		return out;
	}

}
