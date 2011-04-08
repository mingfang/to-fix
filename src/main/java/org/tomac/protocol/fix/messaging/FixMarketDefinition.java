package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixMarketDefinition extends FixInMessage {
	private short hasMarketReportID;
	byte[] marketReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketReqID;
	byte[] marketReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketID;
	byte[] marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketSegmentID;
	byte[] marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketSegmentDesc;
	byte[] marketSegmentDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEncodedMktSegmDescLen;
	long encodedMktSegmDescLen = 0;		
	private short hasEncodedMktSegmDesc;
	byte[] encodedMktSegmDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasParentMktSegmID;
	byte[] parentMktSegmID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixBaseTradingRules baseTradingRules;
	public FixOrdTypeRules[] ordTypeRules;
	public FixTimeInForceRules[] timeInForceRules;
	public FixExecInstRules[] execInstRules;
	
	public FixMarketDefinition() {
		super(FixMessageInfo.MessageTypes.MARKETDEFINITION);


		hasMarketReportID = FixUtils.TAG_HAS_NO_VALUE;		
		marketReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketReqID = FixUtils.TAG_HAS_NO_VALUE;		
		marketReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketID = FixUtils.TAG_HAS_NO_VALUE;		
		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketSegmentID = FixUtils.TAG_HAS_NO_VALUE;		
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketSegmentDesc = FixUtils.TAG_HAS_NO_VALUE;		
		marketSegmentDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEncodedMktSegmDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedMktSegmDesc = FixUtils.TAG_HAS_NO_VALUE;		
		encodedMktSegmDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasParentMktSegmID = FixUtils.TAG_HAS_NO_VALUE;		
		parentMktSegmID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		applicationSequenceControl = new FixApplicationSequenceControl();
		baseTradingRules = new FixBaseTradingRules();
		ordTypeRules = new FixOrdTypeRules[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) ordTypeRules[i] = new FixOrdTypeRules();
		timeInForceRules = new FixTimeInForceRules[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) timeInForceRules[i] = new FixTimeInForceRules();
		execInstRules = new FixExecInstRules[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) execInstRules[i] = new FixExecInstRules();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.MARKETREPORTID_INT:		
            		hasMarketReportID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MARKETREQID_INT:		
            		hasMarketReqID = (short) buf.position();		
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
            	case FixTags.MARKETSEGMENTDESC_INT:		
            		hasMarketSegmentDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDMKTSEGMDESCLEN_INT:		
            		hasEncodedMktSegmDescLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDMKTSEGMDESC_INT:		
            		hasEncodedMktSegmDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PARENTMKTSEGMID_INT:		
            		hasParentMktSegmID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
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
        			} else if ( baseTradingRules.isKeyTag(tag)) {
        				tag = baseTradingRules.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOORDTYPERULES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !ordTypeRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = ordTypeRules[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOTIMEINFORCERULES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !timeInForceRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = timeInForceRules[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOEXECINSTRULES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !execInstRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = execInstRules[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.MARKETDEFINITION);
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

		if (!hasMarketReportID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.MARKETREPORTID_INT, FixMessageInfo.MessageTypes.MARKETDEFINITION);
			return false;
		}
		if (!hasMarketID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.MARKETID_INT, FixMessageInfo.MessageTypes.MARKETDEFINITION);
			return false;
		}
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getMarketReportID();		
		getMarketReqID();		
		getMarketID();		
		getMarketSegmentID();		
		getMarketSegmentDesc();		
		getEncodedMktSegmDescLen();		
		getEncodedMktSegmDesc();		
		getParentMktSegmID();		
		getCurrency();		
		getTransactTime();		
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
		if (hasMarketReportID()) {		
			out.put(FixTags.MARKETREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,marketReportID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarketReqID()) {		
			out.put(FixTags.MARKETREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,marketReqID); 		
		
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
		if (hasMarketSegmentDesc()) {		
			out.put(FixTags.MARKETSEGMENTDESC);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,marketSegmentDesc); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedMktSegmDescLen()) {		
			out.put(FixTags.ENCODEDMKTSEGMDESCLEN);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encodedMktSegmDescLen);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedMktSegmDesc()) {		
			out.put(FixTags.ENCODEDMKTSEGMDESC);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,encodedMktSegmDesc); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasParentMktSegmID()) {		
			out.put(FixTags.PARENTMKTSEGMID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,parentMktSegmID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
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
		baseTradingRules.encode(out);
		if (FixUtils.getNoInGroup(ordTypeRules)>0) {
			out.put(FixTags.NOORDTYPERULES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(ordTypeRules));

			out.put(FixUtils.SOH);

		}
		for (FixOrdTypeRules fixOrdTypeRules : ordTypeRules) if (fixOrdTypeRules.hasGroup()) fixOrdTypeRules.encode(out);
		if (FixUtils.getNoInGroup(timeInForceRules)>0) {
			out.put(FixTags.NOTIMEINFORCERULES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(timeInForceRules));

			out.put(FixUtils.SOH);

		}
		for (FixTimeInForceRules fixTimeInForceRules : timeInForceRules) if (fixTimeInForceRules.hasGroup()) fixTimeInForceRules.encode(out);
		if (FixUtils.getNoInGroup(execInstRules)>0) {
			out.put(FixTags.NOEXECINSTRULES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(execInstRules));

			out.put(FixUtils.SOH);

		}
		for (FixExecInstRules fixExecInstRules : execInstRules) if (fixExecInstRules.hasGroup()) fixExecInstRules.encode(out);
		
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
		
		if (hasMarketReportID()) {		
			FixUtils.put(out,marketReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketReqID()) {		
			FixUtils.put(out,marketReqID); 		
		
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
		
		if (hasMarketSegmentDesc()) {		
			FixUtils.put(out,marketSegmentDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedMktSegmDescLen()) {		
			FixUtils.put(out, (long)encodedMktSegmDescLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedMktSegmDesc()) {		
			FixUtils.put(out,encodedMktSegmDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasParentMktSegmID()) {		
			FixUtils.put(out,parentMktSegmID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
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
			
	public void crackMarketReportID() {		
		getMarketReportID();		
	}		
			
	public byte[] getMarketReportID() { 		
		if ( hasMarketReportID()) {		
			if (hasMarketReportID == FixUtils.TAG_HAS_VALUE) {		
				return marketReportID; 		
			} else {

				buf.position(hasMarketReportID);

			FixMessage.getTagStringValue(buf, marketReportID, 0, marketReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMarketReportID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return marketReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMarketReportID() { return hasMarketReportID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMarketReportID(byte[] src) {		
		if (src == null ) return;
		if (hasMarketReportID()) FixUtils.fillNul(marketReportID);		
		FixUtils.copy(marketReportID, src); 		
		hasMarketReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketReportID(String str) {		
		if (str == null ) return;
		if (hasMarketReportID()) FixUtils.fillNul(marketReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketReportID, src); 		
		hasMarketReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMarketReqID() {		
		getMarketReqID();		
	}		
			
	public byte[] getMarketReqID() { 		
		if ( hasMarketReqID()) {		
			if (hasMarketReqID == FixUtils.TAG_HAS_VALUE) {		
				return marketReqID; 		
			} else {

				buf.position(hasMarketReqID);

			FixMessage.getTagStringValue(buf, marketReqID, 0, marketReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMarketReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return marketReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMarketReqID() { return hasMarketReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMarketReqID(byte[] src) {		
		if (src == null ) return;
		if (hasMarketReqID()) FixUtils.fillNul(marketReqID);		
		FixUtils.copy(marketReqID, src); 		
		hasMarketReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketReqID(String str) {		
		if (str == null ) return;
		if (hasMarketReqID()) FixUtils.fillNul(marketReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketReqID, src); 		
		hasMarketReqID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackMarketSegmentDesc() {		
		getMarketSegmentDesc();		
	}		
			
	public byte[] getMarketSegmentDesc() { 		
		if ( hasMarketSegmentDesc()) {		
			if (hasMarketSegmentDesc == FixUtils.TAG_HAS_VALUE) {		
				return marketSegmentDesc; 		
			} else {

				buf.position(hasMarketSegmentDesc);

			FixMessage.getTagStringValue(buf, marketSegmentDesc, 0, marketSegmentDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMarketSegmentDesc = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return marketSegmentDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMarketSegmentDesc() { return hasMarketSegmentDesc != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMarketSegmentDesc(byte[] src) {		
		if (src == null ) return;
		if (hasMarketSegmentDesc()) FixUtils.fillNul(marketSegmentDesc);		
		FixUtils.copy(marketSegmentDesc, src); 		
		hasMarketSegmentDesc = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketSegmentDesc(String str) {		
		if (str == null ) return;
		if (hasMarketSegmentDesc()) FixUtils.fillNul(marketSegmentDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketSegmentDesc, src); 		
		hasMarketSegmentDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedMktSegmDescLen() {		
		getEncodedMktSegmDescLen();		
	}		
			
	public long getEncodedMktSegmDescLen() { 		
		if ( hasEncodedMktSegmDescLen()) {		
			if (hasEncodedMktSegmDescLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedMktSegmDescLen; 		
			} else {

				buf.position(hasEncodedMktSegmDescLen);

			encodedMktSegmDescLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncodedMktSegmDescLen = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedMktSegmDescLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedMktSegmDescLen() { return hasEncodedMktSegmDescLen != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedMktSegmDescLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedMktSegmDescLen()) encodedMktSegmDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedMktSegmDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedMktSegmDescLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedMktSegmDescLen(long src) {		
		encodedMktSegmDescLen = src;
		hasEncodedMktSegmDescLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedMktSegmDescLen(String str) {		
		if (str == null ) return;
		if (hasEncodedMktSegmDescLen()) encodedMktSegmDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedMktSegmDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedMktSegmDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedMktSegmDesc() {		
		getEncodedMktSegmDesc();		
	}		
			
	public byte[] getEncodedMktSegmDesc() { 		
		if ( hasEncodedMktSegmDesc()) {		
			if (hasEncodedMktSegmDesc == FixUtils.TAG_HAS_VALUE) {		
				return encodedMktSegmDesc; 		
			} else {

				buf.position(hasEncodedMktSegmDesc);

			FixMessage.getTagStringValue(buf, encodedMktSegmDesc, 0, encodedMktSegmDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEncodedMktSegmDesc = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedMktSegmDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedMktSegmDesc() { return hasEncodedMktSegmDesc != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedMktSegmDesc(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedMktSegmDesc()) FixUtils.fillNul(encodedMktSegmDesc);		
		FixUtils.copy(encodedMktSegmDesc, src); 		
		hasEncodedMktSegmDesc = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedMktSegmDesc(String str) {		
		if (str == null ) return;
		if (hasEncodedMktSegmDesc()) FixUtils.fillNul(encodedMktSegmDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedMktSegmDesc, src); 		
		hasEncodedMktSegmDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackParentMktSegmID() {		
		getParentMktSegmID();		
	}		
			
	public byte[] getParentMktSegmID() { 		
		if ( hasParentMktSegmID()) {		
			if (hasParentMktSegmID == FixUtils.TAG_HAS_VALUE) {		
				return parentMktSegmID; 		
			} else {

				buf.position(hasParentMktSegmID);

			FixMessage.getTagStringValue(buf, parentMktSegmID, 0, parentMktSegmID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasParentMktSegmID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return parentMktSegmID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasParentMktSegmID() { return hasParentMktSegmID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setParentMktSegmID(byte[] src) {		
		if (src == null ) return;
		if (hasParentMktSegmID()) FixUtils.fillNul(parentMktSegmID);		
		FixUtils.copy(parentMktSegmID, src); 		
		hasParentMktSegmID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setParentMktSegmID(String str) {		
		if (str == null ) return;
		if (hasParentMktSegmID()) FixUtils.fillNul(parentMktSegmID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(parentMktSegmID, src); 		
		hasParentMktSegmID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCurrency() {		
		getCurrency();		
	}		
			
	public byte[] getCurrency() { 		
		if ( hasCurrency()) {		
			if (hasCurrency == FixUtils.TAG_HAS_VALUE) {		
				return currency; 		
			} else {

				buf.position(hasCurrency);

			FixMessage.getTagStringValue(buf, currency, 0, currency.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCurrency = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return currency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCurrency() { return hasCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasCurrency()) FixUtils.fillNul(currency);		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCurrency(String str) {		
		if (str == null ) return;
		if (hasCurrency()) FixUtils.fillNul(currency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
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

					if (hasMarketReportID()) s += "MarketReportID(1394)= " + new String( FixUtils.trim(getMarketReportID()) ) + "\n" ; 
		if (hasMarketReqID()) s += "MarketReqID(1393)= " + new String( FixUtils.trim(getMarketReqID()) ) + "\n" ; 
		if (hasMarketID()) s += "MarketID(1301)= " + new String( FixUtils.trim(getMarketID()) ) + "\n" ; 
		if (hasMarketSegmentID()) s += "MarketSegmentID(1300)= " + new String( FixUtils.trim(getMarketSegmentID()) ) + "\n" ; 
		if (hasMarketSegmentDesc()) s += "MarketSegmentDesc(1396)= " + new String( FixUtils.trim(getMarketSegmentDesc()) ) + "\n" ; 
		if (hasEncodedMktSegmDescLen()) s += "EncodedMktSegmDescLen(1397)= " + getEncodedMktSegmDescLen() + "\n" ; 
		if (hasEncodedMktSegmDesc()) s += "EncodedMktSegmDesc(1398)= " + new String( FixUtils.trim(getEncodedMktSegmDesc()) ) + "\n" ; 
		if (hasParentMktSegmID()) s += "ParentMktSegmID(1325)= " + new String( FixUtils.trim(getParentMktSegmID()) ) + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
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
		if (! ( o instanceof FixMarketDefinition)) return false;

		FixMarketDefinition msg = (FixMarketDefinition) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasMarketReportID() && !msg.hasMarketReportID()) || (!hasMarketReportID() && msg.hasMarketReportID())) return false;
		if (!(!hasMarketReportID() && !msg.hasMarketReportID()) && !FixUtils.equals(getMarketReportID(), msg.getMarketReportID())) return false;
		if ((hasMarketReqID() && !msg.hasMarketReqID()) || (!hasMarketReqID() && msg.hasMarketReqID())) return false;
		if (!(!hasMarketReqID() && !msg.hasMarketReqID()) && !FixUtils.equals(getMarketReqID(), msg.getMarketReqID())) return false;
		if ((hasMarketID() && !msg.hasMarketID()) || (!hasMarketID() && msg.hasMarketID())) return false;
		if (!(!hasMarketID() && !msg.hasMarketID()) && !FixUtils.equals(getMarketID(), msg.getMarketID())) return false;
		if ((hasMarketSegmentID() && !msg.hasMarketSegmentID()) || (!hasMarketSegmentID() && msg.hasMarketSegmentID())) return false;
		if (!(!hasMarketSegmentID() && !msg.hasMarketSegmentID()) && !FixUtils.equals(getMarketSegmentID(), msg.getMarketSegmentID())) return false;
		if ((hasMarketSegmentDesc() && !msg.hasMarketSegmentDesc()) || (!hasMarketSegmentDesc() && msg.hasMarketSegmentDesc())) return false;
		if (!(!hasMarketSegmentDesc() && !msg.hasMarketSegmentDesc()) && !FixUtils.equals(getMarketSegmentDesc(), msg.getMarketSegmentDesc())) return false;
		if ((hasEncodedMktSegmDescLen() && !msg.hasEncodedMktSegmDescLen()) || (!hasEncodedMktSegmDescLen() && msg.hasEncodedMktSegmDescLen())) return false;
		if (!(!hasEncodedMktSegmDescLen() && !msg.hasEncodedMktSegmDescLen()) && !(getEncodedMktSegmDescLen()==msg.getEncodedMktSegmDescLen())) return false;
		if ((hasEncodedMktSegmDesc() && !msg.hasEncodedMktSegmDesc()) || (!hasEncodedMktSegmDesc() && msg.hasEncodedMktSegmDesc())) return false;
		if (!(!hasEncodedMktSegmDesc() && !msg.hasEncodedMktSegmDesc()) && !FixUtils.equals(getEncodedMktSegmDesc(), msg.getEncodedMktSegmDesc())) return false;
		if ((hasParentMktSegmID() && !msg.hasParentMktSegmID()) || (!hasParentMktSegmID() && msg.hasParentMktSegmID())) return false;
		if (!(!hasParentMktSegmID() && !msg.hasParentMktSegmID()) && !FixUtils.equals(getParentMktSegmID(), msg.getParentMktSegmID())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixMarketDefinition clone () {
		FixMarketDefinition out = new FixMarketDefinition();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixMarketDefinition clone ( FixMarketDefinition out ) {
		if ( hasMarketReportID())
			out.setMarketReportID(getMarketReportID());
		if ( hasMarketReqID())
			out.setMarketReqID(getMarketReqID());
		if ( hasMarketID())
			out.setMarketID(getMarketID());
		if ( hasMarketSegmentID())
			out.setMarketSegmentID(getMarketSegmentID());
		if ( hasMarketSegmentDesc())
			out.setMarketSegmentDesc(getMarketSegmentDesc());
		if ( hasEncodedMktSegmDescLen())
			out.setEncodedMktSegmDescLen(getEncodedMktSegmDescLen());
		if ( hasEncodedMktSegmDesc())
			out.setEncodedMktSegmDesc(getEncodedMktSegmDesc());
		if ( hasParentMktSegmID())
			out.setParentMktSegmID(getParentMktSegmID());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		if (baseTradingRules.hasGroup())
			out.baseTradingRules = baseTradingRules.clone( out.baseTradingRules);
		int count = 0;
		count = 0;
		for (FixOrdTypeRules fixOrdTypeRules : ordTypeRules) {
			if (!fixOrdTypeRules.hasGroup()) continue;
			out.ordTypeRules[count] = fixOrdTypeRules.clone( out.ordTypeRules[count] );
			count++;
		}
		count = 0;
		for (FixTimeInForceRules fixTimeInForceRules : timeInForceRules) {
			if (!fixTimeInForceRules.hasGroup()) continue;
			out.timeInForceRules[count] = fixTimeInForceRules.clone( out.timeInForceRules[count] );
			count++;
		}
		count = 0;
		for (FixExecInstRules fixExecInstRules : execInstRules) {
			if (!fixExecInstRules.hasGroup()) continue;
			out.execInstRules[count] = fixExecInstRules.clone( out.execInstRules[count] );
			count++;
		}
		return out;
	}

}
