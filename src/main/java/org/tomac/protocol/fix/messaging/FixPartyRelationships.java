package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixPartyRelationships extends FixGroup {
	private short hasPartyRelationship;
	long partyRelationship = 0;		
	
	public FixPartyRelationships() {
		this(false);
	}

	public FixPartyRelationships(boolean isRequired) {
		super(FixTags.PARTYRELATIONSHIP_INT);

		this.isRequired = isRequired;
		
		hasPartyRelationship = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasPartyRelationship()) return true;
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
            	case FixTags.PARTYRELATIONSHIP_INT:		
            		hasPartyRelationship = (short) buf.position();		
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
		hasPartyRelationship = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasPartyRelationship()) {		
			out.put(FixTags.PARTYRELATIONSHIP);

			out.put((byte) '=');

			FixUtils.put(out, (long)partyRelationship);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasPartyRelationship()) {		
			FixUtils.put(out, (long)partyRelationship);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getPartyRelationship() { 		
		if ( hasPartyRelationship()) {		
			if (hasPartyRelationship == FixUtils.TAG_HAS_VALUE) {		
				return partyRelationship; 		
			} else {		
		
				buf.position(hasPartyRelationship);		
		
			partyRelationship = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPartyRelationship);		
					return 0;		
				}		
			}		
			hasPartyRelationship = FixUtils.TAG_HAS_VALUE;		
			return partyRelationship;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPartyRelationship() { return hasPartyRelationship != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPartyRelationship(long src) {		
		partyRelationship = src;
		hasPartyRelationship = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPartyRelationship(byte[] src) {		
		if (src == null ) return;
		if (hasPartyRelationship()) partyRelationship = FixUtils.TAG_HAS_NO_VALUE;		
		partyRelationship = FixUtils.longValueOf(src, 0, src.length);
		hasPartyRelationship = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPartyRelationship(String str) {		
		if (str == null ) return;
		if (hasPartyRelationship()) partyRelationship = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		partyRelationship = FixUtils.longValueOf(src, 0, src.length);
		hasPartyRelationship = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasPartyRelationship()) s += "PartyRelationship(1515)= " + getPartyRelationship() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPartyRelationships)) return false;

		FixPartyRelationships msg = (FixPartyRelationships) o;

		if ((hasPartyRelationship() && !msg.hasPartyRelationship()) || (!hasPartyRelationship() && msg.hasPartyRelationship())) return false;
		if (!(!hasPartyRelationship() && !msg.hasPartyRelationship()) && !(getPartyRelationship()==msg.getPartyRelationship())) return false;
		return true;
	}
	public FixPartyRelationships clone ( FixPartyRelationships out ) {
		if ( hasPartyRelationship())
			out.setPartyRelationship(getPartyRelationship());
		return out;
	}

}
