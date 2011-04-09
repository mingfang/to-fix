package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixMiscFeesGrp extends FixGroup {
	private short hasMiscFeeAmt;
	long miscFeeAmt = 0;		
	private short hasMiscFeeCurr;
	byte[] miscFeeCurr = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasMiscFeeType;
	byte[] miscFeeType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMiscFeeBasis;
	long miscFeeBasis = 0;		
	
	public FixMiscFeesGrp() {
		this(false);
	}

	public FixMiscFeesGrp(boolean isRequired) {
		super(FixTags.MISCFEEAMT_INT);

		this.isRequired = isRequired;
		
		hasMiscFeeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasMiscFeeCurr = FixUtils.TAG_HAS_NO_VALUE;		
		miscFeeCurr = new byte[FixUtils.CURRENCY_LENGTH];		
		hasMiscFeeType = FixUtils.TAG_HAS_NO_VALUE;		
		miscFeeType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMiscFeeBasis = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasMiscFeeAmt()) return true;
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
            	case FixTags.MISCFEEAMT_INT:		
            		hasMiscFeeAmt = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MISCFEECURR_INT:		
            		hasMiscFeeCurr = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MISCFEETYPE_INT:		
            		hasMiscFeeType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MISCFEEBASIS_INT:		
            		hasMiscFeeBasis = (short) buf.position();		
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
		hasMiscFeeAmt = FixUtils.TAG_HAS_NO_VALUE;
		hasMiscFeeCurr = FixUtils.TAG_HAS_NO_VALUE;
		hasMiscFeeType = FixUtils.TAG_HAS_NO_VALUE;
		hasMiscFeeBasis = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasMiscFeeAmt()) {		
			out.put(FixTags.MISCFEEAMT);

			out.put((byte) '=');

			FixUtils.put(out, (long)miscFeeAmt);
		
			out.put(FixUtils.SOH);

            }

		if (hasMiscFeeCurr()) {		
			out.put(FixTags.MISCFEECURR);

			out.put((byte) '=');

			FixUtils.put(out,miscFeeCurr); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMiscFeeType()) {		
			out.put(FixTags.MISCFEETYPE);

			out.put((byte) '=');

			FixUtils.put(out,miscFeeType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMiscFeeBasis()) {		
			out.put(FixTags.MISCFEEBASIS);

			out.put((byte) '=');

			FixUtils.put(out, (long)miscFeeBasis);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasMiscFeeAmt()) {		
			FixUtils.put(out, (long)miscFeeAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMiscFeeCurr()) {		
			FixUtils.put(out,miscFeeCurr); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMiscFeeType()) {		
			FixUtils.put(out,miscFeeType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMiscFeeBasis()) {		
			FixUtils.put(out, (long)miscFeeBasis);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getMiscFeeAmt() { 		
		if ( hasMiscFeeAmt()) {		
			if (hasMiscFeeAmt == FixUtils.TAG_HAS_VALUE) {		
				return miscFeeAmt; 		
			} else {		
		
				buf.position(hasMiscFeeAmt);		
		
			miscFeeAmt = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMiscFeeAmt);		
					return 0;		
				}		
			}		
			hasMiscFeeAmt = FixUtils.TAG_HAS_VALUE;		
			return miscFeeAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMiscFeeAmt() { return hasMiscFeeAmt != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMiscFeeAmt(long src) {		
		miscFeeAmt = src;
		hasMiscFeeAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMiscFeeAmt(byte[] src) {		
		if (src == null ) return;
		if (hasMiscFeeAmt()) miscFeeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		miscFeeAmt = FixUtils.longValueOf(src, 0, src.length);
		hasMiscFeeAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMiscFeeAmt(String str) {		
		if (str == null ) return;
		if (hasMiscFeeAmt()) miscFeeAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		miscFeeAmt = FixUtils.longValueOf(src, 0, src.length);
		hasMiscFeeAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMiscFeeCurr() { 		
		if ( hasMiscFeeCurr()) {		
			if (hasMiscFeeCurr == FixUtils.TAG_HAS_VALUE) {		
				return miscFeeCurr; 		
			} else {		
		
				buf.position(hasMiscFeeCurr);		
		
			FixUtils.getTagStringValue(buf, miscFeeCurr, 0, miscFeeCurr.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMiscFeeCurr);		
					return null;		
				}		
			}		
			hasMiscFeeCurr = FixUtils.TAG_HAS_VALUE;		
			return miscFeeCurr;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMiscFeeCurr() { return hasMiscFeeCurr != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMiscFeeCurr(byte[] src) {		
		if (src == null ) return;
		if (hasMiscFeeCurr()) FixUtils.fillNul(miscFeeCurr);		
		FixUtils.copy(miscFeeCurr, src); 		
		hasMiscFeeCurr = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMiscFeeCurr(String str) {		
		if (str == null ) return;
		if (hasMiscFeeCurr()) FixUtils.fillNul(miscFeeCurr);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(miscFeeCurr, src); 		
		hasMiscFeeCurr = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMiscFeeType() { 		
		if ( hasMiscFeeType()) {		
			if (hasMiscFeeType == FixUtils.TAG_HAS_VALUE) {		
				return miscFeeType; 		
			} else {		
		
				buf.position(hasMiscFeeType);		
		
			FixUtils.getTagStringValue(buf, miscFeeType, 0, miscFeeType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMiscFeeType);		
					return null;		
				}		
			}		
			hasMiscFeeType = FixUtils.TAG_HAS_VALUE;		
			return miscFeeType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMiscFeeType() { return hasMiscFeeType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMiscFeeType(byte[] src) {		
		if (src == null ) return;
		if (hasMiscFeeType()) FixUtils.fillNul(miscFeeType);		
		FixUtils.copy(miscFeeType, src); 		
		hasMiscFeeType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMiscFeeType(String str) {		
		if (str == null ) return;
		if (hasMiscFeeType()) FixUtils.fillNul(miscFeeType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(miscFeeType, src); 		
		hasMiscFeeType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMiscFeeBasis() { 		
		if ( hasMiscFeeBasis()) {		
			if (hasMiscFeeBasis == FixUtils.TAG_HAS_VALUE) {		
				return miscFeeBasis; 		
			} else {		
		
				buf.position(hasMiscFeeBasis);		
		
			miscFeeBasis = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMiscFeeBasis);		
					return 0;		
				}		
			}		
			hasMiscFeeBasis = FixUtils.TAG_HAS_VALUE;		
			return miscFeeBasis;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMiscFeeBasis() { return hasMiscFeeBasis != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMiscFeeBasis(long src) {		
		miscFeeBasis = src;
		hasMiscFeeBasis = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMiscFeeBasis(byte[] src) {		
		if (src == null ) return;
		if (hasMiscFeeBasis()) miscFeeBasis = FixUtils.TAG_HAS_NO_VALUE;		
		miscFeeBasis = FixUtils.longValueOf(src, 0, src.length);
		hasMiscFeeBasis = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMiscFeeBasis(String str) {		
		if (str == null ) return;
		if (hasMiscFeeBasis()) miscFeeBasis = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		miscFeeBasis = FixUtils.longValueOf(src, 0, src.length);
		hasMiscFeeBasis = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasMiscFeeAmt()) s += "MiscFeeAmt(137)= " + getMiscFeeAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMiscFeeCurr()) s += "MiscFeeCurr(138)= " + new String( FixUtils.trim(getMiscFeeCurr()) ) + "\n" ; 
		if (hasMiscFeeType()) s += "MiscFeeType(139)= " + new String( FixUtils.trim(getMiscFeeType()) ) + "\n" ; 
		if (hasMiscFeeBasis()) s += "MiscFeeBasis(891)= " + getMiscFeeBasis() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixMiscFeesGrp)) return false;

		FixMiscFeesGrp msg = (FixMiscFeesGrp) o;

		if ((hasMiscFeeAmt() && !msg.hasMiscFeeAmt()) || (!hasMiscFeeAmt() && msg.hasMiscFeeAmt())) return false;
		if (!(!hasMiscFeeAmt() && !msg.hasMiscFeeAmt()) && !(getMiscFeeAmt()==msg.getMiscFeeAmt())) return false;
		if ((hasMiscFeeCurr() && !msg.hasMiscFeeCurr()) || (!hasMiscFeeCurr() && msg.hasMiscFeeCurr())) return false;
		if (!(!hasMiscFeeCurr() && !msg.hasMiscFeeCurr()) && !FixUtils.equals(getMiscFeeCurr(), msg.getMiscFeeCurr())) return false;
		if ((hasMiscFeeType() && !msg.hasMiscFeeType()) || (!hasMiscFeeType() && msg.hasMiscFeeType())) return false;
		if (!(!hasMiscFeeType() && !msg.hasMiscFeeType()) && !FixUtils.equals(getMiscFeeType(), msg.getMiscFeeType())) return false;
		if ((hasMiscFeeBasis() && !msg.hasMiscFeeBasis()) || (!hasMiscFeeBasis() && msg.hasMiscFeeBasis())) return false;
		if (!(!hasMiscFeeBasis() && !msg.hasMiscFeeBasis()) && !(getMiscFeeBasis()==msg.getMiscFeeBasis())) return false;
		return true;
	}
	public FixMiscFeesGrp clone ( FixMiscFeesGrp out ) {
		if ( hasMiscFeeAmt())
			out.setMiscFeeAmt(getMiscFeeAmt());
		if ( hasMiscFeeCurr())
			out.setMiscFeeCurr(getMiscFeeCurr());
		if ( hasMiscFeeType())
			out.setMiscFeeType(getMiscFeeType());
		if ( hasMiscFeeBasis())
			out.setMiscFeeBasis(getMiscFeeBasis());
		return out;
	}

}
