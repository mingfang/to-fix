package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixNewOrderList extends FixInMessage {
	private short hasListID;
	byte[] listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasBidID;
	byte[] bidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClientBidID;
	byte[] clientBidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasProgRptReqs;
	long progRptReqs = 0;		
	private short hasBidType;
	long bidType = 0;		
	private short hasProgPeriodInterval;
	long progPeriodInterval = 0;		
	private short hasCancellationRights;
	byte cancellationRights = (byte)' ';		
	private short hasMoneyLaunderingStatus;
	byte moneyLaunderingStatus = (byte)' ';		
	private short hasRegistID;
	byte[] registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasListExecInstType;
	byte listExecInstType = (byte)' ';		
	private short hasListExecInst;
	byte[] listExecInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasContingencyType;
	long contingencyType = 0;		
	private short hasEncodedListExecInstLen;
	long encodedListExecInstLen = 0;		
	private short hasEncodedListExecInst;
	byte[] encodedListExecInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllowableOneSidednessPct;
	long allowableOneSidednessPct = 0;		
	private short hasAllowableOneSidednessValue;
	long allowableOneSidednessValue = 0;		
	private short hasAllowableOneSidednessCurr;
	byte[] allowableOneSidednessCurr = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasTotNoOrders;
	long totNoOrders = 0;		
	private short hasLastFragment;
		boolean lastFragment = false;		
	FixRootParties[] rootParties;
	FixListOrdGrp[] listOrdGrp;
	
	public FixNewOrderList() {
		super(FixMessageInfo.MessageTypes.NEWORDERLIST);


		hasListID = FixUtils.TAG_HAS_NO_VALUE;		
		listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasBidID = FixUtils.TAG_HAS_NO_VALUE;		
		bidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClientBidID = FixUtils.TAG_HAS_NO_VALUE;		
		clientBidID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasProgRptReqs = FixUtils.TAG_HAS_NO_VALUE;		
		hasBidType = FixUtils.TAG_HAS_NO_VALUE;		
		hasProgPeriodInterval = FixUtils.TAG_HAS_NO_VALUE;		
		hasCancellationRights = FixUtils.TAG_HAS_NO_VALUE;		
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasRegistID = FixUtils.TAG_HAS_NO_VALUE;		
		registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasListExecInstType = FixUtils.TAG_HAS_NO_VALUE;		
		hasListExecInst = FixUtils.TAG_HAS_NO_VALUE;		
		listExecInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasContingencyType = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedListExecInstLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedListExecInst = FixUtils.TAG_HAS_NO_VALUE;		
		encodedListExecInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllowableOneSidednessPct = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllowableOneSidednessValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllowableOneSidednessCurr = FixUtils.TAG_HAS_NO_VALUE;		
		allowableOneSidednessCurr = new byte[FixUtils.CURRENCY_LENGTH];		
		hasTotNoOrders = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastFragment = FixUtils.TAG_HAS_NO_VALUE;		
		rootParties = new FixRootParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rootParties[i] = new FixRootParties();
		listOrdGrp = new FixListOrdGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) listOrdGrp[i] = new FixListOrdGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.LISTID_INT:		
            		hasListID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BIDID_INT:		
            		hasBidID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLIENTBIDID_INT:		
            		hasClientBidID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PROGRPTREQS_INT:		
            		hasProgRptReqs = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BIDTYPE_INT:		
            		hasBidType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PROGPERIODINTERVAL_INT:		
            		hasProgPeriodInterval = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CANCELLATIONRIGHTS_INT:		
            		hasCancellationRights = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MONEYLAUNDERINGSTATUS_INT:		
            		hasMoneyLaunderingStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REGISTID_INT:		
            		hasRegistID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LISTEXECINSTTYPE_INT:		
            		hasListExecInstType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LISTEXECINST_INT:		
            		hasListExecInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CONTINGENCYTYPE_INT:		
            		hasContingencyType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDLISTEXECINSTLEN_INT:		
            		hasEncodedListExecInstLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDLISTEXECINST_INT:		
            		hasEncodedListExecInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOWABLEONESIDEDNESSPCT_INT:		
            		hasAllowableOneSidednessPct = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOWABLEONESIDEDNESSVALUE_INT:		
            		hasAllowableOneSidednessValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOWABLEONESIDEDNESSCURR_INT:		
            		hasAllowableOneSidednessCurr = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TOTNOORDERS_INT:		
            		hasTotNoOrders = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOROOTPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !rootParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = rootParties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOORDERS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !listOrdGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = listOrdGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	private boolean hasRequiredTags(FixValidationError err) {
		if (!hasListID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ListID missing", FixTags.LISTID_INT, FixMessageInfo.MessageTypes.NEWORDERLIST);
			return false;
		}
		if (!hasBidType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag BidType missing", FixTags.BIDTYPE_INT, FixMessageInfo.MessageTypes.NEWORDERLIST);
			return false;
		}
		if (!hasTotNoOrders()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TotNoOrders missing", FixTags.TOTNOORDERS_INT, FixMessageInfo.MessageTypes.NEWORDERLIST);
			return false;
		}
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

		super.standardHeader.encode(out);		
		if (hasListID()) {		
			out.put(FixTags.LISTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,listID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBidID()) {		
			out.put(FixTags.BIDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,bidID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClientBidID()) {		
			out.put(FixTags.CLIENTBIDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clientBidID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasProgRptReqs()) {		
			out.put(FixTags.PROGRPTREQS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)progRptReqs);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBidType()) {		
			out.put(FixTags.BIDTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)bidType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasProgPeriodInterval()) {		
			out.put(FixTags.PROGPERIODINTERVAL);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)progPeriodInterval);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCancellationRights()) {		
			out.put(FixTags.CANCELLATIONRIGHTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,cancellationRights); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMoneyLaunderingStatus()) {		
			out.put(FixTags.MONEYLAUNDERINGSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,moneyLaunderingStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRegistID()) {		
			out.put(FixTags.REGISTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,registID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasListExecInstType()) {		
			out.put(FixTags.LISTEXECINSTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,listExecInstType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasListExecInst()) {		
			out.put(FixTags.LISTEXECINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,listExecInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasContingencyType()) {		
			out.put(FixTags.CONTINGENCYTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)contingencyType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedListExecInstLen()) {		
			out.put(FixTags.ENCODEDLISTEXECINSTLEN);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encodedListExecInstLen);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedListExecInst()) {		
			out.put(FixTags.ENCODEDLISTEXECINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,encodedListExecInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllowableOneSidednessPct()) {		
			out.put(FixTags.ALLOWABLEONESIDEDNESSPCT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allowableOneSidednessPct);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllowableOneSidednessValue()) {		
			out.put(FixTags.ALLOWABLEONESIDEDNESSVALUE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allowableOneSidednessValue);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllowableOneSidednessCurr()) {		
			out.put(FixTags.ALLOWABLEONESIDEDNESSCURR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allowableOneSidednessCurr); 		
		
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
		
		if (hasListID()) {		
			FixUtils.put(out,listID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidID()) {		
			FixUtils.put(out,bidID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClientBidID()) {		
			FixUtils.put(out,clientBidID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasProgRptReqs()) {		
			FixUtils.put(out, (long)progRptReqs);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidType()) {		
			FixUtils.put(out, (long)bidType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasProgPeriodInterval()) {		
			FixUtils.put(out, (long)progPeriodInterval);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCancellationRights()) {		
			FixUtils.put(out,cancellationRights); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMoneyLaunderingStatus()) {		
			FixUtils.put(out,moneyLaunderingStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRegistID()) {		
			FixUtils.put(out,registID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasListExecInstType()) {		
			FixUtils.put(out,listExecInstType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasListExecInst()) {		
			FixUtils.put(out,listExecInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContingencyType()) {		
			FixUtils.put(out, (long)contingencyType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedListExecInstLen()) {		
			FixUtils.put(out, (long)encodedListExecInstLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedListExecInst()) {		
			FixUtils.put(out,encodedListExecInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllowableOneSidednessPct()) {		
			FixUtils.put(out, (long)allowableOneSidednessPct);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllowableOneSidednessValue()) {		
			FixUtils.put(out, (long)allowableOneSidednessValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllowableOneSidednessCurr()) {		
			FixUtils.put(out,allowableOneSidednessCurr); 		
		
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

			FixMessage.getTagStringValue(buf, listID, 0, listID.length, err);
		
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
		if (hasListID()) FixUtils.fillSpace(listID);		
		FixUtils.copy(listID, src); 		
		hasListID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListID(String str) {		
		if (str == null ) return;
		if (hasListID()) FixUtils.fillSpace(listID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(listID, src); 		
		hasListID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBidID() {		
		getBidID();		
	}		
			
	public byte[] getBidID() { 		
		if ( hasBidID()) {		
			if (hasBidID == FixUtils.TAG_HAS_VALUE) {		
				return bidID; 		
			} else {

				buf.position(hasBidID);

			FixMessage.getTagStringValue(buf, bidID, 0, bidID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasBidID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBidID() { return hasBidID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidID(byte[] src) {		
		if (src == null ) return;
		if (hasBidID()) FixUtils.fillSpace(bidID);		
		FixUtils.copy(bidID, src); 		
		hasBidID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidID(String str) {		
		if (str == null ) return;
		if (hasBidID()) FixUtils.fillSpace(bidID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(bidID, src); 		
		hasBidID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClientBidID() {		
		getClientBidID();		
	}		
			
	public byte[] getClientBidID() { 		
		if ( hasClientBidID()) {		
			if (hasClientBidID == FixUtils.TAG_HAS_VALUE) {		
				return clientBidID; 		
			} else {

				buf.position(hasClientBidID);

			FixMessage.getTagStringValue(buf, clientBidID, 0, clientBidID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClientBidID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clientBidID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClientBidID() { return hasClientBidID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClientBidID(byte[] src) {		
		if (src == null ) return;
		if (hasClientBidID()) FixUtils.fillSpace(clientBidID);		
		FixUtils.copy(clientBidID, src); 		
		hasClientBidID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClientBidID(String str) {		
		if (str == null ) return;
		if (hasClientBidID()) FixUtils.fillSpace(clientBidID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clientBidID, src); 		
		hasClientBidID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackProgRptReqs() {		
		getProgRptReqs();		
	}		
			
	public long getProgRptReqs() { 		
		if ( hasProgRptReqs()) {		
			if (hasProgRptReqs == FixUtils.TAG_HAS_VALUE) {		
				return progRptReqs; 		
			} else {

				buf.position(hasProgRptReqs);

			progRptReqs = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasProgRptReqs = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return progRptReqs;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasProgRptReqs() { return hasProgRptReqs != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setProgRptReqs(byte[] src) {		
		if (src == null ) return;
		if (hasProgRptReqs()) progRptReqs = FixUtils.TAG_HAS_NO_VALUE;		
		progRptReqs = FixUtils.longValueOf(src, 0, src.length);
		hasProgRptReqs = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProgRptReqs(long src) {		
		progRptReqs = src;
		hasProgRptReqs = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProgRptReqs(String str) {		
		if (str == null ) return;
		if (hasProgRptReqs()) progRptReqs = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		progRptReqs = FixUtils.longValueOf(src, 0, src.length);
		hasProgRptReqs = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBidType() {		
		getBidType();		
	}		
			
	public long getBidType() { 		
		if ( hasBidType()) {		
			if (hasBidType == FixUtils.TAG_HAS_VALUE) {		
				return bidType; 		
			} else {

				buf.position(hasBidType);

			bidType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBidType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return bidType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidType() { return hasBidType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBidType(byte[] src) {		
		if (src == null ) return;
		if (hasBidType()) bidType = FixUtils.TAG_HAS_NO_VALUE;		
		bidType = FixUtils.longValueOf(src, 0, src.length);
		hasBidType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidType(long src) {		
		bidType = src;
		hasBidType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidType(String str) {		
		if (str == null ) return;
		if (hasBidType()) bidType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidType = FixUtils.longValueOf(src, 0, src.length);
		hasBidType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackProgPeriodInterval() {		
		getProgPeriodInterval();		
	}		
			
	public long getProgPeriodInterval() { 		
		if ( hasProgPeriodInterval()) {		
			if (hasProgPeriodInterval == FixUtils.TAG_HAS_VALUE) {		
				return progPeriodInterval; 		
			} else {

				buf.position(hasProgPeriodInterval);

			progPeriodInterval = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasProgPeriodInterval = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return progPeriodInterval;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasProgPeriodInterval() { return hasProgPeriodInterval != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setProgPeriodInterval(byte[] src) {		
		if (src == null ) return;
		if (hasProgPeriodInterval()) progPeriodInterval = FixUtils.TAG_HAS_NO_VALUE;		
		progPeriodInterval = FixUtils.longValueOf(src, 0, src.length);
		hasProgPeriodInterval = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProgPeriodInterval(long src) {		
		progPeriodInterval = src;
		hasProgPeriodInterval = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProgPeriodInterval(String str) {		
		if (str == null ) return;
		if (hasProgPeriodInterval()) progPeriodInterval = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		progPeriodInterval = FixUtils.longValueOf(src, 0, src.length);
		hasProgPeriodInterval = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCancellationRights() {		
		getCancellationRights();		
	}		
			
	public byte getCancellationRights() { 		
		if ( hasCancellationRights()) {		
			if (hasCancellationRights == FixUtils.TAG_HAS_VALUE) {		
				return cancellationRights; 		
			} else {

				buf.position(hasCancellationRights);

			cancellationRights = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (cancellationRights != (byte)'M') && (cancellationRights != (byte)'N') && (cancellationRights != (byte)'O') && (cancellationRights != (byte)'Y') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 480);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasCancellationRights = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return cancellationRights;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasCancellationRights() { return hasCancellationRights != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCancellationRights(byte[] src) {		
		if (src == null ) return;
		if (hasCancellationRights()) cancellationRights = (byte)' ';		
		cancellationRights = src[0];		
		hasCancellationRights = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCancellationRights(byte src) {		
		cancellationRights = src;
		hasCancellationRights = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCancellationRights(String str) {		
		if (str == null ) return;
		if (hasCancellationRights()) cancellationRights = (byte)' ';		
		byte[] src = str.getBytes(); 		
		cancellationRights = src[0];		
		hasCancellationRights = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMoneyLaunderingStatus() {		
		getMoneyLaunderingStatus();		
	}		
			
	public byte getMoneyLaunderingStatus() { 		
		if ( hasMoneyLaunderingStatus()) {		
			if (hasMoneyLaunderingStatus == FixUtils.TAG_HAS_VALUE) {		
				return moneyLaunderingStatus; 		
			} else {

				buf.position(hasMoneyLaunderingStatus);

			moneyLaunderingStatus = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (moneyLaunderingStatus != (byte)'3') && (moneyLaunderingStatus != (byte)'2') && (moneyLaunderingStatus != (byte)'1') && (moneyLaunderingStatus != (byte)'N') && (moneyLaunderingStatus != (byte)'Y') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 481);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasMoneyLaunderingStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return moneyLaunderingStatus;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMoneyLaunderingStatus() { return hasMoneyLaunderingStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMoneyLaunderingStatus(byte[] src) {		
		if (src == null ) return;
		if (hasMoneyLaunderingStatus()) moneyLaunderingStatus = (byte)' ';		
		moneyLaunderingStatus = src[0];		
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMoneyLaunderingStatus(byte src) {		
		moneyLaunderingStatus = src;
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMoneyLaunderingStatus(String str) {		
		if (str == null ) return;
		if (hasMoneyLaunderingStatus()) moneyLaunderingStatus = (byte)' ';		
		byte[] src = str.getBytes(); 		
		moneyLaunderingStatus = src[0];		
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRegistID() {		
		getRegistID();		
	}		
			
	public byte[] getRegistID() { 		
		if ( hasRegistID()) {		
			if (hasRegistID == FixUtils.TAG_HAS_VALUE) {		
				return registID; 		
			} else {

				buf.position(hasRegistID);

			FixMessage.getTagStringValue(buf, registID, 0, registID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRegistID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return registID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRegistID() { return hasRegistID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRegistID(byte[] src) {		
		if (src == null ) return;
		if (hasRegistID()) FixUtils.fillSpace(registID);		
		FixUtils.copy(registID, src); 		
		hasRegistID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistID(String str) {		
		if (str == null ) return;
		if (hasRegistID()) FixUtils.fillSpace(registID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(registID, src); 		
		hasRegistID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackListExecInstType() {		
		getListExecInstType();		
	}		
			
	public byte getListExecInstType() { 		
		if ( hasListExecInstType()) {		
			if (hasListExecInstType == FixUtils.TAG_HAS_VALUE) {		
				return listExecInstType; 		
			} else {

				buf.position(hasListExecInstType);

			listExecInstType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (listExecInstType != (byte)'3') && (listExecInstType != (byte)'2') && (listExecInstType != (byte)'1') && (listExecInstType != (byte)'5') && (listExecInstType != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 433);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasListExecInstType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return listExecInstType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasListExecInstType() { return hasListExecInstType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setListExecInstType(byte[] src) {		
		if (src == null ) return;
		if (hasListExecInstType()) listExecInstType = (byte)' ';		
		listExecInstType = src[0];		
		hasListExecInstType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListExecInstType(byte src) {		
		listExecInstType = src;
		hasListExecInstType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListExecInstType(String str) {		
		if (str == null ) return;
		if (hasListExecInstType()) listExecInstType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		listExecInstType = src[0];		
		hasListExecInstType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackListExecInst() {		
		getListExecInst();		
	}		
			
	public byte[] getListExecInst() { 		
		if ( hasListExecInst()) {		
			if (hasListExecInst == FixUtils.TAG_HAS_VALUE) {		
				return listExecInst; 		
			} else {

				buf.position(hasListExecInst);

			FixMessage.getTagStringValue(buf, listExecInst, 0, listExecInst.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasListExecInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return listExecInst;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasListExecInst() { return hasListExecInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setListExecInst(byte[] src) {		
		if (src == null ) return;
		if (hasListExecInst()) FixUtils.fillSpace(listExecInst);		
		FixUtils.copy(listExecInst, src); 		
		hasListExecInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListExecInst(String str) {		
		if (str == null ) return;
		if (hasListExecInst()) FixUtils.fillSpace(listExecInst);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(listExecInst, src); 		
		hasListExecInst = FixUtils.TAG_HAS_VALUE;		
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

			contingencyType = FixMessage.getTagIntValue(buf, err);
		
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
			
	public void crackEncodedListExecInstLen() {		
		getEncodedListExecInstLen();		
	}		
			
	public long getEncodedListExecInstLen() { 		
		if ( hasEncodedListExecInstLen()) {		
			if (hasEncodedListExecInstLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedListExecInstLen; 		
			} else {

				buf.position(hasEncodedListExecInstLen);

			encodedListExecInstLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncodedListExecInstLen = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedListExecInstLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedListExecInstLen() { return hasEncodedListExecInstLen != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedListExecInstLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedListExecInstLen()) encodedListExecInstLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedListExecInstLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedListExecInstLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedListExecInstLen(long src) {		
		encodedListExecInstLen = src;
		hasEncodedListExecInstLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedListExecInstLen(String str) {		
		if (str == null ) return;
		if (hasEncodedListExecInstLen()) encodedListExecInstLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedListExecInstLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedListExecInstLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedListExecInst() {		
		getEncodedListExecInst();		
	}		
			
	public byte[] getEncodedListExecInst() { 		
		if ( hasEncodedListExecInst()) {		
			if (hasEncodedListExecInst == FixUtils.TAG_HAS_VALUE) {		
				return encodedListExecInst; 		
			} else {

				buf.position(hasEncodedListExecInst);

			FixMessage.getTagStringValue(buf, encodedListExecInst, 0, encodedListExecInst.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEncodedListExecInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedListExecInst;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedListExecInst() { return hasEncodedListExecInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedListExecInst(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedListExecInst()) FixUtils.fillSpace(encodedListExecInst);		
		FixUtils.copy(encodedListExecInst, src); 		
		hasEncodedListExecInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedListExecInst(String str) {		
		if (str == null ) return;
		if (hasEncodedListExecInst()) FixUtils.fillSpace(encodedListExecInst);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedListExecInst, src); 		
		hasEncodedListExecInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllowableOneSidednessPct() {		
		getAllowableOneSidednessPct();		
	}		
			
	public long getAllowableOneSidednessPct() { 		
		if ( hasAllowableOneSidednessPct()) {		
			if (hasAllowableOneSidednessPct == FixUtils.TAG_HAS_VALUE) {		
				return allowableOneSidednessPct; 		
			} else {

				buf.position(hasAllowableOneSidednessPct);

			allowableOneSidednessPct = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllowableOneSidednessPct = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allowableOneSidednessPct;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllowableOneSidednessPct() { return hasAllowableOneSidednessPct != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllowableOneSidednessPct(byte[] src) {		
		if (src == null ) return;
		if (hasAllowableOneSidednessPct()) allowableOneSidednessPct = FixUtils.TAG_HAS_NO_VALUE;		
		allowableOneSidednessPct = FixUtils.longValueOf(src, 0, src.length);
		hasAllowableOneSidednessPct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllowableOneSidednessPct(long src) {		
		allowableOneSidednessPct = src;
		hasAllowableOneSidednessPct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllowableOneSidednessPct(String str) {		
		if (str == null ) return;
		if (hasAllowableOneSidednessPct()) allowableOneSidednessPct = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allowableOneSidednessPct = FixUtils.longValueOf(src, 0, src.length);
		hasAllowableOneSidednessPct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllowableOneSidednessValue() {		
		getAllowableOneSidednessValue();		
	}		
			
	public long getAllowableOneSidednessValue() { 		
		if ( hasAllowableOneSidednessValue()) {		
			if (hasAllowableOneSidednessValue == FixUtils.TAG_HAS_VALUE) {		
				return allowableOneSidednessValue; 		
			} else {

				buf.position(hasAllowableOneSidednessValue);

			allowableOneSidednessValue = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllowableOneSidednessValue = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allowableOneSidednessValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllowableOneSidednessValue() { return hasAllowableOneSidednessValue != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllowableOneSidednessValue(byte[] src) {		
		if (src == null ) return;
		if (hasAllowableOneSidednessValue()) allowableOneSidednessValue = FixUtils.TAG_HAS_NO_VALUE;		
		allowableOneSidednessValue = FixUtils.longValueOf(src, 0, src.length);
		hasAllowableOneSidednessValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllowableOneSidednessValue(long src) {		
		allowableOneSidednessValue = src;
		hasAllowableOneSidednessValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllowableOneSidednessValue(String str) {		
		if (str == null ) return;
		if (hasAllowableOneSidednessValue()) allowableOneSidednessValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allowableOneSidednessValue = FixUtils.longValueOf(src, 0, src.length);
		hasAllowableOneSidednessValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllowableOneSidednessCurr() {		
		getAllowableOneSidednessCurr();		
	}		
			
	public byte[] getAllowableOneSidednessCurr() { 		
		if ( hasAllowableOneSidednessCurr()) {		
			if (hasAllowableOneSidednessCurr == FixUtils.TAG_HAS_VALUE) {		
				return allowableOneSidednessCurr; 		
			} else {

				buf.position(hasAllowableOneSidednessCurr);

			FixMessage.getTagStringValue(buf, allowableOneSidednessCurr, 0, allowableOneSidednessCurr.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAllowableOneSidednessCurr = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allowableOneSidednessCurr;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllowableOneSidednessCurr() { return hasAllowableOneSidednessCurr != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllowableOneSidednessCurr(byte[] src) {		
		if (src == null ) return;
		if (hasAllowableOneSidednessCurr()) FixUtils.fillSpace(allowableOneSidednessCurr);		
		FixUtils.copy(allowableOneSidednessCurr, src); 		
		hasAllowableOneSidednessCurr = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllowableOneSidednessCurr(String str) {		
		if (str == null ) return;
		if (hasAllowableOneSidednessCurr()) FixUtils.fillSpace(allowableOneSidednessCurr);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allowableOneSidednessCurr, src); 		
		hasAllowableOneSidednessCurr = FixUtils.TAG_HAS_VALUE;		
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

			totNoOrders = FixMessage.getTagIntValue(buf, err);
		
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
		if (standardHeader.hasApplVerID()) s += "ApplVerID(1128)= " + new String( FixUtils.trim(standardHeader.getApplVerID()) ) + "\n" ; 
		if (standardHeader.hasCstmApplVerID()) s += "CstmApplVerID(1129)= " + new String( FixUtils.trim(standardHeader.getCstmApplVerID()) ) + "\n" ; 
		if (standardHeader.hasApplExtID()) s += "ApplExtID(1156)= " + standardHeader.getApplExtID() + "\n" ; 

					if (hasListID()) s += "ListID(66)= " + new String( FixUtils.trim(getListID()) ) + "\n" ; 
		if (hasBidID()) s += "BidID(390)= " + new String( FixUtils.trim(getBidID()) ) + "\n" ; 
		if (hasClientBidID()) s += "ClientBidID(391)= " + new String( FixUtils.trim(getClientBidID()) ) + "\n" ; 
		if (hasProgRptReqs()) s += "ProgRptReqs(414)= " + getProgRptReqs() + "\n" ; 
		if (hasBidType()) s += "BidType(394)= " + getBidType() + "\n" ; 
		if (hasProgPeriodInterval()) s += "ProgPeriodInterval(415)= " + getProgPeriodInterval() + "\n" ; 
		if (hasCancellationRights()) s += "CancellationRights(480)= " + getCancellationRights() + "\n" ; 
		if (hasMoneyLaunderingStatus()) s += "MoneyLaunderingStatus(481)= " + getMoneyLaunderingStatus() + "\n" ; 
		if (hasRegistID()) s += "RegistID(513)= " + new String( FixUtils.trim(getRegistID()) ) + "\n" ; 
		if (hasListExecInstType()) s += "ListExecInstType(433)= " + getListExecInstType() + "\n" ; 
		if (hasListExecInst()) s += "ListExecInst(69)= " + new String( FixUtils.trim(getListExecInst()) ) + "\n" ; 
		if (hasContingencyType()) s += "ContingencyType(1385)= " + getContingencyType() + "\n" ; 
		if (hasEncodedListExecInstLen()) s += "EncodedListExecInstLen(352)= " + getEncodedListExecInstLen() + "\n" ; 
		if (hasEncodedListExecInst()) s += "EncodedListExecInst(353)= " + new String( FixUtils.trim(getEncodedListExecInst()) ) + "\n" ; 
		if (hasAllowableOneSidednessPct()) s += "AllowableOneSidednessPct(765)= " + getAllowableOneSidednessPct() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAllowableOneSidednessValue()) s += "AllowableOneSidednessValue(766)= " + getAllowableOneSidednessValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAllowableOneSidednessCurr()) s += "AllowableOneSidednessCurr(767)= " + new String( FixUtils.trim(getAllowableOneSidednessCurr()) ) + "\n" ; 
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
		if (! ( o instanceof FixNewOrderList)) return false;

		FixNewOrderList msg = (FixNewOrderList) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasListID() && !msg.hasListID()) || (!hasListID() && msg.hasListID())) return false;
		if (!(!hasListID() && !msg.hasListID()) && !FixUtils.equals(getListID(), msg.getListID())) return false;
		if ((hasBidID() && !msg.hasBidID()) || (!hasBidID() && msg.hasBidID())) return false;
		if (!(!hasBidID() && !msg.hasBidID()) && !FixUtils.equals(getBidID(), msg.getBidID())) return false;
		if ((hasClientBidID() && !msg.hasClientBidID()) || (!hasClientBidID() && msg.hasClientBidID())) return false;
		if (!(!hasClientBidID() && !msg.hasClientBidID()) && !FixUtils.equals(getClientBidID(), msg.getClientBidID())) return false;
		if ((hasProgRptReqs() && !msg.hasProgRptReqs()) || (!hasProgRptReqs() && msg.hasProgRptReqs())) return false;
		if (!(!hasProgRptReqs() && !msg.hasProgRptReqs()) && !(getProgRptReqs()==msg.getProgRptReqs())) return false;
		if ((hasBidType() && !msg.hasBidType()) || (!hasBidType() && msg.hasBidType())) return false;
		if (!(!hasBidType() && !msg.hasBidType()) && !(getBidType()==msg.getBidType())) return false;
		if ((hasProgPeriodInterval() && !msg.hasProgPeriodInterval()) || (!hasProgPeriodInterval() && msg.hasProgPeriodInterval())) return false;
		if (!(!hasProgPeriodInterval() && !msg.hasProgPeriodInterval()) && !(getProgPeriodInterval()==msg.getProgPeriodInterval())) return false;
		if ((hasCancellationRights() && !msg.hasCancellationRights()) || (!hasCancellationRights() && msg.hasCancellationRights())) return false;
		if (!(!hasCancellationRights() && !msg.hasCancellationRights()) && !(getCancellationRights()==msg.getCancellationRights())) return false;
		if ((hasMoneyLaunderingStatus() && !msg.hasMoneyLaunderingStatus()) || (!hasMoneyLaunderingStatus() && msg.hasMoneyLaunderingStatus())) return false;
		if (!(!hasMoneyLaunderingStatus() && !msg.hasMoneyLaunderingStatus()) && !(getMoneyLaunderingStatus()==msg.getMoneyLaunderingStatus())) return false;
		if ((hasRegistID() && !msg.hasRegistID()) || (!hasRegistID() && msg.hasRegistID())) return false;
		if (!(!hasRegistID() && !msg.hasRegistID()) && !FixUtils.equals(getRegistID(), msg.getRegistID())) return false;
		if ((hasListExecInstType() && !msg.hasListExecInstType()) || (!hasListExecInstType() && msg.hasListExecInstType())) return false;
		if (!(!hasListExecInstType() && !msg.hasListExecInstType()) && !(getListExecInstType()==msg.getListExecInstType())) return false;
		if ((hasListExecInst() && !msg.hasListExecInst()) || (!hasListExecInst() && msg.hasListExecInst())) return false;
		if (!(!hasListExecInst() && !msg.hasListExecInst()) && !FixUtils.equals(getListExecInst(), msg.getListExecInst())) return false;
		if ((hasContingencyType() && !msg.hasContingencyType()) || (!hasContingencyType() && msg.hasContingencyType())) return false;
		if (!(!hasContingencyType() && !msg.hasContingencyType()) && !(getContingencyType()==msg.getContingencyType())) return false;
		if ((hasEncodedListExecInstLen() && !msg.hasEncodedListExecInstLen()) || (!hasEncodedListExecInstLen() && msg.hasEncodedListExecInstLen())) return false;
		if (!(!hasEncodedListExecInstLen() && !msg.hasEncodedListExecInstLen()) && !(getEncodedListExecInstLen()==msg.getEncodedListExecInstLen())) return false;
		if ((hasEncodedListExecInst() && !msg.hasEncodedListExecInst()) || (!hasEncodedListExecInst() && msg.hasEncodedListExecInst())) return false;
		if (!(!hasEncodedListExecInst() && !msg.hasEncodedListExecInst()) && !FixUtils.equals(getEncodedListExecInst(), msg.getEncodedListExecInst())) return false;
		if ((hasAllowableOneSidednessPct() && !msg.hasAllowableOneSidednessPct()) || (!hasAllowableOneSidednessPct() && msg.hasAllowableOneSidednessPct())) return false;
		if (!(!hasAllowableOneSidednessPct() && !msg.hasAllowableOneSidednessPct()) && !(getAllowableOneSidednessPct()==msg.getAllowableOneSidednessPct())) return false;
		if ((hasAllowableOneSidednessValue() && !msg.hasAllowableOneSidednessValue()) || (!hasAllowableOneSidednessValue() && msg.hasAllowableOneSidednessValue())) return false;
		if (!(!hasAllowableOneSidednessValue() && !msg.hasAllowableOneSidednessValue()) && !(getAllowableOneSidednessValue()==msg.getAllowableOneSidednessValue())) return false;
		if ((hasAllowableOneSidednessCurr() && !msg.hasAllowableOneSidednessCurr()) || (!hasAllowableOneSidednessCurr() && msg.hasAllowableOneSidednessCurr())) return false;
		if (!(!hasAllowableOneSidednessCurr() && !msg.hasAllowableOneSidednessCurr()) && !FixUtils.equals(getAllowableOneSidednessCurr(), msg.getAllowableOneSidednessCurr())) return false;
		if ((hasTotNoOrders() && !msg.hasTotNoOrders()) || (!hasTotNoOrders() && msg.hasTotNoOrders())) return false;
		if (!(!hasTotNoOrders() && !msg.hasTotNoOrders()) && !(getTotNoOrders()==msg.getTotNoOrders())) return false;
		if ((hasLastFragment() && !msg.hasLastFragment()) || (!hasLastFragment() && msg.hasLastFragment())) return false;
		if (!(!hasLastFragment() && !msg.hasLastFragment()) && !(getLastFragment()==msg.getLastFragment())) return false;
		return true;
	}
	@Override
	public FixNewOrderList clone () {
		FixNewOrderList out = new FixNewOrderList();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixNewOrderList clone ( FixNewOrderList out ) {
		if ( hasListID())
			out.setListID(getListID());
		if ( hasBidID())
			out.setBidID(getBidID());
		if ( hasClientBidID())
			out.setClientBidID(getClientBidID());
		if ( hasProgRptReqs())
			out.setProgRptReqs(getProgRptReqs());
		if ( hasBidType())
			out.setBidType(getBidType());
		if ( hasProgPeriodInterval())
			out.setProgPeriodInterval(getProgPeriodInterval());
		if ( hasCancellationRights())
			out.setCancellationRights(getCancellationRights());
		if ( hasMoneyLaunderingStatus())
			out.setMoneyLaunderingStatus(getMoneyLaunderingStatus());
		if ( hasRegistID())
			out.setRegistID(getRegistID());
		if ( hasListExecInstType())
			out.setListExecInstType(getListExecInstType());
		if ( hasListExecInst())
			out.setListExecInst(getListExecInst());
		if ( hasContingencyType())
			out.setContingencyType(getContingencyType());
		if ( hasEncodedListExecInstLen())
			out.setEncodedListExecInstLen(getEncodedListExecInstLen());
		if ( hasEncodedListExecInst())
			out.setEncodedListExecInst(getEncodedListExecInst());
		if ( hasAllowableOneSidednessPct())
			out.setAllowableOneSidednessPct(getAllowableOneSidednessPct());
		if ( hasAllowableOneSidednessValue())
			out.setAllowableOneSidednessValue(getAllowableOneSidednessValue());
		if ( hasAllowableOneSidednessCurr())
			out.setAllowableOneSidednessCurr(getAllowableOneSidednessCurr());
		if ( hasTotNoOrders())
			out.setTotNoOrders(getTotNoOrders());
		if ( hasLastFragment())
			out.setLastFragment(getLastFragment());
		int count = 0;
		count = 0;
		for (FixRootParties fixRootParties : rootParties) {
			if (!fixRootParties.hasGroup()) continue;
			out.rootParties[count] = fixRootParties.clone( out.rootParties[count] );
			count++;
		}
		count = 0;
		for (FixListOrdGrp fixListOrdGrp : listOrdGrp) {
			if (!fixListOrdGrp.hasGroup()) continue;
			out.listOrdGrp[count] = fixListOrdGrp.clone( out.listOrdGrp[count] );
			count++;
		}
		return out;
	}

}
