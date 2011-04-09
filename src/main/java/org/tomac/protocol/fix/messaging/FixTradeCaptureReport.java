package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixTradeCaptureReport extends FixInMessage {
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
	private short hasTrdRptStatus;
	long trdRptStatus = 0;		
	private short hasTradeRequestID;
	byte[] tradeRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
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
	private short hasTotNumTradeReports;
	long totNumTradeReports = 0;		
	private short hasLastRptRequested;
		boolean lastRptRequested = false;		
	private short hasUnsolicitedIndicator;
		boolean unsolicitedIndicator = false;		
	private short hasSubscriptionRequestType;
	byte subscriptionRequestType = (byte)' ';		
	private short hasTradeReportRefID;
	byte[] tradeReportRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryTradeReportRefID;
	byte[] secondaryTradeReportRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryTradeReportID;
	byte[] secondaryTradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
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
	private short hasAsOfIndicator;
	byte asOfIndicator = (byte)' ';		
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
	private short hasQtyType;
	long qtyType = 0;		
	private short hasUnderlyingTradingSessionID;
	byte[] underlyingTradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingTradingSessionSubID;
	byte[] underlyingTradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLastQty;
	long lastQty = 0;		
	private short hasLastPx;
	long lastPx = 0;		
	private short hasCalculatedCcyLastQty;
	long calculatedCcyLastQty = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasSettlCurrency;
	byte[] settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasLastParPx;
	long lastParPx = 0;		
	private short hasLastSpotRate;
	long lastSpotRate = 0;		
	private short hasLastForwardPoints;
	long lastForwardPoints = 0;		
	private short hasLastSwapPoints;
	long lastSwapPoints = 0;		
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
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasSettlType;
	byte[] settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlDate;
	byte[] settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingSettlementDate;
	byte[] underlyingSettlementDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMatchStatus;
	byte matchStatus = (byte)' ';		
	private short hasMatchType;
	byte[] matchType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasVolatility;
	long volatility = 0;		
	private short hasDividendYield;
	long dividendYield = 0;		
	private short hasRiskFreeRate;
	long riskFreeRate = 0;		
	private short hasCurrencyRatio;
	long currencyRatio = 0;		
	private short hasCopyMsgIndicator;
		boolean copyMsgIndicator = false;		
	private short hasPublishTrdIndicator;
		boolean publishTrdIndicator = false;		
	private short hasTradePublishIndicator;
	long tradePublishIndicator = 0;		
	private short hasShortSaleReason;
	long shortSaleReason = 0;		
	private short hasTierCode;
	byte[] tierCode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMessageEventSource;
	byte[] messageEventSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLastUpdateTime;
	byte[] lastUpdateTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasRndPx;
	long rndPx = 0;		
	private short hasGrossTradeAmt;
	long grossTradeAmt = 0;		
	private short hasTZTransactTime;
	byte[] tZTransactTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasReportedPxDiff;
		boolean reportedPxDiff = false;		
	private short hasRejectText;
	byte[] rejectText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasFeeMultiplier;
	long feeMultiplier = 0;		
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixRootParties[] rootParties;
	public FixInstrument instrument;
	public FixFinancingDetails financingDetails;
	public FixYieldData yieldData;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	public FixPositionAmountData[] positionAmountData;
	public FixTrdInstrmtLegGrp[] trdInstrmtLegGrp;
	public FixTrdRegTimestamps[] trdRegTimestamps;
	public FixTrdCapRptSideGrp[] trdCapRptSideGrp;
	public FixTrdRepIndicatorsGrp[] trdRepIndicatorsGrp;
	
	public FixTradeCaptureReport() {
		super(FixMessageInfo.MessageTypes.TRADECAPTUREREPORT);


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
		hasTrdRptStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeRequestID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
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
		hasTotNumTradeReports = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastRptRequested = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeReportRefID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeReportRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryTradeReportRefID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryTradeReportRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryTradeReportID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryTradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
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
		hasAsOfIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlSessID = FixUtils.TAG_HAS_NO_VALUE;		
		settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlSessSubID = FixUtils.TAG_HAS_NO_VALUE;		
		settlSessSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasVenueType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMarketSegmentID = FixUtils.TAG_HAS_NO_VALUE;		
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketID = FixUtils.TAG_HAS_NO_VALUE;		
		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQtyType = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingTradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingTradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasCalculatedCcyLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasLastParPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastSwapPoints = FixUtils.TAG_HAS_NO_VALUE;		
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
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingSettlementDate = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSettlementDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMatchStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasMatchType = FixUtils.TAG_HAS_NO_VALUE;		
		matchType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasVolatility = FixUtils.TAG_HAS_NO_VALUE;		
		hasDividendYield = FixUtils.TAG_HAS_NO_VALUE;		
		hasRiskFreeRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrencyRatio = FixUtils.TAG_HAS_NO_VALUE;		
		hasCopyMsgIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasPublishTrdIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradePublishIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasShortSaleReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasTierCode = FixUtils.TAG_HAS_NO_VALUE;		
		tierCode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMessageEventSource = FixUtils.TAG_HAS_NO_VALUE;		
		messageEventSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLastUpdateTime = FixUtils.TAG_HAS_NO_VALUE;		
		lastUpdateTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasRndPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasGrossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasTZTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		tZTransactTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasReportedPxDiff = FixUtils.TAG_HAS_NO_VALUE;		
		hasRejectText = FixUtils.TAG_HAS_NO_VALUE;		
		rejectText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasFeeMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		applicationSequenceControl = new FixApplicationSequenceControl();
		rootParties = new FixRootParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rootParties[i] = new FixRootParties();
		instrument = new FixInstrument();
		financingDetails = new FixFinancingDetails();
		yieldData = new FixYieldData();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		positionAmountData = new FixPositionAmountData[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) positionAmountData[i] = new FixPositionAmountData();
		trdInstrmtLegGrp = new FixTrdInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdInstrmtLegGrp[i] = new FixTrdInstrmtLegGrp();
		trdRegTimestamps = new FixTrdRegTimestamps[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdRegTimestamps[i] = new FixTrdRegTimestamps();
		trdCapRptSideGrp = new FixTrdCapRptSideGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdCapRptSideGrp[i] = new FixTrdCapRptSideGrp();
		trdRepIndicatorsGrp = new FixTrdRepIndicatorsGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdRepIndicatorsGrp[i] = new FixTrdRepIndicatorsGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.TRADEREPORTID_INT:		
            		hasTradeReportID = (short) buf.position();		
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
            	case FixTags.TRADEREPORTTRANSTYPE_INT:		
            		hasTradeReportTransType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREPORTTYPE_INT:		
            		hasTradeReportType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRDRPTSTATUS_INT:		
            		hasTrdRptStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREQUESTID_INT:		
            		hasTradeRequestID = (short) buf.position();		
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
            	case FixTags.SECONDARYTRDTYPE_INT:		
            		hasSecondaryTrdType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEHANDLINGINSTR_INT:		
            		hasTradeHandlingInstr = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ORIGTRADEHANDLINGINSTR_INT:		
            		hasOrigTradeHandlingInstr = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ORIGTRADEDATE_INT:		
            		hasOrigTradeDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ORIGTRADEID_INT:		
            		hasOrigTradeID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ORIGSECONDARYTRADEID_INT:		
            		hasOrigSecondaryTradeID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRANSFERREASON_INT:		
            		hasTransferReason = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXECTYPE_INT:		
            		hasExecType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TOTNUMTRADEREPORTS_INT:		
            		hasTotNumTradeReports = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LASTRPTREQUESTED_INT:		
            		hasLastRptRequested = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.UNSOLICITEDINDICATOR_INT:		
            		hasUnsolicitedIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SUBSCRIPTIONREQUESTTYPE_INT:		
            		hasSubscriptionRequestType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREPORTREFID_INT:		
            		hasTradeReportRefID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYTRADEREPORTREFID_INT:		
            		hasSecondaryTradeReportRefID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYTRADEREPORTID_INT:		
            		hasSecondaryTradeReportID = (short) buf.position();		
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
            	case FixTags.EXECID_INT:		
            		hasExecID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYEXECID_INT:		
            		hasSecondaryExecID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXECRESTATEMENTREASON_INT:		
            		hasExecRestatementReason = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PREVIOUSLYREPORTED_INT:		
            		hasPreviouslyReported = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRICETYPE_INT:		
            		hasPriceType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ASOFINDICATOR_INT:		
            		hasAsOfIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SETTLSESSID_INT:		
            		hasSettlSessID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SETTLSESSSUBID_INT:		
            		hasSettlSessSubID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.VENUETYPE_INT:		
            		hasVenueType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MARKETSEGMENTID_INT:		
            		hasMarketSegmentID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MARKETID_INT:		
            		hasMarketID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.QTYTYPE_INT:		
            		hasQtyType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.UNDERLYINGTRADINGSESSIONID_INT:		
            		hasUnderlyingTradingSessionID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.UNDERLYINGTRADINGSESSIONSUBID_INT:		
            		hasUnderlyingTradingSessionSubID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LASTQTY_INT:		
            		hasLastQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LASTPX_INT:		
            		hasLastPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CALCULATEDCCYLASTQTY_INT:		
            		hasCalculatedCcyLastQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SETTLCURRENCY_INT:		
            		hasSettlCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LASTPARPX_INT:		
            		hasLastParPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LASTSPOTRATE_INT:		
            		hasLastSpotRate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LASTFORWARDPOINTS_INT:		
            		hasLastForwardPoints = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LASTSWAPPOINTS_INT:		
            		hasLastSwapPoints = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LASTMKT_INT:		
            		hasLastMkt = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEDATE_INT:		
            		hasTradeDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.AVGPX_INT:		
            		hasAvgPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.AVGPXINDICATOR_INT:		
            		hasAvgPxIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MULTILEGREPORTINGTYPE_INT:		
            		hasMultiLegReportingType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADELEGREFID_INT:		
            		hasTradeLegRefID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SETTLTYPE_INT:		
            		hasSettlType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SETTLDATE_INT:		
            		hasSettlDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.UNDERLYINGSETTLEMENTDATE_INT:		
            		hasUnderlyingSettlementDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MATCHSTATUS_INT:		
            		hasMatchStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MATCHTYPE_INT:		
            		hasMatchType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.VOLATILITY_INT:		
            		hasVolatility = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.DIVIDENDYIELD_INT:		
            		hasDividendYield = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.RISKFREERATE_INT:		
            		hasRiskFreeRate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCYRATIO_INT:		
            		hasCurrencyRatio = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.COPYMSGINDICATOR_INT:		
            		hasCopyMsgIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PUBLISHTRDINDICATOR_INT:		
            		hasPublishTrdIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEPUBLISHINDICATOR_INT:		
            		hasTradePublishIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SHORTSALEREASON_INT:		
            		hasShortSaleReason = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TIERCODE_INT:		
            		hasTierCode = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MESSAGEEVENTSOURCE_INT:		
            		hasMessageEventSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LASTUPDATETIME_INT:		
            		hasLastUpdateTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.RNDPX_INT:		
            		hasRndPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.GROSSTRADEAMT_INT:		
            		hasGrossTradeAmt = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TZTRANSACTTIME_INT:		
            		hasTZTransactTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.REPORTEDPXDIFF_INT:		
            		hasReportedPxDiff = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.REJECTTEXT_INT:		
            		hasRejectText = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.FEEMULTIPLIER_INT:		
            		hasFeeMultiplier = (short) buf.position();		
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
        			} else if ( applicationSequenceControl.isKeyTag(tag)) {
        				tag = applicationSequenceControl.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
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
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( financingDetails.isKeyTag(tag)) {
        				tag = financingDetails.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( yieldData.isKeyTag(tag)) {
        				tag = yieldData.setBuffer( tag, buf, err);		
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
        			} else if ( spreadOrBenchmarkCurveData.isKeyTag(tag)) {
        				tag = spreadOrBenchmarkCurveData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOPOSAMT_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !positionAmountData[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOPOSAMT_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = positionAmountData[count].setBuffer( repeatingGroupTag, buf, err);	
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
        					if ( !trdInstrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOLEGS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdInstrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOTRDREGTIMESTAMPS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdRegTimestamps[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOTRDREGTIMESTAMPS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdRegTimestamps[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOSIDES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdCapRptSideGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOSIDES_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdCapRptSideGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOTRDREPINDICATORS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdRepIndicatorsGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOTRDREPINDICATORS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdRepIndicatorsGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.TRADECAPTUREREPORT_INT);
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
		if (!hasLastQty()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.LASTQTY_INT, FixMessageInfo.MessageTypes.TRADECAPTUREREPORT_INT);
			return false;
		}
		if (!hasLastPx()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.LASTPX_INT, FixMessageInfo.MessageTypes.TRADECAPTUREREPORT_INT);
			return false;
		}
		if (instrument.isRequired) instrument.hasRequiredTags(err); if (err.hasError()) return false;
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (trdCapRptSideGrp[i].hasGroup()) trdCapRptSideGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		return true;
	}
	@Override		
	public void getAll() {		
		getTradeReportID();		
		getTradeID();		
		getSecondaryTradeID();		
		getFirmTradeID();		
		getSecondaryFirmTradeID();		
		getTradeReportTransType();		
		getTradeReportType();		
		getTrdRptStatus();		
		getTradeRequestID();		
		getTrdType();		
		getTrdSubType();		
		getSecondaryTrdType();		
		getTradeHandlingInstr();		
		getOrigTradeHandlingInstr();		
		getOrigTradeDate();		
		getOrigTradeID();		
		getOrigSecondaryTradeID();		
		getTransferReason();		
		getExecType();		
		getTotNumTradeReports();		
		getLastRptRequested();		
		getUnsolicitedIndicator();		
		getSubscriptionRequestType();		
		getTradeReportRefID();		
		getSecondaryTradeReportRefID();		
		getSecondaryTradeReportID();		
		getTradeLinkID();		
		getTrdMatchID();		
		getExecID();		
		getSecondaryExecID();		
		getExecRestatementReason();		
		getPreviouslyReported();		
		getPriceType();		
		getAsOfIndicator();		
		getSettlSessID();		
		getSettlSessSubID();		
		getVenueType();		
		getMarketSegmentID();		
		getMarketID();		
		getQtyType();		
		getUnderlyingTradingSessionID();		
		getUnderlyingTradingSessionSubID();		
		getLastQty();		
		getLastPx();		
		getCalculatedCcyLastQty();		
		getCurrency();		
		getSettlCurrency();		
		getLastParPx();		
		getLastSpotRate();		
		getLastForwardPoints();		
		getLastSwapPoints();		
		getLastMkt();		
		getTradeDate();		
		getClearingBusinessDate();		
		getAvgPx();		
		getAvgPxIndicator();		
		getMultiLegReportingType();		
		getTradeLegRefID();		
		getTransactTime();		
		getSettlType();		
		getSettlDate();		
		getUnderlyingSettlementDate();		
		getMatchStatus();		
		getMatchType();		
		getVolatility();		
		getDividendYield();		
		getRiskFreeRate();		
		getCurrencyRatio();		
		getCopyMsgIndicator();		
		getPublishTrdIndicator();		
		getTradePublishIndicator();		
		getShortSaleReason();		
		getTierCode();		
		getMessageEventSource();		
		getLastUpdateTime();		
		getRndPx();		
		getGrossTradeAmt();		
		getTZTransactTime();		
		getReportedPxDiff();		
		getRejectText();		
		getFeeMultiplier();		
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
		if (hasTrdRptStatus()) {		
			out.put(FixTags.TRDRPTSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)trdRptStatus);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeRequestID()) {		
			out.put(FixTags.TRADEREQUESTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeRequestID); 		
		
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
		if (hasTotNumTradeReports()) {		
			out.put(FixTags.TOTNUMTRADEREPORTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totNumTradeReports);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastRptRequested()) {		
			out.put(FixTags.LASTRPTREQUESTED);		
		
			out.put((byte) '=');		
		
			out.put(lastRptRequested?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUnsolicitedIndicator()) {		
			out.put(FixTags.UNSOLICITEDINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(unsolicitedIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSubscriptionRequestType()) {		
			out.put(FixTags.SUBSCRIPTIONREQUESTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,subscriptionRequestType); 		
		
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
		if (hasSecondaryTradeReportID()) {		
			out.put(FixTags.SECONDARYTRADEREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryTradeReportID); 		
		
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
		if (hasAsOfIndicator()) {		
			out.put(FixTags.ASOFINDICATOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,asOfIndicator); 		
		
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
		if (hasQtyType()) {		
			out.put(FixTags.QTYTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)qtyType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUnderlyingTradingSessionID()) {		
			out.put(FixTags.UNDERLYINGTRADINGSESSIONID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,underlyingTradingSessionID); 		
		
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
		if (hasCalculatedCcyLastQty()) {		
			out.put(FixTags.CALCULATEDCCYLASTQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)calculatedCcyLastQty);
		
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
		if (hasLastSwapPoints()) {		
			out.put(FixTags.LASTSWAPPOINTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lastSwapPoints);
		
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
		if (hasSettlDate()) {		
			out.put(FixTags.SETTLDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUnderlyingSettlementDate()) {		
			out.put(FixTags.UNDERLYINGSETTLEMENTDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,underlyingSettlementDate); 		
		
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
		if (hasVolatility()) {		
			out.put(FixTags.VOLATILITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)volatility);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDividendYield()) {		
			out.put(FixTags.DIVIDENDYIELD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)dividendYield);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRiskFreeRate()) {		
			out.put(FixTags.RISKFREERATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)riskFreeRate);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrencyRatio()) {		
			out.put(FixTags.CURRENCYRATIO);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)currencyRatio);
		
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
		if (hasTradePublishIndicator()) {		
			out.put(FixTags.TRADEPUBLISHINDICATOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)tradePublishIndicator);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasShortSaleReason()) {		
			out.put(FixTags.SHORTSALEREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)shortSaleReason);
		
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
		if (hasGrossTradeAmt()) {		
			out.put(FixTags.GROSSTRADEAMT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)grossTradeAmt);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTZTransactTime()) {		
			out.put(FixTags.TZTRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tZTransactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasReportedPxDiff()) {		
			out.put(FixTags.REPORTEDPXDIFF);		
		
			out.put((byte) '=');		
		
			out.put(reportedPxDiff?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRejectText()) {		
			out.put(FixTags.REJECTTEXT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,rejectText); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasFeeMultiplier()) {		
			out.put(FixTags.FEEMULTIPLIER);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)feeMultiplier);
		
			out.put(FixUtils.SOH);		
		}		
		
		applicationSequenceControl.encode(out);
		if (FixUtils.getNoInGroup(rootParties)>0) {
			out.put(FixTags.NOROOTPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(rootParties));

			out.put(FixUtils.SOH);

		}
		for (FixRootParties fixRootParties : rootParties) if (fixRootParties.hasGroup()) fixRootParties.encode(out);
		instrument.encode(out);
		financingDetails.encode(out);
		yieldData.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		spreadOrBenchmarkCurveData.encode(out);
		if (FixUtils.getNoInGroup(positionAmountData)>0) {
			out.put(FixTags.NOPOSAMT);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(positionAmountData));

			out.put(FixUtils.SOH);

		}
		for (FixPositionAmountData fixPositionAmountData : positionAmountData) if (fixPositionAmountData.hasGroup()) fixPositionAmountData.encode(out);
		if (FixUtils.getNoInGroup(trdInstrmtLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdInstrmtLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTrdInstrmtLegGrp fixTrdInstrmtLegGrp : trdInstrmtLegGrp) if (fixTrdInstrmtLegGrp.hasGroup()) fixTrdInstrmtLegGrp.encode(out);
		if (FixUtils.getNoInGroup(trdRegTimestamps)>0) {
			out.put(FixTags.NOTRDREGTIMESTAMPS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdRegTimestamps));

			out.put(FixUtils.SOH);

		}
		for (FixTrdRegTimestamps fixTrdRegTimestamps : trdRegTimestamps) if (fixTrdRegTimestamps.hasGroup()) fixTrdRegTimestamps.encode(out);
		if (FixUtils.getNoInGroup(trdCapRptSideGrp)>0) {
			out.put(FixTags.NOSIDES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdCapRptSideGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTrdCapRptSideGrp fixTrdCapRptSideGrp : trdCapRptSideGrp) if (fixTrdCapRptSideGrp.hasGroup()) fixTrdCapRptSideGrp.encode(out);
		if (FixUtils.getNoInGroup(trdRepIndicatorsGrp)>0) {
			out.put(FixTags.NOTRDREPINDICATORS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdRepIndicatorsGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTrdRepIndicatorsGrp fixTrdRepIndicatorsGrp : trdRepIndicatorsGrp) if (fixTrdRepIndicatorsGrp.hasGroup()) fixTrdRepIndicatorsGrp.encode(out);
		
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
		
		if (hasTrdRptStatus()) {		
			FixUtils.put(out, (long)trdRptStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeRequestID()) {		
			FixUtils.put(out,tradeRequestID); 		
		
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
		
		if (hasTotNumTradeReports()) {		
			FixUtils.put(out, (long)totNumTradeReports);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastRptRequested()) {		
			out.put(lastRptRequested?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnsolicitedIndicator()) {		
			out.put(unsolicitedIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSubscriptionRequestType()) {		
			FixUtils.put(out,subscriptionRequestType); 		
		
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
		
		if (hasSecondaryTradeReportID()) {		
			FixUtils.put(out,secondaryTradeReportID); 		
		
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
		
		if (hasAsOfIndicator()) {		
			FixUtils.put(out,asOfIndicator); 		
		
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
		
		if (hasQtyType()) {		
			FixUtils.put(out, (long)qtyType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingTradingSessionID()) {		
			FixUtils.put(out,underlyingTradingSessionID); 		
		
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
		
		if (hasCalculatedCcyLastQty()) {		
			FixUtils.put(out, (long)calculatedCcyLastQty);
		
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
		
		if (hasLastSwapPoints()) {		
			FixUtils.put(out, (long)lastSwapPoints);
		
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
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlType()) {		
			FixUtils.put(out,settlType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlDate()) {		
			FixUtils.put(out,settlDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSettlementDate()) {		
			FixUtils.put(out,underlyingSettlementDate); 		
		
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
		
		if (hasVolatility()) {		
			FixUtils.put(out, (long)volatility);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDividendYield()) {		
			FixUtils.put(out, (long)dividendYield);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskFreeRate()) {		
			FixUtils.put(out, (long)riskFreeRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrencyRatio()) {		
			FixUtils.put(out, (long)currencyRatio);
		
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
		
		if (hasTradePublishIndicator()) {		
			FixUtils.put(out, (long)tradePublishIndicator);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasShortSaleReason()) {		
			FixUtils.put(out, (long)shortSaleReason);
		
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
		
		if (hasGrossTradeAmt()) {		
			FixUtils.put(out, (long)grossTradeAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTZTransactTime()) {		
			FixUtils.put(out,tZTransactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasReportedPxDiff()) {		
			out.put(reportedPxDiff?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRejectText()) {		
			FixUtils.put(out,rejectText); 		
		
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
			
	public void crackTradeReportTransType() {		
		getTradeReportTransType();		
	}		
			
	public long getTradeReportTransType() { 		
		if ( hasTradeReportTransType()) {		
			if (hasTradeReportTransType == FixUtils.TAG_HAS_VALUE) {		
				return tradeReportTransType; 		
			} else {

				buf.position(hasTradeReportTransType);

			tradeReportTransType = FixUtils.getTagIntValue(buf, err);
		
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

			tradeReportType = FixUtils.getTagIntValue(buf, err);
		
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
			
	public void crackTrdRptStatus() {		
		getTrdRptStatus();		
	}		
			
	public long getTrdRptStatus() { 		
		if ( hasTrdRptStatus()) {		
			if (hasTrdRptStatus == FixUtils.TAG_HAS_VALUE) {		
				return trdRptStatus; 		
			} else {

				buf.position(hasTrdRptStatus);

			trdRptStatus = FixUtils.getTagIntValue(buf, err);
		
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
			
	public void crackOrigTradeHandlingInstr() {		
		getOrigTradeHandlingInstr();		
	}		
			
	public byte getOrigTradeHandlingInstr() { 		
		if ( hasOrigTradeHandlingInstr()) {		
			if (hasOrigTradeHandlingInstr == FixUtils.TAG_HAS_VALUE) {		
				return origTradeHandlingInstr; 		
			} else {

				buf.position(hasOrigTradeHandlingInstr);

			origTradeHandlingInstr = FixUtils.getTagCharValue(buf, err);
		
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

			FixUtils.getTagStringValue(buf, origTradeDate, 0, origTradeDate.length, err);
		
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
		if (hasOrigTradeDate()) FixUtils.fillNul(origTradeDate);		
		FixUtils.copy(origTradeDate, src); 		
		hasOrigTradeDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigTradeDate(String str) {		
		if (str == null ) return;
		if (hasOrigTradeDate()) FixUtils.fillNul(origTradeDate);		
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

			FixUtils.getTagStringValue(buf, origTradeID, 0, origTradeID.length, err);
		
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
		if (hasOrigTradeID()) FixUtils.fillNul(origTradeID);		
		FixUtils.copy(origTradeID, src); 		
		hasOrigTradeID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigTradeID(String str) {		
		if (str == null ) return;
		if (hasOrigTradeID()) FixUtils.fillNul(origTradeID);		
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

			FixUtils.getTagStringValue(buf, origSecondaryTradeID, 0, origSecondaryTradeID.length, err);
		
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
		if (hasOrigSecondaryTradeID()) FixUtils.fillNul(origSecondaryTradeID);		
		FixUtils.copy(origSecondaryTradeID, src); 		
		hasOrigSecondaryTradeID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigSecondaryTradeID(String str) {		
		if (str == null ) return;
		if (hasOrigSecondaryTradeID()) FixUtils.fillNul(origSecondaryTradeID);		
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
			
	public void crackTotNumTradeReports() {		
		getTotNumTradeReports();		
	}		
			
	public long getTotNumTradeReports() { 		
		if ( hasTotNumTradeReports()) {		
			if (hasTotNumTradeReports == FixUtils.TAG_HAS_VALUE) {		
				return totNumTradeReports; 		
			} else {

				buf.position(hasTotNumTradeReports);

			totNumTradeReports = FixUtils.getTagIntValue(buf, err);
		
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
			
	public void crackLastRptRequested() {		
		getLastRptRequested();		
	}		
			
	public boolean getLastRptRequested() { 		
		if ( hasLastRptRequested()) {		
			if (hasLastRptRequested == FixUtils.TAG_HAS_VALUE) {		
				return lastRptRequested; 		
			} else {

				buf.position(hasLastRptRequested);

			lastRptRequested = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasLastRptRequested = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastRptRequested;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasLastRptRequested() { return hasLastRptRequested != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastRptRequested(byte[] src) {		
		if (src == null ) return;
		if (hasLastRptRequested()) lastRptRequested = false;		
		lastRptRequested = src[0]==(byte)'Y'?true:false;		
		hasLastRptRequested = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastRptRequested(boolean src) {		
		lastRptRequested = src;
		hasLastRptRequested = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastRptRequested(String str) {		
		if (str == null ) return;
		if (hasLastRptRequested()) lastRptRequested = false;		
		byte[] src = str.getBytes(); 		
		lastRptRequested = src[0]==(byte)'Y'?true:false;		
		hasLastRptRequested = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackUnsolicitedIndicator() {		
		getUnsolicitedIndicator();		
	}		
			
	public boolean getUnsolicitedIndicator() { 		
		if ( hasUnsolicitedIndicator()) {		
			if (hasUnsolicitedIndicator == FixUtils.TAG_HAS_VALUE) {		
				return unsolicitedIndicator; 		
			} else {

				buf.position(hasUnsolicitedIndicator);

			unsolicitedIndicator = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasUnsolicitedIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return unsolicitedIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasUnsolicitedIndicator() { return hasUnsolicitedIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUnsolicitedIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasUnsolicitedIndicator()) unsolicitedIndicator = false;		
		unsolicitedIndicator = src[0]==(byte)'Y'?true:false;		
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnsolicitedIndicator(boolean src) {		
		unsolicitedIndicator = src;
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnsolicitedIndicator(String str) {		
		if (str == null ) return;
		if (hasUnsolicitedIndicator()) unsolicitedIndicator = false;		
		byte[] src = str.getBytes(); 		
		unsolicitedIndicator = src[0]==(byte)'Y'?true:false;		
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackTradeReportRefID() {		
		getTradeReportRefID();		
	}		
			
	public byte[] getTradeReportRefID() { 		
		if ( hasTradeReportRefID()) {		
			if (hasTradeReportRefID == FixUtils.TAG_HAS_VALUE) {		
				return tradeReportRefID; 		
			} else {

				buf.position(hasTradeReportRefID);

			FixUtils.getTagStringValue(buf, tradeReportRefID, 0, tradeReportRefID.length, err);
		
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
		if (hasTradeReportRefID()) FixUtils.fillNul(tradeReportRefID);		
		FixUtils.copy(tradeReportRefID, src); 		
		hasTradeReportRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeReportRefID(String str) {		
		if (str == null ) return;
		if (hasTradeReportRefID()) FixUtils.fillNul(tradeReportRefID);		
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

			FixUtils.getTagStringValue(buf, secondaryTradeReportRefID, 0, secondaryTradeReportRefID.length, err);
		
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
		if (hasSecondaryTradeReportRefID()) FixUtils.fillNul(secondaryTradeReportRefID);		
		FixUtils.copy(secondaryTradeReportRefID, src); 		
		hasSecondaryTradeReportRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryTradeReportRefID(String str) {		
		if (str == null ) return;
		if (hasSecondaryTradeReportRefID()) FixUtils.fillNul(secondaryTradeReportRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryTradeReportRefID, src); 		
		hasSecondaryTradeReportRefID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackSecondaryExecID() {		
		getSecondaryExecID();		
	}		
			
	public byte[] getSecondaryExecID() { 		
		if ( hasSecondaryExecID()) {		
			if (hasSecondaryExecID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryExecID; 		
			} else {

				buf.position(hasSecondaryExecID);

			FixUtils.getTagStringValue(buf, secondaryExecID, 0, secondaryExecID.length, err);
		
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
		if (hasSecondaryExecID()) FixUtils.fillNul(secondaryExecID);		
		FixUtils.copy(secondaryExecID, src); 		
		hasSecondaryExecID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryExecID(String str) {		
		if (str == null ) return;
		if (hasSecondaryExecID()) FixUtils.fillNul(secondaryExecID);		
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

			execRestatementReason = FixUtils.getTagIntValue(buf, err);
		
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

			previouslyReported = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
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

			priceType = FixUtils.getTagIntValue(buf, err);
		
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
			
	public void crackAsOfIndicator() {		
		getAsOfIndicator();		
	}		
			
	public byte getAsOfIndicator() { 		
		if ( hasAsOfIndicator()) {		
			if (hasAsOfIndicator == FixUtils.TAG_HAS_VALUE) {		
				return asOfIndicator; 		
			} else {

				buf.position(hasAsOfIndicator);

			asOfIndicator = FixUtils.getTagCharValue(buf, err);
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
			
	public void crackSettlSessID() {		
		getSettlSessID();		
	}		
			
	public byte[] getSettlSessID() { 		
		if ( hasSettlSessID()) {		
			if (hasSettlSessID == FixUtils.TAG_HAS_VALUE) {		
				return settlSessID; 		
			} else {

				buf.position(hasSettlSessID);

			FixUtils.getTagStringValue(buf, settlSessID, 0, settlSessID.length, err);
		
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
		if (hasSettlSessID()) FixUtils.fillNul(settlSessID);		
		FixUtils.copy(settlSessID, src); 		
		hasSettlSessID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlSessID(String str) {		
		if (str == null ) return;
		if (hasSettlSessID()) FixUtils.fillNul(settlSessID);		
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

			FixUtils.getTagStringValue(buf, settlSessSubID, 0, settlSessSubID.length, err);
		
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
		if (hasSettlSessSubID()) FixUtils.fillNul(settlSessSubID);		
		FixUtils.copy(settlSessSubID, src); 		
		hasSettlSessSubID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlSessSubID(String str) {		
		if (str == null ) return;
		if (hasSettlSessSubID()) FixUtils.fillNul(settlSessSubID);		
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

			venueType = FixUtils.getTagCharValue(buf, err);
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

			FixUtils.getTagStringValue(buf, marketSegmentID, 0, marketSegmentID.length, err);
		
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
			
	public void crackMarketID() {		
		getMarketID();		
	}		
			
	public byte[] getMarketID() { 		
		if ( hasMarketID()) {		
			if (hasMarketID == FixUtils.TAG_HAS_VALUE) {		
				return marketID; 		
			} else {

				buf.position(hasMarketID);

			FixUtils.getTagStringValue(buf, marketID, 0, marketID.length, err);
		
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
			
	public void crackQtyType() {		
		getQtyType();		
	}		
			
	public long getQtyType() { 		
		if ( hasQtyType()) {		
			if (hasQtyType == FixUtils.TAG_HAS_VALUE) {		
				return qtyType; 		
			} else {

				buf.position(hasQtyType);

			qtyType = FixUtils.getTagIntValue(buf, err);
		
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
			
	public void crackUnderlyingTradingSessionID() {		
		getUnderlyingTradingSessionID();		
	}		
			
	public byte[] getUnderlyingTradingSessionID() { 		
		if ( hasUnderlyingTradingSessionID()) {		
			if (hasUnderlyingTradingSessionID == FixUtils.TAG_HAS_VALUE) {		
				return underlyingTradingSessionID; 		
			} else {

				buf.position(hasUnderlyingTradingSessionID);

			FixUtils.getTagStringValue(buf, underlyingTradingSessionID, 0, underlyingTradingSessionID.length, err);
		
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
		if (hasUnderlyingTradingSessionID()) FixUtils.fillNul(underlyingTradingSessionID);		
		FixUtils.copy(underlyingTradingSessionID, src); 		
		hasUnderlyingTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingTradingSessionID(String str) {		
		if (str == null ) return;
		if (hasUnderlyingTradingSessionID()) FixUtils.fillNul(underlyingTradingSessionID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingTradingSessionID, src); 		
		hasUnderlyingTradingSessionID = FixUtils.TAG_HAS_VALUE;		
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

			FixUtils.getTagStringValue(buf, underlyingTradingSessionSubID, 0, underlyingTradingSessionSubID.length, err);
		
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
		if (hasUnderlyingTradingSessionSubID()) FixUtils.fillNul(underlyingTradingSessionSubID);		
		FixUtils.copy(underlyingTradingSessionSubID, src); 		
		hasUnderlyingTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingTradingSessionSubID(String str) {		
		if (str == null ) return;
		if (hasUnderlyingTradingSessionSubID()) FixUtils.fillNul(underlyingTradingSessionSubID);		
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

			lastQty = FixUtils.getTagFloatValue(buf, err);
		
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

			lastPx = FixUtils.getTagFloatValue(buf, err);
		
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
			
	public void crackCalculatedCcyLastQty() {		
		getCalculatedCcyLastQty();		
	}		
			
	public long getCalculatedCcyLastQty() { 		
		if ( hasCalculatedCcyLastQty()) {		
			if (hasCalculatedCcyLastQty == FixUtils.TAG_HAS_VALUE) {		
				return calculatedCcyLastQty; 		
			} else {

				buf.position(hasCalculatedCcyLastQty);

			calculatedCcyLastQty = FixUtils.getTagFloatValue(buf, err);
		
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
			
	public void crackCurrency() {		
		getCurrency();		
	}		
			
	public byte[] getCurrency() { 		
		if ( hasCurrency()) {		
			if (hasCurrency == FixUtils.TAG_HAS_VALUE) {		
				return currency; 		
			} else {

				buf.position(hasCurrency);

			FixUtils.getTagStringValue(buf, currency, 0, currency.length, err);
		
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
			
	public void crackSettlCurrency() {		
		getSettlCurrency();		
	}		
			
	public byte[] getSettlCurrency() { 		
		if ( hasSettlCurrency()) {		
			if (hasSettlCurrency == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrency; 		
			} else {

				buf.position(hasSettlCurrency);

			FixUtils.getTagStringValue(buf, settlCurrency, 0, settlCurrency.length, err);
		
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
		if (hasSettlCurrency()) FixUtils.fillNul(settlCurrency);		
		FixUtils.copy(settlCurrency, src); 		
		hasSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrency(String str) {		
		if (str == null ) return;
		if (hasSettlCurrency()) FixUtils.fillNul(settlCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlCurrency, src); 		
		hasSettlCurrency = FixUtils.TAG_HAS_VALUE;		
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

			lastParPx = FixUtils.getTagFloatValue(buf, err);
		
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

			lastSpotRate = FixUtils.getTagFloatValue(buf, err);
		
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

			lastForwardPoints = FixUtils.getTagFloatValue(buf, err);
		
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
			
	public void crackLastSwapPoints() {		
		getLastSwapPoints();		
	}		
			
	public long getLastSwapPoints() { 		
		if ( hasLastSwapPoints()) {		
			if (hasLastSwapPoints == FixUtils.TAG_HAS_VALUE) {		
				return lastSwapPoints; 		
			} else {

				buf.position(hasLastSwapPoints);

			lastSwapPoints = FixUtils.getTagFloatValue(buf, err);
		
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
			
	public void crackLastMkt() {		
		getLastMkt();		
	}		
			
	public byte[] getLastMkt() { 		
		if ( hasLastMkt()) {		
			if (hasLastMkt == FixUtils.TAG_HAS_VALUE) {		
				return lastMkt; 		
			} else {

				buf.position(hasLastMkt);

			FixUtils.getTagStringValue(buf, lastMkt, 0, lastMkt.length, err);
		
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
		if (hasLastMkt()) FixUtils.fillNul(lastMkt);		
		FixUtils.copy(lastMkt, src); 		
		hasLastMkt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastMkt(String str) {		
		if (str == null ) return;
		if (hasLastMkt()) FixUtils.fillNul(lastMkt);		
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

			FixUtils.getTagStringValue(buf, tradeDate, 0, tradeDate.length, err);
		
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
		if (hasTradeDate()) FixUtils.fillNul(tradeDate);		
		FixUtils.copy(tradeDate, src); 		
		hasTradeDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeDate(String str) {		
		if (str == null ) return;
		if (hasTradeDate()) FixUtils.fillNul(tradeDate);		
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
			
	public void crackAvgPx() {		
		getAvgPx();		
	}		
			
	public long getAvgPx() { 		
		if ( hasAvgPx()) {		
			if (hasAvgPx == FixUtils.TAG_HAS_VALUE) {		
				return avgPx; 		
			} else {

				buf.position(hasAvgPx);

			avgPx = FixUtils.getTagFloatValue(buf, err);
		
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

			avgPxIndicator = FixUtils.getTagIntValue(buf, err);
		
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
			
	public void crackTradeLegRefID() {		
		getTradeLegRefID();		
	}		
			
	public byte[] getTradeLegRefID() { 		
		if ( hasTradeLegRefID()) {		
			if (hasTradeLegRefID == FixUtils.TAG_HAS_VALUE) {		
				return tradeLegRefID; 		
			} else {

				buf.position(hasTradeLegRefID);

			FixUtils.getTagStringValue(buf, tradeLegRefID, 0, tradeLegRefID.length, err);
		
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
		if (hasTradeLegRefID()) FixUtils.fillNul(tradeLegRefID);		
		FixUtils.copy(tradeLegRefID, src); 		
		hasTradeLegRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeLegRefID(String str) {		
		if (str == null ) return;
		if (hasTradeLegRefID()) FixUtils.fillNul(tradeLegRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeLegRefID, src); 		
		hasTradeLegRefID = FixUtils.TAG_HAS_VALUE;		
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

			FixUtils.getTagStringValue(buf, transactTime, 0, transactTime.length, err);
		
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
			
	public void crackSettlType() {		
		getSettlType();		
	}		
			
	public byte[] getSettlType() { 		
		if ( hasSettlType()) {		
			if (hasSettlType == FixUtils.TAG_HAS_VALUE) {		
				return settlType; 		
			} else {

				buf.position(hasSettlType);

			FixUtils.getTagStringValue(buf, settlType, 0, settlType.length, err);
		
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
		if (hasSettlType()) FixUtils.fillNul(settlType);		
		FixUtils.copy(settlType, src); 		
		hasSettlType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlType(String str) {		
		if (str == null ) return;
		if (hasSettlType()) FixUtils.fillNul(settlType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlType, src); 		
		hasSettlType = FixUtils.TAG_HAS_VALUE;		
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

			FixUtils.getTagStringValue(buf, settlDate, 0, settlDate.length, err);
		
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
		if (hasSettlDate()) FixUtils.fillNul(settlDate);		
		FixUtils.copy(settlDate, src); 		
		hasSettlDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlDate(String str) {		
		if (str == null ) return;
		if (hasSettlDate()) FixUtils.fillNul(settlDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlDate, src); 		
		hasSettlDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackUnderlyingSettlementDate() {		
		getUnderlyingSettlementDate();		
	}		
			
	public byte[] getUnderlyingSettlementDate() { 		
		if ( hasUnderlyingSettlementDate()) {		
			if (hasUnderlyingSettlementDate == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSettlementDate; 		
			} else {

				buf.position(hasUnderlyingSettlementDate);

			FixUtils.getTagStringValue(buf, underlyingSettlementDate, 0, underlyingSettlementDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasUnderlyingSettlementDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return underlyingSettlementDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSettlementDate() { return hasUnderlyingSettlementDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUnderlyingSettlementDate(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSettlementDate()) FixUtils.fillNul(underlyingSettlementDate);		
		FixUtils.copy(underlyingSettlementDate, src); 		
		hasUnderlyingSettlementDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingSettlementDate(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSettlementDate()) FixUtils.fillNul(underlyingSettlementDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSettlementDate, src); 		
		hasUnderlyingSettlementDate = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackMatchType() {		
		getMatchType();		
	}		
			
	public byte[] getMatchType() { 		
		if ( hasMatchType()) {		
			if (hasMatchType == FixUtils.TAG_HAS_VALUE) {		
				return matchType; 		
			} else {

				buf.position(hasMatchType);

			FixUtils.getTagStringValue(buf, matchType, 0, matchType.length, err);
		
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
		if (hasMatchType()) FixUtils.fillNul(matchType);		
		FixUtils.copy(matchType, src); 		
		hasMatchType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMatchType(String str) {		
		if (str == null ) return;
		if (hasMatchType()) FixUtils.fillNul(matchType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(matchType, src); 		
		hasMatchType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackVolatility() {		
		getVolatility();		
	}		
			
	public long getVolatility() { 		
		if ( hasVolatility()) {		
			if (hasVolatility == FixUtils.TAG_HAS_VALUE) {		
				return volatility; 		
			} else {

				buf.position(hasVolatility);

			volatility = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasVolatility = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return volatility;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasVolatility() { return hasVolatility != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setVolatility(byte[] src) {		
		if (src == null ) return;
		if (hasVolatility()) volatility = FixUtils.TAG_HAS_NO_VALUE;		
		volatility = FixUtils.longValueOf(src, 0, src.length);
		hasVolatility = FixUtils.TAG_HAS_VALUE;		
	}

	public void setVolatility(long src) {		
		volatility = src;
		hasVolatility = FixUtils.TAG_HAS_VALUE;		
	}

	public void setVolatility(String str) {		
		if (str == null ) return;
		if (hasVolatility()) volatility = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		volatility = FixUtils.longValueOf(src, 0, src.length);
		hasVolatility = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDividendYield() {		
		getDividendYield();		
	}		
			
	public long getDividendYield() { 		
		if ( hasDividendYield()) {		
			if (hasDividendYield == FixUtils.TAG_HAS_VALUE) {		
				return dividendYield; 		
			} else {

				buf.position(hasDividendYield);

			dividendYield = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasDividendYield = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return dividendYield;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDividendYield() { return hasDividendYield != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDividendYield(byte[] src) {		
		if (src == null ) return;
		if (hasDividendYield()) dividendYield = FixUtils.TAG_HAS_NO_VALUE;		
		dividendYield = FixUtils.longValueOf(src, 0, src.length);
		hasDividendYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDividendYield(long src) {		
		dividendYield = src;
		hasDividendYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDividendYield(String str) {		
		if (str == null ) return;
		if (hasDividendYield()) dividendYield = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		dividendYield = FixUtils.longValueOf(src, 0, src.length);
		hasDividendYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRiskFreeRate() {		
		getRiskFreeRate();		
	}		
			
	public long getRiskFreeRate() { 		
		if ( hasRiskFreeRate()) {		
			if (hasRiskFreeRate == FixUtils.TAG_HAS_VALUE) {		
				return riskFreeRate; 		
			} else {

				buf.position(hasRiskFreeRate);

			riskFreeRate = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasRiskFreeRate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return riskFreeRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRiskFreeRate() { return hasRiskFreeRate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRiskFreeRate(byte[] src) {		
		if (src == null ) return;
		if (hasRiskFreeRate()) riskFreeRate = FixUtils.TAG_HAS_NO_VALUE;		
		riskFreeRate = FixUtils.longValueOf(src, 0, src.length);
		hasRiskFreeRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRiskFreeRate(long src) {		
		riskFreeRate = src;
		hasRiskFreeRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRiskFreeRate(String str) {		
		if (str == null ) return;
		if (hasRiskFreeRate()) riskFreeRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		riskFreeRate = FixUtils.longValueOf(src, 0, src.length);
		hasRiskFreeRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCurrencyRatio() {		
		getCurrencyRatio();		
	}		
			
	public long getCurrencyRatio() { 		
		if ( hasCurrencyRatio()) {		
			if (hasCurrencyRatio == FixUtils.TAG_HAS_VALUE) {		
				return currencyRatio; 		
			} else {

				buf.position(hasCurrencyRatio);

			currencyRatio = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCurrencyRatio = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return currencyRatio;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCurrencyRatio() { return hasCurrencyRatio != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCurrencyRatio(byte[] src) {		
		if (src == null ) return;
		if (hasCurrencyRatio()) currencyRatio = FixUtils.TAG_HAS_NO_VALUE;		
		currencyRatio = FixUtils.longValueOf(src, 0, src.length);
		hasCurrencyRatio = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCurrencyRatio(long src) {		
		currencyRatio = src;
		hasCurrencyRatio = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCurrencyRatio(String str) {		
		if (str == null ) return;
		if (hasCurrencyRatio()) currencyRatio = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		currencyRatio = FixUtils.longValueOf(src, 0, src.length);
		hasCurrencyRatio = FixUtils.TAG_HAS_VALUE;		
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

			copyMsgIndicator = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
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

			publishTrdIndicator = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
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
			
	public void crackTradePublishIndicator() {		
		getTradePublishIndicator();		
	}		
			
	public long getTradePublishIndicator() { 		
		if ( hasTradePublishIndicator()) {		
			if (hasTradePublishIndicator == FixUtils.TAG_HAS_VALUE) {		
				return tradePublishIndicator; 		
			} else {

				buf.position(hasTradePublishIndicator);

			tradePublishIndicator = FixUtils.getTagIntValue(buf, err);
		
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
			
	public void crackShortSaleReason() {		
		getShortSaleReason();		
	}		
			
	public long getShortSaleReason() { 		
		if ( hasShortSaleReason()) {		
			if (hasShortSaleReason == FixUtils.TAG_HAS_VALUE) {		
				return shortSaleReason; 		
			} else {

				buf.position(hasShortSaleReason);

			shortSaleReason = FixUtils.getTagIntValue(buf, err);
		
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
			
	public void crackTierCode() {		
		getTierCode();		
	}		
			
	public byte[] getTierCode() { 		
		if ( hasTierCode()) {		
			if (hasTierCode == FixUtils.TAG_HAS_VALUE) {		
				return tierCode; 		
			} else {

				buf.position(hasTierCode);

			FixUtils.getTagStringValue(buf, tierCode, 0, tierCode.length, err);
		
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
		if (hasTierCode()) FixUtils.fillNul(tierCode);		
		FixUtils.copy(tierCode, src); 		
		hasTierCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTierCode(String str) {		
		if (str == null ) return;
		if (hasTierCode()) FixUtils.fillNul(tierCode);		
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
			
	public void crackLastUpdateTime() {		
		getLastUpdateTime();		
	}		
			
	public byte[] getLastUpdateTime() { 		
		if ( hasLastUpdateTime()) {		
			if (hasLastUpdateTime == FixUtils.TAG_HAS_VALUE) {		
				return lastUpdateTime; 		
			} else {

				buf.position(hasLastUpdateTime);

			FixUtils.getTagStringValue(buf, lastUpdateTime, 0, lastUpdateTime.length, err);
		
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
		if (hasLastUpdateTime()) FixUtils.fillNul(lastUpdateTime);		
		FixUtils.copy(lastUpdateTime, src); 		
		hasLastUpdateTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastUpdateTime(String str) {		
		if (str == null ) return;
		if (hasLastUpdateTime()) FixUtils.fillNul(lastUpdateTime);		
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

			rndPx = FixUtils.getTagFloatValue(buf, err);
		
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
			
	public void crackGrossTradeAmt() {		
		getGrossTradeAmt();		
	}		
			
	public long getGrossTradeAmt() { 		
		if ( hasGrossTradeAmt()) {		
			if (hasGrossTradeAmt == FixUtils.TAG_HAS_VALUE) {		
				return grossTradeAmt; 		
			} else {

				buf.position(hasGrossTradeAmt);

			grossTradeAmt = FixUtils.getTagFloatValue(buf, err);
		
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
			
	public void crackTZTransactTime() {		
		getTZTransactTime();		
	}		
			
	public byte[] getTZTransactTime() { 		
		if ( hasTZTransactTime()) {		
			if (hasTZTransactTime == FixUtils.TAG_HAS_VALUE) {		
				return tZTransactTime; 		
			} else {

				buf.position(hasTZTransactTime);

			FixUtils.getTagStringValue(buf, tZTransactTime, 0, tZTransactTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTZTransactTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tZTransactTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTZTransactTime() { return hasTZTransactTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTZTransactTime(byte[] src) {		
		if (src == null ) return;
		if (hasTZTransactTime()) FixUtils.fillNul(tZTransactTime);		
		FixUtils.copy(tZTransactTime, src); 		
		hasTZTransactTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTZTransactTime(String str) {		
		if (str == null ) return;
		if (hasTZTransactTime()) FixUtils.fillNul(tZTransactTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tZTransactTime, src); 		
		hasTZTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackReportedPxDiff() {		
		getReportedPxDiff();		
	}		
			
	public boolean getReportedPxDiff() { 		
		if ( hasReportedPxDiff()) {		
			if (hasReportedPxDiff == FixUtils.TAG_HAS_VALUE) {		
				return reportedPxDiff; 		
			} else {

				buf.position(hasReportedPxDiff);

			reportedPxDiff = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasReportedPxDiff = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return reportedPxDiff;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasReportedPxDiff() { return hasReportedPxDiff != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setReportedPxDiff(byte[] src) {		
		if (src == null ) return;
		if (hasReportedPxDiff()) reportedPxDiff = false;		
		reportedPxDiff = src[0]==(byte)'Y'?true:false;		
		hasReportedPxDiff = FixUtils.TAG_HAS_VALUE;		
	}

	public void setReportedPxDiff(boolean src) {		
		reportedPxDiff = src;
		hasReportedPxDiff = FixUtils.TAG_HAS_VALUE;		
	}

	public void setReportedPxDiff(String str) {		
		if (str == null ) return;
		if (hasReportedPxDiff()) reportedPxDiff = false;		
		byte[] src = str.getBytes(); 		
		reportedPxDiff = src[0]==(byte)'Y'?true:false;		
		hasReportedPxDiff = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRejectText() {		
		getRejectText();		
	}		
			
	public byte[] getRejectText() { 		
		if ( hasRejectText()) {		
			if (hasRejectText == FixUtils.TAG_HAS_VALUE) {		
				return rejectText; 		
			} else {

				buf.position(hasRejectText);

			FixUtils.getTagStringValue(buf, rejectText, 0, rejectText.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRejectText = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return rejectText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRejectText() { return hasRejectText != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRejectText(byte[] src) {		
		if (src == null ) return;
		if (hasRejectText()) FixUtils.fillNul(rejectText);		
		FixUtils.copy(rejectText, src); 		
		hasRejectText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRejectText(String str) {		
		if (str == null ) return;
		if (hasRejectText()) FixUtils.fillNul(rejectText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(rejectText, src); 		
		hasRejectText = FixUtils.TAG_HAS_VALUE;		
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

			feeMultiplier = FixUtils.getTagFloatValue(buf, err);
		
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
		if (hasTrdRptStatus()) s += "TrdRptStatus(939)= " + getTrdRptStatus() + "\n" ; 
		if (hasTradeRequestID()) s += "TradeRequestID(568)= " + new String( FixUtils.trim(getTradeRequestID()) ) + "\n" ; 
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
		if (hasTotNumTradeReports()) s += "TotNumTradeReports(748)= " + getTotNumTradeReports() + "\n" ; 
		if (hasLastRptRequested()) s += "LastRptRequested(912)= " + getLastRptRequested() + "\n" ; 
		if (hasUnsolicitedIndicator()) s += "UnsolicitedIndicator(325)= " + getUnsolicitedIndicator() + "\n" ; 
		if (hasSubscriptionRequestType()) s += "SubscriptionRequestType(263)= " + getSubscriptionRequestType() + "\n" ; 
		if (hasTradeReportRefID()) s += "TradeReportRefID(572)= " + new String( FixUtils.trim(getTradeReportRefID()) ) + "\n" ; 
		if (hasSecondaryTradeReportRefID()) s += "SecondaryTradeReportRefID(881)= " + new String( FixUtils.trim(getSecondaryTradeReportRefID()) ) + "\n" ; 
		if (hasSecondaryTradeReportID()) s += "SecondaryTradeReportID(818)= " + new String( FixUtils.trim(getSecondaryTradeReportID()) ) + "\n" ; 
		if (hasTradeLinkID()) s += "TradeLinkID(820)= " + new String( FixUtils.trim(getTradeLinkID()) ) + "\n" ; 
		if (hasTrdMatchID()) s += "TrdMatchID(880)= " + new String( FixUtils.trim(getTrdMatchID()) ) + "\n" ; 
		if (hasExecID()) s += "ExecID(17)= " + new String( FixUtils.trim(getExecID()) ) + "\n" ; 
		if (hasSecondaryExecID()) s += "SecondaryExecID(527)= " + new String( FixUtils.trim(getSecondaryExecID()) ) + "\n" ; 
		if (hasExecRestatementReason()) s += "ExecRestatementReason(378)= " + getExecRestatementReason() + "\n" ; 
		if (hasPreviouslyReported()) s += "PreviouslyReported(570)= " + getPreviouslyReported() + "\n" ; 
		if (hasPriceType()) s += "PriceType(423)= " + getPriceType() + "\n" ; 
		if (hasAsOfIndicator()) s += "AsOfIndicator(1015)= " + getAsOfIndicator() + "\n" ; 
		if (hasSettlSessID()) s += "SettlSessID(716)= " + new String( FixUtils.trim(getSettlSessID()) ) + "\n" ; 
		if (hasSettlSessSubID()) s += "SettlSessSubID(717)= " + new String( FixUtils.trim(getSettlSessSubID()) ) + "\n" ; 
		if (hasVenueType()) s += "VenueType(1430)= " + getVenueType() + "\n" ; 
		if (hasMarketSegmentID()) s += "MarketSegmentID(1300)= " + new String( FixUtils.trim(getMarketSegmentID()) ) + "\n" ; 
		if (hasMarketID()) s += "MarketID(1301)= " + new String( FixUtils.trim(getMarketID()) ) + "\n" ; 
		if (hasQtyType()) s += "QtyType(854)= " + getQtyType() + "\n" ; 
		if (hasUnderlyingTradingSessionID()) s += "UnderlyingTradingSessionID(822)= " + new String( FixUtils.trim(getUnderlyingTradingSessionID()) ) + "\n" ; 
		if (hasUnderlyingTradingSessionSubID()) s += "UnderlyingTradingSessionSubID(823)= " + new String( FixUtils.trim(getUnderlyingTradingSessionSubID()) ) + "\n" ; 
		if (hasLastQty()) s += "LastQty(32)= " + getLastQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastPx()) s += "LastPx(31)= " + getLastPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCalculatedCcyLastQty()) s += "CalculatedCcyLastQty(1056)= " + getCalculatedCcyLastQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasSettlCurrency()) s += "SettlCurrency(120)= " + new String( FixUtils.trim(getSettlCurrency()) ) + "\n" ; 
		if (hasLastParPx()) s += "LastParPx(669)= " + getLastParPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastSpotRate()) s += "LastSpotRate(194)= " + getLastSpotRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastForwardPoints()) s += "LastForwardPoints(195)= " + getLastForwardPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastSwapPoints()) s += "LastSwapPoints(1071)= " + getLastSwapPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastMkt()) s += "LastMkt(30)= " + new String( FixUtils.trim(getLastMkt()) ) + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasAvgPx()) s += "AvgPx(6)= " + getAvgPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAvgPxIndicator()) s += "AvgPxIndicator(819)= " + getAvgPxIndicator() + "\n" ; 
		if (hasMultiLegReportingType()) s += "MultiLegReportingType(442)= " + getMultiLegReportingType() + "\n" ; 
		if (hasTradeLegRefID()) s += "TradeLegRefID(824)= " + new String( FixUtils.trim(getTradeLegRefID()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasSettlType()) s += "SettlType(63)= " + new String( FixUtils.trim(getSettlType()) ) + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasUnderlyingSettlementDate()) s += "UnderlyingSettlementDate(987)= " + new String( FixUtils.trim(getUnderlyingSettlementDate()) ) + "\n" ; 
		if (hasMatchStatus()) s += "MatchStatus(573)= " + getMatchStatus() + "\n" ; 
		if (hasMatchType()) s += "MatchType(574)= " + new String( FixUtils.trim(getMatchType()) ) + "\n" ; 
		if (hasVolatility()) s += "Volatility(1188)= " + getVolatility() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDividendYield()) s += "DividendYield(1380)= " + getDividendYield() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasRiskFreeRate()) s += "RiskFreeRate(1190)= " + getRiskFreeRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCurrencyRatio()) s += "CurrencyRatio(1382)= " + getCurrencyRatio() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCopyMsgIndicator()) s += "CopyMsgIndicator(797)= " + getCopyMsgIndicator() + "\n" ; 
		if (hasPublishTrdIndicator()) s += "PublishTrdIndicator(852)= " + getPublishTrdIndicator() + "\n" ; 
		if (hasTradePublishIndicator()) s += "TradePublishIndicator(1390)= " + getTradePublishIndicator() + "\n" ; 
		if (hasShortSaleReason()) s += "ShortSaleReason(853)= " + getShortSaleReason() + "\n" ; 
		if (hasTierCode()) s += "TierCode(994)= " + new String( FixUtils.trim(getTierCode()) ) + "\n" ; 
		if (hasMessageEventSource()) s += "MessageEventSource(1011)= " + new String( FixUtils.trim(getMessageEventSource()) ) + "\n" ; 
		if (hasLastUpdateTime()) s += "LastUpdateTime(779)= " + new String( FixUtils.trim(getLastUpdateTime()) ) + "\n" ; 
		if (hasRndPx()) s += "RndPx(991)= " + getRndPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasGrossTradeAmt()) s += "GrossTradeAmt(381)= " + getGrossTradeAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTZTransactTime()) s += "TZTransactTime(1132)= " + new String( FixUtils.trim(getTZTransactTime()) ) + "\n" ; 
		if (hasReportedPxDiff()) s += "ReportedPxDiff(1134)= " + getReportedPxDiff() + "\n" ; 
		if (hasRejectText()) s += "RejectText(1328)= " + new String( FixUtils.trim(getRejectText()) ) + "\n" ; 
		if (hasFeeMultiplier()) s += "FeeMultiplier(1329)= " + getFeeMultiplier() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTradeCaptureReport)) return false;

		FixTradeCaptureReport msg = (FixTradeCaptureReport) o;

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
		if ((hasTrdRptStatus() && !msg.hasTrdRptStatus()) || (!hasTrdRptStatus() && msg.hasTrdRptStatus())) return false;
		if (!(!hasTrdRptStatus() && !msg.hasTrdRptStatus()) && !(getTrdRptStatus()==msg.getTrdRptStatus())) return false;
		if ((hasTradeRequestID() && !msg.hasTradeRequestID()) || (!hasTradeRequestID() && msg.hasTradeRequestID())) return false;
		if (!(!hasTradeRequestID() && !msg.hasTradeRequestID()) && !FixUtils.equals(getTradeRequestID(), msg.getTradeRequestID())) return false;
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
		if ((hasTotNumTradeReports() && !msg.hasTotNumTradeReports()) || (!hasTotNumTradeReports() && msg.hasTotNumTradeReports())) return false;
		if (!(!hasTotNumTradeReports() && !msg.hasTotNumTradeReports()) && !(getTotNumTradeReports()==msg.getTotNumTradeReports())) return false;
		if ((hasLastRptRequested() && !msg.hasLastRptRequested()) || (!hasLastRptRequested() && msg.hasLastRptRequested())) return false;
		if (!(!hasLastRptRequested() && !msg.hasLastRptRequested()) && !(getLastRptRequested()==msg.getLastRptRequested())) return false;
		if ((hasUnsolicitedIndicator() && !msg.hasUnsolicitedIndicator()) || (!hasUnsolicitedIndicator() && msg.hasUnsolicitedIndicator())) return false;
		if (!(!hasUnsolicitedIndicator() && !msg.hasUnsolicitedIndicator()) && !(getUnsolicitedIndicator()==msg.getUnsolicitedIndicator())) return false;
		if ((hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) || (!hasSubscriptionRequestType() && msg.hasSubscriptionRequestType())) return false;
		if (!(!hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) && !(getSubscriptionRequestType()==msg.getSubscriptionRequestType())) return false;
		if ((hasTradeReportRefID() && !msg.hasTradeReportRefID()) || (!hasTradeReportRefID() && msg.hasTradeReportRefID())) return false;
		if (!(!hasTradeReportRefID() && !msg.hasTradeReportRefID()) && !FixUtils.equals(getTradeReportRefID(), msg.getTradeReportRefID())) return false;
		if ((hasSecondaryTradeReportRefID() && !msg.hasSecondaryTradeReportRefID()) || (!hasSecondaryTradeReportRefID() && msg.hasSecondaryTradeReportRefID())) return false;
		if (!(!hasSecondaryTradeReportRefID() && !msg.hasSecondaryTradeReportRefID()) && !FixUtils.equals(getSecondaryTradeReportRefID(), msg.getSecondaryTradeReportRefID())) return false;
		if ((hasSecondaryTradeReportID() && !msg.hasSecondaryTradeReportID()) || (!hasSecondaryTradeReportID() && msg.hasSecondaryTradeReportID())) return false;
		if (!(!hasSecondaryTradeReportID() && !msg.hasSecondaryTradeReportID()) && !FixUtils.equals(getSecondaryTradeReportID(), msg.getSecondaryTradeReportID())) return false;
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
		if ((hasAsOfIndicator() && !msg.hasAsOfIndicator()) || (!hasAsOfIndicator() && msg.hasAsOfIndicator())) return false;
		if (!(!hasAsOfIndicator() && !msg.hasAsOfIndicator()) && !(getAsOfIndicator()==msg.getAsOfIndicator())) return false;
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
		if ((hasQtyType() && !msg.hasQtyType()) || (!hasQtyType() && msg.hasQtyType())) return false;
		if (!(!hasQtyType() && !msg.hasQtyType()) && !(getQtyType()==msg.getQtyType())) return false;
		if ((hasUnderlyingTradingSessionID() && !msg.hasUnderlyingTradingSessionID()) || (!hasUnderlyingTradingSessionID() && msg.hasUnderlyingTradingSessionID())) return false;
		if (!(!hasUnderlyingTradingSessionID() && !msg.hasUnderlyingTradingSessionID()) && !FixUtils.equals(getUnderlyingTradingSessionID(), msg.getUnderlyingTradingSessionID())) return false;
		if ((hasUnderlyingTradingSessionSubID() && !msg.hasUnderlyingTradingSessionSubID()) || (!hasUnderlyingTradingSessionSubID() && msg.hasUnderlyingTradingSessionSubID())) return false;
		if (!(!hasUnderlyingTradingSessionSubID() && !msg.hasUnderlyingTradingSessionSubID()) && !FixUtils.equals(getUnderlyingTradingSessionSubID(), msg.getUnderlyingTradingSessionSubID())) return false;
		if ((hasLastQty() && !msg.hasLastQty()) || (!hasLastQty() && msg.hasLastQty())) return false;
		if (!(!hasLastQty() && !msg.hasLastQty()) && !(getLastQty()==msg.getLastQty())) return false;
		if ((hasLastPx() && !msg.hasLastPx()) || (!hasLastPx() && msg.hasLastPx())) return false;
		if (!(!hasLastPx() && !msg.hasLastPx()) && !(getLastPx()==msg.getLastPx())) return false;
		if ((hasCalculatedCcyLastQty() && !msg.hasCalculatedCcyLastQty()) || (!hasCalculatedCcyLastQty() && msg.hasCalculatedCcyLastQty())) return false;
		if (!(!hasCalculatedCcyLastQty() && !msg.hasCalculatedCcyLastQty()) && !(getCalculatedCcyLastQty()==msg.getCalculatedCcyLastQty())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasSettlCurrency() && !msg.hasSettlCurrency()) || (!hasSettlCurrency() && msg.hasSettlCurrency())) return false;
		if (!(!hasSettlCurrency() && !msg.hasSettlCurrency()) && !FixUtils.equals(getSettlCurrency(), msg.getSettlCurrency())) return false;
		if ((hasLastParPx() && !msg.hasLastParPx()) || (!hasLastParPx() && msg.hasLastParPx())) return false;
		if (!(!hasLastParPx() && !msg.hasLastParPx()) && !(getLastParPx()==msg.getLastParPx())) return false;
		if ((hasLastSpotRate() && !msg.hasLastSpotRate()) || (!hasLastSpotRate() && msg.hasLastSpotRate())) return false;
		if (!(!hasLastSpotRate() && !msg.hasLastSpotRate()) && !(getLastSpotRate()==msg.getLastSpotRate())) return false;
		if ((hasLastForwardPoints() && !msg.hasLastForwardPoints()) || (!hasLastForwardPoints() && msg.hasLastForwardPoints())) return false;
		if (!(!hasLastForwardPoints() && !msg.hasLastForwardPoints()) && !(getLastForwardPoints()==msg.getLastForwardPoints())) return false;
		if ((hasLastSwapPoints() && !msg.hasLastSwapPoints()) || (!hasLastSwapPoints() && msg.hasLastSwapPoints())) return false;
		if (!(!hasLastSwapPoints() && !msg.hasLastSwapPoints()) && !(getLastSwapPoints()==msg.getLastSwapPoints())) return false;
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
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasSettlType() && !msg.hasSettlType()) || (!hasSettlType() && msg.hasSettlType())) return false;
		if (!(!hasSettlType() && !msg.hasSettlType()) && !FixUtils.equals(getSettlType(), msg.getSettlType())) return false;
		if ((hasSettlDate() && !msg.hasSettlDate()) || (!hasSettlDate() && msg.hasSettlDate())) return false;
		if ((hasUnderlyingSettlementDate() && !msg.hasUnderlyingSettlementDate()) || (!hasUnderlyingSettlementDate() && msg.hasUnderlyingSettlementDate())) return false;
		if ((hasMatchStatus() && !msg.hasMatchStatus()) || (!hasMatchStatus() && msg.hasMatchStatus())) return false;
		if (!(!hasMatchStatus() && !msg.hasMatchStatus()) && !(getMatchStatus()==msg.getMatchStatus())) return false;
		if ((hasMatchType() && !msg.hasMatchType()) || (!hasMatchType() && msg.hasMatchType())) return false;
		if (!(!hasMatchType() && !msg.hasMatchType()) && !FixUtils.equals(getMatchType(), msg.getMatchType())) return false;
		if ((hasVolatility() && !msg.hasVolatility()) || (!hasVolatility() && msg.hasVolatility())) return false;
		if (!(!hasVolatility() && !msg.hasVolatility()) && !(getVolatility()==msg.getVolatility())) return false;
		if ((hasDividendYield() && !msg.hasDividendYield()) || (!hasDividendYield() && msg.hasDividendYield())) return false;
		if (!(!hasDividendYield() && !msg.hasDividendYield()) && !(getDividendYield()==msg.getDividendYield())) return false;
		if ((hasRiskFreeRate() && !msg.hasRiskFreeRate()) || (!hasRiskFreeRate() && msg.hasRiskFreeRate())) return false;
		if (!(!hasRiskFreeRate() && !msg.hasRiskFreeRate()) && !(getRiskFreeRate()==msg.getRiskFreeRate())) return false;
		if ((hasCurrencyRatio() && !msg.hasCurrencyRatio()) || (!hasCurrencyRatio() && msg.hasCurrencyRatio())) return false;
		if (!(!hasCurrencyRatio() && !msg.hasCurrencyRatio()) && !(getCurrencyRatio()==msg.getCurrencyRatio())) return false;
		if ((hasCopyMsgIndicator() && !msg.hasCopyMsgIndicator()) || (!hasCopyMsgIndicator() && msg.hasCopyMsgIndicator())) return false;
		if (!(!hasCopyMsgIndicator() && !msg.hasCopyMsgIndicator()) && !(getCopyMsgIndicator()==msg.getCopyMsgIndicator())) return false;
		if ((hasPublishTrdIndicator() && !msg.hasPublishTrdIndicator()) || (!hasPublishTrdIndicator() && msg.hasPublishTrdIndicator())) return false;
		if (!(!hasPublishTrdIndicator() && !msg.hasPublishTrdIndicator()) && !(getPublishTrdIndicator()==msg.getPublishTrdIndicator())) return false;
		if ((hasTradePublishIndicator() && !msg.hasTradePublishIndicator()) || (!hasTradePublishIndicator() && msg.hasTradePublishIndicator())) return false;
		if (!(!hasTradePublishIndicator() && !msg.hasTradePublishIndicator()) && !(getTradePublishIndicator()==msg.getTradePublishIndicator())) return false;
		if ((hasShortSaleReason() && !msg.hasShortSaleReason()) || (!hasShortSaleReason() && msg.hasShortSaleReason())) return false;
		if (!(!hasShortSaleReason() && !msg.hasShortSaleReason()) && !(getShortSaleReason()==msg.getShortSaleReason())) return false;
		if ((hasTierCode() && !msg.hasTierCode()) || (!hasTierCode() && msg.hasTierCode())) return false;
		if (!(!hasTierCode() && !msg.hasTierCode()) && !FixUtils.equals(getTierCode(), msg.getTierCode())) return false;
		if ((hasMessageEventSource() && !msg.hasMessageEventSource()) || (!hasMessageEventSource() && msg.hasMessageEventSource())) return false;
		if (!(!hasMessageEventSource() && !msg.hasMessageEventSource()) && !FixUtils.equals(getMessageEventSource(), msg.getMessageEventSource())) return false;
		if ((hasLastUpdateTime() && !msg.hasLastUpdateTime()) || (!hasLastUpdateTime() && msg.hasLastUpdateTime())) return false;
		if ((hasRndPx() && !msg.hasRndPx()) || (!hasRndPx() && msg.hasRndPx())) return false;
		if (!(!hasRndPx() && !msg.hasRndPx()) && !(getRndPx()==msg.getRndPx())) return false;
		if ((hasGrossTradeAmt() && !msg.hasGrossTradeAmt()) || (!hasGrossTradeAmt() && msg.hasGrossTradeAmt())) return false;
		if (!(!hasGrossTradeAmt() && !msg.hasGrossTradeAmt()) && !(getGrossTradeAmt()==msg.getGrossTradeAmt())) return false;
		if ((hasTZTransactTime() && !msg.hasTZTransactTime()) || (!hasTZTransactTime() && msg.hasTZTransactTime())) return false;
		if ((hasReportedPxDiff() && !msg.hasReportedPxDiff()) || (!hasReportedPxDiff() && msg.hasReportedPxDiff())) return false;
		if (!(!hasReportedPxDiff() && !msg.hasReportedPxDiff()) && !(getReportedPxDiff()==msg.getReportedPxDiff())) return false;
		if ((hasRejectText() && !msg.hasRejectText()) || (!hasRejectText() && msg.hasRejectText())) return false;
		if (!(!hasRejectText() && !msg.hasRejectText()) && !FixUtils.equals(getRejectText(), msg.getRejectText())) return false;
		if ((hasFeeMultiplier() && !msg.hasFeeMultiplier()) || (!hasFeeMultiplier() && msg.hasFeeMultiplier())) return false;
		if (!(!hasFeeMultiplier() && !msg.hasFeeMultiplier()) && !(getFeeMultiplier()==msg.getFeeMultiplier())) return false;
		return true;
	}
	@Override
	public FixTradeCaptureReport clone () {
		FixTradeCaptureReport out = new FixTradeCaptureReport();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixTradeCaptureReport clone ( FixTradeCaptureReport out ) {
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
		if ( hasTrdRptStatus())
			out.setTrdRptStatus(getTrdRptStatus());
		if ( hasTradeRequestID())
			out.setTradeRequestID(getTradeRequestID());
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
		if ( hasTotNumTradeReports())
			out.setTotNumTradeReports(getTotNumTradeReports());
		if ( hasLastRptRequested())
			out.setLastRptRequested(getLastRptRequested());
		if ( hasUnsolicitedIndicator())
			out.setUnsolicitedIndicator(getUnsolicitedIndicator());
		if ( hasSubscriptionRequestType())
			out.setSubscriptionRequestType(getSubscriptionRequestType());
		if ( hasTradeReportRefID())
			out.setTradeReportRefID(getTradeReportRefID());
		if ( hasSecondaryTradeReportRefID())
			out.setSecondaryTradeReportRefID(getSecondaryTradeReportRefID());
		if ( hasSecondaryTradeReportID())
			out.setSecondaryTradeReportID(getSecondaryTradeReportID());
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
		if ( hasAsOfIndicator())
			out.setAsOfIndicator(getAsOfIndicator());
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
		if ( hasQtyType())
			out.setQtyType(getQtyType());
		if ( hasUnderlyingTradingSessionID())
			out.setUnderlyingTradingSessionID(getUnderlyingTradingSessionID());
		if ( hasUnderlyingTradingSessionSubID())
			out.setUnderlyingTradingSessionSubID(getUnderlyingTradingSessionSubID());
		if ( hasLastQty())
			out.setLastQty(getLastQty());
		if ( hasLastPx())
			out.setLastPx(getLastPx());
		if ( hasCalculatedCcyLastQty())
			out.setCalculatedCcyLastQty(getCalculatedCcyLastQty());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasSettlCurrency())
			out.setSettlCurrency(getSettlCurrency());
		if ( hasLastParPx())
			out.setLastParPx(getLastParPx());
		if ( hasLastSpotRate())
			out.setLastSpotRate(getLastSpotRate());
		if ( hasLastForwardPoints())
			out.setLastForwardPoints(getLastForwardPoints());
		if ( hasLastSwapPoints())
			out.setLastSwapPoints(getLastSwapPoints());
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
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasSettlType())
			out.setSettlType(getSettlType());
		if ( hasSettlDate())
			out.setSettlDate(getSettlDate());
		if ( hasUnderlyingSettlementDate())
			out.setUnderlyingSettlementDate(getUnderlyingSettlementDate());
		if ( hasMatchStatus())
			out.setMatchStatus(getMatchStatus());
		if ( hasMatchType())
			out.setMatchType(getMatchType());
		if ( hasVolatility())
			out.setVolatility(getVolatility());
		if ( hasDividendYield())
			out.setDividendYield(getDividendYield());
		if ( hasRiskFreeRate())
			out.setRiskFreeRate(getRiskFreeRate());
		if ( hasCurrencyRatio())
			out.setCurrencyRatio(getCurrencyRatio());
		if ( hasCopyMsgIndicator())
			out.setCopyMsgIndicator(getCopyMsgIndicator());
		if ( hasPublishTrdIndicator())
			out.setPublishTrdIndicator(getPublishTrdIndicator());
		if ( hasTradePublishIndicator())
			out.setTradePublishIndicator(getTradePublishIndicator());
		if ( hasShortSaleReason())
			out.setShortSaleReason(getShortSaleReason());
		if ( hasTierCode())
			out.setTierCode(getTierCode());
		if ( hasMessageEventSource())
			out.setMessageEventSource(getMessageEventSource());
		if ( hasLastUpdateTime())
			out.setLastUpdateTime(getLastUpdateTime());
		if ( hasRndPx())
			out.setRndPx(getRndPx());
		if ( hasGrossTradeAmt())
			out.setGrossTradeAmt(getGrossTradeAmt());
		if ( hasTZTransactTime())
			out.setTZTransactTime(getTZTransactTime());
		if ( hasReportedPxDiff())
			out.setReportedPxDiff(getReportedPxDiff());
		if ( hasRejectText())
			out.setRejectText(getRejectText());
		if ( hasFeeMultiplier())
			out.setFeeMultiplier(getFeeMultiplier());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		int count = 0;
		count = 0;
		for (FixRootParties fixRootParties : rootParties) {
			if (!fixRootParties.hasGroup()) continue;
			out.rootParties[count] = fixRootParties.clone( out.rootParties[count] );
			count++;
		}
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		if (financingDetails.hasGroup())
			out.financingDetails = financingDetails.clone( out.financingDetails);
		if (yieldData.hasGroup())
			out.yieldData = yieldData.clone( out.yieldData);
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		if (spreadOrBenchmarkCurveData.hasGroup())
			out.spreadOrBenchmarkCurveData = spreadOrBenchmarkCurveData.clone( out.spreadOrBenchmarkCurveData);
		count = 0;
		for (FixPositionAmountData fixPositionAmountData : positionAmountData) {
			if (!fixPositionAmountData.hasGroup()) continue;
			out.positionAmountData[count] = fixPositionAmountData.clone( out.positionAmountData[count] );
			count++;
		}
		count = 0;
		for (FixTrdInstrmtLegGrp fixTrdInstrmtLegGrp : trdInstrmtLegGrp) {
			if (!fixTrdInstrmtLegGrp.hasGroup()) continue;
			out.trdInstrmtLegGrp[count] = fixTrdInstrmtLegGrp.clone( out.trdInstrmtLegGrp[count] );
			count++;
		}
		count = 0;
		for (FixTrdRegTimestamps fixTrdRegTimestamps : trdRegTimestamps) {
			if (!fixTrdRegTimestamps.hasGroup()) continue;
			out.trdRegTimestamps[count] = fixTrdRegTimestamps.clone( out.trdRegTimestamps[count] );
			count++;
		}
		count = 0;
		for (FixTrdCapRptSideGrp fixTrdCapRptSideGrp : trdCapRptSideGrp) {
			if (!fixTrdCapRptSideGrp.hasGroup()) continue;
			out.trdCapRptSideGrp[count] = fixTrdCapRptSideGrp.clone( out.trdCapRptSideGrp[count] );
			count++;
		}
		count = 0;
		for (FixTrdRepIndicatorsGrp fixTrdRepIndicatorsGrp : trdRepIndicatorsGrp) {
			if (!fixTrdRepIndicatorsGrp.hasGroup()) continue;
			out.trdRepIndicatorsGrp[count] = fixTrdRepIndicatorsGrp.clone( out.trdRepIndicatorsGrp[count] );
			count++;
		}
		return out;
	}

}
