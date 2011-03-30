package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixAssignmentReport extends FixInMessage {
	private short hasAsgnRptID;
	byte[] asgnRptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPosReqID;
	byte[] posReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTotNumAssignmentReports;
	long totNumAssignmentReports = 0;		
	private short hasLastRptRequested;
		boolean lastRptRequested = false;		
	private short hasAccount;
	byte[] account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAccountType;
	long accountType = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasThresholdAmount;
	long thresholdAmount = 0;		
	private short hasSettlPrice;
	long settlPrice = 0;		
	private short hasSettlPriceType;
	long settlPriceType = 0;		
	private short hasUnderlyingSettlPrice;
	long underlyingSettlPrice = 0;		
	private short hasPriorSettlPrice;
	long priorSettlPrice = 0;		
	private short hasExpireDate;
	byte[] expireDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAssignmentMethod;
	byte assignmentMethod = (byte)' ';		
	private short hasAssignmentUnit;
	long assignmentUnit = 0;		
	private short hasOpenInterest;
	long openInterest = 0;		
	private short hasExerciseMethod;
	byte exerciseMethod = (byte)' ';		
	private short hasSettlSessID;
	byte[] settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlSessSubID;
	byte[] settlSessSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixParties[] parties;
	public FixInstrument instrument;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixPositionQty[] positionQty;
	public FixPositionAmountData[] positionAmountData;
	
	public FixAssignmentReport() {
		super(FixMessageInfo.MessageTypes.ASSIGNMENTREPORT);


		hasAsgnRptID = FixUtils.TAG_HAS_NO_VALUE;		
		asgnRptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPosReqID = FixUtils.TAG_HAS_NO_VALUE;		
		posReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTotNumAssignmentReports = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastRptRequested = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;		
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasThresholdAmount = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriorSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasExpireDate = FixUtils.TAG_HAS_NO_VALUE;		
		expireDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAssignmentMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasAssignmentUnit = FixUtils.TAG_HAS_NO_VALUE;		
		hasOpenInterest = FixUtils.TAG_HAS_NO_VALUE;		
		hasExerciseMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlSessID = FixUtils.TAG_HAS_NO_VALUE;		
		settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlSessSubID = FixUtils.TAG_HAS_NO_VALUE;		
		settlSessSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		applicationSequenceControl = new FixApplicationSequenceControl();
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		instrument = new FixInstrument();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		positionQty = new FixPositionQty[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) positionQty[i] = new FixPositionQty();
		positionAmountData = new FixPositionAmountData[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) positionAmountData[i] = new FixPositionAmountData();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.ASGNRPTID_INT:		
            		hasAsgnRptID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.POSREQID_INT:		
            		hasPosReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TOTNUMASSIGNMENTREPORTS_INT:		
            		hasTotNumAssignmentReports = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTRPTREQUESTED_INT:		
            		hasLastRptRequested = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCOUNT_INT:		
            		hasAccount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCOUNTTYPE_INT:		
            		hasAccountType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.THRESHOLDAMOUNT_INT:		
            		hasThresholdAmount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLPRICE_INT:		
            		hasSettlPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLPRICETYPE_INT:		
            		hasSettlPriceType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.UNDERLYINGSETTLPRICE_INT:		
            		hasUnderlyingSettlPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRIORSETTLPRICE_INT:		
            		hasPriorSettlPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXPIREDATE_INT:		
            		hasExpireDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ASSIGNMENTMETHOD_INT:		
            		hasAssignmentMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ASSIGNMENTUNIT_INT:		
            		hasAssignmentUnit = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.OPENINTEREST_INT:		
            		hasOpenInterest = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXERCISEMETHOD_INT:		
            		hasExerciseMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLSESSID_INT:		
            		hasSettlSessID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLSESSSUBID_INT:		
            		hasSettlSessSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
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
        			} else if ( applicationSequenceControl.isKeyTag(tag)) {
        				tag = applicationSequenceControl.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
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
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
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
        			} else if ( tag == FixTags.NOPOSITIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !positionQty[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
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
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !positionAmountData[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = positionAmountData[count].setBuffer( repeatingGroupTag, buf, err);	
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

		if (!hasAsgnRptID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag AsgnRptID missing", FixTags.ASGNRPTID_INT, FixMessageInfo.MessageTypes.ASSIGNMENTREPORT);
			return false;
		}
		if (!hasClearingBusinessDate()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ClearingBusinessDate missing", FixTags.CLEARINGBUSINESSDATE_INT, FixMessageInfo.MessageTypes.ASSIGNMENTREPORT);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (parties[i].hasGroup()) parties[i].hasRequiredTags(err); if (err.hasError()) return false; }
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
		if (hasAsgnRptID()) {		
			out.put(FixTags.ASGNRPTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,asgnRptID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPosReqID()) {		
			out.put(FixTags.POSREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,posReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotNumAssignmentReports()) {		
			out.put(FixTags.TOTNUMASSIGNMENTREPORTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totNumAssignmentReports);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastRptRequested()) {		
			out.put(FixTags.LASTRPTREQUESTED);		
		
			out.put((byte) '=');		
		
			out.put(lastRptRequested?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAccount()) {		
			out.put(FixTags.ACCOUNT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,account); 		
		
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
		if (hasThresholdAmount()) {		
			out.put(FixTags.THRESHOLDAMOUNT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)thresholdAmount);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlPrice()) {		
			out.put(FixTags.SETTLPRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)settlPrice);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlPriceType()) {		
			out.put(FixTags.SETTLPRICETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)settlPriceType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUnderlyingSettlPrice()) {		
			out.put(FixTags.UNDERLYINGSETTLPRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)underlyingSettlPrice);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriorSettlPrice()) {		
			out.put(FixTags.PRIORSETTLPRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priorSettlPrice);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExpireDate()) {		
			out.put(FixTags.EXPIREDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,expireDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAssignmentMethod()) {		
			out.put(FixTags.ASSIGNMENTMETHOD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,assignmentMethod); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAssignmentUnit()) {		
			out.put(FixTags.ASSIGNMENTUNIT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)assignmentUnit);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOpenInterest()) {		
			out.put(FixTags.OPENINTEREST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)openInterest);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExerciseMethod()) {		
			out.put(FixTags.EXERCISEMETHOD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,exerciseMethod); 		
		
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
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
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
		
		applicationSequenceControl.encode(out);
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
		
		if (hasAsgnRptID()) {		
			FixUtils.put(out,asgnRptID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPosReqID()) {		
			FixUtils.put(out,posReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNumAssignmentReports()) {		
			FixUtils.put(out, (long)totNumAssignmentReports);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastRptRequested()) {		
			out.put(lastRptRequested?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAccount()) {		
			FixUtils.put(out,account); 		
		
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
		
		if (hasThresholdAmount()) {		
			FixUtils.put(out, (long)thresholdAmount);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlPrice()) {		
			FixUtils.put(out, (long)settlPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlPriceType()) {		
			FixUtils.put(out, (long)settlPriceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSettlPrice()) {		
			FixUtils.put(out, (long)underlyingSettlPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriorSettlPrice()) {		
			FixUtils.put(out, (long)priorSettlPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExpireDate()) {		
			FixUtils.put(out,expireDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAssignmentMethod()) {		
			FixUtils.put(out,assignmentMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAssignmentUnit()) {		
			FixUtils.put(out, (long)assignmentUnit);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOpenInterest()) {		
			FixUtils.put(out, (long)openInterest);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExerciseMethod()) {		
			FixUtils.put(out,exerciseMethod); 		
		
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
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
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
			
	public void crackAsgnRptID() {		
		getAsgnRptID();		
	}		
			
	public byte[] getAsgnRptID() { 		
		if ( hasAsgnRptID()) {		
			if (hasAsgnRptID == FixUtils.TAG_HAS_VALUE) {		
				return asgnRptID; 		
			} else {

				buf.position(hasAsgnRptID);

			FixMessage.getTagStringValue(buf, asgnRptID, 0, asgnRptID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAsgnRptID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return asgnRptID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAsgnRptID() { return hasAsgnRptID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAsgnRptID(byte[] src) {		
		if (src == null ) return;
		if (hasAsgnRptID()) FixUtils.fillSpace(asgnRptID);		
		FixUtils.copy(asgnRptID, src); 		
		hasAsgnRptID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAsgnRptID(String str) {		
		if (str == null ) return;
		if (hasAsgnRptID()) FixUtils.fillSpace(asgnRptID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(asgnRptID, src); 		
		hasAsgnRptID = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, posReqID, 0, posReqID.length, err);
		
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
		if (hasPosReqID()) FixUtils.fillSpace(posReqID);		
		FixUtils.copy(posReqID, src); 		
		hasPosReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosReqID(String str) {		
		if (str == null ) return;
		if (hasPosReqID()) FixUtils.fillSpace(posReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(posReqID, src); 		
		hasPosReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTotNumAssignmentReports() {		
		getTotNumAssignmentReports();		
	}		
			
	public long getTotNumAssignmentReports() { 		
		if ( hasTotNumAssignmentReports()) {		
			if (hasTotNumAssignmentReports == FixUtils.TAG_HAS_VALUE) {		
				return totNumAssignmentReports; 		
			} else {

				buf.position(hasTotNumAssignmentReports);

			totNumAssignmentReports = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotNumAssignmentReports = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totNumAssignmentReports;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNumAssignmentReports() { return hasTotNumAssignmentReports != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotNumAssignmentReports(byte[] src) {		
		if (src == null ) return;
		if (hasTotNumAssignmentReports()) totNumAssignmentReports = FixUtils.TAG_HAS_NO_VALUE;		
		totNumAssignmentReports = FixUtils.longValueOf(src, 0, src.length);
		hasTotNumAssignmentReports = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNumAssignmentReports(long src) {		
		totNumAssignmentReports = src;
		hasTotNumAssignmentReports = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNumAssignmentReports(String str) {		
		if (str == null ) return;
		if (hasTotNumAssignmentReports()) totNumAssignmentReports = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNumAssignmentReports = FixUtils.longValueOf(src, 0, src.length);
		hasTotNumAssignmentReports = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastRptRequested() {		
		getLastRptRequested();		
	}		
			
	public boolean getLastRptRequested() { 		
		if ( hasLastRptRequested()) {		
			if (hasLastRptRequested == FixUtils.TAG_HAS_VALUE) {		
				return lastRptRequested; 		
			} else {

				buf.position(hasLastRptRequested);

			lastRptRequested = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasLastRptRequested = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastRptRequested;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasLastRptRequested() { return hasLastRptRequested != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastRptRequested(byte[] src) {		
		if (src == null ) return;
		if (hasLastRptRequested()) lastRptRequested = false;		
		lastRptRequested = src[0]==(byte)'Y'?true:false;		
		hasLastRptRequested = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastRptRequested(boolean src) {		
		lastRptRequested = src;
		hasLastRptRequested = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastRptRequested(String str) {		
		if (str == null ) return;
		if (hasLastRptRequested()) lastRptRequested = false;		
		byte[] src = str.getBytes(); 		
		lastRptRequested = src[0]==(byte)'Y'?true:false;		
		hasLastRptRequested = FixUtils.TAG_HAS_VALUE;		
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
		if (hasCurrency()) FixUtils.fillSpace(currency);		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCurrency(String str) {		
		if (str == null ) return;
		if (hasCurrency()) FixUtils.fillSpace(currency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
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

			thresholdAmount = FixMessage.getTagFloatValue(buf, err);
		
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
			
	public void crackSettlPrice() {		
		getSettlPrice();		
	}		
			
	public long getSettlPrice() { 		
		if ( hasSettlPrice()) {		
			if (hasSettlPrice == FixUtils.TAG_HAS_VALUE) {		
				return settlPrice; 		
			} else {

				buf.position(hasSettlPrice);

			settlPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSettlPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlPrice() { return hasSettlPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlPrice(byte[] src) {		
		if (src == null ) return;
		if (hasSettlPrice()) settlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		settlPrice = FixUtils.longValueOf(src, 0, src.length);
		hasSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlPrice(long src) {		
		settlPrice = src;
		hasSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlPrice(String str) {		
		if (str == null ) return;
		if (hasSettlPrice()) settlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlPrice = FixUtils.longValueOf(src, 0, src.length);
		hasSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlPriceType() {		
		getSettlPriceType();		
	}		
			
	public long getSettlPriceType() { 		
		if ( hasSettlPriceType()) {		
			if (hasSettlPriceType == FixUtils.TAG_HAS_VALUE) {		
				return settlPriceType; 		
			} else {

				buf.position(hasSettlPriceType);

			settlPriceType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSettlPriceType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlPriceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlPriceType() { return hasSettlPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasSettlPriceType()) settlPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		settlPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasSettlPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlPriceType(long src) {		
		settlPriceType = src;
		hasSettlPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlPriceType(String str) {		
		if (str == null ) return;
		if (hasSettlPriceType()) settlPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasSettlPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackUnderlyingSettlPrice() {		
		getUnderlyingSettlPrice();		
	}		
			
	public long getUnderlyingSettlPrice() { 		
		if ( hasUnderlyingSettlPrice()) {		
			if (hasUnderlyingSettlPrice == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSettlPrice; 		
			} else {

				buf.position(hasUnderlyingSettlPrice);

			underlyingSettlPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasUnderlyingSettlPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return underlyingSettlPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingSettlPrice() { return hasUnderlyingSettlPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUnderlyingSettlPrice(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSettlPrice()) underlyingSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSettlPrice = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingSettlPrice(long src) {		
		underlyingSettlPrice = src;
		hasUnderlyingSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingSettlPrice(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSettlPrice()) underlyingSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingSettlPrice = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPriorSettlPrice() {		
		getPriorSettlPrice();		
	}		
			
	public long getPriorSettlPrice() { 		
		if ( hasPriorSettlPrice()) {		
			if (hasPriorSettlPrice == FixUtils.TAG_HAS_VALUE) {		
				return priorSettlPrice; 		
			} else {

				buf.position(hasPriorSettlPrice);

			priorSettlPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPriorSettlPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return priorSettlPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriorSettlPrice() { return hasPriorSettlPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPriorSettlPrice(byte[] src) {		
		if (src == null ) return;
		if (hasPriorSettlPrice()) priorSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		priorSettlPrice = FixUtils.longValueOf(src, 0, src.length);
		hasPriorSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriorSettlPrice(long src) {		
		priorSettlPrice = src;
		hasPriorSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriorSettlPrice(String str) {		
		if (str == null ) return;
		if (hasPriorSettlPrice()) priorSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priorSettlPrice = FixUtils.longValueOf(src, 0, src.length);
		hasPriorSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExpireDate() {		
		getExpireDate();		
	}		
			
	public byte[] getExpireDate() { 		
		if ( hasExpireDate()) {		
			if (hasExpireDate == FixUtils.TAG_HAS_VALUE) {		
				return expireDate; 		
			} else {

				buf.position(hasExpireDate);

			FixMessage.getTagStringValue(buf, expireDate, 0, expireDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExpireDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return expireDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExpireDate() { return hasExpireDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExpireDate(byte[] src) {		
		if (src == null ) return;
		if (hasExpireDate()) FixUtils.fillSpace(expireDate);		
		FixUtils.copy(expireDate, src); 		
		hasExpireDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExpireDate(String str) {		
		if (str == null ) return;
		if (hasExpireDate()) FixUtils.fillSpace(expireDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(expireDate, src); 		
		hasExpireDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAssignmentMethod() {		
		getAssignmentMethod();		
	}		
			
	public byte getAssignmentMethod() { 		
		if ( hasAssignmentMethod()) {		
			if (hasAssignmentMethod == FixUtils.TAG_HAS_VALUE) {		
				return assignmentMethod; 		
			} else {

				buf.position(hasAssignmentMethod);

			assignmentMethod = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (assignmentMethod != (byte)'P') && (assignmentMethod != (byte)'R') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 744);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasAssignmentMethod = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return assignmentMethod;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasAssignmentMethod() { return hasAssignmentMethod != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAssignmentMethod(byte[] src) {		
		if (src == null ) return;
		if (hasAssignmentMethod()) assignmentMethod = (byte)' ';		
		assignmentMethod = src[0];		
		hasAssignmentMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAssignmentMethod(byte src) {		
		assignmentMethod = src;
		hasAssignmentMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAssignmentMethod(String str) {		
		if (str == null ) return;
		if (hasAssignmentMethod()) assignmentMethod = (byte)' ';		
		byte[] src = str.getBytes(); 		
		assignmentMethod = src[0];		
		hasAssignmentMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAssignmentUnit() {		
		getAssignmentUnit();		
	}		
			
	public long getAssignmentUnit() { 		
		if ( hasAssignmentUnit()) {		
			if (hasAssignmentUnit == FixUtils.TAG_HAS_VALUE) {		
				return assignmentUnit; 		
			} else {

				buf.position(hasAssignmentUnit);

			assignmentUnit = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAssignmentUnit = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return assignmentUnit;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAssignmentUnit() { return hasAssignmentUnit != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAssignmentUnit(byte[] src) {		
		if (src == null ) return;
		if (hasAssignmentUnit()) assignmentUnit = FixUtils.TAG_HAS_NO_VALUE;		
		assignmentUnit = FixUtils.longValueOf(src, 0, src.length);
		hasAssignmentUnit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAssignmentUnit(long src) {		
		assignmentUnit = src;
		hasAssignmentUnit = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAssignmentUnit(String str) {		
		if (str == null ) return;
		if (hasAssignmentUnit()) assignmentUnit = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		assignmentUnit = FixUtils.longValueOf(src, 0, src.length);
		hasAssignmentUnit = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOpenInterest() {		
		getOpenInterest();		
	}		
			
	public long getOpenInterest() { 		
		if ( hasOpenInterest()) {		
			if (hasOpenInterest == FixUtils.TAG_HAS_VALUE) {		
				return openInterest; 		
			} else {

				buf.position(hasOpenInterest);

			openInterest = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasOpenInterest = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return openInterest;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOpenInterest() { return hasOpenInterest != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOpenInterest(byte[] src) {		
		if (src == null ) return;
		if (hasOpenInterest()) openInterest = FixUtils.TAG_HAS_NO_VALUE;		
		openInterest = FixUtils.longValueOf(src, 0, src.length);
		hasOpenInterest = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOpenInterest(long src) {		
		openInterest = src;
		hasOpenInterest = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOpenInterest(String str) {		
		if (str == null ) return;
		if (hasOpenInterest()) openInterest = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		openInterest = FixUtils.longValueOf(src, 0, src.length);
		hasOpenInterest = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExerciseMethod() {		
		getExerciseMethod();		
	}		
			
	public byte getExerciseMethod() { 		
		if ( hasExerciseMethod()) {		
			if (hasExerciseMethod == FixUtils.TAG_HAS_VALUE) {		
				return exerciseMethod; 		
			} else {

				buf.position(hasExerciseMethod);

			exerciseMethod = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (exerciseMethod != (byte)'A') && (exerciseMethod != (byte)'M') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 747);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasExerciseMethod = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return exerciseMethod;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasExerciseMethod() { return hasExerciseMethod != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExerciseMethod(byte[] src) {		
		if (src == null ) return;
		if (hasExerciseMethod()) exerciseMethod = (byte)' ';		
		exerciseMethod = src[0];		
		hasExerciseMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExerciseMethod(byte src) {		
		exerciseMethod = src;
		hasExerciseMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExerciseMethod(String str) {		
		if (str == null ) return;
		if (hasExerciseMethod()) exerciseMethod = (byte)' ';		
		byte[] src = str.getBytes(); 		
		exerciseMethod = src[0];		
		hasExerciseMethod = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, settlSessID, 0, settlSessID.length, err);
		
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
		if (hasSettlSessID()) FixUtils.fillSpace(settlSessID);		
		FixUtils.copy(settlSessID, src); 		
		hasSettlSessID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlSessID(String str) {		
		if (str == null ) return;
		if (hasSettlSessID()) FixUtils.fillSpace(settlSessID);		
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

			FixMessage.getTagStringValue(buf, settlSessSubID, 0, settlSessSubID.length, err);
		
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
		if (hasSettlSessSubID()) FixUtils.fillSpace(settlSessSubID);		
		FixUtils.copy(settlSessSubID, src); 		
		hasSettlSessSubID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlSessSubID(String str) {		
		if (str == null ) return;
		if (hasSettlSessSubID()) FixUtils.fillSpace(settlSessSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlSessSubID, src); 		
		hasSettlSessSubID = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, clearingBusinessDate, 0, clearingBusinessDate.length, err);
		
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
		if (hasClearingBusinessDate()) FixUtils.fillSpace(clearingBusinessDate);		
		FixUtils.copy(clearingBusinessDate, src); 		
		hasClearingBusinessDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClearingBusinessDate(String str) {		
		if (str == null ) return;
		if (hasClearingBusinessDate()) FixUtils.fillSpace(clearingBusinessDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clearingBusinessDate, src); 		
		hasClearingBusinessDate = FixUtils.TAG_HAS_VALUE;		
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
		if (hasText()) FixUtils.fillSpace(text);		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setText(String str) {		
		if (str == null ) return;
		if (hasText()) FixUtils.fillSpace(text);		
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
		if (hasEncodedText()) FixUtils.fillSpace(encodedText);		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedText(String str) {		
		if (str == null ) return;
		if (hasEncodedText()) FixUtils.fillSpace(encodedText);		
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

					if (hasAsgnRptID()) s += "AsgnRptID(833)= " + new String( FixUtils.trim(getAsgnRptID()) ) + "\n" ; 
		if (hasPosReqID()) s += "PosReqID(710)= " + new String( FixUtils.trim(getPosReqID()) ) + "\n" ; 
		if (hasTotNumAssignmentReports()) s += "TotNumAssignmentReports(832)= " + getTotNumAssignmentReports() + "\n" ; 
		if (hasLastRptRequested()) s += "LastRptRequested(912)= " + getLastRptRequested() + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAccountType()) s += "AccountType(581)= " + getAccountType() + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasThresholdAmount()) s += "ThresholdAmount(834)= " + getThresholdAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlPrice()) s += "SettlPrice(730)= " + getSettlPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlPriceType()) s += "SettlPriceType(731)= " + getSettlPriceType() + "\n" ; 
		if (hasUnderlyingSettlPrice()) s += "UnderlyingSettlPrice(732)= " + getUnderlyingSettlPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPriorSettlPrice()) s += "PriorSettlPrice(734)= " + getPriorSettlPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasExpireDate()) s += "ExpireDate(432)= " + new String( FixUtils.trim(getExpireDate()) ) + "\n" ; 
		if (hasAssignmentMethod()) s += "AssignmentMethod(744)= " + getAssignmentMethod() + "\n" ; 
		if (hasAssignmentUnit()) s += "AssignmentUnit(745)= " + getAssignmentUnit() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOpenInterest()) s += "OpenInterest(746)= " + getOpenInterest() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasExerciseMethod()) s += "ExerciseMethod(747)= " + getExerciseMethod() + "\n" ; 
		if (hasSettlSessID()) s += "SettlSessID(716)= " + new String( FixUtils.trim(getSettlSessID()) ) + "\n" ; 
		if (hasSettlSessSubID()) s += "SettlSessSubID(717)= " + new String( FixUtils.trim(getSettlSessSubID()) ) + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
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
		if (! ( o instanceof FixAssignmentReport)) return false;

		FixAssignmentReport msg = (FixAssignmentReport) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasAsgnRptID() && !msg.hasAsgnRptID()) || (!hasAsgnRptID() && msg.hasAsgnRptID())) return false;
		if (!(!hasAsgnRptID() && !msg.hasAsgnRptID()) && !FixUtils.equals(getAsgnRptID(), msg.getAsgnRptID())) return false;
		if ((hasPosReqID() && !msg.hasPosReqID()) || (!hasPosReqID() && msg.hasPosReqID())) return false;
		if (!(!hasPosReqID() && !msg.hasPosReqID()) && !FixUtils.equals(getPosReqID(), msg.getPosReqID())) return false;
		if ((hasTotNumAssignmentReports() && !msg.hasTotNumAssignmentReports()) || (!hasTotNumAssignmentReports() && msg.hasTotNumAssignmentReports())) return false;
		if (!(!hasTotNumAssignmentReports() && !msg.hasTotNumAssignmentReports()) && !(getTotNumAssignmentReports()==msg.getTotNumAssignmentReports())) return false;
		if ((hasLastRptRequested() && !msg.hasLastRptRequested()) || (!hasLastRptRequested() && msg.hasLastRptRequested())) return false;
		if (!(!hasLastRptRequested() && !msg.hasLastRptRequested()) && !(getLastRptRequested()==msg.getLastRptRequested())) return false;
		if ((hasAccount() && !msg.hasAccount()) || (!hasAccount() && msg.hasAccount())) return false;
		if (!(!hasAccount() && !msg.hasAccount()) && !FixUtils.equals(getAccount(), msg.getAccount())) return false;
		if ((hasAccountType() && !msg.hasAccountType()) || (!hasAccountType() && msg.hasAccountType())) return false;
		if (!(!hasAccountType() && !msg.hasAccountType()) && !(getAccountType()==msg.getAccountType())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasThresholdAmount() && !msg.hasThresholdAmount()) || (!hasThresholdAmount() && msg.hasThresholdAmount())) return false;
		if (!(!hasThresholdAmount() && !msg.hasThresholdAmount()) && !(getThresholdAmount()==msg.getThresholdAmount())) return false;
		if ((hasSettlPrice() && !msg.hasSettlPrice()) || (!hasSettlPrice() && msg.hasSettlPrice())) return false;
		if (!(!hasSettlPrice() && !msg.hasSettlPrice()) && !(getSettlPrice()==msg.getSettlPrice())) return false;
		if ((hasSettlPriceType() && !msg.hasSettlPriceType()) || (!hasSettlPriceType() && msg.hasSettlPriceType())) return false;
		if (!(!hasSettlPriceType() && !msg.hasSettlPriceType()) && !(getSettlPriceType()==msg.getSettlPriceType())) return false;
		if ((hasUnderlyingSettlPrice() && !msg.hasUnderlyingSettlPrice()) || (!hasUnderlyingSettlPrice() && msg.hasUnderlyingSettlPrice())) return false;
		if (!(!hasUnderlyingSettlPrice() && !msg.hasUnderlyingSettlPrice()) && !(getUnderlyingSettlPrice()==msg.getUnderlyingSettlPrice())) return false;
		if ((hasPriorSettlPrice() && !msg.hasPriorSettlPrice()) || (!hasPriorSettlPrice() && msg.hasPriorSettlPrice())) return false;
		if (!(!hasPriorSettlPrice() && !msg.hasPriorSettlPrice()) && !(getPriorSettlPrice()==msg.getPriorSettlPrice())) return false;
		if ((hasExpireDate() && !msg.hasExpireDate()) || (!hasExpireDate() && msg.hasExpireDate())) return false;
		if (!(!hasExpireDate() && !msg.hasExpireDate()) ) return false;
		if ((hasAssignmentMethod() && !msg.hasAssignmentMethod()) || (!hasAssignmentMethod() && msg.hasAssignmentMethod())) return false;
		if (!(!hasAssignmentMethod() && !msg.hasAssignmentMethod()) && !(getAssignmentMethod()==msg.getAssignmentMethod())) return false;
		if ((hasAssignmentUnit() && !msg.hasAssignmentUnit()) || (!hasAssignmentUnit() && msg.hasAssignmentUnit())) return false;
		if (!(!hasAssignmentUnit() && !msg.hasAssignmentUnit()) && !(getAssignmentUnit()==msg.getAssignmentUnit())) return false;
		if ((hasOpenInterest() && !msg.hasOpenInterest()) || (!hasOpenInterest() && msg.hasOpenInterest())) return false;
		if (!(!hasOpenInterest() && !msg.hasOpenInterest()) && !(getOpenInterest()==msg.getOpenInterest())) return false;
		if ((hasExerciseMethod() && !msg.hasExerciseMethod()) || (!hasExerciseMethod() && msg.hasExerciseMethod())) return false;
		if (!(!hasExerciseMethod() && !msg.hasExerciseMethod()) && !(getExerciseMethod()==msg.getExerciseMethod())) return false;
		if ((hasSettlSessID() && !msg.hasSettlSessID()) || (!hasSettlSessID() && msg.hasSettlSessID())) return false;
		if (!(!hasSettlSessID() && !msg.hasSettlSessID()) && !FixUtils.equals(getSettlSessID(), msg.getSettlSessID())) return false;
		if ((hasSettlSessSubID() && !msg.hasSettlSessSubID()) || (!hasSettlSessSubID() && msg.hasSettlSessSubID())) return false;
		if (!(!hasSettlSessSubID() && !msg.hasSettlSessSubID()) && !FixUtils.equals(getSettlSessSubID(), msg.getSettlSessSubID())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if (!(!hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) ) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixAssignmentReport clone () {
		FixAssignmentReport out = new FixAssignmentReport();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixAssignmentReport clone ( FixAssignmentReport out ) {
		if ( hasAsgnRptID())
			out.setAsgnRptID(getAsgnRptID());
		if ( hasPosReqID())
			out.setPosReqID(getPosReqID());
		if ( hasTotNumAssignmentReports())
			out.setTotNumAssignmentReports(getTotNumAssignmentReports());
		if ( hasLastRptRequested())
			out.setLastRptRequested(getLastRptRequested());
		if ( hasAccount())
			out.setAccount(getAccount());
		if ( hasAccountType())
			out.setAccountType(getAccountType());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasThresholdAmount())
			out.setThresholdAmount(getThresholdAmount());
		if ( hasSettlPrice())
			out.setSettlPrice(getSettlPrice());
		if ( hasSettlPriceType())
			out.setSettlPriceType(getSettlPriceType());
		if ( hasUnderlyingSettlPrice())
			out.setUnderlyingSettlPrice(getUnderlyingSettlPrice());
		if ( hasPriorSettlPrice())
			out.setPriorSettlPrice(getPriorSettlPrice());
		if ( hasExpireDate())
			out.setExpireDate(getExpireDate());
		if ( hasAssignmentMethod())
			out.setAssignmentMethod(getAssignmentMethod());
		if ( hasAssignmentUnit())
			out.setAssignmentUnit(getAssignmentUnit());
		if ( hasOpenInterest())
			out.setOpenInterest(getOpenInterest());
		if ( hasExerciseMethod())
			out.setExerciseMethod(getExerciseMethod());
		if ( hasSettlSessID())
			out.setSettlSessID(getSettlSessID());
		if ( hasSettlSessSubID())
			out.setSettlSessSubID(getSettlSessSubID());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
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
