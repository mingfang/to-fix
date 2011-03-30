package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTrdCapRptAckSideGrp extends FixGroup {
	private short hasSide;
	byte side = (byte)' ';		
	private short hasSideExecID;
	byte[] sideExecID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderDelay;
	long orderDelay = 0;		
	private short hasOrderDelayUnit;
	long orderDelayUnit = 0;		
	private short hasAccount;
	byte[] account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAcctIDSource;
	long acctIDSource = 0;		
	private short hasAccountType;
	long accountType = 0;		
	private short hasProcessCode;
	byte processCode = (byte)' ';		
	private short hasOddLot;
		boolean oddLot = false;		
	private short hasTradeInputSource;
	byte[] tradeInputSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeInputDevice;
	byte[] tradeInputDevice = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasComplianceID;
	byte[] complianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSolicitedFlag;
		boolean solicitedFlag = false;		
	private short hasCustOrderCapacity;
	long custOrderCapacity = 0;		
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTimeBracket;
	byte[] timeBracket = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNetGrossInd;
	long netGrossInd = 0;		
	private short hasSideCurrency;
	byte[] sideCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasSideSettlCurrency;
	byte[] sideSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
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
	private short hasSettlCurrAmt;
	long settlCurrAmt = 0;		
	private short hasSettlCurrFxRate;
	long settlCurrFxRate = 0;		
	private short hasSettlCurrFxRateCalc;
	byte settlCurrFxRateCalc = (byte)' ';		
	private short hasPositionEffect;
	byte positionEffect = (byte)' ';		
	private short hasSideMultiLegReportingType;
	long sideMultiLegReportingType = 0;		
	private short hasExchangeRule;
	byte[] exchangeRule = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeAllocIndicator;
	long tradeAllocIndicator = 0;		
	private short hasPreallocMethod;
	byte preallocMethod = (byte)' ';		
	private short hasAllocID;
	byte[] allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSideGrossTradeAmt;
	long sideGrossTradeAmt = 0;		
	private short hasAggressorIndicator;
		boolean aggressorIndicator = false;		
	private short hasSideLastQty;
	long sideLastQty = 0;		
	private short hasSideTradeReportID;
	byte[] sideTradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSideFillStationCd;
	byte[] sideFillStationCd = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSideReasonCd;
	byte[] sideReasonCd = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRptSeq;
	long rptSeq = 0;		
	private short hasSideTrdSubTyp;
	long sideTrdSubTyp = 0;		
	private short hasOrderCategory;
	byte orderCategory = (byte)' ';		
		public FixParties[] parties;
		public FixClrInstGrp[] clrInstGrp;
		public FixCommissionData commissionData;
		public FixContAmtGrp[] contAmtGrp;
		public FixStipulations[] stipulations;
		public FixMiscFeesGrp[] miscFeesGrp;
		public FixSettlDetails[] settlDetails;
		public FixTrdAllocGrp[] trdAllocGrp;
		public FixSideTrdRegTS[] sideTrdRegTS;
		public FixTradeReportOrderDetail tradeReportOrderDetail;
	
	public FixTrdCapRptAckSideGrp() {
		this(false);
	}

	public FixTrdCapRptAckSideGrp(boolean isRequired) {
		super(FixTags.SIDE_INT);

		this.isRequired = isRequired;
		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasSideExecID = FixUtils.TAG_HAS_NO_VALUE;		
		sideExecID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderDelay = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderDelayUnit = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;		
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		hasProcessCode = FixUtils.TAG_HAS_NO_VALUE;		
		hasOddLot = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeInputSource = FixUtils.TAG_HAS_NO_VALUE;		
		tradeInputSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeInputDevice = FixUtils.TAG_HAS_NO_VALUE;		
		tradeInputDevice = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasComplianceID = FixUtils.TAG_HAS_NO_VALUE;		
		complianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSolicitedFlag = FixUtils.TAG_HAS_NO_VALUE;		
		hasCustOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTimeBracket = FixUtils.TAG_HAS_NO_VALUE;		
		timeBracket = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNetGrossInd = FixUtils.TAG_HAS_NO_VALUE;		
		hasSideCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		sideCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasSideSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		sideSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
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
		hasSettlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_NO_VALUE;		
		hasPositionEffect = FixUtils.TAG_HAS_NO_VALUE;		
		hasSideMultiLegReportingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasExchangeRule = FixUtils.TAG_HAS_NO_VALUE;		
		exchangeRule = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeAllocIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasPreallocMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSideGrossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasAggressorIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasSideLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasSideTradeReportID = FixUtils.TAG_HAS_NO_VALUE;		
		sideTradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSideFillStationCd = FixUtils.TAG_HAS_NO_VALUE;		
		sideFillStationCd = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSideReasonCd = FixUtils.TAG_HAS_NO_VALUE;		
		sideReasonCd = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRptSeq = FixUtils.TAG_HAS_NO_VALUE;		
		hasSideTrdSubTyp = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderCategory = FixUtils.TAG_HAS_NO_VALUE;		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		clrInstGrp = new FixClrInstGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) clrInstGrp[i] = new FixClrInstGrp();
		commissionData = new FixCommissionData();
		contAmtGrp = new FixContAmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) contAmtGrp[i] = new FixContAmtGrp();
		stipulations = new FixStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) stipulations[i] = new FixStipulations();
		miscFeesGrp = new FixMiscFeesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) miscFeesGrp[i] = new FixMiscFeesGrp();
		settlDetails = new FixSettlDetails[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) settlDetails[i] = new FixSettlDetails();
		trdAllocGrp = new FixTrdAllocGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdAllocGrp[i] = new FixTrdAllocGrp();
		sideTrdRegTS = new FixSideTrdRegTS[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) sideTrdRegTS[i] = new FixSideTrdRegTS();
		tradeReportOrderDetail = new FixTradeReportOrderDetail();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSide()) return true;
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
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDEEXECID_INT:		
            		hasSideExecID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERDELAY_INT:		
            		hasOrderDelay = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERDELAYUNIT_INT:		
            		hasOrderDelayUnit = (short) buf.position();		
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
            	case FixTags.PROCESSCODE_INT:		
            		hasProcessCode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ODDLOT_INT:		
            		hasOddLot = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADEINPUTSOURCE_INT:		
            		hasTradeInputSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADEINPUTDEVICE_INT:		
            		hasTradeInputDevice = (short) buf.position();		
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
            	case FixTags.CUSTORDERCAPACITY_INT:		
            		hasCustOrderCapacity = (short) buf.position();		
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
            	case FixTags.NETGROSSIND_INT:		
            		hasNetGrossInd = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDECURRENCY_INT:		
            		hasSideCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDESETTLCURRENCY_INT:		
            		hasSideSettlCurrency = (short) buf.position();		
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
            	case FixTags.SETTLCURRAMT_INT:		
            		hasSettlCurrAmt = (short) buf.position();		
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
            	case FixTags.POSITIONEFFECT_INT:		
            		hasPositionEffect = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDEMULTILEGREPORTINGTYPE_INT:		
            		hasSideMultiLegReportingType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.EXCHANGERULE_INT:		
            		hasExchangeRule = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADEALLOCINDICATOR_INT:		
            		hasTradeAllocIndicator = (short) buf.position();		
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
            	case FixTags.SIDEGROSSTRADEAMT_INT:		
            		hasSideGrossTradeAmt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.AGGRESSORINDICATOR_INT:		
            		hasAggressorIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDELASTQTY_INT:		
            		hasSideLastQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDETRADEREPORTID_INT:		
            		hasSideTradeReportID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDEFILLSTATIONCD_INT:		
            		hasSideFillStationCd = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDEREASONCD_INT:		
            		hasSideReasonCd = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RPTSEQ_INT:		
            		hasRptSeq = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDETRDSUBTYP_INT:		
            		hasSideTrdSubTyp = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERCATEGORY_INT:		
            		hasOrderCategory = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOCLEARINGINSTRUCTIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !clrInstGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = clrInstGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( commissionData.isKeyTag(tag)) {
        				tag = commissionData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOCONTAMTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !contAmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = contAmtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
        			} else if ( tag == FixTags.NOMISCFEES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !miscFeesGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = miscFeesGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOSETTLDETAILS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !settlDetails[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = settlDetails[count].setBuffer( repeatingGroupTag, buf, err);	
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
        					if ( !trdAllocGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = trdAllocGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOSIDETRDREGTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !sideTrdRegTS[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = sideTrdRegTS[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tradeReportOrderDetail.isKeyTag(tag)) {
        				tag = tradeReportOrderDetail.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
            		} else { return tag; }
            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
            if (isKeyTag(tag)) return tag; // next in repeating group
        }		
        return tag;
    }		
	public boolean hasRequiredTags(FixValidationError err) {
		if (!hasSide()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Side missing", FixTags.SIDE_INT);
			return false;
		}
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasSide = FixUtils.TAG_HAS_NO_VALUE;
		hasSideExecID = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderDelay = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderDelayUnit = FixUtils.TAG_HAS_NO_VALUE;
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;
		hasAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasAccountType = FixUtils.TAG_HAS_NO_VALUE;
		hasProcessCode = FixUtils.TAG_HAS_NO_VALUE;
		hasOddLot = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeInputSource = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeInputDevice = FixUtils.TAG_HAS_NO_VALUE;
		hasComplianceID = FixUtils.TAG_HAS_NO_VALUE;
		hasSolicitedFlag = FixUtils.TAG_HAS_NO_VALUE;
		hasCustOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasTimeBracket = FixUtils.TAG_HAS_NO_VALUE;
		hasNetGrossInd = FixUtils.TAG_HAS_NO_VALUE;
		hasSideCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasSideSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasNumDaysInterest = FixUtils.TAG_HAS_NO_VALUE;
		hasExDate = FixUtils.TAG_HAS_NO_VALUE;
		hasAccruedInterestRate = FixUtils.TAG_HAS_NO_VALUE;
		hasAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;
		hasInterestAtMaturity = FixUtils.TAG_HAS_NO_VALUE;
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;
		hasStartCash = FixUtils.TAG_HAS_NO_VALUE;
		hasEndCash = FixUtils.TAG_HAS_NO_VALUE;
		hasConcession = FixUtils.TAG_HAS_NO_VALUE;
		hasTotalTakedown = FixUtils.TAG_HAS_NO_VALUE;
		hasNetMoney = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_NO_VALUE;
		hasPositionEffect = FixUtils.TAG_HAS_NO_VALUE;
		hasSideMultiLegReportingType = FixUtils.TAG_HAS_NO_VALUE;
		hasExchangeRule = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeAllocIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasPreallocMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocID = FixUtils.TAG_HAS_NO_VALUE;
		hasSideGrossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;
		hasAggressorIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasSideLastQty = FixUtils.TAG_HAS_NO_VALUE;
		hasSideTradeReportID = FixUtils.TAG_HAS_NO_VALUE;
		hasSideFillStationCd = FixUtils.TAG_HAS_NO_VALUE;
		hasSideReasonCd = FixUtils.TAG_HAS_NO_VALUE;
		hasRptSeq = FixUtils.TAG_HAS_NO_VALUE;
		hasSideTrdSubTyp = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderCategory = FixUtils.TAG_HAS_NO_VALUE;
		for (FixParties fixParties : parties) fixParties.clear();
		for (FixClrInstGrp fixClrInstGrp : clrInstGrp) fixClrInstGrp.clear();
		commissionData.clear();
		for (FixContAmtGrp fixContAmtGrp : contAmtGrp) fixContAmtGrp.clear();
		for (FixStipulations fixStipulations : stipulations) fixStipulations.clear();
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) fixMiscFeesGrp.clear();
		for (FixSettlDetails fixSettlDetails : settlDetails) fixSettlDetails.clear();
		for (FixTrdAllocGrp fixTrdAllocGrp : trdAllocGrp) fixTrdAllocGrp.clear();
		for (FixSideTrdRegTS fixSideTrdRegTS : sideTrdRegTS) fixSideTrdRegTS.clear();
		tradeReportOrderDetail.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSide()) {		
			out.put(FixTags.SIDE);

			out.put((byte) '=');

			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSideExecID()) {		
			out.put(FixTags.SIDEEXECID);

			out.put((byte) '=');

			FixUtils.put(out,sideExecID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderDelay()) {		
			out.put(FixTags.ORDERDELAY);

			out.put((byte) '=');

			FixUtils.put(out, (long)orderDelay);
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderDelayUnit()) {		
			out.put(FixTags.ORDERDELAYUNIT);

			out.put((byte) '=');

			FixUtils.put(out, (long)orderDelayUnit);
		
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

		if (hasProcessCode()) {		
			out.put(FixTags.PROCESSCODE);

			out.put((byte) '=');

			FixUtils.put(out,processCode); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOddLot()) {		
			out.put(FixTags.ODDLOT);

			out.put((byte) '=');

			out.put(oddLot?(byte)'Y':(byte)'N' );
		
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

		if (hasCustOrderCapacity()) {		
			out.put(FixTags.CUSTORDERCAPACITY);

			out.put((byte) '=');

			FixUtils.put(out, (long)custOrderCapacity);
		
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

		if (hasNetGrossInd()) {		
			out.put(FixTags.NETGROSSIND);

			out.put((byte) '=');

			FixUtils.put(out, (long)netGrossInd);
		
			out.put(FixUtils.SOH);

            }

		if (hasSideCurrency()) {		
			out.put(FixTags.SIDECURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,sideCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSideSettlCurrency()) {		
			out.put(FixTags.SIDESETTLCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,sideSettlCurrency); 		
		
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

		if (hasSettlCurrAmt()) {		
			out.put(FixTags.SETTLCURRAMT);

			out.put((byte) '=');

			FixUtils.put(out, (long)settlCurrAmt);
		
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

		if (hasPositionEffect()) {		
			out.put(FixTags.POSITIONEFFECT);

			out.put((byte) '=');

			FixUtils.put(out,positionEffect); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSideMultiLegReportingType()) {		
			out.put(FixTags.SIDEMULTILEGREPORTINGTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)sideMultiLegReportingType);
		
			out.put(FixUtils.SOH);

            }

		if (hasExchangeRule()) {		
			out.put(FixTags.EXCHANGERULE);

			out.put((byte) '=');

			FixUtils.put(out,exchangeRule); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradeAllocIndicator()) {		
			out.put(FixTags.TRADEALLOCINDICATOR);

			out.put((byte) '=');

			FixUtils.put(out, (long)tradeAllocIndicator);
		
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

		if (hasSideGrossTradeAmt()) {		
			out.put(FixTags.SIDEGROSSTRADEAMT);

			out.put((byte) '=');

			FixUtils.put(out, (long)sideGrossTradeAmt);
		
			out.put(FixUtils.SOH);

            }

		if (hasAggressorIndicator()) {		
			out.put(FixTags.AGGRESSORINDICATOR);

			out.put((byte) '=');

			out.put(aggressorIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasSideLastQty()) {		
			out.put(FixTags.SIDELASTQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)sideLastQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasSideTradeReportID()) {		
			out.put(FixTags.SIDETRADEREPORTID);

			out.put((byte) '=');

			FixUtils.put(out,sideTradeReportID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSideFillStationCd()) {		
			out.put(FixTags.SIDEFILLSTATIONCD);

			out.put((byte) '=');

			FixUtils.put(out,sideFillStationCd); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSideReasonCd()) {		
			out.put(FixTags.SIDEREASONCD);

			out.put((byte) '=');

			FixUtils.put(out,sideReasonCd); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRptSeq()) {		
			out.put(FixTags.RPTSEQ);

			out.put((byte) '=');

			FixUtils.put(out, (long)rptSeq);
		
			out.put(FixUtils.SOH);

            }

		if (hasSideTrdSubTyp()) {		
			out.put(FixTags.SIDETRDSUBTYP);

			out.put((byte) '=');

			FixUtils.put(out, (long)sideTrdSubTyp);
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderCategory()) {		
			out.put(FixTags.ORDERCATEGORY);

			out.put((byte) '=');

			FixUtils.put(out,orderCategory); 		
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(clrInstGrp)>0) {
			out.put(FixTags.NOCLEARINGINSTRUCTIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(clrInstGrp));

			out.put(FixUtils.SOH);

		}
		for (FixClrInstGrp fixClrInstGrp : clrInstGrp) if (fixClrInstGrp.hasGroup()) fixClrInstGrp.encode(out);
		commissionData.encode(out);
		if (FixUtils.getNoInGroup(contAmtGrp)>0) {
			out.put(FixTags.NOCONTAMTS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(contAmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixContAmtGrp fixContAmtGrp : contAmtGrp) if (fixContAmtGrp.hasGroup()) fixContAmtGrp.encode(out);
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
		if (FixUtils.getNoInGroup(settlDetails)>0) {
			out.put(FixTags.NOSETTLDETAILS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(settlDetails));

			out.put(FixUtils.SOH);

		}
		for (FixSettlDetails fixSettlDetails : settlDetails) if (fixSettlDetails.hasGroup()) fixSettlDetails.encode(out);
		if (FixUtils.getNoInGroup(trdAllocGrp)>0) {
			out.put(FixTags.NOALLOCS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdAllocGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTrdAllocGrp fixTrdAllocGrp : trdAllocGrp) if (fixTrdAllocGrp.hasGroup()) fixTrdAllocGrp.encode(out);
		if (FixUtils.getNoInGroup(sideTrdRegTS)>0) {
			out.put(FixTags.NOSIDETRDREGTS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(sideTrdRegTS));

			out.put(FixUtils.SOH);

		}
		for (FixSideTrdRegTS fixSideTrdRegTS : sideTrdRegTS) if (fixSideTrdRegTS.hasGroup()) fixSideTrdRegTS.encode(out);
		tradeReportOrderDetail.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideExecID()) {		
			FixUtils.put(out,sideExecID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderDelay()) {		
			FixUtils.put(out, (long)orderDelay);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderDelayUnit()) {		
			FixUtils.put(out, (long)orderDelayUnit);
		
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
		
		if (hasProcessCode()) {		
			FixUtils.put(out,processCode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOddLot()) {		
			out.put(oddLot?(byte)'Y':(byte)'N' );
		
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
		
		if (hasComplianceID()) {		
			FixUtils.put(out,complianceID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSolicitedFlag()) {		
			out.put(solicitedFlag?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCustOrderCapacity()) {		
			FixUtils.put(out, (long)custOrderCapacity);
		
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
		
		if (hasNetGrossInd()) {		
			FixUtils.put(out, (long)netGrossInd);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideCurrency()) {		
			FixUtils.put(out,sideCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideSettlCurrency()) {		
			FixUtils.put(out,sideSettlCurrency); 		
		
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
		
		if (hasSettlCurrAmt()) {		
			FixUtils.put(out, (long)settlCurrAmt);
		
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
		
		if (hasPositionEffect()) {		
			FixUtils.put(out,positionEffect); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideMultiLegReportingType()) {		
			FixUtils.put(out, (long)sideMultiLegReportingType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExchangeRule()) {		
			FixUtils.put(out,exchangeRule); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeAllocIndicator()) {		
			FixUtils.put(out, (long)tradeAllocIndicator);
		
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
		
		if (hasSideGrossTradeAmt()) {		
			FixUtils.put(out, (long)sideGrossTradeAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAggressorIndicator()) {		
			out.put(aggressorIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideLastQty()) {		
			FixUtils.put(out, (long)sideLastQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideTradeReportID()) {		
			FixUtils.put(out,sideTradeReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideFillStationCd()) {		
			FixUtils.put(out,sideFillStationCd); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideReasonCd()) {		
			FixUtils.put(out,sideReasonCd); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRptSeq()) {		
			FixUtils.put(out, (long)rptSeq);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideTrdSubTyp()) {		
			FixUtils.put(out, (long)sideTrdSubTyp);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderCategory()) {		
			FixUtils.put(out,orderCategory); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixParties fixParties : parties) fixParties.printBuffer(out);
		for (FixClrInstGrp fixClrInstGrp : clrInstGrp) fixClrInstGrp.printBuffer(out);
		commissionData.printBuffer(out);
		for (FixContAmtGrp fixContAmtGrp : contAmtGrp) fixContAmtGrp.printBuffer(out);
		for (FixStipulations fixStipulations : stipulations) fixStipulations.printBuffer(out);
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) fixMiscFeesGrp.printBuffer(out);
		for (FixSettlDetails fixSettlDetails : settlDetails) fixSettlDetails.printBuffer(out);
		for (FixTrdAllocGrp fixTrdAllocGrp : trdAllocGrp) fixTrdAllocGrp.printBuffer(out);
		for (FixSideTrdRegTS fixSideTrdRegTS : sideTrdRegTS) fixSideTrdRegTS.printBuffer(out);
		tradeReportOrderDetail.printBuffer(out);
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
			
	public byte[] getSideExecID() { 		
		if ( hasSideExecID()) {		
			if (hasSideExecID == FixUtils.TAG_HAS_VALUE) {		
				return sideExecID; 		
			} else {		
		
				buf.position(hasSideExecID);		
		
			FixMessage.getTagStringValue(buf, sideExecID, 0, sideExecID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSideExecID);		
					return null;		
				}		
			}		
			hasSideExecID = FixUtils.TAG_HAS_VALUE;		
			return sideExecID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSideExecID() { return hasSideExecID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideExecID(byte[] src) {		
		if (src == null ) return;
		if (hasSideExecID()) FixUtils.fillSpace(sideExecID);		
		FixUtils.copy(sideExecID, src); 		
		hasSideExecID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideExecID(String str) {		
		if (str == null ) return;
		if (hasSideExecID()) FixUtils.fillSpace(sideExecID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(sideExecID, src); 		
		hasSideExecID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOrderDelay() { 		
		if ( hasOrderDelay()) {		
			if (hasOrderDelay == FixUtils.TAG_HAS_VALUE) {		
				return orderDelay; 		
			} else {		
		
				buf.position(hasOrderDelay);		
		
			orderDelay = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderDelay);		
					return 0;		
				}		
			}		
			hasOrderDelay = FixUtils.TAG_HAS_VALUE;		
			return orderDelay;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrderDelay() { return hasOrderDelay != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderDelay(long src) {		
		orderDelay = src;
		hasOrderDelay = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderDelay(byte[] src) {		
		if (src == null ) return;
		if (hasOrderDelay()) orderDelay = FixUtils.TAG_HAS_NO_VALUE;		
		orderDelay = FixUtils.longValueOf(src, 0, src.length);
		hasOrderDelay = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderDelay(String str) {		
		if (str == null ) return;
		if (hasOrderDelay()) orderDelay = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		orderDelay = FixUtils.longValueOf(src, 0, src.length);
		hasOrderDelay = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOrderDelayUnit() { 		
		if ( hasOrderDelayUnit()) {		
			if (hasOrderDelayUnit == FixUtils.TAG_HAS_VALUE) {		
				return orderDelayUnit; 		
			} else {		
		
				buf.position(hasOrderDelayUnit);		
		
			orderDelayUnit = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderDelayUnit);		
					return 0;		
				}		
			}		
			hasOrderDelayUnit = FixUtils.TAG_HAS_VALUE;		
			return orderDelayUnit;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrderDelayUnit() { return hasOrderDelayUnit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderDelayUnit(long src) {		
		orderDelayUnit = src;
		hasOrderDelayUnit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderDelayUnit(byte[] src) {		
		if (src == null ) return;
		if (hasOrderDelayUnit()) orderDelayUnit = FixUtils.TAG_HAS_NO_VALUE;		
		orderDelayUnit = FixUtils.longValueOf(src, 0, src.length);
		hasOrderDelayUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderDelayUnit(String str) {		
		if (str == null ) return;
		if (hasOrderDelayUnit()) orderDelayUnit = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		orderDelayUnit = FixUtils.longValueOf(src, 0, src.length);
		hasOrderDelayUnit = FixUtils.TAG_HAS_VALUE;		
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
			
	public boolean getOddLot() { 		
		if ( hasOddLot()) {		
			if (hasOddLot == FixUtils.TAG_HAS_VALUE) {		
				return oddLot; 		
			} else {		
		
				buf.position(hasOddLot);		
		
			oddLot = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasOddLot);		
					return false;		
				}		
			}		
			hasOddLot = FixUtils.TAG_HAS_VALUE;		
			return oddLot;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasOddLot() { return hasOddLot != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOddLot(boolean src) {		
		oddLot = src;
		hasOddLot = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOddLot(byte[] src) {		
		if (src == null ) return;
		if (hasOddLot()) oddLot = false;		
		oddLot = src[0]==(byte)'Y'?true:false;		
		hasOddLot = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOddLot(String str) {		
		if (str == null ) return;
		if (hasOddLot()) oddLot = false;		
		byte[] src = str.getBytes(); 		
		oddLot = src[0]==(byte)'Y'?true:false;		
		hasOddLot = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradeInputSource() { 		
		if ( hasTradeInputSource()) {		
			if (hasTradeInputSource == FixUtils.TAG_HAS_VALUE) {		
				return tradeInputSource; 		
			} else {		
		
				buf.position(hasTradeInputSource);		
		
			FixMessage.getTagStringValue(buf, tradeInputSource, 0, tradeInputSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradeInputSource);		
					return null;		
				}		
			}		
			hasTradeInputSource = FixUtils.TAG_HAS_VALUE;		
			return tradeInputSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeInputSource() { return hasTradeInputSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradeInputSource(byte[] src) {		
		if (src == null ) return;
		if (hasTradeInputSource()) FixUtils.fillSpace(tradeInputSource);		
		FixUtils.copy(tradeInputSource, src); 		
		hasTradeInputSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradeInputSource(String str) {		
		if (str == null ) return;
		if (hasTradeInputSource()) FixUtils.fillSpace(tradeInputSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeInputSource, src); 		
		hasTradeInputSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradeInputDevice() { 		
		if ( hasTradeInputDevice()) {		
			if (hasTradeInputDevice == FixUtils.TAG_HAS_VALUE) {		
				return tradeInputDevice; 		
			} else {		
		
				buf.position(hasTradeInputDevice);		
		
			FixMessage.getTagStringValue(buf, tradeInputDevice, 0, tradeInputDevice.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradeInputDevice);		
					return null;		
				}		
			}		
			hasTradeInputDevice = FixUtils.TAG_HAS_VALUE;		
			return tradeInputDevice;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeInputDevice() { return hasTradeInputDevice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradeInputDevice(byte[] src) {		
		if (src == null ) return;
		if (hasTradeInputDevice()) FixUtils.fillSpace(tradeInputDevice);		
		FixUtils.copy(tradeInputDevice, src); 		
		hasTradeInputDevice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradeInputDevice(String str) {		
		if (str == null ) return;
		if (hasTradeInputDevice()) FixUtils.fillSpace(tradeInputDevice);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeInputDevice, src); 		
		hasTradeInputDevice = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getTimeBracket() { 		
		if ( hasTimeBracket()) {		
			if (hasTimeBracket == FixUtils.TAG_HAS_VALUE) {		
				return timeBracket; 		
			} else {		
		
				buf.position(hasTimeBracket);		
		
			FixMessage.getTagStringValue(buf, timeBracket, 0, timeBracket.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTimeBracket);		
					return null;		
				}		
			}		
			hasTimeBracket = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getNetGrossInd() { 		
		if ( hasNetGrossInd()) {		
			if (hasNetGrossInd == FixUtils.TAG_HAS_VALUE) {		
				return netGrossInd; 		
			} else {		
		
				buf.position(hasNetGrossInd);		
		
			netGrossInd = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNetGrossInd);		
					return 0;		
				}		
			}		
			hasNetGrossInd = FixUtils.TAG_HAS_VALUE;		
			return netGrossInd;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNetGrossInd() { return hasNetGrossInd != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNetGrossInd(long src) {		
		netGrossInd = src;
		hasNetGrossInd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetGrossInd(byte[] src) {		
		if (src == null ) return;
		if (hasNetGrossInd()) netGrossInd = FixUtils.TAG_HAS_NO_VALUE;		
		netGrossInd = FixUtils.longValueOf(src, 0, src.length);
		hasNetGrossInd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNetGrossInd(String str) {		
		if (str == null ) return;
		if (hasNetGrossInd()) netGrossInd = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		netGrossInd = FixUtils.longValueOf(src, 0, src.length);
		hasNetGrossInd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSideCurrency() { 		
		if ( hasSideCurrency()) {		
			if (hasSideCurrency == FixUtils.TAG_HAS_VALUE) {		
				return sideCurrency; 		
			} else {		
		
				buf.position(hasSideCurrency);		
		
			FixMessage.getTagStringValue(buf, sideCurrency, 0, sideCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSideCurrency);		
					return null;		
				}		
			}		
			hasSideCurrency = FixUtils.TAG_HAS_VALUE;		
			return sideCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSideCurrency() { return hasSideCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasSideCurrency()) FixUtils.fillSpace(sideCurrency);		
		FixUtils.copy(sideCurrency, src); 		
		hasSideCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideCurrency(String str) {		
		if (str == null ) return;
		if (hasSideCurrency()) FixUtils.fillSpace(sideCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(sideCurrency, src); 		
		hasSideCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSideSettlCurrency() { 		
		if ( hasSideSettlCurrency()) {		
			if (hasSideSettlCurrency == FixUtils.TAG_HAS_VALUE) {		
				return sideSettlCurrency; 		
			} else {		
		
				buf.position(hasSideSettlCurrency);		
		
			FixMessage.getTagStringValue(buf, sideSettlCurrency, 0, sideSettlCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSideSettlCurrency);		
					return null;		
				}		
			}		
			hasSideSettlCurrency = FixUtils.TAG_HAS_VALUE;		
			return sideSettlCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSideSettlCurrency() { return hasSideSettlCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideSettlCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasSideSettlCurrency()) FixUtils.fillSpace(sideSettlCurrency);		
		FixUtils.copy(sideSettlCurrency, src); 		
		hasSideSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideSettlCurrency(String str) {		
		if (str == null ) return;
		if (hasSideSettlCurrency()) FixUtils.fillSpace(sideSettlCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(sideSettlCurrency, src); 		
		hasSideSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNumDaysInterest() { 		
		if ( hasNumDaysInterest()) {		
			if (hasNumDaysInterest == FixUtils.TAG_HAS_VALUE) {		
				return numDaysInterest; 		
			} else {		
		
				buf.position(hasNumDaysInterest);		
		
			numDaysInterest = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNumDaysInterest);		
					return 0;		
				}		
			}		
			hasNumDaysInterest = FixUtils.TAG_HAS_VALUE;		
			return numDaysInterest;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNumDaysInterest() { return hasNumDaysInterest != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNumDaysInterest(long src) {		
		numDaysInterest = src;
		hasNumDaysInterest = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNumDaysInterest(byte[] src) {		
		if (src == null ) return;
		if (hasNumDaysInterest()) numDaysInterest = FixUtils.TAG_HAS_NO_VALUE;		
		numDaysInterest = FixUtils.longValueOf(src, 0, src.length);
		hasNumDaysInterest = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNumDaysInterest(String str) {		
		if (str == null ) return;
		if (hasNumDaysInterest()) numDaysInterest = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		numDaysInterest = FixUtils.longValueOf(src, 0, src.length);
		hasNumDaysInterest = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getExDate() { 		
		if ( hasExDate()) {		
			if (hasExDate == FixUtils.TAG_HAS_VALUE) {		
				return exDate; 		
			} else {		
		
				buf.position(hasExDate);		
		
			FixMessage.getTagStringValue(buf, exDate, 0, exDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasExDate);		
					return null;		
				}		
			}		
			hasExDate = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getAccruedInterestRate() { 		
		if ( hasAccruedInterestRate()) {		
			if (hasAccruedInterestRate == FixUtils.TAG_HAS_VALUE) {		
				return accruedInterestRate; 		
			} else {		
		
				buf.position(hasAccruedInterestRate);		
		
			accruedInterestRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAccruedInterestRate);		
					return 0;		
				}		
			}		
			hasAccruedInterestRate = FixUtils.TAG_HAS_VALUE;		
			return accruedInterestRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAccruedInterestRate() { return hasAccruedInterestRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAccruedInterestRate(long src) {		
		accruedInterestRate = src;
		hasAccruedInterestRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccruedInterestRate(byte[] src) {		
		if (src == null ) return;
		if (hasAccruedInterestRate()) accruedInterestRate = FixUtils.TAG_HAS_NO_VALUE;		
		accruedInterestRate = FixUtils.longValueOf(src, 0, src.length);
		hasAccruedInterestRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAccruedInterestRate(String str) {		
		if (str == null ) return;
		if (hasAccruedInterestRate()) accruedInterestRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		accruedInterestRate = FixUtils.longValueOf(src, 0, src.length);
		hasAccruedInterestRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAccruedInterestAmt() { 		
		if ( hasAccruedInterestAmt()) {		
			if (hasAccruedInterestAmt == FixUtils.TAG_HAS_VALUE) {		
				return accruedInterestAmt; 		
			} else {		
		
				buf.position(hasAccruedInterestAmt);		
		
			accruedInterestAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAccruedInterestAmt);		
					return 0;		
				}		
			}		
			hasAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
			return accruedInterestAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAccruedInterestAmt() { return hasAccruedInterestAmt != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAccruedInterestAmt(long src) {		
		accruedInterestAmt = src;
		hasAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccruedInterestAmt(byte[] src) {		
		if (src == null ) return;
		if (hasAccruedInterestAmt()) accruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		accruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAccruedInterestAmt(String str) {		
		if (str == null ) return;
		if (hasAccruedInterestAmt()) accruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		accruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getInterestAtMaturity() { 		
		if ( hasInterestAtMaturity()) {		
			if (hasInterestAtMaturity == FixUtils.TAG_HAS_VALUE) {		
				return interestAtMaturity; 		
			} else {		
		
				buf.position(hasInterestAtMaturity);		
		
			interestAtMaturity = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasInterestAtMaturity);		
					return 0;		
				}		
			}		
			hasInterestAtMaturity = FixUtils.TAG_HAS_VALUE;		
			return interestAtMaturity;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasInterestAtMaturity() { return hasInterestAtMaturity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setInterestAtMaturity(long src) {		
		interestAtMaturity = src;
		hasInterestAtMaturity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setInterestAtMaturity(byte[] src) {		
		if (src == null ) return;
		if (hasInterestAtMaturity()) interestAtMaturity = FixUtils.TAG_HAS_NO_VALUE;		
		interestAtMaturity = FixUtils.longValueOf(src, 0, src.length);
		hasInterestAtMaturity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setInterestAtMaturity(String str) {		
		if (str == null ) return;
		if (hasInterestAtMaturity()) interestAtMaturity = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		interestAtMaturity = FixUtils.longValueOf(src, 0, src.length);
		hasInterestAtMaturity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEndAccruedInterestAmt() { 		
		if ( hasEndAccruedInterestAmt()) {		
			if (hasEndAccruedInterestAmt == FixUtils.TAG_HAS_VALUE) {		
				return endAccruedInterestAmt; 		
			} else {		
		
				buf.position(hasEndAccruedInterestAmt);		
		
			endAccruedInterestAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEndAccruedInterestAmt);		
					return 0;		
				}		
			}		
			hasEndAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
			return endAccruedInterestAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEndAccruedInterestAmt() { return hasEndAccruedInterestAmt != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEndAccruedInterestAmt(long src) {		
		endAccruedInterestAmt = src;
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndAccruedInterestAmt(byte[] src) {		
		if (src == null ) return;
		if (hasEndAccruedInterestAmt()) endAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		endAccruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEndAccruedInterestAmt(String str) {		
		if (str == null ) return;
		if (hasEndAccruedInterestAmt()) endAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		endAccruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasEndAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStartCash() { 		
		if ( hasStartCash()) {		
			if (hasStartCash == FixUtils.TAG_HAS_VALUE) {		
				return startCash; 		
			} else {		
		
				buf.position(hasStartCash);		
		
			startCash = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStartCash);		
					return 0;		
				}		
			}		
			hasStartCash = FixUtils.TAG_HAS_VALUE;		
			return startCash;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStartCash() { return hasStartCash != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStartCash(long src) {		
		startCash = src;
		hasStartCash = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStartCash(byte[] src) {		
		if (src == null ) return;
		if (hasStartCash()) startCash = FixUtils.TAG_HAS_NO_VALUE;		
		startCash = FixUtils.longValueOf(src, 0, src.length);
		hasStartCash = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStartCash(String str) {		
		if (str == null ) return;
		if (hasStartCash()) startCash = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		startCash = FixUtils.longValueOf(src, 0, src.length);
		hasStartCash = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEndCash() { 		
		if ( hasEndCash()) {		
			if (hasEndCash == FixUtils.TAG_HAS_VALUE) {		
				return endCash; 		
			} else {		
		
				buf.position(hasEndCash);		
		
			endCash = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEndCash);		
					return 0;		
				}		
			}		
			hasEndCash = FixUtils.TAG_HAS_VALUE;		
			return endCash;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEndCash() { return hasEndCash != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEndCash(long src) {		
		endCash = src;
		hasEndCash = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndCash(byte[] src) {		
		if (src == null ) return;
		if (hasEndCash()) endCash = FixUtils.TAG_HAS_NO_VALUE;		
		endCash = FixUtils.longValueOf(src, 0, src.length);
		hasEndCash = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEndCash(String str) {		
		if (str == null ) return;
		if (hasEndCash()) endCash = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		endCash = FixUtils.longValueOf(src, 0, src.length);
		hasEndCash = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getConcession() { 		
		if ( hasConcession()) {		
			if (hasConcession == FixUtils.TAG_HAS_VALUE) {		
				return concession; 		
			} else {		
		
				buf.position(hasConcession);		
		
			concession = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasConcession);		
					return 0;		
				}		
			}		
			hasConcession = FixUtils.TAG_HAS_VALUE;		
			return concession;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasConcession() { return hasConcession != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setConcession(long src) {		
		concession = src;
		hasConcession = FixUtils.TAG_HAS_VALUE;		
	}

	public void setConcession(byte[] src) {		
		if (src == null ) return;
		if (hasConcession()) concession = FixUtils.TAG_HAS_NO_VALUE;		
		concession = FixUtils.longValueOf(src, 0, src.length);
		hasConcession = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setConcession(String str) {		
		if (str == null ) return;
		if (hasConcession()) concession = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		concession = FixUtils.longValueOf(src, 0, src.length);
		hasConcession = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTotalTakedown() { 		
		if ( hasTotalTakedown()) {		
			if (hasTotalTakedown == FixUtils.TAG_HAS_VALUE) {		
				return totalTakedown; 		
			} else {		
		
				buf.position(hasTotalTakedown);		
		
			totalTakedown = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTotalTakedown);		
					return 0;		
				}		
			}		
			hasTotalTakedown = FixUtils.TAG_HAS_VALUE;		
			return totalTakedown;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotalTakedown() { return hasTotalTakedown != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTotalTakedown(long src) {		
		totalTakedown = src;
		hasTotalTakedown = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotalTakedown(byte[] src) {		
		if (src == null ) return;
		if (hasTotalTakedown()) totalTakedown = FixUtils.TAG_HAS_NO_VALUE;		
		totalTakedown = FixUtils.longValueOf(src, 0, src.length);
		hasTotalTakedown = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTotalTakedown(String str) {		
		if (str == null ) return;
		if (hasTotalTakedown()) totalTakedown = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totalTakedown = FixUtils.longValueOf(src, 0, src.length);
		hasTotalTakedown = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNetMoney() { 		
		if ( hasNetMoney()) {		
			if (hasNetMoney == FixUtils.TAG_HAS_VALUE) {		
				return netMoney; 		
			} else {		
		
				buf.position(hasNetMoney);		
		
			netMoney = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNetMoney);		
					return 0;		
				}		
			}		
			hasNetMoney = FixUtils.TAG_HAS_VALUE;		
			return netMoney;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNetMoney() { return hasNetMoney != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNetMoney(long src) {		
		netMoney = src;
		hasNetMoney = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetMoney(byte[] src) {		
		if (src == null ) return;
		if (hasNetMoney()) netMoney = FixUtils.TAG_HAS_NO_VALUE;		
		netMoney = FixUtils.longValueOf(src, 0, src.length);
		hasNetMoney = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNetMoney(String str) {		
		if (str == null ) return;
		if (hasNetMoney()) netMoney = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		netMoney = FixUtils.longValueOf(src, 0, src.length);
		hasNetMoney = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSettlCurrAmt() { 		
		if ( hasSettlCurrAmt()) {		
			if (hasSettlCurrAmt == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrAmt; 		
			} else {		
		
				buf.position(hasSettlCurrAmt);		
		
			settlCurrAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlCurrAmt);		
					return 0;		
				}		
			}		
			hasSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
			return settlCurrAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlCurrAmt() { return hasSettlCurrAmt != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlCurrAmt(long src) {		
		settlCurrAmt = src;
		hasSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrAmt(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrAmt()) settlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrAmt = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlCurrAmt(String str) {		
		if (str == null ) return;
		if (hasSettlCurrAmt()) settlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlCurrAmt = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSettlCurrFxRate() { 		
		if ( hasSettlCurrFxRate()) {		
			if (hasSettlCurrFxRate == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrFxRate; 		
			} else {		
		
				buf.position(hasSettlCurrFxRate);		
		
			settlCurrFxRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlCurrFxRate);		
					return 0;		
				}		
			}		
			hasSettlCurrFxRate = FixUtils.TAG_HAS_VALUE;		
			return settlCurrFxRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlCurrFxRate() { return hasSettlCurrFxRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlCurrFxRate(long src) {		
		settlCurrFxRate = src;
		hasSettlCurrFxRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrFxRate(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrFxRate()) settlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrFxRate = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrFxRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlCurrFxRate(String str) {		
		if (str == null ) return;
		if (hasSettlCurrFxRate()) settlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlCurrFxRate = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrFxRate = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasSettlCurrFxRateCalc);		
					return (byte)'0';		
				}		
			}		
			hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_VALUE;		
			return settlCurrFxRateCalc;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSettlCurrFxRateCalc() { return hasSettlCurrFxRateCalc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlCurrFxRateCalc(byte src) {		
		settlCurrFxRateCalc = src;
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrFxRateCalc(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrFxRateCalc()) settlCurrFxRateCalc = (byte)' ';		
		settlCurrFxRateCalc = src[0];		
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlCurrFxRateCalc(String str) {		
		if (str == null ) return;
		if (hasSettlCurrFxRateCalc()) settlCurrFxRateCalc = (byte)' ';		
		byte[] src = str.getBytes(); 		
		settlCurrFxRateCalc = src[0];		
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getSideMultiLegReportingType() { 		
		if ( hasSideMultiLegReportingType()) {		
			if (hasSideMultiLegReportingType == FixUtils.TAG_HAS_VALUE) {		
				return sideMultiLegReportingType; 		
			} else {		
		
				buf.position(hasSideMultiLegReportingType);		
		
			sideMultiLegReportingType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSideMultiLegReportingType);		
					return 0;		
				}		
			}		
			hasSideMultiLegReportingType = FixUtils.TAG_HAS_VALUE;		
			return sideMultiLegReportingType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSideMultiLegReportingType() { return hasSideMultiLegReportingType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideMultiLegReportingType(long src) {		
		sideMultiLegReportingType = src;
		hasSideMultiLegReportingType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSideMultiLegReportingType(byte[] src) {		
		if (src == null ) return;
		if (hasSideMultiLegReportingType()) sideMultiLegReportingType = FixUtils.TAG_HAS_NO_VALUE;		
		sideMultiLegReportingType = FixUtils.longValueOf(src, 0, src.length);
		hasSideMultiLegReportingType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideMultiLegReportingType(String str) {		
		if (str == null ) return;
		if (hasSideMultiLegReportingType()) sideMultiLegReportingType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sideMultiLegReportingType = FixUtils.longValueOf(src, 0, src.length);
		hasSideMultiLegReportingType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getExchangeRule() { 		
		if ( hasExchangeRule()) {		
			if (hasExchangeRule == FixUtils.TAG_HAS_VALUE) {		
				return exchangeRule; 		
			} else {		
		
				buf.position(hasExchangeRule);		
		
			FixMessage.getTagStringValue(buf, exchangeRule, 0, exchangeRule.length, err);
		
				if (err.hasError()) {		
					buf.position(hasExchangeRule);		
					return null;		
				}		
			}		
			hasExchangeRule = FixUtils.TAG_HAS_VALUE;		
			return exchangeRule;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExchangeRule() { return hasExchangeRule != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setExchangeRule(byte[] src) {		
		if (src == null ) return;
		if (hasExchangeRule()) FixUtils.fillSpace(exchangeRule);		
		FixUtils.copy(exchangeRule, src); 		
		hasExchangeRule = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setExchangeRule(String str) {		
		if (str == null ) return;
		if (hasExchangeRule()) FixUtils.fillSpace(exchangeRule);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(exchangeRule, src); 		
		hasExchangeRule = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTradeAllocIndicator() { 		
		if ( hasTradeAllocIndicator()) {		
			if (hasTradeAllocIndicator == FixUtils.TAG_HAS_VALUE) {		
				return tradeAllocIndicator; 		
			} else {		
		
				buf.position(hasTradeAllocIndicator);		
		
			tradeAllocIndicator = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTradeAllocIndicator);		
					return 0;		
				}		
			}		
			hasTradeAllocIndicator = FixUtils.TAG_HAS_VALUE;		
			return tradeAllocIndicator;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradeAllocIndicator() { return hasTradeAllocIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradeAllocIndicator(long src) {		
		tradeAllocIndicator = src;
		hasTradeAllocIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeAllocIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasTradeAllocIndicator()) tradeAllocIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		tradeAllocIndicator = FixUtils.longValueOf(src, 0, src.length);
		hasTradeAllocIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradeAllocIndicator(String str) {		
		if (str == null ) return;
		if (hasTradeAllocIndicator()) tradeAllocIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradeAllocIndicator = FixUtils.longValueOf(src, 0, src.length);
		hasTradeAllocIndicator = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getSideGrossTradeAmt() { 		
		if ( hasSideGrossTradeAmt()) {		
			if (hasSideGrossTradeAmt == FixUtils.TAG_HAS_VALUE) {		
				return sideGrossTradeAmt; 		
			} else {		
		
				buf.position(hasSideGrossTradeAmt);		
		
			sideGrossTradeAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSideGrossTradeAmt);		
					return 0;		
				}		
			}		
			hasSideGrossTradeAmt = FixUtils.TAG_HAS_VALUE;		
			return sideGrossTradeAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSideGrossTradeAmt() { return hasSideGrossTradeAmt != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideGrossTradeAmt(long src) {		
		sideGrossTradeAmt = src;
		hasSideGrossTradeAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSideGrossTradeAmt(byte[] src) {		
		if (src == null ) return;
		if (hasSideGrossTradeAmt()) sideGrossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		sideGrossTradeAmt = FixUtils.longValueOf(src, 0, src.length);
		hasSideGrossTradeAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideGrossTradeAmt(String str) {		
		if (str == null ) return;
		if (hasSideGrossTradeAmt()) sideGrossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sideGrossTradeAmt = FixUtils.longValueOf(src, 0, src.length);
		hasSideGrossTradeAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getAggressorIndicator() { 		
		if ( hasAggressorIndicator()) {		
			if (hasAggressorIndicator == FixUtils.TAG_HAS_VALUE) {		
				return aggressorIndicator; 		
			} else {		
		
				buf.position(hasAggressorIndicator);		
		
			aggressorIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasAggressorIndicator);		
					return false;		
				}		
			}		
			hasAggressorIndicator = FixUtils.TAG_HAS_VALUE;		
			return aggressorIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasAggressorIndicator() { return hasAggressorIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAggressorIndicator(boolean src) {		
		aggressorIndicator = src;
		hasAggressorIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAggressorIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasAggressorIndicator()) aggressorIndicator = false;		
		aggressorIndicator = src[0]==(byte)'Y'?true:false;		
		hasAggressorIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAggressorIndicator(String str) {		
		if (str == null ) return;
		if (hasAggressorIndicator()) aggressorIndicator = false;		
		byte[] src = str.getBytes(); 		
		aggressorIndicator = src[0]==(byte)'Y'?true:false;		
		hasAggressorIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSideLastQty() { 		
		if ( hasSideLastQty()) {		
			if (hasSideLastQty == FixUtils.TAG_HAS_VALUE) {		
				return sideLastQty; 		
			} else {		
		
				buf.position(hasSideLastQty);		
		
			sideLastQty = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSideLastQty);		
					return 0;		
				}		
			}		
			hasSideLastQty = FixUtils.TAG_HAS_VALUE;		
			return sideLastQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSideLastQty() { return hasSideLastQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideLastQty(long src) {		
		sideLastQty = src;
		hasSideLastQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSideLastQty(byte[] src) {		
		if (src == null ) return;
		if (hasSideLastQty()) sideLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		sideLastQty = FixUtils.longValueOf(src, 0, src.length);
		hasSideLastQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideLastQty(String str) {		
		if (str == null ) return;
		if (hasSideLastQty()) sideLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sideLastQty = FixUtils.longValueOf(src, 0, src.length);
		hasSideLastQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSideTradeReportID() { 		
		if ( hasSideTradeReportID()) {		
			if (hasSideTradeReportID == FixUtils.TAG_HAS_VALUE) {		
				return sideTradeReportID; 		
			} else {		
		
				buf.position(hasSideTradeReportID);		
		
			FixMessage.getTagStringValue(buf, sideTradeReportID, 0, sideTradeReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSideTradeReportID);		
					return null;		
				}		
			}		
			hasSideTradeReportID = FixUtils.TAG_HAS_VALUE;		
			return sideTradeReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSideTradeReportID() { return hasSideTradeReportID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideTradeReportID(byte[] src) {		
		if (src == null ) return;
		if (hasSideTradeReportID()) FixUtils.fillSpace(sideTradeReportID);		
		FixUtils.copy(sideTradeReportID, src); 		
		hasSideTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideTradeReportID(String str) {		
		if (str == null ) return;
		if (hasSideTradeReportID()) FixUtils.fillSpace(sideTradeReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(sideTradeReportID, src); 		
		hasSideTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSideFillStationCd() { 		
		if ( hasSideFillStationCd()) {		
			if (hasSideFillStationCd == FixUtils.TAG_HAS_VALUE) {		
				return sideFillStationCd; 		
			} else {		
		
				buf.position(hasSideFillStationCd);		
		
			FixMessage.getTagStringValue(buf, sideFillStationCd, 0, sideFillStationCd.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSideFillStationCd);		
					return null;		
				}		
			}		
			hasSideFillStationCd = FixUtils.TAG_HAS_VALUE;		
			return sideFillStationCd;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSideFillStationCd() { return hasSideFillStationCd != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideFillStationCd(byte[] src) {		
		if (src == null ) return;
		if (hasSideFillStationCd()) FixUtils.fillSpace(sideFillStationCd);		
		FixUtils.copy(sideFillStationCd, src); 		
		hasSideFillStationCd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideFillStationCd(String str) {		
		if (str == null ) return;
		if (hasSideFillStationCd()) FixUtils.fillSpace(sideFillStationCd);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(sideFillStationCd, src); 		
		hasSideFillStationCd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSideReasonCd() { 		
		if ( hasSideReasonCd()) {		
			if (hasSideReasonCd == FixUtils.TAG_HAS_VALUE) {		
				return sideReasonCd; 		
			} else {		
		
				buf.position(hasSideReasonCd);		
		
			FixMessage.getTagStringValue(buf, sideReasonCd, 0, sideReasonCd.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSideReasonCd);		
					return null;		
				}		
			}		
			hasSideReasonCd = FixUtils.TAG_HAS_VALUE;		
			return sideReasonCd;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSideReasonCd() { return hasSideReasonCd != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideReasonCd(byte[] src) {		
		if (src == null ) return;
		if (hasSideReasonCd()) FixUtils.fillSpace(sideReasonCd);		
		FixUtils.copy(sideReasonCd, src); 		
		hasSideReasonCd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideReasonCd(String str) {		
		if (str == null ) return;
		if (hasSideReasonCd()) FixUtils.fillSpace(sideReasonCd);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(sideReasonCd, src); 		
		hasSideReasonCd = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getSideTrdSubTyp() { 		
		if ( hasSideTrdSubTyp()) {		
			if (hasSideTrdSubTyp == FixUtils.TAG_HAS_VALUE) {		
				return sideTrdSubTyp; 		
			} else {		
		
				buf.position(hasSideTrdSubTyp);		
		
			sideTrdSubTyp = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSideTrdSubTyp);		
					return 0;		
				}		
			}		
			hasSideTrdSubTyp = FixUtils.TAG_HAS_VALUE;		
			return sideTrdSubTyp;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSideTrdSubTyp() { return hasSideTrdSubTyp != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideTrdSubTyp(long src) {		
		sideTrdSubTyp = src;
		hasSideTrdSubTyp = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSideTrdSubTyp(byte[] src) {		
		if (src == null ) return;
		if (hasSideTrdSubTyp()) sideTrdSubTyp = FixUtils.TAG_HAS_NO_VALUE;		
		sideTrdSubTyp = FixUtils.longValueOf(src, 0, src.length);
		hasSideTrdSubTyp = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideTrdSubTyp(String str) {		
		if (str == null ) return;
		if (hasSideTrdSubTyp()) sideTrdSubTyp = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sideTrdSubTyp = FixUtils.longValueOf(src, 0, src.length);
		hasSideTrdSubTyp = FixUtils.TAG_HAS_VALUE;		
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
					buf.position(hasOrderCategory);		
					return (byte)'0';		
				}		
			}		
			hasOrderCategory = FixUtils.TAG_HAS_VALUE;		
			return orderCategory;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrderCategory() { return hasOrderCategory != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderCategory(byte src) {		
		orderCategory = src;
		hasOrderCategory = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderCategory(byte[] src) {		
		if (src == null ) return;
		if (hasOrderCategory()) orderCategory = (byte)' ';		
		orderCategory = src[0];		
		hasOrderCategory = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderCategory(String str) {		
		if (str == null ) return;
		if (hasOrderCategory()) orderCategory = (byte)' ';		
		byte[] src = str.getBytes(); 		
		orderCategory = src[0];		
		hasOrderCategory = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasSideExecID()) s += "SideExecID(1427)= " + new String( FixUtils.trim(getSideExecID()) ) + "\n" ; 
		if (hasOrderDelay()) s += "OrderDelay(1428)= " + getOrderDelay() + "\n" ; 
		if (hasOrderDelayUnit()) s += "OrderDelayUnit(1429)= " + getOrderDelayUnit() + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAcctIDSource()) s += "AcctIDSource(660)= " + getAcctIDSource() + "\n" ; 
		if (hasAccountType()) s += "AccountType(581)= " + getAccountType() + "\n" ; 
		if (hasProcessCode()) s += "ProcessCode(81)= " + getProcessCode() + "\n" ; 
		if (hasOddLot()) s += "OddLot(575)= " + getOddLot() + "\n" ; 
		if (hasTradeInputSource()) s += "TradeInputSource(578)= " + new String( FixUtils.trim(getTradeInputSource()) ) + "\n" ; 
		if (hasTradeInputDevice()) s += "TradeInputDevice(579)= " + new String( FixUtils.trim(getTradeInputDevice()) ) + "\n" ; 
		if (hasComplianceID()) s += "ComplianceID(376)= " + new String( FixUtils.trim(getComplianceID()) ) + "\n" ; 
		if (hasSolicitedFlag()) s += "SolicitedFlag(377)= " + getSolicitedFlag() + "\n" ; 
		if (hasCustOrderCapacity()) s += "CustOrderCapacity(582)= " + getCustOrderCapacity() + "\n" ; 
		if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 
		if (hasTimeBracket()) s += "TimeBracket(943)= " + new String( FixUtils.trim(getTimeBracket()) ) + "\n" ; 
		if (hasNetGrossInd()) s += "NetGrossInd(430)= " + getNetGrossInd() + "\n" ; 
		if (hasSideCurrency()) s += "SideCurrency(1154)= " + new String( FixUtils.trim(getSideCurrency()) ) + "\n" ; 
		if (hasSideSettlCurrency()) s += "SideSettlCurrency(1155)= " + new String( FixUtils.trim(getSideSettlCurrency()) ) + "\n" ; 
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
		if (hasSettlCurrAmt()) s += "SettlCurrAmt(119)= " + getSettlCurrAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrFxRate()) s += "SettlCurrFxRate(155)= " + getSettlCurrFxRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrFxRateCalc()) s += "SettlCurrFxRateCalc(156)= " + getSettlCurrFxRateCalc() + "\n" ; 
		if (hasPositionEffect()) s += "PositionEffect(77)= " + getPositionEffect() + "\n" ; 
		if (hasSideMultiLegReportingType()) s += "SideMultiLegReportingType(752)= " + getSideMultiLegReportingType() + "\n" ; 
		if (hasExchangeRule()) s += "ExchangeRule(825)= " + new String( FixUtils.trim(getExchangeRule()) ) + "\n" ; 
		if (hasTradeAllocIndicator()) s += "TradeAllocIndicator(826)= " + getTradeAllocIndicator() + "\n" ; 
		if (hasPreallocMethod()) s += "PreallocMethod(591)= " + getPreallocMethod() + "\n" ; 
		if (hasAllocID()) s += "AllocID(70)= " + new String( FixUtils.trim(getAllocID()) ) + "\n" ; 
		if (hasSideGrossTradeAmt()) s += "SideGrossTradeAmt(1072)= " + getSideGrossTradeAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAggressorIndicator()) s += "AggressorIndicator(1057)= " + getAggressorIndicator() + "\n" ; 
		if (hasSideLastQty()) s += "SideLastQty(1009)= " + getSideLastQty() + "\n" ; 
		if (hasSideTradeReportID()) s += "SideTradeReportID(1005)= " + new String( FixUtils.trim(getSideTradeReportID()) ) + "\n" ; 
		if (hasSideFillStationCd()) s += "SideFillStationCd(1006)= " + new String( FixUtils.trim(getSideFillStationCd()) ) + "\n" ; 
		if (hasSideReasonCd()) s += "SideReasonCd(1007)= " + new String( FixUtils.trim(getSideReasonCd()) ) + "\n" ; 
		if (hasRptSeq()) s += "RptSeq(83)= " + getRptSeq() + "\n" ; 
		if (hasSideTrdSubTyp()) s += "SideTrdSubTyp(1008)= " + getSideTrdSubTyp() + "\n" ; 
		if (hasOrderCategory()) s += "OrderCategory(1115)= " + getOrderCategory() + "\n" ; 

		for (FixParties fixParties : parties) fixParties.toString();
		for (FixClrInstGrp fixClrInstGrp : clrInstGrp) fixClrInstGrp.toString();
		s += commissionData.toString();
		for (FixContAmtGrp fixContAmtGrp : contAmtGrp) fixContAmtGrp.toString();
		for (FixStipulations fixStipulations : stipulations) fixStipulations.toString();
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) fixMiscFeesGrp.toString();
		for (FixSettlDetails fixSettlDetails : settlDetails) fixSettlDetails.toString();
		for (FixTrdAllocGrp fixTrdAllocGrp : trdAllocGrp) fixTrdAllocGrp.toString();
		for (FixSideTrdRegTS fixSideTrdRegTS : sideTrdRegTS) fixSideTrdRegTS.toString();
		s += tradeReportOrderDetail.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTrdCapRptAckSideGrp)) return false;

		FixTrdCapRptAckSideGrp msg = (FixTrdCapRptAckSideGrp) o;

		for (FixParties fixParties : parties)
			if (!fixParties.equals(msg.parties)) return false;
		for (FixClrInstGrp fixClrInstGrp : clrInstGrp)
			if (!fixClrInstGrp.equals(msg.clrInstGrp)) return false;
		if (!commissionData.equals(msg.commissionData)) return false;
		for (FixContAmtGrp fixContAmtGrp : contAmtGrp)
			if (!fixContAmtGrp.equals(msg.contAmtGrp)) return false;
		for (FixStipulations fixStipulations : stipulations)
			if (!fixStipulations.equals(msg.stipulations)) return false;
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp)
			if (!fixMiscFeesGrp.equals(msg.miscFeesGrp)) return false;
		for (FixSettlDetails fixSettlDetails : settlDetails)
			if (!fixSettlDetails.equals(msg.settlDetails)) return false;
		for (FixTrdAllocGrp fixTrdAllocGrp : trdAllocGrp)
			if (!fixTrdAllocGrp.equals(msg.trdAllocGrp)) return false;
		for (FixSideTrdRegTS fixSideTrdRegTS : sideTrdRegTS)
			if (!fixSideTrdRegTS.equals(msg.sideTrdRegTS)) return false;
		if (!tradeReportOrderDetail.equals(msg.tradeReportOrderDetail)) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasSideExecID() && !msg.hasSideExecID()) || (!hasSideExecID() && msg.hasSideExecID())) return false;
		if (!(!hasSideExecID() && !msg.hasSideExecID()) && !FixUtils.equals(getSideExecID(), msg.getSideExecID())) return false;
		if ((hasOrderDelay() && !msg.hasOrderDelay()) || (!hasOrderDelay() && msg.hasOrderDelay())) return false;
		if (!(!hasOrderDelay() && !msg.hasOrderDelay()) && !(getOrderDelay()==msg.getOrderDelay())) return false;
		if ((hasOrderDelayUnit() && !msg.hasOrderDelayUnit()) || (!hasOrderDelayUnit() && msg.hasOrderDelayUnit())) return false;
		if (!(!hasOrderDelayUnit() && !msg.hasOrderDelayUnit()) && !(getOrderDelayUnit()==msg.getOrderDelayUnit())) return false;
		if ((hasAccount() && !msg.hasAccount()) || (!hasAccount() && msg.hasAccount())) return false;
		if (!(!hasAccount() && !msg.hasAccount()) && !FixUtils.equals(getAccount(), msg.getAccount())) return false;
		if ((hasAcctIDSource() && !msg.hasAcctIDSource()) || (!hasAcctIDSource() && msg.hasAcctIDSource())) return false;
		if (!(!hasAcctIDSource() && !msg.hasAcctIDSource()) && !(getAcctIDSource()==msg.getAcctIDSource())) return false;
		if ((hasAccountType() && !msg.hasAccountType()) || (!hasAccountType() && msg.hasAccountType())) return false;
		if (!(!hasAccountType() && !msg.hasAccountType()) && !(getAccountType()==msg.getAccountType())) return false;
		if ((hasProcessCode() && !msg.hasProcessCode()) || (!hasProcessCode() && msg.hasProcessCode())) return false;
		if (!(!hasProcessCode() && !msg.hasProcessCode()) && !(getProcessCode()==msg.getProcessCode())) return false;
		if ((hasOddLot() && !msg.hasOddLot()) || (!hasOddLot() && msg.hasOddLot())) return false;
		if (!(!hasOddLot() && !msg.hasOddLot()) && !(getOddLot()==msg.getOddLot())) return false;
		if ((hasTradeInputSource() && !msg.hasTradeInputSource()) || (!hasTradeInputSource() && msg.hasTradeInputSource())) return false;
		if (!(!hasTradeInputSource() && !msg.hasTradeInputSource()) && !FixUtils.equals(getTradeInputSource(), msg.getTradeInputSource())) return false;
		if ((hasTradeInputDevice() && !msg.hasTradeInputDevice()) || (!hasTradeInputDevice() && msg.hasTradeInputDevice())) return false;
		if (!(!hasTradeInputDevice() && !msg.hasTradeInputDevice()) && !FixUtils.equals(getTradeInputDevice(), msg.getTradeInputDevice())) return false;
		if ((hasComplianceID() && !msg.hasComplianceID()) || (!hasComplianceID() && msg.hasComplianceID())) return false;
		if (!(!hasComplianceID() && !msg.hasComplianceID()) && !FixUtils.equals(getComplianceID(), msg.getComplianceID())) return false;
		if ((hasSolicitedFlag() && !msg.hasSolicitedFlag()) || (!hasSolicitedFlag() && msg.hasSolicitedFlag())) return false;
		if (!(!hasSolicitedFlag() && !msg.hasSolicitedFlag()) && !(getSolicitedFlag()==msg.getSolicitedFlag())) return false;
		if ((hasCustOrderCapacity() && !msg.hasCustOrderCapacity()) || (!hasCustOrderCapacity() && msg.hasCustOrderCapacity())) return false;
		if (!(!hasCustOrderCapacity() && !msg.hasCustOrderCapacity()) && !(getCustOrderCapacity()==msg.getCustOrderCapacity())) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		if ((hasTimeBracket() && !msg.hasTimeBracket()) || (!hasTimeBracket() && msg.hasTimeBracket())) return false;
		if (!(!hasTimeBracket() && !msg.hasTimeBracket()) && !FixUtils.equals(getTimeBracket(), msg.getTimeBracket())) return false;
		if ((hasNetGrossInd() && !msg.hasNetGrossInd()) || (!hasNetGrossInd() && msg.hasNetGrossInd())) return false;
		if (!(!hasNetGrossInd() && !msg.hasNetGrossInd()) && !(getNetGrossInd()==msg.getNetGrossInd())) return false;
		if ((hasSideCurrency() && !msg.hasSideCurrency()) || (!hasSideCurrency() && msg.hasSideCurrency())) return false;
		if (!(!hasSideCurrency() && !msg.hasSideCurrency()) && !FixUtils.equals(getSideCurrency(), msg.getSideCurrency())) return false;
		if ((hasSideSettlCurrency() && !msg.hasSideSettlCurrency()) || (!hasSideSettlCurrency() && msg.hasSideSettlCurrency())) return false;
		if (!(!hasSideSettlCurrency() && !msg.hasSideSettlCurrency()) && !FixUtils.equals(getSideSettlCurrency(), msg.getSideSettlCurrency())) return false;
		if ((hasNumDaysInterest() && !msg.hasNumDaysInterest()) || (!hasNumDaysInterest() && msg.hasNumDaysInterest())) return false;
		if (!(!hasNumDaysInterest() && !msg.hasNumDaysInterest()) && !(getNumDaysInterest()==msg.getNumDaysInterest())) return false;
		if ((hasExDate() && !msg.hasExDate()) || (!hasExDate() && msg.hasExDate())) return false;
		if (!(!hasExDate() && !msg.hasExDate()) ) return false;
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
		if ((hasSettlCurrAmt() && !msg.hasSettlCurrAmt()) || (!hasSettlCurrAmt() && msg.hasSettlCurrAmt())) return false;
		if (!(!hasSettlCurrAmt() && !msg.hasSettlCurrAmt()) && !(getSettlCurrAmt()==msg.getSettlCurrAmt())) return false;
		if ((hasSettlCurrFxRate() && !msg.hasSettlCurrFxRate()) || (!hasSettlCurrFxRate() && msg.hasSettlCurrFxRate())) return false;
		if (!(!hasSettlCurrFxRate() && !msg.hasSettlCurrFxRate()) && !(getSettlCurrFxRate()==msg.getSettlCurrFxRate())) return false;
		if ((hasSettlCurrFxRateCalc() && !msg.hasSettlCurrFxRateCalc()) || (!hasSettlCurrFxRateCalc() && msg.hasSettlCurrFxRateCalc())) return false;
		if (!(!hasSettlCurrFxRateCalc() && !msg.hasSettlCurrFxRateCalc()) && !(getSettlCurrFxRateCalc()==msg.getSettlCurrFxRateCalc())) return false;
		if ((hasPositionEffect() && !msg.hasPositionEffect()) || (!hasPositionEffect() && msg.hasPositionEffect())) return false;
		if (!(!hasPositionEffect() && !msg.hasPositionEffect()) && !(getPositionEffect()==msg.getPositionEffect())) return false;
		if ((hasSideMultiLegReportingType() && !msg.hasSideMultiLegReportingType()) || (!hasSideMultiLegReportingType() && msg.hasSideMultiLegReportingType())) return false;
		if (!(!hasSideMultiLegReportingType() && !msg.hasSideMultiLegReportingType()) && !(getSideMultiLegReportingType()==msg.getSideMultiLegReportingType())) return false;
		if ((hasExchangeRule() && !msg.hasExchangeRule()) || (!hasExchangeRule() && msg.hasExchangeRule())) return false;
		if (!(!hasExchangeRule() && !msg.hasExchangeRule()) && !FixUtils.equals(getExchangeRule(), msg.getExchangeRule())) return false;
		if ((hasTradeAllocIndicator() && !msg.hasTradeAllocIndicator()) || (!hasTradeAllocIndicator() && msg.hasTradeAllocIndicator())) return false;
		if (!(!hasTradeAllocIndicator() && !msg.hasTradeAllocIndicator()) && !(getTradeAllocIndicator()==msg.getTradeAllocIndicator())) return false;
		if ((hasPreallocMethod() && !msg.hasPreallocMethod()) || (!hasPreallocMethod() && msg.hasPreallocMethod())) return false;
		if (!(!hasPreallocMethod() && !msg.hasPreallocMethod()) && !(getPreallocMethod()==msg.getPreallocMethod())) return false;
		if ((hasAllocID() && !msg.hasAllocID()) || (!hasAllocID() && msg.hasAllocID())) return false;
		if (!(!hasAllocID() && !msg.hasAllocID()) && !FixUtils.equals(getAllocID(), msg.getAllocID())) return false;
		if ((hasSideGrossTradeAmt() && !msg.hasSideGrossTradeAmt()) || (!hasSideGrossTradeAmt() && msg.hasSideGrossTradeAmt())) return false;
		if (!(!hasSideGrossTradeAmt() && !msg.hasSideGrossTradeAmt()) && !(getSideGrossTradeAmt()==msg.getSideGrossTradeAmt())) return false;
		if ((hasAggressorIndicator() && !msg.hasAggressorIndicator()) || (!hasAggressorIndicator() && msg.hasAggressorIndicator())) return false;
		if (!(!hasAggressorIndicator() && !msg.hasAggressorIndicator()) && !(getAggressorIndicator()==msg.getAggressorIndicator())) return false;
		if ((hasSideLastQty() && !msg.hasSideLastQty()) || (!hasSideLastQty() && msg.hasSideLastQty())) return false;
		if (!(!hasSideLastQty() && !msg.hasSideLastQty()) && !(getSideLastQty()==msg.getSideLastQty())) return false;
		if ((hasSideTradeReportID() && !msg.hasSideTradeReportID()) || (!hasSideTradeReportID() && msg.hasSideTradeReportID())) return false;
		if (!(!hasSideTradeReportID() && !msg.hasSideTradeReportID()) && !FixUtils.equals(getSideTradeReportID(), msg.getSideTradeReportID())) return false;
		if ((hasSideFillStationCd() && !msg.hasSideFillStationCd()) || (!hasSideFillStationCd() && msg.hasSideFillStationCd())) return false;
		if (!(!hasSideFillStationCd() && !msg.hasSideFillStationCd()) && !FixUtils.equals(getSideFillStationCd(), msg.getSideFillStationCd())) return false;
		if ((hasSideReasonCd() && !msg.hasSideReasonCd()) || (!hasSideReasonCd() && msg.hasSideReasonCd())) return false;
		if (!(!hasSideReasonCd() && !msg.hasSideReasonCd()) && !FixUtils.equals(getSideReasonCd(), msg.getSideReasonCd())) return false;
		if ((hasRptSeq() && !msg.hasRptSeq()) || (!hasRptSeq() && msg.hasRptSeq())) return false;
		if (!(!hasRptSeq() && !msg.hasRptSeq()) && !(getRptSeq()==msg.getRptSeq())) return false;
		if ((hasSideTrdSubTyp() && !msg.hasSideTrdSubTyp()) || (!hasSideTrdSubTyp() && msg.hasSideTrdSubTyp())) return false;
		if (!(!hasSideTrdSubTyp() && !msg.hasSideTrdSubTyp()) && !(getSideTrdSubTyp()==msg.getSideTrdSubTyp())) return false;
		if ((hasOrderCategory() && !msg.hasOrderCategory()) || (!hasOrderCategory() && msg.hasOrderCategory())) return false;
		if (!(!hasOrderCategory() && !msg.hasOrderCategory()) && !(getOrderCategory()==msg.getOrderCategory())) return false;
		return true;
	}
	public FixTrdCapRptAckSideGrp clone ( FixTrdCapRptAckSideGrp out ) {
		if ( hasSide())
			out.setSide(getSide());
		if ( hasSideExecID())
			out.setSideExecID(getSideExecID());
		if ( hasOrderDelay())
			out.setOrderDelay(getOrderDelay());
		if ( hasOrderDelayUnit())
			out.setOrderDelayUnit(getOrderDelayUnit());
		if ( hasAccount())
			out.setAccount(getAccount());
		if ( hasAcctIDSource())
			out.setAcctIDSource(getAcctIDSource());
		if ( hasAccountType())
			out.setAccountType(getAccountType());
		if ( hasProcessCode())
			out.setProcessCode(getProcessCode());
		if ( hasOddLot())
			out.setOddLot(getOddLot());
		if ( hasTradeInputSource())
			out.setTradeInputSource(getTradeInputSource());
		if ( hasTradeInputDevice())
			out.setTradeInputDevice(getTradeInputDevice());
		if ( hasComplianceID())
			out.setComplianceID(getComplianceID());
		if ( hasSolicitedFlag())
			out.setSolicitedFlag(getSolicitedFlag());
		if ( hasCustOrderCapacity())
			out.setCustOrderCapacity(getCustOrderCapacity());
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		if ( hasTimeBracket())
			out.setTimeBracket(getTimeBracket());
		if ( hasNetGrossInd())
			out.setNetGrossInd(getNetGrossInd());
		if ( hasSideCurrency())
			out.setSideCurrency(getSideCurrency());
		if ( hasSideSettlCurrency())
			out.setSideSettlCurrency(getSideSettlCurrency());
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
		if ( hasSettlCurrAmt())
			out.setSettlCurrAmt(getSettlCurrAmt());
		if ( hasSettlCurrFxRate())
			out.setSettlCurrFxRate(getSettlCurrFxRate());
		if ( hasSettlCurrFxRateCalc())
			out.setSettlCurrFxRateCalc(getSettlCurrFxRateCalc());
		if ( hasPositionEffect())
			out.setPositionEffect(getPositionEffect());
		if ( hasSideMultiLegReportingType())
			out.setSideMultiLegReportingType(getSideMultiLegReportingType());
		if ( hasExchangeRule())
			out.setExchangeRule(getExchangeRule());
		if ( hasTradeAllocIndicator())
			out.setTradeAllocIndicator(getTradeAllocIndicator());
		if ( hasPreallocMethod())
			out.setPreallocMethod(getPreallocMethod());
		if ( hasAllocID())
			out.setAllocID(getAllocID());
		if ( hasSideGrossTradeAmt())
			out.setSideGrossTradeAmt(getSideGrossTradeAmt());
		if ( hasAggressorIndicator())
			out.setAggressorIndicator(getAggressorIndicator());
		if ( hasSideLastQty())
			out.setSideLastQty(getSideLastQty());
		if ( hasSideTradeReportID())
			out.setSideTradeReportID(getSideTradeReportID());
		if ( hasSideFillStationCd())
			out.setSideFillStationCd(getSideFillStationCd());
		if ( hasSideReasonCd())
			out.setSideReasonCd(getSideReasonCd());
		if ( hasRptSeq())
			out.setRptSeq(getRptSeq());
		if ( hasSideTrdSubTyp())
			out.setSideTrdSubTyp(getSideTrdSubTyp());
		if ( hasOrderCategory())
			out.setOrderCategory(getOrderCategory());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixClrInstGrp fixClrInstGrp : clrInstGrp) {
			if (!fixClrInstGrp.hasGroup()) continue;
			out.clrInstGrp[count] = fixClrInstGrp.clone( out.clrInstGrp[count] );
			count++;
		}
		if (commissionData.hasGroup())
			out.commissionData = commissionData.clone( out.commissionData);
		count = 0;
		for (FixContAmtGrp fixContAmtGrp : contAmtGrp) {
			if (!fixContAmtGrp.hasGroup()) continue;
			out.contAmtGrp[count] = fixContAmtGrp.clone( out.contAmtGrp[count] );
			count++;
		}
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
		count = 0;
		for (FixSettlDetails fixSettlDetails : settlDetails) {
			if (!fixSettlDetails.hasGroup()) continue;
			out.settlDetails[count] = fixSettlDetails.clone( out.settlDetails[count] );
			count++;
		}
		count = 0;
		for (FixTrdAllocGrp fixTrdAllocGrp : trdAllocGrp) {
			if (!fixTrdAllocGrp.hasGroup()) continue;
			out.trdAllocGrp[count] = fixTrdAllocGrp.clone( out.trdAllocGrp[count] );
			count++;
		}
		count = 0;
		for (FixSideTrdRegTS fixSideTrdRegTS : sideTrdRegTS) {
			if (!fixSideTrdRegTS.hasGroup()) continue;
			out.sideTrdRegTS[count] = fixSideTrdRegTS.clone( out.sideTrdRegTS[count] );
			count++;
		}
		if (tradeReportOrderDetail.hasGroup())
			out.tradeReportOrderDetail = tradeReportOrderDetail.clone( out.tradeReportOrderDetail);
		return out;
	}

}
