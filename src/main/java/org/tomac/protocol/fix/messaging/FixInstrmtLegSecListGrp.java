package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixInstrmtLegSecListGrp extends FixGroup {
	private short hasLegSwapType;
	long legSwapType = 0;		
	private short hasLegSettlType;
	byte legSettlType = (byte)' ';		
		public FixInstrumentLeg instrumentLeg;
		public FixLegStipulations[] legStipulations;
		public FixLegBenchmarkCurveData legBenchmarkCurveData;
	
	public FixInstrmtLegSecListGrp() {
		this(false);
	}

	public FixInstrmtLegSecListGrp(boolean isRequired) {
		super(FixTags.LEGSYMBOL_INT);

		this.isRequired = isRequired;
		
		hasLegSwapType = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		instrumentLeg = new FixInstrumentLeg();
		legStipulations = new FixLegStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) legStipulations[i] = new FixLegStipulations();
		legBenchmarkCurveData = new FixLegBenchmarkCurveData();
		
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
            	case FixTags.LEGSWAPTYPE_INT:		
            		hasLegSwapType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSETTLTYPE_INT:		
            		hasLegSettlType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( instrumentLeg.isKeyTag(tag)) {
        				tag = instrumentLeg.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOLEGSTIPULATIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
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
        			} else if ( legBenchmarkCurveData.isKeyTag(tag)) {
        				tag = legBenchmarkCurveData.setBuffer( tag, buf, err);		
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
		hasLegSwapType = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSettlType = FixUtils.TAG_HAS_NO_VALUE;
		instrumentLeg.clear();
		for (FixLegStipulations fixLegStipulations : legStipulations) fixLegStipulations.clear();
		legBenchmarkCurveData.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasLegSwapType()) {		
			out.put(FixTags.LEGSWAPTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)legSwapType);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSettlType()) {		
			out.put(FixTags.LEGSETTLTYPE);

			out.put((byte) '=');

			FixUtils.put(out,legSettlType); 		
		
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
		legBenchmarkCurveData.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasLegSwapType()) {		
			FixUtils.put(out, (long)legSwapType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSettlType()) {		
			FixUtils.put(out,legSettlType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		instrumentLeg.printBuffer(out);
		for (FixLegStipulations fixLegStipulations : legStipulations) fixLegStipulations.printBuffer(out);
		legBenchmarkCurveData.printBuffer(out);
	}

	public long getLegSwapType() { 		
		if ( hasLegSwapType()) {		
			if (hasLegSwapType == FixUtils.TAG_HAS_VALUE) {		
				return legSwapType; 		
			} else {		
		
				buf.position(hasLegSwapType);		
		
			legSwapType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSwapType);		
					return 0;		
				}		
			}		
			hasLegSwapType = FixUtils.TAG_HAS_VALUE;		
			return legSwapType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegSwapType() { return hasLegSwapType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSwapType(long src) {		
		legSwapType = src;
		hasLegSwapType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegSwapType(byte[] src) {		
		if (src == null ) return;
		if (hasLegSwapType()) legSwapType = FixUtils.TAG_HAS_NO_VALUE;		
		legSwapType = FixUtils.longValueOf(src, 0, src.length);
		hasLegSwapType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSwapType(String str) {		
		if (str == null ) return;
		if (hasLegSwapType()) legSwapType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legSwapType = FixUtils.longValueOf(src, 0, src.length);
		hasLegSwapType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getLegSettlType() { 		
		if ( hasLegSettlType()) {		
			if (hasLegSettlType == FixUtils.TAG_HAS_VALUE) {		
				return legSettlType; 		
			} else {		
		
				buf.position(hasLegSettlType);		
		
			legSettlType = FixUtils.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSettlType);		
					return (byte)'0';		
				}		
			}		
			hasLegSettlType = FixUtils.TAG_HAS_VALUE;		
			return legSettlType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasLegSettlType() { return hasLegSettlType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSettlType(byte src) {		
		legSettlType = src;
		hasLegSettlType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegSettlType(byte[] src) {		
		if (src == null ) return;
		if (hasLegSettlType()) legSettlType = (byte)' ';		
		legSettlType = src[0];		
		hasLegSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSettlType(String str) {		
		if (str == null ) return;
		if (hasLegSettlType()) legSettlType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		legSettlType = src[0];		
		hasLegSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasLegSwapType()) s += "LegSwapType(690)= " + getLegSwapType() + "\n" ; 
		if (hasLegSettlType()) s += "LegSettlType(587)= " + getLegSettlType() + "\n" ; 

		s += instrumentLeg.toString();
		for (FixLegStipulations fixLegStipulations : legStipulations) fixLegStipulations.toString();
		s += legBenchmarkCurveData.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrmtLegSecListGrp)) return false;

		FixInstrmtLegSecListGrp msg = (FixInstrmtLegSecListGrp) o;

		if (!instrumentLeg.equals(msg.instrumentLeg)) return false;
		for (int i = 0; i < legStipulations.length; i++)
			if (!legStipulations[i].equals(msg.legStipulations[i])) return false;
		if (!legBenchmarkCurveData.equals(msg.legBenchmarkCurveData)) return false;
		if ((hasLegSwapType() && !msg.hasLegSwapType()) || (!hasLegSwapType() && msg.hasLegSwapType())) return false;
		if (!(!hasLegSwapType() && !msg.hasLegSwapType()) && !(getLegSwapType()==msg.getLegSwapType())) return false;
		if ((hasLegSettlType() && !msg.hasLegSettlType()) || (!hasLegSettlType() && msg.hasLegSettlType())) return false;
		if (!(!hasLegSettlType() && !msg.hasLegSettlType()) && !(getLegSettlType()==msg.getLegSettlType())) return false;
		return true;
	}
	public FixInstrmtLegSecListGrp clone ( FixInstrmtLegSecListGrp out ) {
		if ( hasLegSwapType())
			out.setLegSwapType(getLegSwapType());
		if ( hasLegSettlType())
			out.setLegSettlType(getLegSettlType());
		if (instrumentLeg.hasGroup())
			out.instrumentLeg = instrumentLeg.clone( out.instrumentLeg);
		int count = 0;
		count = 0;
		for (FixLegStipulations fixLegStipulations : legStipulations) {
			if (!fixLegStipulations.hasGroup()) continue;
			out.legStipulations[count] = fixLegStipulations.clone( out.legStipulations[count] );
			count++;
		}
		if (legBenchmarkCurveData.hasGroup())
			out.legBenchmarkCurveData = legBenchmarkCurveData.clone( out.legBenchmarkCurveData);
		return out;
	}

}
