package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixMarketDataIncrementalRefresh extends FixInMessage {
	private short hasMDBookType;
	long mDBookType = 0;		
	private short hasMDFeedType;
	byte[] mDFeedType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeDate;
	byte[] tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDReqID;
	byte[] mDReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasApplQueueDepth;
	long applQueueDepth = 0;		
	private short hasApplQueueResolution;
	long applQueueResolution = 0;		
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixMDIncGrp[] mDIncGrp;
	public FixRoutingGrp[] routingGrp;
	
	public FixMarketDataIncrementalRefresh() {
		super(FixMessageInfo.MessageTypes.MARKETDATAINCREMENTALREFRESH);


		hasMDBookType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDFeedType = FixUtils.TAG_HAS_NO_VALUE;		
		mDFeedType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDReqID = FixUtils.TAG_HAS_NO_VALUE;		
		mDReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasApplQueueDepth = FixUtils.TAG_HAS_NO_VALUE;		
		hasApplQueueResolution = FixUtils.TAG_HAS_NO_VALUE;		
		applicationSequenceControl = new FixApplicationSequenceControl();
		mDIncGrp = new FixMDIncGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) mDIncGrp[i] = new FixMDIncGrp();
		routingGrp = new FixRoutingGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) routingGrp[i] = new FixRoutingGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.MDBOOKTYPE_INT:		
            		hasMDBookType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MDFEEDTYPE_INT:		
            		hasMDFeedType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEDATE_INT:		
            		hasTradeDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MDREQID_INT:		
            		hasMDReqID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.APPLQUEUEDEPTH_INT:		
            		hasApplQueueDepth = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.APPLQUEUERESOLUTION_INT:		
            		hasApplQueueResolution = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOMDENTRIES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !mDIncGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = mDIncGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.MARKETDATAINCREMENTALREFRESH_INT);
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
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (mDIncGrp[i].hasGroup()) mDIncGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		return true;
	}
	@Override		
	public void getAll() {		
		getMDBookType();		
		getMDFeedType();		
		getTradeDate();		
		getMDReqID();		
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
		if (hasMDReqID()) {		
			out.put(FixTags.MDREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,mDReqID); 		
		
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
		if (FixUtils.getNoInGroup(mDIncGrp)>0) {
			out.put(FixTags.NOMDENTRIES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(mDIncGrp));

			out.put(FixUtils.SOH);

		}
		for (FixMDIncGrp fixMDIncGrp : mDIncGrp) if (fixMDIncGrp.hasGroup()) fixMDIncGrp.encode(out);
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
		
		if (hasMDReqID()) {		
			FixUtils.put(out,mDReqID); 		
		
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
			
	public void crackMDFeedType() {		
		getMDFeedType();		
	}		
			
	public byte[] getMDFeedType() { 		
		if ( hasMDFeedType()) {		
			if (hasMDFeedType == FixUtils.TAG_HAS_VALUE) {		
				return mDFeedType; 		
			} else {

				buf.position(hasMDFeedType);

			FixUtils.getTagStringValue(buf, mDFeedType, 0, mDFeedType.length, err);
		
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

			FixUtils.getTagStringValue(buf, tradeDate, 0, tradeDate.length, err);
		
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
			
	public void crackMDReqID() {		
		getMDReqID();		
	}		
			
	public byte[] getMDReqID() { 		
		if ( hasMDReqID()) {		
			if (hasMDReqID == FixUtils.TAG_HAS_VALUE) {		
				return mDReqID; 		
			} else {

				buf.position(hasMDReqID);

			FixUtils.getTagStringValue(buf, mDReqID, 0, mDReqID.length, err);
		
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
			
	public void crackApplQueueDepth() {		
		getApplQueueDepth();		
	}		
			
	public long getApplQueueDepth() { 		
		if ( hasApplQueueDepth()) {		
			if (hasApplQueueDepth == FixUtils.TAG_HAS_VALUE) {		
				return applQueueDepth; 		
			} else {

				buf.position(hasApplQueueDepth);

			applQueueDepth = FixUtils.getTagIntValue(buf, err);
		
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

			applQueueResolution = FixUtils.getTagIntValue(buf, err);
		
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

					if (hasMDBookType()) s += "MDBookType(1021)= " + getMDBookType() + "\n" ; 
		if (hasMDFeedType()) s += "MDFeedType(1022)= " + new String( FixUtils.trim(getMDFeedType()) ) + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasMDReqID()) s += "MDReqID(262)= " + new String( FixUtils.trim(getMDReqID()) ) + "\n" ; 
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
		if (! ( o instanceof FixMarketDataIncrementalRefresh)) return false;

		FixMarketDataIncrementalRefresh msg = (FixMarketDataIncrementalRefresh) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasMDBookType() && !msg.hasMDBookType()) || (!hasMDBookType() && msg.hasMDBookType())) return false;
		if (!(!hasMDBookType() && !msg.hasMDBookType()) && !(getMDBookType()==msg.getMDBookType())) return false;
		if ((hasMDFeedType() && !msg.hasMDFeedType()) || (!hasMDFeedType() && msg.hasMDFeedType())) return false;
		if (!(!hasMDFeedType() && !msg.hasMDFeedType()) && !FixUtils.equals(getMDFeedType(), msg.getMDFeedType())) return false;
		if ((hasTradeDate() && !msg.hasTradeDate()) || (!hasTradeDate() && msg.hasTradeDate())) return false;
		if ((hasMDReqID() && !msg.hasMDReqID()) || (!hasMDReqID() && msg.hasMDReqID())) return false;
		if (!(!hasMDReqID() && !msg.hasMDReqID()) && !FixUtils.equals(getMDReqID(), msg.getMDReqID())) return false;
		if ((hasApplQueueDepth() && !msg.hasApplQueueDepth()) || (!hasApplQueueDepth() && msg.hasApplQueueDepth())) return false;
		if (!(!hasApplQueueDepth() && !msg.hasApplQueueDepth()) && !(getApplQueueDepth()==msg.getApplQueueDepth())) return false;
		if ((hasApplQueueResolution() && !msg.hasApplQueueResolution()) || (!hasApplQueueResolution() && msg.hasApplQueueResolution())) return false;
		if (!(!hasApplQueueResolution() && !msg.hasApplQueueResolution()) && !(getApplQueueResolution()==msg.getApplQueueResolution())) return false;
		return true;
	}
	@Override
	public FixMarketDataIncrementalRefresh clone () {
		FixMarketDataIncrementalRefresh out = new FixMarketDataIncrementalRefresh();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixMarketDataIncrementalRefresh clone ( FixMarketDataIncrementalRefresh out ) {
		if ( hasMDBookType())
			out.setMDBookType(getMDBookType());
		if ( hasMDFeedType())
			out.setMDFeedType(getMDFeedType());
		if ( hasTradeDate())
			out.setTradeDate(getTradeDate());
		if ( hasMDReqID())
			out.setMDReqID(getMDReqID());
		if ( hasApplQueueDepth())
			out.setApplQueueDepth(getApplQueueDepth());
		if ( hasApplQueueResolution())
			out.setApplQueueResolution(getApplQueueResolution());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		int count = 0;
		count = 0;
		for (FixMDIncGrp fixMDIncGrp : mDIncGrp) {
			if (!fixMDIncGrp.hasGroup()) continue;
			out.mDIncGrp[count] = fixMDIncGrp.clone( out.mDIncGrp[count] );
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
