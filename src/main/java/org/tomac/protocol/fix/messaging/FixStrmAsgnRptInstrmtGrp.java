package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixStrmAsgnRptInstrmtGrp extends FixGroup {
	private short hasSettlType;
	byte[] settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasStreamAsgnType;
	long streamAsgnType = 0;		
	private short hasMDStreamID;
	byte[] mDStreamID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasStreamAsgnRejReason;
	long streamAsgnRejReason = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		public FixInstrument instrument;
	
	public FixStrmAsgnRptInstrmtGrp() {
		this(false);
	}

	public FixStrmAsgnRptInstrmtGrp(boolean isRequired) {
		super(FixTags.SYMBOL_INT);

		this.isRequired = isRequired;
		
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasStreamAsgnType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDStreamID = FixUtils.TAG_HAS_NO_VALUE;		
		mDStreamID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasStreamAsgnRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		instrument = new FixInstrument();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (instrument.hasGroup()) return true;
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
            	case FixTags.SETTLTYPE_INT:		
            		hasSettlType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STREAMASGNTYPE_INT:		
            		hasStreamAsgnType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDSTREAMID_INT:		
            		hasMDStreamID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STREAMASGNREJREASON_INT:		
            		hasStreamAsgnRejReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TEXT_INT:		
            		hasText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDTEXTLEN_INT:		
            		hasEncodedTextLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDTEXT_INT:		
            		hasEncodedText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
            		} else { return tag; }
            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
            if (isKeyTag(tag)) return tag; // next in repeating group
        }		
        return tag;
    }		
	public boolean hasRequiredTags(FixValidationError err) {
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;
		hasStreamAsgnType = FixUtils.TAG_HAS_NO_VALUE;
		hasMDStreamID = FixUtils.TAG_HAS_NO_VALUE;
		hasStreamAsgnRejReason = FixUtils.TAG_HAS_NO_VALUE;
		hasText = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;
		instrument.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSettlType()) {		
			out.put(FixTags.SETTLTYPE);

			out.put((byte) '=');

			FixUtils.put(out,settlType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasStreamAsgnType()) {		
			out.put(FixTags.STREAMASGNTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)streamAsgnType);
		
			out.put(FixUtils.SOH);

            }

		if (hasMDStreamID()) {		
			out.put(FixTags.MDSTREAMID);

			out.put((byte) '=');

			FixUtils.put(out,mDStreamID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasStreamAsgnRejReason()) {		
			out.put(FixTags.STREAMASGNREJREASON);

			out.put((byte) '=');

			FixUtils.put(out, (long)streamAsgnRejReason);
		
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

		instrument.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSettlType()) {		
			FixUtils.put(out,settlType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStreamAsgnType()) {		
			FixUtils.put(out, (long)streamAsgnType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDStreamID()) {		
			FixUtils.put(out,mDStreamID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStreamAsgnRejReason()) {		
			FixUtils.put(out, (long)streamAsgnRejReason);
		
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
		
		instrument.printBuffer(out);
	}

	public byte[] getSettlType() { 		
		if ( hasSettlType()) {		
			if (hasSettlType == FixUtils.TAG_HAS_VALUE) {		
				return settlType; 		
			} else {		
		
				buf.position(hasSettlType);		
		
			FixMessage.getTagStringValue(buf, settlType, 0, settlType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlType);		
					return null;		
				}		
			}		
			hasSettlType = FixUtils.TAG_HAS_VALUE;		
			return settlType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlType() { return hasSettlType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlType(byte[] src) {		
		if (src == null ) return;
		if (hasSettlType()) FixUtils.fillSpace(settlType);		
		FixUtils.copy(settlType, src); 		
		hasSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlType(String str) {		
		if (str == null ) return;
		if (hasSettlType()) FixUtils.fillSpace(settlType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlType, src); 		
		hasSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStreamAsgnType() { 		
		if ( hasStreamAsgnType()) {		
			if (hasStreamAsgnType == FixUtils.TAG_HAS_VALUE) {		
				return streamAsgnType; 		
			} else {		
		
				buf.position(hasStreamAsgnType);		
		
			streamAsgnType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStreamAsgnType);		
					return 0;		
				}		
			}		
			hasStreamAsgnType = FixUtils.TAG_HAS_VALUE;		
			return streamAsgnType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStreamAsgnType() { return hasStreamAsgnType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStreamAsgnType(long src) {		
		streamAsgnType = src;
		hasStreamAsgnType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStreamAsgnType(byte[] src) {		
		if (src == null ) return;
		if (hasStreamAsgnType()) streamAsgnType = FixUtils.TAG_HAS_NO_VALUE;		
		streamAsgnType = FixUtils.longValueOf(src, 0, src.length);
		hasStreamAsgnType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStreamAsgnType(String str) {		
		if (str == null ) return;
		if (hasStreamAsgnType()) streamAsgnType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		streamAsgnType = FixUtils.longValueOf(src, 0, src.length);
		hasStreamAsgnType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMDStreamID() { 		
		if ( hasMDStreamID()) {		
			if (hasMDStreamID == FixUtils.TAG_HAS_VALUE) {		
				return mDStreamID; 		
			} else {		
		
				buf.position(hasMDStreamID);		
		
			FixMessage.getTagStringValue(buf, mDStreamID, 0, mDStreamID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDStreamID);		
					return null;		
				}		
			}		
			hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
			return mDStreamID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDStreamID() { return hasMDStreamID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDStreamID(byte[] src) {		
		if (src == null ) return;
		if (hasMDStreamID()) FixUtils.fillSpace(mDStreamID);		
		FixUtils.copy(mDStreamID, src); 		
		hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDStreamID(String str) {		
		if (str == null ) return;
		if (hasMDStreamID()) FixUtils.fillSpace(mDStreamID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDStreamID, src); 		
		hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStreamAsgnRejReason() { 		
		if ( hasStreamAsgnRejReason()) {		
			if (hasStreamAsgnRejReason == FixUtils.TAG_HAS_VALUE) {		
				return streamAsgnRejReason; 		
			} else {		
		
				buf.position(hasStreamAsgnRejReason);		
		
			streamAsgnRejReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStreamAsgnRejReason);		
					return 0;		
				}		
			}		
			hasStreamAsgnRejReason = FixUtils.TAG_HAS_VALUE;		
			return streamAsgnRejReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStreamAsgnRejReason() { return hasStreamAsgnRejReason != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStreamAsgnRejReason(long src) {		
		streamAsgnRejReason = src;
		hasStreamAsgnRejReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStreamAsgnRejReason(byte[] src) {		
		if (src == null ) return;
		if (hasStreamAsgnRejReason()) streamAsgnRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		streamAsgnRejReason = FixUtils.longValueOf(src, 0, src.length);
		hasStreamAsgnRejReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStreamAsgnRejReason(String str) {		
		if (str == null ) return;
		if (hasStreamAsgnRejReason()) streamAsgnRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		streamAsgnRejReason = FixUtils.longValueOf(src, 0, src.length);
		hasStreamAsgnRejReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getText() { 		
		if ( hasText()) {		
			if (hasText == FixUtils.TAG_HAS_VALUE) {		
				return text; 		
			} else {		
		
				buf.position(hasText);		
		
			FixMessage.getTagStringValue(buf, text, 0, text.length, err);
		
				if (err.hasError()) {		
					buf.position(hasText);		
					return null;		
				}		
			}		
			hasText = FixUtils.TAG_HAS_VALUE;		
			return text;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasText() { return hasText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setText(byte[] src) {		
		if (src == null ) return;
		if (hasText()) FixUtils.fillSpace(text);		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setText(String str) {		
		if (str == null ) return;
		if (hasText()) FixUtils.fillSpace(text);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEncodedTextLen() { 		
		if ( hasEncodedTextLen()) {		
			if (hasEncodedTextLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedTextLen; 		
			} else {		
		
				buf.position(hasEncodedTextLen);		
		
			encodedTextLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedTextLen);		
					return 0;		
				}		
			}		
			hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
			return encodedTextLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedTextLen() { return hasEncodedTextLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedTextLen(long src) {		
		encodedTextLen = src;
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedTextLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedTextLen(String str) {		
		if (str == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedText() { 		
		if ( hasEncodedText()) {		
			if (hasEncodedText == FixUtils.TAG_HAS_VALUE) {		
				return encodedText; 		
			} else {		
		
				buf.position(hasEncodedText);		
		
			FixMessage.getTagStringValue(buf, encodedText, 0, encodedText.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedText);		
					return null;		
				}		
			}		
			hasEncodedText = FixUtils.TAG_HAS_VALUE;		
			return encodedText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedText() { return hasEncodedText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedText(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedText()) FixUtils.fillSpace(encodedText);		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedText(String str) {		
		if (str == null ) return;
		if (hasEncodedText()) FixUtils.fillSpace(encodedText);		
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
				if (hasSettlType()) s += "SettlType(63)= " + new String( FixUtils.trim(getSettlType()) ) + "\n" ; 
		if (hasStreamAsgnType()) s += "StreamAsgnType(1617)= " + getStreamAsgnType() + "\n" ; 
		if (hasMDStreamID()) s += "MDStreamID(1500)= " + new String( FixUtils.trim(getMDStreamID()) ) + "\n" ; 
		if (hasStreamAsgnRejReason()) s += "StreamAsgnRejReason(1502)= " + getStreamAsgnRejReason() + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 

		s += instrument.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStrmAsgnRptInstrmtGrp)) return false;

		FixStrmAsgnRptInstrmtGrp msg = (FixStrmAsgnRptInstrmtGrp) o;

		if (!instrument.equals(msg.instrument)) return false;
		if ((hasSettlType() && !msg.hasSettlType()) || (!hasSettlType() && msg.hasSettlType())) return false;
		if (!(!hasSettlType() && !msg.hasSettlType()) && !FixUtils.equals(getSettlType(), msg.getSettlType())) return false;
		if ((hasStreamAsgnType() && !msg.hasStreamAsgnType()) || (!hasStreamAsgnType() && msg.hasStreamAsgnType())) return false;
		if (!(!hasStreamAsgnType() && !msg.hasStreamAsgnType()) && !(getStreamAsgnType()==msg.getStreamAsgnType())) return false;
		if ((hasMDStreamID() && !msg.hasMDStreamID()) || (!hasMDStreamID() && msg.hasMDStreamID())) return false;
		if (!(!hasMDStreamID() && !msg.hasMDStreamID()) && !FixUtils.equals(getMDStreamID(), msg.getMDStreamID())) return false;
		if ((hasStreamAsgnRejReason() && !msg.hasStreamAsgnRejReason()) || (!hasStreamAsgnRejReason() && msg.hasStreamAsgnRejReason())) return false;
		if (!(!hasStreamAsgnRejReason() && !msg.hasStreamAsgnRejReason()) && !(getStreamAsgnRejReason()==msg.getStreamAsgnRejReason())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	public FixStrmAsgnRptInstrmtGrp clone ( FixStrmAsgnRptInstrmtGrp out ) {
		if ( hasSettlType())
			out.setSettlType(getSettlType());
		if ( hasStreamAsgnType())
			out.setStreamAsgnType(getStreamAsgnType());
		if ( hasMDStreamID())
			out.setMDStreamID(getMDStreamID());
		if ( hasStreamAsgnRejReason())
			out.setStreamAsgnRejReason(getStreamAsgnRejReason());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		return out;
	}

}
