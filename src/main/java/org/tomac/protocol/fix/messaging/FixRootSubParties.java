package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRootSubParties extends FixGroup {
	private short hasRootPartySubID;
	byte[] rootPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRootPartySubIDType;
	long rootPartySubIDType = 0;		
	
	public FixRootSubParties() {
		this(false);
	}

	public FixRootSubParties(boolean isRequired) {
		super(FixTags.ROOTPARTYSUBID_INT);

		this.isRequired = isRequired;
		
		hasRootPartySubID = FixUtils.TAG_HAS_NO_VALUE;		
		rootPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRootPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRootPartySubID()) return true;
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
            	case FixTags.ROOTPARTYSUBID_INT:		
            		hasRootPartySubID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ROOTPARTYSUBIDTYPE_INT:		
            		hasRootPartySubIDType = (short) buf.position();		
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
		hasRootPartySubID = FixUtils.TAG_HAS_NO_VALUE;
		hasRootPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRootPartySubID()) {		
			out.put(FixTags.ROOTPARTYSUBID);

			out.put((byte) '=');

			FixUtils.put(out,rootPartySubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRootPartySubIDType()) {		
			out.put(FixTags.ROOTPARTYSUBIDTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)rootPartySubIDType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRootPartySubID()) {		
			FixUtils.put(out,rootPartySubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRootPartySubIDType()) {		
			FixUtils.put(out, (long)rootPartySubIDType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getRootPartySubID() { 		
		if ( hasRootPartySubID()) {		
			if (hasRootPartySubID == FixUtils.TAG_HAS_VALUE) {		
				return rootPartySubID; 		
			} else {		
		
				buf.position(hasRootPartySubID);		
		
			FixUtils.getTagStringValue(buf, rootPartySubID, 0, rootPartySubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRootPartySubID);		
					return null;		
				}		
			}		
			hasRootPartySubID = FixUtils.TAG_HAS_VALUE;		
			return rootPartySubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRootPartySubID() { return hasRootPartySubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRootPartySubID(byte[] src) {		
		if (src == null ) return;
		if (hasRootPartySubID()) FixUtils.fillNul(rootPartySubID);		
		FixUtils.copy(rootPartySubID, src); 		
		hasRootPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRootPartySubID(String str) {		
		if (str == null ) return;
		if (hasRootPartySubID()) FixUtils.fillNul(rootPartySubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(rootPartySubID, src); 		
		hasRootPartySubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRootPartySubIDType() { 		
		if ( hasRootPartySubIDType()) {		
			if (hasRootPartySubIDType == FixUtils.TAG_HAS_VALUE) {		
				return rootPartySubIDType; 		
			} else {		
		
				buf.position(hasRootPartySubIDType);		
		
			rootPartySubIDType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRootPartySubIDType);		
					return 0;		
				}		
			}		
			hasRootPartySubIDType = FixUtils.TAG_HAS_VALUE;		
			return rootPartySubIDType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRootPartySubIDType() { return hasRootPartySubIDType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRootPartySubIDType(long src) {		
		rootPartySubIDType = src;
		hasRootPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRootPartySubIDType(byte[] src) {		
		if (src == null ) return;
		if (hasRootPartySubIDType()) rootPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		rootPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasRootPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRootPartySubIDType(String str) {		
		if (str == null ) return;
		if (hasRootPartySubIDType()) rootPartySubIDType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		rootPartySubIDType = FixUtils.longValueOf(src, 0, src.length);
		hasRootPartySubIDType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRootPartySubID()) s += "RootPartySubID(1121)= " + new String( FixUtils.trim(getRootPartySubID()) ) + "\n" ; 
		if (hasRootPartySubIDType()) s += "RootPartySubIDType(1122)= " + getRootPartySubIDType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRootSubParties)) return false;

		FixRootSubParties msg = (FixRootSubParties) o;

		if ((hasRootPartySubID() && !msg.hasRootPartySubID()) || (!hasRootPartySubID() && msg.hasRootPartySubID())) return false;
		if (!(!hasRootPartySubID() && !msg.hasRootPartySubID()) && !FixUtils.equals(getRootPartySubID(), msg.getRootPartySubID())) return false;
		if ((hasRootPartySubIDType() && !msg.hasRootPartySubIDType()) || (!hasRootPartySubIDType() && msg.hasRootPartySubIDType())) return false;
		if (!(!hasRootPartySubIDType() && !msg.hasRootPartySubIDType()) && !(getRootPartySubIDType()==msg.getRootPartySubIDType())) return false;
		return true;
	}
	public FixRootSubParties clone ( FixRootSubParties out ) {
		if ( hasRootPartySubID())
			out.setRootPartySubID(getRootPartySubID());
		if ( hasRootPartySubIDType())
			out.setRootPartySubIDType(getRootPartySubIDType());
		return out;
	}

}
