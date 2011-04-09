package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixHopGrp extends FixGroup {
	private short hasHopCompID;
	byte[] hopCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasHopSendingTime;
	byte[] hopSendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasHopRefID;
	long hopRefID = 0;		
	
	public FixHopGrp() {
		this(false);
	}

	public FixHopGrp(boolean isRequired) {
		super(FixTags.HOPCOMPID_INT);

		this.isRequired = isRequired;
		
		hasHopCompID = FixUtils.TAG_HAS_NO_VALUE;		
		hopCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasHopSendingTime = FixUtils.TAG_HAS_NO_VALUE;		
		hopSendingTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasHopRefID = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasHopCompID()) return true;
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
            	case FixTags.HOPCOMPID_INT:		
            		hasHopCompID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.HOPSENDINGTIME_INT:		
            		hasHopSendingTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.HOPREFID_INT:		
            		hasHopRefID = (short) buf.position();		
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
		hasHopCompID = FixUtils.TAG_HAS_NO_VALUE;
		hasHopSendingTime = FixUtils.TAG_HAS_NO_VALUE;
		hasHopRefID = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasHopCompID()) {		
			out.put(FixTags.HOPCOMPID);

			out.put((byte) '=');

			FixUtils.put(out,hopCompID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasHopSendingTime()) {		
			out.put(FixTags.HOPSENDINGTIME);

			out.put((byte) '=');

			FixUtils.put(out,hopSendingTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasHopRefID()) {		
			out.put(FixTags.HOPREFID);

			out.put((byte) '=');

			FixUtils.put(out, (long)hopRefID);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasHopCompID()) {		
			FixUtils.put(out,hopCompID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHopSendingTime()) {		
			FixUtils.put(out,hopSendingTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHopRefID()) {		
			FixUtils.put(out, (long)hopRefID);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getHopCompID() { 		
		if ( hasHopCompID()) {		
			if (hasHopCompID == FixUtils.TAG_HAS_VALUE) {		
				return hopCompID; 		
			} else {		
		
				buf.position(hasHopCompID);		
		
			FixUtils.getTagStringValue(buf, hopCompID, 0, hopCompID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasHopCompID);		
					return null;		
				}		
			}		
			hasHopCompID = FixUtils.TAG_HAS_VALUE;		
			return hopCompID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasHopCompID() { return hasHopCompID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setHopCompID(byte[] src) {		
		if (src == null ) return;
		if (hasHopCompID()) FixUtils.fillNul(hopCompID);		
		FixUtils.copy(hopCompID, src); 		
		hasHopCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setHopCompID(String str) {		
		if (str == null ) return;
		if (hasHopCompID()) FixUtils.fillNul(hopCompID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(hopCompID, src); 		
		hasHopCompID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getHopSendingTime() { 		
		if ( hasHopSendingTime()) {		
			if (hasHopSendingTime == FixUtils.TAG_HAS_VALUE) {		
				return hopSendingTime; 		
			} else {		
		
				buf.position(hasHopSendingTime);		
		
			FixUtils.getTagStringValue(buf, hopSendingTime, 0, hopSendingTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasHopSendingTime);		
					return null;		
				}		
			}		
			hasHopSendingTime = FixUtils.TAG_HAS_VALUE;		
			return hopSendingTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasHopSendingTime() { return hasHopSendingTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setHopSendingTime(byte[] src) {		
		if (src == null ) return;
		if (hasHopSendingTime()) FixUtils.fillNul(hopSendingTime);		
		FixUtils.copy(hopSendingTime, src); 		
		hasHopSendingTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setHopSendingTime(String str) {		
		if (str == null ) return;
		if (hasHopSendingTime()) FixUtils.fillNul(hopSendingTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(hopSendingTime, src); 		
		hasHopSendingTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getHopRefID() { 		
		if ( hasHopRefID()) {		
			if (hasHopRefID == FixUtils.TAG_HAS_VALUE) {		
				return hopRefID; 		
			} else {		
		
				buf.position(hasHopRefID);		
		
			hopRefID = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasHopRefID);		
					return 0;		
				}		
			}		
			hasHopRefID = FixUtils.TAG_HAS_VALUE;		
			return hopRefID;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasHopRefID() { return hasHopRefID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setHopRefID(long src) {		
		hopRefID = src;
		hasHopRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHopRefID(byte[] src) {		
		if (src == null ) return;
		if (hasHopRefID()) hopRefID = FixUtils.TAG_HAS_NO_VALUE;		
		hopRefID = FixUtils.longValueOf(src, 0, src.length);
		hasHopRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setHopRefID(String str) {		
		if (str == null ) return;
		if (hasHopRefID()) hopRefID = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		hopRefID = FixUtils.longValueOf(src, 0, src.length);
		hasHopRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasHopCompID()) s += "HopCompID(628)= " + new String( FixUtils.trim(getHopCompID()) ) + "\n" ; 
		if (hasHopSendingTime()) s += "HopSendingTime(629)= " + new String( FixUtils.trim(getHopSendingTime()) ) + "\n" ; 
		if (hasHopRefID()) s += "HopRefID(630)= " + getHopRefID() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixHopGrp)) return false;

		FixHopGrp msg = (FixHopGrp) o;

		if ((hasHopCompID() && !msg.hasHopCompID()) || (!hasHopCompID() && msg.hasHopCompID())) return false;
		if (!(!hasHopCompID() && !msg.hasHopCompID()) && !FixUtils.equals(getHopCompID(), msg.getHopCompID())) return false;
		if ((hasHopSendingTime() && !msg.hasHopSendingTime()) || (!hasHopSendingTime() && msg.hasHopSendingTime())) return false;
		if ((hasHopRefID() && !msg.hasHopRefID()) || (!hasHopRefID() && msg.hasHopRefID())) return false;
		if (!(!hasHopRefID() && !msg.hasHopRefID()) && !(getHopRefID()==msg.getHopRefID())) return false;
		return true;
	}
	public FixHopGrp clone ( FixHopGrp out ) {
		if ( hasHopCompID())
			out.setHopCompID(getHopCompID());
		if ( hasHopSendingTime())
			out.setHopSendingTime(getHopSendingTime());
		if ( hasHopRefID())
			out.setHopRefID(getHopRefID());
		return out;
	}

}
