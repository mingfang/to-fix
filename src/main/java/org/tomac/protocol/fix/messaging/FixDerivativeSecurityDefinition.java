package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixDerivativeSecurityDefinition extends FixGroup {
		FixDerivativeInstrument derivativeInstrument;
		FixDerivativeInstrumentAttribute[] derivativeInstrumentAttribute;
		FixMarketSegmentGrp[] marketSegmentGrp;
	
	public FixDerivativeSecurityDefinition() {
		super(FixTags.DERIVATIVESYMBOL_INT);

		
		derivativeInstrument = new FixDerivativeInstrument();
		derivativeInstrumentAttribute = new FixDerivativeInstrumentAttribute[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) derivativeInstrumentAttribute[i] = new FixDerivativeInstrumentAttribute();
		marketSegmentGrp = new FixMarketSegmentGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) marketSegmentGrp[i] = new FixMarketSegmentGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (derivativeInstrument.hasGroup()) return true;
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
        			if ( derivativeInstrument.isKeyTag(tag)) {
        				tag = derivativeInstrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NODERIVATIVEINSTRATTRIB_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !derivativeInstrumentAttribute[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = derivativeInstrumentAttribute[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOMARKETSEGMENTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !marketSegmentGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = marketSegmentGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		derivativeInstrument.clear();
		for (FixDerivativeInstrumentAttribute fixDerivativeInstrumentAttribute : derivativeInstrumentAttribute) fixDerivativeInstrumentAttribute.clear();
		for (FixMarketSegmentGrp fixMarketSegmentGrp : marketSegmentGrp) fixMarketSegmentGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		derivativeInstrument.encode(out);
		for (FixDerivativeInstrumentAttribute fixDerivativeInstrumentAttribute : derivativeInstrumentAttribute) fixDerivativeInstrumentAttribute.encode(out);
		for (FixMarketSegmentGrp fixMarketSegmentGrp : marketSegmentGrp) fixMarketSegmentGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		derivativeInstrument.printBuffer(out);
		for (FixDerivativeInstrumentAttribute fixDerivativeInstrumentAttribute : derivativeInstrumentAttribute) fixDerivativeInstrumentAttribute.printBuffer(out);
		for (FixMarketSegmentGrp fixMarketSegmentGrp : marketSegmentGrp) fixMarketSegmentGrp.printBuffer(out);
	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		
		s += derivativeInstrument.toString();
		for (FixDerivativeInstrumentAttribute fixDerivativeInstrumentAttribute : derivativeInstrumentAttribute) fixDerivativeInstrumentAttribute.toString();
		for (FixMarketSegmentGrp fixMarketSegmentGrp : marketSegmentGrp) fixMarketSegmentGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDerivativeSecurityDefinition)) return false;

		FixDerivativeSecurityDefinition msg = (FixDerivativeSecurityDefinition) o;

		if (!derivativeInstrument.equals(msg.derivativeInstrument)) return false;
		for (FixDerivativeInstrumentAttribute fixDerivativeInstrumentAttribute : derivativeInstrumentAttribute)
			if (!fixDerivativeInstrumentAttribute.equals(msg.derivativeInstrumentAttribute)) return false;
		for (FixMarketSegmentGrp fixMarketSegmentGrp : marketSegmentGrp)
			if (!fixMarketSegmentGrp.equals(msg.marketSegmentGrp)) return false;
		return true;
	}
	public FixDerivativeSecurityDefinition clone ( FixDerivativeSecurityDefinition out ) {
		if (derivativeInstrument.hasGroup())
			out.derivativeInstrument = derivativeInstrument.clone( out.derivativeInstrument);
		int count = 0;
		count = 0;
		for (FixDerivativeInstrumentAttribute fixDerivativeInstrumentAttribute : derivativeInstrumentAttribute) {
			if (!fixDerivativeInstrumentAttribute.hasGroup()) continue;
			out.derivativeInstrumentAttribute[count] = fixDerivativeInstrumentAttribute.clone( out.derivativeInstrumentAttribute[count] );
			count++;
		}
		count = 0;
		for (FixMarketSegmentGrp fixMarketSegmentGrp : marketSegmentGrp) {
			if (!fixMarketSegmentGrp.hasGroup()) continue;
			out.marketSegmentGrp[count] = fixMarketSegmentGrp.clone( out.marketSegmentGrp[count] );
			count++;
		}
		return out;
	}

}
