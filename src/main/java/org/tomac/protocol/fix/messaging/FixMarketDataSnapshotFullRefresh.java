package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixMarketDataSnapshotFullRefresh extends FixInMessage {
	private short hasMDReportID;
	long mDReportID = 0;		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDBookType;
	long mDBookType = 0;		
	private short hasMDFeedType;
	byte[] mDFeedType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeDate;
	byte[] tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDSubBookType;
	long mDSubBookType = 0;		
	private short hasMarketDepth;
	long marketDepth = 0;		
	private short hasTotNumReports;
	long totNumReports = 0;		
	private short hasRefreshIndicator;
		boolean refreshIndicator = false;		
	private short hasMDReqID;
	byte[] mDReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDStreamID;
	byte[] mDStreamID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasFinancialStatus;
	byte[] financialStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCorporateAction;
	byte[] corporateAction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNetChgPrevDay;
	long netChgPrevDay = 0;		
	private short hasApplQueueDepth;
	long applQueueDepth = 0;		
	private short hasApplQueueResolution;
	long applQueueResolution = 0;		
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixInstrument instrument;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	public FixMDFullGrp[] mDFullGrp;
	public FixRoutingGrp[] routingGrp;
	
	public FixMarketDataSnapshotFullRefresh() {
		super(FixMessageInfo.MessageTypes.MARKETDATASNAPSHOTFULLREFRESH);


		hasMDReportID = FixUtils.TAG_HAS_NO_VALUE;		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDBookType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDFeedType = FixUtils.TAG_HAS_NO_VALUE;		
		mDFeedType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDSubBookType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMarketDepth = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotNumReports = FixUtils.TAG_HAS_NO_VALUE;		
		hasRefreshIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDReqID = FixUtils.TAG_HAS_NO_VALUE;		
		mDReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDStreamID = FixUtils.TAG_HAS_NO_VALUE;		
		mDStreamID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasFinancialStatus = FixUtils.TAG_HAS_NO_VALUE;		
		financialStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCorporateAction = FixUtils.TAG_HAS_NO_VALUE;		
		corporateAction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNetChgPrevDay = FixUtils.TAG_HAS_NO_VALUE;		
		hasApplQueueDepth = FixUtils.TAG_HAS_NO_VALUE;		
		hasApplQueueResolution = FixUtils.TAG_HAS_NO_VALUE;		
		applicationSequenceControl = new FixApplicationSequenceControl();
		instrument = new FixInstrument();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		mDFullGrp = new FixMDFullGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) mDFullGrp[i] = new FixMDFullGrp();
		routingGrp = new FixRoutingGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) routingGrp[i] = new FixRoutingGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.MDREPORTID_INT:		
            		hasMDReportID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MDBOOKTYPE_INT:		
            		hasMDBookType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MDFEEDTYPE_INT:		
            		hasMDFeedType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEDATE_INT:		
            		hasTradeDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MDSUBBOOKTYPE_INT:		
            		hasMDSubBookType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MARKETDEPTH_INT:		
            		hasMarketDepth = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TOTNUMREPORTS_INT:		
            		hasTotNumReports = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REFRESHINDICATOR_INT:		
            		hasRefreshIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MDREQID_INT:		
            		hasMDReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MDSTREAMID_INT:		
            		hasMDStreamID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.FINANCIALSTATUS_INT:		
            		hasFinancialStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CORPORATEACTION_INT:		
            		hasCorporateAction = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.NETCHGPREVDAY_INT:		
            		hasNetChgPrevDay = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.APPLQUEUEDEPTH_INT:		
            		hasApplQueueDepth = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.APPLQUEUERESOLUTION_INT:		
            		hasApplQueueResolution = (short) buf.position();		
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
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
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
        			} else if ( tag == FixTags.NOMDENTRIES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !mDFullGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = mDFullGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOROUTINGIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
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

		if (instrument.isRequired) instrument.hasRequiredTags(err); if (err.hasError()) return false;
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (mDFullGrp[i].hasGroup()) mDFullGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getMDReportID();		
		getClearingBusinessDate();		
		getMDBookType();		
		getMDFeedType();		
		getTradeDate();		
		getMDSubBookType();		
		getMarketDepth();		
		getTotNumReports();		
		getRefreshIndicator();		
		getMDReqID();		
		getMDStreamID();		
		getFinancialStatus();		
		getCorporateAction();		
		getNetChgPrevDay();		
		getApplQueueDepth();		
		getApplQueueResolution();		
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
		if (hasMDReportID()) {		
			out.put(FixTags.MDREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)mDReportID);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMDBookType()) {		
			out.put(FixTags.MDBOOKTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)mDBookType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMDFeedType()) {		
			out.put(FixTags.MDFEEDTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,mDFeedType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeDate()) {		
			out.put(FixTags.TRADEDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMDSubBookType()) {		
			out.put(FixTags.MDSUBBOOKTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)mDSubBookType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarketDepth()) {		
			out.put(FixTags.MARKETDEPTH);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)marketDepth);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotNumReports()) {		
			out.put(FixTags.TOTNUMREPORTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totNumReports);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRefreshIndicator()) {		
			out.put(FixTags.REFRESHINDICATOR);		
		
			out.put((byte) '=');		
		
			out.put(refreshIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMDReqID()) {		
			out.put(FixTags.MDREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,mDReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMDStreamID()) {		
			out.put(FixTags.MDSTREAMID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,mDStreamID); 		
		
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
		if (hasNetChgPrevDay()) {		
			out.put(FixTags.NETCHGPREVDAY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)netChgPrevDay);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasApplQueueDepth()) {		
			out.put(FixTags.APPLQUEUEDEPTH);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)applQueueDepth);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasApplQueueResolution()) {		
			out.put(FixTags.APPLQUEUERESOLUTION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)applQueueResolution);
		
			out.put(FixUtils.SOH);		
		}		
		
		applicationSequenceControl.encode(out);
		instrument.encode(out);
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
		if (FixUtils.getNoInGroup(mDFullGrp)>0) {
			out.put(FixTags.NOMDENTRIES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(mDFullGrp));

			out.put(FixUtils.SOH);

		}
		for (FixMDFullGrp fixMDFullGrp : mDFullGrp) if (fixMDFullGrp.hasGroup()) fixMDFullGrp.encode(out);
		if (FixUtils.getNoInGroup(routingGrp)>0) {
			out.put(FixTags.NOROUTINGIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(routingGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRoutingGrp fixRoutingGrp : routingGrp) if (fixRoutingGrp.hasGroup()) fixRoutingGrp.encode(out);
		
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
		
		if (hasMDReportID()) {		
			FixUtils.put(out, (long)mDReportID);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDBookType()) {		
			FixUtils.put(out, (long)mDBookType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDFeedType()) {		
			FixUtils.put(out,mDFeedType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeDate()) {		
			FixUtils.put(out,tradeDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDSubBookType()) {		
			FixUtils.put(out, (long)mDSubBookType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketDepth()) {		
			FixUtils.put(out, (long)marketDepth);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNumReports()) {		
			FixUtils.put(out, (long)totNumReports);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefreshIndicator()) {		
			out.put(refreshIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDReqID()) {		
			FixUtils.put(out,mDReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDStreamID()) {		
			FixUtils.put(out,mDStreamID); 		
		
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
		
		if (hasNetChgPrevDay()) {		
			FixUtils.put(out, (long)netChgPrevDay);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplQueueDepth()) {		
			FixUtils.put(out, (long)applQueueDepth);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplQueueResolution()) {		
			FixUtils.put(out, (long)applQueueResolution);
		
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
			
	public void crackMDReportID() {		
		getMDReportID();		
	}		
			
	public long getMDReportID() { 		
		if ( hasMDReportID()) {		
			if (hasMDReportID == FixUtils.TAG_HAS_VALUE) {		
				return mDReportID; 		
			} else {

				buf.position(hasMDReportID);

			mDReportID = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMDReportID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return mDReportID;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDReportID() { return hasMDReportID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMDReportID(byte[] src) {		
		if (src == null ) return;
		if (hasMDReportID()) mDReportID = FixUtils.TAG_HAS_NO_VALUE;		
		mDReportID = FixUtils.longValueOf(src, 0, src.length);
		hasMDReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDReportID(long src) {		
		mDReportID = src;
		hasMDReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDReportID(String str) {		
		if (str == null ) return;
		if (hasMDReportID()) mDReportID = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDReportID = FixUtils.longValueOf(src, 0, src.length);
		hasMDReportID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackMDBookType() {		
		getMDBookType();		
	}		
			
	public long getMDBookType() { 		
		if ( hasMDBookType()) {		
			if (hasMDBookType == FixUtils.TAG_HAS_VALUE) {		
				return mDBookType; 		
			} else {

				buf.position(hasMDBookType);

			mDBookType = FixMessage.getTagIntValue(buf, err);
		
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
			
	public void crackMDFeedType() {		
		getMDFeedType();		
	}		
			
	public byte[] getMDFeedType() { 		
		if ( hasMDFeedType()) {		
			if (hasMDFeedType == FixUtils.TAG_HAS_VALUE) {		
				return mDFeedType; 		
			} else {

				buf.position(hasMDFeedType);

			FixMessage.getTagStringValue(buf, mDFeedType, 0, mDFeedType.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMDFeedType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return mDFeedType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDFeedType() { return hasMDFeedType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMDFeedType(byte[] src) {		
		if (src == null ) return;
		if (hasMDFeedType()) FixUtils.fillNul(mDFeedType);		
		FixUtils.copy(mDFeedType, src); 		
		hasMDFeedType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDFeedType(String str) {		
		if (str == null ) return;
		if (hasMDFeedType()) FixUtils.fillNul(mDFeedType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDFeedType, src); 		
		hasMDFeedType = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackMDSubBookType() {		
		getMDSubBookType();		
	}		
			
	public long getMDSubBookType() { 		
		if ( hasMDSubBookType()) {		
			if (hasMDSubBookType == FixUtils.TAG_HAS_VALUE) {		
				return mDSubBookType; 		
			} else {

				buf.position(hasMDSubBookType);

			mDSubBookType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMDSubBookType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return mDSubBookType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDSubBookType() { return hasMDSubBookType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMDSubBookType(byte[] src) {		
		if (src == null ) return;
		if (hasMDSubBookType()) mDSubBookType = FixUtils.TAG_HAS_NO_VALUE;		
		mDSubBookType = FixUtils.longValueOf(src, 0, src.length);
		hasMDSubBookType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDSubBookType(long src) {		
		mDSubBookType = src;
		hasMDSubBookType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDSubBookType(String str) {		
		if (str == null ) return;
		if (hasMDSubBookType()) mDSubBookType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDSubBookType = FixUtils.longValueOf(src, 0, src.length);
		hasMDSubBookType = FixUtils.TAG_HAS_VALUE;		
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

			marketDepth = FixMessage.getTagIntValue(buf, err);
		
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
			
	public void crackTotNumReports() {		
		getTotNumReports();		
	}		
			
	public long getTotNumReports() { 		
		if ( hasTotNumReports()) {		
			if (hasTotNumReports == FixUtils.TAG_HAS_VALUE) {		
				return totNumReports; 		
			} else {

				buf.position(hasTotNumReports);

			totNumReports = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotNumReports = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totNumReports;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNumReports() { return hasTotNumReports != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotNumReports(byte[] src) {		
		if (src == null ) return;
		if (hasTotNumReports()) totNumReports = FixUtils.TAG_HAS_NO_VALUE;		
		totNumReports = FixUtils.longValueOf(src, 0, src.length);
		hasTotNumReports = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNumReports(long src) {		
		totNumReports = src;
		hasTotNumReports = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNumReports(String str) {		
		if (str == null ) return;
		if (hasTotNumReports()) totNumReports = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNumReports = FixUtils.longValueOf(src, 0, src.length);
		hasTotNumReports = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRefreshIndicator() {		
		getRefreshIndicator();		
	}		
			
	public boolean getRefreshIndicator() { 		
		if ( hasRefreshIndicator()) {		
			if (hasRefreshIndicator == FixUtils.TAG_HAS_VALUE) {		
				return refreshIndicator; 		
			} else {

				buf.position(hasRefreshIndicator);

			refreshIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasRefreshIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return refreshIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasRefreshIndicator() { return hasRefreshIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRefreshIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasRefreshIndicator()) refreshIndicator = false;		
		refreshIndicator = src[0]==(byte)'Y'?true:false;		
		hasRefreshIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefreshIndicator(boolean src) {		
		refreshIndicator = src;
		hasRefreshIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefreshIndicator(String str) {		
		if (str == null ) return;
		if (hasRefreshIndicator()) refreshIndicator = false;		
		byte[] src = str.getBytes(); 		
		refreshIndicator = src[0]==(byte)'Y'?true:false;		
		hasRefreshIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMDReqID() {		
		getMDReqID();		
	}		
			
	public byte[] getMDReqID() { 		
		if ( hasMDReqID()) {		
			if (hasMDReqID == FixUtils.TAG_HAS_VALUE) {		
				return mDReqID; 		
			} else {

				buf.position(hasMDReqID);

			FixMessage.getTagStringValue(buf, mDReqID, 0, mDReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMDReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return mDReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDReqID() { return hasMDReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMDReqID(byte[] src) {		
		if (src == null ) return;
		if (hasMDReqID()) FixUtils.fillNul(mDReqID);		
		FixUtils.copy(mDReqID, src); 		
		hasMDReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDReqID(String str) {		
		if (str == null ) return;
		if (hasMDReqID()) FixUtils.fillNul(mDReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDReqID, src); 		
		hasMDReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMDStreamID() {		
		getMDStreamID();		
	}		
			
	public byte[] getMDStreamID() { 		
		if ( hasMDStreamID()) {		
			if (hasMDStreamID == FixUtils.TAG_HAS_VALUE) {		
				return mDStreamID; 		
			} else {

				buf.position(hasMDStreamID);

			FixMessage.getTagStringValue(buf, mDStreamID, 0, mDStreamID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return mDStreamID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDStreamID() { return hasMDStreamID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMDStreamID(byte[] src) {		
		if (src == null ) return;
		if (hasMDStreamID()) FixUtils.fillNul(mDStreamID);		
		FixUtils.copy(mDStreamID, src); 		
		hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDStreamID(String str) {		
		if (str == null ) return;
		if (hasMDStreamID()) FixUtils.fillNul(mDStreamID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDStreamID, src); 		
		hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, financialStatus, 0, financialStatus.length, err);
		
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

			FixMessage.getTagStringValue(buf, corporateAction, 0, corporateAction.length, err);
		
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
			
	public void crackNetChgPrevDay() {		
		getNetChgPrevDay();		
	}		
			
	public long getNetChgPrevDay() { 		
		if ( hasNetChgPrevDay()) {		
			if (hasNetChgPrevDay == FixUtils.TAG_HAS_VALUE) {		
				return netChgPrevDay; 		
			} else {

				buf.position(hasNetChgPrevDay);

			netChgPrevDay = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasNetChgPrevDay = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return netChgPrevDay;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNetChgPrevDay() { return hasNetChgPrevDay != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNetChgPrevDay(byte[] src) {		
		if (src == null ) return;
		if (hasNetChgPrevDay()) netChgPrevDay = FixUtils.TAG_HAS_NO_VALUE;		
		netChgPrevDay = FixUtils.longValueOf(src, 0, src.length);
		hasNetChgPrevDay = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetChgPrevDay(long src) {		
		netChgPrevDay = src;
		hasNetChgPrevDay = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetChgPrevDay(String str) {		
		if (str == null ) return;
		if (hasNetChgPrevDay()) netChgPrevDay = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		netChgPrevDay = FixUtils.longValueOf(src, 0, src.length);
		hasNetChgPrevDay = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackApplQueueDepth() {		
		getApplQueueDepth();		
	}		
			
	public long getApplQueueDepth() { 		
		if ( hasApplQueueDepth()) {		
			if (hasApplQueueDepth == FixUtils.TAG_HAS_VALUE) {		
				return applQueueDepth; 		
			} else {

				buf.position(hasApplQueueDepth);

			applQueueDepth = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasApplQueueDepth = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return applQueueDepth;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplQueueDepth() { return hasApplQueueDepth != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setApplQueueDepth(byte[] src) {		
		if (src == null ) return;
		if (hasApplQueueDepth()) applQueueDepth = FixUtils.TAG_HAS_NO_VALUE;		
		applQueueDepth = FixUtils.longValueOf(src, 0, src.length);
		hasApplQueueDepth = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplQueueDepth(long src) {		
		applQueueDepth = src;
		hasApplQueueDepth = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplQueueDepth(String str) {		
		if (str == null ) return;
		if (hasApplQueueDepth()) applQueueDepth = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applQueueDepth = FixUtils.longValueOf(src, 0, src.length);
		hasApplQueueDepth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackApplQueueResolution() {		
		getApplQueueResolution();		
	}		
			
	public long getApplQueueResolution() { 		
		if ( hasApplQueueResolution()) {		
			if (hasApplQueueResolution == FixUtils.TAG_HAS_VALUE) {		
				return applQueueResolution; 		
			} else {

				buf.position(hasApplQueueResolution);

			applQueueResolution = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasApplQueueResolution = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return applQueueResolution;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplQueueResolution() { return hasApplQueueResolution != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setApplQueueResolution(byte[] src) {		
		if (src == null ) return;
		if (hasApplQueueResolution()) applQueueResolution = FixUtils.TAG_HAS_NO_VALUE;		
		applQueueResolution = FixUtils.longValueOf(src, 0, src.length);
		hasApplQueueResolution = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplQueueResolution(long src) {		
		applQueueResolution = src;
		hasApplQueueResolution = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplQueueResolution(String str) {		
		if (str == null ) return;
		if (hasApplQueueResolution()) applQueueResolution = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applQueueResolution = FixUtils.longValueOf(src, 0, src.length);
		hasApplQueueResolution = FixUtils.TAG_HAS_VALUE;		
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

					if (hasMDReportID()) s += "MDReportID(963)= " + getMDReportID() + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasMDBookType()) s += "MDBookType(1021)= " + getMDBookType() + "\n" ; 
		if (hasMDFeedType()) s += "MDFeedType(1022)= " + new String( FixUtils.trim(getMDFeedType()) ) + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasMDSubBookType()) s += "MDSubBookType(1173)= " + getMDSubBookType() + "\n" ; 
		if (hasMarketDepth()) s += "MarketDepth(264)= " + getMarketDepth() + "\n" ; 
		if (hasTotNumReports()) s += "TotNumReports(911)= " + getTotNumReports() + "\n" ; 
		if (hasRefreshIndicator()) s += "RefreshIndicator(1187)= " + getRefreshIndicator() + "\n" ; 
		if (hasMDReqID()) s += "MDReqID(262)= " + new String( FixUtils.trim(getMDReqID()) ) + "\n" ; 
		if (hasMDStreamID()) s += "MDStreamID(1500)= " + new String( FixUtils.trim(getMDStreamID()) ) + "\n" ; 
		if (hasFinancialStatus()) s += "FinancialStatus(291)= " + new String( FixUtils.trim(getFinancialStatus()) ) + "\n" ; 
		if (hasCorporateAction()) s += "CorporateAction(292)= " + new String( FixUtils.trim(getCorporateAction()) ) + "\n" ; 
		if (hasNetChgPrevDay()) s += "NetChgPrevDay(451)= " + getNetChgPrevDay() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasApplQueueDepth()) s += "ApplQueueDepth(813)= " + getApplQueueDepth() + "\n" ; 
		if (hasApplQueueResolution()) s += "ApplQueueResolution(814)= " + getApplQueueResolution() + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixMarketDataSnapshotFullRefresh)) return false;

		FixMarketDataSnapshotFullRefresh msg = (FixMarketDataSnapshotFullRefresh) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasMDReportID() && !msg.hasMDReportID()) || (!hasMDReportID() && msg.hasMDReportID())) return false;
		if (!(!hasMDReportID() && !msg.hasMDReportID()) && !(getMDReportID()==msg.getMDReportID())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if ((hasMDBookType() && !msg.hasMDBookType()) || (!hasMDBookType() && msg.hasMDBookType())) return false;
		if (!(!hasMDBookType() && !msg.hasMDBookType()) && !(getMDBookType()==msg.getMDBookType())) return false;
		if ((hasMDFeedType() && !msg.hasMDFeedType()) || (!hasMDFeedType() && msg.hasMDFeedType())) return false;
		if (!(!hasMDFeedType() && !msg.hasMDFeedType()) && !FixUtils.equals(getMDFeedType(), msg.getMDFeedType())) return false;
		if ((hasTradeDate() && !msg.hasTradeDate()) || (!hasTradeDate() && msg.hasTradeDate())) return false;
		if ((hasMDSubBookType() && !msg.hasMDSubBookType()) || (!hasMDSubBookType() && msg.hasMDSubBookType())) return false;
		if (!(!hasMDSubBookType() && !msg.hasMDSubBookType()) && !(getMDSubBookType()==msg.getMDSubBookType())) return false;
		if ((hasMarketDepth() && !msg.hasMarketDepth()) || (!hasMarketDepth() && msg.hasMarketDepth())) return false;
		if (!(!hasMarketDepth() && !msg.hasMarketDepth()) && !(getMarketDepth()==msg.getMarketDepth())) return false;
		if ((hasTotNumReports() && !msg.hasTotNumReports()) || (!hasTotNumReports() && msg.hasTotNumReports())) return false;
		if (!(!hasTotNumReports() && !msg.hasTotNumReports()) && !(getTotNumReports()==msg.getTotNumReports())) return false;
		if ((hasRefreshIndicator() && !msg.hasRefreshIndicator()) || (!hasRefreshIndicator() && msg.hasRefreshIndicator())) return false;
		if (!(!hasRefreshIndicator() && !msg.hasRefreshIndicator()) && !(getRefreshIndicator()==msg.getRefreshIndicator())) return false;
		if ((hasMDReqID() && !msg.hasMDReqID()) || (!hasMDReqID() && msg.hasMDReqID())) return false;
		if (!(!hasMDReqID() && !msg.hasMDReqID()) && !FixUtils.equals(getMDReqID(), msg.getMDReqID())) return false;
		if ((hasMDStreamID() && !msg.hasMDStreamID()) || (!hasMDStreamID() && msg.hasMDStreamID())) return false;
		if (!(!hasMDStreamID() && !msg.hasMDStreamID()) && !FixUtils.equals(getMDStreamID(), msg.getMDStreamID())) return false;
		if ((hasFinancialStatus() && !msg.hasFinancialStatus()) || (!hasFinancialStatus() && msg.hasFinancialStatus())) return false;
		if (!(!hasFinancialStatus() && !msg.hasFinancialStatus()) && !FixUtils.equals(getFinancialStatus(), msg.getFinancialStatus())) return false;
		if ((hasCorporateAction() && !msg.hasCorporateAction()) || (!hasCorporateAction() && msg.hasCorporateAction())) return false;
		if (!(!hasCorporateAction() && !msg.hasCorporateAction()) && !FixUtils.equals(getCorporateAction(), msg.getCorporateAction())) return false;
		if ((hasNetChgPrevDay() && !msg.hasNetChgPrevDay()) || (!hasNetChgPrevDay() && msg.hasNetChgPrevDay())) return false;
		if (!(!hasNetChgPrevDay() && !msg.hasNetChgPrevDay()) && !(getNetChgPrevDay()==msg.getNetChgPrevDay())) return false;
		if ((hasApplQueueDepth() && !msg.hasApplQueueDepth()) || (!hasApplQueueDepth() && msg.hasApplQueueDepth())) return false;
		if (!(!hasApplQueueDepth() && !msg.hasApplQueueDepth()) && !(getApplQueueDepth()==msg.getApplQueueDepth())) return false;
		if ((hasApplQueueResolution() && !msg.hasApplQueueResolution()) || (!hasApplQueueResolution() && msg.hasApplQueueResolution())) return false;
		if (!(!hasApplQueueResolution() && !msg.hasApplQueueResolution()) && !(getApplQueueResolution()==msg.getApplQueueResolution())) return false;
		return true;
	}
	@Override
	public FixMarketDataSnapshotFullRefresh clone () {
		FixMarketDataSnapshotFullRefresh out = new FixMarketDataSnapshotFullRefresh();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixMarketDataSnapshotFullRefresh clone ( FixMarketDataSnapshotFullRefresh out ) {
		if ( hasMDReportID())
			out.setMDReportID(getMDReportID());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasMDBookType())
			out.setMDBookType(getMDBookType());
		if ( hasMDFeedType())
			out.setMDFeedType(getMDFeedType());
		if ( hasTradeDate())
			out.setTradeDate(getTradeDate());
		if ( hasMDSubBookType())
			out.setMDSubBookType(getMDSubBookType());
		if ( hasMarketDepth())
			out.setMarketDepth(getMarketDepth());
		if ( hasTotNumReports())
			out.setTotNumReports(getTotNumReports());
		if ( hasRefreshIndicator())
			out.setRefreshIndicator(getRefreshIndicator());
		if ( hasMDReqID())
			out.setMDReqID(getMDReqID());
		if ( hasMDStreamID())
			out.setMDStreamID(getMDStreamID());
		if ( hasFinancialStatus())
			out.setFinancialStatus(getFinancialStatus());
		if ( hasCorporateAction())
			out.setCorporateAction(getCorporateAction());
		if ( hasNetChgPrevDay())
			out.setNetChgPrevDay(getNetChgPrevDay());
		if ( hasApplQueueDepth())
			out.setApplQueueDepth(getApplQueueDepth());
		if ( hasApplQueueResolution())
			out.setApplQueueResolution(getApplQueueResolution());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
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
		count = 0;
		for (FixMDFullGrp fixMDFullGrp : mDFullGrp) {
			if (!fixMDFullGrp.hasGroup()) continue;
			out.mDFullGrp[count] = fixMDFullGrp.clone( out.mDFullGrp[count] );
			count++;
		}
		count = 0;
		for (FixRoutingGrp fixRoutingGrp : routingGrp) {
			if (!fixRoutingGrp.hasGroup()) continue;
			out.routingGrp[count] = fixRoutingGrp.clone( out.routingGrp[count] );
			count++;
		}
		return out;
	}

}
