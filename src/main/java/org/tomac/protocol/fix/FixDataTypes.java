package org.tomac.protocol.fix;

public class FixDataTypes {

	public static final int	UNKNOWN				= 0;
	public static final int	INT					= 1;
	public static final int	LENGTH				= 11;
	public static final int	TAGNUM				= 12;
	public static final int	SEQNUM				= 13;
	public static final int	NUMINGROUP			= 14;
	public static final int	DAYOFMOUNTH			= 15;
	public static final int	FLOAT				= 2;
	public static final int	PRICE				= 21;
	public static final int	QTY					= 22;
	public static final int	PRICEOFFSET			= 23;
	public static final int	AMT					= 24;
	public static final int	PERCENTAGE			= 25;
	public static final int	CHAR				= 3;
	public static final int	BOOLEAN				= 31;
	public static final int	STRING				= 4;
	public static final int	MULTIPLECHARVALUE	= 41;
	public static final int	MULTIPLESTRINGVALUE	= 42;
	public static final int	COUNTRY				= 43;
	public static final int	CURRENCY			= 44;
	public static final int	EXCHANGE			= 45;
	public static final int	MONTHYEAR			= 46;
	public static final int	UTCTIMESTAMP		= 47;
	public static final int	UTCTIMEONLY			= 48;
	public static final int	UTCDATEONLY			= 49;
	public static final int	LOCALMKTDATE		= 410;
	public static final int	TZTIMEONLY			= 411;
	public static final int	TZTIMESTAMP			= 412;
	public static final int	DATA				= 413;
	public static final int	XMLDATA				= 414;
	public static final int	LANGUAGE			= 415;

	public static final int toInt(final String type) {
		if (type.equals("INT"))
			return INT;
		if (type.equals("LENGTH"))
			return LENGTH;
		if (type.equals("TAGNUM"))
			return TAGNUM;
		if (type.equals("SEQNUM"))
			return SEQNUM;
		if (type.equals("NUMINGROUP"))
			return NUMINGROUP;
		if (type.equals("NUMINGRP"))
			return NUMINGROUP; // <field name="NoRiskSecurityAltID" number="1540" type="NUMINGRP"/> fixprotocol.org bug
		if (type.equals("DAYOFMOUNTH"))
			return DAYOFMOUNTH;
		if (type.equals("FLOAT"))
			return FLOAT;
		if (type.equals("PRICE"))
			return PRICE;
		if (type.equals("QTY"))
			return QTY;
		if (type.equals("PRICEOFFSET"))
			return PRICEOFFSET;
		if (type.equals("AMT"))
			return AMT;
		if (type.equals("PERCENTAGE"))
			return PERCENTAGE;
		if (type.equals("CHAR"))
			return CHAR;
		if (type.equals("BOOLEAN"))
			return BOOLEAN;
		if (type.equals("STRING"))
			return STRING;
		if (type.equals("MULTIPLECHARVALUE"))
			return MULTIPLECHARVALUE;
		if (type.equals("MULTIPLESTRINGVALUE"))
			return MULTIPLESTRINGVALUE;
		if (type.equals("COUNTRY"))
			return COUNTRY;
		if (type.equals("CURRENCY"))
			return CURRENCY;
		if (type.equals("EXCHANGE"))
			return EXCHANGE;
		if (type.equals("MONTHYEAR"))
			return MONTHYEAR;
		if (type.equals("UTCTIMESTAMP"))
			return UTCTIMESTAMP;
		if (type.equals("UTCTIMEONLY"))
			return UTCTIMEONLY;
		if (type.equals("UTCDATEONLY"))
			return UTCDATEONLY;
		if (type.equals("LOCALMKTDATE"))
			return LOCALMKTDATE;
		if (type.equals("TZTIMEONLY"))
			return TZTIMEONLY;
		if (type.equals("TZTIMESTAMP"))
			return TZTIMESTAMP;
		if (type.equals("DATA"))
			return DATA;
		if (type.equals("XMLDATA"))
			return XMLDATA;
		if (type.equals("LANGUAGE"))
			return LANGUAGE;
		return UNKNOWN;
	}

}
