package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSettlInstGrp extends FixGroup {
	private short hasSettlInstID;
	byte[] settlInstID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlInstTransType;
	byte settlInstTransType = (byte)' ';		
	private short hasSettlInstRefID;
	byte[] settlInstRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasProduct;
	long product = 0;		
	private short hasSecurityType;
	byte[] securityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCFICode;
	byte[] cFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlCurrency;
	byte[] settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasEffectiveTime;
	byte[] effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasExpireTime;
	byte[] expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasLastUpdateTime;
	byte[] lastUpdateTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasPaymentMethod;
	long paymentMethod = 0;		
	private short hasPaymentRef;
	byte[] paymentRef = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCardHolderName;
	byte[] cardHolderName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCardNumber;
	byte[] cardNumber = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCardStartDate;
	byte[] cardStartDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCardExpDate;
	byte[] cardExpDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCardIssNum;
	byte[] cardIssNum = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPaymentDate;
	byte[] paymentDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPaymentRemitterID;
	byte[] paymentRemitterID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixParties[] parties;
		public FixSettlInstructionsData settlInstructionsData;
	
	public FixSettlInstGrp() {
		this(false);
	}

	public FixSettlInstGrp(boolean isRequired) {
		super(FixTags.SETTLINSTID_INT);

		this.isRequired = isRequired;
		
		hasSettlInstID = FixUtils.TAG_HAS_NO_VALUE;		
		settlInstID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlInstTransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlInstRefID = FixUtils.TAG_HAS_NO_VALUE;		
		settlInstRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasProduct = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		securityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCFICode = FixUtils.TAG_HAS_NO_VALUE;		
		cFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasEffectiveTime = FixUtils.TAG_HAS_NO_VALUE;		
		effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;		
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasLastUpdateTime = FixUtils.TAG_HAS_NO_VALUE;		
		lastUpdateTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasPaymentMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasPaymentRef = FixUtils.TAG_HAS_NO_VALUE;		
		paymentRef = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCardHolderName = FixUtils.TAG_HAS_NO_VALUE;		
		cardHolderName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCardNumber = FixUtils.TAG_HAS_NO_VALUE;		
		cardNumber = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCardStartDate = FixUtils.TAG_HAS_NO_VALUE;		
		cardStartDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCardExpDate = FixUtils.TAG_HAS_NO_VALUE;		
		cardExpDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCardIssNum = FixUtils.TAG_HAS_NO_VALUE;		
		cardIssNum = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPaymentDate = FixUtils.TAG_HAS_NO_VALUE;		
		paymentDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPaymentRemitterID = FixUtils.TAG_HAS_NO_VALUE;		
		paymentRemitterID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		settlInstructionsData = new FixSettlInstructionsData();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSettlInstID()) return true;
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
            	case FixTags.SETTLINSTID_INT:		
            		hasSettlInstID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLINSTTRANSTYPE_INT:		
            		hasSettlInstTransType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLINSTREFID_INT:		
            		hasSettlInstRefID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PRODUCT_INT:		
            		hasProduct = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYTYPE_INT:		
            		hasSecurityType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CFICODE_INT:		
            		hasCFICode = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLCURRENCY_INT:		
            		hasSettlCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.EFFECTIVETIME_INT:		
            		hasEffectiveTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.EXPIRETIME_INT:		
            		hasExpireTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.LASTUPDATETIME_INT:		
            		hasLastUpdateTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PAYMENTMETHOD_INT:		
            		hasPaymentMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PAYMENTREF_INT:		
            		hasPaymentRef = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CARDHOLDERNAME_INT:		
            		hasCardHolderName = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CARDNUMBER_INT:		
            		hasCardNumber = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CARDSTARTDATE_INT:		
            		hasCardStartDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CARDEXPDATE_INT:		
            		hasCardExpDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CARDISSNUM_INT:		
            		hasCardIssNum = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PAYMENTDATE_INT:		
            		hasPaymentDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PAYMENTREMITTERID_INT:		
            		hasPaymentRemitterID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !parties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( settlInstructionsData.isKeyTag(tag)) {
        				tag = settlInstructionsData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
            		} else { return tag; }
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
		hasSettlInstID = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlInstTransType = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlInstRefID = FixUtils.TAG_HAS_NO_VALUE;
		hasSide = FixUtils.TAG_HAS_NO_VALUE;
		hasProduct = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityType = FixUtils.TAG_HAS_NO_VALUE;
		hasCFICode = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasEffectiveTime = FixUtils.TAG_HAS_NO_VALUE;
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;
		hasLastUpdateTime = FixUtils.TAG_HAS_NO_VALUE;
		hasPaymentMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasPaymentRef = FixUtils.TAG_HAS_NO_VALUE;
		hasCardHolderName = FixUtils.TAG_HAS_NO_VALUE;
		hasCardNumber = FixUtils.TAG_HAS_NO_VALUE;
		hasCardStartDate = FixUtils.TAG_HAS_NO_VALUE;
		hasCardExpDate = FixUtils.TAG_HAS_NO_VALUE;
		hasCardIssNum = FixUtils.TAG_HAS_NO_VALUE;
		hasPaymentDate = FixUtils.TAG_HAS_NO_VALUE;
		hasPaymentRemitterID = FixUtils.TAG_HAS_NO_VALUE;
		for (FixParties fixParties : parties) fixParties.clear();
		settlInstructionsData.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSettlInstID()) {		
			out.put(FixTags.SETTLINSTID);

			out.put((byte) '=');

			FixUtils.put(out,settlInstID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlInstTransType()) {		
			out.put(FixTags.SETTLINSTTRANSTYPE);

			out.put((byte) '=');

			FixUtils.put(out,settlInstTransType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlInstRefID()) {		
			out.put(FixTags.SETTLINSTREFID);

			out.put((byte) '=');

			FixUtils.put(out,settlInstRefID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSide()) {		
			out.put(FixTags.SIDE);

			out.put((byte) '=');

			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasProduct()) {		
			out.put(FixTags.PRODUCT);

			out.put((byte) '=');

			FixUtils.put(out, (long)product);
		
			out.put(FixUtils.SOH);

            }

		if (hasSecurityType()) {		
			out.put(FixTags.SECURITYTYPE);

			out.put((byte) '=');

			FixUtils.put(out,securityType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCFICode()) {		
			out.put(FixTags.CFICODE);

			out.put((byte) '=');

			FixUtils.put(out,cFICode); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlCurrency()) {		
			out.put(FixTags.SETTLCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,settlCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEffectiveTime()) {		
			out.put(FixTags.EFFECTIVETIME);

			out.put((byte) '=');

			FixUtils.put(out,effectiveTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasExpireTime()) {		
			out.put(FixTags.EXPIRETIME);

			out.put((byte) '=');

			FixUtils.put(out,expireTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLastUpdateTime()) {		
			out.put(FixTags.LASTUPDATETIME);

			out.put((byte) '=');

			FixUtils.put(out,lastUpdateTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPaymentMethod()) {		
			out.put(FixTags.PAYMENTMETHOD);

			out.put((byte) '=');

			FixUtils.put(out, (long)paymentMethod);
		
			out.put(FixUtils.SOH);

            }

		if (hasPaymentRef()) {		
			out.put(FixTags.PAYMENTREF);

			out.put((byte) '=');

			FixUtils.put(out,paymentRef); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCardHolderName()) {		
			out.put(FixTags.CARDHOLDERNAME);

			out.put((byte) '=');

			FixUtils.put(out,cardHolderName); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCardNumber()) {		
			out.put(FixTags.CARDNUMBER);

			out.put((byte) '=');

			FixUtils.put(out,cardNumber); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCardStartDate()) {		
			out.put(FixTags.CARDSTARTDATE);

			out.put((byte) '=');

			FixUtils.put(out,cardStartDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCardExpDate()) {		
			out.put(FixTags.CARDEXPDATE);

			out.put((byte) '=');

			FixUtils.put(out,cardExpDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCardIssNum()) {		
			out.put(FixTags.CARDISSNUM);

			out.put((byte) '=');

			FixUtils.put(out,cardIssNum); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPaymentDate()) {		
			out.put(FixTags.PAYMENTDATE);

			out.put((byte) '=');

			FixUtils.put(out,paymentDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPaymentRemitterID()) {		
			out.put(FixTags.PAYMENTREMITTERID);

			out.put((byte) '=');

			FixUtils.put(out,paymentRemitterID); 		
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		settlInstructionsData.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSettlInstID()) {		
			FixUtils.put(out,settlInstID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlInstTransType()) {		
			FixUtils.put(out,settlInstTransType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlInstRefID()) {		
			FixUtils.put(out,settlInstRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasProduct()) {		
			FixUtils.put(out, (long)product);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityType()) {		
			FixUtils.put(out,securityType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCFICode()) {		
			FixUtils.put(out,cFICode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrency()) {		
			FixUtils.put(out,settlCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEffectiveTime()) {		
			FixUtils.put(out,effectiveTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExpireTime()) {		
			FixUtils.put(out,expireTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLastUpdateTime()) {		
			FixUtils.put(out,lastUpdateTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPaymentMethod()) {		
			FixUtils.put(out, (long)paymentMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPaymentRef()) {		
			FixUtils.put(out,paymentRef); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCardHolderName()) {		
			FixUtils.put(out,cardHolderName); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCardNumber()) {		
			FixUtils.put(out,cardNumber); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCardStartDate()) {		
			FixUtils.put(out,cardStartDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCardExpDate()) {		
			FixUtils.put(out,cardExpDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCardIssNum()) {		
			FixUtils.put(out,cardIssNum); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPaymentDate()) {		
			FixUtils.put(out,paymentDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPaymentRemitterID()) {		
			FixUtils.put(out,paymentRemitterID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixParties fixParties : parties) fixParties.printBuffer(out);
		settlInstructionsData.printBuffer(out);
	}

	public byte[] getSettlInstID() { 		
		if ( hasSettlInstID()) {		
			if (hasSettlInstID == FixUtils.TAG_HAS_VALUE) {		
				return settlInstID; 		
			} else {		
		
				buf.position(hasSettlInstID);		
		
			FixUtils.getTagStringValue(buf, settlInstID, 0, settlInstID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlInstID);		
					return null;		
				}		
			}		
			hasSettlInstID = FixUtils.TAG_HAS_VALUE;		
			return settlInstID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlInstID() { return hasSettlInstID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlInstID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlInstID()) FixUtils.fillNul(settlInstID);		
		FixUtils.copy(settlInstID, src); 		
		hasSettlInstID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlInstID(String str) {		
		if (str == null ) return;
		if (hasSettlInstID()) FixUtils.fillNul(settlInstID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlInstID, src); 		
		hasSettlInstID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getSettlInstTransType() { 		
		if ( hasSettlInstTransType()) {		
			if (hasSettlInstTransType == FixUtils.TAG_HAS_VALUE) {		
				return settlInstTransType; 		
			} else {		
		
				buf.position(hasSettlInstTransType);		
		
			settlInstTransType = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (settlInstTransType != (byte)'T') && (settlInstTransType != (byte)'R') && (settlInstTransType != (byte)'C') && (settlInstTransType != (byte)'N') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 163);		
				if (err.hasError()) {		
					buf.position(hasSettlInstTransType);		
					return (byte)'0';		
				}		
			}		
			hasSettlInstTransType = FixUtils.TAG_HAS_VALUE;		
			return settlInstTransType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSettlInstTransType() { return hasSettlInstTransType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlInstTransType(byte src) {		
		settlInstTransType = src;
		hasSettlInstTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlInstTransType(byte[] src) {		
		if (src == null ) return;
		if (hasSettlInstTransType()) settlInstTransType = (byte)' ';		
		settlInstTransType = src[0];		
		hasSettlInstTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlInstTransType(String str) {		
		if (str == null ) return;
		if (hasSettlInstTransType()) settlInstTransType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		settlInstTransType = src[0];		
		hasSettlInstTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSettlInstRefID() { 		
		if ( hasSettlInstRefID()) {		
			if (hasSettlInstRefID == FixUtils.TAG_HAS_VALUE) {		
				return settlInstRefID; 		
			} else {		
		
				buf.position(hasSettlInstRefID);		
		
			FixUtils.getTagStringValue(buf, settlInstRefID, 0, settlInstRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlInstRefID);		
					return null;		
				}		
			}		
			hasSettlInstRefID = FixUtils.TAG_HAS_VALUE;		
			return settlInstRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlInstRefID() { return hasSettlInstRefID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlInstRefID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlInstRefID()) FixUtils.fillNul(settlInstRefID);		
		FixUtils.copy(settlInstRefID, src); 		
		hasSettlInstRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlInstRefID(String str) {		
		if (str == null ) return;
		if (hasSettlInstRefID()) FixUtils.fillNul(settlInstRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlInstRefID, src); 		
		hasSettlInstRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getSide() { 		
		if ( hasSide()) {		
			if (hasSide == FixUtils.TAG_HAS_VALUE) {		
				return side; 		
			} else {		
		
				buf.position(hasSide);		
		
			side = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (side != (byte)'D') && (side != (byte)'E') && (side != (byte)'F') && (side != (byte)'G') && (side != (byte)'A') && (side != (byte)'B') && (side != (byte)'C') && (side != (byte)'3') && (side != (byte)'2') && (side != (byte)'1') && (side != (byte)'7') && (side != (byte)'6') && (side != (byte)'5') && (side != (byte)'4') && (side != (byte)'9') && (side != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 54);		
				if (err.hasError()) {		
					buf.position(hasSide);		
					return (byte)'0';		
				}		
			}		
			hasSide = FixUtils.TAG_HAS_VALUE;		
			return side;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSide() { return hasSide != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSide(byte src) {		
		side = src;
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(byte[] src) {		
		if (src == null ) return;
		if (hasSide()) side = (byte)' ';		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSide(String str) {		
		if (str == null ) return;
		if (hasSide()) side = (byte)' ';		
		byte[] src = str.getBytes(); 		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getProduct() { 		
		if ( hasProduct()) {		
			if (hasProduct == FixUtils.TAG_HAS_VALUE) {		
				return product; 		
			} else {		
		
				buf.position(hasProduct);		
		
			product = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasProduct);		
					return 0;		
				}		
			}		
			hasProduct = FixUtils.TAG_HAS_VALUE;		
			return product;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasProduct() { return hasProduct != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setProduct(long src) {		
		product = src;
		hasProduct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProduct(byte[] src) {		
		if (src == null ) return;
		if (hasProduct()) product = FixUtils.TAG_HAS_NO_VALUE;		
		product = FixUtils.longValueOf(src, 0, src.length);
		hasProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setProduct(String str) {		
		if (str == null ) return;
		if (hasProduct()) product = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		product = FixUtils.longValueOf(src, 0, src.length);
		hasProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecurityType() { 		
		if ( hasSecurityType()) {		
			if (hasSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return securityType; 		
			} else {		
		
				buf.position(hasSecurityType);		
		
			FixUtils.getTagStringValue(buf, securityType, 0, securityType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityType);		
					return null;		
				}		
			}		
			hasSecurityType = FixUtils.TAG_HAS_VALUE;		
			return securityType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityType() { return hasSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityType()) FixUtils.fillNul(securityType);		
		FixUtils.copy(securityType, src); 		
		hasSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityType(String str) {		
		if (str == null ) return;
		if (hasSecurityType()) FixUtils.fillNul(securityType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityType, src); 		
		hasSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCFICode() { 		
		if ( hasCFICode()) {		
			if (hasCFICode == FixUtils.TAG_HAS_VALUE) {		
				return cFICode; 		
			} else {		
		
				buf.position(hasCFICode);		
		
			FixUtils.getTagStringValue(buf, cFICode, 0, cFICode.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCFICode);		
					return null;		
				}		
			}		
			hasCFICode = FixUtils.TAG_HAS_VALUE;		
			return cFICode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCFICode() { return hasCFICode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCFICode(byte[] src) {		
		if (src == null ) return;
		if (hasCFICode()) FixUtils.fillNul(cFICode);		
		FixUtils.copy(cFICode, src); 		
		hasCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCFICode(String str) {		
		if (str == null ) return;
		if (hasCFICode()) FixUtils.fillNul(cFICode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cFICode, src); 		
		hasCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSettlCurrency() { 		
		if ( hasSettlCurrency()) {		
			if (hasSettlCurrency == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrency; 		
			} else {		
		
				buf.position(hasSettlCurrency);		
		
			FixUtils.getTagStringValue(buf, settlCurrency, 0, settlCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlCurrency);		
					return null;		
				}		
			}		
			hasSettlCurrency = FixUtils.TAG_HAS_VALUE;		
			return settlCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlCurrency() { return hasSettlCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrency()) FixUtils.fillNul(settlCurrency);		
		FixUtils.copy(settlCurrency, src); 		
		hasSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlCurrency(String str) {		
		if (str == null ) return;
		if (hasSettlCurrency()) FixUtils.fillNul(settlCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlCurrency, src); 		
		hasSettlCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEffectiveTime() { 		
		if ( hasEffectiveTime()) {		
			if (hasEffectiveTime == FixUtils.TAG_HAS_VALUE) {		
				return effectiveTime; 		
			} else {		
		
				buf.position(hasEffectiveTime);		
		
			FixUtils.getTagStringValue(buf, effectiveTime, 0, effectiveTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEffectiveTime);		
					return null;		
				}		
			}		
			hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
			return effectiveTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEffectiveTime() { return hasEffectiveTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEffectiveTime(byte[] src) {		
		if (src == null ) return;
		if (hasEffectiveTime()) FixUtils.fillNul(effectiveTime);		
		FixUtils.copy(effectiveTime, src); 		
		hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEffectiveTime(String str) {		
		if (str == null ) return;
		if (hasEffectiveTime()) FixUtils.fillNul(effectiveTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(effectiveTime, src); 		
		hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getExpireTime() { 		
		if ( hasExpireTime()) {		
			if (hasExpireTime == FixUtils.TAG_HAS_VALUE) {		
				return expireTime; 		
			} else {		
		
				buf.position(hasExpireTime);		
		
			FixUtils.getTagStringValue(buf, expireTime, 0, expireTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasExpireTime);		
					return null;		
				}		
			}		
			hasExpireTime = FixUtils.TAG_HAS_VALUE;		
			return expireTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExpireTime() { return hasExpireTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setExpireTime(byte[] src) {		
		if (src == null ) return;
		if (hasExpireTime()) FixUtils.fillNul(expireTime);		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setExpireTime(String str) {		
		if (str == null ) return;
		if (hasExpireTime()) FixUtils.fillNul(expireTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLastUpdateTime() { 		
		if ( hasLastUpdateTime()) {		
			if (hasLastUpdateTime == FixUtils.TAG_HAS_VALUE) {		
				return lastUpdateTime; 		
			} else {		
		
				buf.position(hasLastUpdateTime);		
		
			FixUtils.getTagStringValue(buf, lastUpdateTime, 0, lastUpdateTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLastUpdateTime);		
					return null;		
				}		
			}		
			hasLastUpdateTime = FixUtils.TAG_HAS_VALUE;		
			return lastUpdateTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLastUpdateTime() { return hasLastUpdateTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLastUpdateTime(byte[] src) {		
		if (src == null ) return;
		if (hasLastUpdateTime()) FixUtils.fillNul(lastUpdateTime);		
		FixUtils.copy(lastUpdateTime, src); 		
		hasLastUpdateTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLastUpdateTime(String str) {		
		if (str == null ) return;
		if (hasLastUpdateTime()) FixUtils.fillNul(lastUpdateTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(lastUpdateTime, src); 		
		hasLastUpdateTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPaymentMethod() { 		
		if ( hasPaymentMethod()) {		
			if (hasPaymentMethod == FixUtils.TAG_HAS_VALUE) {		
				return paymentMethod; 		
			} else {		
		
				buf.position(hasPaymentMethod);		
		
			paymentMethod = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPaymentMethod);		
					return 0;		
				}		
			}		
			hasPaymentMethod = FixUtils.TAG_HAS_VALUE;		
			return paymentMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPaymentMethod() { return hasPaymentMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPaymentMethod(long src) {		
		paymentMethod = src;
		hasPaymentMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPaymentMethod(byte[] src) {		
		if (src == null ) return;
		if (hasPaymentMethod()) paymentMethod = FixUtils.TAG_HAS_NO_VALUE;		
		paymentMethod = FixUtils.longValueOf(src, 0, src.length);
		hasPaymentMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPaymentMethod(String str) {		
		if (str == null ) return;
		if (hasPaymentMethod()) paymentMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		paymentMethod = FixUtils.longValueOf(src, 0, src.length);
		hasPaymentMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getPaymentRef() { 		
		if ( hasPaymentRef()) {		
			if (hasPaymentRef == FixUtils.TAG_HAS_VALUE) {		
				return paymentRef; 		
			} else {		
		
				buf.position(hasPaymentRef);		
		
			FixUtils.getTagStringValue(buf, paymentRef, 0, paymentRef.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPaymentRef);		
					return null;		
				}		
			}		
			hasPaymentRef = FixUtils.TAG_HAS_VALUE;		
			return paymentRef;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPaymentRef() { return hasPaymentRef != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPaymentRef(byte[] src) {		
		if (src == null ) return;
		if (hasPaymentRef()) FixUtils.fillNul(paymentRef);		
		FixUtils.copy(paymentRef, src); 		
		hasPaymentRef = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPaymentRef(String str) {		
		if (str == null ) return;
		if (hasPaymentRef()) FixUtils.fillNul(paymentRef);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(paymentRef, src); 		
		hasPaymentRef = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCardHolderName() { 		
		if ( hasCardHolderName()) {		
			if (hasCardHolderName == FixUtils.TAG_HAS_VALUE) {		
				return cardHolderName; 		
			} else {		
		
				buf.position(hasCardHolderName);		
		
			FixUtils.getTagStringValue(buf, cardHolderName, 0, cardHolderName.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCardHolderName);		
					return null;		
				}		
			}		
			hasCardHolderName = FixUtils.TAG_HAS_VALUE;		
			return cardHolderName;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCardHolderName() { return hasCardHolderName != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCardHolderName(byte[] src) {		
		if (src == null ) return;
		if (hasCardHolderName()) FixUtils.fillNul(cardHolderName);		
		FixUtils.copy(cardHolderName, src); 		
		hasCardHolderName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCardHolderName(String str) {		
		if (str == null ) return;
		if (hasCardHolderName()) FixUtils.fillNul(cardHolderName);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cardHolderName, src); 		
		hasCardHolderName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCardNumber() { 		
		if ( hasCardNumber()) {		
			if (hasCardNumber == FixUtils.TAG_HAS_VALUE) {		
				return cardNumber; 		
			} else {		
		
				buf.position(hasCardNumber);		
		
			FixUtils.getTagStringValue(buf, cardNumber, 0, cardNumber.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCardNumber);		
					return null;		
				}		
			}		
			hasCardNumber = FixUtils.TAG_HAS_VALUE;		
			return cardNumber;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCardNumber() { return hasCardNumber != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCardNumber(byte[] src) {		
		if (src == null ) return;
		if (hasCardNumber()) FixUtils.fillNul(cardNumber);		
		FixUtils.copy(cardNumber, src); 		
		hasCardNumber = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCardNumber(String str) {		
		if (str == null ) return;
		if (hasCardNumber()) FixUtils.fillNul(cardNumber);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cardNumber, src); 		
		hasCardNumber = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCardStartDate() { 		
		if ( hasCardStartDate()) {		
			if (hasCardStartDate == FixUtils.TAG_HAS_VALUE) {		
				return cardStartDate; 		
			} else {		
		
				buf.position(hasCardStartDate);		
		
			FixUtils.getTagStringValue(buf, cardStartDate, 0, cardStartDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCardStartDate);		
					return null;		
				}		
			}		
			hasCardStartDate = FixUtils.TAG_HAS_VALUE;		
			return cardStartDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCardStartDate() { return hasCardStartDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCardStartDate(byte[] src) {		
		if (src == null ) return;
		if (hasCardStartDate()) FixUtils.fillNul(cardStartDate);		
		FixUtils.copy(cardStartDate, src); 		
		hasCardStartDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCardStartDate(String str) {		
		if (str == null ) return;
		if (hasCardStartDate()) FixUtils.fillNul(cardStartDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cardStartDate, src); 		
		hasCardStartDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCardExpDate() { 		
		if ( hasCardExpDate()) {		
			if (hasCardExpDate == FixUtils.TAG_HAS_VALUE) {		
				return cardExpDate; 		
			} else {		
		
				buf.position(hasCardExpDate);		
		
			FixUtils.getTagStringValue(buf, cardExpDate, 0, cardExpDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCardExpDate);		
					return null;		
				}		
			}		
			hasCardExpDate = FixUtils.TAG_HAS_VALUE;		
			return cardExpDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCardExpDate() { return hasCardExpDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCardExpDate(byte[] src) {		
		if (src == null ) return;
		if (hasCardExpDate()) FixUtils.fillNul(cardExpDate);		
		FixUtils.copy(cardExpDate, src); 		
		hasCardExpDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCardExpDate(String str) {		
		if (str == null ) return;
		if (hasCardExpDate()) FixUtils.fillNul(cardExpDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cardExpDate, src); 		
		hasCardExpDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCardIssNum() { 		
		if ( hasCardIssNum()) {		
			if (hasCardIssNum == FixUtils.TAG_HAS_VALUE) {		
				return cardIssNum; 		
			} else {		
		
				buf.position(hasCardIssNum);		
		
			FixUtils.getTagStringValue(buf, cardIssNum, 0, cardIssNum.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCardIssNum);		
					return null;		
				}		
			}		
			hasCardIssNum = FixUtils.TAG_HAS_VALUE;		
			return cardIssNum;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCardIssNum() { return hasCardIssNum != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCardIssNum(byte[] src) {		
		if (src == null ) return;
		if (hasCardIssNum()) FixUtils.fillNul(cardIssNum);		
		FixUtils.copy(cardIssNum, src); 		
		hasCardIssNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCardIssNum(String str) {		
		if (str == null ) return;
		if (hasCardIssNum()) FixUtils.fillNul(cardIssNum);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(cardIssNum, src); 		
		hasCardIssNum = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getPaymentDate() { 		
		if ( hasPaymentDate()) {		
			if (hasPaymentDate == FixUtils.TAG_HAS_VALUE) {		
				return paymentDate; 		
			} else {		
		
				buf.position(hasPaymentDate);		
		
			FixUtils.getTagStringValue(buf, paymentDate, 0, paymentDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPaymentDate);		
					return null;		
				}		
			}		
			hasPaymentDate = FixUtils.TAG_HAS_VALUE;		
			return paymentDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPaymentDate() { return hasPaymentDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPaymentDate(byte[] src) {		
		if (src == null ) return;
		if (hasPaymentDate()) FixUtils.fillNul(paymentDate);		
		FixUtils.copy(paymentDate, src); 		
		hasPaymentDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPaymentDate(String str) {		
		if (str == null ) return;
		if (hasPaymentDate()) FixUtils.fillNul(paymentDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(paymentDate, src); 		
		hasPaymentDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getPaymentRemitterID() { 		
		if ( hasPaymentRemitterID()) {		
			if (hasPaymentRemitterID == FixUtils.TAG_HAS_VALUE) {		
				return paymentRemitterID; 		
			} else {		
		
				buf.position(hasPaymentRemitterID);		
		
			FixUtils.getTagStringValue(buf, paymentRemitterID, 0, paymentRemitterID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPaymentRemitterID);		
					return null;		
				}		
			}		
			hasPaymentRemitterID = FixUtils.TAG_HAS_VALUE;		
			return paymentRemitterID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPaymentRemitterID() { return hasPaymentRemitterID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPaymentRemitterID(byte[] src) {		
		if (src == null ) return;
		if (hasPaymentRemitterID()) FixUtils.fillNul(paymentRemitterID);		
		FixUtils.copy(paymentRemitterID, src); 		
		hasPaymentRemitterID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPaymentRemitterID(String str) {		
		if (str == null ) return;
		if (hasPaymentRemitterID()) FixUtils.fillNul(paymentRemitterID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(paymentRemitterID, src); 		
		hasPaymentRemitterID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSettlInstID()) s += "SettlInstID(162)= " + new String( FixUtils.trim(getSettlInstID()) ) + "\n" ; 
		if (hasSettlInstTransType()) s += "SettlInstTransType(163)= " + getSettlInstTransType() + "\n" ; 
		if (hasSettlInstRefID()) s += "SettlInstRefID(214)= " + new String( FixUtils.trim(getSettlInstRefID()) ) + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasProduct()) s += "Product(460)= " + getProduct() + "\n" ; 
		if (hasSecurityType()) s += "SecurityType(167)= " + new String( FixUtils.trim(getSecurityType()) ) + "\n" ; 
		if (hasCFICode()) s += "CFICode(461)= " + new String( FixUtils.trim(getCFICode()) ) + "\n" ; 
		if (hasSettlCurrency()) s += "SettlCurrency(120)= " + new String( FixUtils.trim(getSettlCurrency()) ) + "\n" ; 
		if (hasEffectiveTime()) s += "EffectiveTime(168)= " + new String( FixUtils.trim(getEffectiveTime()) ) + "\n" ; 
		if (hasExpireTime()) s += "ExpireTime(126)= " + new String( FixUtils.trim(getExpireTime()) ) + "\n" ; 
		if (hasLastUpdateTime()) s += "LastUpdateTime(779)= " + new String( FixUtils.trim(getLastUpdateTime()) ) + "\n" ; 
		if (hasPaymentMethod()) s += "PaymentMethod(492)= " + getPaymentMethod() + "\n" ; 
		if (hasPaymentRef()) s += "PaymentRef(476)= " + new String( FixUtils.trim(getPaymentRef()) ) + "\n" ; 
		if (hasCardHolderName()) s += "CardHolderName(488)= " + new String( FixUtils.trim(getCardHolderName()) ) + "\n" ; 
		if (hasCardNumber()) s += "CardNumber(489)= " + new String( FixUtils.trim(getCardNumber()) ) + "\n" ; 
		if (hasCardStartDate()) s += "CardStartDate(503)= " + new String( FixUtils.trim(getCardStartDate()) ) + "\n" ; 
		if (hasCardExpDate()) s += "CardExpDate(490)= " + new String( FixUtils.trim(getCardExpDate()) ) + "\n" ; 
		if (hasCardIssNum()) s += "CardIssNum(491)= " + new String( FixUtils.trim(getCardIssNum()) ) + "\n" ; 
		if (hasPaymentDate()) s += "PaymentDate(504)= " + new String( FixUtils.trim(getPaymentDate()) ) + "\n" ; 
		if (hasPaymentRemitterID()) s += "PaymentRemitterID(505)= " + new String( FixUtils.trim(getPaymentRemitterID()) ) + "\n" ; 

		for (FixParties fixParties : parties) fixParties.toString();
		s += settlInstructionsData.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSettlInstGrp)) return false;

		FixSettlInstGrp msg = (FixSettlInstGrp) o;

		for (int i = 0; i < parties.length; i++)
			if (!parties[i].equals(msg.parties[i])) return false;
		if (!settlInstructionsData.equals(msg.settlInstructionsData)) return false;
		if ((hasSettlInstID() && !msg.hasSettlInstID()) || (!hasSettlInstID() && msg.hasSettlInstID())) return false;
		if (!(!hasSettlInstID() && !msg.hasSettlInstID()) && !FixUtils.equals(getSettlInstID(), msg.getSettlInstID())) return false;
		if ((hasSettlInstTransType() && !msg.hasSettlInstTransType()) || (!hasSettlInstTransType() && msg.hasSettlInstTransType())) return false;
		if (!(!hasSettlInstTransType() && !msg.hasSettlInstTransType()) && !(getSettlInstTransType()==msg.getSettlInstTransType())) return false;
		if ((hasSettlInstRefID() && !msg.hasSettlInstRefID()) || (!hasSettlInstRefID() && msg.hasSettlInstRefID())) return false;
		if (!(!hasSettlInstRefID() && !msg.hasSettlInstRefID()) && !FixUtils.equals(getSettlInstRefID(), msg.getSettlInstRefID())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasProduct() && !msg.hasProduct()) || (!hasProduct() && msg.hasProduct())) return false;
		if (!(!hasProduct() && !msg.hasProduct()) && !(getProduct()==msg.getProduct())) return false;
		if ((hasSecurityType() && !msg.hasSecurityType()) || (!hasSecurityType() && msg.hasSecurityType())) return false;
		if (!(!hasSecurityType() && !msg.hasSecurityType()) && !FixUtils.equals(getSecurityType(), msg.getSecurityType())) return false;
		if ((hasCFICode() && !msg.hasCFICode()) || (!hasCFICode() && msg.hasCFICode())) return false;
		if (!(!hasCFICode() && !msg.hasCFICode()) && !FixUtils.equals(getCFICode(), msg.getCFICode())) return false;
		if ((hasSettlCurrency() && !msg.hasSettlCurrency()) || (!hasSettlCurrency() && msg.hasSettlCurrency())) return false;
		if (!(!hasSettlCurrency() && !msg.hasSettlCurrency()) && !FixUtils.equals(getSettlCurrency(), msg.getSettlCurrency())) return false;
		if ((hasEffectiveTime() && !msg.hasEffectiveTime()) || (!hasEffectiveTime() && msg.hasEffectiveTime())) return false;
		if ((hasExpireTime() && !msg.hasExpireTime()) || (!hasExpireTime() && msg.hasExpireTime())) return false;
		if ((hasLastUpdateTime() && !msg.hasLastUpdateTime()) || (!hasLastUpdateTime() && msg.hasLastUpdateTime())) return false;
		if ((hasPaymentMethod() && !msg.hasPaymentMethod()) || (!hasPaymentMethod() && msg.hasPaymentMethod())) return false;
		if (!(!hasPaymentMethod() && !msg.hasPaymentMethod()) && !(getPaymentMethod()==msg.getPaymentMethod())) return false;
		if ((hasPaymentRef() && !msg.hasPaymentRef()) || (!hasPaymentRef() && msg.hasPaymentRef())) return false;
		if (!(!hasPaymentRef() && !msg.hasPaymentRef()) && !FixUtils.equals(getPaymentRef(), msg.getPaymentRef())) return false;
		if ((hasCardHolderName() && !msg.hasCardHolderName()) || (!hasCardHolderName() && msg.hasCardHolderName())) return false;
		if (!(!hasCardHolderName() && !msg.hasCardHolderName()) && !FixUtils.equals(getCardHolderName(), msg.getCardHolderName())) return false;
		if ((hasCardNumber() && !msg.hasCardNumber()) || (!hasCardNumber() && msg.hasCardNumber())) return false;
		if (!(!hasCardNumber() && !msg.hasCardNumber()) && !FixUtils.equals(getCardNumber(), msg.getCardNumber())) return false;
		if ((hasCardStartDate() && !msg.hasCardStartDate()) || (!hasCardStartDate() && msg.hasCardStartDate())) return false;
		if ((hasCardExpDate() && !msg.hasCardExpDate()) || (!hasCardExpDate() && msg.hasCardExpDate())) return false;
		if ((hasCardIssNum() && !msg.hasCardIssNum()) || (!hasCardIssNum() && msg.hasCardIssNum())) return false;
		if (!(!hasCardIssNum() && !msg.hasCardIssNum()) && !FixUtils.equals(getCardIssNum(), msg.getCardIssNum())) return false;
		if ((hasPaymentDate() && !msg.hasPaymentDate()) || (!hasPaymentDate() && msg.hasPaymentDate())) return false;
		if ((hasPaymentRemitterID() && !msg.hasPaymentRemitterID()) || (!hasPaymentRemitterID() && msg.hasPaymentRemitterID())) return false;
		if (!(!hasPaymentRemitterID() && !msg.hasPaymentRemitterID()) && !FixUtils.equals(getPaymentRemitterID(), msg.getPaymentRemitterID())) return false;
		return true;
	}
	public FixSettlInstGrp clone ( FixSettlInstGrp out ) {
		if ( hasSettlInstID())
			out.setSettlInstID(getSettlInstID());
		if ( hasSettlInstTransType())
			out.setSettlInstTransType(getSettlInstTransType());
		if ( hasSettlInstRefID())
			out.setSettlInstRefID(getSettlInstRefID());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasProduct())
			out.setProduct(getProduct());
		if ( hasSecurityType())
			out.setSecurityType(getSecurityType());
		if ( hasCFICode())
			out.setCFICode(getCFICode());
		if ( hasSettlCurrency())
			out.setSettlCurrency(getSettlCurrency());
		if ( hasEffectiveTime())
			out.setEffectiveTime(getEffectiveTime());
		if ( hasExpireTime())
			out.setExpireTime(getExpireTime());
		if ( hasLastUpdateTime())
			out.setLastUpdateTime(getLastUpdateTime());
		if ( hasPaymentMethod())
			out.setPaymentMethod(getPaymentMethod());
		if ( hasPaymentRef())
			out.setPaymentRef(getPaymentRef());
		if ( hasCardHolderName())
			out.setCardHolderName(getCardHolderName());
		if ( hasCardNumber())
			out.setCardNumber(getCardNumber());
		if ( hasCardStartDate())
			out.setCardStartDate(getCardStartDate());
		if ( hasCardExpDate())
			out.setCardExpDate(getCardExpDate());
		if ( hasCardIssNum())
			out.setCardIssNum(getCardIssNum());
		if ( hasPaymentDate())
			out.setPaymentDate(getPaymentDate());
		if ( hasPaymentRemitterID())
			out.setPaymentRemitterID(getPaymentRemitterID());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		if (settlInstructionsData.hasGroup())
			out.settlInstructionsData = settlInstructionsData.clone( out.settlInstructionsData);
		return out;
	}

}
