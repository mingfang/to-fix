package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixOrdListStatGrp extends FixGroup {
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderID;
	byte[] orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryClOrdID;
	byte[] secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCumQty;
	long cumQty = 0;		
	private short hasOrdStatus;
	byte ordStatus = (byte)' ';		
	private short hasWorkingIndicator;
		boolean workingIndicator = false;		
	private short hasLeavesQty;
	long leavesQty = 0;		
	private short hasCxlQty;
	long cxlQty = 0;		
	private short hasAvgPx;
	long avgPx = 0;		
	private short hasOrdRejReason;
	long ordRejReason = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	
	public FixOrdListStatGrp() {
		this(false);
	}

	public FixOrdListStatGrp(boolean isRequired) {
		super(FixTags.CLORDID_INT);

		this.isRequired = isRequired;
		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCumQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrdStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasWorkingIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasLeavesQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasCxlQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrdRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		
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
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERID_INT:		
            		hasOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYCLORDID_INT:		
            		hasSecondaryClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CUMQTY_INT:		
            		hasCumQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDSTATUS_INT:		
            		hasOrdStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.WORKINGINDICATOR_INT:		
            		hasWorkingIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEAVESQTY_INT:		
            		hasLeavesQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CXLQTY_INT:		
            		hasCxlQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.AVGPX_INT:		
            		hasAvgPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDREJREASON_INT:		
            		hasOrdRejReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TEXT_INT:		
            		hasText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDTEXTLEN_INT:		
            		hasEncodedTextLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDTEXT_INT:		
            		hasEncodedText = (short) buf.position();		
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
		if (!hasCumQty()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CUMQTY_INT);
			return false;
		}
		if (!hasOrdStatus()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.ORDSTATUS_INT);
			return false;
		}
		if (!hasLeavesQty()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.LEAVESQTY_INT);
			return false;
		}
		if (!hasCxlQty()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CXLQTY_INT);
			return false;
		}
		if (!hasAvgPx()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.AVGPX_INT);
			return false;
		}
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasCumQty = FixUtils.TAG_HAS_NO_VALUE;
		hasOrdStatus = FixUtils.TAG_HAS_NO_VALUE;
		hasWorkingIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasLeavesQty = FixUtils.TAG_HAS_NO_VALUE;
		hasCxlQty = FixUtils.TAG_HAS_NO_VALUE;
		hasAvgPx = FixUtils.TAG_HAS_NO_VALUE;
		hasOrdRejReason = FixUtils.TAG_HAS_NO_VALUE;
		hasText = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;
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

		if (hasSecondaryClOrdID()) {		
			out.put(FixTags.SECONDARYCLORDID);

			out.put((byte) '=');

			FixUtils.put(out,secondaryClOrdID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCumQty()) {		
			out.put(FixTags.CUMQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)cumQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasOrdStatus()) {		
			out.put(FixTags.ORDSTATUS);

			out.put((byte) '=');

			FixUtils.put(out,ordStatus); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasWorkingIndicator()) {		
			out.put(FixTags.WORKINGINDICATOR);

			out.put((byte) '=');

			out.put(workingIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasLeavesQty()) {		
			out.put(FixTags.LEAVESQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)leavesQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasCxlQty()) {		
			out.put(FixTags.CXLQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)cxlQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasAvgPx()) {		
			out.put(FixTags.AVGPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)avgPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasOrdRejReason()) {		
			out.put(FixTags.ORDREJREASON);

			out.put((byte) '=');

			FixUtils.put(out, (long)ordRejReason);
		
			out.put(FixUtils.SOH);

            }

		if (hasText()) {		
			out.put(FixTags.TEXT);

			out.put((byte) '=');

			FixUtils.put(out,text); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedTextLen()) {		
			out.put(FixTags.ENCODEDTEXTLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)encodedTextLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedText()) {		
			out.put(FixTags.ENCODEDTEXT);

			out.put((byte) '=');

			FixUtils.put(out,encodedText); 		
		
			out.put(FixUtils.SOH);

            }

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
		
		if (hasSecondaryClOrdID()) {		
			FixUtils.put(out,secondaryClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCumQty()) {		
			FixUtils.put(out, (long)cumQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdStatus()) {		
			FixUtils.put(out,ordStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasWorkingIndicator()) {		
			out.put(workingIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLeavesQty()) {		
			FixUtils.put(out, (long)leavesQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCxlQty()) {		
			FixUtils.put(out, (long)cxlQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAvgPx()) {		
			FixUtils.put(out, (long)avgPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdRejReason()) {		
			FixUtils.put(out, (long)ordRejReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasText()) {		
			FixUtils.put(out,text); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedTextLen()) {		
			FixUtils.put(out, (long)encodedTextLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedText()) {		
			FixUtils.put(out,encodedText); 		
		
	        out.put( (byte)' ' );		
		}		
		
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
			
	public boolean getWorkingIndicator() { 		
		if ( hasWorkingIndicator()) {		
			if (hasWorkingIndicator == FixUtils.TAG_HAS_VALUE) {		
				return workingIndicator; 		
			} else {		
		
				buf.position(hasWorkingIndicator);		
		
			workingIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasWorkingIndicator);		
					return false;		
				}		
			}		
			hasWorkingIndicator = FixUtils.TAG_HAS_VALUE;		
			return workingIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasWorkingIndicator() { return hasWorkingIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setWorkingIndicator(boolean src) {		
		workingIndicator = src;
		hasWorkingIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setWorkingIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasWorkingIndicator()) workingIndicator = false;		
		workingIndicator = src[0]==(byte)'Y'?true:false;		
		hasWorkingIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setWorkingIndicator(String str) {		
		if (str == null ) return;
		if (hasWorkingIndicator()) workingIndicator = false;		
		byte[] src = str.getBytes(); 		
		workingIndicator = src[0]==(byte)'Y'?true:false;		
		hasWorkingIndicator = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getCxlQty() { 		
		if ( hasCxlQty()) {		
			if (hasCxlQty == FixUtils.TAG_HAS_VALUE) {		
				return cxlQty; 		
			} else {		
		
				buf.position(hasCxlQty);		
		
			cxlQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasCxlQty);		
					return 0;		
				}		
			}		
			hasCxlQty = FixUtils.TAG_HAS_VALUE;		
			return cxlQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCxlQty() { return hasCxlQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCxlQty(long src) {		
		cxlQty = src;
		hasCxlQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCxlQty(byte[] src) {		
		if (src == null ) return;
		if (hasCxlQty()) cxlQty = FixUtils.TAG_HAS_NO_VALUE;		
		cxlQty = FixUtils.longValueOf(src, 0, src.length);
		hasCxlQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCxlQty(String str) {		
		if (str == null ) return;
		if (hasCxlQty()) cxlQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		cxlQty = FixUtils.longValueOf(src, 0, src.length);
		hasCxlQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAvgPx() { 		
		if ( hasAvgPx()) {		
			if (hasAvgPx == FixUtils.TAG_HAS_VALUE) {		
				return avgPx; 		
			} else {		
		
				buf.position(hasAvgPx);		
		
			avgPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAvgPx);		
					return 0;		
				}		
			}		
			hasAvgPx = FixUtils.TAG_HAS_VALUE;		
			return avgPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAvgPx() { return hasAvgPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAvgPx(long src) {		
		avgPx = src;
		hasAvgPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgPx(byte[] src) {		
		if (src == null ) return;
		if (hasAvgPx()) avgPx = FixUtils.TAG_HAS_NO_VALUE;		
		avgPx = FixUtils.longValueOf(src, 0, src.length);
		hasAvgPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAvgPx(String str) {		
		if (str == null ) return;
		if (hasAvgPx()) avgPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		avgPx = FixUtils.longValueOf(src, 0, src.length);
		hasAvgPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOrdRejReason() { 		
		if ( hasOrdRejReason()) {		
			if (hasOrdRejReason == FixUtils.TAG_HAS_VALUE) {		
				return ordRejReason; 		
			} else {		
		
				buf.position(hasOrdRejReason);		
		
			ordRejReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOrdRejReason);		
					return 0;		
				}		
			}		
			hasOrdRejReason = FixUtils.TAG_HAS_VALUE;		
			return ordRejReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrdRejReason() { return hasOrdRejReason != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrdRejReason(long src) {		
		ordRejReason = src;
		hasOrdRejReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdRejReason(byte[] src) {		
		if (src == null ) return;
		if (hasOrdRejReason()) ordRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		ordRejReason = FixUtils.longValueOf(src, 0, src.length);
		hasOrdRejReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrdRejReason(String str) {		
		if (str == null ) return;
		if (hasOrdRejReason()) ordRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		ordRejReason = FixUtils.longValueOf(src, 0, src.length);
		hasOrdRejReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getText() { 		
		if ( hasText()) {		
			if (hasText == FixUtils.TAG_HAS_VALUE) {		
				return text; 		
			} else {		
		
				buf.position(hasText);		
		
			FixMessage.getTagStringValue(buf, text, 0, text.length, err);
		
				if (err.hasError()) {		
					buf.position(hasText);		
					return null;		
				}		
			}		
			hasText = FixUtils.TAG_HAS_VALUE;		
			return text;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasText() { return hasText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setText(byte[] src) {		
		if (src == null ) return;
		if (hasText()) FixUtils.fillNul(text);		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setText(String str) {		
		if (str == null ) return;
		if (hasText()) FixUtils.fillNul(text);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEncodedTextLen() { 		
		if ( hasEncodedTextLen()) {		
			if (hasEncodedTextLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedTextLen; 		
			} else {		
		
				buf.position(hasEncodedTextLen);		
		
			encodedTextLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedTextLen);		
					return 0;		
				}		
			}		
			hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
			return encodedTextLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedTextLen() { return hasEncodedTextLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedTextLen(long src) {		
		encodedTextLen = src;
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedTextLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedTextLen(String str) {		
		if (str == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedText() { 		
		if ( hasEncodedText()) {		
			if (hasEncodedText == FixUtils.TAG_HAS_VALUE) {		
				return encodedText; 		
			} else {		
		
				buf.position(hasEncodedText);		
		
			FixMessage.getTagStringValue(buf, encodedText, 0, encodedText.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedText);		
					return null;		
				}		
			}		
			hasEncodedText = FixUtils.TAG_HAS_VALUE;		
			return encodedText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedText() { return hasEncodedText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedText(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedText()) FixUtils.fillNul(encodedText);		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedText(String str) {		
		if (str == null ) return;
		if (hasEncodedText()) FixUtils.fillNul(encodedText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
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
		if (hasSecondaryClOrdID()) s += "SecondaryClOrdID(526)= " + new String( FixUtils.trim(getSecondaryClOrdID()) ) + "\n" ; 
		if (hasCumQty()) s += "CumQty(14)= " + getCumQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOrdStatus()) s += "OrdStatus(39)= " + getOrdStatus() + "\n" ; 
		if (hasWorkingIndicator()) s += "WorkingIndicator(636)= " + getWorkingIndicator() + "\n" ; 
		if (hasLeavesQty()) s += "LeavesQty(151)= " + getLeavesQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCxlQty()) s += "CxlQty(84)= " + getCxlQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAvgPx()) s += "AvgPx(6)= " + getAvgPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOrdRejReason()) s += "OrdRejReason(103)= " + getOrdRejReason() + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixOrdListStatGrp)) return false;

		FixOrdListStatGrp msg = (FixOrdListStatGrp) o;

		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) || (!hasSecondaryClOrdID() && msg.hasSecondaryClOrdID())) return false;
		if (!(!hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) && !FixUtils.equals(getSecondaryClOrdID(), msg.getSecondaryClOrdID())) return false;
		if ((hasCumQty() && !msg.hasCumQty()) || (!hasCumQty() && msg.hasCumQty())) return false;
		if (!(!hasCumQty() && !msg.hasCumQty()) && !(getCumQty()==msg.getCumQty())) return false;
		if ((hasOrdStatus() && !msg.hasOrdStatus()) || (!hasOrdStatus() && msg.hasOrdStatus())) return false;
		if (!(!hasOrdStatus() && !msg.hasOrdStatus()) && !(getOrdStatus()==msg.getOrdStatus())) return false;
		if ((hasWorkingIndicator() && !msg.hasWorkingIndicator()) || (!hasWorkingIndicator() && msg.hasWorkingIndicator())) return false;
		if (!(!hasWorkingIndicator() && !msg.hasWorkingIndicator()) && !(getWorkingIndicator()==msg.getWorkingIndicator())) return false;
		if ((hasLeavesQty() && !msg.hasLeavesQty()) || (!hasLeavesQty() && msg.hasLeavesQty())) return false;
		if (!(!hasLeavesQty() && !msg.hasLeavesQty()) && !(getLeavesQty()==msg.getLeavesQty())) return false;
		if ((hasCxlQty() && !msg.hasCxlQty()) || (!hasCxlQty() && msg.hasCxlQty())) return false;
		if (!(!hasCxlQty() && !msg.hasCxlQty()) && !(getCxlQty()==msg.getCxlQty())) return false;
		if ((hasAvgPx() && !msg.hasAvgPx()) || (!hasAvgPx() && msg.hasAvgPx())) return false;
		if (!(!hasAvgPx() && !msg.hasAvgPx()) && !(getAvgPx()==msg.getAvgPx())) return false;
		if ((hasOrdRejReason() && !msg.hasOrdRejReason()) || (!hasOrdRejReason() && msg.hasOrdRejReason())) return false;
		if (!(!hasOrdRejReason() && !msg.hasOrdRejReason()) && !(getOrdRejReason()==msg.getOrdRejReason())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	public FixOrdListStatGrp clone ( FixOrdListStatGrp out ) {
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasSecondaryClOrdID())
			out.setSecondaryClOrdID(getSecondaryClOrdID());
		if ( hasCumQty())
			out.setCumQty(getCumQty());
		if ( hasOrdStatus())
			out.setOrdStatus(getOrdStatus());
		if ( hasWorkingIndicator())
			out.setWorkingIndicator(getWorkingIndicator());
		if ( hasLeavesQty())
			out.setLeavesQty(getLeavesQty());
		if ( hasCxlQty())
			out.setCxlQty(getCxlQty());
		if ( hasAvgPx())
			out.setAvgPx(getAvgPx());
		if ( hasOrdRejReason())
			out.setOrdRejReason(getOrdRejReason());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		return out;
	}

}
