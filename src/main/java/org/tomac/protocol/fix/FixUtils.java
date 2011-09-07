package org.tomac.protocol.fix;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

import org.tomac.utils.Utils;

public class FixUtils {
	
	private final static boolean useNasdaqOmx = Boolean.getBoolean("useNasdaq");
	
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
	
	public final static byte[] EXECUTIONREPORT = "8".getBytes(); // ascii for '8'
	public final static byte[] ORDERCANCELREJECT = "9".getBytes(); // ascii for '9'
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
	public static int getTagId( final ByteBuffer out ) throws FixGarbledException
	{
		out.mark();
		
		int x = 0;
		byte b = 0;

		try {
			while ((b = out.get() ) != EQL) {

				x *= 10;

				x += b - '0';

			}
			return x;
		} catch (final BufferUnderflowException e) {
			throw new FixGarbledException(out, "Tag not terminated by \'=\' or exceding " + FIX_MAX_DIGITS);
		}
	}

	public static ByteBuffer getTagValue( final ByteBuffer data )
	{
		final int tagSOH  = Utils.scan( data, SOH ); if ( tagSOH < 0 ) return null;

		final ByteBuffer value = data.slice(); 
		value.limit( tagSOH );

		data.position( tagSOH + 1 );

		return value;
	}	

	public static boolean getTagBooleanValue(final byte[] msgType, final int tag, final ByteBuffer buf ) throws FixSessionException {
		byte c = '0';

		c = buf.get();

		if (c == SOH) {
			throw new FixSessionException(SessionRejectReason.TAG_SPECIFIED_WITHOUT_A_VALUE, "Premature end of buffer missing SOH".getBytes(), tag, msgType);
		}

		if (buf.get() != SOH) {
			throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, "Integer value length exceeds one character".getBytes(), tag, msgType);
		}

