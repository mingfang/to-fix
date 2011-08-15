package org.tomac.protocol.fix;

import java.nio.ByteBuffer;

import org.tomac.utils.Utils;

public class FixUtils {
	
	public final static int UTCTIMESTAMP_LENGTH = 21; // yyyyMMdd-HH:mm:ss.SSS
	public final static int CURRENCY_LENGTH = 3;
	public final static int FIX_MAX_STRING_LENGTH = 32;
	public final static int FIX_MAX_STRING_TEXT_LENGTH = 64;
	public final static int FIX_MAX_TAG_DIGITS = 4;

	public static final byte SOH = ( byte )0x01;
	public static final byte EQL = ( byte )'=';
	public static final byte DECIMAL = ( byte )'.';
	
	public static final long FIX_FLOAT_NUMBER_OF_DECIMALS = 10000;
	public static final int FIX_FLOAT_NUMBER_OF_DECIMALS_DIGITS = 4;
	public static final int FIX_MAX_DIGITS = 24;
	public static byte[] digitsBuf = new byte[FIX_MAX_DIGITS];
	private static byte[] newMsgType = new byte[2];
	
	public final static int EXECUTIONREPORT_INT = 56; // ascii for '8'
	public final static int ORDERCANCELREJECT_INT = 57; // ascii for '9'
	private static final byte[] EXECTYPE_SCAN = "\u0001150=".getBytes();
	private static final byte[] CXLREJRESPONSETO_SCAN = "\u0001434=".getBytes();

	public static class SessionRejectReason {
		public static final long UNDEFINED_TAG = 3;
		public static final long TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE = 2;
		public static final long SENDINGTIME_ACCURACY_PROBLEM = 10;
		public static final long REQUIRED_TAG_MISSING = 1;
		public static final long INVALID_TAG_NUMBER = 0;
		public static final long DECRYPTION_PROBLEM = 7;
		public static final long INCORRECT_DATA_FORMAT_FOR_VALUE = 6;
		public static final long VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG = 5;
		public static final long TAG_SPECIFIED_WITHOUT_A_VALUE = 4;
		public static final long COMPID_PROBLEM = 9;
		public static final long SIGNATURE_PROBLEM = 8;
		public static final long INVALID_MSGTYPE = 11;
	}
	
	/**
	 * Intrusive fetch of tag id.
	 * @param data
	 * @return
	 */
	public static int getTagId( ByteBuffer data )
	{
		int pos     = data.position();
		int tagIdEq = Utils.scan( data, pos, EQL );	 
		
		if ( tagIdEq < 0 || FIX_MAX_TAG_DIGITS < (tagIdEq - pos) ) return -1;

		int id = Utils.intValueOf( data, ( tagIdEq - pos ) );

		data.position( tagIdEq + 1 );

		return id;
	}

	public static ByteBuffer getTagValue( ByteBuffer data )
	{
		int pos     = data.position();
		int tagSOH  = Utils.scan( data, pos, SOH ); if ( tagSOH < 0 ) return null;

		ByteBuffer value = data.slice(); 
		value.limit( tagSOH );

		data.position( tagSOH + 1 );

		return value;
	}	

	public static boolean getTagBooleanValue(final ByteBuffer buf ) throws FixSessionException {
		byte c = '0';

		if (buf.hasRemaining()) {

			c = buf.get();

			if (c == SOH) {
				throw new FixSessionException(SessionRejectReason.TAG_SPECIFIED_WITHOUT_A_VALUE, "Premature end of buffer missing SOH");
			}
		}

		if (buf.get() != SOH) {
			throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, "Integer value length exceeds one character");
		}

