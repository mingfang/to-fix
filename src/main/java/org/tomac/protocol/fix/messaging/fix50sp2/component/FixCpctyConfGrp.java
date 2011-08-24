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

public class FixCpctyConfGrp
{

	public int noCapacities;
	public CpctyConfGrp[] group;

	public void getAll(int noCapacities, ByteBuffer buf) throws FixSessionException {
		this.noCapacities = noCapacities;

		if (noCapacities < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noCapacities ).getBytes(), FixTags.NOCAPACITIES_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noCapacities) {
			group = new CpctyConfGrp[noCapacities];

			for ( int i = 0; i < noCapacities; i++ ) group[i] = new CpctyConfGrp();
	}

		for ( int i = 0; i < noCapacities; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noCapacities; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noCapacities; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noCapacities; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noCapacities; i++)
			s += group[i].toString();
		return s;
	}

public class CpctyConfGrp implements FixComponent
{

	public byte orderCapacity = (byte)' ';
	public byte[] orderRestrictions;
	public long orderCapacityQty = 0;

	public CpctyConfGrp() {
		super();

		orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		orderCapacity = Byte.MAX_VALUE;		
		Utils.fill( orderRestrictions, (byte)0 );
		orderCapacityQty = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

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

			if(id == FixTags.ORDERCAPACITYQTY_INT) {
				orderCapacityQty = FixUtils.getTagFloatValue(value);
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

		if (! FixUtils.isSet(orderCapacity) ) return FixTags.ORDERCAPACITY_INT;
		if (! FixUtils.isSet(orderCapacityQty) ) return FixTags.ORDERCAPACITYQTY_INT;
		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(orderRestrictions)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		FixUtils.putFixTag( out, FixTags.ORDERCAPACITY_INT, orderCapacity );
		if (FixUtils.isSet(orderRestrictions)) FixUtils.putFixTag( out, FixTags.ORDERRESTRICTIONS_INT, orderRestrictions, 0, Utils.lastIndexTrim(orderRestrictions, (byte)0) );
		FixUtils.putFixFloatTag( out, FixTags.ORDERCAPACITYQTY_INT, orderCapacityQty);
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

			 s += "OrderCapacity(528)=" + String.valueOf(orderCapacity) + sep;
			if (FixUtils.isSet(orderRestrictions)) s += "OrderRestrictions(529)=" + new String(orderRestrictions) + sep;
			 s += "OrderCapacityQty(863)=" + String.valueOf(orderCapacityQty) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof CpctyConfGrp)) return false;

			CpctyConfGrp msg = (CpctyConfGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( orderCapacity==msg.orderCapacity)) return false;

		if (!Utils.equals( orderRestrictions, msg.orderRestrictions)) return false;

		if (!( orderCapacityQty==msg.orderCapacityQty)) return false;

		return true;
	}
}
}
