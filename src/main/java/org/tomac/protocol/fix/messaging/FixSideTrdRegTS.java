package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSideTrdRegTS extends FixGroup {
	private short hasSideTrdRegTimestamp;
	byte[] sideTrdRegTimestamp = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasSideTrdRegTimestampType;
	long sideTrdRegTimestampType = 0;		
	private short hasSideTrdRegTimestampSrc;
	byte[] sideTrdRegTimestampSrc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixSideTrdRegTS() {
		this(false);
	}

	public FixSideTrdRegTS(boolean isRequired) {
		super(FixTags.SIDETRDREGTIMESTAMP_INT);

		this.isRequired = isRequired;
		
		hasSideTrdRegTimestamp = FixUtils.TAG_HAS_NO_VALUE;		
		sideTrdRegTimestamp = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasSideTrdRegTimestampType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSideTrdRegTimestampSrc = FixUtils.TAG_HAS_NO_VALUE;		
		sideTrdRegTimestampSrc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSideTrdRegTimestamp()) return true;
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
            	case FixTags.SIDETRDREGTIMESTAMP_INT:		
            		hasSideTrdRegTimestamp = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDETRDREGTIMESTAMPTYPE_INT:		
            		hasSideTrdRegTimestampType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDETRDREGTIMESTAMPSRC_INT:		
            		hasSideTrdRegTimestampSrc = (short) buf.position();		
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
		hasSideTrdRegTimestamp = FixUtils.TAG_HAS_NO_VALUE;
		hasSideTrdRegTimestampType = FixUtils.TAG_HAS_NO_VALUE;
		hasSideTrdRegTimestampSrc = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSideTrdRegTimestamp()) {		
			out.put(FixTags.SIDETRDREGTIMESTAMP);

			out.put((byte) '=');

			FixUtils.put(out,sideTrdRegTimestamp); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSideTrdRegTimestampType()) {		
			out.put(FixTags.SIDETRDREGTIMESTAMPTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)sideTrdRegTimestampType);
		
			out.put(FixUtils.SOH);

            }

		if (hasSideTrdRegTimestampSrc()) {		
			out.put(FixTags.SIDETRDREGTIMESTAMPSRC);

			out.put((byte) '=');

			FixUtils.put(out,sideTrdRegTimestampSrc); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSideTrdRegTimestamp()) {		
			FixUtils.put(out,sideTrdRegTimestamp); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideTrdRegTimestampType()) {		
			FixUtils.put(out, (long)sideTrdRegTimestampType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideTrdRegTimestampSrc()) {		
			FixUtils.put(out,sideTrdRegTimestampSrc); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getSideTrdRegTimestamp() { 		
		if ( hasSideTrdRegTimestamp()) {		
			if (hasSideTrdRegTimestamp == FixUtils.TAG_HAS_VALUE) {		
				return sideTrdRegTimestamp; 		
			} else {		
		
				buf.position(hasSideTrdRegTimestamp);		
		
			FixUtils.getTagStringValue(buf, sideTrdRegTimestamp, 0, sideTrdRegTimestamp.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSideTrdRegTimestamp);		
					return null;		
				}		
			}		
			hasSideTrdRegTimestamp = FixUtils.TAG_HAS_VALUE;		
			return sideTrdRegTimestamp;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSideTrdRegTimestamp() { return hasSideTrdRegTimestamp != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideTrdRegTimestamp(byte[] src) {		
		if (src == null ) return;
		if (hasSideTrdRegTimestamp()) FixUtils.fillNul(sideTrdRegTimestamp);		
		FixUtils.copy(sideTrdRegTimestamp, src); 		
		hasSideTrdRegTimestamp = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideTrdRegTimestamp(String str) {		
		if (str == null ) return;
		if (hasSideTrdRegTimestamp()) FixUtils.fillNul(sideTrdRegTimestamp);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(sideTrdRegTimestamp, src); 		
		hasSideTrdRegTimestamp = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSideTrdRegTimestampType() { 		
		if ( hasSideTrdRegTimestampType()) {		
			if (hasSideTrdRegTimestampType == FixUtils.TAG_HAS_VALUE) {		
				return sideTrdRegTimestampType; 		
			} else {		
		
				buf.position(hasSideTrdRegTimestampType);		
		
			sideTrdRegTimestampType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSideTrdRegTimestampType);		
					return 0;		
				}		
			}		
			hasSideTrdRegTimestampType = FixUtils.TAG_HAS_VALUE;		
			return sideTrdRegTimestampType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSideTrdRegTimestampType() { return hasSideTrdRegTimestampType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideTrdRegTimestampType(long src) {		
		sideTrdRegTimestampType = src;
		hasSideTrdRegTimestampType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSideTrdRegTimestampType(byte[] src) {		
		if (src == null ) return;
		if (hasSideTrdRegTimestampType()) sideTrdRegTimestampType = FixUtils.TAG_HAS_NO_VALUE;		
		sideTrdRegTimestampType = FixUtils.longValueOf(src, 0, src.length);
		hasSideTrdRegTimestampType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideTrdRegTimestampType(String str) {		
		if (str == null ) return;
		if (hasSideTrdRegTimestampType()) sideTrdRegTimestampType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sideTrdRegTimestampType = FixUtils.longValueOf(src, 0, src.length);
		hasSideTrdRegTimestampType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSideTrdRegTimestampSrc() { 		
		if ( hasSideTrdRegTimestampSrc()) {		
			if (hasSideTrdRegTimestampSrc == FixUtils.TAG_HAS_VALUE) {		
				return sideTrdRegTimestampSrc; 		
			} else {		
		
				buf.position(hasSideTrdRegTimestampSrc);		
		
			FixUtils.getTagStringValue(buf, sideTrdRegTimestampSrc, 0, sideTrdRegTimestampSrc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSideTrdRegTimestampSrc);		
					return null;		
				}		
			}		
			hasSideTrdRegTimestampSrc = FixUtils.TAG_HAS_VALUE;		
			return sideTrdRegTimestampSrc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSideTrdRegTimestampSrc() { return hasSideTrdRegTimestampSrc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideTrdRegTimestampSrc(byte[] src) {		
		if (src == null ) return;
		if (hasSideTrdRegTimestampSrc()) FixUtils.fillNul(sideTrdRegTimestampSrc);		
		FixUtils.copy(sideTrdRegTimestampSrc, src); 		
		hasSideTrdRegTimestampSrc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideTrdRegTimestampSrc(String str) {		
		if (str == null ) return;
		if (hasSideTrdRegTimestampSrc()) FixUtils.fillNul(sideTrdRegTimestampSrc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(sideTrdRegTimestampSrc, src); 		
		hasSideTrdRegTimestampSrc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSideTrdRegTimestamp()) s += "SideTrdRegTimestamp(1012)= " + new String( FixUtils.trim(getSideTrdRegTimestamp()) ) + "\n" ; 
		if (hasSideTrdRegTimestampType()) s += "SideTrdRegTimestampType(1013)= " + getSideTrdRegTimestampType() + "\n" ; 
		if (hasSideTrdRegTimestampSrc()) s += "SideTrdRegTimestampSrc(1014)= " + new String( FixUtils.trim(getSideTrdRegTimestampSrc()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSideTrdRegTS)) return false;

		FixSideTrdRegTS msg = (FixSideTrdRegTS) o;

		if ((hasSideTrdRegTimestamp() && !msg.hasSideTrdRegTimestamp()) || (!hasSideTrdRegTimestamp() && msg.hasSideTrdRegTimestamp())) return false;
		if ((hasSideTrdRegTimestampType() && !msg.hasSideTrdRegTimestampType()) || (!hasSideTrdRegTimestampType() && msg.hasSideTrdRegTimestampType())) return false;
		if (!(!hasSideTrdRegTimestampType() && !msg.hasSideTrdRegTimestampType()) && !(getSideTrdRegTimestampType()==msg.getSideTrdRegTimestampType())) return false;
		if ((hasSideTrdRegTimestampSrc() && !msg.hasSideTrdRegTimestampSrc()) || (!hasSideTrdRegTimestampSrc() && msg.hasSideTrdRegTimestampSrc())) return false;
		if (!(!hasSideTrdRegTimestampSrc() && !msg.hasSideTrdRegTimestampSrc()) && !FixUtils.equals(getSideTrdRegTimestampSrc(), msg.getSideTrdRegTimestampSrc())) return false;
		return true;
	}
	public FixSideTrdRegTS clone ( FixSideTrdRegTS out ) {
		if ( hasSideTrdRegTimestamp())
			out.setSideTrdRegTimestamp(getSideTrdRegTimestamp());
		if ( hasSideTrdRegTimestampType())
			out.setSideTrdRegTimestampType(getSideTrdRegTimestampType());
		if ( hasSideTrdRegTimestampSrc())
			out.setSideTrdRegTimestampSrc(getSideTrdRegTimestampSrc());
		return out;
	}

}
