package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixQuoteRequestReject extends FixInMessage {
	private short hasQuoteReqID;
	byte[] quoteReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRFQReqID;
	byte[] rFQReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteRequestRejectReason;
	long quoteRequestRejectReason = 0;		
	private short hasPrivateQuote;
		boolean privateQuote = false;		
	private short hasRespondentType;
	long respondentType = 0;		
	private short hasPreTradeAnonymity;
		boolean preTradeAnonymity = false;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixRootParties[] rootParties;
	public FixQuotReqRjctGrp[] quotReqRjctGrp;
	
	public FixQuoteRequestReject() {
		super(FixMessageInfo.MessageTypes.QUOTEREQUESTREJECT);


		hasQuoteReqID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRFQReqID = FixUtils.TAG_HAS_NO_VALUE;		
		rFQReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteRequestRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasPrivateQuote = FixUtils.TAG_HAS_NO_VALUE;		
		hasRespondentType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPreTradeAnonymity = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		rootParties = new FixRootParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rootParties[i] = new FixRootParties();
		quotReqRjctGrp = new FixQuotReqRjctGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) quotReqRjctGrp[i] = new FixQuotReqRjctGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.QUOTEREQID_INT:		
            		hasQuoteReqID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.RFQREQID_INT:		
            		hasRFQReqID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.QUOTEREQUESTREJECTREASON_INT:		
            		hasQuoteRequestRejectReason = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRIVATEQUOTE_INT:		
            		hasPrivateQuote = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.RESPONDENTTYPE_INT:		
            		hasRespondentType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRETRADEANONYMITY_INT:		
            		hasPreTradeAnonymity = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOROOTPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !rootParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOROOTPARTYIDS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = rootParties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NORELATEDSYM_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !quotReqRjctGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NORELATEDSYM_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = quotReqRjctGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.QUOTEREQUESTREJECT_INT);
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
		if (!hasQuoteReqID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.QUOTEREQID_INT, FixMessageInfo.MessageTypes.QUOTEREQUESTREJECT_INT);
			return false;
		}
		if (!hasQuoteRequestRejectReason()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.QUOTEREQUESTREJECTREASON_INT, FixMessageInfo.MessageTypes.QUOTEREQUESTREJECT_INT);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (quotReqRjctGrp[i].hasGroup()) quotReqRjctGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		return true;
	}
	@Override		
	public void getAll() {		
		getQuoteReqID();		
		getRFQReqID();		
		getQuoteRequestRejectReason();		
		getPrivateQuote();		
		getRespondentType();		
		getPreTradeAnonymity();		
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
		if (hasQuoteReqID()) {		
			out.put(FixTags.QUOTEREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,quoteReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRFQReqID()) {		
			out.put(FixTags.RFQREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,rFQReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteRequestRejectReason()) {		
			out.put(FixTags.QUOTEREQUESTREJECTREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)quoteRequestRejectReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPrivateQuote()) {		
			out.put(FixTags.PRIVATEQUOTE);		
		
			out.put((byte) '=');		
		
			out.put(privateQuote?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRespondentType()) {		
			out.put(FixTags.RESPONDENTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)respondentType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPreTradeAnonymity()) {		
			out.put(FixTags.PRETRADEANONYMITY);		
		
			out.put((byte) '=');		
		
			out.put(preTradeAnonymity?(byte)'Y':(byte)'N' );
		
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
		
		if (FixUtils.getNoInGroup(rootParties)>0) {
			out.put(FixTags.NOROOTPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(rootParties));

			out.put(FixUtils.SOH);

		}
		for (FixRootParties fixRootParties : rootParties) if (fixRootParties.hasGroup()) fixRootParties.encode(out);
		if (FixUtils.getNoInGroup(quotReqRjctGrp)>0) {
			out.put(FixTags.NORELATEDSYM);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(quotReqRjctGrp));

			out.put(FixUtils.SOH);

		}
		for (FixQuotReqRjctGrp fixQuotReqRjctGrp : quotReqRjctGrp) if (fixQuotReqRjctGrp.hasGroup()) fixQuotReqRjctGrp.encode(out);
		
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
		
		if (hasQuoteReqID()) {		
			FixUtils.put(out,quoteReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRFQReqID()) {		
			FixUtils.put(out,rFQReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteRequestRejectReason()) {		
			FixUtils.put(out, (long)quoteRequestRejectReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPrivateQuote()) {		
			out.put(privateQuote?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRespondentType()) {		
			FixUtils.put(out, (long)respondentType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPreTradeAnonymity()) {		
			out.put(preTradeAnonymity?(byte)'Y':(byte)'N' );
		
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
			
	public void crackQuoteReqID() {		
		getQuoteReqID();		
	}		
			
	public byte[] getQuoteReqID() { 		
		if ( hasQuoteReqID()) {		
			if (hasQuoteReqID == FixUtils.TAG_HAS_VALUE) {		
				return quoteReqID; 		
			} else {

				buf.position(hasQuoteReqID);

			FixUtils.getTagStringValue(buf, quoteReqID, 0, quoteReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasQuoteReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteReqID() { return hasQuoteReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteReqID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteReqID()) FixUtils.fillNul(quoteReqID);		
		FixUtils.copy(quoteReqID, src); 		
		hasQuoteReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteReqID(String str) {		
		if (str == null ) return;
		if (hasQuoteReqID()) FixUtils.fillNul(quoteReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteReqID, src); 		
		hasQuoteReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRFQReqID() {		
		getRFQReqID();		
	}		
			
	public byte[] getRFQReqID() { 		
		if ( hasRFQReqID()) {		
			if (hasRFQReqID == FixUtils.TAG_HAS_VALUE) {		
				return rFQReqID; 		
			} else {

				buf.position(hasRFQReqID);

			FixUtils.getTagStringValue(buf, rFQReqID, 0, rFQReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRFQReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return rFQReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRFQReqID() { return hasRFQReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRFQReqID(byte[] src) {		
		if (src == null ) return;
		if (hasRFQReqID()) FixUtils.fillNul(rFQReqID);		
		FixUtils.copy(rFQReqID, src); 		
		hasRFQReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRFQReqID(String str) {		
		if (str == null ) return;
		if (hasRFQReqID()) FixUtils.fillNul(rFQReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(rFQReqID, src); 		
		hasRFQReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteRequestRejectReason() {		
		getQuoteRequestRejectReason();		
	}		
			
	public long getQuoteRequestRejectReason() { 		
		if ( hasQuoteRequestRejectReason()) {		
			if (hasQuoteRequestRejectReason == FixUtils.TAG_HAS_VALUE) {		
				return quoteRequestRejectReason; 		
			} else {

				buf.position(hasQuoteRequestRejectReason);

			quoteRequestRejectReason = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQuoteRequestRejectReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteRequestRejectReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuoteRequestRejectReason() { return hasQuoteRequestRejectReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteRequestRejectReason(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteRequestRejectReason()) quoteRequestRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		quoteRequestRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteRequestRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteRequestRejectReason(long src) {		
		quoteRequestRejectReason = src;
		hasQuoteRequestRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteRequestRejectReason(String str) {		
		if (str == null ) return;
		if (hasQuoteRequestRejectReason()) quoteRequestRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quoteRequestRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteRequestRejectReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPrivateQuote() {		
		getPrivateQuote();		
	}		
			
	public boolean getPrivateQuote() { 		
		if ( hasPrivateQuote()) {		
			if (hasPrivateQuote == FixUtils.TAG_HAS_VALUE) {		
				return privateQuote; 		
			} else {

				buf.position(hasPrivateQuote);

			privateQuote = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasPrivateQuote = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return privateQuote;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasPrivateQuote() { return hasPrivateQuote != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPrivateQuote(byte[] src) {		
		if (src == null ) return;
		if (hasPrivateQuote()) privateQuote = false;		
		privateQuote = src[0]==(byte)'Y'?true:false;		
		hasPrivateQuote = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrivateQuote(boolean src) {		
		privateQuote = src;
		hasPrivateQuote = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrivateQuote(String str) {		
		if (str == null ) return;
		if (hasPrivateQuote()) privateQuote = false;		
		byte[] src = str.getBytes(); 		
		privateQuote = src[0]==(byte)'Y'?true:false;		
		hasPrivateQuote = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRespondentType() {		
		getRespondentType();		
	}		
			
	public long getRespondentType() { 		
		if ( hasRespondentType()) {		
			if (hasRespondentType == FixUtils.TAG_HAS_VALUE) {		
				return respondentType; 		
			} else {

				buf.position(hasRespondentType);

			respondentType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasRespondentType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return respondentType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRespondentType() { return hasRespondentType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRespondentType(byte[] src) {		
		if (src == null ) return;
		if (hasRespondentType()) respondentType = FixUtils.TAG_HAS_NO_VALUE;		
		respondentType = FixUtils.longValueOf(src, 0, src.length);
		hasRespondentType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRespondentType(long src) {		
		respondentType = src;
		hasRespondentType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRespondentType(String str) {		
		if (str == null ) return;
		if (hasRespondentType()) respondentType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		respondentType = FixUtils.longValueOf(src, 0, src.length);
		hasRespondentType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPreTradeAnonymity() {		
		getPreTradeAnonymity();		
	}		
			
	public boolean getPreTradeAnonymity() { 		
		if ( hasPreTradeAnonymity()) {		
			if (hasPreTradeAnonymity == FixUtils.TAG_HAS_VALUE) {		
				return preTradeAnonymity; 		
			} else {

				buf.position(hasPreTradeAnonymity);

			preTradeAnonymity = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasPreTradeAnonymity = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return preTradeAnonymity;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasPreTradeAnonymity() { return hasPreTradeAnonymity != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPreTradeAnonymity(byte[] src) {		
		if (src == null ) return;
		if (hasPreTradeAnonymity()) preTradeAnonymity = false;		
		preTradeAnonymity = src[0]==(byte)'Y'?true:false;		
		hasPreTradeAnonymity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPreTradeAnonymity(boolean src) {		
		preTradeAnonymity = src;
		hasPreTradeAnonymity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPreTradeAnonymity(String str) {		
		if (str == null ) return;
		if (hasPreTradeAnonymity()) preTradeAnonymity = false;		
		byte[] src = str.getBytes(); 		
		preTradeAnonymity = src[0]==(byte)'Y'?true:false;		
		hasPreTradeAnonymity = FixUtils.TAG_HAS_VALUE;		
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

					if (hasQuoteReqID()) s += "QuoteReqID(131)= " + new String( FixUtils.trim(getQuoteReqID()) ) + "\n" ; 
		if (hasRFQReqID()) s += "RFQReqID(644)= " + new String( FixUtils.trim(getRFQReqID()) ) + "\n" ; 
		if (hasQuoteRequestRejectReason()) s += "QuoteRequestRejectReason(658)= " + getQuoteRequestRejectReason() + "\n" ; 
		if (hasPrivateQuote()) s += "PrivateQuote(1171)= " + getPrivateQuote() + "\n" ; 
		if (hasRespondentType()) s += "RespondentType(1172)= " + getRespondentType() + "\n" ; 
		if (hasPreTradeAnonymity()) s += "PreTradeAnonymity(1091)= " + getPreTradeAnonymity() + "\n" ; 
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
		if (! ( o instanceof FixQuoteRequestReject)) return false;

		FixQuoteRequestReject msg = (FixQuoteRequestReject) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasQuoteReqID() && !msg.hasQuoteReqID()) || (!hasQuoteReqID() && msg.hasQuoteReqID())) return false;
		if (!(!hasQuoteReqID() && !msg.hasQuoteReqID()) && !FixUtils.equals(getQuoteReqID(), msg.getQuoteReqID())) return false;
		if ((hasRFQReqID() && !msg.hasRFQReqID()) || (!hasRFQReqID() && msg.hasRFQReqID())) return false;
		if (!(!hasRFQReqID() && !msg.hasRFQReqID()) && !FixUtils.equals(getRFQReqID(), msg.getRFQReqID())) return false;
		if ((hasQuoteRequestRejectReason() && !msg.hasQuoteRequestRejectReason()) || (!hasQuoteRequestRejectReason() && msg.hasQuoteRequestRejectReason())) return false;
		if (!(!hasQuoteRequestRejectReason() && !msg.hasQuoteRequestRejectReason()) && !(getQuoteRequestRejectReason()==msg.getQuoteRequestRejectReason())) return false;
		if ((hasPrivateQuote() && !msg.hasPrivateQuote()) || (!hasPrivateQuote() && msg.hasPrivateQuote())) return false;
		if (!(!hasPrivateQuote() && !msg.hasPrivateQuote()) && !(getPrivateQuote()==msg.getPrivateQuote())) return false;
		if ((hasRespondentType() && !msg.hasRespondentType()) || (!hasRespondentType() && msg.hasRespondentType())) return false;
		if (!(!hasRespondentType() && !msg.hasRespondentType()) && !(getRespondentType()==msg.getRespondentType())) return false;
		if ((hasPreTradeAnonymity() && !msg.hasPreTradeAnonymity()) || (!hasPreTradeAnonymity() && msg.hasPreTradeAnonymity())) return false;
		if (!(!hasPreTradeAnonymity() && !msg.hasPreTradeAnonymity()) && !(getPreTradeAnonymity()==msg.getPreTradeAnonymity())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixQuoteRequestReject clone () {
		FixQuoteRequestReject out = new FixQuoteRequestReject();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixQuoteRequestReject clone ( FixQuoteRequestReject out ) {
		if ( hasQuoteReqID())
			out.setQuoteReqID(getQuoteReqID());
		if ( hasRFQReqID())
			out.setRFQReqID(getRFQReqID());
		if ( hasQuoteRequestRejectReason())
			out.setQuoteRequestRejectReason(getQuoteRequestRejectReason());
		if ( hasPrivateQuote())
			out.setPrivateQuote(getPrivateQuote());
		if ( hasRespondentType())
			out.setRespondentType(getRespondentType());
		if ( hasPreTradeAnonymity())
			out.setPreTradeAnonymity(getPreTradeAnonymity());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		int count = 0;
		count = 0;
		for (FixRootParties fixRootParties : rootParties) {
			if (!fixRootParties.hasGroup()) continue;
			out.rootParties[count] = fixRootParties.clone( out.rootParties[count] );
			count++;
		}
		count = 0;
		for (FixQuotReqRjctGrp fixQuotReqRjctGrp : quotReqRjctGrp) {
			if (!fixQuotReqRjctGrp.hasGroup()) continue;
			out.quotReqRjctGrp[count] = fixQuotReqRjctGrp.clone( out.quotReqRjctGrp[count] );
			count++;
		}
		return out;
	}

}
