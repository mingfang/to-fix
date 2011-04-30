package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixApplicationMessageRequestAck extends FixInMessage {
	private short hasApplResponseID;
	byte[] applResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasApplReqID;
	byte[] applReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasApplReqType;
	long applReqType = 0;		
	private short hasApplResponseType;
	long applResponseType = 0;		
	private short hasApplTotalMessageCount;
	long applTotalMessageCount = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixApplIDRequestAckGrp[] applIDRequestAckGrp;
	public FixParties[] parties;
	
	public FixApplicationMessageRequestAck() {
		super(FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREQUESTACK);


		hasApplResponseID = FixUtils.TAG_HAS_NO_VALUE;		
		applResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasApplReqID = FixUtils.TAG_HAS_NO_VALUE;		
		applReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasApplReqType = FixUtils.TAG_HAS_NO_VALUE;		
		hasApplResponseType = FixUtils.TAG_HAS_NO_VALUE;		
		hasApplTotalMessageCount = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		applIDRequestAckGrp = new FixApplIDRequestAckGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) applIDRequestAckGrp[i] = new FixApplIDRequestAckGrp();
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.APPLRESPONSEID_INT:		
            		hasApplResponseID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.APPLREQID_INT:		
            		hasApplReqID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.APPLREQTYPE_INT:		
            		hasApplReqType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.APPLRESPONSETYPE_INT:		
            		hasApplResponseType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.APPLTOTALMESSAGECOUNT_INT:		
            		hasApplTotalMessageCount = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TEXT_INT:		
            		hasText = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDTEXTLEN_INT:		
            		hasEncodedTextLen = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDTEXT_INT:		
            		hasEncodedText = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOAPPLIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !applIDRequestAckGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOAPPLIDS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = applIDRequestAckGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !parties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOPARTYIDS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREQUESTACK_INT);
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
		if (!hasApplResponseID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.APPLRESPONSEID_INT, FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREQUESTACK_INT);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		getApplResponseID();		
		getApplReqID();		
		getApplReqType();		
		getApplResponseType();		
		getApplTotalMessageCount();		
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
		if (hasApplResponseID()) {		
			out.put(FixTags.APPLRESPONSEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,applResponseID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasApplReqID()) {		
			out.put(FixTags.APPLREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,applReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasApplReqType()) {		
			out.put(FixTags.APPLREQTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)applReqType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasApplResponseType()) {		
			out.put(FixTags.APPLRESPONSETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)applResponseType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasApplTotalMessageCount()) {		
			out.put(FixTags.APPLTOTALMESSAGECOUNT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)applTotalMessageCount);
		
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
		
		if (FixUtils.getNoInGroup(applIDRequestAckGrp)>0) {
			out.put(FixTags.NOAPPLIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(applIDRequestAckGrp));

			out.put(FixUtils.SOH);

		}
		for (FixApplIDRequestAckGrp fixApplIDRequestAckGrp : applIDRequestAckGrp) if (fixApplIDRequestAckGrp.hasGroup()) fixApplIDRequestAckGrp.encode(out);
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		
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
		
		if (hasApplResponseID()) {		
			FixUtils.put(out,applResponseID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplReqID()) {		
			FixUtils.put(out,applReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplReqType()) {		
			FixUtils.put(out, (long)applReqType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplResponseType()) {		
			FixUtils.put(out, (long)applResponseType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplTotalMessageCount()) {		
			FixUtils.put(out, (long)applTotalMessageCount);
		
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
			
	public void crackApplResponseID() {		
		getApplResponseID();		
	}		
			
	public byte[] getApplResponseID() { 		
		if ( hasApplResponseID()) {		
			if (hasApplResponseID == FixUtils.TAG_HAS_VALUE) {		
				return applResponseID; 		
			} else {

				buf.position(hasApplResponseID);

			FixUtils.getTagStringValue(buf, applResponseID, 0, applResponseID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasApplResponseID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return applResponseID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasApplResponseID() { return hasApplResponseID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setApplResponseID(byte[] src) {		
		if (src == null ) return;
		if (hasApplResponseID()) FixUtils.fillNul(applResponseID);		
		FixUtils.copy(applResponseID, src); 		
		hasApplResponseID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplResponseID(String str) {		
		if (str == null ) return;
		if (hasApplResponseID()) FixUtils.fillNul(applResponseID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(applResponseID, src); 		
		hasApplResponseID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackApplReqID() {		
		getApplReqID();		
	}		
			
	public byte[] getApplReqID() { 		
		if ( hasApplReqID()) {		
			if (hasApplReqID == FixUtils.TAG_HAS_VALUE) {		
				return applReqID; 		
			} else {

				buf.position(hasApplReqID);

			FixUtils.getTagStringValue(buf, applReqID, 0, applReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasApplReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return applReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasApplReqID() { return hasApplReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setApplReqID(byte[] src) {		
		if (src == null ) return;
		if (hasApplReqID()) FixUtils.fillNul(applReqID);		
		FixUtils.copy(applReqID, src); 		
		hasApplReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplReqID(String str) {		
		if (str == null ) return;
		if (hasApplReqID()) FixUtils.fillNul(applReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(applReqID, src); 		
		hasApplReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackApplReqType() {		
		getApplReqType();		
	}		
			
	public long getApplReqType() { 		
		if ( hasApplReqType()) {		
			if (hasApplReqType == FixUtils.TAG_HAS_VALUE) {		
				return applReqType; 		
			} else {

				buf.position(hasApplReqType);

			applReqType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasApplReqType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return applReqType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplReqType() { return hasApplReqType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setApplReqType(byte[] src) {		
		if (src == null ) return;
		if (hasApplReqType()) applReqType = FixUtils.TAG_HAS_NO_VALUE;		
		applReqType = FixUtils.longValueOf(src, 0, src.length);
		hasApplReqType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplReqType(long src) {		
		applReqType = src;
		hasApplReqType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplReqType(String str) {		
		if (str == null ) return;
		if (hasApplReqType()) applReqType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applReqType = FixUtils.longValueOf(src, 0, src.length);
		hasApplReqType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackApplResponseType() {		
		getApplResponseType();		
	}		
			
	public long getApplResponseType() { 		
		if ( hasApplResponseType()) {		
			if (hasApplResponseType == FixUtils.TAG_HAS_VALUE) {		
				return applResponseType; 		
			} else {

				buf.position(hasApplResponseType);

			applResponseType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasApplResponseType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return applResponseType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplResponseType() { return hasApplResponseType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setApplResponseType(byte[] src) {		
		if (src == null ) return;
		if (hasApplResponseType()) applResponseType = FixUtils.TAG_HAS_NO_VALUE;		
		applResponseType = FixUtils.longValueOf(src, 0, src.length);
		hasApplResponseType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplResponseType(long src) {		
		applResponseType = src;
		hasApplResponseType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplResponseType(String str) {		
		if (str == null ) return;
		if (hasApplResponseType()) applResponseType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applResponseType = FixUtils.longValueOf(src, 0, src.length);
		hasApplResponseType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackApplTotalMessageCount() {		
		getApplTotalMessageCount();		
	}		
			
	public long getApplTotalMessageCount() { 		
		if ( hasApplTotalMessageCount()) {		
			if (hasApplTotalMessageCount == FixUtils.TAG_HAS_VALUE) {		
				return applTotalMessageCount; 		
			} else {

				buf.position(hasApplTotalMessageCount);

			applTotalMessageCount = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasApplTotalMessageCount = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return applTotalMessageCount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplTotalMessageCount() { return hasApplTotalMessageCount != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setApplTotalMessageCount(byte[] src) {		
		if (src == null ) return;
		if (hasApplTotalMessageCount()) applTotalMessageCount = FixUtils.TAG_HAS_NO_VALUE;		
		applTotalMessageCount = FixUtils.longValueOf(src, 0, src.length);
		hasApplTotalMessageCount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplTotalMessageCount(long src) {		
		applTotalMessageCount = src;
		hasApplTotalMessageCount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplTotalMessageCount(String str) {		
		if (str == null ) return;
		if (hasApplTotalMessageCount()) applTotalMessageCount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applTotalMessageCount = FixUtils.longValueOf(src, 0, src.length);
		hasApplTotalMessageCount = FixUtils.TAG_HAS_VALUE;		
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

			FixUtils.getTagStringValue(buf, text, 0, text.length, err);
		
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

			encodedTextLen = FixUtils.getTagIntValue(buf, err);
		
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

			FixUtils.getTagStringValue(buf, encodedText, 0, encodedText.length, err);
		
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

					if (hasApplResponseID()) s += "ApplResponseID(1353)= " + new String( FixUtils.trim(getApplResponseID()) ) + "\n" ; 
		if (hasApplReqID()) s += "ApplReqID(1346)= " + new String( FixUtils.trim(getApplReqID()) ) + "\n" ; 
		if (hasApplReqType()) s += "ApplReqType(1347)= " + getApplReqType() + "\n" ; 
		if (hasApplResponseType()) s += "ApplResponseType(1348)= " + getApplResponseType() + "\n" ; 
		if (hasApplTotalMessageCount()) s += "ApplTotalMessageCount(1349)= " + getApplTotalMessageCount() + "\n" ; 
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
		if (! ( o instanceof FixApplicationMessageRequestAck)) return false;

		FixApplicationMessageRequestAck msg = (FixApplicationMessageRequestAck) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasApplResponseID() && !msg.hasApplResponseID()) || (!hasApplResponseID() && msg.hasApplResponseID())) return false;
		if (!(!hasApplResponseID() && !msg.hasApplResponseID()) && !FixUtils.equals(getApplResponseID(), msg.getApplResponseID())) return false;
		if ((hasApplReqID() && !msg.hasApplReqID()) || (!hasApplReqID() && msg.hasApplReqID())) return false;
		if (!(!hasApplReqID() && !msg.hasApplReqID()) && !FixUtils.equals(getApplReqID(), msg.getApplReqID())) return false;
		if ((hasApplReqType() && !msg.hasApplReqType()) || (!hasApplReqType() && msg.hasApplReqType())) return false;
		if (!(!hasApplReqType() && !msg.hasApplReqType()) && !(getApplReqType()==msg.getApplReqType())) return false;
		if ((hasApplResponseType() && !msg.hasApplResponseType()) || (!hasApplResponseType() && msg.hasApplResponseType())) return false;
		if (!(!hasApplResponseType() && !msg.hasApplResponseType()) && !(getApplResponseType()==msg.getApplResponseType())) return false;
		if ((hasApplTotalMessageCount() && !msg.hasApplTotalMessageCount()) || (!hasApplTotalMessageCount() && msg.hasApplTotalMessageCount())) return false;
		if (!(!hasApplTotalMessageCount() && !msg.hasApplTotalMessageCount()) && !(getApplTotalMessageCount()==msg.getApplTotalMessageCount())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixApplicationMessageRequestAck clone () {
		FixApplicationMessageRequestAck out = new FixApplicationMessageRequestAck();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixApplicationMessageRequestAck clone ( FixApplicationMessageRequestAck out ) {
		if ( hasApplResponseID())
			out.setApplResponseID(getApplResponseID());
		if ( hasApplReqID())
			out.setApplReqID(getApplReqID());
		if ( hasApplReqType())
			out.setApplReqType(getApplReqType());
		if ( hasApplResponseType())
			out.setApplResponseType(getApplResponseType());
		if ( hasApplTotalMessageCount())
			out.setApplTotalMessageCount(getApplTotalMessageCount());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		int count = 0;
		count = 0;
		for (FixApplIDRequestAckGrp fixApplIDRequestAckGrp : applIDRequestAckGrp) {
			if (!fixApplIDRequestAckGrp.hasGroup()) continue;
			out.applIDRequestAckGrp[count] = fixApplIDRequestAckGrp.clone( out.applIDRequestAckGrp[count] );
			count++;
		}
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		return out;
	}

}
