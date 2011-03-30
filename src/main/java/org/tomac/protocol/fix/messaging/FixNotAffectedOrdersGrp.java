package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixNotAffectedOrdersGrp extends FixGroup {
	private short hasNotAffOrigClOrdID;
	byte[] notAffOrigClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNotAffectedOrderID;
	byte[] notAffectedOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixNotAffectedOrdersGrp() {
		this(false);
	}

	public FixNotAffectedOrdersGrp(boolean isRequired) {
		super(FixTags.NOTAFFORIGCLORDID_INT);

		this.isRequired = isRequired;
		
		hasNotAffOrigClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		notAffOrigClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNotAffectedOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		notAffectedOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNotAffOrigClOrdID()) return true;
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
            	case FixTags.NOTAFFORIGCLORDID_INT:		
            		hasNotAffOrigClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NOTAFFECTEDORDERID_INT:		
            		hasNotAffectedOrderID = (short) buf.position();		
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
		hasNotAffOrigClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasNotAffectedOrderID = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNotAffOrigClOrdID()) {		
			out.put(FixTags.NOTAFFORIGCLORDID);

			out.put((byte) '=');

			FixUtils.put(out,notAffOrigClOrdID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNotAffectedOrderID()) {		
			out.put(FixTags.NOTAFFECTEDORDERID);

			out.put((byte) '=');

			FixUtils.put(out,notAffectedOrderID); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNotAffOrigClOrdID()) {		
			FixUtils.put(out,notAffOrigClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNotAffectedOrderID()) {		
			FixUtils.put(out,notAffectedOrderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getNotAffOrigClOrdID() { 		
		if ( hasNotAffOrigClOrdID()) {		
			if (hasNotAffOrigClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return notAffOrigClOrdID; 		
			} else {		
		
				buf.position(hasNotAffOrigClOrdID);		
		
			FixMessage.getTagStringValue(buf, notAffOrigClOrdID, 0, notAffOrigClOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNotAffOrigClOrdID);		
					return null;		
				}		
			}		
			hasNotAffOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
			return notAffOrigClOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNotAffOrigClOrdID() { return hasNotAffOrigClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNotAffOrigClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasNotAffOrigClOrdID()) FixUtils.fillSpace(notAffOrigClOrdID);		
		FixUtils.copy(notAffOrigClOrdID, src); 		
		hasNotAffOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNotAffOrigClOrdID(String str) {		
		if (str == null ) return;
		if (hasNotAffOrigClOrdID()) FixUtils.fillSpace(notAffOrigClOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(notAffOrigClOrdID, src); 		
		hasNotAffOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getNotAffectedOrderID() { 		
		if ( hasNotAffectedOrderID()) {		
			if (hasNotAffectedOrderID == FixUtils.TAG_HAS_VALUE) {		
				return notAffectedOrderID; 		
			} else {		
		
				buf.position(hasNotAffectedOrderID);		
		
			FixMessage.getTagStringValue(buf, notAffectedOrderID, 0, notAffectedOrderID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNotAffectedOrderID);		
					return null;		
				}		
			}		
			hasNotAffectedOrderID = FixUtils.TAG_HAS_VALUE;		
			return notAffectedOrderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNotAffectedOrderID() { return hasNotAffectedOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNotAffectedOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasNotAffectedOrderID()) FixUtils.fillSpace(notAffectedOrderID);		
		FixUtils.copy(notAffectedOrderID, src); 		
		hasNotAffectedOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNotAffectedOrderID(String str) {		
		if (str == null ) return;
		if (hasNotAffectedOrderID()) FixUtils.fillSpace(notAffectedOrderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(notAffectedOrderID, src); 		
		hasNotAffectedOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNotAffOrigClOrdID()) s += "NotAffOrigClOrdID(1372)= " + new String( FixUtils.trim(getNotAffOrigClOrdID()) ) + "\n" ; 
		if (hasNotAffectedOrderID()) s += "NotAffectedOrderID(1371)= " + new String( FixUtils.trim(getNotAffectedOrderID()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNotAffectedOrdersGrp)) return false;

		FixNotAffectedOrdersGrp msg = (FixNotAffectedOrdersGrp) o;

		if ((hasNotAffOrigClOrdID() && !msg.hasNotAffOrigClOrdID()) || (!hasNotAffOrigClOrdID() && msg.hasNotAffOrigClOrdID())) return false;
		if (!(!hasNotAffOrigClOrdID() && !msg.hasNotAffOrigClOrdID()) && !FixUtils.equals(getNotAffOrigClOrdID(), msg.getNotAffOrigClOrdID())) return false;
		if ((hasNotAffectedOrderID() && !msg.hasNotAffectedOrderID()) || (!hasNotAffectedOrderID() && msg.hasNotAffectedOrderID())) return false;
		if (!(!hasNotAffectedOrderID() && !msg.hasNotAffectedOrderID()) && !FixUtils.equals(getNotAffectedOrderID(), msg.getNotAffectedOrderID())) return false;
		return true;
	}
	public FixNotAffectedOrdersGrp clone ( FixNotAffectedOrdersGrp out ) {
		if ( hasNotAffOrigClOrdID())
			out.setNotAffOrigClOrdID(getNotAffOrigClOrdID());
		if ( hasNotAffectedOrderID())
			out.setNotAffectedOrderID(getNotAffectedOrderID());
		return out;
	}

}
