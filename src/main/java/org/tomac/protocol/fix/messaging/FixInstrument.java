package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixInstrument extends FixGroup {
	private short hasSymbol;
	byte[] symbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSymbolSfx;
	byte[] symbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityID;
	byte[] securityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityIDSource;
	byte[] securityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasProduct;
	long product = 0;		
	private short hasSecurityGroup;
	byte[] securityGroup = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasProductComplex;
	byte[] productComplex = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCFICode;
	byte[] cFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityType;
	byte[] securityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecuritySubType;
	byte[] securitySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMaturityMonthYear;
	byte[] maturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMaturityDate;
	byte[] maturityDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityStatus;
	byte[] securityStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettleOnOpenFlag;
	byte[] settleOnOpenFlag = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasInstrmtAssignmentMethod;
	byte instrmtAssignmentMethod = (byte)' ';		
	private short hasMaturityTime;
	byte[] maturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCouponPaymentDate;
	byte[] couponPaymentDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRestructuringType;
	byte[] restructuringType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSeniority;
	byte[] seniority = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNotionalPercentageOutstanding;
	long notionalPercentageOutstanding = 0;		
	private short hasOriginalNotionalPercentageOutstanding;
	long originalNotionalPercentageOutstanding = 0;		
	private short hasAttachmentPoint;
	long attachmentPoint = 0;		
	private short hasDetachmentPoint;
	long detachmentPoint = 0;		
	private short hasIssueDate;
	byte[] issueDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRepoCollateralSecurityType;
	long repoCollateralSecurityType = 0;		
	private short hasRepurchaseTerm;
	long repurchaseTerm = 0;		
	private short hasRepurchaseRate;
	long repurchaseRate = 0;		
	private short hasFactor;
	long factor = 0;		
	private short hasCreditRating;
	byte[] creditRating = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasInstrRegistry;
	byte[] instrRegistry = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCountryOfIssue;
	byte[] countryOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasStateOrProvinceOfIssue;
	byte[] stateOrProvinceOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLocaleOfIssue;
	byte[] localeOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRedemptionDate;
	byte[] redemptionDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasStrikePrice;
	long strikePrice = 0;		
	private short hasStrikeCurrency;
	byte[] strikeCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasStrikeMultiplier;
	long strikeMultiplier = 0;		
	private short hasStrikeValue;
	long strikeValue = 0;		
	private short hasStrikePriceDeterminationMethod;
	long strikePriceDeterminationMethod = 0;		
	private short hasStrikePriceBoundaryMethod;
	long strikePriceBoundaryMethod = 0;		
	private short hasStrikePriceBoundaryPrecision;
	long strikePriceBoundaryPrecision = 0;		
	private short hasUnderlyingPriceDeterminationMethod;
	long underlyingPriceDeterminationMethod = 0;		
	private short hasOptAttribute;
	byte optAttribute = (byte)' ';		
	private short hasContractMultiplier;
	long contractMultiplier = 0;		
	private short hasMinPriceIncrement;
	long minPriceIncrement = 0;		
	private short hasUnitOfMeasure;
	byte[] unitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTimeUnit;
	byte[] timeUnit = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMinPriceIncrementAmount;
	long minPriceIncrementAmount = 0;		
	private short hasUnitOfMeasureQty;
	long unitOfMeasureQty = 0;		
	private short hasPriceUnitOfMeasure;
	byte[] priceUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPriceUnitOfMeasureQty;
	long priceUnitOfMeasureQty = 0;		
	private short hasSettlMethod;
	byte settlMethod = (byte)' ';		
	private short hasExerciseStyle;
	long exerciseStyle = 0;		
	private short hasOptPayoutAmount;
	long optPayoutAmount = 0;		
	private short hasPriceQuoteMethod;
	byte[] priceQuoteMethod = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasListMethod;
	long listMethod = 0;		
	private short hasCapPrice;
	long capPrice = 0;		
	private short hasFloorPrice;
	long floorPrice = 0;		
	private short hasPutOrCall;
	long putOrCall = 0;		
	private short hasFlexibleIndicator;
		boolean flexibleIndicator = false;		
	private short hasFlexProductEligibilityIndicator;
		boolean flexProductEligibilityIndicator = false;		
	private short hasValuationMethod;
	byte[] valuationMethod = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasContractMultiplierUnit;
	long contractMultiplierUnit = 0;		
	private short hasFlowScheduleType;
	long flowScheduleType = 0;		
	private short hasOptPayoutType;
	long optPayoutType = 0;		
	private short hasCouponRate;
	long couponRate = 0;		
	private short hasSecurityExchange;
	byte[] securityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPositionLimit;
	long positionLimit = 0;		
	private short hasNTPositionLimit;
	long nTPositionLimit = 0;		
	private short hasIssuer;
	byte[] issuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEncodedIssuerLen;
	long encodedIssuerLen = 0;		
	private short hasEncodedIssuer;
	byte[] encodedIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityDesc;
	byte[] securityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEncodedSecurityDescLen;
	long encodedSecurityDescLen = 0;		
	private short hasEncodedSecurityDesc;
	byte[] encodedSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPool;
	byte[] pool = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasContractSettlMonth;
	byte[] contractSettlMonth = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCPProgram;
	long cPProgram = 0;		
	private short hasCPRegType;
	byte[] cPRegType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDatedDate;
	byte[] datedDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasInterestAccrualDate;
	byte[] interestAccrualDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixSecAltIDGrp[] secAltIDGrp;
		public FixSecurityXML securityXML;
		public FixEvntGrp[] evntGrp;
		public FixInstrumentParties[] instrumentParties;
		public FixComplexEvents[] complexEvents;
	
	public FixInstrument() {
		this(false);
	}

	public FixInstrument(boolean isRequired) {
		super(FixTags.SYMBOL_INT);

		this.isRequired = isRequired;
		
		hasSymbol = FixUtils.TAG_HAS_NO_VALUE;		
		symbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;		
		symbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityID = FixUtils.TAG_HAS_NO_VALUE;		
		securityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		securityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasProduct = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityGroup = FixUtils.TAG_HAS_NO_VALUE;		
		securityGroup = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasProductComplex = FixUtils.TAG_HAS_NO_VALUE;		
		productComplex = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCFICode = FixUtils.TAG_HAS_NO_VALUE;		
		cFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		securityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;		
		securitySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;		
		maturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMaturityDate = FixUtils.TAG_HAS_NO_VALUE;		
		maturityDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityStatus = FixUtils.TAG_HAS_NO_VALUE;		
		securityStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettleOnOpenFlag = FixUtils.TAG_HAS_NO_VALUE;		
		settleOnOpenFlag = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasInstrmtAssignmentMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaturityTime = FixUtils.TAG_HAS_NO_VALUE;		
		maturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCouponPaymentDate = FixUtils.TAG_HAS_NO_VALUE;		
		couponPaymentDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRestructuringType = FixUtils.TAG_HAS_NO_VALUE;		
		restructuringType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSeniority = FixUtils.TAG_HAS_NO_VALUE;		
		seniority = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		hasOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		hasAttachmentPoint = FixUtils.TAG_HAS_NO_VALUE;		
		hasDetachmentPoint = FixUtils.TAG_HAS_NO_VALUE;		
		hasIssueDate = FixUtils.TAG_HAS_NO_VALUE;		
		issueDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRepoCollateralSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		hasRepurchaseTerm = FixUtils.TAG_HAS_NO_VALUE;		
		hasRepurchaseRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasFactor = FixUtils.TAG_HAS_NO_VALUE;		
		hasCreditRating = FixUtils.TAG_HAS_NO_VALUE;		
		creditRating = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasInstrRegistry = FixUtils.TAG_HAS_NO_VALUE;		
		instrRegistry = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCountryOfIssue = FixUtils.TAG_HAS_NO_VALUE;		
		countryOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasStateOrProvinceOfIssue = FixUtils.TAG_HAS_NO_VALUE;		
		stateOrProvinceOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLocaleOfIssue = FixUtils.TAG_HAS_NO_VALUE;		
		localeOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRedemptionDate = FixUtils.TAG_HAS_NO_VALUE;		
		redemptionDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasStrikeCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		strikeCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasStrikeMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		hasStrikeValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasStrikePriceDeterminationMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasStrikePriceBoundaryMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasStrikePriceBoundaryPrecision = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingPriceDeterminationMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasOptAttribute = FixUtils.TAG_HAS_NO_VALUE;		
		hasContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		hasMinPriceIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;		
		unitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTimeUnit = FixUtils.TAG_HAS_NO_VALUE;		
		timeUnit = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMinPriceIncrementAmount = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;		
		priceUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		hasOptPayoutAmount = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceQuoteMethod = FixUtils.TAG_HAS_NO_VALUE;		
		priceQuoteMethod = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasListMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasCapPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasFloorPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		hasFlexibleIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasFlexProductEligibilityIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasValuationMethod = FixUtils.TAG_HAS_NO_VALUE;		
		valuationMethod = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;		
		hasFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;		
		hasOptPayoutType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;		
		securityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPositionLimit = FixUtils.TAG_HAS_NO_VALUE;		
		hasNTPositionLimit = FixUtils.TAG_HAS_NO_VALUE;		
		hasIssuer = FixUtils.TAG_HAS_NO_VALUE;		
		issuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEncodedIssuerLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedIssuer = FixUtils.TAG_HAS_NO_VALUE;		
		encodedIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		securityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		encodedSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPool = FixUtils.TAG_HAS_NO_VALUE;		
		pool = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasContractSettlMonth = FixUtils.TAG_HAS_NO_VALUE;		
		contractSettlMonth = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCPProgram = FixUtils.TAG_HAS_NO_VALUE;		
		hasCPRegType = FixUtils.TAG_HAS_NO_VALUE;		
		cPRegType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDatedDate = FixUtils.TAG_HAS_NO_VALUE;		
		datedDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasInterestAccrualDate = FixUtils.TAG_HAS_NO_VALUE;		
		interestAccrualDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		secAltIDGrp = new FixSecAltIDGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) secAltIDGrp[i] = new FixSecAltIDGrp();
		securityXML = new FixSecurityXML();
		evntGrp = new FixEvntGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) evntGrp[i] = new FixEvntGrp();
		instrumentParties = new FixInstrumentParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrumentParties[i] = new FixInstrumentParties();
		complexEvents = new FixComplexEvents[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) complexEvents[i] = new FixComplexEvents();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSymbol()) return true;
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
            	case FixTags.SYMBOL_INT:		
            		hasSymbol = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SYMBOLSFX_INT:		
            		hasSymbolSfx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYID_INT:		
            		hasSecurityID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYIDSOURCE_INT:		
            		hasSecurityIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PRODUCT_INT:		
            		hasProduct = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYGROUP_INT:		
            		hasSecurityGroup = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PRODUCTCOMPLEX_INT:		
            		hasProductComplex = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CFICODE_INT:		
            		hasCFICode = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYTYPE_INT:		
            		hasSecurityType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYSUBTYPE_INT:		
            		hasSecuritySubType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MATURITYMONTHYEAR_INT:		
            		hasMaturityMonthYear = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MATURITYDATE_INT:		
            		hasMaturityDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYSTATUS_INT:		
            		hasSecurityStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLEONOPENFLAG_INT:		
            		hasSettleOnOpenFlag = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.INSTRMTASSIGNMENTMETHOD_INT:		
            		hasInstrmtAssignmentMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MATURITYTIME_INT:		
            		hasMaturityTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.COUPONPAYMENTDATE_INT:		
            		hasCouponPaymentDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RESTRUCTURINGTYPE_INT:		
            		hasRestructuringType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SENIORITY_INT:		
            		hasSeniority = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.NOTIONALPERCENTAGEOUTSTANDING_INT:		
            		hasNotionalPercentageOutstanding = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ORIGINALNOTIONALPERCENTAGEOUTSTANDING_INT:		
            		hasOriginalNotionalPercentageOutstanding = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ATTACHMENTPOINT_INT:		
            		hasAttachmentPoint = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DETACHMENTPOINT_INT:		
            		hasDetachmentPoint = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ISSUEDATE_INT:		
            		hasIssueDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.REPOCOLLATERALSECURITYTYPE_INT:		
            		hasRepoCollateralSecurityType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.REPURCHASETERM_INT:		
            		hasRepurchaseTerm = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.REPURCHASERATE_INT:		
            		hasRepurchaseRate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.FACTOR_INT:		
            		hasFactor = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CREDITRATING_INT:		
            		hasCreditRating = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.INSTRREGISTRY_INT:		
            		hasInstrRegistry = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.COUNTRYOFISSUE_INT:		
            		hasCountryOfIssue = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.STATEORPROVINCEOFISSUE_INT:		
            		hasStateOrProvinceOfIssue = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LOCALEOFISSUE_INT:		
            		hasLocaleOfIssue = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.REDEMPTIONDATE_INT:		
            		hasRedemptionDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.STRIKEPRICE_INT:		
            		hasStrikePrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.STRIKECURRENCY_INT:		
            		hasStrikeCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.STRIKEMULTIPLIER_INT:		
            		hasStrikeMultiplier = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.STRIKEVALUE_INT:		
            		hasStrikeValue = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.STRIKEPRICEDETERMINATIONMETHOD_INT:		
            		hasStrikePriceDeterminationMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.STRIKEPRICEBOUNDARYMETHOD_INT:		
            		hasStrikePriceBoundaryMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.STRIKEPRICEBOUNDARYPRECISION_INT:		
            		hasStrikePriceBoundaryPrecision = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGPRICEDETERMINATIONMETHOD_INT:		
            		hasUnderlyingPriceDeterminationMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.OPTATTRIBUTE_INT:		
            		hasOptAttribute = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CONTRACTMULTIPLIER_INT:		
            		hasContractMultiplier = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MINPRICEINCREMENT_INT:		
            		hasMinPriceIncrement = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNITOFMEASURE_INT:		
            		hasUnitOfMeasure = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.TIMEUNIT_INT:		
            		hasTimeUnit = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MINPRICEINCREMENTAMOUNT_INT:		
            		hasMinPriceIncrementAmount = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNITOFMEASUREQTY_INT:		
            		hasUnitOfMeasureQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PRICEUNITOFMEASURE_INT:		
            		hasPriceUnitOfMeasure = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PRICEUNITOFMEASUREQTY_INT:		
            		hasPriceUnitOfMeasureQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLMETHOD_INT:		
            		hasSettlMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.EXERCISESTYLE_INT:		
            		hasExerciseStyle = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.OPTPAYOUTAMOUNT_INT:		
            		hasOptPayoutAmount = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PRICEQUOTEMETHOD_INT:		
            		hasPriceQuoteMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LISTMETHOD_INT:		
            		hasListMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CAPPRICE_INT:		
            		hasCapPrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.FLOORPRICE_INT:		
            		hasFloorPrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PUTORCALL_INT:		
            		hasPutOrCall = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.FLEXIBLEINDICATOR_INT:		
            		hasFlexibleIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.FLEXPRODUCTELIGIBILITYINDICATOR_INT:		
            		hasFlexProductEligibilityIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.VALUATIONMETHOD_INT:		
            		hasValuationMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CONTRACTMULTIPLIERUNIT_INT:		
            		hasContractMultiplierUnit = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.FLOWSCHEDULETYPE_INT:		
            		hasFlowScheduleType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.OPTPAYOUTTYPE_INT:		
            		hasOptPayoutType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.COUPONRATE_INT:		
            		hasCouponRate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYEXCHANGE_INT:		
            		hasSecurityExchange = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.POSITIONLIMIT_INT:		
            		hasPositionLimit = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.NTPOSITIONLIMIT_INT:		
            		hasNTPositionLimit = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ISSUER_INT:		
            		hasIssuer = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDISSUERLEN_INT:		
            		hasEncodedIssuerLen = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDISSUER_INT:		
            		hasEncodedIssuer = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYDESC_INT:		
            		hasSecurityDesc = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDSECURITYDESCLEN_INT:		
            		hasEncodedSecurityDescLen = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDSECURITYDESC_INT:		
            		hasEncodedSecurityDesc = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.POOL_INT:		
            		hasPool = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CONTRACTSETTLMONTH_INT:		
            		hasContractSettlMonth = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CPPROGRAM_INT:		
            		hasCPProgram = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CPREGTYPE_INT:		
            		hasCPRegType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DATEDDATE_INT:		
            		hasDatedDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.INTERESTACCRUALDATE_INT:		
            		hasInterestAccrualDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOSECURITYALTID_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !secAltIDGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = secAltIDGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( securityXML.isKeyTag(tag)) {
        				tag = securityXML.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOEVENTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !evntGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = evntGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOINSTRUMENTPARTIES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrumentParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = instrumentParties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOCOMPLEXEVENTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !complexEvents[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = complexEvents[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
            }

            tag = FixUtils.getTag(buf, err);
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
		hasSymbol = FixUtils.TAG_HAS_NO_VALUE;
		hasSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasProduct = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityGroup = FixUtils.TAG_HAS_NO_VALUE;
		hasProductComplex = FixUtils.TAG_HAS_NO_VALUE;
		hasCFICode = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityType = FixUtils.TAG_HAS_NO_VALUE;
		hasSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;
		hasMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;
		hasMaturityDate = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityStatus = FixUtils.TAG_HAS_NO_VALUE;
		hasSettleOnOpenFlag = FixUtils.TAG_HAS_NO_VALUE;
		hasInstrmtAssignmentMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasMaturityTime = FixUtils.TAG_HAS_NO_VALUE;
		hasCouponPaymentDate = FixUtils.TAG_HAS_NO_VALUE;
		hasRestructuringType = FixUtils.TAG_HAS_NO_VALUE;
		hasSeniority = FixUtils.TAG_HAS_NO_VALUE;
		hasNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;
		hasOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;
		hasAttachmentPoint = FixUtils.TAG_HAS_NO_VALUE;
		hasDetachmentPoint = FixUtils.TAG_HAS_NO_VALUE;
		hasIssueDate = FixUtils.TAG_HAS_NO_VALUE;
		hasRepoCollateralSecurityType = FixUtils.TAG_HAS_NO_VALUE;
		hasRepurchaseTerm = FixUtils.TAG_HAS_NO_VALUE;
		hasRepurchaseRate = FixUtils.TAG_HAS_NO_VALUE;
		hasFactor = FixUtils.TAG_HAS_NO_VALUE;
		hasCreditRating = FixUtils.TAG_HAS_NO_VALUE;
		hasInstrRegistry = FixUtils.TAG_HAS_NO_VALUE;
		hasCountryOfIssue = FixUtils.TAG_HAS_NO_VALUE;
		hasStateOrProvinceOfIssue = FixUtils.TAG_HAS_NO_VALUE;
		hasLocaleOfIssue = FixUtils.TAG_HAS_NO_VALUE;
		hasRedemptionDate = FixUtils.TAG_HAS_NO_VALUE;
		hasStrikePrice = FixUtils.TAG_HAS_NO_VALUE;
		hasStrikeCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasStrikeMultiplier = FixUtils.TAG_HAS_NO_VALUE;
		hasStrikeValue = FixUtils.TAG_HAS_NO_VALUE;
		hasStrikePriceDeterminationMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasStrikePriceBoundaryMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasStrikePriceBoundaryPrecision = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingPriceDeterminationMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasOptAttribute = FixUtils.TAG_HAS_NO_VALUE;
		hasContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;
		hasMinPriceIncrement = FixUtils.TAG_HAS_NO_VALUE;
		hasUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;
		hasTimeUnit = FixUtils.TAG_HAS_NO_VALUE;
		hasMinPriceIncrementAmount = FixUtils.TAG_HAS_NO_VALUE;
		hasUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;
		hasPriceUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;
		hasPriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;
		hasOptPayoutAmount = FixUtils.TAG_HAS_NO_VALUE;
		hasPriceQuoteMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasListMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasCapPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasFloorPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasPutOrCall = FixUtils.TAG_HAS_NO_VALUE;
		hasFlexibleIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasFlexProductEligibilityIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasValuationMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;
		hasFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;
		hasOptPayoutType = FixUtils.TAG_HAS_NO_VALUE;
		hasCouponRate = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;
		hasPositionLimit = FixUtils.TAG_HAS_NO_VALUE;
		hasNTPositionLimit = FixUtils.TAG_HAS_NO_VALUE;
		hasIssuer = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedIssuerLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedIssuer = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasPool = FixUtils.TAG_HAS_NO_VALUE;
		hasContractSettlMonth = FixUtils.TAG_HAS_NO_VALUE;
		hasCPProgram = FixUtils.TAG_HAS_NO_VALUE;
		hasCPRegType = FixUtils.TAG_HAS_NO_VALUE;
		hasDatedDate = FixUtils.TAG_HAS_NO_VALUE;
		hasInterestAccrualDate = FixUtils.TAG_HAS_NO_VALUE;
		for (FixSecAltIDGrp fixSecAltIDGrp : secAltIDGrp) fixSecAltIDGrp.clear();
		securityXML.clear();
		for (FixEvntGrp fixEvntGrp : evntGrp) fixEvntGrp.clear();
		for (FixInstrumentParties fixInstrumentParties : instrumentParties) fixInstrumentParties.clear();
		for (FixComplexEvents fixComplexEvents : complexEvents) fixComplexEvents.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSymbol()) {		
			out.put(FixTags.SYMBOL);

			out.put((byte) '=');

			FixUtils.put(out,symbol); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSymbolSfx()) {		
			out.put(FixTags.SYMBOLSFX);

			out.put((byte) '=');

			FixUtils.put(out,symbolSfx); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecurityID()) {		
			out.put(FixTags.SECURITYID);

			out.put((byte) '=');

			FixUtils.put(out,securityID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecurityIDSource()) {		
			out.put(FixTags.SECURITYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,securityIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasProduct()) {		
			out.put(FixTags.PRODUCT);

			out.put((byte) '=');

			FixUtils.put(out, (long)product);
		
			out.put(FixUtils.SOH);

            }

		if (hasSecurityGroup()) {		
			out.put(FixTags.SECURITYGROUP);

			out.put((byte) '=');

			FixUtils.put(out,securityGroup); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasProductComplex()) {		
			out.put(FixTags.PRODUCTCOMPLEX);

			out.put((byte) '=');

			FixUtils.put(out,productComplex); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCFICode()) {		
			out.put(FixTags.CFICODE);

			out.put((byte) '=');

			FixUtils.put(out,cFICode); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecurityType()) {		
			out.put(FixTags.SECURITYTYPE);

			out.put((byte) '=');

			FixUtils.put(out,securityType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecuritySubType()) {		
			out.put(FixTags.SECURITYSUBTYPE);

			out.put((byte) '=');

			FixUtils.put(out,securitySubType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMaturityMonthYear()) {		
			out.put(FixTags.MATURITYMONTHYEAR);

			out.put((byte) '=');

			FixUtils.put(out,maturityMonthYear); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMaturityDate()) {		
			out.put(FixTags.MATURITYDATE);

			out.put((byte) '=');

			FixUtils.put(out,maturityDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecurityStatus()) {		
			out.put(FixTags.SECURITYSTATUS);

			out.put((byte) '=');

			FixUtils.put(out,securityStatus); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettleOnOpenFlag()) {		
			out.put(FixTags.SETTLEONOPENFLAG);

			out.put((byte) '=');

			FixUtils.put(out,settleOnOpenFlag); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasInstrmtAssignmentMethod()) {		
			out.put(FixTags.INSTRMTASSIGNMENTMETHOD);

			out.put((byte) '=');

			FixUtils.put(out,instrmtAssignmentMethod); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMaturityTime()) {		
			out.put(FixTags.MATURITYTIME);

			out.put((byte) '=');

			FixUtils.put(out,maturityTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCouponPaymentDate()) {		
			out.put(FixTags.COUPONPAYMENTDATE);

			out.put((byte) '=');

			FixUtils.put(out,couponPaymentDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRestructuringType()) {		
			out.put(FixTags.RESTRUCTURINGTYPE);

			out.put((byte) '=');

			FixUtils.put(out,restructuringType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSeniority()) {		
			out.put(FixTags.SENIORITY);

			out.put((byte) '=');

			FixUtils.put(out,seniority); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNotionalPercentageOutstanding()) {		
			out.put(FixTags.NOTIONALPERCENTAGEOUTSTANDING);

			out.put((byte) '=');

			FixUtils.put(out, (long)notionalPercentageOutstanding);
		
			out.put(FixUtils.SOH);

            }

		if (hasOriginalNotionalPercentageOutstanding()) {		
			out.put(FixTags.ORIGINALNOTIONALPERCENTAGEOUTSTANDING);

			out.put((byte) '=');

			FixUtils.put(out, (long)originalNotionalPercentageOutstanding);
		
			out.put(FixUtils.SOH);

            }

		if (hasAttachmentPoint()) {		
			out.put(FixTags.ATTACHMENTPOINT);

			out.put((byte) '=');

			FixUtils.put(out, (long)attachmentPoint);
		
			out.put(FixUtils.SOH);

            }

		if (hasDetachmentPoint()) {		
			out.put(FixTags.DETACHMENTPOINT);

			out.put((byte) '=');

			FixUtils.put(out, (long)detachmentPoint);
		
			out.put(FixUtils.SOH);

            }

		if (hasIssueDate()) {		
			out.put(FixTags.ISSUEDATE);

			out.put((byte) '=');

			FixUtils.put(out,issueDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRepoCollateralSecurityType()) {		
			out.put(FixTags.REPOCOLLATERALSECURITYTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)repoCollateralSecurityType);
		
			out.put(FixUtils.SOH);

            }

		if (hasRepurchaseTerm()) {		
			out.put(FixTags.REPURCHASETERM);

			out.put((byte) '=');

			FixUtils.put(out, (long)repurchaseTerm);
		
			out.put(FixUtils.SOH);

            }

		if (hasRepurchaseRate()) {		
			out.put(FixTags.REPURCHASERATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)repurchaseRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasFactor()) {		
			out.put(FixTags.FACTOR);

			out.put((byte) '=');

			FixUtils.put(out, (long)factor);
		
			out.put(FixUtils.SOH);

            }

		if (hasCreditRating()) {		
			out.put(FixTags.CREDITRATING);

			out.put((byte) '=');

			FixUtils.put(out,creditRating); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasInstrRegistry()) {		
			out.put(FixTags.INSTRREGISTRY);

			out.put((byte) '=');

			FixUtils.put(out,instrRegistry); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCountryOfIssue()) {		
			out.put(FixTags.COUNTRYOFISSUE);

			out.put((byte) '=');

			FixUtils.put(out,countryOfIssue); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasStateOrProvinceOfIssue()) {		
			out.put(FixTags.STATEORPROVINCEOFISSUE);

			out.put((byte) '=');

			FixUtils.put(out,stateOrProvinceOfIssue); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLocaleOfIssue()) {		
			out.put(FixTags.LOCALEOFISSUE);

			out.put((byte) '=');

			FixUtils.put(out,localeOfIssue); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRedemptionDate()) {		
			out.put(FixTags.REDEMPTIONDATE);

			out.put((byte) '=');

			FixUtils.put(out,redemptionDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasStrikePrice()) {		
			out.put(FixTags.STRIKEPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)strikePrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasStrikeCurrency()) {		
			out.put(FixTags.STRIKECURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,strikeCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasStrikeMultiplier()) {		
			out.put(FixTags.STRIKEMULTIPLIER);

			out.put((byte) '=');

			FixUtils.put(out, (long)strikeMultiplier);
		
			out.put(FixUtils.SOH);

            }

		if (hasStrikeValue()) {		
			out.put(FixTags.STRIKEVALUE);

			out.put((byte) '=');

			FixUtils.put(out, (long)strikeValue);
		
			out.put(FixUtils.SOH);

            }

		if (hasStrikePriceDeterminationMethod()) {		
			out.put(FixTags.STRIKEPRICEDETERMINATIONMETHOD);

			out.put((byte) '=');

			FixUtils.put(out, (long)strikePriceDeterminationMethod);
		
			out.put(FixUtils.SOH);

            }

		if (hasStrikePriceBoundaryMethod()) {		
			out.put(FixTags.STRIKEPRICEBOUNDARYMETHOD);

			out.put((byte) '=');

			FixUtils.put(out, (long)strikePriceBoundaryMethod);
		
			out.put(FixUtils.SOH);

            }

		if (hasStrikePriceBoundaryPrecision()) {		
			out.put(FixTags.STRIKEPRICEBOUNDARYPRECISION);

			out.put((byte) '=');

			FixUtils.put(out, (long)strikePriceBoundaryPrecision);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingPriceDeterminationMethod()) {		
			out.put(FixTags.UNDERLYINGPRICEDETERMINATIONMETHOD);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingPriceDeterminationMethod);
		
			out.put(FixUtils.SOH);

            }

		if (hasOptAttribute()) {		
			out.put(FixTags.OPTATTRIBUTE);

			out.put((byte) '=');

			FixUtils.put(out,optAttribute); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasContractMultiplier()) {		
			out.put(FixTags.CONTRACTMULTIPLIER);

			out.put((byte) '=');

			FixUtils.put(out, (long)contractMultiplier);
		
			out.put(FixUtils.SOH);

            }

		if (hasMinPriceIncrement()) {		
			out.put(FixTags.MINPRICEINCREMENT);

			out.put((byte) '=');

			FixUtils.put(out, (long)minPriceIncrement);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnitOfMeasure()) {		
			out.put(FixTags.UNITOFMEASURE);

			out.put((byte) '=');

			FixUtils.put(out,unitOfMeasure); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTimeUnit()) {		
			out.put(FixTags.TIMEUNIT);

			out.put((byte) '=');

			FixUtils.put(out,timeUnit); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMinPriceIncrementAmount()) {		
			out.put(FixTags.MINPRICEINCREMENTAMOUNT);

			out.put((byte) '=');

			FixUtils.put(out, (long)minPriceIncrementAmount);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnitOfMeasureQty()) {		
			out.put(FixTags.UNITOFMEASUREQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)unitOfMeasureQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasPriceUnitOfMeasure()) {		
			out.put(FixTags.PRICEUNITOFMEASURE);

			out.put((byte) '=');

			FixUtils.put(out,priceUnitOfMeasure); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPriceUnitOfMeasureQty()) {		
			out.put(FixTags.PRICEUNITOFMEASUREQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)priceUnitOfMeasureQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlMethod()) {		
			out.put(FixTags.SETTLMETHOD);

			out.put((byte) '=');

			FixUtils.put(out,settlMethod); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasExerciseStyle()) {		
			out.put(FixTags.EXERCISESTYLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)exerciseStyle);
		
			out.put(FixUtils.SOH);

            }

		if (hasOptPayoutAmount()) {		
			out.put(FixTags.OPTPAYOUTAMOUNT);

			out.put((byte) '=');

			FixUtils.put(out, (long)optPayoutAmount);
		
			out.put(FixUtils.SOH);

            }

		if (hasPriceQuoteMethod()) {		
			out.put(FixTags.PRICEQUOTEMETHOD);

			out.put((byte) '=');

			FixUtils.put(out,priceQuoteMethod); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasListMethod()) {		
			out.put(FixTags.LISTMETHOD);

			out.put((byte) '=');

			FixUtils.put(out, (long)listMethod);
		
			out.put(FixUtils.SOH);

            }

		if (hasCapPrice()) {		
			out.put(FixTags.CAPPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)capPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasFloorPrice()) {		
			out.put(FixTags.FLOORPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)floorPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasPutOrCall()) {		
			out.put(FixTags.PUTORCALL);

			out.put((byte) '=');

			FixUtils.put(out, (long)putOrCall);
		
			out.put(FixUtils.SOH);

            }

		if (hasFlexibleIndicator()) {		
			out.put(FixTags.FLEXIBLEINDICATOR);

			out.put((byte) '=');

			out.put(flexibleIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasFlexProductEligibilityIndicator()) {		
			out.put(FixTags.FLEXPRODUCTELIGIBILITYINDICATOR);

			out.put((byte) '=');

			out.put(flexProductEligibilityIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasValuationMethod()) {		
			out.put(FixTags.VALUATIONMETHOD);

			out.put((byte) '=');

			FixUtils.put(out,valuationMethod); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasContractMultiplierUnit()) {		
			out.put(FixTags.CONTRACTMULTIPLIERUNIT);

			out.put((byte) '=');

			FixUtils.put(out, (long)contractMultiplierUnit);
		
			out.put(FixUtils.SOH);

            }

		if (hasFlowScheduleType()) {		
			out.put(FixTags.FLOWSCHEDULETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)flowScheduleType);
		
			out.put(FixUtils.SOH);

            }

		if (hasOptPayoutType()) {		
			out.put(FixTags.OPTPAYOUTTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)optPayoutType);
		
			out.put(FixUtils.SOH);

            }

		if (hasCouponRate()) {		
			out.put(FixTags.COUPONRATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)couponRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasSecurityExchange()) {		
			out.put(FixTags.SECURITYEXCHANGE);

			out.put((byte) '=');

			FixUtils.put(out,securityExchange); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPositionLimit()) {		
			out.put(FixTags.POSITIONLIMIT);

			out.put((byte) '=');

			FixUtils.put(out, (long)positionLimit);
		
			out.put(FixUtils.SOH);

            }

		if (hasNTPositionLimit()) {		
			out.put(FixTags.NTPOSITIONLIMIT);

			out.put((byte) '=');

			FixUtils.put(out, (long)nTPositionLimit);
		
			out.put(FixUtils.SOH);

            }

		if (hasIssuer()) {		
			out.put(FixTags.ISSUER);

			out.put((byte) '=');

			FixUtils.put(out,issuer); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedIssuerLen()) {		
			out.put(FixTags.ENCODEDISSUERLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)encodedIssuerLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedIssuer()) {		
			out.put(FixTags.ENCODEDISSUER);

			out.put((byte) '=');

			FixUtils.put(out,encodedIssuer); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecurityDesc()) {		
			out.put(FixTags.SECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,securityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedSecurityDescLen()) {		
			out.put(FixTags.ENCODEDSECURITYDESCLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)encodedSecurityDescLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedSecurityDesc()) {		
			out.put(FixTags.ENCODEDSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,encodedSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPool()) {		
			out.put(FixTags.POOL);

			out.put((byte) '=');

			FixUtils.put(out,pool); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasContractSettlMonth()) {		
			out.put(FixTags.CONTRACTSETTLMONTH);

			out.put((byte) '=');

			FixUtils.put(out,contractSettlMonth); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCPProgram()) {		
			out.put(FixTags.CPPROGRAM);

			out.put((byte) '=');

			FixUtils.put(out, (long)cPProgram);
		
			out.put(FixUtils.SOH);

            }

		if (hasCPRegType()) {		
			out.put(FixTags.CPREGTYPE);

			out.put((byte) '=');

			FixUtils.put(out,cPRegType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDatedDate()) {		
			out.put(FixTags.DATEDDATE);

			out.put((byte) '=');

			FixUtils.put(out,datedDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasInterestAccrualDate()) {		
			out.put(FixTags.INTERESTACCRUALDATE);

			out.put((byte) '=');

			FixUtils.put(out,interestAccrualDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(secAltIDGrp)>0) {
			out.put(FixTags.NOSECURITYALTID);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(secAltIDGrp));

			out.put(FixUtils.SOH);

		}
		for (FixSecAltIDGrp fixSecAltIDGrp : secAltIDGrp) if (fixSecAltIDGrp.hasGroup()) fixSecAltIDGrp.encode(out);
		securityXML.encode(out);
		if (FixUtils.getNoInGroup(evntGrp)>0) {
			out.put(FixTags.NOEVENTS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(evntGrp));

			out.put(FixUtils.SOH);

		}
		for (FixEvntGrp fixEvntGrp : evntGrp) if (fixEvntGrp.hasGroup()) fixEvntGrp.encode(out);
		if (FixUtils.getNoInGroup(instrumentParties)>0) {
			out.put(FixTags.NOINSTRUMENTPARTIES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrumentParties));

			out.put(FixUtils.SOH);

		}
		for (FixInstrumentParties fixInstrumentParties : instrumentParties) if (fixInstrumentParties.hasGroup()) fixInstrumentParties.encode(out);
		if (FixUtils.getNoInGroup(complexEvents)>0) {
			out.put(FixTags.NOCOMPLEXEVENTS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(complexEvents));

			out.put(FixUtils.SOH);

		}
		for (FixComplexEvents fixComplexEvents : complexEvents) if (fixComplexEvents.hasGroup()) fixComplexEvents.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSymbol()) {		
			FixUtils.put(out,symbol); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSymbolSfx()) {		
			FixUtils.put(out,symbolSfx); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityID()) {		
			FixUtils.put(out,securityID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityIDSource()) {		
			FixUtils.put(out,securityIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasProduct()) {		
			FixUtils.put(out, (long)product);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityGroup()) {		
			FixUtils.put(out,securityGroup); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasProductComplex()) {		
			FixUtils.put(out,productComplex); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCFICode()) {		
			FixUtils.put(out,cFICode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityType()) {		
			FixUtils.put(out,securityType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecuritySubType()) {		
			FixUtils.put(out,securitySubType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaturityMonthYear()) {		
			FixUtils.put(out,maturityMonthYear); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaturityDate()) {		
			FixUtils.put(out,maturityDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityStatus()) {		
			FixUtils.put(out,securityStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettleOnOpenFlag()) {		
			FixUtils.put(out,settleOnOpenFlag); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasInstrmtAssignmentMethod()) {		
			FixUtils.put(out,instrmtAssignmentMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaturityTime()) {		
			FixUtils.put(out,maturityTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCouponPaymentDate()) {		
			FixUtils.put(out,couponPaymentDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRestructuringType()) {		
			FixUtils.put(out,restructuringType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSeniority()) {		
			FixUtils.put(out,seniority); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNotionalPercentageOutstanding()) {		
			FixUtils.put(out, (long)notionalPercentageOutstanding);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOriginalNotionalPercentageOutstanding()) {		
			FixUtils.put(out, (long)originalNotionalPercentageOutstanding);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAttachmentPoint()) {		
			FixUtils.put(out, (long)attachmentPoint);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDetachmentPoint()) {		
			FixUtils.put(out, (long)detachmentPoint);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIssueDate()) {		
			FixUtils.put(out,issueDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRepoCollateralSecurityType()) {		
			FixUtils.put(out, (long)repoCollateralSecurityType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRepurchaseTerm()) {		
			FixUtils.put(out, (long)repurchaseTerm);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRepurchaseRate()) {		
			FixUtils.put(out, (long)repurchaseRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFactor()) {		
			FixUtils.put(out, (long)factor);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCreditRating()) {		
			FixUtils.put(out,creditRating); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasInstrRegistry()) {		
			FixUtils.put(out,instrRegistry); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCountryOfIssue()) {		
			FixUtils.put(out,countryOfIssue); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStateOrProvinceOfIssue()) {		
			FixUtils.put(out,stateOrProvinceOfIssue); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLocaleOfIssue()) {		
			FixUtils.put(out,localeOfIssue); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRedemptionDate()) {		
			FixUtils.put(out,redemptionDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStrikePrice()) {		
			FixUtils.put(out, (long)strikePrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStrikeCurrency()) {		
			FixUtils.put(out,strikeCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStrikeMultiplier()) {		
			FixUtils.put(out, (long)strikeMultiplier);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStrikeValue()) {		
			FixUtils.put(out, (long)strikeValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStrikePriceDeterminationMethod()) {		
			FixUtils.put(out, (long)strikePriceDeterminationMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStrikePriceBoundaryMethod()) {		
			FixUtils.put(out, (long)strikePriceBoundaryMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStrikePriceBoundaryPrecision()) {		
			FixUtils.put(out, (long)strikePriceBoundaryPrecision);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingPriceDeterminationMethod()) {		
			FixUtils.put(out, (long)underlyingPriceDeterminationMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOptAttribute()) {		
			FixUtils.put(out,optAttribute); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContractMultiplier()) {		
			FixUtils.put(out, (long)contractMultiplier);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMinPriceIncrement()) {		
			FixUtils.put(out, (long)minPriceIncrement);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnitOfMeasure()) {		
			FixUtils.put(out,unitOfMeasure); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTimeUnit()) {		
			FixUtils.put(out,timeUnit); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMinPriceIncrementAmount()) {		
			FixUtils.put(out, (long)minPriceIncrementAmount);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnitOfMeasureQty()) {		
			FixUtils.put(out, (long)unitOfMeasureQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceUnitOfMeasure()) {		
			FixUtils.put(out,priceUnitOfMeasure); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceUnitOfMeasureQty()) {		
			FixUtils.put(out, (long)priceUnitOfMeasureQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlMethod()) {		
			FixUtils.put(out,settlMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExerciseStyle()) {		
			FixUtils.put(out, (long)exerciseStyle);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOptPayoutAmount()) {		
			FixUtils.put(out, (long)optPayoutAmount);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceQuoteMethod()) {		
			FixUtils.put(out,priceQuoteMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasListMethod()) {		
			FixUtils.put(out, (long)listMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCapPrice()) {		
			FixUtils.put(out, (long)capPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFloorPrice()) {		
			FixUtils.put(out, (long)floorPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPutOrCall()) {		
			FixUtils.put(out, (long)putOrCall);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFlexibleIndicator()) {		
			out.put(flexibleIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFlexProductEligibilityIndicator()) {		
			out.put(flexProductEligibilityIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasValuationMethod()) {		
			FixUtils.put(out,valuationMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContractMultiplierUnit()) {		
			FixUtils.put(out, (long)contractMultiplierUnit);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFlowScheduleType()) {		
			FixUtils.put(out, (long)flowScheduleType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOptPayoutType()) {		
			FixUtils.put(out, (long)optPayoutType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCouponRate()) {		
			FixUtils.put(out, (long)couponRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityExchange()) {		
			FixUtils.put(out,securityExchange); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPositionLimit()) {		
			FixUtils.put(out, (long)positionLimit);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNTPositionLimit()) {		
			FixUtils.put(out, (long)nTPositionLimit);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIssuer()) {		
			FixUtils.put(out,issuer); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedIssuerLen()) {		
			FixUtils.put(out, (long)encodedIssuerLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedIssuer()) {		
			FixUtils.put(out,encodedIssuer); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityDesc()) {		
			FixUtils.put(out,securityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedSecurityDescLen()) {		
			FixUtils.put(out, (long)encodedSecurityDescLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedSecurityDesc()) {		
			FixUtils.put(out,encodedSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPool()) {		
			FixUtils.put(out,pool); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContractSettlMonth()) {		
			FixUtils.put(out,contractSettlMonth); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCPProgram()) {		
			FixUtils.put(out, (long)cPProgram);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCPRegType()) {		
			FixUtils.put(out,cPRegType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDatedDate()) {		
			FixUtils.put(out,datedDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasInterestAccrualDate()) {		
			FixUtils.put(out,interestAccrualDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixSecAltIDGrp fixSecAltIDGrp : secAltIDGrp) fixSecAltIDGrp.printBuffer(out);
		securityXML.printBuffer(out);
		for (FixEvntGrp fixEvntGrp : evntGrp) fixEvntGrp.printBuffer(out);
		for (FixInstrumentParties fixInstrumentParties : instrumentParties) fixInstrumentParties.printBuffer(out);
		for (FixComplexEvents fixComplexEvents : complexEvents) fixComplexEvents.printBuffer(out);
	}

	public byte[] getSymbol() { 		
		if ( hasSymbol()) {		
			if (hasSymbol == FixUtils.TAG_HAS_VALUE) {		
				return symbol; 		
			} else {		
		
				buf.position(hasSymbol);		
		
			FixUtils.getTagStringValue(buf, symbol, 0, symbol.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSymbol);		
					return null;		
				}		
			}		
			hasSymbol = FixUtils.TAG_HAS_VALUE;		
			return symbol;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSymbol() { return hasSymbol != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSymbol(byte[] src) {		
		if (src == null ) return;
		if (hasSymbol()) FixUtils.fillNul(symbol);		
		FixUtils.copy(symbol, src); 		
		hasSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSymbol(String str) {		
		if (str == null ) return;
		if (hasSymbol()) FixUtils.fillNul(symbol);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(symbol, src); 		
		hasSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSymbolSfx() { 		
		if ( hasSymbolSfx()) {		
			if (hasSymbolSfx == FixUtils.TAG_HAS_VALUE) {		
				return symbolSfx; 		
			} else {		
		
				buf.position(hasSymbolSfx);		
		
			FixUtils.getTagStringValue(buf, symbolSfx, 0, symbolSfx.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSymbolSfx);		
					return null;		
				}		
			}		
			hasSymbolSfx = FixUtils.TAG_HAS_VALUE;		
			return symbolSfx;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSymbolSfx() { return hasSymbolSfx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSymbolSfx(byte[] src) {		
		if (src == null ) return;
		if (hasSymbolSfx()) FixUtils.fillNul(symbolSfx);		
		FixUtils.copy(symbolSfx, src); 		
		hasSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSymbolSfx(String str) {		
		if (str == null ) return;
		if (hasSymbolSfx()) FixUtils.fillNul(symbolSfx);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(symbolSfx, src); 		
		hasSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecurityID() { 		
		if ( hasSecurityID()) {		
			if (hasSecurityID == FixUtils.TAG_HAS_VALUE) {		
				return securityID; 		
			} else {		
		
				buf.position(hasSecurityID);		
		
			FixUtils.getTagStringValue(buf, securityID, 0, securityID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityID);		
					return null;		
				}		
			}		
			hasSecurityID = FixUtils.TAG_HAS_VALUE;		
			return securityID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityID() { return hasSecurityID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityID(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityID()) FixUtils.fillNul(securityID);		
		FixUtils.copy(securityID, src); 		
		hasSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityID(String str) {		
		if (str == null ) return;
		if (hasSecurityID()) FixUtils.fillNul(securityID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityID, src); 		
		hasSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecurityIDSource() { 		
		if ( hasSecurityIDSource()) {		
			if (hasSecurityIDSource == FixUtils.TAG_HAS_VALUE) {		
				return securityIDSource; 		
			} else {		
		
				buf.position(hasSecurityIDSource);		
		
			FixUtils.getTagStringValue(buf, securityIDSource, 0, securityIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityIDSource);		
					return null;		
				}		
			}		
			hasSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
			return securityIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityIDSource() { return hasSecurityIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityIDSource()) FixUtils.fillNul(securityIDSource);		
		FixUtils.copy(securityIDSource, src); 		
		hasSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityIDSource(String str) {		
		if (str == null ) return;
		if (hasSecurityIDSource()) FixUtils.fillNul(securityIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityIDSource, src); 		
		hasSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getProduct() { 		
		if ( hasProduct()) {		
			if (hasProduct == FixUtils.TAG_HAS_VALUE) {		
				return product; 		
			} else {		
		
				buf.position(hasProduct);		
		
			product = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasProduct);		
					return 0;		
				}		
			}		
			hasProduct = FixUtils.TAG_HAS_VALUE;		
			return product;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasProduct() { return hasProduct != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setProduct(long src) {		
		product = src;
		hasProduct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProduct(byte[] src) {		
		if (src == null ) return;
		if (hasProduct()) product = FixUtils.TAG_HAS_NO_VALUE;		
		product = FixUtils.longValueOf(src, 0, src.length);
		hasProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setProduct(String str) {		
		if (str == null ) return;
		if (hasProduct()) product = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		product = FixUtils.longValueOf(src, 0, src.length);
		hasProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecurityGroup() { 		
		if ( hasSecurityGroup()) {		
			if (hasSecurityGroup == FixUtils.TAG_HAS_VALUE) {		
				return securityGroup; 		
			} else {		
		
				buf.position(hasSecurityGroup);		
		
			FixUtils.getTagStringValue(buf, securityGroup, 0, securityGroup.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityGroup);		
					return null;		
				}		
			}		
			hasSecurityGroup = FixUtils.TAG_HAS_VALUE;		
			return securityGroup;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityGroup() { return hasSecurityGroup != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityGroup(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityGroup()) FixUtils.fillNul(securityGroup);		
		FixUtils.copy(securityGroup, src); 		
		hasSecurityGroup = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityGroup(String str) {		
		if (str == null ) return;
		if (hasSecurityGroup()) FixUtils.fillNul(securityGroup);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityGroup, src); 		
		hasSecurityGroup = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getProductComplex() { 		
		if ( hasProductComplex()) {		
			if (hasProductComplex == FixUtils.TAG_HAS_VALUE) {		
				return productComplex; 		
			} else {		
		
				buf.position(hasProductComplex);		
		
			FixUtils.getTagStringValue(buf, productComplex, 0, productComplex.length, err);
		
				if (err.hasError()) {		
					buf.position(hasProductComplex);		
					return null;		
				}		
			}		
			hasProductComplex = FixUtils.TAG_HAS_VALUE;		
			return productComplex;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasProductComplex() { return hasProductComplex != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setProductComplex(byte[] src) {		
		if (src == null ) return;
		if (hasProductComplex()) FixUtils.fillNul(productComplex);		
		FixUtils.copy(productComplex, src); 		
		hasProductComplex = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setProductComplex(String str) {		
		if (str == null ) return;
		if (hasProductComplex()) FixUtils.fillNul(productComplex);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(productComplex, src); 		
		hasProductComplex = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCFICode() { 		
		if ( hasCFICode()) {		
			if (hasCFICode == FixUtils.TAG_HAS_VALUE) {		
				return cFICode; 		
			} else {		
		
				buf.position(hasCFICode);		
		
			FixUtils.getTagStringValue(buf, cFICode, 0, cFICode.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCFICode);		
					return null;		
				}		
			}		
			hasCFICode = FixUtils.TAG_HAS_VALUE;		
			return cFICode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCFICode() { return hasCFICode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCFICode(byte[] src) {		
		if (src == null ) return;
		if (hasCFICode()) FixUtils.fillNul(cFICode);		
		FixUtils.copy(cFICode, src); 		
		hasCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCFICode(String str) {		
		if (str == null ) return;
		if (hasCFICode()) FixUtils.fillNul(cFICode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cFICode, src); 		
		hasCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecurityType() { 		
		if ( hasSecurityType()) {		
			if (hasSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return securityType; 		
			} else {		
		
				buf.position(hasSecurityType);		
		
			FixUtils.getTagStringValue(buf, securityType, 0, securityType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityType);		
					return null;		
				}		
			}		
			hasSecurityType = FixUtils.TAG_HAS_VALUE;		
			return securityType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityType() { return hasSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityType()) FixUtils.fillNul(securityType);		
		FixUtils.copy(securityType, src); 		
		hasSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityType(String str) {		
		if (str == null ) return;
		if (hasSecurityType()) FixUtils.fillNul(securityType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityType, src); 		
		hasSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecuritySubType() { 		
		if ( hasSecuritySubType()) {		
			if (hasSecuritySubType == FixUtils.TAG_HAS_VALUE) {		
				return securitySubType; 		
			} else {		
		
				buf.position(hasSecuritySubType);		
		
			FixUtils.getTagStringValue(buf, securitySubType, 0, securitySubType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecuritySubType);		
					return null;		
				}		
			}		
			hasSecuritySubType = FixUtils.TAG_HAS_VALUE;		
			return securitySubType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecuritySubType() { return hasSecuritySubType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecuritySubType(byte[] src) {		
		if (src == null ) return;
		if (hasSecuritySubType()) FixUtils.fillNul(securitySubType);		
		FixUtils.copy(securitySubType, src); 		
		hasSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecuritySubType(String str) {		
		if (str == null ) return;
		if (hasSecuritySubType()) FixUtils.fillNul(securitySubType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securitySubType, src); 		
		hasSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMaturityMonthYear() { 		
		if ( hasMaturityMonthYear()) {		
			if (hasMaturityMonthYear == FixUtils.TAG_HAS_VALUE) {		
				return maturityMonthYear; 		
			} else {		
		
				buf.position(hasMaturityMonthYear);		
		
			FixUtils.getTagStringValue(buf, maturityMonthYear, 0, maturityMonthYear.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMaturityMonthYear);		
					return null;		
				}		
			}		
			hasMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
			return maturityMonthYear;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMaturityMonthYear() { return hasMaturityMonthYear != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMaturityMonthYear(byte[] src) {		
		if (src == null ) return;
		if (hasMaturityMonthYear()) FixUtils.fillNul(maturityMonthYear);		
		FixUtils.copy(maturityMonthYear, src); 		
		hasMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMaturityMonthYear(String str) {		
		if (str == null ) return;
		if (hasMaturityMonthYear()) FixUtils.fillNul(maturityMonthYear);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(maturityMonthYear, src); 		
		hasMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMaturityDate() { 		
		if ( hasMaturityDate()) {		
			if (hasMaturityDate == FixUtils.TAG_HAS_VALUE) {		
				return maturityDate; 		
			} else {		
		
				buf.position(hasMaturityDate);		
		
			FixUtils.getTagStringValue(buf, maturityDate, 0, maturityDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMaturityDate);		
					return null;		
				}		
			}		
			hasMaturityDate = FixUtils.TAG_HAS_VALUE;		
			return maturityDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMaturityDate() { return hasMaturityDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMaturityDate(byte[] src) {		
		if (src == null ) return;
		if (hasMaturityDate()) FixUtils.fillNul(maturityDate);		
		FixUtils.copy(maturityDate, src); 		
		hasMaturityDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMaturityDate(String str) {		
		if (str == null ) return;
		if (hasMaturityDate()) FixUtils.fillNul(maturityDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(maturityDate, src); 		
		hasMaturityDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecurityStatus() { 		
		if ( hasSecurityStatus()) {		
			if (hasSecurityStatus == FixUtils.TAG_HAS_VALUE) {		
				return securityStatus; 		
			} else {		
		
				buf.position(hasSecurityStatus);		
		
			FixUtils.getTagStringValue(buf, securityStatus, 0, securityStatus.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityStatus);		
					return null;		
				}		
			}		
			hasSecurityStatus = FixUtils.TAG_HAS_VALUE;		
			return securityStatus;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityStatus() { return hasSecurityStatus != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityStatus(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityStatus()) FixUtils.fillNul(securityStatus);		
		FixUtils.copy(securityStatus, src); 		
		hasSecurityStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityStatus(String str) {		
		if (str == null ) return;
		if (hasSecurityStatus()) FixUtils.fillNul(securityStatus);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityStatus, src); 		
		hasSecurityStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSettleOnOpenFlag() { 		
		if ( hasSettleOnOpenFlag()) {		
			if (hasSettleOnOpenFlag == FixUtils.TAG_HAS_VALUE) {		
				return settleOnOpenFlag; 		
			} else {		
		
				buf.position(hasSettleOnOpenFlag);		
		
			FixUtils.getTagStringValue(buf, settleOnOpenFlag, 0, settleOnOpenFlag.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettleOnOpenFlag);		
					return null;		
				}		
			}		
			hasSettleOnOpenFlag = FixUtils.TAG_HAS_VALUE;		
			return settleOnOpenFlag;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettleOnOpenFlag() { return hasSettleOnOpenFlag != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettleOnOpenFlag(byte[] src) {		
		if (src == null ) return;
		if (hasSettleOnOpenFlag()) FixUtils.fillNul(settleOnOpenFlag);		
		FixUtils.copy(settleOnOpenFlag, src); 		
		hasSettleOnOpenFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettleOnOpenFlag(String str) {		
		if (str == null ) return;
		if (hasSettleOnOpenFlag()) FixUtils.fillNul(settleOnOpenFlag);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settleOnOpenFlag, src); 		
		hasSettleOnOpenFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getInstrmtAssignmentMethod() { 		
		if ( hasInstrmtAssignmentMethod()) {		
			if (hasInstrmtAssignmentMethod == FixUtils.TAG_HAS_VALUE) {		
				return instrmtAssignmentMethod; 		
			} else {		
		
				buf.position(hasInstrmtAssignmentMethod);		
		
			instrmtAssignmentMethod = FixUtils.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasInstrmtAssignmentMethod);		
					return (byte)'0';		
				}		
			}		
			hasInstrmtAssignmentMethod = FixUtils.TAG_HAS_VALUE;		
			return instrmtAssignmentMethod;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasInstrmtAssignmentMethod() { return hasInstrmtAssignmentMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setInstrmtAssignmentMethod(byte src) {		
		instrmtAssignmentMethod = src;
		hasInstrmtAssignmentMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setInstrmtAssignmentMethod(byte[] src) {		
		if (src == null ) return;
		if (hasInstrmtAssignmentMethod()) instrmtAssignmentMethod = (byte)' ';		
		instrmtAssignmentMethod = src[0];		
		hasInstrmtAssignmentMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setInstrmtAssignmentMethod(String str) {		
		if (str == null ) return;
		if (hasInstrmtAssignmentMethod()) instrmtAssignmentMethod = (byte)' ';		
		byte[] src = str.getBytes(); 		
		instrmtAssignmentMethod = src[0];		
		hasInstrmtAssignmentMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMaturityTime() { 		
		if ( hasMaturityTime()) {		
			if (hasMaturityTime == FixUtils.TAG_HAS_VALUE) {		
				return maturityTime; 		
			} else {		
		
				buf.position(hasMaturityTime);		
		
			FixUtils.getTagStringValue(buf, maturityTime, 0, maturityTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMaturityTime);		
					return null;		
				}		
			}		
			hasMaturityTime = FixUtils.TAG_HAS_VALUE;		
			return maturityTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMaturityTime() { return hasMaturityTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMaturityTime(byte[] src) {		
		if (src == null ) return;
		if (hasMaturityTime()) FixUtils.fillNul(maturityTime);		
		FixUtils.copy(maturityTime, src); 		
		hasMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMaturityTime(String str) {		
		if (str == null ) return;
		if (hasMaturityTime()) FixUtils.fillNul(maturityTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(maturityTime, src); 		
		hasMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCouponPaymentDate() { 		
		if ( hasCouponPaymentDate()) {		
			if (hasCouponPaymentDate == FixUtils.TAG_HAS_VALUE) {		
				return couponPaymentDate; 		
			} else {		
		
				buf.position(hasCouponPaymentDate);		
		
			FixUtils.getTagStringValue(buf, couponPaymentDate, 0, couponPaymentDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCouponPaymentDate);		
					return null;		
				}		
			}		
			hasCouponPaymentDate = FixUtils.TAG_HAS_VALUE;		
			return couponPaymentDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCouponPaymentDate() { return hasCouponPaymentDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCouponPaymentDate(byte[] src) {		
		if (src == null ) return;
		if (hasCouponPaymentDate()) FixUtils.fillNul(couponPaymentDate);		
		FixUtils.copy(couponPaymentDate, src); 		
		hasCouponPaymentDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCouponPaymentDate(String str) {		
		if (str == null ) return;
		if (hasCouponPaymentDate()) FixUtils.fillNul(couponPaymentDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(couponPaymentDate, src); 		
		hasCouponPaymentDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRestructuringType() { 		
		if ( hasRestructuringType()) {		
			if (hasRestructuringType == FixUtils.TAG_HAS_VALUE) {		
				return restructuringType; 		
			} else {		
		
				buf.position(hasRestructuringType);		
		
			FixUtils.getTagStringValue(buf, restructuringType, 0, restructuringType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRestructuringType);		
					return null;		
				}		
			}		
			hasRestructuringType = FixUtils.TAG_HAS_VALUE;		
			return restructuringType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRestructuringType() { return hasRestructuringType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRestructuringType(byte[] src) {		
		if (src == null ) return;
		if (hasRestructuringType()) FixUtils.fillNul(restructuringType);		
		FixUtils.copy(restructuringType, src); 		
		hasRestructuringType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRestructuringType(String str) {		
		if (str == null ) return;
		if (hasRestructuringType()) FixUtils.fillNul(restructuringType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(restructuringType, src); 		
		hasRestructuringType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSeniority() { 		
		if ( hasSeniority()) {		
			if (hasSeniority == FixUtils.TAG_HAS_VALUE) {		
				return seniority; 		
			} else {		
		
				buf.position(hasSeniority);		
		
			FixUtils.getTagStringValue(buf, seniority, 0, seniority.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSeniority);		
					return null;		
				}		
			}		
			hasSeniority = FixUtils.TAG_HAS_VALUE;		
			return seniority;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSeniority() { return hasSeniority != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSeniority(byte[] src) {		
		if (src == null ) return;
		if (hasSeniority()) FixUtils.fillNul(seniority);		
		FixUtils.copy(seniority, src); 		
		hasSeniority = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSeniority(String str) {		
		if (str == null ) return;
		if (hasSeniority()) FixUtils.fillNul(seniority);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(seniority, src); 		
		hasSeniority = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNotionalPercentageOutstanding() { 		
		if ( hasNotionalPercentageOutstanding()) {		
			if (hasNotionalPercentageOutstanding == FixUtils.TAG_HAS_VALUE) {		
				return notionalPercentageOutstanding; 		
			} else {		
		
				buf.position(hasNotionalPercentageOutstanding);		
		
			notionalPercentageOutstanding = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNotionalPercentageOutstanding);		
					return 0;		
				}		
			}		
			hasNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
			return notionalPercentageOutstanding;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNotionalPercentageOutstanding() { return hasNotionalPercentageOutstanding != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNotionalPercentageOutstanding(long src) {		
		notionalPercentageOutstanding = src;
		hasNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNotionalPercentageOutstanding(byte[] src) {		
		if (src == null ) return;
		if (hasNotionalPercentageOutstanding()) notionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		notionalPercentageOutstanding = FixUtils.longValueOf(src, 0, src.length);
		hasNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNotionalPercentageOutstanding(String str) {		
		if (str == null ) return;
		if (hasNotionalPercentageOutstanding()) notionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		notionalPercentageOutstanding = FixUtils.longValueOf(src, 0, src.length);
		hasNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOriginalNotionalPercentageOutstanding() { 		
		if ( hasOriginalNotionalPercentageOutstanding()) {		
			if (hasOriginalNotionalPercentageOutstanding == FixUtils.TAG_HAS_VALUE) {		
				return originalNotionalPercentageOutstanding; 		
			} else {		
		
				buf.position(hasOriginalNotionalPercentageOutstanding);		
		
			originalNotionalPercentageOutstanding = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOriginalNotionalPercentageOutstanding);		
					return 0;		
				}		
			}		
			hasOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
			return originalNotionalPercentageOutstanding;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOriginalNotionalPercentageOutstanding() { return hasOriginalNotionalPercentageOutstanding != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOriginalNotionalPercentageOutstanding(long src) {		
		originalNotionalPercentageOutstanding = src;
		hasOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOriginalNotionalPercentageOutstanding(byte[] src) {		
		if (src == null ) return;
		if (hasOriginalNotionalPercentageOutstanding()) originalNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		originalNotionalPercentageOutstanding = FixUtils.longValueOf(src, 0, src.length);
		hasOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOriginalNotionalPercentageOutstanding(String str) {		
		if (str == null ) return;
		if (hasOriginalNotionalPercentageOutstanding()) originalNotionalPercentageOutstanding = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		originalNotionalPercentageOutstanding = FixUtils.longValueOf(src, 0, src.length);
		hasOriginalNotionalPercentageOutstanding = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAttachmentPoint() { 		
		if ( hasAttachmentPoint()) {		
			if (hasAttachmentPoint == FixUtils.TAG_HAS_VALUE) {		
				return attachmentPoint; 		
			} else {		
		
				buf.position(hasAttachmentPoint);		
		
			attachmentPoint = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAttachmentPoint);		
					return 0;		
				}		
			}		
			hasAttachmentPoint = FixUtils.TAG_HAS_VALUE;		
			return attachmentPoint;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAttachmentPoint() { return hasAttachmentPoint != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAttachmentPoint(long src) {		
		attachmentPoint = src;
		hasAttachmentPoint = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAttachmentPoint(byte[] src) {		
		if (src == null ) return;
		if (hasAttachmentPoint()) attachmentPoint = FixUtils.TAG_HAS_NO_VALUE;		
		attachmentPoint = FixUtils.longValueOf(src, 0, src.length);
		hasAttachmentPoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAttachmentPoint(String str) {		
		if (str == null ) return;
		if (hasAttachmentPoint()) attachmentPoint = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		attachmentPoint = FixUtils.longValueOf(src, 0, src.length);
		hasAttachmentPoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDetachmentPoint() { 		
		if ( hasDetachmentPoint()) {		
			if (hasDetachmentPoint == FixUtils.TAG_HAS_VALUE) {		
				return detachmentPoint; 		
			} else {		
		
				buf.position(hasDetachmentPoint);		
		
			detachmentPoint = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDetachmentPoint);		
					return 0;		
				}		
			}		
			hasDetachmentPoint = FixUtils.TAG_HAS_VALUE;		
			return detachmentPoint;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDetachmentPoint() { return hasDetachmentPoint != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDetachmentPoint(long src) {		
		detachmentPoint = src;
		hasDetachmentPoint = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDetachmentPoint(byte[] src) {		
		if (src == null ) return;
		if (hasDetachmentPoint()) detachmentPoint = FixUtils.TAG_HAS_NO_VALUE;		
		detachmentPoint = FixUtils.longValueOf(src, 0, src.length);
		hasDetachmentPoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDetachmentPoint(String str) {		
		if (str == null ) return;
		if (hasDetachmentPoint()) detachmentPoint = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		detachmentPoint = FixUtils.longValueOf(src, 0, src.length);
		hasDetachmentPoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getIssueDate() { 		
		if ( hasIssueDate()) {		
			if (hasIssueDate == FixUtils.TAG_HAS_VALUE) {		
				return issueDate; 		
			} else {		
		
				buf.position(hasIssueDate);		
		
			FixUtils.getTagStringValue(buf, issueDate, 0, issueDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasIssueDate);		
					return null;		
				}		
			}		
			hasIssueDate = FixUtils.TAG_HAS_VALUE;		
			return issueDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasIssueDate() { return hasIssueDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setIssueDate(byte[] src) {		
		if (src == null ) return;
		if (hasIssueDate()) FixUtils.fillNul(issueDate);		
		FixUtils.copy(issueDate, src); 		
		hasIssueDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setIssueDate(String str) {		
		if (str == null ) return;
		if (hasIssueDate()) FixUtils.fillNul(issueDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(issueDate, src); 		
		hasIssueDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRepoCollateralSecurityType() { 		
		if ( hasRepoCollateralSecurityType()) {		
			if (hasRepoCollateralSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return repoCollateralSecurityType; 		
			} else {		
		
				buf.position(hasRepoCollateralSecurityType);		
		
			repoCollateralSecurityType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRepoCollateralSecurityType);		
					return 0;		
				}		
			}		
			hasRepoCollateralSecurityType = FixUtils.TAG_HAS_VALUE;		
			return repoCollateralSecurityType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRepoCollateralSecurityType() { return hasRepoCollateralSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRepoCollateralSecurityType(long src) {		
		repoCollateralSecurityType = src;
		hasRepoCollateralSecurityType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRepoCollateralSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasRepoCollateralSecurityType()) repoCollateralSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		repoCollateralSecurityType = FixUtils.longValueOf(src, 0, src.length);
		hasRepoCollateralSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRepoCollateralSecurityType(String str) {		
		if (str == null ) return;
		if (hasRepoCollateralSecurityType()) repoCollateralSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		repoCollateralSecurityType = FixUtils.longValueOf(src, 0, src.length);
		hasRepoCollateralSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRepurchaseTerm() { 		
		if ( hasRepurchaseTerm()) {		
			if (hasRepurchaseTerm == FixUtils.TAG_HAS_VALUE) {		
				return repurchaseTerm; 		
			} else {		
		
				buf.position(hasRepurchaseTerm);		
		
			repurchaseTerm = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRepurchaseTerm);		
					return 0;		
				}		
			}		
			hasRepurchaseTerm = FixUtils.TAG_HAS_VALUE;		
			return repurchaseTerm;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRepurchaseTerm() { return hasRepurchaseTerm != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRepurchaseTerm(long src) {		
		repurchaseTerm = src;
		hasRepurchaseTerm = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRepurchaseTerm(byte[] src) {		
		if (src == null ) return;
		if (hasRepurchaseTerm()) repurchaseTerm = FixUtils.TAG_HAS_NO_VALUE;		
		repurchaseTerm = FixUtils.longValueOf(src, 0, src.length);
		hasRepurchaseTerm = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRepurchaseTerm(String str) {		
		if (str == null ) return;
		if (hasRepurchaseTerm()) repurchaseTerm = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		repurchaseTerm = FixUtils.longValueOf(src, 0, src.length);
		hasRepurchaseTerm = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRepurchaseRate() { 		
		if ( hasRepurchaseRate()) {		
			if (hasRepurchaseRate == FixUtils.TAG_HAS_VALUE) {		
				return repurchaseRate; 		
			} else {		
		
				buf.position(hasRepurchaseRate);		
		
			repurchaseRate = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRepurchaseRate);		
					return 0;		
				}		
			}		
			hasRepurchaseRate = FixUtils.TAG_HAS_VALUE;		
			return repurchaseRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRepurchaseRate() { return hasRepurchaseRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRepurchaseRate(long src) {		
		repurchaseRate = src;
		hasRepurchaseRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRepurchaseRate(byte[] src) {		
		if (src == null ) return;
		if (hasRepurchaseRate()) repurchaseRate = FixUtils.TAG_HAS_NO_VALUE;		
		repurchaseRate = FixUtils.longValueOf(src, 0, src.length);
		hasRepurchaseRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRepurchaseRate(String str) {		
		if (str == null ) return;
		if (hasRepurchaseRate()) repurchaseRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		repurchaseRate = FixUtils.longValueOf(src, 0, src.length);
		hasRepurchaseRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getFactor() { 		
		if ( hasFactor()) {		
			if (hasFactor == FixUtils.TAG_HAS_VALUE) {		
				return factor; 		
			} else {		
		
				buf.position(hasFactor);		
		
			factor = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasFactor);		
					return 0;		
				}		
			}		
			hasFactor = FixUtils.TAG_HAS_VALUE;		
			return factor;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasFactor() { return hasFactor != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFactor(long src) {		
		factor = src;
		hasFactor = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFactor(byte[] src) {		
		if (src == null ) return;
		if (hasFactor()) factor = FixUtils.TAG_HAS_NO_VALUE;		
		factor = FixUtils.longValueOf(src, 0, src.length);
		hasFactor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFactor(String str) {		
		if (str == null ) return;
		if (hasFactor()) factor = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		factor = FixUtils.longValueOf(src, 0, src.length);
		hasFactor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCreditRating() { 		
		if ( hasCreditRating()) {		
			if (hasCreditRating == FixUtils.TAG_HAS_VALUE) {		
				return creditRating; 		
			} else {		
		
				buf.position(hasCreditRating);		
		
			FixUtils.getTagStringValue(buf, creditRating, 0, creditRating.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCreditRating);		
					return null;		
				}		
			}		
			hasCreditRating = FixUtils.TAG_HAS_VALUE;		
			return creditRating;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCreditRating() { return hasCreditRating != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCreditRating(byte[] src) {		
		if (src == null ) return;
		if (hasCreditRating()) FixUtils.fillNul(creditRating);		
		FixUtils.copy(creditRating, src); 		
		hasCreditRating = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCreditRating(String str) {		
		if (str == null ) return;
		if (hasCreditRating()) FixUtils.fillNul(creditRating);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(creditRating, src); 		
		hasCreditRating = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getInstrRegistry() { 		
		if ( hasInstrRegistry()) {		
			if (hasInstrRegistry == FixUtils.TAG_HAS_VALUE) {		
				return instrRegistry; 		
			} else {		
		
				buf.position(hasInstrRegistry);		
		
			FixUtils.getTagStringValue(buf, instrRegistry, 0, instrRegistry.length, err);
		
				if (err.hasError()) {		
					buf.position(hasInstrRegistry);		
					return null;		
				}		
			}		
			hasInstrRegistry = FixUtils.TAG_HAS_VALUE;		
			return instrRegistry;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasInstrRegistry() { return hasInstrRegistry != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setInstrRegistry(byte[] src) {		
		if (src == null ) return;
		if (hasInstrRegistry()) FixUtils.fillNul(instrRegistry);		
		FixUtils.copy(instrRegistry, src); 		
		hasInstrRegistry = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setInstrRegistry(String str) {		
		if (str == null ) return;
		if (hasInstrRegistry()) FixUtils.fillNul(instrRegistry);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(instrRegistry, src); 		
		hasInstrRegistry = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCountryOfIssue() { 		
		if ( hasCountryOfIssue()) {		
			if (hasCountryOfIssue == FixUtils.TAG_HAS_VALUE) {		
				return countryOfIssue; 		
			} else {		
		
				buf.position(hasCountryOfIssue);		
		
			FixUtils.getTagStringValue(buf, countryOfIssue, 0, countryOfIssue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCountryOfIssue);		
					return null;		
				}		
			}		
			hasCountryOfIssue = FixUtils.TAG_HAS_VALUE;		
			return countryOfIssue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCountryOfIssue() { return hasCountryOfIssue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCountryOfIssue(byte[] src) {		
		if (src == null ) return;
		if (hasCountryOfIssue()) FixUtils.fillNul(countryOfIssue);		
		FixUtils.copy(countryOfIssue, src); 		
		hasCountryOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCountryOfIssue(String str) {		
		if (str == null ) return;
		if (hasCountryOfIssue()) FixUtils.fillNul(countryOfIssue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(countryOfIssue, src); 		
		hasCountryOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getStateOrProvinceOfIssue() { 		
		if ( hasStateOrProvinceOfIssue()) {		
			if (hasStateOrProvinceOfIssue == FixUtils.TAG_HAS_VALUE) {		
				return stateOrProvinceOfIssue; 		
			} else {		
		
				buf.position(hasStateOrProvinceOfIssue);		
		
			FixUtils.getTagStringValue(buf, stateOrProvinceOfIssue, 0, stateOrProvinceOfIssue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasStateOrProvinceOfIssue);		
					return null;		
				}		
			}		
			hasStateOrProvinceOfIssue = FixUtils.TAG_HAS_VALUE;		
			return stateOrProvinceOfIssue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStateOrProvinceOfIssue() { return hasStateOrProvinceOfIssue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStateOrProvinceOfIssue(byte[] src) {		
		if (src == null ) return;
		if (hasStateOrProvinceOfIssue()) FixUtils.fillNul(stateOrProvinceOfIssue);		
		FixUtils.copy(stateOrProvinceOfIssue, src); 		
		hasStateOrProvinceOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStateOrProvinceOfIssue(String str) {		
		if (str == null ) return;
		if (hasStateOrProvinceOfIssue()) FixUtils.fillNul(stateOrProvinceOfIssue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(stateOrProvinceOfIssue, src); 		
		hasStateOrProvinceOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLocaleOfIssue() { 		
		if ( hasLocaleOfIssue()) {		
			if (hasLocaleOfIssue == FixUtils.TAG_HAS_VALUE) {		
				return localeOfIssue; 		
			} else {		
		
				buf.position(hasLocaleOfIssue);		
		
			FixUtils.getTagStringValue(buf, localeOfIssue, 0, localeOfIssue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLocaleOfIssue);		
					return null;		
				}		
			}		
			hasLocaleOfIssue = FixUtils.TAG_HAS_VALUE;		
			return localeOfIssue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLocaleOfIssue() { return hasLocaleOfIssue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLocaleOfIssue(byte[] src) {		
		if (src == null ) return;
		if (hasLocaleOfIssue()) FixUtils.fillNul(localeOfIssue);		
		FixUtils.copy(localeOfIssue, src); 		
		hasLocaleOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLocaleOfIssue(String str) {		
		if (str == null ) return;
		if (hasLocaleOfIssue()) FixUtils.fillNul(localeOfIssue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(localeOfIssue, src); 		
		hasLocaleOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRedemptionDate() { 		
		if ( hasRedemptionDate()) {		
			if (hasRedemptionDate == FixUtils.TAG_HAS_VALUE) {		
				return redemptionDate; 		
			} else {		
		
				buf.position(hasRedemptionDate);		
		
			FixUtils.getTagStringValue(buf, redemptionDate, 0, redemptionDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRedemptionDate);		
					return null;		
				}		
			}		
			hasRedemptionDate = FixUtils.TAG_HAS_VALUE;		
			return redemptionDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRedemptionDate() { return hasRedemptionDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRedemptionDate(byte[] src) {		
		if (src == null ) return;
		if (hasRedemptionDate()) FixUtils.fillNul(redemptionDate);		
		FixUtils.copy(redemptionDate, src); 		
		hasRedemptionDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRedemptionDate(String str) {		
		if (str == null ) return;
		if (hasRedemptionDate()) FixUtils.fillNul(redemptionDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(redemptionDate, src); 		
		hasRedemptionDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStrikePrice() { 		
		if ( hasStrikePrice()) {		
			if (hasStrikePrice == FixUtils.TAG_HAS_VALUE) {		
				return strikePrice; 		
			} else {		
		
				buf.position(hasStrikePrice);		
		
			strikePrice = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStrikePrice);		
					return 0;		
				}		
			}		
			hasStrikePrice = FixUtils.TAG_HAS_VALUE;		
			return strikePrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStrikePrice() { return hasStrikePrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrikePrice(long src) {		
		strikePrice = src;
		hasStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStrikePrice(byte[] src) {		
		if (src == null ) return;
		if (hasStrikePrice()) strikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		strikePrice = FixUtils.longValueOf(src, 0, src.length);
		hasStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrikePrice(String str) {		
		if (str == null ) return;
		if (hasStrikePrice()) strikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		strikePrice = FixUtils.longValueOf(src, 0, src.length);
		hasStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getStrikeCurrency() { 		
		if ( hasStrikeCurrency()) {		
			if (hasStrikeCurrency == FixUtils.TAG_HAS_VALUE) {		
				return strikeCurrency; 		
			} else {		
		
				buf.position(hasStrikeCurrency);		
		
			FixUtils.getTagStringValue(buf, strikeCurrency, 0, strikeCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasStrikeCurrency);		
					return null;		
				}		
			}		
			hasStrikeCurrency = FixUtils.TAG_HAS_VALUE;		
			return strikeCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStrikeCurrency() { return hasStrikeCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrikeCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasStrikeCurrency()) FixUtils.fillNul(strikeCurrency);		
		FixUtils.copy(strikeCurrency, src); 		
		hasStrikeCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrikeCurrency(String str) {		
		if (str == null ) return;
		if (hasStrikeCurrency()) FixUtils.fillNul(strikeCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(strikeCurrency, src); 		
		hasStrikeCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStrikeMultiplier() { 		
		if ( hasStrikeMultiplier()) {		
			if (hasStrikeMultiplier == FixUtils.TAG_HAS_VALUE) {		
				return strikeMultiplier; 		
			} else {		
		
				buf.position(hasStrikeMultiplier);		
		
			strikeMultiplier = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStrikeMultiplier);		
					return 0;		
				}		
			}		
			hasStrikeMultiplier = FixUtils.TAG_HAS_VALUE;		
			return strikeMultiplier;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStrikeMultiplier() { return hasStrikeMultiplier != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrikeMultiplier(long src) {		
		strikeMultiplier = src;
		hasStrikeMultiplier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStrikeMultiplier(byte[] src) {		
		if (src == null ) return;
		if (hasStrikeMultiplier()) strikeMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		strikeMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasStrikeMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrikeMultiplier(String str) {		
		if (str == null ) return;
		if (hasStrikeMultiplier()) strikeMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		strikeMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasStrikeMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStrikeValue() { 		
		if ( hasStrikeValue()) {		
			if (hasStrikeValue == FixUtils.TAG_HAS_VALUE) {		
				return strikeValue; 		
			} else {		
		
				buf.position(hasStrikeValue);		
		
			strikeValue = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStrikeValue);		
					return 0;		
				}		
			}		
			hasStrikeValue = FixUtils.TAG_HAS_VALUE;		
			return strikeValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStrikeValue() { return hasStrikeValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrikeValue(long src) {		
		strikeValue = src;
		hasStrikeValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStrikeValue(byte[] src) {		
		if (src == null ) return;
		if (hasStrikeValue()) strikeValue = FixUtils.TAG_HAS_NO_VALUE;		
		strikeValue = FixUtils.longValueOf(src, 0, src.length);
		hasStrikeValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrikeValue(String str) {		
		if (str == null ) return;
		if (hasStrikeValue()) strikeValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		strikeValue = FixUtils.longValueOf(src, 0, src.length);
		hasStrikeValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStrikePriceDeterminationMethod() { 		
		if ( hasStrikePriceDeterminationMethod()) {		
			if (hasStrikePriceDeterminationMethod == FixUtils.TAG_HAS_VALUE) {		
				return strikePriceDeterminationMethod; 		
			} else {		
		
				buf.position(hasStrikePriceDeterminationMethod);		
		
			strikePriceDeterminationMethod = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStrikePriceDeterminationMethod);		
					return 0;		
				}		
			}		
			hasStrikePriceDeterminationMethod = FixUtils.TAG_HAS_VALUE;		
			return strikePriceDeterminationMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStrikePriceDeterminationMethod() { return hasStrikePriceDeterminationMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrikePriceDeterminationMethod(long src) {		
		strikePriceDeterminationMethod = src;
		hasStrikePriceDeterminationMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStrikePriceDeterminationMethod(byte[] src) {		
		if (src == null ) return;
		if (hasStrikePriceDeterminationMethod()) strikePriceDeterminationMethod = FixUtils.TAG_HAS_NO_VALUE;		
		strikePriceDeterminationMethod = FixUtils.longValueOf(src, 0, src.length);
		hasStrikePriceDeterminationMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrikePriceDeterminationMethod(String str) {		
		if (str == null ) return;
		if (hasStrikePriceDeterminationMethod()) strikePriceDeterminationMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		strikePriceDeterminationMethod = FixUtils.longValueOf(src, 0, src.length);
		hasStrikePriceDeterminationMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStrikePriceBoundaryMethod() { 		
		if ( hasStrikePriceBoundaryMethod()) {		
			if (hasStrikePriceBoundaryMethod == FixUtils.TAG_HAS_VALUE) {		
				return strikePriceBoundaryMethod; 		
			} else {		
		
				buf.position(hasStrikePriceBoundaryMethod);		
		
			strikePriceBoundaryMethod = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStrikePriceBoundaryMethod);		
					return 0;		
				}		
			}		
			hasStrikePriceBoundaryMethod = FixUtils.TAG_HAS_VALUE;		
			return strikePriceBoundaryMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStrikePriceBoundaryMethod() { return hasStrikePriceBoundaryMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrikePriceBoundaryMethod(long src) {		
		strikePriceBoundaryMethod = src;
		hasStrikePriceBoundaryMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStrikePriceBoundaryMethod(byte[] src) {		
		if (src == null ) return;
		if (hasStrikePriceBoundaryMethod()) strikePriceBoundaryMethod = FixUtils.TAG_HAS_NO_VALUE;		
		strikePriceBoundaryMethod = FixUtils.longValueOf(src, 0, src.length);
		hasStrikePriceBoundaryMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrikePriceBoundaryMethod(String str) {		
		if (str == null ) return;
		if (hasStrikePriceBoundaryMethod()) strikePriceBoundaryMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		strikePriceBoundaryMethod = FixUtils.longValueOf(src, 0, src.length);
		hasStrikePriceBoundaryMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStrikePriceBoundaryPrecision() { 		
		if ( hasStrikePriceBoundaryPrecision()) {		
			if (hasStrikePriceBoundaryPrecision == FixUtils.TAG_HAS_VALUE) {		
				return strikePriceBoundaryPrecision; 		
			} else {		
		
				buf.position(hasStrikePriceBoundaryPrecision);		
		
			strikePriceBoundaryPrecision = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStrikePriceBoundaryPrecision);		
					return 0;		
				}		
			}		
			hasStrikePriceBoundaryPrecision = FixUtils.TAG_HAS_VALUE;		
			return strikePriceBoundaryPrecision;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStrikePriceBoundaryPrecision() { return hasStrikePriceBoundaryPrecision != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrikePriceBoundaryPrecision(long src) {		
		strikePriceBoundaryPrecision = src;
		hasStrikePriceBoundaryPrecision = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStrikePriceBoundaryPrecision(byte[] src) {		
		if (src == null ) return;
		if (hasStrikePriceBoundaryPrecision()) strikePriceBoundaryPrecision = FixUtils.TAG_HAS_NO_VALUE;		
		strikePriceBoundaryPrecision = FixUtils.longValueOf(src, 0, src.length);
		hasStrikePriceBoundaryPrecision = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrikePriceBoundaryPrecision(String str) {		
		if (str == null ) return;
		if (hasStrikePriceBoundaryPrecision()) strikePriceBoundaryPrecision = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		strikePriceBoundaryPrecision = FixUtils.longValueOf(src, 0, src.length);
		hasStrikePriceBoundaryPrecision = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingPriceDeterminationMethod() { 		
		if ( hasUnderlyingPriceDeterminationMethod()) {		
			if (hasUnderlyingPriceDeterminationMethod == FixUtils.TAG_HAS_VALUE) {		
				return underlyingPriceDeterminationMethod; 		
			} else {		
		
				buf.position(hasUnderlyingPriceDeterminationMethod);		
		
			underlyingPriceDeterminationMethod = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingPriceDeterminationMethod);		
					return 0;		
				}		
			}		
			hasUnderlyingPriceDeterminationMethod = FixUtils.TAG_HAS_VALUE;		
			return underlyingPriceDeterminationMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingPriceDeterminationMethod() { return hasUnderlyingPriceDeterminationMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingPriceDeterminationMethod(long src) {		
		underlyingPriceDeterminationMethod = src;
		hasUnderlyingPriceDeterminationMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingPriceDeterminationMethod(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingPriceDeterminationMethod()) underlyingPriceDeterminationMethod = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingPriceDeterminationMethod = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingPriceDeterminationMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingPriceDeterminationMethod(String str) {		
		if (str == null ) return;
		if (hasUnderlyingPriceDeterminationMethod()) underlyingPriceDeterminationMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingPriceDeterminationMethod = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingPriceDeterminationMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getOptAttribute() { 		
		if ( hasOptAttribute()) {		
			if (hasOptAttribute == FixUtils.TAG_HAS_VALUE) {		
				return optAttribute; 		
			} else {		
		
				buf.position(hasOptAttribute);		
		
			optAttribute = FixUtils.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOptAttribute);		
					return (byte)'0';		
				}		
			}		
			hasOptAttribute = FixUtils.TAG_HAS_VALUE;		
			return optAttribute;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOptAttribute() { return hasOptAttribute != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOptAttribute(byte src) {		
		optAttribute = src;
		hasOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOptAttribute(byte[] src) {		
		if (src == null ) return;
		if (hasOptAttribute()) optAttribute = (byte)' ';		
		optAttribute = src[0];		
		hasOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOptAttribute(String str) {		
		if (str == null ) return;
		if (hasOptAttribute()) optAttribute = (byte)' ';		
		byte[] src = str.getBytes(); 		
		optAttribute = src[0];		
		hasOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getContractMultiplier() { 		
		if ( hasContractMultiplier()) {		
			if (hasContractMultiplier == FixUtils.TAG_HAS_VALUE) {		
				return contractMultiplier; 		
			} else {		
		
				buf.position(hasContractMultiplier);		
		
			contractMultiplier = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasContractMultiplier);		
					return 0;		
				}		
			}		
			hasContractMultiplier = FixUtils.TAG_HAS_VALUE;		
			return contractMultiplier;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasContractMultiplier() { return hasContractMultiplier != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContractMultiplier(long src) {		
		contractMultiplier = src;
		hasContractMultiplier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContractMultiplier(byte[] src) {		
		if (src == null ) return;
		if (hasContractMultiplier()) contractMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		contractMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasContractMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContractMultiplier(String str) {		
		if (str == null ) return;
		if (hasContractMultiplier()) contractMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		contractMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasContractMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMinPriceIncrement() { 		
		if ( hasMinPriceIncrement()) {		
			if (hasMinPriceIncrement == FixUtils.TAG_HAS_VALUE) {		
				return minPriceIncrement; 		
			} else {		
		
				buf.position(hasMinPriceIncrement);		
		
			minPriceIncrement = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMinPriceIncrement);		
					return 0;		
				}		
			}		
			hasMinPriceIncrement = FixUtils.TAG_HAS_VALUE;		
			return minPriceIncrement;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMinPriceIncrement() { return hasMinPriceIncrement != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMinPriceIncrement(long src) {		
		minPriceIncrement = src;
		hasMinPriceIncrement = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinPriceIncrement(byte[] src) {		
		if (src == null ) return;
		if (hasMinPriceIncrement()) minPriceIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		minPriceIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasMinPriceIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMinPriceIncrement(String str) {		
		if (str == null ) return;
		if (hasMinPriceIncrement()) minPriceIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		minPriceIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasMinPriceIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnitOfMeasure() { 		
		if ( hasUnitOfMeasure()) {		
			if (hasUnitOfMeasure == FixUtils.TAG_HAS_VALUE) {		
				return unitOfMeasure; 		
			} else {		
		
				buf.position(hasUnitOfMeasure);		
		
			FixUtils.getTagStringValue(buf, unitOfMeasure, 0, unitOfMeasure.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnitOfMeasure);		
					return null;		
				}		
			}		
			hasUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
			return unitOfMeasure;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnitOfMeasure() { return hasUnitOfMeasure != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnitOfMeasure(byte[] src) {		
		if (src == null ) return;
		if (hasUnitOfMeasure()) FixUtils.fillNul(unitOfMeasure);		
		FixUtils.copy(unitOfMeasure, src); 		
		hasUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnitOfMeasure(String str) {		
		if (str == null ) return;
		if (hasUnitOfMeasure()) FixUtils.fillNul(unitOfMeasure);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(unitOfMeasure, src); 		
		hasUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTimeUnit() { 		
		if ( hasTimeUnit()) {		
			if (hasTimeUnit == FixUtils.TAG_HAS_VALUE) {		
				return timeUnit; 		
			} else {		
		
				buf.position(hasTimeUnit);		
		
			FixUtils.getTagStringValue(buf, timeUnit, 0, timeUnit.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTimeUnit);		
					return null;		
				}		
			}		
			hasTimeUnit = FixUtils.TAG_HAS_VALUE;		
			return timeUnit;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTimeUnit() { return hasTimeUnit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTimeUnit(byte[] src) {		
		if (src == null ) return;
		if (hasTimeUnit()) FixUtils.fillNul(timeUnit);		
		FixUtils.copy(timeUnit, src); 		
		hasTimeUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTimeUnit(String str) {		
		if (str == null ) return;
		if (hasTimeUnit()) FixUtils.fillNul(timeUnit);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(timeUnit, src); 		
		hasTimeUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMinPriceIncrementAmount() { 		
		if ( hasMinPriceIncrementAmount()) {		
			if (hasMinPriceIncrementAmount == FixUtils.TAG_HAS_VALUE) {		
				return minPriceIncrementAmount; 		
			} else {		
		
				buf.position(hasMinPriceIncrementAmount);		
		
			minPriceIncrementAmount = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMinPriceIncrementAmount);		
					return 0;		
				}		
			}		
			hasMinPriceIncrementAmount = FixUtils.TAG_HAS_VALUE;		
			return minPriceIncrementAmount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMinPriceIncrementAmount() { return hasMinPriceIncrementAmount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMinPriceIncrementAmount(long src) {		
		minPriceIncrementAmount = src;
		hasMinPriceIncrementAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinPriceIncrementAmount(byte[] src) {		
		if (src == null ) return;
		if (hasMinPriceIncrementAmount()) minPriceIncrementAmount = FixUtils.TAG_HAS_NO_VALUE;		
		minPriceIncrementAmount = FixUtils.longValueOf(src, 0, src.length);
		hasMinPriceIncrementAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMinPriceIncrementAmount(String str) {		
		if (str == null ) return;
		if (hasMinPriceIncrementAmount()) minPriceIncrementAmount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		minPriceIncrementAmount = FixUtils.longValueOf(src, 0, src.length);
		hasMinPriceIncrementAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnitOfMeasureQty() { 		
		if ( hasUnitOfMeasureQty()) {		
			if (hasUnitOfMeasureQty == FixUtils.TAG_HAS_VALUE) {		
				return unitOfMeasureQty; 		
			} else {		
		
				buf.position(hasUnitOfMeasureQty);		
		
			unitOfMeasureQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnitOfMeasureQty);		
					return 0;		
				}		
			}		
			hasUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
			return unitOfMeasureQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnitOfMeasureQty() { return hasUnitOfMeasureQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnitOfMeasureQty(long src) {		
		unitOfMeasureQty = src;
		hasUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnitOfMeasureQty(byte[] src) {		
		if (src == null ) return;
		if (hasUnitOfMeasureQty()) unitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		unitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnitOfMeasureQty(String str) {		
		if (str == null ) return;
		if (hasUnitOfMeasureQty()) unitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		unitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getPriceUnitOfMeasure() { 		
		if ( hasPriceUnitOfMeasure()) {		
			if (hasPriceUnitOfMeasure == FixUtils.TAG_HAS_VALUE) {		
				return priceUnitOfMeasure; 		
			} else {		
		
				buf.position(hasPriceUnitOfMeasure);		
		
			FixUtils.getTagStringValue(buf, priceUnitOfMeasure, 0, priceUnitOfMeasure.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPriceUnitOfMeasure);		
					return null;		
				}		
			}		
			hasPriceUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
			return priceUnitOfMeasure;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPriceUnitOfMeasure() { return hasPriceUnitOfMeasure != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPriceUnitOfMeasure(byte[] src) {		
		if (src == null ) return;
		if (hasPriceUnitOfMeasure()) FixUtils.fillNul(priceUnitOfMeasure);		
		FixUtils.copy(priceUnitOfMeasure, src); 		
		hasPriceUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPriceUnitOfMeasure(String str) {		
		if (str == null ) return;
		if (hasPriceUnitOfMeasure()) FixUtils.fillNul(priceUnitOfMeasure);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(priceUnitOfMeasure, src); 		
		hasPriceUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPriceUnitOfMeasureQty() { 		
		if ( hasPriceUnitOfMeasureQty()) {		
			if (hasPriceUnitOfMeasureQty == FixUtils.TAG_HAS_VALUE) {		
				return priceUnitOfMeasureQty; 		
			} else {		
		
				buf.position(hasPriceUnitOfMeasureQty);		
		
			priceUnitOfMeasureQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPriceUnitOfMeasureQty);		
					return 0;		
				}		
			}		
			hasPriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
			return priceUnitOfMeasureQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriceUnitOfMeasureQty() { return hasPriceUnitOfMeasureQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPriceUnitOfMeasureQty(long src) {		
		priceUnitOfMeasureQty = src;
		hasPriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceUnitOfMeasureQty(byte[] src) {		
		if (src == null ) return;
		if (hasPriceUnitOfMeasureQty()) priceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		priceUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasPriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPriceUnitOfMeasureQty(String str) {		
		if (str == null ) return;
		if (hasPriceUnitOfMeasureQty()) priceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priceUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasPriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getSettlMethod() { 		
		if ( hasSettlMethod()) {		
			if (hasSettlMethod == FixUtils.TAG_HAS_VALUE) {		
				return settlMethod; 		
			} else {		
		
				buf.position(hasSettlMethod);		
		
			settlMethod = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (settlMethod != (byte)'P') && (settlMethod != (byte)'C') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1193);		
				if (err.hasError()) {		
					buf.position(hasSettlMethod);		
					return (byte)'0';		
				}		
			}		
			hasSettlMethod = FixUtils.TAG_HAS_VALUE;		
			return settlMethod;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSettlMethod() { return hasSettlMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlMethod(byte src) {		
		settlMethod = src;
		hasSettlMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlMethod(byte[] src) {		
		if (src == null ) return;
		if (hasSettlMethod()) settlMethod = (byte)' ';		
		settlMethod = src[0];		
		hasSettlMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlMethod(String str) {		
		if (str == null ) return;
		if (hasSettlMethod()) settlMethod = (byte)' ';		
		byte[] src = str.getBytes(); 		
		settlMethod = src[0];		
		hasSettlMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getExerciseStyle() { 		
		if ( hasExerciseStyle()) {		
			if (hasExerciseStyle == FixUtils.TAG_HAS_VALUE) {		
				return exerciseStyle; 		
			} else {		
		
				buf.position(hasExerciseStyle);		
		
			exerciseStyle = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasExerciseStyle);		
					return 0;		
				}		
			}		
			hasExerciseStyle = FixUtils.TAG_HAS_VALUE;		
			return exerciseStyle;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasExerciseStyle() { return hasExerciseStyle != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setExerciseStyle(long src) {		
		exerciseStyle = src;
		hasExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExerciseStyle(byte[] src) {		
		if (src == null ) return;
		if (hasExerciseStyle()) exerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		exerciseStyle = FixUtils.longValueOf(src, 0, src.length);
		hasExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setExerciseStyle(String str) {		
		if (str == null ) return;
		if (hasExerciseStyle()) exerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		exerciseStyle = FixUtils.longValueOf(src, 0, src.length);
		hasExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOptPayoutAmount() { 		
		if ( hasOptPayoutAmount()) {		
			if (hasOptPayoutAmount == FixUtils.TAG_HAS_VALUE) {		
				return optPayoutAmount; 		
			} else {		
		
				buf.position(hasOptPayoutAmount);		
		
			optPayoutAmount = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOptPayoutAmount);		
					return 0;		
				}		
			}		
			hasOptPayoutAmount = FixUtils.TAG_HAS_VALUE;		
			return optPayoutAmount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOptPayoutAmount() { return hasOptPayoutAmount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOptPayoutAmount(long src) {		
		optPayoutAmount = src;
		hasOptPayoutAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOptPayoutAmount(byte[] src) {		
		if (src == null ) return;
		if (hasOptPayoutAmount()) optPayoutAmount = FixUtils.TAG_HAS_NO_VALUE;		
		optPayoutAmount = FixUtils.longValueOf(src, 0, src.length);
		hasOptPayoutAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOptPayoutAmount(String str) {		
		if (str == null ) return;
		if (hasOptPayoutAmount()) optPayoutAmount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		optPayoutAmount = FixUtils.longValueOf(src, 0, src.length);
		hasOptPayoutAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getPriceQuoteMethod() { 		
		if ( hasPriceQuoteMethod()) {		
			if (hasPriceQuoteMethod == FixUtils.TAG_HAS_VALUE) {		
				return priceQuoteMethod; 		
			} else {		
		
				buf.position(hasPriceQuoteMethod);		
		
			FixUtils.getTagStringValue(buf, priceQuoteMethod, 0, priceQuoteMethod.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPriceQuoteMethod);		
					return null;		
				}		
			}		
			hasPriceQuoteMethod = FixUtils.TAG_HAS_VALUE;		
			return priceQuoteMethod;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPriceQuoteMethod() { return hasPriceQuoteMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPriceQuoteMethod(byte[] src) {		
		if (src == null ) return;
		if (hasPriceQuoteMethod()) FixUtils.fillNul(priceQuoteMethod);		
		FixUtils.copy(priceQuoteMethod, src); 		
		hasPriceQuoteMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPriceQuoteMethod(String str) {		
		if (str == null ) return;
		if (hasPriceQuoteMethod()) FixUtils.fillNul(priceQuoteMethod);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(priceQuoteMethod, src); 		
		hasPriceQuoteMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getListMethod() { 		
		if ( hasListMethod()) {		
			if (hasListMethod == FixUtils.TAG_HAS_VALUE) {		
				return listMethod; 		
			} else {		
		
				buf.position(hasListMethod);		
		
			listMethod = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasListMethod);		
					return 0;		
				}		
			}		
			hasListMethod = FixUtils.TAG_HAS_VALUE;		
			return listMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasListMethod() { return hasListMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setListMethod(long src) {		
		listMethod = src;
		hasListMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListMethod(byte[] src) {		
		if (src == null ) return;
		if (hasListMethod()) listMethod = FixUtils.TAG_HAS_NO_VALUE;		
		listMethod = FixUtils.longValueOf(src, 0, src.length);
		hasListMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setListMethod(String str) {		
		if (str == null ) return;
		if (hasListMethod()) listMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		listMethod = FixUtils.longValueOf(src, 0, src.length);
		hasListMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getCapPrice() { 		
		if ( hasCapPrice()) {		
			if (hasCapPrice == FixUtils.TAG_HAS_VALUE) {		
				return capPrice; 		
			} else {		
		
				buf.position(hasCapPrice);		
		
			capPrice = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasCapPrice);		
					return 0;		
				}		
			}		
			hasCapPrice = FixUtils.TAG_HAS_VALUE;		
			return capPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCapPrice() { return hasCapPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCapPrice(long src) {		
		capPrice = src;
		hasCapPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCapPrice(byte[] src) {		
		if (src == null ) return;
		if (hasCapPrice()) capPrice = FixUtils.TAG_HAS_NO_VALUE;		
		capPrice = FixUtils.longValueOf(src, 0, src.length);
		hasCapPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCapPrice(String str) {		
		if (str == null ) return;
		if (hasCapPrice()) capPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		capPrice = FixUtils.longValueOf(src, 0, src.length);
		hasCapPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getFloorPrice() { 		
		if ( hasFloorPrice()) {		
			if (hasFloorPrice == FixUtils.TAG_HAS_VALUE) {		
				return floorPrice; 		
			} else {		
		
				buf.position(hasFloorPrice);		
		
			floorPrice = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasFloorPrice);		
					return 0;		
				}		
			}		
			hasFloorPrice = FixUtils.TAG_HAS_VALUE;		
			return floorPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasFloorPrice() { return hasFloorPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFloorPrice(long src) {		
		floorPrice = src;
		hasFloorPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFloorPrice(byte[] src) {		
		if (src == null ) return;
		if (hasFloorPrice()) floorPrice = FixUtils.TAG_HAS_NO_VALUE;		
		floorPrice = FixUtils.longValueOf(src, 0, src.length);
		hasFloorPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFloorPrice(String str) {		
		if (str == null ) return;
		if (hasFloorPrice()) floorPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		floorPrice = FixUtils.longValueOf(src, 0, src.length);
		hasFloorPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPutOrCall() { 		
		if ( hasPutOrCall()) {		
			if (hasPutOrCall == FixUtils.TAG_HAS_VALUE) {		
				return putOrCall; 		
			} else {		
		
				buf.position(hasPutOrCall);		
		
			putOrCall = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPutOrCall);		
					return 0;		
				}		
			}		
			hasPutOrCall = FixUtils.TAG_HAS_VALUE;		
			return putOrCall;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPutOrCall() { return hasPutOrCall != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPutOrCall(long src) {		
		putOrCall = src;
		hasPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPutOrCall(byte[] src) {		
		if (src == null ) return;
		if (hasPutOrCall()) putOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		putOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPutOrCall(String str) {		
		if (str == null ) return;
		if (hasPutOrCall()) putOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		putOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getFlexibleIndicator() { 		
		if ( hasFlexibleIndicator()) {		
			if (hasFlexibleIndicator == FixUtils.TAG_HAS_VALUE) {		
				return flexibleIndicator; 		
			} else {		
		
				buf.position(hasFlexibleIndicator);		
		
			flexibleIndicator = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasFlexibleIndicator);		
					return false;		
				}		
			}		
			hasFlexibleIndicator = FixUtils.TAG_HAS_VALUE;		
			return flexibleIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasFlexibleIndicator() { return hasFlexibleIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFlexibleIndicator(boolean src) {		
		flexibleIndicator = src;
		hasFlexibleIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFlexibleIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasFlexibleIndicator()) flexibleIndicator = false;		
		flexibleIndicator = src[0]==(byte)'Y'?true:false;		
		hasFlexibleIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFlexibleIndicator(String str) {		
		if (str == null ) return;
		if (hasFlexibleIndicator()) flexibleIndicator = false;		
		byte[] src = str.getBytes(); 		
		flexibleIndicator = src[0]==(byte)'Y'?true:false;		
		hasFlexibleIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getFlexProductEligibilityIndicator() { 		
		if ( hasFlexProductEligibilityIndicator()) {		
			if (hasFlexProductEligibilityIndicator == FixUtils.TAG_HAS_VALUE) {		
				return flexProductEligibilityIndicator; 		
			} else {		
		
				buf.position(hasFlexProductEligibilityIndicator);		
		
			flexProductEligibilityIndicator = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasFlexProductEligibilityIndicator);		
					return false;		
				}		
			}		
			hasFlexProductEligibilityIndicator = FixUtils.TAG_HAS_VALUE;		
			return flexProductEligibilityIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasFlexProductEligibilityIndicator() { return hasFlexProductEligibilityIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFlexProductEligibilityIndicator(boolean src) {		
		flexProductEligibilityIndicator = src;
		hasFlexProductEligibilityIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFlexProductEligibilityIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasFlexProductEligibilityIndicator()) flexProductEligibilityIndicator = false;		
		flexProductEligibilityIndicator = src[0]==(byte)'Y'?true:false;		
		hasFlexProductEligibilityIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFlexProductEligibilityIndicator(String str) {		
		if (str == null ) return;
		if (hasFlexProductEligibilityIndicator()) flexProductEligibilityIndicator = false;		
		byte[] src = str.getBytes(); 		
		flexProductEligibilityIndicator = src[0]==(byte)'Y'?true:false;		
		hasFlexProductEligibilityIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getValuationMethod() { 		
		if ( hasValuationMethod()) {		
			if (hasValuationMethod == FixUtils.TAG_HAS_VALUE) {		
				return valuationMethod; 		
			} else {		
		
				buf.position(hasValuationMethod);		
		
			FixUtils.getTagStringValue(buf, valuationMethod, 0, valuationMethod.length, err);
		
				if (err.hasError()) {		
					buf.position(hasValuationMethod);		
					return null;		
				}		
			}		
			hasValuationMethod = FixUtils.TAG_HAS_VALUE;		
			return valuationMethod;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasValuationMethod() { return hasValuationMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setValuationMethod(byte[] src) {		
		if (src == null ) return;
		if (hasValuationMethod()) FixUtils.fillNul(valuationMethod);		
		FixUtils.copy(valuationMethod, src); 		
		hasValuationMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setValuationMethod(String str) {		
		if (str == null ) return;
		if (hasValuationMethod()) FixUtils.fillNul(valuationMethod);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(valuationMethod, src); 		
		hasValuationMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getContractMultiplierUnit() { 		
		if ( hasContractMultiplierUnit()) {		
			if (hasContractMultiplierUnit == FixUtils.TAG_HAS_VALUE) {		
				return contractMultiplierUnit; 		
			} else {		
		
				buf.position(hasContractMultiplierUnit);		
		
			contractMultiplierUnit = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasContractMultiplierUnit);		
					return 0;		
				}		
			}		
			hasContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
			return contractMultiplierUnit;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasContractMultiplierUnit() { return hasContractMultiplierUnit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContractMultiplierUnit(long src) {		
		contractMultiplierUnit = src;
		hasContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContractMultiplierUnit(byte[] src) {		
		if (src == null ) return;
		if (hasContractMultiplierUnit()) contractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;		
		contractMultiplierUnit = FixUtils.longValueOf(src, 0, src.length);
		hasContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContractMultiplierUnit(String str) {		
		if (str == null ) return;
		if (hasContractMultiplierUnit()) contractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		contractMultiplierUnit = FixUtils.longValueOf(src, 0, src.length);
		hasContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getFlowScheduleType() { 		
		if ( hasFlowScheduleType()) {		
			if (hasFlowScheduleType == FixUtils.TAG_HAS_VALUE) {		
				return flowScheduleType; 		
			} else {		
		
				buf.position(hasFlowScheduleType);		
		
			flowScheduleType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasFlowScheduleType);		
					return 0;		
				}		
			}		
			hasFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
			return flowScheduleType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasFlowScheduleType() { return hasFlowScheduleType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFlowScheduleType(long src) {		
		flowScheduleType = src;
		hasFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFlowScheduleType(byte[] src) {		
		if (src == null ) return;
		if (hasFlowScheduleType()) flowScheduleType = FixUtils.TAG_HAS_NO_VALUE;		
		flowScheduleType = FixUtils.longValueOf(src, 0, src.length);
		hasFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFlowScheduleType(String str) {		
		if (str == null ) return;
		if (hasFlowScheduleType()) flowScheduleType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		flowScheduleType = FixUtils.longValueOf(src, 0, src.length);
		hasFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOptPayoutType() { 		
		if ( hasOptPayoutType()) {		
			if (hasOptPayoutType == FixUtils.TAG_HAS_VALUE) {		
				return optPayoutType; 		
			} else {		
		
				buf.position(hasOptPayoutType);		
		
			optPayoutType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOptPayoutType);		
					return 0;		
				}		
			}		
			hasOptPayoutType = FixUtils.TAG_HAS_VALUE;		
			return optPayoutType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOptPayoutType() { return hasOptPayoutType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOptPayoutType(long src) {		
		optPayoutType = src;
		hasOptPayoutType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOptPayoutType(byte[] src) {		
		if (src == null ) return;
		if (hasOptPayoutType()) optPayoutType = FixUtils.TAG_HAS_NO_VALUE;		
		optPayoutType = FixUtils.longValueOf(src, 0, src.length);
		hasOptPayoutType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOptPayoutType(String str) {		
		if (str == null ) return;
		if (hasOptPayoutType()) optPayoutType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		optPayoutType = FixUtils.longValueOf(src, 0, src.length);
		hasOptPayoutType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getCouponRate() { 		
		if ( hasCouponRate()) {		
			if (hasCouponRate == FixUtils.TAG_HAS_VALUE) {		
				return couponRate; 		
			} else {		
		
				buf.position(hasCouponRate);		
		
			couponRate = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasCouponRate);		
					return 0;		
				}		
			}		
			hasCouponRate = FixUtils.TAG_HAS_VALUE;		
			return couponRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCouponRate() { return hasCouponRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCouponRate(long src) {		
		couponRate = src;
		hasCouponRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCouponRate(byte[] src) {		
		if (src == null ) return;
		if (hasCouponRate()) couponRate = FixUtils.TAG_HAS_NO_VALUE;		
		couponRate = FixUtils.longValueOf(src, 0, src.length);
		hasCouponRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCouponRate(String str) {		
		if (str == null ) return;
		if (hasCouponRate()) couponRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		couponRate = FixUtils.longValueOf(src, 0, src.length);
		hasCouponRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecurityExchange() { 		
		if ( hasSecurityExchange()) {		
			if (hasSecurityExchange == FixUtils.TAG_HAS_VALUE) {		
				return securityExchange; 		
			} else {		
		
				buf.position(hasSecurityExchange);		
		
			FixUtils.getTagStringValue(buf, securityExchange, 0, securityExchange.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityExchange);		
					return null;		
				}		
			}		
			hasSecurityExchange = FixUtils.TAG_HAS_VALUE;		
			return securityExchange;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityExchange() { return hasSecurityExchange != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityExchange(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityExchange()) FixUtils.fillNul(securityExchange);		
		FixUtils.copy(securityExchange, src); 		
		hasSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityExchange(String str) {		
		if (str == null ) return;
		if (hasSecurityExchange()) FixUtils.fillNul(securityExchange);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityExchange, src); 		
		hasSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPositionLimit() { 		
		if ( hasPositionLimit()) {		
			if (hasPositionLimit == FixUtils.TAG_HAS_VALUE) {		
				return positionLimit; 		
			} else {		
		
				buf.position(hasPositionLimit);		
		
			positionLimit = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPositionLimit);		
					return 0;		
				}		
			}		
			hasPositionLimit = FixUtils.TAG_HAS_VALUE;		
			return positionLimit;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPositionLimit() { return hasPositionLimit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPositionLimit(long src) {		
		positionLimit = src;
		hasPositionLimit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPositionLimit(byte[] src) {		
		if (src == null ) return;
		if (hasPositionLimit()) positionLimit = FixUtils.TAG_HAS_NO_VALUE;		
		positionLimit = FixUtils.longValueOf(src, 0, src.length);
		hasPositionLimit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPositionLimit(String str) {		
		if (str == null ) return;
		if (hasPositionLimit()) positionLimit = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		positionLimit = FixUtils.longValueOf(src, 0, src.length);
		hasPositionLimit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNTPositionLimit() { 		
		if ( hasNTPositionLimit()) {		
			if (hasNTPositionLimit == FixUtils.TAG_HAS_VALUE) {		
				return nTPositionLimit; 		
			} else {		
		
				buf.position(hasNTPositionLimit);		
		
			nTPositionLimit = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNTPositionLimit);		
					return 0;		
				}		
			}		
			hasNTPositionLimit = FixUtils.TAG_HAS_VALUE;		
			return nTPositionLimit;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNTPositionLimit() { return hasNTPositionLimit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNTPositionLimit(long src) {		
		nTPositionLimit = src;
		hasNTPositionLimit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNTPositionLimit(byte[] src) {		
		if (src == null ) return;
		if (hasNTPositionLimit()) nTPositionLimit = FixUtils.TAG_HAS_NO_VALUE;		
		nTPositionLimit = FixUtils.longValueOf(src, 0, src.length);
		hasNTPositionLimit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNTPositionLimit(String str) {		
		if (str == null ) return;
		if (hasNTPositionLimit()) nTPositionLimit = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		nTPositionLimit = FixUtils.longValueOf(src, 0, src.length);
		hasNTPositionLimit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getIssuer() { 		
		if ( hasIssuer()) {		
			if (hasIssuer == FixUtils.TAG_HAS_VALUE) {		
				return issuer; 		
			} else {		
		
				buf.position(hasIssuer);		
		
			FixUtils.getTagStringValue(buf, issuer, 0, issuer.length, err);
		
				if (err.hasError()) {		
					buf.position(hasIssuer);		
					return null;		
				}		
			}		
			hasIssuer = FixUtils.TAG_HAS_VALUE;		
			return issuer;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasIssuer() { return hasIssuer != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setIssuer(byte[] src) {		
		if (src == null ) return;
		if (hasIssuer()) FixUtils.fillNul(issuer);		
		FixUtils.copy(issuer, src); 		
		hasIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setIssuer(String str) {		
		if (str == null ) return;
		if (hasIssuer()) FixUtils.fillNul(issuer);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(issuer, src); 		
		hasIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEncodedIssuerLen() { 		
		if ( hasEncodedIssuerLen()) {		
			if (hasEncodedIssuerLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedIssuerLen; 		
			} else {		
		
				buf.position(hasEncodedIssuerLen);		
		
			encodedIssuerLen = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedIssuerLen);		
					return 0;		
				}		
			}		
			hasEncodedIssuerLen = FixUtils.TAG_HAS_VALUE;		
			return encodedIssuerLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedIssuerLen() { return hasEncodedIssuerLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedIssuerLen(long src) {		
		encodedIssuerLen = src;
		hasEncodedIssuerLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedIssuerLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedIssuerLen()) encodedIssuerLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedIssuerLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedIssuerLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedIssuerLen(String str) {		
		if (str == null ) return;
		if (hasEncodedIssuerLen()) encodedIssuerLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedIssuerLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedIssuerLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedIssuer() { 		
		if ( hasEncodedIssuer()) {		
			if (hasEncodedIssuer == FixUtils.TAG_HAS_VALUE) {		
				return encodedIssuer; 		
			} else {		
		
				buf.position(hasEncodedIssuer);		
		
			FixUtils.getTagStringValue(buf, encodedIssuer, 0, encodedIssuer.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedIssuer);		
					return null;		
				}		
			}		
			hasEncodedIssuer = FixUtils.TAG_HAS_VALUE;		
			return encodedIssuer;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedIssuer() { return hasEncodedIssuer != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedIssuer(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedIssuer()) FixUtils.fillNul(encodedIssuer);		
		FixUtils.copy(encodedIssuer, src); 		
		hasEncodedIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedIssuer(String str) {		
		if (str == null ) return;
		if (hasEncodedIssuer()) FixUtils.fillNul(encodedIssuer);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedIssuer, src); 		
		hasEncodedIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecurityDesc() { 		
		if ( hasSecurityDesc()) {		
			if (hasSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return securityDesc; 		
			} else {		
		
				buf.position(hasSecurityDesc);		
		
			FixUtils.getTagStringValue(buf, securityDesc, 0, securityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityDesc);		
					return null;		
				}		
			}		
			hasSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return securityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityDesc() { return hasSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityDesc()) FixUtils.fillNul(securityDesc);		
		FixUtils.copy(securityDesc, src); 		
		hasSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasSecurityDesc()) FixUtils.fillNul(securityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityDesc, src); 		
		hasSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEncodedSecurityDescLen() { 		
		if ( hasEncodedSecurityDescLen()) {		
			if (hasEncodedSecurityDescLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedSecurityDescLen; 		
			} else {		
		
				buf.position(hasEncodedSecurityDescLen);		
		
			encodedSecurityDescLen = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedSecurityDescLen);		
					return 0;		
				}		
			}		
			hasEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
			return encodedSecurityDescLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedSecurityDescLen() { return hasEncodedSecurityDescLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedSecurityDescLen(long src) {		
		encodedSecurityDescLen = src;
		hasEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedSecurityDescLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedSecurityDescLen()) encodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedSecurityDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedSecurityDescLen(String str) {		
		if (str == null ) return;
		if (hasEncodedSecurityDescLen()) encodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedSecurityDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedSecurityDesc() { 		
		if ( hasEncodedSecurityDesc()) {		
			if (hasEncodedSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return encodedSecurityDesc; 		
			} else {		
		
				buf.position(hasEncodedSecurityDesc);		
		
			FixUtils.getTagStringValue(buf, encodedSecurityDesc, 0, encodedSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedSecurityDesc);		
					return null;		
				}		
			}		
			hasEncodedSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return encodedSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedSecurityDesc() { return hasEncodedSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedSecurityDesc()) FixUtils.fillNul(encodedSecurityDesc);		
		FixUtils.copy(encodedSecurityDesc, src); 		
		hasEncodedSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasEncodedSecurityDesc()) FixUtils.fillNul(encodedSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedSecurityDesc, src); 		
		hasEncodedSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getPool() { 		
		if ( hasPool()) {		
			if (hasPool == FixUtils.TAG_HAS_VALUE) {		
				return pool; 		
			} else {		
		
				buf.position(hasPool);		
		
			FixUtils.getTagStringValue(buf, pool, 0, pool.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPool);		
					return null;		
				}		
			}		
			hasPool = FixUtils.TAG_HAS_VALUE;		
			return pool;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPool() { return hasPool != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPool(byte[] src) {		
		if (src == null ) return;
		if (hasPool()) FixUtils.fillNul(pool);		
		FixUtils.copy(pool, src); 		
		hasPool = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPool(String str) {		
		if (str == null ) return;
		if (hasPool()) FixUtils.fillNul(pool);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(pool, src); 		
		hasPool = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getContractSettlMonth() { 		
		if ( hasContractSettlMonth()) {		
			if (hasContractSettlMonth == FixUtils.TAG_HAS_VALUE) {		
				return contractSettlMonth; 		
			} else {		
		
				buf.position(hasContractSettlMonth);		
		
			FixUtils.getTagStringValue(buf, contractSettlMonth, 0, contractSettlMonth.length, err);
		
				if (err.hasError()) {		
					buf.position(hasContractSettlMonth);		
					return null;		
				}		
			}		
			hasContractSettlMonth = FixUtils.TAG_HAS_VALUE;		
			return contractSettlMonth;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasContractSettlMonth() { return hasContractSettlMonth != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContractSettlMonth(byte[] src) {		
		if (src == null ) return;
		if (hasContractSettlMonth()) FixUtils.fillNul(contractSettlMonth);		
		FixUtils.copy(contractSettlMonth, src); 		
		hasContractSettlMonth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContractSettlMonth(String str) {		
		if (str == null ) return;
		if (hasContractSettlMonth()) FixUtils.fillNul(contractSettlMonth);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(contractSettlMonth, src); 		
		hasContractSettlMonth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getCPProgram() { 		
		if ( hasCPProgram()) {		
			if (hasCPProgram == FixUtils.TAG_HAS_VALUE) {		
				return cPProgram; 		
			} else {		
		
				buf.position(hasCPProgram);		
		
			cPProgram = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasCPProgram);		
					return 0;		
				}		
			}		
			hasCPProgram = FixUtils.TAG_HAS_VALUE;		
			return cPProgram;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCPProgram() { return hasCPProgram != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCPProgram(long src) {		
		cPProgram = src;
		hasCPProgram = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCPProgram(byte[] src) {		
		if (src == null ) return;
		if (hasCPProgram()) cPProgram = FixUtils.TAG_HAS_NO_VALUE;		
		cPProgram = FixUtils.longValueOf(src, 0, src.length);
		hasCPProgram = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCPProgram(String str) {		
		if (str == null ) return;
		if (hasCPProgram()) cPProgram = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		cPProgram = FixUtils.longValueOf(src, 0, src.length);
		hasCPProgram = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCPRegType() { 		
		if ( hasCPRegType()) {		
			if (hasCPRegType == FixUtils.TAG_HAS_VALUE) {		
				return cPRegType; 		
			} else {		
		
				buf.position(hasCPRegType);		
		
			FixUtils.getTagStringValue(buf, cPRegType, 0, cPRegType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCPRegType);		
					return null;		
				}		
			}		
			hasCPRegType = FixUtils.TAG_HAS_VALUE;		
			return cPRegType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCPRegType() { return hasCPRegType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCPRegType(byte[] src) {		
		if (src == null ) return;
		if (hasCPRegType()) FixUtils.fillNul(cPRegType);		
		FixUtils.copy(cPRegType, src); 		
		hasCPRegType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCPRegType(String str) {		
		if (str == null ) return;
		if (hasCPRegType()) FixUtils.fillNul(cPRegType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cPRegType, src); 		
		hasCPRegType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDatedDate() { 		
		if ( hasDatedDate()) {		
			if (hasDatedDate == FixUtils.TAG_HAS_VALUE) {		
				return datedDate; 		
			} else {		
		
				buf.position(hasDatedDate);		
		
			FixUtils.getTagStringValue(buf, datedDate, 0, datedDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDatedDate);		
					return null;		
				}		
			}		
			hasDatedDate = FixUtils.TAG_HAS_VALUE;		
			return datedDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDatedDate() { return hasDatedDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDatedDate(byte[] src) {		
		if (src == null ) return;
		if (hasDatedDate()) FixUtils.fillNul(datedDate);		
		FixUtils.copy(datedDate, src); 		
		hasDatedDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDatedDate(String str) {		
		if (str == null ) return;
		if (hasDatedDate()) FixUtils.fillNul(datedDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(datedDate, src); 		
		hasDatedDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getInterestAccrualDate() { 		
		if ( hasInterestAccrualDate()) {		
			if (hasInterestAccrualDate == FixUtils.TAG_HAS_VALUE) {		
				return interestAccrualDate; 		
			} else {		
		
				buf.position(hasInterestAccrualDate);		
		
			FixUtils.getTagStringValue(buf, interestAccrualDate, 0, interestAccrualDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasInterestAccrualDate);		
					return null;		
				}		
			}		
			hasInterestAccrualDate = FixUtils.TAG_HAS_VALUE;		
			return interestAccrualDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasInterestAccrualDate() { return hasInterestAccrualDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setInterestAccrualDate(byte[] src) {		
		if (src == null ) return;
		if (hasInterestAccrualDate()) FixUtils.fillNul(interestAccrualDate);		
		FixUtils.copy(interestAccrualDate, src); 		
		hasInterestAccrualDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setInterestAccrualDate(String str) {		
		if (str == null ) return;
		if (hasInterestAccrualDate()) FixUtils.fillNul(interestAccrualDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(interestAccrualDate, src); 		
		hasInterestAccrualDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSymbol()) s += "Symbol(55)= " + new String( FixUtils.trim(getSymbol()) ) + "\n" ; 
		if (hasSymbolSfx()) s += "SymbolSfx(65)= " + new String( FixUtils.trim(getSymbolSfx()) ) + "\n" ; 
		if (hasSecurityID()) s += "SecurityID(48)= " + new String( FixUtils.trim(getSecurityID()) ) + "\n" ; 
		if (hasSecurityIDSource()) s += "SecurityIDSource(22)= " + new String( FixUtils.trim(getSecurityIDSource()) ) + "\n" ; 
		if (hasProduct()) s += "Product(460)= " + getProduct() + "\n" ; 
		if (hasSecurityGroup()) s += "SecurityGroup(1151)= " + new String( FixUtils.trim(getSecurityGroup()) ) + "\n" ; 
		if (hasProductComplex()) s += "ProductComplex(1227)= " + new String( FixUtils.trim(getProductComplex()) ) + "\n" ; 
		if (hasCFICode()) s += "CFICode(461)= " + new String( FixUtils.trim(getCFICode()) ) + "\n" ; 
		if (hasSecurityType()) s += "SecurityType(167)= " + new String( FixUtils.trim(getSecurityType()) ) + "\n" ; 
		if (hasSecuritySubType()) s += "SecuritySubType(762)= " + new String( FixUtils.trim(getSecuritySubType()) ) + "\n" ; 
		if (hasMaturityMonthYear()) s += "MaturityMonthYear(200)= " + new String( FixUtils.trim(getMaturityMonthYear()) ) + "\n" ; 
		if (hasMaturityDate()) s += "MaturityDate(541)= " + new String( FixUtils.trim(getMaturityDate()) ) + "\n" ; 
		if (hasSecurityStatus()) s += "SecurityStatus(965)= " + new String( FixUtils.trim(getSecurityStatus()) ) + "\n" ; 
		if (hasSettleOnOpenFlag()) s += "SettleOnOpenFlag(966)= " + new String( FixUtils.trim(getSettleOnOpenFlag()) ) + "\n" ; 
		if (hasInstrmtAssignmentMethod()) s += "InstrmtAssignmentMethod(1049)= " + getInstrmtAssignmentMethod() + "\n" ; 
		if (hasMaturityTime()) s += "MaturityTime(1079)= " + new String( FixUtils.trim(getMaturityTime()) ) + "\n" ; 
		if (hasCouponPaymentDate()) s += "CouponPaymentDate(224)= " + new String( FixUtils.trim(getCouponPaymentDate()) ) + "\n" ; 
		if (hasRestructuringType()) s += "RestructuringType(1449)= " + new String( FixUtils.trim(getRestructuringType()) ) + "\n" ; 
		if (hasSeniority()) s += "Seniority(1450)= " + new String( FixUtils.trim(getSeniority()) ) + "\n" ; 
		if (hasNotionalPercentageOutstanding()) s += "NotionalPercentageOutstanding(1451)= " + getNotionalPercentageOutstanding() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOriginalNotionalPercentageOutstanding()) s += "OriginalNotionalPercentageOutstanding(1452)= " + getOriginalNotionalPercentageOutstanding() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAttachmentPoint()) s += "AttachmentPoint(1457)= " + getAttachmentPoint() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDetachmentPoint()) s += "DetachmentPoint(1458)= " + getDetachmentPoint() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasIssueDate()) s += "IssueDate(225)= " + new String( FixUtils.trim(getIssueDate()) ) + "\n" ; 
		if (hasRepoCollateralSecurityType()) s += "RepoCollateralSecurityType(239)= " + getRepoCollateralSecurityType() + "\n" ; 
		if (hasRepurchaseTerm()) s += "RepurchaseTerm(226)= " + getRepurchaseTerm() + "\n" ; 
		if (hasRepurchaseRate()) s += "RepurchaseRate(227)= " + getRepurchaseRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasFactor()) s += "Factor(228)= " + getFactor() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCreditRating()) s += "CreditRating(255)= " + new String( FixUtils.trim(getCreditRating()) ) + "\n" ; 
		if (hasInstrRegistry()) s += "InstrRegistry(543)= " + new String( FixUtils.trim(getInstrRegistry()) ) + "\n" ; 
		if (hasCountryOfIssue()) s += "CountryOfIssue(470)= " + new String( FixUtils.trim(getCountryOfIssue()) ) + "\n" ; 
		if (hasStateOrProvinceOfIssue()) s += "StateOrProvinceOfIssue(471)= " + new String( FixUtils.trim(getStateOrProvinceOfIssue()) ) + "\n" ; 
		if (hasLocaleOfIssue()) s += "LocaleOfIssue(472)= " + new String( FixUtils.trim(getLocaleOfIssue()) ) + "\n" ; 
		if (hasRedemptionDate()) s += "RedemptionDate(240)= " + new String( FixUtils.trim(getRedemptionDate()) ) + "\n" ; 
		if (hasStrikePrice()) s += "StrikePrice(202)= " + getStrikePrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasStrikeCurrency()) s += "StrikeCurrency(947)= " + new String( FixUtils.trim(getStrikeCurrency()) ) + "\n" ; 
		if (hasStrikeMultiplier()) s += "StrikeMultiplier(967)= " + getStrikeMultiplier() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasStrikeValue()) s += "StrikeValue(968)= " + getStrikeValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasStrikePriceDeterminationMethod()) s += "StrikePriceDeterminationMethod(1478)= " + getStrikePriceDeterminationMethod() + "\n" ; 
		if (hasStrikePriceBoundaryMethod()) s += "StrikePriceBoundaryMethod(1479)= " + getStrikePriceBoundaryMethod() + "\n" ; 
		if (hasStrikePriceBoundaryPrecision()) s += "StrikePriceBoundaryPrecision(1480)= " + getStrikePriceBoundaryPrecision() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingPriceDeterminationMethod()) s += "UnderlyingPriceDeterminationMethod(1481)= " + getUnderlyingPriceDeterminationMethod() + "\n" ; 
		if (hasOptAttribute()) s += "OptAttribute(206)= " + getOptAttribute() + "\n" ; 
		if (hasContractMultiplier()) s += "ContractMultiplier(231)= " + getContractMultiplier() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMinPriceIncrement()) s += "MinPriceIncrement(969)= " + getMinPriceIncrement() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnitOfMeasure()) s += "UnitOfMeasure(996)= " + new String( FixUtils.trim(getUnitOfMeasure()) ) + "\n" ; 
		if (hasTimeUnit()) s += "TimeUnit(997)= " + new String( FixUtils.trim(getTimeUnit()) ) + "\n" ; 
		if (hasMinPriceIncrementAmount()) s += "MinPriceIncrementAmount(1146)= " + getMinPriceIncrementAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnitOfMeasureQty()) s += "UnitOfMeasureQty(1147)= " + getUnitOfMeasureQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPriceUnitOfMeasure()) s += "PriceUnitOfMeasure(1191)= " + new String( FixUtils.trim(getPriceUnitOfMeasure()) ) + "\n" ; 
		if (hasPriceUnitOfMeasureQty()) s += "PriceUnitOfMeasureQty(1192)= " + getPriceUnitOfMeasureQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlMethod()) s += "SettlMethod(1193)= " + getSettlMethod() + "\n" ; 
		if (hasExerciseStyle()) s += "ExerciseStyle(1194)= " + getExerciseStyle() + "\n" ; 
		if (hasOptPayoutAmount()) s += "OptPayoutAmount(1195)= " + getOptPayoutAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPriceQuoteMethod()) s += "PriceQuoteMethod(1196)= " + new String( FixUtils.trim(getPriceQuoteMethod()) ) + "\n" ; 
		if (hasListMethod()) s += "ListMethod(1198)= " + getListMethod() + "\n" ; 
		if (hasCapPrice()) s += "CapPrice(1199)= " + getCapPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasFloorPrice()) s += "FloorPrice(1200)= " + getFloorPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPutOrCall()) s += "PutOrCall(201)= " + getPutOrCall() + "\n" ; 
		if (hasFlexibleIndicator()) s += "FlexibleIndicator(1244)= " + getFlexibleIndicator() + "\n" ; 
		if (hasFlexProductEligibilityIndicator()) s += "FlexProductEligibilityIndicator(1242)= " + getFlexProductEligibilityIndicator() + "\n" ; 
		if (hasValuationMethod()) s += "ValuationMethod(1197)= " + new String( FixUtils.trim(getValuationMethod()) ) + "\n" ; 
		if (hasContractMultiplierUnit()) s += "ContractMultiplierUnit(1435)= " + getContractMultiplierUnit() + "\n" ; 
		if (hasFlowScheduleType()) s += "FlowScheduleType(1439)= " + getFlowScheduleType() + "\n" ; 
		if (hasOptPayoutType()) s += "OptPayoutType(1482)= " + getOptPayoutType() + "\n" ; 
		if (hasCouponRate()) s += "CouponRate(223)= " + getCouponRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSecurityExchange()) s += "SecurityExchange(207)= " + new String( FixUtils.trim(getSecurityExchange()) ) + "\n" ; 
		if (hasPositionLimit()) s += "PositionLimit(970)= " + getPositionLimit() + "\n" ; 
		if (hasNTPositionLimit()) s += "NTPositionLimit(971)= " + getNTPositionLimit() + "\n" ; 
		if (hasIssuer()) s += "Issuer(106)= " + new String( FixUtils.trim(getIssuer()) ) + "\n" ; 
		if (hasEncodedIssuerLen()) s += "EncodedIssuerLen(348)= " + getEncodedIssuerLen() + "\n" ; 
		if (hasEncodedIssuer()) s += "EncodedIssuer(349)= " + new String( FixUtils.trim(getEncodedIssuer()) ) + "\n" ; 
		if (hasSecurityDesc()) s += "SecurityDesc(107)= " + new String( FixUtils.trim(getSecurityDesc()) ) + "\n" ; 
		if (hasEncodedSecurityDescLen()) s += "EncodedSecurityDescLen(350)= " + getEncodedSecurityDescLen() + "\n" ; 
		if (hasEncodedSecurityDesc()) s += "EncodedSecurityDesc(351)= " + new String( FixUtils.trim(getEncodedSecurityDesc()) ) + "\n" ; 
		if (hasPool()) s += "Pool(691)= " + new String( FixUtils.trim(getPool()) ) + "\n" ; 
		if (hasContractSettlMonth()) s += "ContractSettlMonth(667)= " + new String( FixUtils.trim(getContractSettlMonth()) ) + "\n" ; 
		if (hasCPProgram()) s += "CPProgram(875)= " + getCPProgram() + "\n" ; 
		if (hasCPRegType()) s += "CPRegType(876)= " + new String( FixUtils.trim(getCPRegType()) ) + "\n" ; 
		if (hasDatedDate()) s += "DatedDate(873)= " + new String( FixUtils.trim(getDatedDate()) ) + "\n" ; 
		if (hasInterestAccrualDate()) s += "InterestAccrualDate(874)= " + new String( FixUtils.trim(getInterestAccrualDate()) ) + "\n" ; 

		for (FixSecAltIDGrp fixSecAltIDGrp : secAltIDGrp) fixSecAltIDGrp.toString();
		s += securityXML.toString();
		for (FixEvntGrp fixEvntGrp : evntGrp) fixEvntGrp.toString();
		for (FixInstrumentParties fixInstrumentParties : instrumentParties) fixInstrumentParties.toString();
		for (FixComplexEvents fixComplexEvents : complexEvents) fixComplexEvents.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrument)) return false;

		FixInstrument msg = (FixInstrument) o;

		for (int i = 0; i < secAltIDGrp.length; i++)
			if (!secAltIDGrp[i].equals(msg.secAltIDGrp[i])) return false;
		if (!securityXML.equals(msg.securityXML)) return false;
		for (int i = 0; i < evntGrp.length; i++)
			if (!evntGrp[i].equals(msg.evntGrp[i])) return false;
		for (int i = 0; i < instrumentParties.length; i++)
			if (!instrumentParties[i].equals(msg.instrumentParties[i])) return false;
		for (int i = 0; i < complexEvents.length; i++)
			if (!complexEvents[i].equals(msg.complexEvents[i])) return false;
		if ((hasSymbol() && !msg.hasSymbol()) || (!hasSymbol() && msg.hasSymbol())) return false;
		if (!(!hasSymbol() && !msg.hasSymbol()) && !FixUtils.equals(getSymbol(), msg.getSymbol())) return false;
		if ((hasSymbolSfx() && !msg.hasSymbolSfx()) || (!hasSymbolSfx() && msg.hasSymbolSfx())) return false;
		if (!(!hasSymbolSfx() && !msg.hasSymbolSfx()) && !FixUtils.equals(getSymbolSfx(), msg.getSymbolSfx())) return false;
		if ((hasSecurityID() && !msg.hasSecurityID()) || (!hasSecurityID() && msg.hasSecurityID())) return false;
		if (!(!hasSecurityID() && !msg.hasSecurityID()) && !FixUtils.equals(getSecurityID(), msg.getSecurityID())) return false;
		if ((hasSecurityIDSource() && !msg.hasSecurityIDSource()) || (!hasSecurityIDSource() && msg.hasSecurityIDSource())) return false;
		if (!(!hasSecurityIDSource() && !msg.hasSecurityIDSource()) && !FixUtils.equals(getSecurityIDSource(), msg.getSecurityIDSource())) return false;
		if ((hasProduct() && !msg.hasProduct()) || (!hasProduct() && msg.hasProduct())) return false;
		if (!(!hasProduct() && !msg.hasProduct()) && !(getProduct()==msg.getProduct())) return false;
		if ((hasSecurityGroup() && !msg.hasSecurityGroup()) || (!hasSecurityGroup() && msg.hasSecurityGroup())) return false;
		if (!(!hasSecurityGroup() && !msg.hasSecurityGroup()) && !FixUtils.equals(getSecurityGroup(), msg.getSecurityGroup())) return false;
		if ((hasProductComplex() && !msg.hasProductComplex()) || (!hasProductComplex() && msg.hasProductComplex())) return false;
		if (!(!hasProductComplex() && !msg.hasProductComplex()) && !FixUtils.equals(getProductComplex(), msg.getProductComplex())) return false;
		if ((hasCFICode() && !msg.hasCFICode()) || (!hasCFICode() && msg.hasCFICode())) return false;
		if (!(!hasCFICode() && !msg.hasCFICode()) && !FixUtils.equals(getCFICode(), msg.getCFICode())) return false;
		if ((hasSecurityType() && !msg.hasSecurityType()) || (!hasSecurityType() && msg.hasSecurityType())) return false;
		if (!(!hasSecurityType() && !msg.hasSecurityType()) && !FixUtils.equals(getSecurityType(), msg.getSecurityType())) return false;
		if ((hasSecuritySubType() && !msg.hasSecuritySubType()) || (!hasSecuritySubType() && msg.hasSecuritySubType())) return false;
		if (!(!hasSecuritySubType() && !msg.hasSecuritySubType()) && !FixUtils.equals(getSecuritySubType(), msg.getSecuritySubType())) return false;
		if ((hasMaturityMonthYear() && !msg.hasMaturityMonthYear()) || (!hasMaturityMonthYear() && msg.hasMaturityMonthYear())) return false;
		if (!(!hasMaturityMonthYear() && !msg.hasMaturityMonthYear()) && !FixUtils.equals(getMaturityMonthYear(), msg.getMaturityMonthYear())) return false;
		if ((hasMaturityDate() && !msg.hasMaturityDate()) || (!hasMaturityDate() && msg.hasMaturityDate())) return false;
		if ((hasSecurityStatus() && !msg.hasSecurityStatus()) || (!hasSecurityStatus() && msg.hasSecurityStatus())) return false;
		if (!(!hasSecurityStatus() && !msg.hasSecurityStatus()) && !FixUtils.equals(getSecurityStatus(), msg.getSecurityStatus())) return false;
		if ((hasSettleOnOpenFlag() && !msg.hasSettleOnOpenFlag()) || (!hasSettleOnOpenFlag() && msg.hasSettleOnOpenFlag())) return false;
		if (!(!hasSettleOnOpenFlag() && !msg.hasSettleOnOpenFlag()) && !FixUtils.equals(getSettleOnOpenFlag(), msg.getSettleOnOpenFlag())) return false;
		if ((hasInstrmtAssignmentMethod() && !msg.hasInstrmtAssignmentMethod()) || (!hasInstrmtAssignmentMethod() && msg.hasInstrmtAssignmentMethod())) return false;
		if (!(!hasInstrmtAssignmentMethod() && !msg.hasInstrmtAssignmentMethod()) && !(getInstrmtAssignmentMethod()==msg.getInstrmtAssignmentMethod())) return false;
		if ((hasMaturityTime() && !msg.hasMaturityTime()) || (!hasMaturityTime() && msg.hasMaturityTime())) return false;
		if ((hasCouponPaymentDate() && !msg.hasCouponPaymentDate()) || (!hasCouponPaymentDate() && msg.hasCouponPaymentDate())) return false;
		if ((hasRestructuringType() && !msg.hasRestructuringType()) || (!hasRestructuringType() && msg.hasRestructuringType())) return false;
		if (!(!hasRestructuringType() && !msg.hasRestructuringType()) && !FixUtils.equals(getRestructuringType(), msg.getRestructuringType())) return false;
		if ((hasSeniority() && !msg.hasSeniority()) || (!hasSeniority() && msg.hasSeniority())) return false;
		if (!(!hasSeniority() && !msg.hasSeniority()) && !FixUtils.equals(getSeniority(), msg.getSeniority())) return false;
		if ((hasNotionalPercentageOutstanding() && !msg.hasNotionalPercentageOutstanding()) || (!hasNotionalPercentageOutstanding() && msg.hasNotionalPercentageOutstanding())) return false;
		if (!(!hasNotionalPercentageOutstanding() && !msg.hasNotionalPercentageOutstanding()) && !(getNotionalPercentageOutstanding()==msg.getNotionalPercentageOutstanding())) return false;
		if ((hasOriginalNotionalPercentageOutstanding() && !msg.hasOriginalNotionalPercentageOutstanding()) || (!hasOriginalNotionalPercentageOutstanding() && msg.hasOriginalNotionalPercentageOutstanding())) return false;
		if (!(!hasOriginalNotionalPercentageOutstanding() && !msg.hasOriginalNotionalPercentageOutstanding()) && !(getOriginalNotionalPercentageOutstanding()==msg.getOriginalNotionalPercentageOutstanding())) return false;
		if ((hasAttachmentPoint() && !msg.hasAttachmentPoint()) || (!hasAttachmentPoint() && msg.hasAttachmentPoint())) return false;
		if (!(!hasAttachmentPoint() && !msg.hasAttachmentPoint()) && !(getAttachmentPoint()==msg.getAttachmentPoint())) return false;
		if ((hasDetachmentPoint() && !msg.hasDetachmentPoint()) || (!hasDetachmentPoint() && msg.hasDetachmentPoint())) return false;
		if (!(!hasDetachmentPoint() && !msg.hasDetachmentPoint()) && !(getDetachmentPoint()==msg.getDetachmentPoint())) return false;
		if ((hasIssueDate() && !msg.hasIssueDate()) || (!hasIssueDate() && msg.hasIssueDate())) return false;
		if ((hasRepoCollateralSecurityType() && !msg.hasRepoCollateralSecurityType()) || (!hasRepoCollateralSecurityType() && msg.hasRepoCollateralSecurityType())) return false;
		if (!(!hasRepoCollateralSecurityType() && !msg.hasRepoCollateralSecurityType()) && !(getRepoCollateralSecurityType()==msg.getRepoCollateralSecurityType())) return false;
		if ((hasRepurchaseTerm() && !msg.hasRepurchaseTerm()) || (!hasRepurchaseTerm() && msg.hasRepurchaseTerm())) return false;
		if (!(!hasRepurchaseTerm() && !msg.hasRepurchaseTerm()) && !(getRepurchaseTerm()==msg.getRepurchaseTerm())) return false;
		if ((hasRepurchaseRate() && !msg.hasRepurchaseRate()) || (!hasRepurchaseRate() && msg.hasRepurchaseRate())) return false;
		if (!(!hasRepurchaseRate() && !msg.hasRepurchaseRate()) && !(getRepurchaseRate()==msg.getRepurchaseRate())) return false;
		if ((hasFactor() && !msg.hasFactor()) || (!hasFactor() && msg.hasFactor())) return false;
		if (!(!hasFactor() && !msg.hasFactor()) && !(getFactor()==msg.getFactor())) return false;
		if ((hasCreditRating() && !msg.hasCreditRating()) || (!hasCreditRating() && msg.hasCreditRating())) return false;
		if (!(!hasCreditRating() && !msg.hasCreditRating()) && !FixUtils.equals(getCreditRating(), msg.getCreditRating())) return false;
		if ((hasInstrRegistry() && !msg.hasInstrRegistry()) || (!hasInstrRegistry() && msg.hasInstrRegistry())) return false;
		if (!(!hasInstrRegistry() && !msg.hasInstrRegistry()) && !FixUtils.equals(getInstrRegistry(), msg.getInstrRegistry())) return false;
		if ((hasCountryOfIssue() && !msg.hasCountryOfIssue()) || (!hasCountryOfIssue() && msg.hasCountryOfIssue())) return false;
		if (!(!hasCountryOfIssue() && !msg.hasCountryOfIssue()) && !FixUtils.equals(getCountryOfIssue(), msg.getCountryOfIssue())) return false;
		if ((hasStateOrProvinceOfIssue() && !msg.hasStateOrProvinceOfIssue()) || (!hasStateOrProvinceOfIssue() && msg.hasStateOrProvinceOfIssue())) return false;
		if (!(!hasStateOrProvinceOfIssue() && !msg.hasStateOrProvinceOfIssue()) && !FixUtils.equals(getStateOrProvinceOfIssue(), msg.getStateOrProvinceOfIssue())) return false;
		if ((hasLocaleOfIssue() && !msg.hasLocaleOfIssue()) || (!hasLocaleOfIssue() && msg.hasLocaleOfIssue())) return false;
		if (!(!hasLocaleOfIssue() && !msg.hasLocaleOfIssue()) && !FixUtils.equals(getLocaleOfIssue(), msg.getLocaleOfIssue())) return false;
		if ((hasRedemptionDate() && !msg.hasRedemptionDate()) || (!hasRedemptionDate() && msg.hasRedemptionDate())) return false;
		if ((hasStrikePrice() && !msg.hasStrikePrice()) || (!hasStrikePrice() && msg.hasStrikePrice())) return false;
		if (!(!hasStrikePrice() && !msg.hasStrikePrice()) && !(getStrikePrice()==msg.getStrikePrice())) return false;
		if ((hasStrikeCurrency() && !msg.hasStrikeCurrency()) || (!hasStrikeCurrency() && msg.hasStrikeCurrency())) return false;
		if (!(!hasStrikeCurrency() && !msg.hasStrikeCurrency()) && !FixUtils.equals(getStrikeCurrency(), msg.getStrikeCurrency())) return false;
		if ((hasStrikeMultiplier() && !msg.hasStrikeMultiplier()) || (!hasStrikeMultiplier() && msg.hasStrikeMultiplier())) return false;
		if (!(!hasStrikeMultiplier() && !msg.hasStrikeMultiplier()) && !(getStrikeMultiplier()==msg.getStrikeMultiplier())) return false;
		if ((hasStrikeValue() && !msg.hasStrikeValue()) || (!hasStrikeValue() && msg.hasStrikeValue())) return false;
		if (!(!hasStrikeValue() && !msg.hasStrikeValue()) && !(getStrikeValue()==msg.getStrikeValue())) return false;
		if ((hasStrikePriceDeterminationMethod() && !msg.hasStrikePriceDeterminationMethod()) || (!hasStrikePriceDeterminationMethod() && msg.hasStrikePriceDeterminationMethod())) return false;
		if (!(!hasStrikePriceDeterminationMethod() && !msg.hasStrikePriceDeterminationMethod()) && !(getStrikePriceDeterminationMethod()==msg.getStrikePriceDeterminationMethod())) return false;
		if ((hasStrikePriceBoundaryMethod() && !msg.hasStrikePriceBoundaryMethod()) || (!hasStrikePriceBoundaryMethod() && msg.hasStrikePriceBoundaryMethod())) return false;
		if (!(!hasStrikePriceBoundaryMethod() && !msg.hasStrikePriceBoundaryMethod()) && !(getStrikePriceBoundaryMethod()==msg.getStrikePriceBoundaryMethod())) return false;
		if ((hasStrikePriceBoundaryPrecision() && !msg.hasStrikePriceBoundaryPrecision()) || (!hasStrikePriceBoundaryPrecision() && msg.hasStrikePriceBoundaryPrecision())) return false;
		if (!(!hasStrikePriceBoundaryPrecision() && !msg.hasStrikePriceBoundaryPrecision()) && !(getStrikePriceBoundaryPrecision()==msg.getStrikePriceBoundaryPrecision())) return false;
		if ((hasUnderlyingPriceDeterminationMethod() && !msg.hasUnderlyingPriceDeterminationMethod()) || (!hasUnderlyingPriceDeterminationMethod() && msg.hasUnderlyingPriceDeterminationMethod())) return false;
		if (!(!hasUnderlyingPriceDeterminationMethod() && !msg.hasUnderlyingPriceDeterminationMethod()) && !(getUnderlyingPriceDeterminationMethod()==msg.getUnderlyingPriceDeterminationMethod())) return false;
		if ((hasOptAttribute() && !msg.hasOptAttribute()) || (!hasOptAttribute() && msg.hasOptAttribute())) return false;
		if (!(!hasOptAttribute() && !msg.hasOptAttribute()) && !(getOptAttribute()==msg.getOptAttribute())) return false;
		if ((hasContractMultiplier() && !msg.hasContractMultiplier()) || (!hasContractMultiplier() && msg.hasContractMultiplier())) return false;
		if (!(!hasContractMultiplier() && !msg.hasContractMultiplier()) && !(getContractMultiplier()==msg.getContractMultiplier())) return false;
		if ((hasMinPriceIncrement() && !msg.hasMinPriceIncrement()) || (!hasMinPriceIncrement() && msg.hasMinPriceIncrement())) return false;
		if (!(!hasMinPriceIncrement() && !msg.hasMinPriceIncrement()) && !(getMinPriceIncrement()==msg.getMinPriceIncrement())) return false;
		if ((hasUnitOfMeasure() && !msg.hasUnitOfMeasure()) || (!hasUnitOfMeasure() && msg.hasUnitOfMeasure())) return false;
		if (!(!hasUnitOfMeasure() && !msg.hasUnitOfMeasure()) && !FixUtils.equals(getUnitOfMeasure(), msg.getUnitOfMeasure())) return false;
		if ((hasTimeUnit() && !msg.hasTimeUnit()) || (!hasTimeUnit() && msg.hasTimeUnit())) return false;
		if (!(!hasTimeUnit() && !msg.hasTimeUnit()) && !FixUtils.equals(getTimeUnit(), msg.getTimeUnit())) return false;
		if ((hasMinPriceIncrementAmount() && !msg.hasMinPriceIncrementAmount()) || (!hasMinPriceIncrementAmount() && msg.hasMinPriceIncrementAmount())) return false;
		if (!(!hasMinPriceIncrementAmount() && !msg.hasMinPriceIncrementAmount()) && !(getMinPriceIncrementAmount()==msg.getMinPriceIncrementAmount())) return false;
		if ((hasUnitOfMeasureQty() && !msg.hasUnitOfMeasureQty()) || (!hasUnitOfMeasureQty() && msg.hasUnitOfMeasureQty())) return false;
		if (!(!hasUnitOfMeasureQty() && !msg.hasUnitOfMeasureQty()) && !(getUnitOfMeasureQty()==msg.getUnitOfMeasureQty())) return false;
		if ((hasPriceUnitOfMeasure() && !msg.hasPriceUnitOfMeasure()) || (!hasPriceUnitOfMeasure() && msg.hasPriceUnitOfMeasure())) return false;
		if (!(!hasPriceUnitOfMeasure() && !msg.hasPriceUnitOfMeasure()) && !FixUtils.equals(getPriceUnitOfMeasure(), msg.getPriceUnitOfMeasure())) return false;
		if ((hasPriceUnitOfMeasureQty() && !msg.hasPriceUnitOfMeasureQty()) || (!hasPriceUnitOfMeasureQty() && msg.hasPriceUnitOfMeasureQty())) return false;
		if (!(!hasPriceUnitOfMeasureQty() && !msg.hasPriceUnitOfMeasureQty()) && !(getPriceUnitOfMeasureQty()==msg.getPriceUnitOfMeasureQty())) return false;
		if ((hasSettlMethod() && !msg.hasSettlMethod()) || (!hasSettlMethod() && msg.hasSettlMethod())) return false;
		if (!(!hasSettlMethod() && !msg.hasSettlMethod()) && !(getSettlMethod()==msg.getSettlMethod())) return false;
		if ((hasExerciseStyle() && !msg.hasExerciseStyle()) || (!hasExerciseStyle() && msg.hasExerciseStyle())) return false;
		if (!(!hasExerciseStyle() && !msg.hasExerciseStyle()) && !(getExerciseStyle()==msg.getExerciseStyle())) return false;
		if ((hasOptPayoutAmount() && !msg.hasOptPayoutAmount()) || (!hasOptPayoutAmount() && msg.hasOptPayoutAmount())) return false;
		if (!(!hasOptPayoutAmount() && !msg.hasOptPayoutAmount()) && !(getOptPayoutAmount()==msg.getOptPayoutAmount())) return false;
		if ((hasPriceQuoteMethod() && !msg.hasPriceQuoteMethod()) || (!hasPriceQuoteMethod() && msg.hasPriceQuoteMethod())) return false;
		if (!(!hasPriceQuoteMethod() && !msg.hasPriceQuoteMethod()) && !FixUtils.equals(getPriceQuoteMethod(), msg.getPriceQuoteMethod())) return false;
		if ((hasListMethod() && !msg.hasListMethod()) || (!hasListMethod() && msg.hasListMethod())) return false;
		if (!(!hasListMethod() && !msg.hasListMethod()) && !(getListMethod()==msg.getListMethod())) return false;
		if ((hasCapPrice() && !msg.hasCapPrice()) || (!hasCapPrice() && msg.hasCapPrice())) return false;
		if (!(!hasCapPrice() && !msg.hasCapPrice()) && !(getCapPrice()==msg.getCapPrice())) return false;
		if ((hasFloorPrice() && !msg.hasFloorPrice()) || (!hasFloorPrice() && msg.hasFloorPrice())) return false;
		if (!(!hasFloorPrice() && !msg.hasFloorPrice()) && !(getFloorPrice()==msg.getFloorPrice())) return false;
		if ((hasPutOrCall() && !msg.hasPutOrCall()) || (!hasPutOrCall() && msg.hasPutOrCall())) return false;
		if (!(!hasPutOrCall() && !msg.hasPutOrCall()) && !(getPutOrCall()==msg.getPutOrCall())) return false;
		if ((hasFlexibleIndicator() && !msg.hasFlexibleIndicator()) || (!hasFlexibleIndicator() && msg.hasFlexibleIndicator())) return false;
		if (!(!hasFlexibleIndicator() && !msg.hasFlexibleIndicator()) && !(getFlexibleIndicator()==msg.getFlexibleIndicator())) return false;
		if ((hasFlexProductEligibilityIndicator() && !msg.hasFlexProductEligibilityIndicator()) || (!hasFlexProductEligibilityIndicator() && msg.hasFlexProductEligibilityIndicator())) return false;
		if (!(!hasFlexProductEligibilityIndicator() && !msg.hasFlexProductEligibilityIndicator()) && !(getFlexProductEligibilityIndicator()==msg.getFlexProductEligibilityIndicator())) return false;
		if ((hasValuationMethod() && !msg.hasValuationMethod()) || (!hasValuationMethod() && msg.hasValuationMethod())) return false;
		if (!(!hasValuationMethod() && !msg.hasValuationMethod()) && !FixUtils.equals(getValuationMethod(), msg.getValuationMethod())) return false;
		if ((hasContractMultiplierUnit() && !msg.hasContractMultiplierUnit()) || (!hasContractMultiplierUnit() && msg.hasContractMultiplierUnit())) return false;
		if (!(!hasContractMultiplierUnit() && !msg.hasContractMultiplierUnit()) && !(getContractMultiplierUnit()==msg.getContractMultiplierUnit())) return false;
		if ((hasFlowScheduleType() && !msg.hasFlowScheduleType()) || (!hasFlowScheduleType() && msg.hasFlowScheduleType())) return false;
		if (!(!hasFlowScheduleType() && !msg.hasFlowScheduleType()) && !(getFlowScheduleType()==msg.getFlowScheduleType())) return false;
		if ((hasOptPayoutType() && !msg.hasOptPayoutType()) || (!hasOptPayoutType() && msg.hasOptPayoutType())) return false;
		if (!(!hasOptPayoutType() && !msg.hasOptPayoutType()) && !(getOptPayoutType()==msg.getOptPayoutType())) return false;
		if ((hasCouponRate() && !msg.hasCouponRate()) || (!hasCouponRate() && msg.hasCouponRate())) return false;
		if (!(!hasCouponRate() && !msg.hasCouponRate()) && !(getCouponRate()==msg.getCouponRate())) return false;
		if ((hasSecurityExchange() && !msg.hasSecurityExchange()) || (!hasSecurityExchange() && msg.hasSecurityExchange())) return false;
		if (!(!hasSecurityExchange() && !msg.hasSecurityExchange()) && !FixUtils.equals(getSecurityExchange(), msg.getSecurityExchange())) return false;
		if ((hasPositionLimit() && !msg.hasPositionLimit()) || (!hasPositionLimit() && msg.hasPositionLimit())) return false;
		if (!(!hasPositionLimit() && !msg.hasPositionLimit()) && !(getPositionLimit()==msg.getPositionLimit())) return false;
		if ((hasNTPositionLimit() && !msg.hasNTPositionLimit()) || (!hasNTPositionLimit() && msg.hasNTPositionLimit())) return false;
		if (!(!hasNTPositionLimit() && !msg.hasNTPositionLimit()) && !(getNTPositionLimit()==msg.getNTPositionLimit())) return false;
		if ((hasIssuer() && !msg.hasIssuer()) || (!hasIssuer() && msg.hasIssuer())) return false;
		if (!(!hasIssuer() && !msg.hasIssuer()) && !FixUtils.equals(getIssuer(), msg.getIssuer())) return false;
		if ((hasEncodedIssuerLen() && !msg.hasEncodedIssuerLen()) || (!hasEncodedIssuerLen() && msg.hasEncodedIssuerLen())) return false;
		if (!(!hasEncodedIssuerLen() && !msg.hasEncodedIssuerLen()) && !(getEncodedIssuerLen()==msg.getEncodedIssuerLen())) return false;
		if ((hasEncodedIssuer() && !msg.hasEncodedIssuer()) || (!hasEncodedIssuer() && msg.hasEncodedIssuer())) return false;
		if (!(!hasEncodedIssuer() && !msg.hasEncodedIssuer()) && !FixUtils.equals(getEncodedIssuer(), msg.getEncodedIssuer())) return false;
		if ((hasSecurityDesc() && !msg.hasSecurityDesc()) || (!hasSecurityDesc() && msg.hasSecurityDesc())) return false;
		if (!(!hasSecurityDesc() && !msg.hasSecurityDesc()) && !FixUtils.equals(getSecurityDesc(), msg.getSecurityDesc())) return false;
		if ((hasEncodedSecurityDescLen() && !msg.hasEncodedSecurityDescLen()) || (!hasEncodedSecurityDescLen() && msg.hasEncodedSecurityDescLen())) return false;
		if (!(!hasEncodedSecurityDescLen() && !msg.hasEncodedSecurityDescLen()) && !(getEncodedSecurityDescLen()==msg.getEncodedSecurityDescLen())) return false;
		if ((hasEncodedSecurityDesc() && !msg.hasEncodedSecurityDesc()) || (!hasEncodedSecurityDesc() && msg.hasEncodedSecurityDesc())) return false;
		if (!(!hasEncodedSecurityDesc() && !msg.hasEncodedSecurityDesc()) && !FixUtils.equals(getEncodedSecurityDesc(), msg.getEncodedSecurityDesc())) return false;
		if ((hasPool() && !msg.hasPool()) || (!hasPool() && msg.hasPool())) return false;
		if (!(!hasPool() && !msg.hasPool()) && !FixUtils.equals(getPool(), msg.getPool())) return false;
		if ((hasContractSettlMonth() && !msg.hasContractSettlMonth()) || (!hasContractSettlMonth() && msg.hasContractSettlMonth())) return false;
		if (!(!hasContractSettlMonth() && !msg.hasContractSettlMonth()) && !FixUtils.equals(getContractSettlMonth(), msg.getContractSettlMonth())) return false;
		if ((hasCPProgram() && !msg.hasCPProgram()) || (!hasCPProgram() && msg.hasCPProgram())) return false;
		if (!(!hasCPProgram() && !msg.hasCPProgram()) && !(getCPProgram()==msg.getCPProgram())) return false;
		if ((hasCPRegType() && !msg.hasCPRegType()) || (!hasCPRegType() && msg.hasCPRegType())) return false;
		if (!(!hasCPRegType() && !msg.hasCPRegType()) && !FixUtils.equals(getCPRegType(), msg.getCPRegType())) return false;
		if ((hasDatedDate() && !msg.hasDatedDate()) || (!hasDatedDate() && msg.hasDatedDate())) return false;
		if ((hasInterestAccrualDate() && !msg.hasInterestAccrualDate()) || (!hasInterestAccrualDate() && msg.hasInterestAccrualDate())) return false;
		return true;
	}
	public FixInstrument clone ( FixInstrument out ) {
		if ( hasSymbol())
			out.setSymbol(getSymbol());
		if ( hasSymbolSfx())
			out.setSymbolSfx(getSymbolSfx());
		if ( hasSecurityID())
			out.setSecurityID(getSecurityID());
		if ( hasSecurityIDSource())
			out.setSecurityIDSource(getSecurityIDSource());
		if ( hasProduct())
			out.setProduct(getProduct());
		if ( hasSecurityGroup())
			out.setSecurityGroup(getSecurityGroup());
		if ( hasProductComplex())
			out.setProductComplex(getProductComplex());
		if ( hasCFICode())
			out.setCFICode(getCFICode());
		if ( hasSecurityType())
			out.setSecurityType(getSecurityType());
		if ( hasSecuritySubType())
			out.setSecuritySubType(getSecuritySubType());
		if ( hasMaturityMonthYear())
			out.setMaturityMonthYear(getMaturityMonthYear());
		if ( hasMaturityDate())
			out.setMaturityDate(getMaturityDate());
		if ( hasSecurityStatus())
			out.setSecurityStatus(getSecurityStatus());
		if ( hasSettleOnOpenFlag())
			out.setSettleOnOpenFlag(getSettleOnOpenFlag());
		if ( hasInstrmtAssignmentMethod())
			out.setInstrmtAssignmentMethod(getInstrmtAssignmentMethod());
		if ( hasMaturityTime())
			out.setMaturityTime(getMaturityTime());
		if ( hasCouponPaymentDate())
			out.setCouponPaymentDate(getCouponPaymentDate());
		if ( hasRestructuringType())
			out.setRestructuringType(getRestructuringType());
		if ( hasSeniority())
			out.setSeniority(getSeniority());
		if ( hasNotionalPercentageOutstanding())
			out.setNotionalPercentageOutstanding(getNotionalPercentageOutstanding());
		if ( hasOriginalNotionalPercentageOutstanding())
			out.setOriginalNotionalPercentageOutstanding(getOriginalNotionalPercentageOutstanding());
		if ( hasAttachmentPoint())
			out.setAttachmentPoint(getAttachmentPoint());
		if ( hasDetachmentPoint())
			out.setDetachmentPoint(getDetachmentPoint());
		if ( hasIssueDate())
			out.setIssueDate(getIssueDate());
		if ( hasRepoCollateralSecurityType())
			out.setRepoCollateralSecurityType(getRepoCollateralSecurityType());
		if ( hasRepurchaseTerm())
			out.setRepurchaseTerm(getRepurchaseTerm());
		if ( hasRepurchaseRate())
			out.setRepurchaseRate(getRepurchaseRate());
		if ( hasFactor())
			out.setFactor(getFactor());
		if ( hasCreditRating())
			out.setCreditRating(getCreditRating());
		if ( hasInstrRegistry())
			out.setInstrRegistry(getInstrRegistry());
		if ( hasCountryOfIssue())
			out.setCountryOfIssue(getCountryOfIssue());
		if ( hasStateOrProvinceOfIssue())
			out.setStateOrProvinceOfIssue(getStateOrProvinceOfIssue());
		if ( hasLocaleOfIssue())
			out.setLocaleOfIssue(getLocaleOfIssue());
		if ( hasRedemptionDate())
			out.setRedemptionDate(getRedemptionDate());
		if ( hasStrikePrice())
			out.setStrikePrice(getStrikePrice());
		if ( hasStrikeCurrency())
			out.setStrikeCurrency(getStrikeCurrency());
		if ( hasStrikeMultiplier())
			out.setStrikeMultiplier(getStrikeMultiplier());
		if ( hasStrikeValue())
			out.setStrikeValue(getStrikeValue());
		if ( hasStrikePriceDeterminationMethod())
			out.setStrikePriceDeterminationMethod(getStrikePriceDeterminationMethod());
		if ( hasStrikePriceBoundaryMethod())
			out.setStrikePriceBoundaryMethod(getStrikePriceBoundaryMethod());
		if ( hasStrikePriceBoundaryPrecision())
			out.setStrikePriceBoundaryPrecision(getStrikePriceBoundaryPrecision());
		if ( hasUnderlyingPriceDeterminationMethod())
			out.setUnderlyingPriceDeterminationMethod(getUnderlyingPriceDeterminationMethod());
		if ( hasOptAttribute())
			out.setOptAttribute(getOptAttribute());
		if ( hasContractMultiplier())
			out.setContractMultiplier(getContractMultiplier());
		if ( hasMinPriceIncrement())
			out.setMinPriceIncrement(getMinPriceIncrement());
		if ( hasUnitOfMeasure())
			out.setUnitOfMeasure(getUnitOfMeasure());
		if ( hasTimeUnit())
			out.setTimeUnit(getTimeUnit());
		if ( hasMinPriceIncrementAmount())
			out.setMinPriceIncrementAmount(getMinPriceIncrementAmount());
		if ( hasUnitOfMeasureQty())
			out.setUnitOfMeasureQty(getUnitOfMeasureQty());
		if ( hasPriceUnitOfMeasure())
			out.setPriceUnitOfMeasure(getPriceUnitOfMeasure());
		if ( hasPriceUnitOfMeasureQty())
			out.setPriceUnitOfMeasureQty(getPriceUnitOfMeasureQty());
		if ( hasSettlMethod())
			out.setSettlMethod(getSettlMethod());
		if ( hasExerciseStyle())
			out.setExerciseStyle(getExerciseStyle());
		if ( hasOptPayoutAmount())
			out.setOptPayoutAmount(getOptPayoutAmount());
		if ( hasPriceQuoteMethod())
			out.setPriceQuoteMethod(getPriceQuoteMethod());
		if ( hasListMethod())
			out.setListMethod(getListMethod());
		if ( hasCapPrice())
			out.setCapPrice(getCapPrice());
		if ( hasFloorPrice())
			out.setFloorPrice(getFloorPrice());
		if ( hasPutOrCall())
			out.setPutOrCall(getPutOrCall());
		if ( hasFlexibleIndicator())
			out.setFlexibleIndicator(getFlexibleIndicator());
		if ( hasFlexProductEligibilityIndicator())
			out.setFlexProductEligibilityIndicator(getFlexProductEligibilityIndicator());
		if ( hasValuationMethod())
			out.setValuationMethod(getValuationMethod());
		if ( hasContractMultiplierUnit())
			out.setContractMultiplierUnit(getContractMultiplierUnit());
		if ( hasFlowScheduleType())
			out.setFlowScheduleType(getFlowScheduleType());
		if ( hasOptPayoutType())
			out.setOptPayoutType(getOptPayoutType());
		if ( hasCouponRate())
			out.setCouponRate(getCouponRate());
		if ( hasSecurityExchange())
			out.setSecurityExchange(getSecurityExchange());
		if ( hasPositionLimit())
			out.setPositionLimit(getPositionLimit());
		if ( hasNTPositionLimit())
			out.setNTPositionLimit(getNTPositionLimit());
		if ( hasIssuer())
			out.setIssuer(getIssuer());
		if ( hasEncodedIssuerLen())
			out.setEncodedIssuerLen(getEncodedIssuerLen());
		if ( hasEncodedIssuer())
			out.setEncodedIssuer(getEncodedIssuer());
		if ( hasSecurityDesc())
			out.setSecurityDesc(getSecurityDesc());
		if ( hasEncodedSecurityDescLen())
			out.setEncodedSecurityDescLen(getEncodedSecurityDescLen());
		if ( hasEncodedSecurityDesc())
			out.setEncodedSecurityDesc(getEncodedSecurityDesc());
		if ( hasPool())
			out.setPool(getPool());
		if ( hasContractSettlMonth())
			out.setContractSettlMonth(getContractSettlMonth());
		if ( hasCPProgram())
			out.setCPProgram(getCPProgram());
		if ( hasCPRegType())
			out.setCPRegType(getCPRegType());
		if ( hasDatedDate())
			out.setDatedDate(getDatedDate());
		if ( hasInterestAccrualDate())
			out.setInterestAccrualDate(getInterestAccrualDate());
		int count = 0;
		count = 0;
		for (FixSecAltIDGrp fixSecAltIDGrp : secAltIDGrp) {
			if (!fixSecAltIDGrp.hasGroup()) continue;
			out.secAltIDGrp[count] = fixSecAltIDGrp.clone( out.secAltIDGrp[count] );
			count++;
		}
		if (securityXML.hasGroup())
			out.securityXML = securityXML.clone( out.securityXML);
		count = 0;
		for (FixEvntGrp fixEvntGrp : evntGrp) {
			if (!fixEvntGrp.hasGroup()) continue;
			out.evntGrp[count] = fixEvntGrp.clone( out.evntGrp[count] );
			count++;
		}
		count = 0;
		for (FixInstrumentParties fixInstrumentParties : instrumentParties) {
			if (!fixInstrumentParties.hasGroup()) continue;
			out.instrumentParties[count] = fixInstrumentParties.clone( out.instrumentParties[count] );
			count++;
		}
		count = 0;
		for (FixComplexEvents fixComplexEvents : complexEvents) {
			if (!fixComplexEvents.hasGroup()) continue;
			out.complexEvents[count] = fixComplexEvents.clone( out.complexEvents[count] );
			count++;
		}
		return out;
	}

}
