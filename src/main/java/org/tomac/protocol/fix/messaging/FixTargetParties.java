package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTargetParties extends FixGroup {
	private short hasTargetPartyID;
	byte[] targetPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTargetPartyIDSource;
	byte targetPartyIDSource = (byte)' ';		
	private short hasTargetPartyRole;
	long targetPartyRole = 0;		
	
	public FixTargetParties() {
		super(FixTags.TARGETPARTYID_INT);

		
		hasTargetPartyID = FixUtils.TAG_HAS_NO_VALUE;		
		targetPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTargetPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasTargetPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasTargetPartyID()) return true;
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
            	case FixTags.TARGETPARTYID_INT:		
            		hasTargetPartyID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TARGETPARTYIDSOURCE_INT:		
            		hasTargetPartyIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TARGETPARTYROLE_INT:		
            		hasTargetPartyRole = (short) buf.position();		
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
		hasTargetPartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasTargetPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasTargetPartyRole = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasTargetPartyID()) {		
			out.put(FixTags.TARGETPARTYID);

			out.put((byte) '=');

			FixUtils.put(out,targetPartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTargetPartyIDSource()) {		
			out.put(FixTags.TARGETPARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,targetPartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTargetPartyRole()) {		
			out.put(FixTags.TARGETPARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)targetPartyRole);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasTargetPartyID()) {		
			FixUtils.put(out,targetPartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTargetPartyIDSource()) {		
			FixUtils.put(out,targetPartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTargetPartyRole()) {		
			FixUtils.put(out, (long)targetPartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getTargetPartyID() { 		
		if ( hasTargetPartyID()) {		
			if (hasTargetPartyID == FixUtils.TAG_HAS_VALUE) {		
				return targetPartyID; 		
			} else {		
		
				buf.position(hasTargetPartyID);		
		
			FixMessage.getTagStringValue(buf, targetPartyID, 0, targetPartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTargetPartyID);		
					return null;		
				}		
			}		
			hasTargetPartyID = FixUtils.TAG_HAS_VALUE;		
			return targetPartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTargetPartyID() { return hasTargetPartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTargetPartyID(byte[] src) {		
		if (src == null ) return;
		if (hasTargetPartyID()) FixUtils.fillSpace(targetPartyID);		
		FixUtils.copy(targetPartyID, src); 		
		hasTargetPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTargetPartyID(String str) {		
		if (str == null ) return;
		if (hasTargetPartyID()) FixUtils.fillSpace(targetPartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(targetPartyID, src); 		
		hasTargetPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getTargetPartyIDSource() { 		
		if ( hasTargetPartyIDSource()) {		
			if (hasTargetPartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return targetPartyIDSource; 		
			} else {		
		
				buf.position(hasTargetPartyIDSource);		
		
			targetPartyIDSource = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTargetPartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasTargetPartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return targetPartyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTargetPartyIDSource() { return hasTargetPartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTargetPartyIDSource(byte src) {		
		targetPartyIDSource = src;
		hasTargetPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTargetPartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasTargetPartyIDSource()) targetPartyIDSource = (byte)' ';		
		targetPartyIDSource = src[0];		
		hasTargetPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTargetPartyIDSource(String str) {		
		if (str == null ) return;
		if (hasTargetPartyIDSource()) targetPartyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		targetPartyIDSource = src[0];		
		hasTargetPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTargetPartyRole() { 		
		if ( hasTargetPartyRole()) {		
			if (hasTargetPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return targetPartyRole; 		
			} else {		
		
				buf.position(hasTargetPartyRole);		
		
			targetPartyRole = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTargetPartyRole);		
					return 0;		
				}		
			}		
			hasTargetPartyRole = FixUtils.TAG_HAS_VALUE;		
			return targetPartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTargetPartyRole() { return hasTargetPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTargetPartyRole(long src) {		
		targetPartyRole = src;
		hasTargetPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTargetPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasTargetPartyRole()) targetPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		targetPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasTargetPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTargetPartyRole(String str) {		
		if (str == null ) return;
		if (hasTargetPartyRole()) targetPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		targetPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasTargetPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasTargetPartyID()) s += "TargetPartyID(1462)= " + new String( FixUtils.trim(getTargetPartyID()) ) + "\n" ; 
		if (hasTargetPartyIDSource()) s += "TargetPartyIDSource(1463)= " + getTargetPartyIDSource() + "\n" ; 
		if (hasTargetPartyRole()) s += "TargetPartyRole(1464)= " + getTargetPartyRole() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTargetParties)) return false;

		FixTargetParties msg = (FixTargetParties) o;

		if ((hasTargetPartyID() && !msg.hasTargetPartyID()) || (!hasTargetPartyID() && msg.hasTargetPartyID())) return false;
		if (!(!hasTargetPartyID() && !msg.hasTargetPartyID()) && !FixUtils.equals(getTargetPartyID(), msg.getTargetPartyID())) return false;
		if ((hasTargetPartyIDSource() && !msg.hasTargetPartyIDSource()) || (!hasTargetPartyIDSource() && msg.hasTargetPartyIDSource())) return false;
		if (!(!hasTargetPartyIDSource() && !msg.hasTargetPartyIDSource()) && !(getTargetPartyIDSource()==msg.getTargetPartyIDSource())) return false;
		if ((hasTargetPartyRole() && !msg.hasTargetPartyRole()) || (!hasTargetPartyRole() && msg.hasTargetPartyRole())) return false;
		if (!(!hasTargetPartyRole() && !msg.hasTargetPartyRole()) && !(getTargetPartyRole()==msg.getTargetPartyRole())) return false;
		return true;
	}
	public FixTargetParties clone ( FixTargetParties out ) {
		if ( hasTargetPartyID())
			out.setTargetPartyID(getTargetPartyID());
		if ( hasTargetPartyIDSource())
			out.setTargetPartyIDSource(getTargetPartyIDSource());
		if ( hasTargetPartyRole())
			out.setTargetPartyRole(getTargetPartyRole());
		return out;
	}

}
