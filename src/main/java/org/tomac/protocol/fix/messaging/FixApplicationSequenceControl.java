package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixApplicationSequenceControl extends FixGroup {
	private short hasApplID;
	byte[] applID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasApplSeqNum;
	long applSeqNum = 0;		
	private short hasApplLastSeqNum;
	long applLastSeqNum = 0;		
	private short hasApplResendFlag;
		boolean applResendFlag = false;		
	
	public FixApplicationSequenceControl() {
		this(false);
	}

	public FixApplicationSequenceControl(boolean isRequired) {
		super(FixTags.APPLID_INT);

		this.isRequired = isRequired;
		
		hasApplID = FixUtils.TAG_HAS_NO_VALUE;		
		applID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasApplSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		hasApplLastSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		hasApplResendFlag = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasApplID()) return true;
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
            	case FixTags.APPLID_INT:		
            		hasApplID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.APPLSEQNUM_INT:		
            		hasApplSeqNum = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.APPLLASTSEQNUM_INT:		
            		hasApplLastSeqNum = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.APPLRESENDFLAG_INT:		
            		hasApplResendFlag = (short) buf.position();		
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
		hasApplID = FixUtils.TAG_HAS_NO_VALUE;
		hasApplSeqNum = FixUtils.TAG_HAS_NO_VALUE;
		hasApplLastSeqNum = FixUtils.TAG_HAS_NO_VALUE;
		hasApplResendFlag = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasApplID()) {		
			out.put(FixTags.APPLID);

			out.put((byte) '=');

			FixUtils.put(out,applID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasApplSeqNum()) {		
			out.put(FixTags.APPLSEQNUM);

			out.put((byte) '=');

			FixUtils.put(out, (long)applSeqNum);
		
			out.put(FixUtils.SOH);

            }

		if (hasApplLastSeqNum()) {		
			out.put(FixTags.APPLLASTSEQNUM);

			out.put((byte) '=');

			FixUtils.put(out, (long)applLastSeqNum);
		
			out.put(FixUtils.SOH);

            }

		if (hasApplResendFlag()) {		
			out.put(FixTags.APPLRESENDFLAG);

			out.put((byte) '=');

			out.put(applResendFlag?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasApplID()) {		
			FixUtils.put(out,applID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplSeqNum()) {		
			FixUtils.put(out, (long)applSeqNum);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplLastSeqNum()) {		
			FixUtils.put(out, (long)applLastSeqNum);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplResendFlag()) {		
			out.put(applResendFlag?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getApplID() { 		
		if ( hasApplID()) {		
			if (hasApplID == FixUtils.TAG_HAS_VALUE) {		
				return applID; 		
			} else {		
		
				buf.position(hasApplID);		
		
			FixUtils.getTagStringValue(buf, applID, 0, applID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasApplID);		
					return null;		
				}		
			}		
			hasApplID = FixUtils.TAG_HAS_VALUE;		
			return applID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasApplID() { return hasApplID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setApplID(byte[] src) {		
		if (src == null ) return;
		if (hasApplID()) FixUtils.fillNul(applID);		
		FixUtils.copy(applID, src); 		
		hasApplID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setApplID(String str) {		
		if (str == null ) return;
		if (hasApplID()) FixUtils.fillNul(applID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(applID, src); 		
		hasApplID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getApplSeqNum() { 		
		if ( hasApplSeqNum()) {		
			if (hasApplSeqNum == FixUtils.TAG_HAS_VALUE) {		
				return applSeqNum; 		
			} else {		
		
				buf.position(hasApplSeqNum);		
		
			applSeqNum = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasApplSeqNum);		
					return 0;		
				}		
			}		
			hasApplSeqNum = FixUtils.TAG_HAS_VALUE;		
			return applSeqNum;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplSeqNum() { return hasApplSeqNum != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setApplSeqNum(long src) {		
		applSeqNum = src;
		hasApplSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplSeqNum(byte[] src) {		
		if (src == null ) return;
		if (hasApplSeqNum()) applSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		applSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasApplSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setApplSeqNum(String str) {		
		if (str == null ) return;
		if (hasApplSeqNum()) applSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasApplSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getApplLastSeqNum() { 		
		if ( hasApplLastSeqNum()) {		
			if (hasApplLastSeqNum == FixUtils.TAG_HAS_VALUE) {		
				return applLastSeqNum; 		
			} else {		
		
				buf.position(hasApplLastSeqNum);		
		
			applLastSeqNum = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasApplLastSeqNum);		
					return 0;		
				}		
			}		
			hasApplLastSeqNum = FixUtils.TAG_HAS_VALUE;		
			return applLastSeqNum;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplLastSeqNum() { return hasApplLastSeqNum != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setApplLastSeqNum(long src) {		
		applLastSeqNum = src;
		hasApplLastSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplLastSeqNum(byte[] src) {		
		if (src == null ) return;
		if (hasApplLastSeqNum()) applLastSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		applLastSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasApplLastSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setApplLastSeqNum(String str) {		
		if (str == null ) return;
		if (hasApplLastSeqNum()) applLastSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applLastSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasApplLastSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getApplResendFlag() { 		
		if ( hasApplResendFlag()) {		
			if (hasApplResendFlag == FixUtils.TAG_HAS_VALUE) {		
				return applResendFlag; 		
			} else {		
		
				buf.position(hasApplResendFlag);		
		
			applResendFlag = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasApplResendFlag);		
					return false;		
				}		
			}		
			hasApplResendFlag = FixUtils.TAG_HAS_VALUE;		
			return applResendFlag;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasApplResendFlag() { return hasApplResendFlag != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setApplResendFlag(boolean src) {		
		applResendFlag = src;
		hasApplResendFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplResendFlag(byte[] src) {		
		if (src == null ) return;
		if (hasApplResendFlag()) applResendFlag = false;		
		applResendFlag = src[0]==(byte)'Y'?true:false;		
		hasApplResendFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setApplResendFlag(String str) {		
		if (str == null ) return;
		if (hasApplResendFlag()) applResendFlag = false;		
		byte[] src = str.getBytes(); 		
		applResendFlag = src[0]==(byte)'Y'?true:false;		
		hasApplResendFlag = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasApplID()) s += "ApplID(1180)= " + new String( FixUtils.trim(getApplID()) ) + "\n" ; 
		if (hasApplSeqNum()) s += "ApplSeqNum(1181)= " + getApplSeqNum() + "\n" ; 
		if (hasApplLastSeqNum()) s += "ApplLastSeqNum(1350)= " + getApplLastSeqNum() + "\n" ; 
		if (hasApplResendFlag()) s += "ApplResendFlag(1352)= " + getApplResendFlag() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixApplicationSequenceControl)) return false;

		FixApplicationSequenceControl msg = (FixApplicationSequenceControl) o;

		if ((hasApplID() && !msg.hasApplID()) || (!hasApplID() && msg.hasApplID())) return false;
		if (!(!hasApplID() && !msg.hasApplID()) && !FixUtils.equals(getApplID(), msg.getApplID())) return false;
		if ((hasApplSeqNum() && !msg.hasApplSeqNum()) || (!hasApplSeqNum() && msg.hasApplSeqNum())) return false;
		if (!(!hasApplSeqNum() && !msg.hasApplSeqNum()) && !(getApplSeqNum()==msg.getApplSeqNum())) return false;
		if ((hasApplLastSeqNum() && !msg.hasApplLastSeqNum()) || (!hasApplLastSeqNum() && msg.hasApplLastSeqNum())) return false;
		if (!(!hasApplLastSeqNum() && !msg.hasApplLastSeqNum()) && !(getApplLastSeqNum()==msg.getApplLastSeqNum())) return false;
		if ((hasApplResendFlag() && !msg.hasApplResendFlag()) || (!hasApplResendFlag() && msg.hasApplResendFlag())) return false;
		if (!(!hasApplResendFlag() && !msg.hasApplResendFlag()) && !(getApplResendFlag()==msg.getApplResendFlag())) return false;
		return true;
	}
	public FixApplicationSequenceControl clone ( FixApplicationSequenceControl out ) {
		if ( hasApplID())
			out.setApplID(getApplID());
		if ( hasApplSeqNum())
			out.setApplSeqNum(getApplSeqNum());
		if ( hasApplLastSeqNum())
			out.setApplLastSeqNum(getApplLastSeqNum());
		if ( hasApplResendFlag())
			out.setApplResendFlag(getApplResendFlag());
		return out;
	}

}
