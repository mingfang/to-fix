package org.tomac.protocol.fix.messaging.fix50sp2.component;

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
public interface FixComponent {

	public void clear();

	public void encode(ByteBuffer out);

	public boolean isSet();§
}
