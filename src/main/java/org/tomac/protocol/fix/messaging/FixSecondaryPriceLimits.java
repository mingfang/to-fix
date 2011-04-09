package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSecondaryPriceLimits extends FixGroup {
	private short hasSecondaryPriceLimitType;
	long secondaryPriceLimitType = 0;		
	private short hasSecondaryLowLimitPrice;
	long secondaryLowLimitPrice = 0;		
	private short hasSecondaryHighLimitPrice;
	long secondaryHighLimitPrice = 0;		
	private short hasSecondaryTradingReferencePrice;
	long secondaryTradingReferencePrice = 0;		
	
	public FixSecondaryPriceLimits() {
		this(false);
	}

	public FixSecondaryPriceLimits(boolean isRequired) {
		super(FixTags.SECONDARYPRICELIMITTYPE_INT);

		this.isRequired = isRequired;
		
		hasSecondaryPriceLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecondaryLowLimitPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecondaryHighLimitPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecondaryTradingReferencePrice = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSecondaryPriceLimitType()) return true;
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
            	case FixTags.SECONDARYPRICELIMITTYPE_INT:		
            		hasSecondaryPriceLimitType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYLOWLIMITPRICE_INT:		
            		hasSecondaryLowLimitPrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYHIGHLIMITPRICE_INT:		
            		hasSecondaryHighLimitPrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYTRADINGREFERENCEPRICE_INT:		
            		hasSecondaryTradingReferencePrice = (short) buf.position();		
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
		hasSecondaryPriceLimitType = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryLowLimitPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryHighLimitPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryTradingReferencePrice = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSecondaryPriceLimitType()) {		
			out.put(FixTags.SECONDARYPRICELIMITTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)secondaryPriceLimitType);
		
			out.put(FixUtils.SOH);

            }

		if (hasSecondaryLowLimitPrice()) {		
			out.put(FixTags.SECONDARYLOWLIMITPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)secondaryLowLimitPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasSecondaryHighLimitPrice()) {		
			out.put(FixTags.SECONDARYHIGHLIMITPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)secondaryHighLimitPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasSecondaryTradingReferencePrice()) {		
			out.put(FixTags.SECONDARYTRADINGREFERENCEPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)secondaryTradingReferencePrice);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSecondaryPriceLimitType()) {		
			FixUtils.put(out, (long)secondaryPriceLimitType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryLowLimitPrice()) {		
			FixUtils.put(out, (long)secondaryLowLimitPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryHighLimitPrice()) {		
			FixUtils.put(out, (long)secondaryHighLimitPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryTradingReferencePrice()) {		
			FixUtils.put(out, (long)secondaryTradingReferencePrice);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getSecondaryPriceLimitType() { 		
		if ( hasSecondaryPriceLimitType()) {		
			if (hasSecondaryPriceLimitType == FixUtils.TAG_HAS_VALUE) {		
				return secondaryPriceLimitType; 		
			} else {		
		
				buf.position(hasSecondaryPriceLimitType);		
		
			secondaryPriceLimitType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryPriceLimitType);		
					return 0;		
				}		
			}		
			hasSecondaryPriceLimitType = FixUtils.TAG_HAS_VALUE;		
			return secondaryPriceLimitType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecondaryPriceLimitType() { return hasSecondaryPriceLimitType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecondaryPriceLimitType(long src) {		
		secondaryPriceLimitType = src;
		hasSecondaryPriceLimitType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryPriceLimitType(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryPriceLimitType()) secondaryPriceLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryPriceLimitType = FixUtils.longValueOf(src, 0, src.length);
		hasSecondaryPriceLimitType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryPriceLimitType(String str) {		
		if (str == null ) return;
		if (hasSecondaryPriceLimitType()) secondaryPriceLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		secondaryPriceLimitType = FixUtils.longValueOf(src, 0, src.length);
		hasSecondaryPriceLimitType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSecondaryLowLimitPrice() { 		
		if ( hasSecondaryLowLimitPrice()) {		
			if (hasSecondaryLowLimitPrice == FixUtils.TAG_HAS_VALUE) {		
				return secondaryLowLimitPrice; 		
			} else {		
		
				buf.position(hasSecondaryLowLimitPrice);		
		
			secondaryLowLimitPrice = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryLowLimitPrice);		
					return 0;		
				}		
			}		
			hasSecondaryLowLimitPrice = FixUtils.TAG_HAS_VALUE;		
			return secondaryLowLimitPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecondaryLowLimitPrice() { return hasSecondaryLowLimitPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecondaryLowLimitPrice(long src) {		
		secondaryLowLimitPrice = src;
		hasSecondaryLowLimitPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryLowLimitPrice(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryLowLimitPrice()) secondaryLowLimitPrice = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryLowLimitPrice = FixUtils.longValueOf(src, 0, src.length);
		hasSecondaryLowLimitPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryLowLimitPrice(String str) {		
		if (str == null ) return;
		if (hasSecondaryLowLimitPrice()) secondaryLowLimitPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		secondaryLowLimitPrice = FixUtils.longValueOf(src, 0, src.length);
		hasSecondaryLowLimitPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSecondaryHighLimitPrice() { 		
		if ( hasSecondaryHighLimitPrice()) {		
			if (hasSecondaryHighLimitPrice == FixUtils.TAG_HAS_VALUE) {		
				return secondaryHighLimitPrice; 		
			} else {		
		
				buf.position(hasSecondaryHighLimitPrice);		
		
			secondaryHighLimitPrice = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryHighLimitPrice);		
					return 0;		
				}		
			}		
			hasSecondaryHighLimitPrice = FixUtils.TAG_HAS_VALUE;		
			return secondaryHighLimitPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecondaryHighLimitPrice() { return hasSecondaryHighLimitPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecondaryHighLimitPrice(long src) {		
		secondaryHighLimitPrice = src;
		hasSecondaryHighLimitPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryHighLimitPrice(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryHighLimitPrice()) secondaryHighLimitPrice = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryHighLimitPrice = FixUtils.longValueOf(src, 0, src.length);
		hasSecondaryHighLimitPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryHighLimitPrice(String str) {		
		if (str == null ) return;
		if (hasSecondaryHighLimitPrice()) secondaryHighLimitPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		secondaryHighLimitPrice = FixUtils.longValueOf(src, 0, src.length);
		hasSecondaryHighLimitPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSecondaryTradingReferencePrice() { 		
		if ( hasSecondaryTradingReferencePrice()) {		
			if (hasSecondaryTradingReferencePrice == FixUtils.TAG_HAS_VALUE) {		
				return secondaryTradingReferencePrice; 		
			} else {		
		
				buf.position(hasSecondaryTradingReferencePrice);		
		
			secondaryTradingReferencePrice = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryTradingReferencePrice);		
					return 0;		
				}		
			}		
			hasSecondaryTradingReferencePrice = FixUtils.TAG_HAS_VALUE;		
			return secondaryTradingReferencePrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecondaryTradingReferencePrice() { return hasSecondaryTradingReferencePrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecondaryTradingReferencePrice(long src) {		
		secondaryTradingReferencePrice = src;
		hasSecondaryTradingReferencePrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryTradingReferencePrice(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryTradingReferencePrice()) secondaryTradingReferencePrice = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryTradingReferencePrice = FixUtils.longValueOf(src, 0, src.length);
		hasSecondaryTradingReferencePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryTradingReferencePrice(String str) {		
		if (str == null ) return;
		if (hasSecondaryTradingReferencePrice()) secondaryTradingReferencePrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		secondaryTradingReferencePrice = FixUtils.longValueOf(src, 0, src.length);
		hasSecondaryTradingReferencePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSecondaryPriceLimitType()) s += "SecondaryPriceLimitType(1305)= " + getSecondaryPriceLimitType() + "\n" ; 
		if (hasSecondaryLowLimitPrice()) s += "SecondaryLowLimitPrice(1221)= " + getSecondaryLowLimitPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSecondaryHighLimitPrice()) s += "SecondaryHighLimitPrice(1230)= " + getSecondaryHighLimitPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSecondaryTradingReferencePrice()) s += "SecondaryTradingReferencePrice(1240)= " + getSecondaryTradingReferencePrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSecondaryPriceLimits)) return false;

		FixSecondaryPriceLimits msg = (FixSecondaryPriceLimits) o;

		if ((hasSecondaryPriceLimitType() && !msg.hasSecondaryPriceLimitType()) || (!hasSecondaryPriceLimitType() && msg.hasSecondaryPriceLimitType())) return false;
		if (!(!hasSecondaryPriceLimitType() && !msg.hasSecondaryPriceLimitType()) && !(getSecondaryPriceLimitType()==msg.getSecondaryPriceLimitType())) return false;
		if ((hasSecondaryLowLimitPrice() && !msg.hasSecondaryLowLimitPrice()) || (!hasSecondaryLowLimitPrice() && msg.hasSecondaryLowLimitPrice())) return false;
		if (!(!hasSecondaryLowLimitPrice() && !msg.hasSecondaryLowLimitPrice()) && !(getSecondaryLowLimitPrice()==msg.getSecondaryLowLimitPrice())) return false;
		if ((hasSecondaryHighLimitPrice() && !msg.hasSecondaryHighLimitPrice()) || (!hasSecondaryHighLimitPrice() && msg.hasSecondaryHighLimitPrice())) return false;
		if (!(!hasSecondaryHighLimitPrice() && !msg.hasSecondaryHighLimitPrice()) && !(getSecondaryHighLimitPrice()==msg.getSecondaryHighLimitPrice())) return false;
		if ((hasSecondaryTradingReferencePrice() && !msg.hasSecondaryTradingReferencePrice()) || (!hasSecondaryTradingReferencePrice() && msg.hasSecondaryTradingReferencePrice())) return false;
		if (!(!hasSecondaryTradingReferencePrice() && !msg.hasSecondaryTradingReferencePrice()) && !(getSecondaryTradingReferencePrice()==msg.getSecondaryTradingReferencePrice())) return false;
		return true;
	}
	public FixSecondaryPriceLimits clone ( FixSecondaryPriceLimits out ) {
		if ( hasSecondaryPriceLimitType())
			out.setSecondaryPriceLimitType(getSecondaryPriceLimitType());
		if ( hasSecondaryLowLimitPrice())
			out.setSecondaryLowLimitPrice(getSecondaryLowLimitPrice());
		if ( hasSecondaryHighLimitPrice())
			out.setSecondaryHighLimitPrice(getSecondaryHighLimitPrice());
		if ( hasSecondaryTradingReferencePrice())
			out.setSecondaryTradingReferencePrice(getSecondaryTradingReferencePrice());
		return out;
	}

}
