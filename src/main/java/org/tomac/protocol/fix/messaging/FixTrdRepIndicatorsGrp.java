package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTrdRepIndicatorsGrp extends FixGroup {
	private short hasTrdRepPartyRole;
	long trdRepPartyRole = 0;		
	private short hasTrdRepIndicator;
		boolean trdRepIndicator = false;		
	
	public FixTrdRepIndicatorsGrp() {
		this(false);
	}

	public FixTrdRepIndicatorsGrp(boolean isRequired) {
		super(FixTags.TRDREPPARTYROLE_INT);

		this.isRequired = isRequired;
		
		hasTrdRepPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		hasTrdRepIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasTrdRepPartyRole()) return true;
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
            	case FixTags.TRDREPPARTYROLE_INT:		
            		hasTrdRepPartyRole = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.TRDREPINDICATOR_INT:		
            		hasTrdRepIndicator = (short) buf.position();		
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
		hasTrdRepPartyRole = FixUtils.TAG_HAS_NO_VALUE;
		hasTrdRepIndicator = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasTrdRepPartyRole()) {		
			out.put(FixTags.TRDREPPARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)trdRepPartyRole);
		
			out.put(FixUtils.SOH);

            }

		if (hasTrdRepIndicator()) {		
			out.put(FixTags.TRDREPINDICATOR);

			out.put((byte) '=');

			out.put(trdRepIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasTrdRepPartyRole()) {		
			FixUtils.put(out, (long)trdRepPartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTrdRepIndicator()) {		
			out.put(trdRepIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getTrdRepPartyRole() { 		
		if ( hasTrdRepPartyRole()) {		
			if (hasTrdRepPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return trdRepPartyRole; 		
			} else {		
		
				buf.position(hasTrdRepPartyRole);		
		
			trdRepPartyRole = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTrdRepPartyRole);		
					return 0;		
				}		
			}		
			hasTrdRepPartyRole = FixUtils.TAG_HAS_VALUE;		
			return trdRepPartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTrdRepPartyRole() { return hasTrdRepPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTrdRepPartyRole(long src) {		
		trdRepPartyRole = src;
		hasTrdRepPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdRepPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasTrdRepPartyRole()) trdRepPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		trdRepPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasTrdRepPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTrdRepPartyRole(String str) {		
		if (str == null ) return;
		if (hasTrdRepPartyRole()) trdRepPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		trdRepPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasTrdRepPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getTrdRepIndicator() { 		
		if ( hasTrdRepIndicator()) {		
			if (hasTrdRepIndicator == FixUtils.TAG_HAS_VALUE) {		
				return trdRepIndicator; 		
			} else {		
		
				buf.position(hasTrdRepIndicator);		
		
			trdRepIndicator = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasTrdRepIndicator);		
					return false;		
				}		
			}		
			hasTrdRepIndicator = FixUtils.TAG_HAS_VALUE;		
			return trdRepIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasTrdRepIndicator() { return hasTrdRepIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTrdRepIndicator(boolean src) {		
		trdRepIndicator = src;
		hasTrdRepIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdRepIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasTrdRepIndicator()) trdRepIndicator = false;		
		trdRepIndicator = src[0]==(byte)'Y'?true:false;		
		hasTrdRepIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTrdRepIndicator(String str) {		
		if (str == null ) return;
		if (hasTrdRepIndicator()) trdRepIndicator = false;		
		byte[] src = str.getBytes(); 		
		trdRepIndicator = src[0]==(byte)'Y'?true:false;		
		hasTrdRepIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasTrdRepPartyRole()) s += "TrdRepPartyRole(1388)= " + getTrdRepPartyRole() + "\n" ; 
		if (hasTrdRepIndicator()) s += "TrdRepIndicator(1389)= " + getTrdRepIndicator() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTrdRepIndicatorsGrp)) return false;

		FixTrdRepIndicatorsGrp msg = (FixTrdRepIndicatorsGrp) o;

		if ((hasTrdRepPartyRole() && !msg.hasTrdRepPartyRole()) || (!hasTrdRepPartyRole() && msg.hasTrdRepPartyRole())) return false;
		if (!(!hasTrdRepPartyRole() && !msg.hasTrdRepPartyRole()) && !(getTrdRepPartyRole()==msg.getTrdRepPartyRole())) return false;
		if ((hasTrdRepIndicator() && !msg.hasTrdRepIndicator()) || (!hasTrdRepIndicator() && msg.hasTrdRepIndicator())) return false;
		if (!(!hasTrdRepIndicator() && !msg.hasTrdRepIndicator()) && !(getTrdRepIndicator()==msg.getTrdRepIndicator())) return false;
		return true;
	}
	public FixTrdRepIndicatorsGrp clone ( FixTrdRepIndicatorsGrp out ) {
		if ( hasTrdRepPartyRole())
			out.setTrdRepPartyRole(getTrdRepPartyRole());
		if ( hasTrdRepIndicator())
			out.setTrdRepIndicator(getTrdRepIndicator());
		return out;
	}

}
