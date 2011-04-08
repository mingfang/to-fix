package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixNetworkCounterpartySystemStatusResponse extends FixInMessage {
	private short hasNetworkStatusResponseType;
	long networkStatusResponseType = 0;		
	private short hasNetworkRequestID;
	byte[] networkRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNetworkResponseID;
	byte[] networkResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLastNetworkResponseID;
	byte[] lastNetworkResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	public FixCompIDStatGrp[] compIDStatGrp;
	
	public FixNetworkCounterpartySystemStatusResponse() {
		super(FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSRESPONSE);


		hasNetworkStatusResponseType = FixUtils.TAG_HAS_NO_VALUE;		
		hasNetworkRequestID = FixUtils.TAG_HAS_NO_VALUE;		
		networkRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNetworkResponseID = FixUtils.TAG_HAS_NO_VALUE;		
		networkResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLastNetworkResponseID = FixUtils.TAG_HAS_NO_VALUE;		
		lastNetworkResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		compIDStatGrp = new FixCompIDStatGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) compIDStatGrp[i] = new FixCompIDStatGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.NETWORKSTATUSRESPONSETYPE_INT:		
            		hasNetworkStatusResponseType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.NETWORKREQUESTID_INT:		
            		hasNetworkRequestID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.NETWORKRESPONSEID_INT:		
            		hasNetworkResponseID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LASTNETWORKRESPONSEID_INT:		
            		hasLastNetworkResponseID = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOCOMPIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !compIDStatGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = compIDStatGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSRESPONSE);
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

		if (!hasNetworkStatusResponseType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.NETWORKSTATUSRESPONSETYPE_INT, FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSRESPONSE);
			return false;
		}
		if (!hasNetworkResponseID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.NETWORKRESPONSEID_INT, FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSRESPONSE);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (compIDStatGrp[i].hasGroup()) compIDStatGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		getNetworkStatusResponseType();		
		getNetworkRequestID();		
		getNetworkResponseID();		
		getLastNetworkResponseID();		
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
		if (hasNetworkStatusResponseType()) {		
			out.put(FixTags.NETWORKSTATUSRESPONSETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)networkStatusResponseType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNetworkRequestID()) {		
			out.put(FixTags.NETWORKREQUESTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,networkRequestID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNetworkResponseID()) {		
			out.put(FixTags.NETWORKRESPONSEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,networkResponseID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastNetworkResponseID()) {		
			out.put(FixTags.LASTNETWORKRESPONSEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,lastNetworkResponseID); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(compIDStatGrp)>0) {
			out.put(FixTags.NOCOMPIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(compIDStatGrp));

			out.put(FixUtils.SOH);

		}
		for (FixCompIDStatGrp fixCompIDStatGrp : compIDStatGrp) if (fixCompIDStatGrp.hasGroup()) fixCompIDStatGrp.encode(out);
		
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
		
		if (hasNetworkStatusResponseType()) {		
			FixUtils.put(out, (long)networkStatusResponseType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNetworkRequestID()) {		
			FixUtils.put(out,networkRequestID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNetworkResponseID()) {		
			FixUtils.put(out,networkResponseID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastNetworkResponseID()) {		
			FixUtils.put(out,lastNetworkResponseID); 		
		
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
			
	public void crackNetworkStatusResponseType() {		
		getNetworkStatusResponseType();		
	}		
			
	public long getNetworkStatusResponseType() { 		
		if ( hasNetworkStatusResponseType()) {		
			if (hasNetworkStatusResponseType == FixUtils.TAG_HAS_VALUE) {		
				return networkStatusResponseType; 		
			} else {

				buf.position(hasNetworkStatusResponseType);

			networkStatusResponseType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasNetworkStatusResponseType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return networkStatusResponseType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNetworkStatusResponseType() { return hasNetworkStatusResponseType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNetworkStatusResponseType(byte[] src) {		
		if (src == null ) return;
		if (hasNetworkStatusResponseType()) networkStatusResponseType = FixUtils.TAG_HAS_NO_VALUE;		
		networkStatusResponseType = FixUtils.longValueOf(src, 0, src.length);
		hasNetworkStatusResponseType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetworkStatusResponseType(long src) {		
		networkStatusResponseType = src;
		hasNetworkStatusResponseType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetworkStatusResponseType(String str) {		
		if (str == null ) return;
		if (hasNetworkStatusResponseType()) networkStatusResponseType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		networkStatusResponseType = FixUtils.longValueOf(src, 0, src.length);
		hasNetworkStatusResponseType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackNetworkRequestID() {		
		getNetworkRequestID();		
	}		
			
	public byte[] getNetworkRequestID() { 		
		if ( hasNetworkRequestID()) {		
			if (hasNetworkRequestID == FixUtils.TAG_HAS_VALUE) {		
				return networkRequestID; 		
			} else {

				buf.position(hasNetworkRequestID);

			FixMessage.getTagStringValue(buf, networkRequestID, 0, networkRequestID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasNetworkRequestID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return networkRequestID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNetworkRequestID() { return hasNetworkRequestID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNetworkRequestID(byte[] src) {		
		if (src == null ) return;
		if (hasNetworkRequestID()) FixUtils.fillNul(networkRequestID);		
		FixUtils.copy(networkRequestID, src); 		
		hasNetworkRequestID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetworkRequestID(String str) {		
		if (str == null ) return;
		if (hasNetworkRequestID()) FixUtils.fillNul(networkRequestID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(networkRequestID, src); 		
		hasNetworkRequestID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackNetworkResponseID() {		
		getNetworkResponseID();		
	}		
			
	public byte[] getNetworkResponseID() { 		
		if ( hasNetworkResponseID()) {		
			if (hasNetworkResponseID == FixUtils.TAG_HAS_VALUE) {		
				return networkResponseID; 		
			} else {

				buf.position(hasNetworkResponseID);

			FixMessage.getTagStringValue(buf, networkResponseID, 0, networkResponseID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasNetworkResponseID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return networkResponseID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNetworkResponseID() { return hasNetworkResponseID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNetworkResponseID(byte[] src) {		
		if (src == null ) return;
		if (hasNetworkResponseID()) FixUtils.fillNul(networkResponseID);		
		FixUtils.copy(networkResponseID, src); 		
		hasNetworkResponseID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetworkResponseID(String str) {		
		if (str == null ) return;
		if (hasNetworkResponseID()) FixUtils.fillNul(networkResponseID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(networkResponseID, src); 		
		hasNetworkResponseID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLastNetworkResponseID() {		
		getLastNetworkResponseID();		
	}		
			
	public byte[] getLastNetworkResponseID() { 		
		if ( hasLastNetworkResponseID()) {		
			if (hasLastNetworkResponseID == FixUtils.TAG_HAS_VALUE) {		
				return lastNetworkResponseID; 		
			} else {

				buf.position(hasLastNetworkResponseID);

			FixMessage.getTagStringValue(buf, lastNetworkResponseID, 0, lastNetworkResponseID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasLastNetworkResponseID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return lastNetworkResponseID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLastNetworkResponseID() { return hasLastNetworkResponseID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLastNetworkResponseID(byte[] src) {		
		if (src == null ) return;
		if (hasLastNetworkResponseID()) FixUtils.fillNul(lastNetworkResponseID);		
		FixUtils.copy(lastNetworkResponseID, src); 		
		hasLastNetworkResponseID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastNetworkResponseID(String str) {		
		if (str == null ) return;
		if (hasLastNetworkResponseID()) FixUtils.fillNul(lastNetworkResponseID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(lastNetworkResponseID, src); 		
		hasLastNetworkResponseID = FixUtils.TAG_HAS_VALUE;		
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

					if (hasNetworkStatusResponseType()) s += "NetworkStatusResponseType(937)= " + getNetworkStatusResponseType() + "\n" ; 
		if (hasNetworkRequestID()) s += "NetworkRequestID(933)= " + new String( FixUtils.trim(getNetworkRequestID()) ) + "\n" ; 
		if (hasNetworkResponseID()) s += "NetworkResponseID(932)= " + new String( FixUtils.trim(getNetworkResponseID()) ) + "\n" ; 
		if (hasLastNetworkResponseID()) s += "LastNetworkResponseID(934)= " + new String( FixUtils.trim(getLastNetworkResponseID()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNetworkCounterpartySystemStatusResponse)) return false;

		FixNetworkCounterpartySystemStatusResponse msg = (FixNetworkCounterpartySystemStatusResponse) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasNetworkStatusResponseType() && !msg.hasNetworkStatusResponseType()) || (!hasNetworkStatusResponseType() && msg.hasNetworkStatusResponseType())) return false;
		if (!(!hasNetworkStatusResponseType() && !msg.hasNetworkStatusResponseType()) && !(getNetworkStatusResponseType()==msg.getNetworkStatusResponseType())) return false;
		if ((hasNetworkRequestID() && !msg.hasNetworkRequestID()) || (!hasNetworkRequestID() && msg.hasNetworkRequestID())) return false;
		if (!(!hasNetworkRequestID() && !msg.hasNetworkRequestID()) && !FixUtils.equals(getNetworkRequestID(), msg.getNetworkRequestID())) return false;
		if ((hasNetworkResponseID() && !msg.hasNetworkResponseID()) || (!hasNetworkResponseID() && msg.hasNetworkResponseID())) return false;
		if (!(!hasNetworkResponseID() && !msg.hasNetworkResponseID()) && !FixUtils.equals(getNetworkResponseID(), msg.getNetworkResponseID())) return false;
		if ((hasLastNetworkResponseID() && !msg.hasLastNetworkResponseID()) || (!hasLastNetworkResponseID() && msg.hasLastNetworkResponseID())) return false;
		if (!(!hasLastNetworkResponseID() && !msg.hasLastNetworkResponseID()) && !FixUtils.equals(getLastNetworkResponseID(), msg.getLastNetworkResponseID())) return false;
		return true;
	}
	@Override
	public FixNetworkCounterpartySystemStatusResponse clone () {
		FixNetworkCounterpartySystemStatusResponse out = new FixNetworkCounterpartySystemStatusResponse();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixNetworkCounterpartySystemStatusResponse clone ( FixNetworkCounterpartySystemStatusResponse out ) {
		if ( hasNetworkStatusResponseType())
			out.setNetworkStatusResponseType(getNetworkStatusResponseType());
		if ( hasNetworkRequestID())
			out.setNetworkRequestID(getNetworkRequestID());
		if ( hasNetworkResponseID())
			out.setNetworkResponseID(getNetworkResponseID());
		if ( hasLastNetworkResponseID())
			out.setLastNetworkResponseID(getLastNetworkResponseID());
		int count = 0;
		count = 0;
		for (FixCompIDStatGrp fixCompIDStatGrp : compIDStatGrp) {
			if (!fixCompIDStatGrp.hasGroup()) continue;
			out.compIDStatGrp[count] = fixCompIDStatGrp.clone( out.compIDStatGrp[count] );
			count++;
		}
		return out;
	}

}
