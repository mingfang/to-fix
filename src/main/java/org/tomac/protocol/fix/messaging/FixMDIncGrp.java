package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixMDIncGrp extends FixGroup {
	private short hasMDUpdateAction;
	byte mDUpdateAction = (byte)' ';		
	private short hasDeleteReason;
	byte deleteReason = (byte)' ';		
	private short hasMDSubBookType;
	long mDSubBookType = 0;		
	private short hasMarketDepth;
	long marketDepth = 0;		
	private short hasMDEntryType;
	byte mDEntryType = (byte)' ';		
	private short hasMDEntryID;
	byte[] mDEntryID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDEntryRefID;
	byte[] mDEntryRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDStreamID;
	byte[] mDStreamID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasFinancialStatus;
	byte[] financialStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCorporateAction;
	byte[] corporateAction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDEntryPx;
	long mDEntryPx = 0;		
	private short hasOrdType;
	byte ordType = (byte)' ';		
	private short hasPriceType;
	long priceType = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasSettlCurrency;
	byte[] settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasMDEntrySize;
	long mDEntrySize = 0;		
	private short hasLotType;
	byte lotType = (byte)' ';		
	private short hasMDEntryDate;
	byte[] mDEntryDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDEntryTime;
	byte[] mDEntryTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTickDirection;
	byte tickDirection = (byte)' ';		
	private short hasMDMkt;
	byte[] mDMkt = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityTradingStatus;
	long securityTradingStatus = 0;		
	private short hasHaltReason;
	long haltReason = 0;		
	private short hasQuoteCondition;
	byte[] quoteCondition = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeCondition;
	byte[] tradeCondition = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTrdType;
	long trdType = 0;		
	private short hasMatchType;
	byte[] matchType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDEntryOriginator;
	byte[] mDEntryOriginator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLocationID;
	byte[] locationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDeskID;
	byte[] deskID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOpenCloseSettlFlag;
	byte[] openCloseSettlFlag = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTimeInForce;
	byte timeInForce = (byte)' ';		
	private short hasExpireDate;
	byte[] expireDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExpireTime;
	byte[] expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasMinQty;
	long minQty = 0;		
	private short hasExecInst;
	byte[] execInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSellerDays;
	long sellerDays = 0;		
	private short hasOrderID;
	byte[] orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryOrderID;
	byte[] secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteEntryID;
	byte[] quoteEntryID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeID;
	byte[] tradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDEntryBuyer;
	byte[] mDEntryBuyer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDEntrySeller;
	byte[] mDEntrySeller = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNumberOfOrders;
	long numberOfOrders = 0;		
	private short hasMDEntryPositionNo;
	long mDEntryPositionNo = 0;		
	private short hasScope;
	byte[] scope = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPriceDelta;
	long priceDelta = 0;		
	private short hasNetChgPrevDay;
	long netChgPrevDay = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasOrderCapacity;
	byte orderCapacity = (byte)' ';		
	private short hasMDOriginType;
	long mDOriginType = 0;		
	private short hasHighPx;
	long highPx = 0;		
	private short hasLowPx;
	long lowPx = 0;		
	private short hasTradeVolume;
	long tradeVolume = 0;		
	private short hasSettlType;
	byte[] settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlDate;
	byte[] settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDQuoteType;
	long mDQuoteType = 0;		
	private short hasRptSeq;
	long rptSeq = 0;		
	private short hasMDPriceLevel;
	long mDPriceLevel = 0;		
	private short hasTransBkdTime;
	byte[] transBkdTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasFirstPx;
	long firstPx = 0;		
	private short hasLastPx;
	long lastPx = 0;		
	private short hasDealingCapacity;
	byte dealingCapacity = (byte)' ';		
	private short hasMDEntrySpotRate;
	long mDEntrySpotRate = 0;		
	private short hasMDEntryForwardPoints;
	long mDEntryForwardPoints = 0;		
		public FixInstrument instrument;
		public FixUndInstrmtGrp[] undInstrmtGrp;
		public FixInstrmtLegGrp[] instrmtLegGrp;
		public FixYieldData yieldData;
		public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
		public FixRateSource[] rateSource;
		public FixSecSizesGrp[] secSizesGrp;
		public FixParties[] parties;
		public FixStatsIndGrp[] statsIndGrp;
	
	public FixMDIncGrp() {
		this(false);
	}

	public FixMDIncGrp(boolean isRequired) {
		super(FixTags.MDUPDATEACTION_INT);

		this.isRequired = isRequired;
		
		hasMDUpdateAction = FixUtils.TAG_HAS_NO_VALUE;		
		hasDeleteReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDSubBookType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMarketDepth = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDEntryType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDEntryID = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntryID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDEntryRefID = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntryRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDStreamID = FixUtils.TAG_HAS_NO_VALUE;		
		mDStreamID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasFinancialStatus = FixUtils.TAG_HAS_NO_VALUE;		
		financialStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCorporateAction = FixUtils.TAG_HAS_NO_VALUE;		
		corporateAction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDEntryPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasMDEntrySize = FixUtils.TAG_HAS_NO_VALUE;		
		hasLotType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDEntryDate = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntryDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDEntryTime = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntryTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTickDirection = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDMkt = FixUtils.TAG_HAS_NO_VALUE;		
		mDMkt = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityTradingStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasHaltReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasQuoteCondition = FixUtils.TAG_HAS_NO_VALUE;		
		quoteCondition = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeCondition = FixUtils.TAG_HAS_NO_VALUE;		
		tradeCondition = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMatchType = FixUtils.TAG_HAS_NO_VALUE;		
		matchType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDEntryOriginator = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntryOriginator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLocationID = FixUtils.TAG_HAS_NO_VALUE;		
		locationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDeskID = FixUtils.TAG_HAS_NO_VALUE;		
		deskID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOpenCloseSettlFlag = FixUtils.TAG_HAS_NO_VALUE;		
		openCloseSettlFlag = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTimeInForce = FixUtils.TAG_HAS_NO_VALUE;		
		hasExpireDate = FixUtils.TAG_HAS_NO_VALUE;		
		expireDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;		
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasMinQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasExecInst = FixUtils.TAG_HAS_NO_VALUE;		
		execInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSellerDays = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteEntryID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteEntryID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDEntryBuyer = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntryBuyer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDEntrySeller = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntrySeller = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNumberOfOrders = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDEntryPositionNo = FixUtils.TAG_HAS_NO_VALUE;		
		hasScope = FixUtils.TAG_HAS_NO_VALUE;		
		scope = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPriceDelta = FixUtils.TAG_HAS_NO_VALUE;		
		hasNetChgPrevDay = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDOriginType = FixUtils.TAG_HAS_NO_VALUE;		
		hasHighPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLowPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeVolume = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDQuoteType = FixUtils.TAG_HAS_NO_VALUE;		
		hasRptSeq = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDPriceLevel = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransBkdTime = FixUtils.TAG_HAS_NO_VALUE;		
		transBkdTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasFirstPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasDealingCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDEntrySpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDEntryForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		instrument = new FixInstrument();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		yieldData = new FixYieldData();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		rateSource = new FixRateSource[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rateSource[i] = new FixRateSource();
		secSizesGrp = new FixSecSizesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) secSizesGrp[i] = new FixSecSizesGrp();
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		statsIndGrp = new FixStatsIndGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) statsIndGrp[i] = new FixStatsIndGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasMDUpdateAction()) return true;
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
            	case FixTags.MDUPDATEACTION_INT:		
            		hasMDUpdateAction = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DELETEREASON_INT:		
            		hasDeleteReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDSUBBOOKTYPE_INT:		
            		hasMDSubBookType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MARKETDEPTH_INT:		
            		hasMarketDepth = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYTYPE_INT:		
            		hasMDEntryType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYID_INT:		
            		hasMDEntryID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYREFID_INT:		
            		hasMDEntryRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDSTREAMID_INT:		
            		hasMDStreamID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.FINANCIALSTATUS_INT:		
            		hasFinancialStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CORPORATEACTION_INT:		
            		hasCorporateAction = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYPX_INT:		
            		hasMDEntryPx = (short) buf.position();		
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
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLCURRENCY_INT:		
            		hasSettlCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYSIZE_INT:		
            		hasMDEntrySize = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LOTTYPE_INT:		
            		hasLotType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYDATE_INT:		
            		hasMDEntryDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYTIME_INT:		
            		hasMDEntryTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TICKDIRECTION_INT:		
            		hasTickDirection = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDMKT_INT:		
            		hasMDMkt = (short) buf.position();		
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
            	case FixTags.SECURITYTRADINGSTATUS_INT:		
            		hasSecurityTradingStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.HALTREASON_INT:		
            		hasHaltReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.QUOTECONDITION_INT:		
            		hasQuoteCondition = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADECONDITION_INT:		
            		hasTradeCondition = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRDTYPE_INT:		
            		hasTrdType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MATCHTYPE_INT:		
            		hasMatchType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYORIGINATOR_INT:		
            		hasMDEntryOriginator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LOCATIONID_INT:		
            		hasLocationID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DESKID_INT:		
            		hasDeskID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.OPENCLOSESETTLFLAG_INT:		
            		hasOpenCloseSettlFlag = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TIMEINFORCE_INT:		
            		hasTimeInForce = (short) buf.position();		
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
            	case FixTags.MINQTY_INT:		
            		hasMinQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.EXECINST_INT:		
            		hasExecInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SELLERDAYS_INT:		
            		hasSellerDays = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERID_INT:		
            		hasOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYORDERID_INT:		
            		hasSecondaryOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.QUOTEENTRYID_INT:		
            		hasQuoteEntryID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADEID_INT:		
            		hasTradeID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYBUYER_INT:		
            		hasMDEntryBuyer = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYSELLER_INT:		
            		hasMDEntrySeller = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NUMBEROFORDERS_INT:		
            		hasNumberOfOrders = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYPOSITIONNO_INT:		
            		hasMDEntryPositionNo = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SCOPE_INT:		
            		hasScope = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PRICEDELTA_INT:		
            		hasPriceDelta = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NETCHGPREVDAY_INT:		
            		hasNetChgPrevDay = (short) buf.position();		
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
            	case FixTags.ORDERCAPACITY_INT:		
            		hasOrderCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDORIGINTYPE_INT:		
            		hasMDOriginType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.HIGHPX_INT:		
            		hasHighPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LOWPX_INT:		
            		hasLowPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADEVOLUME_INT:		
            		hasTradeVolume = (short) buf.position();		
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
            	case FixTags.MDQUOTETYPE_INT:		
            		hasMDQuoteType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RPTSEQ_INT:		
            		hasRptSeq = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDPRICELEVEL_INT:		
            		hasMDPriceLevel = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRANSBKDTIME_INT:		
            		hasTransBkdTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.FIRSTPX_INT:		
            		hasFirstPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LASTPX_INT:		
            		hasLastPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DEALINGCAPACITY_INT:		
            		hasDealingCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYSPOTRATE_INT:		
            		hasMDEntrySpotRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYFORWARDPOINTS_INT:		
            		hasMDEntryForwardPoints = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( instrument.isKeyTag(tag)) {
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
        			} else if ( tag == FixTags.NOLEGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( yieldData.isKeyTag(tag)) {
        				tag = yieldData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( spreadOrBenchmarkCurveData.isKeyTag(tag)) {
        				tag = spreadOrBenchmarkCurveData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NORATESOURCES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !rateSource[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = rateSource[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOOFSECSIZES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !secSizesGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = secSizesGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOPARTYIDS_INT ) {
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
        			} else if ( tag == FixTags.NOSTATSINDICATORS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !statsIndGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = statsIndGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		if (!hasMDUpdateAction()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag MDUpdateAction missing", FixTags.MDUPDATEACTION_INT);
			return false;
		}
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasMDUpdateAction = FixUtils.TAG_HAS_NO_VALUE;
		hasDeleteReason = FixUtils.TAG_HAS_NO_VALUE;
		hasMDSubBookType = FixUtils.TAG_HAS_NO_VALUE;
		hasMarketDepth = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntryType = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntryID = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntryRefID = FixUtils.TAG_HAS_NO_VALUE;
		hasMDStreamID = FixUtils.TAG_HAS_NO_VALUE;
		hasFinancialStatus = FixUtils.TAG_HAS_NO_VALUE;
		hasCorporateAction = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntryPx = FixUtils.TAG_HAS_NO_VALUE;
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntrySize = FixUtils.TAG_HAS_NO_VALUE;
		hasLotType = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntryDate = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntryTime = FixUtils.TAG_HAS_NO_VALUE;
		hasTickDirection = FixUtils.TAG_HAS_NO_VALUE;
		hasMDMkt = FixUtils.TAG_HAS_NO_VALUE;
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityTradingStatus = FixUtils.TAG_HAS_NO_VALUE;
		hasHaltReason = FixUtils.TAG_HAS_NO_VALUE;
		hasQuoteCondition = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeCondition = FixUtils.TAG_HAS_NO_VALUE;
		hasTrdType = FixUtils.TAG_HAS_NO_VALUE;
		hasMatchType = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntryOriginator = FixUtils.TAG_HAS_NO_VALUE;
		hasLocationID = FixUtils.TAG_HAS_NO_VALUE;
		hasDeskID = FixUtils.TAG_HAS_NO_VALUE;
		hasOpenCloseSettlFlag = FixUtils.TAG_HAS_NO_VALUE;
		hasTimeInForce = FixUtils.TAG_HAS_NO_VALUE;
		hasExpireDate = FixUtils.TAG_HAS_NO_VALUE;
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;
		hasMinQty = FixUtils.TAG_HAS_NO_VALUE;
		hasExecInst = FixUtils.TAG_HAS_NO_VALUE;
		hasSellerDays = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryOrderID = FixUtils.TAG_HAS_NO_VALUE;
		hasQuoteEntryID = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeID = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntryBuyer = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntrySeller = FixUtils.TAG_HAS_NO_VALUE;
		hasNumberOfOrders = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntryPositionNo = FixUtils.TAG_HAS_NO_VALUE;
		hasScope = FixUtils.TAG_HAS_NO_VALUE;
		hasPriceDelta = FixUtils.TAG_HAS_NO_VALUE;
		hasNetChgPrevDay = FixUtils.TAG_HAS_NO_VALUE;
		hasText = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasMDOriginType = FixUtils.TAG_HAS_NO_VALUE;
		hasHighPx = FixUtils.TAG_HAS_NO_VALUE;
		hasLowPx = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeVolume = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;
		hasMDQuoteType = FixUtils.TAG_HAS_NO_VALUE;
		hasRptSeq = FixUtils.TAG_HAS_NO_VALUE;
		hasMDPriceLevel = FixUtils.TAG_HAS_NO_VALUE;
		hasTransBkdTime = FixUtils.TAG_HAS_NO_VALUE;
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;
		hasFirstPx = FixUtils.TAG_HAS_NO_VALUE;
		hasLastPx = FixUtils.TAG_HAS_NO_VALUE;
		hasDealingCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntrySpotRate = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntryForwardPoints = FixUtils.TAG_HAS_NO_VALUE;
		instrument.clear();
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.clear();
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.clear();
		yieldData.clear();
		spreadOrBenchmarkCurveData.clear();
		for (FixRateSource fixRateSource : rateSource) fixRateSource.clear();
		for (FixSecSizesGrp fixSecSizesGrp : secSizesGrp) fixSecSizesGrp.clear();
		for (FixParties fixParties : parties) fixParties.clear();
		for (FixStatsIndGrp fixStatsIndGrp : statsIndGrp) fixStatsIndGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasMDUpdateAction()) {		
			out.put(FixTags.MDUPDATEACTION);

			out.put((byte) '=');

			FixUtils.put(out,mDUpdateAction); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDeleteReason()) {		
			out.put(FixTags.DELETEREASON);

			out.put((byte) '=');

			FixUtils.put(out,deleteReason); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDSubBookType()) {		
			out.put(FixTags.MDSUBBOOKTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDSubBookType);
		
			out.put(FixUtils.SOH);

            }

		if (hasMarketDepth()) {		
			out.put(FixTags.MARKETDEPTH);

			out.put((byte) '=');

			FixUtils.put(out, (long)marketDepth);
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntryType()) {		
			out.put(FixTags.MDENTRYTYPE);

			out.put((byte) '=');

			FixUtils.put(out,mDEntryType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntryID()) {		
			out.put(FixTags.MDENTRYID);

			out.put((byte) '=');

			FixUtils.put(out,mDEntryID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntryRefID()) {		
			out.put(FixTags.MDENTRYREFID);

			out.put((byte) '=');

			FixUtils.put(out,mDEntryRefID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDStreamID()) {		
			out.put(FixTags.MDSTREAMID);

			out.put((byte) '=');

			FixUtils.put(out,mDStreamID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasFinancialStatus()) {		
			out.put(FixTags.FINANCIALSTATUS);

			out.put((byte) '=');

			FixUtils.put(out,financialStatus); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCorporateAction()) {		
			out.put(FixTags.CORPORATEACTION);

			out.put((byte) '=');

			FixUtils.put(out,corporateAction); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntryPx()) {		
			out.put(FixTags.MDENTRYPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDEntryPx);
		
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

		if (hasMDEntrySize()) {		
			out.put(FixTags.MDENTRYSIZE);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDEntrySize);
		
			out.put(FixUtils.SOH);

            }

		if (hasLotType()) {		
			out.put(FixTags.LOTTYPE);

			out.put((byte) '=');

			FixUtils.put(out,lotType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntryDate()) {		
			out.put(FixTags.MDENTRYDATE);

			out.put((byte) '=');

			FixUtils.put(out,mDEntryDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntryTime()) {		
			out.put(FixTags.MDENTRYTIME);

			out.put((byte) '=');

			FixUtils.put(out,mDEntryTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTickDirection()) {		
			out.put(FixTags.TICKDIRECTION);

			out.put((byte) '=');

			FixUtils.put(out,tickDirection); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDMkt()) {		
			out.put(FixTags.MDMKT);

			out.put((byte) '=');

			FixUtils.put(out,mDMkt); 		
		
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

		if (hasSecurityTradingStatus()) {		
			out.put(FixTags.SECURITYTRADINGSTATUS);

			out.put((byte) '=');

			FixUtils.put(out, (long)securityTradingStatus);
		
			out.put(FixUtils.SOH);

            }

		if (hasHaltReason()) {		
			out.put(FixTags.HALTREASON);

			out.put((byte) '=');

			FixUtils.put(out, (long)haltReason);
		
			out.put(FixUtils.SOH);

            }

		if (hasQuoteCondition()) {		
			out.put(FixTags.QUOTECONDITION);

			out.put((byte) '=');

			FixUtils.put(out,quoteCondition); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradeCondition()) {		
			out.put(FixTags.TRADECONDITION);

			out.put((byte) '=');

			FixUtils.put(out,tradeCondition); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTrdType()) {		
			out.put(FixTags.TRDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)trdType);
		
			out.put(FixUtils.SOH);

            }

		if (hasMatchType()) {		
			out.put(FixTags.MATCHTYPE);

			out.put((byte) '=');

			FixUtils.put(out,matchType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntryOriginator()) {		
			out.put(FixTags.MDENTRYORIGINATOR);

			out.put((byte) '=');

			FixUtils.put(out,mDEntryOriginator); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLocationID()) {		
			out.put(FixTags.LOCATIONID);

			out.put((byte) '=');

			FixUtils.put(out,locationID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDeskID()) {		
			out.put(FixTags.DESKID);

			out.put((byte) '=');

			FixUtils.put(out,deskID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOpenCloseSettlFlag()) {		
			out.put(FixTags.OPENCLOSESETTLFLAG);

			out.put((byte) '=');

			FixUtils.put(out,openCloseSettlFlag); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTimeInForce()) {		
			out.put(FixTags.TIMEINFORCE);

			out.put((byte) '=');

			FixUtils.put(out,timeInForce); 		
		
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

		if (hasMinQty()) {		
			out.put(FixTags.MINQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)minQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasExecInst()) {		
			out.put(FixTags.EXECINST);

			out.put((byte) '=');

			FixUtils.put(out,execInst); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSellerDays()) {		
			out.put(FixTags.SELLERDAYS);

			out.put((byte) '=');

			FixUtils.put(out, (long)sellerDays);
		
			out.put(FixUtils.SOH);

            }

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

		if (hasQuoteEntryID()) {		
			out.put(FixTags.QUOTEENTRYID);

			out.put((byte) '=');

			FixUtils.put(out,quoteEntryID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradeID()) {		
			out.put(FixTags.TRADEID);

			out.put((byte) '=');

			FixUtils.put(out,tradeID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntryBuyer()) {		
			out.put(FixTags.MDENTRYBUYER);

			out.put((byte) '=');

			FixUtils.put(out,mDEntryBuyer); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntrySeller()) {		
			out.put(FixTags.MDENTRYSELLER);

			out.put((byte) '=');

			FixUtils.put(out,mDEntrySeller); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNumberOfOrders()) {		
			out.put(FixTags.NUMBEROFORDERS);

			out.put((byte) '=');

			FixUtils.put(out, (long)numberOfOrders);
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntryPositionNo()) {		
			out.put(FixTags.MDENTRYPOSITIONNO);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDEntryPositionNo);
		
			out.put(FixUtils.SOH);

            }

		if (hasScope()) {		
			out.put(FixTags.SCOPE);

			out.put((byte) '=');

			FixUtils.put(out,scope); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPriceDelta()) {		
			out.put(FixTags.PRICEDELTA);

			out.put((byte) '=');

			FixUtils.put(out, (long)priceDelta);
		
			out.put(FixUtils.SOH);

            }

		if (hasNetChgPrevDay()) {		
			out.put(FixTags.NETCHGPREVDAY);

			out.put((byte) '=');

			FixUtils.put(out, (long)netChgPrevDay);
		
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

		if (hasOrderCapacity()) {		
			out.put(FixTags.ORDERCAPACITY);

			out.put((byte) '=');

			FixUtils.put(out,orderCapacity); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDOriginType()) {		
			out.put(FixTags.MDORIGINTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDOriginType);
		
			out.put(FixUtils.SOH);

            }

		if (hasHighPx()) {		
			out.put(FixTags.HIGHPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)highPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasLowPx()) {		
			out.put(FixTags.LOWPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)lowPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasTradeVolume()) {		
			out.put(FixTags.TRADEVOLUME);

			out.put((byte) '=');

			FixUtils.put(out, (long)tradeVolume);
		
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

		if (hasMDQuoteType()) {		
			out.put(FixTags.MDQUOTETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDQuoteType);
		
			out.put(FixUtils.SOH);

            }

		if (hasRptSeq()) {		
			out.put(FixTags.RPTSEQ);

			out.put((byte) '=');

			FixUtils.put(out, (long)rptSeq);
		
			out.put(FixUtils.SOH);

            }

		if (hasMDPriceLevel()) {		
			out.put(FixTags.MDPRICELEVEL);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDPriceLevel);
		
			out.put(FixUtils.SOH);

            }

		if (hasTransBkdTime()) {		
			out.put(FixTags.TRANSBKDTIME);

			out.put((byte) '=');

			FixUtils.put(out,transBkdTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);

			out.put((byte) '=');

			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasFirstPx()) {		
			out.put(FixTags.FIRSTPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)firstPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasLastPx()) {		
			out.put(FixTags.LASTPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)lastPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasDealingCapacity()) {		
			out.put(FixTags.DEALINGCAPACITY);

			out.put((byte) '=');

			FixUtils.put(out,dealingCapacity); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntrySpotRate()) {		
			out.put(FixTags.MDENTRYSPOTRATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDEntrySpotRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntryForwardPoints()) {		
			out.put(FixTags.MDENTRYFORWARDPOINTS);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDEntryForwardPoints);
		
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
		yieldData.encode(out);
		spreadOrBenchmarkCurveData.encode(out);
		if (FixUtils.getNoInGroup(rateSource)>0) {
			out.put(FixTags.NORATESOURCES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(rateSource));

			out.put(FixUtils.SOH);

		}
		for (FixRateSource fixRateSource : rateSource) if (fixRateSource.hasGroup()) fixRateSource.encode(out);
		if (FixUtils.getNoInGroup(secSizesGrp)>0) {
			out.put(FixTags.NOOFSECSIZES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(secSizesGrp));

			out.put(FixUtils.SOH);

		}
		for (FixSecSizesGrp fixSecSizesGrp : secSizesGrp) if (fixSecSizesGrp.hasGroup()) fixSecSizesGrp.encode(out);
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(statsIndGrp)>0) {
			out.put(FixTags.NOSTATSINDICATORS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(statsIndGrp));

			out.put(FixUtils.SOH);

		}
		for (FixStatsIndGrp fixStatsIndGrp : statsIndGrp) if (fixStatsIndGrp.hasGroup()) fixStatsIndGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasMDUpdateAction()) {		
			FixUtils.put(out,mDUpdateAction); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDeleteReason()) {		
			FixUtils.put(out,deleteReason); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDSubBookType()) {		
			FixUtils.put(out, (long)mDSubBookType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketDepth()) {		
			FixUtils.put(out, (long)marketDepth);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntryType()) {		
			FixUtils.put(out,mDEntryType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntryID()) {		
			FixUtils.put(out,mDEntryID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntryRefID()) {		
			FixUtils.put(out,mDEntryRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDStreamID()) {		
			FixUtils.put(out,mDStreamID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFinancialStatus()) {		
			FixUtils.put(out,financialStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCorporateAction()) {		
			FixUtils.put(out,corporateAction); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntryPx()) {		
			FixUtils.put(out, (long)mDEntryPx);
		
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
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrency()) {		
			FixUtils.put(out,settlCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntrySize()) {		
			FixUtils.put(out, (long)mDEntrySize);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLotType()) {		
			FixUtils.put(out,lotType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntryDate()) {		
			FixUtils.put(out,mDEntryDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntryTime()) {		
			FixUtils.put(out,mDEntryTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTickDirection()) {		
			FixUtils.put(out,tickDirection); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDMkt()) {		
			FixUtils.put(out,mDMkt); 		
		
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
		
		if (hasSecurityTradingStatus()) {		
			FixUtils.put(out, (long)securityTradingStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHaltReason()) {		
			FixUtils.put(out, (long)haltReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteCondition()) {		
			FixUtils.put(out,quoteCondition); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeCondition()) {		
			FixUtils.put(out,tradeCondition); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTrdType()) {		
			FixUtils.put(out, (long)trdType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMatchType()) {		
			FixUtils.put(out,matchType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntryOriginator()) {		
			FixUtils.put(out,mDEntryOriginator); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLocationID()) {		
			FixUtils.put(out,locationID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDeskID()) {		
			FixUtils.put(out,deskID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOpenCloseSettlFlag()) {		
			FixUtils.put(out,openCloseSettlFlag); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTimeInForce()) {		
			FixUtils.put(out,timeInForce); 		
		
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
		
		if (hasMinQty()) {		
			FixUtils.put(out, (long)minQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecInst()) {		
			FixUtils.put(out,execInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSellerDays()) {		
			FixUtils.put(out, (long)sellerDays);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderID()) {		
			FixUtils.put(out,orderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryOrderID()) {		
			FixUtils.put(out,secondaryOrderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteEntryID()) {		
			FixUtils.put(out,quoteEntryID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeID()) {		
			FixUtils.put(out,tradeID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntryBuyer()) {		
			FixUtils.put(out,mDEntryBuyer); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntrySeller()) {		
			FixUtils.put(out,mDEntrySeller); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNumberOfOrders()) {		
			FixUtils.put(out, (long)numberOfOrders);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntryPositionNo()) {		
			FixUtils.put(out, (long)mDEntryPositionNo);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasScope()) {		
			FixUtils.put(out,scope); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceDelta()) {		
			FixUtils.put(out, (long)priceDelta);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNetChgPrevDay()) {		
			FixUtils.put(out, (long)netChgPrevDay);
		
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
		
		if (hasOrderCapacity()) {		
			FixUtils.put(out,orderCapacity); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDOriginType()) {		
			FixUtils.put(out, (long)mDOriginType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHighPx()) {		
			FixUtils.put(out, (long)highPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLowPx()) {		
			FixUtils.put(out, (long)lowPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeVolume()) {		
			FixUtils.put(out, (long)tradeVolume);
		
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
		
		if (hasMDQuoteType()) {		
			FixUtils.put(out, (long)mDQuoteType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRptSeq()) {		
			FixUtils.put(out, (long)rptSeq);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDPriceLevel()) {		
			FixUtils.put(out, (long)mDPriceLevel);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransBkdTime()) {		
			FixUtils.put(out,transBkdTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFirstPx()) {		
			FixUtils.put(out, (long)firstPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastPx()) {		
			FixUtils.put(out, (long)lastPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDealingCapacity()) {		
			FixUtils.put(out,dealingCapacity); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntrySpotRate()) {		
			FixUtils.put(out, (long)mDEntrySpotRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntryForwardPoints()) {		
			FixUtils.put(out, (long)mDEntryForwardPoints);
		
	        out.put( (byte)' ' );		
		}		
		
		instrument.printBuffer(out);
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.printBuffer(out);
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.printBuffer(out);
		yieldData.printBuffer(out);
		spreadOrBenchmarkCurveData.printBuffer(out);
		for (FixRateSource fixRateSource : rateSource) fixRateSource.printBuffer(out);
		for (FixSecSizesGrp fixSecSizesGrp : secSizesGrp) fixSecSizesGrp.printBuffer(out);
		for (FixParties fixParties : parties) fixParties.printBuffer(out);
		for (FixStatsIndGrp fixStatsIndGrp : statsIndGrp) fixStatsIndGrp.printBuffer(out);
	}

	public byte getMDUpdateAction() { 		
		if ( hasMDUpdateAction()) {		
			if (hasMDUpdateAction == FixUtils.TAG_HAS_VALUE) {		
				return mDUpdateAction; 		
			} else {		
		
				buf.position(hasMDUpdateAction);		
		
			mDUpdateAction = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (mDUpdateAction != (byte)'3') && (mDUpdateAction != (byte)'2') && (mDUpdateAction != (byte)'1') && (mDUpdateAction != (byte)'0') && (mDUpdateAction != (byte)'5') && (mDUpdateAction != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 279);		
				if (err.hasError()) {		
					buf.position(hasMDUpdateAction);		
					return (byte)'0';		
				}		
			}		
			hasMDUpdateAction = FixUtils.TAG_HAS_VALUE;		
			return mDUpdateAction;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMDUpdateAction() { return hasMDUpdateAction != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDUpdateAction(byte src) {		
		mDUpdateAction = src;
		hasMDUpdateAction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDUpdateAction(byte[] src) {		
		if (src == null ) return;
		if (hasMDUpdateAction()) mDUpdateAction = (byte)' ';		
		mDUpdateAction = src[0];		
		hasMDUpdateAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDUpdateAction(String str) {		
		if (str == null ) return;
		if (hasMDUpdateAction()) mDUpdateAction = (byte)' ';		
		byte[] src = str.getBytes(); 		
		mDUpdateAction = src[0];		
		hasMDUpdateAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getDeleteReason() { 		
		if ( hasDeleteReason()) {		
			if (hasDeleteReason == FixUtils.TAG_HAS_VALUE) {		
				return deleteReason; 		
			} else {		
		
				buf.position(hasDeleteReason);		
		
			deleteReason = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (deleteReason != (byte)'1') && (deleteReason != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 285);		
				if (err.hasError()) {		
					buf.position(hasDeleteReason);		
					return (byte)'0';		
				}		
			}		
			hasDeleteReason = FixUtils.TAG_HAS_VALUE;		
			return deleteReason;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDeleteReason() { return hasDeleteReason != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDeleteReason(byte src) {		
		deleteReason = src;
		hasDeleteReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDeleteReason(byte[] src) {		
		if (src == null ) return;
		if (hasDeleteReason()) deleteReason = (byte)' ';		
		deleteReason = src[0];		
		hasDeleteReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDeleteReason(String str) {		
		if (str == null ) return;
		if (hasDeleteReason()) deleteReason = (byte)' ';		
		byte[] src = str.getBytes(); 		
		deleteReason = src[0];		
		hasDeleteReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMDSubBookType() { 		
		if ( hasMDSubBookType()) {		
			if (hasMDSubBookType == FixUtils.TAG_HAS_VALUE) {		
				return mDSubBookType; 		
			} else {		
		
				buf.position(hasMDSubBookType);		
		
			mDSubBookType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDSubBookType);		
					return 0;		
				}		
			}		
			hasMDSubBookType = FixUtils.TAG_HAS_VALUE;		
			return mDSubBookType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDSubBookType() { return hasMDSubBookType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDSubBookType(long src) {		
		mDSubBookType = src;
		hasMDSubBookType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDSubBookType(byte[] src) {		
		if (src == null ) return;
		if (hasMDSubBookType()) mDSubBookType = FixUtils.TAG_HAS_NO_VALUE;		
		mDSubBookType = FixUtils.longValueOf(src, 0, src.length);
		hasMDSubBookType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDSubBookType(String str) {		
		if (str == null ) return;
		if (hasMDSubBookType()) mDSubBookType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDSubBookType = FixUtils.longValueOf(src, 0, src.length);
		hasMDSubBookType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMarketDepth() { 		
		if ( hasMarketDepth()) {		
			if (hasMarketDepth == FixUtils.TAG_HAS_VALUE) {		
				return marketDepth; 		
			} else {		
		
				buf.position(hasMarketDepth);		
		
			marketDepth = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMarketDepth);		
					return 0;		
				}		
			}		
			hasMarketDepth = FixUtils.TAG_HAS_VALUE;		
			return marketDepth;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMarketDepth() { return hasMarketDepth != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMarketDepth(long src) {		
		marketDepth = src;
		hasMarketDepth = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketDepth(byte[] src) {		
		if (src == null ) return;
		if (hasMarketDepth()) marketDepth = FixUtils.TAG_HAS_NO_VALUE;		
		marketDepth = FixUtils.longValueOf(src, 0, src.length);
		hasMarketDepth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMarketDepth(String str) {		
		if (str == null ) return;
		if (hasMarketDepth()) marketDepth = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		marketDepth = FixUtils.longValueOf(src, 0, src.length);
		hasMarketDepth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getMDEntryType() { 		
		if ( hasMDEntryType()) {		
			if (hasMDEntryType == FixUtils.TAG_HAS_VALUE) {		
				return mDEntryType; 		
			} else {		
		
				buf.position(hasMDEntryType);		
		
			mDEntryType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (mDEntryType != (byte)'D') && (mDEntryType != (byte)'E') && (mDEntryType != (byte)'F') && (mDEntryType != (byte)'G') && (mDEntryType != (byte)'A') && (mDEntryType != (byte)'B') && (mDEntryType != (byte)'C') && (mDEntryType != (byte)'L') && (mDEntryType != (byte)'M') && (mDEntryType != (byte)'N') && (mDEntryType != (byte)'O') && (mDEntryType != (byte)'H') && (mDEntryType != (byte)'J') && (mDEntryType != (byte)'K') && (mDEntryType != (byte)'U') && (mDEntryType != (byte)'T') && (mDEntryType != (byte)'W') && (mDEntryType != (byte)'V') && (mDEntryType != (byte)'Q') && (mDEntryType != (byte)'P') && (mDEntryType != (byte)'S') && (mDEntryType != (byte)'R') && (mDEntryType != (byte)'Y') && (mDEntryType != (byte)'X') && (mDEntryType != (byte)'Z') && (mDEntryType != (byte)'a') && (mDEntryType != (byte)'3') && (mDEntryType != (byte)'2') && (mDEntryType != (byte)'1') && (mDEntryType != (byte)'0') && (mDEntryType != (byte)'7') && (mDEntryType != (byte)'6') && (mDEntryType != (byte)'5') && (mDEntryType != (byte)'4') && (mDEntryType != (byte)'9') && (mDEntryType != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 269);		
				if (err.hasError()) {		
					buf.position(hasMDEntryType);		
					return (byte)'0';		
				}		
			}		
			hasMDEntryType = FixUtils.TAG_HAS_VALUE;		
			return mDEntryType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMDEntryType() { return hasMDEntryType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntryType(byte src) {		
		mDEntryType = src;
		hasMDEntryType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDEntryType(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntryType()) mDEntryType = (byte)' ';		
		mDEntryType = src[0];		
		hasMDEntryType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntryType(String str) {		
		if (str == null ) return;
		if (hasMDEntryType()) mDEntryType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		mDEntryType = src[0];		
		hasMDEntryType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMDEntryID() { 		
		if ( hasMDEntryID()) {		
			if (hasMDEntryID == FixUtils.TAG_HAS_VALUE) {		
				return mDEntryID; 		
			} else {		
		
				buf.position(hasMDEntryID);		
		
			FixMessage.getTagStringValue(buf, mDEntryID, 0, mDEntryID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntryID);		
					return null;		
				}		
			}		
			hasMDEntryID = FixUtils.TAG_HAS_VALUE;		
			return mDEntryID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDEntryID() { return hasMDEntryID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntryID(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntryID()) FixUtils.fillSpace(mDEntryID);		
		FixUtils.copy(mDEntryID, src); 		
		hasMDEntryID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntryID(String str) {		
		if (str == null ) return;
		if (hasMDEntryID()) FixUtils.fillSpace(mDEntryID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDEntryID, src); 		
		hasMDEntryID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMDEntryRefID() { 		
		if ( hasMDEntryRefID()) {		
			if (hasMDEntryRefID == FixUtils.TAG_HAS_VALUE) {		
				return mDEntryRefID; 		
			} else {		
		
				buf.position(hasMDEntryRefID);		
		
			FixMessage.getTagStringValue(buf, mDEntryRefID, 0, mDEntryRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntryRefID);		
					return null;		
				}		
			}		
			hasMDEntryRefID = FixUtils.TAG_HAS_VALUE;		
			return mDEntryRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDEntryRefID() { return hasMDEntryRefID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntryRefID(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntryRefID()) FixUtils.fillSpace(mDEntryRefID);		
		FixUtils.copy(mDEntryRefID, src); 		
		hasMDEntryRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntryRefID(String str) {		
		if (str == null ) return;
		if (hasMDEntryRefID()) FixUtils.fillSpace(mDEntryRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDEntryRefID, src); 		
		hasMDEntryRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMDStreamID() { 		
		if ( hasMDStreamID()) {		
			if (hasMDStreamID == FixUtils.TAG_HAS_VALUE) {		
				return mDStreamID; 		
			} else {		
		
				buf.position(hasMDStreamID);		
		
			FixMessage.getTagStringValue(buf, mDStreamID, 0, mDStreamID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDStreamID);		
					return null;		
				}		
			}		
			hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
			return mDStreamID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDStreamID() { return hasMDStreamID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDStreamID(byte[] src) {		
		if (src == null ) return;
		if (hasMDStreamID()) FixUtils.fillSpace(mDStreamID);		
		FixUtils.copy(mDStreamID, src); 		
		hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDStreamID(String str) {		
		if (str == null ) return;
		if (hasMDStreamID()) FixUtils.fillSpace(mDStreamID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDStreamID, src); 		
		hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getFinancialStatus() { 		
		if ( hasFinancialStatus()) {		
			if (hasFinancialStatus == FixUtils.TAG_HAS_VALUE) {		
				return financialStatus; 		
			} else {		
		
				buf.position(hasFinancialStatus);		
		
			FixMessage.getTagStringValue(buf, financialStatus, 0, financialStatus.length, err);
		
				if (err.hasError()) {		
					buf.position(hasFinancialStatus);		
					return null;		
				}		
			}		
			hasFinancialStatus = FixUtils.TAG_HAS_VALUE;		
			return financialStatus;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasFinancialStatus() { return hasFinancialStatus != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFinancialStatus(byte[] src) {		
		if (src == null ) return;
		if (hasFinancialStatus()) FixUtils.fillSpace(financialStatus);		
		FixUtils.copy(financialStatus, src); 		
		hasFinancialStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFinancialStatus(String str) {		
		if (str == null ) return;
		if (hasFinancialStatus()) FixUtils.fillSpace(financialStatus);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(financialStatus, src); 		
		hasFinancialStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCorporateAction() { 		
		if ( hasCorporateAction()) {		
			if (hasCorporateAction == FixUtils.TAG_HAS_VALUE) {		
				return corporateAction; 		
			} else {		
		
				buf.position(hasCorporateAction);		
		
			FixMessage.getTagStringValue(buf, corporateAction, 0, corporateAction.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCorporateAction);		
					return null;		
				}		
			}		
			hasCorporateAction = FixUtils.TAG_HAS_VALUE;		
			return corporateAction;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCorporateAction() { return hasCorporateAction != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCorporateAction(byte[] src) {		
		if (src == null ) return;
		if (hasCorporateAction()) FixUtils.fillSpace(corporateAction);		
		FixUtils.copy(corporateAction, src); 		
		hasCorporateAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCorporateAction(String str) {		
		if (str == null ) return;
		if (hasCorporateAction()) FixUtils.fillSpace(corporateAction);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(corporateAction, src); 		
		hasCorporateAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMDEntryPx() { 		
		if ( hasMDEntryPx()) {		
			if (hasMDEntryPx == FixUtils.TAG_HAS_VALUE) {		
				return mDEntryPx; 		
			} else {		
		
				buf.position(hasMDEntryPx);		
		
			mDEntryPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntryPx);		
					return 0;		
				}		
			}		
			hasMDEntryPx = FixUtils.TAG_HAS_VALUE;		
			return mDEntryPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDEntryPx() { return hasMDEntryPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntryPx(long src) {		
		mDEntryPx = src;
		hasMDEntryPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDEntryPx(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntryPx()) mDEntryPx = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntryPx = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntryPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntryPx(String str) {		
		if (str == null ) return;
		if (hasMDEntryPx()) mDEntryPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDEntryPx = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntryPx = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getMDEntrySize() { 		
		if ( hasMDEntrySize()) {		
			if (hasMDEntrySize == FixUtils.TAG_HAS_VALUE) {		
				return mDEntrySize; 		
			} else {		
		
				buf.position(hasMDEntrySize);		
		
			mDEntrySize = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntrySize);		
					return 0;		
				}		
			}		
			hasMDEntrySize = FixUtils.TAG_HAS_VALUE;		
			return mDEntrySize;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDEntrySize() { return hasMDEntrySize != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntrySize(long src) {		
		mDEntrySize = src;
		hasMDEntrySize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDEntrySize(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntrySize()) mDEntrySize = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntrySize = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntrySize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntrySize(String str) {		
		if (str == null ) return;
		if (hasMDEntrySize()) mDEntrySize = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDEntrySize = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntrySize = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasLotType);		
					return (byte)'0';		
				}		
			}		
			hasLotType = FixUtils.TAG_HAS_VALUE;		
			return lotType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasLotType() { return hasLotType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLotType(byte src) {		
		lotType = src;
		hasLotType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLotType(byte[] src) {		
		if (src == null ) return;
		if (hasLotType()) lotType = (byte)' ';		
		lotType = src[0];		
		hasLotType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLotType(String str) {		
		if (str == null ) return;
		if (hasLotType()) lotType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		lotType = src[0];		
		hasLotType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMDEntryDate() { 		
		if ( hasMDEntryDate()) {		
			if (hasMDEntryDate == FixUtils.TAG_HAS_VALUE) {		
				return mDEntryDate; 		
			} else {		
		
				buf.position(hasMDEntryDate);		
		
			FixMessage.getTagStringValue(buf, mDEntryDate, 0, mDEntryDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntryDate);		
					return null;		
				}		
			}		
			hasMDEntryDate = FixUtils.TAG_HAS_VALUE;		
			return mDEntryDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDEntryDate() { return hasMDEntryDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntryDate(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntryDate()) FixUtils.fillSpace(mDEntryDate);		
		FixUtils.copy(mDEntryDate, src); 		
		hasMDEntryDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntryDate(String str) {		
		if (str == null ) return;
		if (hasMDEntryDate()) FixUtils.fillSpace(mDEntryDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDEntryDate, src); 		
		hasMDEntryDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMDEntryTime() { 		
		if ( hasMDEntryTime()) {		
			if (hasMDEntryTime == FixUtils.TAG_HAS_VALUE) {		
				return mDEntryTime; 		
			} else {		
		
				buf.position(hasMDEntryTime);		
		
			FixMessage.getTagStringValue(buf, mDEntryTime, 0, mDEntryTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntryTime);		
					return null;		
				}		
			}		
			hasMDEntryTime = FixUtils.TAG_HAS_VALUE;		
			return mDEntryTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDEntryTime() { return hasMDEntryTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntryTime(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntryTime()) FixUtils.fillSpace(mDEntryTime);		
		FixUtils.copy(mDEntryTime, src); 		
		hasMDEntryTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntryTime(String str) {		
		if (str == null ) return;
		if (hasMDEntryTime()) FixUtils.fillSpace(mDEntryTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDEntryTime, src); 		
		hasMDEntryTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getTickDirection() { 		
		if ( hasTickDirection()) {		
			if (hasTickDirection == FixUtils.TAG_HAS_VALUE) {		
				return tickDirection; 		
			} else {		
		
				buf.position(hasTickDirection);		
		
			tickDirection = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (tickDirection != (byte)'3') && (tickDirection != (byte)'2') && (tickDirection != (byte)'1') && (tickDirection != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 274);		
				if (err.hasError()) {		
					buf.position(hasTickDirection);		
					return (byte)'0';		
				}		
			}		
			hasTickDirection = FixUtils.TAG_HAS_VALUE;		
			return tickDirection;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTickDirection() { return hasTickDirection != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTickDirection(byte src) {		
		tickDirection = src;
		hasTickDirection = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTickDirection(byte[] src) {		
		if (src == null ) return;
		if (hasTickDirection()) tickDirection = (byte)' ';		
		tickDirection = src[0];		
		hasTickDirection = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTickDirection(String str) {		
		if (str == null ) return;
		if (hasTickDirection()) tickDirection = (byte)' ';		
		byte[] src = str.getBytes(); 		
		tickDirection = src[0];		
		hasTickDirection = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMDMkt() { 		
		if ( hasMDMkt()) {		
			if (hasMDMkt == FixUtils.TAG_HAS_VALUE) {		
				return mDMkt; 		
			} else {		
		
				buf.position(hasMDMkt);		
		
			FixMessage.getTagStringValue(buf, mDMkt, 0, mDMkt.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDMkt);		
					return null;		
				}		
			}		
			hasMDMkt = FixUtils.TAG_HAS_VALUE;		
			return mDMkt;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDMkt() { return hasMDMkt != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDMkt(byte[] src) {		
		if (src == null ) return;
		if (hasMDMkt()) FixUtils.fillSpace(mDMkt);		
		FixUtils.copy(mDMkt, src); 		
		hasMDMkt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDMkt(String str) {		
		if (str == null ) return;
		if (hasMDMkt()) FixUtils.fillSpace(mDMkt);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDMkt, src); 		
		hasMDMkt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradingSessionID() { 		
		if ( hasTradingSessionID()) {		
			if (hasTradingSessionID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionID; 		
			} else {		
		
				buf.position(hasTradingSessionID);		
		
			FixMessage.getTagStringValue(buf, tradingSessionID, 0, tradingSessionID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradingSessionID);		
					return null;		
				}		
			}		
			hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getTradingSessionSubID() { 		
		if ( hasTradingSessionSubID()) {		
			if (hasTradingSessionSubID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionSubID; 		
			} else {		
		
				buf.position(hasTradingSessionSubID);		
		
			FixMessage.getTagStringValue(buf, tradingSessionSubID, 0, tradingSessionSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradingSessionSubID);		
					return null;		
				}		
			}		
			hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getSecurityTradingStatus() { 		
		if ( hasSecurityTradingStatus()) {		
			if (hasSecurityTradingStatus == FixUtils.TAG_HAS_VALUE) {		
				return securityTradingStatus; 		
			} else {		
		
				buf.position(hasSecurityTradingStatus);		
		
			securityTradingStatus = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityTradingStatus);		
					return 0;		
				}		
			}		
			hasSecurityTradingStatus = FixUtils.TAG_HAS_VALUE;		
			return securityTradingStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecurityTradingStatus() { return hasSecurityTradingStatus != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityTradingStatus(long src) {		
		securityTradingStatus = src;
		hasSecurityTradingStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityTradingStatus(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityTradingStatus()) securityTradingStatus = FixUtils.TAG_HAS_NO_VALUE;		
		securityTradingStatus = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityTradingStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityTradingStatus(String str) {		
		if (str == null ) return;
		if (hasSecurityTradingStatus()) securityTradingStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		securityTradingStatus = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityTradingStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getHaltReason() { 		
		if ( hasHaltReason()) {		
			if (hasHaltReason == FixUtils.TAG_HAS_VALUE) {		
				return haltReason; 		
			} else {		
		
				buf.position(hasHaltReason);		
		
			haltReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasHaltReason);		
					return 0;		
				}		
			}		
			hasHaltReason = FixUtils.TAG_HAS_VALUE;		
			return haltReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasHaltReason() { return hasHaltReason != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setHaltReason(long src) {		
		haltReason = src;
		hasHaltReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHaltReason(byte[] src) {		
		if (src == null ) return;
		if (hasHaltReason()) haltReason = FixUtils.TAG_HAS_NO_VALUE;		
		haltReason = FixUtils.longValueOf(src, 0, src.length);
		hasHaltReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setHaltReason(String str) {		
		if (str == null ) return;
		if (hasHaltReason()) haltReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		haltReason = FixUtils.longValueOf(src, 0, src.length);
		hasHaltReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getQuoteCondition() { 		
		if ( hasQuoteCondition()) {		
			if (hasQuoteCondition == FixUtils.TAG_HAS_VALUE) {		
				return quoteCondition; 		
			} else {		
		
				buf.position(hasQuoteCondition);		
		
			FixMessage.getTagStringValue(buf, quoteCondition, 0, quoteCondition.length, err);
		
				if (err.hasError()) {		
					buf.position(hasQuoteCondition);		
					return null;		
				}		
			}		
			hasQuoteCondition = FixUtils.TAG_HAS_VALUE;		
			return quoteCondition;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteCondition() { return hasQuoteCondition != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setQuoteCondition(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteCondition()) FixUtils.fillSpace(quoteCondition);		
		FixUtils.copy(quoteCondition, src); 		
		hasQuoteCondition = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setQuoteCondition(String str) {		
		if (str == null ) return;
		if (hasQuoteCondition()) FixUtils.fillSpace(quoteCondition);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteCondition, src); 		
		hasQuoteCondition = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradeCondition() { 		
		if ( hasTradeCondition()) {		
			if (hasTradeCondition == FixUtils.TAG_HAS_VALUE) {		
				return tradeCondition; 		
			} else {		
		
				buf.position(hasTradeCondition);		
		
			FixMessage.getTagStringValue(buf, tradeCondition, 0, tradeCondition.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradeCondition);		
					return null;		
				}		
			}		
			hasTradeCondition = FixUtils.TAG_HAS_VALUE;		
			return tradeCondition;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeCondition() { return hasTradeCondition != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradeCondition(byte[] src) {		
		if (src == null ) return;
		if (hasTradeCondition()) FixUtils.fillSpace(tradeCondition);		
		FixUtils.copy(tradeCondition, src); 		
		hasTradeCondition = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradeCondition(String str) {		
		if (str == null ) return;
		if (hasTradeCondition()) FixUtils.fillSpace(tradeCondition);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeCondition, src); 		
		hasTradeCondition = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTrdType() { 		
		if ( hasTrdType()) {		
			if (hasTrdType == FixUtils.TAG_HAS_VALUE) {		
				return trdType; 		
			} else {		
		
				buf.position(hasTrdType);		
		
			trdType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTrdType);		
					return 0;		
				}		
			}		
			hasTrdType = FixUtils.TAG_HAS_VALUE;		
			return trdType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTrdType() { return hasTrdType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTrdType(long src) {		
		trdType = src;
		hasTrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdType(byte[] src) {		
		if (src == null ) return;
		if (hasTrdType()) trdType = FixUtils.TAG_HAS_NO_VALUE;		
		trdType = FixUtils.longValueOf(src, 0, src.length);
		hasTrdType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTrdType(String str) {		
		if (str == null ) return;
		if (hasTrdType()) trdType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		trdType = FixUtils.longValueOf(src, 0, src.length);
		hasTrdType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMatchType() { 		
		if ( hasMatchType()) {		
			if (hasMatchType == FixUtils.TAG_HAS_VALUE) {		
				return matchType; 		
			} else {		
		
				buf.position(hasMatchType);		
		
			FixMessage.getTagStringValue(buf, matchType, 0, matchType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMatchType);		
					return null;		
				}		
			}		
			hasMatchType = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getMDEntryOriginator() { 		
		if ( hasMDEntryOriginator()) {		
			if (hasMDEntryOriginator == FixUtils.TAG_HAS_VALUE) {		
				return mDEntryOriginator; 		
			} else {		
		
				buf.position(hasMDEntryOriginator);		
		
			FixMessage.getTagStringValue(buf, mDEntryOriginator, 0, mDEntryOriginator.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntryOriginator);		
					return null;		
				}		
			}		
			hasMDEntryOriginator = FixUtils.TAG_HAS_VALUE;		
			return mDEntryOriginator;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDEntryOriginator() { return hasMDEntryOriginator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntryOriginator(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntryOriginator()) FixUtils.fillSpace(mDEntryOriginator);		
		FixUtils.copy(mDEntryOriginator, src); 		
		hasMDEntryOriginator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntryOriginator(String str) {		
		if (str == null ) return;
		if (hasMDEntryOriginator()) FixUtils.fillSpace(mDEntryOriginator);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDEntryOriginator, src); 		
		hasMDEntryOriginator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLocationID() { 		
		if ( hasLocationID()) {		
			if (hasLocationID == FixUtils.TAG_HAS_VALUE) {		
				return locationID; 		
			} else {		
		
				buf.position(hasLocationID);		
		
			FixMessage.getTagStringValue(buf, locationID, 0, locationID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLocationID);		
					return null;		
				}		
			}		
			hasLocationID = FixUtils.TAG_HAS_VALUE;		
			return locationID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLocationID() { return hasLocationID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLocationID(byte[] src) {		
		if (src == null ) return;
		if (hasLocationID()) FixUtils.fillSpace(locationID);		
		FixUtils.copy(locationID, src); 		
		hasLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLocationID(String str) {		
		if (str == null ) return;
		if (hasLocationID()) FixUtils.fillSpace(locationID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(locationID, src); 		
		hasLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDeskID() { 		
		if ( hasDeskID()) {		
			if (hasDeskID == FixUtils.TAG_HAS_VALUE) {		
				return deskID; 		
			} else {		
		
				buf.position(hasDeskID);		
		
			FixMessage.getTagStringValue(buf, deskID, 0, deskID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDeskID);		
					return null;		
				}		
			}		
			hasDeskID = FixUtils.TAG_HAS_VALUE;		
			return deskID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDeskID() { return hasDeskID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDeskID(byte[] src) {		
		if (src == null ) return;
		if (hasDeskID()) FixUtils.fillSpace(deskID);		
		FixUtils.copy(deskID, src); 		
		hasDeskID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDeskID(String str) {		
		if (str == null ) return;
		if (hasDeskID()) FixUtils.fillSpace(deskID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(deskID, src); 		
		hasDeskID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOpenCloseSettlFlag() { 		
		if ( hasOpenCloseSettlFlag()) {		
			if (hasOpenCloseSettlFlag == FixUtils.TAG_HAS_VALUE) {		
				return openCloseSettlFlag; 		
			} else {		
		
				buf.position(hasOpenCloseSettlFlag);		
		
			FixMessage.getTagStringValue(buf, openCloseSettlFlag, 0, openCloseSettlFlag.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOpenCloseSettlFlag);		
					return null;		
				}		
			}		
			hasOpenCloseSettlFlag = FixUtils.TAG_HAS_VALUE;		
			return openCloseSettlFlag;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOpenCloseSettlFlag() { return hasOpenCloseSettlFlag != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOpenCloseSettlFlag(byte[] src) {		
		if (src == null ) return;
		if (hasOpenCloseSettlFlag()) FixUtils.fillSpace(openCloseSettlFlag);		
		FixUtils.copy(openCloseSettlFlag, src); 		
		hasOpenCloseSettlFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOpenCloseSettlFlag(String str) {		
		if (str == null ) return;
		if (hasOpenCloseSettlFlag()) FixUtils.fillSpace(openCloseSettlFlag);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(openCloseSettlFlag, src); 		
		hasOpenCloseSettlFlag = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getSellerDays() { 		
		if ( hasSellerDays()) {		
			if (hasSellerDays == FixUtils.TAG_HAS_VALUE) {		
				return sellerDays; 		
			} else {		
		
				buf.position(hasSellerDays);		
		
			sellerDays = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSellerDays);		
					return 0;		
				}		
			}		
			hasSellerDays = FixUtils.TAG_HAS_VALUE;		
			return sellerDays;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSellerDays() { return hasSellerDays != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSellerDays(long src) {		
		sellerDays = src;
		hasSellerDays = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSellerDays(byte[] src) {		
		if (src == null ) return;
		if (hasSellerDays()) sellerDays = FixUtils.TAG_HAS_NO_VALUE;		
		sellerDays = FixUtils.longValueOf(src, 0, src.length);
		hasSellerDays = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSellerDays(String str) {		
		if (str == null ) return;
		if (hasSellerDays()) sellerDays = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sellerDays = FixUtils.longValueOf(src, 0, src.length);
		hasSellerDays = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOrderID() { 		
		if ( hasOrderID()) {		
			if (hasOrderID == FixUtils.TAG_HAS_VALUE) {		
				return orderID; 		
			} else {		
		
				buf.position(hasOrderID);		
		
			FixMessage.getTagStringValue(buf, orderID, 0, orderID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderID);		
					return null;		
				}		
			}		
			hasOrderID = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getSecondaryOrderID() { 		
		if ( hasSecondaryOrderID()) {		
			if (hasSecondaryOrderID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryOrderID; 		
			} else {		
		
				buf.position(hasSecondaryOrderID);		
		
			FixMessage.getTagStringValue(buf, secondaryOrderID, 0, secondaryOrderID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryOrderID);		
					return null;		
				}		
			}		
			hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getQuoteEntryID() { 		
		if ( hasQuoteEntryID()) {		
			if (hasQuoteEntryID == FixUtils.TAG_HAS_VALUE) {		
				return quoteEntryID; 		
			} else {		
		
				buf.position(hasQuoteEntryID);		
		
			FixMessage.getTagStringValue(buf, quoteEntryID, 0, quoteEntryID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasQuoteEntryID);		
					return null;		
				}		
			}		
			hasQuoteEntryID = FixUtils.TAG_HAS_VALUE;		
			return quoteEntryID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteEntryID() { return hasQuoteEntryID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setQuoteEntryID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteEntryID()) FixUtils.fillSpace(quoteEntryID);		
		FixUtils.copy(quoteEntryID, src); 		
		hasQuoteEntryID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setQuoteEntryID(String str) {		
		if (str == null ) return;
		if (hasQuoteEntryID()) FixUtils.fillSpace(quoteEntryID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteEntryID, src); 		
		hasQuoteEntryID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradeID() { 		
		if ( hasTradeID()) {		
			if (hasTradeID == FixUtils.TAG_HAS_VALUE) {		
				return tradeID; 		
			} else {		
		
				buf.position(hasTradeID);		
		
			FixMessage.getTagStringValue(buf, tradeID, 0, tradeID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradeID);		
					return null;		
				}		
			}		
			hasTradeID = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getMDEntryBuyer() { 		
		if ( hasMDEntryBuyer()) {		
			if (hasMDEntryBuyer == FixUtils.TAG_HAS_VALUE) {		
				return mDEntryBuyer; 		
			} else {		
		
				buf.position(hasMDEntryBuyer);		
		
			FixMessage.getTagStringValue(buf, mDEntryBuyer, 0, mDEntryBuyer.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntryBuyer);		
					return null;		
				}		
			}		
			hasMDEntryBuyer = FixUtils.TAG_HAS_VALUE;		
			return mDEntryBuyer;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDEntryBuyer() { return hasMDEntryBuyer != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntryBuyer(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntryBuyer()) FixUtils.fillSpace(mDEntryBuyer);		
		FixUtils.copy(mDEntryBuyer, src); 		
		hasMDEntryBuyer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntryBuyer(String str) {		
		if (str == null ) return;
		if (hasMDEntryBuyer()) FixUtils.fillSpace(mDEntryBuyer);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDEntryBuyer, src); 		
		hasMDEntryBuyer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMDEntrySeller() { 		
		if ( hasMDEntrySeller()) {		
			if (hasMDEntrySeller == FixUtils.TAG_HAS_VALUE) {		
				return mDEntrySeller; 		
			} else {		
		
				buf.position(hasMDEntrySeller);		
		
			FixMessage.getTagStringValue(buf, mDEntrySeller, 0, mDEntrySeller.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntrySeller);		
					return null;		
				}		
			}		
			hasMDEntrySeller = FixUtils.TAG_HAS_VALUE;		
			return mDEntrySeller;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDEntrySeller() { return hasMDEntrySeller != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntrySeller(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntrySeller()) FixUtils.fillSpace(mDEntrySeller);		
		FixUtils.copy(mDEntrySeller, src); 		
		hasMDEntrySeller = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntrySeller(String str) {		
		if (str == null ) return;
		if (hasMDEntrySeller()) FixUtils.fillSpace(mDEntrySeller);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDEntrySeller, src); 		
		hasMDEntrySeller = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNumberOfOrders() { 		
		if ( hasNumberOfOrders()) {		
			if (hasNumberOfOrders == FixUtils.TAG_HAS_VALUE) {		
				return numberOfOrders; 		
			} else {		
		
				buf.position(hasNumberOfOrders);		
		
			numberOfOrders = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNumberOfOrders);		
					return 0;		
				}		
			}		
			hasNumberOfOrders = FixUtils.TAG_HAS_VALUE;		
			return numberOfOrders;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNumberOfOrders() { return hasNumberOfOrders != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNumberOfOrders(long src) {		
		numberOfOrders = src;
		hasNumberOfOrders = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNumberOfOrders(byte[] src) {		
		if (src == null ) return;
		if (hasNumberOfOrders()) numberOfOrders = FixUtils.TAG_HAS_NO_VALUE;		
		numberOfOrders = FixUtils.longValueOf(src, 0, src.length);
		hasNumberOfOrders = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNumberOfOrders(String str) {		
		if (str == null ) return;
		if (hasNumberOfOrders()) numberOfOrders = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		numberOfOrders = FixUtils.longValueOf(src, 0, src.length);
		hasNumberOfOrders = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMDEntryPositionNo() { 		
		if ( hasMDEntryPositionNo()) {		
			if (hasMDEntryPositionNo == FixUtils.TAG_HAS_VALUE) {		
				return mDEntryPositionNo; 		
			} else {		
		
				buf.position(hasMDEntryPositionNo);		
		
			mDEntryPositionNo = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntryPositionNo);		
					return 0;		
				}		
			}		
			hasMDEntryPositionNo = FixUtils.TAG_HAS_VALUE;		
			return mDEntryPositionNo;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDEntryPositionNo() { return hasMDEntryPositionNo != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntryPositionNo(long src) {		
		mDEntryPositionNo = src;
		hasMDEntryPositionNo = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDEntryPositionNo(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntryPositionNo()) mDEntryPositionNo = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntryPositionNo = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntryPositionNo = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntryPositionNo(String str) {		
		if (str == null ) return;
		if (hasMDEntryPositionNo()) mDEntryPositionNo = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDEntryPositionNo = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntryPositionNo = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getScope() { 		
		if ( hasScope()) {		
			if (hasScope == FixUtils.TAG_HAS_VALUE) {		
				return scope; 		
			} else {		
		
				buf.position(hasScope);		
		
			FixMessage.getTagStringValue(buf, scope, 0, scope.length, err);
		
				if (err.hasError()) {		
					buf.position(hasScope);		
					return null;		
				}		
			}		
			hasScope = FixUtils.TAG_HAS_VALUE;		
			return scope;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasScope() { return hasScope != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setScope(byte[] src) {		
		if (src == null ) return;
		if (hasScope()) FixUtils.fillSpace(scope);		
		FixUtils.copy(scope, src); 		
		hasScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setScope(String str) {		
		if (str == null ) return;
		if (hasScope()) FixUtils.fillSpace(scope);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(scope, src); 		
		hasScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPriceDelta() { 		
		if ( hasPriceDelta()) {		
			if (hasPriceDelta == FixUtils.TAG_HAS_VALUE) {		
				return priceDelta; 		
			} else {		
		
				buf.position(hasPriceDelta);		
		
			priceDelta = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPriceDelta);		
					return 0;		
				}		
			}		
			hasPriceDelta = FixUtils.TAG_HAS_VALUE;		
			return priceDelta;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriceDelta() { return hasPriceDelta != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPriceDelta(long src) {		
		priceDelta = src;
		hasPriceDelta = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceDelta(byte[] src) {		
		if (src == null ) return;
		if (hasPriceDelta()) priceDelta = FixUtils.TAG_HAS_NO_VALUE;		
		priceDelta = FixUtils.longValueOf(src, 0, src.length);
		hasPriceDelta = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPriceDelta(String str) {		
		if (str == null ) return;
		if (hasPriceDelta()) priceDelta = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priceDelta = FixUtils.longValueOf(src, 0, src.length);
		hasPriceDelta = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNetChgPrevDay() { 		
		if ( hasNetChgPrevDay()) {		
			if (hasNetChgPrevDay == FixUtils.TAG_HAS_VALUE) {		
				return netChgPrevDay; 		
			} else {		
		
				buf.position(hasNetChgPrevDay);		
		
			netChgPrevDay = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNetChgPrevDay);		
					return 0;		
				}		
			}		
			hasNetChgPrevDay = FixUtils.TAG_HAS_VALUE;		
			return netChgPrevDay;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNetChgPrevDay() { return hasNetChgPrevDay != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNetChgPrevDay(long src) {		
		netChgPrevDay = src;
		hasNetChgPrevDay = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetChgPrevDay(byte[] src) {		
		if (src == null ) return;
		if (hasNetChgPrevDay()) netChgPrevDay = FixUtils.TAG_HAS_NO_VALUE;		
		netChgPrevDay = FixUtils.longValueOf(src, 0, src.length);
		hasNetChgPrevDay = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNetChgPrevDay(String str) {		
		if (str == null ) return;
		if (hasNetChgPrevDay()) netChgPrevDay = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		netChgPrevDay = FixUtils.longValueOf(src, 0, src.length);
		hasNetChgPrevDay = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getMDOriginType() { 		
		if ( hasMDOriginType()) {		
			if (hasMDOriginType == FixUtils.TAG_HAS_VALUE) {		
				return mDOriginType; 		
			} else {		
		
				buf.position(hasMDOriginType);		
		
			mDOriginType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDOriginType);		
					return 0;		
				}		
			}		
			hasMDOriginType = FixUtils.TAG_HAS_VALUE;		
			return mDOriginType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDOriginType() { return hasMDOriginType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDOriginType(long src) {		
		mDOriginType = src;
		hasMDOriginType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDOriginType(byte[] src) {		
		if (src == null ) return;
		if (hasMDOriginType()) mDOriginType = FixUtils.TAG_HAS_NO_VALUE;		
		mDOriginType = FixUtils.longValueOf(src, 0, src.length);
		hasMDOriginType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDOriginType(String str) {		
		if (str == null ) return;
		if (hasMDOriginType()) mDOriginType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDOriginType = FixUtils.longValueOf(src, 0, src.length);
		hasMDOriginType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getHighPx() { 		
		if ( hasHighPx()) {		
			if (hasHighPx == FixUtils.TAG_HAS_VALUE) {		
				return highPx; 		
			} else {		
		
				buf.position(hasHighPx);		
		
			highPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasHighPx);		
					return 0;		
				}		
			}		
			hasHighPx = FixUtils.TAG_HAS_VALUE;		
			return highPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasHighPx() { return hasHighPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setHighPx(long src) {		
		highPx = src;
		hasHighPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHighPx(byte[] src) {		
		if (src == null ) return;
		if (hasHighPx()) highPx = FixUtils.TAG_HAS_NO_VALUE;		
		highPx = FixUtils.longValueOf(src, 0, src.length);
		hasHighPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setHighPx(String str) {		
		if (str == null ) return;
		if (hasHighPx()) highPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		highPx = FixUtils.longValueOf(src, 0, src.length);
		hasHighPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLowPx() { 		
		if ( hasLowPx()) {		
			if (hasLowPx == FixUtils.TAG_HAS_VALUE) {		
				return lowPx; 		
			} else {		
		
				buf.position(hasLowPx);		
		
			lowPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLowPx);		
					return 0;		
				}		
			}		
			hasLowPx = FixUtils.TAG_HAS_VALUE;		
			return lowPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLowPx() { return hasLowPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLowPx(long src) {		
		lowPx = src;
		hasLowPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLowPx(byte[] src) {		
		if (src == null ) return;
		if (hasLowPx()) lowPx = FixUtils.TAG_HAS_NO_VALUE;		
		lowPx = FixUtils.longValueOf(src, 0, src.length);
		hasLowPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLowPx(String str) {		
		if (str == null ) return;
		if (hasLowPx()) lowPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lowPx = FixUtils.longValueOf(src, 0, src.length);
		hasLowPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTradeVolume() { 		
		if ( hasTradeVolume()) {		
			if (hasTradeVolume == FixUtils.TAG_HAS_VALUE) {		
				return tradeVolume; 		
			} else {		
		
				buf.position(hasTradeVolume);		
		
			tradeVolume = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTradeVolume);		
					return 0;		
				}		
			}		
			hasTradeVolume = FixUtils.TAG_HAS_VALUE;		
			return tradeVolume;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradeVolume() { return hasTradeVolume != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradeVolume(long src) {		
		tradeVolume = src;
		hasTradeVolume = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeVolume(byte[] src) {		
		if (src == null ) return;
		if (hasTradeVolume()) tradeVolume = FixUtils.TAG_HAS_NO_VALUE;		
		tradeVolume = FixUtils.longValueOf(src, 0, src.length);
		hasTradeVolume = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradeVolume(String str) {		
		if (str == null ) return;
		if (hasTradeVolume()) tradeVolume = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradeVolume = FixUtils.longValueOf(src, 0, src.length);
		hasTradeVolume = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getMDQuoteType() { 		
		if ( hasMDQuoteType()) {		
			if (hasMDQuoteType == FixUtils.TAG_HAS_VALUE) {		
				return mDQuoteType; 		
			} else {		
		
				buf.position(hasMDQuoteType);		
		
			mDQuoteType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDQuoteType);		
					return 0;		
				}		
			}		
			hasMDQuoteType = FixUtils.TAG_HAS_VALUE;		
			return mDQuoteType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDQuoteType() { return hasMDQuoteType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDQuoteType(long src) {		
		mDQuoteType = src;
		hasMDQuoteType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDQuoteType(byte[] src) {		
		if (src == null ) return;
		if (hasMDQuoteType()) mDQuoteType = FixUtils.TAG_HAS_NO_VALUE;		
		mDQuoteType = FixUtils.longValueOf(src, 0, src.length);
		hasMDQuoteType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDQuoteType(String str) {		
		if (str == null ) return;
		if (hasMDQuoteType()) mDQuoteType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDQuoteType = FixUtils.longValueOf(src, 0, src.length);
		hasMDQuoteType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRptSeq() { 		
		if ( hasRptSeq()) {		
			if (hasRptSeq == FixUtils.TAG_HAS_VALUE) {		
				return rptSeq; 		
			} else {		
		
				buf.position(hasRptSeq);		
		
			rptSeq = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRptSeq);		
					return 0;		
				}		
			}		
			hasRptSeq = FixUtils.TAG_HAS_VALUE;		
			return rptSeq;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRptSeq() { return hasRptSeq != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRptSeq(long src) {		
		rptSeq = src;
		hasRptSeq = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRptSeq(byte[] src) {		
		if (src == null ) return;
		if (hasRptSeq()) rptSeq = FixUtils.TAG_HAS_NO_VALUE;		
		rptSeq = FixUtils.longValueOf(src, 0, src.length);
		hasRptSeq = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRptSeq(String str) {		
		if (str == null ) return;
		if (hasRptSeq()) rptSeq = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		rptSeq = FixUtils.longValueOf(src, 0, src.length);
		hasRptSeq = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMDPriceLevel() { 		
		if ( hasMDPriceLevel()) {		
			if (hasMDPriceLevel == FixUtils.TAG_HAS_VALUE) {		
				return mDPriceLevel; 		
			} else {		
		
				buf.position(hasMDPriceLevel);		
		
			mDPriceLevel = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDPriceLevel);		
					return 0;		
				}		
			}		
			hasMDPriceLevel = FixUtils.TAG_HAS_VALUE;		
			return mDPriceLevel;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDPriceLevel() { return hasMDPriceLevel != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDPriceLevel(long src) {		
		mDPriceLevel = src;
		hasMDPriceLevel = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDPriceLevel(byte[] src) {		
		if (src == null ) return;
		if (hasMDPriceLevel()) mDPriceLevel = FixUtils.TAG_HAS_NO_VALUE;		
		mDPriceLevel = FixUtils.longValueOf(src, 0, src.length);
		hasMDPriceLevel = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDPriceLevel(String str) {		
		if (str == null ) return;
		if (hasMDPriceLevel()) mDPriceLevel = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDPriceLevel = FixUtils.longValueOf(src, 0, src.length);
		hasMDPriceLevel = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTransBkdTime() { 		
		if ( hasTransBkdTime()) {		
			if (hasTransBkdTime == FixUtils.TAG_HAS_VALUE) {		
				return transBkdTime; 		
			} else {		
		
				buf.position(hasTransBkdTime);		
		
			FixMessage.getTagStringValue(buf, transBkdTime, 0, transBkdTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTransBkdTime);		
					return null;		
				}		
			}		
			hasTransBkdTime = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getFirstPx() { 		
		if ( hasFirstPx()) {		
			if (hasFirstPx == FixUtils.TAG_HAS_VALUE) {		
				return firstPx; 		
			} else {		
		
				buf.position(hasFirstPx);		
		
			firstPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasFirstPx);		
					return 0;		
				}		
			}		
			hasFirstPx = FixUtils.TAG_HAS_VALUE;		
			return firstPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasFirstPx() { return hasFirstPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFirstPx(long src) {		
		firstPx = src;
		hasFirstPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFirstPx(byte[] src) {		
		if (src == null ) return;
		if (hasFirstPx()) firstPx = FixUtils.TAG_HAS_NO_VALUE;		
		firstPx = FixUtils.longValueOf(src, 0, src.length);
		hasFirstPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFirstPx(String str) {		
		if (str == null ) return;
		if (hasFirstPx()) firstPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		firstPx = FixUtils.longValueOf(src, 0, src.length);
		hasFirstPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLastPx() { 		
		if ( hasLastPx()) {		
			if (hasLastPx == FixUtils.TAG_HAS_VALUE) {		
				return lastPx; 		
			} else {		
		
				buf.position(hasLastPx);		
		
			lastPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLastPx);		
					return 0;		
				}		
			}		
			hasLastPx = FixUtils.TAG_HAS_VALUE;		
			return lastPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastPx() { return hasLastPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLastPx(long src) {		
		lastPx = src;
		hasLastPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastPx(byte[] src) {		
		if (src == null ) return;
		if (hasLastPx()) lastPx = FixUtils.TAG_HAS_NO_VALUE;		
		lastPx = FixUtils.longValueOf(src, 0, src.length);
		hasLastPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLastPx(String str) {		
		if (str == null ) return;
		if (hasLastPx()) lastPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastPx = FixUtils.longValueOf(src, 0, src.length);
		hasLastPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getDealingCapacity() { 		
		if ( hasDealingCapacity()) {		
			if (hasDealingCapacity == FixUtils.TAG_HAS_VALUE) {		
				return dealingCapacity; 		
			} else {		
		
				buf.position(hasDealingCapacity);		
		
			dealingCapacity = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (dealingCapacity != (byte)'P') && (dealingCapacity != (byte)'A') && (dealingCapacity != (byte)'R') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1048);		
				if (err.hasError()) {		
					buf.position(hasDealingCapacity);		
					return (byte)'0';		
				}		
			}		
			hasDealingCapacity = FixUtils.TAG_HAS_VALUE;		
			return dealingCapacity;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDealingCapacity() { return hasDealingCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDealingCapacity(byte src) {		
		dealingCapacity = src;
		hasDealingCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDealingCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasDealingCapacity()) dealingCapacity = (byte)' ';		
		dealingCapacity = src[0];		
		hasDealingCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDealingCapacity(String str) {		
		if (str == null ) return;
		if (hasDealingCapacity()) dealingCapacity = (byte)' ';		
		byte[] src = str.getBytes(); 		
		dealingCapacity = src[0];		
		hasDealingCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMDEntrySpotRate() { 		
		if ( hasMDEntrySpotRate()) {		
			if (hasMDEntrySpotRate == FixUtils.TAG_HAS_VALUE) {		
				return mDEntrySpotRate; 		
			} else {		
		
				buf.position(hasMDEntrySpotRate);		
		
			mDEntrySpotRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntrySpotRate);		
					return 0;		
				}		
			}		
			hasMDEntrySpotRate = FixUtils.TAG_HAS_VALUE;		
			return mDEntrySpotRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDEntrySpotRate() { return hasMDEntrySpotRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntrySpotRate(long src) {		
		mDEntrySpotRate = src;
		hasMDEntrySpotRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDEntrySpotRate(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntrySpotRate()) mDEntrySpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntrySpotRate = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntrySpotRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntrySpotRate(String str) {		
		if (str == null ) return;
		if (hasMDEntrySpotRate()) mDEntrySpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDEntrySpotRate = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntrySpotRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMDEntryForwardPoints() { 		
		if ( hasMDEntryForwardPoints()) {		
			if (hasMDEntryForwardPoints == FixUtils.TAG_HAS_VALUE) {		
				return mDEntryForwardPoints; 		
			} else {		
		
				buf.position(hasMDEntryForwardPoints);		
		
			mDEntryForwardPoints = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntryForwardPoints);		
					return 0;		
				}		
			}		
			hasMDEntryForwardPoints = FixUtils.TAG_HAS_VALUE;		
			return mDEntryForwardPoints;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDEntryForwardPoints() { return hasMDEntryForwardPoints != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntryForwardPoints(long src) {		
		mDEntryForwardPoints = src;
		hasMDEntryForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDEntryForwardPoints(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntryForwardPoints()) mDEntryForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntryForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntryForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntryForwardPoints(String str) {		
		if (str == null ) return;
		if (hasMDEntryForwardPoints()) mDEntryForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDEntryForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntryForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasMDUpdateAction()) s += "MDUpdateAction(279)= " + getMDUpdateAction() + "\n" ; 
		if (hasDeleteReason()) s += "DeleteReason(285)= " + getDeleteReason() + "\n" ; 
		if (hasMDSubBookType()) s += "MDSubBookType(1173)= " + getMDSubBookType() + "\n" ; 
		if (hasMarketDepth()) s += "MarketDepth(264)= " + getMarketDepth() + "\n" ; 
		if (hasMDEntryType()) s += "MDEntryType(269)= " + getMDEntryType() + "\n" ; 
		if (hasMDEntryID()) s += "MDEntryID(278)= " + new String( FixUtils.trim(getMDEntryID()) ) + "\n" ; 
		if (hasMDEntryRefID()) s += "MDEntryRefID(280)= " + new String( FixUtils.trim(getMDEntryRefID()) ) + "\n" ; 
		if (hasMDStreamID()) s += "MDStreamID(1500)= " + new String( FixUtils.trim(getMDStreamID()) ) + "\n" ; 
		if (hasFinancialStatus()) s += "FinancialStatus(291)= " + new String( FixUtils.trim(getFinancialStatus()) ) + "\n" ; 
		if (hasCorporateAction()) s += "CorporateAction(292)= " + new String( FixUtils.trim(getCorporateAction()) ) + "\n" ; 
		if (hasMDEntryPx()) s += "MDEntryPx(270)= " + getMDEntryPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOrdType()) s += "OrdType(40)= " + getOrdType() + "\n" ; 
		if (hasPriceType()) s += "PriceType(423)= " + getPriceType() + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasSettlCurrency()) s += "SettlCurrency(120)= " + new String( FixUtils.trim(getSettlCurrency()) ) + "\n" ; 
		if (hasMDEntrySize()) s += "MDEntrySize(271)= " + getMDEntrySize() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLotType()) s += "LotType(1093)= " + getLotType() + "\n" ; 
		if (hasMDEntryDate()) s += "MDEntryDate(272)= " + new String( FixUtils.trim(getMDEntryDate()) ) + "\n" ; 
		if (hasMDEntryTime()) s += "MDEntryTime(273)= " + new String( FixUtils.trim(getMDEntryTime()) ) + "\n" ; 
		if (hasTickDirection()) s += "TickDirection(274)= " + getTickDirection() + "\n" ; 
		if (hasMDMkt()) s += "MDMkt(275)= " + new String( FixUtils.trim(getMDMkt()) ) + "\n" ; 
		if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 
		if (hasSecurityTradingStatus()) s += "SecurityTradingStatus(326)= " + getSecurityTradingStatus() + "\n" ; 
		if (hasHaltReason()) s += "HaltReason(327)= " + getHaltReason() + "\n" ; 
		if (hasQuoteCondition()) s += "QuoteCondition(276)= " + new String( FixUtils.trim(getQuoteCondition()) ) + "\n" ; 
		if (hasTradeCondition()) s += "TradeCondition(277)= " + new String( FixUtils.trim(getTradeCondition()) ) + "\n" ; 
		if (hasTrdType()) s += "TrdType(828)= " + getTrdType() + "\n" ; 
		if (hasMatchType()) s += "MatchType(574)= " + new String( FixUtils.trim(getMatchType()) ) + "\n" ; 
		if (hasMDEntryOriginator()) s += "MDEntryOriginator(282)= " + new String( FixUtils.trim(getMDEntryOriginator()) ) + "\n" ; 
		if (hasLocationID()) s += "LocationID(283)= " + new String( FixUtils.trim(getLocationID()) ) + "\n" ; 
		if (hasDeskID()) s += "DeskID(284)= " + new String( FixUtils.trim(getDeskID()) ) + "\n" ; 
		if (hasOpenCloseSettlFlag()) s += "OpenCloseSettlFlag(286)= " + new String( FixUtils.trim(getOpenCloseSettlFlag()) ) + "\n" ; 
		if (hasTimeInForce()) s += "TimeInForce(59)= " + getTimeInForce() + "\n" ; 
		if (hasExpireDate()) s += "ExpireDate(432)= " + new String( FixUtils.trim(getExpireDate()) ) + "\n" ; 
		if (hasExpireTime()) s += "ExpireTime(126)= " + new String( FixUtils.trim(getExpireTime()) ) + "\n" ; 
		if (hasMinQty()) s += "MinQty(110)= " + getMinQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasExecInst()) s += "ExecInst(18)= " + new String( FixUtils.trim(getExecInst()) ) + "\n" ; 
		if (hasSellerDays()) s += "SellerDays(287)= " + getSellerDays() + "\n" ; 
		if (hasOrderID()) s += "OrderID(37)= " + new String( FixUtils.trim(getOrderID()) ) + "\n" ; 
		if (hasSecondaryOrderID()) s += "SecondaryOrderID(198)= " + new String( FixUtils.trim(getSecondaryOrderID()) ) + "\n" ; 
		if (hasQuoteEntryID()) s += "QuoteEntryID(299)= " + new String( FixUtils.trim(getQuoteEntryID()) ) + "\n" ; 
		if (hasTradeID()) s += "TradeID(1003)= " + new String( FixUtils.trim(getTradeID()) ) + "\n" ; 
		if (hasMDEntryBuyer()) s += "MDEntryBuyer(288)= " + new String( FixUtils.trim(getMDEntryBuyer()) ) + "\n" ; 
		if (hasMDEntrySeller()) s += "MDEntrySeller(289)= " + new String( FixUtils.trim(getMDEntrySeller()) ) + "\n" ; 
		if (hasNumberOfOrders()) s += "NumberOfOrders(346)= " + getNumberOfOrders() + "\n" ; 
		if (hasMDEntryPositionNo()) s += "MDEntryPositionNo(290)= " + getMDEntryPositionNo() + "\n" ; 
		if (hasScope()) s += "Scope(546)= " + new String( FixUtils.trim(getScope()) ) + "\n" ; 
		if (hasPriceDelta()) s += "PriceDelta(811)= " + getPriceDelta() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasNetChgPrevDay()) s += "NetChgPrevDay(451)= " + getNetChgPrevDay() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasOrderCapacity()) s += "OrderCapacity(528)= " + getOrderCapacity() + "\n" ; 
		if (hasMDOriginType()) s += "MDOriginType(1024)= " + getMDOriginType() + "\n" ; 
		if (hasHighPx()) s += "HighPx(332)= " + getHighPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLowPx()) s += "LowPx(333)= " + getLowPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTradeVolume()) s += "TradeVolume(1020)= " + getTradeVolume() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlType()) s += "SettlType(63)= " + new String( FixUtils.trim(getSettlType()) ) + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasMDQuoteType()) s += "MDQuoteType(1070)= " + getMDQuoteType() + "\n" ; 
		if (hasRptSeq()) s += "RptSeq(83)= " + getRptSeq() + "\n" ; 
		if (hasMDPriceLevel()) s += "MDPriceLevel(1023)= " + getMDPriceLevel() + "\n" ; 
		if (hasTransBkdTime()) s += "TransBkdTime(483)= " + new String( FixUtils.trim(getTransBkdTime()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasFirstPx()) s += "FirstPx(1025)= " + getFirstPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastPx()) s += "LastPx(31)= " + getLastPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDealingCapacity()) s += "DealingCapacity(1048)= " + getDealingCapacity() + "\n" ; 
		if (hasMDEntrySpotRate()) s += "MDEntrySpotRate(1026)= " + getMDEntrySpotRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMDEntryForwardPoints()) s += "MDEntryForwardPoints(1027)= " + getMDEntryForwardPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

		s += instrument.toString();
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.toString();
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.toString();
		s += yieldData.toString();
		s += spreadOrBenchmarkCurveData.toString();
		for (FixRateSource fixRateSource : rateSource) fixRateSource.toString();
		for (FixSecSizesGrp fixSecSizesGrp : secSizesGrp) fixSecSizesGrp.toString();
		for (FixParties fixParties : parties) fixParties.toString();
		for (FixStatsIndGrp fixStatsIndGrp : statsIndGrp) fixStatsIndGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixMDIncGrp)) return false;

		FixMDIncGrp msg = (FixMDIncGrp) o;

		if (!instrument.equals(msg.instrument)) return false;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp)
			if (!fixUndInstrmtGrp.equals(msg.undInstrmtGrp)) return false;
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp)
			if (!fixInstrmtLegGrp.equals(msg.instrmtLegGrp)) return false;
		if (!yieldData.equals(msg.yieldData)) return false;
		if (!spreadOrBenchmarkCurveData.equals(msg.spreadOrBenchmarkCurveData)) return false;
		for (FixRateSource fixRateSource : rateSource)
			if (!fixRateSource.equals(msg.rateSource)) return false;
		for (FixSecSizesGrp fixSecSizesGrp : secSizesGrp)
			if (!fixSecSizesGrp.equals(msg.secSizesGrp)) return false;
		for (FixParties fixParties : parties)
			if (!fixParties.equals(msg.parties)) return false;
		for (FixStatsIndGrp fixStatsIndGrp : statsIndGrp)
			if (!fixStatsIndGrp.equals(msg.statsIndGrp)) return false;
		if ((hasMDUpdateAction() && !msg.hasMDUpdateAction()) || (!hasMDUpdateAction() && msg.hasMDUpdateAction())) return false;
		if (!(!hasMDUpdateAction() && !msg.hasMDUpdateAction()) && !(getMDUpdateAction()==msg.getMDUpdateAction())) return false;
		if ((hasDeleteReason() && !msg.hasDeleteReason()) || (!hasDeleteReason() && msg.hasDeleteReason())) return false;
		if (!(!hasDeleteReason() && !msg.hasDeleteReason()) && !(getDeleteReason()==msg.getDeleteReason())) return false;
		if ((hasMDSubBookType() && !msg.hasMDSubBookType()) || (!hasMDSubBookType() && msg.hasMDSubBookType())) return false;
		if (!(!hasMDSubBookType() && !msg.hasMDSubBookType()) && !(getMDSubBookType()==msg.getMDSubBookType())) return false;
		if ((hasMarketDepth() && !msg.hasMarketDepth()) || (!hasMarketDepth() && msg.hasMarketDepth())) return false;
		if (!(!hasMarketDepth() && !msg.hasMarketDepth()) && !(getMarketDepth()==msg.getMarketDepth())) return false;
		if ((hasMDEntryType() && !msg.hasMDEntryType()) || (!hasMDEntryType() && msg.hasMDEntryType())) return false;
		if (!(!hasMDEntryType() && !msg.hasMDEntryType()) && !(getMDEntryType()==msg.getMDEntryType())) return false;
		if ((hasMDEntryID() && !msg.hasMDEntryID()) || (!hasMDEntryID() && msg.hasMDEntryID())) return false;
		if (!(!hasMDEntryID() && !msg.hasMDEntryID()) && !FixUtils.equals(getMDEntryID(), msg.getMDEntryID())) return false;
		if ((hasMDEntryRefID() && !msg.hasMDEntryRefID()) || (!hasMDEntryRefID() && msg.hasMDEntryRefID())) return false;
		if (!(!hasMDEntryRefID() && !msg.hasMDEntryRefID()) && !FixUtils.equals(getMDEntryRefID(), msg.getMDEntryRefID())) return false;
		if ((hasMDStreamID() && !msg.hasMDStreamID()) || (!hasMDStreamID() && msg.hasMDStreamID())) return false;
		if (!(!hasMDStreamID() && !msg.hasMDStreamID()) && !FixUtils.equals(getMDStreamID(), msg.getMDStreamID())) return false;
		if ((hasFinancialStatus() && !msg.hasFinancialStatus()) || (!hasFinancialStatus() && msg.hasFinancialStatus())) return false;
		if (!(!hasFinancialStatus() && !msg.hasFinancialStatus()) && !FixUtils.equals(getFinancialStatus(), msg.getFinancialStatus())) return false;
		if ((hasCorporateAction() && !msg.hasCorporateAction()) || (!hasCorporateAction() && msg.hasCorporateAction())) return false;
		if (!(!hasCorporateAction() && !msg.hasCorporateAction()) && !FixUtils.equals(getCorporateAction(), msg.getCorporateAction())) return false;
		if ((hasMDEntryPx() && !msg.hasMDEntryPx()) || (!hasMDEntryPx() && msg.hasMDEntryPx())) return false;
		if (!(!hasMDEntryPx() && !msg.hasMDEntryPx()) && !(getMDEntryPx()==msg.getMDEntryPx())) return false;
		if ((hasOrdType() && !msg.hasOrdType()) || (!hasOrdType() && msg.hasOrdType())) return false;
		if (!(!hasOrdType() && !msg.hasOrdType()) && !(getOrdType()==msg.getOrdType())) return false;
		if ((hasPriceType() && !msg.hasPriceType()) || (!hasPriceType() && msg.hasPriceType())) return false;
		if (!(!hasPriceType() && !msg.hasPriceType()) && !(getPriceType()==msg.getPriceType())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasSettlCurrency() && !msg.hasSettlCurrency()) || (!hasSettlCurrency() && msg.hasSettlCurrency())) return false;
		if (!(!hasSettlCurrency() && !msg.hasSettlCurrency()) && !FixUtils.equals(getSettlCurrency(), msg.getSettlCurrency())) return false;
		if ((hasMDEntrySize() && !msg.hasMDEntrySize()) || (!hasMDEntrySize() && msg.hasMDEntrySize())) return false;
		if (!(!hasMDEntrySize() && !msg.hasMDEntrySize()) && !(getMDEntrySize()==msg.getMDEntrySize())) return false;
		if ((hasLotType() && !msg.hasLotType()) || (!hasLotType() && msg.hasLotType())) return false;
		if (!(!hasLotType() && !msg.hasLotType()) && !(getLotType()==msg.getLotType())) return false;
		if ((hasMDEntryDate() && !msg.hasMDEntryDate()) || (!hasMDEntryDate() && msg.hasMDEntryDate())) return false;
		if (!(!hasMDEntryDate() && !msg.hasMDEntryDate()) ) return false;
		if ((hasMDEntryTime() && !msg.hasMDEntryTime()) || (!hasMDEntryTime() && msg.hasMDEntryTime())) return false;
		if (!(!hasMDEntryTime() && !msg.hasMDEntryTime()) ) return false;
		if ((hasTickDirection() && !msg.hasTickDirection()) || (!hasTickDirection() && msg.hasTickDirection())) return false;
		if (!(!hasTickDirection() && !msg.hasTickDirection()) && !(getTickDirection()==msg.getTickDirection())) return false;
		if ((hasMDMkt() && !msg.hasMDMkt()) || (!hasMDMkt() && msg.hasMDMkt())) return false;
		if (!(!hasMDMkt() && !msg.hasMDMkt()) && !FixUtils.equals(getMDMkt(), msg.getMDMkt())) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		if ((hasSecurityTradingStatus() && !msg.hasSecurityTradingStatus()) || (!hasSecurityTradingStatus() && msg.hasSecurityTradingStatus())) return false;
		if (!(!hasSecurityTradingStatus() && !msg.hasSecurityTradingStatus()) && !(getSecurityTradingStatus()==msg.getSecurityTradingStatus())) return false;
		if ((hasHaltReason() && !msg.hasHaltReason()) || (!hasHaltReason() && msg.hasHaltReason())) return false;
		if (!(!hasHaltReason() && !msg.hasHaltReason()) && !(getHaltReason()==msg.getHaltReason())) return false;
		if ((hasQuoteCondition() && !msg.hasQuoteCondition()) || (!hasQuoteCondition() && msg.hasQuoteCondition())) return false;
		if (!(!hasQuoteCondition() && !msg.hasQuoteCondition()) && !FixUtils.equals(getQuoteCondition(), msg.getQuoteCondition())) return false;
		if ((hasTradeCondition() && !msg.hasTradeCondition()) || (!hasTradeCondition() && msg.hasTradeCondition())) return false;
		if (!(!hasTradeCondition() && !msg.hasTradeCondition()) && !FixUtils.equals(getTradeCondition(), msg.getTradeCondition())) return false;
		if ((hasTrdType() && !msg.hasTrdType()) || (!hasTrdType() && msg.hasTrdType())) return false;
		if (!(!hasTrdType() && !msg.hasTrdType()) && !(getTrdType()==msg.getTrdType())) return false;
		if ((hasMatchType() && !msg.hasMatchType()) || (!hasMatchType() && msg.hasMatchType())) return false;
		if (!(!hasMatchType() && !msg.hasMatchType()) && !FixUtils.equals(getMatchType(), msg.getMatchType())) return false;
		if ((hasMDEntryOriginator() && !msg.hasMDEntryOriginator()) || (!hasMDEntryOriginator() && msg.hasMDEntryOriginator())) return false;
		if (!(!hasMDEntryOriginator() && !msg.hasMDEntryOriginator()) && !FixUtils.equals(getMDEntryOriginator(), msg.getMDEntryOriginator())) return false;
		if ((hasLocationID() && !msg.hasLocationID()) || (!hasLocationID() && msg.hasLocationID())) return false;
		if (!(!hasLocationID() && !msg.hasLocationID()) && !FixUtils.equals(getLocationID(), msg.getLocationID())) return false;
		if ((hasDeskID() && !msg.hasDeskID()) || (!hasDeskID() && msg.hasDeskID())) return false;
		if (!(!hasDeskID() && !msg.hasDeskID()) && !FixUtils.equals(getDeskID(), msg.getDeskID())) return false;
		if ((hasOpenCloseSettlFlag() && !msg.hasOpenCloseSettlFlag()) || (!hasOpenCloseSettlFlag() && msg.hasOpenCloseSettlFlag())) return false;
		if (!(!hasOpenCloseSettlFlag() && !msg.hasOpenCloseSettlFlag()) && !FixUtils.equals(getOpenCloseSettlFlag(), msg.getOpenCloseSettlFlag())) return false;
		if ((hasTimeInForce() && !msg.hasTimeInForce()) || (!hasTimeInForce() && msg.hasTimeInForce())) return false;
		if (!(!hasTimeInForce() && !msg.hasTimeInForce()) && !(getTimeInForce()==msg.getTimeInForce())) return false;
		if ((hasExpireDate() && !msg.hasExpireDate()) || (!hasExpireDate() && msg.hasExpireDate())) return false;
		if (!(!hasExpireDate() && !msg.hasExpireDate()) ) return false;
		if ((hasExpireTime() && !msg.hasExpireTime()) || (!hasExpireTime() && msg.hasExpireTime())) return false;
		if (!(!hasExpireTime() && !msg.hasExpireTime()) ) return false;
		if ((hasMinQty() && !msg.hasMinQty()) || (!hasMinQty() && msg.hasMinQty())) return false;
		if (!(!hasMinQty() && !msg.hasMinQty()) && !(getMinQty()==msg.getMinQty())) return false;
		if ((hasExecInst() && !msg.hasExecInst()) || (!hasExecInst() && msg.hasExecInst())) return false;
		if (!(!hasExecInst() && !msg.hasExecInst()) && !FixUtils.equals(getExecInst(), msg.getExecInst())) return false;
		if ((hasSellerDays() && !msg.hasSellerDays()) || (!hasSellerDays() && msg.hasSellerDays())) return false;
		if (!(!hasSellerDays() && !msg.hasSellerDays()) && !(getSellerDays()==msg.getSellerDays())) return false;
		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasSecondaryOrderID() && !msg.hasSecondaryOrderID()) || (!hasSecondaryOrderID() && msg.hasSecondaryOrderID())) return false;
		if (!(!hasSecondaryOrderID() && !msg.hasSecondaryOrderID()) && !FixUtils.equals(getSecondaryOrderID(), msg.getSecondaryOrderID())) return false;
		if ((hasQuoteEntryID() && !msg.hasQuoteEntryID()) || (!hasQuoteEntryID() && msg.hasQuoteEntryID())) return false;
		if (!(!hasQuoteEntryID() && !msg.hasQuoteEntryID()) && !FixUtils.equals(getQuoteEntryID(), msg.getQuoteEntryID())) return false;
		if ((hasTradeID() && !msg.hasTradeID()) || (!hasTradeID() && msg.hasTradeID())) return false;
		if (!(!hasTradeID() && !msg.hasTradeID()) && !FixUtils.equals(getTradeID(), msg.getTradeID())) return false;
		if ((hasMDEntryBuyer() && !msg.hasMDEntryBuyer()) || (!hasMDEntryBuyer() && msg.hasMDEntryBuyer())) return false;
		if (!(!hasMDEntryBuyer() && !msg.hasMDEntryBuyer()) && !FixUtils.equals(getMDEntryBuyer(), msg.getMDEntryBuyer())) return false;
		if ((hasMDEntrySeller() && !msg.hasMDEntrySeller()) || (!hasMDEntrySeller() && msg.hasMDEntrySeller())) return false;
		if (!(!hasMDEntrySeller() && !msg.hasMDEntrySeller()) && !FixUtils.equals(getMDEntrySeller(), msg.getMDEntrySeller())) return false;
		if ((hasNumberOfOrders() && !msg.hasNumberOfOrders()) || (!hasNumberOfOrders() && msg.hasNumberOfOrders())) return false;
		if (!(!hasNumberOfOrders() && !msg.hasNumberOfOrders()) && !(getNumberOfOrders()==msg.getNumberOfOrders())) return false;
		if ((hasMDEntryPositionNo() && !msg.hasMDEntryPositionNo()) || (!hasMDEntryPositionNo() && msg.hasMDEntryPositionNo())) return false;
		if (!(!hasMDEntryPositionNo() && !msg.hasMDEntryPositionNo()) && !(getMDEntryPositionNo()==msg.getMDEntryPositionNo())) return false;
		if ((hasScope() && !msg.hasScope()) || (!hasScope() && msg.hasScope())) return false;
		if (!(!hasScope() && !msg.hasScope()) && !FixUtils.equals(getScope(), msg.getScope())) return false;
		if ((hasPriceDelta() && !msg.hasPriceDelta()) || (!hasPriceDelta() && msg.hasPriceDelta())) return false;
		if (!(!hasPriceDelta() && !msg.hasPriceDelta()) && !(getPriceDelta()==msg.getPriceDelta())) return false;
		if ((hasNetChgPrevDay() && !msg.hasNetChgPrevDay()) || (!hasNetChgPrevDay() && msg.hasNetChgPrevDay())) return false;
		if (!(!hasNetChgPrevDay() && !msg.hasNetChgPrevDay()) && !(getNetChgPrevDay()==msg.getNetChgPrevDay())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasOrderCapacity() && !msg.hasOrderCapacity()) || (!hasOrderCapacity() && msg.hasOrderCapacity())) return false;
		if (!(!hasOrderCapacity() && !msg.hasOrderCapacity()) && !(getOrderCapacity()==msg.getOrderCapacity())) return false;
		if ((hasMDOriginType() && !msg.hasMDOriginType()) || (!hasMDOriginType() && msg.hasMDOriginType())) return false;
		if (!(!hasMDOriginType() && !msg.hasMDOriginType()) && !(getMDOriginType()==msg.getMDOriginType())) return false;
		if ((hasHighPx() && !msg.hasHighPx()) || (!hasHighPx() && msg.hasHighPx())) return false;
		if (!(!hasHighPx() && !msg.hasHighPx()) && !(getHighPx()==msg.getHighPx())) return false;
		if ((hasLowPx() && !msg.hasLowPx()) || (!hasLowPx() && msg.hasLowPx())) return false;
		if (!(!hasLowPx() && !msg.hasLowPx()) && !(getLowPx()==msg.getLowPx())) return false;
		if ((hasTradeVolume() && !msg.hasTradeVolume()) || (!hasTradeVolume() && msg.hasTradeVolume())) return false;
		if (!(!hasTradeVolume() && !msg.hasTradeVolume()) && !(getTradeVolume()==msg.getTradeVolume())) return false;
		if ((hasSettlType() && !msg.hasSettlType()) || (!hasSettlType() && msg.hasSettlType())) return false;
		if (!(!hasSettlType() && !msg.hasSettlType()) && !FixUtils.equals(getSettlType(), msg.getSettlType())) return false;
		if ((hasSettlDate() && !msg.hasSettlDate()) || (!hasSettlDate() && msg.hasSettlDate())) return false;
		if (!(!hasSettlDate() && !msg.hasSettlDate()) ) return false;
		if ((hasMDQuoteType() && !msg.hasMDQuoteType()) || (!hasMDQuoteType() && msg.hasMDQuoteType())) return false;
		if (!(!hasMDQuoteType() && !msg.hasMDQuoteType()) && !(getMDQuoteType()==msg.getMDQuoteType())) return false;
		if ((hasRptSeq() && !msg.hasRptSeq()) || (!hasRptSeq() && msg.hasRptSeq())) return false;
		if (!(!hasRptSeq() && !msg.hasRptSeq()) && !(getRptSeq()==msg.getRptSeq())) return false;
		if ((hasMDPriceLevel() && !msg.hasMDPriceLevel()) || (!hasMDPriceLevel() && msg.hasMDPriceLevel())) return false;
		if (!(!hasMDPriceLevel() && !msg.hasMDPriceLevel()) && !(getMDPriceLevel()==msg.getMDPriceLevel())) return false;
		if ((hasTransBkdTime() && !msg.hasTransBkdTime()) || (!hasTransBkdTime() && msg.hasTransBkdTime())) return false;
		if (!(!hasTransBkdTime() && !msg.hasTransBkdTime()) ) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if (!(!hasTransactTime() && !msg.hasTransactTime()) ) return false;
		if ((hasFirstPx() && !msg.hasFirstPx()) || (!hasFirstPx() && msg.hasFirstPx())) return false;
		if (!(!hasFirstPx() && !msg.hasFirstPx()) && !(getFirstPx()==msg.getFirstPx())) return false;
		if ((hasLastPx() && !msg.hasLastPx()) || (!hasLastPx() && msg.hasLastPx())) return false;
		if (!(!hasLastPx() && !msg.hasLastPx()) && !(getLastPx()==msg.getLastPx())) return false;
		if ((hasDealingCapacity() && !msg.hasDealingCapacity()) || (!hasDealingCapacity() && msg.hasDealingCapacity())) return false;
		if (!(!hasDealingCapacity() && !msg.hasDealingCapacity()) && !(getDealingCapacity()==msg.getDealingCapacity())) return false;
		if ((hasMDEntrySpotRate() && !msg.hasMDEntrySpotRate()) || (!hasMDEntrySpotRate() && msg.hasMDEntrySpotRate())) return false;
		if (!(!hasMDEntrySpotRate() && !msg.hasMDEntrySpotRate()) && !(getMDEntrySpotRate()==msg.getMDEntrySpotRate())) return false;
		if ((hasMDEntryForwardPoints() && !msg.hasMDEntryForwardPoints()) || (!hasMDEntryForwardPoints() && msg.hasMDEntryForwardPoints())) return false;
		if (!(!hasMDEntryForwardPoints() && !msg.hasMDEntryForwardPoints()) && !(getMDEntryForwardPoints()==msg.getMDEntryForwardPoints())) return false;
		return true;
	}
	public FixMDIncGrp clone ( FixMDIncGrp out ) {
		if ( hasMDUpdateAction())
			out.setMDUpdateAction(getMDUpdateAction());
		if ( hasDeleteReason())
			out.setDeleteReason(getDeleteReason());
		if ( hasMDSubBookType())
			out.setMDSubBookType(getMDSubBookType());
		if ( hasMarketDepth())
			out.setMarketDepth(getMarketDepth());
		if ( hasMDEntryType())
			out.setMDEntryType(getMDEntryType());
		if ( hasMDEntryID())
			out.setMDEntryID(getMDEntryID());
		if ( hasMDEntryRefID())
			out.setMDEntryRefID(getMDEntryRefID());
		if ( hasMDStreamID())
			out.setMDStreamID(getMDStreamID());
		if ( hasFinancialStatus())
			out.setFinancialStatus(getFinancialStatus());
		if ( hasCorporateAction())
			out.setCorporateAction(getCorporateAction());
		if ( hasMDEntryPx())
			out.setMDEntryPx(getMDEntryPx());
		if ( hasOrdType())
			out.setOrdType(getOrdType());
		if ( hasPriceType())
			out.setPriceType(getPriceType());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasSettlCurrency())
			out.setSettlCurrency(getSettlCurrency());
		if ( hasMDEntrySize())
			out.setMDEntrySize(getMDEntrySize());
		if ( hasLotType())
			out.setLotType(getLotType());
		if ( hasMDEntryDate())
			out.setMDEntryDate(getMDEntryDate());
		if ( hasMDEntryTime())
			out.setMDEntryTime(getMDEntryTime());
		if ( hasTickDirection())
			out.setTickDirection(getTickDirection());
		if ( hasMDMkt())
			out.setMDMkt(getMDMkt());
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		if ( hasSecurityTradingStatus())
			out.setSecurityTradingStatus(getSecurityTradingStatus());
		if ( hasHaltReason())
			out.setHaltReason(getHaltReason());
		if ( hasQuoteCondition())
			out.setQuoteCondition(getQuoteCondition());
		if ( hasTradeCondition())
			out.setTradeCondition(getTradeCondition());
		if ( hasTrdType())
			out.setTrdType(getTrdType());
		if ( hasMatchType())
			out.setMatchType(getMatchType());
		if ( hasMDEntryOriginator())
			out.setMDEntryOriginator(getMDEntryOriginator());
		if ( hasLocationID())
			out.setLocationID(getLocationID());
		if ( hasDeskID())
			out.setDeskID(getDeskID());
		if ( hasOpenCloseSettlFlag())
			out.setOpenCloseSettlFlag(getOpenCloseSettlFlag());
		if ( hasTimeInForce())
			out.setTimeInForce(getTimeInForce());
		if ( hasExpireDate())
			out.setExpireDate(getExpireDate());
		if ( hasExpireTime())
			out.setExpireTime(getExpireTime());
		if ( hasMinQty())
			out.setMinQty(getMinQty());
		if ( hasExecInst())
			out.setExecInst(getExecInst());
		if ( hasSellerDays())
			out.setSellerDays(getSellerDays());
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasSecondaryOrderID())
			out.setSecondaryOrderID(getSecondaryOrderID());
		if ( hasQuoteEntryID())
			out.setQuoteEntryID(getQuoteEntryID());
		if ( hasTradeID())
			out.setTradeID(getTradeID());
		if ( hasMDEntryBuyer())
			out.setMDEntryBuyer(getMDEntryBuyer());
		if ( hasMDEntrySeller())
			out.setMDEntrySeller(getMDEntrySeller());
		if ( hasNumberOfOrders())
			out.setNumberOfOrders(getNumberOfOrders());
		if ( hasMDEntryPositionNo())
			out.setMDEntryPositionNo(getMDEntryPositionNo());
		if ( hasScope())
			out.setScope(getScope());
		if ( hasPriceDelta())
			out.setPriceDelta(getPriceDelta());
		if ( hasNetChgPrevDay())
			out.setNetChgPrevDay(getNetChgPrevDay());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasOrderCapacity())
			out.setOrderCapacity(getOrderCapacity());
		if ( hasMDOriginType())
			out.setMDOriginType(getMDOriginType());
		if ( hasHighPx())
			out.setHighPx(getHighPx());
		if ( hasLowPx())
			out.setLowPx(getLowPx());
		if ( hasTradeVolume())
			out.setTradeVolume(getTradeVolume());
		if ( hasSettlType())
			out.setSettlType(getSettlType());
		if ( hasSettlDate())
			out.setSettlDate(getSettlDate());
		if ( hasMDQuoteType())
			out.setMDQuoteType(getMDQuoteType());
		if ( hasRptSeq())
			out.setRptSeq(getRptSeq());
		if ( hasMDPriceLevel())
			out.setMDPriceLevel(getMDPriceLevel());
		if ( hasTransBkdTime())
			out.setTransBkdTime(getTransBkdTime());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasFirstPx())
			out.setFirstPx(getFirstPx());
		if ( hasLastPx())
			out.setLastPx(getLastPx());
		if ( hasDealingCapacity())
			out.setDealingCapacity(getDealingCapacity());
		if ( hasMDEntrySpotRate())
			out.setMDEntrySpotRate(getMDEntrySpotRate());
		if ( hasMDEntryForwardPoints())
			out.setMDEntryForwardPoints(getMDEntryForwardPoints());
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
		if (yieldData.hasGroup())
			out.yieldData = yieldData.clone( out.yieldData);
		if (spreadOrBenchmarkCurveData.hasGroup())
			out.spreadOrBenchmarkCurveData = spreadOrBenchmarkCurveData.clone( out.spreadOrBenchmarkCurveData);
		count = 0;
		for (FixRateSource fixRateSource : rateSource) {
			if (!fixRateSource.hasGroup()) continue;
			out.rateSource[count] = fixRateSource.clone( out.rateSource[count] );
			count++;
		}
		count = 0;
		for (FixSecSizesGrp fixSecSizesGrp : secSizesGrp) {
			if (!fixSecSizesGrp.hasGroup()) continue;
			out.secSizesGrp[count] = fixSecSizesGrp.clone( out.secSizesGrp[count] );
			count++;
		}
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixStatsIndGrp fixStatsIndGrp : statsIndGrp) {
			if (!fixStatsIndGrp.hasGroup()) continue;
			out.statsIndGrp[count] = fixStatsIndGrp.clone( out.statsIndGrp[count] );
			count++;
		}
		return out;
	}

}
