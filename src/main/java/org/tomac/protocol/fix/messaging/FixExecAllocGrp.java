package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixExecAllocGrp extends FixGroup {
	private short hasLastQty;
	long lastQty = 0;		
	private short hasExecID;
	byte[] execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryExecID;
	byte[] secondaryExecID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLastPx;
	long lastPx = 0;		
	private short hasLastParPx;
	long lastParPx = 0;		
	private short hasLastCapacity;
	byte lastCapacity = (byte)' ';		
	private short hasTradeID;
	byte[] tradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasFirmTradeID;
	byte[] firmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixExecAllocGrp() {
		this(false);
	}

	public FixExecAllocGrp(boolean isRequired) {
		super(FixTags.LASTQTY_INT);

		this.isRequired = isRequired;
		
		hasLastQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasExecID = FixUtils.TAG_HAS_NO_VALUE;		
		execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryExecID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryExecID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLastPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastParPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLastCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasFirmTradeID = FixUtils.TAG_HAS_NO_VALUE;		
		firmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasLastQty()) return true;
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
            	case FixTags.LASTQTY_INT:		
            		hasLastQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.EXECID_INT:		
            		hasExecID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYEXECID_INT:		
            		hasSecondaryExecID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LASTPX_INT:		
            		hasLastPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LASTPARPX_INT:		
            		hasLastParPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LASTCAPACITY_INT:		
            		hasLastCapacity = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADEID_INT:		
            		hasTradeID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.FIRMTRADEID_INT:		
            		hasFirmTradeID = (short) buf.position();		
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
		hasLastQty = FixUtils.TAG_HAS_NO_VALUE;
		hasExecID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryExecID = FixUtils.TAG_HAS_NO_VALUE;
		hasLastPx = FixUtils.TAG_HAS_NO_VALUE;
		hasLastParPx = FixUtils.TAG_HAS_NO_VALUE;
		hasLastCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeID = FixUtils.TAG_HAS_NO_VALUE;
		hasFirmTradeID = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasLastQty()) {		
			out.put(FixTags.LASTQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)lastQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasExecID()) {		
			out.put(FixTags.EXECID);

			out.put((byte) '=');

			FixUtils.put(out,execID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecondaryExecID()) {		
			out.put(FixTags.SECONDARYEXECID);

			out.put((byte) '=');

			FixUtils.put(out,secondaryExecID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLastPx()) {		
			out.put(FixTags.LASTPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)lastPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasLastParPx()) {		
			out.put(FixTags.LASTPARPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)lastParPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasLastCapacity()) {		
			out.put(FixTags.LASTCAPACITY);

			out.put((byte) '=');

			FixUtils.put(out,lastCapacity); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradeID()) {		
			out.put(FixTags.TRADEID);

			out.put((byte) '=');

			FixUtils.put(out,tradeID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasFirmTradeID()) {		
			out.put(FixTags.FIRMTRADEID);

			out.put((byte) '=');

			FixUtils.put(out,firmTradeID); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasLastQty()) {		
			FixUtils.put(out, (long)lastQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecID()) {		
			FixUtils.put(out,execID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryExecID()) {		
			FixUtils.put(out,secondaryExecID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastPx()) {		
			FixUtils.put(out, (long)lastPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastParPx()) {		
			FixUtils.put(out, (long)lastParPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastCapacity()) {		
			FixUtils.put(out,lastCapacity); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeID()) {		
			FixUtils.put(out,tradeID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFirmTradeID()) {		
			FixUtils.put(out,firmTradeID); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getLastQty() { 		
		if ( hasLastQty()) {		
			if (hasLastQty == FixUtils.TAG_HAS_VALUE) {		
				return lastQty; 		
			} else {		
		
				buf.position(hasLastQty);		
		
			lastQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLastQty);		
					return 0;		
				}		
			}		
			hasLastQty = FixUtils.TAG_HAS_VALUE;		
			return lastQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastQty() { return hasLastQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLastQty(long src) {		
		lastQty = src;
		hasLastQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastQty(byte[] src) {		
		if (src == null ) return;
		if (hasLastQty()) lastQty = FixUtils.TAG_HAS_NO_VALUE;		
		lastQty = FixUtils.longValueOf(src, 0, src.length);
		hasLastQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLastQty(String str) {		
		if (str == null ) return;
		if (hasLastQty()) lastQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastQty = FixUtils.longValueOf(src, 0, src.length);
		hasLastQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getExecID() { 		
		if ( hasExecID()) {		
			if (hasExecID == FixUtils.TAG_HAS_VALUE) {		
				return execID; 		
			} else {		
		
				buf.position(hasExecID);		
		
			FixUtils.getTagStringValue(buf, execID, 0, execID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasExecID);		
					return null;		
				}		
			}		
			hasExecID = FixUtils.TAG_HAS_VALUE;		
			return execID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExecID() { return hasExecID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setExecID(byte[] src) {		
		if (src == null ) return;
		if (hasExecID()) FixUtils.fillNul(execID);		
		FixUtils.copy(execID, src); 		
		hasExecID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setExecID(String str) {		
		if (str == null ) return;
		if (hasExecID()) FixUtils.fillNul(execID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(execID, src); 		
		hasExecID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecondaryExecID() { 		
		if ( hasSecondaryExecID()) {		
			if (hasSecondaryExecID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryExecID; 		
			} else {		
		
				buf.position(hasSecondaryExecID);		
		
			FixUtils.getTagStringValue(buf, secondaryExecID, 0, secondaryExecID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryExecID);		
					return null;		
				}		
			}		
			hasSecondaryExecID = FixUtils.TAG_HAS_VALUE;		
			return secondaryExecID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryExecID() { return hasSecondaryExecID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecondaryExecID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryExecID()) FixUtils.fillNul(secondaryExecID);		
		FixUtils.copy(secondaryExecID, src); 		
		hasSecondaryExecID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryExecID(String str) {		
		if (str == null ) return;
		if (hasSecondaryExecID()) FixUtils.fillNul(secondaryExecID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryExecID, src); 		
		hasSecondaryExecID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLastPx() { 		
		if ( hasLastPx()) {		
			if (hasLastPx == FixUtils.TAG_HAS_VALUE) {		
				return lastPx; 		
			} else {		
		
				buf.position(hasLastPx);		
		
			lastPx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLastPx);		
					return 0;		
				}		
			}		
			hasLastPx = FixUtils.TAG_HAS_VALUE;		
			return lastPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastPx() { return hasLastPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLastPx(long src) {		
		lastPx = src;
		hasLastPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastPx(byte[] src) {		
		if (src == null ) return;
		if (hasLastPx()) lastPx = FixUtils.TAG_HAS_NO_VALUE;		
		lastPx = FixUtils.longValueOf(src, 0, src.length);
		hasLastPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLastPx(String str) {		
		if (str == null ) return;
		if (hasLastPx()) lastPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastPx = FixUtils.longValueOf(src, 0, src.length);
		hasLastPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLastParPx() { 		
		if ( hasLastParPx()) {		
			if (hasLastParPx == FixUtils.TAG_HAS_VALUE) {		
				return lastParPx; 		
			} else {		
		
				buf.position(hasLastParPx);		
		
			lastParPx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLastParPx);		
					return 0;		
				}		
			}		
			hasLastParPx = FixUtils.TAG_HAS_VALUE;		
			return lastParPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLastParPx() { return hasLastParPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLastParPx(long src) {		
		lastParPx = src;
		hasLastParPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastParPx(byte[] src) {		
		if (src == null ) return;
		if (hasLastParPx()) lastParPx = FixUtils.TAG_HAS_NO_VALUE;		
		lastParPx = FixUtils.longValueOf(src, 0, src.length);
		hasLastParPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLastParPx(String str) {		
		if (str == null ) return;
		if (hasLastParPx()) lastParPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		lastParPx = FixUtils.longValueOf(src, 0, src.length);
		hasLastParPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getLastCapacity() { 		
		if ( hasLastCapacity()) {		
			if (hasLastCapacity == FixUtils.TAG_HAS_VALUE) {		
				return lastCapacity; 		
			} else {		
		
				buf.position(hasLastCapacity);		
		
			lastCapacity = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (lastCapacity != (byte)'3') && (lastCapacity != (byte)'2') && (lastCapacity != (byte)'1') && (lastCapacity != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 29);		
				if (err.hasError()) {		
					buf.position(hasLastCapacity);		
					return (byte)'0';		
				}		
			}		
			hasLastCapacity = FixUtils.TAG_HAS_VALUE;		
			return lastCapacity;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasLastCapacity() { return hasLastCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLastCapacity(byte src) {		
		lastCapacity = src;
		hasLastCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLastCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasLastCapacity()) lastCapacity = (byte)' ';		
		lastCapacity = src[0];		
		hasLastCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLastCapacity(String str) {		
		if (str == null ) return;
		if (hasLastCapacity()) lastCapacity = (byte)' ';		
		byte[] src = str.getBytes(); 		
		lastCapacity = src[0];		
		hasLastCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradeID() { 		
		if ( hasTradeID()) {		
			if (hasTradeID == FixUtils.TAG_HAS_VALUE) {		
				return tradeID; 		
			} else {		
		
				buf.position(hasTradeID);		
		
			FixUtils.getTagStringValue(buf, tradeID, 0, tradeID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradeID);		
					return null;		
				}		
			}		
			hasTradeID = FixUtils.TAG_HAS_VALUE;		
			return tradeID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeID() { return hasTradeID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradeID(byte[] src) {		
		if (src == null ) return;
		if (hasTradeID()) FixUtils.fillNul(tradeID);		
		FixUtils.copy(tradeID, src); 		
		hasTradeID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradeID(String str) {		
		if (str == null ) return;
		if (hasTradeID()) FixUtils.fillNul(tradeID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeID, src); 		
		hasTradeID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getFirmTradeID() { 		
		if ( hasFirmTradeID()) {		
			if (hasFirmTradeID == FixUtils.TAG_HAS_VALUE) {		
				return firmTradeID; 		
			} else {		
		
				buf.position(hasFirmTradeID);		
		
			FixUtils.getTagStringValue(buf, firmTradeID, 0, firmTradeID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasFirmTradeID);		
					return null;		
				}		
			}		
			hasFirmTradeID = FixUtils.TAG_HAS_VALUE;		
			return firmTradeID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasFirmTradeID() { return hasFirmTradeID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFirmTradeID(byte[] src) {		
		if (src == null ) return;
		if (hasFirmTradeID()) FixUtils.fillNul(firmTradeID);		
		FixUtils.copy(firmTradeID, src); 		
		hasFirmTradeID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFirmTradeID(String str) {		
		if (str == null ) return;
		if (hasFirmTradeID()) FixUtils.fillNul(firmTradeID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(firmTradeID, src); 		
		hasFirmTradeID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasLastQty()) s += "LastQty(32)= " + getLastQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasExecID()) s += "ExecID(17)= " + new String( FixUtils.trim(getExecID()) ) + "\n" ; 
		if (hasSecondaryExecID()) s += "SecondaryExecID(527)= " + new String( FixUtils.trim(getSecondaryExecID()) ) + "\n" ; 
		if (hasLastPx()) s += "LastPx(31)= " + getLastPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastParPx()) s += "LastParPx(669)= " + getLastParPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLastCapacity()) s += "LastCapacity(29)= " + getLastCapacity() + "\n" ; 
		if (hasTradeID()) s += "TradeID(1003)= " + new String( FixUtils.trim(getTradeID()) ) + "\n" ; 
		if (hasFirmTradeID()) s += "FirmTradeID(1041)= " + new String( FixUtils.trim(getFirmTradeID()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixExecAllocGrp)) return false;

		FixExecAllocGrp msg = (FixExecAllocGrp) o;

		if ((hasLastQty() && !msg.hasLastQty()) || (!hasLastQty() && msg.hasLastQty())) return false;
		if (!(!hasLastQty() && !msg.hasLastQty()) && !(getLastQty()==msg.getLastQty())) return false;
		if ((hasExecID() && !msg.hasExecID()) || (!hasExecID() && msg.hasExecID())) return false;
		if (!(!hasExecID() && !msg.hasExecID()) && !FixUtils.equals(getExecID(), msg.getExecID())) return false;
		if ((hasSecondaryExecID() && !msg.hasSecondaryExecID()) || (!hasSecondaryExecID() && msg.hasSecondaryExecID())) return false;
		if (!(!hasSecondaryExecID() && !msg.hasSecondaryExecID()) && !FixUtils.equals(getSecondaryExecID(), msg.getSecondaryExecID())) return false;
		if ((hasLastPx() && !msg.hasLastPx()) || (!hasLastPx() && msg.hasLastPx())) return false;
		if (!(!hasLastPx() && !msg.hasLastPx()) && !(getLastPx()==msg.getLastPx())) return false;
		if ((hasLastParPx() && !msg.hasLastParPx()) || (!hasLastParPx() && msg.hasLastParPx())) return false;
		if (!(!hasLastParPx() && !msg.hasLastParPx()) && !(getLastParPx()==msg.getLastParPx())) return false;
		if ((hasLastCapacity() && !msg.hasLastCapacity()) || (!hasLastCapacity() && msg.hasLastCapacity())) return false;
		if (!(!hasLastCapacity() && !msg.hasLastCapacity()) && !(getLastCapacity()==msg.getLastCapacity())) return false;
		if ((hasTradeID() && !msg.hasTradeID()) || (!hasTradeID() && msg.hasTradeID())) return false;
		if (!(!hasTradeID() && !msg.hasTradeID()) && !FixUtils.equals(getTradeID(), msg.getTradeID())) return false;
		if ((hasFirmTradeID() && !msg.hasFirmTradeID()) || (!hasFirmTradeID() && msg.hasFirmTradeID())) return false;
		if (!(!hasFirmTradeID() && !msg.hasFirmTradeID()) && !FixUtils.equals(getFirmTradeID(), msg.getFirmTradeID())) return false;
		return true;
	}
	public FixExecAllocGrp clone ( FixExecAllocGrp out ) {
		if ( hasLastQty())
			out.setLastQty(getLastQty());
		if ( hasExecID())
			out.setExecID(getExecID());
		if ( hasSecondaryExecID())
			out.setSecondaryExecID(getSecondaryExecID());
		if ( hasLastPx())
			out.setLastPx(getLastPx());
		if ( hasLastParPx())
			out.setLastParPx(getLastParPx());
		if ( hasLastCapacity())
			out.setLastCapacity(getLastCapacity());
		if ( hasTradeID())
			out.setTradeID(getTradeID());
		if ( hasFirmTradeID())
			out.setFirmTradeID(getFirmTradeID());
		return out;
	}

}
