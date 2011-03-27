package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixOrderCancelReject extends FixInMessage {
	private short hasClOrdID;
	byte[] clOrdID = new byte[20];		
	private short hasOrderID;
	byte[] orderID = new byte[32];		
	private short hasOrdStatus;
	byte ordStatus = (byte)' ';		
	private short hasOrigClOrdID;
	byte[] origClOrdID = new byte[20];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasCxlRejReason;
	long cxlRejReason = 0;		
	private short hasClientID;
	byte[] clientID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCxlRejResponseTo;
	byte cxlRejResponseTo = (byte)' ';		
	
	public FixOrderCancelReject() {
		super(FixMessageInfo.MessageTypes.ORDERCANCELREJECT);


		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[20];		
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[32];		
		hasOrdStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrigClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		origClOrdID = new byte[20];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasCxlRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasClientID = FixUtils.TAG_HAS_NO_VALUE;		
		clientID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCxlRejResponseTo = FixUtils.TAG_HAS_NO_VALUE;		

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

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
            	case FixTags.ORDSTATUS_INT:		
            		hasOrdStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORIGCLORDID_INT:		
            		hasOrigClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TEXT_INT:		
            		hasText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CXLREJREASON_INT:		
            		hasCxlRejReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLIENTID_INT:		
            		hasClientID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CXLREJRESPONSETO_INT:		
            		hasCxlRejResponseTo = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	default:
        			if ( standardHeader.isKeyTag(tag)) {
        				tag = standardHeader.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( standardTrailer.isKeyTag(tag)) {
        				tag = standardTrailer.setBuffer( tag, buf, err);
        				FixMessage.unreadLastTag(tag, buf);
        				if (!err.hasError()) hasRequiredTags(err);
            			return; // always last, we are done now
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else break; //Ugha
					}

			}

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	private boolean hasRequiredTags(FixValidationError err) {
		if (!hasClOrdID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ClOrdID missing", FixTags.CLORDID_INT, FixMessageInfo.MessageTypes.ORDERCANCELREJECT);
			return false;
		}
		if (!hasOrderID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag OrderID missing", FixTags.ORDERID_INT, FixMessageInfo.MessageTypes.ORDERCANCELREJECT);
			return false;
		}
		if (!hasOrdStatus()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag OrdStatus missing", FixTags.ORDSTATUS_INT, FixMessageInfo.MessageTypes.ORDERCANCELREJECT);
			return false;
		}
		if (!hasOrigClOrdID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag OrigClOrdID missing", FixTags.ORIGCLORDID_INT, FixMessageInfo.MessageTypes.ORDERCANCELREJECT);
			return false;
		}
		if (!hasClientID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ClientID missing", FixTags.CLIENTID_INT, FixMessageInfo.MessageTypes.ORDERCANCELREJECT);
			return false;
		}
		if (!hasCxlRejResponseTo()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag CxlRejResponseTo missing", FixTags.CXLREJRESPONSETO_INT, FixMessageInfo.MessageTypes.ORDERCANCELREJECT);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		/* not needed, just for the inet dudes recognition */		
	}		
		
	@Override		
	public int encode(ByteBuffer out) {

		int startPos = out.position();
		super.standardHeader.setBodyLength(1000);

		super.standardHeader.encode(out);		
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
		if (hasOrdStatus()) {		
			out.put(FixTags.ORDSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,ordStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrigClOrdID()) {		
			out.put(FixTags.ORIGCLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,origClOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasText()) {		
			out.put(FixTags.TEXT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,text); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCxlRejReason()) {		
			out.put(FixTags.CXLREJREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)cxlRejReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClientID()) {		
			out.put(FixTags.CLIENTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clientID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCxlRejResponseTo()) {		
			out.put(FixTags.CXLREJRESPONSETO);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,cxlRejResponseTo); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		// set body length

		int endPos = out.position();

		super.standardHeader.setBodyLength(endPos - FixUtils.FIX_MESSAGE_START);

		out.position(startPos + FixUtils.FIX_HEADER);

		if (super.standardHeader.getBodyLength()>999) {
			FixUtils.put(out, super.standardHeader.getBodyLength());
		} else if (super.standardHeader.getBodyLength()>99) {
			FixUtils.put(out, 0);
			FixUtils.put(out, super.standardHeader.getBodyLength());
		} else {
			FixUtils.put(out, 0);
			FixUtils.put(out, 0);
			FixUtils.put(out, super.standardHeader.getBodyLength());
		}
		final byte[] tmpCheckSum = new byte[FixTags.CHECKSUM_LENGTH];
		FixUtils.generateCheckSum(tmpCheckSum, out, startPos, endPos);
		super.standardTrailer.setCheckSum(tmpCheckSum);

		out.position(endPos);

		super.standardTrailer.encode(out);
		out.limit(out.position());
		out.flip();

		return (int) super.standardHeader.getBodyLength();

	}			
			
			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		int startPos = out.position();		
					
		super.standardHeader.encode(out);		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderID()) {		
			FixUtils.put(out,orderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdStatus()) {		
			FixUtils.put(out,ordStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigClOrdID()) {		
			FixUtils.put(out,origClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasText()) {		
			FixUtils.put(out,text); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCxlRejReason()) {		
			FixUtils.put(out, (long)cxlRejReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClientID()) {		
			FixUtils.put(out,clientID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCxlRejResponseTo()) {		
			FixUtils.put(out,cxlRejResponseTo); 		
		
	        out.put( (byte)' ' );		
		}		
		
		super.standardTrailer.encode(out);		
		
		int endPos = out.position();		
		
		// set body length		
				
		super.standardHeader.setBodyLength( out.position() - startPos );		
				
		out.position(startPos + FixUtils.FIX_HEADER); 		
		
		FixUtils.put( out, super.standardHeader.getBodyLength() );		
		
		out.position(endPos);		
		
	}			
			
	public void crackClOrdID() {		
		getClOrdID();		
	}		
			
	public byte[] getClOrdID() { 		
		if ( hasClOrdID()) {		
			if (hasClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return clOrdID; 		
			} else {

				buf.position(hasClOrdID);

			FixMessage.getTagStringValue(buf, clOrdID, 0, clOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClOrdID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
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
			
	public void crackOrderID() {		
		getOrderID();		
	}		
			
	public byte[] getOrderID() { 		
		if ( hasOrderID()) {		
			if (hasOrderID == FixUtils.TAG_HAS_VALUE) {		
				return orderID; 		
			} else {

				buf.position(hasOrderID);

			FixMessage.getTagStringValue(buf, orderID, 0, orderID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrderID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
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
			
	public void crackOrdStatus() {		
		getOrdStatus();		
	}		
			
	public byte getOrdStatus() { 		
		if ( hasOrdStatus()) {		
			if (hasOrdStatus == FixUtils.TAG_HAS_VALUE) {		
				return ordStatus; 		
			} else {

				buf.position(hasOrdStatus);

			ordStatus = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (ordStatus != (byte)'2') && (ordStatus != (byte)'1') && (ordStatus != (byte)'0') && (ordStatus != (byte)'6') && (ordStatus != (byte)'5') && (ordStatus != (byte)'4') && (ordStatus != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 39);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return ordStatus;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrdStatus() { return hasOrdStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrdStatus(byte[] src) {		
		if (src == null ) return;
		if (hasOrdStatus()) ordStatus = (byte)' ';		
		ordStatus = src[0];		
		hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdStatus(byte src) {		
		ordStatus = src;
		hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdStatus(String str) {		
		if (str == null ) return;
		if (hasOrdStatus()) ordStatus = (byte)' ';		
		byte[] src = str.getBytes(); 		
		ordStatus = src[0];		
		hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrigClOrdID() {		
		getOrigClOrdID();		
	}		
			
	public byte[] getOrigClOrdID() { 		
		if ( hasOrigClOrdID()) {		
			if (hasOrigClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return origClOrdID; 		
			} else {

				buf.position(hasOrigClOrdID);

			FixMessage.getTagStringValue(buf, origClOrdID, 0, origClOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return origClOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigClOrdID() { return hasOrigClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrigClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasOrigClOrdID()) FixUtils.fillSpace(origClOrdID);		
		FixUtils.copy(origClOrdID, src); 		
		hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigClOrdID(String str) {		
		if (str == null ) return;
		if (hasOrigClOrdID()) FixUtils.fillSpace(origClOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origClOrdID, src); 		
		hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackText() {		
		getText();		
	}		
			
	public byte[] getText() { 		
		if ( hasText()) {		
			if (hasText == FixUtils.TAG_HAS_VALUE) {		
				return text; 		
			} else {

				buf.position(hasText);

			FixMessage.getTagStringValue(buf, text, 0, text.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasText = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return text;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasText() { return hasText != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setText(byte[] src) {		
		if (src == null ) return;
		if (hasText()) FixUtils.fillSpace(text);		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setText(String str) {		
		if (str == null ) return;
		if (hasText()) FixUtils.fillSpace(text);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCxlRejReason() {		
		getCxlRejReason();		
	}		
			
	public long getCxlRejReason() { 		
		if ( hasCxlRejReason()) {		
			if (hasCxlRejReason == FixUtils.TAG_HAS_VALUE) {		
				return cxlRejReason; 		
			} else {

				buf.position(hasCxlRejReason);

			cxlRejReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCxlRejReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return cxlRejReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCxlRejReason() { return hasCxlRejReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCxlRejReason(byte[] src) {		
		if (src == null ) return;
		if (hasCxlRejReason()) cxlRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		cxlRejReason = FixUtils.longValueOf(src, 0, src.length);
		hasCxlRejReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCxlRejReason(long src) {		
		cxlRejReason = src;
		hasCxlRejReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCxlRejReason(String str) {		
		if (str == null ) return;
		if (hasCxlRejReason()) cxlRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		cxlRejReason = FixUtils.longValueOf(src, 0, src.length);
		hasCxlRejReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClientID() {		
		getClientID();		
	}		
			
	public byte[] getClientID() { 		
		if ( hasClientID()) {		
			if (hasClientID == FixUtils.TAG_HAS_VALUE) {		
				return clientID; 		
			} else {

				buf.position(hasClientID);

			FixMessage.getTagStringValue(buf, clientID, 0, clientID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClientID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clientID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClientID() { return hasClientID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClientID(byte[] src) {		
		if (src == null ) return;
		if (hasClientID()) FixUtils.fillSpace(clientID);		
		FixUtils.copy(clientID, src); 		
		hasClientID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClientID(String str) {		
		if (str == null ) return;
		if (hasClientID()) FixUtils.fillSpace(clientID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clientID, src); 		
		hasClientID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCxlRejResponseTo() {		
		getCxlRejResponseTo();		
	}		
			
	public byte getCxlRejResponseTo() { 		
		if ( hasCxlRejResponseTo()) {		
			if (hasCxlRejResponseTo == FixUtils.TAG_HAS_VALUE) {		
				return cxlRejResponseTo; 		
			} else {

				buf.position(hasCxlRejResponseTo);

			cxlRejResponseTo = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (cxlRejResponseTo != (byte)'2') && (cxlRejResponseTo != (byte)'1') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 434);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasCxlRejResponseTo = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return cxlRejResponseTo;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasCxlRejResponseTo() { return hasCxlRejResponseTo != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCxlRejResponseTo(byte[] src) {		
		if (src == null ) return;
		if (hasCxlRejResponseTo()) cxlRejResponseTo = (byte)' ';		
		cxlRejResponseTo = src[0];		
		hasCxlRejResponseTo = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCxlRejResponseTo(byte src) {		
		cxlRejResponseTo = src;
		hasCxlRejResponseTo = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCxlRejResponseTo(String str) {		
		if (str == null ) return;
		if (hasCxlRejResponseTo()) cxlRejResponseTo = (byte)' ';		
		byte[] src = str.getBytes(); 		
		cxlRejResponseTo = src[0];		
		hasCxlRejResponseTo = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		try {
					if (standardHeader.hasBeginString()) s += "BeginString(8)= " + new String( FixUtils.trim(standardHeader.getBeginString()) ) + "\n" ; 
		if (standardHeader.hasBodyLength()) s += "BodyLength(9)= " + standardHeader.getBodyLength() + "\n" ; 
		if (standardHeader.hasMsgType()) s += "MsgType(35)= " + new String( FixUtils.trim(standardHeader.getMsgType()) ) + "\n" ; 
		if (standardHeader.hasMsgSeqNum()) s += "MsgSeqNum(34)= " + standardHeader.getMsgSeqNum() + "\n" ; 
		if (standardHeader.hasPossDupFlag()) s += "PossDupFlag(43)= " + standardHeader.getPossDupFlag() + "\n" ; 
		if (standardHeader.hasSenderCompID()) s += "SenderCompID(49)= " + new String( FixUtils.trim(standardHeader.getSenderCompID()) ) + "\n" ; 
		if (standardHeader.hasSenderSubID()) s += "SenderSubID(50)= " + new String( FixUtils.trim(standardHeader.getSenderSubID()) ) + "\n" ; 
		if (standardHeader.hasSendingTime()) s += "SendingTime(52)= " + new String( FixUtils.trim(standardHeader.getSendingTime()) ) + "\n" ; 
		if (standardHeader.hasTargetCompID()) s += "TargetCompID(56)= " + new String( FixUtils.trim(standardHeader.getTargetCompID()) ) + "\n" ; 
		if (standardHeader.hasTargetSubID()) s += "TargetSubID(57)= " + new String( FixUtils.trim(standardHeader.getTargetSubID()) ) + "\n" ; 
		if (standardHeader.hasPossResend()) s += "PossResend(97)= " + standardHeader.getPossResend() + "\n" ; 
		if (standardHeader.hasOnBehalfOfCompID()) s += "OnBehalfOfCompID(115)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfCompID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfSubID()) s += "OnBehalfOfSubID(116)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfSubID()) ) + "\n" ; 
		if (standardHeader.hasOrigSendingTime()) s += "OrigSendingTime(122)= " + new String( FixUtils.trim(standardHeader.getOrigSendingTime()) ) + "\n" ; 
		if (standardHeader.hasDeliverToCompID()) s += "DeliverToCompID(128)= " + new String( FixUtils.trim(standardHeader.getDeliverToCompID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToSubID()) s += "DeliverToSubID(129)= " + new String( FixUtils.trim(standardHeader.getDeliverToSubID()) ) + "\n" ; 

					if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasOrderID()) s += "OrderID(37)= " + new String( FixUtils.trim(getOrderID()) ) + "\n" ; 
		if (hasOrdStatus()) s += "OrdStatus(39)= " + getOrdStatus() + "\n" ; 
		if (hasOrigClOrdID()) s += "OrigClOrdID(41)= " + new String( FixUtils.trim(getOrigClOrdID()) ) + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasCxlRejReason()) s += "CxlRejReason(102)= " + getCxlRejReason() + "\n" ; 
		if (hasClientID()) s += "ClientID(109)= " + new String( FixUtils.trim(getClientID()) ) + "\n" ; 
		if (hasCxlRejResponseTo()) s += "CxlRejResponseTo(434)= " + getCxlRejResponseTo() + "\n" ; 

					if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixOrderCancelReject)) return false;

		FixOrderCancelReject msg = (FixOrderCancelReject) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasOrdStatus() && !msg.hasOrdStatus()) || (!hasOrdStatus() && msg.hasOrdStatus())) return false;
		if (!(!hasOrdStatus() && !msg.hasOrdStatus()) && !(getOrdStatus()==msg.getOrdStatus())) return false;
		if ((hasOrigClOrdID() && !msg.hasOrigClOrdID()) || (!hasOrigClOrdID() && msg.hasOrigClOrdID())) return false;
		if (!(!hasOrigClOrdID() && !msg.hasOrigClOrdID()) && !FixUtils.equals(getOrigClOrdID(), msg.getOrigClOrdID())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasCxlRejReason() && !msg.hasCxlRejReason()) || (!hasCxlRejReason() && msg.hasCxlRejReason())) return false;
		if (!(!hasCxlRejReason() && !msg.hasCxlRejReason()) && !(getCxlRejReason()==msg.getCxlRejReason())) return false;
		if ((hasClientID() && !msg.hasClientID()) || (!hasClientID() && msg.hasClientID())) return false;
		if (!(!hasClientID() && !msg.hasClientID()) && !FixUtils.equals(getClientID(), msg.getClientID())) return false;
		if ((hasCxlRejResponseTo() && !msg.hasCxlRejResponseTo()) || (!hasCxlRejResponseTo() && msg.hasCxlRejResponseTo())) return false;
		if (!(!hasCxlRejResponseTo() && !msg.hasCxlRejResponseTo()) && !(getCxlRejResponseTo()==msg.getCxlRejResponseTo())) return false;
		return true;
	}
	@Override
	public FixOrderCancelReject clone () {
		FixOrderCancelReject out = new FixOrderCancelReject();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixOrderCancelReject clone ( FixOrderCancelReject out ) {
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasOrdStatus())
			out.setOrdStatus(getOrdStatus());
		if ( hasOrigClOrdID())
			out.setOrigClOrdID(getOrigClOrdID());
		if ( hasText())
			out.setText(getText());
		if ( hasCxlRejReason())
			out.setCxlRejReason(getCxlRejReason());
		if ( hasClientID())
			out.setClientID(getClientID());
		if ( hasCxlRejResponseTo())
			out.setCxlRejResponseTo(getCxlRejResponseTo());
		return out;
	}

}
