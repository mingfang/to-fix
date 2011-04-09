package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixAffectedOrdGrp extends FixGroup {
	private short hasOrigClOrdID;
	byte[] origClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAffectedOrderID;
	byte[] affectedOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAffectedSecondaryOrderID;
	byte[] affectedSecondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixAffectedOrdGrp() {
		this(false);
	}

	public FixAffectedOrdGrp(boolean isRequired) {
		super(FixTags.ORIGCLORDID_INT);

		this.isRequired = isRequired;
		
		hasOrigClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		origClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAffectedOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		affectedOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAffectedSecondaryOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		affectedSecondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasOrigClOrdID()) return true;
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
            	case FixTags.ORIGCLORDID_INT:		
            		hasOrigClOrdID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.AFFECTEDORDERID_INT:		
            		hasAffectedOrderID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.AFFECTEDSECONDARYORDERID_INT:		
            		hasAffectedSecondaryOrderID = (short) buf.position();		
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
		hasOrigClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasAffectedOrderID = FixUtils.TAG_HAS_NO_VALUE;
		hasAffectedSecondaryOrderID = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasOrigClOrdID()) {		
			out.put(FixTags.ORIGCLORDID);

			out.put((byte) '=');

			FixUtils.put(out,origClOrdID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAffectedOrderID()) {		
			out.put(FixTags.AFFECTEDORDERID);

			out.put((byte) '=');

			FixUtils.put(out,affectedOrderID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAffectedSecondaryOrderID()) {		
			out.put(FixTags.AFFECTEDSECONDARYORDERID);

			out.put((byte) '=');

			FixUtils.put(out,affectedSecondaryOrderID); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasOrigClOrdID()) {		
			FixUtils.put(out,origClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAffectedOrderID()) {		
			FixUtils.put(out,affectedOrderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAffectedSecondaryOrderID()) {		
			FixUtils.put(out,affectedSecondaryOrderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getOrigClOrdID() { 		
		if ( hasOrigClOrdID()) {		
			if (hasOrigClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return origClOrdID; 		
			} else {		
		
				buf.position(hasOrigClOrdID);		
		
			FixUtils.getTagStringValue(buf, origClOrdID, 0, origClOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOrigClOrdID);		
					return null;		
				}		
			}		
			hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
			return origClOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigClOrdID() { return hasOrigClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrigClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasOrigClOrdID()) FixUtils.fillNul(origClOrdID);		
		FixUtils.copy(origClOrdID, src); 		
		hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrigClOrdID(String str) {		
		if (str == null ) return;
		if (hasOrigClOrdID()) FixUtils.fillNul(origClOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origClOrdID, src); 		
		hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getAffectedOrderID() { 		
		if ( hasAffectedOrderID()) {		
			if (hasAffectedOrderID == FixUtils.TAG_HAS_VALUE) {		
				return affectedOrderID; 		
			} else {		
		
				buf.position(hasAffectedOrderID);		
		
			FixUtils.getTagStringValue(buf, affectedOrderID, 0, affectedOrderID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAffectedOrderID);		
					return null;		
				}		
			}		
			hasAffectedOrderID = FixUtils.TAG_HAS_VALUE;		
			return affectedOrderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAffectedOrderID() { return hasAffectedOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAffectedOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasAffectedOrderID()) FixUtils.fillNul(affectedOrderID);		
		FixUtils.copy(affectedOrderID, src); 		
		hasAffectedOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAffectedOrderID(String str) {		
		if (str == null ) return;
		if (hasAffectedOrderID()) FixUtils.fillNul(affectedOrderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(affectedOrderID, src); 		
		hasAffectedOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getAffectedSecondaryOrderID() { 		
		if ( hasAffectedSecondaryOrderID()) {		
			if (hasAffectedSecondaryOrderID == FixUtils.TAG_HAS_VALUE) {		
				return affectedSecondaryOrderID; 		
			} else {		
		
				buf.position(hasAffectedSecondaryOrderID);		
		
			FixUtils.getTagStringValue(buf, affectedSecondaryOrderID, 0, affectedSecondaryOrderID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAffectedSecondaryOrderID);		
					return null;		
				}		
			}		
			hasAffectedSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
			return affectedSecondaryOrderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAffectedSecondaryOrderID() { return hasAffectedSecondaryOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAffectedSecondaryOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasAffectedSecondaryOrderID()) FixUtils.fillNul(affectedSecondaryOrderID);		
		FixUtils.copy(affectedSecondaryOrderID, src); 		
		hasAffectedSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAffectedSecondaryOrderID(String str) {		
		if (str == null ) return;
		if (hasAffectedSecondaryOrderID()) FixUtils.fillNul(affectedSecondaryOrderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(affectedSecondaryOrderID, src); 		
		hasAffectedSecondaryOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasOrigClOrdID()) s += "OrigClOrdID(41)= " + new String( FixUtils.trim(getOrigClOrdID()) ) + "\n" ; 
		if (hasAffectedOrderID()) s += "AffectedOrderID(535)= " + new String( FixUtils.trim(getAffectedOrderID()) ) + "\n" ; 
		if (hasAffectedSecondaryOrderID()) s += "AffectedSecondaryOrderID(536)= " + new String( FixUtils.trim(getAffectedSecondaryOrderID()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixAffectedOrdGrp)) return false;

		FixAffectedOrdGrp msg = (FixAffectedOrdGrp) o;

		if ((hasOrigClOrdID() && !msg.hasOrigClOrdID()) || (!hasOrigClOrdID() && msg.hasOrigClOrdID())) return false;
		if (!(!hasOrigClOrdID() && !msg.hasOrigClOrdID()) && !FixUtils.equals(getOrigClOrdID(), msg.getOrigClOrdID())) return false;
		if ((hasAffectedOrderID() && !msg.hasAffectedOrderID()) || (!hasAffectedOrderID() && msg.hasAffectedOrderID())) return false;
		if (!(!hasAffectedOrderID() && !msg.hasAffectedOrderID()) && !FixUtils.equals(getAffectedOrderID(), msg.getAffectedOrderID())) return false;
		if ((hasAffectedSecondaryOrderID() && !msg.hasAffectedSecondaryOrderID()) || (!hasAffectedSecondaryOrderID() && msg.hasAffectedSecondaryOrderID())) return false;
		if (!(!hasAffectedSecondaryOrderID() && !msg.hasAffectedSecondaryOrderID()) && !FixUtils.equals(getAffectedSecondaryOrderID(), msg.getAffectedSecondaryOrderID())) return false;
		return true;
	}
	public FixAffectedOrdGrp clone ( FixAffectedOrdGrp out ) {
		if ( hasOrigClOrdID())
			out.setOrigClOrdID(getOrigClOrdID());
		if ( hasAffectedOrderID())
			out.setAffectedOrderID(getAffectedOrderID());
		if ( hasAffectedSecondaryOrderID())
			out.setAffectedSecondaryOrderID(getAffectedSecondaryOrderID());
		return out;
	}

}
