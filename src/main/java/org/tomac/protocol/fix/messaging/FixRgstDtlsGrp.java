package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRgstDtlsGrp extends FixGroup {
	private short hasRegistDtls;
	byte[] registDtls = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRegistEmail;
	byte[] registEmail = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMailingDtls;
	byte[] mailingDtls = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMailingInst;
	byte[] mailingInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOwnerType;
	long ownerType = 0;		
	private short hasDateOfBirth;
	byte[] dateOfBirth = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasInvestorCountryOfResidence;
	byte[] investorCountryOfResidence = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixNestedParties[] nestedParties;
	
	public FixRgstDtlsGrp() {
		this(false);
	}

	public FixRgstDtlsGrp(boolean isRequired) {
		super(FixTags.REGISTDTLS_INT);

		this.isRequired = isRequired;
		
		hasRegistDtls = FixUtils.TAG_HAS_NO_VALUE;		
		registDtls = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRegistEmail = FixUtils.TAG_HAS_NO_VALUE;		
		registEmail = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMailingDtls = FixUtils.TAG_HAS_NO_VALUE;		
		mailingDtls = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMailingInst = FixUtils.TAG_HAS_NO_VALUE;		
		mailingInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOwnerType = FixUtils.TAG_HAS_NO_VALUE;		
		hasDateOfBirth = FixUtils.TAG_HAS_NO_VALUE;		
		dateOfBirth = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasInvestorCountryOfResidence = FixUtils.TAG_HAS_NO_VALUE;		
		investorCountryOfResidence = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		nestedParties = new FixNestedParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedParties[i] = new FixNestedParties();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRegistDtls()) return true;
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
            	case FixTags.REGISTDTLS_INT:		
            		hasRegistDtls = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.REGISTEMAIL_INT:		
            		hasRegistEmail = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MAILINGDTLS_INT:		
            		hasMailingDtls = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MAILINGINST_INT:		
            		hasMailingInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.OWNERTYPE_INT:		
            		hasOwnerType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DATEOFBIRTH_INT:		
            		hasDateOfBirth = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.INVESTORCOUNTRYOFRESIDENCE_INT:		
            		hasInvestorCountryOfResidence = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTEDPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !nestedParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = nestedParties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
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
		hasRegistDtls = FixUtils.TAG_HAS_NO_VALUE;
		hasRegistEmail = FixUtils.TAG_HAS_NO_VALUE;
		hasMailingDtls = FixUtils.TAG_HAS_NO_VALUE;
		hasMailingInst = FixUtils.TAG_HAS_NO_VALUE;
		hasOwnerType = FixUtils.TAG_HAS_NO_VALUE;
		hasDateOfBirth = FixUtils.TAG_HAS_NO_VALUE;
		hasInvestorCountryOfResidence = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRegistDtls()) {		
			out.put(FixTags.REGISTDTLS);

			out.put((byte) '=');

			FixUtils.put(out,registDtls); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRegistEmail()) {		
			out.put(FixTags.REGISTEMAIL);

			out.put((byte) '=');

			FixUtils.put(out,registEmail); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMailingDtls()) {		
			out.put(FixTags.MAILINGDTLS);

			out.put((byte) '=');

			FixUtils.put(out,mailingDtls); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMailingInst()) {		
			out.put(FixTags.MAILINGINST);

			out.put((byte) '=');

			FixUtils.put(out,mailingInst); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOwnerType()) {		
			out.put(FixTags.OWNERTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)ownerType);
		
			out.put(FixUtils.SOH);

            }

		if (hasDateOfBirth()) {		
			out.put(FixTags.DATEOFBIRTH);

			out.put((byte) '=');

			FixUtils.put(out,dateOfBirth); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasInvestorCountryOfResidence()) {		
			out.put(FixTags.INVESTORCOUNTRYOFRESIDENCE);

			out.put((byte) '=');

			FixUtils.put(out,investorCountryOfResidence); 		
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(nestedParties)>0) {
			out.put(FixTags.NONESTEDPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(nestedParties));

			out.put(FixUtils.SOH);

		}
		for (FixNestedParties fixNestedParties : nestedParties) if (fixNestedParties.hasGroup()) fixNestedParties.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRegistDtls()) {		
			FixUtils.put(out,registDtls); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRegistEmail()) {		
			FixUtils.put(out,registEmail); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMailingDtls()) {		
			FixUtils.put(out,mailingDtls); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMailingInst()) {		
			FixUtils.put(out,mailingInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOwnerType()) {		
			FixUtils.put(out, (long)ownerType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDateOfBirth()) {		
			FixUtils.put(out,dateOfBirth); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasInvestorCountryOfResidence()) {		
			FixUtils.put(out,investorCountryOfResidence); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.printBuffer(out);
	}

	public byte[] getRegistDtls() { 		
		if ( hasRegistDtls()) {		
			if (hasRegistDtls == FixUtils.TAG_HAS_VALUE) {		
				return registDtls; 		
			} else {		
		
				buf.position(hasRegistDtls);		
		
			FixMessage.getTagStringValue(buf, registDtls, 0, registDtls.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRegistDtls);		
					return null;		
				}		
			}		
			hasRegistDtls = FixUtils.TAG_HAS_VALUE;		
			return registDtls;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRegistDtls() { return hasRegistDtls != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRegistDtls(byte[] src) {		
		if (src == null ) return;
		if (hasRegistDtls()) FixUtils.fillNul(registDtls);		
		FixUtils.copy(registDtls, src); 		
		hasRegistDtls = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRegistDtls(String str) {		
		if (str == null ) return;
		if (hasRegistDtls()) FixUtils.fillNul(registDtls);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(registDtls, src); 		
		hasRegistDtls = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRegistEmail() { 		
		if ( hasRegistEmail()) {		
			if (hasRegistEmail == FixUtils.TAG_HAS_VALUE) {		
				return registEmail; 		
			} else {		
		
				buf.position(hasRegistEmail);		
		
			FixMessage.getTagStringValue(buf, registEmail, 0, registEmail.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRegistEmail);		
					return null;		
				}		
			}		
			hasRegistEmail = FixUtils.TAG_HAS_VALUE;		
			return registEmail;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRegistEmail() { return hasRegistEmail != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRegistEmail(byte[] src) {		
		if (src == null ) return;
		if (hasRegistEmail()) FixUtils.fillNul(registEmail);		
		FixUtils.copy(registEmail, src); 		
		hasRegistEmail = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRegistEmail(String str) {		
		if (str == null ) return;
		if (hasRegistEmail()) FixUtils.fillNul(registEmail);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(registEmail, src); 		
		hasRegistEmail = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMailingDtls() { 		
		if ( hasMailingDtls()) {		
			if (hasMailingDtls == FixUtils.TAG_HAS_VALUE) {		
				return mailingDtls; 		
			} else {		
		
				buf.position(hasMailingDtls);		
		
			FixMessage.getTagStringValue(buf, mailingDtls, 0, mailingDtls.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMailingDtls);		
					return null;		
				}		
			}		
			hasMailingDtls = FixUtils.TAG_HAS_VALUE;		
			return mailingDtls;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMailingDtls() { return hasMailingDtls != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMailingDtls(byte[] src) {		
		if (src == null ) return;
		if (hasMailingDtls()) FixUtils.fillNul(mailingDtls);		
		FixUtils.copy(mailingDtls, src); 		
		hasMailingDtls = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMailingDtls(String str) {		
		if (str == null ) return;
		if (hasMailingDtls()) FixUtils.fillNul(mailingDtls);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mailingDtls, src); 		
		hasMailingDtls = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMailingInst() { 		
		if ( hasMailingInst()) {		
			if (hasMailingInst == FixUtils.TAG_HAS_VALUE) {		
				return mailingInst; 		
			} else {		
		
				buf.position(hasMailingInst);		
		
			FixMessage.getTagStringValue(buf, mailingInst, 0, mailingInst.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMailingInst);		
					return null;		
				}		
			}		
			hasMailingInst = FixUtils.TAG_HAS_VALUE;		
			return mailingInst;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMailingInst() { return hasMailingInst != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMailingInst(byte[] src) {		
		if (src == null ) return;
		if (hasMailingInst()) FixUtils.fillNul(mailingInst);		
		FixUtils.copy(mailingInst, src); 		
		hasMailingInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMailingInst(String str) {		
		if (str == null ) return;
		if (hasMailingInst()) FixUtils.fillNul(mailingInst);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mailingInst, src); 		
		hasMailingInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOwnerType() { 		
		if ( hasOwnerType()) {		
			if (hasOwnerType == FixUtils.TAG_HAS_VALUE) {		
				return ownerType; 		
			} else {		
		
				buf.position(hasOwnerType);		
		
			ownerType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOwnerType);		
					return 0;		
				}		
			}		
			hasOwnerType = FixUtils.TAG_HAS_VALUE;		
			return ownerType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOwnerType() { return hasOwnerType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOwnerType(long src) {		
		ownerType = src;
		hasOwnerType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOwnerType(byte[] src) {		
		if (src == null ) return;
		if (hasOwnerType()) ownerType = FixUtils.TAG_HAS_NO_VALUE;		
		ownerType = FixUtils.longValueOf(src, 0, src.length);
		hasOwnerType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOwnerType(String str) {		
		if (str == null ) return;
		if (hasOwnerType()) ownerType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		ownerType = FixUtils.longValueOf(src, 0, src.length);
		hasOwnerType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDateOfBirth() { 		
		if ( hasDateOfBirth()) {		
			if (hasDateOfBirth == FixUtils.TAG_HAS_VALUE) {		
				return dateOfBirth; 		
			} else {		
		
				buf.position(hasDateOfBirth);		
		
			FixMessage.getTagStringValue(buf, dateOfBirth, 0, dateOfBirth.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDateOfBirth);		
					return null;		
				}		
			}		
			hasDateOfBirth = FixUtils.TAG_HAS_VALUE;		
			return dateOfBirth;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDateOfBirth() { return hasDateOfBirth != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDateOfBirth(byte[] src) {		
		if (src == null ) return;
		if (hasDateOfBirth()) FixUtils.fillNul(dateOfBirth);		
		FixUtils.copy(dateOfBirth, src); 		
		hasDateOfBirth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDateOfBirth(String str) {		
		if (str == null ) return;
		if (hasDateOfBirth()) FixUtils.fillNul(dateOfBirth);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(dateOfBirth, src); 		
		hasDateOfBirth = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getInvestorCountryOfResidence() { 		
		if ( hasInvestorCountryOfResidence()) {		
			if (hasInvestorCountryOfResidence == FixUtils.TAG_HAS_VALUE) {		
				return investorCountryOfResidence; 		
			} else {		
		
				buf.position(hasInvestorCountryOfResidence);		
		
			FixMessage.getTagStringValue(buf, investorCountryOfResidence, 0, investorCountryOfResidence.length, err);
		
				if (err.hasError()) {		
					buf.position(hasInvestorCountryOfResidence);		
					return null;		
				}		
			}		
			hasInvestorCountryOfResidence = FixUtils.TAG_HAS_VALUE;		
			return investorCountryOfResidence;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasInvestorCountryOfResidence() { return hasInvestorCountryOfResidence != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setInvestorCountryOfResidence(byte[] src) {		
		if (src == null ) return;
		if (hasInvestorCountryOfResidence()) FixUtils.fillNul(investorCountryOfResidence);		
		FixUtils.copy(investorCountryOfResidence, src); 		
		hasInvestorCountryOfResidence = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setInvestorCountryOfResidence(String str) {		
		if (str == null ) return;
		if (hasInvestorCountryOfResidence()) FixUtils.fillNul(investorCountryOfResidence);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(investorCountryOfResidence, src); 		
		hasInvestorCountryOfResidence = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRegistDtls()) s += "RegistDtls(509)= " + new String( FixUtils.trim(getRegistDtls()) ) + "\n" ; 
		if (hasRegistEmail()) s += "RegistEmail(511)= " + new String( FixUtils.trim(getRegistEmail()) ) + "\n" ; 
		if (hasMailingDtls()) s += "MailingDtls(474)= " + new String( FixUtils.trim(getMailingDtls()) ) + "\n" ; 
		if (hasMailingInst()) s += "MailingInst(482)= " + new String( FixUtils.trim(getMailingInst()) ) + "\n" ; 
		if (hasOwnerType()) s += "OwnerType(522)= " + getOwnerType() + "\n" ; 
		if (hasDateOfBirth()) s += "DateOfBirth(486)= " + new String( FixUtils.trim(getDateOfBirth()) ) + "\n" ; 
		if (hasInvestorCountryOfResidence()) s += "InvestorCountryOfResidence(475)= " + new String( FixUtils.trim(getInvestorCountryOfResidence()) ) + "\n" ; 

		for (FixNestedParties fixNestedParties : nestedParties) fixNestedParties.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRgstDtlsGrp)) return false;

		FixRgstDtlsGrp msg = (FixRgstDtlsGrp) o;

		for (int i = 0; i < nestedParties.length; i++)
			if (!nestedParties[i].equals(msg.nestedParties[i])) return false;
		if ((hasRegistDtls() && !msg.hasRegistDtls()) || (!hasRegistDtls() && msg.hasRegistDtls())) return false;
		if (!(!hasRegistDtls() && !msg.hasRegistDtls()) && !FixUtils.equals(getRegistDtls(), msg.getRegistDtls())) return false;
		if ((hasRegistEmail() && !msg.hasRegistEmail()) || (!hasRegistEmail() && msg.hasRegistEmail())) return false;
		if (!(!hasRegistEmail() && !msg.hasRegistEmail()) && !FixUtils.equals(getRegistEmail(), msg.getRegistEmail())) return false;
		if ((hasMailingDtls() && !msg.hasMailingDtls()) || (!hasMailingDtls() && msg.hasMailingDtls())) return false;
		if (!(!hasMailingDtls() && !msg.hasMailingDtls()) && !FixUtils.equals(getMailingDtls(), msg.getMailingDtls())) return false;
		if ((hasMailingInst() && !msg.hasMailingInst()) || (!hasMailingInst() && msg.hasMailingInst())) return false;
		if (!(!hasMailingInst() && !msg.hasMailingInst()) && !FixUtils.equals(getMailingInst(), msg.getMailingInst())) return false;
		if ((hasOwnerType() && !msg.hasOwnerType()) || (!hasOwnerType() && msg.hasOwnerType())) return false;
		if (!(!hasOwnerType() && !msg.hasOwnerType()) && !(getOwnerType()==msg.getOwnerType())) return false;
		if ((hasDateOfBirth() && !msg.hasDateOfBirth()) || (!hasDateOfBirth() && msg.hasDateOfBirth())) return false;
		if ((hasInvestorCountryOfResidence() && !msg.hasInvestorCountryOfResidence()) || (!hasInvestorCountryOfResidence() && msg.hasInvestorCountryOfResidence())) return false;
		if (!(!hasInvestorCountryOfResidence() && !msg.hasInvestorCountryOfResidence()) && !FixUtils.equals(getInvestorCountryOfResidence(), msg.getInvestorCountryOfResidence())) return false;
		return true;
	}
	public FixRgstDtlsGrp clone ( FixRgstDtlsGrp out ) {
		if ( hasRegistDtls())
			out.setRegistDtls(getRegistDtls());
		if ( hasRegistEmail())
			out.setRegistEmail(getRegistEmail());
		if ( hasMailingDtls())
			out.setMailingDtls(getMailingDtls());
		if ( hasMailingInst())
			out.setMailingInst(getMailingInst());
		if ( hasOwnerType())
			out.setOwnerType(getOwnerType());
		if ( hasDateOfBirth())
			out.setDateOfBirth(getDateOfBirth());
		if ( hasInvestorCountryOfResidence())
			out.setInvestorCountryOfResidence(getInvestorCountryOfResidence());
		int count = 0;
		count = 0;
		for (FixNestedParties fixNestedParties : nestedParties) {
			if (!fixNestedParties.hasGroup()) continue;
			out.nestedParties[count] = fixNestedParties.clone( out.nestedParties[count] );
			count++;
		}
		return out;
	}

}
