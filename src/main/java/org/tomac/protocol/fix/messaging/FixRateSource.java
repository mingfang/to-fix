package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRateSource extends FixGroup {
	private short hasRateSource;
	long rateSource = 0;		
	private short hasRateSourceType;
	long rateSourceType = 0;		
	private short hasReferencePage;
	byte[] referencePage = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixRateSource() {
		super(FixTags.RATESOURCE_INT);

		
		hasRateSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasRateSourceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasReferencePage = FixUtils.TAG_HAS_NO_VALUE;		
		referencePage = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRateSource()) return true;
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
            	case FixTags.RATESOURCE_INT:		
            		hasRateSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RATESOURCETYPE_INT:		
            		hasRateSourceType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.REFERENCEPAGE_INT:		
            		hasReferencePage = (short) buf.position();		
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
		hasRateSource = FixUtils.TAG_HAS_NO_VALUE;
		hasRateSourceType = FixUtils.TAG_HAS_NO_VALUE;
		hasReferencePage = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRateSource()) {		
			out.put(FixTags.RATESOURCE);

			out.put((byte) '=');

			FixUtils.put(out, (long)rateSource);
		
			out.put(FixUtils.SOH);

            }

		if (hasRateSourceType()) {		
			out.put(FixTags.RATESOURCETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)rateSourceType);
		
			out.put(FixUtils.SOH);

            }

		if (hasReferencePage()) {		
			out.put(FixTags.REFERENCEPAGE);

			out.put((byte) '=');

			FixUtils.put(out,referencePage); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRateSource()) {		
			FixUtils.put(out, (long)rateSource);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRateSourceType()) {		
			FixUtils.put(out, (long)rateSourceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasReferencePage()) {		
			FixUtils.put(out,referencePage); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getRateSource() { 		
		if ( hasRateSource()) {		
			if (hasRateSource == FixUtils.TAG_HAS_VALUE) {		
				return rateSource; 		
			} else {		
		
				buf.position(hasRateSource);		
		
			rateSource = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRateSource);		
					return 0;		
				}		
			}		
			hasRateSource = FixUtils.TAG_HAS_VALUE;		
			return rateSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRateSource() { return hasRateSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRateSource(long src) {		
		rateSource = src;
		hasRateSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRateSource(byte[] src) {		
		if (src == null ) return;
		if (hasRateSource()) rateSource = FixUtils.TAG_HAS_NO_VALUE;		
		rateSource = FixUtils.longValueOf(src, 0, src.length);
		hasRateSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRateSource(String str) {		
		if (str == null ) return;
		if (hasRateSource()) rateSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		rateSource = FixUtils.longValueOf(src, 0, src.length);
		hasRateSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRateSourceType() { 		
		if ( hasRateSourceType()) {		
			if (hasRateSourceType == FixUtils.TAG_HAS_VALUE) {		
				return rateSourceType; 		
			} else {		
		
				buf.position(hasRateSourceType);		
		
			rateSourceType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRateSourceType);		
					return 0;		
				}		
			}		
			hasRateSourceType = FixUtils.TAG_HAS_VALUE;		
			return rateSourceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRateSourceType() { return hasRateSourceType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRateSourceType(long src) {		
		rateSourceType = src;
		hasRateSourceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRateSourceType(byte[] src) {		
		if (src == null ) return;
		if (hasRateSourceType()) rateSourceType = FixUtils.TAG_HAS_NO_VALUE;		
		rateSourceType = FixUtils.longValueOf(src, 0, src.length);
		hasRateSourceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRateSourceType(String str) {		
		if (str == null ) return;
		if (hasRateSourceType()) rateSourceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		rateSourceType = FixUtils.longValueOf(src, 0, src.length);
		hasRateSourceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getReferencePage() { 		
		if ( hasReferencePage()) {		
			if (hasReferencePage == FixUtils.TAG_HAS_VALUE) {		
				return referencePage; 		
			} else {		
		
				buf.position(hasReferencePage);		
		
			FixMessage.getTagStringValue(buf, referencePage, 0, referencePage.length, err);
		
				if (err.hasError()) {		
					buf.position(hasReferencePage);		
					return null;		
				}		
			}		
			hasReferencePage = FixUtils.TAG_HAS_VALUE;		
			return referencePage;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasReferencePage() { return hasReferencePage != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setReferencePage(byte[] src) {		
		if (src == null ) return;
		if (hasReferencePage()) FixUtils.fillSpace(referencePage);		
		FixUtils.copy(referencePage, src); 		
		hasReferencePage = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setReferencePage(String str) {		
		if (str == null ) return;
		if (hasReferencePage()) FixUtils.fillSpace(referencePage);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(referencePage, src); 		
		hasReferencePage = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRateSource()) s += "RateSource(1446)= " + getRateSource() + "\n" ; 
		if (hasRateSourceType()) s += "RateSourceType(1447)= " + getRateSourceType() + "\n" ; 
		if (hasReferencePage()) s += "ReferencePage(1448)= " + new String( FixUtils.trim(getReferencePage()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRateSource)) return false;

		FixRateSource msg = (FixRateSource) o;

		if ((hasRateSource() && !msg.hasRateSource()) || (!hasRateSource() && msg.hasRateSource())) return false;
		if (!(!hasRateSource() && !msg.hasRateSource()) && !(getRateSource()==msg.getRateSource())) return false;
		if ((hasRateSourceType() && !msg.hasRateSourceType()) || (!hasRateSourceType() && msg.hasRateSourceType())) return false;
		if (!(!hasRateSourceType() && !msg.hasRateSourceType()) && !(getRateSourceType()==msg.getRateSourceType())) return false;
		if ((hasReferencePage() && !msg.hasReferencePage()) || (!hasReferencePage() && msg.hasReferencePage())) return false;
		if (!(!hasReferencePage() && !msg.hasReferencePage()) && !FixUtils.equals(getReferencePage(), msg.getReferencePage())) return false;
		return true;
	}
	public FixRateSource clone ( FixRateSource out ) {
		if ( hasRateSource())
			out.setRateSource(getRateSource());
		if ( hasRateSourceType())
			out.setRateSourceType(getRateSourceType());
		if ( hasReferencePage())
			out.setReferencePage(getReferencePage());
		return out;
	}

}
