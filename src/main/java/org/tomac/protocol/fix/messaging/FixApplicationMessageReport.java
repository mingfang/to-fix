package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixApplicationMessageReport extends FixInMessage {
	private short hasApplReportID;
	byte[] applReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasApplReqID;
	byte[] applReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasApplReportType;
	long applReportType = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixApplIDReportGrp[] applIDReportGrp;
	
	public FixApplicationMessageReport() {
		super(FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREPORT);


		hasApplReportID = FixUtils.TAG_HAS_NO_VALUE;		
		applReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasApplReqID = FixUtils.TAG_HAS_NO_VALUE;		
		applReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasApplReportType = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		applIDReportGrp = new FixApplIDReportGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) applIDReportGrp[i] = new FixApplIDReportGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.APPLREPORTID_INT:		
            		hasApplReportID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.APPLREQID_INT:		
            		hasApplReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.APPLREPORTTYPE_INT:		
            		hasApplReportType = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOAPPLIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !applIDReportGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = applIDReportGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
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

		if (!hasApplReportID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ApplReportID missing", FixTags.APPLREPORTID_INT, FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREPORT);
			return false;
		}
		if (!hasApplReportType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ApplReportType missing", FixTags.APPLREPORTTYPE_INT, FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREPORT);
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
		if (hasApplReportID()) {		
			out.put(FixTags.APPLREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,applReportID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasApplReqID()) {		
			out.put(FixTags.APPLREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,applReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasApplReportType()) {		
			out.put(FixTags.APPLREPORTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)applReportType);
		
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
		
		if (FixUtils.getNoInGroup(applIDReportGrp)>0) {
			out.put(FixTags.NOAPPLIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(applIDReportGrp));

			out.put(FixUtils.SOH);

		}
		for (FixApplIDReportGrp fixApplIDReportGrp : applIDReportGrp) if (fixApplIDReportGrp.hasGroup()) fixApplIDReportGrp.encode(out);
		
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
		
		if (hasApplReportID()) {		
			FixUtils.put(out,applReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplReqID()) {		
			FixUtils.put(out,applReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplReportType()) {		
			FixUtils.put(out, (long)applReportType);
		
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
			
	public void crackApplReportID() {		
		getApplReportID();		
	}		
			
	public byte[] getApplReportID() { 		
		if ( hasApplReportID()) {		
			if (hasApplReportID == FixUtils.TAG_HAS_VALUE) {		
				return applReportID; 		
			} else {

				buf.position(hasApplReportID);

			FixMessage.getTagStringValue(buf, applReportID, 0, applReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasApplReportID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return applReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasApplReportID() { return hasApplReportID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setApplReportID(byte[] src) {		
		if (src == null ) return;
		if (hasApplReportID()) FixUtils.fillNul(applReportID);		
		FixUtils.copy(applReportID, src); 		
		hasApplReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplReportID(String str) {		
		if (str == null ) return;
		if (hasApplReportID()) FixUtils.fillNul(applReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(applReportID, src); 		
		hasApplReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackApplReqID() {		
		getApplReqID();		
	}		
			
	public byte[] getApplReqID() { 		
		if ( hasApplReqID()) {		
			if (hasApplReqID == FixUtils.TAG_HAS_VALUE) {		
				return applReqID; 		
			} else {

				buf.position(hasApplReqID);

			FixMessage.getTagStringValue(buf, applReqID, 0, applReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasApplReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return applReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasApplReqID() { return hasApplReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setApplReqID(byte[] src) {		
		if (src == null ) return;
		if (hasApplReqID()) FixUtils.fillNul(applReqID);		
		FixUtils.copy(applReqID, src); 		
		hasApplReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplReqID(String str) {		
		if (str == null ) return;
		if (hasApplReqID()) FixUtils.fillNul(applReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(applReqID, src); 		
		hasApplReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackApplReportType() {		
		getApplReportType();		
	}		
			
	public long getApplReportType() { 		
		if ( hasApplReportType()) {		
			if (hasApplReportType == FixUtils.TAG_HAS_VALUE) {		
				return applReportType; 		
			} else {

				buf.position(hasApplReportType);

			applReportType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasApplReportType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return applReportType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplReportType() { return hasApplReportType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setApplReportType(byte[] src) {		
		if (src == null ) return;
		if (hasApplReportType()) applReportType = FixUtils.TAG_HAS_NO_VALUE;		
		applReportType = FixUtils.longValueOf(src, 0, src.length);
		hasApplReportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplReportType(long src) {		
		applReportType = src;
		hasApplReportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplReportType(String str) {		
		if (str == null ) return;
		if (hasApplReportType()) applReportType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applReportType = FixUtils.longValueOf(src, 0, src.length);
		hasApplReportType = FixUtils.TAG_HAS_VALUE;		
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

					if (hasApplReportID()) s += "ApplReportID(1356)= " + new String( FixUtils.trim(getApplReportID()) ) + "\n" ; 
		if (hasApplReqID()) s += "ApplReqID(1346)= " + new String( FixUtils.trim(getApplReqID()) ) + "\n" ; 
		if (hasApplReportType()) s += "ApplReportType(1426)= " + getApplReportType() + "\n" ; 
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
		if (! ( o instanceof FixApplicationMessageReport)) return false;

		FixApplicationMessageReport msg = (FixApplicationMessageReport) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasApplReportID() && !msg.hasApplReportID()) || (!hasApplReportID() && msg.hasApplReportID())) return false;
		if (!(!hasApplReportID() && !msg.hasApplReportID()) && !FixUtils.equals(getApplReportID(), msg.getApplReportID())) return false;
		if ((hasApplReqID() && !msg.hasApplReqID()) || (!hasApplReqID() && msg.hasApplReqID())) return false;
		if (!(!hasApplReqID() && !msg.hasApplReqID()) && !FixUtils.equals(getApplReqID(), msg.getApplReqID())) return false;
		if ((hasApplReportType() && !msg.hasApplReportType()) || (!hasApplReportType() && msg.hasApplReportType())) return false;
		if (!(!hasApplReportType() && !msg.hasApplReportType()) && !(getApplReportType()==msg.getApplReportType())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixApplicationMessageReport clone () {
		FixApplicationMessageReport out = new FixApplicationMessageReport();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixApplicationMessageReport clone ( FixApplicationMessageReport out ) {
		if ( hasApplReportID())
			out.setApplReportID(getApplReportID());
		if ( hasApplReqID())
			out.setApplReqID(getApplReqID());
		if ( hasApplReportType())
			out.setApplReportType(getApplReportType());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		int count = 0;
		count = 0;
		for (FixApplIDReportGrp fixApplIDReportGrp : applIDReportGrp) {
			if (!fixApplIDReportGrp.hasGroup()) continue;
			out.applIDReportGrp[count] = fixApplIDReportGrp.clone( out.applIDReportGrp[count] );
			count++;
		}
		return out;
	}

}
