package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixCommissionData extends FixGroup {
	private short hasCommission;
	long commission = 0;		
	private short hasCommType;
	byte commType = (byte)' ';		
	private short hasCommCurrency;
	byte[] commCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasFundRenewWaiv;
	byte fundRenewWaiv = (byte)' ';		
	
	public FixCommissionData() {
		super(FixTags.COMMISSION_INT);

		
		hasCommission = FixUtils.TAG_HAS_NO_VALUE;		
		hasCommType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCommCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		commCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasFundRenewWaiv = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasCommission()) return true;
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
            	case FixTags.COMMISSION_INT:		
            		hasCommission = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.COMMTYPE_INT:		
            		hasCommType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.COMMCURRENCY_INT:		
            		hasCommCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.FUNDRENEWWAIV_INT:		
            		hasFundRenewWaiv = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasCommission = FixUtils.TAG_HAS_NO_VALUE;
		hasCommType = FixUtils.TAG_HAS_NO_VALUE;
		hasCommCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasFundRenewWaiv = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasCommission()) {		
			out.put(FixTags.COMMISSION);

			out.put((byte) '=');

			FixUtils.put(out, (long)commission);
		
			out.put(FixUtils.SOH);

            }

		if (hasCommType()) {		
			out.put(FixTags.COMMTYPE);

			out.put((byte) '=');

			FixUtils.put(out,commType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCommCurrency()) {		
			out.put(FixTags.COMMCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,commCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasFundRenewWaiv()) {		
			out.put(FixTags.FUNDRENEWWAIV);

			out.put((byte) '=');

			FixUtils.put(out,fundRenewWaiv); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasCommission()) {		
			FixUtils.put(out, (long)commission);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCommType()) {		
			FixUtils.put(out,commType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCommCurrency()) {		
			FixUtils.put(out,commCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFundRenewWaiv()) {		
			FixUtils.put(out,fundRenewWaiv); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getCommission() { 		
		if ( hasCommission()) {		
			if (hasCommission == FixUtils.TAG_HAS_VALUE) {		
				return commission; 		
			} else {		
		
				buf.position(hasCommission);		
		
			commission = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasCommission);		
					return 0;		
				}		
			}		
			hasCommission = FixUtils.TAG_HAS_VALUE;		
			return commission;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCommission() { return hasCommission != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCommission(long src) {		
		commission = src;
		hasCommission = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCommission(byte[] src) {		
		if (src == null ) return;
		if (hasCommission()) commission = FixUtils.TAG_HAS_NO_VALUE;		
		commission = FixUtils.longValueOf(src, 0, src.length);
		hasCommission = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCommission(String str) {		
		if (str == null ) return;
		if (hasCommission()) commission = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		commission = FixUtils.longValueOf(src, 0, src.length);
		hasCommission = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getCommType() { 		
		if ( hasCommType()) {		
			if (hasCommType == FixUtils.TAG_HAS_VALUE) {		
				return commType; 		
			} else {		
		
				buf.position(hasCommType);		
		
			commType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (commType != (byte)'3') && (commType != (byte)'2') && (commType != (byte)'1') && (commType != (byte)'6') && (commType != (byte)'5') && (commType != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 13);		
				if (err.hasError()) {		
					buf.position(hasCommType);		
					return (byte)'0';		
				}		
			}		
			hasCommType = FixUtils.TAG_HAS_VALUE;		
			return commType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasCommType() { return hasCommType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCommType(byte src) {		
		commType = src;
		hasCommType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCommType(byte[] src) {		
		if (src == null ) return;
		if (hasCommType()) commType = (byte)' ';		
		commType = src[0];		
		hasCommType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCommType(String str) {		
		if (str == null ) return;
		if (hasCommType()) commType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		commType = src[0];		
		hasCommType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCommCurrency() { 		
		if ( hasCommCurrency()) {		
			if (hasCommCurrency == FixUtils.TAG_HAS_VALUE) {		
				return commCurrency; 		
			} else {		
		
				buf.position(hasCommCurrency);		
		
			FixMessage.getTagStringValue(buf, commCurrency, 0, commCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCommCurrency);		
					return null;		
				}		
			}		
			hasCommCurrency = FixUtils.TAG_HAS_VALUE;		
			return commCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCommCurrency() { return hasCommCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCommCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasCommCurrency()) FixUtils.fillSpace(commCurrency);		
		FixUtils.copy(commCurrency, src); 		
		hasCommCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCommCurrency(String str) {		
		if (str == null ) return;
		if (hasCommCurrency()) FixUtils.fillSpace(commCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(commCurrency, src); 		
		hasCommCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getFundRenewWaiv() { 		
		if ( hasFundRenewWaiv()) {		
			if (hasFundRenewWaiv == FixUtils.TAG_HAS_VALUE) {		
				return fundRenewWaiv; 		
			} else {		
		
				buf.position(hasFundRenewWaiv);		
		
			fundRenewWaiv = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (fundRenewWaiv != (byte)'N') && (fundRenewWaiv != (byte)'Y') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 497);		
				if (err.hasError()) {		
					buf.position(hasFundRenewWaiv);		
					return (byte)'0';		
				}		
			}		
			hasFundRenewWaiv = FixUtils.TAG_HAS_VALUE;		
			return fundRenewWaiv;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasFundRenewWaiv() { return hasFundRenewWaiv != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFundRenewWaiv(byte src) {		
		fundRenewWaiv = src;
		hasFundRenewWaiv = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFundRenewWaiv(byte[] src) {		
		if (src == null ) return;
		if (hasFundRenewWaiv()) fundRenewWaiv = (byte)' ';		
		fundRenewWaiv = src[0];		
		hasFundRenewWaiv = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFundRenewWaiv(String str) {		
		if (str == null ) return;
		if (hasFundRenewWaiv()) fundRenewWaiv = (byte)' ';		
		byte[] src = str.getBytes(); 		
		fundRenewWaiv = src[0];		
		hasFundRenewWaiv = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasCommission()) s += "Commission(12)= " + getCommission() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCommType()) s += "CommType(13)= " + getCommType() + "\n" ; 
		if (hasCommCurrency()) s += "CommCurrency(479)= " + new String( FixUtils.trim(getCommCurrency()) ) + "\n" ; 
		if (hasFundRenewWaiv()) s += "FundRenewWaiv(497)= " + getFundRenewWaiv() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixCommissionData)) return false;

		FixCommissionData msg = (FixCommissionData) o;

		if ((hasCommission() && !msg.hasCommission()) || (!hasCommission() && msg.hasCommission())) return false;
		if (!(!hasCommission() && !msg.hasCommission()) && !(getCommission()==msg.getCommission())) return false;
		if ((hasCommType() && !msg.hasCommType()) || (!hasCommType() && msg.hasCommType())) return false;
		if (!(!hasCommType() && !msg.hasCommType()) && !(getCommType()==msg.getCommType())) return false;
		if ((hasCommCurrency() && !msg.hasCommCurrency()) || (!hasCommCurrency() && msg.hasCommCurrency())) return false;
		if (!(!hasCommCurrency() && !msg.hasCommCurrency()) && !FixUtils.equals(getCommCurrency(), msg.getCommCurrency())) return false;
		if ((hasFundRenewWaiv() && !msg.hasFundRenewWaiv()) || (!hasFundRenewWaiv() && msg.hasFundRenewWaiv())) return false;
		if (!(!hasFundRenewWaiv() && !msg.hasFundRenewWaiv()) && !(getFundRenewWaiv()==msg.getFundRenewWaiv())) return false;
		return true;
	}
	public FixCommissionData clone ( FixCommissionData out ) {
		if ( hasCommission())
			out.setCommission(getCommission());
		if ( hasCommType())
			out.setCommType(getCommType());
		if ( hasCommCurrency())
			out.setCommCurrency(getCommCurrency());
		if ( hasFundRenewWaiv())
			out.setFundRenewWaiv(getFundRenewWaiv());
		return out;
	}

}
