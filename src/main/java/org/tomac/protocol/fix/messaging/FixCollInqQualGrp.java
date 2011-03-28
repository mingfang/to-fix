package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixCollInqQualGrp extends FixGroup {
	private short hasCollInquiryQualifier;
	long collInquiryQualifier = 0;		
	
	public FixCollInqQualGrp() {
		super(FixTags.COLLINQUIRYQUALIFIER_INT);

		
		hasCollInquiryQualifier = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasCollInquiryQualifier()) return true;
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
            	case FixTags.COLLINQUIRYQUALIFIER_INT:		
            		hasCollInquiryQualifier = (short) buf.position();		
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
		hasCollInquiryQualifier = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasCollInquiryQualifier()) {		
			out.put(FixTags.COLLINQUIRYQUALIFIER);

			out.put((byte) '=');

			FixUtils.put(out, (long)collInquiryQualifier);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasCollInquiryQualifier()) {		
			FixUtils.put(out, (long)collInquiryQualifier);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getCollInquiryQualifier() { 		
		if ( hasCollInquiryQualifier()) {		
			if (hasCollInquiryQualifier == FixUtils.TAG_HAS_VALUE) {		
				return collInquiryQualifier; 		
			} else {		
		
				buf.position(hasCollInquiryQualifier);		
		
			collInquiryQualifier = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasCollInquiryQualifier);		
					return 0;		
				}		
			}		
			hasCollInquiryQualifier = FixUtils.TAG_HAS_VALUE;		
			return collInquiryQualifier;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCollInquiryQualifier() { return hasCollInquiryQualifier != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCollInquiryQualifier(long src) {		
		collInquiryQualifier = src;
		hasCollInquiryQualifier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollInquiryQualifier(byte[] src) {		
		if (src == null ) return;
		if (hasCollInquiryQualifier()) collInquiryQualifier = FixUtils.TAG_HAS_NO_VALUE;		
		collInquiryQualifier = FixUtils.longValueOf(src, 0, src.length);
		hasCollInquiryQualifier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCollInquiryQualifier(String str) {		
		if (str == null ) return;
		if (hasCollInquiryQualifier()) collInquiryQualifier = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		collInquiryQualifier = FixUtils.longValueOf(src, 0, src.length);
		hasCollInquiryQualifier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasCollInquiryQualifier()) s += "CollInquiryQualifier(896)= " + getCollInquiryQualifier() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixCollInqQualGrp)) return false;

		FixCollInqQualGrp msg = (FixCollInqQualGrp) o;

		if ((hasCollInquiryQualifier() && !msg.hasCollInquiryQualifier()) || (!hasCollInquiryQualifier() && msg.hasCollInquiryQualifier())) return false;
		if (!(!hasCollInquiryQualifier() && !msg.hasCollInquiryQualifier()) && !(getCollInquiryQualifier()==msg.getCollInquiryQualifier())) return false;
		return true;
	}
	public FixCollInqQualGrp clone ( FixCollInqQualGrp out ) {
		if ( hasCollInquiryQualifier())
			out.setCollInquiryQualifier(getCollInquiryQualifier());
		return out;
	}

}
