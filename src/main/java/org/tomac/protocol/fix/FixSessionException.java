package org.tomac.protocol.fix;

import java.nio.ByteBuffer;

public class FixSessionException extends Exception {

	private static final long serialVersionUID = -1L;
	
	StringBuffer description = new StringBuffer();
	
	public FixSessionException(String message) {
		description.append("Framing Exception: (").append(message).append(")\n");
	}
	
	public FixSessionException(String message, Throwable cause) {
		super(cause);
		description.append("Framing Exception: (").append(message).append(")\n");
	}

	public FixSessionException(ByteBuffer packetBuf, String message) {
		description.append("Framing Exception: (").append(message).append(")\n");
	}

	public FixSessionException(ByteBuffer packetBuf, int msgEnd, String message) {
		description.append("Framing Exception: (").append(message).append(")\n");
		packetBuf.position(msgEnd);
	}

	
	public FixSessionException(long sessionRejectReason, String message) {
		description.append("Framing Exception: (").append(message).append(")\n");
	}

	@Override
	public String getMessage() {
		return description.toString();
	}


}
