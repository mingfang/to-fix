package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixPosUndInstrmtGrp extends FixGroup {
	private short hasUnderlyingSettlPrice;
	long underlyingSettlPrice = 0;		
	private short hasUnderlyingSettlPriceType;
	long underlyingSettlPriceType = 0;		
	private short hasUnderlyingDeliveryAmount;
	long underlyingDeliveryAmount = 0;		
		public FixUnderlyingInstrument underlyingInstrument;
		public FixUnderlyingAmount[] underlyingAmount;
	
	public FixPosUndInstrmtGrp() {
		this(false);
	}

	public FixPosUndInstrmtGrp(boolean isRequired) {
		super(FixTags.UNDERLYINGSYMBOL_INT);

		this.isRequired = isRequired;
		
		hasUnderlyingSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingSettlPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingDeliveryAmount = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingInstrument = new FixUnderlyingInstrument();
		underlyingAmount = new FixUnderlyingAmount[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) underlyingAmount[i] = new FixUnderlyingAmount();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (underlyingInstrument.hasGroup()) return true;
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
            	case FixTags.UNDERLYINGSETTLPRICE_INT:		
            		hasUnderlyingSettlPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSETTLPRICETYPE_INT:		
            		hasUnderlyingSettlPriceType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGDELIVERYAMOUNT_INT:		
            		hasUnderlyingDeliveryAmount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( underlyingInstrument.isKeyTag(tag)) {
        				tag = underlyingInstrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOUNDERLYINGAMOUNTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !underlyingAmount[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = underlyingAmount[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
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
		hasUnderlyingSettlPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSettlPriceType = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingDeliveryAmount = FixUtils.TAG_HAS_NO_VALUE;
		underlyingInstrument.clear();
		for (FixUnderlyingAmount fixUnderlyingAmount : underlyingAmount) fixUnderlyingAmount.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasUnderlyingSettlPrice()) {		
			out.put(FixTags.UNDERLYINGSETTLPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingSettlPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSettlPriceType()) {		
			out.put(FixTags.UNDERLYINGSETTLPRICETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingSettlPriceType);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingDeliveryAmount()) {		
			out.put(FixTags.UNDERLYINGDELIVERYAMOUNT);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingDeliveryAmount);
		
			out.put(FixUtils.SOH);

            }

		underlyingInstrument.encode(out);
		if (FixUtils.getNoInGroup(underlyingAmount)>0) {
			out.put(FixTags.NOUNDERLYINGAMOUNTS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(underlyingAmount));

			out.put(FixUtils.SOH);

		}
		for (FixUnderlyingAmount fixUnderlyingAmount : underlyingAmount) if (fixUnderlyingAmount.hasGroup()) fixUnderlyingAmount.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasUnderlyingSettlPrice()) {		
			FixUtils.put(out, (long)underlyingSettlPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSettlPriceType()) {		
			FixUtils.put(out, (long)underlyingSettlPriceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingDeliveryAmount()) {		
			FixUtils.put(out, (long)underlyingDeliveryAmount);
		
	        out.put( (byte)' ' );		
		}		
		
		underlyingInstrument.printBuffer(out);
		for (FixUnderlyingAmount fixUnderlyingAmount : underlyingAmount) fixUnderlyingAmount.printBuffer(out);
	}

	public long getUnderlyingSettlPrice() { 		
		if ( hasUnderlyingSettlPrice()) {		
			if (hasUnderlyingSettlPrice == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSettlPrice; 		
			} else {		
		
				buf.position(hasUnderlyingSettlPrice);		
		
			underlyingSettlPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSettlPrice);		
					return 0;		
				}		
			}		
			hasUnderlyingSettlPrice = FixUtils.TAG_HAS_VALUE;		
			return underlyingSettlPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingSettlPrice() { return hasUnderlyingSettlPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSettlPrice(long src) {		
		underlyingSettlPrice = src;
		hasUnderlyingSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingSettlPrice(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSettlPrice()) underlyingSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSettlPrice = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSettlPrice(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSettlPrice()) underlyingSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingSettlPrice = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingSettlPriceType() { 		
		if ( hasUnderlyingSettlPriceType()) {		
			if (hasUnderlyingSettlPriceType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSettlPriceType; 		
			} else {		
		
				buf.position(hasUnderlyingSettlPriceType);		
		
			underlyingSettlPriceType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSettlPriceType);		
					return 0;		
				}		
			}		
			hasUnderlyingSettlPriceType = FixUtils.TAG_HAS_VALUE;		
			return underlyingSettlPriceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingSettlPriceType() { return hasUnderlyingSettlPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSettlPriceType(long src) {		
		underlyingSettlPriceType = src;
		hasUnderlyingSettlPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingSettlPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSettlPriceType()) underlyingSettlPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSettlPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingSettlPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSettlPriceType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSettlPriceType()) underlyingSettlPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingSettlPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingSettlPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingDeliveryAmount() { 		
		if ( hasUnderlyingDeliveryAmount()) {		
			if (hasUnderlyingDeliveryAmount == FixUtils.TAG_HAS_VALUE) {		
				return underlyingDeliveryAmount; 		
			} else {		
		
				buf.position(hasUnderlyingDeliveryAmount);		
		
			underlyingDeliveryAmount = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingDeliveryAmount);		
					return 0;		
				}		
			}		
			hasUnderlyingDeliveryAmount = FixUtils.TAG_HAS_VALUE;		
			return underlyingDeliveryAmount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingDeliveryAmount() { return hasUnderlyingDeliveryAmount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingDeliveryAmount(long src) {		
		underlyingDeliveryAmount = src;
		hasUnderlyingDeliveryAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingDeliveryAmount(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingDeliveryAmount()) underlyingDeliveryAmount = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingDeliveryAmount = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingDeliveryAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingDeliveryAmount(String str) {		
		if (str == null ) return;
		if (hasUnderlyingDeliveryAmount()) underlyingDeliveryAmount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingDeliveryAmount = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingDeliveryAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasUnderlyingSettlPrice()) s += "UnderlyingSettlPrice(732)= " + getUnderlyingSettlPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingSettlPriceType()) s += "UnderlyingSettlPriceType(733)= " + getUnderlyingSettlPriceType() + "\n" ; 
		if (hasUnderlyingDeliveryAmount()) s += "UnderlyingDeliveryAmount(1037)= " + getUnderlyingDeliveryAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

		s += underlyingInstrument.toString();
		for (FixUnderlyingAmount fixUnderlyingAmount : underlyingAmount) fixUnderlyingAmount.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPosUndInstrmtGrp)) return false;

		FixPosUndInstrmtGrp msg = (FixPosUndInstrmtGrp) o;

		if (!underlyingInstrument.equals(msg.underlyingInstrument)) return false;
		for (int i = 0; i < underlyingAmount.length; i++)
			if (!underlyingAmount[i].equals(msg.underlyingAmount[i])) return false;
		if ((hasUnderlyingSettlPrice() && !msg.hasUnderlyingSettlPrice()) || (!hasUnderlyingSettlPrice() && msg.hasUnderlyingSettlPrice())) return false;
		if (!(!hasUnderlyingSettlPrice() && !msg.hasUnderlyingSettlPrice()) && !(getUnderlyingSettlPrice()==msg.getUnderlyingSettlPrice())) return false;
		if ((hasUnderlyingSettlPriceType() && !msg.hasUnderlyingSettlPriceType()) || (!hasUnderlyingSettlPriceType() && msg.hasUnderlyingSettlPriceType())) return false;
		if (!(!hasUnderlyingSettlPriceType() && !msg.hasUnderlyingSettlPriceType()) && !(getUnderlyingSettlPriceType()==msg.getUnderlyingSettlPriceType())) return false;
		if ((hasUnderlyingDeliveryAmount() && !msg.hasUnderlyingDeliveryAmount()) || (!hasUnderlyingDeliveryAmount() && msg.hasUnderlyingDeliveryAmount())) return false;
		if (!(!hasUnderlyingDeliveryAmount() && !msg.hasUnderlyingDeliveryAmount()) && !(getUnderlyingDeliveryAmount()==msg.getUnderlyingDeliveryAmount())) return false;
		return true;
	}
	public FixPosUndInstrmtGrp clone ( FixPosUndInstrmtGrp out ) {
		if ( hasUnderlyingSettlPrice())
			out.setUnderlyingSettlPrice(getUnderlyingSettlPrice());
		if ( hasUnderlyingSettlPriceType())
			out.setUnderlyingSettlPriceType(getUnderlyingSettlPriceType());
		if ( hasUnderlyingDeliveryAmount())
			out.setUnderlyingDeliveryAmount(getUnderlyingDeliveryAmount());
		if (underlyingInstrument.hasGroup())
			out.underlyingInstrument = underlyingInstrument.clone( out.underlyingInstrument);
		int count = 0;
		count = 0;
		for (FixUnderlyingAmount fixUnderlyingAmount : underlyingAmount) {
			if (!fixUnderlyingAmount.hasGroup()) continue;
			out.underlyingAmount[count] = fixUnderlyingAmount.clone( out.underlyingAmount[count] );
			count++;
		}
		return out;
	}

}
