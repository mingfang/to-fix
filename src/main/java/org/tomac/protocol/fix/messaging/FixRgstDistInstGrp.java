package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRgstDistInstGrp extends FixGroup {
	private short hasDistribPaymentMethod;
	long distribPaymentMethod = 0;		
	private short hasDistribPercentage;
	long distribPercentage = 0;		
	private short hasCashDistribCurr;
	byte[] cashDistribCurr = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasCashDistribAgentName;
	byte[] cashDistribAgentName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCashDistribAgentCode;
	byte[] cashDistribAgentCode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCashDistribAgentAcctNumber;
	byte[] cashDistribAgentAcctNumber = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCashDistribPayRef;
	byte[] cashDistribPayRef = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCashDistribAgentAcctName;
	byte[] cashDistribAgentAcctName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixRgstDistInstGrp() {
		this(false);
	}

	public FixRgstDistInstGrp(boolean isRequired) {
		super(FixTags.DISTRIBPAYMENTMETHOD_INT);

		this.isRequired = isRequired;
		
		hasDistribPaymentMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasDistribPercentage = FixUtils.TAG_HAS_NO_VALUE;		
		hasCashDistribCurr = FixUtils.TAG_HAS_NO_VALUE;		
		cashDistribCurr = new byte[FixUtils.CURRENCY_LENGTH];		
		hasCashDistribAgentName = FixUtils.TAG_HAS_NO_VALUE;		
		cashDistribAgentName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCashDistribAgentCode = FixUtils.TAG_HAS_NO_VALUE;		
		cashDistribAgentCode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCashDistribAgentAcctNumber = FixUtils.TAG_HAS_NO_VALUE;		
		cashDistribAgentAcctNumber = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCashDistribPayRef = FixUtils.TAG_HAS_NO_VALUE;		
		cashDistribPayRef = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCashDistribAgentAcctName = FixUtils.TAG_HAS_NO_VALUE;		
		cashDistribAgentAcctName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasDistribPaymentMethod()) return true;
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
            	case FixTags.DISTRIBPAYMENTMETHOD_INT:		
            		hasDistribPaymentMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DISTRIBPERCENTAGE_INT:		
            		hasDistribPercentage = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CASHDISTRIBCURR_INT:		
            		hasCashDistribCurr = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CASHDISTRIBAGENTNAME_INT:		
            		hasCashDistribAgentName = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CASHDISTRIBAGENTCODE_INT:		
            		hasCashDistribAgentCode = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CASHDISTRIBAGENTACCTNUMBER_INT:		
            		hasCashDistribAgentAcctNumber = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CASHDISTRIBPAYREF_INT:		
            		hasCashDistribPayRef = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CASHDISTRIBAGENTACCTNAME_INT:		
            		hasCashDistribAgentAcctName = (short) buf.position();		
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
		hasDistribPaymentMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasDistribPercentage = FixUtils.TAG_HAS_NO_VALUE;
		hasCashDistribCurr = FixUtils.TAG_HAS_NO_VALUE;
		hasCashDistribAgentName = FixUtils.TAG_HAS_NO_VALUE;
		hasCashDistribAgentCode = FixUtils.TAG_HAS_NO_VALUE;
		hasCashDistribAgentAcctNumber = FixUtils.TAG_HAS_NO_VALUE;
		hasCashDistribPayRef = FixUtils.TAG_HAS_NO_VALUE;
		hasCashDistribAgentAcctName = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasDistribPaymentMethod()) {		
			out.put(FixTags.DISTRIBPAYMENTMETHOD);

			out.put((byte) '=');

			FixUtils.put(out, (long)distribPaymentMethod);
		
			out.put(FixUtils.SOH);

            }

		if (hasDistribPercentage()) {		
			out.put(FixTags.DISTRIBPERCENTAGE);

			out.put((byte) '=');

			FixUtils.put(out, (long)distribPercentage);
		
			out.put(FixUtils.SOH);

            }

		if (hasCashDistribCurr()) {		
			out.put(FixTags.CASHDISTRIBCURR);

			out.put((byte) '=');

			FixUtils.put(out,cashDistribCurr); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCashDistribAgentName()) {		
			out.put(FixTags.CASHDISTRIBAGENTNAME);

			out.put((byte) '=');

			FixUtils.put(out,cashDistribAgentName); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCashDistribAgentCode()) {		
			out.put(FixTags.CASHDISTRIBAGENTCODE);

			out.put((byte) '=');

			FixUtils.put(out,cashDistribAgentCode); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCashDistribAgentAcctNumber()) {		
			out.put(FixTags.CASHDISTRIBAGENTACCTNUMBER);

			out.put((byte) '=');

			FixUtils.put(out,cashDistribAgentAcctNumber); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCashDistribPayRef()) {		
			out.put(FixTags.CASHDISTRIBPAYREF);

			out.put((byte) '=');

			FixUtils.put(out,cashDistribPayRef); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCashDistribAgentAcctName()) {		
			out.put(FixTags.CASHDISTRIBAGENTACCTNAME);

			out.put((byte) '=');

			FixUtils.put(out,cashDistribAgentAcctName); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasDistribPaymentMethod()) {		
			FixUtils.put(out, (long)distribPaymentMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDistribPercentage()) {		
			FixUtils.put(out, (long)distribPercentage);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCashDistribCurr()) {		
			FixUtils.put(out,cashDistribCurr); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCashDistribAgentName()) {		
			FixUtils.put(out,cashDistribAgentName); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCashDistribAgentCode()) {		
			FixUtils.put(out,cashDistribAgentCode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCashDistribAgentAcctNumber()) {		
			FixUtils.put(out,cashDistribAgentAcctNumber); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCashDistribPayRef()) {		
			FixUtils.put(out,cashDistribPayRef); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCashDistribAgentAcctName()) {		
			FixUtils.put(out,cashDistribAgentAcctName); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getDistribPaymentMethod() { 		
		if ( hasDistribPaymentMethod()) {		
			if (hasDistribPaymentMethod == FixUtils.TAG_HAS_VALUE) {		
				return distribPaymentMethod; 		
			} else {		
		
				buf.position(hasDistribPaymentMethod);		
		
			distribPaymentMethod = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDistribPaymentMethod);		
					return 0;		
				}		
			}		
			hasDistribPaymentMethod = FixUtils.TAG_HAS_VALUE;		
			return distribPaymentMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDistribPaymentMethod() { return hasDistribPaymentMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDistribPaymentMethod(long src) {		
		distribPaymentMethod = src;
		hasDistribPaymentMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDistribPaymentMethod(byte[] src) {		
		if (src == null ) return;
		if (hasDistribPaymentMethod()) distribPaymentMethod = FixUtils.TAG_HAS_NO_VALUE;		
		distribPaymentMethod = FixUtils.longValueOf(src, 0, src.length);
		hasDistribPaymentMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDistribPaymentMethod(String str) {		
		if (str == null ) return;
		if (hasDistribPaymentMethod()) distribPaymentMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		distribPaymentMethod = FixUtils.longValueOf(src, 0, src.length);
		hasDistribPaymentMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDistribPercentage() { 		
		if ( hasDistribPercentage()) {		
			if (hasDistribPercentage == FixUtils.TAG_HAS_VALUE) {		
				return distribPercentage; 		
			} else {		
		
				buf.position(hasDistribPercentage);		
		
			distribPercentage = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDistribPercentage);		
					return 0;		
				}		
			}		
			hasDistribPercentage = FixUtils.TAG_HAS_VALUE;		
			return distribPercentage;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDistribPercentage() { return hasDistribPercentage != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDistribPercentage(long src) {		
		distribPercentage = src;
		hasDistribPercentage = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDistribPercentage(byte[] src) {		
		if (src == null ) return;
		if (hasDistribPercentage()) distribPercentage = FixUtils.TAG_HAS_NO_VALUE;		
		distribPercentage = FixUtils.longValueOf(src, 0, src.length);
		hasDistribPercentage = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDistribPercentage(String str) {		
		if (str == null ) return;
		if (hasDistribPercentage()) distribPercentage = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		distribPercentage = FixUtils.longValueOf(src, 0, src.length);
		hasDistribPercentage = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCashDistribCurr() { 		
		if ( hasCashDistribCurr()) {		
			if (hasCashDistribCurr == FixUtils.TAG_HAS_VALUE) {		
				return cashDistribCurr; 		
			} else {		
		
				buf.position(hasCashDistribCurr);		
		
			FixUtils.getTagStringValue(buf, cashDistribCurr, 0, cashDistribCurr.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCashDistribCurr);		
					return null;		
				}		
			}		
			hasCashDistribCurr = FixUtils.TAG_HAS_VALUE;		
			return cashDistribCurr;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCashDistribCurr() { return hasCashDistribCurr != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCashDistribCurr(byte[] src) {		
		if (src == null ) return;
		if (hasCashDistribCurr()) FixUtils.fillNul(cashDistribCurr);		
		FixUtils.copy(cashDistribCurr, src); 		
		hasCashDistribCurr = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCashDistribCurr(String str) {		
		if (str == null ) return;
		if (hasCashDistribCurr()) FixUtils.fillNul(cashDistribCurr);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cashDistribCurr, src); 		
		hasCashDistribCurr = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCashDistribAgentName() { 		
		if ( hasCashDistribAgentName()) {		
			if (hasCashDistribAgentName == FixUtils.TAG_HAS_VALUE) {		
				return cashDistribAgentName; 		
			} else {		
		
				buf.position(hasCashDistribAgentName);		
		
			FixUtils.getTagStringValue(buf, cashDistribAgentName, 0, cashDistribAgentName.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCashDistribAgentName);		
					return null;		
				}		
			}		
			hasCashDistribAgentName = FixUtils.TAG_HAS_VALUE;		
			return cashDistribAgentName;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCashDistribAgentName() { return hasCashDistribAgentName != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCashDistribAgentName(byte[] src) {		
		if (src == null ) return;
		if (hasCashDistribAgentName()) FixUtils.fillNul(cashDistribAgentName);		
		FixUtils.copy(cashDistribAgentName, src); 		
		hasCashDistribAgentName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCashDistribAgentName(String str) {		
		if (str == null ) return;
		if (hasCashDistribAgentName()) FixUtils.fillNul(cashDistribAgentName);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cashDistribAgentName, src); 		
		hasCashDistribAgentName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCashDistribAgentCode() { 		
		if ( hasCashDistribAgentCode()) {		
			if (hasCashDistribAgentCode == FixUtils.TAG_HAS_VALUE) {		
				return cashDistribAgentCode; 		
			} else {		
		
				buf.position(hasCashDistribAgentCode);		
		
			FixUtils.getTagStringValue(buf, cashDistribAgentCode, 0, cashDistribAgentCode.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCashDistribAgentCode);		
					return null;		
				}		
			}		
			hasCashDistribAgentCode = FixUtils.TAG_HAS_VALUE;		
			return cashDistribAgentCode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCashDistribAgentCode() { return hasCashDistribAgentCode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCashDistribAgentCode(byte[] src) {		
		if (src == null ) return;
		if (hasCashDistribAgentCode()) FixUtils.fillNul(cashDistribAgentCode);		
		FixUtils.copy(cashDistribAgentCode, src); 		
		hasCashDistribAgentCode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCashDistribAgentCode(String str) {		
		if (str == null ) return;
		if (hasCashDistribAgentCode()) FixUtils.fillNul(cashDistribAgentCode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cashDistribAgentCode, src); 		
		hasCashDistribAgentCode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCashDistribAgentAcctNumber() { 		
		if ( hasCashDistribAgentAcctNumber()) {		
			if (hasCashDistribAgentAcctNumber == FixUtils.TAG_HAS_VALUE) {		
				return cashDistribAgentAcctNumber; 		
			} else {		
		
				buf.position(hasCashDistribAgentAcctNumber);		
		
			FixUtils.getTagStringValue(buf, cashDistribAgentAcctNumber, 0, cashDistribAgentAcctNumber.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCashDistribAgentAcctNumber);		
					return null;		
				}		
			}		
			hasCashDistribAgentAcctNumber = FixUtils.TAG_HAS_VALUE;		
			return cashDistribAgentAcctNumber;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCashDistribAgentAcctNumber() { return hasCashDistribAgentAcctNumber != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCashDistribAgentAcctNumber(byte[] src) {		
		if (src == null ) return;
		if (hasCashDistribAgentAcctNumber()) FixUtils.fillNul(cashDistribAgentAcctNumber);		
		FixUtils.copy(cashDistribAgentAcctNumber, src); 		
		hasCashDistribAgentAcctNumber = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCashDistribAgentAcctNumber(String str) {		
		if (str == null ) return;
		if (hasCashDistribAgentAcctNumber()) FixUtils.fillNul(cashDistribAgentAcctNumber);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cashDistribAgentAcctNumber, src); 		
		hasCashDistribAgentAcctNumber = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCashDistribPayRef() { 		
		if ( hasCashDistribPayRef()) {		
			if (hasCashDistribPayRef == FixUtils.TAG_HAS_VALUE) {		
				return cashDistribPayRef; 		
			} else {		
		
				buf.position(hasCashDistribPayRef);		
		
			FixUtils.getTagStringValue(buf, cashDistribPayRef, 0, cashDistribPayRef.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCashDistribPayRef);		
					return null;		
				}		
			}		
			hasCashDistribPayRef = FixUtils.TAG_HAS_VALUE;		
			return cashDistribPayRef;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCashDistribPayRef() { return hasCashDistribPayRef != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCashDistribPayRef(byte[] src) {		
		if (src == null ) return;
		if (hasCashDistribPayRef()) FixUtils.fillNul(cashDistribPayRef);		
		FixUtils.copy(cashDistribPayRef, src); 		
		hasCashDistribPayRef = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCashDistribPayRef(String str) {		
		if (str == null ) return;
		if (hasCashDistribPayRef()) FixUtils.fillNul(cashDistribPayRef);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cashDistribPayRef, src); 		
		hasCashDistribPayRef = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCashDistribAgentAcctName() { 		
		if ( hasCashDistribAgentAcctName()) {		
			if (hasCashDistribAgentAcctName == FixUtils.TAG_HAS_VALUE) {		
				return cashDistribAgentAcctName; 		
			} else {		
		
				buf.position(hasCashDistribAgentAcctName);		
		
			FixUtils.getTagStringValue(buf, cashDistribAgentAcctName, 0, cashDistribAgentAcctName.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCashDistribAgentAcctName);		
					return null;		
				}		
			}		
			hasCashDistribAgentAcctName = FixUtils.TAG_HAS_VALUE;		
			return cashDistribAgentAcctName;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCashDistribAgentAcctName() { return hasCashDistribAgentAcctName != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCashDistribAgentAcctName(byte[] src) {		
		if (src == null ) return;
		if (hasCashDistribAgentAcctName()) FixUtils.fillNul(cashDistribAgentAcctName);		
		FixUtils.copy(cashDistribAgentAcctName, src); 		
		hasCashDistribAgentAcctName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCashDistribAgentAcctName(String str) {		
		if (str == null ) return;
		if (hasCashDistribAgentAcctName()) FixUtils.fillNul(cashDistribAgentAcctName);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cashDistribAgentAcctName, src); 		
		hasCashDistribAgentAcctName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasDistribPaymentMethod()) s += "DistribPaymentMethod(477)= " + getDistribPaymentMethod() + "\n" ; 
		if (hasDistribPercentage()) s += "DistribPercentage(512)= " + getDistribPercentage() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCashDistribCurr()) s += "CashDistribCurr(478)= " + new String( FixUtils.trim(getCashDistribCurr()) ) + "\n" ; 
		if (hasCashDistribAgentName()) s += "CashDistribAgentName(498)= " + new String( FixUtils.trim(getCashDistribAgentName()) ) + "\n" ; 
		if (hasCashDistribAgentCode()) s += "CashDistribAgentCode(499)= " + new String( FixUtils.trim(getCashDistribAgentCode()) ) + "\n" ; 
		if (hasCashDistribAgentAcctNumber()) s += "CashDistribAgentAcctNumber(500)= " + new String( FixUtils.trim(getCashDistribAgentAcctNumber()) ) + "\n" ; 
		if (hasCashDistribPayRef()) s += "CashDistribPayRef(501)= " + new String( FixUtils.trim(getCashDistribPayRef()) ) + "\n" ; 
		if (hasCashDistribAgentAcctName()) s += "CashDistribAgentAcctName(502)= " + new String( FixUtils.trim(getCashDistribAgentAcctName()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRgstDistInstGrp)) return false;

		FixRgstDistInstGrp msg = (FixRgstDistInstGrp) o;

		if ((hasDistribPaymentMethod() && !msg.hasDistribPaymentMethod()) || (!hasDistribPaymentMethod() && msg.hasDistribPaymentMethod())) return false;
		if (!(!hasDistribPaymentMethod() && !msg.hasDistribPaymentMethod()) && !(getDistribPaymentMethod()==msg.getDistribPaymentMethod())) return false;
		if ((hasDistribPercentage() && !msg.hasDistribPercentage()) || (!hasDistribPercentage() && msg.hasDistribPercentage())) return false;
		if (!(!hasDistribPercentage() && !msg.hasDistribPercentage()) && !(getDistribPercentage()==msg.getDistribPercentage())) return false;
		if ((hasCashDistribCurr() && !msg.hasCashDistribCurr()) || (!hasCashDistribCurr() && msg.hasCashDistribCurr())) return false;
		if (!(!hasCashDistribCurr() && !msg.hasCashDistribCurr()) && !FixUtils.equals(getCashDistribCurr(), msg.getCashDistribCurr())) return false;
		if ((hasCashDistribAgentName() && !msg.hasCashDistribAgentName()) || (!hasCashDistribAgentName() && msg.hasCashDistribAgentName())) return false;
		if (!(!hasCashDistribAgentName() && !msg.hasCashDistribAgentName()) && !FixUtils.equals(getCashDistribAgentName(), msg.getCashDistribAgentName())) return false;
		if ((hasCashDistribAgentCode() && !msg.hasCashDistribAgentCode()) || (!hasCashDistribAgentCode() && msg.hasCashDistribAgentCode())) return false;
		if (!(!hasCashDistribAgentCode() && !msg.hasCashDistribAgentCode()) && !FixUtils.equals(getCashDistribAgentCode(), msg.getCashDistribAgentCode())) return false;
		if ((hasCashDistribAgentAcctNumber() && !msg.hasCashDistribAgentAcctNumber()) || (!hasCashDistribAgentAcctNumber() && msg.hasCashDistribAgentAcctNumber())) return false;
		if (!(!hasCashDistribAgentAcctNumber() && !msg.hasCashDistribAgentAcctNumber()) && !FixUtils.equals(getCashDistribAgentAcctNumber(), msg.getCashDistribAgentAcctNumber())) return false;
		if ((hasCashDistribPayRef() && !msg.hasCashDistribPayRef()) || (!hasCashDistribPayRef() && msg.hasCashDistribPayRef())) return false;
		if (!(!hasCashDistribPayRef() && !msg.hasCashDistribPayRef()) && !FixUtils.equals(getCashDistribPayRef(), msg.getCashDistribPayRef())) return false;
		if ((hasCashDistribAgentAcctName() && !msg.hasCashDistribAgentAcctName()) || (!hasCashDistribAgentAcctName() && msg.hasCashDistribAgentAcctName())) return false;
		if (!(!hasCashDistribAgentAcctName() && !msg.hasCashDistribAgentAcctName()) && !FixUtils.equals(getCashDistribAgentAcctName(), msg.getCashDistribAgentAcctName())) return false;
		return true;
	}
	public FixRgstDistInstGrp clone ( FixRgstDistInstGrp out ) {
		if ( hasDistribPaymentMethod())
			out.setDistribPaymentMethod(getDistribPaymentMethod());
		if ( hasDistribPercentage())
			out.setDistribPercentage(getDistribPercentage());
		if ( hasCashDistribCurr())
			out.setCashDistribCurr(getCashDistribCurr());
		if ( hasCashDistribAgentName())
			out.setCashDistribAgentName(getCashDistribAgentName());
		if ( hasCashDistribAgentCode())
			out.setCashDistribAgentCode(getCashDistribAgentCode());
		if ( hasCashDistribAgentAcctNumber())
			out.setCashDistribAgentAcctNumber(getCashDistribAgentAcctNumber());
		if ( hasCashDistribPayRef())
			out.setCashDistribPayRef(getCashDistribPayRef());
		if ( hasCashDistribAgentAcctName())
			out.setCashDistribAgentAcctName(getCashDistribAgentAcctName());
		return out;
	}

}
