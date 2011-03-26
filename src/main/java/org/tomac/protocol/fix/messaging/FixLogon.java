package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixLogon extends FixInMessage {
	private short hasEncryptMethod;
	long encryptMethod = 0;		
	private short hasHeartBtInt;
	long heartBtInt = 0;		
	private short hasResetSeqNumFlag;
		boolean resetSeqNumFlag = false;		
	
	public FixLogon() {
		super(FixMessageInfo.MessageTypes.LOGON);


		hasEncryptMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasHeartBtInt = FixUtils.TAG_HAS_NO_VALUE;		
		hasResetSeqNumFlag = FixUtils.TAG_HAS_NO_VALUE;		

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.ENCRYPTMETHOD_INT:		
            		hasEncryptMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.HEARTBTINT_INT:		
            		hasHeartBtInt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.RESETSEQNUMFLAG_INT:		
            		hasResetSeqNumFlag = (short) buf.position();		
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
		if (!hasEncryptMethod()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag EncryptMethod missing", FixTags.ENCRYPTMETHOD_INT, FixMessageInfo.MessageTypes.LOGON);
			return false;
		}
		if (!hasHeartBtInt()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag HeartBtInt missing", FixTags.HEARTBTINT_INT, FixMessageInfo.MessageTypes.LOGON);
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
		if (hasEncryptMethod()) {		
			out.put(FixTags.ENCRYPTMETHOD);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encryptMethod);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasHeartBtInt()) {		
			out.put(FixTags.HEARTBTINT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)heartBtInt);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasResetSeqNumFlag()) {		
			out.put(FixTags.RESETSEQNUMFLAG);		
		
			out.put((byte) '=');		
		
			out.put(resetSeqNumFlag?(byte)'Y':(byte)'N' );
		
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
		
		if (hasEncryptMethod()) {		
			FixUtils.put(out, (long)encryptMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHeartBtInt()) {		
			FixUtils.put(out, (long)heartBtInt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasResetSeqNumFlag()) {		
			out.put(resetSeqNumFlag?(byte)'Y':(byte)'N' );
		
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
			
	public void crackEncryptMethod() {		
		getEncryptMethod();		
	}		
			
	public long getEncryptMethod() { 		
		if ( hasEncryptMethod()) {		
			if (hasEncryptMethod == FixUtils.TAG_HAS_VALUE) {		
				return encryptMethod; 		
			} else {

				buf.position(hasEncryptMethod);

			encryptMethod = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncryptMethod = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encryptMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncryptMethod() { return hasEncryptMethod != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncryptMethod(byte[] src) {		
		if (src == null ) return;
		if (hasEncryptMethod()) encryptMethod = FixUtils.TAG_HAS_NO_VALUE;		
		encryptMethod = FixUtils.longValueOf(src, 0, src.length);
		hasEncryptMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncryptMethod(long src) {		
		encryptMethod = src;
		hasEncryptMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncryptMethod(String str) {		
		if (str == null ) return;
		if (hasEncryptMethod()) encryptMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encryptMethod = FixUtils.longValueOf(src, 0, src.length);
		hasEncryptMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackHeartBtInt() {		
		getHeartBtInt();		
	}		
			
	public long getHeartBtInt() { 		
		if ( hasHeartBtInt()) {		
			if (hasHeartBtInt == FixUtils.TAG_HAS_VALUE) {		
				return heartBtInt; 		
			} else {

				buf.position(hasHeartBtInt);

			heartBtInt = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasHeartBtInt = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return heartBtInt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasHeartBtInt() { return hasHeartBtInt != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setHeartBtInt(byte[] src) {		
		if (src == null ) return;
		if (hasHeartBtInt()) heartBtInt = FixUtils.TAG_HAS_NO_VALUE;		
		heartBtInt = FixUtils.longValueOf(src, 0, src.length);
		hasHeartBtInt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHeartBtInt(long src) {		
		heartBtInt = src;
		hasHeartBtInt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHeartBtInt(String str) {		
		if (str == null ) return;
		if (hasHeartBtInt()) heartBtInt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		heartBtInt = FixUtils.longValueOf(src, 0, src.length);
		hasHeartBtInt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackResetSeqNumFlag() {		
		getResetSeqNumFlag();		
	}		
			
	public boolean getResetSeqNumFlag() { 		
		if ( hasResetSeqNumFlag()) {		
			if (hasResetSeqNumFlag == FixUtils.TAG_HAS_VALUE) {		
				return resetSeqNumFlag; 		
			} else {

				buf.position(hasResetSeqNumFlag);

			resetSeqNumFlag = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasResetSeqNumFlag = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return resetSeqNumFlag;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasResetSeqNumFlag() { return hasResetSeqNumFlag != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setResetSeqNumFlag(byte[] src) {		
		if (src == null ) return;
		if (hasResetSeqNumFlag()) resetSeqNumFlag = false;		
		resetSeqNumFlag = src[0]==(byte)'Y'?true:false;		
		hasResetSeqNumFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setResetSeqNumFlag(boolean src) {		
		resetSeqNumFlag = src;
		hasResetSeqNumFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setResetSeqNumFlag(String str) {		
		if (str == null ) return;
		if (hasResetSeqNumFlag()) resetSeqNumFlag = false;		
		byte[] src = str.getBytes(); 		
		resetSeqNumFlag = src[0]==(byte)'Y'?true:false;		
		hasResetSeqNumFlag = FixUtils.TAG_HAS_VALUE;		
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
		if (standardHeader.hasMsgSeqNum()) s += "MsgSeqNum(34)= " + standardHeader.getMsgSeqNum() + "\n" ; 
		if (standardHeader.hasPossDupFlag()) s += "PossDupFlag(43)= " + standardHeader.getPossDupFlag() + "\n" ; 
		if (standardHeader.hasSenderCompID()) s += "SenderCompID(49)= " + new String( FixUtils.trim(standardHeader.getSenderCompID()) ) + "\n" ; 
		if (standardHeader.hasSenderSubID()) s += "SenderSubID(50)= " + new String( FixUtils.trim(standardHeader.getSenderSubID()) ) + "\n" ; 
		if (standardHeader.hasSendingTime()) s += "SendingTime(52)= " + new String( FixUtils.trim(standardHeader.getSendingTime()) ) + "\n" ; 
		if (standardHeader.hasTargetCompID()) s += "TargetCompID(56)= " + new String( FixUtils.trim(standardHeader.getTargetCompID()) ) + "\n" ; 
		if (standardHeader.hasTargetSubID()) s += "TargetSubID(57)= " + new String( FixUtils.trim(standardHeader.getTargetSubID()) ) + "\n" ; 
		if (standardHeader.hasPossResend()) s += "PossResend(97)= " + standardHeader.getPossResend() + "\n" ; 
		if (standardHeader.hasOnBehalfOfCompID()) s += "OnBehalfOfCompID(115)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfCompID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfSubID()) s += "OnBehalfOfSubID(116)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfSubID()) ) + "\n" ; 
		if (standardHeader.hasOrigSendingTime()) s += "OrigSendingTime(122)= " + new String( FixUtils.trim(standardHeader.getOrigSendingTime()) ) + "\n" ; 
		if (standardHeader.hasDeliverToCompID()) s += "DeliverToCompID(128)= " + new String( FixUtils.trim(standardHeader.getDeliverToCompID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToSubID()) s += "DeliverToSubID(129)= " + new String( FixUtils.trim(standardHeader.getDeliverToSubID()) ) + "\n" ; 

					if (hasEncryptMethod()) s += "EncryptMethod(98)= " + getEncryptMethod() + "\n" ; 
		if (hasHeartBtInt()) s += "HeartBtInt(108)= " + getHeartBtInt() + "\n" ; 
		if (hasResetSeqNumFlag()) s += "ResetSeqNumFlag(141)= " + getResetSeqNumFlag() + "\n" ; 

					if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixLogon)) return false;

		FixLogon msg = (FixLogon) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasEncryptMethod() && !msg.hasEncryptMethod()) || (!hasEncryptMethod() && msg.hasEncryptMethod())) return false;
		if (!(!hasEncryptMethod() && !msg.hasEncryptMethod()) && !(getEncryptMethod()==msg.getEncryptMethod())) return false;
		if ((hasHeartBtInt() && !msg.hasHeartBtInt()) || (!hasHeartBtInt() && msg.hasHeartBtInt())) return false;
		if (!(!hasHeartBtInt() && !msg.hasHeartBtInt()) && !(getHeartBtInt()==msg.getHeartBtInt())) return false;
		if ((hasResetSeqNumFlag() && !msg.hasResetSeqNumFlag()) || (!hasResetSeqNumFlag() && msg.hasResetSeqNumFlag())) return false;
		if (!(!hasResetSeqNumFlag() && !msg.hasResetSeqNumFlag()) && !(getResetSeqNumFlag()==msg.getResetSeqNumFlag())) return false;
		return true;
	}
	@Override
	public FixLogon clone () {
		FixLogon out = (FixLogon) FixUtils.fixMessagePool.getFixMessage(FixMessageInfo.MessageTypes.LOGON_INT);

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixLogon clone ( FixLogon out ) {
		if ( hasEncryptMethod())
			out.setEncryptMethod(getEncryptMethod());
		if ( hasHeartBtInt())
			out.setHeartBtInt(getHeartBtInt());
		if ( hasResetSeqNumFlag())
			out.setResetSeqNumFlag(getResetSeqNumFlag());
		return out;
	}

}
