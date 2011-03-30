package org.tomac.protocol.fix;

import java.nio.ByteBuffer;

abstract public class FixGroup {
	private final int				keyTag;
	protected java.nio.ByteBuffer	buf;
	protected FixValidationError	err;
	public boolean isRequired = false;

	protected FixGroup(final int keyTag) {
		this.keyTag = keyTag;

		buf = null;
	}

	public abstract void clear();

	public abstract void encode(ByteBuffer out);

	public abstract boolean hasGroup();

	public boolean isKeyTag(final int tag) {
		return keyTag == tag;
	}

	public void printBuffer(final ByteBuffer out) {
	}

	public void setBuffer(final ByteBuffer buf, final FixValidationError err) {
		this.err = err;
		this.buf = buf;
	}

}
