package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTimeInForceRules extends FixGroup {
	private short hasTimeInForce;
	byte timeInForce = (byte)' ';		
	
	public FixTimeInForceRules() {
		this(false);
	}

	public FixTimeInForceRules(boolean isRequired) {
		super(FixTags.TIMEINFORCE_INT);

		this.isRequired = isRequired;
		
		hasTimeInForce = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasTimeInForce()) return true;
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
            	case FixTags.TIMEINFORCE_INT:		
            		hasTimeInForce = (short) buf.position();		
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
		hasTimeInForce = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasTimeInForce()) {		
			out.put(FixTags.TIMEINFORCE);

			out.put((byte) '=');

			FixUtils.put(out,timeInForce); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasTimeInForce()) {		
			FixUtils.put(out,timeInForce); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte getTimeInForce() { 		
		if ( hasTimeInForce()) {		
			if (hasTimeInForce == FixUtils.TAG_HAS_VALUE) {		
				return timeInForce; 		
			} else {		
		
				buf.position(hasTimeInForce);		
		
			timeInForce = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (timeInForce != (byte)'3') && (timeInForce != (byte)'2') && (timeInForce != (byte)'1') && (timeInForce != (byte)'0') && (timeInForce != (byte)'7') && (timeInForce != (byte)'6') && (timeInForce != (byte)'5') && (timeInForce != (byte)'4') && (timeInForce != (byte)'9') && (timeInForce != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 59);		
				if (err.hasError()) {		
					buf.position(hasTimeInForce);		
					return (byte)'0';		
				}		
			}		
			hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
			return timeInForce;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTimeInForce() { return hasTimeInForce != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTimeInForce(byte src) {		
		timeInForce = src;
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeInForce(byte[] src) {		
		if (src == null ) return;
		if (hasTimeInForce()) timeInForce = (byte)' ';		
		timeInForce = src[0];		
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTimeInForce(String str) {		
		if (str == null ) return;
		if (hasTimeInForce()) timeInForce = (byte)' ';		
		byte[] src = str.getBytes(); 		
		timeInForce = src[0];		
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasTimeInForce()) s += "TimeInForce(59)= " + getTimeInForce() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTimeInForceRules)) return false;

		FixTimeInForceRules msg = (FixTimeInForceRules) o;

		if ((hasTimeInForce() && !msg.hasTimeInForce()) || (!hasTimeInForce() && msg.hasTimeInForce())) return false;
		if (!(!hasTimeInForce() && !msg.hasTimeInForce()) && !(getTimeInForce()==msg.getTimeInForce())) return false;
		return true;
	}
	public FixTimeInForceRules clone ( FixTimeInForceRules out ) {
		if ( hasTimeInForce())
			out.setTimeInForce(getTimeInForce());
		return out;
	}

}
