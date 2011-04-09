package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixExecInstRules extends FixGroup {
	private short hasExecInstValue;
	byte execInstValue = (byte)' ';		
	
	public FixExecInstRules() {
		this(false);
	}

	public FixExecInstRules(boolean isRequired) {
		super(FixTags.EXECINSTVALUE_INT);

		this.isRequired = isRequired;
		
		hasExecInstValue = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasExecInstValue()) return true;
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
            	case FixTags.EXECINSTVALUE_INT:		
            		hasExecInstValue = (short) buf.position();		
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
		hasExecInstValue = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasExecInstValue()) {		
			out.put(FixTags.EXECINSTVALUE);

			out.put((byte) '=');

			FixUtils.put(out,execInstValue); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasExecInstValue()) {		
			FixUtils.put(out,execInstValue); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte getExecInstValue() { 		
		if ( hasExecInstValue()) {		
			if (hasExecInstValue == FixUtils.TAG_HAS_VALUE) {		
				return execInstValue; 		
			} else {		
		
				buf.position(hasExecInstValue);		
		
			execInstValue = FixUtils.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasExecInstValue);		
					return (byte)'0';		
				}		
			}		
			hasExecInstValue = FixUtils.TAG_HAS_VALUE;		
			return execInstValue;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasExecInstValue() { return hasExecInstValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setExecInstValue(byte src) {		
		execInstValue = src;
		hasExecInstValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecInstValue(byte[] src) {		
		if (src == null ) return;
		if (hasExecInstValue()) execInstValue = (byte)' ';		
		execInstValue = src[0];		
		hasExecInstValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setExecInstValue(String str) {		
		if (str == null ) return;
		if (hasExecInstValue()) execInstValue = (byte)' ';		
		byte[] src = str.getBytes(); 		
		execInstValue = src[0];		
		hasExecInstValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasExecInstValue()) s += "ExecInstValue(1308)= " + getExecInstValue() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixExecInstRules)) return false;

		FixExecInstRules msg = (FixExecInstRules) o;

		if ((hasExecInstValue() && !msg.hasExecInstValue()) || (!hasExecInstValue() && msg.hasExecInstValue())) return false;
		if (!(!hasExecInstValue() && !msg.hasExecInstValue()) && !(getExecInstValue()==msg.getExecInstValue())) return false;
		return true;
	}
	public FixExecInstRules clone ( FixExecInstRules out ) {
		if ( hasExecInstValue())
			out.setExecInstValue(getExecInstValue());
		return out;
	}

}
