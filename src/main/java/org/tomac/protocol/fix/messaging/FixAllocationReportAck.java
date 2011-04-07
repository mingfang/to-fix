package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixAllocationReportAck extends FixInMessage {
	private short hasAllocReportID;
	byte[] allocReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocID;
	byte[] allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAvgPxIndicator;
	long avgPxIndicator = 0;		
	private short hasQuantity;
	long quantity = 0;		
	private short hasAllocTransType;
	byte allocTransType = (byte)' ';		
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
	private short hasAllocReportType;
	long allocReportType = 0;		
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
	
	public FixAllocationReportAck() {
		super(FixMessageInfo.MessageTypes.ALLOCATIONREPORTACK);


		hasAllocReportID = FixUtils.TAG_HAS_NO_VALUE;		
		allocReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAvgPxIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasQuantity = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocTransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecondaryAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasAllocStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocReportType = FixUtils.TAG_HAS_NO_VALUE;		
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

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.ALLOCREPORTID_INT:		
            		hasAllocReportID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCID_INT:		
            		hasAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.AVGPXINDICATOR_INT:		
            		hasAvgPxIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.QUANTITY_INT:		
            		hasQuantity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCTRANSTYPE_INT:		
            		hasAllocTransType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECONDARYALLOCID_INT:		
            		hasSecondaryAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEDATE_INT:		
            		hasTradeDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCSTATUS_INT:		
            		hasAllocStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCREJCODE_INT:		
            		hasAllocRejCode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCREPORTTYPE_INT:		
            		hasAllocReportType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCINTERMEDREQTYPE_INT:		
            		hasAllocIntermedReqType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MATCHSTATUS_INT:		
            		hasMatchStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRODUCT_INT:		
            		hasProduct = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYTYPE_INT:		
            		hasSecurityType = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOALLOCS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !allocAckGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = allocAckGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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

		if (!hasAllocReportID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag AllocReportID missing", FixTags.ALLOCREPORTID_INT, FixMessageInfo.MessageTypes.ALLOCATIONREPORTACK);
			return false;
		}
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getAllocReportID();		
		getAllocID();		
		getClearingBusinessDate();		
		getAvgPxIndicator();		
		getQuantity();		
		getAllocTransType();		
		getSecondaryAllocID();		
		getTradeDate();		
		getTransactTime();		
		getAllocStatus();		
		getAllocRejCode();		
		getAllocReportType();		
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
		if (hasAllocReportID()) {		
			out.put(FixTags.ALLOCREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocReportID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocID()) {		
			out.put(FixTags.ALLOCID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAvgPxIndicator()) {		
			out.put(FixTags.AVGPXINDICATOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)avgPxIndicator);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuantity()) {		
			out.put(FixTags.QUANTITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)quantity);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocTransType()) {		
			out.put(FixTags.ALLOCTRANSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocTransType); 		
		
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
		if (hasAllocReportType()) {		
			out.put(FixTags.ALLOCREPORTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocReportType);
		
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
		
		if (hasAllocReportID()) {		
			FixUtils.put(out,allocReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocID()) {		
			FixUtils.put(out,allocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAvgPxIndicator()) {		
			FixUtils.put(out, (long)avgPxIndicator);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuantity()) {		
			FixUtils.put(out, (long)quantity);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocTransType()) {		
			FixUtils.put(out,allocTransType); 		
		
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
		
		if (hasAllocReportType()) {		
			FixUtils.put(out, (long)allocReportType);
		
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
			
	public void crackAllocReportID() {		
		getAllocReportID();		
	}		
			
	public byte[] getAllocReportID() { 		
		if ( hasAllocReportID()) {		
			if (hasAllocReportID == FixUtils.TAG_HAS_VALUE) {		
				return allocReportID; 		
			} else {

				buf.position(hasAllocReportID);

			FixMessage.getTagStringValue(buf, allocReportID, 0, allocReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAllocReportID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocReportID() { return hasAllocReportID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocReportID(byte[] src) {		
		if (src == null ) return;
		if (hasAllocReportID()) FixUtils.fillNul(allocReportID);		
		FixUtils.copy(allocReportID, src); 		
		hasAllocReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocReportID(String str) {		
		if (str == null ) return;
		if (hasAllocReportID()) FixUtils.fillNul(allocReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocReportID, src); 		
		hasAllocReportID = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, allocID, 0, allocID.length, err);
		
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
			
	public void crackAvgPxIndicator() {		
		getAvgPxIndicator();		
	}		
			
	public long getAvgPxIndicator() { 		
		if ( hasAvgPxIndicator()) {		
			if (hasAvgPxIndicator == FixUtils.TAG_HAS_VALUE) {		
				return avgPxIndicator; 		
			} else {

				buf.position(hasAvgPxIndicator);

			avgPxIndicator = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAvgPxIndicator = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return avgPxIndicator;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAvgPxIndicator() { return hasAvgPxIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAvgPxIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasAvgPxIndicator()) avgPxIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		avgPxIndicator = FixUtils.longValueOf(src, 0, src.length);
		hasAvgPxIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgPxIndicator(long src) {		
		avgPxIndicator = src;
		hasAvgPxIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgPxIndicator(String str) {		
		if (str == null ) return;
		if (hasAvgPxIndicator()) avgPxIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		avgPxIndicator = FixUtils.longValueOf(src, 0, src.length);
		hasAvgPxIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuantity() {		
		getQuantity();		
	}		
			
	public long getQuantity() { 		
		if ( hasQuantity()) {		
			if (hasQuantity == FixUtils.TAG_HAS_VALUE) {		
				return quantity; 		
			} else {

				buf.position(hasQuantity);

			quantity = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasQuantity = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quantity;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuantity() { return hasQuantity != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuantity(byte[] src) {		
		if (src == null ) return;
		if (hasQuantity()) quantity = FixUtils.TAG_HAS_NO_VALUE;		
		quantity = FixUtils.longValueOf(src, 0, src.length);
		hasQuantity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuantity(long src) {		
		quantity = src;
		hasQuantity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuantity(String str) {		
		if (str == null ) return;
		if (hasQuantity()) quantity = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quantity = FixUtils.longValueOf(src, 0, src.length);
		hasQuantity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocTransType() {		
		getAllocTransType();		
	}		
			
	public byte getAllocTransType() { 		
		if ( hasAllocTransType()) {		
			if (hasAllocTransType == FixUtils.TAG_HAS_VALUE) {		
				return allocTransType; 		
			} else {

				buf.position(hasAllocTransType);

			allocTransType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (allocTransType != (byte)'3') && (allocTransType != (byte)'2') && (allocTransType != (byte)'1') && (allocTransType != (byte)'0') && (allocTransType != (byte)'6') && (allocTransType != (byte)'5') && (allocTransType != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 71);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasAllocTransType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocTransType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasAllocTransType() { return hasAllocTransType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocTransType(byte[] src) {		
		if (src == null ) return;
		if (hasAllocTransType()) allocTransType = (byte)' ';		
		allocTransType = src[0];		
		hasAllocTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocTransType(byte src) {		
		allocTransType = src;
		hasAllocTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocTransType(String str) {		
		if (str == null ) return;
		if (hasAllocTransType()) allocTransType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		allocTransType = src[0];		
		hasAllocTransType = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, secondaryAllocID, 0, secondaryAllocID.length, err);
		
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
			
	public void crackTransactTime() {		
		getTransactTime();		
	}		
			
	public byte[] getTransactTime() { 		
		if ( hasTransactTime()) {		
			if (hasTransactTime == FixUtils.TAG_HAS_VALUE) {		
				return transactTime; 		
			} else {

				buf.position(hasTransactTime);

			FixMessage.getTagStringValue(buf, transactTime, 0, transactTime.length, err);
		
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

			allocStatus = FixMessage.getTagIntValue(buf, err);
		
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

			allocRejCode = FixMessage.getTagIntValue(buf, err);
		
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
			
	public void crackAllocReportType() {		
		getAllocReportType();		
	}		
			
	public long getAllocReportType() { 		
		if ( hasAllocReportType()) {		
			if (hasAllocReportType == FixUtils.TAG_HAS_VALUE) {		
				return allocReportType; 		
			} else {

				buf.position(hasAllocReportType);

			allocReportType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocReportType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocReportType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocReportType() { return hasAllocReportType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocReportType(byte[] src) {		
		if (src == null ) return;
		if (hasAllocReportType()) allocReportType = FixUtils.TAG_HAS_NO_VALUE;		
		allocReportType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocReportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocReportType(long src) {		
		allocReportType = src;
		hasAllocReportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocReportType(String str) {		
		if (str == null ) return;
		if (hasAllocReportType()) allocReportType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocReportType = FixUtils.longValueOf(src, 0, src.length);
		hasAllocReportType = FixUtils.TAG_HAS_VALUE;		
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

			allocIntermedReqType = FixMessage.getTagIntValue(buf, err);
		
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

			matchStatus = FixMessage.getTagCharValue(buf, err);
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

			product = FixMessage.getTagIntValue(buf, err);
		
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

			FixMessage.getTagStringValue(buf, securityType, 0, securityType.length, err);
		
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

					if (hasAllocReportID()) s += "AllocReportID(755)= " + new String( FixUtils.trim(getAllocReportID()) ) + "\n" ; 
		if (hasAllocID()) s += "AllocID(70)= " + new String( FixUtils.trim(getAllocID()) ) + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasAvgPxIndicator()) s += "AvgPxIndicator(819)= " + getAvgPxIndicator() + "\n" ; 
		if (hasQuantity()) s += "Quantity(53)= " + getQuantity() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAllocTransType()) s += "AllocTransType(71)= " + getAllocTransType() + "\n" ; 
		if (hasSecondaryAllocID()) s += "SecondaryAllocID(793)= " + new String( FixUtils.trim(getSecondaryAllocID()) ) + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasAllocStatus()) s += "AllocStatus(87)= " + getAllocStatus() + "\n" ; 
		if (hasAllocRejCode()) s += "AllocRejCode(88)= " + getAllocRejCode() + "\n" ; 
		if (hasAllocReportType()) s += "AllocReportType(794)= " + getAllocReportType() + "\n" ; 
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
		if (! ( o instanceof FixAllocationReportAck)) return false;

		FixAllocationReportAck msg = (FixAllocationReportAck) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasAllocReportID() && !msg.hasAllocReportID()) || (!hasAllocReportID() && msg.hasAllocReportID())) return false;
		if (!(!hasAllocReportID() && !msg.hasAllocReportID()) && !FixUtils.equals(getAllocReportID(), msg.getAllocReportID())) return false;
		if ((hasAllocID() && !msg.hasAllocID()) || (!hasAllocID() && msg.hasAllocID())) return false;
		if (!(!hasAllocID() && !msg.hasAllocID()) && !FixUtils.equals(getAllocID(), msg.getAllocID())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if ((hasAvgPxIndicator() && !msg.hasAvgPxIndicator()) || (!hasAvgPxIndicator() && msg.hasAvgPxIndicator())) return false;
		if (!(!hasAvgPxIndicator() && !msg.hasAvgPxIndicator()) && !(getAvgPxIndicator()==msg.getAvgPxIndicator())) return false;
		if ((hasQuantity() && !msg.hasQuantity()) || (!hasQuantity() && msg.hasQuantity())) return false;
		if (!(!hasQuantity() && !msg.hasQuantity()) && !(getQuantity()==msg.getQuantity())) return false;
		if ((hasAllocTransType() && !msg.hasAllocTransType()) || (!hasAllocTransType() && msg.hasAllocTransType())) return false;
		if (!(!hasAllocTransType() && !msg.hasAllocTransType()) && !(getAllocTransType()==msg.getAllocTransType())) return false;
		if ((hasSecondaryAllocID() && !msg.hasSecondaryAllocID()) || (!hasSecondaryAllocID() && msg.hasSecondaryAllocID())) return false;
		if (!(!hasSecondaryAllocID() && !msg.hasSecondaryAllocID()) && !FixUtils.equals(getSecondaryAllocID(), msg.getSecondaryAllocID())) return false;
		if ((hasTradeDate() && !msg.hasTradeDate()) || (!hasTradeDate() && msg.hasTradeDate())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasAllocStatus() && !msg.hasAllocStatus()) || (!hasAllocStatus() && msg.hasAllocStatus())) return false;
		if (!(!hasAllocStatus() && !msg.hasAllocStatus()) && !(getAllocStatus()==msg.getAllocStatus())) return false;
		if ((hasAllocRejCode() && !msg.hasAllocRejCode()) || (!hasAllocRejCode() && msg.hasAllocRejCode())) return false;
		if (!(!hasAllocRejCode() && !msg.hasAllocRejCode()) && !(getAllocRejCode()==msg.getAllocRejCode())) return false;
		if ((hasAllocReportType() && !msg.hasAllocReportType()) || (!hasAllocReportType() && msg.hasAllocReportType())) return false;
		if (!(!hasAllocReportType() && !msg.hasAllocReportType()) && !(getAllocReportType()==msg.getAllocReportType())) return false;
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
	public FixAllocationReportAck clone () {
		FixAllocationReportAck out = new FixAllocationReportAck();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixAllocationReportAck clone ( FixAllocationReportAck out ) {
		if ( hasAllocReportID())
			out.setAllocReportID(getAllocReportID());
		if ( hasAllocID())
			out.setAllocID(getAllocID());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasAvgPxIndicator())
			out.setAvgPxIndicator(getAvgPxIndicator());
		if ( hasQuantity())
			out.setQuantity(getQuantity());
		if ( hasAllocTransType())
			out.setAllocTransType(getAllocTransType());
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
		if ( hasAllocReportType())
			out.setAllocReportType(getAllocReportType());
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
