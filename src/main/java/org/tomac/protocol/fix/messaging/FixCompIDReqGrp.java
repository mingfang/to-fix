package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixCompIDReqGrp extends FixGroup {
	private short hasRefCompID;
	byte[] refCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRefSubID;
	byte[] refSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLocationID;
	byte[] locationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDeskID;
	byte[] deskID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixCompIDReqGrp() {
		super(FixTags.REFCOMPID_INT);

		
		hasRefCompID = FixUtils.TAG_HAS_NO_VALUE;		
		refCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRefSubID = FixUtils.TAG_HAS_NO_VALUE;		
		refSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLocationID = FixUtils.TAG_HAS_NO_VALUE;		
		locationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDeskID = FixUtils.TAG_HAS_NO_VALUE;		
		deskID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRefCompID()) return true;
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
            	case FixTags.REFCOMPID_INT:		
            		hasRefCompID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.REFSUBID_INT:		
            		hasRefSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LOCATIONID_INT:		
            		hasLocationID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DESKID_INT:		
            		hasDeskID = (short) buf.position();		
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
		hasRefCompID = FixUtils.TAG_HAS_NO_VALUE;
		hasRefSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasLocationID = FixUtils.TAG_HAS_NO_VALUE;
		hasDeskID = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRefCompID()) {		
			out.put(FixTags.REFCOMPID);

			out.put((byte) '=');

			FixUtils.put(out,refCompID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRefSubID()) {		
			out.put(FixTags.REFSUBID);

			out.put((byte) '=');

			FixUtils.put(out,refSubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLocationID()) {		
			out.put(FixTags.LOCATIONID);

			out.put((byte) '=');

			FixUtils.put(out,locationID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDeskID()) {		
			out.put(FixTags.DESKID);

			out.put((byte) '=');

			FixUtils.put(out,deskID); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRefCompID()) {		
			FixUtils.put(out,refCompID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefSubID()) {		
			FixUtils.put(out,refSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLocationID()) {		
			FixUtils.put(out,locationID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDeskID()) {		
			FixUtils.put(out,deskID); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getRefCompID() { 		
		if ( hasRefCompID()) {		
			if (hasRefCompID == FixUtils.TAG_HAS_VALUE) {		
				return refCompID; 		
			} else {		
		
				buf.position(hasRefCompID);		
		
			FixMessage.getTagStringValue(buf, refCompID, 0, refCompID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRefCompID);		
					return null;		
				}		
			}		
			hasRefCompID = FixUtils.TAG_HAS_VALUE;		
			return refCompID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefCompID() { return hasRefCompID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefCompID(byte[] src) {		
		if (src == null ) return;
		if (hasRefCompID()) FixUtils.fillSpace(refCompID);		
		FixUtils.copy(refCompID, src); 		
		hasRefCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefCompID(String str) {		
		if (str == null ) return;
		if (hasRefCompID()) FixUtils.fillSpace(refCompID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refCompID, src); 		
		hasRefCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRefSubID() { 		
		if ( hasRefSubID()) {		
			if (hasRefSubID == FixUtils.TAG_HAS_VALUE) {		
				return refSubID; 		
			} else {		
		
				buf.position(hasRefSubID);		
		
			FixMessage.getTagStringValue(buf, refSubID, 0, refSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRefSubID);		
					return null;		
				}		
			}		
			hasRefSubID = FixUtils.TAG_HAS_VALUE;		
			return refSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefSubID() { return hasRefSubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefSubID(byte[] src) {		
		if (src == null ) return;
		if (hasRefSubID()) FixUtils.fillSpace(refSubID);		
		FixUtils.copy(refSubID, src); 		
		hasRefSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefSubID(String str) {		
		if (str == null ) return;
		if (hasRefSubID()) FixUtils.fillSpace(refSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refSubID, src); 		
		hasRefSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLocationID() { 		
		if ( hasLocationID()) {		
			if (hasLocationID == FixUtils.TAG_HAS_VALUE) {		
				return locationID; 		
			} else {		
		
				buf.position(hasLocationID);		
		
			FixMessage.getTagStringValue(buf, locationID, 0, locationID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLocationID);		
					return null;		
				}		
			}		
			hasLocationID = FixUtils.TAG_HAS_VALUE;		
			return locationID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLocationID() { return hasLocationID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLocationID(byte[] src) {		
		if (src == null ) return;
		if (hasLocationID()) FixUtils.fillSpace(locationID);		
		FixUtils.copy(locationID, src); 		
		hasLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLocationID(String str) {		
		if (str == null ) return;
		if (hasLocationID()) FixUtils.fillSpace(locationID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(locationID, src); 		
		hasLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDeskID() { 		
		if ( hasDeskID()) {		
			if (hasDeskID == FixUtils.TAG_HAS_VALUE) {		
				return deskID; 		
			} else {		
		
				buf.position(hasDeskID);		
		
			FixMessage.getTagStringValue(buf, deskID, 0, deskID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDeskID);		
					return null;		
				}		
			}		
			hasDeskID = FixUtils.TAG_HAS_VALUE;		
			return deskID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDeskID() { return hasDeskID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDeskID(byte[] src) {		
		if (src == null ) return;
		if (hasDeskID()) FixUtils.fillSpace(deskID);		
		FixUtils.copy(deskID, src); 		
		hasDeskID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDeskID(String str) {		
		if (str == null ) return;
		if (hasDeskID()) FixUtils.fillSpace(deskID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(deskID, src); 		
		hasDeskID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRefCompID()) s += "RefCompID(930)= " + new String( FixUtils.trim(getRefCompID()) ) + "\n" ; 
		if (hasRefSubID()) s += "RefSubID(931)= " + new String( FixUtils.trim(getRefSubID()) ) + "\n" ; 
		if (hasLocationID()) s += "LocationID(283)= " + new String( FixUtils.trim(getLocationID()) ) + "\n" ; 
		if (hasDeskID()) s += "DeskID(284)= " + new String( FixUtils.trim(getDeskID()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixCompIDReqGrp)) return false;

		FixCompIDReqGrp msg = (FixCompIDReqGrp) o;

		if ((hasRefCompID() && !msg.hasRefCompID()) || (!hasRefCompID() && msg.hasRefCompID())) return false;
		if (!(!hasRefCompID() && !msg.hasRefCompID()) && !FixUtils.equals(getRefCompID(), msg.getRefCompID())) return false;
		if ((hasRefSubID() && !msg.hasRefSubID()) || (!hasRefSubID() && msg.hasRefSubID())) return false;
		if (!(!hasRefSubID() && !msg.hasRefSubID()) && !FixUtils.equals(getRefSubID(), msg.getRefSubID())) return false;
		if ((hasLocationID() && !msg.hasLocationID()) || (!hasLocationID() && msg.hasLocationID())) return false;
		if (!(!hasLocationID() && !msg.hasLocationID()) && !FixUtils.equals(getLocationID(), msg.getLocationID())) return false;
		if ((hasDeskID() && !msg.hasDeskID()) || (!hasDeskID() && msg.hasDeskID())) return false;
		if (!(!hasDeskID() && !msg.hasDeskID()) && !FixUtils.equals(getDeskID(), msg.getDeskID())) return false;
		return true;
	}
	public FixCompIDReqGrp clone ( FixCompIDReqGrp out ) {
		if ( hasRefCompID())
			out.setRefCompID(getRefCompID());
		if ( hasRefSubID())
			out.setRefSubID(getRefSubID());
		if ( hasLocationID())
			out.setLocationID(getLocationID());
		if ( hasDeskID())
			out.setDeskID(getDeskID());
		return out;
	}

}
