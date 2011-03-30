package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixUnderlyingAmount extends FixGroup {
	private short hasUnderlyingPayAmount;
	long underlyingPayAmount = 0;		
	private short hasUnderlyingCollectAmount;
	long underlyingCollectAmount = 0;		
	private short hasUnderlyingSettlementDate;
	byte[] underlyingSettlementDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingSettlementStatus;
	byte[] underlyingSettlementStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixUnderlyingAmount() {
		this(false);
	}

	public FixUnderlyingAmount(boolean isRequired) {
		super(FixTags.UNDERLYINGPAYAMOUNT_INT);

		this.isRequired = isRequired;
		
		hasUnderlyingPayAmount = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingCollectAmount = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingSettlementDate = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSettlementDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingSettlementStatus = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingSettlementStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasUnderlyingPayAmount()) return true;
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
            	case FixTags.UNDERLYINGPAYAMOUNT_INT:		
            		hasUnderlyingPayAmount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGCOLLECTAMOUNT_INT:		
            		hasUnderlyingCollectAmount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSETTLEMENTDATE_INT:		
            		hasUnderlyingSettlementDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGSETTLEMENTSTATUS_INT:		
            		hasUnderlyingSettlementStatus = (short) buf.position();		
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
		hasUnderlyingPayAmount = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingCollectAmount = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSettlementDate = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingSettlementStatus = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasUnderlyingPayAmount()) {		
			out.put(FixTags.UNDERLYINGPAYAMOUNT);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingPayAmount);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingCollectAmount()) {		
			out.put(FixTags.UNDERLYINGCOLLECTAMOUNT);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingCollectAmount);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSettlementDate()) {		
			out.put(FixTags.UNDERLYINGSETTLEMENTDATE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSettlementDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingSettlementStatus()) {		
			out.put(FixTags.UNDERLYINGSETTLEMENTSTATUS);

			out.put((byte) '=');

			FixUtils.put(out,underlyingSettlementStatus); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasUnderlyingPayAmount()) {		
			FixUtils.put(out, (long)underlyingPayAmount);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingCollectAmount()) {		
			FixUtils.put(out, (long)underlyingCollectAmount);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSettlementDate()) {		
			FixUtils.put(out,underlyingSettlementDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingSettlementStatus()) {		
			FixUtils.put(out,underlyingSettlementStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getUnderlyingPayAmount() { 		
		if ( hasUnderlyingPayAmount()) {		
			if (hasUnderlyingPayAmount == FixUtils.TAG_HAS_VALUE) {		
				return underlyingPayAmount; 		
			} else {		
		
				buf.position(hasUnderlyingPayAmount);		
		
			underlyingPayAmount = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingPayAmount);		
					return 0;		
				}		
			}		
			hasUnderlyingPayAmount = FixUtils.TAG_HAS_VALUE;		
			return underlyingPayAmount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingPayAmount() { return hasUnderlyingPayAmount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingPayAmount(long src) {		
		underlyingPayAmount = src;
		hasUnderlyingPayAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingPayAmount(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingPayAmount()) underlyingPayAmount = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingPayAmount = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingPayAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingPayAmount(String str) {		
		if (str == null ) return;
		if (hasUnderlyingPayAmount()) underlyingPayAmount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingPayAmount = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingPayAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingCollectAmount() { 		
		if ( hasUnderlyingCollectAmount()) {		
			if (hasUnderlyingCollectAmount == FixUtils.TAG_HAS_VALUE) {		
				return underlyingCollectAmount; 		
			} else {		
		
				buf.position(hasUnderlyingCollectAmount);		
		
			underlyingCollectAmount = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingCollectAmount);		
					return 0;		
				}		
			}		
			hasUnderlyingCollectAmount = FixUtils.TAG_HAS_VALUE;		
			return underlyingCollectAmount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingCollectAmount() { return hasUnderlyingCollectAmount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingCollectAmount(long src) {		
		underlyingCollectAmount = src;
		hasUnderlyingCollectAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingCollectAmount(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingCollectAmount()) underlyingCollectAmount = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingCollectAmount = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingCollectAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingCollectAmount(String str) {		
		if (str == null ) return;
		if (hasUnderlyingCollectAmount()) underlyingCollectAmount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingCollectAmount = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingCollectAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingSettlementDate() { 		
		if ( hasUnderlyingSettlementDate()) {		
			if (hasUnderlyingSettlementDate == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSettlementDate; 		
			} else {		
		
				buf.position(hasUnderlyingSettlementDate);		
		
			FixMessage.getTagStringValue(buf, underlyingSettlementDate, 0, underlyingSettlementDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSettlementDate);		
					return null;		
				}		
			}		
			hasUnderlyingSettlementDate = FixUtils.TAG_HAS_VALUE;		
			return underlyingSettlementDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSettlementDate() { return hasUnderlyingSettlementDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSettlementDate(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSettlementDate()) FixUtils.fillSpace(underlyingSettlementDate);		
		FixUtils.copy(underlyingSettlementDate, src); 		
		hasUnderlyingSettlementDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSettlementDate(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSettlementDate()) FixUtils.fillSpace(underlyingSettlementDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSettlementDate, src); 		
		hasUnderlyingSettlementDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingSettlementStatus() { 		
		if ( hasUnderlyingSettlementStatus()) {		
			if (hasUnderlyingSettlementStatus == FixUtils.TAG_HAS_VALUE) {		
				return underlyingSettlementStatus; 		
			} else {		
		
				buf.position(hasUnderlyingSettlementStatus);		
		
			FixMessage.getTagStringValue(buf, underlyingSettlementStatus, 0, underlyingSettlementStatus.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingSettlementStatus);		
					return null;		
				}		
			}		
			hasUnderlyingSettlementStatus = FixUtils.TAG_HAS_VALUE;		
			return underlyingSettlementStatus;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingSettlementStatus() { return hasUnderlyingSettlementStatus != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingSettlementStatus(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingSettlementStatus()) FixUtils.fillSpace(underlyingSettlementStatus);		
		FixUtils.copy(underlyingSettlementStatus, src); 		
		hasUnderlyingSettlementStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingSettlementStatus(String str) {		
		if (str == null ) return;
		if (hasUnderlyingSettlementStatus()) FixUtils.fillSpace(underlyingSettlementStatus);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingSettlementStatus, src); 		
		hasUnderlyingSettlementStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasUnderlyingPayAmount()) s += "UnderlyingPayAmount(985)= " + getUnderlyingPayAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingCollectAmount()) s += "UnderlyingCollectAmount(986)= " + getUnderlyingCollectAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingSettlementDate()) s += "UnderlyingSettlementDate(987)= " + new String( FixUtils.trim(getUnderlyingSettlementDate()) ) + "\n" ; 
		if (hasUnderlyingSettlementStatus()) s += "UnderlyingSettlementStatus(988)= " + new String( FixUtils.trim(getUnderlyingSettlementStatus()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUnderlyingAmount)) return false;

		FixUnderlyingAmount msg = (FixUnderlyingAmount) o;

		if ((hasUnderlyingPayAmount() && !msg.hasUnderlyingPayAmount()) || (!hasUnderlyingPayAmount() && msg.hasUnderlyingPayAmount())) return false;
		if (!(!hasUnderlyingPayAmount() && !msg.hasUnderlyingPayAmount()) && !(getUnderlyingPayAmount()==msg.getUnderlyingPayAmount())) return false;
		if ((hasUnderlyingCollectAmount() && !msg.hasUnderlyingCollectAmount()) || (!hasUnderlyingCollectAmount() && msg.hasUnderlyingCollectAmount())) return false;
		if (!(!hasUnderlyingCollectAmount() && !msg.hasUnderlyingCollectAmount()) && !(getUnderlyingCollectAmount()==msg.getUnderlyingCollectAmount())) return false;
		if ((hasUnderlyingSettlementDate() && !msg.hasUnderlyingSettlementDate()) || (!hasUnderlyingSettlementDate() && msg.hasUnderlyingSettlementDate())) return false;
		if (!(!hasUnderlyingSettlementDate() && !msg.hasUnderlyingSettlementDate()) ) return false;
		if ((hasUnderlyingSettlementStatus() && !msg.hasUnderlyingSettlementStatus()) || (!hasUnderlyingSettlementStatus() && msg.hasUnderlyingSettlementStatus())) return false;
		if (!(!hasUnderlyingSettlementStatus() && !msg.hasUnderlyingSettlementStatus()) && !FixUtils.equals(getUnderlyingSettlementStatus(), msg.getUnderlyingSettlementStatus())) return false;
		return true;
	}
	public FixUnderlyingAmount clone ( FixUnderlyingAmount out ) {
		if ( hasUnderlyingPayAmount())
			out.setUnderlyingPayAmount(getUnderlyingPayAmount());
		if ( hasUnderlyingCollectAmount())
			out.setUnderlyingCollectAmount(getUnderlyingCollectAmount());
		if ( hasUnderlyingSettlementDate())
			out.setUnderlyingSettlementDate(getUnderlyingSettlementDate());
		if ( hasUnderlyingSettlementStatus())
			out.setUnderlyingSettlementStatus(getUnderlyingSettlementStatus());
		return out;
	}

}
