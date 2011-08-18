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

public class FixStrmAsgnRptInstrmtGrp
{

	public int noRelatedSym;
	public StrmAsgnRptInstrmtGrp[] group;

	public void getAll(int noRelatedSym, ByteBuffer buf) throws FixSessionException {
		this.noRelatedSym = noRelatedSym;

		if (noRelatedSym < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noRelatedSym) 
			group = new StrmAsgnRptInstrmtGrp[noRelatedSym];

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

public class StrmAsgnRptInstrmtGrp implements FixComponent
{

	public FixInstrument instrument;
	public byte[] settlType;
	public long streamAsgnType = 0;
	public byte[] mDStreamID;
	public long streamAsgnRejReason = 0;
	public byte[] text;
	public long encodedTextLen = 0;
	public byte[] encodedText;

	public StrmAsgnRptInstrmtGrp() {
		super();

		instrument = new FixInstrument();
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		mDStreamID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( settlType, (byte)0 );
		streamAsgnType = Long.MAX_VALUE;		
		Utils.fill( mDStreamID, (byte)0 );
		streamAsgnRejReason = Long.MAX_VALUE;		
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		instrument.clear();
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

			if(id == FixTags.SETTLTYPE_INT) {
				settlType = FixUtils.getTagStringValue(value, settlType);
				if (!FixMessageInfo.SettlType.isValid(settlType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + settlType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.STREAMASGNTYPE_INT) {
				streamAsgnType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.StreamAsgnType.isValid(streamAsgnType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + streamAsgnType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MDSTREAMID_INT) {
				mDStreamID = FixUtils.getTagStringValue(value, mDStreamID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.STREAMASGNREJREASON_INT) {
				streamAsgnRejReason = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.StreamAsgnRejReason.isValid(streamAsgnRejReason) ) throw new FixSessionException(buf, "Invalid enumerated value(" + streamAsgnRejReason + ") for tag: " + id );
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
		if (FixUtils.isSet(settlType)) return true;
		if (FixUtils.isSet(streamAsgnType)) return true;
		if (FixUtils.isSet(mDStreamID)) return true;
		if (FixUtils.isSet(streamAsgnRejReason)) return true;
		if (FixUtils.isSet(text)) return true;
		if (FixUtils.isSet(encodedTextLen)) return true;
		if (FixUtils.isSet(encodedText)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(settlType)) FixUtils.putFixTag( out, FixTags.SETTLTYPE_INT, settlType, 0, Utils.lastIndexTrim(settlType, (byte)0) );
		if (FixUtils.isSet(streamAsgnType)) FixUtils.putFixTag( out, FixTags.STREAMASGNTYPE_INT, streamAsgnType);
		if (FixUtils.isSet(mDStreamID)) FixUtils.putFixTag( out, FixTags.MDSTREAMID_INT, mDStreamID, 0, Utils.lastIndexTrim(mDStreamID, (byte)0) );
		if (FixUtils.isSet(streamAsgnRejReason)) FixUtils.putFixTag( out, FixTags.STREAMASGNREJREASON_INT, streamAsgnRejReason);
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
			if (FixUtils.isSet(settlType)) s += "SettlType(63)=" + new String(settlType) + sep;
			if (FixUtils.isSet(streamAsgnType)) s += "StreamAsgnType(1617)=" + String.valueOf(streamAsgnType) + sep;
			if (FixUtils.isSet(mDStreamID)) s += "MDStreamID(1500)=" + new String(mDStreamID) + sep;
			if (FixUtils.isSet(streamAsgnRejReason)) s += "StreamAsgnRejReason(1502)=" + String.valueOf(streamAsgnRejReason) + sep;
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof StrmAsgnRptInstrmtGrp)) return false;

			StrmAsgnRptInstrmtGrp msg = (StrmAsgnRptInstrmtGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!Utils.equals( settlType, msg.settlType)) return false;

		if (!( streamAsgnType==msg.streamAsgnType)) return false;

		if (!Utils.equals( mDStreamID, msg.mDStreamID)) return false;

		if (!( streamAsgnRejReason==msg.streamAsgnRejReason)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		return true;
	}
}
}
