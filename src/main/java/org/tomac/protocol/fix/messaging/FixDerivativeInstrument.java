package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixDerivativeInstrument extends FixGroup {
	private short hasDerivativeSymbol;
	byte[] derivativeSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeSymbolSfx;
	byte[] derivativeSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeSecurityID;
	byte[] derivativeSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeSecurityIDSource;
	byte[] derivativeSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeProduct;
	long derivativeProduct = 0;		
	private short hasDerivativeProductComplex;
	byte[] derivativeProductComplex = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivFlexProductEligibilityIndicator;
		boolean derivFlexProductEligibilityIndicator = false;		
	private short hasDerivativeSecurityGroup;
	byte[] derivativeSecurityGroup = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeCFICode;
	byte[] derivativeCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeSecurityType;
	byte[] derivativeSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeSecuritySubType;
	byte[] derivativeSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeMaturityMonthYear;
	byte[] derivativeMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeMaturityDate;
	byte[] derivativeMaturityDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeMaturityTime;
	byte[] derivativeMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeSettleOnOpenFlag;
	byte[] derivativeSettleOnOpenFlag = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeInstrmtAssignmentMethod;
	byte derivativeInstrmtAssignmentMethod = (byte)' ';		
	private short hasDerivativeSecurityStatus;
	byte[] derivativeSecurityStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeIssueDate;
	byte[] derivativeIssueDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeInstrRegistry;
	byte[] derivativeInstrRegistry = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeCountryOfIssue;
	byte[] derivativeCountryOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeStateOrProvinceOfIssue;
	byte[] derivativeStateOrProvinceOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeStrikePrice;
	long derivativeStrikePrice = 0;		
	private short hasDerivativeLocaleOfIssue;
	byte[] derivativeLocaleOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeStrikeCurrency;
	byte[] derivativeStrikeCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasDerivativeStrikeMultiplier;
	long derivativeStrikeMultiplier = 0;		
	private short hasDerivativeStrikeValue;
	long derivativeStrikeValue = 0;		
	private short hasDerivativeOptAttribute;
	byte derivativeOptAttribute = (byte)' ';		
	private short hasDerivativeContractMultiplier;
	long derivativeContractMultiplier = 0;		
	private short hasDerivativeMinPriceIncrement;
	long derivativeMinPriceIncrement = 0;		
	private short hasDerivativeMinPriceIncrementAmount;
	long derivativeMinPriceIncrementAmount = 0;		
	private short hasDerivativeContractMultiplierUnit;
	long derivativeContractMultiplierUnit = 0;		
	private short hasDerivativeFlowScheduleType;
	long derivativeFlowScheduleType = 0;		
	private short hasDerivativeUnitOfMeasure;
	byte[] derivativeUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeUnitOfMeasureQty;
	long derivativeUnitOfMeasureQty = 0;		
	private short hasDerivativePriceUnitOfMeasure;
	byte[] derivativePriceUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativePriceUnitOfMeasureQty;
	long derivativePriceUnitOfMeasureQty = 0;		
	private short hasDerivativeExerciseStyle;
	byte derivativeExerciseStyle = (byte)' ';		
	private short hasDerivativeOptPayAmount;
	long derivativeOptPayAmount = 0;		
	private short hasDerivativeTimeUnit;
	byte[] derivativeTimeUnit = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeSecurityExchange;
	byte[] derivativeSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativePositionLimit;
	long derivativePositionLimit = 0;		
	private short hasDerivativeNTPositionLimit;
	long derivativeNTPositionLimit = 0;		
	private short hasDerivativeSettlMethod;
	byte derivativeSettlMethod = (byte)' ';		
	private short hasDerivativePriceQuoteMethod;
	byte[] derivativePriceQuoteMethod = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeValuationMethod;
	byte[] derivativeValuationMethod = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeListMethod;
	long derivativeListMethod = 0;		
	private short hasDerivativeCapPrice;
	long derivativeCapPrice = 0;		
	private short hasDerivativeFloorPrice;
	long derivativeFloorPrice = 0;		
	private short hasDerivativePutOrCall;
	long derivativePutOrCall = 0;		
	private short hasDerivativeIssuer;
	byte[] derivativeIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeEncodedIssuerLen;
	long derivativeEncodedIssuerLen = 0;		
	private short hasDerivativeEncodedIssuer;
	byte[] derivativeEncodedIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeSecurityDesc;
	byte[] derivativeSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeEncodedSecurityDescLen;
	long derivativeEncodedSecurityDescLen = 0;		
	private short hasDerivativeEncodedSecurityDesc;
	byte[] derivativeEncodedSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeContractSettlMonth;
	byte[] derivativeContractSettlMonth = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixDerivativeSecurityAltIDGrp[] derivativeSecurityAltIDGrp;
		public FixDerivativeSecurityXML derivativeSecurityXML;
		public FixDerivativeEventsGrp[] derivativeEventsGrp;
		public FixDerivativeInstrumentParties[] derivativeInstrumentParties;
	
	public FixDerivativeInstrument() {
		this(false);
	}

	public FixDerivativeInstrument(boolean isRequired) {
		super(FixTags.DERIVATIVESYMBOL_INT);

		this.isRequired = isRequired;
		
		hasDerivativeSymbol = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeSecurityID = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeProduct = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeProductComplex = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeProductComplex = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivFlexProductEligibilityIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeSecurityGroup = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecurityGroup = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeCFICode = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeMaturityDate = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeMaturityDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeMaturityTime = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeSettleOnOpenFlag = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSettleOnOpenFlag = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeInstrmtAssignmentMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeSecurityStatus = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecurityStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeIssueDate = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeIssueDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeInstrRegistry = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeInstrRegistry = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeCountryOfIssue = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeCountryOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeStateOrProvinceOfIssue = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeStateOrProvinceOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeLocaleOfIssue = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeLocaleOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeStrikeCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeStrikeCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasDerivativeStrikeMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeStrikeValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeOptAttribute = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeMinPriceIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeMinPriceIncrementAmount = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativePriceUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;		
		derivativePriceUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativePriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeOptPayAmount = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeTimeUnit = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeTimeUnit = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativePositionLimit = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeNTPositionLimit = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeSettlMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativePriceQuoteMethod = FixUtils.TAG_HAS_NO_VALUE;		
		derivativePriceQuoteMethod = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeValuationMethod = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeValuationMethod = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeListMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeCapPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeFloorPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativePutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeIssuer = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeEncodedIssuerLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeEncodedIssuer = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeEncodedIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeEncodedSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeEncodedSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeContractSettlMonth = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeContractSettlMonth = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		derivativeSecurityAltIDGrp = new FixDerivativeSecurityAltIDGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) derivativeSecurityAltIDGrp[i] = new FixDerivativeSecurityAltIDGrp();
		derivativeSecurityXML = new FixDerivativeSecurityXML();
		derivativeEventsGrp = new FixDerivativeEventsGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) derivativeEventsGrp[i] = new FixDerivativeEventsGrp();
		derivativeInstrumentParties = new FixDerivativeInstrumentParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) derivativeInstrumentParties[i] = new FixDerivativeInstrumentParties();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasDerivativeSymbol()) return true;
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
            	case FixTags.DERIVATIVESYMBOL_INT:		
            		hasDerivativeSymbol = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESYMBOLSFX_INT:		
            		hasDerivativeSymbolSfx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESECURITYID_INT:		
            		hasDerivativeSecurityID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESECURITYIDSOURCE_INT:		
            		hasDerivativeSecurityIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEPRODUCT_INT:		
            		hasDerivativeProduct = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEPRODUCTCOMPLEX_INT:		
            		hasDerivativeProductComplex = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVFLEXPRODUCTELIGIBILITYINDICATOR_INT:		
            		hasDerivFlexProductEligibilityIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESECURITYGROUP_INT:		
            		hasDerivativeSecurityGroup = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVECFICODE_INT:		
            		hasDerivativeCFICode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESECURITYTYPE_INT:		
            		hasDerivativeSecurityType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESECURITYSUBTYPE_INT:		
            		hasDerivativeSecuritySubType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEMATURITYMONTHYEAR_INT:		
            		hasDerivativeMaturityMonthYear = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEMATURITYDATE_INT:		
            		hasDerivativeMaturityDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEMATURITYTIME_INT:		
            		hasDerivativeMaturityTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESETTLEONOPENFLAG_INT:		
            		hasDerivativeSettleOnOpenFlag = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEINSTRMTASSIGNMENTMETHOD_INT:		
            		hasDerivativeInstrmtAssignmentMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESECURITYSTATUS_INT:		
            		hasDerivativeSecurityStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEISSUEDATE_INT:		
            		hasDerivativeIssueDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEINSTRREGISTRY_INT:		
            		hasDerivativeInstrRegistry = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVECOUNTRYOFISSUE_INT:		
            		hasDerivativeCountryOfIssue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESTATEORPROVINCEOFISSUE_INT:		
            		hasDerivativeStateOrProvinceOfIssue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESTRIKEPRICE_INT:		
            		hasDerivativeStrikePrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVELOCALEOFISSUE_INT:		
            		hasDerivativeLocaleOfIssue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESTRIKECURRENCY_INT:		
            		hasDerivativeStrikeCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESTRIKEMULTIPLIER_INT:		
            		hasDerivativeStrikeMultiplier = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESTRIKEVALUE_INT:		
            		hasDerivativeStrikeValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEOPTATTRIBUTE_INT:		
            		hasDerivativeOptAttribute = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVECONTRACTMULTIPLIER_INT:		
            		hasDerivativeContractMultiplier = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEMINPRICEINCREMENT_INT:		
            		hasDerivativeMinPriceIncrement = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEMINPRICEINCREMENTAMOUNT_INT:		
            		hasDerivativeMinPriceIncrementAmount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVECONTRACTMULTIPLIERUNIT_INT:		
            		hasDerivativeContractMultiplierUnit = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEFLOWSCHEDULETYPE_INT:		
            		hasDerivativeFlowScheduleType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEUNITOFMEASURE_INT:		
            		hasDerivativeUnitOfMeasure = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEUNITOFMEASUREQTY_INT:		
            		hasDerivativeUnitOfMeasureQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEPRICEUNITOFMEASURE_INT:		
            		hasDerivativePriceUnitOfMeasure = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEPRICEUNITOFMEASUREQTY_INT:		
            		hasDerivativePriceUnitOfMeasureQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEEXERCISESTYLE_INT:		
            		hasDerivativeExerciseStyle = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEOPTPAYAMOUNT_INT:		
            		hasDerivativeOptPayAmount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVETIMEUNIT_INT:		
            		hasDerivativeTimeUnit = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESECURITYEXCHANGE_INT:		
            		hasDerivativeSecurityExchange = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEPOSITIONLIMIT_INT:		
            		hasDerivativePositionLimit = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVENTPOSITIONLIMIT_INT:		
            		hasDerivativeNTPositionLimit = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESETTLMETHOD_INT:		
            		hasDerivativeSettlMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEPRICEQUOTEMETHOD_INT:		
            		hasDerivativePriceQuoteMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEVALUATIONMETHOD_INT:		
            		hasDerivativeValuationMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVELISTMETHOD_INT:		
            		hasDerivativeListMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVECAPPRICE_INT:		
            		hasDerivativeCapPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEFLOORPRICE_INT:		
            		hasDerivativeFloorPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEPUTORCALL_INT:		
            		hasDerivativePutOrCall = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEISSUER_INT:		
            		hasDerivativeIssuer = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEENCODEDISSUERLEN_INT:		
            		hasDerivativeEncodedIssuerLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEENCODEDISSUER_INT:		
            		hasDerivativeEncodedIssuer = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESECURITYDESC_INT:		
            		hasDerivativeSecurityDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEENCODEDSECURITYDESCLEN_INT:		
            		hasDerivativeEncodedSecurityDescLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEENCODEDSECURITYDESC_INT:		
            		hasDerivativeEncodedSecurityDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVECONTRACTSETTLMONTH_INT:		
            		hasDerivativeContractSettlMonth = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NODERIVATIVESECURITYALTID_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !derivativeSecurityAltIDGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = derivativeSecurityAltIDGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( derivativeSecurityXML.isKeyTag(tag)) {
        				tag = derivativeSecurityXML.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NODERIVATIVEEVENTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !derivativeEventsGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = derivativeEventsGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NODERIVATIVEINSTRUMENTPARTIES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !derivativeInstrumentParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = derivativeInstrumentParties[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasDerivativeSymbol = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSecurityID = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeProduct = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeProductComplex = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivFlexProductEligibilityIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSecurityGroup = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeCFICode = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSecurityType = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeMaturityDate = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeMaturityTime = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSettleOnOpenFlag = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeInstrmtAssignmentMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSecurityStatus = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeIssueDate = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeInstrRegistry = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeCountryOfIssue = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeStateOrProvinceOfIssue = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeStrikePrice = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeLocaleOfIssue = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeStrikeCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeStrikeMultiplier = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeStrikeValue = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeOptAttribute = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeMinPriceIncrement = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeMinPriceIncrementAmount = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativePriceUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativePriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeOptPayAmount = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeTimeUnit = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativePositionLimit = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeNTPositionLimit = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSettlMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativePriceQuoteMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeValuationMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeListMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeCapPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeFloorPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativePutOrCall = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeIssuer = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeEncodedIssuerLen = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeEncodedIssuer = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeEncodedSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeContractSettlMonth = FixUtils.TAG_HAS_NO_VALUE;
		for (FixDerivativeSecurityAltIDGrp fixDerivativeSecurityAltIDGrp : derivativeSecurityAltIDGrp) fixDerivativeSecurityAltIDGrp.clear();
		derivativeSecurityXML.clear();
		for (FixDerivativeEventsGrp fixDerivativeEventsGrp : derivativeEventsGrp) fixDerivativeEventsGrp.clear();
		for (FixDerivativeInstrumentParties fixDerivativeInstrumentParties : derivativeInstrumentParties) fixDerivativeInstrumentParties.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasDerivativeSymbol()) {		
			out.put(FixTags.DERIVATIVESYMBOL);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSymbol); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSymbolSfx()) {		
			out.put(FixTags.DERIVATIVESYMBOLSFX);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSymbolSfx); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSecurityID()) {		
			out.put(FixTags.DERIVATIVESECURITYID);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSecurityID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSecurityIDSource()) {		
			out.put(FixTags.DERIVATIVESECURITYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSecurityIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeProduct()) {		
			out.put(FixTags.DERIVATIVEPRODUCT);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeProduct);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeProductComplex()) {		
			out.put(FixTags.DERIVATIVEPRODUCTCOMPLEX);

			out.put((byte) '=');

			FixUtils.put(out,derivativeProductComplex); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivFlexProductEligibilityIndicator()) {		
			out.put(FixTags.DERIVFLEXPRODUCTELIGIBILITYINDICATOR);

			out.put((byte) '=');

			out.put(derivFlexProductEligibilityIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSecurityGroup()) {		
			out.put(FixTags.DERIVATIVESECURITYGROUP);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSecurityGroup); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeCFICode()) {		
			out.put(FixTags.DERIVATIVECFICODE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeCFICode); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSecurityType()) {		
			out.put(FixTags.DERIVATIVESECURITYTYPE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSecurityType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSecuritySubType()) {		
			out.put(FixTags.DERIVATIVESECURITYSUBTYPE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSecuritySubType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeMaturityMonthYear()) {		
			out.put(FixTags.DERIVATIVEMATURITYMONTHYEAR);

			out.put((byte) '=');

			FixUtils.put(out,derivativeMaturityMonthYear); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeMaturityDate()) {		
			out.put(FixTags.DERIVATIVEMATURITYDATE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeMaturityDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeMaturityTime()) {		
			out.put(FixTags.DERIVATIVEMATURITYTIME);

			out.put((byte) '=');

			FixUtils.put(out,derivativeMaturityTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSettleOnOpenFlag()) {		
			out.put(FixTags.DERIVATIVESETTLEONOPENFLAG);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSettleOnOpenFlag); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeInstrmtAssignmentMethod()) {		
			out.put(FixTags.DERIVATIVEINSTRMTASSIGNMENTMETHOD);

			out.put((byte) '=');

			FixUtils.put(out,derivativeInstrmtAssignmentMethod); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSecurityStatus()) {		
			out.put(FixTags.DERIVATIVESECURITYSTATUS);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSecurityStatus); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeIssueDate()) {		
			out.put(FixTags.DERIVATIVEISSUEDATE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeIssueDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeInstrRegistry()) {		
			out.put(FixTags.DERIVATIVEINSTRREGISTRY);

			out.put((byte) '=');

			FixUtils.put(out,derivativeInstrRegistry); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeCountryOfIssue()) {		
			out.put(FixTags.DERIVATIVECOUNTRYOFISSUE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeCountryOfIssue); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeStateOrProvinceOfIssue()) {		
			out.put(FixTags.DERIVATIVESTATEORPROVINCEOFISSUE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeStateOrProvinceOfIssue); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeStrikePrice()) {		
			out.put(FixTags.DERIVATIVESTRIKEPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeStrikePrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeLocaleOfIssue()) {		
			out.put(FixTags.DERIVATIVELOCALEOFISSUE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeLocaleOfIssue); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeStrikeCurrency()) {		
			out.put(FixTags.DERIVATIVESTRIKECURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,derivativeStrikeCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeStrikeMultiplier()) {		
			out.put(FixTags.DERIVATIVESTRIKEMULTIPLIER);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeStrikeMultiplier);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeStrikeValue()) {		
			out.put(FixTags.DERIVATIVESTRIKEVALUE);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeStrikeValue);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeOptAttribute()) {		
			out.put(FixTags.DERIVATIVEOPTATTRIBUTE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeOptAttribute); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeContractMultiplier()) {		
			out.put(FixTags.DERIVATIVECONTRACTMULTIPLIER);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeContractMultiplier);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeMinPriceIncrement()) {		
			out.put(FixTags.DERIVATIVEMINPRICEINCREMENT);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeMinPriceIncrement);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeMinPriceIncrementAmount()) {		
			out.put(FixTags.DERIVATIVEMINPRICEINCREMENTAMOUNT);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeMinPriceIncrementAmount);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeContractMultiplierUnit()) {		
			out.put(FixTags.DERIVATIVECONTRACTMULTIPLIERUNIT);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeContractMultiplierUnit);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeFlowScheduleType()) {		
			out.put(FixTags.DERIVATIVEFLOWSCHEDULETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeFlowScheduleType);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeUnitOfMeasure()) {		
			out.put(FixTags.DERIVATIVEUNITOFMEASURE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeUnitOfMeasure); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeUnitOfMeasureQty()) {		
			out.put(FixTags.DERIVATIVEUNITOFMEASUREQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeUnitOfMeasureQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativePriceUnitOfMeasure()) {		
			out.put(FixTags.DERIVATIVEPRICEUNITOFMEASURE);

			out.put((byte) '=');

			FixUtils.put(out,derivativePriceUnitOfMeasure); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativePriceUnitOfMeasureQty()) {		
			out.put(FixTags.DERIVATIVEPRICEUNITOFMEASUREQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativePriceUnitOfMeasureQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeExerciseStyle()) {		
			out.put(FixTags.DERIVATIVEEXERCISESTYLE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeExerciseStyle); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeOptPayAmount()) {		
			out.put(FixTags.DERIVATIVEOPTPAYAMOUNT);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeOptPayAmount);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeTimeUnit()) {		
			out.put(FixTags.DERIVATIVETIMEUNIT);

			out.put((byte) '=');

			FixUtils.put(out,derivativeTimeUnit); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSecurityExchange()) {		
			out.put(FixTags.DERIVATIVESECURITYEXCHANGE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSecurityExchange); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativePositionLimit()) {		
			out.put(FixTags.DERIVATIVEPOSITIONLIMIT);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativePositionLimit);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeNTPositionLimit()) {		
			out.put(FixTags.DERIVATIVENTPOSITIONLIMIT);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeNTPositionLimit);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSettlMethod()) {		
			out.put(FixTags.DERIVATIVESETTLMETHOD);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSettlMethod); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativePriceQuoteMethod()) {		
			out.put(FixTags.DERIVATIVEPRICEQUOTEMETHOD);

			out.put((byte) '=');

			FixUtils.put(out,derivativePriceQuoteMethod); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeValuationMethod()) {		
			out.put(FixTags.DERIVATIVEVALUATIONMETHOD);

			out.put((byte) '=');

			FixUtils.put(out,derivativeValuationMethod); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeListMethod()) {		
			out.put(FixTags.DERIVATIVELISTMETHOD);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeListMethod);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeCapPrice()) {		
			out.put(FixTags.DERIVATIVECAPPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeCapPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeFloorPrice()) {		
			out.put(FixTags.DERIVATIVEFLOORPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeFloorPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativePutOrCall()) {		
			out.put(FixTags.DERIVATIVEPUTORCALL);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativePutOrCall);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeIssuer()) {		
			out.put(FixTags.DERIVATIVEISSUER);

			out.put((byte) '=');

			FixUtils.put(out,derivativeIssuer); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeEncodedIssuerLen()) {		
			out.put(FixTags.DERIVATIVEENCODEDISSUERLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeEncodedIssuerLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeEncodedIssuer()) {		
			out.put(FixTags.DERIVATIVEENCODEDISSUER);

			out.put((byte) '=');

			FixUtils.put(out,derivativeEncodedIssuer); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSecurityDesc()) {		
			out.put(FixTags.DERIVATIVESECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeEncodedSecurityDescLen()) {		
			out.put(FixTags.DERIVATIVEENCODEDSECURITYDESCLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeEncodedSecurityDescLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeEncodedSecurityDesc()) {		
			out.put(FixTags.DERIVATIVEENCODEDSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,derivativeEncodedSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeContractSettlMonth()) {		
			out.put(FixTags.DERIVATIVECONTRACTSETTLMONTH);

			out.put((byte) '=');

			FixUtils.put(out,derivativeContractSettlMonth); 		
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(derivativeSecurityAltIDGrp)>0) {
			out.put(FixTags.NODERIVATIVESECURITYALTID);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(derivativeSecurityAltIDGrp));

			out.put(FixUtils.SOH);

		}
		for (FixDerivativeSecurityAltIDGrp fixDerivativeSecurityAltIDGrp : derivativeSecurityAltIDGrp) if (fixDerivativeSecurityAltIDGrp.hasGroup()) fixDerivativeSecurityAltIDGrp.encode(out);
		derivativeSecurityXML.encode(out);
		if (FixUtils.getNoInGroup(derivativeEventsGrp)>0) {
			out.put(FixTags.NODERIVATIVEEVENTS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(derivativeEventsGrp));

			out.put(FixUtils.SOH);

		}
		for (FixDerivativeEventsGrp fixDerivativeEventsGrp : derivativeEventsGrp) if (fixDerivativeEventsGrp.hasGroup()) fixDerivativeEventsGrp.encode(out);
		if (FixUtils.getNoInGroup(derivativeInstrumentParties)>0) {
			out.put(FixTags.NODERIVATIVEINSTRUMENTPARTIES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(derivativeInstrumentParties));

			out.put(FixUtils.SOH);

		}
		for (FixDerivativeInstrumentParties fixDerivativeInstrumentParties : derivativeInstrumentParties) if (fixDerivativeInstrumentParties.hasGroup()) fixDerivativeInstrumentParties.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasDerivativeSymbol()) {		
			FixUtils.put(out,derivativeSymbol); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSymbolSfx()) {		
			FixUtils.put(out,derivativeSymbolSfx); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSecurityID()) {		
			FixUtils.put(out,derivativeSecurityID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSecurityIDSource()) {		
			FixUtils.put(out,derivativeSecurityIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeProduct()) {		
			FixUtils.put(out, (long)derivativeProduct);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeProductComplex()) {		
			FixUtils.put(out,derivativeProductComplex); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivFlexProductEligibilityIndicator()) {		
			out.put(derivFlexProductEligibilityIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSecurityGroup()) {		
			FixUtils.put(out,derivativeSecurityGroup); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeCFICode()) {		
			FixUtils.put(out,derivativeCFICode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSecurityType()) {		
			FixUtils.put(out,derivativeSecurityType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSecuritySubType()) {		
			FixUtils.put(out,derivativeSecuritySubType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeMaturityMonthYear()) {		
			FixUtils.put(out,derivativeMaturityMonthYear); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeMaturityDate()) {		
			FixUtils.put(out,derivativeMaturityDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeMaturityTime()) {		
			FixUtils.put(out,derivativeMaturityTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSettleOnOpenFlag()) {		
			FixUtils.put(out,derivativeSettleOnOpenFlag); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeInstrmtAssignmentMethod()) {		
			FixUtils.put(out,derivativeInstrmtAssignmentMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSecurityStatus()) {		
			FixUtils.put(out,derivativeSecurityStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeIssueDate()) {		
			FixUtils.put(out,derivativeIssueDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeInstrRegistry()) {		
			FixUtils.put(out,derivativeInstrRegistry); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeCountryOfIssue()) {		
			FixUtils.put(out,derivativeCountryOfIssue); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeStateOrProvinceOfIssue()) {		
			FixUtils.put(out,derivativeStateOrProvinceOfIssue); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeStrikePrice()) {		
			FixUtils.put(out, (long)derivativeStrikePrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeLocaleOfIssue()) {		
			FixUtils.put(out,derivativeLocaleOfIssue); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeStrikeCurrency()) {		
			FixUtils.put(out,derivativeStrikeCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeStrikeMultiplier()) {		
			FixUtils.put(out, (long)derivativeStrikeMultiplier);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeStrikeValue()) {		
			FixUtils.put(out, (long)derivativeStrikeValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeOptAttribute()) {		
			FixUtils.put(out,derivativeOptAttribute); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeContractMultiplier()) {		
			FixUtils.put(out, (long)derivativeContractMultiplier);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeMinPriceIncrement()) {		
			FixUtils.put(out, (long)derivativeMinPriceIncrement);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeMinPriceIncrementAmount()) {		
			FixUtils.put(out, (long)derivativeMinPriceIncrementAmount);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeContractMultiplierUnit()) {		
			FixUtils.put(out, (long)derivativeContractMultiplierUnit);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeFlowScheduleType()) {		
			FixUtils.put(out, (long)derivativeFlowScheduleType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeUnitOfMeasure()) {		
			FixUtils.put(out,derivativeUnitOfMeasure); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeUnitOfMeasureQty()) {		
			FixUtils.put(out, (long)derivativeUnitOfMeasureQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativePriceUnitOfMeasure()) {		
			FixUtils.put(out,derivativePriceUnitOfMeasure); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativePriceUnitOfMeasureQty()) {		
			FixUtils.put(out, (long)derivativePriceUnitOfMeasureQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeExerciseStyle()) {		
			FixUtils.put(out,derivativeExerciseStyle); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeOptPayAmount()) {		
			FixUtils.put(out, (long)derivativeOptPayAmount);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeTimeUnit()) {		
			FixUtils.put(out,derivativeTimeUnit); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSecurityExchange()) {		
			FixUtils.put(out,derivativeSecurityExchange); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativePositionLimit()) {		
			FixUtils.put(out, (long)derivativePositionLimit);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeNTPositionLimit()) {		
			FixUtils.put(out, (long)derivativeNTPositionLimit);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSettlMethod()) {		
			FixUtils.put(out,derivativeSettlMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativePriceQuoteMethod()) {		
			FixUtils.put(out,derivativePriceQuoteMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeValuationMethod()) {		
			FixUtils.put(out,derivativeValuationMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeListMethod()) {		
			FixUtils.put(out, (long)derivativeListMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeCapPrice()) {		
			FixUtils.put(out, (long)derivativeCapPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeFloorPrice()) {		
			FixUtils.put(out, (long)derivativeFloorPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativePutOrCall()) {		
			FixUtils.put(out, (long)derivativePutOrCall);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeIssuer()) {		
			FixUtils.put(out,derivativeIssuer); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeEncodedIssuerLen()) {		
			FixUtils.put(out, (long)derivativeEncodedIssuerLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeEncodedIssuer()) {		
			FixUtils.put(out,derivativeEncodedIssuer); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSecurityDesc()) {		
			FixUtils.put(out,derivativeSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeEncodedSecurityDescLen()) {		
			FixUtils.put(out, (long)derivativeEncodedSecurityDescLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeEncodedSecurityDesc()) {		
			FixUtils.put(out,derivativeEncodedSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeContractSettlMonth()) {		
			FixUtils.put(out,derivativeContractSettlMonth); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixDerivativeSecurityAltIDGrp fixDerivativeSecurityAltIDGrp : derivativeSecurityAltIDGrp) fixDerivativeSecurityAltIDGrp.printBuffer(out);
		derivativeSecurityXML.printBuffer(out);
		for (FixDerivativeEventsGrp fixDerivativeEventsGrp : derivativeEventsGrp) fixDerivativeEventsGrp.printBuffer(out);
		for (FixDerivativeInstrumentParties fixDerivativeInstrumentParties : derivativeInstrumentParties) fixDerivativeInstrumentParties.printBuffer(out);
	}

	public byte[] getDerivativeSymbol() { 		
		if ( hasDerivativeSymbol()) {		
			if (hasDerivativeSymbol == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSymbol; 		
			} else {		
		
				buf.position(hasDerivativeSymbol);		
		
			FixMessage.getTagStringValue(buf, derivativeSymbol, 0, derivativeSymbol.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSymbol);		
					return null;		
				}		
			}		
			hasDerivativeSymbol = FixUtils.TAG_HAS_VALUE;		
			return derivativeSymbol;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSymbol() { return hasDerivativeSymbol != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSymbol(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSymbol()) FixUtils.fillSpace(derivativeSymbol);		
		FixUtils.copy(derivativeSymbol, src); 		
		hasDerivativeSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSymbol(String str) {		
		if (str == null ) return;
		if (hasDerivativeSymbol()) FixUtils.fillSpace(derivativeSymbol);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSymbol, src); 		
		hasDerivativeSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSymbolSfx() { 		
		if ( hasDerivativeSymbolSfx()) {		
			if (hasDerivativeSymbolSfx == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSymbolSfx; 		
			} else {		
		
				buf.position(hasDerivativeSymbolSfx);		
		
			FixMessage.getTagStringValue(buf, derivativeSymbolSfx, 0, derivativeSymbolSfx.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSymbolSfx);		
					return null;		
				}		
			}		
			hasDerivativeSymbolSfx = FixUtils.TAG_HAS_VALUE;		
			return derivativeSymbolSfx;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSymbolSfx() { return hasDerivativeSymbolSfx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSymbolSfx(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSymbolSfx()) FixUtils.fillSpace(derivativeSymbolSfx);		
		FixUtils.copy(derivativeSymbolSfx, src); 		
		hasDerivativeSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSymbolSfx(String str) {		
		if (str == null ) return;
		if (hasDerivativeSymbolSfx()) FixUtils.fillSpace(derivativeSymbolSfx);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSymbolSfx, src); 		
		hasDerivativeSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSecurityID() { 		
		if ( hasDerivativeSecurityID()) {		
			if (hasDerivativeSecurityID == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecurityID; 		
			} else {		
		
				buf.position(hasDerivativeSecurityID);		
		
			FixMessage.getTagStringValue(buf, derivativeSecurityID, 0, derivativeSecurityID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecurityID);		
					return null;		
				}		
			}		
			hasDerivativeSecurityID = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecurityID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSecurityID() { return hasDerivativeSecurityID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecurityID(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecurityID()) FixUtils.fillSpace(derivativeSecurityID);		
		FixUtils.copy(derivativeSecurityID, src); 		
		hasDerivativeSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecurityID(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecurityID()) FixUtils.fillSpace(derivativeSecurityID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSecurityID, src); 		
		hasDerivativeSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSecurityIDSource() { 		
		if ( hasDerivativeSecurityIDSource()) {		
			if (hasDerivativeSecurityIDSource == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecurityIDSource; 		
			} else {		
		
				buf.position(hasDerivativeSecurityIDSource);		
		
			FixMessage.getTagStringValue(buf, derivativeSecurityIDSource, 0, derivativeSecurityIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecurityIDSource);		
					return null;		
				}		
			}		
			hasDerivativeSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecurityIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSecurityIDSource() { return hasDerivativeSecurityIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecurityIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecurityIDSource()) FixUtils.fillSpace(derivativeSecurityIDSource);		
		FixUtils.copy(derivativeSecurityIDSource, src); 		
		hasDerivativeSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecurityIDSource(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecurityIDSource()) FixUtils.fillSpace(derivativeSecurityIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSecurityIDSource, src); 		
		hasDerivativeSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeProduct() { 		
		if ( hasDerivativeProduct()) {		
			if (hasDerivativeProduct == FixUtils.TAG_HAS_VALUE) {		
				return derivativeProduct; 		
			} else {		
		
				buf.position(hasDerivativeProduct);		
		
			derivativeProduct = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeProduct);		
					return 0;		
				}		
			}		
			hasDerivativeProduct = FixUtils.TAG_HAS_VALUE;		
			return derivativeProduct;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeProduct() { return hasDerivativeProduct != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeProduct(long src) {		
		derivativeProduct = src;
		hasDerivativeProduct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeProduct(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeProduct()) derivativeProduct = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeProduct = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeProduct(String str) {		
		if (str == null ) return;
		if (hasDerivativeProduct()) derivativeProduct = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeProduct = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeProductComplex() { 		
		if ( hasDerivativeProductComplex()) {		
			if (hasDerivativeProductComplex == FixUtils.TAG_HAS_VALUE) {		
				return derivativeProductComplex; 		
			} else {		
		
				buf.position(hasDerivativeProductComplex);		
		
			FixMessage.getTagStringValue(buf, derivativeProductComplex, 0, derivativeProductComplex.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeProductComplex);		
					return null;		
				}		
			}		
			hasDerivativeProductComplex = FixUtils.TAG_HAS_VALUE;		
			return derivativeProductComplex;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeProductComplex() { return hasDerivativeProductComplex != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeProductComplex(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeProductComplex()) FixUtils.fillSpace(derivativeProductComplex);		
		FixUtils.copy(derivativeProductComplex, src); 		
		hasDerivativeProductComplex = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeProductComplex(String str) {		
		if (str == null ) return;
		if (hasDerivativeProductComplex()) FixUtils.fillSpace(derivativeProductComplex);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeProductComplex, src); 		
		hasDerivativeProductComplex = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getDerivFlexProductEligibilityIndicator() { 		
		if ( hasDerivFlexProductEligibilityIndicator()) {		
			if (hasDerivFlexProductEligibilityIndicator == FixUtils.TAG_HAS_VALUE) {		
				return derivFlexProductEligibilityIndicator; 		
			} else {		
		
				buf.position(hasDerivFlexProductEligibilityIndicator);		
		
			derivFlexProductEligibilityIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasDerivFlexProductEligibilityIndicator);		
					return false;		
				}		
			}		
			hasDerivFlexProductEligibilityIndicator = FixUtils.TAG_HAS_VALUE;		
			return derivFlexProductEligibilityIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasDerivFlexProductEligibilityIndicator() { return hasDerivFlexProductEligibilityIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivFlexProductEligibilityIndicator(boolean src) {		
		derivFlexProductEligibilityIndicator = src;
		hasDerivFlexProductEligibilityIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivFlexProductEligibilityIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasDerivFlexProductEligibilityIndicator()) derivFlexProductEligibilityIndicator = false;		
		derivFlexProductEligibilityIndicator = src[0]==(byte)'Y'?true:false;		
		hasDerivFlexProductEligibilityIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivFlexProductEligibilityIndicator(String str) {		
		if (str == null ) return;
		if (hasDerivFlexProductEligibilityIndicator()) derivFlexProductEligibilityIndicator = false;		
		byte[] src = str.getBytes(); 		
		derivFlexProductEligibilityIndicator = src[0]==(byte)'Y'?true:false;		
		hasDerivFlexProductEligibilityIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSecurityGroup() { 		
		if ( hasDerivativeSecurityGroup()) {		
			if (hasDerivativeSecurityGroup == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecurityGroup; 		
			} else {		
		
				buf.position(hasDerivativeSecurityGroup);		
		
			FixMessage.getTagStringValue(buf, derivativeSecurityGroup, 0, derivativeSecurityGroup.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecurityGroup);		
					return null;		
				}		
			}		
			hasDerivativeSecurityGroup = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecurityGroup;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSecurityGroup() { return hasDerivativeSecurityGroup != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecurityGroup(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecurityGroup()) FixUtils.fillSpace(derivativeSecurityGroup);		
		FixUtils.copy(derivativeSecurityGroup, src); 		
		hasDerivativeSecurityGroup = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecurityGroup(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecurityGroup()) FixUtils.fillSpace(derivativeSecurityGroup);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSecurityGroup, src); 		
		hasDerivativeSecurityGroup = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeCFICode() { 		
		if ( hasDerivativeCFICode()) {		
			if (hasDerivativeCFICode == FixUtils.TAG_HAS_VALUE) {		
				return derivativeCFICode; 		
			} else {		
		
				buf.position(hasDerivativeCFICode);		
		
			FixMessage.getTagStringValue(buf, derivativeCFICode, 0, derivativeCFICode.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeCFICode);		
					return null;		
				}		
			}		
			hasDerivativeCFICode = FixUtils.TAG_HAS_VALUE;		
			return derivativeCFICode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeCFICode() { return hasDerivativeCFICode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeCFICode(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeCFICode()) FixUtils.fillSpace(derivativeCFICode);		
		FixUtils.copy(derivativeCFICode, src); 		
		hasDerivativeCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeCFICode(String str) {		
		if (str == null ) return;
		if (hasDerivativeCFICode()) FixUtils.fillSpace(derivativeCFICode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeCFICode, src); 		
		hasDerivativeCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSecurityType() { 		
		if ( hasDerivativeSecurityType()) {		
			if (hasDerivativeSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecurityType; 		
			} else {		
		
				buf.position(hasDerivativeSecurityType);		
		
			FixMessage.getTagStringValue(buf, derivativeSecurityType, 0, derivativeSecurityType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecurityType);		
					return null;		
				}		
			}		
			hasDerivativeSecurityType = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecurityType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSecurityType() { return hasDerivativeSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecurityType()) FixUtils.fillSpace(derivativeSecurityType);		
		FixUtils.copy(derivativeSecurityType, src); 		
		hasDerivativeSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecurityType(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecurityType()) FixUtils.fillSpace(derivativeSecurityType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSecurityType, src); 		
		hasDerivativeSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSecuritySubType() { 		
		if ( hasDerivativeSecuritySubType()) {		
			if (hasDerivativeSecuritySubType == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecuritySubType; 		
			} else {		
		
				buf.position(hasDerivativeSecuritySubType);		
		
			FixMessage.getTagStringValue(buf, derivativeSecuritySubType, 0, derivativeSecuritySubType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecuritySubType);		
					return null;		
				}		
			}		
			hasDerivativeSecuritySubType = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecuritySubType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSecuritySubType() { return hasDerivativeSecuritySubType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecuritySubType(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecuritySubType()) FixUtils.fillSpace(derivativeSecuritySubType);		
		FixUtils.copy(derivativeSecuritySubType, src); 		
		hasDerivativeSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecuritySubType(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecuritySubType()) FixUtils.fillSpace(derivativeSecuritySubType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSecuritySubType, src); 		
		hasDerivativeSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeMaturityMonthYear() { 		
		if ( hasDerivativeMaturityMonthYear()) {		
			if (hasDerivativeMaturityMonthYear == FixUtils.TAG_HAS_VALUE) {		
				return derivativeMaturityMonthYear; 		
			} else {		
		
				buf.position(hasDerivativeMaturityMonthYear);		
		
			FixMessage.getTagStringValue(buf, derivativeMaturityMonthYear, 0, derivativeMaturityMonthYear.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeMaturityMonthYear);		
					return null;		
				}		
			}		
			hasDerivativeMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
			return derivativeMaturityMonthYear;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeMaturityMonthYear() { return hasDerivativeMaturityMonthYear != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeMaturityMonthYear(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeMaturityMonthYear()) FixUtils.fillSpace(derivativeMaturityMonthYear);		
		FixUtils.copy(derivativeMaturityMonthYear, src); 		
		hasDerivativeMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeMaturityMonthYear(String str) {		
		if (str == null ) return;
		if (hasDerivativeMaturityMonthYear()) FixUtils.fillSpace(derivativeMaturityMonthYear);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeMaturityMonthYear, src); 		
		hasDerivativeMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeMaturityDate() { 		
		if ( hasDerivativeMaturityDate()) {		
			if (hasDerivativeMaturityDate == FixUtils.TAG_HAS_VALUE) {		
				return derivativeMaturityDate; 		
			} else {		
		
				buf.position(hasDerivativeMaturityDate);		
		
			FixMessage.getTagStringValue(buf, derivativeMaturityDate, 0, derivativeMaturityDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeMaturityDate);		
					return null;		
				}		
			}		
			hasDerivativeMaturityDate = FixUtils.TAG_HAS_VALUE;		
			return derivativeMaturityDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeMaturityDate() { return hasDerivativeMaturityDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeMaturityDate(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeMaturityDate()) FixUtils.fillSpace(derivativeMaturityDate);		
		FixUtils.copy(derivativeMaturityDate, src); 		
		hasDerivativeMaturityDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeMaturityDate(String str) {		
		if (str == null ) return;
		if (hasDerivativeMaturityDate()) FixUtils.fillSpace(derivativeMaturityDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeMaturityDate, src); 		
		hasDerivativeMaturityDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeMaturityTime() { 		
		if ( hasDerivativeMaturityTime()) {		
			if (hasDerivativeMaturityTime == FixUtils.TAG_HAS_VALUE) {		
				return derivativeMaturityTime; 		
			} else {		
		
				buf.position(hasDerivativeMaturityTime);		
		
			FixMessage.getTagStringValue(buf, derivativeMaturityTime, 0, derivativeMaturityTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeMaturityTime);		
					return null;		
				}		
			}		
			hasDerivativeMaturityTime = FixUtils.TAG_HAS_VALUE;		
			return derivativeMaturityTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeMaturityTime() { return hasDerivativeMaturityTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeMaturityTime(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeMaturityTime()) FixUtils.fillSpace(derivativeMaturityTime);		
		FixUtils.copy(derivativeMaturityTime, src); 		
		hasDerivativeMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeMaturityTime(String str) {		
		if (str == null ) return;
		if (hasDerivativeMaturityTime()) FixUtils.fillSpace(derivativeMaturityTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeMaturityTime, src); 		
		hasDerivativeMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSettleOnOpenFlag() { 		
		if ( hasDerivativeSettleOnOpenFlag()) {		
			if (hasDerivativeSettleOnOpenFlag == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSettleOnOpenFlag; 		
			} else {		
		
				buf.position(hasDerivativeSettleOnOpenFlag);		
		
			FixMessage.getTagStringValue(buf, derivativeSettleOnOpenFlag, 0, derivativeSettleOnOpenFlag.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSettleOnOpenFlag);		
					return null;		
				}		
			}		
			hasDerivativeSettleOnOpenFlag = FixUtils.TAG_HAS_VALUE;		
			return derivativeSettleOnOpenFlag;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSettleOnOpenFlag() { return hasDerivativeSettleOnOpenFlag != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSettleOnOpenFlag(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSettleOnOpenFlag()) FixUtils.fillSpace(derivativeSettleOnOpenFlag);		
		FixUtils.copy(derivativeSettleOnOpenFlag, src); 		
		hasDerivativeSettleOnOpenFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSettleOnOpenFlag(String str) {		
		if (str == null ) return;
		if (hasDerivativeSettleOnOpenFlag()) FixUtils.fillSpace(derivativeSettleOnOpenFlag);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSettleOnOpenFlag, src); 		
		hasDerivativeSettleOnOpenFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getDerivativeInstrmtAssignmentMethod() { 		
		if ( hasDerivativeInstrmtAssignmentMethod()) {		
			if (hasDerivativeInstrmtAssignmentMethod == FixUtils.TAG_HAS_VALUE) {		
				return derivativeInstrmtAssignmentMethod; 		
			} else {		
		
				buf.position(hasDerivativeInstrmtAssignmentMethod);		
		
			derivativeInstrmtAssignmentMethod = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeInstrmtAssignmentMethod);		
					return (byte)'0';		
				}		
			}		
			hasDerivativeInstrmtAssignmentMethod = FixUtils.TAG_HAS_VALUE;		
			return derivativeInstrmtAssignmentMethod;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDerivativeInstrmtAssignmentMethod() { return hasDerivativeInstrmtAssignmentMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeInstrmtAssignmentMethod(byte src) {		
		derivativeInstrmtAssignmentMethod = src;
		hasDerivativeInstrmtAssignmentMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeInstrmtAssignmentMethod(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeInstrmtAssignmentMethod()) derivativeInstrmtAssignmentMethod = (byte)' ';		
		derivativeInstrmtAssignmentMethod = src[0];		
		hasDerivativeInstrmtAssignmentMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeInstrmtAssignmentMethod(String str) {		
		if (str == null ) return;
		if (hasDerivativeInstrmtAssignmentMethod()) derivativeInstrmtAssignmentMethod = (byte)' ';		
		byte[] src = str.getBytes(); 		
		derivativeInstrmtAssignmentMethod = src[0];		
		hasDerivativeInstrmtAssignmentMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSecurityStatus() { 		
		if ( hasDerivativeSecurityStatus()) {		
			if (hasDerivativeSecurityStatus == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecurityStatus; 		
			} else {		
		
				buf.position(hasDerivativeSecurityStatus);		
		
			FixMessage.getTagStringValue(buf, derivativeSecurityStatus, 0, derivativeSecurityStatus.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecurityStatus);		
					return null;		
				}		
			}		
			hasDerivativeSecurityStatus = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecurityStatus;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSecurityStatus() { return hasDerivativeSecurityStatus != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecurityStatus(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecurityStatus()) FixUtils.fillSpace(derivativeSecurityStatus);		
		FixUtils.copy(derivativeSecurityStatus, src); 		
		hasDerivativeSecurityStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecurityStatus(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecurityStatus()) FixUtils.fillSpace(derivativeSecurityStatus);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSecurityStatus, src); 		
		hasDerivativeSecurityStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeIssueDate() { 		
		if ( hasDerivativeIssueDate()) {		
			if (hasDerivativeIssueDate == FixUtils.TAG_HAS_VALUE) {		
				return derivativeIssueDate; 		
			} else {		
		
				buf.position(hasDerivativeIssueDate);		
		
			FixMessage.getTagStringValue(buf, derivativeIssueDate, 0, derivativeIssueDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeIssueDate);		
					return null;		
				}		
			}		
			hasDerivativeIssueDate = FixUtils.TAG_HAS_VALUE;		
			return derivativeIssueDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeIssueDate() { return hasDerivativeIssueDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeIssueDate(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeIssueDate()) FixUtils.fillSpace(derivativeIssueDate);		
		FixUtils.copy(derivativeIssueDate, src); 		
		hasDerivativeIssueDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeIssueDate(String str) {		
		if (str == null ) return;
		if (hasDerivativeIssueDate()) FixUtils.fillSpace(derivativeIssueDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeIssueDate, src); 		
		hasDerivativeIssueDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeInstrRegistry() { 		
		if ( hasDerivativeInstrRegistry()) {		
			if (hasDerivativeInstrRegistry == FixUtils.TAG_HAS_VALUE) {		
				return derivativeInstrRegistry; 		
			} else {		
		
				buf.position(hasDerivativeInstrRegistry);		
		
			FixMessage.getTagStringValue(buf, derivativeInstrRegistry, 0, derivativeInstrRegistry.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeInstrRegistry);		
					return null;		
				}		
			}		
			hasDerivativeInstrRegistry = FixUtils.TAG_HAS_VALUE;		
			return derivativeInstrRegistry;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeInstrRegistry() { return hasDerivativeInstrRegistry != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeInstrRegistry(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeInstrRegistry()) FixUtils.fillSpace(derivativeInstrRegistry);		
		FixUtils.copy(derivativeInstrRegistry, src); 		
		hasDerivativeInstrRegistry = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeInstrRegistry(String str) {		
		if (str == null ) return;
		if (hasDerivativeInstrRegistry()) FixUtils.fillSpace(derivativeInstrRegistry);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeInstrRegistry, src); 		
		hasDerivativeInstrRegistry = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeCountryOfIssue() { 		
		if ( hasDerivativeCountryOfIssue()) {		
			if (hasDerivativeCountryOfIssue == FixUtils.TAG_HAS_VALUE) {		
				return derivativeCountryOfIssue; 		
			} else {		
		
				buf.position(hasDerivativeCountryOfIssue);		
		
			FixMessage.getTagStringValue(buf, derivativeCountryOfIssue, 0, derivativeCountryOfIssue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeCountryOfIssue);		
					return null;		
				}		
			}		
			hasDerivativeCountryOfIssue = FixUtils.TAG_HAS_VALUE;		
			return derivativeCountryOfIssue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeCountryOfIssue() { return hasDerivativeCountryOfIssue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeCountryOfIssue(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeCountryOfIssue()) FixUtils.fillSpace(derivativeCountryOfIssue);		
		FixUtils.copy(derivativeCountryOfIssue, src); 		
		hasDerivativeCountryOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeCountryOfIssue(String str) {		
		if (str == null ) return;
		if (hasDerivativeCountryOfIssue()) FixUtils.fillSpace(derivativeCountryOfIssue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeCountryOfIssue, src); 		
		hasDerivativeCountryOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeStateOrProvinceOfIssue() { 		
		if ( hasDerivativeStateOrProvinceOfIssue()) {		
			if (hasDerivativeStateOrProvinceOfIssue == FixUtils.TAG_HAS_VALUE) {		
				return derivativeStateOrProvinceOfIssue; 		
			} else {		
		
				buf.position(hasDerivativeStateOrProvinceOfIssue);		
		
			FixMessage.getTagStringValue(buf, derivativeStateOrProvinceOfIssue, 0, derivativeStateOrProvinceOfIssue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeStateOrProvinceOfIssue);		
					return null;		
				}		
			}		
			hasDerivativeStateOrProvinceOfIssue = FixUtils.TAG_HAS_VALUE;		
			return derivativeStateOrProvinceOfIssue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeStateOrProvinceOfIssue() { return hasDerivativeStateOrProvinceOfIssue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeStateOrProvinceOfIssue(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeStateOrProvinceOfIssue()) FixUtils.fillSpace(derivativeStateOrProvinceOfIssue);		
		FixUtils.copy(derivativeStateOrProvinceOfIssue, src); 		
		hasDerivativeStateOrProvinceOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeStateOrProvinceOfIssue(String str) {		
		if (str == null ) return;
		if (hasDerivativeStateOrProvinceOfIssue()) FixUtils.fillSpace(derivativeStateOrProvinceOfIssue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeStateOrProvinceOfIssue, src); 		
		hasDerivativeStateOrProvinceOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeStrikePrice() { 		
		if ( hasDerivativeStrikePrice()) {		
			if (hasDerivativeStrikePrice == FixUtils.TAG_HAS_VALUE) {		
				return derivativeStrikePrice; 		
			} else {		
		
				buf.position(hasDerivativeStrikePrice);		
		
			derivativeStrikePrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeStrikePrice);		
					return 0;		
				}		
			}		
			hasDerivativeStrikePrice = FixUtils.TAG_HAS_VALUE;		
			return derivativeStrikePrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeStrikePrice() { return hasDerivativeStrikePrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeStrikePrice(long src) {		
		derivativeStrikePrice = src;
		hasDerivativeStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeStrikePrice(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeStrikePrice()) derivativeStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeStrikePrice = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeStrikePrice(String str) {		
		if (str == null ) return;
		if (hasDerivativeStrikePrice()) derivativeStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeStrikePrice = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeLocaleOfIssue() { 		
		if ( hasDerivativeLocaleOfIssue()) {		
			if (hasDerivativeLocaleOfIssue == FixUtils.TAG_HAS_VALUE) {		
				return derivativeLocaleOfIssue; 		
			} else {		
		
				buf.position(hasDerivativeLocaleOfIssue);		
		
			FixMessage.getTagStringValue(buf, derivativeLocaleOfIssue, 0, derivativeLocaleOfIssue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeLocaleOfIssue);		
					return null;		
				}		
			}		
			hasDerivativeLocaleOfIssue = FixUtils.TAG_HAS_VALUE;		
			return derivativeLocaleOfIssue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeLocaleOfIssue() { return hasDerivativeLocaleOfIssue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeLocaleOfIssue(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeLocaleOfIssue()) FixUtils.fillSpace(derivativeLocaleOfIssue);		
		FixUtils.copy(derivativeLocaleOfIssue, src); 		
		hasDerivativeLocaleOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeLocaleOfIssue(String str) {		
		if (str == null ) return;
		if (hasDerivativeLocaleOfIssue()) FixUtils.fillSpace(derivativeLocaleOfIssue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeLocaleOfIssue, src); 		
		hasDerivativeLocaleOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeStrikeCurrency() { 		
		if ( hasDerivativeStrikeCurrency()) {		
			if (hasDerivativeStrikeCurrency == FixUtils.TAG_HAS_VALUE) {		
				return derivativeStrikeCurrency; 		
			} else {		
		
				buf.position(hasDerivativeStrikeCurrency);		
		
			FixMessage.getTagStringValue(buf, derivativeStrikeCurrency, 0, derivativeStrikeCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeStrikeCurrency);		
					return null;		
				}		
			}		
			hasDerivativeStrikeCurrency = FixUtils.TAG_HAS_VALUE;		
			return derivativeStrikeCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeStrikeCurrency() { return hasDerivativeStrikeCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeStrikeCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeStrikeCurrency()) FixUtils.fillSpace(derivativeStrikeCurrency);		
		FixUtils.copy(derivativeStrikeCurrency, src); 		
		hasDerivativeStrikeCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeStrikeCurrency(String str) {		
		if (str == null ) return;
		if (hasDerivativeStrikeCurrency()) FixUtils.fillSpace(derivativeStrikeCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeStrikeCurrency, src); 		
		hasDerivativeStrikeCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeStrikeMultiplier() { 		
		if ( hasDerivativeStrikeMultiplier()) {		
			if (hasDerivativeStrikeMultiplier == FixUtils.TAG_HAS_VALUE) {		
				return derivativeStrikeMultiplier; 		
			} else {		
		
				buf.position(hasDerivativeStrikeMultiplier);		
		
			derivativeStrikeMultiplier = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeStrikeMultiplier);		
					return 0;		
				}		
			}		
			hasDerivativeStrikeMultiplier = FixUtils.TAG_HAS_VALUE;		
			return derivativeStrikeMultiplier;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeStrikeMultiplier() { return hasDerivativeStrikeMultiplier != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeStrikeMultiplier(long src) {		
		derivativeStrikeMultiplier = src;
		hasDerivativeStrikeMultiplier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeStrikeMultiplier(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeStrikeMultiplier()) derivativeStrikeMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeStrikeMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeStrikeMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeStrikeMultiplier(String str) {		
		if (str == null ) return;
		if (hasDerivativeStrikeMultiplier()) derivativeStrikeMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeStrikeMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeStrikeMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeStrikeValue() { 		
		if ( hasDerivativeStrikeValue()) {		
			if (hasDerivativeStrikeValue == FixUtils.TAG_HAS_VALUE) {		
				return derivativeStrikeValue; 		
			} else {		
		
				buf.position(hasDerivativeStrikeValue);		
		
			derivativeStrikeValue = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeStrikeValue);		
					return 0;		
				}		
			}		
			hasDerivativeStrikeValue = FixUtils.TAG_HAS_VALUE;		
			return derivativeStrikeValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeStrikeValue() { return hasDerivativeStrikeValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeStrikeValue(long src) {		
		derivativeStrikeValue = src;
		hasDerivativeStrikeValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeStrikeValue(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeStrikeValue()) derivativeStrikeValue = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeStrikeValue = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeStrikeValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeStrikeValue(String str) {		
		if (str == null ) return;
		if (hasDerivativeStrikeValue()) derivativeStrikeValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeStrikeValue = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeStrikeValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getDerivativeOptAttribute() { 		
		if ( hasDerivativeOptAttribute()) {		
			if (hasDerivativeOptAttribute == FixUtils.TAG_HAS_VALUE) {		
				return derivativeOptAttribute; 		
			} else {		
		
				buf.position(hasDerivativeOptAttribute);		
		
			derivativeOptAttribute = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeOptAttribute);		
					return (byte)'0';		
				}		
			}		
			hasDerivativeOptAttribute = FixUtils.TAG_HAS_VALUE;		
			return derivativeOptAttribute;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDerivativeOptAttribute() { return hasDerivativeOptAttribute != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeOptAttribute(byte src) {		
		derivativeOptAttribute = src;
		hasDerivativeOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeOptAttribute(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeOptAttribute()) derivativeOptAttribute = (byte)' ';		
		derivativeOptAttribute = src[0];		
		hasDerivativeOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeOptAttribute(String str) {		
		if (str == null ) return;
		if (hasDerivativeOptAttribute()) derivativeOptAttribute = (byte)' ';		
		byte[] src = str.getBytes(); 		
		derivativeOptAttribute = src[0];		
		hasDerivativeOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeContractMultiplier() { 		
		if ( hasDerivativeContractMultiplier()) {		
			if (hasDerivativeContractMultiplier == FixUtils.TAG_HAS_VALUE) {		
				return derivativeContractMultiplier; 		
			} else {		
		
				buf.position(hasDerivativeContractMultiplier);		
		
			derivativeContractMultiplier = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeContractMultiplier);		
					return 0;		
				}		
			}		
			hasDerivativeContractMultiplier = FixUtils.TAG_HAS_VALUE;		
			return derivativeContractMultiplier;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeContractMultiplier() { return hasDerivativeContractMultiplier != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeContractMultiplier(long src) {		
		derivativeContractMultiplier = src;
		hasDerivativeContractMultiplier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeContractMultiplier(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeContractMultiplier()) derivativeContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeContractMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeContractMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeContractMultiplier(String str) {		
		if (str == null ) return;
		if (hasDerivativeContractMultiplier()) derivativeContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeContractMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeContractMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeMinPriceIncrement() { 		
		if ( hasDerivativeMinPriceIncrement()) {		
			if (hasDerivativeMinPriceIncrement == FixUtils.TAG_HAS_VALUE) {		
				return derivativeMinPriceIncrement; 		
			} else {		
		
				buf.position(hasDerivativeMinPriceIncrement);		
		
			derivativeMinPriceIncrement = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeMinPriceIncrement);		
					return 0;		
				}		
			}		
			hasDerivativeMinPriceIncrement = FixUtils.TAG_HAS_VALUE;		
			return derivativeMinPriceIncrement;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeMinPriceIncrement() { return hasDerivativeMinPriceIncrement != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeMinPriceIncrement(long src) {		
		derivativeMinPriceIncrement = src;
		hasDerivativeMinPriceIncrement = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeMinPriceIncrement(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeMinPriceIncrement()) derivativeMinPriceIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeMinPriceIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeMinPriceIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeMinPriceIncrement(String str) {		
		if (str == null ) return;
		if (hasDerivativeMinPriceIncrement()) derivativeMinPriceIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeMinPriceIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeMinPriceIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeMinPriceIncrementAmount() { 		
		if ( hasDerivativeMinPriceIncrementAmount()) {		
			if (hasDerivativeMinPriceIncrementAmount == FixUtils.TAG_HAS_VALUE) {		
				return derivativeMinPriceIncrementAmount; 		
			} else {		
		
				buf.position(hasDerivativeMinPriceIncrementAmount);		
		
			derivativeMinPriceIncrementAmount = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeMinPriceIncrementAmount);		
					return 0;		
				}		
			}		
			hasDerivativeMinPriceIncrementAmount = FixUtils.TAG_HAS_VALUE;		
			return derivativeMinPriceIncrementAmount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeMinPriceIncrementAmount() { return hasDerivativeMinPriceIncrementAmount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeMinPriceIncrementAmount(long src) {		
		derivativeMinPriceIncrementAmount = src;
		hasDerivativeMinPriceIncrementAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeMinPriceIncrementAmount(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeMinPriceIncrementAmount()) derivativeMinPriceIncrementAmount = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeMinPriceIncrementAmount = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeMinPriceIncrementAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeMinPriceIncrementAmount(String str) {		
		if (str == null ) return;
		if (hasDerivativeMinPriceIncrementAmount()) derivativeMinPriceIncrementAmount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeMinPriceIncrementAmount = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeMinPriceIncrementAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeContractMultiplierUnit() { 		
		if ( hasDerivativeContractMultiplierUnit()) {		
			if (hasDerivativeContractMultiplierUnit == FixUtils.TAG_HAS_VALUE) {		
				return derivativeContractMultiplierUnit; 		
			} else {		
		
				buf.position(hasDerivativeContractMultiplierUnit);		
		
			derivativeContractMultiplierUnit = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeContractMultiplierUnit);		
					return 0;		
				}		
			}		
			hasDerivativeContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
			return derivativeContractMultiplierUnit;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeContractMultiplierUnit() { return hasDerivativeContractMultiplierUnit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeContractMultiplierUnit(long src) {		
		derivativeContractMultiplierUnit = src;
		hasDerivativeContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeContractMultiplierUnit(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeContractMultiplierUnit()) derivativeContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeContractMultiplierUnit = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeContractMultiplierUnit(String str) {		
		if (str == null ) return;
		if (hasDerivativeContractMultiplierUnit()) derivativeContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeContractMultiplierUnit = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeFlowScheduleType() { 		
		if ( hasDerivativeFlowScheduleType()) {		
			if (hasDerivativeFlowScheduleType == FixUtils.TAG_HAS_VALUE) {		
				return derivativeFlowScheduleType; 		
			} else {		
		
				buf.position(hasDerivativeFlowScheduleType);		
		
			derivativeFlowScheduleType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeFlowScheduleType);		
					return 0;		
				}		
			}		
			hasDerivativeFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
			return derivativeFlowScheduleType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeFlowScheduleType() { return hasDerivativeFlowScheduleType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeFlowScheduleType(long src) {		
		derivativeFlowScheduleType = src;
		hasDerivativeFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeFlowScheduleType(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeFlowScheduleType()) derivativeFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeFlowScheduleType = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeFlowScheduleType(String str) {		
		if (str == null ) return;
		if (hasDerivativeFlowScheduleType()) derivativeFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeFlowScheduleType = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeUnitOfMeasure() { 		
		if ( hasDerivativeUnitOfMeasure()) {		
			if (hasDerivativeUnitOfMeasure == FixUtils.TAG_HAS_VALUE) {		
				return derivativeUnitOfMeasure; 		
			} else {		
		
				buf.position(hasDerivativeUnitOfMeasure);		
		
			FixMessage.getTagStringValue(buf, derivativeUnitOfMeasure, 0, derivativeUnitOfMeasure.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeUnitOfMeasure);		
					return null;		
				}		
			}		
			hasDerivativeUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
			return derivativeUnitOfMeasure;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeUnitOfMeasure() { return hasDerivativeUnitOfMeasure != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeUnitOfMeasure(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeUnitOfMeasure()) FixUtils.fillSpace(derivativeUnitOfMeasure);		
		FixUtils.copy(derivativeUnitOfMeasure, src); 		
		hasDerivativeUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeUnitOfMeasure(String str) {		
		if (str == null ) return;
		if (hasDerivativeUnitOfMeasure()) FixUtils.fillSpace(derivativeUnitOfMeasure);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeUnitOfMeasure, src); 		
		hasDerivativeUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeUnitOfMeasureQty() { 		
		if ( hasDerivativeUnitOfMeasureQty()) {		
			if (hasDerivativeUnitOfMeasureQty == FixUtils.TAG_HAS_VALUE) {		
				return derivativeUnitOfMeasureQty; 		
			} else {		
		
				buf.position(hasDerivativeUnitOfMeasureQty);		
		
			derivativeUnitOfMeasureQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeUnitOfMeasureQty);		
					return 0;		
				}		
			}		
			hasDerivativeUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
			return derivativeUnitOfMeasureQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeUnitOfMeasureQty() { return hasDerivativeUnitOfMeasureQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeUnitOfMeasureQty(long src) {		
		derivativeUnitOfMeasureQty = src;
		hasDerivativeUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeUnitOfMeasureQty(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeUnitOfMeasureQty()) derivativeUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeUnitOfMeasureQty(String str) {		
		if (str == null ) return;
		if (hasDerivativeUnitOfMeasureQty()) derivativeUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativePriceUnitOfMeasure() { 		
		if ( hasDerivativePriceUnitOfMeasure()) {		
			if (hasDerivativePriceUnitOfMeasure == FixUtils.TAG_HAS_VALUE) {		
				return derivativePriceUnitOfMeasure; 		
			} else {		
		
				buf.position(hasDerivativePriceUnitOfMeasure);		
		
			FixMessage.getTagStringValue(buf, derivativePriceUnitOfMeasure, 0, derivativePriceUnitOfMeasure.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativePriceUnitOfMeasure);		
					return null;		
				}		
			}		
			hasDerivativePriceUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
			return derivativePriceUnitOfMeasure;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativePriceUnitOfMeasure() { return hasDerivativePriceUnitOfMeasure != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativePriceUnitOfMeasure(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativePriceUnitOfMeasure()) FixUtils.fillSpace(derivativePriceUnitOfMeasure);		
		FixUtils.copy(derivativePriceUnitOfMeasure, src); 		
		hasDerivativePriceUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativePriceUnitOfMeasure(String str) {		
		if (str == null ) return;
		if (hasDerivativePriceUnitOfMeasure()) FixUtils.fillSpace(derivativePriceUnitOfMeasure);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativePriceUnitOfMeasure, src); 		
		hasDerivativePriceUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativePriceUnitOfMeasureQty() { 		
		if ( hasDerivativePriceUnitOfMeasureQty()) {		
			if (hasDerivativePriceUnitOfMeasureQty == FixUtils.TAG_HAS_VALUE) {		
				return derivativePriceUnitOfMeasureQty; 		
			} else {		
		
				buf.position(hasDerivativePriceUnitOfMeasureQty);		
		
			derivativePriceUnitOfMeasureQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativePriceUnitOfMeasureQty);		
					return 0;		
				}		
			}		
			hasDerivativePriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
			return derivativePriceUnitOfMeasureQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativePriceUnitOfMeasureQty() { return hasDerivativePriceUnitOfMeasureQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativePriceUnitOfMeasureQty(long src) {		
		derivativePriceUnitOfMeasureQty = src;
		hasDerivativePriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativePriceUnitOfMeasureQty(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativePriceUnitOfMeasureQty()) derivativePriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		derivativePriceUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativePriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativePriceUnitOfMeasureQty(String str) {		
		if (str == null ) return;
		if (hasDerivativePriceUnitOfMeasureQty()) derivativePriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativePriceUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativePriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getDerivativeExerciseStyle() { 		
		if ( hasDerivativeExerciseStyle()) {		
			if (hasDerivativeExerciseStyle == FixUtils.TAG_HAS_VALUE) {		
				return derivativeExerciseStyle; 		
			} else {		
		
				buf.position(hasDerivativeExerciseStyle);		
		
			derivativeExerciseStyle = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeExerciseStyle);		
					return (byte)'0';		
				}		
			}		
			hasDerivativeExerciseStyle = FixUtils.TAG_HAS_VALUE;		
			return derivativeExerciseStyle;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDerivativeExerciseStyle() { return hasDerivativeExerciseStyle != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeExerciseStyle(byte src) {		
		derivativeExerciseStyle = src;
		hasDerivativeExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeExerciseStyle(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeExerciseStyle()) derivativeExerciseStyle = (byte)' ';		
		derivativeExerciseStyle = src[0];		
		hasDerivativeExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeExerciseStyle(String str) {		
		if (str == null ) return;
		if (hasDerivativeExerciseStyle()) derivativeExerciseStyle = (byte)' ';		
		byte[] src = str.getBytes(); 		
		derivativeExerciseStyle = src[0];		
		hasDerivativeExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeOptPayAmount() { 		
		if ( hasDerivativeOptPayAmount()) {		
			if (hasDerivativeOptPayAmount == FixUtils.TAG_HAS_VALUE) {		
				return derivativeOptPayAmount; 		
			} else {		
		
				buf.position(hasDerivativeOptPayAmount);		
		
			derivativeOptPayAmount = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeOptPayAmount);		
					return 0;		
				}		
			}		
			hasDerivativeOptPayAmount = FixUtils.TAG_HAS_VALUE;		
			return derivativeOptPayAmount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeOptPayAmount() { return hasDerivativeOptPayAmount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeOptPayAmount(long src) {		
		derivativeOptPayAmount = src;
		hasDerivativeOptPayAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeOptPayAmount(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeOptPayAmount()) derivativeOptPayAmount = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeOptPayAmount = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeOptPayAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeOptPayAmount(String str) {		
		if (str == null ) return;
		if (hasDerivativeOptPayAmount()) derivativeOptPayAmount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeOptPayAmount = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeOptPayAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeTimeUnit() { 		
		if ( hasDerivativeTimeUnit()) {		
			if (hasDerivativeTimeUnit == FixUtils.TAG_HAS_VALUE) {		
				return derivativeTimeUnit; 		
			} else {		
		
				buf.position(hasDerivativeTimeUnit);		
		
			FixMessage.getTagStringValue(buf, derivativeTimeUnit, 0, derivativeTimeUnit.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeTimeUnit);		
					return null;		
				}		
			}		
			hasDerivativeTimeUnit = FixUtils.TAG_HAS_VALUE;		
			return derivativeTimeUnit;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeTimeUnit() { return hasDerivativeTimeUnit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeTimeUnit(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeTimeUnit()) FixUtils.fillSpace(derivativeTimeUnit);		
		FixUtils.copy(derivativeTimeUnit, src); 		
		hasDerivativeTimeUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeTimeUnit(String str) {		
		if (str == null ) return;
		if (hasDerivativeTimeUnit()) FixUtils.fillSpace(derivativeTimeUnit);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeTimeUnit, src); 		
		hasDerivativeTimeUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSecurityExchange() { 		
		if ( hasDerivativeSecurityExchange()) {		
			if (hasDerivativeSecurityExchange == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecurityExchange; 		
			} else {		
		
				buf.position(hasDerivativeSecurityExchange);		
		
			FixMessage.getTagStringValue(buf, derivativeSecurityExchange, 0, derivativeSecurityExchange.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecurityExchange);		
					return null;		
				}		
			}		
			hasDerivativeSecurityExchange = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecurityExchange;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSecurityExchange() { return hasDerivativeSecurityExchange != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecurityExchange(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecurityExchange()) FixUtils.fillSpace(derivativeSecurityExchange);		
		FixUtils.copy(derivativeSecurityExchange, src); 		
		hasDerivativeSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecurityExchange(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecurityExchange()) FixUtils.fillSpace(derivativeSecurityExchange);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSecurityExchange, src); 		
		hasDerivativeSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativePositionLimit() { 		
		if ( hasDerivativePositionLimit()) {		
			if (hasDerivativePositionLimit == FixUtils.TAG_HAS_VALUE) {		
				return derivativePositionLimit; 		
			} else {		
		
				buf.position(hasDerivativePositionLimit);		
		
			derivativePositionLimit = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativePositionLimit);		
					return 0;		
				}		
			}		
			hasDerivativePositionLimit = FixUtils.TAG_HAS_VALUE;		
			return derivativePositionLimit;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativePositionLimit() { return hasDerivativePositionLimit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativePositionLimit(long src) {		
		derivativePositionLimit = src;
		hasDerivativePositionLimit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativePositionLimit(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativePositionLimit()) derivativePositionLimit = FixUtils.TAG_HAS_NO_VALUE;		
		derivativePositionLimit = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativePositionLimit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativePositionLimit(String str) {		
		if (str == null ) return;
		if (hasDerivativePositionLimit()) derivativePositionLimit = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativePositionLimit = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativePositionLimit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeNTPositionLimit() { 		
		if ( hasDerivativeNTPositionLimit()) {		
			if (hasDerivativeNTPositionLimit == FixUtils.TAG_HAS_VALUE) {		
				return derivativeNTPositionLimit; 		
			} else {		
		
				buf.position(hasDerivativeNTPositionLimit);		
		
			derivativeNTPositionLimit = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeNTPositionLimit);		
					return 0;		
				}		
			}		
			hasDerivativeNTPositionLimit = FixUtils.TAG_HAS_VALUE;		
			return derivativeNTPositionLimit;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeNTPositionLimit() { return hasDerivativeNTPositionLimit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeNTPositionLimit(long src) {		
		derivativeNTPositionLimit = src;
		hasDerivativeNTPositionLimit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeNTPositionLimit(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeNTPositionLimit()) derivativeNTPositionLimit = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeNTPositionLimit = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeNTPositionLimit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeNTPositionLimit(String str) {		
		if (str == null ) return;
		if (hasDerivativeNTPositionLimit()) derivativeNTPositionLimit = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeNTPositionLimit = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeNTPositionLimit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getDerivativeSettlMethod() { 		
		if ( hasDerivativeSettlMethod()) {		
			if (hasDerivativeSettlMethod == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSettlMethod; 		
			} else {		
		
				buf.position(hasDerivativeSettlMethod);		
		
			derivativeSettlMethod = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSettlMethod);		
					return (byte)'0';		
				}		
			}		
			hasDerivativeSettlMethod = FixUtils.TAG_HAS_VALUE;		
			return derivativeSettlMethod;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDerivativeSettlMethod() { return hasDerivativeSettlMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSettlMethod(byte src) {		
		derivativeSettlMethod = src;
		hasDerivativeSettlMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeSettlMethod(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSettlMethod()) derivativeSettlMethod = (byte)' ';		
		derivativeSettlMethod = src[0];		
		hasDerivativeSettlMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSettlMethod(String str) {		
		if (str == null ) return;
		if (hasDerivativeSettlMethod()) derivativeSettlMethod = (byte)' ';		
		byte[] src = str.getBytes(); 		
		derivativeSettlMethod = src[0];		
		hasDerivativeSettlMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativePriceQuoteMethod() { 		
		if ( hasDerivativePriceQuoteMethod()) {		
			if (hasDerivativePriceQuoteMethod == FixUtils.TAG_HAS_VALUE) {		
				return derivativePriceQuoteMethod; 		
			} else {		
		
				buf.position(hasDerivativePriceQuoteMethod);		
		
			FixMessage.getTagStringValue(buf, derivativePriceQuoteMethod, 0, derivativePriceQuoteMethod.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativePriceQuoteMethod);		
					return null;		
				}		
			}		
			hasDerivativePriceQuoteMethod = FixUtils.TAG_HAS_VALUE;		
			return derivativePriceQuoteMethod;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativePriceQuoteMethod() { return hasDerivativePriceQuoteMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativePriceQuoteMethod(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativePriceQuoteMethod()) FixUtils.fillSpace(derivativePriceQuoteMethod);		
		FixUtils.copy(derivativePriceQuoteMethod, src); 		
		hasDerivativePriceQuoteMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativePriceQuoteMethod(String str) {		
		if (str == null ) return;
		if (hasDerivativePriceQuoteMethod()) FixUtils.fillSpace(derivativePriceQuoteMethod);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativePriceQuoteMethod, src); 		
		hasDerivativePriceQuoteMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeValuationMethod() { 		
		if ( hasDerivativeValuationMethod()) {		
			if (hasDerivativeValuationMethod == FixUtils.TAG_HAS_VALUE) {		
				return derivativeValuationMethod; 		
			} else {		
		
				buf.position(hasDerivativeValuationMethod);		
		
			FixMessage.getTagStringValue(buf, derivativeValuationMethod, 0, derivativeValuationMethod.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeValuationMethod);		
					return null;		
				}		
			}		
			hasDerivativeValuationMethod = FixUtils.TAG_HAS_VALUE;		
			return derivativeValuationMethod;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeValuationMethod() { return hasDerivativeValuationMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeValuationMethod(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeValuationMethod()) FixUtils.fillSpace(derivativeValuationMethod);		
		FixUtils.copy(derivativeValuationMethod, src); 		
		hasDerivativeValuationMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeValuationMethod(String str) {		
		if (str == null ) return;
		if (hasDerivativeValuationMethod()) FixUtils.fillSpace(derivativeValuationMethod);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeValuationMethod, src); 		
		hasDerivativeValuationMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeListMethod() { 		
		if ( hasDerivativeListMethod()) {		
			if (hasDerivativeListMethod == FixUtils.TAG_HAS_VALUE) {		
				return derivativeListMethod; 		
			} else {		
		
				buf.position(hasDerivativeListMethod);		
		
			derivativeListMethod = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeListMethod);		
					return 0;		
				}		
			}		
			hasDerivativeListMethod = FixUtils.TAG_HAS_VALUE;		
			return derivativeListMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeListMethod() { return hasDerivativeListMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeListMethod(long src) {		
		derivativeListMethod = src;
		hasDerivativeListMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeListMethod(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeListMethod()) derivativeListMethod = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeListMethod = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeListMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeListMethod(String str) {		
		if (str == null ) return;
		if (hasDerivativeListMethod()) derivativeListMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeListMethod = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeListMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeCapPrice() { 		
		if ( hasDerivativeCapPrice()) {		
			if (hasDerivativeCapPrice == FixUtils.TAG_HAS_VALUE) {		
				return derivativeCapPrice; 		
			} else {		
		
				buf.position(hasDerivativeCapPrice);		
		
			derivativeCapPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeCapPrice);		
					return 0;		
				}		
			}		
			hasDerivativeCapPrice = FixUtils.TAG_HAS_VALUE;		
			return derivativeCapPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeCapPrice() { return hasDerivativeCapPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeCapPrice(long src) {		
		derivativeCapPrice = src;
		hasDerivativeCapPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeCapPrice(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeCapPrice()) derivativeCapPrice = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeCapPrice = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeCapPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeCapPrice(String str) {		
		if (str == null ) return;
		if (hasDerivativeCapPrice()) derivativeCapPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeCapPrice = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeCapPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeFloorPrice() { 		
		if ( hasDerivativeFloorPrice()) {		
			if (hasDerivativeFloorPrice == FixUtils.TAG_HAS_VALUE) {		
				return derivativeFloorPrice; 		
			} else {		
		
				buf.position(hasDerivativeFloorPrice);		
		
			derivativeFloorPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeFloorPrice);		
					return 0;		
				}		
			}		
			hasDerivativeFloorPrice = FixUtils.TAG_HAS_VALUE;		
			return derivativeFloorPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeFloorPrice() { return hasDerivativeFloorPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeFloorPrice(long src) {		
		derivativeFloorPrice = src;
		hasDerivativeFloorPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeFloorPrice(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeFloorPrice()) derivativeFloorPrice = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeFloorPrice = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeFloorPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeFloorPrice(String str) {		
		if (str == null ) return;
		if (hasDerivativeFloorPrice()) derivativeFloorPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeFloorPrice = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeFloorPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativePutOrCall() { 		
		if ( hasDerivativePutOrCall()) {		
			if (hasDerivativePutOrCall == FixUtils.TAG_HAS_VALUE) {		
				return derivativePutOrCall; 		
			} else {		
		
				buf.position(hasDerivativePutOrCall);		
		
			derivativePutOrCall = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativePutOrCall);		
					return 0;		
				}		
			}		
			hasDerivativePutOrCall = FixUtils.TAG_HAS_VALUE;		
			return derivativePutOrCall;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativePutOrCall() { return hasDerivativePutOrCall != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativePutOrCall(long src) {		
		derivativePutOrCall = src;
		hasDerivativePutOrCall = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativePutOrCall(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativePutOrCall()) derivativePutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		derivativePutOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativePutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativePutOrCall(String str) {		
		if (str == null ) return;
		if (hasDerivativePutOrCall()) derivativePutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativePutOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativePutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeIssuer() { 		
		if ( hasDerivativeIssuer()) {		
			if (hasDerivativeIssuer == FixUtils.TAG_HAS_VALUE) {		
				return derivativeIssuer; 		
			} else {		
		
				buf.position(hasDerivativeIssuer);		
		
			FixMessage.getTagStringValue(buf, derivativeIssuer, 0, derivativeIssuer.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeIssuer);		
					return null;		
				}		
			}		
			hasDerivativeIssuer = FixUtils.TAG_HAS_VALUE;		
			return derivativeIssuer;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeIssuer() { return hasDerivativeIssuer != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeIssuer(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeIssuer()) FixUtils.fillSpace(derivativeIssuer);		
		FixUtils.copy(derivativeIssuer, src); 		
		hasDerivativeIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeIssuer(String str) {		
		if (str == null ) return;
		if (hasDerivativeIssuer()) FixUtils.fillSpace(derivativeIssuer);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeIssuer, src); 		
		hasDerivativeIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeEncodedIssuerLen() { 		
		if ( hasDerivativeEncodedIssuerLen()) {		
			if (hasDerivativeEncodedIssuerLen == FixUtils.TAG_HAS_VALUE) {		
				return derivativeEncodedIssuerLen; 		
			} else {		
		
				buf.position(hasDerivativeEncodedIssuerLen);		
		
			derivativeEncodedIssuerLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeEncodedIssuerLen);		
					return 0;		
				}		
			}		
			hasDerivativeEncodedIssuerLen = FixUtils.TAG_HAS_VALUE;		
			return derivativeEncodedIssuerLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeEncodedIssuerLen() { return hasDerivativeEncodedIssuerLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeEncodedIssuerLen(long src) {		
		derivativeEncodedIssuerLen = src;
		hasDerivativeEncodedIssuerLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeEncodedIssuerLen(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeEncodedIssuerLen()) derivativeEncodedIssuerLen = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeEncodedIssuerLen = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeEncodedIssuerLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeEncodedIssuerLen(String str) {		
		if (str == null ) return;
		if (hasDerivativeEncodedIssuerLen()) derivativeEncodedIssuerLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeEncodedIssuerLen = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeEncodedIssuerLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeEncodedIssuer() { 		
		if ( hasDerivativeEncodedIssuer()) {		
			if (hasDerivativeEncodedIssuer == FixUtils.TAG_HAS_VALUE) {		
				return derivativeEncodedIssuer; 		
			} else {		
		
				buf.position(hasDerivativeEncodedIssuer);		
		
			FixMessage.getTagStringValue(buf, derivativeEncodedIssuer, 0, derivativeEncodedIssuer.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeEncodedIssuer);		
					return null;		
				}		
			}		
			hasDerivativeEncodedIssuer = FixUtils.TAG_HAS_VALUE;		
			return derivativeEncodedIssuer;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeEncodedIssuer() { return hasDerivativeEncodedIssuer != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeEncodedIssuer(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeEncodedIssuer()) FixUtils.fillSpace(derivativeEncodedIssuer);		
		FixUtils.copy(derivativeEncodedIssuer, src); 		
		hasDerivativeEncodedIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeEncodedIssuer(String str) {		
		if (str == null ) return;
		if (hasDerivativeEncodedIssuer()) FixUtils.fillSpace(derivativeEncodedIssuer);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeEncodedIssuer, src); 		
		hasDerivativeEncodedIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSecurityDesc() { 		
		if ( hasDerivativeSecurityDesc()) {		
			if (hasDerivativeSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecurityDesc; 		
			} else {		
		
				buf.position(hasDerivativeSecurityDesc);		
		
			FixMessage.getTagStringValue(buf, derivativeSecurityDesc, 0, derivativeSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecurityDesc);		
					return null;		
				}		
			}		
			hasDerivativeSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSecurityDesc() { return hasDerivativeSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecurityDesc()) FixUtils.fillSpace(derivativeSecurityDesc);		
		FixUtils.copy(derivativeSecurityDesc, src); 		
		hasDerivativeSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecurityDesc()) FixUtils.fillSpace(derivativeSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSecurityDesc, src); 		
		hasDerivativeSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeEncodedSecurityDescLen() { 		
		if ( hasDerivativeEncodedSecurityDescLen()) {		
			if (hasDerivativeEncodedSecurityDescLen == FixUtils.TAG_HAS_VALUE) {		
				return derivativeEncodedSecurityDescLen; 		
			} else {		
		
				buf.position(hasDerivativeEncodedSecurityDescLen);		
		
			derivativeEncodedSecurityDescLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeEncodedSecurityDescLen);		
					return 0;		
				}		
			}		
			hasDerivativeEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
			return derivativeEncodedSecurityDescLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeEncodedSecurityDescLen() { return hasDerivativeEncodedSecurityDescLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeEncodedSecurityDescLen(long src) {		
		derivativeEncodedSecurityDescLen = src;
		hasDerivativeEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeEncodedSecurityDescLen(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeEncodedSecurityDescLen()) derivativeEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeEncodedSecurityDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeEncodedSecurityDescLen(String str) {		
		if (str == null ) return;
		if (hasDerivativeEncodedSecurityDescLen()) derivativeEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeEncodedSecurityDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeEncodedSecurityDesc() { 		
		if ( hasDerivativeEncodedSecurityDesc()) {		
			if (hasDerivativeEncodedSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return derivativeEncodedSecurityDesc; 		
			} else {		
		
				buf.position(hasDerivativeEncodedSecurityDesc);		
		
			FixMessage.getTagStringValue(buf, derivativeEncodedSecurityDesc, 0, derivativeEncodedSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeEncodedSecurityDesc);		
					return null;		
				}		
			}		
			hasDerivativeEncodedSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return derivativeEncodedSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeEncodedSecurityDesc() { return hasDerivativeEncodedSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeEncodedSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeEncodedSecurityDesc()) FixUtils.fillSpace(derivativeEncodedSecurityDesc);		
		FixUtils.copy(derivativeEncodedSecurityDesc, src); 		
		hasDerivativeEncodedSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeEncodedSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasDerivativeEncodedSecurityDesc()) FixUtils.fillSpace(derivativeEncodedSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeEncodedSecurityDesc, src); 		
		hasDerivativeEncodedSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeContractSettlMonth() { 		
		if ( hasDerivativeContractSettlMonth()) {		
			if (hasDerivativeContractSettlMonth == FixUtils.TAG_HAS_VALUE) {		
				return derivativeContractSettlMonth; 		
			} else {		
		
				buf.position(hasDerivativeContractSettlMonth);		
		
			FixMessage.getTagStringValue(buf, derivativeContractSettlMonth, 0, derivativeContractSettlMonth.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeContractSettlMonth);		
					return null;		
				}		
			}		
			hasDerivativeContractSettlMonth = FixUtils.TAG_HAS_VALUE;		
			return derivativeContractSettlMonth;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeContractSettlMonth() { return hasDerivativeContractSettlMonth != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeContractSettlMonth(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeContractSettlMonth()) FixUtils.fillSpace(derivativeContractSettlMonth);		
		FixUtils.copy(derivativeContractSettlMonth, src); 		
		hasDerivativeContractSettlMonth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeContractSettlMonth(String str) {		
		if (str == null ) return;
		if (hasDerivativeContractSettlMonth()) FixUtils.fillSpace(derivativeContractSettlMonth);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeContractSettlMonth, src); 		
		hasDerivativeContractSettlMonth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasDerivativeSymbol()) s += "DerivativeSymbol(1214)= " + new String( FixUtils.trim(getDerivativeSymbol()) ) + "\n" ; 
		if (hasDerivativeSymbolSfx()) s += "DerivativeSymbolSfx(1215)= " + new String( FixUtils.trim(getDerivativeSymbolSfx()) ) + "\n" ; 
		if (hasDerivativeSecurityID()) s += "DerivativeSecurityID(1216)= " + new String( FixUtils.trim(getDerivativeSecurityID()) ) + "\n" ; 
		if (hasDerivativeSecurityIDSource()) s += "DerivativeSecurityIDSource(1217)= " + new String( FixUtils.trim(getDerivativeSecurityIDSource()) ) + "\n" ; 
		if (hasDerivativeProduct()) s += "DerivativeProduct(1246)= " + getDerivativeProduct() + "\n" ; 
		if (hasDerivativeProductComplex()) s += "DerivativeProductComplex(1228)= " + new String( FixUtils.trim(getDerivativeProductComplex()) ) + "\n" ; 
		if (hasDerivFlexProductEligibilityIndicator()) s += "DerivFlexProductEligibilityIndicator(1243)= " + getDerivFlexProductEligibilityIndicator() + "\n" ; 
		if (hasDerivativeSecurityGroup()) s += "DerivativeSecurityGroup(1247)= " + new String( FixUtils.trim(getDerivativeSecurityGroup()) ) + "\n" ; 
		if (hasDerivativeCFICode()) s += "DerivativeCFICode(1248)= " + new String( FixUtils.trim(getDerivativeCFICode()) ) + "\n" ; 
		if (hasDerivativeSecurityType()) s += "DerivativeSecurityType(1249)= " + new String( FixUtils.trim(getDerivativeSecurityType()) ) + "\n" ; 
		if (hasDerivativeSecuritySubType()) s += "DerivativeSecuritySubType(1250)= " + new String( FixUtils.trim(getDerivativeSecuritySubType()) ) + "\n" ; 
		if (hasDerivativeMaturityMonthYear()) s += "DerivativeMaturityMonthYear(1251)= " + new String( FixUtils.trim(getDerivativeMaturityMonthYear()) ) + "\n" ; 
		if (hasDerivativeMaturityDate()) s += "DerivativeMaturityDate(1252)= " + new String( FixUtils.trim(getDerivativeMaturityDate()) ) + "\n" ; 
		if (hasDerivativeMaturityTime()) s += "DerivativeMaturityTime(1253)= " + new String( FixUtils.trim(getDerivativeMaturityTime()) ) + "\n" ; 
		if (hasDerivativeSettleOnOpenFlag()) s += "DerivativeSettleOnOpenFlag(1254)= " + new String( FixUtils.trim(getDerivativeSettleOnOpenFlag()) ) + "\n" ; 
		if (hasDerivativeInstrmtAssignmentMethod()) s += "DerivativeInstrmtAssignmentMethod(1255)= " + getDerivativeInstrmtAssignmentMethod() + "\n" ; 
		if (hasDerivativeSecurityStatus()) s += "DerivativeSecurityStatus(1256)= " + new String( FixUtils.trim(getDerivativeSecurityStatus()) ) + "\n" ; 
		if (hasDerivativeIssueDate()) s += "DerivativeIssueDate(1276)= " + new String( FixUtils.trim(getDerivativeIssueDate()) ) + "\n" ; 
		if (hasDerivativeInstrRegistry()) s += "DerivativeInstrRegistry(1257)= " + new String( FixUtils.trim(getDerivativeInstrRegistry()) ) + "\n" ; 
		if (hasDerivativeCountryOfIssue()) s += "DerivativeCountryOfIssue(1258)= " + new String( FixUtils.trim(getDerivativeCountryOfIssue()) ) + "\n" ; 
		if (hasDerivativeStateOrProvinceOfIssue()) s += "DerivativeStateOrProvinceOfIssue(1259)= " + new String( FixUtils.trim(getDerivativeStateOrProvinceOfIssue()) ) + "\n" ; 
		if (hasDerivativeStrikePrice()) s += "DerivativeStrikePrice(1261)= " + getDerivativeStrikePrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDerivativeLocaleOfIssue()) s += "DerivativeLocaleOfIssue(1260)= " + new String( FixUtils.trim(getDerivativeLocaleOfIssue()) ) + "\n" ; 
		if (hasDerivativeStrikeCurrency()) s += "DerivativeStrikeCurrency(1262)= " + new String( FixUtils.trim(getDerivativeStrikeCurrency()) ) + "\n" ; 
		if (hasDerivativeStrikeMultiplier()) s += "DerivativeStrikeMultiplier(1263)= " + getDerivativeStrikeMultiplier() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDerivativeStrikeValue()) s += "DerivativeStrikeValue(1264)= " + getDerivativeStrikeValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDerivativeOptAttribute()) s += "DerivativeOptAttribute(1265)= " + getDerivativeOptAttribute() + "\n" ; 
		if (hasDerivativeContractMultiplier()) s += "DerivativeContractMultiplier(1266)= " + getDerivativeContractMultiplier() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDerivativeMinPriceIncrement()) s += "DerivativeMinPriceIncrement(1267)= " + getDerivativeMinPriceIncrement() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDerivativeMinPriceIncrementAmount()) s += "DerivativeMinPriceIncrementAmount(1268)= " + getDerivativeMinPriceIncrementAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDerivativeContractMultiplierUnit()) s += "DerivativeContractMultiplierUnit(1438)= " + getDerivativeContractMultiplierUnit() + "\n" ; 
		if (hasDerivativeFlowScheduleType()) s += "DerivativeFlowScheduleType(1442)= " + getDerivativeFlowScheduleType() + "\n" ; 
		if (hasDerivativeUnitOfMeasure()) s += "DerivativeUnitOfMeasure(1269)= " + new String( FixUtils.trim(getDerivativeUnitOfMeasure()) ) + "\n" ; 
		if (hasDerivativeUnitOfMeasureQty()) s += "DerivativeUnitOfMeasureQty(1270)= " + getDerivativeUnitOfMeasureQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDerivativePriceUnitOfMeasure()) s += "DerivativePriceUnitOfMeasure(1315)= " + new String( FixUtils.trim(getDerivativePriceUnitOfMeasure()) ) + "\n" ; 
		if (hasDerivativePriceUnitOfMeasureQty()) s += "DerivativePriceUnitOfMeasureQty(1316)= " + getDerivativePriceUnitOfMeasureQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDerivativeExerciseStyle()) s += "DerivativeExerciseStyle(1299)= " + getDerivativeExerciseStyle() + "\n" ; 
		if (hasDerivativeOptPayAmount()) s += "DerivativeOptPayAmount(1225)= " + getDerivativeOptPayAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDerivativeTimeUnit()) s += "DerivativeTimeUnit(1271)= " + new String( FixUtils.trim(getDerivativeTimeUnit()) ) + "\n" ; 
		if (hasDerivativeSecurityExchange()) s += "DerivativeSecurityExchange(1272)= " + new String( FixUtils.trim(getDerivativeSecurityExchange()) ) + "\n" ; 
		if (hasDerivativePositionLimit()) s += "DerivativePositionLimit(1273)= " + getDerivativePositionLimit() + "\n" ; 
		if (hasDerivativeNTPositionLimit()) s += "DerivativeNTPositionLimit(1274)= " + getDerivativeNTPositionLimit() + "\n" ; 
		if (hasDerivativeSettlMethod()) s += "DerivativeSettlMethod(1317)= " + getDerivativeSettlMethod() + "\n" ; 
		if (hasDerivativePriceQuoteMethod()) s += "DerivativePriceQuoteMethod(1318)= " + new String( FixUtils.trim(getDerivativePriceQuoteMethod()) ) + "\n" ; 
		if (hasDerivativeValuationMethod()) s += "DerivativeValuationMethod(1319)= " + new String( FixUtils.trim(getDerivativeValuationMethod()) ) + "\n" ; 
		if (hasDerivativeListMethod()) s += "DerivativeListMethod(1320)= " + getDerivativeListMethod() + "\n" ; 
		if (hasDerivativeCapPrice()) s += "DerivativeCapPrice(1321)= " + getDerivativeCapPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDerivativeFloorPrice()) s += "DerivativeFloorPrice(1322)= " + getDerivativeFloorPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDerivativePutOrCall()) s += "DerivativePutOrCall(1323)= " + getDerivativePutOrCall() + "\n" ; 
		if (hasDerivativeIssuer()) s += "DerivativeIssuer(1275)= " + new String( FixUtils.trim(getDerivativeIssuer()) ) + "\n" ; 
		if (hasDerivativeEncodedIssuerLen()) s += "DerivativeEncodedIssuerLen(1277)= " + getDerivativeEncodedIssuerLen() + "\n" ; 
		if (hasDerivativeEncodedIssuer()) s += "DerivativeEncodedIssuer(1278)= " + new String( FixUtils.trim(getDerivativeEncodedIssuer()) ) + "\n" ; 
		if (hasDerivativeSecurityDesc()) s += "DerivativeSecurityDesc(1279)= " + new String( FixUtils.trim(getDerivativeSecurityDesc()) ) + "\n" ; 
		if (hasDerivativeEncodedSecurityDescLen()) s += "DerivativeEncodedSecurityDescLen(1280)= " + getDerivativeEncodedSecurityDescLen() + "\n" ; 
		if (hasDerivativeEncodedSecurityDesc()) s += "DerivativeEncodedSecurityDesc(1281)= " + new String( FixUtils.trim(getDerivativeEncodedSecurityDesc()) ) + "\n" ; 
		if (hasDerivativeContractSettlMonth()) s += "DerivativeContractSettlMonth(1285)= " + new String( FixUtils.trim(getDerivativeContractSettlMonth()) ) + "\n" ; 

		for (FixDerivativeSecurityAltIDGrp fixDerivativeSecurityAltIDGrp : derivativeSecurityAltIDGrp) fixDerivativeSecurityAltIDGrp.toString();
		s += derivativeSecurityXML.toString();
		for (FixDerivativeEventsGrp fixDerivativeEventsGrp : derivativeEventsGrp) fixDerivativeEventsGrp.toString();
		for (FixDerivativeInstrumentParties fixDerivativeInstrumentParties : derivativeInstrumentParties) fixDerivativeInstrumentParties.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDerivativeInstrument)) return false;

		FixDerivativeInstrument msg = (FixDerivativeInstrument) o;

		for (int i = 0; i < derivativeSecurityAltIDGrp.length; i++)
			if (!derivativeSecurityAltIDGrp[i].equals(msg.derivativeSecurityAltIDGrp[i])) return false;
		if (!derivativeSecurityXML.equals(msg.derivativeSecurityXML)) return false;
		for (int i = 0; i < derivativeEventsGrp.length; i++)
			if (!derivativeEventsGrp[i].equals(msg.derivativeEventsGrp[i])) return false;
		for (int i = 0; i < derivativeInstrumentParties.length; i++)
			if (!derivativeInstrumentParties[i].equals(msg.derivativeInstrumentParties[i])) return false;
		if ((hasDerivativeSymbol() && !msg.hasDerivativeSymbol()) || (!hasDerivativeSymbol() && msg.hasDerivativeSymbol())) return false;
		if (!(!hasDerivativeSymbol() && !msg.hasDerivativeSymbol()) && !FixUtils.equals(getDerivativeSymbol(), msg.getDerivativeSymbol())) return false;
		if ((hasDerivativeSymbolSfx() && !msg.hasDerivativeSymbolSfx()) || (!hasDerivativeSymbolSfx() && msg.hasDerivativeSymbolSfx())) return false;
		if (!(!hasDerivativeSymbolSfx() && !msg.hasDerivativeSymbolSfx()) && !FixUtils.equals(getDerivativeSymbolSfx(), msg.getDerivativeSymbolSfx())) return false;
		if ((hasDerivativeSecurityID() && !msg.hasDerivativeSecurityID()) || (!hasDerivativeSecurityID() && msg.hasDerivativeSecurityID())) return false;
		if (!(!hasDerivativeSecurityID() && !msg.hasDerivativeSecurityID()) && !FixUtils.equals(getDerivativeSecurityID(), msg.getDerivativeSecurityID())) return false;
		if ((hasDerivativeSecurityIDSource() && !msg.hasDerivativeSecurityIDSource()) || (!hasDerivativeSecurityIDSource() && msg.hasDerivativeSecurityIDSource())) return false;
		if (!(!hasDerivativeSecurityIDSource() && !msg.hasDerivativeSecurityIDSource()) && !FixUtils.equals(getDerivativeSecurityIDSource(), msg.getDerivativeSecurityIDSource())) return false;
		if ((hasDerivativeProduct() && !msg.hasDerivativeProduct()) || (!hasDerivativeProduct() && msg.hasDerivativeProduct())) return false;
		if (!(!hasDerivativeProduct() && !msg.hasDerivativeProduct()) && !(getDerivativeProduct()==msg.getDerivativeProduct())) return false;
		if ((hasDerivativeProductComplex() && !msg.hasDerivativeProductComplex()) || (!hasDerivativeProductComplex() && msg.hasDerivativeProductComplex())) return false;
		if (!(!hasDerivativeProductComplex() && !msg.hasDerivativeProductComplex()) && !FixUtils.equals(getDerivativeProductComplex(), msg.getDerivativeProductComplex())) return false;
		if ((hasDerivFlexProductEligibilityIndicator() && !msg.hasDerivFlexProductEligibilityIndicator()) || (!hasDerivFlexProductEligibilityIndicator() && msg.hasDerivFlexProductEligibilityIndicator())) return false;
		if (!(!hasDerivFlexProductEligibilityIndicator() && !msg.hasDerivFlexProductEligibilityIndicator()) && !(getDerivFlexProductEligibilityIndicator()==msg.getDerivFlexProductEligibilityIndicator())) return false;
		if ((hasDerivativeSecurityGroup() && !msg.hasDerivativeSecurityGroup()) || (!hasDerivativeSecurityGroup() && msg.hasDerivativeSecurityGroup())) return false;
		if (!(!hasDerivativeSecurityGroup() && !msg.hasDerivativeSecurityGroup()) && !FixUtils.equals(getDerivativeSecurityGroup(), msg.getDerivativeSecurityGroup())) return false;
		if ((hasDerivativeCFICode() && !msg.hasDerivativeCFICode()) || (!hasDerivativeCFICode() && msg.hasDerivativeCFICode())) return false;
		if (!(!hasDerivativeCFICode() && !msg.hasDerivativeCFICode()) && !FixUtils.equals(getDerivativeCFICode(), msg.getDerivativeCFICode())) return false;
		if ((hasDerivativeSecurityType() && !msg.hasDerivativeSecurityType()) || (!hasDerivativeSecurityType() && msg.hasDerivativeSecurityType())) return false;
		if (!(!hasDerivativeSecurityType() && !msg.hasDerivativeSecurityType()) && !FixUtils.equals(getDerivativeSecurityType(), msg.getDerivativeSecurityType())) return false;
		if ((hasDerivativeSecuritySubType() && !msg.hasDerivativeSecuritySubType()) || (!hasDerivativeSecuritySubType() && msg.hasDerivativeSecuritySubType())) return false;
		if (!(!hasDerivativeSecuritySubType() && !msg.hasDerivativeSecuritySubType()) && !FixUtils.equals(getDerivativeSecuritySubType(), msg.getDerivativeSecuritySubType())) return false;
		if ((hasDerivativeMaturityMonthYear() && !msg.hasDerivativeMaturityMonthYear()) || (!hasDerivativeMaturityMonthYear() && msg.hasDerivativeMaturityMonthYear())) return false;
		if (!(!hasDerivativeMaturityMonthYear() && !msg.hasDerivativeMaturityMonthYear()) && !FixUtils.equals(getDerivativeMaturityMonthYear(), msg.getDerivativeMaturityMonthYear())) return false;
		if ((hasDerivativeMaturityDate() && !msg.hasDerivativeMaturityDate()) || (!hasDerivativeMaturityDate() && msg.hasDerivativeMaturityDate())) return false;
		if ((hasDerivativeMaturityTime() && !msg.hasDerivativeMaturityTime()) || (!hasDerivativeMaturityTime() && msg.hasDerivativeMaturityTime())) return false;
		if ((hasDerivativeSettleOnOpenFlag() && !msg.hasDerivativeSettleOnOpenFlag()) || (!hasDerivativeSettleOnOpenFlag() && msg.hasDerivativeSettleOnOpenFlag())) return false;
		if (!(!hasDerivativeSettleOnOpenFlag() && !msg.hasDerivativeSettleOnOpenFlag()) && !FixUtils.equals(getDerivativeSettleOnOpenFlag(), msg.getDerivativeSettleOnOpenFlag())) return false;
		if ((hasDerivativeInstrmtAssignmentMethod() && !msg.hasDerivativeInstrmtAssignmentMethod()) || (!hasDerivativeInstrmtAssignmentMethod() && msg.hasDerivativeInstrmtAssignmentMethod())) return false;
		if (!(!hasDerivativeInstrmtAssignmentMethod() && !msg.hasDerivativeInstrmtAssignmentMethod()) && !(getDerivativeInstrmtAssignmentMethod()==msg.getDerivativeInstrmtAssignmentMethod())) return false;
		if ((hasDerivativeSecurityStatus() && !msg.hasDerivativeSecurityStatus()) || (!hasDerivativeSecurityStatus() && msg.hasDerivativeSecurityStatus())) return false;
		if (!(!hasDerivativeSecurityStatus() && !msg.hasDerivativeSecurityStatus()) && !FixUtils.equals(getDerivativeSecurityStatus(), msg.getDerivativeSecurityStatus())) return false;
		if ((hasDerivativeIssueDate() && !msg.hasDerivativeIssueDate()) || (!hasDerivativeIssueDate() && msg.hasDerivativeIssueDate())) return false;
		if ((hasDerivativeInstrRegistry() && !msg.hasDerivativeInstrRegistry()) || (!hasDerivativeInstrRegistry() && msg.hasDerivativeInstrRegistry())) return false;
		if (!(!hasDerivativeInstrRegistry() && !msg.hasDerivativeInstrRegistry()) && !FixUtils.equals(getDerivativeInstrRegistry(), msg.getDerivativeInstrRegistry())) return false;
		if ((hasDerivativeCountryOfIssue() && !msg.hasDerivativeCountryOfIssue()) || (!hasDerivativeCountryOfIssue() && msg.hasDerivativeCountryOfIssue())) return false;
		if (!(!hasDerivativeCountryOfIssue() && !msg.hasDerivativeCountryOfIssue()) && !FixUtils.equals(getDerivativeCountryOfIssue(), msg.getDerivativeCountryOfIssue())) return false;
		if ((hasDerivativeStateOrProvinceOfIssue() && !msg.hasDerivativeStateOrProvinceOfIssue()) || (!hasDerivativeStateOrProvinceOfIssue() && msg.hasDerivativeStateOrProvinceOfIssue())) return false;
		if (!(!hasDerivativeStateOrProvinceOfIssue() && !msg.hasDerivativeStateOrProvinceOfIssue()) && !FixUtils.equals(getDerivativeStateOrProvinceOfIssue(), msg.getDerivativeStateOrProvinceOfIssue())) return false;
		if ((hasDerivativeStrikePrice() && !msg.hasDerivativeStrikePrice()) || (!hasDerivativeStrikePrice() && msg.hasDerivativeStrikePrice())) return false;
		if (!(!hasDerivativeStrikePrice() && !msg.hasDerivativeStrikePrice()) && !(getDerivativeStrikePrice()==msg.getDerivativeStrikePrice())) return false;
		if ((hasDerivativeLocaleOfIssue() && !msg.hasDerivativeLocaleOfIssue()) || (!hasDerivativeLocaleOfIssue() && msg.hasDerivativeLocaleOfIssue())) return false;
		if (!(!hasDerivativeLocaleOfIssue() && !msg.hasDerivativeLocaleOfIssue()) && !FixUtils.equals(getDerivativeLocaleOfIssue(), msg.getDerivativeLocaleOfIssue())) return false;
		if ((hasDerivativeStrikeCurrency() && !msg.hasDerivativeStrikeCurrency()) || (!hasDerivativeStrikeCurrency() && msg.hasDerivativeStrikeCurrency())) return false;
		if (!(!hasDerivativeStrikeCurrency() && !msg.hasDerivativeStrikeCurrency()) && !FixUtils.equals(getDerivativeStrikeCurrency(), msg.getDerivativeStrikeCurrency())) return false;
		if ((hasDerivativeStrikeMultiplier() && !msg.hasDerivativeStrikeMultiplier()) || (!hasDerivativeStrikeMultiplier() && msg.hasDerivativeStrikeMultiplier())) return false;
		if (!(!hasDerivativeStrikeMultiplier() && !msg.hasDerivativeStrikeMultiplier()) && !(getDerivativeStrikeMultiplier()==msg.getDerivativeStrikeMultiplier())) return false;
		if ((hasDerivativeStrikeValue() && !msg.hasDerivativeStrikeValue()) || (!hasDerivativeStrikeValue() && msg.hasDerivativeStrikeValue())) return false;
		if (!(!hasDerivativeStrikeValue() && !msg.hasDerivativeStrikeValue()) && !(getDerivativeStrikeValue()==msg.getDerivativeStrikeValue())) return false;
		if ((hasDerivativeOptAttribute() && !msg.hasDerivativeOptAttribute()) || (!hasDerivativeOptAttribute() && msg.hasDerivativeOptAttribute())) return false;
		if (!(!hasDerivativeOptAttribute() && !msg.hasDerivativeOptAttribute()) && !(getDerivativeOptAttribute()==msg.getDerivativeOptAttribute())) return false;
		if ((hasDerivativeContractMultiplier() && !msg.hasDerivativeContractMultiplier()) || (!hasDerivativeContractMultiplier() && msg.hasDerivativeContractMultiplier())) return false;
		if (!(!hasDerivativeContractMultiplier() && !msg.hasDerivativeContractMultiplier()) && !(getDerivativeContractMultiplier()==msg.getDerivativeContractMultiplier())) return false;
		if ((hasDerivativeMinPriceIncrement() && !msg.hasDerivativeMinPriceIncrement()) || (!hasDerivativeMinPriceIncrement() && msg.hasDerivativeMinPriceIncrement())) return false;
		if (!(!hasDerivativeMinPriceIncrement() && !msg.hasDerivativeMinPriceIncrement()) && !(getDerivativeMinPriceIncrement()==msg.getDerivativeMinPriceIncrement())) return false;
		if ((hasDerivativeMinPriceIncrementAmount() && !msg.hasDerivativeMinPriceIncrementAmount()) || (!hasDerivativeMinPriceIncrementAmount() && msg.hasDerivativeMinPriceIncrementAmount())) return false;
		if (!(!hasDerivativeMinPriceIncrementAmount() && !msg.hasDerivativeMinPriceIncrementAmount()) && !(getDerivativeMinPriceIncrementAmount()==msg.getDerivativeMinPriceIncrementAmount())) return false;
		if ((hasDerivativeContractMultiplierUnit() && !msg.hasDerivativeContractMultiplierUnit()) || (!hasDerivativeContractMultiplierUnit() && msg.hasDerivativeContractMultiplierUnit())) return false;
		if (!(!hasDerivativeContractMultiplierUnit() && !msg.hasDerivativeContractMultiplierUnit()) && !(getDerivativeContractMultiplierUnit()==msg.getDerivativeContractMultiplierUnit())) return false;
		if ((hasDerivativeFlowScheduleType() && !msg.hasDerivativeFlowScheduleType()) || (!hasDerivativeFlowScheduleType() && msg.hasDerivativeFlowScheduleType())) return false;
		if (!(!hasDerivativeFlowScheduleType() && !msg.hasDerivativeFlowScheduleType()) && !(getDerivativeFlowScheduleType()==msg.getDerivativeFlowScheduleType())) return false;
		if ((hasDerivativeUnitOfMeasure() && !msg.hasDerivativeUnitOfMeasure()) || (!hasDerivativeUnitOfMeasure() && msg.hasDerivativeUnitOfMeasure())) return false;
		if (!(!hasDerivativeUnitOfMeasure() && !msg.hasDerivativeUnitOfMeasure()) && !FixUtils.equals(getDerivativeUnitOfMeasure(), msg.getDerivativeUnitOfMeasure())) return false;
		if ((hasDerivativeUnitOfMeasureQty() && !msg.hasDerivativeUnitOfMeasureQty()) || (!hasDerivativeUnitOfMeasureQty() && msg.hasDerivativeUnitOfMeasureQty())) return false;
		if (!(!hasDerivativeUnitOfMeasureQty() && !msg.hasDerivativeUnitOfMeasureQty()) && !(getDerivativeUnitOfMeasureQty()==msg.getDerivativeUnitOfMeasureQty())) return false;
		if ((hasDerivativePriceUnitOfMeasure() && !msg.hasDerivativePriceUnitOfMeasure()) || (!hasDerivativePriceUnitOfMeasure() && msg.hasDerivativePriceUnitOfMeasure())) return false;
		if (!(!hasDerivativePriceUnitOfMeasure() && !msg.hasDerivativePriceUnitOfMeasure()) && !FixUtils.equals(getDerivativePriceUnitOfMeasure(), msg.getDerivativePriceUnitOfMeasure())) return false;
		if ((hasDerivativePriceUnitOfMeasureQty() && !msg.hasDerivativePriceUnitOfMeasureQty()) || (!hasDerivativePriceUnitOfMeasureQty() && msg.hasDerivativePriceUnitOfMeasureQty())) return false;
		if (!(!hasDerivativePriceUnitOfMeasureQty() && !msg.hasDerivativePriceUnitOfMeasureQty()) && !(getDerivativePriceUnitOfMeasureQty()==msg.getDerivativePriceUnitOfMeasureQty())) return false;
		if ((hasDerivativeExerciseStyle() && !msg.hasDerivativeExerciseStyle()) || (!hasDerivativeExerciseStyle() && msg.hasDerivativeExerciseStyle())) return false;
		if (!(!hasDerivativeExerciseStyle() && !msg.hasDerivativeExerciseStyle()) && !(getDerivativeExerciseStyle()==msg.getDerivativeExerciseStyle())) return false;
		if ((hasDerivativeOptPayAmount() && !msg.hasDerivativeOptPayAmount()) || (!hasDerivativeOptPayAmount() && msg.hasDerivativeOptPayAmount())) return false;
		if (!(!hasDerivativeOptPayAmount() && !msg.hasDerivativeOptPayAmount()) && !(getDerivativeOptPayAmount()==msg.getDerivativeOptPayAmount())) return false;
		if ((hasDerivativeTimeUnit() && !msg.hasDerivativeTimeUnit()) || (!hasDerivativeTimeUnit() && msg.hasDerivativeTimeUnit())) return false;
		if (!(!hasDerivativeTimeUnit() && !msg.hasDerivativeTimeUnit()) && !FixUtils.equals(getDerivativeTimeUnit(), msg.getDerivativeTimeUnit())) return false;
		if ((hasDerivativeSecurityExchange() && !msg.hasDerivativeSecurityExchange()) || (!hasDerivativeSecurityExchange() && msg.hasDerivativeSecurityExchange())) return false;
		if (!(!hasDerivativeSecurityExchange() && !msg.hasDerivativeSecurityExchange()) && !FixUtils.equals(getDerivativeSecurityExchange(), msg.getDerivativeSecurityExchange())) return false;
		if ((hasDerivativePositionLimit() && !msg.hasDerivativePositionLimit()) || (!hasDerivativePositionLimit() && msg.hasDerivativePositionLimit())) return false;
		if (!(!hasDerivativePositionLimit() && !msg.hasDerivativePositionLimit()) && !(getDerivativePositionLimit()==msg.getDerivativePositionLimit())) return false;
		if ((hasDerivativeNTPositionLimit() && !msg.hasDerivativeNTPositionLimit()) || (!hasDerivativeNTPositionLimit() && msg.hasDerivativeNTPositionLimit())) return false;
		if (!(!hasDerivativeNTPositionLimit() && !msg.hasDerivativeNTPositionLimit()) && !(getDerivativeNTPositionLimit()==msg.getDerivativeNTPositionLimit())) return false;
		if ((hasDerivativeSettlMethod() && !msg.hasDerivativeSettlMethod()) || (!hasDerivativeSettlMethod() && msg.hasDerivativeSettlMethod())) return false;
		if (!(!hasDerivativeSettlMethod() && !msg.hasDerivativeSettlMethod()) && !(getDerivativeSettlMethod()==msg.getDerivativeSettlMethod())) return false;
		if ((hasDerivativePriceQuoteMethod() && !msg.hasDerivativePriceQuoteMethod()) || (!hasDerivativePriceQuoteMethod() && msg.hasDerivativePriceQuoteMethod())) return false;
		if (!(!hasDerivativePriceQuoteMethod() && !msg.hasDerivativePriceQuoteMethod()) && !FixUtils.equals(getDerivativePriceQuoteMethod(), msg.getDerivativePriceQuoteMethod())) return false;
		if ((hasDerivativeValuationMethod() && !msg.hasDerivativeValuationMethod()) || (!hasDerivativeValuationMethod() && msg.hasDerivativeValuationMethod())) return false;
		if (!(!hasDerivativeValuationMethod() && !msg.hasDerivativeValuationMethod()) && !FixUtils.equals(getDerivativeValuationMethod(), msg.getDerivativeValuationMethod())) return false;
		if ((hasDerivativeListMethod() && !msg.hasDerivativeListMethod()) || (!hasDerivativeListMethod() && msg.hasDerivativeListMethod())) return false;
		if (!(!hasDerivativeListMethod() && !msg.hasDerivativeListMethod()) && !(getDerivativeListMethod()==msg.getDerivativeListMethod())) return false;
		if ((hasDerivativeCapPrice() && !msg.hasDerivativeCapPrice()) || (!hasDerivativeCapPrice() && msg.hasDerivativeCapPrice())) return false;
		if (!(!hasDerivativeCapPrice() && !msg.hasDerivativeCapPrice()) && !(getDerivativeCapPrice()==msg.getDerivativeCapPrice())) return false;
		if ((hasDerivativeFloorPrice() && !msg.hasDerivativeFloorPrice()) || (!hasDerivativeFloorPrice() && msg.hasDerivativeFloorPrice())) return false;
		if (!(!hasDerivativeFloorPrice() && !msg.hasDerivativeFloorPrice()) && !(getDerivativeFloorPrice()==msg.getDerivativeFloorPrice())) return false;
		if ((hasDerivativePutOrCall() && !msg.hasDerivativePutOrCall()) || (!hasDerivativePutOrCall() && msg.hasDerivativePutOrCall())) return false;
		if (!(!hasDerivativePutOrCall() && !msg.hasDerivativePutOrCall()) && !(getDerivativePutOrCall()==msg.getDerivativePutOrCall())) return false;
		if ((hasDerivativeIssuer() && !msg.hasDerivativeIssuer()) || (!hasDerivativeIssuer() && msg.hasDerivativeIssuer())) return false;
		if (!(!hasDerivativeIssuer() && !msg.hasDerivativeIssuer()) && !FixUtils.equals(getDerivativeIssuer(), msg.getDerivativeIssuer())) return false;
		if ((hasDerivativeEncodedIssuerLen() && !msg.hasDerivativeEncodedIssuerLen()) || (!hasDerivativeEncodedIssuerLen() && msg.hasDerivativeEncodedIssuerLen())) return false;
		if (!(!hasDerivativeEncodedIssuerLen() && !msg.hasDerivativeEncodedIssuerLen()) && !(getDerivativeEncodedIssuerLen()==msg.getDerivativeEncodedIssuerLen())) return false;
		if ((hasDerivativeEncodedIssuer() && !msg.hasDerivativeEncodedIssuer()) || (!hasDerivativeEncodedIssuer() && msg.hasDerivativeEncodedIssuer())) return false;
		if (!(!hasDerivativeEncodedIssuer() && !msg.hasDerivativeEncodedIssuer()) && !FixUtils.equals(getDerivativeEncodedIssuer(), msg.getDerivativeEncodedIssuer())) return false;
		if ((hasDerivativeSecurityDesc() && !msg.hasDerivativeSecurityDesc()) || (!hasDerivativeSecurityDesc() && msg.hasDerivativeSecurityDesc())) return false;
		if (!(!hasDerivativeSecurityDesc() && !msg.hasDerivativeSecurityDesc()) && !FixUtils.equals(getDerivativeSecurityDesc(), msg.getDerivativeSecurityDesc())) return false;
		if ((hasDerivativeEncodedSecurityDescLen() && !msg.hasDerivativeEncodedSecurityDescLen()) || (!hasDerivativeEncodedSecurityDescLen() && msg.hasDerivativeEncodedSecurityDescLen())) return false;
		if (!(!hasDerivativeEncodedSecurityDescLen() && !msg.hasDerivativeEncodedSecurityDescLen()) && !(getDerivativeEncodedSecurityDescLen()==msg.getDerivativeEncodedSecurityDescLen())) return false;
		if ((hasDerivativeEncodedSecurityDesc() && !msg.hasDerivativeEncodedSecurityDesc()) || (!hasDerivativeEncodedSecurityDesc() && msg.hasDerivativeEncodedSecurityDesc())) return false;
		if (!(!hasDerivativeEncodedSecurityDesc() && !msg.hasDerivativeEncodedSecurityDesc()) && !FixUtils.equals(getDerivativeEncodedSecurityDesc(), msg.getDerivativeEncodedSecurityDesc())) return false;
		if ((hasDerivativeContractSettlMonth() && !msg.hasDerivativeContractSettlMonth()) || (!hasDerivativeContractSettlMonth() && msg.hasDerivativeContractSettlMonth())) return false;
		if (!(!hasDerivativeContractSettlMonth() && !msg.hasDerivativeContractSettlMonth()) && !FixUtils.equals(getDerivativeContractSettlMonth(), msg.getDerivativeContractSettlMonth())) return false;
		return true;
	}
	public FixDerivativeInstrument clone ( FixDerivativeInstrument out ) {
		if ( hasDerivativeSymbol())
			out.setDerivativeSymbol(getDerivativeSymbol());
		if ( hasDerivativeSymbolSfx())
			out.setDerivativeSymbolSfx(getDerivativeSymbolSfx());
		if ( hasDerivativeSecurityID())
			out.setDerivativeSecurityID(getDerivativeSecurityID());
		if ( hasDerivativeSecurityIDSource())
			out.setDerivativeSecurityIDSource(getDerivativeSecurityIDSource());
		if ( hasDerivativeProduct())
			out.setDerivativeProduct(getDerivativeProduct());
		if ( hasDerivativeProductComplex())
			out.setDerivativeProductComplex(getDerivativeProductComplex());
		if ( hasDerivFlexProductEligibilityIndicator())
			out.setDerivFlexProductEligibilityIndicator(getDerivFlexProductEligibilityIndicator());
		if ( hasDerivativeSecurityGroup())
			out.setDerivativeSecurityGroup(getDerivativeSecurityGroup());
		if ( hasDerivativeCFICode())
			out.setDerivativeCFICode(getDerivativeCFICode());
		if ( hasDerivativeSecurityType())
			out.setDerivativeSecurityType(getDerivativeSecurityType());
		if ( hasDerivativeSecuritySubType())
			out.setDerivativeSecuritySubType(getDerivativeSecuritySubType());
		if ( hasDerivativeMaturityMonthYear())
			out.setDerivativeMaturityMonthYear(getDerivativeMaturityMonthYear());
		if ( hasDerivativeMaturityDate())
			out.setDerivativeMaturityDate(getDerivativeMaturityDate());
		if ( hasDerivativeMaturityTime())
			out.setDerivativeMaturityTime(getDerivativeMaturityTime());
		if ( hasDerivativeSettleOnOpenFlag())
			out.setDerivativeSettleOnOpenFlag(getDerivativeSettleOnOpenFlag());
		if ( hasDerivativeInstrmtAssignmentMethod())
			out.setDerivativeInstrmtAssignmentMethod(getDerivativeInstrmtAssignmentMethod());
		if ( hasDerivativeSecurityStatus())
			out.setDerivativeSecurityStatus(getDerivativeSecurityStatus());
		if ( hasDerivativeIssueDate())
			out.setDerivativeIssueDate(getDerivativeIssueDate());
		if ( hasDerivativeInstrRegistry())
			out.setDerivativeInstrRegistry(getDerivativeInstrRegistry());
		if ( hasDerivativeCountryOfIssue())
			out.setDerivativeCountryOfIssue(getDerivativeCountryOfIssue());
		if ( hasDerivativeStateOrProvinceOfIssue())
			out.setDerivativeStateOrProvinceOfIssue(getDerivativeStateOrProvinceOfIssue());
		if ( hasDerivativeStrikePrice())
			out.setDerivativeStrikePrice(getDerivativeStrikePrice());
		if ( hasDerivativeLocaleOfIssue())
			out.setDerivativeLocaleOfIssue(getDerivativeLocaleOfIssue());
		if ( hasDerivativeStrikeCurrency())
			out.setDerivativeStrikeCurrency(getDerivativeStrikeCurrency());
		if ( hasDerivativeStrikeMultiplier())
			out.setDerivativeStrikeMultiplier(getDerivativeStrikeMultiplier());
		if ( hasDerivativeStrikeValue())
			out.setDerivativeStrikeValue(getDerivativeStrikeValue());
		if ( hasDerivativeOptAttribute())
			out.setDerivativeOptAttribute(getDerivativeOptAttribute());
		if ( hasDerivativeContractMultiplier())
			out.setDerivativeContractMultiplier(getDerivativeContractMultiplier());
		if ( hasDerivativeMinPriceIncrement())
			out.setDerivativeMinPriceIncrement(getDerivativeMinPriceIncrement());
		if ( hasDerivativeMinPriceIncrementAmount())
			out.setDerivativeMinPriceIncrementAmount(getDerivativeMinPriceIncrementAmount());
		if ( hasDerivativeContractMultiplierUnit())
			out.setDerivativeContractMultiplierUnit(getDerivativeContractMultiplierUnit());
		if ( hasDerivativeFlowScheduleType())
			out.setDerivativeFlowScheduleType(getDerivativeFlowScheduleType());
		if ( hasDerivativeUnitOfMeasure())
			out.setDerivativeUnitOfMeasure(getDerivativeUnitOfMeasure());
		if ( hasDerivativeUnitOfMeasureQty())
			out.setDerivativeUnitOfMeasureQty(getDerivativeUnitOfMeasureQty());
		if ( hasDerivativePriceUnitOfMeasure())
			out.setDerivativePriceUnitOfMeasure(getDerivativePriceUnitOfMeasure());
		if ( hasDerivativePriceUnitOfMeasureQty())
			out.setDerivativePriceUnitOfMeasureQty(getDerivativePriceUnitOfMeasureQty());
		if ( hasDerivativeExerciseStyle())
			out.setDerivativeExerciseStyle(getDerivativeExerciseStyle());
		if ( hasDerivativeOptPayAmount())
			out.setDerivativeOptPayAmount(getDerivativeOptPayAmount());
		if ( hasDerivativeTimeUnit())
			out.setDerivativeTimeUnit(getDerivativeTimeUnit());
		if ( hasDerivativeSecurityExchange())
			out.setDerivativeSecurityExchange(getDerivativeSecurityExchange());
		if ( hasDerivativePositionLimit())
			out.setDerivativePositionLimit(getDerivativePositionLimit());
		if ( hasDerivativeNTPositionLimit())
			out.setDerivativeNTPositionLimit(getDerivativeNTPositionLimit());
		if ( hasDerivativeSettlMethod())
			out.setDerivativeSettlMethod(getDerivativeSettlMethod());
		if ( hasDerivativePriceQuoteMethod())
			out.setDerivativePriceQuoteMethod(getDerivativePriceQuoteMethod());
		if ( hasDerivativeValuationMethod())
			out.setDerivativeValuationMethod(getDerivativeValuationMethod());
		if ( hasDerivativeListMethod())
			out.setDerivativeListMethod(getDerivativeListMethod());
		if ( hasDerivativeCapPrice())
			out.setDerivativeCapPrice(getDerivativeCapPrice());
		if ( hasDerivativeFloorPrice())
			out.setDerivativeFloorPrice(getDerivativeFloorPrice());
		if ( hasDerivativePutOrCall())
			out.setDerivativePutOrCall(getDerivativePutOrCall());
		if ( hasDerivativeIssuer())
			out.setDerivativeIssuer(getDerivativeIssuer());
		if ( hasDerivativeEncodedIssuerLen())
			out.setDerivativeEncodedIssuerLen(getDerivativeEncodedIssuerLen());
		if ( hasDerivativeEncodedIssuer())
			out.setDerivativeEncodedIssuer(getDerivativeEncodedIssuer());
		if ( hasDerivativeSecurityDesc())
			out.setDerivativeSecurityDesc(getDerivativeSecurityDesc());
		if ( hasDerivativeEncodedSecurityDescLen())
			out.setDerivativeEncodedSecurityDescLen(getDerivativeEncodedSecurityDescLen());
		if ( hasDerivativeEncodedSecurityDesc())
			out.setDerivativeEncodedSecurityDesc(getDerivativeEncodedSecurityDesc());
		if ( hasDerivativeContractSettlMonth())
			out.setDerivativeContractSettlMonth(getDerivativeContractSettlMonth());
		int count = 0;
		count = 0;
		for (FixDerivativeSecurityAltIDGrp fixDerivativeSecurityAltIDGrp : derivativeSecurityAltIDGrp) {
			if (!fixDerivativeSecurityAltIDGrp.hasGroup()) continue;
			out.derivativeSecurityAltIDGrp[count] = fixDerivativeSecurityAltIDGrp.clone( out.derivativeSecurityAltIDGrp[count] );
			count++;
		}
		if (derivativeSecurityXML.hasGroup())
			out.derivativeSecurityXML = derivativeSecurityXML.clone( out.derivativeSecurityXML);
		count = 0;
		for (FixDerivativeEventsGrp fixDerivativeEventsGrp : derivativeEventsGrp) {
			if (!fixDerivativeEventsGrp.hasGroup()) continue;
			out.derivativeEventsGrp[count] = fixDerivativeEventsGrp.clone( out.derivativeEventsGrp[count] );
			count++;
		}
		count = 0;
		for (FixDerivativeInstrumentParties fixDerivativeInstrumentParties : derivativeInstrumentParties) {
			if (!fixDerivativeInstrumentParties.hasGroup()) continue;
			out.derivativeInstrumentParties[count] = fixDerivativeInstrumentParties.clone( out.derivativeInstrumentParties[count] );
			count++;
		}
		return out;
	}

}
