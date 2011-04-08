package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixAdjustedPositionReport extends FixInMessage {
	private short hasPosMaintRptID;
	byte[] posMaintRptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPosReqType;
	long posReqType = 0;		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlSessID;
	byte[] settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlPrice;
	long settlPrice = 0;		
	private short hasPosMaintRptRefID;
	byte[] posMaintRptRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPriorSettlPrice;
	long priorSettlPrice = 0;		
	public FixParties[] parties;
	public FixPositionQty[] positionQty;
	public FixInstrmtGrp[] instrmtGrp;
	
	public FixAdjustedPositionReport() {
		super(FixMessageInfo.MessageTypes.ADJUSTEDPOSITIONREPORT);


		hasPosMaintRptID = FixUtils.TAG_HAS_NO_VALUE;		
		posMaintRptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPosReqType = FixUtils.TAG_HAS_NO_VALUE;		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlSessID = FixUtils.TAG_HAS_NO_VALUE;		
		settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasPosMaintRptRefID = FixUtils.TAG_HAS_NO_VALUE;		
		posMaintRptRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPriorSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		positionQty = new FixPositionQty[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) positionQty[i] = new FixPositionQty();
		instrmtGrp = new FixInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtGrp[i] = new FixInstrmtGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.POSMAINTRPTID_INT:		
            		hasPosMaintRptID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.POSREQTYPE_INT:		
            		hasPosReqType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLSESSID_INT:		
            		hasSettlSessID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLPRICE_INT:		
            		hasSettlPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.POSMAINTRPTREFID_INT:		
            		hasPosMaintRptRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRIORSETTLPRICE_INT:		
            		hasPriorSettlPrice = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOPOSITIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !positionQty[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = positionQty[count].setBuffer( repeatingGroupTag, buf, err);	
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
        					if ( !instrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = instrmtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.ADJUSTEDPOSITIONREPORT);
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

		if (!hasPosMaintRptID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.POSMAINTRPTID_INT, FixMessageInfo.MessageTypes.ADJUSTEDPOSITIONREPORT);
			return false;
		}
		if (!hasClearingBusinessDate()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CLEARINGBUSINESSDATE_INT, FixMessageInfo.MessageTypes.ADJUSTEDPOSITIONREPORT);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (parties[i].hasGroup()) parties[i].hasRequiredTags(err); if (err.hasError()) return false; }
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (positionQty[i].hasGroup()) positionQty[i].hasRequiredTags(err); if (err.hasError()) return false; }
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getPosMaintRptID();		
		getPosReqType();		
		getClearingBusinessDate();		
		getSettlSessID();		
		getSettlPrice();		
		getPosMaintRptRefID();		
		getPriorSettlPrice();		
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
		if (hasPosMaintRptID()) {		
			out.put(FixTags.POSMAINTRPTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,posMaintRptID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPosReqType()) {		
			out.put(FixTags.POSREQTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)posReqType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlSessID()) {		
			out.put(FixTags.SETTLSESSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlSessID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlPrice()) {		
			out.put(FixTags.SETTLPRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)settlPrice);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPosMaintRptRefID()) {		
			out.put(FixTags.POSMAINTRPTREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,posMaintRptRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriorSettlPrice()) {		
			out.put(FixTags.PRIORSETTLPRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priorSettlPrice);
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(positionQty)>0) {
			out.put(FixTags.NOPOSITIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(positionQty));

			out.put(FixUtils.SOH);

		}
		for (FixPositionQty fixPositionQty : positionQty) if (fixPositionQty.hasGroup()) fixPositionQty.encode(out);
		if (FixUtils.getNoInGroup(instrmtGrp)>0) {
			out.put(FixTags.NORELATEDSYM);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtGrp fixInstrmtGrp : instrmtGrp) if (fixInstrmtGrp.hasGroup()) fixInstrmtGrp.encode(out);
		
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
		
		if (hasPosMaintRptID()) {		
			FixUtils.put(out,posMaintRptID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPosReqType()) {		
			FixUtils.put(out, (long)posReqType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlSessID()) {		
			FixUtils.put(out,settlSessID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlPrice()) {		
			FixUtils.put(out, (long)settlPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPosMaintRptRefID()) {		
			FixUtils.put(out,posMaintRptRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriorSettlPrice()) {		
			FixUtils.put(out, (long)priorSettlPrice);
		
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
			
	public void crackPosMaintRptID() {		
		getPosMaintRptID();		
	}		
			
	public byte[] getPosMaintRptID() { 		
		if ( hasPosMaintRptID()) {		
			if (hasPosMaintRptID == FixUtils.TAG_HAS_VALUE) {		
				return posMaintRptID; 		
			} else {

				buf.position(hasPosMaintRptID);

			FixMessage.getTagStringValue(buf, posMaintRptID, 0, posMaintRptID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasPosMaintRptID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return posMaintRptID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPosMaintRptID() { return hasPosMaintRptID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPosMaintRptID(byte[] src) {		
		if (src == null ) return;
		if (hasPosMaintRptID()) FixUtils.fillNul(posMaintRptID);		
		FixUtils.copy(posMaintRptID, src); 		
		hasPosMaintRptID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosMaintRptID(String str) {		
		if (str == null ) return;
		if (hasPosMaintRptID()) FixUtils.fillNul(posMaintRptID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(posMaintRptID, src); 		
		hasPosMaintRptID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPosReqType() {		
		getPosReqType();		
	}		
			
	public long getPosReqType() { 		
		if ( hasPosReqType()) {		
			if (hasPosReqType == FixUtils.TAG_HAS_VALUE) {		
				return posReqType; 		
			} else {

				buf.position(hasPosReqType);

			posReqType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPosReqType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return posReqType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPosReqType() { return hasPosReqType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPosReqType(byte[] src) {		
		if (src == null ) return;
		if (hasPosReqType()) posReqType = FixUtils.TAG_HAS_NO_VALUE;		
		posReqType = FixUtils.longValueOf(src, 0, src.length);
		hasPosReqType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosReqType(long src) {		
		posReqType = src;
		hasPosReqType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosReqType(String str) {		
		if (str == null ) return;
		if (hasPosReqType()) posReqType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		posReqType = FixUtils.longValueOf(src, 0, src.length);
		hasPosReqType = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackSettlSessID() {		
		getSettlSessID();		
	}		
			
	public byte[] getSettlSessID() { 		
		if ( hasSettlSessID()) {		
			if (hasSettlSessID == FixUtils.TAG_HAS_VALUE) {		
				return settlSessID; 		
			} else {

				buf.position(hasSettlSessID);

			FixMessage.getTagStringValue(buf, settlSessID, 0, settlSessID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlSessID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlSessID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlSessID() { return hasSettlSessID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlSessID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlSessID()) FixUtils.fillNul(settlSessID);		
		FixUtils.copy(settlSessID, src); 		
		hasSettlSessID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlSessID(String str) {		
		if (str == null ) return;
		if (hasSettlSessID()) FixUtils.fillNul(settlSessID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlSessID, src); 		
		hasSettlSessID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlPrice() {		
		getSettlPrice();		
	}		
			
	public long getSettlPrice() { 		
		if ( hasSettlPrice()) {		
			if (hasSettlPrice == FixUtils.TAG_HAS_VALUE) {		
				return settlPrice; 		
			} else {

				buf.position(hasSettlPrice);

			settlPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasSettlPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlPrice() { return hasSettlPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlPrice(byte[] src) {		
		if (src == null ) return;
		if (hasSettlPrice()) settlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		settlPrice = FixUtils.longValueOf(src, 0, src.length);
		hasSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlPrice(long src) {		
		settlPrice = src;
		hasSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlPrice(String str) {		
		if (str == null ) return;
		if (hasSettlPrice()) settlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlPrice = FixUtils.longValueOf(src, 0, src.length);
		hasSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPosMaintRptRefID() {		
		getPosMaintRptRefID();		
	}		
			
	public byte[] getPosMaintRptRefID() { 		
		if ( hasPosMaintRptRefID()) {		
			if (hasPosMaintRptRefID == FixUtils.TAG_HAS_VALUE) {		
				return posMaintRptRefID; 		
			} else {

				buf.position(hasPosMaintRptRefID);

			FixMessage.getTagStringValue(buf, posMaintRptRefID, 0, posMaintRptRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasPosMaintRptRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return posMaintRptRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPosMaintRptRefID() { return hasPosMaintRptRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPosMaintRptRefID(byte[] src) {		
		if (src == null ) return;
		if (hasPosMaintRptRefID()) FixUtils.fillNul(posMaintRptRefID);		
		FixUtils.copy(posMaintRptRefID, src); 		
		hasPosMaintRptRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosMaintRptRefID(String str) {		
		if (str == null ) return;
		if (hasPosMaintRptRefID()) FixUtils.fillNul(posMaintRptRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(posMaintRptRefID, src); 		
		hasPosMaintRptRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPriorSettlPrice() {		
		getPriorSettlPrice();		
	}		
			
	public long getPriorSettlPrice() { 		
		if ( hasPriorSettlPrice()) {		
			if (hasPriorSettlPrice == FixUtils.TAG_HAS_VALUE) {		
				return priorSettlPrice; 		
			} else {

				buf.position(hasPriorSettlPrice);

			priorSettlPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPriorSettlPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return priorSettlPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriorSettlPrice() { return hasPriorSettlPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPriorSettlPrice(byte[] src) {		
		if (src == null ) return;
		if (hasPriorSettlPrice()) priorSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		priorSettlPrice = FixUtils.longValueOf(src, 0, src.length);
		hasPriorSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriorSettlPrice(long src) {		
		priorSettlPrice = src;
		hasPriorSettlPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriorSettlPrice(String str) {		
		if (str == null ) return;
		if (hasPriorSettlPrice()) priorSettlPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priorSettlPrice = FixUtils.longValueOf(src, 0, src.length);
		hasPriorSettlPrice = FixUtils.TAG_HAS_VALUE;		
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

					if (hasPosMaintRptID()) s += "PosMaintRptID(721)= " + new String( FixUtils.trim(getPosMaintRptID()) ) + "\n" ; 
		if (hasPosReqType()) s += "PosReqType(724)= " + getPosReqType() + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasSettlSessID()) s += "SettlSessID(716)= " + new String( FixUtils.trim(getSettlSessID()) ) + "\n" ; 
		if (hasSettlPrice()) s += "SettlPrice(730)= " + getSettlPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPosMaintRptRefID()) s += "PosMaintRptRefID(714)= " + new String( FixUtils.trim(getPosMaintRptRefID()) ) + "\n" ; 
		if (hasPriorSettlPrice()) s += "PriorSettlPrice(734)= " + getPriorSettlPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixAdjustedPositionReport)) return false;

		FixAdjustedPositionReport msg = (FixAdjustedPositionReport) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasPosMaintRptID() && !msg.hasPosMaintRptID()) || (!hasPosMaintRptID() && msg.hasPosMaintRptID())) return false;
		if (!(!hasPosMaintRptID() && !msg.hasPosMaintRptID()) && !FixUtils.equals(getPosMaintRptID(), msg.getPosMaintRptID())) return false;
		if ((hasPosReqType() && !msg.hasPosReqType()) || (!hasPosReqType() && msg.hasPosReqType())) return false;
		if (!(!hasPosReqType() && !msg.hasPosReqType()) && !(getPosReqType()==msg.getPosReqType())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if ((hasSettlSessID() && !msg.hasSettlSessID()) || (!hasSettlSessID() && msg.hasSettlSessID())) return false;
		if (!(!hasSettlSessID() && !msg.hasSettlSessID()) && !FixUtils.equals(getSettlSessID(), msg.getSettlSessID())) return false;
		if ((hasSettlPrice() && !msg.hasSettlPrice()) || (!hasSettlPrice() && msg.hasSettlPrice())) return false;
		if (!(!hasSettlPrice() && !msg.hasSettlPrice()) && !(getSettlPrice()==msg.getSettlPrice())) return false;
		if ((hasPosMaintRptRefID() && !msg.hasPosMaintRptRefID()) || (!hasPosMaintRptRefID() && msg.hasPosMaintRptRefID())) return false;
		if (!(!hasPosMaintRptRefID() && !msg.hasPosMaintRptRefID()) && !FixUtils.equals(getPosMaintRptRefID(), msg.getPosMaintRptRefID())) return false;
		if ((hasPriorSettlPrice() && !msg.hasPriorSettlPrice()) || (!hasPriorSettlPrice() && msg.hasPriorSettlPrice())) return false;
		if (!(!hasPriorSettlPrice() && !msg.hasPriorSettlPrice()) && !(getPriorSettlPrice()==msg.getPriorSettlPrice())) return false;
		return true;
	}
	@Override
	public FixAdjustedPositionReport clone () {
		FixAdjustedPositionReport out = new FixAdjustedPositionReport();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixAdjustedPositionReport clone ( FixAdjustedPositionReport out ) {
		if ( hasPosMaintRptID())
			out.setPosMaintRptID(getPosMaintRptID());
		if ( hasPosReqType())
			out.setPosReqType(getPosReqType());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasSettlSessID())
			out.setSettlSessID(getSettlSessID());
		if ( hasSettlPrice())
			out.setSettlPrice(getSettlPrice());
		if ( hasPosMaintRptRefID())
			out.setPosMaintRptRefID(getPosMaintRptRefID());
		if ( hasPriorSettlPrice())
			out.setPriorSettlPrice(getPriorSettlPrice());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixPositionQty fixPositionQty : positionQty) {
			if (!fixPositionQty.hasGroup()) continue;
			out.positionQty[count] = fixPositionQty.clone( out.positionQty[count] );
			count++;
		}
		count = 0;
		for (FixInstrmtGrp fixInstrmtGrp : instrmtGrp) {
			if (!fixInstrmtGrp.hasGroup()) continue;
			out.instrmtGrp[count] = fixInstrmtGrp.clone( out.instrmtGrp[count] );
			count++;
		}
		return out;
	}

}
