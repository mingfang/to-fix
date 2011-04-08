/**
 * Copyright (c) 2011 Sebastian Tomac (tomac.org)
 * Licensed under LGPL licenses.
 * You may obtain a copy of the License at http://www.gnu.org/copyleft/lgpl.html
 **/
package org.tomac.fix.example;


import java.nio.ByteBuffer;

import org.junit.Before;
import org.junit.Test;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.messaging.FixLogon;
import org.tomac.protocol.fix.messaging.FixLogout;
import org.tomac.protocol.fix.messaging.FixMessageListenerImpl;
import org.tomac.protocol.fix.messaging.FixMessageParser;
import org.tomac.protocol.fix.messaging.FixMessagePool;

/**
 * @author seto
 *
 */
public class CodeExamples {

	@Test
	public void simpleCodeExample() {
		// out bound message
		FixLogon logon = new FixLogon();
		// populate the fields
		logon.setHeartBtInt(10);
		// get field values
		long heartBtInt = logon.getHeartBtInt();

		ByteBuffer buf = ByteBuffer.wrap(new String("8=FIXT.1.1\u00019=75\u000135=A\u000149=TOC\u000156=TOMAC\u000134=1\u000150=TOC\u000157=S\u000152=20110211-05:40:09.425\u000198=0\u0001108=30\u000110=167\u0001").getBytes());
		// In-bound message from raw fix message byte buffer
		FixLogout logout = new FixLogout();
		// err will contain potential validation errors in the message buffer
		FixValidationError err = new FixValidationError();
		logout.setBuffer(buf, err);
		// if (err.hasError()).. check for SessionRejectReason errors
		// get field values
		byte[] beginString = logout.standardHeader.getBeginString();
		// ...
	}
	
	@Test
	public void SimpleExampleUsingMessagePool() {
		FixMessagePool<FixMessage> pool = new FixMessagePool<FixMessage>();
		FixValidationError err = new FixValidationError();
		ByteBuffer buf = ByteBuffer.wrap(new String("8=FIXT.1.1\u00019=75\u000135=A\u000149=TOC\u000156=TOMAC\u000134=1\u000150=TOC\u000157=S\u000152=20110211-05:40:09.425\u000198=0\u0001108=30\u000110=167\u0001").getBytes());
		// in-bound message from your message Pool and raw fix message byteBuffer
		FixLogon inLogon = (FixLogon) pool.getFixMessage(buf, err);
		// process the message, then return it to to pool
		pool.returnFixLogon(inLogon);
		
		// out bound message from your message Pool
		FixLogon logon = pool.getFixLogon();
		// populate the fields
		logon.setHeartBtInt(10);
		// convert to raw message for sending..
		ByteBuffer out = ByteBuffer.allocate(1024);
		logon.encode(out);
		// when you are done return the message to the pool
		pool.returnFixLogon(logon);
		
		
	}
	
	@Test
	public void ProperExampleMessageListener() {
		// create a listener, parser and error holder for in-bound FIX messages
		MyFixMessageListener listener = new MyFixMessageListener();
		FixValidationError err = new FixValidationError();
		FixMessagePool<FixMessage> pool = new FixMessagePool<FixMessage>();
		FixMessageParser parser = new FixMessageParser(pool);
		
		ByteBuffer buf = ByteBuffer.wrap(new String("8=FIXT.1.1\u00019=75\u000135=A\u000149=TOC\u000156=TOMAC\u000134=1\u000150=TOC\u000157=S\u000152=20110211-05:40:09.425\u000198=0\u0001108=30\u000110=167\u0001").getBytes());
		// the buf ByteBuffer contains the raw fix message
		parser.parse(buf, err, listener);
		
	}
	
	public class MyFixMessageListener extends FixMessageListenerImpl { // or implements FixMessageListener

		@Override
	    public void onFixLogon( FixLogon msg ) { 
			//handle the FIX logon message
			long heartBtInt = msg.getHeartBtInt();
			//...
			// and when done the message is returned to the pool. If (only if!) you need to keep it you have to clone it.
			// FixLogon logon = msg.clone();
		}
	}
}
