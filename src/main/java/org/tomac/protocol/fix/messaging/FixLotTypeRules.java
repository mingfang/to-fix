package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixLotTypeRules extends FixGroup {
	private short hasLotType;
	byte lotType = (byte)' ';		
	private short hasMinLotSize;
	long minLotSize = 0;		
	
	public FixLotTypeRules() {
		this(false);
	}

	public FixLotTypeRules(boolean isRequired) {
		super(FixTags.LOTTYPE_INT);

		this.isRequired = isRequired;
		
		hasLotType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMinLotSize = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasLotType()) return true;
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
            	case FixTags.LOTTYPE_INT:		
            		hasLotType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MINLOTSIZE_INT:		
            		hasMinLotSize = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

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
		hasLotType = FixUtils.TAG_HAS_NO_VALUE;
		hasMinLotSize = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasLotType()) {		
			out.put(FixTags.LOTTYPE);

			out.put((byte) '=');

			FixUtils.put(out,lotType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMinLotSize()) {		
			out.put(FixTags.MINLOTSIZE);

			out.put((byte) '=');

			FixUtils.put(out, (long)minLotSize);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasLotType()) {		
			FixUtils.put(out,lotType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMinLotSize()) {		
			FixUtils.put(out, (long)minLotSize);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte getLotType() { 		
		if ( hasLotType()) {		
			if (hasLotType == FixUtils.TAG_HAS_VALUE) {		
				return lotType; 		
			} else {		
		
				buf.position(hasLotType);		
		
			lotType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (lotType != (byte)'3') && (lotType != (byte)'2') && (lotType != (byte)'1') && (lotType != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1093);		
				if (err.hasError()) {		
					buf.position(hasLotType);		
					return (byte)'0';		
				}		
			}		
			hasLotType = FixUtils.TAG_HAS_VALUE;		
			return lotType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasLotType() { return hasLotType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLotType(byte src) {		
		lotType = src;
		hasLotType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLotType(byte[] src) {		
		if (src == null ) return;
		if (hasLotType()) lotType = (byte)' ';		
		lotType = src[0];		
		hasLotType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLotType(String str) {		
		if (str == null ) return;
		if (hasLotType()) lotType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		lotType = src[0];		
		hasLotType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMinLotSize() { 		
		if ( hasMinLotSize()) {		
			if (hasMinLotSize == FixUtils.TAG_HAS_VALUE) {		
				return minLotSize; 		
			} else {		
		
				buf.position(hasMinLotSize);		
		
			minLotSize = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMinLotSize);		
					return 0;		
				}		
			}		
			hasMinLotSize = FixUtils.TAG_HAS_VALUE;		
			return minLotSize;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMinLotSize() { return hasMinLotSize != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMinLotSize(long src) {		
		minLotSize = src;
		hasMinLotSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinLotSize(byte[] src) {		
		if (src == null ) return;
		if (hasMinLotSize()) minLotSize = FixUtils.TAG_HAS_NO_VALUE;		
		minLotSize = FixUtils.longValueOf(src, 0, src.length);
		hasMinLotSize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMinLotSize(String str) {		
		if (str == null ) return;
		if (hasMinLotSize()) minLotSize = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		minLotSize = FixUtils.longValueOf(src, 0, src.length);
		hasMinLotSize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasLotType()) s += "LotType(1093)= " + getLotType() + "\n" ; 
		if (hasMinLotSize()) s += "MinLotSize(1231)= " + getMinLotSize() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixLotTypeRules)) return false;

		FixLotTypeRules msg = (FixLotTypeRules) o;

		if ((hasLotType() && !msg.hasLotType()) || (!hasLotType() && msg.hasLotType())) return false;
		if (!(!hasLotType() && !msg.hasLotType()) && !(getLotType()==msg.getLotType())) return false;
		if ((hasMinLotSize() && !msg.hasMinLotSize()) || (!hasMinLotSize() && msg.hasMinLotSize())) return false;
		if (!(!hasMinLotSize() && !msg.hasMinLotSize()) && !(getMinLotSize()==msg.getMinLotSize())) return false;
		return true;
	}
	public FixLotTypeRules clone ( FixLotTypeRules out ) {
		if ( hasLotType())
			out.setLotType(getLotType());
		if ( hasMinLotSize())
			out.setMinLotSize(getMinLotSize());
		return out;
	}

}
