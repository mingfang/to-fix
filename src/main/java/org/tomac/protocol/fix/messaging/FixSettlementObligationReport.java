package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixSettlementObligationReport extends FixInMessage {
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlementCycleNo;
	long settlementCycleNo = 0;		
	private short hasSettlObligMsgID;
	byte[] settlObligMsgID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlObligMode;
	long settlObligMode = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixSettlObligationInstructions[] settlObligationInstructions;
	
	public FixSettlementObligationReport() {
		super(FixMessageInfo.MessageTypes.SETTLEMENTOBLIGATIONREPORT);


		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlementCycleNo = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlObligMsgID = FixUtils.TAG_HAS_NO_VALUE;		
		settlObligMsgID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlObligMode = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		applicationSequenceControl = new FixApplicationSequenceControl();
		settlObligationInstructions = new FixSettlObligationInstructions[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) settlObligationInstructions[i] = new FixSettlObligationInstructions();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLEMENTCYCLENO_INT:		
            		hasSettlementCycleNo = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLOBLIGMSGID_INT:		
            		hasSettlObligMsgID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLOBLIGMODE_INT:		
            		hasSettlObligMode = (short) buf.position();		
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
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
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
        			} else if ( applicationSequenceControl.isKeyTag(tag)) {
        				tag = applicationSequenceControl.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOSETTLOBLIG_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !settlObligationInstructions[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = settlObligationInstructions[count].setBuffer( repeatingGroupTag, buf, err);	
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

		if (!hasSettlObligMsgID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag SettlObligMsgID missing", FixTags.SETTLOBLIGMSGID_INT, FixMessageInfo.MessageTypes.SETTLEMENTOBLIGATIONREPORT);
			return false;
		}
		if (!hasSettlObligMode()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag SettlObligMode missing", FixTags.SETTLOBLIGMODE_INT, FixMessageInfo.MessageTypes.SETTLEMENTOBLIGATIONREPORT);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (settlObligationInstructions[i].hasGroup()) settlObligationInstructions[i].hasRequiredTags(err); if (err.hasError()) return false; }
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
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlementCycleNo()) {		
			out.put(FixTags.SETTLEMENTCYCLENO);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)settlementCycleNo);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlObligMsgID()) {		
			out.put(FixTags.SETTLOBLIGMSGID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlObligMsgID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlObligMode()) {		
			out.put(FixTags.SETTLOBLIGMODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)settlObligMode);
		
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
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		applicationSequenceControl.encode(out);
		if (FixUtils.getNoInGroup(settlObligationInstructions)>0) {
			out.put(FixTags.NOSETTLOBLIG);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(settlObligationInstructions));

			out.put(FixUtils.SOH);

		}
		for (FixSettlObligationInstructions fixSettlObligationInstructions : settlObligationInstructions) if (fixSettlObligationInstructions.hasGroup()) fixSettlObligationInstructions.encode(out);
		
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
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlementCycleNo()) {		
			FixUtils.put(out, (long)settlementCycleNo);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlObligMsgID()) {		
			FixUtils.put(out,settlObligMsgID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlObligMode()) {		
			FixUtils.put(out, (long)settlObligMode);
		
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
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
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
			
	public void crackClearingBusinessDate() {		
		getClearingBusinessDate();		
	}		
			
	public byte[] getClearingBusinessDate() { 		
		if ( hasClearingBusinessDate()) {		
			if (hasClearingBusinessDate == FixUtils.TAG_HAS_VALUE) {		
				return clearingBusinessDate; 		
			} else {

				buf.position(hasClearingBusinessDate);

			FixMessage.getTagStringValue(buf, clearingBusinessDate, 0, clearingBusinessDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClearingBusinessDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clearingBusinessDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClearingBusinessDate() { return hasClearingBusinessDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClearingBusinessDate(byte[] src) {		
		if (src == null ) return;
		if (hasClearingBusinessDate()) FixUtils.fillNul(clearingBusinessDate);		
		FixUtils.copy(clearingBusinessDate, src); 		
		hasClearingBusinessDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClearingBusinessDate(String str) {		
		if (str == null ) return;
		if (hasClearingBusinessDate()) FixUtils.fillNul(clearingBusinessDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clearingBusinessDate, src); 		
		hasClearingBusinessDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlementCycleNo() {		
		getSettlementCycleNo();		
	}		
			
	public long getSettlementCycleNo() { 		
		if ( hasSettlementCycleNo()) {		
			if (hasSettlementCycleNo == FixUtils.TAG_HAS_VALUE) {		
				return settlementCycleNo; 		
			} else {

				buf.position(hasSettlementCycleNo);

			settlementCycleNo = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSettlementCycleNo = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlementCycleNo;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlementCycleNo() { return hasSettlementCycleNo != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlementCycleNo(byte[] src) {		
		if (src == null ) return;
		if (hasSettlementCycleNo()) settlementCycleNo = FixUtils.TAG_HAS_NO_VALUE;		
		settlementCycleNo = FixUtils.longValueOf(src, 0, src.length);
		hasSettlementCycleNo = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlementCycleNo(long src) {		
		settlementCycleNo = src;
		hasSettlementCycleNo = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlementCycleNo(String str) {		
		if (str == null ) return;
		if (hasSettlementCycleNo()) settlementCycleNo = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlementCycleNo = FixUtils.longValueOf(src, 0, src.length);
		hasSettlementCycleNo = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlObligMsgID() {		
		getSettlObligMsgID();		
	}		
			
	public byte[] getSettlObligMsgID() { 		
		if ( hasSettlObligMsgID()) {		
			if (hasSettlObligMsgID == FixUtils.TAG_HAS_VALUE) {		
				return settlObligMsgID; 		
			} else {

				buf.position(hasSettlObligMsgID);

			FixMessage.getTagStringValue(buf, settlObligMsgID, 0, settlObligMsgID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlObligMsgID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlObligMsgID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlObligMsgID() { return hasSettlObligMsgID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlObligMsgID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlObligMsgID()) FixUtils.fillNul(settlObligMsgID);		
		FixUtils.copy(settlObligMsgID, src); 		
		hasSettlObligMsgID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlObligMsgID(String str) {		
		if (str == null ) return;
		if (hasSettlObligMsgID()) FixUtils.fillNul(settlObligMsgID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlObligMsgID, src); 		
		hasSettlObligMsgID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlObligMode() {		
		getSettlObligMode();		
	}		
			
	public long getSettlObligMode() { 		
		if ( hasSettlObligMode()) {		
			if (hasSettlObligMode == FixUtils.TAG_HAS_VALUE) {		
				return settlObligMode; 		
			} else {

				buf.position(hasSettlObligMode);

			settlObligMode = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSettlObligMode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlObligMode;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlObligMode() { return hasSettlObligMode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlObligMode(byte[] src) {		
		if (src == null ) return;
		if (hasSettlObligMode()) settlObligMode = FixUtils.TAG_HAS_NO_VALUE;		
		settlObligMode = FixUtils.longValueOf(src, 0, src.length);
		hasSettlObligMode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlObligMode(long src) {		
		settlObligMode = src;
		hasSettlObligMode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlObligMode(String str) {		
		if (str == null ) return;
		if (hasSettlObligMode()) settlObligMode = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlObligMode = FixUtils.longValueOf(src, 0, src.length);
		hasSettlObligMode = FixUtils.TAG_HAS_VALUE;		
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

					if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasSettlementCycleNo()) s += "SettlementCycleNo(1153)= " + getSettlementCycleNo() + "\n" ; 
		if (hasSettlObligMsgID()) s += "SettlObligMsgID(1160)= " + new String( FixUtils.trim(getSettlObligMsgID()) ) + "\n" ; 
		if (hasSettlObligMode()) s += "SettlObligMode(1159)= " + getSettlObligMode() + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSettlementObligationReport)) return false;

		FixSettlementObligationReport msg = (FixSettlementObligationReport) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if ((hasSettlementCycleNo() && !msg.hasSettlementCycleNo()) || (!hasSettlementCycleNo() && msg.hasSettlementCycleNo())) return false;
		if (!(!hasSettlementCycleNo() && !msg.hasSettlementCycleNo()) && !(getSettlementCycleNo()==msg.getSettlementCycleNo())) return false;
		if ((hasSettlObligMsgID() && !msg.hasSettlObligMsgID()) || (!hasSettlObligMsgID() && msg.hasSettlObligMsgID())) return false;
		if (!(!hasSettlObligMsgID() && !msg.hasSettlObligMsgID()) && !FixUtils.equals(getSettlObligMsgID(), msg.getSettlObligMsgID())) return false;
		if ((hasSettlObligMode() && !msg.hasSettlObligMode()) || (!hasSettlObligMode() && msg.hasSettlObligMode())) return false;
		if (!(!hasSettlObligMode() && !msg.hasSettlObligMode()) && !(getSettlObligMode()==msg.getSettlObligMode())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		return true;
	}
	@Override
	public FixSettlementObligationReport clone () {
		FixSettlementObligationReport out = new FixSettlementObligationReport();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixSettlementObligationReport clone ( FixSettlementObligationReport out ) {
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasSettlementCycleNo())
			out.setSettlementCycleNo(getSettlementCycleNo());
		if ( hasSettlObligMsgID())
			out.setSettlObligMsgID(getSettlObligMsgID());
		if ( hasSettlObligMode())
			out.setSettlObligMode(getSettlObligMode());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		int count = 0;
		count = 0;
		for (FixSettlObligationInstructions fixSettlObligationInstructions : settlObligationInstructions) {
			if (!fixSettlObligationInstructions.hasGroup()) continue;
			out.settlObligationInstructions[count] = fixSettlObligationInstructions.clone( out.settlObligationInstructions[count] );
			count++;
		}
		return out;
	}

}
