package org.tomac.protocol.fix;

import org.tomac.protocol.fix.messaging.FixMessageInfo;
import org.tomac.protocol.fix.messaging.FixTags;


public class FixValidationError {
	public int		sessionRejectReason;
	public String	text;

	public int		refTagID;
	public long		refSeqNum;
	public int	    refMsgTypeInt;
	
	public IFixSession session;
	public long	resendRequestMsgSeqNum;


	public void clear() {
		sessionRejectReason = -1;
		session = null;
		text = null;
		refTagID = Integer.MIN_VALUE;
		refMsgTypeInt = -1;
		refSeqNum = -1;
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
		boolean consumer = sessionRejectReason != FixEvent.DISCONNECT &&
		sessionRejectReason != FixEvent.GARBLED &&
		sessionRejectReason != FixEvent.IGNORE_MESSAGE &&
		sessionRejectReason != FixEvent.MSGSEQNUM_RESENDREQUEST; // propbaly MSGSEQNUM_LOGON_RESENDREQUEST also
		
		if (sessionRejectReason == FixMessageInfo.SessionRejectReason.SENDINGTIME_ACCURACY_PROBLEM && session != null)
			if (refSeqNum < session.getInMsgSeqNum()) return false;
		if (sessionRejectReason == FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING && refTagID == FixTags.ORIGSENDINGTIME_INT && session != null)
			if (refSeqNum < session.getInMsgSeqNum()) return false;
		
			
		return consumer;
	}
	
	@Override
	public String toString() {
		return "sessionRejectReason=" + sessionRejectReason + " " + text + " refTagID(" + refTagID + ") refMsgTypeInt(" + refMsgTypeInt + ")";
	}

}
