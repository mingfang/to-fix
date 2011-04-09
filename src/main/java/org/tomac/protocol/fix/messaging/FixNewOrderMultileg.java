package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixNewOrderMultileg extends FixInMessage {
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryClOrdID;
	byte[] secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClOrdLinkID;
	byte[] clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeOriginationDate;
	byte[] tradeOriginationDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeDate;
	byte[] tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
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
	private short hasCashMargin;
	byte cashMargin = (byte)' ';		
	private short hasClearingFeeIndicator;
	byte[] clearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasHandlInst;
	byte handlInst = (byte)' ';		
	private short hasExecInst;
	byte[] execInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMinQty;
	long minQty = 0;		
	private short hasMatchIncrement;
	long matchIncrement = 0;		
	private short hasMaxPriceLevels;
	long maxPriceLevels = 0;		
	private short hasMaxFloor;
	long maxFloor = 0;		
	private short hasExDestination;
	byte[] exDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExDestinationIDSource;
	byte exDestinationIDSource = (byte)' ';		
	private short hasProcessCode;
	byte processCode = (byte)' ';		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasPrevClosePx;
	long prevClosePx = 0;		
	private short hasSwapPoints;
	long swapPoints = 0;		
	private short hasLocateReqd;
		boolean locateReqd = false;		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasQtyType;
	long qtyType = 0;		
	private short hasOrdType;
	byte ordType = (byte)' ';		
	private short hasMultilegModel;
	long multilegModel = 0;		
	private short hasMultilegPriceMethod;
	long multilegPriceMethod = 0;		
	private short hasPriceType;
	long priceType = 0;		
	private short hasPrice;
	long price = 0;		
	private short hasPriceProtectionScope;
	byte priceProtectionScope = (byte)' ';		
	private short hasStopPx;
	long stopPx = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasComplianceID;
	byte[] complianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSolicitedFlag;
		boolean solicitedFlag = false;		
	private short hasIOIID;
	byte[] iOIID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteID;
	byte[] quoteID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRefOrderID;
	byte[] refOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRefOrderIDSource;
	byte refOrderIDSource = (byte)' ';		
	private short hasTimeInForce;
	byte timeInForce = (byte)' ';		
	private short hasEffectiveTime;
	byte[] effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasExpireDate;
	byte[] expireDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExpireTime;
	byte[] expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasGTBookingInst;
	long gTBookingInst = 0;		
	private short hasOrderCapacity;
	byte orderCapacity = (byte)' ';		
	private short hasOrderRestrictions;
	byte[] orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPreTradeAnonymity;
		boolean preTradeAnonymity = false;		
	private short hasCustOrderCapacity;
	long custOrderCapacity = 0;		
	private short hasForexReq;
		boolean forexReq = false;		
	private short hasSettlCurrency;
	byte[] settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasBookingType;
	long bookingType = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasPositionEffect;
	byte positionEffect = (byte)' ';		
	private short hasCoveredOrUncovered;
	long coveredOrUncovered = 0;		
	private short hasMaxShow;
	long maxShow = 0;		
	private short hasTargetStrategy;
	long targetStrategy = 0;		
	private short hasTargetStrategyParameters;
	byte[] targetStrategyParameters = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskFreeRate;
	long riskFreeRate = 0;		
	private short hasParticipationRate;
	long participationRate = 0;		
	private short hasCancellationRights;
	byte cancellationRights = (byte)' ';		
	private short hasMoneyLaunderingStatus;
	byte moneyLaunderingStatus = (byte)' ';		
	private short hasRegistID;
	byte[] registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDesignation;
	byte[] designation = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMultiLegRptTypeReq;
	long multiLegRptTypeReq = 0;		
	public FixParties[] parties;
	public FixPreAllocMlegGrp[] preAllocMlegGrp;
	public FixDisplayInstruction displayInstruction;
	public FixTrdgSesGrp[] trdgSesGrp;
	public FixInstrument instrument;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixLegOrdGrp[] legOrdGrp;
	public FixOrderQtyData orderQtyData;
	public FixTriggeringInstruction triggeringInstruction;
	public FixCommissionData commissionData;
	public FixPegInstructions pegInstructions;
	public FixDiscretionInstructions discretionInstructions;
	public FixStrategyParametersGrp[] strategyParametersGrp;
	
	public FixNewOrderMultileg() {
		super(FixMessageInfo.MessageTypes.NEWORDERMULTILEG);


		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClOrdLinkID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeOriginationDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeOriginationDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
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
		hasCashMargin = FixUtils.TAG_HAS_NO_VALUE;		
		hasClearingFeeIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		clearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasHandlInst = FixUtils.TAG_HAS_NO_VALUE;		
		hasExecInst = FixUtils.TAG_HAS_NO_VALUE;		
		execInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMinQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasMatchIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxPriceLevels = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxFloor = FixUtils.TAG_HAS_NO_VALUE;		
		hasExDestination = FixUtils.TAG_HAS_NO_VALUE;		
		exDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExDestinationIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasProcessCode = FixUtils.TAG_HAS_NO_VALUE;		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasPrevClosePx = FixUtils.TAG_HAS_NO_VALUE;		
		hasSwapPoints = FixUtils.TAG_HAS_NO_VALUE;		
		hasLocateReqd = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasQtyType = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMultilegModel = FixUtils.TAG_HAS_NO_VALUE;		
		hasMultilegPriceMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceProtectionScope = FixUtils.TAG_HAS_NO_VALUE;		
		hasStopPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasComplianceID = FixUtils.TAG_HAS_NO_VALUE;		
		complianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSolicitedFlag = FixUtils.TAG_HAS_NO_VALUE;		
		hasIOIID = FixUtils.TAG_HAS_NO_VALUE;		
		iOIID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRefOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		refOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRefOrderIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasTimeInForce = FixUtils.TAG_HAS_NO_VALUE;		
		hasEffectiveTime = FixUtils.TAG_HAS_NO_VALUE;		
		effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasExpireDate = FixUtils.TAG_HAS_NO_VALUE;		
		expireDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;		
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasGTBookingInst = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderRestrictions = FixUtils.TAG_HAS_NO_VALUE;		
		orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPreTradeAnonymity = FixUtils.TAG_HAS_NO_VALUE;		
		hasCustOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasForexReq = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasBookingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasPositionEffect = FixUtils.TAG_HAS_NO_VALUE;		
		hasCoveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxShow = FixUtils.TAG_HAS_NO_VALUE;		
		hasTargetStrategy = FixUtils.TAG_HAS_NO_VALUE;		
		hasTargetStrategyParameters = FixUtils.TAG_HAS_NO_VALUE;		
		targetStrategyParameters = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskFreeRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasParticipationRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasCancellationRights = FixUtils.TAG_HAS_NO_VALUE;		
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasRegistID = FixUtils.TAG_HAS_NO_VALUE;		
		registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDesignation = FixUtils.TAG_HAS_NO_VALUE;		
		designation = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMultiLegRptTypeReq = FixUtils.TAG_HAS_NO_VALUE;		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		preAllocMlegGrp = new FixPreAllocMlegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) preAllocMlegGrp[i] = new FixPreAllocMlegGrp();
		displayInstruction = new FixDisplayInstruction();
		trdgSesGrp = new FixTrdgSesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdgSesGrp[i] = new FixTrdgSesGrp();
		instrument = new FixInstrument();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		legOrdGrp = new FixLegOrdGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) legOrdGrp[i] = new FixLegOrdGrp();
		orderQtyData = new FixOrderQtyData();
		triggeringInstruction = new FixTriggeringInstruction();
		commissionData = new FixCommissionData();
		pegInstructions = new FixPegInstructions();
		discretionInstructions = new FixDiscretionInstructions();
		strategyParametersGrp = new FixStrategyParametersGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) strategyParametersGrp[i] = new FixStrategyParametersGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYCLORDID_INT:		
            		hasSecondaryClOrdID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CLORDLINKID_INT:		
            		hasClOrdLinkID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEORIGINATIONDATE_INT:		
            		hasTradeOriginationDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEDATE_INT:		
            		hasTradeDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ACCOUNT_INT:		
            		hasAccount = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ACCTIDSOURCE_INT:		
            		hasAcctIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ACCOUNTTYPE_INT:		
            		hasAccountType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.DAYBOOKINGINST_INT:		
            		hasDayBookingInst = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.BOOKINGUNIT_INT:		
            		hasBookingUnit = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PREALLOCMETHOD_INT:		
            		hasPreallocMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCID_INT:		
            		hasAllocID = (short) buf.position();		
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
            	case FixTags.CASHMARGIN_INT:		
            		hasCashMargin = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGFEEINDICATOR_INT:		
            		hasClearingFeeIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.HANDLINST_INT:		
            		hasHandlInst = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXECINST_INT:		
            		hasExecInst = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MINQTY_INT:		
            		hasMinQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MATCHINCREMENT_INT:		
            		hasMatchIncrement = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MAXPRICELEVELS_INT:		
            		hasMaxPriceLevels = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MAXFLOOR_INT:		
            		hasMaxFloor = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXDESTINATION_INT:		
            		hasExDestination = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXDESTINATIONIDSOURCE_INT:		
            		hasExDestinationIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PROCESSCODE_INT:		
            		hasProcessCode = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PREVCLOSEPX_INT:		
            		hasPrevClosePx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SWAPPOINTS_INT:		
            		hasSwapPoints = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LOCATEREQD_INT:		
            		hasLocateReqd = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.QTYTYPE_INT:		
            		hasQtyType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ORDTYPE_INT:		
            		hasOrdType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MULTILEGMODEL_INT:		
            		hasMultilegModel = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MULTILEGPRICEMETHOD_INT:		
            		hasMultilegPriceMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRICETYPE_INT:		
            		hasPriceType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRICE_INT:		
            		hasPrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRICEPROTECTIONSCOPE_INT:		
            		hasPriceProtectionScope = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.STOPPX_INT:		
            		hasStopPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.COMPLIANCEID_INT:		
            		hasComplianceID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SOLICITEDFLAG_INT:		
            		hasSolicitedFlag = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.IOIID_INT:		
            		hasIOIID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.QUOTEID_INT:		
            		hasQuoteID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.REFORDERID_INT:		
            		hasRefOrderID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.REFORDERIDSOURCE_INT:		
            		hasRefOrderIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TIMEINFORCE_INT:		
            		hasTimeInForce = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EFFECTIVETIME_INT:		
            		hasEffectiveTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXPIREDATE_INT:		
            		hasExpireDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXPIRETIME_INT:		
            		hasExpireTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.GTBOOKINGINST_INT:		
            		hasGTBookingInst = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ORDERCAPACITY_INT:		
            		hasOrderCapacity = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ORDERRESTRICTIONS_INT:		
            		hasOrderRestrictions = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRETRADEANONYMITY_INT:		
            		hasPreTradeAnonymity = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CUSTORDERCAPACITY_INT:		
            		hasCustOrderCapacity = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.FOREXREQ_INT:		
            		hasForexReq = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SETTLCURRENCY_INT:		
            		hasSettlCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.BOOKINGTYPE_INT:		
            		hasBookingType = (short) buf.position();		
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
            	case FixTags.POSITIONEFFECT_INT:		
            		hasPositionEffect = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.COVEREDORUNCOVERED_INT:		
            		hasCoveredOrUncovered = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MAXSHOW_INT:		
            		hasMaxShow = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TARGETSTRATEGY_INT:		
            		hasTargetStrategy = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TARGETSTRATEGYPARAMETERS_INT:		
            		hasTargetStrategyParameters = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.RISKFREERATE_INT:		
            		hasRiskFreeRate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PARTICIPATIONRATE_INT:		
            		hasParticipationRate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CANCELLATIONRIGHTS_INT:		
            		hasCancellationRights = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MONEYLAUNDERINGSTATUS_INT:		
            		hasMoneyLaunderingStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.REGISTID_INT:		
            		hasRegistID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.DESIGNATION_INT:		
            		hasDesignation = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MULTILEGRPTTYPEREQ_INT:		
            		hasMultiLegRptTypeReq = (short) buf.position();		
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
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOALLOCS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !preAllocMlegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = preAllocMlegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( displayInstruction.isKeyTag(tag)) {
        				tag = displayInstruction.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOTRADINGSESSIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdgSesGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdgSesGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
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
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !legOrdGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = legOrdGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
        			} else if ( commissionData.isKeyTag(tag)) {
        				tag = commissionData.setBuffer( tag, buf, err);		
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
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
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
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.NEWORDERMULTILEG_INT);
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
		if (!hasClOrdID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CLORDID_INT, FixMessageInfo.MessageTypes.NEWORDERMULTILEG_INT);
			return false;
		}
		if (!hasSide()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.SIDE_INT, FixMessageInfo.MessageTypes.NEWORDERMULTILEG_INT);
			return false;
		}
		if (!hasTransactTime()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRANSACTTIME_INT, FixMessageInfo.MessageTypes.NEWORDERMULTILEG_INT);
			return false;
		}
		if (!hasOrdType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.ORDTYPE_INT, FixMessageInfo.MessageTypes.NEWORDERMULTILEG_INT);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		getClOrdID();		
		getSecondaryClOrdID();		
		getClOrdLinkID();		
		getTradeOriginationDate();		
		getTradeDate();		
		getAccount();		
		getAcctIDSource();		
		getAccountType();		
		getDayBookingInst();		
		getBookingUnit();		
		getPreallocMethod();		
		getAllocID();		
		getSettlType();		
		getSettlDate();		
		getCashMargin();		
		getClearingFeeIndicator();		
		getHandlInst();		
		getExecInst();		
		getMinQty();		
		getMatchIncrement();		
		getMaxPriceLevels();		
		getMaxFloor();		
		getExDestination();		
		getExDestinationIDSource();		
		getProcessCode();		
		getSide();		
		getPrevClosePx();		
		getSwapPoints();		
		getLocateReqd();		
		getTransactTime();		
		getQtyType();		
		getOrdType();		
		getMultilegModel();		
		getMultilegPriceMethod();		
		getPriceType();		
		getPrice();		
		getPriceProtectionScope();		
		getStopPx();		
		getCurrency();		
		getComplianceID();		
		getSolicitedFlag();		
		getIOIID();		
		getQuoteID();		
		getRefOrderID();		
		getRefOrderIDSource();		
		getTimeInForce();		
		getEffectiveTime();		
		getExpireDate();		
		getExpireTime();		
		getGTBookingInst();		
		getOrderCapacity();		
		getOrderRestrictions();		
		getPreTradeAnonymity();		
		getCustOrderCapacity();		
		getForexReq();		
		getSettlCurrency();		
		getBookingType();		
		getText();		
		getEncodedTextLen();		
		getEncodedText();		
		getPositionEffect();		
		getCoveredOrUncovered();		
		getMaxShow();		
		getTargetStrategy();		
		getTargetStrategyParameters();		
		getRiskFreeRate();		
		getParticipationRate();		
		getCancellationRights();		
		getMoneyLaunderingStatus();		
		getRegistID();		
		getDesignation();		
		getMultiLegRptTypeReq();		
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
		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryClOrdID()) {		
			out.put(FixTags.SECONDARYCLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryClOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClOrdLinkID()) {		
			out.put(FixTags.CLORDLINKID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clOrdLinkID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeOriginationDate()) {		
			out.put(FixTags.TRADEORIGINATIONDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeOriginationDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeDate()) {		
			out.put(FixTags.TRADEDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeDate); 		
		
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
		if (hasHandlInst()) {		
			out.put(FixTags.HANDLINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,handlInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecInst()) {		
			out.put(FixTags.EXECINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execInst); 		
		
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
		if (hasExDestination()) {		
			out.put(FixTags.EXDESTINATION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,exDestination); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExDestinationIDSource()) {		
			out.put(FixTags.EXDESTINATIONIDSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,exDestinationIDSource); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasProcessCode()) {		
			out.put(FixTags.PROCESSCODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,processCode); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSide()) {		
			out.put(FixTags.SIDE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPrevClosePx()) {		
			out.put(FixTags.PREVCLOSEPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)prevClosePx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSwapPoints()) {		
			out.put(FixTags.SWAPPOINTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)swapPoints);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLocateReqd()) {		
			out.put(FixTags.LOCATEREQD);		
		
			out.put((byte) '=');		
		
			out.put(locateReqd?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQtyType()) {		
			out.put(FixTags.QTYTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)qtyType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrdType()) {		
			out.put(FixTags.ORDTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,ordType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMultilegModel()) {		
			out.put(FixTags.MULTILEGMODEL);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)multilegModel);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMultilegPriceMethod()) {		
			out.put(FixTags.MULTILEGPRICEMETHOD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)multilegPriceMethod);
		
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
		if (hasIOIID()) {		
			out.put(FixTags.IOIID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,iOIID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteID()) {		
			out.put(FixTags.QUOTEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,quoteID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRefOrderID()) {		
			out.put(FixTags.REFORDERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,refOrderID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRefOrderIDSource()) {		
			out.put(FixTags.REFORDERIDSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,refOrderIDSource); 		
		
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
		if (hasGTBookingInst()) {		
			out.put(FixTags.GTBOOKINGINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)gTBookingInst);
		
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
		if (hasForexReq()) {		
			out.put(FixTags.FOREXREQ);		
		
			out.put((byte) '=');		
		
			out.put(forexReq?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlCurrency()) {		
			out.put(FixTags.SETTLCURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlCurrency); 		
		
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
		if (hasPositionEffect()) {		
			out.put(FixTags.POSITIONEFFECT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,positionEffect); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCoveredOrUncovered()) {		
			out.put(FixTags.COVEREDORUNCOVERED);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)coveredOrUncovered);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMaxShow()) {		
			out.put(FixTags.MAXSHOW);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)maxShow);
		
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
		if (hasRiskFreeRate()) {		
			out.put(FixTags.RISKFREERATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)riskFreeRate);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasParticipationRate()) {		
			out.put(FixTags.PARTICIPATIONRATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)participationRate);
		
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
		if (hasMultiLegRptTypeReq()) {		
			out.put(FixTags.MULTILEGRPTTYPEREQ);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)multiLegRptTypeReq);
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(preAllocMlegGrp)>0) {
			out.put(FixTags.NOALLOCS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(preAllocMlegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixPreAllocMlegGrp fixPreAllocMlegGrp : preAllocMlegGrp) if (fixPreAllocMlegGrp.hasGroup()) fixPreAllocMlegGrp.encode(out);
		displayInstruction.encode(out);
		if (FixUtils.getNoInGroup(trdgSesGrp)>0) {
			out.put(FixTags.NOTRADINGSESSIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdgSesGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTrdgSesGrp fixTrdgSesGrp : trdgSesGrp) if (fixTrdgSesGrp.hasGroup()) fixTrdgSesGrp.encode(out);
		instrument.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(legOrdGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(legOrdGrp));

			out.put(FixUtils.SOH);

		}
		for (FixLegOrdGrp fixLegOrdGrp : legOrdGrp) if (fixLegOrdGrp.hasGroup()) fixLegOrdGrp.encode(out);
		orderQtyData.encode(out);
		triggeringInstruction.encode(out);
		commissionData.encode(out);
		pegInstructions.encode(out);
		discretionInstructions.encode(out);
		if (FixUtils.getNoInGroup(strategyParametersGrp)>0) {
			out.put(FixTags.NOSTRATEGYPARAMETERS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(strategyParametersGrp));

			out.put(FixUtils.SOH);

		}
		for (FixStrategyParametersGrp fixStrategyParametersGrp : strategyParametersGrp) if (fixStrategyParametersGrp.hasGroup()) fixStrategyParametersGrp.encode(out);
		
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
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryClOrdID()) {		
			FixUtils.put(out,secondaryClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdLinkID()) {		
			FixUtils.put(out,clOrdLinkID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeOriginationDate()) {		
			FixUtils.put(out,tradeOriginationDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeDate()) {		
			FixUtils.put(out,tradeDate); 		
		
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
		
		if (hasCashMargin()) {		
			FixUtils.put(out,cashMargin); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingFeeIndicator()) {		
			FixUtils.put(out,clearingFeeIndicator); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHandlInst()) {		
			FixUtils.put(out,handlInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecInst()) {		
			FixUtils.put(out,execInst); 		
		
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
		
		if (hasExDestination()) {		
			FixUtils.put(out,exDestination); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExDestinationIDSource()) {		
			FixUtils.put(out,exDestinationIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasProcessCode()) {		
			FixUtils.put(out,processCode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPrevClosePx()) {		
			FixUtils.put(out, (long)prevClosePx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSwapPoints()) {		
			FixUtils.put(out, (long)swapPoints);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLocateReqd()) {		
			out.put(locateReqd?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQtyType()) {		
			FixUtils.put(out, (long)qtyType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdType()) {		
			FixUtils.put(out,ordType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMultilegModel()) {		
			FixUtils.put(out, (long)multilegModel);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMultilegPriceMethod()) {		
			FixUtils.put(out, (long)multilegPriceMethod);
		
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
		
		if (hasIOIID()) {		
			FixUtils.put(out,iOIID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteID()) {		
			FixUtils.put(out,quoteID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefOrderID()) {		
			FixUtils.put(out,refOrderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefOrderIDSource()) {		
			FixUtils.put(out,refOrderIDSource); 		
		
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
		
		if (hasGTBookingInst()) {		
			FixUtils.put(out, (long)gTBookingInst);
		
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
		
		if (hasForexReq()) {		
			out.put(forexReq?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrency()) {		
			FixUtils.put(out,settlCurrency); 		
		
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
		
		if (hasPositionEffect()) {		
			FixUtils.put(out,positionEffect); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCoveredOrUncovered()) {		
			FixUtils.put(out, (long)coveredOrUncovered);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaxShow()) {		
			FixUtils.put(out, (long)maxShow);
		
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
		
		if (hasRiskFreeRate()) {		
			FixUtils.put(out, (long)riskFreeRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasParticipationRate()) {		
			FixUtils.put(out, (long)participationRate);
		
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
		
		if (hasMultiLegRptTypeReq()) {		
			FixUtils.put(out, (long)multiLegRptTypeReq);
		
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
			
	public void crackSecondaryClOrdID() {		
		getSecondaryClOrdID();		
	}		
			
	public byte[] getSecondaryClOrdID() { 		
		if ( hasSecondaryClOrdID()) {		
			if (hasSecondaryClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryClOrdID; 		
			} else {

				buf.position(hasSecondaryClOrdID);

			FixUtils.getTagStringValue(buf, secondaryClOrdID, 0, secondaryClOrdID.length, err);
		
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
		if (hasSecondaryClOrdID()) FixUtils.fillNul(secondaryClOrdID);		
		FixUtils.copy(secondaryClOrdID, src); 		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryClOrdID(String str) {		
		if (str == null ) return;
		if (hasSecondaryClOrdID()) FixUtils.fillNul(secondaryClOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryClOrdID, src); 		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
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

			FixUtils.getTagStringValue(buf, clOrdLinkID, 0, clOrdLinkID.length, err);
		
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
		if (hasClOrdLinkID()) FixUtils.fillNul(clOrdLinkID);		
		FixUtils.copy(clOrdLinkID, src); 		
		hasClOrdLinkID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClOrdLinkID(String str) {		
		if (str == null ) return;
		if (hasClOrdLinkID()) FixUtils.fillNul(clOrdLinkID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clOrdLinkID, src); 		
		hasClOrdLinkID = FixUtils.TAG_HAS_VALUE;		
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

			FixUtils.getTagStringValue(buf, tradeOriginationDate, 0, tradeOriginationDate.length, err);
		
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
		if (hasTradeOriginationDate()) FixUtils.fillNul(tradeOriginationDate);		
		FixUtils.copy(tradeOriginationDate, src); 		
		hasTradeOriginationDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeOriginationDate(String str) {		
		if (str == null ) return;
		if (hasTradeOriginationDate()) FixUtils.fillNul(tradeOriginationDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeOriginationDate, src); 		
		hasTradeOriginationDate = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackAccount() {		
		getAccount();		
	}		
			
	public byte[] getAccount() { 		
		if ( hasAccount()) {		
			if (hasAccount == FixUtils.TAG_HAS_VALUE) {		
				return account; 		
			} else {

				buf.position(hasAccount);

			FixUtils.getTagStringValue(buf, account, 0, account.length, err);
		
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
		if (hasAccount()) FixUtils.fillNul(account);		
		FixUtils.copy(account, src); 		
		hasAccount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccount(String str) {		
		if (str == null ) return;
		if (hasAccount()) FixUtils.fillNul(account);		
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

			acctIDSource = FixUtils.getTagIntValue(buf, err);
		
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

			accountType = FixUtils.getTagIntValue(buf, err);
		
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

			dayBookingInst = FixUtils.getTagCharValue(buf, err);
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

			bookingUnit = FixUtils.getTagCharValue(buf, err);
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

			preallocMethod = FixUtils.getTagCharValue(buf, err);
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

			FixUtils.getTagStringValue(buf, allocID, 0, allocID.length, err);
		
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
		if (hasAllocID()) FixUtils.fillNul(allocID);		
		FixUtils.copy(allocID, src); 		
		hasAllocID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocID(String str) {		
		if (str == null ) return;
		if (hasAllocID()) FixUtils.fillNul(allocID);		
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
			
	public void crackCashMargin() {		
		getCashMargin();		
	}		
			
	public byte getCashMargin() { 		
		if ( hasCashMargin()) {		
			if (hasCashMargin == FixUtils.TAG_HAS_VALUE) {		
				return cashMargin; 		
			} else {

				buf.position(hasCashMargin);

			cashMargin = FixUtils.getTagCharValue(buf, err);
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

			FixUtils.getTagStringValue(buf, clearingFeeIndicator, 0, clearingFeeIndicator.length, err);
		
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
		if (hasClearingFeeIndicator()) FixUtils.fillNul(clearingFeeIndicator);		
		FixUtils.copy(clearingFeeIndicator, src); 		
		hasClearingFeeIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClearingFeeIndicator(String str) {		
		if (str == null ) return;
		if (hasClearingFeeIndicator()) FixUtils.fillNul(clearingFeeIndicator);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clearingFeeIndicator, src); 		
		hasClearingFeeIndicator = FixUtils.TAG_HAS_VALUE;		
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

			handlInst = FixUtils.getTagCharValue(buf, err);
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
			
	public void crackExecInst() {		
		getExecInst();		
	}		
			
	public byte[] getExecInst() { 		
		if ( hasExecInst()) {		
			if (hasExecInst == FixUtils.TAG_HAS_VALUE) {		
				return execInst; 		
			} else {

				buf.position(hasExecInst);

			FixUtils.getTagStringValue(buf, execInst, 0, execInst.length, err);
		
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
		if (hasExecInst()) FixUtils.fillNul(execInst);		
		FixUtils.copy(execInst, src); 		
		hasExecInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecInst(String str) {		
		if (str == null ) return;
		if (hasExecInst()) FixUtils.fillNul(execInst);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(execInst, src); 		
		hasExecInst = FixUtils.TAG_HAS_VALUE;		
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

			minQty = FixUtils.getTagFloatValue(buf, err);
		
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

			matchIncrement = FixUtils.getTagFloatValue(buf, err);
		
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

			maxPriceLevels = FixUtils.getTagIntValue(buf, err);
		
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

			maxFloor = FixUtils.getTagFloatValue(buf, err);
		
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
			
	public void crackExDestination() {		
		getExDestination();		
	}		
			
	public byte[] getExDestination() { 		
		if ( hasExDestination()) {		
			if (hasExDestination == FixUtils.TAG_HAS_VALUE) {		
				return exDestination; 		
			} else {

				buf.position(hasExDestination);

			FixUtils.getTagStringValue(buf, exDestination, 0, exDestination.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExDestination = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return exDestination;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExDestination() { return hasExDestination != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExDestination(byte[] src) {		
		if (src == null ) return;
		if (hasExDestination()) FixUtils.fillNul(exDestination);		
		FixUtils.copy(exDestination, src); 		
		hasExDestination = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExDestination(String str) {		
		if (str == null ) return;
		if (hasExDestination()) FixUtils.fillNul(exDestination);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(exDestination, src); 		
		hasExDestination = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExDestinationIDSource() {		
		getExDestinationIDSource();		
	}		
			
	public byte getExDestinationIDSource() { 		
		if ( hasExDestinationIDSource()) {		
			if (hasExDestinationIDSource == FixUtils.TAG_HAS_VALUE) {		
				return exDestinationIDSource; 		
			} else {

				buf.position(hasExDestinationIDSource);

			exDestinationIDSource = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (exDestinationIDSource != (byte)'D') && (exDestinationIDSource != (byte)'E') && (exDestinationIDSource != (byte)'G') && (exDestinationIDSource != (byte)'B') && (exDestinationIDSource != (byte)'C') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1133);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasExDestinationIDSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return exDestinationIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasExDestinationIDSource() { return hasExDestinationIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExDestinationIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasExDestinationIDSource()) exDestinationIDSource = (byte)' ';		
		exDestinationIDSource = src[0];		
		hasExDestinationIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExDestinationIDSource(byte src) {		
		exDestinationIDSource = src;
		hasExDestinationIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExDestinationIDSource(String str) {		
		if (str == null ) return;
		if (hasExDestinationIDSource()) exDestinationIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		exDestinationIDSource = src[0];		
		hasExDestinationIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackProcessCode() {		
		getProcessCode();		
	}		
			
	public byte getProcessCode() { 		
		if ( hasProcessCode()) {		
			if (hasProcessCode == FixUtils.TAG_HAS_VALUE) {		
				return processCode; 		
			} else {

				buf.position(hasProcessCode);

			processCode = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (processCode != (byte)'3') && (processCode != (byte)'2') && (processCode != (byte)'1') && (processCode != (byte)'0') && (processCode != (byte)'6') && (processCode != (byte)'5') && (processCode != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 81);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasProcessCode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return processCode;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasProcessCode() { return hasProcessCode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setProcessCode(byte[] src) {		
		if (src == null ) return;
		if (hasProcessCode()) processCode = (byte)' ';		
		processCode = src[0];		
		hasProcessCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProcessCode(byte src) {		
		processCode = src;
		hasProcessCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProcessCode(String str) {		
		if (str == null ) return;
		if (hasProcessCode()) processCode = (byte)' ';		
		byte[] src = str.getBytes(); 		
		processCode = src[0];		
		hasProcessCode = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackPrevClosePx() {		
		getPrevClosePx();		
	}		
			
	public long getPrevClosePx() { 		
		if ( hasPrevClosePx()) {		
			if (hasPrevClosePx == FixUtils.TAG_HAS_VALUE) {		
				return prevClosePx; 		
			} else {

				buf.position(hasPrevClosePx);

			prevClosePx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return prevClosePx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPrevClosePx() { return hasPrevClosePx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPrevClosePx(byte[] src) {		
		if (src == null ) return;
		if (hasPrevClosePx()) prevClosePx = FixUtils.TAG_HAS_NO_VALUE;		
		prevClosePx = FixUtils.longValueOf(src, 0, src.length);
		hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrevClosePx(long src) {		
		prevClosePx = src;
		hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrevClosePx(String str) {		
		if (str == null ) return;
		if (hasPrevClosePx()) prevClosePx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		prevClosePx = FixUtils.longValueOf(src, 0, src.length);
		hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSwapPoints() {		
		getSwapPoints();		
	}		
			
	public long getSwapPoints() { 		
		if ( hasSwapPoints()) {		
			if (hasSwapPoints == FixUtils.TAG_HAS_VALUE) {		
				return swapPoints; 		
			} else {

				buf.position(hasSwapPoints);

			swapPoints = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSwapPoints = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return swapPoints;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSwapPoints() { return hasSwapPoints != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSwapPoints(byte[] src) {		
		if (src == null ) return;
		if (hasSwapPoints()) swapPoints = FixUtils.TAG_HAS_NO_VALUE;		
		swapPoints = FixUtils.longValueOf(src, 0, src.length);
		hasSwapPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSwapPoints(long src) {		
		swapPoints = src;
		hasSwapPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSwapPoints(String str) {		
		if (str == null ) return;
		if (hasSwapPoints()) swapPoints = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		swapPoints = FixUtils.longValueOf(src, 0, src.length);
		hasSwapPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLocateReqd() {		
		getLocateReqd();		
	}		
			
	public boolean getLocateReqd() { 		
		if ( hasLocateReqd()) {		
			if (hasLocateReqd == FixUtils.TAG_HAS_VALUE) {		
				return locateReqd; 		
			} else {

				buf.position(hasLocateReqd);

			locateReqd = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasLocateReqd = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return locateReqd;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasLocateReqd() { return hasLocateReqd != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLocateReqd(byte[] src) {		
		if (src == null ) return;
		if (hasLocateReqd()) locateReqd = false;		
		locateReqd = src[0]==(byte)'Y'?true:false;		
		hasLocateReqd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLocateReqd(boolean src) {		
		locateReqd = src;
		hasLocateReqd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLocateReqd(String str) {		
		if (str == null ) return;
		if (hasLocateReqd()) locateReqd = false;		
		byte[] src = str.getBytes(); 		
		locateReqd = src[0]==(byte)'Y'?true:false;		
		hasLocateReqd = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackOrdType() {		
		getOrdType();		
	}		
			
	public byte getOrdType() { 		
		if ( hasOrdType()) {		
			if (hasOrdType == FixUtils.TAG_HAS_VALUE) {		
				return ordType; 		
			} else {

				buf.position(hasOrdType);

			ordType = FixUtils.getTagCharValue(buf, err);
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
			
	public void crackMultilegModel() {		
		getMultilegModel();		
	}		
			
	public long getMultilegModel() { 		
		if ( hasMultilegModel()) {		
			if (hasMultilegModel == FixUtils.TAG_HAS_VALUE) {		
				return multilegModel; 		
			} else {

				buf.position(hasMultilegModel);

			multilegModel = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMultilegModel = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return multilegModel;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMultilegModel() { return hasMultilegModel != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMultilegModel(byte[] src) {		
		if (src == null ) return;
		if (hasMultilegModel()) multilegModel = FixUtils.TAG_HAS_NO_VALUE;		
		multilegModel = FixUtils.longValueOf(src, 0, src.length);
		hasMultilegModel = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMultilegModel(long src) {		
		multilegModel = src;
		hasMultilegModel = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMultilegModel(String str) {		
		if (str == null ) return;
		if (hasMultilegModel()) multilegModel = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		multilegModel = FixUtils.longValueOf(src, 0, src.length);
		hasMultilegModel = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMultilegPriceMethod() {		
		getMultilegPriceMethod();		
	}		
			
	public long getMultilegPriceMethod() { 		
		if ( hasMultilegPriceMethod()) {		
			if (hasMultilegPriceMethod == FixUtils.TAG_HAS_VALUE) {		
				return multilegPriceMethod; 		
			} else {

				buf.position(hasMultilegPriceMethod);

			multilegPriceMethod = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMultilegPriceMethod = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return multilegPriceMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMultilegPriceMethod() { return hasMultilegPriceMethod != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMultilegPriceMethod(byte[] src) {		
		if (src == null ) return;
		if (hasMultilegPriceMethod()) multilegPriceMethod = FixUtils.TAG_HAS_NO_VALUE;		
		multilegPriceMethod = FixUtils.longValueOf(src, 0, src.length);
		hasMultilegPriceMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMultilegPriceMethod(long src) {		
		multilegPriceMethod = src;
		hasMultilegPriceMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMultilegPriceMethod(String str) {		
		if (str == null ) return;
		if (hasMultilegPriceMethod()) multilegPriceMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		multilegPriceMethod = FixUtils.longValueOf(src, 0, src.length);
		hasMultilegPriceMethod = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackPrice() {		
		getPrice();		
	}		
			
	public long getPrice() { 		
		if ( hasPrice()) {		
			if (hasPrice == FixUtils.TAG_HAS_VALUE) {		
				return price; 		
			} else {

				buf.position(hasPrice);

			price = FixUtils.getTagFloatValue(buf, err);
		
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

			priceProtectionScope = FixUtils.getTagCharValue(buf, err);
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

			stopPx = FixUtils.getTagFloatValue(buf, err);
		
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
			
	public void crackComplianceID() {		
		getComplianceID();		
	}		
			
	public byte[] getComplianceID() { 		
		if ( hasComplianceID()) {		
			if (hasComplianceID == FixUtils.TAG_HAS_VALUE) {		
				return complianceID; 		
			} else {

				buf.position(hasComplianceID);

			FixUtils.getTagStringValue(buf, complianceID, 0, complianceID.length, err);
		
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
		if (hasComplianceID()) FixUtils.fillNul(complianceID);		
		FixUtils.copy(complianceID, src); 		
		hasComplianceID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setComplianceID(String str) {		
		if (str == null ) return;
		if (hasComplianceID()) FixUtils.fillNul(complianceID);		
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

			solicitedFlag = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
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
			
	public void crackIOIID() {		
		getIOIID();		
	}		
			
	public byte[] getIOIID() { 		
		if ( hasIOIID()) {		
			if (hasIOIID == FixUtils.TAG_HAS_VALUE) {		
				return iOIID; 		
			} else {

				buf.position(hasIOIID);

			FixUtils.getTagStringValue(buf, iOIID, 0, iOIID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasIOIID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return iOIID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasIOIID() { return hasIOIID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setIOIID(byte[] src) {		
		if (src == null ) return;
		if (hasIOIID()) FixUtils.fillNul(iOIID);		
		FixUtils.copy(iOIID, src); 		
		hasIOIID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIOIID(String str) {		
		if (str == null ) return;
		if (hasIOIID()) FixUtils.fillNul(iOIID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(iOIID, src); 		
		hasIOIID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteID() {		
		getQuoteID();		
	}		
			
	public byte[] getQuoteID() { 		
		if ( hasQuoteID()) {		
			if (hasQuoteID == FixUtils.TAG_HAS_VALUE) {		
				return quoteID; 		
			} else {

				buf.position(hasQuoteID);

			FixUtils.getTagStringValue(buf, quoteID, 0, quoteID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasQuoteID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteID() { return hasQuoteID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteID()) FixUtils.fillNul(quoteID);		
		FixUtils.copy(quoteID, src); 		
		hasQuoteID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteID(String str) {		
		if (str == null ) return;
		if (hasQuoteID()) FixUtils.fillNul(quoteID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteID, src); 		
		hasQuoteID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRefOrderID() {		
		getRefOrderID();		
	}		
			
	public byte[] getRefOrderID() { 		
		if ( hasRefOrderID()) {		
			if (hasRefOrderID == FixUtils.TAG_HAS_VALUE) {		
				return refOrderID; 		
			} else {

				buf.position(hasRefOrderID);

			FixUtils.getTagStringValue(buf, refOrderID, 0, refOrderID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRefOrderID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return refOrderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefOrderID() { return hasRefOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRefOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasRefOrderID()) FixUtils.fillNul(refOrderID);		
		FixUtils.copy(refOrderID, src); 		
		hasRefOrderID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefOrderID(String str) {		
		if (str == null ) return;
		if (hasRefOrderID()) FixUtils.fillNul(refOrderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refOrderID, src); 		
		hasRefOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRefOrderIDSource() {		
		getRefOrderIDSource();		
	}		
			
	public byte getRefOrderIDSource() { 		
		if ( hasRefOrderIDSource()) {		
			if (hasRefOrderIDSource == FixUtils.TAG_HAS_VALUE) {		
				return refOrderIDSource; 		
			} else {

				buf.position(hasRefOrderIDSource);

			refOrderIDSource = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (refOrderIDSource != (byte)'3') && (refOrderIDSource != (byte)'2') && (refOrderIDSource != (byte)'1') && (refOrderIDSource != (byte)'0') && (refOrderIDSource != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1081);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasRefOrderIDSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return refOrderIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasRefOrderIDSource() { return hasRefOrderIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRefOrderIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasRefOrderIDSource()) refOrderIDSource = (byte)' ';		
		refOrderIDSource = src[0];		
		hasRefOrderIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefOrderIDSource(byte src) {		
		refOrderIDSource = src;
		hasRefOrderIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefOrderIDSource(String str) {		
		if (str == null ) return;
		if (hasRefOrderIDSource()) refOrderIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		refOrderIDSource = src[0];		
		hasRefOrderIDSource = FixUtils.TAG_HAS_VALUE;		
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

			timeInForce = FixUtils.getTagCharValue(buf, err);
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

			FixUtils.getTagStringValue(buf, effectiveTime, 0, effectiveTime.length, err);
		
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
		if (hasEffectiveTime()) FixUtils.fillNul(effectiveTime);		
		FixUtils.copy(effectiveTime, src); 		
		hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEffectiveTime(String str) {		
		if (str == null ) return;
		if (hasEffectiveTime()) FixUtils.fillNul(effectiveTime);		
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

			FixUtils.getTagStringValue(buf, expireDate, 0, expireDate.length, err);
		
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
		if (hasExpireDate()) FixUtils.fillNul(expireDate);		
		FixUtils.copy(expireDate, src); 		
		hasExpireDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExpireDate(String str) {		
		if (str == null ) return;
		if (hasExpireDate()) FixUtils.fillNul(expireDate);		
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

			FixUtils.getTagStringValue(buf, expireTime, 0, expireTime.length, err);
		
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
		if (hasExpireTime()) FixUtils.fillNul(expireTime);		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExpireTime(String str) {		
		if (str == null ) return;
		if (hasExpireTime()) FixUtils.fillNul(expireTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
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

			gTBookingInst = FixUtils.getTagIntValue(buf, err);
		
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
			
	public void crackOrderCapacity() {		
		getOrderCapacity();		
	}		
			
	public byte getOrderCapacity() { 		
		if ( hasOrderCapacity()) {		
			if (hasOrderCapacity == FixUtils.TAG_HAS_VALUE) {		
				return orderCapacity; 		
			} else {

				buf.position(hasOrderCapacity);

			orderCapacity = FixUtils.getTagCharValue(buf, err);
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

			FixUtils.getTagStringValue(buf, orderRestrictions, 0, orderRestrictions.length, err);
		
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
		if (hasOrderRestrictions()) FixUtils.fillNul(orderRestrictions);		
		FixUtils.copy(orderRestrictions, src); 		
		hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderRestrictions(String str) {		
		if (str == null ) return;
		if (hasOrderRestrictions()) FixUtils.fillNul(orderRestrictions);		
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
			
	public void crackCustOrderCapacity() {		
		getCustOrderCapacity();		
	}		
			
	public long getCustOrderCapacity() { 		
		if ( hasCustOrderCapacity()) {		
			if (hasCustOrderCapacity == FixUtils.TAG_HAS_VALUE) {		
				return custOrderCapacity; 		
			} else {

				buf.position(hasCustOrderCapacity);

			custOrderCapacity = FixUtils.getTagIntValue(buf, err);
		
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
			
	public void crackForexReq() {		
		getForexReq();		
	}		
			
	public boolean getForexReq() { 		
		if ( hasForexReq()) {		
			if (hasForexReq == FixUtils.TAG_HAS_VALUE) {		
				return forexReq; 		
			} else {

				buf.position(hasForexReq);

			forexReq = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasForexReq = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return forexReq;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasForexReq() { return hasForexReq != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setForexReq(byte[] src) {		
		if (src == null ) return;
		if (hasForexReq()) forexReq = false;		
		forexReq = src[0]==(byte)'Y'?true:false;		
		hasForexReq = FixUtils.TAG_HAS_VALUE;		
	}

	public void setForexReq(boolean src) {		
		forexReq = src;
		hasForexReq = FixUtils.TAG_HAS_VALUE;		
	}

	public void setForexReq(String str) {		
		if (str == null ) return;
		if (hasForexReq()) forexReq = false;		
		byte[] src = str.getBytes(); 		
		forexReq = src[0]==(byte)'Y'?true:false;		
		hasForexReq = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackBookingType() {		
		getBookingType();		
	}		
			
	public long getBookingType() { 		
		if ( hasBookingType()) {		
			if (hasBookingType == FixUtils.TAG_HAS_VALUE) {		
				return bookingType; 		
			} else {

				buf.position(hasBookingType);

			bookingType = FixUtils.getTagIntValue(buf, err);
		
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
			
	public void crackPositionEffect() {		
		getPositionEffect();		
	}		
			
	public byte getPositionEffect() { 		
		if ( hasPositionEffect()) {		
			if (hasPositionEffect == FixUtils.TAG_HAS_VALUE) {		
				return positionEffect; 		
			} else {

				buf.position(hasPositionEffect);

			positionEffect = FixUtils.getTagCharValue(buf, err);
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
			
	public void crackCoveredOrUncovered() {		
		getCoveredOrUncovered();		
	}		
			
	public long getCoveredOrUncovered() { 		
		if ( hasCoveredOrUncovered()) {		
			if (hasCoveredOrUncovered == FixUtils.TAG_HAS_VALUE) {		
				return coveredOrUncovered; 		
			} else {

				buf.position(hasCoveredOrUncovered);

			coveredOrUncovered = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCoveredOrUncovered = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return coveredOrUncovered;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCoveredOrUncovered() { return hasCoveredOrUncovered != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCoveredOrUncovered(byte[] src) {		
		if (src == null ) return;
		if (hasCoveredOrUncovered()) coveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;		
		coveredOrUncovered = FixUtils.longValueOf(src, 0, src.length);
		hasCoveredOrUncovered = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCoveredOrUncovered(long src) {		
		coveredOrUncovered = src;
		hasCoveredOrUncovered = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCoveredOrUncovered(String str) {		
		if (str == null ) return;
		if (hasCoveredOrUncovered()) coveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		coveredOrUncovered = FixUtils.longValueOf(src, 0, src.length);
		hasCoveredOrUncovered = FixUtils.TAG_HAS_VALUE;		
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

			maxShow = FixUtils.getTagFloatValue(buf, err);
		
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
			
	public void crackTargetStrategy() {		
		getTargetStrategy();		
	}		
			
	public long getTargetStrategy() { 		
		if ( hasTargetStrategy()) {		
			if (hasTargetStrategy == FixUtils.TAG_HAS_VALUE) {		
				return targetStrategy; 		
			} else {

				buf.position(hasTargetStrategy);

			targetStrategy = FixUtils.getTagIntValue(buf, err);
		
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

			FixUtils.getTagStringValue(buf, targetStrategyParameters, 0, targetStrategyParameters.length, err);
		
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
		if (hasTargetStrategyParameters()) FixUtils.fillNul(targetStrategyParameters);		
		FixUtils.copy(targetStrategyParameters, src); 		
		hasTargetStrategyParameters = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTargetStrategyParameters(String str) {		
		if (str == null ) return;
		if (hasTargetStrategyParameters()) FixUtils.fillNul(targetStrategyParameters);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(targetStrategyParameters, src); 		
		hasTargetStrategyParameters = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackParticipationRate() {		
		getParticipationRate();		
	}		
			
	public long getParticipationRate() { 		
		if ( hasParticipationRate()) {		
			if (hasParticipationRate == FixUtils.TAG_HAS_VALUE) {		
				return participationRate; 		
			} else {

				buf.position(hasParticipationRate);

			participationRate = FixUtils.getTagFloatValue(buf, err);
		
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
			
	public void crackCancellationRights() {		
		getCancellationRights();		
	}		
			
	public byte getCancellationRights() { 		
		if ( hasCancellationRights()) {		
			if (hasCancellationRights == FixUtils.TAG_HAS_VALUE) {		
				return cancellationRights; 		
			} else {

				buf.position(hasCancellationRights);

			cancellationRights = FixUtils.getTagCharValue(buf, err);
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

			moneyLaunderingStatus = FixUtils.getTagCharValue(buf, err);
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

			FixUtils.getTagStringValue(buf, registID, 0, registID.length, err);
		
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
		if (hasRegistID()) FixUtils.fillNul(registID);		
		FixUtils.copy(registID, src); 		
		hasRegistID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistID(String str) {		
		if (str == null ) return;
		if (hasRegistID()) FixUtils.fillNul(registID);		
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

			FixUtils.getTagStringValue(buf, designation, 0, designation.length, err);
		
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
		if (hasDesignation()) FixUtils.fillNul(designation);		
		FixUtils.copy(designation, src); 		
		hasDesignation = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDesignation(String str) {		
		if (str == null ) return;
		if (hasDesignation()) FixUtils.fillNul(designation);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(designation, src); 		
		hasDesignation = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMultiLegRptTypeReq() {		
		getMultiLegRptTypeReq();		
	}		
			
	public long getMultiLegRptTypeReq() { 		
		if ( hasMultiLegRptTypeReq()) {		
			if (hasMultiLegRptTypeReq == FixUtils.TAG_HAS_VALUE) {		
				return multiLegRptTypeReq; 		
			} else {

				buf.position(hasMultiLegRptTypeReq);

			multiLegRptTypeReq = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMultiLegRptTypeReq = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return multiLegRptTypeReq;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMultiLegRptTypeReq() { return hasMultiLegRptTypeReq != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMultiLegRptTypeReq(byte[] src) {		
		if (src == null ) return;
		if (hasMultiLegRptTypeReq()) multiLegRptTypeReq = FixUtils.TAG_HAS_NO_VALUE;		
		multiLegRptTypeReq = FixUtils.longValueOf(src, 0, src.length);
		hasMultiLegRptTypeReq = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMultiLegRptTypeReq(long src) {		
		multiLegRptTypeReq = src;
		hasMultiLegRptTypeReq = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMultiLegRptTypeReq(String str) {		
		if (str == null ) return;
		if (hasMultiLegRptTypeReq()) multiLegRptTypeReq = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		multiLegRptTypeReq = FixUtils.longValueOf(src, 0, src.length);
		hasMultiLegRptTypeReq = FixUtils.TAG_HAS_VALUE;		
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

					if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasSecondaryClOrdID()) s += "SecondaryClOrdID(526)= " + new String( FixUtils.trim(getSecondaryClOrdID()) ) + "\n" ; 
		if (hasClOrdLinkID()) s += "ClOrdLinkID(583)= " + new String( FixUtils.trim(getClOrdLinkID()) ) + "\n" ; 
		if (hasTradeOriginationDate()) s += "TradeOriginationDate(229)= " + new String( FixUtils.trim(getTradeOriginationDate()) ) + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAcctIDSource()) s += "AcctIDSource(660)= " + getAcctIDSource() + "\n" ; 
		if (hasAccountType()) s += "AccountType(581)= " + getAccountType() + "\n" ; 
		if (hasDayBookingInst()) s += "DayBookingInst(589)= " + getDayBookingInst() + "\n" ; 
		if (hasBookingUnit()) s += "BookingUnit(590)= " + getBookingUnit() + "\n" ; 
		if (hasPreallocMethod()) s += "PreallocMethod(591)= " + getPreallocMethod() + "\n" ; 
		if (hasAllocID()) s += "AllocID(70)= " + new String( FixUtils.trim(getAllocID()) ) + "\n" ; 
		if (hasSettlType()) s += "SettlType(63)= " + new String( FixUtils.trim(getSettlType()) ) + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasCashMargin()) s += "CashMargin(544)= " + getCashMargin() + "\n" ; 
		if (hasClearingFeeIndicator()) s += "ClearingFeeIndicator(635)= " + new String( FixUtils.trim(getClearingFeeIndicator()) ) + "\n" ; 
		if (hasHandlInst()) s += "HandlInst(21)= " + getHandlInst() + "\n" ; 
		if (hasExecInst()) s += "ExecInst(18)= " + new String( FixUtils.trim(getExecInst()) ) + "\n" ; 
		if (hasMinQty()) s += "MinQty(110)= " + getMinQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMatchIncrement()) s += "MatchIncrement(1089)= " + getMatchIncrement() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMaxPriceLevels()) s += "MaxPriceLevels(1090)= " + getMaxPriceLevels() + "\n" ; 
		if (hasMaxFloor()) s += "MaxFloor(111)= " + getMaxFloor() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasExDestination()) s += "ExDestination(100)= " + new String( FixUtils.trim(getExDestination()) ) + "\n" ; 
		if (hasExDestinationIDSource()) s += "ExDestinationIDSource(1133)= " + getExDestinationIDSource() + "\n" ; 
		if (hasProcessCode()) s += "ProcessCode(81)= " + getProcessCode() + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasPrevClosePx()) s += "PrevClosePx(140)= " + getPrevClosePx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSwapPoints()) s += "SwapPoints(1069)= " + getSwapPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLocateReqd()) s += "LocateReqd(114)= " + getLocateReqd() + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasQtyType()) s += "QtyType(854)= " + getQtyType() + "\n" ; 
		if (hasOrdType()) s += "OrdType(40)= " + getOrdType() + "\n" ; 
		if (hasMultilegModel()) s += "MultilegModel(1377)= " + getMultilegModel() + "\n" ; 
		if (hasMultilegPriceMethod()) s += "MultilegPriceMethod(1378)= " + getMultilegPriceMethod() + "\n" ; 
		if (hasPriceType()) s += "PriceType(423)= " + getPriceType() + "\n" ; 
		if (hasPrice()) s += "Price(44)= " + getPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPriceProtectionScope()) s += "PriceProtectionScope(1092)= " + getPriceProtectionScope() + "\n" ; 
		if (hasStopPx()) s += "StopPx(99)= " + getStopPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasComplianceID()) s += "ComplianceID(376)= " + new String( FixUtils.trim(getComplianceID()) ) + "\n" ; 
		if (hasSolicitedFlag()) s += "SolicitedFlag(377)= " + getSolicitedFlag() + "\n" ; 
		if (hasIOIID()) s += "IOIID(23)= " + new String( FixUtils.trim(getIOIID()) ) + "\n" ; 
		if (hasQuoteID()) s += "QuoteID(117)= " + new String( FixUtils.trim(getQuoteID()) ) + "\n" ; 
		if (hasRefOrderID()) s += "RefOrderID(1080)= " + new String( FixUtils.trim(getRefOrderID()) ) + "\n" ; 
		if (hasRefOrderIDSource()) s += "RefOrderIDSource(1081)= " + getRefOrderIDSource() + "\n" ; 
		if (hasTimeInForce()) s += "TimeInForce(59)= " + getTimeInForce() + "\n" ; 
		if (hasEffectiveTime()) s += "EffectiveTime(168)= " + new String( FixUtils.trim(getEffectiveTime()) ) + "\n" ; 
		if (hasExpireDate()) s += "ExpireDate(432)= " + new String( FixUtils.trim(getExpireDate()) ) + "\n" ; 
		if (hasExpireTime()) s += "ExpireTime(126)= " + new String( FixUtils.trim(getExpireTime()) ) + "\n" ; 
		if (hasGTBookingInst()) s += "GTBookingInst(427)= " + getGTBookingInst() + "\n" ; 
		if (hasOrderCapacity()) s += "OrderCapacity(528)= " + getOrderCapacity() + "\n" ; 
		if (hasOrderRestrictions()) s += "OrderRestrictions(529)= " + new String( FixUtils.trim(getOrderRestrictions()) ) + "\n" ; 
		if (hasPreTradeAnonymity()) s += "PreTradeAnonymity(1091)= " + getPreTradeAnonymity() + "\n" ; 
		if (hasCustOrderCapacity()) s += "CustOrderCapacity(582)= " + getCustOrderCapacity() + "\n" ; 
		if (hasForexReq()) s += "ForexReq(121)= " + getForexReq() + "\n" ; 
		if (hasSettlCurrency()) s += "SettlCurrency(120)= " + new String( FixUtils.trim(getSettlCurrency()) ) + "\n" ; 
		if (hasBookingType()) s += "BookingType(775)= " + getBookingType() + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasPositionEffect()) s += "PositionEffect(77)= " + getPositionEffect() + "\n" ; 
		if (hasCoveredOrUncovered()) s += "CoveredOrUncovered(203)= " + getCoveredOrUncovered() + "\n" ; 
		if (hasMaxShow()) s += "MaxShow(210)= " + getMaxShow() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTargetStrategy()) s += "TargetStrategy(847)= " + getTargetStrategy() + "\n" ; 
		if (hasTargetStrategyParameters()) s += "TargetStrategyParameters(848)= " + new String( FixUtils.trim(getTargetStrategyParameters()) ) + "\n" ; 
		if (hasRiskFreeRate()) s += "RiskFreeRate(1190)= " + getRiskFreeRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasParticipationRate()) s += "ParticipationRate(849)= " + getParticipationRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCancellationRights()) s += "CancellationRights(480)= " + getCancellationRights() + "\n" ; 
		if (hasMoneyLaunderingStatus()) s += "MoneyLaunderingStatus(481)= " + getMoneyLaunderingStatus() + "\n" ; 
		if (hasRegistID()) s += "RegistID(513)= " + new String( FixUtils.trim(getRegistID()) ) + "\n" ; 
		if (hasDesignation()) s += "Designation(494)= " + new String( FixUtils.trim(getDesignation()) ) + "\n" ; 
		if (hasMultiLegRptTypeReq()) s += "MultiLegRptTypeReq(563)= " + getMultiLegRptTypeReq() + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNewOrderMultileg)) return false;

		FixNewOrderMultileg msg = (FixNewOrderMultileg) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) || (!hasSecondaryClOrdID() && msg.hasSecondaryClOrdID())) return false;
		if (!(!hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) && !FixUtils.equals(getSecondaryClOrdID(), msg.getSecondaryClOrdID())) return false;
		if ((hasClOrdLinkID() && !msg.hasClOrdLinkID()) || (!hasClOrdLinkID() && msg.hasClOrdLinkID())) return false;
		if (!(!hasClOrdLinkID() && !msg.hasClOrdLinkID()) && !FixUtils.equals(getClOrdLinkID(), msg.getClOrdLinkID())) return false;
		if ((hasTradeOriginationDate() && !msg.hasTradeOriginationDate()) || (!hasTradeOriginationDate() && msg.hasTradeOriginationDate())) return false;
		if ((hasTradeDate() && !msg.hasTradeDate()) || (!hasTradeDate() && msg.hasTradeDate())) return false;
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
		if ((hasCashMargin() && !msg.hasCashMargin()) || (!hasCashMargin() && msg.hasCashMargin())) return false;
		if (!(!hasCashMargin() && !msg.hasCashMargin()) && !(getCashMargin()==msg.getCashMargin())) return false;
		if ((hasClearingFeeIndicator() && !msg.hasClearingFeeIndicator()) || (!hasClearingFeeIndicator() && msg.hasClearingFeeIndicator())) return false;
		if (!(!hasClearingFeeIndicator() && !msg.hasClearingFeeIndicator()) && !FixUtils.equals(getClearingFeeIndicator(), msg.getClearingFeeIndicator())) return false;
		if ((hasHandlInst() && !msg.hasHandlInst()) || (!hasHandlInst() && msg.hasHandlInst())) return false;
		if (!(!hasHandlInst() && !msg.hasHandlInst()) && !(getHandlInst()==msg.getHandlInst())) return false;
		if ((hasExecInst() && !msg.hasExecInst()) || (!hasExecInst() && msg.hasExecInst())) return false;
		if (!(!hasExecInst() && !msg.hasExecInst()) && !FixUtils.equals(getExecInst(), msg.getExecInst())) return false;
		if ((hasMinQty() && !msg.hasMinQty()) || (!hasMinQty() && msg.hasMinQty())) return false;
		if (!(!hasMinQty() && !msg.hasMinQty()) && !(getMinQty()==msg.getMinQty())) return false;
		if ((hasMatchIncrement() && !msg.hasMatchIncrement()) || (!hasMatchIncrement() && msg.hasMatchIncrement())) return false;
		if (!(!hasMatchIncrement() && !msg.hasMatchIncrement()) && !(getMatchIncrement()==msg.getMatchIncrement())) return false;
		if ((hasMaxPriceLevels() && !msg.hasMaxPriceLevels()) || (!hasMaxPriceLevels() && msg.hasMaxPriceLevels())) return false;
		if (!(!hasMaxPriceLevels() && !msg.hasMaxPriceLevels()) && !(getMaxPriceLevels()==msg.getMaxPriceLevels())) return false;
		if ((hasMaxFloor() && !msg.hasMaxFloor()) || (!hasMaxFloor() && msg.hasMaxFloor())) return false;
		if (!(!hasMaxFloor() && !msg.hasMaxFloor()) && !(getMaxFloor()==msg.getMaxFloor())) return false;
		if ((hasExDestination() && !msg.hasExDestination()) || (!hasExDestination() && msg.hasExDestination())) return false;
		if (!(!hasExDestination() && !msg.hasExDestination()) && !FixUtils.equals(getExDestination(), msg.getExDestination())) return false;
		if ((hasExDestinationIDSource() && !msg.hasExDestinationIDSource()) || (!hasExDestinationIDSource() && msg.hasExDestinationIDSource())) return false;
		if (!(!hasExDestinationIDSource() && !msg.hasExDestinationIDSource()) && !(getExDestinationIDSource()==msg.getExDestinationIDSource())) return false;
		if ((hasProcessCode() && !msg.hasProcessCode()) || (!hasProcessCode() && msg.hasProcessCode())) return false;
		if (!(!hasProcessCode() && !msg.hasProcessCode()) && !(getProcessCode()==msg.getProcessCode())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasPrevClosePx() && !msg.hasPrevClosePx()) || (!hasPrevClosePx() && msg.hasPrevClosePx())) return false;
		if (!(!hasPrevClosePx() && !msg.hasPrevClosePx()) && !(getPrevClosePx()==msg.getPrevClosePx())) return false;
		if ((hasSwapPoints() && !msg.hasSwapPoints()) || (!hasSwapPoints() && msg.hasSwapPoints())) return false;
		if (!(!hasSwapPoints() && !msg.hasSwapPoints()) && !(getSwapPoints()==msg.getSwapPoints())) return false;
		if ((hasLocateReqd() && !msg.hasLocateReqd()) || (!hasLocateReqd() && msg.hasLocateReqd())) return false;
		if (!(!hasLocateReqd() && !msg.hasLocateReqd()) && !(getLocateReqd()==msg.getLocateReqd())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasQtyType() && !msg.hasQtyType()) || (!hasQtyType() && msg.hasQtyType())) return false;
		if (!(!hasQtyType() && !msg.hasQtyType()) && !(getQtyType()==msg.getQtyType())) return false;
		if ((hasOrdType() && !msg.hasOrdType()) || (!hasOrdType() && msg.hasOrdType())) return false;
		if (!(!hasOrdType() && !msg.hasOrdType()) && !(getOrdType()==msg.getOrdType())) return false;
		if ((hasMultilegModel() && !msg.hasMultilegModel()) || (!hasMultilegModel() && msg.hasMultilegModel())) return false;
		if (!(!hasMultilegModel() && !msg.hasMultilegModel()) && !(getMultilegModel()==msg.getMultilegModel())) return false;
		if ((hasMultilegPriceMethod() && !msg.hasMultilegPriceMethod()) || (!hasMultilegPriceMethod() && msg.hasMultilegPriceMethod())) return false;
		if (!(!hasMultilegPriceMethod() && !msg.hasMultilegPriceMethod()) && !(getMultilegPriceMethod()==msg.getMultilegPriceMethod())) return false;
		if ((hasPriceType() && !msg.hasPriceType()) || (!hasPriceType() && msg.hasPriceType())) return false;
		if (!(!hasPriceType() && !msg.hasPriceType()) && !(getPriceType()==msg.getPriceType())) return false;
		if ((hasPrice() && !msg.hasPrice()) || (!hasPrice() && msg.hasPrice())) return false;
		if (!(!hasPrice() && !msg.hasPrice()) && !(getPrice()==msg.getPrice())) return false;
		if ((hasPriceProtectionScope() && !msg.hasPriceProtectionScope()) || (!hasPriceProtectionScope() && msg.hasPriceProtectionScope())) return false;
		if (!(!hasPriceProtectionScope() && !msg.hasPriceProtectionScope()) && !(getPriceProtectionScope()==msg.getPriceProtectionScope())) return false;
		if ((hasStopPx() && !msg.hasStopPx()) || (!hasStopPx() && msg.hasStopPx())) return false;
		if (!(!hasStopPx() && !msg.hasStopPx()) && !(getStopPx()==msg.getStopPx())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasComplianceID() && !msg.hasComplianceID()) || (!hasComplianceID() && msg.hasComplianceID())) return false;
		if (!(!hasComplianceID() && !msg.hasComplianceID()) && !FixUtils.equals(getComplianceID(), msg.getComplianceID())) return false;
		if ((hasSolicitedFlag() && !msg.hasSolicitedFlag()) || (!hasSolicitedFlag() && msg.hasSolicitedFlag())) return false;
		if (!(!hasSolicitedFlag() && !msg.hasSolicitedFlag()) && !(getSolicitedFlag()==msg.getSolicitedFlag())) return false;
		if ((hasIOIID() && !msg.hasIOIID()) || (!hasIOIID() && msg.hasIOIID())) return false;
		if (!(!hasIOIID() && !msg.hasIOIID()) && !FixUtils.equals(getIOIID(), msg.getIOIID())) return false;
		if ((hasQuoteID() && !msg.hasQuoteID()) || (!hasQuoteID() && msg.hasQuoteID())) return false;
		if (!(!hasQuoteID() && !msg.hasQuoteID()) && !FixUtils.equals(getQuoteID(), msg.getQuoteID())) return false;
		if ((hasRefOrderID() && !msg.hasRefOrderID()) || (!hasRefOrderID() && msg.hasRefOrderID())) return false;
		if (!(!hasRefOrderID() && !msg.hasRefOrderID()) && !FixUtils.equals(getRefOrderID(), msg.getRefOrderID())) return false;
		if ((hasRefOrderIDSource() && !msg.hasRefOrderIDSource()) || (!hasRefOrderIDSource() && msg.hasRefOrderIDSource())) return false;
		if (!(!hasRefOrderIDSource() && !msg.hasRefOrderIDSource()) && !(getRefOrderIDSource()==msg.getRefOrderIDSource())) return false;
		if ((hasTimeInForce() && !msg.hasTimeInForce()) || (!hasTimeInForce() && msg.hasTimeInForce())) return false;
		if (!(!hasTimeInForce() && !msg.hasTimeInForce()) && !(getTimeInForce()==msg.getTimeInForce())) return false;
		if ((hasEffectiveTime() && !msg.hasEffectiveTime()) || (!hasEffectiveTime() && msg.hasEffectiveTime())) return false;
		if ((hasExpireDate() && !msg.hasExpireDate()) || (!hasExpireDate() && msg.hasExpireDate())) return false;
		if ((hasExpireTime() && !msg.hasExpireTime()) || (!hasExpireTime() && msg.hasExpireTime())) return false;
		if ((hasGTBookingInst() && !msg.hasGTBookingInst()) || (!hasGTBookingInst() && msg.hasGTBookingInst())) return false;
		if (!(!hasGTBookingInst() && !msg.hasGTBookingInst()) && !(getGTBookingInst()==msg.getGTBookingInst())) return false;
		if ((hasOrderCapacity() && !msg.hasOrderCapacity()) || (!hasOrderCapacity() && msg.hasOrderCapacity())) return false;
		if (!(!hasOrderCapacity() && !msg.hasOrderCapacity()) && !(getOrderCapacity()==msg.getOrderCapacity())) return false;
		if ((hasOrderRestrictions() && !msg.hasOrderRestrictions()) || (!hasOrderRestrictions() && msg.hasOrderRestrictions())) return false;
		if (!(!hasOrderRestrictions() && !msg.hasOrderRestrictions()) && !FixUtils.equals(getOrderRestrictions(), msg.getOrderRestrictions())) return false;
		if ((hasPreTradeAnonymity() && !msg.hasPreTradeAnonymity()) || (!hasPreTradeAnonymity() && msg.hasPreTradeAnonymity())) return false;
		if (!(!hasPreTradeAnonymity() && !msg.hasPreTradeAnonymity()) && !(getPreTradeAnonymity()==msg.getPreTradeAnonymity())) return false;
		if ((hasCustOrderCapacity() && !msg.hasCustOrderCapacity()) || (!hasCustOrderCapacity() && msg.hasCustOrderCapacity())) return false;
		if (!(!hasCustOrderCapacity() && !msg.hasCustOrderCapacity()) && !(getCustOrderCapacity()==msg.getCustOrderCapacity())) return false;
		if ((hasForexReq() && !msg.hasForexReq()) || (!hasForexReq() && msg.hasForexReq())) return false;
		if (!(!hasForexReq() && !msg.hasForexReq()) && !(getForexReq()==msg.getForexReq())) return false;
		if ((hasSettlCurrency() && !msg.hasSettlCurrency()) || (!hasSettlCurrency() && msg.hasSettlCurrency())) return false;
		if (!(!hasSettlCurrency() && !msg.hasSettlCurrency()) && !FixUtils.equals(getSettlCurrency(), msg.getSettlCurrency())) return false;
		if ((hasBookingType() && !msg.hasBookingType()) || (!hasBookingType() && msg.hasBookingType())) return false;
		if (!(!hasBookingType() && !msg.hasBookingType()) && !(getBookingType()==msg.getBookingType())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasPositionEffect() && !msg.hasPositionEffect()) || (!hasPositionEffect() && msg.hasPositionEffect())) return false;
		if (!(!hasPositionEffect() && !msg.hasPositionEffect()) && !(getPositionEffect()==msg.getPositionEffect())) return false;
		if ((hasCoveredOrUncovered() && !msg.hasCoveredOrUncovered()) || (!hasCoveredOrUncovered() && msg.hasCoveredOrUncovered())) return false;
		if (!(!hasCoveredOrUncovered() && !msg.hasCoveredOrUncovered()) && !(getCoveredOrUncovered()==msg.getCoveredOrUncovered())) return false;
		if ((hasMaxShow() && !msg.hasMaxShow()) || (!hasMaxShow() && msg.hasMaxShow())) return false;
		if (!(!hasMaxShow() && !msg.hasMaxShow()) && !(getMaxShow()==msg.getMaxShow())) return false;
		if ((hasTargetStrategy() && !msg.hasTargetStrategy()) || (!hasTargetStrategy() && msg.hasTargetStrategy())) return false;
		if (!(!hasTargetStrategy() && !msg.hasTargetStrategy()) && !(getTargetStrategy()==msg.getTargetStrategy())) return false;
		if ((hasTargetStrategyParameters() && !msg.hasTargetStrategyParameters()) || (!hasTargetStrategyParameters() && msg.hasTargetStrategyParameters())) return false;
		if (!(!hasTargetStrategyParameters() && !msg.hasTargetStrategyParameters()) && !FixUtils.equals(getTargetStrategyParameters(), msg.getTargetStrategyParameters())) return false;
		if ((hasRiskFreeRate() && !msg.hasRiskFreeRate()) || (!hasRiskFreeRate() && msg.hasRiskFreeRate())) return false;
		if (!(!hasRiskFreeRate() && !msg.hasRiskFreeRate()) && !(getRiskFreeRate()==msg.getRiskFreeRate())) return false;
		if ((hasParticipationRate() && !msg.hasParticipationRate()) || (!hasParticipationRate() && msg.hasParticipationRate())) return false;
		if (!(!hasParticipationRate() && !msg.hasParticipationRate()) && !(getParticipationRate()==msg.getParticipationRate())) return false;
		if ((hasCancellationRights() && !msg.hasCancellationRights()) || (!hasCancellationRights() && msg.hasCancellationRights())) return false;
		if (!(!hasCancellationRights() && !msg.hasCancellationRights()) && !(getCancellationRights()==msg.getCancellationRights())) return false;
		if ((hasMoneyLaunderingStatus() && !msg.hasMoneyLaunderingStatus()) || (!hasMoneyLaunderingStatus() && msg.hasMoneyLaunderingStatus())) return false;
		if (!(!hasMoneyLaunderingStatus() && !msg.hasMoneyLaunderingStatus()) && !(getMoneyLaunderingStatus()==msg.getMoneyLaunderingStatus())) return false;
		if ((hasRegistID() && !msg.hasRegistID()) || (!hasRegistID() && msg.hasRegistID())) return false;
		if (!(!hasRegistID() && !msg.hasRegistID()) && !FixUtils.equals(getRegistID(), msg.getRegistID())) return false;
		if ((hasDesignation() && !msg.hasDesignation()) || (!hasDesignation() && msg.hasDesignation())) return false;
		if (!(!hasDesignation() && !msg.hasDesignation()) && !FixUtils.equals(getDesignation(), msg.getDesignation())) return false;
		if ((hasMultiLegRptTypeReq() && !msg.hasMultiLegRptTypeReq()) || (!hasMultiLegRptTypeReq() && msg.hasMultiLegRptTypeReq())) return false;
		if (!(!hasMultiLegRptTypeReq() && !msg.hasMultiLegRptTypeReq()) && !(getMultiLegRptTypeReq()==msg.getMultiLegRptTypeReq())) return false;
		return true;
	}
	@Override
	public FixNewOrderMultileg clone () {
		FixNewOrderMultileg out = new FixNewOrderMultileg();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixNewOrderMultileg clone ( FixNewOrderMultileg out ) {
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasSecondaryClOrdID())
			out.setSecondaryClOrdID(getSecondaryClOrdID());
		if ( hasClOrdLinkID())
			out.setClOrdLinkID(getClOrdLinkID());
		if ( hasTradeOriginationDate())
			out.setTradeOriginationDate(getTradeOriginationDate());
		if ( hasTradeDate())
			out.setTradeDate(getTradeDate());
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
		if ( hasCashMargin())
			out.setCashMargin(getCashMargin());
		if ( hasClearingFeeIndicator())
			out.setClearingFeeIndicator(getClearingFeeIndicator());
		if ( hasHandlInst())
			out.setHandlInst(getHandlInst());
		if ( hasExecInst())
			out.setExecInst(getExecInst());
		if ( hasMinQty())
			out.setMinQty(getMinQty());
		if ( hasMatchIncrement())
			out.setMatchIncrement(getMatchIncrement());
		if ( hasMaxPriceLevels())
			out.setMaxPriceLevels(getMaxPriceLevels());
		if ( hasMaxFloor())
			out.setMaxFloor(getMaxFloor());
		if ( hasExDestination())
			out.setExDestination(getExDestination());
		if ( hasExDestinationIDSource())
			out.setExDestinationIDSource(getExDestinationIDSource());
		if ( hasProcessCode())
			out.setProcessCode(getProcessCode());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasPrevClosePx())
			out.setPrevClosePx(getPrevClosePx());
		if ( hasSwapPoints())
			out.setSwapPoints(getSwapPoints());
		if ( hasLocateReqd())
			out.setLocateReqd(getLocateReqd());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasQtyType())
			out.setQtyType(getQtyType());
		if ( hasOrdType())
			out.setOrdType(getOrdType());
		if ( hasMultilegModel())
			out.setMultilegModel(getMultilegModel());
		if ( hasMultilegPriceMethod())
			out.setMultilegPriceMethod(getMultilegPriceMethod());
		if ( hasPriceType())
			out.setPriceType(getPriceType());
		if ( hasPrice())
			out.setPrice(getPrice());
		if ( hasPriceProtectionScope())
			out.setPriceProtectionScope(getPriceProtectionScope());
		if ( hasStopPx())
			out.setStopPx(getStopPx());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasComplianceID())
			out.setComplianceID(getComplianceID());
		if ( hasSolicitedFlag())
			out.setSolicitedFlag(getSolicitedFlag());
		if ( hasIOIID())
			out.setIOIID(getIOIID());
		if ( hasQuoteID())
			out.setQuoteID(getQuoteID());
		if ( hasRefOrderID())
			out.setRefOrderID(getRefOrderID());
		if ( hasRefOrderIDSource())
			out.setRefOrderIDSource(getRefOrderIDSource());
		if ( hasTimeInForce())
			out.setTimeInForce(getTimeInForce());
		if ( hasEffectiveTime())
			out.setEffectiveTime(getEffectiveTime());
		if ( hasExpireDate())
			out.setExpireDate(getExpireDate());
		if ( hasExpireTime())
			out.setExpireTime(getExpireTime());
		if ( hasGTBookingInst())
			out.setGTBookingInst(getGTBookingInst());
		if ( hasOrderCapacity())
			out.setOrderCapacity(getOrderCapacity());
		if ( hasOrderRestrictions())
			out.setOrderRestrictions(getOrderRestrictions());
		if ( hasPreTradeAnonymity())
			out.setPreTradeAnonymity(getPreTradeAnonymity());
		if ( hasCustOrderCapacity())
			out.setCustOrderCapacity(getCustOrderCapacity());
		if ( hasForexReq())
			out.setForexReq(getForexReq());
		if ( hasSettlCurrency())
			out.setSettlCurrency(getSettlCurrency());
		if ( hasBookingType())
			out.setBookingType(getBookingType());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasPositionEffect())
			out.setPositionEffect(getPositionEffect());
		if ( hasCoveredOrUncovered())
			out.setCoveredOrUncovered(getCoveredOrUncovered());
		if ( hasMaxShow())
			out.setMaxShow(getMaxShow());
		if ( hasTargetStrategy())
			out.setTargetStrategy(getTargetStrategy());
		if ( hasTargetStrategyParameters())
			out.setTargetStrategyParameters(getTargetStrategyParameters());
		if ( hasRiskFreeRate())
			out.setRiskFreeRate(getRiskFreeRate());
		if ( hasParticipationRate())
			out.setParticipationRate(getParticipationRate());
		if ( hasCancellationRights())
			out.setCancellationRights(getCancellationRights());
		if ( hasMoneyLaunderingStatus())
			out.setMoneyLaunderingStatus(getMoneyLaunderingStatus());
		if ( hasRegistID())
			out.setRegistID(getRegistID());
		if ( hasDesignation())
			out.setDesignation(getDesignation());
		if ( hasMultiLegRptTypeReq())
			out.setMultiLegRptTypeReq(getMultiLegRptTypeReq());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixPreAllocMlegGrp fixPreAllocMlegGrp : preAllocMlegGrp) {
			if (!fixPreAllocMlegGrp.hasGroup()) continue;
			out.preAllocMlegGrp[count] = fixPreAllocMlegGrp.clone( out.preAllocMlegGrp[count] );
			count++;
		}
		if (displayInstruction.hasGroup())
			out.displayInstruction = displayInstruction.clone( out.displayInstruction);
		count = 0;
		for (FixTrdgSesGrp fixTrdgSesGrp : trdgSesGrp) {
			if (!fixTrdgSesGrp.hasGroup()) continue;
			out.trdgSesGrp[count] = fixTrdgSesGrp.clone( out.trdgSesGrp[count] );
			count++;
		}
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		count = 0;
		for (FixLegOrdGrp fixLegOrdGrp : legOrdGrp) {
			if (!fixLegOrdGrp.hasGroup()) continue;
			out.legOrdGrp[count] = fixLegOrdGrp.clone( out.legOrdGrp[count] );
			count++;
		}
		if (orderQtyData.hasGroup())
			out.orderQtyData = orderQtyData.clone( out.orderQtyData);
		if (triggeringInstruction.hasGroup())
			out.triggeringInstruction = triggeringInstruction.clone( out.triggeringInstruction);
		if (commissionData.hasGroup())
			out.commissionData = commissionData.clone( out.commissionData);
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
		return out;
	}

}
