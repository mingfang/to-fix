package org.tomac.protocol.fix;

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.messaging.FixMessageInfo;
import org.tomac.protocol.fix.messaging.FixMessagePool;
import org.tomac.protocol.fix.messaging.FixTags;

public class FixUtils {
	public static final int						FIX_HEADER							= 5 + FixTags.BEGINSTRING_LENGTH;										// '8' + '=' + BeginString[7] + SOH + '9' + '='
	public static final int						FIX_MESSAGE_START					= FIX_HEADER + 5;							// '8' + '=' + BeginString[7] + SOH + '9' + '=' '0000' + SOH
	public static final int						FIX_TRAILER							= 7;										// '10' + = + checkSum[3] + SOH

	public static final byte					SOH									= (byte) 0x01;
	public static final byte					EQUALS								= (byte) '=';
	public static final byte					DECIMAL								= (byte) '.';

	public static final short					TAG_HAS_NO_VALUE					= 0;
	public static final short					TAG_HAS_VALUE						= -1;
	// public static final short BUFFER_HAS_TAG > 0;

	public static int							FIX_FLOAT_NUMBER_OF_DECIMALS_DIGITS	= 2;
	public static int							FIX_FLOAT_NUMBER_OF_DECIMALS		= FIX_FLOAT_NUMBER_OF_DECIMALS_DIGITS * 10;
	public static final int						FIX_MAX_DIGITS						= 19;
	public static final int						FIX_MAX_TAG_LENGTH					= 4;
	public static final int						FIX_MAX_INT_LENGTH					= 19;
	public static final int						FIX_MAX_STRING_LENGTH				= 64;
	public static final int						UTCTIMESTAMP_LENGTH					= 24;
	public static final int						CURRENCY_LENGTH						= 3;
	public static final int						FIX_MAX_STRING_TEXT_LENGTH			= 64;
	public static final int						FIX_MAX_NOINGROUP					= 5;

	private static byte[]						beginsStringTmp						= new byte[FixTags.BEGINSTRING_LENGTH];

	public static boolean						isNasdaqOMX							= true;

	private static byte[]						calcCheckSum						= new byte[FixTags.CHECKSUM_LENGTH];

	private static byte[]						currCheckSum						= new byte[FixTags.CHECKSUM_LENGTH];

	public static boolean						validateChecksum					= true;

	/**
	 * Non intrusive check of header. Returns fix length of message.
	 * 
	 * @param buf
	 * @param err
	 * @return
	 */
	public static int checkHeaderAndTrailer(final ByteBuffer buf, final FixValidationError err) {
		final int startPos = buf.position();
		int length = 0;

		if (buf.limit() <= FixUtils.FIX_HEADER)
			err.setError((int) FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "No room in message for body length", FixTags.BODYLENGTH_INT);

		// BeginString
		if (!err.hasError()) {
			final int tag = FixMessage.getTag(buf, err);

			if (tag != FixTags.BEGINSTRING_INT)
				err.setError((int) FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "BeginString missing", FixTags.BEGINSTRING_INT);
			else {
				FixMessage.getTagStringValue(buf, beginsStringTmp, 0, FixTags.BEGINSTRING_LENGTH, err);

				if (!FixUtils.equals(beginsStringTmp, FixMessageInfo.BEGINSTRING_VALUE))
					err.setError((int) FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "BeginString not set to " + new String(FixMessageInfo.BEGINSTRING_VALUE), FixTags.BEGINSTRING_INT);
			}

		}

		// BodyLength
		if (!err.hasError()) {
			final int tag = FixMessage.getTag(buf, err);

			if (!err.hasError())
				if (tag != FixTags.BODYLENGTH_INT)
					err.setError((int) FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "BodyLength missing", FixTags.BEGINSTRING_INT);
				else
					length = FixMessage.getTagIntValue(buf, err);
		}

		// CheckSum and trailer
		if (!err.hasError() && validateChecksum) {

			generateCheckSum(calcCheckSum, buf, buf.position(), length + buf.position());

			buf.position(length + buf.position());
			final int tag = FixMessage.getTag(buf, err);

			if (!err.hasError())
				if (tag != FixTags.CHECKSUM_INT)
					err.setError((int) FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "CheckSum missing", FixTags.CHECKSUM_INT);
				else {

					FixMessage.getTagStringValue(buf, currCheckSum, 0, FixTags.CHECKSUM_LENGTH, err);

					if (!err.hasError())
						if (FixUtils.equals(currCheckSum, calcCheckSum))
							err.setError((int) FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, "Checksum incorrect " + new String(currCheckSum), FixTags.CHECKSUM_INT);
				}
		}

		buf.position(startPos);
		return length;
	}

