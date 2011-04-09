package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixFinancingDetails extends FixGroup {
	private short hasAgreementDesc;
	byte[] agreementDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAgreementID;
	byte[] agreementID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAgreementDate;
	byte[] agreementDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasAgreementCurrency;
	byte[] agreementCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasTerminationType;
	long terminationType = 0;		
	private short hasStartDate;
	byte[] startDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEndDate;
	byte[] endDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDeliveryType;
	long deliveryType = 0;		
	private short hasMarginRatio;
	long marginRatio = 0;		
	
	public FixFinancingDetails() {
		this(false);
	}

	public FixFinancingDetails(boolean isRequired) {
		super(FixTags.AGREEMENTDESC_INT);

		this.isRequired = isRequired;
		
		hasAgreementDesc = FixUtils.TAG_HAS_NO_VALUE;		
		agreementDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAgreementID = FixUtils.TAG_HAS_NO_VALUE;		
		agreementID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAgreementDate = FixUtils.TAG_HAS_NO_VALUE;		
		agreementDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasAgreementCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		agreementCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasTerminationType = FixUtils.TAG_HAS_NO_VALUE;		
		hasStartDate = FixUtils.TAG_HAS_NO_VALUE;		
		startDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEndDate = FixUtils.TAG_HAS_NO_VALUE;		
		endDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDeliveryType = FixUtils.TAG_HAS_NO_VALUE;		
		hasMarginRatio = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasAgreementDesc()) return true;
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
            	case FixTags.AGREEMENTDESC_INT:		
            		hasAgreementDesc = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.AGREEMENTID_INT:		
            		hasAgreementID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.AGREEMENTDATE_INT:		
            		hasAgreementDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.AGREEMENTCURRENCY_INT:		
            		hasAgreementCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.TERMINATIONTYPE_INT:		
            		hasTerminationType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.STARTDATE_INT:		
            		hasStartDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ENDDATE_INT:		
            		hasEndDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DELIVERYTYPE_INT:		
            		hasDeliveryType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MARGINRATIO_INT:		
            		hasMarginRatio = (short) buf.position();		
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
		hasAgreementDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasAgreementID = FixUtils.TAG_HAS_NO_VALUE;
		hasAgreementDate = FixUtils.TAG_HAS_NO_VALUE;
		hasAgreementCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasTerminationType = FixUtils.TAG_HAS_NO_VALUE;
		hasStartDate = FixUtils.TAG_HAS_NO_VALUE;
		hasEndDate = FixUtils.TAG_HAS_NO_VALUE;
		hasDeliveryType = FixUtils.TAG_HAS_NO_VALUE;
		hasMarginRatio = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasAgreementDesc()) {		
			out.put(FixTags.AGREEMENTDESC);

			out.put((byte) '=');

			FixUtils.put(out,agreementDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAgreementID()) {		
			out.put(FixTags.AGREEMENTID);

			out.put((byte) '=');

			FixUtils.put(out,agreementID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAgreementDate()) {		
			out.put(FixTags.AGREEMENTDATE);

			out.put((byte) '=');

			FixUtils.put(out,agreementDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasAgreementCurrency()) {		
			out.put(FixTags.AGREEMENTCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,agreementCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTerminationType()) {		
			out.put(FixTags.TERMINATIONTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)terminationType);
		
			out.put(FixUtils.SOH);

            }

		if (hasStartDate()) {		
			out.put(FixTags.STARTDATE);

			out.put((byte) '=');

			FixUtils.put(out,startDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEndDate()) {		
			out.put(FixTags.ENDDATE);

			out.put((byte) '=');

			FixUtils.put(out,endDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDeliveryType()) {		
			out.put(FixTags.DELIVERYTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)deliveryType);
		
			out.put(FixUtils.SOH);

            }

		if (hasMarginRatio()) {		
			out.put(FixTags.MARGINRATIO);

			out.put((byte) '=');

			FixUtils.put(out, (long)marginRatio);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasAgreementDesc()) {		
			FixUtils.put(out,agreementDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAgreementID()) {		
			FixUtils.put(out,agreementID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAgreementDate()) {		
			FixUtils.put(out,agreementDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasAgreementCurrency()) {		
			FixUtils.put(out,agreementCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTerminationType()) {		
			FixUtils.put(out, (long)terminationType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStartDate()) {		
			FixUtils.put(out,startDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEndDate()) {		
			FixUtils.put(out,endDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDeliveryType()) {		
			FixUtils.put(out, (long)deliveryType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarginRatio()) {		
			FixUtils.put(out, (long)marginRatio);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getAgreementDesc() { 		
		if ( hasAgreementDesc()) {		
			if (hasAgreementDesc == FixUtils.TAG_HAS_VALUE) {		
				return agreementDesc; 		
			} else {		
		
				buf.position(hasAgreementDesc);		
		
			FixUtils.getTagStringValue(buf, agreementDesc, 0, agreementDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAgreementDesc);		
					return null;		
				}		
			}		
			hasAgreementDesc = FixUtils.TAG_HAS_VALUE;		
			return agreementDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAgreementDesc() { return hasAgreementDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAgreementDesc(byte[] src) {		
		if (src == null ) return;
		if (hasAgreementDesc()) FixUtils.fillNul(agreementDesc);		
		FixUtils.copy(agreementDesc, src); 		
		hasAgreementDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAgreementDesc(String str) {		
		if (str == null ) return;
		if (hasAgreementDesc()) FixUtils.fillNul(agreementDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(agreementDesc, src); 		
		hasAgreementDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getAgreementID() { 		
		if ( hasAgreementID()) {		
			if (hasAgreementID == FixUtils.TAG_HAS_VALUE) {		
				return agreementID; 		
			} else {		
		
				buf.position(hasAgreementID);		
		
			FixUtils.getTagStringValue(buf, agreementID, 0, agreementID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAgreementID);		
					return null;		
				}		
			}		
			hasAgreementID = FixUtils.TAG_HAS_VALUE;		
			return agreementID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAgreementID() { return hasAgreementID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAgreementID(byte[] src) {		
		if (src == null ) return;
		if (hasAgreementID()) FixUtils.fillNul(agreementID);		
		FixUtils.copy(agreementID, src); 		
		hasAgreementID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAgreementID(String str) {		
		if (str == null ) return;
		if (hasAgreementID()) FixUtils.fillNul(agreementID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(agreementID, src); 		
		hasAgreementID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getAgreementDate() { 		
		if ( hasAgreementDate()) {		
			if (hasAgreementDate == FixUtils.TAG_HAS_VALUE) {		
				return agreementDate; 		
			} else {		
		
				buf.position(hasAgreementDate);		
		
			FixUtils.getTagStringValue(buf, agreementDate, 0, agreementDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAgreementDate);		
					return null;		
				}		
			}		
			hasAgreementDate = FixUtils.TAG_HAS_VALUE;		
			return agreementDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAgreementDate() { return hasAgreementDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAgreementDate(byte[] src) {		
		if (src == null ) return;
		if (hasAgreementDate()) FixUtils.fillNul(agreementDate);		
		FixUtils.copy(agreementDate, src); 		
		hasAgreementDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAgreementDate(String str) {		
		if (str == null ) return;
		if (hasAgreementDate()) FixUtils.fillNul(agreementDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(agreementDate, src); 		
		hasAgreementDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getAgreementCurrency() { 		
		if ( hasAgreementCurrency()) {		
			if (hasAgreementCurrency == FixUtils.TAG_HAS_VALUE) {		
				return agreementCurrency; 		
			} else {		
		
				buf.position(hasAgreementCurrency);		
		
			FixUtils.getTagStringValue(buf, agreementCurrency, 0, agreementCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasAgreementCurrency);		
					return null;		
				}		
			}		
			hasAgreementCurrency = FixUtils.TAG_HAS_VALUE;		
			return agreementCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasAgreementCurrency() { return hasAgreementCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setAgreementCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasAgreementCurrency()) FixUtils.fillNul(agreementCurrency);		
		FixUtils.copy(agreementCurrency, src); 		
		hasAgreementCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setAgreementCurrency(String str) {		
		if (str == null ) return;
		if (hasAgreementCurrency()) FixUtils.fillNul(agreementCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(agreementCurrency, src); 		
		hasAgreementCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTerminationType() { 		
		if ( hasTerminationType()) {		
			if (hasTerminationType == FixUtils.TAG_HAS_VALUE) {		
				return terminationType; 		
			} else {		
		
				buf.position(hasTerminationType);		
		
			terminationType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTerminationType);		
					return 0;		
				}		
			}		
			hasTerminationType = FixUtils.TAG_HAS_VALUE;		
			return terminationType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTerminationType() { return hasTerminationType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTerminationType(long src) {		
		terminationType = src;
		hasTerminationType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTerminationType(byte[] src) {		
		if (src == null ) return;
		if (hasTerminationType()) terminationType = FixUtils.TAG_HAS_NO_VALUE;		
		terminationType = FixUtils.longValueOf(src, 0, src.length);
		hasTerminationType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTerminationType(String str) {		
		if (str == null ) return;
		if (hasTerminationType()) terminationType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		terminationType = FixUtils.longValueOf(src, 0, src.length);
		hasTerminationType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getStartDate() { 		
		if ( hasStartDate()) {		
			if (hasStartDate == FixUtils.TAG_HAS_VALUE) {		
				return startDate; 		
			} else {		
		
				buf.position(hasStartDate);		
		
			FixUtils.getTagStringValue(buf, startDate, 0, startDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasStartDate);		
					return null;		
				}		
			}		
			hasStartDate = FixUtils.TAG_HAS_VALUE;		
			return startDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStartDate() { return hasStartDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStartDate(byte[] src) {		
		if (src == null ) return;
		if (hasStartDate()) FixUtils.fillNul(startDate);		
		FixUtils.copy(startDate, src); 		
		hasStartDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStartDate(String str) {		
		if (str == null ) return;
		if (hasStartDate()) FixUtils.fillNul(startDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(startDate, src); 		
		hasStartDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEndDate() { 		
		if ( hasEndDate()) {		
			if (hasEndDate == FixUtils.TAG_HAS_VALUE) {		
				return endDate; 		
			} else {		
		
				buf.position(hasEndDate);		
		
			FixUtils.getTagStringValue(buf, endDate, 0, endDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEndDate);		
					return null;		
				}		
			}		
			hasEndDate = FixUtils.TAG_HAS_VALUE;		
			return endDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEndDate() { return hasEndDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEndDate(byte[] src) {		
		if (src == null ) return;
		if (hasEndDate()) FixUtils.fillNul(endDate);		
		FixUtils.copy(endDate, src); 		
		hasEndDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEndDate(String str) {		
		if (str == null ) return;
		if (hasEndDate()) FixUtils.fillNul(endDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(endDate, src); 		
		hasEndDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDeliveryType() { 		
		if ( hasDeliveryType()) {		
			if (hasDeliveryType == FixUtils.TAG_HAS_VALUE) {		
				return deliveryType; 		
			} else {		
		
				buf.position(hasDeliveryType);		
		
			deliveryType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDeliveryType);		
					return 0;		
				}		
			}		
			hasDeliveryType = FixUtils.TAG_HAS_VALUE;		
			return deliveryType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDeliveryType() { return hasDeliveryType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDeliveryType(long src) {		
		deliveryType = src;
		hasDeliveryType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDeliveryType(byte[] src) {		
		if (src == null ) return;
		if (hasDeliveryType()) deliveryType = FixUtils.TAG_HAS_NO_VALUE;		
		deliveryType = FixUtils.longValueOf(src, 0, src.length);
		hasDeliveryType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDeliveryType(String str) {		
		if (str == null ) return;
		if (hasDeliveryType()) deliveryType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		deliveryType = FixUtils.longValueOf(src, 0, src.length);
		hasDeliveryType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMarginRatio() { 		
		if ( hasMarginRatio()) {		
			if (hasMarginRatio == FixUtils.TAG_HAS_VALUE) {		
				return marginRatio; 		
			} else {		
		
				buf.position(hasMarginRatio);		
		
			marginRatio = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMarginRatio);		
					return 0;		
				}		
			}		
			hasMarginRatio = FixUtils.TAG_HAS_VALUE;		
			return marginRatio;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMarginRatio() { return hasMarginRatio != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMarginRatio(long src) {		
		marginRatio = src;
		hasMarginRatio = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMarginRatio(byte[] src) {		
		if (src == null ) return;
		if (hasMarginRatio()) marginRatio = FixUtils.TAG_HAS_NO_VALUE;		
		marginRatio = FixUtils.longValueOf(src, 0, src.length);
		hasMarginRatio = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMarginRatio(String str) {		
		if (str == null ) return;
		if (hasMarginRatio()) marginRatio = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		marginRatio = FixUtils.longValueOf(src, 0, src.length);
		hasMarginRatio = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasAgreementDesc()) s += "AgreementDesc(913)= " + new String( FixUtils.trim(getAgreementDesc()) ) + "\n" ; 
		if (hasAgreementID()) s += "AgreementID(914)= " + new String( FixUtils.trim(getAgreementID()) ) + "\n" ; 
		if (hasAgreementDate()) s += "AgreementDate(915)= " + new String( FixUtils.trim(getAgreementDate()) ) + "\n" ; 
		if (hasAgreementCurrency()) s += "AgreementCurrency(918)= " + new String( FixUtils.trim(getAgreementCurrency()) ) + "\n" ; 
		if (hasTerminationType()) s += "TerminationType(788)= " + getTerminationType() + "\n" ; 
		if (hasStartDate()) s += "StartDate(916)= " + new String( FixUtils.trim(getStartDate()) ) + "\n" ; 
		if (hasEndDate()) s += "EndDate(917)= " + new String( FixUtils.trim(getEndDate()) ) + "\n" ; 
		if (hasDeliveryType()) s += "DeliveryType(919)= " + getDeliveryType() + "\n" ; 
		if (hasMarginRatio()) s += "MarginRatio(898)= " + getMarginRatio() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixFinancingDetails)) return false;

		FixFinancingDetails msg = (FixFinancingDetails) o;

		if ((hasAgreementDesc() && !msg.hasAgreementDesc()) || (!hasAgreementDesc() && msg.hasAgreementDesc())) return false;
		if (!(!hasAgreementDesc() && !msg.hasAgreementDesc()) && !FixUtils.equals(getAgreementDesc(), msg.getAgreementDesc())) return false;
		if ((hasAgreementID() && !msg.hasAgreementID()) || (!hasAgreementID() && msg.hasAgreementID())) return false;
		if (!(!hasAgreementID() && !msg.hasAgreementID()) && !FixUtils.equals(getAgreementID(), msg.getAgreementID())) return false;
		if ((hasAgreementDate() && !msg.hasAgreementDate()) || (!hasAgreementDate() && msg.hasAgreementDate())) return false;
		if ((hasAgreementCurrency() && !msg.hasAgreementCurrency()) || (!hasAgreementCurrency() && msg.hasAgreementCurrency())) return false;
		if (!(!hasAgreementCurrency() && !msg.hasAgreementCurrency()) && !FixUtils.equals(getAgreementCurrency(), msg.getAgreementCurrency())) return false;
		if ((hasTerminationType() && !msg.hasTerminationType()) || (!hasTerminationType() && msg.hasTerminationType())) return false;
		if (!(!hasTerminationType() && !msg.hasTerminationType()) && !(getTerminationType()==msg.getTerminationType())) return false;
		if ((hasStartDate() && !msg.hasStartDate()) || (!hasStartDate() && msg.hasStartDate())) return false;
		if ((hasEndDate() && !msg.hasEndDate()) || (!hasEndDate() && msg.hasEndDate())) return false;
		if ((hasDeliveryType() && !msg.hasDeliveryType()) || (!hasDeliveryType() && msg.hasDeliveryType())) return false;
		if (!(!hasDeliveryType() && !msg.hasDeliveryType()) && !(getDeliveryType()==msg.getDeliveryType())) return false;
		if ((hasMarginRatio() && !msg.hasMarginRatio()) || (!hasMarginRatio() && msg.hasMarginRatio())) return false;
		if (!(!hasMarginRatio() && !msg.hasMarginRatio()) && !(getMarginRatio()==msg.getMarginRatio())) return false;
		return true;
	}
	public FixFinancingDetails clone ( FixFinancingDetails out ) {
		if ( hasAgreementDesc())
			out.setAgreementDesc(getAgreementDesc());
		if ( hasAgreementID())
			out.setAgreementID(getAgreementID());
		if ( hasAgreementDate())
			out.setAgreementDate(getAgreementDate());
		if ( hasAgreementCurrency())
			out.setAgreementCurrency(getAgreementCurrency());
		if ( hasTerminationType())
			out.setTerminationType(getTerminationType());
		if ( hasStartDate())
			out.setStartDate(getStartDate());
		if ( hasEndDate())
			out.setEndDate(getEndDate());
		if ( hasDeliveryType())
			out.setDeliveryType(getDeliveryType());
		if ( hasMarginRatio())
			out.setMarginRatio(getMarginRatio());
		return out;
	}

}
