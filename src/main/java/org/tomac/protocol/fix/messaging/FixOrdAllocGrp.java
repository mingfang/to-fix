package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixOrdAllocGrp extends FixGroup {
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderID;
	byte[] orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryOrderID;
	byte[] secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryClOrdID;
	byte[] secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasListID;
	byte[] listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderQty;
	long orderQty = 0;		
	private short hasOrderAvgPx;
	long orderAvgPx = 0;		
	private short hasOrderBookingQty;
	long orderBookingQty = 0;		
		public FixNestedParties2[] nestedParties2;
	
	public FixOrdAllocGrp() {
		this(false);
	}

	public FixOrdAllocGrp(boolean isRequired) {
		super(FixTags.CLORDID_INT);

		this.isRequired = isRequired;
		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasListID = FixUtils.TAG_HAS_NO_VALUE;		
		listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderBookingQty = FixUtils.TAG_HAS_NO_VALUE;		
		nestedParties2 = new FixNestedParties2[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedParties2[i] = new FixNestedParties2();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasClOrdID()) return true;
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
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERID_INT:		
            		hasOrderID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYORDERID_INT:		
            		hasSecondaryOrderID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYCLORDID_INT:		
            		hasSecondaryClOrdID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LISTID_INT:		
            		hasListID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERQTY_INT:		
            		hasOrderQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERAVGPX_INT:		
            		hasOrderAvgPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERBOOKINGQTY_INT:		
            		hasOrderBookingQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTED2PARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !nestedParties2[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = nestedParties2[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
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
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryOrderID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasListID = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderQty = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderAvgPx = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderBookingQty = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNestedParties2 fixNestedParties2 : nestedParties2) fixNestedParties2.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);

			out.put((byte) '=');

			FixUtils.put(out,clOrdID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderID()) {		
			out.put(FixTags.ORDERID);

			out.put((byte) '=');

			FixUtils.put(out,orderID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecondaryOrderID()) {		
			out.put(FixTags.SECONDARYORDERID);

			out.put((byte) '=');

			FixUtils.put(out,secondaryOrderID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecondaryClOrdID()) {		
			out.put(FixTags.SECONDARYCLORDID);

			out.put((byte) '=');

			FixUtils.put(out,secondaryClOrdID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasListID()) {		
			out.put(FixTags.LISTID);

			out.put((byte) '=');

			FixUtils.put(out,listID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderQty()) {		
			out.put(FixTags.ORDERQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)orderQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderAvgPx()) {		
			out.put(FixTags.ORDERAVGPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)orderAvgPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderBookingQty()) {		
			out.put(FixTags.ORDERBOOKINGQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)orderBookingQty);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(nestedParties2)>0) {
			out.put(FixTags.NONESTED2PARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(nestedParties2));

			out.put(FixUtils.SOH);

		}
		for (FixNestedParties2 fixNestedParties2 : nestedParties2) if (fixNestedParties2.hasGroup()) fixNestedParties2.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderID()) {		
			FixUtils.put(out,orderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryOrderID()) {		
			FixUtils.put(out,secondaryOrderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryClOrdID()) {		
			FixUtils.put(out,secondaryClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasListID()) {		
			FixUtils.put(out,listID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderQty()) {		
			FixUtils.put(out, (long)orderQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderAvgPx()) {		
			FixUtils.put(out, (long)orderAvgPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderBookingQty()) {		
			FixUtils.put(out, (long)orderBookingQty);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNestedParties2 fixNestedParties2 : nestedParties2) fixNestedParties2.printBuffer(out);
	}

	public byte[] getClOrdID() { 		
		if ( hasClOrdID()) {		
			if (hasClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return clOrdID; 		
			} else {		
		
				buf.position(hasClOrdID);		
		
			FixUtils.getTagStringValue(buf, clOrdID, 0, clOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasClOrdID);		
					return null;		
				}		
			}		
			hasClOrdID = FixUtils.TAG_HAS_VALUE;		
			return clOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClOrdID() { return hasClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasClOrdID()) FixUtils.fillNul(clOrdID);		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setClOrdID(String str) {		
		if (str == null ) return;
		if (hasClOrdID()) FixUtils.fillNul(clOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOrderID() { 		
		if ( hasOrderID()) {		
			if (hasOrderID == FixUtils.TAG_HAS_VALUE) {		
				return orderID; 		
			} else {		
		
				buf.position(hasOrderID);		
		
			FixUtils.getTagStringValue(buf, orderID, 0, orderID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderID);		
					return null;		
				}		
			}		
			hasOrderID = FixUtils.TAG_HAS_VALUE;		
			return orderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderID() { return hasOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasOrderID()) FixUtils.fillNul(orderID);		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderID(String str) {		
		if (str == null ) return;
		if (hasOrderID()) FixUtils.fillNul(orderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecondaryOrderID() { 		
		if ( hasSecondaryOrderID()) {		
			if (hasSecondaryOrderID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryOrderID; 		
			} else {		
		
				buf.position(hasSecondaryOrderID);		
		
			FixUtils.getTagStringValue(buf, secondaryOrderID, 0, secondaryOrderID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryOrderID);		
					return null;		
				}		
			}		
			hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
			return secondaryOrderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryOrderID() { return hasSecondaryOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecondaryOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryOrderID()) FixUtils.fillNul(secondaryOrderID);		
		FixUtils.copy(secondaryOrderID, src); 		
		hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryOrderID(String str) {		
		if (str == null ) return;
		if (hasSecondaryOrderID()) FixUtils.fillNul(secondaryOrderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryOrderID, src); 		
		hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecondaryClOrdID() { 		
		if ( hasSecondaryClOrdID()) {		
			if (hasSecondaryClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryClOrdID; 		
			} else {		
		
				buf.position(hasSecondaryClOrdID);		
		
			FixUtils.getTagStringValue(buf, secondaryClOrdID, 0, secondaryClOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryClOrdID);		
					return null;		
				}		
			}		
			hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
			return secondaryClOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryClOrdID() { return hasSecondaryClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecondaryClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryClOrdID()) FixUtils.fillNul(secondaryClOrdID);		
		FixUtils.copy(secondaryClOrdID, src); 		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryClOrdID(String str) {		
		if (str == null ) return;
		if (hasSecondaryClOrdID()) FixUtils.fillNul(secondaryClOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryClOrdID, src); 		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getListID() { 		
		if ( hasListID()) {		
			if (hasListID == FixUtils.TAG_HAS_VALUE) {		
				return listID; 		
			} else {		
		
				buf.position(hasListID);		
		
			FixUtils.getTagStringValue(buf, listID, 0, listID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasListID);		
					return null;		
				}		
			}		
			hasListID = FixUtils.TAG_HAS_VALUE;		
			return listID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasListID() { return hasListID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setListID(byte[] src) {		
		if (src == null ) return;
		if (hasListID()) FixUtils.fillNul(listID);		
		FixUtils.copy(listID, src); 		
		hasListID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setListID(String str) {		
		if (str == null ) return;
		if (hasListID()) FixUtils.fillNul(listID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(listID, src); 		
		hasListID = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getOrderAvgPx() { 		
		if ( hasOrderAvgPx()) {		
			if (hasOrderAvgPx == FixUtils.TAG_HAS_VALUE) {		
				return orderAvgPx; 		
			} else {		
		
				buf.position(hasOrderAvgPx);		
		
			orderAvgPx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderAvgPx);		
					return 0;		
				}		
			}		
			hasOrderAvgPx = FixUtils.TAG_HAS_VALUE;		
			return orderAvgPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrderAvgPx() { return hasOrderAvgPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderAvgPx(long src) {		
		orderAvgPx = src;
		hasOrderAvgPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderAvgPx(byte[] src) {		
		if (src == null ) return;
		if (hasOrderAvgPx()) orderAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		orderAvgPx = FixUtils.longValueOf(src, 0, src.length);
		hasOrderAvgPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderAvgPx(String str) {		
		if (str == null ) return;
		if (hasOrderAvgPx()) orderAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		orderAvgPx = FixUtils.longValueOf(src, 0, src.length);
		hasOrderAvgPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOrderBookingQty() { 		
		if ( hasOrderBookingQty()) {		
			if (hasOrderBookingQty == FixUtils.TAG_HAS_VALUE) {		
				return orderBookingQty; 		
			} else {		
		
				buf.position(hasOrderBookingQty);		
		
			orderBookingQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderBookingQty);		
					return 0;		
				}		
			}		
			hasOrderBookingQty = FixUtils.TAG_HAS_VALUE;		
			return orderBookingQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrderBookingQty() { return hasOrderBookingQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderBookingQty(long src) {		
		orderBookingQty = src;
		hasOrderBookingQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderBookingQty(byte[] src) {		
		if (src == null ) return;
		if (hasOrderBookingQty()) orderBookingQty = FixUtils.TAG_HAS_NO_VALUE;		
		orderBookingQty = FixUtils.longValueOf(src, 0, src.length);
		hasOrderBookingQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderBookingQty(String str) {		
		if (str == null ) return;
		if (hasOrderBookingQty()) orderBookingQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		orderBookingQty = FixUtils.longValueOf(src, 0, src.length);
		hasOrderBookingQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasOrderID()) s += "OrderID(37)= " + new String( FixUtils.trim(getOrderID()) ) + "\n" ; 
		if (hasSecondaryOrderID()) s += "SecondaryOrderID(198)= " + new String( FixUtils.trim(getSecondaryOrderID()) ) + "\n" ; 
		if (hasSecondaryClOrdID()) s += "SecondaryClOrdID(526)= " + new String( FixUtils.trim(getSecondaryClOrdID()) ) + "\n" ; 
		if (hasListID()) s += "ListID(66)= " + new String( FixUtils.trim(getListID()) ) + "\n" ; 
		if (hasOrderQty()) s += "OrderQty(38)= " + getOrderQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOrderAvgPx()) s += "OrderAvgPx(799)= " + getOrderAvgPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOrderBookingQty()) s += "OrderBookingQty(800)= " + getOrderBookingQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

		for (FixNestedParties2 fixNestedParties2 : nestedParties2) fixNestedParties2.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixOrdAllocGrp)) return false;

		FixOrdAllocGrp msg = (FixOrdAllocGrp) o;

		for (int i = 0; i < nestedParties2.length; i++)
			if (!nestedParties2[i].equals(msg.nestedParties2[i])) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasSecondaryOrderID() && !msg.hasSecondaryOrderID()) || (!hasSecondaryOrderID() && msg.hasSecondaryOrderID())) return false;
		if (!(!hasSecondaryOrderID() && !msg.hasSecondaryOrderID()) && !FixUtils.equals(getSecondaryOrderID(), msg.getSecondaryOrderID())) return false;
		if ((hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) || (!hasSecondaryClOrdID() && msg.hasSecondaryClOrdID())) return false;
		if (!(!hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) && !FixUtils.equals(getSecondaryClOrdID(), msg.getSecondaryClOrdID())) return false;
		if ((hasListID() && !msg.hasListID()) || (!hasListID() && msg.hasListID())) return false;
		if (!(!hasListID() && !msg.hasListID()) && !FixUtils.equals(getListID(), msg.getListID())) return false;
		if ((hasOrderQty() && !msg.hasOrderQty()) || (!hasOrderQty() && msg.hasOrderQty())) return false;
		if (!(!hasOrderQty() && !msg.hasOrderQty()) && !(getOrderQty()==msg.getOrderQty())) return false;
		if ((hasOrderAvgPx() && !msg.hasOrderAvgPx()) || (!hasOrderAvgPx() && msg.hasOrderAvgPx())) return false;
		if (!(!hasOrderAvgPx() && !msg.hasOrderAvgPx()) && !(getOrderAvgPx()==msg.getOrderAvgPx())) return false;
		if ((hasOrderBookingQty() && !msg.hasOrderBookingQty()) || (!hasOrderBookingQty() && msg.hasOrderBookingQty())) return false;
		if (!(!hasOrderBookingQty() && !msg.hasOrderBookingQty()) && !(getOrderBookingQty()==msg.getOrderBookingQty())) return false;
		return true;
	}
	public FixOrdAllocGrp clone ( FixOrdAllocGrp out ) {
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasSecondaryOrderID())
			out.setSecondaryOrderID(getSecondaryOrderID());
		if ( hasSecondaryClOrdID())
			out.setSecondaryClOrdID(getSecondaryClOrdID());
		if ( hasListID())
			out.setListID(getListID());
		if ( hasOrderQty())
			out.setOrderQty(getOrderQty());
		if ( hasOrderAvgPx())
			out.setOrderAvgPx(getOrderAvgPx());
		if ( hasOrderBookingQty())
			out.setOrderBookingQty(getOrderBookingQty());
		int count = 0;
		count = 0;
		for (FixNestedParties2 fixNestedParties2 : nestedParties2) {
			if (!fixNestedParties2.hasGroup()) continue;
			out.nestedParties2[count] = fixNestedParties2.clone( out.nestedParties2[count] );
			count++;
		}
		return out;
	}

}
