package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixQuotQualGrp extends FixGroup {
	private short hasQuoteQualifier;
	byte quoteQualifier = (byte)' ';		
	
	public FixQuotQualGrp() {
		this(false);
	}

	public FixQuotQualGrp(boolean isRequired) {
		super(FixTags.QUOTEQUALIFIER_INT);

		this.isRequired = isRequired;
		
		hasQuoteQualifier = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasQuoteQualifier()) return true;
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
            	case FixTags.QUOTEQUALIFIER_INT:		
            		hasQuoteQualifier = (short) buf.position();		
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
		hasQuoteQualifier = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasQuoteQualifier()) {		
			out.put(FixTags.QUOTEQUALIFIER);

			out.put((byte) '=');

			FixUtils.put(out,quoteQualifier); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasQuoteQualifier()) {		
			FixUtils.put(out,quoteQualifier); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte getQuoteQualifier() { 		
		if ( hasQuoteQualifier()) {		
			if (hasQuoteQualifier == FixUtils.TAG_HAS_VALUE) {		
				return quoteQualifier; 		
			} else {		
		
				buf.position(hasQuoteQualifier);		
		
			quoteQualifier = FixUtils.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasQuoteQualifier);		
					return (byte)'0';		
				}		
			}		
			hasQuoteQualifier = FixUtils.TAG_HAS_VALUE;		
			return quoteQualifier;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasQuoteQualifier() { return hasQuoteQualifier != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setQuoteQualifier(byte src) {		
		quoteQualifier = src;
		hasQuoteQualifier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteQualifier(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteQualifier()) quoteQualifier = (byte)' ';		
		quoteQualifier = src[0];		
		hasQuoteQualifier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setQuoteQualifier(String str) {		
		if (str == null ) return;
		if (hasQuoteQualifier()) quoteQualifier = (byte)' ';		
		byte[] src = str.getBytes(); 		
		quoteQualifier = src[0];		
		hasQuoteQualifier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasQuoteQualifier()) s += "QuoteQualifier(695)= " + getQuoteQualifier() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixQuotQualGrp)) return false;

		FixQuotQualGrp msg = (FixQuotQualGrp) o;

		if ((hasQuoteQualifier() && !msg.hasQuoteQualifier()) || (!hasQuoteQualifier() && msg.hasQuoteQualifier())) return false;
		if (!(!hasQuoteQualifier() && !msg.hasQuoteQualifier()) && !(getQuoteQualifier()==msg.getQuoteQualifier())) return false;
		return true;
	}
	public FixQuotQualGrp clone ( FixQuotQualGrp out ) {
		if ( hasQuoteQualifier())
			out.setQuoteQualifier(getQuoteQualifier());
		return out;
	}

}
