package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixInstrumentPtysSubGrp extends FixGroup {
	private short hasInstrumentPartySubID;
	byte[] instrumentPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasInstrumentPartySubIDType;
	long instrumentPartySubIDType = 0;		
	
	public FixInstrumentPtysSubGrp() {
		this(false);
	}

	public FixInstrumentPtysSubGrp(boolean isRequired) {
		super(FixTags.INSTRUMENTPARTYSUBID_INT);

		this.isRequired = isRequired;
		
		hasInstrumentPartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		instrumentPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasInstrumentPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasInstrumentPartySubID()) return true;
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
            	case FixTags.INSTRUMENTPARTYSUBID_INT:		
            		hasInstrumentPartySubID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.INSTRUMENTPARTYSUBIDTYPE_INT:		
            		hasInstrumentPartySubIDType = (short) buf.position();		
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
		hasInstrumentPartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasInstrumentPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasInstrumentPartySubID()) {		
			out.put(FixTags.INSTRUMENTPARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,instrumentPartySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasInstrumentPartySubIDType()) {		
			out.put(FixTags.INSTRUMENTPARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)instrumentPartySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasInstrumentPartySubID()) {		
			FixUtils.put(out,instrumentPartySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasInstrumentPartySubIDType()) {		
			FixUtils.put(out, (long)instrumentPartySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getInstrumentPartySubID() { 		
		if ( hasInstrumentPartySubID()) {		
			if (hasInstrumentPartySubID == FixUtils.TAG_HAS_VALUE) {		
				return instrumentPartySubID; 		
			} else {		
		
				buf.position(hasInstrumentPartySubID);		
		
			FixUtils.getTagStringValue(buf, instrumentPartySubID, 0, instrumentPartySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasInstrumentPartySubID);		
					return null;		
				}		
			}		
			hasInstrumentPartySubID = FixUtils.TAG_HAS_VALUE;		
			return instrumentPartySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasInstrumentPartySubID() { return hasInstrumentPartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setInstrumentPartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasInstrumentPartySubID()) FixUtils.fillNul(instrumentPartySubID);		
		FixUtils.copy(instrumentPartySubID, src); 		
		hasInstrumentPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setInstrumentPartySubID(String str) {		
		if (str == null ) return;
		if (hasInstrumentPartySubID()) FixUtils.fillNul(instrumentPartySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(instrumentPartySubID, src); 		
		hasInstrumentPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getInstrumentPartySubIDType() { 		
		if ( hasInstrumentPartySubIDType()) {		
			if (hasInstrumentPartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return instrumentPartySubIDType; 		
			} else {		
		
				buf.position(hasInstrumentPartySubIDType);		
		
			instrumentPartySubIDType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasInstrumentPartySubIDType);		
					return 0;		
				}		
			}		
			hasInstrumentPartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return instrumentPartySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasInstrumentPartySubIDType() { return hasInstrumentPartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setInstrumentPartySubIDType(long src) {		
		instrumentPartySubIDType = src;
		hasInstrumentPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setInstrumentPartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasInstrumentPartySubIDType()) instrumentPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		instrumentPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasInstrumentPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setInstrumentPartySubIDType(String str) {		
		if (str == null ) return;
		if (hasInstrumentPartySubIDType()) instrumentPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		instrumentPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasInstrumentPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasInstrumentPartySubID()) s += "InstrumentPartySubID(1053)= " + new String( FixUtils.trim(getInstrumentPartySubID()) ) + "\n" ; 
		if (hasInstrumentPartySubIDType()) s += "InstrumentPartySubIDType(1054)= " + getInstrumentPartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrumentPtysSubGrp)) return false;

		FixInstrumentPtysSubGrp msg = (FixInstrumentPtysSubGrp) o;

		if ((hasInstrumentPartySubID() && !msg.hasInstrumentPartySubID()) || (!hasInstrumentPartySubID() && msg.hasInstrumentPartySubID())) return false;
		if (!(!hasInstrumentPartySubID() && !msg.hasInstrumentPartySubID()) && !FixUtils.equals(getInstrumentPartySubID(), msg.getInstrumentPartySubID())) return false;
		if ((hasInstrumentPartySubIDType() && !msg.hasInstrumentPartySubIDType()) || (!hasInstrumentPartySubIDType() && msg.hasInstrumentPartySubIDType())) return false;
		if (!(!hasInstrumentPartySubIDType() && !msg.hasInstrumentPartySubIDType()) && !(getInstrumentPartySubIDType()==msg.getInstrumentPartySubIDType())) return false;
		return true;
	}
	public FixInstrumentPtysSubGrp clone ( FixInstrumentPtysSubGrp out ) {
		if ( hasInstrumentPartySubID())
			out.setInstrumentPartySubID(getInstrumentPartySubID());
		if ( hasInstrumentPartySubIDType())
			out.setInstrumentPartySubIDType(getInstrumentPartySubIDType());
		return out;
	}

}
