package org.tomac.protocol.fix;

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.messaging.FixTags;

public abstract class FixInMessage extends FixMessage {

	/**
	 * non intrucive cracks the msgType from IO ByteBuffer.
	 * 
	 * @param buf
	 * @param backingBuf
	 * @param err
	 * @return
	 */
	public static int crackMsgType(final ByteBuffer buf, final FixValidationError err) {
		int msgTypeInt = 0;
		FixUtils.fillNul(tmpMsgType);

		err.clear();

		final int startPos = buf.position();

		FixUtils.checkHeaderAndTrailer(buf, err);

		if (!err.hasError())
			msgTypeInt = getMsgType(buf, err);

		buf.position(startPos);

		return msgTypeInt;
	}

	private static int getMsgType(final ByteBuffer buf, final FixValidationError err) {
		int msgTypeInt = 0;
		int length = 0;
		final int pos = buf.position();

		if (FixMessage.getTag(FixTags.MSGTYPE_INT, buf, err))
			if (!err.hasError())
				length = FixMessage.getTagStringValue(buf, tmpMsgType, 0, FixTags.MSGTYPE_LENGTH, err);
			else
				return -1;

		if (FixUtils.isNasdaqOMX && tmpMsgType[0] == (byte) '8') {
			// this is Execution Report need to figure out sub type...
			// get tag ExecType (150)
			if (FixMessage.getTag(FixTags.EXECTYPE_INT, buf, err)) {
				if (!err.hasError()) {

					final byte c = FixMessage.getTagCharValue(buf, err);

					if (!err.hasError()) {

						tmpMsgType[0] = (byte) '8';
						tmpMsgType[1] = c;

						msgTypeInt = FixMessage.getTagAsInt(tmpMsgType, 2);
					}
				}
			} else if (FixMessage.getTag(FixTags.EXECTYPE_INT, buf, err))
				if (!err.hasError()) {

					final byte c = FixMessage.getTagCharValue(buf, err);

					if (err.hasError()) {

						tmpMsgType[0] = (byte) '8';
						tmpMsgType[1] = c;

						msgTypeInt = FixMessage.getTagAsInt(tmpMsgType, 2);
					}
				}
		} else if (FixUtils.isNasdaqOMX && tmpMsgType[0] == (byte) '9') { // this is order reject...
			// 434 CxlRejResponseTo
			if (FixMessage.getTag(FixTags.CXLREJRESPONSETO_INT, buf, err))
				if (!err.hasError()) {

					final byte c = FixMessage.getTagCharValue(buf, err);

					if (!err.hasError()) {
						tmpMsgType[0] = (byte) '9';
						tmpMsgType[1] = c;

						msgTypeInt = FixMessage.getTagAsInt(tmpMsgType, 2);

					}

				}
		} else if (!err.hasError())
			msgTypeInt = FixMessage.getTagAsInt(tmpMsgType, length);
		else
			return -1;

		buf.position(pos);
		return msgTypeInt;
	}

	protected ByteBuffer			buf;
	protected FixValidationError	err;
	private static byte[]			tmpMsgType	= new byte[FixTags.MSGTYPE_LENGTH];

	protected FixInMessage(final byte[] msgType) {
		super(msgType);
		buf = null;
	}

	@Override
	public void clear() {
		super.clear();
	}

	@Override
	public abstract FixMessage clone();

	abstract public void getAll();

	public FixValidationError getLastFixValidationError() {
		return err;
	}

	protected void setBuffer(final ByteBuffer buf, final FixValidationError err) {
		this.buf = buf;
		this.err = err;
	}

	@Override
	public abstract String toString();

}
