package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixSecurityList extends FixInMessage {
	private short hasSecurityReportID;
	long securityReportID = 0;		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityListID;
	byte[] securityListID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityListRefID;
	byte[] securityListRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityListDesc;
	byte[] securityListDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEncodedSecurityListDescLen;
	long encodedSecurityListDescLen = 0;		
	private short hasEncodedSecurityListDesc;
	byte[] encodedSecurityListDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityListType;
	long securityListType = 0;		
	private short hasSecurityListTypeSource;
	long securityListTypeSource = 0;		
	private short hasSecurityReqID;
	byte[] securityReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityResponseID;
	byte[] securityResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityRequestResult;
	long securityRequestResult = 0;		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTotNoRelatedSym;
	long totNoRelatedSym = 0;		
	private short hasMarketID;
	byte[] marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketSegmentID;
	byte[] marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLastFragment;
		boolean lastFragment = false;		
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixSecListGrp[] secListGrp;
	
	public FixSecurityList() {
		super(FixMessageInfo.MessageTypes.SECURITYLIST);


		hasSecurityReportID = FixUtils.TAG_HAS_NO_VALUE;		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityListID = FixUtils.TAG_HAS_NO_VALUE;		
		securityListID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityListRefID = FixUtils.TAG_HAS_NO_VALUE;		
		securityListRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityListDesc = FixUtils.TAG_HAS_NO_VALUE;		
		securityListDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEncodedSecurityListDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedSecurityListDesc = FixUtils.TAG_HAS_NO_VALUE;		
		encodedSecurityListDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityListType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityListTypeSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityReqID = FixUtils.TAG_HAS_NO_VALUE;		
		securityReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityResponseID = FixUtils.TAG_HAS_NO_VALUE;		
		securityResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityRequestResult = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTotNoRelatedSym = FixUtils.TAG_HAS_NO_VALUE;		
		hasMarketID = FixUtils.TAG_HAS_NO_VALUE;		
		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketSegmentID = FixUtils.TAG_HAS_NO_VALUE;		
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLastFragment = FixUtils.TAG_HAS_NO_VALUE;		
		applicationSequenceControl = new FixApplicationSequenceControl();
		secListGrp = new FixSecListGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) secListGrp[i] = new FixSecListGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.SECURITYREPORTID_INT:		
            		hasSecurityReportID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYLISTID_INT:		
            		hasSecurityListID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYLISTREFID_INT:		
            		hasSecurityListRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYLISTDESC_INT:		
            		hasSecurityListDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDSECURITYLISTDESCLEN_INT:		
            		hasEncodedSecurityListDescLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDSECURITYLISTDESC_INT:		
            		hasEncodedSecurityListDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYLISTTYPE_INT:		
            		hasSecurityListType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYLISTTYPESOURCE_INT:		
            		hasSecurityListTypeSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYREQID_INT:		
            		hasSecurityReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYRESPONSEID_INT:		
            		hasSecurityResponseID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYREQUESTRESULT_INT:		
            		hasSecurityRequestResult = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TOTNORELATEDSYM_INT:		
            		hasTotNoRelatedSym = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MARKETID_INT:		
            		hasMarketID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MARKETSEGMENTID_INT:		
            		hasMarketSegmentID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTFRAGMENT_INT:		
            		hasLastFragment = (short) buf.position();		
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
        			} else if ( tag == FixTags.NORELATEDSYM_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !secListGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = secListGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else break; //Ugha
					}

			}

        		if (err.hasError()) return;

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	public boolean hasRequiredTags(FixValidationError err) {
		standardHeader.hasRequiredTags(err); if (err.hasError()) return false; 

		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		/* not needed, just for the inet dudes recognition */		
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
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityListID()) {		
			out.put(FixTags.SECURITYLISTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,securityListID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityListRefID()) {		
			out.put(FixTags.SECURITYLISTREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,securityListRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityListDesc()) {		
			out.put(FixTags.SECURITYLISTDESC);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,securityListDesc); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedSecurityListDescLen()) {		
			out.put(FixTags.ENCODEDSECURITYLISTDESCLEN);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encodedSecurityListDescLen);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedSecurityListDesc()) {		
			out.put(FixTags.ENCODEDSECURITYLISTDESC);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,encodedSecurityListDesc); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityListType()) {		
			out.put(FixTags.SECURITYLISTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)securityListType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityListTypeSource()) {		
			out.put(FixTags.SECURITYLISTTYPESOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)securityListTypeSource);
		
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
		if (hasSecurityRequestResult()) {		
			out.put(FixTags.SECURITYREQUESTRESULT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)securityRequestResult);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotNoRelatedSym()) {		
			out.put(FixTags.TOTNORELATEDSYM);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totNoRelatedSym);
		
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
		if (hasLastFragment()) {		
			out.put(FixTags.LASTFRAGMENT);		
		
			out.put((byte) '=');		
		
			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		
		applicationSequenceControl.encode(out);
		if (FixUtils.getNoInGroup(secListGrp)>0) {
			out.put(FixTags.NORELATEDSYM);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(secListGrp));

			out.put(FixUtils.SOH);

		}
		for (FixSecListGrp fixSecListGrp : secListGrp) if (fixSecListGrp.hasGroup()) fixSecListGrp.encode(out);
		
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
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityListID()) {		
			FixUtils.put(out,securityListID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityListRefID()) {		
			FixUtils.put(out,securityListRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityListDesc()) {		
			FixUtils.put(out,securityListDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedSecurityListDescLen()) {		
			FixUtils.put(out, (long)encodedSecurityListDescLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedSecurityListDesc()) {		
			FixUtils.put(out,encodedSecurityListDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityListType()) {		
			FixUtils.put(out, (long)securityListType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityListTypeSource()) {		
			FixUtils.put(out, (long)securityListTypeSource);
		
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
		
		if (hasSecurityRequestResult()) {		
			FixUtils.put(out, (long)securityRequestResult);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNoRelatedSym()) {		
			FixUtils.put(out, (long)totNoRelatedSym);
		
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
		
		if (hasLastFragment()) {		
			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
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

			securityReportID = FixMessage.getTagIntValue(buf, err);
		
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
		if (hasClearingBusinessDate()) FixUtils.fillSpace(clearingBusinessDate);		
		FixUtils.copy(clearingBusinessDate, src); 		
		hasClearingBusinessDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClearingBusinessDate(String str) {		
		if (str == null ) return;
		if (hasClearingBusinessDate()) FixUtils.fillSpace(clearingBusinessDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clearingBusinessDate, src); 		
		hasClearingBusinessDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityListID() {		
		getSecurityListID();		
	}		
			
	public byte[] getSecurityListID() { 		
		if ( hasSecurityListID()) {		
			if (hasSecurityListID == FixUtils.TAG_HAS_VALUE) {		
				return securityListID; 		
			} else {

				buf.position(hasSecurityListID);

			FixMessage.getTagStringValue(buf, securityListID, 0, securityListID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecurityListID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityListID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityListID() { return hasSecurityListID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityListID(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityListID()) FixUtils.fillSpace(securityListID);		
		FixUtils.copy(securityListID, src); 		
		hasSecurityListID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityListID(String str) {		
		if (str == null ) return;
		if (hasSecurityListID()) FixUtils.fillSpace(securityListID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityListID, src); 		
		hasSecurityListID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityListRefID() {		
		getSecurityListRefID();		
	}		
			
	public byte[] getSecurityListRefID() { 		
		if ( hasSecurityListRefID()) {		
			if (hasSecurityListRefID == FixUtils.TAG_HAS_VALUE) {		
				return securityListRefID; 		
			} else {

				buf.position(hasSecurityListRefID);

			FixMessage.getTagStringValue(buf, securityListRefID, 0, securityListRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecurityListRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityListRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityListRefID() { return hasSecurityListRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityListRefID(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityListRefID()) FixUtils.fillSpace(securityListRefID);		
		FixUtils.copy(securityListRefID, src); 		
		hasSecurityListRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityListRefID(String str) {		
		if (str == null ) return;
		if (hasSecurityListRefID()) FixUtils.fillSpace(securityListRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityListRefID, src); 		
		hasSecurityListRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityListDesc() {		
		getSecurityListDesc();		
	}		
			
	public byte[] getSecurityListDesc() { 		
		if ( hasSecurityListDesc()) {		
			if (hasSecurityListDesc == FixUtils.TAG_HAS_VALUE) {		
				return securityListDesc; 		
			} else {

				buf.position(hasSecurityListDesc);

			FixMessage.getTagStringValue(buf, securityListDesc, 0, securityListDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecurityListDesc = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityListDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityListDesc() { return hasSecurityListDesc != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityListDesc(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityListDesc()) FixUtils.fillSpace(securityListDesc);		
		FixUtils.copy(securityListDesc, src); 		
		hasSecurityListDesc = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityListDesc(String str) {		
		if (str == null ) return;
		if (hasSecurityListDesc()) FixUtils.fillSpace(securityListDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityListDesc, src); 		
		hasSecurityListDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedSecurityListDescLen() {		
		getEncodedSecurityListDescLen();		
	}		
			
	public long getEncodedSecurityListDescLen() { 		
		if ( hasEncodedSecurityListDescLen()) {		
			if (hasEncodedSecurityListDescLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedSecurityListDescLen; 		
			} else {

				buf.position(hasEncodedSecurityListDescLen);

			encodedSecurityListDescLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncodedSecurityListDescLen = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedSecurityListDescLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedSecurityListDescLen() { return hasEncodedSecurityListDescLen != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedSecurityListDescLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedSecurityListDescLen()) encodedSecurityListDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedSecurityListDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedSecurityListDescLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedSecurityListDescLen(long src) {		
		encodedSecurityListDescLen = src;
		hasEncodedSecurityListDescLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedSecurityListDescLen(String str) {		
		if (str == null ) return;
		if (hasEncodedSecurityListDescLen()) encodedSecurityListDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedSecurityListDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedSecurityListDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedSecurityListDesc() {		
		getEncodedSecurityListDesc();		
	}		
			
	public byte[] getEncodedSecurityListDesc() { 		
		if ( hasEncodedSecurityListDesc()) {		
			if (hasEncodedSecurityListDesc == FixUtils.TAG_HAS_VALUE) {		
				return encodedSecurityListDesc; 		
			} else {

				buf.position(hasEncodedSecurityListDesc);

			FixMessage.getTagStringValue(buf, encodedSecurityListDesc, 0, encodedSecurityListDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEncodedSecurityListDesc = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedSecurityListDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedSecurityListDesc() { return hasEncodedSecurityListDesc != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedSecurityListDesc(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedSecurityListDesc()) FixUtils.fillSpace(encodedSecurityListDesc);		
		FixUtils.copy(encodedSecurityListDesc, src); 		
		hasEncodedSecurityListDesc = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedSecurityListDesc(String str) {		
		if (str == null ) return;
		if (hasEncodedSecurityListDesc()) FixUtils.fillSpace(encodedSecurityListDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedSecurityListDesc, src); 		
		hasEncodedSecurityListDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityListType() {		
		getSecurityListType();		
	}		
			
	public long getSecurityListType() { 		
		if ( hasSecurityListType()) {		
			if (hasSecurityListType == FixUtils.TAG_HAS_VALUE) {		
				return securityListType; 		
			} else {

				buf.position(hasSecurityListType);

			securityListType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSecurityListType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityListType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecurityListType() { return hasSecurityListType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityListType(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityListType()) securityListType = FixUtils.TAG_HAS_NO_VALUE;		
		securityListType = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityListType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityListType(long src) {		
		securityListType = src;
		hasSecurityListType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityListType(String str) {		
		if (str == null ) return;
		if (hasSecurityListType()) securityListType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		securityListType = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityListType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityListTypeSource() {		
		getSecurityListTypeSource();		
	}		
			
	public long getSecurityListTypeSource() { 		
		if ( hasSecurityListTypeSource()) {		
			if (hasSecurityListTypeSource == FixUtils.TAG_HAS_VALUE) {		
				return securityListTypeSource; 		
			} else {

				buf.position(hasSecurityListTypeSource);

			securityListTypeSource = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSecurityListTypeSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityListTypeSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecurityListTypeSource() { return hasSecurityListTypeSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityListTypeSource(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityListTypeSource()) securityListTypeSource = FixUtils.TAG_HAS_NO_VALUE;		
		securityListTypeSource = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityListTypeSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityListTypeSource(long src) {		
		securityListTypeSource = src;
		hasSecurityListTypeSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityListTypeSource(String str) {		
		if (str == null ) return;
		if (hasSecurityListTypeSource()) securityListTypeSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		securityListTypeSource = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityListTypeSource = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, securityReqID, 0, securityReqID.length, err);
		
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
		if (hasSecurityReqID()) FixUtils.fillSpace(securityReqID);		
		FixUtils.copy(securityReqID, src); 		
		hasSecurityReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityReqID(String str) {		
		if (str == null ) return;
		if (hasSecurityReqID()) FixUtils.fillSpace(securityReqID);		
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

			FixMessage.getTagStringValue(buf, securityResponseID, 0, securityResponseID.length, err);
		
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
		if (hasSecurityResponseID()) FixUtils.fillSpace(securityResponseID);		
		FixUtils.copy(securityResponseID, src); 		
		hasSecurityResponseID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityResponseID(String str) {		
		if (str == null ) return;
		if (hasSecurityResponseID()) FixUtils.fillSpace(securityResponseID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityResponseID, src); 		
		hasSecurityResponseID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityRequestResult() {		
		getSecurityRequestResult();		
	}		
			
	public long getSecurityRequestResult() { 		
		if ( hasSecurityRequestResult()) {		
			if (hasSecurityRequestResult == FixUtils.TAG_HAS_VALUE) {		
				return securityRequestResult; 		
			} else {

				buf.position(hasSecurityRequestResult);

			securityRequestResult = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSecurityRequestResult = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityRequestResult;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecurityRequestResult() { return hasSecurityRequestResult != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityRequestResult(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityRequestResult()) securityRequestResult = FixUtils.TAG_HAS_NO_VALUE;		
		securityRequestResult = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityRequestResult = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityRequestResult(long src) {		
		securityRequestResult = src;
		hasSecurityRequestResult = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityRequestResult(String str) {		
		if (str == null ) return;
		if (hasSecurityRequestResult()) securityRequestResult = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		securityRequestResult = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityRequestResult = FixUtils.TAG_HAS_VALUE;		
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
		if (hasTransactTime()) FixUtils.fillSpace(transactTime);		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTransactTime(String str) {		
		if (str == null ) return;
		if (hasTransactTime()) FixUtils.fillSpace(transactTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTotNoRelatedSym() {		
		getTotNoRelatedSym();		
	}		
			
	public long getTotNoRelatedSym() { 		
		if ( hasTotNoRelatedSym()) {		
			if (hasTotNoRelatedSym == FixUtils.TAG_HAS_VALUE) {		
				return totNoRelatedSym; 		
			} else {

				buf.position(hasTotNoRelatedSym);

			totNoRelatedSym = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotNoRelatedSym = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totNoRelatedSym;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNoRelatedSym() { return hasTotNoRelatedSym != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotNoRelatedSym(byte[] src) {		
		if (src == null ) return;
		if (hasTotNoRelatedSym()) totNoRelatedSym = FixUtils.TAG_HAS_NO_VALUE;		
		totNoRelatedSym = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoRelatedSym = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoRelatedSym(long src) {		
		totNoRelatedSym = src;
		hasTotNoRelatedSym = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoRelatedSym(String str) {		
		if (str == null ) return;
		if (hasTotNoRelatedSym()) totNoRelatedSym = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNoRelatedSym = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoRelatedSym = FixUtils.TAG_HAS_VALUE;		
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

			FixMessage.getTagStringValue(buf, marketID, 0, marketID.length, err);
		
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
		if (hasMarketID()) FixUtils.fillSpace(marketID);		
		FixUtils.copy(marketID, src); 		
		hasMarketID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketID(String str) {		
		if (str == null ) return;
		if (hasMarketID()) FixUtils.fillSpace(marketID);		
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

			FixMessage.getTagStringValue(buf, marketSegmentID, 0, marketSegmentID.length, err);
		
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
		if (hasMarketSegmentID()) FixUtils.fillSpace(marketSegmentID);		
		FixUtils.copy(marketSegmentID, src); 		
		hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketSegmentID(String str) {		
		if (str == null ) return;
		if (hasMarketSegmentID()) FixUtils.fillSpace(marketSegmentID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketSegmentID, src); 		
		hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastFragment() {		
		getLastFragment();		
	}		
			
	public boolean getLastFragment() { 		
		if ( hasLastFragment()) {		
			if (hasLastFragment == FixUtils.TAG_HAS_VALUE) {		
				return lastFragment; 		
			} else {

				buf.position(hasLastFragment);

			lastFragment = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasLastFragment = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastFragment;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasLastFragment() { return hasLastFragment != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastFragment(byte[] src) {		
		if (src == null ) return;
		if (hasLastFragment()) lastFragment = false;		
		lastFragment = src[0]==(byte)'Y'?true:false;		
		hasLastFragment = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastFragment(boolean src) {		
		lastFragment = src;
		hasLastFragment = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastFragment(String str) {		
		if (str == null ) return;
		if (hasLastFragment()) lastFragment = false;		
		byte[] src = str.getBytes(); 		
		lastFragment = src[0]==(byte)'Y'?true:false;		
		hasLastFragment = FixUtils.TAG_HAS_VALUE;		
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
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasSecurityListID()) s += "SecurityListID(1465)= " + new String( FixUtils.trim(getSecurityListID()) ) + "\n" ; 
		if (hasSecurityListRefID()) s += "SecurityListRefID(1466)= " + new String( FixUtils.trim(getSecurityListRefID()) ) + "\n" ; 
		if (hasSecurityListDesc()) s += "SecurityListDesc(1467)= " + new String( FixUtils.trim(getSecurityListDesc()) ) + "\n" ; 
		if (hasEncodedSecurityListDescLen()) s += "EncodedSecurityListDescLen(1468)= " + getEncodedSecurityListDescLen() + "\n" ; 
		if (hasEncodedSecurityListDesc()) s += "EncodedSecurityListDesc(1469)= " + new String( FixUtils.trim(getEncodedSecurityListDesc()) ) + "\n" ; 
		if (hasSecurityListType()) s += "SecurityListType(1470)= " + getSecurityListType() + "\n" ; 
		if (hasSecurityListTypeSource()) s += "SecurityListTypeSource(1471)= " + getSecurityListTypeSource() + "\n" ; 
		if (hasSecurityReqID()) s += "SecurityReqID(320)= " + new String( FixUtils.trim(getSecurityReqID()) ) + "\n" ; 
		if (hasSecurityResponseID()) s += "SecurityResponseID(322)= " + new String( FixUtils.trim(getSecurityResponseID()) ) + "\n" ; 
		if (hasSecurityRequestResult()) s += "SecurityRequestResult(560)= " + getSecurityRequestResult() + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasTotNoRelatedSym()) s += "TotNoRelatedSym(393)= " + getTotNoRelatedSym() + "\n" ; 
		if (hasMarketID()) s += "MarketID(1301)= " + new String( FixUtils.trim(getMarketID()) ) + "\n" ; 
		if (hasMarketSegmentID()) s += "MarketSegmentID(1300)= " + new String( FixUtils.trim(getMarketSegmentID()) ) + "\n" ; 
		if (hasLastFragment()) s += "LastFragment(893)= " + getLastFragment() + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSecurityList)) return false;

		FixSecurityList msg = (FixSecurityList) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasSecurityReportID() && !msg.hasSecurityReportID()) || (!hasSecurityReportID() && msg.hasSecurityReportID())) return false;
		if (!(!hasSecurityReportID() && !msg.hasSecurityReportID()) && !(getSecurityReportID()==msg.getSecurityReportID())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if ((hasSecurityListID() && !msg.hasSecurityListID()) || (!hasSecurityListID() && msg.hasSecurityListID())) return false;
		if (!(!hasSecurityListID() && !msg.hasSecurityListID()) && !FixUtils.equals(getSecurityListID(), msg.getSecurityListID())) return false;
		if ((hasSecurityListRefID() && !msg.hasSecurityListRefID()) || (!hasSecurityListRefID() && msg.hasSecurityListRefID())) return false;
		if (!(!hasSecurityListRefID() && !msg.hasSecurityListRefID()) && !FixUtils.equals(getSecurityListRefID(), msg.getSecurityListRefID())) return false;
		if ((hasSecurityListDesc() && !msg.hasSecurityListDesc()) || (!hasSecurityListDesc() && msg.hasSecurityListDesc())) return false;
		if (!(!hasSecurityListDesc() && !msg.hasSecurityListDesc()) && !FixUtils.equals(getSecurityListDesc(), msg.getSecurityListDesc())) return false;
		if ((hasEncodedSecurityListDescLen() && !msg.hasEncodedSecurityListDescLen()) || (!hasEncodedSecurityListDescLen() && msg.hasEncodedSecurityListDescLen())) return false;
		if (!(!hasEncodedSecurityListDescLen() && !msg.hasEncodedSecurityListDescLen()) && !(getEncodedSecurityListDescLen()==msg.getEncodedSecurityListDescLen())) return false;
		if ((hasEncodedSecurityListDesc() && !msg.hasEncodedSecurityListDesc()) || (!hasEncodedSecurityListDesc() && msg.hasEncodedSecurityListDesc())) return false;
		if (!(!hasEncodedSecurityListDesc() && !msg.hasEncodedSecurityListDesc()) && !FixUtils.equals(getEncodedSecurityListDesc(), msg.getEncodedSecurityListDesc())) return false;
		if ((hasSecurityListType() && !msg.hasSecurityListType()) || (!hasSecurityListType() && msg.hasSecurityListType())) return false;
		if (!(!hasSecurityListType() && !msg.hasSecurityListType()) && !(getSecurityListType()==msg.getSecurityListType())) return false;
		if ((hasSecurityListTypeSource() && !msg.hasSecurityListTypeSource()) || (!hasSecurityListTypeSource() && msg.hasSecurityListTypeSource())) return false;
		if (!(!hasSecurityListTypeSource() && !msg.hasSecurityListTypeSource()) && !(getSecurityListTypeSource()==msg.getSecurityListTypeSource())) return false;
		if ((hasSecurityReqID() && !msg.hasSecurityReqID()) || (!hasSecurityReqID() && msg.hasSecurityReqID())) return false;
		if (!(!hasSecurityReqID() && !msg.hasSecurityReqID()) && !FixUtils.equals(getSecurityReqID(), msg.getSecurityReqID())) return false;
		if ((hasSecurityResponseID() && !msg.hasSecurityResponseID()) || (!hasSecurityResponseID() && msg.hasSecurityResponseID())) return false;
		if (!(!hasSecurityResponseID() && !msg.hasSecurityResponseID()) && !FixUtils.equals(getSecurityResponseID(), msg.getSecurityResponseID())) return false;
		if ((hasSecurityRequestResult() && !msg.hasSecurityRequestResult()) || (!hasSecurityRequestResult() && msg.hasSecurityRequestResult())) return false;
		if (!(!hasSecurityRequestResult() && !msg.hasSecurityRequestResult()) && !(getSecurityRequestResult()==msg.getSecurityRequestResult())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasTotNoRelatedSym() && !msg.hasTotNoRelatedSym()) || (!hasTotNoRelatedSym() && msg.hasTotNoRelatedSym())) return false;
		if (!(!hasTotNoRelatedSym() && !msg.hasTotNoRelatedSym()) && !(getTotNoRelatedSym()==msg.getTotNoRelatedSym())) return false;
		if ((hasMarketID() && !msg.hasMarketID()) || (!hasMarketID() && msg.hasMarketID())) return false;
		if (!(!hasMarketID() && !msg.hasMarketID()) && !FixUtils.equals(getMarketID(), msg.getMarketID())) return false;
		if ((hasMarketSegmentID() && !msg.hasMarketSegmentID()) || (!hasMarketSegmentID() && msg.hasMarketSegmentID())) return false;
		if (!(!hasMarketSegmentID() && !msg.hasMarketSegmentID()) && !FixUtils.equals(getMarketSegmentID(), msg.getMarketSegmentID())) return false;
		if ((hasLastFragment() && !msg.hasLastFragment()) || (!hasLastFragment() && msg.hasLastFragment())) return false;
		if (!(!hasLastFragment() && !msg.hasLastFragment()) && !(getLastFragment()==msg.getLastFragment())) return false;
		return true;
	}
	@Override
	public FixSecurityList clone () {
		FixSecurityList out = new FixSecurityList();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixSecurityList clone ( FixSecurityList out ) {
		if ( hasSecurityReportID())
			out.setSecurityReportID(getSecurityReportID());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasSecurityListID())
			out.setSecurityListID(getSecurityListID());
		if ( hasSecurityListRefID())
			out.setSecurityListRefID(getSecurityListRefID());
		if ( hasSecurityListDesc())
			out.setSecurityListDesc(getSecurityListDesc());
		if ( hasEncodedSecurityListDescLen())
			out.setEncodedSecurityListDescLen(getEncodedSecurityListDescLen());
		if ( hasEncodedSecurityListDesc())
			out.setEncodedSecurityListDesc(getEncodedSecurityListDesc());
		if ( hasSecurityListType())
			out.setSecurityListType(getSecurityListType());
		if ( hasSecurityListTypeSource())
			out.setSecurityListTypeSource(getSecurityListTypeSource());
		if ( hasSecurityReqID())
			out.setSecurityReqID(getSecurityReqID());
		if ( hasSecurityResponseID())
			out.setSecurityResponseID(getSecurityResponseID());
		if ( hasSecurityRequestResult())
			out.setSecurityRequestResult(getSecurityRequestResult());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasTotNoRelatedSym())
			out.setTotNoRelatedSym(getTotNoRelatedSym());
		if ( hasMarketID())
			out.setMarketID(getMarketID());
		if ( hasMarketSegmentID())
			out.setMarketSegmentID(getMarketSegmentID());
		if ( hasLastFragment())
			out.setLastFragment(getLastFragment());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		int count = 0;
		count = 0;
		for (FixSecListGrp fixSecListGrp : secListGrp) {
			if (!fixSecListGrp.hasGroup()) continue;
			out.secListGrp[count] = fixSecListGrp.clone( out.secListGrp[count] );
			count++;
		}
		return out;
	}

}
