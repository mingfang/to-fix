package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTrdRegTimestamps extends FixGroup {
	private short hasTrdRegTimestamp;
	byte[] trdRegTimestamp = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTrdRegTimestampType;
	long trdRegTimestampType = 0;		
	private short hasTrdRegTimestampOrigin;
	byte[] trdRegTimestampOrigin = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDeskType;
	byte[] deskType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDeskTypeSource;
	long deskTypeSource = 0;		
	private short hasDeskOrderHandlingInst;
	byte[] deskOrderHandlingInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixTrdRegTimestamps() {
		this(false);
	}

	public FixTrdRegTimestamps(boolean isRequired) {
		super(FixTags.TRDREGTIMESTAMP_INT);

		this.isRequired = isRequired;
		
		hasTrdRegTimestamp = FixUtils.TAG_HAS_NO_VALUE;		
		trdRegTimestamp = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTrdRegTimestampType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTrdRegTimestampOrigin = FixUtils.TAG_HAS_NO_VALUE;		
		trdRegTimestampOrigin = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDeskType = FixUtils.TAG_HAS_NO_VALUE;		
		deskType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDeskTypeSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasDeskOrderHandlingInst = FixUtils.TAG_HAS_NO_VALUE;		
		deskOrderHandlingInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasTrdRegTimestamp()) return true;
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
            	case FixTags.TRDREGTIMESTAMP_INT:		
            		hasTrdRegTimestamp = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRDREGTIMESTAMPTYPE_INT:		
            		hasTrdRegTimestampType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRDREGTIMESTAMPORIGIN_INT:		
            		hasTrdRegTimestampOrigin = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DESKTYPE_INT:		
            		hasDeskType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DESKTYPESOURCE_INT:		
            		hasDeskTypeSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DESKORDERHANDLINGINST_INT:		
            		hasDeskOrderHandlingInst = (short) buf.position();		
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
		hasTrdRegTimestamp = FixUtils.TAG_HAS_NO_VALUE;
		hasTrdRegTimestampType = FixUtils.TAG_HAS_NO_VALUE;
		hasTrdRegTimestampOrigin = FixUtils.TAG_HAS_NO_VALUE;
		hasDeskType = FixUtils.TAG_HAS_NO_VALUE;
		hasDeskTypeSource = FixUtils.TAG_HAS_NO_VALUE;
		hasDeskOrderHandlingInst = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasTrdRegTimestamp()) {		
			out.put(FixTags.TRDREGTIMESTAMP);

			out.put((byte) '=');

			FixUtils.put(out,trdRegTimestamp); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTrdRegTimestampType()) {		
			out.put(FixTags.TRDREGTIMESTAMPTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)trdRegTimestampType);
		
			out.put(FixUtils.SOH);

            }

		if (hasTrdRegTimestampOrigin()) {		
			out.put(FixTags.TRDREGTIMESTAMPORIGIN);

			out.put((byte) '=');

			FixUtils.put(out,trdRegTimestampOrigin); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDeskType()) {		
			out.put(FixTags.DESKTYPE);

			out.put((byte) '=');

			FixUtils.put(out,deskType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDeskTypeSource()) {		
			out.put(FixTags.DESKTYPESOURCE);

			out.put((byte) '=');

			FixUtils.put(out, (long)deskTypeSource);
		
			out.put(FixUtils.SOH);

            }

		if (hasDeskOrderHandlingInst()) {		
			out.put(FixTags.DESKORDERHANDLINGINST);

			out.put((byte) '=');

			FixUtils.put(out,deskOrderHandlingInst); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasTrdRegTimestamp()) {		
			FixUtils.put(out,trdRegTimestamp); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTrdRegTimestampType()) {		
			FixUtils.put(out, (long)trdRegTimestampType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTrdRegTimestampOrigin()) {		
			FixUtils.put(out,trdRegTimestampOrigin); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDeskType()) {		
			FixUtils.put(out,deskType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDeskTypeSource()) {		
			FixUtils.put(out, (long)deskTypeSource);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDeskOrderHandlingInst()) {		
			FixUtils.put(out,deskOrderHandlingInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getTrdRegTimestamp() { 		
		if ( hasTrdRegTimestamp()) {		
			if (hasTrdRegTimestamp == FixUtils.TAG_HAS_VALUE) {		
				return trdRegTimestamp; 		
			} else {		
		
				buf.position(hasTrdRegTimestamp);		
		
			FixMessage.getTagStringValue(buf, trdRegTimestamp, 0, trdRegTimestamp.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTrdRegTimestamp);		
					return null;		
				}		
			}		
			hasTrdRegTimestamp = FixUtils.TAG_HAS_VALUE;		
			return trdRegTimestamp;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTrdRegTimestamp() { return hasTrdRegTimestamp != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTrdRegTimestamp(byte[] src) {		
		if (src == null ) return;
		if (hasTrdRegTimestamp()) FixUtils.fillSpace(trdRegTimestamp);		
		FixUtils.copy(trdRegTimestamp, src); 		
		hasTrdRegTimestamp = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTrdRegTimestamp(String str) {		
		if (str == null ) return;
		if (hasTrdRegTimestamp()) FixUtils.fillSpace(trdRegTimestamp);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(trdRegTimestamp, src); 		
		hasTrdRegTimestamp = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTrdRegTimestampType() { 		
		if ( hasTrdRegTimestampType()) {		
			if (hasTrdRegTimestampType == FixUtils.TAG_HAS_VALUE) {		
				return trdRegTimestampType; 		
			} else {		
		
				buf.position(hasTrdRegTimestampType);		
		
			trdRegTimestampType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTrdRegTimestampType);		
					return 0;		
				}		
			}		
			hasTrdRegTimestampType = FixUtils.TAG_HAS_VALUE;		
			return trdRegTimestampType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTrdRegTimestampType() { return hasTrdRegTimestampType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTrdRegTimestampType(long src) {		
		trdRegTimestampType = src;
		hasTrdRegTimestampType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdRegTimestampType(byte[] src) {		
		if (src == null ) return;
		if (hasTrdRegTimestampType()) trdRegTimestampType = FixUtils.TAG_HAS_NO_VALUE;		
		trdRegTimestampType = FixUtils.longValueOf(src, 0, src.length);
		hasTrdRegTimestampType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTrdRegTimestampType(String str) {		
		if (str == null ) return;
		if (hasTrdRegTimestampType()) trdRegTimestampType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		trdRegTimestampType = FixUtils.longValueOf(src, 0, src.length);
		hasTrdRegTimestampType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTrdRegTimestampOrigin() { 		
		if ( hasTrdRegTimestampOrigin()) {		
			if (hasTrdRegTimestampOrigin == FixUtils.TAG_HAS_VALUE) {		
				return trdRegTimestampOrigin; 		
			} else {		
		
				buf.position(hasTrdRegTimestampOrigin);		
		
			FixMessage.getTagStringValue(buf, trdRegTimestampOrigin, 0, trdRegTimestampOrigin.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTrdRegTimestampOrigin);		
					return null;		
				}		
			}		
			hasTrdRegTimestampOrigin = FixUtils.TAG_HAS_VALUE;		
			return trdRegTimestampOrigin;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTrdRegTimestampOrigin() { return hasTrdRegTimestampOrigin != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTrdRegTimestampOrigin(byte[] src) {		
		if (src == null ) return;
		if (hasTrdRegTimestampOrigin()) FixUtils.fillSpace(trdRegTimestampOrigin);		
		FixUtils.copy(trdRegTimestampOrigin, src); 		
		hasTrdRegTimestampOrigin = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTrdRegTimestampOrigin(String str) {		
		if (str == null ) return;
		if (hasTrdRegTimestampOrigin()) FixUtils.fillSpace(trdRegTimestampOrigin);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(trdRegTimestampOrigin, src); 		
		hasTrdRegTimestampOrigin = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDeskType() { 		
		if ( hasDeskType()) {		
			if (hasDeskType == FixUtils.TAG_HAS_VALUE) {		
				return deskType; 		
			} else {		
		
				buf.position(hasDeskType);		
		
			FixMessage.getTagStringValue(buf, deskType, 0, deskType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDeskType);		
					return null;		
				}		
			}		
			hasDeskType = FixUtils.TAG_HAS_VALUE;		
			return deskType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDeskType() { return hasDeskType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDeskType(byte[] src) {		
		if (src == null ) return;
		if (hasDeskType()) FixUtils.fillSpace(deskType);		
		FixUtils.copy(deskType, src); 		
		hasDeskType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDeskType(String str) {		
		if (str == null ) return;
		if (hasDeskType()) FixUtils.fillSpace(deskType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(deskType, src); 		
		hasDeskType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDeskTypeSource() { 		
		if ( hasDeskTypeSource()) {		
			if (hasDeskTypeSource == FixUtils.TAG_HAS_VALUE) {		
				return deskTypeSource; 		
			} else {		
		
				buf.position(hasDeskTypeSource);		
		
			deskTypeSource = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDeskTypeSource);		
					return 0;		
				}		
			}		
			hasDeskTypeSource = FixUtils.TAG_HAS_VALUE;		
			return deskTypeSource;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDeskTypeSource() { return hasDeskTypeSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDeskTypeSource(long src) {		
		deskTypeSource = src;
		hasDeskTypeSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDeskTypeSource(byte[] src) {		
		if (src == null ) return;
		if (hasDeskTypeSource()) deskTypeSource = FixUtils.TAG_HAS_NO_VALUE;		
		deskTypeSource = FixUtils.longValueOf(src, 0, src.length);
		hasDeskTypeSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDeskTypeSource(String str) {		
		if (str == null ) return;
		if (hasDeskTypeSource()) deskTypeSource = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		deskTypeSource = FixUtils.longValueOf(src, 0, src.length);
		hasDeskTypeSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDeskOrderHandlingInst() { 		
		if ( hasDeskOrderHandlingInst()) {		
			if (hasDeskOrderHandlingInst == FixUtils.TAG_HAS_VALUE) {		
				return deskOrderHandlingInst; 		
			} else {		
		
				buf.position(hasDeskOrderHandlingInst);		
		
			FixMessage.getTagStringValue(buf, deskOrderHandlingInst, 0, deskOrderHandlingInst.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDeskOrderHandlingInst);		
					return null;		
				}		
			}		
			hasDeskOrderHandlingInst = FixUtils.TAG_HAS_VALUE;		
			return deskOrderHandlingInst;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDeskOrderHandlingInst() { return hasDeskOrderHandlingInst != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDeskOrderHandlingInst(byte[] src) {		
		if (src == null ) return;
		if (hasDeskOrderHandlingInst()) FixUtils.fillSpace(deskOrderHandlingInst);		
		FixUtils.copy(deskOrderHandlingInst, src); 		
		hasDeskOrderHandlingInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDeskOrderHandlingInst(String str) {		
		if (str == null ) return;
		if (hasDeskOrderHandlingInst()) FixUtils.fillSpace(deskOrderHandlingInst);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(deskOrderHandlingInst, src); 		
		hasDeskOrderHandlingInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasTrdRegTimestamp()) s += "TrdRegTimestamp(769)= " + new String( FixUtils.trim(getTrdRegTimestamp()) ) + "\n" ; 
		if (hasTrdRegTimestampType()) s += "TrdRegTimestampType(770)= " + getTrdRegTimestampType() + "\n" ; 
		if (hasTrdRegTimestampOrigin()) s += "TrdRegTimestampOrigin(771)= " + new String( FixUtils.trim(getTrdRegTimestampOrigin()) ) + "\n" ; 
		if (hasDeskType()) s += "DeskType(1033)= " + new String( FixUtils.trim(getDeskType()) ) + "\n" ; 
		if (hasDeskTypeSource()) s += "DeskTypeSource(1034)= " + getDeskTypeSource() + "\n" ; 
		if (hasDeskOrderHandlingInst()) s += "DeskOrderHandlingInst(1035)= " + new String( FixUtils.trim(getDeskOrderHandlingInst()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTrdRegTimestamps)) return false;

		FixTrdRegTimestamps msg = (FixTrdRegTimestamps) o;

		if ((hasTrdRegTimestamp() && !msg.hasTrdRegTimestamp()) || (!hasTrdRegTimestamp() && msg.hasTrdRegTimestamp())) return false;
		if (!(!hasTrdRegTimestamp() && !msg.hasTrdRegTimestamp()) ) return false;
		if ((hasTrdRegTimestampType() && !msg.hasTrdRegTimestampType()) || (!hasTrdRegTimestampType() && msg.hasTrdRegTimestampType())) return false;
		if (!(!hasTrdRegTimestampType() && !msg.hasTrdRegTimestampType()) && !(getTrdRegTimestampType()==msg.getTrdRegTimestampType())) return false;
		if ((hasTrdRegTimestampOrigin() && !msg.hasTrdRegTimestampOrigin()) || (!hasTrdRegTimestampOrigin() && msg.hasTrdRegTimestampOrigin())) return false;
		if (!(!hasTrdRegTimestampOrigin() && !msg.hasTrdRegTimestampOrigin()) && !FixUtils.equals(getTrdRegTimestampOrigin(), msg.getTrdRegTimestampOrigin())) return false;
		if ((hasDeskType() && !msg.hasDeskType()) || (!hasDeskType() && msg.hasDeskType())) return false;
		if (!(!hasDeskType() && !msg.hasDeskType()) && !FixUtils.equals(getDeskType(), msg.getDeskType())) return false;
		if ((hasDeskTypeSource() && !msg.hasDeskTypeSource()) || (!hasDeskTypeSource() && msg.hasDeskTypeSource())) return false;
		if (!(!hasDeskTypeSource() && !msg.hasDeskTypeSource()) && !(getDeskTypeSource()==msg.getDeskTypeSource())) return false;
		if ((hasDeskOrderHandlingInst() && !msg.hasDeskOrderHandlingInst()) || (!hasDeskOrderHandlingInst() && msg.hasDeskOrderHandlingInst())) return false;
		if (!(!hasDeskOrderHandlingInst() && !msg.hasDeskOrderHandlingInst()) && !FixUtils.equals(getDeskOrderHandlingInst(), msg.getDeskOrderHandlingInst())) return false;
		return true;
	}
	public FixTrdRegTimestamps clone ( FixTrdRegTimestamps out ) {
		if ( hasTrdRegTimestamp())
			out.setTrdRegTimestamp(getTrdRegTimestamp());
		if ( hasTrdRegTimestampType())
			out.setTrdRegTimestampType(getTrdRegTimestampType());
		if ( hasTrdRegTimestampOrigin())
			out.setTrdRegTimestampOrigin(getTrdRegTimestampOrigin());
		if ( hasDeskType())
			out.setDeskType(getDeskType());
		if ( hasDeskTypeSource())
			out.setDeskTypeSource(getDeskTypeSource());
		if ( hasDeskOrderHandlingInst())
			out.setDeskOrderHandlingInst(getDeskOrderHandlingInst());
		return out;
	}

}
