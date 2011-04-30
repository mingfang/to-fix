package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixResendRequest extends FixInMessage {
	private short hasBeginSeqNo;
	long beginSeqNo = 0;		
	private short hasEndSeqNo;
	long endSeqNo = 0;		
	
	public FixResendRequest() {
		super(FixMessageInfo.MessageTypes.RESENDREQUEST);


		hasBeginSeqNo = FixUtils.TAG_HAS_NO_VALUE;		
		hasEndSeqNo = FixUtils.TAG_HAS_NO_VALUE;		

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.BEGINSEQNO_INT:		
            		hasBeginSeqNo = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ENDSEQNO_INT:		
            		hasEndSeqNo = (short) buf.position();		
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
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.RESENDREQUEST_INT);
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
		if (!hasBeginSeqNo()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.BEGINSEQNO_INT, FixMessageInfo.MessageTypes.RESENDREQUEST_INT);
			return false;
		}
		if (!hasEndSeqNo()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.ENDSEQNO_INT, FixMessageInfo.MessageTypes.RESENDREQUEST_INT);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		getBeginSeqNo();		
		getEndSeqNo();		
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
		if (hasBeginSeqNo()) {		
			out.put(FixTags.BEGINSEQNO);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)beginSeqNo);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEndSeqNo()) {		
			out.put(FixTags.ENDSEQNO);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)endSeqNo);
		
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
		
		if (hasBeginSeqNo()) {		
			FixUtils.put(out, (long)beginSeqNo);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEndSeqNo()) {		
			FixUtils.put(out, (long)endSeqNo);
		
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
			
	public void crackBeginSeqNo() {		
		getBeginSeqNo();		
	}		
			
	public long getBeginSeqNo() { 		
		if ( hasBeginSeqNo()) {		
			if (hasBeginSeqNo == FixUtils.TAG_HAS_VALUE) {		
				return beginSeqNo; 		
			} else {

				buf.position(hasBeginSeqNo);

			beginSeqNo = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBeginSeqNo = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return beginSeqNo;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBeginSeqNo() { return hasBeginSeqNo != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBeginSeqNo(byte[] src) {		
		if (src == null ) return;
		if (hasBeginSeqNo()) beginSeqNo = FixUtils.TAG_HAS_NO_VALUE;		
		beginSeqNo = FixUtils.longValueOf(src, 0, src.length);
		hasBeginSeqNo = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBeginSeqNo(long src) {		
		beginSeqNo = src;
		hasBeginSeqNo = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBeginSeqNo(String str) {		
		if (str == null ) return;
		if (hasBeginSeqNo()) beginSeqNo = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		beginSeqNo = FixUtils.longValueOf(src, 0, src.length);
		hasBeginSeqNo = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEndSeqNo() {		
		getEndSeqNo();		
	}		
			
	public long getEndSeqNo() { 		
		if ( hasEndSeqNo()) {		
			if (hasEndSeqNo == FixUtils.TAG_HAS_VALUE) {		
				return endSeqNo; 		
			} else {

				buf.position(hasEndSeqNo);

			endSeqNo = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEndSeqNo = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return endSeqNo;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEndSeqNo() { return hasEndSeqNo != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEndSeqNo(byte[] src) {		
		if (src == null ) return;
		if (hasEndSeqNo()) endSeqNo = FixUtils.TAG_HAS_NO_VALUE;		
		endSeqNo = FixUtils.longValueOf(src, 0, src.length);
		hasEndSeqNo = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndSeqNo(long src) {		
		endSeqNo = src;
		hasEndSeqNo = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndSeqNo(String str) {		
		if (str == null ) return;
		if (hasEndSeqNo()) endSeqNo = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		endSeqNo = FixUtils.longValueOf(src, 0, src.length);
		hasEndSeqNo = FixUtils.TAG_HAS_VALUE;		
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

					if (hasBeginSeqNo()) s += "BeginSeqNo(7)= " + getBeginSeqNo() + "\n" ; 
		if (hasEndSeqNo()) s += "EndSeqNo(16)= " + getEndSeqNo() + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixResendRequest)) return false;

		FixResendRequest msg = (FixResendRequest) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasBeginSeqNo() && !msg.hasBeginSeqNo()) || (!hasBeginSeqNo() && msg.hasBeginSeqNo())) return false;
		if (!(!hasBeginSeqNo() && !msg.hasBeginSeqNo()) && !(getBeginSeqNo()==msg.getBeginSeqNo())) return false;
		if ((hasEndSeqNo() && !msg.hasEndSeqNo()) || (!hasEndSeqNo() && msg.hasEndSeqNo())) return false;
		if (!(!hasEndSeqNo() && !msg.hasEndSeqNo()) && !(getEndSeqNo()==msg.getEndSeqNo())) return false;
		return true;
	}
	@Override
	public FixResendRequest clone () {
		FixResendRequest out = new FixResendRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixResendRequest clone ( FixResendRequest out ) {
		if ( hasBeginSeqNo())
			out.setBeginSeqNo(getBeginSeqNo());
		if ( hasEndSeqNo())
			out.setEndSeqNo(getEndSeqNo());
		return out;
	}

}
