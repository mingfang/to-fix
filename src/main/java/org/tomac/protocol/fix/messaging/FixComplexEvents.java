package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixComplexEvents extends FixGroup {
	private short hasComplexEventType;
	long complexEventType = 0;		
	private short hasComplexOptPayoutAmount;
	long complexOptPayoutAmount = 0;		
	private short hasComplexEventPrice;
	long complexEventPrice = 0;		
	private short hasComplexEventPriceBoundaryMethod;
	long complexEventPriceBoundaryMethod = 0;		
	private short hasComplexEventPriceBoundaryPrecision;
	long complexEventPriceBoundaryPrecision = 0;		
	private short hasComplexEventPriceTimeType;
	long complexEventPriceTimeType = 0;		
	private short hasComplexEventCondition;
	long complexEventCondition = 0;		
		public FixComplexEventDates[] complexEventDates;
	
	public FixComplexEvents() {
		this(false);
	}

	public FixComplexEvents(boolean isRequired) {
		super(FixTags.COMPLEXEVENTTYPE_INT);

		this.isRequired = isRequired;
		
		hasComplexEventType = FixUtils.TAG_HAS_NO_VALUE;		
		hasComplexOptPayoutAmount = FixUtils.TAG_HAS_NO_VALUE;		
		hasComplexEventPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasComplexEventPriceBoundaryMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasComplexEventPriceBoundaryPrecision = FixUtils.TAG_HAS_NO_VALUE;		
		hasComplexEventPriceTimeType = FixUtils.TAG_HAS_NO_VALUE;		
		hasComplexEventCondition = FixUtils.TAG_HAS_NO_VALUE;		
		complexEventDates = new FixComplexEventDates[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) complexEventDates[i] = new FixComplexEventDates();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasComplexEventType()) return true;
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
            	case FixTags.COMPLEXEVENTTYPE_INT:		
            		hasComplexEventType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.COMPLEXOPTPAYOUTAMOUNT_INT:		
            		hasComplexOptPayoutAmount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.COMPLEXEVENTPRICE_INT:		
            		hasComplexEventPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.COMPLEXEVENTPRICEBOUNDARYMETHOD_INT:		
            		hasComplexEventPriceBoundaryMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.COMPLEXEVENTPRICEBOUNDARYPRECISION_INT:		
            		hasComplexEventPriceBoundaryPrecision = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.COMPLEXEVENTPRICETIMETYPE_INT:		
            		hasComplexEventPriceTimeType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.COMPLEXEVENTCONDITION_INT:		
            		hasComplexEventCondition = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOCOMPLEXEVENTDATES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !complexEventDates[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = complexEventDates[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasComplexEventType = FixUtils.TAG_HAS_NO_VALUE;
		hasComplexOptPayoutAmount = FixUtils.TAG_HAS_NO_VALUE;
		hasComplexEventPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasComplexEventPriceBoundaryMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasComplexEventPriceBoundaryPrecision = FixUtils.TAG_HAS_NO_VALUE;
		hasComplexEventPriceTimeType = FixUtils.TAG_HAS_NO_VALUE;
		hasComplexEventCondition = FixUtils.TAG_HAS_NO_VALUE;
		for (FixComplexEventDates fixComplexEventDates : complexEventDates) fixComplexEventDates.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasComplexEventType()) {		
			out.put(FixTags.COMPLEXEVENTTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)complexEventType);
		
			out.put(FixUtils.SOH);

            }

		if (hasComplexOptPayoutAmount()) {		
			out.put(FixTags.COMPLEXOPTPAYOUTAMOUNT);

			out.put((byte) '=');

			FixUtils.put(out, (long)complexOptPayoutAmount);
		
			out.put(FixUtils.SOH);

            }

		if (hasComplexEventPrice()) {		
			out.put(FixTags.COMPLEXEVENTPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)complexEventPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasComplexEventPriceBoundaryMethod()) {		
			out.put(FixTags.COMPLEXEVENTPRICEBOUNDARYMETHOD);

			out.put((byte) '=');

			FixUtils.put(out, (long)complexEventPriceBoundaryMethod);
		
			out.put(FixUtils.SOH);

            }

		if (hasComplexEventPriceBoundaryPrecision()) {		
			out.put(FixTags.COMPLEXEVENTPRICEBOUNDARYPRECISION);

			out.put((byte) '=');

			FixUtils.put(out, (long)complexEventPriceBoundaryPrecision);
		
			out.put(FixUtils.SOH);

            }

		if (hasComplexEventPriceTimeType()) {		
			out.put(FixTags.COMPLEXEVENTPRICETIMETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)complexEventPriceTimeType);
		
			out.put(FixUtils.SOH);

            }

		if (hasComplexEventCondition()) {		
			out.put(FixTags.COMPLEXEVENTCONDITION);

			out.put((byte) '=');

			FixUtils.put(out, (long)complexEventCondition);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(complexEventDates)>0) {
			out.put(FixTags.NOCOMPLEXEVENTDATES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(complexEventDates));

			out.put(FixUtils.SOH);

		}
		for (FixComplexEventDates fixComplexEventDates : complexEventDates) if (fixComplexEventDates.hasGroup()) fixComplexEventDates.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasComplexEventType()) {		
			FixUtils.put(out, (long)complexEventType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasComplexOptPayoutAmount()) {		
			FixUtils.put(out, (long)complexOptPayoutAmount);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasComplexEventPrice()) {		
			FixUtils.put(out, (long)complexEventPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasComplexEventPriceBoundaryMethod()) {		
			FixUtils.put(out, (long)complexEventPriceBoundaryMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasComplexEventPriceBoundaryPrecision()) {		
			FixUtils.put(out, (long)complexEventPriceBoundaryPrecision);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasComplexEventPriceTimeType()) {		
			FixUtils.put(out, (long)complexEventPriceTimeType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasComplexEventCondition()) {		
			FixUtils.put(out, (long)complexEventCondition);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixComplexEventDates fixComplexEventDates : complexEventDates) fixComplexEventDates.printBuffer(out);
	}

	public long getComplexEventType() { 		
		if ( hasComplexEventType()) {		
			if (hasComplexEventType == FixUtils.TAG_HAS_VALUE) {		
				return complexEventType; 		
			} else {		
		
				buf.position(hasComplexEventType);		
		
			complexEventType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasComplexEventType);		
					return 0;		
				}		
			}		
			hasComplexEventType = FixUtils.TAG_HAS_VALUE;		
			return complexEventType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasComplexEventType() { return hasComplexEventType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setComplexEventType(long src) {		
		complexEventType = src;
		hasComplexEventType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setComplexEventType(byte[] src) {		
		if (src == null ) return;
		if (hasComplexEventType()) complexEventType = FixUtils.TAG_HAS_NO_VALUE;		
		complexEventType = FixUtils.longValueOf(src, 0, src.length);
		hasComplexEventType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setComplexEventType(String str) {		
		if (str == null ) return;
		if (hasComplexEventType()) complexEventType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		complexEventType = FixUtils.longValueOf(src, 0, src.length);
		hasComplexEventType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getComplexOptPayoutAmount() { 		
		if ( hasComplexOptPayoutAmount()) {		
			if (hasComplexOptPayoutAmount == FixUtils.TAG_HAS_VALUE) {		
				return complexOptPayoutAmount; 		
			} else {		
		
				buf.position(hasComplexOptPayoutAmount);		
		
			complexOptPayoutAmount = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasComplexOptPayoutAmount);		
					return 0;		
				}		
			}		
			hasComplexOptPayoutAmount = FixUtils.TAG_HAS_VALUE;		
			return complexOptPayoutAmount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasComplexOptPayoutAmount() { return hasComplexOptPayoutAmount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setComplexOptPayoutAmount(long src) {		
		complexOptPayoutAmount = src;
		hasComplexOptPayoutAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setComplexOptPayoutAmount(byte[] src) {		
		if (src == null ) return;
		if (hasComplexOptPayoutAmount()) complexOptPayoutAmount = FixUtils.TAG_HAS_NO_VALUE;		
		complexOptPayoutAmount = FixUtils.longValueOf(src, 0, src.length);
		hasComplexOptPayoutAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setComplexOptPayoutAmount(String str) {		
		if (str == null ) return;
		if (hasComplexOptPayoutAmount()) complexOptPayoutAmount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		complexOptPayoutAmount = FixUtils.longValueOf(src, 0, src.length);
		hasComplexOptPayoutAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getComplexEventPrice() { 		
		if ( hasComplexEventPrice()) {		
			if (hasComplexEventPrice == FixUtils.TAG_HAS_VALUE) {		
				return complexEventPrice; 		
			} else {		
		
				buf.position(hasComplexEventPrice);		
		
			complexEventPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasComplexEventPrice);		
					return 0;		
				}		
			}		
			hasComplexEventPrice = FixUtils.TAG_HAS_VALUE;		
			return complexEventPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasComplexEventPrice() { return hasComplexEventPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setComplexEventPrice(long src) {		
		complexEventPrice = src;
		hasComplexEventPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setComplexEventPrice(byte[] src) {		
		if (src == null ) return;
		if (hasComplexEventPrice()) complexEventPrice = FixUtils.TAG_HAS_NO_VALUE;		
		complexEventPrice = FixUtils.longValueOf(src, 0, src.length);
		hasComplexEventPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setComplexEventPrice(String str) {		
		if (str == null ) return;
		if (hasComplexEventPrice()) complexEventPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		complexEventPrice = FixUtils.longValueOf(src, 0, src.length);
		hasComplexEventPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getComplexEventPriceBoundaryMethod() { 		
		if ( hasComplexEventPriceBoundaryMethod()) {		
			if (hasComplexEventPriceBoundaryMethod == FixUtils.TAG_HAS_VALUE) {		
				return complexEventPriceBoundaryMethod; 		
			} else {		
		
				buf.position(hasComplexEventPriceBoundaryMethod);		
		
			complexEventPriceBoundaryMethod = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasComplexEventPriceBoundaryMethod);		
					return 0;		
				}		
			}		
			hasComplexEventPriceBoundaryMethod = FixUtils.TAG_HAS_VALUE;		
			return complexEventPriceBoundaryMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasComplexEventPriceBoundaryMethod() { return hasComplexEventPriceBoundaryMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setComplexEventPriceBoundaryMethod(long src) {		
		complexEventPriceBoundaryMethod = src;
		hasComplexEventPriceBoundaryMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setComplexEventPriceBoundaryMethod(byte[] src) {		
		if (src == null ) return;
		if (hasComplexEventPriceBoundaryMethod()) complexEventPriceBoundaryMethod = FixUtils.TAG_HAS_NO_VALUE;		
		complexEventPriceBoundaryMethod = FixUtils.longValueOf(src, 0, src.length);
		hasComplexEventPriceBoundaryMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setComplexEventPriceBoundaryMethod(String str) {		
		if (str == null ) return;
		if (hasComplexEventPriceBoundaryMethod()) complexEventPriceBoundaryMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		complexEventPriceBoundaryMethod = FixUtils.longValueOf(src, 0, src.length);
		hasComplexEventPriceBoundaryMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getComplexEventPriceBoundaryPrecision() { 		
		if ( hasComplexEventPriceBoundaryPrecision()) {		
			if (hasComplexEventPriceBoundaryPrecision == FixUtils.TAG_HAS_VALUE) {		
				return complexEventPriceBoundaryPrecision; 		
			} else {		
		
				buf.position(hasComplexEventPriceBoundaryPrecision);		
		
			complexEventPriceBoundaryPrecision = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasComplexEventPriceBoundaryPrecision);		
					return 0;		
				}		
			}		
			hasComplexEventPriceBoundaryPrecision = FixUtils.TAG_HAS_VALUE;		
			return complexEventPriceBoundaryPrecision;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasComplexEventPriceBoundaryPrecision() { return hasComplexEventPriceBoundaryPrecision != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setComplexEventPriceBoundaryPrecision(long src) {		
		complexEventPriceBoundaryPrecision = src;
		hasComplexEventPriceBoundaryPrecision = FixUtils.TAG_HAS_VALUE;		
	}

	public void setComplexEventPriceBoundaryPrecision(byte[] src) {		
		if (src == null ) return;
		if (hasComplexEventPriceBoundaryPrecision()) complexEventPriceBoundaryPrecision = FixUtils.TAG_HAS_NO_VALUE;		
		complexEventPriceBoundaryPrecision = FixUtils.longValueOf(src, 0, src.length);
		hasComplexEventPriceBoundaryPrecision = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setComplexEventPriceBoundaryPrecision(String str) {		
		if (str == null ) return;
		if (hasComplexEventPriceBoundaryPrecision()) complexEventPriceBoundaryPrecision = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		complexEventPriceBoundaryPrecision = FixUtils.longValueOf(src, 0, src.length);
		hasComplexEventPriceBoundaryPrecision = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getComplexEventPriceTimeType() { 		
		if ( hasComplexEventPriceTimeType()) {		
			if (hasComplexEventPriceTimeType == FixUtils.TAG_HAS_VALUE) {		
				return complexEventPriceTimeType; 		
			} else {		
		
				buf.position(hasComplexEventPriceTimeType);		
		
			complexEventPriceTimeType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasComplexEventPriceTimeType);		
					return 0;		
				}		
			}		
			hasComplexEventPriceTimeType = FixUtils.TAG_HAS_VALUE;		
			return complexEventPriceTimeType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasComplexEventPriceTimeType() { return hasComplexEventPriceTimeType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setComplexEventPriceTimeType(long src) {		
		complexEventPriceTimeType = src;
		hasComplexEventPriceTimeType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setComplexEventPriceTimeType(byte[] src) {		
		if (src == null ) return;
		if (hasComplexEventPriceTimeType()) complexEventPriceTimeType = FixUtils.TAG_HAS_NO_VALUE;		
		complexEventPriceTimeType = FixUtils.longValueOf(src, 0, src.length);
		hasComplexEventPriceTimeType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setComplexEventPriceTimeType(String str) {		
		if (str == null ) return;
		if (hasComplexEventPriceTimeType()) complexEventPriceTimeType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		complexEventPriceTimeType = FixUtils.longValueOf(src, 0, src.length);
		hasComplexEventPriceTimeType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getComplexEventCondition() { 		
		if ( hasComplexEventCondition()) {		
			if (hasComplexEventCondition == FixUtils.TAG_HAS_VALUE) {		
				return complexEventCondition; 		
			} else {		
		
				buf.position(hasComplexEventCondition);		
		
			complexEventCondition = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasComplexEventCondition);		
					return 0;		
				}		
			}		
			hasComplexEventCondition = FixUtils.TAG_HAS_VALUE;		
			return complexEventCondition;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasComplexEventCondition() { return hasComplexEventCondition != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setComplexEventCondition(long src) {		
		complexEventCondition = src;
		hasComplexEventCondition = FixUtils.TAG_HAS_VALUE;		
	}

	public void setComplexEventCondition(byte[] src) {		
		if (src == null ) return;
		if (hasComplexEventCondition()) complexEventCondition = FixUtils.TAG_HAS_NO_VALUE;		
		complexEventCondition = FixUtils.longValueOf(src, 0, src.length);
		hasComplexEventCondition = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setComplexEventCondition(String str) {		
		if (str == null ) return;
		if (hasComplexEventCondition()) complexEventCondition = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		complexEventCondition = FixUtils.longValueOf(src, 0, src.length);
		hasComplexEventCondition = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasComplexEventType()) s += "ComplexEventType(1484)= " + getComplexEventType() + "\n" ; 
		if (hasComplexOptPayoutAmount()) s += "ComplexOptPayoutAmount(1485)= " + getComplexOptPayoutAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasComplexEventPrice()) s += "ComplexEventPrice(1486)= " + getComplexEventPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasComplexEventPriceBoundaryMethod()) s += "ComplexEventPriceBoundaryMethod(1487)= " + getComplexEventPriceBoundaryMethod() + "\n" ; 
		if (hasComplexEventPriceBoundaryPrecision()) s += "ComplexEventPriceBoundaryPrecision(1488)= " + getComplexEventPriceBoundaryPrecision() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasComplexEventPriceTimeType()) s += "ComplexEventPriceTimeType(1489)= " + getComplexEventPriceTimeType() + "\n" ; 
		if (hasComplexEventCondition()) s += "ComplexEventCondition(1490)= " + getComplexEventCondition() + "\n" ; 

		for (FixComplexEventDates fixComplexEventDates : complexEventDates) fixComplexEventDates.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixComplexEvents)) return false;

		FixComplexEvents msg = (FixComplexEvents) o;

		for (int i = 0; i < complexEventDates.length; i++)
			if (!complexEventDates[i].equals(msg.complexEventDates[i])) return false;
		if ((hasComplexEventType() && !msg.hasComplexEventType()) || (!hasComplexEventType() && msg.hasComplexEventType())) return false;
		if (!(!hasComplexEventType() && !msg.hasComplexEventType()) && !(getComplexEventType()==msg.getComplexEventType())) return false;
		if ((hasComplexOptPayoutAmount() && !msg.hasComplexOptPayoutAmount()) || (!hasComplexOptPayoutAmount() && msg.hasComplexOptPayoutAmount())) return false;
		if (!(!hasComplexOptPayoutAmount() && !msg.hasComplexOptPayoutAmount()) && !(getComplexOptPayoutAmount()==msg.getComplexOptPayoutAmount())) return false;
		if ((hasComplexEventPrice() && !msg.hasComplexEventPrice()) || (!hasComplexEventPrice() && msg.hasComplexEventPrice())) return false;
		if (!(!hasComplexEventPrice() && !msg.hasComplexEventPrice()) && !(getComplexEventPrice()==msg.getComplexEventPrice())) return false;
		if ((hasComplexEventPriceBoundaryMethod() && !msg.hasComplexEventPriceBoundaryMethod()) || (!hasComplexEventPriceBoundaryMethod() && msg.hasComplexEventPriceBoundaryMethod())) return false;
		if (!(!hasComplexEventPriceBoundaryMethod() && !msg.hasComplexEventPriceBoundaryMethod()) && !(getComplexEventPriceBoundaryMethod()==msg.getComplexEventPriceBoundaryMethod())) return false;
		if ((hasComplexEventPriceBoundaryPrecision() && !msg.hasComplexEventPriceBoundaryPrecision()) || (!hasComplexEventPriceBoundaryPrecision() && msg.hasComplexEventPriceBoundaryPrecision())) return false;
		if (!(!hasComplexEventPriceBoundaryPrecision() && !msg.hasComplexEventPriceBoundaryPrecision()) && !(getComplexEventPriceBoundaryPrecision()==msg.getComplexEventPriceBoundaryPrecision())) return false;
		if ((hasComplexEventPriceTimeType() && !msg.hasComplexEventPriceTimeType()) || (!hasComplexEventPriceTimeType() && msg.hasComplexEventPriceTimeType())) return false;
		if (!(!hasComplexEventPriceTimeType() && !msg.hasComplexEventPriceTimeType()) && !(getComplexEventPriceTimeType()==msg.getComplexEventPriceTimeType())) return false;
		if ((hasComplexEventCondition() && !msg.hasComplexEventCondition()) || (!hasComplexEventCondition() && msg.hasComplexEventCondition())) return false;
		if (!(!hasComplexEventCondition() && !msg.hasComplexEventCondition()) && !(getComplexEventCondition()==msg.getComplexEventCondition())) return false;
		return true;
	}
	public FixComplexEvents clone ( FixComplexEvents out ) {
		if ( hasComplexEventType())
			out.setComplexEventType(getComplexEventType());
		if ( hasComplexOptPayoutAmount())
			out.setComplexOptPayoutAmount(getComplexOptPayoutAmount());
		if ( hasComplexEventPrice())
			out.setComplexEventPrice(getComplexEventPrice());
		if ( hasComplexEventPriceBoundaryMethod())
			out.setComplexEventPriceBoundaryMethod(getComplexEventPriceBoundaryMethod());
		if ( hasComplexEventPriceBoundaryPrecision())
			out.setComplexEventPriceBoundaryPrecision(getComplexEventPriceBoundaryPrecision());
		if ( hasComplexEventPriceTimeType())
			out.setComplexEventPriceTimeType(getComplexEventPriceTimeType());
		if ( hasComplexEventCondition())
			out.setComplexEventCondition(getComplexEventCondition());
		int count = 0;
		count = 0;
		for (FixComplexEventDates fixComplexEventDates : complexEventDates) {
			if (!fixComplexEventDates.hasGroup()) continue;
			out.complexEventDates[count] = fixComplexEventDates.clone( out.complexEventDates[count] );
			count++;
		}
		return out;
	}

}
