package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixInstrmtGrp extends FixGroup {
		public FixInstrument instrument;
	
	public FixInstrmtGrp() {
		this(false);
	}

	public FixInstrmtGrp(boolean isRequired) {
		super(FixTags.SYMBOL_INT);

		this.isRequired = isRequired;
		
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
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	default:
        			if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
            		} else { return tag; }
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
		instrument.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		instrument.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		instrument.printBuffer(out);
	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		
		s += instrument.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrmtGrp)) return false;

		FixInstrmtGrp msg = (FixInstrmtGrp) o;

		if (!instrument.equals(msg.instrument)) return false;
		return true;
	}
	public FixInstrmtGrp clone ( FixInstrmtGrp out ) {
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		return out;
	}

}
