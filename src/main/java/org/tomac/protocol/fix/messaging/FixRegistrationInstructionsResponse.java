package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixRegistrationInstructionsResponse extends FixInMessage {
	private short hasRegistID;
	byte[] registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRegistTransType;
	byte registTransType = (byte)' ';		
	private short hasRegistRefID;
	byte[] registRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAccount;
	byte[] account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAcctIDSource;
	long acctIDSource = 0;		
	private short hasRegistStatus;
	byte registStatus = (byte)' ';		
	private short hasRegistRejReasonCode;
	long registRejReasonCode = 0;		
	private short hasRegistRejReasonText;
	byte[] registRejReasonText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	FixParties[] parties;
	
	public FixRegistrationInstructionsResponse() {
		super(FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONSRESPONSE);


		hasRegistID = FixUtils.TAG_HAS_NO_VALUE;		
		registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRegistTransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasRegistRefID = FixUtils.TAG_HAS_NO_VALUE;		
		registRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;		
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasRegistStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasRegistRejReasonCode = FixUtils.TAG_HAS_NO_VALUE;		
		hasRegistRejReasonText = FixUtils.TAG_HAS_NO_VALUE;		
		registRejReasonText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.REGISTID_INT:		
            		hasRegistID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REGISTTRANSTYPE_INT:		
            		hasRegistTransType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REGISTREFID_INT:		
            		hasRegistRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCOUNT_INT:		
            		hasAccount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCTIDSOURCE_INT:		
            		hasAcctIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REGISTSTATUS_INT:		
            		hasRegistStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REGISTREJREASONCODE_INT:		
            		hasRegistRejReasonCode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REGISTREJREASONTEXT_INT:		
            		hasRegistRejReasonText = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !parties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
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

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	private boolean hasRequiredTags(FixValidationError err) {
		if (!hasRegistID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag RegistID missing", FixTags.REGISTID_INT, FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONSRESPONSE);
			return false;
		}
		if (!hasRegistTransType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag RegistTransType missing", FixTags.REGISTTRANSTYPE_INT, FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONSRESPONSE);
			return false;
		}
		if (!hasRegistRefID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag RegistRefID missing", FixTags.REGISTREFID_INT, FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONSRESPONSE);
			return false;
		}
		if (!hasRegistStatus()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag RegistStatus missing", FixTags.REGISTSTATUS_INT, FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONSRESPONSE);
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
		if (hasRegistID()) {		
			out.put(FixTags.REGISTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,registID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRegistTransType()) {		
			out.put(FixTags.REGISTTRANSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,registTransType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRegistRefID()) {		
			out.put(FixTags.REGISTREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,registRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAccount()) {		
			out.put(FixTags.ACCOUNT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,account); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAcctIDSource()) {		
			out.put(FixTags.ACCTIDSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)acctIDSource);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRegistStatus()) {		
			out.put(FixTags.REGISTSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,registStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRegistRejReasonCode()) {		
			out.put(FixTags.REGISTREJREASONCODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)registRejReasonCode);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRegistRejReasonText()) {		
			out.put(FixTags.REGISTREJREASONTEXT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,registRejReasonText); 		
		
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
		
		if (hasRegistID()) {		
			FixUtils.put(out,registID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRegistTransType()) {		
			FixUtils.put(out,registTransType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRegistRefID()) {		
			FixUtils.put(out,registRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAccount()) {		
			FixUtils.put(out,account); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAcctIDSource()) {		
			FixUtils.put(out, (long)acctIDSource);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRegistStatus()) {		
			FixUtils.put(out,registStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRegistRejReasonCode()) {		
			FixUtils.put(out, (long)registRejReasonCode);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRegistRejReasonText()) {		
			FixUtils.put(out,registRejReasonText); 		
		
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
			
	public void crackRegistID() {		
		getRegistID();		
	}		
			
	public byte[] getRegistID() { 		
		if ( hasRegistID()) {		
			if (hasRegistID == FixUtils.TAG_HAS_VALUE) {		
				return registID; 		
			} else {

				buf.position(hasRegistID);

			FixMessage.getTagStringValue(buf, registID, 0, registID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRegistID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return registID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRegistID() { return hasRegistID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRegistID(byte[] src) {		
		if (src == null ) return;
		if (hasRegistID()) FixUtils.fillSpace(registID);		
		FixUtils.copy(registID, src); 		
		hasRegistID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistID(String str) {		
		if (str == null ) return;
		if (hasRegistID()) FixUtils.fillSpace(registID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(registID, src); 		
		hasRegistID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRegistTransType() {		
		getRegistTransType();		
	}		
			
	public byte getRegistTransType() { 		
		if ( hasRegistTransType()) {		
			if (hasRegistTransType == FixUtils.TAG_HAS_VALUE) {		
				return registTransType; 		
			} else {

				buf.position(hasRegistTransType);

			registTransType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (registTransType != (byte)'2') && (registTransType != (byte)'1') && (registTransType != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 514);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasRegistTransType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return registTransType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasRegistTransType() { return hasRegistTransType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRegistTransType(byte[] src) {		
		if (src == null ) return;
		if (hasRegistTransType()) registTransType = (byte)' ';		
		registTransType = src[0];		
		hasRegistTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistTransType(byte src) {		
		registTransType = src;
		hasRegistTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistTransType(String str) {		
		if (str == null ) return;
		if (hasRegistTransType()) registTransType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		registTransType = src[0];		
		hasRegistTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRegistRefID() {		
		getRegistRefID();		
	}		
			
	public byte[] getRegistRefID() { 		
		if ( hasRegistRefID()) {		
			if (hasRegistRefID == FixUtils.TAG_HAS_VALUE) {		
				return registRefID; 		
			} else {

				buf.position(hasRegistRefID);

			FixMessage.getTagStringValue(buf, registRefID, 0, registRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRegistRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return registRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRegistRefID() { return hasRegistRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRegistRefID(byte[] src) {		
		if (src == null ) return;
		if (hasRegistRefID()) FixUtils.fillSpace(registRefID);		
		FixUtils.copy(registRefID, src); 		
		hasRegistRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistRefID(String str) {		
		if (str == null ) return;
		if (hasRegistRefID()) FixUtils.fillSpace(registRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(registRefID, src); 		
		hasRegistRefID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackAccount() {		
		getAccount();		
	}		
			
	public byte[] getAccount() { 		
		if ( hasAccount()) {		
			if (hasAccount == FixUtils.TAG_HAS_VALUE) {		
				return account; 		
			} else {

				buf.position(hasAccount);

			FixMessage.getTagStringValue(buf, account, 0, account.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAccount = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return account;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAccount() { return hasAccount != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAccount(byte[] src) {		
		if (src == null ) return;
		if (hasAccount()) FixUtils.fillSpace(account);		
		FixUtils.copy(account, src); 		
		hasAccount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccount(String str) {		
		if (str == null ) return;
		if (hasAccount()) FixUtils.fillSpace(account);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(account, src); 		
		hasAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAcctIDSource() {		
		getAcctIDSource();		
	}		
			
	public long getAcctIDSource() { 		
		if ( hasAcctIDSource()) {		
			if (hasAcctIDSource == FixUtils.TAG_HAS_VALUE) {		
				return acctIDSource; 		
			} else {

				buf.position(hasAcctIDSource);

			acctIDSource = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return acctIDSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAcctIDSource() { return hasAcctIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAcctIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasAcctIDSource()) acctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		acctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAcctIDSource(long src) {		
		acctIDSource = src;
		hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAcctIDSource(String str) {		
		if (str == null ) return;
		if (hasAcctIDSource()) acctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		acctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRegistStatus() {		
		getRegistStatus();		
	}		
			
	public byte getRegistStatus() { 		
		if ( hasRegistStatus()) {		
			if (hasRegistStatus == FixUtils.TAG_HAS_VALUE) {		
				return registStatus; 		
			} else {

				buf.position(hasRegistStatus);

			registStatus = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (registStatus != (byte)'A') && (registStatus != (byte)'R') && (registStatus != (byte)'N') && (registStatus != (byte)'H') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 506);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasRegistStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return registStatus;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasRegistStatus() { return hasRegistStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRegistStatus(byte[] src) {		
		if (src == null ) return;
		if (hasRegistStatus()) registStatus = (byte)' ';		
		registStatus = src[0];		
		hasRegistStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistStatus(byte src) {		
		registStatus = src;
		hasRegistStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistStatus(String str) {		
		if (str == null ) return;
		if (hasRegistStatus()) registStatus = (byte)' ';		
		byte[] src = str.getBytes(); 		
		registStatus = src[0];		
		hasRegistStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRegistRejReasonCode() {		
		getRegistRejReasonCode();		
	}		
			
	public long getRegistRejReasonCode() { 		
		if ( hasRegistRejReasonCode()) {		
			if (hasRegistRejReasonCode == FixUtils.TAG_HAS_VALUE) {		
				return registRejReasonCode; 		
			} else {

				buf.position(hasRegistRejReasonCode);

			registRejReasonCode = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasRegistRejReasonCode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return registRejReasonCode;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRegistRejReasonCode() { return hasRegistRejReasonCode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRegistRejReasonCode(byte[] src) {		
		if (src == null ) return;
		if (hasRegistRejReasonCode()) registRejReasonCode = FixUtils.TAG_HAS_NO_VALUE;		
		registRejReasonCode = FixUtils.longValueOf(src, 0, src.length);
		hasRegistRejReasonCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistRejReasonCode(long src) {		
		registRejReasonCode = src;
		hasRegistRejReasonCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistRejReasonCode(String str) {		
		if (str == null ) return;
		if (hasRegistRejReasonCode()) registRejReasonCode = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		registRejReasonCode = FixUtils.longValueOf(src, 0, src.length);
		hasRegistRejReasonCode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRegistRejReasonText() {		
		getRegistRejReasonText();		
	}		
			
	public byte[] getRegistRejReasonText() { 		
		if ( hasRegistRejReasonText()) {		
			if (hasRegistRejReasonText == FixUtils.TAG_HAS_VALUE) {		
				return registRejReasonText; 		
			} else {

				buf.position(hasRegistRejReasonText);

			FixMessage.getTagStringValue(buf, registRejReasonText, 0, registRejReasonText.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRegistRejReasonText = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return registRejReasonText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRegistRejReasonText() { return hasRegistRejReasonText != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRegistRejReasonText(byte[] src) {		
		if (src == null ) return;
		if (hasRegistRejReasonText()) FixUtils.fillSpace(registRejReasonText);		
		FixUtils.copy(registRejReasonText, src); 		
		hasRegistRejReasonText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistRejReasonText(String str) {		
		if (str == null ) return;
		if (hasRegistRejReasonText()) FixUtils.fillSpace(registRejReasonText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(registRejReasonText, src); 		
		hasRegistRejReasonText = FixUtils.TAG_HAS_VALUE;		
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
		if (standardHeader.hasApplVerID()) s += "ApplVerID(1128)= " + new String( FixUtils.trim(standardHeader.getApplVerID()) ) + "\n" ; 
		if (standardHeader.hasCstmApplVerID()) s += "CstmApplVerID(1129)= " + new String( FixUtils.trim(standardHeader.getCstmApplVerID()) ) + "\n" ; 
		if (standardHeader.hasApplExtID()) s += "ApplExtID(1156)= " + standardHeader.getApplExtID() + "\n" ; 

					if (hasRegistID()) s += "RegistID(513)= " + new String( FixUtils.trim(getRegistID()) ) + "\n" ; 
		if (hasRegistTransType()) s += "RegistTransType(514)= " + getRegistTransType() + "\n" ; 
		if (hasRegistRefID()) s += "RegistRefID(508)= " + new String( FixUtils.trim(getRegistRefID()) ) + "\n" ; 
		if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAcctIDSource()) s += "AcctIDSource(660)= " + getAcctIDSource() + "\n" ; 
		if (hasRegistStatus()) s += "RegistStatus(506)= " + getRegistStatus() + "\n" ; 
		if (hasRegistRejReasonCode()) s += "RegistRejReasonCode(507)= " + getRegistRejReasonCode() + "\n" ; 
		if (hasRegistRejReasonText()) s += "RegistRejReasonText(496)= " + new String( FixUtils.trim(getRegistRejReasonText()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRegistrationInstructionsResponse)) return false;

		FixRegistrationInstructionsResponse msg = (FixRegistrationInstructionsResponse) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasRegistID() && !msg.hasRegistID()) || (!hasRegistID() && msg.hasRegistID())) return false;
		if (!(!hasRegistID() && !msg.hasRegistID()) && !FixUtils.equals(getRegistID(), msg.getRegistID())) return false;
		if ((hasRegistTransType() && !msg.hasRegistTransType()) || (!hasRegistTransType() && msg.hasRegistTransType())) return false;
		if (!(!hasRegistTransType() && !msg.hasRegistTransType()) && !(getRegistTransType()==msg.getRegistTransType())) return false;
		if ((hasRegistRefID() && !msg.hasRegistRefID()) || (!hasRegistRefID() && msg.hasRegistRefID())) return false;
		if (!(!hasRegistRefID() && !msg.hasRegistRefID()) && !FixUtils.equals(getRegistRefID(), msg.getRegistRefID())) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasAccount() && !msg.hasAccount()) || (!hasAccount() && msg.hasAccount())) return false;
		if (!(!hasAccount() && !msg.hasAccount()) && !FixUtils.equals(getAccount(), msg.getAccount())) return false;
		if ((hasAcctIDSource() && !msg.hasAcctIDSource()) || (!hasAcctIDSource() && msg.hasAcctIDSource())) return false;
		if (!(!hasAcctIDSource() && !msg.hasAcctIDSource()) && !(getAcctIDSource()==msg.getAcctIDSource())) return false;
		if ((hasRegistStatus() && !msg.hasRegistStatus()) || (!hasRegistStatus() && msg.hasRegistStatus())) return false;
		if (!(!hasRegistStatus() && !msg.hasRegistStatus()) && !(getRegistStatus()==msg.getRegistStatus())) return false;
		if ((hasRegistRejReasonCode() && !msg.hasRegistRejReasonCode()) || (!hasRegistRejReasonCode() && msg.hasRegistRejReasonCode())) return false;
		if (!(!hasRegistRejReasonCode() && !msg.hasRegistRejReasonCode()) && !(getRegistRejReasonCode()==msg.getRegistRejReasonCode())) return false;
		if ((hasRegistRejReasonText() && !msg.hasRegistRejReasonText()) || (!hasRegistRejReasonText() && msg.hasRegistRejReasonText())) return false;
		if (!(!hasRegistRejReasonText() && !msg.hasRegistRejReasonText()) && !FixUtils.equals(getRegistRejReasonText(), msg.getRegistRejReasonText())) return false;
		return true;
	}
	@Override
	public FixRegistrationInstructionsResponse clone () {
		FixRegistrationInstructionsResponse out = new FixRegistrationInstructionsResponse();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixRegistrationInstructionsResponse clone ( FixRegistrationInstructionsResponse out ) {
		if ( hasRegistID())
			out.setRegistID(getRegistID());
		if ( hasRegistTransType())
			out.setRegistTransType(getRegistTransType());
		if ( hasRegistRefID())
			out.setRegistRefID(getRegistRefID());
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasAccount())
			out.setAccount(getAccount());
		if ( hasAcctIDSource())
			out.setAcctIDSource(getAcctIDSource());
		if ( hasRegistStatus())
			out.setRegistStatus(getRegistStatus());
		if ( hasRegistRejReasonCode())
			out.setRegistRejReasonCode(getRegistRejReasonCode());
		if ( hasRegistRejReasonText())
			out.setRegistRejReasonText(getRegistRejReasonText());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		return out;
	}

}
