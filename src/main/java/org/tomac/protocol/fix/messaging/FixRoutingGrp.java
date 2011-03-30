package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRoutingGrp extends FixGroup {
	private short hasRoutingType;
	long routingType = 0;		
	private short hasRoutingID;
	byte[] routingID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixRoutingGrp() {
		this(false);
	}

	public FixRoutingGrp(boolean isRequired) {
		super(FixTags.ROUTINGTYPE_INT);

		this.isRequired = isRequired;
		
		hasRoutingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasRoutingID = FixUtils.TAG_HAS_NO_VALUE;		
		routingID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRoutingType()) return true;
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
            	case FixTags.ROUTINGTYPE_INT:		
            		hasRoutingType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ROUTINGID_INT:		
            		hasRoutingID = (short) buf.position();		
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
		hasRoutingType = FixUtils.TAG_HAS_NO_VALUE;
		hasRoutingID = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRoutingType()) {		
			out.put(FixTags.ROUTINGTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)routingType);
		
			out.put(FixUtils.SOH);

            }

		if (hasRoutingID()) {		
			out.put(FixTags.ROUTINGID);

			out.put((byte) '=');

			FixUtils.put(out,routingID); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRoutingType()) {		
			FixUtils.put(out, (long)routingType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRoutingID()) {		
			FixUtils.put(out,routingID); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getRoutingType() { 		
		if ( hasRoutingType()) {		
			if (hasRoutingType == FixUtils.TAG_HAS_VALUE) {		
				return routingType; 		
			} else {		
		
				buf.position(hasRoutingType);		
		
			routingType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRoutingType);		
					return 0;		
				}		
			}		
			hasRoutingType = FixUtils.TAG_HAS_VALUE;		
			return routingType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRoutingType() { return hasRoutingType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRoutingType(long src) {		
		routingType = src;
		hasRoutingType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRoutingType(byte[] src) {		
		if (src == null ) return;
		if (hasRoutingType()) routingType = FixUtils.TAG_HAS_NO_VALUE;		
		routingType = FixUtils.longValueOf(src, 0, src.length);
		hasRoutingType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRoutingType(String str) {		
		if (str == null ) return;
		if (hasRoutingType()) routingType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		routingType = FixUtils.longValueOf(src, 0, src.length);
		hasRoutingType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRoutingID() { 		
		if ( hasRoutingID()) {		
			if (hasRoutingID == FixUtils.TAG_HAS_VALUE) {		
				return routingID; 		
			} else {		
		
				buf.position(hasRoutingID);		
		
			FixMessage.getTagStringValue(buf, routingID, 0, routingID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRoutingID);		
					return null;		
				}		
			}		
			hasRoutingID = FixUtils.TAG_HAS_VALUE;		
			return routingID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRoutingID() { return hasRoutingID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRoutingID(byte[] src) {		
		if (src == null ) return;
		if (hasRoutingID()) FixUtils.fillSpace(routingID);		
		FixUtils.copy(routingID, src); 		
		hasRoutingID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRoutingID(String str) {		
		if (str == null ) return;
		if (hasRoutingID()) FixUtils.fillSpace(routingID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(routingID, src); 		
		hasRoutingID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRoutingType()) s += "RoutingType(216)= " + getRoutingType() + "\n" ; 
		if (hasRoutingID()) s += "RoutingID(217)= " + new String( FixUtils.trim(getRoutingID()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRoutingGrp)) return false;

		FixRoutingGrp msg = (FixRoutingGrp) o;

		if ((hasRoutingType() && !msg.hasRoutingType()) || (!hasRoutingType() && msg.hasRoutingType())) return false;
		if (!(!hasRoutingType() && !msg.hasRoutingType()) && !(getRoutingType()==msg.getRoutingType())) return false;
		if ((hasRoutingID() && !msg.hasRoutingID()) || (!hasRoutingID() && msg.hasRoutingID())) return false;
		if (!(!hasRoutingID() && !msg.hasRoutingID()) && !FixUtils.equals(getRoutingID(), msg.getRoutingID())) return false;
		return true;
	}
	public FixRoutingGrp clone ( FixRoutingGrp out ) {
		if ( hasRoutingType())
			out.setRoutingType(getRoutingType());
		if ( hasRoutingID())
			out.setRoutingID(getRoutingID());
		return out;
	}

}
