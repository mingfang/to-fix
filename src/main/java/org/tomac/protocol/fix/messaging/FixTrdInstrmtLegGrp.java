package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTrdInstrmtLegGrp extends FixGroup {
	private short hasLegQty;
	long legQty = 0;		
	private short hasLegSwapType;
	long legSwapType = 0;		
	private short hasLegReportID;
	byte[] legReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegNumber;
	long legNumber = 0;		
	private short hasLegPositionEffect;
	byte legPositionEffect = (byte)' ';		
	private short hasLegCoveredOrUncovered;
	long legCoveredOrUncovered = 0;		
	private short hasLegRefID;
	byte[] legRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegSettlType;
	byte legSettlType = (byte)' ';		
	private short hasLegSettlDate;
	byte[] legSettlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegLastPx;
	long legLastPx = 0;		
	private short hasLegSettlCurrency;
	byte[] legSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasLegLastForwardPoints;
	long legLastForwardPoints = 0;		
	private short hasLegCalculatedCcyLastQty;
	long legCalculatedCcyLastQty = 0;		
	private short hasLegGrossTradeAmt;
	long legGrossTradeAmt = 0;		
	private short hasLegVolatility;
	long legVolatility = 0;		
	private short hasLegDividendYield;
	long legDividendYield = 0;		
	private short hasLegCurrencyRatio;
	long legCurrencyRatio = 0;		
	private short hasLegExecInst;
	byte[] legExecInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegLastQty;
	long legLastQty = 0;		
		public FixInstrumentLeg instrumentLeg;
		public FixLegStipulations[] legStipulations;
		public FixNestedParties[] nestedParties;
		public FixTradeCapLegUnderlyingsGrp[] tradeCapLegUnderlyingsGrp;
	
	public FixTrdInstrmtLegGrp() {
		this(false);
	}

	public FixTrdInstrmtLegGrp(boolean isRequired) {
		super(FixTags.LEGSYMBOL_INT);

		this.isRequired = isRequired;
		
		hasLegQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegSwapType = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegReportID = FixUtils.TAG_HAS_NO_VALUE;		
		legReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegNumber = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegPositionEffect = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegCoveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegRefID = FixUtils.TAG_HAS_NO_VALUE;		
		legRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		legSettlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegLastPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		legSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasLegLastForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegCalculatedCcyLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegGrossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegVolatility = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegDividendYield = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegCurrencyRatio = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegExecInst = FixUtils.TAG_HAS_NO_VALUE;		
		legExecInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		instrumentLeg = new FixInstrumentLeg();
		legStipulations = new FixLegStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) legStipulations[i] = new FixLegStipulations();
		nestedParties = new FixNestedParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedParties[i] = new FixNestedParties();
		tradeCapLegUnderlyingsGrp = new FixTradeCapLegUnderlyingsGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) tradeCapLegUnderlyingsGrp[i] = new FixTradeCapLegUnderlyingsGrp();
		
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
            	case FixTags.LEGQTY_INT:		
            		hasLegQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSWAPTYPE_INT:		
            		hasLegSwapType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGREPORTID_INT:		
            		hasLegReportID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGNUMBER_INT:		
            		hasLegNumber = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGPOSITIONEFFECT_INT:		
            		hasLegPositionEffect = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGCOVEREDORUNCOVERED_INT:		
            		hasLegCoveredOrUncovered = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGREFID_INT:		
            		hasLegRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSETTLTYPE_INT:		
            		hasLegSettlType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSETTLDATE_INT:		
            		hasLegSettlDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGLASTPX_INT:		
            		hasLegLastPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSETTLCURRENCY_INT:		
            		hasLegSettlCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGLASTFORWARDPOINTS_INT:		
            		hasLegLastForwardPoints = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGCALCULATEDCCYLASTQTY_INT:		
            		hasLegCalculatedCcyLastQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGGROSSTRADEAMT_INT:		
            		hasLegGrossTradeAmt = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGVOLATILITY_INT:		
            		hasLegVolatility = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGDIVIDENDYIELD_INT:		
            		hasLegDividendYield = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGCURRENCYRATIO_INT:		
            		hasLegCurrencyRatio = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGEXECINST_INT:		
            		hasLegExecInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGLASTQTY_INT:		
            		hasLegLastQty = (short) buf.position();		
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
        			} else if ( tag == FixTags.NONESTEDPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !nestedParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = nestedParties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOOFLEGUNDERLYINGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !tradeCapLegUnderlyingsGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = tradeCapLegUnderlyingsGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasLegQty = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSwapType = FixUtils.TAG_HAS_NO_VALUE;
		hasLegReportID = FixUtils.TAG_HAS_NO_VALUE;
		hasLegNumber = FixUtils.TAG_HAS_NO_VALUE;
		hasLegPositionEffect = FixUtils.TAG_HAS_NO_VALUE;
		hasLegCoveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;
		hasLegRefID = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSettlType = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSettlDate = FixUtils.TAG_HAS_NO_VALUE;
		hasLegLastPx = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasLegLastForwardPoints = FixUtils.TAG_HAS_NO_VALUE;
		hasLegCalculatedCcyLastQty = FixUtils.TAG_HAS_NO_VALUE;
		hasLegGrossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;
		hasLegVolatility = FixUtils.TAG_HAS_NO_VALUE;
		hasLegDividendYield = FixUtils.TAG_HAS_NO_VALUE;
		hasLegCurrencyRatio = FixUtils.TAG_HAS_NO_VALUE;
		hasLegExecInst = FixUtils.TAG_HAS_NO_VALUE;
		hasLegLastQty = FixUtils.TAG_HAS_NO_VALUE;
		instrumentLeg.clear();
		for (FixLegStipulations fixLegStipulations : legStipulations) fixLegStipulations.clear();
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.clear();
		for (FixTradeCapLegUnderlyingsGrp fixTradeCapLegUnderlyingsGrp : tradeCapLegUnderlyingsGrp) fixTradeCapLegUnderlyingsGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasLegQty()) {		
			out.put(FixTags.LEGQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)legQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSwapType()) {		
			out.put(FixTags.LEGSWAPTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)legSwapType);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegReportID()) {		
			out.put(FixTags.LEGREPORTID);

			out.put((byte) '=');

			FixUtils.put(out,legReportID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegNumber()) {		
			out.put(FixTags.LEGNUMBER);

			out.put((byte) '=');

			FixUtils.put(out, (long)legNumber);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegPositionEffect()) {		
			out.put(FixTags.LEGPOSITIONEFFECT);

			out.put((byte) '=');

			FixUtils.put(out,legPositionEffect); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegCoveredOrUncovered()) {		
			out.put(FixTags.LEGCOVEREDORUNCOVERED);

			out.put((byte) '=');

			FixUtils.put(out, (long)legCoveredOrUncovered);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegRefID()) {		
			out.put(FixTags.LEGREFID);

			out.put((byte) '=');

			FixUtils.put(out,legRefID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSettlType()) {		
			out.put(FixTags.LEGSETTLTYPE);

			out.put((byte) '=');

			FixUtils.put(out,legSettlType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSettlDate()) {		
			out.put(FixTags.LEGSETTLDATE);

			out.put((byte) '=');

			FixUtils.put(out,legSettlDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegLastPx()) {		
			out.put(FixTags.LEGLASTPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)legLastPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegSettlCurrency()) {		
			out.put(FixTags.LEGSETTLCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,legSettlCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegLastForwardPoints()) {		
			out.put(FixTags.LEGLASTFORWARDPOINTS);

			out.put((byte) '=');

			FixUtils.put(out, (long)legLastForwardPoints);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegCalculatedCcyLastQty()) {		
			out.put(FixTags.LEGCALCULATEDCCYLASTQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)legCalculatedCcyLastQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegGrossTradeAmt()) {		
			out.put(FixTags.LEGGROSSTRADEAMT);

			out.put((byte) '=');

			FixUtils.put(out, (long)legGrossTradeAmt);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegVolatility()) {		
			out.put(FixTags.LEGVOLATILITY);

			out.put((byte) '=');

			FixUtils.put(out, (long)legVolatility);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegDividendYield()) {		
			out.put(FixTags.LEGDIVIDENDYIELD);

			out.put((byte) '=');

			FixUtils.put(out, (long)legDividendYield);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegCurrencyRatio()) {		
			out.put(FixTags.LEGCURRENCYRATIO);

			out.put((byte) '=');

			FixUtils.put(out, (long)legCurrencyRatio);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegExecInst()) {		
			out.put(FixTags.LEGEXECINST);

			out.put((byte) '=');

			FixUtils.put(out,legExecInst); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegLastQty()) {		
			out.put(FixTags.LEGLASTQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)legLastQty);
		
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
		if (FixUtils.getNoInGroup(nestedParties)>0) {
			out.put(FixTags.NONESTEDPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(nestedParties));

			out.put(FixUtils.SOH);

		}
		for (FixNestedParties fixNestedParties : nestedParties) if (fixNestedParties.hasGroup()) fixNestedParties.encode(out);
		if (FixUtils.getNoInGroup(tradeCapLegUnderlyingsGrp)>0) {
			out.put(FixTags.NOOFLEGUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(tradeCapLegUnderlyingsGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTradeCapLegUnderlyingsGrp fixTradeCapLegUnderlyingsGrp : tradeCapLegUnderlyingsGrp) if (fixTradeCapLegUnderlyingsGrp.hasGroup()) fixTradeCapLegUnderlyingsGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasLegQty()) {		
			FixUtils.put(out, (long)legQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSwapType()) {		
			FixUtils.put(out, (long)legSwapType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegReportID()) {		
			FixUtils.put(out,legReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegNumber()) {		
			FixUtils.put(out, (long)legNumber);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegPositionEffect()) {		
			FixUtils.put(out,legPositionEffect); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegCoveredOrUncovered()) {		
			FixUtils.put(out, (long)legCoveredOrUncovered);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegRefID()) {		
			FixUtils.put(out,legRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSettlType()) {		
			FixUtils.put(out,legSettlType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSettlDate()) {		
			FixUtils.put(out,legSettlDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegLastPx()) {		
			FixUtils.put(out, (long)legLastPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSettlCurrency()) {		
			FixUtils.put(out,legSettlCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegLastForwardPoints()) {		
			FixUtils.put(out, (long)legLastForwardPoints);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegCalculatedCcyLastQty()) {		
			FixUtils.put(out, (long)legCalculatedCcyLastQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegGrossTradeAmt()) {		
			FixUtils.put(out, (long)legGrossTradeAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegVolatility()) {		
			FixUtils.put(out, (long)legVolatility);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegDividendYield()) {		
			FixUtils.put(out, (long)legDividendYield);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegCurrencyRatio()) {		
			FixUtils.put(out, (long)legCurrencyRatio);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegExecInst()) {		
			FixUtils.put(out,legExecInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegLastQty()) {		
			FixUtils.put(out, (long)legLastQty);
		
	        out.put( (byte)' ' );		
		}		
		
		instrumentLeg.printBuffer(out);
		for (FixLegStipulations fixLegStipulations : legStipulations) fixLegStipulations.printBuffer(out);
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.printBuffer(out);
		for (FixTradeCapLegUnderlyingsGrp fixTradeCapLegUnderlyingsGrp : tradeCapLegUnderlyingsGrp) fixTradeCapLegUnderlyingsGrp.printBuffer(out);
	}

	public long getLegQty() { 		
		if ( hasLegQty()) {		
			if (hasLegQty == FixUtils.TAG_HAS_VALUE) {		
				return legQty; 		
			} else {		
		
				buf.position(hasLegQty);		
		
			legQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegQty);		
					return 0;		
				}		
			}		
			hasLegQty = FixUtils.TAG_HAS_VALUE;		
			return legQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegQty() { return hasLegQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegQty(long src) {		
		legQty = src;
		hasLegQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegQty(byte[] src) {		
		if (src == null ) return;
		if (hasLegQty()) legQty = FixUtils.TAG_HAS_NO_VALUE;		
		legQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegQty(String str) {		
		if (str == null ) return;
		if (hasLegQty()) legQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegSwapType() { 		
		if ( hasLegSwapType()) {		
			if (hasLegSwapType == FixUtils.TAG_HAS_VALUE) {		
				return legSwapType; 		
			} else {		
		
				buf.position(hasLegSwapType);		
		
			legSwapType = FixMessage.getTagIntValue(buf, err);
		
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
			
	public byte[] getLegReportID() { 		
		if ( hasLegReportID()) {		
			if (hasLegReportID == FixUtils.TAG_HAS_VALUE) {		
				return legReportID; 		
			} else {		
		
				buf.position(hasLegReportID);		
		
			FixMessage.getTagStringValue(buf, legReportID, 0, legReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegReportID);		
					return null;		
				}		
			}		
			hasLegReportID = FixUtils.TAG_HAS_VALUE;		
			return legReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegReportID() { return hasLegReportID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegReportID(byte[] src) {		
		if (src == null ) return;
		if (hasLegReportID()) FixUtils.fillSpace(legReportID);		
		FixUtils.copy(legReportID, src); 		
		hasLegReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegReportID(String str) {		
		if (str == null ) return;
		if (hasLegReportID()) FixUtils.fillSpace(legReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legReportID, src); 		
		hasLegReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegNumber() { 		
		if ( hasLegNumber()) {		
			if (hasLegNumber == FixUtils.TAG_HAS_VALUE) {		
				return legNumber; 		
			} else {		
		
				buf.position(hasLegNumber);		
		
			legNumber = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegNumber);		
					return 0;		
				}		
			}		
			hasLegNumber = FixUtils.TAG_HAS_VALUE;		
			return legNumber;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegNumber() { return hasLegNumber != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegNumber(long src) {		
		legNumber = src;
		hasLegNumber = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegNumber(byte[] src) {		
		if (src == null ) return;
		if (hasLegNumber()) legNumber = FixUtils.TAG_HAS_NO_VALUE;		
		legNumber = FixUtils.longValueOf(src, 0, src.length);
		hasLegNumber = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegNumber(String str) {		
		if (str == null ) return;
		if (hasLegNumber()) legNumber = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legNumber = FixUtils.longValueOf(src, 0, src.length);
		hasLegNumber = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getLegPositionEffect() { 		
		if ( hasLegPositionEffect()) {		
			if (hasLegPositionEffect == FixUtils.TAG_HAS_VALUE) {		
				return legPositionEffect; 		
			} else {		
		
				buf.position(hasLegPositionEffect);		
		
			legPositionEffect = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegPositionEffect);		
					return (byte)'0';		
				}		
			}		
			hasLegPositionEffect = FixUtils.TAG_HAS_VALUE;		
			return legPositionEffect;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasLegPositionEffect() { return hasLegPositionEffect != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegPositionEffect(byte src) {		
		legPositionEffect = src;
		hasLegPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegPositionEffect(byte[] src) {		
		if (src == null ) return;
		if (hasLegPositionEffect()) legPositionEffect = (byte)' ';		
		legPositionEffect = src[0];		
		hasLegPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegPositionEffect(String str) {		
		if (str == null ) return;
		if (hasLegPositionEffect()) legPositionEffect = (byte)' ';		
		byte[] src = str.getBytes(); 		
		legPositionEffect = src[0];		
		hasLegPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegCoveredOrUncovered() { 		
		if ( hasLegCoveredOrUncovered()) {		
			if (hasLegCoveredOrUncovered == FixUtils.TAG_HAS_VALUE) {		
				return legCoveredOrUncovered; 		
			} else {		
		
				buf.position(hasLegCoveredOrUncovered);		
		
			legCoveredOrUncovered = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegCoveredOrUncovered);		
					return 0;		
				}		
			}		
			hasLegCoveredOrUncovered = FixUtils.TAG_HAS_VALUE;		
			return legCoveredOrUncovered;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegCoveredOrUncovered() { return hasLegCoveredOrUncovered != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegCoveredOrUncovered(long src) {		
		legCoveredOrUncovered = src;
		hasLegCoveredOrUncovered = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegCoveredOrUncovered(byte[] src) {		
		if (src == null ) return;
		if (hasLegCoveredOrUncovered()) legCoveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;		
		legCoveredOrUncovered = FixUtils.longValueOf(src, 0, src.length);
		hasLegCoveredOrUncovered = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegCoveredOrUncovered(String str) {		
		if (str == null ) return;
		if (hasLegCoveredOrUncovered()) legCoveredOrUncovered = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legCoveredOrUncovered = FixUtils.longValueOf(src, 0, src.length);
		hasLegCoveredOrUncovered = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegRefID() { 		
		if ( hasLegRefID()) {		
			if (hasLegRefID == FixUtils.TAG_HAS_VALUE) {		
				return legRefID; 		
			} else {		
		
				buf.position(hasLegRefID);		
		
			FixMessage.getTagStringValue(buf, legRefID, 0, legRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegRefID);		
					return null;		
				}		
			}		
			hasLegRefID = FixUtils.TAG_HAS_VALUE;		
			return legRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegRefID() { return hasLegRefID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegRefID(byte[] src) {		
		if (src == null ) return;
		if (hasLegRefID()) FixUtils.fillSpace(legRefID);		
		FixUtils.copy(legRefID, src); 		
		hasLegRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegRefID(String str) {		
		if (str == null ) return;
		if (hasLegRefID()) FixUtils.fillSpace(legRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legRefID, src); 		
		hasLegRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getLegSettlType() { 		
		if ( hasLegSettlType()) {		
			if (hasLegSettlType == FixUtils.TAG_HAS_VALUE) {		
				return legSettlType; 		
			} else {		
		
				buf.position(hasLegSettlType);		
		
			legSettlType = FixMessage.getTagCharValue(buf, err);
		
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
			
	public byte[] getLegSettlDate() { 		
		if ( hasLegSettlDate()) {		
			if (hasLegSettlDate == FixUtils.TAG_HAS_VALUE) {		
				return legSettlDate; 		
			} else {		
		
				buf.position(hasLegSettlDate);		
		
			FixMessage.getTagStringValue(buf, legSettlDate, 0, legSettlDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSettlDate);		
					return null;		
				}		
			}		
			hasLegSettlDate = FixUtils.TAG_HAS_VALUE;		
			return legSettlDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegSettlDate() { return hasLegSettlDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSettlDate(byte[] src) {		
		if (src == null ) return;
		if (hasLegSettlDate()) FixUtils.fillSpace(legSettlDate);		
		FixUtils.copy(legSettlDate, src); 		
		hasLegSettlDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSettlDate(String str) {		
		if (str == null ) return;
		if (hasLegSettlDate()) FixUtils.fillSpace(legSettlDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSettlDate, src); 		
		hasLegSettlDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegLastPx() { 		
		if ( hasLegLastPx()) {		
			if (hasLegLastPx == FixUtils.TAG_HAS_VALUE) {		
				return legLastPx; 		
			} else {		
		
				buf.position(hasLegLastPx);		
		
			legLastPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegLastPx);		
					return 0;		
				}		
			}		
			hasLegLastPx = FixUtils.TAG_HAS_VALUE;		
			return legLastPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegLastPx() { return hasLegLastPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegLastPx(long src) {		
		legLastPx = src;
		hasLegLastPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegLastPx(byte[] src) {		
		if (src == null ) return;
		if (hasLegLastPx()) legLastPx = FixUtils.TAG_HAS_NO_VALUE;		
		legLastPx = FixUtils.longValueOf(src, 0, src.length);
		hasLegLastPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegLastPx(String str) {		
		if (str == null ) return;
		if (hasLegLastPx()) legLastPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legLastPx = FixUtils.longValueOf(src, 0, src.length);
		hasLegLastPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegSettlCurrency() { 		
		if ( hasLegSettlCurrency()) {		
			if (hasLegSettlCurrency == FixUtils.TAG_HAS_VALUE) {		
				return legSettlCurrency; 		
			} else {		
		
				buf.position(hasLegSettlCurrency);		
		
			FixMessage.getTagStringValue(buf, legSettlCurrency, 0, legSettlCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegSettlCurrency);		
					return null;		
				}		
			}		
			hasLegSettlCurrency = FixUtils.TAG_HAS_VALUE;		
			return legSettlCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegSettlCurrency() { return hasLegSettlCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegSettlCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasLegSettlCurrency()) FixUtils.fillSpace(legSettlCurrency);		
		FixUtils.copy(legSettlCurrency, src); 		
		hasLegSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSettlCurrency(String str) {		
		if (str == null ) return;
		if (hasLegSettlCurrency()) FixUtils.fillSpace(legSettlCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSettlCurrency, src); 		
		hasLegSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegLastForwardPoints() { 		
		if ( hasLegLastForwardPoints()) {		
			if (hasLegLastForwardPoints == FixUtils.TAG_HAS_VALUE) {		
				return legLastForwardPoints; 		
			} else {		
		
				buf.position(hasLegLastForwardPoints);		
		
			legLastForwardPoints = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegLastForwardPoints);		
					return 0;		
				}		
			}		
			hasLegLastForwardPoints = FixUtils.TAG_HAS_VALUE;		
			return legLastForwardPoints;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegLastForwardPoints() { return hasLegLastForwardPoints != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegLastForwardPoints(long src) {		
		legLastForwardPoints = src;
		hasLegLastForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegLastForwardPoints(byte[] src) {		
		if (src == null ) return;
		if (hasLegLastForwardPoints()) legLastForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		legLastForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasLegLastForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegLastForwardPoints(String str) {		
		if (str == null ) return;
		if (hasLegLastForwardPoints()) legLastForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legLastForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasLegLastForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegCalculatedCcyLastQty() { 		
		if ( hasLegCalculatedCcyLastQty()) {		
			if (hasLegCalculatedCcyLastQty == FixUtils.TAG_HAS_VALUE) {		
				return legCalculatedCcyLastQty; 		
			} else {		
		
				buf.position(hasLegCalculatedCcyLastQty);		
		
			legCalculatedCcyLastQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegCalculatedCcyLastQty);		
					return 0;		
				}		
			}		
			hasLegCalculatedCcyLastQty = FixUtils.TAG_HAS_VALUE;		
			return legCalculatedCcyLastQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegCalculatedCcyLastQty() { return hasLegCalculatedCcyLastQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegCalculatedCcyLastQty(long src) {		
		legCalculatedCcyLastQty = src;
		hasLegCalculatedCcyLastQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegCalculatedCcyLastQty(byte[] src) {		
		if (src == null ) return;
		if (hasLegCalculatedCcyLastQty()) legCalculatedCcyLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		legCalculatedCcyLastQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegCalculatedCcyLastQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegCalculatedCcyLastQty(String str) {		
		if (str == null ) return;
		if (hasLegCalculatedCcyLastQty()) legCalculatedCcyLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legCalculatedCcyLastQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegCalculatedCcyLastQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegGrossTradeAmt() { 		
		if ( hasLegGrossTradeAmt()) {		
			if (hasLegGrossTradeAmt == FixUtils.TAG_HAS_VALUE) {		
				return legGrossTradeAmt; 		
			} else {		
		
				buf.position(hasLegGrossTradeAmt);		
		
			legGrossTradeAmt = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegGrossTradeAmt);		
					return 0;		
				}		
			}		
			hasLegGrossTradeAmt = FixUtils.TAG_HAS_VALUE;		
			return legGrossTradeAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegGrossTradeAmt() { return hasLegGrossTradeAmt != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegGrossTradeAmt(long src) {		
		legGrossTradeAmt = src;
		hasLegGrossTradeAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegGrossTradeAmt(byte[] src) {		
		if (src == null ) return;
		if (hasLegGrossTradeAmt()) legGrossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		legGrossTradeAmt = FixUtils.longValueOf(src, 0, src.length);
		hasLegGrossTradeAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegGrossTradeAmt(String str) {		
		if (str == null ) return;
		if (hasLegGrossTradeAmt()) legGrossTradeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legGrossTradeAmt = FixUtils.longValueOf(src, 0, src.length);
		hasLegGrossTradeAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegVolatility() { 		
		if ( hasLegVolatility()) {		
			if (hasLegVolatility == FixUtils.TAG_HAS_VALUE) {		
				return legVolatility; 		
			} else {		
		
				buf.position(hasLegVolatility);		
		
			legVolatility = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegVolatility);		
					return 0;		
				}		
			}		
			hasLegVolatility = FixUtils.TAG_HAS_VALUE;		
			return legVolatility;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegVolatility() { return hasLegVolatility != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegVolatility(long src) {		
		legVolatility = src;
		hasLegVolatility = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegVolatility(byte[] src) {		
		if (src == null ) return;
		if (hasLegVolatility()) legVolatility = FixUtils.TAG_HAS_NO_VALUE;		
		legVolatility = FixUtils.longValueOf(src, 0, src.length);
		hasLegVolatility = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegVolatility(String str) {		
		if (str == null ) return;
		if (hasLegVolatility()) legVolatility = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legVolatility = FixUtils.longValueOf(src, 0, src.length);
		hasLegVolatility = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegDividendYield() { 		
		if ( hasLegDividendYield()) {		
			if (hasLegDividendYield == FixUtils.TAG_HAS_VALUE) {		
				return legDividendYield; 		
			} else {		
		
				buf.position(hasLegDividendYield);		
		
			legDividendYield = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegDividendYield);		
					return 0;		
				}		
			}		
			hasLegDividendYield = FixUtils.TAG_HAS_VALUE;		
			return legDividendYield;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegDividendYield() { return hasLegDividendYield != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegDividendYield(long src) {		
		legDividendYield = src;
		hasLegDividendYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegDividendYield(byte[] src) {		
		if (src == null ) return;
		if (hasLegDividendYield()) legDividendYield = FixUtils.TAG_HAS_NO_VALUE;		
		legDividendYield = FixUtils.longValueOf(src, 0, src.length);
		hasLegDividendYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegDividendYield(String str) {		
		if (str == null ) return;
		if (hasLegDividendYield()) legDividendYield = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legDividendYield = FixUtils.longValueOf(src, 0, src.length);
		hasLegDividendYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegCurrencyRatio() { 		
		if ( hasLegCurrencyRatio()) {		
			if (hasLegCurrencyRatio == FixUtils.TAG_HAS_VALUE) {		
				return legCurrencyRatio; 		
			} else {		
		
				buf.position(hasLegCurrencyRatio);		
		
			legCurrencyRatio = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegCurrencyRatio);		
					return 0;		
				}		
			}		
			hasLegCurrencyRatio = FixUtils.TAG_HAS_VALUE;		
			return legCurrencyRatio;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegCurrencyRatio() { return hasLegCurrencyRatio != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegCurrencyRatio(long src) {		
		legCurrencyRatio = src;
		hasLegCurrencyRatio = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegCurrencyRatio(byte[] src) {		
		if (src == null ) return;
		if (hasLegCurrencyRatio()) legCurrencyRatio = FixUtils.TAG_HAS_NO_VALUE;		
		legCurrencyRatio = FixUtils.longValueOf(src, 0, src.length);
		hasLegCurrencyRatio = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegCurrencyRatio(String str) {		
		if (str == null ) return;
		if (hasLegCurrencyRatio()) legCurrencyRatio = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legCurrencyRatio = FixUtils.longValueOf(src, 0, src.length);
		hasLegCurrencyRatio = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegExecInst() { 		
		if ( hasLegExecInst()) {		
			if (hasLegExecInst == FixUtils.TAG_HAS_VALUE) {		
				return legExecInst; 		
			} else {		
		
				buf.position(hasLegExecInst);		
		
			FixMessage.getTagStringValue(buf, legExecInst, 0, legExecInst.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegExecInst);		
					return null;		
				}		
			}		
			hasLegExecInst = FixUtils.TAG_HAS_VALUE;		
			return legExecInst;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegExecInst() { return hasLegExecInst != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegExecInst(byte[] src) {		
		if (src == null ) return;
		if (hasLegExecInst()) FixUtils.fillSpace(legExecInst);		
		FixUtils.copy(legExecInst, src); 		
		hasLegExecInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegExecInst(String str) {		
		if (str == null ) return;
		if (hasLegExecInst()) FixUtils.fillSpace(legExecInst);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legExecInst, src); 		
		hasLegExecInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegLastQty() { 		
		if ( hasLegLastQty()) {		
			if (hasLegLastQty == FixUtils.TAG_HAS_VALUE) {		
				return legLastQty; 		
			} else {		
		
				buf.position(hasLegLastQty);		
		
			legLastQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegLastQty);		
					return 0;		
				}		
			}		
			hasLegLastQty = FixUtils.TAG_HAS_VALUE;		
			return legLastQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegLastQty() { return hasLegLastQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegLastQty(long src) {		
		legLastQty = src;
		hasLegLastQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegLastQty(byte[] src) {		
		if (src == null ) return;
		if (hasLegLastQty()) legLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		legLastQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegLastQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegLastQty(String str) {		
		if (str == null ) return;
		if (hasLegLastQty()) legLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legLastQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegLastQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasLegQty()) s += "LegQty(687)= " + getLegQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegSwapType()) s += "LegSwapType(690)= " + getLegSwapType() + "\n" ; 
		if (hasLegReportID()) s += "LegReportID(990)= " + new String( FixUtils.trim(getLegReportID()) ) + "\n" ; 
		if (hasLegNumber()) s += "LegNumber(1152)= " + getLegNumber() + "\n" ; 
		if (hasLegPositionEffect()) s += "LegPositionEffect(564)= " + getLegPositionEffect() + "\n" ; 
		if (hasLegCoveredOrUncovered()) s += "LegCoveredOrUncovered(565)= " + getLegCoveredOrUncovered() + "\n" ; 
		if (hasLegRefID()) s += "LegRefID(654)= " + new String( FixUtils.trim(getLegRefID()) ) + "\n" ; 
		if (hasLegSettlType()) s += "LegSettlType(587)= " + getLegSettlType() + "\n" ; 
		if (hasLegSettlDate()) s += "LegSettlDate(588)= " + new String( FixUtils.trim(getLegSettlDate()) ) + "\n" ; 
		if (hasLegLastPx()) s += "LegLastPx(637)= " + getLegLastPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegSettlCurrency()) s += "LegSettlCurrency(675)= " + new String( FixUtils.trim(getLegSettlCurrency()) ) + "\n" ; 
		if (hasLegLastForwardPoints()) s += "LegLastForwardPoints(1073)= " + getLegLastForwardPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegCalculatedCcyLastQty()) s += "LegCalculatedCcyLastQty(1074)= " + getLegCalculatedCcyLastQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegGrossTradeAmt()) s += "LegGrossTradeAmt(1075)= " + getLegGrossTradeAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegVolatility()) s += "LegVolatility(1379)= " + getLegVolatility() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegDividendYield()) s += "LegDividendYield(1381)= " + getLegDividendYield() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegCurrencyRatio()) s += "LegCurrencyRatio(1383)= " + getLegCurrencyRatio() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegExecInst()) s += "LegExecInst(1384)= " + new String( FixUtils.trim(getLegExecInst()) ) + "\n" ; 
		if (hasLegLastQty()) s += "LegLastQty(1418)= " + getLegLastQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

		s += instrumentLeg.toString();
		for (FixLegStipulations fixLegStipulations : legStipulations) fixLegStipulations.toString();
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.toString();
		for (FixTradeCapLegUnderlyingsGrp fixTradeCapLegUnderlyingsGrp : tradeCapLegUnderlyingsGrp) fixTradeCapLegUnderlyingsGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTrdInstrmtLegGrp)) return false;

		FixTrdInstrmtLegGrp msg = (FixTrdInstrmtLegGrp) o;

		if (!instrumentLeg.equals(msg.instrumentLeg)) return false;
		for (int i = 0; i < legStipulations.length; i++)
			if (!legStipulations[i].equals(msg.legStipulations[i])) return false;
		for (int i = 0; i < nestedParties.length; i++)
			if (!nestedParties[i].equals(msg.nestedParties[i])) return false;
		for (int i = 0; i < tradeCapLegUnderlyingsGrp.length; i++)
			if (!tradeCapLegUnderlyingsGrp[i].equals(msg.tradeCapLegUnderlyingsGrp[i])) return false;
		if ((hasLegQty() && !msg.hasLegQty()) || (!hasLegQty() && msg.hasLegQty())) return false;
		if (!(!hasLegQty() && !msg.hasLegQty()) && !(getLegQty()==msg.getLegQty())) return false;
		if ((hasLegSwapType() && !msg.hasLegSwapType()) || (!hasLegSwapType() && msg.hasLegSwapType())) return false;
		if (!(!hasLegSwapType() && !msg.hasLegSwapType()) && !(getLegSwapType()==msg.getLegSwapType())) return false;
		if ((hasLegReportID() && !msg.hasLegReportID()) || (!hasLegReportID() && msg.hasLegReportID())) return false;
		if (!(!hasLegReportID() && !msg.hasLegReportID()) && !FixUtils.equals(getLegReportID(), msg.getLegReportID())) return false;
		if ((hasLegNumber() && !msg.hasLegNumber()) || (!hasLegNumber() && msg.hasLegNumber())) return false;
		if (!(!hasLegNumber() && !msg.hasLegNumber()) && !(getLegNumber()==msg.getLegNumber())) return false;
		if ((hasLegPositionEffect() && !msg.hasLegPositionEffect()) || (!hasLegPositionEffect() && msg.hasLegPositionEffect())) return false;
		if (!(!hasLegPositionEffect() && !msg.hasLegPositionEffect()) && !(getLegPositionEffect()==msg.getLegPositionEffect())) return false;
		if ((hasLegCoveredOrUncovered() && !msg.hasLegCoveredOrUncovered()) || (!hasLegCoveredOrUncovered() && msg.hasLegCoveredOrUncovered())) return false;
		if (!(!hasLegCoveredOrUncovered() && !msg.hasLegCoveredOrUncovered()) && !(getLegCoveredOrUncovered()==msg.getLegCoveredOrUncovered())) return false;
		if ((hasLegRefID() && !msg.hasLegRefID()) || (!hasLegRefID() && msg.hasLegRefID())) return false;
		if (!(!hasLegRefID() && !msg.hasLegRefID()) && !FixUtils.equals(getLegRefID(), msg.getLegRefID())) return false;
		if ((hasLegSettlType() && !msg.hasLegSettlType()) || (!hasLegSettlType() && msg.hasLegSettlType())) return false;
		if (!(!hasLegSettlType() && !msg.hasLegSettlType()) && !(getLegSettlType()==msg.getLegSettlType())) return false;
		if ((hasLegSettlDate() && !msg.hasLegSettlDate()) || (!hasLegSettlDate() && msg.hasLegSettlDate())) return false;
		if ((hasLegLastPx() && !msg.hasLegLastPx()) || (!hasLegLastPx() && msg.hasLegLastPx())) return false;
		if (!(!hasLegLastPx() && !msg.hasLegLastPx()) && !(getLegLastPx()==msg.getLegLastPx())) return false;
		if ((hasLegSettlCurrency() && !msg.hasLegSettlCurrency()) || (!hasLegSettlCurrency() && msg.hasLegSettlCurrency())) return false;
		if (!(!hasLegSettlCurrency() && !msg.hasLegSettlCurrency()) && !FixUtils.equals(getLegSettlCurrency(), msg.getLegSettlCurrency())) return false;
		if ((hasLegLastForwardPoints() && !msg.hasLegLastForwardPoints()) || (!hasLegLastForwardPoints() && msg.hasLegLastForwardPoints())) return false;
		if (!(!hasLegLastForwardPoints() && !msg.hasLegLastForwardPoints()) && !(getLegLastForwardPoints()==msg.getLegLastForwardPoints())) return false;
		if ((hasLegCalculatedCcyLastQty() && !msg.hasLegCalculatedCcyLastQty()) || (!hasLegCalculatedCcyLastQty() && msg.hasLegCalculatedCcyLastQty())) return false;
		if (!(!hasLegCalculatedCcyLastQty() && !msg.hasLegCalculatedCcyLastQty()) && !(getLegCalculatedCcyLastQty()==msg.getLegCalculatedCcyLastQty())) return false;
		if ((hasLegGrossTradeAmt() && !msg.hasLegGrossTradeAmt()) || (!hasLegGrossTradeAmt() && msg.hasLegGrossTradeAmt())) return false;
		if (!(!hasLegGrossTradeAmt() && !msg.hasLegGrossTradeAmt()) && !(getLegGrossTradeAmt()==msg.getLegGrossTradeAmt())) return false;
		if ((hasLegVolatility() && !msg.hasLegVolatility()) || (!hasLegVolatility() && msg.hasLegVolatility())) return false;
		if (!(!hasLegVolatility() && !msg.hasLegVolatility()) && !(getLegVolatility()==msg.getLegVolatility())) return false;
		if ((hasLegDividendYield() && !msg.hasLegDividendYield()) || (!hasLegDividendYield() && msg.hasLegDividendYield())) return false;
		if (!(!hasLegDividendYield() && !msg.hasLegDividendYield()) && !(getLegDividendYield()==msg.getLegDividendYield())) return false;
		if ((hasLegCurrencyRatio() && !msg.hasLegCurrencyRatio()) || (!hasLegCurrencyRatio() && msg.hasLegCurrencyRatio())) return false;
		if (!(!hasLegCurrencyRatio() && !msg.hasLegCurrencyRatio()) && !(getLegCurrencyRatio()==msg.getLegCurrencyRatio())) return false;
		if ((hasLegExecInst() && !msg.hasLegExecInst()) || (!hasLegExecInst() && msg.hasLegExecInst())) return false;
		if (!(!hasLegExecInst() && !msg.hasLegExecInst()) && !FixUtils.equals(getLegExecInst(), msg.getLegExecInst())) return false;
		if ((hasLegLastQty() && !msg.hasLegLastQty()) || (!hasLegLastQty() && msg.hasLegLastQty())) return false;
		if (!(!hasLegLastQty() && !msg.hasLegLastQty()) && !(getLegLastQty()==msg.getLegLastQty())) return false;
		return true;
	}
	public FixTrdInstrmtLegGrp clone ( FixTrdInstrmtLegGrp out ) {
		if ( hasLegQty())
			out.setLegQty(getLegQty());
		if ( hasLegSwapType())
			out.setLegSwapType(getLegSwapType());
		if ( hasLegReportID())
			out.setLegReportID(getLegReportID());
		if ( hasLegNumber())
			out.setLegNumber(getLegNumber());
		if ( hasLegPositionEffect())
			out.setLegPositionEffect(getLegPositionEffect());
		if ( hasLegCoveredOrUncovered())
			out.setLegCoveredOrUncovered(getLegCoveredOrUncovered());
		if ( hasLegRefID())
			out.setLegRefID(getLegRefID());
		if ( hasLegSettlType())
			out.setLegSettlType(getLegSettlType());
		if ( hasLegSettlDate())
			out.setLegSettlDate(getLegSettlDate());
		if ( hasLegLastPx())
			out.setLegLastPx(getLegLastPx());
		if ( hasLegSettlCurrency())
			out.setLegSettlCurrency(getLegSettlCurrency());
		if ( hasLegLastForwardPoints())
			out.setLegLastForwardPoints(getLegLastForwardPoints());
		if ( hasLegCalculatedCcyLastQty())
			out.setLegCalculatedCcyLastQty(getLegCalculatedCcyLastQty());
		if ( hasLegGrossTradeAmt())
			out.setLegGrossTradeAmt(getLegGrossTradeAmt());
		if ( hasLegVolatility())
			out.setLegVolatility(getLegVolatility());
		if ( hasLegDividendYield())
			out.setLegDividendYield(getLegDividendYield());
		if ( hasLegCurrencyRatio())
			out.setLegCurrencyRatio(getLegCurrencyRatio());
		if ( hasLegExecInst())
			out.setLegExecInst(getLegExecInst());
		if ( hasLegLastQty())
			out.setLegLastQty(getLegLastQty());
		if (instrumentLeg.hasGroup())
			out.instrumentLeg = instrumentLeg.clone( out.instrumentLeg);
		int count = 0;
		count = 0;
		for (FixLegStipulations fixLegStipulations : legStipulations) {
			if (!fixLegStipulations.hasGroup()) continue;
			out.legStipulations[count] = fixLegStipulations.clone( out.legStipulations[count] );
			count++;
		}
		count = 0;
		for (FixNestedParties fixNestedParties : nestedParties) {
			if (!fixNestedParties.hasGroup()) continue;
			out.nestedParties[count] = fixNestedParties.clone( out.nestedParties[count] );
			count++;
		}
		count = 0;
		for (FixTradeCapLegUnderlyingsGrp fixTradeCapLegUnderlyingsGrp : tradeCapLegUnderlyingsGrp) {
			if (!fixTradeCapLegUnderlyingsGrp.hasGroup()) continue;
			out.tradeCapLegUnderlyingsGrp[count] = fixTradeCapLegUnderlyingsGrp.clone( out.tradeCapLegUnderlyingsGrp[count] );
			count++;
		}
		return out;
	}

}
