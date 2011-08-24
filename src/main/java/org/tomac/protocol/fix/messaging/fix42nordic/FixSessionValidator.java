package org.tomac.protocol.fix.messaging.fix42nordic;

import org.tomac.protocol.fix.FixSessionException;

public abstract class FixSessionValidator {

	public boolean validate(FixMessage msg)  throws FixSessionException {return true;}

}
