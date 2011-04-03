package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixUnderlyingInstrument extends FixGroup {
	private short hasUnderlyingSymbol;
	byte[] underlyingSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingSymbolSfx;
	byte[] underlyingSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingSecurityID;
	byte[] underlyingSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingSecurityIDSource;
	byte[] underlyingSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingProduct;
	long underlyingProduct = 0;		
	private short hasUnderlyingCFICode;
	byte[] underlyingCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingSecurityType;
	byte[] underlyingSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingSecuritySubType;
	byte[] underlyingSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingMaturityMonthYear;
	byte[] underlyingMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingMaturityDate;
	byte[] underlyingMaturityDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingMaturityTime;
	byte[] underlyingMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingCouponPaymentDate;
	byte[] underlyingCouponPaymentDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingRestructuringType;
	byte[] underlyingRestructuringType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingSeniority;
	byte[] underlyingSeniority = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingNotionalPercentageOutstanding;
	long underlyingNotionalPercentageOutstanding = 0;		
	private short hasUnderlyingOriginalNotionalPercentageOutstanding;
	long underlyingOriginalNotionalPercentageOutstanding = 0;		
	private short hasUnderlyingAttachmentPoint;
	long underlyingAttachmentPoint = 0;		
	private short hasUnderlyingDetachmentPoint;
	long underlyingDetachmentPoint = 0;		
	private short hasUnderlyingIssueDate;
	byte[] underlyingIssueDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingRepoCollateralSecurityType;
	long underlyingRepoCollateralSecurityType = 0;		
	private short hasUnderlyingRepurchaseTerm;
	long underlyingRepurchaseTerm = 0;		
	private short hasUnderlyingRepurchaseRate;
	long underlyingRepurchaseRate = 0;		
	private short hasUnderlyingFactor;
	long underlyingFactor = 0;		
	private short hasUnderlyingCreditRating;
	byte[] underlyingCreditRating = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingInstrRegistry;
	byte[] underlyingInstrRegistry = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingCountryOfIssue;
	byte[] underlyingCountryOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingStateOrProvinceOfIssue;
	byte[] underlyingStateOrProvinceOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLocaleOfIssue;
	byte[] underlyingLocaleOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingRedemptionDate;
	byte[] underlyingRedemptionDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingStrikePrice;
	long underlyingStrikePrice = 0;		
	private short hasUnderlyingStrikeCurrency;
	byte[] underlyingStrikeCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasUnderlyingOptAttribute;
	byte underlyingOptAttribute = (byte)' ';		
	private short hasUnderlyingContractMultiplier;
	long underlyingContractMultiplier = 0;		
	private short hasUnderlyingUnitOfMeasure;
	byte[] underlyingUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingTimeUnit;
	byte[] underlyingTimeUnit = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingExerciseStyle;
	long underlyingExerciseStyle = 0;		
	private short hasUnderlyingUnitOfMeasureQty;
	long underlyingUnitOfMeasureQty = 0;		
	private short hasUnderlyingPriceUnitOfMeasure;
	byte[] underlyingPriceUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingPriceUnitOfMeasureQty;
	long underlyingPriceUnitOfMeasureQty = 0;		
	private short hasUnderlyingContractMultiplierUnit;
	long underlyingContractMultiplierUnit = 0;		
	private short hasUnderlyingFlowScheduleType;
	long underlyingFlowScheduleType = 0;		
	private short hasUnderlyingCouponRate;
	long underlyingCouponRate = 0;		
	private short hasUnderlyingSecurityExchange;
	byte[] underlyingSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingIssuer;
	byte[] underlyingIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEncodedUnderlyingIssuerLen;
	long encodedUnderlyingIssuerLen = 0;		
	private short hasEncodedUnderlyingIssuer;
	byte[] encodedUnderlyingIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingSecurityDesc;
	byte[] underlyingSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEncodedUnderlyingSecurityDescLen;
	long encodedUnderlyingSecurityDescLen = 0;		
	private short hasEncodedUnderlyingSecurityDesc;
	byte[] encodedUnderlyingSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingCPProgram;
	byte[] underlyingCPProgram = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingCPRegType;
	byte[] underlyingCPRegType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingAllocationPercent;
	long underlyingAllocationPercent = 0;		
	private short hasUnderlyingCurrency;
	byte[] underlyingCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasUnderlyingQty;
	long underlyingQty = 0;		
	private short hasUnderlyingSettlementType;
	long underlyingSettlementType = 0;		
	private short hasUnderlyingCashAmount;
	long underlyingCashAmount = 0;		
	private short hasUnderlyingCashType;
	byte[] underlyingCashType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingPx;
	long underlyingPx = 0;		
	private short hasUnderlyingDirtyPrice;
	long underlyingDirtyPrice = 0;		
	private short hasUnderlyingEndPrice;
	long underlyingEndPrice = 0;		
	private short hasUnderlyingStartValue;
	long underlyingStartValue = 0;		
	private short hasUnderlyingCurrentValue;
	long underlyingCurrentValue = 0;		
	private short hasUnderlyingEndValue;
	long underlyingEndValue = 0;		
	private short hasUnderlyingAdjustedQuantity;
	long underlyingAdjustedQuantity = 0;		
	private short hasUnderlyingFXRate;
	long underlyingFXRate = 0;		
	private short hasUnderlyingFXRateCalc;
	byte underlyingFXRateCalc = (byte)' ';		
	private short hasUnderlyingCapValue;
	long underlyingCapValue = 0;		
	private short hasUnderlyingSettlMethod;
	byte[] underlyingSettlMethod = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingPutOrCall;
	long underlyingPutOrCall = 0;		
		public FixUndSecAltIDGrp[] undSecAltIDGrp;
		public FixUnderlyingStipulations[] underlyingStipulations;
		public FixUndlyInstrumentParties[] undlyInstrumentParties;
	
	public FixUnderlyingInstrument() {
		this(false);
	}

	public FixUnderlyingInstrument(boolean isRequired) {
		super(FixTags.UNDERLYINGSYMBOL_INT);

		this.isRequired = isRequired;
		
		hasUnderlyingSymbol = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingSecurityID = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingProduct = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingCFICode = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingMaturityDate = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingMaturityDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingMaturityTime = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingCouponPaymentDate = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCouponPaymentDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingRestructuringType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingRestructuringType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingSeniority = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSeniority = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingAttachmentPoint = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingDetachmentPoint = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingIssueDate = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingIssueDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingRepoCollateralSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingRepurchaseTerm = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingRepurchaseRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingFactor = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingCreditRating = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCreditRating = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingInstrRegistry = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingInstrRegistry = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingCountryOfIssue = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCountryOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingStateOrProvinceOfIssue = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingStateOrProvinceOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLocaleOfIssue = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLocaleOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingRedemptionDate = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingRedemptionDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingStrikeCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingStrikeCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasUnderlyingOptAttribute = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingTimeUnit = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingTimeUnit = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingPriceUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingPriceUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingPriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingIssuer = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEncodedUnderlyingIssuerLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedUnderlyingIssuer = FixUtils.TAG_HAS_NO_VALUE;		
		encodedUnderlyingIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEncodedUnderlyingSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedUnderlyingSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		encodedUnderlyingSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingCPProgram = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCPProgram = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingCPRegType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCPRegType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingAllocationPercent = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasUnderlyingQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingSettlementType = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingCashAmount = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingCashType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCashType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingDirtyPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingEndPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingStartValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingCurrentValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingEndValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingAdjustedQuantity = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingFXRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingFXRateCalc = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingCapValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingSettlMethod = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSettlMethod = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		undSecAltIDGrp = new FixUndSecAltIDGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undSecAltIDGrp[i] = new FixUndSecAltIDGrp();
		underlyingStipulations = new FixUnderlyingStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) underlyingStipulations[i] = new FixUnderlyingStipulations();
		undlyInstrumentParties = new FixUndlyInstrumentParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undlyInstrumentParties[i] = new FixUndlyInstrumentParties();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasUnderlyingSymbol()) return true;
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
            	case FixTags.UNDERLYINGSYMBOL_INT:		
            		hasUnderlyingSymbol = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSYMBOLSFX_INT:		
            		hasUnderlyingSymbolSfx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSECURITYID_INT:		
            		hasUnderlyingSecurityID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSECURITYIDSOURCE_INT:		
            		hasUnderlyingSecurityIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGPRODUCT_INT:		
            		hasUnderlyingProduct = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCFICODE_INT:		
            		hasUnderlyingCFICode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSECURITYTYPE_INT:		
            		hasUnderlyingSecurityType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSECURITYSUBTYPE_INT:		
            		hasUnderlyingSecuritySubType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGMATURITYMONTHYEAR_INT:		
            		hasUnderlyingMaturityMonthYear = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGMATURITYDATE_INT:		
            		hasUnderlyingMaturityDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGMATURITYTIME_INT:		
            		hasUnderlyingMaturityTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCOUPONPAYMENTDATE_INT:		
            		hasUnderlyingCouponPaymentDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGRESTRUCTURINGTYPE_INT:		
            		hasUnderlyingRestructuringType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSENIORITY_INT:		
            		hasUnderlyingSeniority = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGNOTIONALPERCENTAGEOUTSTANDING_INT:		
            		hasUnderlyingNotionalPercentageOutstanding = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGORIGINALNOTIONALPERCENTAGEOUTSTANDING_INT:		
            		hasUnderlyingOriginalNotionalPercentageOutstanding = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGATTACHMENTPOINT_INT:		
            		hasUnderlyingAttachmentPoint = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGDETACHMENTPOINT_INT:		
            		hasUnderlyingDetachmentPoint = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGISSUEDATE_INT:		
            		hasUnderlyingIssueDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGREPOCOLLATERALSECURITYTYPE_INT:		
            		hasUnderlyingRepoCollateralSecurityType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGREPURCHASETERM_INT:		
            		hasUnderlyingRepurchaseTerm = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGREPURCHASERATE_INT:		
            		hasUnderlyingRepurchaseRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGFACTOR_INT:		
            		hasUnderlyingFactor = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCREDITRATING_INT:		
            		hasUnderlyingCreditRating = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGINSTRREGISTRY_INT:		
            		hasUnderlyingInstrRegistry = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCOUNTRYOFISSUE_INT:		
            		hasUnderlyingCountryOfIssue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSTATEORPROVINCEOFISSUE_INT:		
            		hasUnderlyingStateOrProvinceOfIssue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLOCALEOFISSUE_INT:		
            		hasUnderlyingLocaleOfIssue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGREDEMPTIONDATE_INT:		
            		hasUnderlyingRedemptionDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSTRIKEPRICE_INT:		
            		hasUnderlyingStrikePrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSTRIKECURRENCY_INT:		
            		hasUnderlyingStrikeCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGOPTATTRIBUTE_INT:		
            		hasUnderlyingOptAttribute = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCONTRACTMULTIPLIER_INT:		
            		hasUnderlyingContractMultiplier = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGUNITOFMEASURE_INT:		
            		hasUnderlyingUnitOfMeasure = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGTIMEUNIT_INT:		
            		hasUnderlyingTimeUnit = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGEXERCISESTYLE_INT:		
            		hasUnderlyingExerciseStyle = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGUNITOFMEASUREQTY_INT:		
            		hasUnderlyingUnitOfMeasureQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGPRICEUNITOFMEASURE_INT:		
            		hasUnderlyingPriceUnitOfMeasure = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGPRICEUNITOFMEASUREQTY_INT:		
            		hasUnderlyingPriceUnitOfMeasureQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCONTRACTMULTIPLIERUNIT_INT:		
            		hasUnderlyingContractMultiplierUnit = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGFLOWSCHEDULETYPE_INT:		
            		hasUnderlyingFlowScheduleType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCOUPONRATE_INT:		
            		hasUnderlyingCouponRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSECURITYEXCHANGE_INT:		
            		hasUnderlyingSecurityExchange = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGISSUER_INT:		
            		hasUnderlyingIssuer = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDUNDERLYINGISSUERLEN_INT:		
            		hasEncodedUnderlyingIssuerLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDUNDERLYINGISSUER_INT:		
            		hasEncodedUnderlyingIssuer = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSECURITYDESC_INT:		
            		hasUnderlyingSecurityDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDUNDERLYINGSECURITYDESCLEN_INT:		
            		hasEncodedUnderlyingSecurityDescLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDUNDERLYINGSECURITYDESC_INT:		
            		hasEncodedUnderlyingSecurityDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCPPROGRAM_INT:		
            		hasUnderlyingCPProgram = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCPREGTYPE_INT:		
            		hasUnderlyingCPRegType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGALLOCATIONPERCENT_INT:		
            		hasUnderlyingAllocationPercent = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCURRENCY_INT:		
            		hasUnderlyingCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGQTY_INT:		
            		hasUnderlyingQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSETTLEMENTTYPE_INT:		
            		hasUnderlyingSettlementType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCASHAMOUNT_INT:		
            		hasUnderlyingCashAmount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCASHTYPE_INT:		
            		hasUnderlyingCashType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGPX_INT:		
            		hasUnderlyingPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGDIRTYPRICE_INT:		
            		hasUnderlyingDirtyPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGENDPRICE_INT:		
            		hasUnderlyingEndPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSTARTVALUE_INT:		
            		hasUnderlyingStartValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCURRENTVALUE_INT:		
            		hasUnderlyingCurrentValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGENDVALUE_INT:		
            		hasUnderlyingEndValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGADJUSTEDQUANTITY_INT:		
            		hasUnderlyingAdjustedQuantity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGFXRATE_INT:		
            		hasUnderlyingFXRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGFXRATECALC_INT:		
            		hasUnderlyingFXRateCalc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCAPVALUE_INT:		
            		hasUnderlyingCapValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSETTLMETHOD_INT:		
            		hasUnderlyingSettlMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGPUTORCALL_INT:		
            		hasUnderlyingPutOrCall = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOUNDERLYINGSECURITYALTID_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !undSecAltIDGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = undSecAltIDGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOUNDERLYINGSTIPS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !underlyingStipulations[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = underlyingStipulations[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOUNDLYINSTRUMENTPARTIES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !undlyInstrumentParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = undlyInstrumentParties[count].setBuffer( repeatingGroupTag, buf, err);	
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
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasUnderlyingSymbol = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSecurityID = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingProduct = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCFICode = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSecurityType = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingMaturityDate = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingMaturityTime = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCouponPaymentDate = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingRestructuringType = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSeniority = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingAttachmentPoint = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingDetachmentPoint = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingIssueDate = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingRepoCollateralSecurityType = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingRepurchaseTerm = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingRepurchaseRate = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingFactor = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCreditRating = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingInstrRegistry = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCountryOfIssue = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingStateOrProvinceOfIssue = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLocaleOfIssue = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingRedemptionDate = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingStrikePrice = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingStrikeCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingOptAttribute = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingTimeUnit = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingPriceUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingPriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCouponRate = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingIssuer = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedUnderlyingIssuerLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedUnderlyingIssuer = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedUnderlyingSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedUnderlyingSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCPProgram = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCPRegType = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingAllocationPercent = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingQty = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSettlementType = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCashAmount = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCashType = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingPx = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingDirtyPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingEndPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingStartValue = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCurrentValue = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingEndValue = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingAdjustedQuantity = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingFXRate = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingFXRateCalc = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCapValue = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSettlMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingPutOrCall = FixUtils.TAG_HAS_NO_VALUE;
		for (FixUndSecAltIDGrp fixUndSecAltIDGrp : undSecAltIDGrp) fixUndSecAltIDGrp.clear();
		for (FixUnderlyingStipulations fixUnderlyingStipulations : underlyingStipulations) fixUnderlyingStipulations.clear();
		for (FixUndlyInstrumentParties fixUndlyInstrumentParties : undlyInstrumentParties) fixUndlyInstrumentParties.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasUnderlyingSymbol()) {		
			out.put(FixTags.UNDERLYINGSYMBOL);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSymbol); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSymbolSfx()) {		
			out.put(FixTags.UNDERLYINGSYMBOLSFX);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSymbolSfx); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSecurityID()) {		
			out.put(FixTags.UNDERLYINGSECURITYID);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSecurityID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSecurityIDSource()) {		
			out.put(FixTags.UNDERLYINGSECURITYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSecurityIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingProduct()) {		
			out.put(FixTags.UNDERLYINGPRODUCT);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingProduct);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCFICode()) {		
			out.put(FixTags.UNDERLYINGCFICODE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingCFICode); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSecurityType()) {		
			out.put(FixTags.UNDERLYINGSECURITYTYPE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSecurityType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSecuritySubType()) {		
			out.put(FixTags.UNDERLYINGSECURITYSUBTYPE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSecuritySubType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingMaturityMonthYear()) {		
			out.put(FixTags.UNDERLYINGMATURITYMONTHYEAR);

			out.put((byte) '=');

			FixUtils.put(out,underlyingMaturityMonthYear); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingMaturityDate()) {		
			out.put(FixTags.UNDERLYINGMATURITYDATE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingMaturityDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingMaturityTime()) {		
			out.put(FixTags.UNDERLYINGMATURITYTIME);

			out.put((byte) '=');

			FixUtils.put(out,underlyingMaturityTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCouponPaymentDate()) {		
			out.put(FixTags.UNDERLYINGCOUPONPAYMENTDATE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingCouponPaymentDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingRestructuringType()) {		
			out.put(FixTags.UNDERLYINGRESTRUCTURINGTYPE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingRestructuringType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSeniority()) {		
			out.put(FixTags.UNDERLYINGSENIORITY);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSeniority); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingNotionalPercentageOutstanding()) {		
			out.put(FixTags.UNDERLYINGNOTIONALPERCENTAGEOUTSTANDING);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingNotionalPercentageOutstanding);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingOriginalNotionalPercentageOutstanding()) {		
			out.put(FixTags.UNDERLYINGORIGINALNOTIONALPERCENTAGEOUTSTANDING);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingOriginalNotionalPercentageOutstanding);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingAttachmentPoint()) {		
			out.put(FixTags.UNDERLYINGATTACHMENTPOINT);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingAttachmentPoint);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingDetachmentPoint()) {		
			out.put(FixTags.UNDERLYINGDETACHMENTPOINT);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingDetachmentPoint);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingIssueDate()) {		
			out.put(FixTags.UNDERLYINGISSUEDATE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingIssueDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingRepoCollateralSecurityType()) {		
			out.put(FixTags.UNDERLYINGREPOCOLLATERALSECURITYTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingRepoCollateralSecurityType);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingRepurchaseTerm()) {		
			out.put(FixTags.UNDERLYINGREPURCHASETERM);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingRepurchaseTerm);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingRepurchaseRate()) {		
			out.put(FixTags.UNDERLYINGREPURCHASERATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingRepurchaseRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingFactor()) {		
			out.put(FixTags.UNDERLYINGFACTOR);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingFactor);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCreditRating()) {		
			out.put(FixTags.UNDERLYINGCREDITRATING);

			out.put((byte) '=');

			FixUtils.put(out,underlyingCreditRating); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingInstrRegistry()) {		
			out.put(FixTags.UNDERLYINGINSTRREGISTRY);

			out.put((byte) '=');

			FixUtils.put(out,underlyingInstrRegistry); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCountryOfIssue()) {		
			out.put(FixTags.UNDERLYINGCOUNTRYOFISSUE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingCountryOfIssue); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingStateOrProvinceOfIssue()) {		
			out.put(FixTags.UNDERLYINGSTATEORPROVINCEOFISSUE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingStateOrProvinceOfIssue); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLocaleOfIssue()) {		
			out.put(FixTags.UNDERLYINGLOCALEOFISSUE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLocaleOfIssue); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingRedemptionDate()) {		
			out.put(FixTags.UNDERLYINGREDEMPTIONDATE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingRedemptionDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingStrikePrice()) {		
			out.put(FixTags.UNDERLYINGSTRIKEPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingStrikePrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingStrikeCurrency()) {		
			out.put(FixTags.UNDERLYINGSTRIKECURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,underlyingStrikeCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingOptAttribute()) {		
			out.put(FixTags.UNDERLYINGOPTATTRIBUTE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingOptAttribute); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingContractMultiplier()) {		
			out.put(FixTags.UNDERLYINGCONTRACTMULTIPLIER);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingContractMultiplier);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingUnitOfMeasure()) {		
			out.put(FixTags.UNDERLYINGUNITOFMEASURE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingUnitOfMeasure); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingTimeUnit()) {		
			out.put(FixTags.UNDERLYINGTIMEUNIT);

			out.put((byte) '=');

			FixUtils.put(out,underlyingTimeUnit); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingExerciseStyle()) {		
			out.put(FixTags.UNDERLYINGEXERCISESTYLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingExerciseStyle);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingUnitOfMeasureQty()) {		
			out.put(FixTags.UNDERLYINGUNITOFMEASUREQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingUnitOfMeasureQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingPriceUnitOfMeasure()) {		
			out.put(FixTags.UNDERLYINGPRICEUNITOFMEASURE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingPriceUnitOfMeasure); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingPriceUnitOfMeasureQty()) {		
			out.put(FixTags.UNDERLYINGPRICEUNITOFMEASUREQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingPriceUnitOfMeasureQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingContractMultiplierUnit()) {		
			out.put(FixTags.UNDERLYINGCONTRACTMULTIPLIERUNIT);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingContractMultiplierUnit);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingFlowScheduleType()) {		
			out.put(FixTags.UNDERLYINGFLOWSCHEDULETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingFlowScheduleType);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCouponRate()) {		
			out.put(FixTags.UNDERLYINGCOUPONRATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingCouponRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSecurityExchange()) {		
			out.put(FixTags.UNDERLYINGSECURITYEXCHANGE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSecurityExchange); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingIssuer()) {		
			out.put(FixTags.UNDERLYINGISSUER);

			out.put((byte) '=');

			FixUtils.put(out,underlyingIssuer); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedUnderlyingIssuerLen()) {		
			out.put(FixTags.ENCODEDUNDERLYINGISSUERLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)encodedUnderlyingIssuerLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedUnderlyingIssuer()) {		
			out.put(FixTags.ENCODEDUNDERLYINGISSUER);

			out.put((byte) '=');

			FixUtils.put(out,encodedUnderlyingIssuer); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSecurityDesc()) {		
			out.put(FixTags.UNDERLYINGSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedUnderlyingSecurityDescLen()) {		
			out.put(FixTags.ENCODEDUNDERLYINGSECURITYDESCLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)encodedUnderlyingSecurityDescLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedUnderlyingSecurityDesc()) {		
			out.put(FixTags.ENCODEDUNDERLYINGSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,encodedUnderlyingSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCPProgram()) {		
			out.put(FixTags.UNDERLYINGCPPROGRAM);

			out.put((byte) '=');

			FixUtils.put(out,underlyingCPProgram); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCPRegType()) {		
			out.put(FixTags.UNDERLYINGCPREGTYPE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingCPRegType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingAllocationPercent()) {		
			out.put(FixTags.UNDERLYINGALLOCATIONPERCENT);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingAllocationPercent);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCurrency()) {		
			out.put(FixTags.UNDERLYINGCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,underlyingCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingQty()) {		
			out.put(FixTags.UNDERLYINGQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSettlementType()) {		
			out.put(FixTags.UNDERLYINGSETTLEMENTTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingSettlementType);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCashAmount()) {		
			out.put(FixTags.UNDERLYINGCASHAMOUNT);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingCashAmount);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCashType()) {		
			out.put(FixTags.UNDERLYINGCASHTYPE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingCashType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingPx()) {		
			out.put(FixTags.UNDERLYINGPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingDirtyPrice()) {		
			out.put(FixTags.UNDERLYINGDIRTYPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingDirtyPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingEndPrice()) {		
			out.put(FixTags.UNDERLYINGENDPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingEndPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingStartValue()) {		
			out.put(FixTags.UNDERLYINGSTARTVALUE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingStartValue);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCurrentValue()) {		
			out.put(FixTags.UNDERLYINGCURRENTVALUE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingCurrentValue);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingEndValue()) {		
			out.put(FixTags.UNDERLYINGENDVALUE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingEndValue);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingAdjustedQuantity()) {		
			out.put(FixTags.UNDERLYINGADJUSTEDQUANTITY);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingAdjustedQuantity);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingFXRate()) {		
			out.put(FixTags.UNDERLYINGFXRATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingFXRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingFXRateCalc()) {		
			out.put(FixTags.UNDERLYINGFXRATECALC);

			out.put((byte) '=');

			FixUtils.put(out,underlyingFXRateCalc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCapValue()) {		
			out.put(FixTags.UNDERLYINGCAPVALUE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingCapValue);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSettlMethod()) {		
			out.put(FixTags.UNDERLYINGSETTLMETHOD);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSettlMethod); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingPutOrCall()) {		
			out.put(FixTags.UNDERLYINGPUTORCALL);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingPutOrCall);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(undSecAltIDGrp)>0) {
			out.put(FixTags.NOUNDERLYINGSECURITYALTID);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undSecAltIDGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndSecAltIDGrp fixUndSecAltIDGrp : undSecAltIDGrp) if (fixUndSecAltIDGrp.hasGroup()) fixUndSecAltIDGrp.encode(out);
		if (FixUtils.getNoInGroup(underlyingStipulations)>0) {
			out.put(FixTags.NOUNDERLYINGSTIPS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(underlyingStipulations));

			out.put(FixUtils.SOH);

		}
		for (FixUnderlyingStipulations fixUnderlyingStipulations : underlyingStipulations) if (fixUnderlyingStipulations.hasGroup()) fixUnderlyingStipulations.encode(out);
		if (FixUtils.getNoInGroup(undlyInstrumentParties)>0) {
			out.put(FixTags.NOUNDLYINSTRUMENTPARTIES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undlyInstrumentParties));

			out.put(FixUtils.SOH);

		}
		for (FixUndlyInstrumentParties fixUndlyInstrumentParties : undlyInstrumentParties) if (fixUndlyInstrumentParties.hasGroup()) fixUndlyInstrumentParties.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasUnderlyingSymbol()) {		
			FixUtils.put(out,underlyingSymbol); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSymbolSfx()) {		
			FixUtils.put(out,underlyingSymbolSfx); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSecurityID()) {		
			FixUtils.put(out,underlyingSecurityID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSecurityIDSource()) {		
			FixUtils.put(out,underlyingSecurityIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingProduct()) {		
			FixUtils.put(out, (long)underlyingProduct);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCFICode()) {		
			FixUtils.put(out,underlyingCFICode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSecurityType()) {		
			FixUtils.put(out,underlyingSecurityType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSecuritySubType()) {		
			FixUtils.put(out,underlyingSecuritySubType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingMaturityMonthYear()) {		
			FixUtils.put(out,underlyingMaturityMonthYear); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingMaturityDate()) {		
			FixUtils.put(out,underlyingMaturityDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingMaturityTime()) {		
			FixUtils.put(out,underlyingMaturityTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCouponPaymentDate()) {		
			FixUtils.put(out,underlyingCouponPaymentDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingRestructuringType()) {		
			FixUtils.put(out,underlyingRestructuringType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSeniority()) {		
			FixUtils.put(out,underlyingSeniority); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingNotionalPercentageOutstanding()) {		
			FixUtils.put(out, (long)underlyingNotionalPercentageOutstanding);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingOriginalNotionalPercentageOutstanding()) {		
			FixUtils.put(out, (long)underlyingOriginalNotionalPercentageOutstanding);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingAttachmentPoint()) {		
			FixUtils.put(out, (long)underlyingAttachmentPoint);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingDetachmentPoint()) {		
			FixUtils.put(out, (long)underlyingDetachmentPoint);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingIssueDate()) {		
			FixUtils.put(out,underlyingIssueDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingRepoCollateralSecurityType()) {		
			FixUtils.put(out, (long)underlyingRepoCollateralSecurityType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingRepurchaseTerm()) {		
			FixUtils.put(out, (long)underlyingRepurchaseTerm);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingRepurchaseRate()) {		
			FixUtils.put(out, (long)underlyingRepurchaseRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingFactor()) {		
			FixUtils.put(out, (long)underlyingFactor);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCreditRating()) {		
			FixUtils.put(out,underlyingCreditRating); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingInstrRegistry()) {		
			FixUtils.put(out,underlyingInstrRegistry); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCountryOfIssue()) {		
			FixUtils.put(out,underlyingCountryOfIssue); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingStateOrProvinceOfIssue()) {		
			FixUtils.put(out,underlyingStateOrProvinceOfIssue); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLocaleOfIssue()) {		
			FixUtils.put(out,underlyingLocaleOfIssue); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingRedemptionDate()) {		
			FixUtils.put(out,underlyingRedemptionDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingStrikePrice()) {		
			FixUtils.put(out, (long)underlyingStrikePrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingStrikeCurrency()) {		
			FixUtils.put(out,underlyingStrikeCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingOptAttribute()) {		
			FixUtils.put(out,underlyingOptAttribute); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingContractMultiplier()) {		
			FixUtils.put(out, (long)underlyingContractMultiplier);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingUnitOfMeasure()) {		
			FixUtils.put(out,underlyingUnitOfMeasure); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingTimeUnit()) {		
			FixUtils.put(out,underlyingTimeUnit); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingExerciseStyle()) {		
			FixUtils.put(out, (long)underlyingExerciseStyle);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingUnitOfMeasureQty()) {		
			FixUtils.put(out, (long)underlyingUnitOfMeasureQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingPriceUnitOfMeasure()) {		
			FixUtils.put(out,underlyingPriceUnitOfMeasure); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingPriceUnitOfMeasureQty()) {		
			FixUtils.put(out, (long)underlyingPriceUnitOfMeasureQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingContractMultiplierUnit()) {		
			FixUtils.put(out, (long)underlyingContractMultiplierUnit);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingFlowScheduleType()) {		
			FixUtils.put(out, (long)underlyingFlowScheduleType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCouponRate()) {		
			FixUtils.put(out, (long)underlyingCouponRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSecurityExchange()) {		
			FixUtils.put(out,underlyingSecurityExchange); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingIssuer()) {		
			FixUtils.put(out,underlyingIssuer); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedUnderlyingIssuerLen()) {		
			FixUtils.put(out, (long)encodedUnderlyingIssuerLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedUnderlyingIssuer()) {		
			FixUtils.put(out,encodedUnderlyingIssuer); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSecurityDesc()) {		
			FixUtils.put(out,underlyingSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedUnderlyingSecurityDescLen()) {		
			FixUtils.put(out, (long)encodedUnderlyingSecurityDescLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedUnderlyingSecurityDesc()) {		
			FixUtils.put(out,encodedUnderlyingSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCPProgram()) {		
			FixUtils.put(out,underlyingCPProgram); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCPRegType()) {		
			FixUtils.put(out,underlyingCPRegType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingAllocationPercent()) {		
			FixUtils.put(out, (long)underlyingAllocationPercent);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCurrency()) {		
			FixUtils.put(out,underlyingCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingQty()) {		
			FixUtils.put(out, (long)underlyingQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSettlementType()) {		
			FixUtils.put(out, (long)underlyingSettlementType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCashAmount()) {		
			FixUtils.put(out, (long)underlyingCashAmount);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCashType()) {		
			FixUtils.put(out,underlyingCashType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingPx()) {		
			FixUtils.put(out, (long)underlyingPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingDirtyPrice()) {		
			FixUtils.put(out, (long)underlyingDirtyPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingEndPrice()) {		
			FixUtils.put(out, (long)underlyingEndPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingStartValue()) {		
			FixUtils.put(out, (long)underlyingStartValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCurrentValue()) {		
			FixUtils.put(out, (long)underlyingCurrentValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingEndValue()) {		
			FixUtils.put(out, (long)underlyingEndValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingAdjustedQuantity()) {		
			FixUtils.put(out, (long)underlyingAdjustedQuantity);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingFXRate()) {		
			FixUtils.put(out, (long)underlyingFXRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingFXRateCalc()) {		
			FixUtils.put(out,underlyingFXRateCalc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCapValue()) {		
			FixUtils.put(out, (long)underlyingCapValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSettlMethod()) {		
			FixUtils.put(out,underlyingSettlMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingPutOrCall()) {		
			FixUtils.put(out, (long)underlyingPutOrCall);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixUndSecAltIDGrp fixUndSecAltIDGrp : undSecAltIDGrp) fixUndSecAltIDGrp.printBuffer(out);
		for (FixUnderlyingStipulations fixUnderlyingStipulations : underlyingStipulations) fixUnderlyingStipulations.printBuffer(out);
		for (FixUndlyInstrumentParties fixUndlyInstrumentParties : undlyInstrumentParties) fixUndlyInstrumentParties.printBuffer(out);
	}

	public byte[] getUnderlyingSymbol() { 		
		if ( hasUnderlyingSymbol()) {		
			if (hasUnderlyingSymbol == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSymbol; 		
			} else {		
		
				buf.position(hasUnderlyingSymbol);		
		
			FixMessage.getTagStringValue(buf, underlyingSymbol, 0, underlyingSymbol.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSymbol);		
					return null;		
				}		
			}		
			hasUnderlyingSymbol = FixUtils.TAG_HAS_VALUE;		
			return underlyingSymbol;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSymbol() { return hasUnderlyingSymbol != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSymbol(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSymbol()) FixUtils.fillSpace(underlyingSymbol);		
		FixUtils.copy(underlyingSymbol, src); 		
		hasUnderlyingSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSymbol(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSymbol()) FixUtils.fillSpace(underlyingSymbol);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSymbol, src); 		
		hasUnderlyingSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingSymbolSfx() { 		
		if ( hasUnderlyingSymbolSfx()) {		
			if (hasUnderlyingSymbolSfx == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSymbolSfx; 		
			} else {		
		
				buf.position(hasUnderlyingSymbolSfx);		
		
			FixMessage.getTagStringValue(buf, underlyingSymbolSfx, 0, underlyingSymbolSfx.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSymbolSfx);		
					return null;		
				}		
			}		
			hasUnderlyingSymbolSfx = FixUtils.TAG_HAS_VALUE;		
			return underlyingSymbolSfx;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSymbolSfx() { return hasUnderlyingSymbolSfx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSymbolSfx(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSymbolSfx()) FixUtils.fillSpace(underlyingSymbolSfx);		
		FixUtils.copy(underlyingSymbolSfx, src); 		
		hasUnderlyingSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSymbolSfx(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSymbolSfx()) FixUtils.fillSpace(underlyingSymbolSfx);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSymbolSfx, src); 		
		hasUnderlyingSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingSecurityID() { 		
		if ( hasUnderlyingSecurityID()) {		
			if (hasUnderlyingSecurityID == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSecurityID; 		
			} else {		
		
				buf.position(hasUnderlyingSecurityID);		
		
			FixMessage.getTagStringValue(buf, underlyingSecurityID, 0, underlyingSecurityID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSecurityID);		
					return null;		
				}		
			}		
			hasUnderlyingSecurityID = FixUtils.TAG_HAS_VALUE;		
			return underlyingSecurityID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSecurityID() { return hasUnderlyingSecurityID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSecurityID(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSecurityID()) FixUtils.fillSpace(underlyingSecurityID);		
		FixUtils.copy(underlyingSecurityID, src); 		
		hasUnderlyingSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSecurityID(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSecurityID()) FixUtils.fillSpace(underlyingSecurityID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSecurityID, src); 		
		hasUnderlyingSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingSecurityIDSource() { 		
		if ( hasUnderlyingSecurityIDSource()) {		
			if (hasUnderlyingSecurityIDSource == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSecurityIDSource; 		
			} else {		
		
				buf.position(hasUnderlyingSecurityIDSource);		
		
			FixMessage.getTagStringValue(buf, underlyingSecurityIDSource, 0, underlyingSecurityIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSecurityIDSource);		
					return null;		
				}		
			}		
			hasUnderlyingSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
			return underlyingSecurityIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSecurityIDSource() { return hasUnderlyingSecurityIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSecurityIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSecurityIDSource()) FixUtils.fillSpace(underlyingSecurityIDSource);		
		FixUtils.copy(underlyingSecurityIDSource, src); 		
		hasUnderlyingSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSecurityIDSource(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSecurityIDSource()) FixUtils.fillSpace(underlyingSecurityIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSecurityIDSource, src); 		
		hasUnderlyingSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingProduct() { 		
		if ( hasUnderlyingProduct()) {		
			if (hasUnderlyingProduct == FixUtils.TAG_HAS_VALUE) {		
				return underlyingProduct; 		
			} else {		
		
				buf.position(hasUnderlyingProduct);		
		
			underlyingProduct = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingProduct);		
					return 0;		
				}		
			}		
			hasUnderlyingProduct = FixUtils.TAG_HAS_VALUE;		
			return underlyingProduct;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingProduct() { return hasUnderlyingProduct != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingProduct(long src) {		
		underlyingProduct = src;
		hasUnderlyingProduct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingProduct(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingProduct()) underlyingProduct = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingProduct = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingProduct(String str) {		
		if (str == null ) return;
		if (hasUnderlyingProduct()) underlyingProduct = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingProduct = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingCFICode() { 		
		if ( hasUnderlyingCFICode()) {		
			if (hasUnderlyingCFICode == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCFICode; 		
			} else {		
		
				buf.position(hasUnderlyingCFICode);		
		
			FixMessage.getTagStringValue(buf, underlyingCFICode, 0, underlyingCFICode.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCFICode);		
					return null;		
				}		
			}		
			hasUnderlyingCFICode = FixUtils.TAG_HAS_VALUE;		
			return underlyingCFICode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingCFICode() { return hasUnderlyingCFICode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCFICode(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCFICode()) FixUtils.fillSpace(underlyingCFICode);		
		FixUtils.copy(underlyingCFICode, src); 		
		hasUnderlyingCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCFICode(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCFICode()) FixUtils.fillSpace(underlyingCFICode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingCFICode, src); 		
		hasUnderlyingCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingSecurityType() { 		
		if ( hasUnderlyingSecurityType()) {		
			if (hasUnderlyingSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSecurityType; 		
			} else {		
		
				buf.position(hasUnderlyingSecurityType);		
		
			FixMessage.getTagStringValue(buf, underlyingSecurityType, 0, underlyingSecurityType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSecurityType);		
					return null;		
				}		
			}		
			hasUnderlyingSecurityType = FixUtils.TAG_HAS_VALUE;		
			return underlyingSecurityType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSecurityType() { return hasUnderlyingSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSecurityType()) FixUtils.fillSpace(underlyingSecurityType);		
		FixUtils.copy(underlyingSecurityType, src); 		
		hasUnderlyingSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSecurityType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSecurityType()) FixUtils.fillSpace(underlyingSecurityType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSecurityType, src); 		
		hasUnderlyingSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingSecuritySubType() { 		
		if ( hasUnderlyingSecuritySubType()) {		
			if (hasUnderlyingSecuritySubType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSecuritySubType; 		
			} else {		
		
				buf.position(hasUnderlyingSecuritySubType);		
		
			FixMessage.getTagStringValue(buf, underlyingSecuritySubType, 0, underlyingSecuritySubType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSecuritySubType);		
					return null;		
				}		
			}		
			hasUnderlyingSecuritySubType = FixUtils.TAG_HAS_VALUE;		
			return underlyingSecuritySubType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSecuritySubType() { return hasUnderlyingSecuritySubType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSecuritySubType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSecuritySubType()) FixUtils.fillSpace(underlyingSecuritySubType);		
		FixUtils.copy(underlyingSecuritySubType, src); 		
		hasUnderlyingSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSecuritySubType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSecuritySubType()) FixUtils.fillSpace(underlyingSecuritySubType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSecuritySubType, src); 		
		hasUnderlyingSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingMaturityMonthYear() { 		
		if ( hasUnderlyingMaturityMonthYear()) {		
			if (hasUnderlyingMaturityMonthYear == FixUtils.TAG_HAS_VALUE) {		
				return underlyingMaturityMonthYear; 		
			} else {		
		
				buf.position(hasUnderlyingMaturityMonthYear);		
		
			FixMessage.getTagStringValue(buf, underlyingMaturityMonthYear, 0, underlyingMaturityMonthYear.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingMaturityMonthYear);		
					return null;		
				}		
			}		
			hasUnderlyingMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
			return underlyingMaturityMonthYear;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingMaturityMonthYear() { return hasUnderlyingMaturityMonthYear != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingMaturityMonthYear(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingMaturityMonthYear()) FixUtils.fillSpace(underlyingMaturityMonthYear);		
		FixUtils.copy(underlyingMaturityMonthYear, src); 		
		hasUnderlyingMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingMaturityMonthYear(String str) {		
		if (str == null ) return;
		if (hasUnderlyingMaturityMonthYear()) FixUtils.fillSpace(underlyingMaturityMonthYear);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingMaturityMonthYear, src); 		
		hasUnderlyingMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingMaturityDate() { 		
		if ( hasUnderlyingMaturityDate()) {		
			if (hasUnderlyingMaturityDate == FixUtils.TAG_HAS_VALUE) {		
				return underlyingMaturityDate; 		
			} else {		
		
				buf.position(hasUnderlyingMaturityDate);		
		
			FixMessage.getTagStringValue(buf, underlyingMaturityDate, 0, underlyingMaturityDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingMaturityDate);		
					return null;		
				}		
			}		
			hasUnderlyingMaturityDate = FixUtils.TAG_HAS_VALUE;		
			return underlyingMaturityDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingMaturityDate() { return hasUnderlyingMaturityDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingMaturityDate(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingMaturityDate()) FixUtils.fillSpace(underlyingMaturityDate);		
		FixUtils.copy(underlyingMaturityDate, src); 		
		hasUnderlyingMaturityDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingMaturityDate(String str) {		
		if (str == null ) return;
		if (hasUnderlyingMaturityDate()) FixUtils.fillSpace(underlyingMaturityDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingMaturityDate, src); 		
		hasUnderlyingMaturityDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingMaturityTime() { 		
		if ( hasUnderlyingMaturityTime()) {		
			if (hasUnderlyingMaturityTime == FixUtils.TAG_HAS_VALUE) {		
				return underlyingMaturityTime; 		
			} else {		
		
				buf.position(hasUnderlyingMaturityTime);		
		
			FixMessage.getTagStringValue(buf, underlyingMaturityTime, 0, underlyingMaturityTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingMaturityTime);		
					return null;		
				}		
			}		
			hasUnderlyingMaturityTime = FixUtils.TAG_HAS_VALUE;		
			return underlyingMaturityTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingMaturityTime() { return hasUnderlyingMaturityTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingMaturityTime(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingMaturityTime()) FixUtils.fillSpace(underlyingMaturityTime);		
		FixUtils.copy(underlyingMaturityTime, src); 		
		hasUnderlyingMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingMaturityTime(String str) {		
		if (str == null ) return;
		if (hasUnderlyingMaturityTime()) FixUtils.fillSpace(underlyingMaturityTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingMaturityTime, src); 		
		hasUnderlyingMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingCouponPaymentDate() { 		
		if ( hasUnderlyingCouponPaymentDate()) {		
			if (hasUnderlyingCouponPaymentDate == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCouponPaymentDate; 		
			} else {		
		
				buf.position(hasUnderlyingCouponPaymentDate);		
		
			FixMessage.getTagStringValue(buf, underlyingCouponPaymentDate, 0, underlyingCouponPaymentDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCouponPaymentDate);		
					return null;		
				}		
			}		
			hasUnderlyingCouponPaymentDate = FixUtils.TAG_HAS_VALUE;		
			return underlyingCouponPaymentDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingCouponPaymentDate() { return hasUnderlyingCouponPaymentDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCouponPaymentDate(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCouponPaymentDate()) FixUtils.fillSpace(underlyingCouponPaymentDate);		
		FixUtils.copy(underlyingCouponPaymentDate, src); 		
		hasUnderlyingCouponPaymentDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCouponPaymentDate(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCouponPaymentDate()) FixUtils.fillSpace(underlyingCouponPaymentDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingCouponPaymentDate, src); 		
		hasUnderlyingCouponPaymentDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingRestructuringType() { 		
		if ( hasUnderlyingRestructuringType()) {		
			if (hasUnderlyingRestructuringType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingRestructuringType; 		
			} else {		
		
				buf.position(hasUnderlyingRestructuringType);		
		
			FixMessage.getTagStringValue(buf, underlyingRestructuringType, 0, underlyingRestructuringType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingRestructuringType);		
					return null;		
				}		
			}		
			hasUnderlyingRestructuringType = FixUtils.TAG_HAS_VALUE;		
			return underlyingRestructuringType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingRestructuringType() { return hasUnderlyingRestructuringType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingRestructuringType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingRestructuringType()) FixUtils.fillSpace(underlyingRestructuringType);		
		FixUtils.copy(underlyingRestructuringType, src); 		
		hasUnderlyingRestructuringType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingRestructuringType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingRestructuringType()) FixUtils.fillSpace(underlyingRestructuringType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingRestructuringType, src); 		
		hasUnderlyingRestructuringType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingSeniority() { 		
		if ( hasUnderlyingSeniority()) {		
			if (hasUnderlyingSeniority == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSeniority; 		
			} else {		
		
				buf.position(hasUnderlyingSeniority);		
		
			FixMessage.getTagStringValue(buf, underlyingSeniority, 0, underlyingSeniority.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSeniority);		
					return null;		
				}		
			}		
			hasUnderlyingSeniority = FixUtils.TAG_HAS_VALUE;		
			return underlyingSeniority;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSeniority() { return hasUnderlyingSeniority != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSeniority(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSeniority()) FixUtils.fillSpace(underlyingSeniority);		
		FixUtils.copy(underlyingSeniority, src); 		
		hasUnderlyingSeniority = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSeniority(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSeniority()) FixUtils.fillSpace(underlyingSeniority);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSeniority, src); 		
		hasUnderlyingSeniority = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingNotionalPercentageOutstanding() { 		
		if ( hasUnderlyingNotionalPercentageOutstanding()) {		
			if (hasUnderlyingNotionalPercentageOutstanding == FixUtils.TAG_HAS_VALUE) {		
				return underlyingNotionalPercentageOutstanding; 		
			} else {		
		
				buf.position(hasUnderlyingNotionalPercentageOutstanding);		
		
			underlyingNotionalPercentageOutstanding = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingNotionalPercentageOutstanding);		
					return 0;		
				}		
			}		
			hasUnderlyingNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
			return underlyingNotionalPercentageOutstanding;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingNotionalPercentageOutstanding() { return hasUnderlyingNotionalPercentageOutstanding != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingNotionalPercentageOutstanding(long src) {		
		underlyingNotionalPercentageOutstanding = src;
		hasUnderlyingNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingNotionalPercentageOutstanding(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingNotionalPercentageOutstanding()) underlyingNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingNotionalPercentageOutstanding = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingNotionalPercentageOutstanding(String str) {		
		if (str == null ) return;
		if (hasUnderlyingNotionalPercentageOutstanding()) underlyingNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingNotionalPercentageOutstanding = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingOriginalNotionalPercentageOutstanding() { 		
		if ( hasUnderlyingOriginalNotionalPercentageOutstanding()) {		
			if (hasUnderlyingOriginalNotionalPercentageOutstanding == FixUtils.TAG_HAS_VALUE) {		
				return underlyingOriginalNotionalPercentageOutstanding; 		
			} else {		
		
				buf.position(hasUnderlyingOriginalNotionalPercentageOutstanding);		
		
			underlyingOriginalNotionalPercentageOutstanding = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingOriginalNotionalPercentageOutstanding);		
					return 0;		
				}		
			}		
			hasUnderlyingOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
			return underlyingOriginalNotionalPercentageOutstanding;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingOriginalNotionalPercentageOutstanding() { return hasUnderlyingOriginalNotionalPercentageOutstanding != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingOriginalNotionalPercentageOutstanding(long src) {		
		underlyingOriginalNotionalPercentageOutstanding = src;
		hasUnderlyingOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingOriginalNotionalPercentageOutstanding(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingOriginalNotionalPercentageOutstanding()) underlyingOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingOriginalNotionalPercentageOutstanding = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingOriginalNotionalPercentageOutstanding(String str) {		
		if (str == null ) return;
		if (hasUnderlyingOriginalNotionalPercentageOutstanding()) underlyingOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingOriginalNotionalPercentageOutstanding = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingAttachmentPoint() { 		
		if ( hasUnderlyingAttachmentPoint()) {		
			if (hasUnderlyingAttachmentPoint == FixUtils.TAG_HAS_VALUE) {		
				return underlyingAttachmentPoint; 		
			} else {		
		
				buf.position(hasUnderlyingAttachmentPoint);		
		
			underlyingAttachmentPoint = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingAttachmentPoint);		
					return 0;		
				}		
			}		
			hasUnderlyingAttachmentPoint = FixUtils.TAG_HAS_VALUE;		
			return underlyingAttachmentPoint;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingAttachmentPoint() { return hasUnderlyingAttachmentPoint != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingAttachmentPoint(long src) {		
		underlyingAttachmentPoint = src;
		hasUnderlyingAttachmentPoint = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingAttachmentPoint(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingAttachmentPoint()) underlyingAttachmentPoint = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingAttachmentPoint = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingAttachmentPoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingAttachmentPoint(String str) {		
		if (str == null ) return;
		if (hasUnderlyingAttachmentPoint()) underlyingAttachmentPoint = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingAttachmentPoint = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingAttachmentPoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingDetachmentPoint() { 		
		if ( hasUnderlyingDetachmentPoint()) {		
			if (hasUnderlyingDetachmentPoint == FixUtils.TAG_HAS_VALUE) {		
				return underlyingDetachmentPoint; 		
			} else {		
		
				buf.position(hasUnderlyingDetachmentPoint);		
		
			underlyingDetachmentPoint = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingDetachmentPoint);		
					return 0;		
				}		
			}		
			hasUnderlyingDetachmentPoint = FixUtils.TAG_HAS_VALUE;		
			return underlyingDetachmentPoint;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingDetachmentPoint() { return hasUnderlyingDetachmentPoint != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingDetachmentPoint(long src) {		
		underlyingDetachmentPoint = src;
		hasUnderlyingDetachmentPoint = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingDetachmentPoint(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingDetachmentPoint()) underlyingDetachmentPoint = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingDetachmentPoint = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingDetachmentPoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingDetachmentPoint(String str) {		
		if (str == null ) return;
		if (hasUnderlyingDetachmentPoint()) underlyingDetachmentPoint = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingDetachmentPoint = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingDetachmentPoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingIssueDate() { 		
		if ( hasUnderlyingIssueDate()) {		
			if (hasUnderlyingIssueDate == FixUtils.TAG_HAS_VALUE) {		
				return underlyingIssueDate; 		
			} else {		
		
				buf.position(hasUnderlyingIssueDate);		
		
			FixMessage.getTagStringValue(buf, underlyingIssueDate, 0, underlyingIssueDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingIssueDate);		
					return null;		
				}		
			}		
			hasUnderlyingIssueDate = FixUtils.TAG_HAS_VALUE;		
			return underlyingIssueDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingIssueDate() { return hasUnderlyingIssueDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingIssueDate(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingIssueDate()) FixUtils.fillSpace(underlyingIssueDate);		
		FixUtils.copy(underlyingIssueDate, src); 		
		hasUnderlyingIssueDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingIssueDate(String str) {		
		if (str == null ) return;
		if (hasUnderlyingIssueDate()) FixUtils.fillSpace(underlyingIssueDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingIssueDate, src); 		
		hasUnderlyingIssueDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingRepoCollateralSecurityType() { 		
		if ( hasUnderlyingRepoCollateralSecurityType()) {		
			if (hasUnderlyingRepoCollateralSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingRepoCollateralSecurityType; 		
			} else {		
		
				buf.position(hasUnderlyingRepoCollateralSecurityType);		
		
			underlyingRepoCollateralSecurityType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingRepoCollateralSecurityType);		
					return 0;		
				}		
			}		
			hasUnderlyingRepoCollateralSecurityType = FixUtils.TAG_HAS_VALUE;		
			return underlyingRepoCollateralSecurityType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingRepoCollateralSecurityType() { return hasUnderlyingRepoCollateralSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingRepoCollateralSecurityType(long src) {		
		underlyingRepoCollateralSecurityType = src;
		hasUnderlyingRepoCollateralSecurityType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingRepoCollateralSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingRepoCollateralSecurityType()) underlyingRepoCollateralSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingRepoCollateralSecurityType = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingRepoCollateralSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingRepoCollateralSecurityType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingRepoCollateralSecurityType()) underlyingRepoCollateralSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingRepoCollateralSecurityType = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingRepoCollateralSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingRepurchaseTerm() { 		
		if ( hasUnderlyingRepurchaseTerm()) {		
			if (hasUnderlyingRepurchaseTerm == FixUtils.TAG_HAS_VALUE) {		
				return underlyingRepurchaseTerm; 		
			} else {		
		
				buf.position(hasUnderlyingRepurchaseTerm);		
		
			underlyingRepurchaseTerm = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingRepurchaseTerm);		
					return 0;		
				}		
			}		
			hasUnderlyingRepurchaseTerm = FixUtils.TAG_HAS_VALUE;		
			return underlyingRepurchaseTerm;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingRepurchaseTerm() { return hasUnderlyingRepurchaseTerm != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingRepurchaseTerm(long src) {		
		underlyingRepurchaseTerm = src;
		hasUnderlyingRepurchaseTerm = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingRepurchaseTerm(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingRepurchaseTerm()) underlyingRepurchaseTerm = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingRepurchaseTerm = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingRepurchaseTerm = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingRepurchaseTerm(String str) {		
		if (str == null ) return;
		if (hasUnderlyingRepurchaseTerm()) underlyingRepurchaseTerm = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingRepurchaseTerm = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingRepurchaseTerm = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingRepurchaseRate() { 		
		if ( hasUnderlyingRepurchaseRate()) {		
			if (hasUnderlyingRepurchaseRate == FixUtils.TAG_HAS_VALUE) {		
				return underlyingRepurchaseRate; 		
			} else {		
		
				buf.position(hasUnderlyingRepurchaseRate);		
		
			underlyingRepurchaseRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingRepurchaseRate);		
					return 0;		
				}		
			}		
			hasUnderlyingRepurchaseRate = FixUtils.TAG_HAS_VALUE;		
			return underlyingRepurchaseRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingRepurchaseRate() { return hasUnderlyingRepurchaseRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingRepurchaseRate(long src) {		
		underlyingRepurchaseRate = src;
		hasUnderlyingRepurchaseRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingRepurchaseRate(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingRepurchaseRate()) underlyingRepurchaseRate = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingRepurchaseRate = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingRepurchaseRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingRepurchaseRate(String str) {		
		if (str == null ) return;
		if (hasUnderlyingRepurchaseRate()) underlyingRepurchaseRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingRepurchaseRate = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingRepurchaseRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingFactor() { 		
		if ( hasUnderlyingFactor()) {		
			if (hasUnderlyingFactor == FixUtils.TAG_HAS_VALUE) {		
				return underlyingFactor; 		
			} else {		
		
				buf.position(hasUnderlyingFactor);		
		
			underlyingFactor = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingFactor);		
					return 0;		
				}		
			}		
			hasUnderlyingFactor = FixUtils.TAG_HAS_VALUE;		
			return underlyingFactor;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingFactor() { return hasUnderlyingFactor != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingFactor(long src) {		
		underlyingFactor = src;
		hasUnderlyingFactor = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingFactor(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingFactor()) underlyingFactor = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingFactor = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingFactor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingFactor(String str) {		
		if (str == null ) return;
		if (hasUnderlyingFactor()) underlyingFactor = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingFactor = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingFactor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingCreditRating() { 		
		if ( hasUnderlyingCreditRating()) {		
			if (hasUnderlyingCreditRating == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCreditRating; 		
			} else {		
		
				buf.position(hasUnderlyingCreditRating);		
		
			FixMessage.getTagStringValue(buf, underlyingCreditRating, 0, underlyingCreditRating.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCreditRating);		
					return null;		
				}		
			}		
			hasUnderlyingCreditRating = FixUtils.TAG_HAS_VALUE;		
			return underlyingCreditRating;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingCreditRating() { return hasUnderlyingCreditRating != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCreditRating(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCreditRating()) FixUtils.fillSpace(underlyingCreditRating);		
		FixUtils.copy(underlyingCreditRating, src); 		
		hasUnderlyingCreditRating = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCreditRating(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCreditRating()) FixUtils.fillSpace(underlyingCreditRating);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingCreditRating, src); 		
		hasUnderlyingCreditRating = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingInstrRegistry() { 		
		if ( hasUnderlyingInstrRegistry()) {		
			if (hasUnderlyingInstrRegistry == FixUtils.TAG_HAS_VALUE) {		
				return underlyingInstrRegistry; 		
			} else {		
		
				buf.position(hasUnderlyingInstrRegistry);		
		
			FixMessage.getTagStringValue(buf, underlyingInstrRegistry, 0, underlyingInstrRegistry.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingInstrRegistry);		
					return null;		
				}		
			}		
			hasUnderlyingInstrRegistry = FixUtils.TAG_HAS_VALUE;		
			return underlyingInstrRegistry;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingInstrRegistry() { return hasUnderlyingInstrRegistry != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingInstrRegistry(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingInstrRegistry()) FixUtils.fillSpace(underlyingInstrRegistry);		
		FixUtils.copy(underlyingInstrRegistry, src); 		
		hasUnderlyingInstrRegistry = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingInstrRegistry(String str) {		
		if (str == null ) return;
		if (hasUnderlyingInstrRegistry()) FixUtils.fillSpace(underlyingInstrRegistry);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingInstrRegistry, src); 		
		hasUnderlyingInstrRegistry = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingCountryOfIssue() { 		
		if ( hasUnderlyingCountryOfIssue()) {		
			if (hasUnderlyingCountryOfIssue == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCountryOfIssue; 		
			} else {		
		
				buf.position(hasUnderlyingCountryOfIssue);		
		
			FixMessage.getTagStringValue(buf, underlyingCountryOfIssue, 0, underlyingCountryOfIssue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCountryOfIssue);		
					return null;		
				}		
			}		
			hasUnderlyingCountryOfIssue = FixUtils.TAG_HAS_VALUE;		
			return underlyingCountryOfIssue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingCountryOfIssue() { return hasUnderlyingCountryOfIssue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCountryOfIssue(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCountryOfIssue()) FixUtils.fillSpace(underlyingCountryOfIssue);		
		FixUtils.copy(underlyingCountryOfIssue, src); 		
		hasUnderlyingCountryOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCountryOfIssue(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCountryOfIssue()) FixUtils.fillSpace(underlyingCountryOfIssue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingCountryOfIssue, src); 		
		hasUnderlyingCountryOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingStateOrProvinceOfIssue() { 		
		if ( hasUnderlyingStateOrProvinceOfIssue()) {		
			if (hasUnderlyingStateOrProvinceOfIssue == FixUtils.TAG_HAS_VALUE) {		
				return underlyingStateOrProvinceOfIssue; 		
			} else {		
		
				buf.position(hasUnderlyingStateOrProvinceOfIssue);		
		
			FixMessage.getTagStringValue(buf, underlyingStateOrProvinceOfIssue, 0, underlyingStateOrProvinceOfIssue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingStateOrProvinceOfIssue);		
					return null;		
				}		
			}		
			hasUnderlyingStateOrProvinceOfIssue = FixUtils.TAG_HAS_VALUE;		
			return underlyingStateOrProvinceOfIssue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingStateOrProvinceOfIssue() { return hasUnderlyingStateOrProvinceOfIssue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingStateOrProvinceOfIssue(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingStateOrProvinceOfIssue()) FixUtils.fillSpace(underlyingStateOrProvinceOfIssue);		
		FixUtils.copy(underlyingStateOrProvinceOfIssue, src); 		
		hasUnderlyingStateOrProvinceOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingStateOrProvinceOfIssue(String str) {		
		if (str == null ) return;
		if (hasUnderlyingStateOrProvinceOfIssue()) FixUtils.fillSpace(underlyingStateOrProvinceOfIssue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingStateOrProvinceOfIssue, src); 		
		hasUnderlyingStateOrProvinceOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLocaleOfIssue() { 		
		if ( hasUnderlyingLocaleOfIssue()) {		
			if (hasUnderlyingLocaleOfIssue == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLocaleOfIssue; 		
			} else {		
		
				buf.position(hasUnderlyingLocaleOfIssue);		
		
			FixMessage.getTagStringValue(buf, underlyingLocaleOfIssue, 0, underlyingLocaleOfIssue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLocaleOfIssue);		
					return null;		
				}		
			}		
			hasUnderlyingLocaleOfIssue = FixUtils.TAG_HAS_VALUE;		
			return underlyingLocaleOfIssue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLocaleOfIssue() { return hasUnderlyingLocaleOfIssue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLocaleOfIssue(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLocaleOfIssue()) FixUtils.fillSpace(underlyingLocaleOfIssue);		
		FixUtils.copy(underlyingLocaleOfIssue, src); 		
		hasUnderlyingLocaleOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLocaleOfIssue(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLocaleOfIssue()) FixUtils.fillSpace(underlyingLocaleOfIssue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLocaleOfIssue, src); 		
		hasUnderlyingLocaleOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingRedemptionDate() { 		
		if ( hasUnderlyingRedemptionDate()) {		
			if (hasUnderlyingRedemptionDate == FixUtils.TAG_HAS_VALUE) {		
				return underlyingRedemptionDate; 		
			} else {		
		
				buf.position(hasUnderlyingRedemptionDate);		
		
			FixMessage.getTagStringValue(buf, underlyingRedemptionDate, 0, underlyingRedemptionDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingRedemptionDate);		
					return null;		
				}		
			}		
			hasUnderlyingRedemptionDate = FixUtils.TAG_HAS_VALUE;		
			return underlyingRedemptionDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingRedemptionDate() { return hasUnderlyingRedemptionDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingRedemptionDate(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingRedemptionDate()) FixUtils.fillSpace(underlyingRedemptionDate);		
		FixUtils.copy(underlyingRedemptionDate, src); 		
		hasUnderlyingRedemptionDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingRedemptionDate(String str) {		
		if (str == null ) return;
		if (hasUnderlyingRedemptionDate()) FixUtils.fillSpace(underlyingRedemptionDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingRedemptionDate, src); 		
		hasUnderlyingRedemptionDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingStrikePrice() { 		
		if ( hasUnderlyingStrikePrice()) {		
			if (hasUnderlyingStrikePrice == FixUtils.TAG_HAS_VALUE) {		
				return underlyingStrikePrice; 		
			} else {		
		
				buf.position(hasUnderlyingStrikePrice);		
		
			underlyingStrikePrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingStrikePrice);		
					return 0;		
				}		
			}		
			hasUnderlyingStrikePrice = FixUtils.TAG_HAS_VALUE;		
			return underlyingStrikePrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingStrikePrice() { return hasUnderlyingStrikePrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingStrikePrice(long src) {		
		underlyingStrikePrice = src;
		hasUnderlyingStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingStrikePrice(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingStrikePrice()) underlyingStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingStrikePrice = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingStrikePrice(String str) {		
		if (str == null ) return;
		if (hasUnderlyingStrikePrice()) underlyingStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingStrikePrice = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingStrikeCurrency() { 		
		if ( hasUnderlyingStrikeCurrency()) {		
			if (hasUnderlyingStrikeCurrency == FixUtils.TAG_HAS_VALUE) {		
				return underlyingStrikeCurrency; 		
			} else {		
		
				buf.position(hasUnderlyingStrikeCurrency);		
		
			FixMessage.getTagStringValue(buf, underlyingStrikeCurrency, 0, underlyingStrikeCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingStrikeCurrency);		
					return null;		
				}		
			}		
			hasUnderlyingStrikeCurrency = FixUtils.TAG_HAS_VALUE;		
			return underlyingStrikeCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingStrikeCurrency() { return hasUnderlyingStrikeCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingStrikeCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingStrikeCurrency()) FixUtils.fillSpace(underlyingStrikeCurrency);		
		FixUtils.copy(underlyingStrikeCurrency, src); 		
		hasUnderlyingStrikeCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingStrikeCurrency(String str) {		
		if (str == null ) return;
		if (hasUnderlyingStrikeCurrency()) FixUtils.fillSpace(underlyingStrikeCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingStrikeCurrency, src); 		
		hasUnderlyingStrikeCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getUnderlyingOptAttribute() { 		
		if ( hasUnderlyingOptAttribute()) {		
			if (hasUnderlyingOptAttribute == FixUtils.TAG_HAS_VALUE) {		
				return underlyingOptAttribute; 		
			} else {		
		
				buf.position(hasUnderlyingOptAttribute);		
		
			underlyingOptAttribute = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingOptAttribute);		
					return (byte)'0';		
				}		
			}		
			hasUnderlyingOptAttribute = FixUtils.TAG_HAS_VALUE;		
			return underlyingOptAttribute;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasUnderlyingOptAttribute() { return hasUnderlyingOptAttribute != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingOptAttribute(byte src) {		
		underlyingOptAttribute = src;
		hasUnderlyingOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingOptAttribute(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingOptAttribute()) underlyingOptAttribute = (byte)' ';		
		underlyingOptAttribute = src[0];		
		hasUnderlyingOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingOptAttribute(String str) {		
		if (str == null ) return;
		if (hasUnderlyingOptAttribute()) underlyingOptAttribute = (byte)' ';		
		byte[] src = str.getBytes(); 		
		underlyingOptAttribute = src[0];		
		hasUnderlyingOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingContractMultiplier() { 		
		if ( hasUnderlyingContractMultiplier()) {		
			if (hasUnderlyingContractMultiplier == FixUtils.TAG_HAS_VALUE) {		
				return underlyingContractMultiplier; 		
			} else {		
		
				buf.position(hasUnderlyingContractMultiplier);		
		
			underlyingContractMultiplier = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingContractMultiplier);		
					return 0;		
				}		
			}		
			hasUnderlyingContractMultiplier = FixUtils.TAG_HAS_VALUE;		
			return underlyingContractMultiplier;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingContractMultiplier() { return hasUnderlyingContractMultiplier != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingContractMultiplier(long src) {		
		underlyingContractMultiplier = src;
		hasUnderlyingContractMultiplier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingContractMultiplier(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingContractMultiplier()) underlyingContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingContractMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingContractMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingContractMultiplier(String str) {		
		if (str == null ) return;
		if (hasUnderlyingContractMultiplier()) underlyingContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingContractMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingContractMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingUnitOfMeasure() { 		
		if ( hasUnderlyingUnitOfMeasure()) {		
			if (hasUnderlyingUnitOfMeasure == FixUtils.TAG_HAS_VALUE) {		
				return underlyingUnitOfMeasure; 		
			} else {		
		
				buf.position(hasUnderlyingUnitOfMeasure);		
		
			FixMessage.getTagStringValue(buf, underlyingUnitOfMeasure, 0, underlyingUnitOfMeasure.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingUnitOfMeasure);		
					return null;		
				}		
			}		
			hasUnderlyingUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
			return underlyingUnitOfMeasure;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingUnitOfMeasure() { return hasUnderlyingUnitOfMeasure != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingUnitOfMeasure(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingUnitOfMeasure()) FixUtils.fillSpace(underlyingUnitOfMeasure);		
		FixUtils.copy(underlyingUnitOfMeasure, src); 		
		hasUnderlyingUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingUnitOfMeasure(String str) {		
		if (str == null ) return;
		if (hasUnderlyingUnitOfMeasure()) FixUtils.fillSpace(underlyingUnitOfMeasure);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingUnitOfMeasure, src); 		
		hasUnderlyingUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingTimeUnit() { 		
		if ( hasUnderlyingTimeUnit()) {		
			if (hasUnderlyingTimeUnit == FixUtils.TAG_HAS_VALUE) {		
				return underlyingTimeUnit; 		
			} else {		
		
				buf.position(hasUnderlyingTimeUnit);		
		
			FixMessage.getTagStringValue(buf, underlyingTimeUnit, 0, underlyingTimeUnit.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingTimeUnit);		
					return null;		
				}		
			}		
			hasUnderlyingTimeUnit = FixUtils.TAG_HAS_VALUE;		
			return underlyingTimeUnit;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingTimeUnit() { return hasUnderlyingTimeUnit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingTimeUnit(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingTimeUnit()) FixUtils.fillSpace(underlyingTimeUnit);		
		FixUtils.copy(underlyingTimeUnit, src); 		
		hasUnderlyingTimeUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingTimeUnit(String str) {		
		if (str == null ) return;
		if (hasUnderlyingTimeUnit()) FixUtils.fillSpace(underlyingTimeUnit);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingTimeUnit, src); 		
		hasUnderlyingTimeUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingExerciseStyle() { 		
		if ( hasUnderlyingExerciseStyle()) {		
			if (hasUnderlyingExerciseStyle == FixUtils.TAG_HAS_VALUE) {		
				return underlyingExerciseStyle; 		
			} else {		
		
				buf.position(hasUnderlyingExerciseStyle);		
		
			underlyingExerciseStyle = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingExerciseStyle);		
					return 0;		
				}		
			}		
			hasUnderlyingExerciseStyle = FixUtils.TAG_HAS_VALUE;		
			return underlyingExerciseStyle;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingExerciseStyle() { return hasUnderlyingExerciseStyle != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingExerciseStyle(long src) {		
		underlyingExerciseStyle = src;
		hasUnderlyingExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingExerciseStyle(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingExerciseStyle()) underlyingExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingExerciseStyle = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingExerciseStyle(String str) {		
		if (str == null ) return;
		if (hasUnderlyingExerciseStyle()) underlyingExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingExerciseStyle = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingUnitOfMeasureQty() { 		
		if ( hasUnderlyingUnitOfMeasureQty()) {		
			if (hasUnderlyingUnitOfMeasureQty == FixUtils.TAG_HAS_VALUE) {		
				return underlyingUnitOfMeasureQty; 		
			} else {		
		
				buf.position(hasUnderlyingUnitOfMeasureQty);		
		
			underlyingUnitOfMeasureQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingUnitOfMeasureQty);		
					return 0;		
				}		
			}		
			hasUnderlyingUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
			return underlyingUnitOfMeasureQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingUnitOfMeasureQty() { return hasUnderlyingUnitOfMeasureQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingUnitOfMeasureQty(long src) {		
		underlyingUnitOfMeasureQty = src;
		hasUnderlyingUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingUnitOfMeasureQty(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingUnitOfMeasureQty()) underlyingUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingUnitOfMeasureQty(String str) {		
		if (str == null ) return;
		if (hasUnderlyingUnitOfMeasureQty()) underlyingUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingPriceUnitOfMeasure() { 		
		if ( hasUnderlyingPriceUnitOfMeasure()) {		
			if (hasUnderlyingPriceUnitOfMeasure == FixUtils.TAG_HAS_VALUE) {		
				return underlyingPriceUnitOfMeasure; 		
			} else {		
		
				buf.position(hasUnderlyingPriceUnitOfMeasure);		
		
			FixMessage.getTagStringValue(buf, underlyingPriceUnitOfMeasure, 0, underlyingPriceUnitOfMeasure.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingPriceUnitOfMeasure);		
					return null;		
				}		
			}		
			hasUnderlyingPriceUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
			return underlyingPriceUnitOfMeasure;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingPriceUnitOfMeasure() { return hasUnderlyingPriceUnitOfMeasure != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingPriceUnitOfMeasure(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingPriceUnitOfMeasure()) FixUtils.fillSpace(underlyingPriceUnitOfMeasure);		
		FixUtils.copy(underlyingPriceUnitOfMeasure, src); 		
		hasUnderlyingPriceUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingPriceUnitOfMeasure(String str) {		
		if (str == null ) return;
		if (hasUnderlyingPriceUnitOfMeasure()) FixUtils.fillSpace(underlyingPriceUnitOfMeasure);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingPriceUnitOfMeasure, src); 		
		hasUnderlyingPriceUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingPriceUnitOfMeasureQty() { 		
		if ( hasUnderlyingPriceUnitOfMeasureQty()) {		
			if (hasUnderlyingPriceUnitOfMeasureQty == FixUtils.TAG_HAS_VALUE) {		
				return underlyingPriceUnitOfMeasureQty; 		
			} else {		
		
				buf.position(hasUnderlyingPriceUnitOfMeasureQty);		
		
			underlyingPriceUnitOfMeasureQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingPriceUnitOfMeasureQty);		
					return 0;		
				}		
			}		
			hasUnderlyingPriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
			return underlyingPriceUnitOfMeasureQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingPriceUnitOfMeasureQty() { return hasUnderlyingPriceUnitOfMeasureQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingPriceUnitOfMeasureQty(long src) {		
		underlyingPriceUnitOfMeasureQty = src;
		hasUnderlyingPriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingPriceUnitOfMeasureQty(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingPriceUnitOfMeasureQty()) underlyingPriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingPriceUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingPriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingPriceUnitOfMeasureQty(String str) {		
		if (str == null ) return;
		if (hasUnderlyingPriceUnitOfMeasureQty()) underlyingPriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingPriceUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingPriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingContractMultiplierUnit() { 		
		if ( hasUnderlyingContractMultiplierUnit()) {		
			if (hasUnderlyingContractMultiplierUnit == FixUtils.TAG_HAS_VALUE) {		
				return underlyingContractMultiplierUnit; 		
			} else {		
		
				buf.position(hasUnderlyingContractMultiplierUnit);		
		
			underlyingContractMultiplierUnit = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingContractMultiplierUnit);		
					return 0;		
				}		
			}		
			hasUnderlyingContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
			return underlyingContractMultiplierUnit;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingContractMultiplierUnit() { return hasUnderlyingContractMultiplierUnit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingContractMultiplierUnit(long src) {		
		underlyingContractMultiplierUnit = src;
		hasUnderlyingContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingContractMultiplierUnit(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingContractMultiplierUnit()) underlyingContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingContractMultiplierUnit = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingContractMultiplierUnit(String str) {		
		if (str == null ) return;
		if (hasUnderlyingContractMultiplierUnit()) underlyingContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingContractMultiplierUnit = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingFlowScheduleType() { 		
		if ( hasUnderlyingFlowScheduleType()) {		
			if (hasUnderlyingFlowScheduleType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingFlowScheduleType; 		
			} else {		
		
				buf.position(hasUnderlyingFlowScheduleType);		
		
			underlyingFlowScheduleType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingFlowScheduleType);		
					return 0;		
				}		
			}		
			hasUnderlyingFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
			return underlyingFlowScheduleType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingFlowScheduleType() { return hasUnderlyingFlowScheduleType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingFlowScheduleType(long src) {		
		underlyingFlowScheduleType = src;
		hasUnderlyingFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingFlowScheduleType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingFlowScheduleType()) underlyingFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingFlowScheduleType = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingFlowScheduleType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingFlowScheduleType()) underlyingFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingFlowScheduleType = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingCouponRate() { 		
		if ( hasUnderlyingCouponRate()) {		
			if (hasUnderlyingCouponRate == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCouponRate; 		
			} else {		
		
				buf.position(hasUnderlyingCouponRate);		
		
			underlyingCouponRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCouponRate);		
					return 0;		
				}		
			}		
			hasUnderlyingCouponRate = FixUtils.TAG_HAS_VALUE;		
			return underlyingCouponRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingCouponRate() { return hasUnderlyingCouponRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCouponRate(long src) {		
		underlyingCouponRate = src;
		hasUnderlyingCouponRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingCouponRate(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCouponRate()) underlyingCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCouponRate = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingCouponRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCouponRate(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCouponRate()) underlyingCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingCouponRate = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingCouponRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingSecurityExchange() { 		
		if ( hasUnderlyingSecurityExchange()) {		
			if (hasUnderlyingSecurityExchange == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSecurityExchange; 		
			} else {		
		
				buf.position(hasUnderlyingSecurityExchange);		
		
			FixMessage.getTagStringValue(buf, underlyingSecurityExchange, 0, underlyingSecurityExchange.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSecurityExchange);		
					return null;		
				}		
			}		
			hasUnderlyingSecurityExchange = FixUtils.TAG_HAS_VALUE;		
			return underlyingSecurityExchange;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSecurityExchange() { return hasUnderlyingSecurityExchange != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSecurityExchange(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSecurityExchange()) FixUtils.fillSpace(underlyingSecurityExchange);		
		FixUtils.copy(underlyingSecurityExchange, src); 		
		hasUnderlyingSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSecurityExchange(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSecurityExchange()) FixUtils.fillSpace(underlyingSecurityExchange);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSecurityExchange, src); 		
		hasUnderlyingSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingIssuer() { 		
		if ( hasUnderlyingIssuer()) {		
			if (hasUnderlyingIssuer == FixUtils.TAG_HAS_VALUE) {		
				return underlyingIssuer; 		
			} else {		
		
				buf.position(hasUnderlyingIssuer);		
		
			FixMessage.getTagStringValue(buf, underlyingIssuer, 0, underlyingIssuer.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingIssuer);		
					return null;		
				}		
			}		
			hasUnderlyingIssuer = FixUtils.TAG_HAS_VALUE;		
			return underlyingIssuer;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingIssuer() { return hasUnderlyingIssuer != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingIssuer(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingIssuer()) FixUtils.fillSpace(underlyingIssuer);		
		FixUtils.copy(underlyingIssuer, src); 		
		hasUnderlyingIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingIssuer(String str) {		
		if (str == null ) return;
		if (hasUnderlyingIssuer()) FixUtils.fillSpace(underlyingIssuer);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingIssuer, src); 		
		hasUnderlyingIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEncodedUnderlyingIssuerLen() { 		
		if ( hasEncodedUnderlyingIssuerLen()) {		
			if (hasEncodedUnderlyingIssuerLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedUnderlyingIssuerLen; 		
			} else {		
		
				buf.position(hasEncodedUnderlyingIssuerLen);		
		
			encodedUnderlyingIssuerLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedUnderlyingIssuerLen);		
					return 0;		
				}		
			}		
			hasEncodedUnderlyingIssuerLen = FixUtils.TAG_HAS_VALUE;		
			return encodedUnderlyingIssuerLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedUnderlyingIssuerLen() { return hasEncodedUnderlyingIssuerLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedUnderlyingIssuerLen(long src) {		
		encodedUnderlyingIssuerLen = src;
		hasEncodedUnderlyingIssuerLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedUnderlyingIssuerLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedUnderlyingIssuerLen()) encodedUnderlyingIssuerLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedUnderlyingIssuerLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedUnderlyingIssuerLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedUnderlyingIssuerLen(String str) {		
		if (str == null ) return;
		if (hasEncodedUnderlyingIssuerLen()) encodedUnderlyingIssuerLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedUnderlyingIssuerLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedUnderlyingIssuerLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedUnderlyingIssuer() { 		
		if ( hasEncodedUnderlyingIssuer()) {		
			if (hasEncodedUnderlyingIssuer == FixUtils.TAG_HAS_VALUE) {		
				return encodedUnderlyingIssuer; 		
			} else {		
		
				buf.position(hasEncodedUnderlyingIssuer);		
		
			FixMessage.getTagStringValue(buf, encodedUnderlyingIssuer, 0, encodedUnderlyingIssuer.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedUnderlyingIssuer);		
					return null;		
				}		
			}		
			hasEncodedUnderlyingIssuer = FixUtils.TAG_HAS_VALUE;		
			return encodedUnderlyingIssuer;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedUnderlyingIssuer() { return hasEncodedUnderlyingIssuer != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedUnderlyingIssuer(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedUnderlyingIssuer()) FixUtils.fillSpace(encodedUnderlyingIssuer);		
		FixUtils.copy(encodedUnderlyingIssuer, src); 		
		hasEncodedUnderlyingIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedUnderlyingIssuer(String str) {		
		if (str == null ) return;
		if (hasEncodedUnderlyingIssuer()) FixUtils.fillSpace(encodedUnderlyingIssuer);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedUnderlyingIssuer, src); 		
		hasEncodedUnderlyingIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingSecurityDesc() { 		
		if ( hasUnderlyingSecurityDesc()) {		
			if (hasUnderlyingSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSecurityDesc; 		
			} else {		
		
				buf.position(hasUnderlyingSecurityDesc);		
		
			FixMessage.getTagStringValue(buf, underlyingSecurityDesc, 0, underlyingSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSecurityDesc);		
					return null;		
				}		
			}		
			hasUnderlyingSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return underlyingSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSecurityDesc() { return hasUnderlyingSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSecurityDesc()) FixUtils.fillSpace(underlyingSecurityDesc);		
		FixUtils.copy(underlyingSecurityDesc, src); 		
		hasUnderlyingSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSecurityDesc()) FixUtils.fillSpace(underlyingSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSecurityDesc, src); 		
		hasUnderlyingSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEncodedUnderlyingSecurityDescLen() { 		
		if ( hasEncodedUnderlyingSecurityDescLen()) {		
			if (hasEncodedUnderlyingSecurityDescLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedUnderlyingSecurityDescLen; 		
			} else {		
		
				buf.position(hasEncodedUnderlyingSecurityDescLen);		
		
			encodedUnderlyingSecurityDescLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedUnderlyingSecurityDescLen);		
					return 0;		
				}		
			}		
			hasEncodedUnderlyingSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
			return encodedUnderlyingSecurityDescLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedUnderlyingSecurityDescLen() { return hasEncodedUnderlyingSecurityDescLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedUnderlyingSecurityDescLen(long src) {		
		encodedUnderlyingSecurityDescLen = src;
		hasEncodedUnderlyingSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedUnderlyingSecurityDescLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedUnderlyingSecurityDescLen()) encodedUnderlyingSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedUnderlyingSecurityDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedUnderlyingSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedUnderlyingSecurityDescLen(String str) {		
		if (str == null ) return;
		if (hasEncodedUnderlyingSecurityDescLen()) encodedUnderlyingSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedUnderlyingSecurityDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedUnderlyingSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedUnderlyingSecurityDesc() { 		
		if ( hasEncodedUnderlyingSecurityDesc()) {		
			if (hasEncodedUnderlyingSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return encodedUnderlyingSecurityDesc; 		
			} else {		
		
				buf.position(hasEncodedUnderlyingSecurityDesc);		
		
			FixMessage.getTagStringValue(buf, encodedUnderlyingSecurityDesc, 0, encodedUnderlyingSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedUnderlyingSecurityDesc);		
					return null;		
				}		
			}		
			hasEncodedUnderlyingSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return encodedUnderlyingSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedUnderlyingSecurityDesc() { return hasEncodedUnderlyingSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedUnderlyingSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedUnderlyingSecurityDesc()) FixUtils.fillSpace(encodedUnderlyingSecurityDesc);		
		FixUtils.copy(encodedUnderlyingSecurityDesc, src); 		
		hasEncodedUnderlyingSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedUnderlyingSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasEncodedUnderlyingSecurityDesc()) FixUtils.fillSpace(encodedUnderlyingSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedUnderlyingSecurityDesc, src); 		
		hasEncodedUnderlyingSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingCPProgram() { 		
		if ( hasUnderlyingCPProgram()) {		
			if (hasUnderlyingCPProgram == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCPProgram; 		
			} else {		
		
				buf.position(hasUnderlyingCPProgram);		
		
			FixMessage.getTagStringValue(buf, underlyingCPProgram, 0, underlyingCPProgram.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCPProgram);		
					return null;		
				}		
			}		
			hasUnderlyingCPProgram = FixUtils.TAG_HAS_VALUE;		
			return underlyingCPProgram;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingCPProgram() { return hasUnderlyingCPProgram != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCPProgram(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCPProgram()) FixUtils.fillSpace(underlyingCPProgram);		
		FixUtils.copy(underlyingCPProgram, src); 		
		hasUnderlyingCPProgram = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCPProgram(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCPProgram()) FixUtils.fillSpace(underlyingCPProgram);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingCPProgram, src); 		
		hasUnderlyingCPProgram = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingCPRegType() { 		
		if ( hasUnderlyingCPRegType()) {		
			if (hasUnderlyingCPRegType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCPRegType; 		
			} else {		
		
				buf.position(hasUnderlyingCPRegType);		
		
			FixMessage.getTagStringValue(buf, underlyingCPRegType, 0, underlyingCPRegType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCPRegType);		
					return null;		
				}		
			}		
			hasUnderlyingCPRegType = FixUtils.TAG_HAS_VALUE;		
			return underlyingCPRegType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingCPRegType() { return hasUnderlyingCPRegType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCPRegType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCPRegType()) FixUtils.fillSpace(underlyingCPRegType);		
		FixUtils.copy(underlyingCPRegType, src); 		
		hasUnderlyingCPRegType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCPRegType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCPRegType()) FixUtils.fillSpace(underlyingCPRegType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingCPRegType, src); 		
		hasUnderlyingCPRegType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingAllocationPercent() { 		
		if ( hasUnderlyingAllocationPercent()) {		
			if (hasUnderlyingAllocationPercent == FixUtils.TAG_HAS_VALUE) {		
				return underlyingAllocationPercent; 		
			} else {		
		
				buf.position(hasUnderlyingAllocationPercent);		
		
			underlyingAllocationPercent = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingAllocationPercent);		
					return 0;		
				}		
			}		
			hasUnderlyingAllocationPercent = FixUtils.TAG_HAS_VALUE;		
			return underlyingAllocationPercent;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingAllocationPercent() { return hasUnderlyingAllocationPercent != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingAllocationPercent(long src) {		
		underlyingAllocationPercent = src;
		hasUnderlyingAllocationPercent = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingAllocationPercent(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingAllocationPercent()) underlyingAllocationPercent = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingAllocationPercent = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingAllocationPercent = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingAllocationPercent(String str) {		
		if (str == null ) return;
		if (hasUnderlyingAllocationPercent()) underlyingAllocationPercent = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingAllocationPercent = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingAllocationPercent = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingCurrency() { 		
		if ( hasUnderlyingCurrency()) {		
			if (hasUnderlyingCurrency == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCurrency; 		
			} else {		
		
				buf.position(hasUnderlyingCurrency);		
		
			FixMessage.getTagStringValue(buf, underlyingCurrency, 0, underlyingCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCurrency);		
					return null;		
				}		
			}		
			hasUnderlyingCurrency = FixUtils.TAG_HAS_VALUE;		
			return underlyingCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingCurrency() { return hasUnderlyingCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCurrency()) FixUtils.fillSpace(underlyingCurrency);		
		FixUtils.copy(underlyingCurrency, src); 		
		hasUnderlyingCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCurrency(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCurrency()) FixUtils.fillSpace(underlyingCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingCurrency, src); 		
		hasUnderlyingCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingQty() { 		
		if ( hasUnderlyingQty()) {		
			if (hasUnderlyingQty == FixUtils.TAG_HAS_VALUE) {		
				return underlyingQty; 		
			} else {		
		
				buf.position(hasUnderlyingQty);		
		
			underlyingQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingQty);		
					return 0;		
				}		
			}		
			hasUnderlyingQty = FixUtils.TAG_HAS_VALUE;		
			return underlyingQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingQty() { return hasUnderlyingQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingQty(long src) {		
		underlyingQty = src;
		hasUnderlyingQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingQty(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingQty()) underlyingQty = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingQty = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingQty(String str) {		
		if (str == null ) return;
		if (hasUnderlyingQty()) underlyingQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingQty = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingSettlementType() { 		
		if ( hasUnderlyingSettlementType()) {		
			if (hasUnderlyingSettlementType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSettlementType; 		
			} else {		
		
				buf.position(hasUnderlyingSettlementType);		
		
			underlyingSettlementType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSettlementType);		
					return 0;		
				}		
			}		
			hasUnderlyingSettlementType = FixUtils.TAG_HAS_VALUE;		
			return underlyingSettlementType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingSettlementType() { return hasUnderlyingSettlementType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSettlementType(long src) {		
		underlyingSettlementType = src;
		hasUnderlyingSettlementType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingSettlementType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSettlementType()) underlyingSettlementType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSettlementType = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingSettlementType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSettlementType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSettlementType()) underlyingSettlementType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingSettlementType = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingSettlementType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingCashAmount() { 		
		if ( hasUnderlyingCashAmount()) {		
			if (hasUnderlyingCashAmount == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCashAmount; 		
			} else {		
		
				buf.position(hasUnderlyingCashAmount);		
		
			underlyingCashAmount = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCashAmount);		
					return 0;		
				}		
			}		
			hasUnderlyingCashAmount = FixUtils.TAG_HAS_VALUE;		
			return underlyingCashAmount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingCashAmount() { return hasUnderlyingCashAmount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCashAmount(long src) {		
		underlyingCashAmount = src;
		hasUnderlyingCashAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingCashAmount(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCashAmount()) underlyingCashAmount = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCashAmount = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingCashAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCashAmount(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCashAmount()) underlyingCashAmount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingCashAmount = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingCashAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingCashType() { 		
		if ( hasUnderlyingCashType()) {		
			if (hasUnderlyingCashType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCashType; 		
			} else {		
		
				buf.position(hasUnderlyingCashType);		
		
			FixMessage.getTagStringValue(buf, underlyingCashType, 0, underlyingCashType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCashType);		
					return null;		
				}		
			}		
			hasUnderlyingCashType = FixUtils.TAG_HAS_VALUE;		
			return underlyingCashType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingCashType() { return hasUnderlyingCashType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCashType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCashType()) FixUtils.fillSpace(underlyingCashType);		
		FixUtils.copy(underlyingCashType, src); 		
		hasUnderlyingCashType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCashType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCashType()) FixUtils.fillSpace(underlyingCashType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingCashType, src); 		
		hasUnderlyingCashType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingPx() { 		
		if ( hasUnderlyingPx()) {		
			if (hasUnderlyingPx == FixUtils.TAG_HAS_VALUE) {		
				return underlyingPx; 		
			} else {		
		
				buf.position(hasUnderlyingPx);		
		
			underlyingPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingPx);		
					return 0;		
				}		
			}		
			hasUnderlyingPx = FixUtils.TAG_HAS_VALUE;		
			return underlyingPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingPx() { return hasUnderlyingPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingPx(long src) {		
		underlyingPx = src;
		hasUnderlyingPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingPx(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingPx()) underlyingPx = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingPx = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingPx(String str) {		
		if (str == null ) return;
		if (hasUnderlyingPx()) underlyingPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingPx = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingDirtyPrice() { 		
		if ( hasUnderlyingDirtyPrice()) {		
			if (hasUnderlyingDirtyPrice == FixUtils.TAG_HAS_VALUE) {		
				return underlyingDirtyPrice; 		
			} else {		
		
				buf.position(hasUnderlyingDirtyPrice);		
		
			underlyingDirtyPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingDirtyPrice);		
					return 0;		
				}		
			}		
			hasUnderlyingDirtyPrice = FixUtils.TAG_HAS_VALUE;		
			return underlyingDirtyPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingDirtyPrice() { return hasUnderlyingDirtyPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingDirtyPrice(long src) {		
		underlyingDirtyPrice = src;
		hasUnderlyingDirtyPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingDirtyPrice(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingDirtyPrice()) underlyingDirtyPrice = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingDirtyPrice = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingDirtyPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingDirtyPrice(String str) {		
		if (str == null ) return;
		if (hasUnderlyingDirtyPrice()) underlyingDirtyPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingDirtyPrice = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingDirtyPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingEndPrice() { 		
		if ( hasUnderlyingEndPrice()) {		
			if (hasUnderlyingEndPrice == FixUtils.TAG_HAS_VALUE) {		
				return underlyingEndPrice; 		
			} else {		
		
				buf.position(hasUnderlyingEndPrice);		
		
			underlyingEndPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingEndPrice);		
					return 0;		
				}		
			}		
			hasUnderlyingEndPrice = FixUtils.TAG_HAS_VALUE;		
			return underlyingEndPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingEndPrice() { return hasUnderlyingEndPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingEndPrice(long src) {		
		underlyingEndPrice = src;
		hasUnderlyingEndPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingEndPrice(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingEndPrice()) underlyingEndPrice = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingEndPrice = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingEndPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingEndPrice(String str) {		
		if (str == null ) return;
		if (hasUnderlyingEndPrice()) underlyingEndPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingEndPrice = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingEndPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingStartValue() { 		
		if ( hasUnderlyingStartValue()) {		
			if (hasUnderlyingStartValue == FixUtils.TAG_HAS_VALUE) {		
				return underlyingStartValue; 		
			} else {		
		
				buf.position(hasUnderlyingStartValue);		
		
			underlyingStartValue = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingStartValue);		
					return 0;		
				}		
			}		
			hasUnderlyingStartValue = FixUtils.TAG_HAS_VALUE;		
			return underlyingStartValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingStartValue() { return hasUnderlyingStartValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingStartValue(long src) {		
		underlyingStartValue = src;
		hasUnderlyingStartValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingStartValue(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingStartValue()) underlyingStartValue = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingStartValue = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingStartValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingStartValue(String str) {		
		if (str == null ) return;
		if (hasUnderlyingStartValue()) underlyingStartValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingStartValue = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingStartValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingCurrentValue() { 		
		if ( hasUnderlyingCurrentValue()) {		
			if (hasUnderlyingCurrentValue == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCurrentValue; 		
			} else {		
		
				buf.position(hasUnderlyingCurrentValue);		
		
			underlyingCurrentValue = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCurrentValue);		
					return 0;		
				}		
			}		
			hasUnderlyingCurrentValue = FixUtils.TAG_HAS_VALUE;		
			return underlyingCurrentValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingCurrentValue() { return hasUnderlyingCurrentValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCurrentValue(long src) {		
		underlyingCurrentValue = src;
		hasUnderlyingCurrentValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingCurrentValue(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCurrentValue()) underlyingCurrentValue = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCurrentValue = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingCurrentValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCurrentValue(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCurrentValue()) underlyingCurrentValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingCurrentValue = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingCurrentValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingEndValue() { 		
		if ( hasUnderlyingEndValue()) {		
			if (hasUnderlyingEndValue == FixUtils.TAG_HAS_VALUE) {		
				return underlyingEndValue; 		
			} else {		
		
				buf.position(hasUnderlyingEndValue);		
		
			underlyingEndValue = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingEndValue);		
					return 0;		
				}		
			}		
			hasUnderlyingEndValue = FixUtils.TAG_HAS_VALUE;		
			return underlyingEndValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingEndValue() { return hasUnderlyingEndValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingEndValue(long src) {		
		underlyingEndValue = src;
		hasUnderlyingEndValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingEndValue(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingEndValue()) underlyingEndValue = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingEndValue = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingEndValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingEndValue(String str) {		
		if (str == null ) return;
		if (hasUnderlyingEndValue()) underlyingEndValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingEndValue = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingEndValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingAdjustedQuantity() { 		
		if ( hasUnderlyingAdjustedQuantity()) {		
			if (hasUnderlyingAdjustedQuantity == FixUtils.TAG_HAS_VALUE) {		
				return underlyingAdjustedQuantity; 		
			} else {		
		
				buf.position(hasUnderlyingAdjustedQuantity);		
		
			underlyingAdjustedQuantity = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingAdjustedQuantity);		
					return 0;		
				}		
			}		
			hasUnderlyingAdjustedQuantity = FixUtils.TAG_HAS_VALUE;		
			return underlyingAdjustedQuantity;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingAdjustedQuantity() { return hasUnderlyingAdjustedQuantity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingAdjustedQuantity(long src) {		
		underlyingAdjustedQuantity = src;
		hasUnderlyingAdjustedQuantity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingAdjustedQuantity(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingAdjustedQuantity()) underlyingAdjustedQuantity = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingAdjustedQuantity = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingAdjustedQuantity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingAdjustedQuantity(String str) {		
		if (str == null ) return;
		if (hasUnderlyingAdjustedQuantity()) underlyingAdjustedQuantity = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingAdjustedQuantity = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingAdjustedQuantity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingFXRate() { 		
		if ( hasUnderlyingFXRate()) {		
			if (hasUnderlyingFXRate == FixUtils.TAG_HAS_VALUE) {		
				return underlyingFXRate; 		
			} else {		
		
				buf.position(hasUnderlyingFXRate);		
		
			underlyingFXRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingFXRate);		
					return 0;		
				}		
			}		
			hasUnderlyingFXRate = FixUtils.TAG_HAS_VALUE;		
			return underlyingFXRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingFXRate() { return hasUnderlyingFXRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingFXRate(long src) {		
		underlyingFXRate = src;
		hasUnderlyingFXRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingFXRate(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingFXRate()) underlyingFXRate = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingFXRate = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingFXRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingFXRate(String str) {		
		if (str == null ) return;
		if (hasUnderlyingFXRate()) underlyingFXRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingFXRate = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingFXRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getUnderlyingFXRateCalc() { 		
		if ( hasUnderlyingFXRateCalc()) {		
			if (hasUnderlyingFXRateCalc == FixUtils.TAG_HAS_VALUE) {		
				return underlyingFXRateCalc; 		
			} else {		
		
				buf.position(hasUnderlyingFXRateCalc);		
		
			underlyingFXRateCalc = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (underlyingFXRateCalc != (byte)'D') && (underlyingFXRateCalc != (byte)'M') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1046);		
				if (err.hasError()) {		
					buf.position(hasUnderlyingFXRateCalc);		
					return (byte)'0';		
				}		
			}		
			hasUnderlyingFXRateCalc = FixUtils.TAG_HAS_VALUE;		
			return underlyingFXRateCalc;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasUnderlyingFXRateCalc() { return hasUnderlyingFXRateCalc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingFXRateCalc(byte src) {		
		underlyingFXRateCalc = src;
		hasUnderlyingFXRateCalc = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingFXRateCalc(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingFXRateCalc()) underlyingFXRateCalc = (byte)' ';		
		underlyingFXRateCalc = src[0];		
		hasUnderlyingFXRateCalc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingFXRateCalc(String str) {		
		if (str == null ) return;
		if (hasUnderlyingFXRateCalc()) underlyingFXRateCalc = (byte)' ';		
		byte[] src = str.getBytes(); 		
		underlyingFXRateCalc = src[0];		
		hasUnderlyingFXRateCalc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingCapValue() { 		
		if ( hasUnderlyingCapValue()) {		
			if (hasUnderlyingCapValue == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCapValue; 		
			} else {		
		
				buf.position(hasUnderlyingCapValue);		
		
			underlyingCapValue = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCapValue);		
					return 0;		
				}		
			}		
			hasUnderlyingCapValue = FixUtils.TAG_HAS_VALUE;		
			return underlyingCapValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingCapValue() { return hasUnderlyingCapValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCapValue(long src) {		
		underlyingCapValue = src;
		hasUnderlyingCapValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingCapValue(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCapValue()) underlyingCapValue = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCapValue = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingCapValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCapValue(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCapValue()) underlyingCapValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingCapValue = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingCapValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingSettlMethod() { 		
		if ( hasUnderlyingSettlMethod()) {		
			if (hasUnderlyingSettlMethod == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSettlMethod; 		
			} else {		
		
				buf.position(hasUnderlyingSettlMethod);		
		
			FixMessage.getTagStringValue(buf, underlyingSettlMethod, 0, underlyingSettlMethod.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSettlMethod);		
					return null;		
				}		
			}		
			hasUnderlyingSettlMethod = FixUtils.TAG_HAS_VALUE;		
			return underlyingSettlMethod;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSettlMethod() { return hasUnderlyingSettlMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSettlMethod(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSettlMethod()) FixUtils.fillSpace(underlyingSettlMethod);		
		FixUtils.copy(underlyingSettlMethod, src); 		
		hasUnderlyingSettlMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSettlMethod(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSettlMethod()) FixUtils.fillSpace(underlyingSettlMethod);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSettlMethod, src); 		
		hasUnderlyingSettlMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingPutOrCall() { 		
		if ( hasUnderlyingPutOrCall()) {		
			if (hasUnderlyingPutOrCall == FixUtils.TAG_HAS_VALUE) {		
				return underlyingPutOrCall; 		
			} else {		
		
				buf.position(hasUnderlyingPutOrCall);		
		
			underlyingPutOrCall = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingPutOrCall);		
					return 0;		
				}		
			}		
			hasUnderlyingPutOrCall = FixUtils.TAG_HAS_VALUE;		
			return underlyingPutOrCall;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingPutOrCall() { return hasUnderlyingPutOrCall != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingPutOrCall(long src) {		
		underlyingPutOrCall = src;
		hasUnderlyingPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingPutOrCall(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingPutOrCall()) underlyingPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingPutOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingPutOrCall(String str) {		
		if (str == null ) return;
		if (hasUnderlyingPutOrCall()) underlyingPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingPutOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasUnderlyingSymbol()) s += "UnderlyingSymbol(311)= " + new String( FixUtils.trim(getUnderlyingSymbol()) ) + "\n" ; 
		if (hasUnderlyingSymbolSfx()) s += "UnderlyingSymbolSfx(312)= " + new String( FixUtils.trim(getUnderlyingSymbolSfx()) ) + "\n" ; 
		if (hasUnderlyingSecurityID()) s += "UnderlyingSecurityID(309)= " + new String( FixUtils.trim(getUnderlyingSecurityID()) ) + "\n" ; 
		if (hasUnderlyingSecurityIDSource()) s += "UnderlyingSecurityIDSource(305)= " + new String( FixUtils.trim(getUnderlyingSecurityIDSource()) ) + "\n" ; 
		if (hasUnderlyingProduct()) s += "UnderlyingProduct(462)= " + getUnderlyingProduct() + "\n" ; 
		if (hasUnderlyingCFICode()) s += "UnderlyingCFICode(463)= " + new String( FixUtils.trim(getUnderlyingCFICode()) ) + "\n" ; 
		if (hasUnderlyingSecurityType()) s += "UnderlyingSecurityType(310)= " + new String( FixUtils.trim(getUnderlyingSecurityType()) ) + "\n" ; 
		if (hasUnderlyingSecuritySubType()) s += "UnderlyingSecuritySubType(763)= " + new String( FixUtils.trim(getUnderlyingSecuritySubType()) ) + "\n" ; 
		if (hasUnderlyingMaturityMonthYear()) s += "UnderlyingMaturityMonthYear(313)= " + new String( FixUtils.trim(getUnderlyingMaturityMonthYear()) ) + "\n" ; 
		if (hasUnderlyingMaturityDate()) s += "UnderlyingMaturityDate(542)= " + new String( FixUtils.trim(getUnderlyingMaturityDate()) ) + "\n" ; 
		if (hasUnderlyingMaturityTime()) s += "UnderlyingMaturityTime(1213)= " + new String( FixUtils.trim(getUnderlyingMaturityTime()) ) + "\n" ; 
		if (hasUnderlyingCouponPaymentDate()) s += "UnderlyingCouponPaymentDate(241)= " + new String( FixUtils.trim(getUnderlyingCouponPaymentDate()) ) + "\n" ; 
		if (hasUnderlyingRestructuringType()) s += "UnderlyingRestructuringType(1453)= " + new String( FixUtils.trim(getUnderlyingRestructuringType()) ) + "\n" ; 
		if (hasUnderlyingSeniority()) s += "UnderlyingSeniority(1454)= " + new String( FixUtils.trim(getUnderlyingSeniority()) ) + "\n" ; 
		if (hasUnderlyingNotionalPercentageOutstanding()) s += "UnderlyingNotionalPercentageOutstanding(1455)= " + getUnderlyingNotionalPercentageOutstanding() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingOriginalNotionalPercentageOutstanding()) s += "UnderlyingOriginalNotionalPercentageOutstanding(1456)= " + getUnderlyingOriginalNotionalPercentageOutstanding() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingAttachmentPoint()) s += "UnderlyingAttachmentPoint(1459)= " + getUnderlyingAttachmentPoint() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingDetachmentPoint()) s += "UnderlyingDetachmentPoint(1460)= " + getUnderlyingDetachmentPoint() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingIssueDate()) s += "UnderlyingIssueDate(242)= " + new String( FixUtils.trim(getUnderlyingIssueDate()) ) + "\n" ; 
		if (hasUnderlyingRepoCollateralSecurityType()) s += "UnderlyingRepoCollateralSecurityType(243)= " + getUnderlyingRepoCollateralSecurityType() + "\n" ; 
		if (hasUnderlyingRepurchaseTerm()) s += "UnderlyingRepurchaseTerm(244)= " + getUnderlyingRepurchaseTerm() + "\n" ; 
		if (hasUnderlyingRepurchaseRate()) s += "UnderlyingRepurchaseRate(245)= " + getUnderlyingRepurchaseRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingFactor()) s += "UnderlyingFactor(246)= " + getUnderlyingFactor() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingCreditRating()) s += "UnderlyingCreditRating(256)= " + new String( FixUtils.trim(getUnderlyingCreditRating()) ) + "\n" ; 
		if (hasUnderlyingInstrRegistry()) s += "UnderlyingInstrRegistry(595)= " + new String( FixUtils.trim(getUnderlyingInstrRegistry()) ) + "\n" ; 
		if (hasUnderlyingCountryOfIssue()) s += "UnderlyingCountryOfIssue(592)= " + new String( FixUtils.trim(getUnderlyingCountryOfIssue()) ) + "\n" ; 
		if (hasUnderlyingStateOrProvinceOfIssue()) s += "UnderlyingStateOrProvinceOfIssue(593)= " + new String( FixUtils.trim(getUnderlyingStateOrProvinceOfIssue()) ) + "\n" ; 
		if (hasUnderlyingLocaleOfIssue()) s += "UnderlyingLocaleOfIssue(594)= " + new String( FixUtils.trim(getUnderlyingLocaleOfIssue()) ) + "\n" ; 
		if (hasUnderlyingRedemptionDate()) s += "UnderlyingRedemptionDate(247)= " + new String( FixUtils.trim(getUnderlyingRedemptionDate()) ) + "\n" ; 
		if (hasUnderlyingStrikePrice()) s += "UnderlyingStrikePrice(316)= " + getUnderlyingStrikePrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingStrikeCurrency()) s += "UnderlyingStrikeCurrency(941)= " + new String( FixUtils.trim(getUnderlyingStrikeCurrency()) ) + "\n" ; 
		if (hasUnderlyingOptAttribute()) s += "UnderlyingOptAttribute(317)= " + getUnderlyingOptAttribute() + "\n" ; 
		if (hasUnderlyingContractMultiplier()) s += "UnderlyingContractMultiplier(436)= " + getUnderlyingContractMultiplier() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingUnitOfMeasure()) s += "UnderlyingUnitOfMeasure(998)= " + new String( FixUtils.trim(getUnderlyingUnitOfMeasure()) ) + "\n" ; 
		if (hasUnderlyingTimeUnit()) s += "UnderlyingTimeUnit(1000)= " + new String( FixUtils.trim(getUnderlyingTimeUnit()) ) + "\n" ; 
		if (hasUnderlyingExerciseStyle()) s += "UnderlyingExerciseStyle(1419)= " + getUnderlyingExerciseStyle() + "\n" ; 
		if (hasUnderlyingUnitOfMeasureQty()) s += "UnderlyingUnitOfMeasureQty(1423)= " + getUnderlyingUnitOfMeasureQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingPriceUnitOfMeasure()) s += "UnderlyingPriceUnitOfMeasure(1424)= " + new String( FixUtils.trim(getUnderlyingPriceUnitOfMeasure()) ) + "\n" ; 
		if (hasUnderlyingPriceUnitOfMeasureQty()) s += "UnderlyingPriceUnitOfMeasureQty(1425)= " + getUnderlyingPriceUnitOfMeasureQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingContractMultiplierUnit()) s += "UnderlyingContractMultiplierUnit(1437)= " + getUnderlyingContractMultiplierUnit() + "\n" ; 
		if (hasUnderlyingFlowScheduleType()) s += "UnderlyingFlowScheduleType(1441)= " + getUnderlyingFlowScheduleType() + "\n" ; 
		if (hasUnderlyingCouponRate()) s += "UnderlyingCouponRate(435)= " + getUnderlyingCouponRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingSecurityExchange()) s += "UnderlyingSecurityExchange(308)= " + new String( FixUtils.trim(getUnderlyingSecurityExchange()) ) + "\n" ; 
		if (hasUnderlyingIssuer()) s += "UnderlyingIssuer(306)= " + new String( FixUtils.trim(getUnderlyingIssuer()) ) + "\n" ; 
		if (hasEncodedUnderlyingIssuerLen()) s += "EncodedUnderlyingIssuerLen(362)= " + getEncodedUnderlyingIssuerLen() + "\n" ; 
		if (hasEncodedUnderlyingIssuer()) s += "EncodedUnderlyingIssuer(363)= " + new String( FixUtils.trim(getEncodedUnderlyingIssuer()) ) + "\n" ; 
		if (hasUnderlyingSecurityDesc()) s += "UnderlyingSecurityDesc(307)= " + new String( FixUtils.trim(getUnderlyingSecurityDesc()) ) + "\n" ; 
		if (hasEncodedUnderlyingSecurityDescLen()) s += "EncodedUnderlyingSecurityDescLen(364)= " + getEncodedUnderlyingSecurityDescLen() + "\n" ; 
		if (hasEncodedUnderlyingSecurityDesc()) s += "EncodedUnderlyingSecurityDesc(365)= " + new String( FixUtils.trim(getEncodedUnderlyingSecurityDesc()) ) + "\n" ; 
		if (hasUnderlyingCPProgram()) s += "UnderlyingCPProgram(877)= " + new String( FixUtils.trim(getUnderlyingCPProgram()) ) + "\n" ; 
		if (hasUnderlyingCPRegType()) s += "UnderlyingCPRegType(878)= " + new String( FixUtils.trim(getUnderlyingCPRegType()) ) + "\n" ; 
		if (hasUnderlyingAllocationPercent()) s += "UnderlyingAllocationPercent(972)= " + getUnderlyingAllocationPercent() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingCurrency()) s += "UnderlyingCurrency(318)= " + new String( FixUtils.trim(getUnderlyingCurrency()) ) + "\n" ; 
		if (hasUnderlyingQty()) s += "UnderlyingQty(879)= " + getUnderlyingQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingSettlementType()) s += "UnderlyingSettlementType(975)= " + getUnderlyingSettlementType() + "\n" ; 
		if (hasUnderlyingCashAmount()) s += "UnderlyingCashAmount(973)= " + getUnderlyingCashAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingCashType()) s += "UnderlyingCashType(974)= " + new String( FixUtils.trim(getUnderlyingCashType()) ) + "\n" ; 
		if (hasUnderlyingPx()) s += "UnderlyingPx(810)= " + getUnderlyingPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingDirtyPrice()) s += "UnderlyingDirtyPrice(882)= " + getUnderlyingDirtyPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingEndPrice()) s += "UnderlyingEndPrice(883)= " + getUnderlyingEndPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingStartValue()) s += "UnderlyingStartValue(884)= " + getUnderlyingStartValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingCurrentValue()) s += "UnderlyingCurrentValue(885)= " + getUnderlyingCurrentValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingEndValue()) s += "UnderlyingEndValue(886)= " + getUnderlyingEndValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingAdjustedQuantity()) s += "UnderlyingAdjustedQuantity(1044)= " + getUnderlyingAdjustedQuantity() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingFXRate()) s += "UnderlyingFXRate(1045)= " + getUnderlyingFXRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingFXRateCalc()) s += "UnderlyingFXRateCalc(1046)= " + getUnderlyingFXRateCalc() + "\n" ; 
		if (hasUnderlyingCapValue()) s += "UnderlyingCapValue(1038)= " + getUnderlyingCapValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingSettlMethod()) s += "UnderlyingSettlMethod(1039)= " + new String( FixUtils.trim(getUnderlyingSettlMethod()) ) + "\n" ; 
		if (hasUnderlyingPutOrCall()) s += "UnderlyingPutOrCall(315)= " + getUnderlyingPutOrCall() + "\n" ; 

		for (FixUndSecAltIDGrp fixUndSecAltIDGrp : undSecAltIDGrp) fixUndSecAltIDGrp.toString();
		for (FixUnderlyingStipulations fixUnderlyingStipulations : underlyingStipulations) fixUnderlyingStipulations.toString();
		for (FixUndlyInstrumentParties fixUndlyInstrumentParties : undlyInstrumentParties) fixUndlyInstrumentParties.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUnderlyingInstrument)) return false;

		FixUnderlyingInstrument msg = (FixUnderlyingInstrument) o;

		for (int i = 0; i < undSecAltIDGrp.length; i++)
			if (!undSecAltIDGrp[i].equals(msg.undSecAltIDGrp[i])) return false;
		for (int i = 0; i < underlyingStipulations.length; i++)
			if (!underlyingStipulations[i].equals(msg.underlyingStipulations[i])) return false;
		for (int i = 0; i < undlyInstrumentParties.length; i++)
			if (!undlyInstrumentParties[i].equals(msg.undlyInstrumentParties[i])) return false;
		if ((hasUnderlyingSymbol() && !msg.hasUnderlyingSymbol()) || (!hasUnderlyingSymbol() && msg.hasUnderlyingSymbol())) return false;
		if (!(!hasUnderlyingSymbol() && !msg.hasUnderlyingSymbol()) && !FixUtils.equals(getUnderlyingSymbol(), msg.getUnderlyingSymbol())) return false;
		if ((hasUnderlyingSymbolSfx() && !msg.hasUnderlyingSymbolSfx()) || (!hasUnderlyingSymbolSfx() && msg.hasUnderlyingSymbolSfx())) return false;
		if (!(!hasUnderlyingSymbolSfx() && !msg.hasUnderlyingSymbolSfx()) && !FixUtils.equals(getUnderlyingSymbolSfx(), msg.getUnderlyingSymbolSfx())) return false;
		if ((hasUnderlyingSecurityID() && !msg.hasUnderlyingSecurityID()) || (!hasUnderlyingSecurityID() && msg.hasUnderlyingSecurityID())) return false;
		if (!(!hasUnderlyingSecurityID() && !msg.hasUnderlyingSecurityID()) && !FixUtils.equals(getUnderlyingSecurityID(), msg.getUnderlyingSecurityID())) return false;
		if ((hasUnderlyingSecurityIDSource() && !msg.hasUnderlyingSecurityIDSource()) || (!hasUnderlyingSecurityIDSource() && msg.hasUnderlyingSecurityIDSource())) return false;
		if (!(!hasUnderlyingSecurityIDSource() && !msg.hasUnderlyingSecurityIDSource()) && !FixUtils.equals(getUnderlyingSecurityIDSource(), msg.getUnderlyingSecurityIDSource())) return false;
		if ((hasUnderlyingProduct() && !msg.hasUnderlyingProduct()) || (!hasUnderlyingProduct() && msg.hasUnderlyingProduct())) return false;
		if (!(!hasUnderlyingProduct() && !msg.hasUnderlyingProduct()) && !(getUnderlyingProduct()==msg.getUnderlyingProduct())) return false;
		if ((hasUnderlyingCFICode() && !msg.hasUnderlyingCFICode()) || (!hasUnderlyingCFICode() && msg.hasUnderlyingCFICode())) return false;
		if (!(!hasUnderlyingCFICode() && !msg.hasUnderlyingCFICode()) && !FixUtils.equals(getUnderlyingCFICode(), msg.getUnderlyingCFICode())) return false;
		if ((hasUnderlyingSecurityType() && !msg.hasUnderlyingSecurityType()) || (!hasUnderlyingSecurityType() && msg.hasUnderlyingSecurityType())) return false;
		if (!(!hasUnderlyingSecurityType() && !msg.hasUnderlyingSecurityType()) && !FixUtils.equals(getUnderlyingSecurityType(), msg.getUnderlyingSecurityType())) return false;
		if ((hasUnderlyingSecuritySubType() && !msg.hasUnderlyingSecuritySubType()) || (!hasUnderlyingSecuritySubType() && msg.hasUnderlyingSecuritySubType())) return false;
		if (!(!hasUnderlyingSecuritySubType() && !msg.hasUnderlyingSecuritySubType()) && !FixUtils.equals(getUnderlyingSecuritySubType(), msg.getUnderlyingSecuritySubType())) return false;
		if ((hasUnderlyingMaturityMonthYear() && !msg.hasUnderlyingMaturityMonthYear()) || (!hasUnderlyingMaturityMonthYear() && msg.hasUnderlyingMaturityMonthYear())) return false;
		if (!(!hasUnderlyingMaturityMonthYear() && !msg.hasUnderlyingMaturityMonthYear()) && !FixUtils.equals(getUnderlyingMaturityMonthYear(), msg.getUnderlyingMaturityMonthYear())) return false;
		if ((hasUnderlyingMaturityDate() && !msg.hasUnderlyingMaturityDate()) || (!hasUnderlyingMaturityDate() && msg.hasUnderlyingMaturityDate())) return false;
		if ((hasUnderlyingMaturityTime() && !msg.hasUnderlyingMaturityTime()) || (!hasUnderlyingMaturityTime() && msg.hasUnderlyingMaturityTime())) return false;
		if ((hasUnderlyingCouponPaymentDate() && !msg.hasUnderlyingCouponPaymentDate()) || (!hasUnderlyingCouponPaymentDate() && msg.hasUnderlyingCouponPaymentDate())) return false;
		if ((hasUnderlyingRestructuringType() && !msg.hasUnderlyingRestructuringType()) || (!hasUnderlyingRestructuringType() && msg.hasUnderlyingRestructuringType())) return false;
		if (!(!hasUnderlyingRestructuringType() && !msg.hasUnderlyingRestructuringType()) && !FixUtils.equals(getUnderlyingRestructuringType(), msg.getUnderlyingRestructuringType())) return false;
		if ((hasUnderlyingSeniority() && !msg.hasUnderlyingSeniority()) || (!hasUnderlyingSeniority() && msg.hasUnderlyingSeniority())) return false;
		if (!(!hasUnderlyingSeniority() && !msg.hasUnderlyingSeniority()) && !FixUtils.equals(getUnderlyingSeniority(), msg.getUnderlyingSeniority())) return false;
		if ((hasUnderlyingNotionalPercentageOutstanding() && !msg.hasUnderlyingNotionalPercentageOutstanding()) || (!hasUnderlyingNotionalPercentageOutstanding() && msg.hasUnderlyingNotionalPercentageOutstanding())) return false;
		if (!(!hasUnderlyingNotionalPercentageOutstanding() && !msg.hasUnderlyingNotionalPercentageOutstanding()) && !(getUnderlyingNotionalPercentageOutstanding()==msg.getUnderlyingNotionalPercentageOutstanding())) return false;
		if ((hasUnderlyingOriginalNotionalPercentageOutstanding() && !msg.hasUnderlyingOriginalNotionalPercentageOutstanding()) || (!hasUnderlyingOriginalNotionalPercentageOutstanding() && msg.hasUnderlyingOriginalNotionalPercentageOutstanding())) return false;
		if (!(!hasUnderlyingOriginalNotionalPercentageOutstanding() && !msg.hasUnderlyingOriginalNotionalPercentageOutstanding()) && !(getUnderlyingOriginalNotionalPercentageOutstanding()==msg.getUnderlyingOriginalNotionalPercentageOutstanding())) return false;
		if ((hasUnderlyingAttachmentPoint() && !msg.hasUnderlyingAttachmentPoint()) || (!hasUnderlyingAttachmentPoint() && msg.hasUnderlyingAttachmentPoint())) return false;
		if (!(!hasUnderlyingAttachmentPoint() && !msg.hasUnderlyingAttachmentPoint()) && !(getUnderlyingAttachmentPoint()==msg.getUnderlyingAttachmentPoint())) return false;
		if ((hasUnderlyingDetachmentPoint() && !msg.hasUnderlyingDetachmentPoint()) || (!hasUnderlyingDetachmentPoint() && msg.hasUnderlyingDetachmentPoint())) return false;
		if (!(!hasUnderlyingDetachmentPoint() && !msg.hasUnderlyingDetachmentPoint()) && !(getUnderlyingDetachmentPoint()==msg.getUnderlyingDetachmentPoint())) return false;
		if ((hasUnderlyingIssueDate() && !msg.hasUnderlyingIssueDate()) || (!hasUnderlyingIssueDate() && msg.hasUnderlyingIssueDate())) return false;
		if ((hasUnderlyingRepoCollateralSecurityType() && !msg.hasUnderlyingRepoCollateralSecurityType()) || (!hasUnderlyingRepoCollateralSecurityType() && msg.hasUnderlyingRepoCollateralSecurityType())) return false;
		if (!(!hasUnderlyingRepoCollateralSecurityType() && !msg.hasUnderlyingRepoCollateralSecurityType()) && !(getUnderlyingRepoCollateralSecurityType()==msg.getUnderlyingRepoCollateralSecurityType())) return false;
		if ((hasUnderlyingRepurchaseTerm() && !msg.hasUnderlyingRepurchaseTerm()) || (!hasUnderlyingRepurchaseTerm() && msg.hasUnderlyingRepurchaseTerm())) return false;
		if (!(!hasUnderlyingRepurchaseTerm() && !msg.hasUnderlyingRepurchaseTerm()) && !(getUnderlyingRepurchaseTerm()==msg.getUnderlyingRepurchaseTerm())) return false;
		if ((hasUnderlyingRepurchaseRate() && !msg.hasUnderlyingRepurchaseRate()) || (!hasUnderlyingRepurchaseRate() && msg.hasUnderlyingRepurchaseRate())) return false;
		if (!(!hasUnderlyingRepurchaseRate() && !msg.hasUnderlyingRepurchaseRate()) && !(getUnderlyingRepurchaseRate()==msg.getUnderlyingRepurchaseRate())) return false;
		if ((hasUnderlyingFactor() && !msg.hasUnderlyingFactor()) || (!hasUnderlyingFactor() && msg.hasUnderlyingFactor())) return false;
		if (!(!hasUnderlyingFactor() && !msg.hasUnderlyingFactor()) && !(getUnderlyingFactor()==msg.getUnderlyingFactor())) return false;
		if ((hasUnderlyingCreditRating() && !msg.hasUnderlyingCreditRating()) || (!hasUnderlyingCreditRating() && msg.hasUnderlyingCreditRating())) return false;
		if (!(!hasUnderlyingCreditRating() && !msg.hasUnderlyingCreditRating()) && !FixUtils.equals(getUnderlyingCreditRating(), msg.getUnderlyingCreditRating())) return false;
		if ((hasUnderlyingInstrRegistry() && !msg.hasUnderlyingInstrRegistry()) || (!hasUnderlyingInstrRegistry() && msg.hasUnderlyingInstrRegistry())) return false;
		if (!(!hasUnderlyingInstrRegistry() && !msg.hasUnderlyingInstrRegistry()) && !FixUtils.equals(getUnderlyingInstrRegistry(), msg.getUnderlyingInstrRegistry())) return false;
		if ((hasUnderlyingCountryOfIssue() && !msg.hasUnderlyingCountryOfIssue()) || (!hasUnderlyingCountryOfIssue() && msg.hasUnderlyingCountryOfIssue())) return false;
		if (!(!hasUnderlyingCountryOfIssue() && !msg.hasUnderlyingCountryOfIssue()) && !FixUtils.equals(getUnderlyingCountryOfIssue(), msg.getUnderlyingCountryOfIssue())) return false;
		if ((hasUnderlyingStateOrProvinceOfIssue() && !msg.hasUnderlyingStateOrProvinceOfIssue()) || (!hasUnderlyingStateOrProvinceOfIssue() && msg.hasUnderlyingStateOrProvinceOfIssue())) return false;
		if (!(!hasUnderlyingStateOrProvinceOfIssue() && !msg.hasUnderlyingStateOrProvinceOfIssue()) && !FixUtils.equals(getUnderlyingStateOrProvinceOfIssue(), msg.getUnderlyingStateOrProvinceOfIssue())) return false;
		if ((hasUnderlyingLocaleOfIssue() && !msg.hasUnderlyingLocaleOfIssue()) || (!hasUnderlyingLocaleOfIssue() && msg.hasUnderlyingLocaleOfIssue())) return false;
		if (!(!hasUnderlyingLocaleOfIssue() && !msg.hasUnderlyingLocaleOfIssue()) && !FixUtils.equals(getUnderlyingLocaleOfIssue(), msg.getUnderlyingLocaleOfIssue())) return false;
		if ((hasUnderlyingRedemptionDate() && !msg.hasUnderlyingRedemptionDate()) || (!hasUnderlyingRedemptionDate() && msg.hasUnderlyingRedemptionDate())) return false;
		if ((hasUnderlyingStrikePrice() && !msg.hasUnderlyingStrikePrice()) || (!hasUnderlyingStrikePrice() && msg.hasUnderlyingStrikePrice())) return false;
		if (!(!hasUnderlyingStrikePrice() && !msg.hasUnderlyingStrikePrice()) && !(getUnderlyingStrikePrice()==msg.getUnderlyingStrikePrice())) return false;
		if ((hasUnderlyingStrikeCurrency() && !msg.hasUnderlyingStrikeCurrency()) || (!hasUnderlyingStrikeCurrency() && msg.hasUnderlyingStrikeCurrency())) return false;
		if (!(!hasUnderlyingStrikeCurrency() && !msg.hasUnderlyingStrikeCurrency()) && !FixUtils.equals(getUnderlyingStrikeCurrency(), msg.getUnderlyingStrikeCurrency())) return false;
		if ((hasUnderlyingOptAttribute() && !msg.hasUnderlyingOptAttribute()) || (!hasUnderlyingOptAttribute() && msg.hasUnderlyingOptAttribute())) return false;
		if (!(!hasUnderlyingOptAttribute() && !msg.hasUnderlyingOptAttribute()) && !(getUnderlyingOptAttribute()==msg.getUnderlyingOptAttribute())) return false;
		if ((hasUnderlyingContractMultiplier() && !msg.hasUnderlyingContractMultiplier()) || (!hasUnderlyingContractMultiplier() && msg.hasUnderlyingContractMultiplier())) return false;
		if (!(!hasUnderlyingContractMultiplier() && !msg.hasUnderlyingContractMultiplier()) && !(getUnderlyingContractMultiplier()==msg.getUnderlyingContractMultiplier())) return false;
		if ((hasUnderlyingUnitOfMeasure() && !msg.hasUnderlyingUnitOfMeasure()) || (!hasUnderlyingUnitOfMeasure() && msg.hasUnderlyingUnitOfMeasure())) return false;
		if (!(!hasUnderlyingUnitOfMeasure() && !msg.hasUnderlyingUnitOfMeasure()) && !FixUtils.equals(getUnderlyingUnitOfMeasure(), msg.getUnderlyingUnitOfMeasure())) return false;
		if ((hasUnderlyingTimeUnit() && !msg.hasUnderlyingTimeUnit()) || (!hasUnderlyingTimeUnit() && msg.hasUnderlyingTimeUnit())) return false;
		if (!(!hasUnderlyingTimeUnit() && !msg.hasUnderlyingTimeUnit()) && !FixUtils.equals(getUnderlyingTimeUnit(), msg.getUnderlyingTimeUnit())) return false;
		if ((hasUnderlyingExerciseStyle() && !msg.hasUnderlyingExerciseStyle()) || (!hasUnderlyingExerciseStyle() && msg.hasUnderlyingExerciseStyle())) return false;
		if (!(!hasUnderlyingExerciseStyle() && !msg.hasUnderlyingExerciseStyle()) && !(getUnderlyingExerciseStyle()==msg.getUnderlyingExerciseStyle())) return false;
		if ((hasUnderlyingUnitOfMeasureQty() && !msg.hasUnderlyingUnitOfMeasureQty()) || (!hasUnderlyingUnitOfMeasureQty() && msg.hasUnderlyingUnitOfMeasureQty())) return false;
		if (!(!hasUnderlyingUnitOfMeasureQty() && !msg.hasUnderlyingUnitOfMeasureQty()) && !(getUnderlyingUnitOfMeasureQty()==msg.getUnderlyingUnitOfMeasureQty())) return false;
		if ((hasUnderlyingPriceUnitOfMeasure() && !msg.hasUnderlyingPriceUnitOfMeasure()) || (!hasUnderlyingPriceUnitOfMeasure() && msg.hasUnderlyingPriceUnitOfMeasure())) return false;
		if (!(!hasUnderlyingPriceUnitOfMeasure() && !msg.hasUnderlyingPriceUnitOfMeasure()) && !FixUtils.equals(getUnderlyingPriceUnitOfMeasure(), msg.getUnderlyingPriceUnitOfMeasure())) return false;
		if ((hasUnderlyingPriceUnitOfMeasureQty() && !msg.hasUnderlyingPriceUnitOfMeasureQty()) || (!hasUnderlyingPriceUnitOfMeasureQty() && msg.hasUnderlyingPriceUnitOfMeasureQty())) return false;
		if (!(!hasUnderlyingPriceUnitOfMeasureQty() && !msg.hasUnderlyingPriceUnitOfMeasureQty()) && !(getUnderlyingPriceUnitOfMeasureQty()==msg.getUnderlyingPriceUnitOfMeasureQty())) return false;
		if ((hasUnderlyingContractMultiplierUnit() && !msg.hasUnderlyingContractMultiplierUnit()) || (!hasUnderlyingContractMultiplierUnit() && msg.hasUnderlyingContractMultiplierUnit())) return false;
		if (!(!hasUnderlyingContractMultiplierUnit() && !msg.hasUnderlyingContractMultiplierUnit()) && !(getUnderlyingContractMultiplierUnit()==msg.getUnderlyingContractMultiplierUnit())) return false;
		if ((hasUnderlyingFlowScheduleType() && !msg.hasUnderlyingFlowScheduleType()) || (!hasUnderlyingFlowScheduleType() && msg.hasUnderlyingFlowScheduleType())) return false;
		if (!(!hasUnderlyingFlowScheduleType() && !msg.hasUnderlyingFlowScheduleType()) && !(getUnderlyingFlowScheduleType()==msg.getUnderlyingFlowScheduleType())) return false;
		if ((hasUnderlyingCouponRate() && !msg.hasUnderlyingCouponRate()) || (!hasUnderlyingCouponRate() && msg.hasUnderlyingCouponRate())) return false;
		if (!(!hasUnderlyingCouponRate() && !msg.hasUnderlyingCouponRate()) && !(getUnderlyingCouponRate()==msg.getUnderlyingCouponRate())) return false;
		if ((hasUnderlyingSecurityExchange() && !msg.hasUnderlyingSecurityExchange()) || (!hasUnderlyingSecurityExchange() && msg.hasUnderlyingSecurityExchange())) return false;
		if (!(!hasUnderlyingSecurityExchange() && !msg.hasUnderlyingSecurityExchange()) && !FixUtils.equals(getUnderlyingSecurityExchange(), msg.getUnderlyingSecurityExchange())) return false;
		if ((hasUnderlyingIssuer() && !msg.hasUnderlyingIssuer()) || (!hasUnderlyingIssuer() && msg.hasUnderlyingIssuer())) return false;
		if (!(!hasUnderlyingIssuer() && !msg.hasUnderlyingIssuer()) && !FixUtils.equals(getUnderlyingIssuer(), msg.getUnderlyingIssuer())) return false;
		if ((hasEncodedUnderlyingIssuerLen() && !msg.hasEncodedUnderlyingIssuerLen()) || (!hasEncodedUnderlyingIssuerLen() && msg.hasEncodedUnderlyingIssuerLen())) return false;
		if (!(!hasEncodedUnderlyingIssuerLen() && !msg.hasEncodedUnderlyingIssuerLen()) && !(getEncodedUnderlyingIssuerLen()==msg.getEncodedUnderlyingIssuerLen())) return false;
		if ((hasEncodedUnderlyingIssuer() && !msg.hasEncodedUnderlyingIssuer()) || (!hasEncodedUnderlyingIssuer() && msg.hasEncodedUnderlyingIssuer())) return false;
		if (!(!hasEncodedUnderlyingIssuer() && !msg.hasEncodedUnderlyingIssuer()) && !FixUtils.equals(getEncodedUnderlyingIssuer(), msg.getEncodedUnderlyingIssuer())) return false;
		if ((hasUnderlyingSecurityDesc() && !msg.hasUnderlyingSecurityDesc()) || (!hasUnderlyingSecurityDesc() && msg.hasUnderlyingSecurityDesc())) return false;
		if (!(!hasUnderlyingSecurityDesc() && !msg.hasUnderlyingSecurityDesc()) && !FixUtils.equals(getUnderlyingSecurityDesc(), msg.getUnderlyingSecurityDesc())) return false;
		if ((hasEncodedUnderlyingSecurityDescLen() && !msg.hasEncodedUnderlyingSecurityDescLen()) || (!hasEncodedUnderlyingSecurityDescLen() && msg.hasEncodedUnderlyingSecurityDescLen())) return false;
		if (!(!hasEncodedUnderlyingSecurityDescLen() && !msg.hasEncodedUnderlyingSecurityDescLen()) && !(getEncodedUnderlyingSecurityDescLen()==msg.getEncodedUnderlyingSecurityDescLen())) return false;
		if ((hasEncodedUnderlyingSecurityDesc() && !msg.hasEncodedUnderlyingSecurityDesc()) || (!hasEncodedUnderlyingSecurityDesc() && msg.hasEncodedUnderlyingSecurityDesc())) return false;
		if (!(!hasEncodedUnderlyingSecurityDesc() && !msg.hasEncodedUnderlyingSecurityDesc()) && !FixUtils.equals(getEncodedUnderlyingSecurityDesc(), msg.getEncodedUnderlyingSecurityDesc())) return false;
		if ((hasUnderlyingCPProgram() && !msg.hasUnderlyingCPProgram()) || (!hasUnderlyingCPProgram() && msg.hasUnderlyingCPProgram())) return false;
		if (!(!hasUnderlyingCPProgram() && !msg.hasUnderlyingCPProgram()) && !FixUtils.equals(getUnderlyingCPProgram(), msg.getUnderlyingCPProgram())) return false;
		if ((hasUnderlyingCPRegType() && !msg.hasUnderlyingCPRegType()) || (!hasUnderlyingCPRegType() && msg.hasUnderlyingCPRegType())) return false;
		if (!(!hasUnderlyingCPRegType() && !msg.hasUnderlyingCPRegType()) && !FixUtils.equals(getUnderlyingCPRegType(), msg.getUnderlyingCPRegType())) return false;
		if ((hasUnderlyingAllocationPercent() && !msg.hasUnderlyingAllocationPercent()) || (!hasUnderlyingAllocationPercent() && msg.hasUnderlyingAllocationPercent())) return false;
		if (!(!hasUnderlyingAllocationPercent() && !msg.hasUnderlyingAllocationPercent()) && !(getUnderlyingAllocationPercent()==msg.getUnderlyingAllocationPercent())) return false;
		if ((hasUnderlyingCurrency() && !msg.hasUnderlyingCurrency()) || (!hasUnderlyingCurrency() && msg.hasUnderlyingCurrency())) return false;
		if (!(!hasUnderlyingCurrency() && !msg.hasUnderlyingCurrency()) && !FixUtils.equals(getUnderlyingCurrency(), msg.getUnderlyingCurrency())) return false;
		if ((hasUnderlyingQty() && !msg.hasUnderlyingQty()) || (!hasUnderlyingQty() && msg.hasUnderlyingQty())) return false;
		if (!(!hasUnderlyingQty() && !msg.hasUnderlyingQty()) && !(getUnderlyingQty()==msg.getUnderlyingQty())) return false;
		if ((hasUnderlyingSettlementType() && !msg.hasUnderlyingSettlementType()) || (!hasUnderlyingSettlementType() && msg.hasUnderlyingSettlementType())) return false;
		if (!(!hasUnderlyingSettlementType() && !msg.hasUnderlyingSettlementType()) && !(getUnderlyingSettlementType()==msg.getUnderlyingSettlementType())) return false;
		if ((hasUnderlyingCashAmount() && !msg.hasUnderlyingCashAmount()) || (!hasUnderlyingCashAmount() && msg.hasUnderlyingCashAmount())) return false;
		if (!(!hasUnderlyingCashAmount() && !msg.hasUnderlyingCashAmount()) && !(getUnderlyingCashAmount()==msg.getUnderlyingCashAmount())) return false;
		if ((hasUnderlyingCashType() && !msg.hasUnderlyingCashType()) || (!hasUnderlyingCashType() && msg.hasUnderlyingCashType())) return false;
		if (!(!hasUnderlyingCashType() && !msg.hasUnderlyingCashType()) && !FixUtils.equals(getUnderlyingCashType(), msg.getUnderlyingCashType())) return false;
		if ((hasUnderlyingPx() && !msg.hasUnderlyingPx()) || (!hasUnderlyingPx() && msg.hasUnderlyingPx())) return false;
		if (!(!hasUnderlyingPx() && !msg.hasUnderlyingPx()) && !(getUnderlyingPx()==msg.getUnderlyingPx())) return false;
		if ((hasUnderlyingDirtyPrice() && !msg.hasUnderlyingDirtyPrice()) || (!hasUnderlyingDirtyPrice() && msg.hasUnderlyingDirtyPrice())) return false;
		if (!(!hasUnderlyingDirtyPrice() && !msg.hasUnderlyingDirtyPrice()) && !(getUnderlyingDirtyPrice()==msg.getUnderlyingDirtyPrice())) return false;
		if ((hasUnderlyingEndPrice() && !msg.hasUnderlyingEndPrice()) || (!hasUnderlyingEndPrice() && msg.hasUnderlyingEndPrice())) return false;
		if (!(!hasUnderlyingEndPrice() && !msg.hasUnderlyingEndPrice()) && !(getUnderlyingEndPrice()==msg.getUnderlyingEndPrice())) return false;
		if ((hasUnderlyingStartValue() && !msg.hasUnderlyingStartValue()) || (!hasUnderlyingStartValue() && msg.hasUnderlyingStartValue())) return false;
		if (!(!hasUnderlyingStartValue() && !msg.hasUnderlyingStartValue()) && !(getUnderlyingStartValue()==msg.getUnderlyingStartValue())) return false;
		if ((hasUnderlyingCurrentValue() && !msg.hasUnderlyingCurrentValue()) || (!hasUnderlyingCurrentValue() && msg.hasUnderlyingCurrentValue())) return false;
		if (!(!hasUnderlyingCurrentValue() && !msg.hasUnderlyingCurrentValue()) && !(getUnderlyingCurrentValue()==msg.getUnderlyingCurrentValue())) return false;
		if ((hasUnderlyingEndValue() && !msg.hasUnderlyingEndValue()) || (!hasUnderlyingEndValue() && msg.hasUnderlyingEndValue())) return false;
		if (!(!hasUnderlyingEndValue() && !msg.hasUnderlyingEndValue()) && !(getUnderlyingEndValue()==msg.getUnderlyingEndValue())) return false;
		if ((hasUnderlyingAdjustedQuantity() && !msg.hasUnderlyingAdjustedQuantity()) || (!hasUnderlyingAdjustedQuantity() && msg.hasUnderlyingAdjustedQuantity())) return false;
		if (!(!hasUnderlyingAdjustedQuantity() && !msg.hasUnderlyingAdjustedQuantity()) && !(getUnderlyingAdjustedQuantity()==msg.getUnderlyingAdjustedQuantity())) return false;
		if ((hasUnderlyingFXRate() && !msg.hasUnderlyingFXRate()) || (!hasUnderlyingFXRate() && msg.hasUnderlyingFXRate())) return false;
		if (!(!hasUnderlyingFXRate() && !msg.hasUnderlyingFXRate()) && !(getUnderlyingFXRate()==msg.getUnderlyingFXRate())) return false;
		if ((hasUnderlyingFXRateCalc() && !msg.hasUnderlyingFXRateCalc()) || (!hasUnderlyingFXRateCalc() && msg.hasUnderlyingFXRateCalc())) return false;
		if (!(!hasUnderlyingFXRateCalc() && !msg.hasUnderlyingFXRateCalc()) && !(getUnderlyingFXRateCalc()==msg.getUnderlyingFXRateCalc())) return false;
		if ((hasUnderlyingCapValue() && !msg.hasUnderlyingCapValue()) || (!hasUnderlyingCapValue() && msg.hasUnderlyingCapValue())) return false;
		if (!(!hasUnderlyingCapValue() && !msg.hasUnderlyingCapValue()) && !(getUnderlyingCapValue()==msg.getUnderlyingCapValue())) return false;
		if ((hasUnderlyingSettlMethod() && !msg.hasUnderlyingSettlMethod()) || (!hasUnderlyingSettlMethod() && msg.hasUnderlyingSettlMethod())) return false;
		if (!(!hasUnderlyingSettlMethod() && !msg.hasUnderlyingSettlMethod()) && !FixUtils.equals(getUnderlyingSettlMethod(), msg.getUnderlyingSettlMethod())) return false;
		if ((hasUnderlyingPutOrCall() && !msg.hasUnderlyingPutOrCall()) || (!hasUnderlyingPutOrCall() && msg.hasUnderlyingPutOrCall())) return false;
		if (!(!hasUnderlyingPutOrCall() && !msg.hasUnderlyingPutOrCall()) && !(getUnderlyingPutOrCall()==msg.getUnderlyingPutOrCall())) return false;
		return true;
	}
	public FixUnderlyingInstrument clone ( FixUnderlyingInstrument out ) {
		if ( hasUnderlyingSymbol())
			out.setUnderlyingSymbol(getUnderlyingSymbol());
		if ( hasUnderlyingSymbolSfx())
			out.setUnderlyingSymbolSfx(getUnderlyingSymbolSfx());
		if ( hasUnderlyingSecurityID())
			out.setUnderlyingSecurityID(getUnderlyingSecurityID());
		if ( hasUnderlyingSecurityIDSource())
			out.setUnderlyingSecurityIDSource(getUnderlyingSecurityIDSource());
		if ( hasUnderlyingProduct())
			out.setUnderlyingProduct(getUnderlyingProduct());
		if ( hasUnderlyingCFICode())
			out.setUnderlyingCFICode(getUnderlyingCFICode());
		if ( hasUnderlyingSecurityType())
			out.setUnderlyingSecurityType(getUnderlyingSecurityType());
		if ( hasUnderlyingSecuritySubType())
			out.setUnderlyingSecuritySubType(getUnderlyingSecuritySubType());
		if ( hasUnderlyingMaturityMonthYear())
			out.setUnderlyingMaturityMonthYear(getUnderlyingMaturityMonthYear());
		if ( hasUnderlyingMaturityDate())
			out.setUnderlyingMaturityDate(getUnderlyingMaturityDate());
		if ( hasUnderlyingMaturityTime())
			out.setUnderlyingMaturityTime(getUnderlyingMaturityTime());
		if ( hasUnderlyingCouponPaymentDate())
			out.setUnderlyingCouponPaymentDate(getUnderlyingCouponPaymentDate());
		if ( hasUnderlyingRestructuringType())
			out.setUnderlyingRestructuringType(getUnderlyingRestructuringType());
		if ( hasUnderlyingSeniority())
			out.setUnderlyingSeniority(getUnderlyingSeniority());
		if ( hasUnderlyingNotionalPercentageOutstanding())
			out.setUnderlyingNotionalPercentageOutstanding(getUnderlyingNotionalPercentageOutstanding());
		if ( hasUnderlyingOriginalNotionalPercentageOutstanding())
			out.setUnderlyingOriginalNotionalPercentageOutstanding(getUnderlyingOriginalNotionalPercentageOutstanding());
		if ( hasUnderlyingAttachmentPoint())
			out.setUnderlyingAttachmentPoint(getUnderlyingAttachmentPoint());
		if ( hasUnderlyingDetachmentPoint())
			out.setUnderlyingDetachmentPoint(getUnderlyingDetachmentPoint());
		if ( hasUnderlyingIssueDate())
			out.setUnderlyingIssueDate(getUnderlyingIssueDate());
		if ( hasUnderlyingRepoCollateralSecurityType())
			out.setUnderlyingRepoCollateralSecurityType(getUnderlyingRepoCollateralSecurityType());
		if ( hasUnderlyingRepurchaseTerm())
			out.setUnderlyingRepurchaseTerm(getUnderlyingRepurchaseTerm());
		if ( hasUnderlyingRepurchaseRate())
			out.setUnderlyingRepurchaseRate(getUnderlyingRepurchaseRate());
		if ( hasUnderlyingFactor())
			out.setUnderlyingFactor(getUnderlyingFactor());
		if ( hasUnderlyingCreditRating())
			out.setUnderlyingCreditRating(getUnderlyingCreditRating());
		if ( hasUnderlyingInstrRegistry())
			out.setUnderlyingInstrRegistry(getUnderlyingInstrRegistry());
		if ( hasUnderlyingCountryOfIssue())
			out.setUnderlyingCountryOfIssue(getUnderlyingCountryOfIssue());
		if ( hasUnderlyingStateOrProvinceOfIssue())
			out.setUnderlyingStateOrProvinceOfIssue(getUnderlyingStateOrProvinceOfIssue());
		if ( hasUnderlyingLocaleOfIssue())
			out.setUnderlyingLocaleOfIssue(getUnderlyingLocaleOfIssue());
		if ( hasUnderlyingRedemptionDate())
			out.setUnderlyingRedemptionDate(getUnderlyingRedemptionDate());
		if ( hasUnderlyingStrikePrice())
			out.setUnderlyingStrikePrice(getUnderlyingStrikePrice());
		if ( hasUnderlyingStrikeCurrency())
			out.setUnderlyingStrikeCurrency(getUnderlyingStrikeCurrency());
		if ( hasUnderlyingOptAttribute())
			out.setUnderlyingOptAttribute(getUnderlyingOptAttribute());
		if ( hasUnderlyingContractMultiplier())
			out.setUnderlyingContractMultiplier(getUnderlyingContractMultiplier());
		if ( hasUnderlyingUnitOfMeasure())
			out.setUnderlyingUnitOfMeasure(getUnderlyingUnitOfMeasure());
		if ( hasUnderlyingTimeUnit())
			out.setUnderlyingTimeUnit(getUnderlyingTimeUnit());
		if ( hasUnderlyingExerciseStyle())
			out.setUnderlyingExerciseStyle(getUnderlyingExerciseStyle());
		if ( hasUnderlyingUnitOfMeasureQty())
			out.setUnderlyingUnitOfMeasureQty(getUnderlyingUnitOfMeasureQty());
		if ( hasUnderlyingPriceUnitOfMeasure())
			out.setUnderlyingPriceUnitOfMeasure(getUnderlyingPriceUnitOfMeasure());
		if ( hasUnderlyingPriceUnitOfMeasureQty())
			out.setUnderlyingPriceUnitOfMeasureQty(getUnderlyingPriceUnitOfMeasureQty());
		if ( hasUnderlyingContractMultiplierUnit())
			out.setUnderlyingContractMultiplierUnit(getUnderlyingContractMultiplierUnit());
		if ( hasUnderlyingFlowScheduleType())
			out.setUnderlyingFlowScheduleType(getUnderlyingFlowScheduleType());
		if ( hasUnderlyingCouponRate())
			out.setUnderlyingCouponRate(getUnderlyingCouponRate());
		if ( hasUnderlyingSecurityExchange())
			out.setUnderlyingSecurityExchange(getUnderlyingSecurityExchange());
		if ( hasUnderlyingIssuer())
			out.setUnderlyingIssuer(getUnderlyingIssuer());
		if ( hasEncodedUnderlyingIssuerLen())
			out.setEncodedUnderlyingIssuerLen(getEncodedUnderlyingIssuerLen());
		if ( hasEncodedUnderlyingIssuer())
			out.setEncodedUnderlyingIssuer(getEncodedUnderlyingIssuer());
		if ( hasUnderlyingSecurityDesc())
			out.setUnderlyingSecurityDesc(getUnderlyingSecurityDesc());
		if ( hasEncodedUnderlyingSecurityDescLen())
			out.setEncodedUnderlyingSecurityDescLen(getEncodedUnderlyingSecurityDescLen());
		if ( hasEncodedUnderlyingSecurityDesc())
			out.setEncodedUnderlyingSecurityDesc(getEncodedUnderlyingSecurityDesc());
		if ( hasUnderlyingCPProgram())
			out.setUnderlyingCPProgram(getUnderlyingCPProgram());
		if ( hasUnderlyingCPRegType())
			out.setUnderlyingCPRegType(getUnderlyingCPRegType());
		if ( hasUnderlyingAllocationPercent())
			out.setUnderlyingAllocationPercent(getUnderlyingAllocationPercent());
		if ( hasUnderlyingCurrency())
			out.setUnderlyingCurrency(getUnderlyingCurrency());
		if ( hasUnderlyingQty())
			out.setUnderlyingQty(getUnderlyingQty());
		if ( hasUnderlyingSettlementType())
			out.setUnderlyingSettlementType(getUnderlyingSettlementType());
		if ( hasUnderlyingCashAmount())
			out.setUnderlyingCashAmount(getUnderlyingCashAmount());
		if ( hasUnderlyingCashType())
			out.setUnderlyingCashType(getUnderlyingCashType());
		if ( hasUnderlyingPx())
			out.setUnderlyingPx(getUnderlyingPx());
		if ( hasUnderlyingDirtyPrice())
			out.setUnderlyingDirtyPrice(getUnderlyingDirtyPrice());
		if ( hasUnderlyingEndPrice())
			out.setUnderlyingEndPrice(getUnderlyingEndPrice());
		if ( hasUnderlyingStartValue())
			out.setUnderlyingStartValue(getUnderlyingStartValue());
		if ( hasUnderlyingCurrentValue())
			out.setUnderlyingCurrentValue(getUnderlyingCurrentValue());
		if ( hasUnderlyingEndValue())
			out.setUnderlyingEndValue(getUnderlyingEndValue());
		if ( hasUnderlyingAdjustedQuantity())
			out.setUnderlyingAdjustedQuantity(getUnderlyingAdjustedQuantity());
		if ( hasUnderlyingFXRate())
			out.setUnderlyingFXRate(getUnderlyingFXRate());
		if ( hasUnderlyingFXRateCalc())
			out.setUnderlyingFXRateCalc(getUnderlyingFXRateCalc());
		if ( hasUnderlyingCapValue())
			out.setUnderlyingCapValue(getUnderlyingCapValue());
		if ( hasUnderlyingSettlMethod())
			out.setUnderlyingSettlMethod(getUnderlyingSettlMethod());
		if ( hasUnderlyingPutOrCall())
			out.setUnderlyingPutOrCall(getUnderlyingPutOrCall());
		int count = 0;
		count = 0;
		for (FixUndSecAltIDGrp fixUndSecAltIDGrp : undSecAltIDGrp) {
			if (!fixUndSecAltIDGrp.hasGroup()) continue;
			out.undSecAltIDGrp[count] = fixUndSecAltIDGrp.clone( out.undSecAltIDGrp[count] );
			count++;
		}
		count = 0;
		for (FixUnderlyingStipulations fixUnderlyingStipulations : underlyingStipulations) {
			if (!fixUnderlyingStipulations.hasGroup()) continue;
			out.underlyingStipulations[count] = fixUnderlyingStipulations.clone( out.underlyingStipulations[count] );
			count++;
		}
		count = 0;
		for (FixUndlyInstrumentParties fixUndlyInstrumentParties : undlyInstrumentParties) {
			if (!fixUndlyInstrumentParties.hasGroup()) continue;
			out.undlyInstrumentParties[count] = fixUndlyInstrumentParties.clone( out.undlyInstrumentParties[count] );
			count++;
		}
		return out;
	}

}
