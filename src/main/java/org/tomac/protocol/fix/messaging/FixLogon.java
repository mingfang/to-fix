package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixLogon extends FixInMessage {
	private short hasEncryptMethod;
	long encryptMethod = 0;		
	private short hasHeartBtInt;
	long heartBtInt = 0;		
	private short hasRawDataLength;
	long rawDataLength = 0;		
	private short hasRawData;
	byte[] rawData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasResetSeqNumFlag;
		boolean resetSeqNumFlag = false;		
	private short hasNextExpectedMsgSeqNum;
	long nextExpectedMsgSeqNum = 0;		
	private short hasMaxMessageSize;
	long maxMessageSize = 0;		
	private short hasTestMessageIndicator;
		boolean testMessageIndicator = false;		
	private short hasUsername;
	byte[] username = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPassword;
	byte[] password = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNewPassword;
	byte[] newPassword = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEncryptedPasswordMethod;
	long encryptedPasswordMethod = 0;		
	private short hasEncryptedPasswordLen;
	long encryptedPasswordLen = 0;		
	private short hasEncryptedPassword;
	byte[] encryptedPassword = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEncryptedNewPasswordLen;
	long encryptedNewPasswordLen = 0;		
	private short hasEncryptedNewPassword;
	byte[] encryptedNewPassword = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSessionStatus;
	long sessionStatus = 0;		
	private short hasDefaultApplVerID;
	byte[] defaultApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDefaultApplExtID;
	long defaultApplExtID = 0;		
	private short hasDefaultCstmApplVerID;
	byte[] defaultCstmApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixMsgTypeGrp[] msgTypeGrp;
	
	public FixLogon() {
		super(FixMessageInfo.MessageTypes.LOGON);


		hasEncryptMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasHeartBtInt = FixUtils.TAG_HAS_NO_VALUE;		
		hasRawDataLength = FixUtils.TAG_HAS_NO_VALUE;		
		hasRawData = FixUtils.TAG_HAS_NO_VALUE;		
		rawData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasResetSeqNumFlag = FixUtils.TAG_HAS_NO_VALUE;		
		hasNextExpectedMsgSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxMessageSize = FixUtils.TAG_HAS_NO_VALUE;		
		hasTestMessageIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasUsername = FixUtils.TAG_HAS_NO_VALUE;		
		username = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPassword = FixUtils.TAG_HAS_NO_VALUE;		
		password = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNewPassword = FixUtils.TAG_HAS_NO_VALUE;		
		newPassword = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEncryptedPasswordMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncryptedPasswordLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncryptedPassword = FixUtils.TAG_HAS_NO_VALUE;		
		encryptedPassword = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEncryptedNewPasswordLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncryptedNewPassword = FixUtils.TAG_HAS_NO_VALUE;		
		encryptedNewPassword = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSessionStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasDefaultApplVerID = FixUtils.TAG_HAS_NO_VALUE;		
		defaultApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDefaultApplExtID = FixUtils.TAG_HAS_NO_VALUE;		
		hasDefaultCstmApplVerID = FixUtils.TAG_HAS_NO_VALUE;		
		defaultCstmApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		msgTypeGrp = new FixMsgTypeGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) msgTypeGrp[i] = new FixMsgTypeGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.ENCRYPTMETHOD_INT:		
            		hasEncryptMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.HEARTBTINT_INT:		
            		hasHeartBtInt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RAWDATALENGTH_INT:		
            		hasRawDataLength = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RAWDATA_INT:		
            		hasRawData = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RESETSEQNUMFLAG_INT:		
            		hasResetSeqNumFlag = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.NEXTEXPECTEDMSGSEQNUM_INT:		
            		hasNextExpectedMsgSeqNum = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MAXMESSAGESIZE_INT:		
            		hasMaxMessageSize = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TESTMESSAGEINDICATOR_INT:		
            		hasTestMessageIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.USERNAME_INT:		
            		hasUsername = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PASSWORD_INT:		
            		hasPassword = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.NEWPASSWORD_INT:		
            		hasNewPassword = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCRYPTEDPASSWORDMETHOD_INT:		
            		hasEncryptedPasswordMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCRYPTEDPASSWORDLEN_INT:		
            		hasEncryptedPasswordLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCRYPTEDPASSWORD_INT:		
            		hasEncryptedPassword = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCRYPTEDNEWPASSWORDLEN_INT:		
            		hasEncryptedNewPasswordLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCRYPTEDNEWPASSWORD_INT:		
            		hasEncryptedNewPassword = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SESSIONSTATUS_INT:		
            		hasSessionStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.DEFAULTAPPLVERID_INT:		
            		hasDefaultApplVerID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.DEFAULTAPPLEXTID_INT:		
            		hasDefaultApplExtID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.DEFAULTCSTMAPPLVERID_INT:		
            		hasDefaultCstmApplVerID = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOMSGTYPES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !msgTypeGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = msgTypeGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.LOGON);
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

		if (!hasEncryptMethod()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.ENCRYPTMETHOD_INT, FixMessageInfo.MessageTypes.LOGON);
			return false;
		}
		if (!hasHeartBtInt()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.HEARTBTINT_INT, FixMessageInfo.MessageTypes.LOGON);
			return false;
		}
		if (!hasDefaultApplVerID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.DEFAULTAPPLVERID_INT, FixMessageInfo.MessageTypes.LOGON);
			return false;
		}
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getEncryptMethod();		
		getHeartBtInt();		
		getRawDataLength();		
		getRawData();		
		getResetSeqNumFlag();		
		getNextExpectedMsgSeqNum();		
		getMaxMessageSize();		
		getTestMessageIndicator();		
		getUsername();		
		getPassword();		
		getNewPassword();		
		getEncryptedPasswordMethod();		
		getEncryptedPasswordLen();		
		getEncryptedPassword();		
		getEncryptedNewPasswordLen();		
		getEncryptedNewPassword();		
		getSessionStatus();		
		getDefaultApplVerID();		
		getDefaultApplExtID();		
		getDefaultCstmApplVerID();		
		getText();		
		getEncodedTextLen();		
		getEncodedText();		
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
		if (hasEncryptMethod()) {		
			out.put(FixTags.ENCRYPTMETHOD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encryptMethod);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasHeartBtInt()) {		
			out.put(FixTags.HEARTBTINT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)heartBtInt);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRawDataLength()) {		
			out.put(FixTags.RAWDATALENGTH);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)rawDataLength);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRawData()) {		
			out.put(FixTags.RAWDATA);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,rawData); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasResetSeqNumFlag()) {		
			out.put(FixTags.RESETSEQNUMFLAG);		
		
			out.put((byte) '=');		
		
			out.put(resetSeqNumFlag?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNextExpectedMsgSeqNum()) {		
			out.put(FixTags.NEXTEXPECTEDMSGSEQNUM);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)nextExpectedMsgSeqNum);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMaxMessageSize()) {		
			out.put(FixTags.MAXMESSAGESIZE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)maxMessageSize);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTestMessageIndicator()) {		
			out.put(FixTags.TESTMESSAGEINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(testMessageIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUsername()) {		
			out.put(FixTags.USERNAME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,username); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPassword()) {		
			out.put(FixTags.PASSWORD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,password); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNewPassword()) {		
			out.put(FixTags.NEWPASSWORD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,newPassword); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncryptedPasswordMethod()) {		
			out.put(FixTags.ENCRYPTEDPASSWORDMETHOD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encryptedPasswordMethod);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncryptedPasswordLen()) {		
			out.put(FixTags.ENCRYPTEDPASSWORDLEN);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encryptedPasswordLen);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncryptedPassword()) {		
			out.put(FixTags.ENCRYPTEDPASSWORD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,encryptedPassword); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncryptedNewPasswordLen()) {		
			out.put(FixTags.ENCRYPTEDNEWPASSWORDLEN);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encryptedNewPasswordLen);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncryptedNewPassword()) {		
			out.put(FixTags.ENCRYPTEDNEWPASSWORD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,encryptedNewPassword); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSessionStatus()) {		
			out.put(FixTags.SESSIONSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)sessionStatus);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDefaultApplVerID()) {		
			out.put(FixTags.DEFAULTAPPLVERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,defaultApplVerID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDefaultApplExtID()) {		
			out.put(FixTags.DEFAULTAPPLEXTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)defaultApplExtID);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDefaultCstmApplVerID()) {		
			out.put(FixTags.DEFAULTCSTMAPPLVERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,defaultCstmApplVerID); 		
		
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
		
		if (FixUtils.getNoInGroup(msgTypeGrp)>0) {
			out.put(FixTags.NOMSGTYPES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(msgTypeGrp));

			out.put(FixUtils.SOH);

		}
		for (FixMsgTypeGrp fixMsgTypeGrp : msgTypeGrp) if (fixMsgTypeGrp.hasGroup()) fixMsgTypeGrp.encode(out);
		
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
		
		if (hasEncryptMethod()) {		
			FixUtils.put(out, (long)encryptMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHeartBtInt()) {		
			FixUtils.put(out, (long)heartBtInt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRawDataLength()) {		
			FixUtils.put(out, (long)rawDataLength);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRawData()) {		
			FixUtils.put(out,rawData); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasResetSeqNumFlag()) {		
			out.put(resetSeqNumFlag?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNextExpectedMsgSeqNum()) {		
			FixUtils.put(out, (long)nextExpectedMsgSeqNum);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaxMessageSize()) {		
			FixUtils.put(out, (long)maxMessageSize);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTestMessageIndicator()) {		
			out.put(testMessageIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUsername()) {		
			FixUtils.put(out,username); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPassword()) {		
			FixUtils.put(out,password); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNewPassword()) {		
			FixUtils.put(out,newPassword); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncryptedPasswordMethod()) {		
			FixUtils.put(out, (long)encryptedPasswordMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncryptedPasswordLen()) {		
			FixUtils.put(out, (long)encryptedPasswordLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncryptedPassword()) {		
			FixUtils.put(out,encryptedPassword); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncryptedNewPasswordLen()) {		
			FixUtils.put(out, (long)encryptedNewPasswordLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncryptedNewPassword()) {		
			FixUtils.put(out,encryptedNewPassword); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSessionStatus()) {		
			FixUtils.put(out, (long)sessionStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDefaultApplVerID()) {		
			FixUtils.put(out,defaultApplVerID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDefaultApplExtID()) {		
			FixUtils.put(out, (long)defaultApplExtID);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDefaultCstmApplVerID()) {		
			FixUtils.put(out,defaultCstmApplVerID); 		
		
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
			
	public void crackEncryptMethod() {		
		getEncryptMethod();		
	}		
			
	public long getEncryptMethod() { 		
		if ( hasEncryptMethod()) {		
			if (hasEncryptMethod == FixUtils.TAG_HAS_VALUE) {		
				return encryptMethod; 		
			} else {

				buf.position(hasEncryptMethod);

			encryptMethod = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncryptMethod = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encryptMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncryptMethod() { return hasEncryptMethod != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncryptMethod(byte[] src) {		
		if (src == null ) return;
		if (hasEncryptMethod()) encryptMethod = FixUtils.TAG_HAS_NO_VALUE;		
		encryptMethod = FixUtils.longValueOf(src, 0, src.length);
		hasEncryptMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncryptMethod(long src) {		
		encryptMethod = src;
		hasEncryptMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncryptMethod(String str) {		
		if (str == null ) return;
		if (hasEncryptMethod()) encryptMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encryptMethod = FixUtils.longValueOf(src, 0, src.length);
		hasEncryptMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackHeartBtInt() {		
		getHeartBtInt();		
	}		
			
	public long getHeartBtInt() { 		
		if ( hasHeartBtInt()) {		
			if (hasHeartBtInt == FixUtils.TAG_HAS_VALUE) {		
				return heartBtInt; 		
			} else {

				buf.position(hasHeartBtInt);

			heartBtInt = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasHeartBtInt = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return heartBtInt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasHeartBtInt() { return hasHeartBtInt != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setHeartBtInt(byte[] src) {		
		if (src == null ) return;
		if (hasHeartBtInt()) heartBtInt = FixUtils.TAG_HAS_NO_VALUE;		
		heartBtInt = FixUtils.longValueOf(src, 0, src.length);
		hasHeartBtInt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHeartBtInt(long src) {		
		heartBtInt = src;
		hasHeartBtInt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHeartBtInt(String str) {		
		if (str == null ) return;
		if (hasHeartBtInt()) heartBtInt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		heartBtInt = FixUtils.longValueOf(src, 0, src.length);
		hasHeartBtInt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRawDataLength() {		
		getRawDataLength();		
	}		
			
	public long getRawDataLength() { 		
		if ( hasRawDataLength()) {		
			if (hasRawDataLength == FixUtils.TAG_HAS_VALUE) {		
				return rawDataLength; 		
			} else {

				buf.position(hasRawDataLength);

			rawDataLength = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasRawDataLength = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return rawDataLength;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRawDataLength() { return hasRawDataLength != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRawDataLength(byte[] src) {		
		if (src == null ) return;
		if (hasRawDataLength()) rawDataLength = FixUtils.TAG_HAS_NO_VALUE;		
		rawDataLength = FixUtils.longValueOf(src, 0, src.length);
		hasRawDataLength = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRawDataLength(long src) {		
		rawDataLength = src;
		hasRawDataLength = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRawDataLength(String str) {		
		if (str == null ) return;
		if (hasRawDataLength()) rawDataLength = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		rawDataLength = FixUtils.longValueOf(src, 0, src.length);
		hasRawDataLength = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRawData() {		
		getRawData();		
	}		
			
	public byte[] getRawData() { 		
		if ( hasRawData()) {		
			if (hasRawData == FixUtils.TAG_HAS_VALUE) {		
				return rawData; 		
			} else {

				buf.position(hasRawData);

			FixMessage.getTagStringValue(buf, rawData, 0, rawData.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRawData = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return rawData;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRawData() { return hasRawData != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRawData(byte[] src) {		
		if (src == null ) return;
		if (hasRawData()) FixUtils.fillNul(rawData);		
		FixUtils.copy(rawData, src); 		
		hasRawData = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRawData(String str) {		
		if (str == null ) return;
		if (hasRawData()) FixUtils.fillNul(rawData);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(rawData, src); 		
		hasRawData = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackResetSeqNumFlag() {		
		getResetSeqNumFlag();		
	}		
			
	public boolean getResetSeqNumFlag() { 		
		if ( hasResetSeqNumFlag()) {		
			if (hasResetSeqNumFlag == FixUtils.TAG_HAS_VALUE) {		
				return resetSeqNumFlag; 		
			} else {

				buf.position(hasResetSeqNumFlag);

			resetSeqNumFlag = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasResetSeqNumFlag = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return resetSeqNumFlag;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasResetSeqNumFlag() { return hasResetSeqNumFlag != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setResetSeqNumFlag(byte[] src) {		
		if (src == null ) return;
		if (hasResetSeqNumFlag()) resetSeqNumFlag = false;		
		resetSeqNumFlag = src[0]==(byte)'Y'?true:false;		
		hasResetSeqNumFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setResetSeqNumFlag(boolean src) {		
		resetSeqNumFlag = src;
		hasResetSeqNumFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setResetSeqNumFlag(String str) {		
		if (str == null ) return;
		if (hasResetSeqNumFlag()) resetSeqNumFlag = false;		
		byte[] src = str.getBytes(); 		
		resetSeqNumFlag = src[0]==(byte)'Y'?true:false;		
		hasResetSeqNumFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackNextExpectedMsgSeqNum() {		
		getNextExpectedMsgSeqNum();		
	}		
			
	public long getNextExpectedMsgSeqNum() { 		
		if ( hasNextExpectedMsgSeqNum()) {		
			if (hasNextExpectedMsgSeqNum == FixUtils.TAG_HAS_VALUE) {		
				return nextExpectedMsgSeqNum; 		
			} else {

				buf.position(hasNextExpectedMsgSeqNum);

			nextExpectedMsgSeqNum = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasNextExpectedMsgSeqNum = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return nextExpectedMsgSeqNum;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNextExpectedMsgSeqNum() { return hasNextExpectedMsgSeqNum != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNextExpectedMsgSeqNum(byte[] src) {		
		if (src == null ) return;
		if (hasNextExpectedMsgSeqNum()) nextExpectedMsgSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		nextExpectedMsgSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasNextExpectedMsgSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNextExpectedMsgSeqNum(long src) {		
		nextExpectedMsgSeqNum = src;
		hasNextExpectedMsgSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNextExpectedMsgSeqNum(String str) {		
		if (str == null ) return;
		if (hasNextExpectedMsgSeqNum()) nextExpectedMsgSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		nextExpectedMsgSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasNextExpectedMsgSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMaxMessageSize() {		
		getMaxMessageSize();		
	}		
			
	public long getMaxMessageSize() { 		
		if ( hasMaxMessageSize()) {		
			if (hasMaxMessageSize == FixUtils.TAG_HAS_VALUE) {		
				return maxMessageSize; 		
			} else {

				buf.position(hasMaxMessageSize);

			maxMessageSize = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMaxMessageSize = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return maxMessageSize;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxMessageSize() { return hasMaxMessageSize != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMaxMessageSize(byte[] src) {		
		if (src == null ) return;
		if (hasMaxMessageSize()) maxMessageSize = FixUtils.TAG_HAS_NO_VALUE;		
		maxMessageSize = FixUtils.longValueOf(src, 0, src.length);
		hasMaxMessageSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxMessageSize(long src) {		
		maxMessageSize = src;
		hasMaxMessageSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxMessageSize(String str) {		
		if (str == null ) return;
		if (hasMaxMessageSize()) maxMessageSize = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxMessageSize = FixUtils.longValueOf(src, 0, src.length);
		hasMaxMessageSize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTestMessageIndicator() {		
		getTestMessageIndicator();		
	}		
			
	public boolean getTestMessageIndicator() { 		
		if ( hasTestMessageIndicator()) {		
			if (hasTestMessageIndicator == FixUtils.TAG_HAS_VALUE) {		
				return testMessageIndicator; 		
			} else {

				buf.position(hasTestMessageIndicator);

			testMessageIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasTestMessageIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return testMessageIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasTestMessageIndicator() { return hasTestMessageIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTestMessageIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasTestMessageIndicator()) testMessageIndicator = false;		
		testMessageIndicator = src[0]==(byte)'Y'?true:false;		
		hasTestMessageIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTestMessageIndicator(boolean src) {		
		testMessageIndicator = src;
		hasTestMessageIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTestMessageIndicator(String str) {		
		if (str == null ) return;
		if (hasTestMessageIndicator()) testMessageIndicator = false;		
		byte[] src = str.getBytes(); 		
		testMessageIndicator = src[0]==(byte)'Y'?true:false;		
		hasTestMessageIndicator = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, username, 0, username.length, err);
		
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
			
	public void crackPassword() {		
		getPassword();		
	}		
			
	public byte[] getPassword() { 		
		if ( hasPassword()) {		
			if (hasPassword == FixUtils.TAG_HAS_VALUE) {		
				return password; 		
			} else {

				buf.position(hasPassword);

			FixMessage.getTagStringValue(buf, password, 0, password.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasPassword = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return password;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPassword() { return hasPassword != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPassword(byte[] src) {		
		if (src == null ) return;
		if (hasPassword()) FixUtils.fillNul(password);		
		FixUtils.copy(password, src); 		
		hasPassword = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPassword(String str) {		
		if (str == null ) return;
		if (hasPassword()) FixUtils.fillNul(password);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(password, src); 		
		hasPassword = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackNewPassword() {		
		getNewPassword();		
	}		
			
	public byte[] getNewPassword() { 		
		if ( hasNewPassword()) {		
			if (hasNewPassword == FixUtils.TAG_HAS_VALUE) {		
				return newPassword; 		
			} else {

				buf.position(hasNewPassword);

			FixMessage.getTagStringValue(buf, newPassword, 0, newPassword.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasNewPassword = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return newPassword;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNewPassword() { return hasNewPassword != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNewPassword(byte[] src) {		
		if (src == null ) return;
		if (hasNewPassword()) FixUtils.fillNul(newPassword);		
		FixUtils.copy(newPassword, src); 		
		hasNewPassword = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNewPassword(String str) {		
		if (str == null ) return;
		if (hasNewPassword()) FixUtils.fillNul(newPassword);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(newPassword, src); 		
		hasNewPassword = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncryptedPasswordMethod() {		
		getEncryptedPasswordMethod();		
	}		
			
	public long getEncryptedPasswordMethod() { 		
		if ( hasEncryptedPasswordMethod()) {		
			if (hasEncryptedPasswordMethod == FixUtils.TAG_HAS_VALUE) {		
				return encryptedPasswordMethod; 		
			} else {

				buf.position(hasEncryptedPasswordMethod);

			encryptedPasswordMethod = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncryptedPasswordMethod = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encryptedPasswordMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncryptedPasswordMethod() { return hasEncryptedPasswordMethod != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncryptedPasswordMethod(byte[] src) {		
		if (src == null ) return;
		if (hasEncryptedPasswordMethod()) encryptedPasswordMethod = FixUtils.TAG_HAS_NO_VALUE;		
		encryptedPasswordMethod = FixUtils.longValueOf(src, 0, src.length);
		hasEncryptedPasswordMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncryptedPasswordMethod(long src) {		
		encryptedPasswordMethod = src;
		hasEncryptedPasswordMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncryptedPasswordMethod(String str) {		
		if (str == null ) return;
		if (hasEncryptedPasswordMethod()) encryptedPasswordMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encryptedPasswordMethod = FixUtils.longValueOf(src, 0, src.length);
		hasEncryptedPasswordMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncryptedPasswordLen() {		
		getEncryptedPasswordLen();		
	}		
			
	public long getEncryptedPasswordLen() { 		
		if ( hasEncryptedPasswordLen()) {		
			if (hasEncryptedPasswordLen == FixUtils.TAG_HAS_VALUE) {		
				return encryptedPasswordLen; 		
			} else {

				buf.position(hasEncryptedPasswordLen);

			encryptedPasswordLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncryptedPasswordLen = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encryptedPasswordLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncryptedPasswordLen() { return hasEncryptedPasswordLen != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncryptedPasswordLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncryptedPasswordLen()) encryptedPasswordLen = FixUtils.TAG_HAS_NO_VALUE;		
		encryptedPasswordLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncryptedPasswordLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncryptedPasswordLen(long src) {		
		encryptedPasswordLen = src;
		hasEncryptedPasswordLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncryptedPasswordLen(String str) {		
		if (str == null ) return;
		if (hasEncryptedPasswordLen()) encryptedPasswordLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encryptedPasswordLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncryptedPasswordLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncryptedPassword() {		
		getEncryptedPassword();		
	}		
			
	public byte[] getEncryptedPassword() { 		
		if ( hasEncryptedPassword()) {		
			if (hasEncryptedPassword == FixUtils.TAG_HAS_VALUE) {		
				return encryptedPassword; 		
			} else {

				buf.position(hasEncryptedPassword);

			FixMessage.getTagStringValue(buf, encryptedPassword, 0, encryptedPassword.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEncryptedPassword = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encryptedPassword;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncryptedPassword() { return hasEncryptedPassword != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncryptedPassword(byte[] src) {		
		if (src == null ) return;
		if (hasEncryptedPassword()) FixUtils.fillNul(encryptedPassword);		
		FixUtils.copy(encryptedPassword, src); 		
		hasEncryptedPassword = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncryptedPassword(String str) {		
		if (str == null ) return;
		if (hasEncryptedPassword()) FixUtils.fillNul(encryptedPassword);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encryptedPassword, src); 		
		hasEncryptedPassword = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncryptedNewPasswordLen() {		
		getEncryptedNewPasswordLen();		
	}		
			
	public long getEncryptedNewPasswordLen() { 		
		if ( hasEncryptedNewPasswordLen()) {		
			if (hasEncryptedNewPasswordLen == FixUtils.TAG_HAS_VALUE) {		
				return encryptedNewPasswordLen; 		
			} else {

				buf.position(hasEncryptedNewPasswordLen);

			encryptedNewPasswordLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncryptedNewPasswordLen = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encryptedNewPasswordLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncryptedNewPasswordLen() { return hasEncryptedNewPasswordLen != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncryptedNewPasswordLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncryptedNewPasswordLen()) encryptedNewPasswordLen = FixUtils.TAG_HAS_NO_VALUE;		
		encryptedNewPasswordLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncryptedNewPasswordLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncryptedNewPasswordLen(long src) {		
		encryptedNewPasswordLen = src;
		hasEncryptedNewPasswordLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncryptedNewPasswordLen(String str) {		
		if (str == null ) return;
		if (hasEncryptedNewPasswordLen()) encryptedNewPasswordLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encryptedNewPasswordLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncryptedNewPasswordLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncryptedNewPassword() {		
		getEncryptedNewPassword();		
	}		
			
	public byte[] getEncryptedNewPassword() { 		
		if ( hasEncryptedNewPassword()) {		
			if (hasEncryptedNewPassword == FixUtils.TAG_HAS_VALUE) {		
				return encryptedNewPassword; 		
			} else {

				buf.position(hasEncryptedNewPassword);

			FixMessage.getTagStringValue(buf, encryptedNewPassword, 0, encryptedNewPassword.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEncryptedNewPassword = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encryptedNewPassword;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncryptedNewPassword() { return hasEncryptedNewPassword != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncryptedNewPassword(byte[] src) {		
		if (src == null ) return;
		if (hasEncryptedNewPassword()) FixUtils.fillNul(encryptedNewPassword);		
		FixUtils.copy(encryptedNewPassword, src); 		
		hasEncryptedNewPassword = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncryptedNewPassword(String str) {		
		if (str == null ) return;
		if (hasEncryptedNewPassword()) FixUtils.fillNul(encryptedNewPassword);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encryptedNewPassword, src); 		
		hasEncryptedNewPassword = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSessionStatus() {		
		getSessionStatus();		
	}		
			
	public long getSessionStatus() { 		
		if ( hasSessionStatus()) {		
			if (hasSessionStatus == FixUtils.TAG_HAS_VALUE) {		
				return sessionStatus; 		
			} else {

				buf.position(hasSessionStatus);

			sessionStatus = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSessionStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return sessionStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSessionStatus() { return hasSessionStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSessionStatus(byte[] src) {		
		if (src == null ) return;
		if (hasSessionStatus()) sessionStatus = FixUtils.TAG_HAS_NO_VALUE;		
		sessionStatus = FixUtils.longValueOf(src, 0, src.length);
		hasSessionStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSessionStatus(long src) {		
		sessionStatus = src;
		hasSessionStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSessionStatus(String str) {		
		if (str == null ) return;
		if (hasSessionStatus()) sessionStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sessionStatus = FixUtils.longValueOf(src, 0, src.length);
		hasSessionStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDefaultApplVerID() {		
		getDefaultApplVerID();		
	}		
			
	public byte[] getDefaultApplVerID() { 		
		if ( hasDefaultApplVerID()) {		
			if (hasDefaultApplVerID == FixUtils.TAG_HAS_VALUE) {		
				return defaultApplVerID; 		
			} else {

				buf.position(hasDefaultApplVerID);

			FixMessage.getTagStringValue(buf, defaultApplVerID, 0, defaultApplVerID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasDefaultApplVerID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return defaultApplVerID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDefaultApplVerID() { return hasDefaultApplVerID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDefaultApplVerID(byte[] src) {		
		if (src == null ) return;
		if (hasDefaultApplVerID()) FixUtils.fillNul(defaultApplVerID);		
		FixUtils.copy(defaultApplVerID, src); 		
		hasDefaultApplVerID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDefaultApplVerID(String str) {		
		if (str == null ) return;
		if (hasDefaultApplVerID()) FixUtils.fillNul(defaultApplVerID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(defaultApplVerID, src); 		
		hasDefaultApplVerID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDefaultApplExtID() {		
		getDefaultApplExtID();		
	}		
			
	public long getDefaultApplExtID() { 		
		if ( hasDefaultApplExtID()) {		
			if (hasDefaultApplExtID == FixUtils.TAG_HAS_VALUE) {		
				return defaultApplExtID; 		
			} else {

				buf.position(hasDefaultApplExtID);

			defaultApplExtID = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasDefaultApplExtID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return defaultApplExtID;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDefaultApplExtID() { return hasDefaultApplExtID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDefaultApplExtID(byte[] src) {		
		if (src == null ) return;
		if (hasDefaultApplExtID()) defaultApplExtID = FixUtils.TAG_HAS_NO_VALUE;		
		defaultApplExtID = FixUtils.longValueOf(src, 0, src.length);
		hasDefaultApplExtID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDefaultApplExtID(long src) {		
		defaultApplExtID = src;
		hasDefaultApplExtID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDefaultApplExtID(String str) {		
		if (str == null ) return;
		if (hasDefaultApplExtID()) defaultApplExtID = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		defaultApplExtID = FixUtils.longValueOf(src, 0, src.length);
		hasDefaultApplExtID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDefaultCstmApplVerID() {		
		getDefaultCstmApplVerID();		
	}		
			
	public byte[] getDefaultCstmApplVerID() { 		
		if ( hasDefaultCstmApplVerID()) {		
			if (hasDefaultCstmApplVerID == FixUtils.TAG_HAS_VALUE) {		
				return defaultCstmApplVerID; 		
			} else {

				buf.position(hasDefaultCstmApplVerID);

			FixMessage.getTagStringValue(buf, defaultCstmApplVerID, 0, defaultCstmApplVerID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasDefaultCstmApplVerID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return defaultCstmApplVerID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDefaultCstmApplVerID() { return hasDefaultCstmApplVerID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDefaultCstmApplVerID(byte[] src) {		
		if (src == null ) return;
		if (hasDefaultCstmApplVerID()) FixUtils.fillNul(defaultCstmApplVerID);		
		FixUtils.copy(defaultCstmApplVerID, src); 		
		hasDefaultCstmApplVerID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDefaultCstmApplVerID(String str) {		
		if (str == null ) return;
		if (hasDefaultCstmApplVerID()) FixUtils.fillNul(defaultCstmApplVerID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(defaultCstmApplVerID, src); 		
		hasDefaultCstmApplVerID = FixUtils.TAG_HAS_VALUE;		
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

					if (hasEncryptMethod()) s += "EncryptMethod(98)= " + getEncryptMethod() + "\n" ; 
		if (hasHeartBtInt()) s += "HeartBtInt(108)= " + getHeartBtInt() + "\n" ; 
		if (hasRawDataLength()) s += "RawDataLength(95)= " + getRawDataLength() + "\n" ; 
		if (hasRawData()) s += "RawData(96)= " + new String( FixUtils.trim(getRawData()) ) + "\n" ; 
		if (hasResetSeqNumFlag()) s += "ResetSeqNumFlag(141)= " + getResetSeqNumFlag() + "\n" ; 
		if (hasNextExpectedMsgSeqNum()) s += "NextExpectedMsgSeqNum(789)= " + getNextExpectedMsgSeqNum() + "\n" ; 
		if (hasMaxMessageSize()) s += "MaxMessageSize(383)= " + getMaxMessageSize() + "\n" ; 
		if (hasTestMessageIndicator()) s += "TestMessageIndicator(464)= " + getTestMessageIndicator() + "\n" ; 
		if (hasUsername()) s += "Username(553)= " + new String( FixUtils.trim(getUsername()) ) + "\n" ; 
		if (hasPassword()) s += "Password(554)= " + new String( FixUtils.trim(getPassword()) ) + "\n" ; 
		if (hasNewPassword()) s += "NewPassword(925)= " + new String( FixUtils.trim(getNewPassword()) ) + "\n" ; 
		if (hasEncryptedPasswordMethod()) s += "EncryptedPasswordMethod(1400)= " + getEncryptedPasswordMethod() + "\n" ; 
		if (hasEncryptedPasswordLen()) s += "EncryptedPasswordLen(1401)= " + getEncryptedPasswordLen() + "\n" ; 
		if (hasEncryptedPassword()) s += "EncryptedPassword(1402)= " + new String( FixUtils.trim(getEncryptedPassword()) ) + "\n" ; 
		if (hasEncryptedNewPasswordLen()) s += "EncryptedNewPasswordLen(1403)= " + getEncryptedNewPasswordLen() + "\n" ; 
		if (hasEncryptedNewPassword()) s += "EncryptedNewPassword(1404)= " + new String( FixUtils.trim(getEncryptedNewPassword()) ) + "\n" ; 
		if (hasSessionStatus()) s += "SessionStatus(1409)= " + getSessionStatus() + "\n" ; 
		if (hasDefaultApplVerID()) s += "DefaultApplVerID(1137)= " + new String( FixUtils.trim(getDefaultApplVerID()) ) + "\n" ; 
		if (hasDefaultApplExtID()) s += "DefaultApplExtID(1407)= " + getDefaultApplExtID() + "\n" ; 
		if (hasDefaultCstmApplVerID()) s += "DefaultCstmApplVerID(1408)= " + new String( FixUtils.trim(getDefaultCstmApplVerID()) ) + "\n" ; 
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
		if (! ( o instanceof FixLogon)) return false;

		FixLogon msg = (FixLogon) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasEncryptMethod() && !msg.hasEncryptMethod()) || (!hasEncryptMethod() && msg.hasEncryptMethod())) return false;
		if (!(!hasEncryptMethod() && !msg.hasEncryptMethod()) && !(getEncryptMethod()==msg.getEncryptMethod())) return false;
		if ((hasHeartBtInt() && !msg.hasHeartBtInt()) || (!hasHeartBtInt() && msg.hasHeartBtInt())) return false;
		if (!(!hasHeartBtInt() && !msg.hasHeartBtInt()) && !(getHeartBtInt()==msg.getHeartBtInt())) return false;
		if ((hasRawDataLength() && !msg.hasRawDataLength()) || (!hasRawDataLength() && msg.hasRawDataLength())) return false;
		if (!(!hasRawDataLength() && !msg.hasRawDataLength()) && !(getRawDataLength()==msg.getRawDataLength())) return false;
		if ((hasRawData() && !msg.hasRawData()) || (!hasRawData() && msg.hasRawData())) return false;
		if (!(!hasRawData() && !msg.hasRawData()) && !FixUtils.equals(getRawData(), msg.getRawData())) return false;
		if ((hasResetSeqNumFlag() && !msg.hasResetSeqNumFlag()) || (!hasResetSeqNumFlag() && msg.hasResetSeqNumFlag())) return false;
		if (!(!hasResetSeqNumFlag() && !msg.hasResetSeqNumFlag()) && !(getResetSeqNumFlag()==msg.getResetSeqNumFlag())) return false;
		if ((hasNextExpectedMsgSeqNum() && !msg.hasNextExpectedMsgSeqNum()) || (!hasNextExpectedMsgSeqNum() && msg.hasNextExpectedMsgSeqNum())) return false;
		if (!(!hasNextExpectedMsgSeqNum() && !msg.hasNextExpectedMsgSeqNum()) && !(getNextExpectedMsgSeqNum()==msg.getNextExpectedMsgSeqNum())) return false;
		if ((hasMaxMessageSize() && !msg.hasMaxMessageSize()) || (!hasMaxMessageSize() && msg.hasMaxMessageSize())) return false;
		if (!(!hasMaxMessageSize() && !msg.hasMaxMessageSize()) && !(getMaxMessageSize()==msg.getMaxMessageSize())) return false;
		if ((hasTestMessageIndicator() && !msg.hasTestMessageIndicator()) || (!hasTestMessageIndicator() && msg.hasTestMessageIndicator())) return false;
		if (!(!hasTestMessageIndicator() && !msg.hasTestMessageIndicator()) && !(getTestMessageIndicator()==msg.getTestMessageIndicator())) return false;
		if ((hasUsername() && !msg.hasUsername()) || (!hasUsername() && msg.hasUsername())) return false;
		if (!(!hasUsername() && !msg.hasUsername()) && !FixUtils.equals(getUsername(), msg.getUsername())) return false;
		if ((hasPassword() && !msg.hasPassword()) || (!hasPassword() && msg.hasPassword())) return false;
		if (!(!hasPassword() && !msg.hasPassword()) && !FixUtils.equals(getPassword(), msg.getPassword())) return false;
		if ((hasNewPassword() && !msg.hasNewPassword()) || (!hasNewPassword() && msg.hasNewPassword())) return false;
		if (!(!hasNewPassword() && !msg.hasNewPassword()) && !FixUtils.equals(getNewPassword(), msg.getNewPassword())) return false;
		if ((hasEncryptedPasswordMethod() && !msg.hasEncryptedPasswordMethod()) || (!hasEncryptedPasswordMethod() && msg.hasEncryptedPasswordMethod())) return false;
		if (!(!hasEncryptedPasswordMethod() && !msg.hasEncryptedPasswordMethod()) && !(getEncryptedPasswordMethod()==msg.getEncryptedPasswordMethod())) return false;
		if ((hasEncryptedPasswordLen() && !msg.hasEncryptedPasswordLen()) || (!hasEncryptedPasswordLen() && msg.hasEncryptedPasswordLen())) return false;
		if (!(!hasEncryptedPasswordLen() && !msg.hasEncryptedPasswordLen()) && !(getEncryptedPasswordLen()==msg.getEncryptedPasswordLen())) return false;
		if ((hasEncryptedPassword() && !msg.hasEncryptedPassword()) || (!hasEncryptedPassword() && msg.hasEncryptedPassword())) return false;
		if (!(!hasEncryptedPassword() && !msg.hasEncryptedPassword()) && !FixUtils.equals(getEncryptedPassword(), msg.getEncryptedPassword())) return false;
		if ((hasEncryptedNewPasswordLen() && !msg.hasEncryptedNewPasswordLen()) || (!hasEncryptedNewPasswordLen() && msg.hasEncryptedNewPasswordLen())) return false;
		if (!(!hasEncryptedNewPasswordLen() && !msg.hasEncryptedNewPasswordLen()) && !(getEncryptedNewPasswordLen()==msg.getEncryptedNewPasswordLen())) return false;
		if ((hasEncryptedNewPassword() && !msg.hasEncryptedNewPassword()) || (!hasEncryptedNewPassword() && msg.hasEncryptedNewPassword())) return false;
		if (!(!hasEncryptedNewPassword() && !msg.hasEncryptedNewPassword()) && !FixUtils.equals(getEncryptedNewPassword(), msg.getEncryptedNewPassword())) return false;
		if ((hasSessionStatus() && !msg.hasSessionStatus()) || (!hasSessionStatus() && msg.hasSessionStatus())) return false;
		if (!(!hasSessionStatus() && !msg.hasSessionStatus()) && !(getSessionStatus()==msg.getSessionStatus())) return false;
		if ((hasDefaultApplVerID() && !msg.hasDefaultApplVerID()) || (!hasDefaultApplVerID() && msg.hasDefaultApplVerID())) return false;
		if (!(!hasDefaultApplVerID() && !msg.hasDefaultApplVerID()) && !FixUtils.equals(getDefaultApplVerID(), msg.getDefaultApplVerID())) return false;
		if ((hasDefaultApplExtID() && !msg.hasDefaultApplExtID()) || (!hasDefaultApplExtID() && msg.hasDefaultApplExtID())) return false;
		if (!(!hasDefaultApplExtID() && !msg.hasDefaultApplExtID()) && !(getDefaultApplExtID()==msg.getDefaultApplExtID())) return false;
		if ((hasDefaultCstmApplVerID() && !msg.hasDefaultCstmApplVerID()) || (!hasDefaultCstmApplVerID() && msg.hasDefaultCstmApplVerID())) return false;
		if (!(!hasDefaultCstmApplVerID() && !msg.hasDefaultCstmApplVerID()) && !FixUtils.equals(getDefaultCstmApplVerID(), msg.getDefaultCstmApplVerID())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixLogon clone () {
		FixLogon out = new FixLogon();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixLogon clone ( FixLogon out ) {
		if ( hasEncryptMethod())
			out.setEncryptMethod(getEncryptMethod());
		if ( hasHeartBtInt())
			out.setHeartBtInt(getHeartBtInt());
		if ( hasRawDataLength())
			out.setRawDataLength(getRawDataLength());
		if ( hasRawData())
			out.setRawData(getRawData());
		if ( hasResetSeqNumFlag())
			out.setResetSeqNumFlag(getResetSeqNumFlag());
		if ( hasNextExpectedMsgSeqNum())
			out.setNextExpectedMsgSeqNum(getNextExpectedMsgSeqNum());
		if ( hasMaxMessageSize())
			out.setMaxMessageSize(getMaxMessageSize());
		if ( hasTestMessageIndicator())
			out.setTestMessageIndicator(getTestMessageIndicator());
		if ( hasUsername())
			out.setUsername(getUsername());
		if ( hasPassword())
			out.setPassword(getPassword());
		if ( hasNewPassword())
			out.setNewPassword(getNewPassword());
		if ( hasEncryptedPasswordMethod())
			out.setEncryptedPasswordMethod(getEncryptedPasswordMethod());
		if ( hasEncryptedPasswordLen())
			out.setEncryptedPasswordLen(getEncryptedPasswordLen());
		if ( hasEncryptedPassword())
			out.setEncryptedPassword(getEncryptedPassword());
		if ( hasEncryptedNewPasswordLen())
			out.setEncryptedNewPasswordLen(getEncryptedNewPasswordLen());
		if ( hasEncryptedNewPassword())
			out.setEncryptedNewPassword(getEncryptedNewPassword());
		if ( hasSessionStatus())
			out.setSessionStatus(getSessionStatus());
		if ( hasDefaultApplVerID())
			out.setDefaultApplVerID(getDefaultApplVerID());
		if ( hasDefaultApplExtID())
			out.setDefaultApplExtID(getDefaultApplExtID());
		if ( hasDefaultCstmApplVerID())
			out.setDefaultCstmApplVerID(getDefaultCstmApplVerID());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		int count = 0;
		count = 0;
		for (FixMsgTypeGrp fixMsgTypeGrp : msgTypeGrp) {
			if (!fixMsgTypeGrp.hasGroup()) continue;
			out.msgTypeGrp[count] = fixMsgTypeGrp.clone( out.msgTypeGrp[count] );
			count++;
		}
		return out;
	}

}
