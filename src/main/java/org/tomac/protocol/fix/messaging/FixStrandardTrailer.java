package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixStrandardTrailer extends FixGroup {
	private short hasCheckSum;
	byte[] checkSum = new byte[3];		
	
	public FixStrandardTrailer() {
		super(FixTags.CHECKSUM_INT);

		
		hasCheckSum = FixUtils.TAG_HAS_NO_VALUE;		
		checkSum = new byte[3];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasCheckSum()) return true;
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
            	case FixTags.CHECKSUM_INT:		
            		hasCheckSum = (short) buf.position();		
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
		hasCheckSum = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasCheckSum()) {		
			out.put(FixTags.CHECKSUM);

			out.put((byte) '=');

			FixUtils.put(out,checkSum); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasCheckSum()) {		
			FixUtils.put(out,checkSum); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	byte[] getCheckSum() { 		
		if ( hasCheckSum()) {		
			if (hasCheckSum == FixUtils.TAG_HAS_VALUE) {		
				return checkSum; 		
			} else {		
		
				buf.position(hasCheckSum);		
		
			FixMessage.getTagStringValue(buf, checkSum, 0, checkSum.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCheckSum);		
					return null;		
				}		
			}		
			hasCheckSum = FixUtils.TAG_HAS_VALUE;		
			return checkSum;		
		} else {		
			return null; 		
		}		
	}		
			
	boolean hasCheckSum() { return hasCheckSum != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	void setCheckSum(byte[] src) {		
		if (src == null ) return;
		if (hasCheckSum()) FixUtils.fillSpace(checkSum);		
		FixUtils.copy(checkSum, src); 		
		hasCheckSum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	void setCheckSum(String str) {		
		if (str == null ) return;
		if (hasCheckSum()) FixUtils.fillSpace(checkSum);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(checkSum, src); 		
		hasCheckSum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(getCheckSum()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStrandardTrailer)) return false;

		FixStrandardTrailer msg = (FixStrandardTrailer) o;

		if ((hasCheckSum() && !msg.hasCheckSum()) || (!hasCheckSum() && msg.hasCheckSum())) return false;
		if (!(!hasCheckSum() && !msg.hasCheckSum()) && !FixUtils.equals(getCheckSum(), msg.getCheckSum())) return false;
		return true;
	}
	public FixStrandardTrailer clone ( FixStrandardTrailer out ) {
		if ( hasCheckSum())
			out.setCheckSum(getCheckSum());
		return out;
	}

}