		return c == (byte)'Y' ? true : false;
	}
	
	public static byte getTagCharValue(final ByteBuffer buf ) throws FixSessionException {
		byte c = '0';

		if (buf.hasRemaining()) {

			c = buf.get();

			if (c == SOH) {
				throw new FixSessionException(SessionRejectReason.TAG_SPECIFIED_WITHOUT_A_VALUE, "Premature end of buffer missing SOH");
			}
		}

		if (buf.get() != SOH) {
			throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, "Integer value length exceeds one character");
		}

		return c;
	}

	public static long getTagFloatValue(final ByteBuffer buf) throws FixSessionException {
		byte c;
		int start = 0;
		final int end = FIX_MAX_DIGITS - 2;

		Utils.fillNul(digitsBuf);

		while (buf.hasRemaining()) {

			if ((c = buf.get()) == SOH)
				break;

			digitsBuf[start++] = c;

			if (start == end) {
				throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
						"Value is incorrect or out of range for this tag" + FIX_MAX_DIGITS);
			}
		}
		try {
			long val = fixFloatValueOf(digitsBuf, start);
			return val;
		} catch (NumberFormatException n) {
			throw new FixSessionException(SessionRejectReason.INCORRECT_DATA_FORMAT_FOR_VALUE, "Incorrect data format for value");
		}
	}

	public static int getTagIntValue(final ByteBuffer buf) throws FixSessionException {
		byte c;
		int start = 0;
		final int end = FIX_MAX_DIGITS;

		while (buf.hasRemaining()) {

			if ((c = buf.get()) == SOH)
				break;

			digitsBuf[start++] = c;

			if (start == end) {
				throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
						"Value length exceeds maximum number of digits " + FIX_MAX_DIGITS);
			}
		}

		if (start == 0)
			throw new FixSessionException(SessionRejectReason.TAG_SPECIFIED_WITHOUT_A_VALUE, "Tag specified without a value");
			
		return Utils.intValueOf(digitsBuf, 0, start);
	}

	public static byte[] getTagStringValue(final ByteBuffer src, final byte[] dst) throws FixSessionException {
		int start = 0;
		final int end = dst.length;
		byte c;
		final int oldPos = src.position();

		Utils.fillNul(dst);

		while (src.hasRemaining()) {

			if ((c = src.get()) == SOH)
				break;

			if (start >= end) {
				throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, "Value length exceeds maximum of "
						+ (end - start));
			} else {
				dst[start] = c;
				start++;
			}
		}
		
		if (start == 0)
			throw new FixSessionException(SessionRejectReason.TAG_SPECIFIED_WITHOUT_A_VALUE, "Tag specified without a value");
			
		return dst;
	}
	
	public static boolean isSet(byte[] val) {
		return Utils.lastIndexTrim(val, (byte)0) > 0;
	}	

	public static boolean isSet(byte val) {
		return val != Byte.MAX_VALUE;
	}	

	public static boolean isSet(long val) {
		return val != Long.MAX_VALUE;
	}

	public static boolean isSet(boolean val) {
		return val;
	}

	public static int computeChecksum( ByteBuffer buffer, int start, int end )
	{
		int cks = 0;
		
		for (int i = start; i < end; i++)
		{
			cks += buffer.get(i);
		}
                                                                                                                   
        return ( cks % 256 );
	}
	
	public static void longToFixFloat(final byte out[], final int offset, long l, final int length) {
		final int radix = 10;
		
		Utils.fillNul(out);

		if (l == 0) {
			out[offset] = (byte) '0';
			return;
		}

		int count = 2;
		long j = l;
		final boolean negative = l < 0;
		if (!negative) {
			count = 1;
			j = -l;
		}
		count++; // the decimal
		int decimalPos = length - offset - FIX_FLOAT_NUMBER_OF_DECIMALS_DIGITS + 1;

		while ((l /= radix) != 0 && count < length - offset)
			count++;

		do {
			int ch = 0 - (int) (j % radix);
			if (ch > 9)
				ch = ch - 10 + (byte) 'a';
			else
				ch += (byte) '0';
			if (count == decimalPos - 1)
				out[--count] = (byte) '.';
			out[--count] = (byte) ch;

		} while ((j /= radix) != 0);
		if (negative)
			out[0] = (byte) '-';

	}	

	public static long fixFloatValueOf(final byte[] s, int length) {
		int start = 0;
		boolean negative = false;
		int decimal = -1;
		long value;

		final byte c = s[start];
		if (c == '-') {
			++start;
			--length;
			negative = true;
		} /*
		 * else if (c == '+') { ++start; --length; }
		 */
		if (length == 0)
			throw new NumberFormatException("to short number");

		for (decimal = length - 1; decimal >= 0; decimal--)
			if (s[decimal] == (byte) '.')
				break;

		final int decimals = length - 1 - decimal;

		if (decimal > -1) {
			value = Utils.longValueOf(s, 0, decimal) * FIX_FLOAT_NUMBER_OF_DECIMALS;
			value += Utils.intValueOf(s, decimal + 1 < length ? decimal + 1 : length - 1,
					FIX_FLOAT_NUMBER_OF_DECIMALS_DIGITS < decimals ? FIX_FLOAT_NUMBER_OF_DECIMALS_DIGITS : decimals);
		} else
			value = Utils.longValueOf(s, 0, decimals) * FIX_FLOAT_NUMBER_OF_DECIMALS;

		if (negative)
			return -1 * value;
		return value;

	}

	public static void putFixFloatTag(ByteBuffer buf, int tag, long value) {
		int length = Utils.digits(value) + 1; // 1 for decimal point
		
		longToFixFloat(digitsBuf, 0, value, length);
		
		put(buf, tag);
		
		buf.put( EQL );
		
		put(buf, digitsBuf);
			
		buf.put( SOH );
		
	}

	public static void putFixTag(ByteBuffer buf, int tag, byte value) {

		put(buf, tag);
		
		buf.put( EQL );
		
		buf.put(value);
			
		buf.put( SOH );
		
	}

	public static void putFixTag(ByteBuffer buf, int tag, int value) {
		putFixTag(buf, tag, (long)value);
	}

	public static void putFixTag(ByteBuffer buf, int tag, byte[] value) {

		put(buf, tag);
		
		buf.put( EQL );
		
		put(buf, value);
			
		buf.put( SOH );
		
	}

	public static void putFixTag(ByteBuffer buf, int tag, long value) {

		put(buf, tag);
		
		buf.put( EQL );
		
		if( value < 0 ) {

			buf.put( (byte)'-' );

			value *= -1;
		}

		put(buf, value);
			
		buf.put( SOH );
		
	}

	public static void putFixTag(ByteBuffer buf, int tag, byte[] value, int offset, int end) {

		put(buf, tag);
		
		buf.put( EQL );
		
		buf.put(value, offset, end);
			
		buf.put( SOH );
		
	}


	static void put(final ByteBuffer out, final byte b) {
		out.put(b);
	}

	static void put(final ByteBuffer out, final byte[] buf) {
		for (final byte b : buf) {
			if (b == SOH || b == 0)
				break;

			out.put(b);
		}
	}

	static void put(final ByteBuffer out, long l) {
		final int radix = 10;
		final int endPos;

		if (l == 0) {
			out.put((byte) '0');
			return;
		}

		int count = 2;
		long j = l;
		final boolean negative = l < 0;
		if (!negative) {
			count = 1;
			j = -l;
		}
		while ((l /= radix) != 0)
			count++;

		int index = endPos = out.position() + count;

		do {
			int ch = 0 - (int) (j % radix);
			if (ch > 9)
				ch = ch - 10 + (byte) 'a';
			else
				ch += (byte) '0';
			index--;
			count--;
			out.position(index);
			out.put((byte) ch);

		} while ((j /= radix) != 0);
		if (negative) {
			out.position(--index);
			out.put((byte) '-');
		}

		out.position(endPos);
	}

	public static int getMsgTypeTagAsInt(final byte[] b, final int length) {
		int val = 0;

		val |= b[0];

		if (length > 1)
			for (int i = 1; i < length; i++) {
				val <<= 8;
				val |= b[i];
			}

		return val;
	}	
	
	public static int crackNasdaqMsgType(int msgType, final ByteBuffer buf) throws FixSessionException {

		if (! Boolean.valueOf("useNasdaq")) return msgType;
		
		final int pos = buf.position();

		if (msgType == EXECUTIONREPORT_INT) { // this is Execution Report need to figure out sub type...

			// get tag ExecType (150)
			if (Utils.contains(buf,EXECTYPE_SCAN)) {

				final byte c = getTagCharValue(buf);

				newMsgType[0] = (byte) '8';

				newMsgType[1] = c;

				msgType = getMsgTypeTagAsInt(newMsgType, 2);

			} 
			
		} else if (msgType == ORDERCANCELREJECT_INT) { // this is order reject...

			// 434 CxlRejResponseTo
			if (Utils.contains(buf, CXLREJRESPONSETO_SCAN)) {

				final byte c = getTagCharValue(buf);

				newMsgType[0] = (byte) '9';
				newMsgType[1] = c;
				msgType = getMsgTypeTagAsInt(newMsgType, 2);

			}

		} 

		buf.position(pos);

		return msgType;
	}
	
}