		return c == (byte)'Y' ? true : false;
	}
	
	public static byte getTagCharValue(final byte[] msgType, final int tag, final ByteBuffer buf ) throws FixSessionException {
		byte c = '0';

		c = buf.get();

		if (c == SOH) {
			throw new FixSessionException(SessionRejectReason.TAG_SPECIFIED_WITHOUT_A_VALUE, "Premature end of buffer missing SOH".getBytes(), tag, msgType);
		}

		if (buf.get() != SOH) {
			throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Integer value length exceeds one character, read" + buf.get(buf.position()-1) ).getBytes(), tag, msgType);
		}

		return c;
	}

	public static long getTagFloatValue(final byte[] msgType, final int tag, final ByteBuffer buf) throws FixSessionException {
		byte c;
		int start = 0;
		final int end = FIX_MAX_DIGITS - 2;

		Utils.fillNul(digitsBuf);

		while ((c = buf.get()) != SOH) {

			digitsBuf[start++] = c;

			if (start == end) {
				throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
						("Value is incorrect or out of range for this tag " + FIX_MAX_DIGITS).getBytes() , tag, msgType);
			}
		}
		try {
			final long val = fixFloatValueOf(digitsBuf, start);
			return val;
		} catch (final NumberFormatException n) {
			throw new FixSessionException(SessionRejectReason.INCORRECT_DATA_FORMAT_FOR_VALUE, "Incorrect data format for value".getBytes(), tag, msgType);
		}
	}

	public static int getTagIntValue(final byte[] msgType, final int tag, final ByteBuffer buf) throws FixSessionException {
		byte c = SOH;
		int start = 0;
		final int end = FIX_MAX_DIGITS;

		while ((c = buf.get()) != SOH) {

			digitsBuf[start++] = c;

			if (start == end) {
				throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
						("Value length exceeds maximum number of digits " + FIX_MAX_DIGITS).getBytes(), tag, msgType);
			}
		}

		if (start == 0)
			throw new FixSessionException(SessionRejectReason.TAG_SPECIFIED_WITHOUT_A_VALUE, "Tag specified without a value".getBytes(), tag, msgType);

		if (c != SOH)
			throw new FixSessionException(SessionRejectReason.TAG_SPECIFIED_WITHOUT_A_VALUE, "Message not terminated by SOH".getBytes(), tag, msgType);
		
		return Utils.intValueOf(digitsBuf, 0, start);
	}

	public static byte[] getTagStringValue(final byte[] msgType, final int tag, final ByteBuffer src, final byte[] dst) throws FixSessionException {
		int start = 0;
		final int end = dst.length;
		byte c = SOH;

		Utils.fillNul(dst);

		while ((c = src.get()) != SOH) {

			if (start >= end) {
				throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Value length exceeds maximum of " + end).getBytes(), tag, msgType);
			} else {
				dst[start] = c;
				start++;
			}
		}
		
		if (start == 0)
			throw new FixSessionException(SessionRejectReason.TAG_SPECIFIED_WITHOUT_A_VALUE, "Tag specified without a value".getBytes(), tag, msgType);
			
		return dst;
	}
	
	public static boolean isSet(final byte[] val) {
		return val[0] != (byte)0;
	}	

	public static boolean isSet(final byte val) {
		return val != Byte.MAX_VALUE;
	}	

	public static boolean isSet(final long val) {
		return val != Long.MAX_VALUE;
	}

	public static boolean isSet(final boolean val) {
		return val;
	}

	public static int computeChecksum( final ByteBuffer buf, final int start, final int end )
	{
		int cks = 0;
		int i = end - start;
		
		buf.position(start);
		
		while (i > 0)
		{
			i--;
			cks += buf.get();
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
		final int decimalPos = length - offset - FIX_FLOAT_NUMBER_OF_DECIMALS_DIGITS + 1;

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
			final int dec = FIX_FLOAT_NUMBER_OF_DECIMALS_DIGITS < decimals ? FIX_FLOAT_NUMBER_OF_DECIMALS_DIGITS : decimals;
			value += Utils.intValueOf(s, decimal + 1 < length ? decimal + 1 : length - 1, dec) * Utils.multiplier(FIX_FLOAT_NUMBER_OF_DECIMALS_DIGITS - dec);
		} else
			value = Utils.longValueOf(s, 0, decimals) * FIX_FLOAT_NUMBER_OF_DECIMALS;

		if (negative)
			return -1 * value;
		return value;

	}

	public static void putFixFloatTag(final ByteBuffer buf, final int tag, final long value) {
		final int length = Utils.digits(value) + 1; // 1 for decimal point
		
		longToFixFloat(digitsBuf, 0, value, length);
		
		put(buf, tag);
		
		buf.put( EQL );
		
		put(buf, digitsBuf);
			
		buf.put( SOH );
		
	}

	public static void putFixTag(final ByteBuffer buf, final int tag, final byte value) {

		put(buf, tag);
		
		buf.put( EQL );
		
		buf.put(value);
			
		buf.put( SOH );
		
	}

	public static void putFixTag(final ByteBuffer buf, final int tag, final int value) {
		putFixTag(buf, tag, (long)value);
	}

	public static void putFixTag(final ByteBuffer buf, final int tag, final byte[] value) {

		put(buf, tag);
		
		buf.put( EQL );
		
		put(buf, value);
			
		buf.put( SOH );
		
	}

	public static void putFixTag(final ByteBuffer buf, final int tag, long value) {

		put(buf, tag);
		
		buf.put( EQL );
		
		if( value < 0 ) {

			buf.put( (byte)'-' );

			value *= -1;
		}

		put(buf, value);
			
		buf.put( SOH );
		
	}

	public static void putFixTag(final ByteBuffer buf, final int tag, final byte[] value, final int offset, final int end) {

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

		if (! useNasdaqOmx) return msgType;
		
		final int pos = buf.position();

		if (msgType == EXECUTIONREPORT_INT) { // this is Execution Report need to figure out sub type...

			// get tag ExecType (150)
			if (Utils.contains(buf,EXECTYPE_SCAN)) {

				final byte c = getTagCharValue(EXECUTIONREPORT, 150, buf);

				newMsgType[0] = (byte) '8';

				newMsgType[1] = c;

				msgType = getMsgTypeTagAsInt(newMsgType, 2);

			} 
			
		} else if (msgType == ORDERCANCELREJECT_INT) { // this is order reject...

			// 434 CxlRejResponseTo
			if (Utils.contains(buf, CXLREJRESPONSETO_SCAN)) {

				final byte c = getTagCharValue(ORDERCANCELREJECT, 434, buf);

				newMsgType[0] = (byte) '9';
				newMsgType[1] = c;
				msgType = getMsgTypeTagAsInt(newMsgType, 2);

			}

		} 
		
		buf.position(pos);

		return msgType;
	}

	public static byte[] getMsgType(final int msgType) {
        return new byte[] {
                //(byte)(msgType >>> 24),
                //(byte)(msgType >>> 16),
                (byte)(msgType >>> 8),
                (byte)msgType};
	}

	public static void findEndOfMessage(final ByteBuffer buf) {
		while(buf.hasRemaining()) {
			int pos; 
			if ( ( pos = Utils.scan(buf, SOH) ) < 0 ) return;
			buf.position(pos + 1);
			if (buf.get() != (byte)'1') continue;
			if (buf.get() != (byte)'0') continue;
			if (buf.get() != EQL) continue;
			if ( ( pos = Utils.scan(buf, SOH) ) < 0 ) return;
			buf.position(pos + 1);
			return;
		}
		
	}
	
}
