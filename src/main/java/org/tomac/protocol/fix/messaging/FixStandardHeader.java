package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixStandardHeader extends FixGroup {
	private short hasBeginString;
	byte[] beginString = new byte[7];		
	private short hasBodyLength;
	long bodyLength = 0;		
	private short hasMsgType;
	byte[] msgType = new byte[2];		
	private short hasMsgSeqNum;
	long msgSeqNum = 0;		
	private short hasPossDupFlag;
		boolean possDupFlag = false;		
	private short hasSenderCompID;
	byte[] senderCompID = new byte[12];		
	private short hasSenderSubID;
	byte[] senderSubID = new byte[6];		
	private short hasSendingTime;
	byte[] sendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTargetCompID;
	byte[] targetCompID = new byte[12];		
	private short hasTargetSubID;
	byte[] targetSubID = new byte[20];		
	private short hasPossResend;
		boolean possResend = false;		
	private short hasOnBehalfOfCompID;
	byte[] onBehalfOfCompID = new byte[12];		
	private short hasOnBehalfOfSubID;
	byte[] onBehalfOfSubID = new byte[6];		
	private short hasOrigSendingTime;
	byte[] origSendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasDeliverToCompID;
	byte[] deliverToCompID = new byte[12];		
	private short hasDeliverToSubID;
	byte[] deliverToSubID = new byte[6];		
	
	public FixStandardHeader() {
		super(FixTags.BEGINSTRING_INT);

		System.arraycopy( msgType, 0, this.msgType, 0, msgType.length );
		
		hasBeginString = FixUtils.TAG_HAS_NO_VALUE;		
		beginString = new byte[7];		
		hasBodyLength = FixUtils.TAG_HAS_NO_VALUE;		
		hasMsgType = FixUtils.TAG_HAS_NO_VALUE;		
		msgType = new byte[2];		
		hasMsgSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		hasPossDupFlag = FixUtils.TAG_HAS_NO_VALUE;		
		hasSenderCompID = FixUtils.TAG_HAS_NO_VALUE;		
		senderCompID = new byte[12];		
		hasSenderSubID = FixUtils.TAG_HAS_NO_VALUE;		
		senderSubID = new byte[6];		
		hasSendingTime = FixUtils.TAG_HAS_NO_VALUE;		
		sendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTargetCompID = FixUtils.TAG_HAS_NO_VALUE;		
		targetCompID = new byte[12];		
		hasTargetSubID = FixUtils.TAG_HAS_NO_VALUE;		
		targetSubID = new byte[20];		
		hasPossResend = FixUtils.TAG_HAS_NO_VALUE;		
		hasOnBehalfOfCompID = FixUtils.TAG_HAS_NO_VALUE;		
		onBehalfOfCompID = new byte[12];		
		hasOnBehalfOfSubID = FixUtils.TAG_HAS_NO_VALUE;		
		onBehalfOfSubID = new byte[6];		
		hasOrigSendingTime = FixUtils.TAG_HAS_NO_VALUE;		
		origSendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasDeliverToCompID = FixUtils.TAG_HAS_NO_VALUE;		
		deliverToCompID = new byte[12];		
		hasDeliverToSubID = FixUtils.TAG_HAS_NO_VALUE;		
		deliverToSubID = new byte[6];		
		
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
            	case FixTags.MSGSEQNUM_INT:		
            		hasMsgSeqNum = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.POSSDUPFLAG_INT:		
            		hasPossDupFlag = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SENDERCOMPID_INT:		
            		hasSenderCompID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SENDERSUBID_INT:		
            		hasSenderSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SENDINGTIME_INT:		
            		hasSendingTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TARGETCOMPID_INT:		
            		hasTargetCompID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TARGETSUBID_INT:		
            		hasTargetSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.POSSRESEND_INT:		
            		hasPossResend = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ONBEHALFOFCOMPID_INT:		
            		hasOnBehalfOfCompID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ONBEHALFOFSUBID_INT:		
            		hasOnBehalfOfSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORIGSENDINGTIME_INT:		
            		hasOrigSendingTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DELIVERTOCOMPID_INT:		
            		hasDeliverToCompID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DELIVERTOSUBID_INT:		
            		hasDeliverToSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasBeginString = FixUtils.TAG_HAS_NO_VALUE;
		hasBodyLength = FixUtils.TAG_HAS_NO_VALUE;
		hasMsgType = FixUtils.TAG_HAS_NO_VALUE;
		hasMsgSeqNum = FixUtils.TAG_HAS_NO_VALUE;
		hasPossDupFlag = FixUtils.TAG_HAS_NO_VALUE;
		hasSenderCompID = FixUtils.TAG_HAS_NO_VALUE;
		hasSenderSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasSendingTime = FixUtils.TAG_HAS_NO_VALUE;
		hasTargetCompID = FixUtils.TAG_HAS_NO_VALUE;
		hasTargetSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasPossResend = FixUtils.TAG_HAS_NO_VALUE;
		hasOnBehalfOfCompID = FixUtils.TAG_HAS_NO_VALUE;
		hasOnBehalfOfSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasOrigSendingTime = FixUtils.TAG_HAS_NO_VALUE;
		hasDeliverToCompID = FixUtils.TAG_HAS_NO_VALUE;
		hasDeliverToSubID = FixUtils.TAG_HAS_NO_VALUE;
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

		if (hasMsgSeqNum()) {		
			out.put(FixTags.MSGSEQNUM);

			out.put((byte) '=');

			FixUtils.put(out, (long)msgSeqNum);
		
			out.put(FixUtils.SOH);

            }

		if (hasPossDupFlag()) {		
			out.put(FixTags.POSSDUPFLAG);

			out.put((byte) '=');

			out.put(possDupFlag?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasSenderCompID()) {		
			out.put(FixTags.SENDERCOMPID);

			out.put((byte) '=');

			FixUtils.put(out,senderCompID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSenderSubID()) {		
			out.put(FixTags.SENDERSUBID);

			out.put((byte) '=');

			FixUtils.put(out,senderSubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSendingTime()) {		
			out.put(FixTags.SENDINGTIME);

			out.put((byte) '=');

			FixUtils.put(out,sendingTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTargetCompID()) {		
			out.put(FixTags.TARGETCOMPID);

			out.put((byte) '=');

			FixUtils.put(out,targetCompID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTargetSubID()) {		
			out.put(FixTags.TARGETSUBID);

			out.put((byte) '=');

			FixUtils.put(out,targetSubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPossResend()) {		
			out.put(FixTags.POSSRESEND);

			out.put((byte) '=');

			out.put(possResend?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasOnBehalfOfCompID()) {		
			out.put(FixTags.ONBEHALFOFCOMPID);

			out.put((byte) '=');

			FixUtils.put(out,onBehalfOfCompID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOnBehalfOfSubID()) {		
			out.put(FixTags.ONBEHALFOFSUBID);

			out.put((byte) '=');

			FixUtils.put(out,onBehalfOfSubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrigSendingTime()) {		
			out.put(FixTags.ORIGSENDINGTIME);

			out.put((byte) '=');

			FixUtils.put(out,origSendingTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDeliverToCompID()) {		
			out.put(FixTags.DELIVERTOCOMPID);

			out.put((byte) '=');

			FixUtils.put(out,deliverToCompID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDeliverToSubID()) {		
			out.put(FixTags.DELIVERTOSUBID);

			out.put((byte) '=');

			FixUtils.put(out,deliverToSubID); 		
		
			out.put(FixUtils.SOH);

            }

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
		
		if (hasMsgSeqNum()) {		
			FixUtils.put(out, (long)msgSeqNum);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPossDupFlag()) {		
			out.put(possDupFlag?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSenderCompID()) {		
			FixUtils.put(out,senderCompID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSenderSubID()) {		
			FixUtils.put(out,senderSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSendingTime()) {		
			FixUtils.put(out,sendingTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTargetCompID()) {		
			FixUtils.put(out,targetCompID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTargetSubID()) {		
			FixUtils.put(out,targetSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPossResend()) {		
			out.put(possResend?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOnBehalfOfCompID()) {		
			FixUtils.put(out,onBehalfOfCompID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOnBehalfOfSubID()) {		
			FixUtils.put(out,onBehalfOfSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigSendingTime()) {		
			FixUtils.put(out,origSendingTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDeliverToCompID()) {		
			FixUtils.put(out,deliverToCompID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDeliverToSubID()) {		
			FixUtils.put(out,deliverToSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
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
		if (hasMsgSeqNum()) s += "MsgSeqNum(34)= " + getMsgSeqNum() + "\n" ; 
		if (hasPossDupFlag()) s += "PossDupFlag(43)= " + getPossDupFlag() + "\n" ; 
		if (hasSenderCompID()) s += "SenderCompID(49)= " + new String( FixUtils.trim(getSenderCompID()) ) + "\n" ; 
		if (hasSenderSubID()) s += "SenderSubID(50)= " + new String( FixUtils.trim(getSenderSubID()) ) + "\n" ; 
		if (hasSendingTime()) s += "SendingTime(52)= " + new String( FixUtils.trim(getSendingTime()) ) + "\n" ; 
		if (hasTargetCompID()) s += "TargetCompID(56)= " + new String( FixUtils.trim(getTargetCompID()) ) + "\n" ; 
		if (hasTargetSubID()) s += "TargetSubID(57)= " + new String( FixUtils.trim(getTargetSubID()) ) + "\n" ; 
		if (hasPossResend()) s += "PossResend(97)= " + getPossResend() + "\n" ; 
		if (hasOnBehalfOfCompID()) s += "OnBehalfOfCompID(115)= " + new String( FixUtils.trim(getOnBehalfOfCompID()) ) + "\n" ; 
		if (hasOnBehalfOfSubID()) s += "OnBehalfOfSubID(116)= " + new String( FixUtils.trim(getOnBehalfOfSubID()) ) + "\n" ; 
		if (hasOrigSendingTime()) s += "OrigSendingTime(122)= " + new String( FixUtils.trim(getOrigSendingTime()) ) + "\n" ; 
		if (hasDeliverToCompID()) s += "DeliverToCompID(128)= " + new String( FixUtils.trim(getDeliverToCompID()) ) + "\n" ; 
		if (hasDeliverToSubID()) s += "DeliverToSubID(129)= " + new String( FixUtils.trim(getDeliverToSubID()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStandardHeader)) return false;

		FixStandardHeader msg = (FixStandardHeader) o;

		if ((hasBeginString() && !msg.hasBeginString()) || (!hasBeginString() && msg.hasBeginString())) return false;
		if (!(!hasBeginString() && !msg.hasBeginString()) && !FixUtils.equals(getBeginString(), msg.getBeginString())) return false;
		if ((hasBodyLength() && !msg.hasBodyLength()) || (!hasBodyLength() && msg.hasBodyLength())) return false;
		if (!(!hasBodyLength() && !msg.hasBodyLength()) && !(getBodyLength()==msg.getBodyLength())) return false;
		if ((hasMsgType() && !msg.hasMsgType()) || (!hasMsgType() && msg.hasMsgType())) return false;
		if (!(!hasMsgType() && !msg.hasMsgType()) && !FixUtils.equals(getMsgType(), msg.getMsgType())) return false;
		if ((hasMsgSeqNum() && !msg.hasMsgSeqNum()) || (!hasMsgSeqNum() && msg.hasMsgSeqNum())) return false;
		if (!(!hasMsgSeqNum() && !msg.hasMsgSeqNum()) && !(getMsgSeqNum()==msg.getMsgSeqNum())) return false;
		if ((hasPossDupFlag() && !msg.hasPossDupFlag()) || (!hasPossDupFlag() && msg.hasPossDupFlag())) return false;
		if (!(!hasPossDupFlag() && !msg.hasPossDupFlag()) && !(getPossDupFlag()==msg.getPossDupFlag())) return false;
		if ((hasSenderCompID() && !msg.hasSenderCompID()) || (!hasSenderCompID() && msg.hasSenderCompID())) return false;
		if (!(!hasSenderCompID() && !msg.hasSenderCompID()) && !FixUtils.equals(getSenderCompID(), msg.getSenderCompID())) return false;
		if ((hasSenderSubID() && !msg.hasSenderSubID()) || (!hasSenderSubID() && msg.hasSenderSubID())) return false;
		if (!(!hasSenderSubID() && !msg.hasSenderSubID()) && !FixUtils.equals(getSenderSubID(), msg.getSenderSubID())) return false;
		if ((hasSendingTime() && !msg.hasSendingTime()) || (!hasSendingTime() && msg.hasSendingTime())) return false;
		if (!(!hasSendingTime() && !msg.hasSendingTime()) ) return false;
		if ((hasTargetCompID() && !msg.hasTargetCompID()) || (!hasTargetCompID() && msg.hasTargetCompID())) return false;
		if (!(!hasTargetCompID() && !msg.hasTargetCompID()) && !FixUtils.equals(getTargetCompID(), msg.getTargetCompID())) return false;
		if ((hasTargetSubID() && !msg.hasTargetSubID()) || (!hasTargetSubID() && msg.hasTargetSubID())) return false;
		if (!(!hasTargetSubID() && !msg.hasTargetSubID()) && !FixUtils.equals(getTargetSubID(), msg.getTargetSubID())) return false;
		if ((hasPossResend() && !msg.hasPossResend()) || (!hasPossResend() && msg.hasPossResend())) return false;
		if (!(!hasPossResend() && !msg.hasPossResend()) && !(getPossResend()==msg.getPossResend())) return false;
		if ((hasOnBehalfOfCompID() && !msg.hasOnBehalfOfCompID()) || (!hasOnBehalfOfCompID() && msg.hasOnBehalfOfCompID())) return false;
		if (!(!hasOnBehalfOfCompID() && !msg.hasOnBehalfOfCompID()) && !FixUtils.equals(getOnBehalfOfCompID(), msg.getOnBehalfOfCompID())) return false;
		if ((hasOnBehalfOfSubID() && !msg.hasOnBehalfOfSubID()) || (!hasOnBehalfOfSubID() && msg.hasOnBehalfOfSubID())) return false;
		if (!(!hasOnBehalfOfSubID() && !msg.hasOnBehalfOfSubID()) && !FixUtils.equals(getOnBehalfOfSubID(), msg.getOnBehalfOfSubID())) return false;
		if ((hasOrigSendingTime() && !msg.hasOrigSendingTime()) || (!hasOrigSendingTime() && msg.hasOrigSendingTime())) return false;
		if (!(!hasOrigSendingTime() && !msg.hasOrigSendingTime()) ) return false;
		if ((hasDeliverToCompID() && !msg.hasDeliverToCompID()) || (!hasDeliverToCompID() && msg.hasDeliverToCompID())) return false;
		if (!(!hasDeliverToCompID() && !msg.hasDeliverToCompID()) && !FixUtils.equals(getDeliverToCompID(), msg.getDeliverToCompID())) return false;
		if ((hasDeliverToSubID() && !msg.hasDeliverToSubID()) || (!hasDeliverToSubID() && msg.hasDeliverToSubID())) return false;
		if (!(!hasDeliverToSubID() && !msg.hasDeliverToSubID()) && !FixUtils.equals(getDeliverToSubID(), msg.getDeliverToSubID())) return false;
		return true;
	}
	public FixStandardHeader clone ( FixStandardHeader out ) {
		if ( hasBeginString())
			out.setBeginString(getBeginString());
		if ( hasBodyLength())
			out.setBodyLength(getBodyLength());
		if ( hasMsgType())
			out.setMsgType(getMsgType());
		if ( hasMsgSeqNum())
			out.setMsgSeqNum(getMsgSeqNum());
		if ( hasPossDupFlag())
			out.setPossDupFlag(getPossDupFlag());
		if ( hasSenderCompID())
			out.setSenderCompID(getSenderCompID());
		if ( hasSenderSubID())
			out.setSenderSubID(getSenderSubID());
		if ( hasSendingTime())
			out.setSendingTime(getSendingTime());
		if ( hasTargetCompID())
			out.setTargetCompID(getTargetCompID());
		if ( hasTargetSubID())
			out.setTargetSubID(getTargetSubID());
		if ( hasPossResend())
			out.setPossResend(getPossResend());
		if ( hasOnBehalfOfCompID())
			out.setOnBehalfOfCompID(getOnBehalfOfCompID());
		if ( hasOnBehalfOfSubID())
			out.setOnBehalfOfSubID(getOnBehalfOfSubID());
		if ( hasOrigSendingTime())
			out.setOrigSendingTime(getOrigSendingTime());
		if ( hasDeliverToCompID())
			out.setDeliverToCompID(getDeliverToCompID());
		if ( hasDeliverToSubID())
			out.setDeliverToSubID(getDeliverToSubID());
		return out;
	}

}
