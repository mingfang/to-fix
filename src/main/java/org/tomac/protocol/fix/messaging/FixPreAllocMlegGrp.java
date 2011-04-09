package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixPreAllocMlegGrp extends FixGroup {
	private short hasAllocAccount;
	byte[] allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocAcctIDSource;
	long allocAcctIDSource = 0;		
	private short hasAllocSettlCurrency;
	byte[] allocSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasIndividualAllocID;
	byte[] individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocQty;
	long allocQty = 0;		
		public FixNestedParties3[] nestedParties3;
	
	public FixPreAllocMlegGrp() {
		this(false);
	}

	public FixPreAllocMlegGrp(boolean isRequired) {
		super(FixTags.ALLOCACCOUNT_INT);

		this.isRequired = isRequired;
		
		hasAllocAccount = FixUtils.TAG_HAS_NO_VALUE;		
		allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		allocSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocQty = FixUtils.TAG_HAS_NO_VALUE;		
		nestedParties3 = new FixNestedParties3[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedParties3[i] = new FixNestedParties3();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasAllocAccount()) return true;
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
            	case FixTags.ALLOCACCOUNT_INT:		
            		hasAllocAccount = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCACCTIDSOURCE_INT:		
            		hasAllocAcctIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCSETTLCURRENCY_INT:		
            		hasAllocSettlCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.INDIVIDUALALLOCID_INT:		
            		hasIndividualAllocID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCQTY_INT:		
            		hasAllocQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTED3PARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !nestedParties3[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = nestedParties3[count].setBuffer( repeatingGroupTag, buf, err);	
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
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasAllocAccount = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocQty = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNestedParties3 fixNestedParties3 : nestedParties3) fixNestedParties3.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasAllocAccount()) {		
			out.put(FixTags.ALLOCACCOUNT);

			out.put((byte) '=');

			FixUtils.put(out,allocAccount); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocAcctIDSource()) {		
			out.put(FixTags.ALLOCACCTIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocAcctIDSource);
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocSettlCurrency()) {		
			out.put(FixTags.ALLOCSETTLCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,allocSettlCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasIndividualAllocID()) {		
			out.put(FixTags.INDIVIDUALALLOCID);

			out.put((byte) '=');

			FixUtils.put(out,individualAllocID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocQty()) {		
			out.put(FixTags.ALLOCQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocQty);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(nestedParties3)>0) {
			out.put(FixTags.NONESTED3PARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(nestedParties3));

			out.put(FixUtils.SOH);

		}
		for (FixNestedParties3 fixNestedParties3 : nestedParties3) if (fixNestedParties3.hasGroup()) fixNestedParties3.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasAllocAccount()) {		
			FixUtils.put(out,allocAccount); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocAcctIDSource()) {		
			FixUtils.put(out, (long)allocAcctIDSource);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocSettlCurrency()) {		
			FixUtils.put(out,allocSettlCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIndividualAllocID()) {		
			FixUtils.put(out,individualAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocQty()) {		
			FixUtils.put(out, (long)allocQty);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNestedParties3 fixNestedParties3 : nestedParties3) fixNestedParties3.printBuffer(out);
	}

	public byte[] getAllocAccount() { 		
		if ( hasAllocAccount()) {		
			if (hasAllocAccount == FixUtils.TAG_HAS_VALUE) {		
				return allocAccount; 		
			} else {		
		
				buf.position(hasAllocAccount);		
		
			FixUtils.getTagStringValue(buf, allocAccount, 0, allocAccount.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocAccount);		
					return null;		
				}		
			}		
			hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
			return allocAccount;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocAccount() { return hasAllocAccount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocAccount(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAccount()) FixUtils.fillNul(allocAccount);		
		FixUtils.copy(allocAccount, src); 		
		hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocAccount(String str) {		
		if (str == null ) return;
		if (hasAllocAccount()) FixUtils.fillNul(allocAccount);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocAccount, src); 		
		hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAllocAcctIDSource() { 		
		if ( hasAllocAcctIDSource()) {		
			if (hasAllocAcctIDSource == FixUtils.TAG_HAS_VALUE) {		
				return allocAcctIDSource; 		
			} else {		
		
				buf.position(hasAllocAcctIDSource);		
		
			allocAcctIDSource = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocAcctIDSource);		
					return 0;		
				}		
			}		
			hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
			return allocAcctIDSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocAcctIDSource() { return hasAllocAcctIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocAcctIDSource(long src) {		
		allocAcctIDSource = src;
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocAcctIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasAllocAcctIDSource()) allocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		allocAcctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocAcctIDSource(String str) {		
		if (str == null ) return;
		if (hasAllocAcctIDSource()) allocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocAcctIDSource = FixUtils.longValueOf(src, 0, src.length);
		hasAllocAcctIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getAllocSettlCurrency() { 		
		if ( hasAllocSettlCurrency()) {		
			if (hasAllocSettlCurrency == FixUtils.TAG_HAS_VALUE) {		
				return allocSettlCurrency; 		
			} else {		
		
				buf.position(hasAllocSettlCurrency);		
		
			FixUtils.getTagStringValue(buf, allocSettlCurrency, 0, allocSettlCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocSettlCurrency);		
					return null;		
				}		
			}		
			hasAllocSettlCurrency = FixUtils.TAG_HAS_VALUE;		
			return allocSettlCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocSettlCurrency() { return hasAllocSettlCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocSettlCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasAllocSettlCurrency()) FixUtils.fillNul(allocSettlCurrency);		
		FixUtils.copy(allocSettlCurrency, src); 		
		hasAllocSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocSettlCurrency(String str) {		
		if (str == null ) return;
		if (hasAllocSettlCurrency()) FixUtils.fillNul(allocSettlCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocSettlCurrency, src); 		
		hasAllocSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getIndividualAllocID() { 		
		if ( hasIndividualAllocID()) {		
			if (hasIndividualAllocID == FixUtils.TAG_HAS_VALUE) {		
				return individualAllocID; 		
			} else {		
		
				buf.position(hasIndividualAllocID);		
		
			FixUtils.getTagStringValue(buf, individualAllocID, 0, individualAllocID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasIndividualAllocID);		
					return null;		
				}		
			}		
			hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
			return individualAllocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasIndividualAllocID() { return hasIndividualAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setIndividualAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasIndividualAllocID()) FixUtils.fillNul(individualAllocID);		
		FixUtils.copy(individualAllocID, src); 		
		hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setIndividualAllocID(String str) {		
		if (str == null ) return;
		if (hasIndividualAllocID()) FixUtils.fillNul(individualAllocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(individualAllocID, src); 		
		hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAllocQty() { 		
		if ( hasAllocQty()) {		
			if (hasAllocQty == FixUtils.TAG_HAS_VALUE) {		
				return allocQty; 		
			} else {		
		
				buf.position(hasAllocQty);		
		
			allocQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocQty);		
					return 0;		
				}		
			}		
			hasAllocQty = FixUtils.TAG_HAS_VALUE;		
			return allocQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocQty() { return hasAllocQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocQty(long src) {		
		allocQty = src;
		hasAllocQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocQty(byte[] src) {		
		if (src == null ) return;
		if (hasAllocQty()) allocQty = FixUtils.TAG_HAS_NO_VALUE;		
		allocQty = FixUtils.longValueOf(src, 0, src.length);
		hasAllocQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocQty(String str) {		
		if (str == null ) return;
		if (hasAllocQty()) allocQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocQty = FixUtils.longValueOf(src, 0, src.length);
		hasAllocQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasAllocAccount()) s += "AllocAccount(79)= " + new String( FixUtils.trim(getAllocAccount()) ) + "\n" ; 
		if (hasAllocAcctIDSource()) s += "AllocAcctIDSource(661)= " + getAllocAcctIDSource() + "\n" ; 
		if (hasAllocSettlCurrency()) s += "AllocSettlCurrency(736)= " + new String( FixUtils.trim(getAllocSettlCurrency()) ) + "\n" ; 
		if (hasIndividualAllocID()) s += "IndividualAllocID(467)= " + new String( FixUtils.trim(getIndividualAllocID()) ) + "\n" ; 
		if (hasAllocQty()) s += "AllocQty(80)= " + getAllocQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

		for (FixNestedParties3 fixNestedParties3 : nestedParties3) fixNestedParties3.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPreAllocMlegGrp)) return false;

		FixPreAllocMlegGrp msg = (FixPreAllocMlegGrp) o;

		for (int i = 0; i < nestedParties3.length; i++)
			if (!nestedParties3[i].equals(msg.nestedParties3[i])) return false;
		if ((hasAllocAccount() && !msg.hasAllocAccount()) || (!hasAllocAccount() && msg.hasAllocAccount())) return false;
		if (!(!hasAllocAccount() && !msg.hasAllocAccount()) && !FixUtils.equals(getAllocAccount(), msg.getAllocAccount())) return false;
		if ((hasAllocAcctIDSource() && !msg.hasAllocAcctIDSource()) || (!hasAllocAcctIDSource() && msg.hasAllocAcctIDSource())) return false;
		if (!(!hasAllocAcctIDSource() && !msg.hasAllocAcctIDSource()) && !(getAllocAcctIDSource()==msg.getAllocAcctIDSource())) return false;
		if ((hasAllocSettlCurrency() && !msg.hasAllocSettlCurrency()) || (!hasAllocSettlCurrency() && msg.hasAllocSettlCurrency())) return false;
		if (!(!hasAllocSettlCurrency() && !msg.hasAllocSettlCurrency()) && !FixUtils.equals(getAllocSettlCurrency(), msg.getAllocSettlCurrency())) return false;
		if ((hasIndividualAllocID() && !msg.hasIndividualAllocID()) || (!hasIndividualAllocID() && msg.hasIndividualAllocID())) return false;
		if (!(!hasIndividualAllocID() && !msg.hasIndividualAllocID()) && !FixUtils.equals(getIndividualAllocID(), msg.getIndividualAllocID())) return false;
		if ((hasAllocQty() && !msg.hasAllocQty()) || (!hasAllocQty() && msg.hasAllocQty())) return false;
		if (!(!hasAllocQty() && !msg.hasAllocQty()) && !(getAllocQty()==msg.getAllocQty())) return false;
		return true;
	}
	public FixPreAllocMlegGrp clone ( FixPreAllocMlegGrp out ) {
		if ( hasAllocAccount())
			out.setAllocAccount(getAllocAccount());
		if ( hasAllocAcctIDSource())
			out.setAllocAcctIDSource(getAllocAcctIDSource());
		if ( hasAllocSettlCurrency())
			out.setAllocSettlCurrency(getAllocSettlCurrency());
		if ( hasIndividualAllocID())
			out.setIndividualAllocID(getIndividualAllocID());
		if ( hasAllocQty())
			out.setAllocQty(getAllocQty());
		int count = 0;
		count = 0;
		for (FixNestedParties3 fixNestedParties3 : nestedParties3) {
			if (!fixNestedParties3.hasGroup()) continue;
			out.nestedParties3[count] = fixNestedParties3.clone( out.nestedParties3[count] );
			count++;
		}
		return out;
	}

}
