package org.tomac.protocol.fix.messaging.fix50sp2.component;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrmtLegGrp;

public class FixQuotEntryGrp
{

	public int noQuoteEntries;
	public QuotEntryGrp[] group;

	public void getAll(int noQuoteEntries, ByteBuffer buf) throws FixSessionException {
		this.noQuoteEntries = noQuoteEntries;

		if (noQuoteEntries < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noQuoteEntries) 
			group = new QuotEntryGrp[noQuoteEntries];

		for ( int i = 0; i < noQuoteEntries; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noQuoteEntries; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noQuoteEntries; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noQuoteEntries; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noQuoteEntries; i++)
			s += group[i].toString();
		return s;
	}

public class QuotEntryGrp implements FixComponent
{

	public byte[] quoteEntryID;
	public FixInstrument instrument;
	public FixInstrmtLegGrp instrmtLegGrp;
	public long bidPx = 0;
	public long offerPx = 0;
	public long bidSize = 0;
	public long offerSize = 0;
	public byte[] validUntilTime;
	public long bidSpotRate = 0;
	public long offerSpotRate = 0;
	public long bidForwardPoints = 0;
	public long offerForwardPoints = 0;
	public long midPx = 0;
	public long bidYield = 0;
	public long midYield = 0;
	public long offerYield = 0;
	public byte[] transactTime;
	public byte[] tradingSessionID;
	public byte[] tradingSessionSubID;
	public byte[] settlDate;
	public byte ordType = (byte)' ';
	public byte[] settlDate2;
	public long orderQty2 = 0;
	public long bidForwardPoints2 = 0;
	public long offerForwardPoints2 = 0;
	public byte[] currency;
	public long bookingType = 0;
	public byte orderCapacity = (byte)' ';
	public byte[] orderRestrictions;

