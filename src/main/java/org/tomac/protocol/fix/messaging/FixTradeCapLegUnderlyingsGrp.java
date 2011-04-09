package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTradeCapLegUnderlyingsGrp extends FixGroup {
		public FixUnderlyingLegInstrument underlyingLegInstrument;
	
	public FixTradeCapLegUnderlyingsGrp() {
		this(false);
	}

	public FixTradeCapLegUnderlyingsGrp(boolean isRequired) {
		super(FixTags.UNDERLYINGLEGSYMBOL_INT);

		this.isRequired = isRequired;
		
		underlyingLegInstrument = new FixUnderlyingLegInstrument();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (underlyingLegInstrument.hasGroup()) return true;
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
        			if ( underlyingLegInstrument.isKeyTag(tag)) {
        				tag = underlyingLegInstrument.setBuffer( tag, buf, err);		
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
		underlyingLegInstrument.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		underlyingLegInstrument.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		underlyingLegInstrument.printBuffer(out);
	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		
		s += underlyingLegInstrument.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTradeCapLegUnderlyingsGrp)) return false;

		FixTradeCapLegUnderlyingsGrp msg = (FixTradeCapLegUnderlyingsGrp) o;

		if (!underlyingLegInstrument.equals(msg.underlyingLegInstrument)) return false;
		return true;
	}
	public FixTradeCapLegUnderlyingsGrp clone ( FixTradeCapLegUnderlyingsGrp out ) {
		if (underlyingLegInstrument.hasGroup())
			out.underlyingLegInstrument = underlyingLegInstrument.clone( out.underlyingLegInstrument);
		return out;
	}

}
