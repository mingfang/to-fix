package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixContraGrp extends FixGroup {
	private short hasContraBroker;
	byte[] contraBroker = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasContraTrader;
	byte[] contraTrader = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasContraTradeQty;
	long contraTradeQty = 0;		
	private short hasContraTradeTime;
	byte[] contraTradeTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasContraLegRefID;
	byte[] contraLegRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixContraGrp() {
		this(false);
	}

	public FixContraGrp(boolean isRequired) {
		super(FixTags.CONTRABROKER_INT);

		this.isRequired = isRequired;
		
		hasContraBroker = FixUtils.TAG_HAS_NO_VALUE;		
		contraBroker = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasContraTrader = FixUtils.TAG_HAS_NO_VALUE;		
		contraTrader = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasContraTradeQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasContraTradeTime = FixUtils.TAG_HAS_NO_VALUE;		
		contraTradeTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasContraLegRefID = FixUtils.TAG_HAS_NO_VALUE;		
		contraLegRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasContraBroker()) return true;
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
            	case FixTags.CONTRABROKER_INT:		
            		hasContraBroker = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CONTRATRADER_INT:		
            		hasContraTrader = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CONTRATRADEQTY_INT:		
            		hasContraTradeQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CONTRATRADETIME_INT:		
            		hasContraTradeTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CONTRALEGREFID_INT:		
            		hasContraLegRefID = (short) buf.position();		
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
		hasContraBroker = FixUtils.TAG_HAS_NO_VALUE;
		hasContraTrader = FixUtils.TAG_HAS_NO_VALUE;
		hasContraTradeQty = FixUtils.TAG_HAS_NO_VALUE;
		hasContraTradeTime = FixUtils.TAG_HAS_NO_VALUE;
		hasContraLegRefID = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasContraBroker()) {		
			out.put(FixTags.CONTRABROKER);

			out.put((byte) '=');

			FixUtils.put(out,contraBroker); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasContraTrader()) {		
			out.put(FixTags.CONTRATRADER);

			out.put((byte) '=');

			FixUtils.put(out,contraTrader); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasContraTradeQty()) {		
			out.put(FixTags.CONTRATRADEQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)contraTradeQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasContraTradeTime()) {		
			out.put(FixTags.CONTRATRADETIME);

			out.put((byte) '=');

			FixUtils.put(out,contraTradeTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasContraLegRefID()) {		
			out.put(FixTags.CONTRALEGREFID);

			out.put((byte) '=');

			FixUtils.put(out,contraLegRefID); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasContraBroker()) {		
			FixUtils.put(out,contraBroker); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContraTrader()) {		
			FixUtils.put(out,contraTrader); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContraTradeQty()) {		
			FixUtils.put(out, (long)contraTradeQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContraTradeTime()) {		
			FixUtils.put(out,contraTradeTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContraLegRefID()) {		
			FixUtils.put(out,contraLegRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getContraBroker() { 		
		if ( hasContraBroker()) {		
			if (hasContraBroker == FixUtils.TAG_HAS_VALUE) {		
				return contraBroker; 		
			} else {		
		
				buf.position(hasContraBroker);		
		
			FixMessage.getTagStringValue(buf, contraBroker, 0, contraBroker.length, err);
		
				if (err.hasError()) {		
					buf.position(hasContraBroker);		
					return null;		
				}		
			}		
			hasContraBroker = FixUtils.TAG_HAS_VALUE;		
			return contraBroker;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasContraBroker() { return hasContraBroker != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContraBroker(byte[] src) {		
		if (src == null ) return;
		if (hasContraBroker()) FixUtils.fillNul(contraBroker);		
		FixUtils.copy(contraBroker, src); 		
		hasContraBroker = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContraBroker(String str) {		
		if (str == null ) return;
		if (hasContraBroker()) FixUtils.fillNul(contraBroker);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(contraBroker, src); 		
		hasContraBroker = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getContraTrader() { 		
		if ( hasContraTrader()) {		
			if (hasContraTrader == FixUtils.TAG_HAS_VALUE) {		
				return contraTrader; 		
			} else {		
		
				buf.position(hasContraTrader);		
		
			FixMessage.getTagStringValue(buf, contraTrader, 0, contraTrader.length, err);
		
				if (err.hasError()) {		
					buf.position(hasContraTrader);		
					return null;		
				}		
			}		
			hasContraTrader = FixUtils.TAG_HAS_VALUE;		
			return contraTrader;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasContraTrader() { return hasContraTrader != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContraTrader(byte[] src) {		
		if (src == null ) return;
		if (hasContraTrader()) FixUtils.fillNul(contraTrader);		
		FixUtils.copy(contraTrader, src); 		
		hasContraTrader = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContraTrader(String str) {		
		if (str == null ) return;
		if (hasContraTrader()) FixUtils.fillNul(contraTrader);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(contraTrader, src); 		
		hasContraTrader = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getContraTradeQty() { 		
		if ( hasContraTradeQty()) {		
			if (hasContraTradeQty == FixUtils.TAG_HAS_VALUE) {		
				return contraTradeQty; 		
			} else {		
		
				buf.position(hasContraTradeQty);		
		
			contraTradeQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasContraTradeQty);		
					return 0;		
				}		
			}		
			hasContraTradeQty = FixUtils.TAG_HAS_VALUE;		
			return contraTradeQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasContraTradeQty() { return hasContraTradeQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContraTradeQty(long src) {		
		contraTradeQty = src;
		hasContraTradeQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContraTradeQty(byte[] src) {		
		if (src == null ) return;
		if (hasContraTradeQty()) contraTradeQty = FixUtils.TAG_HAS_NO_VALUE;		
		contraTradeQty = FixUtils.longValueOf(src, 0, src.length);
		hasContraTradeQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContraTradeQty(String str) {		
		if (str == null ) return;
		if (hasContraTradeQty()) contraTradeQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		contraTradeQty = FixUtils.longValueOf(src, 0, src.length);
		hasContraTradeQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getContraTradeTime() { 		
		if ( hasContraTradeTime()) {		
			if (hasContraTradeTime == FixUtils.TAG_HAS_VALUE) {		
				return contraTradeTime; 		
			} else {		
		
				buf.position(hasContraTradeTime);		
		
			FixMessage.getTagStringValue(buf, contraTradeTime, 0, contraTradeTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasContraTradeTime);		
					return null;		
				}		
			}		
			hasContraTradeTime = FixUtils.TAG_HAS_VALUE;		
			return contraTradeTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasContraTradeTime() { return hasContraTradeTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContraTradeTime(byte[] src) {		
		if (src == null ) return;
		if (hasContraTradeTime()) FixUtils.fillNul(contraTradeTime);		
		FixUtils.copy(contraTradeTime, src); 		
		hasContraTradeTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContraTradeTime(String str) {		
		if (str == null ) return;
		if (hasContraTradeTime()) FixUtils.fillNul(contraTradeTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(contraTradeTime, src); 		
		hasContraTradeTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getContraLegRefID() { 		
		if ( hasContraLegRefID()) {		
			if (hasContraLegRefID == FixUtils.TAG_HAS_VALUE) {		
				return contraLegRefID; 		
			} else {		
		
				buf.position(hasContraLegRefID);		
		
			FixMessage.getTagStringValue(buf, contraLegRefID, 0, contraLegRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasContraLegRefID);		
					return null;		
				}		
			}		
			hasContraLegRefID = FixUtils.TAG_HAS_VALUE;		
			return contraLegRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasContraLegRefID() { return hasContraLegRefID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContraLegRefID(byte[] src) {		
		if (src == null ) return;
		if (hasContraLegRefID()) FixUtils.fillNul(contraLegRefID);		
		FixUtils.copy(contraLegRefID, src); 		
		hasContraLegRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContraLegRefID(String str) {		
		if (str == null ) return;
		if (hasContraLegRefID()) FixUtils.fillNul(contraLegRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(contraLegRefID, src); 		
		hasContraLegRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasContraBroker()) s += "ContraBroker(375)= " + new String( FixUtils.trim(getContraBroker()) ) + "\n" ; 
		if (hasContraTrader()) s += "ContraTrader(337)= " + new String( FixUtils.trim(getContraTrader()) ) + "\n" ; 
		if (hasContraTradeQty()) s += "ContraTradeQty(437)= " + getContraTradeQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasContraTradeTime()) s += "ContraTradeTime(438)= " + new String( FixUtils.trim(getContraTradeTime()) ) + "\n" ; 
		if (hasContraLegRefID()) s += "ContraLegRefID(655)= " + new String( FixUtils.trim(getContraLegRefID()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixContraGrp)) return false;

		FixContraGrp msg = (FixContraGrp) o;

		if ((hasContraBroker() && !msg.hasContraBroker()) || (!hasContraBroker() && msg.hasContraBroker())) return false;
		if (!(!hasContraBroker() && !msg.hasContraBroker()) && !FixUtils.equals(getContraBroker(), msg.getContraBroker())) return false;
		if ((hasContraTrader() && !msg.hasContraTrader()) || (!hasContraTrader() && msg.hasContraTrader())) return false;
		if (!(!hasContraTrader() && !msg.hasContraTrader()) && !FixUtils.equals(getContraTrader(), msg.getContraTrader())) return false;
		if ((hasContraTradeQty() && !msg.hasContraTradeQty()) || (!hasContraTradeQty() && msg.hasContraTradeQty())) return false;
		if (!(!hasContraTradeQty() && !msg.hasContraTradeQty()) && !(getContraTradeQty()==msg.getContraTradeQty())) return false;
		if ((hasContraTradeTime() && !msg.hasContraTradeTime()) || (!hasContraTradeTime() && msg.hasContraTradeTime())) return false;
		if ((hasContraLegRefID() && !msg.hasContraLegRefID()) || (!hasContraLegRefID() && msg.hasContraLegRefID())) return false;
		if (!(!hasContraLegRefID() && !msg.hasContraLegRefID()) && !FixUtils.equals(getContraLegRefID(), msg.getContraLegRefID())) return false;
		return true;
	}
	public FixContraGrp clone ( FixContraGrp out ) {
		if ( hasContraBroker())
			out.setContraBroker(getContraBroker());
		if ( hasContraTrader())
			out.setContraTrader(getContraTrader());
		if ( hasContraTradeQty())
			out.setContraTradeQty(getContraTradeQty());
		if ( hasContraTradeTime())
			out.setContraTradeTime(getContraTradeTime());
		if ( hasContraLegRefID())
			out.setContraLegRefID(getContraLegRefID());
		return out;
	}

}
