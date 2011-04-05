package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixNews extends FixInMessage {
	private short hasNewsID;
	byte[] newsID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNewsCategory;
	long newsCategory = 0;		
	private short hasLanguageCode;
	byte[] languageCode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrigTime;
	byte[] origTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasUrgency;
	byte urgency = (byte)' ';		
	private short hasHeadline;
	byte[] headline = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEncodedHeadlineLen;
	long encodedHeadlineLen = 0;		
	private short hasEncodedHeadline;
	byte[] encodedHeadline = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketID;
	byte[] marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketSegmentID;
	byte[] marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasURLLink;
	byte[] uRLLink = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRawDataLength;
	long rawDataLength = 0;		
	private short hasRawData;
	byte[] rawData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixNewsRefGrp[] newsRefGrp;
	public FixRoutingGrp[] routingGrp;
	public FixInstrmtGrp[] instrmtGrp;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixLinesOfTextGrp[] linesOfTextGrp;
	
	public FixNews() {
		super(FixMessageInfo.MessageTypes.NEWS);


		hasNewsID = FixUtils.TAG_HAS_NO_VALUE;		
		newsID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNewsCategory = FixUtils.TAG_HAS_NO_VALUE;		
		hasLanguageCode = FixUtils.TAG_HAS_NO_VALUE;		
		languageCode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrigTime = FixUtils.TAG_HAS_NO_VALUE;		
		origTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasUrgency = FixUtils.TAG_HAS_NO_VALUE;		
		hasHeadline = FixUtils.TAG_HAS_NO_VALUE;		
		headline = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEncodedHeadlineLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedHeadline = FixUtils.TAG_HAS_NO_VALUE;		
		encodedHeadline = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketID = FixUtils.TAG_HAS_NO_VALUE;		
		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketSegmentID = FixUtils.TAG_HAS_NO_VALUE;		
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasURLLink = FixUtils.TAG_HAS_NO_VALUE;		
		uRLLink = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRawDataLength = FixUtils.TAG_HAS_NO_VALUE;		
		hasRawData = FixUtils.TAG_HAS_NO_VALUE;		
		rawData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		applicationSequenceControl = new FixApplicationSequenceControl();
		newsRefGrp = new FixNewsRefGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) newsRefGrp[i] = new FixNewsRefGrp();
		routingGrp = new FixRoutingGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) routingGrp[i] = new FixRoutingGrp();
		instrmtGrp = new FixInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtGrp[i] = new FixInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		linesOfTextGrp = new FixLinesOfTextGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) linesOfTextGrp[i] = new FixLinesOfTextGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.NEWSID_INT:		
            		hasNewsID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.NEWSCATEGORY_INT:		
            		hasNewsCategory = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LANGUAGECODE_INT:		
            		hasLanguageCode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORIGTIME_INT:		
            		hasOrigTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.URGENCY_INT:		
            		hasUrgency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.HEADLINE_INT:		
            		hasHeadline = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDHEADLINELEN_INT:		
            		hasEncodedHeadlineLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDHEADLINE_INT:		
            		hasEncodedHeadline = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MARKETID_INT:		
            		hasMarketID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MARKETSEGMENTID_INT:		
            		hasMarketSegmentID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.URLLINK_INT:		
            		hasURLLink = (short) buf.position();		
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
        			} else if ( applicationSequenceControl.isKeyTag(tag)) {
        				tag = applicationSequenceControl.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NONEWSREFIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !newsRefGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = newsRefGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOROUTINGIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !routingGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = routingGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NORELATEDSYM_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = instrmtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOLEGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOUNDERLYINGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !undInstrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = undInstrmtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOLINESOFTEXT_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !linesOfTextGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = linesOfTextGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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

		if (!hasHeadline()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Headline missing", FixTags.HEADLINE_INT, FixMessageInfo.MessageTypes.NEWS);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (linesOfTextGrp[i].hasGroup()) linesOfTextGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
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
		if (hasNewsID()) {		
			out.put(FixTags.NEWSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,newsID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNewsCategory()) {		
			out.put(FixTags.NEWSCATEGORY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)newsCategory);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLanguageCode()) {		
			out.put(FixTags.LANGUAGECODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,languageCode); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrigTime()) {		
			out.put(FixTags.ORIGTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,origTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUrgency()) {		
			out.put(FixTags.URGENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,urgency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasHeadline()) {		
			out.put(FixTags.HEADLINE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,headline); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedHeadlineLen()) {		
			out.put(FixTags.ENCODEDHEADLINELEN);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encodedHeadlineLen);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedHeadline()) {		
			out.put(FixTags.ENCODEDHEADLINE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,encodedHeadline); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarketID()) {		
			out.put(FixTags.MARKETID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,marketID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarketSegmentID()) {		
			out.put(FixTags.MARKETSEGMENTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,marketSegmentID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasURLLink()) {		
			out.put(FixTags.URLLINK);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,uRLLink); 		
		
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
		
		applicationSequenceControl.encode(out);
		if (FixUtils.getNoInGroup(newsRefGrp)>0) {
			out.put(FixTags.NONEWSREFIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(newsRefGrp));

			out.put(FixUtils.SOH);

		}
		for (FixNewsRefGrp fixNewsRefGrp : newsRefGrp) if (fixNewsRefGrp.hasGroup()) fixNewsRefGrp.encode(out);
		if (FixUtils.getNoInGroup(routingGrp)>0) {
			out.put(FixTags.NOROUTINGIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(routingGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRoutingGrp fixRoutingGrp : routingGrp) if (fixRoutingGrp.hasGroup()) fixRoutingGrp.encode(out);
		if (FixUtils.getNoInGroup(instrmtGrp)>0) {
			out.put(FixTags.NORELATEDSYM);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtGrp fixInstrmtGrp : instrmtGrp) if (fixInstrmtGrp.hasGroup()) fixInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(instrmtLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) if (fixInstrmtLegGrp.hasGroup()) fixInstrmtLegGrp.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(linesOfTextGrp)>0) {
			out.put(FixTags.NOLINESOFTEXT);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(linesOfTextGrp));

			out.put(FixUtils.SOH);

		}
		for (FixLinesOfTextGrp fixLinesOfTextGrp : linesOfTextGrp) if (fixLinesOfTextGrp.hasGroup()) fixLinesOfTextGrp.encode(out);
		
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
		
		if (hasNewsID()) {		
			FixUtils.put(out,newsID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNewsCategory()) {		
			FixUtils.put(out, (long)newsCategory);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLanguageCode()) {		
			FixUtils.put(out,languageCode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigTime()) {		
			FixUtils.put(out,origTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUrgency()) {		
			FixUtils.put(out,urgency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHeadline()) {		
			FixUtils.put(out,headline); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedHeadlineLen()) {		
			FixUtils.put(out, (long)encodedHeadlineLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedHeadline()) {		
			FixUtils.put(out,encodedHeadline); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketID()) {		
			FixUtils.put(out,marketID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketSegmentID()) {		
			FixUtils.put(out,marketSegmentID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasURLLink()) {		
			FixUtils.put(out,uRLLink); 		
		
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
			
	public void crackNewsID() {		
		getNewsID();		
	}		
			
	public byte[] getNewsID() { 		
		if ( hasNewsID()) {		
			if (hasNewsID == FixUtils.TAG_HAS_VALUE) {		
				return newsID; 		
			} else {

				buf.position(hasNewsID);

			FixMessage.getTagStringValue(buf, newsID, 0, newsID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasNewsID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return newsID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNewsID() { return hasNewsID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNewsID(byte[] src) {		
		if (src == null ) return;
		if (hasNewsID()) FixUtils.fillNul(newsID);		
		FixUtils.copy(newsID, src); 		
		hasNewsID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNewsID(String str) {		
		if (str == null ) return;
		if (hasNewsID()) FixUtils.fillNul(newsID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(newsID, src); 		
		hasNewsID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackNewsCategory() {		
		getNewsCategory();		
	}		
			
	public long getNewsCategory() { 		
		if ( hasNewsCategory()) {		
			if (hasNewsCategory == FixUtils.TAG_HAS_VALUE) {		
				return newsCategory; 		
			} else {

				buf.position(hasNewsCategory);

			newsCategory = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasNewsCategory = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return newsCategory;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNewsCategory() { return hasNewsCategory != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNewsCategory(byte[] src) {		
		if (src == null ) return;
		if (hasNewsCategory()) newsCategory = FixUtils.TAG_HAS_NO_VALUE;		
		newsCategory = FixUtils.longValueOf(src, 0, src.length);
		hasNewsCategory = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNewsCategory(long src) {		
		newsCategory = src;
		hasNewsCategory = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNewsCategory(String str) {		
		if (str == null ) return;
		if (hasNewsCategory()) newsCategory = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		newsCategory = FixUtils.longValueOf(src, 0, src.length);
		hasNewsCategory = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLanguageCode() {		
		getLanguageCode();		
	}		
			
	public byte[] getLanguageCode() { 		
		if ( hasLanguageCode()) {		
			if (hasLanguageCode == FixUtils.TAG_HAS_VALUE) {		
				return languageCode; 		
			} else {

				buf.position(hasLanguageCode);

			FixMessage.getTagStringValue(buf, languageCode, 0, languageCode.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasLanguageCode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return languageCode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLanguageCode() { return hasLanguageCode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLanguageCode(byte[] src) {		
		if (src == null ) return;
		if (hasLanguageCode()) FixUtils.fillNul(languageCode);		
		FixUtils.copy(languageCode, src); 		
		hasLanguageCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLanguageCode(String str) {		
		if (str == null ) return;
		if (hasLanguageCode()) FixUtils.fillNul(languageCode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(languageCode, src); 		
		hasLanguageCode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrigTime() {		
		getOrigTime();		
	}		
			
	public byte[] getOrigTime() { 		
		if ( hasOrigTime()) {		
			if (hasOrigTime == FixUtils.TAG_HAS_VALUE) {		
				return origTime; 		
			} else {

				buf.position(hasOrigTime);

			FixMessage.getTagStringValue(buf, origTime, 0, origTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrigTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return origTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigTime() { return hasOrigTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrigTime(byte[] src) {		
		if (src == null ) return;
		if (hasOrigTime()) FixUtils.fillNul(origTime);		
		FixUtils.copy(origTime, src); 		
		hasOrigTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigTime(String str) {		
		if (str == null ) return;
		if (hasOrigTime()) FixUtils.fillNul(origTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origTime, src); 		
		hasOrigTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackUrgency() {		
		getUrgency();		
	}		
			
	public byte getUrgency() { 		
		if ( hasUrgency()) {		
			if (hasUrgency == FixUtils.TAG_HAS_VALUE) {		
				return urgency; 		
			} else {

				buf.position(hasUrgency);

			urgency = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (urgency != (byte)'2') && (urgency != (byte)'1') && (urgency != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 61);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasUrgency = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return urgency;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasUrgency() { return hasUrgency != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUrgency(byte[] src) {		
		if (src == null ) return;
		if (hasUrgency()) urgency = (byte)' ';		
		urgency = src[0];		
		hasUrgency = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUrgency(byte src) {		
		urgency = src;
		hasUrgency = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUrgency(String str) {		
		if (str == null ) return;
		if (hasUrgency()) urgency = (byte)' ';		
		byte[] src = str.getBytes(); 		
		urgency = src[0];		
		hasUrgency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackHeadline() {		
		getHeadline();		
	}		
			
	public byte[] getHeadline() { 		
		if ( hasHeadline()) {		
			if (hasHeadline == FixUtils.TAG_HAS_VALUE) {		
				return headline; 		
			} else {

				buf.position(hasHeadline);

			FixMessage.getTagStringValue(buf, headline, 0, headline.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasHeadline = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return headline;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasHeadline() { return hasHeadline != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setHeadline(byte[] src) {		
		if (src == null ) return;
		if (hasHeadline()) FixUtils.fillNul(headline);		
		FixUtils.copy(headline, src); 		
		hasHeadline = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHeadline(String str) {		
		if (str == null ) return;
		if (hasHeadline()) FixUtils.fillNul(headline);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(headline, src); 		
		hasHeadline = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedHeadlineLen() {		
		getEncodedHeadlineLen();		
	}		
			
	public long getEncodedHeadlineLen() { 		
		if ( hasEncodedHeadlineLen()) {		
			if (hasEncodedHeadlineLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedHeadlineLen; 		
			} else {

				buf.position(hasEncodedHeadlineLen);

			encodedHeadlineLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncodedHeadlineLen = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedHeadlineLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedHeadlineLen() { return hasEncodedHeadlineLen != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedHeadlineLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedHeadlineLen()) encodedHeadlineLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedHeadlineLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedHeadlineLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedHeadlineLen(long src) {		
		encodedHeadlineLen = src;
		hasEncodedHeadlineLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedHeadlineLen(String str) {		
		if (str == null ) return;
		if (hasEncodedHeadlineLen()) encodedHeadlineLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedHeadlineLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedHeadlineLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedHeadline() {		
		getEncodedHeadline();		
	}		
			
	public byte[] getEncodedHeadline() { 		
		if ( hasEncodedHeadline()) {		
			if (hasEncodedHeadline == FixUtils.TAG_HAS_VALUE) {		
				return encodedHeadline; 		
			} else {

				buf.position(hasEncodedHeadline);

			FixMessage.getTagStringValue(buf, encodedHeadline, 0, encodedHeadline.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEncodedHeadline = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedHeadline;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedHeadline() { return hasEncodedHeadline != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedHeadline(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedHeadline()) FixUtils.fillNul(encodedHeadline);		
		FixUtils.copy(encodedHeadline, src); 		
		hasEncodedHeadline = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedHeadline(String str) {		
		if (str == null ) return;
		if (hasEncodedHeadline()) FixUtils.fillNul(encodedHeadline);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedHeadline, src); 		
		hasEncodedHeadline = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMarketID() {		
		getMarketID();		
	}		
			
	public byte[] getMarketID() { 		
		if ( hasMarketID()) {		
			if (hasMarketID == FixUtils.TAG_HAS_VALUE) {		
				return marketID; 		
			} else {

				buf.position(hasMarketID);

			FixMessage.getTagStringValue(buf, marketID, 0, marketID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMarketID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return marketID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMarketID() { return hasMarketID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMarketID(byte[] src) {		
		if (src == null ) return;
		if (hasMarketID()) FixUtils.fillNul(marketID);		
		FixUtils.copy(marketID, src); 		
		hasMarketID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketID(String str) {		
		if (str == null ) return;
		if (hasMarketID()) FixUtils.fillNul(marketID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketID, src); 		
		hasMarketID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMarketSegmentID() {		
		getMarketSegmentID();		
	}		
			
	public byte[] getMarketSegmentID() { 		
		if ( hasMarketSegmentID()) {		
			if (hasMarketSegmentID == FixUtils.TAG_HAS_VALUE) {		
				return marketSegmentID; 		
			} else {

				buf.position(hasMarketSegmentID);

			FixMessage.getTagStringValue(buf, marketSegmentID, 0, marketSegmentID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return marketSegmentID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMarketSegmentID() { return hasMarketSegmentID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMarketSegmentID(byte[] src) {		
		if (src == null ) return;
		if (hasMarketSegmentID()) FixUtils.fillNul(marketSegmentID);		
		FixUtils.copy(marketSegmentID, src); 		
		hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketSegmentID(String str) {		
		if (str == null ) return;
		if (hasMarketSegmentID()) FixUtils.fillNul(marketSegmentID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketSegmentID, src); 		
		hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackURLLink() {		
		getURLLink();		
	}		
			
	public byte[] getURLLink() { 		
		if ( hasURLLink()) {		
			if (hasURLLink == FixUtils.TAG_HAS_VALUE) {		
				return uRLLink; 		
			} else {

				buf.position(hasURLLink);

			FixMessage.getTagStringValue(buf, uRLLink, 0, uRLLink.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasURLLink = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return uRLLink;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasURLLink() { return hasURLLink != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setURLLink(byte[] src) {		
		if (src == null ) return;
		if (hasURLLink()) FixUtils.fillNul(uRLLink);		
		FixUtils.copy(uRLLink, src); 		
		hasURLLink = FixUtils.TAG_HAS_VALUE;		
	}

	public void setURLLink(String str) {		
		if (str == null ) return;
		if (hasURLLink()) FixUtils.fillNul(uRLLink);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(uRLLink, src); 		
		hasURLLink = FixUtils.TAG_HAS_VALUE;		
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

					if (hasNewsID()) s += "NewsID(1472)= " + new String( FixUtils.trim(getNewsID()) ) + "\n" ; 
		if (hasNewsCategory()) s += "NewsCategory(1473)= " + getNewsCategory() + "\n" ; 
		if (hasLanguageCode()) s += "LanguageCode(1474)= " + new String( FixUtils.trim(getLanguageCode()) ) + "\n" ; 
		if (hasOrigTime()) s += "OrigTime(42)= " + new String( FixUtils.trim(getOrigTime()) ) + "\n" ; 
		if (hasUrgency()) s += "Urgency(61)= " + getUrgency() + "\n" ; 
		if (hasHeadline()) s += "Headline(148)= " + new String( FixUtils.trim(getHeadline()) ) + "\n" ; 
		if (hasEncodedHeadlineLen()) s += "EncodedHeadlineLen(358)= " + getEncodedHeadlineLen() + "\n" ; 
		if (hasEncodedHeadline()) s += "EncodedHeadline(359)= " + new String( FixUtils.trim(getEncodedHeadline()) ) + "\n" ; 
		if (hasMarketID()) s += "MarketID(1301)= " + new String( FixUtils.trim(getMarketID()) ) + "\n" ; 
		if (hasMarketSegmentID()) s += "MarketSegmentID(1300)= " + new String( FixUtils.trim(getMarketSegmentID()) ) + "\n" ; 
		if (hasURLLink()) s += "URLLink(149)= " + new String( FixUtils.trim(getURLLink()) ) + "\n" ; 
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
		if (! ( o instanceof FixNews)) return false;

		FixNews msg = (FixNews) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasNewsID() && !msg.hasNewsID()) || (!hasNewsID() && msg.hasNewsID())) return false;
		if (!(!hasNewsID() && !msg.hasNewsID()) && !FixUtils.equals(getNewsID(), msg.getNewsID())) return false;
		if ((hasNewsCategory() && !msg.hasNewsCategory()) || (!hasNewsCategory() && msg.hasNewsCategory())) return false;
		if (!(!hasNewsCategory() && !msg.hasNewsCategory()) && !(getNewsCategory()==msg.getNewsCategory())) return false;
		if ((hasLanguageCode() && !msg.hasLanguageCode()) || (!hasLanguageCode() && msg.hasLanguageCode())) return false;
		if (!(!hasLanguageCode() && !msg.hasLanguageCode()) && !FixUtils.equals(getLanguageCode(), msg.getLanguageCode())) return false;
		if ((hasOrigTime() && !msg.hasOrigTime()) || (!hasOrigTime() && msg.hasOrigTime())) return false;
		if ((hasUrgency() && !msg.hasUrgency()) || (!hasUrgency() && msg.hasUrgency())) return false;
		if (!(!hasUrgency() && !msg.hasUrgency()) && !(getUrgency()==msg.getUrgency())) return false;
		if ((hasHeadline() && !msg.hasHeadline()) || (!hasHeadline() && msg.hasHeadline())) return false;
		if (!(!hasHeadline() && !msg.hasHeadline()) && !FixUtils.equals(getHeadline(), msg.getHeadline())) return false;
		if ((hasEncodedHeadlineLen() && !msg.hasEncodedHeadlineLen()) || (!hasEncodedHeadlineLen() && msg.hasEncodedHeadlineLen())) return false;
		if (!(!hasEncodedHeadlineLen() && !msg.hasEncodedHeadlineLen()) && !(getEncodedHeadlineLen()==msg.getEncodedHeadlineLen())) return false;
		if ((hasEncodedHeadline() && !msg.hasEncodedHeadline()) || (!hasEncodedHeadline() && msg.hasEncodedHeadline())) return false;
		if (!(!hasEncodedHeadline() && !msg.hasEncodedHeadline()) && !FixUtils.equals(getEncodedHeadline(), msg.getEncodedHeadline())) return false;
		if ((hasMarketID() && !msg.hasMarketID()) || (!hasMarketID() && msg.hasMarketID())) return false;
		if (!(!hasMarketID() && !msg.hasMarketID()) && !FixUtils.equals(getMarketID(), msg.getMarketID())) return false;
		if ((hasMarketSegmentID() && !msg.hasMarketSegmentID()) || (!hasMarketSegmentID() && msg.hasMarketSegmentID())) return false;
		if (!(!hasMarketSegmentID() && !msg.hasMarketSegmentID()) && !FixUtils.equals(getMarketSegmentID(), msg.getMarketSegmentID())) return false;
		if ((hasURLLink() && !msg.hasURLLink()) || (!hasURLLink() && msg.hasURLLink())) return false;
		if (!(!hasURLLink() && !msg.hasURLLink()) && !FixUtils.equals(getURLLink(), msg.getURLLink())) return false;
		if ((hasRawDataLength() && !msg.hasRawDataLength()) || (!hasRawDataLength() && msg.hasRawDataLength())) return false;
		if (!(!hasRawDataLength() && !msg.hasRawDataLength()) && !(getRawDataLength()==msg.getRawDataLength())) return false;
		if ((hasRawData() && !msg.hasRawData()) || (!hasRawData() && msg.hasRawData())) return false;
		if (!(!hasRawData() && !msg.hasRawData()) && !FixUtils.equals(getRawData(), msg.getRawData())) return false;
		return true;
	}
	@Override
	public FixNews clone () {
		FixNews out = new FixNews();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixNews clone ( FixNews out ) {
		if ( hasNewsID())
			out.setNewsID(getNewsID());
		if ( hasNewsCategory())
			out.setNewsCategory(getNewsCategory());
		if ( hasLanguageCode())
			out.setLanguageCode(getLanguageCode());
		if ( hasOrigTime())
			out.setOrigTime(getOrigTime());
		if ( hasUrgency())
			out.setUrgency(getUrgency());
		if ( hasHeadline())
			out.setHeadline(getHeadline());
		if ( hasEncodedHeadlineLen())
			out.setEncodedHeadlineLen(getEncodedHeadlineLen());
		if ( hasEncodedHeadline())
			out.setEncodedHeadline(getEncodedHeadline());
		if ( hasMarketID())
			out.setMarketID(getMarketID());
		if ( hasMarketSegmentID())
			out.setMarketSegmentID(getMarketSegmentID());
		if ( hasURLLink())
			out.setURLLink(getURLLink());
		if ( hasRawDataLength())
			out.setRawDataLength(getRawDataLength());
		if ( hasRawData())
			out.setRawData(getRawData());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		int count = 0;
		count = 0;
		for (FixNewsRefGrp fixNewsRefGrp : newsRefGrp) {
			if (!fixNewsRefGrp.hasGroup()) continue;
			out.newsRefGrp[count] = fixNewsRefGrp.clone( out.newsRefGrp[count] );
			count++;
		}
		count = 0;
		for (FixRoutingGrp fixRoutingGrp : routingGrp) {
			if (!fixRoutingGrp.hasGroup()) continue;
			out.routingGrp[count] = fixRoutingGrp.clone( out.routingGrp[count] );
			count++;
		}
		count = 0;
		for (FixInstrmtGrp fixInstrmtGrp : instrmtGrp) {
			if (!fixInstrmtGrp.hasGroup()) continue;
			out.instrmtGrp[count] = fixInstrmtGrp.clone( out.instrmtGrp[count] );
			count++;
		}
		count = 0;
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) {
			if (!fixInstrmtLegGrp.hasGroup()) continue;
			out.instrmtLegGrp[count] = fixInstrmtLegGrp.clone( out.instrmtLegGrp[count] );
			count++;
		}
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		count = 0;
		for (FixLinesOfTextGrp fixLinesOfTextGrp : linesOfTextGrp) {
			if (!fixLinesOfTextGrp.hasGroup()) continue;
			out.linesOfTextGrp[count] = fixLinesOfTextGrp.clone( out.linesOfTextGrp[count] );
			count++;
		}
		return out;
	}

}
