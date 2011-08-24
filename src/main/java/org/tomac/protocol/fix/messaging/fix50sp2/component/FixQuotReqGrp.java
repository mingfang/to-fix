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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.SessionRejectReason;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixFinancingDetails;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUndInstrmtGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixOrderQtyData;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixRateSource;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixStipulations;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixQuotReqLegsGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixQuotQualGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixSpreadOrBenchmarkCurveData;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixYieldData;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixParties;

public class FixQuotReqGrp
{

	public int noRelatedSym;
	public QuotReqGrp[] group;

	public void getAll(int noRelatedSym, ByteBuffer buf) throws FixSessionException {
		this.noRelatedSym = noRelatedSym;

		if (noRelatedSym < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noRelatedSym ).getBytes(), FixTags.NORELATEDSYM_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noRelatedSym) {
			group = new QuotReqGrp[noRelatedSym];

			for ( int i = 0; i < noRelatedSym; i++ ) group[i] = new QuotReqGrp();
	}

		for ( int i = 0; i < noRelatedSym; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRelatedSym; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRelatedSym; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRelatedSym; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRelatedSym; i++)
			s += group[i].toString();
		return s;
	}

public class QuotReqGrp implements FixComponent
{

	public FixInstrument instrument;
	public FixFinancingDetails financingDetails;
	public FixUndInstrmtGrp undInstrmtGrp;
	public long prevClosePx = 0;
	public long quoteRequestType = 0;
	public long quoteType = 0;
	public byte[] tradingSessionID;
	public byte[] tradingSessionSubID;
	public byte[] tradeOriginationDate;
	public byte side = (byte)' ';
	public long qtyType = 0;
	public long minQty = 0;
	public FixOrderQtyData orderQtyData;
	public byte[] settlType;
	public byte[] settlDate;
	public byte[] settlDate2;
	public long orderQty2 = 0;
	public byte[] currency;
	public byte[] settlCurrency;
	public FixRateSource rateSource;
	public FixStipulations stipulations;
	public byte[] account;
	public long acctIDSource = 0;
	public long accountType = 0;
	public FixQuotReqLegsGrp quotReqLegsGrp;
	public FixQuotQualGrp quotQualGrp;
	public long quotePriceType = 0;
	public byte ordType = (byte)' ';
	public byte[] validUntilTime;
	public byte[] expireTime;
	public byte[] transactTime;
	public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	public long priceType = 0;
	public long price = 0;
	public long price2 = 0;
	public FixYieldData yieldData;
	public FixParties parties;

