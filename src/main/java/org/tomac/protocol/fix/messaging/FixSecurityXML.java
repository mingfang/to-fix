package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSecurityXML extends FixGroup {
	private short hasSecurityXMLLen;
	long securityXMLLen = 0;		
	private short hasSecurityXML;
	byte[] securityXML = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityXMLSchema;
	byte[] securityXMLSchema = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixSecurityXML() {
		this(false);
	}

	public FixSecurityXML(boolean isRequired) {
		super(FixTags.SECURITYXML_INT);

		this.isRequired = isRequired;
		
		hasSecurityXMLLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityXML = FixUtils.TAG_HAS_NO_VALUE;		
		securityXML = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityXMLSchema = FixUtils.TAG_HAS_NO_VALUE;		
		securityXMLSchema = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSecurityXML()) return true;
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
            	case FixTags.SECURITYXMLLEN_INT:		
            		hasSecurityXMLLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYXML_INT:		
            		hasSecurityXML = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYXMLSCHEMA_INT:		
            		hasSecurityXMLSchema = (short) buf.position();		
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
		hasSecurityXMLLen = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityXML = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityXMLSchema = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSecurityXMLLen()) {		
			out.put(FixTags.SECURITYXMLLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)securityXMLLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasSecurityXML()) {		
			out.put(FixTags.SECURITYXML);

			out.put((byte) '=');

			FixUtils.put(out,securityXML); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecurityXMLSchema()) {		
			out.put(FixTags.SECURITYXMLSCHEMA);

			out.put((byte) '=');

			FixUtils.put(out,securityXMLSchema); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSecurityXMLLen()) {		
			FixUtils.put(out, (long)securityXMLLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityXML()) {		
			FixUtils.put(out,securityXML); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityXMLSchema()) {		
			FixUtils.put(out,securityXMLSchema); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getSecurityXMLLen() { 		
		if ( hasSecurityXMLLen()) {		
			if (hasSecurityXMLLen == FixUtils.TAG_HAS_VALUE) {		
				return securityXMLLen; 		
			} else {		
		
				buf.position(hasSecurityXMLLen);		
		
			securityXMLLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityXMLLen);		
					return 0;		
				}		
			}		
			hasSecurityXMLLen = FixUtils.TAG_HAS_VALUE;		
			return securityXMLLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecurityXMLLen() { return hasSecurityXMLLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityXMLLen(long src) {		
		securityXMLLen = src;
		hasSecurityXMLLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityXMLLen(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityXMLLen()) securityXMLLen = FixUtils.TAG_HAS_NO_VALUE;		
		securityXMLLen = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityXMLLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityXMLLen(String str) {		
		if (str == null ) return;
		if (hasSecurityXMLLen()) securityXMLLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		securityXMLLen = FixUtils.longValueOf(src, 0, src.length);
		hasSecurityXMLLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecurityXML() { 		
		if ( hasSecurityXML()) {		
			if (hasSecurityXML == FixUtils.TAG_HAS_VALUE) {		
				return securityXML; 		
			} else {		
		
				buf.position(hasSecurityXML);		
		
			FixMessage.getTagStringValue(buf, securityXML, 0, securityXML.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityXML);		
					return null;		
				}		
			}		
			hasSecurityXML = FixUtils.TAG_HAS_VALUE;		
			return securityXML;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityXML() { return hasSecurityXML != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityXML(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityXML()) FixUtils.fillNul(securityXML);		
		FixUtils.copy(securityXML, src); 		
		hasSecurityXML = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityXML(String str) {		
		if (str == null ) return;
		if (hasSecurityXML()) FixUtils.fillNul(securityXML);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityXML, src); 		
		hasSecurityXML = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecurityXMLSchema() { 		
		if ( hasSecurityXMLSchema()) {		
			if (hasSecurityXMLSchema == FixUtils.TAG_HAS_VALUE) {		
				return securityXMLSchema; 		
			} else {		
		
				buf.position(hasSecurityXMLSchema);		
		
			FixMessage.getTagStringValue(buf, securityXMLSchema, 0, securityXMLSchema.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityXMLSchema);		
					return null;		
				}		
			}		
			hasSecurityXMLSchema = FixUtils.TAG_HAS_VALUE;		
			return securityXMLSchema;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityXMLSchema() { return hasSecurityXMLSchema != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityXMLSchema(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityXMLSchema()) FixUtils.fillNul(securityXMLSchema);		
		FixUtils.copy(securityXMLSchema, src); 		
		hasSecurityXMLSchema = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityXMLSchema(String str) {		
		if (str == null ) return;
		if (hasSecurityXMLSchema()) FixUtils.fillNul(securityXMLSchema);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityXMLSchema, src); 		
		hasSecurityXMLSchema = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSecurityXMLLen()) s += "SecurityXMLLen(1184)= " + getSecurityXMLLen() + "\n" ; 
		if (hasSecurityXML()) s += "SecurityXML(1185)= " + new String( FixUtils.trim(getSecurityXML()) ) + "\n" ; 
		if (hasSecurityXMLSchema()) s += "SecurityXMLSchema(1186)= " + new String( FixUtils.trim(getSecurityXMLSchema()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSecurityXML)) return false;

		FixSecurityXML msg = (FixSecurityXML) o;

		if ((hasSecurityXMLLen() && !msg.hasSecurityXMLLen()) || (!hasSecurityXMLLen() && msg.hasSecurityXMLLen())) return false;
		if (!(!hasSecurityXMLLen() && !msg.hasSecurityXMLLen()) && !(getSecurityXMLLen()==msg.getSecurityXMLLen())) return false;
		if ((hasSecurityXML() && !msg.hasSecurityXML()) || (!hasSecurityXML() && msg.hasSecurityXML())) return false;
		if (!(!hasSecurityXML() && !msg.hasSecurityXML()) && !FixUtils.equals(getSecurityXML(), msg.getSecurityXML())) return false;
		if ((hasSecurityXMLSchema() && !msg.hasSecurityXMLSchema()) || (!hasSecurityXMLSchema() && msg.hasSecurityXMLSchema())) return false;
		if (!(!hasSecurityXMLSchema() && !msg.hasSecurityXMLSchema()) && !FixUtils.equals(getSecurityXMLSchema(), msg.getSecurityXMLSchema())) return false;
		return true;
	}
	public FixSecurityXML clone ( FixSecurityXML out ) {
		if ( hasSecurityXMLLen())
			out.setSecurityXMLLen(getSecurityXMLLen());
		if ( hasSecurityXML())
			out.setSecurityXML(getSecurityXML());
		if ( hasSecurityXMLSchema())
			out.setSecurityXMLSchema(getSecurityXMLSchema());
		return out;
	}

}
