package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSecTypesGrp extends FixGroup {
	private short hasSecurityType;
	byte[] securityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecuritySubType;
	byte[] securitySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasProduct;
	long product = 0;		
	private short hasCFICode;
	byte[] cFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	
	public FixSecTypesGrp() {
		super(FixTags.SECURITYTYPE_INT);

		
		hasSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		securityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;		
		securitySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasProduct = FixUtils.TAG_HAS_NO_VALUE;		
		hasCFICode = FixUtils.TAG_HAS_NO_VALUE;		
		cFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSecurityType()) return true;
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
            	case FixTags.SECURITYTYPE_INT:		
            		hasSecurityType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYSUBTYPE_INT:		
            		hasSecuritySubType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PRODUCT_INT:		
            		hasProduct = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CFICODE_INT:		
            		hasCFICode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
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
		hasSecurityType = FixUtils.TAG_HAS_NO_VALUE;
		hasSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;
		hasProduct = FixUtils.TAG_HAS_NO_VALUE;
		hasCFICode = FixUtils.TAG_HAS_NO_VALUE;
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSecurityType()) {		
			out.put(FixTags.SECURITYTYPE);

			out.put((byte) '=');

			FixUtils.put(out,securityType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecuritySubType()) {		
			out.put(FixTags.SECURITYSUBTYPE);

			out.put((byte) '=');

			FixUtils.put(out,securitySubType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasProduct()) {		
			out.put(FixTags.PRODUCT);

			out.put((byte) '=');

			FixUtils.put(out, (long)product);
		
			out.put(FixUtils.SOH);

            }

		if (hasCFICode()) {		
			out.put(FixTags.CFICODE);

			out.put((byte) '=');

			FixUtils.put(out,cFICode); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);

			out.put((byte) '=');

			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSecurityType()) {		
			FixUtils.put(out,securityType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecuritySubType()) {		
			FixUtils.put(out,securitySubType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasProduct()) {		
			FixUtils.put(out, (long)product);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCFICode()) {		
			FixUtils.put(out,cFICode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getSecurityType() { 		
		if ( hasSecurityType()) {		
			if (hasSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return securityType; 		
			} else {		
		
				buf.position(hasSecurityType);		
		
			FixMessage.getTagStringValue(buf, securityType, 0, securityType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityType);		
					return null;		
				}		
			}		
			hasSecurityType = FixUtils.TAG_HAS_VALUE;		
			return securityType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityType() { return hasSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityType()) FixUtils.fillSpace(securityType);		
		FixUtils.copy(securityType, src); 		
		hasSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityType(String str) {		
		if (str == null ) return;
		if (hasSecurityType()) FixUtils.fillSpace(securityType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityType, src); 		
		hasSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecuritySubType() { 		
		if ( hasSecuritySubType()) {		
			if (hasSecuritySubType == FixUtils.TAG_HAS_VALUE) {		
				return securitySubType; 		
			} else {		
		
				buf.position(hasSecuritySubType);		
		
			FixMessage.getTagStringValue(buf, securitySubType, 0, securitySubType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecuritySubType);		
					return null;		
				}		
			}		
			hasSecuritySubType = FixUtils.TAG_HAS_VALUE;		
			return securitySubType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecuritySubType() { return hasSecuritySubType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecuritySubType(byte[] src) {		
		if (src == null ) return;
		if (hasSecuritySubType()) FixUtils.fillSpace(securitySubType);		
		FixUtils.copy(securitySubType, src); 		
		hasSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecuritySubType(String str) {		
		if (str == null ) return;
		if (hasSecuritySubType()) FixUtils.fillSpace(securitySubType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securitySubType, src); 		
		hasSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getProduct() { 		
		if ( hasProduct()) {		
			if (hasProduct == FixUtils.TAG_HAS_VALUE) {		
				return product; 		
			} else {		
		
				buf.position(hasProduct);		
		
			product = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasProduct);		
					return 0;		
				}		
			}		
			hasProduct = FixUtils.TAG_HAS_VALUE;		
			return product;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasProduct() { return hasProduct != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setProduct(long src) {		
		product = src;
		hasProduct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProduct(byte[] src) {		
		if (src == null ) return;
		if (hasProduct()) product = FixUtils.TAG_HAS_NO_VALUE;		
		product = FixUtils.longValueOf(src, 0, src.length);
		hasProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setProduct(String str) {		
		if (str == null ) return;
		if (hasProduct()) product = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		product = FixUtils.longValueOf(src, 0, src.length);
		hasProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCFICode() { 		
		if ( hasCFICode()) {		
			if (hasCFICode == FixUtils.TAG_HAS_VALUE) {		
				return cFICode; 		
			} else {		
		
				buf.position(hasCFICode);		
		
			FixMessage.getTagStringValue(buf, cFICode, 0, cFICode.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCFICode);		
					return null;		
				}		
			}		
			hasCFICode = FixUtils.TAG_HAS_VALUE;		
			return cFICode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCFICode() { return hasCFICode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCFICode(byte[] src) {		
		if (src == null ) return;
		if (hasCFICode()) FixUtils.fillSpace(cFICode);		
		FixUtils.copy(cFICode, src); 		
		hasCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCFICode(String str) {		
		if (str == null ) return;
		if (hasCFICode()) FixUtils.fillSpace(cFICode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cFICode, src); 		
		hasCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTransactTime() { 		
		if ( hasTransactTime()) {		
			if (hasTransactTime == FixUtils.TAG_HAS_VALUE) {		
				return transactTime; 		
			} else {		
		
				buf.position(hasTransactTime);		
		
			FixMessage.getTagStringValue(buf, transactTime, 0, transactTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTransactTime);		
					return null;		
				}		
			}		
			hasTransactTime = FixUtils.TAG_HAS_VALUE;		
			return transactTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTransactTime() { return hasTransactTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTransactTime(byte[] src) {		
		if (src == null ) return;
		if (hasTransactTime()) FixUtils.fillSpace(transactTime);		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTransactTime(String str) {		
		if (str == null ) return;
		if (hasTransactTime()) FixUtils.fillSpace(transactTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSecurityType()) s += "SecurityType(167)= " + new String( FixUtils.trim(getSecurityType()) ) + "\n" ; 
		if (hasSecuritySubType()) s += "SecuritySubType(762)= " + new String( FixUtils.trim(getSecuritySubType()) ) + "\n" ; 
		if (hasProduct()) s += "Product(460)= " + getProduct() + "\n" ; 
		if (hasCFICode()) s += "CFICode(461)= " + new String( FixUtils.trim(getCFICode()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSecTypesGrp)) return false;

		FixSecTypesGrp msg = (FixSecTypesGrp) o;

		if ((hasSecurityType() && !msg.hasSecurityType()) || (!hasSecurityType() && msg.hasSecurityType())) return false;
		if (!(!hasSecurityType() && !msg.hasSecurityType()) && !FixUtils.equals(getSecurityType(), msg.getSecurityType())) return false;
		if ((hasSecuritySubType() && !msg.hasSecuritySubType()) || (!hasSecuritySubType() && msg.hasSecuritySubType())) return false;
		if (!(!hasSecuritySubType() && !msg.hasSecuritySubType()) && !FixUtils.equals(getSecuritySubType(), msg.getSecuritySubType())) return false;
		if ((hasProduct() && !msg.hasProduct()) || (!hasProduct() && msg.hasProduct())) return false;
		if (!(!hasProduct() && !msg.hasProduct()) && !(getProduct()==msg.getProduct())) return false;
		if ((hasCFICode() && !msg.hasCFICode()) || (!hasCFICode() && msg.hasCFICode())) return false;
		if (!(!hasCFICode() && !msg.hasCFICode()) && !FixUtils.equals(getCFICode(), msg.getCFICode())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if (!(!hasTransactTime() && !msg.hasTransactTime()) ) return false;
		return true;
	}
	public FixSecTypesGrp clone ( FixSecTypesGrp out ) {
		if ( hasSecurityType())
			out.setSecurityType(getSecurityType());
		if ( hasSecuritySubType())
			out.setSecuritySubType(getSecuritySubType());
		if ( hasProduct())
			out.setProduct(getProduct());
		if ( hasCFICode())
			out.setCFICode(getCFICode());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		return out;
	}

}
