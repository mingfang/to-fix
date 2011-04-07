package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixAllocationReport extends FixInMessage {
	private short hasAllocReportID;
	byte[] allocReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocID;
	byte[] allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocTransType;
	byte allocTransType = (byte)' ';		
	private short hasAllocReportRefID;
	byte[] allocReportRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocCancReplaceReason;
	long allocCancReplaceReason = 0;		
	private short hasSecondaryAllocID;
	byte[] secondaryAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocReportType;
	long allocReportType = 0;		
	private short hasAllocStatus;
	long allocStatus = 0;		
	private short hasAllocRejCode;
	long allocRejCode = 0;		
	private short hasRefAllocID;
	byte[] refAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocIntermedReqType;
	long allocIntermedReqType = 0;		
	private short hasAllocLinkID;
	byte[] allocLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocLinkType;
	long allocLinkType = 0;		
	private short hasBookingRefID;
	byte[] bookingRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTrdType;
	long trdType = 0;		
	private short hasTrdSubType;
	long trdSubType = 0;		
	private short hasMultiLegReportingType;
	byte multiLegReportingType = (byte)' ';		
	private short hasCustOrderCapacity;
	long custOrderCapacity = 0;		
	private short hasTradeInputSource;
	byte[] tradeInputSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRndPx;
	long rndPx = 0;		
	private short hasMessageEventSource;
	byte[] messageEventSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeInputDevice;
	byte[] tradeInputDevice = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAvgPxIndicator;
	long avgPxIndicator = 0;		
	private short hasAllocNoOrdersType;
	long allocNoOrdersType = 0;		
	private short hasPreviouslyReported;
		boolean previouslyReported = false;		
	private short hasReversalIndicator;
		boolean reversalIndicator = false;		
	private short hasMatchType;
	byte[] matchType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasQuantity;
	long quantity = 0;		
	private short hasQtyType;
	long qtyType = 0;		
	private short hasLastMkt;
	byte[] lastMkt = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeOriginationDate;
	byte[] tradeOriginationDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPriceType;
	long priceType = 0;		
	private short hasAvgPx;
	long avgPx = 0;		
	private short hasAvgParPx;
	long avgParPx = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasAvgPxPrecision;
	long avgPxPrecision = 0;		
	private short hasTradeDate;
	byte[] tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasSettlType;
	byte[] settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlDate;
	byte[] settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasBookingType;
	long bookingType = 0;		
	private short hasGrossTradeAmt;
	long grossTradeAmt = 0;		
	private short hasConcession;
	long concession = 0;		
	private short hasTotalTakedown;
	long totalTakedown = 0;		
	private short hasNetMoney;
	long netMoney = 0;		
	private short hasPositionEffect;
	byte positionEffect = (byte)' ';		
	private short hasAutoAcceptIndicator;
		boolean autoAcceptIndicator = false;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasNumDaysInterest;
	long numDaysInterest = 0;		
	private short hasAccruedInterestRate;
	long accruedInterestRate = 0;		
	private short hasAccruedInterestAmt;
	long accruedInterestAmt = 0;		
	private short hasTotalAccruedInterestAmt;
	long totalAccruedInterestAmt = 0;		
	private short hasInterestAtMaturity;
	long interestAtMaturity = 0;		
	private short hasEndAccruedInterestAmt;
	long endAccruedInterestAmt = 0;		
	private short hasStartCash;
	long startCash = 0;		
	private short hasEndCash;
	long endCash = 0;		
	private short hasLegalConfirm;
		boolean legalConfirm = false;		
	private short hasTotNoAllocs;
	long totNoAllocs = 0;		
	private short hasLastFragment;
		boolean lastFragment = false;		
	public FixOrdAllocGrp[] ordAllocGrp;
	public FixExecAllocGrp[] execAllocGrp;
	public FixInstrument instrument;
	public FixInstrumentExtension instrumentExtension;
	public FixFinancingDetails financingDetails;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	public FixParties[] parties;
	public FixStipulations[] stipulations;
	public FixYieldData yieldData;
	public FixPositionAmountData[] positionAmountData;
	public FixAllocGrp[] allocGrp;
	public FixRateSource[] rateSource;
	
	public FixAllocationReport() {
		super(FixMessageInfo.MessageTypes.ALLOCATIONREPORT);


		hasAllocReportID = FixUtils.TAG_HAS_NO_VALUE;		
		allocReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocTransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocReportRefID = FixUtils.TAG_HAS_NO_VALUE;		
		allocReportRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocCancReplaceReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecondaryAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocReportType = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		hasRefAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		refAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocIntermedReqType = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocLinkID = FixUtils.TAG_HAS_NO_VALUE;		
		allocLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocLinkType = FixUtils.TAG_HAS_NO_VALUE;		
		hasBookingRefID = FixUtils.TAG_HAS_NO_VALUE;		
		bookingRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTrdSubType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMultiLegReportingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCustOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeInputSource = FixUtils.TAG_HAS_NO_VALUE;		
		tradeInputSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRndPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasMessageEventSource = FixUtils.TAG_HAS_NO_VALUE;		
		messageEventSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeInputDevice = FixUtils.TAG_HAS_NO_VALUE;		
		tradeInputDevice = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAvgPxIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocNoOrdersType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPreviouslyReported = FixUtils.TAG_HAS_NO_VALUE;		
		hasReversalIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasMatchType = FixUtils.TAG_HAS_NO_VALUE;		
		matchType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasQuantity = FixUtils.TAG_HAS_NO_VALUE;		
		hasQtyType = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastMkt = FixUtils.TAG_HAS_NO_VALUE;		
		lastMkt = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeOriginationDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeOriginationDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasAvgParPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasAvgPxPrecision = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasBookingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasGrossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasConcession = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotalTakedown = FixUtils.TAG_HAS_NO_VALUE;		
		hasNetMoney = FixUtils.TAG_HAS_NO_VALUE;		
		hasPositionEffect = FixUtils.TAG_HAS_NO_VALUE;		
		hasAutoAcceptIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasNumDaysInterest = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccruedInterestRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotalAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasInterestAtMaturity = FixUtils.TAG_HAS_NO_VALUE;		
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasStartCash = FixUtils.TAG_HAS_NO_VALUE;		
		hasEndCash = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegalConfirm = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotNoAllocs = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastFragment = FixUtils.TAG_HAS_NO_VALUE;		
		ordAllocGrp = new FixOrdAllocGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) ordAllocGrp[i] = new FixOrdAllocGrp();
		execAllocGrp = new FixExecAllocGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) execAllocGrp[i] = new FixExecAllocGrp();
		instrument = new FixInstrument();
		instrumentExtension = new FixInstrumentExtension();
		financingDetails = new FixFinancingDetails();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		stipulations = new FixStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) stipulations[i] = new FixStipulations();
		yieldData = new FixYieldData();
		positionAmountData = new FixPositionAmountData[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) positionAmountData[i] = new FixPositionAmountData();
		allocGrp = new FixAllocGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) allocGrp[i] = new FixAllocGrp();
		rateSource = new FixRateSource[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rateSource[i] = new FixRateSource();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.ALLOCREPORTID_INT:		
            		hasAllocReportID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCID_INT:		
            		hasAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCTRANSTYPE_INT:		
            		hasAllocTransType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCREPORTREFID_INT:		
            		hasAllocReportRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCCANCREPLACEREASON_INT:		
            		hasAllocCancReplaceReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYALLOCID_INT:		
            		hasSecondaryAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCREPORTTYPE_INT:		
            		hasAllocReportType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCSTATUS_INT:		
            		hasAllocStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCREJCODE_INT:		
            		hasAllocRejCode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REFALLOCID_INT:		
            		hasRefAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCINTERMEDREQTYPE_INT:		
            		hasAllocIntermedReqType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCLINKID_INT:		
            		hasAllocLinkID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCLINKTYPE_INT:		
            		hasAllocLinkType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BOOKINGREFID_INT:		
            		hasBookingRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
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
            	case FixTags.MULTILEGREPORTINGTYPE_INT:		
            		hasMultiLegReportingType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CUSTORDERCAPACITY_INT:		
            		hasCustOrderCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEINPUTSOURCE_INT:		
            		hasTradeInputSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RNDPX_INT:		
            		hasRndPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MESSAGEEVENTSOURCE_INT:		
            		hasMessageEventSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEINPUTDEVICE_INT:		
            		hasTradeInputDevice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AVGPXINDICATOR_INT:		
            		hasAvgPxIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCNOORDERSTYPE_INT:		
            		hasAllocNoOrdersType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PREVIOUSLYREPORTED_INT:		
            		hasPreviouslyReported = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REVERSALINDICATOR_INT:		
            		hasReversalIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MATCHTYPE_INT:		
            		hasMatchType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QUANTITY_INT:		
            		hasQuantity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QTYTYPE_INT:		
            		hasQtyType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTMKT_INT:		
            		hasLastMkt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEORIGINATIONDATE_INT:		
            		hasTradeOriginationDate = (short) buf.position();		
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
            	case FixTags.PRICETYPE_INT:		
            		hasPriceType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AVGPX_INT:		
            		hasAvgPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AVGPARPX_INT:		
            		hasAvgParPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AVGPXPRECISION_INT:		
            		hasAvgPxPrecision = (short) buf.position();		
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
            	case FixTags.SETTLTYPE_INT:		
            		hasSettlType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLDATE_INT:		
            		hasSettlDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BOOKINGTYPE_INT:		
            		hasBookingType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.GROSSTRADEAMT_INT:		
            		hasGrossTradeAmt = (short) buf.position();		
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
            	case FixTags.POSITIONEFFECT_INT:		
            		hasPositionEffect = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AUTOACCEPTINDICATOR_INT:		
            		hasAutoAcceptIndicator = (short) buf.position();		
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
            	case FixTags.NUMDAYSINTEREST_INT:		
            		hasNumDaysInterest = (short) buf.position();		
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
            	case FixTags.TOTALACCRUEDINTERESTAMT_INT:		
            		hasTotalAccruedInterestAmt = (short) buf.position();		
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
            	case FixTags.LEGALCONFIRM_INT:		
            		hasLegalConfirm = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TOTNOALLOCS_INT:		
            		hasTotNoAllocs = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTFRAGMENT_INT:		
            		hasLastFragment = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOORDERS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !ordAllocGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = ordAllocGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOEXECS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !execAllocGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = execAllocGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
        			} else if ( spreadOrBenchmarkCurveData.isKeyTag(tag)) {
        				tag = spreadOrBenchmarkCurveData.setBuffer( tag, buf, err);		
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
        			} else if ( yieldData.isKeyTag(tag)) {
        				tag = yieldData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
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
        			} else if ( tag == FixTags.NOALLOCS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !allocGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = allocGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
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
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else break; //TODO INVALID_TAG error
					}

			}

        		if (err.hasError()) return;

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	public boolean hasRequiredTags(FixValidationError err) {
		standardHeader.hasRequiredTags(err); if (err.hasError()) return false; 

		if (!hasAllocReportID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag AllocReportID missing", FixTags.ALLOCREPORTID_INT, FixMessageInfo.MessageTypes.ALLOCATIONREPORT);
			return false;
		}
		if (!hasAllocTransType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag AllocTransType missing", FixTags.ALLOCTRANSTYPE_INT, FixMessageInfo.MessageTypes.ALLOCATIONREPORT);
			return false;
		}
		if (!hasAllocReportType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag AllocReportType missing", FixTags.ALLOCREPORTTYPE_INT, FixMessageInfo.MessageTypes.ALLOCATIONREPORT);
			return false;
		}
		if (!hasAllocStatus()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag AllocStatus missing", FixTags.ALLOCSTATUS_INT, FixMessageInfo.MessageTypes.ALLOCATIONREPORT);
			return false;
		}
		if (!hasSide()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Side missing", FixTags.SIDE_INT, FixMessageInfo.MessageTypes.ALLOCATIONREPORT);
			return false;
		}
		if (!hasQuantity()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Quantity missing", FixTags.QUANTITY_INT, FixMessageInfo.MessageTypes.ALLOCATIONREPORT);
			return false;
		}
		if (!hasAvgPx()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag AvgPx missing", FixTags.AVGPX_INT, FixMessageInfo.MessageTypes.ALLOCATIONREPORT);
			return false;
		}
		if (!hasTradeDate()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TradeDate missing", FixTags.TRADEDATE_INT, FixMessageInfo.MessageTypes.ALLOCATIONREPORT);
			return false;
		}
		if (instrument.isRequired) instrument.hasRequiredTags(err); if (err.hasError()) return false;
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getAllocReportID();		
		getAllocID();		
		getAllocTransType();		
		getAllocReportRefID();		
		getAllocCancReplaceReason();		
		getSecondaryAllocID();		
		getAllocReportType();		
		getAllocStatus();		
		getAllocRejCode();		
		getRefAllocID();		
		getAllocIntermedReqType();		
		getAllocLinkID();		
		getAllocLinkType();		
		getBookingRefID();		
		getClearingBusinessDate();		
		getTrdType();		
		getTrdSubType();		
		getMultiLegReportingType();		
		getCustOrderCapacity();		
		getTradeInputSource();		
		getRndPx();		
		getMessageEventSource();		
		getTradeInputDevice();		
		getAvgPxIndicator();		
		getAllocNoOrdersType();		
		getPreviouslyReported();		
		getReversalIndicator();		
		getMatchType();		
		getSide();		
		getQuantity();		
		getQtyType();		
		getLastMkt();		
		getTradeOriginationDate();		
		getTradingSessionID();		
		getTradingSessionSubID();		
		getPriceType();		
		getAvgPx();		
		getAvgParPx();		
		getCurrency();		
		getAvgPxPrecision();		
		getTradeDate();		
		getTransactTime();		
		getSettlType();		
		getSettlDate();		
		getBookingType();		
		getGrossTradeAmt();		
		getConcession();		
		getTotalTakedown();		
		getNetMoney();		
		getPositionEffect();		
		getAutoAcceptIndicator();		
		getText();		
		getEncodedTextLen();		
		getEncodedText();		
		getNumDaysInterest();		
		getAccruedInterestRate();		
		getAccruedInterestAmt();		
		getTotalAccruedInterestAmt();		
		getInterestAtMaturity();		
		getEndAccruedInterestAmt();		
		getStartCash();		
		getEndCash();		
		getLegalConfirm();		
		getTotNoAllocs();		
		getLastFragment();		
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
		if (hasAllocReportID()) {		
			out.put(FixTags.ALLOCREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocReportID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocID()) {		
			out.put(FixTags.ALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocTransType()) {		
			out.put(FixTags.ALLOCTRANSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocTransType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocReportRefID()) {		
			out.put(FixTags.ALLOCREPORTREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocReportRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocCancReplaceReason()) {		
			out.put(FixTags.ALLOCCANCREPLACEREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocCancReplaceReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryAllocID()) {		
			out.put(FixTags.SECONDARYALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryAllocID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocReportType()) {		
			out.put(FixTags.ALLOCREPORTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocReportType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocStatus()) {		
			out.put(FixTags.ALLOCSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocStatus);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocRejCode()) {		
			out.put(FixTags.ALLOCREJCODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocRejCode);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRefAllocID()) {		
			out.put(FixTags.REFALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,refAllocID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocIntermedReqType()) {		
			out.put(FixTags.ALLOCINTERMEDREQTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocIntermedReqType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocLinkID()) {		
			out.put(FixTags.ALLOCLINKID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocLinkID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocLinkType()) {		
			out.put(FixTags.ALLOCLINKTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocLinkType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBookingRefID()) {		
			out.put(FixTags.BOOKINGREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,bookingRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
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
		if (hasMultiLegReportingType()) {		
			out.put(FixTags.MULTILEGREPORTINGTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,multiLegReportingType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCustOrderCapacity()) {		
			out.put(FixTags.CUSTORDERCAPACITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)custOrderCapacity);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeInputSource()) {		
			out.put(FixTags.TRADEINPUTSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeInputSource); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRndPx()) {		
			out.put(FixTags.RNDPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)rndPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMessageEventSource()) {		
			out.put(FixTags.MESSAGEEVENTSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,messageEventSource); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeInputDevice()) {		
			out.put(FixTags.TRADEINPUTDEVICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeInputDevice); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAvgPxIndicator()) {		
			out.put(FixTags.AVGPXINDICATOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)avgPxIndicator);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocNoOrdersType()) {		
			out.put(FixTags.ALLOCNOORDERSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocNoOrdersType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPreviouslyReported()) {		
			out.put(FixTags.PREVIOUSLYREPORTED);		
		
			out.put((byte) '=');		
		
			out.put(previouslyReported?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasReversalIndicator()) {		
			out.put(FixTags.REVERSALINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(reversalIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMatchType()) {		
			out.put(FixTags.MATCHTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,matchType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSide()) {		
			out.put(FixTags.SIDE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuantity()) {		
			out.put(FixTags.QUANTITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)quantity);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQtyType()) {		
			out.put(FixTags.QTYTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)qtyType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastMkt()) {		
			out.put(FixTags.LASTMKT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,lastMkt); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeOriginationDate()) {		
			out.put(FixTags.TRADEORIGINATIONDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeOriginationDate); 		
		
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
		if (hasPriceType()) {		
			out.put(FixTags.PRICETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priceType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAvgPx()) {		
			out.put(FixTags.AVGPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)avgPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAvgParPx()) {		
			out.put(FixTags.AVGPARPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)avgParPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAvgPxPrecision()) {		
			out.put(FixTags.AVGPXPRECISION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)avgPxPrecision);
		
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
		if (hasBookingType()) {		
			out.put(FixTags.BOOKINGTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)bookingType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasGrossTradeAmt()) {		
			out.put(FixTags.GROSSTRADEAMT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)grossTradeAmt);
		
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
		if (hasPositionEffect()) {		
			out.put(FixTags.POSITIONEFFECT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,positionEffect); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAutoAcceptIndicator()) {		
			out.put(FixTags.AUTOACCEPTINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(autoAcceptIndicator?(byte)'Y':(byte)'N' );
		
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
		if (hasNumDaysInterest()) {		
			out.put(FixTags.NUMDAYSINTEREST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)numDaysInterest);
		
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
		if (hasTotalAccruedInterestAmt()) {		
			out.put(FixTags.TOTALACCRUEDINTERESTAMT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totalAccruedInterestAmt);
		
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
		if (hasLegalConfirm()) {		
			out.put(FixTags.LEGALCONFIRM);		
		
			out.put((byte) '=');		
		
			out.put(legalConfirm?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotNoAllocs()) {		
			out.put(FixTags.TOTNOALLOCS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totNoAllocs);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastFragment()) {		
			out.put(FixTags.LASTFRAGMENT);		
		
			out.put((byte) '=');		
		
			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(ordAllocGrp)>0) {
			out.put(FixTags.NOORDERS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(ordAllocGrp));

			out.put(FixUtils.SOH);

		}
		for (FixOrdAllocGrp fixOrdAllocGrp : ordAllocGrp) if (fixOrdAllocGrp.hasGroup()) fixOrdAllocGrp.encode(out);
		if (FixUtils.getNoInGroup(execAllocGrp)>0) {
			out.put(FixTags.NOEXECS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(execAllocGrp));

			out.put(FixUtils.SOH);

		}
		for (FixExecAllocGrp fixExecAllocGrp : execAllocGrp) if (fixExecAllocGrp.hasGroup()) fixExecAllocGrp.encode(out);
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
		spreadOrBenchmarkCurveData.encode(out);
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(stipulations)>0) {
			out.put(FixTags.NOSTIPULATIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(stipulations));

			out.put(FixUtils.SOH);

		}
		for (FixStipulations fixStipulations : stipulations) if (fixStipulations.hasGroup()) fixStipulations.encode(out);
		yieldData.encode(out);
		if (FixUtils.getNoInGroup(positionAmountData)>0) {
			out.put(FixTags.NOPOSAMT);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(positionAmountData));

			out.put(FixUtils.SOH);

		}
		for (FixPositionAmountData fixPositionAmountData : positionAmountData) if (fixPositionAmountData.hasGroup()) fixPositionAmountData.encode(out);
		if (FixUtils.getNoInGroup(allocGrp)>0) {
			out.put(FixTags.NOALLOCS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(allocGrp));

			out.put(FixUtils.SOH);

		}
		for (FixAllocGrp fixAllocGrp : allocGrp) if (fixAllocGrp.hasGroup()) fixAllocGrp.encode(out);
		if (FixUtils.getNoInGroup(rateSource)>0) {
			out.put(FixTags.NORATESOURCES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(rateSource));

			out.put(FixUtils.SOH);

		}
		for (FixRateSource fixRateSource : rateSource) if (fixRateSource.hasGroup()) fixRateSource.encode(out);
		
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
		
		if (hasAllocReportID()) {		
			FixUtils.put(out,allocReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocID()) {		
			FixUtils.put(out,allocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocTransType()) {		
			FixUtils.put(out,allocTransType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocReportRefID()) {		
			FixUtils.put(out,allocReportRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocCancReplaceReason()) {		
			FixUtils.put(out, (long)allocCancReplaceReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryAllocID()) {		
			FixUtils.put(out,secondaryAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocReportType()) {		
			FixUtils.put(out, (long)allocReportType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocStatus()) {		
			FixUtils.put(out, (long)allocStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocRejCode()) {		
			FixUtils.put(out, (long)allocRejCode);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefAllocID()) {		
			FixUtils.put(out,refAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocIntermedReqType()) {		
			FixUtils.put(out, (long)allocIntermedReqType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocLinkID()) {		
			FixUtils.put(out,allocLinkID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocLinkType()) {		
			FixUtils.put(out, (long)allocLinkType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBookingRefID()) {		
			FixUtils.put(out,bookingRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
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
		
		if (hasMultiLegReportingType()) {		
			FixUtils.put(out,multiLegReportingType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCustOrderCapacity()) {		
			FixUtils.put(out, (long)custOrderCapacity);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeInputSource()) {		
			FixUtils.put(out,tradeInputSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRndPx()) {		
			FixUtils.put(out, (long)rndPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMessageEventSource()) {		
			FixUtils.put(out,messageEventSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeInputDevice()) {		
			FixUtils.put(out,tradeInputDevice); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAvgPxIndicator()) {		
			FixUtils.put(out, (long)avgPxIndicator);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocNoOrdersType()) {		
			FixUtils.put(out, (long)allocNoOrdersType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPreviouslyReported()) {		
			out.put(previouslyReported?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasReversalIndicator()) {		
			out.put(reversalIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMatchType()) {		
			FixUtils.put(out,matchType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuantity()) {		
			FixUtils.put(out, (long)quantity);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQtyType()) {		
			FixUtils.put(out, (long)qtyType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastMkt()) {		
			FixUtils.put(out,lastMkt); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeOriginationDate()) {		
			FixUtils.put(out,tradeOriginationDate); 		
		
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
		
		if (hasPriceType()) {		
			FixUtils.put(out, (long)priceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAvgPx()) {		
			FixUtils.put(out, (long)avgPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAvgParPx()) {		
			FixUtils.put(out, (long)avgParPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAvgPxPrecision()) {		
			FixUtils.put(out, (long)avgPxPrecision);
		
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
		
		if (hasSettlType()) {		
			FixUtils.put(out,settlType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlDate()) {		
			FixUtils.put(out,settlDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBookingType()) {		
			FixUtils.put(out, (long)bookingType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasGrossTradeAmt()) {		
			FixUtils.put(out, (long)grossTradeAmt);
		
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
		
		if (hasPositionEffect()) {		
			FixUtils.put(out,positionEffect); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAutoAcceptIndicator()) {		
			out.put(autoAcceptIndicator?(byte)'Y':(byte)'N' );
		
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
		
		if (hasNumDaysInterest()) {		
			FixUtils.put(out, (long)numDaysInterest);
		
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
		
		if (hasTotalAccruedInterestAmt()) {		
			FixUtils.put(out, (long)totalAccruedInterestAmt);
		
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
		
		if (hasLegalConfirm()) {		
			out.put(legalConfirm?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNoAllocs()) {		
			FixUtils.put(out, (long)totNoAllocs);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastFragment()) {		
			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
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
			
	public void crackAllocReportID() {		
		getAllocReportID();		
	}		
			
	public byte[] getAllocReportID() { 		
		if ( hasAllocReportID()) {		
			if (hasAllocReportID == FixUtils.TAG_HAS_VALUE) {		
				return allocReportID; 		
			} else {

				buf.position(hasAllocReportID);

			FixMessage.getTagStringValue(buf, allocReportID, 0, allocReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAllocReportID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocReportID() { return hasAllocReportID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocReportID(byte[] src) {		
		if (src == null ) return;
		if (hasAllocReportID()) FixUtils.fillNul(allocReportID);		
		FixUtils.copy(allocReportID, src); 		
		hasAllocReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocReportID(String str) {		
		if (str == null ) return;
		if (hasAllocReportID()) FixUtils.fillNul(allocReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocReportID, src); 		
		hasAllocReportID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackAllocTransType() {		
		getAllocTransType();		
	}		
			
	public byte getAllocTransType() { 		
		if ( hasAllocTransType()) {		
			if (hasAllocTransType == FixUtils.TAG_HAS_VALUE) {		
				return allocTransType; 		
			} else {

				buf.position(hasAllocTransType);

			allocTransType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (allocTransType != (byte)'3') && (allocTransType != (byte)'2') && (allocTransType != (byte)'1') && (allocTransType != (byte)'0') && (allocTransType != (byte)'6') && (allocTransType != (byte)'5') && (allocTransType != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 71);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasAllocTransType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocTransType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasAllocTransType() { return hasAllocTransType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocTransType(byte[] src) {		
		if (src == null ) return;
		if (hasAllocTransType()) allocTransType = (byte)' ';		
		allocTransType = src[0];		
		hasAllocTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocTransType(byte src) {		
		allocTransType = src;
		hasAllocTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocTransType(String str) {		
		if (str == null ) return;
		if (hasAllocTransType()) allocTransType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		allocTransType = src[0];		
		hasAllocTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocReportRefID() {		
		getAllocReportRefID();		
	}		
			
	public byte[] getAllocReportRefID() { 		
		if ( hasAllocReportRefID()) {		
			if (hasAllocReportRefID == FixUtils.TAG_HAS_VALUE) {		
				return allocReportRefID; 		
			} else {

				buf.position(hasAllocReportRefID);

			FixMessage.getTagStringValue(buf, allocReportRefID, 0, allocReportRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAllocReportRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocReportRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocReportRefID() { return hasAllocReportRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocReportRefID(byte[] src) {		
		if (src == null ) return;
		if (hasAllocReportRefID()) FixUtils.fillNul(allocReportRefID);		
		FixUtils.copy(allocReportRefID, src); 		
		hasAllocReportRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocReportRefID(String str) {		
		if (str == null ) return;
		if (hasAllocReportRefID()) FixUtils.fillNul(allocReportRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocReportRefID, src); 		
		hasAllocReportRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocCancReplaceReason() {		
		getAllocCancReplaceReason();		
	}		
			
	public long getAllocCancReplaceReason() { 		
		if ( hasAllocCancReplaceReason()) {		
			if (hasAllocCancReplaceReason == FixUtils.TAG_HAS_VALUE) {		
				return allocCancReplaceReason; 		
			} else {

				buf.position(hasAllocCancReplaceReason);

			allocCancReplaceReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocCancReplaceReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocCancReplaceReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocCancReplaceReason() { return hasAllocCancReplaceReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocCancReplaceReason(byte[] src) {		
		if (src == null ) return;
		if (hasAllocCancReplaceReason()) allocCancReplaceReason = FixUtils.TAG_HAS_NO_VALUE;		
		allocCancReplaceReason = FixUtils.longValueOf(src, 0, src.length);
		hasAllocCancReplaceReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocCancReplaceReason(long src) {		
		allocCancReplaceReason = src;
		hasAllocCancReplaceReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocCancReplaceReason(String str) {		
		if (str == null ) return;
		if (hasAllocCancReplaceReason()) allocCancReplaceReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocCancReplaceReason = FixUtils.longValueOf(src, 0, src.length);
		hasAllocCancReplaceReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryAllocID() {		
		getSecondaryAllocID();		
	}		
			
	public byte[] getSecondaryAllocID() { 		
		if ( hasSecondaryAllocID()) {		
			if (hasSecondaryAllocID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryAllocID; 		
			} else {

				buf.position(hasSecondaryAllocID);

			FixMessage.getTagStringValue(buf, secondaryAllocID, 0, secondaryAllocID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryAllocID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryAllocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryAllocID() { return hasSecondaryAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryAllocID()) FixUtils.fillNul(secondaryAllocID);		
		FixUtils.copy(secondaryAllocID, src); 		
		hasSecondaryAllocID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryAllocID(String str) {		
		if (str == null ) return;
		if (hasSecondaryAllocID()) FixUtils.fillNul(secondaryAllocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryAllocID, src); 		
		hasSecondaryAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocReportType() {		
		getAllocReportType();		
	}		
			
	public long getAllocReportType() { 		
		if ( hasAllocReportType()) {		
			if (hasAllocReportType == FixUtils.TAG_HAS_VALUE) {		
				return allocReportType; 		
			} else {

				buf.position(hasAllocReportType);

			allocReportType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocReportType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocReportType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocReportType() { return hasAllocReportType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocReportType(byte[] src) {		
		if (src == null ) return;
		if (hasAllocReportType()) allocReportType = FixUtils.TAG_HAS_NO_VALUE;		
		allocReportType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocReportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocReportType(long src) {		
		allocReportType = src;
		hasAllocReportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocReportType(String str) {		
		if (str == null ) return;
		if (hasAllocReportType()) allocReportType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocReportType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocReportType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocStatus() {		
		getAllocStatus();		
	}		
			
	public long getAllocStatus() { 		
		if ( hasAllocStatus()) {		
			if (hasAllocStatus == FixUtils.TAG_HAS_VALUE) {		
				return allocStatus; 		
			} else {

				buf.position(hasAllocStatus);

			allocStatus = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocStatus() { return hasAllocStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocStatus(byte[] src) {		
		if (src == null ) return;
		if (hasAllocStatus()) allocStatus = FixUtils.TAG_HAS_NO_VALUE;		
		allocStatus = FixUtils.longValueOf(src, 0, src.length);
		hasAllocStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocStatus(long src) {		
		allocStatus = src;
		hasAllocStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocStatus(String str) {		
		if (str == null ) return;
		if (hasAllocStatus()) allocStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocStatus = FixUtils.longValueOf(src, 0, src.length);
		hasAllocStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocRejCode() {		
		getAllocRejCode();		
	}		
			
	public long getAllocRejCode() { 		
		if ( hasAllocRejCode()) {		
			if (hasAllocRejCode == FixUtils.TAG_HAS_VALUE) {		
				return allocRejCode; 		
			} else {

				buf.position(hasAllocRejCode);

			allocRejCode = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocRejCode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocRejCode;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocRejCode() { return hasAllocRejCode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocRejCode(byte[] src) {		
		if (src == null ) return;
		if (hasAllocRejCode()) allocRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		allocRejCode = FixUtils.longValueOf(src, 0, src.length);
		hasAllocRejCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocRejCode(long src) {		
		allocRejCode = src;
		hasAllocRejCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocRejCode(String str) {		
		if (str == null ) return;
		if (hasAllocRejCode()) allocRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocRejCode = FixUtils.longValueOf(src, 0, src.length);
		hasAllocRejCode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRefAllocID() {		
		getRefAllocID();		
	}		
			
	public byte[] getRefAllocID() { 		
		if ( hasRefAllocID()) {		
			if (hasRefAllocID == FixUtils.TAG_HAS_VALUE) {		
				return refAllocID; 		
			} else {

				buf.position(hasRefAllocID);

			FixMessage.getTagStringValue(buf, refAllocID, 0, refAllocID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRefAllocID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return refAllocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefAllocID() { return hasRefAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRefAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasRefAllocID()) FixUtils.fillNul(refAllocID);		
		FixUtils.copy(refAllocID, src); 		
		hasRefAllocID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefAllocID(String str) {		
		if (str == null ) return;
		if (hasRefAllocID()) FixUtils.fillNul(refAllocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refAllocID, src); 		
		hasRefAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocIntermedReqType() {		
		getAllocIntermedReqType();		
	}		
			
	public long getAllocIntermedReqType() { 		
		if ( hasAllocIntermedReqType()) {		
			if (hasAllocIntermedReqType == FixUtils.TAG_HAS_VALUE) {		
				return allocIntermedReqType; 		
			} else {

				buf.position(hasAllocIntermedReqType);

			allocIntermedReqType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocIntermedReqType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocIntermedReqType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocIntermedReqType() { return hasAllocIntermedReqType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocIntermedReqType(byte[] src) {		
		if (src == null ) return;
		if (hasAllocIntermedReqType()) allocIntermedReqType = FixUtils.TAG_HAS_NO_VALUE;		
		allocIntermedReqType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocIntermedReqType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocIntermedReqType(long src) {		
		allocIntermedReqType = src;
		hasAllocIntermedReqType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocIntermedReqType(String str) {		
		if (str == null ) return;
		if (hasAllocIntermedReqType()) allocIntermedReqType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocIntermedReqType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocIntermedReqType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocLinkID() {		
		getAllocLinkID();		
	}		
			
	public byte[] getAllocLinkID() { 		
		if ( hasAllocLinkID()) {		
			if (hasAllocLinkID == FixUtils.TAG_HAS_VALUE) {		
				return allocLinkID; 		
			} else {

				buf.position(hasAllocLinkID);

			FixMessage.getTagStringValue(buf, allocLinkID, 0, allocLinkID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAllocLinkID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocLinkID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocLinkID() { return hasAllocLinkID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocLinkID(byte[] src) {		
		if (src == null ) return;
		if (hasAllocLinkID()) FixUtils.fillNul(allocLinkID);		
		FixUtils.copy(allocLinkID, src); 		
		hasAllocLinkID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocLinkID(String str) {		
		if (str == null ) return;
		if (hasAllocLinkID()) FixUtils.fillNul(allocLinkID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocLinkID, src); 		
		hasAllocLinkID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocLinkType() {		
		getAllocLinkType();		
	}		
			
	public long getAllocLinkType() { 		
		if ( hasAllocLinkType()) {		
			if (hasAllocLinkType == FixUtils.TAG_HAS_VALUE) {		
				return allocLinkType; 		
			} else {

				buf.position(hasAllocLinkType);

			allocLinkType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocLinkType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocLinkType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocLinkType() { return hasAllocLinkType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocLinkType(byte[] src) {		
		if (src == null ) return;
		if (hasAllocLinkType()) allocLinkType = FixUtils.TAG_HAS_NO_VALUE;		
		allocLinkType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocLinkType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocLinkType(long src) {		
		allocLinkType = src;
		hasAllocLinkType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocLinkType(String str) {		
		if (str == null ) return;
		if (hasAllocLinkType()) allocLinkType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocLinkType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocLinkType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBookingRefID() {		
		getBookingRefID();		
	}		
			
	public byte[] getBookingRefID() { 		
		if ( hasBookingRefID()) {		
			if (hasBookingRefID == FixUtils.TAG_HAS_VALUE) {		
				return bookingRefID; 		
			} else {

				buf.position(hasBookingRefID);

			FixMessage.getTagStringValue(buf, bookingRefID, 0, bookingRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasBookingRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bookingRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBookingRefID() { return hasBookingRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBookingRefID(byte[] src) {		
		if (src == null ) return;
		if (hasBookingRefID()) FixUtils.fillNul(bookingRefID);		
		FixUtils.copy(bookingRefID, src); 		
		hasBookingRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBookingRefID(String str) {		
		if (str == null ) return;
		if (hasBookingRefID()) FixUtils.fillNul(bookingRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(bookingRefID, src); 		
		hasBookingRefID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackTradeInputSource() {		
		getTradeInputSource();		
	}		
			
	public byte[] getTradeInputSource() { 		
		if ( hasTradeInputSource()) {		
			if (hasTradeInputSource == FixUtils.TAG_HAS_VALUE) {		
				return tradeInputSource; 		
			} else {

				buf.position(hasTradeInputSource);

			FixMessage.getTagStringValue(buf, tradeInputSource, 0, tradeInputSource.length, err);
		
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
			
	public void crackTradeInputDevice() {		
		getTradeInputDevice();		
	}		
			
	public byte[] getTradeInputDevice() { 		
		if ( hasTradeInputDevice()) {		
			if (hasTradeInputDevice == FixUtils.TAG_HAS_VALUE) {		
				return tradeInputDevice; 		
			} else {

				buf.position(hasTradeInputDevice);

			FixMessage.getTagStringValue(buf, tradeInputDevice, 0, tradeInputDevice.length, err);
		
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
			
	public void crackAllocNoOrdersType() {		
		getAllocNoOrdersType();		
	}		
			
	public long getAllocNoOrdersType() { 		
		if ( hasAllocNoOrdersType()) {		
			if (hasAllocNoOrdersType == FixUtils.TAG_HAS_VALUE) {		
				return allocNoOrdersType; 		
			} else {

				buf.position(hasAllocNoOrdersType);

			allocNoOrdersType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocNoOrdersType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocNoOrdersType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocNoOrdersType() { return hasAllocNoOrdersType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocNoOrdersType(byte[] src) {		
		if (src == null ) return;
		if (hasAllocNoOrdersType()) allocNoOrdersType = FixUtils.TAG_HAS_NO_VALUE;		
		allocNoOrdersType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocNoOrdersType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocNoOrdersType(long src) {		
		allocNoOrdersType = src;
		hasAllocNoOrdersType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocNoOrdersType(String str) {		
		if (str == null ) return;
		if (hasAllocNoOrdersType()) allocNoOrdersType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocNoOrdersType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocNoOrdersType = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackReversalIndicator() {		
		getReversalIndicator();		
	}		
			
	public boolean getReversalIndicator() { 		
		if ( hasReversalIndicator()) {		
			if (hasReversalIndicator == FixUtils.TAG_HAS_VALUE) {		
				return reversalIndicator; 		
			} else {

				buf.position(hasReversalIndicator);

			reversalIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasReversalIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return reversalIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasReversalIndicator() { return hasReversalIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setReversalIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasReversalIndicator()) reversalIndicator = false;		
		reversalIndicator = src[0]==(byte)'Y'?true:false;		
		hasReversalIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setReversalIndicator(boolean src) {		
		reversalIndicator = src;
		hasReversalIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setReversalIndicator(String str) {		
		if (str == null ) return;
		if (hasReversalIndicator()) reversalIndicator = false;		
		byte[] src = str.getBytes(); 		
		reversalIndicator = src[0]==(byte)'Y'?true:false;		
		hasReversalIndicator = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackQuantity() {		
		getQuantity();		
	}		
			
	public long getQuantity() { 		
		if ( hasQuantity()) {		
			if (hasQuantity == FixUtils.TAG_HAS_VALUE) {		
				return quantity; 		
			} else {

				buf.position(hasQuantity);

			quantity = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQuantity = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quantity;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuantity() { return hasQuantity != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuantity(byte[] src) {		
		if (src == null ) return;
		if (hasQuantity()) quantity = FixUtils.TAG_HAS_NO_VALUE;		
		quantity = FixUtils.longValueOf(src, 0, src.length);
		hasQuantity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuantity(long src) {		
		quantity = src;
		hasQuantity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuantity(String str) {		
		if (str == null ) return;
		if (hasQuantity()) quantity = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quantity = FixUtils.longValueOf(src, 0, src.length);
		hasQuantity = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackAvgParPx() {		
		getAvgParPx();		
	}		
			
	public long getAvgParPx() { 		
		if ( hasAvgParPx()) {		
			if (hasAvgParPx == FixUtils.TAG_HAS_VALUE) {		
				return avgParPx; 		
			} else {

				buf.position(hasAvgParPx);

			avgParPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAvgParPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return avgParPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAvgParPx() { return hasAvgParPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAvgParPx(byte[] src) {		
		if (src == null ) return;
		if (hasAvgParPx()) avgParPx = FixUtils.TAG_HAS_NO_VALUE;		
		avgParPx = FixUtils.longValueOf(src, 0, src.length);
		hasAvgParPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgParPx(long src) {		
		avgParPx = src;
		hasAvgParPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgParPx(String str) {		
		if (str == null ) return;
		if (hasAvgParPx()) avgParPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		avgParPx = FixUtils.longValueOf(src, 0, src.length);
		hasAvgParPx = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackAvgPxPrecision() {		
		getAvgPxPrecision();		
	}		
			
	public long getAvgPxPrecision() { 		
		if ( hasAvgPxPrecision()) {		
			if (hasAvgPxPrecision == FixUtils.TAG_HAS_VALUE) {		
				return avgPxPrecision; 		
			} else {

				buf.position(hasAvgPxPrecision);

			avgPxPrecision = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAvgPxPrecision = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return avgPxPrecision;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAvgPxPrecision() { return hasAvgPxPrecision != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAvgPxPrecision(byte[] src) {		
		if (src == null ) return;
		if (hasAvgPxPrecision()) avgPxPrecision = FixUtils.TAG_HAS_NO_VALUE;		
		avgPxPrecision = FixUtils.longValueOf(src, 0, src.length);
		hasAvgPxPrecision = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgPxPrecision(long src) {		
		avgPxPrecision = src;
		hasAvgPxPrecision = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgPxPrecision(String str) {		
		if (str == null ) return;
		if (hasAvgPxPrecision()) avgPxPrecision = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		avgPxPrecision = FixUtils.longValueOf(src, 0, src.length);
		hasAvgPxPrecision = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackAutoAcceptIndicator() {		
		getAutoAcceptIndicator();		
	}		
			
	public boolean getAutoAcceptIndicator() { 		
		if ( hasAutoAcceptIndicator()) {		
			if (hasAutoAcceptIndicator == FixUtils.TAG_HAS_VALUE) {		
				return autoAcceptIndicator; 		
			} else {

				buf.position(hasAutoAcceptIndicator);

			autoAcceptIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasAutoAcceptIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return autoAcceptIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasAutoAcceptIndicator() { return hasAutoAcceptIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAutoAcceptIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasAutoAcceptIndicator()) autoAcceptIndicator = false;		
		autoAcceptIndicator = src[0]==(byte)'Y'?true:false;		
		hasAutoAcceptIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAutoAcceptIndicator(boolean src) {		
		autoAcceptIndicator = src;
		hasAutoAcceptIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAutoAcceptIndicator(String str) {		
		if (str == null ) return;
		if (hasAutoAcceptIndicator()) autoAcceptIndicator = false;		
		byte[] src = str.getBytes(); 		
		autoAcceptIndicator = src[0]==(byte)'Y'?true:false;		
		hasAutoAcceptIndicator = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackTotalAccruedInterestAmt() {		
		getTotalAccruedInterestAmt();		
	}		
			
	public long getTotalAccruedInterestAmt() { 		
		if ( hasTotalAccruedInterestAmt()) {		
			if (hasTotalAccruedInterestAmt == FixUtils.TAG_HAS_VALUE) {		
				return totalAccruedInterestAmt; 		
			} else {

				buf.position(hasTotalAccruedInterestAmt);

			totalAccruedInterestAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotalAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totalAccruedInterestAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotalAccruedInterestAmt() { return hasTotalAccruedInterestAmt != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotalAccruedInterestAmt(byte[] src) {		
		if (src == null ) return;
		if (hasTotalAccruedInterestAmt()) totalAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		totalAccruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasTotalAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotalAccruedInterestAmt(long src) {		
		totalAccruedInterestAmt = src;
		hasTotalAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotalAccruedInterestAmt(String str) {		
		if (str == null ) return;
		if (hasTotalAccruedInterestAmt()) totalAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totalAccruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasTotalAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackLegalConfirm() {		
		getLegalConfirm();		
	}		
			
	public boolean getLegalConfirm() { 		
		if ( hasLegalConfirm()) {		
			if (hasLegalConfirm == FixUtils.TAG_HAS_VALUE) {		
				return legalConfirm; 		
			} else {

				buf.position(hasLegalConfirm);

			legalConfirm = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasLegalConfirm = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return legalConfirm;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasLegalConfirm() { return hasLegalConfirm != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLegalConfirm(byte[] src) {		
		if (src == null ) return;
		if (hasLegalConfirm()) legalConfirm = false;		
		legalConfirm = src[0]==(byte)'Y'?true:false;		
		hasLegalConfirm = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegalConfirm(boolean src) {		
		legalConfirm = src;
		hasLegalConfirm = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegalConfirm(String str) {		
		if (str == null ) return;
		if (hasLegalConfirm()) legalConfirm = false;		
		byte[] src = str.getBytes(); 		
		legalConfirm = src[0]==(byte)'Y'?true:false;		
		hasLegalConfirm = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTotNoAllocs() {		
		getTotNoAllocs();		
	}		
			
	public long getTotNoAllocs() { 		
		if ( hasTotNoAllocs()) {		
			if (hasTotNoAllocs == FixUtils.TAG_HAS_VALUE) {		
				return totNoAllocs; 		
			} else {

				buf.position(hasTotNoAllocs);

			totNoAllocs = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotNoAllocs = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totNoAllocs;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNoAllocs() { return hasTotNoAllocs != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotNoAllocs(byte[] src) {		
		if (src == null ) return;
		if (hasTotNoAllocs()) totNoAllocs = FixUtils.TAG_HAS_NO_VALUE;		
		totNoAllocs = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoAllocs = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoAllocs(long src) {		
		totNoAllocs = src;
		hasTotNoAllocs = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoAllocs(String str) {		
		if (str == null ) return;
		if (hasTotNoAllocs()) totNoAllocs = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNoAllocs = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoAllocs = FixUtils.TAG_HAS_VALUE;		
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

					if (hasAllocReportID()) s += "AllocReportID(755)= " + new String( FixUtils.trim(getAllocReportID()) ) + "\n" ; 
		if (hasAllocID()) s += "AllocID(70)= " + new String( FixUtils.trim(getAllocID()) ) + "\n" ; 
		if (hasAllocTransType()) s += "AllocTransType(71)= " + getAllocTransType() + "\n" ; 
		if (hasAllocReportRefID()) s += "AllocReportRefID(795)= " + new String( FixUtils.trim(getAllocReportRefID()) ) + "\n" ; 
		if (hasAllocCancReplaceReason()) s += "AllocCancReplaceReason(796)= " + getAllocCancReplaceReason() + "\n" ; 
		if (hasSecondaryAllocID()) s += "SecondaryAllocID(793)= " + new String( FixUtils.trim(getSecondaryAllocID()) ) + "\n" ; 
		if (hasAllocReportType()) s += "AllocReportType(794)= " + getAllocReportType() + "\n" ; 
		if (hasAllocStatus()) s += "AllocStatus(87)= " + getAllocStatus() + "\n" ; 
		if (hasAllocRejCode()) s += "AllocRejCode(88)= " + getAllocRejCode() + "\n" ; 
		if (hasRefAllocID()) s += "RefAllocID(72)= " + new String( FixUtils.trim(getRefAllocID()) ) + "\n" ; 
		if (hasAllocIntermedReqType()) s += "AllocIntermedReqType(808)= " + getAllocIntermedReqType() + "\n" ; 
		if (hasAllocLinkID()) s += "AllocLinkID(196)= " + new String( FixUtils.trim(getAllocLinkID()) ) + "\n" ; 
		if (hasAllocLinkType()) s += "AllocLinkType(197)= " + getAllocLinkType() + "\n" ; 
		if (hasBookingRefID()) s += "BookingRefID(466)= " + new String( FixUtils.trim(getBookingRefID()) ) + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasTrdType()) s += "TrdType(828)= " + getTrdType() + "\n" ; 
		if (hasTrdSubType()) s += "TrdSubType(829)= " + getTrdSubType() + "\n" ; 
		if (hasMultiLegReportingType()) s += "MultiLegReportingType(442)= " + getMultiLegReportingType() + "\n" ; 
		if (hasCustOrderCapacity()) s += "CustOrderCapacity(582)= " + getCustOrderCapacity() + "\n" ; 
		if (hasTradeInputSource()) s += "TradeInputSource(578)= " + new String( FixUtils.trim(getTradeInputSource()) ) + "\n" ; 
		if (hasRndPx()) s += "RndPx(991)= " + getRndPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMessageEventSource()) s += "MessageEventSource(1011)= " + new String( FixUtils.trim(getMessageEventSource()) ) + "\n" ; 
		if (hasTradeInputDevice()) s += "TradeInputDevice(579)= " + new String( FixUtils.trim(getTradeInputDevice()) ) + "\n" ; 
		if (hasAvgPxIndicator()) s += "AvgPxIndicator(819)= " + getAvgPxIndicator() + "\n" ; 
		if (hasAllocNoOrdersType()) s += "AllocNoOrdersType(857)= " + getAllocNoOrdersType() + "\n" ; 
		if (hasPreviouslyReported()) s += "PreviouslyReported(570)= " + getPreviouslyReported() + "\n" ; 
		if (hasReversalIndicator()) s += "ReversalIndicator(700)= " + getReversalIndicator() + "\n" ; 
		if (hasMatchType()) s += "MatchType(574)= " + new String( FixUtils.trim(getMatchType()) ) + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasQuantity()) s += "Quantity(53)= " + getQuantity() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasQtyType()) s += "QtyType(854)= " + getQtyType() + "\n" ; 
		if (hasLastMkt()) s += "LastMkt(30)= " + new String( FixUtils.trim(getLastMkt()) ) + "\n" ; 
		if (hasTradeOriginationDate()) s += "TradeOriginationDate(229)= " + new String( FixUtils.trim(getTradeOriginationDate()) ) + "\n" ; 
		if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 
		if (hasPriceType()) s += "PriceType(423)= " + getPriceType() + "\n" ; 
		if (hasAvgPx()) s += "AvgPx(6)= " + getAvgPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAvgParPx()) s += "AvgParPx(860)= " + getAvgParPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasAvgPxPrecision()) s += "AvgPxPrecision(74)= " + getAvgPxPrecision() + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasSettlType()) s += "SettlType(63)= " + new String( FixUtils.trim(getSettlType()) ) + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasBookingType()) s += "BookingType(775)= " + getBookingType() + "\n" ; 
		if (hasGrossTradeAmt()) s += "GrossTradeAmt(381)= " + getGrossTradeAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasConcession()) s += "Concession(238)= " + getConcession() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTotalTakedown()) s += "TotalTakedown(237)= " + getTotalTakedown() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasNetMoney()) s += "NetMoney(118)= " + getNetMoney() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPositionEffect()) s += "PositionEffect(77)= " + getPositionEffect() + "\n" ; 
		if (hasAutoAcceptIndicator()) s += "AutoAcceptIndicator(754)= " + getAutoAcceptIndicator() + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasNumDaysInterest()) s += "NumDaysInterest(157)= " + getNumDaysInterest() + "\n" ; 
		if (hasAccruedInterestRate()) s += "AccruedInterestRate(158)= " + getAccruedInterestRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAccruedInterestAmt()) s += "AccruedInterestAmt(159)= " + getAccruedInterestAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTotalAccruedInterestAmt()) s += "TotalAccruedInterestAmt(540)= " + getTotalAccruedInterestAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasInterestAtMaturity()) s += "InterestAtMaturity(738)= " + getInterestAtMaturity() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasEndAccruedInterestAmt()) s += "EndAccruedInterestAmt(920)= " + getEndAccruedInterestAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasStartCash()) s += "StartCash(921)= " + getStartCash() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasEndCash()) s += "EndCash(922)= " + getEndCash() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegalConfirm()) s += "LegalConfirm(650)= " + getLegalConfirm() + "\n" ; 
		if (hasTotNoAllocs()) s += "TotNoAllocs(892)= " + getTotNoAllocs() + "\n" ; 
		if (hasLastFragment()) s += "LastFragment(893)= " + getLastFragment() + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixAllocationReport)) return false;

		FixAllocationReport msg = (FixAllocationReport) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasAllocReportID() && !msg.hasAllocReportID()) || (!hasAllocReportID() && msg.hasAllocReportID())) return false;
		if (!(!hasAllocReportID() && !msg.hasAllocReportID()) && !FixUtils.equals(getAllocReportID(), msg.getAllocReportID())) return false;
		if ((hasAllocID() && !msg.hasAllocID()) || (!hasAllocID() && msg.hasAllocID())) return false;
		if (!(!hasAllocID() && !msg.hasAllocID()) && !FixUtils.equals(getAllocID(), msg.getAllocID())) return false;
		if ((hasAllocTransType() && !msg.hasAllocTransType()) || (!hasAllocTransType() && msg.hasAllocTransType())) return false;
		if (!(!hasAllocTransType() && !msg.hasAllocTransType()) && !(getAllocTransType()==msg.getAllocTransType())) return false;
		if ((hasAllocReportRefID() && !msg.hasAllocReportRefID()) || (!hasAllocReportRefID() && msg.hasAllocReportRefID())) return false;
		if (!(!hasAllocReportRefID() && !msg.hasAllocReportRefID()) && !FixUtils.equals(getAllocReportRefID(), msg.getAllocReportRefID())) return false;
		if ((hasAllocCancReplaceReason() && !msg.hasAllocCancReplaceReason()) || (!hasAllocCancReplaceReason() && msg.hasAllocCancReplaceReason())) return false;
		if (!(!hasAllocCancReplaceReason() && !msg.hasAllocCancReplaceReason()) && !(getAllocCancReplaceReason()==msg.getAllocCancReplaceReason())) return false;
		if ((hasSecondaryAllocID() && !msg.hasSecondaryAllocID()) || (!hasSecondaryAllocID() && msg.hasSecondaryAllocID())) return false;
		if (!(!hasSecondaryAllocID() && !msg.hasSecondaryAllocID()) && !FixUtils.equals(getSecondaryAllocID(), msg.getSecondaryAllocID())) return false;
		if ((hasAllocReportType() && !msg.hasAllocReportType()) || (!hasAllocReportType() && msg.hasAllocReportType())) return false;
		if (!(!hasAllocReportType() && !msg.hasAllocReportType()) && !(getAllocReportType()==msg.getAllocReportType())) return false;
		if ((hasAllocStatus() && !msg.hasAllocStatus()) || (!hasAllocStatus() && msg.hasAllocStatus())) return false;
		if (!(!hasAllocStatus() && !msg.hasAllocStatus()) && !(getAllocStatus()==msg.getAllocStatus())) return false;
		if ((hasAllocRejCode() && !msg.hasAllocRejCode()) || (!hasAllocRejCode() && msg.hasAllocRejCode())) return false;
		if (!(!hasAllocRejCode() && !msg.hasAllocRejCode()) && !(getAllocRejCode()==msg.getAllocRejCode())) return false;
		if ((hasRefAllocID() && !msg.hasRefAllocID()) || (!hasRefAllocID() && msg.hasRefAllocID())) return false;
		if (!(!hasRefAllocID() && !msg.hasRefAllocID()) && !FixUtils.equals(getRefAllocID(), msg.getRefAllocID())) return false;
		if ((hasAllocIntermedReqType() && !msg.hasAllocIntermedReqType()) || (!hasAllocIntermedReqType() && msg.hasAllocIntermedReqType())) return false;
		if (!(!hasAllocIntermedReqType() && !msg.hasAllocIntermedReqType()) && !(getAllocIntermedReqType()==msg.getAllocIntermedReqType())) return false;
		if ((hasAllocLinkID() && !msg.hasAllocLinkID()) || (!hasAllocLinkID() && msg.hasAllocLinkID())) return false;
		if (!(!hasAllocLinkID() && !msg.hasAllocLinkID()) && !FixUtils.equals(getAllocLinkID(), msg.getAllocLinkID())) return false;
		if ((hasAllocLinkType() && !msg.hasAllocLinkType()) || (!hasAllocLinkType() && msg.hasAllocLinkType())) return false;
		if (!(!hasAllocLinkType() && !msg.hasAllocLinkType()) && !(getAllocLinkType()==msg.getAllocLinkType())) return false;
		if ((hasBookingRefID() && !msg.hasBookingRefID()) || (!hasBookingRefID() && msg.hasBookingRefID())) return false;
		if (!(!hasBookingRefID() && !msg.hasBookingRefID()) && !FixUtils.equals(getBookingRefID(), msg.getBookingRefID())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if ((hasTrdType() && !msg.hasTrdType()) || (!hasTrdType() && msg.hasTrdType())) return false;
		if (!(!hasTrdType() && !msg.hasTrdType()) && !(getTrdType()==msg.getTrdType())) return false;
		if ((hasTrdSubType() && !msg.hasTrdSubType()) || (!hasTrdSubType() && msg.hasTrdSubType())) return false;
		if (!(!hasTrdSubType() && !msg.hasTrdSubType()) && !(getTrdSubType()==msg.getTrdSubType())) return false;
		if ((hasMultiLegReportingType() && !msg.hasMultiLegReportingType()) || (!hasMultiLegReportingType() && msg.hasMultiLegReportingType())) return false;
		if (!(!hasMultiLegReportingType() && !msg.hasMultiLegReportingType()) && !(getMultiLegReportingType()==msg.getMultiLegReportingType())) return false;
		if ((hasCustOrderCapacity() && !msg.hasCustOrderCapacity()) || (!hasCustOrderCapacity() && msg.hasCustOrderCapacity())) return false;
		if (!(!hasCustOrderCapacity() && !msg.hasCustOrderCapacity()) && !(getCustOrderCapacity()==msg.getCustOrderCapacity())) return false;
		if ((hasTradeInputSource() && !msg.hasTradeInputSource()) || (!hasTradeInputSource() && msg.hasTradeInputSource())) return false;
		if (!(!hasTradeInputSource() && !msg.hasTradeInputSource()) && !FixUtils.equals(getTradeInputSource(), msg.getTradeInputSource())) return false;
		if ((hasRndPx() && !msg.hasRndPx()) || (!hasRndPx() && msg.hasRndPx())) return false;
		if (!(!hasRndPx() && !msg.hasRndPx()) && !(getRndPx()==msg.getRndPx())) return false;
		if ((hasMessageEventSource() && !msg.hasMessageEventSource()) || (!hasMessageEventSource() && msg.hasMessageEventSource())) return false;
		if (!(!hasMessageEventSource() && !msg.hasMessageEventSource()) && !FixUtils.equals(getMessageEventSource(), msg.getMessageEventSource())) return false;
		if ((hasTradeInputDevice() && !msg.hasTradeInputDevice()) || (!hasTradeInputDevice() && msg.hasTradeInputDevice())) return false;
		if (!(!hasTradeInputDevice() && !msg.hasTradeInputDevice()) && !FixUtils.equals(getTradeInputDevice(), msg.getTradeInputDevice())) return false;
		if ((hasAvgPxIndicator() && !msg.hasAvgPxIndicator()) || (!hasAvgPxIndicator() && msg.hasAvgPxIndicator())) return false;
		if (!(!hasAvgPxIndicator() && !msg.hasAvgPxIndicator()) && !(getAvgPxIndicator()==msg.getAvgPxIndicator())) return false;
		if ((hasAllocNoOrdersType() && !msg.hasAllocNoOrdersType()) || (!hasAllocNoOrdersType() && msg.hasAllocNoOrdersType())) return false;
		if (!(!hasAllocNoOrdersType() && !msg.hasAllocNoOrdersType()) && !(getAllocNoOrdersType()==msg.getAllocNoOrdersType())) return false;
		if ((hasPreviouslyReported() && !msg.hasPreviouslyReported()) || (!hasPreviouslyReported() && msg.hasPreviouslyReported())) return false;
		if (!(!hasPreviouslyReported() && !msg.hasPreviouslyReported()) && !(getPreviouslyReported()==msg.getPreviouslyReported())) return false;
		if ((hasReversalIndicator() && !msg.hasReversalIndicator()) || (!hasReversalIndicator() && msg.hasReversalIndicator())) return false;
		if (!(!hasReversalIndicator() && !msg.hasReversalIndicator()) && !(getReversalIndicator()==msg.getReversalIndicator())) return false;
		if ((hasMatchType() && !msg.hasMatchType()) || (!hasMatchType() && msg.hasMatchType())) return false;
		if (!(!hasMatchType() && !msg.hasMatchType()) && !FixUtils.equals(getMatchType(), msg.getMatchType())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasQuantity() && !msg.hasQuantity()) || (!hasQuantity() && msg.hasQuantity())) return false;
		if (!(!hasQuantity() && !msg.hasQuantity()) && !(getQuantity()==msg.getQuantity())) return false;
		if ((hasQtyType() && !msg.hasQtyType()) || (!hasQtyType() && msg.hasQtyType())) return false;
		if (!(!hasQtyType() && !msg.hasQtyType()) && !(getQtyType()==msg.getQtyType())) return false;
		if ((hasLastMkt() && !msg.hasLastMkt()) || (!hasLastMkt() && msg.hasLastMkt())) return false;
		if (!(!hasLastMkt() && !msg.hasLastMkt()) && !FixUtils.equals(getLastMkt(), msg.getLastMkt())) return false;
		if ((hasTradeOriginationDate() && !msg.hasTradeOriginationDate()) || (!hasTradeOriginationDate() && msg.hasTradeOriginationDate())) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		if ((hasPriceType() && !msg.hasPriceType()) || (!hasPriceType() && msg.hasPriceType())) return false;
		if (!(!hasPriceType() && !msg.hasPriceType()) && !(getPriceType()==msg.getPriceType())) return false;
		if ((hasAvgPx() && !msg.hasAvgPx()) || (!hasAvgPx() && msg.hasAvgPx())) return false;
		if (!(!hasAvgPx() && !msg.hasAvgPx()) && !(getAvgPx()==msg.getAvgPx())) return false;
		if ((hasAvgParPx() && !msg.hasAvgParPx()) || (!hasAvgParPx() && msg.hasAvgParPx())) return false;
		if (!(!hasAvgParPx() && !msg.hasAvgParPx()) && !(getAvgParPx()==msg.getAvgParPx())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasAvgPxPrecision() && !msg.hasAvgPxPrecision()) || (!hasAvgPxPrecision() && msg.hasAvgPxPrecision())) return false;
		if (!(!hasAvgPxPrecision() && !msg.hasAvgPxPrecision()) && !(getAvgPxPrecision()==msg.getAvgPxPrecision())) return false;
		if ((hasTradeDate() && !msg.hasTradeDate()) || (!hasTradeDate() && msg.hasTradeDate())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasSettlType() && !msg.hasSettlType()) || (!hasSettlType() && msg.hasSettlType())) return false;
		if (!(!hasSettlType() && !msg.hasSettlType()) && !FixUtils.equals(getSettlType(), msg.getSettlType())) return false;
		if ((hasSettlDate() && !msg.hasSettlDate()) || (!hasSettlDate() && msg.hasSettlDate())) return false;
		if ((hasBookingType() && !msg.hasBookingType()) || (!hasBookingType() && msg.hasBookingType())) return false;
		if (!(!hasBookingType() && !msg.hasBookingType()) && !(getBookingType()==msg.getBookingType())) return false;
		if ((hasGrossTradeAmt() && !msg.hasGrossTradeAmt()) || (!hasGrossTradeAmt() && msg.hasGrossTradeAmt())) return false;
		if (!(!hasGrossTradeAmt() && !msg.hasGrossTradeAmt()) && !(getGrossTradeAmt()==msg.getGrossTradeAmt())) return false;
		if ((hasConcession() && !msg.hasConcession()) || (!hasConcession() && msg.hasConcession())) return false;
		if (!(!hasConcession() && !msg.hasConcession()) && !(getConcession()==msg.getConcession())) return false;
		if ((hasTotalTakedown() && !msg.hasTotalTakedown()) || (!hasTotalTakedown() && msg.hasTotalTakedown())) return false;
		if (!(!hasTotalTakedown() && !msg.hasTotalTakedown()) && !(getTotalTakedown()==msg.getTotalTakedown())) return false;
		if ((hasNetMoney() && !msg.hasNetMoney()) || (!hasNetMoney() && msg.hasNetMoney())) return false;
		if (!(!hasNetMoney() && !msg.hasNetMoney()) && !(getNetMoney()==msg.getNetMoney())) return false;
		if ((hasPositionEffect() && !msg.hasPositionEffect()) || (!hasPositionEffect() && msg.hasPositionEffect())) return false;
		if (!(!hasPositionEffect() && !msg.hasPositionEffect()) && !(getPositionEffect()==msg.getPositionEffect())) return false;
		if ((hasAutoAcceptIndicator() && !msg.hasAutoAcceptIndicator()) || (!hasAutoAcceptIndicator() && msg.hasAutoAcceptIndicator())) return false;
		if (!(!hasAutoAcceptIndicator() && !msg.hasAutoAcceptIndicator()) && !(getAutoAcceptIndicator()==msg.getAutoAcceptIndicator())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasNumDaysInterest() && !msg.hasNumDaysInterest()) || (!hasNumDaysInterest() && msg.hasNumDaysInterest())) return false;
		if (!(!hasNumDaysInterest() && !msg.hasNumDaysInterest()) && !(getNumDaysInterest()==msg.getNumDaysInterest())) return false;
		if ((hasAccruedInterestRate() && !msg.hasAccruedInterestRate()) || (!hasAccruedInterestRate() && msg.hasAccruedInterestRate())) return false;
		if (!(!hasAccruedInterestRate() && !msg.hasAccruedInterestRate()) && !(getAccruedInterestRate()==msg.getAccruedInterestRate())) return false;
		if ((hasAccruedInterestAmt() && !msg.hasAccruedInterestAmt()) || (!hasAccruedInterestAmt() && msg.hasAccruedInterestAmt())) return false;
		if (!(!hasAccruedInterestAmt() && !msg.hasAccruedInterestAmt()) && !(getAccruedInterestAmt()==msg.getAccruedInterestAmt())) return false;
		if ((hasTotalAccruedInterestAmt() && !msg.hasTotalAccruedInterestAmt()) || (!hasTotalAccruedInterestAmt() && msg.hasTotalAccruedInterestAmt())) return false;
		if (!(!hasTotalAccruedInterestAmt() && !msg.hasTotalAccruedInterestAmt()) && !(getTotalAccruedInterestAmt()==msg.getTotalAccruedInterestAmt())) return false;
		if ((hasInterestAtMaturity() && !msg.hasInterestAtMaturity()) || (!hasInterestAtMaturity() && msg.hasInterestAtMaturity())) return false;
		if (!(!hasInterestAtMaturity() && !msg.hasInterestAtMaturity()) && !(getInterestAtMaturity()==msg.getInterestAtMaturity())) return false;
		if ((hasEndAccruedInterestAmt() && !msg.hasEndAccruedInterestAmt()) || (!hasEndAccruedInterestAmt() && msg.hasEndAccruedInterestAmt())) return false;
		if (!(!hasEndAccruedInterestAmt() && !msg.hasEndAccruedInterestAmt()) && !(getEndAccruedInterestAmt()==msg.getEndAccruedInterestAmt())) return false;
		if ((hasStartCash() && !msg.hasStartCash()) || (!hasStartCash() && msg.hasStartCash())) return false;
		if (!(!hasStartCash() && !msg.hasStartCash()) && !(getStartCash()==msg.getStartCash())) return false;
		if ((hasEndCash() && !msg.hasEndCash()) || (!hasEndCash() && msg.hasEndCash())) return false;
		if (!(!hasEndCash() && !msg.hasEndCash()) && !(getEndCash()==msg.getEndCash())) return false;
		if ((hasLegalConfirm() && !msg.hasLegalConfirm()) || (!hasLegalConfirm() && msg.hasLegalConfirm())) return false;
		if (!(!hasLegalConfirm() && !msg.hasLegalConfirm()) && !(getLegalConfirm()==msg.getLegalConfirm())) return false;
		if ((hasTotNoAllocs() && !msg.hasTotNoAllocs()) || (!hasTotNoAllocs() && msg.hasTotNoAllocs())) return false;
		if (!(!hasTotNoAllocs() && !msg.hasTotNoAllocs()) && !(getTotNoAllocs()==msg.getTotNoAllocs())) return false;
		if ((hasLastFragment() && !msg.hasLastFragment()) || (!hasLastFragment() && msg.hasLastFragment())) return false;
		if (!(!hasLastFragment() && !msg.hasLastFragment()) && !(getLastFragment()==msg.getLastFragment())) return false;
		return true;
	}
	@Override
	public FixAllocationReport clone () {
		FixAllocationReport out = new FixAllocationReport();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixAllocationReport clone ( FixAllocationReport out ) {
		if ( hasAllocReportID())
			out.setAllocReportID(getAllocReportID());
		if ( hasAllocID())
			out.setAllocID(getAllocID());
		if ( hasAllocTransType())
			out.setAllocTransType(getAllocTransType());
		if ( hasAllocReportRefID())
			out.setAllocReportRefID(getAllocReportRefID());
		if ( hasAllocCancReplaceReason())
			out.setAllocCancReplaceReason(getAllocCancReplaceReason());
		if ( hasSecondaryAllocID())
			out.setSecondaryAllocID(getSecondaryAllocID());
		if ( hasAllocReportType())
			out.setAllocReportType(getAllocReportType());
		if ( hasAllocStatus())
			out.setAllocStatus(getAllocStatus());
		if ( hasAllocRejCode())
			out.setAllocRejCode(getAllocRejCode());
		if ( hasRefAllocID())
			out.setRefAllocID(getRefAllocID());
		if ( hasAllocIntermedReqType())
			out.setAllocIntermedReqType(getAllocIntermedReqType());
		if ( hasAllocLinkID())
			out.setAllocLinkID(getAllocLinkID());
		if ( hasAllocLinkType())
			out.setAllocLinkType(getAllocLinkType());
		if ( hasBookingRefID())
			out.setBookingRefID(getBookingRefID());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasTrdType())
			out.setTrdType(getTrdType());
		if ( hasTrdSubType())
			out.setTrdSubType(getTrdSubType());
		if ( hasMultiLegReportingType())
			out.setMultiLegReportingType(getMultiLegReportingType());
		if ( hasCustOrderCapacity())
			out.setCustOrderCapacity(getCustOrderCapacity());
		if ( hasTradeInputSource())
			out.setTradeInputSource(getTradeInputSource());
		if ( hasRndPx())
			out.setRndPx(getRndPx());
		if ( hasMessageEventSource())
			out.setMessageEventSource(getMessageEventSource());
		if ( hasTradeInputDevice())
			out.setTradeInputDevice(getTradeInputDevice());
		if ( hasAvgPxIndicator())
			out.setAvgPxIndicator(getAvgPxIndicator());
		if ( hasAllocNoOrdersType())
			out.setAllocNoOrdersType(getAllocNoOrdersType());
		if ( hasPreviouslyReported())
			out.setPreviouslyReported(getPreviouslyReported());
		if ( hasReversalIndicator())
			out.setReversalIndicator(getReversalIndicator());
		if ( hasMatchType())
			out.setMatchType(getMatchType());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasQuantity())
			out.setQuantity(getQuantity());
		if ( hasQtyType())
			out.setQtyType(getQtyType());
		if ( hasLastMkt())
			out.setLastMkt(getLastMkt());
		if ( hasTradeOriginationDate())
			out.setTradeOriginationDate(getTradeOriginationDate());
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		if ( hasPriceType())
			out.setPriceType(getPriceType());
		if ( hasAvgPx())
			out.setAvgPx(getAvgPx());
		if ( hasAvgParPx())
			out.setAvgParPx(getAvgParPx());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasAvgPxPrecision())
			out.setAvgPxPrecision(getAvgPxPrecision());
		if ( hasTradeDate())
			out.setTradeDate(getTradeDate());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasSettlType())
			out.setSettlType(getSettlType());
		if ( hasSettlDate())
			out.setSettlDate(getSettlDate());
		if ( hasBookingType())
			out.setBookingType(getBookingType());
		if ( hasGrossTradeAmt())
			out.setGrossTradeAmt(getGrossTradeAmt());
		if ( hasConcession())
			out.setConcession(getConcession());
		if ( hasTotalTakedown())
			out.setTotalTakedown(getTotalTakedown());
		if ( hasNetMoney())
			out.setNetMoney(getNetMoney());
		if ( hasPositionEffect())
			out.setPositionEffect(getPositionEffect());
		if ( hasAutoAcceptIndicator())
			out.setAutoAcceptIndicator(getAutoAcceptIndicator());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasNumDaysInterest())
			out.setNumDaysInterest(getNumDaysInterest());
		if ( hasAccruedInterestRate())
			out.setAccruedInterestRate(getAccruedInterestRate());
		if ( hasAccruedInterestAmt())
			out.setAccruedInterestAmt(getAccruedInterestAmt());
		if ( hasTotalAccruedInterestAmt())
			out.setTotalAccruedInterestAmt(getTotalAccruedInterestAmt());
		if ( hasInterestAtMaturity())
			out.setInterestAtMaturity(getInterestAtMaturity());
		if ( hasEndAccruedInterestAmt())
			out.setEndAccruedInterestAmt(getEndAccruedInterestAmt());
		if ( hasStartCash())
			out.setStartCash(getStartCash());
		if ( hasEndCash())
			out.setEndCash(getEndCash());
		if ( hasLegalConfirm())
			out.setLegalConfirm(getLegalConfirm());
		if ( hasTotNoAllocs())
			out.setTotNoAllocs(getTotNoAllocs());
		if ( hasLastFragment())
			out.setLastFragment(getLastFragment());
		int count = 0;
		count = 0;
		for (FixOrdAllocGrp fixOrdAllocGrp : ordAllocGrp) {
			if (!fixOrdAllocGrp.hasGroup()) continue;
			out.ordAllocGrp[count] = fixOrdAllocGrp.clone( out.ordAllocGrp[count] );
			count++;
		}
		count = 0;
		for (FixExecAllocGrp fixExecAllocGrp : execAllocGrp) {
			if (!fixExecAllocGrp.hasGroup()) continue;
			out.execAllocGrp[count] = fixExecAllocGrp.clone( out.execAllocGrp[count] );
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
		if (spreadOrBenchmarkCurveData.hasGroup())
			out.spreadOrBenchmarkCurveData = spreadOrBenchmarkCurveData.clone( out.spreadOrBenchmarkCurveData);
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixStipulations fixStipulations : stipulations) {
			if (!fixStipulations.hasGroup()) continue;
			out.stipulations[count] = fixStipulations.clone( out.stipulations[count] );
			count++;
		}
		if (yieldData.hasGroup())
			out.yieldData = yieldData.clone( out.yieldData);
		count = 0;
		for (FixPositionAmountData fixPositionAmountData : positionAmountData) {
			if (!fixPositionAmountData.hasGroup()) continue;
			out.positionAmountData[count] = fixPositionAmountData.clone( out.positionAmountData[count] );
			count++;
		}
		count = 0;
		for (FixAllocGrp fixAllocGrp : allocGrp) {
			if (!fixAllocGrp.hasGroup()) continue;
			out.allocGrp[count] = fixAllocGrp.clone( out.allocGrp[count] );
			count++;
		}
		count = 0;
		for (FixRateSource fixRateSource : rateSource) {
			if (!fixRateSource.hasGroup()) continue;
			out.rateSource[count] = fixRateSource.clone( out.rateSource[count] );
			count++;
		}
		return out;
	}

}
