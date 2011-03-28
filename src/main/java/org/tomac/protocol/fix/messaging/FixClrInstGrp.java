package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixClrInstGrp extends FixGroup {
	private short hasClearingInstruction;
	long clearingInstruction = 0;		
	
	public FixClrInstGrp() {
		super(FixTags.CLEARINGINSTRUCTION_INT);

		
		hasClearingInstruction = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasClearingInstruction()) return true;
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
            	case FixTags.CLEARINGINSTRUCTION_INT:		
            		hasClearingInstruction = (short) buf.position();		
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
		hasClearingInstruction = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasClearingInstruction()) {		
			out.put(FixTags.CLEARINGINSTRUCTION);

			out.put((byte) '=');

			FixUtils.put(out, (long)clearingInstruction);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasClearingInstruction()) {		
			FixUtils.put(out, (long)clearingInstruction);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getClearingInstruction() { 		
		if ( hasClearingInstruction()) {		
			if (hasClearingInstruction == FixUtils.TAG_HAS_VALUE) {		
				return clearingInstruction; 		
			} else {		
		
				buf.position(hasClearingInstruction);		
		
			clearingInstruction = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasClearingInstruction);		
					return 0;		
				}		
			}		
			hasClearingInstruction = FixUtils.TAG_HAS_VALUE;		
			return clearingInstruction;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasClearingInstruction() { return hasClearingInstruction != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setClearingInstruction(long src) {		
		clearingInstruction = src;
		hasClearingInstruction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClearingInstruction(byte[] src) {		
		if (src == null ) return;
		if (hasClearingInstruction()) clearingInstruction = FixUtils.TAG_HAS_NO_VALUE;		
		clearingInstruction = FixUtils.longValueOf(src, 0, src.length);
		hasClearingInstruction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setClearingInstruction(String str) {		
		if (str == null ) return;
		if (hasClearingInstruction()) clearingInstruction = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		clearingInstruction = FixUtils.longValueOf(src, 0, src.length);
		hasClearingInstruction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasClearingInstruction()) s += "ClearingInstruction(577)= " + getClearingInstruction() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixClrInstGrp)) return false;

		FixClrInstGrp msg = (FixClrInstGrp) o;

		if ((hasClearingInstruction() && !msg.hasClearingInstruction()) || (!hasClearingInstruction() && msg.hasClearingInstruction())) return false;
		if (!(!hasClearingInstruction() && !msg.hasClearingInstruction()) && !(getClearingInstruction()==msg.getClearingInstruction())) return false;
		return true;
	}
	public FixClrInstGrp clone ( FixClrInstGrp out ) {
		if ( hasClearingInstruction())
			out.setClearingInstruction(getClearingInstruction());
		return out;
	}

}
