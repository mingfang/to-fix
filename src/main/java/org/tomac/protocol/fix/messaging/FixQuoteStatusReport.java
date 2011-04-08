package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixQuoteStatusReport extends FixInMessage {
	private short hasQuoteStatusReqID;
	byte[] quoteStatusReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteReqID;
	byte[] quoteReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteID;
	byte[] quoteID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteMsgID;
	byte[] quoteMsgID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteRespID;
	byte[] quoteRespID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteType;
	long quoteType = 0;		
	private short hasQuoteCancelType;
	long quoteCancelType = 0;		
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasSettlType;
	byte[] settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlDate;
	byte[] settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlDate2;
	byte[] settlDate2 = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderQty2;
	long orderQty2 = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasAccount;
	byte[] account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAcctIDSource;
	long acctIDSource = 0;		
	private short hasAccountType;
	long accountType = 0;		
	private short hasExpireTime;
	byte[] expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasPrice;
	long price = 0;		
	private short hasPriceType;
	long priceType = 0;		
	private short hasBidPx;
	long bidPx = 0;		
	private short hasOfferPx;
	long offerPx = 0;		
	private short hasMktBidPx;
	long mktBidPx = 0;		
	private short hasMktOfferPx;
	long mktOfferPx = 0;		
	private short hasMinBidSize;
	long minBidSize = 0;		
	private short hasBidSize;
	long bidSize = 0;		
	private short hasMinOfferSize;
	long minOfferSize = 0;		
	private short hasOfferSize;
	long offerSize = 0;		
	private short hasMinQty;
	long minQty = 0;		
	private short hasValidUntilTime;
	byte[] validUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasBidSpotRate;
	long bidSpotRate = 0;		
	private short hasOfferSpotRate;
	long offerSpotRate = 0;		
	private short hasBidForwardPoints;
	long bidForwardPoints = 0;		
	private short hasOfferForwardPoints;
	long offerForwardPoints = 0;		
	private short hasMidPx;
	long midPx = 0;		
	private short hasBidYield;
	long bidYield = 0;		
	private short hasMidYield;
	long midYield = 0;		
	private short hasOfferYield;
	long offerYield = 0;		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasOrdType;
	byte ordType = (byte)' ';		
	private short hasBidForwardPoints2;
	long bidForwardPoints2 = 0;		
	private short hasOfferForwardPoints2;
	long offerForwardPoints2 = 0;		
	private short hasSettlCurrBidFxRate;
	long settlCurrBidFxRate = 0;		
	private short hasSettlCurrOfferFxRate;
	long settlCurrOfferFxRate = 0;		
	private short hasSettlCurrFxRateCalc;
	byte settlCurrFxRateCalc = (byte)' ';		
	private short hasCommType;
	byte commType = (byte)' ';		
	private short hasCommission;
	long commission = 0;		
	private short hasCustOrderCapacity;
	long custOrderCapacity = 0;		
	private short hasExDestination;
	byte[] exDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExDestinationIDSource;
	byte exDestinationIDSource = (byte)' ';		
	private short hasBookingType;
	long bookingType = 0;		
	private short hasOrderCapacity;
	byte orderCapacity = (byte)' ';		
	private short hasOrderRestrictions;
	byte[] orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteStatus;
	long quoteStatus = 0;		
	private short hasQuoteRejectReason;
	long quoteRejectReason = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixParties[] parties;
	public FixTargetParties[] targetParties;
	public FixInstrument instrument;
	public FixFinancingDetails financingDetails;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixOrderQtyData orderQtyData;
	public FixStipulations[] stipulations;
	public FixLegQuotStatGrp[] legQuotStatGrp;
	public FixQuotQualGrp[] quotQualGrp;
	public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	public FixYieldData yieldData;
	
	public FixQuoteStatusReport() {
		super(FixMessageInfo.MessageTypes.QUOTESTATUSREPORT);


		hasQuoteStatusReqID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteStatusReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteReqID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteMsgID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteMsgID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteRespID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteRespID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteType = FixUtils.TAG_HAS_NO_VALUE;		
		hasQuoteCancelType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlDate2 = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate2 = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderQty2 = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;		
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;		
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasBidPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasOfferPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasMktBidPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasMktOfferPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasMinBidSize = FixUtils.TAG_HAS_NO_VALUE;		
		hasBidSize = FixUtils.TAG_HAS_NO_VALUE;		
		hasMinOfferSize = FixUtils.TAG_HAS_NO_VALUE;		
		hasOfferSize = FixUtils.TAG_HAS_NO_VALUE;		
		hasMinQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasValidUntilTime = FixUtils.TAG_HAS_NO_VALUE;		
		validUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasBidSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasOfferSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasBidForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		hasOfferForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		hasMidPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasBidYield = FixUtils.TAG_HAS_NO_VALUE;		
		hasMidYield = FixUtils.TAG_HAS_NO_VALUE;		
		hasOfferYield = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasBidForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		hasOfferForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrBidFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrOfferFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_NO_VALUE;		
		hasCommType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCommission = FixUtils.TAG_HAS_NO_VALUE;		
		hasCustOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasExDestination = FixUtils.TAG_HAS_NO_VALUE;		
		exDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExDestinationIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasBookingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderRestrictions = FixUtils.TAG_HAS_NO_VALUE;		
		orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasQuoteRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		targetParties = new FixTargetParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) targetParties[i] = new FixTargetParties();
		instrument = new FixInstrument();
		financingDetails = new FixFinancingDetails();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		orderQtyData = new FixOrderQtyData();
		stipulations = new FixStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) stipulations[i] = new FixStipulations();
		legQuotStatGrp = new FixLegQuotStatGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) legQuotStatGrp[i] = new FixLegQuotStatGrp();
		quotQualGrp = new FixQuotQualGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) quotQualGrp[i] = new FixQuotQualGrp();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		yieldData = new FixYieldData();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.QUOTESTATUSREQID_INT:		
            		hasQuoteStatusReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QUOTEREQID_INT:		
            		hasQuoteReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QUOTEID_INT:		
            		hasQuoteID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QUOTEMSGID_INT:		
            		hasQuoteMsgID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QUOTERESPID_INT:		
            		hasQuoteRespID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QUOTETYPE_INT:		
            		hasQuoteType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QUOTECANCELTYPE_INT:		
            		hasQuoteCancelType = (short) buf.position();		
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
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
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
            	case FixTags.SETTLDATE2_INT:		
            		hasSettlDate2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDERQTY2_INT:		
            		hasOrderQty2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
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
            	case FixTags.EXPIRETIME_INT:		
            		hasExpireTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRICE_INT:		
            		hasPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRICETYPE_INT:		
            		hasPriceType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BIDPX_INT:		
            		hasBidPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.OFFERPX_INT:		
            		hasOfferPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MKTBIDPX_INT:		
            		hasMktBidPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MKTOFFERPX_INT:		
            		hasMktOfferPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MINBIDSIZE_INT:		
            		hasMinBidSize = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BIDSIZE_INT:		
            		hasBidSize = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MINOFFERSIZE_INT:		
            		hasMinOfferSize = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.OFFERSIZE_INT:		
            		hasOfferSize = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MINQTY_INT:		
            		hasMinQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.VALIDUNTILTIME_INT:		
            		hasValidUntilTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BIDSPOTRATE_INT:		
            		hasBidSpotRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.OFFERSPOTRATE_INT:		
            		hasOfferSpotRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BIDFORWARDPOINTS_INT:		
            		hasBidForwardPoints = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.OFFERFORWARDPOINTS_INT:		
            		hasOfferForwardPoints = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MIDPX_INT:		
            		hasMidPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BIDYIELD_INT:		
            		hasBidYield = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MIDYIELD_INT:		
            		hasMidYield = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.OFFERYIELD_INT:		
            		hasOfferYield = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDTYPE_INT:		
            		hasOrdType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BIDFORWARDPOINTS2_INT:		
            		hasBidForwardPoints2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.OFFERFORWARDPOINTS2_INT:		
            		hasOfferForwardPoints2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLCURRBIDFXRATE_INT:		
            		hasSettlCurrBidFxRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLCURROFFERFXRATE_INT:		
            		hasSettlCurrOfferFxRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLCURRFXRATECALC_INT:		
            		hasSettlCurrFxRateCalc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COMMTYPE_INT:		
            		hasCommType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COMMISSION_INT:		
            		hasCommission = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CUSTORDERCAPACITY_INT:		
            		hasCustOrderCapacity = (short) buf.position();		
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
            	case FixTags.BOOKINGTYPE_INT:		
            		hasBookingType = (short) buf.position();		
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
            	case FixTags.QUOTESTATUS_INT:		
            		hasQuoteStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QUOTEREJECTREASON_INT:		
            		hasQuoteRejectReason = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOTARGETPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !targetParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = targetParties[count].setBuffer( repeatingGroupTag, buf, err);	
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
        			} else if ( orderQtyData.isKeyTag(tag)) {
        				tag = orderQtyData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
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
        			} else if ( tag == FixTags.NOLEGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !legQuotStatGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = legQuotStatGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOQUOTEQUALIFIERS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !quotQualGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = quotQualGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( spreadOrBenchmarkCurveData.isKeyTag(tag)) {
        				tag = spreadOrBenchmarkCurveData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( yieldData.isKeyTag(tag)) {
        				tag = yieldData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.QUOTESTATUSREPORT);
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

		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getQuoteStatusReqID();		
		getQuoteReqID();		
		getQuoteID();		
		getQuoteMsgID();		
		getQuoteRespID();		
		getQuoteType();		
		getQuoteCancelType();		
		getTradingSessionID();		
		getTradingSessionSubID();		
		getSide();		
		getSettlType();		
		getSettlDate();		
		getSettlDate2();		
		getOrderQty2();		
		getCurrency();		
		getAccount();		
		getAcctIDSource();		
		getAccountType();		
		getExpireTime();		
		getPrice();		
		getPriceType();		
		getBidPx();		
		getOfferPx();		
		getMktBidPx();		
		getMktOfferPx();		
		getMinBidSize();		
		getBidSize();		
		getMinOfferSize();		
		getOfferSize();		
		getMinQty();		
		getValidUntilTime();		
		getBidSpotRate();		
		getOfferSpotRate();		
		getBidForwardPoints();		
		getOfferForwardPoints();		
		getMidPx();		
		getBidYield();		
		getMidYield();		
		getOfferYield();		
		getTransactTime();		
		getOrdType();		
		getBidForwardPoints2();		
		getOfferForwardPoints2();		
		getSettlCurrBidFxRate();		
		getSettlCurrOfferFxRate();		
		getSettlCurrFxRateCalc();		
		getCommType();		
		getCommission();		
		getCustOrderCapacity();		
		getExDestination();		
		getExDestinationIDSource();		
		getBookingType();		
		getOrderCapacity();		
		getOrderRestrictions();		
		getQuoteStatus();		
		getQuoteRejectReason();		
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
		if (hasQuoteStatusReqID()) {		
			out.put(FixTags.QUOTESTATUSREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,quoteStatusReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteReqID()) {		
			out.put(FixTags.QUOTEREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,quoteReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteID()) {		
			out.put(FixTags.QUOTEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,quoteID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteMsgID()) {		
			out.put(FixTags.QUOTEMSGID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,quoteMsgID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteRespID()) {		
			out.put(FixTags.QUOTERESPID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,quoteRespID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteType()) {		
			out.put(FixTags.QUOTETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)quoteType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteCancelType()) {		
			out.put(FixTags.QUOTECANCELTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)quoteCancelType);
		
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
		if (hasSide()) {		
			out.put(FixTags.SIDE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,side); 		
		
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
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
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
		if (hasExpireTime()) {		
			out.put(FixTags.EXPIRETIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,expireTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPrice()) {		
			out.put(FixTags.PRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)price);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriceType()) {		
			out.put(FixTags.PRICETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priceType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBidPx()) {		
			out.put(FixTags.BIDPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)bidPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOfferPx()) {		
			out.put(FixTags.OFFERPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)offerPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMktBidPx()) {		
			out.put(FixTags.MKTBIDPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)mktBidPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMktOfferPx()) {		
			out.put(FixTags.MKTOFFERPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)mktOfferPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMinBidSize()) {		
			out.put(FixTags.MINBIDSIZE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)minBidSize);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBidSize()) {		
			out.put(FixTags.BIDSIZE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)bidSize);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMinOfferSize()) {		
			out.put(FixTags.MINOFFERSIZE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)minOfferSize);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOfferSize()) {		
			out.put(FixTags.OFFERSIZE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)offerSize);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMinQty()) {		
			out.put(FixTags.MINQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)minQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasValidUntilTime()) {		
			out.put(FixTags.VALIDUNTILTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,validUntilTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBidSpotRate()) {		
			out.put(FixTags.BIDSPOTRATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)bidSpotRate);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOfferSpotRate()) {		
			out.put(FixTags.OFFERSPOTRATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)offerSpotRate);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBidForwardPoints()) {		
			out.put(FixTags.BIDFORWARDPOINTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)bidForwardPoints);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOfferForwardPoints()) {		
			out.put(FixTags.OFFERFORWARDPOINTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)offerForwardPoints);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMidPx()) {		
			out.put(FixTags.MIDPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)midPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBidYield()) {		
			out.put(FixTags.BIDYIELD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)bidYield);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMidYield()) {		
			out.put(FixTags.MIDYIELD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)midYield);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOfferYield()) {		
			out.put(FixTags.OFFERYIELD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)offerYield);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrdType()) {		
			out.put(FixTags.ORDTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,ordType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBidForwardPoints2()) {		
			out.put(FixTags.BIDFORWARDPOINTS2);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)bidForwardPoints2);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOfferForwardPoints2()) {		
			out.put(FixTags.OFFERFORWARDPOINTS2);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)offerForwardPoints2);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlCurrBidFxRate()) {		
			out.put(FixTags.SETTLCURRBIDFXRATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)settlCurrBidFxRate);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlCurrOfferFxRate()) {		
			out.put(FixTags.SETTLCURROFFERFXRATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)settlCurrOfferFxRate);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlCurrFxRateCalc()) {		
			out.put(FixTags.SETTLCURRFXRATECALC);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlCurrFxRateCalc); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCommType()) {		
			out.put(FixTags.COMMTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,commType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCommission()) {		
			out.put(FixTags.COMMISSION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)commission);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCustOrderCapacity()) {		
			out.put(FixTags.CUSTORDERCAPACITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)custOrderCapacity);
		
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
		if (hasBookingType()) {		
			out.put(FixTags.BOOKINGTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)bookingType);
		
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
		if (hasQuoteStatus()) {		
			out.put(FixTags.QUOTESTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)quoteStatus);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteRejectReason()) {		
			out.put(FixTags.QUOTEREJECTREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)quoteRejectReason);
		
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
		
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(targetParties)>0) {
			out.put(FixTags.NOTARGETPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(targetParties));

			out.put(FixUtils.SOH);

		}
		for (FixTargetParties fixTargetParties : targetParties) if (fixTargetParties.hasGroup()) fixTargetParties.encode(out);
		instrument.encode(out);
		financingDetails.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		orderQtyData.encode(out);
		if (FixUtils.getNoInGroup(stipulations)>0) {
			out.put(FixTags.NOSTIPULATIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(stipulations));

			out.put(FixUtils.SOH);

		}
		for (FixStipulations fixStipulations : stipulations) if (fixStipulations.hasGroup()) fixStipulations.encode(out);
		if (FixUtils.getNoInGroup(legQuotStatGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(legQuotStatGrp));

			out.put(FixUtils.SOH);

		}
		for (FixLegQuotStatGrp fixLegQuotStatGrp : legQuotStatGrp) if (fixLegQuotStatGrp.hasGroup()) fixLegQuotStatGrp.encode(out);
		if (FixUtils.getNoInGroup(quotQualGrp)>0) {
			out.put(FixTags.NOQUOTEQUALIFIERS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(quotQualGrp));

			out.put(FixUtils.SOH);

		}
		for (FixQuotQualGrp fixQuotQualGrp : quotQualGrp) if (fixQuotQualGrp.hasGroup()) fixQuotQualGrp.encode(out);
		spreadOrBenchmarkCurveData.encode(out);
		yieldData.encode(out);
		
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
		
		if (hasQuoteStatusReqID()) {		
			FixUtils.put(out,quoteStatusReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteReqID()) {		
			FixUtils.put(out,quoteReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteID()) {		
			FixUtils.put(out,quoteID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteMsgID()) {		
			FixUtils.put(out,quoteMsgID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteRespID()) {		
			FixUtils.put(out,quoteRespID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteType()) {		
			FixUtils.put(out, (long)quoteType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteCancelType()) {		
			FixUtils.put(out, (long)quoteCancelType);
		
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
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
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
		
		if (hasSettlDate2()) {		
			FixUtils.put(out,settlDate2); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderQty2()) {		
			FixUtils.put(out, (long)orderQty2);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
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
		
		if (hasExpireTime()) {		
			FixUtils.put(out,expireTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPrice()) {		
			FixUtils.put(out, (long)price);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceType()) {		
			FixUtils.put(out, (long)priceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidPx()) {		
			FixUtils.put(out, (long)bidPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOfferPx()) {		
			FixUtils.put(out, (long)offerPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMktBidPx()) {		
			FixUtils.put(out, (long)mktBidPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMktOfferPx()) {		
			FixUtils.put(out, (long)mktOfferPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMinBidSize()) {		
			FixUtils.put(out, (long)minBidSize);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidSize()) {		
			FixUtils.put(out, (long)bidSize);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMinOfferSize()) {		
			FixUtils.put(out, (long)minOfferSize);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOfferSize()) {		
			FixUtils.put(out, (long)offerSize);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMinQty()) {		
			FixUtils.put(out, (long)minQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasValidUntilTime()) {		
			FixUtils.put(out,validUntilTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidSpotRate()) {		
			FixUtils.put(out, (long)bidSpotRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOfferSpotRate()) {		
			FixUtils.put(out, (long)offerSpotRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidForwardPoints()) {		
			FixUtils.put(out, (long)bidForwardPoints);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOfferForwardPoints()) {		
			FixUtils.put(out, (long)offerForwardPoints);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMidPx()) {		
			FixUtils.put(out, (long)midPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidYield()) {		
			FixUtils.put(out, (long)bidYield);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMidYield()) {		
			FixUtils.put(out, (long)midYield);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOfferYield()) {		
			FixUtils.put(out, (long)offerYield);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdType()) {		
			FixUtils.put(out,ordType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidForwardPoints2()) {		
			FixUtils.put(out, (long)bidForwardPoints2);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOfferForwardPoints2()) {		
			FixUtils.put(out, (long)offerForwardPoints2);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrBidFxRate()) {		
			FixUtils.put(out, (long)settlCurrBidFxRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrOfferFxRate()) {		
			FixUtils.put(out, (long)settlCurrOfferFxRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrFxRateCalc()) {		
			FixUtils.put(out,settlCurrFxRateCalc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCommType()) {		
			FixUtils.put(out,commType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCommission()) {		
			FixUtils.put(out, (long)commission);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCustOrderCapacity()) {		
			FixUtils.put(out, (long)custOrderCapacity);
		
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
		
		if (hasBookingType()) {		
			FixUtils.put(out, (long)bookingType);
		
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
		
		if (hasQuoteStatus()) {		
			FixUtils.put(out, (long)quoteStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteRejectReason()) {		
			FixUtils.put(out, (long)quoteRejectReason);
		
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
			
	public void crackQuoteStatusReqID() {		
		getQuoteStatusReqID();		
	}		
			
	public byte[] getQuoteStatusReqID() { 		
		if ( hasQuoteStatusReqID()) {		
			if (hasQuoteStatusReqID == FixUtils.TAG_HAS_VALUE) {		
				return quoteStatusReqID; 		
			} else {

				buf.position(hasQuoteStatusReqID);

			FixMessage.getTagStringValue(buf, quoteStatusReqID, 0, quoteStatusReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasQuoteStatusReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteStatusReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteStatusReqID() { return hasQuoteStatusReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteStatusReqID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteStatusReqID()) FixUtils.fillNul(quoteStatusReqID);		
		FixUtils.copy(quoteStatusReqID, src); 		
		hasQuoteStatusReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteStatusReqID(String str) {		
		if (str == null ) return;
		if (hasQuoteStatusReqID()) FixUtils.fillNul(quoteStatusReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteStatusReqID, src); 		
		hasQuoteStatusReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteReqID() {		
		getQuoteReqID();		
	}		
			
	public byte[] getQuoteReqID() { 		
		if ( hasQuoteReqID()) {		
			if (hasQuoteReqID == FixUtils.TAG_HAS_VALUE) {		
				return quoteReqID; 		
			} else {

				buf.position(hasQuoteReqID);

			FixMessage.getTagStringValue(buf, quoteReqID, 0, quoteReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasQuoteReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteReqID() { return hasQuoteReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteReqID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteReqID()) FixUtils.fillNul(quoteReqID);		
		FixUtils.copy(quoteReqID, src); 		
		hasQuoteReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteReqID(String str) {		
		if (str == null ) return;
		if (hasQuoteReqID()) FixUtils.fillNul(quoteReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteReqID, src); 		
		hasQuoteReqID = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, quoteID, 0, quoteID.length, err);
		
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
			
	public void crackQuoteMsgID() {		
		getQuoteMsgID();		
	}		
			
	public byte[] getQuoteMsgID() { 		
		if ( hasQuoteMsgID()) {		
			if (hasQuoteMsgID == FixUtils.TAG_HAS_VALUE) {		
				return quoteMsgID; 		
			} else {

				buf.position(hasQuoteMsgID);

			FixMessage.getTagStringValue(buf, quoteMsgID, 0, quoteMsgID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasQuoteMsgID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteMsgID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteMsgID() { return hasQuoteMsgID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteMsgID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteMsgID()) FixUtils.fillNul(quoteMsgID);		
		FixUtils.copy(quoteMsgID, src); 		
		hasQuoteMsgID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteMsgID(String str) {		
		if (str == null ) return;
		if (hasQuoteMsgID()) FixUtils.fillNul(quoteMsgID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteMsgID, src); 		
		hasQuoteMsgID = FixUtils.TAG_HAS_VALUE;		
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
		if (hasQuoteRespID()) FixUtils.fillNul(quoteRespID);		
		FixUtils.copy(quoteRespID, src); 		
		hasQuoteRespID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteRespID(String str) {		
		if (str == null ) return;
		if (hasQuoteRespID()) FixUtils.fillNul(quoteRespID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteRespID, src); 		
		hasQuoteRespID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteType() {		
		getQuoteType();		
	}		
			
	public long getQuoteType() { 		
		if ( hasQuoteType()) {		
			if (hasQuoteType == FixUtils.TAG_HAS_VALUE) {		
				return quoteType; 		
			} else {

				buf.position(hasQuoteType);

			quoteType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQuoteType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuoteType() { return hasQuoteType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteType(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteType()) quoteType = FixUtils.TAG_HAS_NO_VALUE;		
		quoteType = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteType(long src) {		
		quoteType = src;
		hasQuoteType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteType(String str) {		
		if (str == null ) return;
		if (hasQuoteType()) quoteType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quoteType = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteCancelType() {		
		getQuoteCancelType();		
	}		
			
	public long getQuoteCancelType() { 		
		if ( hasQuoteCancelType()) {		
			if (hasQuoteCancelType == FixUtils.TAG_HAS_VALUE) {		
				return quoteCancelType; 		
			} else {

				buf.position(hasQuoteCancelType);

			quoteCancelType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQuoteCancelType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteCancelType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuoteCancelType() { return hasQuoteCancelType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteCancelType(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteCancelType()) quoteCancelType = FixUtils.TAG_HAS_NO_VALUE;		
		quoteCancelType = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteCancelType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteCancelType(long src) {		
		quoteCancelType = src;
		hasQuoteCancelType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteCancelType(String str) {		
		if (str == null ) return;
		if (hasQuoteCancelType()) quoteCancelType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quoteCancelType = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteCancelType = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackBidPx() {		
		getBidPx();		
	}		
			
	public long getBidPx() { 		
		if ( hasBidPx()) {		
			if (hasBidPx == FixUtils.TAG_HAS_VALUE) {		
				return bidPx; 		
			} else {

				buf.position(hasBidPx);

			bidPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBidPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidPx() { return hasBidPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidPx(byte[] src) {		
		if (src == null ) return;
		if (hasBidPx()) bidPx = FixUtils.TAG_HAS_NO_VALUE;		
		bidPx = FixUtils.longValueOf(src, 0, src.length);
		hasBidPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidPx(long src) {		
		bidPx = src;
		hasBidPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidPx(String str) {		
		if (str == null ) return;
		if (hasBidPx()) bidPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidPx = FixUtils.longValueOf(src, 0, src.length);
		hasBidPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOfferPx() {		
		getOfferPx();		
	}		
			
	public long getOfferPx() { 		
		if ( hasOfferPx()) {		
			if (hasOfferPx == FixUtils.TAG_HAS_VALUE) {		
				return offerPx; 		
			} else {

				buf.position(hasOfferPx);

			offerPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasOfferPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return offerPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOfferPx() { return hasOfferPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOfferPx(byte[] src) {		
		if (src == null ) return;
		if (hasOfferPx()) offerPx = FixUtils.TAG_HAS_NO_VALUE;		
		offerPx = FixUtils.longValueOf(src, 0, src.length);
		hasOfferPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferPx(long src) {		
		offerPx = src;
		hasOfferPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferPx(String str) {		
		if (str == null ) return;
		if (hasOfferPx()) offerPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		offerPx = FixUtils.longValueOf(src, 0, src.length);
		hasOfferPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMktBidPx() {		
		getMktBidPx();		
	}		
			
	public long getMktBidPx() { 		
		if ( hasMktBidPx()) {		
			if (hasMktBidPx == FixUtils.TAG_HAS_VALUE) {		
				return mktBidPx; 		
			} else {

				buf.position(hasMktBidPx);

			mktBidPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMktBidPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return mktBidPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMktBidPx() { return hasMktBidPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMktBidPx(byte[] src) {		
		if (src == null ) return;
		if (hasMktBidPx()) mktBidPx = FixUtils.TAG_HAS_NO_VALUE;		
		mktBidPx = FixUtils.longValueOf(src, 0, src.length);
		hasMktBidPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMktBidPx(long src) {		
		mktBidPx = src;
		hasMktBidPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMktBidPx(String str) {		
		if (str == null ) return;
		if (hasMktBidPx()) mktBidPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mktBidPx = FixUtils.longValueOf(src, 0, src.length);
		hasMktBidPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMktOfferPx() {		
		getMktOfferPx();		
	}		
			
	public long getMktOfferPx() { 		
		if ( hasMktOfferPx()) {		
			if (hasMktOfferPx == FixUtils.TAG_HAS_VALUE) {		
				return mktOfferPx; 		
			} else {

				buf.position(hasMktOfferPx);

			mktOfferPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMktOfferPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return mktOfferPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMktOfferPx() { return hasMktOfferPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMktOfferPx(byte[] src) {		
		if (src == null ) return;
		if (hasMktOfferPx()) mktOfferPx = FixUtils.TAG_HAS_NO_VALUE;		
		mktOfferPx = FixUtils.longValueOf(src, 0, src.length);
		hasMktOfferPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMktOfferPx(long src) {		
		mktOfferPx = src;
		hasMktOfferPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMktOfferPx(String str) {		
		if (str == null ) return;
		if (hasMktOfferPx()) mktOfferPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mktOfferPx = FixUtils.longValueOf(src, 0, src.length);
		hasMktOfferPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMinBidSize() {		
		getMinBidSize();		
	}		
			
	public long getMinBidSize() { 		
		if ( hasMinBidSize()) {		
			if (hasMinBidSize == FixUtils.TAG_HAS_VALUE) {		
				return minBidSize; 		
			} else {

				buf.position(hasMinBidSize);

			minBidSize = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMinBidSize = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return minBidSize;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMinBidSize() { return hasMinBidSize != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMinBidSize(byte[] src) {		
		if (src == null ) return;
		if (hasMinBidSize()) minBidSize = FixUtils.TAG_HAS_NO_VALUE;		
		minBidSize = FixUtils.longValueOf(src, 0, src.length);
		hasMinBidSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinBidSize(long src) {		
		minBidSize = src;
		hasMinBidSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinBidSize(String str) {		
		if (str == null ) return;
		if (hasMinBidSize()) minBidSize = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		minBidSize = FixUtils.longValueOf(src, 0, src.length);
		hasMinBidSize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBidSize() {		
		getBidSize();		
	}		
			
	public long getBidSize() { 		
		if ( hasBidSize()) {		
			if (hasBidSize == FixUtils.TAG_HAS_VALUE) {		
				return bidSize; 		
			} else {

				buf.position(hasBidSize);

			bidSize = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBidSize = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidSize;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidSize() { return hasBidSize != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidSize(byte[] src) {		
		if (src == null ) return;
		if (hasBidSize()) bidSize = FixUtils.TAG_HAS_NO_VALUE;		
		bidSize = FixUtils.longValueOf(src, 0, src.length);
		hasBidSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidSize(long src) {		
		bidSize = src;
		hasBidSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidSize(String str) {		
		if (str == null ) return;
		if (hasBidSize()) bidSize = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidSize = FixUtils.longValueOf(src, 0, src.length);
		hasBidSize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMinOfferSize() {		
		getMinOfferSize();		
	}		
			
	public long getMinOfferSize() { 		
		if ( hasMinOfferSize()) {		
			if (hasMinOfferSize == FixUtils.TAG_HAS_VALUE) {		
				return minOfferSize; 		
			} else {

				buf.position(hasMinOfferSize);

			minOfferSize = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMinOfferSize = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return minOfferSize;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMinOfferSize() { return hasMinOfferSize != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMinOfferSize(byte[] src) {		
		if (src == null ) return;
		if (hasMinOfferSize()) minOfferSize = FixUtils.TAG_HAS_NO_VALUE;		
		minOfferSize = FixUtils.longValueOf(src, 0, src.length);
		hasMinOfferSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinOfferSize(long src) {		
		minOfferSize = src;
		hasMinOfferSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinOfferSize(String str) {		
		if (str == null ) return;
		if (hasMinOfferSize()) minOfferSize = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		minOfferSize = FixUtils.longValueOf(src, 0, src.length);
		hasMinOfferSize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOfferSize() {		
		getOfferSize();		
	}		
			
	public long getOfferSize() { 		
		if ( hasOfferSize()) {		
			if (hasOfferSize == FixUtils.TAG_HAS_VALUE) {		
				return offerSize; 		
			} else {

				buf.position(hasOfferSize);

			offerSize = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasOfferSize = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return offerSize;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOfferSize() { return hasOfferSize != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOfferSize(byte[] src) {		
		if (src == null ) return;
		if (hasOfferSize()) offerSize = FixUtils.TAG_HAS_NO_VALUE;		
		offerSize = FixUtils.longValueOf(src, 0, src.length);
		hasOfferSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferSize(long src) {		
		offerSize = src;
		hasOfferSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferSize(String str) {		
		if (str == null ) return;
		if (hasOfferSize()) offerSize = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		offerSize = FixUtils.longValueOf(src, 0, src.length);
		hasOfferSize = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackValidUntilTime() {		
		getValidUntilTime();		
	}		
			
	public byte[] getValidUntilTime() { 		
		if ( hasValidUntilTime()) {		
			if (hasValidUntilTime == FixUtils.TAG_HAS_VALUE) {		
				return validUntilTime; 		
			} else {

				buf.position(hasValidUntilTime);

			FixMessage.getTagStringValue(buf, validUntilTime, 0, validUntilTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasValidUntilTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return validUntilTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasValidUntilTime() { return hasValidUntilTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setValidUntilTime(byte[] src) {		
		if (src == null ) return;
		if (hasValidUntilTime()) FixUtils.fillNul(validUntilTime);		
		FixUtils.copy(validUntilTime, src); 		
		hasValidUntilTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setValidUntilTime(String str) {		
		if (str == null ) return;
		if (hasValidUntilTime()) FixUtils.fillNul(validUntilTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(validUntilTime, src); 		
		hasValidUntilTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBidSpotRate() {		
		getBidSpotRate();		
	}		
			
	public long getBidSpotRate() { 		
		if ( hasBidSpotRate()) {		
			if (hasBidSpotRate == FixUtils.TAG_HAS_VALUE) {		
				return bidSpotRate; 		
			} else {

				buf.position(hasBidSpotRate);

			bidSpotRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBidSpotRate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidSpotRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidSpotRate() { return hasBidSpotRate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidSpotRate(byte[] src) {		
		if (src == null ) return;
		if (hasBidSpotRate()) bidSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		bidSpotRate = FixUtils.longValueOf(src, 0, src.length);
		hasBidSpotRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidSpotRate(long src) {		
		bidSpotRate = src;
		hasBidSpotRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidSpotRate(String str) {		
		if (str == null ) return;
		if (hasBidSpotRate()) bidSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidSpotRate = FixUtils.longValueOf(src, 0, src.length);
		hasBidSpotRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOfferSpotRate() {		
		getOfferSpotRate();		
	}		
			
	public long getOfferSpotRate() { 		
		if ( hasOfferSpotRate()) {		
			if (hasOfferSpotRate == FixUtils.TAG_HAS_VALUE) {		
				return offerSpotRate; 		
			} else {

				buf.position(hasOfferSpotRate);

			offerSpotRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasOfferSpotRate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return offerSpotRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOfferSpotRate() { return hasOfferSpotRate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOfferSpotRate(byte[] src) {		
		if (src == null ) return;
		if (hasOfferSpotRate()) offerSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		offerSpotRate = FixUtils.longValueOf(src, 0, src.length);
		hasOfferSpotRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferSpotRate(long src) {		
		offerSpotRate = src;
		hasOfferSpotRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferSpotRate(String str) {		
		if (str == null ) return;
		if (hasOfferSpotRate()) offerSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		offerSpotRate = FixUtils.longValueOf(src, 0, src.length);
		hasOfferSpotRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBidForwardPoints() {		
		getBidForwardPoints();		
	}		
			
	public long getBidForwardPoints() { 		
		if ( hasBidForwardPoints()) {		
			if (hasBidForwardPoints == FixUtils.TAG_HAS_VALUE) {		
				return bidForwardPoints; 		
			} else {

				buf.position(hasBidForwardPoints);

			bidForwardPoints = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBidForwardPoints = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidForwardPoints;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidForwardPoints() { return hasBidForwardPoints != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidForwardPoints(byte[] src) {		
		if (src == null ) return;
		if (hasBidForwardPoints()) bidForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		bidForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasBidForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidForwardPoints(long src) {		
		bidForwardPoints = src;
		hasBidForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidForwardPoints(String str) {		
		if (str == null ) return;
		if (hasBidForwardPoints()) bidForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasBidForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOfferForwardPoints() {		
		getOfferForwardPoints();		
	}		
			
	public long getOfferForwardPoints() { 		
		if ( hasOfferForwardPoints()) {		
			if (hasOfferForwardPoints == FixUtils.TAG_HAS_VALUE) {		
				return offerForwardPoints; 		
			} else {

				buf.position(hasOfferForwardPoints);

			offerForwardPoints = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasOfferForwardPoints = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return offerForwardPoints;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOfferForwardPoints() { return hasOfferForwardPoints != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOfferForwardPoints(byte[] src) {		
		if (src == null ) return;
		if (hasOfferForwardPoints()) offerForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		offerForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasOfferForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferForwardPoints(long src) {		
		offerForwardPoints = src;
		hasOfferForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferForwardPoints(String str) {		
		if (str == null ) return;
		if (hasOfferForwardPoints()) offerForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		offerForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasOfferForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMidPx() {		
		getMidPx();		
	}		
			
	public long getMidPx() { 		
		if ( hasMidPx()) {		
			if (hasMidPx == FixUtils.TAG_HAS_VALUE) {		
				return midPx; 		
			} else {

				buf.position(hasMidPx);

			midPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMidPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return midPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMidPx() { return hasMidPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMidPx(byte[] src) {		
		if (src == null ) return;
		if (hasMidPx()) midPx = FixUtils.TAG_HAS_NO_VALUE;		
		midPx = FixUtils.longValueOf(src, 0, src.length);
		hasMidPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMidPx(long src) {		
		midPx = src;
		hasMidPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMidPx(String str) {		
		if (str == null ) return;
		if (hasMidPx()) midPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		midPx = FixUtils.longValueOf(src, 0, src.length);
		hasMidPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBidYield() {		
		getBidYield();		
	}		
			
	public long getBidYield() { 		
		if ( hasBidYield()) {		
			if (hasBidYield == FixUtils.TAG_HAS_VALUE) {		
				return bidYield; 		
			} else {

				buf.position(hasBidYield);

			bidYield = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBidYield = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidYield;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidYield() { return hasBidYield != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidYield(byte[] src) {		
		if (src == null ) return;
		if (hasBidYield()) bidYield = FixUtils.TAG_HAS_NO_VALUE;		
		bidYield = FixUtils.longValueOf(src, 0, src.length);
		hasBidYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidYield(long src) {		
		bidYield = src;
		hasBidYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidYield(String str) {		
		if (str == null ) return;
		if (hasBidYield()) bidYield = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidYield = FixUtils.longValueOf(src, 0, src.length);
		hasBidYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMidYield() {		
		getMidYield();		
	}		
			
	public long getMidYield() { 		
		if ( hasMidYield()) {		
			if (hasMidYield == FixUtils.TAG_HAS_VALUE) {		
				return midYield; 		
			} else {

				buf.position(hasMidYield);

			midYield = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMidYield = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return midYield;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMidYield() { return hasMidYield != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMidYield(byte[] src) {		
		if (src == null ) return;
		if (hasMidYield()) midYield = FixUtils.TAG_HAS_NO_VALUE;		
		midYield = FixUtils.longValueOf(src, 0, src.length);
		hasMidYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMidYield(long src) {		
		midYield = src;
		hasMidYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMidYield(String str) {		
		if (str == null ) return;
		if (hasMidYield()) midYield = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		midYield = FixUtils.longValueOf(src, 0, src.length);
		hasMidYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOfferYield() {		
		getOfferYield();		
	}		
			
	public long getOfferYield() { 		
		if ( hasOfferYield()) {		
			if (hasOfferYield == FixUtils.TAG_HAS_VALUE) {		
				return offerYield; 		
			} else {

				buf.position(hasOfferYield);

			offerYield = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasOfferYield = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return offerYield;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOfferYield() { return hasOfferYield != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOfferYield(byte[] src) {		
		if (src == null ) return;
		if (hasOfferYield()) offerYield = FixUtils.TAG_HAS_NO_VALUE;		
		offerYield = FixUtils.longValueOf(src, 0, src.length);
		hasOfferYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferYield(long src) {		
		offerYield = src;
		hasOfferYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferYield(String str) {		
		if (str == null ) return;
		if (hasOfferYield()) offerYield = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		offerYield = FixUtils.longValueOf(src, 0, src.length);
		hasOfferYield = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackBidForwardPoints2() {		
		getBidForwardPoints2();		
	}		
			
	public long getBidForwardPoints2() { 		
		if ( hasBidForwardPoints2()) {		
			if (hasBidForwardPoints2 == FixUtils.TAG_HAS_VALUE) {		
				return bidForwardPoints2; 		
			} else {

				buf.position(hasBidForwardPoints2);

			bidForwardPoints2 = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBidForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidForwardPoints2;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidForwardPoints2() { return hasBidForwardPoints2 != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidForwardPoints2(byte[] src) {		
		if (src == null ) return;
		if (hasBidForwardPoints2()) bidForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		bidForwardPoints2 = FixUtils.longValueOf(src, 0, src.length);
		hasBidForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidForwardPoints2(long src) {		
		bidForwardPoints2 = src;
		hasBidForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidForwardPoints2(String str) {		
		if (str == null ) return;
		if (hasBidForwardPoints2()) bidForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidForwardPoints2 = FixUtils.longValueOf(src, 0, src.length);
		hasBidForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOfferForwardPoints2() {		
		getOfferForwardPoints2();		
	}		
			
	public long getOfferForwardPoints2() { 		
		if ( hasOfferForwardPoints2()) {		
			if (hasOfferForwardPoints2 == FixUtils.TAG_HAS_VALUE) {		
				return offerForwardPoints2; 		
			} else {

				buf.position(hasOfferForwardPoints2);

			offerForwardPoints2 = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasOfferForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return offerForwardPoints2;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOfferForwardPoints2() { return hasOfferForwardPoints2 != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOfferForwardPoints2(byte[] src) {		
		if (src == null ) return;
		if (hasOfferForwardPoints2()) offerForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		offerForwardPoints2 = FixUtils.longValueOf(src, 0, src.length);
		hasOfferForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferForwardPoints2(long src) {		
		offerForwardPoints2 = src;
		hasOfferForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferForwardPoints2(String str) {		
		if (str == null ) return;
		if (hasOfferForwardPoints2()) offerForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		offerForwardPoints2 = FixUtils.longValueOf(src, 0, src.length);
		hasOfferForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlCurrBidFxRate() {		
		getSettlCurrBidFxRate();		
	}		
			
	public long getSettlCurrBidFxRate() { 		
		if ( hasSettlCurrBidFxRate()) {		
			if (hasSettlCurrBidFxRate == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrBidFxRate; 		
			} else {

				buf.position(hasSettlCurrBidFxRate);

			settlCurrBidFxRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSettlCurrBidFxRate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlCurrBidFxRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlCurrBidFxRate() { return hasSettlCurrBidFxRate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlCurrBidFxRate(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrBidFxRate()) settlCurrBidFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrBidFxRate = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrBidFxRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrBidFxRate(long src) {		
		settlCurrBidFxRate = src;
		hasSettlCurrBidFxRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrBidFxRate(String str) {		
		if (str == null ) return;
		if (hasSettlCurrBidFxRate()) settlCurrBidFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlCurrBidFxRate = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrBidFxRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlCurrOfferFxRate() {		
		getSettlCurrOfferFxRate();		
	}		
			
	public long getSettlCurrOfferFxRate() { 		
		if ( hasSettlCurrOfferFxRate()) {		
			if (hasSettlCurrOfferFxRate == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrOfferFxRate; 		
			} else {

				buf.position(hasSettlCurrOfferFxRate);

			settlCurrOfferFxRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSettlCurrOfferFxRate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlCurrOfferFxRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlCurrOfferFxRate() { return hasSettlCurrOfferFxRate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlCurrOfferFxRate(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrOfferFxRate()) settlCurrOfferFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrOfferFxRate = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrOfferFxRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrOfferFxRate(long src) {		
		settlCurrOfferFxRate = src;
		hasSettlCurrOfferFxRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrOfferFxRate(String str) {		
		if (str == null ) return;
		if (hasSettlCurrOfferFxRate()) settlCurrOfferFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlCurrOfferFxRate = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrOfferFxRate = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackCommType() {		
		getCommType();		
	}		
			
	public byte getCommType() { 		
		if ( hasCommType()) {		
			if (hasCommType == FixUtils.TAG_HAS_VALUE) {		
				return commType; 		
			} else {

				buf.position(hasCommType);

			commType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (commType != (byte)'3') && (commType != (byte)'2') && (commType != (byte)'1') && (commType != (byte)'6') && (commType != (byte)'5') && (commType != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 13);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasCommType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return commType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasCommType() { return hasCommType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCommType(byte[] src) {		
		if (src == null ) return;
		if (hasCommType()) commType = (byte)' ';		
		commType = src[0];		
		hasCommType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCommType(byte src) {		
		commType = src;
		hasCommType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCommType(String str) {		
		if (str == null ) return;
		if (hasCommType()) commType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		commType = src[0];		
		hasCommType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCommission() {		
		getCommission();		
	}		
			
	public long getCommission() { 		
		if ( hasCommission()) {		
			if (hasCommission == FixUtils.TAG_HAS_VALUE) {		
				return commission; 		
			} else {

				buf.position(hasCommission);

			commission = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCommission = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return commission;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCommission() { return hasCommission != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCommission(byte[] src) {		
		if (src == null ) return;
		if (hasCommission()) commission = FixUtils.TAG_HAS_NO_VALUE;		
		commission = FixUtils.longValueOf(src, 0, src.length);
		hasCommission = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCommission(long src) {		
		commission = src;
		hasCommission = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCommission(String str) {		
		if (str == null ) return;
		if (hasCommission()) commission = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		commission = FixUtils.longValueOf(src, 0, src.length);
		hasCommission = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackExDestination() {		
		getExDestination();		
	}		
			
	public byte[] getExDestination() { 		
		if ( hasExDestination()) {		
			if (hasExDestination == FixUtils.TAG_HAS_VALUE) {		
				return exDestination; 		
			} else {

				buf.position(hasExDestination);

			FixMessage.getTagStringValue(buf, exDestination, 0, exDestination.length, err);
		
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

			exDestinationIDSource = FixMessage.getTagCharValue(buf, err);
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
			
	public void crackQuoteStatus() {		
		getQuoteStatus();		
	}		
			
	public long getQuoteStatus() { 		
		if ( hasQuoteStatus()) {		
			if (hasQuoteStatus == FixUtils.TAG_HAS_VALUE) {		
				return quoteStatus; 		
			} else {

				buf.position(hasQuoteStatus);

			quoteStatus = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQuoteStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuoteStatus() { return hasQuoteStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteStatus(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteStatus()) quoteStatus = FixUtils.TAG_HAS_NO_VALUE;		
		quoteStatus = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteStatus(long src) {		
		quoteStatus = src;
		hasQuoteStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteStatus(String str) {		
		if (str == null ) return;
		if (hasQuoteStatus()) quoteStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quoteStatus = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteRejectReason() {		
		getQuoteRejectReason();		
	}		
			
	public long getQuoteRejectReason() { 		
		if ( hasQuoteRejectReason()) {		
			if (hasQuoteRejectReason == FixUtils.TAG_HAS_VALUE) {		
				return quoteRejectReason; 		
			} else {

				buf.position(hasQuoteRejectReason);

			quoteRejectReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQuoteRejectReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteRejectReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuoteRejectReason() { return hasQuoteRejectReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteRejectReason(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteRejectReason()) quoteRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		quoteRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteRejectReason(long src) {		
		quoteRejectReason = src;
		hasQuoteRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteRejectReason(String str) {		
		if (str == null ) return;
		if (hasQuoteRejectReason()) quoteRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quoteRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteRejectReason = FixUtils.TAG_HAS_VALUE;		
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

					if (hasQuoteStatusReqID()) s += "QuoteStatusReqID(649)= " + new String( FixUtils.trim(getQuoteStatusReqID()) ) + "\n" ; 
		if (hasQuoteReqID()) s += "QuoteReqID(131)= " + new String( FixUtils.trim(getQuoteReqID()) ) + "\n" ; 
		if (hasQuoteID()) s += "QuoteID(117)= " + new String( FixUtils.trim(getQuoteID()) ) + "\n" ; 
		if (hasQuoteMsgID()) s += "QuoteMsgID(1166)= " + new String( FixUtils.trim(getQuoteMsgID()) ) + "\n" ; 
		if (hasQuoteRespID()) s += "QuoteRespID(693)= " + new String( FixUtils.trim(getQuoteRespID()) ) + "\n" ; 
		if (hasQuoteType()) s += "QuoteType(537)= " + getQuoteType() + "\n" ; 
		if (hasQuoteCancelType()) s += "QuoteCancelType(298)= " + getQuoteCancelType() + "\n" ; 
		if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasSettlType()) s += "SettlType(63)= " + new String( FixUtils.trim(getSettlType()) ) + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasSettlDate2()) s += "SettlDate2(193)= " + new String( FixUtils.trim(getSettlDate2()) ) + "\n" ; 
		if (hasOrderQty2()) s += "OrderQty2(192)= " + getOrderQty2() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAcctIDSource()) s += "AcctIDSource(660)= " + getAcctIDSource() + "\n" ; 
		if (hasAccountType()) s += "AccountType(581)= " + getAccountType() + "\n" ; 
		if (hasExpireTime()) s += "ExpireTime(126)= " + new String( FixUtils.trim(getExpireTime()) ) + "\n" ; 
		if (hasPrice()) s += "Price(44)= " + getPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPriceType()) s += "PriceType(423)= " + getPriceType() + "\n" ; 
		if (hasBidPx()) s += "BidPx(132)= " + getBidPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOfferPx()) s += "OfferPx(133)= " + getOfferPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMktBidPx()) s += "MktBidPx(645)= " + getMktBidPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMktOfferPx()) s += "MktOfferPx(646)= " + getMktOfferPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMinBidSize()) s += "MinBidSize(647)= " + getMinBidSize() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasBidSize()) s += "BidSize(134)= " + getBidSize() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMinOfferSize()) s += "MinOfferSize(648)= " + getMinOfferSize() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOfferSize()) s += "OfferSize(135)= " + getOfferSize() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMinQty()) s += "MinQty(110)= " + getMinQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasValidUntilTime()) s += "ValidUntilTime(62)= " + new String( FixUtils.trim(getValidUntilTime()) ) + "\n" ; 
		if (hasBidSpotRate()) s += "BidSpotRate(188)= " + getBidSpotRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOfferSpotRate()) s += "OfferSpotRate(190)= " + getOfferSpotRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasBidForwardPoints()) s += "BidForwardPoints(189)= " + getBidForwardPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOfferForwardPoints()) s += "OfferForwardPoints(191)= " + getOfferForwardPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMidPx()) s += "MidPx(631)= " + getMidPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasBidYield()) s += "BidYield(632)= " + getBidYield() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMidYield()) s += "MidYield(633)= " + getMidYield() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOfferYield()) s += "OfferYield(634)= " + getOfferYield() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasOrdType()) s += "OrdType(40)= " + getOrdType() + "\n" ; 
		if (hasBidForwardPoints2()) s += "BidForwardPoints2(642)= " + getBidForwardPoints2() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOfferForwardPoints2()) s += "OfferForwardPoints2(643)= " + getOfferForwardPoints2() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrBidFxRate()) s += "SettlCurrBidFxRate(656)= " + getSettlCurrBidFxRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrOfferFxRate()) s += "SettlCurrOfferFxRate(657)= " + getSettlCurrOfferFxRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrFxRateCalc()) s += "SettlCurrFxRateCalc(156)= " + getSettlCurrFxRateCalc() + "\n" ; 
		if (hasCommType()) s += "CommType(13)= " + getCommType() + "\n" ; 
		if (hasCommission()) s += "Commission(12)= " + getCommission() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCustOrderCapacity()) s += "CustOrderCapacity(582)= " + getCustOrderCapacity() + "\n" ; 
		if (hasExDestination()) s += "ExDestination(100)= " + new String( FixUtils.trim(getExDestination()) ) + "\n" ; 
		if (hasExDestinationIDSource()) s += "ExDestinationIDSource(1133)= " + getExDestinationIDSource() + "\n" ; 
		if (hasBookingType()) s += "BookingType(775)= " + getBookingType() + "\n" ; 
		if (hasOrderCapacity()) s += "OrderCapacity(528)= " + getOrderCapacity() + "\n" ; 
		if (hasOrderRestrictions()) s += "OrderRestrictions(529)= " + new String( FixUtils.trim(getOrderRestrictions()) ) + "\n" ; 
		if (hasQuoteStatus()) s += "QuoteStatus(297)= " + getQuoteStatus() + "\n" ; 
		if (hasQuoteRejectReason()) s += "QuoteRejectReason(300)= " + getQuoteRejectReason() + "\n" ; 
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
		if (! ( o instanceof FixQuoteStatusReport)) return false;

		FixQuoteStatusReport msg = (FixQuoteStatusReport) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasQuoteStatusReqID() && !msg.hasQuoteStatusReqID()) || (!hasQuoteStatusReqID() && msg.hasQuoteStatusReqID())) return false;
		if (!(!hasQuoteStatusReqID() && !msg.hasQuoteStatusReqID()) && !FixUtils.equals(getQuoteStatusReqID(), msg.getQuoteStatusReqID())) return false;
		if ((hasQuoteReqID() && !msg.hasQuoteReqID()) || (!hasQuoteReqID() && msg.hasQuoteReqID())) return false;
		if (!(!hasQuoteReqID() && !msg.hasQuoteReqID()) && !FixUtils.equals(getQuoteReqID(), msg.getQuoteReqID())) return false;
		if ((hasQuoteID() && !msg.hasQuoteID()) || (!hasQuoteID() && msg.hasQuoteID())) return false;
		if (!(!hasQuoteID() && !msg.hasQuoteID()) && !FixUtils.equals(getQuoteID(), msg.getQuoteID())) return false;
		if ((hasQuoteMsgID() && !msg.hasQuoteMsgID()) || (!hasQuoteMsgID() && msg.hasQuoteMsgID())) return false;
		if (!(!hasQuoteMsgID() && !msg.hasQuoteMsgID()) && !FixUtils.equals(getQuoteMsgID(), msg.getQuoteMsgID())) return false;
		if ((hasQuoteRespID() && !msg.hasQuoteRespID()) || (!hasQuoteRespID() && msg.hasQuoteRespID())) return false;
		if (!(!hasQuoteRespID() && !msg.hasQuoteRespID()) && !FixUtils.equals(getQuoteRespID(), msg.getQuoteRespID())) return false;
		if ((hasQuoteType() && !msg.hasQuoteType()) || (!hasQuoteType() && msg.hasQuoteType())) return false;
		if (!(!hasQuoteType() && !msg.hasQuoteType()) && !(getQuoteType()==msg.getQuoteType())) return false;
		if ((hasQuoteCancelType() && !msg.hasQuoteCancelType()) || (!hasQuoteCancelType() && msg.hasQuoteCancelType())) return false;
		if (!(!hasQuoteCancelType() && !msg.hasQuoteCancelType()) && !(getQuoteCancelType()==msg.getQuoteCancelType())) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasSettlType() && !msg.hasSettlType()) || (!hasSettlType() && msg.hasSettlType())) return false;
		if (!(!hasSettlType() && !msg.hasSettlType()) && !FixUtils.equals(getSettlType(), msg.getSettlType())) return false;
		if ((hasSettlDate() && !msg.hasSettlDate()) || (!hasSettlDate() && msg.hasSettlDate())) return false;
		if ((hasSettlDate2() && !msg.hasSettlDate2()) || (!hasSettlDate2() && msg.hasSettlDate2())) return false;
		if ((hasOrderQty2() && !msg.hasOrderQty2()) || (!hasOrderQty2() && msg.hasOrderQty2())) return false;
		if (!(!hasOrderQty2() && !msg.hasOrderQty2()) && !(getOrderQty2()==msg.getOrderQty2())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasAccount() && !msg.hasAccount()) || (!hasAccount() && msg.hasAccount())) return false;
		if (!(!hasAccount() && !msg.hasAccount()) && !FixUtils.equals(getAccount(), msg.getAccount())) return false;
		if ((hasAcctIDSource() && !msg.hasAcctIDSource()) || (!hasAcctIDSource() && msg.hasAcctIDSource())) return false;
		if (!(!hasAcctIDSource() && !msg.hasAcctIDSource()) && !(getAcctIDSource()==msg.getAcctIDSource())) return false;
		if ((hasAccountType() && !msg.hasAccountType()) || (!hasAccountType() && msg.hasAccountType())) return false;
		if (!(!hasAccountType() && !msg.hasAccountType()) && !(getAccountType()==msg.getAccountType())) return false;
		if ((hasExpireTime() && !msg.hasExpireTime()) || (!hasExpireTime() && msg.hasExpireTime())) return false;
		if ((hasPrice() && !msg.hasPrice()) || (!hasPrice() && msg.hasPrice())) return false;
		if (!(!hasPrice() && !msg.hasPrice()) && !(getPrice()==msg.getPrice())) return false;
		if ((hasPriceType() && !msg.hasPriceType()) || (!hasPriceType() && msg.hasPriceType())) return false;
		if (!(!hasPriceType() && !msg.hasPriceType()) && !(getPriceType()==msg.getPriceType())) return false;
		if ((hasBidPx() && !msg.hasBidPx()) || (!hasBidPx() && msg.hasBidPx())) return false;
		if (!(!hasBidPx() && !msg.hasBidPx()) && !(getBidPx()==msg.getBidPx())) return false;
		if ((hasOfferPx() && !msg.hasOfferPx()) || (!hasOfferPx() && msg.hasOfferPx())) return false;
		if (!(!hasOfferPx() && !msg.hasOfferPx()) && !(getOfferPx()==msg.getOfferPx())) return false;
		if ((hasMktBidPx() && !msg.hasMktBidPx()) || (!hasMktBidPx() && msg.hasMktBidPx())) return false;
		if (!(!hasMktBidPx() && !msg.hasMktBidPx()) && !(getMktBidPx()==msg.getMktBidPx())) return false;
		if ((hasMktOfferPx() && !msg.hasMktOfferPx()) || (!hasMktOfferPx() && msg.hasMktOfferPx())) return false;
		if (!(!hasMktOfferPx() && !msg.hasMktOfferPx()) && !(getMktOfferPx()==msg.getMktOfferPx())) return false;
		if ((hasMinBidSize() && !msg.hasMinBidSize()) || (!hasMinBidSize() && msg.hasMinBidSize())) return false;
		if (!(!hasMinBidSize() && !msg.hasMinBidSize()) && !(getMinBidSize()==msg.getMinBidSize())) return false;
		if ((hasBidSize() && !msg.hasBidSize()) || (!hasBidSize() && msg.hasBidSize())) return false;
		if (!(!hasBidSize() && !msg.hasBidSize()) && !(getBidSize()==msg.getBidSize())) return false;
		if ((hasMinOfferSize() && !msg.hasMinOfferSize()) || (!hasMinOfferSize() && msg.hasMinOfferSize())) return false;
		if (!(!hasMinOfferSize() && !msg.hasMinOfferSize()) && !(getMinOfferSize()==msg.getMinOfferSize())) return false;
		if ((hasOfferSize() && !msg.hasOfferSize()) || (!hasOfferSize() && msg.hasOfferSize())) return false;
		if (!(!hasOfferSize() && !msg.hasOfferSize()) && !(getOfferSize()==msg.getOfferSize())) return false;
		if ((hasMinQty() && !msg.hasMinQty()) || (!hasMinQty() && msg.hasMinQty())) return false;
		if (!(!hasMinQty() && !msg.hasMinQty()) && !(getMinQty()==msg.getMinQty())) return false;
		if ((hasValidUntilTime() && !msg.hasValidUntilTime()) || (!hasValidUntilTime() && msg.hasValidUntilTime())) return false;
		if ((hasBidSpotRate() && !msg.hasBidSpotRate()) || (!hasBidSpotRate() && msg.hasBidSpotRate())) return false;
		if (!(!hasBidSpotRate() && !msg.hasBidSpotRate()) && !(getBidSpotRate()==msg.getBidSpotRate())) return false;
		if ((hasOfferSpotRate() && !msg.hasOfferSpotRate()) || (!hasOfferSpotRate() && msg.hasOfferSpotRate())) return false;
		if (!(!hasOfferSpotRate() && !msg.hasOfferSpotRate()) && !(getOfferSpotRate()==msg.getOfferSpotRate())) return false;
		if ((hasBidForwardPoints() && !msg.hasBidForwardPoints()) || (!hasBidForwardPoints() && msg.hasBidForwardPoints())) return false;
		if (!(!hasBidForwardPoints() && !msg.hasBidForwardPoints()) && !(getBidForwardPoints()==msg.getBidForwardPoints())) return false;
		if ((hasOfferForwardPoints() && !msg.hasOfferForwardPoints()) || (!hasOfferForwardPoints() && msg.hasOfferForwardPoints())) return false;
		if (!(!hasOfferForwardPoints() && !msg.hasOfferForwardPoints()) && !(getOfferForwardPoints()==msg.getOfferForwardPoints())) return false;
		if ((hasMidPx() && !msg.hasMidPx()) || (!hasMidPx() && msg.hasMidPx())) return false;
		if (!(!hasMidPx() && !msg.hasMidPx()) && !(getMidPx()==msg.getMidPx())) return false;
		if ((hasBidYield() && !msg.hasBidYield()) || (!hasBidYield() && msg.hasBidYield())) return false;
		if (!(!hasBidYield() && !msg.hasBidYield()) && !(getBidYield()==msg.getBidYield())) return false;
		if ((hasMidYield() && !msg.hasMidYield()) || (!hasMidYield() && msg.hasMidYield())) return false;
		if (!(!hasMidYield() && !msg.hasMidYield()) && !(getMidYield()==msg.getMidYield())) return false;
		if ((hasOfferYield() && !msg.hasOfferYield()) || (!hasOfferYield() && msg.hasOfferYield())) return false;
		if (!(!hasOfferYield() && !msg.hasOfferYield()) && !(getOfferYield()==msg.getOfferYield())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasOrdType() && !msg.hasOrdType()) || (!hasOrdType() && msg.hasOrdType())) return false;
		if (!(!hasOrdType() && !msg.hasOrdType()) && !(getOrdType()==msg.getOrdType())) return false;
		if ((hasBidForwardPoints2() && !msg.hasBidForwardPoints2()) || (!hasBidForwardPoints2() && msg.hasBidForwardPoints2())) return false;
		if (!(!hasBidForwardPoints2() && !msg.hasBidForwardPoints2()) && !(getBidForwardPoints2()==msg.getBidForwardPoints2())) return false;
		if ((hasOfferForwardPoints2() && !msg.hasOfferForwardPoints2()) || (!hasOfferForwardPoints2() && msg.hasOfferForwardPoints2())) return false;
		if (!(!hasOfferForwardPoints2() && !msg.hasOfferForwardPoints2()) && !(getOfferForwardPoints2()==msg.getOfferForwardPoints2())) return false;
		if ((hasSettlCurrBidFxRate() && !msg.hasSettlCurrBidFxRate()) || (!hasSettlCurrBidFxRate() && msg.hasSettlCurrBidFxRate())) return false;
		if (!(!hasSettlCurrBidFxRate() && !msg.hasSettlCurrBidFxRate()) && !(getSettlCurrBidFxRate()==msg.getSettlCurrBidFxRate())) return false;
		if ((hasSettlCurrOfferFxRate() && !msg.hasSettlCurrOfferFxRate()) || (!hasSettlCurrOfferFxRate() && msg.hasSettlCurrOfferFxRate())) return false;
		if (!(!hasSettlCurrOfferFxRate() && !msg.hasSettlCurrOfferFxRate()) && !(getSettlCurrOfferFxRate()==msg.getSettlCurrOfferFxRate())) return false;
		if ((hasSettlCurrFxRateCalc() && !msg.hasSettlCurrFxRateCalc()) || (!hasSettlCurrFxRateCalc() && msg.hasSettlCurrFxRateCalc())) return false;
		if (!(!hasSettlCurrFxRateCalc() && !msg.hasSettlCurrFxRateCalc()) && !(getSettlCurrFxRateCalc()==msg.getSettlCurrFxRateCalc())) return false;
		if ((hasCommType() && !msg.hasCommType()) || (!hasCommType() && msg.hasCommType())) return false;
		if (!(!hasCommType() && !msg.hasCommType()) && !(getCommType()==msg.getCommType())) return false;
		if ((hasCommission() && !msg.hasCommission()) || (!hasCommission() && msg.hasCommission())) return false;
		if (!(!hasCommission() && !msg.hasCommission()) && !(getCommission()==msg.getCommission())) return false;
		if ((hasCustOrderCapacity() && !msg.hasCustOrderCapacity()) || (!hasCustOrderCapacity() && msg.hasCustOrderCapacity())) return false;
		if (!(!hasCustOrderCapacity() && !msg.hasCustOrderCapacity()) && !(getCustOrderCapacity()==msg.getCustOrderCapacity())) return false;
		if ((hasExDestination() && !msg.hasExDestination()) || (!hasExDestination() && msg.hasExDestination())) return false;
		if (!(!hasExDestination() && !msg.hasExDestination()) && !FixUtils.equals(getExDestination(), msg.getExDestination())) return false;
		if ((hasExDestinationIDSource() && !msg.hasExDestinationIDSource()) || (!hasExDestinationIDSource() && msg.hasExDestinationIDSource())) return false;
		if (!(!hasExDestinationIDSource() && !msg.hasExDestinationIDSource()) && !(getExDestinationIDSource()==msg.getExDestinationIDSource())) return false;
		if ((hasBookingType() && !msg.hasBookingType()) || (!hasBookingType() && msg.hasBookingType())) return false;
		if (!(!hasBookingType() && !msg.hasBookingType()) && !(getBookingType()==msg.getBookingType())) return false;
		if ((hasOrderCapacity() && !msg.hasOrderCapacity()) || (!hasOrderCapacity() && msg.hasOrderCapacity())) return false;
		if (!(!hasOrderCapacity() && !msg.hasOrderCapacity()) && !(getOrderCapacity()==msg.getOrderCapacity())) return false;
		if ((hasOrderRestrictions() && !msg.hasOrderRestrictions()) || (!hasOrderRestrictions() && msg.hasOrderRestrictions())) return false;
		if (!(!hasOrderRestrictions() && !msg.hasOrderRestrictions()) && !FixUtils.equals(getOrderRestrictions(), msg.getOrderRestrictions())) return false;
		if ((hasQuoteStatus() && !msg.hasQuoteStatus()) || (!hasQuoteStatus() && msg.hasQuoteStatus())) return false;
		if (!(!hasQuoteStatus() && !msg.hasQuoteStatus()) && !(getQuoteStatus()==msg.getQuoteStatus())) return false;
		if ((hasQuoteRejectReason() && !msg.hasQuoteRejectReason()) || (!hasQuoteRejectReason() && msg.hasQuoteRejectReason())) return false;
		if (!(!hasQuoteRejectReason() && !msg.hasQuoteRejectReason()) && !(getQuoteRejectReason()==msg.getQuoteRejectReason())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixQuoteStatusReport clone () {
		FixQuoteStatusReport out = new FixQuoteStatusReport();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixQuoteStatusReport clone ( FixQuoteStatusReport out ) {
		if ( hasQuoteStatusReqID())
			out.setQuoteStatusReqID(getQuoteStatusReqID());
		if ( hasQuoteReqID())
			out.setQuoteReqID(getQuoteReqID());
		if ( hasQuoteID())
			out.setQuoteID(getQuoteID());
		if ( hasQuoteMsgID())
			out.setQuoteMsgID(getQuoteMsgID());
		if ( hasQuoteRespID())
			out.setQuoteRespID(getQuoteRespID());
		if ( hasQuoteType())
			out.setQuoteType(getQuoteType());
		if ( hasQuoteCancelType())
			out.setQuoteCancelType(getQuoteCancelType());
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasSettlType())
			out.setSettlType(getSettlType());
		if ( hasSettlDate())
			out.setSettlDate(getSettlDate());
		if ( hasSettlDate2())
			out.setSettlDate2(getSettlDate2());
		if ( hasOrderQty2())
			out.setOrderQty2(getOrderQty2());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasAccount())
			out.setAccount(getAccount());
		if ( hasAcctIDSource())
			out.setAcctIDSource(getAcctIDSource());
		if ( hasAccountType())
			out.setAccountType(getAccountType());
		if ( hasExpireTime())
			out.setExpireTime(getExpireTime());
		if ( hasPrice())
			out.setPrice(getPrice());
		if ( hasPriceType())
			out.setPriceType(getPriceType());
		if ( hasBidPx())
			out.setBidPx(getBidPx());
		if ( hasOfferPx())
			out.setOfferPx(getOfferPx());
		if ( hasMktBidPx())
			out.setMktBidPx(getMktBidPx());
		if ( hasMktOfferPx())
			out.setMktOfferPx(getMktOfferPx());
		if ( hasMinBidSize())
			out.setMinBidSize(getMinBidSize());
		if ( hasBidSize())
			out.setBidSize(getBidSize());
		if ( hasMinOfferSize())
			out.setMinOfferSize(getMinOfferSize());
		if ( hasOfferSize())
			out.setOfferSize(getOfferSize());
		if ( hasMinQty())
			out.setMinQty(getMinQty());
		if ( hasValidUntilTime())
			out.setValidUntilTime(getValidUntilTime());
		if ( hasBidSpotRate())
			out.setBidSpotRate(getBidSpotRate());
		if ( hasOfferSpotRate())
			out.setOfferSpotRate(getOfferSpotRate());
		if ( hasBidForwardPoints())
			out.setBidForwardPoints(getBidForwardPoints());
		if ( hasOfferForwardPoints())
			out.setOfferForwardPoints(getOfferForwardPoints());
		if ( hasMidPx())
			out.setMidPx(getMidPx());
		if ( hasBidYield())
			out.setBidYield(getBidYield());
		if ( hasMidYield())
			out.setMidYield(getMidYield());
		if ( hasOfferYield())
			out.setOfferYield(getOfferYield());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasOrdType())
			out.setOrdType(getOrdType());
		if ( hasBidForwardPoints2())
			out.setBidForwardPoints2(getBidForwardPoints2());
		if ( hasOfferForwardPoints2())
			out.setOfferForwardPoints2(getOfferForwardPoints2());
		if ( hasSettlCurrBidFxRate())
			out.setSettlCurrBidFxRate(getSettlCurrBidFxRate());
		if ( hasSettlCurrOfferFxRate())
			out.setSettlCurrOfferFxRate(getSettlCurrOfferFxRate());
		if ( hasSettlCurrFxRateCalc())
			out.setSettlCurrFxRateCalc(getSettlCurrFxRateCalc());
		if ( hasCommType())
			out.setCommType(getCommType());
		if ( hasCommission())
			out.setCommission(getCommission());
		if ( hasCustOrderCapacity())
			out.setCustOrderCapacity(getCustOrderCapacity());
		if ( hasExDestination())
			out.setExDestination(getExDestination());
		if ( hasExDestinationIDSource())
			out.setExDestinationIDSource(getExDestinationIDSource());
		if ( hasBookingType())
			out.setBookingType(getBookingType());
		if ( hasOrderCapacity())
			out.setOrderCapacity(getOrderCapacity());
		if ( hasOrderRestrictions())
			out.setOrderRestrictions(getOrderRestrictions());
		if ( hasQuoteStatus())
			out.setQuoteStatus(getQuoteStatus());
		if ( hasQuoteRejectReason())
			out.setQuoteRejectReason(getQuoteRejectReason());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixTargetParties fixTargetParties : targetParties) {
			if (!fixTargetParties.hasGroup()) continue;
			out.targetParties[count] = fixTargetParties.clone( out.targetParties[count] );
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
		if (orderQtyData.hasGroup())
			out.orderQtyData = orderQtyData.clone( out.orderQtyData);
		count = 0;
		for (FixStipulations fixStipulations : stipulations) {
			if (!fixStipulations.hasGroup()) continue;
			out.stipulations[count] = fixStipulations.clone( out.stipulations[count] );
			count++;
		}
		count = 0;
		for (FixLegQuotStatGrp fixLegQuotStatGrp : legQuotStatGrp) {
			if (!fixLegQuotStatGrp.hasGroup()) continue;
			out.legQuotStatGrp[count] = fixLegQuotStatGrp.clone( out.legQuotStatGrp[count] );
			count++;
		}
		count = 0;
		for (FixQuotQualGrp fixQuotQualGrp : quotQualGrp) {
			if (!fixQuotQualGrp.hasGroup()) continue;
			out.quotQualGrp[count] = fixQuotQualGrp.clone( out.quotQualGrp[count] );
			count++;
		}
		if (spreadOrBenchmarkCurveData.hasGroup())
			out.spreadOrBenchmarkCurveData = spreadOrBenchmarkCurveData.clone( out.spreadOrBenchmarkCurveData);
		if (yieldData.hasGroup())
			out.yieldData = yieldData.clone( out.yieldData);
		return out;
	}

}
