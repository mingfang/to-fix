package org.tomac.protocol.fix;

import java.nio.ByteBuffer;

public abstract class FixInMessage extends FixMessage {

	protected ByteBuffer			buf;
	protected FixValidationError	err;

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
