package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixExpirationQty extends FixGroup {
	private short hasExpirationQtyType;
	long expirationQtyType = 0;		
	private short hasExpQty;
	long expQty = 0;		
	
	public FixExpirationQty() {
		this(false);
	}

	public FixExpirationQty(boolean isRequired) {
		super(FixTags.EXPIRATIONQTYTYPE_INT);

		this.isRequired = isRequired;
		
		hasExpirationQtyType = FixUtils.TAG_HAS_NO_VALUE;		
		hasExpQty = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasExpirationQtyType()) return true;
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
            	case FixTags.EXPIRATIONQTYTYPE_INT:		
            		hasExpirationQtyType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.EXPQTY_INT:		
            		hasExpQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

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
		hasExpirationQtyType = FixUtils.TAG_HAS_NO_VALUE;
		hasExpQty = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasExpirationQtyType()) {		
			out.put(FixTags.EXPIRATIONQTYTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)expirationQtyType);
		
			out.put(FixUtils.SOH);

            }

		if (hasExpQty()) {		
			out.put(FixTags.EXPQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)expQty);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasExpirationQtyType()) {		
			FixUtils.put(out, (long)expirationQtyType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExpQty()) {		
			FixUtils.put(out, (long)expQty);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getExpirationQtyType() { 		
		if ( hasExpirationQtyType()) {		
			if (hasExpirationQtyType == FixUtils.TAG_HAS_VALUE) {		
				return expirationQtyType; 		
			} else {		
		
				buf.position(hasExpirationQtyType);		
		
			expirationQtyType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasExpirationQtyType);		
					return 0;		
				}		
			}		
			hasExpirationQtyType = FixUtils.TAG_HAS_VALUE;		
			return expirationQtyType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasExpirationQtyType() { return hasExpirationQtyType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setExpirationQtyType(long src) {		
		expirationQtyType = src;
		hasExpirationQtyType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExpirationQtyType(byte[] src) {		
		if (src == null ) return;
		if (hasExpirationQtyType()) expirationQtyType = FixUtils.TAG_HAS_NO_VALUE;		
		expirationQtyType = FixUtils.longValueOf(src, 0, src.length);
		hasExpirationQtyType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setExpirationQtyType(String str) {		
		if (str == null ) return;
		if (hasExpirationQtyType()) expirationQtyType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		expirationQtyType = FixUtils.longValueOf(src, 0, src.length);
		hasExpirationQtyType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getExpQty() { 		
		if ( hasExpQty()) {		
			if (hasExpQty == FixUtils.TAG_HAS_VALUE) {		
				return expQty; 		
			} else {		
		
				buf.position(hasExpQty);		
		
			expQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasExpQty);		
					return 0;		
				}		
			}		
			hasExpQty = FixUtils.TAG_HAS_VALUE;		
			return expQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasExpQty() { return hasExpQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setExpQty(long src) {		
		expQty = src;
		hasExpQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExpQty(byte[] src) {		
		if (src == null ) return;
		if (hasExpQty()) expQty = FixUtils.TAG_HAS_NO_VALUE;		
		expQty = FixUtils.longValueOf(src, 0, src.length);
		hasExpQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setExpQty(String str) {		
		if (str == null ) return;
		if (hasExpQty()) expQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		expQty = FixUtils.longValueOf(src, 0, src.length);
		hasExpQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasExpirationQtyType()) s += "ExpirationQtyType(982)= " + getExpirationQtyType() + "\n" ; 
		if (hasExpQty()) s += "ExpQty(983)= " + getExpQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixExpirationQty)) return false;

		FixExpirationQty msg = (FixExpirationQty) o;

		if ((hasExpirationQtyType() && !msg.hasExpirationQtyType()) || (!hasExpirationQtyType() && msg.hasExpirationQtyType())) return false;
		if (!(!hasExpirationQtyType() && !msg.hasExpirationQtyType()) && !(getExpirationQtyType()==msg.getExpirationQtyType())) return false;
		if ((hasExpQty() && !msg.hasExpQty()) || (!hasExpQty() && msg.hasExpQty())) return false;
		if (!(!hasExpQty() && !msg.hasExpQty()) && !(getExpQty()==msg.getExpQty())) return false;
		return true;
	}
	public FixExpirationQty clone ( FixExpirationQty out ) {
		if ( hasExpirationQtyType())
			out.setExpirationQtyType(getExpirationQtyType());
		if ( hasExpQty())
			out.setExpQty(getExpQty());
		return out;
	}

}
