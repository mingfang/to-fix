package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixDerivativeEventsGrp extends FixGroup {
	private short hasDerivativeEventType;
	long derivativeEventType = 0;		
	private short hasDerivativeEventDate;
	byte[] derivativeEventDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeEventTime;
	byte[] derivativeEventTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasDerivativeEventPx;
	long derivativeEventPx = 0;		
	private short hasDerivativeEventText;
	byte[] derivativeEventText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	
	public FixDerivativeEventsGrp() {
		this(false);
	}

	public FixDerivativeEventsGrp(boolean isRequired) {
		super(FixTags.DERIVATIVEEVENTTYPE_INT);

		this.isRequired = isRequired;
		
		hasDerivativeEventType = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeEventDate = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeEventDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeEventTime = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeEventTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasDerivativeEventPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeEventText = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeEventText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasDerivativeEventType()) return true;
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
            	case FixTags.DERIVATIVEEVENTTYPE_INT:		
            		hasDerivativeEventType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEEVENTDATE_INT:		
            		hasDerivativeEventDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEEVENTTIME_INT:		
            		hasDerivativeEventTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEEVENTPX_INT:		
            		hasDerivativeEventPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEEVENTTEXT_INT:		
            		hasDerivativeEventText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

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
		hasDerivativeEventType = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeEventDate = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeEventTime = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeEventPx = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeEventText = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasDerivativeEventType()) {		
			out.put(FixTags.DERIVATIVEEVENTTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeEventType);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeEventDate()) {		
			out.put(FixTags.DERIVATIVEEVENTDATE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeEventDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeEventTime()) {		
			out.put(FixTags.DERIVATIVEEVENTTIME);

			out.put((byte) '=');

			FixUtils.put(out,derivativeEventTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeEventPx()) {		
			out.put(FixTags.DERIVATIVEEVENTPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeEventPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeEventText()) {		
			out.put(FixTags.DERIVATIVEEVENTTEXT);

			out.put((byte) '=');

			FixUtils.put(out,derivativeEventText); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasDerivativeEventType()) {		
			FixUtils.put(out, (long)derivativeEventType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeEventDate()) {		
			FixUtils.put(out,derivativeEventDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeEventTime()) {		
			FixUtils.put(out,derivativeEventTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeEventPx()) {		
			FixUtils.put(out, (long)derivativeEventPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeEventText()) {		
			FixUtils.put(out,derivativeEventText); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getDerivativeEventType() { 		
		if ( hasDerivativeEventType()) {		
			if (hasDerivativeEventType == FixUtils.TAG_HAS_VALUE) {		
				return derivativeEventType; 		
			} else {		
		
				buf.position(hasDerivativeEventType);		
		
			derivativeEventType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeEventType);		
					return 0;		
				}		
			}		
			hasDerivativeEventType = FixUtils.TAG_HAS_VALUE;		
			return derivativeEventType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeEventType() { return hasDerivativeEventType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeEventType(long src) {		
		derivativeEventType = src;
		hasDerivativeEventType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeEventType(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeEventType()) derivativeEventType = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeEventType = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeEventType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeEventType(String str) {		
		if (str == null ) return;
		if (hasDerivativeEventType()) derivativeEventType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeEventType = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeEventType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeEventDate() { 		
		if ( hasDerivativeEventDate()) {		
			if (hasDerivativeEventDate == FixUtils.TAG_HAS_VALUE) {		
				return derivativeEventDate; 		
			} else {		
		
				buf.position(hasDerivativeEventDate);		
		
			FixMessage.getTagStringValue(buf, derivativeEventDate, 0, derivativeEventDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeEventDate);		
					return null;		
				}		
			}		
			hasDerivativeEventDate = FixUtils.TAG_HAS_VALUE;		
			return derivativeEventDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeEventDate() { return hasDerivativeEventDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeEventDate(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeEventDate()) FixUtils.fillNul(derivativeEventDate);		
		FixUtils.copy(derivativeEventDate, src); 		
		hasDerivativeEventDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeEventDate(String str) {		
		if (str == null ) return;
		if (hasDerivativeEventDate()) FixUtils.fillNul(derivativeEventDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeEventDate, src); 		
		hasDerivativeEventDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeEventTime() { 		
		if ( hasDerivativeEventTime()) {		
			if (hasDerivativeEventTime == FixUtils.TAG_HAS_VALUE) {		
				return derivativeEventTime; 		
			} else {		
		
				buf.position(hasDerivativeEventTime);		
		
			FixMessage.getTagStringValue(buf, derivativeEventTime, 0, derivativeEventTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeEventTime);		
					return null;		
				}		
			}		
			hasDerivativeEventTime = FixUtils.TAG_HAS_VALUE;		
			return derivativeEventTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeEventTime() { return hasDerivativeEventTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeEventTime(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeEventTime()) FixUtils.fillNul(derivativeEventTime);		
		FixUtils.copy(derivativeEventTime, src); 		
		hasDerivativeEventTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeEventTime(String str) {		
		if (str == null ) return;
		if (hasDerivativeEventTime()) FixUtils.fillNul(derivativeEventTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeEventTime, src); 		
		hasDerivativeEventTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeEventPx() { 		
		if ( hasDerivativeEventPx()) {		
			if (hasDerivativeEventPx == FixUtils.TAG_HAS_VALUE) {		
				return derivativeEventPx; 		
			} else {		
		
				buf.position(hasDerivativeEventPx);		
		
			derivativeEventPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeEventPx);		
					return 0;		
				}		
			}		
			hasDerivativeEventPx = FixUtils.TAG_HAS_VALUE;		
			return derivativeEventPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeEventPx() { return hasDerivativeEventPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeEventPx(long src) {		
		derivativeEventPx = src;
		hasDerivativeEventPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeEventPx(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeEventPx()) derivativeEventPx = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeEventPx = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeEventPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeEventPx(String str) {		
		if (str == null ) return;
		if (hasDerivativeEventPx()) derivativeEventPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeEventPx = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeEventPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeEventText() { 		
		if ( hasDerivativeEventText()) {		
			if (hasDerivativeEventText == FixUtils.TAG_HAS_VALUE) {		
				return derivativeEventText; 		
			} else {		
		
				buf.position(hasDerivativeEventText);		
		
			FixMessage.getTagStringValue(buf, derivativeEventText, 0, derivativeEventText.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeEventText);		
					return null;		
				}		
			}		
			hasDerivativeEventText = FixUtils.TAG_HAS_VALUE;		
			return derivativeEventText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeEventText() { return hasDerivativeEventText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeEventText(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeEventText()) FixUtils.fillNul(derivativeEventText);		
		FixUtils.copy(derivativeEventText, src); 		
		hasDerivativeEventText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeEventText(String str) {		
		if (str == null ) return;
		if (hasDerivativeEventText()) FixUtils.fillNul(derivativeEventText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeEventText, src); 		
		hasDerivativeEventText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasDerivativeEventType()) s += "DerivativeEventType(1287)= " + getDerivativeEventType() + "\n" ; 
		if (hasDerivativeEventDate()) s += "DerivativeEventDate(1288)= " + new String( FixUtils.trim(getDerivativeEventDate()) ) + "\n" ; 
		if (hasDerivativeEventTime()) s += "DerivativeEventTime(1289)= " + new String( FixUtils.trim(getDerivativeEventTime()) ) + "\n" ; 
		if (hasDerivativeEventPx()) s += "DerivativeEventPx(1290)= " + getDerivativeEventPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDerivativeEventText()) s += "DerivativeEventText(1291)= " + new String( FixUtils.trim(getDerivativeEventText()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDerivativeEventsGrp)) return false;

		FixDerivativeEventsGrp msg = (FixDerivativeEventsGrp) o;

		if ((hasDerivativeEventType() && !msg.hasDerivativeEventType()) || (!hasDerivativeEventType() && msg.hasDerivativeEventType())) return false;
		if (!(!hasDerivativeEventType() && !msg.hasDerivativeEventType()) && !(getDerivativeEventType()==msg.getDerivativeEventType())) return false;
		if ((hasDerivativeEventDate() && !msg.hasDerivativeEventDate()) || (!hasDerivativeEventDate() && msg.hasDerivativeEventDate())) return false;
		if ((hasDerivativeEventTime() && !msg.hasDerivativeEventTime()) || (!hasDerivativeEventTime() && msg.hasDerivativeEventTime())) return false;
		if ((hasDerivativeEventPx() && !msg.hasDerivativeEventPx()) || (!hasDerivativeEventPx() && msg.hasDerivativeEventPx())) return false;
		if (!(!hasDerivativeEventPx() && !msg.hasDerivativeEventPx()) && !(getDerivativeEventPx()==msg.getDerivativeEventPx())) return false;
		if ((hasDerivativeEventText() && !msg.hasDerivativeEventText()) || (!hasDerivativeEventText() && msg.hasDerivativeEventText())) return false;
		if (!(!hasDerivativeEventText() && !msg.hasDerivativeEventText()) && !FixUtils.equals(getDerivativeEventText(), msg.getDerivativeEventText())) return false;
		return true;
	}
	public FixDerivativeEventsGrp clone ( FixDerivativeEventsGrp out ) {
		if ( hasDerivativeEventType())
			out.setDerivativeEventType(getDerivativeEventType());
		if ( hasDerivativeEventDate())
			out.setDerivativeEventDate(getDerivativeEventDate());
		if ( hasDerivativeEventTime())
			out.setDerivativeEventTime(getDerivativeEventTime());
		if ( hasDerivativeEventPx())
			out.setDerivativeEventPx(getDerivativeEventPx());
		if ( hasDerivativeEventText())
			out.setDerivativeEventText(getDerivativeEventText());
		return out;
	}

}
