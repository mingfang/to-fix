package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixStrandardTrailer extends FixGroup {
	private short hasSignatureLength;
	long signatureLength = 0;		
	private short hasSignature;
	byte[] signature = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCheckSum;
	byte[] checkSum = new byte[3];		
	
	public FixStrandardTrailer() {
		this(false);
	}

	public FixStrandardTrailer(boolean isRequired) {
		super(FixTags.CHECKSUM_INT);

		this.isRequired = isRequired;
		
		hasSignatureLength = FixUtils.TAG_HAS_NO_VALUE;		
		hasSignature = FixUtils.TAG_HAS_NO_VALUE;		
		signature = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCheckSum = FixUtils.TAG_HAS_NO_VALUE;		
		checkSum = new byte[3];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSignatureLength()) return true;
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
            	case FixTags.SIGNATURELENGTH_INT:		
            		hasSignatureLength = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SIGNATURE_INT:		
            		hasSignature = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CHECKSUM_INT:		
            		hasCheckSum = (short) buf.position();		
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
		if (!hasCheckSum()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CHECKSUM_INT);
			return false;
		}
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasSignatureLength = FixUtils.TAG_HAS_NO_VALUE;
		hasSignature = FixUtils.TAG_HAS_NO_VALUE;
		hasCheckSum = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSignatureLength()) {		
			out.put(FixTags.SIGNATURELENGTH);

			out.put((byte) '=');

			FixUtils.put(out, (long)signatureLength);
		
			out.put(FixUtils.SOH);

            }

		if (hasSignature()) {		
			out.put(FixTags.SIGNATURE);

			out.put((byte) '=');

			FixUtils.put(out,signature); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCheckSum()) {		
			out.put(FixTags.CHECKSUM);

			out.put((byte) '=');

			FixUtils.put(out,checkSum); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSignatureLength()) {		
			FixUtils.put(out, (long)signatureLength);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSignature()) {		
			FixUtils.put(out,signature); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCheckSum()) {		
			FixUtils.put(out,checkSum); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getSignatureLength() { 		
		if ( hasSignatureLength()) {		
			if (hasSignatureLength == FixUtils.TAG_HAS_VALUE) {		
				return signatureLength; 		
			} else {		
		
				buf.position(hasSignatureLength);		
		
			signatureLength = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSignatureLength);		
					return 0;		
				}		
			}		
			hasSignatureLength = FixUtils.TAG_HAS_VALUE;		
			return signatureLength;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSignatureLength() { return hasSignatureLength != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSignatureLength(long src) {		
		signatureLength = src;
		hasSignatureLength = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSignatureLength(byte[] src) {		
		if (src == null ) return;
		if (hasSignatureLength()) signatureLength = FixUtils.TAG_HAS_NO_VALUE;		
		signatureLength = FixUtils.longValueOf(src, 0, src.length);
		hasSignatureLength = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSignatureLength(String str) {		
		if (str == null ) return;
		if (hasSignatureLength()) signatureLength = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		signatureLength = FixUtils.longValueOf(src, 0, src.length);
		hasSignatureLength = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSignature() { 		
		if ( hasSignature()) {		
			if (hasSignature == FixUtils.TAG_HAS_VALUE) {		
				return signature; 		
			} else {		
		
				buf.position(hasSignature);		
		
			FixUtils.getTagStringValue(buf, signature, 0, signature.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSignature);		
					return null;		
				}		
			}		
			hasSignature = FixUtils.TAG_HAS_VALUE;		
			return signature;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSignature() { return hasSignature != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSignature(byte[] src) {		
		if (src == null ) return;
		if (hasSignature()) FixUtils.fillNul(signature);		
		FixUtils.copy(signature, src); 		
		hasSignature = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSignature(String str) {		
		if (str == null ) return;
		if (hasSignature()) FixUtils.fillNul(signature);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(signature, src); 		
		hasSignature = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCheckSum() { 		
		if ( hasCheckSum()) {		
			if (hasCheckSum == FixUtils.TAG_HAS_VALUE) {		
				return checkSum; 		
			} else {		
		
				buf.position(hasCheckSum);		
		
			FixUtils.getTagStringValue(buf, checkSum, 0, checkSum.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCheckSum);		
					return null;		
				}		
			}		
			hasCheckSum = FixUtils.TAG_HAS_VALUE;		
			return checkSum;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCheckSum() { return hasCheckSum != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCheckSum(byte[] src) {		
		if (src == null ) return;
		if (hasCheckSum()) FixUtils.fillNul(checkSum);		
		FixUtils.copy(checkSum, src); 		
		hasCheckSum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCheckSum(String str) {		
		if (str == null ) return;
		if (hasCheckSum()) FixUtils.fillNul(checkSum);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(checkSum, src); 		
		hasCheckSum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSignatureLength()) s += "SignatureLength(93)= " + getSignatureLength() + "\n" ; 
		if (hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(getSignature()) ) + "\n" ; 
		if (hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(getCheckSum()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStrandardTrailer)) return false;

		FixStrandardTrailer msg = (FixStrandardTrailer) o;

		if ((hasSignatureLength() && !msg.hasSignatureLength()) || (!hasSignatureLength() && msg.hasSignatureLength())) return false;
		if (!(!hasSignatureLength() && !msg.hasSignatureLength()) && !(getSignatureLength()==msg.getSignatureLength())) return false;
		if ((hasSignature() && !msg.hasSignature()) || (!hasSignature() && msg.hasSignature())) return false;
		if (!(!hasSignature() && !msg.hasSignature()) && !FixUtils.equals(getSignature(), msg.getSignature())) return false;
		return true;
	}
	public FixStrandardTrailer clone ( FixStrandardTrailer out ) {
		if ( hasSignatureLength())
			out.setSignatureLength(getSignatureLength());
		if ( hasSignature())
			out.setSignature(getSignature());
		if ( hasCheckSum())
			out.setCheckSum(getCheckSum());
		return out;
	}

}
