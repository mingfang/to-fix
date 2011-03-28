package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixComplexEventTimes extends FixGroup {
	private short hasComplexEventStartTime;
	byte[] complexEventStartTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasComplexEventEndTime;
	byte[] complexEventEndTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixComplexEventTimes() {
		super(FixTags.COMPLEXEVENTSTARTTIME_INT);

		
		hasComplexEventStartTime = FixUtils.TAG_HAS_NO_VALUE;		
		complexEventStartTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasComplexEventEndTime = FixUtils.TAG_HAS_NO_VALUE;		
		complexEventEndTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasComplexEventStartTime()) return true;
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
            	case FixTags.COMPLEXEVENTSTARTTIME_INT:		
            		hasComplexEventStartTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.COMPLEXEVENTENDTIME_INT:		
            		hasComplexEventEndTime = (short) buf.position();		
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
		hasComplexEventStartTime = FixUtils.TAG_HAS_NO_VALUE;
		hasComplexEventEndTime = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasComplexEventStartTime()) {		
			out.put(FixTags.COMPLEXEVENTSTARTTIME);

			out.put((byte) '=');

			FixUtils.put(out,complexEventStartTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasComplexEventEndTime()) {		
			out.put(FixTags.COMPLEXEVENTENDTIME);

			out.put((byte) '=');

			FixUtils.put(out,complexEventEndTime); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasComplexEventStartTime()) {		
			FixUtils.put(out,complexEventStartTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasComplexEventEndTime()) {		
			FixUtils.put(out,complexEventEndTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getComplexEventStartTime() { 		
		if ( hasComplexEventStartTime()) {		
			if (hasComplexEventStartTime == FixUtils.TAG_HAS_VALUE) {		
				return complexEventStartTime; 		
			} else {		
		
				buf.position(hasComplexEventStartTime);		
		
			FixMessage.getTagStringValue(buf, complexEventStartTime, 0, complexEventStartTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasComplexEventStartTime);		
					return null;		
				}		
			}		
			hasComplexEventStartTime = FixUtils.TAG_HAS_VALUE;		
			return complexEventStartTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasComplexEventStartTime() { return hasComplexEventStartTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setComplexEventStartTime(byte[] src) {		
		if (src == null ) return;
		if (hasComplexEventStartTime()) FixUtils.fillSpace(complexEventStartTime);		
		FixUtils.copy(complexEventStartTime, src); 		
		hasComplexEventStartTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setComplexEventStartTime(String str) {		
		if (str == null ) return;
		if (hasComplexEventStartTime()) FixUtils.fillSpace(complexEventStartTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(complexEventStartTime, src); 		
		hasComplexEventStartTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getComplexEventEndTime() { 		
		if ( hasComplexEventEndTime()) {		
			if (hasComplexEventEndTime == FixUtils.TAG_HAS_VALUE) {		
				return complexEventEndTime; 		
			} else {		
		
				buf.position(hasComplexEventEndTime);		
		
			FixMessage.getTagStringValue(buf, complexEventEndTime, 0, complexEventEndTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasComplexEventEndTime);		
					return null;		
				}		
			}		
			hasComplexEventEndTime = FixUtils.TAG_HAS_VALUE;		
			return complexEventEndTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasComplexEventEndTime() { return hasComplexEventEndTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setComplexEventEndTime(byte[] src) {		
		if (src == null ) return;
		if (hasComplexEventEndTime()) FixUtils.fillSpace(complexEventEndTime);		
		FixUtils.copy(complexEventEndTime, src); 		
		hasComplexEventEndTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setComplexEventEndTime(String str) {		
		if (str == null ) return;
		if (hasComplexEventEndTime()) FixUtils.fillSpace(complexEventEndTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(complexEventEndTime, src); 		
		hasComplexEventEndTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasComplexEventStartTime()) s += "ComplexEventStartTime(1495)= " + new String( FixUtils.trim(getComplexEventStartTime()) ) + "\n" ; 
		if (hasComplexEventEndTime()) s += "ComplexEventEndTime(1496)= " + new String( FixUtils.trim(getComplexEventEndTime()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixComplexEventTimes)) return false;

		FixComplexEventTimes msg = (FixComplexEventTimes) o;

		if ((hasComplexEventStartTime() && !msg.hasComplexEventStartTime()) || (!hasComplexEventStartTime() && msg.hasComplexEventStartTime())) return false;
		if (!(!hasComplexEventStartTime() && !msg.hasComplexEventStartTime()) ) return false;
		if ((hasComplexEventEndTime() && !msg.hasComplexEventEndTime()) || (!hasComplexEventEndTime() && msg.hasComplexEventEndTime())) return false;
		if (!(!hasComplexEventEndTime() && !msg.hasComplexEventEndTime()) ) return false;
		return true;
	}
	public FixComplexEventTimes clone ( FixComplexEventTimes out ) {
		if ( hasComplexEventStartTime())
			out.setComplexEventStartTime(getComplexEventStartTime());
		if ( hasComplexEventEndTime())
			out.setComplexEventEndTime(getComplexEventEndTime());
		return out;
	}

}