	public QuotReqGrp() {
		super();

		instrument = new FixInstrument();
		financingDetails = new FixFinancingDetails();
		undInstrmtGrp = new FixUndInstrmtGrp();
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeOriginationDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		orderQtyData = new FixOrderQtyData();
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlDate2 = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		currency = new byte[FixUtils.CURRENCY_LENGTH];
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];
		rateSource = new FixRateSource();
		stipulations = new FixStipulations();
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		quotReqLegsGrp = new FixQuotReqLegsGrp();
		quotQualGrp = new FixQuotQualGrp();
		validUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		yieldData = new FixYieldData();
		parties = new FixParties();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		prevClosePx = Long.MAX_VALUE;		
		quoteRequestType = Long.MAX_VALUE;		
		quoteType = Long.MAX_VALUE;		
		Utils.fill( tradingSessionID, (byte)0 );
		Utils.fill( tradingSessionSubID, (byte)0 );
		Utils.fill( tradeOriginationDate, (byte)0 );
		side = Byte.MAX_VALUE;		
		qtyType = Long.MAX_VALUE;		
		minQty = Long.MAX_VALUE;		
		Utils.fill( settlType, (byte)0 );
		Utils.fill( settlDate, (byte)0 );
		Utils.fill( settlDate2, (byte)0 );
		orderQty2 = Long.MAX_VALUE;		
		Utils.fill( currency, (byte)0 );
		Utils.fill( settlCurrency, (byte)0 );
		Utils.fill( account, (byte)0 );
		acctIDSource = Long.MAX_VALUE;		
		accountType = Long.MAX_VALUE;		
		quotePriceType = Long.MAX_VALUE;		
		ordType = Byte.MAX_VALUE;		
		Utils.fill( validUntilTime, (byte)0 );
		Utils.fill( expireTime, (byte)0 );
		Utils.fill( transactTime, (byte)0 );
		priceType = Long.MAX_VALUE;		
		price = Long.MAX_VALUE;		
		price2 = Long.MAX_VALUE;		
		instrument.clear();
		financingDetails.clear();
		undInstrmtGrp.clear();
		orderQtyData.clear();
		rateSource.clear();
		stipulations.clear();
		quotReqLegsGrp.clear();
		quotQualGrp.clear();
		spreadOrBenchmarkCurveData.clear();
		yieldData.clear();
		parties.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.SYMBOL_INT) {
				instrument.getAll(FixTags.SYMBOL_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.AGREEMENTDESC_INT) {
				financingDetails.getAll(FixTags.AGREEMENTDESC_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOUNDERLYINGS_INT) {
				undInstrmtGrp.getAll(FixTags.NOUNDERLYINGS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PREVCLOSEPX_INT) {
				prevClosePx = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.QUOTEREQUESTTYPE_INT) {
				quoteRequestType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.QuoteRequestType.isValid(quoteRequestType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + quoteRequestType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.QUOTETYPE_INT) {
				quoteType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.QuoteType.isValid(quoteType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + quoteType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADINGSESSIONID_INT) {
				tradingSessionID = FixUtils.getTagStringValue(value, tradingSessionID);
				if (!FixMessageInfo.TradingSessionID.isValid(tradingSessionID) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + tradingSessionID + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADINGSESSIONSUBID_INT) {
				tradingSessionSubID = FixUtils.getTagStringValue(value, tradingSessionSubID);
				if (!FixMessageInfo.TradingSessionSubID.isValid(tradingSessionSubID) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + tradingSessionSubID + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADEORIGINATIONDATE_INT) {
				tradeOriginationDate = FixUtils.getTagStringValue(value, tradeOriginationDate);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SIDE_INT) {
				side = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.Side.isValid(side) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + side + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.QTYTYPE_INT) {
				qtyType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.QtyType.isValid(qtyType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + qtyType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MINQTY_INT) {
				minQty = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORDERQTY_INT) {
				orderQtyData.getAll(FixTags.ORDERQTY_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLTYPE_INT) {
				settlType = FixUtils.getTagStringValue(value, settlType);
				if (!FixMessageInfo.SettlType.isValid(settlType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + settlType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLDATE_INT) {
				settlDate = FixUtils.getTagStringValue(value, settlDate);
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

			if(id == FixTags.CURRENCY_INT) {
				currency = FixUtils.getTagStringValue(value, currency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLCURRENCY_INT) {
				settlCurrency = FixUtils.getTagStringValue(value, settlCurrency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NORATESOURCES_INT) {
				rateSource.getAll(FixTags.NORATESOURCES_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOSTIPULATIONS_INT) {
				stipulations.getAll(FixTags.NOSTIPULATIONS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ACCOUNT_INT) {
				account = FixUtils.getTagStringValue(value, account);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ACCTIDSOURCE_INT) {
				acctIDSource = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.AcctIDSource.isValid(acctIDSource) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + acctIDSource + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ACCOUNTTYPE_INT) {
				accountType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.AccountType.isValid(accountType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + accountType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOLEGS_INT) {
				quotReqLegsGrp.getAll(FixTags.NOLEGS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOQUOTEQUALIFIERS_INT) {
				quotQualGrp.getAll(FixTags.NOQUOTEQUALIFIERS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.QUOTEPRICETYPE_INT) {
				quotePriceType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.QuotePriceType.isValid(quotePriceType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + quotePriceType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORDTYPE_INT) {
				ordType = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.OrdType.isValid(ordType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + ordType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.VALIDUNTILTIME_INT) {
				validUntilTime = FixUtils.getTagStringValue(value, validUntilTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.EXPIRETIME_INT) {
				expireTime = FixUtils.getTagStringValue(value, expireTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRANSACTTIME_INT) {
				transactTime = FixUtils.getTagStringValue(value, transactTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SPREAD_INT) {
				spreadOrBenchmarkCurveData.getAll(FixTags.SPREAD_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PRICETYPE_INT) {
				priceType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.PriceType.isValid(priceType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + priceType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PRICE_INT) {
				price = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PRICE2_INT) {
				price2 = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.YIELDTYPE_INT) {
				yieldData.getAll(FixTags.YIELDTYPE_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOPARTYIDS_INT) {
				parties.getAll(FixTags.NOPARTYIDS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		if (! instrument.isSet() ) return FixTags.SYMBOL_INT;
		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(instrument.symbol)) return true;
		if (FixUtils.isSet(financingDetails.agreementDesc)) return true;
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) return true;
		if (FixUtils.isSet(prevClosePx)) return true;
		if (FixUtils.isSet(quoteRequestType)) return true;
		if (FixUtils.isSet(quoteType)) return true;
		if (FixUtils.isSet(tradingSessionID)) return true;
		if (FixUtils.isSet(tradingSessionSubID)) return true;
		if (FixUtils.isSet(tradeOriginationDate)) return true;
		if (FixUtils.isSet(side)) return true;
		if (FixUtils.isSet(qtyType)) return true;
		if (FixUtils.isSet(minQty)) return true;
		if (FixUtils.isSet(orderQtyData.orderQty)) return true;
		if (FixUtils.isSet(settlType)) return true;
		if (FixUtils.isSet(settlDate)) return true;
		if (FixUtils.isSet(settlDate2)) return true;
		if (FixUtils.isSet(orderQty2)) return true;
		if (FixUtils.isSet(currency)) return true;
		if (FixUtils.isSet(settlCurrency)) return true;
		if (FixUtils.isSet(rateSource.noRateSources)) return true;
		if (FixUtils.isSet(stipulations.noStipulations)) return true;
		if (FixUtils.isSet(account)) return true;
		if (FixUtils.isSet(acctIDSource)) return true;
		if (FixUtils.isSet(accountType)) return true;
		if (FixUtils.isSet(quotReqLegsGrp.noLegs)) return true;
		if (FixUtils.isSet(quotQualGrp.noQuoteQualifiers)) return true;
		if (FixUtils.isSet(quotePriceType)) return true;
		if (FixUtils.isSet(ordType)) return true;
		if (FixUtils.isSet(validUntilTime)) return true;
		if (FixUtils.isSet(expireTime)) return true;
		if (FixUtils.isSet(transactTime)) return true;
		if (FixUtils.isSet(spreadOrBenchmarkCurveData.spread)) return true;
		if (FixUtils.isSet(priceType)) return true;
		if (FixUtils.isSet(price)) return true;
		if (FixUtils.isSet(price2)) return true;
		if (FixUtils.isSet(yieldData.yieldType)) return true;
		if (FixUtils.isSet(parties.noPartyIDs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(financingDetails.agreementDesc)) financingDetails.encode( out );
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) undInstrmtGrp.encode( out );
		if (FixUtils.isSet(prevClosePx)) FixUtils.putFixFloatTag( out, FixTags.PREVCLOSEPX_INT, prevClosePx);
		if (FixUtils.isSet(quoteRequestType)) FixUtils.putFixTag( out, FixTags.QUOTEREQUESTTYPE_INT, quoteRequestType);
		if (FixUtils.isSet(quoteType)) FixUtils.putFixTag( out, FixTags.QUOTETYPE_INT, quoteType);
		if (FixUtils.isSet(tradingSessionID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONID_INT, tradingSessionID, 0, Utils.lastIndexTrim(tradingSessionID, (byte)0) );
		if (FixUtils.isSet(tradingSessionSubID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONSUBID_INT, tradingSessionSubID, 0, Utils.lastIndexTrim(tradingSessionSubID, (byte)0) );
		if (FixUtils.isSet(tradeOriginationDate)) FixUtils.putFixTag( out, FixTags.TRADEORIGINATIONDATE_INT, tradeOriginationDate);
		if (FixUtils.isSet(side)) FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		if (FixUtils.isSet(qtyType)) FixUtils.putFixTag( out, FixTags.QTYTYPE_INT, qtyType);
		if (FixUtils.isSet(minQty)) FixUtils.putFixFloatTag( out, FixTags.MINQTY_INT, minQty);
		if (FixUtils.isSet(orderQtyData.orderQty)) orderQtyData.encode( out );
		if (FixUtils.isSet(settlType)) FixUtils.putFixTag( out, FixTags.SETTLTYPE_INT, settlType, 0, Utils.lastIndexTrim(settlType, (byte)0) );
		if (FixUtils.isSet(settlDate)) FixUtils.putFixTag( out, FixTags.SETTLDATE_INT, settlDate);
		if (FixUtils.isSet(settlDate2)) FixUtils.putFixTag( out, FixTags.SETTLDATE2_INT, settlDate2);
		if (FixUtils.isSet(orderQty2)) FixUtils.putFixFloatTag( out, FixTags.ORDERQTY2_INT, orderQty2);
		if (FixUtils.isSet(currency)) FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		if (FixUtils.isSet(settlCurrency)) FixUtils.putFixTag( out, FixTags.SETTLCURRENCY_INT, settlCurrency, 0, Utils.lastIndexTrim(settlCurrency, (byte)0) );
		if (FixUtils.isSet(rateSource.noRateSources)) rateSource.encode( out );
		if (FixUtils.isSet(stipulations.noStipulations)) stipulations.encode( out );
		if (FixUtils.isSet(account)) FixUtils.putFixTag( out, FixTags.ACCOUNT_INT, account, 0, Utils.lastIndexTrim(account, (byte)0) );
		if (FixUtils.isSet(acctIDSource)) FixUtils.putFixTag( out, FixTags.ACCTIDSOURCE_INT, acctIDSource);
		if (FixUtils.isSet(accountType)) FixUtils.putFixTag( out, FixTags.ACCOUNTTYPE_INT, accountType);
		if (FixUtils.isSet(quotReqLegsGrp.noLegs)) quotReqLegsGrp.encode( out );
		if (FixUtils.isSet(quotQualGrp.noQuoteQualifiers)) quotQualGrp.encode( out );
		if (FixUtils.isSet(quotePriceType)) FixUtils.putFixTag( out, FixTags.QUOTEPRICETYPE_INT, quotePriceType);
		if (FixUtils.isSet(ordType)) FixUtils.putFixTag( out, FixTags.ORDTYPE_INT, ordType );
		if (FixUtils.isSet(validUntilTime)) FixUtils.putFixTag( out, FixTags.VALIDUNTILTIME_INT, validUntilTime);
		if (FixUtils.isSet(expireTime)) FixUtils.putFixTag( out, FixTags.EXPIRETIME_INT, expireTime);
		if (FixUtils.isSet(transactTime)) FixUtils.putFixTag( out, FixTags.TRANSACTTIME_INT, transactTime);
		if (FixUtils.isSet(spreadOrBenchmarkCurveData.spread)) spreadOrBenchmarkCurveData.encode( out );
		if (FixUtils.isSet(priceType)) FixUtils.putFixTag( out, FixTags.PRICETYPE_INT, priceType);
		if (FixUtils.isSet(price)) FixUtils.putFixFloatTag( out, FixTags.PRICE_INT, price);
		if (FixUtils.isSet(price2)) FixUtils.putFixFloatTag( out, FixTags.PRICE2_INT, price2);
		if (FixUtils.isSet(yieldData.yieldType)) yieldData.encode( out );
		if (FixUtils.isSet(parties.noPartyIDs)) parties.encode( out );
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

			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(financingDetails.agreementDesc)) s += financingDetails.toString();
			if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) s += undInstrmtGrp.toString();
			if (FixUtils.isSet(prevClosePx)) s += "PrevClosePx(140)=" + String.valueOf(prevClosePx) + sep;
			if (FixUtils.isSet(quoteRequestType)) s += "QuoteRequestType(303)=" + String.valueOf(quoteRequestType) + sep;
			if (FixUtils.isSet(quoteType)) s += "QuoteType(537)=" + String.valueOf(quoteType) + sep;
			if (FixUtils.isSet(tradingSessionID)) s += "TradingSessionID(336)=" + new String(tradingSessionID) + sep;
			if (FixUtils.isSet(tradingSessionSubID)) s += "TradingSessionSubID(625)=" + new String(tradingSessionSubID) + sep;
			if (FixUtils.isSet(tradeOriginationDate)) s += "TradeOriginationDate(229)=" + new String(tradeOriginationDate) + sep;
			if (FixUtils.isSet(side)) s += "Side(54)=" + String.valueOf(side) + sep;
			if (FixUtils.isSet(qtyType)) s += "QtyType(854)=" + String.valueOf(qtyType) + sep;
			if (FixUtils.isSet(minQty)) s += "MinQty(110)=" + String.valueOf(minQty) + sep;
			if (FixUtils.isSet(orderQtyData.orderQty)) s += orderQtyData.toString();
			if (FixUtils.isSet(settlType)) s += "SettlType(63)=" + new String(settlType) + sep;
			if (FixUtils.isSet(settlDate)) s += "SettlDate(64)=" + new String(settlDate) + sep;
			if (FixUtils.isSet(settlDate2)) s += "SettlDate2(193)=" + new String(settlDate2) + sep;
			if (FixUtils.isSet(orderQty2)) s += "OrderQty2(192)=" + String.valueOf(orderQty2) + sep;
			if (FixUtils.isSet(currency)) s += "Currency(15)=" + new String(currency) + sep;
			if (FixUtils.isSet(settlCurrency)) s += "SettlCurrency(120)=" + new String(settlCurrency) + sep;
			if (FixUtils.isSet(rateSource.noRateSources)) s += rateSource.toString();
			if (FixUtils.isSet(stipulations.noStipulations)) s += stipulations.toString();
			if (FixUtils.isSet(account)) s += "Account(1)=" + new String(account) + sep;
			if (FixUtils.isSet(acctIDSource)) s += "AcctIDSource(660)=" + String.valueOf(acctIDSource) + sep;
			if (FixUtils.isSet(accountType)) s += "AccountType(581)=" + String.valueOf(accountType) + sep;
			if (FixUtils.isSet(quotReqLegsGrp.noLegs)) s += quotReqLegsGrp.toString();
			if (FixUtils.isSet(quotQualGrp.noQuoteQualifiers)) s += quotQualGrp.toString();
			if (FixUtils.isSet(quotePriceType)) s += "QuotePriceType(692)=" + String.valueOf(quotePriceType) + sep;
			if (FixUtils.isSet(ordType)) s += "OrdType(40)=" + String.valueOf(ordType) + sep;
			if (FixUtils.isSet(validUntilTime)) s += "ValidUntilTime(62)=" + new String(validUntilTime) + sep;
			if (FixUtils.isSet(expireTime)) s += "ExpireTime(126)=" + new String(expireTime) + sep;
			if (FixUtils.isSet(transactTime)) s += "TransactTime(60)=" + new String(transactTime) + sep;
			if (FixUtils.isSet(spreadOrBenchmarkCurveData.spread)) s += spreadOrBenchmarkCurveData.toString();
			if (FixUtils.isSet(priceType)) s += "PriceType(423)=" + String.valueOf(priceType) + sep;
			if (FixUtils.isSet(price)) s += "Price(44)=" + String.valueOf(price) + sep;
			if (FixUtils.isSet(price2)) s += "Price2(640)=" + String.valueOf(price2) + sep;
			if (FixUtils.isSet(yieldData.yieldType)) s += yieldData.toString();
			if (FixUtils.isSet(parties.noPartyIDs)) s += parties.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof QuotReqGrp)) return false;

			QuotReqGrp msg = (QuotReqGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!financingDetails.equals(msg.financingDetails)) return false;

		if (!undInstrmtGrp.equals(msg.undInstrmtGrp)) return false;

		if (!( prevClosePx==msg.prevClosePx)) return false;

		if (!( quoteRequestType==msg.quoteRequestType)) return false;

		if (!( quoteType==msg.quoteType)) return false;

		if (!Utils.equals( tradingSessionID, msg.tradingSessionID)) return false;

		if (!Utils.equals( tradingSessionSubID, msg.tradingSessionSubID)) return false;

		if (!( side==msg.side)) return false;

		if (!( qtyType==msg.qtyType)) return false;

		if (!( minQty==msg.minQty)) return false;

		if (!orderQtyData.equals(msg.orderQtyData)) return false;

		if (!Utils.equals( settlType, msg.settlType)) return false;

		if (!( orderQty2==msg.orderQty2)) return false;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!Utils.equals( settlCurrency, msg.settlCurrency)) return false;

		if (!rateSource.equals(msg.rateSource)) return false;

		if (!stipulations.equals(msg.stipulations)) return false;

		if (!Utils.equals( account, msg.account)) return false;

		if (!( acctIDSource==msg.acctIDSource)) return false;

		if (!( accountType==msg.accountType)) return false;

		if (!quotReqLegsGrp.equals(msg.quotReqLegsGrp)) return false;

		if (!quotQualGrp.equals(msg.quotQualGrp)) return false;

		if (!( quotePriceType==msg.quotePriceType)) return false;

		if (!( ordType==msg.ordType)) return false;

		if (!spreadOrBenchmarkCurveData.equals(msg.spreadOrBenchmarkCurveData)) return false;

		if (!( priceType==msg.priceType)) return false;

		if (!( price==msg.price)) return false;

		if (!( price2==msg.price2)) return false;

		if (!yieldData.equals(msg.yieldData)) return false;

		if (!parties.equals(msg.parties)) return false;

		return true;
	}
}
}
