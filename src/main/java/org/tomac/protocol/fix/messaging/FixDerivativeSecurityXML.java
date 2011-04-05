package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixDerivativeSecurityXML extends FixGroup {
	private short hasDerivativeSecurityXMLLen;
	long derivativeSecurityXMLLen = 0;		
	private short hasDerivativeSecurityXML;
	byte[] derivativeSecurityXML = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeSecurityXMLSchema;
	byte[] derivativeSecurityXMLSchema = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixDerivativeSecurityXML() {
		this(false);
	}

	public FixDerivativeSecurityXML(boolean isRequired) {
		super(FixTags.DERIVATIVESECURITYXML_INT);

		this.isRequired = isRequired;
		
		hasDerivativeSecurityXMLLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasDerivativeSecurityXML = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecurityXML = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeSecurityXMLSchema = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecurityXMLSchema = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasDerivativeSecurityXML()) return true;
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
            	case FixTags.DERIVATIVESECURITYXMLLEN_INT:		
            		hasDerivativeSecurityXMLLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESECURITYXML_INT:		
            		hasDerivativeSecurityXML = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVESECURITYXMLSCHEMA_INT:		
            		hasDerivativeSecurityXMLSchema = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

            }

            tag = FixMessage.getTag(buf, err);
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
		hasDerivativeSecurityXMLLen = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSecurityXML = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeSecurityXMLSchema = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasDerivativeSecurityXMLLen()) {		
			out.put(FixTags.DERIVATIVESECURITYXMLLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeSecurityXMLLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSecurityXML()) {		
			out.put(FixTags.DERIVATIVESECURITYXML);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSecurityXML); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeSecurityXMLSchema()) {		
			out.put(FixTags.DERIVATIVESECURITYXMLSCHEMA);

			out.put((byte) '=');

			FixUtils.put(out,derivativeSecurityXMLSchema); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasDerivativeSecurityXMLLen()) {		
			FixUtils.put(out, (long)derivativeSecurityXMLLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSecurityXML()) {		
			FixUtils.put(out,derivativeSecurityXML); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeSecurityXMLSchema()) {		
			FixUtils.put(out,derivativeSecurityXMLSchema); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getDerivativeSecurityXMLLen() { 		
		if ( hasDerivativeSecurityXMLLen()) {		
			if (hasDerivativeSecurityXMLLen == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecurityXMLLen; 		
			} else {		
		
				buf.position(hasDerivativeSecurityXMLLen);		
		
			derivativeSecurityXMLLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecurityXMLLen);		
					return 0;		
				}		
			}		
			hasDerivativeSecurityXMLLen = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecurityXMLLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeSecurityXMLLen() { return hasDerivativeSecurityXMLLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecurityXMLLen(long src) {		
		derivativeSecurityXMLLen = src;
		hasDerivativeSecurityXMLLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeSecurityXMLLen(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecurityXMLLen()) derivativeSecurityXMLLen = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeSecurityXMLLen = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeSecurityXMLLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecurityXMLLen(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecurityXMLLen()) derivativeSecurityXMLLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeSecurityXMLLen = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeSecurityXMLLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSecurityXML() { 		
		if ( hasDerivativeSecurityXML()) {		
			if (hasDerivativeSecurityXML == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecurityXML; 		
			} else {		
		
				buf.position(hasDerivativeSecurityXML);		
		
			FixMessage.getTagStringValue(buf, derivativeSecurityXML, 0, derivativeSecurityXML.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecurityXML);		
					return null;		
				}		
			}		
			hasDerivativeSecurityXML = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecurityXML;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSecurityXML() { return hasDerivativeSecurityXML != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecurityXML(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecurityXML()) FixUtils.fillNul(derivativeSecurityXML);		
		FixUtils.copy(derivativeSecurityXML, src); 		
		hasDerivativeSecurityXML = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecurityXML(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecurityXML()) FixUtils.fillNul(derivativeSecurityXML);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSecurityXML, src); 		
		hasDerivativeSecurityXML = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeSecurityXMLSchema() { 		
		if ( hasDerivativeSecurityXMLSchema()) {		
			if (hasDerivativeSecurityXMLSchema == FixUtils.TAG_HAS_VALUE) {		
				return derivativeSecurityXMLSchema; 		
			} else {		
		
				buf.position(hasDerivativeSecurityXMLSchema);		
		
			FixMessage.getTagStringValue(buf, derivativeSecurityXMLSchema, 0, derivativeSecurityXMLSchema.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeSecurityXMLSchema);		
					return null;		
				}		
			}		
			hasDerivativeSecurityXMLSchema = FixUtils.TAG_HAS_VALUE;		
			return derivativeSecurityXMLSchema;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeSecurityXMLSchema() { return hasDerivativeSecurityXMLSchema != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeSecurityXMLSchema(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeSecurityXMLSchema()) FixUtils.fillNul(derivativeSecurityXMLSchema);		
		FixUtils.copy(derivativeSecurityXMLSchema, src); 		
		hasDerivativeSecurityXMLSchema = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeSecurityXMLSchema(String str) {		
		if (str == null ) return;
		if (hasDerivativeSecurityXMLSchema()) FixUtils.fillNul(derivativeSecurityXMLSchema);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeSecurityXMLSchema, src); 		
		hasDerivativeSecurityXMLSchema = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasDerivativeSecurityXMLLen()) s += "DerivativeSecurityXMLLen(1282)= " + getDerivativeSecurityXMLLen() + "\n" ; 
		if (hasDerivativeSecurityXML()) s += "DerivativeSecurityXML(1283)= " + new String( FixUtils.trim(getDerivativeSecurityXML()) ) + "\n" ; 
		if (hasDerivativeSecurityXMLSchema()) s += "DerivativeSecurityXMLSchema(1284)= " + new String( FixUtils.trim(getDerivativeSecurityXMLSchema()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDerivativeSecurityXML)) return false;

		FixDerivativeSecurityXML msg = (FixDerivativeSecurityXML) o;

		if ((hasDerivativeSecurityXMLLen() && !msg.hasDerivativeSecurityXMLLen()) || (!hasDerivativeSecurityXMLLen() && msg.hasDerivativeSecurityXMLLen())) return false;
		if (!(!hasDerivativeSecurityXMLLen() && !msg.hasDerivativeSecurityXMLLen()) && !(getDerivativeSecurityXMLLen()==msg.getDerivativeSecurityXMLLen())) return false;
		if ((hasDerivativeSecurityXML() && !msg.hasDerivativeSecurityXML()) || (!hasDerivativeSecurityXML() && msg.hasDerivativeSecurityXML())) return false;
		if (!(!hasDerivativeSecurityXML() && !msg.hasDerivativeSecurityXML()) && !FixUtils.equals(getDerivativeSecurityXML(), msg.getDerivativeSecurityXML())) return false;
		if ((hasDerivativeSecurityXMLSchema() && !msg.hasDerivativeSecurityXMLSchema()) || (!hasDerivativeSecurityXMLSchema() && msg.hasDerivativeSecurityXMLSchema())) return false;
		if (!(!hasDerivativeSecurityXMLSchema() && !msg.hasDerivativeSecurityXMLSchema()) && !FixUtils.equals(getDerivativeSecurityXMLSchema(), msg.getDerivativeSecurityXMLSchema())) return false;
		return true;
	}
	public FixDerivativeSecurityXML clone ( FixDerivativeSecurityXML out ) {
		if ( hasDerivativeSecurityXMLLen())
			out.setDerivativeSecurityXMLLen(getDerivativeSecurityXMLLen());
		if ( hasDerivativeSecurityXML())
			out.setDerivativeSecurityXML(getDerivativeSecurityXML());
		if ( hasDerivativeSecurityXMLSchema())
			out.setDerivativeSecurityXMLSchema(getDerivativeSecurityXMLSchema());
		return out;
	}

}
