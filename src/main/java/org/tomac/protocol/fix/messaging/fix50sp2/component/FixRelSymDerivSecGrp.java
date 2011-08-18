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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixSecondaryPriceLimits;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrumentExtension;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrmtLegGrp;

public class FixRelSymDerivSecGrp
{

	public int noRelatedSym;
	public RelSymDerivSecGrp[] group;

	public void getAll(int noRelatedSym, ByteBuffer buf) throws FixSessionException {
		this.noRelatedSym = noRelatedSym;

		if (noRelatedSym < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noRelatedSym) 
			group = new RelSymDerivSecGrp[noRelatedSym];

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

public class RelSymDerivSecGrp implements FixComponent
{

	public FixInstrument instrument;
	public FixSecondaryPriceLimits secondaryPriceLimits;
	public byte[] currency;
	public byte[] corporateAction;
	public FixInstrumentExtension instrumentExtension;
	public FixInstrmtLegGrp instrmtLegGrp;
	public byte[] relSymTransactTime;
	public byte[] text;
	public long encodedTextLen = 0;
	public byte[] encodedText;

	public RelSymDerivSecGrp() {
		super();

		instrument = new FixInstrument();
		secondaryPriceLimits = new FixSecondaryPriceLimits();
		currency = new byte[FixUtils.CURRENCY_LENGTH];
		corporateAction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		instrumentExtension = new FixInstrumentExtension();
		instrmtLegGrp = new FixInstrmtLegGrp();
		relSymTransactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( currency, (byte)0 );
		Utils.fill( corporateAction, (byte)0 );
		Utils.fill( relSymTransactTime, (byte)0 );
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		instrument.clear();
		secondaryPriceLimits.clear();
		instrumentExtension.clear();
		instrmtLegGrp.clear();
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

			if(id == FixTags.SECONDARYPRICELIMITTYPE_INT) {
				secondaryPriceLimits.getAll(FixTags.SECONDARYPRICELIMITTYPE_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CURRENCY_INT) {
				currency = FixUtils.getTagStringValue(value, currency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CORPORATEACTION_INT) {
				corporateAction = FixUtils.getTagStringValue(value, corporateAction);
				if (!FixMessageInfo.CorporateAction.isValid(corporateAction) ) throw new FixSessionException(buf, "Invalid enumerated value(" + corporateAction + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.DELIVERYFORM_INT) {
				instrumentExtension.getAll(FixTags.DELIVERYFORM_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOLEGS_INT) {
				instrmtLegGrp.getAll(FixTags.NOLEGS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RELSYMTRANSACTTIME_INT) {
				relSymTransactTime = FixUtils.getTagStringValue(value, relSymTransactTime);
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

			id = checkRequiredTags();
			if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

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
		if (FixUtils.isSet(instrument.symbol)) return true;
		if (FixUtils.isSet(secondaryPriceLimits.secondaryPriceLimitType)) return true;
		if (FixUtils.isSet(currency)) return true;
		if (FixUtils.isSet(corporateAction)) return true;
		if (FixUtils.isSet(instrumentExtension.deliveryForm)) return true;
		if (FixUtils.isSet(instrmtLegGrp.noLegs)) return true;
		if (FixUtils.isSet(relSymTransactTime)) return true;
		if (FixUtils.isSet(text)) return true;
		if (FixUtils.isSet(encodedTextLen)) return true;
		if (FixUtils.isSet(encodedText)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(secondaryPriceLimits.secondaryPriceLimitType)) secondaryPriceLimits.encode( out );
		if (FixUtils.isSet(currency)) FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		if (FixUtils.isSet(corporateAction)) FixUtils.putFixTag( out, FixTags.CORPORATEACTION_INT, corporateAction, 0, Utils.lastIndexTrim(corporateAction, (byte)0) );
		if (FixUtils.isSet(instrumentExtension.deliveryForm)) instrumentExtension.encode( out );
		if (FixUtils.isSet(instrmtLegGrp.noLegs)) instrmtLegGrp.encode( out );
		if (FixUtils.isSet(relSymTransactTime)) FixUtils.putFixTag( out, FixTags.RELSYMTRANSACTTIME_INT, relSymTransactTime);
		if (FixUtils.isSet(text)) FixUtils.putFixTag( out, FixTags.TEXT_INT, text, 0, Utils.lastIndexTrim(text, (byte)0) );
		if (FixUtils.isSet(encodedTextLen)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXTLEN_INT, encodedTextLen);
		if (FixUtils.isSet(encodedText)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXT_INT, encodedText, 0, Utils.lastIndexTrim(encodedText, (byte)0) );
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
			if (FixUtils.isSet(secondaryPriceLimits.secondaryPriceLimitType)) s += secondaryPriceLimits.toString();
			if (FixUtils.isSet(currency)) s += "Currency(15)=" + new String(currency) + sep;
			if (FixUtils.isSet(corporateAction)) s += "CorporateAction(292)=" + new String(corporateAction) + sep;
			if (FixUtils.isSet(instrumentExtension.deliveryForm)) s += instrumentExtension.toString();
			if (FixUtils.isSet(instrmtLegGrp.noLegs)) s += instrmtLegGrp.toString();
			if (FixUtils.isSet(relSymTransactTime)) s += "RelSymTransactTime(1504)=" + new String(relSymTransactTime) + sep;
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RelSymDerivSecGrp)) return false;

			RelSymDerivSecGrp msg = (RelSymDerivSecGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!secondaryPriceLimits.equals(msg.secondaryPriceLimits)) return false;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!Utils.equals( corporateAction, msg.corporateAction)) return false;

		if (!instrumentExtension.equals(msg.instrumentExtension)) return false;

		if (!instrmtLegGrp.equals(msg.instrmtLegGrp)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		return true;
	}
}
}
