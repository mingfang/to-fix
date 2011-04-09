package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixListStrikePrice extends FixInMessage {
	private short hasListID;
	byte[] listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTotNoStrikes;
	long totNoStrikes = 0;		
	private short hasLastFragment;
		boolean lastFragment = false;		
	public FixInstrmtStrkPxGrp[] instrmtStrkPxGrp;
	
	public FixListStrikePrice() {
		super(FixMessageInfo.MessageTypes.LISTSTRIKEPRICE);


		hasListID = FixUtils.TAG_HAS_NO_VALUE;		
		listID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTotNoStrikes = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastFragment = FixUtils.TAG_HAS_NO_VALUE;		
		instrmtStrkPxGrp = new FixInstrmtStrkPxGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtStrkPxGrp[i] = new FixInstrmtStrkPxGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.LISTID_INT:		
            		hasListID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TOTNOSTRIKES_INT:		
            		hasTotNoStrikes = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LASTFRAGMENT_INT:		
            		hasLastFragment = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	default:
        			if ( standardHeader.isKeyTag(tag)) {
        				tag = standardHeader.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( standardTrailer.isKeyTag(tag)) {
        				tag = standardTrailer.setBuffer( tag, buf, err);
        				FixUtils.unreadLastTag(tag, buf);
        				if (!err.hasError()) hasRequiredTags(err);
            			return; // always last, we are done now
        			} else if ( tag == FixTags.NOSTRIKES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtStrkPxGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOSTRIKES_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = instrmtStrkPxGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.LISTSTRIKEPRICE_INT);
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
		if (!hasListID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.LISTID_INT, FixMessageInfo.MessageTypes.LISTSTRIKEPRICE_INT);
			return false;
		}
		if (!hasTotNoStrikes()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TOTNOSTRIKES_INT, FixMessageInfo.MessageTypes.LISTSTRIKEPRICE_INT);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (instrmtStrkPxGrp[i].hasGroup()) instrmtStrkPxGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		return true;
	}
	@Override		
	public void getAll() {		
		getListID();		
		getTotNoStrikes();		
		getLastFragment();		
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
		if (hasListID()) {		
			out.put(FixTags.LISTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,listID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTotNoStrikes()) {		
			out.put(FixTags.TOTNOSTRIKES);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)totNoStrikes);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLastFragment()) {		
			out.put(FixTags.LASTFRAGMENT);		
		
			out.put((byte) '=');		
		
			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(instrmtStrkPxGrp)>0) {
			out.put(FixTags.NOSTRIKES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtStrkPxGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtStrkPxGrp fixInstrmtStrkPxGrp : instrmtStrkPxGrp) if (fixInstrmtStrkPxGrp.hasGroup()) fixInstrmtStrkPxGrp.encode(out);
		
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
		
		if (hasListID()) {		
			FixUtils.put(out,listID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNoStrikes()) {		
			FixUtils.put(out, (long)totNoStrikes);
		
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
			
	public void crackListID() {		
		getListID();		
	}		
			
	public byte[] getListID() { 		
		if ( hasListID()) {		
			if (hasListID == FixUtils.TAG_HAS_VALUE) {		
				return listID; 		
			} else {

				buf.position(hasListID);

			FixUtils.getTagStringValue(buf, listID, 0, listID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasListID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return listID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasListID() { return hasListID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setListID(byte[] src) {		
		if (src == null ) return;
		if (hasListID()) FixUtils.fillNul(listID);		
		FixUtils.copy(listID, src); 		
		hasListID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListID(String str) {		
		if (str == null ) return;
		if (hasListID()) FixUtils.fillNul(listID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(listID, src); 		
		hasListID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTotNoStrikes() {		
		getTotNoStrikes();		
	}		
			
	public long getTotNoStrikes() { 		
		if ( hasTotNoStrikes()) {		
			if (hasTotNoStrikes == FixUtils.TAG_HAS_VALUE) {		
				return totNoStrikes; 		
			} else {

				buf.position(hasTotNoStrikes);

			totNoStrikes = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTotNoStrikes = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return totNoStrikes;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNoStrikes() { return hasTotNoStrikes != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTotNoStrikes(byte[] src) {		
		if (src == null ) return;
		if (hasTotNoStrikes()) totNoStrikes = FixUtils.TAG_HAS_NO_VALUE;		
		totNoStrikes = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoStrikes = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoStrikes(long src) {		
		totNoStrikes = src;
		hasTotNoStrikes = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoStrikes(String str) {		
		if (str == null ) return;
		if (hasTotNoStrikes()) totNoStrikes = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNoStrikes = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoStrikes = FixUtils.TAG_HAS_VALUE;		
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

			lastFragment = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
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

					if (hasListID()) s += "ListID(66)= " + new String( FixUtils.trim(getListID()) ) + "\n" ; 
		if (hasTotNoStrikes()) s += "TotNoStrikes(422)= " + getTotNoStrikes() + "\n" ; 
		if (hasLastFragment()) s += "LastFragment(893)= " + getLastFragment() + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixListStrikePrice)) return false;

		FixListStrikePrice msg = (FixListStrikePrice) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasListID() && !msg.hasListID()) || (!hasListID() && msg.hasListID())) return false;
		if (!(!hasListID() && !msg.hasListID()) && !FixUtils.equals(getListID(), msg.getListID())) return false;
		if ((hasTotNoStrikes() && !msg.hasTotNoStrikes()) || (!hasTotNoStrikes() && msg.hasTotNoStrikes())) return false;
		if (!(!hasTotNoStrikes() && !msg.hasTotNoStrikes()) && !(getTotNoStrikes()==msg.getTotNoStrikes())) return false;
		if ((hasLastFragment() && !msg.hasLastFragment()) || (!hasLastFragment() && msg.hasLastFragment())) return false;
		if (!(!hasLastFragment() && !msg.hasLastFragment()) && !(getLastFragment()==msg.getLastFragment())) return false;
		return true;
	}
	@Override
	public FixListStrikePrice clone () {
		FixListStrikePrice out = new FixListStrikePrice();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixListStrikePrice clone ( FixListStrikePrice out ) {
		if ( hasListID())
			out.setListID(getListID());
		if ( hasTotNoStrikes())
			out.setTotNoStrikes(getTotNoStrikes());
		if ( hasLastFragment())
			out.setLastFragment(getLastFragment());
		int count = 0;
		count = 0;
		for (FixInstrmtStrkPxGrp fixInstrmtStrkPxGrp : instrmtStrkPxGrp) {
			if (!fixInstrmtStrkPxGrp.hasGroup()) continue;
			out.instrmtStrkPxGrp[count] = fixInstrmtStrkPxGrp.clone( out.instrmtStrkPxGrp[count] );
			count++;
		}
		return out;
	}

}
