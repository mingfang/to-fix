package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixQuoteCancel extends FixInMessage {
	private short hasQuoteReqID;
	byte[] quoteReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteID;
	byte[] quoteID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteMsgID;
	byte[] quoteMsgID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteCancelType;
	long quoteCancelType = 0;		
	private short hasQuoteType;
	long quoteType = 0;		
	private short hasQuoteResponseLevel;
	long quoteResponseLevel = 0;		
	private short hasAccount;
	byte[] account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAcctIDSource;
	long acctIDSource = 0;		
	private short hasAccountType;
	long accountType = 0;		
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	public FixParties[] parties;
	public FixTargetParties[] targetParties;
	public FixQuotCxlEntriesGrp[] quotCxlEntriesGrp;
	
	public FixQuoteCancel() {
		super(FixMessageInfo.MessageTypes.QUOTECANCEL);


		hasQuoteReqID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteMsgID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteMsgID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteCancelType = FixUtils.TAG_HAS_NO_VALUE;		
		hasQuoteType = FixUtils.TAG_HAS_NO_VALUE;		
		hasQuoteResponseLevel = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;		
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasAccountType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		targetParties = new FixTargetParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) targetParties[i] = new FixTargetParties();
		quotCxlEntriesGrp = new FixQuotCxlEntriesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) quotCxlEntriesGrp[i] = new FixQuotCxlEntriesGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.QUOTEREQID_INT:		
            		hasQuoteReqID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.QUOTEID_INT:		
            		hasQuoteID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.QUOTEMSGID_INT:		
            		hasQuoteMsgID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.QUOTECANCELTYPE_INT:		
            		hasQuoteCancelType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.QUOTETYPE_INT:		
            		hasQuoteType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.QUOTERESPONSELEVEL_INT:		
            		hasQuoteResponseLevel = (short) buf.position();		
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
            	case FixTags.TRADINGSESSIONID_INT:		
            		hasTradingSessionID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADINGSESSIONSUBID_INT:		
            		hasTradingSessionSubID = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOQUOTEENTRIES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !quotCxlEntriesGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOQUOTEENTRIES_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = quotCxlEntriesGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.QUOTECANCEL_INT);
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
		if (!hasQuoteCancelType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.QUOTECANCELTYPE_INT, FixMessageInfo.MessageTypes.QUOTECANCEL_INT);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		getQuoteReqID();		
		getQuoteID();		
		getQuoteMsgID();		
		getQuoteCancelType();		
		getQuoteType();		
		getQuoteResponseLevel();		
		getAccount();		
		getAcctIDSource();		
		getAccountType();		
		getTradingSessionID();		
		getTradingSessionSubID();		
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
		if (hasQuoteReqID()) {		
			out.put(FixTags.QUOTEREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,quoteReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteID()) {		
			out.put(FixTags.QUOTEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,quoteID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteMsgID()) {		
			out.put(FixTags.QUOTEMSGID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,quoteMsgID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteCancelType()) {		
			out.put(FixTags.QUOTECANCELTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)quoteCancelType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteType()) {		
			out.put(FixTags.QUOTETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)quoteType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteResponseLevel()) {		
			out.put(FixTags.QUOTERESPONSELEVEL);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)quoteResponseLevel);
		
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
		if (FixUtils.getNoInGroup(quotCxlEntriesGrp)>0) {
			out.put(FixTags.NOQUOTEENTRIES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(quotCxlEntriesGrp));

			out.put(FixUtils.SOH);

		}
		for (FixQuotCxlEntriesGrp fixQuotCxlEntriesGrp : quotCxlEntriesGrp) if (fixQuotCxlEntriesGrp.hasGroup()) fixQuotCxlEntriesGrp.encode(out);
		
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
		
		if (hasQuoteReqID()) {		
			FixUtils.put(out,quoteReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteID()) {		
			FixUtils.put(out,quoteID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteMsgID()) {		
			FixUtils.put(out,quoteMsgID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteCancelType()) {		
			FixUtils.put(out, (long)quoteCancelType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteType()) {		
			FixUtils.put(out, (long)quoteType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteResponseLevel()) {		
			FixUtils.put(out, (long)quoteResponseLevel);
		
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
		
		if (hasTradingSessionID()) {		
			FixUtils.put(out,tradingSessionID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionSubID()) {		
			FixUtils.put(out,tradingSessionSubID); 		
		
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
			
	public void crackQuoteReqID() {		
		getQuoteReqID();		
	}		
			
	public byte[] getQuoteReqID() { 		
		if ( hasQuoteReqID()) {		
			if (hasQuoteReqID == FixUtils.TAG_HAS_VALUE) {		
				return quoteReqID; 		
			} else {

				buf.position(hasQuoteReqID);

			FixUtils.getTagStringValue(buf, quoteReqID, 0, quoteReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasQuoteReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteReqID() { return hasQuoteReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteReqID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteReqID()) FixUtils.fillNul(quoteReqID);		
		FixUtils.copy(quoteReqID, src); 		
		hasQuoteReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteReqID(String str) {		
		if (str == null ) return;
		if (hasQuoteReqID()) FixUtils.fillNul(quoteReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteReqID, src); 		
		hasQuoteReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteID() {		
		getQuoteID();		
	}		
			
	public byte[] getQuoteID() { 		
		if ( hasQuoteID()) {		
			if (hasQuoteID == FixUtils.TAG_HAS_VALUE) {		
				return quoteID; 		
			} else {

				buf.position(hasQuoteID);

			FixUtils.getTagStringValue(buf, quoteID, 0, quoteID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasQuoteID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteID() { return hasQuoteID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteID()) FixUtils.fillNul(quoteID);		
		FixUtils.copy(quoteID, src); 		
		hasQuoteID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteID(String str) {		
		if (str == null ) return;
		if (hasQuoteID()) FixUtils.fillNul(quoteID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteID, src); 		
		hasQuoteID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteMsgID() {		
		getQuoteMsgID();		
	}		
			
	public byte[] getQuoteMsgID() { 		
		if ( hasQuoteMsgID()) {		
			if (hasQuoteMsgID == FixUtils.TAG_HAS_VALUE) {		
				return quoteMsgID; 		
			} else {

				buf.position(hasQuoteMsgID);

			FixUtils.getTagStringValue(buf, quoteMsgID, 0, quoteMsgID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasQuoteMsgID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteMsgID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteMsgID() { return hasQuoteMsgID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteMsgID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteMsgID()) FixUtils.fillNul(quoteMsgID);		
		FixUtils.copy(quoteMsgID, src); 		
		hasQuoteMsgID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteMsgID(String str) {		
		if (str == null ) return;
		if (hasQuoteMsgID()) FixUtils.fillNul(quoteMsgID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteMsgID, src); 		
		hasQuoteMsgID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteCancelType() {		
		getQuoteCancelType();		
	}		
			
	public long getQuoteCancelType() { 		
		if ( hasQuoteCancelType()) {		
			if (hasQuoteCancelType == FixUtils.TAG_HAS_VALUE) {		
				return quoteCancelType; 		
			} else {

				buf.position(hasQuoteCancelType);

			quoteCancelType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQuoteCancelType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteCancelType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuoteCancelType() { return hasQuoteCancelType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteCancelType(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteCancelType()) quoteCancelType = FixUtils.TAG_HAS_NO_VALUE;		
		quoteCancelType = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteCancelType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteCancelType(long src) {		
		quoteCancelType = src;
		hasQuoteCancelType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteCancelType(String str) {		
		if (str == null ) return;
		if (hasQuoteCancelType()) quoteCancelType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quoteCancelType = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteCancelType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteType() {		
		getQuoteType();		
	}		
			
	public long getQuoteType() { 		
		if ( hasQuoteType()) {		
			if (hasQuoteType == FixUtils.TAG_HAS_VALUE) {		
				return quoteType; 		
			} else {

				buf.position(hasQuoteType);

			quoteType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQuoteType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuoteType() { return hasQuoteType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteType(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteType()) quoteType = FixUtils.TAG_HAS_NO_VALUE;		
		quoteType = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteType(long src) {		
		quoteType = src;
		hasQuoteType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteType(String str) {		
		if (str == null ) return;
		if (hasQuoteType()) quoteType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quoteType = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteResponseLevel() {		
		getQuoteResponseLevel();		
	}		
			
	public long getQuoteResponseLevel() { 		
		if ( hasQuoteResponseLevel()) {		
			if (hasQuoteResponseLevel == FixUtils.TAG_HAS_VALUE) {		
				return quoteResponseLevel; 		
			} else {

				buf.position(hasQuoteResponseLevel);

			quoteResponseLevel = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQuoteResponseLevel = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteResponseLevel;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuoteResponseLevel() { return hasQuoteResponseLevel != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteResponseLevel(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteResponseLevel()) quoteResponseLevel = FixUtils.TAG_HAS_NO_VALUE;		
		quoteResponseLevel = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteResponseLevel = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteResponseLevel(long src) {		
		quoteResponseLevel = src;
		hasQuoteResponseLevel = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteResponseLevel(String str) {		
		if (str == null ) return;
		if (hasQuoteResponseLevel()) quoteResponseLevel = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quoteResponseLevel = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteResponseLevel = FixUtils.TAG_HAS_VALUE;		
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

					if (hasQuoteReqID()) s += "QuoteReqID(131)= " + new String( FixUtils.trim(getQuoteReqID()) ) + "\n" ; 
		if (hasQuoteID()) s += "QuoteID(117)= " + new String( FixUtils.trim(getQuoteID()) ) + "\n" ; 
		if (hasQuoteMsgID()) s += "QuoteMsgID(1166)= " + new String( FixUtils.trim(getQuoteMsgID()) ) + "\n" ; 
		if (hasQuoteCancelType()) s += "QuoteCancelType(298)= " + getQuoteCancelType() + "\n" ; 
		if (hasQuoteType()) s += "QuoteType(537)= " + getQuoteType() + "\n" ; 
		if (hasQuoteResponseLevel()) s += "QuoteResponseLevel(301)= " + getQuoteResponseLevel() + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAcctIDSource()) s += "AcctIDSource(660)= " + getAcctIDSource() + "\n" ; 
		if (hasAccountType()) s += "AccountType(581)= " + getAccountType() + "\n" ; 
		if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixQuoteCancel)) return false;

		FixQuoteCancel msg = (FixQuoteCancel) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasQuoteReqID() && !msg.hasQuoteReqID()) || (!hasQuoteReqID() && msg.hasQuoteReqID())) return false;
		if (!(!hasQuoteReqID() && !msg.hasQuoteReqID()) && !FixUtils.equals(getQuoteReqID(), msg.getQuoteReqID())) return false;
		if ((hasQuoteID() && !msg.hasQuoteID()) || (!hasQuoteID() && msg.hasQuoteID())) return false;
		if (!(!hasQuoteID() && !msg.hasQuoteID()) && !FixUtils.equals(getQuoteID(), msg.getQuoteID())) return false;
		if ((hasQuoteMsgID() && !msg.hasQuoteMsgID()) || (!hasQuoteMsgID() && msg.hasQuoteMsgID())) return false;
		if (!(!hasQuoteMsgID() && !msg.hasQuoteMsgID()) && !FixUtils.equals(getQuoteMsgID(), msg.getQuoteMsgID())) return false;
		if ((hasQuoteCancelType() && !msg.hasQuoteCancelType()) || (!hasQuoteCancelType() && msg.hasQuoteCancelType())) return false;
		if (!(!hasQuoteCancelType() && !msg.hasQuoteCancelType()) && !(getQuoteCancelType()==msg.getQuoteCancelType())) return false;
		if ((hasQuoteType() && !msg.hasQuoteType()) || (!hasQuoteType() && msg.hasQuoteType())) return false;
		if (!(!hasQuoteType() && !msg.hasQuoteType()) && !(getQuoteType()==msg.getQuoteType())) return false;
		if ((hasQuoteResponseLevel() && !msg.hasQuoteResponseLevel()) || (!hasQuoteResponseLevel() && msg.hasQuoteResponseLevel())) return false;
		if (!(!hasQuoteResponseLevel() && !msg.hasQuoteResponseLevel()) && !(getQuoteResponseLevel()==msg.getQuoteResponseLevel())) return false;
		if ((hasAccount() && !msg.hasAccount()) || (!hasAccount() && msg.hasAccount())) return false;
		if (!(!hasAccount() && !msg.hasAccount()) && !FixUtils.equals(getAccount(), msg.getAccount())) return false;
		if ((hasAcctIDSource() && !msg.hasAcctIDSource()) || (!hasAcctIDSource() && msg.hasAcctIDSource())) return false;
		if (!(!hasAcctIDSource() && !msg.hasAcctIDSource()) && !(getAcctIDSource()==msg.getAcctIDSource())) return false;
		if ((hasAccountType() && !msg.hasAccountType()) || (!hasAccountType() && msg.hasAccountType())) return false;
		if (!(!hasAccountType() && !msg.hasAccountType()) && !(getAccountType()==msg.getAccountType())) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		return true;
	}
	@Override
	public FixQuoteCancel clone () {
		FixQuoteCancel out = new FixQuoteCancel();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixQuoteCancel clone ( FixQuoteCancel out ) {
		if ( hasQuoteReqID())
			out.setQuoteReqID(getQuoteReqID());
		if ( hasQuoteID())
			out.setQuoteID(getQuoteID());
		if ( hasQuoteMsgID())
			out.setQuoteMsgID(getQuoteMsgID());
		if ( hasQuoteCancelType())
			out.setQuoteCancelType(getQuoteCancelType());
		if ( hasQuoteType())
			out.setQuoteType(getQuoteType());
		if ( hasQuoteResponseLevel())
			out.setQuoteResponseLevel(getQuoteResponseLevel());
		if ( hasAccount())
			out.setAccount(getAccount());
		if ( hasAcctIDSource())
			out.setAcctIDSource(getAcctIDSource());
		if ( hasAccountType())
			out.setAccountType(getAccountType());
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		int count = 0;
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
		count = 0;
		for (FixQuotCxlEntriesGrp fixQuotCxlEntriesGrp : quotCxlEntriesGrp) {
			if (!fixQuotCxlEntriesGrp.hasGroup()) continue;
			out.quotCxlEntriesGrp[count] = fixQuotCxlEntriesGrp.clone( out.quotCxlEntriesGrp[count] );
			count++;
		}
		return out;
	}

}
