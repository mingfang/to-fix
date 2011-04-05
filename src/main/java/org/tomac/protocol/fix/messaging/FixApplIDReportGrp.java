package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixApplIDReportGrp extends FixGroup {
	private short hasRefApplID;
	byte[] refApplID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasApplNewSeqNum;
	long applNewSeqNum = 0;		
	private short hasRefApplLastSeqNum;
	long refApplLastSeqNum = 0;		
	
	public FixApplIDReportGrp() {
		this(false);
	}

	public FixApplIDReportGrp(boolean isRequired) {
		super(FixTags.REFAPPLID_INT);

		this.isRequired = isRequired;
		
		hasRefApplID = FixUtils.TAG_HAS_NO_VALUE;		
		refApplID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasApplNewSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		hasRefApplLastSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRefApplID()) return true;
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
            	case FixTags.REFAPPLID_INT:		
            		hasRefApplID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.APPLNEWSEQNUM_INT:		
            		hasApplNewSeqNum = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.REFAPPLLASTSEQNUM_INT:		
            		hasRefApplLastSeqNum = (short) buf.position();		
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
		hasRefApplID = FixUtils.TAG_HAS_NO_VALUE;
		hasApplNewSeqNum = FixUtils.TAG_HAS_NO_VALUE;
		hasRefApplLastSeqNum = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRefApplID()) {		
			out.put(FixTags.REFAPPLID);

			out.put((byte) '=');

			FixUtils.put(out,refApplID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasApplNewSeqNum()) {		
			out.put(FixTags.APPLNEWSEQNUM);

			out.put((byte) '=');

			FixUtils.put(out, (long)applNewSeqNum);
		
			out.put(FixUtils.SOH);

            }

		if (hasRefApplLastSeqNum()) {		
			out.put(FixTags.REFAPPLLASTSEQNUM);

			out.put((byte) '=');

			FixUtils.put(out, (long)refApplLastSeqNum);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRefApplID()) {		
			FixUtils.put(out,refApplID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplNewSeqNum()) {		
			FixUtils.put(out, (long)applNewSeqNum);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefApplLastSeqNum()) {		
			FixUtils.put(out, (long)refApplLastSeqNum);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getRefApplID() { 		
		if ( hasRefApplID()) {		
			if (hasRefApplID == FixUtils.TAG_HAS_VALUE) {		
				return refApplID; 		
			} else {		
		
				buf.position(hasRefApplID);		
		
			FixMessage.getTagStringValue(buf, refApplID, 0, refApplID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRefApplID);		
					return null;		
				}		
			}		
			hasRefApplID = FixUtils.TAG_HAS_VALUE;		
			return refApplID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefApplID() { return hasRefApplID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefApplID(byte[] src) {		
		if (src == null ) return;
		if (hasRefApplID()) FixUtils.fillNul(refApplID);		
		FixUtils.copy(refApplID, src); 		
		hasRefApplID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefApplID(String str) {		
		if (str == null ) return;
		if (hasRefApplID()) FixUtils.fillNul(refApplID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refApplID, src); 		
		hasRefApplID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getApplNewSeqNum() { 		
		if ( hasApplNewSeqNum()) {		
			if (hasApplNewSeqNum == FixUtils.TAG_HAS_VALUE) {		
				return applNewSeqNum; 		
			} else {		
		
				buf.position(hasApplNewSeqNum);		
		
			applNewSeqNum = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasApplNewSeqNum);		
					return 0;		
				}		
			}		
			hasApplNewSeqNum = FixUtils.TAG_HAS_VALUE;		
			return applNewSeqNum;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplNewSeqNum() { return hasApplNewSeqNum != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setApplNewSeqNum(long src) {		
		applNewSeqNum = src;
		hasApplNewSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplNewSeqNum(byte[] src) {		
		if (src == null ) return;
		if (hasApplNewSeqNum()) applNewSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		applNewSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasApplNewSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setApplNewSeqNum(String str) {		
		if (str == null ) return;
		if (hasApplNewSeqNum()) applNewSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applNewSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasApplNewSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRefApplLastSeqNum() { 		
		if ( hasRefApplLastSeqNum()) {		
			if (hasRefApplLastSeqNum == FixUtils.TAG_HAS_VALUE) {		
				return refApplLastSeqNum; 		
			} else {		
		
				buf.position(hasRefApplLastSeqNum);		
		
			refApplLastSeqNum = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRefApplLastSeqNum);		
					return 0;		
				}		
			}		
			hasRefApplLastSeqNum = FixUtils.TAG_HAS_VALUE;		
			return refApplLastSeqNum;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRefApplLastSeqNum() { return hasRefApplLastSeqNum != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefApplLastSeqNum(long src) {		
		refApplLastSeqNum = src;
		hasRefApplLastSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefApplLastSeqNum(byte[] src) {		
		if (src == null ) return;
		if (hasRefApplLastSeqNum()) refApplLastSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		refApplLastSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasRefApplLastSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefApplLastSeqNum(String str) {		
		if (str == null ) return;
		if (hasRefApplLastSeqNum()) refApplLastSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		refApplLastSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasRefApplLastSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRefApplID()) s += "RefApplID(1355)= " + new String( FixUtils.trim(getRefApplID()) ) + "\n" ; 
		if (hasApplNewSeqNum()) s += "ApplNewSeqNum(1399)= " + getApplNewSeqNum() + "\n" ; 
		if (hasRefApplLastSeqNum()) s += "RefApplLastSeqNum(1357)= " + getRefApplLastSeqNum() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixApplIDReportGrp)) return false;

		FixApplIDReportGrp msg = (FixApplIDReportGrp) o;

		if ((hasRefApplID() && !msg.hasRefApplID()) || (!hasRefApplID() && msg.hasRefApplID())) return false;
		if (!(!hasRefApplID() && !msg.hasRefApplID()) && !FixUtils.equals(getRefApplID(), msg.getRefApplID())) return false;
		if ((hasApplNewSeqNum() && !msg.hasApplNewSeqNum()) || (!hasApplNewSeqNum() && msg.hasApplNewSeqNum())) return false;
		if (!(!hasApplNewSeqNum() && !msg.hasApplNewSeqNum()) && !(getApplNewSeqNum()==msg.getApplNewSeqNum())) return false;
		if ((hasRefApplLastSeqNum() && !msg.hasRefApplLastSeqNum()) || (!hasRefApplLastSeqNum() && msg.hasRefApplLastSeqNum())) return false;
		if (!(!hasRefApplLastSeqNum() && !msg.hasRefApplLastSeqNum()) && !(getRefApplLastSeqNum()==msg.getRefApplLastSeqNum())) return false;
		return true;
	}
	public FixApplIDReportGrp clone ( FixApplIDReportGrp out ) {
		if ( hasRefApplID())
			out.setRefApplID(getRefApplID());
		if ( hasApplNewSeqNum())
			out.setApplNewSeqNum(getApplNewSeqNum());
		if ( hasRefApplLastSeqNum())
			out.setRefApplLastSeqNum(getRefApplLastSeqNum());
		return out;
	}

}
