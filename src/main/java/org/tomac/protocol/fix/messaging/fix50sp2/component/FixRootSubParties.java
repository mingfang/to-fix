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

public class FixRootSubParties
{

	public int noRootPartySubIDs;
	public RootSubParties[] group;

	public void getAll(int noRootPartySubIDs, ByteBuffer buf) throws FixSessionException {
		this.noRootPartySubIDs = noRootPartySubIDs;

		if (noRootPartySubIDs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noRootPartySubIDs) 
			group = new RootSubParties[noRootPartySubIDs];

		for ( int i = 0; i < noRootPartySubIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRootPartySubIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRootPartySubIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRootPartySubIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRootPartySubIDs; i++)
			s += group[i].toString();
		return s;
	}

public class RootSubParties implements FixComponent
{

	public byte[] rootPartySubID;
	public long rootPartySubIDType = 0;

	public RootSubParties() {
		super();

		rootPartySubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( rootPartySubID, (byte)0 );
		rootPartySubIDType = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.ROOTPARTYSUBID_INT) {
				rootPartySubID = FixUtils.getTagStringValue(value, rootPartySubID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ROOTPARTYSUBIDTYPE_INT) {
				rootPartySubIDType = FixUtils.getTagIntValue( value );
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
		if (FixUtils.isSet(rootPartySubID)) return true;
		if (FixUtils.isSet(rootPartySubIDType)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(rootPartySubID)) FixUtils.putFixTag( out, FixTags.ROOTPARTYSUBID_INT, rootPartySubID, 0, Utils.lastIndexTrim(rootPartySubID, (byte)0) );
		if (FixUtils.isSet(rootPartySubIDType)) FixUtils.putFixTag( out, FixTags.ROOTPARTYSUBIDTYPE_INT, rootPartySubIDType);
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

			if (FixUtils.isSet(rootPartySubID)) s += "RootPartySubID(1121)=" + new String(rootPartySubID) + sep;
			if (FixUtils.isSet(rootPartySubIDType)) s += "RootPartySubIDType(1122)=" + String.valueOf(rootPartySubIDType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RootSubParties)) return false;

			RootSubParties msg = (RootSubParties) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( rootPartySubID, msg.rootPartySubID)) return false;

		if (!( rootPartySubIDType==msg.rootPartySubIDType)) return false;

		return true;
	}
}
}
