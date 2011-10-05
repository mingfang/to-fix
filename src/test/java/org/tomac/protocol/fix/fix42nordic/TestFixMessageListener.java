/**
 * Copyright (c) 2011 Sebastian Tomac (tomac.org)
 * Licensed under LGPL licenses.
 * You may obtain a copy of the License at http://www.gnu.org/copyleft/lgpl.html
 **/
package org.tomac.protocol.fix.fix42nordic;

import org.tomac.protocol.fix.messaging.FixExecutionReport;
import org.tomac.protocol.fix.messaging.FixHeartbeat;
import org.tomac.protocol.fix.messaging.FixLogon;
import org.tomac.protocol.fix.messaging.FixLogout;
import org.tomac.protocol.fix.messaging.FixMessage;
import org.tomac.protocol.fix.messaging.FixMessageListener;
import org.tomac.protocol.fix.messaging.FixNewOrderSingle;
import org.tomac.protocol.fix.messaging.FixOrderCancelReject;
import org.tomac.protocol.fix.messaging.FixOrderCancelReplaceRequest;
import org.tomac.protocol.fix.messaging.FixOrderCancelRequest;
import org.tomac.protocol.fix.messaging.FixReject;
import org.tomac.protocol.fix.messaging.FixRejectedCancelReplace;
import org.tomac.protocol.fix.messaging.FixResendRequest;
import org.tomac.protocol.fix.messaging.FixSequenceReset;
import org.tomac.protocol.fix.messaging.FixTestRequest;


/**
 * @author seto
 *
 */
public class TestFixMessageListener implements FixMessageListener {

	@Override
	public void onUnknownMessageType(FixMessage msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixExecutionReport(FixExecutionReport msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixHeartbeat(FixHeartbeat msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixLogon(FixLogon msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixLogout(FixLogout msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixNewOrderSingle(FixNewOrderSingle msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixOrderCancelReject(FixOrderCancelReject msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixRejectedCancelReplace(FixRejectedCancelReplace msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixOrderCancelReplaceRequest(FixOrderCancelReplaceRequest msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixOrderCancelRequest(FixOrderCancelRequest msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixReject(FixReject msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixResendRequest(FixResendRequest msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixSequenceReset(FixSequenceReset msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFixTestRequest(FixTestRequest msg) {
		// TODO Auto-generated method stub
		
	}

}
