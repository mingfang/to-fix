package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixBidRequest extends FixInMessage {
	private short hasBidID;
	byte[] bidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClientBidID;
	byte[] clientBidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasBidRequestTransType;
	byte bidRequestTransType = (byte)' ';		
	private short hasListName;
	byte[] listName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTotNoRelatedSym;
	long totNoRelatedSym = 0;		
	private short hasBidType;
	long bidType = 0;		
	private short hasNumTickets;
	long numTickets = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasSideValue1;
	long sideValue1 = 0;		
	private short hasSideValue2;
	long sideValue2 = 0;		
	private short hasLiquidityIndType;
	long liquidityIndType = 0;		
	private short hasWtAverageLiquidity;
	long wtAverageLiquidity = 0;		
	private short hasExchangeForPhysical;
		boolean exchangeForPhysical = false;		
	private short hasOutMainCntryUIndex;
	long outMainCntryUIndex = 0;		
	private short hasCrossPercent;
	long crossPercent = 0;		
	private short hasProgRptReqs;
	long progRptReqs = 0;		
	private short hasProgPeriodInterval;
	long progPeriodInterval = 0;		
	private short hasIncTaxInd;
	long incTaxInd = 0;		
	private short hasForexReq;
		boolean forexReq = false;		
	private short hasNumBidders;
	long numBidders = 0;		
	private short hasTradeDate;
	byte[] tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasBidTradeType;
	byte bidTradeType = (byte)' ';		
	private short hasBasisPxType;
	byte basisPxType = (byte)' ';		
	private short hasStrikeTime;
	byte[] strikeTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixBidDescReqGrp[] bidDescReqGrp;
	public FixBidCompReqGrp[] bidCompReqGrp;
	
	public FixBidRequest() {
		super(FixMessageInfo.MessageTypes.BIDREQUEST);


		hasBidID = FixUtils.TAG_HAS_NO_VALUE;		
		bidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClientBidID = FixUtils.TAG_HAS_NO_VALUE;		
		clientBidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasBidRequestTransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasListName = FixUtils.TAG_HAS_NO_VALUE;		
		listName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTotNoRelatedSym = FixUtils.TAG_HAS_NO_VALUE;		
		hasBidType = FixUtils.TAG_HAS_NO_VALUE;		
		hasNumTickets = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasSideValue1 = FixUtils.TAG_HAS_NO_VALUE;		
		hasSideValue2 = FixUtils.TAG_HAS_NO_VALUE;		
		hasLiquidityIndType = FixUtils.TAG_HAS_NO_VALUE;		
		hasWtAverageLiquidity = FixUtils.TAG_HAS_NO_VALUE;		
		hasExchangeForPhysical = FixUtils.TAG_HAS_NO_VALUE;		
		hasOutMainCntryUIndex = FixUtils.TAG_HAS_NO_VALUE;		
		hasCrossPercent = FixUtils.TAG_HAS_NO_VALUE;		
		hasProgRptReqs = FixUtils.TAG_HAS_NO_VALUE;		
		hasProgPeriodInterval = FixUtils.TAG_HAS_NO_VALUE;		
		hasIncTaxInd = FixUtils.TAG_HAS_NO_VALUE;		
		hasForexReq = FixUtils.TAG_HAS_NO_VALUE;		
		hasNumBidders = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasBidTradeType = FixUtils.TAG_HAS_NO_VALUE;		
		hasBasisPxType = FixUtils.TAG_HAS_NO_VALUE;		
		hasStrikeTime = FixUtils.TAG_HAS_NO_VALUE;		
		strikeTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		bidDescReqGrp = new FixBidDescReqGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) bidDescReqGrp[i] = new FixBidDescReqGrp();
		bidCompReqGrp = new FixBidCompReqGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) bidCompReqGrp[i] = new FixBidCompReqGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.BIDID_INT:		
            		hasBidID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLIENTBIDID_INT:		
            		hasClientBidID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BIDREQUESTTRANSTYPE_INT:		
            		hasBidRequestTransType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LISTNAME_INT:		
            		hasListName = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TOTNORELATEDSYM_INT:		
            		hasTotNoRelatedSym = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BIDTYPE_INT:		
            		hasBidType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.NUMTICKETS_INT:		
            		hasNumTickets = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SIDEVALUE1_INT:		
            		hasSideValue1 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SIDEVALUE2_INT:		
            		hasSideValue2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LIQUIDITYINDTYPE_INT:		
            		hasLiquidityIndType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.WTAVERAGELIQUIDITY_INT:		
            		hasWtAverageLiquidity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXCHANGEFORPHYSICAL_INT:		
            		hasExchangeForPhysical = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.OUTMAINCNTRYUINDEX_INT:		
            		hasOutMainCntryUIndex = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CROSSPERCENT_INT:		
            		hasCrossPercent = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PROGRPTREQS_INT:		
            		hasProgRptReqs = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PROGPERIODINTERVAL_INT:		
            		hasProgPeriodInterval = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.INCTAXIND_INT:		
            		hasIncTaxInd = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.FOREXREQ_INT:		
            		hasForexReq = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.NUMBIDDERS_INT:		
            		hasNumBidders = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEDATE_INT:		
            		hasTradeDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BIDTRADETYPE_INT:		
            		hasBidTradeType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BASISPXTYPE_INT:		
            		hasBasisPxType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.STRIKETIME_INT:		
            		hasStrikeTime = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOBIDDESCRIPTORS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !bidDescReqGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = bidDescReqGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOBIDCOMPONENTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !bidCompReqGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = bidCompReqGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else break; //TODO INVALID_TAG error
					}

			}

        		if (err.hasError()) return;

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	public boolean hasRequiredTags(FixValidationError err) {
		standardHeader.hasRequiredTags(err); if (err.hasError()) return false; 

		if (!hasClientBidID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ClientBidID missing", FixTags.CLIENTBIDID_INT, FixMessageInfo.MessageTypes.BIDREQUEST);
			return false;
		}
		if (!hasBidRequestTransType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag BidRequestTransType missing", FixTags.BIDREQUESTTRANSTYPE_INT, FixMessageInfo.MessageTypes.BIDREQUEST);
			return false;
		}
		if (!hasTotNoRelatedSym()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TotNoRelatedSym missing", FixTags.TOTNORELATEDSYM_INT, FixMessageInfo.MessageTypes.BIDREQUEST);
			return false;
		}
		if (!hasBidType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag BidType missing", FixTags.BIDTYPE_INT, FixMessageInfo.MessageTypes.BIDREQUEST);
			return false;
		}
		if (!hasBidTradeType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag BidTradeType missing", FixTags.BIDTRADETYPE_INT, FixMessageInfo.MessageTypes.BIDREQUEST);
			return false;
		}
		if (!hasBasisPxType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag BasisPxType missing", FixTags.BASISPXTYPE_INT, FixMessageInfo.MessageTypes.BIDREQUEST);
			return false;
		}
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getBidID();		
		getClientBidID();		
		getBidRequestTransType();		
		getListName();		
		getTotNoRelatedSym();		
		getBidType();		
		getNumTickets();		
		getCurrency();		
		getSideValue1();		
		getSideValue2();		
		getLiquidityIndType();		
		getWtAverageLiquidity();		
		getExchangeForPhysical();		
		getOutMainCntryUIndex();		
		getCrossPercent();		
		getProgRptReqs();		
		getProgPeriodInterval();		
		getIncTaxInd();		
		getForexReq();		
		getNumBidders();		
		getTradeDate();		
		getBidTradeType();		
		getBasisPxType();		
		getStrikeTime();		
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
		if (hasBidID()) {		
			out.put(FixTags.BIDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,bidID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClientBidID()) {		
			out.put(FixTags.CLIENTBIDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clientBidID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBidRequestTransType()) {		
			out.put(FixTags.BIDREQUESTTRANSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,bidRequestTransType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasListName()) {		
			out.put(FixTags.LISTNAME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,listName); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotNoRelatedSym()) {		
			out.put(FixTags.TOTNORELATEDSYM);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totNoRelatedSym);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBidType()) {		
			out.put(FixTags.BIDTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)bidType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNumTickets()) {		
			out.put(FixTags.NUMTICKETS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)numTickets);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSideValue1()) {		
			out.put(FixTags.SIDEVALUE1);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)sideValue1);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSideValue2()) {		
			out.put(FixTags.SIDEVALUE2);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)sideValue2);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLiquidityIndType()) {		
			out.put(FixTags.LIQUIDITYINDTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)liquidityIndType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasWtAverageLiquidity()) {		
			out.put(FixTags.WTAVERAGELIQUIDITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)wtAverageLiquidity);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExchangeForPhysical()) {		
			out.put(FixTags.EXCHANGEFORPHYSICAL);		
		
			out.put((byte) '=');		
		
			out.put(exchangeForPhysical?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOutMainCntryUIndex()) {		
			out.put(FixTags.OUTMAINCNTRYUINDEX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)outMainCntryUIndex);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCrossPercent()) {		
			out.put(FixTags.CROSSPERCENT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)crossPercent);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasProgRptReqs()) {		
			out.put(FixTags.PROGRPTREQS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)progRptReqs);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasProgPeriodInterval()) {		
			out.put(FixTags.PROGPERIODINTERVAL);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)progPeriodInterval);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasIncTaxInd()) {		
			out.put(FixTags.INCTAXIND);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)incTaxInd);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasForexReq()) {		
			out.put(FixTags.FOREXREQ);		
		
			out.put((byte) '=');		
		
			out.put(forexReq?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNumBidders()) {		
			out.put(FixTags.NUMBIDDERS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)numBidders);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeDate()) {		
			out.put(FixTags.TRADEDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBidTradeType()) {		
			out.put(FixTags.BIDTRADETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,bidTradeType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBasisPxType()) {		
			out.put(FixTags.BASISPXTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,basisPxType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasStrikeTime()) {		
			out.put(FixTags.STRIKETIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,strikeTime); 		
		
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
		
		if (FixUtils.getNoInGroup(bidDescReqGrp)>0) {
			out.put(FixTags.NOBIDDESCRIPTORS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(bidDescReqGrp));

			out.put(FixUtils.SOH);

		}
		for (FixBidDescReqGrp fixBidDescReqGrp : bidDescReqGrp) if (fixBidDescReqGrp.hasGroup()) fixBidDescReqGrp.encode(out);
		if (FixUtils.getNoInGroup(bidCompReqGrp)>0) {
			out.put(FixTags.NOBIDCOMPONENTS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(bidCompReqGrp));

			out.put(FixUtils.SOH);

		}
		for (FixBidCompReqGrp fixBidCompReqGrp : bidCompReqGrp) if (fixBidCompReqGrp.hasGroup()) fixBidCompReqGrp.encode(out);
		
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
		
		if (hasBidID()) {		
			FixUtils.put(out,bidID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClientBidID()) {		
			FixUtils.put(out,clientBidID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidRequestTransType()) {		
			FixUtils.put(out,bidRequestTransType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasListName()) {		
			FixUtils.put(out,listName); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNoRelatedSym()) {		
			FixUtils.put(out, (long)totNoRelatedSym);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidType()) {		
			FixUtils.put(out, (long)bidType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNumTickets()) {		
			FixUtils.put(out, (long)numTickets);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideValue1()) {		
			FixUtils.put(out, (long)sideValue1);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideValue2()) {		
			FixUtils.put(out, (long)sideValue2);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLiquidityIndType()) {		
			FixUtils.put(out, (long)liquidityIndType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasWtAverageLiquidity()) {		
			FixUtils.put(out, (long)wtAverageLiquidity);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExchangeForPhysical()) {		
			out.put(exchangeForPhysical?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOutMainCntryUIndex()) {		
			FixUtils.put(out, (long)outMainCntryUIndex);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCrossPercent()) {		
			FixUtils.put(out, (long)crossPercent);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasProgRptReqs()) {		
			FixUtils.put(out, (long)progRptReqs);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasProgPeriodInterval()) {		
			FixUtils.put(out, (long)progPeriodInterval);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIncTaxInd()) {		
			FixUtils.put(out, (long)incTaxInd);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasForexReq()) {		
			out.put(forexReq?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNumBidders()) {		
			FixUtils.put(out, (long)numBidders);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeDate()) {		
			FixUtils.put(out,tradeDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidTradeType()) {		
			FixUtils.put(out,bidTradeType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBasisPxType()) {		
			FixUtils.put(out,basisPxType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStrikeTime()) {		
			FixUtils.put(out,strikeTime); 		
		
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
			
	public void crackBidID() {		
		getBidID();		
	}		
			
	public byte[] getBidID() { 		
		if ( hasBidID()) {		
			if (hasBidID == FixUtils.TAG_HAS_VALUE) {		
				return bidID; 		
			} else {

				buf.position(hasBidID);

			FixMessage.getTagStringValue(buf, bidID, 0, bidID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasBidID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBidID() { return hasBidID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidID(byte[] src) {		
		if (src == null ) return;
		if (hasBidID()) FixUtils.fillNul(bidID);		
		FixUtils.copy(bidID, src); 		
		hasBidID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidID(String str) {		
		if (str == null ) return;
		if (hasBidID()) FixUtils.fillNul(bidID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(bidID, src); 		
		hasBidID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClientBidID() {		
		getClientBidID();		
	}		
			
	public byte[] getClientBidID() { 		
		if ( hasClientBidID()) {		
			if (hasClientBidID == FixUtils.TAG_HAS_VALUE) {		
				return clientBidID; 		
			} else {

				buf.position(hasClientBidID);

			FixMessage.getTagStringValue(buf, clientBidID, 0, clientBidID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClientBidID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clientBidID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClientBidID() { return hasClientBidID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClientBidID(byte[] src) {		
		if (src == null ) return;
		if (hasClientBidID()) FixUtils.fillNul(clientBidID);		
		FixUtils.copy(clientBidID, src); 		
		hasClientBidID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClientBidID(String str) {		
		if (str == null ) return;
		if (hasClientBidID()) FixUtils.fillNul(clientBidID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clientBidID, src); 		
		hasClientBidID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBidRequestTransType() {		
		getBidRequestTransType();		
	}		
			
	public byte getBidRequestTransType() { 		
		if ( hasBidRequestTransType()) {		
			if (hasBidRequestTransType == FixUtils.TAG_HAS_VALUE) {		
				return bidRequestTransType; 		
			} else {

				buf.position(hasBidRequestTransType);

			bidRequestTransType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (bidRequestTransType != (byte)'C') && (bidRequestTransType != (byte)'N') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 374);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasBidRequestTransType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidRequestTransType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasBidRequestTransType() { return hasBidRequestTransType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidRequestTransType(byte[] src) {		
		if (src == null ) return;
		if (hasBidRequestTransType()) bidRequestTransType = (byte)' ';		
		bidRequestTransType = src[0];		
		hasBidRequestTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidRequestTransType(byte src) {		
		bidRequestTransType = src;
		hasBidRequestTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidRequestTransType(String str) {		
		if (str == null ) return;
		if (hasBidRequestTransType()) bidRequestTransType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		bidRequestTransType = src[0];		
		hasBidRequestTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackListName() {		
		getListName();		
	}		
			
	public byte[] getListName() { 		
		if ( hasListName()) {		
			if (hasListName == FixUtils.TAG_HAS_VALUE) {		
				return listName; 		
			} else {

				buf.position(hasListName);

			FixMessage.getTagStringValue(buf, listName, 0, listName.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasListName = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return listName;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasListName() { return hasListName != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setListName(byte[] src) {		
		if (src == null ) return;
		if (hasListName()) FixUtils.fillNul(listName);		
		FixUtils.copy(listName, src); 		
		hasListName = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListName(String str) {		
		if (str == null ) return;
		if (hasListName()) FixUtils.fillNul(listName);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(listName, src); 		
		hasListName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTotNoRelatedSym() {		
		getTotNoRelatedSym();		
	}		
			
	public long getTotNoRelatedSym() { 		
		if ( hasTotNoRelatedSym()) {		
			if (hasTotNoRelatedSym == FixUtils.TAG_HAS_VALUE) {		
				return totNoRelatedSym; 		
			} else {

				buf.position(hasTotNoRelatedSym);

			totNoRelatedSym = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotNoRelatedSym = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totNoRelatedSym;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNoRelatedSym() { return hasTotNoRelatedSym != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotNoRelatedSym(byte[] src) {		
		if (src == null ) return;
		if (hasTotNoRelatedSym()) totNoRelatedSym = FixUtils.TAG_HAS_NO_VALUE;		
		totNoRelatedSym = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoRelatedSym = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoRelatedSym(long src) {		
		totNoRelatedSym = src;
		hasTotNoRelatedSym = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoRelatedSym(String str) {		
		if (str == null ) return;
		if (hasTotNoRelatedSym()) totNoRelatedSym = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNoRelatedSym = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoRelatedSym = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBidType() {		
		getBidType();		
	}		
			
	public long getBidType() { 		
		if ( hasBidType()) {		
			if (hasBidType == FixUtils.TAG_HAS_VALUE) {		
				return bidType; 		
			} else {

				buf.position(hasBidType);

			bidType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBidType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidType() { return hasBidType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidType(byte[] src) {		
		if (src == null ) return;
		if (hasBidType()) bidType = FixUtils.TAG_HAS_NO_VALUE;		
		bidType = FixUtils.longValueOf(src, 0, src.length);
		hasBidType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidType(long src) {		
		bidType = src;
		hasBidType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidType(String str) {		
		if (str == null ) return;
		if (hasBidType()) bidType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidType = FixUtils.longValueOf(src, 0, src.length);
		hasBidType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackNumTickets() {		
		getNumTickets();		
	}		
			
	public long getNumTickets() { 		
		if ( hasNumTickets()) {		
			if (hasNumTickets == FixUtils.TAG_HAS_VALUE) {		
				return numTickets; 		
			} else {

				buf.position(hasNumTickets);

			numTickets = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasNumTickets = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return numTickets;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNumTickets() { return hasNumTickets != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNumTickets(byte[] src) {		
		if (src == null ) return;
		if (hasNumTickets()) numTickets = FixUtils.TAG_HAS_NO_VALUE;		
		numTickets = FixUtils.longValueOf(src, 0, src.length);
		hasNumTickets = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNumTickets(long src) {		
		numTickets = src;
		hasNumTickets = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNumTickets(String str) {		
		if (str == null ) return;
		if (hasNumTickets()) numTickets = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		numTickets = FixUtils.longValueOf(src, 0, src.length);
		hasNumTickets = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackSideValue1() {		
		getSideValue1();		
	}		
			
	public long getSideValue1() { 		
		if ( hasSideValue1()) {		
			if (hasSideValue1 == FixUtils.TAG_HAS_VALUE) {		
				return sideValue1; 		
			} else {

				buf.position(hasSideValue1);

			sideValue1 = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSideValue1 = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return sideValue1;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSideValue1() { return hasSideValue1 != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSideValue1(byte[] src) {		
		if (src == null ) return;
		if (hasSideValue1()) sideValue1 = FixUtils.TAG_HAS_NO_VALUE;		
		sideValue1 = FixUtils.longValueOf(src, 0, src.length);
		hasSideValue1 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSideValue1(long src) {		
		sideValue1 = src;
		hasSideValue1 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSideValue1(String str) {		
		if (str == null ) return;
		if (hasSideValue1()) sideValue1 = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sideValue1 = FixUtils.longValueOf(src, 0, src.length);
		hasSideValue1 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSideValue2() {		
		getSideValue2();		
	}		
			
	public long getSideValue2() { 		
		if ( hasSideValue2()) {		
			if (hasSideValue2 == FixUtils.TAG_HAS_VALUE) {		
				return sideValue2; 		
			} else {

				buf.position(hasSideValue2);

			sideValue2 = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSideValue2 = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return sideValue2;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSideValue2() { return hasSideValue2 != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSideValue2(byte[] src) {		
		if (src == null ) return;
		if (hasSideValue2()) sideValue2 = FixUtils.TAG_HAS_NO_VALUE;		
		sideValue2 = FixUtils.longValueOf(src, 0, src.length);
		hasSideValue2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSideValue2(long src) {		
		sideValue2 = src;
		hasSideValue2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSideValue2(String str) {		
		if (str == null ) return;
		if (hasSideValue2()) sideValue2 = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sideValue2 = FixUtils.longValueOf(src, 0, src.length);
		hasSideValue2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLiquidityIndType() {		
		getLiquidityIndType();		
	}		
			
	public long getLiquidityIndType() { 		
		if ( hasLiquidityIndType()) {		
			if (hasLiquidityIndType == FixUtils.TAG_HAS_VALUE) {		
				return liquidityIndType; 		
			} else {

				buf.position(hasLiquidityIndType);

			liquidityIndType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLiquidityIndType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return liquidityIndType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLiquidityIndType() { return hasLiquidityIndType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLiquidityIndType(byte[] src) {		
		if (src == null ) return;
		if (hasLiquidityIndType()) liquidityIndType = FixUtils.TAG_HAS_NO_VALUE;		
		liquidityIndType = FixUtils.longValueOf(src, 0, src.length);
		hasLiquidityIndType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLiquidityIndType(long src) {		
		liquidityIndType = src;
		hasLiquidityIndType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLiquidityIndType(String str) {		
		if (str == null ) return;
		if (hasLiquidityIndType()) liquidityIndType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		liquidityIndType = FixUtils.longValueOf(src, 0, src.length);
		hasLiquidityIndType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackWtAverageLiquidity() {		
		getWtAverageLiquidity();		
	}		
			
	public long getWtAverageLiquidity() { 		
		if ( hasWtAverageLiquidity()) {		
			if (hasWtAverageLiquidity == FixUtils.TAG_HAS_VALUE) {		
				return wtAverageLiquidity; 		
			} else {

				buf.position(hasWtAverageLiquidity);

			wtAverageLiquidity = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasWtAverageLiquidity = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return wtAverageLiquidity;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasWtAverageLiquidity() { return hasWtAverageLiquidity != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setWtAverageLiquidity(byte[] src) {		
		if (src == null ) return;
		if (hasWtAverageLiquidity()) wtAverageLiquidity = FixUtils.TAG_HAS_NO_VALUE;		
		wtAverageLiquidity = FixUtils.longValueOf(src, 0, src.length);
		hasWtAverageLiquidity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setWtAverageLiquidity(long src) {		
		wtAverageLiquidity = src;
		hasWtAverageLiquidity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setWtAverageLiquidity(String str) {		
		if (str == null ) return;
		if (hasWtAverageLiquidity()) wtAverageLiquidity = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		wtAverageLiquidity = FixUtils.longValueOf(src, 0, src.length);
		hasWtAverageLiquidity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExchangeForPhysical() {		
		getExchangeForPhysical();		
	}		
			
	public boolean getExchangeForPhysical() { 		
		if ( hasExchangeForPhysical()) {		
			if (hasExchangeForPhysical == FixUtils.TAG_HAS_VALUE) {		
				return exchangeForPhysical; 		
			} else {

				buf.position(hasExchangeForPhysical);

			exchangeForPhysical = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasExchangeForPhysical = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return exchangeForPhysical;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasExchangeForPhysical() { return hasExchangeForPhysical != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExchangeForPhysical(byte[] src) {		
		if (src == null ) return;
		if (hasExchangeForPhysical()) exchangeForPhysical = false;		
		exchangeForPhysical = src[0]==(byte)'Y'?true:false;		
		hasExchangeForPhysical = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExchangeForPhysical(boolean src) {		
		exchangeForPhysical = src;
		hasExchangeForPhysical = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExchangeForPhysical(String str) {		
		if (str == null ) return;
		if (hasExchangeForPhysical()) exchangeForPhysical = false;		
		byte[] src = str.getBytes(); 		
		exchangeForPhysical = src[0]==(byte)'Y'?true:false;		
		hasExchangeForPhysical = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOutMainCntryUIndex() {		
		getOutMainCntryUIndex();		
	}		
			
	public long getOutMainCntryUIndex() { 		
		if ( hasOutMainCntryUIndex()) {		
			if (hasOutMainCntryUIndex == FixUtils.TAG_HAS_VALUE) {		
				return outMainCntryUIndex; 		
			} else {

				buf.position(hasOutMainCntryUIndex);

			outMainCntryUIndex = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasOutMainCntryUIndex = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return outMainCntryUIndex;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOutMainCntryUIndex() { return hasOutMainCntryUIndex != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOutMainCntryUIndex(byte[] src) {		
		if (src == null ) return;
		if (hasOutMainCntryUIndex()) outMainCntryUIndex = FixUtils.TAG_HAS_NO_VALUE;		
		outMainCntryUIndex = FixUtils.longValueOf(src, 0, src.length);
		hasOutMainCntryUIndex = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOutMainCntryUIndex(long src) {		
		outMainCntryUIndex = src;
		hasOutMainCntryUIndex = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOutMainCntryUIndex(String str) {		
		if (str == null ) return;
		if (hasOutMainCntryUIndex()) outMainCntryUIndex = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		outMainCntryUIndex = FixUtils.longValueOf(src, 0, src.length);
		hasOutMainCntryUIndex = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCrossPercent() {		
		getCrossPercent();		
	}		
			
	public long getCrossPercent() { 		
		if ( hasCrossPercent()) {		
			if (hasCrossPercent == FixUtils.TAG_HAS_VALUE) {		
				return crossPercent; 		
			} else {

				buf.position(hasCrossPercent);

			crossPercent = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCrossPercent = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return crossPercent;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCrossPercent() { return hasCrossPercent != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCrossPercent(byte[] src) {		
		if (src == null ) return;
		if (hasCrossPercent()) crossPercent = FixUtils.TAG_HAS_NO_VALUE;		
		crossPercent = FixUtils.longValueOf(src, 0, src.length);
		hasCrossPercent = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossPercent(long src) {		
		crossPercent = src;
		hasCrossPercent = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossPercent(String str) {		
		if (str == null ) return;
		if (hasCrossPercent()) crossPercent = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		crossPercent = FixUtils.longValueOf(src, 0, src.length);
		hasCrossPercent = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackProgRptReqs() {		
		getProgRptReqs();		
	}		
			
	public long getProgRptReqs() { 		
		if ( hasProgRptReqs()) {		
			if (hasProgRptReqs == FixUtils.TAG_HAS_VALUE) {		
				return progRptReqs; 		
			} else {

				buf.position(hasProgRptReqs);

			progRptReqs = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasProgRptReqs = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return progRptReqs;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasProgRptReqs() { return hasProgRptReqs != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setProgRptReqs(byte[] src) {		
		if (src == null ) return;
		if (hasProgRptReqs()) progRptReqs = FixUtils.TAG_HAS_NO_VALUE;		
		progRptReqs = FixUtils.longValueOf(src, 0, src.length);
		hasProgRptReqs = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProgRptReqs(long src) {		
		progRptReqs = src;
		hasProgRptReqs = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProgRptReqs(String str) {		
		if (str == null ) return;
		if (hasProgRptReqs()) progRptReqs = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		progRptReqs = FixUtils.longValueOf(src, 0, src.length);
		hasProgRptReqs = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackProgPeriodInterval() {		
		getProgPeriodInterval();		
	}		
			
	public long getProgPeriodInterval() { 		
		if ( hasProgPeriodInterval()) {		
			if (hasProgPeriodInterval == FixUtils.TAG_HAS_VALUE) {		
				return progPeriodInterval; 		
			} else {

				buf.position(hasProgPeriodInterval);

			progPeriodInterval = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasProgPeriodInterval = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return progPeriodInterval;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasProgPeriodInterval() { return hasProgPeriodInterval != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setProgPeriodInterval(byte[] src) {		
		if (src == null ) return;
		if (hasProgPeriodInterval()) progPeriodInterval = FixUtils.TAG_HAS_NO_VALUE;		
		progPeriodInterval = FixUtils.longValueOf(src, 0, src.length);
		hasProgPeriodInterval = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProgPeriodInterval(long src) {		
		progPeriodInterval = src;
		hasProgPeriodInterval = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProgPeriodInterval(String str) {		
		if (str == null ) return;
		if (hasProgPeriodInterval()) progPeriodInterval = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		progPeriodInterval = FixUtils.longValueOf(src, 0, src.length);
		hasProgPeriodInterval = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackIncTaxInd() {		
		getIncTaxInd();		
	}		
			
	public long getIncTaxInd() { 		
		if ( hasIncTaxInd()) {		
			if (hasIncTaxInd == FixUtils.TAG_HAS_VALUE) {		
				return incTaxInd; 		
			} else {

				buf.position(hasIncTaxInd);

			incTaxInd = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasIncTaxInd = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return incTaxInd;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasIncTaxInd() { return hasIncTaxInd != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setIncTaxInd(byte[] src) {		
		if (src == null ) return;
		if (hasIncTaxInd()) incTaxInd = FixUtils.TAG_HAS_NO_VALUE;		
		incTaxInd = FixUtils.longValueOf(src, 0, src.length);
		hasIncTaxInd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIncTaxInd(long src) {		
		incTaxInd = src;
		hasIncTaxInd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIncTaxInd(String str) {		
		if (str == null ) return;
		if (hasIncTaxInd()) incTaxInd = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		incTaxInd = FixUtils.longValueOf(src, 0, src.length);
		hasIncTaxInd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackForexReq() {		
		getForexReq();		
	}		
			
	public boolean getForexReq() { 		
		if ( hasForexReq()) {		
			if (hasForexReq == FixUtils.TAG_HAS_VALUE) {		
				return forexReq; 		
			} else {

				buf.position(hasForexReq);

			forexReq = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasForexReq = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return forexReq;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasForexReq() { return hasForexReq != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setForexReq(byte[] src) {		
		if (src == null ) return;
		if (hasForexReq()) forexReq = false;		
		forexReq = src[0]==(byte)'Y'?true:false;		
		hasForexReq = FixUtils.TAG_HAS_VALUE;		
	}

	public void setForexReq(boolean src) {		
		forexReq = src;
		hasForexReq = FixUtils.TAG_HAS_VALUE;		
	}

	public void setForexReq(String str) {		
		if (str == null ) return;
		if (hasForexReq()) forexReq = false;		
		byte[] src = str.getBytes(); 		
		forexReq = src[0]==(byte)'Y'?true:false;		
		hasForexReq = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackNumBidders() {		
		getNumBidders();		
	}		
			
	public long getNumBidders() { 		
		if ( hasNumBidders()) {		
			if (hasNumBidders == FixUtils.TAG_HAS_VALUE) {		
				return numBidders; 		
			} else {

				buf.position(hasNumBidders);

			numBidders = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasNumBidders = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return numBidders;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNumBidders() { return hasNumBidders != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNumBidders(byte[] src) {		
		if (src == null ) return;
		if (hasNumBidders()) numBidders = FixUtils.TAG_HAS_NO_VALUE;		
		numBidders = FixUtils.longValueOf(src, 0, src.length);
		hasNumBidders = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNumBidders(long src) {		
		numBidders = src;
		hasNumBidders = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNumBidders(String str) {		
		if (str == null ) return;
		if (hasNumBidders()) numBidders = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		numBidders = FixUtils.longValueOf(src, 0, src.length);
		hasNumBidders = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeDate() {		
		getTradeDate();		
	}		
			
	public byte[] getTradeDate() { 		
		if ( hasTradeDate()) {		
			if (hasTradeDate == FixUtils.TAG_HAS_VALUE) {		
				return tradeDate; 		
			} else {

				buf.position(hasTradeDate);

			FixMessage.getTagStringValue(buf, tradeDate, 0, tradeDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
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
			
	public void crackBidTradeType() {		
		getBidTradeType();		
	}		
			
	public byte getBidTradeType() { 		
		if ( hasBidTradeType()) {		
			if (hasBidTradeType == FixUtils.TAG_HAS_VALUE) {		
				return bidTradeType; 		
			} else {

				buf.position(hasBidTradeType);

			bidTradeType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (bidTradeType != (byte)'G') && (bidTradeType != (byte)'A') && (bidTradeType != (byte)'R') && (bidTradeType != (byte)'J') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 418);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasBidTradeType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidTradeType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasBidTradeType() { return hasBidTradeType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidTradeType(byte[] src) {		
		if (src == null ) return;
		if (hasBidTradeType()) bidTradeType = (byte)' ';		
		bidTradeType = src[0];		
		hasBidTradeType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidTradeType(byte src) {		
		bidTradeType = src;
		hasBidTradeType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidTradeType(String str) {		
		if (str == null ) return;
		if (hasBidTradeType()) bidTradeType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		bidTradeType = src[0];		
		hasBidTradeType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBasisPxType() {		
		getBasisPxType();		
	}		
			
	public byte getBasisPxType() { 		
		if ( hasBasisPxType()) {		
			if (hasBasisPxType == FixUtils.TAG_HAS_VALUE) {		
				return basisPxType; 		
			} else {

				buf.position(hasBasisPxType);

			basisPxType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (basisPxType != (byte)'D') && (basisPxType != (byte)'A') && (basisPxType != (byte)'B') && (basisPxType != (byte)'C') && (basisPxType != (byte)'3') && (basisPxType != (byte)'2') && (basisPxType != (byte)'7') && (basisPxType != (byte)'6') && (basisPxType != (byte)'5') && (basisPxType != (byte)'4') && (basisPxType != (byte)'9') && (basisPxType != (byte)'8') && (basisPxType != (byte)'Z') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 419);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasBasisPxType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return basisPxType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasBasisPxType() { return hasBasisPxType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBasisPxType(byte[] src) {		
		if (src == null ) return;
		if (hasBasisPxType()) basisPxType = (byte)' ';		
		basisPxType = src[0];		
		hasBasisPxType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBasisPxType(byte src) {		
		basisPxType = src;
		hasBasisPxType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBasisPxType(String str) {		
		if (str == null ) return;
		if (hasBasisPxType()) basisPxType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		basisPxType = src[0];		
		hasBasisPxType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackStrikeTime() {		
		getStrikeTime();		
	}		
			
	public byte[] getStrikeTime() { 		
		if ( hasStrikeTime()) {		
			if (hasStrikeTime == FixUtils.TAG_HAS_VALUE) {		
				return strikeTime; 		
			} else {

				buf.position(hasStrikeTime);

			FixMessage.getTagStringValue(buf, strikeTime, 0, strikeTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasStrikeTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return strikeTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStrikeTime() { return hasStrikeTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStrikeTime(byte[] src) {		
		if (src == null ) return;
		if (hasStrikeTime()) FixUtils.fillNul(strikeTime);		
		FixUtils.copy(strikeTime, src); 		
		hasStrikeTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStrikeTime(String str) {		
		if (str == null ) return;
		if (hasStrikeTime()) FixUtils.fillNul(strikeTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(strikeTime, src); 		
		hasStrikeTime = FixUtils.TAG_HAS_VALUE;		
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

					if (hasBidID()) s += "BidID(390)= " + new String( FixUtils.trim(getBidID()) ) + "\n" ; 
		if (hasClientBidID()) s += "ClientBidID(391)= " + new String( FixUtils.trim(getClientBidID()) ) + "\n" ; 
		if (hasBidRequestTransType()) s += "BidRequestTransType(374)= " + getBidRequestTransType() + "\n" ; 
		if (hasListName()) s += "ListName(392)= " + new String( FixUtils.trim(getListName()) ) + "\n" ; 
		if (hasTotNoRelatedSym()) s += "TotNoRelatedSym(393)= " + getTotNoRelatedSym() + "\n" ; 
		if (hasBidType()) s += "BidType(394)= " + getBidType() + "\n" ; 
		if (hasNumTickets()) s += "NumTickets(395)= " + getNumTickets() + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasSideValue1()) s += "SideValue1(396)= " + getSideValue1() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSideValue2()) s += "SideValue2(397)= " + getSideValue2() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLiquidityIndType()) s += "LiquidityIndType(409)= " + getLiquidityIndType() + "\n" ; 
		if (hasWtAverageLiquidity()) s += "WtAverageLiquidity(410)= " + getWtAverageLiquidity() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasExchangeForPhysical()) s += "ExchangeForPhysical(411)= " + getExchangeForPhysical() + "\n" ; 
		if (hasOutMainCntryUIndex()) s += "OutMainCntryUIndex(412)= " + getOutMainCntryUIndex() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCrossPercent()) s += "CrossPercent(413)= " + getCrossPercent() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasProgRptReqs()) s += "ProgRptReqs(414)= " + getProgRptReqs() + "\n" ; 
		if (hasProgPeriodInterval()) s += "ProgPeriodInterval(415)= " + getProgPeriodInterval() + "\n" ; 
		if (hasIncTaxInd()) s += "IncTaxInd(416)= " + getIncTaxInd() + "\n" ; 
		if (hasForexReq()) s += "ForexReq(121)= " + getForexReq() + "\n" ; 
		if (hasNumBidders()) s += "NumBidders(417)= " + getNumBidders() + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasBidTradeType()) s += "BidTradeType(418)= " + getBidTradeType() + "\n" ; 
		if (hasBasisPxType()) s += "BasisPxType(419)= " + getBasisPxType() + "\n" ; 
		if (hasStrikeTime()) s += "StrikeTime(443)= " + new String( FixUtils.trim(getStrikeTime()) ) + "\n" ; 
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
		if (! ( o instanceof FixBidRequest)) return false;

		FixBidRequest msg = (FixBidRequest) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasBidID() && !msg.hasBidID()) || (!hasBidID() && msg.hasBidID())) return false;
		if (!(!hasBidID() && !msg.hasBidID()) && !FixUtils.equals(getBidID(), msg.getBidID())) return false;
		if ((hasClientBidID() && !msg.hasClientBidID()) || (!hasClientBidID() && msg.hasClientBidID())) return false;
		if (!(!hasClientBidID() && !msg.hasClientBidID()) && !FixUtils.equals(getClientBidID(), msg.getClientBidID())) return false;
		if ((hasBidRequestTransType() && !msg.hasBidRequestTransType()) || (!hasBidRequestTransType() && msg.hasBidRequestTransType())) return false;
		if (!(!hasBidRequestTransType() && !msg.hasBidRequestTransType()) && !(getBidRequestTransType()==msg.getBidRequestTransType())) return false;
		if ((hasListName() && !msg.hasListName()) || (!hasListName() && msg.hasListName())) return false;
		if (!(!hasListName() && !msg.hasListName()) && !FixUtils.equals(getListName(), msg.getListName())) return false;
		if ((hasTotNoRelatedSym() && !msg.hasTotNoRelatedSym()) || (!hasTotNoRelatedSym() && msg.hasTotNoRelatedSym())) return false;
		if (!(!hasTotNoRelatedSym() && !msg.hasTotNoRelatedSym()) && !(getTotNoRelatedSym()==msg.getTotNoRelatedSym())) return false;
		if ((hasBidType() && !msg.hasBidType()) || (!hasBidType() && msg.hasBidType())) return false;
		if (!(!hasBidType() && !msg.hasBidType()) && !(getBidType()==msg.getBidType())) return false;
		if ((hasNumTickets() && !msg.hasNumTickets()) || (!hasNumTickets() && msg.hasNumTickets())) return false;
		if (!(!hasNumTickets() && !msg.hasNumTickets()) && !(getNumTickets()==msg.getNumTickets())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasSideValue1() && !msg.hasSideValue1()) || (!hasSideValue1() && msg.hasSideValue1())) return false;
		if (!(!hasSideValue1() && !msg.hasSideValue1()) && !(getSideValue1()==msg.getSideValue1())) return false;
		if ((hasSideValue2() && !msg.hasSideValue2()) || (!hasSideValue2() && msg.hasSideValue2())) return false;
		if (!(!hasSideValue2() && !msg.hasSideValue2()) && !(getSideValue2()==msg.getSideValue2())) return false;
		if ((hasLiquidityIndType() && !msg.hasLiquidityIndType()) || (!hasLiquidityIndType() && msg.hasLiquidityIndType())) return false;
		if (!(!hasLiquidityIndType() && !msg.hasLiquidityIndType()) && !(getLiquidityIndType()==msg.getLiquidityIndType())) return false;
		if ((hasWtAverageLiquidity() && !msg.hasWtAverageLiquidity()) || (!hasWtAverageLiquidity() && msg.hasWtAverageLiquidity())) return false;
		if (!(!hasWtAverageLiquidity() && !msg.hasWtAverageLiquidity()) && !(getWtAverageLiquidity()==msg.getWtAverageLiquidity())) return false;
		if ((hasExchangeForPhysical() && !msg.hasExchangeForPhysical()) || (!hasExchangeForPhysical() && msg.hasExchangeForPhysical())) return false;
		if (!(!hasExchangeForPhysical() && !msg.hasExchangeForPhysical()) && !(getExchangeForPhysical()==msg.getExchangeForPhysical())) return false;
		if ((hasOutMainCntryUIndex() && !msg.hasOutMainCntryUIndex()) || (!hasOutMainCntryUIndex() && msg.hasOutMainCntryUIndex())) return false;
		if (!(!hasOutMainCntryUIndex() && !msg.hasOutMainCntryUIndex()) && !(getOutMainCntryUIndex()==msg.getOutMainCntryUIndex())) return false;
		if ((hasCrossPercent() && !msg.hasCrossPercent()) || (!hasCrossPercent() && msg.hasCrossPercent())) return false;
		if (!(!hasCrossPercent() && !msg.hasCrossPercent()) && !(getCrossPercent()==msg.getCrossPercent())) return false;
		if ((hasProgRptReqs() && !msg.hasProgRptReqs()) || (!hasProgRptReqs() && msg.hasProgRptReqs())) return false;
		if (!(!hasProgRptReqs() && !msg.hasProgRptReqs()) && !(getProgRptReqs()==msg.getProgRptReqs())) return false;
		if ((hasProgPeriodInterval() && !msg.hasProgPeriodInterval()) || (!hasProgPeriodInterval() && msg.hasProgPeriodInterval())) return false;
		if (!(!hasProgPeriodInterval() && !msg.hasProgPeriodInterval()) && !(getProgPeriodInterval()==msg.getProgPeriodInterval())) return false;
		if ((hasIncTaxInd() && !msg.hasIncTaxInd()) || (!hasIncTaxInd() && msg.hasIncTaxInd())) return false;
		if (!(!hasIncTaxInd() && !msg.hasIncTaxInd()) && !(getIncTaxInd()==msg.getIncTaxInd())) return false;
		if ((hasForexReq() && !msg.hasForexReq()) || (!hasForexReq() && msg.hasForexReq())) return false;
		if (!(!hasForexReq() && !msg.hasForexReq()) && !(getForexReq()==msg.getForexReq())) return false;
		if ((hasNumBidders() && !msg.hasNumBidders()) || (!hasNumBidders() && msg.hasNumBidders())) return false;
		if (!(!hasNumBidders() && !msg.hasNumBidders()) && !(getNumBidders()==msg.getNumBidders())) return false;
		if ((hasTradeDate() && !msg.hasTradeDate()) || (!hasTradeDate() && msg.hasTradeDate())) return false;
		if ((hasBidTradeType() && !msg.hasBidTradeType()) || (!hasBidTradeType() && msg.hasBidTradeType())) return false;
		if (!(!hasBidTradeType() && !msg.hasBidTradeType()) && !(getBidTradeType()==msg.getBidTradeType())) return false;
		if ((hasBasisPxType() && !msg.hasBasisPxType()) || (!hasBasisPxType() && msg.hasBasisPxType())) return false;
		if (!(!hasBasisPxType() && !msg.hasBasisPxType()) && !(getBasisPxType()==msg.getBasisPxType())) return false;
		if ((hasStrikeTime() && !msg.hasStrikeTime()) || (!hasStrikeTime() && msg.hasStrikeTime())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixBidRequest clone () {
		FixBidRequest out = new FixBidRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixBidRequest clone ( FixBidRequest out ) {
		if ( hasBidID())
			out.setBidID(getBidID());
		if ( hasClientBidID())
			out.setClientBidID(getClientBidID());
		if ( hasBidRequestTransType())
			out.setBidRequestTransType(getBidRequestTransType());
		if ( hasListName())
			out.setListName(getListName());
		if ( hasTotNoRelatedSym())
			out.setTotNoRelatedSym(getTotNoRelatedSym());
		if ( hasBidType())
			out.setBidType(getBidType());
		if ( hasNumTickets())
			out.setNumTickets(getNumTickets());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasSideValue1())
			out.setSideValue1(getSideValue1());
		if ( hasSideValue2())
			out.setSideValue2(getSideValue2());
		if ( hasLiquidityIndType())
			out.setLiquidityIndType(getLiquidityIndType());
		if ( hasWtAverageLiquidity())
			out.setWtAverageLiquidity(getWtAverageLiquidity());
		if ( hasExchangeForPhysical())
			out.setExchangeForPhysical(getExchangeForPhysical());
		if ( hasOutMainCntryUIndex())
			out.setOutMainCntryUIndex(getOutMainCntryUIndex());
		if ( hasCrossPercent())
			out.setCrossPercent(getCrossPercent());
		if ( hasProgRptReqs())
			out.setProgRptReqs(getProgRptReqs());
		if ( hasProgPeriodInterval())
			out.setProgPeriodInterval(getProgPeriodInterval());
		if ( hasIncTaxInd())
			out.setIncTaxInd(getIncTaxInd());
		if ( hasForexReq())
			out.setForexReq(getForexReq());
		if ( hasNumBidders())
			out.setNumBidders(getNumBidders());
		if ( hasTradeDate())
			out.setTradeDate(getTradeDate());
		if ( hasBidTradeType())
			out.setBidTradeType(getBidTradeType());
		if ( hasBasisPxType())
			out.setBasisPxType(getBasisPxType());
		if ( hasStrikeTime())
			out.setStrikeTime(getStrikeTime());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		int count = 0;
		count = 0;
		for (FixBidDescReqGrp fixBidDescReqGrp : bidDescReqGrp) {
			if (!fixBidDescReqGrp.hasGroup()) continue;
			out.bidDescReqGrp[count] = fixBidDescReqGrp.clone( out.bidDescReqGrp[count] );
			count++;
		}
		count = 0;
		for (FixBidCompReqGrp fixBidCompReqGrp : bidCompReqGrp) {
			if (!fixBidCompReqGrp.hasGroup()) continue;
			out.bidCompReqGrp[count] = fixBidCompReqGrp.clone( out.bidCompReqGrp[count] );
			count++;
		}
		return out;
	}

}
