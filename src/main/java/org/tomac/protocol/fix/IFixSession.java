package org.tomac.protocol.fix;

public interface IFixSession {

	public int getSessionID();

	public void incrementInMsgSeqNum();

	public long getInMsgSeqNum();

	public void setInMsgSeqNum(long msgSeqNum);
	
	public void incrementOutMsgSeqNum();

	public long getOutMsgSeqNum();

	public void setOutMsgSeqNum(long msgSeqNum);

	public boolean isEstablished();
	
	
}
