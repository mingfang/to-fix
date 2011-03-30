package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixLegPreAllocGrp extends FixGroup {
	private short hasLegAllocAccount;
	byte[] legAllocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegIndividualAllocID;
	byte[] legIndividualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegAllocQty;
	long legAllocQty = 0;		
	private short hasLegAllocAcctIDSource;
	byte[] legAllocAcctIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegAllocSettlCurrency;
	byte[] legAllocSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		public FixNestedParties2[] nestedParties2;
	
	public FixLegPreAllocGrp() {
		this(false);
	}

	public FixLegPreAllocGrp(boolean isRequired) {
		super(FixTags.LEGALLOCACCOUNT_INT);

		this.isRequired = isRequired;
		
		hasLegAllocAccount = FixUtils.TAG_HAS_NO_VALUE;		
		legAllocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		legIndividualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegAllocQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegAllocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		legAllocAcctIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegAllocSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		legAllocSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		nestedParties2 = new FixNestedParties2[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedParties2[i] = new FixNestedParties2();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasLegAllocAccount()) return true;
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
            	case FixTags.LEGALLOCACCOUNT_INT:		
            		hasLegAllocAccount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGINDIVIDUALALLOCID_INT:		
            		hasLegIndividualAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGALLOCQTY_INT:		
            		hasLegAllocQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGALLOCACCTIDSOURCE_INT:		
            		hasLegAllocAcctIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGALLOCSETTLCURRENCY_INT:		
            		hasLegAllocSettlCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTED2PARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !nestedParties2[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = nestedParties2[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasLegAllocAccount = FixUtils.TAG_HAS_NO_VALUE;
		hasLegIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;
		hasLegAllocQty = FixUtils.TAG_HAS_NO_VALUE;
		hasLegAllocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasLegAllocSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNestedParties2 fixNestedParties2 : nestedParties2) fixNestedParties2.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasLegAllocAccount()) {		
			out.put(FixTags.LEGALLOCACCOUNT);

			out.put((byte) '=');

			FixUtils.put(out,legAllocAccount); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegIndividualAllocID()) {		
			out.put(FixTags.LEGINDIVIDUALALLOCID);

			out.put((byte) '=');

			FixUtils.put(out,legIndividualAllocID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegAllocQty()) {		
			out.put(FixTags.LEGALLOCQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)legAllocQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegAllocAcctIDSource()) {		
			out.put(FixTags.LEGALLOCACCTIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,legAllocAcctIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegAllocSettlCurrency()) {		
			out.put(FixTags.LEGALLOCSETTLCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,legAllocSettlCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(nestedParties2)>0) {
			out.put(FixTags.NONESTED2PARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(nestedParties2));

			out.put(FixUtils.SOH);

		}
		for (FixNestedParties2 fixNestedParties2 : nestedParties2) if (fixNestedParties2.hasGroup()) fixNestedParties2.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasLegAllocAccount()) {		
			FixUtils.put(out,legAllocAccount); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegIndividualAllocID()) {		
			FixUtils.put(out,legIndividualAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegAllocQty()) {		
			FixUtils.put(out, (long)legAllocQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegAllocAcctIDSource()) {		
			FixUtils.put(out,legAllocAcctIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegAllocSettlCurrency()) {		
			FixUtils.put(out,legAllocSettlCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNestedParties2 fixNestedParties2 : nestedParties2) fixNestedParties2.printBuffer(out);
	}

	public byte[] getLegAllocAccount() { 		
		if ( hasLegAllocAccount()) {		
			if (hasLegAllocAccount == FixUtils.TAG_HAS_VALUE) {		
				return legAllocAccount; 		
			} else {		
		
				buf.position(hasLegAllocAccount);		
		
			FixMessage.getTagStringValue(buf, legAllocAccount, 0, legAllocAccount.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegAllocAccount);		
					return null;		
				}		
			}		
			hasLegAllocAccount = FixUtils.TAG_HAS_VALUE;		
			return legAllocAccount;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegAllocAccount() { return hasLegAllocAccount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegAllocAccount(byte[] src) {		
		if (src == null ) return;
		if (hasLegAllocAccount()) FixUtils.fillSpace(legAllocAccount);		
		FixUtils.copy(legAllocAccount, src); 		
		hasLegAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegAllocAccount(String str) {		
		if (str == null ) return;
		if (hasLegAllocAccount()) FixUtils.fillSpace(legAllocAccount);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legAllocAccount, src); 		
		hasLegAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegIndividualAllocID() { 		
		if ( hasLegIndividualAllocID()) {		
			if (hasLegIndividualAllocID == FixUtils.TAG_HAS_VALUE) {		
				return legIndividualAllocID; 		
			} else {		
		
				buf.position(hasLegIndividualAllocID);		
		
			FixMessage.getTagStringValue(buf, legIndividualAllocID, 0, legIndividualAllocID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegIndividualAllocID);		
					return null;		
				}		
			}		
			hasLegIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
			return legIndividualAllocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegIndividualAllocID() { return hasLegIndividualAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegIndividualAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasLegIndividualAllocID()) FixUtils.fillSpace(legIndividualAllocID);		
		FixUtils.copy(legIndividualAllocID, src); 		
		hasLegIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegIndividualAllocID(String str) {		
		if (str == null ) return;
		if (hasLegIndividualAllocID()) FixUtils.fillSpace(legIndividualAllocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legIndividualAllocID, src); 		
		hasLegIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegAllocQty() { 		
		if ( hasLegAllocQty()) {		
			if (hasLegAllocQty == FixUtils.TAG_HAS_VALUE) {		
				return legAllocQty; 		
			} else {		
		
				buf.position(hasLegAllocQty);		
		
			legAllocQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegAllocQty);		
					return 0;		
				}		
			}		
			hasLegAllocQty = FixUtils.TAG_HAS_VALUE;		
			return legAllocQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegAllocQty() { return hasLegAllocQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegAllocQty(long src) {		
		legAllocQty = src;
		hasLegAllocQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegAllocQty(byte[] src) {		
		if (src == null ) return;
		if (hasLegAllocQty()) legAllocQty = FixUtils.TAG_HAS_NO_VALUE;		
		legAllocQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegAllocQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegAllocQty(String str) {		
		if (str == null ) return;
		if (hasLegAllocQty()) legAllocQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legAllocQty = FixUtils.longValueOf(src, 0, src.length);
		hasLegAllocQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegAllocAcctIDSource() { 		
		if ( hasLegAllocAcctIDSource()) {		
			if (hasLegAllocAcctIDSource == FixUtils.TAG_HAS_VALUE) {		
				return legAllocAcctIDSource; 		
			} else {		
		
				buf.position(hasLegAllocAcctIDSource);		
		
			FixMessage.getTagStringValue(buf, legAllocAcctIDSource, 0, legAllocAcctIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegAllocAcctIDSource);		
					return null;		
				}		
			}		
			hasLegAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
			return legAllocAcctIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegAllocAcctIDSource() { return hasLegAllocAcctIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegAllocAcctIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasLegAllocAcctIDSource()) FixUtils.fillSpace(legAllocAcctIDSource);		
		FixUtils.copy(legAllocAcctIDSource, src); 		
		hasLegAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegAllocAcctIDSource(String str) {		
		if (str == null ) return;
		if (hasLegAllocAcctIDSource()) FixUtils.fillSpace(legAllocAcctIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legAllocAcctIDSource, src); 		
		hasLegAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegAllocSettlCurrency() { 		
		if ( hasLegAllocSettlCurrency()) {		
			if (hasLegAllocSettlCurrency == FixUtils.TAG_HAS_VALUE) {		
				return legAllocSettlCurrency; 		
			} else {		
		
				buf.position(hasLegAllocSettlCurrency);		
		
			FixMessage.getTagStringValue(buf, legAllocSettlCurrency, 0, legAllocSettlCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegAllocSettlCurrency);		
					return null;		
				}		
			}		
			hasLegAllocSettlCurrency = FixUtils.TAG_HAS_VALUE;		
			return legAllocSettlCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegAllocSettlCurrency() { return hasLegAllocSettlCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegAllocSettlCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasLegAllocSettlCurrency()) FixUtils.fillSpace(legAllocSettlCurrency);		
		FixUtils.copy(legAllocSettlCurrency, src); 		
		hasLegAllocSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegAllocSettlCurrency(String str) {		
		if (str == null ) return;
		if (hasLegAllocSettlCurrency()) FixUtils.fillSpace(legAllocSettlCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legAllocSettlCurrency, src); 		
		hasLegAllocSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasLegAllocAccount()) s += "LegAllocAccount(671)= " + new String( FixUtils.trim(getLegAllocAccount()) ) + "\n" ; 
		if (hasLegIndividualAllocID()) s += "LegIndividualAllocID(672)= " + new String( FixUtils.trim(getLegIndividualAllocID()) ) + "\n" ; 
		if (hasLegAllocQty()) s += "LegAllocQty(673)= " + getLegAllocQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegAllocAcctIDSource()) s += "LegAllocAcctIDSource(674)= " + new String( FixUtils.trim(getLegAllocAcctIDSource()) ) + "\n" ; 
		if (hasLegAllocSettlCurrency()) s += "LegAllocSettlCurrency(1367)= " + new String( FixUtils.trim(getLegAllocSettlCurrency()) ) + "\n" ; 

		for (FixNestedParties2 fixNestedParties2 : nestedParties2) fixNestedParties2.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixLegPreAllocGrp)) return false;

		FixLegPreAllocGrp msg = (FixLegPreAllocGrp) o;

		for (FixNestedParties2 fixNestedParties2 : nestedParties2)
			if (!fixNestedParties2.equals(msg.nestedParties2)) return false;
		if ((hasLegAllocAccount() && !msg.hasLegAllocAccount()) || (!hasLegAllocAccount() && msg.hasLegAllocAccount())) return false;
		if (!(!hasLegAllocAccount() && !msg.hasLegAllocAccount()) && !FixUtils.equals(getLegAllocAccount(), msg.getLegAllocAccount())) return false;
		if ((hasLegIndividualAllocID() && !msg.hasLegIndividualAllocID()) || (!hasLegIndividualAllocID() && msg.hasLegIndividualAllocID())) return false;
		if (!(!hasLegIndividualAllocID() && !msg.hasLegIndividualAllocID()) && !FixUtils.equals(getLegIndividualAllocID(), msg.getLegIndividualAllocID())) return false;
		if ((hasLegAllocQty() && !msg.hasLegAllocQty()) || (!hasLegAllocQty() && msg.hasLegAllocQty())) return false;
		if (!(!hasLegAllocQty() && !msg.hasLegAllocQty()) && !(getLegAllocQty()==msg.getLegAllocQty())) return false;
		if ((hasLegAllocAcctIDSource() && !msg.hasLegAllocAcctIDSource()) || (!hasLegAllocAcctIDSource() && msg.hasLegAllocAcctIDSource())) return false;
		if (!(!hasLegAllocAcctIDSource() && !msg.hasLegAllocAcctIDSource()) && !FixUtils.equals(getLegAllocAcctIDSource(), msg.getLegAllocAcctIDSource())) return false;
		if ((hasLegAllocSettlCurrency() && !msg.hasLegAllocSettlCurrency()) || (!hasLegAllocSettlCurrency() && msg.hasLegAllocSettlCurrency())) return false;
		if (!(!hasLegAllocSettlCurrency() && !msg.hasLegAllocSettlCurrency()) && !FixUtils.equals(getLegAllocSettlCurrency(), msg.getLegAllocSettlCurrency())) return false;
		return true;
	}
	public FixLegPreAllocGrp clone ( FixLegPreAllocGrp out ) {
		if ( hasLegAllocAccount())
			out.setLegAllocAccount(getLegAllocAccount());
		if ( hasLegIndividualAllocID())
			out.setLegIndividualAllocID(getLegIndividualAllocID());
		if ( hasLegAllocQty())
			out.setLegAllocQty(getLegAllocQty());
		if ( hasLegAllocAcctIDSource())
			out.setLegAllocAcctIDSource(getLegAllocAcctIDSource());
		if ( hasLegAllocSettlCurrency())
			out.setLegAllocSettlCurrency(getLegAllocSettlCurrency());
		int count = 0;
		count = 0;
		for (FixNestedParties2 fixNestedParties2 : nestedParties2) {
			if (!fixNestedParties2.hasGroup()) continue;
			out.nestedParties2[count] = fixNestedParties2.clone( out.nestedParties2[count] );
			count++;
		}
		return out;
	}

}
