package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixListStatus extends FixInMessage {
	private short hasListID;
	byte[] listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasListStatusType;
	long listStatusType = 0;		
	private short hasNoRpts;
	long noRpts = 0;		
	private short hasListOrderStatus;
	long listOrderStatus = 0;		
	private short hasContingencyType;
	long contingencyType = 0;		
	private short hasListRejectReason;
	long listRejectReason = 0;		
	private short hasRptSeq;
	long rptSeq = 0;		
	private short hasListStatusText;
	byte[] listStatusText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedListStatusTextLen;
	long encodedListStatusTextLen = 0;		
	private short hasEncodedListStatusText;
	byte[] encodedListStatusText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTotNoOrders;
	long totNoOrders = 0;		
	private short hasLastFragment;
		boolean lastFragment = false;		
	public FixOrdListStatGrp[] ordListStatGrp;
	
	public FixListStatus() {
		super(FixMessageInfo.MessageTypes.LISTSTATUS);


		hasListID = FixUtils.TAG_HAS_NO_VALUE;		
		listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasListStatusType = FixUtils.TAG_HAS_NO_VALUE;		
		hasNoRpts = FixUtils.TAG_HAS_NO_VALUE;		
		hasListOrderStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasContingencyType = FixUtils.TAG_HAS_NO_VALUE;		
		hasListRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasRptSeq = FixUtils.TAG_HAS_NO_VALUE;		
		hasListStatusText = FixUtils.TAG_HAS_NO_VALUE;		
		listStatusText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedListStatusTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedListStatusText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedListStatusText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTotNoOrders = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastFragment = FixUtils.TAG_HAS_NO_VALUE;		
		ordListStatGrp = new FixOrdListStatGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) ordListStatGrp[i] = new FixOrdListStatGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.LISTID_INT:		
            		hasListID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LISTSTATUSTYPE_INT:		
            		hasListStatusType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.NORPTS_INT:		
            		hasNoRpts = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LISTORDERSTATUS_INT:		
            		hasListOrderStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CONTINGENCYTYPE_INT:		
            		hasContingencyType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LISTREJECTREASON_INT:		
            		hasListRejectReason = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.RPTSEQ_INT:		
            		hasRptSeq = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LISTSTATUSTEXT_INT:		
            		hasListStatusText = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDLISTSTATUSTEXTLEN_INT:		
            		hasEncodedListStatusTextLen = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDLISTSTATUSTEXT_INT:		
            		hasEncodedListStatusText = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TOTNOORDERS_INT:		
            		hasTotNoOrders = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LASTFRAGMENT_INT:		
            		hasLastFragment = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOORDERS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !ordListStatGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOORDERS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = ordListStatGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.LISTSTATUS_INT);
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
		if (!hasListID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.LISTID_INT, FixMessageInfo.MessageTypes.LISTSTATUS_INT);
			return false;
		}
		if (!hasListStatusType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.LISTSTATUSTYPE_INT, FixMessageInfo.MessageTypes.LISTSTATUS_INT);
			return false;
		}
		if (!hasNoRpts()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.NORPTS_INT, FixMessageInfo.MessageTypes.LISTSTATUS_INT);
			return false;
		}
		if (!hasListOrderStatus()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.LISTORDERSTATUS_INT, FixMessageInfo.MessageTypes.LISTSTATUS_INT);
			return false;
		}
		if (!hasRptSeq()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.RPTSEQ_INT, FixMessageInfo.MessageTypes.LISTSTATUS_INT);
			return false;
		}
		if (!hasTotNoOrders()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TOTNOORDERS_INT, FixMessageInfo.MessageTypes.LISTSTATUS_INT);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (ordListStatGrp[i].hasGroup()) ordListStatGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		return true;
	}
	@Override		
	public void getAll() {		
		getListID();		
		getListStatusType();		
		getNoRpts();		
		getListOrderStatus();		
		getContingencyType();		
		getListRejectReason();		
		getRptSeq();		
		getListStatusText();		
		getEncodedListStatusTextLen();		
		getEncodedListStatusText();		
		getTransactTime();		
		getTotNoOrders();		
		getLastFragment();		
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
		if (hasListID()) {		
			out.put(FixTags.LISTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,listID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasListStatusType()) {		
			out.put(FixTags.LISTSTATUSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)listStatusType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNoRpts()) {		
			out.put(FixTags.NORPTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)noRpts);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasListOrderStatus()) {		
			out.put(FixTags.LISTORDERSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)listOrderStatus);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasContingencyType()) {		
			out.put(FixTags.CONTINGENCYTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)contingencyType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasListRejectReason()) {		
			out.put(FixTags.LISTREJECTREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)listRejectReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRptSeq()) {		
			out.put(FixTags.RPTSEQ);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)rptSeq);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasListStatusText()) {		
			out.put(FixTags.LISTSTATUSTEXT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,listStatusText); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedListStatusTextLen()) {		
			out.put(FixTags.ENCODEDLISTSTATUSTEXTLEN);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encodedListStatusTextLen);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedListStatusText()) {		
			out.put(FixTags.ENCODEDLISTSTATUSTEXT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,encodedListStatusText); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotNoOrders()) {		
			out.put(FixTags.TOTNOORDERS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totNoOrders);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastFragment()) {		
			out.put(FixTags.LASTFRAGMENT);		
		
			out.put((byte) '=');		
		
			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(ordListStatGrp)>0) {
			out.put(FixTags.NOORDERS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(ordListStatGrp));

			out.put(FixUtils.SOH);

		}
		for (FixOrdListStatGrp fixOrdListStatGrp : ordListStatGrp) if (fixOrdListStatGrp.hasGroup()) fixOrdListStatGrp.encode(out);
		
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
		
		if (hasListID()) {		
			FixUtils.put(out,listID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasListStatusType()) {		
			FixUtils.put(out, (long)listStatusType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNoRpts()) {		
			FixUtils.put(out, (long)noRpts);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasListOrderStatus()) {		
			FixUtils.put(out, (long)listOrderStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContingencyType()) {		
			FixUtils.put(out, (long)contingencyType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasListRejectReason()) {		
			FixUtils.put(out, (long)listRejectReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRptSeq()) {		
			FixUtils.put(out, (long)rptSeq);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasListStatusText()) {		
			FixUtils.put(out,listStatusText); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedListStatusTextLen()) {		
			FixUtils.put(out, (long)encodedListStatusTextLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedListStatusText()) {		
			FixUtils.put(out,encodedListStatusText); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNoOrders()) {		
			FixUtils.put(out, (long)totNoOrders);
		
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
			
	public void crackListID() {		
		getListID();		
	}		
			
	public byte[] getListID() { 		
		if ( hasListID()) {		
			if (hasListID == FixUtils.TAG_HAS_VALUE) {		
				return listID; 		
			} else {

				buf.position(hasListID);

			FixUtils.getTagStringValue(buf, listID, 0, listID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasListID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return listID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasListID() { return hasListID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setListID(byte[] src) {		
		if (src == null ) return;
		if (hasListID()) FixUtils.fillNul(listID);		
		FixUtils.copy(listID, src); 		
		hasListID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListID(String str) {		
		if (str == null ) return;
		if (hasListID()) FixUtils.fillNul(listID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(listID, src); 		
		hasListID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackListStatusType() {		
		getListStatusType();		
	}		
			
	public long getListStatusType() { 		
		if ( hasListStatusType()) {		
			if (hasListStatusType == FixUtils.TAG_HAS_VALUE) {		
				return listStatusType; 		
			} else {

				buf.position(hasListStatusType);

			listStatusType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasListStatusType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return listStatusType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasListStatusType() { return hasListStatusType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setListStatusType(byte[] src) {		
		if (src == null ) return;
		if (hasListStatusType()) listStatusType = FixUtils.TAG_HAS_NO_VALUE;		
		listStatusType = FixUtils.longValueOf(src, 0, src.length);
		hasListStatusType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListStatusType(long src) {		
		listStatusType = src;
		hasListStatusType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListStatusType(String str) {		
		if (str == null ) return;
		if (hasListStatusType()) listStatusType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		listStatusType = FixUtils.longValueOf(src, 0, src.length);
		hasListStatusType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackNoRpts() {		
		getNoRpts();		
	}		
			
	public long getNoRpts() { 		
		if ( hasNoRpts()) {		
			if (hasNoRpts == FixUtils.TAG_HAS_VALUE) {		
				return noRpts; 		
			} else {

				buf.position(hasNoRpts);

			noRpts = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasNoRpts = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return noRpts;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNoRpts() { return hasNoRpts != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNoRpts(byte[] src) {		
		if (src == null ) return;
		if (hasNoRpts()) noRpts = FixUtils.TAG_HAS_NO_VALUE;		
		noRpts = FixUtils.longValueOf(src, 0, src.length);
		hasNoRpts = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNoRpts(long src) {		
		noRpts = src;
		hasNoRpts = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNoRpts(String str) {		
		if (str == null ) return;
		if (hasNoRpts()) noRpts = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		noRpts = FixUtils.longValueOf(src, 0, src.length);
		hasNoRpts = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackListOrderStatus() {		
		getListOrderStatus();		
	}		
			
	public long getListOrderStatus() { 		
		if ( hasListOrderStatus()) {		
			if (hasListOrderStatus == FixUtils.TAG_HAS_VALUE) {		
				return listOrderStatus; 		
			} else {

				buf.position(hasListOrderStatus);

			listOrderStatus = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasListOrderStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return listOrderStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasListOrderStatus() { return hasListOrderStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setListOrderStatus(byte[] src) {		
		if (src == null ) return;
		if (hasListOrderStatus()) listOrderStatus = FixUtils.TAG_HAS_NO_VALUE;		
		listOrderStatus = FixUtils.longValueOf(src, 0, src.length);
		hasListOrderStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListOrderStatus(long src) {		
		listOrderStatus = src;
		hasListOrderStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListOrderStatus(String str) {		
		if (str == null ) return;
		if (hasListOrderStatus()) listOrderStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		listOrderStatus = FixUtils.longValueOf(src, 0, src.length);
		hasListOrderStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackContingencyType() {		
		getContingencyType();		
	}		
			
	public long getContingencyType() { 		
		if ( hasContingencyType()) {		
			if (hasContingencyType == FixUtils.TAG_HAS_VALUE) {		
				return contingencyType; 		
			} else {

				buf.position(hasContingencyType);

			contingencyType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasContingencyType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return contingencyType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasContingencyType() { return hasContingencyType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setContingencyType(byte[] src) {		
		if (src == null ) return;
		if (hasContingencyType()) contingencyType = FixUtils.TAG_HAS_NO_VALUE;		
		contingencyType = FixUtils.longValueOf(src, 0, src.length);
		hasContingencyType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContingencyType(long src) {		
		contingencyType = src;
		hasContingencyType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContingencyType(String str) {		
		if (str == null ) return;
		if (hasContingencyType()) contingencyType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		contingencyType = FixUtils.longValueOf(src, 0, src.length);
		hasContingencyType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackListRejectReason() {		
		getListRejectReason();		
	}		
			
	public long getListRejectReason() { 		
		if ( hasListRejectReason()) {		
			if (hasListRejectReason == FixUtils.TAG_HAS_VALUE) {		
				return listRejectReason; 		
			} else {

				buf.position(hasListRejectReason);

			listRejectReason = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasListRejectReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return listRejectReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasListRejectReason() { return hasListRejectReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setListRejectReason(byte[] src) {		
		if (src == null ) return;
		if (hasListRejectReason()) listRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		listRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasListRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListRejectReason(long src) {		
		listRejectReason = src;
		hasListRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListRejectReason(String str) {		
		if (str == null ) return;
		if (hasListRejectReason()) listRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		listRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasListRejectReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRptSeq() {		
		getRptSeq();		
	}		
			
	public long getRptSeq() { 		
		if ( hasRptSeq()) {		
			if (hasRptSeq == FixUtils.TAG_HAS_VALUE) {		
				return rptSeq; 		
			} else {

				buf.position(hasRptSeq);

			rptSeq = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasRptSeq = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return rptSeq;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRptSeq() { return hasRptSeq != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRptSeq(byte[] src) {		
		if (src == null ) return;
		if (hasRptSeq()) rptSeq = FixUtils.TAG_HAS_NO_VALUE;		
		rptSeq = FixUtils.longValueOf(src, 0, src.length);
		hasRptSeq = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRptSeq(long src) {		
		rptSeq = src;
		hasRptSeq = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRptSeq(String str) {		
		if (str == null ) return;
		if (hasRptSeq()) rptSeq = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		rptSeq = FixUtils.longValueOf(src, 0, src.length);
		hasRptSeq = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackListStatusText() {		
		getListStatusText();		
	}		
			
	public byte[] getListStatusText() { 		
		if ( hasListStatusText()) {		
			if (hasListStatusText == FixUtils.TAG_HAS_VALUE) {		
				return listStatusText; 		
			} else {

				buf.position(hasListStatusText);

			FixUtils.getTagStringValue(buf, listStatusText, 0, listStatusText.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasListStatusText = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return listStatusText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasListStatusText() { return hasListStatusText != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setListStatusText(byte[] src) {		
		if (src == null ) return;
		if (hasListStatusText()) FixUtils.fillNul(listStatusText);		
		FixUtils.copy(listStatusText, src); 		
		hasListStatusText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListStatusText(String str) {		
		if (str == null ) return;
		if (hasListStatusText()) FixUtils.fillNul(listStatusText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(listStatusText, src); 		
		hasListStatusText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedListStatusTextLen() {		
		getEncodedListStatusTextLen();		
	}		
			
	public long getEncodedListStatusTextLen() { 		
		if ( hasEncodedListStatusTextLen()) {		
			if (hasEncodedListStatusTextLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedListStatusTextLen; 		
			} else {

				buf.position(hasEncodedListStatusTextLen);

			encodedListStatusTextLen = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncodedListStatusTextLen = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedListStatusTextLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedListStatusTextLen() { return hasEncodedListStatusTextLen != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedListStatusTextLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedListStatusTextLen()) encodedListStatusTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedListStatusTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedListStatusTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedListStatusTextLen(long src) {		
		encodedListStatusTextLen = src;
		hasEncodedListStatusTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedListStatusTextLen(String str) {		
		if (str == null ) return;
		if (hasEncodedListStatusTextLen()) encodedListStatusTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedListStatusTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedListStatusTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedListStatusText() {		
		getEncodedListStatusText();		
	}		
			
	public byte[] getEncodedListStatusText() { 		
		if ( hasEncodedListStatusText()) {		
			if (hasEncodedListStatusText == FixUtils.TAG_HAS_VALUE) {		
				return encodedListStatusText; 		
			} else {

				buf.position(hasEncodedListStatusText);

			FixUtils.getTagStringValue(buf, encodedListStatusText, 0, encodedListStatusText.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEncodedListStatusText = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedListStatusText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedListStatusText() { return hasEncodedListStatusText != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedListStatusText(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedListStatusText()) FixUtils.fillNul(encodedListStatusText);		
		FixUtils.copy(encodedListStatusText, src); 		
		hasEncodedListStatusText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedListStatusText(String str) {		
		if (str == null ) return;
		if (hasEncodedListStatusText()) FixUtils.fillNul(encodedListStatusText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedListStatusText, src); 		
		hasEncodedListStatusText = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackTotNoOrders() {		
		getTotNoOrders();		
	}		
			
	public long getTotNoOrders() { 		
		if ( hasTotNoOrders()) {		
			if (hasTotNoOrders == FixUtils.TAG_HAS_VALUE) {		
				return totNoOrders; 		
			} else {

				buf.position(hasTotNoOrders);

			totNoOrders = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotNoOrders = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totNoOrders;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNoOrders() { return hasTotNoOrders != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotNoOrders(byte[] src) {		
		if (src == null ) return;
		if (hasTotNoOrders()) totNoOrders = FixUtils.TAG_HAS_NO_VALUE;		
		totNoOrders = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoOrders = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoOrders(long src) {		
		totNoOrders = src;
		hasTotNoOrders = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoOrders(String str) {		
		if (str == null ) return;
		if (hasTotNoOrders()) totNoOrders = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNoOrders = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoOrders = FixUtils.TAG_HAS_VALUE;		
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

			lastFragment = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
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

					if (hasListID()) s += "ListID(66)= " + new String( FixUtils.trim(getListID()) ) + "\n" ; 
		if (hasListStatusType()) s += "ListStatusType(429)= " + getListStatusType() + "\n" ; 
		if (hasNoRpts()) s += "NoRpts(82)= " + getNoRpts() + "\n" ; 
		if (hasListOrderStatus()) s += "ListOrderStatus(431)= " + getListOrderStatus() + "\n" ; 
		if (hasContingencyType()) s += "ContingencyType(1385)= " + getContingencyType() + "\n" ; 
		if (hasListRejectReason()) s += "ListRejectReason(1386)= " + getListRejectReason() + "\n" ; 
		if (hasRptSeq()) s += "RptSeq(83)= " + getRptSeq() + "\n" ; 
		if (hasListStatusText()) s += "ListStatusText(444)= " + new String( FixUtils.trim(getListStatusText()) ) + "\n" ; 
		if (hasEncodedListStatusTextLen()) s += "EncodedListStatusTextLen(445)= " + getEncodedListStatusTextLen() + "\n" ; 
		if (hasEncodedListStatusText()) s += "EncodedListStatusText(446)= " + new String( FixUtils.trim(getEncodedListStatusText()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasTotNoOrders()) s += "TotNoOrders(68)= " + getTotNoOrders() + "\n" ; 
		if (hasLastFragment()) s += "LastFragment(893)= " + getLastFragment() + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixListStatus)) return false;

		FixListStatus msg = (FixListStatus) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasListID() && !msg.hasListID()) || (!hasListID() && msg.hasListID())) return false;
		if (!(!hasListID() && !msg.hasListID()) && !FixUtils.equals(getListID(), msg.getListID())) return false;
		if ((hasListStatusType() && !msg.hasListStatusType()) || (!hasListStatusType() && msg.hasListStatusType())) return false;
		if (!(!hasListStatusType() && !msg.hasListStatusType()) && !(getListStatusType()==msg.getListStatusType())) return false;
		if ((hasNoRpts() && !msg.hasNoRpts()) || (!hasNoRpts() && msg.hasNoRpts())) return false;
		if (!(!hasNoRpts() && !msg.hasNoRpts()) && !(getNoRpts()==msg.getNoRpts())) return false;
		if ((hasListOrderStatus() && !msg.hasListOrderStatus()) || (!hasListOrderStatus() && msg.hasListOrderStatus())) return false;
		if (!(!hasListOrderStatus() && !msg.hasListOrderStatus()) && !(getListOrderStatus()==msg.getListOrderStatus())) return false;
		if ((hasContingencyType() && !msg.hasContingencyType()) || (!hasContingencyType() && msg.hasContingencyType())) return false;
		if (!(!hasContingencyType() && !msg.hasContingencyType()) && !(getContingencyType()==msg.getContingencyType())) return false;
		if ((hasListRejectReason() && !msg.hasListRejectReason()) || (!hasListRejectReason() && msg.hasListRejectReason())) return false;
		if (!(!hasListRejectReason() && !msg.hasListRejectReason()) && !(getListRejectReason()==msg.getListRejectReason())) return false;
		if ((hasRptSeq() && !msg.hasRptSeq()) || (!hasRptSeq() && msg.hasRptSeq())) return false;
		if (!(!hasRptSeq() && !msg.hasRptSeq()) && !(getRptSeq()==msg.getRptSeq())) return false;
		if ((hasListStatusText() && !msg.hasListStatusText()) || (!hasListStatusText() && msg.hasListStatusText())) return false;
		if (!(!hasListStatusText() && !msg.hasListStatusText()) && !FixUtils.equals(getListStatusText(), msg.getListStatusText())) return false;
		if ((hasEncodedListStatusTextLen() && !msg.hasEncodedListStatusTextLen()) || (!hasEncodedListStatusTextLen() && msg.hasEncodedListStatusTextLen())) return false;
		if (!(!hasEncodedListStatusTextLen() && !msg.hasEncodedListStatusTextLen()) && !(getEncodedListStatusTextLen()==msg.getEncodedListStatusTextLen())) return false;
		if ((hasEncodedListStatusText() && !msg.hasEncodedListStatusText()) || (!hasEncodedListStatusText() && msg.hasEncodedListStatusText())) return false;
		if (!(!hasEncodedListStatusText() && !msg.hasEncodedListStatusText()) && !FixUtils.equals(getEncodedListStatusText(), msg.getEncodedListStatusText())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasTotNoOrders() && !msg.hasTotNoOrders()) || (!hasTotNoOrders() && msg.hasTotNoOrders())) return false;
		if (!(!hasTotNoOrders() && !msg.hasTotNoOrders()) && !(getTotNoOrders()==msg.getTotNoOrders())) return false;
		if ((hasLastFragment() && !msg.hasLastFragment()) || (!hasLastFragment() && msg.hasLastFragment())) return false;
		if (!(!hasLastFragment() && !msg.hasLastFragment()) && !(getLastFragment()==msg.getLastFragment())) return false;
		return true;
	}
	@Override
	public FixListStatus clone () {
		FixListStatus out = new FixListStatus();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixListStatus clone ( FixListStatus out ) {
		if ( hasListID())
			out.setListID(getListID());
		if ( hasListStatusType())
			out.setListStatusType(getListStatusType());
		if ( hasNoRpts())
			out.setNoRpts(getNoRpts());
		if ( hasListOrderStatus())
			out.setListOrderStatus(getListOrderStatus());
		if ( hasContingencyType())
			out.setContingencyType(getContingencyType());
		if ( hasListRejectReason())
			out.setListRejectReason(getListRejectReason());
		if ( hasRptSeq())
			out.setRptSeq(getRptSeq());
		if ( hasListStatusText())
			out.setListStatusText(getListStatusText());
		if ( hasEncodedListStatusTextLen())
			out.setEncodedListStatusTextLen(getEncodedListStatusTextLen());
		if ( hasEncodedListStatusText())
			out.setEncodedListStatusText(getEncodedListStatusText());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasTotNoOrders())
			out.setTotNoOrders(getTotNoOrders());
		if ( hasLastFragment())
			out.setLastFragment(getLastFragment());
		int count = 0;
		count = 0;
		for (FixOrdListStatGrp fixOrdListStatGrp : ordListStatGrp) {
			if (!fixOrdListStatGrp.hasGroup()) continue;
			out.ordListStatGrp[count] = fixOrdListStatGrp.clone( out.ordListStatGrp[count] );
			count++;
		}
		return out;
	}

}
