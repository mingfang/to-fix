package org.tomac.protocol.fix.messaging.fix42nordic.component;

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
public interface FixComponent {

	public void clear();

	public void encode(ByteBuffer out);

	public boolean isSet();
}
