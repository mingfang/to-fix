package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixInstrumentLeg extends FixGroup {
	private short hasLegSymbol;
	byte[] legSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegSymbolSfx;
	byte[] legSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegSecurityID;
	byte[] legSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegSecurityIDSource;
	byte[] legSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegProduct;
	long legProduct = 0;		
	private short hasLegCFICode;
	byte[] legCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegSecurityType;
	byte[] legSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegSecuritySubType;
	byte[] legSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegMaturityMonthYear;
	byte[] legMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegMaturityDate;
	byte[] legMaturityDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegMaturityTime;
	byte[] legMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegCouponPaymentDate;
	byte[] legCouponPaymentDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegIssueDate;
	byte[] legIssueDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegRepoCollateralSecurityType;
	long legRepoCollateralSecurityType = 0;		
	private short hasLegRepurchaseTerm;
	long legRepurchaseTerm = 0;		
	private short hasLegRepurchaseRate;
	long legRepurchaseRate = 0;		
	private short hasLegFactor;
	long legFactor = 0;		
	private short hasLegCreditRating;
	byte[] legCreditRating = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegInstrRegistry;
	byte[] legInstrRegistry = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegCountryOfIssue;
	byte[] legCountryOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegStateOrProvinceOfIssue;
	byte[] legStateOrProvinceOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegLocaleOfIssue;
	byte[] legLocaleOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegRedemptionDate;
	byte[] legRedemptionDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegStrikePrice;
	long legStrikePrice = 0;		
	private short hasLegStrikeCurrency;
	byte[] legStrikeCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasLegOptAttribute;
	byte legOptAttribute = (byte)' ';		
	private short hasLegContractMultiplier;
	long legContractMultiplier = 0;		
	private short hasLegUnitOfMeasure;
	byte[] legUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegTimeUnit;
	byte[] legTimeUnit = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegExerciseStyle;
	long legExerciseStyle = 0;		
	private short hasLegUnitOfMeasureQty;
	long legUnitOfMeasureQty = 0;		
	private short hasLegPriceUnitOfMeasure;
	byte[] legPriceUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegPriceUnitOfMeasureQty;
	long legPriceUnitOfMeasureQty = 0;		
	private short hasLegContractMultiplierUnit;
	long legContractMultiplierUnit = 0;		
	private short hasLegFlowScheduleType;
	long legFlowScheduleType = 0;		
	private short hasLegCouponRate;
	long legCouponRate = 0;		
	private short hasLegSecurityExchange;
	byte[] legSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegIssuer;
	byte[] legIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEncodedLegIssuerLen;
	long encodedLegIssuerLen = 0;		
	private short hasEncodedLegIssuer;
	byte[] encodedLegIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegSecurityDesc;
	byte[] legSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEncodedLegSecurityDescLen;
	long encodedLegSecurityDescLen = 0;		
	private short hasEncodedLegSecurityDesc;
	byte[] encodedLegSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegRatioQty;
	long legRatioQty = 0;		
	private short hasLegSide;
	byte legSide = (byte)' ';		
	private short hasLegCurrency;
	byte[] legCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasLegPool;
	byte[] legPool = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegDatedDate;
	byte[] legDatedDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegContractSettlMonth;
	byte[] legContractSettlMonth = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegInterestAccrualDate;
	byte[] legInterestAccrualDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegOptionRatio;
	long legOptionRatio = 0;		
	private short hasLegPrice;
	long legPrice = 0;		
	private short hasLegPutOrCall;
	long legPutOrCall = 0;		
		public FixLegSecAltIDGrp[] legSecAltIDGrp;
	
	public FixInstrumentLeg() {
		this(false);
	}

	public FixInstrumentLeg(boolean isRequired) {
		super(FixTags.LEGSYMBOL_INT);

		this.isRequired = isRequired;
		
		hasLegSymbol = FixUtils.TAG_HAS_NO_VALUE;		
		legSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;		
		legSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegSecurityID = FixUtils.TAG_HAS_NO_VALUE;		
		legSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		legSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegProduct = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegCFICode = FixUtils.TAG_HAS_NO_VALUE;		
		legCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		legSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;		
		legSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;		
		legMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegMaturityDate = FixUtils.TAG_HAS_NO_VALUE;		
		legMaturityDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegMaturityTime = FixUtils.TAG_HAS_NO_VALUE;		
		legMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegCouponPaymentDate = FixUtils.TAG_HAS_NO_VALUE;		
		legCouponPaymentDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegIssueDate = FixUtils.TAG_HAS_NO_VALUE;		
		legIssueDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegRepoCollateralSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegRepurchaseTerm = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegRepurchaseRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegFactor = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegCreditRating = FixUtils.TAG_HAS_NO_VALUE;		
		legCreditRating = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegInstrRegistry = FixUtils.TAG_HAS_NO_VALUE;		
		legInstrRegistry = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegCountryOfIssue = FixUtils.TAG_HAS_NO_VALUE;		
		legCountryOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegStateOrProvinceOfIssue = FixUtils.TAG_HAS_NO_VALUE;		
		legStateOrProvinceOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegLocaleOfIssue = FixUtils.TAG_HAS_NO_VALUE;		
		legLocaleOfIssue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegRedemptionDate = FixUtils.TAG_HAS_NO_VALUE;		
		legRedemptionDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegStrikeCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		legStrikeCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasLegOptAttribute = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;		
		legUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegTimeUnit = FixUtils.TAG_HAS_NO_VALUE;		
		legTimeUnit = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegPriceUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;		
		legPriceUnitOfMeasure = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegPriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;		
		legSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegIssuer = FixUtils.TAG_HAS_NO_VALUE;		
		legIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEncodedLegIssuerLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedLegIssuer = FixUtils.TAG_HAS_NO_VALUE;		
		encodedLegIssuer = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		legSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEncodedLegSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedLegSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		encodedLegSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegRatioQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		legCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasLegPool = FixUtils.TAG_HAS_NO_VALUE;		
		legPool = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegDatedDate = FixUtils.TAG_HAS_NO_VALUE;		
		legDatedDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegContractSettlMonth = FixUtils.TAG_HAS_NO_VALUE;		
		legContractSettlMonth = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegInterestAccrualDate = FixUtils.TAG_HAS_NO_VALUE;		
		legInterestAccrualDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegOptionRatio = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		legSecAltIDGrp = new FixLegSecAltIDGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) legSecAltIDGrp[i] = new FixLegSecAltIDGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasLegSymbol()) return true;
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
            	case FixTags.LEGSYMBOL_INT:		
            		hasLegSymbol = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSYMBOLSFX_INT:		
            		hasLegSymbolSfx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSECURITYID_INT:		
            		hasLegSecurityID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSECURITYIDSOURCE_INT:		
            		hasLegSecurityIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGPRODUCT_INT:		
            		hasLegProduct = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGCFICODE_INT:		
            		hasLegCFICode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSECURITYTYPE_INT:		
            		hasLegSecurityType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSECURITYSUBTYPE_INT:		
            		hasLegSecuritySubType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGMATURITYMONTHYEAR_INT:		
            		hasLegMaturityMonthYear = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGMATURITYDATE_INT:		
            		hasLegMaturityDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGMATURITYTIME_INT:		
            		hasLegMaturityTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGCOUPONPAYMENTDATE_INT:		
            		hasLegCouponPaymentDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGISSUEDATE_INT:		
            		hasLegIssueDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGREPOCOLLATERALSECURITYTYPE_INT:		
            		hasLegRepoCollateralSecurityType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGREPURCHASETERM_INT:		
            		hasLegRepurchaseTerm = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGREPURCHASERATE_INT:		
            		hasLegRepurchaseRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGFACTOR_INT:		
            		hasLegFactor = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGCREDITRATING_INT:		
            		hasLegCreditRating = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGINSTRREGISTRY_INT:		
            		hasLegInstrRegistry = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGCOUNTRYOFISSUE_INT:		
            		hasLegCountryOfIssue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSTATEORPROVINCEOFISSUE_INT:		
            		hasLegStateOrProvinceOfIssue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGLOCALEOFISSUE_INT:		
            		hasLegLocaleOfIssue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGREDEMPTIONDATE_INT:		
            		hasLegRedemptionDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSTRIKEPRICE_INT:		
            		hasLegStrikePrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSTRIKECURRENCY_INT:		
            		hasLegStrikeCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGOPTATTRIBUTE_INT:		
            		hasLegOptAttribute = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGCONTRACTMULTIPLIER_INT:		
            		hasLegContractMultiplier = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGUNITOFMEASURE_INT:		
            		hasLegUnitOfMeasure = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGTIMEUNIT_INT:		
            		hasLegTimeUnit = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGEXERCISESTYLE_INT:		
            		hasLegExerciseStyle = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGUNITOFMEASUREQTY_INT:		
            		hasLegUnitOfMeasureQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGPRICEUNITOFMEASURE_INT:		
            		hasLegPriceUnitOfMeasure = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGPRICEUNITOFMEASUREQTY_INT:		
            		hasLegPriceUnitOfMeasureQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGCONTRACTMULTIPLIERUNIT_INT:		
            		hasLegContractMultiplierUnit = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGFLOWSCHEDULETYPE_INT:		
            		hasLegFlowScheduleType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGCOUPONRATE_INT:		
            		hasLegCouponRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSECURITYEXCHANGE_INT:		
            		hasLegSecurityExchange = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGISSUER_INT:		
            		hasLegIssuer = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDLEGISSUERLEN_INT:		
            		hasEncodedLegIssuerLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDLEGISSUER_INT:		
            		hasEncodedLegIssuer = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSECURITYDESC_INT:		
            		hasLegSecurityDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDLEGSECURITYDESCLEN_INT:		
            		hasEncodedLegSecurityDescLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDLEGSECURITYDESC_INT:		
            		hasEncodedLegSecurityDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGRATIOQTY_INT:		
            		hasLegRatioQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSIDE_INT:		
            		hasLegSide = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGCURRENCY_INT:		
            		hasLegCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGPOOL_INT:		
            		hasLegPool = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGDATEDDATE_INT:		
            		hasLegDatedDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGCONTRACTSETTLMONTH_INT:		
            		hasLegContractSettlMonth = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGINTERESTACCRUALDATE_INT:		
            		hasLegInterestAccrualDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGOPTIONRATIO_INT:		
            		hasLegOptionRatio = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGPRICE_INT:		
            		hasLegPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGPUTORCALL_INT:		
            		hasLegPutOrCall = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOLEGSECURITYALTID_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !legSecAltIDGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = legSecAltIDGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasLegSymbol = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSecurityID = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasLegProduct = FixUtils.TAG_HAS_NO_VALUE;
		hasLegCFICode = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSecurityType = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;
		hasLegMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;
		hasLegMaturityDate = FixUtils.TAG_HAS_NO_VALUE;
		hasLegMaturityTime = FixUtils.TAG_HAS_NO_VALUE;
		hasLegCouponPaymentDate = FixUtils.TAG_HAS_NO_VALUE;
		hasLegIssueDate = FixUtils.TAG_HAS_NO_VALUE;
		hasLegRepoCollateralSecurityType = FixUtils.TAG_HAS_NO_VALUE;
		hasLegRepurchaseTerm = FixUtils.TAG_HAS_NO_VALUE;
		hasLegRepurchaseRate = FixUtils.TAG_HAS_NO_VALUE;
		hasLegFactor = FixUtils.TAG_HAS_NO_VALUE;
		hasLegCreditRating = FixUtils.TAG_HAS_NO_VALUE;
		hasLegInstrRegistry = FixUtils.TAG_HAS_NO_VALUE;
		hasLegCountryOfIssue = FixUtils.TAG_HAS_NO_VALUE;
		hasLegStateOrProvinceOfIssue = FixUtils.TAG_HAS_NO_VALUE;
		hasLegLocaleOfIssue = FixUtils.TAG_HAS_NO_VALUE;
		hasLegRedemptionDate = FixUtils.TAG_HAS_NO_VALUE;
		hasLegStrikePrice = FixUtils.TAG_HAS_NO_VALUE;
		hasLegStrikeCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasLegOptAttribute = FixUtils.TAG_HAS_NO_VALUE;
		hasLegContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;
		hasLegUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;
		hasLegTimeUnit = FixUtils.TAG_HAS_NO_VALUE;
		hasLegExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;
		hasLegUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;
		hasLegPriceUnitOfMeasure = FixUtils.TAG_HAS_NO_VALUE;
		hasLegPriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;
		hasLegContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;
		hasLegFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;
		hasLegCouponRate = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;
		hasLegIssuer = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedLegIssuerLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedLegIssuer = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedLegSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedLegSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasLegRatioQty = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSide = FixUtils.TAG_HAS_NO_VALUE;
		hasLegCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasLegPool = FixUtils.TAG_HAS_NO_VALUE;
		hasLegDatedDate = FixUtils.TAG_HAS_NO_VALUE;
		hasLegContractSettlMonth = FixUtils.TAG_HAS_NO_VALUE;
		hasLegInterestAccrualDate = FixUtils.TAG_HAS_NO_VALUE;
		hasLegOptionRatio = FixUtils.TAG_HAS_NO_VALUE;
		hasLegPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasLegPutOrCall = FixUtils.TAG_HAS_NO_VALUE;
		for (FixLegSecAltIDGrp fixLegSecAltIDGrp : legSecAltIDGrp) fixLegSecAltIDGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasLegSymbol()) {		
			out.put(FixTags.LEGSYMBOL);

			out.put((byte) '=');

			FixUtils.put(out,legSymbol); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSymbolSfx()) {		
			out.put(FixTags.LEGSYMBOLSFX);

			out.put((byte) '=');

			FixUtils.put(out,legSymbolSfx); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSecurityID()) {		
			out.put(FixTags.LEGSECURITYID);

			out.put((byte) '=');

			FixUtils.put(out,legSecurityID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSecurityIDSource()) {		
			out.put(FixTags.LEGSECURITYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,legSecurityIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegProduct()) {		
			out.put(FixTags.LEGPRODUCT);

			out.put((byte) '=');

			FixUtils.put(out, (long)legProduct);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegCFICode()) {		
			out.put(FixTags.LEGCFICODE);

			out.put((byte) '=');

			FixUtils.put(out,legCFICode); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSecurityType()) {		
			out.put(FixTags.LEGSECURITYTYPE);

			out.put((byte) '=');

			FixUtils.put(out,legSecurityType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSecuritySubType()) {		
			out.put(FixTags.LEGSECURITYSUBTYPE);

			out.put((byte) '=');

			FixUtils.put(out,legSecuritySubType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegMaturityMonthYear()) {		
			out.put(FixTags.LEGMATURITYMONTHYEAR);

			out.put((byte) '=');

			FixUtils.put(out,legMaturityMonthYear); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegMaturityDate()) {		
			out.put(FixTags.LEGMATURITYDATE);

			out.put((byte) '=');

			FixUtils.put(out,legMaturityDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegMaturityTime()) {		
			out.put(FixTags.LEGMATURITYTIME);

			out.put((byte) '=');

			FixUtils.put(out,legMaturityTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegCouponPaymentDate()) {		
			out.put(FixTags.LEGCOUPONPAYMENTDATE);

			out.put((byte) '=');

			FixUtils.put(out,legCouponPaymentDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegIssueDate()) {		
			out.put(FixTags.LEGISSUEDATE);

			out.put((byte) '=');

			FixUtils.put(out,legIssueDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegRepoCollateralSecurityType()) {		
			out.put(FixTags.LEGREPOCOLLATERALSECURITYTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)legRepoCollateralSecurityType);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegRepurchaseTerm()) {		
			out.put(FixTags.LEGREPURCHASETERM);

			out.put((byte) '=');

			FixUtils.put(out, (long)legRepurchaseTerm);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegRepurchaseRate()) {		
			out.put(FixTags.LEGREPURCHASERATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)legRepurchaseRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegFactor()) {		
			out.put(FixTags.LEGFACTOR);

			out.put((byte) '=');

			FixUtils.put(out, (long)legFactor);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegCreditRating()) {		
			out.put(FixTags.LEGCREDITRATING);

			out.put((byte) '=');

			FixUtils.put(out,legCreditRating); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegInstrRegistry()) {		
			out.put(FixTags.LEGINSTRREGISTRY);

			out.put((byte) '=');

			FixUtils.put(out,legInstrRegistry); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegCountryOfIssue()) {		
			out.put(FixTags.LEGCOUNTRYOFISSUE);

			out.put((byte) '=');

			FixUtils.put(out,legCountryOfIssue); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegStateOrProvinceOfIssue()) {		
			out.put(FixTags.LEGSTATEORPROVINCEOFISSUE);

			out.put((byte) '=');

			FixUtils.put(out,legStateOrProvinceOfIssue); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegLocaleOfIssue()) {		
			out.put(FixTags.LEGLOCALEOFISSUE);

			out.put((byte) '=');

			FixUtils.put(out,legLocaleOfIssue); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegRedemptionDate()) {		
			out.put(FixTags.LEGREDEMPTIONDATE);

			out.put((byte) '=');

			FixUtils.put(out,legRedemptionDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegStrikePrice()) {		
			out.put(FixTags.LEGSTRIKEPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)legStrikePrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegStrikeCurrency()) {		
			out.put(FixTags.LEGSTRIKECURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,legStrikeCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegOptAttribute()) {		
			out.put(FixTags.LEGOPTATTRIBUTE);

			out.put((byte) '=');

			FixUtils.put(out,legOptAttribute); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegContractMultiplier()) {		
			out.put(FixTags.LEGCONTRACTMULTIPLIER);

			out.put((byte) '=');

			FixUtils.put(out, (long)legContractMultiplier);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegUnitOfMeasure()) {		
			out.put(FixTags.LEGUNITOFMEASURE);

			out.put((byte) '=');

			FixUtils.put(out,legUnitOfMeasure); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegTimeUnit()) {		
			out.put(FixTags.LEGTIMEUNIT);

			out.put((byte) '=');

			FixUtils.put(out,legTimeUnit); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegExerciseStyle()) {		
			out.put(FixTags.LEGEXERCISESTYLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)legExerciseStyle);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegUnitOfMeasureQty()) {		
			out.put(FixTags.LEGUNITOFMEASUREQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)legUnitOfMeasureQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegPriceUnitOfMeasure()) {		
			out.put(FixTags.LEGPRICEUNITOFMEASURE);

			out.put((byte) '=');

			FixUtils.put(out,legPriceUnitOfMeasure); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegPriceUnitOfMeasureQty()) {		
			out.put(FixTags.LEGPRICEUNITOFMEASUREQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)legPriceUnitOfMeasureQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegContractMultiplierUnit()) {		
			out.put(FixTags.LEGCONTRACTMULTIPLIERUNIT);

			out.put((byte) '=');

			FixUtils.put(out, (long)legContractMultiplierUnit);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegFlowScheduleType()) {		
			out.put(FixTags.LEGFLOWSCHEDULETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)legFlowScheduleType);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegCouponRate()) {		
			out.put(FixTags.LEGCOUPONRATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)legCouponRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSecurityExchange()) {		
			out.put(FixTags.LEGSECURITYEXCHANGE);

			out.put((byte) '=');

			FixUtils.put(out,legSecurityExchange); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegIssuer()) {		
			out.put(FixTags.LEGISSUER);

			out.put((byte) '=');

			FixUtils.put(out,legIssuer); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedLegIssuerLen()) {		
			out.put(FixTags.ENCODEDLEGISSUERLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)encodedLegIssuerLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedLegIssuer()) {		
			out.put(FixTags.ENCODEDLEGISSUER);

			out.put((byte) '=');

			FixUtils.put(out,encodedLegIssuer); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSecurityDesc()) {		
			out.put(FixTags.LEGSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,legSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedLegSecurityDescLen()) {		
			out.put(FixTags.ENCODEDLEGSECURITYDESCLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)encodedLegSecurityDescLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedLegSecurityDesc()) {		
			out.put(FixTags.ENCODEDLEGSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,encodedLegSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegRatioQty()) {		
			out.put(FixTags.LEGRATIOQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)legRatioQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSide()) {		
			out.put(FixTags.LEGSIDE);

			out.put((byte) '=');

			FixUtils.put(out,legSide); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegCurrency()) {		
			out.put(FixTags.LEGCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,legCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegPool()) {		
			out.put(FixTags.LEGPOOL);

			out.put((byte) '=');

			FixUtils.put(out,legPool); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegDatedDate()) {		
			out.put(FixTags.LEGDATEDDATE);

			out.put((byte) '=');

			FixUtils.put(out,legDatedDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegContractSettlMonth()) {		
			out.put(FixTags.LEGCONTRACTSETTLMONTH);

			out.put((byte) '=');

			FixUtils.put(out,legContractSettlMonth); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegInterestAccrualDate()) {		
			out.put(FixTags.LEGINTERESTACCRUALDATE);

			out.put((byte) '=');

			FixUtils.put(out,legInterestAccrualDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegOptionRatio()) {		
			out.put(FixTags.LEGOPTIONRATIO);

			out.put((byte) '=');

			FixUtils.put(out, (long)legOptionRatio);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegPrice()) {		
			out.put(FixTags.LEGPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)legPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegPutOrCall()) {		
			out.put(FixTags.LEGPUTORCALL);

			out.put((byte) '=');

			FixUtils.put(out, (long)legPutOrCall);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(legSecAltIDGrp)>0) {
			out.put(FixTags.NOLEGSECURITYALTID);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(legSecAltIDGrp));

			out.put(FixUtils.SOH);

		}
		for (FixLegSecAltIDGrp fixLegSecAltIDGrp : legSecAltIDGrp) if (fixLegSecAltIDGrp.hasGroup()) fixLegSecAltIDGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasLegSymbol()) {		
			FixUtils.put(out,legSymbol); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSymbolSfx()) {		
			FixUtils.put(out,legSymbolSfx); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSecurityID()) {		
			FixUtils.put(out,legSecurityID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSecurityIDSource()) {		
			FixUtils.put(out,legSecurityIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegProduct()) {		
			FixUtils.put(out, (long)legProduct);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegCFICode()) {		
			FixUtils.put(out,legCFICode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSecurityType()) {		
			FixUtils.put(out,legSecurityType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSecuritySubType()) {		
			FixUtils.put(out,legSecuritySubType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegMaturityMonthYear()) {		
			FixUtils.put(out,legMaturityMonthYear); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegMaturityDate()) {		
			FixUtils.put(out,legMaturityDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegMaturityTime()) {		
			FixUtils.put(out,legMaturityTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegCouponPaymentDate()) {		
			FixUtils.put(out,legCouponPaymentDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegIssueDate()) {		
			FixUtils.put(out,legIssueDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegRepoCollateralSecurityType()) {		
			FixUtils.put(out, (long)legRepoCollateralSecurityType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegRepurchaseTerm()) {		
			FixUtils.put(out, (long)legRepurchaseTerm);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegRepurchaseRate()) {		
			FixUtils.put(out, (long)legRepurchaseRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegFactor()) {		
			FixUtils.put(out, (long)legFactor);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegCreditRating()) {		
			FixUtils.put(out,legCreditRating); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegInstrRegistry()) {		
			FixUtils.put(out,legInstrRegistry); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegCountryOfIssue()) {		
			FixUtils.put(out,legCountryOfIssue); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegStateOrProvinceOfIssue()) {		
			FixUtils.put(out,legStateOrProvinceOfIssue); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegLocaleOfIssue()) {		
			FixUtils.put(out,legLocaleOfIssue); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegRedemptionDate()) {		
			FixUtils.put(out,legRedemptionDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegStrikePrice()) {		
			FixUtils.put(out, (long)legStrikePrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegStrikeCurrency()) {		
			FixUtils.put(out,legStrikeCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegOptAttribute()) {		
			FixUtils.put(out,legOptAttribute); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegContractMultiplier()) {		
			FixUtils.put(out, (long)legContractMultiplier);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegUnitOfMeasure()) {		
			FixUtils.put(out,legUnitOfMeasure); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegTimeUnit()) {		
			FixUtils.put(out,legTimeUnit); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegExerciseStyle()) {		
			FixUtils.put(out, (long)legExerciseStyle);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegUnitOfMeasureQty()) {		
			FixUtils.put(out, (long)legUnitOfMeasureQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegPriceUnitOfMeasure()) {		
			FixUtils.put(out,legPriceUnitOfMeasure); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegPriceUnitOfMeasureQty()) {		
			FixUtils.put(out, (long)legPriceUnitOfMeasureQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegContractMultiplierUnit()) {		
			FixUtils.put(out, (long)legContractMultiplierUnit);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegFlowScheduleType()) {		
			FixUtils.put(out, (long)legFlowScheduleType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegCouponRate()) {		
			FixUtils.put(out, (long)legCouponRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSecurityExchange()) {		
			FixUtils.put(out,legSecurityExchange); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegIssuer()) {		
			FixUtils.put(out,legIssuer); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedLegIssuerLen()) {		
			FixUtils.put(out, (long)encodedLegIssuerLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedLegIssuer()) {		
			FixUtils.put(out,encodedLegIssuer); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSecurityDesc()) {		
			FixUtils.put(out,legSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedLegSecurityDescLen()) {		
			FixUtils.put(out, (long)encodedLegSecurityDescLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedLegSecurityDesc()) {		
			FixUtils.put(out,encodedLegSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegRatioQty()) {		
			FixUtils.put(out, (long)legRatioQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSide()) {		
			FixUtils.put(out,legSide); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegCurrency()) {		
			FixUtils.put(out,legCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegPool()) {		
			FixUtils.put(out,legPool); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegDatedDate()) {		
			FixUtils.put(out,legDatedDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegContractSettlMonth()) {		
			FixUtils.put(out,legContractSettlMonth); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegInterestAccrualDate()) {		
			FixUtils.put(out,legInterestAccrualDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegOptionRatio()) {		
			FixUtils.put(out, (long)legOptionRatio);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegPrice()) {		
			FixUtils.put(out, (long)legPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegPutOrCall()) {		
			FixUtils.put(out, (long)legPutOrCall);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixLegSecAltIDGrp fixLegSecAltIDGrp : legSecAltIDGrp) fixLegSecAltIDGrp.printBuffer(out);
	}

	public byte[] getLegSymbol() { 		
		if ( hasLegSymbol()) {		
			if (hasLegSymbol == FixUtils.TAG_HAS_VALUE) {		
				return legSymbol; 		
			} else {		
		
				buf.position(hasLegSymbol);		
		
			FixMessage.getTagStringValue(buf, legSymbol, 0, legSymbol.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSymbol);		
					return null;		
				}		
			}		
			hasLegSymbol = FixUtils.TAG_HAS_VALUE;		
			return legSymbol;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegSymbol() { return hasLegSymbol != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSymbol(byte[] src) {		
		if (src == null ) return;
		if (hasLegSymbol()) FixUtils.fillSpace(legSymbol);		
		FixUtils.copy(legSymbol, src); 		
		hasLegSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSymbol(String str) {		
		if (str == null ) return;
		if (hasLegSymbol()) FixUtils.fillSpace(legSymbol);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSymbol, src); 		
		hasLegSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegSymbolSfx() { 		
		if ( hasLegSymbolSfx()) {		
			if (hasLegSymbolSfx == FixUtils.TAG_HAS_VALUE) {		
				return legSymbolSfx; 		
			} else {		
		
				buf.position(hasLegSymbolSfx);		
		
			FixMessage.getTagStringValue(buf, legSymbolSfx, 0, legSymbolSfx.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSymbolSfx);		
					return null;		
				}		
			}		
			hasLegSymbolSfx = FixUtils.TAG_HAS_VALUE;		
			return legSymbolSfx;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegSymbolSfx() { return hasLegSymbolSfx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSymbolSfx(byte[] src) {		
		if (src == null ) return;
		if (hasLegSymbolSfx()) FixUtils.fillSpace(legSymbolSfx);		
		FixUtils.copy(legSymbolSfx, src); 		
		hasLegSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSymbolSfx(String str) {		
		if (str == null ) return;
		if (hasLegSymbolSfx()) FixUtils.fillSpace(legSymbolSfx);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSymbolSfx, src); 		
		hasLegSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegSecurityID() { 		
		if ( hasLegSecurityID()) {		
			if (hasLegSecurityID == FixUtils.TAG_HAS_VALUE) {		
				return legSecurityID; 		
			} else {		
		
				buf.position(hasLegSecurityID);		
		
			FixMessage.getTagStringValue(buf, legSecurityID, 0, legSecurityID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSecurityID);		
					return null;		
				}		
			}		
			hasLegSecurityID = FixUtils.TAG_HAS_VALUE;		
			return legSecurityID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegSecurityID() { return hasLegSecurityID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSecurityID(byte[] src) {		
		if (src == null ) return;
		if (hasLegSecurityID()) FixUtils.fillSpace(legSecurityID);		
		FixUtils.copy(legSecurityID, src); 		
		hasLegSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSecurityID(String str) {		
		if (str == null ) return;
		if (hasLegSecurityID()) FixUtils.fillSpace(legSecurityID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSecurityID, src); 		
		hasLegSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegSecurityIDSource() { 		
		if ( hasLegSecurityIDSource()) {		
			if (hasLegSecurityIDSource == FixUtils.TAG_HAS_VALUE) {		
				return legSecurityIDSource; 		
			} else {		
		
				buf.position(hasLegSecurityIDSource);		
		
			FixMessage.getTagStringValue(buf, legSecurityIDSource, 0, legSecurityIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSecurityIDSource);		
					return null;		
				}		
			}		
			hasLegSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
			return legSecurityIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegSecurityIDSource() { return hasLegSecurityIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSecurityIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasLegSecurityIDSource()) FixUtils.fillSpace(legSecurityIDSource);		
		FixUtils.copy(legSecurityIDSource, src); 		
		hasLegSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSecurityIDSource(String str) {		
		if (str == null ) return;
		if (hasLegSecurityIDSource()) FixUtils.fillSpace(legSecurityIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSecurityIDSource, src); 		
		hasLegSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegProduct() { 		
		if ( hasLegProduct()) {		
			if (hasLegProduct == FixUtils.TAG_HAS_VALUE) {		
				return legProduct; 		
			} else {		
		
				buf.position(hasLegProduct);		
		
			legProduct = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegProduct);		
					return 0;		
				}		
			}		
			hasLegProduct = FixUtils.TAG_HAS_VALUE;		
			return legProduct;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegProduct() { return hasLegProduct != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegProduct(long src) {		
		legProduct = src;
		hasLegProduct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegProduct(byte[] src) {		
		if (src == null ) return;
		if (hasLegProduct()) legProduct = FixUtils.TAG_HAS_NO_VALUE;		
		legProduct = FixUtils.longValueOf(src, 0, src.length);
		hasLegProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegProduct(String str) {		
		if (str == null ) return;
		if (hasLegProduct()) legProduct = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legProduct = FixUtils.longValueOf(src, 0, src.length);
		hasLegProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegCFICode() { 		
		if ( hasLegCFICode()) {		
			if (hasLegCFICode == FixUtils.TAG_HAS_VALUE) {		
				return legCFICode; 		
			} else {		
		
				buf.position(hasLegCFICode);		
		
			FixMessage.getTagStringValue(buf, legCFICode, 0, legCFICode.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegCFICode);		
					return null;		
				}		
			}		
			hasLegCFICode = FixUtils.TAG_HAS_VALUE;		
			return legCFICode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegCFICode() { return hasLegCFICode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegCFICode(byte[] src) {		
		if (src == null ) return;
		if (hasLegCFICode()) FixUtils.fillSpace(legCFICode);		
		FixUtils.copy(legCFICode, src); 		
		hasLegCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegCFICode(String str) {		
		if (str == null ) return;
		if (hasLegCFICode()) FixUtils.fillSpace(legCFICode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legCFICode, src); 		
		hasLegCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegSecurityType() { 		
		if ( hasLegSecurityType()) {		
			if (hasLegSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return legSecurityType; 		
			} else {		
		
				buf.position(hasLegSecurityType);		
		
			FixMessage.getTagStringValue(buf, legSecurityType, 0, legSecurityType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSecurityType);		
					return null;		
				}		
			}		
			hasLegSecurityType = FixUtils.TAG_HAS_VALUE;		
			return legSecurityType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegSecurityType() { return hasLegSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasLegSecurityType()) FixUtils.fillSpace(legSecurityType);		
		FixUtils.copy(legSecurityType, src); 		
		hasLegSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSecurityType(String str) {		
		if (str == null ) return;
		if (hasLegSecurityType()) FixUtils.fillSpace(legSecurityType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSecurityType, src); 		
		hasLegSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegSecuritySubType() { 		
		if ( hasLegSecuritySubType()) {		
			if (hasLegSecuritySubType == FixUtils.TAG_HAS_VALUE) {		
				return legSecuritySubType; 		
			} else {		
		
				buf.position(hasLegSecuritySubType);		
		
			FixMessage.getTagStringValue(buf, legSecuritySubType, 0, legSecuritySubType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSecuritySubType);		
					return null;		
				}		
			}		
			hasLegSecuritySubType = FixUtils.TAG_HAS_VALUE;		
			return legSecuritySubType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegSecuritySubType() { return hasLegSecuritySubType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSecuritySubType(byte[] src) {		
		if (src == null ) return;
		if (hasLegSecuritySubType()) FixUtils.fillSpace(legSecuritySubType);		
		FixUtils.copy(legSecuritySubType, src); 		
		hasLegSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSecuritySubType(String str) {		
		if (str == null ) return;
		if (hasLegSecuritySubType()) FixUtils.fillSpace(legSecuritySubType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSecuritySubType, src); 		
		hasLegSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegMaturityMonthYear() { 		
		if ( hasLegMaturityMonthYear()) {		
			if (hasLegMaturityMonthYear == FixUtils.TAG_HAS_VALUE) {		
				return legMaturityMonthYear; 		
			} else {		
		
				buf.position(hasLegMaturityMonthYear);		
		
			FixMessage.getTagStringValue(buf, legMaturityMonthYear, 0, legMaturityMonthYear.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegMaturityMonthYear);		
					return null;		
				}		
			}		
			hasLegMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
			return legMaturityMonthYear;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegMaturityMonthYear() { return hasLegMaturityMonthYear != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegMaturityMonthYear(byte[] src) {		
		if (src == null ) return;
		if (hasLegMaturityMonthYear()) FixUtils.fillSpace(legMaturityMonthYear);		
		FixUtils.copy(legMaturityMonthYear, src); 		
		hasLegMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegMaturityMonthYear(String str) {		
		if (str == null ) return;
		if (hasLegMaturityMonthYear()) FixUtils.fillSpace(legMaturityMonthYear);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legMaturityMonthYear, src); 		
		hasLegMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegMaturityDate() { 		
		if ( hasLegMaturityDate()) {		
			if (hasLegMaturityDate == FixUtils.TAG_HAS_VALUE) {		
				return legMaturityDate; 		
			} else {		
		
				buf.position(hasLegMaturityDate);		
		
			FixMessage.getTagStringValue(buf, legMaturityDate, 0, legMaturityDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegMaturityDate);		
					return null;		
				}		
			}		
			hasLegMaturityDate = FixUtils.TAG_HAS_VALUE;		
			return legMaturityDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegMaturityDate() { return hasLegMaturityDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegMaturityDate(byte[] src) {		
		if (src == null ) return;
		if (hasLegMaturityDate()) FixUtils.fillSpace(legMaturityDate);		
		FixUtils.copy(legMaturityDate, src); 		
		hasLegMaturityDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegMaturityDate(String str) {		
		if (str == null ) return;
		if (hasLegMaturityDate()) FixUtils.fillSpace(legMaturityDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legMaturityDate, src); 		
		hasLegMaturityDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegMaturityTime() { 		
		if ( hasLegMaturityTime()) {		
			if (hasLegMaturityTime == FixUtils.TAG_HAS_VALUE) {		
				return legMaturityTime; 		
			} else {		
		
				buf.position(hasLegMaturityTime);		
		
			FixMessage.getTagStringValue(buf, legMaturityTime, 0, legMaturityTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegMaturityTime);		
					return null;		
				}		
			}		
			hasLegMaturityTime = FixUtils.TAG_HAS_VALUE;		
			return legMaturityTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegMaturityTime() { return hasLegMaturityTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegMaturityTime(byte[] src) {		
		if (src == null ) return;
		if (hasLegMaturityTime()) FixUtils.fillSpace(legMaturityTime);		
		FixUtils.copy(legMaturityTime, src); 		
		hasLegMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegMaturityTime(String str) {		
		if (str == null ) return;
		if (hasLegMaturityTime()) FixUtils.fillSpace(legMaturityTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legMaturityTime, src); 		
		hasLegMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegCouponPaymentDate() { 		
		if ( hasLegCouponPaymentDate()) {		
			if (hasLegCouponPaymentDate == FixUtils.TAG_HAS_VALUE) {		
				return legCouponPaymentDate; 		
			} else {		
		
				buf.position(hasLegCouponPaymentDate);		
		
			FixMessage.getTagStringValue(buf, legCouponPaymentDate, 0, legCouponPaymentDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegCouponPaymentDate);		
					return null;		
				}		
			}		
			hasLegCouponPaymentDate = FixUtils.TAG_HAS_VALUE;		
			return legCouponPaymentDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegCouponPaymentDate() { return hasLegCouponPaymentDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegCouponPaymentDate(byte[] src) {		
		if (src == null ) return;
		if (hasLegCouponPaymentDate()) FixUtils.fillSpace(legCouponPaymentDate);		
		FixUtils.copy(legCouponPaymentDate, src); 		
		hasLegCouponPaymentDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegCouponPaymentDate(String str) {		
		if (str == null ) return;
		if (hasLegCouponPaymentDate()) FixUtils.fillSpace(legCouponPaymentDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legCouponPaymentDate, src); 		
		hasLegCouponPaymentDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegIssueDate() { 		
		if ( hasLegIssueDate()) {		
			if (hasLegIssueDate == FixUtils.TAG_HAS_VALUE) {		
				return legIssueDate; 		
			} else {		
		
				buf.position(hasLegIssueDate);		
		
			FixMessage.getTagStringValue(buf, legIssueDate, 0, legIssueDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegIssueDate);		
					return null;		
				}		
			}		
			hasLegIssueDate = FixUtils.TAG_HAS_VALUE;		
			return legIssueDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegIssueDate() { return hasLegIssueDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegIssueDate(byte[] src) {		
		if (src == null ) return;
		if (hasLegIssueDate()) FixUtils.fillSpace(legIssueDate);		
		FixUtils.copy(legIssueDate, src); 		
		hasLegIssueDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegIssueDate(String str) {		
		if (str == null ) return;
		if (hasLegIssueDate()) FixUtils.fillSpace(legIssueDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legIssueDate, src); 		
		hasLegIssueDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegRepoCollateralSecurityType() { 		
		if ( hasLegRepoCollateralSecurityType()) {		
			if (hasLegRepoCollateralSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return legRepoCollateralSecurityType; 		
			} else {		
		
				buf.position(hasLegRepoCollateralSecurityType);		
		
			legRepoCollateralSecurityType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegRepoCollateralSecurityType);		
					return 0;		
				}		
			}		
			hasLegRepoCollateralSecurityType = FixUtils.TAG_HAS_VALUE;		
			return legRepoCollateralSecurityType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegRepoCollateralSecurityType() { return hasLegRepoCollateralSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegRepoCollateralSecurityType(long src) {		
		legRepoCollateralSecurityType = src;
		hasLegRepoCollateralSecurityType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegRepoCollateralSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasLegRepoCollateralSecurityType()) legRepoCollateralSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		legRepoCollateralSecurityType = FixUtils.longValueOf(src, 0, src.length);
		hasLegRepoCollateralSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegRepoCollateralSecurityType(String str) {		
		if (str == null ) return;
		if (hasLegRepoCollateralSecurityType()) legRepoCollateralSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legRepoCollateralSecurityType = FixUtils.longValueOf(src, 0, src.length);
		hasLegRepoCollateralSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegRepurchaseTerm() { 		
		if ( hasLegRepurchaseTerm()) {		
			if (hasLegRepurchaseTerm == FixUtils.TAG_HAS_VALUE) {		
				return legRepurchaseTerm; 		
			} else {		
		
				buf.position(hasLegRepurchaseTerm);		
		
			legRepurchaseTerm = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegRepurchaseTerm);		
					return 0;		
				}		
			}		
			hasLegRepurchaseTerm = FixUtils.TAG_HAS_VALUE;		
			return legRepurchaseTerm;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegRepurchaseTerm() { return hasLegRepurchaseTerm != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegRepurchaseTerm(long src) {		
		legRepurchaseTerm = src;
		hasLegRepurchaseTerm = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegRepurchaseTerm(byte[] src) {		
		if (src == null ) return;
		if (hasLegRepurchaseTerm()) legRepurchaseTerm = FixUtils.TAG_HAS_NO_VALUE;		
		legRepurchaseTerm = FixUtils.longValueOf(src, 0, src.length);
		hasLegRepurchaseTerm = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegRepurchaseTerm(String str) {		
		if (str == null ) return;
		if (hasLegRepurchaseTerm()) legRepurchaseTerm = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legRepurchaseTerm = FixUtils.longValueOf(src, 0, src.length);
		hasLegRepurchaseTerm = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegRepurchaseRate() { 		
		if ( hasLegRepurchaseRate()) {		
			if (hasLegRepurchaseRate == FixUtils.TAG_HAS_VALUE) {		
				return legRepurchaseRate; 		
			} else {		
		
				buf.position(hasLegRepurchaseRate);		
		
			legRepurchaseRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegRepurchaseRate);		
					return 0;		
				}		
			}		
			hasLegRepurchaseRate = FixUtils.TAG_HAS_VALUE;		
			return legRepurchaseRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegRepurchaseRate() { return hasLegRepurchaseRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegRepurchaseRate(long src) {		
		legRepurchaseRate = src;
		hasLegRepurchaseRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegRepurchaseRate(byte[] src) {		
		if (src == null ) return;
		if (hasLegRepurchaseRate()) legRepurchaseRate = FixUtils.TAG_HAS_NO_VALUE;		
		legRepurchaseRate = FixUtils.longValueOf(src, 0, src.length);
		hasLegRepurchaseRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegRepurchaseRate(String str) {		
		if (str == null ) return;
		if (hasLegRepurchaseRate()) legRepurchaseRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legRepurchaseRate = FixUtils.longValueOf(src, 0, src.length);
		hasLegRepurchaseRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegFactor() { 		
		if ( hasLegFactor()) {		
			if (hasLegFactor == FixUtils.TAG_HAS_VALUE) {		
				return legFactor; 		
			} else {		
		
				buf.position(hasLegFactor);		
		
			legFactor = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegFactor);		
					return 0;		
				}		
			}		
			hasLegFactor = FixUtils.TAG_HAS_VALUE;		
			return legFactor;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegFactor() { return hasLegFactor != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegFactor(long src) {		
		legFactor = src;
		hasLegFactor = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegFactor(byte[] src) {		
		if (src == null ) return;
		if (hasLegFactor()) legFactor = FixUtils.TAG_HAS_NO_VALUE;		
		legFactor = FixUtils.longValueOf(src, 0, src.length);
		hasLegFactor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegFactor(String str) {		
		if (str == null ) return;
		if (hasLegFactor()) legFactor = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legFactor = FixUtils.longValueOf(src, 0, src.length);
		hasLegFactor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegCreditRating() { 		
		if ( hasLegCreditRating()) {		
			if (hasLegCreditRating == FixUtils.TAG_HAS_VALUE) {		
				return legCreditRating; 		
			} else {		
		
				buf.position(hasLegCreditRating);		
		
			FixMessage.getTagStringValue(buf, legCreditRating, 0, legCreditRating.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegCreditRating);		
					return null;		
				}		
			}		
			hasLegCreditRating = FixUtils.TAG_HAS_VALUE;		
			return legCreditRating;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegCreditRating() { return hasLegCreditRating != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegCreditRating(byte[] src) {		
		if (src == null ) return;
		if (hasLegCreditRating()) FixUtils.fillSpace(legCreditRating);		
		FixUtils.copy(legCreditRating, src); 		
		hasLegCreditRating = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegCreditRating(String str) {		
		if (str == null ) return;
		if (hasLegCreditRating()) FixUtils.fillSpace(legCreditRating);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legCreditRating, src); 		
		hasLegCreditRating = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegInstrRegistry() { 		
		if ( hasLegInstrRegistry()) {		
			if (hasLegInstrRegistry == FixUtils.TAG_HAS_VALUE) {		
				return legInstrRegistry; 		
			} else {		
		
				buf.position(hasLegInstrRegistry);		
		
			FixMessage.getTagStringValue(buf, legInstrRegistry, 0, legInstrRegistry.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegInstrRegistry);		
					return null;		
				}		
			}		
			hasLegInstrRegistry = FixUtils.TAG_HAS_VALUE;		
			return legInstrRegistry;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegInstrRegistry() { return hasLegInstrRegistry != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegInstrRegistry(byte[] src) {		
		if (src == null ) return;
		if (hasLegInstrRegistry()) FixUtils.fillSpace(legInstrRegistry);		
		FixUtils.copy(legInstrRegistry, src); 		
		hasLegInstrRegistry = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegInstrRegistry(String str) {		
		if (str == null ) return;
		if (hasLegInstrRegistry()) FixUtils.fillSpace(legInstrRegistry);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legInstrRegistry, src); 		
		hasLegInstrRegistry = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegCountryOfIssue() { 		
		if ( hasLegCountryOfIssue()) {		
			if (hasLegCountryOfIssue == FixUtils.TAG_HAS_VALUE) {		
				return legCountryOfIssue; 		
			} else {		
		
				buf.position(hasLegCountryOfIssue);		
		
			FixMessage.getTagStringValue(buf, legCountryOfIssue, 0, legCountryOfIssue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegCountryOfIssue);		
					return null;		
				}		
			}		
			hasLegCountryOfIssue = FixUtils.TAG_HAS_VALUE;		
			return legCountryOfIssue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegCountryOfIssue() { return hasLegCountryOfIssue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegCountryOfIssue(byte[] src) {		
		if (src == null ) return;
		if (hasLegCountryOfIssue()) FixUtils.fillSpace(legCountryOfIssue);		
		FixUtils.copy(legCountryOfIssue, src); 		
		hasLegCountryOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegCountryOfIssue(String str) {		
		if (str == null ) return;
		if (hasLegCountryOfIssue()) FixUtils.fillSpace(legCountryOfIssue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legCountryOfIssue, src); 		
		hasLegCountryOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegStateOrProvinceOfIssue() { 		
		if ( hasLegStateOrProvinceOfIssue()) {		
			if (hasLegStateOrProvinceOfIssue == FixUtils.TAG_HAS_VALUE) {		
				return legStateOrProvinceOfIssue; 		
			} else {		
		
				buf.position(hasLegStateOrProvinceOfIssue);		
		
			FixMessage.getTagStringValue(buf, legStateOrProvinceOfIssue, 0, legStateOrProvinceOfIssue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegStateOrProvinceOfIssue);		
					return null;		
				}		
			}		
			hasLegStateOrProvinceOfIssue = FixUtils.TAG_HAS_VALUE;		
			return legStateOrProvinceOfIssue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegStateOrProvinceOfIssue() { return hasLegStateOrProvinceOfIssue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegStateOrProvinceOfIssue(byte[] src) {		
		if (src == null ) return;
		if (hasLegStateOrProvinceOfIssue()) FixUtils.fillSpace(legStateOrProvinceOfIssue);		
		FixUtils.copy(legStateOrProvinceOfIssue, src); 		
		hasLegStateOrProvinceOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegStateOrProvinceOfIssue(String str) {		
		if (str == null ) return;
		if (hasLegStateOrProvinceOfIssue()) FixUtils.fillSpace(legStateOrProvinceOfIssue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legStateOrProvinceOfIssue, src); 		
		hasLegStateOrProvinceOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegLocaleOfIssue() { 		
		if ( hasLegLocaleOfIssue()) {		
			if (hasLegLocaleOfIssue == FixUtils.TAG_HAS_VALUE) {		
				return legLocaleOfIssue; 		
			} else {		
		
				buf.position(hasLegLocaleOfIssue);		
		
			FixMessage.getTagStringValue(buf, legLocaleOfIssue, 0, legLocaleOfIssue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegLocaleOfIssue);		
					return null;		
				}		
			}		
			hasLegLocaleOfIssue = FixUtils.TAG_HAS_VALUE;		
			return legLocaleOfIssue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegLocaleOfIssue() { return hasLegLocaleOfIssue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegLocaleOfIssue(byte[] src) {		
		if (src == null ) return;
		if (hasLegLocaleOfIssue()) FixUtils.fillSpace(legLocaleOfIssue);		
		FixUtils.copy(legLocaleOfIssue, src); 		
		hasLegLocaleOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegLocaleOfIssue(String str) {		
		if (str == null ) return;
		if (hasLegLocaleOfIssue()) FixUtils.fillSpace(legLocaleOfIssue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legLocaleOfIssue, src); 		
		hasLegLocaleOfIssue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegRedemptionDate() { 		
		if ( hasLegRedemptionDate()) {		
			if (hasLegRedemptionDate == FixUtils.TAG_HAS_VALUE) {		
				return legRedemptionDate; 		
			} else {		
		
				buf.position(hasLegRedemptionDate);		
		
			FixMessage.getTagStringValue(buf, legRedemptionDate, 0, legRedemptionDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegRedemptionDate);		
					return null;		
				}		
			}		
			hasLegRedemptionDate = FixUtils.TAG_HAS_VALUE;		
			return legRedemptionDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegRedemptionDate() { return hasLegRedemptionDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegRedemptionDate(byte[] src) {		
		if (src == null ) return;
		if (hasLegRedemptionDate()) FixUtils.fillSpace(legRedemptionDate);		
		FixUtils.copy(legRedemptionDate, src); 		
		hasLegRedemptionDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegRedemptionDate(String str) {		
		if (str == null ) return;
		if (hasLegRedemptionDate()) FixUtils.fillSpace(legRedemptionDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legRedemptionDate, src); 		
		hasLegRedemptionDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegStrikePrice() { 		
		if ( hasLegStrikePrice()) {		
			if (hasLegStrikePrice == FixUtils.TAG_HAS_VALUE) {		
				return legStrikePrice; 		
			} else {		
		
				buf.position(hasLegStrikePrice);		
		
			legStrikePrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegStrikePrice);		
					return 0;		
				}		
			}		
			hasLegStrikePrice = FixUtils.TAG_HAS_VALUE;		
			return legStrikePrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegStrikePrice() { return hasLegStrikePrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegStrikePrice(long src) {		
		legStrikePrice = src;
		hasLegStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegStrikePrice(byte[] src) {		
		if (src == null ) return;
		if (hasLegStrikePrice()) legStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		legStrikePrice = FixUtils.longValueOf(src, 0, src.length);
		hasLegStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegStrikePrice(String str) {		
		if (str == null ) return;
		if (hasLegStrikePrice()) legStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legStrikePrice = FixUtils.longValueOf(src, 0, src.length);
		hasLegStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegStrikeCurrency() { 		
		if ( hasLegStrikeCurrency()) {		
			if (hasLegStrikeCurrency == FixUtils.TAG_HAS_VALUE) {		
				return legStrikeCurrency; 		
			} else {		
		
				buf.position(hasLegStrikeCurrency);		
		
			FixMessage.getTagStringValue(buf, legStrikeCurrency, 0, legStrikeCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegStrikeCurrency);		
					return null;		
				}		
			}		
			hasLegStrikeCurrency = FixUtils.TAG_HAS_VALUE;		
			return legStrikeCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegStrikeCurrency() { return hasLegStrikeCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegStrikeCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasLegStrikeCurrency()) FixUtils.fillSpace(legStrikeCurrency);		
		FixUtils.copy(legStrikeCurrency, src); 		
		hasLegStrikeCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegStrikeCurrency(String str) {		
		if (str == null ) return;
		if (hasLegStrikeCurrency()) FixUtils.fillSpace(legStrikeCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legStrikeCurrency, src); 		
		hasLegStrikeCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getLegOptAttribute() { 		
		if ( hasLegOptAttribute()) {		
			if (hasLegOptAttribute == FixUtils.TAG_HAS_VALUE) {		
				return legOptAttribute; 		
			} else {		
		
				buf.position(hasLegOptAttribute);		
		
			legOptAttribute = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegOptAttribute);		
					return (byte)'0';		
				}		
			}		
			hasLegOptAttribute = FixUtils.TAG_HAS_VALUE;		
			return legOptAttribute;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasLegOptAttribute() { return hasLegOptAttribute != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegOptAttribute(byte src) {		
		legOptAttribute = src;
		hasLegOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegOptAttribute(byte[] src) {		
		if (src == null ) return;
		if (hasLegOptAttribute()) legOptAttribute = (byte)' ';		
		legOptAttribute = src[0];		
		hasLegOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegOptAttribute(String str) {		
		if (str == null ) return;
		if (hasLegOptAttribute()) legOptAttribute = (byte)' ';		
		byte[] src = str.getBytes(); 		
		legOptAttribute = src[0];		
		hasLegOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegContractMultiplier() { 		
		if ( hasLegContractMultiplier()) {		
			if (hasLegContractMultiplier == FixUtils.TAG_HAS_VALUE) {		
				return legContractMultiplier; 		
			} else {		
		
				buf.position(hasLegContractMultiplier);		
		
			legContractMultiplier = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegContractMultiplier);		
					return 0;		
				}		
			}		
			hasLegContractMultiplier = FixUtils.TAG_HAS_VALUE;		
			return legContractMultiplier;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegContractMultiplier() { return hasLegContractMultiplier != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegContractMultiplier(long src) {		
		legContractMultiplier = src;
		hasLegContractMultiplier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegContractMultiplier(byte[] src) {		
		if (src == null ) return;
		if (hasLegContractMultiplier()) legContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		legContractMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasLegContractMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegContractMultiplier(String str) {		
		if (str == null ) return;
		if (hasLegContractMultiplier()) legContractMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legContractMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasLegContractMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegUnitOfMeasure() { 		
		if ( hasLegUnitOfMeasure()) {		
			if (hasLegUnitOfMeasure == FixUtils.TAG_HAS_VALUE) {		
				return legUnitOfMeasure; 		
			} else {		
		
				buf.position(hasLegUnitOfMeasure);		
		
			FixMessage.getTagStringValue(buf, legUnitOfMeasure, 0, legUnitOfMeasure.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegUnitOfMeasure);		
					return null;		
				}		
			}		
			hasLegUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
			return legUnitOfMeasure;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegUnitOfMeasure() { return hasLegUnitOfMeasure != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegUnitOfMeasure(byte[] src) {		
		if (src == null ) return;
		if (hasLegUnitOfMeasure()) FixUtils.fillSpace(legUnitOfMeasure);		
		FixUtils.copy(legUnitOfMeasure, src); 		
		hasLegUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegUnitOfMeasure(String str) {		
		if (str == null ) return;
		if (hasLegUnitOfMeasure()) FixUtils.fillSpace(legUnitOfMeasure);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legUnitOfMeasure, src); 		
		hasLegUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegTimeUnit() { 		
		if ( hasLegTimeUnit()) {		
			if (hasLegTimeUnit == FixUtils.TAG_HAS_VALUE) {		
				return legTimeUnit; 		
			} else {		
		
				buf.position(hasLegTimeUnit);		
		
			FixMessage.getTagStringValue(buf, legTimeUnit, 0, legTimeUnit.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegTimeUnit);		
					return null;		
				}		
			}		
			hasLegTimeUnit = FixUtils.TAG_HAS_VALUE;		
			return legTimeUnit;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegTimeUnit() { return hasLegTimeUnit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegTimeUnit(byte[] src) {		
		if (src == null ) return;
		if (hasLegTimeUnit()) FixUtils.fillSpace(legTimeUnit);		
		FixUtils.copy(legTimeUnit, src); 		
		hasLegTimeUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegTimeUnit(String str) {		
		if (str == null ) return;
		if (hasLegTimeUnit()) FixUtils.fillSpace(legTimeUnit);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legTimeUnit, src); 		
		hasLegTimeUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegExerciseStyle() { 		
		if ( hasLegExerciseStyle()) {		
			if (hasLegExerciseStyle == FixUtils.TAG_HAS_VALUE) {		
				return legExerciseStyle; 		
			} else {		
		
				buf.position(hasLegExerciseStyle);		
		
			legExerciseStyle = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegExerciseStyle);		
					return 0;		
				}		
			}		
			hasLegExerciseStyle = FixUtils.TAG_HAS_VALUE;		
			return legExerciseStyle;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegExerciseStyle() { return hasLegExerciseStyle != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegExerciseStyle(long src) {		
		legExerciseStyle = src;
		hasLegExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegExerciseStyle(byte[] src) {		
		if (src == null ) return;
		if (hasLegExerciseStyle()) legExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		legExerciseStyle = FixUtils.longValueOf(src, 0, src.length);
		hasLegExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegExerciseStyle(String str) {		
		if (str == null ) return;
		if (hasLegExerciseStyle()) legExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legExerciseStyle = FixUtils.longValueOf(src, 0, src.length);
		hasLegExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegUnitOfMeasureQty() { 		
		if ( hasLegUnitOfMeasureQty()) {		
			if (hasLegUnitOfMeasureQty == FixUtils.TAG_HAS_VALUE) {		
				return legUnitOfMeasureQty; 		
			} else {		
		
				buf.position(hasLegUnitOfMeasureQty);		
		
			legUnitOfMeasureQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegUnitOfMeasureQty);		
					return 0;		
				}		
			}		
			hasLegUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
			return legUnitOfMeasureQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegUnitOfMeasureQty() { return hasLegUnitOfMeasureQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegUnitOfMeasureQty(long src) {		
		legUnitOfMeasureQty = src;
		hasLegUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegUnitOfMeasureQty(byte[] src) {		
		if (src == null ) return;
		if (hasLegUnitOfMeasureQty()) legUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		legUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegUnitOfMeasureQty(String str) {		
		if (str == null ) return;
		if (hasLegUnitOfMeasureQty()) legUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegPriceUnitOfMeasure() { 		
		if ( hasLegPriceUnitOfMeasure()) {		
			if (hasLegPriceUnitOfMeasure == FixUtils.TAG_HAS_VALUE) {		
				return legPriceUnitOfMeasure; 		
			} else {		
		
				buf.position(hasLegPriceUnitOfMeasure);		
		
			FixMessage.getTagStringValue(buf, legPriceUnitOfMeasure, 0, legPriceUnitOfMeasure.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegPriceUnitOfMeasure);		
					return null;		
				}		
			}		
			hasLegPriceUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
			return legPriceUnitOfMeasure;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegPriceUnitOfMeasure() { return hasLegPriceUnitOfMeasure != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegPriceUnitOfMeasure(byte[] src) {		
		if (src == null ) return;
		if (hasLegPriceUnitOfMeasure()) FixUtils.fillSpace(legPriceUnitOfMeasure);		
		FixUtils.copy(legPriceUnitOfMeasure, src); 		
		hasLegPriceUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegPriceUnitOfMeasure(String str) {		
		if (str == null ) return;
		if (hasLegPriceUnitOfMeasure()) FixUtils.fillSpace(legPriceUnitOfMeasure);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legPriceUnitOfMeasure, src); 		
		hasLegPriceUnitOfMeasure = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegPriceUnitOfMeasureQty() { 		
		if ( hasLegPriceUnitOfMeasureQty()) {		
			if (hasLegPriceUnitOfMeasureQty == FixUtils.TAG_HAS_VALUE) {		
				return legPriceUnitOfMeasureQty; 		
			} else {		
		
				buf.position(hasLegPriceUnitOfMeasureQty);		
		
			legPriceUnitOfMeasureQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegPriceUnitOfMeasureQty);		
					return 0;		
				}		
			}		
			hasLegPriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
			return legPriceUnitOfMeasureQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegPriceUnitOfMeasureQty() { return hasLegPriceUnitOfMeasureQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegPriceUnitOfMeasureQty(long src) {		
		legPriceUnitOfMeasureQty = src;
		hasLegPriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegPriceUnitOfMeasureQty(byte[] src) {		
		if (src == null ) return;
		if (hasLegPriceUnitOfMeasureQty()) legPriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		legPriceUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegPriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegPriceUnitOfMeasureQty(String str) {		
		if (str == null ) return;
		if (hasLegPriceUnitOfMeasureQty()) legPriceUnitOfMeasureQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legPriceUnitOfMeasureQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegPriceUnitOfMeasureQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegContractMultiplierUnit() { 		
		if ( hasLegContractMultiplierUnit()) {		
			if (hasLegContractMultiplierUnit == FixUtils.TAG_HAS_VALUE) {		
				return legContractMultiplierUnit; 		
			} else {		
		
				buf.position(hasLegContractMultiplierUnit);		
		
			legContractMultiplierUnit = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegContractMultiplierUnit);		
					return 0;		
				}		
			}		
			hasLegContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
			return legContractMultiplierUnit;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegContractMultiplierUnit() { return hasLegContractMultiplierUnit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegContractMultiplierUnit(long src) {		
		legContractMultiplierUnit = src;
		hasLegContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegContractMultiplierUnit(byte[] src) {		
		if (src == null ) return;
		if (hasLegContractMultiplierUnit()) legContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;		
		legContractMultiplierUnit = FixUtils.longValueOf(src, 0, src.length);
		hasLegContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegContractMultiplierUnit(String str) {		
		if (str == null ) return;
		if (hasLegContractMultiplierUnit()) legContractMultiplierUnit = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legContractMultiplierUnit = FixUtils.longValueOf(src, 0, src.length);
		hasLegContractMultiplierUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegFlowScheduleType() { 		
		if ( hasLegFlowScheduleType()) {		
			if (hasLegFlowScheduleType == FixUtils.TAG_HAS_VALUE) {		
				return legFlowScheduleType; 		
			} else {		
		
				buf.position(hasLegFlowScheduleType);		
		
			legFlowScheduleType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegFlowScheduleType);		
					return 0;		
				}		
			}		
			hasLegFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
			return legFlowScheduleType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegFlowScheduleType() { return hasLegFlowScheduleType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegFlowScheduleType(long src) {		
		legFlowScheduleType = src;
		hasLegFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegFlowScheduleType(byte[] src) {		
		if (src == null ) return;
		if (hasLegFlowScheduleType()) legFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;		
		legFlowScheduleType = FixUtils.longValueOf(src, 0, src.length);
		hasLegFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegFlowScheduleType(String str) {		
		if (str == null ) return;
		if (hasLegFlowScheduleType()) legFlowScheduleType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legFlowScheduleType = FixUtils.longValueOf(src, 0, src.length);
		hasLegFlowScheduleType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegCouponRate() { 		
		if ( hasLegCouponRate()) {		
			if (hasLegCouponRate == FixUtils.TAG_HAS_VALUE) {		
				return legCouponRate; 		
			} else {		
		
				buf.position(hasLegCouponRate);		
		
			legCouponRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegCouponRate);		
					return 0;		
				}		
			}		
			hasLegCouponRate = FixUtils.TAG_HAS_VALUE;		
			return legCouponRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegCouponRate() { return hasLegCouponRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegCouponRate(long src) {		
		legCouponRate = src;
		hasLegCouponRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegCouponRate(byte[] src) {		
		if (src == null ) return;
		if (hasLegCouponRate()) legCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		legCouponRate = FixUtils.longValueOf(src, 0, src.length);
		hasLegCouponRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegCouponRate(String str) {		
		if (str == null ) return;
		if (hasLegCouponRate()) legCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legCouponRate = FixUtils.longValueOf(src, 0, src.length);
		hasLegCouponRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegSecurityExchange() { 		
		if ( hasLegSecurityExchange()) {		
			if (hasLegSecurityExchange == FixUtils.TAG_HAS_VALUE) {		
				return legSecurityExchange; 		
			} else {		
		
				buf.position(hasLegSecurityExchange);		
		
			FixMessage.getTagStringValue(buf, legSecurityExchange, 0, legSecurityExchange.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSecurityExchange);		
					return null;		
				}		
			}		
			hasLegSecurityExchange = FixUtils.TAG_HAS_VALUE;		
			return legSecurityExchange;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegSecurityExchange() { return hasLegSecurityExchange != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSecurityExchange(byte[] src) {		
		if (src == null ) return;
		if (hasLegSecurityExchange()) FixUtils.fillSpace(legSecurityExchange);		
		FixUtils.copy(legSecurityExchange, src); 		
		hasLegSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSecurityExchange(String str) {		
		if (str == null ) return;
		if (hasLegSecurityExchange()) FixUtils.fillSpace(legSecurityExchange);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSecurityExchange, src); 		
		hasLegSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegIssuer() { 		
		if ( hasLegIssuer()) {		
			if (hasLegIssuer == FixUtils.TAG_HAS_VALUE) {		
				return legIssuer; 		
			} else {		
		
				buf.position(hasLegIssuer);		
		
			FixMessage.getTagStringValue(buf, legIssuer, 0, legIssuer.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegIssuer);		
					return null;		
				}		
			}		
			hasLegIssuer = FixUtils.TAG_HAS_VALUE;		
			return legIssuer;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegIssuer() { return hasLegIssuer != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegIssuer(byte[] src) {		
		if (src == null ) return;
		if (hasLegIssuer()) FixUtils.fillSpace(legIssuer);		
		FixUtils.copy(legIssuer, src); 		
		hasLegIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegIssuer(String str) {		
		if (str == null ) return;
		if (hasLegIssuer()) FixUtils.fillSpace(legIssuer);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legIssuer, src); 		
		hasLegIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEncodedLegIssuerLen() { 		
		if ( hasEncodedLegIssuerLen()) {		
			if (hasEncodedLegIssuerLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedLegIssuerLen; 		
			} else {		
		
				buf.position(hasEncodedLegIssuerLen);		
		
			encodedLegIssuerLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedLegIssuerLen);		
					return 0;		
				}		
			}		
			hasEncodedLegIssuerLen = FixUtils.TAG_HAS_VALUE;		
			return encodedLegIssuerLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedLegIssuerLen() { return hasEncodedLegIssuerLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedLegIssuerLen(long src) {		
		encodedLegIssuerLen = src;
		hasEncodedLegIssuerLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedLegIssuerLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedLegIssuerLen()) encodedLegIssuerLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedLegIssuerLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedLegIssuerLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedLegIssuerLen(String str) {		
		if (str == null ) return;
		if (hasEncodedLegIssuerLen()) encodedLegIssuerLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedLegIssuerLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedLegIssuerLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedLegIssuer() { 		
		if ( hasEncodedLegIssuer()) {		
			if (hasEncodedLegIssuer == FixUtils.TAG_HAS_VALUE) {		
				return encodedLegIssuer; 		
			} else {		
		
				buf.position(hasEncodedLegIssuer);		
		
			FixMessage.getTagStringValue(buf, encodedLegIssuer, 0, encodedLegIssuer.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedLegIssuer);		
					return null;		
				}		
			}		
			hasEncodedLegIssuer = FixUtils.TAG_HAS_VALUE;		
			return encodedLegIssuer;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedLegIssuer() { return hasEncodedLegIssuer != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedLegIssuer(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedLegIssuer()) FixUtils.fillSpace(encodedLegIssuer);		
		FixUtils.copy(encodedLegIssuer, src); 		
		hasEncodedLegIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedLegIssuer(String str) {		
		if (str == null ) return;
		if (hasEncodedLegIssuer()) FixUtils.fillSpace(encodedLegIssuer);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedLegIssuer, src); 		
		hasEncodedLegIssuer = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegSecurityDesc() { 		
		if ( hasLegSecurityDesc()) {		
			if (hasLegSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return legSecurityDesc; 		
			} else {		
		
				buf.position(hasLegSecurityDesc);		
		
			FixMessage.getTagStringValue(buf, legSecurityDesc, 0, legSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSecurityDesc);		
					return null;		
				}		
			}		
			hasLegSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return legSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegSecurityDesc() { return hasLegSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasLegSecurityDesc()) FixUtils.fillSpace(legSecurityDesc);		
		FixUtils.copy(legSecurityDesc, src); 		
		hasLegSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasLegSecurityDesc()) FixUtils.fillSpace(legSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSecurityDesc, src); 		
		hasLegSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEncodedLegSecurityDescLen() { 		
		if ( hasEncodedLegSecurityDescLen()) {		
			if (hasEncodedLegSecurityDescLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedLegSecurityDescLen; 		
			} else {		
		
				buf.position(hasEncodedLegSecurityDescLen);		
		
			encodedLegSecurityDescLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedLegSecurityDescLen);		
					return 0;		
				}		
			}		
			hasEncodedLegSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
			return encodedLegSecurityDescLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedLegSecurityDescLen() { return hasEncodedLegSecurityDescLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedLegSecurityDescLen(long src) {		
		encodedLegSecurityDescLen = src;
		hasEncodedLegSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedLegSecurityDescLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedLegSecurityDescLen()) encodedLegSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedLegSecurityDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedLegSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedLegSecurityDescLen(String str) {		
		if (str == null ) return;
		if (hasEncodedLegSecurityDescLen()) encodedLegSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedLegSecurityDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedLegSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedLegSecurityDesc() { 		
		if ( hasEncodedLegSecurityDesc()) {		
			if (hasEncodedLegSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return encodedLegSecurityDesc; 		
			} else {		
		
				buf.position(hasEncodedLegSecurityDesc);		
		
			FixMessage.getTagStringValue(buf, encodedLegSecurityDesc, 0, encodedLegSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedLegSecurityDesc);		
					return null;		
				}		
			}		
			hasEncodedLegSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return encodedLegSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedLegSecurityDesc() { return hasEncodedLegSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedLegSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedLegSecurityDesc()) FixUtils.fillSpace(encodedLegSecurityDesc);		
		FixUtils.copy(encodedLegSecurityDesc, src); 		
		hasEncodedLegSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedLegSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasEncodedLegSecurityDesc()) FixUtils.fillSpace(encodedLegSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedLegSecurityDesc, src); 		
		hasEncodedLegSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegRatioQty() { 		
		if ( hasLegRatioQty()) {		
			if (hasLegRatioQty == FixUtils.TAG_HAS_VALUE) {		
				return legRatioQty; 		
			} else {		
		
				buf.position(hasLegRatioQty);		
		
			legRatioQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegRatioQty);		
					return 0;		
				}		
			}		
			hasLegRatioQty = FixUtils.TAG_HAS_VALUE;		
			return legRatioQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegRatioQty() { return hasLegRatioQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegRatioQty(long src) {		
		legRatioQty = src;
		hasLegRatioQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegRatioQty(byte[] src) {		
		if (src == null ) return;
		if (hasLegRatioQty()) legRatioQty = FixUtils.TAG_HAS_NO_VALUE;		
		legRatioQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegRatioQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegRatioQty(String str) {		
		if (str == null ) return;
		if (hasLegRatioQty()) legRatioQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legRatioQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegRatioQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getLegSide() { 		
		if ( hasLegSide()) {		
			if (hasLegSide == FixUtils.TAG_HAS_VALUE) {		
				return legSide; 		
			} else {		
		
				buf.position(hasLegSide);		
		
			legSide = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSide);		
					return (byte)'0';		
				}		
			}		
			hasLegSide = FixUtils.TAG_HAS_VALUE;		
			return legSide;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasLegSide() { return hasLegSide != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSide(byte src) {		
		legSide = src;
		hasLegSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegSide(byte[] src) {		
		if (src == null ) return;
		if (hasLegSide()) legSide = (byte)' ';		
		legSide = src[0];		
		hasLegSide = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSide(String str) {		
		if (str == null ) return;
		if (hasLegSide()) legSide = (byte)' ';		
		byte[] src = str.getBytes(); 		
		legSide = src[0];		
		hasLegSide = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegCurrency() { 		
		if ( hasLegCurrency()) {		
			if (hasLegCurrency == FixUtils.TAG_HAS_VALUE) {		
				return legCurrency; 		
			} else {		
		
				buf.position(hasLegCurrency);		
		
			FixMessage.getTagStringValue(buf, legCurrency, 0, legCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegCurrency);		
					return null;		
				}		
			}		
			hasLegCurrency = FixUtils.TAG_HAS_VALUE;		
			return legCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegCurrency() { return hasLegCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasLegCurrency()) FixUtils.fillSpace(legCurrency);		
		FixUtils.copy(legCurrency, src); 		
		hasLegCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegCurrency(String str) {		
		if (str == null ) return;
		if (hasLegCurrency()) FixUtils.fillSpace(legCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legCurrency, src); 		
		hasLegCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegPool() { 		
		if ( hasLegPool()) {		
			if (hasLegPool == FixUtils.TAG_HAS_VALUE) {		
				return legPool; 		
			} else {		
		
				buf.position(hasLegPool);		
		
			FixMessage.getTagStringValue(buf, legPool, 0, legPool.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegPool);		
					return null;		
				}		
			}		
			hasLegPool = FixUtils.TAG_HAS_VALUE;		
			return legPool;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegPool() { return hasLegPool != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegPool(byte[] src) {		
		if (src == null ) return;
		if (hasLegPool()) FixUtils.fillSpace(legPool);		
		FixUtils.copy(legPool, src); 		
		hasLegPool = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegPool(String str) {		
		if (str == null ) return;
		if (hasLegPool()) FixUtils.fillSpace(legPool);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legPool, src); 		
		hasLegPool = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegDatedDate() { 		
		if ( hasLegDatedDate()) {		
			if (hasLegDatedDate == FixUtils.TAG_HAS_VALUE) {		
				return legDatedDate; 		
			} else {		
		
				buf.position(hasLegDatedDate);		
		
			FixMessage.getTagStringValue(buf, legDatedDate, 0, legDatedDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegDatedDate);		
					return null;		
				}		
			}		
			hasLegDatedDate = FixUtils.TAG_HAS_VALUE;		
			return legDatedDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegDatedDate() { return hasLegDatedDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegDatedDate(byte[] src) {		
		if (src == null ) return;
		if (hasLegDatedDate()) FixUtils.fillSpace(legDatedDate);		
		FixUtils.copy(legDatedDate, src); 		
		hasLegDatedDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegDatedDate(String str) {		
		if (str == null ) return;
		if (hasLegDatedDate()) FixUtils.fillSpace(legDatedDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legDatedDate, src); 		
		hasLegDatedDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegContractSettlMonth() { 		
		if ( hasLegContractSettlMonth()) {		
			if (hasLegContractSettlMonth == FixUtils.TAG_HAS_VALUE) {		
				return legContractSettlMonth; 		
			} else {		
		
				buf.position(hasLegContractSettlMonth);		
		
			FixMessage.getTagStringValue(buf, legContractSettlMonth, 0, legContractSettlMonth.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegContractSettlMonth);		
					return null;		
				}		
			}		
			hasLegContractSettlMonth = FixUtils.TAG_HAS_VALUE;		
			return legContractSettlMonth;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegContractSettlMonth() { return hasLegContractSettlMonth != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegContractSettlMonth(byte[] src) {		
		if (src == null ) return;
		if (hasLegContractSettlMonth()) FixUtils.fillSpace(legContractSettlMonth);		
		FixUtils.copy(legContractSettlMonth, src); 		
		hasLegContractSettlMonth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegContractSettlMonth(String str) {		
		if (str == null ) return;
		if (hasLegContractSettlMonth()) FixUtils.fillSpace(legContractSettlMonth);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legContractSettlMonth, src); 		
		hasLegContractSettlMonth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegInterestAccrualDate() { 		
		if ( hasLegInterestAccrualDate()) {		
			if (hasLegInterestAccrualDate == FixUtils.TAG_HAS_VALUE) {		
				return legInterestAccrualDate; 		
			} else {		
		
				buf.position(hasLegInterestAccrualDate);		
		
			FixMessage.getTagStringValue(buf, legInterestAccrualDate, 0, legInterestAccrualDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegInterestAccrualDate);		
					return null;		
				}		
			}		
			hasLegInterestAccrualDate = FixUtils.TAG_HAS_VALUE;		
			return legInterestAccrualDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegInterestAccrualDate() { return hasLegInterestAccrualDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegInterestAccrualDate(byte[] src) {		
		if (src == null ) return;
		if (hasLegInterestAccrualDate()) FixUtils.fillSpace(legInterestAccrualDate);		
		FixUtils.copy(legInterestAccrualDate, src); 		
		hasLegInterestAccrualDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegInterestAccrualDate(String str) {		
		if (str == null ) return;
		if (hasLegInterestAccrualDate()) FixUtils.fillSpace(legInterestAccrualDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legInterestAccrualDate, src); 		
		hasLegInterestAccrualDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegOptionRatio() { 		
		if ( hasLegOptionRatio()) {		
			if (hasLegOptionRatio == FixUtils.TAG_HAS_VALUE) {		
				return legOptionRatio; 		
			} else {		
		
				buf.position(hasLegOptionRatio);		
		
			legOptionRatio = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegOptionRatio);		
					return 0;		
				}		
			}		
			hasLegOptionRatio = FixUtils.TAG_HAS_VALUE;		
			return legOptionRatio;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegOptionRatio() { return hasLegOptionRatio != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegOptionRatio(long src) {		
		legOptionRatio = src;
		hasLegOptionRatio = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegOptionRatio(byte[] src) {		
		if (src == null ) return;
		if (hasLegOptionRatio()) legOptionRatio = FixUtils.TAG_HAS_NO_VALUE;		
		legOptionRatio = FixUtils.longValueOf(src, 0, src.length);
		hasLegOptionRatio = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegOptionRatio(String str) {		
		if (str == null ) return;
		if (hasLegOptionRatio()) legOptionRatio = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legOptionRatio = FixUtils.longValueOf(src, 0, src.length);
		hasLegOptionRatio = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegPrice() { 		
		if ( hasLegPrice()) {		
			if (hasLegPrice == FixUtils.TAG_HAS_VALUE) {		
				return legPrice; 		
			} else {		
		
				buf.position(hasLegPrice);		
		
			legPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegPrice);		
					return 0;		
				}		
			}		
			hasLegPrice = FixUtils.TAG_HAS_VALUE;		
			return legPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegPrice() { return hasLegPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegPrice(long src) {		
		legPrice = src;
		hasLegPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegPrice(byte[] src) {		
		if (src == null ) return;
		if (hasLegPrice()) legPrice = FixUtils.TAG_HAS_NO_VALUE;		
		legPrice = FixUtils.longValueOf(src, 0, src.length);
		hasLegPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegPrice(String str) {		
		if (str == null ) return;
		if (hasLegPrice()) legPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legPrice = FixUtils.longValueOf(src, 0, src.length);
		hasLegPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegPutOrCall() { 		
		if ( hasLegPutOrCall()) {		
			if (hasLegPutOrCall == FixUtils.TAG_HAS_VALUE) {		
				return legPutOrCall; 		
			} else {		
		
				buf.position(hasLegPutOrCall);		
		
			legPutOrCall = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegPutOrCall);		
					return 0;		
				}		
			}		
			hasLegPutOrCall = FixUtils.TAG_HAS_VALUE;		
			return legPutOrCall;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegPutOrCall() { return hasLegPutOrCall != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegPutOrCall(long src) {		
		legPutOrCall = src;
		hasLegPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegPutOrCall(byte[] src) {		
		if (src == null ) return;
		if (hasLegPutOrCall()) legPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		legPutOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasLegPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegPutOrCall(String str) {		
		if (str == null ) return;
		if (hasLegPutOrCall()) legPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legPutOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasLegPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasLegSymbol()) s += "LegSymbol(600)= " + new String( FixUtils.trim(getLegSymbol()) ) + "\n" ; 
		if (hasLegSymbolSfx()) s += "LegSymbolSfx(601)= " + new String( FixUtils.trim(getLegSymbolSfx()) ) + "\n" ; 
		if (hasLegSecurityID()) s += "LegSecurityID(602)= " + new String( FixUtils.trim(getLegSecurityID()) ) + "\n" ; 
		if (hasLegSecurityIDSource()) s += "LegSecurityIDSource(603)= " + new String( FixUtils.trim(getLegSecurityIDSource()) ) + "\n" ; 
		if (hasLegProduct()) s += "LegProduct(607)= " + getLegProduct() + "\n" ; 
		if (hasLegCFICode()) s += "LegCFICode(608)= " + new String( FixUtils.trim(getLegCFICode()) ) + "\n" ; 
		if (hasLegSecurityType()) s += "LegSecurityType(609)= " + new String( FixUtils.trim(getLegSecurityType()) ) + "\n" ; 
		if (hasLegSecuritySubType()) s += "LegSecuritySubType(764)= " + new String( FixUtils.trim(getLegSecuritySubType()) ) + "\n" ; 
		if (hasLegMaturityMonthYear()) s += "LegMaturityMonthYear(610)= " + new String( FixUtils.trim(getLegMaturityMonthYear()) ) + "\n" ; 
		if (hasLegMaturityDate()) s += "LegMaturityDate(611)= " + new String( FixUtils.trim(getLegMaturityDate()) ) + "\n" ; 
		if (hasLegMaturityTime()) s += "LegMaturityTime(1212)= " + new String( FixUtils.trim(getLegMaturityTime()) ) + "\n" ; 
		if (hasLegCouponPaymentDate()) s += "LegCouponPaymentDate(248)= " + new String( FixUtils.trim(getLegCouponPaymentDate()) ) + "\n" ; 
		if (hasLegIssueDate()) s += "LegIssueDate(249)= " + new String( FixUtils.trim(getLegIssueDate()) ) + "\n" ; 
		if (hasLegRepoCollateralSecurityType()) s += "LegRepoCollateralSecurityType(250)= " + getLegRepoCollateralSecurityType() + "\n" ; 
		if (hasLegRepurchaseTerm()) s += "LegRepurchaseTerm(251)= " + getLegRepurchaseTerm() + "\n" ; 
		if (hasLegRepurchaseRate()) s += "LegRepurchaseRate(252)= " + getLegRepurchaseRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegFactor()) s += "LegFactor(253)= " + getLegFactor() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegCreditRating()) s += "LegCreditRating(257)= " + new String( FixUtils.trim(getLegCreditRating()) ) + "\n" ; 
		if (hasLegInstrRegistry()) s += "LegInstrRegistry(599)= " + new String( FixUtils.trim(getLegInstrRegistry()) ) + "\n" ; 
		if (hasLegCountryOfIssue()) s += "LegCountryOfIssue(596)= " + new String( FixUtils.trim(getLegCountryOfIssue()) ) + "\n" ; 
		if (hasLegStateOrProvinceOfIssue()) s += "LegStateOrProvinceOfIssue(597)= " + new String( FixUtils.trim(getLegStateOrProvinceOfIssue()) ) + "\n" ; 
		if (hasLegLocaleOfIssue()) s += "LegLocaleOfIssue(598)= " + new String( FixUtils.trim(getLegLocaleOfIssue()) ) + "\n" ; 
		if (hasLegRedemptionDate()) s += "LegRedemptionDate(254)= " + new String( FixUtils.trim(getLegRedemptionDate()) ) + "\n" ; 
		if (hasLegStrikePrice()) s += "LegStrikePrice(612)= " + getLegStrikePrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegStrikeCurrency()) s += "LegStrikeCurrency(942)= " + new String( FixUtils.trim(getLegStrikeCurrency()) ) + "\n" ; 
		if (hasLegOptAttribute()) s += "LegOptAttribute(613)= " + getLegOptAttribute() + "\n" ; 
		if (hasLegContractMultiplier()) s += "LegContractMultiplier(614)= " + getLegContractMultiplier() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegUnitOfMeasure()) s += "LegUnitOfMeasure(999)= " + new String( FixUtils.trim(getLegUnitOfMeasure()) ) + "\n" ; 
		if (hasLegTimeUnit()) s += "LegTimeUnit(1001)= " + new String( FixUtils.trim(getLegTimeUnit()) ) + "\n" ; 
		if (hasLegExerciseStyle()) s += "LegExerciseStyle(1420)= " + getLegExerciseStyle() + "\n" ; 
		if (hasLegUnitOfMeasureQty()) s += "LegUnitOfMeasureQty(1224)= " + getLegUnitOfMeasureQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegPriceUnitOfMeasure()) s += "LegPriceUnitOfMeasure(1421)= " + new String( FixUtils.trim(getLegPriceUnitOfMeasure()) ) + "\n" ; 
		if (hasLegPriceUnitOfMeasureQty()) s += "LegPriceUnitOfMeasureQty(1422)= " + getLegPriceUnitOfMeasureQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegContractMultiplierUnit()) s += "LegContractMultiplierUnit(1436)= " + getLegContractMultiplierUnit() + "\n" ; 
		if (hasLegFlowScheduleType()) s += "LegFlowScheduleType(1440)= " + getLegFlowScheduleType() + "\n" ; 
		if (hasLegCouponRate()) s += "LegCouponRate(615)= " + getLegCouponRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegSecurityExchange()) s += "LegSecurityExchange(616)= " + new String( FixUtils.trim(getLegSecurityExchange()) ) + "\n" ; 
		if (hasLegIssuer()) s += "LegIssuer(617)= " + new String( FixUtils.trim(getLegIssuer()) ) + "\n" ; 
		if (hasEncodedLegIssuerLen()) s += "EncodedLegIssuerLen(618)= " + getEncodedLegIssuerLen() + "\n" ; 
		if (hasEncodedLegIssuer()) s += "EncodedLegIssuer(619)= " + new String( FixUtils.trim(getEncodedLegIssuer()) ) + "\n" ; 
		if (hasLegSecurityDesc()) s += "LegSecurityDesc(620)= " + new String( FixUtils.trim(getLegSecurityDesc()) ) + "\n" ; 
		if (hasEncodedLegSecurityDescLen()) s += "EncodedLegSecurityDescLen(621)= " + getEncodedLegSecurityDescLen() + "\n" ; 
		if (hasEncodedLegSecurityDesc()) s += "EncodedLegSecurityDesc(622)= " + new String( FixUtils.trim(getEncodedLegSecurityDesc()) ) + "\n" ; 
		if (hasLegRatioQty()) s += "LegRatioQty(623)= " + getLegRatioQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegSide()) s += "LegSide(624)= " + getLegSide() + "\n" ; 
		if (hasLegCurrency()) s += "LegCurrency(556)= " + new String( FixUtils.trim(getLegCurrency()) ) + "\n" ; 
		if (hasLegPool()) s += "LegPool(740)= " + new String( FixUtils.trim(getLegPool()) ) + "\n" ; 
		if (hasLegDatedDate()) s += "LegDatedDate(739)= " + new String( FixUtils.trim(getLegDatedDate()) ) + "\n" ; 
		if (hasLegContractSettlMonth()) s += "LegContractSettlMonth(955)= " + new String( FixUtils.trim(getLegContractSettlMonth()) ) + "\n" ; 
		if (hasLegInterestAccrualDate()) s += "LegInterestAccrualDate(956)= " + new String( FixUtils.trim(getLegInterestAccrualDate()) ) + "\n" ; 
		if (hasLegOptionRatio()) s += "LegOptionRatio(1017)= " + getLegOptionRatio() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegPrice()) s += "LegPrice(566)= " + getLegPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegPutOrCall()) s += "LegPutOrCall(1358)= " + getLegPutOrCall() + "\n" ; 

		for (FixLegSecAltIDGrp fixLegSecAltIDGrp : legSecAltIDGrp) fixLegSecAltIDGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrumentLeg)) return false;

		FixInstrumentLeg msg = (FixInstrumentLeg) o;

		for (int i = 0; i < legSecAltIDGrp.length; i++)
			if (!legSecAltIDGrp[i].equals(msg.legSecAltIDGrp[i])) return false;
		if ((hasLegSymbol() && !msg.hasLegSymbol()) || (!hasLegSymbol() && msg.hasLegSymbol())) return false;
		if (!(!hasLegSymbol() && !msg.hasLegSymbol()) && !FixUtils.equals(getLegSymbol(), msg.getLegSymbol())) return false;
		if ((hasLegSymbolSfx() && !msg.hasLegSymbolSfx()) || (!hasLegSymbolSfx() && msg.hasLegSymbolSfx())) return false;
		if (!(!hasLegSymbolSfx() && !msg.hasLegSymbolSfx()) && !FixUtils.equals(getLegSymbolSfx(), msg.getLegSymbolSfx())) return false;
		if ((hasLegSecurityID() && !msg.hasLegSecurityID()) || (!hasLegSecurityID() && msg.hasLegSecurityID())) return false;
		if (!(!hasLegSecurityID() && !msg.hasLegSecurityID()) && !FixUtils.equals(getLegSecurityID(), msg.getLegSecurityID())) return false;
		if ((hasLegSecurityIDSource() && !msg.hasLegSecurityIDSource()) || (!hasLegSecurityIDSource() && msg.hasLegSecurityIDSource())) return false;
		if (!(!hasLegSecurityIDSource() && !msg.hasLegSecurityIDSource()) && !FixUtils.equals(getLegSecurityIDSource(), msg.getLegSecurityIDSource())) return false;
		if ((hasLegProduct() && !msg.hasLegProduct()) || (!hasLegProduct() && msg.hasLegProduct())) return false;
		if (!(!hasLegProduct() && !msg.hasLegProduct()) && !(getLegProduct()==msg.getLegProduct())) return false;
		if ((hasLegCFICode() && !msg.hasLegCFICode()) || (!hasLegCFICode() && msg.hasLegCFICode())) return false;
		if (!(!hasLegCFICode() && !msg.hasLegCFICode()) && !FixUtils.equals(getLegCFICode(), msg.getLegCFICode())) return false;
		if ((hasLegSecurityType() && !msg.hasLegSecurityType()) || (!hasLegSecurityType() && msg.hasLegSecurityType())) return false;
		if (!(!hasLegSecurityType() && !msg.hasLegSecurityType()) && !FixUtils.equals(getLegSecurityType(), msg.getLegSecurityType())) return false;
		if ((hasLegSecuritySubType() && !msg.hasLegSecuritySubType()) || (!hasLegSecuritySubType() && msg.hasLegSecuritySubType())) return false;
		if (!(!hasLegSecuritySubType() && !msg.hasLegSecuritySubType()) && !FixUtils.equals(getLegSecuritySubType(), msg.getLegSecuritySubType())) return false;
		if ((hasLegMaturityMonthYear() && !msg.hasLegMaturityMonthYear()) || (!hasLegMaturityMonthYear() && msg.hasLegMaturityMonthYear())) return false;
		if (!(!hasLegMaturityMonthYear() && !msg.hasLegMaturityMonthYear()) && !FixUtils.equals(getLegMaturityMonthYear(), msg.getLegMaturityMonthYear())) return false;
		if ((hasLegMaturityDate() && !msg.hasLegMaturityDate()) || (!hasLegMaturityDate() && msg.hasLegMaturityDate())) return false;
		if ((hasLegMaturityTime() && !msg.hasLegMaturityTime()) || (!hasLegMaturityTime() && msg.hasLegMaturityTime())) return false;
		if ((hasLegCouponPaymentDate() && !msg.hasLegCouponPaymentDate()) || (!hasLegCouponPaymentDate() && msg.hasLegCouponPaymentDate())) return false;
		if ((hasLegIssueDate() && !msg.hasLegIssueDate()) || (!hasLegIssueDate() && msg.hasLegIssueDate())) return false;
		if ((hasLegRepoCollateralSecurityType() && !msg.hasLegRepoCollateralSecurityType()) || (!hasLegRepoCollateralSecurityType() && msg.hasLegRepoCollateralSecurityType())) return false;
		if (!(!hasLegRepoCollateralSecurityType() && !msg.hasLegRepoCollateralSecurityType()) && !(getLegRepoCollateralSecurityType()==msg.getLegRepoCollateralSecurityType())) return false;
		if ((hasLegRepurchaseTerm() && !msg.hasLegRepurchaseTerm()) || (!hasLegRepurchaseTerm() && msg.hasLegRepurchaseTerm())) return false;
		if (!(!hasLegRepurchaseTerm() && !msg.hasLegRepurchaseTerm()) && !(getLegRepurchaseTerm()==msg.getLegRepurchaseTerm())) return false;
		if ((hasLegRepurchaseRate() && !msg.hasLegRepurchaseRate()) || (!hasLegRepurchaseRate() && msg.hasLegRepurchaseRate())) return false;
		if (!(!hasLegRepurchaseRate() && !msg.hasLegRepurchaseRate()) && !(getLegRepurchaseRate()==msg.getLegRepurchaseRate())) return false;
		if ((hasLegFactor() && !msg.hasLegFactor()) || (!hasLegFactor() && msg.hasLegFactor())) return false;
		if (!(!hasLegFactor() && !msg.hasLegFactor()) && !(getLegFactor()==msg.getLegFactor())) return false;
		if ((hasLegCreditRating() && !msg.hasLegCreditRating()) || (!hasLegCreditRating() && msg.hasLegCreditRating())) return false;
		if (!(!hasLegCreditRating() && !msg.hasLegCreditRating()) && !FixUtils.equals(getLegCreditRating(), msg.getLegCreditRating())) return false;
		if ((hasLegInstrRegistry() && !msg.hasLegInstrRegistry()) || (!hasLegInstrRegistry() && msg.hasLegInstrRegistry())) return false;
		if (!(!hasLegInstrRegistry() && !msg.hasLegInstrRegistry()) && !FixUtils.equals(getLegInstrRegistry(), msg.getLegInstrRegistry())) return false;
		if ((hasLegCountryOfIssue() && !msg.hasLegCountryOfIssue()) || (!hasLegCountryOfIssue() && msg.hasLegCountryOfIssue())) return false;
		if (!(!hasLegCountryOfIssue() && !msg.hasLegCountryOfIssue()) && !FixUtils.equals(getLegCountryOfIssue(), msg.getLegCountryOfIssue())) return false;
		if ((hasLegStateOrProvinceOfIssue() && !msg.hasLegStateOrProvinceOfIssue()) || (!hasLegStateOrProvinceOfIssue() && msg.hasLegStateOrProvinceOfIssue())) return false;
		if (!(!hasLegStateOrProvinceOfIssue() && !msg.hasLegStateOrProvinceOfIssue()) && !FixUtils.equals(getLegStateOrProvinceOfIssue(), msg.getLegStateOrProvinceOfIssue())) return false;
		if ((hasLegLocaleOfIssue() && !msg.hasLegLocaleOfIssue()) || (!hasLegLocaleOfIssue() && msg.hasLegLocaleOfIssue())) return false;
		if (!(!hasLegLocaleOfIssue() && !msg.hasLegLocaleOfIssue()) && !FixUtils.equals(getLegLocaleOfIssue(), msg.getLegLocaleOfIssue())) return false;
		if ((hasLegRedemptionDate() && !msg.hasLegRedemptionDate()) || (!hasLegRedemptionDate() && msg.hasLegRedemptionDate())) return false;
		if ((hasLegStrikePrice() && !msg.hasLegStrikePrice()) || (!hasLegStrikePrice() && msg.hasLegStrikePrice())) return false;
		if (!(!hasLegStrikePrice() && !msg.hasLegStrikePrice()) && !(getLegStrikePrice()==msg.getLegStrikePrice())) return false;
		if ((hasLegStrikeCurrency() && !msg.hasLegStrikeCurrency()) || (!hasLegStrikeCurrency() && msg.hasLegStrikeCurrency())) return false;
		if (!(!hasLegStrikeCurrency() && !msg.hasLegStrikeCurrency()) && !FixUtils.equals(getLegStrikeCurrency(), msg.getLegStrikeCurrency())) return false;
		if ((hasLegOptAttribute() && !msg.hasLegOptAttribute()) || (!hasLegOptAttribute() && msg.hasLegOptAttribute())) return false;
		if (!(!hasLegOptAttribute() && !msg.hasLegOptAttribute()) && !(getLegOptAttribute()==msg.getLegOptAttribute())) return false;
		if ((hasLegContractMultiplier() && !msg.hasLegContractMultiplier()) || (!hasLegContractMultiplier() && msg.hasLegContractMultiplier())) return false;
		if (!(!hasLegContractMultiplier() && !msg.hasLegContractMultiplier()) && !(getLegContractMultiplier()==msg.getLegContractMultiplier())) return false;
		if ((hasLegUnitOfMeasure() && !msg.hasLegUnitOfMeasure()) || (!hasLegUnitOfMeasure() && msg.hasLegUnitOfMeasure())) return false;
		if (!(!hasLegUnitOfMeasure() && !msg.hasLegUnitOfMeasure()) && !FixUtils.equals(getLegUnitOfMeasure(), msg.getLegUnitOfMeasure())) return false;
		if ((hasLegTimeUnit() && !msg.hasLegTimeUnit()) || (!hasLegTimeUnit() && msg.hasLegTimeUnit())) return false;
		if (!(!hasLegTimeUnit() && !msg.hasLegTimeUnit()) && !FixUtils.equals(getLegTimeUnit(), msg.getLegTimeUnit())) return false;
		if ((hasLegExerciseStyle() && !msg.hasLegExerciseStyle()) || (!hasLegExerciseStyle() && msg.hasLegExerciseStyle())) return false;
		if (!(!hasLegExerciseStyle() && !msg.hasLegExerciseStyle()) && !(getLegExerciseStyle()==msg.getLegExerciseStyle())) return false;
		if ((hasLegUnitOfMeasureQty() && !msg.hasLegUnitOfMeasureQty()) || (!hasLegUnitOfMeasureQty() && msg.hasLegUnitOfMeasureQty())) return false;
		if (!(!hasLegUnitOfMeasureQty() && !msg.hasLegUnitOfMeasureQty()) && !(getLegUnitOfMeasureQty()==msg.getLegUnitOfMeasureQty())) return false;
		if ((hasLegPriceUnitOfMeasure() && !msg.hasLegPriceUnitOfMeasure()) || (!hasLegPriceUnitOfMeasure() && msg.hasLegPriceUnitOfMeasure())) return false;
		if (!(!hasLegPriceUnitOfMeasure() && !msg.hasLegPriceUnitOfMeasure()) && !FixUtils.equals(getLegPriceUnitOfMeasure(), msg.getLegPriceUnitOfMeasure())) return false;
		if ((hasLegPriceUnitOfMeasureQty() && !msg.hasLegPriceUnitOfMeasureQty()) || (!hasLegPriceUnitOfMeasureQty() && msg.hasLegPriceUnitOfMeasureQty())) return false;
		if (!(!hasLegPriceUnitOfMeasureQty() && !msg.hasLegPriceUnitOfMeasureQty()) && !(getLegPriceUnitOfMeasureQty()==msg.getLegPriceUnitOfMeasureQty())) return false;
		if ((hasLegContractMultiplierUnit() && !msg.hasLegContractMultiplierUnit()) || (!hasLegContractMultiplierUnit() && msg.hasLegContractMultiplierUnit())) return false;
		if (!(!hasLegContractMultiplierUnit() && !msg.hasLegContractMultiplierUnit()) && !(getLegContractMultiplierUnit()==msg.getLegContractMultiplierUnit())) return false;
		if ((hasLegFlowScheduleType() && !msg.hasLegFlowScheduleType()) || (!hasLegFlowScheduleType() && msg.hasLegFlowScheduleType())) return false;
		if (!(!hasLegFlowScheduleType() && !msg.hasLegFlowScheduleType()) && !(getLegFlowScheduleType()==msg.getLegFlowScheduleType())) return false;
		if ((hasLegCouponRate() && !msg.hasLegCouponRate()) || (!hasLegCouponRate() && msg.hasLegCouponRate())) return false;
		if (!(!hasLegCouponRate() && !msg.hasLegCouponRate()) && !(getLegCouponRate()==msg.getLegCouponRate())) return false;
		if ((hasLegSecurityExchange() && !msg.hasLegSecurityExchange()) || (!hasLegSecurityExchange() && msg.hasLegSecurityExchange())) return false;
		if (!(!hasLegSecurityExchange() && !msg.hasLegSecurityExchange()) && !FixUtils.equals(getLegSecurityExchange(), msg.getLegSecurityExchange())) return false;
		if ((hasLegIssuer() && !msg.hasLegIssuer()) || (!hasLegIssuer() && msg.hasLegIssuer())) return false;
		if (!(!hasLegIssuer() && !msg.hasLegIssuer()) && !FixUtils.equals(getLegIssuer(), msg.getLegIssuer())) return false;
		if ((hasEncodedLegIssuerLen() && !msg.hasEncodedLegIssuerLen()) || (!hasEncodedLegIssuerLen() && msg.hasEncodedLegIssuerLen())) return false;
		if (!(!hasEncodedLegIssuerLen() && !msg.hasEncodedLegIssuerLen()) && !(getEncodedLegIssuerLen()==msg.getEncodedLegIssuerLen())) return false;
		if ((hasEncodedLegIssuer() && !msg.hasEncodedLegIssuer()) || (!hasEncodedLegIssuer() && msg.hasEncodedLegIssuer())) return false;
		if (!(!hasEncodedLegIssuer() && !msg.hasEncodedLegIssuer()) && !FixUtils.equals(getEncodedLegIssuer(), msg.getEncodedLegIssuer())) return false;
		if ((hasLegSecurityDesc() && !msg.hasLegSecurityDesc()) || (!hasLegSecurityDesc() && msg.hasLegSecurityDesc())) return false;
		if (!(!hasLegSecurityDesc() && !msg.hasLegSecurityDesc()) && !FixUtils.equals(getLegSecurityDesc(), msg.getLegSecurityDesc())) return false;
		if ((hasEncodedLegSecurityDescLen() && !msg.hasEncodedLegSecurityDescLen()) || (!hasEncodedLegSecurityDescLen() && msg.hasEncodedLegSecurityDescLen())) return false;
		if (!(!hasEncodedLegSecurityDescLen() && !msg.hasEncodedLegSecurityDescLen()) && !(getEncodedLegSecurityDescLen()==msg.getEncodedLegSecurityDescLen())) return false;
		if ((hasEncodedLegSecurityDesc() && !msg.hasEncodedLegSecurityDesc()) || (!hasEncodedLegSecurityDesc() && msg.hasEncodedLegSecurityDesc())) return false;
		if (!(!hasEncodedLegSecurityDesc() && !msg.hasEncodedLegSecurityDesc()) && !FixUtils.equals(getEncodedLegSecurityDesc(), msg.getEncodedLegSecurityDesc())) return false;
		if ((hasLegRatioQty() && !msg.hasLegRatioQty()) || (!hasLegRatioQty() && msg.hasLegRatioQty())) return false;
		if (!(!hasLegRatioQty() && !msg.hasLegRatioQty()) && !(getLegRatioQty()==msg.getLegRatioQty())) return false;
		if ((hasLegSide() && !msg.hasLegSide()) || (!hasLegSide() && msg.hasLegSide())) return false;
		if (!(!hasLegSide() && !msg.hasLegSide()) && !(getLegSide()==msg.getLegSide())) return false;
		if ((hasLegCurrency() && !msg.hasLegCurrency()) || (!hasLegCurrency() && msg.hasLegCurrency())) return false;
		if (!(!hasLegCurrency() && !msg.hasLegCurrency()) && !FixUtils.equals(getLegCurrency(), msg.getLegCurrency())) return false;
		if ((hasLegPool() && !msg.hasLegPool()) || (!hasLegPool() && msg.hasLegPool())) return false;
		if (!(!hasLegPool() && !msg.hasLegPool()) && !FixUtils.equals(getLegPool(), msg.getLegPool())) return false;
		if ((hasLegDatedDate() && !msg.hasLegDatedDate()) || (!hasLegDatedDate() && msg.hasLegDatedDate())) return false;
		if ((hasLegContractSettlMonth() && !msg.hasLegContractSettlMonth()) || (!hasLegContractSettlMonth() && msg.hasLegContractSettlMonth())) return false;
		if (!(!hasLegContractSettlMonth() && !msg.hasLegContractSettlMonth()) && !FixUtils.equals(getLegContractSettlMonth(), msg.getLegContractSettlMonth())) return false;
		if ((hasLegInterestAccrualDate() && !msg.hasLegInterestAccrualDate()) || (!hasLegInterestAccrualDate() && msg.hasLegInterestAccrualDate())) return false;
		if ((hasLegOptionRatio() && !msg.hasLegOptionRatio()) || (!hasLegOptionRatio() && msg.hasLegOptionRatio())) return false;
		if (!(!hasLegOptionRatio() && !msg.hasLegOptionRatio()) && !(getLegOptionRatio()==msg.getLegOptionRatio())) return false;
		if ((hasLegPrice() && !msg.hasLegPrice()) || (!hasLegPrice() && msg.hasLegPrice())) return false;
		if (!(!hasLegPrice() && !msg.hasLegPrice()) && !(getLegPrice()==msg.getLegPrice())) return false;
		if ((hasLegPutOrCall() && !msg.hasLegPutOrCall()) || (!hasLegPutOrCall() && msg.hasLegPutOrCall())) return false;
		if (!(!hasLegPutOrCall() && !msg.hasLegPutOrCall()) && !(getLegPutOrCall()==msg.getLegPutOrCall())) return false;
		return true;
	}
	public FixInstrumentLeg clone ( FixInstrumentLeg out ) {
		if ( hasLegSymbol())
			out.setLegSymbol(getLegSymbol());
		if ( hasLegSymbolSfx())
			out.setLegSymbolSfx(getLegSymbolSfx());
		if ( hasLegSecurityID())
			out.setLegSecurityID(getLegSecurityID());
		if ( hasLegSecurityIDSource())
			out.setLegSecurityIDSource(getLegSecurityIDSource());
		if ( hasLegProduct())
			out.setLegProduct(getLegProduct());
		if ( hasLegCFICode())
			out.setLegCFICode(getLegCFICode());
		if ( hasLegSecurityType())
			out.setLegSecurityType(getLegSecurityType());
		if ( hasLegSecuritySubType())
			out.setLegSecuritySubType(getLegSecuritySubType());
		if ( hasLegMaturityMonthYear())
			out.setLegMaturityMonthYear(getLegMaturityMonthYear());
		if ( hasLegMaturityDate())
			out.setLegMaturityDate(getLegMaturityDate());
		if ( hasLegMaturityTime())
			out.setLegMaturityTime(getLegMaturityTime());
		if ( hasLegCouponPaymentDate())
			out.setLegCouponPaymentDate(getLegCouponPaymentDate());
		if ( hasLegIssueDate())
			out.setLegIssueDate(getLegIssueDate());
		if ( hasLegRepoCollateralSecurityType())
			out.setLegRepoCollateralSecurityType(getLegRepoCollateralSecurityType());
		if ( hasLegRepurchaseTerm())
			out.setLegRepurchaseTerm(getLegRepurchaseTerm());
		if ( hasLegRepurchaseRate())
			out.setLegRepurchaseRate(getLegRepurchaseRate());
		if ( hasLegFactor())
			out.setLegFactor(getLegFactor());
		if ( hasLegCreditRating())
			out.setLegCreditRating(getLegCreditRating());
		if ( hasLegInstrRegistry())
			out.setLegInstrRegistry(getLegInstrRegistry());
		if ( hasLegCountryOfIssue())
			out.setLegCountryOfIssue(getLegCountryOfIssue());
		if ( hasLegStateOrProvinceOfIssue())
			out.setLegStateOrProvinceOfIssue(getLegStateOrProvinceOfIssue());
		if ( hasLegLocaleOfIssue())
			out.setLegLocaleOfIssue(getLegLocaleOfIssue());
		if ( hasLegRedemptionDate())
			out.setLegRedemptionDate(getLegRedemptionDate());
		if ( hasLegStrikePrice())
			out.setLegStrikePrice(getLegStrikePrice());
		if ( hasLegStrikeCurrency())
			out.setLegStrikeCurrency(getLegStrikeCurrency());
		if ( hasLegOptAttribute())
			out.setLegOptAttribute(getLegOptAttribute());
		if ( hasLegContractMultiplier())
			out.setLegContractMultiplier(getLegContractMultiplier());
		if ( hasLegUnitOfMeasure())
			out.setLegUnitOfMeasure(getLegUnitOfMeasure());
		if ( hasLegTimeUnit())
			out.setLegTimeUnit(getLegTimeUnit());
		if ( hasLegExerciseStyle())
			out.setLegExerciseStyle(getLegExerciseStyle());
		if ( hasLegUnitOfMeasureQty())
			out.setLegUnitOfMeasureQty(getLegUnitOfMeasureQty());
		if ( hasLegPriceUnitOfMeasure())
			out.setLegPriceUnitOfMeasure(getLegPriceUnitOfMeasure());
		if ( hasLegPriceUnitOfMeasureQty())
			out.setLegPriceUnitOfMeasureQty(getLegPriceUnitOfMeasureQty());
		if ( hasLegContractMultiplierUnit())
			out.setLegContractMultiplierUnit(getLegContractMultiplierUnit());
		if ( hasLegFlowScheduleType())
			out.setLegFlowScheduleType(getLegFlowScheduleType());
		if ( hasLegCouponRate())
			out.setLegCouponRate(getLegCouponRate());
		if ( hasLegSecurityExchange())
			out.setLegSecurityExchange(getLegSecurityExchange());
		if ( hasLegIssuer())
			out.setLegIssuer(getLegIssuer());
		if ( hasEncodedLegIssuerLen())
			out.setEncodedLegIssuerLen(getEncodedLegIssuerLen());
		if ( hasEncodedLegIssuer())
			out.setEncodedLegIssuer(getEncodedLegIssuer());
		if ( hasLegSecurityDesc())
			out.setLegSecurityDesc(getLegSecurityDesc());
		if ( hasEncodedLegSecurityDescLen())
			out.setEncodedLegSecurityDescLen(getEncodedLegSecurityDescLen());
		if ( hasEncodedLegSecurityDesc())
			out.setEncodedLegSecurityDesc(getEncodedLegSecurityDesc());
		if ( hasLegRatioQty())
			out.setLegRatioQty(getLegRatioQty());
		if ( hasLegSide())
			out.setLegSide(getLegSide());
		if ( hasLegCurrency())
			out.setLegCurrency(getLegCurrency());
		if ( hasLegPool())
			out.setLegPool(getLegPool());
		if ( hasLegDatedDate())
			out.setLegDatedDate(getLegDatedDate());
		if ( hasLegContractSettlMonth())
			out.setLegContractSettlMonth(getLegContractSettlMonth());
		if ( hasLegInterestAccrualDate())
			out.setLegInterestAccrualDate(getLegInterestAccrualDate());
		if ( hasLegOptionRatio())
			out.setLegOptionRatio(getLegOptionRatio());
		if ( hasLegPrice())
			out.setLegPrice(getLegPrice());
		if ( hasLegPutOrCall())
			out.setLegPutOrCall(getLegPutOrCall());
		int count = 0;
		count = 0;
		for (FixLegSecAltIDGrp fixLegSecAltIDGrp : legSecAltIDGrp) {
			if (!fixLegSecAltIDGrp.hasGroup()) continue;
			out.legSecAltIDGrp[count] = fixLegSecAltIDGrp.clone( out.legSecAltIDGrp[count] );
			count++;
		}
		return out;
	}

}
