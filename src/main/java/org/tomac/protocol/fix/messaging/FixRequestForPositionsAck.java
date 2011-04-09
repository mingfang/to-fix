package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixRequestForPositionsAck extends FixInMessage {
	private short hasPosMaintRptID;
	byte[] posMaintRptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPosReqID;
	byte[] posReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTotalNumPosReports;
	long totalNumPosReports = 0;		
	private short hasUnsolicitedIndicator;
		boolean unsolicitedIndicator = false;		
	private short hasPosReqResult;
	long posReqResult = 0;		
	private short hasPosReqStatus;
	long posReqStatus = 0;		
	private short hasPosReqType;
	long posReqType = 0;		
	private short hasMatchStatus;
	byte matchStatus = (byte)' ';		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSubscriptionRequestType;
	byte subscriptionRequestType = (byte)' ';		
	private short hasSettlSessID;
	byte[] settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlSessSubID;
	byte[] settlSessSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlCurrency;
	byte[] settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasAccount;
	byte[] account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAcctIDSource;
	long acctIDSource = 0;		
	private short hasAccountType;
	long accountType = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasResponseTransportType;
	long responseTransportType = 0;		
	private short hasResponseDestination;
	byte[] responseDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixParties[] parties;
	public FixInstrument instrument;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	
	public FixRequestForPositionsAck() {
		super(FixMessageInfo.MessageTypes.REQUESTFORPOSITIONSACK);


		hasPosMaintRptID = FixUtils.TAG_HAS_NO_VALUE;		
		posMaintRptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPosReqID = FixUtils.TAG_HAS_NO_VALUE;		
		posReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTotalNumPosReports = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasPosReqResult = FixUtils.TAG_HAS_NO_VALUE;		
		hasPosReqStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasPosReqType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMatchStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlSessID = FixUtils.TAG_HAS_NO_VALUE;		
		settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlSessSubID = FixUtils.TAG_HAS_NO_VALUE;		
		settlSessSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;		
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasResponseTransportType = FixUtils.TAG_HAS_NO_VALUE;		
		hasResponseDestination = FixUtils.TAG_HAS_NO_VALUE;		
		responseDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		instrument = new FixInstrument();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.POSMAINTRPTID_INT:		
            		hasPosMaintRptID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.POSREQID_INT:		
            		hasPosReqID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TOTALNUMPOSREPORTS_INT:		
            		hasTotalNumPosReports = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.UNSOLICITEDINDICATOR_INT:		
            		hasUnsolicitedIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.POSREQRESULT_INT:		
            		hasPosReqResult = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.POSREQSTATUS_INT:		
            		hasPosReqStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.POSREQTYPE_INT:		
            		hasPosReqType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MATCHSTATUS_INT:		
            		hasMatchStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SUBSCRIPTIONREQUESTTYPE_INT:		
            		hasSubscriptionRequestType = (short) buf.position();		
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
            	case FixTags.SETTLCURRENCY_INT:		
            		hasSettlCurrency = (short) buf.position();		
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
            	case FixTags.RESPONSETRANSPORTTYPE_INT:		
            		hasResponseTransportType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.RESPONSEDESTINATION_INT:		
            		hasResponseDestination = (short) buf.position();		
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
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.REQUESTFORPOSITIONSACK_INT);
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
		if (!hasPosMaintRptID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.POSMAINTRPTID_INT, FixMessageInfo.MessageTypes.REQUESTFORPOSITIONSACK_INT);
			return false;
		}
		if (!hasPosReqResult()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.POSREQRESULT_INT, FixMessageInfo.MessageTypes.REQUESTFORPOSITIONSACK_INT);
			return false;
		}
		if (!hasPosReqStatus()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.POSREQSTATUS_INT, FixMessageInfo.MessageTypes.REQUESTFORPOSITIONSACK_INT);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (parties[i].hasGroup()) parties[i].hasRequiredTags(err); if (err.hasError()) return false; }
		return true;
	}
	@Override		
	public void getAll() {		
		getPosMaintRptID();		
		getPosReqID();		
		getTotalNumPosReports();		
		getUnsolicitedIndicator();		
		getPosReqResult();		
		getPosReqStatus();		
		getPosReqType();		
		getMatchStatus();		
		getClearingBusinessDate();		
		getSubscriptionRequestType();		
		getSettlSessID();		
		getSettlSessSubID();		
		getSettlCurrency();		
		getAccount();		
		getAcctIDSource();		
		getAccountType();		
		getCurrency();		
		getResponseTransportType();		
		getResponseDestination();		
		getText();		
		getEncodedTextLen();		
		getEncodedText();		
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
		if (hasPosMaintRptID()) {		
			out.put(FixTags.POSMAINTRPTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,posMaintRptID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPosReqID()) {		
			out.put(FixTags.POSREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,posReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotalNumPosReports()) {		
			out.put(FixTags.TOTALNUMPOSREPORTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totalNumPosReports);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUnsolicitedIndicator()) {		
			out.put(FixTags.UNSOLICITEDINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(unsolicitedIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPosReqResult()) {		
			out.put(FixTags.POSREQRESULT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)posReqResult);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPosReqStatus()) {		
			out.put(FixTags.POSREQSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)posReqStatus);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPosReqType()) {		
			out.put(FixTags.POSREQTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)posReqType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMatchStatus()) {		
			out.put(FixTags.MATCHSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,matchStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSubscriptionRequestType()) {		
			out.put(FixTags.SUBSCRIPTIONREQUESTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,subscriptionRequestType); 		
		
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
		if (hasSettlCurrency()) {		
			out.put(FixTags.SETTLCURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlCurrency); 		
		
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
		if (hasResponseTransportType()) {		
			out.put(FixTags.RESPONSETRANSPORTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)responseTransportType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasResponseDestination()) {		
			out.put(FixTags.RESPONSEDESTINATION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,responseDestination); 		
		
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
		
		if (hasPosMaintRptID()) {		
			FixUtils.put(out,posMaintRptID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPosReqID()) {		
			FixUtils.put(out,posReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotalNumPosReports()) {		
			FixUtils.put(out, (long)totalNumPosReports);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnsolicitedIndicator()) {		
			out.put(unsolicitedIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPosReqResult()) {		
			FixUtils.put(out, (long)posReqResult);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPosReqStatus()) {		
			FixUtils.put(out, (long)posReqStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPosReqType()) {		
			FixUtils.put(out, (long)posReqType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMatchStatus()) {		
			FixUtils.put(out,matchStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSubscriptionRequestType()) {		
			FixUtils.put(out,subscriptionRequestType); 		
		
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
		
		if (hasSettlCurrency()) {		
			FixUtils.put(out,settlCurrency); 		
		
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
		
		if (hasResponseTransportType()) {		
			FixUtils.put(out, (long)responseTransportType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasResponseDestination()) {		
			FixUtils.put(out,responseDestination); 		
		
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
			
	public void crackPosMaintRptID() {		
		getPosMaintRptID();		
	}		
			
	public byte[] getPosMaintRptID() { 		
		if ( hasPosMaintRptID()) {		
			if (hasPosMaintRptID == FixUtils.TAG_HAS_VALUE) {		
				return posMaintRptID; 		
			} else {

				buf.position(hasPosMaintRptID);

			FixUtils.getTagStringValue(buf, posMaintRptID, 0, posMaintRptID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasPosMaintRptID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return posMaintRptID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPosMaintRptID() { return hasPosMaintRptID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPosMaintRptID(byte[] src) {		
		if (src == null ) return;
		if (hasPosMaintRptID()) FixUtils.fillNul(posMaintRptID);		
		FixUtils.copy(posMaintRptID, src); 		
		hasPosMaintRptID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosMaintRptID(String str) {		
		if (str == null ) return;
		if (hasPosMaintRptID()) FixUtils.fillNul(posMaintRptID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(posMaintRptID, src); 		
		hasPosMaintRptID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackTotalNumPosReports() {		
		getTotalNumPosReports();		
	}		
			
	public long getTotalNumPosReports() { 		
		if ( hasTotalNumPosReports()) {		
			if (hasTotalNumPosReports == FixUtils.TAG_HAS_VALUE) {		
				return totalNumPosReports; 		
			} else {

				buf.position(hasTotalNumPosReports);

			totalNumPosReports = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotalNumPosReports = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totalNumPosReports;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotalNumPosReports() { return hasTotalNumPosReports != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotalNumPosReports(byte[] src) {		
		if (src == null ) return;
		if (hasTotalNumPosReports()) totalNumPosReports = FixUtils.TAG_HAS_NO_VALUE;		
		totalNumPosReports = FixUtils.longValueOf(src, 0, src.length);
		hasTotalNumPosReports = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotalNumPosReports(long src) {		
		totalNumPosReports = src;
		hasTotalNumPosReports = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotalNumPosReports(String str) {		
		if (str == null ) return;
		if (hasTotalNumPosReports()) totalNumPosReports = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totalNumPosReports = FixUtils.longValueOf(src, 0, src.length);
		hasTotalNumPosReports = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackUnsolicitedIndicator() {		
		getUnsolicitedIndicator();		
	}		
			
	public boolean getUnsolicitedIndicator() { 		
		if ( hasUnsolicitedIndicator()) {		
			if (hasUnsolicitedIndicator == FixUtils.TAG_HAS_VALUE) {		
				return unsolicitedIndicator; 		
			} else {

				buf.position(hasUnsolicitedIndicator);

			unsolicitedIndicator = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasUnsolicitedIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return unsolicitedIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasUnsolicitedIndicator() { return hasUnsolicitedIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setUnsolicitedIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasUnsolicitedIndicator()) unsolicitedIndicator = false;		
		unsolicitedIndicator = src[0]==(byte)'Y'?true:false;		
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnsolicitedIndicator(boolean src) {		
		unsolicitedIndicator = src;
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnsolicitedIndicator(String str) {		
		if (str == null ) return;
		if (hasUnsolicitedIndicator()) unsolicitedIndicator = false;		
		byte[] src = str.getBytes(); 		
		unsolicitedIndicator = src[0]==(byte)'Y'?true:false;		
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPosReqResult() {		
		getPosReqResult();		
	}		
			
	public long getPosReqResult() { 		
		if ( hasPosReqResult()) {		
			if (hasPosReqResult == FixUtils.TAG_HAS_VALUE) {		
				return posReqResult; 		
			} else {

				buf.position(hasPosReqResult);

			posReqResult = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPosReqResult = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return posReqResult;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPosReqResult() { return hasPosReqResult != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPosReqResult(byte[] src) {		
		if (src == null ) return;
		if (hasPosReqResult()) posReqResult = FixUtils.TAG_HAS_NO_VALUE;		
		posReqResult = FixUtils.longValueOf(src, 0, src.length);
		hasPosReqResult = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosReqResult(long src) {		
		posReqResult = src;
		hasPosReqResult = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosReqResult(String str) {		
		if (str == null ) return;
		if (hasPosReqResult()) posReqResult = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		posReqResult = FixUtils.longValueOf(src, 0, src.length);
		hasPosReqResult = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPosReqStatus() {		
		getPosReqStatus();		
	}		
			
	public long getPosReqStatus() { 		
		if ( hasPosReqStatus()) {		
			if (hasPosReqStatus == FixUtils.TAG_HAS_VALUE) {		
				return posReqStatus; 		
			} else {

				buf.position(hasPosReqStatus);

			posReqStatus = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPosReqStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return posReqStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPosReqStatus() { return hasPosReqStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPosReqStatus(byte[] src) {		
		if (src == null ) return;
		if (hasPosReqStatus()) posReqStatus = FixUtils.TAG_HAS_NO_VALUE;		
		posReqStatus = FixUtils.longValueOf(src, 0, src.length);
		hasPosReqStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosReqStatus(long src) {		
		posReqStatus = src;
		hasPosReqStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosReqStatus(String str) {		
		if (str == null ) return;
		if (hasPosReqStatus()) posReqStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		posReqStatus = FixUtils.longValueOf(src, 0, src.length);
		hasPosReqStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPosReqType() {		
		getPosReqType();		
	}		
			
	public long getPosReqType() { 		
		if ( hasPosReqType()) {		
			if (hasPosReqType == FixUtils.TAG_HAS_VALUE) {		
				return posReqType; 		
			} else {

				buf.position(hasPosReqType);

			posReqType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPosReqType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return posReqType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPosReqType() { return hasPosReqType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPosReqType(byte[] src) {		
		if (src == null ) return;
		if (hasPosReqType()) posReqType = FixUtils.TAG_HAS_NO_VALUE;		
		posReqType = FixUtils.longValueOf(src, 0, src.length);
		hasPosReqType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosReqType(long src) {		
		posReqType = src;
		hasPosReqType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosReqType(String str) {		
		if (str == null ) return;
		if (hasPosReqType()) posReqType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		posReqType = FixUtils.longValueOf(src, 0, src.length);
		hasPosReqType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMatchStatus() {		
		getMatchStatus();		
	}		
			
	public byte getMatchStatus() { 		
		if ( hasMatchStatus()) {		
			if (hasMatchStatus == FixUtils.TAG_HAS_VALUE) {		
				return matchStatus; 		
			} else {

				buf.position(hasMatchStatus);

			matchStatus = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (matchStatus != (byte)'2') && (matchStatus != (byte)'1') && (matchStatus != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 573);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasMatchStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return matchStatus;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMatchStatus() { return hasMatchStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMatchStatus(byte[] src) {		
		if (src == null ) return;
		if (hasMatchStatus()) matchStatus = (byte)' ';		
		matchStatus = src[0];		
		hasMatchStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMatchStatus(byte src) {		
		matchStatus = src;
		hasMatchStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMatchStatus(String str) {		
		if (str == null ) return;
		if (hasMatchStatus()) matchStatus = (byte)' ';		
		byte[] src = str.getBytes(); 		
		matchStatus = src[0];		
		hasMatchStatus = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackSubscriptionRequestType() {		
		getSubscriptionRequestType();		
	}		
			
	public byte getSubscriptionRequestType() { 		
		if ( hasSubscriptionRequestType()) {		
			if (hasSubscriptionRequestType == FixUtils.TAG_HAS_VALUE) {		
				return subscriptionRequestType; 		
			} else {

				buf.position(hasSubscriptionRequestType);

			subscriptionRequestType = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (subscriptionRequestType != (byte)'2') && (subscriptionRequestType != (byte)'1') && (subscriptionRequestType != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 263);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return subscriptionRequestType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSubscriptionRequestType() { return hasSubscriptionRequestType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSubscriptionRequestType(byte[] src) {		
		if (src == null ) return;
		if (hasSubscriptionRequestType()) subscriptionRequestType = (byte)' ';		
		subscriptionRequestType = src[0];		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSubscriptionRequestType(byte src) {		
		subscriptionRequestType = src;
		hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSubscriptionRequestType(String str) {		
		if (str == null ) return;
		if (hasSubscriptionRequestType()) subscriptionRequestType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		subscriptionRequestType = src[0];		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackResponseTransportType() {		
		getResponseTransportType();		
	}		
			
	public long getResponseTransportType() { 		
		if ( hasResponseTransportType()) {		
			if (hasResponseTransportType == FixUtils.TAG_HAS_VALUE) {		
				return responseTransportType; 		
			} else {

				buf.position(hasResponseTransportType);

			responseTransportType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasResponseTransportType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return responseTransportType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasResponseTransportType() { return hasResponseTransportType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setResponseTransportType(byte[] src) {		
		if (src == null ) return;
		if (hasResponseTransportType()) responseTransportType = FixUtils.TAG_HAS_NO_VALUE;		
		responseTransportType = FixUtils.longValueOf(src, 0, src.length);
		hasResponseTransportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setResponseTransportType(long src) {		
		responseTransportType = src;
		hasResponseTransportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setResponseTransportType(String str) {		
		if (str == null ) return;
		if (hasResponseTransportType()) responseTransportType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		responseTransportType = FixUtils.longValueOf(src, 0, src.length);
		hasResponseTransportType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackResponseDestination() {		
		getResponseDestination();		
	}		
			
	public byte[] getResponseDestination() { 		
		if ( hasResponseDestination()) {		
			if (hasResponseDestination == FixUtils.TAG_HAS_VALUE) {		
				return responseDestination; 		
			} else {

				buf.position(hasResponseDestination);

			FixUtils.getTagStringValue(buf, responseDestination, 0, responseDestination.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasResponseDestination = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return responseDestination;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasResponseDestination() { return hasResponseDestination != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setResponseDestination(byte[] src) {		
		if (src == null ) return;
		if (hasResponseDestination()) FixUtils.fillNul(responseDestination);		
		FixUtils.copy(responseDestination, src); 		
		hasResponseDestination = FixUtils.TAG_HAS_VALUE;		
	}

	public void setResponseDestination(String str) {		
		if (str == null ) return;
		if (hasResponseDestination()) FixUtils.fillNul(responseDestination);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(responseDestination, src); 		
		hasResponseDestination = FixUtils.TAG_HAS_VALUE;		
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

					if (hasPosMaintRptID()) s += "PosMaintRptID(721)= " + new String( FixUtils.trim(getPosMaintRptID()) ) + "\n" ; 
		if (hasPosReqID()) s += "PosReqID(710)= " + new String( FixUtils.trim(getPosReqID()) ) + "\n" ; 
		if (hasTotalNumPosReports()) s += "TotalNumPosReports(727)= " + getTotalNumPosReports() + "\n" ; 
		if (hasUnsolicitedIndicator()) s += "UnsolicitedIndicator(325)= " + getUnsolicitedIndicator() + "\n" ; 
		if (hasPosReqResult()) s += "PosReqResult(728)= " + getPosReqResult() + "\n" ; 
		if (hasPosReqStatus()) s += "PosReqStatus(729)= " + getPosReqStatus() + "\n" ; 
		if (hasPosReqType()) s += "PosReqType(724)= " + getPosReqType() + "\n" ; 
		if (hasMatchStatus()) s += "MatchStatus(573)= " + getMatchStatus() + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasSubscriptionRequestType()) s += "SubscriptionRequestType(263)= " + getSubscriptionRequestType() + "\n" ; 
		if (hasSettlSessID()) s += "SettlSessID(716)= " + new String( FixUtils.trim(getSettlSessID()) ) + "\n" ; 
		if (hasSettlSessSubID()) s += "SettlSessSubID(717)= " + new String( FixUtils.trim(getSettlSessSubID()) ) + "\n" ; 
		if (hasSettlCurrency()) s += "SettlCurrency(120)= " + new String( FixUtils.trim(getSettlCurrency()) ) + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAcctIDSource()) s += "AcctIDSource(660)= " + getAcctIDSource() + "\n" ; 
		if (hasAccountType()) s += "AccountType(581)= " + getAccountType() + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasResponseTransportType()) s += "ResponseTransportType(725)= " + getResponseTransportType() + "\n" ; 
		if (hasResponseDestination()) s += "ResponseDestination(726)= " + new String( FixUtils.trim(getResponseDestination()) ) + "\n" ; 
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
		if (! ( o instanceof FixRequestForPositionsAck)) return false;

		FixRequestForPositionsAck msg = (FixRequestForPositionsAck) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasPosMaintRptID() && !msg.hasPosMaintRptID()) || (!hasPosMaintRptID() && msg.hasPosMaintRptID())) return false;
		if (!(!hasPosMaintRptID() && !msg.hasPosMaintRptID()) && !FixUtils.equals(getPosMaintRptID(), msg.getPosMaintRptID())) return false;
		if ((hasPosReqID() && !msg.hasPosReqID()) || (!hasPosReqID() && msg.hasPosReqID())) return false;
		if (!(!hasPosReqID() && !msg.hasPosReqID()) && !FixUtils.equals(getPosReqID(), msg.getPosReqID())) return false;
		if ((hasTotalNumPosReports() && !msg.hasTotalNumPosReports()) || (!hasTotalNumPosReports() && msg.hasTotalNumPosReports())) return false;
		if (!(!hasTotalNumPosReports() && !msg.hasTotalNumPosReports()) && !(getTotalNumPosReports()==msg.getTotalNumPosReports())) return false;
		if ((hasUnsolicitedIndicator() && !msg.hasUnsolicitedIndicator()) || (!hasUnsolicitedIndicator() && msg.hasUnsolicitedIndicator())) return false;
		if (!(!hasUnsolicitedIndicator() && !msg.hasUnsolicitedIndicator()) && !(getUnsolicitedIndicator()==msg.getUnsolicitedIndicator())) return false;
		if ((hasPosReqResult() && !msg.hasPosReqResult()) || (!hasPosReqResult() && msg.hasPosReqResult())) return false;
		if (!(!hasPosReqResult() && !msg.hasPosReqResult()) && !(getPosReqResult()==msg.getPosReqResult())) return false;
		if ((hasPosReqStatus() && !msg.hasPosReqStatus()) || (!hasPosReqStatus() && msg.hasPosReqStatus())) return false;
		if (!(!hasPosReqStatus() && !msg.hasPosReqStatus()) && !(getPosReqStatus()==msg.getPosReqStatus())) return false;
		if ((hasPosReqType() && !msg.hasPosReqType()) || (!hasPosReqType() && msg.hasPosReqType())) return false;
		if (!(!hasPosReqType() && !msg.hasPosReqType()) && !(getPosReqType()==msg.getPosReqType())) return false;
		if ((hasMatchStatus() && !msg.hasMatchStatus()) || (!hasMatchStatus() && msg.hasMatchStatus())) return false;
		if (!(!hasMatchStatus() && !msg.hasMatchStatus()) && !(getMatchStatus()==msg.getMatchStatus())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if ((hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) || (!hasSubscriptionRequestType() && msg.hasSubscriptionRequestType())) return false;
		if (!(!hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) && !(getSubscriptionRequestType()==msg.getSubscriptionRequestType())) return false;
		if ((hasSettlSessID() && !msg.hasSettlSessID()) || (!hasSettlSessID() && msg.hasSettlSessID())) return false;
		if (!(!hasSettlSessID() && !msg.hasSettlSessID()) && !FixUtils.equals(getSettlSessID(), msg.getSettlSessID())) return false;
		if ((hasSettlSessSubID() && !msg.hasSettlSessSubID()) || (!hasSettlSessSubID() && msg.hasSettlSessSubID())) return false;
		if (!(!hasSettlSessSubID() && !msg.hasSettlSessSubID()) && !FixUtils.equals(getSettlSessSubID(), msg.getSettlSessSubID())) return false;
		if ((hasSettlCurrency() && !msg.hasSettlCurrency()) || (!hasSettlCurrency() && msg.hasSettlCurrency())) return false;
		if (!(!hasSettlCurrency() && !msg.hasSettlCurrency()) && !FixUtils.equals(getSettlCurrency(), msg.getSettlCurrency())) return false;
		if ((hasAccount() && !msg.hasAccount()) || (!hasAccount() && msg.hasAccount())) return false;
		if (!(!hasAccount() && !msg.hasAccount()) && !FixUtils.equals(getAccount(), msg.getAccount())) return false;
		if ((hasAcctIDSource() && !msg.hasAcctIDSource()) || (!hasAcctIDSource() && msg.hasAcctIDSource())) return false;
		if (!(!hasAcctIDSource() && !msg.hasAcctIDSource()) && !(getAcctIDSource()==msg.getAcctIDSource())) return false;
		if ((hasAccountType() && !msg.hasAccountType()) || (!hasAccountType() && msg.hasAccountType())) return false;
		if (!(!hasAccountType() && !msg.hasAccountType()) && !(getAccountType()==msg.getAccountType())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasResponseTransportType() && !msg.hasResponseTransportType()) || (!hasResponseTransportType() && msg.hasResponseTransportType())) return false;
		if (!(!hasResponseTransportType() && !msg.hasResponseTransportType()) && !(getResponseTransportType()==msg.getResponseTransportType())) return false;
		if ((hasResponseDestination() && !msg.hasResponseDestination()) || (!hasResponseDestination() && msg.hasResponseDestination())) return false;
		if (!(!hasResponseDestination() && !msg.hasResponseDestination()) && !FixUtils.equals(getResponseDestination(), msg.getResponseDestination())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixRequestForPositionsAck clone () {
		FixRequestForPositionsAck out = new FixRequestForPositionsAck();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixRequestForPositionsAck clone ( FixRequestForPositionsAck out ) {
		if ( hasPosMaintRptID())
			out.setPosMaintRptID(getPosMaintRptID());
		if ( hasPosReqID())
			out.setPosReqID(getPosReqID());
		if ( hasTotalNumPosReports())
			out.setTotalNumPosReports(getTotalNumPosReports());
		if ( hasUnsolicitedIndicator())
			out.setUnsolicitedIndicator(getUnsolicitedIndicator());
		if ( hasPosReqResult())
			out.setPosReqResult(getPosReqResult());
		if ( hasPosReqStatus())
			out.setPosReqStatus(getPosReqStatus());
		if ( hasPosReqType())
			out.setPosReqType(getPosReqType());
		if ( hasMatchStatus())
			out.setMatchStatus(getMatchStatus());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasSubscriptionRequestType())
			out.setSubscriptionRequestType(getSubscriptionRequestType());
		if ( hasSettlSessID())
			out.setSettlSessID(getSettlSessID());
		if ( hasSettlSessSubID())
			out.setSettlSessSubID(getSettlSessSubID());
		if ( hasSettlCurrency())
			out.setSettlCurrency(getSettlCurrency());
		if ( hasAccount())
			out.setAccount(getAccount());
		if ( hasAcctIDSource())
			out.setAcctIDSource(getAcctIDSource());
		if ( hasAccountType())
			out.setAccountType(getAccountType());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasResponseTransportType())
			out.setResponseTransportType(getResponseTransportType());
		if ( hasResponseDestination())
			out.setResponseDestination(getResponseDestination());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
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
		return out;
	}

}
