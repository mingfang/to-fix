package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixConfirmationRequest extends FixInMessage {
	private short hasConfirmReqID;
	byte[] confirmReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasConfirmType;
	long confirmType = 0;		
	private short hasAllocID;
	byte[] allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryAllocID;
	byte[] secondaryAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasIndividualAllocID;
	byte[] individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasAllocAccount;
	byte[] allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocAcctIDSource;
	long allocAcctIDSource = 0;		
	private short hasAllocAccountType;
	long allocAccountType = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixOrdAllocGrp[] ordAllocGrp;
	
	public FixConfirmationRequest() {
		super(FixMessageInfo.MessageTypes.CONFIRMATIONREQUEST);


		hasConfirmReqID = FixUtils.TAG_HAS_NO_VALUE;		
		confirmReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasConfirmType = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasAllocAccount = FixUtils.TAG_HAS_NO_VALUE;		
		allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		ordAllocGrp = new FixOrdAllocGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) ordAllocGrp[i] = new FixOrdAllocGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.CONFIRMREQID_INT:		
            		hasConfirmReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CONFIRMTYPE_INT:		
            		hasConfirmType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCID_INT:		
            		hasAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYALLOCID_INT:		
            		hasSecondaryAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.INDIVIDUALALLOCID_INT:		
            		hasIndividualAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCACCOUNT_INT:		
            		hasAllocAccount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCACCTIDSOURCE_INT:		
            		hasAllocAcctIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCACCOUNTTYPE_INT:		
            		hasAllocAccountType = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOORDERS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !ordAllocGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = ordAllocGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.CONFIRMATIONREQUEST);
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

		if (!hasConfirmReqID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CONFIRMREQID_INT, FixMessageInfo.MessageTypes.CONFIRMATIONREQUEST);
			return false;
		}
		if (!hasConfirmType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CONFIRMTYPE_INT, FixMessageInfo.MessageTypes.CONFIRMATIONREQUEST);
			return false;
		}
		if (!hasTransactTime()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRANSACTTIME_INT, FixMessageInfo.MessageTypes.CONFIRMATIONREQUEST);
			return false;
		}
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getConfirmReqID();		
		getConfirmType();		
		getAllocID();		
		getSecondaryAllocID();		
		getIndividualAllocID();		
		getTransactTime();		
		getAllocAccount();		
		getAllocAcctIDSource();		
		getAllocAccountType();		
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
		if (hasConfirmReqID()) {		
			out.put(FixTags.CONFIRMREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,confirmReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasConfirmType()) {		
			out.put(FixTags.CONFIRMTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)confirmType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocID()) {		
			out.put(FixTags.ALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryAllocID()) {		
			out.put(FixTags.SECONDARYALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryAllocID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasIndividualAllocID()) {		
			out.put(FixTags.INDIVIDUALALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,individualAllocID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocAccount()) {		
			out.put(FixTags.ALLOCACCOUNT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocAccount); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocAcctIDSource()) {		
			out.put(FixTags.ALLOCACCTIDSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocAcctIDSource);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocAccountType()) {		
			out.put(FixTags.ALLOCACCOUNTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocAccountType);
		
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
		
		if (FixUtils.getNoInGroup(ordAllocGrp)>0) {
			out.put(FixTags.NOORDERS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(ordAllocGrp));

			out.put(FixUtils.SOH);

		}
		for (FixOrdAllocGrp fixOrdAllocGrp : ordAllocGrp) if (fixOrdAllocGrp.hasGroup()) fixOrdAllocGrp.encode(out);
		
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
		
		if (hasConfirmReqID()) {		
			FixUtils.put(out,confirmReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasConfirmType()) {		
			FixUtils.put(out, (long)confirmType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocID()) {		
			FixUtils.put(out,allocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryAllocID()) {		
			FixUtils.put(out,secondaryAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIndividualAllocID()) {		
			FixUtils.put(out,individualAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocAccount()) {		
			FixUtils.put(out,allocAccount); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocAcctIDSource()) {		
			FixUtils.put(out, (long)allocAcctIDSource);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocAccountType()) {		
			FixUtils.put(out, (long)allocAccountType);
		
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
			
	public void crackConfirmReqID() {		
		getConfirmReqID();		
	}		
			
	public byte[] getConfirmReqID() { 		
		if ( hasConfirmReqID()) {		
			if (hasConfirmReqID == FixUtils.TAG_HAS_VALUE) {		
				return confirmReqID; 		
			} else {

				buf.position(hasConfirmReqID);

			FixMessage.getTagStringValue(buf, confirmReqID, 0, confirmReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasConfirmReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return confirmReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasConfirmReqID() { return hasConfirmReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setConfirmReqID(byte[] src) {		
		if (src == null ) return;
		if (hasConfirmReqID()) FixUtils.fillNul(confirmReqID);		
		FixUtils.copy(confirmReqID, src); 		
		hasConfirmReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConfirmReqID(String str) {		
		if (str == null ) return;
		if (hasConfirmReqID()) FixUtils.fillNul(confirmReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(confirmReqID, src); 		
		hasConfirmReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackConfirmType() {		
		getConfirmType();		
	}		
			
	public long getConfirmType() { 		
		if ( hasConfirmType()) {		
			if (hasConfirmType == FixUtils.TAG_HAS_VALUE) {		
				return confirmType; 		
			} else {

				buf.position(hasConfirmType);

			confirmType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasConfirmType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return confirmType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasConfirmType() { return hasConfirmType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setConfirmType(byte[] src) {		
		if (src == null ) return;
		if (hasConfirmType()) confirmType = FixUtils.TAG_HAS_NO_VALUE;		
		confirmType = FixUtils.longValueOf(src, 0, src.length);
		hasConfirmType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConfirmType(long src) {		
		confirmType = src;
		hasConfirmType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConfirmType(String str) {		
		if (str == null ) return;
		if (hasConfirmType()) confirmType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		confirmType = FixUtils.longValueOf(src, 0, src.length);
		hasConfirmType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocID() {		
		getAllocID();		
	}		
			
	public byte[] getAllocID() { 		
		if ( hasAllocID()) {		
			if (hasAllocID == FixUtils.TAG_HAS_VALUE) {		
				return allocID; 		
			} else {

				buf.position(hasAllocID);

			FixMessage.getTagStringValue(buf, allocID, 0, allocID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAllocID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocID() { return hasAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasAllocID()) FixUtils.fillNul(allocID);		
		FixUtils.copy(allocID, src); 		
		hasAllocID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocID(String str) {		
		if (str == null ) return;
		if (hasAllocID()) FixUtils.fillNul(allocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocID, src); 		
		hasAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryAllocID() {		
		getSecondaryAllocID();		
	}		
			
	public byte[] getSecondaryAllocID() { 		
		if ( hasSecondaryAllocID()) {		
			if (hasSecondaryAllocID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryAllocID; 		
			} else {

				buf.position(hasSecondaryAllocID);

			FixMessage.getTagStringValue(buf, secondaryAllocID, 0, secondaryAllocID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryAllocID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryAllocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryAllocID() { return hasSecondaryAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryAllocID()) FixUtils.fillNul(secondaryAllocID);		
		FixUtils.copy(secondaryAllocID, src); 		
		hasSecondaryAllocID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryAllocID(String str) {		
		if (str == null ) return;
		if (hasSecondaryAllocID()) FixUtils.fillNul(secondaryAllocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryAllocID, src); 		
		hasSecondaryAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackIndividualAllocID() {		
		getIndividualAllocID();		
	}		
			
	public byte[] getIndividualAllocID() { 		
		if ( hasIndividualAllocID()) {		
			if (hasIndividualAllocID == FixUtils.TAG_HAS_VALUE) {		
				return individualAllocID; 		
			} else {

				buf.position(hasIndividualAllocID);

			FixMessage.getTagStringValue(buf, individualAllocID, 0, individualAllocID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return individualAllocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasIndividualAllocID() { return hasIndividualAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setIndividualAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasIndividualAllocID()) FixUtils.fillNul(individualAllocID);		
		FixUtils.copy(individualAllocID, src); 		
		hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIndividualAllocID(String str) {		
		if (str == null ) return;
		if (hasIndividualAllocID()) FixUtils.fillNul(individualAllocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(individualAllocID, src); 		
		hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTransactTime() {		
		getTransactTime();		
	}		
			
	public byte[] getTransactTime() { 		
		if ( hasTransactTime()) {		
			if (hasTransactTime == FixUtils.TAG_HAS_VALUE) {		
				return transactTime; 		
			} else {

				buf.position(hasTransactTime);

			FixMessage.getTagStringValue(buf, transactTime, 0, transactTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTransactTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return transactTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTransactTime() { return hasTransactTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTransactTime(byte[] src) {		
		if (src == null ) return;
		if (hasTransactTime()) FixUtils.fillNul(transactTime);		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTransactTime(String str) {		
		if (str == null ) return;
		if (hasTransactTime()) FixUtils.fillNul(transactTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocAccount() {		
		getAllocAccount();		
	}		
			
	public byte[] getAllocAccount() { 		
		if ( hasAllocAccount()) {		
			if (hasAllocAccount == FixUtils.TAG_HAS_VALUE) {		
				return allocAccount; 		
			} else {

				buf.position(hasAllocAccount);

			FixMessage.getTagStringValue(buf, allocAccount, 0, allocAccount.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocAccount;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocAccount() { return hasAllocAccount != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocAccount(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAccount()) FixUtils.fillNul(allocAccount);		
		FixUtils.copy(allocAccount, src); 		
		hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAccount(String str) {		
		if (str == null ) return;
		if (hasAllocAccount()) FixUtils.fillNul(allocAccount);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocAccount, src); 		
		hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocAcctIDSource() {		
		getAllocAcctIDSource();		
	}		
			
	public long getAllocAcctIDSource() { 		
		if ( hasAllocAcctIDSource()) {		
			if (hasAllocAcctIDSource == FixUtils.TAG_HAS_VALUE) {		
				return allocAcctIDSource; 		
			} else {

				buf.position(hasAllocAcctIDSource);

			allocAcctIDSource = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocAcctIDSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocAcctIDSource() { return hasAllocAcctIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocAcctIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAcctIDSource()) allocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		allocAcctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAcctIDSource(long src) {		
		allocAcctIDSource = src;
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAcctIDSource(String str) {		
		if (str == null ) return;
		if (hasAllocAcctIDSource()) allocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocAcctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocAccountType() {		
		getAllocAccountType();		
	}		
			
	public long getAllocAccountType() { 		
		if ( hasAllocAccountType()) {		
			if (hasAllocAccountType == FixUtils.TAG_HAS_VALUE) {		
				return allocAccountType; 		
			} else {

				buf.position(hasAllocAccountType);

			allocAccountType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocAccountType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocAccountType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocAccountType() { return hasAllocAccountType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocAccountType(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAccountType()) allocAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		allocAccountType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAccountType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAccountType(long src) {		
		allocAccountType = src;
		hasAllocAccountType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAccountType(String str) {		
		if (str == null ) return;
		if (hasAllocAccountType()) allocAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocAccountType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAccountType = FixUtils.TAG_HAS_VALUE;		
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

					if (hasConfirmReqID()) s += "ConfirmReqID(859)= " + new String( FixUtils.trim(getConfirmReqID()) ) + "\n" ; 
		if (hasConfirmType()) s += "ConfirmType(773)= " + getConfirmType() + "\n" ; 
		if (hasAllocID()) s += "AllocID(70)= " + new String( FixUtils.trim(getAllocID()) ) + "\n" ; 
		if (hasSecondaryAllocID()) s += "SecondaryAllocID(793)= " + new String( FixUtils.trim(getSecondaryAllocID()) ) + "\n" ; 
		if (hasIndividualAllocID()) s += "IndividualAllocID(467)= " + new String( FixUtils.trim(getIndividualAllocID()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasAllocAccount()) s += "AllocAccount(79)= " + new String( FixUtils.trim(getAllocAccount()) ) + "\n" ; 
		if (hasAllocAcctIDSource()) s += "AllocAcctIDSource(661)= " + getAllocAcctIDSource() + "\n" ; 
		if (hasAllocAccountType()) s += "AllocAccountType(798)= " + getAllocAccountType() + "\n" ; 
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
		if (! ( o instanceof FixConfirmationRequest)) return false;

		FixConfirmationRequest msg = (FixConfirmationRequest) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasConfirmReqID() && !msg.hasConfirmReqID()) || (!hasConfirmReqID() && msg.hasConfirmReqID())) return false;
		if (!(!hasConfirmReqID() && !msg.hasConfirmReqID()) && !FixUtils.equals(getConfirmReqID(), msg.getConfirmReqID())) return false;
		if ((hasConfirmType() && !msg.hasConfirmType()) || (!hasConfirmType() && msg.hasConfirmType())) return false;
		if (!(!hasConfirmType() && !msg.hasConfirmType()) && !(getConfirmType()==msg.getConfirmType())) return false;
		if ((hasAllocID() && !msg.hasAllocID()) || (!hasAllocID() && msg.hasAllocID())) return false;
		if (!(!hasAllocID() && !msg.hasAllocID()) && !FixUtils.equals(getAllocID(), msg.getAllocID())) return false;
		if ((hasSecondaryAllocID() && !msg.hasSecondaryAllocID()) || (!hasSecondaryAllocID() && msg.hasSecondaryAllocID())) return false;
		if (!(!hasSecondaryAllocID() && !msg.hasSecondaryAllocID()) && !FixUtils.equals(getSecondaryAllocID(), msg.getSecondaryAllocID())) return false;
		if ((hasIndividualAllocID() && !msg.hasIndividualAllocID()) || (!hasIndividualAllocID() && msg.hasIndividualAllocID())) return false;
		if (!(!hasIndividualAllocID() && !msg.hasIndividualAllocID()) && !FixUtils.equals(getIndividualAllocID(), msg.getIndividualAllocID())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasAllocAccount() && !msg.hasAllocAccount()) || (!hasAllocAccount() && msg.hasAllocAccount())) return false;
		if (!(!hasAllocAccount() && !msg.hasAllocAccount()) && !FixUtils.equals(getAllocAccount(), msg.getAllocAccount())) return false;
		if ((hasAllocAcctIDSource() && !msg.hasAllocAcctIDSource()) || (!hasAllocAcctIDSource() && msg.hasAllocAcctIDSource())) return false;
		if (!(!hasAllocAcctIDSource() && !msg.hasAllocAcctIDSource()) && !(getAllocAcctIDSource()==msg.getAllocAcctIDSource())) return false;
		if ((hasAllocAccountType() && !msg.hasAllocAccountType()) || (!hasAllocAccountType() && msg.hasAllocAccountType())) return false;
		if (!(!hasAllocAccountType() && !msg.hasAllocAccountType()) && !(getAllocAccountType()==msg.getAllocAccountType())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixConfirmationRequest clone () {
		FixConfirmationRequest out = new FixConfirmationRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixConfirmationRequest clone ( FixConfirmationRequest out ) {
		if ( hasConfirmReqID())
			out.setConfirmReqID(getConfirmReqID());
		if ( hasConfirmType())
			out.setConfirmType(getConfirmType());
		if ( hasAllocID())
			out.setAllocID(getAllocID());
		if ( hasSecondaryAllocID())
			out.setSecondaryAllocID(getSecondaryAllocID());
		if ( hasIndividualAllocID())
			out.setIndividualAllocID(getIndividualAllocID());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasAllocAccount())
			out.setAllocAccount(getAllocAccount());
		if ( hasAllocAcctIDSource())
			out.setAllocAcctIDSource(getAllocAcctIDSource());
		if ( hasAllocAccountType())
			out.setAllocAccountType(getAllocAccountType());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		int count = 0;
		count = 0;
		for (FixOrdAllocGrp fixOrdAllocGrp : ordAllocGrp) {
			if (!fixOrdAllocGrp.hasGroup()) continue;
			out.ordAllocGrp[count] = fixOrdAllocGrp.clone( out.ordAllocGrp[count] );
			count++;
		}
		return out;
	}

}
