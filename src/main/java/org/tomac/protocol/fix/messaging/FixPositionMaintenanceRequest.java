package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixPositionMaintenanceRequest extends FixInMessage {
	private short hasPosReqID;
	byte[] posReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPosTransType;
	long posTransType = 0;		
	private short hasPosMaintAction;
	long posMaintAction = 0;		
	private short hasOrigPosReqRefID;
	byte[] origPosReqRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPosMaintRptRefID;
	byte[] posMaintRptRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlSessID;
	byte[] settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlSessSubID;
	byte[] settlSessSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAccount;
	byte[] account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAcctIDSource;
	long acctIDSource = 0;		
	private short hasAccountType;
	long accountType = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasAdjustmentType;
	long adjustmentType = 0;		
	private short hasContraryInstructionIndicator;
		boolean contraryInstructionIndicator = false;		
	private short hasPriorSpreadIndicator;
		boolean priorSpreadIndicator = false;		
	private short hasThresholdAmount;
	long thresholdAmount = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasSettlCurrency;
	byte[] settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	public FixParties[] parties;
	public FixInstrument instrument;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixTrdgSesGrp[] trdgSesGrp;
	public FixPositionQty[] positionQty;
	public FixPositionAmountData[] positionAmountData;
	
	public FixPositionMaintenanceRequest() {
		super(FixMessageInfo.MessageTypes.POSITIONMAINTENANCEREQUEST);


		hasPosReqID = FixUtils.TAG_HAS_NO_VALUE;		
		posReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPosTransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPosMaintAction = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrigPosReqRefID = FixUtils.TAG_HAS_NO_VALUE;		
		origPosReqRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPosMaintRptRefID = FixUtils.TAG_HAS_NO_VALUE;		
		posMaintRptRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlSessID = FixUtils.TAG_HAS_NO_VALUE;		
		settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlSessSubID = FixUtils.TAG_HAS_NO_VALUE;		
		settlSessSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;		
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasAdjustmentType = FixUtils.TAG_HAS_NO_VALUE;		
		hasContraryInstructionIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriorSpreadIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasThresholdAmount = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		instrument = new FixInstrument();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		trdgSesGrp = new FixTrdgSesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdgSesGrp[i] = new FixTrdgSesGrp();
		positionQty = new FixPositionQty[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) positionQty[i] = new FixPositionQty();
		positionAmountData = new FixPositionAmountData[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) positionAmountData[i] = new FixPositionAmountData();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.POSREQID_INT:		
            		hasPosReqID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.POSTRANSTYPE_INT:		
            		hasPosTransType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.POSMAINTACTION_INT:		
            		hasPosMaintAction = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ORIGPOSREQREFID_INT:		
            		hasOrigPosReqRefID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.POSMAINTRPTREFID_INT:		
            		hasPosMaintRptRefID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SETTLSESSID_INT:		
            		hasSettlSessID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SETTLSESSSUBID_INT:		
            		hasSettlSessSubID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ACCOUNT_INT:		
            		hasAccount = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ACCTIDSOURCE_INT:		
            		hasAcctIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ACCOUNTTYPE_INT:		
            		hasAccountType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ADJUSTMENTTYPE_INT:		
            		hasAdjustmentType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CONTRARYINSTRUCTIONINDICATOR_INT:		
            		hasContraryInstructionIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRIORSPREADINDICATOR_INT:		
            		hasPriorSpreadIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.THRESHOLDAMOUNT_INT:		
            		hasThresholdAmount = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TEXT_INT:		
            		hasText = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDTEXTLEN_INT:		
            		hasEncodedTextLen = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDTEXT_INT:		
            		hasEncodedText = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SETTLCURRENCY_INT:		
            		hasSettlCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	default:
        			if ( standardHeader.isKeyTag(tag)) {
        				tag = standardHeader.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( standardTrailer.isKeyTag(tag)) {
        				tag = standardTrailer.setBuffer( tag, buf, err);
        				FixUtils.unreadLastTag(tag, buf);
        				if (!err.hasError()) hasRequiredTags(err);
            			return; // always last, we are done now
        			} else if ( tag == FixTags.NOPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !parties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOPARTYIDS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOLEGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOLEGS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOUNDERLYINGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !undInstrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOUNDERLYINGS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = undInstrmtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOTRADINGSESSIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdgSesGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOTRADINGSESSIONS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdgSesGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOPOSITIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !positionQty[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOPOSITIONS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = positionQty[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOPOSAMT_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !positionAmountData[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOPOSAMT_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = positionAmountData[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.POSITIONMAINTENANCEREQUEST_INT);
                			break;
                		}
					}

			}

        		if (err.hasError()) return;

            	tag = FixUtils.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	public boolean hasRequiredTags(FixValidationError err) {
		if (!hasPosTransType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.POSTRANSTYPE_INT, FixMessageInfo.MessageTypes.POSITIONMAINTENANCEREQUEST_INT);
			return false;
		}
		if (!hasPosMaintAction()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.POSMAINTACTION_INT, FixMessageInfo.MessageTypes.POSITIONMAINTENANCEREQUEST_INT);
			return false;
		}
		if (!hasClearingBusinessDate()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CLEARINGBUSINESSDATE_INT, FixMessageInfo.MessageTypes.POSITIONMAINTENANCEREQUEST_INT);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (parties[i].hasGroup()) parties[i].hasRequiredTags(err); if (err.hasError()) return false; }
		if (instrument.isRequired) instrument.hasRequiredTags(err); if (err.hasError()) return false;
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (positionQty[i].hasGroup()) positionQty[i].hasRequiredTags(err); if (err.hasError()) return false; }
		return true;
	}
	@Override		
	public void getAll() {		
		getPosReqID();		
		getPosTransType();		
		getPosMaintAction();		
		getOrigPosReqRefID();		
		getPosMaintRptRefID();		
		getClearingBusinessDate();		
		getSettlSessID();		
		getSettlSessSubID();		
		getAccount();		
		getAcctIDSource();		
		getAccountType();		
		getCurrency();		
		getTransactTime();		
		getAdjustmentType();		
		getContraryInstructionIndicator();		
		getPriorSpreadIndicator();		
		getThresholdAmount();		
		getText();		
		getEncodedTextLen();		
		getEncodedText();		
		getSettlCurrency();		
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
		if (hasPosReqID()) {		
			out.put(FixTags.POSREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,posReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPosTransType()) {		
			out.put(FixTags.POSTRANSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)posTransType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPosMaintAction()) {		
			out.put(FixTags.POSMAINTACTION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)posMaintAction);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrigPosReqRefID()) {		
			out.put(FixTags.ORIGPOSREQREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,origPosReqRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPosMaintRptRefID()) {		
			out.put(FixTags.POSMAINTRPTREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,posMaintRptRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlSessID()) {		
			out.put(FixTags.SETTLSESSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlSessID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlSessSubID()) {		
			out.put(FixTags.SETTLSESSSUBID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlSessSubID); 		
		
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
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAdjustmentType()) {		
			out.put(FixTags.ADJUSTMENTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)adjustmentType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasContraryInstructionIndicator()) {		
			out.put(FixTags.CONTRARYINSTRUCTIONINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(contraryInstructionIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriorSpreadIndicator()) {		
			out.put(FixTags.PRIORSPREADINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(priorSpreadIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasThresholdAmount()) {		
			out.put(FixTags.THRESHOLDAMOUNT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)thresholdAmount);
		
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
		if (hasSettlCurrency()) {		
			out.put(FixTags.SETTLCURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlCurrency); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		instrument.encode(out);
		if (FixUtils.getNoInGroup(instrmtLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) if (fixInstrmtLegGrp.hasGroup()) fixInstrmtLegGrp.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(trdgSesGrp)>0) {
			out.put(FixTags.NOTRADINGSESSIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdgSesGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTrdgSesGrp fixTrdgSesGrp : trdgSesGrp) if (fixTrdgSesGrp.hasGroup()) fixTrdgSesGrp.encode(out);
		if (FixUtils.getNoInGroup(positionQty)>0) {
			out.put(FixTags.NOPOSITIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(positionQty));

			out.put(FixUtils.SOH);

		}
		for (FixPositionQty fixPositionQty : positionQty) if (fixPositionQty.hasGroup()) fixPositionQty.encode(out);
		if (FixUtils.getNoInGroup(positionAmountData)>0) {
			out.put(FixTags.NOPOSAMT);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(positionAmountData));

			out.put(FixUtils.SOH);

		}
		for (FixPositionAmountData fixPositionAmountData : positionAmountData) if (fixPositionAmountData.hasGroup()) fixPositionAmountData.encode(out);
		
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
		
		if (hasPosReqID()) {		
			FixUtils.put(out,posReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPosTransType()) {		
			FixUtils.put(out, (long)posTransType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPosMaintAction()) {		
			FixUtils.put(out, (long)posMaintAction);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigPosReqRefID()) {		
			FixUtils.put(out,origPosReqRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPosMaintRptRefID()) {		
			FixUtils.put(out,posMaintRptRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlSessID()) {		
			FixUtils.put(out,settlSessID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlSessSubID()) {		
			FixUtils.put(out,settlSessSubID); 		
		
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
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAdjustmentType()) {		
			FixUtils.put(out, (long)adjustmentType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContraryInstructionIndicator()) {		
			out.put(contraryInstructionIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriorSpreadIndicator()) {		
			out.put(priorSpreadIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasThresholdAmount()) {		
			FixUtils.put(out, (long)thresholdAmount);
		
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
		
		if (hasSettlCurrency()) {		
			FixUtils.put(out,settlCurrency); 		
		
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
			
	public void crackPosReqID() {		
		getPosReqID();		
	}		
			
	public byte[] getPosReqID() { 		
		if ( hasPosReqID()) {		
			if (hasPosReqID == FixUtils.TAG_HAS_VALUE) {		
				return posReqID; 		
			} else {

				buf.position(hasPosReqID);

			FixUtils.getTagStringValue(buf, posReqID, 0, posReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasPosReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return posReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPosReqID() { return hasPosReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPosReqID(byte[] src) {		
		if (src == null ) return;
		if (hasPosReqID()) FixUtils.fillNul(posReqID);		
		FixUtils.copy(posReqID, src); 		
		hasPosReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosReqID(String str) {		
		if (str == null ) return;
		if (hasPosReqID()) FixUtils.fillNul(posReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(posReqID, src); 		
		hasPosReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPosTransType() {		
		getPosTransType();		
	}		
			
	public long getPosTransType() { 		
		if ( hasPosTransType()) {		
			if (hasPosTransType == FixUtils.TAG_HAS_VALUE) {		
				return posTransType; 		
			} else {

				buf.position(hasPosTransType);

			posTransType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPosTransType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return posTransType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPosTransType() { return hasPosTransType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPosTransType(byte[] src) {		
		if (src == null ) return;
		if (hasPosTransType()) posTransType = FixUtils.TAG_HAS_NO_VALUE;		
		posTransType = FixUtils.longValueOf(src, 0, src.length);
		hasPosTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosTransType(long src) {		
		posTransType = src;
		hasPosTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosTransType(String str) {		
		if (str == null ) return;
		if (hasPosTransType()) posTransType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		posTransType = FixUtils.longValueOf(src, 0, src.length);
		hasPosTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPosMaintAction() {		
		getPosMaintAction();		
	}		
			
	public long getPosMaintAction() { 		
		if ( hasPosMaintAction()) {		
			if (hasPosMaintAction == FixUtils.TAG_HAS_VALUE) {		
				return posMaintAction; 		
			} else {

				buf.position(hasPosMaintAction);

			posMaintAction = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPosMaintAction = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return posMaintAction;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPosMaintAction() { return hasPosMaintAction != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPosMaintAction(byte[] src) {		
		if (src == null ) return;
		if (hasPosMaintAction()) posMaintAction = FixUtils.TAG_HAS_NO_VALUE;		
		posMaintAction = FixUtils.longValueOf(src, 0, src.length);
		hasPosMaintAction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosMaintAction(long src) {		
		posMaintAction = src;
		hasPosMaintAction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosMaintAction(String str) {		
		if (str == null ) return;
		if (hasPosMaintAction()) posMaintAction = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		posMaintAction = FixUtils.longValueOf(src, 0, src.length);
		hasPosMaintAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrigPosReqRefID() {		
		getOrigPosReqRefID();		
	}		
			
	public byte[] getOrigPosReqRefID() { 		
		if ( hasOrigPosReqRefID()) {		
			if (hasOrigPosReqRefID == FixUtils.TAG_HAS_VALUE) {		
				return origPosReqRefID; 		
			} else {

				buf.position(hasOrigPosReqRefID);

			FixUtils.getTagStringValue(buf, origPosReqRefID, 0, origPosReqRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrigPosReqRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return origPosReqRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigPosReqRefID() { return hasOrigPosReqRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrigPosReqRefID(byte[] src) {		
		if (src == null ) return;
		if (hasOrigPosReqRefID()) FixUtils.fillNul(origPosReqRefID);		
		FixUtils.copy(origPosReqRefID, src); 		
		hasOrigPosReqRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigPosReqRefID(String str) {		
		if (str == null ) return;
		if (hasOrigPosReqRefID()) FixUtils.fillNul(origPosReqRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origPosReqRefID, src); 		
		hasOrigPosReqRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPosMaintRptRefID() {		
		getPosMaintRptRefID();		
	}		
			
	public byte[] getPosMaintRptRefID() { 		
		if ( hasPosMaintRptRefID()) {		
			if (hasPosMaintRptRefID == FixUtils.TAG_HAS_VALUE) {		
				return posMaintRptRefID; 		
			} else {

				buf.position(hasPosMaintRptRefID);

			FixUtils.getTagStringValue(buf, posMaintRptRefID, 0, posMaintRptRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasPosMaintRptRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return posMaintRptRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPosMaintRptRefID() { return hasPosMaintRptRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPosMaintRptRefID(byte[] src) {		
		if (src == null ) return;
		if (hasPosMaintRptRefID()) FixUtils.fillNul(posMaintRptRefID);		
		FixUtils.copy(posMaintRptRefID, src); 		
		hasPosMaintRptRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosMaintRptRefID(String str) {		
		if (str == null ) return;
		if (hasPosMaintRptRefID()) FixUtils.fillNul(posMaintRptRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(posMaintRptRefID, src); 		
		hasPosMaintRptRefID = FixUtils.TAG_HAS_VALUE;		
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

			FixUtils.getTagStringValue(buf, clearingBusinessDate, 0, clearingBusinessDate.length, err);
		
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
			
	public void crackSettlSessID() {		
		getSettlSessID();		
	}		
			
	public byte[] getSettlSessID() { 		
		if ( hasSettlSessID()) {		
			if (hasSettlSessID == FixUtils.TAG_HAS_VALUE) {		
				return settlSessID; 		
			} else {

				buf.position(hasSettlSessID);

			FixUtils.getTagStringValue(buf, settlSessID, 0, settlSessID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlSessID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlSessID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlSessID() { return hasSettlSessID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlSessID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlSessID()) FixUtils.fillNul(settlSessID);		
		FixUtils.copy(settlSessID, src); 		
		hasSettlSessID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlSessID(String str) {		
		if (str == null ) return;
		if (hasSettlSessID()) FixUtils.fillNul(settlSessID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlSessID, src); 		
		hasSettlSessID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlSessSubID() {		
		getSettlSessSubID();		
	}		
			
	public byte[] getSettlSessSubID() { 		
		if ( hasSettlSessSubID()) {		
			if (hasSettlSessSubID == FixUtils.TAG_HAS_VALUE) {		
				return settlSessSubID; 		
			} else {

				buf.position(hasSettlSessSubID);

			FixUtils.getTagStringValue(buf, settlSessSubID, 0, settlSessSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlSessSubID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlSessSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlSessSubID() { return hasSettlSessSubID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlSessSubID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlSessSubID()) FixUtils.fillNul(settlSessSubID);		
		FixUtils.copy(settlSessSubID, src); 		
		hasSettlSessSubID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlSessSubID(String str) {		
		if (str == null ) return;
		if (hasSettlSessSubID()) FixUtils.fillNul(settlSessSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlSessSubID, src); 		
		hasSettlSessSubID = FixUtils.TAG_HAS_VALUE;		
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

			FixUtils.getTagStringValue(buf, account, 0, account.length, err);
		
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

			acctIDSource = FixUtils.getTagIntValue(buf, err);
		
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

			accountType = FixUtils.getTagIntValue(buf, err);
		
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
			
	public void crackCurrency() {		
		getCurrency();		
	}		
			
	public byte[] getCurrency() { 		
		if ( hasCurrency()) {		
			if (hasCurrency == FixUtils.TAG_HAS_VALUE) {		
				return currency; 		
			} else {

				buf.position(hasCurrency);

			FixUtils.getTagStringValue(buf, currency, 0, currency.length, err);
		
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
			
	public void crackTransactTime() {		
		getTransactTime();		
	}		
			
	public byte[] getTransactTime() { 		
		if ( hasTransactTime()) {		
			if (hasTransactTime == FixUtils.TAG_HAS_VALUE) {		
				return transactTime; 		
			} else {

				buf.position(hasTransactTime);

			FixUtils.getTagStringValue(buf, transactTime, 0, transactTime.length, err);
		
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
			
	public void crackAdjustmentType() {		
		getAdjustmentType();		
	}		
			
	public long getAdjustmentType() { 		
		if ( hasAdjustmentType()) {		
			if (hasAdjustmentType == FixUtils.TAG_HAS_VALUE) {		
				return adjustmentType; 		
			} else {

				buf.position(hasAdjustmentType);

			adjustmentType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAdjustmentType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return adjustmentType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAdjustmentType() { return hasAdjustmentType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAdjustmentType(byte[] src) {		
		if (src == null ) return;
		if (hasAdjustmentType()) adjustmentType = FixUtils.TAG_HAS_NO_VALUE;		
		adjustmentType = FixUtils.longValueOf(src, 0, src.length);
		hasAdjustmentType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAdjustmentType(long src) {		
		adjustmentType = src;
		hasAdjustmentType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAdjustmentType(String str) {		
		if (str == null ) return;
		if (hasAdjustmentType()) adjustmentType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		adjustmentType = FixUtils.longValueOf(src, 0, src.length);
		hasAdjustmentType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackContraryInstructionIndicator() {		
		getContraryInstructionIndicator();		
	}		
			
	public boolean getContraryInstructionIndicator() { 		
		if ( hasContraryInstructionIndicator()) {		
			if (hasContraryInstructionIndicator == FixUtils.TAG_HAS_VALUE) {		
				return contraryInstructionIndicator; 		
			} else {

				buf.position(hasContraryInstructionIndicator);

			contraryInstructionIndicator = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasContraryInstructionIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return contraryInstructionIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasContraryInstructionIndicator() { return hasContraryInstructionIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setContraryInstructionIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasContraryInstructionIndicator()) contraryInstructionIndicator = false;		
		contraryInstructionIndicator = src[0]==(byte)'Y'?true:false;		
		hasContraryInstructionIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContraryInstructionIndicator(boolean src) {		
		contraryInstructionIndicator = src;
		hasContraryInstructionIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContraryInstructionIndicator(String str) {		
		if (str == null ) return;
		if (hasContraryInstructionIndicator()) contraryInstructionIndicator = false;		
		byte[] src = str.getBytes(); 		
		contraryInstructionIndicator = src[0]==(byte)'Y'?true:false;		
		hasContraryInstructionIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPriorSpreadIndicator() {		
		getPriorSpreadIndicator();		
	}		
			
	public boolean getPriorSpreadIndicator() { 		
		if ( hasPriorSpreadIndicator()) {		
			if (hasPriorSpreadIndicator == FixUtils.TAG_HAS_VALUE) {		
				return priorSpreadIndicator; 		
			} else {

				buf.position(hasPriorSpreadIndicator);

			priorSpreadIndicator = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasPriorSpreadIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return priorSpreadIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasPriorSpreadIndicator() { return hasPriorSpreadIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPriorSpreadIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasPriorSpreadIndicator()) priorSpreadIndicator = false;		
		priorSpreadIndicator = src[0]==(byte)'Y'?true:false;		
		hasPriorSpreadIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriorSpreadIndicator(boolean src) {		
		priorSpreadIndicator = src;
		hasPriorSpreadIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriorSpreadIndicator(String str) {		
		if (str == null ) return;
		if (hasPriorSpreadIndicator()) priorSpreadIndicator = false;		
		byte[] src = str.getBytes(); 		
		priorSpreadIndicator = src[0]==(byte)'Y'?true:false;		
		hasPriorSpreadIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackThresholdAmount() {		
		getThresholdAmount();		
	}		
			
	public long getThresholdAmount() { 		
		if ( hasThresholdAmount()) {		
			if (hasThresholdAmount == FixUtils.TAG_HAS_VALUE) {		
				return thresholdAmount; 		
			} else {

				buf.position(hasThresholdAmount);

			thresholdAmount = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasThresholdAmount = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return thresholdAmount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasThresholdAmount() { return hasThresholdAmount != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setThresholdAmount(byte[] src) {		
		if (src == null ) return;
		if (hasThresholdAmount()) thresholdAmount = FixUtils.TAG_HAS_NO_VALUE;		
		thresholdAmount = FixUtils.longValueOf(src, 0, src.length);
		hasThresholdAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setThresholdAmount(long src) {		
		thresholdAmount = src;
		hasThresholdAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setThresholdAmount(String str) {		
		if (str == null ) return;
		if (hasThresholdAmount()) thresholdAmount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		thresholdAmount = FixUtils.longValueOf(src, 0, src.length);
		hasThresholdAmount = FixUtils.TAG_HAS_VALUE;		
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

			FixUtils.getTagStringValue(buf, text, 0, text.length, err);
		
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

			encodedTextLen = FixUtils.getTagIntValue(buf, err);
		
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

			FixUtils.getTagStringValue(buf, encodedText, 0, encodedText.length, err);
		
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
			
	public void crackSettlCurrency() {		
		getSettlCurrency();		
	}		
			
	public byte[] getSettlCurrency() { 		
		if ( hasSettlCurrency()) {		
			if (hasSettlCurrency == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrency; 		
			} else {

				buf.position(hasSettlCurrency);

			FixUtils.getTagStringValue(buf, settlCurrency, 0, settlCurrency.length, err);
		
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

					if (hasPosReqID()) s += "PosReqID(710)= " + new String( FixUtils.trim(getPosReqID()) ) + "\n" ; 
		if (hasPosTransType()) s += "PosTransType(709)= " + getPosTransType() + "\n" ; 
		if (hasPosMaintAction()) s += "PosMaintAction(712)= " + getPosMaintAction() + "\n" ; 
		if (hasOrigPosReqRefID()) s += "OrigPosReqRefID(713)= " + new String( FixUtils.trim(getOrigPosReqRefID()) ) + "\n" ; 
		if (hasPosMaintRptRefID()) s += "PosMaintRptRefID(714)= " + new String( FixUtils.trim(getPosMaintRptRefID()) ) + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasSettlSessID()) s += "SettlSessID(716)= " + new String( FixUtils.trim(getSettlSessID()) ) + "\n" ; 
		if (hasSettlSessSubID()) s += "SettlSessSubID(717)= " + new String( FixUtils.trim(getSettlSessSubID()) ) + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAcctIDSource()) s += "AcctIDSource(660)= " + getAcctIDSource() + "\n" ; 
		if (hasAccountType()) s += "AccountType(581)= " + getAccountType() + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasAdjustmentType()) s += "AdjustmentType(718)= " + getAdjustmentType() + "\n" ; 
		if (hasContraryInstructionIndicator()) s += "ContraryInstructionIndicator(719)= " + getContraryInstructionIndicator() + "\n" ; 
		if (hasPriorSpreadIndicator()) s += "PriorSpreadIndicator(720)= " + getPriorSpreadIndicator() + "\n" ; 
		if (hasThresholdAmount()) s += "ThresholdAmount(834)= " + getThresholdAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasSettlCurrency()) s += "SettlCurrency(120)= " + new String( FixUtils.trim(getSettlCurrency()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPositionMaintenanceRequest)) return false;

		FixPositionMaintenanceRequest msg = (FixPositionMaintenanceRequest) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasPosReqID() && !msg.hasPosReqID()) || (!hasPosReqID() && msg.hasPosReqID())) return false;
		if (!(!hasPosReqID() && !msg.hasPosReqID()) && !FixUtils.equals(getPosReqID(), msg.getPosReqID())) return false;
		if ((hasPosTransType() && !msg.hasPosTransType()) || (!hasPosTransType() && msg.hasPosTransType())) return false;
		if (!(!hasPosTransType() && !msg.hasPosTransType()) && !(getPosTransType()==msg.getPosTransType())) return false;
		if ((hasPosMaintAction() && !msg.hasPosMaintAction()) || (!hasPosMaintAction() && msg.hasPosMaintAction())) return false;
		if (!(!hasPosMaintAction() && !msg.hasPosMaintAction()) && !(getPosMaintAction()==msg.getPosMaintAction())) return false;
		if ((hasOrigPosReqRefID() && !msg.hasOrigPosReqRefID()) || (!hasOrigPosReqRefID() && msg.hasOrigPosReqRefID())) return false;
		if (!(!hasOrigPosReqRefID() && !msg.hasOrigPosReqRefID()) && !FixUtils.equals(getOrigPosReqRefID(), msg.getOrigPosReqRefID())) return false;
		if ((hasPosMaintRptRefID() && !msg.hasPosMaintRptRefID()) || (!hasPosMaintRptRefID() && msg.hasPosMaintRptRefID())) return false;
		if (!(!hasPosMaintRptRefID() && !msg.hasPosMaintRptRefID()) && !FixUtils.equals(getPosMaintRptRefID(), msg.getPosMaintRptRefID())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if ((hasSettlSessID() && !msg.hasSettlSessID()) || (!hasSettlSessID() && msg.hasSettlSessID())) return false;
		if (!(!hasSettlSessID() && !msg.hasSettlSessID()) && !FixUtils.equals(getSettlSessID(), msg.getSettlSessID())) return false;
		if ((hasSettlSessSubID() && !msg.hasSettlSessSubID()) || (!hasSettlSessSubID() && msg.hasSettlSessSubID())) return false;
		if (!(!hasSettlSessSubID() && !msg.hasSettlSessSubID()) && !FixUtils.equals(getSettlSessSubID(), msg.getSettlSessSubID())) return false;
		if ((hasAccount() && !msg.hasAccount()) || (!hasAccount() && msg.hasAccount())) return false;
		if (!(!hasAccount() && !msg.hasAccount()) && !FixUtils.equals(getAccount(), msg.getAccount())) return false;
		if ((hasAcctIDSource() && !msg.hasAcctIDSource()) || (!hasAcctIDSource() && msg.hasAcctIDSource())) return false;
		if (!(!hasAcctIDSource() && !msg.hasAcctIDSource()) && !(getAcctIDSource()==msg.getAcctIDSource())) return false;
		if ((hasAccountType() && !msg.hasAccountType()) || (!hasAccountType() && msg.hasAccountType())) return false;
		if (!(!hasAccountType() && !msg.hasAccountType()) && !(getAccountType()==msg.getAccountType())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasAdjustmentType() && !msg.hasAdjustmentType()) || (!hasAdjustmentType() && msg.hasAdjustmentType())) return false;
		if (!(!hasAdjustmentType() && !msg.hasAdjustmentType()) && !(getAdjustmentType()==msg.getAdjustmentType())) return false;
		if ((hasContraryInstructionIndicator() && !msg.hasContraryInstructionIndicator()) || (!hasContraryInstructionIndicator() && msg.hasContraryInstructionIndicator())) return false;
		if (!(!hasContraryInstructionIndicator() && !msg.hasContraryInstructionIndicator()) && !(getContraryInstructionIndicator()==msg.getContraryInstructionIndicator())) return false;
		if ((hasPriorSpreadIndicator() && !msg.hasPriorSpreadIndicator()) || (!hasPriorSpreadIndicator() && msg.hasPriorSpreadIndicator())) return false;
		if (!(!hasPriorSpreadIndicator() && !msg.hasPriorSpreadIndicator()) && !(getPriorSpreadIndicator()==msg.getPriorSpreadIndicator())) return false;
		if ((hasThresholdAmount() && !msg.hasThresholdAmount()) || (!hasThresholdAmount() && msg.hasThresholdAmount())) return false;
		if (!(!hasThresholdAmount() && !msg.hasThresholdAmount()) && !(getThresholdAmount()==msg.getThresholdAmount())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasSettlCurrency() && !msg.hasSettlCurrency()) || (!hasSettlCurrency() && msg.hasSettlCurrency())) return false;
		if (!(!hasSettlCurrency() && !msg.hasSettlCurrency()) && !FixUtils.equals(getSettlCurrency(), msg.getSettlCurrency())) return false;
		return true;
	}
	@Override
	public FixPositionMaintenanceRequest clone () {
		FixPositionMaintenanceRequest out = new FixPositionMaintenanceRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixPositionMaintenanceRequest clone ( FixPositionMaintenanceRequest out ) {
		if ( hasPosReqID())
			out.setPosReqID(getPosReqID());
		if ( hasPosTransType())
			out.setPosTransType(getPosTransType());
		if ( hasPosMaintAction())
			out.setPosMaintAction(getPosMaintAction());
		if ( hasOrigPosReqRefID())
			out.setOrigPosReqRefID(getOrigPosReqRefID());
		if ( hasPosMaintRptRefID())
			out.setPosMaintRptRefID(getPosMaintRptRefID());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasSettlSessID())
			out.setSettlSessID(getSettlSessID());
		if ( hasSettlSessSubID())
			out.setSettlSessSubID(getSettlSessSubID());
		if ( hasAccount())
			out.setAccount(getAccount());
		if ( hasAcctIDSource())
			out.setAcctIDSource(getAcctIDSource());
		if ( hasAccountType())
			out.setAccountType(getAccountType());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasAdjustmentType())
			out.setAdjustmentType(getAdjustmentType());
		if ( hasContraryInstructionIndicator())
			out.setContraryInstructionIndicator(getContraryInstructionIndicator());
		if ( hasPriorSpreadIndicator())
			out.setPriorSpreadIndicator(getPriorSpreadIndicator());
		if ( hasThresholdAmount())
			out.setThresholdAmount(getThresholdAmount());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasSettlCurrency())
			out.setSettlCurrency(getSettlCurrency());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		count = 0;
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) {
			if (!fixInstrmtLegGrp.hasGroup()) continue;
			out.instrmtLegGrp[count] = fixInstrmtLegGrp.clone( out.instrmtLegGrp[count] );
			count++;
		}
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		count = 0;
		for (FixTrdgSesGrp fixTrdgSesGrp : trdgSesGrp) {
			if (!fixTrdgSesGrp.hasGroup()) continue;
			out.trdgSesGrp[count] = fixTrdgSesGrp.clone( out.trdgSesGrp[count] );
			count++;
		}
		count = 0;
		for (FixPositionQty fixPositionQty : positionQty) {
			if (!fixPositionQty.hasGroup()) continue;
			out.positionQty[count] = fixPositionQty.clone( out.positionQty[count] );
			count++;
		}
		count = 0;
		for (FixPositionAmountData fixPositionAmountData : positionAmountData) {
			if (!fixPositionAmountData.hasGroup()) continue;
			out.positionAmountData[count] = fixPositionAmountData.clone( out.positionAmountData[count] );
			count++;
		}
		return out;
	}

}
