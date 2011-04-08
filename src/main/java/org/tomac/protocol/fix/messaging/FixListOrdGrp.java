package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixListOrdGrp extends FixGroup {
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryClOrdID;
	byte[] secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasListSeqNo;
	long listSeqNo = 0;		
	private short hasClOrdLinkID;
	byte[] clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlInstMode;
	byte settlInstMode = (byte)' ';		
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
	private short hasAllocID;
	byte[] allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPreallocMethod;
	byte preallocMethod = (byte)' ';		
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
	private short hasPrevClosePx;
	long prevClosePx = 0;		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasSideValueInd;
	long sideValueInd = 0;		
	private short hasLocateReqd;
		boolean locateReqd = false;		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasQtyType;
	long qtyType = 0;		
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
	private short hasSettlDate2;
	byte[] settlDate2 = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderQty2;
	long orderQty2 = 0;		
	private short hasPrice2;
	long price2 = 0;		
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
	private short hasParticipationRate;
	long participationRate = 0;		
	private short hasDesignation;
	byte[] designation = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixParties[] parties;
		public FixPreAllocGrp[] preAllocGrp;
		public FixDisplayInstruction displayInstruction;
		public FixTrdgSesGrp[] trdgSesGrp;
		public FixInstrument instrument;
		public FixUndInstrmtGrp[] undInstrmtGrp;
		public FixStipulations[] stipulations;
		public FixOrderQtyData orderQtyData;
		public FixTriggeringInstruction triggeringInstruction;
		public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
		public FixYieldData yieldData;
		public FixCommissionData commissionData;
		public FixPegInstructions pegInstructions;
		public FixDiscretionInstructions discretionInstructions;
		public FixStrategyParametersGrp[] strategyParametersGrp;
	
	public FixListOrdGrp() {
		this(false);
	}

	public FixListOrdGrp(boolean isRequired) {
		super(FixTags.CLORDID_INT);

		this.isRequired = isRequired;
		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasListSeqNo = FixUtils.TAG_HAS_NO_VALUE;		
		hasClOrdLinkID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlInstMode = FixUtils.TAG_HAS_NO_VALUE;		
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
		hasAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPreallocMethod = FixUtils.TAG_HAS_NO_VALUE;		
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
		hasPrevClosePx = FixUtils.TAG_HAS_NO_VALUE;		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasSideValueInd = FixUtils.TAG_HAS_NO_VALUE;		
		hasLocateReqd = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasQtyType = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;		
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
		hasSettlDate2 = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate2 = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderQty2 = FixUtils.TAG_HAS_NO_VALUE;		
		hasPrice2 = FixUtils.TAG_HAS_NO_VALUE;		
		hasPositionEffect = FixUtils.TAG_HAS_NO_VALUE;		
		hasCoveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxShow = FixUtils.TAG_HAS_NO_VALUE;		
		hasTargetStrategy = FixUtils.TAG_HAS_NO_VALUE;		
		hasTargetStrategyParameters = FixUtils.TAG_HAS_NO_VALUE;		
		targetStrategyParameters = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasParticipationRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasDesignation = FixUtils.TAG_HAS_NO_VALUE;		
		designation = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		preAllocGrp = new FixPreAllocGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) preAllocGrp[i] = new FixPreAllocGrp();
		displayInstruction = new FixDisplayInstruction();
		trdgSesGrp = new FixTrdgSesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdgSesGrp[i] = new FixTrdgSesGrp();
		instrument = new FixInstrument(true);
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		stipulations = new FixStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) stipulations[i] = new FixStipulations();
		orderQtyData = new FixOrderQtyData(true);
		triggeringInstruction = new FixTriggeringInstruction();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		yieldData = new FixYieldData();
		commissionData = new FixCommissionData();
		pegInstructions = new FixPegInstructions();
		discretionInstructions = new FixDiscretionInstructions();
		strategyParametersGrp = new FixStrategyParametersGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) strategyParametersGrp[i] = new FixStrategyParametersGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasClOrdID()) return true;
		else return false;
	}


	/**
     * Parse FIX Group. The buffer is positioned at the value of the tag.
     */
    public int setBuffer( int tag, ByteBuffer buf, FixValidationError err)
    {

		super.err = err;
		super.err.clear();
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYCLORDID_INT:		
            		hasSecondaryClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LISTSEQNO_INT:		
            		hasListSeqNo = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CLORDLINKID_INT:		
            		hasClOrdLinkID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLINSTMODE_INT:		
            		hasSettlInstMode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADEORIGINATIONDATE_INT:		
            		hasTradeOriginationDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADEDATE_INT:		
            		hasTradeDate = (short) buf.position();		
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
            	case FixTags.ALLOCID_INT:		
            		hasAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PREALLOCMETHOD_INT:		
            		hasPreallocMethod = (short) buf.position();		
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
            	case FixTags.CASHMARGIN_INT:		
            		hasCashMargin = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CLEARINGFEEINDICATOR_INT:		
            		hasClearingFeeIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.HANDLINST_INT:		
            		hasHandlInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.EXECINST_INT:		
            		hasExecInst = (short) buf.position();		
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
            	case FixTags.EXDESTINATION_INT:		
            		hasExDestination = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.EXDESTINATIONIDSOURCE_INT:		
            		hasExDestinationIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PROCESSCODE_INT:		
            		hasProcessCode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PREVCLOSEPX_INT:		
            		hasPrevClosePx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDEVALUEIND_INT:		
            		hasSideValueInd = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LOCATEREQD_INT:		
            		hasLocateReqd = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.QTYTYPE_INT:		
            		hasQtyType = (short) buf.position();		
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
            	case FixTags.IOIID_INT:		
            		hasIOIID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.QUOTEID_INT:		
            		hasQuoteID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.REFORDERID_INT:		
            		hasRefOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.REFORDERIDSOURCE_INT:		
            		hasRefOrderIDSource = (short) buf.position();		
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
            	case FixTags.GTBOOKINGINST_INT:		
            		hasGTBookingInst = (short) buf.position();		
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
            	case FixTags.FOREXREQ_INT:		
            		hasForexReq = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLCURRENCY_INT:		
            		hasSettlCurrency = (short) buf.position();		
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
            	case FixTags.PRICE2_INT:		
            		hasPrice2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.POSITIONEFFECT_INT:		
            		hasPositionEffect = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.COVEREDORUNCOVERED_INT:		
            		hasCoveredOrUncovered = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MAXSHOW_INT:		
            		hasMaxShow = (short) buf.position();		
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
            	case FixTags.DESIGNATION_INT:		
            		hasDesignation = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !parties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
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
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !preAllocGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = preAllocGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdgSesGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
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
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !undInstrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
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
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !stipulations[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
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
        			} else if ( spreadOrBenchmarkCurveData.isKeyTag(tag)) {
        				tag = spreadOrBenchmarkCurveData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( yieldData.isKeyTag(tag)) {
        				tag = yieldData.setBuffer( tag, buf, err);		
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
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !strategyParametersGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = strategyParametersGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
            if (isKeyTag(tag)) return tag; // next in repeating group
        }		
        return tag;
    }		
	public boolean hasRequiredTags(FixValidationError err) {
		if (!hasClOrdID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CLORDID_INT);
			return false;
		}
		if (!hasListSeqNo()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.LISTSEQNO_INT);
			return false;
		}
		if (!hasSide()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.SIDE_INT);
			return false;
		}
		if (instrument.isRequired) instrument.hasRequiredTags(err); if (err.hasError()) return false;
		if (orderQtyData.isRequired) orderQtyData.hasRequiredTags(err); if (err.hasError()) return false;
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasListSeqNo = FixUtils.TAG_HAS_NO_VALUE;
		hasClOrdLinkID = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlInstMode = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeOriginationDate = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;
		hasAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasAccountType = FixUtils.TAG_HAS_NO_VALUE;
		hasDayBookingInst = FixUtils.TAG_HAS_NO_VALUE;
		hasBookingUnit = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocID = FixUtils.TAG_HAS_NO_VALUE;
		hasPreallocMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;
		hasCashMargin = FixUtils.TAG_HAS_NO_VALUE;
		hasClearingFeeIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasHandlInst = FixUtils.TAG_HAS_NO_VALUE;
		hasExecInst = FixUtils.TAG_HAS_NO_VALUE;
		hasMinQty = FixUtils.TAG_HAS_NO_VALUE;
		hasMatchIncrement = FixUtils.TAG_HAS_NO_VALUE;
		hasMaxPriceLevels = FixUtils.TAG_HAS_NO_VALUE;
		hasMaxFloor = FixUtils.TAG_HAS_NO_VALUE;
		hasExDestination = FixUtils.TAG_HAS_NO_VALUE;
		hasExDestinationIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasProcessCode = FixUtils.TAG_HAS_NO_VALUE;
		hasPrevClosePx = FixUtils.TAG_HAS_NO_VALUE;
		hasSide = FixUtils.TAG_HAS_NO_VALUE;
		hasSideValueInd = FixUtils.TAG_HAS_NO_VALUE;
		hasLocateReqd = FixUtils.TAG_HAS_NO_VALUE;
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;
		hasQtyType = FixUtils.TAG_HAS_NO_VALUE;
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;
		hasPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasPriceProtectionScope = FixUtils.TAG_HAS_NO_VALUE;
		hasStopPx = FixUtils.TAG_HAS_NO_VALUE;
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasComplianceID = FixUtils.TAG_HAS_NO_VALUE;
		hasSolicitedFlag = FixUtils.TAG_HAS_NO_VALUE;
		hasIOIID = FixUtils.TAG_HAS_NO_VALUE;
		hasQuoteID = FixUtils.TAG_HAS_NO_VALUE;
		hasRefOrderID = FixUtils.TAG_HAS_NO_VALUE;
		hasRefOrderIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasTimeInForce = FixUtils.TAG_HAS_NO_VALUE;
		hasEffectiveTime = FixUtils.TAG_HAS_NO_VALUE;
		hasExpireDate = FixUtils.TAG_HAS_NO_VALUE;
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;
		hasGTBookingInst = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderRestrictions = FixUtils.TAG_HAS_NO_VALUE;
		hasPreTradeAnonymity = FixUtils.TAG_HAS_NO_VALUE;
		hasCustOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasForexReq = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasBookingType = FixUtils.TAG_HAS_NO_VALUE;
		hasText = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlDate2 = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderQty2 = FixUtils.TAG_HAS_NO_VALUE;
		hasPrice2 = FixUtils.TAG_HAS_NO_VALUE;
		hasPositionEffect = FixUtils.TAG_HAS_NO_VALUE;
		hasCoveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;
		hasMaxShow = FixUtils.TAG_HAS_NO_VALUE;
		hasTargetStrategy = FixUtils.TAG_HAS_NO_VALUE;
		hasTargetStrategyParameters = FixUtils.TAG_HAS_NO_VALUE;
		hasParticipationRate = FixUtils.TAG_HAS_NO_VALUE;
		hasDesignation = FixUtils.TAG_HAS_NO_VALUE;
		for (FixParties fixParties : parties) fixParties.clear();
		for (FixPreAllocGrp fixPreAllocGrp : preAllocGrp) fixPreAllocGrp.clear();
		displayInstruction.clear();
		for (FixTrdgSesGrp fixTrdgSesGrp : trdgSesGrp) fixTrdgSesGrp.clear();
		instrument.clear();
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.clear();
		for (FixStipulations fixStipulations : stipulations) fixStipulations.clear();
		orderQtyData.clear();
		triggeringInstruction.clear();
		spreadOrBenchmarkCurveData.clear();
		yieldData.clear();
		commissionData.clear();
		pegInstructions.clear();
		discretionInstructions.clear();
		for (FixStrategyParametersGrp fixStrategyParametersGrp : strategyParametersGrp) fixStrategyParametersGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

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

		if (hasListSeqNo()) {		
			out.put(FixTags.LISTSEQNO);

			out.put((byte) '=');

			FixUtils.put(out, (long)listSeqNo);
		
			out.put(FixUtils.SOH);

            }

		if (hasClOrdLinkID()) {		
			out.put(FixTags.CLORDLINKID);

			out.put((byte) '=');

			FixUtils.put(out,clOrdLinkID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlInstMode()) {		
			out.put(FixTags.SETTLINSTMODE);

			out.put((byte) '=');

			FixUtils.put(out,settlInstMode); 		
		
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

		if (hasAllocID()) {		
			out.put(FixTags.ALLOCID);

			out.put((byte) '=');

			FixUtils.put(out,allocID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPreallocMethod()) {		
			out.put(FixTags.PREALLOCMETHOD);

			out.put((byte) '=');

			FixUtils.put(out,preallocMethod); 		
		
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

		if (hasPrevClosePx()) {		
			out.put(FixTags.PREVCLOSEPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)prevClosePx);
		
			out.put(FixUtils.SOH);

            }

		if (hasSide()) {		
			out.put(FixTags.SIDE);

			out.put((byte) '=');

			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSideValueInd()) {		
			out.put(FixTags.SIDEVALUEIND);

			out.put((byte) '=');

			FixUtils.put(out, (long)sideValueInd);
		
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

		if (hasPrice2()) {		
			out.put(FixTags.PRICE2);

			out.put((byte) '=');

			FixUtils.put(out, (long)price2);
		
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

		if (hasParticipationRate()) {		
			out.put(FixTags.PARTICIPATIONRATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)participationRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasDesignation()) {		
			out.put(FixTags.DESIGNATION);

			out.put((byte) '=');

			FixUtils.put(out,designation); 		
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(preAllocGrp)>0) {
			out.put(FixTags.NOALLOCS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(preAllocGrp));

			out.put(FixUtils.SOH);

		}
		for (FixPreAllocGrp fixPreAllocGrp : preAllocGrp) if (fixPreAllocGrp.hasGroup()) fixPreAllocGrp.encode(out);
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
		if (FixUtils.getNoInGroup(stipulations)>0) {
			out.put(FixTags.NOSTIPULATIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(stipulations));

			out.put(FixUtils.SOH);

		}
		for (FixStipulations fixStipulations : stipulations) if (fixStipulations.hasGroup()) fixStipulations.encode(out);
		orderQtyData.encode(out);
		triggeringInstruction.encode(out);
		spreadOrBenchmarkCurveData.encode(out);
		yieldData.encode(out);
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
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryClOrdID()) {		
			FixUtils.put(out,secondaryClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasListSeqNo()) {		
			FixUtils.put(out, (long)listSeqNo);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdLinkID()) {		
			FixUtils.put(out,clOrdLinkID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlInstMode()) {		
			FixUtils.put(out,settlInstMode); 		
		
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
		
		if (hasAllocID()) {		
			FixUtils.put(out,allocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPreallocMethod()) {		
			FixUtils.put(out,preallocMethod); 		
		
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
		
		if (hasPrevClosePx()) {		
			FixUtils.put(out, (long)prevClosePx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideValueInd()) {		
			FixUtils.put(out, (long)sideValueInd);
		
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
		
		if (hasSettlDate2()) {		
			FixUtils.put(out,settlDate2); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderQty2()) {		
			FixUtils.put(out, (long)orderQty2);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPrice2()) {		
			FixUtils.put(out, (long)price2);
		
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
		
		if (hasParticipationRate()) {		
			FixUtils.put(out, (long)participationRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDesignation()) {		
			FixUtils.put(out,designation); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixParties fixParties : parties) fixParties.printBuffer(out);
		for (FixPreAllocGrp fixPreAllocGrp : preAllocGrp) fixPreAllocGrp.printBuffer(out);
		displayInstruction.printBuffer(out);
		for (FixTrdgSesGrp fixTrdgSesGrp : trdgSesGrp) fixTrdgSesGrp.printBuffer(out);
		instrument.printBuffer(out);
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.printBuffer(out);
		for (FixStipulations fixStipulations : stipulations) fixStipulations.printBuffer(out);
		orderQtyData.printBuffer(out);
		triggeringInstruction.printBuffer(out);
		spreadOrBenchmarkCurveData.printBuffer(out);
		yieldData.printBuffer(out);
		commissionData.printBuffer(out);
		pegInstructions.printBuffer(out);
		discretionInstructions.printBuffer(out);
		for (FixStrategyParametersGrp fixStrategyParametersGrp : strategyParametersGrp) fixStrategyParametersGrp.printBuffer(out);
	}

	public byte[] getClOrdID() { 		
		if ( hasClOrdID()) {		
			if (hasClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return clOrdID; 		
			} else {		
		
				buf.position(hasClOrdID);		
		
			FixMessage.getTagStringValue(buf, clOrdID, 0, clOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasClOrdID);		
					return null;		
				}		
			}		
			hasClOrdID = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getSecondaryClOrdID() { 		
		if ( hasSecondaryClOrdID()) {		
			if (hasSecondaryClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryClOrdID; 		
			} else {		
		
				buf.position(hasSecondaryClOrdID);		
		
			FixMessage.getTagStringValue(buf, secondaryClOrdID, 0, secondaryClOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryClOrdID);		
					return null;		
				}		
			}		
			hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getListSeqNo() { 		
		if ( hasListSeqNo()) {		
			if (hasListSeqNo == FixUtils.TAG_HAS_VALUE) {		
				return listSeqNo; 		
			} else {		
		
				buf.position(hasListSeqNo);		
		
			listSeqNo = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasListSeqNo);		
					return 0;		
				}		
			}		
			hasListSeqNo = FixUtils.TAG_HAS_VALUE;		
			return listSeqNo;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasListSeqNo() { return hasListSeqNo != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setListSeqNo(long src) {		
		listSeqNo = src;
		hasListSeqNo = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListSeqNo(byte[] src) {		
		if (src == null ) return;
		if (hasListSeqNo()) listSeqNo = FixUtils.TAG_HAS_NO_VALUE;		
		listSeqNo = FixUtils.longValueOf(src, 0, src.length);
		hasListSeqNo = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setListSeqNo(String str) {		
		if (str == null ) return;
		if (hasListSeqNo()) listSeqNo = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		listSeqNo = FixUtils.longValueOf(src, 0, src.length);
		hasListSeqNo = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getClOrdLinkID() { 		
		if ( hasClOrdLinkID()) {		
			if (hasClOrdLinkID == FixUtils.TAG_HAS_VALUE) {		
				return clOrdLinkID; 		
			} else {		
		
				buf.position(hasClOrdLinkID);		
		
			FixMessage.getTagStringValue(buf, clOrdLinkID, 0, clOrdLinkID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasClOrdLinkID);		
					return null;		
				}		
			}		
			hasClOrdLinkID = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte getSettlInstMode() { 		
		if ( hasSettlInstMode()) {		
			if (hasSettlInstMode == FixUtils.TAG_HAS_VALUE) {		
				return settlInstMode; 		
			} else {		
		
				buf.position(hasSettlInstMode);		
		
			settlInstMode = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (settlInstMode != (byte)'3') && (settlInstMode != (byte)'2') && (settlInstMode != (byte)'1') && (settlInstMode != (byte)'0') && (settlInstMode != (byte)'5') && (settlInstMode != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 160);		
				if (err.hasError()) {		
					buf.position(hasSettlInstMode);		
					return (byte)'0';		
				}		
			}		
			hasSettlInstMode = FixUtils.TAG_HAS_VALUE;		
			return settlInstMode;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSettlInstMode() { return hasSettlInstMode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlInstMode(byte src) {		
		settlInstMode = src;
		hasSettlInstMode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlInstMode(byte[] src) {		
		if (src == null ) return;
		if (hasSettlInstMode()) settlInstMode = (byte)' ';		
		settlInstMode = src[0];		
		hasSettlInstMode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlInstMode(String str) {		
		if (str == null ) return;
		if (hasSettlInstMode()) settlInstMode = (byte)' ';		
		byte[] src = str.getBytes(); 		
		settlInstMode = src[0];		
		hasSettlInstMode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradeOriginationDate() { 		
		if ( hasTradeOriginationDate()) {		
			if (hasTradeOriginationDate == FixUtils.TAG_HAS_VALUE) {		
				return tradeOriginationDate; 		
			} else {		
		
				buf.position(hasTradeOriginationDate);		
		
			FixMessage.getTagStringValue(buf, tradeOriginationDate, 0, tradeOriginationDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradeOriginationDate);		
					return null;		
				}		
			}		
			hasTradeOriginationDate = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getTradeDate() { 		
		if ( hasTradeDate()) {		
			if (hasTradeDate == FixUtils.TAG_HAS_VALUE) {		
				return tradeDate; 		
			} else {		
		
				buf.position(hasTradeDate);		
		
			FixMessage.getTagStringValue(buf, tradeDate, 0, tradeDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradeDate);		
					return null;		
				}		
			}		
			hasTradeDate = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getAccount() { 		
		if ( hasAccount()) {		
			if (hasAccount == FixUtils.TAG_HAS_VALUE) {		
				return account; 		
			} else {		
		
				buf.position(hasAccount);		
		
			FixMessage.getTagStringValue(buf, account, 0, account.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAccount);		
					return null;		
				}		
			}		
			hasAccount = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getAcctIDSource() { 		
		if ( hasAcctIDSource()) {		
			if (hasAcctIDSource == FixUtils.TAG_HAS_VALUE) {		
				return acctIDSource; 		
			} else {		
		
				buf.position(hasAcctIDSource);		
		
			acctIDSource = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAcctIDSource);		
					return 0;		
				}		
			}		
			hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
			return acctIDSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAcctIDSource() { return hasAcctIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAcctIDSource(long src) {		
		acctIDSource = src;
		hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAcctIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasAcctIDSource()) acctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		acctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAcctIDSource(String str) {		
		if (str == null ) return;
		if (hasAcctIDSource()) acctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		acctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAccountType() { 		
		if ( hasAccountType()) {		
			if (hasAccountType == FixUtils.TAG_HAS_VALUE) {		
				return accountType; 		
			} else {		
		
				buf.position(hasAccountType);		
		
			accountType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAccountType);		
					return 0;		
				}		
			}		
			hasAccountType = FixUtils.TAG_HAS_VALUE;		
			return accountType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAccountType() { return hasAccountType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAccountType(long src) {		
		accountType = src;
		hasAccountType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccountType(byte[] src) {		
		if (src == null ) return;
		if (hasAccountType()) accountType = FixUtils.TAG_HAS_NO_VALUE;		
		accountType = FixUtils.longValueOf(src, 0, src.length);
		hasAccountType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAccountType(String str) {		
		if (str == null ) return;
		if (hasAccountType()) accountType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		accountType = FixUtils.longValueOf(src, 0, src.length);
		hasAccountType = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasDayBookingInst);		
					return (byte)'0';		
				}		
			}		
			hasDayBookingInst = FixUtils.TAG_HAS_VALUE;		
			return dayBookingInst;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDayBookingInst() { return hasDayBookingInst != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDayBookingInst(byte src) {		
		dayBookingInst = src;
		hasDayBookingInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDayBookingInst(byte[] src) {		
		if (src == null ) return;
		if (hasDayBookingInst()) dayBookingInst = (byte)' ';		
		dayBookingInst = src[0];		
		hasDayBookingInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDayBookingInst(String str) {		
		if (str == null ) return;
		if (hasDayBookingInst()) dayBookingInst = (byte)' ';		
		byte[] src = str.getBytes(); 		
		dayBookingInst = src[0];		
		hasDayBookingInst = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasBookingUnit);		
					return (byte)'0';		
				}		
			}		
			hasBookingUnit = FixUtils.TAG_HAS_VALUE;		
			return bookingUnit;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasBookingUnit() { return hasBookingUnit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBookingUnit(byte src) {		
		bookingUnit = src;
		hasBookingUnit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBookingUnit(byte[] src) {		
		if (src == null ) return;
		if (hasBookingUnit()) bookingUnit = (byte)' ';		
		bookingUnit = src[0];		
		hasBookingUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBookingUnit(String str) {		
		if (str == null ) return;
		if (hasBookingUnit()) bookingUnit = (byte)' ';		
		byte[] src = str.getBytes(); 		
		bookingUnit = src[0];		
		hasBookingUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getAllocID() { 		
		if ( hasAllocID()) {		
			if (hasAllocID == FixUtils.TAG_HAS_VALUE) {		
				return allocID; 		
			} else {		
		
				buf.position(hasAllocID);		
		
			FixMessage.getTagStringValue(buf, allocID, 0, allocID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocID);		
					return null;		
				}		
			}		
			hasAllocID = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasPreallocMethod);		
					return (byte)'0';		
				}		
			}		
			hasPreallocMethod = FixUtils.TAG_HAS_VALUE;		
			return preallocMethod;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasPreallocMethod() { return hasPreallocMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPreallocMethod(byte src) {		
		preallocMethod = src;
		hasPreallocMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPreallocMethod(byte[] src) {		
		if (src == null ) return;
		if (hasPreallocMethod()) preallocMethod = (byte)' ';		
		preallocMethod = src[0];		
		hasPreallocMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPreallocMethod(String str) {		
		if (str == null ) return;
		if (hasPreallocMethod()) preallocMethod = (byte)' ';		
		byte[] src = str.getBytes(); 		
		preallocMethod = src[0];		
		hasPreallocMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSettlType() { 		
		if ( hasSettlType()) {		
			if (hasSettlType == FixUtils.TAG_HAS_VALUE) {		
				return settlType; 		
			} else {		
		
				buf.position(hasSettlType);		
		
			FixMessage.getTagStringValue(buf, settlType, 0, settlType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlType);		
					return null;		
				}		
			}		
			hasSettlType = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getSettlDate() { 		
		if ( hasSettlDate()) {		
			if (hasSettlDate == FixUtils.TAG_HAS_VALUE) {		
				return settlDate; 		
			} else {		
		
				buf.position(hasSettlDate);		
		
			FixMessage.getTagStringValue(buf, settlDate, 0, settlDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlDate);		
					return null;		
				}		
			}		
			hasSettlDate = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasCashMargin);		
					return (byte)'0';		
				}		
			}		
			hasCashMargin = FixUtils.TAG_HAS_VALUE;		
			return cashMargin;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasCashMargin() { return hasCashMargin != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCashMargin(byte src) {		
		cashMargin = src;
		hasCashMargin = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCashMargin(byte[] src) {		
		if (src == null ) return;
		if (hasCashMargin()) cashMargin = (byte)' ';		
		cashMargin = src[0];		
		hasCashMargin = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCashMargin(String str) {		
		if (str == null ) return;
		if (hasCashMargin()) cashMargin = (byte)' ';		
		byte[] src = str.getBytes(); 		
		cashMargin = src[0];		
		hasCashMargin = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getClearingFeeIndicator() { 		
		if ( hasClearingFeeIndicator()) {		
			if (hasClearingFeeIndicator == FixUtils.TAG_HAS_VALUE) {		
				return clearingFeeIndicator; 		
			} else {		
		
				buf.position(hasClearingFeeIndicator);		
		
			FixMessage.getTagStringValue(buf, clearingFeeIndicator, 0, clearingFeeIndicator.length, err);
		
				if (err.hasError()) {		
					buf.position(hasClearingFeeIndicator);		
					return null;		
				}		
			}		
			hasClearingFeeIndicator = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasHandlInst);		
					return (byte)'0';		
				}		
			}		
			hasHandlInst = FixUtils.TAG_HAS_VALUE;		
			return handlInst;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasHandlInst() { return hasHandlInst != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setHandlInst(byte src) {		
		handlInst = src;
		hasHandlInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHandlInst(byte[] src) {		
		if (src == null ) return;
		if (hasHandlInst()) handlInst = (byte)' ';		
		handlInst = src[0];		
		hasHandlInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setHandlInst(String str) {		
		if (str == null ) return;
		if (hasHandlInst()) handlInst = (byte)' ';		
		byte[] src = str.getBytes(); 		
		handlInst = src[0];		
		hasHandlInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getExecInst() { 		
		if ( hasExecInst()) {		
			if (hasExecInst == FixUtils.TAG_HAS_VALUE) {		
				return execInst; 		
			} else {		
		
				buf.position(hasExecInst);		
		
			FixMessage.getTagStringValue(buf, execInst, 0, execInst.length, err);
		
				if (err.hasError()) {		
					buf.position(hasExecInst);		
					return null;		
				}		
			}		
			hasExecInst = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getMinQty() { 		
		if ( hasMinQty()) {		
			if (hasMinQty == FixUtils.TAG_HAS_VALUE) {		
				return minQty; 		
			} else {		
		
				buf.position(hasMinQty);		
		
			minQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMinQty);		
					return 0;		
				}		
			}		
			hasMinQty = FixUtils.TAG_HAS_VALUE;		
			return minQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMinQty() { return hasMinQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMinQty(long src) {		
		minQty = src;
		hasMinQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinQty(byte[] src) {		
		if (src == null ) return;
		if (hasMinQty()) minQty = FixUtils.TAG_HAS_NO_VALUE;		
		minQty = FixUtils.longValueOf(src, 0, src.length);
		hasMinQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMinQty(String str) {		
		if (str == null ) return;
		if (hasMinQty()) minQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		minQty = FixUtils.longValueOf(src, 0, src.length);
		hasMinQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMatchIncrement() { 		
		if ( hasMatchIncrement()) {		
			if (hasMatchIncrement == FixUtils.TAG_HAS_VALUE) {		
				return matchIncrement; 		
			} else {		
		
				buf.position(hasMatchIncrement);		
		
			matchIncrement = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMatchIncrement);		
					return 0;		
				}		
			}		
			hasMatchIncrement = FixUtils.TAG_HAS_VALUE;		
			return matchIncrement;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMatchIncrement() { return hasMatchIncrement != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMatchIncrement(long src) {		
		matchIncrement = src;
		hasMatchIncrement = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMatchIncrement(byte[] src) {		
		if (src == null ) return;
		if (hasMatchIncrement()) matchIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		matchIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasMatchIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMatchIncrement(String str) {		
		if (str == null ) return;
		if (hasMatchIncrement()) matchIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		matchIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasMatchIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMaxPriceLevels() { 		
		if ( hasMaxPriceLevels()) {		
			if (hasMaxPriceLevels == FixUtils.TAG_HAS_VALUE) {		
				return maxPriceLevels; 		
			} else {		
		
				buf.position(hasMaxPriceLevels);		
		
			maxPriceLevels = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMaxPriceLevels);		
					return 0;		
				}		
			}		
			hasMaxPriceLevels = FixUtils.TAG_HAS_VALUE;		
			return maxPriceLevels;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxPriceLevels() { return hasMaxPriceLevels != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMaxPriceLevels(long src) {		
		maxPriceLevels = src;
		hasMaxPriceLevels = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxPriceLevels(byte[] src) {		
		if (src == null ) return;
		if (hasMaxPriceLevels()) maxPriceLevels = FixUtils.TAG_HAS_NO_VALUE;		
		maxPriceLevels = FixUtils.longValueOf(src, 0, src.length);
		hasMaxPriceLevels = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMaxPriceLevels(String str) {		
		if (str == null ) return;
		if (hasMaxPriceLevels()) maxPriceLevels = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxPriceLevels = FixUtils.longValueOf(src, 0, src.length);
		hasMaxPriceLevels = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMaxFloor() { 		
		if ( hasMaxFloor()) {		
			if (hasMaxFloor == FixUtils.TAG_HAS_VALUE) {		
				return maxFloor; 		
			} else {		
		
				buf.position(hasMaxFloor);		
		
			maxFloor = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMaxFloor);		
					return 0;		
				}		
			}		
			hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
			return maxFloor;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxFloor() { return hasMaxFloor != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMaxFloor(long src) {		
		maxFloor = src;
		hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxFloor(byte[] src) {		
		if (src == null ) return;
		if (hasMaxFloor()) maxFloor = FixUtils.TAG_HAS_NO_VALUE;		
		maxFloor = FixUtils.longValueOf(src, 0, src.length);
		hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMaxFloor(String str) {		
		if (str == null ) return;
		if (hasMaxFloor()) maxFloor = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxFloor = FixUtils.longValueOf(src, 0, src.length);
		hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getExDestination() { 		
		if ( hasExDestination()) {		
			if (hasExDestination == FixUtils.TAG_HAS_VALUE) {		
				return exDestination; 		
			} else {		
		
				buf.position(hasExDestination);		
		
			FixMessage.getTagStringValue(buf, exDestination, 0, exDestination.length, err);
		
				if (err.hasError()) {		
					buf.position(hasExDestination);		
					return null;		
				}		
			}		
			hasExDestination = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte getExDestinationIDSource() { 		
		if ( hasExDestinationIDSource()) {		
			if (hasExDestinationIDSource == FixUtils.TAG_HAS_VALUE) {		
				return exDestinationIDSource; 		
			} else {		
		
				buf.position(hasExDestinationIDSource);		
		
			exDestinationIDSource = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (exDestinationIDSource != (byte)'D') && (exDestinationIDSource != (byte)'E') && (exDestinationIDSource != (byte)'G') && (exDestinationIDSource != (byte)'B') && (exDestinationIDSource != (byte)'C') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1133);		
				if (err.hasError()) {		
					buf.position(hasExDestinationIDSource);		
					return (byte)'0';		
				}		
			}		
			hasExDestinationIDSource = FixUtils.TAG_HAS_VALUE;		
			return exDestinationIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasExDestinationIDSource() { return hasExDestinationIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setExDestinationIDSource(byte src) {		
		exDestinationIDSource = src;
		hasExDestinationIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExDestinationIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasExDestinationIDSource()) exDestinationIDSource = (byte)' ';		
		exDestinationIDSource = src[0];		
		hasExDestinationIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setExDestinationIDSource(String str) {		
		if (str == null ) return;
		if (hasExDestinationIDSource()) exDestinationIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		exDestinationIDSource = src[0];		
		hasExDestinationIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getProcessCode() { 		
		if ( hasProcessCode()) {		
			if (hasProcessCode == FixUtils.TAG_HAS_VALUE) {		
				return processCode; 		
			} else {		
		
				buf.position(hasProcessCode);		
		
			processCode = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (processCode != (byte)'3') && (processCode != (byte)'2') && (processCode != (byte)'1') && (processCode != (byte)'0') && (processCode != (byte)'6') && (processCode != (byte)'5') && (processCode != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 81);		
				if (err.hasError()) {		
					buf.position(hasProcessCode);		
					return (byte)'0';		
				}		
			}		
			hasProcessCode = FixUtils.TAG_HAS_VALUE;		
			return processCode;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasProcessCode() { return hasProcessCode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setProcessCode(byte src) {		
		processCode = src;
		hasProcessCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProcessCode(byte[] src) {		
		if (src == null ) return;
		if (hasProcessCode()) processCode = (byte)' ';		
		processCode = src[0];		
		hasProcessCode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setProcessCode(String str) {		
		if (str == null ) return;
		if (hasProcessCode()) processCode = (byte)' ';		
		byte[] src = str.getBytes(); 		
		processCode = src[0];		
		hasProcessCode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPrevClosePx() { 		
		if ( hasPrevClosePx()) {		
			if (hasPrevClosePx == FixUtils.TAG_HAS_VALUE) {		
				return prevClosePx; 		
			} else {		
		
				buf.position(hasPrevClosePx);		
		
			prevClosePx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPrevClosePx);		
					return 0;		
				}		
			}		
			hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
			return prevClosePx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPrevClosePx() { return hasPrevClosePx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPrevClosePx(long src) {		
		prevClosePx = src;
		hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrevClosePx(byte[] src) {		
		if (src == null ) return;
		if (hasPrevClosePx()) prevClosePx = FixUtils.TAG_HAS_NO_VALUE;		
		prevClosePx = FixUtils.longValueOf(src, 0, src.length);
		hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPrevClosePx(String str) {		
		if (str == null ) return;
		if (hasPrevClosePx()) prevClosePx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		prevClosePx = FixUtils.longValueOf(src, 0, src.length);
		hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasSide);		
					return (byte)'0';		
				}		
			}		
			hasSide = FixUtils.TAG_HAS_VALUE;		
			return side;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSide() { return hasSide != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSide(byte src) {		
		side = src;
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(byte[] src) {		
		if (src == null ) return;
		if (hasSide()) side = (byte)' ';		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSide(String str) {		
		if (str == null ) return;
		if (hasSide()) side = (byte)' ';		
		byte[] src = str.getBytes(); 		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSideValueInd() { 		
		if ( hasSideValueInd()) {		
			if (hasSideValueInd == FixUtils.TAG_HAS_VALUE) {		
				return sideValueInd; 		
			} else {		
		
				buf.position(hasSideValueInd);		
		
			sideValueInd = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSideValueInd);		
					return 0;		
				}		
			}		
			hasSideValueInd = FixUtils.TAG_HAS_VALUE;		
			return sideValueInd;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSideValueInd() { return hasSideValueInd != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideValueInd(long src) {		
		sideValueInd = src;
		hasSideValueInd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSideValueInd(byte[] src) {		
		if (src == null ) return;
		if (hasSideValueInd()) sideValueInd = FixUtils.TAG_HAS_NO_VALUE;		
		sideValueInd = FixUtils.longValueOf(src, 0, src.length);
		hasSideValueInd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideValueInd(String str) {		
		if (str == null ) return;
		if (hasSideValueInd()) sideValueInd = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sideValueInd = FixUtils.longValueOf(src, 0, src.length);
		hasSideValueInd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getLocateReqd() { 		
		if ( hasLocateReqd()) {		
			if (hasLocateReqd == FixUtils.TAG_HAS_VALUE) {		
				return locateReqd; 		
			} else {		
		
				buf.position(hasLocateReqd);		
		
			locateReqd = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasLocateReqd);		
					return false;		
				}		
			}		
			hasLocateReqd = FixUtils.TAG_HAS_VALUE;		
			return locateReqd;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasLocateReqd() { return hasLocateReqd != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLocateReqd(boolean src) {		
		locateReqd = src;
		hasLocateReqd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLocateReqd(byte[] src) {		
		if (src == null ) return;
		if (hasLocateReqd()) locateReqd = false;		
		locateReqd = src[0]==(byte)'Y'?true:false;		
		hasLocateReqd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLocateReqd(String str) {		
		if (str == null ) return;
		if (hasLocateReqd()) locateReqd = false;		
		byte[] src = str.getBytes(); 		
		locateReqd = src[0]==(byte)'Y'?true:false;		
		hasLocateReqd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTransactTime() { 		
		if ( hasTransactTime()) {		
			if (hasTransactTime == FixUtils.TAG_HAS_VALUE) {		
				return transactTime; 		
			} else {		
		
				buf.position(hasTransactTime);		
		
			FixMessage.getTagStringValue(buf, transactTime, 0, transactTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTransactTime);		
					return null;		
				}		
			}		
			hasTransactTime = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getQtyType() { 		
		if ( hasQtyType()) {		
			if (hasQtyType == FixUtils.TAG_HAS_VALUE) {		
				return qtyType; 		
			} else {		
		
				buf.position(hasQtyType);		
		
			qtyType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasQtyType);		
					return 0;		
				}		
			}		
			hasQtyType = FixUtils.TAG_HAS_VALUE;		
			return qtyType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQtyType() { return hasQtyType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setQtyType(long src) {		
		qtyType = src;
		hasQtyType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQtyType(byte[] src) {		
		if (src == null ) return;
		if (hasQtyType()) qtyType = FixUtils.TAG_HAS_NO_VALUE;		
		qtyType = FixUtils.longValueOf(src, 0, src.length);
		hasQtyType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setQtyType(String str) {		
		if (str == null ) return;
		if (hasQtyType()) qtyType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		qtyType = FixUtils.longValueOf(src, 0, src.length);
		hasQtyType = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasOrdType);		
					return (byte)'0';		
				}		
			}		
			hasOrdType = FixUtils.TAG_HAS_VALUE;		
			return ordType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrdType() { return hasOrdType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrdType(byte src) {		
		ordType = src;
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdType(byte[] src) {		
		if (src == null ) return;
		if (hasOrdType()) ordType = (byte)' ';		
		ordType = src[0];		
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrdType(String str) {		
		if (str == null ) return;
		if (hasOrdType()) ordType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		ordType = src[0];		
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPriceType() { 		
		if ( hasPriceType()) {		
			if (hasPriceType == FixUtils.TAG_HAS_VALUE) {		
				return priceType; 		
			} else {		
		
				buf.position(hasPriceType);		
		
			priceType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPriceType);		
					return 0;		
				}		
			}		
			hasPriceType = FixUtils.TAG_HAS_VALUE;		
			return priceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriceType() { return hasPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPriceType(long src) {		
		priceType = src;
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasPriceType()) priceType = FixUtils.TAG_HAS_NO_VALUE;		
		priceType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPriceType(String str) {		
		if (str == null ) return;
		if (hasPriceType()) priceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priceType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPrice() { 		
		if ( hasPrice()) {		
			if (hasPrice == FixUtils.TAG_HAS_VALUE) {		
				return price; 		
			} else {		
		
				buf.position(hasPrice);		
		
			price = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPrice);		
					return 0;		
				}		
			}		
			hasPrice = FixUtils.TAG_HAS_VALUE;		
			return price;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPrice() { return hasPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPrice(long src) {		
		price = src;
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice(byte[] src) {		
		if (src == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPrice(String str) {		
		if (str == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasPriceProtectionScope);		
					return (byte)'0';		
				}		
			}		
			hasPriceProtectionScope = FixUtils.TAG_HAS_VALUE;		
			return priceProtectionScope;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasPriceProtectionScope() { return hasPriceProtectionScope != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPriceProtectionScope(byte src) {		
		priceProtectionScope = src;
		hasPriceProtectionScope = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceProtectionScope(byte[] src) {		
		if (src == null ) return;
		if (hasPriceProtectionScope()) priceProtectionScope = (byte)' ';		
		priceProtectionScope = src[0];		
		hasPriceProtectionScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPriceProtectionScope(String str) {		
		if (str == null ) return;
		if (hasPriceProtectionScope()) priceProtectionScope = (byte)' ';		
		byte[] src = str.getBytes(); 		
		priceProtectionScope = src[0];		
		hasPriceProtectionScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStopPx() { 		
		if ( hasStopPx()) {		
			if (hasStopPx == FixUtils.TAG_HAS_VALUE) {		
				return stopPx; 		
			} else {		
		
				buf.position(hasStopPx);		
		
			stopPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStopPx);		
					return 0;		
				}		
			}		
			hasStopPx = FixUtils.TAG_HAS_VALUE;		
			return stopPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStopPx() { return hasStopPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStopPx(long src) {		
		stopPx = src;
		hasStopPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStopPx(byte[] src) {		
		if (src == null ) return;
		if (hasStopPx()) stopPx = FixUtils.TAG_HAS_NO_VALUE;		
		stopPx = FixUtils.longValueOf(src, 0, src.length);
		hasStopPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStopPx(String str) {		
		if (str == null ) return;
		if (hasStopPx()) stopPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		stopPx = FixUtils.longValueOf(src, 0, src.length);
		hasStopPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCurrency() { 		
		if ( hasCurrency()) {		
			if (hasCurrency == FixUtils.TAG_HAS_VALUE) {		
				return currency; 		
			} else {		
		
				buf.position(hasCurrency);		
		
			FixMessage.getTagStringValue(buf, currency, 0, currency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCurrency);		
					return null;		
				}		
			}		
			hasCurrency = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getComplianceID() { 		
		if ( hasComplianceID()) {		
			if (hasComplianceID == FixUtils.TAG_HAS_VALUE) {		
				return complianceID; 		
			} else {		
		
				buf.position(hasComplianceID);		
		
			FixMessage.getTagStringValue(buf, complianceID, 0, complianceID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasComplianceID);		
					return null;		
				}		
			}		
			hasComplianceID = FixUtils.TAG_HAS_VALUE;		
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
			
	public boolean getSolicitedFlag() { 		
		if ( hasSolicitedFlag()) {		
			if (hasSolicitedFlag == FixUtils.TAG_HAS_VALUE) {		
				return solicitedFlag; 		
			} else {		
		
				buf.position(hasSolicitedFlag);		
		
			solicitedFlag = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasSolicitedFlag);		
					return false;		
				}		
			}		
			hasSolicitedFlag = FixUtils.TAG_HAS_VALUE;		
			return solicitedFlag;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasSolicitedFlag() { return hasSolicitedFlag != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSolicitedFlag(boolean src) {		
		solicitedFlag = src;
		hasSolicitedFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSolicitedFlag(byte[] src) {		
		if (src == null ) return;
		if (hasSolicitedFlag()) solicitedFlag = false;		
		solicitedFlag = src[0]==(byte)'Y'?true:false;		
		hasSolicitedFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSolicitedFlag(String str) {		
		if (str == null ) return;
		if (hasSolicitedFlag()) solicitedFlag = false;		
		byte[] src = str.getBytes(); 		
		solicitedFlag = src[0]==(byte)'Y'?true:false;		
		hasSolicitedFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getIOIID() { 		
		if ( hasIOIID()) {		
			if (hasIOIID == FixUtils.TAG_HAS_VALUE) {		
				return iOIID; 		
			} else {		
		
				buf.position(hasIOIID);		
		
			FixMessage.getTagStringValue(buf, iOIID, 0, iOIID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasIOIID);		
					return null;		
				}		
			}		
			hasIOIID = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getQuoteID() { 		
		if ( hasQuoteID()) {		
			if (hasQuoteID == FixUtils.TAG_HAS_VALUE) {		
				return quoteID; 		
			} else {		
		
				buf.position(hasQuoteID);		
		
			FixMessage.getTagStringValue(buf, quoteID, 0, quoteID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasQuoteID);		
					return null;		
				}		
			}		
			hasQuoteID = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getRefOrderID() { 		
		if ( hasRefOrderID()) {		
			if (hasRefOrderID == FixUtils.TAG_HAS_VALUE) {		
				return refOrderID; 		
			} else {		
		
				buf.position(hasRefOrderID);		
		
			FixMessage.getTagStringValue(buf, refOrderID, 0, refOrderID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRefOrderID);		
					return null;		
				}		
			}		
			hasRefOrderID = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte getRefOrderIDSource() { 		
		if ( hasRefOrderIDSource()) {		
			if (hasRefOrderIDSource == FixUtils.TAG_HAS_VALUE) {		
				return refOrderIDSource; 		
			} else {		
		
				buf.position(hasRefOrderIDSource);		
		
			refOrderIDSource = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (refOrderIDSource != (byte)'3') && (refOrderIDSource != (byte)'2') && (refOrderIDSource != (byte)'1') && (refOrderIDSource != (byte)'0') && (refOrderIDSource != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1081);		
				if (err.hasError()) {		
					buf.position(hasRefOrderIDSource);		
					return (byte)'0';		
				}		
			}		
			hasRefOrderIDSource = FixUtils.TAG_HAS_VALUE;		
			return refOrderIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasRefOrderIDSource() { return hasRefOrderIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefOrderIDSource(byte src) {		
		refOrderIDSource = src;
		hasRefOrderIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefOrderIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasRefOrderIDSource()) refOrderIDSource = (byte)' ';		
		refOrderIDSource = src[0];		
		hasRefOrderIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefOrderIDSource(String str) {		
		if (str == null ) return;
		if (hasRefOrderIDSource()) refOrderIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		refOrderIDSource = src[0];		
		hasRefOrderIDSource = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasTimeInForce);		
					return (byte)'0';		
				}		
			}		
			hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
			return timeInForce;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTimeInForce() { return hasTimeInForce != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTimeInForce(byte src) {		
		timeInForce = src;
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeInForce(byte[] src) {		
		if (src == null ) return;
		if (hasTimeInForce()) timeInForce = (byte)' ';		
		timeInForce = src[0];		
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTimeInForce(String str) {		
		if (str == null ) return;
		if (hasTimeInForce()) timeInForce = (byte)' ';		
		byte[] src = str.getBytes(); 		
		timeInForce = src[0];		
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEffectiveTime() { 		
		if ( hasEffectiveTime()) {		
			if (hasEffectiveTime == FixUtils.TAG_HAS_VALUE) {		
				return effectiveTime; 		
			} else {		
		
				buf.position(hasEffectiveTime);		
		
			FixMessage.getTagStringValue(buf, effectiveTime, 0, effectiveTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEffectiveTime);		
					return null;		
				}		
			}		
			hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getExpireDate() { 		
		if ( hasExpireDate()) {		
			if (hasExpireDate == FixUtils.TAG_HAS_VALUE) {		
				return expireDate; 		
			} else {		
		
				buf.position(hasExpireDate);		
		
			FixMessage.getTagStringValue(buf, expireDate, 0, expireDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasExpireDate);		
					return null;		
				}		
			}		
			hasExpireDate = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getExpireTime() { 		
		if ( hasExpireTime()) {		
			if (hasExpireTime == FixUtils.TAG_HAS_VALUE) {		
				return expireTime; 		
			} else {		
		
				buf.position(hasExpireTime);		
		
			FixMessage.getTagStringValue(buf, expireTime, 0, expireTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasExpireTime);		
					return null;		
				}		
			}		
			hasExpireTime = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getGTBookingInst() { 		
		if ( hasGTBookingInst()) {		
			if (hasGTBookingInst == FixUtils.TAG_HAS_VALUE) {		
				return gTBookingInst; 		
			} else {		
		
				buf.position(hasGTBookingInst);		
		
			gTBookingInst = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasGTBookingInst);		
					return 0;		
				}		
			}		
			hasGTBookingInst = FixUtils.TAG_HAS_VALUE;		
			return gTBookingInst;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasGTBookingInst() { return hasGTBookingInst != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setGTBookingInst(long src) {		
		gTBookingInst = src;
		hasGTBookingInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setGTBookingInst(byte[] src) {		
		if (src == null ) return;
		if (hasGTBookingInst()) gTBookingInst = FixUtils.TAG_HAS_NO_VALUE;		
		gTBookingInst = FixUtils.longValueOf(src, 0, src.length);
		hasGTBookingInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setGTBookingInst(String str) {		
		if (str == null ) return;
		if (hasGTBookingInst()) gTBookingInst = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		gTBookingInst = FixUtils.longValueOf(src, 0, src.length);
		hasGTBookingInst = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasOrderCapacity);		
					return (byte)'0';		
				}		
			}		
			hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
			return orderCapacity;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrderCapacity() { return hasOrderCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderCapacity(byte src) {		
		orderCapacity = src;
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasOrderCapacity()) orderCapacity = (byte)' ';		
		orderCapacity = src[0];		
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderCapacity(String str) {		
		if (str == null ) return;
		if (hasOrderCapacity()) orderCapacity = (byte)' ';		
		byte[] src = str.getBytes(); 		
		orderCapacity = src[0];		
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOrderRestrictions() { 		
		if ( hasOrderRestrictions()) {		
			if (hasOrderRestrictions == FixUtils.TAG_HAS_VALUE) {		
				return orderRestrictions; 		
			} else {		
		
				buf.position(hasOrderRestrictions);		
		
			FixMessage.getTagStringValue(buf, orderRestrictions, 0, orderRestrictions.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderRestrictions);		
					return null;		
				}		
			}		
			hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
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
			
	public boolean getPreTradeAnonymity() { 		
		if ( hasPreTradeAnonymity()) {		
			if (hasPreTradeAnonymity == FixUtils.TAG_HAS_VALUE) {		
				return preTradeAnonymity; 		
			} else {		
		
				buf.position(hasPreTradeAnonymity);		
		
			preTradeAnonymity = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasPreTradeAnonymity);		
					return false;		
				}		
			}		
			hasPreTradeAnonymity = FixUtils.TAG_HAS_VALUE;		
			return preTradeAnonymity;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasPreTradeAnonymity() { return hasPreTradeAnonymity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPreTradeAnonymity(boolean src) {		
		preTradeAnonymity = src;
		hasPreTradeAnonymity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPreTradeAnonymity(byte[] src) {		
		if (src == null ) return;
		if (hasPreTradeAnonymity()) preTradeAnonymity = false;		
		preTradeAnonymity = src[0]==(byte)'Y'?true:false;		
		hasPreTradeAnonymity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPreTradeAnonymity(String str) {		
		if (str == null ) return;
		if (hasPreTradeAnonymity()) preTradeAnonymity = false;		
		byte[] src = str.getBytes(); 		
		preTradeAnonymity = src[0]==(byte)'Y'?true:false;		
		hasPreTradeAnonymity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getCustOrderCapacity() { 		
		if ( hasCustOrderCapacity()) {		
			if (hasCustOrderCapacity == FixUtils.TAG_HAS_VALUE) {		
				return custOrderCapacity; 		
			} else {		
		
				buf.position(hasCustOrderCapacity);		
		
			custOrderCapacity = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasCustOrderCapacity);		
					return 0;		
				}		
			}		
			hasCustOrderCapacity = FixUtils.TAG_HAS_VALUE;		
			return custOrderCapacity;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCustOrderCapacity() { return hasCustOrderCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCustOrderCapacity(long src) {		
		custOrderCapacity = src;
		hasCustOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCustOrderCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasCustOrderCapacity()) custOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		custOrderCapacity = FixUtils.longValueOf(src, 0, src.length);
		hasCustOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCustOrderCapacity(String str) {		
		if (str == null ) return;
		if (hasCustOrderCapacity()) custOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		custOrderCapacity = FixUtils.longValueOf(src, 0, src.length);
		hasCustOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getForexReq() { 		
		if ( hasForexReq()) {		
			if (hasForexReq == FixUtils.TAG_HAS_VALUE) {		
				return forexReq; 		
			} else {		
		
				buf.position(hasForexReq);		
		
			forexReq = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasForexReq);		
					return false;		
				}		
			}		
			hasForexReq = FixUtils.TAG_HAS_VALUE;		
			return forexReq;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasForexReq() { return hasForexReq != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setForexReq(boolean src) {		
		forexReq = src;
		hasForexReq = FixUtils.TAG_HAS_VALUE;		
	}

	public void setForexReq(byte[] src) {		
		if (src == null ) return;
		if (hasForexReq()) forexReq = false;		
		forexReq = src[0]==(byte)'Y'?true:false;		
		hasForexReq = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setForexReq(String str) {		
		if (str == null ) return;
		if (hasForexReq()) forexReq = false;		
		byte[] src = str.getBytes(); 		
		forexReq = src[0]==(byte)'Y'?true:false;		
		hasForexReq = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSettlCurrency() { 		
		if ( hasSettlCurrency()) {		
			if (hasSettlCurrency == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrency; 		
			} else {		
		
				buf.position(hasSettlCurrency);		
		
			FixMessage.getTagStringValue(buf, settlCurrency, 0, settlCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlCurrency);		
					return null;		
				}		
			}		
			hasSettlCurrency = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getBookingType() { 		
		if ( hasBookingType()) {		
			if (hasBookingType == FixUtils.TAG_HAS_VALUE) {		
				return bookingType; 		
			} else {		
		
				buf.position(hasBookingType);		
		
			bookingType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBookingType);		
					return 0;		
				}		
			}		
			hasBookingType = FixUtils.TAG_HAS_VALUE;		
			return bookingType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBookingType() { return hasBookingType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBookingType(long src) {		
		bookingType = src;
		hasBookingType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBookingType(byte[] src) {		
		if (src == null ) return;
		if (hasBookingType()) bookingType = FixUtils.TAG_HAS_NO_VALUE;		
		bookingType = FixUtils.longValueOf(src, 0, src.length);
		hasBookingType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBookingType(String str) {		
		if (str == null ) return;
		if (hasBookingType()) bookingType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bookingType = FixUtils.longValueOf(src, 0, src.length);
		hasBookingType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getText() { 		
		if ( hasText()) {		
			if (hasText == FixUtils.TAG_HAS_VALUE) {		
				return text; 		
			} else {		
		
				buf.position(hasText);		
		
			FixMessage.getTagStringValue(buf, text, 0, text.length, err);
		
				if (err.hasError()) {		
					buf.position(hasText);		
					return null;		
				}		
			}		
			hasText = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getEncodedTextLen() { 		
		if ( hasEncodedTextLen()) {		
			if (hasEncodedTextLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedTextLen; 		
			} else {		
		
				buf.position(hasEncodedTextLen);		
		
			encodedTextLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedTextLen);		
					return 0;		
				}		
			}		
			hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
			return encodedTextLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedTextLen() { return hasEncodedTextLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedTextLen(long src) {		
		encodedTextLen = src;
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedTextLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedTextLen(String str) {		
		if (str == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedText() { 		
		if ( hasEncodedText()) {		
			if (hasEncodedText == FixUtils.TAG_HAS_VALUE) {		
				return encodedText; 		
			} else {		
		
				buf.position(hasEncodedText);		
		
			FixMessage.getTagStringValue(buf, encodedText, 0, encodedText.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedText);		
					return null;		
				}		
			}		
			hasEncodedText = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getSettlDate2() { 		
		if ( hasSettlDate2()) {		
			if (hasSettlDate2 == FixUtils.TAG_HAS_VALUE) {		
				return settlDate2; 		
			} else {		
		
				buf.position(hasSettlDate2);		
		
			FixMessage.getTagStringValue(buf, settlDate2, 0, settlDate2.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlDate2);		
					return null;		
				}		
			}		
			hasSettlDate2 = FixUtils.TAG_HAS_VALUE;		
			return settlDate2;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlDate2() { return hasSettlDate2 != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlDate2(byte[] src) {		
		if (src == null ) return;
		if (hasSettlDate2()) FixUtils.fillNul(settlDate2);		
		FixUtils.copy(settlDate2, src); 		
		hasSettlDate2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlDate2(String str) {		
		if (str == null ) return;
		if (hasSettlDate2()) FixUtils.fillNul(settlDate2);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlDate2, src); 		
		hasSettlDate2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOrderQty2() { 		
		if ( hasOrderQty2()) {		
			if (hasOrderQty2 == FixUtils.TAG_HAS_VALUE) {		
				return orderQty2; 		
			} else {		
		
				buf.position(hasOrderQty2);		
		
			orderQty2 = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderQty2);		
					return 0;		
				}		
			}		
			hasOrderQty2 = FixUtils.TAG_HAS_VALUE;		
			return orderQty2;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrderQty2() { return hasOrderQty2 != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderQty2(long src) {		
		orderQty2 = src;
		hasOrderQty2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderQty2(byte[] src) {		
		if (src == null ) return;
		if (hasOrderQty2()) orderQty2 = FixUtils.TAG_HAS_NO_VALUE;		
		orderQty2 = FixUtils.longValueOf(src, 0, src.length);
		hasOrderQty2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderQty2(String str) {		
		if (str == null ) return;
		if (hasOrderQty2()) orderQty2 = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		orderQty2 = FixUtils.longValueOf(src, 0, src.length);
		hasOrderQty2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPrice2() { 		
		if ( hasPrice2()) {		
			if (hasPrice2 == FixUtils.TAG_HAS_VALUE) {		
				return price2; 		
			} else {		
		
				buf.position(hasPrice2);		
		
			price2 = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPrice2);		
					return 0;		
				}		
			}		
			hasPrice2 = FixUtils.TAG_HAS_VALUE;		
			return price2;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPrice2() { return hasPrice2 != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPrice2(long src) {		
		price2 = src;
		hasPrice2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice2(byte[] src) {		
		if (src == null ) return;
		if (hasPrice2()) price2 = FixUtils.TAG_HAS_NO_VALUE;		
		price2 = FixUtils.longValueOf(src, 0, src.length);
		hasPrice2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPrice2(String str) {		
		if (str == null ) return;
		if (hasPrice2()) price2 = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		price2 = FixUtils.longValueOf(src, 0, src.length);
		hasPrice2 = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasPositionEffect);		
					return (byte)'0';		
				}		
			}		
			hasPositionEffect = FixUtils.TAG_HAS_VALUE;		
			return positionEffect;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasPositionEffect() { return hasPositionEffect != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPositionEffect(byte src) {		
		positionEffect = src;
		hasPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPositionEffect(byte[] src) {		
		if (src == null ) return;
		if (hasPositionEffect()) positionEffect = (byte)' ';		
		positionEffect = src[0];		
		hasPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPositionEffect(String str) {		
		if (str == null ) return;
		if (hasPositionEffect()) positionEffect = (byte)' ';		
		byte[] src = str.getBytes(); 		
		positionEffect = src[0];		
		hasPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getCoveredOrUncovered() { 		
		if ( hasCoveredOrUncovered()) {		
			if (hasCoveredOrUncovered == FixUtils.TAG_HAS_VALUE) {		
				return coveredOrUncovered; 		
			} else {		
		
				buf.position(hasCoveredOrUncovered);		
		
			coveredOrUncovered = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasCoveredOrUncovered);		
					return 0;		
				}		
			}		
			hasCoveredOrUncovered = FixUtils.TAG_HAS_VALUE;		
			return coveredOrUncovered;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCoveredOrUncovered() { return hasCoveredOrUncovered != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCoveredOrUncovered(long src) {		
		coveredOrUncovered = src;
		hasCoveredOrUncovered = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCoveredOrUncovered(byte[] src) {		
		if (src == null ) return;
		if (hasCoveredOrUncovered()) coveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;		
		coveredOrUncovered = FixUtils.longValueOf(src, 0, src.length);
		hasCoveredOrUncovered = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCoveredOrUncovered(String str) {		
		if (str == null ) return;
		if (hasCoveredOrUncovered()) coveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		coveredOrUncovered = FixUtils.longValueOf(src, 0, src.length);
		hasCoveredOrUncovered = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMaxShow() { 		
		if ( hasMaxShow()) {		
			if (hasMaxShow == FixUtils.TAG_HAS_VALUE) {		
				return maxShow; 		
			} else {		
		
				buf.position(hasMaxShow);		
		
			maxShow = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMaxShow);		
					return 0;		
				}		
			}		
			hasMaxShow = FixUtils.TAG_HAS_VALUE;		
			return maxShow;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxShow() { return hasMaxShow != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMaxShow(long src) {		
		maxShow = src;
		hasMaxShow = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxShow(byte[] src) {		
		if (src == null ) return;
		if (hasMaxShow()) maxShow = FixUtils.TAG_HAS_NO_VALUE;		
		maxShow = FixUtils.longValueOf(src, 0, src.length);
		hasMaxShow = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMaxShow(String str) {		
		if (str == null ) return;
		if (hasMaxShow()) maxShow = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxShow = FixUtils.longValueOf(src, 0, src.length);
		hasMaxShow = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTargetStrategy() { 		
		if ( hasTargetStrategy()) {		
			if (hasTargetStrategy == FixUtils.TAG_HAS_VALUE) {		
				return targetStrategy; 		
			} else {		
		
				buf.position(hasTargetStrategy);		
		
			targetStrategy = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTargetStrategy);		
					return 0;		
				}		
			}		
			hasTargetStrategy = FixUtils.TAG_HAS_VALUE;		
			return targetStrategy;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTargetStrategy() { return hasTargetStrategy != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTargetStrategy(long src) {		
		targetStrategy = src;
		hasTargetStrategy = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTargetStrategy(byte[] src) {		
		if (src == null ) return;
		if (hasTargetStrategy()) targetStrategy = FixUtils.TAG_HAS_NO_VALUE;		
		targetStrategy = FixUtils.longValueOf(src, 0, src.length);
		hasTargetStrategy = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTargetStrategy(String str) {		
		if (str == null ) return;
		if (hasTargetStrategy()) targetStrategy = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		targetStrategy = FixUtils.longValueOf(src, 0, src.length);
		hasTargetStrategy = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTargetStrategyParameters() { 		
		if ( hasTargetStrategyParameters()) {		
			if (hasTargetStrategyParameters == FixUtils.TAG_HAS_VALUE) {		
				return targetStrategyParameters; 		
			} else {		
		
				buf.position(hasTargetStrategyParameters);		
		
			FixMessage.getTagStringValue(buf, targetStrategyParameters, 0, targetStrategyParameters.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTargetStrategyParameters);		
					return null;		
				}		
			}		
			hasTargetStrategyParameters = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getParticipationRate() { 		
		if ( hasParticipationRate()) {		
			if (hasParticipationRate == FixUtils.TAG_HAS_VALUE) {		
				return participationRate; 		
			} else {		
		
				buf.position(hasParticipationRate);		
		
			participationRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasParticipationRate);		
					return 0;		
				}		
			}		
			hasParticipationRate = FixUtils.TAG_HAS_VALUE;		
			return participationRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasParticipationRate() { return hasParticipationRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setParticipationRate(long src) {		
		participationRate = src;
		hasParticipationRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setParticipationRate(byte[] src) {		
		if (src == null ) return;
		if (hasParticipationRate()) participationRate = FixUtils.TAG_HAS_NO_VALUE;		
		participationRate = FixUtils.longValueOf(src, 0, src.length);
		hasParticipationRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setParticipationRate(String str) {		
		if (str == null ) return;
		if (hasParticipationRate()) participationRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		participationRate = FixUtils.longValueOf(src, 0, src.length);
		hasParticipationRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDesignation() { 		
		if ( hasDesignation()) {		
			if (hasDesignation == FixUtils.TAG_HAS_VALUE) {		
				return designation; 		
			} else {		
		
				buf.position(hasDesignation);		
		
			FixMessage.getTagStringValue(buf, designation, 0, designation.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDesignation);		
					return null;		
				}		
			}		
			hasDesignation = FixUtils.TAG_HAS_VALUE;		
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
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasSecondaryClOrdID()) s += "SecondaryClOrdID(526)= " + new String( FixUtils.trim(getSecondaryClOrdID()) ) + "\n" ; 
		if (hasListSeqNo()) s += "ListSeqNo(67)= " + getListSeqNo() + "\n" ; 
		if (hasClOrdLinkID()) s += "ClOrdLinkID(583)= " + new String( FixUtils.trim(getClOrdLinkID()) ) + "\n" ; 
		if (hasSettlInstMode()) s += "SettlInstMode(160)= " + getSettlInstMode() + "\n" ; 
		if (hasTradeOriginationDate()) s += "TradeOriginationDate(229)= " + new String( FixUtils.trim(getTradeOriginationDate()) ) + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAcctIDSource()) s += "AcctIDSource(660)= " + getAcctIDSource() + "\n" ; 
		if (hasAccountType()) s += "AccountType(581)= " + getAccountType() + "\n" ; 
		if (hasDayBookingInst()) s += "DayBookingInst(589)= " + getDayBookingInst() + "\n" ; 
		if (hasBookingUnit()) s += "BookingUnit(590)= " + getBookingUnit() + "\n" ; 
		if (hasAllocID()) s += "AllocID(70)= " + new String( FixUtils.trim(getAllocID()) ) + "\n" ; 
		if (hasPreallocMethod()) s += "PreallocMethod(591)= " + getPreallocMethod() + "\n" ; 
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
		if (hasPrevClosePx()) s += "PrevClosePx(140)= " + getPrevClosePx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasSideValueInd()) s += "SideValueInd(401)= " + getSideValueInd() + "\n" ; 
		if (hasLocateReqd()) s += "LocateReqd(114)= " + getLocateReqd() + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasQtyType()) s += "QtyType(854)= " + getQtyType() + "\n" ; 
		if (hasOrdType()) s += "OrdType(40)= " + getOrdType() + "\n" ; 
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
		if (hasSettlDate2()) s += "SettlDate2(193)= " + new String( FixUtils.trim(getSettlDate2()) ) + "\n" ; 
		if (hasOrderQty2()) s += "OrderQty2(192)= " + getOrderQty2() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPrice2()) s += "Price2(640)= " + getPrice2() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPositionEffect()) s += "PositionEffect(77)= " + getPositionEffect() + "\n" ; 
		if (hasCoveredOrUncovered()) s += "CoveredOrUncovered(203)= " + getCoveredOrUncovered() + "\n" ; 
		if (hasMaxShow()) s += "MaxShow(210)= " + getMaxShow() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTargetStrategy()) s += "TargetStrategy(847)= " + getTargetStrategy() + "\n" ; 
		if (hasTargetStrategyParameters()) s += "TargetStrategyParameters(848)= " + new String( FixUtils.trim(getTargetStrategyParameters()) ) + "\n" ; 
		if (hasParticipationRate()) s += "ParticipationRate(849)= " + getParticipationRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDesignation()) s += "Designation(494)= " + new String( FixUtils.trim(getDesignation()) ) + "\n" ; 

		for (FixParties fixParties : parties) fixParties.toString();
		for (FixPreAllocGrp fixPreAllocGrp : preAllocGrp) fixPreAllocGrp.toString();
		s += displayInstruction.toString();
		for (FixTrdgSesGrp fixTrdgSesGrp : trdgSesGrp) fixTrdgSesGrp.toString();
		s += instrument.toString();
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.toString();
		for (FixStipulations fixStipulations : stipulations) fixStipulations.toString();
		s += orderQtyData.toString();
		s += triggeringInstruction.toString();
		s += spreadOrBenchmarkCurveData.toString();
		s += yieldData.toString();
		s += commissionData.toString();
		s += pegInstructions.toString();
		s += discretionInstructions.toString();
		for (FixStrategyParametersGrp fixStrategyParametersGrp : strategyParametersGrp) fixStrategyParametersGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixListOrdGrp)) return false;

		FixListOrdGrp msg = (FixListOrdGrp) o;

		for (int i = 0; i < parties.length; i++)
			if (!parties[i].equals(msg.parties[i])) return false;
		for (int i = 0; i < preAllocGrp.length; i++)
			if (!preAllocGrp[i].equals(msg.preAllocGrp[i])) return false;
		if (!displayInstruction.equals(msg.displayInstruction)) return false;
		for (int i = 0; i < trdgSesGrp.length; i++)
			if (!trdgSesGrp[i].equals(msg.trdgSesGrp[i])) return false;
		if (!instrument.equals(msg.instrument)) return false;
		for (int i = 0; i < undInstrmtGrp.length; i++)
			if (!undInstrmtGrp[i].equals(msg.undInstrmtGrp[i])) return false;
		for (int i = 0; i < stipulations.length; i++)
			if (!stipulations[i].equals(msg.stipulations[i])) return false;
		if (!orderQtyData.equals(msg.orderQtyData)) return false;
		if (!triggeringInstruction.equals(msg.triggeringInstruction)) return false;
		if (!spreadOrBenchmarkCurveData.equals(msg.spreadOrBenchmarkCurveData)) return false;
		if (!yieldData.equals(msg.yieldData)) return false;
		if (!commissionData.equals(msg.commissionData)) return false;
		if (!pegInstructions.equals(msg.pegInstructions)) return false;
		if (!discretionInstructions.equals(msg.discretionInstructions)) return false;
		for (int i = 0; i < strategyParametersGrp.length; i++)
			if (!strategyParametersGrp[i].equals(msg.strategyParametersGrp[i])) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) || (!hasSecondaryClOrdID() && msg.hasSecondaryClOrdID())) return false;
		if (!(!hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) && !FixUtils.equals(getSecondaryClOrdID(), msg.getSecondaryClOrdID())) return false;
		if ((hasListSeqNo() && !msg.hasListSeqNo()) || (!hasListSeqNo() && msg.hasListSeqNo())) return false;
		if (!(!hasListSeqNo() && !msg.hasListSeqNo()) && !(getListSeqNo()==msg.getListSeqNo())) return false;
		if ((hasClOrdLinkID() && !msg.hasClOrdLinkID()) || (!hasClOrdLinkID() && msg.hasClOrdLinkID())) return false;
		if (!(!hasClOrdLinkID() && !msg.hasClOrdLinkID()) && !FixUtils.equals(getClOrdLinkID(), msg.getClOrdLinkID())) return false;
		if ((hasSettlInstMode() && !msg.hasSettlInstMode()) || (!hasSettlInstMode() && msg.hasSettlInstMode())) return false;
		if (!(!hasSettlInstMode() && !msg.hasSettlInstMode()) && !(getSettlInstMode()==msg.getSettlInstMode())) return false;
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
		if ((hasAllocID() && !msg.hasAllocID()) || (!hasAllocID() && msg.hasAllocID())) return false;
		if (!(!hasAllocID() && !msg.hasAllocID()) && !FixUtils.equals(getAllocID(), msg.getAllocID())) return false;
		if ((hasPreallocMethod() && !msg.hasPreallocMethod()) || (!hasPreallocMethod() && msg.hasPreallocMethod())) return false;
		if (!(!hasPreallocMethod() && !msg.hasPreallocMethod()) && !(getPreallocMethod()==msg.getPreallocMethod())) return false;
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
		if ((hasPrevClosePx() && !msg.hasPrevClosePx()) || (!hasPrevClosePx() && msg.hasPrevClosePx())) return false;
		if (!(!hasPrevClosePx() && !msg.hasPrevClosePx()) && !(getPrevClosePx()==msg.getPrevClosePx())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasSideValueInd() && !msg.hasSideValueInd()) || (!hasSideValueInd() && msg.hasSideValueInd())) return false;
		if (!(!hasSideValueInd() && !msg.hasSideValueInd()) && !(getSideValueInd()==msg.getSideValueInd())) return false;
		if ((hasLocateReqd() && !msg.hasLocateReqd()) || (!hasLocateReqd() && msg.hasLocateReqd())) return false;
		if (!(!hasLocateReqd() && !msg.hasLocateReqd()) && !(getLocateReqd()==msg.getLocateReqd())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasQtyType() && !msg.hasQtyType()) || (!hasQtyType() && msg.hasQtyType())) return false;
		if (!(!hasQtyType() && !msg.hasQtyType()) && !(getQtyType()==msg.getQtyType())) return false;
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
		if ((hasSettlDate2() && !msg.hasSettlDate2()) || (!hasSettlDate2() && msg.hasSettlDate2())) return false;
		if ((hasOrderQty2() && !msg.hasOrderQty2()) || (!hasOrderQty2() && msg.hasOrderQty2())) return false;
		if (!(!hasOrderQty2() && !msg.hasOrderQty2()) && !(getOrderQty2()==msg.getOrderQty2())) return false;
		if ((hasPrice2() && !msg.hasPrice2()) || (!hasPrice2() && msg.hasPrice2())) return false;
		if (!(!hasPrice2() && !msg.hasPrice2()) && !(getPrice2()==msg.getPrice2())) return false;
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
		if ((hasParticipationRate() && !msg.hasParticipationRate()) || (!hasParticipationRate() && msg.hasParticipationRate())) return false;
		if (!(!hasParticipationRate() && !msg.hasParticipationRate()) && !(getParticipationRate()==msg.getParticipationRate())) return false;
		if ((hasDesignation() && !msg.hasDesignation()) || (!hasDesignation() && msg.hasDesignation())) return false;
		if (!(!hasDesignation() && !msg.hasDesignation()) && !FixUtils.equals(getDesignation(), msg.getDesignation())) return false;
		return true;
	}
	public FixListOrdGrp clone ( FixListOrdGrp out ) {
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasSecondaryClOrdID())
			out.setSecondaryClOrdID(getSecondaryClOrdID());
		if ( hasListSeqNo())
			out.setListSeqNo(getListSeqNo());
		if ( hasClOrdLinkID())
			out.setClOrdLinkID(getClOrdLinkID());
		if ( hasSettlInstMode())
			out.setSettlInstMode(getSettlInstMode());
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
		if ( hasAllocID())
			out.setAllocID(getAllocID());
		if ( hasPreallocMethod())
			out.setPreallocMethod(getPreallocMethod());
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
		if ( hasPrevClosePx())
			out.setPrevClosePx(getPrevClosePx());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasSideValueInd())
			out.setSideValueInd(getSideValueInd());
		if ( hasLocateReqd())
			out.setLocateReqd(getLocateReqd());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasQtyType())
			out.setQtyType(getQtyType());
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
		if ( hasSettlDate2())
			out.setSettlDate2(getSettlDate2());
		if ( hasOrderQty2())
			out.setOrderQty2(getOrderQty2());
		if ( hasPrice2())
			out.setPrice2(getPrice2());
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
		if ( hasParticipationRate())
			out.setParticipationRate(getParticipationRate());
		if ( hasDesignation())
			out.setDesignation(getDesignation());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixPreAllocGrp fixPreAllocGrp : preAllocGrp) {
			if (!fixPreAllocGrp.hasGroup()) continue;
			out.preAllocGrp[count] = fixPreAllocGrp.clone( out.preAllocGrp[count] );
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
		for (FixStipulations fixStipulations : stipulations) {
			if (!fixStipulations.hasGroup()) continue;
			out.stipulations[count] = fixStipulations.clone( out.stipulations[count] );
			count++;
		}
		if (orderQtyData.hasGroup())
			out.orderQtyData = orderQtyData.clone( out.orderQtyData);
		if (triggeringInstruction.hasGroup())
			out.triggeringInstruction = triggeringInstruction.clone( out.triggeringInstruction);
		if (spreadOrBenchmarkCurveData.hasGroup())
			out.spreadOrBenchmarkCurveData = spreadOrBenchmarkCurveData.clone( out.spreadOrBenchmarkCurveData);
		if (yieldData.hasGroup())
			out.yieldData = yieldData.clone( out.yieldData);
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
