package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixAllocationInstructionAck extends FixInMessage {
	private short hasAllocID;
	byte[] allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryAllocID;
	byte[] secondaryAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeDate;
	byte[] tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasAllocStatus;
	long allocStatus = 0;		
	private short hasAllocRejCode;
	long allocRejCode = 0;		
	private short hasAllocType;
	long allocType = 0;		
	private short hasAllocIntermedReqType;
	long allocIntermedReqType = 0;		
	private short hasMatchStatus;
	byte matchStatus = (byte)' ';		
	private short hasProduct;
	long product = 0;		
	private short hasSecurityType;
	byte[] securityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	public FixParties[] parties;
	public FixAllocAckGrp[] allocAckGrp;
	
	public FixAllocationInstructionAck() {
		super(FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTIONACK);


		hasAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasAllocStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocType = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocIntermedReqType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMatchStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasProduct = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		securityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		allocAckGrp = new FixAllocAckGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) allocAckGrp[i] = new FixAllocAckGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.ALLOCID_INT:		
            		hasAllocID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYALLOCID_INT:		
            		hasSecondaryAllocID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRADEDATE_INT:		
            		hasTradeDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCSTATUS_INT:		
            		hasAllocStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCREJCODE_INT:		
            		hasAllocRejCode = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCTYPE_INT:		
            		hasAllocType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCINTERMEDREQTYPE_INT:		
            		hasAllocIntermedReqType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MATCHSTATUS_INT:		
            		hasMatchStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRODUCT_INT:		
            		hasProduct = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYTYPE_INT:		
            		hasSecurityType = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOALLOCS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !allocAckGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOALLOCS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = allocAckGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTIONACK_INT);
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
		if (!hasAllocID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.ALLOCID_INT, FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTIONACK_INT);
			return false;
		}
		if (!hasAllocStatus()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.ALLOCSTATUS_INT, FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTIONACK_INT);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		getAllocID();		
		getSecondaryAllocID();		
		getTradeDate();		
		getTransactTime();		
		getAllocStatus();		
		getAllocRejCode();		
		getAllocType();		
		getAllocIntermedReqType();		
		getMatchStatus();		
		getProduct();		
		getSecurityType();		
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
		if (hasAllocID()) {		
			out.put(FixTags.ALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecondaryAllocID()) {		
			out.put(FixTags.SECONDARYALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,secondaryAllocID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeDate()) {		
			out.put(FixTags.TRADEDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocStatus()) {		
			out.put(FixTags.ALLOCSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocStatus);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocRejCode()) {		
			out.put(FixTags.ALLOCREJCODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocRejCode);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocType()) {		
			out.put(FixTags.ALLOCTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocIntermedReqType()) {		
			out.put(FixTags.ALLOCINTERMEDREQTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocIntermedReqType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMatchStatus()) {		
			out.put(FixTags.MATCHSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,matchStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasProduct()) {		
			out.put(FixTags.PRODUCT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)product);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityType()) {		
			out.put(FixTags.SECURITYTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,securityType); 		
		
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
		if (FixUtils.getNoInGroup(allocAckGrp)>0) {
			out.put(FixTags.NOALLOCS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(allocAckGrp));

			out.put(FixUtils.SOH);

		}
		for (FixAllocAckGrp fixAllocAckGrp : allocAckGrp) if (fixAllocAckGrp.hasGroup()) fixAllocAckGrp.encode(out);
		
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
		
		if (hasAllocID()) {		
			FixUtils.put(out,allocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryAllocID()) {		
			FixUtils.put(out,secondaryAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeDate()) {		
			FixUtils.put(out,tradeDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocStatus()) {		
			FixUtils.put(out, (long)allocStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocRejCode()) {		
			FixUtils.put(out, (long)allocRejCode);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocType()) {		
			FixUtils.put(out, (long)allocType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocIntermedReqType()) {		
			FixUtils.put(out, (long)allocIntermedReqType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMatchStatus()) {		
			FixUtils.put(out,matchStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasProduct()) {		
			FixUtils.put(out, (long)product);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityType()) {		
			FixUtils.put(out,securityType); 		
		
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
			
	public void crackAllocID() {		
		getAllocID();		
	}		
			
	public byte[] getAllocID() { 		
		if ( hasAllocID()) {		
			if (hasAllocID == FixUtils.TAG_HAS_VALUE) {		
				return allocID; 		
			} else {

				buf.position(hasAllocID);

			FixUtils.getTagStringValue(buf, allocID, 0, allocID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAllocID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocID() { return hasAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasAllocID()) FixUtils.fillNul(allocID);		
		FixUtils.copy(allocID, src); 		
		hasAllocID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocID(String str) {		
		if (str == null ) return;
		if (hasAllocID()) FixUtils.fillNul(allocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocID, src); 		
		hasAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecondaryAllocID() {		
		getSecondaryAllocID();		
	}		
			
	public byte[] getSecondaryAllocID() { 		
		if ( hasSecondaryAllocID()) {		
			if (hasSecondaryAllocID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryAllocID; 		
			} else {

				buf.position(hasSecondaryAllocID);

			FixUtils.getTagStringValue(buf, secondaryAllocID, 0, secondaryAllocID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecondaryAllocID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return secondaryAllocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryAllocID() { return hasSecondaryAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecondaryAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryAllocID()) FixUtils.fillNul(secondaryAllocID);		
		FixUtils.copy(secondaryAllocID, src); 		
		hasSecondaryAllocID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryAllocID(String str) {		
		if (str == null ) return;
		if (hasSecondaryAllocID()) FixUtils.fillNul(secondaryAllocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryAllocID, src); 		
		hasSecondaryAllocID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackAllocStatus() {		
		getAllocStatus();		
	}		
			
	public long getAllocStatus() { 		
		if ( hasAllocStatus()) {		
			if (hasAllocStatus == FixUtils.TAG_HAS_VALUE) {		
				return allocStatus; 		
			} else {

				buf.position(hasAllocStatus);

			allocStatus = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocStatus() { return hasAllocStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocStatus(byte[] src) {		
		if (src == null ) return;
		if (hasAllocStatus()) allocStatus = FixUtils.TAG_HAS_NO_VALUE;		
		allocStatus = FixUtils.longValueOf(src, 0, src.length);
		hasAllocStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocStatus(long src) {		
		allocStatus = src;
		hasAllocStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocStatus(String str) {		
		if (str == null ) return;
		if (hasAllocStatus()) allocStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocStatus = FixUtils.longValueOf(src, 0, src.length);
		hasAllocStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocRejCode() {		
		getAllocRejCode();		
	}		
			
	public long getAllocRejCode() { 		
		if ( hasAllocRejCode()) {		
			if (hasAllocRejCode == FixUtils.TAG_HAS_VALUE) {		
				return allocRejCode; 		
			} else {

				buf.position(hasAllocRejCode);

			allocRejCode = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocRejCode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocRejCode;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocRejCode() { return hasAllocRejCode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocRejCode(byte[] src) {		
		if (src == null ) return;
		if (hasAllocRejCode()) allocRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		allocRejCode = FixUtils.longValueOf(src, 0, src.length);
		hasAllocRejCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocRejCode(long src) {		
		allocRejCode = src;
		hasAllocRejCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocRejCode(String str) {		
		if (str == null ) return;
		if (hasAllocRejCode()) allocRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocRejCode = FixUtils.longValueOf(src, 0, src.length);
		hasAllocRejCode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocType() {		
		getAllocType();		
	}		
			
	public long getAllocType() { 		
		if ( hasAllocType()) {		
			if (hasAllocType == FixUtils.TAG_HAS_VALUE) {		
				return allocType; 		
			} else {

				buf.position(hasAllocType);

			allocType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocType() { return hasAllocType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocType(byte[] src) {		
		if (src == null ) return;
		if (hasAllocType()) allocType = FixUtils.TAG_HAS_NO_VALUE;		
		allocType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocType(long src) {		
		allocType = src;
		hasAllocType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocType(String str) {		
		if (str == null ) return;
		if (hasAllocType()) allocType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocIntermedReqType() {		
		getAllocIntermedReqType();		
	}		
			
	public long getAllocIntermedReqType() { 		
		if ( hasAllocIntermedReqType()) {		
			if (hasAllocIntermedReqType == FixUtils.TAG_HAS_VALUE) {		
				return allocIntermedReqType; 		
			} else {

				buf.position(hasAllocIntermedReqType);

			allocIntermedReqType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocIntermedReqType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocIntermedReqType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocIntermedReqType() { return hasAllocIntermedReqType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocIntermedReqType(byte[] src) {		
		if (src == null ) return;
		if (hasAllocIntermedReqType()) allocIntermedReqType = FixUtils.TAG_HAS_NO_VALUE;		
		allocIntermedReqType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocIntermedReqType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocIntermedReqType(long src) {		
		allocIntermedReqType = src;
		hasAllocIntermedReqType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocIntermedReqType(String str) {		
		if (str == null ) return;
		if (hasAllocIntermedReqType()) allocIntermedReqType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocIntermedReqType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocIntermedReqType = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackProduct() {		
		getProduct();		
	}		
			
	public long getProduct() { 		
		if ( hasProduct()) {		
			if (hasProduct == FixUtils.TAG_HAS_VALUE) {		
				return product; 		
			} else {

				buf.position(hasProduct);

			product = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasProduct = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return product;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasProduct() { return hasProduct != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setProduct(byte[] src) {		
		if (src == null ) return;
		if (hasProduct()) product = FixUtils.TAG_HAS_NO_VALUE;		
		product = FixUtils.longValueOf(src, 0, src.length);
		hasProduct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProduct(long src) {		
		product = src;
		hasProduct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProduct(String str) {		
		if (str == null ) return;
		if (hasProduct()) product = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		product = FixUtils.longValueOf(src, 0, src.length);
		hasProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityType() {		
		getSecurityType();		
	}		
			
	public byte[] getSecurityType() { 		
		if ( hasSecurityType()) {		
			if (hasSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return securityType; 		
			} else {

				buf.position(hasSecurityType);

			FixUtils.getTagStringValue(buf, securityType, 0, securityType.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecurityType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityType() { return hasSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityType()) FixUtils.fillNul(securityType);		
		FixUtils.copy(securityType, src); 		
		hasSecurityType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityType(String str) {		
		if (str == null ) return;
		if (hasSecurityType()) FixUtils.fillNul(securityType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityType, src); 		
		hasSecurityType = FixUtils.TAG_HAS_VALUE;		
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

					if (hasAllocID()) s += "AllocID(70)= " + new String( FixUtils.trim(getAllocID()) ) + "\n" ; 
		if (hasSecondaryAllocID()) s += "SecondaryAllocID(793)= " + new String( FixUtils.trim(getSecondaryAllocID()) ) + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasAllocStatus()) s += "AllocStatus(87)= " + getAllocStatus() + "\n" ; 
		if (hasAllocRejCode()) s += "AllocRejCode(88)= " + getAllocRejCode() + "\n" ; 
		if (hasAllocType()) s += "AllocType(626)= " + getAllocType() + "\n" ; 
		if (hasAllocIntermedReqType()) s += "AllocIntermedReqType(808)= " + getAllocIntermedReqType() + "\n" ; 
		if (hasMatchStatus()) s += "MatchStatus(573)= " + getMatchStatus() + "\n" ; 
		if (hasProduct()) s += "Product(460)= " + getProduct() + "\n" ; 
		if (hasSecurityType()) s += "SecurityType(167)= " + new String( FixUtils.trim(getSecurityType()) ) + "\n" ; 
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
		if (! ( o instanceof FixAllocationInstructionAck)) return false;

		FixAllocationInstructionAck msg = (FixAllocationInstructionAck) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasAllocID() && !msg.hasAllocID()) || (!hasAllocID() && msg.hasAllocID())) return false;
		if (!(!hasAllocID() && !msg.hasAllocID()) && !FixUtils.equals(getAllocID(), msg.getAllocID())) return false;
		if ((hasSecondaryAllocID() && !msg.hasSecondaryAllocID()) || (!hasSecondaryAllocID() && msg.hasSecondaryAllocID())) return false;
		if (!(!hasSecondaryAllocID() && !msg.hasSecondaryAllocID()) && !FixUtils.equals(getSecondaryAllocID(), msg.getSecondaryAllocID())) return false;
		if ((hasTradeDate() && !msg.hasTradeDate()) || (!hasTradeDate() && msg.hasTradeDate())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasAllocStatus() && !msg.hasAllocStatus()) || (!hasAllocStatus() && msg.hasAllocStatus())) return false;
		if (!(!hasAllocStatus() && !msg.hasAllocStatus()) && !(getAllocStatus()==msg.getAllocStatus())) return false;
		if ((hasAllocRejCode() && !msg.hasAllocRejCode()) || (!hasAllocRejCode() && msg.hasAllocRejCode())) return false;
		if (!(!hasAllocRejCode() && !msg.hasAllocRejCode()) && !(getAllocRejCode()==msg.getAllocRejCode())) return false;
		if ((hasAllocType() && !msg.hasAllocType()) || (!hasAllocType() && msg.hasAllocType())) return false;
		if (!(!hasAllocType() && !msg.hasAllocType()) && !(getAllocType()==msg.getAllocType())) return false;
		if ((hasAllocIntermedReqType() && !msg.hasAllocIntermedReqType()) || (!hasAllocIntermedReqType() && msg.hasAllocIntermedReqType())) return false;
		if (!(!hasAllocIntermedReqType() && !msg.hasAllocIntermedReqType()) && !(getAllocIntermedReqType()==msg.getAllocIntermedReqType())) return false;
		if ((hasMatchStatus() && !msg.hasMatchStatus()) || (!hasMatchStatus() && msg.hasMatchStatus())) return false;
		if (!(!hasMatchStatus() && !msg.hasMatchStatus()) && !(getMatchStatus()==msg.getMatchStatus())) return false;
		if ((hasProduct() && !msg.hasProduct()) || (!hasProduct() && msg.hasProduct())) return false;
		if (!(!hasProduct() && !msg.hasProduct()) && !(getProduct()==msg.getProduct())) return false;
		if ((hasSecurityType() && !msg.hasSecurityType()) || (!hasSecurityType() && msg.hasSecurityType())) return false;
		if (!(!hasSecurityType() && !msg.hasSecurityType()) && !FixUtils.equals(getSecurityType(), msg.getSecurityType())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixAllocationInstructionAck clone () {
		FixAllocationInstructionAck out = new FixAllocationInstructionAck();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixAllocationInstructionAck clone ( FixAllocationInstructionAck out ) {
		if ( hasAllocID())
			out.setAllocID(getAllocID());
		if ( hasSecondaryAllocID())
			out.setSecondaryAllocID(getSecondaryAllocID());
		if ( hasTradeDate())
			out.setTradeDate(getTradeDate());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasAllocStatus())
			out.setAllocStatus(getAllocStatus());
		if ( hasAllocRejCode())
			out.setAllocRejCode(getAllocRejCode());
		if ( hasAllocType())
			out.setAllocType(getAllocType());
		if ( hasAllocIntermedReqType())
			out.setAllocIntermedReqType(getAllocIntermedReqType());
		if ( hasMatchStatus())
			out.setMatchStatus(getMatchStatus());
		if ( hasProduct())
			out.setProduct(getProduct());
		if ( hasSecurityType())
			out.setSecurityType(getSecurityType());
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
		count = 0;
		for (FixAllocAckGrp fixAllocAckGrp : allocAckGrp) {
			if (!fixAllocAckGrp.hasGroup()) continue;
			out.allocAckGrp[count] = fixAllocAckGrp.clone( out.allocAckGrp[count] );
			count++;
		}
		return out;
	}

}
