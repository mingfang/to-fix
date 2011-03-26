package org.tomac.protocol.fix;

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.messaging.FixMessageInfo;
import org.tomac.protocol.fix.messaging.FixStandardHeader;
import org.tomac.protocol.fix.messaging.FixStrandardTrailer;

public abstract class FixMessage {
	public static int getNext(final ByteBuffer buf, final FixValidationError err) {
		int c = 0;

		while (buf.hasRemaining()) {
			c++;

			if (buf.get() == FixUtils.SOH)
				return c;
		}
		if (err != null)
			err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, "Value has no terminating SOH");
		return c;
	}

	/**
	 * Find tag in buffer. position set to tag data if found, else unchanged.
	 * 
	 * @param tag
	 * @param buf
	 * @param err
	 * @return
	 */
	public static boolean getTag(final int tag, final ByteBuffer buf, final FixValidationError err) {
		final int pos = buf.position();

		while (tag != getTag(buf, err) && buf.hasRemaining()) {
			if (err.hasError()) {
				buf.position(pos);
				return false;
			}
			getNext(buf, err);
			if (err.hasError()) {
				buf.position(pos);
				return false;
			}
		}

		return true;
	}

	public static int getTagAsInt(final byte[] b, final int length) {
		int val = 0;

		val |= b[0];

		if (length > 1)
			for (int i = 1; i < length; i++) {
				val <<= 8;
				val |= b[i];
			}

		return val;
	}

	public static byte getTagCharValue(final ByteBuffer buf, final FixValidationError err) {
		byte c = '0';

		if (buf.hasRemaining()) {

			c = buf.get();

			if (c == FixUtils.SOH) {
				err.setError((int) FixMessageInfo.SessionRejectReason.TAG_SPECIFIED_WITHOUT_A_VALUE, "Premature end of buffer missing SOH");
				return c;
			}
		}

		final int count = getNext(buf, null);

		if (count > 1) {
			err.setError((int) FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, "Integer value length exceeds one character");
			return c;
		}

		return c;
	}

	public static long getTagFloatValue(final ByteBuffer buf, final FixValidationError err) {
		byte c;
		int start = 0;
		final int end = FixUtils.FIX_MAX_DIGITS;

		FixUtils.fillSpace(digitsBuf);

		while (buf.hasRemaining()) {

			if ((c = buf.get()) == FixUtils.SOH)
				break;

			digitsBuf[start++] = c;

			if (start == end) {
				err.setError((int) FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, "Float value length exceeds maximum number of digits " + FixUtils.FIX_MAX_DIGITS);
				return getNext(buf, null);
			}
		}
		return FixUtils.fixFloatValueOf(digitsBuf, start);
	}

	public static int getTagIntValue(final ByteBuffer buf, final FixValidationError err) {
		byte c;
		int start = 0;
		final int end = FixUtils.FIX_MAX_DIGITS;

		while (buf.hasRemaining()) {

			if ((c = buf.get()) == FixUtils.SOH)
				break;

			digitsBuf[start++] = c;

			if (start == end) {
				err.setError((int) FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, "Value length exceeds maximum number of digits " + FixUtils.FIX_MAX_DIGITS);
				return getNext(buf, null);
			}
		}

		return FixUtils.intValueOf(digitsBuf, 0, start);
	}

	public static int getTagStringValue(final ByteBuffer src, final byte[] dst, int start, final int end, final FixValidationError err) {
		byte c;
		final int oldPos = src.position();

		while (src.hasRemaining()) {

			if ((c = src.get()) == FixUtils.SOH)
				break;

			if (start >= end) {
				err.setError((int) FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, "Value length exceeds maximum of " + (end - start));
				return getNext(src, null);
			} else {
				dst[start] = c;
				start++;
			}
		}
		return src.position() - oldPos - 1;
	}

	/**
	 * Used for standard trailer in order rewind buffer situated in next tag.
	 * 
	 * @param tag
	 * @param buf
	 */
	public static void unreadLastTag(final int tag, final ByteBuffer buf) {
		// take the standard case first
		if (tag == 8) {
			buf.position(buf.position() - 2);
			return;
		}

		// TODO what about other tags?
	}

	final public int			msgType;

	public FixStandardHeader	standardHeader;

	public FixStrandardTrailer	standardTrailer;

	private static byte[]		digitsBuf;

	public static int getTag(final ByteBuffer buf, final FixValidationError err) {
		int count = 0;
		int tag = 0;
		int c;

		while (buf.hasRemaining()) {
			c = buf.get();
			if (c == '=')
				break;

			if (c == FixUtils.SOH) {
				err.setError((int) FixMessageInfo.SessionRejectReason.INVALID_TAG_NUMBER, "Tag number terminated by SOH");
				return getNext(buf, null);
			}

			if (!FixUtils.isNumeric(c)) {
				err.setError((int) FixMessageInfo.SessionRejectReason.INVALID_TAG_NUMBER, "Tag not nummeric");
				return getNext(buf, null);
			}

			tag = tag * 10 + c - '0';

			if (++count > FixUtils.FIX_MAX_TAG_LENGTH) {
				err.setError((int) FixMessageInfo.SessionRejectReason.INVALID_TAG_NUMBER, "Tag number exceeds max allowed digits");
				return getNext(buf, null);
			}
		}
		return tag;
	}

	FixMessage(final byte[] msgType) {
		standardTrailer = new FixStrandardTrailer();
		standardHeader = new FixStandardHeader();
		this.msgType = FixMessage.getTagAsInt(msgType, msgType.length);
		digitsBuf = new byte[FixUtils.FIX_MAX_DIGITS];
	}

	public void clear() {
		standardHeader.clear();
		standardTrailer.clear();
	}

	@Override
	public abstract FixMessage clone();

	abstract public int encode(ByteBuffer out);

	public abstract void printBuffer(ByteBuffer out);

	@Override
	public abstract String toString();

}
