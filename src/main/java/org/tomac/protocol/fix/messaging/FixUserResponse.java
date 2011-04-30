package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixUserResponse extends FixInMessage {
	private short hasUserRequestID;
	byte[] userRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUsername;
	byte[] username = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUserStatus;
	long userStatus = 0;		
	private short hasUserStatusText;
	byte[] userStatusText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	
	public FixUserResponse() {
		super(FixMessageInfo.MessageTypes.USERRESPONSE);


		hasUserRequestID = FixUtils.TAG_HAS_NO_VALUE;		
		userRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUsername = FixUtils.TAG_HAS_NO_VALUE;		
		username = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUserStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasUserStatusText = FixUtils.TAG_HAS_NO_VALUE;		
		userStatusText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.USERREQUESTID_INT:		
            		hasUserRequestID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.USERNAME_INT:		
            		hasUsername = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.USERSTATUS_INT:		
            		hasUserStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.USERSTATUSTEXT_INT:		
            		hasUserStatusText = (short) buf.position();		
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
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.USERRESPONSE_INT);
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
		if (!hasUserRequestID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.USERREQUESTID_INT, FixMessageInfo.MessageTypes.USERRESPONSE_INT);
			return false;
		}
		if (!hasUsername()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.USERNAME_INT, FixMessageInfo.MessageTypes.USERRESPONSE_INT);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		getUserRequestID();		
		getUsername();		
		getUserStatus();		
		getUserStatusText();		
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
		if (hasUserRequestID()) {		
			out.put(FixTags.USERREQUESTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,userRequestID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUsername()) {		
			out.put(FixTags.USERNAME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,username); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUserStatus()) {		
			out.put(FixTags.USERSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)userStatus);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUserStatusText()) {		
			out.put(FixTags.USERSTATUSTEXT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,userStatusText); 		
		
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
		
		if (hasUserRequestID()) {		
			FixUtils.put(out,userRequestID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUsername()) {		
			FixUtils.put(out,username); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUserStatus()) {		
			FixUtils.put(out, (long)userStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUserStatusText()) {		
			FixUtils.put(out,userStatusText); 		
		
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
			
	public void crackUserRequestID() {		
		getUserRequestID();		
	}		
			
	public byte[] getUserRequestID() { 		
		if ( hasUserRequestID()) {		
			if (hasUserRequestID == FixUtils.TAG_HAS_VALUE) {		
				return userRequestID; 		
			} else {

				buf.position(hasUserRequestID);

			FixUtils.getTagStringValue(buf, userRequestID, 0, userRequestID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasUserRequestID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return userRequestID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUserRequestID() { return hasUserRequestID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUserRequestID(byte[] src) {		
		if (src == null ) return;
		if (hasUserRequestID()) FixUtils.fillNul(userRequestID);		
		FixUtils.copy(userRequestID, src); 		
		hasUserRequestID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUserRequestID(String str) {		
		if (str == null ) return;
		if (hasUserRequestID()) FixUtils.fillNul(userRequestID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(userRequestID, src); 		
		hasUserRequestID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackUsername() {		
		getUsername();		
	}		
			
	public byte[] getUsername() { 		
		if ( hasUsername()) {		
			if (hasUsername == FixUtils.TAG_HAS_VALUE) {		
				return username; 		
			} else {

				buf.position(hasUsername);

			FixUtils.getTagStringValue(buf, username, 0, username.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasUsername = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return username;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUsername() { return hasUsername != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUsername(byte[] src) {		
		if (src == null ) return;
		if (hasUsername()) FixUtils.fillNul(username);		
		FixUtils.copy(username, src); 		
		hasUsername = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUsername(String str) {		
		if (str == null ) return;
		if (hasUsername()) FixUtils.fillNul(username);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(username, src); 		
		hasUsername = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackUserStatus() {		
		getUserStatus();		
	}		
			
	public long getUserStatus() { 		
		if ( hasUserStatus()) {		
			if (hasUserStatus == FixUtils.TAG_HAS_VALUE) {		
				return userStatus; 		
			} else {

				buf.position(hasUserStatus);

			userStatus = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasUserStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return userStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUserStatus() { return hasUserStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUserStatus(byte[] src) {		
		if (src == null ) return;
		if (hasUserStatus()) userStatus = FixUtils.TAG_HAS_NO_VALUE;		
		userStatus = FixUtils.longValueOf(src, 0, src.length);
		hasUserStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUserStatus(long src) {		
		userStatus = src;
		hasUserStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUserStatus(String str) {		
		if (str == null ) return;
		if (hasUserStatus()) userStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		userStatus = FixUtils.longValueOf(src, 0, src.length);
		hasUserStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackUserStatusText() {		
		getUserStatusText();		
	}		
			
	public byte[] getUserStatusText() { 		
		if ( hasUserStatusText()) {		
			if (hasUserStatusText == FixUtils.TAG_HAS_VALUE) {		
				return userStatusText; 		
			} else {

				buf.position(hasUserStatusText);

			FixUtils.getTagStringValue(buf, userStatusText, 0, userStatusText.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasUserStatusText = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return userStatusText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUserStatusText() { return hasUserStatusText != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUserStatusText(byte[] src) {		
		if (src == null ) return;
		if (hasUserStatusText()) FixUtils.fillNul(userStatusText);		
		FixUtils.copy(userStatusText, src); 		
		hasUserStatusText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUserStatusText(String str) {		
		if (str == null ) return;
		if (hasUserStatusText()) FixUtils.fillNul(userStatusText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(userStatusText, src); 		
		hasUserStatusText = FixUtils.TAG_HAS_VALUE;		
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

					if (hasUserRequestID()) s += "UserRequestID(923)= " + new String( FixUtils.trim(getUserRequestID()) ) + "\n" ; 
		if (hasUsername()) s += "Username(553)= " + new String( FixUtils.trim(getUsername()) ) + "\n" ; 
		if (hasUserStatus()) s += "UserStatus(926)= " + getUserStatus() + "\n" ; 
		if (hasUserStatusText()) s += "UserStatusText(927)= " + new String( FixUtils.trim(getUserStatusText()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUserResponse)) return false;

		FixUserResponse msg = (FixUserResponse) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasUserRequestID() && !msg.hasUserRequestID()) || (!hasUserRequestID() && msg.hasUserRequestID())) return false;
		if (!(!hasUserRequestID() && !msg.hasUserRequestID()) && !FixUtils.equals(getUserRequestID(), msg.getUserRequestID())) return false;
		if ((hasUsername() && !msg.hasUsername()) || (!hasUsername() && msg.hasUsername())) return false;
		if (!(!hasUsername() && !msg.hasUsername()) && !FixUtils.equals(getUsername(), msg.getUsername())) return false;
		if ((hasUserStatus() && !msg.hasUserStatus()) || (!hasUserStatus() && msg.hasUserStatus())) return false;
		if (!(!hasUserStatus() && !msg.hasUserStatus()) && !(getUserStatus()==msg.getUserStatus())) return false;
		if ((hasUserStatusText() && !msg.hasUserStatusText()) || (!hasUserStatusText() && msg.hasUserStatusText())) return false;
		if (!(!hasUserStatusText() && !msg.hasUserStatusText()) && !FixUtils.equals(getUserStatusText(), msg.getUserStatusText())) return false;
		return true;
	}
	@Override
	public FixUserResponse clone () {
		FixUserResponse out = new FixUserResponse();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixUserResponse clone ( FixUserResponse out ) {
		if ( hasUserRequestID())
			out.setUserRequestID(getUserRequestID());
		if ( hasUsername())
			out.setUsername(getUsername());
		if ( hasUserStatus())
			out.setUserStatus(getUserStatus());
		if ( hasUserStatusText())
			out.setUserStatusText(getUserStatusText());
		return out;
	}

}
