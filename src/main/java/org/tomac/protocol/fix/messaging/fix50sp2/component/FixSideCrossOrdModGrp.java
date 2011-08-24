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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixParties;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixPreAllocGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixOrderQtyData;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixCommissionData;

public class FixSideCrossOrdModGrp
{

	public int noSides;
	public SideCrossOrdModGrp[] group;

	public void getAll(int noSides, ByteBuffer buf) throws FixSessionException {
		this.noSides = noSides;

		if (noSides < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noSides ).getBytes(), FixTags.NOSIDES_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noSides) {
			group = new SideCrossOrdModGrp[noSides];

			for ( int i = 0; i < noSides; i++ ) group[i] = new SideCrossOrdModGrp();
	}

		for ( int i = 0; i < noSides; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noSides; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noSides; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noSides; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noSides; i++)
			s += group[i].toString();
		return s;
	}

public class SideCrossOrdModGrp implements FixComponent
{

	public byte side = (byte)' ';
	public byte[] origClOrdID;
	public byte[] clOrdID;
	public byte[] secondaryClOrdID;
	public byte[] clOrdLinkID;
	public FixParties parties;
	public byte[] tradeOriginationDate;
	public byte[] tradeDate;
	public byte[] account;
	public long acctIDSource = 0;
	public long accountType = 0;
	public byte dayBookingInst = (byte)' ';
	public byte bookingUnit = (byte)' ';
	public byte preallocMethod = (byte)' ';
	public byte[] allocID;
	public FixPreAllocGrp preAllocGrp;
	public long qtyType = 0;
	public FixOrderQtyData orderQtyData;
	public FixCommissionData commissionData;
	public byte orderCapacity = (byte)' ';
	public byte[] orderRestrictions;
	public boolean preTradeAnonymity = false;
	public long custOrderCapacity = 0;
	public boolean forexReq = false;
	public byte[] settlCurrency;
	public long bookingType = 0;
	public byte[] text;
	public long encodedTextLen = 0;
	public byte[] encodedText;
	public byte positionEffect = (byte)' ';
	public long coveredOrUncovered = 0;
	public byte cashMargin = (byte)' ';
	public byte[] clearingFeeIndicator;
	public boolean solicitedFlag = false;
	public byte[] sideComplianceID;
	public byte[] sideTimeInForce;

