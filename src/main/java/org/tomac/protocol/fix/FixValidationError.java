package org.tomac.protocol.fix;

import org.tomac.protocol.fix.messaging.FixLogon;

public class FixValidationError {
	int		sessionRejectReason	= -1;
	String	text;
	int		refTagID;
	byte[]	refMsgType;
	FixInMessage msg;
	public int	sessionID;
	public long msgSeqNum;

	public void clear() {
		sessionRejectReason = -1;
		msg = null;
		msgSeqNum = -1;
	}

	public boolean hasError() {
		return sessionRejectReason >= 0;
	}

	public void setError(final int sessionRejectReason, final String text) {
		this.sessionRejectReason = sessionRejectReason;
		this.text = text;
	}

	public void setError(final int sessionRejectReason, final String text, final int refTagID) {
		this.sessionRejectReason = sessionRejectReason;
		this.text = text;
		this.refTagID = refTagID;
	}

	public void setError(final int sessionRejectReason, final String text, final int refTagID, final byte[] refMsgType) {
		this.sessionRejectReason = sessionRejectReason;
		this.text = text;
		this.refTagID = refTagID;
		this.refMsgType = refMsgType;
	}
	
	public void setSessionID(int sessionID) { this.sessionID = sessionID; }

	public void setFixMessage(FixInMessage msg) { this.msg = msg; }

	public FixInMessage getFixMessage() { return msg; }
	
	public boolean isMsgSeqNumConsumer() {
		return sessionRejectReason != FixEvent.DISCONNECT && sessionRejectReason != FixEvent.GARBLED ;
	}

	public int getSessionRejectReason() {
		return sessionRejectReason;
	}


}
