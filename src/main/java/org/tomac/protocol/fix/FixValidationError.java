package org.tomac.protocol.fix;

public class FixValidationError {
	int		sessionRejectReason	= -1;
	String	text;
	int		refTagID;
	byte[]	refMsgType;

	public void clear() {
		sessionRejectReason = -1;
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

}
