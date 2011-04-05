package org.tomac.protocol.fix.replay;

import org.tomac.protocol.fix.FixInMessage;

public interface FixValidator {
	
	public void validate(FixInMessage msg);
	
	public void validate(int sessionID, int event);
	
}
