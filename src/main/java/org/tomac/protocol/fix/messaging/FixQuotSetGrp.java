package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixQuotSetGrp extends FixGroup {
	private short hasQuoteSetID;
	byte[] quoteSetID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteSetValidUntilTime;
	byte[] quoteSetValidUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTotNoQuoteEntries;
	long totNoQuoteEntries = 0;		
	private short hasLastFragment;
		boolean lastFragment = false;		
		public FixUnderlyingInstrument underlyingInstrument;
		public FixQuotEntryGrp[] quotEntryGrp;
	
	public FixQuotSetGrp() {
		this(false);
	}

	public FixQuotSetGrp(boolean isRequired) {
		super(FixTags.QUOTESETID_INT);

		this.isRequired = isRequired;
		
		hasQuoteSetID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteSetID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteSetValidUntilTime = FixUtils.TAG_HAS_NO_VALUE;		
		quoteSetValidUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTotNoQuoteEntries = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastFragment = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingInstrument = new FixUnderlyingInstrument();
		quotEntryGrp = new FixQuotEntryGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) quotEntryGrp[i] = new FixQuotEntryGrp(true);
		
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
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.QUOTESETID_INT:		
            		hasQuoteSetID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.QUOTESETVALIDUNTILTIME_INT:		
            		hasQuoteSetValidUntilTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.TOTNOQUOTEENTRIES_INT:		
            		hasTotNoQuoteEntries = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LASTFRAGMENT_INT:		
            		hasLastFragment = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( underlyingInstrument.isKeyTag(tag)) {
        				tag = underlyingInstrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOQUOTEENTRIES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !quotEntryGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOQUOTEENTRIES_INT);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = quotEntryGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		if (!hasQuoteSetID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.QUOTESETID_INT);
			return false;
		}
		if (!hasTotNoQuoteEntries()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TOTNOQUOTEENTRIES_INT);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (quotEntryGrp[i].hasGroup()) quotEntryGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasQuoteSetID = FixUtils.TAG_HAS_NO_VALUE;
		hasQuoteSetValidUntilTime = FixUtils.TAG_HAS_NO_VALUE;
		hasTotNoQuoteEntries = FixUtils.TAG_HAS_NO_VALUE;
		hasLastFragment = FixUtils.TAG_HAS_NO_VALUE;
		underlyingInstrument.clear();
		for (FixQuotEntryGrp fixQuotEntryGrp : quotEntryGrp) fixQuotEntryGrp.clear();
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

		if (hasLastFragment()) {		
			out.put(FixTags.LASTFRAGMENT);

			out.put((byte) '=');

			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		underlyingInstrument.encode(out);
		if (FixUtils.getNoInGroup(quotEntryGrp)>0) {
			out.put(FixTags.NOQUOTEENTRIES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(quotEntryGrp));

			out.put(FixUtils.SOH);

		}
		for (FixQuotEntryGrp fixQuotEntryGrp : quotEntryGrp) if (fixQuotEntryGrp.hasGroup()) fixQuotEntryGrp.encode(out);
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
		
		if (hasLastFragment()) {		
			out.put(lastFragment?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		underlyingInstrument.printBuffer(out);
		for (FixQuotEntryGrp fixQuotEntryGrp : quotEntryGrp) fixQuotEntryGrp.printBuffer(out);
	}

	public byte[] getQuoteSetID() { 		
		if ( hasQuoteSetID()) {		
			if (hasQuoteSetID == FixUtils.TAG_HAS_VALUE) {		
				return quoteSetID; 		
			} else {		
		
				buf.position(hasQuoteSetID);		
		
			FixUtils.getTagStringValue(buf, quoteSetID, 0, quoteSetID.length, err);
		
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
		if (hasQuoteSetID()) FixUtils.fillNul(quoteSetID);		
		FixUtils.copy(quoteSetID, src); 		
		hasQuoteSetID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setQuoteSetID(String str) {		
		if (str == null ) return;
		if (hasQuoteSetID()) FixUtils.fillNul(quoteSetID);		
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
		
			FixUtils.getTagStringValue(buf, quoteSetValidUntilTime, 0, quoteSetValidUntilTime.length, err);
		
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
		if (hasQuoteSetValidUntilTime()) FixUtils.fillNul(quoteSetValidUntilTime);		
		FixUtils.copy(quoteSetValidUntilTime, src); 		
		hasQuoteSetValidUntilTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setQuoteSetValidUntilTime(String str) {		
		if (str == null ) return;
		if (hasQuoteSetValidUntilTime()) FixUtils.fillNul(quoteSetValidUntilTime);		
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
		
			totNoQuoteEntries = FixUtils.getTagIntValue(buf, err);
		
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
			
	public boolean getLastFragment() { 		
		if ( hasLastFragment()) {		
			if (hasLastFragment == FixUtils.TAG_HAS_VALUE) {		
				return lastFragment; 		
			} else {		
		
				buf.position(hasLastFragment);		
		
			lastFragment = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
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
		if (hasLastFragment()) s += "LastFragment(893)= " + getLastFragment() + "\n" ; 

		s += underlyingInstrument.toString();
		for (FixQuotEntryGrp fixQuotEntryGrp : quotEntryGrp) fixQuotEntryGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixQuotSetGrp)) return false;

		FixQuotSetGrp msg = (FixQuotSetGrp) o;

		if (!underlyingInstrument.equals(msg.underlyingInstrument)) return false;
		for (int i = 0; i < quotEntryGrp.length; i++)
			if (!quotEntryGrp[i].equals(msg.quotEntryGrp[i])) return false;
		if ((hasQuoteSetID() && !msg.hasQuoteSetID()) || (!hasQuoteSetID() && msg.hasQuoteSetID())) return false;
		if (!(!hasQuoteSetID() && !msg.hasQuoteSetID()) && !FixUtils.equals(getQuoteSetID(), msg.getQuoteSetID())) return false;
		if ((hasQuoteSetValidUntilTime() && !msg.hasQuoteSetValidUntilTime()) || (!hasQuoteSetValidUntilTime() && msg.hasQuoteSetValidUntilTime())) return false;
		if ((hasTotNoQuoteEntries() && !msg.hasTotNoQuoteEntries()) || (!hasTotNoQuoteEntries() && msg.hasTotNoQuoteEntries())) return false;
		if (!(!hasTotNoQuoteEntries() && !msg.hasTotNoQuoteEntries()) && !(getTotNoQuoteEntries()==msg.getTotNoQuoteEntries())) return false;
		if ((hasLastFragment() && !msg.hasLastFragment()) || (!hasLastFragment() && msg.hasLastFragment())) return false;
		if (!(!hasLastFragment() && !msg.hasLastFragment()) && !(getLastFragment()==msg.getLastFragment())) return false;
		return true;
	}
	public FixQuotSetGrp clone ( FixQuotSetGrp out ) {
		if ( hasQuoteSetID())
			out.setQuoteSetID(getQuoteSetID());
		if ( hasQuoteSetValidUntilTime())
			out.setQuoteSetValidUntilTime(getQuoteSetValidUntilTime());
		if ( hasTotNoQuoteEntries())
			out.setTotNoQuoteEntries(getTotNoQuoteEntries());
		if ( hasLastFragment())
			out.setLastFragment(getLastFragment());
		if (underlyingInstrument.hasGroup())
			out.underlyingInstrument = underlyingInstrument.clone( out.underlyingInstrument);
		int count = 0;
		count = 0;
		for (FixQuotEntryGrp fixQuotEntryGrp : quotEntryGrp) {
			if (!fixQuotEntryGrp.hasGroup()) continue;
			out.quotEntryGrp[count] = fixQuotEntryGrp.clone( out.quotEntryGrp[count] );
			count++;
		}
		return out;
	}

}
