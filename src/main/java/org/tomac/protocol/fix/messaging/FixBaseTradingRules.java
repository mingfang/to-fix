package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixBaseTradingRules extends FixGroup {
	private short hasExpirationCycle;
	long expirationCycle = 0;		
	private short hasMinTradeVol;
	long minTradeVol = 0;		
	private short hasMaxTradeVol;
	long maxTradeVol = 0;		
	private short hasMaxPriceVariation;
	long maxPriceVariation = 0;		
	private short hasImpliedMarketIndicator;
	long impliedMarketIndicator = 0;		
	private short hasTradingCurrency;
	byte[] tradingCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasRoundLot;
	long roundLot = 0;		
	private short hasMultilegModel;
	long multilegModel = 0;		
	private short hasMultilegPriceMethod;
	long multilegPriceMethod = 0;		
	private short hasPriceType;
	long priceType = 0;		
		public FixTickRules[] tickRules;
		public FixLotTypeRules[] lotTypeRules;
		public FixPriceLimits priceLimits;
	
	public FixBaseTradingRules() {
		this(false);
	}

	public FixBaseTradingRules(boolean isRequired) {
		super(FixTags.EXPIRATIONCYCLE_INT);

		this.isRequired = isRequired;
		
		hasExpirationCycle = FixUtils.TAG_HAS_NO_VALUE;		
		hasMinTradeVol = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxTradeVol = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxPriceVariation = FixUtils.TAG_HAS_NO_VALUE;		
		hasImpliedMarketIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradingCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		tradingCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasRoundLot = FixUtils.TAG_HAS_NO_VALUE;		
		hasMultilegModel = FixUtils.TAG_HAS_NO_VALUE;		
		hasMultilegPriceMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		tickRules = new FixTickRules[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) tickRules[i] = new FixTickRules();
		lotTypeRules = new FixLotTypeRules[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) lotTypeRules[i] = new FixLotTypeRules();
		priceLimits = new FixPriceLimits();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasExpirationCycle()) return true;
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
            	case FixTags.EXPIRATIONCYCLE_INT:		
            		hasExpirationCycle = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MINTRADEVOL_INT:		
            		hasMinTradeVol = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MAXTRADEVOL_INT:		
            		hasMaxTradeVol = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MAXPRICEVARIATION_INT:		
            		hasMaxPriceVariation = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.IMPLIEDMARKETINDICATOR_INT:		
            		hasImpliedMarketIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADINGCURRENCY_INT:		
            		hasTradingCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ROUNDLOT_INT:		
            		hasRoundLot = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MULTILEGMODEL_INT:		
            		hasMultilegModel = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MULTILEGPRICEMETHOD_INT:		
            		hasMultilegPriceMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PRICETYPE_INT:		
            		hasPriceType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOTICKRULES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !tickRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = tickRules[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOLOTTYPERULES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !lotTypeRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = lotTypeRules[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( priceLimits.isKeyTag(tag)) {
        				tag = priceLimits.setBuffer( tag, buf, err);		
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
		hasExpirationCycle = FixUtils.TAG_HAS_NO_VALUE;
		hasMinTradeVol = FixUtils.TAG_HAS_NO_VALUE;
		hasMaxTradeVol = FixUtils.TAG_HAS_NO_VALUE;
		hasMaxPriceVariation = FixUtils.TAG_HAS_NO_VALUE;
		hasImpliedMarketIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasTradingCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasRoundLot = FixUtils.TAG_HAS_NO_VALUE;
		hasMultilegModel = FixUtils.TAG_HAS_NO_VALUE;
		hasMultilegPriceMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;
		for (FixTickRules fixTickRules : tickRules) fixTickRules.clear();
		for (FixLotTypeRules fixLotTypeRules : lotTypeRules) fixLotTypeRules.clear();
		priceLimits.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasExpirationCycle()) {		
			out.put(FixTags.EXPIRATIONCYCLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)expirationCycle);
		
			out.put(FixUtils.SOH);

            }

		if (hasMinTradeVol()) {		
			out.put(FixTags.MINTRADEVOL);

			out.put((byte) '=');

			FixUtils.put(out, (long)minTradeVol);
		
			out.put(FixUtils.SOH);

            }

		if (hasMaxTradeVol()) {		
			out.put(FixTags.MAXTRADEVOL);

			out.put((byte) '=');

			FixUtils.put(out, (long)maxTradeVol);
		
			out.put(FixUtils.SOH);

            }

		if (hasMaxPriceVariation()) {		
			out.put(FixTags.MAXPRICEVARIATION);

			out.put((byte) '=');

			FixUtils.put(out, (long)maxPriceVariation);
		
			out.put(FixUtils.SOH);

            }

		if (hasImpliedMarketIndicator()) {		
			out.put(FixTags.IMPLIEDMARKETINDICATOR);

			out.put((byte) '=');

			FixUtils.put(out, (long)impliedMarketIndicator);
		
			out.put(FixUtils.SOH);

            }

		if (hasTradingCurrency()) {		
			out.put(FixTags.TRADINGCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,tradingCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRoundLot()) {		
			out.put(FixTags.ROUNDLOT);

			out.put((byte) '=');

			FixUtils.put(out, (long)roundLot);
		
			out.put(FixUtils.SOH);

            }

		if (hasMultilegModel()) {		
			out.put(FixTags.MULTILEGMODEL);

			out.put((byte) '=');

			FixUtils.put(out, (long)multilegModel);
		
			out.put(FixUtils.SOH);

            }

		if (hasMultilegPriceMethod()) {		
			out.put(FixTags.MULTILEGPRICEMETHOD);

			out.put((byte) '=');

			FixUtils.put(out, (long)multilegPriceMethod);
		
			out.put(FixUtils.SOH);

            }

		if (hasPriceType()) {		
			out.put(FixTags.PRICETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)priceType);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(tickRules)>0) {
			out.put(FixTags.NOTICKRULES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(tickRules));

			out.put(FixUtils.SOH);

		}
		for (FixTickRules fixTickRules : tickRules) if (fixTickRules.hasGroup()) fixTickRules.encode(out);
		if (FixUtils.getNoInGroup(lotTypeRules)>0) {
			out.put(FixTags.NOLOTTYPERULES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(lotTypeRules));

			out.put(FixUtils.SOH);

		}
		for (FixLotTypeRules fixLotTypeRules : lotTypeRules) if (fixLotTypeRules.hasGroup()) fixLotTypeRules.encode(out);
		priceLimits.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasExpirationCycle()) {		
			FixUtils.put(out, (long)expirationCycle);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMinTradeVol()) {		
			FixUtils.put(out, (long)minTradeVol);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaxTradeVol()) {		
			FixUtils.put(out, (long)maxTradeVol);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaxPriceVariation()) {		
			FixUtils.put(out, (long)maxPriceVariation);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasImpliedMarketIndicator()) {		
			FixUtils.put(out, (long)impliedMarketIndicator);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingCurrency()) {		
			FixUtils.put(out,tradingCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRoundLot()) {		
			FixUtils.put(out, (long)roundLot);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMultilegModel()) {		
			FixUtils.put(out, (long)multilegModel);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMultilegPriceMethod()) {		
			FixUtils.put(out, (long)multilegPriceMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceType()) {		
			FixUtils.put(out, (long)priceType);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixTickRules fixTickRules : tickRules) fixTickRules.printBuffer(out);
		for (FixLotTypeRules fixLotTypeRules : lotTypeRules) fixLotTypeRules.printBuffer(out);
		priceLimits.printBuffer(out);
	}

	public long getExpirationCycle() { 		
		if ( hasExpirationCycle()) {		
			if (hasExpirationCycle == FixUtils.TAG_HAS_VALUE) {		
				return expirationCycle; 		
			} else {		
		
				buf.position(hasExpirationCycle);		
		
			expirationCycle = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasExpirationCycle);		
					return 0;		
				}		
			}		
			hasExpirationCycle = FixUtils.TAG_HAS_VALUE;		
			return expirationCycle;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasExpirationCycle() { return hasExpirationCycle != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setExpirationCycle(long src) {		
		expirationCycle = src;
		hasExpirationCycle = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExpirationCycle(byte[] src) {		
		if (src == null ) return;
		if (hasExpirationCycle()) expirationCycle = FixUtils.TAG_HAS_NO_VALUE;		
		expirationCycle = FixUtils.longValueOf(src, 0, src.length);
		hasExpirationCycle = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setExpirationCycle(String str) {		
		if (str == null ) return;
		if (hasExpirationCycle()) expirationCycle = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		expirationCycle = FixUtils.longValueOf(src, 0, src.length);
		hasExpirationCycle = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMinTradeVol() { 		
		if ( hasMinTradeVol()) {		
			if (hasMinTradeVol == FixUtils.TAG_HAS_VALUE) {		
				return minTradeVol; 		
			} else {		
		
				buf.position(hasMinTradeVol);		
		
			minTradeVol = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMinTradeVol);		
					return 0;		
				}		
			}		
			hasMinTradeVol = FixUtils.TAG_HAS_VALUE;		
			return minTradeVol;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMinTradeVol() { return hasMinTradeVol != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMinTradeVol(long src) {		
		minTradeVol = src;
		hasMinTradeVol = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinTradeVol(byte[] src) {		
		if (src == null ) return;
		if (hasMinTradeVol()) minTradeVol = FixUtils.TAG_HAS_NO_VALUE;		
		minTradeVol = FixUtils.longValueOf(src, 0, src.length);
		hasMinTradeVol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMinTradeVol(String str) {		
		if (str == null ) return;
		if (hasMinTradeVol()) minTradeVol = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		minTradeVol = FixUtils.longValueOf(src, 0, src.length);
		hasMinTradeVol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMaxTradeVol() { 		
		if ( hasMaxTradeVol()) {		
			if (hasMaxTradeVol == FixUtils.TAG_HAS_VALUE) {		
				return maxTradeVol; 		
			} else {		
		
				buf.position(hasMaxTradeVol);		
		
			maxTradeVol = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMaxTradeVol);		
					return 0;		
				}		
			}		
			hasMaxTradeVol = FixUtils.TAG_HAS_VALUE;		
			return maxTradeVol;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxTradeVol() { return hasMaxTradeVol != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMaxTradeVol(long src) {		
		maxTradeVol = src;
		hasMaxTradeVol = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxTradeVol(byte[] src) {		
		if (src == null ) return;
		if (hasMaxTradeVol()) maxTradeVol = FixUtils.TAG_HAS_NO_VALUE;		
		maxTradeVol = FixUtils.longValueOf(src, 0, src.length);
		hasMaxTradeVol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMaxTradeVol(String str) {		
		if (str == null ) return;
		if (hasMaxTradeVol()) maxTradeVol = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxTradeVol = FixUtils.longValueOf(src, 0, src.length);
		hasMaxTradeVol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMaxPriceVariation() { 		
		if ( hasMaxPriceVariation()) {		
			if (hasMaxPriceVariation == FixUtils.TAG_HAS_VALUE) {		
				return maxPriceVariation; 		
			} else {		
		
				buf.position(hasMaxPriceVariation);		
		
			maxPriceVariation = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMaxPriceVariation);		
					return 0;		
				}		
			}		
			hasMaxPriceVariation = FixUtils.TAG_HAS_VALUE;		
			return maxPriceVariation;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxPriceVariation() { return hasMaxPriceVariation != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMaxPriceVariation(long src) {		
		maxPriceVariation = src;
		hasMaxPriceVariation = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxPriceVariation(byte[] src) {		
		if (src == null ) return;
		if (hasMaxPriceVariation()) maxPriceVariation = FixUtils.TAG_HAS_NO_VALUE;		
		maxPriceVariation = FixUtils.longValueOf(src, 0, src.length);
		hasMaxPriceVariation = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMaxPriceVariation(String str) {		
		if (str == null ) return;
		if (hasMaxPriceVariation()) maxPriceVariation = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxPriceVariation = FixUtils.longValueOf(src, 0, src.length);
		hasMaxPriceVariation = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getImpliedMarketIndicator() { 		
		if ( hasImpliedMarketIndicator()) {		
			if (hasImpliedMarketIndicator == FixUtils.TAG_HAS_VALUE) {		
				return impliedMarketIndicator; 		
			} else {		
		
				buf.position(hasImpliedMarketIndicator);		
		
			impliedMarketIndicator = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasImpliedMarketIndicator);		
					return 0;		
				}		
			}		
			hasImpliedMarketIndicator = FixUtils.TAG_HAS_VALUE;		
			return impliedMarketIndicator;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasImpliedMarketIndicator() { return hasImpliedMarketIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setImpliedMarketIndicator(long src) {		
		impliedMarketIndicator = src;
		hasImpliedMarketIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setImpliedMarketIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasImpliedMarketIndicator()) impliedMarketIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		impliedMarketIndicator = FixUtils.longValueOf(src, 0, src.length);
		hasImpliedMarketIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setImpliedMarketIndicator(String str) {		
		if (str == null ) return;
		if (hasImpliedMarketIndicator()) impliedMarketIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		impliedMarketIndicator = FixUtils.longValueOf(src, 0, src.length);
		hasImpliedMarketIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradingCurrency() { 		
		if ( hasTradingCurrency()) {		
			if (hasTradingCurrency == FixUtils.TAG_HAS_VALUE) {		
				return tradingCurrency; 		
			} else {		
		
				buf.position(hasTradingCurrency);		
		
			FixUtils.getTagStringValue(buf, tradingCurrency, 0, tradingCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradingCurrency);		
					return null;		
				}		
			}		
			hasTradingCurrency = FixUtils.TAG_HAS_VALUE;		
			return tradingCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingCurrency() { return hasTradingCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradingCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasTradingCurrency()) FixUtils.fillNul(tradingCurrency);		
		FixUtils.copy(tradingCurrency, src); 		
		hasTradingCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradingCurrency(String str) {		
		if (str == null ) return;
		if (hasTradingCurrency()) FixUtils.fillNul(tradingCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingCurrency, src); 		
		hasTradingCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRoundLot() { 		
		if ( hasRoundLot()) {		
			if (hasRoundLot == FixUtils.TAG_HAS_VALUE) {		
				return roundLot; 		
			} else {		
		
				buf.position(hasRoundLot);		
		
			roundLot = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRoundLot);		
					return 0;		
				}		
			}		
			hasRoundLot = FixUtils.TAG_HAS_VALUE;		
			return roundLot;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRoundLot() { return hasRoundLot != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRoundLot(long src) {		
		roundLot = src;
		hasRoundLot = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRoundLot(byte[] src) {		
		if (src == null ) return;
		if (hasRoundLot()) roundLot = FixUtils.TAG_HAS_NO_VALUE;		
		roundLot = FixUtils.longValueOf(src, 0, src.length);
		hasRoundLot = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRoundLot(String str) {		
		if (str == null ) return;
		if (hasRoundLot()) roundLot = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		roundLot = FixUtils.longValueOf(src, 0, src.length);
		hasRoundLot = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMultilegModel() { 		
		if ( hasMultilegModel()) {		
			if (hasMultilegModel == FixUtils.TAG_HAS_VALUE) {		
				return multilegModel; 		
			} else {		
		
				buf.position(hasMultilegModel);		
		
			multilegModel = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMultilegModel);		
					return 0;		
				}		
			}		
			hasMultilegModel = FixUtils.TAG_HAS_VALUE;		
			return multilegModel;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMultilegModel() { return hasMultilegModel != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMultilegModel(long src) {		
		multilegModel = src;
		hasMultilegModel = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMultilegModel(byte[] src) {		
		if (src == null ) return;
		if (hasMultilegModel()) multilegModel = FixUtils.TAG_HAS_NO_VALUE;		
		multilegModel = FixUtils.longValueOf(src, 0, src.length);
		hasMultilegModel = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMultilegModel(String str) {		
		if (str == null ) return;
		if (hasMultilegModel()) multilegModel = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		multilegModel = FixUtils.longValueOf(src, 0, src.length);
		hasMultilegModel = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMultilegPriceMethod() { 		
		if ( hasMultilegPriceMethod()) {		
			if (hasMultilegPriceMethod == FixUtils.TAG_HAS_VALUE) {		
				return multilegPriceMethod; 		
			} else {		
		
				buf.position(hasMultilegPriceMethod);		
		
			multilegPriceMethod = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMultilegPriceMethod);		
					return 0;		
				}		
			}		
			hasMultilegPriceMethod = FixUtils.TAG_HAS_VALUE;		
			return multilegPriceMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMultilegPriceMethod() { return hasMultilegPriceMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMultilegPriceMethod(long src) {		
		multilegPriceMethod = src;
		hasMultilegPriceMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMultilegPriceMethod(byte[] src) {		
		if (src == null ) return;
		if (hasMultilegPriceMethod()) multilegPriceMethod = FixUtils.TAG_HAS_NO_VALUE;		
		multilegPriceMethod = FixUtils.longValueOf(src, 0, src.length);
		hasMultilegPriceMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMultilegPriceMethod(String str) {		
		if (str == null ) return;
		if (hasMultilegPriceMethod()) multilegPriceMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		multilegPriceMethod = FixUtils.longValueOf(src, 0, src.length);
		hasMultilegPriceMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPriceType() { 		
		if ( hasPriceType()) {		
			if (hasPriceType == FixUtils.TAG_HAS_VALUE) {		
				return priceType; 		
			} else {		
		
				buf.position(hasPriceType);		
		
			priceType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPriceType);		
					return 0;		
				}		
			}		
			hasPriceType = FixUtils.TAG_HAS_VALUE;		
			return priceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriceType() { return hasPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPriceType(long src) {		
		priceType = src;
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasPriceType()) priceType = FixUtils.TAG_HAS_NO_VALUE;		
		priceType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPriceType(String str) {		
		if (str == null ) return;
		if (hasPriceType()) priceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priceType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasExpirationCycle()) s += "ExpirationCycle(827)= " + getExpirationCycle() + "\n" ; 
		if (hasMinTradeVol()) s += "MinTradeVol(562)= " + getMinTradeVol() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMaxTradeVol()) s += "MaxTradeVol(1140)= " + getMaxTradeVol() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMaxPriceVariation()) s += "MaxPriceVariation(1143)= " + getMaxPriceVariation() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasImpliedMarketIndicator()) s += "ImpliedMarketIndicator(1144)= " + getImpliedMarketIndicator() + "\n" ; 
		if (hasTradingCurrency()) s += "TradingCurrency(1245)= " + new String( FixUtils.trim(getTradingCurrency()) ) + "\n" ; 
		if (hasRoundLot()) s += "RoundLot(561)= " + getRoundLot() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMultilegModel()) s += "MultilegModel(1377)= " + getMultilegModel() + "\n" ; 
		if (hasMultilegPriceMethod()) s += "MultilegPriceMethod(1378)= " + getMultilegPriceMethod() + "\n" ; 
		if (hasPriceType()) s += "PriceType(423)= " + getPriceType() + "\n" ; 

		for (FixTickRules fixTickRules : tickRules) fixTickRules.toString();
		for (FixLotTypeRules fixLotTypeRules : lotTypeRules) fixLotTypeRules.toString();
		s += priceLimits.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixBaseTradingRules)) return false;

		FixBaseTradingRules msg = (FixBaseTradingRules) o;

		for (int i = 0; i < tickRules.length; i++)
			if (!tickRules[i].equals(msg.tickRules[i])) return false;
		for (int i = 0; i < lotTypeRules.length; i++)
			if (!lotTypeRules[i].equals(msg.lotTypeRules[i])) return false;
		if (!priceLimits.equals(msg.priceLimits)) return false;
		if ((hasExpirationCycle() && !msg.hasExpirationCycle()) || (!hasExpirationCycle() && msg.hasExpirationCycle())) return false;
		if (!(!hasExpirationCycle() && !msg.hasExpirationCycle()) && !(getExpirationCycle()==msg.getExpirationCycle())) return false;
		if ((hasMinTradeVol() && !msg.hasMinTradeVol()) || (!hasMinTradeVol() && msg.hasMinTradeVol())) return false;
		if (!(!hasMinTradeVol() && !msg.hasMinTradeVol()) && !(getMinTradeVol()==msg.getMinTradeVol())) return false;
		if ((hasMaxTradeVol() && !msg.hasMaxTradeVol()) || (!hasMaxTradeVol() && msg.hasMaxTradeVol())) return false;
		if (!(!hasMaxTradeVol() && !msg.hasMaxTradeVol()) && !(getMaxTradeVol()==msg.getMaxTradeVol())) return false;
		if ((hasMaxPriceVariation() && !msg.hasMaxPriceVariation()) || (!hasMaxPriceVariation() && msg.hasMaxPriceVariation())) return false;
		if (!(!hasMaxPriceVariation() && !msg.hasMaxPriceVariation()) && !(getMaxPriceVariation()==msg.getMaxPriceVariation())) return false;
		if ((hasImpliedMarketIndicator() && !msg.hasImpliedMarketIndicator()) || (!hasImpliedMarketIndicator() && msg.hasImpliedMarketIndicator())) return false;
		if (!(!hasImpliedMarketIndicator() && !msg.hasImpliedMarketIndicator()) && !(getImpliedMarketIndicator()==msg.getImpliedMarketIndicator())) return false;
		if ((hasTradingCurrency() && !msg.hasTradingCurrency()) || (!hasTradingCurrency() && msg.hasTradingCurrency())) return false;
		if (!(!hasTradingCurrency() && !msg.hasTradingCurrency()) && !FixUtils.equals(getTradingCurrency(), msg.getTradingCurrency())) return false;
		if ((hasRoundLot() && !msg.hasRoundLot()) || (!hasRoundLot() && msg.hasRoundLot())) return false;
		if (!(!hasRoundLot() && !msg.hasRoundLot()) && !(getRoundLot()==msg.getRoundLot())) return false;
		if ((hasMultilegModel() && !msg.hasMultilegModel()) || (!hasMultilegModel() && msg.hasMultilegModel())) return false;
		if (!(!hasMultilegModel() && !msg.hasMultilegModel()) && !(getMultilegModel()==msg.getMultilegModel())) return false;
		if ((hasMultilegPriceMethod() && !msg.hasMultilegPriceMethod()) || (!hasMultilegPriceMethod() && msg.hasMultilegPriceMethod())) return false;
		if (!(!hasMultilegPriceMethod() && !msg.hasMultilegPriceMethod()) && !(getMultilegPriceMethod()==msg.getMultilegPriceMethod())) return false;
		if ((hasPriceType() && !msg.hasPriceType()) || (!hasPriceType() && msg.hasPriceType())) return false;
		if (!(!hasPriceType() && !msg.hasPriceType()) && !(getPriceType()==msg.getPriceType())) return false;
		return true;
	}
	public FixBaseTradingRules clone ( FixBaseTradingRules out ) {
		if ( hasExpirationCycle())
			out.setExpirationCycle(getExpirationCycle());
		if ( hasMinTradeVol())
			out.setMinTradeVol(getMinTradeVol());
		if ( hasMaxTradeVol())
			out.setMaxTradeVol(getMaxTradeVol());
		if ( hasMaxPriceVariation())
			out.setMaxPriceVariation(getMaxPriceVariation());
		if ( hasImpliedMarketIndicator())
			out.setImpliedMarketIndicator(getImpliedMarketIndicator());
		if ( hasTradingCurrency())
			out.setTradingCurrency(getTradingCurrency());
		if ( hasRoundLot())
			out.setRoundLot(getRoundLot());
		if ( hasMultilegModel())
			out.setMultilegModel(getMultilegModel());
		if ( hasMultilegPriceMethod())
			out.setMultilegPriceMethod(getMultilegPriceMethod());
		if ( hasPriceType())
			out.setPriceType(getPriceType());
		int count = 0;
		count = 0;
		for (FixTickRules fixTickRules : tickRules) {
			if (!fixTickRules.hasGroup()) continue;
			out.tickRules[count] = fixTickRules.clone( out.tickRules[count] );
			count++;
		}
		count = 0;
		for (FixLotTypeRules fixLotTypeRules : lotTypeRules) {
			if (!fixLotTypeRules.hasGroup()) continue;
			out.lotTypeRules[count] = fixLotTypeRules.clone( out.lotTypeRules[count] );
			count++;
		}
		if (priceLimits.hasGroup())
			out.priceLimits = priceLimits.clone( out.priceLimits);
		return out;
	}

}
