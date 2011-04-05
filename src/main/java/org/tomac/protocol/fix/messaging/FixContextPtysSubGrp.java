package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixContextPtysSubGrp extends FixGroup {
	private short hasContextPartySubID;
	byte[] contextPartySubID = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasContextPartySubIDType;
	long contextPartySubIDType = 0;		
	
	public FixContextPtysSubGrp() {
		this(false);
	}

	public FixContextPtysSubGrp(boolean isRequired) {
		super(FixTags.CONTEXTPARTYSUBID_INT);

		this.isRequired = isRequired;
		
		hasContextPartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		contextPartySubID = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasContextPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasContextPartySubID()) return true;
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
            	case FixTags.CONTEXTPARTYSUBID_INT:		
            		hasContextPartySubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CONTEXTPARTYSUBIDTYPE_INT:		
            		hasContextPartySubIDType = (short) buf.position();		
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
		hasContextPartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasContextPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasContextPartySubID()) {		
			out.put(FixTags.CONTEXTPARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,contextPartySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasContextPartySubIDType()) {		
			out.put(FixTags.CONTEXTPARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)contextPartySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasContextPartySubID()) {		
			FixUtils.put(out,contextPartySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContextPartySubIDType()) {		
			FixUtils.put(out, (long)contextPartySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getContextPartySubID() { 		
		if ( hasContextPartySubID()) {		
			if (hasContextPartySubID == FixUtils.TAG_HAS_VALUE) {		
				return contextPartySubID; 		
			} else {		
		
				buf.position(hasContextPartySubID);		
		
			FixMessage.getTagStringValue(buf, contextPartySubID, 0, contextPartySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasContextPartySubID);		
					return null;		
				}		
			}		
			hasContextPartySubID = FixUtils.TAG_HAS_VALUE;		
			return contextPartySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasContextPartySubID() { return hasContextPartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContextPartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasContextPartySubID()) FixUtils.fillNul(contextPartySubID);		
		FixUtils.copy(contextPartySubID, src); 		
		hasContextPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContextPartySubID(String str) {		
		if (str == null ) return;
		if (hasContextPartySubID()) FixUtils.fillNul(contextPartySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(contextPartySubID, src); 		
		hasContextPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getContextPartySubIDType() { 		
		if ( hasContextPartySubIDType()) {		
			if (hasContextPartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return contextPartySubIDType; 		
			} else {		
		
				buf.position(hasContextPartySubIDType);		
		
			contextPartySubIDType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasContextPartySubIDType);		
					return 0;		
				}		
			}		
			hasContextPartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return contextPartySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasContextPartySubIDType() { return hasContextPartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContextPartySubIDType(long src) {		
		contextPartySubIDType = src;
		hasContextPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContextPartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasContextPartySubIDType()) contextPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		contextPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasContextPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContextPartySubIDType(String str) {		
		if (str == null ) return;
		if (hasContextPartySubIDType()) contextPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		contextPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasContextPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasContextPartySubID()) s += "ContextPartySubID(1527)= " + new String( FixUtils.trim(getContextPartySubID()) ) + "\n" ; 
		if (hasContextPartySubIDType()) s += "ContextPartySubIDType(1528)= " + getContextPartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixContextPtysSubGrp)) return false;

		FixContextPtysSubGrp msg = (FixContextPtysSubGrp) o;

		if ((hasContextPartySubID() && !msg.hasContextPartySubID()) || (!hasContextPartySubID() && msg.hasContextPartySubID())) return false;
		if (!(!hasContextPartySubID() && !msg.hasContextPartySubID()) && !FixUtils.equals(getContextPartySubID(), msg.getContextPartySubID())) return false;
		if ((hasContextPartySubIDType() && !msg.hasContextPartySubIDType()) || (!hasContextPartySubIDType() && msg.hasContextPartySubIDType())) return false;
		if (!(!hasContextPartySubIDType() && !msg.hasContextPartySubIDType()) && !(getContextPartySubIDType()==msg.getContextPartySubIDType())) return false;
		return true;
	}
	public FixContextPtysSubGrp clone ( FixContextPtysSubGrp out ) {
		if ( hasContextPartySubID())
			out.setContextPartySubID(getContextPartySubID());
		if ( hasContextPartySubIDType())
			out.setContextPartySubIDType(getContextPartySubIDType());
		return out;
	}

}
