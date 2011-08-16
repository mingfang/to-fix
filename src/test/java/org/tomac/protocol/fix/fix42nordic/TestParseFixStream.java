package org.tomac.protocol.fix.fix42nordic;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.fix42nordic.FixAcceptedCancel;
import org.tomac.protocol.fix.messaging.fix42nordic.FixAcceptedCancelReplace;
import org.tomac.protocol.fix.messaging.fix42nordic.FixApplicationReject;
import org.tomac.protocol.fix.messaging.fix42nordic.FixBreakNotification;
import org.tomac.protocol.fix.messaging.fix42nordic.FixBusinessReject;
import org.tomac.protocol.fix.messaging.fix42nordic.FixCancelNotification;
import org.tomac.protocol.fix.messaging.fix42nordic.FixEntryNotificationtoAllegedFirm;
import org.tomac.protocol.fix.messaging.fix42nordic.FixExecutionReportFill;
import org.tomac.protocol.fix.messaging.fix42nordic.FixExecutionRestatement;
import org.tomac.protocol.fix.messaging.fix42nordic.FixHeartbeat;
import org.tomac.protocol.fix.messaging.fix42nordic.FixLockedinNotification;
import org.tomac.protocol.fix.messaging.fix42nordic.FixLockedinTradeBreak;
import org.tomac.protocol.fix.messaging.fix42nordic.FixLogon;
import org.tomac.protocol.fix.messaging.fix42nordic.FixLogout;
import org.tomac.protocol.fix.messaging.fix42nordic.FixMessage;
import org.tomac.protocol.fix.messaging.fix42nordic.FixMessageListener;
import org.tomac.protocol.fix.messaging.fix42nordic.FixMessageParser;
import org.tomac.protocol.fix.messaging.fix42nordic.FixOrderAcknowledgement;
import org.tomac.protocol.fix.messaging.fix42nordic.FixOrderCancelReject;
import org.tomac.protocol.fix.messaging.fix42nordic.FixOrderCancelReplaceRequest;
import org.tomac.protocol.fix.messaging.fix42nordic.FixOrderCancelRequest;
import org.tomac.protocol.fix.messaging.fix42nordic.FixOrderReject;
import org.tomac.protocol.fix.messaging.fix42nordic.FixOrderSingle;
import org.tomac.protocol.fix.messaging.fix42nordic.FixPendingCancel;
import org.tomac.protocol.fix.messaging.fix42nordic.FixReject;
import org.tomac.protocol.fix.messaging.fix42nordic.FixRejectedCancelReplace;
import org.tomac.protocol.fix.messaging.fix42nordic.FixResendRequest;
import org.tomac.protocol.fix.messaging.fix42nordic.FixSequenceReset;
import org.tomac.protocol.fix.messaging.fix42nordic.FixTestRequest;
import org.tomac.protocol.fix.messaging.fix42nordic.FixTradeEntryNotificationtoEnteringFirm;
import org.tomac.protocol.fix.messaging.fix42nordic.FixTradeReportCancel;
import org.tomac.protocol.fix.messaging.fix42nordic.FixTradeReportEntry;
import org.tomac.utils.Utils;

public class TestParseFixStream {
	/**
	 * to rerun a "realworld" raw FIX log through the parser; 1. decoder 2.
	 * encode 3. validate
	 */
	String RAW_FIX_LOG = "sample-raw-fix-log-fix42nordic.fix";
	int FIX_MAX_MESSAGE_LENGTH = 1024;

	byte[] flipByteArray;
	byte[] readByteArray;
	ByteBuffer buf;
	FixMessageParser parser;
	FixMessageListener listener;

