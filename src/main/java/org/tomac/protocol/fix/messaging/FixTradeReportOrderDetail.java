package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTradeReportOrderDetail extends FixGroup {
	private short hasOrderID;
	byte[] orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryOrderID;
	byte[] secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryClOrdID;
	byte[] secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasListID;
	byte[] listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRefOrderID;
	byte[] refOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRefOrderIDSource;
	byte refOrderIDSource = (byte)' ';		
	private short hasRefOrdIDReason;
	long refOrdIDReason = 0;		
	private short hasOrdType;
	byte ordType = (byte)' ';		
	private short hasPrice;
	long price = 0;		
	private short hasStopPx;
	long stopPx = 0;		
	private short hasExecInst;
	byte[] execInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrdStatus;
	byte ordStatus = (byte)' ';		
	private short hasLeavesQty;
	long leavesQty = 0;		
	private short hasCumQty;
	long cumQty = 0;		
	private short hasTimeInForce;
	byte timeInForce = (byte)' ';		
	private short hasExpireTime;
	byte[] expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasOrderCapacity;
	byte orderCapacity = (byte)' ';		
	private short hasOrderRestrictions;
	byte[] orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasBookingType;
	long bookingType = 0;		
	private short hasOrigCustOrderCapacity;
	long origCustOrderCapacity = 0;		
	private short hasOrderInputDevice;
	byte[] orderInputDevice = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLotType;
	byte lotType = (byte)' ';		
	private short hasTransBkdTime;
	byte[] transBkdTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasOrigOrdModTime;
	byte[] origOrdModTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		public FixOrderQtyData orderQtyData;
		public FixDisplayInstruction displayInstruction;
	
	public FixTradeReportOrderDetail() {
		this(false);
	}

	public FixTradeReportOrderDetail(boolean isRequired) {
		super(FixTags.ORDERID_INT);

		this.isRequired = isRequired;
		
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasListID = FixUtils.TAG_HAS_NO_VALUE;		
		listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRefOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		refOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRefOrderIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasRefOrdIDReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasStopPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasExecInst = FixUtils.TAG_HAS_NO_VALUE;		
		execInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrdStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasLeavesQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasCumQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasTimeInForce = FixUtils.TAG_HAS_NO_VALUE;		
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;		
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderRestrictions = FixUtils.TAG_HAS_NO_VALUE;		
		orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasBookingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrigCustOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderInputDevice = FixUtils.TAG_HAS_NO_VALUE;		
		orderInputDevice = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLotType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransBkdTime = FixUtils.TAG_HAS_NO_VALUE;		
		transBkdTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasOrigOrdModTime = FixUtils.TAG_HAS_NO_VALUE;		
		origOrdModTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		orderQtyData = new FixOrderQtyData();
		displayInstruction = new FixDisplayInstruction();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasOrderID()) return true;
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
            	case FixTags.ORDERID_INT:		
            		hasOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYORDERID_INT:		
            		hasSecondaryOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYCLORDID_INT:		
            		hasSecondaryClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LISTID_INT:		
            		hasListID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.REFORDERID_INT:		
            		hasRefOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.REFORDERIDSOURCE_INT:		
            		hasRefOrderIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.REFORDIDREASON_INT:		
            		hasRefOrdIDReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDTYPE_INT:		
            		hasOrdType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PRICE_INT:		
            		hasPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STOPPX_INT:		
            		hasStopPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.EXECINST_INT:		
            		hasExecInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDSTATUS_INT:		
            		hasOrdStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEAVESQTY_INT:		
            		hasLeavesQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CUMQTY_INT:		
            		hasCumQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TIMEINFORCE_INT:		
            		hasTimeInForce = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.EXPIRETIME_INT:		
            		hasExpireTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERCAPACITY_INT:		
            		hasOrderCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERRESTRICTIONS_INT:		
            		hasOrderRestrictions = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.BOOKINGTYPE_INT:		
            		hasBookingType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORIGCUSTORDERCAPACITY_INT:		
            		hasOrigCustOrderCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERINPUTDEVICE_INT:		
            		hasOrderInputDevice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LOTTYPE_INT:		
            		hasLotType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRANSBKDTIME_INT:		
            		hasTransBkdTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORIGORDMODTIME_INT:		
            		hasOrigOrdModTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( orderQtyData.isKeyTag(tag)) {
        				tag = orderQtyData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( displayInstruction.isKeyTag(tag)) {
        				tag = displayInstruction.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
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
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryOrderID = FixUtils.TAG_HAS_NO_VALUE;
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasListID = FixUtils.TAG_HAS_NO_VALUE;
		hasRefOrderID = FixUtils.TAG_HAS_NO_VALUE;
		hasRefOrderIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasRefOrdIDReason = FixUtils.TAG_HAS_NO_VALUE;
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;
		hasPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasStopPx = FixUtils.TAG_HAS_NO_VALUE;
		hasExecInst = FixUtils.TAG_HAS_NO_VALUE;
		hasOrdStatus = FixUtils.TAG_HAS_NO_VALUE;
		hasLeavesQty = FixUtils.TAG_HAS_NO_VALUE;
		hasCumQty = FixUtils.TAG_HAS_NO_VALUE;
		hasTimeInForce = FixUtils.TAG_HAS_NO_VALUE;
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderRestrictions = FixUtils.TAG_HAS_NO_VALUE;
		hasBookingType = FixUtils.TAG_HAS_NO_VALUE;
		hasOrigCustOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderInputDevice = FixUtils.TAG_HAS_NO_VALUE;
		hasLotType = FixUtils.TAG_HAS_NO_VALUE;
		hasTransBkdTime = FixUtils.TAG_HAS_NO_VALUE;
		hasOrigOrdModTime = FixUtils.TAG_HAS_NO_VALUE;
		orderQtyData.clear();
		displayInstruction.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

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

		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);

			out.put((byte) '=');

			FixUtils.put(out,clOrdID); 		
		
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

		if (hasRefOrderID()) {		
			out.put(FixTags.REFORDERID);

			out.put((byte) '=');

			FixUtils.put(out,refOrderID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRefOrderIDSource()) {		
			out.put(FixTags.REFORDERIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,refOrderIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRefOrdIDReason()) {		
			out.put(FixTags.REFORDIDREASON);

			out.put((byte) '=');

			FixUtils.put(out, (long)refOrdIDReason);
		
			out.put(FixUtils.SOH);

            }

		if (hasOrdType()) {		
			out.put(FixTags.ORDTYPE);

			out.put((byte) '=');

			FixUtils.put(out,ordType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPrice()) {		
			out.put(FixTags.PRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)price);
		
			out.put(FixUtils.SOH);

            }

		if (hasStopPx()) {		
			out.put(FixTags.STOPPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)stopPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasExecInst()) {		
			out.put(FixTags.EXECINST);

			out.put((byte) '=');

			FixUtils.put(out,execInst); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrdStatus()) {		
			out.put(FixTags.ORDSTATUS);

			out.put((byte) '=');

			FixUtils.put(out,ordStatus); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLeavesQty()) {		
			out.put(FixTags.LEAVESQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)leavesQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasCumQty()) {		
			out.put(FixTags.CUMQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)cumQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasTimeInForce()) {		
			out.put(FixTags.TIMEINFORCE);

			out.put((byte) '=');

			FixUtils.put(out,timeInForce); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasExpireTime()) {		
			out.put(FixTags.EXPIRETIME);

			out.put((byte) '=');

			FixUtils.put(out,expireTime); 		
		
			out.put(FixUtils.SOH);

            }

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

		if (hasBookingType()) {		
			out.put(FixTags.BOOKINGTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)bookingType);
		
			out.put(FixUtils.SOH);

            }

		if (hasOrigCustOrderCapacity()) {		
			out.put(FixTags.ORIGCUSTORDERCAPACITY);

			out.put((byte) '=');

			FixUtils.put(out, (long)origCustOrderCapacity);
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderInputDevice()) {		
			out.put(FixTags.ORDERINPUTDEVICE);

			out.put((byte) '=');

			FixUtils.put(out,orderInputDevice); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLotType()) {		
			out.put(FixTags.LOTTYPE);

			out.put((byte) '=');

			FixUtils.put(out,lotType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTransBkdTime()) {		
			out.put(FixTags.TRANSBKDTIME);

			out.put((byte) '=');

			FixUtils.put(out,transBkdTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrigOrdModTime()) {		
			out.put(FixTags.ORIGORDMODTIME);

			out.put((byte) '=');

			FixUtils.put(out,origOrdModTime); 		
		
			out.put(FixUtils.SOH);

            }

		orderQtyData.encode(out);
		displayInstruction.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasOrderID()) {		
			FixUtils.put(out,orderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryOrderID()) {		
			FixUtils.put(out,secondaryOrderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
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
		
		if (hasRefOrderID()) {		
			FixUtils.put(out,refOrderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefOrderIDSource()) {		
			FixUtils.put(out,refOrderIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefOrdIDReason()) {		
			FixUtils.put(out, (long)refOrdIDReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdType()) {		
			FixUtils.put(out,ordType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPrice()) {		
			FixUtils.put(out, (long)price);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStopPx()) {		
			FixUtils.put(out, (long)stopPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecInst()) {		
			FixUtils.put(out,execInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdStatus()) {		
			FixUtils.put(out,ordStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLeavesQty()) {		
			FixUtils.put(out, (long)leavesQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCumQty()) {		
			FixUtils.put(out, (long)cumQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTimeInForce()) {		
			FixUtils.put(out,timeInForce); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExpireTime()) {		
			FixUtils.put(out,expireTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderCapacity()) {		
			FixUtils.put(out,orderCapacity); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderRestrictions()) {		
			FixUtils.put(out,orderRestrictions); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBookingType()) {		
			FixUtils.put(out, (long)bookingType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigCustOrderCapacity()) {		
			FixUtils.put(out, (long)origCustOrderCapacity);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderInputDevice()) {		
			FixUtils.put(out,orderInputDevice); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLotType()) {		
			FixUtils.put(out,lotType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransBkdTime()) {		
			FixUtils.put(out,transBkdTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigOrdModTime()) {		
			FixUtils.put(out,origOrdModTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		orderQtyData.printBuffer(out);
		displayInstruction.printBuffer(out);
	}

	public byte[] getOrderID() { 		
		if ( hasOrderID()) {		
			if (hasOrderID == FixUtils.TAG_HAS_VALUE) {		
				return orderID; 		
			} else {		
		
				buf.position(hasOrderID);		
		
			FixMessage.getTagStringValue(buf, orderID, 0, orderID.length, err);
		
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
		if (hasOrderID()) FixUtils.fillSpace(orderID);		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderID(String str) {		
		if (str == null ) return;
		if (hasOrderID()) FixUtils.fillSpace(orderID);		
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
		
			FixMessage.getTagStringValue(buf, secondaryOrderID, 0, secondaryOrderID.length, err);
		
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
		if (hasSecondaryOrderID()) FixUtils.fillSpace(secondaryOrderID);		
		FixUtils.copy(secondaryOrderID, src); 		
		hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryOrderID(String str) {		
		if (str == null ) return;
		if (hasSecondaryOrderID()) FixUtils.fillSpace(secondaryOrderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryOrderID, src); 		
		hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getClOrdID() { 		
		if ( hasClOrdID()) {		
			if (hasClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return clOrdID; 		
			} else {		
		
				buf.position(hasClOrdID);		
		
			FixMessage.getTagStringValue(buf, clOrdID, 0, clOrdID.length, err);
		
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
		if (hasClOrdID()) FixUtils.fillSpace(clOrdID);		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setClOrdID(String str) {		
		if (str == null ) return;
		if (hasClOrdID()) FixUtils.fillSpace(clOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecondaryClOrdID() { 		
		if ( hasSecondaryClOrdID()) {		
			if (hasSecondaryClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryClOrdID; 		
			} else {		
		
				buf.position(hasSecondaryClOrdID);		
		
			FixMessage.getTagStringValue(buf, secondaryClOrdID, 0, secondaryClOrdID.length, err);
		
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
		if (hasSecondaryClOrdID()) FixUtils.fillSpace(secondaryClOrdID);		
		FixUtils.copy(secondaryClOrdID, src); 		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryClOrdID(String str) {		
		if (str == null ) return;
		if (hasSecondaryClOrdID()) FixUtils.fillSpace(secondaryClOrdID);		
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
		
			FixMessage.getTagStringValue(buf, listID, 0, listID.length, err);
		
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
		if (hasListID()) FixUtils.fillSpace(listID);		
		FixUtils.copy(listID, src); 		
		hasListID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setListID(String str) {		
		if (str == null ) return;
		if (hasListID()) FixUtils.fillSpace(listID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(listID, src); 		
		hasListID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRefOrderID() { 		
		if ( hasRefOrderID()) {		
			if (hasRefOrderID == FixUtils.TAG_HAS_VALUE) {		
				return refOrderID; 		
			} else {		
		
				buf.position(hasRefOrderID);		
		
			FixMessage.getTagStringValue(buf, refOrderID, 0, refOrderID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRefOrderID);		
					return null;		
				}		
			}		
			hasRefOrderID = FixUtils.TAG_HAS_VALUE;		
			return refOrderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefOrderID() { return hasRefOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasRefOrderID()) FixUtils.fillSpace(refOrderID);		
		FixUtils.copy(refOrderID, src); 		
		hasRefOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefOrderID(String str) {		
		if (str == null ) return;
		if (hasRefOrderID()) FixUtils.fillSpace(refOrderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refOrderID, src); 		
		hasRefOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getRefOrderIDSource() { 		
		if ( hasRefOrderIDSource()) {		
			if (hasRefOrderIDSource == FixUtils.TAG_HAS_VALUE) {		
				return refOrderIDSource; 		
			} else {		
		
				buf.position(hasRefOrderIDSource);		
		
			refOrderIDSource = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (refOrderIDSource != (byte)'3') && (refOrderIDSource != (byte)'2') && (refOrderIDSource != (byte)'1') && (refOrderIDSource != (byte)'0') && (refOrderIDSource != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1081);		
				if (err.hasError()) {		
					buf.position(hasRefOrderIDSource);		
					return (byte)'0';		
				}		
			}		
			hasRefOrderIDSource = FixUtils.TAG_HAS_VALUE;		
			return refOrderIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasRefOrderIDSource() { return hasRefOrderIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefOrderIDSource(byte src) {		
		refOrderIDSource = src;
		hasRefOrderIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefOrderIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasRefOrderIDSource()) refOrderIDSource = (byte)' ';		
		refOrderIDSource = src[0];		
		hasRefOrderIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefOrderIDSource(String str) {		
		if (str == null ) return;
		if (hasRefOrderIDSource()) refOrderIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		refOrderIDSource = src[0];		
		hasRefOrderIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRefOrdIDReason() { 		
		if ( hasRefOrdIDReason()) {		
			if (hasRefOrdIDReason == FixUtils.TAG_HAS_VALUE) {		
				return refOrdIDReason; 		
			} else {		
		
				buf.position(hasRefOrdIDReason);		
		
			refOrdIDReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRefOrdIDReason);		
					return 0;		
				}		
			}		
			hasRefOrdIDReason = FixUtils.TAG_HAS_VALUE;		
			return refOrdIDReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRefOrdIDReason() { return hasRefOrdIDReason != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefOrdIDReason(long src) {		
		refOrdIDReason = src;
		hasRefOrdIDReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefOrdIDReason(byte[] src) {		
		if (src == null ) return;
		if (hasRefOrdIDReason()) refOrdIDReason = FixUtils.TAG_HAS_NO_VALUE;		
		refOrdIDReason = FixUtils.longValueOf(src, 0, src.length);
		hasRefOrdIDReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefOrdIDReason(String str) {		
		if (str == null ) return;
		if (hasRefOrdIDReason()) refOrdIDReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		refOrdIDReason = FixUtils.longValueOf(src, 0, src.length);
		hasRefOrdIDReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getOrdType() { 		
		if ( hasOrdType()) {		
			if (hasOrdType == FixUtils.TAG_HAS_VALUE) {		
				return ordType; 		
			} else {		
		
				buf.position(hasOrdType);		
		
			ordType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (ordType != (byte)'D') && (ordType != (byte)'E') && (ordType != (byte)'F') && (ordType != (byte)'G') && (ordType != (byte)'A') && (ordType != (byte)'B') && (ordType != (byte)'C') && (ordType != (byte)'L') && (ordType != (byte)'M') && (ordType != (byte)'H') && (ordType != (byte)'I') && (ordType != (byte)'J') && (ordType != (byte)'K') && (ordType != (byte)'3') && (ordType != (byte)'2') && (ordType != (byte)'1') && (ordType != (byte)'Q') && (ordType != (byte)'7') && (ordType != (byte)'P') && (ordType != (byte)'6') && (ordType != (byte)'5') && (ordType != (byte)'4') && (ordType != (byte)'9') && (ordType != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 40);		
				if (err.hasError()) {		
					buf.position(hasOrdType);		
					return (byte)'0';		
				}		
			}		
			hasOrdType = FixUtils.TAG_HAS_VALUE;		
			return ordType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrdType() { return hasOrdType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrdType(byte src) {		
		ordType = src;
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdType(byte[] src) {		
		if (src == null ) return;
		if (hasOrdType()) ordType = (byte)' ';		
		ordType = src[0];		
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrdType(String str) {		
		if (str == null ) return;
		if (hasOrdType()) ordType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		ordType = src[0];		
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPrice() { 		
		if ( hasPrice()) {		
			if (hasPrice == FixUtils.TAG_HAS_VALUE) {		
				return price; 		
			} else {		
		
				buf.position(hasPrice);		
		
			price = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPrice);		
					return 0;		
				}		
			}		
			hasPrice = FixUtils.TAG_HAS_VALUE;		
			return price;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPrice() { return hasPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPrice(long src) {		
		price = src;
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice(byte[] src) {		
		if (src == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPrice(String str) {		
		if (str == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStopPx() { 		
		if ( hasStopPx()) {		
			if (hasStopPx == FixUtils.TAG_HAS_VALUE) {		
				return stopPx; 		
			} else {		
		
				buf.position(hasStopPx);		
		
			stopPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStopPx);		
					return 0;		
				}		
			}		
			hasStopPx = FixUtils.TAG_HAS_VALUE;		
			return stopPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStopPx() { return hasStopPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStopPx(long src) {		
		stopPx = src;
		hasStopPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStopPx(byte[] src) {		
		if (src == null ) return;
		if (hasStopPx()) stopPx = FixUtils.TAG_HAS_NO_VALUE;		
		stopPx = FixUtils.longValueOf(src, 0, src.length);
		hasStopPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStopPx(String str) {		
		if (str == null ) return;
		if (hasStopPx()) stopPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		stopPx = FixUtils.longValueOf(src, 0, src.length);
		hasStopPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getExecInst() { 		
		if ( hasExecInst()) {		
			if (hasExecInst == FixUtils.TAG_HAS_VALUE) {		
				return execInst; 		
			} else {		
		
				buf.position(hasExecInst);		
		
			FixMessage.getTagStringValue(buf, execInst, 0, execInst.length, err);
		
				if (err.hasError()) {		
					buf.position(hasExecInst);		
					return null;		
				}		
			}		
			hasExecInst = FixUtils.TAG_HAS_VALUE;		
			return execInst;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExecInst() { return hasExecInst != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setExecInst(byte[] src) {		
		if (src == null ) return;
		if (hasExecInst()) FixUtils.fillSpace(execInst);		
		FixUtils.copy(execInst, src); 		
		hasExecInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setExecInst(String str) {		
		if (str == null ) return;
		if (hasExecInst()) FixUtils.fillSpace(execInst);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(execInst, src); 		
		hasExecInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getOrdStatus() { 		
		if ( hasOrdStatus()) {		
			if (hasOrdStatus == FixUtils.TAG_HAS_VALUE) {		
				return ordStatus; 		
			} else {		
		
				buf.position(hasOrdStatus);		
		
			ordStatus = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (ordStatus != (byte)'D') && (ordStatus != (byte)'E') && (ordStatus != (byte)'A') && (ordStatus != (byte)'B') && (ordStatus != (byte)'C') && (ordStatus != (byte)'3') && (ordStatus != (byte)'2') && (ordStatus != (byte)'1') && (ordStatus != (byte)'0') && (ordStatus != (byte)'7') && (ordStatus != (byte)'6') && (ordStatus != (byte)'5') && (ordStatus != (byte)'4') && (ordStatus != (byte)'9') && (ordStatus != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 39);		
				if (err.hasError()) {		
					buf.position(hasOrdStatus);		
					return (byte)'0';		
				}		
			}		
			hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
			return ordStatus;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrdStatus() { return hasOrdStatus != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrdStatus(byte src) {		
		ordStatus = src;
		hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdStatus(byte[] src) {		
		if (src == null ) return;
		if (hasOrdStatus()) ordStatus = (byte)' ';		
		ordStatus = src[0];		
		hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrdStatus(String str) {		
		if (str == null ) return;
		if (hasOrdStatus()) ordStatus = (byte)' ';		
		byte[] src = str.getBytes(); 		
		ordStatus = src[0];		
		hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLeavesQty() { 		
		if ( hasLeavesQty()) {		
			if (hasLeavesQty == FixUtils.TAG_HAS_VALUE) {		
				return leavesQty; 		
			} else {		
		
				buf.position(hasLeavesQty);		
		
			leavesQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLeavesQty);		
					return 0;		
				}		
			}		
			hasLeavesQty = FixUtils.TAG_HAS_VALUE;		
			return leavesQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLeavesQty() { return hasLeavesQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLeavesQty(long src) {		
		leavesQty = src;
		hasLeavesQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLeavesQty(byte[] src) {		
		if (src == null ) return;
		if (hasLeavesQty()) leavesQty = FixUtils.TAG_HAS_NO_VALUE;		
		leavesQty = FixUtils.longValueOf(src, 0, src.length);
		hasLeavesQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLeavesQty(String str) {		
		if (str == null ) return;
		if (hasLeavesQty()) leavesQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		leavesQty = FixUtils.longValueOf(src, 0, src.length);
		hasLeavesQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getCumQty() { 		
		if ( hasCumQty()) {		
			if (hasCumQty == FixUtils.TAG_HAS_VALUE) {		
				return cumQty; 		
			} else {		
		
				buf.position(hasCumQty);		
		
			cumQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasCumQty);		
					return 0;		
				}		
			}		
			hasCumQty = FixUtils.TAG_HAS_VALUE;		
			return cumQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCumQty() { return hasCumQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCumQty(long src) {		
		cumQty = src;
		hasCumQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCumQty(byte[] src) {		
		if (src == null ) return;
		if (hasCumQty()) cumQty = FixUtils.TAG_HAS_NO_VALUE;		
		cumQty = FixUtils.longValueOf(src, 0, src.length);
		hasCumQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCumQty(String str) {		
		if (str == null ) return;
		if (hasCumQty()) cumQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		cumQty = FixUtils.longValueOf(src, 0, src.length);
		hasCumQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getTimeInForce() { 		
		if ( hasTimeInForce()) {		
			if (hasTimeInForce == FixUtils.TAG_HAS_VALUE) {		
				return timeInForce; 		
			} else {		
		
				buf.position(hasTimeInForce);		
		
			timeInForce = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (timeInForce != (byte)'3') && (timeInForce != (byte)'2') && (timeInForce != (byte)'1') && (timeInForce != (byte)'0') && (timeInForce != (byte)'7') && (timeInForce != (byte)'6') && (timeInForce != (byte)'5') && (timeInForce != (byte)'4') && (timeInForce != (byte)'9') && (timeInForce != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 59);		
				if (err.hasError()) {		
					buf.position(hasTimeInForce);		
					return (byte)'0';		
				}		
			}		
			hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
			return timeInForce;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTimeInForce() { return hasTimeInForce != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTimeInForce(byte src) {		
		timeInForce = src;
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeInForce(byte[] src) {		
		if (src == null ) return;
		if (hasTimeInForce()) timeInForce = (byte)' ';		
		timeInForce = src[0];		
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTimeInForce(String str) {		
		if (str == null ) return;
		if (hasTimeInForce()) timeInForce = (byte)' ';		
		byte[] src = str.getBytes(); 		
		timeInForce = src[0];		
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getExpireTime() { 		
		if ( hasExpireTime()) {		
			if (hasExpireTime == FixUtils.TAG_HAS_VALUE) {		
				return expireTime; 		
			} else {		
		
				buf.position(hasExpireTime);		
		
			FixMessage.getTagStringValue(buf, expireTime, 0, expireTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasExpireTime);		
					return null;		
				}		
			}		
			hasExpireTime = FixUtils.TAG_HAS_VALUE;		
			return expireTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExpireTime() { return hasExpireTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setExpireTime(byte[] src) {		
		if (src == null ) return;
		if (hasExpireTime()) FixUtils.fillSpace(expireTime);		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setExpireTime(String str) {		
		if (str == null ) return;
		if (hasExpireTime()) FixUtils.fillSpace(expireTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
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
		if (hasOrderRestrictions()) FixUtils.fillSpace(orderRestrictions);		
		FixUtils.copy(orderRestrictions, src); 		
		hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderRestrictions(String str) {		
		if (str == null ) return;
		if (hasOrderRestrictions()) FixUtils.fillSpace(orderRestrictions);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderRestrictions, src); 		
		hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getBookingType() { 		
		if ( hasBookingType()) {		
			if (hasBookingType == FixUtils.TAG_HAS_VALUE) {		
				return bookingType; 		
			} else {		
		
				buf.position(hasBookingType);		
		
			bookingType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBookingType);		
					return 0;		
				}		
			}		
			hasBookingType = FixUtils.TAG_HAS_VALUE;		
			return bookingType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBookingType() { return hasBookingType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBookingType(long src) {		
		bookingType = src;
		hasBookingType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBookingType(byte[] src) {		
		if (src == null ) return;
		if (hasBookingType()) bookingType = FixUtils.TAG_HAS_NO_VALUE;		
		bookingType = FixUtils.longValueOf(src, 0, src.length);
		hasBookingType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBookingType(String str) {		
		if (str == null ) return;
		if (hasBookingType()) bookingType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bookingType = FixUtils.longValueOf(src, 0, src.length);
		hasBookingType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOrigCustOrderCapacity() { 		
		if ( hasOrigCustOrderCapacity()) {		
			if (hasOrigCustOrderCapacity == FixUtils.TAG_HAS_VALUE) {		
				return origCustOrderCapacity; 		
			} else {		
		
				buf.position(hasOrigCustOrderCapacity);		
		
			origCustOrderCapacity = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOrigCustOrderCapacity);		
					return 0;		
				}		
			}		
			hasOrigCustOrderCapacity = FixUtils.TAG_HAS_VALUE;		
			return origCustOrderCapacity;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrigCustOrderCapacity() { return hasOrigCustOrderCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrigCustOrderCapacity(long src) {		
		origCustOrderCapacity = src;
		hasOrigCustOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigCustOrderCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasOrigCustOrderCapacity()) origCustOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		origCustOrderCapacity = FixUtils.longValueOf(src, 0, src.length);
		hasOrigCustOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrigCustOrderCapacity(String str) {		
		if (str == null ) return;
		if (hasOrigCustOrderCapacity()) origCustOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		origCustOrderCapacity = FixUtils.longValueOf(src, 0, src.length);
		hasOrigCustOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOrderInputDevice() { 		
		if ( hasOrderInputDevice()) {		
			if (hasOrderInputDevice == FixUtils.TAG_HAS_VALUE) {		
				return orderInputDevice; 		
			} else {		
		
				buf.position(hasOrderInputDevice);		
		
			FixMessage.getTagStringValue(buf, orderInputDevice, 0, orderInputDevice.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderInputDevice);		
					return null;		
				}		
			}		
			hasOrderInputDevice = FixUtils.TAG_HAS_VALUE;		
			return orderInputDevice;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderInputDevice() { return hasOrderInputDevice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderInputDevice(byte[] src) {		
		if (src == null ) return;
		if (hasOrderInputDevice()) FixUtils.fillSpace(orderInputDevice);		
		FixUtils.copy(orderInputDevice, src); 		
		hasOrderInputDevice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderInputDevice(String str) {		
		if (str == null ) return;
		if (hasOrderInputDevice()) FixUtils.fillSpace(orderInputDevice);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderInputDevice, src); 		
		hasOrderInputDevice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getLotType() { 		
		if ( hasLotType()) {		
			if (hasLotType == FixUtils.TAG_HAS_VALUE) {		
				return lotType; 		
			} else {		
		
				buf.position(hasLotType);		
		
			lotType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (lotType != (byte)'3') && (lotType != (byte)'2') && (lotType != (byte)'1') && (lotType != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1093);		
				if (err.hasError()) {		
					buf.position(hasLotType);		
					return (byte)'0';		
				}		
			}		
			hasLotType = FixUtils.TAG_HAS_VALUE;		
			return lotType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasLotType() { return hasLotType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLotType(byte src) {		
		lotType = src;
		hasLotType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLotType(byte[] src) {		
		if (src == null ) return;
		if (hasLotType()) lotType = (byte)' ';		
		lotType = src[0];		
		hasLotType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLotType(String str) {		
		if (str == null ) return;
		if (hasLotType()) lotType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		lotType = src[0];		
		hasLotType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTransBkdTime() { 		
		if ( hasTransBkdTime()) {		
			if (hasTransBkdTime == FixUtils.TAG_HAS_VALUE) {		
				return transBkdTime; 		
			} else {		
		
				buf.position(hasTransBkdTime);		
		
			FixMessage.getTagStringValue(buf, transBkdTime, 0, transBkdTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTransBkdTime);		
					return null;		
				}		
			}		
			hasTransBkdTime = FixUtils.TAG_HAS_VALUE;		
			return transBkdTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTransBkdTime() { return hasTransBkdTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTransBkdTime(byte[] src) {		
		if (src == null ) return;
		if (hasTransBkdTime()) FixUtils.fillSpace(transBkdTime);		
		FixUtils.copy(transBkdTime, src); 		
		hasTransBkdTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTransBkdTime(String str) {		
		if (str == null ) return;
		if (hasTransBkdTime()) FixUtils.fillSpace(transBkdTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transBkdTime, src); 		
		hasTransBkdTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOrigOrdModTime() { 		
		if ( hasOrigOrdModTime()) {		
			if (hasOrigOrdModTime == FixUtils.TAG_HAS_VALUE) {		
				return origOrdModTime; 		
			} else {		
		
				buf.position(hasOrigOrdModTime);		
		
			FixMessage.getTagStringValue(buf, origOrdModTime, 0, origOrdModTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOrigOrdModTime);		
					return null;		
				}		
			}		
			hasOrigOrdModTime = FixUtils.TAG_HAS_VALUE;		
			return origOrdModTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigOrdModTime() { return hasOrigOrdModTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrigOrdModTime(byte[] src) {		
		if (src == null ) return;
		if (hasOrigOrdModTime()) FixUtils.fillSpace(origOrdModTime);		
		FixUtils.copy(origOrdModTime, src); 		
		hasOrigOrdModTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrigOrdModTime(String str) {		
		if (str == null ) return;
		if (hasOrigOrdModTime()) FixUtils.fillSpace(origOrdModTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origOrdModTime, src); 		
		hasOrigOrdModTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasOrderID()) s += "OrderID(37)= " + new String( FixUtils.trim(getOrderID()) ) + "\n" ; 
		if (hasSecondaryOrderID()) s += "SecondaryOrderID(198)= " + new String( FixUtils.trim(getSecondaryOrderID()) ) + "\n" ; 
		if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasSecondaryClOrdID()) s += "SecondaryClOrdID(526)= " + new String( FixUtils.trim(getSecondaryClOrdID()) ) + "\n" ; 
		if (hasListID()) s += "ListID(66)= " + new String( FixUtils.trim(getListID()) ) + "\n" ; 
		if (hasRefOrderID()) s += "RefOrderID(1080)= " + new String( FixUtils.trim(getRefOrderID()) ) + "\n" ; 
		if (hasRefOrderIDSource()) s += "RefOrderIDSource(1081)= " + getRefOrderIDSource() + "\n" ; 
		if (hasRefOrdIDReason()) s += "RefOrdIDReason(1431)= " + getRefOrdIDReason() + "\n" ; 
		if (hasOrdType()) s += "OrdType(40)= " + getOrdType() + "\n" ; 
		if (hasPrice()) s += "Price(44)= " + getPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasStopPx()) s += "StopPx(99)= " + getStopPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasExecInst()) s += "ExecInst(18)= " + new String( FixUtils.trim(getExecInst()) ) + "\n" ; 
		if (hasOrdStatus()) s += "OrdStatus(39)= " + getOrdStatus() + "\n" ; 
		if (hasLeavesQty()) s += "LeavesQty(151)= " + getLeavesQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCumQty()) s += "CumQty(14)= " + getCumQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTimeInForce()) s += "TimeInForce(59)= " + getTimeInForce() + "\n" ; 
		if (hasExpireTime()) s += "ExpireTime(126)= " + new String( FixUtils.trim(getExpireTime()) ) + "\n" ; 
		if (hasOrderCapacity()) s += "OrderCapacity(528)= " + getOrderCapacity() + "\n" ; 
		if (hasOrderRestrictions()) s += "OrderRestrictions(529)= " + new String( FixUtils.trim(getOrderRestrictions()) ) + "\n" ; 
		if (hasBookingType()) s += "BookingType(775)= " + getBookingType() + "\n" ; 
		if (hasOrigCustOrderCapacity()) s += "OrigCustOrderCapacity(1432)= " + getOrigCustOrderCapacity() + "\n" ; 
		if (hasOrderInputDevice()) s += "OrderInputDevice(821)= " + new String( FixUtils.trim(getOrderInputDevice()) ) + "\n" ; 
		if (hasLotType()) s += "LotType(1093)= " + getLotType() + "\n" ; 
		if (hasTransBkdTime()) s += "TransBkdTime(483)= " + new String( FixUtils.trim(getTransBkdTime()) ) + "\n" ; 
		if (hasOrigOrdModTime()) s += "OrigOrdModTime(586)= " + new String( FixUtils.trim(getOrigOrdModTime()) ) + "\n" ; 

		s += orderQtyData.toString();
		s += displayInstruction.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTradeReportOrderDetail)) return false;

		FixTradeReportOrderDetail msg = (FixTradeReportOrderDetail) o;

		if (!orderQtyData.equals(msg.orderQtyData)) return false;
		if (!displayInstruction.equals(msg.displayInstruction)) return false;
		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasSecondaryOrderID() && !msg.hasSecondaryOrderID()) || (!hasSecondaryOrderID() && msg.hasSecondaryOrderID())) return false;
		if (!(!hasSecondaryOrderID() && !msg.hasSecondaryOrderID()) && !FixUtils.equals(getSecondaryOrderID(), msg.getSecondaryOrderID())) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) || (!hasSecondaryClOrdID() && msg.hasSecondaryClOrdID())) return false;
		if (!(!hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) && !FixUtils.equals(getSecondaryClOrdID(), msg.getSecondaryClOrdID())) return false;
		if ((hasListID() && !msg.hasListID()) || (!hasListID() && msg.hasListID())) return false;
		if (!(!hasListID() && !msg.hasListID()) && !FixUtils.equals(getListID(), msg.getListID())) return false;
		if ((hasRefOrderID() && !msg.hasRefOrderID()) || (!hasRefOrderID() && msg.hasRefOrderID())) return false;
		if (!(!hasRefOrderID() && !msg.hasRefOrderID()) && !FixUtils.equals(getRefOrderID(), msg.getRefOrderID())) return false;
		if ((hasRefOrderIDSource() && !msg.hasRefOrderIDSource()) || (!hasRefOrderIDSource() && msg.hasRefOrderIDSource())) return false;
		if (!(!hasRefOrderIDSource() && !msg.hasRefOrderIDSource()) && !(getRefOrderIDSource()==msg.getRefOrderIDSource())) return false;
		if ((hasRefOrdIDReason() && !msg.hasRefOrdIDReason()) || (!hasRefOrdIDReason() && msg.hasRefOrdIDReason())) return false;
		if (!(!hasRefOrdIDReason() && !msg.hasRefOrdIDReason()) && !(getRefOrdIDReason()==msg.getRefOrdIDReason())) return false;
		if ((hasOrdType() && !msg.hasOrdType()) || (!hasOrdType() && msg.hasOrdType())) return false;
		if (!(!hasOrdType() && !msg.hasOrdType()) && !(getOrdType()==msg.getOrdType())) return false;
		if ((hasPrice() && !msg.hasPrice()) || (!hasPrice() && msg.hasPrice())) return false;
		if (!(!hasPrice() && !msg.hasPrice()) && !(getPrice()==msg.getPrice())) return false;
		if ((hasStopPx() && !msg.hasStopPx()) || (!hasStopPx() && msg.hasStopPx())) return false;
		if (!(!hasStopPx() && !msg.hasStopPx()) && !(getStopPx()==msg.getStopPx())) return false;
		if ((hasExecInst() && !msg.hasExecInst()) || (!hasExecInst() && msg.hasExecInst())) return false;
		if (!(!hasExecInst() && !msg.hasExecInst()) && !FixUtils.equals(getExecInst(), msg.getExecInst())) return false;
		if ((hasOrdStatus() && !msg.hasOrdStatus()) || (!hasOrdStatus() && msg.hasOrdStatus())) return false;
		if (!(!hasOrdStatus() && !msg.hasOrdStatus()) && !(getOrdStatus()==msg.getOrdStatus())) return false;
		if ((hasLeavesQty() && !msg.hasLeavesQty()) || (!hasLeavesQty() && msg.hasLeavesQty())) return false;
		if (!(!hasLeavesQty() && !msg.hasLeavesQty()) && !(getLeavesQty()==msg.getLeavesQty())) return false;
		if ((hasCumQty() && !msg.hasCumQty()) || (!hasCumQty() && msg.hasCumQty())) return false;
		if (!(!hasCumQty() && !msg.hasCumQty()) && !(getCumQty()==msg.getCumQty())) return false;
		if ((hasTimeInForce() && !msg.hasTimeInForce()) || (!hasTimeInForce() && msg.hasTimeInForce())) return false;
		if (!(!hasTimeInForce() && !msg.hasTimeInForce()) && !(getTimeInForce()==msg.getTimeInForce())) return false;
		if ((hasExpireTime() && !msg.hasExpireTime()) || (!hasExpireTime() && msg.hasExpireTime())) return false;
		if (!(!hasExpireTime() && !msg.hasExpireTime()) ) return false;
		if ((hasOrderCapacity() && !msg.hasOrderCapacity()) || (!hasOrderCapacity() && msg.hasOrderCapacity())) return false;
		if (!(!hasOrderCapacity() && !msg.hasOrderCapacity()) && !(getOrderCapacity()==msg.getOrderCapacity())) return false;
		if ((hasOrderRestrictions() && !msg.hasOrderRestrictions()) || (!hasOrderRestrictions() && msg.hasOrderRestrictions())) return false;
		if (!(!hasOrderRestrictions() && !msg.hasOrderRestrictions()) && !FixUtils.equals(getOrderRestrictions(), msg.getOrderRestrictions())) return false;
		if ((hasBookingType() && !msg.hasBookingType()) || (!hasBookingType() && msg.hasBookingType())) return false;
		if (!(!hasBookingType() && !msg.hasBookingType()) && !(getBookingType()==msg.getBookingType())) return false;
		if ((hasOrigCustOrderCapacity() && !msg.hasOrigCustOrderCapacity()) || (!hasOrigCustOrderCapacity() && msg.hasOrigCustOrderCapacity())) return false;
		if (!(!hasOrigCustOrderCapacity() && !msg.hasOrigCustOrderCapacity()) && !(getOrigCustOrderCapacity()==msg.getOrigCustOrderCapacity())) return false;
		if ((hasOrderInputDevice() && !msg.hasOrderInputDevice()) || (!hasOrderInputDevice() && msg.hasOrderInputDevice())) return false;
		if (!(!hasOrderInputDevice() && !msg.hasOrderInputDevice()) && !FixUtils.equals(getOrderInputDevice(), msg.getOrderInputDevice())) return false;
		if ((hasLotType() && !msg.hasLotType()) || (!hasLotType() && msg.hasLotType())) return false;
		if (!(!hasLotType() && !msg.hasLotType()) && !(getLotType()==msg.getLotType())) return false;
		if ((hasTransBkdTime() && !msg.hasTransBkdTime()) || (!hasTransBkdTime() && msg.hasTransBkdTime())) return false;
		if (!(!hasTransBkdTime() && !msg.hasTransBkdTime()) ) return false;
		if ((hasOrigOrdModTime() && !msg.hasOrigOrdModTime()) || (!hasOrigOrdModTime() && msg.hasOrigOrdModTime())) return false;
		if (!(!hasOrigOrdModTime() && !msg.hasOrigOrdModTime()) ) return false;
		return true;
	}
	public FixTradeReportOrderDetail clone ( FixTradeReportOrderDetail out ) {
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasSecondaryOrderID())
			out.setSecondaryOrderID(getSecondaryOrderID());
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasSecondaryClOrdID())
			out.setSecondaryClOrdID(getSecondaryClOrdID());
		if ( hasListID())
			out.setListID(getListID());
		if ( hasRefOrderID())
			out.setRefOrderID(getRefOrderID());
		if ( hasRefOrderIDSource())
			out.setRefOrderIDSource(getRefOrderIDSource());
		if ( hasRefOrdIDReason())
			out.setRefOrdIDReason(getRefOrdIDReason());
		if ( hasOrdType())
			out.setOrdType(getOrdType());
		if ( hasPrice())
			out.setPrice(getPrice());
		if ( hasStopPx())
			out.setStopPx(getStopPx());
		if ( hasExecInst())
			out.setExecInst(getExecInst());
		if ( hasOrdStatus())
			out.setOrdStatus(getOrdStatus());
		if ( hasLeavesQty())
			out.setLeavesQty(getLeavesQty());
		if ( hasCumQty())
			out.setCumQty(getCumQty());
		if ( hasTimeInForce())
			out.setTimeInForce(getTimeInForce());
		if ( hasExpireTime())
			out.setExpireTime(getExpireTime());
		if ( hasOrderCapacity())
			out.setOrderCapacity(getOrderCapacity());
		if ( hasOrderRestrictions())
			out.setOrderRestrictions(getOrderRestrictions());
		if ( hasBookingType())
			out.setBookingType(getBookingType());
		if ( hasOrigCustOrderCapacity())
			out.setOrigCustOrderCapacity(getOrigCustOrderCapacity());
		if ( hasOrderInputDevice())
			out.setOrderInputDevice(getOrderInputDevice());
		if ( hasLotType())
			out.setLotType(getLotType());
		if ( hasTransBkdTime())
			out.setTransBkdTime(getTransBkdTime());
		if ( hasOrigOrdModTime())
			out.setOrigOrdModTime(getOrigOrdModTime());
		if (orderQtyData.hasGroup())
			out.orderQtyData = orderQtyData.clone( out.orderQtyData);
		if (displayInstruction.hasGroup())
			out.displayInstruction = displayInstruction.clone( out.displayInstruction);
		return out;
	}

}
