package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixPositionQty extends FixGroup {
	private short hasPosType;
	byte[] posType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLongQty;
	long longQty = 0;		
	private short hasShortQty;
	long shortQty = 0;		
	private short hasPosQtyStatus;
	long posQtyStatus = 0;		
	private short hasQuantityDate;
	byte[] quantityDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixNestedParties[] nestedParties;
	
	public FixPositionQty() {
		this(false);
	}

	public FixPositionQty(boolean isRequired) {
		super(FixTags.POSTYPE_INT);

		this.isRequired = isRequired;
		
		hasPosType = FixUtils.TAG_HAS_NO_VALUE;		
		posType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLongQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasShortQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasPosQtyStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasQuantityDate = FixUtils.TAG_HAS_NO_VALUE;		
		quantityDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		nestedParties = new FixNestedParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedParties[i] = new FixNestedParties();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasPosType()) return true;
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
            	case FixTags.POSTYPE_INT:		
            		hasPosType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LONGQTY_INT:		
            		hasLongQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SHORTQTY_INT:		
            		hasShortQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.POSQTYSTATUS_INT:		
            		hasPosQtyStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.QUANTITYDATE_INT:		
            		hasQuantityDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTEDPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !nestedParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NONESTEDPARTYIDS_INT);
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
		hasPosType = FixUtils.TAG_HAS_NO_VALUE;
		hasLongQty = FixUtils.TAG_HAS_NO_VALUE;
		hasShortQty = FixUtils.TAG_HAS_NO_VALUE;
		hasPosQtyStatus = FixUtils.TAG_HAS_NO_VALUE;
		hasQuantityDate = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasPosType()) {		
			out.put(FixTags.POSTYPE);

			out.put((byte) '=');

			FixUtils.put(out,posType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLongQty()) {		
			out.put(FixTags.LONGQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)longQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasShortQty()) {		
			out.put(FixTags.SHORTQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)shortQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasPosQtyStatus()) {		
			out.put(FixTags.POSQTYSTATUS);

			out.put((byte) '=');

			FixUtils.put(out, (long)posQtyStatus);
		
			out.put(FixUtils.SOH);

            }

		if (hasQuantityDate()) {		
			out.put(FixTags.QUANTITYDATE);

			out.put((byte) '=');

			FixUtils.put(out,quantityDate); 		
		
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
		
		if (hasPosType()) {		
			FixUtils.put(out,posType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLongQty()) {		
			FixUtils.put(out, (long)longQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasShortQty()) {		
			FixUtils.put(out, (long)shortQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPosQtyStatus()) {		
			FixUtils.put(out, (long)posQtyStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuantityDate()) {		
			FixUtils.put(out,quantityDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.printBuffer(out);
	}

	public byte[] getPosType() { 		
		if ( hasPosType()) {		
			if (hasPosType == FixUtils.TAG_HAS_VALUE) {		
				return posType; 		
			} else {		
		
				buf.position(hasPosType);		
		
			FixUtils.getTagStringValue(buf, posType, 0, posType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPosType);		
					return null;		
				}		
			}		
			hasPosType = FixUtils.TAG_HAS_VALUE;		
			return posType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPosType() { return hasPosType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPosType(byte[] src) {		
		if (src == null ) return;
		if (hasPosType()) FixUtils.fillNul(posType);		
		FixUtils.copy(posType, src); 		
		hasPosType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPosType(String str) {		
		if (str == null ) return;
		if (hasPosType()) FixUtils.fillNul(posType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(posType, src); 		
		hasPosType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLongQty() { 		
		if ( hasLongQty()) {		
			if (hasLongQty == FixUtils.TAG_HAS_VALUE) {		
				return longQty; 		
			} else {		
		
				buf.position(hasLongQty);		
		
			longQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLongQty);		
					return 0;		
				}		
			}		
			hasLongQty = FixUtils.TAG_HAS_VALUE;		
			return longQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLongQty() { return hasLongQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLongQty(long src) {		
		longQty = src;
		hasLongQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLongQty(byte[] src) {		
		if (src == null ) return;
		if (hasLongQty()) longQty = FixUtils.TAG_HAS_NO_VALUE;		
		longQty = FixUtils.longValueOf(src, 0, src.length);
		hasLongQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLongQty(String str) {		
		if (str == null ) return;
		if (hasLongQty()) longQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		longQty = FixUtils.longValueOf(src, 0, src.length);
		hasLongQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getShortQty() { 		
		if ( hasShortQty()) {		
			if (hasShortQty == FixUtils.TAG_HAS_VALUE) {		
				return shortQty; 		
			} else {		
		
				buf.position(hasShortQty);		
		
			shortQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasShortQty);		
					return 0;		
				}		
			}		
			hasShortQty = FixUtils.TAG_HAS_VALUE;		
			return shortQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasShortQty() { return hasShortQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setShortQty(long src) {		
		shortQty = src;
		hasShortQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setShortQty(byte[] src) {		
		if (src == null ) return;
		if (hasShortQty()) shortQty = FixUtils.TAG_HAS_NO_VALUE;		
		shortQty = FixUtils.longValueOf(src, 0, src.length);
		hasShortQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setShortQty(String str) {		
		if (str == null ) return;
		if (hasShortQty()) shortQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		shortQty = FixUtils.longValueOf(src, 0, src.length);
		hasShortQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPosQtyStatus() { 		
		if ( hasPosQtyStatus()) {		
			if (hasPosQtyStatus == FixUtils.TAG_HAS_VALUE) {		
				return posQtyStatus; 		
			} else {		
		
				buf.position(hasPosQtyStatus);		
		
			posQtyStatus = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPosQtyStatus);		
					return 0;		
				}		
			}		
			hasPosQtyStatus = FixUtils.TAG_HAS_VALUE;		
			return posQtyStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPosQtyStatus() { return hasPosQtyStatus != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPosQtyStatus(long src) {		
		posQtyStatus = src;
		hasPosQtyStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPosQtyStatus(byte[] src) {		
		if (src == null ) return;
		if (hasPosQtyStatus()) posQtyStatus = FixUtils.TAG_HAS_NO_VALUE;		
		posQtyStatus = FixUtils.longValueOf(src, 0, src.length);
		hasPosQtyStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPosQtyStatus(String str) {		
		if (str == null ) return;
		if (hasPosQtyStatus()) posQtyStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		posQtyStatus = FixUtils.longValueOf(src, 0, src.length);
		hasPosQtyStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getQuantityDate() { 		
		if ( hasQuantityDate()) {		
			if (hasQuantityDate == FixUtils.TAG_HAS_VALUE) {		
				return quantityDate; 		
			} else {		
		
				buf.position(hasQuantityDate);		
		
			FixUtils.getTagStringValue(buf, quantityDate, 0, quantityDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasQuantityDate);		
					return null;		
				}		
			}		
			hasQuantityDate = FixUtils.TAG_HAS_VALUE;		
			return quantityDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuantityDate() { return hasQuantityDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setQuantityDate(byte[] src) {		
		if (src == null ) return;
		if (hasQuantityDate()) FixUtils.fillNul(quantityDate);		
		FixUtils.copy(quantityDate, src); 		
		hasQuantityDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setQuantityDate(String str) {		
		if (str == null ) return;
		if (hasQuantityDate()) FixUtils.fillNul(quantityDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quantityDate, src); 		
		hasQuantityDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasPosType()) s += "PosType(703)= " + new String( FixUtils.trim(getPosType()) ) + "\n" ; 
		if (hasLongQty()) s += "LongQty(704)= " + getLongQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasShortQty()) s += "ShortQty(705)= " + getShortQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPosQtyStatus()) s += "PosQtyStatus(706)= " + getPosQtyStatus() + "\n" ; 
		if (hasQuantityDate()) s += "QuantityDate(976)= " + new String( FixUtils.trim(getQuantityDate()) ) + "\n" ; 

		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPositionQty)) return false;

		FixPositionQty msg = (FixPositionQty) o;

		for (int i = 0; i < nestedParties.length; i++)
			if (!nestedParties[i].equals(msg.nestedParties[i])) return false;
		if ((hasPosType() && !msg.hasPosType()) || (!hasPosType() && msg.hasPosType())) return false;
		if (!(!hasPosType() && !msg.hasPosType()) && !FixUtils.equals(getPosType(), msg.getPosType())) return false;
		if ((hasLongQty() && !msg.hasLongQty()) || (!hasLongQty() && msg.hasLongQty())) return false;
		if (!(!hasLongQty() && !msg.hasLongQty()) && !(getLongQty()==msg.getLongQty())) return false;
		if ((hasShortQty() && !msg.hasShortQty()) || (!hasShortQty() && msg.hasShortQty())) return false;
		if (!(!hasShortQty() && !msg.hasShortQty()) && !(getShortQty()==msg.getShortQty())) return false;
		if ((hasPosQtyStatus() && !msg.hasPosQtyStatus()) || (!hasPosQtyStatus() && msg.hasPosQtyStatus())) return false;
		if (!(!hasPosQtyStatus() && !msg.hasPosQtyStatus()) && !(getPosQtyStatus()==msg.getPosQtyStatus())) return false;
		if ((hasQuantityDate() && !msg.hasQuantityDate()) || (!hasQuantityDate() && msg.hasQuantityDate())) return false;
		return true;
	}
	public FixPositionQty clone ( FixPositionQty out ) {
		if ( hasPosType())
			out.setPosType(getPosType());
		if ( hasLongQty())
			out.setLongQty(getLongQty());
		if ( hasShortQty())
			out.setShortQty(getShortQty());
		if ( hasPosQtyStatus())
			out.setPosQtyStatus(getPosQtyStatus());
		if ( hasQuantityDate())
			out.setQuantityDate(getQuantityDate());
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
