package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixContAmtGrp extends FixGroup {
	private short hasContAmtType;
	long contAmtType = 0;		
	private short hasContAmtValue;
	long contAmtValue = 0;		
	private short hasContAmtCurr;
	byte[] contAmtCurr = new byte[FixUtils.CURRENCY_LENGTH];		
	
	public FixContAmtGrp() {
		super(FixTags.CONTAMTTYPE_INT);

		
		hasContAmtType = FixUtils.TAG_HAS_NO_VALUE;		
		hasContAmtValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasContAmtCurr = FixUtils.TAG_HAS_NO_VALUE;		
		contAmtCurr = new byte[FixUtils.CURRENCY_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasContAmtType()) return true;
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
            	case FixTags.CONTAMTTYPE_INT:		
            		hasContAmtType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CONTAMTVALUE_INT:		
            		hasContAmtValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CONTAMTCURR_INT:		
            		hasContAmtCurr = (short) buf.position();		
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
		hasContAmtType = FixUtils.TAG_HAS_NO_VALUE;
		hasContAmtValue = FixUtils.TAG_HAS_NO_VALUE;
		hasContAmtCurr = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasContAmtType()) {		
			out.put(FixTags.CONTAMTTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)contAmtType);
		
			out.put(FixUtils.SOH);

            }

		if (hasContAmtValue()) {		
			out.put(FixTags.CONTAMTVALUE);

			out.put((byte) '=');

			FixUtils.put(out, (long)contAmtValue);
		
			out.put(FixUtils.SOH);

            }

		if (hasContAmtCurr()) {		
			out.put(FixTags.CONTAMTCURR);

			out.put((byte) '=');

			FixUtils.put(out,contAmtCurr); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasContAmtType()) {		
			FixUtils.put(out, (long)contAmtType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContAmtValue()) {		
			FixUtils.put(out, (long)contAmtValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContAmtCurr()) {		
			FixUtils.put(out,contAmtCurr); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getContAmtType() { 		
		if ( hasContAmtType()) {		
			if (hasContAmtType == FixUtils.TAG_HAS_VALUE) {		
				return contAmtType; 		
			} else {		
		
				buf.position(hasContAmtType);		
		
			contAmtType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasContAmtType);		
					return 0;		
				}		
			}		
			hasContAmtType = FixUtils.TAG_HAS_VALUE;		
			return contAmtType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasContAmtType() { return hasContAmtType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContAmtType(long src) {		
		contAmtType = src;
		hasContAmtType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContAmtType(byte[] src) {		
		if (src == null ) return;
		if (hasContAmtType()) contAmtType = FixUtils.TAG_HAS_NO_VALUE;		
		contAmtType = FixUtils.longValueOf(src, 0, src.length);
		hasContAmtType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContAmtType(String str) {		
		if (str == null ) return;
		if (hasContAmtType()) contAmtType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		contAmtType = FixUtils.longValueOf(src, 0, src.length);
		hasContAmtType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getContAmtValue() { 		
		if ( hasContAmtValue()) {		
			if (hasContAmtValue == FixUtils.TAG_HAS_VALUE) {		
				return contAmtValue; 		
			} else {		
		
				buf.position(hasContAmtValue);		
		
			contAmtValue = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasContAmtValue);		
					return 0;		
				}		
			}		
			hasContAmtValue = FixUtils.TAG_HAS_VALUE;		
			return contAmtValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasContAmtValue() { return hasContAmtValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContAmtValue(long src) {		
		contAmtValue = src;
		hasContAmtValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContAmtValue(byte[] src) {		
		if (src == null ) return;
		if (hasContAmtValue()) contAmtValue = FixUtils.TAG_HAS_NO_VALUE;		
		contAmtValue = FixUtils.longValueOf(src, 0, src.length);
		hasContAmtValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContAmtValue(String str) {		
		if (str == null ) return;
		if (hasContAmtValue()) contAmtValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		contAmtValue = FixUtils.longValueOf(src, 0, src.length);
		hasContAmtValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getContAmtCurr() { 		
		if ( hasContAmtCurr()) {		
			if (hasContAmtCurr == FixUtils.TAG_HAS_VALUE) {		
				return contAmtCurr; 		
			} else {		
		
				buf.position(hasContAmtCurr);		
		
			FixMessage.getTagStringValue(buf, contAmtCurr, 0, contAmtCurr.length, err);
		
				if (err.hasError()) {		
					buf.position(hasContAmtCurr);		
					return null;		
				}		
			}		
			hasContAmtCurr = FixUtils.TAG_HAS_VALUE;		
			return contAmtCurr;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasContAmtCurr() { return hasContAmtCurr != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContAmtCurr(byte[] src) {		
		if (src == null ) return;
		if (hasContAmtCurr()) FixUtils.fillSpace(contAmtCurr);		
		FixUtils.copy(contAmtCurr, src); 		
		hasContAmtCurr = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContAmtCurr(String str) {		
		if (str == null ) return;
		if (hasContAmtCurr()) FixUtils.fillSpace(contAmtCurr);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(contAmtCurr, src); 		
		hasContAmtCurr = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasContAmtType()) s += "ContAmtType(519)= " + getContAmtType() + "\n" ; 
		if (hasContAmtValue()) s += "ContAmtValue(520)= " + getContAmtValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasContAmtCurr()) s += "ContAmtCurr(521)= " + new String( FixUtils.trim(getContAmtCurr()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixContAmtGrp)) return false;

		FixContAmtGrp msg = (FixContAmtGrp) o;

		if ((hasContAmtType() && !msg.hasContAmtType()) || (!hasContAmtType() && msg.hasContAmtType())) return false;
		if (!(!hasContAmtType() && !msg.hasContAmtType()) && !(getContAmtType()==msg.getContAmtType())) return false;
		if ((hasContAmtValue() && !msg.hasContAmtValue()) || (!hasContAmtValue() && msg.hasContAmtValue())) return false;
		if (!(!hasContAmtValue() && !msg.hasContAmtValue()) && !(getContAmtValue()==msg.getContAmtValue())) return false;
		if ((hasContAmtCurr() && !msg.hasContAmtCurr()) || (!hasContAmtCurr() && msg.hasContAmtCurr())) return false;
		if (!(!hasContAmtCurr() && !msg.hasContAmtCurr()) && !FixUtils.equals(getContAmtCurr(), msg.getContAmtCurr())) return false;
		return true;
	}
	public FixContAmtGrp clone ( FixContAmtGrp out ) {
		if ( hasContAmtType())
			out.setContAmtType(getContAmtType());
		if ( hasContAmtValue())
			out.setContAmtValue(getContAmtValue());
		if ( hasContAmtCurr())
			out.setContAmtCurr(getContAmtCurr());
		return out;
	}

}
