package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixTradeCaptureReportAck extends FixInMessage {
	private short hasTradeReportID;
	byte[] tradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeID;
	byte[] tradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryTradeID;
	byte[] secondaryTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasFirmTradeID;
	byte[] firmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryFirmTradeID;
	byte[] secondaryFirmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeReportTransType;
	long tradeReportTransType = 0;		
	private short hasTradeReportType;
	long tradeReportType = 0;		
	private short hasTrdType;
	long trdType = 0;		
	private short hasTrdSubType;
	long trdSubType = 0;		
	private short hasSecondaryTrdType;
	long secondaryTrdType = 0;		
	private short hasTradeHandlingInstr;
	byte tradeHandlingInstr = (byte)' ';		
	private short hasOrigTradeHandlingInstr;
	byte origTradeHandlingInstr = (byte)' ';		
	private short hasOrigTradeDate;
	byte[] origTradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrigTradeID;
	byte[] origTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrigSecondaryTradeID;
	byte[] origSecondaryTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTransferReason;
	byte[] transferReason = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExecType;
	byte execType = (byte)' ';		
	private short hasTradeReportRefID;
	byte[] tradeReportRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryTradeReportRefID;
	byte[] secondaryTradeReportRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTrdRptStatus;
	long trdRptStatus = 0;		
	private short hasTradeReportRejectReason;
	long tradeReportRejectReason = 0;		
	private short hasSecondaryTradeReportID;
	byte[] secondaryTradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSubscriptionRequestType;
	byte subscriptionRequestType = (byte)' ';		
	private short hasTradeLinkID;
	byte[] tradeLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTrdMatchID;
	byte[] trdMatchID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExecID;
	byte[] execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryExecID;
	byte[] secondaryExecID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExecRestatementReason;
	long execRestatementReason = 0;		
	private short hasPreviouslyReported;
		boolean previouslyReported = false;		
	private short hasPriceType;
	long priceType = 0;		
	private short hasUnderlyingTradingSessionID;
	byte[] underlyingTradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQtyType;
	long qtyType = 0;		
	private short hasUnderlyingTradingSessionSubID;
	byte[] underlyingTradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLastQty;
	long lastQty = 0;		
	private short hasLastPx;
	long lastPx = 0;		
	private short hasSettlSessID;
	byte[] settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlSessSubID;
	byte[] settlSessSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasVenueType;
	byte venueType = (byte)' ';		
	private short hasMarketSegmentID;
	byte[] marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketID;
	byte[] marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLastParPx;
	long lastParPx = 0;		
	private short hasLastSpotRate;
	long lastSpotRate = 0;		
	private short hasLastForwardPoints;
	long lastForwardPoints = 0;		
	private short hasLastMkt;
	byte[] lastMkt = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeDate;
	byte[] tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAvgPx;
	long avgPx = 0;		
	private short hasAvgPxIndicator;
	long avgPxIndicator = 0;		
	private short hasMultiLegReportingType;
	byte multiLegReportingType = (byte)' ';		
	private short hasTradeLegRefID;
	byte[] tradeLegRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCalculatedCcyLastQty;
	long calculatedCcyLastQty = 0;		
	private short hasLastSwapPoints;
	long lastSwapPoints = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasSettlCurrency;
	byte[] settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasSettlType;
	byte[] settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMatchStatus;
	byte matchStatus = (byte)' ';		
	private short hasMatchType;
	byte[] matchType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCopyMsgIndicator;
		boolean copyMsgIndicator = false;		
	private short hasPublishTrdIndicator;
		boolean publishTrdIndicator = false;		
	private short hasShortSaleReason;
	long shortSaleReason = 0;		
	private short hasTradePublishIndicator;
	long tradePublishIndicator = 0;		
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
	private short hasAsOfIndicator;
	byte asOfIndicator = (byte)' ';		
	private short hasClearingFeeIndicator;
	byte[] clearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTierCode;
	byte[] tierCode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMessageEventSource;
	byte[] messageEventSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLastUpdateTime;
	byte[] lastUpdateTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasRndPx;
	long rndPx = 0;		
	private short hasSettlDate;
	byte[] settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasGrossTradeAmt;
	long grossTradeAmt = 0;		
	private short hasRptSys;
	byte[] rptSys = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasFeeMultiplier;
	long feeMultiplier = 0;		
	public FixRootParties[] rootParties;
	public FixInstrument instrument;
	public FixTrdInstrmtLegGrp[] trdInstrmtLegGrp;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixTrdRepIndicatorsGrp[] trdRepIndicatorsGrp;
	public FixTrdRegTimestamps[] trdRegTimestamps;
	public FixPositionAmountData[] positionAmountData;
	public FixTrdCapRptAckSideGrp[] trdCapRptAckSideGrp;
	
	public FixTradeCaptureReportAck() {
		super(FixMessageInfo.MessageTypes.TRADECAPTUREREPORTACK);


		hasTradeReportID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasFirmTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		firmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryFirmTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryFirmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeReportTransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeReportType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTrdSubType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecondaryTrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeHandlingInstr = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrigTradeHandlingInstr = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrigTradeDate = FixUtils.TAG_HAS_NO_VALUE;		
		origTradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrigTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		origTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrigSecondaryTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		origSecondaryTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTransferReason = FixUtils.TAG_HAS_NO_VALUE;		
		transferReason = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExecType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeReportRefID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeReportRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryTradeReportRefID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryTradeReportRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTrdRptStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeReportRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecondaryTradeReportID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryTradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeLinkID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTrdMatchID = FixUtils.TAG_HAS_NO_VALUE;		
		trdMatchID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExecID = FixUtils.TAG_HAS_NO_VALUE;		
		execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryExecID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryExecID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExecRestatementReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasPreviouslyReported = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingTradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQtyType = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingTradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlSessID = FixUtils.TAG_HAS_NO_VALUE;		
		settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlSessSubID = FixUtils.TAG_HAS_NO_VALUE;		
		settlSessSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasVenueType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMarketSegmentID = FixUtils.TAG_HAS_NO_VALUE;		
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketID = FixUtils.TAG_HAS_NO_VALUE;		
		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLastParPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastMkt = FixUtils.TAG_HAS_NO_VALUE;		
		lastMkt = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasAvgPxIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasMultiLegReportingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeLegRefID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeLegRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCalculatedCcyLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastSwapPoints = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMatchStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasMatchType = FixUtils.TAG_HAS_NO_VALUE;		
		matchType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCopyMsgIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasPublishTrdIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasShortSaleReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradePublishIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasResponseTransportType = FixUtils.TAG_HAS_NO_VALUE;		
		hasResponseDestination = FixUtils.TAG_HAS_NO_VALUE;		
		responseDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasAsOfIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasClearingFeeIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		clearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTierCode = FixUtils.TAG_HAS_NO_VALUE;		
		tierCode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMessageEventSource = FixUtils.TAG_HAS_NO_VALUE;		
		messageEventSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLastUpdateTime = FixUtils.TAG_HAS_NO_VALUE;		
		lastUpdateTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasRndPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasGrossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasRptSys = FixUtils.TAG_HAS_NO_VALUE;		
		rptSys = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasFeeMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		rootParties = new FixRootParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rootParties[i] = new FixRootParties();
		instrument = new FixInstrument();
		trdInstrmtLegGrp = new FixTrdInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdInstrmtLegGrp[i] = new FixTrdInstrmtLegGrp();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		trdRepIndicatorsGrp = new FixTrdRepIndicatorsGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdRepIndicatorsGrp[i] = new FixTrdRepIndicatorsGrp();
		trdRegTimestamps = new FixTrdRegTimestamps[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdRegTimestamps[i] = new FixTrdRegTimestamps();
		positionAmountData = new FixPositionAmountData[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) positionAmountData[i] = new FixPositionAmountData();
		trdCapRptAckSideGrp = new FixTrdCapRptAckSideGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdCapRptAckSideGrp[i] = new FixTrdCapRptAckSideGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.TRADEREPORTID_INT:		
            		hasTradeReportID = (short) buf.position();		
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
            	case FixTags.TRADEREPORTTRANSTYPE_INT:		
            		hasTradeReportTransType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREPORTTYPE_INT:		
            		hasTradeReportType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRDTYPE_INT:		
            		hasTrdType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRDSUBTYPE_INT:		
            		hasTrdSubType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYTRDTYPE_INT:		
            		hasSecondaryTrdType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEHANDLINGINSTR_INT:		
            		hasTradeHandlingInstr = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORIGTRADEHANDLINGINSTR_INT:		
            		hasOrigTradeHandlingInstr = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORIGTRADEDATE_INT:		
            		hasOrigTradeDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORIGTRADEID_INT:		
            		hasOrigTradeID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORIGSECONDARYTRADEID_INT:		
            		hasOrigSecondaryTradeID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSFERREASON_INT:		
            		hasTransferReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECTYPE_INT:		
            		hasExecType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREPORTREFID_INT:		
            		hasTradeReportRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYTRADEREPORTREFID_INT:		
            		hasSecondaryTradeReportRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRDRPTSTATUS_INT:		
            		hasTrdRptStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREPORTREJECTREASON_INT:		
            		hasTradeReportRejectReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYTRADEREPORTID_INT:		
            		hasSecondaryTradeReportID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SUBSCRIPTIONREQUESTTYPE_INT:		
            		hasSubscriptionRequestType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADELINKID_INT:		
            		hasTradeLinkID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRDMATCHID_INT:		
            		hasTrdMatchID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECID_INT:		
            		hasExecID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYEXECID_INT:		
            		hasSecondaryExecID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECRESTATEMENTREASON_INT:		
            		hasExecRestatementReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PREVIOUSLYREPORTED_INT:		
            		hasPreviouslyReported = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRICETYPE_INT:		
            		hasPriceType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.UNDERLYINGTRADINGSESSIONID_INT:		
            		hasUnderlyingTradingSessionID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QTYTYPE_INT:		
            		hasQtyType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.UNDERLYINGTRADINGSESSIONSUBID_INT:		
            		hasUnderlyingTradingSessionSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTQTY_INT:		
            		hasLastQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTPX_INT:		
            		hasLastPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLSESSID_INT:		
            		hasSettlSessID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLSESSSUBID_INT:		
            		hasSettlSessSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.VENUETYPE_INT:		
            		hasVenueType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MARKETSEGMENTID_INT:		
            		hasMarketSegmentID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MARKETID_INT:		
            		hasMarketID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTPARPX_INT:		
            		hasLastParPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTSPOTRATE_INT:		
            		hasLastSpotRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTFORWARDPOINTS_INT:		
            		hasLastForwardPoints = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTMKT_INT:		
            		hasLastMkt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEDATE_INT:		
            		hasTradeDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AVGPX_INT:		
            		hasAvgPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AVGPXINDICATOR_INT:		
            		hasAvgPxIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MULTILEGREPORTINGTYPE_INT:		
            		hasMultiLegReportingType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADELEGREFID_INT:		
            		hasTradeLegRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CALCULATEDCCYLASTQTY_INT:		
            		hasCalculatedCcyLastQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTSWAPPOINTS_INT:		
            		hasLastSwapPoints = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLCURRENCY_INT:		
            		hasSettlCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLTYPE_INT:		
            		hasSettlType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MATCHSTATUS_INT:		
            		hasMatchStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MATCHTYPE_INT:		
            		hasMatchType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COPYMSGINDICATOR_INT:		
            		hasCopyMsgIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PUBLISHTRDINDICATOR_INT:		
            		hasPublishTrdIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SHORTSALEREASON_INT:		
            		hasShortSaleReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEPUBLISHINDICATOR_INT:		
            		hasTradePublishIndicator = (short) buf.position();		
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
            	case FixTags.ASOFINDICATOR_INT:		
            		hasAsOfIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGFEEINDICATOR_INT:		
            		hasClearingFeeIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TIERCODE_INT:		
            		hasTierCode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MESSAGEEVENTSOURCE_INT:		
            		hasMessageEventSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTUPDATETIME_INT:		
            		hasLastUpdateTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RNDPX_INT:		
            		hasRndPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLDATE_INT:		
            		hasSettlDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.GROSSTRADEAMT_INT:		
            		hasGrossTradeAmt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RPTSYS_INT:		
            		hasRptSys = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.FEEMULTIPLIER_INT:		
            		hasFeeMultiplier = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOROOTPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !rootParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = rootParties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOLEGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdInstrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdInstrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
        			} else if ( tag == FixTags.NOTRDREPINDICATORS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdRepIndicatorsGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdRepIndicatorsGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOTRDREGTIMESTAMPS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdRegTimestamps[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdRegTimestamps[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOPOSAMT_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !positionAmountData[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = positionAmountData[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOSIDES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdCapRptAckSideGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdCapRptAckSideGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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

		if (instrument.isRequired) instrument.hasRequiredTags(err); if (err.hasError()) return false;
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
		if (hasTradeReportID()) {		
			out.put(FixTags.TRADEREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeReportID); 		
		
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
		if (hasTradeReportTransType()) {		
			out.put(FixTags.TRADEREPORTTRANSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)tradeReportTransType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeReportType()) {		
			out.put(FixTags.TRADEREPORTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)tradeReportType);
		
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
		if (hasSecondaryTrdType()) {		
			out.put(FixTags.SECONDARYTRDTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)secondaryTrdType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeHandlingInstr()) {		
			out.put(FixTags.TRADEHANDLINGINSTR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeHandlingInstr); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrigTradeHandlingInstr()) {		
			out.put(FixTags.ORIGTRADEHANDLINGINSTR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,origTradeHandlingInstr); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrigTradeDate()) {		
			out.put(FixTags.ORIGTRADEDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,origTradeDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrigTradeID()) {		
			out.put(FixTags.ORIGTRADEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,origTradeID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrigSecondaryTradeID()) {		
			out.put(FixTags.ORIGSECONDARYTRADEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,origSecondaryTradeID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransferReason()) {		
			out.put(FixTags.TRANSFERREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transferReason); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecType()) {		
			out.put(FixTags.EXECTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeReportRefID()) {		
			out.put(FixTags.TRADEREPORTREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeReportRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryTradeReportRefID()) {		
			out.put(FixTags.SECONDARYTRADEREPORTREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryTradeReportRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTrdRptStatus()) {		
			out.put(FixTags.TRDRPTSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)trdRptStatus);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeReportRejectReason()) {		
			out.put(FixTags.TRADEREPORTREJECTREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)tradeReportRejectReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryTradeReportID()) {		
			out.put(FixTags.SECONDARYTRADEREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryTradeReportID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSubscriptionRequestType()) {		
			out.put(FixTags.SUBSCRIPTIONREQUESTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,subscriptionRequestType); 		
		
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
		if (hasExecID()) {		
			out.put(FixTags.EXECID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryExecID()) {		
			out.put(FixTags.SECONDARYEXECID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryExecID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecRestatementReason()) {		
			out.put(FixTags.EXECRESTATEMENTREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)execRestatementReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPreviouslyReported()) {		
			out.put(FixTags.PREVIOUSLYREPORTED);		
		
			out.put((byte) '=');		
		
			out.put(previouslyReported?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriceType()) {		
			out.put(FixTags.PRICETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priceType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUnderlyingTradingSessionID()) {		
			out.put(FixTags.UNDERLYINGTRADINGSESSIONID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,underlyingTradingSessionID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQtyType()) {		
			out.put(FixTags.QTYTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)qtyType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUnderlyingTradingSessionSubID()) {		
			out.put(FixTags.UNDERLYINGTRADINGSESSIONSUBID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,underlyingTradingSessionSubID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastQty()) {		
			out.put(FixTags.LASTQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lastQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastPx()) {		
			out.put(FixTags.LASTPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lastPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlSessID()) {		
			out.put(FixTags.SETTLSESSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlSessID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlSessSubID()) {		
			out.put(FixTags.SETTLSESSSUBID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlSessSubID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasVenueType()) {		
			out.put(FixTags.VENUETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,venueType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarketSegmentID()) {		
			out.put(FixTags.MARKETSEGMENTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,marketSegmentID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarketID()) {		
			out.put(FixTags.MARKETID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,marketID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastParPx()) {		
			out.put(FixTags.LASTPARPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lastParPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastSpotRate()) {		
			out.put(FixTags.LASTSPOTRATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lastSpotRate);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastForwardPoints()) {		
			out.put(FixTags.LASTFORWARDPOINTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lastForwardPoints);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastMkt()) {		
			out.put(FixTags.LASTMKT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,lastMkt); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeDate()) {		
			out.put(FixTags.TRADEDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAvgPx()) {		
			out.put(FixTags.AVGPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)avgPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAvgPxIndicator()) {		
			out.put(FixTags.AVGPXINDICATOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)avgPxIndicator);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMultiLegReportingType()) {		
			out.put(FixTags.MULTILEGREPORTINGTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,multiLegReportingType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeLegRefID()) {		
			out.put(FixTags.TRADELEGREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeLegRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCalculatedCcyLastQty()) {		
			out.put(FixTags.CALCULATEDCCYLASTQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)calculatedCcyLastQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastSwapPoints()) {		
			out.put(FixTags.LASTSWAPPOINTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lastSwapPoints);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlCurrency()) {		
			out.put(FixTags.SETTLCURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlCurrency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlType()) {		
			out.put(FixTags.SETTLTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMatchStatus()) {		
			out.put(FixTags.MATCHSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,matchStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMatchType()) {		
			out.put(FixTags.MATCHTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,matchType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCopyMsgIndicator()) {		
			out.put(FixTags.COPYMSGINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(copyMsgIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPublishTrdIndicator()) {		
			out.put(FixTags.PUBLISHTRDINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(publishTrdIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasShortSaleReason()) {		
			out.put(FixTags.SHORTSALEREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)shortSaleReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradePublishIndicator()) {		
			out.put(FixTags.TRADEPUBLISHINDICATOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)tradePublishIndicator);
		
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
		if (hasAsOfIndicator()) {		
			out.put(FixTags.ASOFINDICATOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,asOfIndicator); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingFeeIndicator()) {		
			out.put(FixTags.CLEARINGFEEINDICATOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingFeeIndicator); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTierCode()) {		
			out.put(FixTags.TIERCODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tierCode); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMessageEventSource()) {		
			out.put(FixTags.MESSAGEEVENTSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,messageEventSource); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastUpdateTime()) {		
			out.put(FixTags.LASTUPDATETIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,lastUpdateTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRndPx()) {		
			out.put(FixTags.RNDPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)rndPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlDate()) {		
			out.put(FixTags.SETTLDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasGrossTradeAmt()) {		
			out.put(FixTags.GROSSTRADEAMT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)grossTradeAmt);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRptSys()) {		
			out.put(FixTags.RPTSYS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,rptSys); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasFeeMultiplier()) {		
			out.put(FixTags.FEEMULTIPLIER);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)feeMultiplier);
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(rootParties)>0) {
			out.put(FixTags.NOROOTPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(rootParties));

			out.put(FixUtils.SOH);

		}
		for (FixRootParties fixRootParties : rootParties) if (fixRootParties.hasGroup()) fixRootParties.encode(out);
		instrument.encode(out);
		if (FixUtils.getNoInGroup(trdInstrmtLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdInstrmtLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTrdInstrmtLegGrp fixTrdInstrmtLegGrp : trdInstrmtLegGrp) if (fixTrdInstrmtLegGrp.hasGroup()) fixTrdInstrmtLegGrp.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(trdRepIndicatorsGrp)>0) {
			out.put(FixTags.NOTRDREPINDICATORS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdRepIndicatorsGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTrdRepIndicatorsGrp fixTrdRepIndicatorsGrp : trdRepIndicatorsGrp) if (fixTrdRepIndicatorsGrp.hasGroup()) fixTrdRepIndicatorsGrp.encode(out);
		if (FixUtils.getNoInGroup(trdRegTimestamps)>0) {
			out.put(FixTags.NOTRDREGTIMESTAMPS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdRegTimestamps));

			out.put(FixUtils.SOH);

		}
		for (FixTrdRegTimestamps fixTrdRegTimestamps : trdRegTimestamps) if (fixTrdRegTimestamps.hasGroup()) fixTrdRegTimestamps.encode(out);
		if (FixUtils.getNoInGroup(positionAmountData)>0) {
			out.put(FixTags.NOPOSAMT);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(positionAmountData));

			out.put(FixUtils.SOH);

		}
		for (FixPositionAmountData fixPositionAmountData : positionAmountData) if (fixPositionAmountData.hasGroup()) fixPositionAmountData.encode(out);
		if (FixUtils.getNoInGroup(trdCapRptAckSideGrp)>0) {
			out.put(FixTags.NOSIDES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdCapRptAckSideGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTrdCapRptAckSideGrp fixTrdCapRptAckSideGrp : trdCapRptAckSideGrp) if (fixTrdCapRptAckSideGrp.hasGroup()) fixTrdCapRptAckSideGrp.encode(out);
		
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
		
		if (hasTradeReportID()) {		
			FixUtils.put(out,tradeReportID); 		
		
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
		
		if (hasTradeReportTransType()) {		
			FixUtils.put(out, (long)tradeReportTransType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeReportType()) {		
			FixUtils.put(out, (long)tradeReportType);
		
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
		
		if (hasSecondaryTrdType()) {		
			FixUtils.put(out, (long)secondaryTrdType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeHandlingInstr()) {		
			FixUtils.put(out,tradeHandlingInstr); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigTradeHandlingInstr()) {		
			FixUtils.put(out,origTradeHandlingInstr); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigTradeDate()) {		
			FixUtils.put(out,origTradeDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigTradeID()) {		
			FixUtils.put(out,origTradeID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigSecondaryTradeID()) {		
			FixUtils.put(out,origSecondaryTradeID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransferReason()) {		
			FixUtils.put(out,transferReason); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecType()) {		
			FixUtils.put(out,execType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeReportRefID()) {		
			FixUtils.put(out,tradeReportRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryTradeReportRefID()) {		
			FixUtils.put(out,secondaryTradeReportRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTrdRptStatus()) {		
			FixUtils.put(out, (long)trdRptStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeReportRejectReason()) {		
			FixUtils.put(out, (long)tradeReportRejectReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryTradeReportID()) {		
			FixUtils.put(out,secondaryTradeReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSubscriptionRequestType()) {		
			FixUtils.put(out,subscriptionRequestType); 		
		
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
		
		if (hasExecID()) {		
			FixUtils.put(out,execID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryExecID()) {		
			FixUtils.put(out,secondaryExecID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecRestatementReason()) {		
			FixUtils.put(out, (long)execRestatementReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPreviouslyReported()) {		
			out.put(previouslyReported?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceType()) {		
			FixUtils.put(out, (long)priceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingTradingSessionID()) {		
			FixUtils.put(out,underlyingTradingSessionID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQtyType()) {		
			FixUtils.put(out, (long)qtyType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingTradingSessionSubID()) {		
			FixUtils.put(out,underlyingTradingSessionSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastQty()) {		
			FixUtils.put(out, (long)lastQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastPx()) {		
			FixUtils.put(out, (long)lastPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlSessID()) {		
			FixUtils.put(out,settlSessID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlSessSubID()) {		
			FixUtils.put(out,settlSessSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasVenueType()) {		
			FixUtils.put(out,venueType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketSegmentID()) {		
			FixUtils.put(out,marketSegmentID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketID()) {		
			FixUtils.put(out,marketID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastParPx()) {		
			FixUtils.put(out, (long)lastParPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastSpotRate()) {		
			FixUtils.put(out, (long)lastSpotRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastForwardPoints()) {		
			FixUtils.put(out, (long)lastForwardPoints);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastMkt()) {		
			FixUtils.put(out,lastMkt); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeDate()) {		
			FixUtils.put(out,tradeDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAvgPx()) {		
			FixUtils.put(out, (long)avgPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAvgPxIndicator()) {		
			FixUtils.put(out, (long)avgPxIndicator);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMultiLegReportingType()) {		
			FixUtils.put(out,multiLegReportingType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeLegRefID()) {		
			FixUtils.put(out,tradeLegRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCalculatedCcyLastQty()) {		
			FixUtils.put(out, (long)calculatedCcyLastQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastSwapPoints()) {		
			FixUtils.put(out, (long)lastSwapPoints);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrency()) {		
			FixUtils.put(out,settlCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlType()) {		
			FixUtils.put(out,settlType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMatchStatus()) {		
			FixUtils.put(out,matchStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMatchType()) {		
			FixUtils.put(out,matchType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCopyMsgIndicator()) {		
			out.put(copyMsgIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPublishTrdIndicator()) {		
			out.put(publishTrdIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasShortSaleReason()) {		
			FixUtils.put(out, (long)shortSaleReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradePublishIndicator()) {		
			FixUtils.put(out, (long)tradePublishIndicator);
		
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
		
		if (hasAsOfIndicator()) {		
			FixUtils.put(out,asOfIndicator); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingFeeIndicator()) {		
			FixUtils.put(out,clearingFeeIndicator); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTierCode()) {		
			FixUtils.put(out,tierCode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMessageEventSource()) {		
			FixUtils.put(out,messageEventSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastUpdateTime()) {		
			FixUtils.put(out,lastUpdateTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRndPx()) {		
			FixUtils.put(out, (long)rndPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlDate()) {		
			FixUtils.put(out,settlDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasGrossTradeAmt()) {		
			FixUtils.put(out, (long)grossTradeAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRptSys()) {		
			FixUtils.put(out,rptSys); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFeeMultiplier()) {		
			FixUtils.put(out, (long)feeMultiplier);
		
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
			
	public void crackTradeReportID() {		
		getTradeReportID();		
	}		
			
	public byte[] getTradeReportID() { 		
		if ( hasTradeReportID()) {		
			if (hasTradeReportID == FixUtils.TAG_HAS_VALUE) {		
				return tradeReportID; 		
			} else {

				buf.position(hasTradeReportID);

			FixMessage.getTagStringValue(buf, tradeReportID, 0, tradeReportID.length, err);
		
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
		if (hasTradeReportID()) FixUtils.fillSpace(tradeReportID);		
		FixUtils.copy(tradeReportID, src); 		
		hasTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeReportID(String str) {		
		if (str == null ) return;
		if (hasTradeReportID()) FixUtils.fillSpace(tradeReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeReportID, src); 		
		hasTradeReportID = FixUtils.TAG_HAS_VALUE;		
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
		if (hasTradeID()) FixUtils.fillSpace(tradeID);		
		FixUtils.copy(tradeID, src); 		
		hasTradeID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeID(String str) {		
		if (str == null ) return;
		if (hasTradeID()) FixUtils.fillSpace(tradeID);		
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
		if (hasSecondaryTradeID()) FixUtils.fillSpace(secondaryTradeID);		
		FixUtils.copy(secondaryTradeID, src); 		
		hasSecondaryTradeID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryTradeID(String str) {		
		if (str == null ) return;
		if (hasSecondaryTradeID()) FixUtils.fillSpace(secondaryTradeID);		
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
		if (hasFirmTradeID()) FixUtils.fillSpace(firmTradeID);		
		FixUtils.copy(firmTradeID, src); 		
		hasFirmTradeID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFirmTradeID(String str) {		
		if (str == null ) return;
		if (hasFirmTradeID()) FixUtils.fillSpace(firmTradeID);		
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
		if (hasSecondaryFirmTradeID()) FixUtils.fillSpace(secondaryFirmTradeID);		
		FixUtils.copy(secondaryFirmTradeID, src); 		
		hasSecondaryFirmTradeID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryFirmTradeID(String str) {		
		if (str == null ) return;
		if (hasSecondaryFirmTradeID()) FixUtils.fillSpace(secondaryFirmTradeID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryFirmTradeID, src); 		
		hasSecondaryFirmTradeID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeReportTransType() {		
		getTradeReportTransType();		
	}		
			
	public long getTradeReportTransType() { 		
		if ( hasTradeReportTransType()) {		
			if (hasTradeReportTransType == FixUtils.TAG_HAS_VALUE) {		
				return tradeReportTransType; 		
			} else {

				buf.position(hasTradeReportTransType);

			tradeReportTransType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTradeReportTransType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeReportTransType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradeReportTransType() { return hasTradeReportTransType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeReportTransType(byte[] src) {		
		if (src == null ) return;
		if (hasTradeReportTransType()) tradeReportTransType = FixUtils.TAG_HAS_NO_VALUE;		
		tradeReportTransType = FixUtils.longValueOf(src, 0, src.length);
		hasTradeReportTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeReportTransType(long src) {		
		tradeReportTransType = src;
		hasTradeReportTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeReportTransType(String str) {		
		if (str == null ) return;
		if (hasTradeReportTransType()) tradeReportTransType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradeReportTransType = FixUtils.longValueOf(src, 0, src.length);
		hasTradeReportTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeReportType() {		
		getTradeReportType();		
	}		
			
	public long getTradeReportType() { 		
		if ( hasTradeReportType()) {		
			if (hasTradeReportType == FixUtils.TAG_HAS_VALUE) {		
				return tradeReportType; 		
			} else {

				buf.position(hasTradeReportType);

			tradeReportType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTradeReportType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeReportType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradeReportType() { return hasTradeReportType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeReportType(byte[] src) {		
		if (src == null ) return;
		if (hasTradeReportType()) tradeReportType = FixUtils.TAG_HAS_NO_VALUE;		
		tradeReportType = FixUtils.longValueOf(src, 0, src.length);
		hasTradeReportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeReportType(long src) {		
		tradeReportType = src;
		hasTradeReportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeReportType(String str) {		
		if (str == null ) return;
		if (hasTradeReportType()) tradeReportType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradeReportType = FixUtils.longValueOf(src, 0, src.length);
		hasTradeReportType = FixUtils.TAG_HAS_VALUE;		
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

			trdType = FixMessage.getTagIntValue(buf, err);
		
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

			trdSubType = FixMessage.getTagIntValue(buf, err);
		
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
			
	public void crackSecondaryTrdType() {		
		getSecondaryTrdType();		
	}		
			
	public long getSecondaryTrdType() { 		
		if ( hasSecondaryTrdType()) {		
			if (hasSecondaryTrdType == FixUtils.TAG_HAS_VALUE) {		
				return secondaryTrdType; 		
			} else {

				buf.position(hasSecondaryTrdType);

			secondaryTrdType = FixMessage.getTagIntValue(buf, err);
		
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
			
	public void crackTradeHandlingInstr() {		
		getTradeHandlingInstr();		
	}		
			
	public byte getTradeHandlingInstr() { 		
		if ( hasTradeHandlingInstr()) {		
			if (hasTradeHandlingInstr == FixUtils.TAG_HAS_VALUE) {		
				return tradeHandlingInstr; 		
			} else {

				buf.position(hasTradeHandlingInstr);

			tradeHandlingInstr = FixMessage.getTagCharValue(buf, err);
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
			
	public void crackOrigTradeHandlingInstr() {		
		getOrigTradeHandlingInstr();		
	}		
			
	public byte getOrigTradeHandlingInstr() { 		
		if ( hasOrigTradeHandlingInstr()) {		
			if (hasOrigTradeHandlingInstr == FixUtils.TAG_HAS_VALUE) {		
				return origTradeHandlingInstr; 		
			} else {

				buf.position(hasOrigTradeHandlingInstr);

			origTradeHandlingInstr = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasOrigTradeHandlingInstr = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return origTradeHandlingInstr;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrigTradeHandlingInstr() { return hasOrigTradeHandlingInstr != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrigTradeHandlingInstr(byte[] src) {		
		if (src == null ) return;
		if (hasOrigTradeHandlingInstr()) origTradeHandlingInstr = (byte)' ';		
		origTradeHandlingInstr = src[0];		
		hasOrigTradeHandlingInstr = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigTradeHandlingInstr(byte src) {		
		origTradeHandlingInstr = src;
		hasOrigTradeHandlingInstr = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigTradeHandlingInstr(String str) {		
		if (str == null ) return;
		if (hasOrigTradeHandlingInstr()) origTradeHandlingInstr = (byte)' ';		
		byte[] src = str.getBytes(); 		
		origTradeHandlingInstr = src[0];		
		hasOrigTradeHandlingInstr = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrigTradeDate() {		
		getOrigTradeDate();		
	}		
			
	public byte[] getOrigTradeDate() { 		
		if ( hasOrigTradeDate()) {		
			if (hasOrigTradeDate == FixUtils.TAG_HAS_VALUE) {		
				return origTradeDate; 		
			} else {

				buf.position(hasOrigTradeDate);

			FixMessage.getTagStringValue(buf, origTradeDate, 0, origTradeDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrigTradeDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return origTradeDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigTradeDate() { return hasOrigTradeDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrigTradeDate(byte[] src) {		
		if (src == null ) return;
		if (hasOrigTradeDate()) FixUtils.fillSpace(origTradeDate);		
		FixUtils.copy(origTradeDate, src); 		
		hasOrigTradeDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigTradeDate(String str) {		
		if (str == null ) return;
		if (hasOrigTradeDate()) FixUtils.fillSpace(origTradeDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origTradeDate, src); 		
		hasOrigTradeDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrigTradeID() {		
		getOrigTradeID();		
	}		
			
	public byte[] getOrigTradeID() { 		
		if ( hasOrigTradeID()) {		
			if (hasOrigTradeID == FixUtils.TAG_HAS_VALUE) {		
				return origTradeID; 		
			} else {

				buf.position(hasOrigTradeID);

			FixMessage.getTagStringValue(buf, origTradeID, 0, origTradeID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrigTradeID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return origTradeID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigTradeID() { return hasOrigTradeID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrigTradeID(byte[] src) {		
		if (src == null ) return;
		if (hasOrigTradeID()) FixUtils.fillSpace(origTradeID);		
		FixUtils.copy(origTradeID, src); 		
		hasOrigTradeID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigTradeID(String str) {		
		if (str == null ) return;
		if (hasOrigTradeID()) FixUtils.fillSpace(origTradeID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origTradeID, src); 		
		hasOrigTradeID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrigSecondaryTradeID() {		
		getOrigSecondaryTradeID();		
	}		
			
	public byte[] getOrigSecondaryTradeID() { 		
		if ( hasOrigSecondaryTradeID()) {		
			if (hasOrigSecondaryTradeID == FixUtils.TAG_HAS_VALUE) {		
				return origSecondaryTradeID; 		
			} else {

				buf.position(hasOrigSecondaryTradeID);

			FixMessage.getTagStringValue(buf, origSecondaryTradeID, 0, origSecondaryTradeID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrigSecondaryTradeID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return origSecondaryTradeID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigSecondaryTradeID() { return hasOrigSecondaryTradeID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrigSecondaryTradeID(byte[] src) {		
		if (src == null ) return;
		if (hasOrigSecondaryTradeID()) FixUtils.fillSpace(origSecondaryTradeID);		
		FixUtils.copy(origSecondaryTradeID, src); 		
		hasOrigSecondaryTradeID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigSecondaryTradeID(String str) {		
		if (str == null ) return;
		if (hasOrigSecondaryTradeID()) FixUtils.fillSpace(origSecondaryTradeID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origSecondaryTradeID, src); 		
		hasOrigSecondaryTradeID = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, transferReason, 0, transferReason.length, err);
		
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
		if (hasTransferReason()) FixUtils.fillSpace(transferReason);		
		FixUtils.copy(transferReason, src); 		
		hasTransferReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTransferReason(String str) {		
		if (str == null ) return;
		if (hasTransferReason()) FixUtils.fillSpace(transferReason);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transferReason, src); 		
		hasTransferReason = FixUtils.TAG_HAS_VALUE;		
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

			execType = FixMessage.getTagCharValue(buf, err);
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
			
	public void crackTradeReportRefID() {		
		getTradeReportRefID();		
	}		
			
	public byte[] getTradeReportRefID() { 		
		if ( hasTradeReportRefID()) {		
			if (hasTradeReportRefID == FixUtils.TAG_HAS_VALUE) {		
				return tradeReportRefID; 		
			} else {

				buf.position(hasTradeReportRefID);

			FixMessage.getTagStringValue(buf, tradeReportRefID, 0, tradeReportRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeReportRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeReportRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeReportRefID() { return hasTradeReportRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeReportRefID(byte[] src) {		
		if (src == null ) return;
		if (hasTradeReportRefID()) FixUtils.fillSpace(tradeReportRefID);		
		FixUtils.copy(tradeReportRefID, src); 		
		hasTradeReportRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeReportRefID(String str) {		
		if (str == null ) return;
		if (hasTradeReportRefID()) FixUtils.fillSpace(tradeReportRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeReportRefID, src); 		
		hasTradeReportRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryTradeReportRefID() {		
		getSecondaryTradeReportRefID();		
	}		
			
	public byte[] getSecondaryTradeReportRefID() { 		
		if ( hasSecondaryTradeReportRefID()) {		
			if (hasSecondaryTradeReportRefID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryTradeReportRefID; 		
			} else {

				buf.position(hasSecondaryTradeReportRefID);

			FixMessage.getTagStringValue(buf, secondaryTradeReportRefID, 0, secondaryTradeReportRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryTradeReportRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryTradeReportRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryTradeReportRefID() { return hasSecondaryTradeReportRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryTradeReportRefID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryTradeReportRefID()) FixUtils.fillSpace(secondaryTradeReportRefID);		
		FixUtils.copy(secondaryTradeReportRefID, src); 		
		hasSecondaryTradeReportRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryTradeReportRefID(String str) {		
		if (str == null ) return;
		if (hasSecondaryTradeReportRefID()) FixUtils.fillSpace(secondaryTradeReportRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryTradeReportRefID, src); 		
		hasSecondaryTradeReportRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTrdRptStatus() {		
		getTrdRptStatus();		
	}		
			
	public long getTrdRptStatus() { 		
		if ( hasTrdRptStatus()) {		
			if (hasTrdRptStatus == FixUtils.TAG_HAS_VALUE) {		
				return trdRptStatus; 		
			} else {

				buf.position(hasTrdRptStatus);

			trdRptStatus = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTrdRptStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return trdRptStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTrdRptStatus() { return hasTrdRptStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTrdRptStatus(byte[] src) {		
		if (src == null ) return;
		if (hasTrdRptStatus()) trdRptStatus = FixUtils.TAG_HAS_NO_VALUE;		
		trdRptStatus = FixUtils.longValueOf(src, 0, src.length);
		hasTrdRptStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdRptStatus(long src) {		
		trdRptStatus = src;
		hasTrdRptStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdRptStatus(String str) {		
		if (str == null ) return;
		if (hasTrdRptStatus()) trdRptStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		trdRptStatus = FixUtils.longValueOf(src, 0, src.length);
		hasTrdRptStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeReportRejectReason() {		
		getTradeReportRejectReason();		
	}		
			
	public long getTradeReportRejectReason() { 		
		if ( hasTradeReportRejectReason()) {		
			if (hasTradeReportRejectReason == FixUtils.TAG_HAS_VALUE) {		
				return tradeReportRejectReason; 		
			} else {

				buf.position(hasTradeReportRejectReason);

			tradeReportRejectReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTradeReportRejectReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeReportRejectReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradeReportRejectReason() { return hasTradeReportRejectReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeReportRejectReason(byte[] src) {		
		if (src == null ) return;
		if (hasTradeReportRejectReason()) tradeReportRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		tradeReportRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasTradeReportRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeReportRejectReason(long src) {		
		tradeReportRejectReason = src;
		hasTradeReportRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeReportRejectReason(String str) {		
		if (str == null ) return;
		if (hasTradeReportRejectReason()) tradeReportRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradeReportRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasTradeReportRejectReason = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, secondaryTradeReportID, 0, secondaryTradeReportID.length, err);
		
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
		if (hasSecondaryTradeReportID()) FixUtils.fillSpace(secondaryTradeReportID);		
		FixUtils.copy(secondaryTradeReportID, src); 		
		hasSecondaryTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryTradeReportID(String str) {		
		if (str == null ) return;
		if (hasSecondaryTradeReportID()) FixUtils.fillSpace(secondaryTradeReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryTradeReportID, src); 		
		hasSecondaryTradeReportID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackTradeLinkID() {		
		getTradeLinkID();		
	}		
			
	public byte[] getTradeLinkID() { 		
		if ( hasTradeLinkID()) {		
			if (hasTradeLinkID == FixUtils.TAG_HAS_VALUE) {		
				return tradeLinkID; 		
			} else {

				buf.position(hasTradeLinkID);

			FixMessage.getTagStringValue(buf, tradeLinkID, 0, tradeLinkID.length, err);
		
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
		if (hasTradeLinkID()) FixUtils.fillSpace(tradeLinkID);		
		FixUtils.copy(tradeLinkID, src); 		
		hasTradeLinkID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeLinkID(String str) {		
		if (str == null ) return;
		if (hasTradeLinkID()) FixUtils.fillSpace(tradeLinkID);		
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

			FixMessage.getTagStringValue(buf, trdMatchID, 0, trdMatchID.length, err);
		
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
		if (hasTrdMatchID()) FixUtils.fillSpace(trdMatchID);		
		FixUtils.copy(trdMatchID, src); 		
		hasTrdMatchID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdMatchID(String str) {		
		if (str == null ) return;
		if (hasTrdMatchID()) FixUtils.fillSpace(trdMatchID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(trdMatchID, src); 		
		hasTrdMatchID = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, execID, 0, execID.length, err);
		
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
		if (hasExecID()) FixUtils.fillSpace(execID);		
		FixUtils.copy(execID, src); 		
		hasExecID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecID(String str) {		
		if (str == null ) return;
		if (hasExecID()) FixUtils.fillSpace(execID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(execID, src); 		
		hasExecID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryExecID() {		
		getSecondaryExecID();		
	}		
			
	public byte[] getSecondaryExecID() { 		
		if ( hasSecondaryExecID()) {		
			if (hasSecondaryExecID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryExecID; 		
			} else {

				buf.position(hasSecondaryExecID);

			FixMessage.getTagStringValue(buf, secondaryExecID, 0, secondaryExecID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryExecID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryExecID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryExecID() { return hasSecondaryExecID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryExecID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryExecID()) FixUtils.fillSpace(secondaryExecID);		
		FixUtils.copy(secondaryExecID, src); 		
		hasSecondaryExecID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryExecID(String str) {		
		if (str == null ) return;
		if (hasSecondaryExecID()) FixUtils.fillSpace(secondaryExecID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryExecID, src); 		
		hasSecondaryExecID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExecRestatementReason() {		
		getExecRestatementReason();		
	}		
			
	public long getExecRestatementReason() { 		
		if ( hasExecRestatementReason()) {		
			if (hasExecRestatementReason == FixUtils.TAG_HAS_VALUE) {		
				return execRestatementReason; 		
			} else {

				buf.position(hasExecRestatementReason);

			execRestatementReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasExecRestatementReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execRestatementReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasExecRestatementReason() { return hasExecRestatementReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecRestatementReason(byte[] src) {		
		if (src == null ) return;
		if (hasExecRestatementReason()) execRestatementReason = FixUtils.TAG_HAS_NO_VALUE;		
		execRestatementReason = FixUtils.longValueOf(src, 0, src.length);
		hasExecRestatementReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecRestatementReason(long src) {		
		execRestatementReason = src;
		hasExecRestatementReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecRestatementReason(String str) {		
		if (str == null ) return;
		if (hasExecRestatementReason()) execRestatementReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		execRestatementReason = FixUtils.longValueOf(src, 0, src.length);
		hasExecRestatementReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPreviouslyReported() {		
		getPreviouslyReported();		
	}		
			
	public boolean getPreviouslyReported() { 		
		if ( hasPreviouslyReported()) {		
			if (hasPreviouslyReported == FixUtils.TAG_HAS_VALUE) {		
				return previouslyReported; 		
			} else {

				buf.position(hasPreviouslyReported);

			previouslyReported = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasPreviouslyReported = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return previouslyReported;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasPreviouslyReported() { return hasPreviouslyReported != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPreviouslyReported(byte[] src) {		
		if (src == null ) return;
		if (hasPreviouslyReported()) previouslyReported = false;		
		previouslyReported = src[0]==(byte)'Y'?true:false;		
		hasPreviouslyReported = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPreviouslyReported(boolean src) {		
		previouslyReported = src;
		hasPreviouslyReported = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPreviouslyReported(String str) {		
		if (str == null ) return;
		if (hasPreviouslyReported()) previouslyReported = false;		
		byte[] src = str.getBytes(); 		
		previouslyReported = src[0]==(byte)'Y'?true:false;		
		hasPreviouslyReported = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPriceType() {		
		getPriceType();		
	}		
			
	public long getPriceType() { 		
		if ( hasPriceType()) {		
			if (hasPriceType == FixUtils.TAG_HAS_VALUE) {		
				return priceType; 		
			} else {

				buf.position(hasPriceType);

			priceType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPriceType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return priceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriceType() { return hasPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasPriceType()) priceType = FixUtils.TAG_HAS_NO_VALUE;		
		priceType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceType(long src) {		
		priceType = src;
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceType(String str) {		
		if (str == null ) return;
		if (hasPriceType()) priceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priceType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackUnderlyingTradingSessionID() {		
		getUnderlyingTradingSessionID();		
	}		
			
	public byte[] getUnderlyingTradingSessionID() { 		
		if ( hasUnderlyingTradingSessionID()) {		
			if (hasUnderlyingTradingSessionID == FixUtils.TAG_HAS_VALUE) {		
				return underlyingTradingSessionID; 		
			} else {

				buf.position(hasUnderlyingTradingSessionID);

			FixMessage.getTagStringValue(buf, underlyingTradingSessionID, 0, underlyingTradingSessionID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasUnderlyingTradingSessionID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return underlyingTradingSessionID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingTradingSessionID() { return hasUnderlyingTradingSessionID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUnderlyingTradingSessionID(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingTradingSessionID()) FixUtils.fillSpace(underlyingTradingSessionID);		
		FixUtils.copy(underlyingTradingSessionID, src); 		
		hasUnderlyingTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingTradingSessionID(String str) {		
		if (str == null ) return;
		if (hasUnderlyingTradingSessionID()) FixUtils.fillSpace(underlyingTradingSessionID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingTradingSessionID, src); 		
		hasUnderlyingTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQtyType() {		
		getQtyType();		
	}		
			
	public long getQtyType() { 		
		if ( hasQtyType()) {		
			if (hasQtyType == FixUtils.TAG_HAS_VALUE) {		
				return qtyType; 		
			} else {

				buf.position(hasQtyType);

			qtyType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQtyType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return qtyType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQtyType() { return hasQtyType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQtyType(byte[] src) {		
		if (src == null ) return;
		if (hasQtyType()) qtyType = FixUtils.TAG_HAS_NO_VALUE;		
		qtyType = FixUtils.longValueOf(src, 0, src.length);
		hasQtyType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQtyType(long src) {		
		qtyType = src;
		hasQtyType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQtyType(String str) {		
		if (str == null ) return;
		if (hasQtyType()) qtyType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		qtyType = FixUtils.longValueOf(src, 0, src.length);
		hasQtyType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackUnderlyingTradingSessionSubID() {		
		getUnderlyingTradingSessionSubID();		
	}		
			
	public byte[] getUnderlyingTradingSessionSubID() { 		
		if ( hasUnderlyingTradingSessionSubID()) {		
			if (hasUnderlyingTradingSessionSubID == FixUtils.TAG_HAS_VALUE) {		
				return underlyingTradingSessionSubID; 		
			} else {

				buf.position(hasUnderlyingTradingSessionSubID);

			FixMessage.getTagStringValue(buf, underlyingTradingSessionSubID, 0, underlyingTradingSessionSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasUnderlyingTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return underlyingTradingSessionSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingTradingSessionSubID() { return hasUnderlyingTradingSessionSubID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUnderlyingTradingSessionSubID(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingTradingSessionSubID()) FixUtils.fillSpace(underlyingTradingSessionSubID);		
		FixUtils.copy(underlyingTradingSessionSubID, src); 		
		hasUnderlyingTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingTradingSessionSubID(String str) {		
		if (str == null ) return;
		if (hasUnderlyingTradingSessionSubID()) FixUtils.fillSpace(underlyingTradingSessionSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingTradingSessionSubID, src); 		
		hasUnderlyingTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastQty() {		
		getLastQty();		
	}		
			
	public long getLastQty() { 		
		if ( hasLastQty()) {		
			if (hasLastQty == FixUtils.TAG_HAS_VALUE) {		
				return lastQty; 		
			} else {

				buf.position(hasLastQty);

			lastQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLastQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastQty() { return hasLastQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastQty(byte[] src) {		
		if (src == null ) return;
		if (hasLastQty()) lastQty = FixUtils.TAG_HAS_NO_VALUE;		
		lastQty = FixUtils.longValueOf(src, 0, src.length);
		hasLastQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastQty(long src) {		
		lastQty = src;
		hasLastQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastQty(String str) {		
		if (str == null ) return;
		if (hasLastQty()) lastQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastQty = FixUtils.longValueOf(src, 0, src.length);
		hasLastQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastPx() {		
		getLastPx();		
	}		
			
	public long getLastPx() { 		
		if ( hasLastPx()) {		
			if (hasLastPx == FixUtils.TAG_HAS_VALUE) {		
				return lastPx; 		
			} else {

				buf.position(hasLastPx);

			lastPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLastPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastPx() { return hasLastPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastPx(byte[] src) {		
		if (src == null ) return;
		if (hasLastPx()) lastPx = FixUtils.TAG_HAS_NO_VALUE;		
		lastPx = FixUtils.longValueOf(src, 0, src.length);
		hasLastPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastPx(long src) {		
		lastPx = src;
		hasLastPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastPx(String str) {		
		if (str == null ) return;
		if (hasLastPx()) lastPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastPx = FixUtils.longValueOf(src, 0, src.length);
		hasLastPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlSessID() {		
		getSettlSessID();		
	}		
			
	public byte[] getSettlSessID() { 		
		if ( hasSettlSessID()) {		
			if (hasSettlSessID == FixUtils.TAG_HAS_VALUE) {		
				return settlSessID; 		
			} else {

				buf.position(hasSettlSessID);

			FixMessage.getTagStringValue(buf, settlSessID, 0, settlSessID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlSessID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlSessID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlSessID() { return hasSettlSessID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlSessID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlSessID()) FixUtils.fillSpace(settlSessID);		
		FixUtils.copy(settlSessID, src); 		
		hasSettlSessID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlSessID(String str) {		
		if (str == null ) return;
		if (hasSettlSessID()) FixUtils.fillSpace(settlSessID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlSessID, src); 		
		hasSettlSessID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlSessSubID() {		
		getSettlSessSubID();		
	}		
			
	public byte[] getSettlSessSubID() { 		
		if ( hasSettlSessSubID()) {		
			if (hasSettlSessSubID == FixUtils.TAG_HAS_VALUE) {		
				return settlSessSubID; 		
			} else {

				buf.position(hasSettlSessSubID);

			FixMessage.getTagStringValue(buf, settlSessSubID, 0, settlSessSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlSessSubID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlSessSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlSessSubID() { return hasSettlSessSubID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlSessSubID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlSessSubID()) FixUtils.fillSpace(settlSessSubID);		
		FixUtils.copy(settlSessSubID, src); 		
		hasSettlSessSubID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlSessSubID(String str) {		
		if (str == null ) return;
		if (hasSettlSessSubID()) FixUtils.fillSpace(settlSessSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlSessSubID, src); 		
		hasSettlSessSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackVenueType() {		
		getVenueType();		
	}		
			
	public byte getVenueType() { 		
		if ( hasVenueType()) {		
			if (hasVenueType == FixUtils.TAG_HAS_VALUE) {		
				return venueType; 		
			} else {

				buf.position(hasVenueType);

			venueType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (venueType != (byte)'E') && (venueType != (byte)'P') && (venueType != (byte)'X') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1430);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasVenueType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return venueType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasVenueType() { return hasVenueType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setVenueType(byte[] src) {		
		if (src == null ) return;
		if (hasVenueType()) venueType = (byte)' ';		
		venueType = src[0];		
		hasVenueType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setVenueType(byte src) {		
		venueType = src;
		hasVenueType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setVenueType(String str) {		
		if (str == null ) return;
		if (hasVenueType()) venueType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		venueType = src[0];		
		hasVenueType = FixUtils.TAG_HAS_VALUE;		
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
		if (hasMarketSegmentID()) FixUtils.fillSpace(marketSegmentID);		
		FixUtils.copy(marketSegmentID, src); 		
		hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketSegmentID(String str) {		
		if (str == null ) return;
		if (hasMarketSegmentID()) FixUtils.fillSpace(marketSegmentID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketSegmentID, src); 		
		hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
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
		if (hasMarketID()) FixUtils.fillSpace(marketID);		
		FixUtils.copy(marketID, src); 		
		hasMarketID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketID(String str) {		
		if (str == null ) return;
		if (hasMarketID()) FixUtils.fillSpace(marketID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketID, src); 		
		hasMarketID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastParPx() {		
		getLastParPx();		
	}		
			
	public long getLastParPx() { 		
		if ( hasLastParPx()) {		
			if (hasLastParPx == FixUtils.TAG_HAS_VALUE) {		
				return lastParPx; 		
			} else {

				buf.position(hasLastParPx);

			lastParPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLastParPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastParPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastParPx() { return hasLastParPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastParPx(byte[] src) {		
		if (src == null ) return;
		if (hasLastParPx()) lastParPx = FixUtils.TAG_HAS_NO_VALUE;		
		lastParPx = FixUtils.longValueOf(src, 0, src.length);
		hasLastParPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastParPx(long src) {		
		lastParPx = src;
		hasLastParPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastParPx(String str) {		
		if (str == null ) return;
		if (hasLastParPx()) lastParPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastParPx = FixUtils.longValueOf(src, 0, src.length);
		hasLastParPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastSpotRate() {		
		getLastSpotRate();		
	}		
			
	public long getLastSpotRate() { 		
		if ( hasLastSpotRate()) {		
			if (hasLastSpotRate == FixUtils.TAG_HAS_VALUE) {		
				return lastSpotRate; 		
			} else {

				buf.position(hasLastSpotRate);

			lastSpotRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLastSpotRate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastSpotRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastSpotRate() { return hasLastSpotRate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastSpotRate(byte[] src) {		
		if (src == null ) return;
		if (hasLastSpotRate()) lastSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		lastSpotRate = FixUtils.longValueOf(src, 0, src.length);
		hasLastSpotRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastSpotRate(long src) {		
		lastSpotRate = src;
		hasLastSpotRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastSpotRate(String str) {		
		if (str == null ) return;
		if (hasLastSpotRate()) lastSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastSpotRate = FixUtils.longValueOf(src, 0, src.length);
		hasLastSpotRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastForwardPoints() {		
		getLastForwardPoints();		
	}		
			
	public long getLastForwardPoints() { 		
		if ( hasLastForwardPoints()) {		
			if (hasLastForwardPoints == FixUtils.TAG_HAS_VALUE) {		
				return lastForwardPoints; 		
			} else {

				buf.position(hasLastForwardPoints);

			lastForwardPoints = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLastForwardPoints = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastForwardPoints;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastForwardPoints() { return hasLastForwardPoints != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastForwardPoints(byte[] src) {		
		if (src == null ) return;
		if (hasLastForwardPoints()) lastForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		lastForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasLastForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastForwardPoints(long src) {		
		lastForwardPoints = src;
		hasLastForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastForwardPoints(String str) {		
		if (str == null ) return;
		if (hasLastForwardPoints()) lastForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasLastForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastMkt() {		
		getLastMkt();		
	}		
			
	public byte[] getLastMkt() { 		
		if ( hasLastMkt()) {		
			if (hasLastMkt == FixUtils.TAG_HAS_VALUE) {		
				return lastMkt; 		
			} else {

				buf.position(hasLastMkt);

			FixMessage.getTagStringValue(buf, lastMkt, 0, lastMkt.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasLastMkt = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastMkt;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLastMkt() { return hasLastMkt != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastMkt(byte[] src) {		
		if (src == null ) return;
		if (hasLastMkt()) FixUtils.fillSpace(lastMkt);		
		FixUtils.copy(lastMkt, src); 		
		hasLastMkt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastMkt(String str) {		
		if (str == null ) return;
		if (hasLastMkt()) FixUtils.fillSpace(lastMkt);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(lastMkt, src); 		
		hasLastMkt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeDate() {		
		getTradeDate();		
	}		
			
	public byte[] getTradeDate() { 		
		if ( hasTradeDate()) {		
			if (hasTradeDate == FixUtils.TAG_HAS_VALUE) {		
				return tradeDate; 		
			} else {

				buf.position(hasTradeDate);

			FixMessage.getTagStringValue(buf, tradeDate, 0, tradeDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeDate() { return hasTradeDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeDate(byte[] src) {		
		if (src == null ) return;
		if (hasTradeDate()) FixUtils.fillSpace(tradeDate);		
		FixUtils.copy(tradeDate, src); 		
		hasTradeDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeDate(String str) {		
		if (str == null ) return;
		if (hasTradeDate()) FixUtils.fillSpace(tradeDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeDate, src); 		
		hasTradeDate = FixUtils.TAG_HAS_VALUE;		
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
		if (hasClearingBusinessDate()) FixUtils.fillSpace(clearingBusinessDate);		
		FixUtils.copy(clearingBusinessDate, src); 		
		hasClearingBusinessDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClearingBusinessDate(String str) {		
		if (str == null ) return;
		if (hasClearingBusinessDate()) FixUtils.fillSpace(clearingBusinessDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clearingBusinessDate, src); 		
		hasClearingBusinessDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAvgPx() {		
		getAvgPx();		
	}		
			
	public long getAvgPx() { 		
		if ( hasAvgPx()) {		
			if (hasAvgPx == FixUtils.TAG_HAS_VALUE) {		
				return avgPx; 		
			} else {

				buf.position(hasAvgPx);

			avgPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAvgPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return avgPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAvgPx() { return hasAvgPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAvgPx(byte[] src) {		
		if (src == null ) return;
		if (hasAvgPx()) avgPx = FixUtils.TAG_HAS_NO_VALUE;		
		avgPx = FixUtils.longValueOf(src, 0, src.length);
		hasAvgPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgPx(long src) {		
		avgPx = src;
		hasAvgPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgPx(String str) {		
		if (str == null ) return;
		if (hasAvgPx()) avgPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		avgPx = FixUtils.longValueOf(src, 0, src.length);
		hasAvgPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAvgPxIndicator() {		
		getAvgPxIndicator();		
	}		
			
	public long getAvgPxIndicator() { 		
		if ( hasAvgPxIndicator()) {		
			if (hasAvgPxIndicator == FixUtils.TAG_HAS_VALUE) {		
				return avgPxIndicator; 		
			} else {

				buf.position(hasAvgPxIndicator);

			avgPxIndicator = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAvgPxIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return avgPxIndicator;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAvgPxIndicator() { return hasAvgPxIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAvgPxIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasAvgPxIndicator()) avgPxIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		avgPxIndicator = FixUtils.longValueOf(src, 0, src.length);
		hasAvgPxIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgPxIndicator(long src) {		
		avgPxIndicator = src;
		hasAvgPxIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgPxIndicator(String str) {		
		if (str == null ) return;
		if (hasAvgPxIndicator()) avgPxIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		avgPxIndicator = FixUtils.longValueOf(src, 0, src.length);
		hasAvgPxIndicator = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackTradeLegRefID() {		
		getTradeLegRefID();		
	}		
			
	public byte[] getTradeLegRefID() { 		
		if ( hasTradeLegRefID()) {		
			if (hasTradeLegRefID == FixUtils.TAG_HAS_VALUE) {		
				return tradeLegRefID; 		
			} else {

				buf.position(hasTradeLegRefID);

			FixMessage.getTagStringValue(buf, tradeLegRefID, 0, tradeLegRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeLegRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeLegRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeLegRefID() { return hasTradeLegRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeLegRefID(byte[] src) {		
		if (src == null ) return;
		if (hasTradeLegRefID()) FixUtils.fillSpace(tradeLegRefID);		
		FixUtils.copy(tradeLegRefID, src); 		
		hasTradeLegRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeLegRefID(String str) {		
		if (str == null ) return;
		if (hasTradeLegRefID()) FixUtils.fillSpace(tradeLegRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeLegRefID, src); 		
		hasTradeLegRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCalculatedCcyLastQty() {		
		getCalculatedCcyLastQty();		
	}		
			
	public long getCalculatedCcyLastQty() { 		
		if ( hasCalculatedCcyLastQty()) {		
			if (hasCalculatedCcyLastQty == FixUtils.TAG_HAS_VALUE) {		
				return calculatedCcyLastQty; 		
			} else {

				buf.position(hasCalculatedCcyLastQty);

			calculatedCcyLastQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCalculatedCcyLastQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return calculatedCcyLastQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCalculatedCcyLastQty() { return hasCalculatedCcyLastQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCalculatedCcyLastQty(byte[] src) {		
		if (src == null ) return;
		if (hasCalculatedCcyLastQty()) calculatedCcyLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		calculatedCcyLastQty = FixUtils.longValueOf(src, 0, src.length);
		hasCalculatedCcyLastQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCalculatedCcyLastQty(long src) {		
		calculatedCcyLastQty = src;
		hasCalculatedCcyLastQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCalculatedCcyLastQty(String str) {		
		if (str == null ) return;
		if (hasCalculatedCcyLastQty()) calculatedCcyLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		calculatedCcyLastQty = FixUtils.longValueOf(src, 0, src.length);
		hasCalculatedCcyLastQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastSwapPoints() {		
		getLastSwapPoints();		
	}		
			
	public long getLastSwapPoints() { 		
		if ( hasLastSwapPoints()) {		
			if (hasLastSwapPoints == FixUtils.TAG_HAS_VALUE) {		
				return lastSwapPoints; 		
			} else {

				buf.position(hasLastSwapPoints);

			lastSwapPoints = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLastSwapPoints = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastSwapPoints;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastSwapPoints() { return hasLastSwapPoints != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastSwapPoints(byte[] src) {		
		if (src == null ) return;
		if (hasLastSwapPoints()) lastSwapPoints = FixUtils.TAG_HAS_NO_VALUE;		
		lastSwapPoints = FixUtils.longValueOf(src, 0, src.length);
		hasLastSwapPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastSwapPoints(long src) {		
		lastSwapPoints = src;
		hasLastSwapPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastSwapPoints(String str) {		
		if (str == null ) return;
		if (hasLastSwapPoints()) lastSwapPoints = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastSwapPoints = FixUtils.longValueOf(src, 0, src.length);
		hasLastSwapPoints = FixUtils.TAG_HAS_VALUE;		
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
		if (hasCurrency()) FixUtils.fillSpace(currency);		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCurrency(String str) {		
		if (str == null ) return;
		if (hasCurrency()) FixUtils.fillSpace(currency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlCurrency() {		
		getSettlCurrency();		
	}		
			
	public byte[] getSettlCurrency() { 		
		if ( hasSettlCurrency()) {		
			if (hasSettlCurrency == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrency; 		
			} else {

				buf.position(hasSettlCurrency);

			FixMessage.getTagStringValue(buf, settlCurrency, 0, settlCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlCurrency = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlCurrency() { return hasSettlCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrency()) FixUtils.fillSpace(settlCurrency);		
		FixUtils.copy(settlCurrency, src); 		
		hasSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrency(String str) {		
		if (str == null ) return;
		if (hasSettlCurrency()) FixUtils.fillSpace(settlCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlCurrency, src); 		
		hasSettlCurrency = FixUtils.TAG_HAS_VALUE;		
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
		if (hasTransactTime()) FixUtils.fillSpace(transactTime);		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTransactTime(String str) {		
		if (str == null ) return;
		if (hasTransactTime()) FixUtils.fillSpace(transactTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlType() {		
		getSettlType();		
	}		
			
	public byte[] getSettlType() { 		
		if ( hasSettlType()) {		
			if (hasSettlType == FixUtils.TAG_HAS_VALUE) {		
				return settlType; 		
			} else {

				buf.position(hasSettlType);

			FixMessage.getTagStringValue(buf, settlType, 0, settlType.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlType() { return hasSettlType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlType(byte[] src) {		
		if (src == null ) return;
		if (hasSettlType()) FixUtils.fillSpace(settlType);		
		FixUtils.copy(settlType, src); 		
		hasSettlType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlType(String str) {		
		if (str == null ) return;
		if (hasSettlType()) FixUtils.fillSpace(settlType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlType, src); 		
		hasSettlType = FixUtils.TAG_HAS_VALUE;		
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

			matchStatus = FixMessage.getTagCharValue(buf, err);
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
			
	public void crackMatchType() {		
		getMatchType();		
	}		
			
	public byte[] getMatchType() { 		
		if ( hasMatchType()) {		
			if (hasMatchType == FixUtils.TAG_HAS_VALUE) {		
				return matchType; 		
			} else {

				buf.position(hasMatchType);

			FixMessage.getTagStringValue(buf, matchType, 0, matchType.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMatchType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return matchType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMatchType() { return hasMatchType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMatchType(byte[] src) {		
		if (src == null ) return;
		if (hasMatchType()) FixUtils.fillSpace(matchType);		
		FixUtils.copy(matchType, src); 		
		hasMatchType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMatchType(String str) {		
		if (str == null ) return;
		if (hasMatchType()) FixUtils.fillSpace(matchType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(matchType, src); 		
		hasMatchType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCopyMsgIndicator() {		
		getCopyMsgIndicator();		
	}		
			
	public boolean getCopyMsgIndicator() { 		
		if ( hasCopyMsgIndicator()) {		
			if (hasCopyMsgIndicator == FixUtils.TAG_HAS_VALUE) {		
				return copyMsgIndicator; 		
			} else {

				buf.position(hasCopyMsgIndicator);

			copyMsgIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasCopyMsgIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return copyMsgIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasCopyMsgIndicator() { return hasCopyMsgIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCopyMsgIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasCopyMsgIndicator()) copyMsgIndicator = false;		
		copyMsgIndicator = src[0]==(byte)'Y'?true:false;		
		hasCopyMsgIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCopyMsgIndicator(boolean src) {		
		copyMsgIndicator = src;
		hasCopyMsgIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCopyMsgIndicator(String str) {		
		if (str == null ) return;
		if (hasCopyMsgIndicator()) copyMsgIndicator = false;		
		byte[] src = str.getBytes(); 		
		copyMsgIndicator = src[0]==(byte)'Y'?true:false;		
		hasCopyMsgIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPublishTrdIndicator() {		
		getPublishTrdIndicator();		
	}		
			
	public boolean getPublishTrdIndicator() { 		
		if ( hasPublishTrdIndicator()) {		
			if (hasPublishTrdIndicator == FixUtils.TAG_HAS_VALUE) {		
				return publishTrdIndicator; 		
			} else {

				buf.position(hasPublishTrdIndicator);

			publishTrdIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasPublishTrdIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return publishTrdIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasPublishTrdIndicator() { return hasPublishTrdIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPublishTrdIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasPublishTrdIndicator()) publishTrdIndicator = false;		
		publishTrdIndicator = src[0]==(byte)'Y'?true:false;		
		hasPublishTrdIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPublishTrdIndicator(boolean src) {		
		publishTrdIndicator = src;
		hasPublishTrdIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPublishTrdIndicator(String str) {		
		if (str == null ) return;
		if (hasPublishTrdIndicator()) publishTrdIndicator = false;		
		byte[] src = str.getBytes(); 		
		publishTrdIndicator = src[0]==(byte)'Y'?true:false;		
		hasPublishTrdIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackShortSaleReason() {		
		getShortSaleReason();		
	}		
			
	public long getShortSaleReason() { 		
		if ( hasShortSaleReason()) {		
			if (hasShortSaleReason == FixUtils.TAG_HAS_VALUE) {		
				return shortSaleReason; 		
			} else {

				buf.position(hasShortSaleReason);

			shortSaleReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasShortSaleReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return shortSaleReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasShortSaleReason() { return hasShortSaleReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setShortSaleReason(byte[] src) {		
		if (src == null ) return;
		if (hasShortSaleReason()) shortSaleReason = FixUtils.TAG_HAS_NO_VALUE;		
		shortSaleReason = FixUtils.longValueOf(src, 0, src.length);
		hasShortSaleReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setShortSaleReason(long src) {		
		shortSaleReason = src;
		hasShortSaleReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setShortSaleReason(String str) {		
		if (str == null ) return;
		if (hasShortSaleReason()) shortSaleReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		shortSaleReason = FixUtils.longValueOf(src, 0, src.length);
		hasShortSaleReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradePublishIndicator() {		
		getTradePublishIndicator();		
	}		
			
	public long getTradePublishIndicator() { 		
		if ( hasTradePublishIndicator()) {		
			if (hasTradePublishIndicator == FixUtils.TAG_HAS_VALUE) {		
				return tradePublishIndicator; 		
			} else {

				buf.position(hasTradePublishIndicator);

			tradePublishIndicator = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTradePublishIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradePublishIndicator;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradePublishIndicator() { return hasTradePublishIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradePublishIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasTradePublishIndicator()) tradePublishIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		tradePublishIndicator = FixUtils.longValueOf(src, 0, src.length);
		hasTradePublishIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradePublishIndicator(long src) {		
		tradePublishIndicator = src;
		hasTradePublishIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradePublishIndicator(String str) {		
		if (str == null ) return;
		if (hasTradePublishIndicator()) tradePublishIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradePublishIndicator = FixUtils.longValueOf(src, 0, src.length);
		hasTradePublishIndicator = FixUtils.TAG_HAS_VALUE;		
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
		if (hasResponseDestination()) FixUtils.fillSpace(responseDestination);		
		FixUtils.copy(responseDestination, src); 		
		hasResponseDestination = FixUtils.TAG_HAS_VALUE;		
	}

	public void setResponseDestination(String str) {		
		if (str == null ) return;
		if (hasResponseDestination()) FixUtils.fillSpace(responseDestination);		
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
			
	public void crackAsOfIndicator() {		
		getAsOfIndicator();		
	}		
			
	public byte getAsOfIndicator() { 		
		if ( hasAsOfIndicator()) {		
			if (hasAsOfIndicator == FixUtils.TAG_HAS_VALUE) {		
				return asOfIndicator; 		
			} else {

				buf.position(hasAsOfIndicator);

			asOfIndicator = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (asOfIndicator != (byte)'1') && (asOfIndicator != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1015);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasAsOfIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return asOfIndicator;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasAsOfIndicator() { return hasAsOfIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAsOfIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasAsOfIndicator()) asOfIndicator = (byte)' ';		
		asOfIndicator = src[0];		
		hasAsOfIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAsOfIndicator(byte src) {		
		asOfIndicator = src;
		hasAsOfIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAsOfIndicator(String str) {		
		if (str == null ) return;
		if (hasAsOfIndicator()) asOfIndicator = (byte)' ';		
		byte[] src = str.getBytes(); 		
		asOfIndicator = src[0];		
		hasAsOfIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClearingFeeIndicator() {		
		getClearingFeeIndicator();		
	}		
			
	public byte[] getClearingFeeIndicator() { 		
		if ( hasClearingFeeIndicator()) {		
			if (hasClearingFeeIndicator == FixUtils.TAG_HAS_VALUE) {		
				return clearingFeeIndicator; 		
			} else {

				buf.position(hasClearingFeeIndicator);

			FixMessage.getTagStringValue(buf, clearingFeeIndicator, 0, clearingFeeIndicator.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClearingFeeIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clearingFeeIndicator;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClearingFeeIndicator() { return hasClearingFeeIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClearingFeeIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasClearingFeeIndicator()) FixUtils.fillSpace(clearingFeeIndicator);		
		FixUtils.copy(clearingFeeIndicator, src); 		
		hasClearingFeeIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClearingFeeIndicator(String str) {		
		if (str == null ) return;
		if (hasClearingFeeIndicator()) FixUtils.fillSpace(clearingFeeIndicator);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clearingFeeIndicator, src); 		
		hasClearingFeeIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTierCode() {		
		getTierCode();		
	}		
			
	public byte[] getTierCode() { 		
		if ( hasTierCode()) {		
			if (hasTierCode == FixUtils.TAG_HAS_VALUE) {		
				return tierCode; 		
			} else {

				buf.position(hasTierCode);

			FixMessage.getTagStringValue(buf, tierCode, 0, tierCode.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTierCode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tierCode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTierCode() { return hasTierCode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTierCode(byte[] src) {		
		if (src == null ) return;
		if (hasTierCode()) FixUtils.fillSpace(tierCode);		
		FixUtils.copy(tierCode, src); 		
		hasTierCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTierCode(String str) {		
		if (str == null ) return;
		if (hasTierCode()) FixUtils.fillSpace(tierCode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tierCode, src); 		
		hasTierCode = FixUtils.TAG_HAS_VALUE;		
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
		if (hasMessageEventSource()) FixUtils.fillSpace(messageEventSource);		
		FixUtils.copy(messageEventSource, src); 		
		hasMessageEventSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMessageEventSource(String str) {		
		if (str == null ) return;
		if (hasMessageEventSource()) FixUtils.fillSpace(messageEventSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(messageEventSource, src); 		
		hasMessageEventSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastUpdateTime() {		
		getLastUpdateTime();		
	}		
			
	public byte[] getLastUpdateTime() { 		
		if ( hasLastUpdateTime()) {		
			if (hasLastUpdateTime == FixUtils.TAG_HAS_VALUE) {		
				return lastUpdateTime; 		
			} else {

				buf.position(hasLastUpdateTime);

			FixMessage.getTagStringValue(buf, lastUpdateTime, 0, lastUpdateTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasLastUpdateTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastUpdateTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLastUpdateTime() { return hasLastUpdateTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastUpdateTime(byte[] src) {		
		if (src == null ) return;
		if (hasLastUpdateTime()) FixUtils.fillSpace(lastUpdateTime);		
		FixUtils.copy(lastUpdateTime, src); 		
		hasLastUpdateTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastUpdateTime(String str) {		
		if (str == null ) return;
		if (hasLastUpdateTime()) FixUtils.fillSpace(lastUpdateTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(lastUpdateTime, src); 		
		hasLastUpdateTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRndPx() {		
		getRndPx();		
	}		
			
	public long getRndPx() { 		
		if ( hasRndPx()) {		
			if (hasRndPx == FixUtils.TAG_HAS_VALUE) {		
				return rndPx; 		
			} else {

				buf.position(hasRndPx);

			rndPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasRndPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return rndPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRndPx() { return hasRndPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRndPx(byte[] src) {		
		if (src == null ) return;
		if (hasRndPx()) rndPx = FixUtils.TAG_HAS_NO_VALUE;		
		rndPx = FixUtils.longValueOf(src, 0, src.length);
		hasRndPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRndPx(long src) {		
		rndPx = src;
		hasRndPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRndPx(String str) {		
		if (str == null ) return;
		if (hasRndPx()) rndPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		rndPx = FixUtils.longValueOf(src, 0, src.length);
		hasRndPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlDate() {		
		getSettlDate();		
	}		
			
	public byte[] getSettlDate() { 		
		if ( hasSettlDate()) {		
			if (hasSettlDate == FixUtils.TAG_HAS_VALUE) {		
				return settlDate; 		
			} else {

				buf.position(hasSettlDate);

			FixMessage.getTagStringValue(buf, settlDate, 0, settlDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlDate() { return hasSettlDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlDate(byte[] src) {		
		if (src == null ) return;
		if (hasSettlDate()) FixUtils.fillSpace(settlDate);		
		FixUtils.copy(settlDate, src); 		
		hasSettlDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlDate(String str) {		
		if (str == null ) return;
		if (hasSettlDate()) FixUtils.fillSpace(settlDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlDate, src); 		
		hasSettlDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackGrossTradeAmt() {		
		getGrossTradeAmt();		
	}		
			
	public long getGrossTradeAmt() { 		
		if ( hasGrossTradeAmt()) {		
			if (hasGrossTradeAmt == FixUtils.TAG_HAS_VALUE) {		
				return grossTradeAmt; 		
			} else {

				buf.position(hasGrossTradeAmt);

			grossTradeAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasGrossTradeAmt = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return grossTradeAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasGrossTradeAmt() { return hasGrossTradeAmt != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setGrossTradeAmt(byte[] src) {		
		if (src == null ) return;
		if (hasGrossTradeAmt()) grossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		grossTradeAmt = FixUtils.longValueOf(src, 0, src.length);
		hasGrossTradeAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setGrossTradeAmt(long src) {		
		grossTradeAmt = src;
		hasGrossTradeAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setGrossTradeAmt(String str) {		
		if (str == null ) return;
		if (hasGrossTradeAmt()) grossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		grossTradeAmt = FixUtils.longValueOf(src, 0, src.length);
		hasGrossTradeAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRptSys() {		
		getRptSys();		
	}		
			
	public byte[] getRptSys() { 		
		if ( hasRptSys()) {		
			if (hasRptSys == FixUtils.TAG_HAS_VALUE) {		
				return rptSys; 		
			} else {

				buf.position(hasRptSys);

			FixMessage.getTagStringValue(buf, rptSys, 0, rptSys.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRptSys = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return rptSys;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRptSys() { return hasRptSys != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRptSys(byte[] src) {		
		if (src == null ) return;
		if (hasRptSys()) FixUtils.fillSpace(rptSys);		
		FixUtils.copy(rptSys, src); 		
		hasRptSys = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRptSys(String str) {		
		if (str == null ) return;
		if (hasRptSys()) FixUtils.fillSpace(rptSys);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(rptSys, src); 		
		hasRptSys = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackFeeMultiplier() {		
		getFeeMultiplier();		
	}		
			
	public long getFeeMultiplier() { 		
		if ( hasFeeMultiplier()) {		
			if (hasFeeMultiplier == FixUtils.TAG_HAS_VALUE) {		
				return feeMultiplier; 		
			} else {

				buf.position(hasFeeMultiplier);

			feeMultiplier = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasFeeMultiplier = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return feeMultiplier;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasFeeMultiplier() { return hasFeeMultiplier != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setFeeMultiplier(byte[] src) {		
		if (src == null ) return;
		if (hasFeeMultiplier()) feeMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		feeMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasFeeMultiplier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFeeMultiplier(long src) {		
		feeMultiplier = src;
		hasFeeMultiplier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFeeMultiplier(String str) {		
		if (str == null ) return;
		if (hasFeeMultiplier()) feeMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		feeMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasFeeMultiplier = FixUtils.TAG_HAS_VALUE;		
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

					if (hasTradeReportID()) s += "TradeReportID(571)= " + new String( FixUtils.trim(getTradeReportID()) ) + "\n" ; 
		if (hasTradeID()) s += "TradeID(1003)= " + new String( FixUtils.trim(getTradeID()) ) + "\n" ; 
		if (hasSecondaryTradeID()) s += "SecondaryTradeID(1040)= " + new String( FixUtils.trim(getSecondaryTradeID()) ) + "\n" ; 
		if (hasFirmTradeID()) s += "FirmTradeID(1041)= " + new String( FixUtils.trim(getFirmTradeID()) ) + "\n" ; 
		if (hasSecondaryFirmTradeID()) s += "SecondaryFirmTradeID(1042)= " + new String( FixUtils.trim(getSecondaryFirmTradeID()) ) + "\n" ; 
		if (hasTradeReportTransType()) s += "TradeReportTransType(487)= " + getTradeReportTransType() + "\n" ; 
		if (hasTradeReportType()) s += "TradeReportType(856)= " + getTradeReportType() + "\n" ; 
		if (hasTrdType()) s += "TrdType(828)= " + getTrdType() + "\n" ; 
		if (hasTrdSubType()) s += "TrdSubType(829)= " + getTrdSubType() + "\n" ; 
		if (hasSecondaryTrdType()) s += "SecondaryTrdType(855)= " + getSecondaryTrdType() + "\n" ; 
		if (hasTradeHandlingInstr()) s += "TradeHandlingInstr(1123)= " + getTradeHandlingInstr() + "\n" ; 
		if (hasOrigTradeHandlingInstr()) s += "OrigTradeHandlingInstr(1124)= " + getOrigTradeHandlingInstr() + "\n" ; 
		if (hasOrigTradeDate()) s += "OrigTradeDate(1125)= " + new String( FixUtils.trim(getOrigTradeDate()) ) + "\n" ; 
		if (hasOrigTradeID()) s += "OrigTradeID(1126)= " + new String( FixUtils.trim(getOrigTradeID()) ) + "\n" ; 
		if (hasOrigSecondaryTradeID()) s += "OrigSecondaryTradeID(1127)= " + new String( FixUtils.trim(getOrigSecondaryTradeID()) ) + "\n" ; 
		if (hasTransferReason()) s += "TransferReason(830)= " + new String( FixUtils.trim(getTransferReason()) ) + "\n" ; 
		if (hasExecType()) s += "ExecType(150)= " + getExecType() + "\n" ; 
		if (hasTradeReportRefID()) s += "TradeReportRefID(572)= " + new String( FixUtils.trim(getTradeReportRefID()) ) + "\n" ; 
		if (hasSecondaryTradeReportRefID()) s += "SecondaryTradeReportRefID(881)= " + new String( FixUtils.trim(getSecondaryTradeReportRefID()) ) + "\n" ; 
		if (hasTrdRptStatus()) s += "TrdRptStatus(939)= " + getTrdRptStatus() + "\n" ; 
		if (hasTradeReportRejectReason()) s += "TradeReportRejectReason(751)= " + getTradeReportRejectReason() + "\n" ; 
		if (hasSecondaryTradeReportID()) s += "SecondaryTradeReportID(818)= " + new String( FixUtils.trim(getSecondaryTradeReportID()) ) + "\n" ; 
		if (hasSubscriptionRequestType()) s += "SubscriptionRequestType(263)= " + getSubscriptionRequestType() + "\n" ; 
		if (hasTradeLinkID()) s += "TradeLinkID(820)= " + new String( FixUtils.trim(getTradeLinkID()) ) + "\n" ; 
		if (hasTrdMatchID()) s += "TrdMatchID(880)= " + new String( FixUtils.trim(getTrdMatchID()) ) + "\n" ; 
		if (hasExecID()) s += "ExecID(17)= " + new String( FixUtils.trim(getExecID()) ) + "\n" ; 
		if (hasSecondaryExecID()) s += "SecondaryExecID(527)= " + new String( FixUtils.trim(getSecondaryExecID()) ) + "\n" ; 
		if (hasExecRestatementReason()) s += "ExecRestatementReason(378)= " + getExecRestatementReason() + "\n" ; 
		if (hasPreviouslyReported()) s += "PreviouslyReported(570)= " + getPreviouslyReported() + "\n" ; 
		if (hasPriceType()) s += "PriceType(423)= " + getPriceType() + "\n" ; 
		if (hasUnderlyingTradingSessionID()) s += "UnderlyingTradingSessionID(822)= " + new String( FixUtils.trim(getUnderlyingTradingSessionID()) ) + "\n" ; 
		if (hasQtyType()) s += "QtyType(854)= " + getQtyType() + "\n" ; 
		if (hasUnderlyingTradingSessionSubID()) s += "UnderlyingTradingSessionSubID(823)= " + new String( FixUtils.trim(getUnderlyingTradingSessionSubID()) ) + "\n" ; 
		if (hasLastQty()) s += "LastQty(32)= " + getLastQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastPx()) s += "LastPx(31)= " + getLastPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlSessID()) s += "SettlSessID(716)= " + new String( FixUtils.trim(getSettlSessID()) ) + "\n" ; 
		if (hasSettlSessSubID()) s += "SettlSessSubID(717)= " + new String( FixUtils.trim(getSettlSessSubID()) ) + "\n" ; 
		if (hasVenueType()) s += "VenueType(1430)= " + getVenueType() + "\n" ; 
		if (hasMarketSegmentID()) s += "MarketSegmentID(1300)= " + new String( FixUtils.trim(getMarketSegmentID()) ) + "\n" ; 
		if (hasMarketID()) s += "MarketID(1301)= " + new String( FixUtils.trim(getMarketID()) ) + "\n" ; 
		if (hasLastParPx()) s += "LastParPx(669)= " + getLastParPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastSpotRate()) s += "LastSpotRate(194)= " + getLastSpotRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastForwardPoints()) s += "LastForwardPoints(195)= " + getLastForwardPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastMkt()) s += "LastMkt(30)= " + new String( FixUtils.trim(getLastMkt()) ) + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasAvgPx()) s += "AvgPx(6)= " + getAvgPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAvgPxIndicator()) s += "AvgPxIndicator(819)= " + getAvgPxIndicator() + "\n" ; 
		if (hasMultiLegReportingType()) s += "MultiLegReportingType(442)= " + getMultiLegReportingType() + "\n" ; 
		if (hasTradeLegRefID()) s += "TradeLegRefID(824)= " + new String( FixUtils.trim(getTradeLegRefID()) ) + "\n" ; 
		if (hasCalculatedCcyLastQty()) s += "CalculatedCcyLastQty(1056)= " + getCalculatedCcyLastQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastSwapPoints()) s += "LastSwapPoints(1071)= " + getLastSwapPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasSettlCurrency()) s += "SettlCurrency(120)= " + new String( FixUtils.trim(getSettlCurrency()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasSettlType()) s += "SettlType(63)= " + new String( FixUtils.trim(getSettlType()) ) + "\n" ; 
		if (hasMatchStatus()) s += "MatchStatus(573)= " + getMatchStatus() + "\n" ; 
		if (hasMatchType()) s += "MatchType(574)= " + new String( FixUtils.trim(getMatchType()) ) + "\n" ; 
		if (hasCopyMsgIndicator()) s += "CopyMsgIndicator(797)= " + getCopyMsgIndicator() + "\n" ; 
		if (hasPublishTrdIndicator()) s += "PublishTrdIndicator(852)= " + getPublishTrdIndicator() + "\n" ; 
		if (hasShortSaleReason()) s += "ShortSaleReason(853)= " + getShortSaleReason() + "\n" ; 
		if (hasTradePublishIndicator()) s += "TradePublishIndicator(1390)= " + getTradePublishIndicator() + "\n" ; 
		if (hasResponseTransportType()) s += "ResponseTransportType(725)= " + getResponseTransportType() + "\n" ; 
		if (hasResponseDestination()) s += "ResponseDestination(726)= " + new String( FixUtils.trim(getResponseDestination()) ) + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasAsOfIndicator()) s += "AsOfIndicator(1015)= " + getAsOfIndicator() + "\n" ; 
		if (hasClearingFeeIndicator()) s += "ClearingFeeIndicator(635)= " + new String( FixUtils.trim(getClearingFeeIndicator()) ) + "\n" ; 
		if (hasTierCode()) s += "TierCode(994)= " + new String( FixUtils.trim(getTierCode()) ) + "\n" ; 
		if (hasMessageEventSource()) s += "MessageEventSource(1011)= " + new String( FixUtils.trim(getMessageEventSource()) ) + "\n" ; 
		if (hasLastUpdateTime()) s += "LastUpdateTime(779)= " + new String( FixUtils.trim(getLastUpdateTime()) ) + "\n" ; 
		if (hasRndPx()) s += "RndPx(991)= " + getRndPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasGrossTradeAmt()) s += "GrossTradeAmt(381)= " + getGrossTradeAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasRptSys()) s += "RptSys(1135)= " + new String( FixUtils.trim(getRptSys()) ) + "\n" ; 
		if (hasFeeMultiplier()) s += "FeeMultiplier(1329)= " + getFeeMultiplier() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTradeCaptureReportAck)) return false;

		FixTradeCaptureReportAck msg = (FixTradeCaptureReportAck) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasTradeReportID() && !msg.hasTradeReportID()) || (!hasTradeReportID() && msg.hasTradeReportID())) return false;
		if (!(!hasTradeReportID() && !msg.hasTradeReportID()) && !FixUtils.equals(getTradeReportID(), msg.getTradeReportID())) return false;
		if ((hasTradeID() && !msg.hasTradeID()) || (!hasTradeID() && msg.hasTradeID())) return false;
		if (!(!hasTradeID() && !msg.hasTradeID()) && !FixUtils.equals(getTradeID(), msg.getTradeID())) return false;
		if ((hasSecondaryTradeID() && !msg.hasSecondaryTradeID()) || (!hasSecondaryTradeID() && msg.hasSecondaryTradeID())) return false;
		if (!(!hasSecondaryTradeID() && !msg.hasSecondaryTradeID()) && !FixUtils.equals(getSecondaryTradeID(), msg.getSecondaryTradeID())) return false;
		if ((hasFirmTradeID() && !msg.hasFirmTradeID()) || (!hasFirmTradeID() && msg.hasFirmTradeID())) return false;
		if (!(!hasFirmTradeID() && !msg.hasFirmTradeID()) && !FixUtils.equals(getFirmTradeID(), msg.getFirmTradeID())) return false;
		if ((hasSecondaryFirmTradeID() && !msg.hasSecondaryFirmTradeID()) || (!hasSecondaryFirmTradeID() && msg.hasSecondaryFirmTradeID())) return false;
		if (!(!hasSecondaryFirmTradeID() && !msg.hasSecondaryFirmTradeID()) && !FixUtils.equals(getSecondaryFirmTradeID(), msg.getSecondaryFirmTradeID())) return false;
		if ((hasTradeReportTransType() && !msg.hasTradeReportTransType()) || (!hasTradeReportTransType() && msg.hasTradeReportTransType())) return false;
		if (!(!hasTradeReportTransType() && !msg.hasTradeReportTransType()) && !(getTradeReportTransType()==msg.getTradeReportTransType())) return false;
		if ((hasTradeReportType() && !msg.hasTradeReportType()) || (!hasTradeReportType() && msg.hasTradeReportType())) return false;
		if (!(!hasTradeReportType() && !msg.hasTradeReportType()) && !(getTradeReportType()==msg.getTradeReportType())) return false;
		if ((hasTrdType() && !msg.hasTrdType()) || (!hasTrdType() && msg.hasTrdType())) return false;
		if (!(!hasTrdType() && !msg.hasTrdType()) && !(getTrdType()==msg.getTrdType())) return false;
		if ((hasTrdSubType() && !msg.hasTrdSubType()) || (!hasTrdSubType() && msg.hasTrdSubType())) return false;
		if (!(!hasTrdSubType() && !msg.hasTrdSubType()) && !(getTrdSubType()==msg.getTrdSubType())) return false;
		if ((hasSecondaryTrdType() && !msg.hasSecondaryTrdType()) || (!hasSecondaryTrdType() && msg.hasSecondaryTrdType())) return false;
		if (!(!hasSecondaryTrdType() && !msg.hasSecondaryTrdType()) && !(getSecondaryTrdType()==msg.getSecondaryTrdType())) return false;
		if ((hasTradeHandlingInstr() && !msg.hasTradeHandlingInstr()) || (!hasTradeHandlingInstr() && msg.hasTradeHandlingInstr())) return false;
		if (!(!hasTradeHandlingInstr() && !msg.hasTradeHandlingInstr()) && !(getTradeHandlingInstr()==msg.getTradeHandlingInstr())) return false;
		if ((hasOrigTradeHandlingInstr() && !msg.hasOrigTradeHandlingInstr()) || (!hasOrigTradeHandlingInstr() && msg.hasOrigTradeHandlingInstr())) return false;
		if (!(!hasOrigTradeHandlingInstr() && !msg.hasOrigTradeHandlingInstr()) && !(getOrigTradeHandlingInstr()==msg.getOrigTradeHandlingInstr())) return false;
		if ((hasOrigTradeDate() && !msg.hasOrigTradeDate()) || (!hasOrigTradeDate() && msg.hasOrigTradeDate())) return false;
		if ((hasOrigTradeID() && !msg.hasOrigTradeID()) || (!hasOrigTradeID() && msg.hasOrigTradeID())) return false;
		if (!(!hasOrigTradeID() && !msg.hasOrigTradeID()) && !FixUtils.equals(getOrigTradeID(), msg.getOrigTradeID())) return false;
		if ((hasOrigSecondaryTradeID() && !msg.hasOrigSecondaryTradeID()) || (!hasOrigSecondaryTradeID() && msg.hasOrigSecondaryTradeID())) return false;
		if (!(!hasOrigSecondaryTradeID() && !msg.hasOrigSecondaryTradeID()) && !FixUtils.equals(getOrigSecondaryTradeID(), msg.getOrigSecondaryTradeID())) return false;
		if ((hasTransferReason() && !msg.hasTransferReason()) || (!hasTransferReason() && msg.hasTransferReason())) return false;
		if (!(!hasTransferReason() && !msg.hasTransferReason()) && !FixUtils.equals(getTransferReason(), msg.getTransferReason())) return false;
		if ((hasExecType() && !msg.hasExecType()) || (!hasExecType() && msg.hasExecType())) return false;
		if (!(!hasExecType() && !msg.hasExecType()) && !(getExecType()==msg.getExecType())) return false;
		if ((hasTradeReportRefID() && !msg.hasTradeReportRefID()) || (!hasTradeReportRefID() && msg.hasTradeReportRefID())) return false;
		if (!(!hasTradeReportRefID() && !msg.hasTradeReportRefID()) && !FixUtils.equals(getTradeReportRefID(), msg.getTradeReportRefID())) return false;
		if ((hasSecondaryTradeReportRefID() && !msg.hasSecondaryTradeReportRefID()) || (!hasSecondaryTradeReportRefID() && msg.hasSecondaryTradeReportRefID())) return false;
		if (!(!hasSecondaryTradeReportRefID() && !msg.hasSecondaryTradeReportRefID()) && !FixUtils.equals(getSecondaryTradeReportRefID(), msg.getSecondaryTradeReportRefID())) return false;
		if ((hasTrdRptStatus() && !msg.hasTrdRptStatus()) || (!hasTrdRptStatus() && msg.hasTrdRptStatus())) return false;
		if (!(!hasTrdRptStatus() && !msg.hasTrdRptStatus()) && !(getTrdRptStatus()==msg.getTrdRptStatus())) return false;
		if ((hasTradeReportRejectReason() && !msg.hasTradeReportRejectReason()) || (!hasTradeReportRejectReason() && msg.hasTradeReportRejectReason())) return false;
		if (!(!hasTradeReportRejectReason() && !msg.hasTradeReportRejectReason()) && !(getTradeReportRejectReason()==msg.getTradeReportRejectReason())) return false;
		if ((hasSecondaryTradeReportID() && !msg.hasSecondaryTradeReportID()) || (!hasSecondaryTradeReportID() && msg.hasSecondaryTradeReportID())) return false;
		if (!(!hasSecondaryTradeReportID() && !msg.hasSecondaryTradeReportID()) && !FixUtils.equals(getSecondaryTradeReportID(), msg.getSecondaryTradeReportID())) return false;
		if ((hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) || (!hasSubscriptionRequestType() && msg.hasSubscriptionRequestType())) return false;
		if (!(!hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) && !(getSubscriptionRequestType()==msg.getSubscriptionRequestType())) return false;
		if ((hasTradeLinkID() && !msg.hasTradeLinkID()) || (!hasTradeLinkID() && msg.hasTradeLinkID())) return false;
		if (!(!hasTradeLinkID() && !msg.hasTradeLinkID()) && !FixUtils.equals(getTradeLinkID(), msg.getTradeLinkID())) return false;
		if ((hasTrdMatchID() && !msg.hasTrdMatchID()) || (!hasTrdMatchID() && msg.hasTrdMatchID())) return false;
		if (!(!hasTrdMatchID() && !msg.hasTrdMatchID()) && !FixUtils.equals(getTrdMatchID(), msg.getTrdMatchID())) return false;
		if ((hasExecID() && !msg.hasExecID()) || (!hasExecID() && msg.hasExecID())) return false;
		if (!(!hasExecID() && !msg.hasExecID()) && !FixUtils.equals(getExecID(), msg.getExecID())) return false;
		if ((hasSecondaryExecID() && !msg.hasSecondaryExecID()) || (!hasSecondaryExecID() && msg.hasSecondaryExecID())) return false;
		if (!(!hasSecondaryExecID() && !msg.hasSecondaryExecID()) && !FixUtils.equals(getSecondaryExecID(), msg.getSecondaryExecID())) return false;
		if ((hasExecRestatementReason() && !msg.hasExecRestatementReason()) || (!hasExecRestatementReason() && msg.hasExecRestatementReason())) return false;
		if (!(!hasExecRestatementReason() && !msg.hasExecRestatementReason()) && !(getExecRestatementReason()==msg.getExecRestatementReason())) return false;
		if ((hasPreviouslyReported() && !msg.hasPreviouslyReported()) || (!hasPreviouslyReported() && msg.hasPreviouslyReported())) return false;
		if (!(!hasPreviouslyReported() && !msg.hasPreviouslyReported()) && !(getPreviouslyReported()==msg.getPreviouslyReported())) return false;
		if ((hasPriceType() && !msg.hasPriceType()) || (!hasPriceType() && msg.hasPriceType())) return false;
		if (!(!hasPriceType() && !msg.hasPriceType()) && !(getPriceType()==msg.getPriceType())) return false;
		if ((hasUnderlyingTradingSessionID() && !msg.hasUnderlyingTradingSessionID()) || (!hasUnderlyingTradingSessionID() && msg.hasUnderlyingTradingSessionID())) return false;
		if (!(!hasUnderlyingTradingSessionID() && !msg.hasUnderlyingTradingSessionID()) && !FixUtils.equals(getUnderlyingTradingSessionID(), msg.getUnderlyingTradingSessionID())) return false;
		if ((hasQtyType() && !msg.hasQtyType()) || (!hasQtyType() && msg.hasQtyType())) return false;
		if (!(!hasQtyType() && !msg.hasQtyType()) && !(getQtyType()==msg.getQtyType())) return false;
		if ((hasUnderlyingTradingSessionSubID() && !msg.hasUnderlyingTradingSessionSubID()) || (!hasUnderlyingTradingSessionSubID() && msg.hasUnderlyingTradingSessionSubID())) return false;
		if (!(!hasUnderlyingTradingSessionSubID() && !msg.hasUnderlyingTradingSessionSubID()) && !FixUtils.equals(getUnderlyingTradingSessionSubID(), msg.getUnderlyingTradingSessionSubID())) return false;
		if ((hasLastQty() && !msg.hasLastQty()) || (!hasLastQty() && msg.hasLastQty())) return false;
		if (!(!hasLastQty() && !msg.hasLastQty()) && !(getLastQty()==msg.getLastQty())) return false;
		if ((hasLastPx() && !msg.hasLastPx()) || (!hasLastPx() && msg.hasLastPx())) return false;
		if (!(!hasLastPx() && !msg.hasLastPx()) && !(getLastPx()==msg.getLastPx())) return false;
		if ((hasSettlSessID() && !msg.hasSettlSessID()) || (!hasSettlSessID() && msg.hasSettlSessID())) return false;
		if (!(!hasSettlSessID() && !msg.hasSettlSessID()) && !FixUtils.equals(getSettlSessID(), msg.getSettlSessID())) return false;
		if ((hasSettlSessSubID() && !msg.hasSettlSessSubID()) || (!hasSettlSessSubID() && msg.hasSettlSessSubID())) return false;
		if (!(!hasSettlSessSubID() && !msg.hasSettlSessSubID()) && !FixUtils.equals(getSettlSessSubID(), msg.getSettlSessSubID())) return false;
		if ((hasVenueType() && !msg.hasVenueType()) || (!hasVenueType() && msg.hasVenueType())) return false;
		if (!(!hasVenueType() && !msg.hasVenueType()) && !(getVenueType()==msg.getVenueType())) return false;
		if ((hasMarketSegmentID() && !msg.hasMarketSegmentID()) || (!hasMarketSegmentID() && msg.hasMarketSegmentID())) return false;
		if (!(!hasMarketSegmentID() && !msg.hasMarketSegmentID()) && !FixUtils.equals(getMarketSegmentID(), msg.getMarketSegmentID())) return false;
		if ((hasMarketID() && !msg.hasMarketID()) || (!hasMarketID() && msg.hasMarketID())) return false;
		if (!(!hasMarketID() && !msg.hasMarketID()) && !FixUtils.equals(getMarketID(), msg.getMarketID())) return false;
		if ((hasLastParPx() && !msg.hasLastParPx()) || (!hasLastParPx() && msg.hasLastParPx())) return false;
		if (!(!hasLastParPx() && !msg.hasLastParPx()) && !(getLastParPx()==msg.getLastParPx())) return false;
		if ((hasLastSpotRate() && !msg.hasLastSpotRate()) || (!hasLastSpotRate() && msg.hasLastSpotRate())) return false;
		if (!(!hasLastSpotRate() && !msg.hasLastSpotRate()) && !(getLastSpotRate()==msg.getLastSpotRate())) return false;
		if ((hasLastForwardPoints() && !msg.hasLastForwardPoints()) || (!hasLastForwardPoints() && msg.hasLastForwardPoints())) return false;
		if (!(!hasLastForwardPoints() && !msg.hasLastForwardPoints()) && !(getLastForwardPoints()==msg.getLastForwardPoints())) return false;
		if ((hasLastMkt() && !msg.hasLastMkt()) || (!hasLastMkt() && msg.hasLastMkt())) return false;
		if (!(!hasLastMkt() && !msg.hasLastMkt()) && !FixUtils.equals(getLastMkt(), msg.getLastMkt())) return false;
		if ((hasTradeDate() && !msg.hasTradeDate()) || (!hasTradeDate() && msg.hasTradeDate())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if ((hasAvgPx() && !msg.hasAvgPx()) || (!hasAvgPx() && msg.hasAvgPx())) return false;
		if (!(!hasAvgPx() && !msg.hasAvgPx()) && !(getAvgPx()==msg.getAvgPx())) return false;
		if ((hasAvgPxIndicator() && !msg.hasAvgPxIndicator()) || (!hasAvgPxIndicator() && msg.hasAvgPxIndicator())) return false;
		if (!(!hasAvgPxIndicator() && !msg.hasAvgPxIndicator()) && !(getAvgPxIndicator()==msg.getAvgPxIndicator())) return false;
		if ((hasMultiLegReportingType() && !msg.hasMultiLegReportingType()) || (!hasMultiLegReportingType() && msg.hasMultiLegReportingType())) return false;
		if (!(!hasMultiLegReportingType() && !msg.hasMultiLegReportingType()) && !(getMultiLegReportingType()==msg.getMultiLegReportingType())) return false;
		if ((hasTradeLegRefID() && !msg.hasTradeLegRefID()) || (!hasTradeLegRefID() && msg.hasTradeLegRefID())) return false;
		if (!(!hasTradeLegRefID() && !msg.hasTradeLegRefID()) && !FixUtils.equals(getTradeLegRefID(), msg.getTradeLegRefID())) return false;
		if ((hasCalculatedCcyLastQty() && !msg.hasCalculatedCcyLastQty()) || (!hasCalculatedCcyLastQty() && msg.hasCalculatedCcyLastQty())) return false;
		if (!(!hasCalculatedCcyLastQty() && !msg.hasCalculatedCcyLastQty()) && !(getCalculatedCcyLastQty()==msg.getCalculatedCcyLastQty())) return false;
		if ((hasLastSwapPoints() && !msg.hasLastSwapPoints()) || (!hasLastSwapPoints() && msg.hasLastSwapPoints())) return false;
		if (!(!hasLastSwapPoints() && !msg.hasLastSwapPoints()) && !(getLastSwapPoints()==msg.getLastSwapPoints())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasSettlCurrency() && !msg.hasSettlCurrency()) || (!hasSettlCurrency() && msg.hasSettlCurrency())) return false;
		if (!(!hasSettlCurrency() && !msg.hasSettlCurrency()) && !FixUtils.equals(getSettlCurrency(), msg.getSettlCurrency())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasSettlType() && !msg.hasSettlType()) || (!hasSettlType() && msg.hasSettlType())) return false;
		if (!(!hasSettlType() && !msg.hasSettlType()) && !FixUtils.equals(getSettlType(), msg.getSettlType())) return false;
		if ((hasMatchStatus() && !msg.hasMatchStatus()) || (!hasMatchStatus() && msg.hasMatchStatus())) return false;
		if (!(!hasMatchStatus() && !msg.hasMatchStatus()) && !(getMatchStatus()==msg.getMatchStatus())) return false;
		if ((hasMatchType() && !msg.hasMatchType()) || (!hasMatchType() && msg.hasMatchType())) return false;
		if (!(!hasMatchType() && !msg.hasMatchType()) && !FixUtils.equals(getMatchType(), msg.getMatchType())) return false;
		if ((hasCopyMsgIndicator() && !msg.hasCopyMsgIndicator()) || (!hasCopyMsgIndicator() && msg.hasCopyMsgIndicator())) return false;
		if (!(!hasCopyMsgIndicator() && !msg.hasCopyMsgIndicator()) && !(getCopyMsgIndicator()==msg.getCopyMsgIndicator())) return false;
		if ((hasPublishTrdIndicator() && !msg.hasPublishTrdIndicator()) || (!hasPublishTrdIndicator() && msg.hasPublishTrdIndicator())) return false;
		if (!(!hasPublishTrdIndicator() && !msg.hasPublishTrdIndicator()) && !(getPublishTrdIndicator()==msg.getPublishTrdIndicator())) return false;
		if ((hasShortSaleReason() && !msg.hasShortSaleReason()) || (!hasShortSaleReason() && msg.hasShortSaleReason())) return false;
		if (!(!hasShortSaleReason() && !msg.hasShortSaleReason()) && !(getShortSaleReason()==msg.getShortSaleReason())) return false;
		if ((hasTradePublishIndicator() && !msg.hasTradePublishIndicator()) || (!hasTradePublishIndicator() && msg.hasTradePublishIndicator())) return false;
		if (!(!hasTradePublishIndicator() && !msg.hasTradePublishIndicator()) && !(getTradePublishIndicator()==msg.getTradePublishIndicator())) return false;
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
		if ((hasAsOfIndicator() && !msg.hasAsOfIndicator()) || (!hasAsOfIndicator() && msg.hasAsOfIndicator())) return false;
		if (!(!hasAsOfIndicator() && !msg.hasAsOfIndicator()) && !(getAsOfIndicator()==msg.getAsOfIndicator())) return false;
		if ((hasClearingFeeIndicator() && !msg.hasClearingFeeIndicator()) || (!hasClearingFeeIndicator() && msg.hasClearingFeeIndicator())) return false;
		if (!(!hasClearingFeeIndicator() && !msg.hasClearingFeeIndicator()) && !FixUtils.equals(getClearingFeeIndicator(), msg.getClearingFeeIndicator())) return false;
		if ((hasTierCode() && !msg.hasTierCode()) || (!hasTierCode() && msg.hasTierCode())) return false;
		if (!(!hasTierCode() && !msg.hasTierCode()) && !FixUtils.equals(getTierCode(), msg.getTierCode())) return false;
		if ((hasMessageEventSource() && !msg.hasMessageEventSource()) || (!hasMessageEventSource() && msg.hasMessageEventSource())) return false;
		if (!(!hasMessageEventSource() && !msg.hasMessageEventSource()) && !FixUtils.equals(getMessageEventSource(), msg.getMessageEventSource())) return false;
		if ((hasLastUpdateTime() && !msg.hasLastUpdateTime()) || (!hasLastUpdateTime() && msg.hasLastUpdateTime())) return false;
		if ((hasRndPx() && !msg.hasRndPx()) || (!hasRndPx() && msg.hasRndPx())) return false;
		if (!(!hasRndPx() && !msg.hasRndPx()) && !(getRndPx()==msg.getRndPx())) return false;
		if ((hasSettlDate() && !msg.hasSettlDate()) || (!hasSettlDate() && msg.hasSettlDate())) return false;
		if ((hasGrossTradeAmt() && !msg.hasGrossTradeAmt()) || (!hasGrossTradeAmt() && msg.hasGrossTradeAmt())) return false;
		if (!(!hasGrossTradeAmt() && !msg.hasGrossTradeAmt()) && !(getGrossTradeAmt()==msg.getGrossTradeAmt())) return false;
		if ((hasRptSys() && !msg.hasRptSys()) || (!hasRptSys() && msg.hasRptSys())) return false;
		if (!(!hasRptSys() && !msg.hasRptSys()) && !FixUtils.equals(getRptSys(), msg.getRptSys())) return false;
		if ((hasFeeMultiplier() && !msg.hasFeeMultiplier()) || (!hasFeeMultiplier() && msg.hasFeeMultiplier())) return false;
		if (!(!hasFeeMultiplier() && !msg.hasFeeMultiplier()) && !(getFeeMultiplier()==msg.getFeeMultiplier())) return false;
		return true;
	}
	@Override
	public FixTradeCaptureReportAck clone () {
		FixTradeCaptureReportAck out = new FixTradeCaptureReportAck();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixTradeCaptureReportAck clone ( FixTradeCaptureReportAck out ) {
		if ( hasTradeReportID())
			out.setTradeReportID(getTradeReportID());
		if ( hasTradeID())
			out.setTradeID(getTradeID());
		if ( hasSecondaryTradeID())
			out.setSecondaryTradeID(getSecondaryTradeID());
		if ( hasFirmTradeID())
			out.setFirmTradeID(getFirmTradeID());
		if ( hasSecondaryFirmTradeID())
			out.setSecondaryFirmTradeID(getSecondaryFirmTradeID());
		if ( hasTradeReportTransType())
			out.setTradeReportTransType(getTradeReportTransType());
		if ( hasTradeReportType())
			out.setTradeReportType(getTradeReportType());
		if ( hasTrdType())
			out.setTrdType(getTrdType());
		if ( hasTrdSubType())
			out.setTrdSubType(getTrdSubType());
		if ( hasSecondaryTrdType())
			out.setSecondaryTrdType(getSecondaryTrdType());
		if ( hasTradeHandlingInstr())
			out.setTradeHandlingInstr(getTradeHandlingInstr());
		if ( hasOrigTradeHandlingInstr())
			out.setOrigTradeHandlingInstr(getOrigTradeHandlingInstr());
		if ( hasOrigTradeDate())
			out.setOrigTradeDate(getOrigTradeDate());
		if ( hasOrigTradeID())
			out.setOrigTradeID(getOrigTradeID());
		if ( hasOrigSecondaryTradeID())
			out.setOrigSecondaryTradeID(getOrigSecondaryTradeID());
		if ( hasTransferReason())
			out.setTransferReason(getTransferReason());
		if ( hasExecType())
			out.setExecType(getExecType());
		if ( hasTradeReportRefID())
			out.setTradeReportRefID(getTradeReportRefID());
		if ( hasSecondaryTradeReportRefID())
			out.setSecondaryTradeReportRefID(getSecondaryTradeReportRefID());
		if ( hasTrdRptStatus())
			out.setTrdRptStatus(getTrdRptStatus());
		if ( hasTradeReportRejectReason())
			out.setTradeReportRejectReason(getTradeReportRejectReason());
		if ( hasSecondaryTradeReportID())
			out.setSecondaryTradeReportID(getSecondaryTradeReportID());
		if ( hasSubscriptionRequestType())
			out.setSubscriptionRequestType(getSubscriptionRequestType());
		if ( hasTradeLinkID())
			out.setTradeLinkID(getTradeLinkID());
		if ( hasTrdMatchID())
			out.setTrdMatchID(getTrdMatchID());
		if ( hasExecID())
			out.setExecID(getExecID());
		if ( hasSecondaryExecID())
			out.setSecondaryExecID(getSecondaryExecID());
		if ( hasExecRestatementReason())
			out.setExecRestatementReason(getExecRestatementReason());
		if ( hasPreviouslyReported())
			out.setPreviouslyReported(getPreviouslyReported());
		if ( hasPriceType())
			out.setPriceType(getPriceType());
		if ( hasUnderlyingTradingSessionID())
			out.setUnderlyingTradingSessionID(getUnderlyingTradingSessionID());
		if ( hasQtyType())
			out.setQtyType(getQtyType());
		if ( hasUnderlyingTradingSessionSubID())
			out.setUnderlyingTradingSessionSubID(getUnderlyingTradingSessionSubID());
		if ( hasLastQty())
			out.setLastQty(getLastQty());
		if ( hasLastPx())
			out.setLastPx(getLastPx());
		if ( hasSettlSessID())
			out.setSettlSessID(getSettlSessID());
		if ( hasSettlSessSubID())
			out.setSettlSessSubID(getSettlSessSubID());
		if ( hasVenueType())
			out.setVenueType(getVenueType());
		if ( hasMarketSegmentID())
			out.setMarketSegmentID(getMarketSegmentID());
		if ( hasMarketID())
			out.setMarketID(getMarketID());
		if ( hasLastParPx())
			out.setLastParPx(getLastParPx());
		if ( hasLastSpotRate())
			out.setLastSpotRate(getLastSpotRate());
		if ( hasLastForwardPoints())
			out.setLastForwardPoints(getLastForwardPoints());
		if ( hasLastMkt())
			out.setLastMkt(getLastMkt());
		if ( hasTradeDate())
			out.setTradeDate(getTradeDate());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasAvgPx())
			out.setAvgPx(getAvgPx());
		if ( hasAvgPxIndicator())
			out.setAvgPxIndicator(getAvgPxIndicator());
		if ( hasMultiLegReportingType())
			out.setMultiLegReportingType(getMultiLegReportingType());
		if ( hasTradeLegRefID())
			out.setTradeLegRefID(getTradeLegRefID());
		if ( hasCalculatedCcyLastQty())
			out.setCalculatedCcyLastQty(getCalculatedCcyLastQty());
		if ( hasLastSwapPoints())
			out.setLastSwapPoints(getLastSwapPoints());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasSettlCurrency())
			out.setSettlCurrency(getSettlCurrency());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasSettlType())
			out.setSettlType(getSettlType());
		if ( hasMatchStatus())
			out.setMatchStatus(getMatchStatus());
		if ( hasMatchType())
			out.setMatchType(getMatchType());
		if ( hasCopyMsgIndicator())
			out.setCopyMsgIndicator(getCopyMsgIndicator());
		if ( hasPublishTrdIndicator())
			out.setPublishTrdIndicator(getPublishTrdIndicator());
		if ( hasShortSaleReason())
			out.setShortSaleReason(getShortSaleReason());
		if ( hasTradePublishIndicator())
			out.setTradePublishIndicator(getTradePublishIndicator());
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
		if ( hasAsOfIndicator())
			out.setAsOfIndicator(getAsOfIndicator());
		if ( hasClearingFeeIndicator())
			out.setClearingFeeIndicator(getClearingFeeIndicator());
		if ( hasTierCode())
			out.setTierCode(getTierCode());
		if ( hasMessageEventSource())
			out.setMessageEventSource(getMessageEventSource());
		if ( hasLastUpdateTime())
			out.setLastUpdateTime(getLastUpdateTime());
		if ( hasRndPx())
			out.setRndPx(getRndPx());
		if ( hasSettlDate())
			out.setSettlDate(getSettlDate());
		if ( hasGrossTradeAmt())
			out.setGrossTradeAmt(getGrossTradeAmt());
		if ( hasRptSys())
			out.setRptSys(getRptSys());
		if ( hasFeeMultiplier())
			out.setFeeMultiplier(getFeeMultiplier());
		int count = 0;
		count = 0;
		for (FixRootParties fixRootParties : rootParties) {
			if (!fixRootParties.hasGroup()) continue;
			out.rootParties[count] = fixRootParties.clone( out.rootParties[count] );
			count++;
		}
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		count = 0;
		for (FixTrdInstrmtLegGrp fixTrdInstrmtLegGrp : trdInstrmtLegGrp) {
			if (!fixTrdInstrmtLegGrp.hasGroup()) continue;
			out.trdInstrmtLegGrp[count] = fixTrdInstrmtLegGrp.clone( out.trdInstrmtLegGrp[count] );
			count++;
		}
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		count = 0;
		for (FixTrdRepIndicatorsGrp fixTrdRepIndicatorsGrp : trdRepIndicatorsGrp) {
			if (!fixTrdRepIndicatorsGrp.hasGroup()) continue;
			out.trdRepIndicatorsGrp[count] = fixTrdRepIndicatorsGrp.clone( out.trdRepIndicatorsGrp[count] );
			count++;
		}
		count = 0;
		for (FixTrdRegTimestamps fixTrdRegTimestamps : trdRegTimestamps) {
			if (!fixTrdRegTimestamps.hasGroup()) continue;
			out.trdRegTimestamps[count] = fixTrdRegTimestamps.clone( out.trdRegTimestamps[count] );
			count++;
		}
		count = 0;
		for (FixPositionAmountData fixPositionAmountData : positionAmountData) {
			if (!fixPositionAmountData.hasGroup()) continue;
			out.positionAmountData[count] = fixPositionAmountData.clone( out.positionAmountData[count] );
			count++;
		}
		count = 0;
		for (FixTrdCapRptAckSideGrp fixTrdCapRptAckSideGrp : trdCapRptAckSideGrp) {
			if (!fixTrdCapRptAckSideGrp.hasGroup()) continue;
			out.trdCapRptAckSideGrp[count] = fixTrdCapRptAckSideGrp.clone( out.trdCapRptAckSideGrp[count] );
			count++;
		}
		return out;
	}

}
