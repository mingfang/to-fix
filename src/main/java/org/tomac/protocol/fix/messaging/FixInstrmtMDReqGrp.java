package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixInstrmtMDReqGrp extends FixGroup {
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasQuoteType;
	long quoteType = 0;		
	private short hasSettlType;
	byte[] settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlDate;
	byte[] settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDEntrySize;
	long mDEntrySize = 0;		
	private short hasMDStreamID;
	byte[] mDStreamID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixInstrument instrument;
		public FixUndInstrmtGrp[] undInstrmtGrp;
		public FixInstrmtLegGrp[] instrmtLegGrp;
	
	public FixInstrmtMDReqGrp() {
		this(false);
	}

	public FixInstrmtMDReqGrp(boolean isRequired) {
		super(FixTags.SYMBOL_INT);

		this.isRequired = isRequired;
		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasQuoteType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDEntrySize = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDStreamID = FixUtils.TAG_HAS_NO_VALUE;		
		mDStreamID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
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
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.QUOTETYPE_INT:		
            		hasQuoteType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLTYPE_INT:		
            		hasSettlType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLDATE_INT:		
            		hasSettlDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYSIZE_INT:		
            		hasMDEntrySize = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MDSTREAMID_INT:		
            		hasMDStreamID = (short) buf.position();		
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
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOUNDERLYINGS_INT);
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
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOLEGS_INT);
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
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasQuoteType = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntrySize = FixUtils.TAG_HAS_NO_VALUE;
		hasMDStreamID = FixUtils.TAG_HAS_NO_VALUE;
		instrument.clear();
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.clear();
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasQuoteType()) {		
			out.put(FixTags.QUOTETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)quoteType);
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlType()) {		
			out.put(FixTags.SETTLTYPE);

			out.put((byte) '=');

			FixUtils.put(out,settlType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlDate()) {		
			out.put(FixTags.SETTLDATE);

			out.put((byte) '=');

			FixUtils.put(out,settlDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntrySize()) {		
			out.put(FixTags.MDENTRYSIZE);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDEntrySize);
		
			out.put(FixUtils.SOH);

            }

		if (hasMDStreamID()) {		
			out.put(FixTags.MDSTREAMID);

			out.put((byte) '=');

			FixUtils.put(out,mDStreamID); 		
		
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
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteType()) {		
			FixUtils.put(out, (long)quoteType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlType()) {		
			FixUtils.put(out,settlType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlDate()) {		
			FixUtils.put(out,settlDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntrySize()) {		
			FixUtils.put(out, (long)mDEntrySize);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDStreamID()) {		
			FixUtils.put(out,mDStreamID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		instrument.printBuffer(out);
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.printBuffer(out);
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.printBuffer(out);
	}

	public byte[] getCurrency() { 		
		if ( hasCurrency()) {		
			if (hasCurrency == FixUtils.TAG_HAS_VALUE) {		
				return currency; 		
			} else {		
		
				buf.position(hasCurrency);		
		
			FixUtils.getTagStringValue(buf, currency, 0, currency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCurrency);		
					return null;		
				}		
			}		
			hasCurrency = FixUtils.TAG_HAS_VALUE;		
			return currency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCurrency() { return hasCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasCurrency()) FixUtils.fillNul(currency);		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCurrency(String str) {		
		if (str == null ) return;
		if (hasCurrency()) FixUtils.fillNul(currency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
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
			
	public byte[] getSettlType() { 		
		if ( hasSettlType()) {		
			if (hasSettlType == FixUtils.TAG_HAS_VALUE) {		
				return settlType; 		
			} else {		
		
				buf.position(hasSettlType);		
		
			FixUtils.getTagStringValue(buf, settlType, 0, settlType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlType);		
					return null;		
				}		
			}		
			hasSettlType = FixUtils.TAG_HAS_VALUE;		
			return settlType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlType() { return hasSettlType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlType(byte[] src) {		
		if (src == null ) return;
		if (hasSettlType()) FixUtils.fillNul(settlType);		
		FixUtils.copy(settlType, src); 		
		hasSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlType(String str) {		
		if (str == null ) return;
		if (hasSettlType()) FixUtils.fillNul(settlType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlType, src); 		
		hasSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSettlDate() { 		
		if ( hasSettlDate()) {		
			if (hasSettlDate == FixUtils.TAG_HAS_VALUE) {		
				return settlDate; 		
			} else {		
		
				buf.position(hasSettlDate);		
		
			FixUtils.getTagStringValue(buf, settlDate, 0, settlDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlDate);		
					return null;		
				}		
			}		
			hasSettlDate = FixUtils.TAG_HAS_VALUE;		
			return settlDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlDate() { return hasSettlDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlDate(byte[] src) {		
		if (src == null ) return;
		if (hasSettlDate()) FixUtils.fillNul(settlDate);		
		FixUtils.copy(settlDate, src); 		
		hasSettlDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlDate(String str) {		
		if (str == null ) return;
		if (hasSettlDate()) FixUtils.fillNul(settlDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlDate, src); 		
		hasSettlDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMDEntrySize() { 		
		if ( hasMDEntrySize()) {		
			if (hasMDEntrySize == FixUtils.TAG_HAS_VALUE) {		
				return mDEntrySize; 		
			} else {		
		
				buf.position(hasMDEntrySize);		
		
			mDEntrySize = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntrySize);		
					return 0;		
				}		
			}		
			hasMDEntrySize = FixUtils.TAG_HAS_VALUE;		
			return mDEntrySize;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDEntrySize() { return hasMDEntrySize != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntrySize(long src) {		
		mDEntrySize = src;
		hasMDEntrySize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDEntrySize(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntrySize()) mDEntrySize = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntrySize = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntrySize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntrySize(String str) {		
		if (str == null ) return;
		if (hasMDEntrySize()) mDEntrySize = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDEntrySize = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntrySize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMDStreamID() { 		
		if ( hasMDStreamID()) {		
			if (hasMDStreamID == FixUtils.TAG_HAS_VALUE) {		
				return mDStreamID; 		
			} else {		
		
				buf.position(hasMDStreamID);		
		
			FixUtils.getTagStringValue(buf, mDStreamID, 0, mDStreamID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDStreamID);		
					return null;		
				}		
			}		
			hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
			return mDStreamID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDStreamID() { return hasMDStreamID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDStreamID(byte[] src) {		
		if (src == null ) return;
		if (hasMDStreamID()) FixUtils.fillNul(mDStreamID);		
		FixUtils.copy(mDStreamID, src); 		
		hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDStreamID(String str) {		
		if (str == null ) return;
		if (hasMDStreamID()) FixUtils.fillNul(mDStreamID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDStreamID, src); 		
		hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasQuoteType()) s += "QuoteType(537)= " + getQuoteType() + "\n" ; 
		if (hasSettlType()) s += "SettlType(63)= " + new String( FixUtils.trim(getSettlType()) ) + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasMDEntrySize()) s += "MDEntrySize(271)= " + getMDEntrySize() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMDStreamID()) s += "MDStreamID(1500)= " + new String( FixUtils.trim(getMDStreamID()) ) + "\n" ; 

		s += instrument.toString();
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.toString();
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrmtMDReqGrp)) return false;

		FixInstrmtMDReqGrp msg = (FixInstrmtMDReqGrp) o;

		if (!instrument.equals(msg.instrument)) return false;
		for (int i = 0; i < undInstrmtGrp.length; i++)
			if (!undInstrmtGrp[i].equals(msg.undInstrmtGrp[i])) return false;
		for (int i = 0; i < instrmtLegGrp.length; i++)
			if (!instrmtLegGrp[i].equals(msg.instrmtLegGrp[i])) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasQuoteType() && !msg.hasQuoteType()) || (!hasQuoteType() && msg.hasQuoteType())) return false;
		if (!(!hasQuoteType() && !msg.hasQuoteType()) && !(getQuoteType()==msg.getQuoteType())) return false;
		if ((hasSettlType() && !msg.hasSettlType()) || (!hasSettlType() && msg.hasSettlType())) return false;
		if (!(!hasSettlType() && !msg.hasSettlType()) && !FixUtils.equals(getSettlType(), msg.getSettlType())) return false;
		if ((hasSettlDate() && !msg.hasSettlDate()) || (!hasSettlDate() && msg.hasSettlDate())) return false;
		if ((hasMDEntrySize() && !msg.hasMDEntrySize()) || (!hasMDEntrySize() && msg.hasMDEntrySize())) return false;
		if (!(!hasMDEntrySize() && !msg.hasMDEntrySize()) && !(getMDEntrySize()==msg.getMDEntrySize())) return false;
		if ((hasMDStreamID() && !msg.hasMDStreamID()) || (!hasMDStreamID() && msg.hasMDStreamID())) return false;
		if (!(!hasMDStreamID() && !msg.hasMDStreamID()) && !FixUtils.equals(getMDStreamID(), msg.getMDStreamID())) return false;
		return true;
	}
	public FixInstrmtMDReqGrp clone ( FixInstrmtMDReqGrp out ) {
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasQuoteType())
			out.setQuoteType(getQuoteType());
		if ( hasSettlType())
			out.setSettlType(getSettlType());
		if ( hasSettlDate())
			out.setSettlDate(getSettlDate());
		if ( hasMDEntrySize())
			out.setMDEntrySize(getMDEntrySize());
		if ( hasMDStreamID())
			out.setMDStreamID(getMDStreamID());
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
