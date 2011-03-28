package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSecurityTradingRules extends FixGroup {
		FixBaseTradingRules baseTradingRules;
		FixTradingSessionRulesGrp[] tradingSessionRulesGrp;
		FixNestedInstrumentAttribute[] nestedInstrumentAttribute;
	
	public FixSecurityTradingRules() {
		super(FixTags.EXPIRATIONCYCLE_INT);

		
		baseTradingRules = new FixBaseTradingRules();
		tradingSessionRulesGrp = new FixTradingSessionRulesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) tradingSessionRulesGrp[i] = new FixTradingSessionRulesGrp();
		nestedInstrumentAttribute = new FixNestedInstrumentAttribute[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedInstrumentAttribute[i] = new FixNestedInstrumentAttribute();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (baseTradingRules.hasGroup()) return true;
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
        			if ( baseTradingRules.isKeyTag(tag)) {
        				tag = baseTradingRules.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOTRADINGSESSIONRULES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !tradingSessionRulesGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = tradingSessionRulesGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NONESTEDINSTRATTRIB_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !nestedInstrumentAttribute[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = nestedInstrumentAttribute[count].setBuffer( repeatingGroupTag, buf, err);	
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
		baseTradingRules.clear();
		for (FixTradingSessionRulesGrp fixTradingSessionRulesGrp : tradingSessionRulesGrp) fixTradingSessionRulesGrp.clear();
		for (FixNestedInstrumentAttribute fixNestedInstrumentAttribute : nestedInstrumentAttribute) fixNestedInstrumentAttribute.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		baseTradingRules.encode(out);
		for (FixTradingSessionRulesGrp fixTradingSessionRulesGrp : tradingSessionRulesGrp) fixTradingSessionRulesGrp.encode(out);
		for (FixNestedInstrumentAttribute fixNestedInstrumentAttribute : nestedInstrumentAttribute) fixNestedInstrumentAttribute.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		baseTradingRules.printBuffer(out);
		for (FixTradingSessionRulesGrp fixTradingSessionRulesGrp : tradingSessionRulesGrp) fixTradingSessionRulesGrp.printBuffer(out);
		for (FixNestedInstrumentAttribute fixNestedInstrumentAttribute : nestedInstrumentAttribute) fixNestedInstrumentAttribute.printBuffer(out);
	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		
		s += baseTradingRules.toString();
		for (FixTradingSessionRulesGrp fixTradingSessionRulesGrp : tradingSessionRulesGrp) fixTradingSessionRulesGrp.toString();
		for (FixNestedInstrumentAttribute fixNestedInstrumentAttribute : nestedInstrumentAttribute) fixNestedInstrumentAttribute.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSecurityTradingRules)) return false;

		FixSecurityTradingRules msg = (FixSecurityTradingRules) o;

		if (!baseTradingRules.equals(msg.baseTradingRules)) return false;
		for (FixTradingSessionRulesGrp fixTradingSessionRulesGrp : tradingSessionRulesGrp)
			if (!fixTradingSessionRulesGrp.equals(msg.tradingSessionRulesGrp)) return false;
		for (FixNestedInstrumentAttribute fixNestedInstrumentAttribute : nestedInstrumentAttribute)
			if (!fixNestedInstrumentAttribute.equals(msg.nestedInstrumentAttribute)) return false;
		return true;
	}
	public FixSecurityTradingRules clone ( FixSecurityTradingRules out ) {
		if (baseTradingRules.hasGroup())
			out.baseTradingRules = baseTradingRules.clone( out.baseTradingRules);
		int count = 0;
		count = 0;
		for (FixTradingSessionRulesGrp fixTradingSessionRulesGrp : tradingSessionRulesGrp) {
			if (!fixTradingSessionRulesGrp.hasGroup()) continue;
			out.tradingSessionRulesGrp[count] = fixTradingSessionRulesGrp.clone( out.tradingSessionRulesGrp[count] );
			count++;
		}
		count = 0;
		for (FixNestedInstrumentAttribute fixNestedInstrumentAttribute : nestedInstrumentAttribute) {
			if (!fixNestedInstrumentAttribute.hasGroup()) continue;
			out.nestedInstrumentAttribute[count] = fixNestedInstrumentAttribute.clone( out.nestedInstrumentAttribute[count] );
			count++;
		}
		return out;
	}

}
