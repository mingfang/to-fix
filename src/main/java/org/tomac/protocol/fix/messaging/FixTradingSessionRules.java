package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTradingSessionRules extends FixGroup {
		FixOrdTypeRules[] ordTypeRules;
		FixTimeInForceRules[] timeInForceRules;
		FixExecInstRules[] execInstRules;
		FixMatchRules[] matchRules;
		FixMarketDataFeedTypes[] marketDataFeedTypes;
	
	public FixTradingSessionRules() {
		super(FixTags.ORDTYPE_INT);

		
		ordTypeRules = new FixOrdTypeRules[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) ordTypeRules[i] = new FixOrdTypeRules();
		timeInForceRules = new FixTimeInForceRules[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) timeInForceRules[i] = new FixTimeInForceRules();
		execInstRules = new FixExecInstRules[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) execInstRules[i] = new FixExecInstRules();
		matchRules = new FixMatchRules[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) matchRules[i] = new FixMatchRules();
		marketDataFeedTypes = new FixMarketDataFeedTypes[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) marketDataFeedTypes[i] = new FixMarketDataFeedTypes();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (ordTypeRules[0].hasGroup()) return true;
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
        			if ( tag == FixTags.NOORDTYPERULES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !ordTypeRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = ordTypeRules[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOTIMEINFORCERULES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !timeInForceRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = timeInForceRules[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOEXECINSTRULES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !execInstRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = execInstRules[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOMATCHRULES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !matchRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = matchRules[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOMDFEEDTYPES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !marketDataFeedTypes[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = marketDataFeedTypes[count].setBuffer( repeatingGroupTag, buf, err);	
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
		for (FixOrdTypeRules fixOrdTypeRules : ordTypeRules) fixOrdTypeRules.clear();
		for (FixTimeInForceRules fixTimeInForceRules : timeInForceRules) fixTimeInForceRules.clear();
		for (FixExecInstRules fixExecInstRules : execInstRules) fixExecInstRules.clear();
		for (FixMatchRules fixMatchRules : matchRules) fixMatchRules.clear();
		for (FixMarketDataFeedTypes fixMarketDataFeedTypes : marketDataFeedTypes) fixMarketDataFeedTypes.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		for (FixOrdTypeRules fixOrdTypeRules : ordTypeRules) fixOrdTypeRules.encode(out);
		for (FixTimeInForceRules fixTimeInForceRules : timeInForceRules) fixTimeInForceRules.encode(out);
		for (FixExecInstRules fixExecInstRules : execInstRules) fixExecInstRules.encode(out);
		for (FixMatchRules fixMatchRules : matchRules) fixMatchRules.encode(out);
		for (FixMarketDataFeedTypes fixMarketDataFeedTypes : marketDataFeedTypes) fixMarketDataFeedTypes.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		for (FixOrdTypeRules fixOrdTypeRules : ordTypeRules) fixOrdTypeRules.printBuffer(out);
		for (FixTimeInForceRules fixTimeInForceRules : timeInForceRules) fixTimeInForceRules.printBuffer(out);
		for (FixExecInstRules fixExecInstRules : execInstRules) fixExecInstRules.printBuffer(out);
		for (FixMatchRules fixMatchRules : matchRules) fixMatchRules.printBuffer(out);
		for (FixMarketDataFeedTypes fixMarketDataFeedTypes : marketDataFeedTypes) fixMarketDataFeedTypes.printBuffer(out);
	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		
		for (FixOrdTypeRules fixOrdTypeRules : ordTypeRules) fixOrdTypeRules.toString();
		for (FixTimeInForceRules fixTimeInForceRules : timeInForceRules) fixTimeInForceRules.toString();
		for (FixExecInstRules fixExecInstRules : execInstRules) fixExecInstRules.toString();
		for (FixMatchRules fixMatchRules : matchRules) fixMatchRules.toString();
		for (FixMarketDataFeedTypes fixMarketDataFeedTypes : marketDataFeedTypes) fixMarketDataFeedTypes.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTradingSessionRules)) return false;

		FixTradingSessionRules msg = (FixTradingSessionRules) o;

		for (FixOrdTypeRules fixOrdTypeRules : ordTypeRules)
			if (!fixOrdTypeRules.equals(msg.ordTypeRules)) return false;
		for (FixTimeInForceRules fixTimeInForceRules : timeInForceRules)
			if (!fixTimeInForceRules.equals(msg.timeInForceRules)) return false;
		for (FixExecInstRules fixExecInstRules : execInstRules)
			if (!fixExecInstRules.equals(msg.execInstRules)) return false;
		for (FixMatchRules fixMatchRules : matchRules)
			if (!fixMatchRules.equals(msg.matchRules)) return false;
		for (FixMarketDataFeedTypes fixMarketDataFeedTypes : marketDataFeedTypes)
			if (!fixMarketDataFeedTypes.equals(msg.marketDataFeedTypes)) return false;
		return true;
	}
	public FixTradingSessionRules clone ( FixTradingSessionRules out ) {
		int count = 0;
		count = 0;
		for (FixOrdTypeRules fixOrdTypeRules : ordTypeRules) {
			if (!fixOrdTypeRules.hasGroup()) continue;
			out.ordTypeRules[count] = fixOrdTypeRules.clone( out.ordTypeRules[count] );
			count++;
		}
		count = 0;
		for (FixTimeInForceRules fixTimeInForceRules : timeInForceRules) {
			if (!fixTimeInForceRules.hasGroup()) continue;
			out.timeInForceRules[count] = fixTimeInForceRules.clone( out.timeInForceRules[count] );
			count++;
		}
		count = 0;
		for (FixExecInstRules fixExecInstRules : execInstRules) {
			if (!fixExecInstRules.hasGroup()) continue;
			out.execInstRules[count] = fixExecInstRules.clone( out.execInstRules[count] );
			count++;
		}
		count = 0;
		for (FixMatchRules fixMatchRules : matchRules) {
			if (!fixMatchRules.hasGroup()) continue;
			out.matchRules[count] = fixMatchRules.clone( out.matchRules[count] );
			count++;
		}
		count = 0;
		for (FixMarketDataFeedTypes fixMarketDataFeedTypes : marketDataFeedTypes) {
			if (!fixMarketDataFeedTypes.hasGroup()) continue;
			out.marketDataFeedTypes[count] = fixMarketDataFeedTypes.clone( out.marketDataFeedTypes[count] );
			count++;
		}
		return out;
	}

}
