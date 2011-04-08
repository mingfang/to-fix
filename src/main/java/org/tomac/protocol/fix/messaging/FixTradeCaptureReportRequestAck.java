package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixTradeCaptureReportRequestAck extends FixInMessage {
	private short hasTradeRequestID;
	byte[] tradeRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeID;
	byte[] tradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryTradeID;
	byte[] secondaryTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasFirmTradeID;
	byte[] firmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryFirmTradeID;
	byte[] secondaryFirmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeRequestType;
	long tradeRequestType = 0;		
	private short hasSubscriptionRequestType;
	byte subscriptionRequestType = (byte)' ';		
	private short hasTotNumTradeReports;
	long totNumTradeReports = 0;		
	private short hasTradeRequestResult;
	long tradeRequestResult = 0;		
	private short hasTradeRequestStatus;
	long tradeRequestStatus = 0;		
	private short hasMultiLegReportingType;
	byte multiLegReportingType = (byte)' ';		
	private short hasResponseTransportType;
	long responseTransportType = 0;		
	private short hasResponseDestination;
	byte[] responseDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasMessageEventSource;
	byte[] messageEventSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	public FixInstrument instrument;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	
	public FixTradeCaptureReportRequestAck() {
		super(FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUESTACK);


		hasTradeRequestID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasFirmTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		firmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryFirmTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryFirmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotNumTradeReports = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeRequestResult = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeRequestStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasMultiLegReportingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasResponseTransportType = FixUtils.TAG_HAS_NO_VALUE;		
		hasResponseDestination = FixUtils.TAG_HAS_NO_VALUE;		
		responseDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasMessageEventSource = FixUtils.TAG_HAS_NO_VALUE;		
		messageEventSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		instrument = new FixInstrument();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.TRADEREQUESTID_INT:		
            		hasTradeRequestID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEID_INT:		
            		hasTradeID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYTRADEID_INT:		
            		hasSecondaryTradeID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.FIRMTRADEID_INT:		
            		hasFirmTradeID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYFIRMTRADEID_INT:		
            		hasSecondaryFirmTradeID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREQUESTTYPE_INT:		
            		hasTradeRequestType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SUBSCRIPTIONREQUESTTYPE_INT:		
            		hasSubscriptionRequestType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TOTNUMTRADEREPORTS_INT:		
            		hasTotNumTradeReports = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREQUESTRESULT_INT:		
            		hasTradeRequestResult = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREQUESTSTATUS_INT:		
            		hasTradeRequestStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MULTILEGREPORTINGTYPE_INT:		
            		hasMultiLegReportingType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RESPONSETRANSPORTTYPE_INT:		
            		hasResponseTransportType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RESPONSEDESTINATION_INT:		
            		hasResponseDestination = (short) buf.position();		
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
            	case FixTags.MESSAGEEVENTSOURCE_INT:		
            		hasMessageEventSource = (short) buf.position();		
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
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
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
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUESTACK);
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

		if (!hasTradeRequestID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRADEREQUESTID_INT, FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUESTACK);
			return false;
		}
		if (!hasTradeRequestType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRADEREQUESTTYPE_INT, FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUESTACK);
			return false;
		}
		if (!hasTradeRequestResult()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRADEREQUESTRESULT_INT, FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUESTACK);
			return false;
		}
		if (!hasTradeRequestStatus()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRADEREQUESTSTATUS_INT, FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUESTACK);
			return false;
		}
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getTradeRequestID();		
		getTradeID();		
		getSecondaryTradeID();		
		getFirmTradeID();		
		getSecondaryFirmTradeID();		
		getTradeRequestType();		
		getSubscriptionRequestType();		
		getTotNumTradeReports();		
		getTradeRequestResult();		
		getTradeRequestStatus();		
		getMultiLegReportingType();		
		getResponseTransportType();		
		getResponseDestination();		
		getText();		
		getEncodedTextLen();		
		getEncodedText();		
		getMessageEventSource();		
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
		if (hasTradeRequestID()) {		
			out.put(FixTags.TRADEREQUESTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeRequestID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeID()) {		
			out.put(FixTags.TRADEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryTradeID()) {		
			out.put(FixTags.SECONDARYTRADEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryTradeID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasFirmTradeID()) {		
			out.put(FixTags.FIRMTRADEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,firmTradeID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryFirmTradeID()) {		
			out.put(FixTags.SECONDARYFIRMTRADEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryFirmTradeID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeRequestType()) {		
			out.put(FixTags.TRADEREQUESTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)tradeRequestType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSubscriptionRequestType()) {		
			out.put(FixTags.SUBSCRIPTIONREQUESTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,subscriptionRequestType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotNumTradeReports()) {		
			out.put(FixTags.TOTNUMTRADEREPORTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totNumTradeReports);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeRequestResult()) {		
			out.put(FixTags.TRADEREQUESTRESULT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)tradeRequestResult);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeRequestStatus()) {		
			out.put(FixTags.TRADEREQUESTSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)tradeRequestStatus);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMultiLegReportingType()) {		
			out.put(FixTags.MULTILEGREPORTINGTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,multiLegReportingType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasResponseTransportType()) {		
			out.put(FixTags.RESPONSETRANSPORTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)responseTransportType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasResponseDestination()) {		
			out.put(FixTags.RESPONSEDESTINATION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,responseDestination); 		
		
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
		if (hasMessageEventSource()) {		
			out.put(FixTags.MESSAGEEVENTSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,messageEventSource); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		instrument.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(instrmtLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) if (fixInstrmtLegGrp.hasGroup()) fixInstrmtLegGrp.encode(out);
		
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
		
		if (hasTradeRequestID()) {		
			FixUtils.put(out,tradeRequestID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeID()) {		
			FixUtils.put(out,tradeID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryTradeID()) {		
			FixUtils.put(out,secondaryTradeID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFirmTradeID()) {		
			FixUtils.put(out,firmTradeID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryFirmTradeID()) {		
			FixUtils.put(out,secondaryFirmTradeID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeRequestType()) {		
			FixUtils.put(out, (long)tradeRequestType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSubscriptionRequestType()) {		
			FixUtils.put(out,subscriptionRequestType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNumTradeReports()) {		
			FixUtils.put(out, (long)totNumTradeReports);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeRequestResult()) {		
			FixUtils.put(out, (long)tradeRequestResult);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeRequestStatus()) {		
			FixUtils.put(out, (long)tradeRequestStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMultiLegReportingType()) {		
			FixUtils.put(out,multiLegReportingType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasResponseTransportType()) {		
			FixUtils.put(out, (long)responseTransportType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasResponseDestination()) {		
			FixUtils.put(out,responseDestination); 		
		
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
		
		if (hasMessageEventSource()) {		
			FixUtils.put(out,messageEventSource); 		
		
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
			
	public void crackTradeRequestID() {		
		getTradeRequestID();		
	}		
			
	public byte[] getTradeRequestID() { 		
		if ( hasTradeRequestID()) {		
			if (hasTradeRequestID == FixUtils.TAG_HAS_VALUE) {		
				return tradeRequestID; 		
			} else {

				buf.position(hasTradeRequestID);

			FixMessage.getTagStringValue(buf, tradeRequestID, 0, tradeRequestID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeRequestID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeRequestID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeRequestID() { return hasTradeRequestID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeRequestID(byte[] src) {		
		if (src == null ) return;
		if (hasTradeRequestID()) FixUtils.fillNul(tradeRequestID);		
		FixUtils.copy(tradeRequestID, src); 		
		hasTradeRequestID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeRequestID(String str) {		
		if (str == null ) return;
		if (hasTradeRequestID()) FixUtils.fillNul(tradeRequestID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeRequestID, src); 		
		hasTradeRequestID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeID() {		
		getTradeID();		
	}		
			
	public byte[] getTradeID() { 		
		if ( hasTradeID()) {		
			if (hasTradeID == FixUtils.TAG_HAS_VALUE) {		
				return tradeID; 		
			} else {

				buf.position(hasTradeID);

			FixMessage.getTagStringValue(buf, tradeID, 0, tradeID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeID() { return hasTradeID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeID(byte[] src) {		
		if (src == null ) return;
		if (hasTradeID()) FixUtils.fillNul(tradeID);		
		FixUtils.copy(tradeID, src); 		
		hasTradeID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeID(String str) {		
		if (str == null ) return;
		if (hasTradeID()) FixUtils.fillNul(tradeID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeID, src); 		
		hasTradeID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryTradeID() {		
		getSecondaryTradeID();		
	}		
			
	public byte[] getSecondaryTradeID() { 		
		if ( hasSecondaryTradeID()) {		
			if (hasSecondaryTradeID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryTradeID; 		
			} else {

				buf.position(hasSecondaryTradeID);

			FixMessage.getTagStringValue(buf, secondaryTradeID, 0, secondaryTradeID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryTradeID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryTradeID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryTradeID() { return hasSecondaryTradeID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryTradeID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryTradeID()) FixUtils.fillNul(secondaryTradeID);		
		FixUtils.copy(secondaryTradeID, src); 		
		hasSecondaryTradeID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryTradeID(String str) {		
		if (str == null ) return;
		if (hasSecondaryTradeID()) FixUtils.fillNul(secondaryTradeID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryTradeID, src); 		
		hasSecondaryTradeID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackFirmTradeID() {		
		getFirmTradeID();		
	}		
			
	public byte[] getFirmTradeID() { 		
		if ( hasFirmTradeID()) {		
			if (hasFirmTradeID == FixUtils.TAG_HAS_VALUE) {		
				return firmTradeID; 		
			} else {

				buf.position(hasFirmTradeID);

			FixMessage.getTagStringValue(buf, firmTradeID, 0, firmTradeID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasFirmTradeID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return firmTradeID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasFirmTradeID() { return hasFirmTradeID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setFirmTradeID(byte[] src) {		
		if (src == null ) return;
		if (hasFirmTradeID()) FixUtils.fillNul(firmTradeID);		
		FixUtils.copy(firmTradeID, src); 		
		hasFirmTradeID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFirmTradeID(String str) {		
		if (str == null ) return;
		if (hasFirmTradeID()) FixUtils.fillNul(firmTradeID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(firmTradeID, src); 		
		hasFirmTradeID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryFirmTradeID() {		
		getSecondaryFirmTradeID();		
	}		
			
	public byte[] getSecondaryFirmTradeID() { 		
		if ( hasSecondaryFirmTradeID()) {		
			if (hasSecondaryFirmTradeID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryFirmTradeID; 		
			} else {

				buf.position(hasSecondaryFirmTradeID);

			FixMessage.getTagStringValue(buf, secondaryFirmTradeID, 0, secondaryFirmTradeID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryFirmTradeID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryFirmTradeID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryFirmTradeID() { return hasSecondaryFirmTradeID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryFirmTradeID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryFirmTradeID()) FixUtils.fillNul(secondaryFirmTradeID);		
		FixUtils.copy(secondaryFirmTradeID, src); 		
		hasSecondaryFirmTradeID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryFirmTradeID(String str) {		
		if (str == null ) return;
		if (hasSecondaryFirmTradeID()) FixUtils.fillNul(secondaryFirmTradeID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryFirmTradeID, src); 		
		hasSecondaryFirmTradeID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeRequestType() {		
		getTradeRequestType();		
	}		
			
	public long getTradeRequestType() { 		
		if ( hasTradeRequestType()) {		
			if (hasTradeRequestType == FixUtils.TAG_HAS_VALUE) {		
				return tradeRequestType; 		
			} else {

				buf.position(hasTradeRequestType);

			tradeRequestType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTradeRequestType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeRequestType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradeRequestType() { return hasTradeRequestType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeRequestType(byte[] src) {		
		if (src == null ) return;
		if (hasTradeRequestType()) tradeRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		tradeRequestType = FixUtils.longValueOf(src, 0, src.length);
		hasTradeRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeRequestType(long src) {		
		tradeRequestType = src;
		hasTradeRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeRequestType(String str) {		
		if (str == null ) return;
		if (hasTradeRequestType()) tradeRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradeRequestType = FixUtils.longValueOf(src, 0, src.length);
		hasTradeRequestType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSubscriptionRequestType() {		
		getSubscriptionRequestType();		
	}		
			
	public byte getSubscriptionRequestType() { 		
		if ( hasSubscriptionRequestType()) {		
			if (hasSubscriptionRequestType == FixUtils.TAG_HAS_VALUE) {		
				return subscriptionRequestType; 		
			} else {

				buf.position(hasSubscriptionRequestType);

			subscriptionRequestType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (subscriptionRequestType != (byte)'2') && (subscriptionRequestType != (byte)'1') && (subscriptionRequestType != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 263);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return subscriptionRequestType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSubscriptionRequestType() { return hasSubscriptionRequestType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSubscriptionRequestType(byte[] src) {		
		if (src == null ) return;
		if (hasSubscriptionRequestType()) subscriptionRequestType = (byte)' ';		
		subscriptionRequestType = src[0];		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSubscriptionRequestType(byte src) {		
		subscriptionRequestType = src;
		hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSubscriptionRequestType(String str) {		
		if (str == null ) return;
		if (hasSubscriptionRequestType()) subscriptionRequestType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		subscriptionRequestType = src[0];		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTotNumTradeReports() {		
		getTotNumTradeReports();		
	}		
			
	public long getTotNumTradeReports() { 		
		if ( hasTotNumTradeReports()) {		
			if (hasTotNumTradeReports == FixUtils.TAG_HAS_VALUE) {		
				return totNumTradeReports; 		
			} else {

				buf.position(hasTotNumTradeReports);

			totNumTradeReports = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotNumTradeReports = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totNumTradeReports;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNumTradeReports() { return hasTotNumTradeReports != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotNumTradeReports(byte[] src) {		
		if (src == null ) return;
		if (hasTotNumTradeReports()) totNumTradeReports = FixUtils.TAG_HAS_NO_VALUE;		
		totNumTradeReports = FixUtils.longValueOf(src, 0, src.length);
		hasTotNumTradeReports = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNumTradeReports(long src) {		
		totNumTradeReports = src;
		hasTotNumTradeReports = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNumTradeReports(String str) {		
		if (str == null ) return;
		if (hasTotNumTradeReports()) totNumTradeReports = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNumTradeReports = FixUtils.longValueOf(src, 0, src.length);
		hasTotNumTradeReports = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeRequestResult() {		
		getTradeRequestResult();		
	}		
			
	public long getTradeRequestResult() { 		
		if ( hasTradeRequestResult()) {		
			if (hasTradeRequestResult == FixUtils.TAG_HAS_VALUE) {		
				return tradeRequestResult; 		
			} else {

				buf.position(hasTradeRequestResult);

			tradeRequestResult = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTradeRequestResult = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeRequestResult;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradeRequestResult() { return hasTradeRequestResult != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeRequestResult(byte[] src) {		
		if (src == null ) return;
		if (hasTradeRequestResult()) tradeRequestResult = FixUtils.TAG_HAS_NO_VALUE;		
		tradeRequestResult = FixUtils.longValueOf(src, 0, src.length);
		hasTradeRequestResult = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeRequestResult(long src) {		
		tradeRequestResult = src;
		hasTradeRequestResult = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeRequestResult(String str) {		
		if (str == null ) return;
		if (hasTradeRequestResult()) tradeRequestResult = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradeRequestResult = FixUtils.longValueOf(src, 0, src.length);
		hasTradeRequestResult = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeRequestStatus() {		
		getTradeRequestStatus();		
	}		
			
	public long getTradeRequestStatus() { 		
		if ( hasTradeRequestStatus()) {		
			if (hasTradeRequestStatus == FixUtils.TAG_HAS_VALUE) {		
				return tradeRequestStatus; 		
			} else {

				buf.position(hasTradeRequestStatus);

			tradeRequestStatus = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTradeRequestStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeRequestStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradeRequestStatus() { return hasTradeRequestStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeRequestStatus(byte[] src) {		
		if (src == null ) return;
		if (hasTradeRequestStatus()) tradeRequestStatus = FixUtils.TAG_HAS_NO_VALUE;		
		tradeRequestStatus = FixUtils.longValueOf(src, 0, src.length);
		hasTradeRequestStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeRequestStatus(long src) {		
		tradeRequestStatus = src;
		hasTradeRequestStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeRequestStatus(String str) {		
		if (str == null ) return;
		if (hasTradeRequestStatus()) tradeRequestStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradeRequestStatus = FixUtils.longValueOf(src, 0, src.length);
		hasTradeRequestStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMultiLegReportingType() {		
		getMultiLegReportingType();		
	}		
			
	public byte getMultiLegReportingType() { 		
		if ( hasMultiLegReportingType()) {		
			if (hasMultiLegReportingType == FixUtils.TAG_HAS_VALUE) {		
				return multiLegReportingType; 		
			} else {

				buf.position(hasMultiLegReportingType);

			multiLegReportingType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (multiLegReportingType != (byte)'3') && (multiLegReportingType != (byte)'2') && (multiLegReportingType != (byte)'1') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 442);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasMultiLegReportingType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return multiLegReportingType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMultiLegReportingType() { return hasMultiLegReportingType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMultiLegReportingType(byte[] src) {		
		if (src == null ) return;
		if (hasMultiLegReportingType()) multiLegReportingType = (byte)' ';		
		multiLegReportingType = src[0];		
		hasMultiLegReportingType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMultiLegReportingType(byte src) {		
		multiLegReportingType = src;
		hasMultiLegReportingType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMultiLegReportingType(String str) {		
		if (str == null ) return;
		if (hasMultiLegReportingType()) multiLegReportingType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		multiLegReportingType = src[0];		
		hasMultiLegReportingType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackResponseTransportType() {		
		getResponseTransportType();		
	}		
			
	public long getResponseTransportType() { 		
		if ( hasResponseTransportType()) {		
			if (hasResponseTransportType == FixUtils.TAG_HAS_VALUE) {		
				return responseTransportType; 		
			} else {

				buf.position(hasResponseTransportType);

			responseTransportType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasResponseTransportType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return responseTransportType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasResponseTransportType() { return hasResponseTransportType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setResponseTransportType(byte[] src) {		
		if (src == null ) return;
		if (hasResponseTransportType()) responseTransportType = FixUtils.TAG_HAS_NO_VALUE;		
		responseTransportType = FixUtils.longValueOf(src, 0, src.length);
		hasResponseTransportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setResponseTransportType(long src) {		
		responseTransportType = src;
		hasResponseTransportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setResponseTransportType(String str) {		
		if (str == null ) return;
		if (hasResponseTransportType()) responseTransportType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		responseTransportType = FixUtils.longValueOf(src, 0, src.length);
		hasResponseTransportType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackResponseDestination() {		
		getResponseDestination();		
	}		
			
	public byte[] getResponseDestination() { 		
		if ( hasResponseDestination()) {		
			if (hasResponseDestination == FixUtils.TAG_HAS_VALUE) {		
				return responseDestination; 		
			} else {

				buf.position(hasResponseDestination);

			FixMessage.getTagStringValue(buf, responseDestination, 0, responseDestination.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasResponseDestination = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return responseDestination;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasResponseDestination() { return hasResponseDestination != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setResponseDestination(byte[] src) {		
		if (src == null ) return;
		if (hasResponseDestination()) FixUtils.fillNul(responseDestination);		
		FixUtils.copy(responseDestination, src); 		
		hasResponseDestination = FixUtils.TAG_HAS_VALUE;		
	}

	public void setResponseDestination(String str) {		
		if (str == null ) return;
		if (hasResponseDestination()) FixUtils.fillNul(responseDestination);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(responseDestination, src); 		
		hasResponseDestination = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackMessageEventSource() {		
		getMessageEventSource();		
	}		
			
	public byte[] getMessageEventSource() { 		
		if ( hasMessageEventSource()) {		
			if (hasMessageEventSource == FixUtils.TAG_HAS_VALUE) {		
				return messageEventSource; 		
			} else {

				buf.position(hasMessageEventSource);

			FixMessage.getTagStringValue(buf, messageEventSource, 0, messageEventSource.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMessageEventSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return messageEventSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMessageEventSource() { return hasMessageEventSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMessageEventSource(byte[] src) {		
		if (src == null ) return;
		if (hasMessageEventSource()) FixUtils.fillNul(messageEventSource);		
		FixUtils.copy(messageEventSource, src); 		
		hasMessageEventSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMessageEventSource(String str) {		
		if (str == null ) return;
		if (hasMessageEventSource()) FixUtils.fillNul(messageEventSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(messageEventSource, src); 		
		hasMessageEventSource = FixUtils.TAG_HAS_VALUE;		
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

					if (hasTradeRequestID()) s += "TradeRequestID(568)= " + new String( FixUtils.trim(getTradeRequestID()) ) + "\n" ; 
		if (hasTradeID()) s += "TradeID(1003)= " + new String( FixUtils.trim(getTradeID()) ) + "\n" ; 
		if (hasSecondaryTradeID()) s += "SecondaryTradeID(1040)= " + new String( FixUtils.trim(getSecondaryTradeID()) ) + "\n" ; 
		if (hasFirmTradeID()) s += "FirmTradeID(1041)= " + new String( FixUtils.trim(getFirmTradeID()) ) + "\n" ; 
		if (hasSecondaryFirmTradeID()) s += "SecondaryFirmTradeID(1042)= " + new String( FixUtils.trim(getSecondaryFirmTradeID()) ) + "\n" ; 
		if (hasTradeRequestType()) s += "TradeRequestType(569)= " + getTradeRequestType() + "\n" ; 
		if (hasSubscriptionRequestType()) s += "SubscriptionRequestType(263)= " + getSubscriptionRequestType() + "\n" ; 
		if (hasTotNumTradeReports()) s += "TotNumTradeReports(748)= " + getTotNumTradeReports() + "\n" ; 
		if (hasTradeRequestResult()) s += "TradeRequestResult(749)= " + getTradeRequestResult() + "\n" ; 
		if (hasTradeRequestStatus()) s += "TradeRequestStatus(750)= " + getTradeRequestStatus() + "\n" ; 
		if (hasMultiLegReportingType()) s += "MultiLegReportingType(442)= " + getMultiLegReportingType() + "\n" ; 
		if (hasResponseTransportType()) s += "ResponseTransportType(725)= " + getResponseTransportType() + "\n" ; 
		if (hasResponseDestination()) s += "ResponseDestination(726)= " + new String( FixUtils.trim(getResponseDestination()) ) + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasMessageEventSource()) s += "MessageEventSource(1011)= " + new String( FixUtils.trim(getMessageEventSource()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTradeCaptureReportRequestAck)) return false;

		FixTradeCaptureReportRequestAck msg = (FixTradeCaptureReportRequestAck) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasTradeRequestID() && !msg.hasTradeRequestID()) || (!hasTradeRequestID() && msg.hasTradeRequestID())) return false;
		if (!(!hasTradeRequestID() && !msg.hasTradeRequestID()) && !FixUtils.equals(getTradeRequestID(), msg.getTradeRequestID())) return false;
		if ((hasTradeID() && !msg.hasTradeID()) || (!hasTradeID() && msg.hasTradeID())) return false;
		if (!(!hasTradeID() && !msg.hasTradeID()) && !FixUtils.equals(getTradeID(), msg.getTradeID())) return false;
		if ((hasSecondaryTradeID() && !msg.hasSecondaryTradeID()) || (!hasSecondaryTradeID() && msg.hasSecondaryTradeID())) return false;
		if (!(!hasSecondaryTradeID() && !msg.hasSecondaryTradeID()) && !FixUtils.equals(getSecondaryTradeID(), msg.getSecondaryTradeID())) return false;
		if ((hasFirmTradeID() && !msg.hasFirmTradeID()) || (!hasFirmTradeID() && msg.hasFirmTradeID())) return false;
		if (!(!hasFirmTradeID() && !msg.hasFirmTradeID()) && !FixUtils.equals(getFirmTradeID(), msg.getFirmTradeID())) return false;
		if ((hasSecondaryFirmTradeID() && !msg.hasSecondaryFirmTradeID()) || (!hasSecondaryFirmTradeID() && msg.hasSecondaryFirmTradeID())) return false;
		if (!(!hasSecondaryFirmTradeID() && !msg.hasSecondaryFirmTradeID()) && !FixUtils.equals(getSecondaryFirmTradeID(), msg.getSecondaryFirmTradeID())) return false;
		if ((hasTradeRequestType() && !msg.hasTradeRequestType()) || (!hasTradeRequestType() && msg.hasTradeRequestType())) return false;
		if (!(!hasTradeRequestType() && !msg.hasTradeRequestType()) && !(getTradeRequestType()==msg.getTradeRequestType())) return false;
		if ((hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) || (!hasSubscriptionRequestType() && msg.hasSubscriptionRequestType())) return false;
		if (!(!hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) && !(getSubscriptionRequestType()==msg.getSubscriptionRequestType())) return false;
		if ((hasTotNumTradeReports() && !msg.hasTotNumTradeReports()) || (!hasTotNumTradeReports() && msg.hasTotNumTradeReports())) return false;
		if (!(!hasTotNumTradeReports() && !msg.hasTotNumTradeReports()) && !(getTotNumTradeReports()==msg.getTotNumTradeReports())) return false;
		if ((hasTradeRequestResult() && !msg.hasTradeRequestResult()) || (!hasTradeRequestResult() && msg.hasTradeRequestResult())) return false;
		if (!(!hasTradeRequestResult() && !msg.hasTradeRequestResult()) && !(getTradeRequestResult()==msg.getTradeRequestResult())) return false;
		if ((hasTradeRequestStatus() && !msg.hasTradeRequestStatus()) || (!hasTradeRequestStatus() && msg.hasTradeRequestStatus())) return false;
		if (!(!hasTradeRequestStatus() && !msg.hasTradeRequestStatus()) && !(getTradeRequestStatus()==msg.getTradeRequestStatus())) return false;
		if ((hasMultiLegReportingType() && !msg.hasMultiLegReportingType()) || (!hasMultiLegReportingType() && msg.hasMultiLegReportingType())) return false;
		if (!(!hasMultiLegReportingType() && !msg.hasMultiLegReportingType()) && !(getMultiLegReportingType()==msg.getMultiLegReportingType())) return false;
		if ((hasResponseTransportType() && !msg.hasResponseTransportType()) || (!hasResponseTransportType() && msg.hasResponseTransportType())) return false;
		if (!(!hasResponseTransportType() && !msg.hasResponseTransportType()) && !(getResponseTransportType()==msg.getResponseTransportType())) return false;
		if ((hasResponseDestination() && !msg.hasResponseDestination()) || (!hasResponseDestination() && msg.hasResponseDestination())) return false;
		if (!(!hasResponseDestination() && !msg.hasResponseDestination()) && !FixUtils.equals(getResponseDestination(), msg.getResponseDestination())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasMessageEventSource() && !msg.hasMessageEventSource()) || (!hasMessageEventSource() && msg.hasMessageEventSource())) return false;
		if (!(!hasMessageEventSource() && !msg.hasMessageEventSource()) && !FixUtils.equals(getMessageEventSource(), msg.getMessageEventSource())) return false;
		return true;
	}
	@Override
	public FixTradeCaptureReportRequestAck clone () {
		FixTradeCaptureReportRequestAck out = new FixTradeCaptureReportRequestAck();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixTradeCaptureReportRequestAck clone ( FixTradeCaptureReportRequestAck out ) {
		if ( hasTradeRequestID())
			out.setTradeRequestID(getTradeRequestID());
		if ( hasTradeID())
			out.setTradeID(getTradeID());
		if ( hasSecondaryTradeID())
			out.setSecondaryTradeID(getSecondaryTradeID());
		if ( hasFirmTradeID())
			out.setFirmTradeID(getFirmTradeID());
		if ( hasSecondaryFirmTradeID())
			out.setSecondaryFirmTradeID(getSecondaryFirmTradeID());
		if ( hasTradeRequestType())
			out.setTradeRequestType(getTradeRequestType());
		if ( hasSubscriptionRequestType())
			out.setSubscriptionRequestType(getSubscriptionRequestType());
		if ( hasTotNumTradeReports())
			out.setTotNumTradeReports(getTotNumTradeReports());
		if ( hasTradeRequestResult())
			out.setTradeRequestResult(getTradeRequestResult());
		if ( hasTradeRequestStatus())
			out.setTradeRequestStatus(getTradeRequestStatus());
		if ( hasMultiLegReportingType())
			out.setMultiLegReportingType(getMultiLegReportingType());
		if ( hasResponseTransportType())
			out.setResponseTransportType(getResponseTransportType());
		if ( hasResponseDestination())
			out.setResponseDestination(getResponseDestination());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasMessageEventSource())
			out.setMessageEventSource(getMessageEventSource());
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		int count = 0;
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		count = 0;
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) {
			if (!fixInstrmtLegGrp.hasGroup()) continue;
			out.instrmtLegGrp[count] = fixInstrmtLegGrp.clone( out.instrmtLegGrp[count] );
			count++;
		}
		return out;
	}

}
