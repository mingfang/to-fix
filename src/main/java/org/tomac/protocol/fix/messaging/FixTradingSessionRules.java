package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTradingSessionRules extends FixGroup {
		public FixOrdTypeRules[] ordTypeRules;
		public FixTimeInForceRules[] timeInForceRules;
		public FixExecInstRules[] execInstRules;
		public FixMatchRules[] matchRules;
		public FixMarketDataFeedTypes[] marketDataFeedTypes;
	
	public FixTradingSessionRules() {
		this(false);
	}

	public FixTradingSessionRules(boolean isRequired) {
		super(FixTags.ORDTYPE_INT);

		this.isRequired = isRequired;
		
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
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !ordTypeRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
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
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !timeInForceRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
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
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !execInstRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
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
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !matchRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
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
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !marketDataFeedTypes[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
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
		for (FixOrdTypeRules fixOrdTypeRules : ordTypeRules) fixOrdTypeRules.clear();
		for (FixTimeInForceRules fixTimeInForceRules : timeInForceRules) fixTimeInForceRules.clear();
		for (FixExecInstRules fixExecInstRules : execInstRules) fixExecInstRules.clear();
		for (FixMatchRules fixMatchRules : matchRules) fixMatchRules.clear();
		for (FixMarketDataFeedTypes fixMarketDataFeedTypes : marketDataFeedTypes) fixMarketDataFeedTypes.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (FixUtils.getNoInGroup(ordTypeRules)>0) {
			out.put(FixTags.NOORDTYPERULES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(ordTypeRules));

			out.put(FixUtils.SOH);

		}
		for (FixOrdTypeRules fixOrdTypeRules : ordTypeRules) if (fixOrdTypeRules.hasGroup()) fixOrdTypeRules.encode(out);
		if (FixUtils.getNoInGroup(timeInForceRules)>0) {
			out.put(FixTags.NOTIMEINFORCERULES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(timeInForceRules));

			out.put(FixUtils.SOH);

		}
		for (FixTimeInForceRules fixTimeInForceRules : timeInForceRules) if (fixTimeInForceRules.hasGroup()) fixTimeInForceRules.encode(out);
		if (FixUtils.getNoInGroup(execInstRules)>0) {
			out.put(FixTags.NOEXECINSTRULES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(execInstRules));

			out.put(FixUtils.SOH);

		}
		for (FixExecInstRules fixExecInstRules : execInstRules) if (fixExecInstRules.hasGroup()) fixExecInstRules.encode(out);
		if (FixUtils.getNoInGroup(matchRules)>0) {
			out.put(FixTags.NOMATCHRULES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(matchRules));

			out.put(FixUtils.SOH);

		}
		for (FixMatchRules fixMatchRules : matchRules) if (fixMatchRules.hasGroup()) fixMatchRules.encode(out);
		if (FixUtils.getNoInGroup(marketDataFeedTypes)>0) {
			out.put(FixTags.NOMDFEEDTYPES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(marketDataFeedTypes));

			out.put(FixUtils.SOH);

		}
		for (FixMarketDataFeedTypes fixMarketDataFeedTypes : marketDataFeedTypes) if (fixMarketDataFeedTypes.hasGroup()) fixMarketDataFeedTypes.encode(out);
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

		for (int i = 0; i < ordTypeRules.length; i++)
			if (!ordTypeRules[i].equals(msg.ordTypeRules[i])) return false;
		for (int i = 0; i < timeInForceRules.length; i++)
			if (!timeInForceRules[i].equals(msg.timeInForceRules[i])) return false;
		for (int i = 0; i < execInstRules.length; i++)
			if (!execInstRules[i].equals(msg.execInstRules[i])) return false;
		for (int i = 0; i < matchRules.length; i++)
			if (!matchRules[i].equals(msg.matchRules[i])) return false;
		for (int i = 0; i < marketDataFeedTypes.length; i++)
			if (!marketDataFeedTypes[i].equals(msg.marketDataFeedTypes[i])) return false;
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
