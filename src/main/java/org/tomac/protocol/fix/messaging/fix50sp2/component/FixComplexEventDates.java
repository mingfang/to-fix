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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixComplexEventTimes;

public class FixComplexEventDates
{

	public int noComplexEventDates;
	public ComplexEventDates[] group;

	public void getAll(int noComplexEventDates, ByteBuffer buf) throws FixSessionException {
		this.noComplexEventDates = noComplexEventDates;

		if (noComplexEventDates < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noComplexEventDates ).getBytes(), FixTags.NOCOMPLEXEVENTDATES_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noComplexEventDates) {
			group = new ComplexEventDates[noComplexEventDates];

			for ( int i = 0; i < noComplexEventDates; i++ ) group[i] = new ComplexEventDates();
	}

		for ( int i = 0; i < noComplexEventDates; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noComplexEventDates; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noComplexEventDates; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noComplexEventDates; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noComplexEventDates; i++)
			s += group[i].toString();
		return s;
	}

public class ComplexEventDates implements FixComponent
{

	public byte[] complexEventStartDate;
	public byte[] complexEventEndDate;
	public FixComplexEventTimes complexEventTimes;

	public ComplexEventDates() {
		super();

		complexEventStartDate = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		complexEventEndDate = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		complexEventTimes = new FixComplexEventTimes();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( complexEventStartDate, (byte)0 );
		Utils.fill( complexEventEndDate, (byte)0 );
		complexEventTimes.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.COMPLEXEVENTSTARTDATE_INT) {
				complexEventStartDate = FixUtils.getTagStringValue(value, complexEventStartDate);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.COMPLEXEVENTENDDATE_INT) {
				complexEventEndDate = FixUtils.getTagStringValue(value, complexEventEndDate);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOCOMPLEXEVENTTIMES_INT) {
				complexEventTimes.getAll(FixTags.NOCOMPLEXEVENTTIMES_INT, buf);
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
		if (FixUtils.isSet(complexEventStartDate)) return true;
		if (FixUtils.isSet(complexEventEndDate)) return true;
		if (FixUtils.isSet(complexEventTimes.noComplexEventTimes)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(complexEventStartDate)) FixUtils.putFixTag( out, FixTags.COMPLEXEVENTSTARTDATE_INT, complexEventStartDate);
		if (FixUtils.isSet(complexEventEndDate)) FixUtils.putFixTag( out, FixTags.COMPLEXEVENTENDDATE_INT, complexEventEndDate);
		if (FixUtils.isSet(complexEventTimes.noComplexEventTimes)) complexEventTimes.encode( out );
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

			if (FixUtils.isSet(complexEventStartDate)) s += "ComplexEventStartDate(1492)=" + new String(complexEventStartDate) + sep;
			if (FixUtils.isSet(complexEventEndDate)) s += "ComplexEventEndDate(1493)=" + new String(complexEventEndDate) + sep;
			if (FixUtils.isSet(complexEventTimes.noComplexEventTimes)) s += complexEventTimes.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof ComplexEventDates)) return false;

			ComplexEventDates msg = (ComplexEventDates) o;

		if ( ! super.equals(msg) ) return false;

		if (!complexEventTimes.equals(msg.complexEventTimes)) return false;

		return true;
	}
}
}
