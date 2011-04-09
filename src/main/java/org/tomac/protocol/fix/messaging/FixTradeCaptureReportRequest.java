package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixTradeCaptureReportRequest extends FixInMessage {
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
	private short hasTradeReportID;
	byte[] tradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryTradeReportID;
	byte[] secondaryTradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExecID;
	byte[] execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExecType;
	byte execType = (byte)' ';		
	private short hasOrderID;
	byte[] orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMatchStatus;
	byte matchStatus = (byte)' ';		
	private short hasTrdType;
	long trdType = 0;		
	private short hasTrdSubType;
	long trdSubType = 0;		
	private short hasTradeHandlingInstr;
	byte tradeHandlingInstr = (byte)' ';		
	private short hasTransferReason;
	byte[] transferReason = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryTrdType;
	long secondaryTrdType = 0;		
	private short hasTradeLinkID;
	byte[] tradeLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTrdMatchID;
	byte[] trdMatchID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTimeBracket;
	byte[] timeBracket = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasMultiLegReportingType;
	byte multiLegReportingType = (byte)' ';		
	private short hasTradeInputSource;
	byte[] tradeInputSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeInputDevice;
	byte[] tradeInputDevice = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
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
	public FixParties[] parties;
	public FixInstrument instrument;
	public FixInstrumentExtension instrumentExtension;
	public FixFinancingDetails financingDetails;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	public FixTrdCapDtGrp[] trdCapDtGrp;
	
	public FixTradeCaptureReportRequest() {
		super(FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUEST);


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
		hasTradeReportID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryTradeReportID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryTradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExecID = FixUtils.TAG_HAS_NO_VALUE;		
		execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExecType = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMatchStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasTrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTrdSubType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeHandlingInstr = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransferReason = FixUtils.TAG_HAS_NO_VALUE;		
		transferReason = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryTrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeLinkID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTrdMatchID = FixUtils.TAG_HAS_NO_VALUE;		
		trdMatchID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTimeBracket = FixUtils.TAG_HAS_NO_VALUE;		
		timeBracket = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasMultiLegReportingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeInputSource = FixUtils.TAG_HAS_NO_VALUE;		
		tradeInputSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeInputDevice = FixUtils.TAG_HAS_NO_VALUE;		
		tradeInputDevice = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
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
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		instrument = new FixInstrument();
		instrumentExtension = new FixInstrumentExtension();
		financingDetails = new FixFinancingDetails();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		trdCapDtGrp = new FixTrdCapDtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdCapDtGrp[i] = new FixTrdCapDtGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.TRADEREQUESTID_INT:		
            		hasTradeRequestID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEID_INT:		
            		hasTradeID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYTRADEID_INT:		
            		hasSecondaryTradeID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.FIRMTRADEID_INT:		
            		hasFirmTradeID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYFIRMTRADEID_INT:		
            		hasSecondaryFirmTradeID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREQUESTTYPE_INT:		
            		hasTradeRequestType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SUBSCRIPTIONREQUESTTYPE_INT:		
            		hasSubscriptionRequestType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREPORTID_INT:		
            		hasTradeReportID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYTRADEREPORTID_INT:		
            		hasSecondaryTradeReportID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXECID_INT:		
            		hasExecID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXECTYPE_INT:		
            		hasExecType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ORDERID_INT:		
            		hasOrderID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MATCHSTATUS_INT:		
            		hasMatchStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRDTYPE_INT:		
            		hasTrdType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRDSUBTYPE_INT:		
            		hasTrdSubType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEHANDLINGINSTR_INT:		
            		hasTradeHandlingInstr = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRANSFERREASON_INT:		
            		hasTransferReason = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYTRDTYPE_INT:		
            		hasSecondaryTrdType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADELINKID_INT:		
            		hasTradeLinkID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRDMATCHID_INT:		
            		hasTrdMatchID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADINGSESSIONID_INT:		
            		hasTradingSessionID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADINGSESSIONSUBID_INT:		
            		hasTradingSessionSubID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TIMEBRACKET_INT:		
            		hasTimeBracket = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MULTILEGREPORTINGTYPE_INT:		
            		hasMultiLegReportingType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEINPUTSOURCE_INT:		
            		hasTradeInputSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEINPUTDEVICE_INT:		
            		hasTradeInputDevice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.RESPONSETRANSPORTTYPE_INT:		
            		hasResponseTransportType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.RESPONSEDESTINATION_INT:		
            		hasResponseDestination = (short) buf.position();		
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
            	case FixTags.MESSAGEEVENTSOURCE_INT:		
            		hasMessageEventSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	default:
        			if ( standardHeader.isKeyTag(tag)) {
        				tag = standardHeader.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( standardTrailer.isKeyTag(tag)) {
        				tag = standardTrailer.setBuffer( tag, buf, err);
        				FixUtils.unreadLastTag(tag, buf);
        				if (!err.hasError()) hasRequiredTags(err);
            			return; // always last, we are done now
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
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( instrumentExtension.isKeyTag(tag)) {
        				tag = instrumentExtension.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( financingDetails.isKeyTag(tag)) {
        				tag = financingDetails.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOUNDERLYINGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !undInstrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOUNDERLYINGS_INT);
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
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOLEGS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NODATES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdCapDtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NODATES_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdCapDtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUEST_INT);
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
		if (!hasTradeRequestID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRADEREQUESTID_INT, FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUEST_INT);
			return false;
		}
		if (!hasTradeRequestType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRADEREQUESTTYPE_INT, FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUEST_INT);
			return false;
		}
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
		getTradeReportID();		
		getSecondaryTradeReportID();		
		getExecID();		
		getExecType();		
		getOrderID();		
		getClOrdID();		
		getMatchStatus();		
		getTrdType();		
		getTrdSubType();		
		getTradeHandlingInstr();		
		getTransferReason();		
		getSecondaryTrdType();		
		getTradeLinkID();		
		getTrdMatchID();		
		getClearingBusinessDate();		
		getTradingSessionID();		
		getTradingSessionSubID();		
		getTimeBracket();		
		getSide();		
		getMultiLegReportingType();		
		getTradeInputSource();		
		getTradeInputDevice();		
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
		if (hasTradeReportID()) {		
			out.put(FixTags.TRADEREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeReportID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryTradeReportID()) {		
			out.put(FixTags.SECONDARYTRADEREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryTradeReportID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecID()) {		
			out.put(FixTags.EXECID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecType()) {		
			out.put(FixTags.EXECTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrderID()) {		
			out.put(FixTags.ORDERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMatchStatus()) {		
			out.put(FixTags.MATCHSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,matchStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTrdType()) {		
			out.put(FixTags.TRDTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)trdType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTrdSubType()) {		
			out.put(FixTags.TRDSUBTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)trdSubType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeHandlingInstr()) {		
			out.put(FixTags.TRADEHANDLINGINSTR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeHandlingInstr); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransferReason()) {		
			out.put(FixTags.TRANSFERREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transferReason); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryTrdType()) {		
			out.put(FixTags.SECONDARYTRDTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)secondaryTrdType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeLinkID()) {		
			out.put(FixTags.TRADELINKID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeLinkID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTrdMatchID()) {		
			out.put(FixTags.TRDMATCHID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,trdMatchID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradingSessionID()) {		
			out.put(FixTags.TRADINGSESSIONID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradingSessionID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradingSessionSubID()) {		
			out.put(FixTags.TRADINGSESSIONSUBID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradingSessionSubID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTimeBracket()) {		
			out.put(FixTags.TIMEBRACKET);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,timeBracket); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSide()) {		
			out.put(FixTags.SIDE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMultiLegReportingType()) {		
			out.put(FixTags.MULTILEGREPORTINGTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,multiLegReportingType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeInputSource()) {		
			out.put(FixTags.TRADEINPUTSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeInputSource); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeInputDevice()) {		
			out.put(FixTags.TRADEINPUTDEVICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeInputDevice); 		
		
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
		
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		instrument.encode(out);
		instrumentExtension.encode(out);
		financingDetails.encode(out);
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
		if (FixUtils.getNoInGroup(trdCapDtGrp)>0) {
			out.put(FixTags.NODATES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdCapDtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTrdCapDtGrp fixTrdCapDtGrp : trdCapDtGrp) if (fixTrdCapDtGrp.hasGroup()) fixTrdCapDtGrp.encode(out);
		
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
		
		if (hasTradeReportID()) {		
			FixUtils.put(out,tradeReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryTradeReportID()) {		
			FixUtils.put(out,secondaryTradeReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecID()) {		
			FixUtils.put(out,execID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecType()) {		
			FixUtils.put(out,execType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderID()) {		
			FixUtils.put(out,orderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMatchStatus()) {		
			FixUtils.put(out,matchStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTrdType()) {		
			FixUtils.put(out, (long)trdType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTrdSubType()) {		
			FixUtils.put(out, (long)trdSubType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeHandlingInstr()) {		
			FixUtils.put(out,tradeHandlingInstr); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransferReason()) {		
			FixUtils.put(out,transferReason); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryTrdType()) {		
			FixUtils.put(out, (long)secondaryTrdType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeLinkID()) {		
			FixUtils.put(out,tradeLinkID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTrdMatchID()) {		
			FixUtils.put(out,trdMatchID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionID()) {		
			FixUtils.put(out,tradingSessionID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionSubID()) {		
			FixUtils.put(out,tradingSessionSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTimeBracket()) {		
			FixUtils.put(out,timeBracket); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMultiLegReportingType()) {		
			FixUtils.put(out,multiLegReportingType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeInputSource()) {		
			FixUtils.put(out,tradeInputSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeInputDevice()) {		
			FixUtils.put(out,tradeInputDevice); 		
		
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

			FixUtils.getTagStringValue(buf, tradeRequestID, 0, tradeRequestID.length, err);
		
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

			FixUtils.getTagStringValue(buf, tradeID, 0, tradeID.length, err);
		
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

			FixUtils.getTagStringValue(buf, secondaryTradeID, 0, secondaryTradeID.length, err);
		
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

			FixUtils.getTagStringValue(buf, firmTradeID, 0, firmTradeID.length, err);
		
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

			FixUtils.getTagStringValue(buf, secondaryFirmTradeID, 0, secondaryFirmTradeID.length, err);
		
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

			tradeRequestType = FixUtils.getTagIntValue(buf, err);
		
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

			subscriptionRequestType = FixUtils.getTagCharValue(buf, err);
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
			
	public void crackTradeReportID() {		
		getTradeReportID();		
	}		
			
	public byte[] getTradeReportID() { 		
		if ( hasTradeReportID()) {		
			if (hasTradeReportID == FixUtils.TAG_HAS_VALUE) {		
				return tradeReportID; 		
			} else {

				buf.position(hasTradeReportID);

			FixUtils.getTagStringValue(buf, tradeReportID, 0, tradeReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeReportID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeReportID() { return hasTradeReportID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeReportID(byte[] src) {		
		if (src == null ) return;
		if (hasTradeReportID()) FixUtils.fillNul(tradeReportID);		
		FixUtils.copy(tradeReportID, src); 		
		hasTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeReportID(String str) {		
		if (str == null ) return;
		if (hasTradeReportID()) FixUtils.fillNul(tradeReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeReportID, src); 		
		hasTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryTradeReportID() {		
		getSecondaryTradeReportID();		
	}		
			
	public byte[] getSecondaryTradeReportID() { 		
		if ( hasSecondaryTradeReportID()) {		
			if (hasSecondaryTradeReportID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryTradeReportID; 		
			} else {

				buf.position(hasSecondaryTradeReportID);

			FixUtils.getTagStringValue(buf, secondaryTradeReportID, 0, secondaryTradeReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryTradeReportID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryTradeReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryTradeReportID() { return hasSecondaryTradeReportID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryTradeReportID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryTradeReportID()) FixUtils.fillNul(secondaryTradeReportID);		
		FixUtils.copy(secondaryTradeReportID, src); 		
		hasSecondaryTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryTradeReportID(String str) {		
		if (str == null ) return;
		if (hasSecondaryTradeReportID()) FixUtils.fillNul(secondaryTradeReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryTradeReportID, src); 		
		hasSecondaryTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExecID() {		
		getExecID();		
	}		
			
	public byte[] getExecID() { 		
		if ( hasExecID()) {		
			if (hasExecID == FixUtils.TAG_HAS_VALUE) {		
				return execID; 		
			} else {

				buf.position(hasExecID);

			FixUtils.getTagStringValue(buf, execID, 0, execID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExecID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExecID() { return hasExecID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecID(byte[] src) {		
		if (src == null ) return;
		if (hasExecID()) FixUtils.fillNul(execID);		
		FixUtils.copy(execID, src); 		
		hasExecID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecID(String str) {		
		if (str == null ) return;
		if (hasExecID()) FixUtils.fillNul(execID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(execID, src); 		
		hasExecID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExecType() {		
		getExecType();		
	}		
			
	public byte getExecType() { 		
		if ( hasExecType()) {		
			if (hasExecType == FixUtils.TAG_HAS_VALUE) {		
				return execType; 		
			} else {

				buf.position(hasExecType);

			execType = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (execType != (byte)'D') && (execType != (byte)'E') && (execType != (byte)'F') && (execType != (byte)'G') && (execType != (byte)'A') && (execType != (byte)'B') && (execType != (byte)'C') && (execType != (byte)'L') && (execType != (byte)'H') && (execType != (byte)'I') && (execType != (byte)'J') && (execType != (byte)'K') && (execType != (byte)'3') && (execType != (byte)'0') && (execType != (byte)'7') && (execType != (byte)'6') && (execType != (byte)'5') && (execType != (byte)'4') && (execType != (byte)'9') && (execType != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 150);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasExecType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasExecType() { return hasExecType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecType(byte[] src) {		
		if (src == null ) return;
		if (hasExecType()) execType = (byte)' ';		
		execType = src[0];		
		hasExecType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecType(byte src) {		
		execType = src;
		hasExecType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecType(String str) {		
		if (str == null ) return;
		if (hasExecType()) execType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		execType = src[0];		
		hasExecType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrderID() {		
		getOrderID();		
	}		
			
	public byte[] getOrderID() { 		
		if ( hasOrderID()) {		
			if (hasOrderID == FixUtils.TAG_HAS_VALUE) {		
				return orderID; 		
			} else {

				buf.position(hasOrderID);

			FixUtils.getTagStringValue(buf, orderID, 0, orderID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrderID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderID() { return hasOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasOrderID()) FixUtils.fillNul(orderID);		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderID(String str) {		
		if (str == null ) return;
		if (hasOrderID()) FixUtils.fillNul(orderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
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

			FixUtils.getTagStringValue(buf, clOrdID, 0, clOrdID.length, err);
		
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
			
	public void crackMatchStatus() {		
		getMatchStatus();		
	}		
			
	public byte getMatchStatus() { 		
		if ( hasMatchStatus()) {		
			if (hasMatchStatus == FixUtils.TAG_HAS_VALUE) {		
				return matchStatus; 		
			} else {

				buf.position(hasMatchStatus);

			matchStatus = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (matchStatus != (byte)'2') && (matchStatus != (byte)'1') && (matchStatus != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 573);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasMatchStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return matchStatus;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMatchStatus() { return hasMatchStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMatchStatus(byte[] src) {		
		if (src == null ) return;
		if (hasMatchStatus()) matchStatus = (byte)' ';		
		matchStatus = src[0];		
		hasMatchStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMatchStatus(byte src) {		
		matchStatus = src;
		hasMatchStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMatchStatus(String str) {		
		if (str == null ) return;
		if (hasMatchStatus()) matchStatus = (byte)' ';		
		byte[] src = str.getBytes(); 		
		matchStatus = src[0];		
		hasMatchStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTrdType() {		
		getTrdType();		
	}		
			
	public long getTrdType() { 		
		if ( hasTrdType()) {		
			if (hasTrdType == FixUtils.TAG_HAS_VALUE) {		
				return trdType; 		
			} else {

				buf.position(hasTrdType);

			trdType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTrdType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return trdType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTrdType() { return hasTrdType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTrdType(byte[] src) {		
		if (src == null ) return;
		if (hasTrdType()) trdType = FixUtils.TAG_HAS_NO_VALUE;		
		trdType = FixUtils.longValueOf(src, 0, src.length);
		hasTrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdType(long src) {		
		trdType = src;
		hasTrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdType(String str) {		
		if (str == null ) return;
		if (hasTrdType()) trdType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		trdType = FixUtils.longValueOf(src, 0, src.length);
		hasTrdType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTrdSubType() {		
		getTrdSubType();		
	}		
			
	public long getTrdSubType() { 		
		if ( hasTrdSubType()) {		
			if (hasTrdSubType == FixUtils.TAG_HAS_VALUE) {		
				return trdSubType; 		
			} else {

				buf.position(hasTrdSubType);

			trdSubType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTrdSubType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return trdSubType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTrdSubType() { return hasTrdSubType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTrdSubType(byte[] src) {		
		if (src == null ) return;
		if (hasTrdSubType()) trdSubType = FixUtils.TAG_HAS_NO_VALUE;		
		trdSubType = FixUtils.longValueOf(src, 0, src.length);
		hasTrdSubType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdSubType(long src) {		
		trdSubType = src;
		hasTrdSubType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdSubType(String str) {		
		if (str == null ) return;
		if (hasTrdSubType()) trdSubType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		trdSubType = FixUtils.longValueOf(src, 0, src.length);
		hasTrdSubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeHandlingInstr() {		
		getTradeHandlingInstr();		
	}		
			
	public byte getTradeHandlingInstr() { 		
		if ( hasTradeHandlingInstr()) {		
			if (hasTradeHandlingInstr == FixUtils.TAG_HAS_VALUE) {		
				return tradeHandlingInstr; 		
			} else {

				buf.position(hasTradeHandlingInstr);

			tradeHandlingInstr = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (tradeHandlingInstr != (byte)'3') && (tradeHandlingInstr != (byte)'2') && (tradeHandlingInstr != (byte)'1') && (tradeHandlingInstr != (byte)'0') && (tradeHandlingInstr != (byte)'5') && (tradeHandlingInstr != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1123);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasTradeHandlingInstr = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeHandlingInstr;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTradeHandlingInstr() { return hasTradeHandlingInstr != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeHandlingInstr(byte[] src) {		
		if (src == null ) return;
		if (hasTradeHandlingInstr()) tradeHandlingInstr = (byte)' ';		
		tradeHandlingInstr = src[0];		
		hasTradeHandlingInstr = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeHandlingInstr(byte src) {		
		tradeHandlingInstr = src;
		hasTradeHandlingInstr = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeHandlingInstr(String str) {		
		if (str == null ) return;
		if (hasTradeHandlingInstr()) tradeHandlingInstr = (byte)' ';		
		byte[] src = str.getBytes(); 		
		tradeHandlingInstr = src[0];		
		hasTradeHandlingInstr = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTransferReason() {		
		getTransferReason();		
	}		
			
	public byte[] getTransferReason() { 		
		if ( hasTransferReason()) {		
			if (hasTransferReason == FixUtils.TAG_HAS_VALUE) {		
				return transferReason; 		
			} else {

				buf.position(hasTransferReason);

			FixUtils.getTagStringValue(buf, transferReason, 0, transferReason.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTransferReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return transferReason;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTransferReason() { return hasTransferReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTransferReason(byte[] src) {		
		if (src == null ) return;
		if (hasTransferReason()) FixUtils.fillNul(transferReason);		
		FixUtils.copy(transferReason, src); 		
		hasTransferReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTransferReason(String str) {		
		if (str == null ) return;
		if (hasTransferReason()) FixUtils.fillNul(transferReason);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transferReason, src); 		
		hasTransferReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryTrdType() {		
		getSecondaryTrdType();		
	}		
			
	public long getSecondaryTrdType() { 		
		if ( hasSecondaryTrdType()) {		
			if (hasSecondaryTrdType == FixUtils.TAG_HAS_VALUE) {		
				return secondaryTrdType; 		
			} else {

				buf.position(hasSecondaryTrdType);

			secondaryTrdType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSecondaryTrdType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryTrdType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecondaryTrdType() { return hasSecondaryTrdType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryTrdType(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryTrdType()) secondaryTrdType = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryTrdType = FixUtils.longValueOf(src, 0, src.length);
		hasSecondaryTrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryTrdType(long src) {		
		secondaryTrdType = src;
		hasSecondaryTrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryTrdType(String str) {		
		if (str == null ) return;
		if (hasSecondaryTrdType()) secondaryTrdType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		secondaryTrdType = FixUtils.longValueOf(src, 0, src.length);
		hasSecondaryTrdType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeLinkID() {		
		getTradeLinkID();		
	}		
			
	public byte[] getTradeLinkID() { 		
		if ( hasTradeLinkID()) {		
			if (hasTradeLinkID == FixUtils.TAG_HAS_VALUE) {		
				return tradeLinkID; 		
			} else {

				buf.position(hasTradeLinkID);

			FixUtils.getTagStringValue(buf, tradeLinkID, 0, tradeLinkID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeLinkID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeLinkID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeLinkID() { return hasTradeLinkID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeLinkID(byte[] src) {		
		if (src == null ) return;
		if (hasTradeLinkID()) FixUtils.fillNul(tradeLinkID);		
		FixUtils.copy(tradeLinkID, src); 		
		hasTradeLinkID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeLinkID(String str) {		
		if (str == null ) return;
		if (hasTradeLinkID()) FixUtils.fillNul(tradeLinkID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeLinkID, src); 		
		hasTradeLinkID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTrdMatchID() {		
		getTrdMatchID();		
	}		
			
	public byte[] getTrdMatchID() { 		
		if ( hasTrdMatchID()) {		
			if (hasTrdMatchID == FixUtils.TAG_HAS_VALUE) {		
				return trdMatchID; 		
			} else {

				buf.position(hasTrdMatchID);

			FixUtils.getTagStringValue(buf, trdMatchID, 0, trdMatchID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTrdMatchID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return trdMatchID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTrdMatchID() { return hasTrdMatchID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTrdMatchID(byte[] src) {		
		if (src == null ) return;
		if (hasTrdMatchID()) FixUtils.fillNul(trdMatchID);		
		FixUtils.copy(trdMatchID, src); 		
		hasTrdMatchID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdMatchID(String str) {		
		if (str == null ) return;
		if (hasTrdMatchID()) FixUtils.fillNul(trdMatchID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(trdMatchID, src); 		
		hasTrdMatchID = FixUtils.TAG_HAS_VALUE;		
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

			FixUtils.getTagStringValue(buf, clearingBusinessDate, 0, clearingBusinessDate.length, err);
		
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
			
	public void crackTradingSessionID() {		
		getTradingSessionID();		
	}		
			
	public byte[] getTradingSessionID() { 		
		if ( hasTradingSessionID()) {		
			if (hasTradingSessionID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionID; 		
			} else {

				buf.position(hasTradingSessionID);

			FixUtils.getTagStringValue(buf, tradingSessionID, 0, tradingSessionID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradingSessionID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionID() { return hasTradingSessionID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradingSessionID(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionID()) FixUtils.fillNul(tradingSessionID);		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradingSessionID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionID()) FixUtils.fillNul(tradingSessionID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradingSessionSubID() {		
		getTradingSessionSubID();		
	}		
			
	public byte[] getTradingSessionSubID() { 		
		if ( hasTradingSessionSubID()) {		
			if (hasTradingSessionSubID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionSubID; 		
			} else {

				buf.position(hasTradingSessionSubID);

			FixUtils.getTagStringValue(buf, tradingSessionSubID, 0, tradingSessionSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradingSessionSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionSubID() { return hasTradingSessionSubID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradingSessionSubID(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillNul(tradingSessionSubID);		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradingSessionSubID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillNul(tradingSessionSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTimeBracket() {		
		getTimeBracket();		
	}		
			
	public byte[] getTimeBracket() { 		
		if ( hasTimeBracket()) {		
			if (hasTimeBracket == FixUtils.TAG_HAS_VALUE) {		
				return timeBracket; 		
			} else {

				buf.position(hasTimeBracket);

			FixUtils.getTagStringValue(buf, timeBracket, 0, timeBracket.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTimeBracket = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return timeBracket;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTimeBracket() { return hasTimeBracket != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTimeBracket(byte[] src) {		
		if (src == null ) return;
		if (hasTimeBracket()) FixUtils.fillNul(timeBracket);		
		FixUtils.copy(timeBracket, src); 		
		hasTimeBracket = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeBracket(String str) {		
		if (str == null ) return;
		if (hasTimeBracket()) FixUtils.fillNul(timeBracket);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(timeBracket, src); 		
		hasTimeBracket = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSide() {		
		getSide();		
	}		
			
	public byte getSide() { 		
		if ( hasSide()) {		
			if (hasSide == FixUtils.TAG_HAS_VALUE) {		
				return side; 		
			} else {

				buf.position(hasSide);

			side = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (side != (byte)'D') && (side != (byte)'E') && (side != (byte)'F') && (side != (byte)'G') && (side != (byte)'A') && (side != (byte)'B') && (side != (byte)'C') && (side != (byte)'3') && (side != (byte)'2') && (side != (byte)'1') && (side != (byte)'7') && (side != (byte)'6') && (side != (byte)'5') && (side != (byte)'4') && (side != (byte)'9') && (side != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 54);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasSide = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return side;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSide() { return hasSide != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSide(byte[] src) {		
		if (src == null ) return;
		if (hasSide()) side = (byte)' ';		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(byte src) {		
		side = src;
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(String str) {		
		if (str == null ) return;
		if (hasSide()) side = (byte)' ';		
		byte[] src = str.getBytes(); 		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
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

			multiLegReportingType = FixUtils.getTagCharValue(buf, err);
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
			
	public void crackTradeInputSource() {		
		getTradeInputSource();		
	}		
			
	public byte[] getTradeInputSource() { 		
		if ( hasTradeInputSource()) {		
			if (hasTradeInputSource == FixUtils.TAG_HAS_VALUE) {		
				return tradeInputSource; 		
			} else {

				buf.position(hasTradeInputSource);

			FixUtils.getTagStringValue(buf, tradeInputSource, 0, tradeInputSource.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeInputSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeInputSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeInputSource() { return hasTradeInputSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeInputSource(byte[] src) {		
		if (src == null ) return;
		if (hasTradeInputSource()) FixUtils.fillNul(tradeInputSource);		
		FixUtils.copy(tradeInputSource, src); 		
		hasTradeInputSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeInputSource(String str) {		
		if (str == null ) return;
		if (hasTradeInputSource()) FixUtils.fillNul(tradeInputSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeInputSource, src); 		
		hasTradeInputSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeInputDevice() {		
		getTradeInputDevice();		
	}		
			
	public byte[] getTradeInputDevice() { 		
		if ( hasTradeInputDevice()) {		
			if (hasTradeInputDevice == FixUtils.TAG_HAS_VALUE) {		
				return tradeInputDevice; 		
			} else {

				buf.position(hasTradeInputDevice);

			FixUtils.getTagStringValue(buf, tradeInputDevice, 0, tradeInputDevice.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeInputDevice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeInputDevice;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeInputDevice() { return hasTradeInputDevice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeInputDevice(byte[] src) {		
		if (src == null ) return;
		if (hasTradeInputDevice()) FixUtils.fillNul(tradeInputDevice);		
		FixUtils.copy(tradeInputDevice, src); 		
		hasTradeInputDevice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeInputDevice(String str) {		
		if (str == null ) return;
		if (hasTradeInputDevice()) FixUtils.fillNul(tradeInputDevice);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeInputDevice, src); 		
		hasTradeInputDevice = FixUtils.TAG_HAS_VALUE;		
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

			responseTransportType = FixUtils.getTagIntValue(buf, err);
		
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

			FixUtils.getTagStringValue(buf, responseDestination, 0, responseDestination.length, err);
		
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
			
	public void crackMessageEventSource() {		
		getMessageEventSource();		
	}		
			
	public byte[] getMessageEventSource() { 		
		if ( hasMessageEventSource()) {		
			if (hasMessageEventSource == FixUtils.TAG_HAS_VALUE) {		
				return messageEventSource; 		
			} else {

				buf.position(hasMessageEventSource);

			FixUtils.getTagStringValue(buf, messageEventSource, 0, messageEventSource.length, err);
		
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
		if (hasTradeReportID()) s += "TradeReportID(571)= " + new String( FixUtils.trim(getTradeReportID()) ) + "\n" ; 
		if (hasSecondaryTradeReportID()) s += "SecondaryTradeReportID(818)= " + new String( FixUtils.trim(getSecondaryTradeReportID()) ) + "\n" ; 
		if (hasExecID()) s += "ExecID(17)= " + new String( FixUtils.trim(getExecID()) ) + "\n" ; 
		if (hasExecType()) s += "ExecType(150)= " + getExecType() + "\n" ; 
		if (hasOrderID()) s += "OrderID(37)= " + new String( FixUtils.trim(getOrderID()) ) + "\n" ; 
		if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasMatchStatus()) s += "MatchStatus(573)= " + getMatchStatus() + "\n" ; 
		if (hasTrdType()) s += "TrdType(828)= " + getTrdType() + "\n" ; 
		if (hasTrdSubType()) s += "TrdSubType(829)= " + getTrdSubType() + "\n" ; 
		if (hasTradeHandlingInstr()) s += "TradeHandlingInstr(1123)= " + getTradeHandlingInstr() + "\n" ; 
		if (hasTransferReason()) s += "TransferReason(830)= " + new String( FixUtils.trim(getTransferReason()) ) + "\n" ; 
		if (hasSecondaryTrdType()) s += "SecondaryTrdType(855)= " + getSecondaryTrdType() + "\n" ; 
		if (hasTradeLinkID()) s += "TradeLinkID(820)= " + new String( FixUtils.trim(getTradeLinkID()) ) + "\n" ; 
		if (hasTrdMatchID()) s += "TrdMatchID(880)= " + new String( FixUtils.trim(getTrdMatchID()) ) + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 
		if (hasTimeBracket()) s += "TimeBracket(943)= " + new String( FixUtils.trim(getTimeBracket()) ) + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasMultiLegReportingType()) s += "MultiLegReportingType(442)= " + getMultiLegReportingType() + "\n" ; 
		if (hasTradeInputSource()) s += "TradeInputSource(578)= " + new String( FixUtils.trim(getTradeInputSource()) ) + "\n" ; 
		if (hasTradeInputDevice()) s += "TradeInputDevice(579)= " + new String( FixUtils.trim(getTradeInputDevice()) ) + "\n" ; 
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
		if (! ( o instanceof FixTradeCaptureReportRequest)) return false;

		FixTradeCaptureReportRequest msg = (FixTradeCaptureReportRequest) o;

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
		if ((hasTradeReportID() && !msg.hasTradeReportID()) || (!hasTradeReportID() && msg.hasTradeReportID())) return false;
		if (!(!hasTradeReportID() && !msg.hasTradeReportID()) && !FixUtils.equals(getTradeReportID(), msg.getTradeReportID())) return false;
		if ((hasSecondaryTradeReportID() && !msg.hasSecondaryTradeReportID()) || (!hasSecondaryTradeReportID() && msg.hasSecondaryTradeReportID())) return false;
		if (!(!hasSecondaryTradeReportID() && !msg.hasSecondaryTradeReportID()) && !FixUtils.equals(getSecondaryTradeReportID(), msg.getSecondaryTradeReportID())) return false;
		if ((hasExecID() && !msg.hasExecID()) || (!hasExecID() && msg.hasExecID())) return false;
		if (!(!hasExecID() && !msg.hasExecID()) && !FixUtils.equals(getExecID(), msg.getExecID())) return false;
		if ((hasExecType() && !msg.hasExecType()) || (!hasExecType() && msg.hasExecType())) return false;
		if (!(!hasExecType() && !msg.hasExecType()) && !(getExecType()==msg.getExecType())) return false;
		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasMatchStatus() && !msg.hasMatchStatus()) || (!hasMatchStatus() && msg.hasMatchStatus())) return false;
		if (!(!hasMatchStatus() && !msg.hasMatchStatus()) && !(getMatchStatus()==msg.getMatchStatus())) return false;
		if ((hasTrdType() && !msg.hasTrdType()) || (!hasTrdType() && msg.hasTrdType())) return false;
		if (!(!hasTrdType() && !msg.hasTrdType()) && !(getTrdType()==msg.getTrdType())) return false;
		if ((hasTrdSubType() && !msg.hasTrdSubType()) || (!hasTrdSubType() && msg.hasTrdSubType())) return false;
		if (!(!hasTrdSubType() && !msg.hasTrdSubType()) && !(getTrdSubType()==msg.getTrdSubType())) return false;
		if ((hasTradeHandlingInstr() && !msg.hasTradeHandlingInstr()) || (!hasTradeHandlingInstr() && msg.hasTradeHandlingInstr())) return false;
		if (!(!hasTradeHandlingInstr() && !msg.hasTradeHandlingInstr()) && !(getTradeHandlingInstr()==msg.getTradeHandlingInstr())) return false;
		if ((hasTransferReason() && !msg.hasTransferReason()) || (!hasTransferReason() && msg.hasTransferReason())) return false;
		if (!(!hasTransferReason() && !msg.hasTransferReason()) && !FixUtils.equals(getTransferReason(), msg.getTransferReason())) return false;
		if ((hasSecondaryTrdType() && !msg.hasSecondaryTrdType()) || (!hasSecondaryTrdType() && msg.hasSecondaryTrdType())) return false;
		if (!(!hasSecondaryTrdType() && !msg.hasSecondaryTrdType()) && !(getSecondaryTrdType()==msg.getSecondaryTrdType())) return false;
		if ((hasTradeLinkID() && !msg.hasTradeLinkID()) || (!hasTradeLinkID() && msg.hasTradeLinkID())) return false;
		if (!(!hasTradeLinkID() && !msg.hasTradeLinkID()) && !FixUtils.equals(getTradeLinkID(), msg.getTradeLinkID())) return false;
		if ((hasTrdMatchID() && !msg.hasTrdMatchID()) || (!hasTrdMatchID() && msg.hasTrdMatchID())) return false;
		if (!(!hasTrdMatchID() && !msg.hasTrdMatchID()) && !FixUtils.equals(getTrdMatchID(), msg.getTrdMatchID())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		if ((hasTimeBracket() && !msg.hasTimeBracket()) || (!hasTimeBracket() && msg.hasTimeBracket())) return false;
		if (!(!hasTimeBracket() && !msg.hasTimeBracket()) && !FixUtils.equals(getTimeBracket(), msg.getTimeBracket())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasMultiLegReportingType() && !msg.hasMultiLegReportingType()) || (!hasMultiLegReportingType() && msg.hasMultiLegReportingType())) return false;
		if (!(!hasMultiLegReportingType() && !msg.hasMultiLegReportingType()) && !(getMultiLegReportingType()==msg.getMultiLegReportingType())) return false;
		if ((hasTradeInputSource() && !msg.hasTradeInputSource()) || (!hasTradeInputSource() && msg.hasTradeInputSource())) return false;
		if (!(!hasTradeInputSource() && !msg.hasTradeInputSource()) && !FixUtils.equals(getTradeInputSource(), msg.getTradeInputSource())) return false;
		if ((hasTradeInputDevice() && !msg.hasTradeInputDevice()) || (!hasTradeInputDevice() && msg.hasTradeInputDevice())) return false;
		if (!(!hasTradeInputDevice() && !msg.hasTradeInputDevice()) && !FixUtils.equals(getTradeInputDevice(), msg.getTradeInputDevice())) return false;
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
	public FixTradeCaptureReportRequest clone () {
		FixTradeCaptureReportRequest out = new FixTradeCaptureReportRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixTradeCaptureReportRequest clone ( FixTradeCaptureReportRequest out ) {
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
		if ( hasTradeReportID())
			out.setTradeReportID(getTradeReportID());
		if ( hasSecondaryTradeReportID())
			out.setSecondaryTradeReportID(getSecondaryTradeReportID());
		if ( hasExecID())
			out.setExecID(getExecID());
		if ( hasExecType())
			out.setExecType(getExecType());
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasMatchStatus())
			out.setMatchStatus(getMatchStatus());
		if ( hasTrdType())
			out.setTrdType(getTrdType());
		if ( hasTrdSubType())
			out.setTrdSubType(getTrdSubType());
		if ( hasTradeHandlingInstr())
			out.setTradeHandlingInstr(getTradeHandlingInstr());
		if ( hasTransferReason())
			out.setTransferReason(getTransferReason());
		if ( hasSecondaryTrdType())
			out.setSecondaryTrdType(getSecondaryTrdType());
		if ( hasTradeLinkID())
			out.setTradeLinkID(getTradeLinkID());
		if ( hasTrdMatchID())
			out.setTrdMatchID(getTrdMatchID());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		if ( hasTimeBracket())
			out.setTimeBracket(getTimeBracket());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasMultiLegReportingType())
			out.setMultiLegReportingType(getMultiLegReportingType());
		if ( hasTradeInputSource())
			out.setTradeInputSource(getTradeInputSource());
		if ( hasTradeInputDevice())
			out.setTradeInputDevice(getTradeInputDevice());
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
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		if (instrumentExtension.hasGroup())
			out.instrumentExtension = instrumentExtension.clone( out.instrumentExtension);
		if (financingDetails.hasGroup())
			out.financingDetails = financingDetails.clone( out.financingDetails);
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
		count = 0;
		for (FixTrdCapDtGrp fixTrdCapDtGrp : trdCapDtGrp) {
			if (!fixTrdCapDtGrp.hasGroup()) continue;
			out.trdCapDtGrp[count] = fixTrdCapDtGrp.clone( out.trdCapDtGrp[count] );
			count++;
		}
		return out;
	}

}