	public static void copy(final byte dst[], final byte src[]) {
		if (src.length != dst.length)
			throw new IllegalArgumentException();

		System.arraycopy(src, 0, dst, 0, dst.length);
	}

	public static boolean equals(final byte[] x, final byte[] y) {

		int len = x.length < y.length ? x.length : y.length;
		int offset = 0;

		while (len > 0) {
			if (x[offset] != y[offset])
				return false;

			offset++;
			len--;
		}

		return true;
	}

	public static void fillSpace(final byte[] buf) {
		for (int i = 0; i < buf.length; i++)
			buf[i] = (byte) ' ';
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
		} else if (c == '+') {
			++start;
			--length;
		}
		if (length == 0)
			throw new NumberFormatException("to short number");

		for (decimal = length; decimal >= 0; decimal--)
			if (s[decimal] == (byte) '.')
				break;

		final int decimals = length - decimal;

		if (decimal > -1) {
			value = longValueOf(s, 0, decimal) * FIX_FLOAT_NUMBER_OF_DECIMALS;
			value += intValueOf(s, decimal + 1, FIX_FLOAT_NUMBER_OF_DECIMALS_DIGITS > decimals ? FIX_FLOAT_NUMBER_OF_DECIMALS_DIGITS : decimals);
		} else
			value = longValueOf(s, 0, decimal);

		if (negative)
			return -1 * value;
		return value;

	}

	public static void generateCheckSum(final byte[] checkSum, final ByteBuffer buf, final int startPos, final int endPos) {
		final int currPos = buf.position();
		int cks = 0;
		final int bufLen = endPos - startPos;

		buf.position(startPos);
		for (int i = 0; i < bufLen; i++)
			cks += buf.get();
		FixUtils.longToNumeric(checkSum, 0, cks % 256, checkSum.length);
		buf.position(currPos);
	}

	public static int intValueOf(final byte[] b, int pos, int len) {

		while (len > 0 && b[pos] == (byte) ' ') {
			pos++;
			len--;
		}

		int sign = 1;

		if (b[pos] == '+') {
			sign = 1;
			len--;
			pos++;
		} else if (b[pos] == '-') {
			sign = -1;
			len--;
			pos++;
		}

		int x = 0;

		while (len > 0 && b[pos] >= '0' && b[pos] <= '9') {

			x *= 10;

			x += b[pos] - '0';

			len--;

			pos++;
		}

		return sign * x;
	}

	public static final boolean isNumeric(final int b) {

		return b >= '0' && b <= '9';
	}

	public static void longToNumeric(final byte out[], final int offset, long l, final int length) {
		final int radix = 10;

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
		while ((l /= radix) != 0)
			count++;

		do {
			int ch = 0 - (int) (j % radix);
			if (ch > 9)
				ch = ch - 10 + (byte) 'a';
			else
				ch += (byte) '0';
			out[--count] = (byte) ch;

		} while ((j /= radix) != 0);
		if (negative)
			out[0] = (byte) '-';

	}

	public static long longValueOf(final byte[] b, int pos, int len) {

		while (len > 0 && b[pos] == (byte) ' ') {
			pos++;
			len--;
		}

		long x = 0;

		while (len > 0 && b[pos] >= '0' && b[pos] <= '9') {

			x *= 10;

			x += b[pos] - '0';

			len--;

			pos++;

		}

		return x;

	}

	public static void put(final ByteBuffer out, final byte b) {
		out.put(b);
	}

	public static void put(final ByteBuffer out, final byte[] buf) {
		for (final byte b : buf) {
			if (b == SOH || b == 0)
				break;

			out.put(b);
		}
	}

	public static void put(final ByteBuffer out, long l) {
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

	/**
	 * Allocates byte[] copy without leading and trailing white spaces.
	 * 
	 * @param buf
	 * @return byte array without trailing and leading whitespace characters
	 */
	public static byte[] trim(final byte[] buf) {
		int start = 0;
		for (final byte b : buf) {
			if (b > 0x20)
				break;
			start++;
		}
		int end = buf.length;
		for (int i = buf.length - 1; i > 0; i--) {
			if (buf[i] > 0x20)
				break;
			end--;
		}

		final byte[] ret = new byte[end - start > 0 ? end - start : buf.length];
		System.arraycopy(buf, start, ret, 0, ret.length);
		return ret;
	}

}
