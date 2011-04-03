package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixQuotSetAckGrp extends FixGroup {
	private short hasQuoteSetID;
	byte[] quoteSetID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteSetValidUntilTime;
	byte[] quoteSetValidUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTotNoQuoteEntries;
	long totNoQuoteEntries = 0;		
	private short hasTotNoCxldQuotes;
	long totNoCxldQuotes = 0;		
	private short hasTotNoAccQuotes;
	long totNoAccQuotes = 0;		
	private short hasTotNoRejQuotes;
	long totNoRejQuotes = 0;		
	private short hasLastFragment;
		boolean lastFragment = false;		
		public FixUnderlyingInstrument underlyingInstrument;
		public FixQuotEntryAckGrp[] quotEntryAckGrp;
	
	public FixQuotSetAckGrp() {
		this(false);
	}

	public FixQuotSetAckGrp(boolean isRequired) {
		super(FixTags.QUOTESETID_INT);

		this.isRequired = isRequired;
		
		hasQuoteSetID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteSetID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteSetValidUntilTime = FixUtils.TAG_HAS_NO_VALUE;		
		quoteSetValidUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTotNoQuoteEntries = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotNoCxldQuotes = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotNoAccQuotes = FixUtils.TAG_HAS_NO_VALUE;		
		hasTotNoRejQuotes = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastFragment = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingInstrument = new FixUnderlyingInstrument();
		quotEntryAckGrp = new FixQuotEntryAckGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) quotEntryAckGrp[i] = new FixQuotEntryAckGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasQuoteSetID()) return true;
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
            	case FixTags.QUOTESETID_INT:		
            		hasQuoteSetID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.QUOTESETVALIDUNTILTIME_INT:		
            		hasQuoteSetValidUntilTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TOTNOQUOTEENTRIES_INT:		
            		hasTotNoQuoteEntries = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TOTNOCXLDQUOTES_INT:		
            		hasTotNoCxldQuotes = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TOTNOACCQUOTES_INT:		
            		hasTotNoAccQuotes = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TOTNOREJQUOTES_INT:		
            		hasTotNoRejQuotes = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LASTFRAGMENT_INT:		
            		hasLastFragment = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( underlyingInstrument.isKeyTag(tag)) {
        				tag = underlyingInstrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOQUOTEENTRIES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !quotEntryAckGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = quotEntryAckGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasQuoteSetID = FixUtils.TAG_HAS_NO_VALUE;
		hasQuoteSetValidUntilTime = FixUtils.TAG_HAS_NO_VALUE;
		hasTotNoQuoteEntries = FixUtils.TAG_HAS_NO_VALUE;
		hasTotNoCxldQuotes = FixUtils.TAG_HAS_NO_VALUE;
		hasTotNoAccQuotes = FixUtils.TAG_HAS_NO_VALUE;
		hasTotNoRejQuotes = FixUtils.TAG_HAS_NO_VALUE;
		hasLastFragment = FixUtils.TAG_HAS_NO_VALUE;
		underlyingInstrument.clear();
		for (FixQuotEntryAckGrp fixQuotEntryAckGrp : quotEntryAckGrp) fixQuotEntryAckGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasQuoteSetID()) {		
			out.put(FixTags.QUOTESETID);

			out.put((byte) '=');

			FixUtils.put(out,quoteSetID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasQuoteSetValidUntilTime()) {		
			out.put(FixTags.QUOTESETVALIDUNTILTIME);

			out.put((byte) '=');

			FixUtils.put(out,quoteSetValidUntilTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTotNoQuoteEntries()) {		
			out.put(FixTags.TOTNOQUOTEENTRIES);

			out.put((byte) '=');

			FixUtils.put(out, (long)totNoQuoteEntries);
		
			out.put(FixUtils.SOH);

            }

		if (hasTotNoCxldQuotes()) {		
			out.put(FixTags.TOTNOCXLDQUOTES);

			out.put((byte) '=');

			FixUtils.put(out, (long)totNoCxldQuotes);
		
			out.put(FixUtils.SOH);

            }

		if (hasTotNoAccQuotes()) {		
			out.put(FixTags.TOTNOACCQUOTES);

			out.put((byte) '=');

			FixUtils.put(out, (long)totNoAccQuotes);
		
			out.put(FixUtils.SOH);

            }

		if (hasTotNoRejQuotes()) {		
			out.put(FixTags.TOTNOREJQUOTES);

			out.put((byte) '=');

			FixUtils.put(out, (long)totNoRejQuotes);
		
			out.put(FixUtils.SOH);

            }

		if (hasLastFragment()) {		
			out.put(FixTags.LASTFRAGMENT);

			out.put((byte) '=');

			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		underlyingInstrument.encode(out);
		if (FixUtils.getNoInGroup(quotEntryAckGrp)>0) {
			out.put(FixTags.NOQUOTEENTRIES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(quotEntryAckGrp));

			out.put(FixUtils.SOH);

		}
		for (FixQuotEntryAckGrp fixQuotEntryAckGrp : quotEntryAckGrp) if (fixQuotEntryAckGrp.hasGroup()) fixQuotEntryAckGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasQuoteSetID()) {		
			FixUtils.put(out,quoteSetID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteSetValidUntilTime()) {		
			FixUtils.put(out,quoteSetValidUntilTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNoQuoteEntries()) {		
			FixUtils.put(out, (long)totNoQuoteEntries);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNoCxldQuotes()) {		
			FixUtils.put(out, (long)totNoCxldQuotes);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNoAccQuotes()) {		
			FixUtils.put(out, (long)totNoAccQuotes);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotNoRejQuotes()) {		
			FixUtils.put(out, (long)totNoRejQuotes);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastFragment()) {		
			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		underlyingInstrument.printBuffer(out);
		for (FixQuotEntryAckGrp fixQuotEntryAckGrp : quotEntryAckGrp) fixQuotEntryAckGrp.printBuffer(out);
	}

	public byte[] getQuoteSetID() { 		
		if ( hasQuoteSetID()) {		
			if (hasQuoteSetID == FixUtils.TAG_HAS_VALUE) {		
				return quoteSetID; 		
			} else {		
		
				buf.position(hasQuoteSetID);		
		
			FixMessage.getTagStringValue(buf, quoteSetID, 0, quoteSetID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasQuoteSetID);		
					return null;		
				}		
			}		
			hasQuoteSetID = FixUtils.TAG_HAS_VALUE;		
			return quoteSetID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteSetID() { return hasQuoteSetID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setQuoteSetID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteSetID()) FixUtils.fillSpace(quoteSetID);		
		FixUtils.copy(quoteSetID, src); 		
		hasQuoteSetID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setQuoteSetID(String str) {		
		if (str == null ) return;
		if (hasQuoteSetID()) FixUtils.fillSpace(quoteSetID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteSetID, src); 		
		hasQuoteSetID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getQuoteSetValidUntilTime() { 		
		if ( hasQuoteSetValidUntilTime()) {		
			if (hasQuoteSetValidUntilTime == FixUtils.TAG_HAS_VALUE) {		
				return quoteSetValidUntilTime; 		
			} else {		
		
				buf.position(hasQuoteSetValidUntilTime);		
		
			FixMessage.getTagStringValue(buf, quoteSetValidUntilTime, 0, quoteSetValidUntilTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasQuoteSetValidUntilTime);		
					return null;		
				}		
			}		
			hasQuoteSetValidUntilTime = FixUtils.TAG_HAS_VALUE;		
			return quoteSetValidUntilTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteSetValidUntilTime() { return hasQuoteSetValidUntilTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setQuoteSetValidUntilTime(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteSetValidUntilTime()) FixUtils.fillSpace(quoteSetValidUntilTime);		
		FixUtils.copy(quoteSetValidUntilTime, src); 		
		hasQuoteSetValidUntilTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setQuoteSetValidUntilTime(String str) {		
		if (str == null ) return;
		if (hasQuoteSetValidUntilTime()) FixUtils.fillSpace(quoteSetValidUntilTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteSetValidUntilTime, src); 		
		hasQuoteSetValidUntilTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTotNoQuoteEntries() { 		
		if ( hasTotNoQuoteEntries()) {		
			if (hasTotNoQuoteEntries == FixUtils.TAG_HAS_VALUE) {		
				return totNoQuoteEntries; 		
			} else {		
		
				buf.position(hasTotNoQuoteEntries);		
		
			totNoQuoteEntries = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTotNoQuoteEntries);		
					return 0;		
				}		
			}		
			hasTotNoQuoteEntries = FixUtils.TAG_HAS_VALUE;		
			return totNoQuoteEntries;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNoQuoteEntries() { return hasTotNoQuoteEntries != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTotNoQuoteEntries(long src) {		
		totNoQuoteEntries = src;
		hasTotNoQuoteEntries = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoQuoteEntries(byte[] src) {		
		if (src == null ) return;
		if (hasTotNoQuoteEntries()) totNoQuoteEntries = FixUtils.TAG_HAS_NO_VALUE;		
		totNoQuoteEntries = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoQuoteEntries = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTotNoQuoteEntries(String str) {		
		if (str == null ) return;
		if (hasTotNoQuoteEntries()) totNoQuoteEntries = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNoQuoteEntries = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoQuoteEntries = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTotNoCxldQuotes() { 		
		if ( hasTotNoCxldQuotes()) {		
			if (hasTotNoCxldQuotes == FixUtils.TAG_HAS_VALUE) {		
				return totNoCxldQuotes; 		
			} else {		
		
				buf.position(hasTotNoCxldQuotes);		
		
			totNoCxldQuotes = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTotNoCxldQuotes);		
					return 0;		
				}		
			}		
			hasTotNoCxldQuotes = FixUtils.TAG_HAS_VALUE;		
			return totNoCxldQuotes;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNoCxldQuotes() { return hasTotNoCxldQuotes != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTotNoCxldQuotes(long src) {		
		totNoCxldQuotes = src;
		hasTotNoCxldQuotes = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoCxldQuotes(byte[] src) {		
		if (src == null ) return;
		if (hasTotNoCxldQuotes()) totNoCxldQuotes = FixUtils.TAG_HAS_NO_VALUE;		
		totNoCxldQuotes = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoCxldQuotes = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTotNoCxldQuotes(String str) {		
		if (str == null ) return;
		if (hasTotNoCxldQuotes()) totNoCxldQuotes = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNoCxldQuotes = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoCxldQuotes = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTotNoAccQuotes() { 		
		if ( hasTotNoAccQuotes()) {		
			if (hasTotNoAccQuotes == FixUtils.TAG_HAS_VALUE) {		
				return totNoAccQuotes; 		
			} else {		
		
				buf.position(hasTotNoAccQuotes);		
		
			totNoAccQuotes = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTotNoAccQuotes);		
					return 0;		
				}		
			}		
			hasTotNoAccQuotes = FixUtils.TAG_HAS_VALUE;		
			return totNoAccQuotes;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNoAccQuotes() { return hasTotNoAccQuotes != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTotNoAccQuotes(long src) {		
		totNoAccQuotes = src;
		hasTotNoAccQuotes = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoAccQuotes(byte[] src) {		
		if (src == null ) return;
		if (hasTotNoAccQuotes()) totNoAccQuotes = FixUtils.TAG_HAS_NO_VALUE;		
		totNoAccQuotes = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoAccQuotes = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTotNoAccQuotes(String str) {		
		if (str == null ) return;
		if (hasTotNoAccQuotes()) totNoAccQuotes = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNoAccQuotes = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoAccQuotes = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTotNoRejQuotes() { 		
		if ( hasTotNoRejQuotes()) {		
			if (hasTotNoRejQuotes == FixUtils.TAG_HAS_VALUE) {		
				return totNoRejQuotes; 		
			} else {		
		
				buf.position(hasTotNoRejQuotes);		
		
			totNoRejQuotes = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTotNoRejQuotes);		
					return 0;		
				}		
			}		
			hasTotNoRejQuotes = FixUtils.TAG_HAS_VALUE;		
			return totNoRejQuotes;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotNoRejQuotes() { return hasTotNoRejQuotes != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTotNoRejQuotes(long src) {		
		totNoRejQuotes = src;
		hasTotNoRejQuotes = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotNoRejQuotes(byte[] src) {		
		if (src == null ) return;
		if (hasTotNoRejQuotes()) totNoRejQuotes = FixUtils.TAG_HAS_NO_VALUE;		
		totNoRejQuotes = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoRejQuotes = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTotNoRejQuotes(String str) {		
		if (str == null ) return;
		if (hasTotNoRejQuotes()) totNoRejQuotes = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totNoRejQuotes = FixUtils.longValueOf(src, 0, src.length);
		hasTotNoRejQuotes = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getLastFragment() { 		
		if ( hasLastFragment()) {		
			if (hasLastFragment == FixUtils.TAG_HAS_VALUE) {		
				return lastFragment; 		
			} else {		
		
				buf.position(hasLastFragment);		
		
			lastFragment = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasLastFragment);		
					return false;		
				}		
			}		
			hasLastFragment = FixUtils.TAG_HAS_VALUE;		
			return lastFragment;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasLastFragment() { return hasLastFragment != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLastFragment(boolean src) {		
		lastFragment = src;
		hasLastFragment = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastFragment(byte[] src) {		
		if (src == null ) return;
		if (hasLastFragment()) lastFragment = false;		
		lastFragment = src[0]==(byte)'Y'?true:false;		
		hasLastFragment = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLastFragment(String str) {		
		if (str == null ) return;
		if (hasLastFragment()) lastFragment = false;		
		byte[] src = str.getBytes(); 		
		lastFragment = src[0]==(byte)'Y'?true:false;		
		hasLastFragment = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasQuoteSetID()) s += "QuoteSetID(302)= " + new String( FixUtils.trim(getQuoteSetID()) ) + "\n" ; 
		if (hasQuoteSetValidUntilTime()) s += "QuoteSetValidUntilTime(367)= " + new String( FixUtils.trim(getQuoteSetValidUntilTime()) ) + "\n" ; 
		if (hasTotNoQuoteEntries()) s += "TotNoQuoteEntries(304)= " + getTotNoQuoteEntries() + "\n" ; 
		if (hasTotNoCxldQuotes()) s += "TotNoCxldQuotes(1168)= " + getTotNoCxldQuotes() + "\n" ; 
		if (hasTotNoAccQuotes()) s += "TotNoAccQuotes(1169)= " + getTotNoAccQuotes() + "\n" ; 
		if (hasTotNoRejQuotes()) s += "TotNoRejQuotes(1170)= " + getTotNoRejQuotes() + "\n" ; 
		if (hasLastFragment()) s += "LastFragment(893)= " + getLastFragment() + "\n" ; 

		s += underlyingInstrument.toString();
		for (FixQuotEntryAckGrp fixQuotEntryAckGrp : quotEntryAckGrp) fixQuotEntryAckGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixQuotSetAckGrp)) return false;

		FixQuotSetAckGrp msg = (FixQuotSetAckGrp) o;

		if (!underlyingInstrument.equals(msg.underlyingInstrument)) return false;
		for (int i = 0; i < quotEntryAckGrp.length; i++)
			if (!quotEntryAckGrp[i].equals(msg.quotEntryAckGrp[i])) return false;
		if ((hasQuoteSetID() && !msg.hasQuoteSetID()) || (!hasQuoteSetID() && msg.hasQuoteSetID())) return false;
		if (!(!hasQuoteSetID() && !msg.hasQuoteSetID()) && !FixUtils.equals(getQuoteSetID(), msg.getQuoteSetID())) return false;
		if ((hasQuoteSetValidUntilTime() && !msg.hasQuoteSetValidUntilTime()) || (!hasQuoteSetValidUntilTime() && msg.hasQuoteSetValidUntilTime())) return false;
		if ((hasTotNoQuoteEntries() && !msg.hasTotNoQuoteEntries()) || (!hasTotNoQuoteEntries() && msg.hasTotNoQuoteEntries())) return false;
		if (!(!hasTotNoQuoteEntries() && !msg.hasTotNoQuoteEntries()) && !(getTotNoQuoteEntries()==msg.getTotNoQuoteEntries())) return false;
		if ((hasTotNoCxldQuotes() && !msg.hasTotNoCxldQuotes()) || (!hasTotNoCxldQuotes() && msg.hasTotNoCxldQuotes())) return false;
		if (!(!hasTotNoCxldQuotes() && !msg.hasTotNoCxldQuotes()) && !(getTotNoCxldQuotes()==msg.getTotNoCxldQuotes())) return false;
		if ((hasTotNoAccQuotes() && !msg.hasTotNoAccQuotes()) || (!hasTotNoAccQuotes() && msg.hasTotNoAccQuotes())) return false;
		if (!(!hasTotNoAccQuotes() && !msg.hasTotNoAccQuotes()) && !(getTotNoAccQuotes()==msg.getTotNoAccQuotes())) return false;
		if ((hasTotNoRejQuotes() && !msg.hasTotNoRejQuotes()) || (!hasTotNoRejQuotes() && msg.hasTotNoRejQuotes())) return false;
		if (!(!hasTotNoRejQuotes() && !msg.hasTotNoRejQuotes()) && !(getTotNoRejQuotes()==msg.getTotNoRejQuotes())) return false;
		if ((hasLastFragment() && !msg.hasLastFragment()) || (!hasLastFragment() && msg.hasLastFragment())) return false;
		if (!(!hasLastFragment() && !msg.hasLastFragment()) && !(getLastFragment()==msg.getLastFragment())) return false;
		return true;
	}
	public FixQuotSetAckGrp clone ( FixQuotSetAckGrp out ) {
		if ( hasQuoteSetID())
			out.setQuoteSetID(getQuoteSetID());
		if ( hasQuoteSetValidUntilTime())
			out.setQuoteSetValidUntilTime(getQuoteSetValidUntilTime());
		if ( hasTotNoQuoteEntries())
			out.setTotNoQuoteEntries(getTotNoQuoteEntries());
		if ( hasTotNoCxldQuotes())
			out.setTotNoCxldQuotes(getTotNoCxldQuotes());
		if ( hasTotNoAccQuotes())
			out.setTotNoAccQuotes(getTotNoAccQuotes());
		if ( hasTotNoRejQuotes())
			out.setTotNoRejQuotes(getTotNoRejQuotes());
		if ( hasLastFragment())
			out.setLastFragment(getLastFragment());
		if (underlyingInstrument.hasGroup())
			out.underlyingInstrument = underlyingInstrument.clone( out.underlyingInstrument);
		int count = 0;
		count = 0;
		for (FixQuotEntryAckGrp fixQuotEntryAckGrp : quotEntryAckGrp) {
			if (!fixQuotEntryAckGrp.hasGroup()) continue;
			out.quotEntryAckGrp[count] = fixQuotEntryAckGrp.clone( out.quotEntryAckGrp[count] );
			count++;
		}
		return out;
	}

}
