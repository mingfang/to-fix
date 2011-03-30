package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixStreamAssignmentReportACK extends FixInMessage {
	private short hasStreamAsgnAckType;
	long streamAsgnAckType = 0;		
	private short hasStreamAsgnRptID;
	byte[] streamAsgnRptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasStreamAsgnRejReason;
	long streamAsgnRejReason = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	
	public FixStreamAssignmentReportACK() {
		super(FixMessageInfo.MessageTypes.STREAMASSIGNMENTREPORTACK);


		hasStreamAsgnAckType = FixUtils.TAG_HAS_NO_VALUE;		
		hasStreamAsgnRptID = FixUtils.TAG_HAS_NO_VALUE;		
		streamAsgnRptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasStreamAsgnRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.STREAMASGNACKTYPE_INT:		
            		hasStreamAsgnAckType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.STREAMASGNRPTID_INT:		
            		hasStreamAsgnRptID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.STREAMASGNREJREASON_INT:		
            		hasStreamAsgnRejReason = (short) buf.position();		
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

        		if (err.hasError()) return;

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	public boolean hasRequiredTags(FixValidationError err) {
		standardHeader.hasRequiredTags(err); if (err.hasError()) return false; 

		if (!hasStreamAsgnAckType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag StreamAsgnAckType missing", FixTags.STREAMASGNACKTYPE_INT, FixMessageInfo.MessageTypes.STREAMASSIGNMENTREPORTACK);
			return false;
		}
		if (!hasStreamAsgnRptID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag StreamAsgnRptID missing", FixTags.STREAMASGNRPTID_INT, FixMessageInfo.MessageTypes.STREAMASSIGNMENTREPORTACK);
			return false;
		}
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

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

		// if this is the standardHeader for an out-bound message wee need to set default tags
		if (buf == null) {
			super.standardHeader.setBeginString(FixMessageInfo.BEGINSTRING_VALUE);
		}

		super.standardHeader.encode(out);
		if (hasStreamAsgnAckType()) {		
			out.put(FixTags.STREAMASGNACKTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)streamAsgnAckType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasStreamAsgnRptID()) {		
			out.put(FixTags.STREAMASGNRPTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,streamAsgnRptID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasStreamAsgnRejReason()) {		
			out.put(FixTags.STREAMASGNREJREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)streamAsgnRejReason);
		
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
		
		if (hasStreamAsgnAckType()) {		
			FixUtils.put(out, (long)streamAsgnAckType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStreamAsgnRptID()) {		
			FixUtils.put(out,streamAsgnRptID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStreamAsgnRejReason()) {		
			FixUtils.put(out, (long)streamAsgnRejReason);
		
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
		
		super.standardTrailer.encode(out);		
		
		int endPos = out.position();		
		
		// set body length		
				
		super.standardHeader.setBodyLength( out.position() - startPos );		
				
		out.position(startPos + FixUtils.FIX_HEADER); 		
		
		FixUtils.put( out, super.standardHeader.getBodyLength() );		
		
		out.position(endPos);		
		
	}			
			
	public void crackStreamAsgnAckType() {		
		getStreamAsgnAckType();		
	}		
			
	public long getStreamAsgnAckType() { 		
		if ( hasStreamAsgnAckType()) {		
			if (hasStreamAsgnAckType == FixUtils.TAG_HAS_VALUE) {		
				return streamAsgnAckType; 		
			} else {

				buf.position(hasStreamAsgnAckType);

			streamAsgnAckType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasStreamAsgnAckType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return streamAsgnAckType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStreamAsgnAckType() { return hasStreamAsgnAckType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStreamAsgnAckType(byte[] src) {		
		if (src == null ) return;
		if (hasStreamAsgnAckType()) streamAsgnAckType = FixUtils.TAG_HAS_NO_VALUE;		
		streamAsgnAckType = FixUtils.longValueOf(src, 0, src.length);
		hasStreamAsgnAckType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStreamAsgnAckType(long src) {		
		streamAsgnAckType = src;
		hasStreamAsgnAckType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStreamAsgnAckType(String str) {		
		if (str == null ) return;
		if (hasStreamAsgnAckType()) streamAsgnAckType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		streamAsgnAckType = FixUtils.longValueOf(src, 0, src.length);
		hasStreamAsgnAckType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackStreamAsgnRptID() {		
		getStreamAsgnRptID();		
	}		
			
	public byte[] getStreamAsgnRptID() { 		
		if ( hasStreamAsgnRptID()) {		
			if (hasStreamAsgnRptID == FixUtils.TAG_HAS_VALUE) {		
				return streamAsgnRptID; 		
			} else {

				buf.position(hasStreamAsgnRptID);

			FixMessage.getTagStringValue(buf, streamAsgnRptID, 0, streamAsgnRptID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasStreamAsgnRptID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return streamAsgnRptID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStreamAsgnRptID() { return hasStreamAsgnRptID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStreamAsgnRptID(byte[] src) {		
		if (src == null ) return;
		if (hasStreamAsgnRptID()) FixUtils.fillSpace(streamAsgnRptID);		
		FixUtils.copy(streamAsgnRptID, src); 		
		hasStreamAsgnRptID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStreamAsgnRptID(String str) {		
		if (str == null ) return;
		if (hasStreamAsgnRptID()) FixUtils.fillSpace(streamAsgnRptID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(streamAsgnRptID, src); 		
		hasStreamAsgnRptID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackStreamAsgnRejReason() {		
		getStreamAsgnRejReason();		
	}		
			
	public long getStreamAsgnRejReason() { 		
		if ( hasStreamAsgnRejReason()) {		
			if (hasStreamAsgnRejReason == FixUtils.TAG_HAS_VALUE) {		
				return streamAsgnRejReason; 		
			} else {

				buf.position(hasStreamAsgnRejReason);

			streamAsgnRejReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasStreamAsgnRejReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return streamAsgnRejReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStreamAsgnRejReason() { return hasStreamAsgnRejReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStreamAsgnRejReason(byte[] src) {		
		if (src == null ) return;
		if (hasStreamAsgnRejReason()) streamAsgnRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		streamAsgnRejReason = FixUtils.longValueOf(src, 0, src.length);
		hasStreamAsgnRejReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStreamAsgnRejReason(long src) {		
		streamAsgnRejReason = src;
		hasStreamAsgnRejReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStreamAsgnRejReason(String str) {		
		if (str == null ) return;
		if (hasStreamAsgnRejReason()) streamAsgnRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		streamAsgnRejReason = FixUtils.longValueOf(src, 0, src.length);
		hasStreamAsgnRejReason = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackEncodedTextLen() {		
		getEncodedTextLen();		
	}		
			
	public long getEncodedTextLen() { 		
		if ( hasEncodedTextLen()) {		
			if (hasEncodedTextLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedTextLen; 		
			} else {

				buf.position(hasEncodedTextLen);

			encodedTextLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedTextLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedTextLen() { return hasEncodedTextLen != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedTextLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedTextLen(long src) {		
		encodedTextLen = src;
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedTextLen(String str) {		
		if (str == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedText() {		
		getEncodedText();		
	}		
			
	public byte[] getEncodedText() { 		
		if ( hasEncodedText()) {		
			if (hasEncodedText == FixUtils.TAG_HAS_VALUE) {		
				return encodedText; 		
			} else {

				buf.position(hasEncodedText);

			FixMessage.getTagStringValue(buf, encodedText, 0, encodedText.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEncodedText = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedText() { return hasEncodedText != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedText(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedText()) FixUtils.fillSpace(encodedText);		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedText(String str) {		
		if (str == null ) return;
		if (hasEncodedText()) FixUtils.fillSpace(encodedText);		
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

					if (hasStreamAsgnAckType()) s += "StreamAsgnAckType(1503)= " + getStreamAsgnAckType() + "\n" ; 
		if (hasStreamAsgnRptID()) s += "StreamAsgnRptID(1501)= " + new String( FixUtils.trim(getStreamAsgnRptID()) ) + "\n" ; 
		if (hasStreamAsgnRejReason()) s += "StreamAsgnRejReason(1502)= " + getStreamAsgnRejReason() + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStreamAssignmentReportACK)) return false;

		FixStreamAssignmentReportACK msg = (FixStreamAssignmentReportACK) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasStreamAsgnAckType() && !msg.hasStreamAsgnAckType()) || (!hasStreamAsgnAckType() && msg.hasStreamAsgnAckType())) return false;
		if (!(!hasStreamAsgnAckType() && !msg.hasStreamAsgnAckType()) && !(getStreamAsgnAckType()==msg.getStreamAsgnAckType())) return false;
		if ((hasStreamAsgnRptID() && !msg.hasStreamAsgnRptID()) || (!hasStreamAsgnRptID() && msg.hasStreamAsgnRptID())) return false;
		if (!(!hasStreamAsgnRptID() && !msg.hasStreamAsgnRptID()) && !FixUtils.equals(getStreamAsgnRptID(), msg.getStreamAsgnRptID())) return false;
		if ((hasStreamAsgnRejReason() && !msg.hasStreamAsgnRejReason()) || (!hasStreamAsgnRejReason() && msg.hasStreamAsgnRejReason())) return false;
		if (!(!hasStreamAsgnRejReason() && !msg.hasStreamAsgnRejReason()) && !(getStreamAsgnRejReason()==msg.getStreamAsgnRejReason())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixStreamAssignmentReportACK clone () {
		FixStreamAssignmentReportACK out = new FixStreamAssignmentReportACK();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixStreamAssignmentReportACK clone ( FixStreamAssignmentReportACK out ) {
		if ( hasStreamAsgnAckType())
			out.setStreamAsgnAckType(getStreamAsgnAckType());
		if ( hasStreamAsgnRptID())
			out.setStreamAsgnRptID(getStreamAsgnRptID());
		if ( hasStreamAsgnRejReason())
			out.setStreamAsgnRejReason(getStreamAsgnRejReason());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		return out;
	}

}
