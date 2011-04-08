package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixSequenceReset extends FixInMessage {
	private short hasGapFillFlag;
		boolean gapFillFlag = false;		
	private short hasNewSeqNo;
	long newSeqNo = 0;		
	
	public FixSequenceReset() {
		super(FixMessageInfo.MessageTypes.SEQUENCERESET);


		hasGapFillFlag = FixUtils.TAG_HAS_NO_VALUE;		
		hasNewSeqNo = FixUtils.TAG_HAS_NO_VALUE;		

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.GAPFILLFLAG_INT:		
            		hasGapFillFlag = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.NEWSEQNO_INT:		
            		hasNewSeqNo = (short) buf.position();		
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
                		else {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.SEQUENCERESET);
                			break;
                		}
					}

			}

        		if (err.hasError()) return;

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	public boolean hasRequiredTags(FixValidationError err) {
		standardHeader.hasRequiredTags(err); if (err.hasError()) return false; 

		if (!hasNewSeqNo()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.NEWSEQNO_INT, FixMessageInfo.MessageTypes.SEQUENCERESET);
			return false;
		}
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getGapFillFlag();		
		getNewSeqNo();		
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
		if (hasGapFillFlag()) {		
			out.put(FixTags.GAPFILLFLAG);		
		
			out.put((byte) '=');		
		
			out.put(gapFillFlag?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNewSeqNo()) {		
			out.put(FixTags.NEWSEQNO);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)newSeqNo);
		
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
		
		if (hasGapFillFlag()) {		
			out.put(gapFillFlag?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNewSeqNo()) {		
			FixUtils.put(out, (long)newSeqNo);
		
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
			
	public void crackGapFillFlag() {		
		getGapFillFlag();		
	}		
			
	public boolean getGapFillFlag() { 		
		if ( hasGapFillFlag()) {		
			if (hasGapFillFlag == FixUtils.TAG_HAS_VALUE) {		
				return gapFillFlag; 		
			} else {

				buf.position(hasGapFillFlag);

			gapFillFlag = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasGapFillFlag = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return gapFillFlag;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasGapFillFlag() { return hasGapFillFlag != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setGapFillFlag(byte[] src) {		
		if (src == null ) return;
		if (hasGapFillFlag()) gapFillFlag = false;		
		gapFillFlag = src[0]==(byte)'Y'?true:false;		
		hasGapFillFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setGapFillFlag(boolean src) {		
		gapFillFlag = src;
		hasGapFillFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setGapFillFlag(String str) {		
		if (str == null ) return;
		if (hasGapFillFlag()) gapFillFlag = false;		
		byte[] src = str.getBytes(); 		
		gapFillFlag = src[0]==(byte)'Y'?true:false;		
		hasGapFillFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackNewSeqNo() {		
		getNewSeqNo();		
	}		
			
	public long getNewSeqNo() { 		
		if ( hasNewSeqNo()) {		
			if (hasNewSeqNo == FixUtils.TAG_HAS_VALUE) {		
				return newSeqNo; 		
			} else {

				buf.position(hasNewSeqNo);

			newSeqNo = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasNewSeqNo = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return newSeqNo;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNewSeqNo() { return hasNewSeqNo != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNewSeqNo(byte[] src) {		
		if (src == null ) return;
		if (hasNewSeqNo()) newSeqNo = FixUtils.TAG_HAS_NO_VALUE;		
		newSeqNo = FixUtils.longValueOf(src, 0, src.length);
		hasNewSeqNo = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNewSeqNo(long src) {		
		newSeqNo = src;
		hasNewSeqNo = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNewSeqNo(String str) {		
		if (str == null ) return;
		if (hasNewSeqNo()) newSeqNo = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		newSeqNo = FixUtils.longValueOf(src, 0, src.length);
		hasNewSeqNo = FixUtils.TAG_HAS_VALUE;		
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

					if (hasGapFillFlag()) s += "GapFillFlag(123)= " + getGapFillFlag() + "\n" ; 
		if (hasNewSeqNo()) s += "NewSeqNo(36)= " + getNewSeqNo() + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSequenceReset)) return false;

		FixSequenceReset msg = (FixSequenceReset) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasGapFillFlag() && !msg.hasGapFillFlag()) || (!hasGapFillFlag() && msg.hasGapFillFlag())) return false;
		if (!(!hasGapFillFlag() && !msg.hasGapFillFlag()) && !(getGapFillFlag()==msg.getGapFillFlag())) return false;
		if ((hasNewSeqNo() && !msg.hasNewSeqNo()) || (!hasNewSeqNo() && msg.hasNewSeqNo())) return false;
		if (!(!hasNewSeqNo() && !msg.hasNewSeqNo()) && !(getNewSeqNo()==msg.getNewSeqNo())) return false;
		return true;
	}
	@Override
	public FixSequenceReset clone () {
		FixSequenceReset out = new FixSequenceReset();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixSequenceReset clone ( FixSequenceReset out ) {
		if ( hasGapFillFlag())
			out.setGapFillFlag(getGapFillFlag());
		if ( hasNewSeqNo())
			out.setNewSeqNo(getNewSeqNo());
		return out;
	}

}
