package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixExecutionReport extends FixInMessage {
	private short hasOrderID;
	byte[] orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryOrderID;
	byte[] secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryClOrdID;
	byte[] secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryExecID;
	byte[] secondaryExecID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrigClOrdID;
	byte[] origClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClOrdLinkID;
	byte[] clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteRespID;
	byte[] quoteRespID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrdStatusReqID;
	byte[] ordStatusReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMassStatusReqID;
	byte[] massStatusReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasHostCrossID;
	byte[] hostCrossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTotNumReports;
	long totNumReports = 0;		
	private short hasLastRptRequested;
		boolean lastRptRequested = false;		
	private short hasTradeOriginationDate;
	byte[] tradeOriginationDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasListID;
	byte[] listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCrossID;
	byte[] crossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrigCrossID;
	byte[] origCrossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCrossType;
	long crossType = 0;		
	private short hasTrdMatchID;
	byte[] trdMatchID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExecID;
	byte[] execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExecRefID;
	byte[] execRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExecType;
	byte execType = (byte)' ';		
	private short hasOrdStatus;
	byte ordStatus = (byte)' ';		
	private short hasWorkingIndicator;
		boolean workingIndicator = false;		
	private short hasOrdRejReason;
	long ordRejReason = 0;		
	private short hasExecRestatementReason;
	long execRestatementReason = 0;		
	private short hasAccount;
	byte[] account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAcctIDSource;
	long acctIDSource = 0;		
	private short hasAccountType;
	long accountType = 0;		
	private short hasDayBookingInst;
	byte dayBookingInst = (byte)' ';		
	private short hasBookingUnit;
	byte bookingUnit = (byte)' ';		
	private short hasPreallocMethod;
	byte preallocMethod = (byte)' ';		
	private short hasAllocID;
	byte[] allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlType;
	byte[] settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlDate;
	byte[] settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMatchType;
	byte[] matchType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderCategory;
	byte orderCategory = (byte)' ';		
	private short hasCashMargin;
	byte cashMargin = (byte)' ';		
	private short hasClearingFeeIndicator;
	byte[] clearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasQtyType;
	long qtyType = 0;		
	private short hasLotType;
	byte lotType = (byte)' ';		
	private short hasOrdType;
	byte ordType = (byte)' ';		
	private short hasPriceType;
	long priceType = 0;		
	private short hasPrice;
	long price = 0;		
	private short hasPriceProtectionScope;
	byte priceProtectionScope = (byte)' ';		
	private short hasStopPx;
	long stopPx = 0;		
	private short hasPeggedPrice;
	long peggedPrice = 0;		
	private short hasPeggedRefPrice;
	long peggedRefPrice = 0;		
	private short hasDiscretionPrice;
	long discretionPrice = 0;		
	private short hasTargetStrategy;
	long targetStrategy = 0;		
	private short hasTargetStrategyParameters;
	byte[] targetStrategyParameters = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasParticipationRate;
	long participationRate = 0;		
	private short hasTargetStrategyPerformance;
	long targetStrategyPerformance = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasComplianceID;
	byte[] complianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSolicitedFlag;
		boolean solicitedFlag = false;		
	private short hasTimeInForce;
	byte timeInForce = (byte)' ';		
	private short hasEffectiveTime;
	byte[] effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasExpireDate;
	byte[] expireDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExpireTime;
	byte[] expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasExecInst;
	byte[] execInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAggressorIndicator;
		boolean aggressorIndicator = false;		
	private short hasOrderCapacity;
	byte orderCapacity = (byte)' ';		
	private short hasOrderRestrictions;
	byte[] orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPreTradeAnonymity;
		boolean preTradeAnonymity = false;		
	private short hasCustOrderCapacity;
	long custOrderCapacity = 0;		
	private short hasLastQty;
	long lastQty = 0;		
	private short hasCalculatedCcyLastQty;
	long calculatedCcyLastQty = 0;		
	private short hasLastSwapPoints;
	long lastSwapPoints = 0;		
	private short hasUnderlyingLastQty;
	long underlyingLastQty = 0;		
	private short hasLastPx;
	long lastPx = 0;		
	private short hasUnderlyingLastPx;
	long underlyingLastPx = 0;		
	private short hasLastParPx;
	long lastParPx = 0;		
	private short hasLastSpotRate;
	long lastSpotRate = 0;		
	private short hasLastForwardPoints;
	long lastForwardPoints = 0;		
	private short hasLastMkt;
	byte[] lastMkt = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTimeBracket;
	byte[] timeBracket = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLastCapacity;
	byte lastCapacity = (byte)' ';		
	private short hasLeavesQty;
	long leavesQty = 0;		
	private short hasCumQty;
	long cumQty = 0;		
	private short hasAvgPx;
	long avgPx = 0;		
	private short hasDayOrderQty;
	long dayOrderQty = 0;		
	private short hasDayCumQty;
	long dayCumQty = 0;		
	private short hasDayAvgPx;
	long dayAvgPx = 0;		
	private short hasTotNoFills;
	long totNoFills = 0;		
	private short hasLastFragment;
		boolean lastFragment = false;		
	private short hasGTBookingInst;
	long gTBookingInst = 0;		
	private short hasTradeDate;
	byte[] tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasReportToExch;
		boolean reportToExch = false;		
	private short hasGrossTradeAmt;
	long grossTradeAmt = 0;		
	private short hasNumDaysInterest;
	long numDaysInterest = 0;		
	private short hasExDate;
	byte[] exDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAccruedInterestRate;
	long accruedInterestRate = 0;		
	private short hasAccruedInterestAmt;
	long accruedInterestAmt = 0;		
	private short hasInterestAtMaturity;
	long interestAtMaturity = 0;		
	private short hasEndAccruedInterestAmt;
	long endAccruedInterestAmt = 0;		
	private short hasStartCash;
	long startCash = 0;		
	private short hasEndCash;
	long endCash = 0;		
	private short hasTradedFlatSwitch;
		boolean tradedFlatSwitch = false;		
	private short hasBasisFeatureDate;
	byte[] basisFeatureDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasBasisFeaturePrice;
	long basisFeaturePrice = 0;		
	private short hasConcession;
	long concession = 0;		
	private short hasTotalTakedown;
	long totalTakedown = 0;		
	private short hasNetMoney;
	long netMoney = 0;		
	private short hasSettlCurrAmt;
	long settlCurrAmt = 0;		
	private short hasSettlCurrency;
	byte[] settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasSettlCurrFxRate;
	long settlCurrFxRate = 0;		
	private short hasSettlCurrFxRateCalc;
	byte settlCurrFxRateCalc = (byte)' ';		
	private short hasHandlInst;
	byte handlInst = (byte)' ';		
	private short hasMinQty;
	long minQty = 0;		
	private short hasMatchIncrement;
	long matchIncrement = 0;		
	private short hasMaxPriceLevels;
	long maxPriceLevels = 0;		
	private short hasMaxFloor;
	long maxFloor = 0;		
	private short hasPositionEffect;
	byte positionEffect = (byte)' ';		
	private short hasMaxShow;
	long maxShow = 0;		
	private short hasBookingType;
	long bookingType = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasSettlDate2;
	byte[] settlDate2 = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderQty2;
	long orderQty2 = 0;		
	private short hasLastForwardPoints2;
	long lastForwardPoints2 = 0;		
	private short hasMultiLegReportingType;
	byte multiLegReportingType = (byte)' ';		
	private short hasCancellationRights;
	byte cancellationRights = (byte)' ';		
	private short hasMoneyLaunderingStatus;
	byte moneyLaunderingStatus = (byte)' ';		
	private short hasRegistID;
	byte[] registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDesignation;
	byte[] designation = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTransBkdTime;
	byte[] transBkdTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasExecValuationPoint;
	byte[] execValuationPoint = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasExecPriceType;
	byte execPriceType = (byte)' ';		
	private short hasExecPriceAdjustment;
	long execPriceAdjustment = 0;		
	private short hasPriorityIndicator;
	long priorityIndicator = 0;		
	private short hasPriceImprovement;
	long priceImprovement = 0;		
	private short hasLastLiquidityInd;
	long lastLiquidityInd = 0;		
	private short hasCopyMsgIndicator;
		boolean copyMsgIndicator = false;		
	private short hasManualOrderIndicator;
		boolean manualOrderIndicator = false;		
	private short hasCustDirectedOrder;
		boolean custDirectedOrder = false;		
	private short hasReceivedDeptID;
	byte[] receivedDeptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCustOrderHandlingInst;
	byte[] custOrderHandlingInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderHandlingInstSource;
	long orderHandlingInstSource = 0;		
	private short hasDividendYield;
	long dividendYield = 0;		
	private short hasVolatility;
	long volatility = 0;		
	private short hasTimeToExpiration;
	long timeToExpiration = 0;		
	private short hasRiskFreeRate;
	long riskFreeRate = 0;		
	private short hasPriceDelta;
	long priceDelta = 0;		
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixParties[] parties;
	public FixContraGrp[] contraGrp;
	public FixPreAllocGrp[] preAllocGrp;
	public FixInstrument instrument;
	public FixFinancingDetails financingDetails;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixStipulations[] stipulations;
	public FixOrderQtyData orderQtyData;
	public FixTriggeringInstruction triggeringInstruction;
	public FixPegInstructions pegInstructions;
	public FixDiscretionInstructions discretionInstructions;
	public FixStrategyParametersGrp[] strategyParametersGrp;
	public FixFillsGrp[] fillsGrp;
	public FixCommissionData commissionData;
	public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	public FixYieldData yieldData;
	public FixRateSource[] rateSource;
	public FixDisplayInstruction displayInstruction;
	public FixContAmtGrp[] contAmtGrp;
	public FixInstrmtLegExecGrp[] instrmtLegExecGrp;
	public FixMiscFeesGrp[] miscFeesGrp;
	public FixTrdRegTimestamps[] trdRegTimestamps;
	
	public FixExecutionReport() {
		super(FixMessageInfo.MessageTypes.EXECUTIONREPORT);


		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryExecID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryExecID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrigClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		origClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClOrdLinkID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteRespID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteRespID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrdStatusReqID = FixUtils.TAG_HAS_NO_VALUE;		
		ordStatusReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMassStatusReqID = FixUtils.TAG_HAS_NO_VALUE;		
		massStatusReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasHostCrossID = FixUtils.TAG_HAS_NO_VALUE;		
		hostCrossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTotNumReports = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastRptRequested = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeOriginationDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeOriginationDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasListID = FixUtils.TAG_HAS_NO_VALUE;		
		listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCrossID = FixUtils.TAG_HAS_NO_VALUE;		
		crossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrigCrossID = FixUtils.TAG_HAS_NO_VALUE;		
		origCrossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCrossType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTrdMatchID = FixUtils.TAG_HAS_NO_VALUE;		
		trdMatchID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExecID = FixUtils.TAG_HAS_NO_VALUE;		
		execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExecRefID = FixUtils.TAG_HAS_NO_VALUE;		
		execRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExecType = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrdStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasWorkingIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrdRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasExecRestatementReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;		
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		hasDayBookingInst = FixUtils.TAG_HAS_NO_VALUE;		
		hasBookingUnit = FixUtils.TAG_HAS_NO_VALUE;		
		hasPreallocMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMatchType = FixUtils.TAG_HAS_NO_VALUE;		
		matchType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderCategory = FixUtils.TAG_HAS_NO_VALUE;		
		hasCashMargin = FixUtils.TAG_HAS_NO_VALUE;		
		hasClearingFeeIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		clearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasQtyType = FixUtils.TAG_HAS_NO_VALUE;		
		hasLotType = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceProtectionScope = FixUtils.TAG_HAS_NO_VALUE;		
		hasStopPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasPeggedPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasPeggedRefPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasDiscretionPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasTargetStrategy = FixUtils.TAG_HAS_NO_VALUE;		
		hasTargetStrategyParameters = FixUtils.TAG_HAS_NO_VALUE;		
		targetStrategyParameters = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasParticipationRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasTargetStrategyPerformance = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasComplianceID = FixUtils.TAG_HAS_NO_VALUE;		
		complianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSolicitedFlag = FixUtils.TAG_HAS_NO_VALUE;		
		hasTimeInForce = FixUtils.TAG_HAS_NO_VALUE;		
		hasEffectiveTime = FixUtils.TAG_HAS_NO_VALUE;		
		effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasExpireDate = FixUtils.TAG_HAS_NO_VALUE;		
		expireDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;		
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasExecInst = FixUtils.TAG_HAS_NO_VALUE;		
		execInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAggressorIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderRestrictions = FixUtils.TAG_HAS_NO_VALUE;		
		orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPreTradeAnonymity = FixUtils.TAG_HAS_NO_VALUE;		
		hasCustOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasCalculatedCcyLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastSwapPoints = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingLastPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastParPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastMkt = FixUtils.TAG_HAS_NO_VALUE;		
		lastMkt = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTimeBracket = FixUtils.TAG_HAS_NO_VALUE;		
		timeBracket = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLastCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasLeavesQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasCumQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasDayOrderQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasDayCumQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasDayAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotNoFills = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastFragment = FixUtils.TAG_HAS_NO_VALUE;		
		hasGTBookingInst = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasReportToExch = FixUtils.TAG_HAS_NO_VALUE;		
		hasGrossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasNumDaysInterest = FixUtils.TAG_HAS_NO_VALUE;		
		hasExDate = FixUtils.TAG_HAS_NO_VALUE;		
		exDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAccruedInterestRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasInterestAtMaturity = FixUtils.TAG_HAS_NO_VALUE;		
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasStartCash = FixUtils.TAG_HAS_NO_VALUE;		
		hasEndCash = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradedFlatSwitch = FixUtils.TAG_HAS_NO_VALUE;		
		hasBasisFeatureDate = FixUtils.TAG_HAS_NO_VALUE;		
		basisFeatureDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasBasisFeaturePrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasConcession = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotalTakedown = FixUtils.TAG_HAS_NO_VALUE;		
		hasNetMoney = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasSettlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_NO_VALUE;		
		hasHandlInst = FixUtils.TAG_HAS_NO_VALUE;		
		hasMinQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasMatchIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxPriceLevels = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxFloor = FixUtils.TAG_HAS_NO_VALUE;		
		hasPositionEffect = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxShow = FixUtils.TAG_HAS_NO_VALUE;		
		hasBookingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasSettlDate2 = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate2 = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderQty2 = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		hasMultiLegReportingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCancellationRights = FixUtils.TAG_HAS_NO_VALUE;		
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasRegistID = FixUtils.TAG_HAS_NO_VALUE;		
		registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDesignation = FixUtils.TAG_HAS_NO_VALUE;		
		designation = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTransBkdTime = FixUtils.TAG_HAS_NO_VALUE;		
		transBkdTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasExecValuationPoint = FixUtils.TAG_HAS_NO_VALUE;		
		execValuationPoint = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasExecPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasExecPriceAdjustment = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriorityIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceImprovement = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastLiquidityInd = FixUtils.TAG_HAS_NO_VALUE;		
		hasCopyMsgIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasManualOrderIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasCustDirectedOrder = FixUtils.TAG_HAS_NO_VALUE;		
		hasReceivedDeptID = FixUtils.TAG_HAS_NO_VALUE;		
		receivedDeptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCustOrderHandlingInst = FixUtils.TAG_HAS_NO_VALUE;		
		custOrderHandlingInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderHandlingInstSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasDividendYield = FixUtils.TAG_HAS_NO_VALUE;		
		hasVolatility = FixUtils.TAG_HAS_NO_VALUE;		
		hasTimeToExpiration = FixUtils.TAG_HAS_NO_VALUE;		
		hasRiskFreeRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceDelta = FixUtils.TAG_HAS_NO_VALUE;		
		applicationSequenceControl = new FixApplicationSequenceControl();
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		contraGrp = new FixContraGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) contraGrp[i] = new FixContraGrp();
		preAllocGrp = new FixPreAllocGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) preAllocGrp[i] = new FixPreAllocGrp();
		instrument = new FixInstrument();
		financingDetails = new FixFinancingDetails();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		stipulations = new FixStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) stipulations[i] = new FixStipulations();
		orderQtyData = new FixOrderQtyData();
		triggeringInstruction = new FixTriggeringInstruction();
		pegInstructions = new FixPegInstructions();
		discretionInstructions = new FixDiscretionInstructions();
		strategyParametersGrp = new FixStrategyParametersGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) strategyParametersGrp[i] = new FixStrategyParametersGrp();
		fillsGrp = new FixFillsGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) fillsGrp[i] = new FixFillsGrp();
		commissionData = new FixCommissionData();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		yieldData = new FixYieldData();
		rateSource = new FixRateSource[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rateSource[i] = new FixRateSource();
		displayInstruction = new FixDisplayInstruction();
		contAmtGrp = new FixContAmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) contAmtGrp[i] = new FixContAmtGrp();
		instrmtLegExecGrp = new FixInstrmtLegExecGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegExecGrp[i] = new FixInstrmtLegExecGrp();
		miscFeesGrp = new FixMiscFeesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) miscFeesGrp[i] = new FixMiscFeesGrp();
		trdRegTimestamps = new FixTrdRegTimestamps[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdRegTimestamps[i] = new FixTrdRegTimestamps();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.ORDERID_INT:		
            		hasOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYORDERID_INT:		
            		hasSecondaryOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYCLORDID_INT:		
            		hasSecondaryClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYEXECID_INT:		
            		hasSecondaryExecID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORIGCLORDID_INT:		
            		hasOrigClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLORDLINKID_INT:		
            		hasClOrdLinkID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QUOTERESPID_INT:		
            		hasQuoteRespID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDSTATUSREQID_INT:		
            		hasOrdStatusReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MASSSTATUSREQID_INT:		
            		hasMassStatusReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.HOSTCROSSID_INT:		
            		hasHostCrossID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TOTNUMREPORTS_INT:		
            		hasTotNumReports = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTRPTREQUESTED_INT:		
            		hasLastRptRequested = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEORIGINATIONDATE_INT:		
            		hasTradeOriginationDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LISTID_INT:		
            		hasListID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CROSSID_INT:		
            		hasCrossID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORIGCROSSID_INT:		
            		hasOrigCrossID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CROSSTYPE_INT:		
            		hasCrossType = (short) buf.position();		
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
            	case FixTags.EXECREFID_INT:		
            		hasExecRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECTYPE_INT:		
            		hasExecType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDSTATUS_INT:		
            		hasOrdStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.WORKINGINDICATOR_INT:		
            		hasWorkingIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDREJREASON_INT:		
            		hasOrdRejReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECRESTATEMENTREASON_INT:		
            		hasExecRestatementReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCOUNT_INT:		
            		hasAccount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCTIDSOURCE_INT:		
            		hasAcctIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCOUNTTYPE_INT:		
            		hasAccountType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.DAYBOOKINGINST_INT:		
            		hasDayBookingInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BOOKINGUNIT_INT:		
            		hasBookingUnit = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PREALLOCMETHOD_INT:		
            		hasPreallocMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCID_INT:		
            		hasAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLTYPE_INT:		
            		hasSettlType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLDATE_INT:		
            		hasSettlDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MATCHTYPE_INT:		
            		hasMatchType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDERCATEGORY_INT:		
            		hasOrderCategory = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CASHMARGIN_INT:		
            		hasCashMargin = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGFEEINDICATOR_INT:		
            		hasClearingFeeIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QTYTYPE_INT:		
            		hasQtyType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LOTTYPE_INT:		
            		hasLotType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDTYPE_INT:		
            		hasOrdType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRICETYPE_INT:		
            		hasPriceType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRICE_INT:		
            		hasPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRICEPROTECTIONSCOPE_INT:		
            		hasPriceProtectionScope = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.STOPPX_INT:		
            		hasStopPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PEGGEDPRICE_INT:		
            		hasPeggedPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PEGGEDREFPRICE_INT:		
            		hasPeggedRefPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.DISCRETIONPRICE_INT:		
            		hasDiscretionPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TARGETSTRATEGY_INT:		
            		hasTargetStrategy = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TARGETSTRATEGYPARAMETERS_INT:		
            		hasTargetStrategyParameters = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PARTICIPATIONRATE_INT:		
            		hasParticipationRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TARGETSTRATEGYPERFORMANCE_INT:		
            		hasTargetStrategyPerformance = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COMPLIANCEID_INT:		
            		hasComplianceID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SOLICITEDFLAG_INT:		
            		hasSolicitedFlag = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TIMEINFORCE_INT:		
            		hasTimeInForce = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EFFECTIVETIME_INT:		
            		hasEffectiveTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXPIREDATE_INT:		
            		hasExpireDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXPIRETIME_INT:		
            		hasExpireTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECINST_INT:		
            		hasExecInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AGGRESSORINDICATOR_INT:		
            		hasAggressorIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDERCAPACITY_INT:		
            		hasOrderCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDERRESTRICTIONS_INT:		
            		hasOrderRestrictions = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRETRADEANONYMITY_INT:		
            		hasPreTradeAnonymity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CUSTORDERCAPACITY_INT:		
            		hasCustOrderCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTQTY_INT:		
            		hasLastQty = (short) buf.position();		
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
            	case FixTags.UNDERLYINGLASTQTY_INT:		
            		hasUnderlyingLastQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTPX_INT:		
            		hasLastPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.UNDERLYINGLASTPX_INT:		
            		hasUnderlyingLastPx = (short) buf.position();		
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
            	case FixTags.TRADINGSESSIONID_INT:		
            		hasTradingSessionID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADINGSESSIONSUBID_INT:		
            		hasTradingSessionSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TIMEBRACKET_INT:		
            		hasTimeBracket = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTCAPACITY_INT:		
            		hasLastCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LEAVESQTY_INT:		
            		hasLeavesQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CUMQTY_INT:		
            		hasCumQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AVGPX_INT:		
            		hasAvgPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.DAYORDERQTY_INT:		
            		hasDayOrderQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.DAYCUMQTY_INT:		
            		hasDayCumQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.DAYAVGPX_INT:		
            		hasDayAvgPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TOTNOFILLS_INT:		
            		hasTotNoFills = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTFRAGMENT_INT:		
            		hasLastFragment = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.GTBOOKINGINST_INT:		
            		hasGTBookingInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEDATE_INT:		
            		hasTradeDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REPORTTOEXCH_INT:		
            		hasReportToExch = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.GROSSTRADEAMT_INT:		
            		hasGrossTradeAmt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.NUMDAYSINTEREST_INT:		
            		hasNumDaysInterest = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXDATE_INT:		
            		hasExDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCRUEDINTERESTRATE_INT:		
            		hasAccruedInterestRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCRUEDINTERESTAMT_INT:		
            		hasAccruedInterestAmt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.INTERESTATMATURITY_INT:		
            		hasInterestAtMaturity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENDACCRUEDINTERESTAMT_INT:		
            		hasEndAccruedInterestAmt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.STARTCASH_INT:		
            		hasStartCash = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENDCASH_INT:		
            		hasEndCash = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEDFLATSWITCH_INT:		
            		hasTradedFlatSwitch = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BASISFEATUREDATE_INT:		
            		hasBasisFeatureDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BASISFEATUREPRICE_INT:		
            		hasBasisFeaturePrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CONCESSION_INT:		
            		hasConcession = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TOTALTAKEDOWN_INT:		
            		hasTotalTakedown = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.NETMONEY_INT:		
            		hasNetMoney = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLCURRAMT_INT:		
            		hasSettlCurrAmt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLCURRENCY_INT:		
            		hasSettlCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLCURRFXRATE_INT:		
            		hasSettlCurrFxRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLCURRFXRATECALC_INT:		
            		hasSettlCurrFxRateCalc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.HANDLINST_INT:		
            		hasHandlInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MINQTY_INT:		
            		hasMinQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MATCHINCREMENT_INT:		
            		hasMatchIncrement = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MAXPRICELEVELS_INT:		
            		hasMaxPriceLevels = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MAXFLOOR_INT:		
            		hasMaxFloor = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.POSITIONEFFECT_INT:		
            		hasPositionEffect = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MAXSHOW_INT:		
            		hasMaxShow = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BOOKINGTYPE_INT:		
            		hasBookingType = (short) buf.position();		
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
            	case FixTags.SETTLDATE2_INT:		
            		hasSettlDate2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDERQTY2_INT:		
            		hasOrderQty2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTFORWARDPOINTS2_INT:		
            		hasLastForwardPoints2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MULTILEGREPORTINGTYPE_INT:		
            		hasMultiLegReportingType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CANCELLATIONRIGHTS_INT:		
            		hasCancellationRights = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MONEYLAUNDERINGSTATUS_INT:		
            		hasMoneyLaunderingStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REGISTID_INT:		
            		hasRegistID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.DESIGNATION_INT:		
            		hasDesignation = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSBKDTIME_INT:		
            		hasTransBkdTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECVALUATIONPOINT_INT:		
            		hasExecValuationPoint = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECPRICETYPE_INT:		
            		hasExecPriceType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECPRICEADJUSTMENT_INT:		
            		hasExecPriceAdjustment = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRIORITYINDICATOR_INT:		
            		hasPriorityIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRICEIMPROVEMENT_INT:		
            		hasPriceImprovement = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTLIQUIDITYIND_INT:		
            		hasLastLiquidityInd = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COPYMSGINDICATOR_INT:		
            		hasCopyMsgIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MANUALORDERINDICATOR_INT:		
            		hasManualOrderIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CUSTDIRECTEDORDER_INT:		
            		hasCustDirectedOrder = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RECEIVEDDEPTID_INT:		
            		hasReceivedDeptID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CUSTORDERHANDLINGINST_INT:		
            		hasCustOrderHandlingInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDERHANDLINGINSTSOURCE_INT:		
            		hasOrderHandlingInstSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.DIVIDENDYIELD_INT:		
            		hasDividendYield = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.VOLATILITY_INT:		
            		hasVolatility = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TIMETOEXPIRATION_INT:		
            		hasTimeToExpiration = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RISKFREERATE_INT:		
            		hasRiskFreeRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRICEDELTA_INT:		
            		hasPriceDelta = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !parties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOCONTRABROKERS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !contraGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = contraGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOALLOCS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !preAllocGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = preAllocGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
        			} else if ( tag == FixTags.NOSTIPULATIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !stipulations[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = stipulations[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( orderQtyData.isKeyTag(tag)) {
        				tag = orderQtyData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( triggeringInstruction.isKeyTag(tag)) {
        				tag = triggeringInstruction.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( pegInstructions.isKeyTag(tag)) {
        				tag = pegInstructions.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( discretionInstructions.isKeyTag(tag)) {
        				tag = discretionInstructions.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOSTRATEGYPARAMETERS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !strategyParametersGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = strategyParametersGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOFILLS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !fillsGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = fillsGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( commissionData.isKeyTag(tag)) {
        				tag = commissionData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( spreadOrBenchmarkCurveData.isKeyTag(tag)) {
        				tag = spreadOrBenchmarkCurveData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( yieldData.isKeyTag(tag)) {
        				tag = yieldData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NORATESOURCES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !rateSource[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = rateSource[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( displayInstruction.isKeyTag(tag)) {
        				tag = displayInstruction.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOCONTAMTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !contAmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = contAmtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
        					if ( !instrmtLegExecGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegExecGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOMISCFEES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !miscFeesGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = miscFeesGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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

		if (!hasOrderID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag OrderID missing", FixTags.ORDERID_INT, FixMessageInfo.MessageTypes.EXECUTIONREPORT);
			return false;
		}
		if (!hasExecID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ExecID missing", FixTags.EXECID_INT, FixMessageInfo.MessageTypes.EXECUTIONREPORT);
			return false;
		}
		if (!hasExecType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ExecType missing", FixTags.EXECTYPE_INT, FixMessageInfo.MessageTypes.EXECUTIONREPORT);
			return false;
		}
		if (!hasOrdStatus()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag OrdStatus missing", FixTags.ORDSTATUS_INT, FixMessageInfo.MessageTypes.EXECUTIONREPORT);
			return false;
		}
		if (!hasSide()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Side missing", FixTags.SIDE_INT, FixMessageInfo.MessageTypes.EXECUTIONREPORT);
			return false;
		}
		if (!hasLeavesQty()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag LeavesQty missing", FixTags.LEAVESQTY_INT, FixMessageInfo.MessageTypes.EXECUTIONREPORT);
			return false;
		}
		if (!hasCumQty()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag CumQty missing", FixTags.CUMQTY_INT, FixMessageInfo.MessageTypes.EXECUTIONREPORT);
			return false;
		}
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
		if (hasOrderID()) {		
			out.put(FixTags.ORDERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryOrderID()) {		
			out.put(FixTags.SECONDARYORDERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryOrderID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryClOrdID()) {		
			out.put(FixTags.SECONDARYCLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryClOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryExecID()) {		
			out.put(FixTags.SECONDARYEXECID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryExecID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrigClOrdID()) {		
			out.put(FixTags.ORIGCLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,origClOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClOrdLinkID()) {		
			out.put(FixTags.CLORDLINKID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clOrdLinkID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteRespID()) {		
			out.put(FixTags.QUOTERESPID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,quoteRespID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrdStatusReqID()) {		
			out.put(FixTags.ORDSTATUSREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,ordStatusReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMassStatusReqID()) {		
			out.put(FixTags.MASSSTATUSREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,massStatusReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasHostCrossID()) {		
			out.put(FixTags.HOSTCROSSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,hostCrossID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotNumReports()) {		
			out.put(FixTags.TOTNUMREPORTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totNumReports);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastRptRequested()) {		
			out.put(FixTags.LASTRPTREQUESTED);		
		
			out.put((byte) '=');		
		
			out.put(lastRptRequested?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeOriginationDate()) {		
			out.put(FixTags.TRADEORIGINATIONDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeOriginationDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasListID()) {		
			out.put(FixTags.LISTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,listID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCrossID()) {		
			out.put(FixTags.CROSSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,crossID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrigCrossID()) {		
			out.put(FixTags.ORIGCROSSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,origCrossID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCrossType()) {		
			out.put(FixTags.CROSSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)crossType);
		
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
		if (hasExecRefID()) {		
			out.put(FixTags.EXECREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecType()) {		
			out.put(FixTags.EXECTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrdStatus()) {		
			out.put(FixTags.ORDSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,ordStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasWorkingIndicator()) {		
			out.put(FixTags.WORKINGINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(workingIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrdRejReason()) {		
			out.put(FixTags.ORDREJREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)ordRejReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecRestatementReason()) {		
			out.put(FixTags.EXECRESTATEMENTREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)execRestatementReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAccount()) {		
			out.put(FixTags.ACCOUNT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,account); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAcctIDSource()) {		
			out.put(FixTags.ACCTIDSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)acctIDSource);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAccountType()) {		
			out.put(FixTags.ACCOUNTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)accountType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDayBookingInst()) {		
			out.put(FixTags.DAYBOOKINGINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,dayBookingInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBookingUnit()) {		
			out.put(FixTags.BOOKINGUNIT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,bookingUnit); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPreallocMethod()) {		
			out.put(FixTags.PREALLOCMETHOD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,preallocMethod); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocID()) {		
			out.put(FixTags.ALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocID); 		
		
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
		if (hasMatchType()) {		
			out.put(FixTags.MATCHTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,matchType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrderCategory()) {		
			out.put(FixTags.ORDERCATEGORY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderCategory); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCashMargin()) {		
			out.put(FixTags.CASHMARGIN);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,cashMargin); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingFeeIndicator()) {		
			out.put(FixTags.CLEARINGFEEINDICATOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingFeeIndicator); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSide()) {		
			out.put(FixTags.SIDE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQtyType()) {		
			out.put(FixTags.QTYTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)qtyType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLotType()) {		
			out.put(FixTags.LOTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,lotType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrdType()) {		
			out.put(FixTags.ORDTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,ordType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriceType()) {		
			out.put(FixTags.PRICETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priceType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPrice()) {		
			out.put(FixTags.PRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)price);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriceProtectionScope()) {		
			out.put(FixTags.PRICEPROTECTIONSCOPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,priceProtectionScope); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasStopPx()) {		
			out.put(FixTags.STOPPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)stopPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPeggedPrice()) {		
			out.put(FixTags.PEGGEDPRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)peggedPrice);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPeggedRefPrice()) {		
			out.put(FixTags.PEGGEDREFPRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)peggedRefPrice);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDiscretionPrice()) {		
			out.put(FixTags.DISCRETIONPRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)discretionPrice);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTargetStrategy()) {		
			out.put(FixTags.TARGETSTRATEGY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)targetStrategy);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTargetStrategyParameters()) {		
			out.put(FixTags.TARGETSTRATEGYPARAMETERS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,targetStrategyParameters); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasParticipationRate()) {		
			out.put(FixTags.PARTICIPATIONRATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)participationRate);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTargetStrategyPerformance()) {		
			out.put(FixTags.TARGETSTRATEGYPERFORMANCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)targetStrategyPerformance);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasComplianceID()) {		
			out.put(FixTags.COMPLIANCEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,complianceID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSolicitedFlag()) {		
			out.put(FixTags.SOLICITEDFLAG);		
		
			out.put((byte) '=');		
		
			out.put(solicitedFlag?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTimeInForce()) {		
			out.put(FixTags.TIMEINFORCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,timeInForce); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEffectiveTime()) {		
			out.put(FixTags.EFFECTIVETIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,effectiveTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExpireDate()) {		
			out.put(FixTags.EXPIREDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,expireDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExpireTime()) {		
			out.put(FixTags.EXPIRETIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,expireTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecInst()) {		
			out.put(FixTags.EXECINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAggressorIndicator()) {		
			out.put(FixTags.AGGRESSORINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(aggressorIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrderCapacity()) {		
			out.put(FixTags.ORDERCAPACITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderCapacity); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrderRestrictions()) {		
			out.put(FixTags.ORDERRESTRICTIONS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderRestrictions); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPreTradeAnonymity()) {		
			out.put(FixTags.PRETRADEANONYMITY);		
		
			out.put((byte) '=');		
		
			out.put(preTradeAnonymity?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCustOrderCapacity()) {		
			out.put(FixTags.CUSTORDERCAPACITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)custOrderCapacity);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastQty()) {		
			out.put(FixTags.LASTQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lastQty);
		
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
		if (hasUnderlyingLastQty()) {		
			out.put(FixTags.UNDERLYINGLASTQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)underlyingLastQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastPx()) {		
			out.put(FixTags.LASTPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lastPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUnderlyingLastPx()) {		
			out.put(FixTags.UNDERLYINGLASTPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)underlyingLastPx);
		
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
		if (hasLastCapacity()) {		
			out.put(FixTags.LASTCAPACITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,lastCapacity); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLeavesQty()) {		
			out.put(FixTags.LEAVESQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)leavesQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCumQty()) {		
			out.put(FixTags.CUMQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)cumQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAvgPx()) {		
			out.put(FixTags.AVGPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)avgPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDayOrderQty()) {		
			out.put(FixTags.DAYORDERQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)dayOrderQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDayCumQty()) {		
			out.put(FixTags.DAYCUMQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)dayCumQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDayAvgPx()) {		
			out.put(FixTags.DAYAVGPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)dayAvgPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotNoFills()) {		
			out.put(FixTags.TOTNOFILLS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totNoFills);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastFragment()) {		
			out.put(FixTags.LASTFRAGMENT);		
		
			out.put((byte) '=');		
		
			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasGTBookingInst()) {		
			out.put(FixTags.GTBOOKINGINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)gTBookingInst);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeDate()) {		
			out.put(FixTags.TRADEDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasReportToExch()) {		
			out.put(FixTags.REPORTTOEXCH);		
		
			out.put((byte) '=');		
		
			out.put(reportToExch?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasGrossTradeAmt()) {		
			out.put(FixTags.GROSSTRADEAMT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)grossTradeAmt);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNumDaysInterest()) {		
			out.put(FixTags.NUMDAYSINTEREST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)numDaysInterest);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExDate()) {		
			out.put(FixTags.EXDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,exDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAccruedInterestRate()) {		
			out.put(FixTags.ACCRUEDINTERESTRATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)accruedInterestRate);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAccruedInterestAmt()) {		
			out.put(FixTags.ACCRUEDINTERESTAMT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)accruedInterestAmt);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasInterestAtMaturity()) {		
			out.put(FixTags.INTERESTATMATURITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)interestAtMaturity);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEndAccruedInterestAmt()) {		
			out.put(FixTags.ENDACCRUEDINTERESTAMT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)endAccruedInterestAmt);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasStartCash()) {		
			out.put(FixTags.STARTCASH);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)startCash);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEndCash()) {		
			out.put(FixTags.ENDCASH);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)endCash);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradedFlatSwitch()) {		
			out.put(FixTags.TRADEDFLATSWITCH);		
		
			out.put((byte) '=');		
		
			out.put(tradedFlatSwitch?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBasisFeatureDate()) {		
			out.put(FixTags.BASISFEATUREDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,basisFeatureDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBasisFeaturePrice()) {		
			out.put(FixTags.BASISFEATUREPRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)basisFeaturePrice);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasConcession()) {		
			out.put(FixTags.CONCESSION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)concession);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotalTakedown()) {		
			out.put(FixTags.TOTALTAKEDOWN);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totalTakedown);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNetMoney()) {		
			out.put(FixTags.NETMONEY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)netMoney);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlCurrAmt()) {		
			out.put(FixTags.SETTLCURRAMT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)settlCurrAmt);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlCurrency()) {		
			out.put(FixTags.SETTLCURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlCurrency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlCurrFxRate()) {		
			out.put(FixTags.SETTLCURRFXRATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)settlCurrFxRate);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlCurrFxRateCalc()) {		
			out.put(FixTags.SETTLCURRFXRATECALC);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlCurrFxRateCalc); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasHandlInst()) {		
			out.put(FixTags.HANDLINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,handlInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMinQty()) {		
			out.put(FixTags.MINQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)minQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMatchIncrement()) {		
			out.put(FixTags.MATCHINCREMENT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)matchIncrement);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMaxPriceLevels()) {		
			out.put(FixTags.MAXPRICELEVELS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)maxPriceLevels);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMaxFloor()) {		
			out.put(FixTags.MAXFLOOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)maxFloor);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPositionEffect()) {		
			out.put(FixTags.POSITIONEFFECT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,positionEffect); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMaxShow()) {		
			out.put(FixTags.MAXSHOW);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)maxShow);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBookingType()) {		
			out.put(FixTags.BOOKINGTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)bookingType);
		
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
		if (hasSettlDate2()) {		
			out.put(FixTags.SETTLDATE2);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlDate2); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrderQty2()) {		
			out.put(FixTags.ORDERQTY2);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)orderQty2);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastForwardPoints2()) {		
			out.put(FixTags.LASTFORWARDPOINTS2);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lastForwardPoints2);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMultiLegReportingType()) {		
			out.put(FixTags.MULTILEGREPORTINGTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,multiLegReportingType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCancellationRights()) {		
			out.put(FixTags.CANCELLATIONRIGHTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,cancellationRights); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMoneyLaunderingStatus()) {		
			out.put(FixTags.MONEYLAUNDERINGSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,moneyLaunderingStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRegistID()) {		
			out.put(FixTags.REGISTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,registID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDesignation()) {		
			out.put(FixTags.DESIGNATION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,designation); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransBkdTime()) {		
			out.put(FixTags.TRANSBKDTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transBkdTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecValuationPoint()) {		
			out.put(FixTags.EXECVALUATIONPOINT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execValuationPoint); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecPriceType()) {		
			out.put(FixTags.EXECPRICETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execPriceType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecPriceAdjustment()) {		
			out.put(FixTags.EXECPRICEADJUSTMENT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)execPriceAdjustment);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriorityIndicator()) {		
			out.put(FixTags.PRIORITYINDICATOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priorityIndicator);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriceImprovement()) {		
			out.put(FixTags.PRICEIMPROVEMENT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priceImprovement);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastLiquidityInd()) {		
			out.put(FixTags.LASTLIQUIDITYIND);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lastLiquidityInd);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCopyMsgIndicator()) {		
			out.put(FixTags.COPYMSGINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(copyMsgIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasManualOrderIndicator()) {		
			out.put(FixTags.MANUALORDERINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(manualOrderIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCustDirectedOrder()) {		
			out.put(FixTags.CUSTDIRECTEDORDER);		
		
			out.put((byte) '=');		
		
			out.put(custDirectedOrder?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasReceivedDeptID()) {		
			out.put(FixTags.RECEIVEDDEPTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,receivedDeptID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCustOrderHandlingInst()) {		
			out.put(FixTags.CUSTORDERHANDLINGINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,custOrderHandlingInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrderHandlingInstSource()) {		
			out.put(FixTags.ORDERHANDLINGINSTSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)orderHandlingInstSource);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDividendYield()) {		
			out.put(FixTags.DIVIDENDYIELD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)dividendYield);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasVolatility()) {		
			out.put(FixTags.VOLATILITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)volatility);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTimeToExpiration()) {		
			out.put(FixTags.TIMETOEXPIRATION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)timeToExpiration);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRiskFreeRate()) {		
			out.put(FixTags.RISKFREERATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)riskFreeRate);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriceDelta()) {		
			out.put(FixTags.PRICEDELTA);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priceDelta);
		
			out.put(FixUtils.SOH);		
		}		
		
		applicationSequenceControl.encode(out);
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(contraGrp)>0) {
			out.put(FixTags.NOCONTRABROKERS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(contraGrp));

			out.put(FixUtils.SOH);

		}
		for (FixContraGrp fixContraGrp : contraGrp) if (fixContraGrp.hasGroup()) fixContraGrp.encode(out);
		if (FixUtils.getNoInGroup(preAllocGrp)>0) {
			out.put(FixTags.NOALLOCS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(preAllocGrp));

			out.put(FixUtils.SOH);

		}
		for (FixPreAllocGrp fixPreAllocGrp : preAllocGrp) if (fixPreAllocGrp.hasGroup()) fixPreAllocGrp.encode(out);
		instrument.encode(out);
		financingDetails.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(stipulations)>0) {
			out.put(FixTags.NOSTIPULATIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(stipulations));

			out.put(FixUtils.SOH);

		}
		for (FixStipulations fixStipulations : stipulations) if (fixStipulations.hasGroup()) fixStipulations.encode(out);
		orderQtyData.encode(out);
		triggeringInstruction.encode(out);
		pegInstructions.encode(out);
		discretionInstructions.encode(out);
		if (FixUtils.getNoInGroup(strategyParametersGrp)>0) {
			out.put(FixTags.NOSTRATEGYPARAMETERS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(strategyParametersGrp));

			out.put(FixUtils.SOH);

		}
		for (FixStrategyParametersGrp fixStrategyParametersGrp : strategyParametersGrp) if (fixStrategyParametersGrp.hasGroup()) fixStrategyParametersGrp.encode(out);
		if (FixUtils.getNoInGroup(fillsGrp)>0) {
			out.put(FixTags.NOFILLS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(fillsGrp));

			out.put(FixUtils.SOH);

		}
		for (FixFillsGrp fixFillsGrp : fillsGrp) if (fixFillsGrp.hasGroup()) fixFillsGrp.encode(out);
		commissionData.encode(out);
		spreadOrBenchmarkCurveData.encode(out);
		yieldData.encode(out);
		if (FixUtils.getNoInGroup(rateSource)>0) {
			out.put(FixTags.NORATESOURCES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(rateSource));

			out.put(FixUtils.SOH);

		}
		for (FixRateSource fixRateSource : rateSource) if (fixRateSource.hasGroup()) fixRateSource.encode(out);
		displayInstruction.encode(out);
		if (FixUtils.getNoInGroup(contAmtGrp)>0) {
			out.put(FixTags.NOCONTAMTS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(contAmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixContAmtGrp fixContAmtGrp : contAmtGrp) if (fixContAmtGrp.hasGroup()) fixContAmtGrp.encode(out);
		if (FixUtils.getNoInGroup(instrmtLegExecGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtLegExecGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtLegExecGrp fixInstrmtLegExecGrp : instrmtLegExecGrp) if (fixInstrmtLegExecGrp.hasGroup()) fixInstrmtLegExecGrp.encode(out);
		if (FixUtils.getNoInGroup(miscFeesGrp)>0) {
			out.put(FixTags.NOMISCFEES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(miscFeesGrp));

			out.put(FixUtils.SOH);

		}
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) if (fixMiscFeesGrp.hasGroup()) fixMiscFeesGrp.encode(out);
		if (FixUtils.getNoInGroup(trdRegTimestamps)>0) {
			out.put(FixTags.NOTRDREGTIMESTAMPS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdRegTimestamps));

			out.put(FixUtils.SOH);

		}
		for (FixTrdRegTimestamps fixTrdRegTimestamps : trdRegTimestamps) if (fixTrdRegTimestamps.hasGroup()) fixTrdRegTimestamps.encode(out);
		
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
		
		if (hasOrderID()) {		
			FixUtils.put(out,orderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryOrderID()) {		
			FixUtils.put(out,secondaryOrderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryClOrdID()) {		
			FixUtils.put(out,secondaryClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryExecID()) {		
			FixUtils.put(out,secondaryExecID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigClOrdID()) {		
			FixUtils.put(out,origClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdLinkID()) {		
			FixUtils.put(out,clOrdLinkID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteRespID()) {		
			FixUtils.put(out,quoteRespID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdStatusReqID()) {		
			FixUtils.put(out,ordStatusReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMassStatusReqID()) {		
			FixUtils.put(out,massStatusReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHostCrossID()) {		
			FixUtils.put(out,hostCrossID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNumReports()) {		
			FixUtils.put(out, (long)totNumReports);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastRptRequested()) {		
			out.put(lastRptRequested?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeOriginationDate()) {		
			FixUtils.put(out,tradeOriginationDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasListID()) {		
			FixUtils.put(out,listID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCrossID()) {		
			FixUtils.put(out,crossID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigCrossID()) {		
			FixUtils.put(out,origCrossID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCrossType()) {		
			FixUtils.put(out, (long)crossType);
		
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
		
		if (hasExecRefID()) {		
			FixUtils.put(out,execRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecType()) {		
			FixUtils.put(out,execType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdStatus()) {		
			FixUtils.put(out,ordStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasWorkingIndicator()) {		
			out.put(workingIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdRejReason()) {		
			FixUtils.put(out, (long)ordRejReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecRestatementReason()) {		
			FixUtils.put(out, (long)execRestatementReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAccount()) {		
			FixUtils.put(out,account); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAcctIDSource()) {		
			FixUtils.put(out, (long)acctIDSource);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAccountType()) {		
			FixUtils.put(out, (long)accountType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDayBookingInst()) {		
			FixUtils.put(out,dayBookingInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBookingUnit()) {		
			FixUtils.put(out,bookingUnit); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPreallocMethod()) {		
			FixUtils.put(out,preallocMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocID()) {		
			FixUtils.put(out,allocID); 		
		
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
		
		if (hasMatchType()) {		
			FixUtils.put(out,matchType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderCategory()) {		
			FixUtils.put(out,orderCategory); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCashMargin()) {		
			FixUtils.put(out,cashMargin); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingFeeIndicator()) {		
			FixUtils.put(out,clearingFeeIndicator); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQtyType()) {		
			FixUtils.put(out, (long)qtyType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLotType()) {		
			FixUtils.put(out,lotType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdType()) {		
			FixUtils.put(out,ordType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceType()) {		
			FixUtils.put(out, (long)priceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPrice()) {		
			FixUtils.put(out, (long)price);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceProtectionScope()) {		
			FixUtils.put(out,priceProtectionScope); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStopPx()) {		
			FixUtils.put(out, (long)stopPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPeggedPrice()) {		
			FixUtils.put(out, (long)peggedPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPeggedRefPrice()) {		
			FixUtils.put(out, (long)peggedRefPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDiscretionPrice()) {		
			FixUtils.put(out, (long)discretionPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTargetStrategy()) {		
			FixUtils.put(out, (long)targetStrategy);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTargetStrategyParameters()) {		
			FixUtils.put(out,targetStrategyParameters); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasParticipationRate()) {		
			FixUtils.put(out, (long)participationRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTargetStrategyPerformance()) {		
			FixUtils.put(out, (long)targetStrategyPerformance);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasComplianceID()) {		
			FixUtils.put(out,complianceID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSolicitedFlag()) {		
			out.put(solicitedFlag?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTimeInForce()) {		
			FixUtils.put(out,timeInForce); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEffectiveTime()) {		
			FixUtils.put(out,effectiveTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExpireDate()) {		
			FixUtils.put(out,expireDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExpireTime()) {		
			FixUtils.put(out,expireTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecInst()) {		
			FixUtils.put(out,execInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAggressorIndicator()) {		
			out.put(aggressorIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderCapacity()) {		
			FixUtils.put(out,orderCapacity); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderRestrictions()) {		
			FixUtils.put(out,orderRestrictions); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPreTradeAnonymity()) {		
			out.put(preTradeAnonymity?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCustOrderCapacity()) {		
			FixUtils.put(out, (long)custOrderCapacity);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastQty()) {		
			FixUtils.put(out, (long)lastQty);
		
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
		
		if (hasUnderlyingLastQty()) {		
			FixUtils.put(out, (long)underlyingLastQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastPx()) {		
			FixUtils.put(out, (long)lastPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLastPx()) {		
			FixUtils.put(out, (long)underlyingLastPx);
		
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
		
		if (hasLastCapacity()) {		
			FixUtils.put(out,lastCapacity); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLeavesQty()) {		
			FixUtils.put(out, (long)leavesQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCumQty()) {		
			FixUtils.put(out, (long)cumQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAvgPx()) {		
			FixUtils.put(out, (long)avgPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDayOrderQty()) {		
			FixUtils.put(out, (long)dayOrderQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDayCumQty()) {		
			FixUtils.put(out, (long)dayCumQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDayAvgPx()) {		
			FixUtils.put(out, (long)dayAvgPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNoFills()) {		
			FixUtils.put(out, (long)totNoFills);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastFragment()) {		
			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasGTBookingInst()) {		
			FixUtils.put(out, (long)gTBookingInst);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeDate()) {		
			FixUtils.put(out,tradeDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasReportToExch()) {		
			out.put(reportToExch?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasGrossTradeAmt()) {		
			FixUtils.put(out, (long)grossTradeAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNumDaysInterest()) {		
			FixUtils.put(out, (long)numDaysInterest);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExDate()) {		
			FixUtils.put(out,exDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAccruedInterestRate()) {		
			FixUtils.put(out, (long)accruedInterestRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAccruedInterestAmt()) {		
			FixUtils.put(out, (long)accruedInterestAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasInterestAtMaturity()) {		
			FixUtils.put(out, (long)interestAtMaturity);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEndAccruedInterestAmt()) {		
			FixUtils.put(out, (long)endAccruedInterestAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStartCash()) {		
			FixUtils.put(out, (long)startCash);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEndCash()) {		
			FixUtils.put(out, (long)endCash);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradedFlatSwitch()) {		
			out.put(tradedFlatSwitch?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBasisFeatureDate()) {		
			FixUtils.put(out,basisFeatureDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBasisFeaturePrice()) {		
			FixUtils.put(out, (long)basisFeaturePrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasConcession()) {		
			FixUtils.put(out, (long)concession);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotalTakedown()) {		
			FixUtils.put(out, (long)totalTakedown);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNetMoney()) {		
			FixUtils.put(out, (long)netMoney);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrAmt()) {		
			FixUtils.put(out, (long)settlCurrAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrency()) {		
			FixUtils.put(out,settlCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrFxRate()) {		
			FixUtils.put(out, (long)settlCurrFxRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrFxRateCalc()) {		
			FixUtils.put(out,settlCurrFxRateCalc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHandlInst()) {		
			FixUtils.put(out,handlInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMinQty()) {		
			FixUtils.put(out, (long)minQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMatchIncrement()) {		
			FixUtils.put(out, (long)matchIncrement);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaxPriceLevels()) {		
			FixUtils.put(out, (long)maxPriceLevels);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaxFloor()) {		
			FixUtils.put(out, (long)maxFloor);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPositionEffect()) {		
			FixUtils.put(out,positionEffect); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaxShow()) {		
			FixUtils.put(out, (long)maxShow);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBookingType()) {		
			FixUtils.put(out, (long)bookingType);
		
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
		
		if (hasSettlDate2()) {		
			FixUtils.put(out,settlDate2); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderQty2()) {		
			FixUtils.put(out, (long)orderQty2);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastForwardPoints2()) {		
			FixUtils.put(out, (long)lastForwardPoints2);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMultiLegReportingType()) {		
			FixUtils.put(out,multiLegReportingType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCancellationRights()) {		
			FixUtils.put(out,cancellationRights); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMoneyLaunderingStatus()) {		
			FixUtils.put(out,moneyLaunderingStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRegistID()) {		
			FixUtils.put(out,registID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDesignation()) {		
			FixUtils.put(out,designation); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransBkdTime()) {		
			FixUtils.put(out,transBkdTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecValuationPoint()) {		
			FixUtils.put(out,execValuationPoint); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecPriceType()) {		
			FixUtils.put(out,execPriceType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecPriceAdjustment()) {		
			FixUtils.put(out, (long)execPriceAdjustment);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriorityIndicator()) {		
			FixUtils.put(out, (long)priorityIndicator);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceImprovement()) {		
			FixUtils.put(out, (long)priceImprovement);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastLiquidityInd()) {		
			FixUtils.put(out, (long)lastLiquidityInd);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCopyMsgIndicator()) {		
			out.put(copyMsgIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasManualOrderIndicator()) {		
			out.put(manualOrderIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCustDirectedOrder()) {		
			out.put(custDirectedOrder?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasReceivedDeptID()) {		
			FixUtils.put(out,receivedDeptID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCustOrderHandlingInst()) {		
			FixUtils.put(out,custOrderHandlingInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderHandlingInstSource()) {		
			FixUtils.put(out, (long)orderHandlingInstSource);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDividendYield()) {		
			FixUtils.put(out, (long)dividendYield);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasVolatility()) {		
			FixUtils.put(out, (long)volatility);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTimeToExpiration()) {		
			FixUtils.put(out, (long)timeToExpiration);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskFreeRate()) {		
			FixUtils.put(out, (long)riskFreeRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceDelta()) {		
			FixUtils.put(out, (long)priceDelta);
		
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
			
	public void crackOrderID() {		
		getOrderID();		
	}		
			
	public byte[] getOrderID() { 		
		if ( hasOrderID()) {		
			if (hasOrderID == FixUtils.TAG_HAS_VALUE) {		
				return orderID; 		
			} else {

				buf.position(hasOrderID);

			FixMessage.getTagStringValue(buf, orderID, 0, orderID.length, err);
		
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
		if (hasOrderID()) FixUtils.fillSpace(orderID);		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderID(String str) {		
		if (str == null ) return;
		if (hasOrderID()) FixUtils.fillSpace(orderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryOrderID() {		
		getSecondaryOrderID();		
	}		
			
	public byte[] getSecondaryOrderID() { 		
		if ( hasSecondaryOrderID()) {		
			if (hasSecondaryOrderID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryOrderID; 		
			} else {

				buf.position(hasSecondaryOrderID);

			FixMessage.getTagStringValue(buf, secondaryOrderID, 0, secondaryOrderID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryOrderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryOrderID() { return hasSecondaryOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryOrderID()) FixUtils.fillSpace(secondaryOrderID);		
		FixUtils.copy(secondaryOrderID, src); 		
		hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryOrderID(String str) {		
		if (str == null ) return;
		if (hasSecondaryOrderID()) FixUtils.fillSpace(secondaryOrderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryOrderID, src); 		
		hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryClOrdID() {		
		getSecondaryClOrdID();		
	}		
			
	public byte[] getSecondaryClOrdID() { 		
		if ( hasSecondaryClOrdID()) {		
			if (hasSecondaryClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryClOrdID; 		
			} else {

				buf.position(hasSecondaryClOrdID);

			FixMessage.getTagStringValue(buf, secondaryClOrdID, 0, secondaryClOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryClOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryClOrdID() { return hasSecondaryClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryClOrdID()) FixUtils.fillSpace(secondaryClOrdID);		
		FixUtils.copy(secondaryClOrdID, src); 		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryClOrdID(String str) {		
		if (str == null ) return;
		if (hasSecondaryClOrdID()) FixUtils.fillSpace(secondaryClOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryClOrdID, src); 		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
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
		if (hasClOrdID()) FixUtils.fillSpace(clOrdID);		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClOrdID(String str) {		
		if (str == null ) return;
		if (hasClOrdID()) FixUtils.fillSpace(clOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrigClOrdID() {		
		getOrigClOrdID();		
	}		
			
	public byte[] getOrigClOrdID() { 		
		if ( hasOrigClOrdID()) {		
			if (hasOrigClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return origClOrdID; 		
			} else {

				buf.position(hasOrigClOrdID);

			FixMessage.getTagStringValue(buf, origClOrdID, 0, origClOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return origClOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigClOrdID() { return hasOrigClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrigClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasOrigClOrdID()) FixUtils.fillSpace(origClOrdID);		
		FixUtils.copy(origClOrdID, src); 		
		hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigClOrdID(String str) {		
		if (str == null ) return;
		if (hasOrigClOrdID()) FixUtils.fillSpace(origClOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origClOrdID, src); 		
		hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClOrdLinkID() {		
		getClOrdLinkID();		
	}		
			
	public byte[] getClOrdLinkID() { 		
		if ( hasClOrdLinkID()) {		
			if (hasClOrdLinkID == FixUtils.TAG_HAS_VALUE) {		
				return clOrdLinkID; 		
			} else {

				buf.position(hasClOrdLinkID);

			FixMessage.getTagStringValue(buf, clOrdLinkID, 0, clOrdLinkID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClOrdLinkID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clOrdLinkID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClOrdLinkID() { return hasClOrdLinkID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClOrdLinkID(byte[] src) {		
		if (src == null ) return;
		if (hasClOrdLinkID()) FixUtils.fillSpace(clOrdLinkID);		
		FixUtils.copy(clOrdLinkID, src); 		
		hasClOrdLinkID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClOrdLinkID(String str) {		
		if (str == null ) return;
		if (hasClOrdLinkID()) FixUtils.fillSpace(clOrdLinkID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clOrdLinkID, src); 		
		hasClOrdLinkID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteRespID() {		
		getQuoteRespID();		
	}		
			
	public byte[] getQuoteRespID() { 		
		if ( hasQuoteRespID()) {		
			if (hasQuoteRespID == FixUtils.TAG_HAS_VALUE) {		
				return quoteRespID; 		
			} else {

				buf.position(hasQuoteRespID);

			FixMessage.getTagStringValue(buf, quoteRespID, 0, quoteRespID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasQuoteRespID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteRespID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteRespID() { return hasQuoteRespID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteRespID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteRespID()) FixUtils.fillSpace(quoteRespID);		
		FixUtils.copy(quoteRespID, src); 		
		hasQuoteRespID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteRespID(String str) {		
		if (str == null ) return;
		if (hasQuoteRespID()) FixUtils.fillSpace(quoteRespID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteRespID, src); 		
		hasQuoteRespID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrdStatusReqID() {		
		getOrdStatusReqID();		
	}		
			
	public byte[] getOrdStatusReqID() { 		
		if ( hasOrdStatusReqID()) {		
			if (hasOrdStatusReqID == FixUtils.TAG_HAS_VALUE) {		
				return ordStatusReqID; 		
			} else {

				buf.position(hasOrdStatusReqID);

			FixMessage.getTagStringValue(buf, ordStatusReqID, 0, ordStatusReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrdStatusReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return ordStatusReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrdStatusReqID() { return hasOrdStatusReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrdStatusReqID(byte[] src) {		
		if (src == null ) return;
		if (hasOrdStatusReqID()) FixUtils.fillSpace(ordStatusReqID);		
		FixUtils.copy(ordStatusReqID, src); 		
		hasOrdStatusReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdStatusReqID(String str) {		
		if (str == null ) return;
		if (hasOrdStatusReqID()) FixUtils.fillSpace(ordStatusReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(ordStatusReqID, src); 		
		hasOrdStatusReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMassStatusReqID() {		
		getMassStatusReqID();		
	}		
			
	public byte[] getMassStatusReqID() { 		
		if ( hasMassStatusReqID()) {		
			if (hasMassStatusReqID == FixUtils.TAG_HAS_VALUE) {		
				return massStatusReqID; 		
			} else {

				buf.position(hasMassStatusReqID);

			FixMessage.getTagStringValue(buf, massStatusReqID, 0, massStatusReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMassStatusReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return massStatusReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMassStatusReqID() { return hasMassStatusReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMassStatusReqID(byte[] src) {		
		if (src == null ) return;
		if (hasMassStatusReqID()) FixUtils.fillSpace(massStatusReqID);		
		FixUtils.copy(massStatusReqID, src); 		
		hasMassStatusReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMassStatusReqID(String str) {		
		if (str == null ) return;
		if (hasMassStatusReqID()) FixUtils.fillSpace(massStatusReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(massStatusReqID, src); 		
		hasMassStatusReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackHostCrossID() {		
		getHostCrossID();		
	}		
			
	public byte[] getHostCrossID() { 		
		if ( hasHostCrossID()) {		
			if (hasHostCrossID == FixUtils.TAG_HAS_VALUE) {		
				return hostCrossID; 		
			} else {

				buf.position(hasHostCrossID);

			FixMessage.getTagStringValue(buf, hostCrossID, 0, hostCrossID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasHostCrossID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return hostCrossID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasHostCrossID() { return hasHostCrossID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setHostCrossID(byte[] src) {		
		if (src == null ) return;
		if (hasHostCrossID()) FixUtils.fillSpace(hostCrossID);		
		FixUtils.copy(hostCrossID, src); 		
		hasHostCrossID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHostCrossID(String str) {		
		if (str == null ) return;
		if (hasHostCrossID()) FixUtils.fillSpace(hostCrossID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(hostCrossID, src); 		
		hasHostCrossID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTotNumReports() {		
		getTotNumReports();		
	}		
			
	public long getTotNumReports() { 		
		if ( hasTotNumReports()) {		
			if (hasTotNumReports == FixUtils.TAG_HAS_VALUE) {		
				return totNumReports; 		
			} else {

				buf.position(hasTotNumReports);

			totNumReports = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotNumReports = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totNumReports;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNumReports() { return hasTotNumReports != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotNumReports(byte[] src) {		
		if (src == null ) return;
		if (hasTotNumReports()) totNumReports = FixUtils.TAG_HAS_NO_VALUE;		
		totNumReports = FixUtils.longValueOf(src, 0, src.length);
		hasTotNumReports = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNumReports(long src) {		
		totNumReports = src;
		hasTotNumReports = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNumReports(String str) {		
		if (str == null ) return;
		if (hasTotNumReports()) totNumReports = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNumReports = FixUtils.longValueOf(src, 0, src.length);
		hasTotNumReports = FixUtils.TAG_HAS_VALUE;		
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

			lastRptRequested = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
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
			
	public void crackTradeOriginationDate() {		
		getTradeOriginationDate();		
	}		
			
	public byte[] getTradeOriginationDate() { 		
		if ( hasTradeOriginationDate()) {		
			if (hasTradeOriginationDate == FixUtils.TAG_HAS_VALUE) {		
				return tradeOriginationDate; 		
			} else {

				buf.position(hasTradeOriginationDate);

			FixMessage.getTagStringValue(buf, tradeOriginationDate, 0, tradeOriginationDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeOriginationDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeOriginationDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeOriginationDate() { return hasTradeOriginationDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeOriginationDate(byte[] src) {		
		if (src == null ) return;
		if (hasTradeOriginationDate()) FixUtils.fillSpace(tradeOriginationDate);		
		FixUtils.copy(tradeOriginationDate, src); 		
		hasTradeOriginationDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeOriginationDate(String str) {		
		if (str == null ) return;
		if (hasTradeOriginationDate()) FixUtils.fillSpace(tradeOriginationDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeOriginationDate, src); 		
		hasTradeOriginationDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackListID() {		
		getListID();		
	}		
			
	public byte[] getListID() { 		
		if ( hasListID()) {		
			if (hasListID == FixUtils.TAG_HAS_VALUE) {		
				return listID; 		
			} else {

				buf.position(hasListID);

			FixMessage.getTagStringValue(buf, listID, 0, listID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasListID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return listID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasListID() { return hasListID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setListID(byte[] src) {		
		if (src == null ) return;
		if (hasListID()) FixUtils.fillSpace(listID);		
		FixUtils.copy(listID, src); 		
		hasListID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListID(String str) {		
		if (str == null ) return;
		if (hasListID()) FixUtils.fillSpace(listID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(listID, src); 		
		hasListID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCrossID() {		
		getCrossID();		
	}		
			
	public byte[] getCrossID() { 		
		if ( hasCrossID()) {		
			if (hasCrossID == FixUtils.TAG_HAS_VALUE) {		
				return crossID; 		
			} else {

				buf.position(hasCrossID);

			FixMessage.getTagStringValue(buf, crossID, 0, crossID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCrossID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return crossID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCrossID() { return hasCrossID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCrossID(byte[] src) {		
		if (src == null ) return;
		if (hasCrossID()) FixUtils.fillSpace(crossID);		
		FixUtils.copy(crossID, src); 		
		hasCrossID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossID(String str) {		
		if (str == null ) return;
		if (hasCrossID()) FixUtils.fillSpace(crossID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(crossID, src); 		
		hasCrossID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrigCrossID() {		
		getOrigCrossID();		
	}		
			
	public byte[] getOrigCrossID() { 		
		if ( hasOrigCrossID()) {		
			if (hasOrigCrossID == FixUtils.TAG_HAS_VALUE) {		
				return origCrossID; 		
			} else {

				buf.position(hasOrigCrossID);

			FixMessage.getTagStringValue(buf, origCrossID, 0, origCrossID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrigCrossID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return origCrossID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigCrossID() { return hasOrigCrossID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrigCrossID(byte[] src) {		
		if (src == null ) return;
		if (hasOrigCrossID()) FixUtils.fillSpace(origCrossID);		
		FixUtils.copy(origCrossID, src); 		
		hasOrigCrossID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigCrossID(String str) {		
		if (str == null ) return;
		if (hasOrigCrossID()) FixUtils.fillSpace(origCrossID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origCrossID, src); 		
		hasOrigCrossID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCrossType() {		
		getCrossType();		
	}		
			
	public long getCrossType() { 		
		if ( hasCrossType()) {		
			if (hasCrossType == FixUtils.TAG_HAS_VALUE) {		
				return crossType; 		
			} else {

				buf.position(hasCrossType);

			crossType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCrossType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return crossType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCrossType() { return hasCrossType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCrossType(byte[] src) {		
		if (src == null ) return;
		if (hasCrossType()) crossType = FixUtils.TAG_HAS_NO_VALUE;		
		crossType = FixUtils.longValueOf(src, 0, src.length);
		hasCrossType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossType(long src) {		
		crossType = src;
		hasCrossType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossType(String str) {		
		if (str == null ) return;
		if (hasCrossType()) crossType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		crossType = FixUtils.longValueOf(src, 0, src.length);
		hasCrossType = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackExecRefID() {		
		getExecRefID();		
	}		
			
	public byte[] getExecRefID() { 		
		if ( hasExecRefID()) {		
			if (hasExecRefID == FixUtils.TAG_HAS_VALUE) {		
				return execRefID; 		
			} else {

				buf.position(hasExecRefID);

			FixMessage.getTagStringValue(buf, execRefID, 0, execRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExecRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExecRefID() { return hasExecRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecRefID(byte[] src) {		
		if (src == null ) return;
		if (hasExecRefID()) FixUtils.fillSpace(execRefID);		
		FixUtils.copy(execRefID, src); 		
		hasExecRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecRefID(String str) {		
		if (str == null ) return;
		if (hasExecRefID()) FixUtils.fillSpace(execRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(execRefID, src); 		
		hasExecRefID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackOrdStatus() {		
		getOrdStatus();		
	}		
			
	public byte getOrdStatus() { 		
		if ( hasOrdStatus()) {		
			if (hasOrdStatus == FixUtils.TAG_HAS_VALUE) {		
				return ordStatus; 		
			} else {

				buf.position(hasOrdStatus);

			ordStatus = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (ordStatus != (byte)'D') && (ordStatus != (byte)'E') && (ordStatus != (byte)'A') && (ordStatus != (byte)'B') && (ordStatus != (byte)'C') && (ordStatus != (byte)'3') && (ordStatus != (byte)'2') && (ordStatus != (byte)'1') && (ordStatus != (byte)'0') && (ordStatus != (byte)'7') && (ordStatus != (byte)'6') && (ordStatus != (byte)'5') && (ordStatus != (byte)'4') && (ordStatus != (byte)'9') && (ordStatus != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 39);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return ordStatus;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrdStatus() { return hasOrdStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrdStatus(byte[] src) {		
		if (src == null ) return;
		if (hasOrdStatus()) ordStatus = (byte)' ';		
		ordStatus = src[0];		
		hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdStatus(byte src) {		
		ordStatus = src;
		hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdStatus(String str) {		
		if (str == null ) return;
		if (hasOrdStatus()) ordStatus = (byte)' ';		
		byte[] src = str.getBytes(); 		
		ordStatus = src[0];		
		hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackWorkingIndicator() {		
		getWorkingIndicator();		
	}		
			
	public boolean getWorkingIndicator() { 		
		if ( hasWorkingIndicator()) {		
			if (hasWorkingIndicator == FixUtils.TAG_HAS_VALUE) {		
				return workingIndicator; 		
			} else {

				buf.position(hasWorkingIndicator);

			workingIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasWorkingIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return workingIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasWorkingIndicator() { return hasWorkingIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setWorkingIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasWorkingIndicator()) workingIndicator = false;		
		workingIndicator = src[0]==(byte)'Y'?true:false;		
		hasWorkingIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setWorkingIndicator(boolean src) {		
		workingIndicator = src;
		hasWorkingIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setWorkingIndicator(String str) {		
		if (str == null ) return;
		if (hasWorkingIndicator()) workingIndicator = false;		
		byte[] src = str.getBytes(); 		
		workingIndicator = src[0]==(byte)'Y'?true:false;		
		hasWorkingIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrdRejReason() {		
		getOrdRejReason();		
	}		
			
	public long getOrdRejReason() { 		
		if ( hasOrdRejReason()) {		
			if (hasOrdRejReason == FixUtils.TAG_HAS_VALUE) {		
				return ordRejReason; 		
			} else {

				buf.position(hasOrdRejReason);

			ordRejReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasOrdRejReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return ordRejReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrdRejReason() { return hasOrdRejReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrdRejReason(byte[] src) {		
		if (src == null ) return;
		if (hasOrdRejReason()) ordRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		ordRejReason = FixUtils.longValueOf(src, 0, src.length);
		hasOrdRejReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdRejReason(long src) {		
		ordRejReason = src;
		hasOrdRejReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdRejReason(String str) {		
		if (str == null ) return;
		if (hasOrdRejReason()) ordRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		ordRejReason = FixUtils.longValueOf(src, 0, src.length);
		hasOrdRejReason = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackAccount() {		
		getAccount();		
	}		
			
	public byte[] getAccount() { 		
		if ( hasAccount()) {		
			if (hasAccount == FixUtils.TAG_HAS_VALUE) {		
				return account; 		
			} else {

				buf.position(hasAccount);

			FixMessage.getTagStringValue(buf, account, 0, account.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAccount = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return account;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAccount() { return hasAccount != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAccount(byte[] src) {		
		if (src == null ) return;
		if (hasAccount()) FixUtils.fillSpace(account);		
		FixUtils.copy(account, src); 		
		hasAccount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccount(String str) {		
		if (str == null ) return;
		if (hasAccount()) FixUtils.fillSpace(account);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(account, src); 		
		hasAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAcctIDSource() {		
		getAcctIDSource();		
	}		
			
	public long getAcctIDSource() { 		
		if ( hasAcctIDSource()) {		
			if (hasAcctIDSource == FixUtils.TAG_HAS_VALUE) {		
				return acctIDSource; 		
			} else {

				buf.position(hasAcctIDSource);

			acctIDSource = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return acctIDSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAcctIDSource() { return hasAcctIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAcctIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasAcctIDSource()) acctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		acctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAcctIDSource(long src) {		
		acctIDSource = src;
		hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAcctIDSource(String str) {		
		if (str == null ) return;
		if (hasAcctIDSource()) acctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		acctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAccountType() {		
		getAccountType();		
	}		
			
	public long getAccountType() { 		
		if ( hasAccountType()) {		
			if (hasAccountType == FixUtils.TAG_HAS_VALUE) {		
				return accountType; 		
			} else {

				buf.position(hasAccountType);

			accountType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAccountType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return accountType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAccountType() { return hasAccountType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAccountType(byte[] src) {		
		if (src == null ) return;
		if (hasAccountType()) accountType = FixUtils.TAG_HAS_NO_VALUE;		
		accountType = FixUtils.longValueOf(src, 0, src.length);
		hasAccountType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccountType(long src) {		
		accountType = src;
		hasAccountType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccountType(String str) {		
		if (str == null ) return;
		if (hasAccountType()) accountType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		accountType = FixUtils.longValueOf(src, 0, src.length);
		hasAccountType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDayBookingInst() {		
		getDayBookingInst();		
	}		
			
	public byte getDayBookingInst() { 		
		if ( hasDayBookingInst()) {		
			if (hasDayBookingInst == FixUtils.TAG_HAS_VALUE) {		
				return dayBookingInst; 		
			} else {

				buf.position(hasDayBookingInst);

			dayBookingInst = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (dayBookingInst != (byte)'2') && (dayBookingInst != (byte)'1') && (dayBookingInst != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 589);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasDayBookingInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return dayBookingInst;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDayBookingInst() { return hasDayBookingInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDayBookingInst(byte[] src) {		
		if (src == null ) return;
		if (hasDayBookingInst()) dayBookingInst = (byte)' ';		
		dayBookingInst = src[0];		
		hasDayBookingInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDayBookingInst(byte src) {		
		dayBookingInst = src;
		hasDayBookingInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDayBookingInst(String str) {		
		if (str == null ) return;
		if (hasDayBookingInst()) dayBookingInst = (byte)' ';		
		byte[] src = str.getBytes(); 		
		dayBookingInst = src[0];		
		hasDayBookingInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBookingUnit() {		
		getBookingUnit();		
	}		
			
	public byte getBookingUnit() { 		
		if ( hasBookingUnit()) {		
			if (hasBookingUnit == FixUtils.TAG_HAS_VALUE) {		
				return bookingUnit; 		
			} else {

				buf.position(hasBookingUnit);

			bookingUnit = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (bookingUnit != (byte)'2') && (bookingUnit != (byte)'1') && (bookingUnit != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 590);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasBookingUnit = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bookingUnit;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasBookingUnit() { return hasBookingUnit != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBookingUnit(byte[] src) {		
		if (src == null ) return;
		if (hasBookingUnit()) bookingUnit = (byte)' ';		
		bookingUnit = src[0];		
		hasBookingUnit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBookingUnit(byte src) {		
		bookingUnit = src;
		hasBookingUnit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBookingUnit(String str) {		
		if (str == null ) return;
		if (hasBookingUnit()) bookingUnit = (byte)' ';		
		byte[] src = str.getBytes(); 		
		bookingUnit = src[0];		
		hasBookingUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPreallocMethod() {		
		getPreallocMethod();		
	}		
			
	public byte getPreallocMethod() { 		
		if ( hasPreallocMethod()) {		
			if (hasPreallocMethod == FixUtils.TAG_HAS_VALUE) {		
				return preallocMethod; 		
			} else {

				buf.position(hasPreallocMethod);

			preallocMethod = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (preallocMethod != (byte)'1') && (preallocMethod != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 591);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasPreallocMethod = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return preallocMethod;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasPreallocMethod() { return hasPreallocMethod != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPreallocMethod(byte[] src) {		
		if (src == null ) return;
		if (hasPreallocMethod()) preallocMethod = (byte)' ';		
		preallocMethod = src[0];		
		hasPreallocMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPreallocMethod(byte src) {		
		preallocMethod = src;
		hasPreallocMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPreallocMethod(String str) {		
		if (str == null ) return;
		if (hasPreallocMethod()) preallocMethod = (byte)' ';		
		byte[] src = str.getBytes(); 		
		preallocMethod = src[0];		
		hasPreallocMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocID() {		
		getAllocID();		
	}		
			
	public byte[] getAllocID() { 		
		if ( hasAllocID()) {		
			if (hasAllocID == FixUtils.TAG_HAS_VALUE) {		
				return allocID; 		
			} else {

				buf.position(hasAllocID);

			FixMessage.getTagStringValue(buf, allocID, 0, allocID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAllocID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocID() { return hasAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasAllocID()) FixUtils.fillSpace(allocID);		
		FixUtils.copy(allocID, src); 		
		hasAllocID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocID(String str) {		
		if (str == null ) return;
		if (hasAllocID()) FixUtils.fillSpace(allocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocID, src); 		
		hasAllocID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackOrderCategory() {		
		getOrderCategory();		
	}		
			
	public byte getOrderCategory() { 		
		if ( hasOrderCategory()) {		
			if (hasOrderCategory == FixUtils.TAG_HAS_VALUE) {		
				return orderCategory; 		
			} else {

				buf.position(hasOrderCategory);

			orderCategory = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (orderCategory != (byte)'3') && (orderCategory != (byte)'2') && (orderCategory != (byte)'1') && (orderCategory != (byte)'7') && (orderCategory != (byte)'6') && (orderCategory != (byte)'5') && (orderCategory != (byte)'4') && (orderCategory != (byte)'9') && (orderCategory != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1115);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasOrderCategory = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderCategory;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrderCategory() { return hasOrderCategory != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderCategory(byte[] src) {		
		if (src == null ) return;
		if (hasOrderCategory()) orderCategory = (byte)' ';		
		orderCategory = src[0];		
		hasOrderCategory = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderCategory(byte src) {		
		orderCategory = src;
		hasOrderCategory = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderCategory(String str) {		
		if (str == null ) return;
		if (hasOrderCategory()) orderCategory = (byte)' ';		
		byte[] src = str.getBytes(); 		
		orderCategory = src[0];		
		hasOrderCategory = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCashMargin() {		
		getCashMargin();		
	}		
			
	public byte getCashMargin() { 		
		if ( hasCashMargin()) {		
			if (hasCashMargin == FixUtils.TAG_HAS_VALUE) {		
				return cashMargin; 		
			} else {

				buf.position(hasCashMargin);

			cashMargin = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (cashMargin != (byte)'3') && (cashMargin != (byte)'2') && (cashMargin != (byte)'1') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 544);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasCashMargin = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return cashMargin;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasCashMargin() { return hasCashMargin != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCashMargin(byte[] src) {		
		if (src == null ) return;
		if (hasCashMargin()) cashMargin = (byte)' ';		
		cashMargin = src[0];		
		hasCashMargin = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCashMargin(byte src) {		
		cashMargin = src;
		hasCashMargin = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCashMargin(String str) {		
		if (str == null ) return;
		if (hasCashMargin()) cashMargin = (byte)' ';		
		byte[] src = str.getBytes(); 		
		cashMargin = src[0];		
		hasCashMargin = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackSide() {		
		getSide();		
	}		
			
	public byte getSide() { 		
		if ( hasSide()) {		
			if (hasSide == FixUtils.TAG_HAS_VALUE) {		
				return side; 		
			} else {

				buf.position(hasSide);

			side = FixMessage.getTagCharValue(buf, err);
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
			
	public void crackLotType() {		
		getLotType();		
	}		
			
	public byte getLotType() { 		
		if ( hasLotType()) {		
			if (hasLotType == FixUtils.TAG_HAS_VALUE) {		
				return lotType; 		
			} else {

				buf.position(hasLotType);

			lotType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (lotType != (byte)'3') && (lotType != (byte)'2') && (lotType != (byte)'1') && (lotType != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1093);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasLotType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lotType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasLotType() { return hasLotType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLotType(byte[] src) {		
		if (src == null ) return;
		if (hasLotType()) lotType = (byte)' ';		
		lotType = src[0];		
		hasLotType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLotType(byte src) {		
		lotType = src;
		hasLotType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLotType(String str) {		
		if (str == null ) return;
		if (hasLotType()) lotType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		lotType = src[0];		
		hasLotType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrdType() {		
		getOrdType();		
	}		
			
	public byte getOrdType() { 		
		if ( hasOrdType()) {		
			if (hasOrdType == FixUtils.TAG_HAS_VALUE) {		
				return ordType; 		
			} else {

				buf.position(hasOrdType);

			ordType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (ordType != (byte)'D') && (ordType != (byte)'E') && (ordType != (byte)'F') && (ordType != (byte)'G') && (ordType != (byte)'A') && (ordType != (byte)'B') && (ordType != (byte)'C') && (ordType != (byte)'L') && (ordType != (byte)'M') && (ordType != (byte)'H') && (ordType != (byte)'I') && (ordType != (byte)'J') && (ordType != (byte)'K') && (ordType != (byte)'3') && (ordType != (byte)'2') && (ordType != (byte)'1') && (ordType != (byte)'Q') && (ordType != (byte)'7') && (ordType != (byte)'P') && (ordType != (byte)'6') && (ordType != (byte)'5') && (ordType != (byte)'4') && (ordType != (byte)'9') && (ordType != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 40);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasOrdType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return ordType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrdType() { return hasOrdType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrdType(byte[] src) {		
		if (src == null ) return;
		if (hasOrdType()) ordType = (byte)' ';		
		ordType = src[0];		
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdType(byte src) {		
		ordType = src;
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdType(String str) {		
		if (str == null ) return;
		if (hasOrdType()) ordType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		ordType = src[0];		
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackPrice() {		
		getPrice();		
	}		
			
	public long getPrice() { 		
		if ( hasPrice()) {		
			if (hasPrice == FixUtils.TAG_HAS_VALUE) {		
				return price; 		
			} else {

				buf.position(hasPrice);

			price = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return price;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPrice() { return hasPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPrice(byte[] src) {		
		if (src == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice(long src) {		
		price = src;
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice(String str) {		
		if (str == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPriceProtectionScope() {		
		getPriceProtectionScope();		
	}		
			
	public byte getPriceProtectionScope() { 		
		if ( hasPriceProtectionScope()) {		
			if (hasPriceProtectionScope == FixUtils.TAG_HAS_VALUE) {		
				return priceProtectionScope; 		
			} else {

				buf.position(hasPriceProtectionScope);

			priceProtectionScope = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (priceProtectionScope != (byte)'3') && (priceProtectionScope != (byte)'2') && (priceProtectionScope != (byte)'1') && (priceProtectionScope != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1092);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasPriceProtectionScope = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return priceProtectionScope;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasPriceProtectionScope() { return hasPriceProtectionScope != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPriceProtectionScope(byte[] src) {		
		if (src == null ) return;
		if (hasPriceProtectionScope()) priceProtectionScope = (byte)' ';		
		priceProtectionScope = src[0];		
		hasPriceProtectionScope = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceProtectionScope(byte src) {		
		priceProtectionScope = src;
		hasPriceProtectionScope = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceProtectionScope(String str) {		
		if (str == null ) return;
		if (hasPriceProtectionScope()) priceProtectionScope = (byte)' ';		
		byte[] src = str.getBytes(); 		
		priceProtectionScope = src[0];		
		hasPriceProtectionScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackStopPx() {		
		getStopPx();		
	}		
			
	public long getStopPx() { 		
		if ( hasStopPx()) {		
			if (hasStopPx == FixUtils.TAG_HAS_VALUE) {		
				return stopPx; 		
			} else {

				buf.position(hasStopPx);

			stopPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasStopPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return stopPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStopPx() { return hasStopPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStopPx(byte[] src) {		
		if (src == null ) return;
		if (hasStopPx()) stopPx = FixUtils.TAG_HAS_NO_VALUE;		
		stopPx = FixUtils.longValueOf(src, 0, src.length);
		hasStopPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStopPx(long src) {		
		stopPx = src;
		hasStopPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStopPx(String str) {		
		if (str == null ) return;
		if (hasStopPx()) stopPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		stopPx = FixUtils.longValueOf(src, 0, src.length);
		hasStopPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPeggedPrice() {		
		getPeggedPrice();		
	}		
			
	public long getPeggedPrice() { 		
		if ( hasPeggedPrice()) {		
			if (hasPeggedPrice == FixUtils.TAG_HAS_VALUE) {		
				return peggedPrice; 		
			} else {

				buf.position(hasPeggedPrice);

			peggedPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPeggedPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return peggedPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPeggedPrice() { return hasPeggedPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPeggedPrice(byte[] src) {		
		if (src == null ) return;
		if (hasPeggedPrice()) peggedPrice = FixUtils.TAG_HAS_NO_VALUE;		
		peggedPrice = FixUtils.longValueOf(src, 0, src.length);
		hasPeggedPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPeggedPrice(long src) {		
		peggedPrice = src;
		hasPeggedPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPeggedPrice(String str) {		
		if (str == null ) return;
		if (hasPeggedPrice()) peggedPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		peggedPrice = FixUtils.longValueOf(src, 0, src.length);
		hasPeggedPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPeggedRefPrice() {		
		getPeggedRefPrice();		
	}		
			
	public long getPeggedRefPrice() { 		
		if ( hasPeggedRefPrice()) {		
			if (hasPeggedRefPrice == FixUtils.TAG_HAS_VALUE) {		
				return peggedRefPrice; 		
			} else {

				buf.position(hasPeggedRefPrice);

			peggedRefPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPeggedRefPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return peggedRefPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPeggedRefPrice() { return hasPeggedRefPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPeggedRefPrice(byte[] src) {		
		if (src == null ) return;
		if (hasPeggedRefPrice()) peggedRefPrice = FixUtils.TAG_HAS_NO_VALUE;		
		peggedRefPrice = FixUtils.longValueOf(src, 0, src.length);
		hasPeggedRefPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPeggedRefPrice(long src) {		
		peggedRefPrice = src;
		hasPeggedRefPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPeggedRefPrice(String str) {		
		if (str == null ) return;
		if (hasPeggedRefPrice()) peggedRefPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		peggedRefPrice = FixUtils.longValueOf(src, 0, src.length);
		hasPeggedRefPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDiscretionPrice() {		
		getDiscretionPrice();		
	}		
			
	public long getDiscretionPrice() { 		
		if ( hasDiscretionPrice()) {		
			if (hasDiscretionPrice == FixUtils.TAG_HAS_VALUE) {		
				return discretionPrice; 		
			} else {

				buf.position(hasDiscretionPrice);

			discretionPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasDiscretionPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return discretionPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDiscretionPrice() { return hasDiscretionPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDiscretionPrice(byte[] src) {		
		if (src == null ) return;
		if (hasDiscretionPrice()) discretionPrice = FixUtils.TAG_HAS_NO_VALUE;		
		discretionPrice = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionPrice(long src) {		
		discretionPrice = src;
		hasDiscretionPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionPrice(String str) {		
		if (str == null ) return;
		if (hasDiscretionPrice()) discretionPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		discretionPrice = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTargetStrategy() {		
		getTargetStrategy();		
	}		
			
	public long getTargetStrategy() { 		
		if ( hasTargetStrategy()) {		
			if (hasTargetStrategy == FixUtils.TAG_HAS_VALUE) {		
				return targetStrategy; 		
			} else {

				buf.position(hasTargetStrategy);

			targetStrategy = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTargetStrategy = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return targetStrategy;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTargetStrategy() { return hasTargetStrategy != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTargetStrategy(byte[] src) {		
		if (src == null ) return;
		if (hasTargetStrategy()) targetStrategy = FixUtils.TAG_HAS_NO_VALUE;		
		targetStrategy = FixUtils.longValueOf(src, 0, src.length);
		hasTargetStrategy = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTargetStrategy(long src) {		
		targetStrategy = src;
		hasTargetStrategy = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTargetStrategy(String str) {		
		if (str == null ) return;
		if (hasTargetStrategy()) targetStrategy = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		targetStrategy = FixUtils.longValueOf(src, 0, src.length);
		hasTargetStrategy = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTargetStrategyParameters() {		
		getTargetStrategyParameters();		
	}		
			
	public byte[] getTargetStrategyParameters() { 		
		if ( hasTargetStrategyParameters()) {		
			if (hasTargetStrategyParameters == FixUtils.TAG_HAS_VALUE) {		
				return targetStrategyParameters; 		
			} else {

				buf.position(hasTargetStrategyParameters);

			FixMessage.getTagStringValue(buf, targetStrategyParameters, 0, targetStrategyParameters.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTargetStrategyParameters = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return targetStrategyParameters;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTargetStrategyParameters() { return hasTargetStrategyParameters != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTargetStrategyParameters(byte[] src) {		
		if (src == null ) return;
		if (hasTargetStrategyParameters()) FixUtils.fillSpace(targetStrategyParameters);		
		FixUtils.copy(targetStrategyParameters, src); 		
		hasTargetStrategyParameters = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTargetStrategyParameters(String str) {		
		if (str == null ) return;
		if (hasTargetStrategyParameters()) FixUtils.fillSpace(targetStrategyParameters);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(targetStrategyParameters, src); 		
		hasTargetStrategyParameters = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackParticipationRate() {		
		getParticipationRate();		
	}		
			
	public long getParticipationRate() { 		
		if ( hasParticipationRate()) {		
			if (hasParticipationRate == FixUtils.TAG_HAS_VALUE) {		
				return participationRate; 		
			} else {

				buf.position(hasParticipationRate);

			participationRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasParticipationRate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return participationRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasParticipationRate() { return hasParticipationRate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setParticipationRate(byte[] src) {		
		if (src == null ) return;
		if (hasParticipationRate()) participationRate = FixUtils.TAG_HAS_NO_VALUE;		
		participationRate = FixUtils.longValueOf(src, 0, src.length);
		hasParticipationRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setParticipationRate(long src) {		
		participationRate = src;
		hasParticipationRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setParticipationRate(String str) {		
		if (str == null ) return;
		if (hasParticipationRate()) participationRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		participationRate = FixUtils.longValueOf(src, 0, src.length);
		hasParticipationRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTargetStrategyPerformance() {		
		getTargetStrategyPerformance();		
	}		
			
	public long getTargetStrategyPerformance() { 		
		if ( hasTargetStrategyPerformance()) {		
			if (hasTargetStrategyPerformance == FixUtils.TAG_HAS_VALUE) {		
				return targetStrategyPerformance; 		
			} else {

				buf.position(hasTargetStrategyPerformance);

			targetStrategyPerformance = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTargetStrategyPerformance = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return targetStrategyPerformance;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTargetStrategyPerformance() { return hasTargetStrategyPerformance != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTargetStrategyPerformance(byte[] src) {		
		if (src == null ) return;
		if (hasTargetStrategyPerformance()) targetStrategyPerformance = FixUtils.TAG_HAS_NO_VALUE;		
		targetStrategyPerformance = FixUtils.longValueOf(src, 0, src.length);
		hasTargetStrategyPerformance = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTargetStrategyPerformance(long src) {		
		targetStrategyPerformance = src;
		hasTargetStrategyPerformance = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTargetStrategyPerformance(String str) {		
		if (str == null ) return;
		if (hasTargetStrategyPerformance()) targetStrategyPerformance = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		targetStrategyPerformance = FixUtils.longValueOf(src, 0, src.length);
		hasTargetStrategyPerformance = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackComplianceID() {		
		getComplianceID();		
	}		
			
	public byte[] getComplianceID() { 		
		if ( hasComplianceID()) {		
			if (hasComplianceID == FixUtils.TAG_HAS_VALUE) {		
				return complianceID; 		
			} else {

				buf.position(hasComplianceID);

			FixMessage.getTagStringValue(buf, complianceID, 0, complianceID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasComplianceID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return complianceID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasComplianceID() { return hasComplianceID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setComplianceID(byte[] src) {		
		if (src == null ) return;
		if (hasComplianceID()) FixUtils.fillSpace(complianceID);		
		FixUtils.copy(complianceID, src); 		
		hasComplianceID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setComplianceID(String str) {		
		if (str == null ) return;
		if (hasComplianceID()) FixUtils.fillSpace(complianceID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(complianceID, src); 		
		hasComplianceID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSolicitedFlag() {		
		getSolicitedFlag();		
	}		
			
	public boolean getSolicitedFlag() { 		
		if ( hasSolicitedFlag()) {		
			if (hasSolicitedFlag == FixUtils.TAG_HAS_VALUE) {		
				return solicitedFlag; 		
			} else {

				buf.position(hasSolicitedFlag);

			solicitedFlag = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasSolicitedFlag = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return solicitedFlag;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasSolicitedFlag() { return hasSolicitedFlag != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSolicitedFlag(byte[] src) {		
		if (src == null ) return;
		if (hasSolicitedFlag()) solicitedFlag = false;		
		solicitedFlag = src[0]==(byte)'Y'?true:false;		
		hasSolicitedFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSolicitedFlag(boolean src) {		
		solicitedFlag = src;
		hasSolicitedFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSolicitedFlag(String str) {		
		if (str == null ) return;
		if (hasSolicitedFlag()) solicitedFlag = false;		
		byte[] src = str.getBytes(); 		
		solicitedFlag = src[0]==(byte)'Y'?true:false;		
		hasSolicitedFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTimeInForce() {		
		getTimeInForce();		
	}		
			
	public byte getTimeInForce() { 		
		if ( hasTimeInForce()) {		
			if (hasTimeInForce == FixUtils.TAG_HAS_VALUE) {		
				return timeInForce; 		
			} else {

				buf.position(hasTimeInForce);

			timeInForce = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (timeInForce != (byte)'3') && (timeInForce != (byte)'2') && (timeInForce != (byte)'1') && (timeInForce != (byte)'0') && (timeInForce != (byte)'7') && (timeInForce != (byte)'6') && (timeInForce != (byte)'5') && (timeInForce != (byte)'4') && (timeInForce != (byte)'9') && (timeInForce != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 59);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return timeInForce;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTimeInForce() { return hasTimeInForce != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTimeInForce(byte[] src) {		
		if (src == null ) return;
		if (hasTimeInForce()) timeInForce = (byte)' ';		
		timeInForce = src[0];		
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeInForce(byte src) {		
		timeInForce = src;
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeInForce(String str) {		
		if (str == null ) return;
		if (hasTimeInForce()) timeInForce = (byte)' ';		
		byte[] src = str.getBytes(); 		
		timeInForce = src[0];		
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEffectiveTime() {		
		getEffectiveTime();		
	}		
			
	public byte[] getEffectiveTime() { 		
		if ( hasEffectiveTime()) {		
			if (hasEffectiveTime == FixUtils.TAG_HAS_VALUE) {		
				return effectiveTime; 		
			} else {

				buf.position(hasEffectiveTime);

			FixMessage.getTagStringValue(buf, effectiveTime, 0, effectiveTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return effectiveTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEffectiveTime() { return hasEffectiveTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEffectiveTime(byte[] src) {		
		if (src == null ) return;
		if (hasEffectiveTime()) FixUtils.fillSpace(effectiveTime);		
		FixUtils.copy(effectiveTime, src); 		
		hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEffectiveTime(String str) {		
		if (str == null ) return;
		if (hasEffectiveTime()) FixUtils.fillSpace(effectiveTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(effectiveTime, src); 		
		hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExpireDate() {		
		getExpireDate();		
	}		
			
	public byte[] getExpireDate() { 		
		if ( hasExpireDate()) {		
			if (hasExpireDate == FixUtils.TAG_HAS_VALUE) {		
				return expireDate; 		
			} else {

				buf.position(hasExpireDate);

			FixMessage.getTagStringValue(buf, expireDate, 0, expireDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExpireDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return expireDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExpireDate() { return hasExpireDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExpireDate(byte[] src) {		
		if (src == null ) return;
		if (hasExpireDate()) FixUtils.fillSpace(expireDate);		
		FixUtils.copy(expireDate, src); 		
		hasExpireDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExpireDate(String str) {		
		if (str == null ) return;
		if (hasExpireDate()) FixUtils.fillSpace(expireDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(expireDate, src); 		
		hasExpireDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExpireTime() {		
		getExpireTime();		
	}		
			
	public byte[] getExpireTime() { 		
		if ( hasExpireTime()) {		
			if (hasExpireTime == FixUtils.TAG_HAS_VALUE) {		
				return expireTime; 		
			} else {

				buf.position(hasExpireTime);

			FixMessage.getTagStringValue(buf, expireTime, 0, expireTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExpireTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return expireTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExpireTime() { return hasExpireTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExpireTime(byte[] src) {		
		if (src == null ) return;
		if (hasExpireTime()) FixUtils.fillSpace(expireTime);		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExpireTime(String str) {		
		if (str == null ) return;
		if (hasExpireTime()) FixUtils.fillSpace(expireTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExecInst() {		
		getExecInst();		
	}		
			
	public byte[] getExecInst() { 		
		if ( hasExecInst()) {		
			if (hasExecInst == FixUtils.TAG_HAS_VALUE) {		
				return execInst; 		
			} else {

				buf.position(hasExecInst);

			FixMessage.getTagStringValue(buf, execInst, 0, execInst.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExecInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execInst;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExecInst() { return hasExecInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecInst(byte[] src) {		
		if (src == null ) return;
		if (hasExecInst()) FixUtils.fillSpace(execInst);		
		FixUtils.copy(execInst, src); 		
		hasExecInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecInst(String str) {		
		if (str == null ) return;
		if (hasExecInst()) FixUtils.fillSpace(execInst);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(execInst, src); 		
		hasExecInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAggressorIndicator() {		
		getAggressorIndicator();		
	}		
			
	public boolean getAggressorIndicator() { 		
		if ( hasAggressorIndicator()) {		
			if (hasAggressorIndicator == FixUtils.TAG_HAS_VALUE) {		
				return aggressorIndicator; 		
			} else {

				buf.position(hasAggressorIndicator);

			aggressorIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasAggressorIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return aggressorIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasAggressorIndicator() { return hasAggressorIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAggressorIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasAggressorIndicator()) aggressorIndicator = false;		
		aggressorIndicator = src[0]==(byte)'Y'?true:false;		
		hasAggressorIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAggressorIndicator(boolean src) {		
		aggressorIndicator = src;
		hasAggressorIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAggressorIndicator(String str) {		
		if (str == null ) return;
		if (hasAggressorIndicator()) aggressorIndicator = false;		
		byte[] src = str.getBytes(); 		
		aggressorIndicator = src[0]==(byte)'Y'?true:false;		
		hasAggressorIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrderCapacity() {		
		getOrderCapacity();		
	}		
			
	public byte getOrderCapacity() { 		
		if ( hasOrderCapacity()) {		
			if (hasOrderCapacity == FixUtils.TAG_HAS_VALUE) {		
				return orderCapacity; 		
			} else {

				buf.position(hasOrderCapacity);

			orderCapacity = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (orderCapacity != (byte)'W') && (orderCapacity != (byte)'G') && (orderCapacity != (byte)'P') && (orderCapacity != (byte)'A') && (orderCapacity != (byte)'R') && (orderCapacity != (byte)'I') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 528);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderCapacity;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrderCapacity() { return hasOrderCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasOrderCapacity()) orderCapacity = (byte)' ';		
		orderCapacity = src[0];		
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderCapacity(byte src) {		
		orderCapacity = src;
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderCapacity(String str) {		
		if (str == null ) return;
		if (hasOrderCapacity()) orderCapacity = (byte)' ';		
		byte[] src = str.getBytes(); 		
		orderCapacity = src[0];		
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrderRestrictions() {		
		getOrderRestrictions();		
	}		
			
	public byte[] getOrderRestrictions() { 		
		if ( hasOrderRestrictions()) {		
			if (hasOrderRestrictions == FixUtils.TAG_HAS_VALUE) {		
				return orderRestrictions; 		
			} else {

				buf.position(hasOrderRestrictions);

			FixMessage.getTagStringValue(buf, orderRestrictions, 0, orderRestrictions.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderRestrictions;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderRestrictions() { return hasOrderRestrictions != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderRestrictions(byte[] src) {		
		if (src == null ) return;
		if (hasOrderRestrictions()) FixUtils.fillSpace(orderRestrictions);		
		FixUtils.copy(orderRestrictions, src); 		
		hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderRestrictions(String str) {		
		if (str == null ) return;
		if (hasOrderRestrictions()) FixUtils.fillSpace(orderRestrictions);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderRestrictions, src); 		
		hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
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

			preTradeAnonymity = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
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
			
	public void crackCustOrderCapacity() {		
		getCustOrderCapacity();		
	}		
			
	public long getCustOrderCapacity() { 		
		if ( hasCustOrderCapacity()) {		
			if (hasCustOrderCapacity == FixUtils.TAG_HAS_VALUE) {		
				return custOrderCapacity; 		
			} else {

				buf.position(hasCustOrderCapacity);

			custOrderCapacity = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCustOrderCapacity = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return custOrderCapacity;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCustOrderCapacity() { return hasCustOrderCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCustOrderCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasCustOrderCapacity()) custOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		custOrderCapacity = FixUtils.longValueOf(src, 0, src.length);
		hasCustOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCustOrderCapacity(long src) {		
		custOrderCapacity = src;
		hasCustOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCustOrderCapacity(String str) {		
		if (str == null ) return;
		if (hasCustOrderCapacity()) custOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		custOrderCapacity = FixUtils.longValueOf(src, 0, src.length);
		hasCustOrderCapacity = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackUnderlyingLastQty() {		
		getUnderlyingLastQty();		
	}		
			
	public long getUnderlyingLastQty() { 		
		if ( hasUnderlyingLastQty()) {		
			if (hasUnderlyingLastQty == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLastQty; 		
			} else {

				buf.position(hasUnderlyingLastQty);

			underlyingLastQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasUnderlyingLastQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return underlyingLastQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingLastQty() { return hasUnderlyingLastQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUnderlyingLastQty(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLastQty()) underlyingLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLastQty = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingLastQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingLastQty(long src) {		
		underlyingLastQty = src;
		hasUnderlyingLastQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingLastQty(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLastQty()) underlyingLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingLastQty = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingLastQty = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackUnderlyingLastPx() {		
		getUnderlyingLastPx();		
	}		
			
	public long getUnderlyingLastPx() { 		
		if ( hasUnderlyingLastPx()) {		
			if (hasUnderlyingLastPx == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLastPx; 		
			} else {

				buf.position(hasUnderlyingLastPx);

			underlyingLastPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasUnderlyingLastPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return underlyingLastPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingLastPx() { return hasUnderlyingLastPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUnderlyingLastPx(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLastPx()) underlyingLastPx = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLastPx = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingLastPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingLastPx(long src) {		
		underlyingLastPx = src;
		hasUnderlyingLastPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingLastPx(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLastPx()) underlyingLastPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingLastPx = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingLastPx = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackTradingSessionID() {		
		getTradingSessionID();		
	}		
			
	public byte[] getTradingSessionID() { 		
		if ( hasTradingSessionID()) {		
			if (hasTradingSessionID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionID; 		
			} else {

				buf.position(hasTradingSessionID);

			FixMessage.getTagStringValue(buf, tradingSessionID, 0, tradingSessionID.length, err);
		
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
		if (hasTradingSessionID()) FixUtils.fillSpace(tradingSessionID);		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradingSessionID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionID()) FixUtils.fillSpace(tradingSessionID);		
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

			FixMessage.getTagStringValue(buf, tradingSessionSubID, 0, tradingSessionSubID.length, err);
		
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
		if (hasTradingSessionSubID()) FixUtils.fillSpace(tradingSessionSubID);		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradingSessionSubID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillSpace(tradingSessionSubID);		
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

			FixMessage.getTagStringValue(buf, timeBracket, 0, timeBracket.length, err);
		
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
		if (hasTimeBracket()) FixUtils.fillSpace(timeBracket);		
		FixUtils.copy(timeBracket, src); 		
		hasTimeBracket = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeBracket(String str) {		
		if (str == null ) return;
		if (hasTimeBracket()) FixUtils.fillSpace(timeBracket);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(timeBracket, src); 		
		hasTimeBracket = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastCapacity() {		
		getLastCapacity();		
	}		
			
	public byte getLastCapacity() { 		
		if ( hasLastCapacity()) {		
			if (hasLastCapacity == FixUtils.TAG_HAS_VALUE) {		
				return lastCapacity; 		
			} else {

				buf.position(hasLastCapacity);

			lastCapacity = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (lastCapacity != (byte)'3') && (lastCapacity != (byte)'2') && (lastCapacity != (byte)'1') && (lastCapacity != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 29);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasLastCapacity = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastCapacity;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasLastCapacity() { return hasLastCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasLastCapacity()) lastCapacity = (byte)' ';		
		lastCapacity = src[0];		
		hasLastCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastCapacity(byte src) {		
		lastCapacity = src;
		hasLastCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastCapacity(String str) {		
		if (str == null ) return;
		if (hasLastCapacity()) lastCapacity = (byte)' ';		
		byte[] src = str.getBytes(); 		
		lastCapacity = src[0];		
		hasLastCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLeavesQty() {		
		getLeavesQty();		
	}		
			
	public long getLeavesQty() { 		
		if ( hasLeavesQty()) {		
			if (hasLeavesQty == FixUtils.TAG_HAS_VALUE) {		
				return leavesQty; 		
			} else {

				buf.position(hasLeavesQty);

			leavesQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLeavesQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return leavesQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLeavesQty() { return hasLeavesQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLeavesQty(byte[] src) {		
		if (src == null ) return;
		if (hasLeavesQty()) leavesQty = FixUtils.TAG_HAS_NO_VALUE;		
		leavesQty = FixUtils.longValueOf(src, 0, src.length);
		hasLeavesQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLeavesQty(long src) {		
		leavesQty = src;
		hasLeavesQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLeavesQty(String str) {		
		if (str == null ) return;
		if (hasLeavesQty()) leavesQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		leavesQty = FixUtils.longValueOf(src, 0, src.length);
		hasLeavesQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCumQty() {		
		getCumQty();		
	}		
			
	public long getCumQty() { 		
		if ( hasCumQty()) {		
			if (hasCumQty == FixUtils.TAG_HAS_VALUE) {		
				return cumQty; 		
			} else {

				buf.position(hasCumQty);

			cumQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCumQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return cumQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCumQty() { return hasCumQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCumQty(byte[] src) {		
		if (src == null ) return;
		if (hasCumQty()) cumQty = FixUtils.TAG_HAS_NO_VALUE;		
		cumQty = FixUtils.longValueOf(src, 0, src.length);
		hasCumQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCumQty(long src) {		
		cumQty = src;
		hasCumQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCumQty(String str) {		
		if (str == null ) return;
		if (hasCumQty()) cumQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		cumQty = FixUtils.longValueOf(src, 0, src.length);
		hasCumQty = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackDayOrderQty() {		
		getDayOrderQty();		
	}		
			
	public long getDayOrderQty() { 		
		if ( hasDayOrderQty()) {		
			if (hasDayOrderQty == FixUtils.TAG_HAS_VALUE) {		
				return dayOrderQty; 		
			} else {

				buf.position(hasDayOrderQty);

			dayOrderQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasDayOrderQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return dayOrderQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDayOrderQty() { return hasDayOrderQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDayOrderQty(byte[] src) {		
		if (src == null ) return;
		if (hasDayOrderQty()) dayOrderQty = FixUtils.TAG_HAS_NO_VALUE;		
		dayOrderQty = FixUtils.longValueOf(src, 0, src.length);
		hasDayOrderQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDayOrderQty(long src) {		
		dayOrderQty = src;
		hasDayOrderQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDayOrderQty(String str) {		
		if (str == null ) return;
		if (hasDayOrderQty()) dayOrderQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		dayOrderQty = FixUtils.longValueOf(src, 0, src.length);
		hasDayOrderQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDayCumQty() {		
		getDayCumQty();		
	}		
			
	public long getDayCumQty() { 		
		if ( hasDayCumQty()) {		
			if (hasDayCumQty == FixUtils.TAG_HAS_VALUE) {		
				return dayCumQty; 		
			} else {

				buf.position(hasDayCumQty);

			dayCumQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasDayCumQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return dayCumQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDayCumQty() { return hasDayCumQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDayCumQty(byte[] src) {		
		if (src == null ) return;
		if (hasDayCumQty()) dayCumQty = FixUtils.TAG_HAS_NO_VALUE;		
		dayCumQty = FixUtils.longValueOf(src, 0, src.length);
		hasDayCumQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDayCumQty(long src) {		
		dayCumQty = src;
		hasDayCumQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDayCumQty(String str) {		
		if (str == null ) return;
		if (hasDayCumQty()) dayCumQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		dayCumQty = FixUtils.longValueOf(src, 0, src.length);
		hasDayCumQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDayAvgPx() {		
		getDayAvgPx();		
	}		
			
	public long getDayAvgPx() { 		
		if ( hasDayAvgPx()) {		
			if (hasDayAvgPx == FixUtils.TAG_HAS_VALUE) {		
				return dayAvgPx; 		
			} else {

				buf.position(hasDayAvgPx);

			dayAvgPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasDayAvgPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return dayAvgPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDayAvgPx() { return hasDayAvgPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDayAvgPx(byte[] src) {		
		if (src == null ) return;
		if (hasDayAvgPx()) dayAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		dayAvgPx = FixUtils.longValueOf(src, 0, src.length);
		hasDayAvgPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDayAvgPx(long src) {		
		dayAvgPx = src;
		hasDayAvgPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDayAvgPx(String str) {		
		if (str == null ) return;
		if (hasDayAvgPx()) dayAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		dayAvgPx = FixUtils.longValueOf(src, 0, src.length);
		hasDayAvgPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTotNoFills() {		
		getTotNoFills();		
	}		
			
	public long getTotNoFills() { 		
		if ( hasTotNoFills()) {		
			if (hasTotNoFills == FixUtils.TAG_HAS_VALUE) {		
				return totNoFills; 		
			} else {

				buf.position(hasTotNoFills);

			totNoFills = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotNoFills = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totNoFills;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNoFills() { return hasTotNoFills != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotNoFills(byte[] src) {		
		if (src == null ) return;
		if (hasTotNoFills()) totNoFills = FixUtils.TAG_HAS_NO_VALUE;		
		totNoFills = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoFills = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoFills(long src) {		
		totNoFills = src;
		hasTotNoFills = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoFills(String str) {		
		if (str == null ) return;
		if (hasTotNoFills()) totNoFills = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNoFills = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoFills = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackGTBookingInst() {		
		getGTBookingInst();		
	}		
			
	public long getGTBookingInst() { 		
		if ( hasGTBookingInst()) {		
			if (hasGTBookingInst == FixUtils.TAG_HAS_VALUE) {		
				return gTBookingInst; 		
			} else {

				buf.position(hasGTBookingInst);

			gTBookingInst = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasGTBookingInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return gTBookingInst;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasGTBookingInst() { return hasGTBookingInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setGTBookingInst(byte[] src) {		
		if (src == null ) return;
		if (hasGTBookingInst()) gTBookingInst = FixUtils.TAG_HAS_NO_VALUE;		
		gTBookingInst = FixUtils.longValueOf(src, 0, src.length);
		hasGTBookingInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setGTBookingInst(long src) {		
		gTBookingInst = src;
		hasGTBookingInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setGTBookingInst(String str) {		
		if (str == null ) return;
		if (hasGTBookingInst()) gTBookingInst = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		gTBookingInst = FixUtils.longValueOf(src, 0, src.length);
		hasGTBookingInst = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackReportToExch() {		
		getReportToExch();		
	}		
			
	public boolean getReportToExch() { 		
		if ( hasReportToExch()) {		
			if (hasReportToExch == FixUtils.TAG_HAS_VALUE) {		
				return reportToExch; 		
			} else {

				buf.position(hasReportToExch);

			reportToExch = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasReportToExch = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return reportToExch;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasReportToExch() { return hasReportToExch != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setReportToExch(byte[] src) {		
		if (src == null ) return;
		if (hasReportToExch()) reportToExch = false;		
		reportToExch = src[0]==(byte)'Y'?true:false;		
		hasReportToExch = FixUtils.TAG_HAS_VALUE;		
	}

	public void setReportToExch(boolean src) {		
		reportToExch = src;
		hasReportToExch = FixUtils.TAG_HAS_VALUE;		
	}

	public void setReportToExch(String str) {		
		if (str == null ) return;
		if (hasReportToExch()) reportToExch = false;		
		byte[] src = str.getBytes(); 		
		reportToExch = src[0]==(byte)'Y'?true:false;		
		hasReportToExch = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackNumDaysInterest() {		
		getNumDaysInterest();		
	}		
			
	public long getNumDaysInterest() { 		
		if ( hasNumDaysInterest()) {		
			if (hasNumDaysInterest == FixUtils.TAG_HAS_VALUE) {		
				return numDaysInterest; 		
			} else {

				buf.position(hasNumDaysInterest);

			numDaysInterest = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasNumDaysInterest = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return numDaysInterest;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNumDaysInterest() { return hasNumDaysInterest != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNumDaysInterest(byte[] src) {		
		if (src == null ) return;
		if (hasNumDaysInterest()) numDaysInterest = FixUtils.TAG_HAS_NO_VALUE;		
		numDaysInterest = FixUtils.longValueOf(src, 0, src.length);
		hasNumDaysInterest = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNumDaysInterest(long src) {		
		numDaysInterest = src;
		hasNumDaysInterest = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNumDaysInterest(String str) {		
		if (str == null ) return;
		if (hasNumDaysInterest()) numDaysInterest = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		numDaysInterest = FixUtils.longValueOf(src, 0, src.length);
		hasNumDaysInterest = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExDate() {		
		getExDate();		
	}		
			
	public byte[] getExDate() { 		
		if ( hasExDate()) {		
			if (hasExDate == FixUtils.TAG_HAS_VALUE) {		
				return exDate; 		
			} else {

				buf.position(hasExDate);

			FixMessage.getTagStringValue(buf, exDate, 0, exDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return exDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExDate() { return hasExDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExDate(byte[] src) {		
		if (src == null ) return;
		if (hasExDate()) FixUtils.fillSpace(exDate);		
		FixUtils.copy(exDate, src); 		
		hasExDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExDate(String str) {		
		if (str == null ) return;
		if (hasExDate()) FixUtils.fillSpace(exDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(exDate, src); 		
		hasExDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAccruedInterestRate() {		
		getAccruedInterestRate();		
	}		
			
	public long getAccruedInterestRate() { 		
		if ( hasAccruedInterestRate()) {		
			if (hasAccruedInterestRate == FixUtils.TAG_HAS_VALUE) {		
				return accruedInterestRate; 		
			} else {

				buf.position(hasAccruedInterestRate);

			accruedInterestRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAccruedInterestRate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return accruedInterestRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAccruedInterestRate() { return hasAccruedInterestRate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAccruedInterestRate(byte[] src) {		
		if (src == null ) return;
		if (hasAccruedInterestRate()) accruedInterestRate = FixUtils.TAG_HAS_NO_VALUE;		
		accruedInterestRate = FixUtils.longValueOf(src, 0, src.length);
		hasAccruedInterestRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccruedInterestRate(long src) {		
		accruedInterestRate = src;
		hasAccruedInterestRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccruedInterestRate(String str) {		
		if (str == null ) return;
		if (hasAccruedInterestRate()) accruedInterestRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		accruedInterestRate = FixUtils.longValueOf(src, 0, src.length);
		hasAccruedInterestRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAccruedInterestAmt() {		
		getAccruedInterestAmt();		
	}		
			
	public long getAccruedInterestAmt() { 		
		if ( hasAccruedInterestAmt()) {		
			if (hasAccruedInterestAmt == FixUtils.TAG_HAS_VALUE) {		
				return accruedInterestAmt; 		
			} else {

				buf.position(hasAccruedInterestAmt);

			accruedInterestAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return accruedInterestAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAccruedInterestAmt() { return hasAccruedInterestAmt != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAccruedInterestAmt(byte[] src) {		
		if (src == null ) return;
		if (hasAccruedInterestAmt()) accruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		accruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccruedInterestAmt(long src) {		
		accruedInterestAmt = src;
		hasAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccruedInterestAmt(String str) {		
		if (str == null ) return;
		if (hasAccruedInterestAmt()) accruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		accruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackInterestAtMaturity() {		
		getInterestAtMaturity();		
	}		
			
	public long getInterestAtMaturity() { 		
		if ( hasInterestAtMaturity()) {		
			if (hasInterestAtMaturity == FixUtils.TAG_HAS_VALUE) {		
				return interestAtMaturity; 		
			} else {

				buf.position(hasInterestAtMaturity);

			interestAtMaturity = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasInterestAtMaturity = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return interestAtMaturity;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasInterestAtMaturity() { return hasInterestAtMaturity != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setInterestAtMaturity(byte[] src) {		
		if (src == null ) return;
		if (hasInterestAtMaturity()) interestAtMaturity = FixUtils.TAG_HAS_NO_VALUE;		
		interestAtMaturity = FixUtils.longValueOf(src, 0, src.length);
		hasInterestAtMaturity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setInterestAtMaturity(long src) {		
		interestAtMaturity = src;
		hasInterestAtMaturity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setInterestAtMaturity(String str) {		
		if (str == null ) return;
		if (hasInterestAtMaturity()) interestAtMaturity = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		interestAtMaturity = FixUtils.longValueOf(src, 0, src.length);
		hasInterestAtMaturity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEndAccruedInterestAmt() {		
		getEndAccruedInterestAmt();		
	}		
			
	public long getEndAccruedInterestAmt() { 		
		if ( hasEndAccruedInterestAmt()) {		
			if (hasEndAccruedInterestAmt == FixUtils.TAG_HAS_VALUE) {		
				return endAccruedInterestAmt; 		
			} else {

				buf.position(hasEndAccruedInterestAmt);

			endAccruedInterestAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEndAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return endAccruedInterestAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEndAccruedInterestAmt() { return hasEndAccruedInterestAmt != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEndAccruedInterestAmt(byte[] src) {		
		if (src == null ) return;
		if (hasEndAccruedInterestAmt()) endAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		endAccruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndAccruedInterestAmt(long src) {		
		endAccruedInterestAmt = src;
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndAccruedInterestAmt(String str) {		
		if (str == null ) return;
		if (hasEndAccruedInterestAmt()) endAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		endAccruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackStartCash() {		
		getStartCash();		
	}		
			
	public long getStartCash() { 		
		if ( hasStartCash()) {		
			if (hasStartCash == FixUtils.TAG_HAS_VALUE) {		
				return startCash; 		
			} else {

				buf.position(hasStartCash);

			startCash = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasStartCash = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return startCash;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStartCash() { return hasStartCash != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStartCash(byte[] src) {		
		if (src == null ) return;
		if (hasStartCash()) startCash = FixUtils.TAG_HAS_NO_VALUE;		
		startCash = FixUtils.longValueOf(src, 0, src.length);
		hasStartCash = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStartCash(long src) {		
		startCash = src;
		hasStartCash = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStartCash(String str) {		
		if (str == null ) return;
		if (hasStartCash()) startCash = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		startCash = FixUtils.longValueOf(src, 0, src.length);
		hasStartCash = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEndCash() {		
		getEndCash();		
	}		
			
	public long getEndCash() { 		
		if ( hasEndCash()) {		
			if (hasEndCash == FixUtils.TAG_HAS_VALUE) {		
				return endCash; 		
			} else {

				buf.position(hasEndCash);

			endCash = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEndCash = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return endCash;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEndCash() { return hasEndCash != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEndCash(byte[] src) {		
		if (src == null ) return;
		if (hasEndCash()) endCash = FixUtils.TAG_HAS_NO_VALUE;		
		endCash = FixUtils.longValueOf(src, 0, src.length);
		hasEndCash = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndCash(long src) {		
		endCash = src;
		hasEndCash = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndCash(String str) {		
		if (str == null ) return;
		if (hasEndCash()) endCash = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		endCash = FixUtils.longValueOf(src, 0, src.length);
		hasEndCash = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradedFlatSwitch() {		
		getTradedFlatSwitch();		
	}		
			
	public boolean getTradedFlatSwitch() { 		
		if ( hasTradedFlatSwitch()) {		
			if (hasTradedFlatSwitch == FixUtils.TAG_HAS_VALUE) {		
				return tradedFlatSwitch; 		
			} else {

				buf.position(hasTradedFlatSwitch);

			tradedFlatSwitch = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasTradedFlatSwitch = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradedFlatSwitch;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasTradedFlatSwitch() { return hasTradedFlatSwitch != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradedFlatSwitch(byte[] src) {		
		if (src == null ) return;
		if (hasTradedFlatSwitch()) tradedFlatSwitch = false;		
		tradedFlatSwitch = src[0]==(byte)'Y'?true:false;		
		hasTradedFlatSwitch = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradedFlatSwitch(boolean src) {		
		tradedFlatSwitch = src;
		hasTradedFlatSwitch = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradedFlatSwitch(String str) {		
		if (str == null ) return;
		if (hasTradedFlatSwitch()) tradedFlatSwitch = false;		
		byte[] src = str.getBytes(); 		
		tradedFlatSwitch = src[0]==(byte)'Y'?true:false;		
		hasTradedFlatSwitch = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBasisFeatureDate() {		
		getBasisFeatureDate();		
	}		
			
	public byte[] getBasisFeatureDate() { 		
		if ( hasBasisFeatureDate()) {		
			if (hasBasisFeatureDate == FixUtils.TAG_HAS_VALUE) {		
				return basisFeatureDate; 		
			} else {

				buf.position(hasBasisFeatureDate);

			FixMessage.getTagStringValue(buf, basisFeatureDate, 0, basisFeatureDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasBasisFeatureDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return basisFeatureDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBasisFeatureDate() { return hasBasisFeatureDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBasisFeatureDate(byte[] src) {		
		if (src == null ) return;
		if (hasBasisFeatureDate()) FixUtils.fillSpace(basisFeatureDate);		
		FixUtils.copy(basisFeatureDate, src); 		
		hasBasisFeatureDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBasisFeatureDate(String str) {		
		if (str == null ) return;
		if (hasBasisFeatureDate()) FixUtils.fillSpace(basisFeatureDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(basisFeatureDate, src); 		
		hasBasisFeatureDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBasisFeaturePrice() {		
		getBasisFeaturePrice();		
	}		
			
	public long getBasisFeaturePrice() { 		
		if ( hasBasisFeaturePrice()) {		
			if (hasBasisFeaturePrice == FixUtils.TAG_HAS_VALUE) {		
				return basisFeaturePrice; 		
			} else {

				buf.position(hasBasisFeaturePrice);

			basisFeaturePrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBasisFeaturePrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return basisFeaturePrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBasisFeaturePrice() { return hasBasisFeaturePrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBasisFeaturePrice(byte[] src) {		
		if (src == null ) return;
		if (hasBasisFeaturePrice()) basisFeaturePrice = FixUtils.TAG_HAS_NO_VALUE;		
		basisFeaturePrice = FixUtils.longValueOf(src, 0, src.length);
		hasBasisFeaturePrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBasisFeaturePrice(long src) {		
		basisFeaturePrice = src;
		hasBasisFeaturePrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBasisFeaturePrice(String str) {		
		if (str == null ) return;
		if (hasBasisFeaturePrice()) basisFeaturePrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		basisFeaturePrice = FixUtils.longValueOf(src, 0, src.length);
		hasBasisFeaturePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackConcession() {		
		getConcession();		
	}		
			
	public long getConcession() { 		
		if ( hasConcession()) {		
			if (hasConcession == FixUtils.TAG_HAS_VALUE) {		
				return concession; 		
			} else {

				buf.position(hasConcession);

			concession = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasConcession = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return concession;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasConcession() { return hasConcession != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setConcession(byte[] src) {		
		if (src == null ) return;
		if (hasConcession()) concession = FixUtils.TAG_HAS_NO_VALUE;		
		concession = FixUtils.longValueOf(src, 0, src.length);
		hasConcession = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConcession(long src) {		
		concession = src;
		hasConcession = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConcession(String str) {		
		if (str == null ) return;
		if (hasConcession()) concession = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		concession = FixUtils.longValueOf(src, 0, src.length);
		hasConcession = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTotalTakedown() {		
		getTotalTakedown();		
	}		
			
	public long getTotalTakedown() { 		
		if ( hasTotalTakedown()) {		
			if (hasTotalTakedown == FixUtils.TAG_HAS_VALUE) {		
				return totalTakedown; 		
			} else {

				buf.position(hasTotalTakedown);

			totalTakedown = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotalTakedown = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totalTakedown;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotalTakedown() { return hasTotalTakedown != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotalTakedown(byte[] src) {		
		if (src == null ) return;
		if (hasTotalTakedown()) totalTakedown = FixUtils.TAG_HAS_NO_VALUE;		
		totalTakedown = FixUtils.longValueOf(src, 0, src.length);
		hasTotalTakedown = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotalTakedown(long src) {		
		totalTakedown = src;
		hasTotalTakedown = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotalTakedown(String str) {		
		if (str == null ) return;
		if (hasTotalTakedown()) totalTakedown = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totalTakedown = FixUtils.longValueOf(src, 0, src.length);
		hasTotalTakedown = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackNetMoney() {		
		getNetMoney();		
	}		
			
	public long getNetMoney() { 		
		if ( hasNetMoney()) {		
			if (hasNetMoney == FixUtils.TAG_HAS_VALUE) {		
				return netMoney; 		
			} else {

				buf.position(hasNetMoney);

			netMoney = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasNetMoney = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return netMoney;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNetMoney() { return hasNetMoney != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNetMoney(byte[] src) {		
		if (src == null ) return;
		if (hasNetMoney()) netMoney = FixUtils.TAG_HAS_NO_VALUE;		
		netMoney = FixUtils.longValueOf(src, 0, src.length);
		hasNetMoney = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetMoney(long src) {		
		netMoney = src;
		hasNetMoney = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetMoney(String str) {		
		if (str == null ) return;
		if (hasNetMoney()) netMoney = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		netMoney = FixUtils.longValueOf(src, 0, src.length);
		hasNetMoney = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlCurrAmt() {		
		getSettlCurrAmt();		
	}		
			
	public long getSettlCurrAmt() { 		
		if ( hasSettlCurrAmt()) {		
			if (hasSettlCurrAmt == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrAmt; 		
			} else {

				buf.position(hasSettlCurrAmt);

			settlCurrAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlCurrAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlCurrAmt() { return hasSettlCurrAmt != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlCurrAmt(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrAmt()) settlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrAmt = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrAmt(long src) {		
		settlCurrAmt = src;
		hasSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrAmt(String str) {		
		if (str == null ) return;
		if (hasSettlCurrAmt()) settlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlCurrAmt = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackSettlCurrFxRate() {		
		getSettlCurrFxRate();		
	}		
			
	public long getSettlCurrFxRate() { 		
		if ( hasSettlCurrFxRate()) {		
			if (hasSettlCurrFxRate == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrFxRate; 		
			} else {

				buf.position(hasSettlCurrFxRate);

			settlCurrFxRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSettlCurrFxRate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlCurrFxRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlCurrFxRate() { return hasSettlCurrFxRate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlCurrFxRate(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrFxRate()) settlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrFxRate = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrFxRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrFxRate(long src) {		
		settlCurrFxRate = src;
		hasSettlCurrFxRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrFxRate(String str) {		
		if (str == null ) return;
		if (hasSettlCurrFxRate()) settlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlCurrFxRate = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrFxRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlCurrFxRateCalc() {		
		getSettlCurrFxRateCalc();		
	}		
			
	public byte getSettlCurrFxRateCalc() { 		
		if ( hasSettlCurrFxRateCalc()) {		
			if (hasSettlCurrFxRateCalc == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrFxRateCalc; 		
			} else {

				buf.position(hasSettlCurrFxRateCalc);

			settlCurrFxRateCalc = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (settlCurrFxRateCalc != (byte)'D') && (settlCurrFxRateCalc != (byte)'M') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 156);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlCurrFxRateCalc;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSettlCurrFxRateCalc() { return hasSettlCurrFxRateCalc != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlCurrFxRateCalc(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrFxRateCalc()) settlCurrFxRateCalc = (byte)' ';		
		settlCurrFxRateCalc = src[0];		
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrFxRateCalc(byte src) {		
		settlCurrFxRateCalc = src;
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrFxRateCalc(String str) {		
		if (str == null ) return;
		if (hasSettlCurrFxRateCalc()) settlCurrFxRateCalc = (byte)' ';		
		byte[] src = str.getBytes(); 		
		settlCurrFxRateCalc = src[0];		
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackHandlInst() {		
		getHandlInst();		
	}		
			
	public byte getHandlInst() { 		
		if ( hasHandlInst()) {		
			if (hasHandlInst == FixUtils.TAG_HAS_VALUE) {		
				return handlInst; 		
			} else {

				buf.position(hasHandlInst);

			handlInst = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (handlInst != (byte)'3') && (handlInst != (byte)'2') && (handlInst != (byte)'1') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 21);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasHandlInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return handlInst;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasHandlInst() { return hasHandlInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setHandlInst(byte[] src) {		
		if (src == null ) return;
		if (hasHandlInst()) handlInst = (byte)' ';		
		handlInst = src[0];		
		hasHandlInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHandlInst(byte src) {		
		handlInst = src;
		hasHandlInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHandlInst(String str) {		
		if (str == null ) return;
		if (hasHandlInst()) handlInst = (byte)' ';		
		byte[] src = str.getBytes(); 		
		handlInst = src[0];		
		hasHandlInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMinQty() {		
		getMinQty();		
	}		
			
	public long getMinQty() { 		
		if ( hasMinQty()) {		
			if (hasMinQty == FixUtils.TAG_HAS_VALUE) {		
				return minQty; 		
			} else {

				buf.position(hasMinQty);

			minQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMinQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return minQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMinQty() { return hasMinQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMinQty(byte[] src) {		
		if (src == null ) return;
		if (hasMinQty()) minQty = FixUtils.TAG_HAS_NO_VALUE;		
		minQty = FixUtils.longValueOf(src, 0, src.length);
		hasMinQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinQty(long src) {		
		minQty = src;
		hasMinQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinQty(String str) {		
		if (str == null ) return;
		if (hasMinQty()) minQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		minQty = FixUtils.longValueOf(src, 0, src.length);
		hasMinQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMatchIncrement() {		
		getMatchIncrement();		
	}		
			
	public long getMatchIncrement() { 		
		if ( hasMatchIncrement()) {		
			if (hasMatchIncrement == FixUtils.TAG_HAS_VALUE) {		
				return matchIncrement; 		
			} else {

				buf.position(hasMatchIncrement);

			matchIncrement = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMatchIncrement = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return matchIncrement;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMatchIncrement() { return hasMatchIncrement != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMatchIncrement(byte[] src) {		
		if (src == null ) return;
		if (hasMatchIncrement()) matchIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		matchIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasMatchIncrement = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMatchIncrement(long src) {		
		matchIncrement = src;
		hasMatchIncrement = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMatchIncrement(String str) {		
		if (str == null ) return;
		if (hasMatchIncrement()) matchIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		matchIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasMatchIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMaxPriceLevels() {		
		getMaxPriceLevels();		
	}		
			
	public long getMaxPriceLevels() { 		
		if ( hasMaxPriceLevels()) {		
			if (hasMaxPriceLevels == FixUtils.TAG_HAS_VALUE) {		
				return maxPriceLevels; 		
			} else {

				buf.position(hasMaxPriceLevels);

			maxPriceLevels = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMaxPriceLevels = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return maxPriceLevels;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxPriceLevels() { return hasMaxPriceLevels != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMaxPriceLevels(byte[] src) {		
		if (src == null ) return;
		if (hasMaxPriceLevels()) maxPriceLevels = FixUtils.TAG_HAS_NO_VALUE;		
		maxPriceLevels = FixUtils.longValueOf(src, 0, src.length);
		hasMaxPriceLevels = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxPriceLevels(long src) {		
		maxPriceLevels = src;
		hasMaxPriceLevels = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxPriceLevels(String str) {		
		if (str == null ) return;
		if (hasMaxPriceLevels()) maxPriceLevels = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxPriceLevels = FixUtils.longValueOf(src, 0, src.length);
		hasMaxPriceLevels = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMaxFloor() {		
		getMaxFloor();		
	}		
			
	public long getMaxFloor() { 		
		if ( hasMaxFloor()) {		
			if (hasMaxFloor == FixUtils.TAG_HAS_VALUE) {		
				return maxFloor; 		
			} else {

				buf.position(hasMaxFloor);

			maxFloor = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return maxFloor;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxFloor() { return hasMaxFloor != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMaxFloor(byte[] src) {		
		if (src == null ) return;
		if (hasMaxFloor()) maxFloor = FixUtils.TAG_HAS_NO_VALUE;		
		maxFloor = FixUtils.longValueOf(src, 0, src.length);
		hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxFloor(long src) {		
		maxFloor = src;
		hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxFloor(String str) {		
		if (str == null ) return;
		if (hasMaxFloor()) maxFloor = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxFloor = FixUtils.longValueOf(src, 0, src.length);
		hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPositionEffect() {		
		getPositionEffect();		
	}		
			
	public byte getPositionEffect() { 		
		if ( hasPositionEffect()) {		
			if (hasPositionEffect == FixUtils.TAG_HAS_VALUE) {		
				return positionEffect; 		
			} else {

				buf.position(hasPositionEffect);

			positionEffect = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (positionEffect != (byte)'D') && (positionEffect != (byte)'F') && (positionEffect != (byte)'R') && (positionEffect != (byte)'C') && (positionEffect != (byte)'N') && (positionEffect != (byte)'O') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 77);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasPositionEffect = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return positionEffect;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasPositionEffect() { return hasPositionEffect != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPositionEffect(byte[] src) {		
		if (src == null ) return;
		if (hasPositionEffect()) positionEffect = (byte)' ';		
		positionEffect = src[0];		
		hasPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPositionEffect(byte src) {		
		positionEffect = src;
		hasPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPositionEffect(String str) {		
		if (str == null ) return;
		if (hasPositionEffect()) positionEffect = (byte)' ';		
		byte[] src = str.getBytes(); 		
		positionEffect = src[0];		
		hasPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMaxShow() {		
		getMaxShow();		
	}		
			
	public long getMaxShow() { 		
		if ( hasMaxShow()) {		
			if (hasMaxShow == FixUtils.TAG_HAS_VALUE) {		
				return maxShow; 		
			} else {

				buf.position(hasMaxShow);

			maxShow = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMaxShow = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return maxShow;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxShow() { return hasMaxShow != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMaxShow(byte[] src) {		
		if (src == null ) return;
		if (hasMaxShow()) maxShow = FixUtils.TAG_HAS_NO_VALUE;		
		maxShow = FixUtils.longValueOf(src, 0, src.length);
		hasMaxShow = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxShow(long src) {		
		maxShow = src;
		hasMaxShow = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxShow(String str) {		
		if (str == null ) return;
		if (hasMaxShow()) maxShow = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxShow = FixUtils.longValueOf(src, 0, src.length);
		hasMaxShow = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBookingType() {		
		getBookingType();		
	}		
			
	public long getBookingType() { 		
		if ( hasBookingType()) {		
			if (hasBookingType == FixUtils.TAG_HAS_VALUE) {		
				return bookingType; 		
			} else {

				buf.position(hasBookingType);

			bookingType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBookingType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bookingType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBookingType() { return hasBookingType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBookingType(byte[] src) {		
		if (src == null ) return;
		if (hasBookingType()) bookingType = FixUtils.TAG_HAS_NO_VALUE;		
		bookingType = FixUtils.longValueOf(src, 0, src.length);
		hasBookingType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBookingType(long src) {		
		bookingType = src;
		hasBookingType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBookingType(String str) {		
		if (str == null ) return;
		if (hasBookingType()) bookingType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bookingType = FixUtils.longValueOf(src, 0, src.length);
		hasBookingType = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackSettlDate2() {		
		getSettlDate2();		
	}		
			
	public byte[] getSettlDate2() { 		
		if ( hasSettlDate2()) {		
			if (hasSettlDate2 == FixUtils.TAG_HAS_VALUE) {		
				return settlDate2; 		
			} else {

				buf.position(hasSettlDate2);

			FixMessage.getTagStringValue(buf, settlDate2, 0, settlDate2.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlDate2 = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlDate2;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlDate2() { return hasSettlDate2 != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlDate2(byte[] src) {		
		if (src == null ) return;
		if (hasSettlDate2()) FixUtils.fillSpace(settlDate2);		
		FixUtils.copy(settlDate2, src); 		
		hasSettlDate2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlDate2(String str) {		
		if (str == null ) return;
		if (hasSettlDate2()) FixUtils.fillSpace(settlDate2);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlDate2, src); 		
		hasSettlDate2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrderQty2() {		
		getOrderQty2();		
	}		
			
	public long getOrderQty2() { 		
		if ( hasOrderQty2()) {		
			if (hasOrderQty2 == FixUtils.TAG_HAS_VALUE) {		
				return orderQty2; 		
			} else {

				buf.position(hasOrderQty2);

			orderQty2 = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasOrderQty2 = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderQty2;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrderQty2() { return hasOrderQty2 != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderQty2(byte[] src) {		
		if (src == null ) return;
		if (hasOrderQty2()) orderQty2 = FixUtils.TAG_HAS_NO_VALUE;		
		orderQty2 = FixUtils.longValueOf(src, 0, src.length);
		hasOrderQty2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderQty2(long src) {		
		orderQty2 = src;
		hasOrderQty2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderQty2(String str) {		
		if (str == null ) return;
		if (hasOrderQty2()) orderQty2 = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		orderQty2 = FixUtils.longValueOf(src, 0, src.length);
		hasOrderQty2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastForwardPoints2() {		
		getLastForwardPoints2();		
	}		
			
	public long getLastForwardPoints2() { 		
		if ( hasLastForwardPoints2()) {		
			if (hasLastForwardPoints2 == FixUtils.TAG_HAS_VALUE) {		
				return lastForwardPoints2; 		
			} else {

				buf.position(hasLastForwardPoints2);

			lastForwardPoints2 = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLastForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastForwardPoints2;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastForwardPoints2() { return hasLastForwardPoints2 != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastForwardPoints2(byte[] src) {		
		if (src == null ) return;
		if (hasLastForwardPoints2()) lastForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		lastForwardPoints2 = FixUtils.longValueOf(src, 0, src.length);
		hasLastForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastForwardPoints2(long src) {		
		lastForwardPoints2 = src;
		hasLastForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastForwardPoints2(String str) {		
		if (str == null ) return;
		if (hasLastForwardPoints2()) lastForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastForwardPoints2 = FixUtils.longValueOf(src, 0, src.length);
		hasLastForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackCancellationRights() {		
		getCancellationRights();		
	}		
			
	public byte getCancellationRights() { 		
		if ( hasCancellationRights()) {		
			if (hasCancellationRights == FixUtils.TAG_HAS_VALUE) {		
				return cancellationRights; 		
			} else {

				buf.position(hasCancellationRights);

			cancellationRights = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (cancellationRights != (byte)'M') && (cancellationRights != (byte)'N') && (cancellationRights != (byte)'O') && (cancellationRights != (byte)'Y') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 480);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasCancellationRights = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return cancellationRights;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasCancellationRights() { return hasCancellationRights != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCancellationRights(byte[] src) {		
		if (src == null ) return;
		if (hasCancellationRights()) cancellationRights = (byte)' ';		
		cancellationRights = src[0];		
		hasCancellationRights = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCancellationRights(byte src) {		
		cancellationRights = src;
		hasCancellationRights = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCancellationRights(String str) {		
		if (str == null ) return;
		if (hasCancellationRights()) cancellationRights = (byte)' ';		
		byte[] src = str.getBytes(); 		
		cancellationRights = src[0];		
		hasCancellationRights = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMoneyLaunderingStatus() {		
		getMoneyLaunderingStatus();		
	}		
			
	public byte getMoneyLaunderingStatus() { 		
		if ( hasMoneyLaunderingStatus()) {		
			if (hasMoneyLaunderingStatus == FixUtils.TAG_HAS_VALUE) {		
				return moneyLaunderingStatus; 		
			} else {

				buf.position(hasMoneyLaunderingStatus);

			moneyLaunderingStatus = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (moneyLaunderingStatus != (byte)'3') && (moneyLaunderingStatus != (byte)'2') && (moneyLaunderingStatus != (byte)'1') && (moneyLaunderingStatus != (byte)'N') && (moneyLaunderingStatus != (byte)'Y') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 481);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasMoneyLaunderingStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return moneyLaunderingStatus;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMoneyLaunderingStatus() { return hasMoneyLaunderingStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMoneyLaunderingStatus(byte[] src) {		
		if (src == null ) return;
		if (hasMoneyLaunderingStatus()) moneyLaunderingStatus = (byte)' ';		
		moneyLaunderingStatus = src[0];		
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMoneyLaunderingStatus(byte src) {		
		moneyLaunderingStatus = src;
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMoneyLaunderingStatus(String str) {		
		if (str == null ) return;
		if (hasMoneyLaunderingStatus()) moneyLaunderingStatus = (byte)' ';		
		byte[] src = str.getBytes(); 		
		moneyLaunderingStatus = src[0];		
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRegistID() {		
		getRegistID();		
	}		
			
	public byte[] getRegistID() { 		
		if ( hasRegistID()) {		
			if (hasRegistID == FixUtils.TAG_HAS_VALUE) {		
				return registID; 		
			} else {

				buf.position(hasRegistID);

			FixMessage.getTagStringValue(buf, registID, 0, registID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRegistID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return registID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRegistID() { return hasRegistID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRegistID(byte[] src) {		
		if (src == null ) return;
		if (hasRegistID()) FixUtils.fillSpace(registID);		
		FixUtils.copy(registID, src); 		
		hasRegistID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistID(String str) {		
		if (str == null ) return;
		if (hasRegistID()) FixUtils.fillSpace(registID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(registID, src); 		
		hasRegistID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDesignation() {		
		getDesignation();		
	}		
			
	public byte[] getDesignation() { 		
		if ( hasDesignation()) {		
			if (hasDesignation == FixUtils.TAG_HAS_VALUE) {		
				return designation; 		
			} else {

				buf.position(hasDesignation);

			FixMessage.getTagStringValue(buf, designation, 0, designation.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasDesignation = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return designation;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDesignation() { return hasDesignation != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDesignation(byte[] src) {		
		if (src == null ) return;
		if (hasDesignation()) FixUtils.fillSpace(designation);		
		FixUtils.copy(designation, src); 		
		hasDesignation = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDesignation(String str) {		
		if (str == null ) return;
		if (hasDesignation()) FixUtils.fillSpace(designation);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(designation, src); 		
		hasDesignation = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTransBkdTime() {		
		getTransBkdTime();		
	}		
			
	public byte[] getTransBkdTime() { 		
		if ( hasTransBkdTime()) {		
			if (hasTransBkdTime == FixUtils.TAG_HAS_VALUE) {		
				return transBkdTime; 		
			} else {

				buf.position(hasTransBkdTime);

			FixMessage.getTagStringValue(buf, transBkdTime, 0, transBkdTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTransBkdTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return transBkdTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTransBkdTime() { return hasTransBkdTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTransBkdTime(byte[] src) {		
		if (src == null ) return;
		if (hasTransBkdTime()) FixUtils.fillSpace(transBkdTime);		
		FixUtils.copy(transBkdTime, src); 		
		hasTransBkdTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTransBkdTime(String str) {		
		if (str == null ) return;
		if (hasTransBkdTime()) FixUtils.fillSpace(transBkdTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transBkdTime, src); 		
		hasTransBkdTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExecValuationPoint() {		
		getExecValuationPoint();		
	}		
			
	public byte[] getExecValuationPoint() { 		
		if ( hasExecValuationPoint()) {		
			if (hasExecValuationPoint == FixUtils.TAG_HAS_VALUE) {		
				return execValuationPoint; 		
			} else {

				buf.position(hasExecValuationPoint);

			FixMessage.getTagStringValue(buf, execValuationPoint, 0, execValuationPoint.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExecValuationPoint = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execValuationPoint;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExecValuationPoint() { return hasExecValuationPoint != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecValuationPoint(byte[] src) {		
		if (src == null ) return;
		if (hasExecValuationPoint()) FixUtils.fillSpace(execValuationPoint);		
		FixUtils.copy(execValuationPoint, src); 		
		hasExecValuationPoint = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecValuationPoint(String str) {		
		if (str == null ) return;
		if (hasExecValuationPoint()) FixUtils.fillSpace(execValuationPoint);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(execValuationPoint, src); 		
		hasExecValuationPoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExecPriceType() {		
		getExecPriceType();		
	}		
			
	public byte getExecPriceType() { 		
		if ( hasExecPriceType()) {		
			if (hasExecPriceType == FixUtils.TAG_HAS_VALUE) {		
				return execPriceType; 		
			} else {

				buf.position(hasExecPriceType);

			execPriceType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (execPriceType != (byte)'D') && (execPriceType != (byte)'E') && (execPriceType != (byte)'Q') && (execPriceType != (byte)'P') && (execPriceType != (byte)'S') && (execPriceType != (byte)'B') && (execPriceType != (byte)'C') && (execPriceType != (byte)'O') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 484);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasExecPriceType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execPriceType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasExecPriceType() { return hasExecPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasExecPriceType()) execPriceType = (byte)' ';		
		execPriceType = src[0];		
		hasExecPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecPriceType(byte src) {		
		execPriceType = src;
		hasExecPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecPriceType(String str) {		
		if (str == null ) return;
		if (hasExecPriceType()) execPriceType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		execPriceType = src[0];		
		hasExecPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExecPriceAdjustment() {		
		getExecPriceAdjustment();		
	}		
			
	public long getExecPriceAdjustment() { 		
		if ( hasExecPriceAdjustment()) {		
			if (hasExecPriceAdjustment == FixUtils.TAG_HAS_VALUE) {		
				return execPriceAdjustment; 		
			} else {

				buf.position(hasExecPriceAdjustment);

			execPriceAdjustment = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasExecPriceAdjustment = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execPriceAdjustment;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasExecPriceAdjustment() { return hasExecPriceAdjustment != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecPriceAdjustment(byte[] src) {		
		if (src == null ) return;
		if (hasExecPriceAdjustment()) execPriceAdjustment = FixUtils.TAG_HAS_NO_VALUE;		
		execPriceAdjustment = FixUtils.longValueOf(src, 0, src.length);
		hasExecPriceAdjustment = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecPriceAdjustment(long src) {		
		execPriceAdjustment = src;
		hasExecPriceAdjustment = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecPriceAdjustment(String str) {		
		if (str == null ) return;
		if (hasExecPriceAdjustment()) execPriceAdjustment = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		execPriceAdjustment = FixUtils.longValueOf(src, 0, src.length);
		hasExecPriceAdjustment = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPriorityIndicator() {		
		getPriorityIndicator();		
	}		
			
	public long getPriorityIndicator() { 		
		if ( hasPriorityIndicator()) {		
			if (hasPriorityIndicator == FixUtils.TAG_HAS_VALUE) {		
				return priorityIndicator; 		
			} else {

				buf.position(hasPriorityIndicator);

			priorityIndicator = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPriorityIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return priorityIndicator;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriorityIndicator() { return hasPriorityIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPriorityIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasPriorityIndicator()) priorityIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		priorityIndicator = FixUtils.longValueOf(src, 0, src.length);
		hasPriorityIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriorityIndicator(long src) {		
		priorityIndicator = src;
		hasPriorityIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriorityIndicator(String str) {		
		if (str == null ) return;
		if (hasPriorityIndicator()) priorityIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priorityIndicator = FixUtils.longValueOf(src, 0, src.length);
		hasPriorityIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPriceImprovement() {		
		getPriceImprovement();		
	}		
			
	public long getPriceImprovement() { 		
		if ( hasPriceImprovement()) {		
			if (hasPriceImprovement == FixUtils.TAG_HAS_VALUE) {		
				return priceImprovement; 		
			} else {

				buf.position(hasPriceImprovement);

			priceImprovement = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPriceImprovement = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return priceImprovement;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriceImprovement() { return hasPriceImprovement != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPriceImprovement(byte[] src) {		
		if (src == null ) return;
		if (hasPriceImprovement()) priceImprovement = FixUtils.TAG_HAS_NO_VALUE;		
		priceImprovement = FixUtils.longValueOf(src, 0, src.length);
		hasPriceImprovement = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceImprovement(long src) {		
		priceImprovement = src;
		hasPriceImprovement = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceImprovement(String str) {		
		if (str == null ) return;
		if (hasPriceImprovement()) priceImprovement = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priceImprovement = FixUtils.longValueOf(src, 0, src.length);
		hasPriceImprovement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastLiquidityInd() {		
		getLastLiquidityInd();		
	}		
			
	public long getLastLiquidityInd() { 		
		if ( hasLastLiquidityInd()) {		
			if (hasLastLiquidityInd == FixUtils.TAG_HAS_VALUE) {		
				return lastLiquidityInd; 		
			} else {

				buf.position(hasLastLiquidityInd);

			lastLiquidityInd = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLastLiquidityInd = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastLiquidityInd;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastLiquidityInd() { return hasLastLiquidityInd != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastLiquidityInd(byte[] src) {		
		if (src == null ) return;
		if (hasLastLiquidityInd()) lastLiquidityInd = FixUtils.TAG_HAS_NO_VALUE;		
		lastLiquidityInd = FixUtils.longValueOf(src, 0, src.length);
		hasLastLiquidityInd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastLiquidityInd(long src) {		
		lastLiquidityInd = src;
		hasLastLiquidityInd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastLiquidityInd(String str) {		
		if (str == null ) return;
		if (hasLastLiquidityInd()) lastLiquidityInd = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastLiquidityInd = FixUtils.longValueOf(src, 0, src.length);
		hasLastLiquidityInd = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackManualOrderIndicator() {		
		getManualOrderIndicator();		
	}		
			
	public boolean getManualOrderIndicator() { 		
		if ( hasManualOrderIndicator()) {		
			if (hasManualOrderIndicator == FixUtils.TAG_HAS_VALUE) {		
				return manualOrderIndicator; 		
			} else {

				buf.position(hasManualOrderIndicator);

			manualOrderIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasManualOrderIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return manualOrderIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasManualOrderIndicator() { return hasManualOrderIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setManualOrderIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasManualOrderIndicator()) manualOrderIndicator = false;		
		manualOrderIndicator = src[0]==(byte)'Y'?true:false;		
		hasManualOrderIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setManualOrderIndicator(boolean src) {		
		manualOrderIndicator = src;
		hasManualOrderIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setManualOrderIndicator(String str) {		
		if (str == null ) return;
		if (hasManualOrderIndicator()) manualOrderIndicator = false;		
		byte[] src = str.getBytes(); 		
		manualOrderIndicator = src[0]==(byte)'Y'?true:false;		
		hasManualOrderIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCustDirectedOrder() {		
		getCustDirectedOrder();		
	}		
			
	public boolean getCustDirectedOrder() { 		
		if ( hasCustDirectedOrder()) {		
			if (hasCustDirectedOrder == FixUtils.TAG_HAS_VALUE) {		
				return custDirectedOrder; 		
			} else {

				buf.position(hasCustDirectedOrder);

			custDirectedOrder = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasCustDirectedOrder = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return custDirectedOrder;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasCustDirectedOrder() { return hasCustDirectedOrder != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCustDirectedOrder(byte[] src) {		
		if (src == null ) return;
		if (hasCustDirectedOrder()) custDirectedOrder = false;		
		custDirectedOrder = src[0]==(byte)'Y'?true:false;		
		hasCustDirectedOrder = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCustDirectedOrder(boolean src) {		
		custDirectedOrder = src;
		hasCustDirectedOrder = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCustDirectedOrder(String str) {		
		if (str == null ) return;
		if (hasCustDirectedOrder()) custDirectedOrder = false;		
		byte[] src = str.getBytes(); 		
		custDirectedOrder = src[0]==(byte)'Y'?true:false;		
		hasCustDirectedOrder = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackReceivedDeptID() {		
		getReceivedDeptID();		
	}		
			
	public byte[] getReceivedDeptID() { 		
		if ( hasReceivedDeptID()) {		
			if (hasReceivedDeptID == FixUtils.TAG_HAS_VALUE) {		
				return receivedDeptID; 		
			} else {

				buf.position(hasReceivedDeptID);

			FixMessage.getTagStringValue(buf, receivedDeptID, 0, receivedDeptID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasReceivedDeptID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return receivedDeptID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasReceivedDeptID() { return hasReceivedDeptID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setReceivedDeptID(byte[] src) {		
		if (src == null ) return;
		if (hasReceivedDeptID()) FixUtils.fillSpace(receivedDeptID);		
		FixUtils.copy(receivedDeptID, src); 		
		hasReceivedDeptID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setReceivedDeptID(String str) {		
		if (str == null ) return;
		if (hasReceivedDeptID()) FixUtils.fillSpace(receivedDeptID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(receivedDeptID, src); 		
		hasReceivedDeptID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCustOrderHandlingInst() {		
		getCustOrderHandlingInst();		
	}		
			
	public byte[] getCustOrderHandlingInst() { 		
		if ( hasCustOrderHandlingInst()) {		
			if (hasCustOrderHandlingInst == FixUtils.TAG_HAS_VALUE) {		
				return custOrderHandlingInst; 		
			} else {

				buf.position(hasCustOrderHandlingInst);

			FixMessage.getTagStringValue(buf, custOrderHandlingInst, 0, custOrderHandlingInst.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCustOrderHandlingInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return custOrderHandlingInst;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCustOrderHandlingInst() { return hasCustOrderHandlingInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCustOrderHandlingInst(byte[] src) {		
		if (src == null ) return;
		if (hasCustOrderHandlingInst()) FixUtils.fillSpace(custOrderHandlingInst);		
		FixUtils.copy(custOrderHandlingInst, src); 		
		hasCustOrderHandlingInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCustOrderHandlingInst(String str) {		
		if (str == null ) return;
		if (hasCustOrderHandlingInst()) FixUtils.fillSpace(custOrderHandlingInst);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(custOrderHandlingInst, src); 		
		hasCustOrderHandlingInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrderHandlingInstSource() {		
		getOrderHandlingInstSource();		
	}		
			
	public long getOrderHandlingInstSource() { 		
		if ( hasOrderHandlingInstSource()) {		
			if (hasOrderHandlingInstSource == FixUtils.TAG_HAS_VALUE) {		
				return orderHandlingInstSource; 		
			} else {

				buf.position(hasOrderHandlingInstSource);

			orderHandlingInstSource = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasOrderHandlingInstSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderHandlingInstSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrderHandlingInstSource() { return hasOrderHandlingInstSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderHandlingInstSource(byte[] src) {		
		if (src == null ) return;
		if (hasOrderHandlingInstSource()) orderHandlingInstSource = FixUtils.TAG_HAS_NO_VALUE;		
		orderHandlingInstSource = FixUtils.longValueOf(src, 0, src.length);
		hasOrderHandlingInstSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderHandlingInstSource(long src) {		
		orderHandlingInstSource = src;
		hasOrderHandlingInstSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderHandlingInstSource(String str) {		
		if (str == null ) return;
		if (hasOrderHandlingInstSource()) orderHandlingInstSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		orderHandlingInstSource = FixUtils.longValueOf(src, 0, src.length);
		hasOrderHandlingInstSource = FixUtils.TAG_HAS_VALUE;		
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

			dividendYield = FixMessage.getTagFloatValue(buf, err);
		
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
			
	public void crackVolatility() {		
		getVolatility();		
	}		
			
	public long getVolatility() { 		
		if ( hasVolatility()) {		
			if (hasVolatility == FixUtils.TAG_HAS_VALUE) {		
				return volatility; 		
			} else {

				buf.position(hasVolatility);

			volatility = FixMessage.getTagFloatValue(buf, err);
		
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
			
	public void crackTimeToExpiration() {		
		getTimeToExpiration();		
	}		
			
	public long getTimeToExpiration() { 		
		if ( hasTimeToExpiration()) {		
			if (hasTimeToExpiration == FixUtils.TAG_HAS_VALUE) {		
				return timeToExpiration; 		
			} else {

				buf.position(hasTimeToExpiration);

			timeToExpiration = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTimeToExpiration = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return timeToExpiration;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTimeToExpiration() { return hasTimeToExpiration != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTimeToExpiration(byte[] src) {		
		if (src == null ) return;
		if (hasTimeToExpiration()) timeToExpiration = FixUtils.TAG_HAS_NO_VALUE;		
		timeToExpiration = FixUtils.longValueOf(src, 0, src.length);
		hasTimeToExpiration = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeToExpiration(long src) {		
		timeToExpiration = src;
		hasTimeToExpiration = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeToExpiration(String str) {		
		if (str == null ) return;
		if (hasTimeToExpiration()) timeToExpiration = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		timeToExpiration = FixUtils.longValueOf(src, 0, src.length);
		hasTimeToExpiration = FixUtils.TAG_HAS_VALUE;		
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

			riskFreeRate = FixMessage.getTagFloatValue(buf, err);
		
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
			
	public void crackPriceDelta() {		
		getPriceDelta();		
	}		
			
	public long getPriceDelta() { 		
		if ( hasPriceDelta()) {		
			if (hasPriceDelta == FixUtils.TAG_HAS_VALUE) {		
				return priceDelta; 		
			} else {

				buf.position(hasPriceDelta);

			priceDelta = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPriceDelta = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return priceDelta;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriceDelta() { return hasPriceDelta != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPriceDelta(byte[] src) {		
		if (src == null ) return;
		if (hasPriceDelta()) priceDelta = FixUtils.TAG_HAS_NO_VALUE;		
		priceDelta = FixUtils.longValueOf(src, 0, src.length);
		hasPriceDelta = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceDelta(long src) {		
		priceDelta = src;
		hasPriceDelta = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceDelta(String str) {		
		if (str == null ) return;
		if (hasPriceDelta()) priceDelta = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priceDelta = FixUtils.longValueOf(src, 0, src.length);
		hasPriceDelta = FixUtils.TAG_HAS_VALUE;		
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

					if (hasOrderID()) s += "OrderID(37)= " + new String( FixUtils.trim(getOrderID()) ) + "\n" ; 
		if (hasSecondaryOrderID()) s += "SecondaryOrderID(198)= " + new String( FixUtils.trim(getSecondaryOrderID()) ) + "\n" ; 
		if (hasSecondaryClOrdID()) s += "SecondaryClOrdID(526)= " + new String( FixUtils.trim(getSecondaryClOrdID()) ) + "\n" ; 
		if (hasSecondaryExecID()) s += "SecondaryExecID(527)= " + new String( FixUtils.trim(getSecondaryExecID()) ) + "\n" ; 
		if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasOrigClOrdID()) s += "OrigClOrdID(41)= " + new String( FixUtils.trim(getOrigClOrdID()) ) + "\n" ; 
		if (hasClOrdLinkID()) s += "ClOrdLinkID(583)= " + new String( FixUtils.trim(getClOrdLinkID()) ) + "\n" ; 
		if (hasQuoteRespID()) s += "QuoteRespID(693)= " + new String( FixUtils.trim(getQuoteRespID()) ) + "\n" ; 
		if (hasOrdStatusReqID()) s += "OrdStatusReqID(790)= " + new String( FixUtils.trim(getOrdStatusReqID()) ) + "\n" ; 
		if (hasMassStatusReqID()) s += "MassStatusReqID(584)= " + new String( FixUtils.trim(getMassStatusReqID()) ) + "\n" ; 
		if (hasHostCrossID()) s += "HostCrossID(961)= " + new String( FixUtils.trim(getHostCrossID()) ) + "\n" ; 
		if (hasTotNumReports()) s += "TotNumReports(911)= " + getTotNumReports() + "\n" ; 
		if (hasLastRptRequested()) s += "LastRptRequested(912)= " + getLastRptRequested() + "\n" ; 
		if (hasTradeOriginationDate()) s += "TradeOriginationDate(229)= " + new String( FixUtils.trim(getTradeOriginationDate()) ) + "\n" ; 
		if (hasListID()) s += "ListID(66)= " + new String( FixUtils.trim(getListID()) ) + "\n" ; 
		if (hasCrossID()) s += "CrossID(548)= " + new String( FixUtils.trim(getCrossID()) ) + "\n" ; 
		if (hasOrigCrossID()) s += "OrigCrossID(551)= " + new String( FixUtils.trim(getOrigCrossID()) ) + "\n" ; 
		if (hasCrossType()) s += "CrossType(549)= " + getCrossType() + "\n" ; 
		if (hasTrdMatchID()) s += "TrdMatchID(880)= " + new String( FixUtils.trim(getTrdMatchID()) ) + "\n" ; 
		if (hasExecID()) s += "ExecID(17)= " + new String( FixUtils.trim(getExecID()) ) + "\n" ; 
		if (hasExecRefID()) s += "ExecRefID(19)= " + new String( FixUtils.trim(getExecRefID()) ) + "\n" ; 
		if (hasExecType()) s += "ExecType(150)= " + getExecType() + "\n" ; 
		if (hasOrdStatus()) s += "OrdStatus(39)= " + getOrdStatus() + "\n" ; 
		if (hasWorkingIndicator()) s += "WorkingIndicator(636)= " + getWorkingIndicator() + "\n" ; 
		if (hasOrdRejReason()) s += "OrdRejReason(103)= " + getOrdRejReason() + "\n" ; 
		if (hasExecRestatementReason()) s += "ExecRestatementReason(378)= " + getExecRestatementReason() + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAcctIDSource()) s += "AcctIDSource(660)= " + getAcctIDSource() + "\n" ; 
		if (hasAccountType()) s += "AccountType(581)= " + getAccountType() + "\n" ; 
		if (hasDayBookingInst()) s += "DayBookingInst(589)= " + getDayBookingInst() + "\n" ; 
		if (hasBookingUnit()) s += "BookingUnit(590)= " + getBookingUnit() + "\n" ; 
		if (hasPreallocMethod()) s += "PreallocMethod(591)= " + getPreallocMethod() + "\n" ; 
		if (hasAllocID()) s += "AllocID(70)= " + new String( FixUtils.trim(getAllocID()) ) + "\n" ; 
		if (hasSettlType()) s += "SettlType(63)= " + new String( FixUtils.trim(getSettlType()) ) + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasMatchType()) s += "MatchType(574)= " + new String( FixUtils.trim(getMatchType()) ) + "\n" ; 
		if (hasOrderCategory()) s += "OrderCategory(1115)= " + getOrderCategory() + "\n" ; 
		if (hasCashMargin()) s += "CashMargin(544)= " + getCashMargin() + "\n" ; 
		if (hasClearingFeeIndicator()) s += "ClearingFeeIndicator(635)= " + new String( FixUtils.trim(getClearingFeeIndicator()) ) + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasQtyType()) s += "QtyType(854)= " + getQtyType() + "\n" ; 
		if (hasLotType()) s += "LotType(1093)= " + getLotType() + "\n" ; 
		if (hasOrdType()) s += "OrdType(40)= " + getOrdType() + "\n" ; 
		if (hasPriceType()) s += "PriceType(423)= " + getPriceType() + "\n" ; 
		if (hasPrice()) s += "Price(44)= " + getPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPriceProtectionScope()) s += "PriceProtectionScope(1092)= " + getPriceProtectionScope() + "\n" ; 
		if (hasStopPx()) s += "StopPx(99)= " + getStopPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPeggedPrice()) s += "PeggedPrice(839)= " + getPeggedPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPeggedRefPrice()) s += "PeggedRefPrice(1095)= " + getPeggedRefPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDiscretionPrice()) s += "DiscretionPrice(845)= " + getDiscretionPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTargetStrategy()) s += "TargetStrategy(847)= " + getTargetStrategy() + "\n" ; 
		if (hasTargetStrategyParameters()) s += "TargetStrategyParameters(848)= " + new String( FixUtils.trim(getTargetStrategyParameters()) ) + "\n" ; 
		if (hasParticipationRate()) s += "ParticipationRate(849)= " + getParticipationRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTargetStrategyPerformance()) s += "TargetStrategyPerformance(850)= " + getTargetStrategyPerformance() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasComplianceID()) s += "ComplianceID(376)= " + new String( FixUtils.trim(getComplianceID()) ) + "\n" ; 
		if (hasSolicitedFlag()) s += "SolicitedFlag(377)= " + getSolicitedFlag() + "\n" ; 
		if (hasTimeInForce()) s += "TimeInForce(59)= " + getTimeInForce() + "\n" ; 
		if (hasEffectiveTime()) s += "EffectiveTime(168)= " + new String( FixUtils.trim(getEffectiveTime()) ) + "\n" ; 
		if (hasExpireDate()) s += "ExpireDate(432)= " + new String( FixUtils.trim(getExpireDate()) ) + "\n" ; 
		if (hasExpireTime()) s += "ExpireTime(126)= " + new String( FixUtils.trim(getExpireTime()) ) + "\n" ; 
		if (hasExecInst()) s += "ExecInst(18)= " + new String( FixUtils.trim(getExecInst()) ) + "\n" ; 
		if (hasAggressorIndicator()) s += "AggressorIndicator(1057)= " + getAggressorIndicator() + "\n" ; 
		if (hasOrderCapacity()) s += "OrderCapacity(528)= " + getOrderCapacity() + "\n" ; 
		if (hasOrderRestrictions()) s += "OrderRestrictions(529)= " + new String( FixUtils.trim(getOrderRestrictions()) ) + "\n" ; 
		if (hasPreTradeAnonymity()) s += "PreTradeAnonymity(1091)= " + getPreTradeAnonymity() + "\n" ; 
		if (hasCustOrderCapacity()) s += "CustOrderCapacity(582)= " + getCustOrderCapacity() + "\n" ; 
		if (hasLastQty()) s += "LastQty(32)= " + getLastQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCalculatedCcyLastQty()) s += "CalculatedCcyLastQty(1056)= " + getCalculatedCcyLastQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastSwapPoints()) s += "LastSwapPoints(1071)= " + getLastSwapPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingLastQty()) s += "UnderlyingLastQty(652)= " + getUnderlyingLastQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastPx()) s += "LastPx(31)= " + getLastPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingLastPx()) s += "UnderlyingLastPx(651)= " + getUnderlyingLastPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastParPx()) s += "LastParPx(669)= " + getLastParPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastSpotRate()) s += "LastSpotRate(194)= " + getLastSpotRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastForwardPoints()) s += "LastForwardPoints(195)= " + getLastForwardPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastMkt()) s += "LastMkt(30)= " + new String( FixUtils.trim(getLastMkt()) ) + "\n" ; 
		if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 
		if (hasTimeBracket()) s += "TimeBracket(943)= " + new String( FixUtils.trim(getTimeBracket()) ) + "\n" ; 
		if (hasLastCapacity()) s += "LastCapacity(29)= " + getLastCapacity() + "\n" ; 
		if (hasLeavesQty()) s += "LeavesQty(151)= " + getLeavesQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCumQty()) s += "CumQty(14)= " + getCumQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAvgPx()) s += "AvgPx(6)= " + getAvgPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDayOrderQty()) s += "DayOrderQty(424)= " + getDayOrderQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDayCumQty()) s += "DayCumQty(425)= " + getDayCumQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDayAvgPx()) s += "DayAvgPx(426)= " + getDayAvgPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTotNoFills()) s += "TotNoFills(1361)= " + getTotNoFills() + "\n" ; 
		if (hasLastFragment()) s += "LastFragment(893)= " + getLastFragment() + "\n" ; 
		if (hasGTBookingInst()) s += "GTBookingInst(427)= " + getGTBookingInst() + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasReportToExch()) s += "ReportToExch(113)= " + getReportToExch() + "\n" ; 
		if (hasGrossTradeAmt()) s += "GrossTradeAmt(381)= " + getGrossTradeAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasNumDaysInterest()) s += "NumDaysInterest(157)= " + getNumDaysInterest() + "\n" ; 
		if (hasExDate()) s += "ExDate(230)= " + new String( FixUtils.trim(getExDate()) ) + "\n" ; 
		if (hasAccruedInterestRate()) s += "AccruedInterestRate(158)= " + getAccruedInterestRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAccruedInterestAmt()) s += "AccruedInterestAmt(159)= " + getAccruedInterestAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasInterestAtMaturity()) s += "InterestAtMaturity(738)= " + getInterestAtMaturity() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasEndAccruedInterestAmt()) s += "EndAccruedInterestAmt(920)= " + getEndAccruedInterestAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasStartCash()) s += "StartCash(921)= " + getStartCash() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasEndCash()) s += "EndCash(922)= " + getEndCash() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTradedFlatSwitch()) s += "TradedFlatSwitch(258)= " + getTradedFlatSwitch() + "\n" ; 
		if (hasBasisFeatureDate()) s += "BasisFeatureDate(259)= " + new String( FixUtils.trim(getBasisFeatureDate()) ) + "\n" ; 
		if (hasBasisFeaturePrice()) s += "BasisFeaturePrice(260)= " + getBasisFeaturePrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasConcession()) s += "Concession(238)= " + getConcession() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTotalTakedown()) s += "TotalTakedown(237)= " + getTotalTakedown() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasNetMoney()) s += "NetMoney(118)= " + getNetMoney() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrAmt()) s += "SettlCurrAmt(119)= " + getSettlCurrAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrency()) s += "SettlCurrency(120)= " + new String( FixUtils.trim(getSettlCurrency()) ) + "\n" ; 
		if (hasSettlCurrFxRate()) s += "SettlCurrFxRate(155)= " + getSettlCurrFxRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrFxRateCalc()) s += "SettlCurrFxRateCalc(156)= " + getSettlCurrFxRateCalc() + "\n" ; 
		if (hasHandlInst()) s += "HandlInst(21)= " + getHandlInst() + "\n" ; 
		if (hasMinQty()) s += "MinQty(110)= " + getMinQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMatchIncrement()) s += "MatchIncrement(1089)= " + getMatchIncrement() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMaxPriceLevels()) s += "MaxPriceLevels(1090)= " + getMaxPriceLevels() + "\n" ; 
		if (hasMaxFloor()) s += "MaxFloor(111)= " + getMaxFloor() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPositionEffect()) s += "PositionEffect(77)= " + getPositionEffect() + "\n" ; 
		if (hasMaxShow()) s += "MaxShow(210)= " + getMaxShow() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasBookingType()) s += "BookingType(775)= " + getBookingType() + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasSettlDate2()) s += "SettlDate2(193)= " + new String( FixUtils.trim(getSettlDate2()) ) + "\n" ; 
		if (hasOrderQty2()) s += "OrderQty2(192)= " + getOrderQty2() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastForwardPoints2()) s += "LastForwardPoints2(641)= " + getLastForwardPoints2() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMultiLegReportingType()) s += "MultiLegReportingType(442)= " + getMultiLegReportingType() + "\n" ; 
		if (hasCancellationRights()) s += "CancellationRights(480)= " + getCancellationRights() + "\n" ; 
		if (hasMoneyLaunderingStatus()) s += "MoneyLaunderingStatus(481)= " + getMoneyLaunderingStatus() + "\n" ; 
		if (hasRegistID()) s += "RegistID(513)= " + new String( FixUtils.trim(getRegistID()) ) + "\n" ; 
		if (hasDesignation()) s += "Designation(494)= " + new String( FixUtils.trim(getDesignation()) ) + "\n" ; 
		if (hasTransBkdTime()) s += "TransBkdTime(483)= " + new String( FixUtils.trim(getTransBkdTime()) ) + "\n" ; 
		if (hasExecValuationPoint()) s += "ExecValuationPoint(515)= " + new String( FixUtils.trim(getExecValuationPoint()) ) + "\n" ; 
		if (hasExecPriceType()) s += "ExecPriceType(484)= " + getExecPriceType() + "\n" ; 
		if (hasExecPriceAdjustment()) s += "ExecPriceAdjustment(485)= " + getExecPriceAdjustment() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPriorityIndicator()) s += "PriorityIndicator(638)= " + getPriorityIndicator() + "\n" ; 
		if (hasPriceImprovement()) s += "PriceImprovement(639)= " + getPriceImprovement() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastLiquidityInd()) s += "LastLiquidityInd(851)= " + getLastLiquidityInd() + "\n" ; 
		if (hasCopyMsgIndicator()) s += "CopyMsgIndicator(797)= " + getCopyMsgIndicator() + "\n" ; 
		if (hasManualOrderIndicator()) s += "ManualOrderIndicator(1028)= " + getManualOrderIndicator() + "\n" ; 
		if (hasCustDirectedOrder()) s += "CustDirectedOrder(1029)= " + getCustDirectedOrder() + "\n" ; 
		if (hasReceivedDeptID()) s += "ReceivedDeptID(1030)= " + new String( FixUtils.trim(getReceivedDeptID()) ) + "\n" ; 
		if (hasCustOrderHandlingInst()) s += "CustOrderHandlingInst(1031)= " + new String( FixUtils.trim(getCustOrderHandlingInst()) ) + "\n" ; 
		if (hasOrderHandlingInstSource()) s += "OrderHandlingInstSource(1032)= " + getOrderHandlingInstSource() + "\n" ; 
		if (hasDividendYield()) s += "DividendYield(1380)= " + getDividendYield() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasVolatility()) s += "Volatility(1188)= " + getVolatility() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTimeToExpiration()) s += "TimeToExpiration(1189)= " + getTimeToExpiration() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasRiskFreeRate()) s += "RiskFreeRate(1190)= " + getRiskFreeRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPriceDelta()) s += "PriceDelta(811)= " + getPriceDelta() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixExecutionReport)) return false;

		FixExecutionReport msg = (FixExecutionReport) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasSecondaryOrderID() && !msg.hasSecondaryOrderID()) || (!hasSecondaryOrderID() && msg.hasSecondaryOrderID())) return false;
		if (!(!hasSecondaryOrderID() && !msg.hasSecondaryOrderID()) && !FixUtils.equals(getSecondaryOrderID(), msg.getSecondaryOrderID())) return false;
		if ((hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) || (!hasSecondaryClOrdID() && msg.hasSecondaryClOrdID())) return false;
		if (!(!hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) && !FixUtils.equals(getSecondaryClOrdID(), msg.getSecondaryClOrdID())) return false;
		if ((hasSecondaryExecID() && !msg.hasSecondaryExecID()) || (!hasSecondaryExecID() && msg.hasSecondaryExecID())) return false;
		if (!(!hasSecondaryExecID() && !msg.hasSecondaryExecID()) && !FixUtils.equals(getSecondaryExecID(), msg.getSecondaryExecID())) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasOrigClOrdID() && !msg.hasOrigClOrdID()) || (!hasOrigClOrdID() && msg.hasOrigClOrdID())) return false;
		if (!(!hasOrigClOrdID() && !msg.hasOrigClOrdID()) && !FixUtils.equals(getOrigClOrdID(), msg.getOrigClOrdID())) return false;
		if ((hasClOrdLinkID() && !msg.hasClOrdLinkID()) || (!hasClOrdLinkID() && msg.hasClOrdLinkID())) return false;
		if (!(!hasClOrdLinkID() && !msg.hasClOrdLinkID()) && !FixUtils.equals(getClOrdLinkID(), msg.getClOrdLinkID())) return false;
		if ((hasQuoteRespID() && !msg.hasQuoteRespID()) || (!hasQuoteRespID() && msg.hasQuoteRespID())) return false;
		if (!(!hasQuoteRespID() && !msg.hasQuoteRespID()) && !FixUtils.equals(getQuoteRespID(), msg.getQuoteRespID())) return false;
		if ((hasOrdStatusReqID() && !msg.hasOrdStatusReqID()) || (!hasOrdStatusReqID() && msg.hasOrdStatusReqID())) return false;
		if (!(!hasOrdStatusReqID() && !msg.hasOrdStatusReqID()) && !FixUtils.equals(getOrdStatusReqID(), msg.getOrdStatusReqID())) return false;
		if ((hasMassStatusReqID() && !msg.hasMassStatusReqID()) || (!hasMassStatusReqID() && msg.hasMassStatusReqID())) return false;
		if (!(!hasMassStatusReqID() && !msg.hasMassStatusReqID()) && !FixUtils.equals(getMassStatusReqID(), msg.getMassStatusReqID())) return false;
		if ((hasHostCrossID() && !msg.hasHostCrossID()) || (!hasHostCrossID() && msg.hasHostCrossID())) return false;
		if (!(!hasHostCrossID() && !msg.hasHostCrossID()) && !FixUtils.equals(getHostCrossID(), msg.getHostCrossID())) return false;
		if ((hasTotNumReports() && !msg.hasTotNumReports()) || (!hasTotNumReports() && msg.hasTotNumReports())) return false;
		if (!(!hasTotNumReports() && !msg.hasTotNumReports()) && !(getTotNumReports()==msg.getTotNumReports())) return false;
		if ((hasLastRptRequested() && !msg.hasLastRptRequested()) || (!hasLastRptRequested() && msg.hasLastRptRequested())) return false;
		if (!(!hasLastRptRequested() && !msg.hasLastRptRequested()) && !(getLastRptRequested()==msg.getLastRptRequested())) return false;
		if ((hasTradeOriginationDate() && !msg.hasTradeOriginationDate()) || (!hasTradeOriginationDate() && msg.hasTradeOriginationDate())) return false;
		if ((hasListID() && !msg.hasListID()) || (!hasListID() && msg.hasListID())) return false;
		if (!(!hasListID() && !msg.hasListID()) && !FixUtils.equals(getListID(), msg.getListID())) return false;
		if ((hasCrossID() && !msg.hasCrossID()) || (!hasCrossID() && msg.hasCrossID())) return false;
		if (!(!hasCrossID() && !msg.hasCrossID()) && !FixUtils.equals(getCrossID(), msg.getCrossID())) return false;
		if ((hasOrigCrossID() && !msg.hasOrigCrossID()) || (!hasOrigCrossID() && msg.hasOrigCrossID())) return false;
		if (!(!hasOrigCrossID() && !msg.hasOrigCrossID()) && !FixUtils.equals(getOrigCrossID(), msg.getOrigCrossID())) return false;
		if ((hasCrossType() && !msg.hasCrossType()) || (!hasCrossType() && msg.hasCrossType())) return false;
		if (!(!hasCrossType() && !msg.hasCrossType()) && !(getCrossType()==msg.getCrossType())) return false;
		if ((hasTrdMatchID() && !msg.hasTrdMatchID()) || (!hasTrdMatchID() && msg.hasTrdMatchID())) return false;
		if (!(!hasTrdMatchID() && !msg.hasTrdMatchID()) && !FixUtils.equals(getTrdMatchID(), msg.getTrdMatchID())) return false;
		if ((hasExecID() && !msg.hasExecID()) || (!hasExecID() && msg.hasExecID())) return false;
		if (!(!hasExecID() && !msg.hasExecID()) && !FixUtils.equals(getExecID(), msg.getExecID())) return false;
		if ((hasExecRefID() && !msg.hasExecRefID()) || (!hasExecRefID() && msg.hasExecRefID())) return false;
		if (!(!hasExecRefID() && !msg.hasExecRefID()) && !FixUtils.equals(getExecRefID(), msg.getExecRefID())) return false;
		if ((hasExecType() && !msg.hasExecType()) || (!hasExecType() && msg.hasExecType())) return false;
		if (!(!hasExecType() && !msg.hasExecType()) && !(getExecType()==msg.getExecType())) return false;
		if ((hasOrdStatus() && !msg.hasOrdStatus()) || (!hasOrdStatus() && msg.hasOrdStatus())) return false;
		if (!(!hasOrdStatus() && !msg.hasOrdStatus()) && !(getOrdStatus()==msg.getOrdStatus())) return false;
		if ((hasWorkingIndicator() && !msg.hasWorkingIndicator()) || (!hasWorkingIndicator() && msg.hasWorkingIndicator())) return false;
		if (!(!hasWorkingIndicator() && !msg.hasWorkingIndicator()) && !(getWorkingIndicator()==msg.getWorkingIndicator())) return false;
		if ((hasOrdRejReason() && !msg.hasOrdRejReason()) || (!hasOrdRejReason() && msg.hasOrdRejReason())) return false;
		if (!(!hasOrdRejReason() && !msg.hasOrdRejReason()) && !(getOrdRejReason()==msg.getOrdRejReason())) return false;
		if ((hasExecRestatementReason() && !msg.hasExecRestatementReason()) || (!hasExecRestatementReason() && msg.hasExecRestatementReason())) return false;
		if (!(!hasExecRestatementReason() && !msg.hasExecRestatementReason()) && !(getExecRestatementReason()==msg.getExecRestatementReason())) return false;
		if ((hasAccount() && !msg.hasAccount()) || (!hasAccount() && msg.hasAccount())) return false;
		if (!(!hasAccount() && !msg.hasAccount()) && !FixUtils.equals(getAccount(), msg.getAccount())) return false;
		if ((hasAcctIDSource() && !msg.hasAcctIDSource()) || (!hasAcctIDSource() && msg.hasAcctIDSource())) return false;
		if (!(!hasAcctIDSource() && !msg.hasAcctIDSource()) && !(getAcctIDSource()==msg.getAcctIDSource())) return false;
		if ((hasAccountType() && !msg.hasAccountType()) || (!hasAccountType() && msg.hasAccountType())) return false;
		if (!(!hasAccountType() && !msg.hasAccountType()) && !(getAccountType()==msg.getAccountType())) return false;
		if ((hasDayBookingInst() && !msg.hasDayBookingInst()) || (!hasDayBookingInst() && msg.hasDayBookingInst())) return false;
		if (!(!hasDayBookingInst() && !msg.hasDayBookingInst()) && !(getDayBookingInst()==msg.getDayBookingInst())) return false;
		if ((hasBookingUnit() && !msg.hasBookingUnit()) || (!hasBookingUnit() && msg.hasBookingUnit())) return false;
		if (!(!hasBookingUnit() && !msg.hasBookingUnit()) && !(getBookingUnit()==msg.getBookingUnit())) return false;
		if ((hasPreallocMethod() && !msg.hasPreallocMethod()) || (!hasPreallocMethod() && msg.hasPreallocMethod())) return false;
		if (!(!hasPreallocMethod() && !msg.hasPreallocMethod()) && !(getPreallocMethod()==msg.getPreallocMethod())) return false;
		if ((hasAllocID() && !msg.hasAllocID()) || (!hasAllocID() && msg.hasAllocID())) return false;
		if (!(!hasAllocID() && !msg.hasAllocID()) && !FixUtils.equals(getAllocID(), msg.getAllocID())) return false;
		if ((hasSettlType() && !msg.hasSettlType()) || (!hasSettlType() && msg.hasSettlType())) return false;
		if (!(!hasSettlType() && !msg.hasSettlType()) && !FixUtils.equals(getSettlType(), msg.getSettlType())) return false;
		if ((hasSettlDate() && !msg.hasSettlDate()) || (!hasSettlDate() && msg.hasSettlDate())) return false;
		if ((hasMatchType() && !msg.hasMatchType()) || (!hasMatchType() && msg.hasMatchType())) return false;
		if (!(!hasMatchType() && !msg.hasMatchType()) && !FixUtils.equals(getMatchType(), msg.getMatchType())) return false;
		if ((hasOrderCategory() && !msg.hasOrderCategory()) || (!hasOrderCategory() && msg.hasOrderCategory())) return false;
		if (!(!hasOrderCategory() && !msg.hasOrderCategory()) && !(getOrderCategory()==msg.getOrderCategory())) return false;
		if ((hasCashMargin() && !msg.hasCashMargin()) || (!hasCashMargin() && msg.hasCashMargin())) return false;
		if (!(!hasCashMargin() && !msg.hasCashMargin()) && !(getCashMargin()==msg.getCashMargin())) return false;
		if ((hasClearingFeeIndicator() && !msg.hasClearingFeeIndicator()) || (!hasClearingFeeIndicator() && msg.hasClearingFeeIndicator())) return false;
		if (!(!hasClearingFeeIndicator() && !msg.hasClearingFeeIndicator()) && !FixUtils.equals(getClearingFeeIndicator(), msg.getClearingFeeIndicator())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasQtyType() && !msg.hasQtyType()) || (!hasQtyType() && msg.hasQtyType())) return false;
		if (!(!hasQtyType() && !msg.hasQtyType()) && !(getQtyType()==msg.getQtyType())) return false;
		if ((hasLotType() && !msg.hasLotType()) || (!hasLotType() && msg.hasLotType())) return false;
		if (!(!hasLotType() && !msg.hasLotType()) && !(getLotType()==msg.getLotType())) return false;
		if ((hasOrdType() && !msg.hasOrdType()) || (!hasOrdType() && msg.hasOrdType())) return false;
		if (!(!hasOrdType() && !msg.hasOrdType()) && !(getOrdType()==msg.getOrdType())) return false;
		if ((hasPriceType() && !msg.hasPriceType()) || (!hasPriceType() && msg.hasPriceType())) return false;
		if (!(!hasPriceType() && !msg.hasPriceType()) && !(getPriceType()==msg.getPriceType())) return false;
		if ((hasPrice() && !msg.hasPrice()) || (!hasPrice() && msg.hasPrice())) return false;
		if (!(!hasPrice() && !msg.hasPrice()) && !(getPrice()==msg.getPrice())) return false;
		if ((hasPriceProtectionScope() && !msg.hasPriceProtectionScope()) || (!hasPriceProtectionScope() && msg.hasPriceProtectionScope())) return false;
		if (!(!hasPriceProtectionScope() && !msg.hasPriceProtectionScope()) && !(getPriceProtectionScope()==msg.getPriceProtectionScope())) return false;
		if ((hasStopPx() && !msg.hasStopPx()) || (!hasStopPx() && msg.hasStopPx())) return false;
		if (!(!hasStopPx() && !msg.hasStopPx()) && !(getStopPx()==msg.getStopPx())) return false;
		if ((hasPeggedPrice() && !msg.hasPeggedPrice()) || (!hasPeggedPrice() && msg.hasPeggedPrice())) return false;
		if (!(!hasPeggedPrice() && !msg.hasPeggedPrice()) && !(getPeggedPrice()==msg.getPeggedPrice())) return false;
		if ((hasPeggedRefPrice() && !msg.hasPeggedRefPrice()) || (!hasPeggedRefPrice() && msg.hasPeggedRefPrice())) return false;
		if (!(!hasPeggedRefPrice() && !msg.hasPeggedRefPrice()) && !(getPeggedRefPrice()==msg.getPeggedRefPrice())) return false;
		if ((hasDiscretionPrice() && !msg.hasDiscretionPrice()) || (!hasDiscretionPrice() && msg.hasDiscretionPrice())) return false;
		if (!(!hasDiscretionPrice() && !msg.hasDiscretionPrice()) && !(getDiscretionPrice()==msg.getDiscretionPrice())) return false;
		if ((hasTargetStrategy() && !msg.hasTargetStrategy()) || (!hasTargetStrategy() && msg.hasTargetStrategy())) return false;
		if (!(!hasTargetStrategy() && !msg.hasTargetStrategy()) && !(getTargetStrategy()==msg.getTargetStrategy())) return false;
		if ((hasTargetStrategyParameters() && !msg.hasTargetStrategyParameters()) || (!hasTargetStrategyParameters() && msg.hasTargetStrategyParameters())) return false;
		if (!(!hasTargetStrategyParameters() && !msg.hasTargetStrategyParameters()) && !FixUtils.equals(getTargetStrategyParameters(), msg.getTargetStrategyParameters())) return false;
		if ((hasParticipationRate() && !msg.hasParticipationRate()) || (!hasParticipationRate() && msg.hasParticipationRate())) return false;
		if (!(!hasParticipationRate() && !msg.hasParticipationRate()) && !(getParticipationRate()==msg.getParticipationRate())) return false;
		if ((hasTargetStrategyPerformance() && !msg.hasTargetStrategyPerformance()) || (!hasTargetStrategyPerformance() && msg.hasTargetStrategyPerformance())) return false;
		if (!(!hasTargetStrategyPerformance() && !msg.hasTargetStrategyPerformance()) && !(getTargetStrategyPerformance()==msg.getTargetStrategyPerformance())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasComplianceID() && !msg.hasComplianceID()) || (!hasComplianceID() && msg.hasComplianceID())) return false;
		if (!(!hasComplianceID() && !msg.hasComplianceID()) && !FixUtils.equals(getComplianceID(), msg.getComplianceID())) return false;
		if ((hasSolicitedFlag() && !msg.hasSolicitedFlag()) || (!hasSolicitedFlag() && msg.hasSolicitedFlag())) return false;
		if (!(!hasSolicitedFlag() && !msg.hasSolicitedFlag()) && !(getSolicitedFlag()==msg.getSolicitedFlag())) return false;
		if ((hasTimeInForce() && !msg.hasTimeInForce()) || (!hasTimeInForce() && msg.hasTimeInForce())) return false;
		if (!(!hasTimeInForce() && !msg.hasTimeInForce()) && !(getTimeInForce()==msg.getTimeInForce())) return false;
		if ((hasEffectiveTime() && !msg.hasEffectiveTime()) || (!hasEffectiveTime() && msg.hasEffectiveTime())) return false;
		if ((hasExpireDate() && !msg.hasExpireDate()) || (!hasExpireDate() && msg.hasExpireDate())) return false;
		if ((hasExpireTime() && !msg.hasExpireTime()) || (!hasExpireTime() && msg.hasExpireTime())) return false;
		if ((hasExecInst() && !msg.hasExecInst()) || (!hasExecInst() && msg.hasExecInst())) return false;
		if (!(!hasExecInst() && !msg.hasExecInst()) && !FixUtils.equals(getExecInst(), msg.getExecInst())) return false;
		if ((hasAggressorIndicator() && !msg.hasAggressorIndicator()) || (!hasAggressorIndicator() && msg.hasAggressorIndicator())) return false;
		if (!(!hasAggressorIndicator() && !msg.hasAggressorIndicator()) && !(getAggressorIndicator()==msg.getAggressorIndicator())) return false;
		if ((hasOrderCapacity() && !msg.hasOrderCapacity()) || (!hasOrderCapacity() && msg.hasOrderCapacity())) return false;
		if (!(!hasOrderCapacity() && !msg.hasOrderCapacity()) && !(getOrderCapacity()==msg.getOrderCapacity())) return false;
		if ((hasOrderRestrictions() && !msg.hasOrderRestrictions()) || (!hasOrderRestrictions() && msg.hasOrderRestrictions())) return false;
		if (!(!hasOrderRestrictions() && !msg.hasOrderRestrictions()) && !FixUtils.equals(getOrderRestrictions(), msg.getOrderRestrictions())) return false;
		if ((hasPreTradeAnonymity() && !msg.hasPreTradeAnonymity()) || (!hasPreTradeAnonymity() && msg.hasPreTradeAnonymity())) return false;
		if (!(!hasPreTradeAnonymity() && !msg.hasPreTradeAnonymity()) && !(getPreTradeAnonymity()==msg.getPreTradeAnonymity())) return false;
		if ((hasCustOrderCapacity() && !msg.hasCustOrderCapacity()) || (!hasCustOrderCapacity() && msg.hasCustOrderCapacity())) return false;
		if (!(!hasCustOrderCapacity() && !msg.hasCustOrderCapacity()) && !(getCustOrderCapacity()==msg.getCustOrderCapacity())) return false;
		if ((hasLastQty() && !msg.hasLastQty()) || (!hasLastQty() && msg.hasLastQty())) return false;
		if (!(!hasLastQty() && !msg.hasLastQty()) && !(getLastQty()==msg.getLastQty())) return false;
		if ((hasCalculatedCcyLastQty() && !msg.hasCalculatedCcyLastQty()) || (!hasCalculatedCcyLastQty() && msg.hasCalculatedCcyLastQty())) return false;
		if (!(!hasCalculatedCcyLastQty() && !msg.hasCalculatedCcyLastQty()) && !(getCalculatedCcyLastQty()==msg.getCalculatedCcyLastQty())) return false;
		if ((hasLastSwapPoints() && !msg.hasLastSwapPoints()) || (!hasLastSwapPoints() && msg.hasLastSwapPoints())) return false;
		if (!(!hasLastSwapPoints() && !msg.hasLastSwapPoints()) && !(getLastSwapPoints()==msg.getLastSwapPoints())) return false;
		if ((hasUnderlyingLastQty() && !msg.hasUnderlyingLastQty()) || (!hasUnderlyingLastQty() && msg.hasUnderlyingLastQty())) return false;
		if (!(!hasUnderlyingLastQty() && !msg.hasUnderlyingLastQty()) && !(getUnderlyingLastQty()==msg.getUnderlyingLastQty())) return false;
		if ((hasLastPx() && !msg.hasLastPx()) || (!hasLastPx() && msg.hasLastPx())) return false;
		if (!(!hasLastPx() && !msg.hasLastPx()) && !(getLastPx()==msg.getLastPx())) return false;
		if ((hasUnderlyingLastPx() && !msg.hasUnderlyingLastPx()) || (!hasUnderlyingLastPx() && msg.hasUnderlyingLastPx())) return false;
		if (!(!hasUnderlyingLastPx() && !msg.hasUnderlyingLastPx()) && !(getUnderlyingLastPx()==msg.getUnderlyingLastPx())) return false;
		if ((hasLastParPx() && !msg.hasLastParPx()) || (!hasLastParPx() && msg.hasLastParPx())) return false;
		if (!(!hasLastParPx() && !msg.hasLastParPx()) && !(getLastParPx()==msg.getLastParPx())) return false;
		if ((hasLastSpotRate() && !msg.hasLastSpotRate()) || (!hasLastSpotRate() && msg.hasLastSpotRate())) return false;
		if (!(!hasLastSpotRate() && !msg.hasLastSpotRate()) && !(getLastSpotRate()==msg.getLastSpotRate())) return false;
		if ((hasLastForwardPoints() && !msg.hasLastForwardPoints()) || (!hasLastForwardPoints() && msg.hasLastForwardPoints())) return false;
		if (!(!hasLastForwardPoints() && !msg.hasLastForwardPoints()) && !(getLastForwardPoints()==msg.getLastForwardPoints())) return false;
		if ((hasLastMkt() && !msg.hasLastMkt()) || (!hasLastMkt() && msg.hasLastMkt())) return false;
		if (!(!hasLastMkt() && !msg.hasLastMkt()) && !FixUtils.equals(getLastMkt(), msg.getLastMkt())) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		if ((hasTimeBracket() && !msg.hasTimeBracket()) || (!hasTimeBracket() && msg.hasTimeBracket())) return false;
		if (!(!hasTimeBracket() && !msg.hasTimeBracket()) && !FixUtils.equals(getTimeBracket(), msg.getTimeBracket())) return false;
		if ((hasLastCapacity() && !msg.hasLastCapacity()) || (!hasLastCapacity() && msg.hasLastCapacity())) return false;
		if (!(!hasLastCapacity() && !msg.hasLastCapacity()) && !(getLastCapacity()==msg.getLastCapacity())) return false;
		if ((hasLeavesQty() && !msg.hasLeavesQty()) || (!hasLeavesQty() && msg.hasLeavesQty())) return false;
		if (!(!hasLeavesQty() && !msg.hasLeavesQty()) && !(getLeavesQty()==msg.getLeavesQty())) return false;
		if ((hasCumQty() && !msg.hasCumQty()) || (!hasCumQty() && msg.hasCumQty())) return false;
		if (!(!hasCumQty() && !msg.hasCumQty()) && !(getCumQty()==msg.getCumQty())) return false;
		if ((hasAvgPx() && !msg.hasAvgPx()) || (!hasAvgPx() && msg.hasAvgPx())) return false;
		if (!(!hasAvgPx() && !msg.hasAvgPx()) && !(getAvgPx()==msg.getAvgPx())) return false;
		if ((hasDayOrderQty() && !msg.hasDayOrderQty()) || (!hasDayOrderQty() && msg.hasDayOrderQty())) return false;
		if (!(!hasDayOrderQty() && !msg.hasDayOrderQty()) && !(getDayOrderQty()==msg.getDayOrderQty())) return false;
		if ((hasDayCumQty() && !msg.hasDayCumQty()) || (!hasDayCumQty() && msg.hasDayCumQty())) return false;
		if (!(!hasDayCumQty() && !msg.hasDayCumQty()) && !(getDayCumQty()==msg.getDayCumQty())) return false;
		if ((hasDayAvgPx() && !msg.hasDayAvgPx()) || (!hasDayAvgPx() && msg.hasDayAvgPx())) return false;
		if (!(!hasDayAvgPx() && !msg.hasDayAvgPx()) && !(getDayAvgPx()==msg.getDayAvgPx())) return false;
		if ((hasTotNoFills() && !msg.hasTotNoFills()) || (!hasTotNoFills() && msg.hasTotNoFills())) return false;
		if (!(!hasTotNoFills() && !msg.hasTotNoFills()) && !(getTotNoFills()==msg.getTotNoFills())) return false;
		if ((hasLastFragment() && !msg.hasLastFragment()) || (!hasLastFragment() && msg.hasLastFragment())) return false;
		if (!(!hasLastFragment() && !msg.hasLastFragment()) && !(getLastFragment()==msg.getLastFragment())) return false;
		if ((hasGTBookingInst() && !msg.hasGTBookingInst()) || (!hasGTBookingInst() && msg.hasGTBookingInst())) return false;
		if (!(!hasGTBookingInst() && !msg.hasGTBookingInst()) && !(getGTBookingInst()==msg.getGTBookingInst())) return false;
		if ((hasTradeDate() && !msg.hasTradeDate()) || (!hasTradeDate() && msg.hasTradeDate())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasReportToExch() && !msg.hasReportToExch()) || (!hasReportToExch() && msg.hasReportToExch())) return false;
		if (!(!hasReportToExch() && !msg.hasReportToExch()) && !(getReportToExch()==msg.getReportToExch())) return false;
		if ((hasGrossTradeAmt() && !msg.hasGrossTradeAmt()) || (!hasGrossTradeAmt() && msg.hasGrossTradeAmt())) return false;
		if (!(!hasGrossTradeAmt() && !msg.hasGrossTradeAmt()) && !(getGrossTradeAmt()==msg.getGrossTradeAmt())) return false;
		if ((hasNumDaysInterest() && !msg.hasNumDaysInterest()) || (!hasNumDaysInterest() && msg.hasNumDaysInterest())) return false;
		if (!(!hasNumDaysInterest() && !msg.hasNumDaysInterest()) && !(getNumDaysInterest()==msg.getNumDaysInterest())) return false;
		if ((hasExDate() && !msg.hasExDate()) || (!hasExDate() && msg.hasExDate())) return false;
		if ((hasAccruedInterestRate() && !msg.hasAccruedInterestRate()) || (!hasAccruedInterestRate() && msg.hasAccruedInterestRate())) return false;
		if (!(!hasAccruedInterestRate() && !msg.hasAccruedInterestRate()) && !(getAccruedInterestRate()==msg.getAccruedInterestRate())) return false;
		if ((hasAccruedInterestAmt() && !msg.hasAccruedInterestAmt()) || (!hasAccruedInterestAmt() && msg.hasAccruedInterestAmt())) return false;
		if (!(!hasAccruedInterestAmt() && !msg.hasAccruedInterestAmt()) && !(getAccruedInterestAmt()==msg.getAccruedInterestAmt())) return false;
		if ((hasInterestAtMaturity() && !msg.hasInterestAtMaturity()) || (!hasInterestAtMaturity() && msg.hasInterestAtMaturity())) return false;
		if (!(!hasInterestAtMaturity() && !msg.hasInterestAtMaturity()) && !(getInterestAtMaturity()==msg.getInterestAtMaturity())) return false;
		if ((hasEndAccruedInterestAmt() && !msg.hasEndAccruedInterestAmt()) || (!hasEndAccruedInterestAmt() && msg.hasEndAccruedInterestAmt())) return false;
		if (!(!hasEndAccruedInterestAmt() && !msg.hasEndAccruedInterestAmt()) && !(getEndAccruedInterestAmt()==msg.getEndAccruedInterestAmt())) return false;
		if ((hasStartCash() && !msg.hasStartCash()) || (!hasStartCash() && msg.hasStartCash())) return false;
		if (!(!hasStartCash() && !msg.hasStartCash()) && !(getStartCash()==msg.getStartCash())) return false;
		if ((hasEndCash() && !msg.hasEndCash()) || (!hasEndCash() && msg.hasEndCash())) return false;
		if (!(!hasEndCash() && !msg.hasEndCash()) && !(getEndCash()==msg.getEndCash())) return false;
		if ((hasTradedFlatSwitch() && !msg.hasTradedFlatSwitch()) || (!hasTradedFlatSwitch() && msg.hasTradedFlatSwitch())) return false;
		if (!(!hasTradedFlatSwitch() && !msg.hasTradedFlatSwitch()) && !(getTradedFlatSwitch()==msg.getTradedFlatSwitch())) return false;
		if ((hasBasisFeatureDate() && !msg.hasBasisFeatureDate()) || (!hasBasisFeatureDate() && msg.hasBasisFeatureDate())) return false;
		if ((hasBasisFeaturePrice() && !msg.hasBasisFeaturePrice()) || (!hasBasisFeaturePrice() && msg.hasBasisFeaturePrice())) return false;
		if (!(!hasBasisFeaturePrice() && !msg.hasBasisFeaturePrice()) && !(getBasisFeaturePrice()==msg.getBasisFeaturePrice())) return false;
		if ((hasConcession() && !msg.hasConcession()) || (!hasConcession() && msg.hasConcession())) return false;
		if (!(!hasConcession() && !msg.hasConcession()) && !(getConcession()==msg.getConcession())) return false;
		if ((hasTotalTakedown() && !msg.hasTotalTakedown()) || (!hasTotalTakedown() && msg.hasTotalTakedown())) return false;
		if (!(!hasTotalTakedown() && !msg.hasTotalTakedown()) && !(getTotalTakedown()==msg.getTotalTakedown())) return false;
		if ((hasNetMoney() && !msg.hasNetMoney()) || (!hasNetMoney() && msg.hasNetMoney())) return false;
		if (!(!hasNetMoney() && !msg.hasNetMoney()) && !(getNetMoney()==msg.getNetMoney())) return false;
		if ((hasSettlCurrAmt() && !msg.hasSettlCurrAmt()) || (!hasSettlCurrAmt() && msg.hasSettlCurrAmt())) return false;
		if (!(!hasSettlCurrAmt() && !msg.hasSettlCurrAmt()) && !(getSettlCurrAmt()==msg.getSettlCurrAmt())) return false;
		if ((hasSettlCurrency() && !msg.hasSettlCurrency()) || (!hasSettlCurrency() && msg.hasSettlCurrency())) return false;
		if (!(!hasSettlCurrency() && !msg.hasSettlCurrency()) && !FixUtils.equals(getSettlCurrency(), msg.getSettlCurrency())) return false;
		if ((hasSettlCurrFxRate() && !msg.hasSettlCurrFxRate()) || (!hasSettlCurrFxRate() && msg.hasSettlCurrFxRate())) return false;
		if (!(!hasSettlCurrFxRate() && !msg.hasSettlCurrFxRate()) && !(getSettlCurrFxRate()==msg.getSettlCurrFxRate())) return false;
		if ((hasSettlCurrFxRateCalc() && !msg.hasSettlCurrFxRateCalc()) || (!hasSettlCurrFxRateCalc() && msg.hasSettlCurrFxRateCalc())) return false;
		if (!(!hasSettlCurrFxRateCalc() && !msg.hasSettlCurrFxRateCalc()) && !(getSettlCurrFxRateCalc()==msg.getSettlCurrFxRateCalc())) return false;
		if ((hasHandlInst() && !msg.hasHandlInst()) || (!hasHandlInst() && msg.hasHandlInst())) return false;
		if (!(!hasHandlInst() && !msg.hasHandlInst()) && !(getHandlInst()==msg.getHandlInst())) return false;
		if ((hasMinQty() && !msg.hasMinQty()) || (!hasMinQty() && msg.hasMinQty())) return false;
		if (!(!hasMinQty() && !msg.hasMinQty()) && !(getMinQty()==msg.getMinQty())) return false;
		if ((hasMatchIncrement() && !msg.hasMatchIncrement()) || (!hasMatchIncrement() && msg.hasMatchIncrement())) return false;
		if (!(!hasMatchIncrement() && !msg.hasMatchIncrement()) && !(getMatchIncrement()==msg.getMatchIncrement())) return false;
		if ((hasMaxPriceLevels() && !msg.hasMaxPriceLevels()) || (!hasMaxPriceLevels() && msg.hasMaxPriceLevels())) return false;
		if (!(!hasMaxPriceLevels() && !msg.hasMaxPriceLevels()) && !(getMaxPriceLevels()==msg.getMaxPriceLevels())) return false;
		if ((hasMaxFloor() && !msg.hasMaxFloor()) || (!hasMaxFloor() && msg.hasMaxFloor())) return false;
		if (!(!hasMaxFloor() && !msg.hasMaxFloor()) && !(getMaxFloor()==msg.getMaxFloor())) return false;
		if ((hasPositionEffect() && !msg.hasPositionEffect()) || (!hasPositionEffect() && msg.hasPositionEffect())) return false;
		if (!(!hasPositionEffect() && !msg.hasPositionEffect()) && !(getPositionEffect()==msg.getPositionEffect())) return false;
		if ((hasMaxShow() && !msg.hasMaxShow()) || (!hasMaxShow() && msg.hasMaxShow())) return false;
		if (!(!hasMaxShow() && !msg.hasMaxShow()) && !(getMaxShow()==msg.getMaxShow())) return false;
		if ((hasBookingType() && !msg.hasBookingType()) || (!hasBookingType() && msg.hasBookingType())) return false;
		if (!(!hasBookingType() && !msg.hasBookingType()) && !(getBookingType()==msg.getBookingType())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasSettlDate2() && !msg.hasSettlDate2()) || (!hasSettlDate2() && msg.hasSettlDate2())) return false;
		if ((hasOrderQty2() && !msg.hasOrderQty2()) || (!hasOrderQty2() && msg.hasOrderQty2())) return false;
		if (!(!hasOrderQty2() && !msg.hasOrderQty2()) && !(getOrderQty2()==msg.getOrderQty2())) return false;
		if ((hasLastForwardPoints2() && !msg.hasLastForwardPoints2()) || (!hasLastForwardPoints2() && msg.hasLastForwardPoints2())) return false;
		if (!(!hasLastForwardPoints2() && !msg.hasLastForwardPoints2()) && !(getLastForwardPoints2()==msg.getLastForwardPoints2())) return false;
		if ((hasMultiLegReportingType() && !msg.hasMultiLegReportingType()) || (!hasMultiLegReportingType() && msg.hasMultiLegReportingType())) return false;
		if (!(!hasMultiLegReportingType() && !msg.hasMultiLegReportingType()) && !(getMultiLegReportingType()==msg.getMultiLegReportingType())) return false;
		if ((hasCancellationRights() && !msg.hasCancellationRights()) || (!hasCancellationRights() && msg.hasCancellationRights())) return false;
		if (!(!hasCancellationRights() && !msg.hasCancellationRights()) && !(getCancellationRights()==msg.getCancellationRights())) return false;
		if ((hasMoneyLaunderingStatus() && !msg.hasMoneyLaunderingStatus()) || (!hasMoneyLaunderingStatus() && msg.hasMoneyLaunderingStatus())) return false;
		if (!(!hasMoneyLaunderingStatus() && !msg.hasMoneyLaunderingStatus()) && !(getMoneyLaunderingStatus()==msg.getMoneyLaunderingStatus())) return false;
		if ((hasRegistID() && !msg.hasRegistID()) || (!hasRegistID() && msg.hasRegistID())) return false;
		if (!(!hasRegistID() && !msg.hasRegistID()) && !FixUtils.equals(getRegistID(), msg.getRegistID())) return false;
		if ((hasDesignation() && !msg.hasDesignation()) || (!hasDesignation() && msg.hasDesignation())) return false;
		if (!(!hasDesignation() && !msg.hasDesignation()) && !FixUtils.equals(getDesignation(), msg.getDesignation())) return false;
		if ((hasTransBkdTime() && !msg.hasTransBkdTime()) || (!hasTransBkdTime() && msg.hasTransBkdTime())) return false;
		if ((hasExecValuationPoint() && !msg.hasExecValuationPoint()) || (!hasExecValuationPoint() && msg.hasExecValuationPoint())) return false;
		if ((hasExecPriceType() && !msg.hasExecPriceType()) || (!hasExecPriceType() && msg.hasExecPriceType())) return false;
		if (!(!hasExecPriceType() && !msg.hasExecPriceType()) && !(getExecPriceType()==msg.getExecPriceType())) return false;
		if ((hasExecPriceAdjustment() && !msg.hasExecPriceAdjustment()) || (!hasExecPriceAdjustment() && msg.hasExecPriceAdjustment())) return false;
		if (!(!hasExecPriceAdjustment() && !msg.hasExecPriceAdjustment()) && !(getExecPriceAdjustment()==msg.getExecPriceAdjustment())) return false;
		if ((hasPriorityIndicator() && !msg.hasPriorityIndicator()) || (!hasPriorityIndicator() && msg.hasPriorityIndicator())) return false;
		if (!(!hasPriorityIndicator() && !msg.hasPriorityIndicator()) && !(getPriorityIndicator()==msg.getPriorityIndicator())) return false;
		if ((hasPriceImprovement() && !msg.hasPriceImprovement()) || (!hasPriceImprovement() && msg.hasPriceImprovement())) return false;
		if (!(!hasPriceImprovement() && !msg.hasPriceImprovement()) && !(getPriceImprovement()==msg.getPriceImprovement())) return false;
		if ((hasLastLiquidityInd() && !msg.hasLastLiquidityInd()) || (!hasLastLiquidityInd() && msg.hasLastLiquidityInd())) return false;
		if (!(!hasLastLiquidityInd() && !msg.hasLastLiquidityInd()) && !(getLastLiquidityInd()==msg.getLastLiquidityInd())) return false;
		if ((hasCopyMsgIndicator() && !msg.hasCopyMsgIndicator()) || (!hasCopyMsgIndicator() && msg.hasCopyMsgIndicator())) return false;
		if (!(!hasCopyMsgIndicator() && !msg.hasCopyMsgIndicator()) && !(getCopyMsgIndicator()==msg.getCopyMsgIndicator())) return false;
		if ((hasManualOrderIndicator() && !msg.hasManualOrderIndicator()) || (!hasManualOrderIndicator() && msg.hasManualOrderIndicator())) return false;
		if (!(!hasManualOrderIndicator() && !msg.hasManualOrderIndicator()) && !(getManualOrderIndicator()==msg.getManualOrderIndicator())) return false;
		if ((hasCustDirectedOrder() && !msg.hasCustDirectedOrder()) || (!hasCustDirectedOrder() && msg.hasCustDirectedOrder())) return false;
		if (!(!hasCustDirectedOrder() && !msg.hasCustDirectedOrder()) && !(getCustDirectedOrder()==msg.getCustDirectedOrder())) return false;
		if ((hasReceivedDeptID() && !msg.hasReceivedDeptID()) || (!hasReceivedDeptID() && msg.hasReceivedDeptID())) return false;
		if (!(!hasReceivedDeptID() && !msg.hasReceivedDeptID()) && !FixUtils.equals(getReceivedDeptID(), msg.getReceivedDeptID())) return false;
		if ((hasCustOrderHandlingInst() && !msg.hasCustOrderHandlingInst()) || (!hasCustOrderHandlingInst() && msg.hasCustOrderHandlingInst())) return false;
		if (!(!hasCustOrderHandlingInst() && !msg.hasCustOrderHandlingInst()) && !FixUtils.equals(getCustOrderHandlingInst(), msg.getCustOrderHandlingInst())) return false;
		if ((hasOrderHandlingInstSource() && !msg.hasOrderHandlingInstSource()) || (!hasOrderHandlingInstSource() && msg.hasOrderHandlingInstSource())) return false;
		if (!(!hasOrderHandlingInstSource() && !msg.hasOrderHandlingInstSource()) && !(getOrderHandlingInstSource()==msg.getOrderHandlingInstSource())) return false;
		if ((hasDividendYield() && !msg.hasDividendYield()) || (!hasDividendYield() && msg.hasDividendYield())) return false;
		if (!(!hasDividendYield() && !msg.hasDividendYield()) && !(getDividendYield()==msg.getDividendYield())) return false;
		if ((hasVolatility() && !msg.hasVolatility()) || (!hasVolatility() && msg.hasVolatility())) return false;
		if (!(!hasVolatility() && !msg.hasVolatility()) && !(getVolatility()==msg.getVolatility())) return false;
		if ((hasTimeToExpiration() && !msg.hasTimeToExpiration()) || (!hasTimeToExpiration() && msg.hasTimeToExpiration())) return false;
		if (!(!hasTimeToExpiration() && !msg.hasTimeToExpiration()) && !(getTimeToExpiration()==msg.getTimeToExpiration())) return false;
		if ((hasRiskFreeRate() && !msg.hasRiskFreeRate()) || (!hasRiskFreeRate() && msg.hasRiskFreeRate())) return false;
		if (!(!hasRiskFreeRate() && !msg.hasRiskFreeRate()) && !(getRiskFreeRate()==msg.getRiskFreeRate())) return false;
		if ((hasPriceDelta() && !msg.hasPriceDelta()) || (!hasPriceDelta() && msg.hasPriceDelta())) return false;
		if (!(!hasPriceDelta() && !msg.hasPriceDelta()) && !(getPriceDelta()==msg.getPriceDelta())) return false;
		return true;
	}
	@Override
	public FixExecutionReport clone () {
		FixExecutionReport out = new FixExecutionReport();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixExecutionReport clone ( FixExecutionReport out ) {
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasSecondaryOrderID())
			out.setSecondaryOrderID(getSecondaryOrderID());
		if ( hasSecondaryClOrdID())
			out.setSecondaryClOrdID(getSecondaryClOrdID());
		if ( hasSecondaryExecID())
			out.setSecondaryExecID(getSecondaryExecID());
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasOrigClOrdID())
			out.setOrigClOrdID(getOrigClOrdID());
		if ( hasClOrdLinkID())
			out.setClOrdLinkID(getClOrdLinkID());
		if ( hasQuoteRespID())
			out.setQuoteRespID(getQuoteRespID());
		if ( hasOrdStatusReqID())
			out.setOrdStatusReqID(getOrdStatusReqID());
		if ( hasMassStatusReqID())
			out.setMassStatusReqID(getMassStatusReqID());
		if ( hasHostCrossID())
			out.setHostCrossID(getHostCrossID());
		if ( hasTotNumReports())
			out.setTotNumReports(getTotNumReports());
		if ( hasLastRptRequested())
			out.setLastRptRequested(getLastRptRequested());
		if ( hasTradeOriginationDate())
			out.setTradeOriginationDate(getTradeOriginationDate());
		if ( hasListID())
			out.setListID(getListID());
		if ( hasCrossID())
			out.setCrossID(getCrossID());
		if ( hasOrigCrossID())
			out.setOrigCrossID(getOrigCrossID());
		if ( hasCrossType())
			out.setCrossType(getCrossType());
		if ( hasTrdMatchID())
			out.setTrdMatchID(getTrdMatchID());
		if ( hasExecID())
			out.setExecID(getExecID());
		if ( hasExecRefID())
			out.setExecRefID(getExecRefID());
		if ( hasExecType())
			out.setExecType(getExecType());
		if ( hasOrdStatus())
			out.setOrdStatus(getOrdStatus());
		if ( hasWorkingIndicator())
			out.setWorkingIndicator(getWorkingIndicator());
		if ( hasOrdRejReason())
			out.setOrdRejReason(getOrdRejReason());
		if ( hasExecRestatementReason())
			out.setExecRestatementReason(getExecRestatementReason());
		if ( hasAccount())
			out.setAccount(getAccount());
		if ( hasAcctIDSource())
			out.setAcctIDSource(getAcctIDSource());
		if ( hasAccountType())
			out.setAccountType(getAccountType());
		if ( hasDayBookingInst())
			out.setDayBookingInst(getDayBookingInst());
		if ( hasBookingUnit())
			out.setBookingUnit(getBookingUnit());
		if ( hasPreallocMethod())
			out.setPreallocMethod(getPreallocMethod());
		if ( hasAllocID())
			out.setAllocID(getAllocID());
		if ( hasSettlType())
			out.setSettlType(getSettlType());
		if ( hasSettlDate())
			out.setSettlDate(getSettlDate());
		if ( hasMatchType())
			out.setMatchType(getMatchType());
		if ( hasOrderCategory())
			out.setOrderCategory(getOrderCategory());
		if ( hasCashMargin())
			out.setCashMargin(getCashMargin());
		if ( hasClearingFeeIndicator())
			out.setClearingFeeIndicator(getClearingFeeIndicator());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasQtyType())
			out.setQtyType(getQtyType());
		if ( hasLotType())
			out.setLotType(getLotType());
		if ( hasOrdType())
			out.setOrdType(getOrdType());
		if ( hasPriceType())
			out.setPriceType(getPriceType());
		if ( hasPrice())
			out.setPrice(getPrice());
		if ( hasPriceProtectionScope())
			out.setPriceProtectionScope(getPriceProtectionScope());
		if ( hasStopPx())
			out.setStopPx(getStopPx());
		if ( hasPeggedPrice())
			out.setPeggedPrice(getPeggedPrice());
		if ( hasPeggedRefPrice())
			out.setPeggedRefPrice(getPeggedRefPrice());
		if ( hasDiscretionPrice())
			out.setDiscretionPrice(getDiscretionPrice());
		if ( hasTargetStrategy())
			out.setTargetStrategy(getTargetStrategy());
		if ( hasTargetStrategyParameters())
			out.setTargetStrategyParameters(getTargetStrategyParameters());
		if ( hasParticipationRate())
			out.setParticipationRate(getParticipationRate());
		if ( hasTargetStrategyPerformance())
			out.setTargetStrategyPerformance(getTargetStrategyPerformance());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasComplianceID())
			out.setComplianceID(getComplianceID());
		if ( hasSolicitedFlag())
			out.setSolicitedFlag(getSolicitedFlag());
		if ( hasTimeInForce())
			out.setTimeInForce(getTimeInForce());
		if ( hasEffectiveTime())
			out.setEffectiveTime(getEffectiveTime());
		if ( hasExpireDate())
			out.setExpireDate(getExpireDate());
		if ( hasExpireTime())
			out.setExpireTime(getExpireTime());
		if ( hasExecInst())
			out.setExecInst(getExecInst());
		if ( hasAggressorIndicator())
			out.setAggressorIndicator(getAggressorIndicator());
		if ( hasOrderCapacity())
			out.setOrderCapacity(getOrderCapacity());
		if ( hasOrderRestrictions())
			out.setOrderRestrictions(getOrderRestrictions());
		if ( hasPreTradeAnonymity())
			out.setPreTradeAnonymity(getPreTradeAnonymity());
		if ( hasCustOrderCapacity())
			out.setCustOrderCapacity(getCustOrderCapacity());
		if ( hasLastQty())
			out.setLastQty(getLastQty());
		if ( hasCalculatedCcyLastQty())
			out.setCalculatedCcyLastQty(getCalculatedCcyLastQty());
		if ( hasLastSwapPoints())
			out.setLastSwapPoints(getLastSwapPoints());
		if ( hasUnderlyingLastQty())
			out.setUnderlyingLastQty(getUnderlyingLastQty());
		if ( hasLastPx())
			out.setLastPx(getLastPx());
		if ( hasUnderlyingLastPx())
			out.setUnderlyingLastPx(getUnderlyingLastPx());
		if ( hasLastParPx())
			out.setLastParPx(getLastParPx());
		if ( hasLastSpotRate())
			out.setLastSpotRate(getLastSpotRate());
		if ( hasLastForwardPoints())
			out.setLastForwardPoints(getLastForwardPoints());
		if ( hasLastMkt())
			out.setLastMkt(getLastMkt());
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		if ( hasTimeBracket())
			out.setTimeBracket(getTimeBracket());
		if ( hasLastCapacity())
			out.setLastCapacity(getLastCapacity());
		if ( hasLeavesQty())
			out.setLeavesQty(getLeavesQty());
		if ( hasCumQty())
			out.setCumQty(getCumQty());
		if ( hasAvgPx())
			out.setAvgPx(getAvgPx());
		if ( hasDayOrderQty())
			out.setDayOrderQty(getDayOrderQty());
		if ( hasDayCumQty())
			out.setDayCumQty(getDayCumQty());
		if ( hasDayAvgPx())
			out.setDayAvgPx(getDayAvgPx());
		if ( hasTotNoFills())
			out.setTotNoFills(getTotNoFills());
		if ( hasLastFragment())
			out.setLastFragment(getLastFragment());
		if ( hasGTBookingInst())
			out.setGTBookingInst(getGTBookingInst());
		if ( hasTradeDate())
			out.setTradeDate(getTradeDate());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasReportToExch())
			out.setReportToExch(getReportToExch());
		if ( hasGrossTradeAmt())
			out.setGrossTradeAmt(getGrossTradeAmt());
		if ( hasNumDaysInterest())
			out.setNumDaysInterest(getNumDaysInterest());
		if ( hasExDate())
			out.setExDate(getExDate());
		if ( hasAccruedInterestRate())
			out.setAccruedInterestRate(getAccruedInterestRate());
		if ( hasAccruedInterestAmt())
			out.setAccruedInterestAmt(getAccruedInterestAmt());
		if ( hasInterestAtMaturity())
			out.setInterestAtMaturity(getInterestAtMaturity());
		if ( hasEndAccruedInterestAmt())
			out.setEndAccruedInterestAmt(getEndAccruedInterestAmt());
		if ( hasStartCash())
			out.setStartCash(getStartCash());
		if ( hasEndCash())
			out.setEndCash(getEndCash());
		if ( hasTradedFlatSwitch())
			out.setTradedFlatSwitch(getTradedFlatSwitch());
		if ( hasBasisFeatureDate())
			out.setBasisFeatureDate(getBasisFeatureDate());
		if ( hasBasisFeaturePrice())
			out.setBasisFeaturePrice(getBasisFeaturePrice());
		if ( hasConcession())
			out.setConcession(getConcession());
		if ( hasTotalTakedown())
			out.setTotalTakedown(getTotalTakedown());
		if ( hasNetMoney())
			out.setNetMoney(getNetMoney());
		if ( hasSettlCurrAmt())
			out.setSettlCurrAmt(getSettlCurrAmt());
		if ( hasSettlCurrency())
			out.setSettlCurrency(getSettlCurrency());
		if ( hasSettlCurrFxRate())
			out.setSettlCurrFxRate(getSettlCurrFxRate());
		if ( hasSettlCurrFxRateCalc())
			out.setSettlCurrFxRateCalc(getSettlCurrFxRateCalc());
		if ( hasHandlInst())
			out.setHandlInst(getHandlInst());
		if ( hasMinQty())
			out.setMinQty(getMinQty());
		if ( hasMatchIncrement())
			out.setMatchIncrement(getMatchIncrement());
		if ( hasMaxPriceLevels())
			out.setMaxPriceLevels(getMaxPriceLevels());
		if ( hasMaxFloor())
			out.setMaxFloor(getMaxFloor());
		if ( hasPositionEffect())
			out.setPositionEffect(getPositionEffect());
		if ( hasMaxShow())
			out.setMaxShow(getMaxShow());
		if ( hasBookingType())
			out.setBookingType(getBookingType());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasSettlDate2())
			out.setSettlDate2(getSettlDate2());
		if ( hasOrderQty2())
			out.setOrderQty2(getOrderQty2());
		if ( hasLastForwardPoints2())
			out.setLastForwardPoints2(getLastForwardPoints2());
		if ( hasMultiLegReportingType())
			out.setMultiLegReportingType(getMultiLegReportingType());
		if ( hasCancellationRights())
			out.setCancellationRights(getCancellationRights());
		if ( hasMoneyLaunderingStatus())
			out.setMoneyLaunderingStatus(getMoneyLaunderingStatus());
		if ( hasRegistID())
			out.setRegistID(getRegistID());
		if ( hasDesignation())
			out.setDesignation(getDesignation());
		if ( hasTransBkdTime())
			out.setTransBkdTime(getTransBkdTime());
		if ( hasExecValuationPoint())
			out.setExecValuationPoint(getExecValuationPoint());
		if ( hasExecPriceType())
			out.setExecPriceType(getExecPriceType());
		if ( hasExecPriceAdjustment())
			out.setExecPriceAdjustment(getExecPriceAdjustment());
		if ( hasPriorityIndicator())
			out.setPriorityIndicator(getPriorityIndicator());
		if ( hasPriceImprovement())
			out.setPriceImprovement(getPriceImprovement());
		if ( hasLastLiquidityInd())
			out.setLastLiquidityInd(getLastLiquidityInd());
		if ( hasCopyMsgIndicator())
			out.setCopyMsgIndicator(getCopyMsgIndicator());
		if ( hasManualOrderIndicator())
			out.setManualOrderIndicator(getManualOrderIndicator());
		if ( hasCustDirectedOrder())
			out.setCustDirectedOrder(getCustDirectedOrder());
		if ( hasReceivedDeptID())
			out.setReceivedDeptID(getReceivedDeptID());
		if ( hasCustOrderHandlingInst())
			out.setCustOrderHandlingInst(getCustOrderHandlingInst());
		if ( hasOrderHandlingInstSource())
			out.setOrderHandlingInstSource(getOrderHandlingInstSource());
		if ( hasDividendYield())
			out.setDividendYield(getDividendYield());
		if ( hasVolatility())
			out.setVolatility(getVolatility());
		if ( hasTimeToExpiration())
			out.setTimeToExpiration(getTimeToExpiration());
		if ( hasRiskFreeRate())
			out.setRiskFreeRate(getRiskFreeRate());
		if ( hasPriceDelta())
			out.setPriceDelta(getPriceDelta());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixContraGrp fixContraGrp : contraGrp) {
			if (!fixContraGrp.hasGroup()) continue;
			out.contraGrp[count] = fixContraGrp.clone( out.contraGrp[count] );
			count++;
		}
		count = 0;
		for (FixPreAllocGrp fixPreAllocGrp : preAllocGrp) {
			if (!fixPreAllocGrp.hasGroup()) continue;
			out.preAllocGrp[count] = fixPreAllocGrp.clone( out.preAllocGrp[count] );
			count++;
		}
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		if (financingDetails.hasGroup())
			out.financingDetails = financingDetails.clone( out.financingDetails);
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		count = 0;
		for (FixStipulations fixStipulations : stipulations) {
			if (!fixStipulations.hasGroup()) continue;
			out.stipulations[count] = fixStipulations.clone( out.stipulations[count] );
			count++;
		}
		if (orderQtyData.hasGroup())
			out.orderQtyData = orderQtyData.clone( out.orderQtyData);
		if (triggeringInstruction.hasGroup())
			out.triggeringInstruction = triggeringInstruction.clone( out.triggeringInstruction);
		if (pegInstructions.hasGroup())
			out.pegInstructions = pegInstructions.clone( out.pegInstructions);
		if (discretionInstructions.hasGroup())
			out.discretionInstructions = discretionInstructions.clone( out.discretionInstructions);
		count = 0;
		for (FixStrategyParametersGrp fixStrategyParametersGrp : strategyParametersGrp) {
			if (!fixStrategyParametersGrp.hasGroup()) continue;
			out.strategyParametersGrp[count] = fixStrategyParametersGrp.clone( out.strategyParametersGrp[count] );
			count++;
		}
		count = 0;
		for (FixFillsGrp fixFillsGrp : fillsGrp) {
			if (!fixFillsGrp.hasGroup()) continue;
			out.fillsGrp[count] = fixFillsGrp.clone( out.fillsGrp[count] );
			count++;
		}
		if (commissionData.hasGroup())
			out.commissionData = commissionData.clone( out.commissionData);
		if (spreadOrBenchmarkCurveData.hasGroup())
			out.spreadOrBenchmarkCurveData = spreadOrBenchmarkCurveData.clone( out.spreadOrBenchmarkCurveData);
		if (yieldData.hasGroup())
			out.yieldData = yieldData.clone( out.yieldData);
		count = 0;
		for (FixRateSource fixRateSource : rateSource) {
			if (!fixRateSource.hasGroup()) continue;
			out.rateSource[count] = fixRateSource.clone( out.rateSource[count] );
			count++;
		}
		if (displayInstruction.hasGroup())
			out.displayInstruction = displayInstruction.clone( out.displayInstruction);
		count = 0;
		for (FixContAmtGrp fixContAmtGrp : contAmtGrp) {
			if (!fixContAmtGrp.hasGroup()) continue;
			out.contAmtGrp[count] = fixContAmtGrp.clone( out.contAmtGrp[count] );
			count++;
		}
		count = 0;
		for (FixInstrmtLegExecGrp fixInstrmtLegExecGrp : instrmtLegExecGrp) {
			if (!fixInstrmtLegExecGrp.hasGroup()) continue;
			out.instrmtLegExecGrp[count] = fixInstrmtLegExecGrp.clone( out.instrmtLegExecGrp[count] );
			count++;
		}
		count = 0;
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) {
			if (!fixMiscFeesGrp.hasGroup()) continue;
			out.miscFeesGrp[count] = fixMiscFeesGrp.clone( out.miscFeesGrp[count] );
			count++;
		}
		count = 0;
		for (FixTrdRegTimestamps fixTrdRegTimestamps : trdRegTimestamps) {
			if (!fixTrdRegTimestamps.hasGroup()) continue;
			out.trdRegTimestamps[count] = fixTrdRegTimestamps.clone( out.trdRegTimestamps[count] );
			count++;
		}
		return out;
	}

}
