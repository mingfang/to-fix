package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixCpctyConfGrp extends FixGroup {
	private short hasOrderCapacity;
	byte orderCapacity = (byte)' ';		
	private short hasOrderRestrictions;
	byte[] orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderCapacityQty;
	long orderCapacityQty = 0;		
	
	public FixCpctyConfGrp() {
		this(false);
	}

	public FixCpctyConfGrp(boolean isRequired) {
		super(FixTags.ORDERCAPACITY_INT);

		this.isRequired = isRequired;
		
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderRestrictions = FixUtils.TAG_HAS_NO_VALUE;		
		orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderCapacityQty = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasOrderCapacity()) return true;
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
            	case FixTags.ORDERCAPACITY_INT:		
            		hasOrderCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERRESTRICTIONS_INT:		
            		hasOrderRestrictions = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERCAPACITYQTY_INT:		
            		hasOrderCapacityQty = (short) buf.position();		
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
		if (!hasOrderCapacity()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag OrderCapacity missing", FixTags.ORDERCAPACITY_INT);
			return false;
		}
		if (!hasOrderCapacityQty()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag OrderCapacityQty missing", FixTags.ORDERCAPACITYQTY_INT);
			return false;
		}
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderRestrictions = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderCapacityQty = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasOrderCapacity()) {		
			out.put(FixTags.ORDERCAPACITY);

			out.put((byte) '=');

			FixUtils.put(out,orderCapacity); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderRestrictions()) {		
			out.put(FixTags.ORDERRESTRICTIONS);

			out.put((byte) '=');

			FixUtils.put(out,orderRestrictions); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderCapacityQty()) {		
			out.put(FixTags.ORDERCAPACITYQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)orderCapacityQty);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasOrderCapacity()) {		
			FixUtils.put(out,orderCapacity); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderRestrictions()) {		
			FixUtils.put(out,orderRestrictions); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderCapacityQty()) {		
			FixUtils.put(out, (long)orderCapacityQty);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte getOrderCapacity() { 		
		if ( hasOrderCapacity()) {		
			if (hasOrderCapacity == FixUtils.TAG_HAS_VALUE) {		
				return orderCapacity; 		
			} else {		
		
				buf.position(hasOrderCapacity);		
		
			orderCapacity = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (orderCapacity != (byte)'W') && (orderCapacity != (byte)'G') && (orderCapacity != (byte)'P') && (orderCapacity != (byte)'A') && (orderCapacity != (byte)'R') && (orderCapacity != (byte)'I') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 528);		
				if (err.hasError()) {		
					buf.position(hasOrderCapacity);		
					return (byte)'0';		
				}		
			}		
			hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
			return orderCapacity;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrderCapacity() { return hasOrderCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderCapacity(byte src) {		
		orderCapacity = src;
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasOrderCapacity()) orderCapacity = (byte)' ';		
		orderCapacity = src[0];		
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderCapacity(String str) {		
		if (str == null ) return;
		if (hasOrderCapacity()) orderCapacity = (byte)' ';		
		byte[] src = str.getBytes(); 		
		orderCapacity = src[0];		
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOrderRestrictions() { 		
		if ( hasOrderRestrictions()) {		
			if (hasOrderRestrictions == FixUtils.TAG_HAS_VALUE) {		
				return orderRestrictions; 		
			} else {		
		
				buf.position(hasOrderRestrictions);		
		
			FixMessage.getTagStringValue(buf, orderRestrictions, 0, orderRestrictions.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderRestrictions);		
					return null;		
				}		
			}		
			hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
			return orderRestrictions;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderRestrictions() { return hasOrderRestrictions != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderRestrictions(byte[] src) {		
		if (src == null ) return;
		if (hasOrderRestrictions()) FixUtils.fillNul(orderRestrictions);		
		FixUtils.copy(orderRestrictions, src); 		
		hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderRestrictions(String str) {		
		if (str == null ) return;
		if (hasOrderRestrictions()) FixUtils.fillNul(orderRestrictions);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderRestrictions, src); 		
		hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOrderCapacityQty() { 		
		if ( hasOrderCapacityQty()) {		
			if (hasOrderCapacityQty == FixUtils.TAG_HAS_VALUE) {		
				return orderCapacityQty; 		
			} else {		
		
				buf.position(hasOrderCapacityQty);		
		
			orderCapacityQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderCapacityQty);		
					return 0;		
				}		
			}		
			hasOrderCapacityQty = FixUtils.TAG_HAS_VALUE;		
			return orderCapacityQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrderCapacityQty() { return hasOrderCapacityQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderCapacityQty(long src) {		
		orderCapacityQty = src;
		hasOrderCapacityQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderCapacityQty(byte[] src) {		
		if (src == null ) return;
		if (hasOrderCapacityQty()) orderCapacityQty = FixUtils.TAG_HAS_NO_VALUE;		
		orderCapacityQty = FixUtils.longValueOf(src, 0, src.length);
		hasOrderCapacityQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderCapacityQty(String str) {		
		if (str == null ) return;
		if (hasOrderCapacityQty()) orderCapacityQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		orderCapacityQty = FixUtils.longValueOf(src, 0, src.length);
		hasOrderCapacityQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasOrderCapacity()) s += "OrderCapacity(528)= " + getOrderCapacity() + "\n" ; 
		if (hasOrderRestrictions()) s += "OrderRestrictions(529)= " + new String( FixUtils.trim(getOrderRestrictions()) ) + "\n" ; 
		if (hasOrderCapacityQty()) s += "OrderCapacityQty(863)= " + getOrderCapacityQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixCpctyConfGrp)) return false;

		FixCpctyConfGrp msg = (FixCpctyConfGrp) o;

		if ((hasOrderCapacity() && !msg.hasOrderCapacity()) || (!hasOrderCapacity() && msg.hasOrderCapacity())) return false;
		if (!(!hasOrderCapacity() && !msg.hasOrderCapacity()) && !(getOrderCapacity()==msg.getOrderCapacity())) return false;
		if ((hasOrderRestrictions() && !msg.hasOrderRestrictions()) || (!hasOrderRestrictions() && msg.hasOrderRestrictions())) return false;
		if (!(!hasOrderRestrictions() && !msg.hasOrderRestrictions()) && !FixUtils.equals(getOrderRestrictions(), msg.getOrderRestrictions())) return false;
		if ((hasOrderCapacityQty() && !msg.hasOrderCapacityQty()) || (!hasOrderCapacityQty() && msg.hasOrderCapacityQty())) return false;
		if (!(!hasOrderCapacityQty() && !msg.hasOrderCapacityQty()) && !(getOrderCapacityQty()==msg.getOrderCapacityQty())) return false;
		return true;
	}
	public FixCpctyConfGrp clone ( FixCpctyConfGrp out ) {
		if ( hasOrderCapacity())
			out.setOrderCapacity(getOrderCapacity());
		if ( hasOrderRestrictions())
			out.setOrderRestrictions(getOrderRestrictions());
		if ( hasOrderCapacityQty())
			out.setOrderCapacityQty(getOrderCapacityQty());
		return out;
	}

}