	@Before
	public void setUp() throws Exception {
		flipByteArray = new byte[FIX_MAX_MESSAGE_LENGTH];
		readByteArray = new byte[FIX_MAX_MESSAGE_LENGTH];
		buf = ByteBuffer.allocate(FIX_MAX_MESSAGE_LENGTH + FIX_MAX_MESSAGE_LENGTH);
		parser = new FixMessageParser();
		listener = new FixMessageListenerImpl();
		System.setProperty("fix.raw", "true");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParesFixStream() {
		File f = new File(RAW_FIX_LOG);
		FixMessage.IGNORE_CHECKSUM = true;
		
		assertTrue(f.isFile() && f.canRead());

		try {
			int read = 0;
			int offset = 0;

			InputStream is = new FileInputStream(f);

			while ((read = is.read(readByteArray, offset, readByteArray.length - offset)) > 0) {

				// find the last checksum tag.Use the readByteArry up till that.
				int endPos = findLastCehcksum(readByteArray, offset, read - offset);
				
				if (endPos < 0) fail("no checksum");
				
				buf.clear();
				buf.put(readByteArray, 0, endPos); 

				// calc new readByteArray offset and move trailng bytes to begining of buffer
				offset = readByteArray.length - endPos;
				Utils.copy(readByteArray, endPos, readByteArray, 0, offset);

				buf.flip();
				
				//System.out.println("Read data: " + new String(buf.array()));
				//System.out.println("readByteArray: " + new String(readByteArray));

				while (buf.hasRemaining()) {

					ByteBuffer curr = buf.slice();
						
					try {

						parser.parse(curr, listener);
						
						buf.position(buf.position() + curr.limit());
						
					} catch (FixGarbledException e) {
						fail(e.getMessage());
					} catch (FixSessionException e) {
						fail(e.getMessage());
					}
					
				}

			}
		} catch (IOException e) {
			fail(e.getMessage());
		}

	}

	private int findLastCehcksum(byte[] buf, int offset, int len) {
		int sohPos = -1;
			
		for (int i = buf.length - 1; i >= 0; i --) {
			
			if (buf[i]== FixUtils.SOH) sohPos = i;
			
			if (sohPos != -1 && buf[i] == (byte)FixUtils.EQL) {
				if (i > 3  && buf[i - 1] == (byte)'0' && buf[i-2] == (byte)'1' && buf[i-3] == FixUtils.SOH) 
					return sohPos + 1;
			}
		}
		return -1;
	}

	private class FixMessageListenerImpl implements FixMessageListener {

		private void printIt(FixMessage msg) {
			try {
				msg.getAll();

				if (Boolean.getBoolean("fix.raw")) {
					ByteBuffer out = ByteBuffer.allocate(1024);
					msg.encode(out);
					byte[] outArray = new byte[out.limit()];
					//msg.buf.position(0);
					//msg.buf.get(outArray, 0, msg.buf.limit() - 1);
					//System.out.println(new String(outArray));
					out.get(outArray);
					System.out.println(new String(outArray));
				} else {
					System.out.println(msg.toString());
				}
				msg.clear();
			} catch (FixSessionException e) {
				e.printStackTrace();
			} catch (FixGarbledException e) {
				e.printStackTrace();
			}
		}

		/**
		 * FixMessageListenre methods
		 */

		@Override
		public void onUnknownMessageType(ByteBuffer msg, int msgType) {
		}

		@Override
		public void onFixAcceptedCancelReplace(FixAcceptedCancelReplace msg) {
			printIt(msg);
		}

		@Override
		public void onFixAcceptedCancel(FixAcceptedCancel msg) {
			printIt(msg);
		}

		@Override
		public void onFixApplicationReject(FixApplicationReject msg) {
			printIt(msg);

		}

		@Override
		public void onFixBreakNotification(FixBreakNotification msg) {
			printIt(msg);

		}

		@Override
		public void onFixBusinessReject(FixBusinessReject msg) {
			printIt(msg);

		}

		@Override
		public void onFixCancelNotification(FixCancelNotification msg) {
			printIt(msg);

		}

		@Override
		public void onFixEntryNotificationtoAllegedFirm(FixEntryNotificationtoAllegedFirm msg) {
			printIt(msg);

		}

		@Override
		public void onFixExecutionReportFill(FixExecutionReportFill msg) {
			printIt(msg);

		}

		@Override
		public void onFixExecutionRestatement(FixExecutionRestatement msg) {
			printIt(msg);

		}

		@Override
		public void onFixLockedinNotification(FixLockedinNotification msg) {
			printIt(msg);

		}

		@Override
		public void onFixLockedinTradeBreak(FixLockedinTradeBreak msg) {
			printIt(msg);

		}

		@Override
		public void onFixOrderAcknowledgement(FixOrderAcknowledgement msg) {
			printIt(msg);

		}

		@Override
		public void onFixOrderReject(FixOrderReject msg) {
			printIt(msg);

		}

		@Override
		public void onFixPendingCancel(FixPendingCancel msg) {
			printIt(msg);

		}

		@Override
		public void onFixTradeEntryNotificationtoEnteringFirm(FixTradeEntryNotificationtoEnteringFirm msg) {
			printIt(msg);

		}

		@Override
		public void onFixTradeReportCancel(FixTradeReportCancel msg) {
			printIt(msg);

		}

		@Override
		public void onFixTradeReportEntry(FixTradeReportEntry msg) {
			printIt(msg);

		}

		@Override
		public void onFixHeartbeat(FixHeartbeat msg) {
			printIt(msg);

		}

		@Override
		public void onFixLogon(FixLogon msg) {
			printIt(msg);

		}

		@Override
		public void onFixLogout(FixLogout msg) {
			printIt(msg);

		}

		@Override
		public void onFixOrderSingle(FixOrderSingle msg) {
			printIt(msg);

		}

		@Override
		public void onFixOrderCancelReject(FixOrderCancelReject msg) {
			printIt(msg);

		}

		@Override
		public void onFixRejectedCancelReplace(FixRejectedCancelReplace msg) {
			printIt(msg);

		}

		@Override
		public void onFixOrderCancelReplaceRequest(FixOrderCancelReplaceRequest msg) {
			printIt(msg);

		}

		@Override
		public void onFixOrderCancelRequest(FixOrderCancelRequest msg) {
			printIt(msg);

		}

		@Override
		public void onFixReject(FixReject msg) {
			printIt(msg);

		}

		@Override
		public void onFixResendRequest(FixResendRequest msg) {
			printIt(msg);

		}

		@Override
		public void onFixSequenceReset(FixSequenceReset msg) {
			printIt(msg);

		}

		@Override
		public void onFixTestRequest(FixTestRequest msg) {
			printIt(msg);

		}

	}
}
