package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixQuotEntryGrp extends FixGroup {
	private short hasQuoteEntryID;
	byte[] quoteEntryID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasBidPx;
	long bidPx = 0;		
	private short hasOfferPx;
	long offerPx = 0;		
	private short hasBidSize;
	long bidSize = 0;		
	private short hasOfferSize;
	long offerSize = 0;		
	private short hasValidUntilTime;
	byte[] validUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasBidSpotRate;
	long bidSpotRate = 0;		
	private short hasOfferSpotRate;
	long offerSpotRate = 0;		
	private short hasBidForwardPoints;
	long bidForwardPoints = 0;		
	private short hasOfferForwardPoints;
	long offerForwardPoints = 0;		
	private short hasMidPx;
	long midPx = 0;		
	private short hasBidYield;
	long bidYield = 0;		
	private short hasMidYield;
	long midYield = 0;		
	private short hasOfferYield;
	long offerYield = 0;		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlDate;
	byte[] settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrdType;
	byte ordType = (byte)' ';		
	private short hasSettlDate2;
	byte[] settlDate2 = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderQty2;
	long orderQty2 = 0;		
	private short hasBidForwardPoints2;
	long bidForwardPoints2 = 0;		
	private short hasOfferForwardPoints2;
	long offerForwardPoints2 = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasBookingType;
	long bookingType = 0;		
	private short hasOrderCapacity;
	byte orderCapacity = (byte)' ';		
	private short hasOrderRestrictions;
	byte[] orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixInstrument instrument;
		public FixInstrmtLegGrp[] instrmtLegGrp;
	
	public FixQuotEntryGrp() {
		this(false);
	}

	public FixQuotEntryGrp(boolean isRequired) {
		super(FixTags.QUOTEENTRYID_INT);

		this.isRequired = isRequired;
		
		hasQuoteEntryID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteEntryID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasBidPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasOfferPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasBidSize = FixUtils.TAG_HAS_NO_VALUE;		
		hasOfferSize = FixUtils.TAG_HAS_NO_VALUE;		
		hasValidUntilTime = FixUtils.TAG_HAS_NO_VALUE;		
		validUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasBidSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasOfferSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasBidForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		hasOfferForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		hasMidPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasBidYield = FixUtils.TAG_HAS_NO_VALUE;		
		hasMidYield = FixUtils.TAG_HAS_NO_VALUE;		
		hasOfferYield = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlDate2 = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate2 = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderQty2 = FixUtils.TAG_HAS_NO_VALUE;		
		hasBidForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		hasOfferForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasBookingType = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderRestrictions = FixUtils.TAG_HAS_NO_VALUE;		
		orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		instrument = new FixInstrument();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasQuoteEntryID()) return true;
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
            	case FixTags.QUOTEENTRYID_INT:		
            		hasQuoteEntryID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.BIDPX_INT:		
            		hasBidPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.OFFERPX_INT:		
            		hasOfferPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.BIDSIZE_INT:		
            		hasBidSize = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.OFFERSIZE_INT:		
            		hasOfferSize = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.VALIDUNTILTIME_INT:		
            		hasValidUntilTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.BIDSPOTRATE_INT:		
            		hasBidSpotRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.OFFERSPOTRATE_INT:		
            		hasOfferSpotRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.BIDFORWARDPOINTS_INT:		
            		hasBidForwardPoints = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.OFFERFORWARDPOINTS_INT:		
            		hasOfferForwardPoints = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MIDPX_INT:		
            		hasMidPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.BIDYIELD_INT:		
            		hasBidYield = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MIDYIELD_INT:		
            		hasMidYield = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.OFFERYIELD_INT:		
            		hasOfferYield = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADINGSESSIONID_INT:		
            		hasTradingSessionID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADINGSESSIONSUBID_INT:		
            		hasTradingSessionSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLDATE_INT:		
            		hasSettlDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDTYPE_INT:		
            		hasOrdType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLDATE2_INT:		
            		hasSettlDate2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERQTY2_INT:		
            		hasOrderQty2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.BIDFORWARDPOINTS2_INT:		
            		hasBidForwardPoints2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.OFFERFORWARDPOINTS2_INT:		
            		hasOfferForwardPoints2 = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.BOOKINGTYPE_INT:		
            		hasBookingType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERCAPACITY_INT:		
            		hasOrderCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ORDERRESTRICTIONS_INT:		
            		hasOrderRestrictions = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOLEGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		if (!hasQuoteEntryID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag QuoteEntryID missing", FixTags.QUOTEENTRYID_INT);
			return false;
		}
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasQuoteEntryID = FixUtils.TAG_HAS_NO_VALUE;
		hasBidPx = FixUtils.TAG_HAS_NO_VALUE;
		hasOfferPx = FixUtils.TAG_HAS_NO_VALUE;
		hasBidSize = FixUtils.TAG_HAS_NO_VALUE;
		hasOfferSize = FixUtils.TAG_HAS_NO_VALUE;
		hasValidUntilTime = FixUtils.TAG_HAS_NO_VALUE;
		hasBidSpotRate = FixUtils.TAG_HAS_NO_VALUE;
		hasOfferSpotRate = FixUtils.TAG_HAS_NO_VALUE;
		hasBidForwardPoints = FixUtils.TAG_HAS_NO_VALUE;
		hasOfferForwardPoints = FixUtils.TAG_HAS_NO_VALUE;
		hasMidPx = FixUtils.TAG_HAS_NO_VALUE;
		hasBidYield = FixUtils.TAG_HAS_NO_VALUE;
		hasMidYield = FixUtils.TAG_HAS_NO_VALUE;
		hasOfferYield = FixUtils.TAG_HAS_NO_VALUE;
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlDate2 = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderQty2 = FixUtils.TAG_HAS_NO_VALUE;
		hasBidForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;
		hasOfferForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasBookingType = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;
		hasOrderRestrictions = FixUtils.TAG_HAS_NO_VALUE;
		instrument.clear();
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasQuoteEntryID()) {		
			out.put(FixTags.QUOTEENTRYID);

			out.put((byte) '=');

			FixUtils.put(out,quoteEntryID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasBidPx()) {		
			out.put(FixTags.BIDPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)bidPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasOfferPx()) {		
			out.put(FixTags.OFFERPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)offerPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasBidSize()) {		
			out.put(FixTags.BIDSIZE);

			out.put((byte) '=');

			FixUtils.put(out, (long)bidSize);
		
			out.put(FixUtils.SOH);

            }

		if (hasOfferSize()) {		
			out.put(FixTags.OFFERSIZE);

			out.put((byte) '=');

			FixUtils.put(out, (long)offerSize);
		
			out.put(FixUtils.SOH);

            }

		if (hasValidUntilTime()) {		
			out.put(FixTags.VALIDUNTILTIME);

			out.put((byte) '=');

			FixUtils.put(out,validUntilTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasBidSpotRate()) {		
			out.put(FixTags.BIDSPOTRATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)bidSpotRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasOfferSpotRate()) {		
			out.put(FixTags.OFFERSPOTRATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)offerSpotRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasBidForwardPoints()) {		
			out.put(FixTags.BIDFORWARDPOINTS);

			out.put((byte) '=');

			FixUtils.put(out, (long)bidForwardPoints);
		
			out.put(FixUtils.SOH);

            }

		if (hasOfferForwardPoints()) {		
			out.put(FixTags.OFFERFORWARDPOINTS);

			out.put((byte) '=');

			FixUtils.put(out, (long)offerForwardPoints);
		
			out.put(FixUtils.SOH);

            }

		if (hasMidPx()) {		
			out.put(FixTags.MIDPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)midPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasBidYield()) {		
			out.put(FixTags.BIDYIELD);

			out.put((byte) '=');

			FixUtils.put(out, (long)bidYield);
		
			out.put(FixUtils.SOH);

            }

		if (hasMidYield()) {		
			out.put(FixTags.MIDYIELD);

			out.put((byte) '=');

			FixUtils.put(out, (long)midYield);
		
			out.put(FixUtils.SOH);

            }

		if (hasOfferYield()) {		
			out.put(FixTags.OFFERYIELD);

			out.put((byte) '=');

			FixUtils.put(out, (long)offerYield);
		
			out.put(FixUtils.SOH);

            }

		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);

			out.put((byte) '=');

			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradingSessionID()) {		
			out.put(FixTags.TRADINGSESSIONID);

			out.put((byte) '=');

			FixUtils.put(out,tradingSessionID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradingSessionSubID()) {		
			out.put(FixTags.TRADINGSESSIONSUBID);

			out.put((byte) '=');

			FixUtils.put(out,tradingSessionSubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlDate()) {		
			out.put(FixTags.SETTLDATE);

			out.put((byte) '=');

			FixUtils.put(out,settlDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrdType()) {		
			out.put(FixTags.ORDTYPE);

			out.put((byte) '=');

			FixUtils.put(out,ordType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlDate2()) {		
			out.put(FixTags.SETTLDATE2);

			out.put((byte) '=');

			FixUtils.put(out,settlDate2); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderQty2()) {		
			out.put(FixTags.ORDERQTY2);

			out.put((byte) '=');

			FixUtils.put(out, (long)orderQty2);
		
			out.put(FixUtils.SOH);

            }

		if (hasBidForwardPoints2()) {		
			out.put(FixTags.BIDFORWARDPOINTS2);

			out.put((byte) '=');

			FixUtils.put(out, (long)bidForwardPoints2);
		
			out.put(FixUtils.SOH);

            }

		if (hasOfferForwardPoints2()) {		
			out.put(FixTags.OFFERFORWARDPOINTS2);

			out.put((byte) '=');

			FixUtils.put(out, (long)offerForwardPoints2);
		
			out.put(FixUtils.SOH);

            }

		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasBookingType()) {		
			out.put(FixTags.BOOKINGTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)bookingType);
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderCapacity()) {		
			out.put(FixTags.ORDERCAPACITY);

			out.put((byte) '=');

			FixUtils.put(out,orderCapacity); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrderRestrictions()) {		
			out.put(FixTags.ORDERRESTRICTIONS);

			out.put((byte) '=');

			FixUtils.put(out,orderRestrictions); 		
		
			out.put(FixUtils.SOH);

            }

		instrument.encode(out);
		if (FixUtils.getNoInGroup(instrmtLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) if (fixInstrmtLegGrp.hasGroup()) fixInstrmtLegGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasQuoteEntryID()) {		
			FixUtils.put(out,quoteEntryID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidPx()) {		
			FixUtils.put(out, (long)bidPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOfferPx()) {		
			FixUtils.put(out, (long)offerPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidSize()) {		
			FixUtils.put(out, (long)bidSize);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOfferSize()) {		
			FixUtils.put(out, (long)offerSize);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasValidUntilTime()) {		
			FixUtils.put(out,validUntilTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidSpotRate()) {		
			FixUtils.put(out, (long)bidSpotRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOfferSpotRate()) {		
			FixUtils.put(out, (long)offerSpotRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidForwardPoints()) {		
			FixUtils.put(out, (long)bidForwardPoints);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOfferForwardPoints()) {		
			FixUtils.put(out, (long)offerForwardPoints);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMidPx()) {		
			FixUtils.put(out, (long)midPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidYield()) {		
			FixUtils.put(out, (long)bidYield);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMidYield()) {		
			FixUtils.put(out, (long)midYield);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOfferYield()) {		
			FixUtils.put(out, (long)offerYield);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionID()) {		
			FixUtils.put(out,tradingSessionID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionSubID()) {		
			FixUtils.put(out,tradingSessionSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlDate()) {		
			FixUtils.put(out,settlDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdType()) {		
			FixUtils.put(out,ordType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlDate2()) {		
			FixUtils.put(out,settlDate2); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderQty2()) {		
			FixUtils.put(out, (long)orderQty2);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidForwardPoints2()) {		
			FixUtils.put(out, (long)bidForwardPoints2);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOfferForwardPoints2()) {		
			FixUtils.put(out, (long)offerForwardPoints2);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBookingType()) {		
			FixUtils.put(out, (long)bookingType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderCapacity()) {		
			FixUtils.put(out,orderCapacity); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderRestrictions()) {		
			FixUtils.put(out,orderRestrictions); 		
		
	        out.put( (byte)' ' );		
		}		
		
		instrument.printBuffer(out);
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.printBuffer(out);
	}

	public byte[] getQuoteEntryID() { 		
		if ( hasQuoteEntryID()) {		
			if (hasQuoteEntryID == FixUtils.TAG_HAS_VALUE) {		
				return quoteEntryID; 		
			} else {		
		
				buf.position(hasQuoteEntryID);		
		
			FixMessage.getTagStringValue(buf, quoteEntryID, 0, quoteEntryID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasQuoteEntryID);		
					return null;		
				}		
			}		
			hasQuoteEntryID = FixUtils.TAG_HAS_VALUE;		
			return quoteEntryID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteEntryID() { return hasQuoteEntryID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setQuoteEntryID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteEntryID()) FixUtils.fillNul(quoteEntryID);		
		FixUtils.copy(quoteEntryID, src); 		
		hasQuoteEntryID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setQuoteEntryID(String str) {		
		if (str == null ) return;
		if (hasQuoteEntryID()) FixUtils.fillNul(quoteEntryID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteEntryID, src); 		
		hasQuoteEntryID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getBidPx() { 		
		if ( hasBidPx()) {		
			if (hasBidPx == FixUtils.TAG_HAS_VALUE) {		
				return bidPx; 		
			} else {		
		
				buf.position(hasBidPx);		
		
			bidPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBidPx);		
					return 0;		
				}		
			}		
			hasBidPx = FixUtils.TAG_HAS_VALUE;		
			return bidPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidPx() { return hasBidPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBidPx(long src) {		
		bidPx = src;
		hasBidPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidPx(byte[] src) {		
		if (src == null ) return;
		if (hasBidPx()) bidPx = FixUtils.TAG_HAS_NO_VALUE;		
		bidPx = FixUtils.longValueOf(src, 0, src.length);
		hasBidPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBidPx(String str) {		
		if (str == null ) return;
		if (hasBidPx()) bidPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidPx = FixUtils.longValueOf(src, 0, src.length);
		hasBidPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOfferPx() { 		
		if ( hasOfferPx()) {		
			if (hasOfferPx == FixUtils.TAG_HAS_VALUE) {		
				return offerPx; 		
			} else {		
		
				buf.position(hasOfferPx);		
		
			offerPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOfferPx);		
					return 0;		
				}		
			}		
			hasOfferPx = FixUtils.TAG_HAS_VALUE;		
			return offerPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOfferPx() { return hasOfferPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOfferPx(long src) {		
		offerPx = src;
		hasOfferPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferPx(byte[] src) {		
		if (src == null ) return;
		if (hasOfferPx()) offerPx = FixUtils.TAG_HAS_NO_VALUE;		
		offerPx = FixUtils.longValueOf(src, 0, src.length);
		hasOfferPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOfferPx(String str) {		
		if (str == null ) return;
		if (hasOfferPx()) offerPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		offerPx = FixUtils.longValueOf(src, 0, src.length);
		hasOfferPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getBidSize() { 		
		if ( hasBidSize()) {		
			if (hasBidSize == FixUtils.TAG_HAS_VALUE) {		
				return bidSize; 		
			} else {		
		
				buf.position(hasBidSize);		
		
			bidSize = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBidSize);		
					return 0;		
				}		
			}		
			hasBidSize = FixUtils.TAG_HAS_VALUE;		
			return bidSize;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidSize() { return hasBidSize != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBidSize(long src) {		
		bidSize = src;
		hasBidSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidSize(byte[] src) {		
		if (src == null ) return;
		if (hasBidSize()) bidSize = FixUtils.TAG_HAS_NO_VALUE;		
		bidSize = FixUtils.longValueOf(src, 0, src.length);
		hasBidSize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBidSize(String str) {		
		if (str == null ) return;
		if (hasBidSize()) bidSize = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidSize = FixUtils.longValueOf(src, 0, src.length);
		hasBidSize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOfferSize() { 		
		if ( hasOfferSize()) {		
			if (hasOfferSize == FixUtils.TAG_HAS_VALUE) {		
				return offerSize; 		
			} else {		
		
				buf.position(hasOfferSize);		
		
			offerSize = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOfferSize);		
					return 0;		
				}		
			}		
			hasOfferSize = FixUtils.TAG_HAS_VALUE;		
			return offerSize;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOfferSize() { return hasOfferSize != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOfferSize(long src) {		
		offerSize = src;
		hasOfferSize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferSize(byte[] src) {		
		if (src == null ) return;
		if (hasOfferSize()) offerSize = FixUtils.TAG_HAS_NO_VALUE;		
		offerSize = FixUtils.longValueOf(src, 0, src.length);
		hasOfferSize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOfferSize(String str) {		
		if (str == null ) return;
		if (hasOfferSize()) offerSize = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		offerSize = FixUtils.longValueOf(src, 0, src.length);
		hasOfferSize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getValidUntilTime() { 		
		if ( hasValidUntilTime()) {		
			if (hasValidUntilTime == FixUtils.TAG_HAS_VALUE) {		
				return validUntilTime; 		
			} else {		
		
				buf.position(hasValidUntilTime);		
		
			FixMessage.getTagStringValue(buf, validUntilTime, 0, validUntilTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasValidUntilTime);		
					return null;		
				}		
			}		
			hasValidUntilTime = FixUtils.TAG_HAS_VALUE;		
			return validUntilTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasValidUntilTime() { return hasValidUntilTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setValidUntilTime(byte[] src) {		
		if (src == null ) return;
		if (hasValidUntilTime()) FixUtils.fillNul(validUntilTime);		
		FixUtils.copy(validUntilTime, src); 		
		hasValidUntilTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setValidUntilTime(String str) {		
		if (str == null ) return;
		if (hasValidUntilTime()) FixUtils.fillNul(validUntilTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(validUntilTime, src); 		
		hasValidUntilTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getBidSpotRate() { 		
		if ( hasBidSpotRate()) {		
			if (hasBidSpotRate == FixUtils.TAG_HAS_VALUE) {		
				return bidSpotRate; 		
			} else {		
		
				buf.position(hasBidSpotRate);		
		
			bidSpotRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBidSpotRate);		
					return 0;		
				}		
			}		
			hasBidSpotRate = FixUtils.TAG_HAS_VALUE;		
			return bidSpotRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidSpotRate() { return hasBidSpotRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBidSpotRate(long src) {		
		bidSpotRate = src;
		hasBidSpotRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidSpotRate(byte[] src) {		
		if (src == null ) return;
		if (hasBidSpotRate()) bidSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		bidSpotRate = FixUtils.longValueOf(src, 0, src.length);
		hasBidSpotRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBidSpotRate(String str) {		
		if (str == null ) return;
		if (hasBidSpotRate()) bidSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidSpotRate = FixUtils.longValueOf(src, 0, src.length);
		hasBidSpotRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOfferSpotRate() { 		
		if ( hasOfferSpotRate()) {		
			if (hasOfferSpotRate == FixUtils.TAG_HAS_VALUE) {		
				return offerSpotRate; 		
			} else {		
		
				buf.position(hasOfferSpotRate);		
		
			offerSpotRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOfferSpotRate);		
					return 0;		
				}		
			}		
			hasOfferSpotRate = FixUtils.TAG_HAS_VALUE;		
			return offerSpotRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOfferSpotRate() { return hasOfferSpotRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOfferSpotRate(long src) {		
		offerSpotRate = src;
		hasOfferSpotRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferSpotRate(byte[] src) {		
		if (src == null ) return;
		if (hasOfferSpotRate()) offerSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		offerSpotRate = FixUtils.longValueOf(src, 0, src.length);
		hasOfferSpotRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOfferSpotRate(String str) {		
		if (str == null ) return;
		if (hasOfferSpotRate()) offerSpotRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		offerSpotRate = FixUtils.longValueOf(src, 0, src.length);
		hasOfferSpotRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getBidForwardPoints() { 		
		if ( hasBidForwardPoints()) {		
			if (hasBidForwardPoints == FixUtils.TAG_HAS_VALUE) {		
				return bidForwardPoints; 		
			} else {		
		
				buf.position(hasBidForwardPoints);		
		
			bidForwardPoints = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBidForwardPoints);		
					return 0;		
				}		
			}		
			hasBidForwardPoints = FixUtils.TAG_HAS_VALUE;		
			return bidForwardPoints;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidForwardPoints() { return hasBidForwardPoints != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBidForwardPoints(long src) {		
		bidForwardPoints = src;
		hasBidForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidForwardPoints(byte[] src) {		
		if (src == null ) return;
		if (hasBidForwardPoints()) bidForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		bidForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasBidForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBidForwardPoints(String str) {		
		if (str == null ) return;
		if (hasBidForwardPoints()) bidForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasBidForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOfferForwardPoints() { 		
		if ( hasOfferForwardPoints()) {		
			if (hasOfferForwardPoints == FixUtils.TAG_HAS_VALUE) {		
				return offerForwardPoints; 		
			} else {		
		
				buf.position(hasOfferForwardPoints);		
		
			offerForwardPoints = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOfferForwardPoints);		
					return 0;		
				}		
			}		
			hasOfferForwardPoints = FixUtils.TAG_HAS_VALUE;		
			return offerForwardPoints;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOfferForwardPoints() { return hasOfferForwardPoints != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOfferForwardPoints(long src) {		
		offerForwardPoints = src;
		hasOfferForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferForwardPoints(byte[] src) {		
		if (src == null ) return;
		if (hasOfferForwardPoints()) offerForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		offerForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasOfferForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOfferForwardPoints(String str) {		
		if (str == null ) return;
		if (hasOfferForwardPoints()) offerForwardPoints = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		offerForwardPoints = FixUtils.longValueOf(src, 0, src.length);
		hasOfferForwardPoints = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMidPx() { 		
		if ( hasMidPx()) {		
			if (hasMidPx == FixUtils.TAG_HAS_VALUE) {		
				return midPx; 		
			} else {		
		
				buf.position(hasMidPx);		
		
			midPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMidPx);		
					return 0;		
				}		
			}		
			hasMidPx = FixUtils.TAG_HAS_VALUE;		
			return midPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMidPx() { return hasMidPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMidPx(long src) {		
		midPx = src;
		hasMidPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMidPx(byte[] src) {		
		if (src == null ) return;
		if (hasMidPx()) midPx = FixUtils.TAG_HAS_NO_VALUE;		
		midPx = FixUtils.longValueOf(src, 0, src.length);
		hasMidPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMidPx(String str) {		
		if (str == null ) return;
		if (hasMidPx()) midPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		midPx = FixUtils.longValueOf(src, 0, src.length);
		hasMidPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getBidYield() { 		
		if ( hasBidYield()) {		
			if (hasBidYield == FixUtils.TAG_HAS_VALUE) {		
				return bidYield; 		
			} else {		
		
				buf.position(hasBidYield);		
		
			bidYield = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBidYield);		
					return 0;		
				}		
			}		
			hasBidYield = FixUtils.TAG_HAS_VALUE;		
			return bidYield;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidYield() { return hasBidYield != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBidYield(long src) {		
		bidYield = src;
		hasBidYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidYield(byte[] src) {		
		if (src == null ) return;
		if (hasBidYield()) bidYield = FixUtils.TAG_HAS_NO_VALUE;		
		bidYield = FixUtils.longValueOf(src, 0, src.length);
		hasBidYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBidYield(String str) {		
		if (str == null ) return;
		if (hasBidYield()) bidYield = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidYield = FixUtils.longValueOf(src, 0, src.length);
		hasBidYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMidYield() { 		
		if ( hasMidYield()) {		
			if (hasMidYield == FixUtils.TAG_HAS_VALUE) {		
				return midYield; 		
			} else {		
		
				buf.position(hasMidYield);		
		
			midYield = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMidYield);		
					return 0;		
				}		
			}		
			hasMidYield = FixUtils.TAG_HAS_VALUE;		
			return midYield;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMidYield() { return hasMidYield != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMidYield(long src) {		
		midYield = src;
		hasMidYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMidYield(byte[] src) {		
		if (src == null ) return;
		if (hasMidYield()) midYield = FixUtils.TAG_HAS_NO_VALUE;		
		midYield = FixUtils.longValueOf(src, 0, src.length);
		hasMidYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMidYield(String str) {		
		if (str == null ) return;
		if (hasMidYield()) midYield = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		midYield = FixUtils.longValueOf(src, 0, src.length);
		hasMidYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOfferYield() { 		
		if ( hasOfferYield()) {		
			if (hasOfferYield == FixUtils.TAG_HAS_VALUE) {		
				return offerYield; 		
			} else {		
		
				buf.position(hasOfferYield);		
		
			offerYield = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOfferYield);		
					return 0;		
				}		
			}		
			hasOfferYield = FixUtils.TAG_HAS_VALUE;		
			return offerYield;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOfferYield() { return hasOfferYield != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOfferYield(long src) {		
		offerYield = src;
		hasOfferYield = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferYield(byte[] src) {		
		if (src == null ) return;
		if (hasOfferYield()) offerYield = FixUtils.TAG_HAS_NO_VALUE;		
		offerYield = FixUtils.longValueOf(src, 0, src.length);
		hasOfferYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOfferYield(String str) {		
		if (str == null ) return;
		if (hasOfferYield()) offerYield = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		offerYield = FixUtils.longValueOf(src, 0, src.length);
		hasOfferYield = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTransactTime() { 		
		if ( hasTransactTime()) {		
			if (hasTransactTime == FixUtils.TAG_HAS_VALUE) {		
				return transactTime; 		
			} else {		
		
				buf.position(hasTransactTime);		
		
			FixMessage.getTagStringValue(buf, transactTime, 0, transactTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTransactTime);		
					return null;		
				}		
			}		
			hasTransactTime = FixUtils.TAG_HAS_VALUE;		
			return transactTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTransactTime() { return hasTransactTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTransactTime(byte[] src) {		
		if (src == null ) return;
		if (hasTransactTime()) FixUtils.fillNul(transactTime);		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTransactTime(String str) {		
		if (str == null ) return;
		if (hasTransactTime()) FixUtils.fillNul(transactTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradingSessionID() { 		
		if ( hasTradingSessionID()) {		
			if (hasTradingSessionID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionID; 		
			} else {		
		
				buf.position(hasTradingSessionID);		
		
			FixMessage.getTagStringValue(buf, tradingSessionID, 0, tradingSessionID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradingSessionID);		
					return null;		
				}		
			}		
			hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
			return tradingSessionID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionID() { return hasTradingSessionID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradingSessionID(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionID()) FixUtils.fillNul(tradingSessionID);		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradingSessionID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionID()) FixUtils.fillNul(tradingSessionID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradingSessionSubID() { 		
		if ( hasTradingSessionSubID()) {		
			if (hasTradingSessionSubID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionSubID; 		
			} else {		
		
				buf.position(hasTradingSessionSubID);		
		
			FixMessage.getTagStringValue(buf, tradingSessionSubID, 0, tradingSessionSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradingSessionSubID);		
					return null;		
				}		
			}		
			hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
			return tradingSessionSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionSubID() { return hasTradingSessionSubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradingSessionSubID(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillNul(tradingSessionSubID);		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradingSessionSubID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillNul(tradingSessionSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSettlDate() { 		
		if ( hasSettlDate()) {		
			if (hasSettlDate == FixUtils.TAG_HAS_VALUE) {		
				return settlDate; 		
			} else {		
		
				buf.position(hasSettlDate);		
		
			FixMessage.getTagStringValue(buf, settlDate, 0, settlDate.length, err);
		
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
			
	public byte getOrdType() { 		
		if ( hasOrdType()) {		
			if (hasOrdType == FixUtils.TAG_HAS_VALUE) {		
				return ordType; 		
			} else {		
		
				buf.position(hasOrdType);		
		
			ordType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (ordType != (byte)'D') && (ordType != (byte)'E') && (ordType != (byte)'F') && (ordType != (byte)'G') && (ordType != (byte)'A') && (ordType != (byte)'B') && (ordType != (byte)'C') && (ordType != (byte)'L') && (ordType != (byte)'M') && (ordType != (byte)'H') && (ordType != (byte)'I') && (ordType != (byte)'J') && (ordType != (byte)'K') && (ordType != (byte)'3') && (ordType != (byte)'2') && (ordType != (byte)'1') && (ordType != (byte)'Q') && (ordType != (byte)'7') && (ordType != (byte)'P') && (ordType != (byte)'6') && (ordType != (byte)'5') && (ordType != (byte)'4') && (ordType != (byte)'9') && (ordType != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 40);		
				if (err.hasError()) {		
					buf.position(hasOrdType);		
					return (byte)'0';		
				}		
			}		
			hasOrdType = FixUtils.TAG_HAS_VALUE;		
			return ordType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrdType() { return hasOrdType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrdType(byte src) {		
		ordType = src;
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdType(byte[] src) {		
		if (src == null ) return;
		if (hasOrdType()) ordType = (byte)' ';		
		ordType = src[0];		
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrdType(String str) {		
		if (str == null ) return;
		if (hasOrdType()) ordType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		ordType = src[0];		
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSettlDate2() { 		
		if ( hasSettlDate2()) {		
			if (hasSettlDate2 == FixUtils.TAG_HAS_VALUE) {		
				return settlDate2; 		
			} else {		
		
				buf.position(hasSettlDate2);		
		
			FixMessage.getTagStringValue(buf, settlDate2, 0, settlDate2.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlDate2);		
					return null;		
				}		
			}		
			hasSettlDate2 = FixUtils.TAG_HAS_VALUE;		
			return settlDate2;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlDate2() { return hasSettlDate2 != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlDate2(byte[] src) {		
		if (src == null ) return;
		if (hasSettlDate2()) FixUtils.fillNul(settlDate2);		
		FixUtils.copy(settlDate2, src); 		
		hasSettlDate2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlDate2(String str) {		
		if (str == null ) return;
		if (hasSettlDate2()) FixUtils.fillNul(settlDate2);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlDate2, src); 		
		hasSettlDate2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOrderQty2() { 		
		if ( hasOrderQty2()) {		
			if (hasOrderQty2 == FixUtils.TAG_HAS_VALUE) {		
				return orderQty2; 		
			} else {		
		
				buf.position(hasOrderQty2);		
		
			orderQty2 = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderQty2);		
					return 0;		
				}		
			}		
			hasOrderQty2 = FixUtils.TAG_HAS_VALUE;		
			return orderQty2;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrderQty2() { return hasOrderQty2 != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderQty2(long src) {		
		orderQty2 = src;
		hasOrderQty2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderQty2(byte[] src) {		
		if (src == null ) return;
		if (hasOrderQty2()) orderQty2 = FixUtils.TAG_HAS_NO_VALUE;		
		orderQty2 = FixUtils.longValueOf(src, 0, src.length);
		hasOrderQty2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderQty2(String str) {		
		if (str == null ) return;
		if (hasOrderQty2()) orderQty2 = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		orderQty2 = FixUtils.longValueOf(src, 0, src.length);
		hasOrderQty2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getBidForwardPoints2() { 		
		if ( hasBidForwardPoints2()) {		
			if (hasBidForwardPoints2 == FixUtils.TAG_HAS_VALUE) {		
				return bidForwardPoints2; 		
			} else {		
		
				buf.position(hasBidForwardPoints2);		
		
			bidForwardPoints2 = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBidForwardPoints2);		
					return 0;		
				}		
			}		
			hasBidForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
			return bidForwardPoints2;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidForwardPoints2() { return hasBidForwardPoints2 != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBidForwardPoints2(long src) {		
		bidForwardPoints2 = src;
		hasBidForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidForwardPoints2(byte[] src) {		
		if (src == null ) return;
		if (hasBidForwardPoints2()) bidForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		bidForwardPoints2 = FixUtils.longValueOf(src, 0, src.length);
		hasBidForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBidForwardPoints2(String str) {		
		if (str == null ) return;
		if (hasBidForwardPoints2()) bidForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidForwardPoints2 = FixUtils.longValueOf(src, 0, src.length);
		hasBidForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOfferForwardPoints2() { 		
		if ( hasOfferForwardPoints2()) {		
			if (hasOfferForwardPoints2 == FixUtils.TAG_HAS_VALUE) {		
				return offerForwardPoints2; 		
			} else {		
		
				buf.position(hasOfferForwardPoints2);		
		
			offerForwardPoints2 = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOfferForwardPoints2);		
					return 0;		
				}		
			}		
			hasOfferForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
			return offerForwardPoints2;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOfferForwardPoints2() { return hasOfferForwardPoints2 != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOfferForwardPoints2(long src) {		
		offerForwardPoints2 = src;
		hasOfferForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOfferForwardPoints2(byte[] src) {		
		if (src == null ) return;
		if (hasOfferForwardPoints2()) offerForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		offerForwardPoints2 = FixUtils.longValueOf(src, 0, src.length);
		hasOfferForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOfferForwardPoints2(String str) {		
		if (str == null ) return;
		if (hasOfferForwardPoints2()) offerForwardPoints2 = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		offerForwardPoints2 = FixUtils.longValueOf(src, 0, src.length);
		hasOfferForwardPoints2 = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCurrency() { 		
		if ( hasCurrency()) {		
			if (hasCurrency == FixUtils.TAG_HAS_VALUE) {		
				return currency; 		
			} else {		
		
				buf.position(hasCurrency);		
		
			FixMessage.getTagStringValue(buf, currency, 0, currency.length, err);
		
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
			
	public long getBookingType() { 		
		if ( hasBookingType()) {		
			if (hasBookingType == FixUtils.TAG_HAS_VALUE) {		
				return bookingType; 		
			} else {		
		
				buf.position(hasBookingType);		
		
			bookingType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBookingType);		
					return 0;		
				}		
			}		
			hasBookingType = FixUtils.TAG_HAS_VALUE;		
			return bookingType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBookingType() { return hasBookingType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBookingType(long src) {		
		bookingType = src;
		hasBookingType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBookingType(byte[] src) {		
		if (src == null ) return;
		if (hasBookingType()) bookingType = FixUtils.TAG_HAS_NO_VALUE;		
		bookingType = FixUtils.longValueOf(src, 0, src.length);
		hasBookingType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBookingType(String str) {		
		if (str == null ) return;
		if (hasBookingType()) bookingType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bookingType = FixUtils.longValueOf(src, 0, src.length);
		hasBookingType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getOrderCapacity() { 		
		if ( hasOrderCapacity()) {		
			if (hasOrderCapacity == FixUtils.TAG_HAS_VALUE) {		
				return orderCapacity; 		
			} else {		
		
				buf.position(hasOrderCapacity);		
		
			orderCapacity = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (orderCapacity != (byte)'W') && (orderCapacity != (byte)'G') && (orderCapacity != (byte)'P') && (orderCapacity != (byte)'A') && (orderCapacity != (byte)'R') && (orderCapacity != (byte)'I') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 528);		
				if (err.hasError()) {		
					buf.position(hasOrderCapacity);		
					return (byte)'0';		
				}		
			}		
			hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
			return orderCapacity;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrderCapacity() { return hasOrderCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderCapacity(byte src) {		
		orderCapacity = src;
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasOrderCapacity()) orderCapacity = (byte)' ';		
		orderCapacity = src[0];		
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderCapacity(String str) {		
		if (str == null ) return;
		if (hasOrderCapacity()) orderCapacity = (byte)' ';		
		byte[] src = str.getBytes(); 		
		orderCapacity = src[0];		
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOrderRestrictions() { 		
		if ( hasOrderRestrictions()) {		
			if (hasOrderRestrictions == FixUtils.TAG_HAS_VALUE) {		
				return orderRestrictions; 		
			} else {		
		
				buf.position(hasOrderRestrictions);		
		
			FixMessage.getTagStringValue(buf, orderRestrictions, 0, orderRestrictions.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOrderRestrictions);		
					return null;		
				}		
			}		
			hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
			return orderRestrictions;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderRestrictions() { return hasOrderRestrictions != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrderRestrictions(byte[] src) {		
		if (src == null ) return;
		if (hasOrderRestrictions()) FixUtils.fillNul(orderRestrictions);		
		FixUtils.copy(orderRestrictions, src); 		
		hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrderRestrictions(String str) {		
		if (str == null ) return;
		if (hasOrderRestrictions()) FixUtils.fillNul(orderRestrictions);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderRestrictions, src); 		
		hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasQuoteEntryID()) s += "QuoteEntryID(299)= " + new String( FixUtils.trim(getQuoteEntryID()) ) + "\n" ; 
		if (hasBidPx()) s += "BidPx(132)= " + getBidPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOfferPx()) s += "OfferPx(133)= " + getOfferPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasBidSize()) s += "BidSize(134)= " + getBidSize() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOfferSize()) s += "OfferSize(135)= " + getOfferSize() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasValidUntilTime()) s += "ValidUntilTime(62)= " + new String( FixUtils.trim(getValidUntilTime()) ) + "\n" ; 
		if (hasBidSpotRate()) s += "BidSpotRate(188)= " + getBidSpotRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOfferSpotRate()) s += "OfferSpotRate(190)= " + getOfferSpotRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasBidForwardPoints()) s += "BidForwardPoints(189)= " + getBidForwardPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOfferForwardPoints()) s += "OfferForwardPoints(191)= " + getOfferForwardPoints() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMidPx()) s += "MidPx(631)= " + getMidPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasBidYield()) s += "BidYield(632)= " + getBidYield() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMidYield()) s += "MidYield(633)= " + getMidYield() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOfferYield()) s += "OfferYield(634)= " + getOfferYield() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasOrdType()) s += "OrdType(40)= " + getOrdType() + "\n" ; 
		if (hasSettlDate2()) s += "SettlDate2(193)= " + new String( FixUtils.trim(getSettlDate2()) ) + "\n" ; 
		if (hasOrderQty2()) s += "OrderQty2(192)= " + getOrderQty2() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasBidForwardPoints2()) s += "BidForwardPoints2(642)= " + getBidForwardPoints2() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOfferForwardPoints2()) s += "OfferForwardPoints2(643)= " + getOfferForwardPoints2() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasBookingType()) s += "BookingType(775)= " + getBookingType() + "\n" ; 
		if (hasOrderCapacity()) s += "OrderCapacity(528)= " + getOrderCapacity() + "\n" ; 
		if (hasOrderRestrictions()) s += "OrderRestrictions(529)= " + new String( FixUtils.trim(getOrderRestrictions()) ) + "\n" ; 

		s += instrument.toString();
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixQuotEntryGrp)) return false;

		FixQuotEntryGrp msg = (FixQuotEntryGrp) o;

		if (!instrument.equals(msg.instrument)) return false;
		for (int i = 0; i < instrmtLegGrp.length; i++)
			if (!instrmtLegGrp[i].equals(msg.instrmtLegGrp[i])) return false;
		if ((hasQuoteEntryID() && !msg.hasQuoteEntryID()) || (!hasQuoteEntryID() && msg.hasQuoteEntryID())) return false;
		if (!(!hasQuoteEntryID() && !msg.hasQuoteEntryID()) && !FixUtils.equals(getQuoteEntryID(), msg.getQuoteEntryID())) return false;
		if ((hasBidPx() && !msg.hasBidPx()) || (!hasBidPx() && msg.hasBidPx())) return false;
		if (!(!hasBidPx() && !msg.hasBidPx()) && !(getBidPx()==msg.getBidPx())) return false;
		if ((hasOfferPx() && !msg.hasOfferPx()) || (!hasOfferPx() && msg.hasOfferPx())) return false;
		if (!(!hasOfferPx() && !msg.hasOfferPx()) && !(getOfferPx()==msg.getOfferPx())) return false;
		if ((hasBidSize() && !msg.hasBidSize()) || (!hasBidSize() && msg.hasBidSize())) return false;
		if (!(!hasBidSize() && !msg.hasBidSize()) && !(getBidSize()==msg.getBidSize())) return false;
		if ((hasOfferSize() && !msg.hasOfferSize()) || (!hasOfferSize() && msg.hasOfferSize())) return false;
		if (!(!hasOfferSize() && !msg.hasOfferSize()) && !(getOfferSize()==msg.getOfferSize())) return false;
		if ((hasValidUntilTime() && !msg.hasValidUntilTime()) || (!hasValidUntilTime() && msg.hasValidUntilTime())) return false;
		if ((hasBidSpotRate() && !msg.hasBidSpotRate()) || (!hasBidSpotRate() && msg.hasBidSpotRate())) return false;
		if (!(!hasBidSpotRate() && !msg.hasBidSpotRate()) && !(getBidSpotRate()==msg.getBidSpotRate())) return false;
		if ((hasOfferSpotRate() && !msg.hasOfferSpotRate()) || (!hasOfferSpotRate() && msg.hasOfferSpotRate())) return false;
		if (!(!hasOfferSpotRate() && !msg.hasOfferSpotRate()) && !(getOfferSpotRate()==msg.getOfferSpotRate())) return false;
		if ((hasBidForwardPoints() && !msg.hasBidForwardPoints()) || (!hasBidForwardPoints() && msg.hasBidForwardPoints())) return false;
		if (!(!hasBidForwardPoints() && !msg.hasBidForwardPoints()) && !(getBidForwardPoints()==msg.getBidForwardPoints())) return false;
		if ((hasOfferForwardPoints() && !msg.hasOfferForwardPoints()) || (!hasOfferForwardPoints() && msg.hasOfferForwardPoints())) return false;
		if (!(!hasOfferForwardPoints() && !msg.hasOfferForwardPoints()) && !(getOfferForwardPoints()==msg.getOfferForwardPoints())) return false;
		if ((hasMidPx() && !msg.hasMidPx()) || (!hasMidPx() && msg.hasMidPx())) return false;
		if (!(!hasMidPx() && !msg.hasMidPx()) && !(getMidPx()==msg.getMidPx())) return false;
		if ((hasBidYield() && !msg.hasBidYield()) || (!hasBidYield() && msg.hasBidYield())) return false;
		if (!(!hasBidYield() && !msg.hasBidYield()) && !(getBidYield()==msg.getBidYield())) return false;
		if ((hasMidYield() && !msg.hasMidYield()) || (!hasMidYield() && msg.hasMidYield())) return false;
		if (!(!hasMidYield() && !msg.hasMidYield()) && !(getMidYield()==msg.getMidYield())) return false;
		if ((hasOfferYield() && !msg.hasOfferYield()) || (!hasOfferYield() && msg.hasOfferYield())) return false;
		if (!(!hasOfferYield() && !msg.hasOfferYield()) && !(getOfferYield()==msg.getOfferYield())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		if ((hasSettlDate() && !msg.hasSettlDate()) || (!hasSettlDate() && msg.hasSettlDate())) return false;
		if ((hasOrdType() && !msg.hasOrdType()) || (!hasOrdType() && msg.hasOrdType())) return false;
		if (!(!hasOrdType() && !msg.hasOrdType()) && !(getOrdType()==msg.getOrdType())) return false;
		if ((hasSettlDate2() && !msg.hasSettlDate2()) || (!hasSettlDate2() && msg.hasSettlDate2())) return false;
		if ((hasOrderQty2() && !msg.hasOrderQty2()) || (!hasOrderQty2() && msg.hasOrderQty2())) return false;
		if (!(!hasOrderQty2() && !msg.hasOrderQty2()) && !(getOrderQty2()==msg.getOrderQty2())) return false;
		if ((hasBidForwardPoints2() && !msg.hasBidForwardPoints2()) || (!hasBidForwardPoints2() && msg.hasBidForwardPoints2())) return false;
		if (!(!hasBidForwardPoints2() && !msg.hasBidForwardPoints2()) && !(getBidForwardPoints2()==msg.getBidForwardPoints2())) return false;
		if ((hasOfferForwardPoints2() && !msg.hasOfferForwardPoints2()) || (!hasOfferForwardPoints2() && msg.hasOfferForwardPoints2())) return false;
		if (!(!hasOfferForwardPoints2() && !msg.hasOfferForwardPoints2()) && !(getOfferForwardPoints2()==msg.getOfferForwardPoints2())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasBookingType() && !msg.hasBookingType()) || (!hasBookingType() && msg.hasBookingType())) return false;
		if (!(!hasBookingType() && !msg.hasBookingType()) && !(getBookingType()==msg.getBookingType())) return false;
		if ((hasOrderCapacity() && !msg.hasOrderCapacity()) || (!hasOrderCapacity() && msg.hasOrderCapacity())) return false;
		if (!(!hasOrderCapacity() && !msg.hasOrderCapacity()) && !(getOrderCapacity()==msg.getOrderCapacity())) return false;
		if ((hasOrderRestrictions() && !msg.hasOrderRestrictions()) || (!hasOrderRestrictions() && msg.hasOrderRestrictions())) return false;
		if (!(!hasOrderRestrictions() && !msg.hasOrderRestrictions()) && !FixUtils.equals(getOrderRestrictions(), msg.getOrderRestrictions())) return false;
		return true;
	}
	public FixQuotEntryGrp clone ( FixQuotEntryGrp out ) {
		if ( hasQuoteEntryID())
			out.setQuoteEntryID(getQuoteEntryID());
		if ( hasBidPx())
			out.setBidPx(getBidPx());
		if ( hasOfferPx())
			out.setOfferPx(getOfferPx());
		if ( hasBidSize())
			out.setBidSize(getBidSize());
		if ( hasOfferSize())
			out.setOfferSize(getOfferSize());
		if ( hasValidUntilTime())
			out.setValidUntilTime(getValidUntilTime());
		if ( hasBidSpotRate())
			out.setBidSpotRate(getBidSpotRate());
		if ( hasOfferSpotRate())
			out.setOfferSpotRate(getOfferSpotRate());
		if ( hasBidForwardPoints())
			out.setBidForwardPoints(getBidForwardPoints());
		if ( hasOfferForwardPoints())
			out.setOfferForwardPoints(getOfferForwardPoints());
		if ( hasMidPx())
			out.setMidPx(getMidPx());
		if ( hasBidYield())
			out.setBidYield(getBidYield());
		if ( hasMidYield())
			out.setMidYield(getMidYield());
		if ( hasOfferYield())
			out.setOfferYield(getOfferYield());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		if ( hasSettlDate())
			out.setSettlDate(getSettlDate());
		if ( hasOrdType())
			out.setOrdType(getOrdType());
		if ( hasSettlDate2())
			out.setSettlDate2(getSettlDate2());
		if ( hasOrderQty2())
			out.setOrderQty2(getOrderQty2());
		if ( hasBidForwardPoints2())
			out.setBidForwardPoints2(getBidForwardPoints2());
		if ( hasOfferForwardPoints2())
			out.setOfferForwardPoints2(getOfferForwardPoints2());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasBookingType())
			out.setBookingType(getBookingType());
		if ( hasOrderCapacity())
			out.setOrderCapacity(getOrderCapacity());
		if ( hasOrderRestrictions())
			out.setOrderRestrictions(getOrderRestrictions());
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		int count = 0;
		count = 0;
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) {
			if (!fixInstrmtLegGrp.hasGroup()) continue;
			out.instrmtLegGrp[count] = fixInstrmtLegGrp.clone( out.instrmtLegGrp[count] );
			count++;
		}
		return out;
	}

}
