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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixPartyDetail;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixRelatedPartyGrp;

public class FixPartyListGrp
{

	public int noPartyList;
	public PartyListGrp[] group;

	public void getAll(int noPartyList, ByteBuffer buf) throws FixSessionException {
		this.noPartyList = noPartyList;

		if (noPartyList < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noPartyList ).getBytes(), FixTags.NOPARTYLIST_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noPartyList) {
			group = new PartyListGrp[noPartyList];

			for ( int i = 0; i < noPartyList; i++ ) group[i] = new PartyListGrp();
	}

		for ( int i = 0; i < noPartyList; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noPartyList; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noPartyList; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noPartyList; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noPartyList; i++)
			s += group[i].toString();
		return s;
	}

public class PartyListGrp implements FixComponent
{

	public FixPartyDetail partyDetail;
	public FixRelatedPartyGrp relatedPartyGrp;

	public PartyListGrp() {
		super();

		partyDetail = new FixPartyDetail();
		relatedPartyGrp = new FixRelatedPartyGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		partyDetail.clear();
		relatedPartyGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.PARTYID_INT) {
				partyDetail.getAll(FixTags.PARTYID_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NORELATEDPARTYIDS_INT) {
				relatedPartyGrp.getAll(FixTags.NORELATEDPARTYIDS_INT, buf);
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
		if (FixUtils.isSet(partyDetail.partyID)) return true;
		if (FixUtils.isSet(relatedPartyGrp.noRelatedPartyIDs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(partyDetail.partyID)) partyDetail.encode( out );
		if (FixUtils.isSet(relatedPartyGrp.noRelatedPartyIDs)) relatedPartyGrp.encode( out );
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

			if (FixUtils.isSet(partyDetail.partyID)) s += partyDetail.toString();
			if (FixUtils.isSet(relatedPartyGrp.noRelatedPartyIDs)) s += relatedPartyGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof PartyListGrp)) return false;

			PartyListGrp msg = (PartyListGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!partyDetail.equals(msg.partyDetail)) return false;

		if (!relatedPartyGrp.equals(msg.relatedPartyGrp)) return false;

		return true;
	}
}
}
