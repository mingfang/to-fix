package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixSettlementInstructions extends FixInMessage {
	private short hasSettlInstMsgID;
	byte[] settlInstMsgID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlInstReqID;
	byte[] settlInstReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlInstMode;
	byte settlInstMode = (byte)' ';		
	private short hasSettlInstReqRejCode;
	long settlInstReqRejCode = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	public FixSettlInstGrp[] settlInstGrp;
	
	public FixSettlementInstructions() {
		super(FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONS);


		hasSettlInstMsgID = FixUtils.TAG_HAS_NO_VALUE;		
		settlInstMsgID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlInstReqID = FixUtils.TAG_HAS_NO_VALUE;		
		settlInstReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlInstMode = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlInstReqRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		settlInstGrp = new FixSettlInstGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) settlInstGrp[i] = new FixSettlInstGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.SETTLINSTMSGID_INT:		
            		hasSettlInstMsgID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLINSTREQID_INT:		
            		hasSettlInstReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLINSTMODE_INT:		
            		hasSettlInstMode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLINSTREQREJCODE_INT:		
            		hasSettlInstReqRejCode = (short) buf.position();		
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
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOSETTLINST_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !settlInstGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = settlInstGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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

		if (!hasSettlInstMsgID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag SettlInstMsgID missing", FixTags.SETTLINSTMSGID_INT, FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONS);
			return false;
		}
		if (!hasSettlInstMode()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag SettlInstMode missing", FixTags.SETTLINSTMODE_INT, FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONS);
			return false;
		}
		if (!hasTransactTime()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TransactTime missing", FixTags.TRANSACTTIME_INT, FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONS);
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
		if (hasSettlInstMsgID()) {		
			out.put(FixTags.SETTLINSTMSGID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlInstMsgID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlInstReqID()) {		
			out.put(FixTags.SETTLINSTREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlInstReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlInstMode()) {		
			out.put(FixTags.SETTLINSTMODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlInstMode); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlInstReqRejCode()) {		
			out.put(FixTags.SETTLINSTREQREJCODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)settlInstReqRejCode);
		
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
		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(settlInstGrp)>0) {
			out.put(FixTags.NOSETTLINST);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(settlInstGrp));

			out.put(FixUtils.SOH);

		}
		for (FixSettlInstGrp fixSettlInstGrp : settlInstGrp) if (fixSettlInstGrp.hasGroup()) fixSettlInstGrp.encode(out);
		
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
		
		if (hasSettlInstMsgID()) {		
			FixUtils.put(out,settlInstMsgID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlInstReqID()) {		
			FixUtils.put(out,settlInstReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlInstMode()) {		
			FixUtils.put(out,settlInstMode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlInstReqRejCode()) {		
			FixUtils.put(out, (long)settlInstReqRejCode);
		
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
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
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
			
	public void crackSettlInstMsgID() {		
		getSettlInstMsgID();		
	}		
			
	public byte[] getSettlInstMsgID() { 		
		if ( hasSettlInstMsgID()) {		
			if (hasSettlInstMsgID == FixUtils.TAG_HAS_VALUE) {		
				return settlInstMsgID; 		
			} else {

				buf.position(hasSettlInstMsgID);

			FixMessage.getTagStringValue(buf, settlInstMsgID, 0, settlInstMsgID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlInstMsgID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlInstMsgID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlInstMsgID() { return hasSettlInstMsgID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlInstMsgID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlInstMsgID()) FixUtils.fillNul(settlInstMsgID);		
		FixUtils.copy(settlInstMsgID, src); 		
		hasSettlInstMsgID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlInstMsgID(String str) {		
		if (str == null ) return;
		if (hasSettlInstMsgID()) FixUtils.fillNul(settlInstMsgID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlInstMsgID, src); 		
		hasSettlInstMsgID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlInstReqID() {		
		getSettlInstReqID();		
	}		
			
	public byte[] getSettlInstReqID() { 		
		if ( hasSettlInstReqID()) {		
			if (hasSettlInstReqID == FixUtils.TAG_HAS_VALUE) {		
				return settlInstReqID; 		
			} else {

				buf.position(hasSettlInstReqID);

			FixMessage.getTagStringValue(buf, settlInstReqID, 0, settlInstReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlInstReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlInstReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlInstReqID() { return hasSettlInstReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlInstReqID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlInstReqID()) FixUtils.fillNul(settlInstReqID);		
		FixUtils.copy(settlInstReqID, src); 		
		hasSettlInstReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlInstReqID(String str) {		
		if (str == null ) return;
		if (hasSettlInstReqID()) FixUtils.fillNul(settlInstReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlInstReqID, src); 		
		hasSettlInstReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlInstMode() {		
		getSettlInstMode();		
	}		
			
	public byte getSettlInstMode() { 		
		if ( hasSettlInstMode()) {		
			if (hasSettlInstMode == FixUtils.TAG_HAS_VALUE) {		
				return settlInstMode; 		
			} else {

				buf.position(hasSettlInstMode);

			settlInstMode = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (settlInstMode != (byte)'3') && (settlInstMode != (byte)'2') && (settlInstMode != (byte)'1') && (settlInstMode != (byte)'0') && (settlInstMode != (byte)'5') && (settlInstMode != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 160);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasSettlInstMode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlInstMode;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSettlInstMode() { return hasSettlInstMode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlInstMode(byte[] src) {		
		if (src == null ) return;
		if (hasSettlInstMode()) settlInstMode = (byte)' ';		
		settlInstMode = src[0];		
		hasSettlInstMode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlInstMode(byte src) {		
		settlInstMode = src;
		hasSettlInstMode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlInstMode(String str) {		
		if (str == null ) return;
		if (hasSettlInstMode()) settlInstMode = (byte)' ';		
		byte[] src = str.getBytes(); 		
		settlInstMode = src[0];		
		hasSettlInstMode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlInstReqRejCode() {		
		getSettlInstReqRejCode();		
	}		
			
	public long getSettlInstReqRejCode() { 		
		if ( hasSettlInstReqRejCode()) {		
			if (hasSettlInstReqRejCode == FixUtils.TAG_HAS_VALUE) {		
				return settlInstReqRejCode; 		
			} else {

				buf.position(hasSettlInstReqRejCode);

			settlInstReqRejCode = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSettlInstReqRejCode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlInstReqRejCode;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlInstReqRejCode() { return hasSettlInstReqRejCode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlInstReqRejCode(byte[] src) {		
		if (src == null ) return;
		if (hasSettlInstReqRejCode()) settlInstReqRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		settlInstReqRejCode = FixUtils.longValueOf(src, 0, src.length);
		hasSettlInstReqRejCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlInstReqRejCode(long src) {		
		settlInstReqRejCode = src;
		hasSettlInstReqRejCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlInstReqRejCode(String str) {		
		if (str == null ) return;
		if (hasSettlInstReqRejCode()) settlInstReqRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlInstReqRejCode = FixUtils.longValueOf(src, 0, src.length);
		hasSettlInstReqRejCode = FixUtils.TAG_HAS_VALUE;		
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
		if (hasClOrdID()) FixUtils.fillNul(clOrdID);		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClOrdID(String str) {		
		if (str == null ) return;
		if (hasClOrdID()) FixUtils.fillNul(clOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
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

					if (hasSettlInstMsgID()) s += "SettlInstMsgID(777)= " + new String( FixUtils.trim(getSettlInstMsgID()) ) + "\n" ; 
		if (hasSettlInstReqID()) s += "SettlInstReqID(791)= " + new String( FixUtils.trim(getSettlInstReqID()) ) + "\n" ; 
		if (hasSettlInstMode()) s += "SettlInstMode(160)= " + getSettlInstMode() + "\n" ; 
		if (hasSettlInstReqRejCode()) s += "SettlInstReqRejCode(792)= " + getSettlInstReqRejCode() + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSettlementInstructions)) return false;

		FixSettlementInstructions msg = (FixSettlementInstructions) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasSettlInstMsgID() && !msg.hasSettlInstMsgID()) || (!hasSettlInstMsgID() && msg.hasSettlInstMsgID())) return false;
		if (!(!hasSettlInstMsgID() && !msg.hasSettlInstMsgID()) && !FixUtils.equals(getSettlInstMsgID(), msg.getSettlInstMsgID())) return false;
		if ((hasSettlInstReqID() && !msg.hasSettlInstReqID()) || (!hasSettlInstReqID() && msg.hasSettlInstReqID())) return false;
		if (!(!hasSettlInstReqID() && !msg.hasSettlInstReqID()) && !FixUtils.equals(getSettlInstReqID(), msg.getSettlInstReqID())) return false;
		if ((hasSettlInstMode() && !msg.hasSettlInstMode()) || (!hasSettlInstMode() && msg.hasSettlInstMode())) return false;
		if (!(!hasSettlInstMode() && !msg.hasSettlInstMode()) && !(getSettlInstMode()==msg.getSettlInstMode())) return false;
		if ((hasSettlInstReqRejCode() && !msg.hasSettlInstReqRejCode()) || (!hasSettlInstReqRejCode() && msg.hasSettlInstReqRejCode())) return false;
		if (!(!hasSettlInstReqRejCode() && !msg.hasSettlInstReqRejCode()) && !(getSettlInstReqRejCode()==msg.getSettlInstReqRejCode())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		return true;
	}
	@Override
	public FixSettlementInstructions clone () {
		FixSettlementInstructions out = new FixSettlementInstructions();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixSettlementInstructions clone ( FixSettlementInstructions out ) {
		if ( hasSettlInstMsgID())
			out.setSettlInstMsgID(getSettlInstMsgID());
		if ( hasSettlInstReqID())
			out.setSettlInstReqID(getSettlInstReqID());
		if ( hasSettlInstMode())
			out.setSettlInstMode(getSettlInstMode());
		if ( hasSettlInstReqRejCode())
			out.setSettlInstReqRejCode(getSettlInstReqRejCode());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		int count = 0;
		count = 0;
		for (FixSettlInstGrp fixSettlInstGrp : settlInstGrp) {
			if (!fixSettlInstGrp.hasGroup()) continue;
			out.settlInstGrp[count] = fixSettlInstGrp.clone( out.settlInstGrp[count] );
			count++;
		}
		return out;
	}

}
