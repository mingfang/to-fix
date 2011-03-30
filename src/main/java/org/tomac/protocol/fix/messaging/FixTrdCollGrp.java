package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTrdCollGrp extends FixGroup {
	private short hasTradeReportID;
	byte[] tradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryTradeReportID;
	byte[] secondaryTradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixTrdCollGrp() {
		this(false);
	}

	public FixTrdCollGrp(boolean isRequired) {
		super(FixTags.TRADEREPORTID_INT);

		this.isRequired = isRequired;
		
		hasTradeReportID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryTradeReportID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryTradeReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasTradeReportID()) return true;
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
            	case FixTags.TRADEREPORTID_INT:		
            		hasTradeReportID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYTRADEREPORTID_INT:		
            		hasSecondaryTradeReportID = (short) buf.position();		
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
		hasTradeReportID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryTradeReportID = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasTradeReportID()) {		
			out.put(FixTags.TRADEREPORTID);

			out.put((byte) '=');

			FixUtils.put(out,tradeReportID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecondaryTradeReportID()) {		
			out.put(FixTags.SECONDARYTRADEREPORTID);

			out.put((byte) '=');

			FixUtils.put(out,secondaryTradeReportID); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasTradeReportID()) {		
			FixUtils.put(out,tradeReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryTradeReportID()) {		
			FixUtils.put(out,secondaryTradeReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getTradeReportID() { 		
		if ( hasTradeReportID()) {		
			if (hasTradeReportID == FixUtils.TAG_HAS_VALUE) {		
				return tradeReportID; 		
			} else {		
		
				buf.position(hasTradeReportID);		
		
			FixMessage.getTagStringValue(buf, tradeReportID, 0, tradeReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradeReportID);		
					return null;		
				}		
			}		
			hasTradeReportID = FixUtils.TAG_HAS_VALUE;		
			return tradeReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeReportID() { return hasTradeReportID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradeReportID(byte[] src) {		
		if (src == null ) return;
		if (hasTradeReportID()) FixUtils.fillSpace(tradeReportID);		
		FixUtils.copy(tradeReportID, src); 		
		hasTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradeReportID(String str) {		
		if (str == null ) return;
		if (hasTradeReportID()) FixUtils.fillSpace(tradeReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeReportID, src); 		
		hasTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecondaryTradeReportID() { 		
		if ( hasSecondaryTradeReportID()) {		
			if (hasSecondaryTradeReportID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryTradeReportID; 		
			} else {		
		
				buf.position(hasSecondaryTradeReportID);		
		
			FixMessage.getTagStringValue(buf, secondaryTradeReportID, 0, secondaryTradeReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryTradeReportID);		
					return null;		
				}		
			}		
			hasSecondaryTradeReportID = FixUtils.TAG_HAS_VALUE;		
			return secondaryTradeReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryTradeReportID() { return hasSecondaryTradeReportID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecondaryTradeReportID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryTradeReportID()) FixUtils.fillSpace(secondaryTradeReportID);		
		FixUtils.copy(secondaryTradeReportID, src); 		
		hasSecondaryTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryTradeReportID(String str) {		
		if (str == null ) return;
		if (hasSecondaryTradeReportID()) FixUtils.fillSpace(secondaryTradeReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryTradeReportID, src); 		
		hasSecondaryTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasTradeReportID()) s += "TradeReportID(571)= " + new String( FixUtils.trim(getTradeReportID()) ) + "\n" ; 
		if (hasSecondaryTradeReportID()) s += "SecondaryTradeReportID(818)= " + new String( FixUtils.trim(getSecondaryTradeReportID()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTrdCollGrp)) return false;

		FixTrdCollGrp msg = (FixTrdCollGrp) o;

		if ((hasTradeReportID() && !msg.hasTradeReportID()) || (!hasTradeReportID() && msg.hasTradeReportID())) return false;
		if (!(!hasTradeReportID() && !msg.hasTradeReportID()) && !FixUtils.equals(getTradeReportID(), msg.getTradeReportID())) return false;
		if ((hasSecondaryTradeReportID() && !msg.hasSecondaryTradeReportID()) || (!hasSecondaryTradeReportID() && msg.hasSecondaryTradeReportID())) return false;
		if (!(!hasSecondaryTradeReportID() && !msg.hasSecondaryTradeReportID()) && !FixUtils.equals(getSecondaryTradeReportID(), msg.getSecondaryTradeReportID())) return false;
		return true;
	}
	public FixTrdCollGrp clone ( FixTrdCollGrp out ) {
		if ( hasTradeReportID())
			out.setTradeReportID(getTradeReportID());
		if ( hasSecondaryTradeReportID())
			out.setSecondaryTradeReportID(getSecondaryTradeReportID());
		return out;
	}

}
