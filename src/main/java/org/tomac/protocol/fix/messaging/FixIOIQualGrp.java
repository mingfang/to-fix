package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixIOIQualGrp extends FixGroup {
	private short hasIOIQualifier;
	byte iOIQualifier = (byte)' ';		
	
	public FixIOIQualGrp() {
		super(FixTags.IOIQUALIFIER_INT);

		
		hasIOIQualifier = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasIOIQualifier()) return true;
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
            	case FixTags.IOIQUALIFIER_INT:		
            		hasIOIQualifier = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasIOIQualifier = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasIOIQualifier()) {		
			out.put(FixTags.IOIQUALIFIER);

			out.put((byte) '=');

			FixUtils.put(out,iOIQualifier); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasIOIQualifier()) {		
			FixUtils.put(out,iOIQualifier); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte getIOIQualifier() { 		
		if ( hasIOIQualifier()) {		
			if (hasIOIQualifier == FixUtils.TAG_HAS_VALUE) {		
				return iOIQualifier; 		
			} else {		
		
				buf.position(hasIOIQualifier);		
		
			iOIQualifier = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (iOIQualifier != (byte)'D') && (iOIQualifier != (byte)'A') && (iOIQualifier != (byte)'B') && (iOIQualifier != (byte)'C') && (iOIQualifier != (byte)'L') && (iOIQualifier != (byte)'M') && (iOIQualifier != (byte)'O') && (iOIQualifier != (byte)'I') && (iOIQualifier != (byte)'T') && (iOIQualifier != (byte)'W') && (iOIQualifier != (byte)'V') && (iOIQualifier != (byte)'Q') && (iOIQualifier != (byte)'P') && (iOIQualifier != (byte)'S') && (iOIQualifier != (byte)'R') && (iOIQualifier != (byte)'Y') && (iOIQualifier != (byte)'X') && (iOIQualifier != (byte)'Z') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 104);		
				if (err.hasError()) {		
					buf.position(hasIOIQualifier);		
					return (byte)'0';		
				}		
			}		
			hasIOIQualifier = FixUtils.TAG_HAS_VALUE;		
			return iOIQualifier;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasIOIQualifier() { return hasIOIQualifier != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setIOIQualifier(byte src) {		
		iOIQualifier = src;
		hasIOIQualifier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIOIQualifier(byte[] src) {		
		if (src == null ) return;
		if (hasIOIQualifier()) iOIQualifier = (byte)' ';		
		iOIQualifier = src[0];		
		hasIOIQualifier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setIOIQualifier(String str) {		
		if (str == null ) return;
		if (hasIOIQualifier()) iOIQualifier = (byte)' ';		
		byte[] src = str.getBytes(); 		
		iOIQualifier = src[0];		
		hasIOIQualifier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasIOIQualifier()) s += "IOIQualifier(104)= " + getIOIQualifier() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixIOIQualGrp)) return false;

		FixIOIQualGrp msg = (FixIOIQualGrp) o;

		if ((hasIOIQualifier() && !msg.hasIOIQualifier()) || (!hasIOIQualifier() && msg.hasIOIQualifier())) return false;
		if (!(!hasIOIQualifier() && !msg.hasIOIQualifier()) && !(getIOIQualifier()==msg.getIOIQualifier())) return false;
		return true;
	}
	public FixIOIQualGrp clone ( FixIOIQualGrp out ) {
		if ( hasIOIQualifier())
			out.setIOIQualifier(getIOIQualifier());
		return out;
	}

}
