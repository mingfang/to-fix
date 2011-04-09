package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSecSizesGrp extends FixGroup {
	private short hasMDSecSizeType;
	long mDSecSizeType = 0;		
	private short hasMDSecSize;
	long mDSecSize = 0;		
	
	public FixSecSizesGrp() {
		this(false);
	}

	public FixSecSizesGrp(boolean isRequired) {
		super(FixTags.MDSECSIZETYPE_INT);

		this.isRequired = isRequired;
		
		hasMDSecSizeType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDSecSize = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasMDSecSizeType()) return true;
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
            	case FixTags.MDSECSIZETYPE_INT:		
            		hasMDSecSizeType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MDSECSIZE_INT:		
            		hasMDSecSize = (short) buf.position();		
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
		hasMDSecSizeType = FixUtils.TAG_HAS_NO_VALUE;
		hasMDSecSize = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasMDSecSizeType()) {		
			out.put(FixTags.MDSECSIZETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDSecSizeType);
		
			out.put(FixUtils.SOH);

            }

		if (hasMDSecSize()) {		
			out.put(FixTags.MDSECSIZE);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDSecSize);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasMDSecSizeType()) {		
			FixUtils.put(out, (long)mDSecSizeType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDSecSize()) {		
			FixUtils.put(out, (long)mDSecSize);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getMDSecSizeType() { 		
		if ( hasMDSecSizeType()) {		
			if (hasMDSecSizeType == FixUtils.TAG_HAS_VALUE) {		
				return mDSecSizeType; 		
			} else {		
		
				buf.position(hasMDSecSizeType);		
		
			mDSecSizeType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDSecSizeType);		
					return 0;		
				}		
			}		
			hasMDSecSizeType = FixUtils.TAG_HAS_VALUE;		
			return mDSecSizeType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDSecSizeType() { return hasMDSecSizeType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDSecSizeType(long src) {		
		mDSecSizeType = src;
		hasMDSecSizeType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDSecSizeType(byte[] src) {		
		if (src == null ) return;
		if (hasMDSecSizeType()) mDSecSizeType = FixUtils.TAG_HAS_NO_VALUE;		
		mDSecSizeType = FixUtils.longValueOf(src, 0, src.length);
		hasMDSecSizeType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDSecSizeType(String str) {		
		if (str == null ) return;
		if (hasMDSecSizeType()) mDSecSizeType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDSecSizeType = FixUtils.longValueOf(src, 0, src.length);
		hasMDSecSizeType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMDSecSize() { 		
		if ( hasMDSecSize()) {		
			if (hasMDSecSize == FixUtils.TAG_HAS_VALUE) {		
				return mDSecSize; 		
			} else {		
		
				buf.position(hasMDSecSize);		
		
			mDSecSize = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDSecSize);		
					return 0;		
				}		
			}		
			hasMDSecSize = FixUtils.TAG_HAS_VALUE;		
			return mDSecSize;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDSecSize() { return hasMDSecSize != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDSecSize(long src) {		
		mDSecSize = src;
		hasMDSecSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDSecSize(byte[] src) {		
		if (src == null ) return;
		if (hasMDSecSize()) mDSecSize = FixUtils.TAG_HAS_NO_VALUE;		
		mDSecSize = FixUtils.longValueOf(src, 0, src.length);
		hasMDSecSize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDSecSize(String str) {		
		if (str == null ) return;
		if (hasMDSecSize()) mDSecSize = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDSecSize = FixUtils.longValueOf(src, 0, src.length);
		hasMDSecSize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasMDSecSizeType()) s += "MDSecSizeType(1178)= " + getMDSecSizeType() + "\n" ; 
		if (hasMDSecSize()) s += "MDSecSize(1179)= " + getMDSecSize() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSecSizesGrp)) return false;

		FixSecSizesGrp msg = (FixSecSizesGrp) o;

		if ((hasMDSecSizeType() && !msg.hasMDSecSizeType()) || (!hasMDSecSizeType() && msg.hasMDSecSizeType())) return false;
		if (!(!hasMDSecSizeType() && !msg.hasMDSecSizeType()) && !(getMDSecSizeType()==msg.getMDSecSizeType())) return false;
		if ((hasMDSecSize() && !msg.hasMDSecSize()) || (!hasMDSecSize() && msg.hasMDSecSize())) return false;
		if (!(!hasMDSecSize() && !msg.hasMDSecSize()) && !(getMDSecSize()==msg.getMDSecSize())) return false;
		return true;
	}
	public FixSecSizesGrp clone ( FixSecSizesGrp out ) {
		if ( hasMDSecSizeType())
			out.setMDSecSizeType(getMDSecSizeType());
		if ( hasMDSecSize())
			out.setMDSecSize(getMDSecSize());
		return out;
	}

}
