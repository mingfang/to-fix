package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixOrderQtyData extends FixGroup {
	private short hasOrderQty;
	long orderQty = 0;		
	private short hasCashOrderQty;
	long cashOrderQty = 0;		
	private short hasOrderPercent;
	long orderPercent = 0;		
	private short hasRoundingDirection;
	byte roundingDirection = (byte)' ';		
	private short hasRoundingModulus;
	long roundingModulus = 0;		
	
	public FixOrderQtyData() {
		this(false);
	}

	public FixOrderQtyData(boolean isRequired) {
		super(FixTags.ORDERQTY_INT);

		this.isRequired = isRequired;
		
		hasOrderQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasCashOrderQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderPercent = FixUtils.TAG_HAS_NO_VALUE;		
		hasRoundingDirection = FixUtils.TAG_HAS_NO_VALUE;		
		hasRoundingModulus = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasOrderQty()) return true;
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
            	case FixTags.ORDERQTY_INT:		
            		hasOrderQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CASHORDERQTY_INT:		
            		hasCashOrderQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERPERCENT_INT:		
            		hasOrderPercent = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ROUNDINGDIRECTION_INT:		
            		hasRoundingDirection = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ROUNDINGMODULUS_INT:		
            		hasRoundingModulus = (short) buf.position();		
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
		hasOrderQty = FixUtils.TAG_HAS_NO_VALUE;
		hasCashOrderQty = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderPercent = FixUtils.TAG_HAS_NO_VALUE;
		hasRoundingDirection = FixUtils.TAG_HAS_NO_VALUE;
		hasRoundingModulus = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasOrderQty()) {		
			out.put(FixTags.ORDERQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)orderQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasCashOrderQty()) {		
			out.put(FixTags.CASHORDERQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)cashOrderQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderPercent()) {		
			out.put(FixTags.ORDERPERCENT);

			out.put((byte) '=');

			FixUtils.put(out, (long)orderPercent);
		
			out.put(FixUtils.SOH);

            }

		if (hasRoundingDirection()) {		
			out.put(FixTags.ROUNDINGDIRECTION);

			out.put((byte) '=');

			FixUtils.put(out,roundingDirection); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRoundingModulus()) {		
			out.put(FixTags.ROUNDINGMODULUS);

			out.put((byte) '=');

			FixUtils.put(out, (long)roundingModulus);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasOrderQty()) {		
			FixUtils.put(out, (long)orderQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCashOrderQty()) {		
			FixUtils.put(out, (long)cashOrderQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderPercent()) {		
			FixUtils.put(out, (long)orderPercent);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRoundingDirection()) {		
			FixUtils.put(out,roundingDirection); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRoundingModulus()) {		
			FixUtils.put(out, (long)roundingModulus);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getOrderQty() { 		
		if ( hasOrderQty()) {		
			if (hasOrderQty == FixUtils.TAG_HAS_VALUE) {		
				return orderQty; 		
			} else {		
		
				buf.position(hasOrderQty);		
		
			orderQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderQty);		
					return 0;		
				}		
			}		
			hasOrderQty = FixUtils.TAG_HAS_VALUE;		
			return orderQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrderQty() { return hasOrderQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderQty(long src) {		
		orderQty = src;
		hasOrderQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderQty(byte[] src) {		
		if (src == null ) return;
		if (hasOrderQty()) orderQty = FixUtils.TAG_HAS_NO_VALUE;		
		orderQty = FixUtils.longValueOf(src, 0, src.length);
		hasOrderQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderQty(String str) {		
		if (str == null ) return;
		if (hasOrderQty()) orderQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		orderQty = FixUtils.longValueOf(src, 0, src.length);
		hasOrderQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getCashOrderQty() { 		
		if ( hasCashOrderQty()) {		
			if (hasCashOrderQty == FixUtils.TAG_HAS_VALUE) {		
				return cashOrderQty; 		
			} else {		
		
				buf.position(hasCashOrderQty);		
		
			cashOrderQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasCashOrderQty);		
					return 0;		
				}		
			}		
			hasCashOrderQty = FixUtils.TAG_HAS_VALUE;		
			return cashOrderQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCashOrderQty() { return hasCashOrderQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCashOrderQty(long src) {		
		cashOrderQty = src;
		hasCashOrderQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCashOrderQty(byte[] src) {		
		if (src == null ) return;
		if (hasCashOrderQty()) cashOrderQty = FixUtils.TAG_HAS_NO_VALUE;		
		cashOrderQty = FixUtils.longValueOf(src, 0, src.length);
		hasCashOrderQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCashOrderQty(String str) {		
		if (str == null ) return;
		if (hasCashOrderQty()) cashOrderQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		cashOrderQty = FixUtils.longValueOf(src, 0, src.length);
		hasCashOrderQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOrderPercent() { 		
		if ( hasOrderPercent()) {		
			if (hasOrderPercent == FixUtils.TAG_HAS_VALUE) {		
				return orderPercent; 		
			} else {		
		
				buf.position(hasOrderPercent);		
		
			orderPercent = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderPercent);		
					return 0;		
				}		
			}		
			hasOrderPercent = FixUtils.TAG_HAS_VALUE;		
			return orderPercent;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrderPercent() { return hasOrderPercent != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderPercent(long src) {		
		orderPercent = src;
		hasOrderPercent = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderPercent(byte[] src) {		
		if (src == null ) return;
		if (hasOrderPercent()) orderPercent = FixUtils.TAG_HAS_NO_VALUE;		
		orderPercent = FixUtils.longValueOf(src, 0, src.length);
		hasOrderPercent = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderPercent(String str) {		
		if (str == null ) return;
		if (hasOrderPercent()) orderPercent = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		orderPercent = FixUtils.longValueOf(src, 0, src.length);
		hasOrderPercent = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getRoundingDirection() { 		
		if ( hasRoundingDirection()) {		
			if (hasRoundingDirection == FixUtils.TAG_HAS_VALUE) {		
				return roundingDirection; 		
			} else {		
		
				buf.position(hasRoundingDirection);		
		
			roundingDirection = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (roundingDirection != (byte)'2') && (roundingDirection != (byte)'1') && (roundingDirection != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 468);		
				if (err.hasError()) {		
					buf.position(hasRoundingDirection);		
					return (byte)'0';		
				}		
			}		
			hasRoundingDirection = FixUtils.TAG_HAS_VALUE;		
			return roundingDirection;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasRoundingDirection() { return hasRoundingDirection != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRoundingDirection(byte src) {		
		roundingDirection = src;
		hasRoundingDirection = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRoundingDirection(byte[] src) {		
		if (src == null ) return;
		if (hasRoundingDirection()) roundingDirection = (byte)' ';		
		roundingDirection = src[0];		
		hasRoundingDirection = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRoundingDirection(String str) {		
		if (str == null ) return;
		if (hasRoundingDirection()) roundingDirection = (byte)' ';		
		byte[] src = str.getBytes(); 		
		roundingDirection = src[0];		
		hasRoundingDirection = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRoundingModulus() { 		
		if ( hasRoundingModulus()) {		
			if (hasRoundingModulus == FixUtils.TAG_HAS_VALUE) {		
				return roundingModulus; 		
			} else {		
		
				buf.position(hasRoundingModulus);		
		
			roundingModulus = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRoundingModulus);		
					return 0;		
				}		
			}		
			hasRoundingModulus = FixUtils.TAG_HAS_VALUE;		
			return roundingModulus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRoundingModulus() { return hasRoundingModulus != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRoundingModulus(long src) {		
		roundingModulus = src;
		hasRoundingModulus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRoundingModulus(byte[] src) {		
		if (src == null ) return;
		if (hasRoundingModulus()) roundingModulus = FixUtils.TAG_HAS_NO_VALUE;		
		roundingModulus = FixUtils.longValueOf(src, 0, src.length);
		hasRoundingModulus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRoundingModulus(String str) {		
		if (str == null ) return;
		if (hasRoundingModulus()) roundingModulus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		roundingModulus = FixUtils.longValueOf(src, 0, src.length);
		hasRoundingModulus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasOrderQty()) s += "OrderQty(38)= " + getOrderQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCashOrderQty()) s += "CashOrderQty(152)= " + getCashOrderQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOrderPercent()) s += "OrderPercent(516)= " + getOrderPercent() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasRoundingDirection()) s += "RoundingDirection(468)= " + getRoundingDirection() + "\n" ; 
		if (hasRoundingModulus()) s += "RoundingModulus(469)= " + getRoundingModulus() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixOrderQtyData)) return false;

		FixOrderQtyData msg = (FixOrderQtyData) o;

		if ((hasOrderQty() && !msg.hasOrderQty()) || (!hasOrderQty() && msg.hasOrderQty())) return false;
		if (!(!hasOrderQty() && !msg.hasOrderQty()) && !(getOrderQty()==msg.getOrderQty())) return false;
		if ((hasCashOrderQty() && !msg.hasCashOrderQty()) || (!hasCashOrderQty() && msg.hasCashOrderQty())) return false;
		if (!(!hasCashOrderQty() && !msg.hasCashOrderQty()) && !(getCashOrderQty()==msg.getCashOrderQty())) return false;
		if ((hasOrderPercent() && !msg.hasOrderPercent()) || (!hasOrderPercent() && msg.hasOrderPercent())) return false;
		if (!(!hasOrderPercent() && !msg.hasOrderPercent()) && !(getOrderPercent()==msg.getOrderPercent())) return false;
		if ((hasRoundingDirection() && !msg.hasRoundingDirection()) || (!hasRoundingDirection() && msg.hasRoundingDirection())) return false;
		if (!(!hasRoundingDirection() && !msg.hasRoundingDirection()) && !(getRoundingDirection()==msg.getRoundingDirection())) return false;
		if ((hasRoundingModulus() && !msg.hasRoundingModulus()) || (!hasRoundingModulus() && msg.hasRoundingModulus())) return false;
		if (!(!hasRoundingModulus() && !msg.hasRoundingModulus()) && !(getRoundingModulus()==msg.getRoundingModulus())) return false;
		return true;
	}
	public FixOrderQtyData clone ( FixOrderQtyData out ) {
		if ( hasOrderQty())
			out.setOrderQty(getOrderQty());
		if ( hasCashOrderQty())
			out.setCashOrderQty(getCashOrderQty());
		if ( hasOrderPercent())
			out.setOrderPercent(getOrderPercent());
		if ( hasRoundingDirection())
			out.setRoundingDirection(getRoundingDirection());
		if ( hasRoundingModulus())
			out.setRoundingModulus(getRoundingModulus());
		return out;
	}

}
