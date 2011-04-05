package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSideCrossOrdModGrp extends FixGroup {
	private short hasSide;
	byte side = (byte)' ';		
	private short hasOrigClOrdID;
	byte[] origClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryClOrdID;
	byte[] secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClOrdLinkID;
	byte[] clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
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
	private short hasPreallocMethod;
	byte preallocMethod = (byte)' ';		
	private short hasAllocID;
	byte[] allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQtyType;
	long qtyType = 0;		
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
	private short hasPositionEffect;
	byte positionEffect = (byte)' ';		
	private short hasCoveredOrUncovered;
	long coveredOrUncovered = 0;		
	private short hasCashMargin;
	byte cashMargin = (byte)' ';		
	private short hasClearingFeeIndicator;
	byte[] clearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSolicitedFlag;
		boolean solicitedFlag = false;		
	private short hasSideComplianceID;
	byte[] sideComplianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSideTimeInForce;
	byte[] sideTimeInForce = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		public FixParties[] parties;
		public FixPreAllocGrp[] preAllocGrp;
		public FixOrderQtyData orderQtyData;
		public FixCommissionData commissionData;
	
	public FixSideCrossOrdModGrp() {
		this(false);
	}

	public FixSideCrossOrdModGrp(boolean isRequired) {
		super(FixTags.SIDE_INT);

		this.isRequired = isRequired;
		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrigClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		origClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClOrdLinkID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
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
		hasPreallocMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQtyType = FixUtils.TAG_HAS_NO_VALUE;		
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
		hasPositionEffect = FixUtils.TAG_HAS_NO_VALUE;		
		hasCoveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;		
		hasCashMargin = FixUtils.TAG_HAS_NO_VALUE;		
		hasClearingFeeIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		clearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSolicitedFlag = FixUtils.TAG_HAS_NO_VALUE;		
		hasSideComplianceID = FixUtils.TAG_HAS_NO_VALUE;		
		sideComplianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSideTimeInForce = FixUtils.TAG_HAS_NO_VALUE;		
		sideTimeInForce = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		preAllocGrp = new FixPreAllocGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) preAllocGrp[i] = new FixPreAllocGrp();
		orderQtyData = new FixOrderQtyData(true);
		commissionData = new FixCommissionData();
		
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
            	case FixTags.ORIGCLORDID_INT:		
            		hasOrigClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYCLORDID_INT:		
            		hasSecondaryClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CLORDLINKID_INT:		
            		hasClOrdLinkID = (short) buf.position();		
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
            	case FixTags.PREALLOCMETHOD_INT:		
            		hasPreallocMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCID_INT:		
            		hasAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.QTYTYPE_INT:		
            		hasQtyType = (short) buf.position();		
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
            	case FixTags.POSITIONEFFECT_INT:		
            		hasPositionEffect = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.COVEREDORUNCOVERED_INT:		
            		hasCoveredOrUncovered = (short) buf.position();		
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
            	case FixTags.SOLICITEDFLAG_INT:		
            		hasSolicitedFlag = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDECOMPLIANCEID_INT:		
            		hasSideComplianceID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDETIMEINFORCE_INT:		
            		hasSideTimeInForce = (short) buf.position();		
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
        			} else if ( orderQtyData.isKeyTag(tag)) {
        				tag = orderQtyData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( commissionData.isKeyTag(tag)) {
        				tag = commissionData.setBuffer( tag, buf, err);		
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
		if (!hasClOrdID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ClOrdID missing", FixTags.CLORDID_INT);
			return false;
		}
		if (orderQtyData.isRequired) orderQtyData.hasRequiredTags(err); if (err.hasError()) return false;
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasSide = FixUtils.TAG_HAS_NO_VALUE;
		hasOrigClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasClOrdLinkID = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeOriginationDate = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;
		hasAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasAccountType = FixUtils.TAG_HAS_NO_VALUE;
		hasDayBookingInst = FixUtils.TAG_HAS_NO_VALUE;
		hasBookingUnit = FixUtils.TAG_HAS_NO_VALUE;
		hasPreallocMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocID = FixUtils.TAG_HAS_NO_VALUE;
		hasQtyType = FixUtils.TAG_HAS_NO_VALUE;
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
		hasPositionEffect = FixUtils.TAG_HAS_NO_VALUE;
		hasCoveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;
		hasCashMargin = FixUtils.TAG_HAS_NO_VALUE;
		hasClearingFeeIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasSolicitedFlag = FixUtils.TAG_HAS_NO_VALUE;
		hasSideComplianceID = FixUtils.TAG_HAS_NO_VALUE;
		hasSideTimeInForce = FixUtils.TAG_HAS_NO_VALUE;
		for (FixParties fixParties : parties) fixParties.clear();
		for (FixPreAllocGrp fixPreAllocGrp : preAllocGrp) fixPreAllocGrp.clear();
		orderQtyData.clear();
		commissionData.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSide()) {		
			out.put(FixTags.SIDE);

			out.put((byte) '=');

			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrigClOrdID()) {		
			out.put(FixTags.ORIGCLORDID);

			out.put((byte) '=');

			FixUtils.put(out,origClOrdID); 		
		
			out.put(FixUtils.SOH);

            }

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

		if (hasClOrdLinkID()) {		
			out.put(FixTags.CLORDLINKID);

			out.put((byte) '=');

			FixUtils.put(out,clOrdLinkID); 		
		
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

		if (hasQtyType()) {		
			out.put(FixTags.QTYTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)qtyType);
		
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

		if (hasSolicitedFlag()) {		
			out.put(FixTags.SOLICITEDFLAG);

			out.put((byte) '=');

			out.put(solicitedFlag?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasSideComplianceID()) {		
			out.put(FixTags.SIDECOMPLIANCEID);

			out.put((byte) '=');

			FixUtils.put(out,sideComplianceID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSideTimeInForce()) {		
			out.put(FixTags.SIDETIMEINFORCE);

			out.put((byte) '=');

			FixUtils.put(out,sideTimeInForce); 		
		
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
		orderQtyData.encode(out);
		commissionData.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigClOrdID()) {		
			FixUtils.put(out,origClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryClOrdID()) {		
			FixUtils.put(out,secondaryClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdLinkID()) {		
			FixUtils.put(out,clOrdLinkID); 		
		
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
		
		if (hasPreallocMethod()) {		
			FixUtils.put(out,preallocMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocID()) {		
			FixUtils.put(out,allocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQtyType()) {		
			FixUtils.put(out, (long)qtyType);
		
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
		
		if (hasPositionEffect()) {		
			FixUtils.put(out,positionEffect); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCoveredOrUncovered()) {		
			FixUtils.put(out, (long)coveredOrUncovered);
		
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
		
		if (hasSolicitedFlag()) {		
			out.put(solicitedFlag?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideComplianceID()) {		
			FixUtils.put(out,sideComplianceID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideTimeInForce()) {		
			FixUtils.put(out,sideTimeInForce); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixParties fixParties : parties) fixParties.printBuffer(out);
		for (FixPreAllocGrp fixPreAllocGrp : preAllocGrp) fixPreAllocGrp.printBuffer(out);
		orderQtyData.printBuffer(out);
		commissionData.printBuffer(out);
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
			
	public byte[] getOrigClOrdID() { 		
		if ( hasOrigClOrdID()) {		
			if (hasOrigClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return origClOrdID; 		
			} else {		
		
				buf.position(hasOrigClOrdID);		
		
			FixMessage.getTagStringValue(buf, origClOrdID, 0, origClOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOrigClOrdID);		
					return null;		
				}		
			}		
			hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
			return origClOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigClOrdID() { return hasOrigClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrigClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasOrigClOrdID()) FixUtils.fillNul(origClOrdID);		
		FixUtils.copy(origClOrdID, src); 		
		hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrigClOrdID(String str) {		
		if (str == null ) return;
		if (hasOrigClOrdID()) FixUtils.fillNul(origClOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origClOrdID, src); 		
		hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getSideComplianceID() { 		
		if ( hasSideComplianceID()) {		
			if (hasSideComplianceID == FixUtils.TAG_HAS_VALUE) {		
				return sideComplianceID; 		
			} else {		
		
				buf.position(hasSideComplianceID);		
		
			FixMessage.getTagStringValue(buf, sideComplianceID, 0, sideComplianceID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSideComplianceID);		
					return null;		
				}		
			}		
			hasSideComplianceID = FixUtils.TAG_HAS_VALUE;		
			return sideComplianceID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSideComplianceID() { return hasSideComplianceID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideComplianceID(byte[] src) {		
		if (src == null ) return;
		if (hasSideComplianceID()) FixUtils.fillNul(sideComplianceID);		
		FixUtils.copy(sideComplianceID, src); 		
		hasSideComplianceID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideComplianceID(String str) {		
		if (str == null ) return;
		if (hasSideComplianceID()) FixUtils.fillNul(sideComplianceID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(sideComplianceID, src); 		
		hasSideComplianceID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSideTimeInForce() { 		
		if ( hasSideTimeInForce()) {		
			if (hasSideTimeInForce == FixUtils.TAG_HAS_VALUE) {		
				return sideTimeInForce; 		
			} else {		
		
				buf.position(hasSideTimeInForce);		
		
			FixMessage.getTagStringValue(buf, sideTimeInForce, 0, sideTimeInForce.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSideTimeInForce);		
					return null;		
				}		
			}		
			hasSideTimeInForce = FixUtils.TAG_HAS_VALUE;		
			return sideTimeInForce;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSideTimeInForce() { return hasSideTimeInForce != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideTimeInForce(byte[] src) {		
		if (src == null ) return;
		if (hasSideTimeInForce()) FixUtils.fillNul(sideTimeInForce);		
		FixUtils.copy(sideTimeInForce, src); 		
		hasSideTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideTimeInForce(String str) {		
		if (str == null ) return;
		if (hasSideTimeInForce()) FixUtils.fillNul(sideTimeInForce);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(sideTimeInForce, src); 		
		hasSideTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasOrigClOrdID()) s += "OrigClOrdID(41)= " + new String( FixUtils.trim(getOrigClOrdID()) ) + "\n" ; 
		if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasSecondaryClOrdID()) s += "SecondaryClOrdID(526)= " + new String( FixUtils.trim(getSecondaryClOrdID()) ) + "\n" ; 
		if (hasClOrdLinkID()) s += "ClOrdLinkID(583)= " + new String( FixUtils.trim(getClOrdLinkID()) ) + "\n" ; 
		if (hasTradeOriginationDate()) s += "TradeOriginationDate(229)= " + new String( FixUtils.trim(getTradeOriginationDate()) ) + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAcctIDSource()) s += "AcctIDSource(660)= " + getAcctIDSource() + "\n" ; 
		if (hasAccountType()) s += "AccountType(581)= " + getAccountType() + "\n" ; 
		if (hasDayBookingInst()) s += "DayBookingInst(589)= " + getDayBookingInst() + "\n" ; 
		if (hasBookingUnit()) s += "BookingUnit(590)= " + getBookingUnit() + "\n" ; 
		if (hasPreallocMethod()) s += "PreallocMethod(591)= " + getPreallocMethod() + "\n" ; 
		if (hasAllocID()) s += "AllocID(70)= " + new String( FixUtils.trim(getAllocID()) ) + "\n" ; 
		if (hasQtyType()) s += "QtyType(854)= " + getQtyType() + "\n" ; 
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
		if (hasPositionEffect()) s += "PositionEffect(77)= " + getPositionEffect() + "\n" ; 
		if (hasCoveredOrUncovered()) s += "CoveredOrUncovered(203)= " + getCoveredOrUncovered() + "\n" ; 
		if (hasCashMargin()) s += "CashMargin(544)= " + getCashMargin() + "\n" ; 
		if (hasClearingFeeIndicator()) s += "ClearingFeeIndicator(635)= " + new String( FixUtils.trim(getClearingFeeIndicator()) ) + "\n" ; 
		if (hasSolicitedFlag()) s += "SolicitedFlag(377)= " + getSolicitedFlag() + "\n" ; 
		if (hasSideComplianceID()) s += "SideComplianceID(659)= " + new String( FixUtils.trim(getSideComplianceID()) ) + "\n" ; 
		if (hasSideTimeInForce()) s += "SideTimeInForce(962)= " + new String( FixUtils.trim(getSideTimeInForce()) ) + "\n" ; 

		for (FixParties fixParties : parties) fixParties.toString();
		for (FixPreAllocGrp fixPreAllocGrp : preAllocGrp) fixPreAllocGrp.toString();
		s += orderQtyData.toString();
		s += commissionData.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSideCrossOrdModGrp)) return false;

		FixSideCrossOrdModGrp msg = (FixSideCrossOrdModGrp) o;

		for (int i = 0; i < parties.length; i++)
			if (!parties[i].equals(msg.parties[i])) return false;
		for (int i = 0; i < preAllocGrp.length; i++)
			if (!preAllocGrp[i].equals(msg.preAllocGrp[i])) return false;
		if (!orderQtyData.equals(msg.orderQtyData)) return false;
		if (!commissionData.equals(msg.commissionData)) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasOrigClOrdID() && !msg.hasOrigClOrdID()) || (!hasOrigClOrdID() && msg.hasOrigClOrdID())) return false;
		if (!(!hasOrigClOrdID() && !msg.hasOrigClOrdID()) && !FixUtils.equals(getOrigClOrdID(), msg.getOrigClOrdID())) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) || (!hasSecondaryClOrdID() && msg.hasSecondaryClOrdID())) return false;
		if (!(!hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) && !FixUtils.equals(getSecondaryClOrdID(), msg.getSecondaryClOrdID())) return false;
		if ((hasClOrdLinkID() && !msg.hasClOrdLinkID()) || (!hasClOrdLinkID() && msg.hasClOrdLinkID())) return false;
		if (!(!hasClOrdLinkID() && !msg.hasClOrdLinkID()) && !FixUtils.equals(getClOrdLinkID(), msg.getClOrdLinkID())) return false;
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
		if ((hasPreallocMethod() && !msg.hasPreallocMethod()) || (!hasPreallocMethod() && msg.hasPreallocMethod())) return false;
		if (!(!hasPreallocMethod() && !msg.hasPreallocMethod()) && !(getPreallocMethod()==msg.getPreallocMethod())) return false;
		if ((hasAllocID() && !msg.hasAllocID()) || (!hasAllocID() && msg.hasAllocID())) return false;
		if (!(!hasAllocID() && !msg.hasAllocID()) && !FixUtils.equals(getAllocID(), msg.getAllocID())) return false;
		if ((hasQtyType() && !msg.hasQtyType()) || (!hasQtyType() && msg.hasQtyType())) return false;
		if (!(!hasQtyType() && !msg.hasQtyType()) && !(getQtyType()==msg.getQtyType())) return false;
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
		if ((hasPositionEffect() && !msg.hasPositionEffect()) || (!hasPositionEffect() && msg.hasPositionEffect())) return false;
		if (!(!hasPositionEffect() && !msg.hasPositionEffect()) && !(getPositionEffect()==msg.getPositionEffect())) return false;
		if ((hasCoveredOrUncovered() && !msg.hasCoveredOrUncovered()) || (!hasCoveredOrUncovered() && msg.hasCoveredOrUncovered())) return false;
		if (!(!hasCoveredOrUncovered() && !msg.hasCoveredOrUncovered()) && !(getCoveredOrUncovered()==msg.getCoveredOrUncovered())) return false;
		if ((hasCashMargin() && !msg.hasCashMargin()) || (!hasCashMargin() && msg.hasCashMargin())) return false;
		if (!(!hasCashMargin() && !msg.hasCashMargin()) && !(getCashMargin()==msg.getCashMargin())) return false;
		if ((hasClearingFeeIndicator() && !msg.hasClearingFeeIndicator()) || (!hasClearingFeeIndicator() && msg.hasClearingFeeIndicator())) return false;
		if (!(!hasClearingFeeIndicator() && !msg.hasClearingFeeIndicator()) && !FixUtils.equals(getClearingFeeIndicator(), msg.getClearingFeeIndicator())) return false;
		if ((hasSolicitedFlag() && !msg.hasSolicitedFlag()) || (!hasSolicitedFlag() && msg.hasSolicitedFlag())) return false;
		if (!(!hasSolicitedFlag() && !msg.hasSolicitedFlag()) && !(getSolicitedFlag()==msg.getSolicitedFlag())) return false;
		if ((hasSideComplianceID() && !msg.hasSideComplianceID()) || (!hasSideComplianceID() && msg.hasSideComplianceID())) return false;
		if (!(!hasSideComplianceID() && !msg.hasSideComplianceID()) && !FixUtils.equals(getSideComplianceID(), msg.getSideComplianceID())) return false;
		if ((hasSideTimeInForce() && !msg.hasSideTimeInForce()) || (!hasSideTimeInForce() && msg.hasSideTimeInForce())) return false;
		return true;
	}
	public FixSideCrossOrdModGrp clone ( FixSideCrossOrdModGrp out ) {
		if ( hasSide())
			out.setSide(getSide());
		if ( hasOrigClOrdID())
			out.setOrigClOrdID(getOrigClOrdID());
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasSecondaryClOrdID())
			out.setSecondaryClOrdID(getSecondaryClOrdID());
		if ( hasClOrdLinkID())
			out.setClOrdLinkID(getClOrdLinkID());
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
		if ( hasPreallocMethod())
			out.setPreallocMethod(getPreallocMethod());
		if ( hasAllocID())
			out.setAllocID(getAllocID());
		if ( hasQtyType())
			out.setQtyType(getQtyType());
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
		if ( hasPositionEffect())
			out.setPositionEffect(getPositionEffect());
		if ( hasCoveredOrUncovered())
			out.setCoveredOrUncovered(getCoveredOrUncovered());
		if ( hasCashMargin())
			out.setCashMargin(getCashMargin());
		if ( hasClearingFeeIndicator())
			out.setClearingFeeIndicator(getClearingFeeIndicator());
		if ( hasSolicitedFlag())
			out.setSolicitedFlag(getSolicitedFlag());
		if ( hasSideComplianceID())
			out.setSideComplianceID(getSideComplianceID());
		if ( hasSideTimeInForce())
			out.setSideTimeInForce(getSideTimeInForce());
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
		if (orderQtyData.hasGroup())
			out.orderQtyData = orderQtyData.clone( out.orderQtyData);
		if (commissionData.hasGroup())
			out.commissionData = commissionData.clone( out.commissionData);
		return out;
	}

}
