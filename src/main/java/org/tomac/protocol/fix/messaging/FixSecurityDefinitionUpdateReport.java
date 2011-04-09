package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixSecurityDefinitionUpdateReport extends FixInMessage {
	private short hasSecurityReportID;
	long securityReportID = 0;		
	private short hasSecurityReqID;
	byte[] securityReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityResponseID;
	byte[] securityResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityResponseType;
	long securityResponseType = 0;		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityUpdateAction;
	byte securityUpdateAction = (byte)' ';		
	private short hasCorporateAction;
	byte[] corporateAction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	public FixInstrument instrument;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixInstrumentExtension instrumentExtension;
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	public FixStipulations[] stipulations;
	public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	public FixYieldData yieldData;
	public FixMarketSegmentGrp[] marketSegmentGrp;
	
	public FixSecurityDefinitionUpdateReport() {
		super(FixMessageInfo.MessageTypes.SECURITYDEFINITIONUPDATEREPORT);


		hasSecurityReportID = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityReqID = FixUtils.TAG_HAS_NO_VALUE;		
		securityReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityResponseID = FixUtils.TAG_HAS_NO_VALUE;		
		securityResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityResponseType = FixUtils.TAG_HAS_NO_VALUE;		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityUpdateAction = FixUtils.TAG_HAS_NO_VALUE;		
		hasCorporateAction = FixUtils.TAG_HAS_NO_VALUE;		
		corporateAction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		instrument = new FixInstrument();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		instrumentExtension = new FixInstrumentExtension();
		applicationSequenceControl = new FixApplicationSequenceControl();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		stipulations = new FixStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) stipulations[i] = new FixStipulations();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		yieldData = new FixYieldData();
		marketSegmentGrp = new FixMarketSegmentGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) marketSegmentGrp[i] = new FixMarketSegmentGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.SECURITYREPORTID_INT:		
            		hasSecurityReportID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYREQID_INT:		
            		hasSecurityReqID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYRESPONSEID_INT:		
            		hasSecurityResponseID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYRESPONSETYPE_INT:		
            		hasSecurityResponseType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYUPDATEACTION_INT:		
            		hasSecurityUpdateAction = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CORPORATEACTION_INT:		
            		hasCorporateAction = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
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
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
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
        			} else if ( instrumentExtension.isKeyTag(tag)) {
        				tag = instrumentExtension.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( applicationSequenceControl.isKeyTag(tag)) {
        				tag = applicationSequenceControl.setBuffer( tag, buf, err);		
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
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
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
        			} else if ( spreadOrBenchmarkCurveData.isKeyTag(tag)) {
        				tag = spreadOrBenchmarkCurveData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( yieldData.isKeyTag(tag)) {
        				tag = yieldData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOMARKETSEGMENTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !marketSegmentGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = marketSegmentGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.SECURITYDEFINITIONUPDATEREPORT_INT);
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
		return true;
	}
	@Override		
	public void getAll() {		
		getSecurityReportID();		
		getSecurityReqID();		
		getSecurityResponseID();		
		getSecurityResponseType();		
		getClearingBusinessDate();		
		getSecurityUpdateAction();		
		getCorporateAction();		
		getCurrency();		
		getText();		
		getEncodedTextLen();		
		getEncodedText();		
		getTransactTime();		
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
		if (hasSecurityReportID()) {		
			out.put(FixTags.SECURITYREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)securityReportID);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityReqID()) {		
			out.put(FixTags.SECURITYREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,securityReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityResponseID()) {		
			out.put(FixTags.SECURITYRESPONSEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,securityResponseID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityResponseType()) {		
			out.put(FixTags.SECURITYRESPONSETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)securityResponseType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityUpdateAction()) {		
			out.put(FixTags.SECURITYUPDATEACTION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,securityUpdateAction); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCorporateAction()) {		
			out.put(FixTags.CORPORATEACTION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,corporateAction); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
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
		
		instrument.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		instrumentExtension.encode(out);
		applicationSequenceControl.encode(out);
		if (FixUtils.getNoInGroup(instrmtLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) if (fixInstrmtLegGrp.hasGroup()) fixInstrmtLegGrp.encode(out);
		if (FixUtils.getNoInGroup(stipulations)>0) {
			out.put(FixTags.NOSTIPULATIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(stipulations));

			out.put(FixUtils.SOH);

		}
		for (FixStipulations fixStipulations : stipulations) if (fixStipulations.hasGroup()) fixStipulations.encode(out);
		spreadOrBenchmarkCurveData.encode(out);
		yieldData.encode(out);
		if (FixUtils.getNoInGroup(marketSegmentGrp)>0) {
			out.put(FixTags.NOMARKETSEGMENTS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(marketSegmentGrp));

			out.put(FixUtils.SOH);

		}
		for (FixMarketSegmentGrp fixMarketSegmentGrp : marketSegmentGrp) if (fixMarketSegmentGrp.hasGroup()) fixMarketSegmentGrp.encode(out);
		
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
		
		if (hasSecurityReportID()) {		
			FixUtils.put(out, (long)securityReportID);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityReqID()) {		
			FixUtils.put(out,securityReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityResponseID()) {		
			FixUtils.put(out,securityResponseID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityResponseType()) {		
			FixUtils.put(out, (long)securityResponseType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityUpdateAction()) {		
			FixUtils.put(out,securityUpdateAction); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCorporateAction()) {		
			FixUtils.put(out,corporateAction); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
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
		
		super.standardTrailer.encode(out);		
		
		int endPos = out.position();		
		
		// set body length		
				
		super.standardHeader.setBodyLength( out.position() - startPos );		
				
		out.position(startPos + FixUtils.FIX_HEADER); 		
		
		FixUtils.put( out, super.standardHeader.getBodyLength() );		
		
		out.position(endPos);		
		
	}			
			
	public void crackSecurityReportID() {		
		getSecurityReportID();		
	}		
			
	public long getSecurityReportID() { 		
		if ( hasSecurityReportID()) {		
			if (hasSecurityReportID == FixUtils.TAG_HAS_VALUE) {		
				return securityReportID; 		
			} else {

				buf.position(hasSecurityReportID);

			securityReportID = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSecurityReportID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityReportID;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecurityReportID() { return hasSecurityReportID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityReportID(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityReportID()) securityReportID = FixUtils.TAG_HAS_NO_VALUE;		
		securityReportID = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityReportID(long src) {		
		securityReportID = src;
		hasSecurityReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityReportID(String str) {		
		if (str == null ) return;
		if (hasSecurityReportID()) securityReportID = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		securityReportID = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityReqID() {		
		getSecurityReqID();		
	}		
			
	public byte[] getSecurityReqID() { 		
		if ( hasSecurityReqID()) {		
			if (hasSecurityReqID == FixUtils.TAG_HAS_VALUE) {		
				return securityReqID; 		
			} else {

				buf.position(hasSecurityReqID);

			FixUtils.getTagStringValue(buf, securityReqID, 0, securityReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecurityReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityReqID() { return hasSecurityReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityReqID(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityReqID()) FixUtils.fillNul(securityReqID);		
		FixUtils.copy(securityReqID, src); 		
		hasSecurityReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityReqID(String str) {		
		if (str == null ) return;
		if (hasSecurityReqID()) FixUtils.fillNul(securityReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityReqID, src); 		
		hasSecurityReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityResponseID() {		
		getSecurityResponseID();		
	}		
			
	public byte[] getSecurityResponseID() { 		
		if ( hasSecurityResponseID()) {		
			if (hasSecurityResponseID == FixUtils.TAG_HAS_VALUE) {		
				return securityResponseID; 		
			} else {

				buf.position(hasSecurityResponseID);

			FixUtils.getTagStringValue(buf, securityResponseID, 0, securityResponseID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecurityResponseID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityResponseID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityResponseID() { return hasSecurityResponseID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityResponseID(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityResponseID()) FixUtils.fillNul(securityResponseID);		
		FixUtils.copy(securityResponseID, src); 		
		hasSecurityResponseID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityResponseID(String str) {		
		if (str == null ) return;
		if (hasSecurityResponseID()) FixUtils.fillNul(securityResponseID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityResponseID, src); 		
		hasSecurityResponseID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityResponseType() {		
		getSecurityResponseType();		
	}		
			
	public long getSecurityResponseType() { 		
		if ( hasSecurityResponseType()) {		
			if (hasSecurityResponseType == FixUtils.TAG_HAS_VALUE) {		
				return securityResponseType; 		
			} else {

				buf.position(hasSecurityResponseType);

			securityResponseType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSecurityResponseType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityResponseType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecurityResponseType() { return hasSecurityResponseType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityResponseType(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityResponseType()) securityResponseType = FixUtils.TAG_HAS_NO_VALUE;		
		securityResponseType = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityResponseType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityResponseType(long src) {		
		securityResponseType = src;
		hasSecurityResponseType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityResponseType(String str) {		
		if (str == null ) return;
		if (hasSecurityResponseType()) securityResponseType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		securityResponseType = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityResponseType = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackSecurityUpdateAction() {		
		getSecurityUpdateAction();		
	}		
			
	public byte getSecurityUpdateAction() { 		
		if ( hasSecurityUpdateAction()) {		
			if (hasSecurityUpdateAction == FixUtils.TAG_HAS_VALUE) {		
				return securityUpdateAction; 		
			} else {

				buf.position(hasSecurityUpdateAction);

			securityUpdateAction = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (securityUpdateAction != (byte)'D') && (securityUpdateAction != (byte)'A') && (securityUpdateAction != (byte)'M') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 980);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasSecurityUpdateAction = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityUpdateAction;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSecurityUpdateAction() { return hasSecurityUpdateAction != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityUpdateAction(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityUpdateAction()) securityUpdateAction = (byte)' ';		
		securityUpdateAction = src[0];		
		hasSecurityUpdateAction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityUpdateAction(byte src) {		
		securityUpdateAction = src;
		hasSecurityUpdateAction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityUpdateAction(String str) {		
		if (str == null ) return;
		if (hasSecurityUpdateAction()) securityUpdateAction = (byte)' ';		
		byte[] src = str.getBytes(); 		
		securityUpdateAction = src[0];		
		hasSecurityUpdateAction = FixUtils.TAG_HAS_VALUE;		
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

					if (hasSecurityReportID()) s += "SecurityReportID(964)= " + getSecurityReportID() + "\n" ; 
		if (hasSecurityReqID()) s += "SecurityReqID(320)= " + new String( FixUtils.trim(getSecurityReqID()) ) + "\n" ; 
		if (hasSecurityResponseID()) s += "SecurityResponseID(322)= " + new String( FixUtils.trim(getSecurityResponseID()) ) + "\n" ; 
		if (hasSecurityResponseType()) s += "SecurityResponseType(323)= " + getSecurityResponseType() + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasSecurityUpdateAction()) s += "SecurityUpdateAction(980)= " + getSecurityUpdateAction() + "\n" ; 
		if (hasCorporateAction()) s += "CorporateAction(292)= " + new String( FixUtils.trim(getCorporateAction()) ) + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSecurityDefinitionUpdateReport)) return false;

		FixSecurityDefinitionUpdateReport msg = (FixSecurityDefinitionUpdateReport) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasSecurityReportID() && !msg.hasSecurityReportID()) || (!hasSecurityReportID() && msg.hasSecurityReportID())) return false;
		if (!(!hasSecurityReportID() && !msg.hasSecurityReportID()) && !(getSecurityReportID()==msg.getSecurityReportID())) return false;
		if ((hasSecurityReqID() && !msg.hasSecurityReqID()) || (!hasSecurityReqID() && msg.hasSecurityReqID())) return false;
		if (!(!hasSecurityReqID() && !msg.hasSecurityReqID()) && !FixUtils.equals(getSecurityReqID(), msg.getSecurityReqID())) return false;
		if ((hasSecurityResponseID() && !msg.hasSecurityResponseID()) || (!hasSecurityResponseID() && msg.hasSecurityResponseID())) return false;
		if (!(!hasSecurityResponseID() && !msg.hasSecurityResponseID()) && !FixUtils.equals(getSecurityResponseID(), msg.getSecurityResponseID())) return false;
		if ((hasSecurityResponseType() && !msg.hasSecurityResponseType()) || (!hasSecurityResponseType() && msg.hasSecurityResponseType())) return false;
		if (!(!hasSecurityResponseType() && !msg.hasSecurityResponseType()) && !(getSecurityResponseType()==msg.getSecurityResponseType())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if ((hasSecurityUpdateAction() && !msg.hasSecurityUpdateAction()) || (!hasSecurityUpdateAction() && msg.hasSecurityUpdateAction())) return false;
		if (!(!hasSecurityUpdateAction() && !msg.hasSecurityUpdateAction()) && !(getSecurityUpdateAction()==msg.getSecurityUpdateAction())) return false;
		if ((hasCorporateAction() && !msg.hasCorporateAction()) || (!hasCorporateAction() && msg.hasCorporateAction())) return false;
		if (!(!hasCorporateAction() && !msg.hasCorporateAction()) && !FixUtils.equals(getCorporateAction(), msg.getCorporateAction())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		return true;
	}
	@Override
	public FixSecurityDefinitionUpdateReport clone () {
		FixSecurityDefinitionUpdateReport out = new FixSecurityDefinitionUpdateReport();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixSecurityDefinitionUpdateReport clone ( FixSecurityDefinitionUpdateReport out ) {
		if ( hasSecurityReportID())
			out.setSecurityReportID(getSecurityReportID());
		if ( hasSecurityReqID())
			out.setSecurityReqID(getSecurityReqID());
		if ( hasSecurityResponseID())
			out.setSecurityResponseID(getSecurityResponseID());
		if ( hasSecurityResponseType())
			out.setSecurityResponseType(getSecurityResponseType());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasSecurityUpdateAction())
			out.setSecurityUpdateAction(getSecurityUpdateAction());
		if ( hasCorporateAction())
			out.setCorporateAction(getCorporateAction());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		int count = 0;
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		if (instrumentExtension.hasGroup())
			out.instrumentExtension = instrumentExtension.clone( out.instrumentExtension);
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		count = 0;
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) {
			if (!fixInstrmtLegGrp.hasGroup()) continue;
			out.instrmtLegGrp[count] = fixInstrmtLegGrp.clone( out.instrmtLegGrp[count] );
			count++;
		}
		count = 0;
		for (FixStipulations fixStipulations : stipulations) {
			if (!fixStipulations.hasGroup()) continue;
			out.stipulations[count] = fixStipulations.clone( out.stipulations[count] );
			count++;
		}
		if (spreadOrBenchmarkCurveData.hasGroup())
			out.spreadOrBenchmarkCurveData = spreadOrBenchmarkCurveData.clone( out.spreadOrBenchmarkCurveData);
		if (yieldData.hasGroup())
			out.yieldData = yieldData.clone( out.yieldData);
		count = 0;
		for (FixMarketSegmentGrp fixMarketSegmentGrp : marketSegmentGrp) {
			if (!fixMarketSegmentGrp.hasGroup()) continue;
			out.marketSegmentGrp[count] = fixMarketSegmentGrp.clone( out.marketSegmentGrp[count] );
			count++;
		}
		return out;
	}

}
