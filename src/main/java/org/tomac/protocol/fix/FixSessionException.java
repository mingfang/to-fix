package org.tomac.protocol.fix;

public class FixSessionException extends Exception {

	private static final long serialVersionUID = -1L;
	
	public byte[] text;
	public long refTagID = 0;
	public byte[] refMsgType = new byte[0];
	public long sessionRejectReason = 0;	
	
	public FixSessionException(long sessionRejectReason, byte[] text, long refTagID, byte[] refMsgType) {
		this.sessionRejectReason = sessionRejectReason;
		this.text = text;
		this.refTagID = refTagID;
		if (refMsgType != null) this.refMsgType = refMsgType;
	}
	
/*	public FixSessionException(long sessionRejectReason, byte[] text) {
		this.sessionRejectReason = sessionRejectReason;
		this.text = text;
	}*/

	@Override
	public String getMessage() {
		String txt = text==null?"null":new String(text);
		String ref = refMsgType==null?"null":new String(refMsgType);
		return sessionRejectReason + ": " + "text=" + txt + " refTagID=" + refTagID + " refMsgType=" + ref;
	}


}