	public QuotEntryGrp() {
		super();

		quoteEntryID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		instrument = new FixInstrument();
		instrmtLegGrp = new FixInstrmtLegGrp();
		validUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlDate2 = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		currency = new byte[FixUtils.CURRENCY_LENGTH];
		orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( quoteEntryID, (byte)0 );
		bidPx = Long.MAX_VALUE;		
		offerPx = Long.MAX_VALUE;		
		bidSize = Long.MAX_VALUE;		
		offerSize = Long.MAX_VALUE;		
		Utils.fill( validUntilTime, (byte)0 );
		bidSpotRate = Long.MAX_VALUE;		
		offerSpotRate = Long.MAX_VALUE;		
		bidForwardPoints = Long.MAX_VALUE;		
		offerForwardPoints = Long.MAX_VALUE;		
		midPx = Long.MAX_VALUE;		
		bidYield = Long.MAX_VALUE;		
		midYield = Long.MAX_VALUE;		
		offerYield = Long.MAX_VALUE;		
		Utils.fill( transactTime, (byte)0 );
		Utils.fill( tradingSessionID, (byte)0 );
		Utils.fill( tradingSessionSubID, (byte)0 );
		Utils.fill( settlDate, (byte)0 );
		ordType = Byte.MAX_VALUE;		
		Utils.fill( settlDate2, (byte)0 );
		orderQty2 = Long.MAX_VALUE;		
		bidForwardPoints2 = Long.MAX_VALUE;		
		offerForwardPoints2 = Long.MAX_VALUE;		
		Utils.fill( currency, (byte)0 );
		bookingType = Long.MAX_VALUE;		
		orderCapacity = Byte.MAX_VALUE;		
		Utils.fill( orderRestrictions, (byte)0 );
		instrument.clear();
		instrmtLegGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.QUOTEENTRYID_INT) {
				quoteEntryID = FixUtils.getTagStringValue(value, quoteEntryID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SYMBOL_INT) {
				instrument.getAll(FixTags.SYMBOL_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOLEGS_INT) {
				instrmtLegGrp.getAll(FixTags.NOLEGS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.BIDPX_INT) {
				bidPx = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.OFFERPX_INT) {
				offerPx = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.BIDSIZE_INT) {
				bidSize = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.OFFERSIZE_INT) {
				offerSize = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.VALIDUNTILTIME_INT) {
				validUntilTime = FixUtils.getTagStringValue(value, validUntilTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.BIDSPOTRATE_INT) {
				bidSpotRate = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.OFFERSPOTRATE_INT) {
				offerSpotRate = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.BIDFORWARDPOINTS_INT) {
				bidForwardPoints = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.OFFERFORWARDPOINTS_INT) {
				offerForwardPoints = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MIDPX_INT) {
				midPx = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.BIDYIELD_INT) {
				bidYield = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MIDYIELD_INT) {
				midYield = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.OFFERYIELD_INT) {
				offerYield = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRANSACTTIME_INT) {
				transactTime = FixUtils.getTagStringValue(value, transactTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADINGSESSIONID_INT) {
				tradingSessionID = FixUtils.getTagStringValue(value, tradingSessionID);
				if (!FixMessageInfo.TradingSessionID.isValid(tradingSessionID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradingSessionID + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADINGSESSIONSUBID_INT) {
				tradingSessionSubID = FixUtils.getTagStringValue(value, tradingSessionSubID);
				if (!FixMessageInfo.TradingSessionSubID.isValid(tradingSessionSubID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradingSessionSubID + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLDATE_INT) {
				settlDate = FixUtils.getTagStringValue(value, settlDate);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORDTYPE_INT) {
				ordType = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.OrdType.isValid(ordType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + ordType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLDATE2_INT) {
				settlDate2 = FixUtils.getTagStringValue(value, settlDate2);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORDERQTY2_INT) {
				orderQty2 = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.BIDFORWARDPOINTS2_INT) {
				bidForwardPoints2 = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.OFFERFORWARDPOINTS2_INT) {
				offerForwardPoints2 = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CURRENCY_INT) {
				currency = FixUtils.getTagStringValue(value, currency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.BOOKINGTYPE_INT) {
				bookingType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.BookingType.isValid(bookingType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + bookingType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORDERCAPACITY_INT) {
				orderCapacity = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.OrderCapacity.isValid(orderCapacity) ) throw new FixSessionException(buf, "Invalid enumerated value(" + orderCapacity + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORDERRESTRICTIONS_INT) {
				orderRestrictions = FixUtils.getTagStringValue(value, orderRestrictions);
				if (!FixMessageInfo.OrderRestrictions.isValid(orderRestrictions) ) throw new FixSessionException(buf, "Invalid enumerated value(" + orderRestrictions + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
			if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		if (! FixUtils.isSet(quoteEntryID) ) return FixTags.QUOTEENTRYID_INT;
		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(instrument.symbol)) return true;
		if (FixUtils.isSet(instrmtLegGrp.noLegs)) return true;
		if (FixUtils.isSet(bidPx)) return true;
		if (FixUtils.isSet(offerPx)) return true;
		if (FixUtils.isSet(bidSize)) return true;
		if (FixUtils.isSet(offerSize)) return true;
		if (FixUtils.isSet(validUntilTime)) return true;
		if (FixUtils.isSet(bidSpotRate)) return true;
		if (FixUtils.isSet(offerSpotRate)) return true;
		if (FixUtils.isSet(bidForwardPoints)) return true;
		if (FixUtils.isSet(offerForwardPoints)) return true;
		if (FixUtils.isSet(midPx)) return true;
		if (FixUtils.isSet(bidYield)) return true;
		if (FixUtils.isSet(midYield)) return true;
		if (FixUtils.isSet(offerYield)) return true;
		if (FixUtils.isSet(transactTime)) return true;
		if (FixUtils.isSet(tradingSessionID)) return true;
		if (FixUtils.isSet(tradingSessionSubID)) return true;
		if (FixUtils.isSet(settlDate)) return true;
		if (FixUtils.isSet(ordType)) return true;
		if (FixUtils.isSet(settlDate2)) return true;
		if (FixUtils.isSet(orderQty2)) return true;
		if (FixUtils.isSet(bidForwardPoints2)) return true;
		if (FixUtils.isSet(offerForwardPoints2)) return true;
		if (FixUtils.isSet(currency)) return true;
		if (FixUtils.isSet(bookingType)) return true;
		if (FixUtils.isSet(orderCapacity)) return true;
		if (FixUtils.isSet(orderRestrictions)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		FixUtils.putFixTag( out, FixTags.QUOTEENTRYID_INT, quoteEntryID, 0, Utils.lastIndexTrim(quoteEntryID, (byte)0) );
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(instrmtLegGrp.noLegs)) instrmtLegGrp.encode( out );
		if (FixUtils.isSet(bidPx)) FixUtils.putFixFloatTag( out, FixTags.BIDPX_INT, bidPx);
		if (FixUtils.isSet(offerPx)) FixUtils.putFixFloatTag( out, FixTags.OFFERPX_INT, offerPx);
		if (FixUtils.isSet(bidSize)) FixUtils.putFixFloatTag( out, FixTags.BIDSIZE_INT, bidSize);
		if (FixUtils.isSet(offerSize)) FixUtils.putFixFloatTag( out, FixTags.OFFERSIZE_INT, offerSize);
		if (FixUtils.isSet(validUntilTime)) FixUtils.putFixTag( out, FixTags.VALIDUNTILTIME_INT, validUntilTime);
		if (FixUtils.isSet(bidSpotRate)) FixUtils.putFixFloatTag( out, FixTags.BIDSPOTRATE_INT, bidSpotRate);
		if (FixUtils.isSet(offerSpotRate)) FixUtils.putFixFloatTag( out, FixTags.OFFERSPOTRATE_INT, offerSpotRate);
		if (FixUtils.isSet(bidForwardPoints)) FixUtils.putFixFloatTag( out, FixTags.BIDFORWARDPOINTS_INT, bidForwardPoints);
		if (FixUtils.isSet(offerForwardPoints)) FixUtils.putFixFloatTag( out, FixTags.OFFERFORWARDPOINTS_INT, offerForwardPoints);
		if (FixUtils.isSet(midPx)) FixUtils.putFixFloatTag( out, FixTags.MIDPX_INT, midPx);
		if (FixUtils.isSet(bidYield)) FixUtils.putFixFloatTag( out, FixTags.BIDYIELD_INT, bidYield);
		if (FixUtils.isSet(midYield)) FixUtils.putFixFloatTag( out, FixTags.MIDYIELD_INT, midYield);
		if (FixUtils.isSet(offerYield)) FixUtils.putFixFloatTag( out, FixTags.OFFERYIELD_INT, offerYield);
		if (FixUtils.isSet(transactTime)) FixUtils.putFixTag( out, FixTags.TRANSACTTIME_INT, transactTime);
		if (FixUtils.isSet(tradingSessionID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONID_INT, tradingSessionID, 0, Utils.lastIndexTrim(tradingSessionID, (byte)0) );
		if (FixUtils.isSet(tradingSessionSubID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONSUBID_INT, tradingSessionSubID, 0, Utils.lastIndexTrim(tradingSessionSubID, (byte)0) );
		if (FixUtils.isSet(settlDate)) FixUtils.putFixTag( out, FixTags.SETTLDATE_INT, settlDate);
		if (FixUtils.isSet(ordType)) FixUtils.putFixTag( out, FixTags.ORDTYPE_INT, ordType );
		if (FixUtils.isSet(settlDate2)) FixUtils.putFixTag( out, FixTags.SETTLDATE2_INT, settlDate2);
		if (FixUtils.isSet(orderQty2)) FixUtils.putFixFloatTag( out, FixTags.ORDERQTY2_INT, orderQty2);
		if (FixUtils.isSet(bidForwardPoints2)) FixUtils.putFixFloatTag( out, FixTags.BIDFORWARDPOINTS2_INT, bidForwardPoints2);
		if (FixUtils.isSet(offerForwardPoints2)) FixUtils.putFixFloatTag( out, FixTags.OFFERFORWARDPOINTS2_INT, offerForwardPoints2);
		if (FixUtils.isSet(currency)) FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		if (FixUtils.isSet(bookingType)) FixUtils.putFixTag( out, FixTags.BOOKINGTYPE_INT, bookingType);
		if (FixUtils.isSet(orderCapacity)) FixUtils.putFixTag( out, FixTags.ORDERCAPACITY_INT, orderCapacity );
		if (FixUtils.isSet(orderRestrictions)) FixUtils.putFixTag( out, FixTags.ORDERRESTRICTIONS_INT, orderRestrictions, 0, Utils.lastIndexTrim(orderRestrictions, (byte)0) );
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			 s += "QuoteEntryID(299)=" + new String(quoteEntryID) + sep;
			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(instrmtLegGrp.noLegs)) s += instrmtLegGrp.toString();
			if (FixUtils.isSet(bidPx)) s += "BidPx(132)=" + String.valueOf(bidPx) + sep;
			if (FixUtils.isSet(offerPx)) s += "OfferPx(133)=" + String.valueOf(offerPx) + sep;
			if (FixUtils.isSet(bidSize)) s += "BidSize(134)=" + String.valueOf(bidSize) + sep;
			if (FixUtils.isSet(offerSize)) s += "OfferSize(135)=" + String.valueOf(offerSize) + sep;
			if (FixUtils.isSet(validUntilTime)) s += "ValidUntilTime(62)=" + new String(validUntilTime) + sep;
			if (FixUtils.isSet(bidSpotRate)) s += "BidSpotRate(188)=" + String.valueOf(bidSpotRate) + sep;
			if (FixUtils.isSet(offerSpotRate)) s += "OfferSpotRate(190)=" + String.valueOf(offerSpotRate) + sep;
			if (FixUtils.isSet(bidForwardPoints)) s += "BidForwardPoints(189)=" + String.valueOf(bidForwardPoints) + sep;
			if (FixUtils.isSet(offerForwardPoints)) s += "OfferForwardPoints(191)=" + String.valueOf(offerForwardPoints) + sep;
			if (FixUtils.isSet(midPx)) s += "MidPx(631)=" + String.valueOf(midPx) + sep;
			if (FixUtils.isSet(bidYield)) s += "BidYield(632)=" + String.valueOf(bidYield) + sep;
			if (FixUtils.isSet(midYield)) s += "MidYield(633)=" + String.valueOf(midYield) + sep;
			if (FixUtils.isSet(offerYield)) s += "OfferYield(634)=" + String.valueOf(offerYield) + sep;
			if (FixUtils.isSet(transactTime)) s += "TransactTime(60)=" + new String(transactTime) + sep;
			if (FixUtils.isSet(tradingSessionID)) s += "TradingSessionID(336)=" + new String(tradingSessionID) + sep;
			if (FixUtils.isSet(tradingSessionSubID)) s += "TradingSessionSubID(625)=" + new String(tradingSessionSubID) + sep;
			if (FixUtils.isSet(settlDate)) s += "SettlDate(64)=" + new String(settlDate) + sep;
			if (FixUtils.isSet(ordType)) s += "OrdType(40)=" + String.valueOf(ordType) + sep;
			if (FixUtils.isSet(settlDate2)) s += "SettlDate2(193)=" + new String(settlDate2) + sep;
			if (FixUtils.isSet(orderQty2)) s += "OrderQty2(192)=" + String.valueOf(orderQty2) + sep;
			if (FixUtils.isSet(bidForwardPoints2)) s += "BidForwardPoints2(642)=" + String.valueOf(bidForwardPoints2) + sep;
			if (FixUtils.isSet(offerForwardPoints2)) s += "OfferForwardPoints2(643)=" + String.valueOf(offerForwardPoints2) + sep;
			if (FixUtils.isSet(currency)) s += "Currency(15)=" + new String(currency) + sep;
			if (FixUtils.isSet(bookingType)) s += "BookingType(775)=" + String.valueOf(bookingType) + sep;
			if (FixUtils.isSet(orderCapacity)) s += "OrderCapacity(528)=" + String.valueOf(orderCapacity) + sep;
			if (FixUtils.isSet(orderRestrictions)) s += "OrderRestrictions(529)=" + new String(orderRestrictions) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof QuotEntryGrp)) return false;

			QuotEntryGrp msg = (QuotEntryGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( quoteEntryID, msg.quoteEntryID)) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!instrmtLegGrp.equals(msg.instrmtLegGrp)) return false;

		if (!( bidPx==msg.bidPx)) return false;

		if (!( offerPx==msg.offerPx)) return false;

		if (!( bidSize==msg.bidSize)) return false;

		if (!( offerSize==msg.offerSize)) return false;

		if (!( bidSpotRate==msg.bidSpotRate)) return false;

		if (!( offerSpotRate==msg.offerSpotRate)) return false;

		if (!( bidForwardPoints==msg.bidForwardPoints)) return false;

		if (!( offerForwardPoints==msg.offerForwardPoints)) return false;

		if (!( midPx==msg.midPx)) return false;

		if (!( bidYield==msg.bidYield)) return false;

		if (!( midYield==msg.midYield)) return false;

		if (!( offerYield==msg.offerYield)) return false;

		if (!Utils.equals( tradingSessionID, msg.tradingSessionID)) return false;

		if (!Utils.equals( tradingSessionSubID, msg.tradingSessionSubID)) return false;

		if (!( ordType==msg.ordType)) return false;

		if (!( orderQty2==msg.orderQty2)) return false;

		if (!( bidForwardPoints2==msg.bidForwardPoints2)) return false;

		if (!( offerForwardPoints2==msg.offerForwardPoints2)) return false;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!( bookingType==msg.bookingType)) return false;

		if (!( orderCapacity==msg.orderCapacity)) return false;

		if (!Utils.equals( orderRestrictions, msg.orderRestrictions)) return false;

		return true;
	}
}
}