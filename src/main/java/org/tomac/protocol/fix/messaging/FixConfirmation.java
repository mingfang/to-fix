package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixConfirmation extends FixInMessage {
	private short hasConfirmID;
	byte[] confirmID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasConfirmRefID;
	byte[] confirmRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasConfirmReqID;
	byte[] confirmReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasConfirmTransType;
	long confirmTransType = 0;		
	private short hasConfirmType;
	long confirmType = 0;		
	private short hasCopyMsgIndicator;
		boolean copyMsgIndicator = false;		
	private short hasLegalConfirm;
		boolean legalConfirm = false;		
	private short hasConfirmStatus;
	long confirmStatus = 0;		
	private short hasAllocID;
	byte[] allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryAllocID;
	byte[] secondaryAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasIndividualAllocID;
	byte[] individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTradeDate;
	byte[] tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocQty;
	long allocQty = 0;		
	private short hasQtyType;
	long qtyType = 0;		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasLastMkt;
	byte[] lastMkt = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocAccount;
	byte[] allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocAcctIDSource;
	long allocAcctIDSource = 0;		
	private short hasAllocAccountType;
	long allocAccountType = 0;		
	private short hasAvgPx;
	long avgPx = 0;		
	private short hasAvgPxPrecision;
	long avgPxPrecision = 0;		
	private short hasPriceType;
	long priceType = 0;		
	private short hasAvgParPx;
	long avgParPx = 0;		
	private short hasReportedPx;
	long reportedPx = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasProcessCode;
	byte processCode = (byte)' ';		
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
	private short hasConcession;
	long concession = 0;		
	private short hasTotalTakedown;
	long totalTakedown = 0;		
	private short hasNetMoney;
	long netMoney = 0;		
	private short hasMaturityNetMoney;
	long maturityNetMoney = 0;		
	private short hasSettlCurrAmt;
	long settlCurrAmt = 0;		
	private short hasSettlCurrency;
	byte[] settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasSettlCurrFxRate;
	long settlCurrFxRate = 0;		
	private short hasSettlCurrFxRateCalc;
	byte settlCurrFxRateCalc = (byte)' ';		
	private short hasSettlType;
	byte[] settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlDate;
	byte[] settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSharedCommission;
	long sharedCommission = 0;		
	public FixParties[] parties;
	public FixOrdAllocGrp[] ordAllocGrp;
	public FixTrdRegTimestamps[] trdRegTimestamps;
	public FixInstrument instrument;
	public FixInstrumentExtension instrumentExtension;
	public FixFinancingDetails financingDetails;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	public FixYieldData yieldData;
	public FixCpctyConfGrp[] cpctyConfGrp;
	public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	public FixSettlInstructionsData settlInstructionsData;
	public FixCommissionData commissionData;
	public FixStipulations[] stipulations;
	public FixMiscFeesGrp[] miscFeesGrp;
	
	public FixConfirmation() {
		super(FixMessageInfo.MessageTypes.CONFIRMATION);


		hasConfirmID = FixUtils.TAG_HAS_NO_VALUE;		
		confirmID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasConfirmRefID = FixUtils.TAG_HAS_NO_VALUE;		
		confirmRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasConfirmReqID = FixUtils.TAG_HAS_NO_VALUE;		
		confirmReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasConfirmTransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasConfirmType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCopyMsgIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegalConfirm = FixUtils.TAG_HAS_NO_VALUE;		
		hasConfirmStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasQtyType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasLastMkt = FixUtils.TAG_HAS_NO_VALUE;		
		lastMkt = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocAccount = FixUtils.TAG_HAS_NO_VALUE;		
		allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		hasAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasAvgPxPrecision = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasAvgParPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasReportedPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasProcessCode = FixUtils.TAG_HAS_NO_VALUE;		
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
		hasConcession = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotalTakedown = FixUtils.TAG_HAS_NO_VALUE;		
		hasNetMoney = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaturityNetMoney = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasSettlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSharedCommission = FixUtils.TAG_HAS_NO_VALUE;		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		ordAllocGrp = new FixOrdAllocGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) ordAllocGrp[i] = new FixOrdAllocGrp();
		trdRegTimestamps = new FixTrdRegTimestamps[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdRegTimestamps[i] = new FixTrdRegTimestamps();
		instrument = new FixInstrument();
		instrumentExtension = new FixInstrumentExtension();
		financingDetails = new FixFinancingDetails();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		yieldData = new FixYieldData();
		cpctyConfGrp = new FixCpctyConfGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) cpctyConfGrp[i] = new FixCpctyConfGrp();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		settlInstructionsData = new FixSettlInstructionsData();
		commissionData = new FixCommissionData();
		stipulations = new FixStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) stipulations[i] = new FixStipulations();
		miscFeesGrp = new FixMiscFeesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) miscFeesGrp[i] = new FixMiscFeesGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.CONFIRMID_INT:		
            		hasConfirmID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CONFIRMREFID_INT:		
            		hasConfirmRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CONFIRMREQID_INT:		
            		hasConfirmReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CONFIRMTRANSTYPE_INT:		
            		hasConfirmTransType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CONFIRMTYPE_INT:		
            		hasConfirmType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.COPYMSGINDICATOR_INT:		
            		hasCopyMsgIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LEGALCONFIRM_INT:		
            		hasLegalConfirm = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CONFIRMSTATUS_INT:		
            		hasConfirmStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCID_INT:		
            		hasAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYALLOCID_INT:		
            		hasSecondaryAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.INDIVIDUALALLOCID_INT:		
            		hasIndividualAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEDATE_INT:		
            		hasTradeDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCQTY_INT:		
            		hasAllocQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QTYTYPE_INT:		
            		hasQtyType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTMKT_INT:		
            		hasLastMkt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCACCOUNT_INT:		
            		hasAllocAccount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCACCTIDSOURCE_INT:		
            		hasAllocAcctIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCACCOUNTTYPE_INT:		
            		hasAllocAccountType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AVGPX_INT:		
            		hasAvgPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AVGPXPRECISION_INT:		
            		hasAvgPxPrecision = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRICETYPE_INT:		
            		hasPriceType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AVGPARPX_INT:		
            		hasAvgParPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REPORTEDPX_INT:		
            		hasReportedPx = (short) buf.position();		
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
            	case FixTags.PROCESSCODE_INT:		
            		hasProcessCode = (short) buf.position();		
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
            	case FixTags.MATURITYNETMONEY_INT:		
            		hasMaturityNetMoney = (short) buf.position();		
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
            	case FixTags.SETTLTYPE_INT:		
            		hasSettlType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLDATE_INT:		
            		hasSettlDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SHAREDCOMMISSION_INT:		
            		hasSharedCommission = (short) buf.position();		
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
        			} else if ( yieldData.isKeyTag(tag)) {
        				tag = yieldData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOCAPACITIES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !cpctyConfGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = cpctyConfGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( spreadOrBenchmarkCurveData.isKeyTag(tag)) {
        				tag = spreadOrBenchmarkCurveData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( settlInstructionsData.isKeyTag(tag)) {
        				tag = settlInstructionsData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( commissionData.isKeyTag(tag)) {
        				tag = commissionData.setBuffer( tag, buf, err);		
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

		if (!hasConfirmID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ConfirmID missing", FixTags.CONFIRMID_INT, FixMessageInfo.MessageTypes.CONFIRMATION);
			return false;
		}
		if (!hasConfirmTransType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ConfirmTransType missing", FixTags.CONFIRMTRANSTYPE_INT, FixMessageInfo.MessageTypes.CONFIRMATION);
			return false;
		}
		if (!hasConfirmType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ConfirmType missing", FixTags.CONFIRMTYPE_INT, FixMessageInfo.MessageTypes.CONFIRMATION);
			return false;
		}
		if (!hasConfirmStatus()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ConfirmStatus missing", FixTags.CONFIRMSTATUS_INT, FixMessageInfo.MessageTypes.CONFIRMATION);
			return false;
		}
		if (!hasTransactTime()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TransactTime missing", FixTags.TRANSACTTIME_INT, FixMessageInfo.MessageTypes.CONFIRMATION);
			return false;
		}
		if (!hasTradeDate()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TradeDate missing", FixTags.TRADEDATE_INT, FixMessageInfo.MessageTypes.CONFIRMATION);
			return false;
		}
		if (!hasAllocQty()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag AllocQty missing", FixTags.ALLOCQTY_INT, FixMessageInfo.MessageTypes.CONFIRMATION);
			return false;
		}
		if (!hasSide()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Side missing", FixTags.SIDE_INT, FixMessageInfo.MessageTypes.CONFIRMATION);
			return false;
		}
		if (!hasAllocAccount()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag AllocAccount missing", FixTags.ALLOCACCOUNT_INT, FixMessageInfo.MessageTypes.CONFIRMATION);
			return false;
		}
		if (!hasAvgPx()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag AvgPx missing", FixTags.AVGPX_INT, FixMessageInfo.MessageTypes.CONFIRMATION);
			return false;
		}
		if (!hasGrossTradeAmt()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag GrossTradeAmt missing", FixTags.GROSSTRADEAMT_INT, FixMessageInfo.MessageTypes.CONFIRMATION);
			return false;
		}
		if (!hasNetMoney()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag NetMoney missing", FixTags.NETMONEY_INT, FixMessageInfo.MessageTypes.CONFIRMATION);
			return false;
		}
		if (instrument.isRequired) instrument.hasRequiredTags(err); if (err.hasError()) return false;
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (cpctyConfGrp[i].hasGroup()) cpctyConfGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
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
		if (hasConfirmID()) {		
			out.put(FixTags.CONFIRMID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,confirmID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasConfirmRefID()) {		
			out.put(FixTags.CONFIRMREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,confirmRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasConfirmReqID()) {		
			out.put(FixTags.CONFIRMREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,confirmReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasConfirmTransType()) {		
			out.put(FixTags.CONFIRMTRANSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)confirmTransType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasConfirmType()) {		
			out.put(FixTags.CONFIRMTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)confirmType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCopyMsgIndicator()) {		
			out.put(FixTags.COPYMSGINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(copyMsgIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLegalConfirm()) {		
			out.put(FixTags.LEGALCONFIRM);		
		
			out.put((byte) '=');		
		
			out.put(legalConfirm?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasConfirmStatus()) {		
			out.put(FixTags.CONFIRMSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)confirmStatus);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocID()) {		
			out.put(FixTags.ALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryAllocID()) {		
			out.put(FixTags.SECONDARYALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryAllocID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasIndividualAllocID()) {		
			out.put(FixTags.INDIVIDUALALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,individualAllocID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeDate()) {		
			out.put(FixTags.TRADEDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocQty()) {		
			out.put(FixTags.ALLOCQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQtyType()) {		
			out.put(FixTags.QTYTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)qtyType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSide()) {		
			out.put(FixTags.SIDE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastMkt()) {		
			out.put(FixTags.LASTMKT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,lastMkt); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocAccount()) {		
			out.put(FixTags.ALLOCACCOUNT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocAccount); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocAcctIDSource()) {		
			out.put(FixTags.ALLOCACCTIDSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocAcctIDSource);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocAccountType()) {		
			out.put(FixTags.ALLOCACCOUNTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocAccountType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAvgPx()) {		
			out.put(FixTags.AVGPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)avgPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAvgPxPrecision()) {		
			out.put(FixTags.AVGPXPRECISION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)avgPxPrecision);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriceType()) {		
			out.put(FixTags.PRICETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priceType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAvgParPx()) {		
			out.put(FixTags.AVGPARPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)avgParPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasReportedPx()) {		
			out.put(FixTags.REPORTEDPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)reportedPx);
		
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
		if (hasProcessCode()) {		
			out.put(FixTags.PROCESSCODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,processCode); 		
		
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
		if (hasMaturityNetMoney()) {		
			out.put(FixTags.MATURITYNETMONEY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)maturityNetMoney);
		
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
		if (hasSharedCommission()) {		
			out.put(FixTags.SHAREDCOMMISSION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)sharedCommission);
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(ordAllocGrp)>0) {
			out.put(FixTags.NOORDERS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(ordAllocGrp));

			out.put(FixUtils.SOH);

		}
		for (FixOrdAllocGrp fixOrdAllocGrp : ordAllocGrp) if (fixOrdAllocGrp.hasGroup()) fixOrdAllocGrp.encode(out);
		if (FixUtils.getNoInGroup(trdRegTimestamps)>0) {
			out.put(FixTags.NOTRDREGTIMESTAMPS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdRegTimestamps));

			out.put(FixUtils.SOH);

		}
		for (FixTrdRegTimestamps fixTrdRegTimestamps : trdRegTimestamps) if (fixTrdRegTimestamps.hasGroup()) fixTrdRegTimestamps.encode(out);
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
		yieldData.encode(out);
		if (FixUtils.getNoInGroup(cpctyConfGrp)>0) {
			out.put(FixTags.NOCAPACITIES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(cpctyConfGrp));

			out.put(FixUtils.SOH);

		}
		for (FixCpctyConfGrp fixCpctyConfGrp : cpctyConfGrp) if (fixCpctyConfGrp.hasGroup()) fixCpctyConfGrp.encode(out);
		spreadOrBenchmarkCurveData.encode(out);
		settlInstructionsData.encode(out);
		commissionData.encode(out);
		if (FixUtils.getNoInGroup(stipulations)>0) {
			out.put(FixTags.NOSTIPULATIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(stipulations));

			out.put(FixUtils.SOH);

		}
		for (FixStipulations fixStipulations : stipulations) if (fixStipulations.hasGroup()) fixStipulations.encode(out);
		if (FixUtils.getNoInGroup(miscFeesGrp)>0) {
			out.put(FixTags.NOMISCFEES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(miscFeesGrp));

			out.put(FixUtils.SOH);

		}
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) if (fixMiscFeesGrp.hasGroup()) fixMiscFeesGrp.encode(out);
		
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
		
		if (hasConfirmID()) {		
			FixUtils.put(out,confirmID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasConfirmRefID()) {		
			FixUtils.put(out,confirmRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasConfirmReqID()) {		
			FixUtils.put(out,confirmReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasConfirmTransType()) {		
			FixUtils.put(out, (long)confirmTransType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasConfirmType()) {		
			FixUtils.put(out, (long)confirmType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCopyMsgIndicator()) {		
			out.put(copyMsgIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegalConfirm()) {		
			out.put(legalConfirm?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasConfirmStatus()) {		
			FixUtils.put(out, (long)confirmStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocID()) {		
			FixUtils.put(out,allocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryAllocID()) {		
			FixUtils.put(out,secondaryAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIndividualAllocID()) {		
			FixUtils.put(out,individualAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeDate()) {		
			FixUtils.put(out,tradeDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocQty()) {		
			FixUtils.put(out, (long)allocQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQtyType()) {		
			FixUtils.put(out, (long)qtyType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastMkt()) {		
			FixUtils.put(out,lastMkt); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocAccount()) {		
			FixUtils.put(out,allocAccount); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocAcctIDSource()) {		
			FixUtils.put(out, (long)allocAcctIDSource);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocAccountType()) {		
			FixUtils.put(out, (long)allocAccountType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAvgPx()) {		
			FixUtils.put(out, (long)avgPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAvgPxPrecision()) {		
			FixUtils.put(out, (long)avgPxPrecision);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceType()) {		
			FixUtils.put(out, (long)priceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAvgParPx()) {		
			FixUtils.put(out, (long)avgParPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasReportedPx()) {		
			FixUtils.put(out, (long)reportedPx);
		
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
		
		if (hasProcessCode()) {		
			FixUtils.put(out,processCode); 		
		
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
		
		if (hasMaturityNetMoney()) {		
			FixUtils.put(out, (long)maturityNetMoney);
		
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
		
		if (hasSettlType()) {		
			FixUtils.put(out,settlType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlDate()) {		
			FixUtils.put(out,settlDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSharedCommission()) {		
			FixUtils.put(out, (long)sharedCommission);
		
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
			
	public void crackConfirmID() {		
		getConfirmID();		
	}		
			
	public byte[] getConfirmID() { 		
		if ( hasConfirmID()) {		
			if (hasConfirmID == FixUtils.TAG_HAS_VALUE) {		
				return confirmID; 		
			} else {

				buf.position(hasConfirmID);

			FixMessage.getTagStringValue(buf, confirmID, 0, confirmID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasConfirmID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return confirmID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasConfirmID() { return hasConfirmID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setConfirmID(byte[] src) {		
		if (src == null ) return;
		if (hasConfirmID()) FixUtils.fillNul(confirmID);		
		FixUtils.copy(confirmID, src); 		
		hasConfirmID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConfirmID(String str) {		
		if (str == null ) return;
		if (hasConfirmID()) FixUtils.fillNul(confirmID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(confirmID, src); 		
		hasConfirmID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackConfirmRefID() {		
		getConfirmRefID();		
	}		
			
	public byte[] getConfirmRefID() { 		
		if ( hasConfirmRefID()) {		
			if (hasConfirmRefID == FixUtils.TAG_HAS_VALUE) {		
				return confirmRefID; 		
			} else {

				buf.position(hasConfirmRefID);

			FixMessage.getTagStringValue(buf, confirmRefID, 0, confirmRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasConfirmRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return confirmRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasConfirmRefID() { return hasConfirmRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setConfirmRefID(byte[] src) {		
		if (src == null ) return;
		if (hasConfirmRefID()) FixUtils.fillNul(confirmRefID);		
		FixUtils.copy(confirmRefID, src); 		
		hasConfirmRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConfirmRefID(String str) {		
		if (str == null ) return;
		if (hasConfirmRefID()) FixUtils.fillNul(confirmRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(confirmRefID, src); 		
		hasConfirmRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackConfirmReqID() {		
		getConfirmReqID();		
	}		
			
	public byte[] getConfirmReqID() { 		
		if ( hasConfirmReqID()) {		
			if (hasConfirmReqID == FixUtils.TAG_HAS_VALUE) {		
				return confirmReqID; 		
			} else {

				buf.position(hasConfirmReqID);

			FixMessage.getTagStringValue(buf, confirmReqID, 0, confirmReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasConfirmReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return confirmReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasConfirmReqID() { return hasConfirmReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setConfirmReqID(byte[] src) {		
		if (src == null ) return;
		if (hasConfirmReqID()) FixUtils.fillNul(confirmReqID);		
		FixUtils.copy(confirmReqID, src); 		
		hasConfirmReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConfirmReqID(String str) {		
		if (str == null ) return;
		if (hasConfirmReqID()) FixUtils.fillNul(confirmReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(confirmReqID, src); 		
		hasConfirmReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackConfirmTransType() {		
		getConfirmTransType();		
	}		
			
	public long getConfirmTransType() { 		
		if ( hasConfirmTransType()) {		
			if (hasConfirmTransType == FixUtils.TAG_HAS_VALUE) {		
				return confirmTransType; 		
			} else {

				buf.position(hasConfirmTransType);

			confirmTransType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasConfirmTransType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return confirmTransType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasConfirmTransType() { return hasConfirmTransType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setConfirmTransType(byte[] src) {		
		if (src == null ) return;
		if (hasConfirmTransType()) confirmTransType = FixUtils.TAG_HAS_NO_VALUE;		
		confirmTransType = FixUtils.longValueOf(src, 0, src.length);
		hasConfirmTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConfirmTransType(long src) {		
		confirmTransType = src;
		hasConfirmTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConfirmTransType(String str) {		
		if (str == null ) return;
		if (hasConfirmTransType()) confirmTransType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		confirmTransType = FixUtils.longValueOf(src, 0, src.length);
		hasConfirmTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackConfirmType() {		
		getConfirmType();		
	}		
			
	public long getConfirmType() { 		
		if ( hasConfirmType()) {		
			if (hasConfirmType == FixUtils.TAG_HAS_VALUE) {		
				return confirmType; 		
			} else {

				buf.position(hasConfirmType);

			confirmType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasConfirmType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return confirmType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasConfirmType() { return hasConfirmType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setConfirmType(byte[] src) {		
		if (src == null ) return;
		if (hasConfirmType()) confirmType = FixUtils.TAG_HAS_NO_VALUE;		
		confirmType = FixUtils.longValueOf(src, 0, src.length);
		hasConfirmType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConfirmType(long src) {		
		confirmType = src;
		hasConfirmType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConfirmType(String str) {		
		if (str == null ) return;
		if (hasConfirmType()) confirmType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		confirmType = FixUtils.longValueOf(src, 0, src.length);
		hasConfirmType = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackConfirmStatus() {		
		getConfirmStatus();		
	}		
			
	public long getConfirmStatus() { 		
		if ( hasConfirmStatus()) {		
			if (hasConfirmStatus == FixUtils.TAG_HAS_VALUE) {		
				return confirmStatus; 		
			} else {

				buf.position(hasConfirmStatus);

			confirmStatus = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasConfirmStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return confirmStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasConfirmStatus() { return hasConfirmStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setConfirmStatus(byte[] src) {		
		if (src == null ) return;
		if (hasConfirmStatus()) confirmStatus = FixUtils.TAG_HAS_NO_VALUE;		
		confirmStatus = FixUtils.longValueOf(src, 0, src.length);
		hasConfirmStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConfirmStatus(long src) {		
		confirmStatus = src;
		hasConfirmStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConfirmStatus(String str) {		
		if (str == null ) return;
		if (hasConfirmStatus()) confirmStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		confirmStatus = FixUtils.longValueOf(src, 0, src.length);
		hasConfirmStatus = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackIndividualAllocID() {		
		getIndividualAllocID();		
	}		
			
	public byte[] getIndividualAllocID() { 		
		if ( hasIndividualAllocID()) {		
			if (hasIndividualAllocID == FixUtils.TAG_HAS_VALUE) {		
				return individualAllocID; 		
			} else {

				buf.position(hasIndividualAllocID);

			FixMessage.getTagStringValue(buf, individualAllocID, 0, individualAllocID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return individualAllocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasIndividualAllocID() { return hasIndividualAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setIndividualAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasIndividualAllocID()) FixUtils.fillNul(individualAllocID);		
		FixUtils.copy(individualAllocID, src); 		
		hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIndividualAllocID(String str) {		
		if (str == null ) return;
		if (hasIndividualAllocID()) FixUtils.fillNul(individualAllocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(individualAllocID, src); 		
		hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackAllocQty() {		
		getAllocQty();		
	}		
			
	public long getAllocQty() { 		
		if ( hasAllocQty()) {		
			if (hasAllocQty == FixUtils.TAG_HAS_VALUE) {		
				return allocQty; 		
			} else {

				buf.position(hasAllocQty);

			allocQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocQty() { return hasAllocQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocQty(byte[] src) {		
		if (src == null ) return;
		if (hasAllocQty()) allocQty = FixUtils.TAG_HAS_NO_VALUE;		
		allocQty = FixUtils.longValueOf(src, 0, src.length);
		hasAllocQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocQty(long src) {		
		allocQty = src;
		hasAllocQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocQty(String str) {		
		if (str == null ) return;
		if (hasAllocQty()) allocQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocQty = FixUtils.longValueOf(src, 0, src.length);
		hasAllocQty = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackAllocAccount() {		
		getAllocAccount();		
	}		
			
	public byte[] getAllocAccount() { 		
		if ( hasAllocAccount()) {		
			if (hasAllocAccount == FixUtils.TAG_HAS_VALUE) {		
				return allocAccount; 		
			} else {

				buf.position(hasAllocAccount);

			FixMessage.getTagStringValue(buf, allocAccount, 0, allocAccount.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocAccount;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocAccount() { return hasAllocAccount != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocAccount(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAccount()) FixUtils.fillNul(allocAccount);		
		FixUtils.copy(allocAccount, src); 		
		hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAccount(String str) {		
		if (str == null ) return;
		if (hasAllocAccount()) FixUtils.fillNul(allocAccount);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocAccount, src); 		
		hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocAcctIDSource() {		
		getAllocAcctIDSource();		
	}		
			
	public long getAllocAcctIDSource() { 		
		if ( hasAllocAcctIDSource()) {		
			if (hasAllocAcctIDSource == FixUtils.TAG_HAS_VALUE) {		
				return allocAcctIDSource; 		
			} else {

				buf.position(hasAllocAcctIDSource);

			allocAcctIDSource = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocAcctIDSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocAcctIDSource() { return hasAllocAcctIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocAcctIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAcctIDSource()) allocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		allocAcctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAcctIDSource(long src) {		
		allocAcctIDSource = src;
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAcctIDSource(String str) {		
		if (str == null ) return;
		if (hasAllocAcctIDSource()) allocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocAcctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocAccountType() {		
		getAllocAccountType();		
	}		
			
	public long getAllocAccountType() { 		
		if ( hasAllocAccountType()) {		
			if (hasAllocAccountType == FixUtils.TAG_HAS_VALUE) {		
				return allocAccountType; 		
			} else {

				buf.position(hasAllocAccountType);

			allocAccountType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocAccountType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocAccountType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocAccountType() { return hasAllocAccountType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocAccountType(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAccountType()) allocAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		allocAccountType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAccountType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAccountType(long src) {		
		allocAccountType = src;
		hasAllocAccountType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAccountType(String str) {		
		if (str == null ) return;
		if (hasAllocAccountType()) allocAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocAccountType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAccountType = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackReportedPx() {		
		getReportedPx();		
	}		
			
	public long getReportedPx() { 		
		if ( hasReportedPx()) {		
			if (hasReportedPx == FixUtils.TAG_HAS_VALUE) {		
				return reportedPx; 		
			} else {

				buf.position(hasReportedPx);

			reportedPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasReportedPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return reportedPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasReportedPx() { return hasReportedPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setReportedPx(byte[] src) {		
		if (src == null ) return;
		if (hasReportedPx()) reportedPx = FixUtils.TAG_HAS_NO_VALUE;		
		reportedPx = FixUtils.longValueOf(src, 0, src.length);
		hasReportedPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setReportedPx(long src) {		
		reportedPx = src;
		hasReportedPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setReportedPx(String str) {		
		if (str == null ) return;
		if (hasReportedPx()) reportedPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		reportedPx = FixUtils.longValueOf(src, 0, src.length);
		hasReportedPx = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackProcessCode() {		
		getProcessCode();		
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
		if (hasExDate()) FixUtils.fillNul(exDate);		
		FixUtils.copy(exDate, src); 		
		hasExDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExDate(String str) {		
		if (str == null ) return;
		if (hasExDate()) FixUtils.fillNul(exDate);		
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
			
	public void crackMaturityNetMoney() {		
		getMaturityNetMoney();		
	}		
			
	public long getMaturityNetMoney() { 		
		if ( hasMaturityNetMoney()) {		
			if (hasMaturityNetMoney == FixUtils.TAG_HAS_VALUE) {		
				return maturityNetMoney; 		
			} else {

				buf.position(hasMaturityNetMoney);

			maturityNetMoney = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMaturityNetMoney = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return maturityNetMoney;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaturityNetMoney() { return hasMaturityNetMoney != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMaturityNetMoney(byte[] src) {		
		if (src == null ) return;
		if (hasMaturityNetMoney()) maturityNetMoney = FixUtils.TAG_HAS_NO_VALUE;		
		maturityNetMoney = FixUtils.longValueOf(src, 0, src.length);
		hasMaturityNetMoney = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaturityNetMoney(long src) {		
		maturityNetMoney = src;
		hasMaturityNetMoney = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaturityNetMoney(String str) {		
		if (str == null ) return;
		if (hasMaturityNetMoney()) maturityNetMoney = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maturityNetMoney = FixUtils.longValueOf(src, 0, src.length);
		hasMaturityNetMoney = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackSharedCommission() {		
		getSharedCommission();		
	}		
			
	public long getSharedCommission() { 		
		if ( hasSharedCommission()) {		
			if (hasSharedCommission == FixUtils.TAG_HAS_VALUE) {		
				return sharedCommission; 		
			} else {

				buf.position(hasSharedCommission);

			sharedCommission = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSharedCommission = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return sharedCommission;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSharedCommission() { return hasSharedCommission != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSharedCommission(byte[] src) {		
		if (src == null ) return;
		if (hasSharedCommission()) sharedCommission = FixUtils.TAG_HAS_NO_VALUE;		
		sharedCommission = FixUtils.longValueOf(src, 0, src.length);
		hasSharedCommission = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSharedCommission(long src) {		
		sharedCommission = src;
		hasSharedCommission = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSharedCommission(String str) {		
		if (str == null ) return;
		if (hasSharedCommission()) sharedCommission = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sharedCommission = FixUtils.longValueOf(src, 0, src.length);
		hasSharedCommission = FixUtils.TAG_HAS_VALUE;		
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

					if (hasConfirmID()) s += "ConfirmID(664)= " + new String( FixUtils.trim(getConfirmID()) ) + "\n" ; 
		if (hasConfirmRefID()) s += "ConfirmRefID(772)= " + new String( FixUtils.trim(getConfirmRefID()) ) + "\n" ; 
		if (hasConfirmReqID()) s += "ConfirmReqID(859)= " + new String( FixUtils.trim(getConfirmReqID()) ) + "\n" ; 
		if (hasConfirmTransType()) s += "ConfirmTransType(666)= " + getConfirmTransType() + "\n" ; 
		if (hasConfirmType()) s += "ConfirmType(773)= " + getConfirmType() + "\n" ; 
		if (hasCopyMsgIndicator()) s += "CopyMsgIndicator(797)= " + getCopyMsgIndicator() + "\n" ; 
		if (hasLegalConfirm()) s += "LegalConfirm(650)= " + getLegalConfirm() + "\n" ; 
		if (hasConfirmStatus()) s += "ConfirmStatus(665)= " + getConfirmStatus() + "\n" ; 
		if (hasAllocID()) s += "AllocID(70)= " + new String( FixUtils.trim(getAllocID()) ) + "\n" ; 
		if (hasSecondaryAllocID()) s += "SecondaryAllocID(793)= " + new String( FixUtils.trim(getSecondaryAllocID()) ) + "\n" ; 
		if (hasIndividualAllocID()) s += "IndividualAllocID(467)= " + new String( FixUtils.trim(getIndividualAllocID()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasAllocQty()) s += "AllocQty(80)= " + getAllocQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasQtyType()) s += "QtyType(854)= " + getQtyType() + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasLastMkt()) s += "LastMkt(30)= " + new String( FixUtils.trim(getLastMkt()) ) + "\n" ; 
		if (hasAllocAccount()) s += "AllocAccount(79)= " + new String( FixUtils.trim(getAllocAccount()) ) + "\n" ; 
		if (hasAllocAcctIDSource()) s += "AllocAcctIDSource(661)= " + getAllocAcctIDSource() + "\n" ; 
		if (hasAllocAccountType()) s += "AllocAccountType(798)= " + getAllocAccountType() + "\n" ; 
		if (hasAvgPx()) s += "AvgPx(6)= " + getAvgPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAvgPxPrecision()) s += "AvgPxPrecision(74)= " + getAvgPxPrecision() + "\n" ; 
		if (hasPriceType()) s += "PriceType(423)= " + getPriceType() + "\n" ; 
		if (hasAvgParPx()) s += "AvgParPx(860)= " + getAvgParPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasReportedPx()) s += "ReportedPx(861)= " + getReportedPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasProcessCode()) s += "ProcessCode(81)= " + getProcessCode() + "\n" ; 
		if (hasGrossTradeAmt()) s += "GrossTradeAmt(381)= " + getGrossTradeAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasNumDaysInterest()) s += "NumDaysInterest(157)= " + getNumDaysInterest() + "\n" ; 
		if (hasExDate()) s += "ExDate(230)= " + new String( FixUtils.trim(getExDate()) ) + "\n" ; 
		if (hasAccruedInterestRate()) s += "AccruedInterestRate(158)= " + getAccruedInterestRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAccruedInterestAmt()) s += "AccruedInterestAmt(159)= " + getAccruedInterestAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasInterestAtMaturity()) s += "InterestAtMaturity(738)= " + getInterestAtMaturity() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasEndAccruedInterestAmt()) s += "EndAccruedInterestAmt(920)= " + getEndAccruedInterestAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasStartCash()) s += "StartCash(921)= " + getStartCash() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasEndCash()) s += "EndCash(922)= " + getEndCash() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasConcession()) s += "Concession(238)= " + getConcession() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTotalTakedown()) s += "TotalTakedown(237)= " + getTotalTakedown() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasNetMoney()) s += "NetMoney(118)= " + getNetMoney() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMaturityNetMoney()) s += "MaturityNetMoney(890)= " + getMaturityNetMoney() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrAmt()) s += "SettlCurrAmt(119)= " + getSettlCurrAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrency()) s += "SettlCurrency(120)= " + new String( FixUtils.trim(getSettlCurrency()) ) + "\n" ; 
		if (hasSettlCurrFxRate()) s += "SettlCurrFxRate(155)= " + getSettlCurrFxRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrFxRateCalc()) s += "SettlCurrFxRateCalc(156)= " + getSettlCurrFxRateCalc() + "\n" ; 
		if (hasSettlType()) s += "SettlType(63)= " + new String( FixUtils.trim(getSettlType()) ) + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasSharedCommission()) s += "SharedCommission(858)= " + getSharedCommission() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixConfirmation)) return false;

		FixConfirmation msg = (FixConfirmation) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasConfirmID() && !msg.hasConfirmID()) || (!hasConfirmID() && msg.hasConfirmID())) return false;
		if (!(!hasConfirmID() && !msg.hasConfirmID()) && !FixUtils.equals(getConfirmID(), msg.getConfirmID())) return false;
		if ((hasConfirmRefID() && !msg.hasConfirmRefID()) || (!hasConfirmRefID() && msg.hasConfirmRefID())) return false;
		if (!(!hasConfirmRefID() && !msg.hasConfirmRefID()) && !FixUtils.equals(getConfirmRefID(), msg.getConfirmRefID())) return false;
		if ((hasConfirmReqID() && !msg.hasConfirmReqID()) || (!hasConfirmReqID() && msg.hasConfirmReqID())) return false;
		if (!(!hasConfirmReqID() && !msg.hasConfirmReqID()) && !FixUtils.equals(getConfirmReqID(), msg.getConfirmReqID())) return false;
		if ((hasConfirmTransType() && !msg.hasConfirmTransType()) || (!hasConfirmTransType() && msg.hasConfirmTransType())) return false;
		if (!(!hasConfirmTransType() && !msg.hasConfirmTransType()) && !(getConfirmTransType()==msg.getConfirmTransType())) return false;
		if ((hasConfirmType() && !msg.hasConfirmType()) || (!hasConfirmType() && msg.hasConfirmType())) return false;
		if (!(!hasConfirmType() && !msg.hasConfirmType()) && !(getConfirmType()==msg.getConfirmType())) return false;
		if ((hasCopyMsgIndicator() && !msg.hasCopyMsgIndicator()) || (!hasCopyMsgIndicator() && msg.hasCopyMsgIndicator())) return false;
		if (!(!hasCopyMsgIndicator() && !msg.hasCopyMsgIndicator()) && !(getCopyMsgIndicator()==msg.getCopyMsgIndicator())) return false;
		if ((hasLegalConfirm() && !msg.hasLegalConfirm()) || (!hasLegalConfirm() && msg.hasLegalConfirm())) return false;
		if (!(!hasLegalConfirm() && !msg.hasLegalConfirm()) && !(getLegalConfirm()==msg.getLegalConfirm())) return false;
		if ((hasConfirmStatus() && !msg.hasConfirmStatus()) || (!hasConfirmStatus() && msg.hasConfirmStatus())) return false;
		if (!(!hasConfirmStatus() && !msg.hasConfirmStatus()) && !(getConfirmStatus()==msg.getConfirmStatus())) return false;
		if ((hasAllocID() && !msg.hasAllocID()) || (!hasAllocID() && msg.hasAllocID())) return false;
		if (!(!hasAllocID() && !msg.hasAllocID()) && !FixUtils.equals(getAllocID(), msg.getAllocID())) return false;
		if ((hasSecondaryAllocID() && !msg.hasSecondaryAllocID()) || (!hasSecondaryAllocID() && msg.hasSecondaryAllocID())) return false;
		if (!(!hasSecondaryAllocID() && !msg.hasSecondaryAllocID()) && !FixUtils.equals(getSecondaryAllocID(), msg.getSecondaryAllocID())) return false;
		if ((hasIndividualAllocID() && !msg.hasIndividualAllocID()) || (!hasIndividualAllocID() && msg.hasIndividualAllocID())) return false;
		if (!(!hasIndividualAllocID() && !msg.hasIndividualAllocID()) && !FixUtils.equals(getIndividualAllocID(), msg.getIndividualAllocID())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasTradeDate() && !msg.hasTradeDate()) || (!hasTradeDate() && msg.hasTradeDate())) return false;
		if ((hasAllocQty() && !msg.hasAllocQty()) || (!hasAllocQty() && msg.hasAllocQty())) return false;
		if (!(!hasAllocQty() && !msg.hasAllocQty()) && !(getAllocQty()==msg.getAllocQty())) return false;
		if ((hasQtyType() && !msg.hasQtyType()) || (!hasQtyType() && msg.hasQtyType())) return false;
		if (!(!hasQtyType() && !msg.hasQtyType()) && !(getQtyType()==msg.getQtyType())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasLastMkt() && !msg.hasLastMkt()) || (!hasLastMkt() && msg.hasLastMkt())) return false;
		if (!(!hasLastMkt() && !msg.hasLastMkt()) && !FixUtils.equals(getLastMkt(), msg.getLastMkt())) return false;
		if ((hasAllocAccount() && !msg.hasAllocAccount()) || (!hasAllocAccount() && msg.hasAllocAccount())) return false;
		if (!(!hasAllocAccount() && !msg.hasAllocAccount()) && !FixUtils.equals(getAllocAccount(), msg.getAllocAccount())) return false;
		if ((hasAllocAcctIDSource() && !msg.hasAllocAcctIDSource()) || (!hasAllocAcctIDSource() && msg.hasAllocAcctIDSource())) return false;
		if (!(!hasAllocAcctIDSource() && !msg.hasAllocAcctIDSource()) && !(getAllocAcctIDSource()==msg.getAllocAcctIDSource())) return false;
		if ((hasAllocAccountType() && !msg.hasAllocAccountType()) || (!hasAllocAccountType() && msg.hasAllocAccountType())) return false;
		if (!(!hasAllocAccountType() && !msg.hasAllocAccountType()) && !(getAllocAccountType()==msg.getAllocAccountType())) return false;
		if ((hasAvgPx() && !msg.hasAvgPx()) || (!hasAvgPx() && msg.hasAvgPx())) return false;
		if (!(!hasAvgPx() && !msg.hasAvgPx()) && !(getAvgPx()==msg.getAvgPx())) return false;
		if ((hasAvgPxPrecision() && !msg.hasAvgPxPrecision()) || (!hasAvgPxPrecision() && msg.hasAvgPxPrecision())) return false;
		if (!(!hasAvgPxPrecision() && !msg.hasAvgPxPrecision()) && !(getAvgPxPrecision()==msg.getAvgPxPrecision())) return false;
		if ((hasPriceType() && !msg.hasPriceType()) || (!hasPriceType() && msg.hasPriceType())) return false;
		if (!(!hasPriceType() && !msg.hasPriceType()) && !(getPriceType()==msg.getPriceType())) return false;
		if ((hasAvgParPx() && !msg.hasAvgParPx()) || (!hasAvgParPx() && msg.hasAvgParPx())) return false;
		if (!(!hasAvgParPx() && !msg.hasAvgParPx()) && !(getAvgParPx()==msg.getAvgParPx())) return false;
		if ((hasReportedPx() && !msg.hasReportedPx()) || (!hasReportedPx() && msg.hasReportedPx())) return false;
		if (!(!hasReportedPx() && !msg.hasReportedPx()) && !(getReportedPx()==msg.getReportedPx())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasProcessCode() && !msg.hasProcessCode()) || (!hasProcessCode() && msg.hasProcessCode())) return false;
		if (!(!hasProcessCode() && !msg.hasProcessCode()) && !(getProcessCode()==msg.getProcessCode())) return false;
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
		if ((hasConcession() && !msg.hasConcession()) || (!hasConcession() && msg.hasConcession())) return false;
		if (!(!hasConcession() && !msg.hasConcession()) && !(getConcession()==msg.getConcession())) return false;
		if ((hasTotalTakedown() && !msg.hasTotalTakedown()) || (!hasTotalTakedown() && msg.hasTotalTakedown())) return false;
		if (!(!hasTotalTakedown() && !msg.hasTotalTakedown()) && !(getTotalTakedown()==msg.getTotalTakedown())) return false;
		if ((hasNetMoney() && !msg.hasNetMoney()) || (!hasNetMoney() && msg.hasNetMoney())) return false;
		if (!(!hasNetMoney() && !msg.hasNetMoney()) && !(getNetMoney()==msg.getNetMoney())) return false;
		if ((hasMaturityNetMoney() && !msg.hasMaturityNetMoney()) || (!hasMaturityNetMoney() && msg.hasMaturityNetMoney())) return false;
		if (!(!hasMaturityNetMoney() && !msg.hasMaturityNetMoney()) && !(getMaturityNetMoney()==msg.getMaturityNetMoney())) return false;
		if ((hasSettlCurrAmt() && !msg.hasSettlCurrAmt()) || (!hasSettlCurrAmt() && msg.hasSettlCurrAmt())) return false;
		if (!(!hasSettlCurrAmt() && !msg.hasSettlCurrAmt()) && !(getSettlCurrAmt()==msg.getSettlCurrAmt())) return false;
		if ((hasSettlCurrency() && !msg.hasSettlCurrency()) || (!hasSettlCurrency() && msg.hasSettlCurrency())) return false;
		if (!(!hasSettlCurrency() && !msg.hasSettlCurrency()) && !FixUtils.equals(getSettlCurrency(), msg.getSettlCurrency())) return false;
		if ((hasSettlCurrFxRate() && !msg.hasSettlCurrFxRate()) || (!hasSettlCurrFxRate() && msg.hasSettlCurrFxRate())) return false;
		if (!(!hasSettlCurrFxRate() && !msg.hasSettlCurrFxRate()) && !(getSettlCurrFxRate()==msg.getSettlCurrFxRate())) return false;
		if ((hasSettlCurrFxRateCalc() && !msg.hasSettlCurrFxRateCalc()) || (!hasSettlCurrFxRateCalc() && msg.hasSettlCurrFxRateCalc())) return false;
		if (!(!hasSettlCurrFxRateCalc() && !msg.hasSettlCurrFxRateCalc()) && !(getSettlCurrFxRateCalc()==msg.getSettlCurrFxRateCalc())) return false;
		if ((hasSettlType() && !msg.hasSettlType()) || (!hasSettlType() && msg.hasSettlType())) return false;
		if (!(!hasSettlType() && !msg.hasSettlType()) && !FixUtils.equals(getSettlType(), msg.getSettlType())) return false;
		if ((hasSettlDate() && !msg.hasSettlDate()) || (!hasSettlDate() && msg.hasSettlDate())) return false;
		if ((hasSharedCommission() && !msg.hasSharedCommission()) || (!hasSharedCommission() && msg.hasSharedCommission())) return false;
		if (!(!hasSharedCommission() && !msg.hasSharedCommission()) && !(getSharedCommission()==msg.getSharedCommission())) return false;
		return true;
	}
	@Override
	public FixConfirmation clone () {
		FixConfirmation out = new FixConfirmation();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixConfirmation clone ( FixConfirmation out ) {
		if ( hasConfirmID())
			out.setConfirmID(getConfirmID());
		if ( hasConfirmRefID())
			out.setConfirmRefID(getConfirmRefID());
		if ( hasConfirmReqID())
			out.setConfirmReqID(getConfirmReqID());
		if ( hasConfirmTransType())
			out.setConfirmTransType(getConfirmTransType());
		if ( hasConfirmType())
			out.setConfirmType(getConfirmType());
		if ( hasCopyMsgIndicator())
			out.setCopyMsgIndicator(getCopyMsgIndicator());
		if ( hasLegalConfirm())
			out.setLegalConfirm(getLegalConfirm());
		if ( hasConfirmStatus())
			out.setConfirmStatus(getConfirmStatus());
		if ( hasAllocID())
			out.setAllocID(getAllocID());
		if ( hasSecondaryAllocID())
			out.setSecondaryAllocID(getSecondaryAllocID());
		if ( hasIndividualAllocID())
			out.setIndividualAllocID(getIndividualAllocID());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasTradeDate())
			out.setTradeDate(getTradeDate());
		if ( hasAllocQty())
			out.setAllocQty(getAllocQty());
		if ( hasQtyType())
			out.setQtyType(getQtyType());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasLastMkt())
			out.setLastMkt(getLastMkt());
		if ( hasAllocAccount())
			out.setAllocAccount(getAllocAccount());
		if ( hasAllocAcctIDSource())
			out.setAllocAcctIDSource(getAllocAcctIDSource());
		if ( hasAllocAccountType())
			out.setAllocAccountType(getAllocAccountType());
		if ( hasAvgPx())
			out.setAvgPx(getAvgPx());
		if ( hasAvgPxPrecision())
			out.setAvgPxPrecision(getAvgPxPrecision());
		if ( hasPriceType())
			out.setPriceType(getPriceType());
		if ( hasAvgParPx())
			out.setAvgParPx(getAvgParPx());
		if ( hasReportedPx())
			out.setReportedPx(getReportedPx());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasProcessCode())
			out.setProcessCode(getProcessCode());
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
		if ( hasConcession())
			out.setConcession(getConcession());
		if ( hasTotalTakedown())
			out.setTotalTakedown(getTotalTakedown());
		if ( hasNetMoney())
			out.setNetMoney(getNetMoney());
		if ( hasMaturityNetMoney())
			out.setMaturityNetMoney(getMaturityNetMoney());
		if ( hasSettlCurrAmt())
			out.setSettlCurrAmt(getSettlCurrAmt());
		if ( hasSettlCurrency())
			out.setSettlCurrency(getSettlCurrency());
		if ( hasSettlCurrFxRate())
			out.setSettlCurrFxRate(getSettlCurrFxRate());
		if ( hasSettlCurrFxRateCalc())
			out.setSettlCurrFxRateCalc(getSettlCurrFxRateCalc());
		if ( hasSettlType())
			out.setSettlType(getSettlType());
		if ( hasSettlDate())
			out.setSettlDate(getSettlDate());
		if ( hasSharedCommission())
			out.setSharedCommission(getSharedCommission());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixOrdAllocGrp fixOrdAllocGrp : ordAllocGrp) {
			if (!fixOrdAllocGrp.hasGroup()) continue;
			out.ordAllocGrp[count] = fixOrdAllocGrp.clone( out.ordAllocGrp[count] );
			count++;
		}
		count = 0;
		for (FixTrdRegTimestamps fixTrdRegTimestamps : trdRegTimestamps) {
			if (!fixTrdRegTimestamps.hasGroup()) continue;
			out.trdRegTimestamps[count] = fixTrdRegTimestamps.clone( out.trdRegTimestamps[count] );
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
		if (yieldData.hasGroup())
			out.yieldData = yieldData.clone( out.yieldData);
		count = 0;
		for (FixCpctyConfGrp fixCpctyConfGrp : cpctyConfGrp) {
			if (!fixCpctyConfGrp.hasGroup()) continue;
			out.cpctyConfGrp[count] = fixCpctyConfGrp.clone( out.cpctyConfGrp[count] );
			count++;
		}
		if (spreadOrBenchmarkCurveData.hasGroup())
			out.spreadOrBenchmarkCurveData = spreadOrBenchmarkCurveData.clone( out.spreadOrBenchmarkCurveData);
		if (settlInstructionsData.hasGroup())
			out.settlInstructionsData = settlInstructionsData.clone( out.settlInstructionsData);
		if (commissionData.hasGroup())
			out.commissionData = commissionData.clone( out.commissionData);
		count = 0;
		for (FixStipulations fixStipulations : stipulations) {
			if (!fixStipulations.hasGroup()) continue;
			out.stipulations[count] = fixStipulations.clone( out.stipulations[count] );
			count++;
		}
		count = 0;
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) {
			if (!fixMiscFeesGrp.hasGroup()) continue;
			out.miscFeesGrp[count] = fixMiscFeesGrp.clone( out.miscFeesGrp[count] );
			count++;
		}
		return out;
	}

}