	public SideCrossOrdModGrp() {
		super();

		origClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		parties = new FixParties();
		tradeOriginationDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		allocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		preAllocGrp = new FixPreAllocGrp();
		orderQtyData = new FixOrderQtyData();
		commissionData = new FixCommissionData();
		orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		clearingFeeIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		sideComplianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		sideTimeInForce = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		side = Byte.MAX_VALUE;		
		Utils.fill( origClOrdID, (byte)0 );
		Utils.fill( clOrdID, (byte)0 );
		Utils.fill( secondaryClOrdID, (byte)0 );
		Utils.fill( clOrdLinkID, (byte)0 );
		Utils.fill( tradeOriginationDate, (byte)0 );
		Utils.fill( tradeDate, (byte)0 );
		Utils.fill( account, (byte)0 );
		acctIDSource = Long.MAX_VALUE;		
		accountType = Long.MAX_VALUE;		
		dayBookingInst = Byte.MAX_VALUE;		
		bookingUnit = Byte.MAX_VALUE;		
		preallocMethod = Byte.MAX_VALUE;		
		Utils.fill( allocID, (byte)0 );
		qtyType = Long.MAX_VALUE;		
		orderCapacity = Byte.MAX_VALUE;		
		Utils.fill( orderRestrictions, (byte)0 );
		preTradeAnonymity = false;		
		custOrderCapacity = Long.MAX_VALUE;		
		forexReq = false;		
		Utils.fill( settlCurrency, (byte)0 );
		bookingType = Long.MAX_VALUE;		
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		positionEffect = Byte.MAX_VALUE;		
		coveredOrUncovered = Long.MAX_VALUE;		
		cashMargin = Byte.MAX_VALUE;		
		Utils.fill( clearingFeeIndicator, (byte)0 );
		solicitedFlag = false;		
		Utils.fill( sideComplianceID, (byte)0 );
		Utils.fill( sideTimeInForce, (byte)0 );
		parties.clear();
		preAllocGrp.clear();
		orderQtyData.clear();
		commissionData.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.SIDE_INT) {
				side = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.Side.isValid(side) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + side + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORIGCLORDID_INT) {
				origClOrdID = FixUtils.getTagStringValue(value, origClOrdID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CLORDID_INT) {
				clOrdID = FixUtils.getTagStringValue(value, clOrdID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SECONDARYCLORDID_INT) {
				secondaryClOrdID = FixUtils.getTagStringValue(value, secondaryClOrdID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CLORDLINKID_INT) {
				clOrdLinkID = FixUtils.getTagStringValue(value, clOrdLinkID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOPARTYIDS_INT) {
				parties.getAll(FixTags.NOPARTYIDS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADEORIGINATIONDATE_INT) {
				tradeOriginationDate = FixUtils.getTagStringValue(value, tradeOriginationDate);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADEDATE_INT) {
				tradeDate = FixUtils.getTagStringValue(value, tradeDate);
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

			if(id == FixTags.DAYBOOKINGINST_INT) {
				dayBookingInst = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.DayBookingInst.isValid(dayBookingInst) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + dayBookingInst + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.BOOKINGUNIT_INT) {
				bookingUnit = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.BookingUnit.isValid(bookingUnit) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + bookingUnit + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PREALLOCMETHOD_INT) {
				preallocMethod = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.PreallocMethod.isValid(preallocMethod) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + preallocMethod + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCID_INT) {
				allocID = FixUtils.getTagStringValue(value, allocID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOALLOCS_INT) {
				preAllocGrp.getAll(FixTags.NOALLOCS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.QTYTYPE_INT) {
				qtyType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.QtyType.isValid(qtyType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + qtyType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORDERQTY_INT) {
				orderQtyData.getAll(FixTags.ORDERQTY_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.COMMISSION_INT) {
				commissionData.getAll(FixTags.COMMISSION_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORDERCAPACITY_INT) {
				orderCapacity = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.OrderCapacity.isValid(orderCapacity) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + orderCapacity + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ORDERRESTRICTIONS_INT) {
				orderRestrictions = FixUtils.getTagStringValue(value, orderRestrictions);
				if (!FixMessageInfo.OrderRestrictions.isValid(orderRestrictions) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + orderRestrictions + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PRETRADEANONYMITY_INT) {
				preTradeAnonymity = FixUtils.getTagBooleanValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CUSTORDERCAPACITY_INT) {
				custOrderCapacity = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.CustOrderCapacity.isValid(custOrderCapacity) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + custOrderCapacity + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.FOREXREQ_INT) {
				forexReq = FixUtils.getTagBooleanValue( value );
				if (!FixMessageInfo.ForexReq.isValid(forexReq) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + forexReq + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLCURRENCY_INT) {
				settlCurrency = FixUtils.getTagStringValue(value, settlCurrency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.BOOKINGTYPE_INT) {
				bookingType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.BookingType.isValid(bookingType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + bookingType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TEXT_INT) {
				text = FixUtils.getTagStringValue(value, text);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ENCODEDTEXTLEN_INT) {
				encodedTextLen = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ENCODEDTEXT_INT) {
				encodedText = FixUtils.getTagStringValue(value, encodedText);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.POSITIONEFFECT_INT) {
				positionEffect = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.PositionEffect.isValid(positionEffect) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + positionEffect + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.COVEREDORUNCOVERED_INT) {
				coveredOrUncovered = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.CoveredOrUncovered.isValid(coveredOrUncovered) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + coveredOrUncovered + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CASHMARGIN_INT) {
				cashMargin = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.CashMargin.isValid(cashMargin) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + cashMargin + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CLEARINGFEEINDICATOR_INT) {
				clearingFeeIndicator = FixUtils.getTagStringValue(value, clearingFeeIndicator);
				if (!FixMessageInfo.ClearingFeeIndicator.isValid(clearingFeeIndicator) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + clearingFeeIndicator + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SOLICITEDFLAG_INT) {
				solicitedFlag = FixUtils.getTagBooleanValue( value );
				if (!FixMessageInfo.SolicitedFlag.isValid(solicitedFlag) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + solicitedFlag + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SIDECOMPLIANCEID_INT) {
				sideComplianceID = FixUtils.getTagStringValue(value, sideComplianceID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SIDETIMEINFORCE_INT) {
				sideTimeInForce = FixUtils.getTagStringValue(value, sideTimeInForce);
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

		if (! FixUtils.isSet(side) ) return FixTags.SIDE_INT;
		if (! FixUtils.isSet(clOrdID) ) return FixTags.CLORDID_INT;
		if (! orderQtyData.isSet() ) return FixTags.ORDERQTY_INT;
		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(origClOrdID)) return true;
		if (FixUtils.isSet(secondaryClOrdID)) return true;
		if (FixUtils.isSet(clOrdLinkID)) return true;
		if (FixUtils.isSet(parties.noPartyIDs)) return true;
		if (FixUtils.isSet(tradeOriginationDate)) return true;
		if (FixUtils.isSet(tradeDate)) return true;
		if (FixUtils.isSet(account)) return true;
		if (FixUtils.isSet(acctIDSource)) return true;
		if (FixUtils.isSet(accountType)) return true;
		if (FixUtils.isSet(dayBookingInst)) return true;
		if (FixUtils.isSet(bookingUnit)) return true;
		if (FixUtils.isSet(preallocMethod)) return true;
		if (FixUtils.isSet(allocID)) return true;
		if (FixUtils.isSet(preAllocGrp.noAllocs)) return true;
		if (FixUtils.isSet(qtyType)) return true;
		if (FixUtils.isSet(orderQtyData.orderQty)) return true;
		if (FixUtils.isSet(commissionData.commission)) return true;
		if (FixUtils.isSet(orderCapacity)) return true;
		if (FixUtils.isSet(orderRestrictions)) return true;
		if (FixUtils.isSet(preTradeAnonymity)) return true;
		if (FixUtils.isSet(custOrderCapacity)) return true;
		if (FixUtils.isSet(forexReq)) return true;
		if (FixUtils.isSet(settlCurrency)) return true;
		if (FixUtils.isSet(bookingType)) return true;
		if (FixUtils.isSet(text)) return true;
		if (FixUtils.isSet(encodedTextLen)) return true;
		if (FixUtils.isSet(encodedText)) return true;
		if (FixUtils.isSet(positionEffect)) return true;
		if (FixUtils.isSet(coveredOrUncovered)) return true;
		if (FixUtils.isSet(cashMargin)) return true;
		if (FixUtils.isSet(clearingFeeIndicator)) return true;
		if (FixUtils.isSet(solicitedFlag)) return true;
		if (FixUtils.isSet(sideComplianceID)) return true;
		if (FixUtils.isSet(sideTimeInForce)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		if (FixUtils.isSet(origClOrdID)) FixUtils.putFixTag( out, FixTags.ORIGCLORDID_INT, origClOrdID, 0, Utils.lastIndexTrim(origClOrdID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		if (FixUtils.isSet(secondaryClOrdID)) FixUtils.putFixTag( out, FixTags.SECONDARYCLORDID_INT, secondaryClOrdID, 0, Utils.lastIndexTrim(secondaryClOrdID, (byte)0) );
		if (FixUtils.isSet(clOrdLinkID)) FixUtils.putFixTag( out, FixTags.CLORDLINKID_INT, clOrdLinkID, 0, Utils.lastIndexTrim(clOrdLinkID, (byte)0) );
		if (FixUtils.isSet(parties.noPartyIDs)) parties.encode( out );
		if (FixUtils.isSet(tradeOriginationDate)) FixUtils.putFixTag( out, FixTags.TRADEORIGINATIONDATE_INT, tradeOriginationDate);
		if (FixUtils.isSet(tradeDate)) FixUtils.putFixTag( out, FixTags.TRADEDATE_INT, tradeDate);
		if (FixUtils.isSet(account)) FixUtils.putFixTag( out, FixTags.ACCOUNT_INT, account, 0, Utils.lastIndexTrim(account, (byte)0) );
		if (FixUtils.isSet(acctIDSource)) FixUtils.putFixTag( out, FixTags.ACCTIDSOURCE_INT, acctIDSource);
		if (FixUtils.isSet(accountType)) FixUtils.putFixTag( out, FixTags.ACCOUNTTYPE_INT, accountType);
		if (FixUtils.isSet(dayBookingInst)) FixUtils.putFixTag( out, FixTags.DAYBOOKINGINST_INT, dayBookingInst );
		if (FixUtils.isSet(bookingUnit)) FixUtils.putFixTag( out, FixTags.BOOKINGUNIT_INT, bookingUnit );
		if (FixUtils.isSet(preallocMethod)) FixUtils.putFixTag( out, FixTags.PREALLOCMETHOD_INT, preallocMethod );
		if (FixUtils.isSet(allocID)) FixUtils.putFixTag( out, FixTags.ALLOCID_INT, allocID, 0, Utils.lastIndexTrim(allocID, (byte)0) );
		if (FixUtils.isSet(preAllocGrp.noAllocs)) preAllocGrp.encode( out );
		if (FixUtils.isSet(qtyType)) FixUtils.putFixTag( out, FixTags.QTYTYPE_INT, qtyType);
		if (FixUtils.isSet(orderQtyData.orderQty)) orderQtyData.encode( out );
		if (FixUtils.isSet(commissionData.commission)) commissionData.encode( out );
		if (FixUtils.isSet(orderCapacity)) FixUtils.putFixTag( out, FixTags.ORDERCAPACITY_INT, orderCapacity );
		if (FixUtils.isSet(orderRestrictions)) FixUtils.putFixTag( out, FixTags.ORDERRESTRICTIONS_INT, orderRestrictions, 0, Utils.lastIndexTrim(orderRestrictions, (byte)0) );
		if (FixUtils.isSet(preTradeAnonymity)) FixUtils.putFixTag( out, FixTags.PRETRADEANONYMITY_INT, preTradeAnonymity?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(custOrderCapacity)) FixUtils.putFixTag( out, FixTags.CUSTORDERCAPACITY_INT, custOrderCapacity);
		if (FixUtils.isSet(forexReq)) FixUtils.putFixTag( out, FixTags.FOREXREQ_INT, forexReq?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(settlCurrency)) FixUtils.putFixTag( out, FixTags.SETTLCURRENCY_INT, settlCurrency, 0, Utils.lastIndexTrim(settlCurrency, (byte)0) );
		if (FixUtils.isSet(bookingType)) FixUtils.putFixTag( out, FixTags.BOOKINGTYPE_INT, bookingType);
		if (FixUtils.isSet(text)) FixUtils.putFixTag( out, FixTags.TEXT_INT, text, 0, Utils.lastIndexTrim(text, (byte)0) );
		if (FixUtils.isSet(encodedTextLen)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXTLEN_INT, encodedTextLen);
		if (FixUtils.isSet(encodedText)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXT_INT, encodedText, 0, Utils.lastIndexTrim(encodedText, (byte)0) );
		if (FixUtils.isSet(positionEffect)) FixUtils.putFixTag( out, FixTags.POSITIONEFFECT_INT, positionEffect );
		if (FixUtils.isSet(coveredOrUncovered)) FixUtils.putFixTag( out, FixTags.COVEREDORUNCOVERED_INT, coveredOrUncovered);
		if (FixUtils.isSet(cashMargin)) FixUtils.putFixTag( out, FixTags.CASHMARGIN_INT, cashMargin );
		if (FixUtils.isSet(clearingFeeIndicator)) FixUtils.putFixTag( out, FixTags.CLEARINGFEEINDICATOR_INT, clearingFeeIndicator, 0, Utils.lastIndexTrim(clearingFeeIndicator, (byte)0) );
		if (FixUtils.isSet(solicitedFlag)) FixUtils.putFixTag( out, FixTags.SOLICITEDFLAG_INT, solicitedFlag?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(sideComplianceID)) FixUtils.putFixTag( out, FixTags.SIDECOMPLIANCEID_INT, sideComplianceID, 0, Utils.lastIndexTrim(sideComplianceID, (byte)0) );
		if (FixUtils.isSet(sideTimeInForce)) FixUtils.putFixTag( out, FixTags.SIDETIMEINFORCE_INT, sideTimeInForce);
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

			 s += "Side(54)=" + String.valueOf(side) + sep;
			if (FixUtils.isSet(origClOrdID)) s += "OrigClOrdID(41)=" + new String(origClOrdID) + sep;
			 s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			if (FixUtils.isSet(secondaryClOrdID)) s += "SecondaryClOrdID(526)=" + new String(secondaryClOrdID) + sep;
			if (FixUtils.isSet(clOrdLinkID)) s += "ClOrdLinkID(583)=" + new String(clOrdLinkID) + sep;
			if (FixUtils.isSet(parties.noPartyIDs)) s += parties.toString();
			if (FixUtils.isSet(tradeOriginationDate)) s += "TradeOriginationDate(229)=" + new String(tradeOriginationDate) + sep;
			if (FixUtils.isSet(tradeDate)) s += "TradeDate(75)=" + new String(tradeDate) + sep;
			if (FixUtils.isSet(account)) s += "Account(1)=" + new String(account) + sep;
			if (FixUtils.isSet(acctIDSource)) s += "AcctIDSource(660)=" + String.valueOf(acctIDSource) + sep;
			if (FixUtils.isSet(accountType)) s += "AccountType(581)=" + String.valueOf(accountType) + sep;
			if (FixUtils.isSet(dayBookingInst)) s += "DayBookingInst(589)=" + String.valueOf(dayBookingInst) + sep;
			if (FixUtils.isSet(bookingUnit)) s += "BookingUnit(590)=" + String.valueOf(bookingUnit) + sep;
			if (FixUtils.isSet(preallocMethod)) s += "PreallocMethod(591)=" + String.valueOf(preallocMethod) + sep;
			if (FixUtils.isSet(allocID)) s += "AllocID(70)=" + new String(allocID) + sep;
			if (FixUtils.isSet(preAllocGrp.noAllocs)) s += preAllocGrp.toString();
			if (FixUtils.isSet(qtyType)) s += "QtyType(854)=" + String.valueOf(qtyType) + sep;
			if (FixUtils.isSet(orderQtyData.orderQty)) s += orderQtyData.toString();
			if (FixUtils.isSet(commissionData.commission)) s += commissionData.toString();
			if (FixUtils.isSet(orderCapacity)) s += "OrderCapacity(528)=" + String.valueOf(orderCapacity) + sep;
			if (FixUtils.isSet(orderRestrictions)) s += "OrderRestrictions(529)=" + new String(orderRestrictions) + sep;
			if (FixUtils.isSet(preTradeAnonymity)) s += "PreTradeAnonymity(1091)=" + String.valueOf(preTradeAnonymity) + sep;
			if (FixUtils.isSet(custOrderCapacity)) s += "CustOrderCapacity(582)=" + String.valueOf(custOrderCapacity) + sep;
			if (FixUtils.isSet(forexReq)) s += "ForexReq(121)=" + String.valueOf(forexReq) + sep;
			if (FixUtils.isSet(settlCurrency)) s += "SettlCurrency(120)=" + new String(settlCurrency) + sep;
			if (FixUtils.isSet(bookingType)) s += "BookingType(775)=" + String.valueOf(bookingType) + sep;
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;
			if (FixUtils.isSet(positionEffect)) s += "PositionEffect(77)=" + String.valueOf(positionEffect) + sep;
			if (FixUtils.isSet(coveredOrUncovered)) s += "CoveredOrUncovered(203)=" + String.valueOf(coveredOrUncovered) + sep;
			if (FixUtils.isSet(cashMargin)) s += "CashMargin(544)=" + String.valueOf(cashMargin) + sep;
			if (FixUtils.isSet(clearingFeeIndicator)) s += "ClearingFeeIndicator(635)=" + new String(clearingFeeIndicator) + sep;
			if (FixUtils.isSet(solicitedFlag)) s += "SolicitedFlag(377)=" + String.valueOf(solicitedFlag) + sep;
			if (FixUtils.isSet(sideComplianceID)) s += "SideComplianceID(659)=" + new String(sideComplianceID) + sep;
			if (FixUtils.isSet(sideTimeInForce)) s += "SideTimeInForce(962)=" + new String(sideTimeInForce) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof SideCrossOrdModGrp)) return false;

			SideCrossOrdModGrp msg = (SideCrossOrdModGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( side==msg.side)) return false;

		if (!Utils.equals( origClOrdID, msg.origClOrdID)) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!Utils.equals( secondaryClOrdID, msg.secondaryClOrdID)) return false;

		if (!Utils.equals( clOrdLinkID, msg.clOrdLinkID)) return false;

		if (!parties.equals(msg.parties)) return false;

		if (!Utils.equals( account, msg.account)) return false;

		if (!( acctIDSource==msg.acctIDSource)) return false;

		if (!( accountType==msg.accountType)) return false;

		if (!( dayBookingInst==msg.dayBookingInst)) return false;

		if (!( bookingUnit==msg.bookingUnit)) return false;

		if (!( preallocMethod==msg.preallocMethod)) return false;

		if (!Utils.equals( allocID, msg.allocID)) return false;

		if (!preAllocGrp.equals(msg.preAllocGrp)) return false;

		if (!( qtyType==msg.qtyType)) return false;

		if (!orderQtyData.equals(msg.orderQtyData)) return false;

		if (!commissionData.equals(msg.commissionData)) return false;

		if (!( orderCapacity==msg.orderCapacity)) return false;

		if (!Utils.equals( orderRestrictions, msg.orderRestrictions)) return false;

		if (!( preTradeAnonymity==msg.preTradeAnonymity)) return false;

		if (!( custOrderCapacity==msg.custOrderCapacity)) return false;

		if (!( forexReq==msg.forexReq)) return false;

		if (!Utils.equals( settlCurrency, msg.settlCurrency)) return false;

		if (!( bookingType==msg.bookingType)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		if (!( positionEffect==msg.positionEffect)) return false;

		if (!( coveredOrUncovered==msg.coveredOrUncovered)) return false;

		if (!( cashMargin==msg.cashMargin)) return false;

		if (!Utils.equals( clearingFeeIndicator, msg.clearingFeeIndicator)) return false;

		if (!( solicitedFlag==msg.solicitedFlag)) return false;

		if (!Utils.equals( sideComplianceID, msg.sideComplianceID)) return false;

		return true;
	}
}
}
