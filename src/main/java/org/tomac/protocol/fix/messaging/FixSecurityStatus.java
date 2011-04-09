package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixSecurityStatus extends FixInMessage {
	private short hasSecurityStatusReqID;
	byte[] securityStatusReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasMarketID;
	byte[] marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketSegmentID;
	byte[] marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnsolicitedIndicator;
		boolean unsolicitedIndicator = false;		
	private short hasSecurityTradingStatus;
	long securityTradingStatus = 0;		
	private short hasSecurityTradingEvent;
	long securityTradingEvent = 0;		
	private short hasFinancialStatus;
	byte[] financialStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCorporateAction;
	byte[] corporateAction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasHaltReason;
	long haltReason = 0;		
	private short hasInViewOfCommon;
		boolean inViewOfCommon = false;		
	private short hasDueToRelated;
		boolean dueToRelated = false;		
	private short hasMDBookType;
	long mDBookType = 0;		
	private short hasMarketDepth;
	long marketDepth = 0;		
	private short hasBuyVolume;
	long buyVolume = 0;		
	private short hasSellVolume;
	long sellVolume = 0;		
	private short hasHighPx;
	long highPx = 0;		
	private short hasLowPx;
	long lowPx = 0;		
	private short hasLastPx;
	long lastPx = 0;		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasAdjustment;
	long adjustment = 0;		
	private short hasFirstPx;
	long firstPx = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixInstrument instrument;
	public FixInstrumentExtension instrumentExtension;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	
	public FixSecurityStatus() {
		super(FixMessageInfo.MessageTypes.SECURITYSTATUS);


		hasSecurityStatusReqID = FixUtils.TAG_HAS_NO_VALUE;		
		securityStatusReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasMarketID = FixUtils.TAG_HAS_NO_VALUE;		
		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketSegmentID = FixUtils.TAG_HAS_NO_VALUE;		
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityTradingStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityTradingEvent = FixUtils.TAG_HAS_NO_VALUE;		
		hasFinancialStatus = FixUtils.TAG_HAS_NO_VALUE;		
		financialStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCorporateAction = FixUtils.TAG_HAS_NO_VALUE;		
		corporateAction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasHaltReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasInViewOfCommon = FixUtils.TAG_HAS_NO_VALUE;		
		hasDueToRelated = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDBookType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMarketDepth = FixUtils.TAG_HAS_NO_VALUE;		
		hasBuyVolume = FixUtils.TAG_HAS_NO_VALUE;		
		hasSellVolume = FixUtils.TAG_HAS_NO_VALUE;		
		hasHighPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLowPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasAdjustment = FixUtils.TAG_HAS_NO_VALUE;		
		hasFirstPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		applicationSequenceControl = new FixApplicationSequenceControl();
		instrument = new FixInstrument();
		instrumentExtension = new FixInstrumentExtension();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.SECURITYSTATUSREQID_INT:		
            		hasSecurityStatusReqID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MARKETID_INT:		
            		hasMarketID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MARKETSEGMENTID_INT:		
            		hasMarketSegmentID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADINGSESSIONID_INT:		
            		hasTradingSessionID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADINGSESSIONSUBID_INT:		
            		hasTradingSessionSubID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.UNSOLICITEDINDICATOR_INT:		
            		hasUnsolicitedIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYTRADINGSTATUS_INT:		
            		hasSecurityTradingStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYTRADINGEVENT_INT:		
            		hasSecurityTradingEvent = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.FINANCIALSTATUS_INT:		
            		hasFinancialStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CORPORATEACTION_INT:		
            		hasCorporateAction = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.HALTREASON_INT:		
            		hasHaltReason = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.INVIEWOFCOMMON_INT:		
            		hasInViewOfCommon = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.DUETORELATED_INT:		
            		hasDueToRelated = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MDBOOKTYPE_INT:		
            		hasMDBookType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MARKETDEPTH_INT:		
            		hasMarketDepth = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.BUYVOLUME_INT:		
            		hasBuyVolume = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SELLVOLUME_INT:		
            		hasSellVolume = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.HIGHPX_INT:		
            		hasHighPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LOWPX_INT:		
            		hasLowPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LASTPX_INT:		
            		hasLastPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ADJUSTMENT_INT:		
            		hasAdjustment = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.FIRSTPX_INT:		
            		hasFirstPx = (short) buf.position();		
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
        			} else if ( applicationSequenceControl.isKeyTag(tag)) {
        				tag = applicationSequenceControl.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( instrumentExtension.isKeyTag(tag)) {
        				tag = instrumentExtension.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
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
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.SECURITYSTATUS_INT);
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
		if (instrument.isRequired) instrument.hasRequiredTags(err); if (err.hasError()) return false;
		return true;
	}
	@Override		
	public void getAll() {		
		getSecurityStatusReqID();		
		getCurrency();		
		getMarketID();		
		getMarketSegmentID();		
		getTradingSessionID();		
		getTradingSessionSubID();		
		getUnsolicitedIndicator();		
		getSecurityTradingStatus();		
		getSecurityTradingEvent();		
		getFinancialStatus();		
		getCorporateAction();		
		getHaltReason();		
		getInViewOfCommon();		
		getDueToRelated();		
		getMDBookType();		
		getMarketDepth();		
		getBuyVolume();		
		getSellVolume();		
		getHighPx();		
		getLowPx();		
		getLastPx();		
		getTransactTime();		
		getAdjustment();		
		getFirstPx();		
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
		if (hasSecurityStatusReqID()) {		
			out.put(FixTags.SECURITYSTATUSREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,securityStatusReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarketID()) {		
			out.put(FixTags.MARKETID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,marketID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarketSegmentID()) {		
			out.put(FixTags.MARKETSEGMENTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,marketSegmentID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradingSessionID()) {		
			out.put(FixTags.TRADINGSESSIONID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradingSessionID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradingSessionSubID()) {		
			out.put(FixTags.TRADINGSESSIONSUBID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradingSessionSubID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasUnsolicitedIndicator()) {		
			out.put(FixTags.UNSOLICITEDINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(unsolicitedIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityTradingStatus()) {		
			out.put(FixTags.SECURITYTRADINGSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)securityTradingStatus);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityTradingEvent()) {		
			out.put(FixTags.SECURITYTRADINGEVENT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)securityTradingEvent);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasFinancialStatus()) {		
			out.put(FixTags.FINANCIALSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,financialStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCorporateAction()) {		
			out.put(FixTags.CORPORATEACTION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,corporateAction); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasHaltReason()) {		
			out.put(FixTags.HALTREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)haltReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasInViewOfCommon()) {		
			out.put(FixTags.INVIEWOFCOMMON);		
		
			out.put((byte) '=');		
		
			out.put(inViewOfCommon?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDueToRelated()) {		
			out.put(FixTags.DUETORELATED);		
		
			out.put((byte) '=');		
		
			out.put(dueToRelated?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMDBookType()) {		
			out.put(FixTags.MDBOOKTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)mDBookType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarketDepth()) {		
			out.put(FixTags.MARKETDEPTH);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)marketDepth);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBuyVolume()) {		
			out.put(FixTags.BUYVOLUME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)buyVolume);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSellVolume()) {		
			out.put(FixTags.SELLVOLUME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)sellVolume);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasHighPx()) {		
			out.put(FixTags.HIGHPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)highPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLowPx()) {		
			out.put(FixTags.LOWPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lowPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastPx()) {		
			out.put(FixTags.LASTPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)lastPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAdjustment()) {		
			out.put(FixTags.ADJUSTMENT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)adjustment);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasFirstPx()) {		
			out.put(FixTags.FIRSTPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)firstPx);
		
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
		instrument.encode(out);
		instrumentExtension.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(instrmtLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) if (fixInstrmtLegGrp.hasGroup()) fixInstrmtLegGrp.encode(out);
		
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
		
		if (hasSecurityStatusReqID()) {		
			FixUtils.put(out,securityStatusReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketID()) {		
			FixUtils.put(out,marketID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketSegmentID()) {		
			FixUtils.put(out,marketSegmentID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionID()) {		
			FixUtils.put(out,tradingSessionID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionSubID()) {		
			FixUtils.put(out,tradingSessionSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnsolicitedIndicator()) {		
			out.put(unsolicitedIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityTradingStatus()) {		
			FixUtils.put(out, (long)securityTradingStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityTradingEvent()) {		
			FixUtils.put(out, (long)securityTradingEvent);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFinancialStatus()) {		
			FixUtils.put(out,financialStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCorporateAction()) {		
			FixUtils.put(out,corporateAction); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHaltReason()) {		
			FixUtils.put(out, (long)haltReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasInViewOfCommon()) {		
			out.put(inViewOfCommon?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDueToRelated()) {		
			out.put(dueToRelated?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDBookType()) {		
			FixUtils.put(out, (long)mDBookType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketDepth()) {		
			FixUtils.put(out, (long)marketDepth);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBuyVolume()) {		
			FixUtils.put(out, (long)buyVolume);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSellVolume()) {		
			FixUtils.put(out, (long)sellVolume);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHighPx()) {		
			FixUtils.put(out, (long)highPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLowPx()) {		
			FixUtils.put(out, (long)lowPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastPx()) {		
			FixUtils.put(out, (long)lastPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAdjustment()) {		
			FixUtils.put(out, (long)adjustment);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFirstPx()) {		
			FixUtils.put(out, (long)firstPx);
		
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
			
	public void crackSecurityStatusReqID() {		
		getSecurityStatusReqID();		
	}		
			
	public byte[] getSecurityStatusReqID() { 		
		if ( hasSecurityStatusReqID()) {		
			if (hasSecurityStatusReqID == FixUtils.TAG_HAS_VALUE) {		
				return securityStatusReqID; 		
			} else {

				buf.position(hasSecurityStatusReqID);

			FixUtils.getTagStringValue(buf, securityStatusReqID, 0, securityStatusReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecurityStatusReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityStatusReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityStatusReqID() { return hasSecurityStatusReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityStatusReqID(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityStatusReqID()) FixUtils.fillNul(securityStatusReqID);		
		FixUtils.copy(securityStatusReqID, src); 		
		hasSecurityStatusReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityStatusReqID(String str) {		
		if (str == null ) return;
		if (hasSecurityStatusReqID()) FixUtils.fillNul(securityStatusReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityStatusReqID, src); 		
		hasSecurityStatusReqID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackMarketID() {		
		getMarketID();		
	}		
			
	public byte[] getMarketID() { 		
		if ( hasMarketID()) {		
			if (hasMarketID == FixUtils.TAG_HAS_VALUE) {		
				return marketID; 		
			} else {

				buf.position(hasMarketID);

			FixUtils.getTagStringValue(buf, marketID, 0, marketID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMarketID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return marketID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMarketID() { return hasMarketID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMarketID(byte[] src) {		
		if (src == null ) return;
		if (hasMarketID()) FixUtils.fillNul(marketID);		
		FixUtils.copy(marketID, src); 		
		hasMarketID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketID(String str) {		
		if (str == null ) return;
		if (hasMarketID()) FixUtils.fillNul(marketID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketID, src); 		
		hasMarketID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMarketSegmentID() {		
		getMarketSegmentID();		
	}		
			
	public byte[] getMarketSegmentID() { 		
		if ( hasMarketSegmentID()) {		
			if (hasMarketSegmentID == FixUtils.TAG_HAS_VALUE) {		
				return marketSegmentID; 		
			} else {

				buf.position(hasMarketSegmentID);

			FixUtils.getTagStringValue(buf, marketSegmentID, 0, marketSegmentID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return marketSegmentID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMarketSegmentID() { return hasMarketSegmentID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMarketSegmentID(byte[] src) {		
		if (src == null ) return;
		if (hasMarketSegmentID()) FixUtils.fillNul(marketSegmentID);		
		FixUtils.copy(marketSegmentID, src); 		
		hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketSegmentID(String str) {		
		if (str == null ) return;
		if (hasMarketSegmentID()) FixUtils.fillNul(marketSegmentID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketSegmentID, src); 		
		hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradingSessionID() {		
		getTradingSessionID();		
	}		
			
	public byte[] getTradingSessionID() { 		
		if ( hasTradingSessionID()) {		
			if (hasTradingSessionID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionID; 		
			} else {

				buf.position(hasTradingSessionID);

			FixUtils.getTagStringValue(buf, tradingSessionID, 0, tradingSessionID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradingSessionID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionID() { return hasTradingSessionID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradingSessionID(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionID()) FixUtils.fillNul(tradingSessionID);		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradingSessionID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionID()) FixUtils.fillNul(tradingSessionID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradingSessionSubID() {		
		getTradingSessionSubID();		
	}		
			
	public byte[] getTradingSessionSubID() { 		
		if ( hasTradingSessionSubID()) {		
			if (hasTradingSessionSubID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionSubID; 		
			} else {

				buf.position(hasTradingSessionSubID);

			FixUtils.getTagStringValue(buf, tradingSessionSubID, 0, tradingSessionSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradingSessionSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionSubID() { return hasTradingSessionSubID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradingSessionSubID(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillNul(tradingSessionSubID);		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradingSessionSubID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillNul(tradingSessionSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackSecurityTradingStatus() {		
		getSecurityTradingStatus();		
	}		
			
	public long getSecurityTradingStatus() { 		
		if ( hasSecurityTradingStatus()) {		
			if (hasSecurityTradingStatus == FixUtils.TAG_HAS_VALUE) {		
				return securityTradingStatus; 		
			} else {

				buf.position(hasSecurityTradingStatus);

			securityTradingStatus = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSecurityTradingStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityTradingStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecurityTradingStatus() { return hasSecurityTradingStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityTradingStatus(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityTradingStatus()) securityTradingStatus = FixUtils.TAG_HAS_NO_VALUE;		
		securityTradingStatus = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityTradingStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityTradingStatus(long src) {		
		securityTradingStatus = src;
		hasSecurityTradingStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityTradingStatus(String str) {		
		if (str == null ) return;
		if (hasSecurityTradingStatus()) securityTradingStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		securityTradingStatus = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityTradingStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityTradingEvent() {		
		getSecurityTradingEvent();		
	}		
			
	public long getSecurityTradingEvent() { 		
		if ( hasSecurityTradingEvent()) {		
			if (hasSecurityTradingEvent == FixUtils.TAG_HAS_VALUE) {		
				return securityTradingEvent; 		
			} else {

				buf.position(hasSecurityTradingEvent);

			securityTradingEvent = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSecurityTradingEvent = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityTradingEvent;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecurityTradingEvent() { return hasSecurityTradingEvent != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityTradingEvent(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityTradingEvent()) securityTradingEvent = FixUtils.TAG_HAS_NO_VALUE;		
		securityTradingEvent = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityTradingEvent = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityTradingEvent(long src) {		
		securityTradingEvent = src;
		hasSecurityTradingEvent = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityTradingEvent(String str) {		
		if (str == null ) return;
		if (hasSecurityTradingEvent()) securityTradingEvent = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		securityTradingEvent = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityTradingEvent = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackFinancialStatus() {		
		getFinancialStatus();		
	}		
			
	public byte[] getFinancialStatus() { 		
		if ( hasFinancialStatus()) {		
			if (hasFinancialStatus == FixUtils.TAG_HAS_VALUE) {		
				return financialStatus; 		
			} else {

				buf.position(hasFinancialStatus);

			FixUtils.getTagStringValue(buf, financialStatus, 0, financialStatus.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasFinancialStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return financialStatus;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasFinancialStatus() { return hasFinancialStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setFinancialStatus(byte[] src) {		
		if (src == null ) return;
		if (hasFinancialStatus()) FixUtils.fillNul(financialStatus);		
		FixUtils.copy(financialStatus, src); 		
		hasFinancialStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFinancialStatus(String str) {		
		if (str == null ) return;
		if (hasFinancialStatus()) FixUtils.fillNul(financialStatus);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(financialStatus, src); 		
		hasFinancialStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCorporateAction() {		
		getCorporateAction();		
	}		
			
	public byte[] getCorporateAction() { 		
		if ( hasCorporateAction()) {		
			if (hasCorporateAction == FixUtils.TAG_HAS_VALUE) {		
				return corporateAction; 		
			} else {

				buf.position(hasCorporateAction);

			FixUtils.getTagStringValue(buf, corporateAction, 0, corporateAction.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCorporateAction = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return corporateAction;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCorporateAction() { return hasCorporateAction != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCorporateAction(byte[] src) {		
		if (src == null ) return;
		if (hasCorporateAction()) FixUtils.fillNul(corporateAction);		
		FixUtils.copy(corporateAction, src); 		
		hasCorporateAction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCorporateAction(String str) {		
		if (str == null ) return;
		if (hasCorporateAction()) FixUtils.fillNul(corporateAction);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(corporateAction, src); 		
		hasCorporateAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackHaltReason() {		
		getHaltReason();		
	}		
			
	public long getHaltReason() { 		
		if ( hasHaltReason()) {		
			if (hasHaltReason == FixUtils.TAG_HAS_VALUE) {		
				return haltReason; 		
			} else {

				buf.position(hasHaltReason);

			haltReason = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasHaltReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return haltReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasHaltReason() { return hasHaltReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setHaltReason(byte[] src) {		
		if (src == null ) return;
		if (hasHaltReason()) haltReason = FixUtils.TAG_HAS_NO_VALUE;		
		haltReason = FixUtils.longValueOf(src, 0, src.length);
		hasHaltReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHaltReason(long src) {		
		haltReason = src;
		hasHaltReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHaltReason(String str) {		
		if (str == null ) return;
		if (hasHaltReason()) haltReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		haltReason = FixUtils.longValueOf(src, 0, src.length);
		hasHaltReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackInViewOfCommon() {		
		getInViewOfCommon();		
	}		
			
	public boolean getInViewOfCommon() { 		
		if ( hasInViewOfCommon()) {		
			if (hasInViewOfCommon == FixUtils.TAG_HAS_VALUE) {		
				return inViewOfCommon; 		
			} else {

				buf.position(hasInViewOfCommon);

			inViewOfCommon = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasInViewOfCommon = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return inViewOfCommon;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasInViewOfCommon() { return hasInViewOfCommon != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setInViewOfCommon(byte[] src) {		
		if (src == null ) return;
		if (hasInViewOfCommon()) inViewOfCommon = false;		
		inViewOfCommon = src[0]==(byte)'Y'?true:false;		
		hasInViewOfCommon = FixUtils.TAG_HAS_VALUE;		
	}

	public void setInViewOfCommon(boolean src) {		
		inViewOfCommon = src;
		hasInViewOfCommon = FixUtils.TAG_HAS_VALUE;		
	}

	public void setInViewOfCommon(String str) {		
		if (str == null ) return;
		if (hasInViewOfCommon()) inViewOfCommon = false;		
		byte[] src = str.getBytes(); 		
		inViewOfCommon = src[0]==(byte)'Y'?true:false;		
		hasInViewOfCommon = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDueToRelated() {		
		getDueToRelated();		
	}		
			
	public boolean getDueToRelated() { 		
		if ( hasDueToRelated()) {		
			if (hasDueToRelated == FixUtils.TAG_HAS_VALUE) {		
				return dueToRelated; 		
			} else {

				buf.position(hasDueToRelated);

			dueToRelated = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasDueToRelated = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return dueToRelated;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasDueToRelated() { return hasDueToRelated != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDueToRelated(byte[] src) {		
		if (src == null ) return;
		if (hasDueToRelated()) dueToRelated = false;		
		dueToRelated = src[0]==(byte)'Y'?true:false;		
		hasDueToRelated = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDueToRelated(boolean src) {		
		dueToRelated = src;
		hasDueToRelated = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDueToRelated(String str) {		
		if (str == null ) return;
		if (hasDueToRelated()) dueToRelated = false;		
		byte[] src = str.getBytes(); 		
		dueToRelated = src[0]==(byte)'Y'?true:false;		
		hasDueToRelated = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMDBookType() {		
		getMDBookType();		
	}		
			
	public long getMDBookType() { 		
		if ( hasMDBookType()) {		
			if (hasMDBookType == FixUtils.TAG_HAS_VALUE) {		
				return mDBookType; 		
			} else {

				buf.position(hasMDBookType);

			mDBookType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMDBookType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return mDBookType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDBookType() { return hasMDBookType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMDBookType(byte[] src) {		
		if (src == null ) return;
		if (hasMDBookType()) mDBookType = FixUtils.TAG_HAS_NO_VALUE;		
		mDBookType = FixUtils.longValueOf(src, 0, src.length);
		hasMDBookType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDBookType(long src) {		
		mDBookType = src;
		hasMDBookType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDBookType(String str) {		
		if (str == null ) return;
		if (hasMDBookType()) mDBookType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDBookType = FixUtils.longValueOf(src, 0, src.length);
		hasMDBookType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMarketDepth() {		
		getMarketDepth();		
	}		
			
	public long getMarketDepth() { 		
		if ( hasMarketDepth()) {		
			if (hasMarketDepth == FixUtils.TAG_HAS_VALUE) {		
				return marketDepth; 		
			} else {

				buf.position(hasMarketDepth);

			marketDepth = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMarketDepth = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return marketDepth;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMarketDepth() { return hasMarketDepth != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMarketDepth(byte[] src) {		
		if (src == null ) return;
		if (hasMarketDepth()) marketDepth = FixUtils.TAG_HAS_NO_VALUE;		
		marketDepth = FixUtils.longValueOf(src, 0, src.length);
		hasMarketDepth = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketDepth(long src) {		
		marketDepth = src;
		hasMarketDepth = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketDepth(String str) {		
		if (str == null ) return;
		if (hasMarketDepth()) marketDepth = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		marketDepth = FixUtils.longValueOf(src, 0, src.length);
		hasMarketDepth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBuyVolume() {		
		getBuyVolume();		
	}		
			
	public long getBuyVolume() { 		
		if ( hasBuyVolume()) {		
			if (hasBuyVolume == FixUtils.TAG_HAS_VALUE) {		
				return buyVolume; 		
			} else {

				buf.position(hasBuyVolume);

			buyVolume = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBuyVolume = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return buyVolume;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBuyVolume() { return hasBuyVolume != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBuyVolume(byte[] src) {		
		if (src == null ) return;
		if (hasBuyVolume()) buyVolume = FixUtils.TAG_HAS_NO_VALUE;		
		buyVolume = FixUtils.longValueOf(src, 0, src.length);
		hasBuyVolume = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBuyVolume(long src) {		
		buyVolume = src;
		hasBuyVolume = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBuyVolume(String str) {		
		if (str == null ) return;
		if (hasBuyVolume()) buyVolume = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		buyVolume = FixUtils.longValueOf(src, 0, src.length);
		hasBuyVolume = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSellVolume() {		
		getSellVolume();		
	}		
			
	public long getSellVolume() { 		
		if ( hasSellVolume()) {		
			if (hasSellVolume == FixUtils.TAG_HAS_VALUE) {		
				return sellVolume; 		
			} else {

				buf.position(hasSellVolume);

			sellVolume = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSellVolume = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return sellVolume;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSellVolume() { return hasSellVolume != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSellVolume(byte[] src) {		
		if (src == null ) return;
		if (hasSellVolume()) sellVolume = FixUtils.TAG_HAS_NO_VALUE;		
		sellVolume = FixUtils.longValueOf(src, 0, src.length);
		hasSellVolume = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSellVolume(long src) {		
		sellVolume = src;
		hasSellVolume = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSellVolume(String str) {		
		if (str == null ) return;
		if (hasSellVolume()) sellVolume = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sellVolume = FixUtils.longValueOf(src, 0, src.length);
		hasSellVolume = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackHighPx() {		
		getHighPx();		
	}		
			
	public long getHighPx() { 		
		if ( hasHighPx()) {		
			if (hasHighPx == FixUtils.TAG_HAS_VALUE) {		
				return highPx; 		
			} else {

				buf.position(hasHighPx);

			highPx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasHighPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return highPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasHighPx() { return hasHighPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setHighPx(byte[] src) {		
		if (src == null ) return;
		if (hasHighPx()) highPx = FixUtils.TAG_HAS_NO_VALUE;		
		highPx = FixUtils.longValueOf(src, 0, src.length);
		hasHighPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHighPx(long src) {		
		highPx = src;
		hasHighPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHighPx(String str) {		
		if (str == null ) return;
		if (hasHighPx()) highPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		highPx = FixUtils.longValueOf(src, 0, src.length);
		hasHighPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLowPx() {		
		getLowPx();		
	}		
			
	public long getLowPx() { 		
		if ( hasLowPx()) {		
			if (hasLowPx == FixUtils.TAG_HAS_VALUE) {		
				return lowPx; 		
			} else {

				buf.position(hasLowPx);

			lowPx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLowPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lowPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLowPx() { return hasLowPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLowPx(byte[] src) {		
		if (src == null ) return;
		if (hasLowPx()) lowPx = FixUtils.TAG_HAS_NO_VALUE;		
		lowPx = FixUtils.longValueOf(src, 0, src.length);
		hasLowPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLowPx(long src) {		
		lowPx = src;
		hasLowPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLowPx(String str) {		
		if (str == null ) return;
		if (hasLowPx()) lowPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lowPx = FixUtils.longValueOf(src, 0, src.length);
		hasLowPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastPx() {		
		getLastPx();		
	}		
			
	public long getLastPx() { 		
		if ( hasLastPx()) {		
			if (hasLastPx == FixUtils.TAG_HAS_VALUE) {		
				return lastPx; 		
			} else {

				buf.position(hasLastPx);

			lastPx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLastPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastPx() { return hasLastPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastPx(byte[] src) {		
		if (src == null ) return;
		if (hasLastPx()) lastPx = FixUtils.TAG_HAS_NO_VALUE;		
		lastPx = FixUtils.longValueOf(src, 0, src.length);
		hasLastPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastPx(long src) {		
		lastPx = src;
		hasLastPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastPx(String str) {		
		if (str == null ) return;
		if (hasLastPx()) lastPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastPx = FixUtils.longValueOf(src, 0, src.length);
		hasLastPx = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackAdjustment() {		
		getAdjustment();		
	}		
			
	public long getAdjustment() { 		
		if ( hasAdjustment()) {		
			if (hasAdjustment == FixUtils.TAG_HAS_VALUE) {		
				return adjustment; 		
			} else {

				buf.position(hasAdjustment);

			adjustment = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAdjustment = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return adjustment;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAdjustment() { return hasAdjustment != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAdjustment(byte[] src) {		
		if (src == null ) return;
		if (hasAdjustment()) adjustment = FixUtils.TAG_HAS_NO_VALUE;		
		adjustment = FixUtils.longValueOf(src, 0, src.length);
		hasAdjustment = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAdjustment(long src) {		
		adjustment = src;
		hasAdjustment = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAdjustment(String str) {		
		if (str == null ) return;
		if (hasAdjustment()) adjustment = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		adjustment = FixUtils.longValueOf(src, 0, src.length);
		hasAdjustment = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackFirstPx() {		
		getFirstPx();		
	}		
			
	public long getFirstPx() { 		
		if ( hasFirstPx()) {		
			if (hasFirstPx == FixUtils.TAG_HAS_VALUE) {		
				return firstPx; 		
			} else {

				buf.position(hasFirstPx);

			firstPx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasFirstPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return firstPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasFirstPx() { return hasFirstPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setFirstPx(byte[] src) {		
		if (src == null ) return;
		if (hasFirstPx()) firstPx = FixUtils.TAG_HAS_NO_VALUE;		
		firstPx = FixUtils.longValueOf(src, 0, src.length);
		hasFirstPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFirstPx(long src) {		
		firstPx = src;
		hasFirstPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFirstPx(String str) {		
		if (str == null ) return;
		if (hasFirstPx()) firstPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		firstPx = FixUtils.longValueOf(src, 0, src.length);
		hasFirstPx = FixUtils.TAG_HAS_VALUE;		
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

					if (hasSecurityStatusReqID()) s += "SecurityStatusReqID(324)= " + new String( FixUtils.trim(getSecurityStatusReqID()) ) + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasMarketID()) s += "MarketID(1301)= " + new String( FixUtils.trim(getMarketID()) ) + "\n" ; 
		if (hasMarketSegmentID()) s += "MarketSegmentID(1300)= " + new String( FixUtils.trim(getMarketSegmentID()) ) + "\n" ; 
		if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 
		if (hasUnsolicitedIndicator()) s += "UnsolicitedIndicator(325)= " + getUnsolicitedIndicator() + "\n" ; 
		if (hasSecurityTradingStatus()) s += "SecurityTradingStatus(326)= " + getSecurityTradingStatus() + "\n" ; 
		if (hasSecurityTradingEvent()) s += "SecurityTradingEvent(1174)= " + getSecurityTradingEvent() + "\n" ; 
		if (hasFinancialStatus()) s += "FinancialStatus(291)= " + new String( FixUtils.trim(getFinancialStatus()) ) + "\n" ; 
		if (hasCorporateAction()) s += "CorporateAction(292)= " + new String( FixUtils.trim(getCorporateAction()) ) + "\n" ; 
		if (hasHaltReason()) s += "HaltReason(327)= " + getHaltReason() + "\n" ; 
		if (hasInViewOfCommon()) s += "InViewOfCommon(328)= " + getInViewOfCommon() + "\n" ; 
		if (hasDueToRelated()) s += "DueToRelated(329)= " + getDueToRelated() + "\n" ; 
		if (hasMDBookType()) s += "MDBookType(1021)= " + getMDBookType() + "\n" ; 
		if (hasMarketDepth()) s += "MarketDepth(264)= " + getMarketDepth() + "\n" ; 
		if (hasBuyVolume()) s += "BuyVolume(330)= " + getBuyVolume() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSellVolume()) s += "SellVolume(331)= " + getSellVolume() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasHighPx()) s += "HighPx(332)= " + getHighPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLowPx()) s += "LowPx(333)= " + getLowPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastPx()) s += "LastPx(31)= " + getLastPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasAdjustment()) s += "Adjustment(334)= " + getAdjustment() + "\n" ; 
		if (hasFirstPx()) s += "FirstPx(1025)= " + getFirstPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
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
		if (! ( o instanceof FixSecurityStatus)) return false;

		FixSecurityStatus msg = (FixSecurityStatus) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasSecurityStatusReqID() && !msg.hasSecurityStatusReqID()) || (!hasSecurityStatusReqID() && msg.hasSecurityStatusReqID())) return false;
		if (!(!hasSecurityStatusReqID() && !msg.hasSecurityStatusReqID()) && !FixUtils.equals(getSecurityStatusReqID(), msg.getSecurityStatusReqID())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasMarketID() && !msg.hasMarketID()) || (!hasMarketID() && msg.hasMarketID())) return false;
		if (!(!hasMarketID() && !msg.hasMarketID()) && !FixUtils.equals(getMarketID(), msg.getMarketID())) return false;
		if ((hasMarketSegmentID() && !msg.hasMarketSegmentID()) || (!hasMarketSegmentID() && msg.hasMarketSegmentID())) return false;
		if (!(!hasMarketSegmentID() && !msg.hasMarketSegmentID()) && !FixUtils.equals(getMarketSegmentID(), msg.getMarketSegmentID())) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		if ((hasUnsolicitedIndicator() && !msg.hasUnsolicitedIndicator()) || (!hasUnsolicitedIndicator() && msg.hasUnsolicitedIndicator())) return false;
		if (!(!hasUnsolicitedIndicator() && !msg.hasUnsolicitedIndicator()) && !(getUnsolicitedIndicator()==msg.getUnsolicitedIndicator())) return false;
		if ((hasSecurityTradingStatus() && !msg.hasSecurityTradingStatus()) || (!hasSecurityTradingStatus() && msg.hasSecurityTradingStatus())) return false;
		if (!(!hasSecurityTradingStatus() && !msg.hasSecurityTradingStatus()) && !(getSecurityTradingStatus()==msg.getSecurityTradingStatus())) return false;
		if ((hasSecurityTradingEvent() && !msg.hasSecurityTradingEvent()) || (!hasSecurityTradingEvent() && msg.hasSecurityTradingEvent())) return false;
		if (!(!hasSecurityTradingEvent() && !msg.hasSecurityTradingEvent()) && !(getSecurityTradingEvent()==msg.getSecurityTradingEvent())) return false;
		if ((hasFinancialStatus() && !msg.hasFinancialStatus()) || (!hasFinancialStatus() && msg.hasFinancialStatus())) return false;
		if (!(!hasFinancialStatus() && !msg.hasFinancialStatus()) && !FixUtils.equals(getFinancialStatus(), msg.getFinancialStatus())) return false;
		if ((hasCorporateAction() && !msg.hasCorporateAction()) || (!hasCorporateAction() && msg.hasCorporateAction())) return false;
		if (!(!hasCorporateAction() && !msg.hasCorporateAction()) && !FixUtils.equals(getCorporateAction(), msg.getCorporateAction())) return false;
		if ((hasHaltReason() && !msg.hasHaltReason()) || (!hasHaltReason() && msg.hasHaltReason())) return false;
		if (!(!hasHaltReason() && !msg.hasHaltReason()) && !(getHaltReason()==msg.getHaltReason())) return false;
		if ((hasInViewOfCommon() && !msg.hasInViewOfCommon()) || (!hasInViewOfCommon() && msg.hasInViewOfCommon())) return false;
		if (!(!hasInViewOfCommon() && !msg.hasInViewOfCommon()) && !(getInViewOfCommon()==msg.getInViewOfCommon())) return false;
		if ((hasDueToRelated() && !msg.hasDueToRelated()) || (!hasDueToRelated() && msg.hasDueToRelated())) return false;
		if (!(!hasDueToRelated() && !msg.hasDueToRelated()) && !(getDueToRelated()==msg.getDueToRelated())) return false;
		if ((hasMDBookType() && !msg.hasMDBookType()) || (!hasMDBookType() && msg.hasMDBookType())) return false;
		if (!(!hasMDBookType() && !msg.hasMDBookType()) && !(getMDBookType()==msg.getMDBookType())) return false;
		if ((hasMarketDepth() && !msg.hasMarketDepth()) || (!hasMarketDepth() && msg.hasMarketDepth())) return false;
		if (!(!hasMarketDepth() && !msg.hasMarketDepth()) && !(getMarketDepth()==msg.getMarketDepth())) return false;
		if ((hasBuyVolume() && !msg.hasBuyVolume()) || (!hasBuyVolume() && msg.hasBuyVolume())) return false;
		if (!(!hasBuyVolume() && !msg.hasBuyVolume()) && !(getBuyVolume()==msg.getBuyVolume())) return false;
		if ((hasSellVolume() && !msg.hasSellVolume()) || (!hasSellVolume() && msg.hasSellVolume())) return false;
		if (!(!hasSellVolume() && !msg.hasSellVolume()) && !(getSellVolume()==msg.getSellVolume())) return false;
		if ((hasHighPx() && !msg.hasHighPx()) || (!hasHighPx() && msg.hasHighPx())) return false;
		if (!(!hasHighPx() && !msg.hasHighPx()) && !(getHighPx()==msg.getHighPx())) return false;
		if ((hasLowPx() && !msg.hasLowPx()) || (!hasLowPx() && msg.hasLowPx())) return false;
		if (!(!hasLowPx() && !msg.hasLowPx()) && !(getLowPx()==msg.getLowPx())) return false;
		if ((hasLastPx() && !msg.hasLastPx()) || (!hasLastPx() && msg.hasLastPx())) return false;
		if (!(!hasLastPx() && !msg.hasLastPx()) && !(getLastPx()==msg.getLastPx())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasAdjustment() && !msg.hasAdjustment()) || (!hasAdjustment() && msg.hasAdjustment())) return false;
		if (!(!hasAdjustment() && !msg.hasAdjustment()) && !(getAdjustment()==msg.getAdjustment())) return false;
		if ((hasFirstPx() && !msg.hasFirstPx()) || (!hasFirstPx() && msg.hasFirstPx())) return false;
		if (!(!hasFirstPx() && !msg.hasFirstPx()) && !(getFirstPx()==msg.getFirstPx())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixSecurityStatus clone () {
		FixSecurityStatus out = new FixSecurityStatus();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixSecurityStatus clone ( FixSecurityStatus out ) {
		if ( hasSecurityStatusReqID())
			out.setSecurityStatusReqID(getSecurityStatusReqID());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasMarketID())
			out.setMarketID(getMarketID());
		if ( hasMarketSegmentID())
			out.setMarketSegmentID(getMarketSegmentID());
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		if ( hasUnsolicitedIndicator())
			out.setUnsolicitedIndicator(getUnsolicitedIndicator());
		if ( hasSecurityTradingStatus())
			out.setSecurityTradingStatus(getSecurityTradingStatus());
		if ( hasSecurityTradingEvent())
			out.setSecurityTradingEvent(getSecurityTradingEvent());
		if ( hasFinancialStatus())
			out.setFinancialStatus(getFinancialStatus());
		if ( hasCorporateAction())
			out.setCorporateAction(getCorporateAction());
		if ( hasHaltReason())
			out.setHaltReason(getHaltReason());
		if ( hasInViewOfCommon())
			out.setInViewOfCommon(getInViewOfCommon());
		if ( hasDueToRelated())
			out.setDueToRelated(getDueToRelated());
		if ( hasMDBookType())
			out.setMDBookType(getMDBookType());
		if ( hasMarketDepth())
			out.setMarketDepth(getMarketDepth());
		if ( hasBuyVolume())
			out.setBuyVolume(getBuyVolume());
		if ( hasSellVolume())
			out.setSellVolume(getSellVolume());
		if ( hasHighPx())
			out.setHighPx(getHighPx());
		if ( hasLowPx())
			out.setLowPx(getLowPx());
		if ( hasLastPx())
			out.setLastPx(getLastPx());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasAdjustment())
			out.setAdjustment(getAdjustment());
		if ( hasFirstPx())
			out.setFirstPx(getFirstPx());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		if (instrumentExtension.hasGroup())
			out.instrumentExtension = instrumentExtension.clone( out.instrumentExtension);
		int count = 0;
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		count = 0;
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) {
			if (!fixInstrmtLegGrp.hasGroup()) continue;
			out.instrmtLegGrp[count] = fixInstrmtLegGrp.clone( out.instrmtLegGrp[count] );
			count++;
		}
		return out;
	}

}
