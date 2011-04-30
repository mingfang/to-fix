package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixOrderMassCancelReport extends FixInMessage {
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryClOrdID;
	byte[] secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderID;
	byte[] orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMassActionReportID;
	byte[] massActionReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryOrderID;
	byte[] secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMassCancelRequestType;
	byte massCancelRequestType = (byte)' ';		
	private short hasMassCancelResponse;
	byte massCancelResponse = (byte)' ';		
	private short hasMassCancelRejectReason;
	long massCancelRejectReason = 0;		
	private short hasTotalAffectedOrders;
	long totalAffectedOrders = 0;		
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketID;
	byte[] marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketSegmentID;
	byte[] marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixAffectedOrdGrp[] affectedOrdGrp;
	public FixNotAffectedOrdersGrp[] notAffectedOrdersGrp;
	public FixParties[] parties;
	public FixTargetParties[] targetParties;
	public FixInstrument instrument;
	public FixUnderlyingInstrument underlyingInstrument;
	
	public FixOrderMassCancelReport() {
		super(FixMessageInfo.MessageTypes.ORDERMASSCANCELREPORT);


		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMassActionReportID = FixUtils.TAG_HAS_NO_VALUE;		
		massActionReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMassCancelRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMassCancelResponse = FixUtils.TAG_HAS_NO_VALUE;		
		hasMassCancelRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotalAffectedOrders = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketID = FixUtils.TAG_HAS_NO_VALUE;		
		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketSegmentID = FixUtils.TAG_HAS_NO_VALUE;		
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		affectedOrdGrp = new FixAffectedOrdGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) affectedOrdGrp[i] = new FixAffectedOrdGrp();
		notAffectedOrdersGrp = new FixNotAffectedOrdersGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) notAffectedOrdersGrp[i] = new FixNotAffectedOrdersGrp();
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		targetParties = new FixTargetParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) targetParties[i] = new FixTargetParties();
		instrument = new FixInstrument();
		underlyingInstrument = new FixUnderlyingInstrument();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYCLORDID_INT:		
            		hasSecondaryClOrdID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ORDERID_INT:		
            		hasOrderID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MASSACTIONREPORTID_INT:		
            		hasMassActionReportID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYORDERID_INT:		
            		hasSecondaryOrderID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MASSCANCELREQUESTTYPE_INT:		
            		hasMassCancelRequestType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MASSCANCELRESPONSE_INT:		
            		hasMassCancelResponse = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MASSCANCELREJECTREASON_INT:		
            		hasMassCancelRejectReason = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TOTALAFFECTEDORDERS_INT:		
            		hasTotalAffectedOrders = (short) buf.position();		
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
            	case FixTags.MARKETID_INT:		
            		hasMarketID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MARKETSEGMENTID_INT:		
            		hasMarketSegmentID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
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
        				if (!err.hasError()) hasRequiredTags(err);
            			return; // always last, we are done now
        			} else if ( tag == FixTags.NOAFFECTEDORDERS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !affectedOrdGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOAFFECTEDORDERS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = affectedOrdGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NONOTAFFECTEDORDERS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !notAffectedOrdersGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NONOTAFFECTEDORDERS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = notAffectedOrdersGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
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
        			} else if ( tag == FixTags.NOTARGETPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !targetParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOTARGETPARTYIDS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = targetParties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( underlyingInstrument.isKeyTag(tag)) {
        				tag = underlyingInstrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.ORDERMASSCANCELREPORT_INT);
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
		if (!hasOrderID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.ORDERID_INT, FixMessageInfo.MessageTypes.ORDERMASSCANCELREPORT_INT);
			return false;
		}
		if (!hasMassActionReportID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.MASSACTIONREPORTID_INT, FixMessageInfo.MessageTypes.ORDERMASSCANCELREPORT_INT);
			return false;
		}
		if (!hasMassCancelRequestType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.MASSCANCELREQUESTTYPE_INT, FixMessageInfo.MessageTypes.ORDERMASSCANCELREPORT_INT);
			return false;
		}
		if (!hasMassCancelResponse()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.MASSCANCELRESPONSE_INT, FixMessageInfo.MessageTypes.ORDERMASSCANCELREPORT_INT);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		getClOrdID();		
		getSecondaryClOrdID();		
		getOrderID();		
		getMassActionReportID();		
		getSecondaryOrderID();		
		getMassCancelRequestType();		
		getMassCancelResponse();		
		getMassCancelRejectReason();		
		getTotalAffectedOrders();		
		getTradingSessionID();		
		getTradingSessionSubID();		
		getMarketID();		
		getMarketSegmentID();		
		getSide();		
		getTransactTime();		
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
		if (hasOrderID()) {		
			out.put(FixTags.ORDERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMassActionReportID()) {		
			out.put(FixTags.MASSACTIONREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,massActionReportID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryOrderID()) {		
			out.put(FixTags.SECONDARYORDERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryOrderID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMassCancelRequestType()) {		
			out.put(FixTags.MASSCANCELREQUESTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,massCancelRequestType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMassCancelResponse()) {		
			out.put(FixTags.MASSCANCELRESPONSE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,massCancelResponse); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMassCancelRejectReason()) {		
			out.put(FixTags.MASSCANCELREJECTREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)massCancelRejectReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotalAffectedOrders()) {		
			out.put(FixTags.TOTALAFFECTEDORDERS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totalAffectedOrders);
		
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
		if (hasSide()) {		
			out.put(FixTags.SIDE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
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
		
		if (FixUtils.getNoInGroup(affectedOrdGrp)>0) {
			out.put(FixTags.NOAFFECTEDORDERS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(affectedOrdGrp));

			out.put(FixUtils.SOH);

		}
		for (FixAffectedOrdGrp fixAffectedOrdGrp : affectedOrdGrp) if (fixAffectedOrdGrp.hasGroup()) fixAffectedOrdGrp.encode(out);
		if (FixUtils.getNoInGroup(notAffectedOrdersGrp)>0) {
			out.put(FixTags.NONOTAFFECTEDORDERS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(notAffectedOrdersGrp));

			out.put(FixUtils.SOH);

		}
		for (FixNotAffectedOrdersGrp fixNotAffectedOrdersGrp : notAffectedOrdersGrp) if (fixNotAffectedOrdersGrp.hasGroup()) fixNotAffectedOrdersGrp.encode(out);
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(targetParties)>0) {
			out.put(FixTags.NOTARGETPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(targetParties));

			out.put(FixUtils.SOH);

		}
		for (FixTargetParties fixTargetParties : targetParties) if (fixTargetParties.hasGroup()) fixTargetParties.encode(out);
		instrument.encode(out);
		underlyingInstrument.encode(out);
		
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
		FixUtils.fill(tmpCheckSum, (byte)'0');
		FixUtils.generateCheckSum(tmpCheckSum, out, startPos + FixUtils.FIX_MESSAGE_START, endPos);
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
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryClOrdID()) {		
			FixUtils.put(out,secondaryClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderID()) {		
			FixUtils.put(out,orderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMassActionReportID()) {		
			FixUtils.put(out,massActionReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryOrderID()) {		
			FixUtils.put(out,secondaryOrderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMassCancelRequestType()) {		
			FixUtils.put(out,massCancelRequestType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMassCancelResponse()) {		
			FixUtils.put(out,massCancelResponse); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMassCancelRejectReason()) {		
			FixUtils.put(out, (long)massCancelRejectReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotalAffectedOrders()) {		
			FixUtils.put(out, (long)totalAffectedOrders);
		
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
		
		if (hasMarketID()) {		
			FixUtils.put(out,marketID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketSegmentID()) {		
			FixUtils.put(out,marketSegmentID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
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
			
	public void crackClOrdID() {		
		getClOrdID();		
	}		
			
	public byte[] getClOrdID() { 		
		if ( hasClOrdID()) {		
			if (hasClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return clOrdID; 		
			} else {

				buf.position(hasClOrdID);

			FixUtils.getTagStringValue(buf, clOrdID, 0, clOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClOrdID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
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
			
	public void crackSecondaryClOrdID() {		
		getSecondaryClOrdID();		
	}		
			
	public byte[] getSecondaryClOrdID() { 		
		if ( hasSecondaryClOrdID()) {		
			if (hasSecondaryClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryClOrdID; 		
			} else {

				buf.position(hasSecondaryClOrdID);

			FixUtils.getTagStringValue(buf, secondaryClOrdID, 0, secondaryClOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
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
			
	public void crackOrderID() {		
		getOrderID();		
	}		
			
	public byte[] getOrderID() { 		
		if ( hasOrderID()) {		
			if (hasOrderID == FixUtils.TAG_HAS_VALUE) {		
				return orderID; 		
			} else {

				buf.position(hasOrderID);

			FixUtils.getTagStringValue(buf, orderID, 0, orderID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrderID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderID() { return hasOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasOrderID()) FixUtils.fillNul(orderID);		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderID(String str) {		
		if (str == null ) return;
		if (hasOrderID()) FixUtils.fillNul(orderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMassActionReportID() {		
		getMassActionReportID();		
	}		
			
	public byte[] getMassActionReportID() { 		
		if ( hasMassActionReportID()) {		
			if (hasMassActionReportID == FixUtils.TAG_HAS_VALUE) {		
				return massActionReportID; 		
			} else {

				buf.position(hasMassActionReportID);

			FixUtils.getTagStringValue(buf, massActionReportID, 0, massActionReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMassActionReportID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return massActionReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMassActionReportID() { return hasMassActionReportID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMassActionReportID(byte[] src) {		
		if (src == null ) return;
		if (hasMassActionReportID()) FixUtils.fillNul(massActionReportID);		
		FixUtils.copy(massActionReportID, src); 		
		hasMassActionReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMassActionReportID(String str) {		
		if (str == null ) return;
		if (hasMassActionReportID()) FixUtils.fillNul(massActionReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(massActionReportID, src); 		
		hasMassActionReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryOrderID() {		
		getSecondaryOrderID();		
	}		
			
	public byte[] getSecondaryOrderID() { 		
		if ( hasSecondaryOrderID()) {		
			if (hasSecondaryOrderID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryOrderID; 		
			} else {

				buf.position(hasSecondaryOrderID);

			FixUtils.getTagStringValue(buf, secondaryOrderID, 0, secondaryOrderID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryOrderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryOrderID() { return hasSecondaryOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryOrderID()) FixUtils.fillNul(secondaryOrderID);		
		FixUtils.copy(secondaryOrderID, src); 		
		hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryOrderID(String str) {		
		if (str == null ) return;
		if (hasSecondaryOrderID()) FixUtils.fillNul(secondaryOrderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryOrderID, src); 		
		hasSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMassCancelRequestType() {		
		getMassCancelRequestType();		
	}		
			
	public byte getMassCancelRequestType() { 		
		if ( hasMassCancelRequestType()) {		
			if (hasMassCancelRequestType == FixUtils.TAG_HAS_VALUE) {		
				return massCancelRequestType; 		
			} else {

				buf.position(hasMassCancelRequestType);

			massCancelRequestType = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (massCancelRequestType != (byte)'3') && (massCancelRequestType != (byte)'2') && (massCancelRequestType != (byte)'1') && (massCancelRequestType != (byte)'7') && (massCancelRequestType != (byte)'A') && (massCancelRequestType != (byte)'6') && (massCancelRequestType != (byte)'B') && (massCancelRequestType != (byte)'5') && (massCancelRequestType != (byte)'C') && (massCancelRequestType != (byte)'4') && (massCancelRequestType != (byte)'9') && (massCancelRequestType != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 530);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasMassCancelRequestType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return massCancelRequestType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMassCancelRequestType() { return hasMassCancelRequestType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMassCancelRequestType(byte[] src) {		
		if (src == null ) return;
		if (hasMassCancelRequestType()) massCancelRequestType = (byte)' ';		
		massCancelRequestType = src[0];		
		hasMassCancelRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMassCancelRequestType(byte src) {		
		massCancelRequestType = src;
		hasMassCancelRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMassCancelRequestType(String str) {		
		if (str == null ) return;
		if (hasMassCancelRequestType()) massCancelRequestType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		massCancelRequestType = src[0];		
		hasMassCancelRequestType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMassCancelResponse() {		
		getMassCancelResponse();		
	}		
			
	public byte getMassCancelResponse() { 		
		if ( hasMassCancelResponse()) {		
			if (hasMassCancelResponse == FixUtils.TAG_HAS_VALUE) {		
				return massCancelResponse; 		
			} else {

				buf.position(hasMassCancelResponse);

			massCancelResponse = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (massCancelResponse != (byte)'A') && (massCancelResponse != (byte)'B') && (massCancelResponse != (byte)'C') && (massCancelResponse != (byte)'3') && (massCancelResponse != (byte)'2') && (massCancelResponse != (byte)'1') && (massCancelResponse != (byte)'0') && (massCancelResponse != (byte)'7') && (massCancelResponse != (byte)'6') && (massCancelResponse != (byte)'5') && (massCancelResponse != (byte)'4') && (massCancelResponse != (byte)'9') && (massCancelResponse != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 531);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasMassCancelResponse = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return massCancelResponse;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMassCancelResponse() { return hasMassCancelResponse != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMassCancelResponse(byte[] src) {		
		if (src == null ) return;
		if (hasMassCancelResponse()) massCancelResponse = (byte)' ';		
		massCancelResponse = src[0];		
		hasMassCancelResponse = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMassCancelResponse(byte src) {		
		massCancelResponse = src;
		hasMassCancelResponse = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMassCancelResponse(String str) {		
		if (str == null ) return;
		if (hasMassCancelResponse()) massCancelResponse = (byte)' ';		
		byte[] src = str.getBytes(); 		
		massCancelResponse = src[0];		
		hasMassCancelResponse = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMassCancelRejectReason() {		
		getMassCancelRejectReason();		
	}		
			
	public long getMassCancelRejectReason() { 		
		if ( hasMassCancelRejectReason()) {		
			if (hasMassCancelRejectReason == FixUtils.TAG_HAS_VALUE) {		
				return massCancelRejectReason; 		
			} else {

				buf.position(hasMassCancelRejectReason);

			massCancelRejectReason = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMassCancelRejectReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return massCancelRejectReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMassCancelRejectReason() { return hasMassCancelRejectReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMassCancelRejectReason(byte[] src) {		
		if (src == null ) return;
		if (hasMassCancelRejectReason()) massCancelRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		massCancelRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasMassCancelRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMassCancelRejectReason(long src) {		
		massCancelRejectReason = src;
		hasMassCancelRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMassCancelRejectReason(String str) {		
		if (str == null ) return;
		if (hasMassCancelRejectReason()) massCancelRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		massCancelRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasMassCancelRejectReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTotalAffectedOrders() {		
		getTotalAffectedOrders();		
	}		
			
	public long getTotalAffectedOrders() { 		
		if ( hasTotalAffectedOrders()) {		
			if (hasTotalAffectedOrders == FixUtils.TAG_HAS_VALUE) {		
				return totalAffectedOrders; 		
			} else {

				buf.position(hasTotalAffectedOrders);

			totalAffectedOrders = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotalAffectedOrders = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totalAffectedOrders;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotalAffectedOrders() { return hasTotalAffectedOrders != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotalAffectedOrders(byte[] src) {		
		if (src == null ) return;
		if (hasTotalAffectedOrders()) totalAffectedOrders = FixUtils.TAG_HAS_NO_VALUE;		
		totalAffectedOrders = FixUtils.longValueOf(src, 0, src.length);
		hasTotalAffectedOrders = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotalAffectedOrders(long src) {		
		totalAffectedOrders = src;
		hasTotalAffectedOrders = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotalAffectedOrders(String str) {		
		if (str == null ) return;
		if (hasTotalAffectedOrders()) totalAffectedOrders = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totalAffectedOrders = FixUtils.longValueOf(src, 0, src.length);
		hasTotalAffectedOrders = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackSide() {		
		getSide();		
	}		
			
	public byte getSide() { 		
		if ( hasSide()) {		
			if (hasSide == FixUtils.TAG_HAS_VALUE) {		
				return side; 		
			} else {

				buf.position(hasSide);

			side = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (side != (byte)'D') && (side != (byte)'E') && (side != (byte)'F') && (side != (byte)'G') && (side != (byte)'A') && (side != (byte)'B') && (side != (byte)'C') && (side != (byte)'3') && (side != (byte)'2') && (side != (byte)'1') && (side != (byte)'7') && (side != (byte)'6') && (side != (byte)'5') && (side != (byte)'4') && (side != (byte)'9') && (side != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 54);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasSide = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return side;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSide() { return hasSide != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSide(byte[] src) {		
		if (src == null ) return;
		if (hasSide()) side = (byte)' ';		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(byte src) {		
		side = src;
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(String str) {		
		if (str == null ) return;
		if (hasSide()) side = (byte)' ';		
		byte[] src = str.getBytes(); 		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
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

					if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasSecondaryClOrdID()) s += "SecondaryClOrdID(526)= " + new String( FixUtils.trim(getSecondaryClOrdID()) ) + "\n" ; 
		if (hasOrderID()) s += "OrderID(37)= " + new String( FixUtils.trim(getOrderID()) ) + "\n" ; 
		if (hasMassActionReportID()) s += "MassActionReportID(1369)= " + new String( FixUtils.trim(getMassActionReportID()) ) + "\n" ; 
		if (hasSecondaryOrderID()) s += "SecondaryOrderID(198)= " + new String( FixUtils.trim(getSecondaryOrderID()) ) + "\n" ; 
		if (hasMassCancelRequestType()) s += "MassCancelRequestType(530)= " + getMassCancelRequestType() + "\n" ; 
		if (hasMassCancelResponse()) s += "MassCancelResponse(531)= " + getMassCancelResponse() + "\n" ; 
		if (hasMassCancelRejectReason()) s += "MassCancelRejectReason(532)= " + getMassCancelRejectReason() + "\n" ; 
		if (hasTotalAffectedOrders()) s += "TotalAffectedOrders(533)= " + getTotalAffectedOrders() + "\n" ; 
		if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 
		if (hasMarketID()) s += "MarketID(1301)= " + new String( FixUtils.trim(getMarketID()) ) + "\n" ; 
		if (hasMarketSegmentID()) s += "MarketSegmentID(1300)= " + new String( FixUtils.trim(getMarketSegmentID()) ) + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
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
		if (! ( o instanceof FixOrderMassCancelReport)) return false;

		FixOrderMassCancelReport msg = (FixOrderMassCancelReport) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) || (!hasSecondaryClOrdID() && msg.hasSecondaryClOrdID())) return false;
		if (!(!hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) && !FixUtils.equals(getSecondaryClOrdID(), msg.getSecondaryClOrdID())) return false;
		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasMassActionReportID() && !msg.hasMassActionReportID()) || (!hasMassActionReportID() && msg.hasMassActionReportID())) return false;
		if (!(!hasMassActionReportID() && !msg.hasMassActionReportID()) && !FixUtils.equals(getMassActionReportID(), msg.getMassActionReportID())) return false;
		if ((hasSecondaryOrderID() && !msg.hasSecondaryOrderID()) || (!hasSecondaryOrderID() && msg.hasSecondaryOrderID())) return false;
		if (!(!hasSecondaryOrderID() && !msg.hasSecondaryOrderID()) && !FixUtils.equals(getSecondaryOrderID(), msg.getSecondaryOrderID())) return false;
		if ((hasMassCancelRequestType() && !msg.hasMassCancelRequestType()) || (!hasMassCancelRequestType() && msg.hasMassCancelRequestType())) return false;
		if (!(!hasMassCancelRequestType() && !msg.hasMassCancelRequestType()) && !(getMassCancelRequestType()==msg.getMassCancelRequestType())) return false;
		if ((hasMassCancelResponse() && !msg.hasMassCancelResponse()) || (!hasMassCancelResponse() && msg.hasMassCancelResponse())) return false;
		if (!(!hasMassCancelResponse() && !msg.hasMassCancelResponse()) && !(getMassCancelResponse()==msg.getMassCancelResponse())) return false;
		if ((hasMassCancelRejectReason() && !msg.hasMassCancelRejectReason()) || (!hasMassCancelRejectReason() && msg.hasMassCancelRejectReason())) return false;
		if (!(!hasMassCancelRejectReason() && !msg.hasMassCancelRejectReason()) && !(getMassCancelRejectReason()==msg.getMassCancelRejectReason())) return false;
		if ((hasTotalAffectedOrders() && !msg.hasTotalAffectedOrders()) || (!hasTotalAffectedOrders() && msg.hasTotalAffectedOrders())) return false;
		if (!(!hasTotalAffectedOrders() && !msg.hasTotalAffectedOrders()) && !(getTotalAffectedOrders()==msg.getTotalAffectedOrders())) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		if ((hasMarketID() && !msg.hasMarketID()) || (!hasMarketID() && msg.hasMarketID())) return false;
		if (!(!hasMarketID() && !msg.hasMarketID()) && !FixUtils.equals(getMarketID(), msg.getMarketID())) return false;
		if ((hasMarketSegmentID() && !msg.hasMarketSegmentID()) || (!hasMarketSegmentID() && msg.hasMarketSegmentID())) return false;
		if (!(!hasMarketSegmentID() && !msg.hasMarketSegmentID()) && !FixUtils.equals(getMarketSegmentID(), msg.getMarketSegmentID())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixOrderMassCancelReport clone () {
		FixOrderMassCancelReport out = new FixOrderMassCancelReport();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixOrderMassCancelReport clone ( FixOrderMassCancelReport out ) {
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasSecondaryClOrdID())
			out.setSecondaryClOrdID(getSecondaryClOrdID());
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasMassActionReportID())
			out.setMassActionReportID(getMassActionReportID());
		if ( hasSecondaryOrderID())
			out.setSecondaryOrderID(getSecondaryOrderID());
		if ( hasMassCancelRequestType())
			out.setMassCancelRequestType(getMassCancelRequestType());
		if ( hasMassCancelResponse())
			out.setMassCancelResponse(getMassCancelResponse());
		if ( hasMassCancelRejectReason())
			out.setMassCancelRejectReason(getMassCancelRejectReason());
		if ( hasTotalAffectedOrders())
			out.setTotalAffectedOrders(getTotalAffectedOrders());
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		if ( hasMarketID())
			out.setMarketID(getMarketID());
		if ( hasMarketSegmentID())
			out.setMarketSegmentID(getMarketSegmentID());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		int count = 0;
		count = 0;
		for (FixAffectedOrdGrp fixAffectedOrdGrp : affectedOrdGrp) {
			if (!fixAffectedOrdGrp.hasGroup()) continue;
			out.affectedOrdGrp[count] = fixAffectedOrdGrp.clone( out.affectedOrdGrp[count] );
			count++;
		}
		count = 0;
		for (FixNotAffectedOrdersGrp fixNotAffectedOrdersGrp : notAffectedOrdersGrp) {
			if (!fixNotAffectedOrdersGrp.hasGroup()) continue;
			out.notAffectedOrdersGrp[count] = fixNotAffectedOrdersGrp.clone( out.notAffectedOrdersGrp[count] );
			count++;
		}
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixTargetParties fixTargetParties : targetParties) {
			if (!fixTargetParties.hasGroup()) continue;
			out.targetParties[count] = fixTargetParties.clone( out.targetParties[count] );
			count++;
		}
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		if (underlyingInstrument.hasGroup())
			out.underlyingInstrument = underlyingInstrument.clone( out.underlyingInstrument);
		return out;
	}

}
