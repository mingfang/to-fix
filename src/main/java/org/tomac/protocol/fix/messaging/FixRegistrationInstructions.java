package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixRegistrationInstructions extends FixInMessage {
	private short hasRegistID;
	byte[] registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRegistTransType;
	byte registTransType = (byte)' ';		
	private short hasRegistRefID;
	byte[] registRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAccount;
	byte[] account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAcctIDSource;
	long acctIDSource = 0;		
	private short hasRegistAcctType;
	byte[] registAcctType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTaxAdvantageType;
	long taxAdvantageType = 0;		
	private short hasOwnershipType;
	byte ownershipType = (byte)' ';		
	public FixParties[] parties;
	public FixRgstDtlsGrp[] rgstDtlsGrp;
	public FixRgstDistInstGrp[] rgstDistInstGrp;
	
	public FixRegistrationInstructions() {
		super(FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONS);


		hasRegistID = FixUtils.TAG_HAS_NO_VALUE;		
		registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRegistTransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasRegistRefID = FixUtils.TAG_HAS_NO_VALUE;		
		registRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAccount = FixUtils.TAG_HAS_NO_VALUE;		
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasRegistAcctType = FixUtils.TAG_HAS_NO_VALUE;		
		registAcctType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTaxAdvantageType = FixUtils.TAG_HAS_NO_VALUE;		
		hasOwnershipType = FixUtils.TAG_HAS_NO_VALUE;		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		rgstDtlsGrp = new FixRgstDtlsGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rgstDtlsGrp[i] = new FixRgstDtlsGrp();
		rgstDistInstGrp = new FixRgstDistInstGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rgstDistInstGrp[i] = new FixRgstDistInstGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.REGISTID_INT:		
            		hasRegistID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REGISTTRANSTYPE_INT:		
            		hasRegistTransType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REGISTREFID_INT:		
            		hasRegistRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCOUNT_INT:		
            		hasAccount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ACCTIDSOURCE_INT:		
            		hasAcctIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.REGISTACCTTYPE_INT:		
            		hasRegistAcctType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TAXADVANTAGETYPE_INT:		
            		hasTaxAdvantageType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.OWNERSHIPTYPE_INT:		
            		hasOwnershipType = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOREGISTDTLS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !rgstDtlsGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = rgstDtlsGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NODISTRIBINSTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !rgstDistInstGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = rgstDistInstGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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

		if (!hasRegistID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag RegistID missing", FixTags.REGISTID_INT, FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONS);
			return false;
		}
		if (!hasRegistTransType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag RegistTransType missing", FixTags.REGISTTRANSTYPE_INT, FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONS);
			return false;
		}
		if (!hasRegistRefID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag RegistRefID missing", FixTags.REGISTREFID_INT, FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONS);
			return false;
		}
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getRegistID();		
		getRegistTransType();		
		getRegistRefID();		
		getClOrdID();		
		getAccount();		
		getAcctIDSource();		
		getRegistAcctType();		
		getTaxAdvantageType();		
		getOwnershipType();		
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
		if (hasRegistID()) {		
			out.put(FixTags.REGISTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,registID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRegistTransType()) {		
			out.put(FixTags.REGISTTRANSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,registTransType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRegistRefID()) {		
			out.put(FixTags.REGISTREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,registRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAccount()) {		
			out.put(FixTags.ACCOUNT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,account); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasAcctIDSource()) {		
			out.put(FixTags.ACCTIDSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)acctIDSource);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRegistAcctType()) {		
			out.put(FixTags.REGISTACCTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,registAcctType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTaxAdvantageType()) {		
			out.put(FixTags.TAXADVANTAGETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)taxAdvantageType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOwnershipType()) {		
			out.put(FixTags.OWNERSHIPTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,ownershipType); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(rgstDtlsGrp)>0) {
			out.put(FixTags.NOREGISTDTLS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(rgstDtlsGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRgstDtlsGrp fixRgstDtlsGrp : rgstDtlsGrp) if (fixRgstDtlsGrp.hasGroup()) fixRgstDtlsGrp.encode(out);
		if (FixUtils.getNoInGroup(rgstDistInstGrp)>0) {
			out.put(FixTags.NODISTRIBINSTS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(rgstDistInstGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRgstDistInstGrp fixRgstDistInstGrp : rgstDistInstGrp) if (fixRgstDistInstGrp.hasGroup()) fixRgstDistInstGrp.encode(out);
		
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
		
		if (hasRegistID()) {		
			FixUtils.put(out,registID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRegistTransType()) {		
			FixUtils.put(out,registTransType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRegistRefID()) {		
			FixUtils.put(out,registRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAccount()) {		
			FixUtils.put(out,account); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAcctIDSource()) {		
			FixUtils.put(out, (long)acctIDSource);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRegistAcctType()) {		
			FixUtils.put(out,registAcctType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTaxAdvantageType()) {		
			FixUtils.put(out, (long)taxAdvantageType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOwnershipType()) {		
			FixUtils.put(out,ownershipType); 		
		
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
		if (hasRegistID()) FixUtils.fillNul(registID);		
		FixUtils.copy(registID, src); 		
		hasRegistID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistID(String str) {		
		if (str == null ) return;
		if (hasRegistID()) FixUtils.fillNul(registID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(registID, src); 		
		hasRegistID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRegistTransType() {		
		getRegistTransType();		
	}		
			
	public byte getRegistTransType() { 		
		if ( hasRegistTransType()) {		
			if (hasRegistTransType == FixUtils.TAG_HAS_VALUE) {		
				return registTransType; 		
			} else {

				buf.position(hasRegistTransType);

			registTransType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (registTransType != (byte)'2') && (registTransType != (byte)'1') && (registTransType != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 514);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasRegistTransType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return registTransType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasRegistTransType() { return hasRegistTransType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRegistTransType(byte[] src) {		
		if (src == null ) return;
		if (hasRegistTransType()) registTransType = (byte)' ';		
		registTransType = src[0];		
		hasRegistTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistTransType(byte src) {		
		registTransType = src;
		hasRegistTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistTransType(String str) {		
		if (str == null ) return;
		if (hasRegistTransType()) registTransType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		registTransType = src[0];		
		hasRegistTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRegistRefID() {		
		getRegistRefID();		
	}		
			
	public byte[] getRegistRefID() { 		
		if ( hasRegistRefID()) {		
			if (hasRegistRefID == FixUtils.TAG_HAS_VALUE) {		
				return registRefID; 		
			} else {

				buf.position(hasRegistRefID);

			FixMessage.getTagStringValue(buf, registRefID, 0, registRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRegistRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return registRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRegistRefID() { return hasRegistRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRegistRefID(byte[] src) {		
		if (src == null ) return;
		if (hasRegistRefID()) FixUtils.fillNul(registRefID);		
		FixUtils.copy(registRefID, src); 		
		hasRegistRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistRefID(String str) {		
		if (str == null ) return;
		if (hasRegistRefID()) FixUtils.fillNul(registRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(registRefID, src); 		
		hasRegistRefID = FixUtils.TAG_HAS_VALUE;		
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
		if (hasClOrdID()) FixUtils.fillNul(clOrdID);		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClOrdID(String str) {		
		if (str == null ) return;
		if (hasClOrdID()) FixUtils.fillNul(clOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAccount() {		
		getAccount();		
	}		
			
	public byte[] getAccount() { 		
		if ( hasAccount()) {		
			if (hasAccount == FixUtils.TAG_HAS_VALUE) {		
				return account; 		
			} else {

				buf.position(hasAccount);

			FixMessage.getTagStringValue(buf, account, 0, account.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasAccount = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return account;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAccount() { return hasAccount != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAccount(byte[] src) {		
		if (src == null ) return;
		if (hasAccount()) FixUtils.fillNul(account);		
		FixUtils.copy(account, src); 		
		hasAccount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAccount(String str) {		
		if (str == null ) return;
		if (hasAccount()) FixUtils.fillNul(account);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(account, src); 		
		hasAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackAcctIDSource() {		
		getAcctIDSource();		
	}		
			
	public long getAcctIDSource() { 		
		if ( hasAcctIDSource()) {		
			if (hasAcctIDSource == FixUtils.TAG_HAS_VALUE) {		
				return acctIDSource; 		
			} else {

				buf.position(hasAcctIDSource);

			acctIDSource = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return acctIDSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAcctIDSource() { return hasAcctIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAcctIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasAcctIDSource()) acctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		acctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAcctIDSource(long src) {		
		acctIDSource = src;
		hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAcctIDSource(String str) {		
		if (str == null ) return;
		if (hasAcctIDSource()) acctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		acctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRegistAcctType() {		
		getRegistAcctType();		
	}		
			
	public byte[] getRegistAcctType() { 		
		if ( hasRegistAcctType()) {		
			if (hasRegistAcctType == FixUtils.TAG_HAS_VALUE) {		
				return registAcctType; 		
			} else {

				buf.position(hasRegistAcctType);

			FixMessage.getTagStringValue(buf, registAcctType, 0, registAcctType.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRegistAcctType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return registAcctType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRegistAcctType() { return hasRegistAcctType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRegistAcctType(byte[] src) {		
		if (src == null ) return;
		if (hasRegistAcctType()) FixUtils.fillNul(registAcctType);		
		FixUtils.copy(registAcctType, src); 		
		hasRegistAcctType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistAcctType(String str) {		
		if (str == null ) return;
		if (hasRegistAcctType()) FixUtils.fillNul(registAcctType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(registAcctType, src); 		
		hasRegistAcctType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTaxAdvantageType() {		
		getTaxAdvantageType();		
	}		
			
	public long getTaxAdvantageType() { 		
		if ( hasTaxAdvantageType()) {		
			if (hasTaxAdvantageType == FixUtils.TAG_HAS_VALUE) {		
				return taxAdvantageType; 		
			} else {

				buf.position(hasTaxAdvantageType);

			taxAdvantageType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTaxAdvantageType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return taxAdvantageType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTaxAdvantageType() { return hasTaxAdvantageType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTaxAdvantageType(byte[] src) {		
		if (src == null ) return;
		if (hasTaxAdvantageType()) taxAdvantageType = FixUtils.TAG_HAS_NO_VALUE;		
		taxAdvantageType = FixUtils.longValueOf(src, 0, src.length);
		hasTaxAdvantageType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTaxAdvantageType(long src) {		
		taxAdvantageType = src;
		hasTaxAdvantageType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTaxAdvantageType(String str) {		
		if (str == null ) return;
		if (hasTaxAdvantageType()) taxAdvantageType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		taxAdvantageType = FixUtils.longValueOf(src, 0, src.length);
		hasTaxAdvantageType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOwnershipType() {		
		getOwnershipType();		
	}		
			
	public byte getOwnershipType() { 		
		if ( hasOwnershipType()) {		
			if (hasOwnershipType == FixUtils.TAG_HAS_VALUE) {		
				return ownershipType; 		
			} else {

				buf.position(hasOwnershipType);

			ownershipType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (ownershipType != (byte)'T') && (ownershipType != (byte)'2') && (ownershipType != (byte)'J') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 517);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasOwnershipType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return ownershipType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOwnershipType() { return hasOwnershipType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOwnershipType(byte[] src) {		
		if (src == null ) return;
		if (hasOwnershipType()) ownershipType = (byte)' ';		
		ownershipType = src[0];		
		hasOwnershipType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOwnershipType(byte src) {		
		ownershipType = src;
		hasOwnershipType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOwnershipType(String str) {		
		if (str == null ) return;
		if (hasOwnershipType()) ownershipType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		ownershipType = src[0];		
		hasOwnershipType = FixUtils.TAG_HAS_VALUE;		
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

					if (hasRegistID()) s += "RegistID(513)= " + new String( FixUtils.trim(getRegistID()) ) + "\n" ; 
		if (hasRegistTransType()) s += "RegistTransType(514)= " + getRegistTransType() + "\n" ; 
		if (hasRegistRefID()) s += "RegistRefID(508)= " + new String( FixUtils.trim(getRegistRefID()) ) + "\n" ; 
		if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasAccount()) s += "Account(1)= " + new String( FixUtils.trim(getAccount()) ) + "\n" ; 
		if (hasAcctIDSource()) s += "AcctIDSource(660)= " + getAcctIDSource() + "\n" ; 
		if (hasRegistAcctType()) s += "RegistAcctType(493)= " + new String( FixUtils.trim(getRegistAcctType()) ) + "\n" ; 
		if (hasTaxAdvantageType()) s += "TaxAdvantageType(495)= " + getTaxAdvantageType() + "\n" ; 
		if (hasOwnershipType()) s += "OwnershipType(517)= " + getOwnershipType() + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRegistrationInstructions)) return false;

		FixRegistrationInstructions msg = (FixRegistrationInstructions) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasRegistID() && !msg.hasRegistID()) || (!hasRegistID() && msg.hasRegistID())) return false;
		if (!(!hasRegistID() && !msg.hasRegistID()) && !FixUtils.equals(getRegistID(), msg.getRegistID())) return false;
		if ((hasRegistTransType() && !msg.hasRegistTransType()) || (!hasRegistTransType() && msg.hasRegistTransType())) return false;
		if (!(!hasRegistTransType() && !msg.hasRegistTransType()) && !(getRegistTransType()==msg.getRegistTransType())) return false;
		if ((hasRegistRefID() && !msg.hasRegistRefID()) || (!hasRegistRefID() && msg.hasRegistRefID())) return false;
		if (!(!hasRegistRefID() && !msg.hasRegistRefID()) && !FixUtils.equals(getRegistRefID(), msg.getRegistRefID())) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasAccount() && !msg.hasAccount()) || (!hasAccount() && msg.hasAccount())) return false;
		if (!(!hasAccount() && !msg.hasAccount()) && !FixUtils.equals(getAccount(), msg.getAccount())) return false;
		if ((hasAcctIDSource() && !msg.hasAcctIDSource()) || (!hasAcctIDSource() && msg.hasAcctIDSource())) return false;
		if (!(!hasAcctIDSource() && !msg.hasAcctIDSource()) && !(getAcctIDSource()==msg.getAcctIDSource())) return false;
		if ((hasRegistAcctType() && !msg.hasRegistAcctType()) || (!hasRegistAcctType() && msg.hasRegistAcctType())) return false;
		if (!(!hasRegistAcctType() && !msg.hasRegistAcctType()) && !FixUtils.equals(getRegistAcctType(), msg.getRegistAcctType())) return false;
		if ((hasTaxAdvantageType() && !msg.hasTaxAdvantageType()) || (!hasTaxAdvantageType() && msg.hasTaxAdvantageType())) return false;
		if (!(!hasTaxAdvantageType() && !msg.hasTaxAdvantageType()) && !(getTaxAdvantageType()==msg.getTaxAdvantageType())) return false;
		if ((hasOwnershipType() && !msg.hasOwnershipType()) || (!hasOwnershipType() && msg.hasOwnershipType())) return false;
		if (!(!hasOwnershipType() && !msg.hasOwnershipType()) && !(getOwnershipType()==msg.getOwnershipType())) return false;
		return true;
	}
	@Override
	public FixRegistrationInstructions clone () {
		FixRegistrationInstructions out = new FixRegistrationInstructions();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixRegistrationInstructions clone ( FixRegistrationInstructions out ) {
		if ( hasRegistID())
			out.setRegistID(getRegistID());
		if ( hasRegistTransType())
			out.setRegistTransType(getRegistTransType());
		if ( hasRegistRefID())
			out.setRegistRefID(getRegistRefID());
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasAccount())
			out.setAccount(getAccount());
		if ( hasAcctIDSource())
			out.setAcctIDSource(getAcctIDSource());
		if ( hasRegistAcctType())
			out.setRegistAcctType(getRegistAcctType());
		if ( hasTaxAdvantageType())
			out.setTaxAdvantageType(getTaxAdvantageType());
		if ( hasOwnershipType())
			out.setOwnershipType(getOwnershipType());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixRgstDtlsGrp fixRgstDtlsGrp : rgstDtlsGrp) {
			if (!fixRgstDtlsGrp.hasGroup()) continue;
			out.rgstDtlsGrp[count] = fixRgstDtlsGrp.clone( out.rgstDtlsGrp[count] );
			count++;
		}
		count = 0;
		for (FixRgstDistInstGrp fixRgstDistInstGrp : rgstDistInstGrp) {
			if (!fixRgstDistInstGrp.hasGroup()) continue;
			out.rgstDistInstGrp[count] = fixRgstDistInstGrp.clone( out.rgstDistInstGrp[count] );
			count++;
		}
		return out;
	}

}
