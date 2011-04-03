package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixEmail extends FixInMessage {
	private short hasEmailThreadID;
	byte[] emailThreadID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEmailType;
	byte emailType = (byte)' ';		
	private short hasOrigTime;
	byte[] origTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasSubject;
	byte[] subject = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEncodedSubjectLen;
	long encodedSubjectLen = 0;		
	private short hasEncodedSubject;
	byte[] encodedSubject = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderID;
	byte[] orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRawDataLength;
	long rawDataLength = 0;		
	private short hasRawData;
	byte[] rawData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	public FixRoutingGrp[] routingGrp;
	public FixInstrmtGrp[] instrmtGrp;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	public FixLinesOfTextGrp[] linesOfTextGrp;
	
	public FixEmail() {
		super(FixMessageInfo.MessageTypes.EMAIL);


		hasEmailThreadID = FixUtils.TAG_HAS_NO_VALUE;		
		emailThreadID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEmailType = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrigTime = FixUtils.TAG_HAS_NO_VALUE;		
		origTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasSubject = FixUtils.TAG_HAS_NO_VALUE;		
		subject = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEncodedSubjectLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedSubject = FixUtils.TAG_HAS_NO_VALUE;		
		encodedSubject = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRawDataLength = FixUtils.TAG_HAS_NO_VALUE;		
		hasRawData = FixUtils.TAG_HAS_NO_VALUE;		
		rawData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		routingGrp = new FixRoutingGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) routingGrp[i] = new FixRoutingGrp();
		instrmtGrp = new FixInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtGrp[i] = new FixInstrmtGrp();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		linesOfTextGrp = new FixLinesOfTextGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) linesOfTextGrp[i] = new FixLinesOfTextGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.EMAILTHREADID_INT:		
            		hasEmailThreadID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EMAILTYPE_INT:		
            		hasEmailType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORIGTIME_INT:		
            		hasOrigTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SUBJECT_INT:		
            		hasSubject = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDSUBJECTLEN_INT:		
            		hasEncodedSubjectLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDSUBJECT_INT:		
            		hasEncodedSubject = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDERID_INT:		
            		hasOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RAWDATALENGTH_INT:		
            		hasRawDataLength = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RAWDATA_INT:		
            		hasRawData = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOROUTINGIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
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
        			} else if ( tag == FixTags.NOUNDERLYINGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !undInstrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
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
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOLINESOFTEXT_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !linesOfTextGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = linesOfTextGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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

		if (!hasEmailThreadID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag EmailThreadID missing", FixTags.EMAILTHREADID_INT, FixMessageInfo.MessageTypes.EMAIL);
			return false;
		}
		if (!hasEmailType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag EmailType missing", FixTags.EMAILTYPE_INT, FixMessageInfo.MessageTypes.EMAIL);
			return false;
		}
		if (!hasSubject()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Subject missing", FixTags.SUBJECT_INT, FixMessageInfo.MessageTypes.EMAIL);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (linesOfTextGrp[i].hasGroup()) linesOfTextGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
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
		if (hasEmailThreadID()) {		
			out.put(FixTags.EMAILTHREADID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,emailThreadID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEmailType()) {		
			out.put(FixTags.EMAILTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,emailType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrigTime()) {		
			out.put(FixTags.ORIGTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,origTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSubject()) {		
			out.put(FixTags.SUBJECT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,subject); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedSubjectLen()) {		
			out.put(FixTags.ENCODEDSUBJECTLEN);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encodedSubjectLen);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedSubject()) {		
			out.put(FixTags.ENCODEDSUBJECT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,encodedSubject); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrderID()) {		
			out.put(FixTags.ORDERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRawDataLength()) {		
			out.put(FixTags.RAWDATALENGTH);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)rawDataLength);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRawData()) {		
			out.put(FixTags.RAWDATA);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,rawData); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(routingGrp)>0) {
			out.put(FixTags.NOROUTINGIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(routingGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRoutingGrp fixRoutingGrp : routingGrp) if (fixRoutingGrp.hasGroup()) fixRoutingGrp.encode(out);
		if (FixUtils.getNoInGroup(instrmtGrp)>0) {
			out.put(FixTags.NORELATEDSYM);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtGrp fixInstrmtGrp : instrmtGrp) if (fixInstrmtGrp.hasGroup()) fixInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(instrmtLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) if (fixInstrmtLegGrp.hasGroup()) fixInstrmtLegGrp.encode(out);
		if (FixUtils.getNoInGroup(linesOfTextGrp)>0) {
			out.put(FixTags.NOLINESOFTEXT);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(linesOfTextGrp));

			out.put(FixUtils.SOH);

		}
		for (FixLinesOfTextGrp fixLinesOfTextGrp : linesOfTextGrp) if (fixLinesOfTextGrp.hasGroup()) fixLinesOfTextGrp.encode(out);
		
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
		
		if (hasEmailThreadID()) {		
			FixUtils.put(out,emailThreadID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEmailType()) {		
			FixUtils.put(out,emailType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigTime()) {		
			FixUtils.put(out,origTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSubject()) {		
			FixUtils.put(out,subject); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedSubjectLen()) {		
			FixUtils.put(out, (long)encodedSubjectLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedSubject()) {		
			FixUtils.put(out,encodedSubject); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderID()) {		
			FixUtils.put(out,orderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRawDataLength()) {		
			FixUtils.put(out, (long)rawDataLength);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRawData()) {		
			FixUtils.put(out,rawData); 		
		
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
			
	public void crackEmailThreadID() {		
		getEmailThreadID();		
	}		
			
	public byte[] getEmailThreadID() { 		
		if ( hasEmailThreadID()) {		
			if (hasEmailThreadID == FixUtils.TAG_HAS_VALUE) {		
				return emailThreadID; 		
			} else {

				buf.position(hasEmailThreadID);

			FixMessage.getTagStringValue(buf, emailThreadID, 0, emailThreadID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEmailThreadID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return emailThreadID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEmailThreadID() { return hasEmailThreadID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEmailThreadID(byte[] src) {		
		if (src == null ) return;
		if (hasEmailThreadID()) FixUtils.fillSpace(emailThreadID);		
		FixUtils.copy(emailThreadID, src); 		
		hasEmailThreadID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEmailThreadID(String str) {		
		if (str == null ) return;
		if (hasEmailThreadID()) FixUtils.fillSpace(emailThreadID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(emailThreadID, src); 		
		hasEmailThreadID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEmailType() {		
		getEmailType();		
	}		
			
	public byte getEmailType() { 		
		if ( hasEmailType()) {		
			if (hasEmailType == FixUtils.TAG_HAS_VALUE) {		
				return emailType; 		
			} else {

				buf.position(hasEmailType);

			emailType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (emailType != (byte)'2') && (emailType != (byte)'1') && (emailType != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 94);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasEmailType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return emailType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasEmailType() { return hasEmailType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEmailType(byte[] src) {		
		if (src == null ) return;
		if (hasEmailType()) emailType = (byte)' ';		
		emailType = src[0];		
		hasEmailType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEmailType(byte src) {		
		emailType = src;
		hasEmailType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEmailType(String str) {		
		if (str == null ) return;
		if (hasEmailType()) emailType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		emailType = src[0];		
		hasEmailType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrigTime() {		
		getOrigTime();		
	}		
			
	public byte[] getOrigTime() { 		
		if ( hasOrigTime()) {		
			if (hasOrigTime == FixUtils.TAG_HAS_VALUE) {		
				return origTime; 		
			} else {

				buf.position(hasOrigTime);

			FixMessage.getTagStringValue(buf, origTime, 0, origTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrigTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return origTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigTime() { return hasOrigTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrigTime(byte[] src) {		
		if (src == null ) return;
		if (hasOrigTime()) FixUtils.fillSpace(origTime);		
		FixUtils.copy(origTime, src); 		
		hasOrigTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigTime(String str) {		
		if (str == null ) return;
		if (hasOrigTime()) FixUtils.fillSpace(origTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origTime, src); 		
		hasOrigTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSubject() {		
		getSubject();		
	}		
			
	public byte[] getSubject() { 		
		if ( hasSubject()) {		
			if (hasSubject == FixUtils.TAG_HAS_VALUE) {		
				return subject; 		
			} else {

				buf.position(hasSubject);

			FixMessage.getTagStringValue(buf, subject, 0, subject.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSubject = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return subject;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSubject() { return hasSubject != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSubject(byte[] src) {		
		if (src == null ) return;
		if (hasSubject()) FixUtils.fillSpace(subject);		
		FixUtils.copy(subject, src); 		
		hasSubject = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSubject(String str) {		
		if (str == null ) return;
		if (hasSubject()) FixUtils.fillSpace(subject);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(subject, src); 		
		hasSubject = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedSubjectLen() {		
		getEncodedSubjectLen();		
	}		
			
	public long getEncodedSubjectLen() { 		
		if ( hasEncodedSubjectLen()) {		
			if (hasEncodedSubjectLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedSubjectLen; 		
			} else {

				buf.position(hasEncodedSubjectLen);

			encodedSubjectLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncodedSubjectLen = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedSubjectLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedSubjectLen() { return hasEncodedSubjectLen != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedSubjectLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedSubjectLen()) encodedSubjectLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedSubjectLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedSubjectLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedSubjectLen(long src) {		
		encodedSubjectLen = src;
		hasEncodedSubjectLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedSubjectLen(String str) {		
		if (str == null ) return;
		if (hasEncodedSubjectLen()) encodedSubjectLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedSubjectLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedSubjectLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedSubject() {		
		getEncodedSubject();		
	}		
			
	public byte[] getEncodedSubject() { 		
		if ( hasEncodedSubject()) {		
			if (hasEncodedSubject == FixUtils.TAG_HAS_VALUE) {		
				return encodedSubject; 		
			} else {

				buf.position(hasEncodedSubject);

			FixMessage.getTagStringValue(buf, encodedSubject, 0, encodedSubject.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEncodedSubject = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedSubject;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedSubject() { return hasEncodedSubject != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedSubject(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedSubject()) FixUtils.fillSpace(encodedSubject);		
		FixUtils.copy(encodedSubject, src); 		
		hasEncodedSubject = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedSubject(String str) {		
		if (str == null ) return;
		if (hasEncodedSubject()) FixUtils.fillSpace(encodedSubject);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedSubject, src); 		
		hasEncodedSubject = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackClOrdID() {		
		getClOrdID();		
	}		
			
	public byte[] getClOrdID() { 		
		if ( hasClOrdID()) {		
			if (hasClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return clOrdID; 		
			} else {

				buf.position(hasClOrdID);

			FixMessage.getTagStringValue(buf, clOrdID, 0, clOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClOrdID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClOrdID() { return hasClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasClOrdID()) FixUtils.fillSpace(clOrdID);		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClOrdID(String str) {		
		if (str == null ) return;
		if (hasClOrdID()) FixUtils.fillSpace(clOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRawDataLength() {		
		getRawDataLength();		
	}		
			
	public long getRawDataLength() { 		
		if ( hasRawDataLength()) {		
			if (hasRawDataLength == FixUtils.TAG_HAS_VALUE) {		
				return rawDataLength; 		
			} else {

				buf.position(hasRawDataLength);

			rawDataLength = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasRawDataLength = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return rawDataLength;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRawDataLength() { return hasRawDataLength != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRawDataLength(byte[] src) {		
		if (src == null ) return;
		if (hasRawDataLength()) rawDataLength = FixUtils.TAG_HAS_NO_VALUE;		
		rawDataLength = FixUtils.longValueOf(src, 0, src.length);
		hasRawDataLength = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRawDataLength(long src) {		
		rawDataLength = src;
		hasRawDataLength = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRawDataLength(String str) {		
		if (str == null ) return;
		if (hasRawDataLength()) rawDataLength = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		rawDataLength = FixUtils.longValueOf(src, 0, src.length);
		hasRawDataLength = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRawData() {		
		getRawData();		
	}		
			
	public byte[] getRawData() { 		
		if ( hasRawData()) {		
			if (hasRawData == FixUtils.TAG_HAS_VALUE) {		
				return rawData; 		
			} else {

				buf.position(hasRawData);

			FixMessage.getTagStringValue(buf, rawData, 0, rawData.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRawData = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return rawData;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRawData() { return hasRawData != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRawData(byte[] src) {		
		if (src == null ) return;
		if (hasRawData()) FixUtils.fillSpace(rawData);		
		FixUtils.copy(rawData, src); 		
		hasRawData = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRawData(String str) {		
		if (str == null ) return;
		if (hasRawData()) FixUtils.fillSpace(rawData);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(rawData, src); 		
		hasRawData = FixUtils.TAG_HAS_VALUE;		
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

					if (hasEmailThreadID()) s += "EmailThreadID(164)= " + new String( FixUtils.trim(getEmailThreadID()) ) + "\n" ; 
		if (hasEmailType()) s += "EmailType(94)= " + getEmailType() + "\n" ; 
		if (hasOrigTime()) s += "OrigTime(42)= " + new String( FixUtils.trim(getOrigTime()) ) + "\n" ; 
		if (hasSubject()) s += "Subject(147)= " + new String( FixUtils.trim(getSubject()) ) + "\n" ; 
		if (hasEncodedSubjectLen()) s += "EncodedSubjectLen(356)= " + getEncodedSubjectLen() + "\n" ; 
		if (hasEncodedSubject()) s += "EncodedSubject(357)= " + new String( FixUtils.trim(getEncodedSubject()) ) + "\n" ; 
		if (hasOrderID()) s += "OrderID(37)= " + new String( FixUtils.trim(getOrderID()) ) + "\n" ; 
		if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasRawDataLength()) s += "RawDataLength(95)= " + getRawDataLength() + "\n" ; 
		if (hasRawData()) s += "RawData(96)= " + new String( FixUtils.trim(getRawData()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixEmail)) return false;

		FixEmail msg = (FixEmail) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasEmailThreadID() && !msg.hasEmailThreadID()) || (!hasEmailThreadID() && msg.hasEmailThreadID())) return false;
		if (!(!hasEmailThreadID() && !msg.hasEmailThreadID()) && !FixUtils.equals(getEmailThreadID(), msg.getEmailThreadID())) return false;
		if ((hasEmailType() && !msg.hasEmailType()) || (!hasEmailType() && msg.hasEmailType())) return false;
		if (!(!hasEmailType() && !msg.hasEmailType()) && !(getEmailType()==msg.getEmailType())) return false;
		if ((hasOrigTime() && !msg.hasOrigTime()) || (!hasOrigTime() && msg.hasOrigTime())) return false;
		if ((hasSubject() && !msg.hasSubject()) || (!hasSubject() && msg.hasSubject())) return false;
		if (!(!hasSubject() && !msg.hasSubject()) && !FixUtils.equals(getSubject(), msg.getSubject())) return false;
		if ((hasEncodedSubjectLen() && !msg.hasEncodedSubjectLen()) || (!hasEncodedSubjectLen() && msg.hasEncodedSubjectLen())) return false;
		if (!(!hasEncodedSubjectLen() && !msg.hasEncodedSubjectLen()) && !(getEncodedSubjectLen()==msg.getEncodedSubjectLen())) return false;
		if ((hasEncodedSubject() && !msg.hasEncodedSubject()) || (!hasEncodedSubject() && msg.hasEncodedSubject())) return false;
		if (!(!hasEncodedSubject() && !msg.hasEncodedSubject()) && !FixUtils.equals(getEncodedSubject(), msg.getEncodedSubject())) return false;
		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasRawDataLength() && !msg.hasRawDataLength()) || (!hasRawDataLength() && msg.hasRawDataLength())) return false;
		if (!(!hasRawDataLength() && !msg.hasRawDataLength()) && !(getRawDataLength()==msg.getRawDataLength())) return false;
		if ((hasRawData() && !msg.hasRawData()) || (!hasRawData() && msg.hasRawData())) return false;
		if (!(!hasRawData() && !msg.hasRawData()) && !FixUtils.equals(getRawData(), msg.getRawData())) return false;
		return true;
	}
	@Override
	public FixEmail clone () {
		FixEmail out = new FixEmail();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixEmail clone ( FixEmail out ) {
		if ( hasEmailThreadID())
			out.setEmailThreadID(getEmailThreadID());
		if ( hasEmailType())
			out.setEmailType(getEmailType());
		if ( hasOrigTime())
			out.setOrigTime(getOrigTime());
		if ( hasSubject())
			out.setSubject(getSubject());
		if ( hasEncodedSubjectLen())
			out.setEncodedSubjectLen(getEncodedSubjectLen());
		if ( hasEncodedSubject())
			out.setEncodedSubject(getEncodedSubject());
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasRawDataLength())
			out.setRawDataLength(getRawDataLength());
		if ( hasRawData())
			out.setRawData(getRawData());
		int count = 0;
		count = 0;
		for (FixRoutingGrp fixRoutingGrp : routingGrp) {
			if (!fixRoutingGrp.hasGroup()) continue;
			out.routingGrp[count] = fixRoutingGrp.clone( out.routingGrp[count] );
			count++;
		}
		count = 0;
		for (FixInstrmtGrp fixInstrmtGrp : instrmtGrp) {
			if (!fixInstrmtGrp.hasGroup()) continue;
			out.instrmtGrp[count] = fixInstrmtGrp.clone( out.instrmtGrp[count] );
			count++;
		}
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
		count = 0;
		for (FixLinesOfTextGrp fixLinesOfTextGrp : linesOfTextGrp) {
			if (!fixLinesOfTextGrp.hasGroup()) continue;
			out.linesOfTextGrp[count] = fixLinesOfTextGrp.clone( out.linesOfTextGrp[count] );
			count++;
		}
		return out;
	}

}
