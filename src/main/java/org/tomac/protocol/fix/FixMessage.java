package org.tomac.protocol.fix;

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.messaging.FixStandardHeader;
import org.tomac.protocol.fix.messaging.FixStrandardTrailer;

public abstract class FixMessage {
	
	public int sessionID;
	
	final public int			msgType;

	public FixStandardHeader	standardHeader;

	public FixStrandardTrailer	standardTrailer;

	FixMessage(final byte[] msgType) {
		standardTrailer = new FixStrandardTrailer();
		standardHeader = new FixStandardHeader();
		standardHeader.setMsgType(msgType);
		this.msgType = FixUtils.getTagAsInt(msgType, msgType.length);
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
