package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixApplIDRequestGrp extends FixGroup {
	private short hasRefApplID;
	byte[] refApplID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRefApplReqID;
	byte[] refApplReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasApplBegSeqNum;
	long applBegSeqNum = 0;		
	private short hasApplEndSeqNum;
	long applEndSeqNum = 0;		
		public FixNestedParties[] nestedParties;
	
	public FixApplIDRequestGrp() {
		this(false);
	}

	public FixApplIDRequestGrp(boolean isRequired) {
		super(FixTags.REFAPPLID_INT);

		this.isRequired = isRequired;
		
		hasRefApplID = FixUtils.TAG_HAS_NO_VALUE;		
		refApplID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRefApplReqID = FixUtils.TAG_HAS_NO_VALUE;		
		refApplReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasApplBegSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		hasApplEndSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		nestedParties = new FixNestedParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedParties[i] = new FixNestedParties();
		
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
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.REFAPPLID_INT:		
            		hasRefApplID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.REFAPPLREQID_INT:		
            		hasRefApplReqID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.APPLBEGSEQNUM_INT:		
            		hasApplBegSeqNum = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.APPLENDSEQNUM_INT:		
            		hasApplEndSeqNum = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTEDPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !nestedParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NONESTEDPARTYIDS_INT);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = nestedParties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
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
		hasRefApplID = FixUtils.TAG_HAS_NO_VALUE;
		hasRefApplReqID = FixUtils.TAG_HAS_NO_VALUE;
		hasApplBegSeqNum = FixUtils.TAG_HAS_NO_VALUE;
		hasApplEndSeqNum = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRefApplID()) {		
			out.put(FixTags.REFAPPLID);

			out.put((byte) '=');

			FixUtils.put(out,refApplID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRefApplReqID()) {		
			out.put(FixTags.REFAPPLREQID);

			out.put((byte) '=');

			FixUtils.put(out,refApplReqID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasApplBegSeqNum()) {		
			out.put(FixTags.APPLBEGSEQNUM);

			out.put((byte) '=');

			FixUtils.put(out, (long)applBegSeqNum);
		
			out.put(FixUtils.SOH);

            }

		if (hasApplEndSeqNum()) {		
			out.put(FixTags.APPLENDSEQNUM);

			out.put((byte) '=');

			FixUtils.put(out, (long)applEndSeqNum);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(nestedParties)>0) {
			out.put(FixTags.NONESTEDPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(nestedParties));

			out.put(FixUtils.SOH);

		}
		for (FixNestedParties fixNestedParties : nestedParties) if (fixNestedParties.hasGroup()) fixNestedParties.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRefApplID()) {		
			FixUtils.put(out,refApplID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefApplReqID()) {		
			FixUtils.put(out,refApplReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplBegSeqNum()) {		
			FixUtils.put(out, (long)applBegSeqNum);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasApplEndSeqNum()) {		
			FixUtils.put(out, (long)applEndSeqNum);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.printBuffer(out);
	}

	public byte[] getRefApplID() { 		
		if ( hasRefApplID()) {		
			if (hasRefApplID == FixUtils.TAG_HAS_VALUE) {		
				return refApplID; 		
			} else {		
		
				buf.position(hasRefApplID);		
		
			FixUtils.getTagStringValue(buf, refApplID, 0, refApplID.length, err);
		
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
			
	public byte[] getRefApplReqID() { 		
		if ( hasRefApplReqID()) {		
			if (hasRefApplReqID == FixUtils.TAG_HAS_VALUE) {		
				return refApplReqID; 		
			} else {		
		
				buf.position(hasRefApplReqID);		
		
			FixUtils.getTagStringValue(buf, refApplReqID, 0, refApplReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRefApplReqID);		
					return null;		
				}		
			}		
			hasRefApplReqID = FixUtils.TAG_HAS_VALUE;		
			return refApplReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefApplReqID() { return hasRefApplReqID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefApplReqID(byte[] src) {		
		if (src == null ) return;
		if (hasRefApplReqID()) FixUtils.fillNul(refApplReqID);		
		FixUtils.copy(refApplReqID, src); 		
		hasRefApplReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefApplReqID(String str) {		
		if (str == null ) return;
		if (hasRefApplReqID()) FixUtils.fillNul(refApplReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refApplReqID, src); 		
		hasRefApplReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getApplBegSeqNum() { 		
		if ( hasApplBegSeqNum()) {		
			if (hasApplBegSeqNum == FixUtils.TAG_HAS_VALUE) {		
				return applBegSeqNum; 		
			} else {		
		
				buf.position(hasApplBegSeqNum);		
		
			applBegSeqNum = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasApplBegSeqNum);		
					return 0;		
				}		
			}		
			hasApplBegSeqNum = FixUtils.TAG_HAS_VALUE;		
			return applBegSeqNum;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplBegSeqNum() { return hasApplBegSeqNum != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setApplBegSeqNum(long src) {		
		applBegSeqNum = src;
		hasApplBegSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplBegSeqNum(byte[] src) {		
		if (src == null ) return;
		if (hasApplBegSeqNum()) applBegSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		applBegSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasApplBegSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setApplBegSeqNum(String str) {		
		if (str == null ) return;
		if (hasApplBegSeqNum()) applBegSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applBegSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasApplBegSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getApplEndSeqNum() { 		
		if ( hasApplEndSeqNum()) {		
			if (hasApplEndSeqNum == FixUtils.TAG_HAS_VALUE) {		
				return applEndSeqNum; 		
			} else {		
		
				buf.position(hasApplEndSeqNum);		
		
			applEndSeqNum = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasApplEndSeqNum);		
					return 0;		
				}		
			}		
			hasApplEndSeqNum = FixUtils.TAG_HAS_VALUE;		
			return applEndSeqNum;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasApplEndSeqNum() { return hasApplEndSeqNum != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setApplEndSeqNum(long src) {		
		applEndSeqNum = src;
		hasApplEndSeqNum = FixUtils.TAG_HAS_VALUE;		
	}

	public void setApplEndSeqNum(byte[] src) {		
		if (src == null ) return;
		if (hasApplEndSeqNum()) applEndSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		applEndSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasApplEndSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setApplEndSeqNum(String str) {		
		if (str == null ) return;
		if (hasApplEndSeqNum()) applEndSeqNum = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		applEndSeqNum = FixUtils.longValueOf(src, 0, src.length);
		hasApplEndSeqNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRefApplID()) s += "RefApplID(1355)= " + new String( FixUtils.trim(getRefApplID()) ) + "\n" ; 
		if (hasRefApplReqID()) s += "RefApplReqID(1433)= " + new String( FixUtils.trim(getRefApplReqID()) ) + "\n" ; 
		if (hasApplBegSeqNum()) s += "ApplBegSeqNum(1182)= " + getApplBegSeqNum() + "\n" ; 
		if (hasApplEndSeqNum()) s += "ApplEndSeqNum(1183)= " + getApplEndSeqNum() + "\n" ; 

		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixApplIDRequestGrp)) return false;

		FixApplIDRequestGrp msg = (FixApplIDRequestGrp) o;

		for (int i = 0; i < nestedParties.length; i++)
			if (!nestedParties[i].equals(msg.nestedParties[i])) return false;
		if ((hasRefApplID() && !msg.hasRefApplID()) || (!hasRefApplID() && msg.hasRefApplID())) return false;
		if (!(!hasRefApplID() && !msg.hasRefApplID()) && !FixUtils.equals(getRefApplID(), msg.getRefApplID())) return false;
		if ((hasRefApplReqID() && !msg.hasRefApplReqID()) || (!hasRefApplReqID() && msg.hasRefApplReqID())) return false;
		if (!(!hasRefApplReqID() && !msg.hasRefApplReqID()) && !FixUtils.equals(getRefApplReqID(), msg.getRefApplReqID())) return false;
		if ((hasApplBegSeqNum() && !msg.hasApplBegSeqNum()) || (!hasApplBegSeqNum() && msg.hasApplBegSeqNum())) return false;
		if (!(!hasApplBegSeqNum() && !msg.hasApplBegSeqNum()) && !(getApplBegSeqNum()==msg.getApplBegSeqNum())) return false;
		if ((hasApplEndSeqNum() && !msg.hasApplEndSeqNum()) || (!hasApplEndSeqNum() && msg.hasApplEndSeqNum())) return false;
		if (!(!hasApplEndSeqNum() && !msg.hasApplEndSeqNum()) && !(getApplEndSeqNum()==msg.getApplEndSeqNum())) return false;
		return true;
	}
	public FixApplIDRequestGrp clone ( FixApplIDRequestGrp out ) {
		if ( hasRefApplID())
			out.setRefApplID(getRefApplID());
		if ( hasRefApplReqID())
			out.setRefApplReqID(getRefApplReqID());
		if ( hasApplBegSeqNum())
			out.setApplBegSeqNum(getApplBegSeqNum());
		if ( hasApplEndSeqNum())
			out.setApplEndSeqNum(getApplEndSeqNum());
		int count = 0;
		count = 0;
		for (FixNestedParties fixNestedParties : nestedParties) {
			if (!fixNestedParties.hasGroup()) continue;
			out.nestedParties[count] = fixNestedParties.clone( out.nestedParties[count] );
			count++;
		}
		return out;
	}

}
