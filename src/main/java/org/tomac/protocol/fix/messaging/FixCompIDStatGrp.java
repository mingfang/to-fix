package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixCompIDStatGrp extends FixGroup {
	private short hasRefCompID;
	byte[] refCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRefSubID;
	byte[] refSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLocationID;
	byte[] locationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDeskID;
	byte[] deskID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasStatusValue;
	long statusValue = 0;		
	private short hasStatusText;
	byte[] statusText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	
	public FixCompIDStatGrp() {
		this(false);
	}

	public FixCompIDStatGrp(boolean isRequired) {
		super(FixTags.REFCOMPID_INT);

		this.isRequired = isRequired;
		
		hasRefCompID = FixUtils.TAG_HAS_NO_VALUE;		
		refCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRefSubID = FixUtils.TAG_HAS_NO_VALUE;		
		refSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLocationID = FixUtils.TAG_HAS_NO_VALUE;		
		locationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDeskID = FixUtils.TAG_HAS_NO_VALUE;		
		deskID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasStatusValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasStatusText = FixUtils.TAG_HAS_NO_VALUE;		
		statusText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		
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
            	case FixTags.STATUSVALUE_INT:		
            		hasStatusValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STATUSTEXT_INT:		
            		hasStatusText = (short) buf.position();		
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
		if (!hasRefCompID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag RefCompID missing", FixTags.REFCOMPID_INT);
			return false;
		}
		if (!hasStatusValue()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag StatusValue missing", FixTags.STATUSVALUE_INT);
			return false;
		}
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasRefCompID = FixUtils.TAG_HAS_NO_VALUE;
		hasRefSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasLocationID = FixUtils.TAG_HAS_NO_VALUE;
		hasDeskID = FixUtils.TAG_HAS_NO_VALUE;
		hasStatusValue = FixUtils.TAG_HAS_NO_VALUE;
		hasStatusText = FixUtils.TAG_HAS_NO_VALUE;
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

		if (hasStatusValue()) {		
			out.put(FixTags.STATUSVALUE);

			out.put((byte) '=');

			FixUtils.put(out, (long)statusValue);
		
			out.put(FixUtils.SOH);

            }

		if (hasStatusText()) {		
			out.put(FixTags.STATUSTEXT);

			out.put((byte) '=');

			FixUtils.put(out,statusText); 		
		
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
		
		if (hasStatusValue()) {		
			FixUtils.put(out, (long)statusValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStatusText()) {		
			FixUtils.put(out,statusText); 		
		
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
		if (hasRefCompID()) FixUtils.fillNul(refCompID);		
		FixUtils.copy(refCompID, src); 		
		hasRefCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefCompID(String str) {		
		if (str == null ) return;
		if (hasRefCompID()) FixUtils.fillNul(refCompID);		
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
		if (hasRefSubID()) FixUtils.fillNul(refSubID);		
		FixUtils.copy(refSubID, src); 		
		hasRefSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefSubID(String str) {		
		if (str == null ) return;
		if (hasRefSubID()) FixUtils.fillNul(refSubID);		
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
		if (hasLocationID()) FixUtils.fillNul(locationID);		
		FixUtils.copy(locationID, src); 		
		hasLocationID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLocationID(String str) {		
		if (str == null ) return;
		if (hasLocationID()) FixUtils.fillNul(locationID);		
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
		if (hasDeskID()) FixUtils.fillNul(deskID);		
		FixUtils.copy(deskID, src); 		
		hasDeskID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDeskID(String str) {		
		if (str == null ) return;
		if (hasDeskID()) FixUtils.fillNul(deskID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(deskID, src); 		
		hasDeskID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStatusValue() { 		
		if ( hasStatusValue()) {		
			if (hasStatusValue == FixUtils.TAG_HAS_VALUE) {		
				return statusValue; 		
			} else {		
		
				buf.position(hasStatusValue);		
		
			statusValue = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStatusValue);		
					return 0;		
				}		
			}		
			hasStatusValue = FixUtils.TAG_HAS_VALUE;		
			return statusValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStatusValue() { return hasStatusValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStatusValue(long src) {		
		statusValue = src;
		hasStatusValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStatusValue(byte[] src) {		
		if (src == null ) return;
		if (hasStatusValue()) statusValue = FixUtils.TAG_HAS_NO_VALUE;		
		statusValue = FixUtils.longValueOf(src, 0, src.length);
		hasStatusValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStatusValue(String str) {		
		if (str == null ) return;
		if (hasStatusValue()) statusValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		statusValue = FixUtils.longValueOf(src, 0, src.length);
		hasStatusValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getStatusText() { 		
		if ( hasStatusText()) {		
			if (hasStatusText == FixUtils.TAG_HAS_VALUE) {		
				return statusText; 		
			} else {		
		
				buf.position(hasStatusText);		
		
			FixMessage.getTagStringValue(buf, statusText, 0, statusText.length, err);
		
				if (err.hasError()) {		
					buf.position(hasStatusText);		
					return null;		
				}		
			}		
			hasStatusText = FixUtils.TAG_HAS_VALUE;		
			return statusText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStatusText() { return hasStatusText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStatusText(byte[] src) {		
		if (src == null ) return;
		if (hasStatusText()) FixUtils.fillNul(statusText);		
		FixUtils.copy(statusText, src); 		
		hasStatusText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStatusText(String str) {		
		if (str == null ) return;
		if (hasStatusText()) FixUtils.fillNul(statusText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(statusText, src); 		
		hasStatusText = FixUtils.TAG_HAS_VALUE;		
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
		if (hasStatusValue()) s += "StatusValue(928)= " + getStatusValue() + "\n" ; 
		if (hasStatusText()) s += "StatusText(929)= " + new String( FixUtils.trim(getStatusText()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixCompIDStatGrp)) return false;

		FixCompIDStatGrp msg = (FixCompIDStatGrp) o;

		if ((hasRefCompID() && !msg.hasRefCompID()) || (!hasRefCompID() && msg.hasRefCompID())) return false;
		if (!(!hasRefCompID() && !msg.hasRefCompID()) && !FixUtils.equals(getRefCompID(), msg.getRefCompID())) return false;
		if ((hasRefSubID() && !msg.hasRefSubID()) || (!hasRefSubID() && msg.hasRefSubID())) return false;
		if (!(!hasRefSubID() && !msg.hasRefSubID()) && !FixUtils.equals(getRefSubID(), msg.getRefSubID())) return false;
		if ((hasLocationID() && !msg.hasLocationID()) || (!hasLocationID() && msg.hasLocationID())) return false;
		if (!(!hasLocationID() && !msg.hasLocationID()) && !FixUtils.equals(getLocationID(), msg.getLocationID())) return false;
		if ((hasDeskID() && !msg.hasDeskID()) || (!hasDeskID() && msg.hasDeskID())) return false;
		if (!(!hasDeskID() && !msg.hasDeskID()) && !FixUtils.equals(getDeskID(), msg.getDeskID())) return false;
		if ((hasStatusValue() && !msg.hasStatusValue()) || (!hasStatusValue() && msg.hasStatusValue())) return false;
		if (!(!hasStatusValue() && !msg.hasStatusValue()) && !(getStatusValue()==msg.getStatusValue())) return false;
		if ((hasStatusText() && !msg.hasStatusText()) || (!hasStatusText() && msg.hasStatusText())) return false;
		if (!(!hasStatusText() && !msg.hasStatusText()) && !FixUtils.equals(getStatusText(), msg.getStatusText())) return false;
		return true;
	}
	public FixCompIDStatGrp clone ( FixCompIDStatGrp out ) {
		if ( hasRefCompID())
			out.setRefCompID(getRefCompID());
		if ( hasRefSubID())
			out.setRefSubID(getRefSubID());
		if ( hasLocationID())
			out.setLocationID(getLocationID());
		if ( hasDeskID())
			out.setDeskID(getDeskID());
		if ( hasStatusValue())
			out.setStatusValue(getStatusValue());
		if ( hasStatusText())
			out.setStatusText(getStatusText());
		return out;
	}

}
