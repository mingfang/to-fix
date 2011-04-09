package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixMarketDataFeedTypes extends FixGroup {
	private short hasMDFeedType;
	byte[] mDFeedType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketDepth;
	long marketDepth = 0;		
	private short hasMDBookType;
	long mDBookType = 0;		
	
	public FixMarketDataFeedTypes() {
		this(false);
	}

	public FixMarketDataFeedTypes(boolean isRequired) {
		super(FixTags.MDFEEDTYPE_INT);

		this.isRequired = isRequired;
		
		hasMDFeedType = FixUtils.TAG_HAS_NO_VALUE;		
		mDFeedType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketDepth = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDBookType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasMDFeedType()) return true;
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
            	case FixTags.MDFEEDTYPE_INT:		
            		hasMDFeedType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MARKETDEPTH_INT:		
            		hasMarketDepth = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MDBOOKTYPE_INT:		
            		hasMDBookType = (short) buf.position();		
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
		hasMDFeedType = FixUtils.TAG_HAS_NO_VALUE;
		hasMarketDepth = FixUtils.TAG_HAS_NO_VALUE;
		hasMDBookType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasMDFeedType()) {		
			out.put(FixTags.MDFEEDTYPE);

			out.put((byte) '=');

			FixUtils.put(out,mDFeedType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMarketDepth()) {		
			out.put(FixTags.MARKETDEPTH);

			out.put((byte) '=');

			FixUtils.put(out, (long)marketDepth);
		
			out.put(FixUtils.SOH);

            }

		if (hasMDBookType()) {		
			out.put(FixTags.MDBOOKTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDBookType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasMDFeedType()) {		
			FixUtils.put(out,mDFeedType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketDepth()) {		
			FixUtils.put(out, (long)marketDepth);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDBookType()) {		
			FixUtils.put(out, (long)mDBookType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getMDFeedType() { 		
		if ( hasMDFeedType()) {		
			if (hasMDFeedType == FixUtils.TAG_HAS_VALUE) {		
				return mDFeedType; 		
			} else {		
		
				buf.position(hasMDFeedType);		
		
			FixUtils.getTagStringValue(buf, mDFeedType, 0, mDFeedType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDFeedType);		
					return null;		
				}		
			}		
			hasMDFeedType = FixUtils.TAG_HAS_VALUE;		
			return mDFeedType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDFeedType() { return hasMDFeedType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDFeedType(byte[] src) {		
		if (src == null ) return;
		if (hasMDFeedType()) FixUtils.fillNul(mDFeedType);		
		FixUtils.copy(mDFeedType, src); 		
		hasMDFeedType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDFeedType(String str) {		
		if (str == null ) return;
		if (hasMDFeedType()) FixUtils.fillNul(mDFeedType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDFeedType, src); 		
		hasMDFeedType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMarketDepth() { 		
		if ( hasMarketDepth()) {		
			if (hasMarketDepth == FixUtils.TAG_HAS_VALUE) {		
				return marketDepth; 		
			} else {		
		
				buf.position(hasMarketDepth);		
		
			marketDepth = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMarketDepth);		
					return 0;		
				}		
			}		
			hasMarketDepth = FixUtils.TAG_HAS_VALUE;		
			return marketDepth;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMarketDepth() { return hasMarketDepth != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMarketDepth(long src) {		
		marketDepth = src;
		hasMarketDepth = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarketDepth(byte[] src) {		
		if (src == null ) return;
		if (hasMarketDepth()) marketDepth = FixUtils.TAG_HAS_NO_VALUE;		
		marketDepth = FixUtils.longValueOf(src, 0, src.length);
		hasMarketDepth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMarketDepth(String str) {		
		if (str == null ) return;
		if (hasMarketDepth()) marketDepth = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		marketDepth = FixUtils.longValueOf(src, 0, src.length);
		hasMarketDepth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMDBookType() { 		
		if ( hasMDBookType()) {		
			if (hasMDBookType == FixUtils.TAG_HAS_VALUE) {		
				return mDBookType; 		
			} else {		
		
				buf.position(hasMDBookType);		
		
			mDBookType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDBookType);		
					return 0;		
				}		
			}		
			hasMDBookType = FixUtils.TAG_HAS_VALUE;		
			return mDBookType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDBookType() { return hasMDBookType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDBookType(long src) {		
		mDBookType = src;
		hasMDBookType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDBookType(byte[] src) {		
		if (src == null ) return;
		if (hasMDBookType()) mDBookType = FixUtils.TAG_HAS_NO_VALUE;		
		mDBookType = FixUtils.longValueOf(src, 0, src.length);
		hasMDBookType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDBookType(String str) {		
		if (str == null ) return;
		if (hasMDBookType()) mDBookType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDBookType = FixUtils.longValueOf(src, 0, src.length);
		hasMDBookType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasMDFeedType()) s += "MDFeedType(1022)= " + new String( FixUtils.trim(getMDFeedType()) ) + "\n" ; 
		if (hasMarketDepth()) s += "MarketDepth(264)= " + getMarketDepth() + "\n" ; 
		if (hasMDBookType()) s += "MDBookType(1021)= " + getMDBookType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixMarketDataFeedTypes)) return false;

		FixMarketDataFeedTypes msg = (FixMarketDataFeedTypes) o;

		if ((hasMDFeedType() && !msg.hasMDFeedType()) || (!hasMDFeedType() && msg.hasMDFeedType())) return false;
		if (!(!hasMDFeedType() && !msg.hasMDFeedType()) && !FixUtils.equals(getMDFeedType(), msg.getMDFeedType())) return false;
		if ((hasMarketDepth() && !msg.hasMarketDepth()) || (!hasMarketDepth() && msg.hasMarketDepth())) return false;
		if (!(!hasMarketDepth() && !msg.hasMarketDepth()) && !(getMarketDepth()==msg.getMarketDepth())) return false;
		if ((hasMDBookType() && !msg.hasMDBookType()) || (!hasMDBookType() && msg.hasMDBookType())) return false;
		if (!(!hasMDBookType() && !msg.hasMDBookType()) && !(getMDBookType()==msg.getMDBookType())) return false;
		return true;
	}
	public FixMarketDataFeedTypes clone ( FixMarketDataFeedTypes out ) {
		if ( hasMDFeedType())
			out.setMDFeedType(getMDFeedType());
		if ( hasMarketDepth())
			out.setMarketDepth(getMarketDepth());
		if ( hasMDBookType())
			out.setMDBookType(getMDBookType());
		return out;
	}

}
