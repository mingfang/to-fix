package org.tomac.protocol.fix.fix50sp2;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.nio.ByteBuffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessage;
import org.tomac.protocol.fix.messaging.fix50sp2.FixExecutionReport;

public class TestFixContainerSession {

	FixExecutionReport msg;
	FixExecutionReport msg2;
	ByteBuffer buf;
	ByteBuffer out;
	String testHeader;
	String testBody;
	String testTrailer;
	
	@Before
	public void setUp() throws Exception {
		FixMessage.IGNORE_CHECKSUM = false;
		
		buf = ByteBuffer.allocate(1024);
		out = ByteBuffer.allocate(1024);
		
		msg = new FixExecutionReport();
		msg2 = new FixExecutionReport();

		testHeader = "8=FIXT.1.1\u0001" + "9=0257\u0001" + "35=8\u0001" + "34=8337\u0001" + "49=INORD\u0001" + 
		"56=TOM\u0001" + "52=20110505-11:23:18.445\u0001" + "50=S\u0001" + "57=TOMA01\u0001";
		
		testBody = "6=0.0\u0001" + "11=FDEWEEEWDEGPCW\u0001" + "14=0\u0001" + "15=SEK\u0001" + 
		"17=9988:012395:FDEWEEEWDEGPCW\u0001" + "66=0\u0001" + "37=001499881\u0001" + "38=2000\u0001" + 
		"39=0\u0001" + "44=42.51\u0001" + "528=P\u0001" + "54=2\u0001" + 
		"55=5095\u0001" + "48=SE0000777925\u0001"+ "59=0\u0001" + "150=0\u0001" + "151=2000\u0001" + "1089=182\u0001" + 
		"494=TOM\u0001" + "1030=WARP\u0001";
		
		testTrailer = "10=057\u0001";
		
		System.setProperty("useNasdaq", "false");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCorrectMessage() {
		byte[] msgByteArray = (testHeader + testBody + testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			int msgType = FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();

			// validate msg type.
			assertEquals(FixUtils.EXECUTIONREPORT_INT, msgType);
			
			// just check we got some data
			assertEquals(20000000, msg.orderQtyData.orderQty);
			
		} catch( FixGarbledException e )  {
			fail(e.getMessage());
		} catch( FixSessionException e ) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testDecodeEncodeMessage() {
		String inMsg = (testHeader + testBody + testTrailer);
		byte[] msgByteArray = inMsg.getBytes();
		byte[] tmp = new byte[1024];
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			// Decode the message
			int msgType = FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();

			// validate msg type.
			assertEquals(FixUtils.EXECUTIONREPORT_INT, msgType);
			
			// just check we got some data
			assertEquals(20000000, msg.orderQtyData.orderQty);
			
			// Encode the message
			msg.encode(out);
			
			out.get(tmp, 0, out.limit());
			
			// Encode again as tag order may change, and the message is still equal.
			buf.clear();
			buf.put(tmp, 0, out.limit());
			buf.position(0);

			msgType = FixMessage.crackMsgType(buf);

			msg2.setBuffer(buf);
			
			msg2.getAll();
			
			assertTrue(msg + " : m" + msg2, msg.equals(msg2));
			
		} catch( FixGarbledException e )  {
			fail(e.getMessage());
		} catch( FixSessionException e ) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * What constitutes a garbled message
	 * •	BeginString (tag #8) is not the first tag in a message or is not of the format 8=FIXT.n.m.
	 * •	BodyLength (tag #9) is not the second tag in a message or does not contain the correct byte count.
	 * •	MsgType (tag #35) is not the third tag in a message.
	 * •	Checksum (tag #10) is not the last tag or contains an incorrect value.
	 * If the MsgSeqNum(tag #34) is missing a logout message should be sent terminating the FIX Connection, 
	 * as this indicates a serious application error that is likely only circumvented by software modification.
	 */
	
	/**
	 * Garbled message received
	 */
	@Test
	public void test2d_GarbledMessageReceived() {
		byte[] msgByteArray = ( testBody + testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixGarbledException e )  {
			assertTrue(e.getMessage(), e.getMessage().startsWith("First tag in FIX message is not BEGINSTRING (8)"));
		} catch( FixSessionException e ) {
			fail(e.getMessage());
		}
		
	}

	/**
	 * BeginString value (e.g. "FIXT.1.1") received did not match value expected and specified in 
	 * testing profile or does not match BeginString on outbound messages.
	 */
	@Test
	public void test2i_InvalidBeginString() {
		testHeader = "8=FIX.4.3\u0001" + "9=0257\u0001" + "35=8\u0001" + "34=8337\u0001" + "49=INORD\u0001" + 
		"56=TOM\u0001" + "52=20110505-11:23:18.445\u0001" + "50=S\u0001" + "57=TOMA01\u0001";

		testTrailer = "10=234\u0001";
		
		byte[] msgByteArray = ( testHeader + testBody + testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixSessionException e )  {
			assertTrue(e.getMessage(), e.getMessage().startsWith("Framing Exception: (BeginString not equal to: FIXT.1.1)"));
		} catch( FixGarbledException e ) {
			fail(e.getMessage());
		}		
	}
	
	/**
	 * BodyLength value received is not correct.
	 */
	@Test 
	public void test2m_InvalidBodyLength() {
		testHeader = "8=FIXT.1.1\u0001" + "9=0268\u0001" + "35=8\u0001" + "34=8337\u0001" + "49=INORD\u0001" + 
		"56=TOM\u0001" + "52=20110505-11:23:18.445\u0001" + "50=S\u0001" + "57=TOMA01\u0001";

		testTrailer = "10=122\u0001";
		
		String extraBytesSoWeReadTheFullMessage = "123456789FG";
		
		byte[] msgByteArray = ( testHeader + testBody + testTrailer + extraBytesSoWeReadTheFullMessage).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixGarbledException e )  {
			assertTrue(e.getMessage().startsWith("Final tag in FIX message is not CHECKSUM (10)"));
		} catch( FixSessionException e ) {
			fail(e.getMessage());
		}				
	}

	/**
	 * MsgType value received is not valid (defined in spec or classified as user-defined).
	 */
	@Test
	public void test2q_InvalidMsgType() {
		testHeader = "8=FIXT.1.1\u0001" + "9=0257\u0001" + "35=X\u0001" + "34=8337\u0001" + "49=INORD\u0001" + 
		"56=TOM\u0001" + "52=20110505-11:23:18.445\u0001" + "50=S\u0001" + "57=TOMA01\u0001";

		testTrailer = "10=89\u0001";
		
		String extraBytesSoWeReadTheFullMessage = "123456789FG";
		
		byte[] msgByteArray = ( testHeader + testBody + testTrailer + extraBytesSoWeReadTheFullMessage).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixSessionException e )  {
			assertTrue(e.getMessage(), e.getMessage().startsWith("Framing Exception: (MsgType not in specification: X)"));
		} catch( FixGarbledException e ) {
			fail(e.getMessage());
		}		
	}

	/**
	 * MsgType value received is valid (defined in spec or classified as user-defined) but not supported or 
	 * registered in testing profile.
	 */
	@Ignore
	@Test 
	public void test2r_ValidMsgTypeButNotHandled() {
		// stupid demand will not support.
	}

	/**
	 * BeginString, BodyLength, and MsgType are not the first three fields of message.
	 */
	@Test 
	public void test2t_CheckFirstThreeTags() {
		byte[] msgByteArray = ( testBody + testHeader + testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixGarbledException e )  {
			assertTrue(e.getMessage().startsWith("First tag in FIX message is not BEGINSTRING (8)"));
		} catch( FixSessionException e ) {
			fail(e.getMessage());
		}		
		
	}

	/**
	 * Invalid CheckSum 
	 */
	@Test 
	public void test3b_IncorrectCheckSum() {
		testTrailer = "10=126\u0001";
		byte[] msgByteArray = ( testHeader + testBody + testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixGarbledException e )  {
			assertTrue(e.getMessage(), e.getMessage().startsWith("Checksum mismatch; calculated: 57 is not equal message checksum: 126"));
		} catch( FixSessionException e ) {
			fail(e.getMessage());
		}		
	}

	/**
	 * Garbled message trailer
	 */
	@Test 
	public void test3c_GarbledTrailer() {
		// CheckSum with no '='
		testTrailer = "10121\u0001";
		byte[] msgByteArray = ( testHeader + testBody + testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixGarbledException e )  {
			assertTrue(e.getMessage().startsWith("Final tag in FIX message is not CHECKSUM (10)"));
		} catch( FixSessionException e ) {
			fail(e.getMessage());
		}		
	}

	/**
	 * CheckSum is not the last field of message, 
	 * value does not have length of 3, or is not delimited by <SOH>.
	 */
	@Test 
	public void test3d_InvalidCheckSum() {
		// CheckSum with no value
		testTrailer = "10=11\u0001";
		byte[] msgByteArray = ( testHeader + testBody +  testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixGarbledException e )  {
			assertTrue(e.getMessage(), e.getMessage().startsWith("Checksum mismatch; calculated: 57 is not equal message checksum: 11"));
		} catch( FixSessionException e ) {
			fail(e.getMessage());
		}		
	}

	/**
	 * Receive field identifier (tag number) not defined in specification.  
	 * Exception: undefined tag used is specified in testing profile as user-defined.
	 */
	@Test 
	public void test14a_InvalidTag() {
		// add invalid tag(99)
		testBody = "6=0.0\u0001" + "11=FDEWEEEWDEGPCW\u0001" + "14=0\u0001" + "99=SEK\u0001" + 
		"17=9988:012395:FDEWEEEWDEGPCW\u0001" + "66=0\u0001" + "37=001499881\u0001" + "38=2000\u0001" + 
		"39=0\u0001" + "44=42.51\u0001" + "528=P\u0001" + "54=2\u0001" + 
		"55=5095\u0001" + "48=SE0000777925\u0001" + "59=0\u0001" + "150=0\u0001" + "151=2000\u0001" + "1089=182\u0001" + 
		"494=TOM\u0001" + "1030=WARP\u0001";

		testTrailer = "10=69\u0001";

		byte[] msgByteArray = ( testHeader + testBody +  testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixSessionException e )  {
			assertTrue(e.getMessage(), e.getMessage().startsWith("Framing Exception: (Unknown tag: 99)"));
		} catch( FixGarbledException e ) {
			fail(e.getMessage());
		}		
	}

	/**
	 * Receive message with a required field identifier (tag number) missing.
	 */
	@Test 
	public void test14b_RequiredTagMissing() {
		// OrderID (37) missing
		testHeader = "8=FIXT.1.1\u0001" + "9=0244\u0001" + "35=8\u0001" + "34=8337\u0001" + "49=INORD\u0001" + 
		"56=TOM\u0001" + "52=20110505-11:23:18.445\u0001" + "50=S\u0001" + "57=TOMA01\u0001";
		
		testBody = "6=0.0\u0001" + "11=FDEWEEEWDEGPCW\u0001" + "14=0\u0001" + "15=SEK\u0001" + 
		"17=9988:012395:FDEWEEEWDEGPCW\u0001" + "66=0\u0001" + "38=2000\u0001" + 
		"39=0\u0001" + "44=42.51\u0001" + "528=P\u0001" + "54=2\u0001" + 
		"55=5095\u0001" + "48=SE0000777925\u0001" + "59=0\u0001" + "150=0\u0001" + "151=2000\u0001" + "1089=182\u0001" + 
		"494=TOM\u0001" + "1030=WARP\u0001";

		testTrailer = "10=181\u0001";

		byte[] msgByteArray = ( testHeader + testBody +  testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixSessionException e )  {
			assertTrue(e.getMessage(), e.getMessage().startsWith("Framing Exception: (Required tag missing: 37)"));
		} catch( FixGarbledException e ) {
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}
	
	/**
	 * Receive message with field identifier (tag number) which is defined in the specification but not defined 
	 * for this message type.
	 * Exception:  undefined tag used is specified in testing profile as user-defined for this message type.
	 */
	@Test 
	public void test14c_ValidTagButInvalidForMessage() {
		// RefSeqNum(45) in ExecutionReport not allowed.
		testBody = "6=0.0\u0001" + "11=FDEWEEEWDEGPCW\u0001" + "14=0\u0001" + "45=REF\u0001" + 
		"17=9988:012395:FDEWEEEWDEGPCW\u0001" + "66=0\u0001" + "37=001499881\u0001" + "38=2000\u0001" + 
		"39=0\u0001" + "44=42.51\u0001" + "528=P\u0001" + "54=2\u0001" + 
		"55=5095\u0001" + "48=SE0000777925\u0001" + "59=0\u0001" + "150=0\u0001" + "151=2000\u0001" + "1089=182\u0001" + 
		"494=TOM\u0001" + "1030=WARP\u0001";

		testTrailer = "10=54\u0001";

		byte[] msgByteArray = ( testHeader + testBody +  testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixSessionException e )  {
			assertTrue(e.getMessage(), e.getMessage().startsWith("Framing Exception: (Unknown tag: 45)"));
		} catch( FixGarbledException e ) {
			fail(e.getMessage());
		}				
	}
	
	/**
	 * Receive message with field identifier (tag number) specified but no value 
	 * (e.g. "55=<SOH>" vs. "55=IBM<SOH>").
	 */
	@Test 
	public void test14d_TagWithNoValue() {
		// Currency(15) has no value.
		testHeader = "8=FIXT.1.1\u0001" + "9=0254\u0001" + "35=8\u0001" + "34=8337\u0001" + "49=INORD\u0001" + 
		"56=TOM\u0001" + "52=20110505-11:23:18.445\u0001" + "50=S\u0001" + "57=TOMA01\u0001";
		
		testBody = "6=0.0\u0001" + "11=FDEWEEEWDEGPCW\u0001" + "14=0\u0001" + "15=\u0001" + 
		"17=9988:012395:FDEWEEEWDEGPCW\u0001" + "66=0\u0001" + "37=001499881\u0001" + "38=2000\u0001" + 
		"39=0\u0001" + "44=42.51\u0001" + "528=P\u0001" + "54=2\u0001" + 
		"55=5095\u0001" + "48=SE0000777925\u0001" + "59=0\u0001" + "150=0\u0001" + "151=2000\u0001" + "1089=182\u0001" + 
		"494=TOM\u0001" + "1030=WARP\u0001";

		testTrailer = "10=83\u0001";

		byte[] msgByteArray = ( testHeader + testBody +  testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + msg);
		} catch( FixSessionException e )  {
			assertTrue(e.getMessage(), e.getMessage().startsWith("Framing Exception: (Tag specified without a value)"));
		} catch( FixGarbledException e ) {
			fail(e.getMessage());
		}				
		
	}	

	/**
	 * Receive message with incorrect value (out of range or not part of valid list of 
	 * enumerated values) for a particular field identifier (tag number).
	 * Exception:  undefined enumeration values used are specified in testing profile as user-defined.

	 */
	@Test 
	public void test14e_InvalidEnumeratedValue() {
		// Side(54) has invalid enum (9).
		testHeader = "8=FIXT.1.1\u0001" + "9=0257\u0001" + "35=8\u0001" + "34=8337\u0001" + "49=INORD\u0001" + 
		"56=TOM\u0001" + "52=20110505-11:23:18.445\u0001" + "50=S\u0001" + "57=TOMA01\u0001";
		
		testBody = "6=0.0\u0001" + "11=FDEWEEEWDEGPCW\u0001" + "14=0\u0001" + "15=SEK\u0001" + 
		"17=9988:012395:FDEWEEEWDEGPCW\u0001" + "66=0\u0001" + "37=001499881\u0001" + "38=2000\u0001" + 
		"39=0\u0001" + "44=42.51\u0001" + "528=P\u0001" + "54=9\u0001" + 
		"55=5095\u0001" + "48=SE0000777925\u0001" + "59=0\u0001" + "150=0\u0001" + "151=2000\u0001" + "1089=182\u0001" + 
		"494=TOM\u0001" + "1030=WARP\u0001";

		testTrailer = "10=64\u0001";

		byte[] msgByteArray = ( testHeader + testBody +  testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixSessionException e )  {
			assertTrue(e.getMessage(), e.getMessage().startsWith("Framing Exception: (Invalid enumerated value(57) for tag: 54)"));
		} catch( FixGarbledException e ) {
			fail(e.getMessage());
		}			
	}
	
	/**
	 * Receive message with a value in an incorrect data format (syntax) for a particular field 
	 * identifier (tag number).
	 */
	@Test 
	public void test14f_InvalidValue() {
		// Price(44) is not numeric.
		testHeader = "8=FIXT.1.1\u0001" + "9=0257\u0001" + "35=8\u0001" + "34=8337\u0001" + "49=INORD\u0001" + 
		"56=TOM\u0001" + "52=20110505-11:23:18.445\u0001" + "50=S\u0001" + "57=TOMA01\u0001";
		
		testBody = "6=0.0\u0001" + "11=FDEWEEEWDEGPCW\u0001" + "14=0\u0001" + "15=SEK\u0001" + 
		"17=9988:012395:FDEWEEEWDEGPCW\u0001" + "66=0\u0001" + "37=001499881\u0001" + "38=2000\u0001" + 
		"39=0\u0001" + "44=A2.51\u0001" + "528=P\u0001" + "54=9\u0001" + 
		"55=5095\u0001" + "48=SE0000777925\u0001" + "59=0\u0001" + "150=0\u0001" + "151=2000\u0001" + "1089=182\u0001" + 
		"494=TOM\u0001" + "1030=WARP\u0001";

		testTrailer = "10=77\u0001";

		byte[] msgByteArray = ( testHeader + testBody +  testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixSessionException e )  {
			assertTrue(e.getMessage(), e.getMessage().startsWith("Framing Exception: (Incorrect data format for value)"));
		} catch( FixGarbledException e ) {
			fail(e.getMessage());
		}				
	}
	
	/**
	 * Receive a message in which the following is not true:  
	 * Standard Header fields appear before Body fields which appear before Standard Trailer fields.
	 */
	@Test 
	public void test14g_IncorrectHeaderBodyTrailerOrder() {
		// Trailer before body

		byte[] msgByteArray = ( testHeader + testTrailer + testBody  ).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixGarbledException e )  {
			assertTrue(e.getMessage().startsWith("Final tag in FIX message is not CHECKSUM (10)"));
		} catch( FixSessionException e ) {
			fail(e.getMessage());
		}					
	}
	
	/**
	 * Receive a message in which a field identifier (tag number) which is not part of a repeating group 
	 * is specified more than once 
	 */
	@Ignore // TODO simple to implement but costly in terms of computations
	@Test 
	public void test14h_RepeatedTag() {
		// Price(44) repeated
		testHeader = "8=FIXT.1.1\u0001" + "9=0266\u0001" + "35=8\u0001" + "34=8337\u0001" + "49=INORD\u0001" + 
		"56=TOM\u0001" + "52=20110505-11:23:18.445\u0001" + "50=S\u0001" + "57=TOMA01\u0001";
		
		testBody = "6=0.0\u0001" + "11=FDEWEEEWDEGPCW\u0001" + "14=0\u0001" + "15=SEK\u0001" + 
		"17=9988:012395:FDEWEEEWDEGPCW\u0001" + "66=0\u0001" + "37=001499881\u0001" + "38=2000\u0001" + 
		"39=0\u0001" + "44=12.51\u0001" + "44=12.51\u0001" + "528=P\u0001" + "54=2\u0001" + 
		"55=5095\u0001" + "48=SE0000777925\u0001" + "59=0\u0001" + "150=0\u0001" + "151=2000\u0001" + "1089=182\u0001" + 
		"494=TOM\u0001" + "1030=WARP\u0001";

		testTrailer = "10=19\u0001";

		byte[] msgByteArray = ( testHeader + testBody +  testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixSessionException e )  {
			assertTrue(e.getMessage().startsWith("Repeated tag: 44"));
		} catch( FixGarbledException e ) {
			fail(e.getMessage());
		}					
	}

	/**
	 * Receive a message with repeating groups in which the "count" field value for a repeating group is incorrect.
	 */
	@Test 
	public void test14i_RepatingGroupCountIncorrect() {
		// no repeating groups in INET Nordic FIX 4.2
		fail();
	}

	/**
	 * Receive a message with repeating groups in which the order of repeating group fields does not match 
	 * the specification.
	 */
	@Test 
	public void test14j_IncorrectRepeatingGroupTagOrder() {
		// no repeating groups in INET Nordic FIX 4.2
		fail();
	}

	/**
	 * Receive a message with a field of a data type other than "data" which contains one 
	 * or more embedded <SOH> values.
	 */
	@Test 
	public void test14k_EmbeddedSOH() {
		// Currency(15) with embedded SOH
		testHeader = "8=FIXT.1.1\u0001" + "9=0257\u0001" + "35=8\u0001" + "34=8337\u0001" + "49=INORD\u0001" + 
		"56=TOM\u0001" + "52=20110505-11:23:18.445\u0001" + "50=S\u0001" + "57=TOMA01\u0001";
		
		testBody = "6=0.0\u0001" + "11=FDEWEEEWDEGPCW\u0001" + "14=0\u0001" + "15=S\u0001K\u0001" + 
		"17=9988:012395:FDEWEEEWDEGPCW\u0001" + "66=0\u0001" + "37=001499881\u0001" + "38=2000\u0001" + 
		"39=0\u0001" + "44=42.51\u0001" + "528=P\u0001" + "54=2\u0001" + 
		"55=5095\u0001" + "48=SE0000777925\u0001" + "59=0\u0001" + "150=0\u0001" + "151=2000\u0001" + "1089=182\u0001" + 
		"494=TOM\u0001" + "1030=WARP\u0001";
		testTrailer = "10=245\u0001";

		byte[] msgByteArray = ( testHeader + testBody +  testTrailer).getBytes();
		
		buf.put(msgByteArray);
		buf.position(0);
		
		try {
			FixMessage.crackMsgType(buf);
			
			msg.setBuffer(buf);
			
			msg.getAll();
			
			fail("In msg is invalid: " + new String(msgByteArray));
		} catch( FixSessionException e )  {
			fail(e.getMessage());
		} catch ( FixGarbledException e ) {
			fail(e.getMessage());
		} catch( NumberFormatException e ) {
			assertTrue(true);
		}					
	}

	/**
	 * Receive a message in which a conditionally required field is missing.
	 */
	@Ignore
	@Test 
	public void test14m_ConditionallyFiledIsMissing() {
		// Application layer INET Nordic FIX 4.2
	}

	/**
	 * Receive a message in which a field identifier (tag number) appears in both cleartext and encrypted 
	 * section but has different values.
	 */
	@Ignore
	@Test 
	public void test14n_TagInBotheEncrypedAndNonEncryptedSecion() {
		// no encryption in INET Nordic FIX 4.2
	}

}
