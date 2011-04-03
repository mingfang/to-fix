package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTrdAllocGrp extends FixGroup {
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
	private short hasAllocCustomerCapacity;
	byte[] allocCustomerCapacity = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocMethod;
	long allocMethod = 0;		
	private short hasSecondaryIndividualAllocID;
	byte[] secondaryIndividualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocClearingFeeIndicator;
	byte[] allocClearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixNestedParties2[] nestedParties2;
	
	public FixTrdAllocGrp() {
		this(false);
	}

	public FixTrdAllocGrp(boolean isRequired) {
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
		hasAllocCustomerCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		allocCustomerCapacity = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecondaryIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryIndividualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocClearingFeeIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		allocClearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		nestedParties2 = new FixNestedParties2[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedParties2[i] = new FixNestedParties2();
		
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
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCACCTIDSOURCE_INT:		
            		hasAllocAcctIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCSETTLCURRENCY_INT:		
            		hasAllocSettlCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.INDIVIDUALALLOCID_INT:		
            		hasIndividualAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCQTY_INT:		
            		hasAllocQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCCUSTOMERCAPACITY_INT:		
            		hasAllocCustomerCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCMETHOD_INT:		
            		hasAllocMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYINDIVIDUALALLOCID_INT:		
            		hasSecondaryIndividualAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCCLEARINGFEEINDICATOR_INT:		
            		hasAllocClearingFeeIndicator = (short) buf.position();		
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
		hasAllocAccount = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocQty = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocCustomerCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocClearingFeeIndicator = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNestedParties2 fixNestedParties2 : nestedParties2) fixNestedParties2.clear();
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

		if (hasAllocCustomerCapacity()) {		
			out.put(FixTags.ALLOCCUSTOMERCAPACITY);

			out.put((byte) '=');

			FixUtils.put(out,allocCustomerCapacity); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocMethod()) {		
			out.put(FixTags.ALLOCMETHOD);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocMethod);
		
			out.put(FixUtils.SOH);

            }

		if (hasSecondaryIndividualAllocID()) {		
			out.put(FixTags.SECONDARYINDIVIDUALALLOCID);

			out.put((byte) '=');

			FixUtils.put(out,secondaryIndividualAllocID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocClearingFeeIndicator()) {		
			out.put(FixTags.ALLOCCLEARINGFEEINDICATOR);

			out.put((byte) '=');

			FixUtils.put(out,allocClearingFeeIndicator); 		
		
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
		
		if (hasAllocCustomerCapacity()) {		
			FixUtils.put(out,allocCustomerCapacity); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocMethod()) {		
			FixUtils.put(out, (long)allocMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryIndividualAllocID()) {		
			FixUtils.put(out,secondaryIndividualAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocClearingFeeIndicator()) {		
			FixUtils.put(out,allocClearingFeeIndicator); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNestedParties2 fixNestedParties2 : nestedParties2) fixNestedParties2.printBuffer(out);
	}

	public byte[] getAllocAccount() { 		
		if ( hasAllocAccount()) {		
			if (hasAllocAccount == FixUtils.TAG_HAS_VALUE) {		
				return allocAccount; 		
			} else {		
		
				buf.position(hasAllocAccount);		
		
			FixMessage.getTagStringValue(buf, allocAccount, 0, allocAccount.length, err);
		
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
		if (hasAllocAccount()) FixUtils.fillSpace(allocAccount);		
		FixUtils.copy(allocAccount, src); 		
		hasAllocAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocAccount(String str) {		
		if (str == null ) return;
		if (hasAllocAccount()) FixUtils.fillSpace(allocAccount);		
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
		
			allocAcctIDSource = FixMessage.getTagIntValue(buf, err);
		
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
		
			FixMessage.getTagStringValue(buf, allocSettlCurrency, 0, allocSettlCurrency.length, err);
		
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
		if (hasAllocSettlCurrency()) FixUtils.fillSpace(allocSettlCurrency);		
		FixUtils.copy(allocSettlCurrency, src); 		
		hasAllocSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocSettlCurrency(String str) {		
		if (str == null ) return;
		if (hasAllocSettlCurrency()) FixUtils.fillSpace(allocSettlCurrency);		
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
		
			FixMessage.getTagStringValue(buf, individualAllocID, 0, individualAllocID.length, err);
		
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
		if (hasIndividualAllocID()) FixUtils.fillSpace(individualAllocID);		
		FixUtils.copy(individualAllocID, src); 		
		hasIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setIndividualAllocID(String str) {		
		if (str == null ) return;
		if (hasIndividualAllocID()) FixUtils.fillSpace(individualAllocID);		
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
		
			allocQty = FixMessage.getTagFloatValue(buf, err);
		
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
			
	public byte[] getAllocCustomerCapacity() { 		
		if ( hasAllocCustomerCapacity()) {		
			if (hasAllocCustomerCapacity == FixUtils.TAG_HAS_VALUE) {		
				return allocCustomerCapacity; 		
			} else {		
		
				buf.position(hasAllocCustomerCapacity);		
		
			FixMessage.getTagStringValue(buf, allocCustomerCapacity, 0, allocCustomerCapacity.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocCustomerCapacity);		
					return null;		
				}		
			}		
			hasAllocCustomerCapacity = FixUtils.TAG_HAS_VALUE;		
			return allocCustomerCapacity;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocCustomerCapacity() { return hasAllocCustomerCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocCustomerCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasAllocCustomerCapacity()) FixUtils.fillSpace(allocCustomerCapacity);		
		FixUtils.copy(allocCustomerCapacity, src); 		
		hasAllocCustomerCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocCustomerCapacity(String str) {		
		if (str == null ) return;
		if (hasAllocCustomerCapacity()) FixUtils.fillSpace(allocCustomerCapacity);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocCustomerCapacity, src); 		
		hasAllocCustomerCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getAllocMethod() { 		
		if ( hasAllocMethod()) {		
			if (hasAllocMethod == FixUtils.TAG_HAS_VALUE) {		
				return allocMethod; 		
			} else {		
		
				buf.position(hasAllocMethod);		
		
			allocMethod = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocMethod);		
					return 0;		
				}		
			}		
			hasAllocMethod = FixUtils.TAG_HAS_VALUE;		
			return allocMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocMethod() { return hasAllocMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocMethod(long src) {		
		allocMethod = src;
		hasAllocMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocMethod(byte[] src) {		
		if (src == null ) return;
		if (hasAllocMethod()) allocMethod = FixUtils.TAG_HAS_NO_VALUE;		
		allocMethod = FixUtils.longValueOf(src, 0, src.length);
		hasAllocMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocMethod(String str) {		
		if (str == null ) return;
		if (hasAllocMethod()) allocMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocMethod = FixUtils.longValueOf(src, 0, src.length);
		hasAllocMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecondaryIndividualAllocID() { 		
		if ( hasSecondaryIndividualAllocID()) {		
			if (hasSecondaryIndividualAllocID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryIndividualAllocID; 		
			} else {		
		
				buf.position(hasSecondaryIndividualAllocID);		
		
			FixMessage.getTagStringValue(buf, secondaryIndividualAllocID, 0, secondaryIndividualAllocID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryIndividualAllocID);		
					return null;		
				}		
			}		
			hasSecondaryIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
			return secondaryIndividualAllocID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryIndividualAllocID() { return hasSecondaryIndividualAllocID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecondaryIndividualAllocID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryIndividualAllocID()) FixUtils.fillSpace(secondaryIndividualAllocID);		
		FixUtils.copy(secondaryIndividualAllocID, src); 		
		hasSecondaryIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryIndividualAllocID(String str) {		
		if (str == null ) return;
		if (hasSecondaryIndividualAllocID()) FixUtils.fillSpace(secondaryIndividualAllocID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryIndividualAllocID, src); 		
		hasSecondaryIndividualAllocID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getAllocClearingFeeIndicator() { 		
		if ( hasAllocClearingFeeIndicator()) {		
			if (hasAllocClearingFeeIndicator == FixUtils.TAG_HAS_VALUE) {		
				return allocClearingFeeIndicator; 		
			} else {		
		
				buf.position(hasAllocClearingFeeIndicator);		
		
			FixMessage.getTagStringValue(buf, allocClearingFeeIndicator, 0, allocClearingFeeIndicator.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocClearingFeeIndicator);		
					return null;		
				}		
			}		
			hasAllocClearingFeeIndicator = FixUtils.TAG_HAS_VALUE;		
			return allocClearingFeeIndicator;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocClearingFeeIndicator() { return hasAllocClearingFeeIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocClearingFeeIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasAllocClearingFeeIndicator()) FixUtils.fillSpace(allocClearingFeeIndicator);		
		FixUtils.copy(allocClearingFeeIndicator, src); 		
		hasAllocClearingFeeIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocClearingFeeIndicator(String str) {		
		if (str == null ) return;
		if (hasAllocClearingFeeIndicator()) FixUtils.fillSpace(allocClearingFeeIndicator);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocClearingFeeIndicator, src); 		
		hasAllocClearingFeeIndicator = FixUtils.TAG_HAS_VALUE;		
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
		if (hasAllocCustomerCapacity()) s += "AllocCustomerCapacity(993)= " + new String( FixUtils.trim(getAllocCustomerCapacity()) ) + "\n" ; 
		if (hasAllocMethod()) s += "AllocMethod(1002)= " + getAllocMethod() + "\n" ; 
		if (hasSecondaryIndividualAllocID()) s += "SecondaryIndividualAllocID(989)= " + new String( FixUtils.trim(getSecondaryIndividualAllocID()) ) + "\n" ; 
		if (hasAllocClearingFeeIndicator()) s += "AllocClearingFeeIndicator(1136)= " + new String( FixUtils.trim(getAllocClearingFeeIndicator()) ) + "\n" ; 

		for (FixNestedParties2 fixNestedParties2 : nestedParties2) fixNestedParties2.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTrdAllocGrp)) return false;

		FixTrdAllocGrp msg = (FixTrdAllocGrp) o;

		for (int i = 0; i < nestedParties2.length; i++)
			if (!nestedParties2[i].equals(msg.nestedParties2[i])) return false;
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
		if ((hasAllocCustomerCapacity() && !msg.hasAllocCustomerCapacity()) || (!hasAllocCustomerCapacity() && msg.hasAllocCustomerCapacity())) return false;
		if (!(!hasAllocCustomerCapacity() && !msg.hasAllocCustomerCapacity()) && !FixUtils.equals(getAllocCustomerCapacity(), msg.getAllocCustomerCapacity())) return false;
		if ((hasAllocMethod() && !msg.hasAllocMethod()) || (!hasAllocMethod() && msg.hasAllocMethod())) return false;
		if (!(!hasAllocMethod() && !msg.hasAllocMethod()) && !(getAllocMethod()==msg.getAllocMethod())) return false;
		if ((hasSecondaryIndividualAllocID() && !msg.hasSecondaryIndividualAllocID()) || (!hasSecondaryIndividualAllocID() && msg.hasSecondaryIndividualAllocID())) return false;
		if (!(!hasSecondaryIndividualAllocID() && !msg.hasSecondaryIndividualAllocID()) && !FixUtils.equals(getSecondaryIndividualAllocID(), msg.getSecondaryIndividualAllocID())) return false;
		if ((hasAllocClearingFeeIndicator() && !msg.hasAllocClearingFeeIndicator()) || (!hasAllocClearingFeeIndicator() && msg.hasAllocClearingFeeIndicator())) return false;
		if (!(!hasAllocClearingFeeIndicator() && !msg.hasAllocClearingFeeIndicator()) && !FixUtils.equals(getAllocClearingFeeIndicator(), msg.getAllocClearingFeeIndicator())) return false;
		return true;
	}
	public FixTrdAllocGrp clone ( FixTrdAllocGrp out ) {
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
		if ( hasAllocCustomerCapacity())
			out.setAllocCustomerCapacity(getAllocCustomerCapacity());
		if ( hasAllocMethod())
			out.setAllocMethod(getAllocMethod());
		if ( hasSecondaryIndividualAllocID())
			out.setSecondaryIndividualAllocID(getSecondaryIndividualAllocID());
		if ( hasAllocClearingFeeIndicator())
			out.setAllocClearingFeeIndicator(getAllocClearingFeeIndicator());
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
