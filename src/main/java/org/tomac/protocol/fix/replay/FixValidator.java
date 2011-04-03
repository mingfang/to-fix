package org.tomac.protocol.fix.replay;

import org.tomac.protocol.fix.FixInMessage;

public interface FixValidator {
	public FixInMessage validate(FixInMessage msg);
}
