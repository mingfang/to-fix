package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRFQReqGrp extends FixGroup {
	private short hasPrevClosePx;
	long prevClosePx = 0;		
	private short hasQuoteRequestType;
	long quoteRequestType = 0;		
	private short hasQuoteType;
	long quoteType = 0;		
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixInstrument instrument;
		public FixUndInstrmtGrp[] undInstrmtGrp;
		public FixInstrmtLegGrp[] instrmtLegGrp;
	
	public FixRFQReqGrp() {
		this(false);
	}

	public FixRFQReqGrp(boolean isRequired) {
		super(FixTags.SYMBOL_INT);

		this.isRequired = isRequired;
		
		hasPrevClosePx = FixUtils.TAG_HAS_NO_VALUE;		
		hasQuoteRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		hasQuoteType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		instrument = new FixInstrument(true);
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (instrument.hasGroup()) return true;
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
            	case FixTags.PREVCLOSEPX_INT:		
            		hasPrevClosePx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.QUOTEREQUESTTYPE_INT:		
            		hasQuoteRequestType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.QUOTETYPE_INT:		
            		hasQuoteType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADINGSESSIONID_INT:		
            		hasTradingSessionID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADINGSESSIONSUBID_INT:		
            		hasTradingSessionSubID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOUNDERLYINGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !undInstrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = undInstrmtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOLEGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
            }

            tag = FixUtils.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
            if (isKeyTag(tag)) return tag; // next in repeating group
        }		
        return tag;
    }		
	public boolean hasRequiredTags(FixValidationError err) {
		if (instrument.isRequired) instrument.hasRequiredTags(err); if (err.hasError()) return false;
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasPrevClosePx = FixUtils.TAG_HAS_NO_VALUE;
		hasQuoteRequestType = FixUtils.TAG_HAS_NO_VALUE;
		hasQuoteType = FixUtils.TAG_HAS_NO_VALUE;
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;
		instrument.clear();
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.clear();
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasPrevClosePx()) {		
			out.put(FixTags.PREVCLOSEPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)prevClosePx);
		
			out.put(FixUtils.SOH);

            }

		if (hasQuoteRequestType()) {		
			out.put(FixTags.QUOTEREQUESTTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)quoteRequestType);
		
			out.put(FixUtils.SOH);

            }

		if (hasQuoteType()) {		
			out.put(FixTags.QUOTETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)quoteType);
		
			out.put(FixUtils.SOH);

            }

		if (hasTradingSessionID()) {		
			out.put(FixTags.TRADINGSESSIONID);

			out.put((byte) '=');

			FixUtils.put(out,tradingSessionID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradingSessionSubID()) {		
			out.put(FixTags.TRADINGSESSIONSUBID);

			out.put((byte) '=');

			FixUtils.put(out,tradingSessionSubID); 		
		
			out.put(FixUtils.SOH);

            }

		instrument.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(instrmtLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) if (fixInstrmtLegGrp.hasGroup()) fixInstrmtLegGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasPrevClosePx()) {		
			FixUtils.put(out, (long)prevClosePx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteRequestType()) {		
			FixUtils.put(out, (long)quoteRequestType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteType()) {		
			FixUtils.put(out, (long)quoteType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionID()) {		
			FixUtils.put(out,tradingSessionID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionSubID()) {		
			FixUtils.put(out,tradingSessionSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		instrument.printBuffer(out);
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.printBuffer(out);
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.printBuffer(out);
	}

	public long getPrevClosePx() { 		
		if ( hasPrevClosePx()) {		
			if (hasPrevClosePx == FixUtils.TAG_HAS_VALUE) {		
				return prevClosePx; 		
			} else {		
		
				buf.position(hasPrevClosePx);		
		
			prevClosePx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPrevClosePx);		
					return 0;		
				}		
			}		
			hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
			return prevClosePx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPrevClosePx() { return hasPrevClosePx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPrevClosePx(long src) {		
		prevClosePx = src;
		hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrevClosePx(byte[] src) {		
		if (src == null ) return;
		if (hasPrevClosePx()) prevClosePx = FixUtils.TAG_HAS_NO_VALUE;		
		prevClosePx = FixUtils.longValueOf(src, 0, src.length);
		hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPrevClosePx(String str) {		
		if (str == null ) return;
		if (hasPrevClosePx()) prevClosePx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		prevClosePx = FixUtils.longValueOf(src, 0, src.length);
		hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getQuoteRequestType() { 		
		if ( hasQuoteRequestType()) {		
			if (hasQuoteRequestType == FixUtils.TAG_HAS_VALUE) {		
				return quoteRequestType; 		
			} else {		
		
				buf.position(hasQuoteRequestType);		
		
			quoteRequestType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasQuoteRequestType);		
					return 0;		
				}		
			}		
			hasQuoteRequestType = FixUtils.TAG_HAS_VALUE;		
			return quoteRequestType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuoteRequestType() { return hasQuoteRequestType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setQuoteRequestType(long src) {		
		quoteRequestType = src;
		hasQuoteRequestType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteRequestType(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteRequestType()) quoteRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		quoteRequestType = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteRequestType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setQuoteRequestType(String str) {		
		if (str == null ) return;
		if (hasQuoteRequestType()) quoteRequestType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quoteRequestType = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteRequestType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getQuoteType() { 		
		if ( hasQuoteType()) {		
			if (hasQuoteType == FixUtils.TAG_HAS_VALUE) {		
				return quoteType; 		
			} else {		
		
				buf.position(hasQuoteType);		
		
			quoteType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasQuoteType);		
					return 0;		
				}		
			}		
			hasQuoteType = FixUtils.TAG_HAS_VALUE;		
			return quoteType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasQuoteType() { return hasQuoteType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setQuoteType(long src) {		
		quoteType = src;
		hasQuoteType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteType(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteType()) quoteType = FixUtils.TAG_HAS_NO_VALUE;		
		quoteType = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setQuoteType(String str) {		
		if (str == null ) return;
		if (hasQuoteType()) quoteType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		quoteType = FixUtils.longValueOf(src, 0, src.length);
		hasQuoteType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradingSessionID() { 		
		if ( hasTradingSessionID()) {		
			if (hasTradingSessionID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionID; 		
			} else {		
		
				buf.position(hasTradingSessionID);		
		
			FixUtils.getTagStringValue(buf, tradingSessionID, 0, tradingSessionID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradingSessionID);		
					return null;		
				}		
			}		
			hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
			return tradingSessionID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionID() { return hasTradingSessionID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradingSessionID(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionID()) FixUtils.fillNul(tradingSessionID);		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradingSessionID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionID()) FixUtils.fillNul(tradingSessionID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradingSessionSubID() { 		
		if ( hasTradingSessionSubID()) {		
			if (hasTradingSessionSubID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionSubID; 		
			} else {		
		
				buf.position(hasTradingSessionSubID);		
		
			FixUtils.getTagStringValue(buf, tradingSessionSubID, 0, tradingSessionSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradingSessionSubID);		
					return null;		
				}		
			}		
			hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
			return tradingSessionSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionSubID() { return hasTradingSessionSubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradingSessionSubID(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillNul(tradingSessionSubID);		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradingSessionSubID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillNul(tradingSessionSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasPrevClosePx()) s += "PrevClosePx(140)= " + getPrevClosePx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasQuoteRequestType()) s += "QuoteRequestType(303)= " + getQuoteRequestType() + "\n" ; 
		if (hasQuoteType()) s += "QuoteType(537)= " + getQuoteType() + "\n" ; 
		if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 

		s += instrument.toString();
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.toString();
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRFQReqGrp)) return false;

		FixRFQReqGrp msg = (FixRFQReqGrp) o;

		if (!instrument.equals(msg.instrument)) return false;
		for (int i = 0; i < undInstrmtGrp.length; i++)
			if (!undInstrmtGrp[i].equals(msg.undInstrmtGrp[i])) return false;
		for (int i = 0; i < instrmtLegGrp.length; i++)
			if (!instrmtLegGrp[i].equals(msg.instrmtLegGrp[i])) return false;
		if ((hasPrevClosePx() && !msg.hasPrevClosePx()) || (!hasPrevClosePx() && msg.hasPrevClosePx())) return false;
		if (!(!hasPrevClosePx() && !msg.hasPrevClosePx()) && !(getPrevClosePx()==msg.getPrevClosePx())) return false;
		if ((hasQuoteRequestType() && !msg.hasQuoteRequestType()) || (!hasQuoteRequestType() && msg.hasQuoteRequestType())) return false;
		if (!(!hasQuoteRequestType() && !msg.hasQuoteRequestType()) && !(getQuoteRequestType()==msg.getQuoteRequestType())) return false;
		if ((hasQuoteType() && !msg.hasQuoteType()) || (!hasQuoteType() && msg.hasQuoteType())) return false;
		if (!(!hasQuoteType() && !msg.hasQuoteType()) && !(getQuoteType()==msg.getQuoteType())) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		return true;
	}
	public FixRFQReqGrp clone ( FixRFQReqGrp out ) {
		if ( hasPrevClosePx())
			out.setPrevClosePx(getPrevClosePx());
		if ( hasQuoteRequestType())
			out.setQuoteRequestType(getQuoteRequestType());
		if ( hasQuoteType())
			out.setQuoteType(getQuoteType());
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		int count = 0;
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		count = 0;
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) {
			if (!fixInstrmtLegGrp.hasGroup()) continue;
			out.instrmtLegGrp[count] = fixInstrmtLegGrp.clone( out.instrmtLegGrp[count] );
			count++;
		}
		return out;
	}

}
