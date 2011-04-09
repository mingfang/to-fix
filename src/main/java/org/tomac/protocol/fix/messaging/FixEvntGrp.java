package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixEvntGrp extends FixGroup {
	private short hasEventType;
	long eventType = 0;		
	private short hasEventDate;
	byte[] eventDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEventTime;
	byte[] eventTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasEventPx;
	long eventPx = 0;		
	private short hasEventText;
	byte[] eventText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	
	public FixEvntGrp() {
		this(false);
	}

	public FixEvntGrp(boolean isRequired) {
		super(FixTags.EVENTTYPE_INT);

		this.isRequired = isRequired;
		
		hasEventType = FixUtils.TAG_HAS_NO_VALUE;		
		hasEventDate = FixUtils.TAG_HAS_NO_VALUE;		
		eventDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEventTime = FixUtils.TAG_HAS_NO_VALUE;		
		eventTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasEventPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasEventText = FixUtils.TAG_HAS_NO_VALUE;		
		eventText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasEventType()) return true;
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
            	case FixTags.EVENTTYPE_INT:		
            		hasEventType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.EVENTDATE_INT:		
            		hasEventDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.EVENTTIME_INT:		
            		hasEventTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.EVENTPX_INT:		
            		hasEventPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.EVENTTEXT_INT:		
            		hasEventText = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

            }

            tag = FixUtils.getTag(buf, err);
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
		hasEventType = FixUtils.TAG_HAS_NO_VALUE;
		hasEventDate = FixUtils.TAG_HAS_NO_VALUE;
		hasEventTime = FixUtils.TAG_HAS_NO_VALUE;
		hasEventPx = FixUtils.TAG_HAS_NO_VALUE;
		hasEventText = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasEventType()) {		
			out.put(FixTags.EVENTTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)eventType);
		
			out.put(FixUtils.SOH);

            }

		if (hasEventDate()) {		
			out.put(FixTags.EVENTDATE);

			out.put((byte) '=');

			FixUtils.put(out,eventDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEventTime()) {		
			out.put(FixTags.EVENTTIME);

			out.put((byte) '=');

			FixUtils.put(out,eventTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEventPx()) {		
			out.put(FixTags.EVENTPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)eventPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasEventText()) {		
			out.put(FixTags.EVENTTEXT);

			out.put((byte) '=');

			FixUtils.put(out,eventText); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasEventType()) {		
			FixUtils.put(out, (long)eventType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEventDate()) {		
			FixUtils.put(out,eventDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEventTime()) {		
			FixUtils.put(out,eventTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEventPx()) {		
			FixUtils.put(out, (long)eventPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEventText()) {		
			FixUtils.put(out,eventText); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getEventType() { 		
		if ( hasEventType()) {		
			if (hasEventType == FixUtils.TAG_HAS_VALUE) {		
				return eventType; 		
			} else {		
		
				buf.position(hasEventType);		
		
			eventType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEventType);		
					return 0;		
				}		
			}		
			hasEventType = FixUtils.TAG_HAS_VALUE;		
			return eventType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEventType() { return hasEventType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEventType(long src) {		
		eventType = src;
		hasEventType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEventType(byte[] src) {		
		if (src == null ) return;
		if (hasEventType()) eventType = FixUtils.TAG_HAS_NO_VALUE;		
		eventType = FixUtils.longValueOf(src, 0, src.length);
		hasEventType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEventType(String str) {		
		if (str == null ) return;
		if (hasEventType()) eventType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		eventType = FixUtils.longValueOf(src, 0, src.length);
		hasEventType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEventDate() { 		
		if ( hasEventDate()) {		
			if (hasEventDate == FixUtils.TAG_HAS_VALUE) {		
				return eventDate; 		
			} else {		
		
				buf.position(hasEventDate);		
		
			FixUtils.getTagStringValue(buf, eventDate, 0, eventDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEventDate);		
					return null;		
				}		
			}		
			hasEventDate = FixUtils.TAG_HAS_VALUE;		
			return eventDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEventDate() { return hasEventDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEventDate(byte[] src) {		
		if (src == null ) return;
		if (hasEventDate()) FixUtils.fillNul(eventDate);		
		FixUtils.copy(eventDate, src); 		
		hasEventDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEventDate(String str) {		
		if (str == null ) return;
		if (hasEventDate()) FixUtils.fillNul(eventDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(eventDate, src); 		
		hasEventDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEventTime() { 		
		if ( hasEventTime()) {		
			if (hasEventTime == FixUtils.TAG_HAS_VALUE) {		
				return eventTime; 		
			} else {		
		
				buf.position(hasEventTime);		
		
			FixUtils.getTagStringValue(buf, eventTime, 0, eventTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEventTime);		
					return null;		
				}		
			}		
			hasEventTime = FixUtils.TAG_HAS_VALUE;		
			return eventTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEventTime() { return hasEventTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEventTime(byte[] src) {		
		if (src == null ) return;
		if (hasEventTime()) FixUtils.fillNul(eventTime);		
		FixUtils.copy(eventTime, src); 		
		hasEventTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEventTime(String str) {		
		if (str == null ) return;
		if (hasEventTime()) FixUtils.fillNul(eventTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(eventTime, src); 		
		hasEventTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEventPx() { 		
		if ( hasEventPx()) {		
			if (hasEventPx == FixUtils.TAG_HAS_VALUE) {		
				return eventPx; 		
			} else {		
		
				buf.position(hasEventPx);		
		
			eventPx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEventPx);		
					return 0;		
				}		
			}		
			hasEventPx = FixUtils.TAG_HAS_VALUE;		
			return eventPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEventPx() { return hasEventPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEventPx(long src) {		
		eventPx = src;
		hasEventPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEventPx(byte[] src) {		
		if (src == null ) return;
		if (hasEventPx()) eventPx = FixUtils.TAG_HAS_NO_VALUE;		
		eventPx = FixUtils.longValueOf(src, 0, src.length);
		hasEventPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEventPx(String str) {		
		if (str == null ) return;
		if (hasEventPx()) eventPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		eventPx = FixUtils.longValueOf(src, 0, src.length);
		hasEventPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEventText() { 		
		if ( hasEventText()) {		
			if (hasEventText == FixUtils.TAG_HAS_VALUE) {		
				return eventText; 		
			} else {		
		
				buf.position(hasEventText);		
		
			FixUtils.getTagStringValue(buf, eventText, 0, eventText.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEventText);		
					return null;		
				}		
			}		
			hasEventText = FixUtils.TAG_HAS_VALUE;		
			return eventText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEventText() { return hasEventText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEventText(byte[] src) {		
		if (src == null ) return;
		if (hasEventText()) FixUtils.fillNul(eventText);		
		FixUtils.copy(eventText, src); 		
		hasEventText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEventText(String str) {		
		if (str == null ) return;
		if (hasEventText()) FixUtils.fillNul(eventText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(eventText, src); 		
		hasEventText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasEventType()) s += "EventType(865)= " + getEventType() + "\n" ; 
		if (hasEventDate()) s += "EventDate(866)= " + new String( FixUtils.trim(getEventDate()) ) + "\n" ; 
		if (hasEventTime()) s += "EventTime(1145)= " + new String( FixUtils.trim(getEventTime()) ) + "\n" ; 
		if (hasEventPx()) s += "EventPx(867)= " + getEventPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasEventText()) s += "EventText(868)= " + new String( FixUtils.trim(getEventText()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixEvntGrp)) return false;

		FixEvntGrp msg = (FixEvntGrp) o;

		if ((hasEventType() && !msg.hasEventType()) || (!hasEventType() && msg.hasEventType())) return false;
		if (!(!hasEventType() && !msg.hasEventType()) && !(getEventType()==msg.getEventType())) return false;
		if ((hasEventDate() && !msg.hasEventDate()) || (!hasEventDate() && msg.hasEventDate())) return false;
		if ((hasEventTime() && !msg.hasEventTime()) || (!hasEventTime() && msg.hasEventTime())) return false;
		if ((hasEventPx() && !msg.hasEventPx()) || (!hasEventPx() && msg.hasEventPx())) return false;
		if (!(!hasEventPx() && !msg.hasEventPx()) && !(getEventPx()==msg.getEventPx())) return false;
		if ((hasEventText() && !msg.hasEventText()) || (!hasEventText() && msg.hasEventText())) return false;
		if (!(!hasEventText() && !msg.hasEventText()) && !FixUtils.equals(getEventText(), msg.getEventText())) return false;
		return true;
	}
	public FixEvntGrp clone ( FixEvntGrp out ) {
		if ( hasEventType())
			out.setEventType(getEventType());
		if ( hasEventDate())
			out.setEventDate(getEventDate());
		if ( hasEventTime())
			out.setEventTime(getEventTime());
		if ( hasEventPx())
			out.setEventPx(getEventPx());
		if ( hasEventText())
			out.setEventText(getEventText());
		return out;
	}

}
