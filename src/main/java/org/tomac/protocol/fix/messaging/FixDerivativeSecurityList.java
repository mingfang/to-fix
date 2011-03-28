package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixDerivativeSecurityList extends FixInMessage {
	private short hasSecurityReportID;
	long securityReportID = 0;		
	private short hasSecurityReqID;
	byte[] securityReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityResponseID;
	byte[] securityResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityRequestResult;
	long securityRequestResult = 0;		
	private short hasClearingBusinessDate;
	byte[] clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTotNoRelatedSym;
	long totNoRelatedSym = 0;		
	private short hasLastFragment;
		boolean lastFragment = false;		
	FixApplicationSequenceControl applicationSequenceControl;
	FixUnderlyingInstrument underlyingInstrument;
	FixDerivativeSecurityDefinition derivativeSecurityDefinition;
	FixRelSymDerivSecGrp[] relSymDerivSecGrp;
	
	public FixDerivativeSecurityList() {
		super(FixMessageInfo.MessageTypes.DERIVATIVESECURITYLIST);


		hasSecurityReportID = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityReqID = FixUtils.TAG_HAS_NO_VALUE;		
		securityReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityResponseID = FixUtils.TAG_HAS_NO_VALUE;		
		securityResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityRequestResult = FixUtils.TAG_HAS_NO_VALUE;		
		hasClearingBusinessDate = FixUtils.TAG_HAS_NO_VALUE;		
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTotNoRelatedSym = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastFragment = FixUtils.TAG_HAS_NO_VALUE;		
		applicationSequenceControl = new FixApplicationSequenceControl();
		underlyingInstrument = new FixUnderlyingInstrument();
		derivativeSecurityDefinition = new FixDerivativeSecurityDefinition();
		relSymDerivSecGrp = new FixRelSymDerivSecGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) relSymDerivSecGrp[i] = new FixRelSymDerivSecGrp();

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
            	case FixTags.CLEARINGBUSINESSDATE_INT:		
            		hasClearingBusinessDate = (short) buf.position();		
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
        			} else if ( underlyingInstrument.isKeyTag(tag)) {
        				tag = underlyingInstrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( derivativeSecurityDefinition.isKeyTag(tag)) {
        				tag = derivativeSecurityDefinition.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NORELATEDSYM_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !relSymDerivSecGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = relSymDerivSecGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		if (hasSecurityReportID()) {		
			out.put(FixTags.SECURITYREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)securityReportID);
		
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
		if (hasClearingBusinessDate()) {		
			out.put(FixTags.CLEARINGBUSINESSDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingBusinessDate); 		
		
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
		
		if (hasSecurityReportID()) {		
			FixUtils.put(out, (long)securityReportID);
		
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
		
		if (hasClearingBusinessDate()) {		
			FixUtils.put(out,clearingBusinessDate); 		
		
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

					if (hasSecurityReportID()) s += "SecurityReportID(964)= " + getSecurityReportID() + "\n" ; 
		if (hasSecurityReqID()) s += "SecurityReqID(320)= " + new String( FixUtils.trim(getSecurityReqID()) ) + "\n" ; 
		if (hasSecurityResponseID()) s += "SecurityResponseID(322)= " + new String( FixUtils.trim(getSecurityResponseID()) ) + "\n" ; 
		if (hasSecurityRequestResult()) s += "SecurityRequestResult(560)= " + getSecurityRequestResult() + "\n" ; 
		if (hasClearingBusinessDate()) s += "ClearingBusinessDate(715)= " + new String( FixUtils.trim(getClearingBusinessDate()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasTotNoRelatedSym()) s += "TotNoRelatedSym(393)= " + getTotNoRelatedSym() + "\n" ; 
		if (hasLastFragment()) s += "LastFragment(893)= " + getLastFragment() + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDerivativeSecurityList)) return false;

		FixDerivativeSecurityList msg = (FixDerivativeSecurityList) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasSecurityReportID() && !msg.hasSecurityReportID()) || (!hasSecurityReportID() && msg.hasSecurityReportID())) return false;
		if (!(!hasSecurityReportID() && !msg.hasSecurityReportID()) && !(getSecurityReportID()==msg.getSecurityReportID())) return false;
		if ((hasSecurityReqID() && !msg.hasSecurityReqID()) || (!hasSecurityReqID() && msg.hasSecurityReqID())) return false;
		if (!(!hasSecurityReqID() && !msg.hasSecurityReqID()) && !FixUtils.equals(getSecurityReqID(), msg.getSecurityReqID())) return false;
		if ((hasSecurityResponseID() && !msg.hasSecurityResponseID()) || (!hasSecurityResponseID() && msg.hasSecurityResponseID())) return false;
		if (!(!hasSecurityResponseID() && !msg.hasSecurityResponseID()) && !FixUtils.equals(getSecurityResponseID(), msg.getSecurityResponseID())) return false;
		if ((hasSecurityRequestResult() && !msg.hasSecurityRequestResult()) || (!hasSecurityRequestResult() && msg.hasSecurityRequestResult())) return false;
		if (!(!hasSecurityRequestResult() && !msg.hasSecurityRequestResult()) && !(getSecurityRequestResult()==msg.getSecurityRequestResult())) return false;
		if ((hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) || (!hasClearingBusinessDate() && msg.hasClearingBusinessDate())) return false;
		if (!(!hasClearingBusinessDate() && !msg.hasClearingBusinessDate()) ) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if (!(!hasTransactTime() && !msg.hasTransactTime()) ) return false;
		if ((hasTotNoRelatedSym() && !msg.hasTotNoRelatedSym()) || (!hasTotNoRelatedSym() && msg.hasTotNoRelatedSym())) return false;
		if (!(!hasTotNoRelatedSym() && !msg.hasTotNoRelatedSym()) && !(getTotNoRelatedSym()==msg.getTotNoRelatedSym())) return false;
		if ((hasLastFragment() && !msg.hasLastFragment()) || (!hasLastFragment() && msg.hasLastFragment())) return false;
		if (!(!hasLastFragment() && !msg.hasLastFragment()) && !(getLastFragment()==msg.getLastFragment())) return false;
		return true;
	}
	@Override
	public FixDerivativeSecurityList clone () {
		FixDerivativeSecurityList out = new FixDerivativeSecurityList();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixDerivativeSecurityList clone ( FixDerivativeSecurityList out ) {
		if ( hasSecurityReportID())
			out.setSecurityReportID(getSecurityReportID());
		if ( hasSecurityReqID())
			out.setSecurityReqID(getSecurityReqID());
		if ( hasSecurityResponseID())
			out.setSecurityResponseID(getSecurityResponseID());
		if ( hasSecurityRequestResult())
			out.setSecurityRequestResult(getSecurityRequestResult());
		if ( hasClearingBusinessDate())
			out.setClearingBusinessDate(getClearingBusinessDate());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasTotNoRelatedSym())
			out.setTotNoRelatedSym(getTotNoRelatedSym());
		if ( hasLastFragment())
			out.setLastFragment(getLastFragment());
		if (applicationSequenceControl.hasGroup())
			out.applicationSequenceControl = applicationSequenceControl.clone( out.applicationSequenceControl);
		if (underlyingInstrument.hasGroup())
			out.underlyingInstrument = underlyingInstrument.clone( out.underlyingInstrument);
		if (derivativeSecurityDefinition.hasGroup())
			out.derivativeSecurityDefinition = derivativeSecurityDefinition.clone( out.derivativeSecurityDefinition);
		int count = 0;
		count = 0;
		for (FixRelSymDerivSecGrp fixRelSymDerivSecGrp : relSymDerivSecGrp) {
			if (!fixRelSymDerivSecGrp.hasGroup()) continue;
			out.relSymDerivSecGrp[count] = fixRelSymDerivSecGrp.clone( out.relSymDerivSecGrp[count] );
			count++;
		}
		return out;
	}

}
