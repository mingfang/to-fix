package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixPartyDetailsListReport extends FixInMessage {
	private short hasPartyDetailsListReportID;
	byte[] partyDetailsListReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPartyDetailsListRequestID;
	byte[] partyDetailsListRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPartyDetailsRequestResult;
	long partyDetailsRequestResult = 0;		
	private short hasTotNoPartyList;
	long totNoPartyList = 0;		
	private short hasLastFragment;
		boolean lastFragment = false;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixPartyListGrp[] partyListGrp;
	
	public FixPartyDetailsListReport() {
		super(FixMessageInfo.MessageTypes.PARTYDETAILSLISTREPORT);


		hasPartyDetailsListReportID = FixUtils.TAG_HAS_NO_VALUE;		
		partyDetailsListReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPartyDetailsListRequestID = FixUtils.TAG_HAS_NO_VALUE;		
		partyDetailsListRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPartyDetailsRequestResult = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotNoPartyList = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastFragment = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		applicationSequenceControl = new FixApplicationSequenceControl();
		partyListGrp = new FixPartyListGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) partyListGrp[i] = new FixPartyListGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.PARTYDETAILSLISTREPORTID_INT:		
            		hasPartyDetailsListReportID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PARTYDETAILSLISTREQUESTID_INT:		
            		hasPartyDetailsListRequestID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PARTYDETAILSREQUESTRESULT_INT:		
            		hasPartyDetailsRequestResult = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TOTNOPARTYLIST_INT:		
            		hasTotNoPartyList = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTFRAGMENT_INT:		
            		hasLastFragment = (short) buf.position();		
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
        			} else if ( applicationSequenceControl.isKeyTag(tag)) {
        				tag = applicationSequenceControl.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOPARTYLIST_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !partyListGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = partyListGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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

		if (!hasPartyDetailsListReportID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag PartyDetailsListReportID missing", FixTags.PARTYDETAILSLISTREPORTID_INT, FixMessageInfo.MessageTypes.PARTYDETAILSLISTREPORT);
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
		if (hasPartyDetailsListReportID()) {		
			out.put(FixTags.PARTYDETAILSLISTREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,partyDetailsListReportID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPartyDetailsListRequestID()) {		
			out.put(FixTags.PARTYDETAILSLISTREQUESTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,partyDetailsListRequestID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPartyDetailsRequestResult()) {		
			out.put(FixTags.PARTYDETAILSREQUESTRESULT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)partyDetailsRequestResult);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotNoPartyList()) {		
			out.put(FixTags.TOTNOPARTYLIST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totNoPartyList);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastFragment()) {		
			out.put(FixTags.LASTFRAGMENT);		
		
			out.put((byte) '=');		
		
			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
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
		
		applicationSequenceControl.encode(out);
		if (FixUtils.getNoInGroup(partyListGrp)>0) {
			out.put(FixTags.NOPARTYLIST);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(partyListGrp));

			out.put(FixUtils.SOH);

		}
		for (FixPartyListGrp fixPartyListGrp : partyListGrp) if (fixPartyListGrp.hasGroup()) fixPartyListGrp.encode(out);
		
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
		
		if (hasPartyDetailsListReportID()) {		
			FixUtils.put(out,partyDetailsListReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPartyDetailsListRequestID()) {		
			FixUtils.put(out,partyDetailsListRequestID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPartyDetailsRequestResult()) {		
			FixUtils.put(out, (long)partyDetailsRequestResult);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNoPartyList()) {		
			FixUtils.put(out, (long)totNoPartyList);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastFragment()) {		
			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
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
			
	public void crackPartyDetailsListReportID() {		
		getPartyDetailsListReportID();		
	}		
			
	public byte[] getPartyDetailsListReportID() { 		
		if ( hasPartyDetailsListReportID()) {		
			if (hasPartyDetailsListReportID == FixUtils.TAG_HAS_VALUE) {		
				return partyDetailsListReportID; 		
			} else {

				buf.position(hasPartyDetailsListReportID);

			FixMessage.getTagStringValue(buf, partyDetailsListReportID, 0, partyDetailsListReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasPartyDetailsListReportID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return partyDetailsListReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPartyDetailsListReportID() { return hasPartyDetailsListReportID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPartyDetailsListReportID(byte[] src) {		
		if (src == null ) return;
		if (hasPartyDetailsListReportID()) FixUtils.fillSpace(partyDetailsListReportID);		
		FixUtils.copy(partyDetailsListReportID, src); 		
		hasPartyDetailsListReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPartyDetailsListReportID(String str) {		
		if (str == null ) return;
		if (hasPartyDetailsListReportID()) FixUtils.fillSpace(partyDetailsListReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(partyDetailsListReportID, src); 		
		hasPartyDetailsListReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPartyDetailsListRequestID() {		
		getPartyDetailsListRequestID();		
	}		
			
	public byte[] getPartyDetailsListRequestID() { 		
		if ( hasPartyDetailsListRequestID()) {		
			if (hasPartyDetailsListRequestID == FixUtils.TAG_HAS_VALUE) {		
				return partyDetailsListRequestID; 		
			} else {

				buf.position(hasPartyDetailsListRequestID);

			FixMessage.getTagStringValue(buf, partyDetailsListRequestID, 0, partyDetailsListRequestID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasPartyDetailsListRequestID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return partyDetailsListRequestID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPartyDetailsListRequestID() { return hasPartyDetailsListRequestID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPartyDetailsListRequestID(byte[] src) {		
		if (src == null ) return;
		if (hasPartyDetailsListRequestID()) FixUtils.fillSpace(partyDetailsListRequestID);		
		FixUtils.copy(partyDetailsListRequestID, src); 		
		hasPartyDetailsListRequestID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPartyDetailsListRequestID(String str) {		
		if (str == null ) return;
		if (hasPartyDetailsListRequestID()) FixUtils.fillSpace(partyDetailsListRequestID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(partyDetailsListRequestID, src); 		
		hasPartyDetailsListRequestID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPartyDetailsRequestResult() {		
		getPartyDetailsRequestResult();		
	}		
			
	public long getPartyDetailsRequestResult() { 		
		if ( hasPartyDetailsRequestResult()) {		
			if (hasPartyDetailsRequestResult == FixUtils.TAG_HAS_VALUE) {		
				return partyDetailsRequestResult; 		
			} else {

				buf.position(hasPartyDetailsRequestResult);

			partyDetailsRequestResult = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPartyDetailsRequestResult = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return partyDetailsRequestResult;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPartyDetailsRequestResult() { return hasPartyDetailsRequestResult != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPartyDetailsRequestResult(byte[] src) {		
		if (src == null ) return;
		if (hasPartyDetailsRequestResult()) partyDetailsRequestResult = FixUtils.TAG_HAS_NO_VALUE;		
		partyDetailsRequestResult = FixUtils.longValueOf(src, 0, src.length);
		hasPartyDetailsRequestResult = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPartyDetailsRequestResult(long src) {		
		partyDetailsRequestResult = src;
		hasPartyDetailsRequestResult = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPartyDetailsRequestResult(String str) {		
		if (str == null ) return;
		if (hasPartyDetailsRequestResult()) partyDetailsRequestResult = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		partyDetailsRequestResult = FixUtils.longValueOf(src, 0, src.length);
		hasPartyDetailsRequestResult = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTotNoPartyList() {		
		getTotNoPartyList();		
	}		
			
	public long getTotNoPartyList() { 		
		if ( hasTotNoPartyList()) {		
			if (hasTotNoPartyList == FixUtils.TAG_HAS_VALUE) {		
				return totNoPartyList; 		
			} else {

				buf.position(hasTotNoPartyList);

			totNoPartyList = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotNoPartyList = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totNoPartyList;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNoPartyList() { return hasTotNoPartyList != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotNoPartyList(byte[] src) {		
		if (src == null ) return;
		if (hasTotNoPartyList()) totNoPartyList = FixUtils.TAG_HAS_NO_VALUE;		
		totNoPartyList = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoPartyList = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoPartyList(long src) {		
		totNoPartyList = src;
		hasTotNoPartyList = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoPartyList(String str) {		
		if (str == null ) return;
		if (hasTotNoPartyList()) totNoPartyList = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNoPartyList = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoPartyList = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastFragment() {		
		getLastFragment();		
	}		
			
	public boolean getLastFragment() { 		
		if ( hasLastFragment()) {		
			if (hasLastFragment == FixUtils.TAG_HAS_VALUE) {		
				return lastFragment; 		
			} else {

				buf.position(hasLastFragment);

			lastFragment = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasLastFragment = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastFragment;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasLastFragment() { return hasLastFragment != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastFragment(byte[] src) {		
		if (src == null ) return;
		if (hasLastFragment()) lastFragment = false;		
		lastFragment = src[0]==(byte)'Y'?true:false;		
		hasLastFragment = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastFragment(boolean src) {		
		lastFragment = src;
		hasLastFragment = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastFragment(String str) {		
		if (str == null ) return;
		if (hasLastFragment()) lastFragment = false;		
		byte[] src = str.getBytes(); 		
		lastFragment = src[0]==(byte)'Y'?true:false;		
		hasLastFragment = FixUtils.TAG_HAS_VALUE;		
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
		if (hasEncodedText()) FixUtils.fillSpace(encodedText);		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedText(String str) {		
		if (str == null ) return;
		if (hasEncodedText()) FixUtils.fillSpace(encodedText);		
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

					if (hasPartyDetailsListReportID()) s += "PartyDetailsListReportID(1510)= " + new String( FixUtils.trim(getPartyDetailsListReportID()) ) + "\n" ; 
		if (hasPartyDetailsListRequestID()) s += "PartyDetailsListRequestID(1505)= " + new String( FixUtils.trim(getPartyDetailsListRequestID()) ) + "\n" ; 
		if (hasPartyDetailsRequestResult()) s += "PartyDetailsRequestResult(1511)= " + getPartyDetailsRequestResult() + "\n" ; 
		if (hasTotNoPartyList()) s += "TotNoPartyList(1512)= " + getTotNoPartyList() + "\n" ; 
		if (hasLastFragment()) s += "LastFragment(893)= " + getLastFragment() + "\n" ; 
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
		if (! ( o instanceof FixPartyDetailsListReport)) return false;

		FixPartyDetailsListReport msg = (FixPartyDetailsListReport) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasPartyDetailsListReportID() && !msg.hasPartyDetailsListReportID()) || (!hasPartyDetailsListReportID() && msg.hasPartyDetailsListReportID())) return false;
		if (!(!hasPartyDetailsListReportID() && !msg.hasPartyDetailsListReportID()) && !FixUtils.equals(getPartyDetailsListReportID(), msg.getPartyDetailsListReportID())) return false;
		if ((hasPartyDetailsListRequestID() && !msg.hasPartyDetailsListRequestID()) || (!hasPartyDetailsListRequestID() && msg.hasPartyDetailsListRequestID())) return false;
		if (!(!hasPartyDetailsListRequestID() && !msg.hasPartyDetailsListRequestID()) && !FixUtils.equals(getPartyDetailsListRequestID(), msg.getPartyDetailsListRequestID())) return false;
		if ((hasPartyDetailsRequestResult() && !msg.hasPartyDetailsRequestResult()) || (!hasPartyDetailsRequestResult() && msg.hasPartyDetailsRequestResult())) return false;
		if (!(!hasPartyDetailsRequestResult() && !msg.hasPartyDetailsRequestResult()) && !(getPartyDetailsRequestResult()==msg.getPartyDetailsRequestResult())) return false;
		if ((hasTotNoPartyList() && !msg.hasTotNoPartyList()) || (!hasTotNoPartyList() && msg.hasTotNoPartyList())) return false;
		if (!(!hasTotNoPartyList() && !msg.hasTotNoPartyList()) && !(getTotNoPartyList()==msg.getTotNoPartyList())) return false;
		if ((hasLastFragment() && !msg.hasLastFragment()) || (!hasLastFragment() && msg.hasLastFragment())) return false;
		if (!(!hasLastFragment() && !msg.hasLastFragment()) && !(getLastFragment()==msg.getLastFragment())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixPartyDetailsListReport clone () {
		FixPartyDetailsListReport out = new FixPartyDetailsListReport();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixPartyDetailsListReport clone ( FixPartyDetailsListReport out ) {
		if ( hasPartyDetailsListReportID())
			out.setPartyDetailsListReportID(getPartyDetailsListReportID());
		if ( hasPartyDetailsListRequestID())
			out.setPartyDetailsListRequestID(getPartyDetailsListRequestID());
		if ( hasPartyDetailsRequestResult())
			out.setPartyDetailsRequestResult(getPartyDetailsRequestResult());
		if ( hasTotNoPartyList())
			out.setTotNoPartyList(getTotNoPartyList());
		if ( hasLastFragment())
			out.setLastFragment(getLastFragment());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		int count = 0;
		count = 0;
		for (FixPartyListGrp fixPartyListGrp : partyListGrp) {
			if (!fixPartyListGrp.hasGroup()) continue;
			out.partyListGrp[count] = fixPartyListGrp.clone( out.partyListGrp[count] );
			count++;
		}
		return out;
	}

}
