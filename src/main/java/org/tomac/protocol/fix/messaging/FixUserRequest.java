package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixUserRequest extends FixInMessage {
	private short hasUserRequestID;
	byte[] userRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUserRequestType;
	long userRequestType = 0;		
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
	private short hasRawDataLength;
	long rawDataLength = 0;		
	private short hasRawData;
	byte[] rawData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixUserRequest() {
		super(FixMessageInfo.MessageTypes.USERREQUEST);


		hasUserRequestID = FixUtils.TAG_HAS_NO_VALUE;		
		userRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUserRequestType = FixUtils.TAG_HAS_NO_VALUE;		
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
		hasRawDataLength = FixUtils.TAG_HAS_NO_VALUE;		
		hasRawData = FixUtils.TAG_HAS_NO_VALUE;		
		rawData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.USERREQUESTID_INT:		
            		hasUserRequestID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.USERREQUESTTYPE_INT:		
            		hasUserRequestType = (short) buf.position();		
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
            	case FixTags.RAWDATALENGTH_INT:		
            		hasRawDataLength = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RAWDATA_INT:		
            		hasRawData = (short) buf.position();		
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

		if (!hasUserRequestID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag UserRequestID missing", FixTags.USERREQUESTID_INT, FixMessageInfo.MessageTypes.USERREQUEST);
			return false;
		}
		if (!hasUserRequestType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag UserRequestType missing", FixTags.USERREQUESTTYPE_INT, FixMessageInfo.MessageTypes.USERREQUEST);
			return false;
		}
		if (!hasUsername()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Username missing", FixTags.USERNAME_INT, FixMessageInfo.MessageTypes.USERREQUEST);
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
		if (hasUserRequestID()) {		
			out.put(FixTags.USERREQUESTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,userRequestID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUserRequestType()) {		
			out.put(FixTags.USERREQUESTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)userRequestType);
		
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
		
		if (hasUserRequestID()) {		
			FixUtils.put(out,userRequestID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUserRequestType()) {		
			FixUtils.put(out, (long)userRequestType);
		
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
		
		if (hasRawDataLength()) {		
			FixUtils.put(out, (long)rawDataLength);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRawData()) {		
			FixUtils.put(out,rawData); 		
		
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

			FixMessage.getTagStringValue(buf, userRequestID, 0, userRequestID.length, err);
		
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
			
	public void crackUserRequestType() {		
		getUserRequestType();		
	}		
			
	public long getUserRequestType() { 		
		if ( hasUserRequestType()) {		
			if (hasUserRequestType == FixUtils.TAG_HAS_VALUE) {		
				return userRequestType; 		
			} else {

				buf.position(hasUserRequestType);

			userRequestType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasUserRequestType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return userRequestType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUserRequestType() { return hasUserRequestType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUserRequestType(byte[] src) {		
		if (src == null ) return;
		if (hasUserRequestType()) userRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		userRequestType = FixUtils.longValueOf(src, 0, src.length);
		hasUserRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUserRequestType(long src) {		
		userRequestType = src;
		hasUserRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUserRequestType(String str) {		
		if (str == null ) return;
		if (hasUserRequestType()) userRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		userRequestType = FixUtils.longValueOf(src, 0, src.length);
		hasUserRequestType = FixUtils.TAG_HAS_VALUE;		
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
		if (hasUserRequestType()) s += "UserRequestType(924)= " + getUserRequestType() + "\n" ; 
		if (hasUsername()) s += "Username(553)= " + new String( FixUtils.trim(getUsername()) ) + "\n" ; 
		if (hasPassword()) s += "Password(554)= " + new String( FixUtils.trim(getPassword()) ) + "\n" ; 
		if (hasNewPassword()) s += "NewPassword(925)= " + new String( FixUtils.trim(getNewPassword()) ) + "\n" ; 
		if (hasEncryptedPasswordMethod()) s += "EncryptedPasswordMethod(1400)= " + getEncryptedPasswordMethod() + "\n" ; 
		if (hasEncryptedPasswordLen()) s += "EncryptedPasswordLen(1401)= " + getEncryptedPasswordLen() + "\n" ; 
		if (hasEncryptedPassword()) s += "EncryptedPassword(1402)= " + new String( FixUtils.trim(getEncryptedPassword()) ) + "\n" ; 
		if (hasEncryptedNewPasswordLen()) s += "EncryptedNewPasswordLen(1403)= " + getEncryptedNewPasswordLen() + "\n" ; 
		if (hasEncryptedNewPassword()) s += "EncryptedNewPassword(1404)= " + new String( FixUtils.trim(getEncryptedNewPassword()) ) + "\n" ; 
		if (hasRawDataLength()) s += "RawDataLength(95)= " + getRawDataLength() + "\n" ; 
		if (hasRawData()) s += "RawData(96)= " + new String( FixUtils.trim(getRawData()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUserRequest)) return false;

		FixUserRequest msg = (FixUserRequest) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasUserRequestID() && !msg.hasUserRequestID()) || (!hasUserRequestID() && msg.hasUserRequestID())) return false;
		if (!(!hasUserRequestID() && !msg.hasUserRequestID()) && !FixUtils.equals(getUserRequestID(), msg.getUserRequestID())) return false;
		if ((hasUserRequestType() && !msg.hasUserRequestType()) || (!hasUserRequestType() && msg.hasUserRequestType())) return false;
		if (!(!hasUserRequestType() && !msg.hasUserRequestType()) && !(getUserRequestType()==msg.getUserRequestType())) return false;
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
		if ((hasRawDataLength() && !msg.hasRawDataLength()) || (!hasRawDataLength() && msg.hasRawDataLength())) return false;
		if (!(!hasRawDataLength() && !msg.hasRawDataLength()) && !(getRawDataLength()==msg.getRawDataLength())) return false;
		if ((hasRawData() && !msg.hasRawData()) || (!hasRawData() && msg.hasRawData())) return false;
		if (!(!hasRawData() && !msg.hasRawData()) && !FixUtils.equals(getRawData(), msg.getRawData())) return false;
		return true;
	}
	@Override
	public FixUserRequest clone () {
		FixUserRequest out = new FixUserRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixUserRequest clone ( FixUserRequest out ) {
		if ( hasUserRequestID())
			out.setUserRequestID(getUserRequestID());
		if ( hasUserRequestType())
			out.setUserRequestType(getUserRequestType());
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
		if ( hasRawDataLength())
			out.setRawDataLength(getRawDataLength());
		if ( hasRawData())
			out.setRawData(getRawData());
		return out;
	}

}
