package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixInstrmtLegGrp extends FixGroup {
		public FixInstrumentLeg instrumentLeg;
	
	public FixInstrmtLegGrp() {
		this(false);
	}

	public FixInstrmtLegGrp(boolean isRequired) {
		super(FixTags.LEGSYMBOL_INT);

		this.isRequired = isRequired;
		
		instrumentLeg = new FixInstrumentLeg();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (instrumentLeg.hasGroup()) return true;
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
        			if ( instrumentLeg.isKeyTag(tag)) {
        				tag = instrumentLeg.setBuffer( tag, buf, err);		
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
		instrumentLeg.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		instrumentLeg.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		instrumentLeg.printBuffer(out);
	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		
		s += instrumentLeg.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrmtLegGrp)) return false;

		FixInstrmtLegGrp msg = (FixInstrmtLegGrp) o;

		if (!instrumentLeg.equals(msg.instrumentLeg)) return false;
		return true;
	}
	public FixInstrmtLegGrp clone ( FixInstrmtLegGrp out ) {
		if (instrumentLeg.hasGroup())
			out.instrumentLeg = instrumentLeg.clone( out.instrumentLeg);
		return out;
	}

}
