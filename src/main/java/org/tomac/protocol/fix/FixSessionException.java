package org.tomac.protocol.fix;

public class FixSessionException extends Exception {

	private static final long serialVersionUID = -1L;
	
	public byte[] text;
	public long refTagID = 0;
	public byte[] refMsgType;
	public long sessionRejectReason = 0;	
	
	public FixSessionException(long sessionRejectReason, byte[] text, long refTagID, byte[] refMsgType) {
		this.sessionRejectReason = sessionRejectReason;
		this.text = text;
		this.refTagID = refTagID;
		this.refMsgType = refMsgType;
	}
	
	public FixSessionException(long sessionRejectReason, byte[] text) {
		this.sessionRejectReason = sessionRejectReason;
		this.text = text;
	}

	@Override
	public String getMessage() {
		return sessionRejectReason + ": " + "text=" + new String(text) + " refTagID=" + refTagID + " refMsgType=" + new String(refMsgType);
	}


}
