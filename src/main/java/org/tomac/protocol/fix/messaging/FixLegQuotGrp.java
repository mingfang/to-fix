package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixLegQuotGrp extends FixGroup {
	private short hasLegQty;
	long legQty = 0;		
	private short hasLegOrderQty;
	long legOrderQty = 0;		
	private short hasLegSwapType;
	long legSwapType = 0;		
	private short hasLegSettlType;
	byte legSettlType = (byte)' ';		
	private short hasLegSettlDate;
	byte[] legSettlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegPriceType;
	long legPriceType = 0;		
	private short hasLegBidPx;
	long legBidPx = 0;		
	private short hasLegOfferPx;
	long legOfferPx = 0;		
	private short hasLegRefID;
	byte[] legRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegBidForwardPoints;
	long legBidForwardPoints = 0;		
	private short hasLegOfferForwardPoints;
	long legOfferForwardPoints = 0;		
		public FixInstrumentLeg instrumentLeg;
		public FixLegStipulations[] legStipulations;
		public FixNestedParties[] nestedParties;
		public FixLegBenchmarkCurveData legBenchmarkCurveData;
	
	public FixLegQuotGrp() {
		this(false);
	}

	public FixLegQuotGrp(boolean isRequired) {
		super(FixTags.LEGSYMBOL_INT);

		this.isRequired = isRequired;
		
		hasLegQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegOrderQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegSwapType = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		legSettlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegBidPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegOfferPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegRefID = FixUtils.TAG_HAS_NO_VALUE;		
		legRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegBidForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegOfferForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		instrumentLeg = new FixInstrumentLeg();
		legStipulations = new FixLegStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) legStipulations[i] = new FixLegStipulations();
		nestedParties = new FixNestedParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedParties[i] = new FixNestedParties();
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
            	case FixTags.LEGQTY_INT:		
            		hasLegQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGORDERQTY_INT:		
            		hasLegOrderQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSWAPTYPE_INT:		
            		hasLegSwapType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSETTLTYPE_INT:		
            		hasLegSettlType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGSETTLDATE_INT:		
            		hasLegSettlDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGPRICETYPE_INT:		
            		hasLegPriceType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGBIDPX_INT:		
            		hasLegBidPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGOFFERPX_INT:		
            		hasLegOfferPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGREFID_INT:		
            		hasLegRefID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGBIDFORWARDPOINTS_INT:		
            		hasLegBidForwardPoints = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGOFFERFORWARDPOINTS_INT:		
            		hasLegOfferForwardPoints = (short) buf.position();		
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
        			} else if ( tag == FixTags.NONESTEDPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
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
		hasLegQty = FixUtils.TAG_HAS_NO_VALUE;
		hasLegOrderQty = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSwapType = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSettlType = FixUtils.TAG_HAS_NO_VALUE;
		hasLegSettlDate = FixUtils.TAG_HAS_NO_VALUE;
		hasLegPriceType = FixUtils.TAG_HAS_NO_VALUE;
		hasLegBidPx = FixUtils.TAG_HAS_NO_VALUE;
		hasLegOfferPx = FixUtils.TAG_HAS_NO_VALUE;
		hasLegRefID = FixUtils.TAG_HAS_NO_VALUE;
		hasLegBidForwardPoints = FixUtils.TAG_HAS_NO_VALUE;
		hasLegOfferForwardPoints = FixUtils.TAG_HAS_NO_VALUE;
		instrumentLeg.clear();
		for (FixLegStipulations fixLegStipulations : legStipulations) fixLegStipulations.clear();
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.clear();
		legBenchmarkCurveData.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasLegQty()) {		
			out.put(FixTags.LEGQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)legQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegOrderQty()) {		
			out.put(FixTags.LEGORDERQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)legOrderQty);
		
			out.put(FixUtils.SOH);

            }

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

		if (hasLegSettlDate()) {		
			out.put(FixTags.LEGSETTLDATE);

			out.put((byte) '=');

			FixUtils.put(out,legSettlDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegPriceType()) {		
			out.put(FixTags.LEGPRICETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)legPriceType);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegBidPx()) {		
			out.put(FixTags.LEGBIDPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)legBidPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegOfferPx()) {		
			out.put(FixTags.LEGOFFERPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)legOfferPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegRefID()) {		
			out.put(FixTags.LEGREFID);

			out.put((byte) '=');

			FixUtils.put(out,legRefID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegBidForwardPoints()) {		
			out.put(FixTags.LEGBIDFORWARDPOINTS);

			out.put((byte) '=');

			FixUtils.put(out, (long)legBidForwardPoints);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegOfferForwardPoints()) {		
			out.put(FixTags.LEGOFFERFORWARDPOINTS);

			out.put((byte) '=');

			FixUtils.put(out, (long)legOfferForwardPoints);
		
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
		legBenchmarkCurveData.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasLegQty()) {		
			FixUtils.put(out, (long)legQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegOrderQty()) {		
			FixUtils.put(out, (long)legOrderQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegSwapType()) {		
			FixUtils.put(out, (long)legSwapType);
		
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
		
		if (hasLegPriceType()) {		
			FixUtils.put(out, (long)legPriceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegBidPx()) {		
			FixUtils.put(out, (long)legBidPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegOfferPx()) {		
			FixUtils.put(out, (long)legOfferPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegRefID()) {		
			FixUtils.put(out,legRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegBidForwardPoints()) {		
			FixUtils.put(out, (long)legBidForwardPoints);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegOfferForwardPoints()) {		
			FixUtils.put(out, (long)legOfferForwardPoints);
		
	        out.put( (byte)' ' );		
		}		
		
		instrumentLeg.printBuffer(out);
		for (FixLegStipulations fixLegStipulations : legStipulations) fixLegStipulations.printBuffer(out);
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.printBuffer(out);
		legBenchmarkCurveData.printBuffer(out);
	}

	public long getLegQty() { 		
		if ( hasLegQty()) {		
			if (hasLegQty == FixUtils.TAG_HAS_VALUE) {		
				return legQty; 		
			} else {		
		
				buf.position(hasLegQty);		
		
			legQty = FixUtils.getTagFloatValue(buf, err);
		
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
			
	public long getLegOrderQty() { 		
		if ( hasLegOrderQty()) {		
			if (hasLegOrderQty == FixUtils.TAG_HAS_VALUE) {		
				return legOrderQty; 		
			} else {		
		
				buf.position(hasLegOrderQty);		
		
			legOrderQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegOrderQty);		
					return 0;		
				}		
			}		
			hasLegOrderQty = FixUtils.TAG_HAS_VALUE;		
			return legOrderQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegOrderQty() { return hasLegOrderQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegOrderQty(long src) {		
		legOrderQty = src;
		hasLegOrderQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegOrderQty(byte[] src) {		
		if (src == null ) return;
		if (hasLegOrderQty()) legOrderQty = FixUtils.TAG_HAS_NO_VALUE;		
		legOrderQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegOrderQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegOrderQty(String str) {		
		if (str == null ) return;
		if (hasLegOrderQty()) legOrderQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legOrderQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegOrderQty = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getLegSettlDate() { 		
		if ( hasLegSettlDate()) {		
			if (hasLegSettlDate == FixUtils.TAG_HAS_VALUE) {		
				return legSettlDate; 		
			} else {		
		
				buf.position(hasLegSettlDate);		
		
			FixUtils.getTagStringValue(buf, legSettlDate, 0, legSettlDate.length, err);
		
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
		if (hasLegSettlDate()) FixUtils.fillNul(legSettlDate);		
		FixUtils.copy(legSettlDate, src); 		
		hasLegSettlDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegSettlDate(String str) {		
		if (str == null ) return;
		if (hasLegSettlDate()) FixUtils.fillNul(legSettlDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legSettlDate, src); 		
		hasLegSettlDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegPriceType() { 		
		if ( hasLegPriceType()) {		
			if (hasLegPriceType == FixUtils.TAG_HAS_VALUE) {		
				return legPriceType; 		
			} else {		
		
				buf.position(hasLegPriceType);		
		
			legPriceType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegPriceType);		
					return 0;		
				}		
			}		
			hasLegPriceType = FixUtils.TAG_HAS_VALUE;		
			return legPriceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegPriceType() { return hasLegPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegPriceType(long src) {		
		legPriceType = src;
		hasLegPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasLegPriceType()) legPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		legPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasLegPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegPriceType(String str) {		
		if (str == null ) return;
		if (hasLegPriceType()) legPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasLegPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegBidPx() { 		
		if ( hasLegBidPx()) {		
			if (hasLegBidPx == FixUtils.TAG_HAS_VALUE) {		
				return legBidPx; 		
			} else {		
		
				buf.position(hasLegBidPx);		
		
			legBidPx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegBidPx);		
					return 0;		
				}		
			}		
			hasLegBidPx = FixUtils.TAG_HAS_VALUE;		
			return legBidPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegBidPx() { return hasLegBidPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegBidPx(long src) {		
		legBidPx = src;
		hasLegBidPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegBidPx(byte[] src) {		
		if (src == null ) return;
		if (hasLegBidPx()) legBidPx = FixUtils.TAG_HAS_NO_VALUE;		
		legBidPx = FixUtils.longValueOf(src, 0, src.length);
		hasLegBidPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegBidPx(String str) {		
		if (str == null ) return;
		if (hasLegBidPx()) legBidPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legBidPx = FixUtils.longValueOf(src, 0, src.length);
		hasLegBidPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegOfferPx() { 		
		if ( hasLegOfferPx()) {		
			if (hasLegOfferPx == FixUtils.TAG_HAS_VALUE) {		
				return legOfferPx; 		
			} else {		
		
				buf.position(hasLegOfferPx);		
		
			legOfferPx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegOfferPx);		
					return 0;		
				}		
			}		
			hasLegOfferPx = FixUtils.TAG_HAS_VALUE;		
			return legOfferPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegOfferPx() { return hasLegOfferPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegOfferPx(long src) {		
		legOfferPx = src;
		hasLegOfferPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegOfferPx(byte[] src) {		
		if (src == null ) return;
		if (hasLegOfferPx()) legOfferPx = FixUtils.TAG_HAS_NO_VALUE;		
		legOfferPx = FixUtils.longValueOf(src, 0, src.length);
		hasLegOfferPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegOfferPx(String str) {		
		if (str == null ) return;
		if (hasLegOfferPx()) legOfferPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legOfferPx = FixUtils.longValueOf(src, 0, src.length);
		hasLegOfferPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegRefID() { 		
		if ( hasLegRefID()) {		
			if (hasLegRefID == FixUtils.TAG_HAS_VALUE) {		
				return legRefID; 		
			} else {		
		
				buf.position(hasLegRefID);		
		
			FixUtils.getTagStringValue(buf, legRefID, 0, legRefID.length, err);
		
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
		if (hasLegRefID()) FixUtils.fillNul(legRefID);		
		FixUtils.copy(legRefID, src); 		
		hasLegRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegRefID(String str) {		
		if (str == null ) return;
		if (hasLegRefID()) FixUtils.fillNul(legRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legRefID, src); 		
		hasLegRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegBidForwardPoints() { 		
		if ( hasLegBidForwardPoints()) {		
			if (hasLegBidForwardPoints == FixUtils.TAG_HAS_VALUE) {		
				return legBidForwardPoints; 		
			} else {		
		
				buf.position(hasLegBidForwardPoints);		
		
			legBidForwardPoints = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegBidForwardPoints);		
					return 0;		
				}		
			}		
			hasLegBidForwardPoints = FixUtils.TAG_HAS_VALUE;		
			return legBidForwardPoints;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegBidForwardPoints() { return hasLegBidForwardPoints != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegBidForwardPoints(long src) {		
		legBidForwardPoints = src;
		hasLegBidForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegBidForwardPoints(byte[] src) {		
		if (src == null ) return;
		if (hasLegBidForwardPoints()) legBidForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		legBidForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasLegBidForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegBidForwardPoints(String str) {		
		if (str == null ) return;
		if (hasLegBidForwardPoints()) legBidForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legBidForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasLegBidForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegOfferForwardPoints() { 		
		if ( hasLegOfferForwardPoints()) {		
			if (hasLegOfferForwardPoints == FixUtils.TAG_HAS_VALUE) {		
				return legOfferForwardPoints; 		
			} else {		
		
				buf.position(hasLegOfferForwardPoints);		
		
			legOfferForwardPoints = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegOfferForwardPoints);		
					return 0;		
				}		
			}		
			hasLegOfferForwardPoints = FixUtils.TAG_HAS_VALUE;		
			return legOfferForwardPoints;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegOfferForwardPoints() { return hasLegOfferForwardPoints != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegOfferForwardPoints(long src) {		
		legOfferForwardPoints = src;
		hasLegOfferForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegOfferForwardPoints(byte[] src) {		
		if (src == null ) return;
		if (hasLegOfferForwardPoints()) legOfferForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		legOfferForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasLegOfferForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegOfferForwardPoints(String str) {		
		if (str == null ) return;
		if (hasLegOfferForwardPoints()) legOfferForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legOfferForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasLegOfferForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasLegQty()) s += "LegQty(687)= " + getLegQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegOrderQty()) s += "LegOrderQty(685)= " + getLegOrderQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegSwapType()) s += "LegSwapType(690)= " + getLegSwapType() + "\n" ; 
		if (hasLegSettlType()) s += "LegSettlType(587)= " + getLegSettlType() + "\n" ; 
		if (hasLegSettlDate()) s += "LegSettlDate(588)= " + new String( FixUtils.trim(getLegSettlDate()) ) + "\n" ; 
		if (hasLegPriceType()) s += "LegPriceType(686)= " + getLegPriceType() + "\n" ; 
		if (hasLegBidPx()) s += "LegBidPx(681)= " + getLegBidPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegOfferPx()) s += "LegOfferPx(684)= " + getLegOfferPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegRefID()) s += "LegRefID(654)= " + new String( FixUtils.trim(getLegRefID()) ) + "\n" ; 
		if (hasLegBidForwardPoints()) s += "LegBidForwardPoints(1067)= " + getLegBidForwardPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegOfferForwardPoints()) s += "LegOfferForwardPoints(1068)= " + getLegOfferForwardPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

		s += instrumentLeg.toString();
		for (FixLegStipulations fixLegStipulations : legStipulations) fixLegStipulations.toString();
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.toString();
		s += legBenchmarkCurveData.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixLegQuotGrp)) return false;

		FixLegQuotGrp msg = (FixLegQuotGrp) o;

		if (!instrumentLeg.equals(msg.instrumentLeg)) return false;
		for (int i = 0; i < legStipulations.length; i++)
			if (!legStipulations[i].equals(msg.legStipulations[i])) return false;
		for (int i = 0; i < nestedParties.length; i++)
			if (!nestedParties[i].equals(msg.nestedParties[i])) return false;
		if (!legBenchmarkCurveData.equals(msg.legBenchmarkCurveData)) return false;
		if ((hasLegQty() && !msg.hasLegQty()) || (!hasLegQty() && msg.hasLegQty())) return false;
		if (!(!hasLegQty() && !msg.hasLegQty()) && !(getLegQty()==msg.getLegQty())) return false;
		if ((hasLegOrderQty() && !msg.hasLegOrderQty()) || (!hasLegOrderQty() && msg.hasLegOrderQty())) return false;
		if (!(!hasLegOrderQty() && !msg.hasLegOrderQty()) && !(getLegOrderQty()==msg.getLegOrderQty())) return false;
		if ((hasLegSwapType() && !msg.hasLegSwapType()) || (!hasLegSwapType() && msg.hasLegSwapType())) return false;
		if (!(!hasLegSwapType() && !msg.hasLegSwapType()) && !(getLegSwapType()==msg.getLegSwapType())) return false;
		if ((hasLegSettlType() && !msg.hasLegSettlType()) || (!hasLegSettlType() && msg.hasLegSettlType())) return false;
		if (!(!hasLegSettlType() && !msg.hasLegSettlType()) && !(getLegSettlType()==msg.getLegSettlType())) return false;
		if ((hasLegSettlDate() && !msg.hasLegSettlDate()) || (!hasLegSettlDate() && msg.hasLegSettlDate())) return false;
		if ((hasLegPriceType() && !msg.hasLegPriceType()) || (!hasLegPriceType() && msg.hasLegPriceType())) return false;
		if (!(!hasLegPriceType() && !msg.hasLegPriceType()) && !(getLegPriceType()==msg.getLegPriceType())) return false;
		if ((hasLegBidPx() && !msg.hasLegBidPx()) || (!hasLegBidPx() && msg.hasLegBidPx())) return false;
		if (!(!hasLegBidPx() && !msg.hasLegBidPx()) && !(getLegBidPx()==msg.getLegBidPx())) return false;
		if ((hasLegOfferPx() && !msg.hasLegOfferPx()) || (!hasLegOfferPx() && msg.hasLegOfferPx())) return false;
		if (!(!hasLegOfferPx() && !msg.hasLegOfferPx()) && !(getLegOfferPx()==msg.getLegOfferPx())) return false;
		if ((hasLegRefID() && !msg.hasLegRefID()) || (!hasLegRefID() && msg.hasLegRefID())) return false;
		if (!(!hasLegRefID() && !msg.hasLegRefID()) && !FixUtils.equals(getLegRefID(), msg.getLegRefID())) return false;
		if ((hasLegBidForwardPoints() && !msg.hasLegBidForwardPoints()) || (!hasLegBidForwardPoints() && msg.hasLegBidForwardPoints())) return false;
		if (!(!hasLegBidForwardPoints() && !msg.hasLegBidForwardPoints()) && !(getLegBidForwardPoints()==msg.getLegBidForwardPoints())) return false;
		if ((hasLegOfferForwardPoints() && !msg.hasLegOfferForwardPoints()) || (!hasLegOfferForwardPoints() && msg.hasLegOfferForwardPoints())) return false;
		if (!(!hasLegOfferForwardPoints() && !msg.hasLegOfferForwardPoints()) && !(getLegOfferForwardPoints()==msg.getLegOfferForwardPoints())) return false;
		return true;
	}
	public FixLegQuotGrp clone ( FixLegQuotGrp out ) {
		if ( hasLegQty())
			out.setLegQty(getLegQty());
		if ( hasLegOrderQty())
			out.setLegOrderQty(getLegOrderQty());
		if ( hasLegSwapType())
			out.setLegSwapType(getLegSwapType());
		if ( hasLegSettlType())
			out.setLegSettlType(getLegSettlType());
		if ( hasLegSettlDate())
			out.setLegSettlDate(getLegSettlDate());
		if ( hasLegPriceType())
			out.setLegPriceType(getLegPriceType());
		if ( hasLegBidPx())
			out.setLegBidPx(getLegBidPx());
		if ( hasLegOfferPx())
			out.setLegOfferPx(getLegOfferPx());
		if ( hasLegRefID())
			out.setLegRefID(getLegRefID());
		if ( hasLegBidForwardPoints())
			out.setLegBidForwardPoints(getLegBidForwardPoints());
		if ( hasLegOfferForwardPoints())
			out.setLegOfferForwardPoints(getLegOfferForwardPoints());
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
		if (legBenchmarkCurveData.hasGroup())
			out.legBenchmarkCurveData = legBenchmarkCurveData.clone( out.legBenchmarkCurveData);
		return out;
	}

}
