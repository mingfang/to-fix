package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixAllocAckGrp extends FixGroup {
	private short hasAllocAccount;
	byte[] allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocAcctIDSource;
	long allocAcctIDSource = 0;		
	private short hasAllocPrice;
	long allocPrice = 0;		
	private short hasAllocPositionEffect;
	byte allocPositionEffect = (byte)' ';		
	private short hasIndividualAllocID;
	byte[] individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasIndividualAllocRejCode;
	long individualAllocRejCode = 0;		
	private short hasAllocText;
	byte[] allocText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedAllocTextLen;
	long encodedAllocTextLen = 0;		
	private short hasEncodedAllocText;
	byte[] encodedAllocText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasSecondaryIndividualAllocID;
	byte[] secondaryIndividualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAllocCustomerCapacity;
	byte[] allocCustomerCapacity = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasIndividualAllocType;
	long individualAllocType = 0;		
	private short hasAllocQty;
	long allocQty = 0;		
		public FixNestedParties[] nestedParties;
	
	public FixAllocAckGrp() {
		this(false);
	}

	public FixAllocAckGrp(boolean isRequired) {
		super(FixTags.ALLOCACCOUNT_INT);

		this.isRequired = isRequired;
		
		hasAllocAccount = FixUtils.TAG_HAS_NO_VALUE;		
		allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocAcctIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocPositionEffect = FixUtils.TAG_HAS_NO_VALUE;		
		hasIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasIndividualAllocRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocText = FixUtils.TAG_HAS_NO_VALUE;		
		allocText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedAllocTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedAllocText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedAllocText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasSecondaryIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryIndividualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAllocCustomerCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		allocCustomerCapacity = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasIndividualAllocType = FixUtils.TAG_HAS_NO_VALUE;		
		hasAllocQty = FixUtils.TAG_HAS_NO_VALUE;		
		nestedParties = new FixNestedParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedParties[i] = new FixNestedParties();
		
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
            	case FixTags.ALLOCPRICE_INT:		
            		hasAllocPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCPOSITIONEFFECT_INT:		
            		hasAllocPositionEffect = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.INDIVIDUALALLOCID_INT:		
            		hasIndividualAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.INDIVIDUALALLOCREJCODE_INT:		
            		hasIndividualAllocRejCode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCTEXT_INT:		
            		hasAllocText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDALLOCTEXTLEN_INT:		
            		hasEncodedAllocTextLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDALLOCTEXT_INT:		
            		hasEncodedAllocText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYINDIVIDUALALLOCID_INT:		
            		hasSecondaryIndividualAllocID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCCUSTOMERCAPACITY_INT:		
            		hasAllocCustomerCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.INDIVIDUALALLOCTYPE_INT:		
            		hasIndividualAllocType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ALLOCQTY_INT:		
            		hasAllocQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTEDPARTYIDS_INT ) {
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
		hasAllocPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocPositionEffect = FixUtils.TAG_HAS_NO_VALUE;
		hasIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;
		hasIndividualAllocRejCode = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocText = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedAllocTextLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedAllocText = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryIndividualAllocID = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocCustomerCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasIndividualAllocType = FixUtils.TAG_HAS_NO_VALUE;
		hasAllocQty = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.clear();
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

		if (hasAllocPrice()) {		
			out.put(FixTags.ALLOCPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocPositionEffect()) {		
			out.put(FixTags.ALLOCPOSITIONEFFECT);

			out.put((byte) '=');

			FixUtils.put(out,allocPositionEffect); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasIndividualAllocID()) {		
			out.put(FixTags.INDIVIDUALALLOCID);

			out.put((byte) '=');

			FixUtils.put(out,individualAllocID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasIndividualAllocRejCode()) {		
			out.put(FixTags.INDIVIDUALALLOCREJCODE);

			out.put((byte) '=');

			FixUtils.put(out, (long)individualAllocRejCode);
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocText()) {		
			out.put(FixTags.ALLOCTEXT);

			out.put((byte) '=');

			FixUtils.put(out,allocText); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedAllocTextLen()) {		
			out.put(FixTags.ENCODEDALLOCTEXTLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)encodedAllocTextLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedAllocText()) {		
			out.put(FixTags.ENCODEDALLOCTEXT);

			out.put((byte) '=');

			FixUtils.put(out,encodedAllocText); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecondaryIndividualAllocID()) {		
			out.put(FixTags.SECONDARYINDIVIDUALALLOCID);

			out.put((byte) '=');

			FixUtils.put(out,secondaryIndividualAllocID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocCustomerCapacity()) {		
			out.put(FixTags.ALLOCCUSTOMERCAPACITY);

			out.put((byte) '=');

			FixUtils.put(out,allocCustomerCapacity); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasIndividualAllocType()) {		
			out.put(FixTags.INDIVIDUALALLOCTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)individualAllocType);
		
			out.put(FixUtils.SOH);

            }

		if (hasAllocQty()) {		
			out.put(FixTags.ALLOCQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)allocQty);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(nestedParties)>0) {
			out.put(FixTags.NONESTEDPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(nestedParties));

			out.put(FixUtils.SOH);

		}
		for (FixNestedParties fixNestedParties : nestedParties) if (fixNestedParties.hasGroup()) fixNestedParties.encode(out);
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
		
		if (hasAllocPrice()) {		
			FixUtils.put(out, (long)allocPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocPositionEffect()) {		
			FixUtils.put(out,allocPositionEffect); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIndividualAllocID()) {		
			FixUtils.put(out,individualAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIndividualAllocRejCode()) {		
			FixUtils.put(out, (long)individualAllocRejCode);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocText()) {		
			FixUtils.put(out,allocText); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedAllocTextLen()) {		
			FixUtils.put(out, (long)encodedAllocTextLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedAllocText()) {		
			FixUtils.put(out,encodedAllocText); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryIndividualAllocID()) {		
			FixUtils.put(out,secondaryIndividualAllocID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocCustomerCapacity()) {		
			FixUtils.put(out,allocCustomerCapacity); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIndividualAllocType()) {		
			FixUtils.put(out, (long)individualAllocType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAllocQty()) {		
			FixUtils.put(out, (long)allocQty);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.printBuffer(out);
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
			
	public long getAllocPrice() { 		
		if ( hasAllocPrice()) {		
			if (hasAllocPrice == FixUtils.TAG_HAS_VALUE) {		
				return allocPrice; 		
			} else {		
		
				buf.position(hasAllocPrice);		
		
			allocPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocPrice);		
					return 0;		
				}		
			}		
			hasAllocPrice = FixUtils.TAG_HAS_VALUE;		
			return allocPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAllocPrice() { return hasAllocPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocPrice(long src) {		
		allocPrice = src;
		hasAllocPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocPrice(byte[] src) {		
		if (src == null ) return;
		if (hasAllocPrice()) allocPrice = FixUtils.TAG_HAS_NO_VALUE;		
		allocPrice = FixUtils.longValueOf(src, 0, src.length);
		hasAllocPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocPrice(String str) {		
		if (str == null ) return;
		if (hasAllocPrice()) allocPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		allocPrice = FixUtils.longValueOf(src, 0, src.length);
		hasAllocPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getAllocPositionEffect() { 		
		if ( hasAllocPositionEffect()) {		
			if (hasAllocPositionEffect == FixUtils.TAG_HAS_VALUE) {		
				return allocPositionEffect; 		
			} else {		
		
				buf.position(hasAllocPositionEffect);		
		
			allocPositionEffect = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (allocPositionEffect != (byte)'F') && (allocPositionEffect != (byte)'R') && (allocPositionEffect != (byte)'C') && (allocPositionEffect != (byte)'O') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1047);		
				if (err.hasError()) {		
					buf.position(hasAllocPositionEffect);		
					return (byte)'0';		
				}		
			}		
			hasAllocPositionEffect = FixUtils.TAG_HAS_VALUE;		
			return allocPositionEffect;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasAllocPositionEffect() { return hasAllocPositionEffect != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocPositionEffect(byte src) {		
		allocPositionEffect = src;
		hasAllocPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAllocPositionEffect(byte[] src) {		
		if (src == null ) return;
		if (hasAllocPositionEffect()) allocPositionEffect = (byte)' ';		
		allocPositionEffect = src[0];		
		hasAllocPositionEffect = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocPositionEffect(String str) {		
		if (str == null ) return;
		if (hasAllocPositionEffect()) allocPositionEffect = (byte)' ';		
		byte[] src = str.getBytes(); 		
		allocPositionEffect = src[0];		
		hasAllocPositionEffect = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getIndividualAllocRejCode() { 		
		if ( hasIndividualAllocRejCode()) {		
			if (hasIndividualAllocRejCode == FixUtils.TAG_HAS_VALUE) {		
				return individualAllocRejCode; 		
			} else {		
		
				buf.position(hasIndividualAllocRejCode);		
		
			individualAllocRejCode = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasIndividualAllocRejCode);		
					return 0;		
				}		
			}		
			hasIndividualAllocRejCode = FixUtils.TAG_HAS_VALUE;		
			return individualAllocRejCode;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasIndividualAllocRejCode() { return hasIndividualAllocRejCode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setIndividualAllocRejCode(long src) {		
		individualAllocRejCode = src;
		hasIndividualAllocRejCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIndividualAllocRejCode(byte[] src) {		
		if (src == null ) return;
		if (hasIndividualAllocRejCode()) individualAllocRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		individualAllocRejCode = FixUtils.longValueOf(src, 0, src.length);
		hasIndividualAllocRejCode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setIndividualAllocRejCode(String str) {		
		if (str == null ) return;
		if (hasIndividualAllocRejCode()) individualAllocRejCode = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		individualAllocRejCode = FixUtils.longValueOf(src, 0, src.length);
		hasIndividualAllocRejCode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getAllocText() { 		
		if ( hasAllocText()) {		
			if (hasAllocText == FixUtils.TAG_HAS_VALUE) {		
				return allocText; 		
			} else {		
		
				buf.position(hasAllocText);		
		
			FixMessage.getTagStringValue(buf, allocText, 0, allocText.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAllocText);		
					return null;		
				}		
			}		
			hasAllocText = FixUtils.TAG_HAS_VALUE;		
			return allocText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAllocText() { return hasAllocText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAllocText(byte[] src) {		
		if (src == null ) return;
		if (hasAllocText()) FixUtils.fillSpace(allocText);		
		FixUtils.copy(allocText, src); 		
		hasAllocText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAllocText(String str) {		
		if (str == null ) return;
		if (hasAllocText()) FixUtils.fillSpace(allocText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(allocText, src); 		
		hasAllocText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEncodedAllocTextLen() { 		
		if ( hasEncodedAllocTextLen()) {		
			if (hasEncodedAllocTextLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedAllocTextLen; 		
			} else {		
		
				buf.position(hasEncodedAllocTextLen);		
		
			encodedAllocTextLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedAllocTextLen);		
					return 0;		
				}		
			}		
			hasEncodedAllocTextLen = FixUtils.TAG_HAS_VALUE;		
			return encodedAllocTextLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedAllocTextLen() { return hasEncodedAllocTextLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedAllocTextLen(long src) {		
		encodedAllocTextLen = src;
		hasEncodedAllocTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedAllocTextLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedAllocTextLen()) encodedAllocTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedAllocTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedAllocTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedAllocTextLen(String str) {		
		if (str == null ) return;
		if (hasEncodedAllocTextLen()) encodedAllocTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedAllocTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedAllocTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedAllocText() { 		
		if ( hasEncodedAllocText()) {		
			if (hasEncodedAllocText == FixUtils.TAG_HAS_VALUE) {		
				return encodedAllocText; 		
			} else {		
		
				buf.position(hasEncodedAllocText);		
		
			FixMessage.getTagStringValue(buf, encodedAllocText, 0, encodedAllocText.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedAllocText);		
					return null;		
				}		
			}		
			hasEncodedAllocText = FixUtils.TAG_HAS_VALUE;		
			return encodedAllocText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedAllocText() { return hasEncodedAllocText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedAllocText(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedAllocText()) FixUtils.fillSpace(encodedAllocText);		
		FixUtils.copy(encodedAllocText, src); 		
		hasEncodedAllocText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedAllocText(String str) {		
		if (str == null ) return;
		if (hasEncodedAllocText()) FixUtils.fillSpace(encodedAllocText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedAllocText, src); 		
		hasEncodedAllocText = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getIndividualAllocType() { 		
		if ( hasIndividualAllocType()) {		
			if (hasIndividualAllocType == FixUtils.TAG_HAS_VALUE) {		
				return individualAllocType; 		
			} else {		
		
				buf.position(hasIndividualAllocType);		
		
			individualAllocType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasIndividualAllocType);		
					return 0;		
				}		
			}		
			hasIndividualAllocType = FixUtils.TAG_HAS_VALUE;		
			return individualAllocType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasIndividualAllocType() { return hasIndividualAllocType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setIndividualAllocType(long src) {		
		individualAllocType = src;
		hasIndividualAllocType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIndividualAllocType(byte[] src) {		
		if (src == null ) return;
		if (hasIndividualAllocType()) individualAllocType = FixUtils.TAG_HAS_NO_VALUE;		
		individualAllocType = FixUtils.longValueOf(src, 0, src.length);
		hasIndividualAllocType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setIndividualAllocType(String str) {		
		if (str == null ) return;
		if (hasIndividualAllocType()) individualAllocType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		individualAllocType = FixUtils.longValueOf(src, 0, src.length);
		hasIndividualAllocType = FixUtils.TAG_HAS_VALUE;		
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
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasAllocAccount()) s += "AllocAccount(79)= " + new String( FixUtils.trim(getAllocAccount()) ) + "\n" ; 
		if (hasAllocAcctIDSource()) s += "AllocAcctIDSource(661)= " + getAllocAcctIDSource() + "\n" ; 
		if (hasAllocPrice()) s += "AllocPrice(366)= " + getAllocPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasAllocPositionEffect()) s += "AllocPositionEffect(1047)= " + getAllocPositionEffect() + "\n" ; 
		if (hasIndividualAllocID()) s += "IndividualAllocID(467)= " + new String( FixUtils.trim(getIndividualAllocID()) ) + "\n" ; 
		if (hasIndividualAllocRejCode()) s += "IndividualAllocRejCode(776)= " + getIndividualAllocRejCode() + "\n" ; 
		if (hasAllocText()) s += "AllocText(161)= " + new String( FixUtils.trim(getAllocText()) ) + "\n" ; 
		if (hasEncodedAllocTextLen()) s += "EncodedAllocTextLen(360)= " + getEncodedAllocTextLen() + "\n" ; 
		if (hasEncodedAllocText()) s += "EncodedAllocText(361)= " + new String( FixUtils.trim(getEncodedAllocText()) ) + "\n" ; 
		if (hasSecondaryIndividualAllocID()) s += "SecondaryIndividualAllocID(989)= " + new String( FixUtils.trim(getSecondaryIndividualAllocID()) ) + "\n" ; 
		if (hasAllocCustomerCapacity()) s += "AllocCustomerCapacity(993)= " + new String( FixUtils.trim(getAllocCustomerCapacity()) ) + "\n" ; 
		if (hasIndividualAllocType()) s += "IndividualAllocType(992)= " + getIndividualAllocType() + "\n" ; 
		if (hasAllocQty()) s += "AllocQty(80)= " + getAllocQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixAllocAckGrp)) return false;

		FixAllocAckGrp msg = (FixAllocAckGrp) o;

		for (int i = 0; i < nestedParties.length; i++)
			if (!nestedParties[i].equals(msg.nestedParties[i])) return false;
		if ((hasAllocAccount() && !msg.hasAllocAccount()) || (!hasAllocAccount() && msg.hasAllocAccount())) return false;
		if (!(!hasAllocAccount() && !msg.hasAllocAccount()) && !FixUtils.equals(getAllocAccount(), msg.getAllocAccount())) return false;
		if ((hasAllocAcctIDSource() && !msg.hasAllocAcctIDSource()) || (!hasAllocAcctIDSource() && msg.hasAllocAcctIDSource())) return false;
		if (!(!hasAllocAcctIDSource() && !msg.hasAllocAcctIDSource()) && !(getAllocAcctIDSource()==msg.getAllocAcctIDSource())) return false;
		if ((hasAllocPrice() && !msg.hasAllocPrice()) || (!hasAllocPrice() && msg.hasAllocPrice())) return false;
		if (!(!hasAllocPrice() && !msg.hasAllocPrice()) && !(getAllocPrice()==msg.getAllocPrice())) return false;
		if ((hasAllocPositionEffect() && !msg.hasAllocPositionEffect()) || (!hasAllocPositionEffect() && msg.hasAllocPositionEffect())) return false;
		if (!(!hasAllocPositionEffect() && !msg.hasAllocPositionEffect()) && !(getAllocPositionEffect()==msg.getAllocPositionEffect())) return false;
		if ((hasIndividualAllocID() && !msg.hasIndividualAllocID()) || (!hasIndividualAllocID() && msg.hasIndividualAllocID())) return false;
		if (!(!hasIndividualAllocID() && !msg.hasIndividualAllocID()) && !FixUtils.equals(getIndividualAllocID(), msg.getIndividualAllocID())) return false;
		if ((hasIndividualAllocRejCode() && !msg.hasIndividualAllocRejCode()) || (!hasIndividualAllocRejCode() && msg.hasIndividualAllocRejCode())) return false;
		if (!(!hasIndividualAllocRejCode() && !msg.hasIndividualAllocRejCode()) && !(getIndividualAllocRejCode()==msg.getIndividualAllocRejCode())) return false;
		if ((hasAllocText() && !msg.hasAllocText()) || (!hasAllocText() && msg.hasAllocText())) return false;
		if (!(!hasAllocText() && !msg.hasAllocText()) && !FixUtils.equals(getAllocText(), msg.getAllocText())) return false;
		if ((hasEncodedAllocTextLen() && !msg.hasEncodedAllocTextLen()) || (!hasEncodedAllocTextLen() && msg.hasEncodedAllocTextLen())) return false;
		if (!(!hasEncodedAllocTextLen() && !msg.hasEncodedAllocTextLen()) && !(getEncodedAllocTextLen()==msg.getEncodedAllocTextLen())) return false;
		if ((hasEncodedAllocText() && !msg.hasEncodedAllocText()) || (!hasEncodedAllocText() && msg.hasEncodedAllocText())) return false;
		if (!(!hasEncodedAllocText() && !msg.hasEncodedAllocText()) && !FixUtils.equals(getEncodedAllocText(), msg.getEncodedAllocText())) return false;
		if ((hasSecondaryIndividualAllocID() && !msg.hasSecondaryIndividualAllocID()) || (!hasSecondaryIndividualAllocID() && msg.hasSecondaryIndividualAllocID())) return false;
		if (!(!hasSecondaryIndividualAllocID() && !msg.hasSecondaryIndividualAllocID()) && !FixUtils.equals(getSecondaryIndividualAllocID(), msg.getSecondaryIndividualAllocID())) return false;
		if ((hasAllocCustomerCapacity() && !msg.hasAllocCustomerCapacity()) || (!hasAllocCustomerCapacity() && msg.hasAllocCustomerCapacity())) return false;
		if (!(!hasAllocCustomerCapacity() && !msg.hasAllocCustomerCapacity()) && !FixUtils.equals(getAllocCustomerCapacity(), msg.getAllocCustomerCapacity())) return false;
		if ((hasIndividualAllocType() && !msg.hasIndividualAllocType()) || (!hasIndividualAllocType() && msg.hasIndividualAllocType())) return false;
		if (!(!hasIndividualAllocType() && !msg.hasIndividualAllocType()) && !(getIndividualAllocType()==msg.getIndividualAllocType())) return false;
		if ((hasAllocQty() && !msg.hasAllocQty()) || (!hasAllocQty() && msg.hasAllocQty())) return false;
		if (!(!hasAllocQty() && !msg.hasAllocQty()) && !(getAllocQty()==msg.getAllocQty())) return false;
		return true;
	}
	public FixAllocAckGrp clone ( FixAllocAckGrp out ) {
		if ( hasAllocAccount())
			out.setAllocAccount(getAllocAccount());
		if ( hasAllocAcctIDSource())
			out.setAllocAcctIDSource(getAllocAcctIDSource());
		if ( hasAllocPrice())
			out.setAllocPrice(getAllocPrice());
		if ( hasAllocPositionEffect())
			out.setAllocPositionEffect(getAllocPositionEffect());
		if ( hasIndividualAllocID())
			out.setIndividualAllocID(getIndividualAllocID());
		if ( hasIndividualAllocRejCode())
			out.setIndividualAllocRejCode(getIndividualAllocRejCode());
		if ( hasAllocText())
			out.setAllocText(getAllocText());
		if ( hasEncodedAllocTextLen())
			out.setEncodedAllocTextLen(getEncodedAllocTextLen());
		if ( hasEncodedAllocText())
			out.setEncodedAllocText(getEncodedAllocText());
		if ( hasSecondaryIndividualAllocID())
			out.setSecondaryIndividualAllocID(getSecondaryIndividualAllocID());
		if ( hasAllocCustomerCapacity())
			out.setAllocCustomerCapacity(getAllocCustomerCapacity());
		if ( hasIndividualAllocType())
			out.setIndividualAllocType(getIndividualAllocType());
		if ( hasAllocQty())
			out.setAllocQty(getAllocQty());
		int count = 0;
		count = 0;
		for (FixNestedParties fixNestedParties : nestedParties) {
			if (!fixNestedParties.hasGroup()) continue;
			out.nestedParties[count] = fixNestedParties.clone( out.nestedParties[count] );
			count++;
		}
		return out;
	}

}
