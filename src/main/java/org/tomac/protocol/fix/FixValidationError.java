package org.tomac.protocol.fix;


public class FixValidationError {
	int		sessionRejectReason;
	public String	text;

	public int		refTagID;

	public int	    refMsgTypeInt;
	
	public IFixSession session;
	long	resendRequestMsgSeqNum;


	public void clear() {
		sessionRejectReason = -1;
		session = null;
		text = null;
		refTagID = -1;
		refMsgTypeInt = -1;
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

	public void setError(final int sessionRejectReason, final String text, final int refTagID, final int refMsgType) {
		this.sessionRejectReason = sessionRejectReason;
		this.text = text;
		this.refTagID = refTagID;
		this.refMsgTypeInt = refMsgType;
	}
	
	public boolean isMsgSeqNumConsumer() {
		return sessionRejectReason != FixEvent.DISCONNECT && sessionRejectReason != FixEvent.GARBLED ;
	}
	
	@Override
	public String toString() {
		return "sessionRejectReason=" + sessionRejectReason + " " + text + " refTagID(" + refTagID + ") refMsgTypeInt(" + refMsgTypeInt + ")";
	}

}
