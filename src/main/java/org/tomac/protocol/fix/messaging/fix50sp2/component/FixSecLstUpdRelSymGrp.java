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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrumentExtension;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixFinancingDetails;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixSecLstUpdRelSymsLegGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixSpreadOrBenchmarkCurveData;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUndInstrmtGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixStipulations;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixSecurityTradingRules;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixStrikeRules;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixYieldData;

public class FixSecLstUpdRelSymGrp
{

	public int noRelatedSym;
	public SecLstUpdRelSymGrp[] group;

	public void getAll(int noRelatedSym, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noRelatedSym = noRelatedSym;

		if (noRelatedSym < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noRelatedSym ).getBytes(), FixTags.NORELATEDSYM_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noRelatedSym) {
			group = new SecLstUpdRelSymGrp[noRelatedSym];

			for ( int i = 0; i < noRelatedSym; i++ ) group[i] = new SecLstUpdRelSymGrp();
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
	public boolean equals(Object o) {
		if (! ( o instanceof FixSecLstUpdRelSymGrp)) return false;

		FixSecLstUpdRelSymGrp msg = (FixSecLstUpdRelSymGrp) o;

		for (int i = 0; i<noRelatedSym; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRelatedSym; i++)
			s += group[i].toString();
		return s;
	}

public class SecLstUpdRelSymGrp implements FixComponent
{

	public byte[] currency;
	public byte listUpdateAction = (byte)' ';
	public FixInstrument instrument;
	public FixInstrumentExtension instrumentExtension;
	public FixFinancingDetails financingDetails;
	public FixSecLstUpdRelSymsLegGrp secLstUpdRelSymsLegGrp;
	public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	public FixUndInstrmtGrp undInstrmtGrp;
	public FixStipulations stipulations;
	public FixSecurityTradingRules securityTradingRules;
	public FixStrikeRules strikeRules;
	public byte[] text;
	public long encodedTextLen = 0;
	public byte[] encodedText;
	public byte[] relSymTransactTime;
	public FixYieldData yieldData;

	public SecLstUpdRelSymGrp() {
		super();

		currency = new byte[FixUtils.CURRENCY_LENGTH];
		instrument = new FixInstrument();
		instrumentExtension = new FixInstrumentExtension();
		financingDetails = new FixFinancingDetails();
		secLstUpdRelSymsLegGrp = new FixSecLstUpdRelSymsLegGrp();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		undInstrmtGrp = new FixUndInstrmtGrp();
		stipulations = new FixStipulations();
		securityTradingRules = new FixSecurityTradingRules();
		strikeRules = new FixStrikeRules();
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		relSymTransactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		yieldData = new FixYieldData();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( currency, (byte)0 );
		listUpdateAction = Byte.MAX_VALUE;		
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		Utils.fill( relSymTransactTime, (byte)0 );
		instrument.clear();
		instrumentExtension.clear();
		financingDetails.clear();
		secLstUpdRelSymsLegGrp.clear();
		spreadOrBenchmarkCurveData.clear();
		undInstrmtGrp.clear();
		stipulations.clear();
		securityTradingRules.clear();
		strikeRules.clear();
		yieldData.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.CURRENCY_INT) {
				currency = FixUtils.getTagStringValue(value, currency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LISTUPDATEACTION_INT) {
				listUpdateAction = FixUtils.getTagCharValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SYMBOL_INT) {
				instrument.getAll(FixTags.SYMBOL_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.DELIVERYFORM_INT) {
				instrumentExtension.getAll(FixTags.DELIVERYFORM_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.AGREEMENTDESC_INT) {
				financingDetails.getAll(FixTags.AGREEMENTDESC_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOLEGS_INT) {
				int noLegs;
				noLegs = FixUtils.getTagIntValue( value );
				secLstUpdRelSymsLegGrp.getAll(noLegs, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SPREAD_INT) {
				spreadOrBenchmarkCurveData.getAll(FixTags.SPREAD_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOUNDERLYINGS_INT) {
				int noUnderlyings;
				noUnderlyings = FixUtils.getTagIntValue( value );
				undInstrmtGrp.getAll(noUnderlyings, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOSTIPULATIONS_INT) {
				int noStipulations;
				noStipulations = FixUtils.getTagIntValue( value );
				stipulations.getAll(noStipulations, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.EXPIRATIONCYCLE_INT) {
				securityTradingRules.getAll(FixTags.EXPIRATIONCYCLE_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOSTRIKERULES_INT) {
				int noStrikeRules;
				noStrikeRules = FixUtils.getTagIntValue( value );
				strikeRules.getAll(noStrikeRules, buf);
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

			if(id == FixTags.RELSYMTRANSACTTIME_INT) {
				relSymTransactTime = FixUtils.getTagStringValue(value, relSymTransactTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.YIELDTYPE_INT) {
				yieldData.getAll(FixTags.YIELDTYPE_INT, buf);
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

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(currency)) return true;
		if (FixUtils.isSet(listUpdateAction)) return true;
		if (FixUtils.isSet(instrument.symbol)) return true;
		if (FixUtils.isSet(instrumentExtension.deliveryForm)) return true;
		if (FixUtils.isSet(financingDetails.agreementDesc)) return true;
		if (FixUtils.isSet(secLstUpdRelSymsLegGrp.noLegs)) return true;
		if (FixUtils.isSet(spreadOrBenchmarkCurveData.spread)) return true;
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) return true;
		if (FixUtils.isSet(stipulations.noStipulations)) return true;
		if (FixUtils.isSet(securityTradingRules.baseTradingRules.expirationCycle)) return true;
		if (FixUtils.isSet(strikeRules.noStrikeRules)) return true;
		if (FixUtils.isSet(text)) return true;
		if (FixUtils.isSet(encodedTextLen)) return true;
		if (FixUtils.isSet(encodedText)) return true;
		if (FixUtils.isSet(relSymTransactTime)) return true;
		if (FixUtils.isSet(yieldData.yieldType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(currency)) FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		if (FixUtils.isSet(listUpdateAction)) FixUtils.putFixTag( out, FixTags.LISTUPDATEACTION_INT, listUpdateAction );
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(instrumentExtension.deliveryForm)) instrumentExtension.encode( out );
		if (FixUtils.isSet(financingDetails.agreementDesc)) financingDetails.encode( out );
		if (FixUtils.isSet(secLstUpdRelSymsLegGrp.noLegs)) secLstUpdRelSymsLegGrp.encode( out );
		if (FixUtils.isSet(spreadOrBenchmarkCurveData.spread)) spreadOrBenchmarkCurveData.encode( out );
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) undInstrmtGrp.encode( out );
		if (FixUtils.isSet(stipulations.noStipulations)) stipulations.encode( out );
		if (FixUtils.isSet(securityTradingRules.baseTradingRules.expirationCycle)) securityTradingRules.encode( out );
		if (FixUtils.isSet(strikeRules.noStrikeRules)) strikeRules.encode( out );
		if (FixUtils.isSet(text)) FixUtils.putFixTag( out, FixTags.TEXT_INT, text, 0, Utils.lastIndexTrim(text, (byte)0) );
		if (FixUtils.isSet(encodedTextLen)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXTLEN_INT, encodedTextLen);
		if (FixUtils.isSet(encodedText)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXT_INT, encodedText, 0, Utils.lastIndexTrim(encodedText, (byte)0) );
		if (FixUtils.isSet(relSymTransactTime)) FixUtils.putFixTag( out, FixTags.RELSYMTRANSACTTIME_INT, relSymTransactTime);
		if (FixUtils.isSet(yieldData.yieldType)) yieldData.encode( out );
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

			if (FixUtils.isSet(currency)) s += "Currency(15)=" + new String(currency) + sep;
			if (FixUtils.isSet(listUpdateAction)) s += "ListUpdateAction(1324)=" + String.valueOf(listUpdateAction) + sep;
			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(instrumentExtension.deliveryForm)) s += instrumentExtension.toString();
			if (FixUtils.isSet(financingDetails.agreementDesc)) s += financingDetails.toString();
			if (FixUtils.isSet(secLstUpdRelSymsLegGrp.noLegs)) s += secLstUpdRelSymsLegGrp.toString();
			if (FixUtils.isSet(spreadOrBenchmarkCurveData.spread)) s += spreadOrBenchmarkCurveData.toString();
			if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) s += undInstrmtGrp.toString();
			if (FixUtils.isSet(stipulations.noStipulations)) s += stipulations.toString();
			if (FixUtils.isSet(securityTradingRules.baseTradingRules.expirationCycle)) s += securityTradingRules.toString();
			if (FixUtils.isSet(strikeRules.noStrikeRules)) s += strikeRules.toString();
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;
			if (FixUtils.isSet(relSymTransactTime)) s += "RelSymTransactTime(1504)=" + new String(relSymTransactTime) + sep;
			if (FixUtils.isSet(yieldData.yieldType)) s += yieldData.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof SecLstUpdRelSymGrp)) return false;

			SecLstUpdRelSymGrp msg = (SecLstUpdRelSymGrp) o;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!( listUpdateAction==msg.listUpdateAction)) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!instrumentExtension.equals(msg.instrumentExtension)) return false;

		if (!financingDetails.equals(msg.financingDetails)) return false;

		if (!secLstUpdRelSymsLegGrp.equals(msg.secLstUpdRelSymsLegGrp)) return false;

		if (!spreadOrBenchmarkCurveData.equals(msg.spreadOrBenchmarkCurveData)) return false;

		if (!undInstrmtGrp.equals(msg.undInstrmtGrp)) return false;

		if (!stipulations.equals(msg.stipulations)) return false;

		if (!securityTradingRules.equals(msg.securityTradingRules)) return false;

		if (!strikeRules.equals(msg.strikeRules)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		if (!yieldData.equals(msg.yieldData)) return false;

		return true;
	}
}
}
