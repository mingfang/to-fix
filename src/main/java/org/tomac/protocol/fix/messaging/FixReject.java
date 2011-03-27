package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixReject extends FixInMessage {
	private short hasRefSeqNum;
	long refSeqNum = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasRefTagID;
	long refTagID = 0;		
	private short hasRefMsgType;
	byte[] refMsgType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSessionRejectReason;
	long sessionRejectReason = 0;		
	
	public FixReject() {
		super(FixMessageInfo.MessageTypes.REJECT);


		hasRefSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasRefTagID = FixUtils.TAG_HAS_NO_VALUE;		
		hasRefMsgType = FixUtils.TAG_HAS_NO_VALUE;		
		refMsgType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSessionRejectReason = FixUtils.TAG_HAS_NO_VALUE;		

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.REFSEQNUM_INT:		
            		hasRefSeqNum = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TEXT_INT:		
            		hasText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REFTAGID_INT:		
            		hasRefTagID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REFMSGTYPE_INT:		
            		hasRefMsgType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SESSIONREJECTREASON_INT:		
            		hasSessionRejectReason = (short) buf.position();		
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
		if (!hasRefSeqNum()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag RefSeqNum missing", FixTags.REFSEQNUM_INT, FixMessageInfo.MessageTypes.REJECT);
			return false;
		}
		if (!hasText()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Text missing", FixTags.TEXT_INT, FixMessageInfo.MessageTypes.REJECT);
			return false;
		}
		if (!hasSessionRejectReason()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag SessionRejectReason missing", FixTags.SESSIONREJECTREASON_INT, FixMessageInfo.MessageTypes.REJECT);
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
		if (hasRefSeqNum()) {		
			out.put(FixTags.REFSEQNUM);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)refSeqNum);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasText()) {		
			out.put(FixTags.TEXT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,text); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRefTagID()) {		
			out.put(FixTags.REFTAGID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)refTagID);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRefMsgType()) {		
			out.put(FixTags.REFMSGTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,refMsgType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSessionRejectReason()) {		
			out.put(FixTags.SESSIONREJECTREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)sessionRejectReason);
		
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
		
		if (hasRefSeqNum()) {		
			FixUtils.put(out, (long)refSeqNum);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasText()) {		
			FixUtils.put(out,text); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefTagID()) {		
			FixUtils.put(out, (long)refTagID);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefMsgType()) {		
			FixUtils.put(out,refMsgType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSessionRejectReason()) {		
			FixUtils.put(out, (long)sessionRejectReason);
		
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
			
	public void crackRefSeqNum() {		
		getRefSeqNum();		
	}		
			
	public long getRefSeqNum() { 		
		if ( hasRefSeqNum()) {		
			if (hasRefSeqNum == FixUtils.TAG_HAS_VALUE) {		
				return refSeqNum; 		
			} else {

				buf.position(hasRefSeqNum);

			refSeqNum = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasRefSeqNum = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return refSeqNum;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRefSeqNum() { return hasRefSeqNum != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRefSeqNum(byte[] src) {		
		if (src == null ) return;
		if (hasRefSeqNum()) refSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		refSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasRefSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefSeqNum(long src) {		
		refSeqNum = src;
		hasRefSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefSeqNum(String str) {		
		if (str == null ) return;
		if (hasRefSeqNum()) refSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		refSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasRefSeqNum = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackRefTagID() {		
		getRefTagID();		
	}		
			
	public long getRefTagID() { 		
		if ( hasRefTagID()) {		
			if (hasRefTagID == FixUtils.TAG_HAS_VALUE) {		
				return refTagID; 		
			} else {

				buf.position(hasRefTagID);

			refTagID = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasRefTagID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return refTagID;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRefTagID() { return hasRefTagID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRefTagID(byte[] src) {		
		if (src == null ) return;
		if (hasRefTagID()) refTagID = FixUtils.TAG_HAS_NO_VALUE;		
		refTagID = FixUtils.longValueOf(src, 0, src.length);
		hasRefTagID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefTagID(long src) {		
		refTagID = src;
		hasRefTagID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefTagID(String str) {		
		if (str == null ) return;
		if (hasRefTagID()) refTagID = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		refTagID = FixUtils.longValueOf(src, 0, src.length);
		hasRefTagID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRefMsgType() {		
		getRefMsgType();		
	}		
			
	public byte[] getRefMsgType() { 		
		if ( hasRefMsgType()) {		
			if (hasRefMsgType == FixUtils.TAG_HAS_VALUE) {		
				return refMsgType; 		
			} else {

				buf.position(hasRefMsgType);

			FixMessage.getTagStringValue(buf, refMsgType, 0, refMsgType.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRefMsgType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return refMsgType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefMsgType() { return hasRefMsgType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRefMsgType(byte[] src) {		
		if (src == null ) return;
		if (hasRefMsgType()) FixUtils.fillSpace(refMsgType);		
		FixUtils.copy(refMsgType, src); 		
		hasRefMsgType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefMsgType(String str) {		
		if (str == null ) return;
		if (hasRefMsgType()) FixUtils.fillSpace(refMsgType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refMsgType, src); 		
		hasRefMsgType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSessionRejectReason() {		
		getSessionRejectReason();		
	}		
			
	public long getSessionRejectReason() { 		
		if ( hasSessionRejectReason()) {		
			if (hasSessionRejectReason == FixUtils.TAG_HAS_VALUE) {		
				return sessionRejectReason; 		
			} else {

				buf.position(hasSessionRejectReason);

			sessionRejectReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSessionRejectReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return sessionRejectReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSessionRejectReason() { return hasSessionRejectReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSessionRejectReason(byte[] src) {		
		if (src == null ) return;
		if (hasSessionRejectReason()) sessionRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		sessionRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasSessionRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSessionRejectReason(long src) {		
		sessionRejectReason = src;
		hasSessionRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSessionRejectReason(String str) {		
		if (str == null ) return;
		if (hasSessionRejectReason()) sessionRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sessionRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasSessionRejectReason = FixUtils.TAG_HAS_VALUE;		
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

					if (hasRefSeqNum()) s += "RefSeqNum(45)= " + getRefSeqNum() + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasRefTagID()) s += "RefTagID(371)= " + getRefTagID() + "\n" ; 
		if (hasRefMsgType()) s += "RefMsgType(372)= " + new String( FixUtils.trim(getRefMsgType()) ) + "\n" ; 
		if (hasSessionRejectReason()) s += "SessionRejectReason(373)= " + getSessionRejectReason() + "\n" ; 

					if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixReject)) return false;

		FixReject msg = (FixReject) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasRefSeqNum() && !msg.hasRefSeqNum()) || (!hasRefSeqNum() && msg.hasRefSeqNum())) return false;
		if (!(!hasRefSeqNum() && !msg.hasRefSeqNum()) && !(getRefSeqNum()==msg.getRefSeqNum())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasRefTagID() && !msg.hasRefTagID()) || (!hasRefTagID() && msg.hasRefTagID())) return false;
		if (!(!hasRefTagID() && !msg.hasRefTagID()) && !(getRefTagID()==msg.getRefTagID())) return false;
		if ((hasRefMsgType() && !msg.hasRefMsgType()) || (!hasRefMsgType() && msg.hasRefMsgType())) return false;
		if (!(!hasRefMsgType() && !msg.hasRefMsgType()) && !FixUtils.equals(getRefMsgType(), msg.getRefMsgType())) return false;
		if ((hasSessionRejectReason() && !msg.hasSessionRejectReason()) || (!hasSessionRejectReason() && msg.hasSessionRejectReason())) return false;
		if (!(!hasSessionRejectReason() && !msg.hasSessionRejectReason()) && !(getSessionRejectReason()==msg.getSessionRejectReason())) return false;
		return true;
	}
	@Override
	public FixReject clone () {
		FixReject out = new FixReject();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixReject clone ( FixReject out ) {
		if ( hasRefSeqNum())
			out.setRefSeqNum(getRefSeqNum());
		if ( hasText())
			out.setText(getText());
		if ( hasRefTagID())
			out.setRefTagID(getRefTagID());
		if ( hasRefMsgType())
			out.setRefMsgType(getRefMsgType());
		if ( hasSessionRejectReason())
			out.setSessionRejectReason(getSessionRejectReason());
		return out;
	}

}
