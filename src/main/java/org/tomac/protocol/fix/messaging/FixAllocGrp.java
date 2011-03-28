package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixAllocGrp extends FixGroup {
	private short hasAllocAccount;
	byte[] allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocAcctIDSource;
	long allocAcctIDSource = 0;		
	private short hasMatchStatus;
	byte matchStatus = (byte)' ';		
	private short hasAllocPrice;
	long allocPrice = 0;		
	private short hasAllocQty;
	long allocQty = 0;		
	private short hasIndividualAllocID;
	byte[] individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasProcessCode;
	byte processCode = (byte)' ';		
	private short hasSecondaryIndividualAllocID;
	byte[] secondaryIndividualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocMethod;
	long allocMethod = 0;		
	private short hasAllocCustomerCapacity;
	byte[] allocCustomerCapacity = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasIndividualAllocType;
	long individualAllocType = 0;		
	private short hasAllocPositionEffect;
	byte allocPositionEffect = (byte)' ';		
	private short hasNotifyBrokerOfCredit;
		boolean notifyBrokerOfCredit = false;		
	private short hasAllocHandlInst;
	long allocHandlInst = 0;		
	private short hasAllocText;
	byte[] allocText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedAllocTextLen;
	long encodedAllocTextLen = 0;		
	private short hasEncodedAllocText;
	byte[] encodedAllocText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasAllocAvgPx;
	long allocAvgPx = 0;		
	private short hasAllocNetMoney;
	long allocNetMoney = 0;		
	private short hasSettlCurrAmt;
	long settlCurrAmt = 0;		
	private short hasAllocSettlCurrAmt;
	long allocSettlCurrAmt = 0;		
	private short hasSettlCurrency;
	byte[] settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasAllocSettlCurrency;
	byte[] allocSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasSettlCurrFxRate;
	long settlCurrFxRate = 0;		
	private short hasSettlCurrFxRateCalc;
	byte settlCurrFxRateCalc = (byte)' ';		
	private short hasAllocAccruedInterestAmt;
	long allocAccruedInterestAmt = 0;		
	private short hasAllocInterestAtMaturity;
	long allocInterestAtMaturity = 0;		
	private short hasClearingFeeIndicator;
	byte[] clearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocSettlInstType;
	long allocSettlInstType = 0;		
		FixNestedParties[] nestedParties;
		FixCommissionData commissionData;
		FixMiscFeesGrp[] miscFeesGrp;
		FixClrInstGrp[] clrInstGrp;
		FixSettlInstructionsData settlInstructionsData;
	
	public FixAllocGrp() {
		super(FixTags.ALLOCACCOUNT_INT);

		
		hasAllocAccount = FixUtils.TAG_HAS_NO_VALUE;		
		allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasMatchStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasProcessCode = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecondaryIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryIndividualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocCustomerCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		allocCustomerCapacity = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasIndividualAllocType = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocPositionEffect = FixUtils.TAG_HAS_NO_VALUE;		
		hasNotifyBrokerOfCredit = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocHandlInst = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocText = FixUtils.TAG_HAS_NO_VALUE;		
		allocText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedAllocTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedAllocText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedAllocText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasAllocAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocNetMoney = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocSettlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasAllocSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		allocSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasSettlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocInterestAtMaturity = FixUtils.TAG_HAS_NO_VALUE;		
		hasClearingFeeIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		clearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocSettlInstType = FixUtils.TAG_HAS_NO_VALUE;		
		nestedParties = new FixNestedParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedParties[i] = new FixNestedParties();
		commissionData = new FixCommissionData();
		miscFeesGrp = new FixMiscFeesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) miscFeesGrp[i] = new FixMiscFeesGrp();
		clrInstGrp = new FixClrInstGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) clrInstGrp[i] = new FixClrInstGrp();
		settlInstructionsData = new FixSettlInstructionsData();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasAllocAccount()) return true;
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
            	case FixTags.ALLOCACCOUNT_INT:		
            		hasAllocAccount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCACCTIDSOURCE_INT:		
            		hasAllocAcctIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MATCHSTATUS_INT:		
            		hasMatchStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCPRICE_INT:		
            		hasAllocPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCQTY_INT:		
            		hasAllocQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.INDIVIDUALALLOCID_INT:		
            		hasIndividualAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PROCESSCODE_INT:		
            		hasProcessCode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYINDIVIDUALALLOCID_INT:		
            		hasSecondaryIndividualAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCMETHOD_INT:		
            		hasAllocMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCCUSTOMERCAPACITY_INT:		
            		hasAllocCustomerCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.INDIVIDUALALLOCTYPE_INT:		
            		hasIndividualAllocType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCPOSITIONEFFECT_INT:		
            		hasAllocPositionEffect = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NOTIFYBROKEROFCREDIT_INT:		
            		hasNotifyBrokerOfCredit = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCHANDLINST_INT:		
            		hasAllocHandlInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCTEXT_INT:		
            		hasAllocText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDALLOCTEXTLEN_INT:		
            		hasEncodedAllocTextLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDALLOCTEXT_INT:		
            		hasEncodedAllocText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCAVGPX_INT:		
            		hasAllocAvgPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCNETMONEY_INT:		
            		hasAllocNetMoney = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLCURRAMT_INT:		
            		hasSettlCurrAmt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCSETTLCURRAMT_INT:		
            		hasAllocSettlCurrAmt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLCURRENCY_INT:		
            		hasSettlCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCSETTLCURRENCY_INT:		
            		hasAllocSettlCurrency = (short) buf.position();		
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
            	case FixTags.ALLOCACCRUEDINTERESTAMT_INT:		
            		hasAllocAccruedInterestAmt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCINTERESTATMATURITY_INT:		
            		hasAllocInterestAtMaturity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CLEARINGFEEINDICATOR_INT:		
            		hasClearingFeeIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCSETTLINSTTYPE_INT:		
            		hasAllocSettlInstType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTEDPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !nestedParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = nestedParties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( commissionData.isKeyTag(tag)) {
        				tag = commissionData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOMISCFEES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !miscFeesGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = miscFeesGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !clrInstGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = clrInstGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( settlInstructionsData.isKeyTag(tag)) {
        				tag = settlInstructionsData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
            		} else { return tag; }
            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasAllocAccount = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasMatchStatus = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocQty = FixUtils.TAG_HAS_NO_VALUE;
		hasIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;
		hasProcessCode = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocCustomerCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasIndividualAllocType = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocPositionEffect = FixUtils.TAG_HAS_NO_VALUE;
		hasNotifyBrokerOfCredit = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocHandlInst = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocText = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedAllocTextLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedAllocText = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocAvgPx = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocNetMoney = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocSettlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrFxRateCalc = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocInterestAtMaturity = FixUtils.TAG_HAS_NO_VALUE;
		hasClearingFeeIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocSettlInstType = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.clear();
		commissionData.clear();
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) fixMiscFeesGrp.clear();
		for (FixClrInstGrp fixClrInstGrp : clrInstGrp) fixClrInstGrp.clear();
		settlInstructionsData.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

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

		if (hasMatchStatus()) {		
			out.put(FixTags.MATCHSTATUS);

			out.put((byte) '=');

			FixUtils.put(out,matchStatus); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocPrice()) {		
			out.put(FixTags.ALLOCPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocQty()) {		
			out.put(FixTags.ALLOCQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasIndividualAllocID()) {		
			out.put(FixTags.INDIVIDUALALLOCID);

			out.put((byte) '=');

			FixUtils.put(out,individualAllocID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasProcessCode()) {		
			out.put(FixTags.PROCESSCODE);

			out.put((byte) '=');

			FixUtils.put(out,processCode); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecondaryIndividualAllocID()) {		
			out.put(FixTags.SECONDARYINDIVIDUALALLOCID);

			out.put((byte) '=');

			FixUtils.put(out,secondaryIndividualAllocID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocMethod()) {		
			out.put(FixTags.ALLOCMETHOD);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocMethod);
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocCustomerCapacity()) {		
			out.put(FixTags.ALLOCCUSTOMERCAPACITY);

			out.put((byte) '=');

			FixUtils.put(out,allocCustomerCapacity); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasIndividualAllocType()) {		
			out.put(FixTags.INDIVIDUALALLOCTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)individualAllocType);
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocPositionEffect()) {		
			out.put(FixTags.ALLOCPOSITIONEFFECT);

			out.put((byte) '=');

			FixUtils.put(out,allocPositionEffect); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNotifyBrokerOfCredit()) {		
			out.put(FixTags.NOTIFYBROKEROFCREDIT);

			out.put((byte) '=');

			out.put(notifyBrokerOfCredit?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocHandlInst()) {		
			out.put(FixTags.ALLOCHANDLINST);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocHandlInst);
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocText()) {		
			out.put(FixTags.ALLOCTEXT);

			out.put((byte) '=');

			FixUtils.put(out,allocText); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedAllocTextLen()) {		
			out.put(FixTags.ENCODEDALLOCTEXTLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)encodedAllocTextLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedAllocText()) {		
			out.put(FixTags.ENCODEDALLOCTEXT);

			out.put((byte) '=');

			FixUtils.put(out,encodedAllocText); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocAvgPx()) {		
			out.put(FixTags.ALLOCAVGPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocAvgPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocNetMoney()) {		
			out.put(FixTags.ALLOCNETMONEY);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocNetMoney);
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlCurrAmt()) {		
			out.put(FixTags.SETTLCURRAMT);

			out.put((byte) '=');

			FixUtils.put(out, (long)settlCurrAmt);
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocSettlCurrAmt()) {		
			out.put(FixTags.ALLOCSETTLCURRAMT);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocSettlCurrAmt);
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlCurrency()) {		
			out.put(FixTags.SETTLCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,settlCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocSettlCurrency()) {		
			out.put(FixTags.ALLOCSETTLCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,allocSettlCurrency); 		
		
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

		if (hasAllocAccruedInterestAmt()) {		
			out.put(FixTags.ALLOCACCRUEDINTERESTAMT);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocAccruedInterestAmt);
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocInterestAtMaturity()) {		
			out.put(FixTags.ALLOCINTERESTATMATURITY);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocInterestAtMaturity);
		
			out.put(FixUtils.SOH);

            }

		if (hasClearingFeeIndicator()) {		
			out.put(FixTags.CLEARINGFEEINDICATOR);

			out.put((byte) '=');

			FixUtils.put(out,clearingFeeIndicator); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocSettlInstType()) {		
			out.put(FixTags.ALLOCSETTLINSTTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocSettlInstType);
		
			out.put(FixUtils.SOH);

            }

		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.encode(out);
		commissionData.encode(out);
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) fixMiscFeesGrp.encode(out);
		for (FixClrInstGrp fixClrInstGrp : clrInstGrp) fixClrInstGrp.encode(out);
		settlInstructionsData.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasAllocAccount()) {		
			FixUtils.put(out,allocAccount); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocAcctIDSource()) {		
			FixUtils.put(out, (long)allocAcctIDSource);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMatchStatus()) {		
			FixUtils.put(out,matchStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocPrice()) {		
			FixUtils.put(out, (long)allocPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocQty()) {		
			FixUtils.put(out, (long)allocQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIndividualAllocID()) {		
			FixUtils.put(out,individualAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasProcessCode()) {		
			FixUtils.put(out,processCode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryIndividualAllocID()) {		
			FixUtils.put(out,secondaryIndividualAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocMethod()) {		
			FixUtils.put(out, (long)allocMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocCustomerCapacity()) {		
			FixUtils.put(out,allocCustomerCapacity); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIndividualAllocType()) {		
			FixUtils.put(out, (long)individualAllocType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocPositionEffect()) {		
			FixUtils.put(out,allocPositionEffect); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNotifyBrokerOfCredit()) {		
			out.put(notifyBrokerOfCredit?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocHandlInst()) {		
			FixUtils.put(out, (long)allocHandlInst);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocText()) {		
			FixUtils.put(out,allocText); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedAllocTextLen()) {		
			FixUtils.put(out, (long)encodedAllocTextLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedAllocText()) {		
			FixUtils.put(out,encodedAllocText); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocAvgPx()) {		
			FixUtils.put(out, (long)allocAvgPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocNetMoney()) {		
			FixUtils.put(out, (long)allocNetMoney);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrAmt()) {		
			FixUtils.put(out, (long)settlCurrAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocSettlCurrAmt()) {		
			FixUtils.put(out, (long)allocSettlCurrAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrency()) {		
			FixUtils.put(out,settlCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocSettlCurrency()) {		
			FixUtils.put(out,allocSettlCurrency); 		
		
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
		
		if (hasAllocAccruedInterestAmt()) {		
			FixUtils.put(out, (long)allocAccruedInterestAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocInterestAtMaturity()) {		
			FixUtils.put(out, (long)allocInterestAtMaturity);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingFeeIndicator()) {		
			FixUtils.put(out,clearingFeeIndicator); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocSettlInstType()) {		
			FixUtils.put(out, (long)allocSettlInstType);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.printBuffer(out);
		commissionData.printBuffer(out);
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) fixMiscFeesGrp.printBuffer(out);
		for (FixClrInstGrp fixClrInstGrp : clrInstGrp) fixClrInstGrp.printBuffer(out);
		settlInstructionsData.printBuffer(out);
	}

	public byte[] getAllocAccount() { 		
		if ( hasAllocAccount()) {		
			if (hasAllocAccount == FixUtils.TAG_HAS_VALUE) {		
				return allocAccount; 		
			} else {		
		
				buf.position(hasAllocAccount);		
		
			FixMessage.getTagStringValue(buf, allocAccount, 0, allocAccount.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocAccount);		
					return null;		
				}		
			}		
			hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
			return allocAccount;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocAccount() { return hasAllocAccount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocAccount(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAccount()) FixUtils.fillSpace(allocAccount);		
		FixUtils.copy(allocAccount, src); 		
		hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocAccount(String str) {		
		if (str == null ) return;
		if (hasAllocAccount()) FixUtils.fillSpace(allocAccount);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocAccount, src); 		
		hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAllocAcctIDSource() { 		
		if ( hasAllocAcctIDSource()) {		
			if (hasAllocAcctIDSource == FixUtils.TAG_HAS_VALUE) {		
				return allocAcctIDSource; 		
			} else {		
		
				buf.position(hasAllocAcctIDSource);		
		
			allocAcctIDSource = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocAcctIDSource);		
					return 0;		
				}		
			}		
			hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
			return allocAcctIDSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocAcctIDSource() { return hasAllocAcctIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocAcctIDSource(long src) {		
		allocAcctIDSource = src;
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAcctIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAcctIDSource()) allocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		allocAcctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocAcctIDSource(String str) {		
		if (str == null ) return;
		if (hasAllocAcctIDSource()) allocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocAcctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getMatchStatus() { 		
		if ( hasMatchStatus()) {		
			if (hasMatchStatus == FixUtils.TAG_HAS_VALUE) {		
				return matchStatus; 		
			} else {		
		
				buf.position(hasMatchStatus);		
		
			matchStatus = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (matchStatus != (byte)'2') && (matchStatus != (byte)'1') && (matchStatus != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 573);		
				if (err.hasError()) {		
					buf.position(hasMatchStatus);		
					return (byte)'0';		
				}		
			}		
			hasMatchStatus = FixUtils.TAG_HAS_VALUE;		
			return matchStatus;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMatchStatus() { return hasMatchStatus != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMatchStatus(byte src) {		
		matchStatus = src;
		hasMatchStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMatchStatus(byte[] src) {		
		if (src == null ) return;
		if (hasMatchStatus()) matchStatus = (byte)' ';		
		matchStatus = src[0];		
		hasMatchStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMatchStatus(String str) {		
		if (str == null ) return;
		if (hasMatchStatus()) matchStatus = (byte)' ';		
		byte[] src = str.getBytes(); 		
		matchStatus = src[0];		
		hasMatchStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAllocPrice() { 		
		if ( hasAllocPrice()) {		
			if (hasAllocPrice == FixUtils.TAG_HAS_VALUE) {		
				return allocPrice; 		
			} else {		
		
				buf.position(hasAllocPrice);		
		
			allocPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocPrice);		
					return 0;		
				}		
			}		
			hasAllocPrice = FixUtils.TAG_HAS_VALUE;		
			return allocPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocPrice() { return hasAllocPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocPrice(long src) {		
		allocPrice = src;
		hasAllocPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocPrice(byte[] src) {		
		if (src == null ) return;
		if (hasAllocPrice()) allocPrice = FixUtils.TAG_HAS_NO_VALUE;		
		allocPrice = FixUtils.longValueOf(src, 0, src.length);
		hasAllocPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocPrice(String str) {		
		if (str == null ) return;
		if (hasAllocPrice()) allocPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocPrice = FixUtils.longValueOf(src, 0, src.length);
		hasAllocPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAllocQty() { 		
		if ( hasAllocQty()) {		
			if (hasAllocQty == FixUtils.TAG_HAS_VALUE) {		
				return allocQty; 		
			} else {		
		
				buf.position(hasAllocQty);		
		
			allocQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocQty);		
					return 0;		
				}		
			}		
			hasAllocQty = FixUtils.TAG_HAS_VALUE;		
			return allocQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocQty() { return hasAllocQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocQty(long src) {		
		allocQty = src;
		hasAllocQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocQty(byte[] src) {		
		if (src == null ) return;
		if (hasAllocQty()) allocQty = FixUtils.TAG_HAS_NO_VALUE;		
		allocQty = FixUtils.longValueOf(src, 0, src.length);
		hasAllocQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocQty(String str) {		
		if (str == null ) return;
		if (hasAllocQty()) allocQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocQty = FixUtils.longValueOf(src, 0, src.length);
		hasAllocQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getIndividualAllocID() { 		
		if ( hasIndividualAllocID()) {		
			if (hasIndividualAllocID == FixUtils.TAG_HAS_VALUE) {		
				return individualAllocID; 		
			} else {		
		
				buf.position(hasIndividualAllocID);		
		
			FixMessage.getTagStringValue(buf, individualAllocID, 0, individualAllocID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasIndividualAllocID);		
					return null;		
				}		
			}		
			hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
			return individualAllocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasIndividualAllocID() { return hasIndividualAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setIndividualAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasIndividualAllocID()) FixUtils.fillSpace(individualAllocID);		
		FixUtils.copy(individualAllocID, src); 		
		hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setIndividualAllocID(String str) {		
		if (str == null ) return;
		if (hasIndividualAllocID()) FixUtils.fillSpace(individualAllocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(individualAllocID, src); 		
		hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getSecondaryIndividualAllocID() { 		
		if ( hasSecondaryIndividualAllocID()) {		
			if (hasSecondaryIndividualAllocID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryIndividualAllocID; 		
			} else {		
		
				buf.position(hasSecondaryIndividualAllocID);		
		
			FixMessage.getTagStringValue(buf, secondaryIndividualAllocID, 0, secondaryIndividualAllocID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryIndividualAllocID);		
					return null;		
				}		
			}		
			hasSecondaryIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
			return secondaryIndividualAllocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryIndividualAllocID() { return hasSecondaryIndividualAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecondaryIndividualAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryIndividualAllocID()) FixUtils.fillSpace(secondaryIndividualAllocID);		
		FixUtils.copy(secondaryIndividualAllocID, src); 		
		hasSecondaryIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryIndividualAllocID(String str) {		
		if (str == null ) return;
		if (hasSecondaryIndividualAllocID()) FixUtils.fillSpace(secondaryIndividualAllocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryIndividualAllocID, src); 		
		hasSecondaryIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAllocMethod() { 		
		if ( hasAllocMethod()) {		
			if (hasAllocMethod == FixUtils.TAG_HAS_VALUE) {		
				return allocMethod; 		
			} else {		
		
				buf.position(hasAllocMethod);		
		
			allocMethod = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocMethod);		
					return 0;		
				}		
			}		
			hasAllocMethod = FixUtils.TAG_HAS_VALUE;		
			return allocMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocMethod() { return hasAllocMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocMethod(long src) {		
		allocMethod = src;
		hasAllocMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocMethod(byte[] src) {		
		if (src == null ) return;
		if (hasAllocMethod()) allocMethod = FixUtils.TAG_HAS_NO_VALUE;		
		allocMethod = FixUtils.longValueOf(src, 0, src.length);
		hasAllocMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocMethod(String str) {		
		if (str == null ) return;
		if (hasAllocMethod()) allocMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocMethod = FixUtils.longValueOf(src, 0, src.length);
		hasAllocMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getAllocCustomerCapacity() { 		
		if ( hasAllocCustomerCapacity()) {		
			if (hasAllocCustomerCapacity == FixUtils.TAG_HAS_VALUE) {		
				return allocCustomerCapacity; 		
			} else {		
		
				buf.position(hasAllocCustomerCapacity);		
		
			FixMessage.getTagStringValue(buf, allocCustomerCapacity, 0, allocCustomerCapacity.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocCustomerCapacity);		
					return null;		
				}		
			}		
			hasAllocCustomerCapacity = FixUtils.TAG_HAS_VALUE;		
			return allocCustomerCapacity;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocCustomerCapacity() { return hasAllocCustomerCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocCustomerCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasAllocCustomerCapacity()) FixUtils.fillSpace(allocCustomerCapacity);		
		FixUtils.copy(allocCustomerCapacity, src); 		
		hasAllocCustomerCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocCustomerCapacity(String str) {		
		if (str == null ) return;
		if (hasAllocCustomerCapacity()) FixUtils.fillSpace(allocCustomerCapacity);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocCustomerCapacity, src); 		
		hasAllocCustomerCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getIndividualAllocType() { 		
		if ( hasIndividualAllocType()) {		
			if (hasIndividualAllocType == FixUtils.TAG_HAS_VALUE) {		
				return individualAllocType; 		
			} else {		
		
				buf.position(hasIndividualAllocType);		
		
			individualAllocType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasIndividualAllocType);		
					return 0;		
				}		
			}		
			hasIndividualAllocType = FixUtils.TAG_HAS_VALUE;		
			return individualAllocType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasIndividualAllocType() { return hasIndividualAllocType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setIndividualAllocType(long src) {		
		individualAllocType = src;
		hasIndividualAllocType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIndividualAllocType(byte[] src) {		
		if (src == null ) return;
		if (hasIndividualAllocType()) individualAllocType = FixUtils.TAG_HAS_NO_VALUE;		
		individualAllocType = FixUtils.longValueOf(src, 0, src.length);
		hasIndividualAllocType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setIndividualAllocType(String str) {		
		if (str == null ) return;
		if (hasIndividualAllocType()) individualAllocType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		individualAllocType = FixUtils.longValueOf(src, 0, src.length);
		hasIndividualAllocType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getAllocPositionEffect() { 		
		if ( hasAllocPositionEffect()) {		
			if (hasAllocPositionEffect == FixUtils.TAG_HAS_VALUE) {		
				return allocPositionEffect; 		
			} else {		
		
				buf.position(hasAllocPositionEffect);		
		
			allocPositionEffect = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (allocPositionEffect != (byte)'F') && (allocPositionEffect != (byte)'R') && (allocPositionEffect != (byte)'C') && (allocPositionEffect != (byte)'O') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1047);		
				if (err.hasError()) {		
					buf.position(hasAllocPositionEffect);		
					return (byte)'0';		
				}		
			}		
			hasAllocPositionEffect = FixUtils.TAG_HAS_VALUE;		
			return allocPositionEffect;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasAllocPositionEffect() { return hasAllocPositionEffect != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocPositionEffect(byte src) {		
		allocPositionEffect = src;
		hasAllocPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocPositionEffect(byte[] src) {		
		if (src == null ) return;
		if (hasAllocPositionEffect()) allocPositionEffect = (byte)' ';		
		allocPositionEffect = src[0];		
		hasAllocPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocPositionEffect(String str) {		
		if (str == null ) return;
		if (hasAllocPositionEffect()) allocPositionEffect = (byte)' ';		
		byte[] src = str.getBytes(); 		
		allocPositionEffect = src[0];		
		hasAllocPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getNotifyBrokerOfCredit() { 		
		if ( hasNotifyBrokerOfCredit()) {		
			if (hasNotifyBrokerOfCredit == FixUtils.TAG_HAS_VALUE) {		
				return notifyBrokerOfCredit; 		
			} else {		
		
				buf.position(hasNotifyBrokerOfCredit);		
		
			notifyBrokerOfCredit = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasNotifyBrokerOfCredit);		
					return false;		
				}		
			}		
			hasNotifyBrokerOfCredit = FixUtils.TAG_HAS_VALUE;		
			return notifyBrokerOfCredit;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasNotifyBrokerOfCredit() { return hasNotifyBrokerOfCredit != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNotifyBrokerOfCredit(boolean src) {		
		notifyBrokerOfCredit = src;
		hasNotifyBrokerOfCredit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNotifyBrokerOfCredit(byte[] src) {		
		if (src == null ) return;
		if (hasNotifyBrokerOfCredit()) notifyBrokerOfCredit = false;		
		notifyBrokerOfCredit = src[0]==(byte)'Y'?true:false;		
		hasNotifyBrokerOfCredit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNotifyBrokerOfCredit(String str) {		
		if (str == null ) return;
		if (hasNotifyBrokerOfCredit()) notifyBrokerOfCredit = false;		
		byte[] src = str.getBytes(); 		
		notifyBrokerOfCredit = src[0]==(byte)'Y'?true:false;		
		hasNotifyBrokerOfCredit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAllocHandlInst() { 		
		if ( hasAllocHandlInst()) {		
			if (hasAllocHandlInst == FixUtils.TAG_HAS_VALUE) {		
				return allocHandlInst; 		
			} else {		
		
				buf.position(hasAllocHandlInst);		
		
			allocHandlInst = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocHandlInst);		
					return 0;		
				}		
			}		
			hasAllocHandlInst = FixUtils.TAG_HAS_VALUE;		
			return allocHandlInst;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocHandlInst() { return hasAllocHandlInst != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocHandlInst(long src) {		
		allocHandlInst = src;
		hasAllocHandlInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocHandlInst(byte[] src) {		
		if (src == null ) return;
		if (hasAllocHandlInst()) allocHandlInst = FixUtils.TAG_HAS_NO_VALUE;		
		allocHandlInst = FixUtils.longValueOf(src, 0, src.length);
		hasAllocHandlInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocHandlInst(String str) {		
		if (str == null ) return;
		if (hasAllocHandlInst()) allocHandlInst = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocHandlInst = FixUtils.longValueOf(src, 0, src.length);
		hasAllocHandlInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getAllocText() { 		
		if ( hasAllocText()) {		
			if (hasAllocText == FixUtils.TAG_HAS_VALUE) {		
				return allocText; 		
			} else {		
		
				buf.position(hasAllocText);		
		
			FixMessage.getTagStringValue(buf, allocText, 0, allocText.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocText);		
					return null;		
				}		
			}		
			hasAllocText = FixUtils.TAG_HAS_VALUE;		
			return allocText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocText() { return hasAllocText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocText(byte[] src) {		
		if (src == null ) return;
		if (hasAllocText()) FixUtils.fillSpace(allocText);		
		FixUtils.copy(allocText, src); 		
		hasAllocText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocText(String str) {		
		if (str == null ) return;
		if (hasAllocText()) FixUtils.fillSpace(allocText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocText, src); 		
		hasAllocText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEncodedAllocTextLen() { 		
		if ( hasEncodedAllocTextLen()) {		
			if (hasEncodedAllocTextLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedAllocTextLen; 		
			} else {		
		
				buf.position(hasEncodedAllocTextLen);		
		
			encodedAllocTextLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedAllocTextLen);		
					return 0;		
				}		
			}		
			hasEncodedAllocTextLen = FixUtils.TAG_HAS_VALUE;		
			return encodedAllocTextLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedAllocTextLen() { return hasEncodedAllocTextLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedAllocTextLen(long src) {		
		encodedAllocTextLen = src;
		hasEncodedAllocTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedAllocTextLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedAllocTextLen()) encodedAllocTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedAllocTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedAllocTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedAllocTextLen(String str) {		
		if (str == null ) return;
		if (hasEncodedAllocTextLen()) encodedAllocTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedAllocTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedAllocTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedAllocText() { 		
		if ( hasEncodedAllocText()) {		
			if (hasEncodedAllocText == FixUtils.TAG_HAS_VALUE) {		
				return encodedAllocText; 		
			} else {		
		
				buf.position(hasEncodedAllocText);		
		
			FixMessage.getTagStringValue(buf, encodedAllocText, 0, encodedAllocText.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedAllocText);		
					return null;		
				}		
			}		
			hasEncodedAllocText = FixUtils.TAG_HAS_VALUE;		
			return encodedAllocText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedAllocText() { return hasEncodedAllocText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedAllocText(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedAllocText()) FixUtils.fillSpace(encodedAllocText);		
		FixUtils.copy(encodedAllocText, src); 		
		hasEncodedAllocText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedAllocText(String str) {		
		if (str == null ) return;
		if (hasEncodedAllocText()) FixUtils.fillSpace(encodedAllocText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedAllocText, src); 		
		hasEncodedAllocText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAllocAvgPx() { 		
		if ( hasAllocAvgPx()) {		
			if (hasAllocAvgPx == FixUtils.TAG_HAS_VALUE) {		
				return allocAvgPx; 		
			} else {		
		
				buf.position(hasAllocAvgPx);		
		
			allocAvgPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocAvgPx);		
					return 0;		
				}		
			}		
			hasAllocAvgPx = FixUtils.TAG_HAS_VALUE;		
			return allocAvgPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocAvgPx() { return hasAllocAvgPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocAvgPx(long src) {		
		allocAvgPx = src;
		hasAllocAvgPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAvgPx(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAvgPx()) allocAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		allocAvgPx = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAvgPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocAvgPx(String str) {		
		if (str == null ) return;
		if (hasAllocAvgPx()) allocAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocAvgPx = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAvgPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAllocNetMoney() { 		
		if ( hasAllocNetMoney()) {		
			if (hasAllocNetMoney == FixUtils.TAG_HAS_VALUE) {		
				return allocNetMoney; 		
			} else {		
		
				buf.position(hasAllocNetMoney);		
		
			allocNetMoney = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocNetMoney);		
					return 0;		
				}		
			}		
			hasAllocNetMoney = FixUtils.TAG_HAS_VALUE;		
			return allocNetMoney;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocNetMoney() { return hasAllocNetMoney != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocNetMoney(long src) {		
		allocNetMoney = src;
		hasAllocNetMoney = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocNetMoney(byte[] src) {		
		if (src == null ) return;
		if (hasAllocNetMoney()) allocNetMoney = FixUtils.TAG_HAS_NO_VALUE;		
		allocNetMoney = FixUtils.longValueOf(src, 0, src.length);
		hasAllocNetMoney = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocNetMoney(String str) {		
		if (str == null ) return;
		if (hasAllocNetMoney()) allocNetMoney = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocNetMoney = FixUtils.longValueOf(src, 0, src.length);
		hasAllocNetMoney = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getAllocSettlCurrAmt() { 		
		if ( hasAllocSettlCurrAmt()) {		
			if (hasAllocSettlCurrAmt == FixUtils.TAG_HAS_VALUE) {		
				return allocSettlCurrAmt; 		
			} else {		
		
				buf.position(hasAllocSettlCurrAmt);		
		
			allocSettlCurrAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocSettlCurrAmt);		
					return 0;		
				}		
			}		
			hasAllocSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
			return allocSettlCurrAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocSettlCurrAmt() { return hasAllocSettlCurrAmt != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocSettlCurrAmt(long src) {		
		allocSettlCurrAmt = src;
		hasAllocSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocSettlCurrAmt(byte[] src) {		
		if (src == null ) return;
		if (hasAllocSettlCurrAmt()) allocSettlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		allocSettlCurrAmt = FixUtils.longValueOf(src, 0, src.length);
		hasAllocSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocSettlCurrAmt(String str) {		
		if (str == null ) return;
		if (hasAllocSettlCurrAmt()) allocSettlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocSettlCurrAmt = FixUtils.longValueOf(src, 0, src.length);
		hasAllocSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getAllocSettlCurrency() { 		
		if ( hasAllocSettlCurrency()) {		
			if (hasAllocSettlCurrency == FixUtils.TAG_HAS_VALUE) {		
				return allocSettlCurrency; 		
			} else {		
		
				buf.position(hasAllocSettlCurrency);		
		
			FixMessage.getTagStringValue(buf, allocSettlCurrency, 0, allocSettlCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocSettlCurrency);		
					return null;		
				}		
			}		
			hasAllocSettlCurrency = FixUtils.TAG_HAS_VALUE;		
			return allocSettlCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocSettlCurrency() { return hasAllocSettlCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocSettlCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasAllocSettlCurrency()) FixUtils.fillSpace(allocSettlCurrency);		
		FixUtils.copy(allocSettlCurrency, src); 		
		hasAllocSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocSettlCurrency(String str) {		
		if (str == null ) return;
		if (hasAllocSettlCurrency()) FixUtils.fillSpace(allocSettlCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocSettlCurrency, src); 		
		hasAllocSettlCurrency = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getAllocAccruedInterestAmt() { 		
		if ( hasAllocAccruedInterestAmt()) {		
			if (hasAllocAccruedInterestAmt == FixUtils.TAG_HAS_VALUE) {		
				return allocAccruedInterestAmt; 		
			} else {		
		
				buf.position(hasAllocAccruedInterestAmt);		
		
			allocAccruedInterestAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocAccruedInterestAmt);		
					return 0;		
				}		
			}		
			hasAllocAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
			return allocAccruedInterestAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocAccruedInterestAmt() { return hasAllocAccruedInterestAmt != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocAccruedInterestAmt(long src) {		
		allocAccruedInterestAmt = src;
		hasAllocAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAccruedInterestAmt(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAccruedInterestAmt()) allocAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		allocAccruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocAccruedInterestAmt(String str) {		
		if (str == null ) return;
		if (hasAllocAccruedInterestAmt()) allocAccruedInterestAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocAccruedInterestAmt = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAccruedInterestAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAllocInterestAtMaturity() { 		
		if ( hasAllocInterestAtMaturity()) {		
			if (hasAllocInterestAtMaturity == FixUtils.TAG_HAS_VALUE) {		
				return allocInterestAtMaturity; 		
			} else {		
		
				buf.position(hasAllocInterestAtMaturity);		
		
			allocInterestAtMaturity = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocInterestAtMaturity);		
					return 0;		
				}		
			}		
			hasAllocInterestAtMaturity = FixUtils.TAG_HAS_VALUE;		
			return allocInterestAtMaturity;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocInterestAtMaturity() { return hasAllocInterestAtMaturity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocInterestAtMaturity(long src) {		
		allocInterestAtMaturity = src;
		hasAllocInterestAtMaturity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocInterestAtMaturity(byte[] src) {		
		if (src == null ) return;
		if (hasAllocInterestAtMaturity()) allocInterestAtMaturity = FixUtils.TAG_HAS_NO_VALUE;		
		allocInterestAtMaturity = FixUtils.longValueOf(src, 0, src.length);
		hasAllocInterestAtMaturity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocInterestAtMaturity(String str) {		
		if (str == null ) return;
		if (hasAllocInterestAtMaturity()) allocInterestAtMaturity = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocInterestAtMaturity = FixUtils.longValueOf(src, 0, src.length);
		hasAllocInterestAtMaturity = FixUtils.TAG_HAS_VALUE;		
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
		if (hasClearingFeeIndicator()) FixUtils.fillSpace(clearingFeeIndicator);		
		FixUtils.copy(clearingFeeIndicator, src); 		
		hasClearingFeeIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setClearingFeeIndicator(String str) {		
		if (str == null ) return;
		if (hasClearingFeeIndicator()) FixUtils.fillSpace(clearingFeeIndicator);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clearingFeeIndicator, src); 		
		hasClearingFeeIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAllocSettlInstType() { 		
		if ( hasAllocSettlInstType()) {		
			if (hasAllocSettlInstType == FixUtils.TAG_HAS_VALUE) {		
				return allocSettlInstType; 		
			} else {		
		
				buf.position(hasAllocSettlInstType);		
		
			allocSettlInstType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocSettlInstType);		
					return 0;		
				}		
			}		
			hasAllocSettlInstType = FixUtils.TAG_HAS_VALUE;		
			return allocSettlInstType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocSettlInstType() { return hasAllocSettlInstType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocSettlInstType(long src) {		
		allocSettlInstType = src;
		hasAllocSettlInstType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocSettlInstType(byte[] src) {		
		if (src == null ) return;
		if (hasAllocSettlInstType()) allocSettlInstType = FixUtils.TAG_HAS_NO_VALUE;		
		allocSettlInstType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocSettlInstType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocSettlInstType(String str) {		
		if (str == null ) return;
		if (hasAllocSettlInstType()) allocSettlInstType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocSettlInstType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocSettlInstType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasAllocAccount()) s += "AllocAccount(79)= " + new String( FixUtils.trim(getAllocAccount()) ) + "\n" ; 
		if (hasAllocAcctIDSource()) s += "AllocAcctIDSource(661)= " + getAllocAcctIDSource() + "\n" ; 
		if (hasMatchStatus()) s += "MatchStatus(573)= " + getMatchStatus() + "\n" ; 
		if (hasAllocPrice()) s += "AllocPrice(366)= " + getAllocPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAllocQty()) s += "AllocQty(80)= " + getAllocQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasIndividualAllocID()) s += "IndividualAllocID(467)= " + new String( FixUtils.trim(getIndividualAllocID()) ) + "\n" ; 
		if (hasProcessCode()) s += "ProcessCode(81)= " + getProcessCode() + "\n" ; 
		if (hasSecondaryIndividualAllocID()) s += "SecondaryIndividualAllocID(989)= " + new String( FixUtils.trim(getSecondaryIndividualAllocID()) ) + "\n" ; 
		if (hasAllocMethod()) s += "AllocMethod(1002)= " + getAllocMethod() + "\n" ; 
		if (hasAllocCustomerCapacity()) s += "AllocCustomerCapacity(993)= " + new String( FixUtils.trim(getAllocCustomerCapacity()) ) + "\n" ; 
		if (hasIndividualAllocType()) s += "IndividualAllocType(992)= " + getIndividualAllocType() + "\n" ; 
		if (hasAllocPositionEffect()) s += "AllocPositionEffect(1047)= " + getAllocPositionEffect() + "\n" ; 
		if (hasNotifyBrokerOfCredit()) s += "NotifyBrokerOfCredit(208)= " + getNotifyBrokerOfCredit() + "\n" ; 
		if (hasAllocHandlInst()) s += "AllocHandlInst(209)= " + getAllocHandlInst() + "\n" ; 
		if (hasAllocText()) s += "AllocText(161)= " + new String( FixUtils.trim(getAllocText()) ) + "\n" ; 
		if (hasEncodedAllocTextLen()) s += "EncodedAllocTextLen(360)= " + getEncodedAllocTextLen() + "\n" ; 
		if (hasEncodedAllocText()) s += "EncodedAllocText(361)= " + new String( FixUtils.trim(getEncodedAllocText()) ) + "\n" ; 
		if (hasAllocAvgPx()) s += "AllocAvgPx(153)= " + getAllocAvgPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAllocNetMoney()) s += "AllocNetMoney(154)= " + getAllocNetMoney() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrAmt()) s += "SettlCurrAmt(119)= " + getSettlCurrAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAllocSettlCurrAmt()) s += "AllocSettlCurrAmt(737)= " + getAllocSettlCurrAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrency()) s += "SettlCurrency(120)= " + new String( FixUtils.trim(getSettlCurrency()) ) + "\n" ; 
		if (hasAllocSettlCurrency()) s += "AllocSettlCurrency(736)= " + new String( FixUtils.trim(getAllocSettlCurrency()) ) + "\n" ; 
		if (hasSettlCurrFxRate()) s += "SettlCurrFxRate(155)= " + getSettlCurrFxRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrFxRateCalc()) s += "SettlCurrFxRateCalc(156)= " + getSettlCurrFxRateCalc() + "\n" ; 
		if (hasAllocAccruedInterestAmt()) s += "AllocAccruedInterestAmt(742)= " + getAllocAccruedInterestAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAllocInterestAtMaturity()) s += "AllocInterestAtMaturity(741)= " + getAllocInterestAtMaturity() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasClearingFeeIndicator()) s += "ClearingFeeIndicator(635)= " + new String( FixUtils.trim(getClearingFeeIndicator()) ) + "\n" ; 
		if (hasAllocSettlInstType()) s += "AllocSettlInstType(780)= " + getAllocSettlInstType() + "\n" ; 

		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.toString();
		s += commissionData.toString();
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) fixMiscFeesGrp.toString();
		for (FixClrInstGrp fixClrInstGrp : clrInstGrp) fixClrInstGrp.toString();
		s += settlInstructionsData.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixAllocGrp)) return false;

		FixAllocGrp msg = (FixAllocGrp) o;

		for (FixNestedParties fixNestedParties : nestedParties)
			if (!fixNestedParties.equals(msg.nestedParties)) return false;
		if (!commissionData.equals(msg.commissionData)) return false;
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp)
			if (!fixMiscFeesGrp.equals(msg.miscFeesGrp)) return false;
		for (FixClrInstGrp fixClrInstGrp : clrInstGrp)
			if (!fixClrInstGrp.equals(msg.clrInstGrp)) return false;
		if (!settlInstructionsData.equals(msg.settlInstructionsData)) return false;
		if ((hasAllocAccount() && !msg.hasAllocAccount()) || (!hasAllocAccount() && msg.hasAllocAccount())) return false;
		if (!(!hasAllocAccount() && !msg.hasAllocAccount()) && !FixUtils.equals(getAllocAccount(), msg.getAllocAccount())) return false;
		if ((hasAllocAcctIDSource() && !msg.hasAllocAcctIDSource()) || (!hasAllocAcctIDSource() && msg.hasAllocAcctIDSource())) return false;
		if (!(!hasAllocAcctIDSource() && !msg.hasAllocAcctIDSource()) && !(getAllocAcctIDSource()==msg.getAllocAcctIDSource())) return false;
		if ((hasMatchStatus() && !msg.hasMatchStatus()) || (!hasMatchStatus() && msg.hasMatchStatus())) return false;
		if (!(!hasMatchStatus() && !msg.hasMatchStatus()) && !(getMatchStatus()==msg.getMatchStatus())) return false;
		if ((hasAllocPrice() && !msg.hasAllocPrice()) || (!hasAllocPrice() && msg.hasAllocPrice())) return false;
		if (!(!hasAllocPrice() && !msg.hasAllocPrice()) && !(getAllocPrice()==msg.getAllocPrice())) return false;
		if ((hasAllocQty() && !msg.hasAllocQty()) || (!hasAllocQty() && msg.hasAllocQty())) return false;
		if (!(!hasAllocQty() && !msg.hasAllocQty()) && !(getAllocQty()==msg.getAllocQty())) return false;
		if ((hasIndividualAllocID() && !msg.hasIndividualAllocID()) || (!hasIndividualAllocID() && msg.hasIndividualAllocID())) return false;
		if (!(!hasIndividualAllocID() && !msg.hasIndividualAllocID()) && !FixUtils.equals(getIndividualAllocID(), msg.getIndividualAllocID())) return false;
		if ((hasProcessCode() && !msg.hasProcessCode()) || (!hasProcessCode() && msg.hasProcessCode())) return false;
		if (!(!hasProcessCode() && !msg.hasProcessCode()) && !(getProcessCode()==msg.getProcessCode())) return false;
		if ((hasSecondaryIndividualAllocID() && !msg.hasSecondaryIndividualAllocID()) || (!hasSecondaryIndividualAllocID() && msg.hasSecondaryIndividualAllocID())) return false;
		if (!(!hasSecondaryIndividualAllocID() && !msg.hasSecondaryIndividualAllocID()) && !FixUtils.equals(getSecondaryIndividualAllocID(), msg.getSecondaryIndividualAllocID())) return false;
		if ((hasAllocMethod() && !msg.hasAllocMethod()) || (!hasAllocMethod() && msg.hasAllocMethod())) return false;
		if (!(!hasAllocMethod() && !msg.hasAllocMethod()) && !(getAllocMethod()==msg.getAllocMethod())) return false;
		if ((hasAllocCustomerCapacity() && !msg.hasAllocCustomerCapacity()) || (!hasAllocCustomerCapacity() && msg.hasAllocCustomerCapacity())) return false;
		if (!(!hasAllocCustomerCapacity() && !msg.hasAllocCustomerCapacity()) && !FixUtils.equals(getAllocCustomerCapacity(), msg.getAllocCustomerCapacity())) return false;
		if ((hasIndividualAllocType() && !msg.hasIndividualAllocType()) || (!hasIndividualAllocType() && msg.hasIndividualAllocType())) return false;
		if (!(!hasIndividualAllocType() && !msg.hasIndividualAllocType()) && !(getIndividualAllocType()==msg.getIndividualAllocType())) return false;
		if ((hasAllocPositionEffect() && !msg.hasAllocPositionEffect()) || (!hasAllocPositionEffect() && msg.hasAllocPositionEffect())) return false;
		if (!(!hasAllocPositionEffect() && !msg.hasAllocPositionEffect()) && !(getAllocPositionEffect()==msg.getAllocPositionEffect())) return false;
		if ((hasNotifyBrokerOfCredit() && !msg.hasNotifyBrokerOfCredit()) || (!hasNotifyBrokerOfCredit() && msg.hasNotifyBrokerOfCredit())) return false;
		if (!(!hasNotifyBrokerOfCredit() && !msg.hasNotifyBrokerOfCredit()) && !(getNotifyBrokerOfCredit()==msg.getNotifyBrokerOfCredit())) return false;
		if ((hasAllocHandlInst() && !msg.hasAllocHandlInst()) || (!hasAllocHandlInst() && msg.hasAllocHandlInst())) return false;
		if (!(!hasAllocHandlInst() && !msg.hasAllocHandlInst()) && !(getAllocHandlInst()==msg.getAllocHandlInst())) return false;
		if ((hasAllocText() && !msg.hasAllocText()) || (!hasAllocText() && msg.hasAllocText())) return false;
		if (!(!hasAllocText() && !msg.hasAllocText()) && !FixUtils.equals(getAllocText(), msg.getAllocText())) return false;
		if ((hasEncodedAllocTextLen() && !msg.hasEncodedAllocTextLen()) || (!hasEncodedAllocTextLen() && msg.hasEncodedAllocTextLen())) return false;
		if (!(!hasEncodedAllocTextLen() && !msg.hasEncodedAllocTextLen()) && !(getEncodedAllocTextLen()==msg.getEncodedAllocTextLen())) return false;
		if ((hasEncodedAllocText() && !msg.hasEncodedAllocText()) || (!hasEncodedAllocText() && msg.hasEncodedAllocText())) return false;
		if (!(!hasEncodedAllocText() && !msg.hasEncodedAllocText()) && !FixUtils.equals(getEncodedAllocText(), msg.getEncodedAllocText())) return false;
		if ((hasAllocAvgPx() && !msg.hasAllocAvgPx()) || (!hasAllocAvgPx() && msg.hasAllocAvgPx())) return false;
		if (!(!hasAllocAvgPx() && !msg.hasAllocAvgPx()) && !(getAllocAvgPx()==msg.getAllocAvgPx())) return false;
		if ((hasAllocNetMoney() && !msg.hasAllocNetMoney()) || (!hasAllocNetMoney() && msg.hasAllocNetMoney())) return false;
		if (!(!hasAllocNetMoney() && !msg.hasAllocNetMoney()) && !(getAllocNetMoney()==msg.getAllocNetMoney())) return false;
		if ((hasSettlCurrAmt() && !msg.hasSettlCurrAmt()) || (!hasSettlCurrAmt() && msg.hasSettlCurrAmt())) return false;
		if (!(!hasSettlCurrAmt() && !msg.hasSettlCurrAmt()) && !(getSettlCurrAmt()==msg.getSettlCurrAmt())) return false;
		if ((hasAllocSettlCurrAmt() && !msg.hasAllocSettlCurrAmt()) || (!hasAllocSettlCurrAmt() && msg.hasAllocSettlCurrAmt())) return false;
		if (!(!hasAllocSettlCurrAmt() && !msg.hasAllocSettlCurrAmt()) && !(getAllocSettlCurrAmt()==msg.getAllocSettlCurrAmt())) return false;
		if ((hasSettlCurrency() && !msg.hasSettlCurrency()) || (!hasSettlCurrency() && msg.hasSettlCurrency())) return false;
		if (!(!hasSettlCurrency() && !msg.hasSettlCurrency()) && !FixUtils.equals(getSettlCurrency(), msg.getSettlCurrency())) return false;
		if ((hasAllocSettlCurrency() && !msg.hasAllocSettlCurrency()) || (!hasAllocSettlCurrency() && msg.hasAllocSettlCurrency())) return false;
		if (!(!hasAllocSettlCurrency() && !msg.hasAllocSettlCurrency()) && !FixUtils.equals(getAllocSettlCurrency(), msg.getAllocSettlCurrency())) return false;
		if ((hasSettlCurrFxRate() && !msg.hasSettlCurrFxRate()) || (!hasSettlCurrFxRate() && msg.hasSettlCurrFxRate())) return false;
		if (!(!hasSettlCurrFxRate() && !msg.hasSettlCurrFxRate()) && !(getSettlCurrFxRate()==msg.getSettlCurrFxRate())) return false;
		if ((hasSettlCurrFxRateCalc() && !msg.hasSettlCurrFxRateCalc()) || (!hasSettlCurrFxRateCalc() && msg.hasSettlCurrFxRateCalc())) return false;
		if (!(!hasSettlCurrFxRateCalc() && !msg.hasSettlCurrFxRateCalc()) && !(getSettlCurrFxRateCalc()==msg.getSettlCurrFxRateCalc())) return false;
		if ((hasAllocAccruedInterestAmt() && !msg.hasAllocAccruedInterestAmt()) || (!hasAllocAccruedInterestAmt() && msg.hasAllocAccruedInterestAmt())) return false;
		if (!(!hasAllocAccruedInterestAmt() && !msg.hasAllocAccruedInterestAmt()) && !(getAllocAccruedInterestAmt()==msg.getAllocAccruedInterestAmt())) return false;
		if ((hasAllocInterestAtMaturity() && !msg.hasAllocInterestAtMaturity()) || (!hasAllocInterestAtMaturity() && msg.hasAllocInterestAtMaturity())) return false;
		if (!(!hasAllocInterestAtMaturity() && !msg.hasAllocInterestAtMaturity()) && !(getAllocInterestAtMaturity()==msg.getAllocInterestAtMaturity())) return false;
		if ((hasClearingFeeIndicator() && !msg.hasClearingFeeIndicator()) || (!hasClearingFeeIndicator() && msg.hasClearingFeeIndicator())) return false;
		if (!(!hasClearingFeeIndicator() && !msg.hasClearingFeeIndicator()) && !FixUtils.equals(getClearingFeeIndicator(), msg.getClearingFeeIndicator())) return false;
		if ((hasAllocSettlInstType() && !msg.hasAllocSettlInstType()) || (!hasAllocSettlInstType() && msg.hasAllocSettlInstType())) return false;
		if (!(!hasAllocSettlInstType() && !msg.hasAllocSettlInstType()) && !(getAllocSettlInstType()==msg.getAllocSettlInstType())) return false;
		return true;
	}
	public FixAllocGrp clone ( FixAllocGrp out ) {
		if ( hasAllocAccount())
			out.setAllocAccount(getAllocAccount());
		if ( hasAllocAcctIDSource())
			out.setAllocAcctIDSource(getAllocAcctIDSource());
		if ( hasMatchStatus())
			out.setMatchStatus(getMatchStatus());
		if ( hasAllocPrice())
			out.setAllocPrice(getAllocPrice());
		if ( hasAllocQty())
			out.setAllocQty(getAllocQty());
		if ( hasIndividualAllocID())
			out.setIndividualAllocID(getIndividualAllocID());
		if ( hasProcessCode())
			out.setProcessCode(getProcessCode());
		if ( hasSecondaryIndividualAllocID())
			out.setSecondaryIndividualAllocID(getSecondaryIndividualAllocID());
		if ( hasAllocMethod())
			out.setAllocMethod(getAllocMethod());
		if ( hasAllocCustomerCapacity())
			out.setAllocCustomerCapacity(getAllocCustomerCapacity());
		if ( hasIndividualAllocType())
			out.setIndividualAllocType(getIndividualAllocType());
		if ( hasAllocPositionEffect())
			out.setAllocPositionEffect(getAllocPositionEffect());
		if ( hasNotifyBrokerOfCredit())
			out.setNotifyBrokerOfCredit(getNotifyBrokerOfCredit());
		if ( hasAllocHandlInst())
			out.setAllocHandlInst(getAllocHandlInst());
		if ( hasAllocText())
			out.setAllocText(getAllocText());
		if ( hasEncodedAllocTextLen())
			out.setEncodedAllocTextLen(getEncodedAllocTextLen());
		if ( hasEncodedAllocText())
			out.setEncodedAllocText(getEncodedAllocText());
		if ( hasAllocAvgPx())
			out.setAllocAvgPx(getAllocAvgPx());
		if ( hasAllocNetMoney())
			out.setAllocNetMoney(getAllocNetMoney());
		if ( hasSettlCurrAmt())
			out.setSettlCurrAmt(getSettlCurrAmt());
		if ( hasAllocSettlCurrAmt())
			out.setAllocSettlCurrAmt(getAllocSettlCurrAmt());
		if ( hasSettlCurrency())
			out.setSettlCurrency(getSettlCurrency());
		if ( hasAllocSettlCurrency())
			out.setAllocSettlCurrency(getAllocSettlCurrency());
		if ( hasSettlCurrFxRate())
			out.setSettlCurrFxRate(getSettlCurrFxRate());
		if ( hasSettlCurrFxRateCalc())
			out.setSettlCurrFxRateCalc(getSettlCurrFxRateCalc());
		if ( hasAllocAccruedInterestAmt())
			out.setAllocAccruedInterestAmt(getAllocAccruedInterestAmt());
		if ( hasAllocInterestAtMaturity())
			out.setAllocInterestAtMaturity(getAllocInterestAtMaturity());
		if ( hasClearingFeeIndicator())
			out.setClearingFeeIndicator(getClearingFeeIndicator());
		if ( hasAllocSettlInstType())
			out.setAllocSettlInstType(getAllocSettlInstType());
		int count = 0;
		count = 0;
		for (FixNestedParties fixNestedParties : nestedParties) {
			if (!fixNestedParties.hasGroup()) continue;
			out.nestedParties[count] = fixNestedParties.clone( out.nestedParties[count] );
			count++;
		}
		if (commissionData.hasGroup())
			out.commissionData = commissionData.clone( out.commissionData);
		count = 0;
		for (FixMiscFeesGrp fixMiscFeesGrp : miscFeesGrp) {
			if (!fixMiscFeesGrp.hasGroup()) continue;
			out.miscFeesGrp[count] = fixMiscFeesGrp.clone( out.miscFeesGrp[count] );
			count++;
		}
		count = 0;
		for (FixClrInstGrp fixClrInstGrp : clrInstGrp) {
			if (!fixClrInstGrp.hasGroup()) continue;
			out.clrInstGrp[count] = fixClrInstGrp.clone( out.clrInstGrp[count] );
			count++;
		}
		if (settlInstructionsData.hasGroup())
			out.settlInstructionsData = settlInstructionsData.clone( out.settlInstructionsData);
		return out;
	}

}
