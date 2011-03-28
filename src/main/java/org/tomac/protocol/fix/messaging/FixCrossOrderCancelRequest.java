package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixCrossOrderCancelRequest extends FixInMessage {
	private short hasOrderID;
	byte[] orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCrossID;
	byte[] crossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrigCrossID;
	byte[] origCrossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasHostCrossID;
	byte[] hostCrossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCrossType;
	long crossType = 0;		
	private short hasCrossPrioritization;
	long crossPrioritization = 0;		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	FixRootParties[] rootParties;
	FixSideCrossOrdCxlGrp[] sideCrossOrdCxlGrp;
	FixInstrument instrument;
	FixUndInstrmtGrp[] undInstrmtGrp;
	FixInstrmtLegGrp[] instrmtLegGrp;
	
	public FixCrossOrderCancelRequest() {
		super(FixMessageInfo.MessageTypes.CROSSORDERCANCELREQUEST);


		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCrossID = FixUtils.TAG_HAS_NO_VALUE;		
		crossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrigCrossID = FixUtils.TAG_HAS_NO_VALUE;		
		origCrossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasHostCrossID = FixUtils.TAG_HAS_NO_VALUE;		
		hostCrossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCrossType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCrossPrioritization = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		rootParties = new FixRootParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rootParties[i] = new FixRootParties();
		sideCrossOrdCxlGrp = new FixSideCrossOrdCxlGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) sideCrossOrdCxlGrp[i] = new FixSideCrossOrdCxlGrp();
		instrument = new FixInstrument();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.ORDERID_INT:		
            		hasOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CROSSID_INT:		
            		hasCrossID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORIGCROSSID_INT:		
            		hasOrigCrossID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.HOSTCROSSID_INT:		
            		hasHostCrossID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CROSSTYPE_INT:		
            		hasCrossType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CROSSPRIORITIZATION_INT:		
            		hasCrossPrioritization = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOSIDES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !sideCrossOrdCxlGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = sideCrossOrdCxlGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
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
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !undInstrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
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
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		if (!hasCrossID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag CrossID missing", FixTags.CROSSID_INT, FixMessageInfo.MessageTypes.CROSSORDERCANCELREQUEST);
			return false;
		}
		if (!hasOrigCrossID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag OrigCrossID missing", FixTags.ORIGCROSSID_INT, FixMessageInfo.MessageTypes.CROSSORDERCANCELREQUEST);
			return false;
		}
		if (!hasCrossType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag CrossType missing", FixTags.CROSSTYPE_INT, FixMessageInfo.MessageTypes.CROSSORDERCANCELREQUEST);
			return false;
		}
		if (!hasCrossPrioritization()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag CrossPrioritization missing", FixTags.CROSSPRIORITIZATION_INT, FixMessageInfo.MessageTypes.CROSSORDERCANCELREQUEST);
			return false;
		}
		if (!hasTransactTime()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TransactTime missing", FixTags.TRANSACTTIME_INT, FixMessageInfo.MessageTypes.CROSSORDERCANCELREQUEST);
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
		if (hasOrderID()) {		
			out.put(FixTags.ORDERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCrossID()) {		
			out.put(FixTags.CROSSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,crossID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrigCrossID()) {		
			out.put(FixTags.ORIGCROSSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,origCrossID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasHostCrossID()) {		
			out.put(FixTags.HOSTCROSSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,hostCrossID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCrossType()) {		
			out.put(FixTags.CROSSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)crossType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCrossPrioritization()) {		
			out.put(FixTags.CROSSPRIORITIZATION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)crossPrioritization);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
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
		
		if (hasOrderID()) {		
			FixUtils.put(out,orderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCrossID()) {		
			FixUtils.put(out,crossID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigCrossID()) {		
			FixUtils.put(out,origCrossID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHostCrossID()) {		
			FixUtils.put(out,hostCrossID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCrossType()) {		
			FixUtils.put(out, (long)crossType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCrossPrioritization()) {		
			FixUtils.put(out, (long)crossPrioritization);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
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
			
	public void crackOrderID() {		
		getOrderID();		
	}		
			
	public byte[] getOrderID() { 		
		if ( hasOrderID()) {		
			if (hasOrderID == FixUtils.TAG_HAS_VALUE) {		
				return orderID; 		
			} else {

				buf.position(hasOrderID);

			FixMessage.getTagStringValue(buf, orderID, 0, orderID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrderID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderID() { return hasOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasOrderID()) FixUtils.fillSpace(orderID);		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderID(String str) {		
		if (str == null ) return;
		if (hasOrderID()) FixUtils.fillSpace(orderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCrossID() {		
		getCrossID();		
	}		
			
	public byte[] getCrossID() { 		
		if ( hasCrossID()) {		
			if (hasCrossID == FixUtils.TAG_HAS_VALUE) {		
				return crossID; 		
			} else {

				buf.position(hasCrossID);

			FixMessage.getTagStringValue(buf, crossID, 0, crossID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCrossID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return crossID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCrossID() { return hasCrossID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCrossID(byte[] src) {		
		if (src == null ) return;
		if (hasCrossID()) FixUtils.fillSpace(crossID);		
		FixUtils.copy(crossID, src); 		
		hasCrossID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossID(String str) {		
		if (str == null ) return;
		if (hasCrossID()) FixUtils.fillSpace(crossID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(crossID, src); 		
		hasCrossID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrigCrossID() {		
		getOrigCrossID();		
	}		
			
	public byte[] getOrigCrossID() { 		
		if ( hasOrigCrossID()) {		
			if (hasOrigCrossID == FixUtils.TAG_HAS_VALUE) {		
				return origCrossID; 		
			} else {

				buf.position(hasOrigCrossID);

			FixMessage.getTagStringValue(buf, origCrossID, 0, origCrossID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrigCrossID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return origCrossID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigCrossID() { return hasOrigCrossID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrigCrossID(byte[] src) {		
		if (src == null ) return;
		if (hasOrigCrossID()) FixUtils.fillSpace(origCrossID);		
		FixUtils.copy(origCrossID, src); 		
		hasOrigCrossID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigCrossID(String str) {		
		if (str == null ) return;
		if (hasOrigCrossID()) FixUtils.fillSpace(origCrossID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origCrossID, src); 		
		hasOrigCrossID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackHostCrossID() {		
		getHostCrossID();		
	}		
			
	public byte[] getHostCrossID() { 		
		if ( hasHostCrossID()) {		
			if (hasHostCrossID == FixUtils.TAG_HAS_VALUE) {		
				return hostCrossID; 		
			} else {

				buf.position(hasHostCrossID);

			FixMessage.getTagStringValue(buf, hostCrossID, 0, hostCrossID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasHostCrossID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return hostCrossID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasHostCrossID() { return hasHostCrossID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setHostCrossID(byte[] src) {		
		if (src == null ) return;
		if (hasHostCrossID()) FixUtils.fillSpace(hostCrossID);		
		FixUtils.copy(hostCrossID, src); 		
		hasHostCrossID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHostCrossID(String str) {		
		if (str == null ) return;
		if (hasHostCrossID()) FixUtils.fillSpace(hostCrossID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(hostCrossID, src); 		
		hasHostCrossID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCrossType() {		
		getCrossType();		
	}		
			
	public long getCrossType() { 		
		if ( hasCrossType()) {		
			if (hasCrossType == FixUtils.TAG_HAS_VALUE) {		
				return crossType; 		
			} else {

				buf.position(hasCrossType);

			crossType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCrossType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return crossType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCrossType() { return hasCrossType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCrossType(byte[] src) {		
		if (src == null ) return;
		if (hasCrossType()) crossType = FixUtils.TAG_HAS_NO_VALUE;		
		crossType = FixUtils.longValueOf(src, 0, src.length);
		hasCrossType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossType(long src) {		
		crossType = src;
		hasCrossType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossType(String str) {		
		if (str == null ) return;
		if (hasCrossType()) crossType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		crossType = FixUtils.longValueOf(src, 0, src.length);
		hasCrossType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCrossPrioritization() {		
		getCrossPrioritization();		
	}		
			
	public long getCrossPrioritization() { 		
		if ( hasCrossPrioritization()) {		
			if (hasCrossPrioritization == FixUtils.TAG_HAS_VALUE) {		
				return crossPrioritization; 		
			} else {

				buf.position(hasCrossPrioritization);

			crossPrioritization = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCrossPrioritization = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return crossPrioritization;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCrossPrioritization() { return hasCrossPrioritization != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCrossPrioritization(byte[] src) {		
		if (src == null ) return;
		if (hasCrossPrioritization()) crossPrioritization = FixUtils.TAG_HAS_NO_VALUE;		
		crossPrioritization = FixUtils.longValueOf(src, 0, src.length);
		hasCrossPrioritization = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossPrioritization(long src) {		
		crossPrioritization = src;
		hasCrossPrioritization = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossPrioritization(String str) {		
		if (str == null ) return;
		if (hasCrossPrioritization()) crossPrioritization = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		crossPrioritization = FixUtils.longValueOf(src, 0, src.length);
		hasCrossPrioritization = FixUtils.TAG_HAS_VALUE;		
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

					if (hasOrderID()) s += "OrderID(37)= " + new String( FixUtils.trim(getOrderID()) ) + "\n" ; 
		if (hasCrossID()) s += "CrossID(548)= " + new String( FixUtils.trim(getCrossID()) ) + "\n" ; 
		if (hasOrigCrossID()) s += "OrigCrossID(551)= " + new String( FixUtils.trim(getOrigCrossID()) ) + "\n" ; 
		if (hasHostCrossID()) s += "HostCrossID(961)= " + new String( FixUtils.trim(getHostCrossID()) ) + "\n" ; 
		if (hasCrossType()) s += "CrossType(549)= " + getCrossType() + "\n" ; 
		if (hasCrossPrioritization()) s += "CrossPrioritization(550)= " + getCrossPrioritization() + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixCrossOrderCancelRequest)) return false;

		FixCrossOrderCancelRequest msg = (FixCrossOrderCancelRequest) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasCrossID() && !msg.hasCrossID()) || (!hasCrossID() && msg.hasCrossID())) return false;
		if (!(!hasCrossID() && !msg.hasCrossID()) && !FixUtils.equals(getCrossID(), msg.getCrossID())) return false;
		if ((hasOrigCrossID() && !msg.hasOrigCrossID()) || (!hasOrigCrossID() && msg.hasOrigCrossID())) return false;
		if (!(!hasOrigCrossID() && !msg.hasOrigCrossID()) && !FixUtils.equals(getOrigCrossID(), msg.getOrigCrossID())) return false;
		if ((hasHostCrossID() && !msg.hasHostCrossID()) || (!hasHostCrossID() && msg.hasHostCrossID())) return false;
		if (!(!hasHostCrossID() && !msg.hasHostCrossID()) && !FixUtils.equals(getHostCrossID(), msg.getHostCrossID())) return false;
		if ((hasCrossType() && !msg.hasCrossType()) || (!hasCrossType() && msg.hasCrossType())) return false;
		if (!(!hasCrossType() && !msg.hasCrossType()) && !(getCrossType()==msg.getCrossType())) return false;
		if ((hasCrossPrioritization() && !msg.hasCrossPrioritization()) || (!hasCrossPrioritization() && msg.hasCrossPrioritization())) return false;
		if (!(!hasCrossPrioritization() && !msg.hasCrossPrioritization()) && !(getCrossPrioritization()==msg.getCrossPrioritization())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if (!(!hasTransactTime() && !msg.hasTransactTime()) ) return false;
		return true;
	}
	@Override
	public FixCrossOrderCancelRequest clone () {
		FixCrossOrderCancelRequest out = new FixCrossOrderCancelRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixCrossOrderCancelRequest clone ( FixCrossOrderCancelRequest out ) {
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasCrossID())
			out.setCrossID(getCrossID());
		if ( hasOrigCrossID())
			out.setOrigCrossID(getOrigCrossID());
		if ( hasHostCrossID())
			out.setHostCrossID(getHostCrossID());
		if ( hasCrossType())
			out.setCrossType(getCrossType());
		if ( hasCrossPrioritization())
			out.setCrossPrioritization(getCrossPrioritization());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		int count = 0;
		count = 0;
		for (FixRootParties fixRootParties : rootParties) {
			if (!fixRootParties.hasGroup()) continue;
			out.rootParties[count] = fixRootParties.clone( out.rootParties[count] );
			count++;
		}
		count = 0;
		for (FixSideCrossOrdCxlGrp fixSideCrossOrdCxlGrp : sideCrossOrdCxlGrp) {
			if (!fixSideCrossOrdCxlGrp.hasGroup()) continue;
			out.sideCrossOrdCxlGrp[count] = fixSideCrossOrdCxlGrp.clone( out.sideCrossOrdCxlGrp[count] );
			count++;
		}
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
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
		return out;
	}

}
