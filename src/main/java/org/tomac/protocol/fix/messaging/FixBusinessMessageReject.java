package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixBusinessMessageReject extends FixInMessage {
	private short hasRefSeqNum;
	long refSeqNum = 0;		
	private short hasRefMsgType;
	byte[] refMsgType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRefApplVerID;
	byte[] refApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRefApplExtID;
	long refApplExtID = 0;		
	private short hasRefCstmApplVerID;
	byte[] refCstmApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasBusinessRejectRefID;
	byte[] businessRejectRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasBusinessRejectReason;
	long businessRejectReason = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	
	public FixBusinessMessageReject() {
		super(FixMessageInfo.MessageTypes.BUSINESSMESSAGEREJECT);


		hasRefSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		hasRefMsgType = FixUtils.TAG_HAS_NO_VALUE;		
		refMsgType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRefApplVerID = FixUtils.TAG_HAS_NO_VALUE;		
		refApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRefApplExtID = FixUtils.TAG_HAS_NO_VALUE;		
		hasRefCstmApplVerID = FixUtils.TAG_HAS_NO_VALUE;		
		refCstmApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasBusinessRejectRefID = FixUtils.TAG_HAS_NO_VALUE;		
		businessRejectRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasBusinessRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.REFSEQNUM_INT:		
            		hasRefSeqNum = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.REFMSGTYPE_INT:		
            		hasRefMsgType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.REFAPPLVERID_INT:		
            		hasRefApplVerID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.REFAPPLEXTID_INT:		
            		hasRefApplExtID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.REFCSTMAPPLVERID_INT:		
            		hasRefCstmApplVerID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.BUSINESSREJECTREFID_INT:		
            		hasBusinessRejectRefID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.BUSINESSREJECTREASON_INT:		
            		hasBusinessRejectReason = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TEXT_INT:		
            		hasText = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDTEXTLEN_INT:		
            		hasEncodedTextLen = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ENCODEDTEXT_INT:		
            		hasEncodedText = (short) buf.position();		
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
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.BUSINESSMESSAGEREJECT_INT);
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
		if (!hasRefMsgType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.REFMSGTYPE_INT, FixMessageInfo.MessageTypes.BUSINESSMESSAGEREJECT_INT);
			return false;
		}
		if (!hasBusinessRejectReason()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.BUSINESSREJECTREASON_INT, FixMessageInfo.MessageTypes.BUSINESSMESSAGEREJECT_INT);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		getRefSeqNum();		
		getRefMsgType();		
		getRefApplVerID();		
		getRefApplExtID();		
		getRefCstmApplVerID();		
		getBusinessRejectRefID();		
		getBusinessRejectReason();		
		getText();		
		getEncodedTextLen();		
		getEncodedText();		
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
		if (hasRefSeqNum()) {		
			out.put(FixTags.REFSEQNUM);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)refSeqNum);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRefMsgType()) {		
			out.put(FixTags.REFMSGTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,refMsgType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRefApplVerID()) {		
			out.put(FixTags.REFAPPLVERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,refApplVerID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRefApplExtID()) {		
			out.put(FixTags.REFAPPLEXTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)refApplExtID);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRefCstmApplVerID()) {		
			out.put(FixTags.REFCSTMAPPLVERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,refCstmApplVerID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBusinessRejectRefID()) {		
			out.put(FixTags.BUSINESSREJECTREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,businessRejectRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBusinessRejectReason()) {		
			out.put(FixTags.BUSINESSREJECTREASON);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)businessRejectReason);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasText()) {		
			out.put(FixTags.TEXT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,text); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedTextLen()) {		
			out.put(FixTags.ENCODEDTEXTLEN);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)encodedTextLen);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEncodedText()) {		
			out.put(FixTags.ENCODEDTEXT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,encodedText); 		
		
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
		
		if (hasRefSeqNum()) {		
			FixUtils.put(out, (long)refSeqNum);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefMsgType()) {		
			FixUtils.put(out,refMsgType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefApplVerID()) {		
			FixUtils.put(out,refApplVerID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefApplExtID()) {		
			FixUtils.put(out, (long)refApplExtID);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefCstmApplVerID()) {		
			FixUtils.put(out,refCstmApplVerID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBusinessRejectRefID()) {		
			FixUtils.put(out,businessRejectRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBusinessRejectReason()) {		
			FixUtils.put(out, (long)businessRejectReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasText()) {		
			FixUtils.put(out,text); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedTextLen()) {		
			FixUtils.put(out, (long)encodedTextLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedText()) {		
			FixUtils.put(out,encodedText); 		
		
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
			
	public void crackRefSeqNum() {		
		getRefSeqNum();		
	}		
			
	public long getRefSeqNum() { 		
		if ( hasRefSeqNum()) {		
			if (hasRefSeqNum == FixUtils.TAG_HAS_VALUE) {		
				return refSeqNum; 		
			} else {

				buf.position(hasRefSeqNum);

			refSeqNum = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasRefSeqNum = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return refSeqNum;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRefSeqNum() { return hasRefSeqNum != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRefSeqNum(byte[] src) {		
		if (src == null ) return;
		if (hasRefSeqNum()) refSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		refSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasRefSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefSeqNum(long src) {		
		refSeqNum = src;
		hasRefSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefSeqNum(String str) {		
		if (str == null ) return;
		if (hasRefSeqNum()) refSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		refSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasRefSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRefMsgType() {		
		getRefMsgType();		
	}		
			
	public byte[] getRefMsgType() { 		
		if ( hasRefMsgType()) {		
			if (hasRefMsgType == FixUtils.TAG_HAS_VALUE) {		
				return refMsgType; 		
			} else {

				buf.position(hasRefMsgType);

			FixUtils.getTagStringValue(buf, refMsgType, 0, refMsgType.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRefMsgType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return refMsgType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefMsgType() { return hasRefMsgType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRefMsgType(byte[] src) {		
		if (src == null ) return;
		if (hasRefMsgType()) FixUtils.fillNul(refMsgType);		
		FixUtils.copy(refMsgType, src); 		
		hasRefMsgType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefMsgType(String str) {		
		if (str == null ) return;
		if (hasRefMsgType()) FixUtils.fillNul(refMsgType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refMsgType, src); 		
		hasRefMsgType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRefApplVerID() {		
		getRefApplVerID();		
	}		
			
	public byte[] getRefApplVerID() { 		
		if ( hasRefApplVerID()) {		
			if (hasRefApplVerID == FixUtils.TAG_HAS_VALUE) {		
				return refApplVerID; 		
			} else {

				buf.position(hasRefApplVerID);

			FixUtils.getTagStringValue(buf, refApplVerID, 0, refApplVerID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRefApplVerID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return refApplVerID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefApplVerID() { return hasRefApplVerID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRefApplVerID(byte[] src) {		
		if (src == null ) return;
		if (hasRefApplVerID()) FixUtils.fillNul(refApplVerID);		
		FixUtils.copy(refApplVerID, src); 		
		hasRefApplVerID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefApplVerID(String str) {		
		if (str == null ) return;
		if (hasRefApplVerID()) FixUtils.fillNul(refApplVerID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refApplVerID, src); 		
		hasRefApplVerID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRefApplExtID() {		
		getRefApplExtID();		
	}		
			
	public long getRefApplExtID() { 		
		if ( hasRefApplExtID()) {		
			if (hasRefApplExtID == FixUtils.TAG_HAS_VALUE) {		
				return refApplExtID; 		
			} else {

				buf.position(hasRefApplExtID);

			refApplExtID = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasRefApplExtID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return refApplExtID;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRefApplExtID() { return hasRefApplExtID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRefApplExtID(byte[] src) {		
		if (src == null ) return;
		if (hasRefApplExtID()) refApplExtID = FixUtils.TAG_HAS_NO_VALUE;		
		refApplExtID = FixUtils.longValueOf(src, 0, src.length);
		hasRefApplExtID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefApplExtID(long src) {		
		refApplExtID = src;
		hasRefApplExtID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefApplExtID(String str) {		
		if (str == null ) return;
		if (hasRefApplExtID()) refApplExtID = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		refApplExtID = FixUtils.longValueOf(src, 0, src.length);
		hasRefApplExtID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRefCstmApplVerID() {		
		getRefCstmApplVerID();		
	}		
			
	public byte[] getRefCstmApplVerID() { 		
		if ( hasRefCstmApplVerID()) {		
			if (hasRefCstmApplVerID == FixUtils.TAG_HAS_VALUE) {		
				return refCstmApplVerID; 		
			} else {

				buf.position(hasRefCstmApplVerID);

			FixUtils.getTagStringValue(buf, refCstmApplVerID, 0, refCstmApplVerID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRefCstmApplVerID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return refCstmApplVerID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefCstmApplVerID() { return hasRefCstmApplVerID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRefCstmApplVerID(byte[] src) {		
		if (src == null ) return;
		if (hasRefCstmApplVerID()) FixUtils.fillNul(refCstmApplVerID);		
		FixUtils.copy(refCstmApplVerID, src); 		
		hasRefCstmApplVerID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefCstmApplVerID(String str) {		
		if (str == null ) return;
		if (hasRefCstmApplVerID()) FixUtils.fillNul(refCstmApplVerID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refCstmApplVerID, src); 		
		hasRefCstmApplVerID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBusinessRejectRefID() {		
		getBusinessRejectRefID();		
	}		
			
	public byte[] getBusinessRejectRefID() { 		
		if ( hasBusinessRejectRefID()) {		
			if (hasBusinessRejectRefID == FixUtils.TAG_HAS_VALUE) {		
				return businessRejectRefID; 		
			} else {

				buf.position(hasBusinessRejectRefID);

			FixUtils.getTagStringValue(buf, businessRejectRefID, 0, businessRejectRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasBusinessRejectRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return businessRejectRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBusinessRejectRefID() { return hasBusinessRejectRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBusinessRejectRefID(byte[] src) {		
		if (src == null ) return;
		if (hasBusinessRejectRefID()) FixUtils.fillNul(businessRejectRefID);		
		FixUtils.copy(businessRejectRefID, src); 		
		hasBusinessRejectRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBusinessRejectRefID(String str) {		
		if (str == null ) return;
		if (hasBusinessRejectRefID()) FixUtils.fillNul(businessRejectRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(businessRejectRefID, src); 		
		hasBusinessRejectRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBusinessRejectReason() {		
		getBusinessRejectReason();		
	}		
			
	public long getBusinessRejectReason() { 		
		if ( hasBusinessRejectReason()) {		
			if (hasBusinessRejectReason == FixUtils.TAG_HAS_VALUE) {		
				return businessRejectReason; 		
			} else {

				buf.position(hasBusinessRejectReason);

			businessRejectReason = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasBusinessRejectReason = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return businessRejectReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBusinessRejectReason() { return hasBusinessRejectReason != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBusinessRejectReason(byte[] src) {		
		if (src == null ) return;
		if (hasBusinessRejectReason()) businessRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		businessRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasBusinessRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBusinessRejectReason(long src) {		
		businessRejectReason = src;
		hasBusinessRejectReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBusinessRejectReason(String str) {		
		if (str == null ) return;
		if (hasBusinessRejectReason()) businessRejectReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		businessRejectReason = FixUtils.longValueOf(src, 0, src.length);
		hasBusinessRejectReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackText() {		
		getText();		
	}		
			
	public byte[] getText() { 		
		if ( hasText()) {		
			if (hasText == FixUtils.TAG_HAS_VALUE) {		
				return text; 		
			} else {

				buf.position(hasText);

			FixUtils.getTagStringValue(buf, text, 0, text.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasText = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return text;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasText() { return hasText != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setText(byte[] src) {		
		if (src == null ) return;
		if (hasText()) FixUtils.fillNul(text);		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setText(String str) {		
		if (str == null ) return;
		if (hasText()) FixUtils.fillNul(text);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedTextLen() {		
		getEncodedTextLen();		
	}		
			
	public long getEncodedTextLen() { 		
		if ( hasEncodedTextLen()) {		
			if (hasEncodedTextLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedTextLen; 		
			} else {

				buf.position(hasEncodedTextLen);

			encodedTextLen = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedTextLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedTextLen() { return hasEncodedTextLen != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedTextLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedTextLen(long src) {		
		encodedTextLen = src;
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedTextLen(String str) {		
		if (str == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEncodedText() {		
		getEncodedText();		
	}		
			
	public byte[] getEncodedText() { 		
		if ( hasEncodedText()) {		
			if (hasEncodedText == FixUtils.TAG_HAS_VALUE) {		
				return encodedText; 		
			} else {

				buf.position(hasEncodedText);

			FixUtils.getTagStringValue(buf, encodedText, 0, encodedText.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEncodedText = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return encodedText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedText() { return hasEncodedText != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEncodedText(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedText()) FixUtils.fillNul(encodedText);		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedText(String str) {		
		if (str == null ) return;
		if (hasEncodedText()) FixUtils.fillNul(encodedText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
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

					if (hasRefSeqNum()) s += "RefSeqNum(45)= " + getRefSeqNum() + "\n" ; 
		if (hasRefMsgType()) s += "RefMsgType(372)= " + new String( FixUtils.trim(getRefMsgType()) ) + "\n" ; 
		if (hasRefApplVerID()) s += "RefApplVerID(1130)= " + new String( FixUtils.trim(getRefApplVerID()) ) + "\n" ; 
		if (hasRefApplExtID()) s += "RefApplExtID(1406)= " + getRefApplExtID() + "\n" ; 
		if (hasRefCstmApplVerID()) s += "RefCstmApplVerID(1131)= " + new String( FixUtils.trim(getRefCstmApplVerID()) ) + "\n" ; 
		if (hasBusinessRejectRefID()) s += "BusinessRejectRefID(379)= " + new String( FixUtils.trim(getBusinessRejectRefID()) ) + "\n" ; 
		if (hasBusinessRejectReason()) s += "BusinessRejectReason(380)= " + getBusinessRejectReason() + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixBusinessMessageReject)) return false;

		FixBusinessMessageReject msg = (FixBusinessMessageReject) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasRefSeqNum() && !msg.hasRefSeqNum()) || (!hasRefSeqNum() && msg.hasRefSeqNum())) return false;
		if (!(!hasRefSeqNum() && !msg.hasRefSeqNum()) && !(getRefSeqNum()==msg.getRefSeqNum())) return false;
		if ((hasRefMsgType() && !msg.hasRefMsgType()) || (!hasRefMsgType() && msg.hasRefMsgType())) return false;
		if (!(!hasRefMsgType() && !msg.hasRefMsgType()) && !FixUtils.equals(getRefMsgType(), msg.getRefMsgType())) return false;
		if ((hasRefApplVerID() && !msg.hasRefApplVerID()) || (!hasRefApplVerID() && msg.hasRefApplVerID())) return false;
		if (!(!hasRefApplVerID() && !msg.hasRefApplVerID()) && !FixUtils.equals(getRefApplVerID(), msg.getRefApplVerID())) return false;
		if ((hasRefApplExtID() && !msg.hasRefApplExtID()) || (!hasRefApplExtID() && msg.hasRefApplExtID())) return false;
		if (!(!hasRefApplExtID() && !msg.hasRefApplExtID()) && !(getRefApplExtID()==msg.getRefApplExtID())) return false;
		if ((hasRefCstmApplVerID() && !msg.hasRefCstmApplVerID()) || (!hasRefCstmApplVerID() && msg.hasRefCstmApplVerID())) return false;
		if (!(!hasRefCstmApplVerID() && !msg.hasRefCstmApplVerID()) && !FixUtils.equals(getRefCstmApplVerID(), msg.getRefCstmApplVerID())) return false;
		if ((hasBusinessRejectRefID() && !msg.hasBusinessRejectRefID()) || (!hasBusinessRejectRefID() && msg.hasBusinessRejectRefID())) return false;
		if (!(!hasBusinessRejectRefID() && !msg.hasBusinessRejectRefID()) && !FixUtils.equals(getBusinessRejectRefID(), msg.getBusinessRejectRefID())) return false;
		if ((hasBusinessRejectReason() && !msg.hasBusinessRejectReason()) || (!hasBusinessRejectReason() && msg.hasBusinessRejectReason())) return false;
		if (!(!hasBusinessRejectReason() && !msg.hasBusinessRejectReason()) && !(getBusinessRejectReason()==msg.getBusinessRejectReason())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	@Override
	public FixBusinessMessageReject clone () {
		FixBusinessMessageReject out = new FixBusinessMessageReject();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixBusinessMessageReject clone ( FixBusinessMessageReject out ) {
		if ( hasRefSeqNum())
			out.setRefSeqNum(getRefSeqNum());
		if ( hasRefMsgType())
			out.setRefMsgType(getRefMsgType());
		if ( hasRefApplVerID())
			out.setRefApplVerID(getRefApplVerID());
		if ( hasRefApplExtID())
			out.setRefApplExtID(getRefApplExtID());
		if ( hasRefCstmApplVerID())
			out.setRefCstmApplVerID(getRefCstmApplVerID());
		if ( hasBusinessRejectRefID())
			out.setBusinessRejectRefID(getBusinessRejectRefID());
		if ( hasBusinessRejectReason())
			out.setBusinessRejectReason(getBusinessRejectReason());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		return out;
	}

}
