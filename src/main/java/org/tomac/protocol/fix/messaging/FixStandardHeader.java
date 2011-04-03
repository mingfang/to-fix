package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixStandardHeader extends FixGroup {
	private short hasBeginString;
	byte[] beginString = new byte[8];		
	private short hasBodyLength;
	long bodyLength = 0;		
	private short hasMsgType;
	byte[] msgType = new byte[2];		
	private short hasApplVerID;
	byte[] applVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCstmApplVerID;
	byte[] cstmApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasApplExtID;
	long applExtID = 0;		
	private short hasSenderCompID;
	byte[] senderCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTargetCompID;
	byte[] targetCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOnBehalfOfCompID;
	byte[] onBehalfOfCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDeliverToCompID;
	byte[] deliverToCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecureDataLen;
	long secureDataLen = 0;		
	private short hasSecureData;
	byte[] secureData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMsgSeqNum;
	long msgSeqNum = 0;		
	private short hasSenderSubID;
	byte[] senderSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSenderLocationID;
	byte[] senderLocationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTargetSubID;
	byte[] targetSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTargetLocationID;
	byte[] targetLocationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOnBehalfOfSubID;
	byte[] onBehalfOfSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOnBehalfOfLocationID;
	byte[] onBehalfOfLocationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDeliverToSubID;
	byte[] deliverToSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDeliverToLocationID;
	byte[] deliverToLocationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPossDupFlag;
		boolean possDupFlag = false;		
	private short hasPossResend;
		boolean possResend = false;		
	private short hasSendingTime;
	byte[] sendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasOrigSendingTime;
	byte[] origSendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasXmlDataLen;
	long xmlDataLen = 0;		
	private short hasXmlData;
	byte[] xmlData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMessageEncoding;
	byte[] messageEncoding = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLastMsgSeqNumProcessed;
	long lastMsgSeqNumProcessed = 0;		
		public FixHopGrp[] hopGrp;
	
	public FixStandardHeader() {
		this(false);
	}

	public FixStandardHeader(boolean isRequired) {
		super(FixTags.BEGINSTRING_INT);

		this.isRequired = isRequired;
		System.arraycopy( msgType, 0, this.msgType, 0, msgType.length );
		
		hasBeginString = FixUtils.TAG_HAS_NO_VALUE;		
		beginString = new byte[8];		
		hasBodyLength = FixUtils.TAG_HAS_NO_VALUE;		
		hasMsgType = FixUtils.TAG_HAS_NO_VALUE;		
		msgType = new byte[2];		
		hasApplVerID = FixUtils.TAG_HAS_NO_VALUE;		
		applVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCstmApplVerID = FixUtils.TAG_HAS_NO_VALUE;		
		cstmApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasApplExtID = FixUtils.TAG_HAS_NO_VALUE;		
		hasSenderCompID = FixUtils.TAG_HAS_NO_VALUE;		
		senderCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTargetCompID = FixUtils.TAG_HAS_NO_VALUE;		
		targetCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOnBehalfOfCompID = FixUtils.TAG_HAS_NO_VALUE;		
		onBehalfOfCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDeliverToCompID = FixUtils.TAG_HAS_NO_VALUE;		
		deliverToCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecureDataLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecureData = FixUtils.TAG_HAS_NO_VALUE;		
		secureData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMsgSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		hasSenderSubID = FixUtils.TAG_HAS_NO_VALUE;		
		senderSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSenderLocationID = FixUtils.TAG_HAS_NO_VALUE;		
		senderLocationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTargetSubID = FixUtils.TAG_HAS_NO_VALUE;		
		targetSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTargetLocationID = FixUtils.TAG_HAS_NO_VALUE;		
		targetLocationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOnBehalfOfSubID = FixUtils.TAG_HAS_NO_VALUE;		
		onBehalfOfSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOnBehalfOfLocationID = FixUtils.TAG_HAS_NO_VALUE;		
		onBehalfOfLocationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDeliverToSubID = FixUtils.TAG_HAS_NO_VALUE;		
		deliverToSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDeliverToLocationID = FixUtils.TAG_HAS_NO_VALUE;		
		deliverToLocationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPossDupFlag = FixUtils.TAG_HAS_NO_VALUE;		
		hasPossResend = FixUtils.TAG_HAS_NO_VALUE;		
		hasSendingTime = FixUtils.TAG_HAS_NO_VALUE;		
		sendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasOrigSendingTime = FixUtils.TAG_HAS_NO_VALUE;		
		origSendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasXmlDataLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasXmlData = FixUtils.TAG_HAS_NO_VALUE;		
		xmlData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMessageEncoding = FixUtils.TAG_HAS_NO_VALUE;		
		messageEncoding = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLastMsgSeqNumProcessed = FixUtils.TAG_HAS_NO_VALUE;		
		hopGrp = new FixHopGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) hopGrp[i] = new FixHopGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasBeginString()) return true;
		else return false;
	}


	/**
     * Parse FIX Group. The buffer is positioned at the value of the tag.
     */
    public int setBuffer( int tag, ByteBuffer buf, FixValidationError err)
    {

		super.err = err;
		super.err.clear();
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.BEGINSTRING_INT:		
            		hasBeginString = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.BODYLENGTH_INT:		
            		hasBodyLength = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MSGTYPE_INT:		
            		hasMsgType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.APPLVERID_INT:		
            		hasApplVerID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CSTMAPPLVERID_INT:		
            		hasCstmApplVerID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.APPLEXTID_INT:		
            		hasApplExtID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SENDERCOMPID_INT:		
            		hasSenderCompID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TARGETCOMPID_INT:		
            		hasTargetCompID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ONBEHALFOFCOMPID_INT:		
            		hasOnBehalfOfCompID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DELIVERTOCOMPID_INT:		
            		hasDeliverToCompID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECUREDATALEN_INT:		
            		hasSecureDataLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECUREDATA_INT:		
            		hasSecureData = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MSGSEQNUM_INT:		
            		hasMsgSeqNum = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SENDERSUBID_INT:		
            		hasSenderSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SENDERLOCATIONID_INT:		
            		hasSenderLocationID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TARGETSUBID_INT:		
            		hasTargetSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TARGETLOCATIONID_INT:		
            		hasTargetLocationID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ONBEHALFOFSUBID_INT:		
            		hasOnBehalfOfSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ONBEHALFOFLOCATIONID_INT:		
            		hasOnBehalfOfLocationID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DELIVERTOSUBID_INT:		
            		hasDeliverToSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DELIVERTOLOCATIONID_INT:		
            		hasDeliverToLocationID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.POSSDUPFLAG_INT:		
            		hasPossDupFlag = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.POSSRESEND_INT:		
            		hasPossResend = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SENDINGTIME_INT:		
            		hasSendingTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORIGSENDINGTIME_INT:		
            		hasOrigSendingTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.XMLDATALEN_INT:		
            		hasXmlDataLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.XMLDATA_INT:		
            		hasXmlData = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MESSAGEENCODING_INT:		
            		hasMessageEncoding = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LASTMSGSEQNUMPROCESSED_INT:		
            		hasLastMsgSeqNumProcessed = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOHOPS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !hopGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = hopGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
            if (isKeyTag(tag)) return tag; // next in repeating group
        }		
        return tag;
    }		
	public boolean hasRequiredTags(FixValidationError err) {
		if (!hasBeginString()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag BeginString missing", FixTags.BEGINSTRING_INT);
			return false;
		}
		if (!hasBodyLength()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag BodyLength missing", FixTags.BODYLENGTH_INT);
			return false;
		}
		if (!hasMsgType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag MsgType missing", FixTags.MSGTYPE_INT);
			return false;
		}
		if (!hasSenderCompID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag SenderCompID missing", FixTags.SENDERCOMPID_INT);
			return false;
		}
		if (!hasTargetCompID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TargetCompID missing", FixTags.TARGETCOMPID_INT);
			return false;
		}
		if (!hasMsgSeqNum()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag MsgSeqNum missing", FixTags.MSGSEQNUM_INT);
			return false;
		}
		if (!hasSendingTime()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag SendingTime missing", FixTags.SENDINGTIME_INT);
			return false;
		}
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasBeginString = FixUtils.TAG_HAS_NO_VALUE;
		hasBodyLength = FixUtils.TAG_HAS_NO_VALUE;
		hasMsgType = FixUtils.TAG_HAS_NO_VALUE;
		hasApplVerID = FixUtils.TAG_HAS_NO_VALUE;
		hasCstmApplVerID = FixUtils.TAG_HAS_NO_VALUE;
		hasApplExtID = FixUtils.TAG_HAS_NO_VALUE;
		hasSenderCompID = FixUtils.TAG_HAS_NO_VALUE;
		hasTargetCompID = FixUtils.TAG_HAS_NO_VALUE;
		hasOnBehalfOfCompID = FixUtils.TAG_HAS_NO_VALUE;
		hasDeliverToCompID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecureDataLen = FixUtils.TAG_HAS_NO_VALUE;
		hasSecureData = FixUtils.TAG_HAS_NO_VALUE;
		hasMsgSeqNum = FixUtils.TAG_HAS_NO_VALUE;
		hasSenderSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasSenderLocationID = FixUtils.TAG_HAS_NO_VALUE;
		hasTargetSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasTargetLocationID = FixUtils.TAG_HAS_NO_VALUE;
		hasOnBehalfOfSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasOnBehalfOfLocationID = FixUtils.TAG_HAS_NO_VALUE;
		hasDeliverToSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasDeliverToLocationID = FixUtils.TAG_HAS_NO_VALUE;
		hasPossDupFlag = FixUtils.TAG_HAS_NO_VALUE;
		hasPossResend = FixUtils.TAG_HAS_NO_VALUE;
		hasSendingTime = FixUtils.TAG_HAS_NO_VALUE;
		hasOrigSendingTime = FixUtils.TAG_HAS_NO_VALUE;
		hasXmlDataLen = FixUtils.TAG_HAS_NO_VALUE;
		hasXmlData = FixUtils.TAG_HAS_NO_VALUE;
		hasMessageEncoding = FixUtils.TAG_HAS_NO_VALUE;
		hasLastMsgSeqNumProcessed = FixUtils.TAG_HAS_NO_VALUE;
		for (FixHopGrp fixHopGrp : hopGrp) fixHopGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasBeginString()) {		
			out.put(FixTags.BEGINSTRING);

			out.put((byte) '=');

			FixUtils.put(out,beginString); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasBodyLength()) {		
			out.put(FixTags.BODYLENGTH);

			out.put((byte) '=');

			FixUtils.put(out, (long)bodyLength);
		
			out.put(FixUtils.SOH);

            }

		if (hasMsgType()) {		
			out.put(FixTags.MSGTYPE);

			out.put((byte) '=');

			FixUtils.put(out,msgType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasApplVerID()) {		
			out.put(FixTags.APPLVERID);

			out.put((byte) '=');

			FixUtils.put(out,applVerID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCstmApplVerID()) {		
			out.put(FixTags.CSTMAPPLVERID);

			out.put((byte) '=');

			FixUtils.put(out,cstmApplVerID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasApplExtID()) {		
			out.put(FixTags.APPLEXTID);

			out.put((byte) '=');

			FixUtils.put(out, (long)applExtID);
		
			out.put(FixUtils.SOH);

            }

		if (hasSenderCompID()) {		
			out.put(FixTags.SENDERCOMPID);

			out.put((byte) '=');

			FixUtils.put(out,senderCompID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTargetCompID()) {		
			out.put(FixTags.TARGETCOMPID);

			out.put((byte) '=');

			FixUtils.put(out,targetCompID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOnBehalfOfCompID()) {		
			out.put(FixTags.ONBEHALFOFCOMPID);

			out.put((byte) '=');

			FixUtils.put(out,onBehalfOfCompID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDeliverToCompID()) {		
			out.put(FixTags.DELIVERTOCOMPID);

			out.put((byte) '=');

			FixUtils.put(out,deliverToCompID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecureDataLen()) {		
			out.put(FixTags.SECUREDATALEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)secureDataLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasSecureData()) {		
			out.put(FixTags.SECUREDATA);

			out.put((byte) '=');

			FixUtils.put(out,secureData); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMsgSeqNum()) {		
			out.put(FixTags.MSGSEQNUM);

			out.put((byte) '=');

			FixUtils.put(out, (long)msgSeqNum);
		
			out.put(FixUtils.SOH);

            }

		if (hasSenderSubID()) {		
			out.put(FixTags.SENDERSUBID);

			out.put((byte) '=');

			FixUtils.put(out,senderSubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSenderLocationID()) {		
			out.put(FixTags.SENDERLOCATIONID);

			out.put((byte) '=');

			FixUtils.put(out,senderLocationID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTargetSubID()) {		
			out.put(FixTags.TARGETSUBID);

			out.put((byte) '=');

			FixUtils.put(out,targetSubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTargetLocationID()) {		
			out.put(FixTags.TARGETLOCATIONID);

			out.put((byte) '=');

			FixUtils.put(out,targetLocationID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOnBehalfOfSubID()) {		
			out.put(FixTags.ONBEHALFOFSUBID);

			out.put((byte) '=');

			FixUtils.put(out,onBehalfOfSubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOnBehalfOfLocationID()) {		
			out.put(FixTags.ONBEHALFOFLOCATIONID);

			out.put((byte) '=');

			FixUtils.put(out,onBehalfOfLocationID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDeliverToSubID()) {		
			out.put(FixTags.DELIVERTOSUBID);

			out.put((byte) '=');

			FixUtils.put(out,deliverToSubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDeliverToLocationID()) {		
			out.put(FixTags.DELIVERTOLOCATIONID);

			out.put((byte) '=');

			FixUtils.put(out,deliverToLocationID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPossDupFlag()) {		
			out.put(FixTags.POSSDUPFLAG);

			out.put((byte) '=');

			out.put(possDupFlag?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasPossResend()) {		
			out.put(FixTags.POSSRESEND);

			out.put((byte) '=');

			out.put(possResend?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasSendingTime()) {		
			out.put(FixTags.SENDINGTIME);

			out.put((byte) '=');

			FixUtils.put(out,sendingTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrigSendingTime()) {		
			out.put(FixTags.ORIGSENDINGTIME);

			out.put((byte) '=');

			FixUtils.put(out,origSendingTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasXmlDataLen()) {		
			out.put(FixTags.XMLDATALEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)xmlDataLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasXmlData()) {		
			out.put(FixTags.XMLDATA);

			out.put((byte) '=');

			FixUtils.put(out,xmlData); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMessageEncoding()) {		
			out.put(FixTags.MESSAGEENCODING);

			out.put((byte) '=');

			FixUtils.put(out,messageEncoding); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLastMsgSeqNumProcessed()) {		
			out.put(FixTags.LASTMSGSEQNUMPROCESSED);

			out.put((byte) '=');

			FixUtils.put(out, (long)lastMsgSeqNumProcessed);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(hopGrp)>0) {
			out.put(FixTags.NOHOPS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(hopGrp));

			out.put(FixUtils.SOH);

		}
		for (FixHopGrp fixHopGrp : hopGrp) if (fixHopGrp.hasGroup()) fixHopGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasBeginString()) {		
			FixUtils.put(out,beginString); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBodyLength()) {		
			FixUtils.put(out, (long)bodyLength);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMsgType()) {		
			FixUtils.put(out,msgType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplVerID()) {		
			FixUtils.put(out,applVerID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCstmApplVerID()) {		
			FixUtils.put(out,cstmApplVerID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplExtID()) {		
			FixUtils.put(out, (long)applExtID);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSenderCompID()) {		
			FixUtils.put(out,senderCompID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTargetCompID()) {		
			FixUtils.put(out,targetCompID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOnBehalfOfCompID()) {		
			FixUtils.put(out,onBehalfOfCompID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDeliverToCompID()) {		
			FixUtils.put(out,deliverToCompID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecureDataLen()) {		
			FixUtils.put(out, (long)secureDataLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecureData()) {		
			FixUtils.put(out,secureData); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMsgSeqNum()) {		
			FixUtils.put(out, (long)msgSeqNum);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSenderSubID()) {		
			FixUtils.put(out,senderSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSenderLocationID()) {		
			FixUtils.put(out,senderLocationID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTargetSubID()) {		
			FixUtils.put(out,targetSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTargetLocationID()) {		
			FixUtils.put(out,targetLocationID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOnBehalfOfSubID()) {		
			FixUtils.put(out,onBehalfOfSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOnBehalfOfLocationID()) {		
			FixUtils.put(out,onBehalfOfLocationID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDeliverToSubID()) {		
			FixUtils.put(out,deliverToSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDeliverToLocationID()) {		
			FixUtils.put(out,deliverToLocationID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPossDupFlag()) {		
			out.put(possDupFlag?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPossResend()) {		
			out.put(possResend?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSendingTime()) {		
			FixUtils.put(out,sendingTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigSendingTime()) {		
			FixUtils.put(out,origSendingTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasXmlDataLen()) {		
			FixUtils.put(out, (long)xmlDataLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasXmlData()) {		
			FixUtils.put(out,xmlData); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMessageEncoding()) {		
			FixUtils.put(out,messageEncoding); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastMsgSeqNumProcessed()) {		
			FixUtils.put(out, (long)lastMsgSeqNumProcessed);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixHopGrp fixHopGrp : hopGrp) fixHopGrp.printBuffer(out);
	}

	public byte[] getBeginString() { 		
		if ( hasBeginString()) {		
			if (hasBeginString == FixUtils.TAG_HAS_VALUE) {		
				return beginString; 		
			} else {		
		
				buf.position(hasBeginString);		
		
			FixMessage.getTagStringValue(buf, beginString, 0, beginString.length, err);
		
				if (err.hasError()) {		
					buf.position(hasBeginString);		
					return null;		
				}		
			}		
			hasBeginString = FixUtils.TAG_HAS_VALUE;		
			return beginString;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBeginString() { return hasBeginString != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBeginString(byte[] src) {		
		if (src == null ) return;
		if (hasBeginString()) FixUtils.fillSpace(beginString);		
		FixUtils.copy(beginString, src); 		
		hasBeginString = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBeginString(String str) {		
		if (str == null ) return;
		if (hasBeginString()) FixUtils.fillSpace(beginString);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(beginString, src); 		
		hasBeginString = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getBodyLength() { 		
		if ( hasBodyLength()) {		
			if (hasBodyLength == FixUtils.TAG_HAS_VALUE) {		
				return bodyLength; 		
			} else {		
		
				buf.position(hasBodyLength);		
		
			bodyLength = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBodyLength);		
					return 0;		
				}		
			}		
			hasBodyLength = FixUtils.TAG_HAS_VALUE;		
			return bodyLength;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBodyLength() { return hasBodyLength != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBodyLength(long src) {		
		bodyLength = src;
		hasBodyLength = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBodyLength(byte[] src) {		
		if (src == null ) return;
		if (hasBodyLength()) bodyLength = FixUtils.TAG_HAS_NO_VALUE;		
		bodyLength = FixUtils.longValueOf(src, 0, src.length);
		hasBodyLength = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBodyLength(String str) {		
		if (str == null ) return;
		if (hasBodyLength()) bodyLength = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bodyLength = FixUtils.longValueOf(src, 0, src.length);
		hasBodyLength = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMsgType() { 		
		if ( hasMsgType()) {		
			if (hasMsgType == FixUtils.TAG_HAS_VALUE) {		
				return msgType; 		
			} else {		
		
				buf.position(hasMsgType);		
		
			FixMessage.getTagStringValue(buf, msgType, 0, msgType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMsgType);		
					return null;		
				}		
			}		
			hasMsgType = FixUtils.TAG_HAS_VALUE;		
			return msgType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMsgType() { return hasMsgType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMsgType(byte[] src) {		
		if (src == null ) return;
		if (hasMsgType()) FixUtils.fillSpace(msgType);		
		FixUtils.copy(msgType, src); 		
		hasMsgType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMsgType(String str) {		
		if (str == null ) return;
		if (hasMsgType()) FixUtils.fillSpace(msgType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(msgType, src); 		
		hasMsgType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getApplVerID() { 		
		if ( hasApplVerID()) {		
			if (hasApplVerID == FixUtils.TAG_HAS_VALUE) {		
				return applVerID; 		
			} else {		
		
				buf.position(hasApplVerID);		
		
			FixMessage.getTagStringValue(buf, applVerID, 0, applVerID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasApplVerID);		
					return null;		
				}		
			}		
			hasApplVerID = FixUtils.TAG_HAS_VALUE;		
			return applVerID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasApplVerID() { return hasApplVerID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setApplVerID(byte[] src) {		
		if (src == null ) return;
		if (hasApplVerID()) FixUtils.fillSpace(applVerID);		
		FixUtils.copy(applVerID, src); 		
		hasApplVerID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setApplVerID(String str) {		
		if (str == null ) return;
		if (hasApplVerID()) FixUtils.fillSpace(applVerID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(applVerID, src); 		
		hasApplVerID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCstmApplVerID() { 		
		if ( hasCstmApplVerID()) {		
			if (hasCstmApplVerID == FixUtils.TAG_HAS_VALUE) {		
				return cstmApplVerID; 		
			} else {		
		
				buf.position(hasCstmApplVerID);		
		
			FixMessage.getTagStringValue(buf, cstmApplVerID, 0, cstmApplVerID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCstmApplVerID);		
					return null;		
				}		
			}		
			hasCstmApplVerID = FixUtils.TAG_HAS_VALUE;		
			return cstmApplVerID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCstmApplVerID() { return hasCstmApplVerID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCstmApplVerID(byte[] src) {		
		if (src == null ) return;
		if (hasCstmApplVerID()) FixUtils.fillSpace(cstmApplVerID);		
		FixUtils.copy(cstmApplVerID, src); 		
		hasCstmApplVerID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCstmApplVerID(String str) {		
		if (str == null ) return;
		if (hasCstmApplVerID()) FixUtils.fillSpace(cstmApplVerID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cstmApplVerID, src); 		
		hasCstmApplVerID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getApplExtID() { 		
		if ( hasApplExtID()) {		
			if (hasApplExtID == FixUtils.TAG_HAS_VALUE) {		
				return applExtID; 		
			} else {		
		
				buf.position(hasApplExtID);		
		
			applExtID = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasApplExtID);		
					return 0;		
				}		
			}		
			hasApplExtID = FixUtils.TAG_HAS_VALUE;		
			return applExtID;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplExtID() { return hasApplExtID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setApplExtID(long src) {		
		applExtID = src;
		hasApplExtID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplExtID(byte[] src) {		
		if (src == null ) return;
		if (hasApplExtID()) applExtID = FixUtils.TAG_HAS_NO_VALUE;		
		applExtID = FixUtils.longValueOf(src, 0, src.length);
		hasApplExtID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setApplExtID(String str) {		
		if (str == null ) return;
		if (hasApplExtID()) applExtID = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applExtID = FixUtils.longValueOf(src, 0, src.length);
		hasApplExtID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSenderCompID() { 		
		if ( hasSenderCompID()) {		
			if (hasSenderCompID == FixUtils.TAG_HAS_VALUE) {		
				return senderCompID; 		
			} else {		
		
				buf.position(hasSenderCompID);		
		
			FixMessage.getTagStringValue(buf, senderCompID, 0, senderCompID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSenderCompID);		
					return null;		
				}		
			}		
			hasSenderCompID = FixUtils.TAG_HAS_VALUE;		
			return senderCompID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSenderCompID() { return hasSenderCompID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSenderCompID(byte[] src) {		
		if (src == null ) return;
		if (hasSenderCompID()) FixUtils.fillSpace(senderCompID);		
		FixUtils.copy(senderCompID, src); 		
		hasSenderCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSenderCompID(String str) {		
		if (str == null ) return;
		if (hasSenderCompID()) FixUtils.fillSpace(senderCompID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(senderCompID, src); 		
		hasSenderCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTargetCompID() { 		
		if ( hasTargetCompID()) {		
			if (hasTargetCompID == FixUtils.TAG_HAS_VALUE) {		
				return targetCompID; 		
			} else {		
		
				buf.position(hasTargetCompID);		
		
			FixMessage.getTagStringValue(buf, targetCompID, 0, targetCompID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTargetCompID);		
					return null;		
				}		
			}		
			hasTargetCompID = FixUtils.TAG_HAS_VALUE;		
			return targetCompID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTargetCompID() { return hasTargetCompID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTargetCompID(byte[] src) {		
		if (src == null ) return;
		if (hasTargetCompID()) FixUtils.fillSpace(targetCompID);		
		FixUtils.copy(targetCompID, src); 		
		hasTargetCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTargetCompID(String str) {		
		if (str == null ) return;
		if (hasTargetCompID()) FixUtils.fillSpace(targetCompID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(targetCompID, src); 		
		hasTargetCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOnBehalfOfCompID() { 		
		if ( hasOnBehalfOfCompID()) {		
			if (hasOnBehalfOfCompID == FixUtils.TAG_HAS_VALUE) {		
				return onBehalfOfCompID; 		
			} else {		
		
				buf.position(hasOnBehalfOfCompID);		
		
			FixMessage.getTagStringValue(buf, onBehalfOfCompID, 0, onBehalfOfCompID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOnBehalfOfCompID);		
					return null;		
				}		
			}		
			hasOnBehalfOfCompID = FixUtils.TAG_HAS_VALUE;		
			return onBehalfOfCompID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOnBehalfOfCompID() { return hasOnBehalfOfCompID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOnBehalfOfCompID(byte[] src) {		
		if (src == null ) return;
		if (hasOnBehalfOfCompID()) FixUtils.fillSpace(onBehalfOfCompID);		
		FixUtils.copy(onBehalfOfCompID, src); 		
		hasOnBehalfOfCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOnBehalfOfCompID(String str) {		
		if (str == null ) return;
		if (hasOnBehalfOfCompID()) FixUtils.fillSpace(onBehalfOfCompID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(onBehalfOfCompID, src); 		
		hasOnBehalfOfCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDeliverToCompID() { 		
		if ( hasDeliverToCompID()) {		
			if (hasDeliverToCompID == FixUtils.TAG_HAS_VALUE) {		
				return deliverToCompID; 		
			} else {		
		
				buf.position(hasDeliverToCompID);		
		
			FixMessage.getTagStringValue(buf, deliverToCompID, 0, deliverToCompID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDeliverToCompID);		
					return null;		
				}		
			}		
			hasDeliverToCompID = FixUtils.TAG_HAS_VALUE;		
			return deliverToCompID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDeliverToCompID() { return hasDeliverToCompID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDeliverToCompID(byte[] src) {		
		if (src == null ) return;
		if (hasDeliverToCompID()) FixUtils.fillSpace(deliverToCompID);		
		FixUtils.copy(deliverToCompID, src); 		
		hasDeliverToCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDeliverToCompID(String str) {		
		if (str == null ) return;
		if (hasDeliverToCompID()) FixUtils.fillSpace(deliverToCompID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(deliverToCompID, src); 		
		hasDeliverToCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSecureDataLen() { 		
		if ( hasSecureDataLen()) {		
			if (hasSecureDataLen == FixUtils.TAG_HAS_VALUE) {		
				return secureDataLen; 		
			} else {		
		
				buf.position(hasSecureDataLen);		
		
			secureDataLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSecureDataLen);		
					return 0;		
				}		
			}		
			hasSecureDataLen = FixUtils.TAG_HAS_VALUE;		
			return secureDataLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecureDataLen() { return hasSecureDataLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecureDataLen(long src) {		
		secureDataLen = src;
		hasSecureDataLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecureDataLen(byte[] src) {		
		if (src == null ) return;
		if (hasSecureDataLen()) secureDataLen = FixUtils.TAG_HAS_NO_VALUE;		
		secureDataLen = FixUtils.longValueOf(src, 0, src.length);
		hasSecureDataLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecureDataLen(String str) {		
		if (str == null ) return;
		if (hasSecureDataLen()) secureDataLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		secureDataLen = FixUtils.longValueOf(src, 0, src.length);
		hasSecureDataLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecureData() { 		
		if ( hasSecureData()) {		
			if (hasSecureData == FixUtils.TAG_HAS_VALUE) {		
				return secureData; 		
			} else {		
		
				buf.position(hasSecureData);		
		
			FixMessage.getTagStringValue(buf, secureData, 0, secureData.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecureData);		
					return null;		
				}		
			}		
			hasSecureData = FixUtils.TAG_HAS_VALUE;		
			return secureData;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecureData() { return hasSecureData != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecureData(byte[] src) {		
		if (src == null ) return;
		if (hasSecureData()) FixUtils.fillSpace(secureData);		
		FixUtils.copy(secureData, src); 		
		hasSecureData = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecureData(String str) {		
		if (str == null ) return;
		if (hasSecureData()) FixUtils.fillSpace(secureData);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secureData, src); 		
		hasSecureData = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMsgSeqNum() { 		
		if ( hasMsgSeqNum()) {		
			if (hasMsgSeqNum == FixUtils.TAG_HAS_VALUE) {		
				return msgSeqNum; 		
			} else {		
		
				buf.position(hasMsgSeqNum);		
		
			msgSeqNum = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMsgSeqNum);		
					return 0;		
				}		
			}		
			hasMsgSeqNum = FixUtils.TAG_HAS_VALUE;		
			return msgSeqNum;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMsgSeqNum() { return hasMsgSeqNum != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMsgSeqNum(long src) {		
		msgSeqNum = src;
		hasMsgSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMsgSeqNum(byte[] src) {		
		if (src == null ) return;
		if (hasMsgSeqNum()) msgSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		msgSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasMsgSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMsgSeqNum(String str) {		
		if (str == null ) return;
		if (hasMsgSeqNum()) msgSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		msgSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasMsgSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSenderSubID() { 		
		if ( hasSenderSubID()) {		
			if (hasSenderSubID == FixUtils.TAG_HAS_VALUE) {		
				return senderSubID; 		
			} else {		
		
				buf.position(hasSenderSubID);		
		
			FixMessage.getTagStringValue(buf, senderSubID, 0, senderSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSenderSubID);		
					return null;		
				}		
			}		
			hasSenderSubID = FixUtils.TAG_HAS_VALUE;		
			return senderSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSenderSubID() { return hasSenderSubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSenderSubID(byte[] src) {		
		if (src == null ) return;
		if (hasSenderSubID()) FixUtils.fillSpace(senderSubID);		
		FixUtils.copy(senderSubID, src); 		
		hasSenderSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSenderSubID(String str) {		
		if (str == null ) return;
		if (hasSenderSubID()) FixUtils.fillSpace(senderSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(senderSubID, src); 		
		hasSenderSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSenderLocationID() { 		
		if ( hasSenderLocationID()) {		
			if (hasSenderLocationID == FixUtils.TAG_HAS_VALUE) {		
				return senderLocationID; 		
			} else {		
		
				buf.position(hasSenderLocationID);		
		
			FixMessage.getTagStringValue(buf, senderLocationID, 0, senderLocationID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSenderLocationID);		
					return null;		
				}		
			}		
			hasSenderLocationID = FixUtils.TAG_HAS_VALUE;		
			return senderLocationID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSenderLocationID() { return hasSenderLocationID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSenderLocationID(byte[] src) {		
		if (src == null ) return;
		if (hasSenderLocationID()) FixUtils.fillSpace(senderLocationID);		
		FixUtils.copy(senderLocationID, src); 		
		hasSenderLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSenderLocationID(String str) {		
		if (str == null ) return;
		if (hasSenderLocationID()) FixUtils.fillSpace(senderLocationID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(senderLocationID, src); 		
		hasSenderLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTargetSubID() { 		
		if ( hasTargetSubID()) {		
			if (hasTargetSubID == FixUtils.TAG_HAS_VALUE) {		
				return targetSubID; 		
			} else {		
		
				buf.position(hasTargetSubID);		
		
			FixMessage.getTagStringValue(buf, targetSubID, 0, targetSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTargetSubID);		
					return null;		
				}		
			}		
			hasTargetSubID = FixUtils.TAG_HAS_VALUE;		
			return targetSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTargetSubID() { return hasTargetSubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTargetSubID(byte[] src) {		
		if (src == null ) return;
		if (hasTargetSubID()) FixUtils.fillSpace(targetSubID);		
		FixUtils.copy(targetSubID, src); 		
		hasTargetSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTargetSubID(String str) {		
		if (str == null ) return;
		if (hasTargetSubID()) FixUtils.fillSpace(targetSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(targetSubID, src); 		
		hasTargetSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTargetLocationID() { 		
		if ( hasTargetLocationID()) {		
			if (hasTargetLocationID == FixUtils.TAG_HAS_VALUE) {		
				return targetLocationID; 		
			} else {		
		
				buf.position(hasTargetLocationID);		
		
			FixMessage.getTagStringValue(buf, targetLocationID, 0, targetLocationID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTargetLocationID);		
					return null;		
				}		
			}		
			hasTargetLocationID = FixUtils.TAG_HAS_VALUE;		
			return targetLocationID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTargetLocationID() { return hasTargetLocationID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTargetLocationID(byte[] src) {		
		if (src == null ) return;
		if (hasTargetLocationID()) FixUtils.fillSpace(targetLocationID);		
		FixUtils.copy(targetLocationID, src); 		
		hasTargetLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTargetLocationID(String str) {		
		if (str == null ) return;
		if (hasTargetLocationID()) FixUtils.fillSpace(targetLocationID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(targetLocationID, src); 		
		hasTargetLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOnBehalfOfSubID() { 		
		if ( hasOnBehalfOfSubID()) {		
			if (hasOnBehalfOfSubID == FixUtils.TAG_HAS_VALUE) {		
				return onBehalfOfSubID; 		
			} else {		
		
				buf.position(hasOnBehalfOfSubID);		
		
			FixMessage.getTagStringValue(buf, onBehalfOfSubID, 0, onBehalfOfSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOnBehalfOfSubID);		
					return null;		
				}		
			}		
			hasOnBehalfOfSubID = FixUtils.TAG_HAS_VALUE;		
			return onBehalfOfSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOnBehalfOfSubID() { return hasOnBehalfOfSubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOnBehalfOfSubID(byte[] src) {		
		if (src == null ) return;
		if (hasOnBehalfOfSubID()) FixUtils.fillSpace(onBehalfOfSubID);		
		FixUtils.copy(onBehalfOfSubID, src); 		
		hasOnBehalfOfSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOnBehalfOfSubID(String str) {		
		if (str == null ) return;
		if (hasOnBehalfOfSubID()) FixUtils.fillSpace(onBehalfOfSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(onBehalfOfSubID, src); 		
		hasOnBehalfOfSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOnBehalfOfLocationID() { 		
		if ( hasOnBehalfOfLocationID()) {		
			if (hasOnBehalfOfLocationID == FixUtils.TAG_HAS_VALUE) {		
				return onBehalfOfLocationID; 		
			} else {		
		
				buf.position(hasOnBehalfOfLocationID);		
		
			FixMessage.getTagStringValue(buf, onBehalfOfLocationID, 0, onBehalfOfLocationID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOnBehalfOfLocationID);		
					return null;		
				}		
			}		
			hasOnBehalfOfLocationID = FixUtils.TAG_HAS_VALUE;		
			return onBehalfOfLocationID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOnBehalfOfLocationID() { return hasOnBehalfOfLocationID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOnBehalfOfLocationID(byte[] src) {		
		if (src == null ) return;
		if (hasOnBehalfOfLocationID()) FixUtils.fillSpace(onBehalfOfLocationID);		
		FixUtils.copy(onBehalfOfLocationID, src); 		
		hasOnBehalfOfLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOnBehalfOfLocationID(String str) {		
		if (str == null ) return;
		if (hasOnBehalfOfLocationID()) FixUtils.fillSpace(onBehalfOfLocationID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(onBehalfOfLocationID, src); 		
		hasOnBehalfOfLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDeliverToSubID() { 		
		if ( hasDeliverToSubID()) {		
			if (hasDeliverToSubID == FixUtils.TAG_HAS_VALUE) {		
				return deliverToSubID; 		
			} else {		
		
				buf.position(hasDeliverToSubID);		
		
			FixMessage.getTagStringValue(buf, deliverToSubID, 0, deliverToSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDeliverToSubID);		
					return null;		
				}		
			}		
			hasDeliverToSubID = FixUtils.TAG_HAS_VALUE;		
			return deliverToSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDeliverToSubID() { return hasDeliverToSubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDeliverToSubID(byte[] src) {		
		if (src == null ) return;
		if (hasDeliverToSubID()) FixUtils.fillSpace(deliverToSubID);		
		FixUtils.copy(deliverToSubID, src); 		
		hasDeliverToSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDeliverToSubID(String str) {		
		if (str == null ) return;
		if (hasDeliverToSubID()) FixUtils.fillSpace(deliverToSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(deliverToSubID, src); 		
		hasDeliverToSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDeliverToLocationID() { 		
		if ( hasDeliverToLocationID()) {		
			if (hasDeliverToLocationID == FixUtils.TAG_HAS_VALUE) {		
				return deliverToLocationID; 		
			} else {		
		
				buf.position(hasDeliverToLocationID);		
		
			FixMessage.getTagStringValue(buf, deliverToLocationID, 0, deliverToLocationID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDeliverToLocationID);		
					return null;		
				}		
			}		
			hasDeliverToLocationID = FixUtils.TAG_HAS_VALUE;		
			return deliverToLocationID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDeliverToLocationID() { return hasDeliverToLocationID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDeliverToLocationID(byte[] src) {		
		if (src == null ) return;
		if (hasDeliverToLocationID()) FixUtils.fillSpace(deliverToLocationID);		
		FixUtils.copy(deliverToLocationID, src); 		
		hasDeliverToLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDeliverToLocationID(String str) {		
		if (str == null ) return;
		if (hasDeliverToLocationID()) FixUtils.fillSpace(deliverToLocationID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(deliverToLocationID, src); 		
		hasDeliverToLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getPossDupFlag() { 		
		if ( hasPossDupFlag()) {		
			if (hasPossDupFlag == FixUtils.TAG_HAS_VALUE) {		
				return possDupFlag; 		
			} else {		
		
				buf.position(hasPossDupFlag);		
		
			possDupFlag = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasPossDupFlag);		
					return false;		
				}		
			}		
			hasPossDupFlag = FixUtils.TAG_HAS_VALUE;		
			return possDupFlag;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasPossDupFlag() { return hasPossDupFlag != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPossDupFlag(boolean src) {		
		possDupFlag = src;
		hasPossDupFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPossDupFlag(byte[] src) {		
		if (src == null ) return;
		if (hasPossDupFlag()) possDupFlag = false;		
		possDupFlag = src[0]==(byte)'Y'?true:false;		
		hasPossDupFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPossDupFlag(String str) {		
		if (str == null ) return;
		if (hasPossDupFlag()) possDupFlag = false;		
		byte[] src = str.getBytes(); 		
		possDupFlag = src[0]==(byte)'Y'?true:false;		
		hasPossDupFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getPossResend() { 		
		if ( hasPossResend()) {		
			if (hasPossResend == FixUtils.TAG_HAS_VALUE) {		
				return possResend; 		
			} else {		
		
				buf.position(hasPossResend);		
		
			possResend = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasPossResend);		
					return false;		
				}		
			}		
			hasPossResend = FixUtils.TAG_HAS_VALUE;		
			return possResend;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasPossResend() { return hasPossResend != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPossResend(boolean src) {		
		possResend = src;
		hasPossResend = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPossResend(byte[] src) {		
		if (src == null ) return;
		if (hasPossResend()) possResend = false;		
		possResend = src[0]==(byte)'Y'?true:false;		
		hasPossResend = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPossResend(String str) {		
		if (str == null ) return;
		if (hasPossResend()) possResend = false;		
		byte[] src = str.getBytes(); 		
		possResend = src[0]==(byte)'Y'?true:false;		
		hasPossResend = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSendingTime() { 		
		if ( hasSendingTime()) {		
			if (hasSendingTime == FixUtils.TAG_HAS_VALUE) {		
				return sendingTime; 		
			} else {		
		
				buf.position(hasSendingTime);		
		
			FixMessage.getTagStringValue(buf, sendingTime, 0, sendingTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSendingTime);		
					return null;		
				}		
			}		
			hasSendingTime = FixUtils.TAG_HAS_VALUE;		
			return sendingTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSendingTime() { return hasSendingTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSendingTime(byte[] src) {		
		if (src == null ) return;
		if (hasSendingTime()) FixUtils.fillSpace(sendingTime);		
		FixUtils.copy(sendingTime, src); 		
		hasSendingTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSendingTime(String str) {		
		if (str == null ) return;
		if (hasSendingTime()) FixUtils.fillSpace(sendingTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(sendingTime, src); 		
		hasSendingTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOrigSendingTime() { 		
		if ( hasOrigSendingTime()) {		
			if (hasOrigSendingTime == FixUtils.TAG_HAS_VALUE) {		
				return origSendingTime; 		
			} else {		
		
				buf.position(hasOrigSendingTime);		
		
			FixMessage.getTagStringValue(buf, origSendingTime, 0, origSendingTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOrigSendingTime);		
					return null;		
				}		
			}		
			hasOrigSendingTime = FixUtils.TAG_HAS_VALUE;		
			return origSendingTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigSendingTime() { return hasOrigSendingTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrigSendingTime(byte[] src) {		
		if (src == null ) return;
		if (hasOrigSendingTime()) FixUtils.fillSpace(origSendingTime);		
		FixUtils.copy(origSendingTime, src); 		
		hasOrigSendingTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrigSendingTime(String str) {		
		if (str == null ) return;
		if (hasOrigSendingTime()) FixUtils.fillSpace(origSendingTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origSendingTime, src); 		
		hasOrigSendingTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getXmlDataLen() { 		
		if ( hasXmlDataLen()) {		
			if (hasXmlDataLen == FixUtils.TAG_HAS_VALUE) {		
				return xmlDataLen; 		
			} else {		
		
				buf.position(hasXmlDataLen);		
		
			xmlDataLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasXmlDataLen);		
					return 0;		
				}		
			}		
			hasXmlDataLen = FixUtils.TAG_HAS_VALUE;		
			return xmlDataLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasXmlDataLen() { return hasXmlDataLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setXmlDataLen(long src) {		
		xmlDataLen = src;
		hasXmlDataLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setXmlDataLen(byte[] src) {		
		if (src == null ) return;
		if (hasXmlDataLen()) xmlDataLen = FixUtils.TAG_HAS_NO_VALUE;		
		xmlDataLen = FixUtils.longValueOf(src, 0, src.length);
		hasXmlDataLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setXmlDataLen(String str) {		
		if (str == null ) return;
		if (hasXmlDataLen()) xmlDataLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		xmlDataLen = FixUtils.longValueOf(src, 0, src.length);
		hasXmlDataLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getXmlData() { 		
		if ( hasXmlData()) {		
			if (hasXmlData == FixUtils.TAG_HAS_VALUE) {		
				return xmlData; 		
			} else {		
		
				buf.position(hasXmlData);		
		
			FixMessage.getTagStringValue(buf, xmlData, 0, xmlData.length, err);
		
				if (err.hasError()) {		
					buf.position(hasXmlData);		
					return null;		
				}		
			}		
			hasXmlData = FixUtils.TAG_HAS_VALUE;		
			return xmlData;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasXmlData() { return hasXmlData != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setXmlData(byte[] src) {		
		if (src == null ) return;
		if (hasXmlData()) FixUtils.fillSpace(xmlData);		
		FixUtils.copy(xmlData, src); 		
		hasXmlData = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setXmlData(String str) {		
		if (str == null ) return;
		if (hasXmlData()) FixUtils.fillSpace(xmlData);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(xmlData, src); 		
		hasXmlData = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMessageEncoding() { 		
		if ( hasMessageEncoding()) {		
			if (hasMessageEncoding == FixUtils.TAG_HAS_VALUE) {		
				return messageEncoding; 		
			} else {		
		
				buf.position(hasMessageEncoding);		
		
			FixMessage.getTagStringValue(buf, messageEncoding, 0, messageEncoding.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMessageEncoding);		
					return null;		
				}		
			}		
			hasMessageEncoding = FixUtils.TAG_HAS_VALUE;		
			return messageEncoding;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMessageEncoding() { return hasMessageEncoding != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMessageEncoding(byte[] src) {		
		if (src == null ) return;
		if (hasMessageEncoding()) FixUtils.fillSpace(messageEncoding);		
		FixUtils.copy(messageEncoding, src); 		
		hasMessageEncoding = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMessageEncoding(String str) {		
		if (str == null ) return;
		if (hasMessageEncoding()) FixUtils.fillSpace(messageEncoding);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(messageEncoding, src); 		
		hasMessageEncoding = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLastMsgSeqNumProcessed() { 		
		if ( hasLastMsgSeqNumProcessed()) {		
			if (hasLastMsgSeqNumProcessed == FixUtils.TAG_HAS_VALUE) {		
				return lastMsgSeqNumProcessed; 		
			} else {		
		
				buf.position(hasLastMsgSeqNumProcessed);		
		
			lastMsgSeqNumProcessed = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLastMsgSeqNumProcessed);		
					return 0;		
				}		
			}		
			hasLastMsgSeqNumProcessed = FixUtils.TAG_HAS_VALUE;		
			return lastMsgSeqNumProcessed;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastMsgSeqNumProcessed() { return hasLastMsgSeqNumProcessed != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLastMsgSeqNumProcessed(long src) {		
		lastMsgSeqNumProcessed = src;
		hasLastMsgSeqNumProcessed = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastMsgSeqNumProcessed(byte[] src) {		
		if (src == null ) return;
		if (hasLastMsgSeqNumProcessed()) lastMsgSeqNumProcessed = FixUtils.TAG_HAS_NO_VALUE;		
		lastMsgSeqNumProcessed = FixUtils.longValueOf(src, 0, src.length);
		hasLastMsgSeqNumProcessed = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLastMsgSeqNumProcessed(String str) {		
		if (str == null ) return;
		if (hasLastMsgSeqNumProcessed()) lastMsgSeqNumProcessed = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastMsgSeqNumProcessed = FixUtils.longValueOf(src, 0, src.length);
		hasLastMsgSeqNumProcessed = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasBeginString()) s += "BeginString(8)= " + new String( FixUtils.trim(getBeginString()) ) + "\n" ; 
		if (hasBodyLength()) s += "BodyLength(9)= " + getBodyLength() + "\n" ; 
		if (hasMsgType()) s += "MsgType(35)= " + new String( FixUtils.trim(getMsgType()) ) + "\n" ; 
		if (hasApplVerID()) s += "ApplVerID(1128)= " + new String( FixUtils.trim(getApplVerID()) ) + "\n" ; 
		if (hasCstmApplVerID()) s += "CstmApplVerID(1129)= " + new String( FixUtils.trim(getCstmApplVerID()) ) + "\n" ; 
		if (hasApplExtID()) s += "ApplExtID(1156)= " + getApplExtID() + "\n" ; 
		if (hasSenderCompID()) s += "SenderCompID(49)= " + new String( FixUtils.trim(getSenderCompID()) ) + "\n" ; 
		if (hasTargetCompID()) s += "TargetCompID(56)= " + new String( FixUtils.trim(getTargetCompID()) ) + "\n" ; 
		if (hasOnBehalfOfCompID()) s += "OnBehalfOfCompID(115)= " + new String( FixUtils.trim(getOnBehalfOfCompID()) ) + "\n" ; 
		if (hasDeliverToCompID()) s += "DeliverToCompID(128)= " + new String( FixUtils.trim(getDeliverToCompID()) ) + "\n" ; 
		if (hasSecureDataLen()) s += "SecureDataLen(90)= " + getSecureDataLen() + "\n" ; 
		if (hasSecureData()) s += "SecureData(91)= " + new String( FixUtils.trim(getSecureData()) ) + "\n" ; 
		if (hasMsgSeqNum()) s += "MsgSeqNum(34)= " + getMsgSeqNum() + "\n" ; 
		if (hasSenderSubID()) s += "SenderSubID(50)= " + new String( FixUtils.trim(getSenderSubID()) ) + "\n" ; 
		if (hasSenderLocationID()) s += "SenderLocationID(142)= " + new String( FixUtils.trim(getSenderLocationID()) ) + "\n" ; 
		if (hasTargetSubID()) s += "TargetSubID(57)= " + new String( FixUtils.trim(getTargetSubID()) ) + "\n" ; 
		if (hasTargetLocationID()) s += "TargetLocationID(143)= " + new String( FixUtils.trim(getTargetLocationID()) ) + "\n" ; 
		if (hasOnBehalfOfSubID()) s += "OnBehalfOfSubID(116)= " + new String( FixUtils.trim(getOnBehalfOfSubID()) ) + "\n" ; 
		if (hasOnBehalfOfLocationID()) s += "OnBehalfOfLocationID(144)= " + new String( FixUtils.trim(getOnBehalfOfLocationID()) ) + "\n" ; 
		if (hasDeliverToSubID()) s += "DeliverToSubID(129)= " + new String( FixUtils.trim(getDeliverToSubID()) ) + "\n" ; 
		if (hasDeliverToLocationID()) s += "DeliverToLocationID(145)= " + new String( FixUtils.trim(getDeliverToLocationID()) ) + "\n" ; 
		if (hasPossDupFlag()) s += "PossDupFlag(43)= " + getPossDupFlag() + "\n" ; 
		if (hasPossResend()) s += "PossResend(97)= " + getPossResend() + "\n" ; 
		if (hasSendingTime()) s += "SendingTime(52)= " + new String( FixUtils.trim(getSendingTime()) ) + "\n" ; 
		if (hasOrigSendingTime()) s += "OrigSendingTime(122)= " + new String( FixUtils.trim(getOrigSendingTime()) ) + "\n" ; 
		if (hasXmlDataLen()) s += "XmlDataLen(212)= " + getXmlDataLen() + "\n" ; 
		if (hasXmlData()) s += "XmlData(213)= " + new String( FixUtils.trim(getXmlData()) ) + "\n" ; 
		if (hasMessageEncoding()) s += "MessageEncoding(347)= " + new String( FixUtils.trim(getMessageEncoding()) ) + "\n" ; 
		if (hasLastMsgSeqNumProcessed()) s += "LastMsgSeqNumProcessed(369)= " + getLastMsgSeqNumProcessed() + "\n" ; 

		for (FixHopGrp fixHopGrp : hopGrp) fixHopGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStandardHeader)) return false;

		FixStandardHeader msg = (FixStandardHeader) o;

		for (int i = 0; i < hopGrp.length; i++)
			if (!hopGrp[i].equals(msg.hopGrp[i])) return false;
		if ((hasBeginString() && !msg.hasBeginString()) || (!hasBeginString() && msg.hasBeginString())) return false;
		if (!(!hasBeginString() && !msg.hasBeginString()) && !FixUtils.equals(getBeginString(), msg.getBeginString())) return false;
		if ((hasMsgType() && !msg.hasMsgType()) || (!hasMsgType() && msg.hasMsgType())) return false;
		if (!(!hasMsgType() && !msg.hasMsgType()) && !FixUtils.equals(getMsgType(), msg.getMsgType())) return false;
		if ((hasApplVerID() && !msg.hasApplVerID()) || (!hasApplVerID() && msg.hasApplVerID())) return false;
		if (!(!hasApplVerID() && !msg.hasApplVerID()) && !FixUtils.equals(getApplVerID(), msg.getApplVerID())) return false;
		if ((hasCstmApplVerID() && !msg.hasCstmApplVerID()) || (!hasCstmApplVerID() && msg.hasCstmApplVerID())) return false;
		if (!(!hasCstmApplVerID() && !msg.hasCstmApplVerID()) && !FixUtils.equals(getCstmApplVerID(), msg.getCstmApplVerID())) return false;
		if ((hasApplExtID() && !msg.hasApplExtID()) || (!hasApplExtID() && msg.hasApplExtID())) return false;
		if (!(!hasApplExtID() && !msg.hasApplExtID()) && !(getApplExtID()==msg.getApplExtID())) return false;
		if ((hasSenderCompID() && !msg.hasSenderCompID()) || (!hasSenderCompID() && msg.hasSenderCompID())) return false;
		if (!(!hasSenderCompID() && !msg.hasSenderCompID()) && !FixUtils.equals(getSenderCompID(), msg.getSenderCompID())) return false;
		if ((hasTargetCompID() && !msg.hasTargetCompID()) || (!hasTargetCompID() && msg.hasTargetCompID())) return false;
		if (!(!hasTargetCompID() && !msg.hasTargetCompID()) && !FixUtils.equals(getTargetCompID(), msg.getTargetCompID())) return false;
		if ((hasOnBehalfOfCompID() && !msg.hasOnBehalfOfCompID()) || (!hasOnBehalfOfCompID() && msg.hasOnBehalfOfCompID())) return false;
		if (!(!hasOnBehalfOfCompID() && !msg.hasOnBehalfOfCompID()) && !FixUtils.equals(getOnBehalfOfCompID(), msg.getOnBehalfOfCompID())) return false;
		if ((hasDeliverToCompID() && !msg.hasDeliverToCompID()) || (!hasDeliverToCompID() && msg.hasDeliverToCompID())) return false;
		if (!(!hasDeliverToCompID() && !msg.hasDeliverToCompID()) && !FixUtils.equals(getDeliverToCompID(), msg.getDeliverToCompID())) return false;
		if ((hasSecureDataLen() && !msg.hasSecureDataLen()) || (!hasSecureDataLen() && msg.hasSecureDataLen())) return false;
		if (!(!hasSecureDataLen() && !msg.hasSecureDataLen()) && !(getSecureDataLen()==msg.getSecureDataLen())) return false;
		if ((hasSecureData() && !msg.hasSecureData()) || (!hasSecureData() && msg.hasSecureData())) return false;
		if (!(!hasSecureData() && !msg.hasSecureData()) && !FixUtils.equals(getSecureData(), msg.getSecureData())) return false;
		if ((hasMsgSeqNum() && !msg.hasMsgSeqNum()) || (!hasMsgSeqNum() && msg.hasMsgSeqNum())) return false;
		if (!(!hasMsgSeqNum() && !msg.hasMsgSeqNum()) && !(getMsgSeqNum()==msg.getMsgSeqNum())) return false;
		if ((hasSenderSubID() && !msg.hasSenderSubID()) || (!hasSenderSubID() && msg.hasSenderSubID())) return false;
		if (!(!hasSenderSubID() && !msg.hasSenderSubID()) && !FixUtils.equals(getSenderSubID(), msg.getSenderSubID())) return false;
		if ((hasSenderLocationID() && !msg.hasSenderLocationID()) || (!hasSenderLocationID() && msg.hasSenderLocationID())) return false;
		if (!(!hasSenderLocationID() && !msg.hasSenderLocationID()) && !FixUtils.equals(getSenderLocationID(), msg.getSenderLocationID())) return false;
		if ((hasTargetSubID() && !msg.hasTargetSubID()) || (!hasTargetSubID() && msg.hasTargetSubID())) return false;
		if (!(!hasTargetSubID() && !msg.hasTargetSubID()) && !FixUtils.equals(getTargetSubID(), msg.getTargetSubID())) return false;
		if ((hasTargetLocationID() && !msg.hasTargetLocationID()) || (!hasTargetLocationID() && msg.hasTargetLocationID())) return false;
		if (!(!hasTargetLocationID() && !msg.hasTargetLocationID()) && !FixUtils.equals(getTargetLocationID(), msg.getTargetLocationID())) return false;
		if ((hasOnBehalfOfSubID() && !msg.hasOnBehalfOfSubID()) || (!hasOnBehalfOfSubID() && msg.hasOnBehalfOfSubID())) return false;
		if (!(!hasOnBehalfOfSubID() && !msg.hasOnBehalfOfSubID()) && !FixUtils.equals(getOnBehalfOfSubID(), msg.getOnBehalfOfSubID())) return false;
		if ((hasOnBehalfOfLocationID() && !msg.hasOnBehalfOfLocationID()) || (!hasOnBehalfOfLocationID() && msg.hasOnBehalfOfLocationID())) return false;
		if (!(!hasOnBehalfOfLocationID() && !msg.hasOnBehalfOfLocationID()) && !FixUtils.equals(getOnBehalfOfLocationID(), msg.getOnBehalfOfLocationID())) return false;
		if ((hasDeliverToSubID() && !msg.hasDeliverToSubID()) || (!hasDeliverToSubID() && msg.hasDeliverToSubID())) return false;
		if (!(!hasDeliverToSubID() && !msg.hasDeliverToSubID()) && !FixUtils.equals(getDeliverToSubID(), msg.getDeliverToSubID())) return false;
		if ((hasDeliverToLocationID() && !msg.hasDeliverToLocationID()) || (!hasDeliverToLocationID() && msg.hasDeliverToLocationID())) return false;
		if (!(!hasDeliverToLocationID() && !msg.hasDeliverToLocationID()) && !FixUtils.equals(getDeliverToLocationID(), msg.getDeliverToLocationID())) return false;
		if ((hasPossDupFlag() && !msg.hasPossDupFlag()) || (!hasPossDupFlag() && msg.hasPossDupFlag())) return false;
		if (!(!hasPossDupFlag() && !msg.hasPossDupFlag()) && !(getPossDupFlag()==msg.getPossDupFlag())) return false;
		if ((hasPossResend() && !msg.hasPossResend()) || (!hasPossResend() && msg.hasPossResend())) return false;
		if (!(!hasPossResend() && !msg.hasPossResend()) && !(getPossResend()==msg.getPossResend())) return false;
		if ((hasSendingTime() && !msg.hasSendingTime()) || (!hasSendingTime() && msg.hasSendingTime())) return false;
		if ((hasOrigSendingTime() && !msg.hasOrigSendingTime()) || (!hasOrigSendingTime() && msg.hasOrigSendingTime())) return false;
		if ((hasXmlDataLen() && !msg.hasXmlDataLen()) || (!hasXmlDataLen() && msg.hasXmlDataLen())) return false;
		if (!(!hasXmlDataLen() && !msg.hasXmlDataLen()) && !(getXmlDataLen()==msg.getXmlDataLen())) return false;
		if ((hasXmlData() && !msg.hasXmlData()) || (!hasXmlData() && msg.hasXmlData())) return false;
		if (!(!hasXmlData() && !msg.hasXmlData()) && !FixUtils.equals(getXmlData(), msg.getXmlData())) return false;
		if ((hasMessageEncoding() && !msg.hasMessageEncoding()) || (!hasMessageEncoding() && msg.hasMessageEncoding())) return false;
		if (!(!hasMessageEncoding() && !msg.hasMessageEncoding()) && !FixUtils.equals(getMessageEncoding(), msg.getMessageEncoding())) return false;
		if ((hasLastMsgSeqNumProcessed() && !msg.hasLastMsgSeqNumProcessed()) || (!hasLastMsgSeqNumProcessed() && msg.hasLastMsgSeqNumProcessed())) return false;
		if (!(!hasLastMsgSeqNumProcessed() && !msg.hasLastMsgSeqNumProcessed()) && !(getLastMsgSeqNumProcessed()==msg.getLastMsgSeqNumProcessed())) return false;
		return true;
	}
	public FixStandardHeader clone ( FixStandardHeader out ) {
		if ( hasBeginString())
			out.setBeginString(getBeginString());
		if ( hasBodyLength())
			out.setBodyLength(getBodyLength());
		if ( hasMsgType())
			out.setMsgType(getMsgType());
		if ( hasApplVerID())
			out.setApplVerID(getApplVerID());
		if ( hasCstmApplVerID())
			out.setCstmApplVerID(getCstmApplVerID());
		if ( hasApplExtID())
			out.setApplExtID(getApplExtID());
		if ( hasSenderCompID())
			out.setSenderCompID(getSenderCompID());
		if ( hasTargetCompID())
			out.setTargetCompID(getTargetCompID());
		if ( hasOnBehalfOfCompID())
			out.setOnBehalfOfCompID(getOnBehalfOfCompID());
		if ( hasDeliverToCompID())
			out.setDeliverToCompID(getDeliverToCompID());
		if ( hasSecureDataLen())
			out.setSecureDataLen(getSecureDataLen());
		if ( hasSecureData())
			out.setSecureData(getSecureData());
		if ( hasMsgSeqNum())
			out.setMsgSeqNum(getMsgSeqNum());
		if ( hasSenderSubID())
			out.setSenderSubID(getSenderSubID());
		if ( hasSenderLocationID())
			out.setSenderLocationID(getSenderLocationID());
		if ( hasTargetSubID())
			out.setTargetSubID(getTargetSubID());
		if ( hasTargetLocationID())
			out.setTargetLocationID(getTargetLocationID());
		if ( hasOnBehalfOfSubID())
			out.setOnBehalfOfSubID(getOnBehalfOfSubID());
		if ( hasOnBehalfOfLocationID())
			out.setOnBehalfOfLocationID(getOnBehalfOfLocationID());
		if ( hasDeliverToSubID())
			out.setDeliverToSubID(getDeliverToSubID());
		if ( hasDeliverToLocationID())
			out.setDeliverToLocationID(getDeliverToLocationID());
		if ( hasPossDupFlag())
			out.setPossDupFlag(getPossDupFlag());
		if ( hasPossResend())
			out.setPossResend(getPossResend());
		if ( hasSendingTime())
			out.setSendingTime(getSendingTime());
		if ( hasOrigSendingTime())
			out.setOrigSendingTime(getOrigSendingTime());
		if ( hasXmlDataLen())
			out.setXmlDataLen(getXmlDataLen());
		if ( hasXmlData())
			out.setXmlData(getXmlData());
		if ( hasMessageEncoding())
			out.setMessageEncoding(getMessageEncoding());
		if ( hasLastMsgSeqNumProcessed())
			out.setLastMsgSeqNumProcessed(getLastMsgSeqNumProcessed());
		int count = 0;
		count = 0;
		for (FixHopGrp fixHopGrp : hopGrp) {
			if (!fixHopGrp.hasGroup()) continue;
			out.hopGrp[count] = fixHopGrp.clone( out.hopGrp[count] );
			count++;
		}
		return out;
	}

}
