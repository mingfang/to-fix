package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixIOI extends FixInMessage {
	private short hasIOIID;
	byte[] iOIID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasIOITransType;
	byte iOITransType = (byte)' ';		
	private short hasIOIRefID;
	byte[] iOIRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasQtyType;
	long qtyType = 0;		
	private short hasIOIQty;
	byte[] iOIQty = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasPriceType;
	long priceType = 0;		
	private short hasPrice;
	long price = 0;		
	private short hasValidUntilTime;
	byte[] validUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasIOIQltyInd;
	byte iOIQltyInd = (byte)' ';		
	private short hasIOINaturalFlag;
		boolean iOINaturalFlag = false;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasURLLink;
	byte[] uRLLink = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixInstrument instrument;
	public FixParties[] parties;
	public FixFinancingDetails financingDetails;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixOrderQtyData orderQtyData;
	public FixStipulations[] stipulations;
	public FixInstrmtLegIOIGrp[] instrmtLegIOIGrp;
	public FixIOIQualGrp[] iOIQualGrp;
	public FixRoutingGrp[] routingGrp;
	public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	public FixYieldData yieldData;
	
	public FixIOI() {
		super(FixMessageInfo.MessageTypes.IOI);


		hasIOIID = FixUtils.TAG_HAS_NO_VALUE;		
		iOIID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasIOITransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasIOIRefID = FixUtils.TAG_HAS_NO_VALUE;		
		iOIRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasQtyType = FixUtils.TAG_HAS_NO_VALUE;		
		hasIOIQty = FixUtils.TAG_HAS_NO_VALUE;		
		iOIQty = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasValidUntilTime = FixUtils.TAG_HAS_NO_VALUE;		
		validUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasIOIQltyInd = FixUtils.TAG_HAS_NO_VALUE;		
		hasIOINaturalFlag = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasURLLink = FixUtils.TAG_HAS_NO_VALUE;		
		uRLLink = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		applicationSequenceControl = new FixApplicationSequenceControl();
		instrument = new FixInstrument();
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		financingDetails = new FixFinancingDetails();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		orderQtyData = new FixOrderQtyData();
		stipulations = new FixStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) stipulations[i] = new FixStipulations();
		instrmtLegIOIGrp = new FixInstrmtLegIOIGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegIOIGrp[i] = new FixInstrmtLegIOIGrp();
		iOIQualGrp = new FixIOIQualGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) iOIQualGrp[i] = new FixIOIQualGrp();
		routingGrp = new FixRoutingGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) routingGrp[i] = new FixRoutingGrp();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		yieldData = new FixYieldData();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.IOIID_INT:		
            		hasIOIID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.IOITRANSTYPE_INT:		
            		hasIOITransType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.IOIREFID_INT:		
            		hasIOIRefID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.QTYTYPE_INT:		
            		hasQtyType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.IOIQTY_INT:		
            		hasIOIQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRICETYPE_INT:		
            		hasPriceType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRICE_INT:		
            		hasPrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.VALIDUNTILTIME_INT:		
            		hasValidUntilTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.IOIQLTYIND_INT:		
            		hasIOIQltyInd = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.IOINATURALFLAG_INT:		
            		hasIOINaturalFlag = (short) buf.position();		
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
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.URLLINK_INT:		
            		hasURLLink = (short) buf.position();		
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
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( financingDetails.isKeyTag(tag)) {
        				tag = financingDetails.setBuffer( tag, buf, err);		
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
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = undInstrmtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( orderQtyData.isKeyTag(tag)) {
        				tag = orderQtyData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOSTIPULATIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !stipulations[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = stipulations[count].setBuffer( repeatingGroupTag, buf, err);	
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
        					if ( !instrmtLegIOIGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegIOIGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOIOIQUALIFIERS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !iOIQualGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = iOIQualGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOROUTINGIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !routingGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = routingGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( spreadOrBenchmarkCurveData.isKeyTag(tag)) {
        				tag = spreadOrBenchmarkCurveData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( yieldData.isKeyTag(tag)) {
        				tag = yieldData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.IOI_INT);
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
		if (!hasIOIID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.IOIID_INT, FixMessageInfo.MessageTypes.IOI_INT);
			return false;
		}
		if (!hasIOITransType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.IOITRANSTYPE_INT, FixMessageInfo.MessageTypes.IOI_INT);
			return false;
		}
		if (!hasSide()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.SIDE_INT, FixMessageInfo.MessageTypes.IOI_INT);
			return false;
		}
		if (!hasIOIQty()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.IOIQTY_INT, FixMessageInfo.MessageTypes.IOI_INT);
			return false;
		}
		if (instrument.isRequired) instrument.hasRequiredTags(err); if (err.hasError()) return false;
		return true;
	}
	@Override		
	public void getAll() {		
		getIOIID();		
		getIOITransType();		
		getIOIRefID();		
		getSide();		
		getQtyType();		
		getIOIQty();		
		getCurrency();		
		getPriceType();		
		getPrice();		
		getValidUntilTime();		
		getIOIQltyInd();		
		getIOINaturalFlag();		
		getText();		
		getEncodedTextLen();		
		getEncodedText();		
		getTransactTime();		
		getURLLink();		
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
		if (hasIOIID()) {		
			out.put(FixTags.IOIID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,iOIID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasIOITransType()) {		
			out.put(FixTags.IOITRANSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,iOITransType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasIOIRefID()) {		
			out.put(FixTags.IOIREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,iOIRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSide()) {		
			out.put(FixTags.SIDE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQtyType()) {		
			out.put(FixTags.QTYTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)qtyType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasIOIQty()) {		
			out.put(FixTags.IOIQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,iOIQty); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriceType()) {		
			out.put(FixTags.PRICETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priceType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPrice()) {		
			out.put(FixTags.PRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)price);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasValidUntilTime()) {		
			out.put(FixTags.VALIDUNTILTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,validUntilTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasIOIQltyInd()) {		
			out.put(FixTags.IOIQLTYIND);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,iOIQltyInd); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasIOINaturalFlag()) {		
			out.put(FixTags.IOINATURALFLAG);		
		
			out.put((byte) '=');		
		
			out.put(iOINaturalFlag?(byte)'Y':(byte)'N' );
		
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
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasURLLink()) {		
			out.put(FixTags.URLLINK);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,uRLLink); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		applicationSequenceControl.encode(out);
		instrument.encode(out);
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		financingDetails.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		orderQtyData.encode(out);
		if (FixUtils.getNoInGroup(stipulations)>0) {
			out.put(FixTags.NOSTIPULATIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(stipulations));

			out.put(FixUtils.SOH);

		}
		for (FixStipulations fixStipulations : stipulations) if (fixStipulations.hasGroup()) fixStipulations.encode(out);
		if (FixUtils.getNoInGroup(instrmtLegIOIGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtLegIOIGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtLegIOIGrp fixInstrmtLegIOIGrp : instrmtLegIOIGrp) if (fixInstrmtLegIOIGrp.hasGroup()) fixInstrmtLegIOIGrp.encode(out);
		if (FixUtils.getNoInGroup(iOIQualGrp)>0) {
			out.put(FixTags.NOIOIQUALIFIERS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(iOIQualGrp));

			out.put(FixUtils.SOH);

		}
		for (FixIOIQualGrp fixIOIQualGrp : iOIQualGrp) if (fixIOIQualGrp.hasGroup()) fixIOIQualGrp.encode(out);
		if (FixUtils.getNoInGroup(routingGrp)>0) {
			out.put(FixTags.NOROUTINGIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(routingGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRoutingGrp fixRoutingGrp : routingGrp) if (fixRoutingGrp.hasGroup()) fixRoutingGrp.encode(out);
		spreadOrBenchmarkCurveData.encode(out);
		yieldData.encode(out);
		
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
		
		if (hasIOIID()) {		
			FixUtils.put(out,iOIID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIOITransType()) {		
			FixUtils.put(out,iOITransType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIOIRefID()) {		
			FixUtils.put(out,iOIRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQtyType()) {		
			FixUtils.put(out, (long)qtyType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIOIQty()) {		
			FixUtils.put(out,iOIQty); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceType()) {		
			FixUtils.put(out, (long)priceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPrice()) {		
			FixUtils.put(out, (long)price);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasValidUntilTime()) {		
			FixUtils.put(out,validUntilTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIOIQltyInd()) {		
			FixUtils.put(out,iOIQltyInd); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIOINaturalFlag()) {		
			out.put(iOINaturalFlag?(byte)'Y':(byte)'N' );
		
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
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasURLLink()) {		
			FixUtils.put(out,uRLLink); 		
		
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
			
	public void crackIOIID() {		
		getIOIID();		
	}		
			
	public byte[] getIOIID() { 		
		if ( hasIOIID()) {		
			if (hasIOIID == FixUtils.TAG_HAS_VALUE) {		
				return iOIID; 		
			} else {

				buf.position(hasIOIID);

			FixUtils.getTagStringValue(buf, iOIID, 0, iOIID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasIOIID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return iOIID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasIOIID() { return hasIOIID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setIOIID(byte[] src) {		
		if (src == null ) return;
		if (hasIOIID()) FixUtils.fillNul(iOIID);		
		FixUtils.copy(iOIID, src); 		
		hasIOIID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIOIID(String str) {		
		if (str == null ) return;
		if (hasIOIID()) FixUtils.fillNul(iOIID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(iOIID, src); 		
		hasIOIID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackIOITransType() {		
		getIOITransType();		
	}		
			
	public byte getIOITransType() { 		
		if ( hasIOITransType()) {		
			if (hasIOITransType == FixUtils.TAG_HAS_VALUE) {		
				return iOITransType; 		
			} else {

				buf.position(hasIOITransType);

			iOITransType = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (iOITransType != (byte)'R') && (iOITransType != (byte)'C') && (iOITransType != (byte)'N') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 28);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasIOITransType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return iOITransType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasIOITransType() { return hasIOITransType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setIOITransType(byte[] src) {		
		if (src == null ) return;
		if (hasIOITransType()) iOITransType = (byte)' ';		
		iOITransType = src[0];		
		hasIOITransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIOITransType(byte src) {		
		iOITransType = src;
		hasIOITransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIOITransType(String str) {		
		if (str == null ) return;
		if (hasIOITransType()) iOITransType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		iOITransType = src[0];		
		hasIOITransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackIOIRefID() {		
		getIOIRefID();		
	}		
			
	public byte[] getIOIRefID() { 		
		if ( hasIOIRefID()) {		
			if (hasIOIRefID == FixUtils.TAG_HAS_VALUE) {		
				return iOIRefID; 		
			} else {

				buf.position(hasIOIRefID);

			FixUtils.getTagStringValue(buf, iOIRefID, 0, iOIRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasIOIRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return iOIRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasIOIRefID() { return hasIOIRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setIOIRefID(byte[] src) {		
		if (src == null ) return;
		if (hasIOIRefID()) FixUtils.fillNul(iOIRefID);		
		FixUtils.copy(iOIRefID, src); 		
		hasIOIRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIOIRefID(String str) {		
		if (str == null ) return;
		if (hasIOIRefID()) FixUtils.fillNul(iOIRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(iOIRefID, src); 		
		hasIOIRefID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackQtyType() {		
		getQtyType();		
	}		
			
	public long getQtyType() { 		
		if ( hasQtyType()) {		
			if (hasQtyType == FixUtils.TAG_HAS_VALUE) {		
				return qtyType; 		
			} else {

				buf.position(hasQtyType);

			qtyType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQtyType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return qtyType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQtyType() { return hasQtyType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQtyType(byte[] src) {		
		if (src == null ) return;
		if (hasQtyType()) qtyType = FixUtils.TAG_HAS_NO_VALUE;		
		qtyType = FixUtils.longValueOf(src, 0, src.length);
		hasQtyType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQtyType(long src) {		
		qtyType = src;
		hasQtyType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQtyType(String str) {		
		if (str == null ) return;
		if (hasQtyType()) qtyType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		qtyType = FixUtils.longValueOf(src, 0, src.length);
		hasQtyType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackIOIQty() {		
		getIOIQty();		
	}		
			
	public byte[] getIOIQty() { 		
		if ( hasIOIQty()) {		
			if (hasIOIQty == FixUtils.TAG_HAS_VALUE) {		
				return iOIQty; 		
			} else {

				buf.position(hasIOIQty);

			FixUtils.getTagStringValue(buf, iOIQty, 0, iOIQty.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasIOIQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return iOIQty;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasIOIQty() { return hasIOIQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setIOIQty(byte[] src) {		
		if (src == null ) return;
		if (hasIOIQty()) FixUtils.fillNul(iOIQty);		
		FixUtils.copy(iOIQty, src); 		
		hasIOIQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIOIQty(String str) {		
		if (str == null ) return;
		if (hasIOIQty()) FixUtils.fillNul(iOIQty);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(iOIQty, src); 		
		hasIOIQty = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackPriceType() {		
		getPriceType();		
	}		
			
	public long getPriceType() { 		
		if ( hasPriceType()) {		
			if (hasPriceType == FixUtils.TAG_HAS_VALUE) {		
				return priceType; 		
			} else {

				buf.position(hasPriceType);

			priceType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPriceType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return priceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriceType() { return hasPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasPriceType()) priceType = FixUtils.TAG_HAS_NO_VALUE;		
		priceType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceType(long src) {		
		priceType = src;
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceType(String str) {		
		if (str == null ) return;
		if (hasPriceType()) priceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priceType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPrice() {		
		getPrice();		
	}		
			
	public long getPrice() { 		
		if ( hasPrice()) {		
			if (hasPrice == FixUtils.TAG_HAS_VALUE) {		
				return price; 		
			} else {

				buf.position(hasPrice);

			price = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return price;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPrice() { return hasPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPrice(byte[] src) {		
		if (src == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice(long src) {		
		price = src;
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice(String str) {		
		if (str == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackValidUntilTime() {		
		getValidUntilTime();		
	}		
			
	public byte[] getValidUntilTime() { 		
		if ( hasValidUntilTime()) {		
			if (hasValidUntilTime == FixUtils.TAG_HAS_VALUE) {		
				return validUntilTime; 		
			} else {

				buf.position(hasValidUntilTime);

			FixUtils.getTagStringValue(buf, validUntilTime, 0, validUntilTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasValidUntilTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return validUntilTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasValidUntilTime() { return hasValidUntilTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setValidUntilTime(byte[] src) {		
		if (src == null ) return;
		if (hasValidUntilTime()) FixUtils.fillNul(validUntilTime);		
		FixUtils.copy(validUntilTime, src); 		
		hasValidUntilTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setValidUntilTime(String str) {		
		if (str == null ) return;
		if (hasValidUntilTime()) FixUtils.fillNul(validUntilTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(validUntilTime, src); 		
		hasValidUntilTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackIOIQltyInd() {		
		getIOIQltyInd();		
	}		
			
	public byte getIOIQltyInd() { 		
		if ( hasIOIQltyInd()) {		
			if (hasIOIQltyInd == FixUtils.TAG_HAS_VALUE) {		
				return iOIQltyInd; 		
			} else {

				buf.position(hasIOIQltyInd);

			iOIQltyInd = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (iOIQltyInd != (byte)'L') && (iOIQltyInd != (byte)'M') && (iOIQltyInd != (byte)'H') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 25);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasIOIQltyInd = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return iOIQltyInd;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasIOIQltyInd() { return hasIOIQltyInd != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setIOIQltyInd(byte[] src) {		
		if (src == null ) return;
		if (hasIOIQltyInd()) iOIQltyInd = (byte)' ';		
		iOIQltyInd = src[0];		
		hasIOIQltyInd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIOIQltyInd(byte src) {		
		iOIQltyInd = src;
		hasIOIQltyInd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIOIQltyInd(String str) {		
		if (str == null ) return;
		if (hasIOIQltyInd()) iOIQltyInd = (byte)' ';		
		byte[] src = str.getBytes(); 		
		iOIQltyInd = src[0];		
		hasIOIQltyInd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackIOINaturalFlag() {		
		getIOINaturalFlag();		
	}		
			
	public boolean getIOINaturalFlag() { 		
		if ( hasIOINaturalFlag()) {		
			if (hasIOINaturalFlag == FixUtils.TAG_HAS_VALUE) {		
				return iOINaturalFlag; 		
			} else {

				buf.position(hasIOINaturalFlag);

			iOINaturalFlag = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasIOINaturalFlag = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return iOINaturalFlag;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasIOINaturalFlag() { return hasIOINaturalFlag != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setIOINaturalFlag(byte[] src) {		
		if (src == null ) return;
		if (hasIOINaturalFlag()) iOINaturalFlag = false;		
		iOINaturalFlag = src[0]==(byte)'Y'?true:false;		
		hasIOINaturalFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIOINaturalFlag(boolean src) {		
		iOINaturalFlag = src;
		hasIOINaturalFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIOINaturalFlag(String str) {		
		if (str == null ) return;
		if (hasIOINaturalFlag()) iOINaturalFlag = false;		
		byte[] src = str.getBytes(); 		
		iOINaturalFlag = src[0]==(byte)'Y'?true:false;		
		hasIOINaturalFlag = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackURLLink() {		
		getURLLink();		
	}		
			
	public byte[] getURLLink() { 		
		if ( hasURLLink()) {		
			if (hasURLLink == FixUtils.TAG_HAS_VALUE) {		
				return uRLLink; 		
			} else {

				buf.position(hasURLLink);

			FixUtils.getTagStringValue(buf, uRLLink, 0, uRLLink.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasURLLink = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return uRLLink;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasURLLink() { return hasURLLink != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setURLLink(byte[] src) {		
		if (src == null ) return;
		if (hasURLLink()) FixUtils.fillNul(uRLLink);		
		FixUtils.copy(uRLLink, src); 		
		hasURLLink = FixUtils.TAG_HAS_VALUE;		
	}

	public void setURLLink(String str) {		
		if (str == null ) return;
		if (hasURLLink()) FixUtils.fillNul(uRLLink);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(uRLLink, src); 		
		hasURLLink = FixUtils.TAG_HAS_VALUE;		
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

					if (hasIOIID()) s += "IOIID(23)= " + new String( FixUtils.trim(getIOIID()) ) + "\n" ; 
		if (hasIOITransType()) s += "IOITransType(28)= " + getIOITransType() + "\n" ; 
		if (hasIOIRefID()) s += "IOIRefID(26)= " + new String( FixUtils.trim(getIOIRefID()) ) + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasQtyType()) s += "QtyType(854)= " + getQtyType() + "\n" ; 
		if (hasIOIQty()) s += "IOIQty(27)= " + new String( FixUtils.trim(getIOIQty()) ) + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasPriceType()) s += "PriceType(423)= " + getPriceType() + "\n" ; 
		if (hasPrice()) s += "Price(44)= " + getPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasValidUntilTime()) s += "ValidUntilTime(62)= " + new String( FixUtils.trim(getValidUntilTime()) ) + "\n" ; 
		if (hasIOIQltyInd()) s += "IOIQltyInd(25)= " + getIOIQltyInd() + "\n" ; 
		if (hasIOINaturalFlag()) s += "IOINaturalFlag(130)= " + getIOINaturalFlag() + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasURLLink()) s += "URLLink(149)= " + new String( FixUtils.trim(getURLLink()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixIOI)) return false;

		FixIOI msg = (FixIOI) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasIOIID() && !msg.hasIOIID()) || (!hasIOIID() && msg.hasIOIID())) return false;
		if (!(!hasIOIID() && !msg.hasIOIID()) && !FixUtils.equals(getIOIID(), msg.getIOIID())) return false;
		if ((hasIOITransType() && !msg.hasIOITransType()) || (!hasIOITransType() && msg.hasIOITransType())) return false;
		if (!(!hasIOITransType() && !msg.hasIOITransType()) && !(getIOITransType()==msg.getIOITransType())) return false;
		if ((hasIOIRefID() && !msg.hasIOIRefID()) || (!hasIOIRefID() && msg.hasIOIRefID())) return false;
		if (!(!hasIOIRefID() && !msg.hasIOIRefID()) && !FixUtils.equals(getIOIRefID(), msg.getIOIRefID())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasQtyType() && !msg.hasQtyType()) || (!hasQtyType() && msg.hasQtyType())) return false;
		if (!(!hasQtyType() && !msg.hasQtyType()) && !(getQtyType()==msg.getQtyType())) return false;
		if ((hasIOIQty() && !msg.hasIOIQty()) || (!hasIOIQty() && msg.hasIOIQty())) return false;
		if (!(!hasIOIQty() && !msg.hasIOIQty()) && !FixUtils.equals(getIOIQty(), msg.getIOIQty())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasPriceType() && !msg.hasPriceType()) || (!hasPriceType() && msg.hasPriceType())) return false;
		if (!(!hasPriceType() && !msg.hasPriceType()) && !(getPriceType()==msg.getPriceType())) return false;
		if ((hasPrice() && !msg.hasPrice()) || (!hasPrice() && msg.hasPrice())) return false;
		if (!(!hasPrice() && !msg.hasPrice()) && !(getPrice()==msg.getPrice())) return false;
		if ((hasValidUntilTime() && !msg.hasValidUntilTime()) || (!hasValidUntilTime() && msg.hasValidUntilTime())) return false;
		if ((hasIOIQltyInd() && !msg.hasIOIQltyInd()) || (!hasIOIQltyInd() && msg.hasIOIQltyInd())) return false;
		if (!(!hasIOIQltyInd() && !msg.hasIOIQltyInd()) && !(getIOIQltyInd()==msg.getIOIQltyInd())) return false;
		if ((hasIOINaturalFlag() && !msg.hasIOINaturalFlag()) || (!hasIOINaturalFlag() && msg.hasIOINaturalFlag())) return false;
		if (!(!hasIOINaturalFlag() && !msg.hasIOINaturalFlag()) && !(getIOINaturalFlag()==msg.getIOINaturalFlag())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasURLLink() && !msg.hasURLLink()) || (!hasURLLink() && msg.hasURLLink())) return false;
		if (!(!hasURLLink() && !msg.hasURLLink()) && !FixUtils.equals(getURLLink(), msg.getURLLink())) return false;
		return true;
	}
	@Override
	public FixIOI clone () {
		FixIOI out = new FixIOI();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixIOI clone ( FixIOI out ) {
		if ( hasIOIID())
			out.setIOIID(getIOIID());
		if ( hasIOITransType())
			out.setIOITransType(getIOITransType());
		if ( hasIOIRefID())
			out.setIOIRefID(getIOIRefID());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasQtyType())
			out.setQtyType(getQtyType());
		if ( hasIOIQty())
			out.setIOIQty(getIOIQty());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasPriceType())
			out.setPriceType(getPriceType());
		if ( hasPrice())
			out.setPrice(getPrice());
		if ( hasValidUntilTime())
			out.setValidUntilTime(getValidUntilTime());
		if ( hasIOIQltyInd())
			out.setIOIQltyInd(getIOIQltyInd());
		if ( hasIOINaturalFlag())
			out.setIOINaturalFlag(getIOINaturalFlag());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasURLLink())
			out.setURLLink(getURLLink());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		if (financingDetails.hasGroup())
			out.financingDetails = financingDetails.clone( out.financingDetails);
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		if (orderQtyData.hasGroup())
			out.orderQtyData = orderQtyData.clone( out.orderQtyData);
		count = 0;
		for (FixStipulations fixStipulations : stipulations) {
			if (!fixStipulations.hasGroup()) continue;
			out.stipulations[count] = fixStipulations.clone( out.stipulations[count] );
			count++;
		}
		count = 0;
		for (FixInstrmtLegIOIGrp fixInstrmtLegIOIGrp : instrmtLegIOIGrp) {
			if (!fixInstrmtLegIOIGrp.hasGroup()) continue;
			out.instrmtLegIOIGrp[count] = fixInstrmtLegIOIGrp.clone( out.instrmtLegIOIGrp[count] );
			count++;
		}
		count = 0;
		for (FixIOIQualGrp fixIOIQualGrp : iOIQualGrp) {
			if (!fixIOIQualGrp.hasGroup()) continue;
			out.iOIQualGrp[count] = fixIOIQualGrp.clone( out.iOIQualGrp[count] );
			count++;
		}
		count = 0;
		for (FixRoutingGrp fixRoutingGrp : routingGrp) {
			if (!fixRoutingGrp.hasGroup()) continue;
			out.routingGrp[count] = fixRoutingGrp.clone( out.routingGrp[count] );
			count++;
		}
		if (spreadOrBenchmarkCurveData.hasGroup())
			out.spreadOrBenchmarkCurveData = spreadOrBenchmarkCurveData.clone( out.spreadOrBenchmarkCurveData);
		if (yieldData.hasGroup())
			out.yieldData = yieldData.clone( out.yieldData);
		return out;
	}

}
