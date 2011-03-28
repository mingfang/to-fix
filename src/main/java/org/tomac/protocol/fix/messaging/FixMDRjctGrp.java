package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixMDRjctGrp extends FixGroup {
	private short hasAltMDSourceID;
	byte[] altMDSourceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixMDRjctGrp() {
		super(FixTags.ALTMDSOURCEID_INT);

		
		hasAltMDSourceID = FixUtils.TAG_HAS_NO_VALUE;		
		altMDSourceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasAltMDSourceID()) return true;
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
            	case FixTags.ALTMDSOURCEID_INT:		
            		hasAltMDSourceID = (short) buf.position();		
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
		hasAltMDSourceID = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasAltMDSourceID()) {		
			out.put(FixTags.ALTMDSOURCEID);

			out.put((byte) '=');

			FixUtils.put(out,altMDSourceID); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasAltMDSourceID()) {		
			FixUtils.put(out,altMDSourceID); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getAltMDSourceID() { 		
		if ( hasAltMDSourceID()) {		
			if (hasAltMDSourceID == FixUtils.TAG_HAS_VALUE) {		
				return altMDSourceID; 		
			} else {		
		
				buf.position(hasAltMDSourceID);		
		
			FixMessage.getTagStringValue(buf, altMDSourceID, 0, altMDSourceID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAltMDSourceID);		
					return null;		
				}		
			}		
			hasAltMDSourceID = FixUtils.TAG_HAS_VALUE;		
			return altMDSourceID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAltMDSourceID() { return hasAltMDSourceID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAltMDSourceID(byte[] src) {		
		if (src == null ) return;
		if (hasAltMDSourceID()) FixUtils.fillSpace(altMDSourceID);		
		FixUtils.copy(altMDSourceID, src); 		
		hasAltMDSourceID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAltMDSourceID(String str) {		
		if (str == null ) return;
		if (hasAltMDSourceID()) FixUtils.fillSpace(altMDSourceID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(altMDSourceID, src); 		
		hasAltMDSourceID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasAltMDSourceID()) s += "AltMDSourceID(817)= " + new String( FixUtils.trim(getAltMDSourceID()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixMDRjctGrp)) return false;

		FixMDRjctGrp msg = (FixMDRjctGrp) o;

		if ((hasAltMDSourceID() && !msg.hasAltMDSourceID()) || (!hasAltMDSourceID() && msg.hasAltMDSourceID())) return false;
		if (!(!hasAltMDSourceID() && !msg.hasAltMDSourceID()) && !FixUtils.equals(getAltMDSourceID(), msg.getAltMDSourceID())) return false;
		return true;
	}
	public FixMDRjctGrp clone ( FixMDRjctGrp out ) {
		if ( hasAltMDSourceID())
			out.setAltMDSourceID(getAltMDSourceID());
		return out;
	}

}
