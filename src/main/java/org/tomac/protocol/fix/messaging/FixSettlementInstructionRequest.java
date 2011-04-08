package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixSettlementInstructionRequest extends FixInMessage {
	private short hasSettlInstReqID;
	byte[] settlInstReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasAllocAccount;
	byte[] allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocAcctIDSource;
	long allocAcctIDSource = 0;		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasProduct;
	long product = 0;		
	private short hasSecurityType;
	byte[] securityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCFICode;
	byte[] cFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlCurrency;
	byte[] settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasEffectiveTime;
	byte[] effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasExpireTime;
	byte[] expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasLastUpdateTime;
	byte[] lastUpdateTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasStandInstDbType;
	long standInstDbType = 0;		
	private short hasStandInstDbName;
	byte[] standInstDbName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasStandInstDbID;
	byte[] standInstDbID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	public FixParties[] parties;
	
	public FixSettlementInstructionRequest() {
		super(FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONREQUEST);


		hasSettlInstReqID = FixUtils.TAG_HAS_NO_VALUE;		
		settlInstReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasAllocAccount = FixUtils.TAG_HAS_NO_VALUE;		
		allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasProduct = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		securityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCFICode = FixUtils.TAG_HAS_NO_VALUE;		
		cFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasEffectiveTime = FixUtils.TAG_HAS_NO_VALUE;		
		effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;		
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasLastUpdateTime = FixUtils.TAG_HAS_NO_VALUE;		
		lastUpdateTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasStandInstDbType = FixUtils.TAG_HAS_NO_VALUE;		
		hasStandInstDbName = FixUtils.TAG_HAS_NO_VALUE;		
		standInstDbName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasStandInstDbID = FixUtils.TAG_HAS_NO_VALUE;		
		standInstDbID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.SETTLINSTREQID_INT:		
            		hasSettlInstReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCACCOUNT_INT:		
            		hasAllocAccount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ALLOCACCTIDSOURCE_INT:		
            		hasAllocAcctIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
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
            	case FixTags.CFICODE_INT:		
            		hasCFICode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLCURRENCY_INT:		
            		hasSettlCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EFFECTIVETIME_INT:		
            		hasEffectiveTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXPIRETIME_INT:		
            		hasExpireTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTUPDATETIME_INT:		
            		hasLastUpdateTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.STANDINSTDBTYPE_INT:		
            		hasStandInstDbType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.STANDINSTDBNAME_INT:		
            		hasStandInstDbName = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.STANDINSTDBID_INT:		
            		hasStandInstDbID = (short) buf.position();		
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
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONREQUEST);
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

		if (!hasSettlInstReqID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.SETTLINSTREQID_INT, FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONREQUEST);
			return false;
		}
		if (!hasTransactTime()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRANSACTTIME_INT, FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONREQUEST);
			return false;
		}
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getSettlInstReqID();		
		getTransactTime();		
		getAllocAccount();		
		getAllocAcctIDSource();		
		getSide();		
		getProduct();		
		getSecurityType();		
		getCFICode();		
		getSettlCurrency();		
		getEffectiveTime();		
		getExpireTime();		
		getLastUpdateTime();		
		getStandInstDbType();		
		getStandInstDbName();		
		getStandInstDbID();		
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
		if (hasSettlInstReqID()) {		
			out.put(FixTags.SETTLINSTREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlInstReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocAccount()) {		
			out.put(FixTags.ALLOCACCOUNT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,allocAccount); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAllocAcctIDSource()) {		
			out.put(FixTags.ALLOCACCTIDSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)allocAcctIDSource);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSide()) {		
			out.put(FixTags.SIDE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,side); 		
		
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
		if (hasCFICode()) {		
			out.put(FixTags.CFICODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,cFICode); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlCurrency()) {		
			out.put(FixTags.SETTLCURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlCurrency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEffectiveTime()) {		
			out.put(FixTags.EFFECTIVETIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,effectiveTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExpireTime()) {		
			out.put(FixTags.EXPIRETIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,expireTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastUpdateTime()) {		
			out.put(FixTags.LASTUPDATETIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,lastUpdateTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasStandInstDbType()) {		
			out.put(FixTags.STANDINSTDBTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)standInstDbType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasStandInstDbName()) {		
			out.put(FixTags.STANDINSTDBNAME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,standInstDbName); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasStandInstDbID()) {		
			out.put(FixTags.STANDINSTDBID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,standInstDbID); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		
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
		
		if (hasSettlInstReqID()) {		
			FixUtils.put(out,settlInstReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocAccount()) {		
			FixUtils.put(out,allocAccount); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocAcctIDSource()) {		
			FixUtils.put(out, (long)allocAcctIDSource);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
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
		
		if (hasCFICode()) {		
			FixUtils.put(out,cFICode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrency()) {		
			FixUtils.put(out,settlCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEffectiveTime()) {		
			FixUtils.put(out,effectiveTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExpireTime()) {		
			FixUtils.put(out,expireTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastUpdateTime()) {		
			FixUtils.put(out,lastUpdateTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStandInstDbType()) {		
			FixUtils.put(out, (long)standInstDbType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStandInstDbName()) {		
			FixUtils.put(out,standInstDbName); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStandInstDbID()) {		
			FixUtils.put(out,standInstDbID); 		
		
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
			
	public void crackSettlInstReqID() {		
		getSettlInstReqID();		
	}		
			
	public byte[] getSettlInstReqID() { 		
		if ( hasSettlInstReqID()) {		
			if (hasSettlInstReqID == FixUtils.TAG_HAS_VALUE) {		
				return settlInstReqID; 		
			} else {

				buf.position(hasSettlInstReqID);

			FixMessage.getTagStringValue(buf, settlInstReqID, 0, settlInstReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlInstReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlInstReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlInstReqID() { return hasSettlInstReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlInstReqID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlInstReqID()) FixUtils.fillNul(settlInstReqID);		
		FixUtils.copy(settlInstReqID, src); 		
		hasSettlInstReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlInstReqID(String str) {		
		if (str == null ) return;
		if (hasSettlInstReqID()) FixUtils.fillNul(settlInstReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlInstReqID, src); 		
		hasSettlInstReqID = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackAllocAccount() {		
		getAllocAccount();		
	}		
			
	public byte[] getAllocAccount() { 		
		if ( hasAllocAccount()) {		
			if (hasAllocAccount == FixUtils.TAG_HAS_VALUE) {		
				return allocAccount; 		
			} else {

				buf.position(hasAllocAccount);

			FixMessage.getTagStringValue(buf, allocAccount, 0, allocAccount.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocAccount;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocAccount() { return hasAllocAccount != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocAccount(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAccount()) FixUtils.fillNul(allocAccount);		
		FixUtils.copy(allocAccount, src); 		
		hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAccount(String str) {		
		if (str == null ) return;
		if (hasAllocAccount()) FixUtils.fillNul(allocAccount);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocAccount, src); 		
		hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAllocAcctIDSource() {		
		getAllocAcctIDSource();		
	}		
			
	public long getAllocAcctIDSource() { 		
		if ( hasAllocAcctIDSource()) {		
			if (hasAllocAcctIDSource == FixUtils.TAG_HAS_VALUE) {		
				return allocAcctIDSource; 		
			} else {

				buf.position(hasAllocAcctIDSource);

			allocAcctIDSource = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return allocAcctIDSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocAcctIDSource() { return hasAllocAcctIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAllocAcctIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAcctIDSource()) allocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		allocAcctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAcctIDSource(long src) {		
		allocAcctIDSource = src;
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAcctIDSource(String str) {		
		if (str == null ) return;
		if (hasAllocAcctIDSource()) allocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocAcctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSide() {		
		getSide();		
	}		
			
	public byte getSide() { 		
		if ( hasSide()) {		
			if (hasSide == FixUtils.TAG_HAS_VALUE) {		
				return side; 		
			} else {

				buf.position(hasSide);

			side = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (side != (byte)'D') && (side != (byte)'E') && (side != (byte)'F') && (side != (byte)'G') && (side != (byte)'A') && (side != (byte)'B') && (side != (byte)'C') && (side != (byte)'3') && (side != (byte)'2') && (side != (byte)'1') && (side != (byte)'7') && (side != (byte)'6') && (side != (byte)'5') && (side != (byte)'4') && (side != (byte)'9') && (side != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 54);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasSide = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return side;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSide() { return hasSide != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSide(byte[] src) {		
		if (src == null ) return;
		if (hasSide()) side = (byte)' ';		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(byte src) {		
		side = src;
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(String str) {		
		if (str == null ) return;
		if (hasSide()) side = (byte)' ';		
		byte[] src = str.getBytes(); 		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackCFICode() {		
		getCFICode();		
	}		
			
	public byte[] getCFICode() { 		
		if ( hasCFICode()) {		
			if (hasCFICode == FixUtils.TAG_HAS_VALUE) {		
				return cFICode; 		
			} else {

				buf.position(hasCFICode);

			FixMessage.getTagStringValue(buf, cFICode, 0, cFICode.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCFICode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return cFICode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCFICode() { return hasCFICode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCFICode(byte[] src) {		
		if (src == null ) return;
		if (hasCFICode()) FixUtils.fillNul(cFICode);		
		FixUtils.copy(cFICode, src); 		
		hasCFICode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCFICode(String str) {		
		if (str == null ) return;
		if (hasCFICode()) FixUtils.fillNul(cFICode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cFICode, src); 		
		hasCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlCurrency() {		
		getSettlCurrency();		
	}		
			
	public byte[] getSettlCurrency() { 		
		if ( hasSettlCurrency()) {		
			if (hasSettlCurrency == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrency; 		
			} else {

				buf.position(hasSettlCurrency);

			FixMessage.getTagStringValue(buf, settlCurrency, 0, settlCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlCurrency = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlCurrency() { return hasSettlCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrency()) FixUtils.fillNul(settlCurrency);		
		FixUtils.copy(settlCurrency, src); 		
		hasSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrency(String str) {		
		if (str == null ) return;
		if (hasSettlCurrency()) FixUtils.fillNul(settlCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlCurrency, src); 		
		hasSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEffectiveTime() {		
		getEffectiveTime();		
	}		
			
	public byte[] getEffectiveTime() { 		
		if ( hasEffectiveTime()) {		
			if (hasEffectiveTime == FixUtils.TAG_HAS_VALUE) {		
				return effectiveTime; 		
			} else {

				buf.position(hasEffectiveTime);

			FixMessage.getTagStringValue(buf, effectiveTime, 0, effectiveTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return effectiveTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEffectiveTime() { return hasEffectiveTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEffectiveTime(byte[] src) {		
		if (src == null ) return;
		if (hasEffectiveTime()) FixUtils.fillNul(effectiveTime);		
		FixUtils.copy(effectiveTime, src); 		
		hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEffectiveTime(String str) {		
		if (str == null ) return;
		if (hasEffectiveTime()) FixUtils.fillNul(effectiveTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(effectiveTime, src); 		
		hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExpireTime() {		
		getExpireTime();		
	}		
			
	public byte[] getExpireTime() { 		
		if ( hasExpireTime()) {		
			if (hasExpireTime == FixUtils.TAG_HAS_VALUE) {		
				return expireTime; 		
			} else {

				buf.position(hasExpireTime);

			FixMessage.getTagStringValue(buf, expireTime, 0, expireTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExpireTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return expireTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExpireTime() { return hasExpireTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExpireTime(byte[] src) {		
		if (src == null ) return;
		if (hasExpireTime()) FixUtils.fillNul(expireTime);		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExpireTime(String str) {		
		if (str == null ) return;
		if (hasExpireTime()) FixUtils.fillNul(expireTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastUpdateTime() {		
		getLastUpdateTime();		
	}		
			
	public byte[] getLastUpdateTime() { 		
		if ( hasLastUpdateTime()) {		
			if (hasLastUpdateTime == FixUtils.TAG_HAS_VALUE) {		
				return lastUpdateTime; 		
			} else {

				buf.position(hasLastUpdateTime);

			FixMessage.getTagStringValue(buf, lastUpdateTime, 0, lastUpdateTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasLastUpdateTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastUpdateTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLastUpdateTime() { return hasLastUpdateTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastUpdateTime(byte[] src) {		
		if (src == null ) return;
		if (hasLastUpdateTime()) FixUtils.fillNul(lastUpdateTime);		
		FixUtils.copy(lastUpdateTime, src); 		
		hasLastUpdateTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastUpdateTime(String str) {		
		if (str == null ) return;
		if (hasLastUpdateTime()) FixUtils.fillNul(lastUpdateTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(lastUpdateTime, src); 		
		hasLastUpdateTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackStandInstDbType() {		
		getStandInstDbType();		
	}		
			
	public long getStandInstDbType() { 		
		if ( hasStandInstDbType()) {		
			if (hasStandInstDbType == FixUtils.TAG_HAS_VALUE) {		
				return standInstDbType; 		
			} else {

				buf.position(hasStandInstDbType);

			standInstDbType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasStandInstDbType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return standInstDbType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStandInstDbType() { return hasStandInstDbType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStandInstDbType(byte[] src) {		
		if (src == null ) return;
		if (hasStandInstDbType()) standInstDbType = FixUtils.TAG_HAS_NO_VALUE;		
		standInstDbType = FixUtils.longValueOf(src, 0, src.length);
		hasStandInstDbType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStandInstDbType(long src) {		
		standInstDbType = src;
		hasStandInstDbType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStandInstDbType(String str) {		
		if (str == null ) return;
		if (hasStandInstDbType()) standInstDbType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		standInstDbType = FixUtils.longValueOf(src, 0, src.length);
		hasStandInstDbType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackStandInstDbName() {		
		getStandInstDbName();		
	}		
			
	public byte[] getStandInstDbName() { 		
		if ( hasStandInstDbName()) {		
			if (hasStandInstDbName == FixUtils.TAG_HAS_VALUE) {		
				return standInstDbName; 		
			} else {

				buf.position(hasStandInstDbName);

			FixMessage.getTagStringValue(buf, standInstDbName, 0, standInstDbName.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasStandInstDbName = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return standInstDbName;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStandInstDbName() { return hasStandInstDbName != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStandInstDbName(byte[] src) {		
		if (src == null ) return;
		if (hasStandInstDbName()) FixUtils.fillNul(standInstDbName);		
		FixUtils.copy(standInstDbName, src); 		
		hasStandInstDbName = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStandInstDbName(String str) {		
		if (str == null ) return;
		if (hasStandInstDbName()) FixUtils.fillNul(standInstDbName);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(standInstDbName, src); 		
		hasStandInstDbName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackStandInstDbID() {		
		getStandInstDbID();		
	}		
			
	public byte[] getStandInstDbID() { 		
		if ( hasStandInstDbID()) {		
			if (hasStandInstDbID == FixUtils.TAG_HAS_VALUE) {		
				return standInstDbID; 		
			} else {

				buf.position(hasStandInstDbID);

			FixMessage.getTagStringValue(buf, standInstDbID, 0, standInstDbID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasStandInstDbID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return standInstDbID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStandInstDbID() { return hasStandInstDbID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStandInstDbID(byte[] src) {		
		if (src == null ) return;
		if (hasStandInstDbID()) FixUtils.fillNul(standInstDbID);		
		FixUtils.copy(standInstDbID, src); 		
		hasStandInstDbID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStandInstDbID(String str) {		
		if (str == null ) return;
		if (hasStandInstDbID()) FixUtils.fillNul(standInstDbID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(standInstDbID, src); 		
		hasStandInstDbID = FixUtils.TAG_HAS_VALUE;		
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

					if (hasSettlInstReqID()) s += "SettlInstReqID(791)= " + new String( FixUtils.trim(getSettlInstReqID()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasAllocAccount()) s += "AllocAccount(79)= " + new String( FixUtils.trim(getAllocAccount()) ) + "\n" ; 
		if (hasAllocAcctIDSource()) s += "AllocAcctIDSource(661)= " + getAllocAcctIDSource() + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasProduct()) s += "Product(460)= " + getProduct() + "\n" ; 
		if (hasSecurityType()) s += "SecurityType(167)= " + new String( FixUtils.trim(getSecurityType()) ) + "\n" ; 
		if (hasCFICode()) s += "CFICode(461)= " + new String( FixUtils.trim(getCFICode()) ) + "\n" ; 
		if (hasSettlCurrency()) s += "SettlCurrency(120)= " + new String( FixUtils.trim(getSettlCurrency()) ) + "\n" ; 
		if (hasEffectiveTime()) s += "EffectiveTime(168)= " + new String( FixUtils.trim(getEffectiveTime()) ) + "\n" ; 
		if (hasExpireTime()) s += "ExpireTime(126)= " + new String( FixUtils.trim(getExpireTime()) ) + "\n" ; 
		if (hasLastUpdateTime()) s += "LastUpdateTime(779)= " + new String( FixUtils.trim(getLastUpdateTime()) ) + "\n" ; 
		if (hasStandInstDbType()) s += "StandInstDbType(169)= " + getStandInstDbType() + "\n" ; 
		if (hasStandInstDbName()) s += "StandInstDbName(170)= " + new String( FixUtils.trim(getStandInstDbName()) ) + "\n" ; 
		if (hasStandInstDbID()) s += "StandInstDbID(171)= " + new String( FixUtils.trim(getStandInstDbID()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSettlementInstructionRequest)) return false;

		FixSettlementInstructionRequest msg = (FixSettlementInstructionRequest) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasSettlInstReqID() && !msg.hasSettlInstReqID()) || (!hasSettlInstReqID() && msg.hasSettlInstReqID())) return false;
		if (!(!hasSettlInstReqID() && !msg.hasSettlInstReqID()) && !FixUtils.equals(getSettlInstReqID(), msg.getSettlInstReqID())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasAllocAccount() && !msg.hasAllocAccount()) || (!hasAllocAccount() && msg.hasAllocAccount())) return false;
		if (!(!hasAllocAccount() && !msg.hasAllocAccount()) && !FixUtils.equals(getAllocAccount(), msg.getAllocAccount())) return false;
		if ((hasAllocAcctIDSource() && !msg.hasAllocAcctIDSource()) || (!hasAllocAcctIDSource() && msg.hasAllocAcctIDSource())) return false;
		if (!(!hasAllocAcctIDSource() && !msg.hasAllocAcctIDSource()) && !(getAllocAcctIDSource()==msg.getAllocAcctIDSource())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasProduct() && !msg.hasProduct()) || (!hasProduct() && msg.hasProduct())) return false;
		if (!(!hasProduct() && !msg.hasProduct()) && !(getProduct()==msg.getProduct())) return false;
		if ((hasSecurityType() && !msg.hasSecurityType()) || (!hasSecurityType() && msg.hasSecurityType())) return false;
		if (!(!hasSecurityType() && !msg.hasSecurityType()) && !FixUtils.equals(getSecurityType(), msg.getSecurityType())) return false;
		if ((hasCFICode() && !msg.hasCFICode()) || (!hasCFICode() && msg.hasCFICode())) return false;
		if (!(!hasCFICode() && !msg.hasCFICode()) && !FixUtils.equals(getCFICode(), msg.getCFICode())) return false;
		if ((hasSettlCurrency() && !msg.hasSettlCurrency()) || (!hasSettlCurrency() && msg.hasSettlCurrency())) return false;
		if (!(!hasSettlCurrency() && !msg.hasSettlCurrency()) && !FixUtils.equals(getSettlCurrency(), msg.getSettlCurrency())) return false;
		if ((hasEffectiveTime() && !msg.hasEffectiveTime()) || (!hasEffectiveTime() && msg.hasEffectiveTime())) return false;
		if ((hasExpireTime() && !msg.hasExpireTime()) || (!hasExpireTime() && msg.hasExpireTime())) return false;
		if ((hasLastUpdateTime() && !msg.hasLastUpdateTime()) || (!hasLastUpdateTime() && msg.hasLastUpdateTime())) return false;
		if ((hasStandInstDbType() && !msg.hasStandInstDbType()) || (!hasStandInstDbType() && msg.hasStandInstDbType())) return false;
		if (!(!hasStandInstDbType() && !msg.hasStandInstDbType()) && !(getStandInstDbType()==msg.getStandInstDbType())) return false;
		if ((hasStandInstDbName() && !msg.hasStandInstDbName()) || (!hasStandInstDbName() && msg.hasStandInstDbName())) return false;
		if (!(!hasStandInstDbName() && !msg.hasStandInstDbName()) && !FixUtils.equals(getStandInstDbName(), msg.getStandInstDbName())) return false;
		if ((hasStandInstDbID() && !msg.hasStandInstDbID()) || (!hasStandInstDbID() && msg.hasStandInstDbID())) return false;
		if (!(!hasStandInstDbID() && !msg.hasStandInstDbID()) && !FixUtils.equals(getStandInstDbID(), msg.getStandInstDbID())) return false;
		return true;
	}
	@Override
	public FixSettlementInstructionRequest clone () {
		FixSettlementInstructionRequest out = new FixSettlementInstructionRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixSettlementInstructionRequest clone ( FixSettlementInstructionRequest out ) {
		if ( hasSettlInstReqID())
			out.setSettlInstReqID(getSettlInstReqID());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasAllocAccount())
			out.setAllocAccount(getAllocAccount());
		if ( hasAllocAcctIDSource())
			out.setAllocAcctIDSource(getAllocAcctIDSource());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasProduct())
			out.setProduct(getProduct());
		if ( hasSecurityType())
			out.setSecurityType(getSecurityType());
		if ( hasCFICode())
			out.setCFICode(getCFICode());
		if ( hasSettlCurrency())
			out.setSettlCurrency(getSettlCurrency());
		if ( hasEffectiveTime())
			out.setEffectiveTime(getEffectiveTime());
		if ( hasExpireTime())
			out.setExpireTime(getExpireTime());
		if ( hasLastUpdateTime())
			out.setLastUpdateTime(getLastUpdateTime());
		if ( hasStandInstDbType())
			out.setStandInstDbType(getStandInstDbType());
		if ( hasStandInstDbName())
			out.setStandInstDbName(getStandInstDbName());
		if ( hasStandInstDbID())
			out.setStandInstDbID(getStandInstDbID());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		return out;
	}

}
