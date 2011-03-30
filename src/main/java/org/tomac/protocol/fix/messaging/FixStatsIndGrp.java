package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixStatsIndGrp extends FixGroup {
	private short hasStatsType;
	long statsType = 0;		
	
	public FixStatsIndGrp() {
		this(false);
	}

	public FixStatsIndGrp(boolean isRequired) {
		super(FixTags.STATSTYPE_INT);

		this.isRequired = isRequired;
		
		hasStatsType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasStatsType()) return true;
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
            	case FixTags.STATSTYPE_INT:		
            		hasStatsType = (short) buf.position();		
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
		hasStatsType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasStatsType()) {		
			out.put(FixTags.STATSTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)statsType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasStatsType()) {		
			FixUtils.put(out, (long)statsType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getStatsType() { 		
		if ( hasStatsType()) {		
			if (hasStatsType == FixUtils.TAG_HAS_VALUE) {		
				return statsType; 		
			} else {		
		
				buf.position(hasStatsType);		
		
			statsType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStatsType);		
					return 0;		
				}		
			}		
			hasStatsType = FixUtils.TAG_HAS_VALUE;		
			return statsType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStatsType() { return hasStatsType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStatsType(long src) {		
		statsType = src;
		hasStatsType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStatsType(byte[] src) {		
		if (src == null ) return;
		if (hasStatsType()) statsType = FixUtils.TAG_HAS_NO_VALUE;		
		statsType = FixUtils.longValueOf(src, 0, src.length);
		hasStatsType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStatsType(String str) {		
		if (str == null ) return;
		if (hasStatsType()) statsType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		statsType = FixUtils.longValueOf(src, 0, src.length);
		hasStatsType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasStatsType()) s += "StatsType(1176)= " + getStatsType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStatsIndGrp)) return false;

		FixStatsIndGrp msg = (FixStatsIndGrp) o;

		if ((hasStatsType() && !msg.hasStatsType()) || (!hasStatsType() && msg.hasStatsType())) return false;
		if (!(!hasStatsType() && !msg.hasStatsType()) && !(getStatsType()==msg.getStatsType())) return false;
		return true;
	}
	public FixStatsIndGrp clone ( FixStatsIndGrp out ) {
		if ( hasStatsType())
			out.setStatsType(getStatsType());
		return out;
	}

}
