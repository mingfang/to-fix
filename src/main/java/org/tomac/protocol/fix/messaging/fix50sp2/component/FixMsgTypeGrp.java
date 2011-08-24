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

public class FixMsgTypeGrp
{

	public int noMsgTypes;
	public MsgTypeGrp[] group;

	public void getAll(int noMsgTypes, ByteBuffer buf) throws FixSessionException {
		this.noMsgTypes = noMsgTypes;

		if (noMsgTypes < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noMsgTypes ).getBytes(), FixTags.NOMSGTYPES_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noMsgTypes) {
			group = new MsgTypeGrp[noMsgTypes];

			for ( int i = 0; i < noMsgTypes; i++ ) group[i] = new MsgTypeGrp();
	}

		for ( int i = 0; i < noMsgTypes; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noMsgTypes; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noMsgTypes; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noMsgTypes; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noMsgTypes; i++)
			s += group[i].toString();
		return s;
	}

public class MsgTypeGrp implements FixComponent
{

	public byte[] refMsgType;
	public byte msgDirection = (byte)' ';
	public byte[] refApplVerID;
	public byte[] refCstmApplVerID;
	public long refApplExtID = 0;
	public boolean defaultVerIndicator = false;

	public MsgTypeGrp() {
		super();

		refMsgType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		refApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		refCstmApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( refMsgType, (byte)0 );
		msgDirection = Byte.MAX_VALUE;		
		Utils.fill( refApplVerID, (byte)0 );
		Utils.fill( refCstmApplVerID, (byte)0 );
		refApplExtID = Long.MAX_VALUE;		
		defaultVerIndicator = false;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.MSGDIRECTION_INT) {
				msgDirection = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.MsgDirection.isValid(msgDirection) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + msgDirection + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.REFAPPLVERID_INT) {
				refApplVerID = FixUtils.getTagStringValue(value, refApplVerID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.REFCSTMAPPLVERID_INT) {
				refCstmApplVerID = FixUtils.getTagStringValue(value, refCstmApplVerID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.REFAPPLEXTID_INT) {
				refApplExtID = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.DEFAULTVERINDICATOR_INT) {
				defaultVerIndicator = FixUtils.getTagBooleanValue( value );
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
		if (FixUtils.isSet(refMsgType)) return true;
		if (FixUtils.isSet(msgDirection)) return true;
		if (FixUtils.isSet(refApplVerID)) return true;
		if (FixUtils.isSet(refCstmApplVerID)) return true;
		if (FixUtils.isSet(refApplExtID)) return true;
		if (FixUtils.isSet(defaultVerIndicator)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(refMsgType)) FixUtils.putFixTag( out, FixTags.REFMSGTYPE_INT, refMsgType, 0, Utils.lastIndexTrim(refMsgType, (byte)0) );
		if (FixUtils.isSet(msgDirection)) FixUtils.putFixTag( out, FixTags.MSGDIRECTION_INT, msgDirection );
		if (FixUtils.isSet(refApplVerID)) FixUtils.putFixTag( out, FixTags.REFAPPLVERID_INT, refApplVerID, 0, Utils.lastIndexTrim(refApplVerID, (byte)0) );
		if (FixUtils.isSet(refCstmApplVerID)) FixUtils.putFixTag( out, FixTags.REFCSTMAPPLVERID_INT, refCstmApplVerID, 0, Utils.lastIndexTrim(refCstmApplVerID, (byte)0) );
		if (FixUtils.isSet(refApplExtID)) FixUtils.putFixTag( out, FixTags.REFAPPLEXTID_INT, refApplExtID);
		if (FixUtils.isSet(defaultVerIndicator)) FixUtils.putFixTag( out, FixTags.DEFAULTVERINDICATOR_INT, defaultVerIndicator?(byte)'Y':(byte)'N' );
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

			if (FixUtils.isSet(refMsgType)) s += "RefMsgType(372)=" + new String(refMsgType) + sep;
			if (FixUtils.isSet(msgDirection)) s += "MsgDirection(385)=" + String.valueOf(msgDirection) + sep;
			if (FixUtils.isSet(refApplVerID)) s += "RefApplVerID(1130)=" + new String(refApplVerID) + sep;
			if (FixUtils.isSet(refCstmApplVerID)) s += "RefCstmApplVerID(1131)=" + new String(refCstmApplVerID) + sep;
			if (FixUtils.isSet(refApplExtID)) s += "RefApplExtID(1406)=" + String.valueOf(refApplExtID) + sep;
			if (FixUtils.isSet(defaultVerIndicator)) s += "DefaultVerIndicator(1410)=" + String.valueOf(defaultVerIndicator) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof MsgTypeGrp)) return false;

			MsgTypeGrp msg = (MsgTypeGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( refMsgType, msg.refMsgType)) return false;

		if (!( msgDirection==msg.msgDirection)) return false;

		if (!Utils.equals( refApplVerID, msg.refApplVerID)) return false;

		if (!Utils.equals( refCstmApplVerID, msg.refCstmApplVerID)) return false;

		if (!( refApplExtID==msg.refApplExtID)) return false;

		if (!( defaultVerIndicator==msg.defaultVerIndicator)) return false;

		return true;
	}
}
}
