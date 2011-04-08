package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixMarketDataRequest extends FixInMessage {
	private short hasMDReqID;
	byte[] mDReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSubscriptionRequestType;
	byte subscriptionRequestType = (byte)' ';		
	private short hasMarketDepth;
	long marketDepth = 0;		
	private short hasMDUpdateType;
	long mDUpdateType = 0;		
	private short hasAggregatedBook;
		boolean aggregatedBook = false;		
	private short hasOpenCloseSettlFlag;
	byte[] openCloseSettlFlag = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasScope;
	byte[] scope = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDImplicitDelete;
		boolean mDImplicitDelete = false;		
	private short hasApplQueueAction;
	long applQueueAction = 0;		
	private short hasApplQueueMax;
	long applQueueMax = 0;		
	private short hasMDQuoteType;
	long mDQuoteType = 0;		
	public FixParties[] parties;
	public FixMDReqGrp[] mDReqGrp;
	public FixInstrmtMDReqGrp[] instrmtMDReqGrp;
	public FixTrdgSesGrp[] trdgSesGrp;
	
	public FixMarketDataRequest() {
		super(FixMessageInfo.MessageTypes.MARKETDATAREQUEST);


		hasMDReqID = FixUtils.TAG_HAS_NO_VALUE;		
		mDReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSubscriptionRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMarketDepth = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDUpdateType = FixUtils.TAG_HAS_NO_VALUE;		
		hasAggregatedBook = FixUtils.TAG_HAS_NO_VALUE;		
		hasOpenCloseSettlFlag = FixUtils.TAG_HAS_NO_VALUE;		
		openCloseSettlFlag = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasScope = FixUtils.TAG_HAS_NO_VALUE;		
		scope = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDImplicitDelete = FixUtils.TAG_HAS_NO_VALUE;		
		hasApplQueueAction = FixUtils.TAG_HAS_NO_VALUE;		
		hasApplQueueMax = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDQuoteType = FixUtils.TAG_HAS_NO_VALUE;		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		mDReqGrp = new FixMDReqGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) mDReqGrp[i] = new FixMDReqGrp();
		instrmtMDReqGrp = new FixInstrmtMDReqGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtMDReqGrp[i] = new FixInstrmtMDReqGrp();
		trdgSesGrp = new FixTrdgSesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdgSesGrp[i] = new FixTrdgSesGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.MDREQID_INT:		
            		hasMDReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SUBSCRIPTIONREQUESTTYPE_INT:		
            		hasSubscriptionRequestType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MARKETDEPTH_INT:		
            		hasMarketDepth = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MDUPDATETYPE_INT:		
            		hasMDUpdateType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AGGREGATEDBOOK_INT:		
            		hasAggregatedBook = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.OPENCLOSESETTLFLAG_INT:		
            		hasOpenCloseSettlFlag = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SCOPE_INT:		
            		hasScope = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MDIMPLICITDELETE_INT:		
            		hasMDImplicitDelete = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.APPLQUEUEACTION_INT:		
            		hasApplQueueAction = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.APPLQUEUEMAX_INT:		
            		hasApplQueueMax = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MDQUOTETYPE_INT:		
            		hasMDQuoteType = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOMDENTRYTYPES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !mDReqGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = mDReqGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NORELATEDSYM_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtMDReqGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = instrmtMDReqGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOTRADINGSESSIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdgSesGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdgSesGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.MARKETDATAREQUEST);
                			break;
                		}
					}

			}

        		if (err.hasError()) return;

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	public boolean hasRequiredTags(FixValidationError err) {
		standardHeader.hasRequiredTags(err); if (err.hasError()) return false; 

		if (!hasMDReqID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.MDREQID_INT, FixMessageInfo.MessageTypes.MARKETDATAREQUEST);
			return false;
		}
		if (!hasSubscriptionRequestType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.SUBSCRIPTIONREQUESTTYPE_INT, FixMessageInfo.MessageTypes.MARKETDATAREQUEST);
			return false;
		}
		if (!hasMarketDepth()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.MARKETDEPTH_INT, FixMessageInfo.MessageTypes.MARKETDATAREQUEST);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (mDReqGrp[i].hasGroup()) mDReqGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (instrmtMDReqGrp[i].hasGroup()) instrmtMDReqGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getMDReqID();		
		getSubscriptionRequestType();		
		getMarketDepth();		
		getMDUpdateType();		
		getAggregatedBook();		
		getOpenCloseSettlFlag();		
		getScope();		
		getMDImplicitDelete();		
		getApplQueueAction();		
		getApplQueueMax();		
		getMDQuoteType();		
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
		if (hasMDReqID()) {		
			out.put(FixTags.MDREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,mDReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSubscriptionRequestType()) {		
			out.put(FixTags.SUBSCRIPTIONREQUESTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,subscriptionRequestType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMarketDepth()) {		
			out.put(FixTags.MARKETDEPTH);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)marketDepth);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMDUpdateType()) {		
			out.put(FixTags.MDUPDATETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)mDUpdateType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAggregatedBook()) {		
			out.put(FixTags.AGGREGATEDBOOK);		
		
			out.put((byte) '=');		
		
			out.put(aggregatedBook?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOpenCloseSettlFlag()) {		
			out.put(FixTags.OPENCLOSESETTLFLAG);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,openCloseSettlFlag); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasScope()) {		
			out.put(FixTags.SCOPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,scope); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMDImplicitDelete()) {		
			out.put(FixTags.MDIMPLICITDELETE);		
		
			out.put((byte) '=');		
		
			out.put(mDImplicitDelete?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasApplQueueAction()) {		
			out.put(FixTags.APPLQUEUEACTION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)applQueueAction);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasApplQueueMax()) {		
			out.put(FixTags.APPLQUEUEMAX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)applQueueMax);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMDQuoteType()) {		
			out.put(FixTags.MDQUOTETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)mDQuoteType);
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(mDReqGrp)>0) {
			out.put(FixTags.NOMDENTRYTYPES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(mDReqGrp));

			out.put(FixUtils.SOH);

		}
		for (FixMDReqGrp fixMDReqGrp : mDReqGrp) if (fixMDReqGrp.hasGroup()) fixMDReqGrp.encode(out);
		if (FixUtils.getNoInGroup(instrmtMDReqGrp)>0) {
			out.put(FixTags.NORELATEDSYM);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtMDReqGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtMDReqGrp fixInstrmtMDReqGrp : instrmtMDReqGrp) if (fixInstrmtMDReqGrp.hasGroup()) fixInstrmtMDReqGrp.encode(out);
		if (FixUtils.getNoInGroup(trdgSesGrp)>0) {
			out.put(FixTags.NOTRADINGSESSIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdgSesGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTrdgSesGrp fixTrdgSesGrp : trdgSesGrp) if (fixTrdgSesGrp.hasGroup()) fixTrdgSesGrp.encode(out);
		
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
		
		if (hasMDReqID()) {		
			FixUtils.put(out,mDReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSubscriptionRequestType()) {		
			FixUtils.put(out,subscriptionRequestType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketDepth()) {		
			FixUtils.put(out, (long)marketDepth);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDUpdateType()) {		
			FixUtils.put(out, (long)mDUpdateType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAggregatedBook()) {		
			out.put(aggregatedBook?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOpenCloseSettlFlag()) {		
			FixUtils.put(out,openCloseSettlFlag); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasScope()) {		
			FixUtils.put(out,scope); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDImplicitDelete()) {		
			out.put(mDImplicitDelete?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplQueueAction()) {		
			FixUtils.put(out, (long)applQueueAction);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplQueueMax()) {		
			FixUtils.put(out, (long)applQueueMax);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDQuoteType()) {		
			FixUtils.put(out, (long)mDQuoteType);
		
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
			
	public void crackSubscriptionRequestType() {		
		getSubscriptionRequestType();		
	}		
			
	public byte getSubscriptionRequestType() { 		
		if ( hasSubscriptionRequestType()) {		
			if (hasSubscriptionRequestType == FixUtils.TAG_HAS_VALUE) {		
				return subscriptionRequestType; 		
			} else {

				buf.position(hasSubscriptionRequestType);

			subscriptionRequestType = FixMessage.getTagCharValue(buf, err);
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
			
	public void crackMDUpdateType() {		
		getMDUpdateType();		
	}		
			
	public long getMDUpdateType() { 		
		if ( hasMDUpdateType()) {		
			if (hasMDUpdateType == FixUtils.TAG_HAS_VALUE) {		
				return mDUpdateType; 		
			} else {

				buf.position(hasMDUpdateType);

			mDUpdateType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMDUpdateType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return mDUpdateType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDUpdateType() { return hasMDUpdateType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMDUpdateType(byte[] src) {		
		if (src == null ) return;
		if (hasMDUpdateType()) mDUpdateType = FixUtils.TAG_HAS_NO_VALUE;		
		mDUpdateType = FixUtils.longValueOf(src, 0, src.length);
		hasMDUpdateType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDUpdateType(long src) {		
		mDUpdateType = src;
		hasMDUpdateType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDUpdateType(String str) {		
		if (str == null ) return;
		if (hasMDUpdateType()) mDUpdateType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDUpdateType = FixUtils.longValueOf(src, 0, src.length);
		hasMDUpdateType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAggregatedBook() {		
		getAggregatedBook();		
	}		
			
	public boolean getAggregatedBook() { 		
		if ( hasAggregatedBook()) {		
			if (hasAggregatedBook == FixUtils.TAG_HAS_VALUE) {		
				return aggregatedBook; 		
			} else {

				buf.position(hasAggregatedBook);

			aggregatedBook = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasAggregatedBook = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return aggregatedBook;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasAggregatedBook() { return hasAggregatedBook != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAggregatedBook(byte[] src) {		
		if (src == null ) return;
		if (hasAggregatedBook()) aggregatedBook = false;		
		aggregatedBook = src[0]==(byte)'Y'?true:false;		
		hasAggregatedBook = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAggregatedBook(boolean src) {		
		aggregatedBook = src;
		hasAggregatedBook = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAggregatedBook(String str) {		
		if (str == null ) return;
		if (hasAggregatedBook()) aggregatedBook = false;		
		byte[] src = str.getBytes(); 		
		aggregatedBook = src[0]==(byte)'Y'?true:false;		
		hasAggregatedBook = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOpenCloseSettlFlag() {		
		getOpenCloseSettlFlag();		
	}		
			
	public byte[] getOpenCloseSettlFlag() { 		
		if ( hasOpenCloseSettlFlag()) {		
			if (hasOpenCloseSettlFlag == FixUtils.TAG_HAS_VALUE) {		
				return openCloseSettlFlag; 		
			} else {

				buf.position(hasOpenCloseSettlFlag);

			FixMessage.getTagStringValue(buf, openCloseSettlFlag, 0, openCloseSettlFlag.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOpenCloseSettlFlag = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return openCloseSettlFlag;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOpenCloseSettlFlag() { return hasOpenCloseSettlFlag != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOpenCloseSettlFlag(byte[] src) {		
		if (src == null ) return;
		if (hasOpenCloseSettlFlag()) FixUtils.fillNul(openCloseSettlFlag);		
		FixUtils.copy(openCloseSettlFlag, src); 		
		hasOpenCloseSettlFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOpenCloseSettlFlag(String str) {		
		if (str == null ) return;
		if (hasOpenCloseSettlFlag()) FixUtils.fillNul(openCloseSettlFlag);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(openCloseSettlFlag, src); 		
		hasOpenCloseSettlFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackScope() {		
		getScope();		
	}		
			
	public byte[] getScope() { 		
		if ( hasScope()) {		
			if (hasScope == FixUtils.TAG_HAS_VALUE) {		
				return scope; 		
			} else {

				buf.position(hasScope);

			FixMessage.getTagStringValue(buf, scope, 0, scope.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasScope = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return scope;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasScope() { return hasScope != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setScope(byte[] src) {		
		if (src == null ) return;
		if (hasScope()) FixUtils.fillNul(scope);		
		FixUtils.copy(scope, src); 		
		hasScope = FixUtils.TAG_HAS_VALUE;		
	}

	public void setScope(String str) {		
		if (str == null ) return;
		if (hasScope()) FixUtils.fillNul(scope);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(scope, src); 		
		hasScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMDImplicitDelete() {		
		getMDImplicitDelete();		
	}		
			
	public boolean getMDImplicitDelete() { 		
		if ( hasMDImplicitDelete()) {		
			if (hasMDImplicitDelete == FixUtils.TAG_HAS_VALUE) {		
				return mDImplicitDelete; 		
			} else {

				buf.position(hasMDImplicitDelete);

			mDImplicitDelete = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasMDImplicitDelete = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return mDImplicitDelete;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasMDImplicitDelete() { return hasMDImplicitDelete != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMDImplicitDelete(byte[] src) {		
		if (src == null ) return;
		if (hasMDImplicitDelete()) mDImplicitDelete = false;		
		mDImplicitDelete = src[0]==(byte)'Y'?true:false;		
		hasMDImplicitDelete = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDImplicitDelete(boolean src) {		
		mDImplicitDelete = src;
		hasMDImplicitDelete = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDImplicitDelete(String str) {		
		if (str == null ) return;
		if (hasMDImplicitDelete()) mDImplicitDelete = false;		
		byte[] src = str.getBytes(); 		
		mDImplicitDelete = src[0]==(byte)'Y'?true:false;		
		hasMDImplicitDelete = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackApplQueueAction() {		
		getApplQueueAction();		
	}		
			
	public long getApplQueueAction() { 		
		if ( hasApplQueueAction()) {		
			if (hasApplQueueAction == FixUtils.TAG_HAS_VALUE) {		
				return applQueueAction; 		
			} else {

				buf.position(hasApplQueueAction);

			applQueueAction = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasApplQueueAction = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return applQueueAction;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplQueueAction() { return hasApplQueueAction != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setApplQueueAction(byte[] src) {		
		if (src == null ) return;
		if (hasApplQueueAction()) applQueueAction = FixUtils.TAG_HAS_NO_VALUE;		
		applQueueAction = FixUtils.longValueOf(src, 0, src.length);
		hasApplQueueAction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplQueueAction(long src) {		
		applQueueAction = src;
		hasApplQueueAction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplQueueAction(String str) {		
		if (str == null ) return;
		if (hasApplQueueAction()) applQueueAction = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applQueueAction = FixUtils.longValueOf(src, 0, src.length);
		hasApplQueueAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackApplQueueMax() {		
		getApplQueueMax();		
	}		
			
	public long getApplQueueMax() { 		
		if ( hasApplQueueMax()) {		
			if (hasApplQueueMax == FixUtils.TAG_HAS_VALUE) {		
				return applQueueMax; 		
			} else {

				buf.position(hasApplQueueMax);

			applQueueMax = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasApplQueueMax = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return applQueueMax;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplQueueMax() { return hasApplQueueMax != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setApplQueueMax(byte[] src) {		
		if (src == null ) return;
		if (hasApplQueueMax()) applQueueMax = FixUtils.TAG_HAS_NO_VALUE;		
		applQueueMax = FixUtils.longValueOf(src, 0, src.length);
		hasApplQueueMax = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplQueueMax(long src) {		
		applQueueMax = src;
		hasApplQueueMax = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplQueueMax(String str) {		
		if (str == null ) return;
		if (hasApplQueueMax()) applQueueMax = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applQueueMax = FixUtils.longValueOf(src, 0, src.length);
		hasApplQueueMax = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMDQuoteType() {		
		getMDQuoteType();		
	}		
			
	public long getMDQuoteType() { 		
		if ( hasMDQuoteType()) {		
			if (hasMDQuoteType == FixUtils.TAG_HAS_VALUE) {		
				return mDQuoteType; 		
			} else {

				buf.position(hasMDQuoteType);

			mDQuoteType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMDQuoteType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return mDQuoteType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDQuoteType() { return hasMDQuoteType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMDQuoteType(byte[] src) {		
		if (src == null ) return;
		if (hasMDQuoteType()) mDQuoteType = FixUtils.TAG_HAS_NO_VALUE;		
		mDQuoteType = FixUtils.longValueOf(src, 0, src.length);
		hasMDQuoteType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDQuoteType(long src) {		
		mDQuoteType = src;
		hasMDQuoteType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDQuoteType(String str) {		
		if (str == null ) return;
		if (hasMDQuoteType()) mDQuoteType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDQuoteType = FixUtils.longValueOf(src, 0, src.length);
		hasMDQuoteType = FixUtils.TAG_HAS_VALUE;		
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

					if (hasMDReqID()) s += "MDReqID(262)= " + new String( FixUtils.trim(getMDReqID()) ) + "\n" ; 
		if (hasSubscriptionRequestType()) s += "SubscriptionRequestType(263)= " + getSubscriptionRequestType() + "\n" ; 
		if (hasMarketDepth()) s += "MarketDepth(264)= " + getMarketDepth() + "\n" ; 
		if (hasMDUpdateType()) s += "MDUpdateType(265)= " + getMDUpdateType() + "\n" ; 
		if (hasAggregatedBook()) s += "AggregatedBook(266)= " + getAggregatedBook() + "\n" ; 
		if (hasOpenCloseSettlFlag()) s += "OpenCloseSettlFlag(286)= " + new String( FixUtils.trim(getOpenCloseSettlFlag()) ) + "\n" ; 
		if (hasScope()) s += "Scope(546)= " + new String( FixUtils.trim(getScope()) ) + "\n" ; 
		if (hasMDImplicitDelete()) s += "MDImplicitDelete(547)= " + getMDImplicitDelete() + "\n" ; 
		if (hasApplQueueAction()) s += "ApplQueueAction(815)= " + getApplQueueAction() + "\n" ; 
		if (hasApplQueueMax()) s += "ApplQueueMax(812)= " + getApplQueueMax() + "\n" ; 
		if (hasMDQuoteType()) s += "MDQuoteType(1070)= " + getMDQuoteType() + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixMarketDataRequest)) return false;

		FixMarketDataRequest msg = (FixMarketDataRequest) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasMDReqID() && !msg.hasMDReqID()) || (!hasMDReqID() && msg.hasMDReqID())) return false;
		if (!(!hasMDReqID() && !msg.hasMDReqID()) && !FixUtils.equals(getMDReqID(), msg.getMDReqID())) return false;
		if ((hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) || (!hasSubscriptionRequestType() && msg.hasSubscriptionRequestType())) return false;
		if (!(!hasSubscriptionRequestType() && !msg.hasSubscriptionRequestType()) && !(getSubscriptionRequestType()==msg.getSubscriptionRequestType())) return false;
		if ((hasMarketDepth() && !msg.hasMarketDepth()) || (!hasMarketDepth() && msg.hasMarketDepth())) return false;
		if (!(!hasMarketDepth() && !msg.hasMarketDepth()) && !(getMarketDepth()==msg.getMarketDepth())) return false;
		if ((hasMDUpdateType() && !msg.hasMDUpdateType()) || (!hasMDUpdateType() && msg.hasMDUpdateType())) return false;
		if (!(!hasMDUpdateType() && !msg.hasMDUpdateType()) && !(getMDUpdateType()==msg.getMDUpdateType())) return false;
		if ((hasAggregatedBook() && !msg.hasAggregatedBook()) || (!hasAggregatedBook() && msg.hasAggregatedBook())) return false;
		if (!(!hasAggregatedBook() && !msg.hasAggregatedBook()) && !(getAggregatedBook()==msg.getAggregatedBook())) return false;
		if ((hasOpenCloseSettlFlag() && !msg.hasOpenCloseSettlFlag()) || (!hasOpenCloseSettlFlag() && msg.hasOpenCloseSettlFlag())) return false;
		if (!(!hasOpenCloseSettlFlag() && !msg.hasOpenCloseSettlFlag()) && !FixUtils.equals(getOpenCloseSettlFlag(), msg.getOpenCloseSettlFlag())) return false;
		if ((hasScope() && !msg.hasScope()) || (!hasScope() && msg.hasScope())) return false;
		if (!(!hasScope() && !msg.hasScope()) && !FixUtils.equals(getScope(), msg.getScope())) return false;
		if ((hasMDImplicitDelete() && !msg.hasMDImplicitDelete()) || (!hasMDImplicitDelete() && msg.hasMDImplicitDelete())) return false;
		if (!(!hasMDImplicitDelete() && !msg.hasMDImplicitDelete()) && !(getMDImplicitDelete()==msg.getMDImplicitDelete())) return false;
		if ((hasApplQueueAction() && !msg.hasApplQueueAction()) || (!hasApplQueueAction() && msg.hasApplQueueAction())) return false;
		if (!(!hasApplQueueAction() && !msg.hasApplQueueAction()) && !(getApplQueueAction()==msg.getApplQueueAction())) return false;
		if ((hasApplQueueMax() && !msg.hasApplQueueMax()) || (!hasApplQueueMax() && msg.hasApplQueueMax())) return false;
		if (!(!hasApplQueueMax() && !msg.hasApplQueueMax()) && !(getApplQueueMax()==msg.getApplQueueMax())) return false;
		if ((hasMDQuoteType() && !msg.hasMDQuoteType()) || (!hasMDQuoteType() && msg.hasMDQuoteType())) return false;
		if (!(!hasMDQuoteType() && !msg.hasMDQuoteType()) && !(getMDQuoteType()==msg.getMDQuoteType())) return false;
		return true;
	}
	@Override
	public FixMarketDataRequest clone () {
		FixMarketDataRequest out = new FixMarketDataRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixMarketDataRequest clone ( FixMarketDataRequest out ) {
		if ( hasMDReqID())
			out.setMDReqID(getMDReqID());
		if ( hasSubscriptionRequestType())
			out.setSubscriptionRequestType(getSubscriptionRequestType());
		if ( hasMarketDepth())
			out.setMarketDepth(getMarketDepth());
		if ( hasMDUpdateType())
			out.setMDUpdateType(getMDUpdateType());
		if ( hasAggregatedBook())
			out.setAggregatedBook(getAggregatedBook());
		if ( hasOpenCloseSettlFlag())
			out.setOpenCloseSettlFlag(getOpenCloseSettlFlag());
		if ( hasScope())
			out.setScope(getScope());
		if ( hasMDImplicitDelete())
			out.setMDImplicitDelete(getMDImplicitDelete());
		if ( hasApplQueueAction())
			out.setApplQueueAction(getApplQueueAction());
		if ( hasApplQueueMax())
			out.setApplQueueMax(getApplQueueMax());
		if ( hasMDQuoteType())
			out.setMDQuoteType(getMDQuoteType());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixMDReqGrp fixMDReqGrp : mDReqGrp) {
			if (!fixMDReqGrp.hasGroup()) continue;
			out.mDReqGrp[count] = fixMDReqGrp.clone( out.mDReqGrp[count] );
			count++;
		}
		count = 0;
		for (FixInstrmtMDReqGrp fixInstrmtMDReqGrp : instrmtMDReqGrp) {
			if (!fixInstrmtMDReqGrp.hasGroup()) continue;
			out.instrmtMDReqGrp[count] = fixInstrmtMDReqGrp.clone( out.instrmtMDReqGrp[count] );
			count++;
		}
		count = 0;
		for (FixTrdgSesGrp fixTrdgSesGrp : trdgSesGrp) {
			if (!fixTrdgSesGrp.hasGroup()) continue;
			out.trdgSesGrp[count] = fixTrdgSesGrp.clone( out.trdgSesGrp[count] );
			count++;
		}
		return out;
	}

}
