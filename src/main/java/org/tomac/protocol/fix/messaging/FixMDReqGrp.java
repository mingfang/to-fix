package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixMDReqGrp extends FixGroup {
	private short hasMDEntryType;
	byte mDEntryType = (byte)' ';		
	
	public FixMDReqGrp() {
		this(false);
	}

	public FixMDReqGrp(boolean isRequired) {
		super(FixTags.MDENTRYTYPE_INT);

		this.isRequired = isRequired;
		
		hasMDEntryType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasMDEntryType()) return true;
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
            	case FixTags.MDENTRYTYPE_INT:		
            		hasMDEntryType = (short) buf.position();		
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
		if (!hasMDEntryType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.MDENTRYTYPE_INT);
			return false;
		}
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasMDEntryType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasMDEntryType()) {		
			out.put(FixTags.MDENTRYTYPE);

			out.put((byte) '=');

			FixUtils.put(out,mDEntryType); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasMDEntryType()) {		
			FixUtils.put(out,mDEntryType); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte getMDEntryType() { 		
		if ( hasMDEntryType()) {		
			if (hasMDEntryType == FixUtils.TAG_HAS_VALUE) {		
				return mDEntryType; 		
			} else {		
		
				buf.position(hasMDEntryType);		
		
			mDEntryType = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (mDEntryType != (byte)'D') && (mDEntryType != (byte)'E') && (mDEntryType != (byte)'F') && (mDEntryType != (byte)'G') && (mDEntryType != (byte)'A') && (mDEntryType != (byte)'B') && (mDEntryType != (byte)'C') && (mDEntryType != (byte)'L') && (mDEntryType != (byte)'M') && (mDEntryType != (byte)'N') && (mDEntryType != (byte)'O') && (mDEntryType != (byte)'H') && (mDEntryType != (byte)'J') && (mDEntryType != (byte)'K') && (mDEntryType != (byte)'U') && (mDEntryType != (byte)'T') && (mDEntryType != (byte)'W') && (mDEntryType != (byte)'V') && (mDEntryType != (byte)'Q') && (mDEntryType != (byte)'P') && (mDEntryType != (byte)'S') && (mDEntryType != (byte)'R') && (mDEntryType != (byte)'Y') && (mDEntryType != (byte)'X') && (mDEntryType != (byte)'Z') && (mDEntryType != (byte)'a') && (mDEntryType != (byte)'3') && (mDEntryType != (byte)'2') && (mDEntryType != (byte)'1') && (mDEntryType != (byte)'0') && (mDEntryType != (byte)'7') && (mDEntryType != (byte)'6') && (mDEntryType != (byte)'5') && (mDEntryType != (byte)'4') && (mDEntryType != (byte)'9') && (mDEntryType != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 269);		
				if (err.hasError()) {		
					buf.position(hasMDEntryType);		
					return (byte)'0';		
				}		
			}		
			hasMDEntryType = FixUtils.TAG_HAS_VALUE;		
			return mDEntryType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMDEntryType() { return hasMDEntryType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntryType(byte src) {		
		mDEntryType = src;
		hasMDEntryType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDEntryType(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntryType()) mDEntryType = (byte)' ';		
		mDEntryType = src[0];		
		hasMDEntryType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntryType(String str) {		
		if (str == null ) return;
		if (hasMDEntryType()) mDEntryType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		mDEntryType = src[0];		
		hasMDEntryType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasMDEntryType()) s += "MDEntryType(269)= " + getMDEntryType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixMDReqGrp)) return false;

		FixMDReqGrp msg = (FixMDReqGrp) o;

		if ((hasMDEntryType() && !msg.hasMDEntryType()) || (!hasMDEntryType() && msg.hasMDEntryType())) return false;
		if (!(!hasMDEntryType() && !msg.hasMDEntryType()) && !(getMDEntryType()==msg.getMDEntryType())) return false;
		return true;
	}
	public FixMDReqGrp clone ( FixMDReqGrp out ) {
		if ( hasMDEntryType())
			out.setMDEntryType(getMDEntryType());
		return out;
	}

}
