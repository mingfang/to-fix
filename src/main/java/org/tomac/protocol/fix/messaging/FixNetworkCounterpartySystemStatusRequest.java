package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixNetworkCounterpartySystemStatusRequest extends FixInMessage {
	private short hasNetworkRequestType;
	long networkRequestType = 0;		
	private short hasNetworkRequestID;
	byte[] networkRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	public FixCompIDReqGrp[] compIDReqGrp;
	
	public FixNetworkCounterpartySystemStatusRequest() {
		super(FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSREQUEST);


		hasNetworkRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		hasNetworkRequestID = FixUtils.TAG_HAS_NO_VALUE;		
		networkRequestID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		compIDReqGrp = new FixCompIDReqGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) compIDReqGrp[i] = new FixCompIDReqGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.NETWORKREQUESTTYPE_INT:		
            		hasNetworkRequestType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.NETWORKREQUESTID_INT:		
            		hasNetworkRequestID = (short) buf.position();		
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
        			} else if ( tag == FixTags.NOCOMPIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !compIDReqGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOCOMPIDS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = compIDReqGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSREQUEST_INT);
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
		if (!hasNetworkRequestType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.NETWORKREQUESTTYPE_INT, FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSREQUEST_INT);
			return false;
		}
		if (!hasNetworkRequestID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.NETWORKREQUESTID_INT, FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSREQUEST_INT);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		getNetworkRequestType();		
		getNetworkRequestID();		
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
		if (hasNetworkRequestType()) {		
			out.put(FixTags.NETWORKREQUESTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)networkRequestType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNetworkRequestID()) {		
			out.put(FixTags.NETWORKREQUESTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,networkRequestID); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(compIDReqGrp)>0) {
			out.put(FixTags.NOCOMPIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(compIDReqGrp));

			out.put(FixUtils.SOH);

		}
		for (FixCompIDReqGrp fixCompIDReqGrp : compIDReqGrp) if (fixCompIDReqGrp.hasGroup()) fixCompIDReqGrp.encode(out);
		
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
		
		if (hasNetworkRequestType()) {		
			FixUtils.put(out, (long)networkRequestType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNetworkRequestID()) {		
			FixUtils.put(out,networkRequestID); 		
		
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
			
	public void crackNetworkRequestType() {		
		getNetworkRequestType();		
	}		
			
	public long getNetworkRequestType() { 		
		if ( hasNetworkRequestType()) {		
			if (hasNetworkRequestType == FixUtils.TAG_HAS_VALUE) {		
				return networkRequestType; 		
			} else {

				buf.position(hasNetworkRequestType);

			networkRequestType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasNetworkRequestType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return networkRequestType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNetworkRequestType() { return hasNetworkRequestType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNetworkRequestType(byte[] src) {		
		if (src == null ) return;
		if (hasNetworkRequestType()) networkRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		networkRequestType = FixUtils.longValueOf(src, 0, src.length);
		hasNetworkRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetworkRequestType(long src) {		
		networkRequestType = src;
		hasNetworkRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetworkRequestType(String str) {		
		if (str == null ) return;
		if (hasNetworkRequestType()) networkRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		networkRequestType = FixUtils.longValueOf(src, 0, src.length);
		hasNetworkRequestType = FixUtils.TAG_HAS_VALUE;		
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

			FixUtils.getTagStringValue(buf, networkRequestID, 0, networkRequestID.length, err);
		
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

					if (hasNetworkRequestType()) s += "NetworkRequestType(935)= " + getNetworkRequestType() + "\n" ; 
		if (hasNetworkRequestID()) s += "NetworkRequestID(933)= " + new String( FixUtils.trim(getNetworkRequestID()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNetworkCounterpartySystemStatusRequest)) return false;

		FixNetworkCounterpartySystemStatusRequest msg = (FixNetworkCounterpartySystemStatusRequest) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasNetworkRequestType() && !msg.hasNetworkRequestType()) || (!hasNetworkRequestType() && msg.hasNetworkRequestType())) return false;
		if (!(!hasNetworkRequestType() && !msg.hasNetworkRequestType()) && !(getNetworkRequestType()==msg.getNetworkRequestType())) return false;
		if ((hasNetworkRequestID() && !msg.hasNetworkRequestID()) || (!hasNetworkRequestID() && msg.hasNetworkRequestID())) return false;
		if (!(!hasNetworkRequestID() && !msg.hasNetworkRequestID()) && !FixUtils.equals(getNetworkRequestID(), msg.getNetworkRequestID())) return false;
		return true;
	}
	@Override
	public FixNetworkCounterpartySystemStatusRequest clone () {
		FixNetworkCounterpartySystemStatusRequest out = new FixNetworkCounterpartySystemStatusRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixNetworkCounterpartySystemStatusRequest clone ( FixNetworkCounterpartySystemStatusRequest out ) {
		if ( hasNetworkRequestType())
			out.setNetworkRequestType(getNetworkRequestType());
		if ( hasNetworkRequestID())
			out.setNetworkRequestID(getNetworkRequestID());
		int count = 0;
		count = 0;
		for (FixCompIDReqGrp fixCompIDReqGrp : compIDReqGrp) {
			if (!fixCompIDReqGrp.hasGroup()) continue;
			out.compIDReqGrp[count] = fixCompIDReqGrp.clone( out.compIDReqGrp[count] );
			count++;
		}
		return out;
	}

}
