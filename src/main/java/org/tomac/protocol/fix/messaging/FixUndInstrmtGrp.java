package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixUndInstrmtGrp extends FixGroup {
		public FixUnderlyingInstrument underlyingInstrument;
	
	public FixUndInstrmtGrp() {
		this(false);
	}

	public FixUndInstrmtGrp(boolean isRequired) {
		super(FixTags.UNDERLYINGSYMBOL_INT);

		this.isRequired = isRequired;
		
		underlyingInstrument = new FixUnderlyingInstrument();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (underlyingInstrument.hasGroup()) return true;
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
            	default:
        			if ( underlyingInstrument.isKeyTag(tag)) {
        				tag = underlyingInstrument.setBuffer( tag, buf, err);		
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
		underlyingInstrument.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		underlyingInstrument.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		underlyingInstrument.printBuffer(out);
	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		
		s += underlyingInstrument.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUndInstrmtGrp)) return false;

		FixUndInstrmtGrp msg = (FixUndInstrmtGrp) o;

		if (!underlyingInstrument.equals(msg.underlyingInstrument)) return false;
		return true;
	}
	public FixUndInstrmtGrp clone ( FixUndInstrmtGrp out ) {
		if (underlyingInstrument.hasGroup())
			out.underlyingInstrument = underlyingInstrument.clone( out.underlyingInstrument);
		return out;
	}

}
