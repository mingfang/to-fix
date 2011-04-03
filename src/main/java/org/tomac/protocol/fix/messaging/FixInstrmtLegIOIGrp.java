package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixInstrmtLegIOIGrp extends FixGroup {
	private short hasLegIOIQty;
	byte[] legIOIQty = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixInstrumentLeg instrumentLeg;
		public FixLegStipulations[] legStipulations;
	
	public FixInstrmtLegIOIGrp() {
		this(false);
	}

	public FixInstrmtLegIOIGrp(boolean isRequired) {
		super(FixTags.LEGSYMBOL_INT);

		this.isRequired = isRequired;
		
		hasLegIOIQty = FixUtils.TAG_HAS_NO_VALUE;		
		legIOIQty = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		instrumentLeg = new FixInstrumentLeg();
		legStipulations = new FixLegStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) legStipulations[i] = new FixLegStipulations();
		
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
		super.err.clear();
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.LEGIOIQTY_INT:		
            		hasLegIOIQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( instrumentLeg.isKeyTag(tag)) {
        				tag = instrumentLeg.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOLEGSTIPULATIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !legStipulations[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = legStipulations[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
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
		hasLegIOIQty = FixUtils.TAG_HAS_NO_VALUE;
		instrumentLeg.clear();
		for (FixLegStipulations fixLegStipulations : legStipulations) fixLegStipulations.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasLegIOIQty()) {		
			out.put(FixTags.LEGIOIQTY);

			out.put((byte) '=');

			FixUtils.put(out,legIOIQty); 		
		
			out.put(FixUtils.SOH);

            }

		instrumentLeg.encode(out);
		if (FixUtils.getNoInGroup(legStipulations)>0) {
			out.put(FixTags.NOLEGSTIPULATIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(legStipulations));

			out.put(FixUtils.SOH);

		}
		for (FixLegStipulations fixLegStipulations : legStipulations) if (fixLegStipulations.hasGroup()) fixLegStipulations.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasLegIOIQty()) {		
			FixUtils.put(out,legIOIQty); 		
		
	        out.put( (byte)' ' );		
		}		
		
		instrumentLeg.printBuffer(out);
		for (FixLegStipulations fixLegStipulations : legStipulations) fixLegStipulations.printBuffer(out);
	}

	public byte[] getLegIOIQty() { 		
		if ( hasLegIOIQty()) {		
			if (hasLegIOIQty == FixUtils.TAG_HAS_VALUE) {		
				return legIOIQty; 		
			} else {		
		
				buf.position(hasLegIOIQty);		
		
			FixMessage.getTagStringValue(buf, legIOIQty, 0, legIOIQty.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegIOIQty);		
					return null;		
				}		
			}		
			hasLegIOIQty = FixUtils.TAG_HAS_VALUE;		
			return legIOIQty;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegIOIQty() { return hasLegIOIQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegIOIQty(byte[] src) {		
		if (src == null ) return;
		if (hasLegIOIQty()) FixUtils.fillSpace(legIOIQty);		
		FixUtils.copy(legIOIQty, src); 		
		hasLegIOIQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegIOIQty(String str) {		
		if (str == null ) return;
		if (hasLegIOIQty()) FixUtils.fillSpace(legIOIQty);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legIOIQty, src); 		
		hasLegIOIQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasLegIOIQty()) s += "LegIOIQty(682)= " + new String( FixUtils.trim(getLegIOIQty()) ) + "\n" ; 

		s += instrumentLeg.toString();
		for (FixLegStipulations fixLegStipulations : legStipulations) fixLegStipulations.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrmtLegIOIGrp)) return false;

		FixInstrmtLegIOIGrp msg = (FixInstrmtLegIOIGrp) o;

		if (!instrumentLeg.equals(msg.instrumentLeg)) return false;
		for (int i = 0; i < legStipulations.length; i++)
			if (!legStipulations[i].equals(msg.legStipulations[i])) return false;
		if ((hasLegIOIQty() && !msg.hasLegIOIQty()) || (!hasLegIOIQty() && msg.hasLegIOIQty())) return false;
		if (!(!hasLegIOIQty() && !msg.hasLegIOIQty()) && !FixUtils.equals(getLegIOIQty(), msg.getLegIOIQty())) return false;
		return true;
	}
	public FixInstrmtLegIOIGrp clone ( FixInstrmtLegIOIGrp out ) {
		if ( hasLegIOIQty())
			out.setLegIOIQty(getLegIOIQty());
		if (instrumentLeg.hasGroup())
			out.instrumentLeg = instrumentLeg.clone( out.instrumentLeg);
		int count = 0;
		count = 0;
		for (FixLegStipulations fixLegStipulations : legStipulations) {
			if (!fixLegStipulations.hasGroup()) continue;
			out.legStipulations[count] = fixLegStipulations.clone( out.legStipulations[count] );
			count++;
		}
		return out;
	}

}
