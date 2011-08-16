package org.tomac.protocol.fix;

import java.nio.ByteBuffer;

public class FixGarbledException extends Exception {

	private static final long serialVersionUID = 1L;

	StringBuffer description = new StringBuffer();

	public FixGarbledException(ByteBuffer buf, String message) {
		description.append(message);
	}

	@Override
	public String getMessage() {
		return description.toString();
	}
	
}
