package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSettlObligationInstructions extends FixGroup {
	private short hasNetGrossInd;
	long netGrossInd = 0;		
	private short hasSettlObligID;
	byte[] settlObligID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlObligTransType;
	byte settlObligTransType = (byte)' ';		
	private short hasSettlObligRefID;
	byte[] settlObligRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCcyAmt;
	long ccyAmt = 0;		
	private short hasSettlCurrAmt;
	long settlCurrAmt = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasSettlCurrency;
	byte[] settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasSettlCurrFxRate;
	long settlCurrFxRate = 0;		
	private short hasSettlDate;
	byte[] settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEffectiveTime;
	byte[] effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasExpireTime;
	byte[] expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasLastUpdateTime;
	byte[] lastUpdateTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		public FixInstrument instrument;
		public FixParties[] parties;
		public FixSettlDetails[] settlDetails;
	
	public FixSettlObligationInstructions() {
		this(false);
	}

	public FixSettlObligationInstructions(boolean isRequired) {
		super(FixTags.NETGROSSIND_INT);

		this.isRequired = isRequired;
		
		hasNetGrossInd = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlObligID = FixUtils.TAG_HAS_NO_VALUE;		
		settlObligID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlObligTransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlObligRefID = FixUtils.TAG_HAS_NO_VALUE;		
		settlObligRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCcyAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasSettlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEffectiveTime = FixUtils.TAG_HAS_NO_VALUE;		
		effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;		
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasLastUpdateTime = FixUtils.TAG_HAS_NO_VALUE;		
		lastUpdateTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		instrument = new FixInstrument();
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		settlDetails = new FixSettlDetails[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) settlDetails[i] = new FixSettlDetails();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNetGrossInd()) return true;
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
            	case FixTags.NETGROSSIND_INT:		
            		hasNetGrossInd = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLOBLIGID_INT:		
            		hasSettlObligID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLOBLIGTRANSTYPE_INT:		
            		hasSettlObligTransType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLOBLIGREFID_INT:		
            		hasSettlObligRefID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CCYAMT_INT:		
            		hasCcyAmt = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLCURRAMT_INT:		
            		hasSettlCurrAmt = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLCURRENCY_INT:		
            		hasSettlCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLCURRFXRATE_INT:		
            		hasSettlCurrFxRate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLDATE_INT:		
            		hasSettlDate = (short) buf.position();		
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
            	default:
        			if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOPARTYIDS_INT ) {
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
        			} else if ( tag == FixTags.NOSETTLDETAILS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !settlDetails[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = settlDetails[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
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
		hasNetGrossInd = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlObligID = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlObligTransType = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlObligRefID = FixUtils.TAG_HAS_NO_VALUE;
		hasCcyAmt = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;
		hasEffectiveTime = FixUtils.TAG_HAS_NO_VALUE;
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;
		hasLastUpdateTime = FixUtils.TAG_HAS_NO_VALUE;
		instrument.clear();
		for (FixParties fixParties : parties) fixParties.clear();
		for (FixSettlDetails fixSettlDetails : settlDetails) fixSettlDetails.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNetGrossInd()) {		
			out.put(FixTags.NETGROSSIND);

			out.put((byte) '=');

			FixUtils.put(out, (long)netGrossInd);
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlObligID()) {		
			out.put(FixTags.SETTLOBLIGID);

			out.put((byte) '=');

			FixUtils.put(out,settlObligID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlObligTransType()) {		
			out.put(FixTags.SETTLOBLIGTRANSTYPE);

			out.put((byte) '=');

			FixUtils.put(out,settlObligTransType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlObligRefID()) {		
			out.put(FixTags.SETTLOBLIGREFID);

			out.put((byte) '=');

			FixUtils.put(out,settlObligRefID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCcyAmt()) {		
			out.put(FixTags.CCYAMT);

			out.put((byte) '=');

			FixUtils.put(out, (long)ccyAmt);
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlCurrAmt()) {		
			out.put(FixTags.SETTLCURRAMT);

			out.put((byte) '=');

			FixUtils.put(out, (long)settlCurrAmt);
		
			out.put(FixUtils.SOH);

            }

		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlCurrency()) {		
			out.put(FixTags.SETTLCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,settlCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlCurrFxRate()) {		
			out.put(FixTags.SETTLCURRFXRATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)settlCurrFxRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlDate()) {		
			out.put(FixTags.SETTLDATE);

			out.put((byte) '=');

			FixUtils.put(out,settlDate); 		
		
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

		instrument.encode(out);
		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		if (FixUtils.getNoInGroup(settlDetails)>0) {
			out.put(FixTags.NOSETTLDETAILS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(settlDetails));

			out.put(FixUtils.SOH);

		}
		for (FixSettlDetails fixSettlDetails : settlDetails) if (fixSettlDetails.hasGroup()) fixSettlDetails.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNetGrossInd()) {		
			FixUtils.put(out, (long)netGrossInd);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlObligID()) {		
			FixUtils.put(out,settlObligID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlObligTransType()) {		
			FixUtils.put(out,settlObligTransType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlObligRefID()) {		
			FixUtils.put(out,settlObligRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCcyAmt()) {		
			FixUtils.put(out, (long)ccyAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrAmt()) {		
			FixUtils.put(out, (long)settlCurrAmt);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrency()) {		
			FixUtils.put(out,settlCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlCurrFxRate()) {		
			FixUtils.put(out, (long)settlCurrFxRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlDate()) {		
			FixUtils.put(out,settlDate); 		
		
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
		
		instrument.printBuffer(out);
		for (FixParties fixParties : parties) fixParties.printBuffer(out);
		for (FixSettlDetails fixSettlDetails : settlDetails) fixSettlDetails.printBuffer(out);
	}

	public long getNetGrossInd() { 		
		if ( hasNetGrossInd()) {		
			if (hasNetGrossInd == FixUtils.TAG_HAS_VALUE) {		
				return netGrossInd; 		
			} else {		
		
				buf.position(hasNetGrossInd);		
		
			netGrossInd = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNetGrossInd);		
					return 0;		
				}		
			}		
			hasNetGrossInd = FixUtils.TAG_HAS_VALUE;		
			return netGrossInd;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNetGrossInd() { return hasNetGrossInd != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNetGrossInd(long src) {		
		netGrossInd = src;
		hasNetGrossInd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNetGrossInd(byte[] src) {		
		if (src == null ) return;
		if (hasNetGrossInd()) netGrossInd = FixUtils.TAG_HAS_NO_VALUE;		
		netGrossInd = FixUtils.longValueOf(src, 0, src.length);
		hasNetGrossInd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNetGrossInd(String str) {		
		if (str == null ) return;
		if (hasNetGrossInd()) netGrossInd = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		netGrossInd = FixUtils.longValueOf(src, 0, src.length);
		hasNetGrossInd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSettlObligID() { 		
		if ( hasSettlObligID()) {		
			if (hasSettlObligID == FixUtils.TAG_HAS_VALUE) {		
				return settlObligID; 		
			} else {		
		
				buf.position(hasSettlObligID);		
		
			FixUtils.getTagStringValue(buf, settlObligID, 0, settlObligID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlObligID);		
					return null;		
				}		
			}		
			hasSettlObligID = FixUtils.TAG_HAS_VALUE;		
			return settlObligID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlObligID() { return hasSettlObligID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlObligID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlObligID()) FixUtils.fillNul(settlObligID);		
		FixUtils.copy(settlObligID, src); 		
		hasSettlObligID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlObligID(String str) {		
		if (str == null ) return;
		if (hasSettlObligID()) FixUtils.fillNul(settlObligID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlObligID, src); 		
		hasSettlObligID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getSettlObligTransType() { 		
		if ( hasSettlObligTransType()) {		
			if (hasSettlObligTransType == FixUtils.TAG_HAS_VALUE) {		
				return settlObligTransType; 		
			} else {		
		
				buf.position(hasSettlObligTransType);		
		
			settlObligTransType = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (settlObligTransType != (byte)'T') && (settlObligTransType != (byte)'R') && (settlObligTransType != (byte)'C') && (settlObligTransType != (byte)'N') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1162);		
				if (err.hasError()) {		
					buf.position(hasSettlObligTransType);		
					return (byte)'0';		
				}		
			}		
			hasSettlObligTransType = FixUtils.TAG_HAS_VALUE;		
			return settlObligTransType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSettlObligTransType() { return hasSettlObligTransType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlObligTransType(byte src) {		
		settlObligTransType = src;
		hasSettlObligTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlObligTransType(byte[] src) {		
		if (src == null ) return;
		if (hasSettlObligTransType()) settlObligTransType = (byte)' ';		
		settlObligTransType = src[0];		
		hasSettlObligTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlObligTransType(String str) {		
		if (str == null ) return;
		if (hasSettlObligTransType()) settlObligTransType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		settlObligTransType = src[0];		
		hasSettlObligTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSettlObligRefID() { 		
		if ( hasSettlObligRefID()) {		
			if (hasSettlObligRefID == FixUtils.TAG_HAS_VALUE) {		
				return settlObligRefID; 		
			} else {		
		
				buf.position(hasSettlObligRefID);		
		
			FixUtils.getTagStringValue(buf, settlObligRefID, 0, settlObligRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlObligRefID);		
					return null;		
				}		
			}		
			hasSettlObligRefID = FixUtils.TAG_HAS_VALUE;		
			return settlObligRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlObligRefID() { return hasSettlObligRefID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlObligRefID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlObligRefID()) FixUtils.fillNul(settlObligRefID);		
		FixUtils.copy(settlObligRefID, src); 		
		hasSettlObligRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlObligRefID(String str) {		
		if (str == null ) return;
		if (hasSettlObligRefID()) FixUtils.fillNul(settlObligRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlObligRefID, src); 		
		hasSettlObligRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getCcyAmt() { 		
		if ( hasCcyAmt()) {		
			if (hasCcyAmt == FixUtils.TAG_HAS_VALUE) {		
				return ccyAmt; 		
			} else {		
		
				buf.position(hasCcyAmt);		
		
			ccyAmt = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasCcyAmt);		
					return 0;		
				}		
			}		
			hasCcyAmt = FixUtils.TAG_HAS_VALUE;		
			return ccyAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCcyAmt() { return hasCcyAmt != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCcyAmt(long src) {		
		ccyAmt = src;
		hasCcyAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCcyAmt(byte[] src) {		
		if (src == null ) return;
		if (hasCcyAmt()) ccyAmt = FixUtils.TAG_HAS_NO_VALUE;		
		ccyAmt = FixUtils.longValueOf(src, 0, src.length);
		hasCcyAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCcyAmt(String str) {		
		if (str == null ) return;
		if (hasCcyAmt()) ccyAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		ccyAmt = FixUtils.longValueOf(src, 0, src.length);
		hasCcyAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSettlCurrAmt() { 		
		if ( hasSettlCurrAmt()) {		
			if (hasSettlCurrAmt == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrAmt; 		
			} else {		
		
				buf.position(hasSettlCurrAmt);		
		
			settlCurrAmt = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlCurrAmt);		
					return 0;		
				}		
			}		
			hasSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
			return settlCurrAmt;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlCurrAmt() { return hasSettlCurrAmt != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlCurrAmt(long src) {		
		settlCurrAmt = src;
		hasSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrAmt(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrAmt()) settlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrAmt = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlCurrAmt(String str) {		
		if (str == null ) return;
		if (hasSettlCurrAmt()) settlCurrAmt = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlCurrAmt = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrAmt = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCurrency() { 		
		if ( hasCurrency()) {		
			if (hasCurrency == FixUtils.TAG_HAS_VALUE) {		
				return currency; 		
			} else {		
		
				buf.position(hasCurrency);		
		
			FixUtils.getTagStringValue(buf, currency, 0, currency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCurrency);		
					return null;		
				}		
			}		
			hasCurrency = FixUtils.TAG_HAS_VALUE;		
			return currency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCurrency() { return hasCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasCurrency()) FixUtils.fillNul(currency);		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCurrency(String str) {		
		if (str == null ) return;
		if (hasCurrency()) FixUtils.fillNul(currency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
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
			
	public long getSettlCurrFxRate() { 		
		if ( hasSettlCurrFxRate()) {		
			if (hasSettlCurrFxRate == FixUtils.TAG_HAS_VALUE) {		
				return settlCurrFxRate; 		
			} else {		
		
				buf.position(hasSettlCurrFxRate);		
		
			settlCurrFxRate = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlCurrFxRate);		
					return 0;		
				}		
			}		
			hasSettlCurrFxRate = FixUtils.TAG_HAS_VALUE;		
			return settlCurrFxRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlCurrFxRate() { return hasSettlCurrFxRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlCurrFxRate(long src) {		
		settlCurrFxRate = src;
		hasSettlCurrFxRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlCurrFxRate(byte[] src) {		
		if (src == null ) return;
		if (hasSettlCurrFxRate()) settlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		settlCurrFxRate = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrFxRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlCurrFxRate(String str) {		
		if (str == null ) return;
		if (hasSettlCurrFxRate()) settlCurrFxRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlCurrFxRate = FixUtils.longValueOf(src, 0, src.length);
		hasSettlCurrFxRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSettlDate() { 		
		if ( hasSettlDate()) {		
			if (hasSettlDate == FixUtils.TAG_HAS_VALUE) {		
				return settlDate; 		
			} else {		
		
				buf.position(hasSettlDate);		
		
			FixUtils.getTagStringValue(buf, settlDate, 0, settlDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlDate);		
					return null;		
				}		
			}		
			hasSettlDate = FixUtils.TAG_HAS_VALUE;		
			return settlDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlDate() { return hasSettlDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlDate(byte[] src) {		
		if (src == null ) return;
		if (hasSettlDate()) FixUtils.fillNul(settlDate);		
		FixUtils.copy(settlDate, src); 		
		hasSettlDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlDate(String str) {		
		if (str == null ) return;
		if (hasSettlDate()) FixUtils.fillNul(settlDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlDate, src); 		
		hasSettlDate = FixUtils.TAG_HAS_VALUE;		
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
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNetGrossInd()) s += "NetGrossInd(430)= " + getNetGrossInd() + "\n" ; 
		if (hasSettlObligID()) s += "SettlObligID(1161)= " + new String( FixUtils.trim(getSettlObligID()) ) + "\n" ; 
		if (hasSettlObligTransType()) s += "SettlObligTransType(1162)= " + getSettlObligTransType() + "\n" ; 
		if (hasSettlObligRefID()) s += "SettlObligRefID(1163)= " + new String( FixUtils.trim(getSettlObligRefID()) ) + "\n" ; 
		if (hasCcyAmt()) s += "CcyAmt(1157)= " + getCcyAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlCurrAmt()) s += "SettlCurrAmt(119)= " + getSettlCurrAmt() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasSettlCurrency()) s += "SettlCurrency(120)= " + new String( FixUtils.trim(getSettlCurrency()) ) + "\n" ; 
		if (hasSettlCurrFxRate()) s += "SettlCurrFxRate(155)= " + getSettlCurrFxRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasEffectiveTime()) s += "EffectiveTime(168)= " + new String( FixUtils.trim(getEffectiveTime()) ) + "\n" ; 
		if (hasExpireTime()) s += "ExpireTime(126)= " + new String( FixUtils.trim(getExpireTime()) ) + "\n" ; 
		if (hasLastUpdateTime()) s += "LastUpdateTime(779)= " + new String( FixUtils.trim(getLastUpdateTime()) ) + "\n" ; 

		s += instrument.toString();
		for (FixParties fixParties : parties) fixParties.toString();
		for (FixSettlDetails fixSettlDetails : settlDetails) fixSettlDetails.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSettlObligationInstructions)) return false;

		FixSettlObligationInstructions msg = (FixSettlObligationInstructions) o;

		if (!instrument.equals(msg.instrument)) return false;
		for (int i = 0; i < parties.length; i++)
			if (!parties[i].equals(msg.parties[i])) return false;
		for (int i = 0; i < settlDetails.length; i++)
			if (!settlDetails[i].equals(msg.settlDetails[i])) return false;
		if ((hasNetGrossInd() && !msg.hasNetGrossInd()) || (!hasNetGrossInd() && msg.hasNetGrossInd())) return false;
		if (!(!hasNetGrossInd() && !msg.hasNetGrossInd()) && !(getNetGrossInd()==msg.getNetGrossInd())) return false;
		if ((hasSettlObligID() && !msg.hasSettlObligID()) || (!hasSettlObligID() && msg.hasSettlObligID())) return false;
		if (!(!hasSettlObligID() && !msg.hasSettlObligID()) && !FixUtils.equals(getSettlObligID(), msg.getSettlObligID())) return false;
		if ((hasSettlObligTransType() && !msg.hasSettlObligTransType()) || (!hasSettlObligTransType() && msg.hasSettlObligTransType())) return false;
		if (!(!hasSettlObligTransType() && !msg.hasSettlObligTransType()) && !(getSettlObligTransType()==msg.getSettlObligTransType())) return false;
		if ((hasSettlObligRefID() && !msg.hasSettlObligRefID()) || (!hasSettlObligRefID() && msg.hasSettlObligRefID())) return false;
		if (!(!hasSettlObligRefID() && !msg.hasSettlObligRefID()) && !FixUtils.equals(getSettlObligRefID(), msg.getSettlObligRefID())) return false;
		if ((hasCcyAmt() && !msg.hasCcyAmt()) || (!hasCcyAmt() && msg.hasCcyAmt())) return false;
		if (!(!hasCcyAmt() && !msg.hasCcyAmt()) && !(getCcyAmt()==msg.getCcyAmt())) return false;
		if ((hasSettlCurrAmt() && !msg.hasSettlCurrAmt()) || (!hasSettlCurrAmt() && msg.hasSettlCurrAmt())) return false;
		if (!(!hasSettlCurrAmt() && !msg.hasSettlCurrAmt()) && !(getSettlCurrAmt()==msg.getSettlCurrAmt())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasSettlCurrency() && !msg.hasSettlCurrency()) || (!hasSettlCurrency() && msg.hasSettlCurrency())) return false;
		if (!(!hasSettlCurrency() && !msg.hasSettlCurrency()) && !FixUtils.equals(getSettlCurrency(), msg.getSettlCurrency())) return false;
		if ((hasSettlCurrFxRate() && !msg.hasSettlCurrFxRate()) || (!hasSettlCurrFxRate() && msg.hasSettlCurrFxRate())) return false;
		if (!(!hasSettlCurrFxRate() && !msg.hasSettlCurrFxRate()) && !(getSettlCurrFxRate()==msg.getSettlCurrFxRate())) return false;
		if ((hasSettlDate() && !msg.hasSettlDate()) || (!hasSettlDate() && msg.hasSettlDate())) return false;
		if ((hasEffectiveTime() && !msg.hasEffectiveTime()) || (!hasEffectiveTime() && msg.hasEffectiveTime())) return false;
		if ((hasExpireTime() && !msg.hasExpireTime()) || (!hasExpireTime() && msg.hasExpireTime())) return false;
		if ((hasLastUpdateTime() && !msg.hasLastUpdateTime()) || (!hasLastUpdateTime() && msg.hasLastUpdateTime())) return false;
		return true;
	}
	public FixSettlObligationInstructions clone ( FixSettlObligationInstructions out ) {
		if ( hasNetGrossInd())
			out.setNetGrossInd(getNetGrossInd());
		if ( hasSettlObligID())
			out.setSettlObligID(getSettlObligID());
		if ( hasSettlObligTransType())
			out.setSettlObligTransType(getSettlObligTransType());
		if ( hasSettlObligRefID())
			out.setSettlObligRefID(getSettlObligRefID());
		if ( hasCcyAmt())
			out.setCcyAmt(getCcyAmt());
		if ( hasSettlCurrAmt())
			out.setSettlCurrAmt(getSettlCurrAmt());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasSettlCurrency())
			out.setSettlCurrency(getSettlCurrency());
		if ( hasSettlCurrFxRate())
			out.setSettlCurrFxRate(getSettlCurrFxRate());
		if ( hasSettlDate())
			out.setSettlDate(getSettlDate());
		if ( hasEffectiveTime())
			out.setEffectiveTime(getEffectiveTime());
		if ( hasExpireTime())
			out.setExpireTime(getExpireTime());
		if ( hasLastUpdateTime())
			out.setLastUpdateTime(getLastUpdateTime());
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		count = 0;
		for (FixSettlDetails fixSettlDetails : settlDetails) {
			if (!fixSettlDetails.hasGroup()) continue;
			out.settlDetails[count] = fixSettlDetails.clone( out.settlDetails[count] );
			count++;
		}
		return out;
	}

}
