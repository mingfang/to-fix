package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixTradingSessionStatusRequest extends FixInMessage {
	private short hasTradSesReqID;
	byte[] tradSesReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketID;
	byte[] marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketSegmentID;
	byte[] marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradSesMethod;
	long tradSesMethod = 0;		
	private short hasTradSesMode;
	long tradSesMode = 0;		
	private short hasSubscriptionRequestType;
	byte subscriptionRequestType = (byte)' ';		
	private short hasSecurityExchange;
	byte[] securityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixTradingSessionStatusRequest() {
		super(FixMessageInfo.MessageTypes.TRADINGSESSIONSTATUSREQUEST);


		hasTradSesReqID = FixUtils.TAG_HAS_NO_VALUE;		
		tradSesReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketID = FixUtils.TAG_HAS_NO_VALUE;		
		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketSegmentID = FixUtils.TAG_HAS_NO_VALUE;		
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradSesMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradSesMode = FixUtils.TAG_HAS_NO_VALUE;		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;		
		securityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.TRADSESREQID_INT:		
            		hasTradSesReqID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MARKETID_INT:		
            		hasMarketID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MARKETSEGMENTID_INT:		
            		hasMarketSegmentID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADINGSESSIONID_INT:		
            		hasTradingSessionID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADINGSESSIONSUBID_INT:		
            		hasTradingSessionSubID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADSESMETHOD_INT:		
            		hasTradSesMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADSESMODE_INT:		
            		hasTradSesMode = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SUBSCRIPTIONREQUESTTYPE_INT:		
            		hasSubscriptionRequestType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYEXCHANGE_INT:		
            		hasSecurityExchange = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	default:
        			if ( standardHeader.isKeyTag(tag)) {
        				tag = standardHeader.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( standardTrailer.isKeyTag(tag)) {
        				tag = standardTrailer.setBuffer( tag, buf, err);
        				if (!err.hasError()) hasRequiredTags(err);
            			return; // always last, we are done now
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.TRADINGSESSIONSTATUSREQUEST_INT);
                			break;
                		}
					}

			}

        		if (err.hasError()) return;

            	tag = FixUtils.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	public boolean hasRequiredTags(FixValidationError err) {
		if (!hasTradSesReqID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRADSESREQID_INT, FixMessageInfo.MessageTypes.TRADINGSESSIONSTATUSREQUEST_INT);
			return false;
		}
		if (!hasSubscriptionRequestType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.SUBSCRIPTIONREQUESTTYPE_INT, FixMessageInfo.MessageTypes.TRADINGSESSIONSTATUSREQUEST_INT);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		getTradSesReqID();		
		getMarketID();		
		getMarketSegmentID();		
		getTradingSessionID();		
		getTradingSessionSubID();		
		getTradSesMethod();		
		getTradSesMode();		
		getSubscriptionRequestType();		
		getSecurityExchange();		
	}		
		
	@Override		
	public int encode(ByteBuffer out) {

		int startPos = out.position();
		super.standardHeader.setBodyLength(1000);

		// if this is the standardHeader for an out-bound message wee need to set default tags
		if (buf == null) {
			super.standardHeader.setBeginString(FixMessageInfo.BEGINSTRING_VALUE);
		}

		super.standardHeader.encode(out);
		if (hasTradSesReqID()) {		
			out.put(FixTags.TRADSESREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradSesReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarketID()) {		
			out.put(FixTags.MARKETID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,marketID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarketSegmentID()) {		
			out.put(FixTags.MARKETSEGMENTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,marketSegmentID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradingSessionID()) {		
			out.put(FixTags.TRADINGSESSIONID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradingSessionID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradingSessionSubID()) {		
			out.put(FixTags.TRADINGSESSIONSUBID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradingSessionSubID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradSesMethod()) {		
			out.put(FixTags.TRADSESMETHOD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)tradSesMethod);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradSesMode()) {		
			out.put(FixTags.TRADSESMODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)tradSesMode);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSubscriptionRequestType()) {		
			out.put(FixTags.SUBSCRIPTIONREQUESTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,subscriptionRequestType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityExchange()) {		
			out.put(FixTags.SECURITYEXCHANGE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,securityExchange); 		
		
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
		FixUtils.fill(tmpCheckSum, (byte)'0');
		FixUtils.generateCheckSum(tmpCheckSum, out, startPos + FixUtils.FIX_MESSAGE_START, endPos);
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
		
		if (hasTradSesReqID()) {		
			FixUtils.put(out,tradSesReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketID()) {		
			FixUtils.put(out,marketID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketSegmentID()) {		
			FixUtils.put(out,marketSegmentID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionID()) {		
			FixUtils.put(out,tradingSessionID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionSubID()) {		
			FixUtils.put(out,tradingSessionSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradSesMethod()) {		
			FixUtils.put(out, (long)tradSesMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradSesMode()) {		
			FixUtils.put(out, (long)tradSesMode);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSubscriptionRequestType()) {		
			FixUtils.put(out,subscriptionRequestType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityExchange()) {		
			FixUtils.put(out,securityExchange); 		
		
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
			
	public void crackTradSesReqID() {		
		getTradSesReqID();		
	}		
			
	public byte[] getTradSesReqID() { 		
		if ( hasTradSesReqID()) {		
			if (hasTradSesReqID == FixUtils.TAG_HAS_VALUE) {		
				return tradSesReqID; 		
			} else {

				buf.position(hasTradSesReqID);

			FixUtils.getTagStringValue(buf, tradSesReqID, 0, tradSesReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradSesReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradSesReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradSesReqID() { return hasTradSesReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradSesReqID(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesReqID()) FixUtils.fillNul(tradSesReqID);		
		FixUtils.copy(tradSesReqID, src); 		
		hasTradSesReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradSesReqID(String str) {		
		if (str == null ) return;
		if (hasTradSesReqID()) FixUtils.fillNul(tradSesReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradSesReqID, src); 		
		hasTradSesReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMarketID() {		
		getMarketID();		
	}		
			
	public byte[] getMarketID() { 		
		if ( hasMarketID()) {		
			if (hasMarketID == FixUtils.TAG_HAS_VALUE) {		
				return marketID; 		
			} else {

				buf.position(hasMarketID);

			FixUtils.getTagStringValue(buf, marketID, 0, marketID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMarketID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return marketID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMarketID() { return hasMarketID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMarketID(byte[] src) {		
		if (src == null ) return;
		if (hasMarketID()) FixUtils.fillNul(marketID);		
		FixUtils.copy(marketID, src); 		
		hasMarketID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketID(String str) {		
		if (str == null ) return;
		if (hasMarketID()) FixUtils.fillNul(marketID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketID, src); 		
		hasMarketID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMarketSegmentID() {		
		getMarketSegmentID();		
	}		
			
	public byte[] getMarketSegmentID() { 		
		if ( hasMarketSegmentID()) {		
			if (hasMarketSegmentID == FixUtils.TAG_HAS_VALUE) {		
				return marketSegmentID; 		
			} else {

				buf.position(hasMarketSegmentID);

			FixUtils.getTagStringValue(buf, marketSegmentID, 0, marketSegmentID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return marketSegmentID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMarketSegmentID() { return hasMarketSegmentID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMarketSegmentID(byte[] src) {		
		if (src == null ) return;
		if (hasMarketSegmentID()) FixUtils.fillNul(marketSegmentID);		
		FixUtils.copy(marketSegmentID, src); 		
		hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketSegmentID(String str) {		
		if (str == null ) return;
		if (hasMarketSegmentID()) FixUtils.fillNul(marketSegmentID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketSegmentID, src); 		
		hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradingSessionID() {		
		getTradingSessionID();		
	}		
			
	public byte[] getTradingSessionID() { 		
		if ( hasTradingSessionID()) {		
			if (hasTradingSessionID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionID; 		
			} else {

				buf.position(hasTradingSessionID);

			FixUtils.getTagStringValue(buf, tradingSessionID, 0, tradingSessionID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradingSessionID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionID() { return hasTradingSessionID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradingSessionID(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionID()) FixUtils.fillNul(tradingSessionID);		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradingSessionID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionID()) FixUtils.fillNul(tradingSessionID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradingSessionSubID() {		
		getTradingSessionSubID();		
	}		
			
	public byte[] getTradingSessionSubID() { 		
		if ( hasTradingSessionSubID()) {		
			if (hasTradingSessionSubID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionSubID; 		
			} else {

				buf.position(hasTradingSessionSubID);

			FixUtils.getTagStringValue(buf, tradingSessionSubID, 0, tradingSessionSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradingSessionSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionSubID() { return hasTradingSessionSubID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradingSessionSubID(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillNul(tradingSessionSubID);		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradingSessionSubID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillNul(tradingSessionSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradSesMethod() {		
		getTradSesMethod();		
	}		
			
	public long getTradSesMethod() { 		
		if ( hasTradSesMethod()) {		
			if (hasTradSesMethod == FixUtils.TAG_HAS_VALUE) {		
				return tradSesMethod; 		
			} else {

				buf.position(hasTradSesMethod);

			tradSesMethod = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTradSesMethod = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradSesMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradSesMethod() { return hasTradSesMethod != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradSesMethod(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesMethod()) tradSesMethod = FixUtils.TAG_HAS_NO_VALUE;		
		tradSesMethod = FixUtils.longValueOf(src, 0, src.length);
		hasTradSesMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradSesMethod(long src) {		
		tradSesMethod = src;
		hasTradSesMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradSesMethod(String str) {		
		if (str == null ) return;
		if (hasTradSesMethod()) tradSesMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradSesMethod = FixUtils.longValueOf(src, 0, src.length);
		hasTradSesMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradSesMode() {		
		getTradSesMode();		
	}		
			
	public long getTradSesMode() { 		
		if ( hasTradSesMode()) {		
			if (hasTradSesMode == FixUtils.TAG_HAS_VALUE) {		
				return tradSesMode; 		
			} else {

				buf.position(hasTradSesMode);

			tradSesMode = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTradSesMode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradSesMode;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradSesMode() { return hasTradSesMode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradSesMode(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesMode()) tradSesMode = FixUtils.TAG_HAS_NO_VALUE;		
		tradSesMode = FixUtils.longValueOf(src, 0, src.length);
		hasTradSesMode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradSesMode(long src) {		
		tradSesMode = src;
		hasTradSesMode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradSesMode(String str) {		
		if (str == null ) return;
		if (hasTradSesMode()) tradSesMode = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradSesMode = FixUtils.longValueOf(src, 0, src.length);
		hasTradSesMode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSubscriptionRequestType() {		
		getSubscriptionRequestType();		
	}		
			
	public byte getSubscriptionRequestType() { 		
		if ( hasSubscriptionRequestType()) {		
			if (hasSubscriptionRequestType == FixUtils.TAG_HAS_VALUE) {		
				return subscriptionRequestType; 		
			} else {

				buf.position(hasSubscriptionRequestType);

			subscriptionRequestType = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (subscriptionRequestType != (byte)'2') && (subscriptionRequestType != (byte)'1') && (subscriptionRequestType != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 263);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return subscriptionRequestType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSubscriptionRequestType() { return hasSubscriptionRequestType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSubscriptionRequestType(byte[] src) {		
		if (src == null ) return;
		if (hasSubscriptionRequestType()) subscriptionRequestType = (byte)' ';		
		subscriptionRequestType = src[0];		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSubscriptionRequestType(byte src) {		
		subscriptionRequestType = src;
		hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSubscriptionRequestType(String str) {		
		if (str == null ) return;
		if (hasSubscriptionRequestType()) subscriptionRequestType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		subscriptionRequestType = src[0];		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityExchange() {		
		getSecurityExchange();		
	}		
			
	public byte[] getSecurityExchange() { 		
		if ( hasSecurityExchange()) {		
			if (hasSecurityExchange == FixUtils.TAG_HAS_VALUE) {		
				return securityExchange; 		
			} else {

				buf.position(hasSecurityExchange);

			FixUtils.getTagStringValue(buf, securityExchange, 0, securityExchange.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecurityExchange = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityExchange;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityExchange() { return hasSecurityExchange != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityExchange(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityExchange()) FixUtils.fillNul(securityExchange);		
		FixUtils.copy(securityExchange, src); 		
		hasSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityExchange(String str) {		
		if (str == null ) return;
		if (hasSecurityExchange()) FixUtils.fillNul(securityExchange);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityExchange, src); 		
		hasSecurityExchange = FixUtils.TAG_HAS_VALUE;		
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
		if (standardHeader.hasApplVerID()) s += "ApplVerID(1128)= " + new String( FixUtils.trim(standardHeader.getApplVerID()) ) + "\n" ; 
		if (standardHeader.hasCstmApplVerID()) s += "CstmApplVerID(1129)= " + new String( FixUtils.trim(standardHeader.getCstmApplVerID()) ) + "\n" ; 
		if (standardHeader.hasApplExtID()) s += "ApplExtID(1156)= " + standardHeader.getApplExtID() + "\n" ; 
		if (standardHeader.hasSenderCompID()) s += "SenderCompID(49)= " + new String( FixUtils.trim(standardHeader.getSenderCompID()) ) + "\n" ; 
		if (standardHeader.hasTargetCompID()) s += "TargetCompID(56)= " + new String( FixUtils.trim(standardHeader.getTargetCompID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfCompID()) s += "OnBehalfOfCompID(115)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfCompID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToCompID()) s += "DeliverToCompID(128)= " + new String( FixUtils.trim(standardHeader.getDeliverToCompID()) ) + "\n" ; 
		if (standardHeader.hasSecureDataLen()) s += "SecureDataLen(90)= " + standardHeader.getSecureDataLen() + "\n" ; 
		if (standardHeader.hasSecureData()) s += "SecureData(91)= " + new String( FixUtils.trim(standardHeader.getSecureData()) ) + "\n" ; 
		if (standardHeader.hasMsgSeqNum()) s += "MsgSeqNum(34)= " + standardHeader.getMsgSeqNum() + "\n" ; 
		if (standardHeader.hasSenderSubID()) s += "SenderSubID(50)= " + new String( FixUtils.trim(standardHeader.getSenderSubID()) ) + "\n" ; 
		if (standardHeader.hasSenderLocationID()) s += "SenderLocationID(142)= " + new String( FixUtils.trim(standardHeader.getSenderLocationID()) ) + "\n" ; 
		if (standardHeader.hasTargetSubID()) s += "TargetSubID(57)= " + new String( FixUtils.trim(standardHeader.getTargetSubID()) ) + "\n" ; 
		if (standardHeader.hasTargetLocationID()) s += "TargetLocationID(143)= " + new String( FixUtils.trim(standardHeader.getTargetLocationID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfSubID()) s += "OnBehalfOfSubID(116)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfSubID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfLocationID()) s += "OnBehalfOfLocationID(144)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfLocationID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToSubID()) s += "DeliverToSubID(129)= " + new String( FixUtils.trim(standardHeader.getDeliverToSubID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToLocationID()) s += "DeliverToLocationID(145)= " + new String( FixUtils.trim(standardHeader.getDeliverToLocationID()) ) + "\n" ; 
		if (standardHeader.hasPossDupFlag()) s += "PossDupFlag(43)= " + standardHeader.getPossDupFlag() + "\n" ; 
		if (standardHeader.hasPossResend()) s += "PossResend(97)= " + standardHeader.getPossResend() + "\n" ; 
		if (standardHeader.hasSendingTime()) s += "SendingTime(52)= " + new String( FixUtils.trim(standardHeader.getSendingTime()) ) + "\n" ; 
		if (standardHeader.hasOrigSendingTime()) s += "OrigSendingTime(122)= " + new String( FixUtils.trim(standardHeader.getOrigSendingTime()) ) + "\n" ; 
		if (standardHeader.hasXmlDataLen()) s += "XmlDataLen(212)= " + standardHeader.getXmlDataLen() + "\n" ; 
		if (standardHeader.hasXmlData()) s += "XmlData(213)= " + new String( FixUtils.trim(standardHeader.getXmlData()) ) + "\n" ; 
		if (standardHeader.hasMessageEncoding()) s += "MessageEncoding(347)= " + new String( FixUtils.trim(standardHeader.getMessageEncoding()) ) + "\n" ; 
		if (standardHeader.hasLastMsgSeqNumProcessed()) s += "LastMsgSeqNumProcessed(369)= " + standardHeader.getLastMsgSeqNumProcessed() + "\n" ; 

					if (hasTradSesReqID()) s += "TradSesReqID(335)= " + new String( FixUtils.trim(getTradSesReqID()) ) + "\n" ; 
		if (hasMarketID()) s += "MarketID(1301)= " + new String( FixUtils.trim(getMarketID()) ) + "\n" ; 
		if (hasMarketSegmentID()) s += "MarketSegmentID(1300)= " + new String( FixUtils.trim(getMarketSegmentID()) ) + "\n" ; 
		if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 
		if (hasTradSesMethod()) s += "TradSesMethod(338)= " + getTradSesMethod() + "\n" ; 
		if (hasTradSesMode()) s += "TradSesMode(339)= " + getTradSesMode() + "\n" ; 
		if (hasSubscriptionRequestType()) s += "SubscriptionRequestType(263)= " + getSubscriptionRequestType() + "\n" ; 
		if (hasSecurityExchange()) s += "SecurityExchange(207)= " + new String( FixUtils.trim(getSecurityExchange()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTradingSessionStatusRequest)) return false;

		FixTradingSessionStatusRequest msg = (FixTradingSessionStatusRequest) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasTradSesReqID() && !msg.hasTradSesReqID()) || (!hasTradSesReqID() && msg.hasTradSesReqID())) return false;
		if (!(!hasTradSesReqID() && !msg.hasTradSesReqID()) && !FixUtils.equals(getTradSesReqID(), msg.getTradSesReqID())) return false;
		if ((hasMarketID() && !msg.hasMarketID()) || (!hasMarketID() && msg.hasMarketID())) return false;
		if (!(!hasMarketID() && !msg.hasMarketID()) && !FixUtils.equals(getMarketID(), msg.getMarketID())) return false;
		if ((hasMarketSegmentID() && !msg.hasMarketSegmentID()) || (!hasMarketSegmentID() && msg.hasMarketSegmentID())) return false;
		if (!(!hasMarketSegmentID() && !msg.hasMarketSegmentID()) && !FixUtils.equals(getMarketSegmentID(), msg.getMarketSegmentID())) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		if ((hasTradSesMethod() && !msg.hasTradSesMethod()) || (!hasTradSesMethod() && msg.hasTradSesMethod())) return false;
		if (!(!hasTradSesMethod() && !msg.hasTradSesMethod()) && !(getTradSesMethod()==msg.getTradSesMethod())) return false;
		if ((hasTradSesMode() && !msg.hasTradSesMode()) || (!hasTradSesMode() && msg.hasTradSesMode())) return false;
		if (!(!hasTradSesMode() && !msg.hasTradSesMode()) && !(getTradSesMode()==msg.getTradSesMode())) return false;
		if ((hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) || (!hasSubscriptionRequestType() && msg.hasSubscriptionRequestType())) return false;
		if (!(!hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) && !(getSubscriptionRequestType()==msg.getSubscriptionRequestType())) return false;
		if ((hasSecurityExchange() && !msg.hasSecurityExchange()) || (!hasSecurityExchange() && msg.hasSecurityExchange())) return false;
		if (!(!hasSecurityExchange() && !msg.hasSecurityExchange()) && !FixUtils.equals(getSecurityExchange(), msg.getSecurityExchange())) return false;
		return true;
	}
	@Override
	public FixTradingSessionStatusRequest clone () {
		FixTradingSessionStatusRequest out = new FixTradingSessionStatusRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixTradingSessionStatusRequest clone ( FixTradingSessionStatusRequest out ) {
		if ( hasTradSesReqID())
			out.setTradSesReqID(getTradSesReqID());
		if ( hasMarketID())
			out.setMarketID(getMarketID());
		if ( hasMarketSegmentID())
			out.setMarketSegmentID(getMarketSegmentID());
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		if ( hasTradSesMethod())
			out.setTradSesMethod(getTradSesMethod());
		if ( hasTradSesMode())
			out.setTradSesMode(getTradSesMode());
		if ( hasSubscriptionRequestType())
			out.setSubscriptionRequestType(getSubscriptionRequestType());
		if ( hasSecurityExchange())
			out.setSecurityExchange(getSecurityExchange());
		return out;
	}

}
