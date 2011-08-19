package org.tomac.protocol.fix.fix50sp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.ByteBuffer;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.fix50sp2.FixExecutionReport;
import org.tomac.protocol.fix.messaging.fix50sp2.FixLogon;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMarketDataSnapshotFullRefresh;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageParser;
import org.tomac.protocol.fix.messaging.fix50sp2.FixNewOrderSingle;
import org.tomac.protocol.fix.messaging.fix50sp2.FixNews;
import org.tomac.utils.Utils;

public class TestMessages {
	FixMessageListenerTest listener = new FixMessageListenerTest();
	FixMessageParser parser;
	ByteBuffer out = ByteBuffer.allocate(1024);
	
	@Before
	public void setUp() {
		parser = new FixMessageParser();
	}

	@After
	public void tearDown() {
		out.clear();
	}
	
	@Ignore
    @Test
    public void testRepeatingField() throws Exception {
        String data = "8=FIXT.1.1\u00019=65\u000135=D\u000134=2\u000149=TW\u000156=ISLD\u000111=ID\u000121=1\u000140=1\u000154=1\u000140=2\u000138=200\u000155=INTC\u000110=160\u0001";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());

        try {
        	parser.parse(buf, listener);
        } catch (FixSessionException e) {
        	assertTrue(true);
        	//	assertEquals(52.refTagID);
        }
    }

	@Ignore // signature not supported in trailer, as we dont include it in encode
    @Test
    public void testTrailerFieldOrdering() throws Exception {
        final FixNewOrderSingle order = createNewOrderSingle();

        Utils.copy("FOO".getBytes(), 0, order.signature, 0, "FOO".getBytes().length);
        order.signatureLength = 3;

        order.encode(out);
        assertTrue(new String(out.array()), new String(out.array()).contains("89=FOO\u0001"));
    }

    private FixNewOrderSingle createNewOrderSingle() {
    	FixNewOrderSingle msg = new FixNewOrderSingle();
    	Utils.copy(msg.clOrdID, "CLIENT".getBytes());
    	msg.handlInst = FixMessageInfo.HandlInst.AUTOMATED_EXECUTION_ORDER_PRIVATE_NO_BROKER_INTERVENTION;
    	Utils.copy(msg.instrument.symbol,"ORCL".getBytes());
    	msg.side = FixMessageInfo.Side.BUY;
    	Utils.copy(msg.transactTime, Utils.utcTimeOnlyConverter.convert(new Date(0)).getBytes());
    	msg.ordType = FixMessageInfo.OrdType.LIMIT;
    	return msg;
    }
    
    @Ignore // need to go throu all these tests
    @Test
    public void testHeaderGroupParsing() throws Exception {
        ByteBuffer buf = ByteBuffer.wrap("8=FIX.4.2\u00019=061\u000135=A\u0001627=2\u0001628=FOO\u0001628=BAR\u000198=0\u0001384=2\u0001372=D\u0001385=R\u0001372=8\u0001385=S\u000110=228\u0001".getBytes());
    	parser.parse(buf, new FixMessageListenerTest() {
    		@Override
    		public void onFixLogon(FixLogon msg) {
    	        assertEquals("FOO".getBytes(), msg.hopGrp.group[0].hopCompID);
    	        assertEquals("BAR".getBytes(), msg.hopGrp.group[1].hopCompID);
    		}
    	});
    }
    
    private FixExecutionReport createExecutionReport() {
    	FixExecutionReport msg = new FixExecutionReport();
    	Utils.copy(msg.orderID, "ORDER".getBytes());
    	Utils.copy(msg.execID, "EXEC".getBytes());
    	msg.side = FixMessageInfo.Side.BUY;
    	msg.execType = FixMessageInfo.ExecType.TRADE_PARTIAL_FILL_OR_FILL;
    	msg.ordStatus = FixMessageInfo.OrdStatus.FILLED;
    	msg.leavesQty = 100;
    	msg.cumQty = 100;
    	msg.avgPx = 50;
    	return msg;
    }

    @Ignore // TODO encoded not supported yet..
    @Test
    public void testEmbeddedMessage() throws Exception {
        final FixNewOrderSingle order = createNewOrderSingle();
        final FixExecutionReport report = createExecutionReport();
        
        report.encodedTextLen = order.toString().length();
        Utils.copy(report.encodedText, order.toString().getBytes());

        report.encode(out);
        
    	parser.parse(out, new FixMessageListenerTest() {
    		@Override
    		public void onFixExecutionReport(FixExecutionReport msg) {
    	        assertEquals(order.toString(), msg.encodedText);
    		}
    	});
    }

    @Ignore // need to go throu all these tests
    @Test
    public void testParseEmptyString() throws Exception {
        final String data = "";

        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
    	parser.parse(buf,  new FixMessageListenerTest() {
    		@Override
    		public void onUnknownMessageType(ByteBuffer msg, int msgType) {
    	        assertEquals(-1, msgType);
    		}
    	});
    }

    @Ignore
    @Test
    public void testValidation() throws Exception {
        final String data = "8=FIXT.1.19=30935=849=ASX56=CL1_FIX4434=452=20060324-01:05:58"
                + "17=X-B-WOW-1494E9A0:58BD3F9D-1109150=D39=011=18427138=200198=1494E9A0:58BD3F9D"
                + "526=432437=B-WOW-1494E9A0:58BD3F9D55=WOW54=1151=20014=040=244=1559=16=0"
                + "453=3448=AAA35791447=D452=3448=8447=D452=4448=FIX11447=D452=36"
                + "60=20060320-03:34:2910=169";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        final FixExecutionReport msg = new FixExecutionReport();
        msg.setBuffer(buf);
        try {
        	parser.parse(buf,  new FixMessageListenerTest() {
        	});
            } catch (FixSessionException e) {
            	assertTrue(false);
            }
    }

    @Ignore
    @Test 
    public void testValidationWithHops() throws Exception {
        String data = "8=FIXT.1.19=30935=849=ASX56=CL1_FIX4434=452=20060324-01:05:58"
                + "17=X-B-WOW-1494E9A0:58BD3F9D-1109150=D39=011=18427138=200198=1494E9A0:58BD3F9D"
                + "526=432437=B-WOW-1494E9A0:58BD3F9D55=WOW54=1151=20014=040=244=1559=16=0"
                + "453=3448=AAA35791447=D452=3448=8447=D452=4448=FIX11447=D452=36"
                + "60=20060320-03:34:2910=169";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        final FixExecutionReport msg = new FixExecutionReport();
        msg.setBuffer(buf);
        try {
        	parser.parse(buf,  new FixMessageListenerTest() {
        	});
            } catch (FixSessionException e) {
            	assertTrue(false);
            }
    }

    @Ignore
    @Test
    public void testAppMessageValidation() throws Exception {
        final String data = "8=FIXT.1.19=23435=W34=249=ABFX52=20080722-16:37:11.23456=X2RV1"
                + "55=EUR/USD262=CAP0000011268=2269=0270=1.5784415=EUR271=500000272=20080724"
                + "269=1270=1.5786915=EUR271=500000272=2008072410=097";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        final FixMarketDataSnapshotFullRefresh msg = new FixMarketDataSnapshotFullRefresh();
        msg.setBuffer(buf);
        try {
        	parser.parse(buf,  new FixMessageListenerTest() {
        	});
            } catch (FixSessionException e) {
            	assertTrue(false);
            }
    }

    @Ignore
    @Test
    public void testAdminMessageValidation() throws Exception {
        final String data = "8=FIXT.1.19=8435=A49=EXEC56=BANZAI34=152=20080811-13:26:12.409108=1"
                + "141=Y98=01137=710=102";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        try {
    	parser.parse(buf,  new FixMessageListenerTest() {
    	});
        } catch (FixSessionException e) {
        	assertTrue(false);
        }
    }

    @Ignore // need to go throu all these tests
    @Test
    public void testGroupDelimOrdering() throws Exception {
        final FixNewOrderSingle order = new FixNewOrderSingle();
        Utils.copy(order.parties.group[0].partyID, "TraderName".getBytes());
        order.parties.group[0].partyIDSource =
                FixMessageInfo.PartyIDSource.GENERALLY_ACCEPTED_MARKET_PARTICIPANT_IDENTIFIER_EG_NASD_MNEMONI;
        order.parties.group[0].partyRole = 11;
        order.encode(out); 
        assertTrue(new String(out.array()).indexOf("453=1\u0001448=TraderName") != -1);
    }

    @Ignore // need to go throu all these tests
    @Test
    public void testComponentGroupExtraction() throws Exception {
        final FixNewOrderSingle order = new FixNewOrderSingle();
        Utils.copy(order.parties.group[0].partyID, "PARTY_ID_1".getBytes());
        Utils.copy(order.parties.group[1].partyID, "PARTY_ID_2".getBytes());
        assertEquals(2, order.parties.noPartyIDs);
    }

    @Ignore // need to go throu all these tests
    @Test
    public void testHeaderDataField() throws Exception {
    	String data = "8=FIX.4.2\u00019=53\u000135=A\u000190=4\u000191=ABCD\u0001"
                + "98=0\u0001384=2\u0001372=D\u0001385=R\u0001372=8\u0001385=S\u000110=241\u0001";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
    	parser.parse(buf,  new FixMessageListenerTest() {
    		@Override
    		public void onFixLogon(FixLogon msg) {
    	        assertEquals("ABCD".getBytes(), msg.secureData);
    		}
    	});
        
    }

    @Ignore // need to go throu all these tests
    @Test
    public void testInvalidFirstFieldInGroup() throws Exception {
        final FixNews news = new FixNews();
        Utils.copy(news.headline, "Test".getBytes());
        Utils.copy(news.instrmtGrp.group[0].instrument.securityID, "SECID".getBytes());
        Utils.copy(news.instrmtGrp.group[0].instrument.securityIDSource, "SECID_SOURCE".getBytes());

        news.encode(out);
        // TODO we send whatever, nothing is stopping us now!
    }

    @Test
    public void testRequiredGroupValidation() throws Exception {
        final FixNews news = new FixNews();
        Utils.copy(news.headline, "Test".getBytes());
        news.encode(out);
        // TODO we send whatever, nothing is stopping us now!
    }

    /**
     *  Test for data fields with SOH. This test is based on report from a user on
     *  the QuickFIX mailing list. The problem was the user's configuration but this
     *  seems like a good unit test to keep in the suite.
     */
    @Ignore // need to go throu all these tests
    @Test
    public void testDataFieldParsing() throws Exception {
        final String dl = "10001=Canonical.1.00\u000110002=001058\u000125001=01\u000110003=SAPI_ADMRESP\u000110004=SUBSCRIBE_RESP\u0001"
                + "10009=705\u000110012=01\u000110005=SPGW\u000110006=SAPI\u000110007=0\u000110010=16:25:11.537\u0001"
                + "10045=SDQADL:01:/SDB/ENT/@/@/STKSDLL:7\u000110955=Y\u000110963=043\u000110961=03\u000111285=N\u0001"
                + "11339=823,980\u000110919=N\u000111111=86795696\u000110898=043\u000110920=~\u000110938=N\u000111340=5-  9.99\u0001"
                + "11343=0.20\u000111344=~\u000111341=~\u000111342=0.15\u000111345=10- 14.99\u000111348=0.25\u000111349=~\u000111346=~\u0001"
                + "11347=0.15\u000111350=15- 19.99\u000111353=0.30\u000111354=~\u000111351=~\u000111352=0.20\u000111338=23SEP05\u0001"
                + "10981=0\u000110485=N\u000110761=0\u000111220=~\u000111224=N\u000110808=N\u000110921=~\u000110960=N\u000110957=N\u000111329=N\u0001"
                + "11286=0\u000111214=USA\u000110917=Y\u000111288=0\u000110906=N\u000110737=0.01\u000110956=~\u000110967=~\u000110965=~\u000110809=0\u0001"
                + "10762=N\u000110763=N\u000110712=1\u000110905=09:30:00\u000110918=YA0101\u000110951=Y\u000110469=1\u000110949=1\u000110487=Q\u000110950=Y\u0001"
                + "10899=N\u000110380=N\u000110696=03\u000111082=18.41\u000110217=12\u000110954=N\u000110708=E\u000110958=N\u000111213=US \u000111334=N\u0001"
                + "11332=N\u000111331=N\u000111330=N\u000111335=N\u000111333=N\u000110767=3\u000110974=~\u000110980=AIRTRAN HOLDINGS                \u000111289=N\u0001"
                + "10912=4\u000110915=0501\u000110914=0501\u000110975=N\u000110913=SLK\u000110698=055\u000110666=AAI\u000110903=S\u000111328=N\u0001"
                + "10624=L\u000111287=0\u000110699=0\u000110962=L\u000111227=SUB1\u000111229=5\u000111228=1\u000111236=16:24:41.521\u000111277=16:25:11.630\u0001";

		String data = "8=FIX.4.4\u00019=1144\u000135=A\u0001" + "98=0\u0001384=2\u0001372=D\u0001385=R\u0001372=8\u0001385=S\u000195=1092\u0001" + "96=" + dl + "\u000110=5\u0001";
		ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
		
		try {
		parser.parse(buf,  new FixMessageListenerTest() {
			@Override
			public void onFixLogon(FixLogon msg) {
				assertEquals(1144L, msg.bodyLength);
			}
		});
        } catch (FixSessionException e) {
        	assertTrue(false);
        }
    }


    @Test
    public void testFieldOrdering() throws Exception {
        final String data = "8=FIX.4.49=17135=D49=SenderCompId56=TargetCompId11=183339"
                + "22=838=140=244=1248=BHP54=255=BHP59=160=20060223-22:38:33526=3620453=2448=8"
                + "447=D452=4448=AAA35354447=D452=310=168";
        try {
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
    	parser.parse(buf,  new FixMessageListenerTest() {
    	});
        } catch (FixSessionException e) {
        	assertTrue(true);
        	// assertEquals(xxx.refTagID);
        }
	}

    @Ignore // need to go throu all these tests
    @Test
	public void testHeaderFieldsMissing() throws Exception {
		final String data = "1=FIX.4.2";

		ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
		
		try {
		parser.parse(buf,  new FixMessageListenerTest() {
		});
		} catch (FixSessionException e) {
			assertTrue(true);
			// assertEquals(xxx.refTagID);
		}
	}
    
    /*
     * TODO port all the rest of the test cases 
     * 
    @Test
    public void testCalculateStringWithNestedGroups() throws Exception {
        final NewOrderCross noc = new NewOrderCross();
        noc.getHeader().setString(BeginString.FIELD, FixVersions.BEGINSTRING_FIX44);
        noc.getHeader().setInt(MsgSeqNum.FIELD, 5);
        noc.getHeader().setString(SenderCompID.FIELD, "sender");
        noc.getHeader().setString(TargetCompID.FIELD, "target");
        noc.getHeader().setString(SendingTime.FIELD, "20060319-09:08:20.881");

        noc.setString(SecurityIDSource.FIELD, SecurityIDSource.EXCHANGE_SYMBOL);
        noc.setChar(OrdType.FIELD, OrdType.LIMIT);
        noc.setDouble(Price.FIELD, 9.00);
        noc.setString(SecurityID.FIELD, "ABC");
        noc.setString(Symbol.FIELD, "ABC");
        noc.setString(TransactTime.FIELD, "20060319-09:08:19");
        noc.setString(CrossID.FIELD, "184214");
        noc.setInt(CrossType.FIELD,
                CrossType.CROSS_TRADE_WHICH_IS_EXECUTED_PARTIALLY_AND_THE_REST_IS_CANCELLED);
        noc.setInt(CrossPrioritization.FIELD, CrossPrioritization.NONE);

        final NewOrderCross.NoSides side = new NewOrderCross.NoSides();
        side.setChar(Side.FIELD, Side.BUY);
        side.setDouble(OrderQty.FIELD, 9);

        final NewOrderCross.NoSides.NoPartyIDs party = new NewOrderCross.NoSides.NoPartyIDs();
        party.setString(PartyID.FIELD, "8");
        party.setChar(PartyIDSource.FIELD, PartyIDSource.PROPRIETARY_CUSTOM_CODE);
        party.setInt(PartyRole.FIELD, PartyRole.CLEARING_FIRM);

        side.addGroup(party);

        party.setString(PartyID.FIELD, "AAA35777");
        party.setChar(PartyIDSource.FIELD, PartyIDSource.PROPRIETARY_CUSTOM_CODE);
        party.setInt(PartyRole.FIELD, PartyRole.CLIENT_ID);

        side.addGroup(party);

        noc.addGroup(side);

        side.clear();
        side.setChar(Side.FIELD, Side.SELL);
        side.setDouble(OrderQty.FIELD, 9);

        party.clear();
        party.setString(PartyID.FIELD, "8");
        party.setChar(PartyIDSource.FIELD, PartyIDSource.PROPRIETARY_CUSTOM_CODE);
        party.setInt(PartyRole.FIELD, PartyRole.CLEARING_FIRM);
        side.addGroup(party);

        party.clear();
        party.setString(PartyID.FIELD, "aaa");
        party.setChar(PartyIDSource.FIELD, PartyIDSource.PROPRIETARY_CUSTOM_CODE);
        party.setInt(PartyRole.FIELD, PartyRole.CLIENT_ID);
        side.addGroup(party);

        noc.addGroup(side);

        final String expectedMessage = "8=FIX.4.49=24735=s34=549=sender52=20060319-09:08:20.881"
                + "56=target22=840=244=948=ABC55=ABC60=20060319-09:08:19548=184214549=2"
                + "550=0552=254=1453=2448=8447=D452=4448=AAA35777447=D452=338=954=2"
                + "453=2448=8447=D452=4448=aaa447=D452=338=910=056";
        assertEquals("wrong message", expectedMessage, noc.toString());

    }


    @Test
    public void testHeaderFieldInBody() throws Exception {
        final Message message = new Message("8=FIX.4.2\u00019=40\u000135=A\u0001"
                + "98=0\u0001212=4\u0001384=2\u0001372=D\u0001385=R\u0001372=8\u0001385=S\u000110=103\u0001",
                DataDictionaryTest.getDictionary());

        assertFalse(message.hasValidStructure());

        assertTrue(message.getHeader().isSetField(212));

        assertEquals(SessionRejectReason.TAG_SPECIFIED_OUT_OF_REQUIRED_ORDER, message
                .getException().getSessionRejectReason());
        assertEquals(212, message.getException().getField());
    }

   @Test
   public void testTrailerFieldInBody() throws Exception {
        final Message message = new Message("8=FIX.4.2\u00019=40\u000135=A\u0001"
                + "98=0\u000193=5\u0001384=2\u0001372=D\u0001385=R\u0001372=8\u0001385=S\u000110=63\u0001",
                DataDictionaryTest.getDictionary());

        assertFalse(message.hasValidStructure());

        final SignatureLength signatureLength = new SignatureLength();
        message.getTrailer().getField(signatureLength);
        assertEquals(5, signatureLength.getValue());
    }

    @Test
    public void testMessageFromString() {
        Message message = null;

        boolean badMessage = false;
        try {
            message = new Message("8=FIX.4.2\u00019=12\u000135=A\u0001108=30\u000110=036\u0001");
        } catch (final InvalidMessage e) {
            badMessage = true;
        }
        assertTrue("Message should be invalid", badMessage);

        try {
            message = new Message("8=FIX.4.2\u00019=12\u000135=A\u0001108=30\u000110=026\u0001");
        } catch (final InvalidMessage e) {
            assertTrue("Message should be valid (" + e.getMessage() + ")", false);
        }
        assertEquals("8=FIX.4.2\u00019=12\u000135=A\u0001108=30\u000110=026\u0001", message.toString());
    }

    @Test
    public void testMessageGroups() {
        final Message message = new Message();
        final NewOrderSingle.NoAllocs numAllocs = setUpGroups(message);

        assertGroupContent(message, numAllocs);
    }

    @Test
    public void testMessageGroupCountValidation() throws Exception {
        final String data = "8=FIX.4.49=22235=D49=SenderCompId56=TargetCompId34=3752=20070223-22:28:33"
                + "11=18333922=838=140=244=1248=BHP54=255=BHP59=1"
                + "60=20060223-22:38:33526=362078=379=AllocACC180=1010.1"
                + "79=AllocACC280=2020.2453=2448=8447=D452=4448=AAA35354447=D452=310=082";
        final Message message = new Message();
        final DataDictionary dd = DataDictionaryTest.getDictionary();
        message.fromString(data, dd, true);
        try {
            dd.validate(message);
            fail("No exception thrown");
        } catch (final FieldException e) {
            final String emsg = e.getMessage();
            assertNotNull("No exception message", emsg);
            assertTrue(emsg.startsWith("Incorrect NumInGroup"));
        }

    }

    @Test
    public void testMessageCloneWithGroups() {
        final Message message = new Message();
        final NewOrderSingle.NoAllocs numAllocs = setUpGroups(message);

        final Message clonedMessage = (Message) message.clone();
        assertGroupContent(clonedMessage, numAllocs);
    }

    @Test
    public void testFieldOrderAfterClone() {
        final Message message = new quickfix.fix44.NewOrderSingle();
        final quickfix.fix44.NewOrderSingle.NoPartyIDs partyIdGroup = new quickfix.fix44.NewOrderSingle.NoPartyIDs();
        partyIdGroup.set(new PartyID("PARTY_1"));
        partyIdGroup.set(new PartyIDSource(PartyIDSource.DIRECTED_BROKER));
        partyIdGroup.set(new PartyRole(PartyRole.INTRODUCING_FIRM));
        message.addGroup(partyIdGroup);
        final Message clonedMessage = (Message) message.clone();
        assertEquals("wrong field order",
                "8=FIX.4.49=3535=D453=1448=PARTY_1447=I452=610=040", clonedMessage
                        .toString());
    }

    @Test
    public void testMessageGroupRemovalUsingGroupObject() {
        final Message message = new Message();
        final int length = message.calculateLength();
        final int messageFieldWithZeroLengthGroup = length + "79=0\u0001".length();

        NewOrderSingle.NoAllocs numAllocs = setUpGroups(message);

        // Remove all

        assertEquals("wrong # of group members", 2, message.getGroupCount(numAllocs.getFieldTag()));

        message.removeGroup(numAllocs);

        assertEquals("wrong # of group members", 0, message.getGroupCount(numAllocs.getFieldTag()));
        assertZeroLengthField(message);
        assertEquals("wrong message length", messageFieldWithZeroLengthGroup, message
                .calculateLength());

        // Remove one at a time

        numAllocs = setUpGroups(message);
        assertEquals("wrong # of group members", 2, message.getGroupCount(numAllocs.getFieldTag()));

        message.removeGroup(2, numAllocs);

        assertEquals("wrong # of group members", 1, message.getGroupCount(numAllocs.getFieldTag()));

        message.removeGroup(1, numAllocs);

        assertEquals("wrong # of group members", 0, message.getGroupCount(numAllocs.getFieldTag()));
        assertZeroLengthField(message);
        assertEquals("wrong message length", messageFieldWithZeroLengthGroup, message
                .calculateLength());
    }

    private void assertZeroLengthField(Message message) {
        assertTrue("Incorrect length in message.toString()", message.toString()
                .contains("\u000178=0"));
    }

    @Test
    public void testMessageGroupRemovalUsingGroupFieldTag() {
        final Message message = new Message();
        final int length = message.calculateLength();
        final int messageFieldWithZeroLengthGroup = length + "79=0\u0001".length();
        final int expectedTotalWithZeroLengthGroup = new IntField(78, 0).getTotal();

        NewOrderSingle.NoAllocs numAllocs = setUpGroups(message);

        // Remove all

        assertEquals("wrong # of group members", 2, message.getGroupCount(numAllocs.getFieldTag()));

        message.removeGroup(numAllocs.getFieldTag());

        assertEquals("wrong # of group members", 0, message.getGroupCount(numAllocs.getFieldTag()));
        assertZeroLengthField(message);
        assertEquals("wrong message length", messageFieldWithZeroLengthGroup, message
                .calculateLength());
        assertEquals("wrong total", expectedTotalWithZeroLengthGroup, message.calculateTotal());

        // Remove one at a time

        numAllocs = setUpGroups(message);

        assertEquals("wrong # of group members", 2, message.getGroupCount(numAllocs.getFieldTag()));

        message.removeGroup(2, numAllocs.getFieldTag());

        assertEquals("wrong # of group members", 1, message.getGroupCount(numAllocs.getFieldTag()));

        message.removeGroup(1, numAllocs.getFieldTag());

        assertEquals("wrong # of group members", 0, message.getGroupCount(numAllocs.getFieldTag()));
        assertZeroLengthField(message);
        assertEquals("wrong message length", messageFieldWithZeroLengthGroup, message
                .calculateLength());
        assertEquals("wrong total", expectedTotalWithZeroLengthGroup, message.calculateTotal());
    }

    @Test
    public void testMessageGroupRemovalFromEmptyGroup() {
        final Message message = new Message();
        final int length = message.calculateLength();
        final int messageFieldWithZeroLengthGroup = length + "79=0\u0001".length();
        final int expectedTotalWithZeroLengthGroup = new IntField(78, 0).getTotal();
        final NewOrderSingle.NoAllocs numAllocs = setUpGroups(message);
        message.removeGroup(numAllocs);

        // ensure no exception when groups are empty
        message.removeGroup(1, numAllocs);

        assertEquals("wrong # of group members", 0, message.getGroupCount(numAllocs.getFieldTag()));
        assertZeroLengthField(message);
        assertEquals("wrong message length", messageFieldWithZeroLengthGroup, message
                .calculateLength());
        assertEquals("wrong total", expectedTotalWithZeroLengthGroup, message.calculateTotal());
    }

    @Test
    public void testHasGroup() {
        final Message message = new Message();
        final NewOrderSingle.NoAllocs numAllocs = setUpGroups(message);

        assertFalse("wrong value", message.hasGroup(654));
        assertTrue("wrong value", message.hasGroup(numAllocs.getFieldTag()));
        assertTrue("wrong value", message.hasGroup(numAllocs));
        assertTrue("wrong value", message.hasGroup(1, numAllocs));
        assertTrue("wrong value", message.hasGroup(1, numAllocs.getFieldTag()));
        assertTrue("wrong value", message.hasGroup(2, numAllocs));
        assertTrue("wrong value", message.hasGroup(2, numAllocs.getFieldTag()));
        assertFalse("wrong value", message.hasGroup(3, numAllocs));
        assertFalse("wrong value", message.hasGroup(3, numAllocs.getFieldTag()));
    }

    @Test
    public void testIsEmpty() {
        final Message message = new Message();
        assertTrue("Message should be empty on construction", message.isEmpty());
        message.getHeader().setField(new BeginString("FIX.4.2"));
        assertFalse("Header should contain a field", message.isEmpty());
        message.clear();
        assertTrue("Message should be empty after clear", message.isEmpty());
        message.setField(new Symbol("MSFT"));
        assertFalse("Body should contain a field", message.isEmpty());
        message.clear();
        assertTrue("Message should be empty after clear", message.isEmpty());
        message.getTrailer().setField(new CheckSum("10"));
        assertFalse("Trailer should contain a field", message.isEmpty());
        message.clear();
        assertTrue("Message should be empty after clear", message.isEmpty());
    }

    @Test
    public void testMessageSetGetString() {
        final Message message = new Message();

        try {
            message.getString(5);
            assertTrue("exception not thrown", false);
        } catch (final FieldNotFound e) {
        }

        message.setString(5, "string5");

        try {
            assertEquals("string5", message.getString(5));
        } catch (final FieldNotFound e) {
            assertTrue("exception thrown", false);
        }

        try {
            message.setString(100, null);
            assertTrue("exception not thrown", false);
        } catch (final NullPointerException e) {
        }
    }

    @Test
    public void testMessagesetGetBoolean() {
        final Message message = new Message();

        try {
            message.getBoolean(7);
            assertTrue("exception not thrown", false);
        } catch (final FieldNotFound e) {
        }

        message.setBoolean(7, true);

        try {
            assertEquals(true, message.getBoolean(7));
        } catch (final FieldNotFound e) {
            assertTrue("exception thrown", false);
        }
    }

   @Test
   public void testMessageSetGetChar() {
        final Message message = new Message();

        try {
            message.getChar(12);
            assertTrue("exception not thrown", false);
        } catch (final FieldNotFound e) {
        }

        message.setChar(12, 'a');

        try {
            assertEquals('a', message.getChar(12));
        } catch (final FieldNotFound e) {
            assertTrue("exception thrown", false);
        }
    }

    @Test
    public void testMessageSetGetInt() {
        final Message message = new Message();

        try {
            message.getInt(56);
            assertTrue("exception not thrown", false);
        } catch (final FieldNotFound e) {
        }

        message.setInt(56, 23);

        try {
            assertEquals(23, message.getInt(56));
        } catch (final FieldNotFound e) {
            assertTrue("exception thrown", false);
        }
    }

    @Test
    public void testMessageSetGetDouble() {
        final Message message = new Message();

        try {
            message.getDouble(9812);
            assertTrue("exception not thrown", false);
        } catch (final FieldNotFound e) {
        }

        message.setDouble(9812, 12.3443);

        try {
            assertEquals(12.3443, message.getDouble(9812), 1e-10);
        } catch (final FieldNotFound e) {
            assertTrue("exception thrown", false);
        }
    }

    @Test
    public void testMessageSetGetUtcTimeStamp() {
        final Message message = new Message();

        try {
            message.getUtcTimeStamp(8);
            assertTrue("exception not thrown", false);
        } catch (final FieldNotFound e) {
        }

        final TimeZone timezone = TimeZone.getTimeZone("GMT+0");
        final Calendar calendar = Calendar.getInstance(timezone);
        calendar.set(2002, 8, 6, 12, 34, 56);
        calendar.set(Calendar.MILLISECOND, 0);

        final Date time = calendar.getTime();
        message.setUtcTimeStamp(8, time);

        try {
            assertEquals(message.getUtcTimeStamp(8).getTime(), time.getTime());
        } catch (final FieldNotFound e) {
            assertTrue("exception thrown", false);
        }
    }

    @Test
    public void testRemoveField() {
        final Message message = new Message();
        message.setField(new StringField(12, "value"));
        assertTrue(message.isSetField(12));
        message.removeField(12);
        assertTrue(!message.isSetField(12));
    }

    @Test
    public void testMessageIterator() {
        Message message = new Message();
        java.util.Iterator<Field<?>> i = message.iterator();
        assertEquals(false, i.hasNext());
        try {
            assertNull(i.next());
            fail("exception not thrown");
        } catch (final java.util.NoSuchElementException e) {
        }

        try {
            message = new Message("8=FIX.4.2\u00019=12\u000135=A\u0001108=30\u000110=026\u0001");
            i = message.iterator();
            assertTrue(i.hasNext());
            StringField field = (StringField) i.next();
            assertEquals(108, field.getField());
            assertEquals("30", field.getValue());

            assertEquals(false, i.hasNext());
            try {
                assertNull(i.next());
                fail("exception not thrown");
            } catch (final java.util.NoSuchElementException e) {
            }

            final java.util.Iterator<Field<?>> j = message.getHeader().iterator();
            assertTrue(j.hasNext());
            field = (StringField) j.next();
            assertEquals(8, field.getField());
            assertEquals("FIX.4.2", field.getValue());
            field = (StringField) j.next();
            assertEquals(9, field.getField());
            assertEquals("12", field.getValue());
            field = (StringField) j.next();
            assertEquals(35, field.getField());
            assertEquals("A", field.getValue());

            assertEquals(false, j.hasNext());
            try {
                assertNull(j.next());
                fail("exception not thrown");
            } catch (final java.util.NoSuchElementException e) {
            }

        } catch (final InvalidMessage e) {
            fail("exception thrown");
        }
    }

    @Test
    public void testIsAdmin() {
        final Message message = new Message();

        message.getHeader().setString(MsgType.FIELD, MsgType.HEARTBEAT);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.LOGON);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.LOGOUT);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.SEQUENCE_RESET);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.RESEND_REQUEST);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.TEST_REQUEST);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.REJECT);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.ORDER_SINGLE);
        assertFalse(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.QUOTE_RESPONSE);
        assertFalse(message.isAdmin());
    }

    @Test
    public void testComponent() throws Exception {
        final Instrument instrument = new Instrument();
        instrument.set(new Symbol("DELL"));
        instrument.set(new CountryOfIssue("USA"));
        instrument.set(new SecurityType(SecurityType.COMMON_STOCK));

        final quickfix.fix44.NewOrderSingle newOrderSingle = new quickfix.fix44.NewOrderSingle();
        newOrderSingle.set(instrument);
        newOrderSingle.set(new OrderQty(100));
        newOrderSingle.set(new Price(45));

        assertEquals(new Symbol("DELL"), newOrderSingle.getSymbol());
        assertEquals(new CountryOfIssue("USA"), newOrderSingle.getCountryOfIssue());
        assertEquals(new SecurityType(SecurityType.COMMON_STOCK), newOrderSingle.getSecurityType());

        newOrderSingle.set(new ClOrdID("CLIENT_ORDER_ID"));
        final Instrument instrument2 = newOrderSingle.getInstrument();
        assertEquals(new Symbol("DELL"), instrument2.getSymbol());
        assertEquals(new CountryOfIssue("USA"), instrument2.getCountryOfIssue());
        assertEquals(new SecurityType(SecurityType.COMMON_STOCK), instrument2.getSecurityType());
        try {
            instrument2.getField(new ClOrdID());
            fail("should have thrown exception");
        } catch (final FieldNotFound e) {
            // expected
        }

    }

    @Test
    public void testReplaceGroup() throws Exception {
        final Message message = new Message();
        message.setField(new ListID("1"));
        message.setField(new BidType(0));
        message.setField(new TotNoOrders(3));

        final NewOrderList.NoOrders group = new NewOrderList.NoOrders();
        group.set(new ClOrdID("A"));
        group.set(new ListSeqNo(1));
        group.set(new Symbol("DELL"));
        group.set(new Side('1'));
        message.addGroup(group);

        group.set(new ClOrdID("B"));
        group.set(new ListSeqNo(2));
        group.set(new Symbol("LNUX"));
        group.set(new Side('2'));
        message.addGroup(group);

        group.set(new ClOrdID("C"));
        group.set(new ListSeqNo(3));
        group.set(new Symbol("RHAT"));
        group.set(new Side('3'));
        message.addGroup(group);

        group.set(new ClOrdID("D"));
        group.set(new ListSeqNo(4));
        group.set(new Symbol("AAPL"));
        group.set(new Side('4'));
        message.replaceGroup(2, group);

        final NoOrders noOrders = new NoOrders();

        assertTrue(message.hasGroup(1, group));
        assertTrue(message.hasGroup(2, group));
        assertTrue(message.hasGroup(3, group));
        assertEquals(3, message.getGroupCount(NoOrders.FIELD));
        message.getField(noOrders);
        assertEquals(3, noOrders.getValue());

        final ClOrdID clOrdID = new ClOrdID();
        message.getGroup(1, group);
        assertEquals("A", group.getField(clOrdID).getValue());
        message.getGroup(2, group);
        assertEquals("D", group.getField(clOrdID).getValue());
        message.getGroup(3, group);
        assertEquals("C", group.getField(clOrdID).getValue());
    }

    @Test
    public void testFalseMessageStructureException() {
        try {
            final DataDictionary dd = DataDictionaryTest.getDictionary();
            // duplicated tag 98
            // QFJ-65
            new Message("8=FIX.4.4\u00019=22\u000135=A\u000198=0\u000198=0\u0001108=30\u000110=223\u0001", dd,
                    true);
            // For now, this will not cause an exception if the length and checksum are correct
        } catch (final Exception e) {
            final String text = e.getMessage();
            assertTrue("Wrong exception message: " + text, text.indexOf("Actual body length") == -1);
        }
    }

    @Test
    public void testComponentInGroup() {
        try {
            final DataDictionary dd = DataDictionaryTest.getDictionary();
            // duplicated tag 98
            // QFJ-65
            // 8=FIX.4.4\u00019=941\u000135=AE\u000149=ICE\u000134=63\u000152=20091117-18:59:04.780\u000156=XXXX\u000157=X\u0001571=219449\u0001487=0\u0001856=0\u0001828=0\u0001150=F\u000117=44750544433\u000139=2\u0001570=N\u000155=480120\u000148=WBS FMG0010-BRN FMG0010\u000122=8\u0001461=FXXXXX\u0001916=20100201\u0001917=20100228\u000132=1.0\u000131=0.69\u00019018=1\u00019022=1\u000175=20091117\u000160=20091117-18:59:04.775\u0001552=1\u000154=2\u000137=41296064\u000111=557859232\u0001453=7\u0001448=trader\u0001447=D\u0001452=11\u0001448=Trading Corp\u0001447=D\u0001452=13\u0001448=2757\u0001447=D\u0001452=56\u0001448=805\u0001447=D\u0001452=4\u0001448=11122556\u0001447=D\u0001452=51\u0001448=FCM\u0001447=D\u0001452=60\u0001448=U\u0001447=D\u0001452=5 458=41293051\u0001555=2\u0001600=460130\u0001602=WBS FMG0010!\u0001603=8\u0001608=FXXXXX\u0001624=2\u0001637=80.78\u0001687=1.0\u0001654=41296074\u00019019=1\u00019023=1\u00019020=20100201\u00019021=20100228\u0001539=4\u0001524=805\u0001525=D\u0001538=4\u0001524=11122556\u0001525=D\u0001538=51\u0001524=FCM\u0001525=D\u0001538=60 524=U\u0001525=D\u0001538=54\u0001600=217927\u0001602=BRN FMG0010! 63=8 608-FXXXXX 624=1 637=80.09 687=1.0 654=41296073 9019=1 9023=1 9020=20100201 9021=20100228 539=4 524=805\u0001525=D\u0001538=4\u0001524=11122556 525=D\u0001538=51 524=Newedge 525=D 538=60 524=U 525=D 538=54 10=112
            new Message(
                    "8=FIX.4.4\u00019=941\u000135=AE\u000149=ICE\u000134=63\u000152=20091117-18:59:04.780\u000156=XXXX\u000157=X\u0001571=219449\u0001487=0\u0001856=0\u0001828=0\u0001150=F\u000117=44750544433\u000139=2\u0001570=N\u000155=480120\u000148=WBS FMG0010-BRN FMG0010\u000122=8\u0001461=FXXXXX\u0001916=20100201\u0001917=20100228\u000132=1.0\u000131=0.69\u00019018=1\u00019022=1\u000175=20091117\u000160=20091117-18:59:04.775\u0001552=1\u000154=2\u000137=41296064\u000111=557859232\u0001453=7\u0001448=trader\u0001447=D\u0001452=11\u0001448=Trading Corp\u0001447=D\u0001452=13\u0001448=2757\u0001447=D\u0001452=56\u0001448=805\u0001447=D\u0001452=4\u0001448=11122556\u0001447=D\u0001452=51\u0001448=FCM\u0001447=D\u0001452=60\u0001448=U\u0001447=D\u0001452=5 458=41293051\u0001555=2\u0001600=460130\u0001602=WBS FMG0010!\u0001603=8\u0001608=FXXXXX\u0001624=2\u0001637=80.78\u0001687=1.0\u0001654=41296074\u00019019=1\u00019023=1\u00019020=20100201\u00019021=20100228\u0001539=4\u0001524=805\u0001525=D\u0001538=4\u0001524=11122556\u0001525=D\u0001538=51\u0001524=FCM\u0001525=D\u0001538=60 524=U\u0001525=D\u0001538=54\u0001600=217927\u0001602=BRN FMG0010!\u000163=8 608-FXXXXX\u0001624=1\u0001637=80.09\u0001687=1.0\u0001654=41296073\u00019019=1\u00019023=1\u00019020=20100201\u0001021=20100228\u0001539=4\u0001524=805\u0001525=D\u0001538=4\u0001524=11122556\u0001525=D\u0001538=51\u0001524=FCM\u0001525=D\u0001538=60 524=U\u0001525=D\u0001538=54\u0001600=217927\u0001602=BRN FMG0010!\u000163=8 608-FXXXXX\u0001624=1\u0001637=80.09\u0001687=1.0\u0001654=41296073\u00019019=1\u00019023=1\u00019020=20100201\u0001021=20100228\u0001",
                    dd, true);
            // For now, this will not cause an exception if the length and checksum are correct
        } catch (final Exception e) {
            final String text = e.getMessage();
            assertTrue("Wrong exception message: " + text, text.indexOf("Actual body length") == -1);
        }
    }

    @Test
    public void testFalseMessageStructureException2() {
        try {
            final DataDictionary dd = DataDictionaryTest.getDictionary();
            // duplicated raw data length 
            // QFJ-121
            new Message("8=FIX.4.4\u00019=22\u000135=A\u000196=X\u0001108=30\u000110=223\u0001", dd, true);
        } catch (final Exception e) {
            final String text = e.getMessage();
            assertTrue("Wrong exception message: " + text, text != null
                    && text.indexOf("Actual body length") == -1);
        }
    }

    @Test
    public void testEmptyMessageToString() throws Exception {
        final Message msg = new quickfix.Message();
        assertNotNull(msg.toString());
        assertTrue("empty message contains no checksum", msg.toString().length() > 0);
    }

    @Test
    public void testMessageBytesField() throws Exception {
        final Logon logon = new Logon();
        final String data = "rawdata";
        logon.set(new RawDataLength(data.length()));
        logon.setField(new BytesField(RawData.FIELD, data.getBytes()));
        //logon.set(new RawData(data));
        assertEquals("8=FIX.4.49=2135=A95=796=rawdata10=086", logon.toString());
    }

    private void assertGroupContent(Message message, NewOrderSingle.NoAllocs numAllocs) {
        StringField field = null;
        final java.util.Iterator<Field<?>> i = numAllocs.iterator();
        assertTrue(i.hasNext());
        field = (StringField) i.next();
        assertEquals("AllocACC2", field.getValue());
        assertTrue(i.hasNext());
        field = (StringField) i.next();
        assertEquals("2020.20", field.getValue());
        assertTrue(!i.hasNext());

        try {
            final String accountId = numAllocs.getField(new AllocAccount()).getValue();
            final Object shares = numAllocs.getField(new AllocShares()).getObject();
            message.getGroup(1, numAllocs);
            assertAllocation(accountId, shares);
            message.getGroup(2, numAllocs);
            assertEquals("AllocACC2", accountId);
            assertAllocation(accountId, shares);
        } catch (final FieldNotFound e) {
            fail("no exception should be thrown");
        }

        try {
            message.getGroup(3, numAllocs);
            fail("exception should be thrown");
        } catch (final FieldNotFound ignored) {
        }
    }

    private void assertAllocation(String accountId, Object shares) {
        if (accountId.equals("AllocACC1")) {
            assertEquals("got shares: " + shares, 0, new BigDecimal("1010.10")
                    .compareTo(new BigDecimal(shares.toString())));
        } else if (accountId.equals("AllocACC2")) {
            assertEquals("got shares: " + shares, 0, new BigDecimal("2020.20")
                    .compareTo(new BigDecimal(shares.toString())));
        } else {
            fail("Unknown account");
        }
    }

    private FixAllocGrp setUpGroups(FixInMessage message) {
        final NewOrderSingle.NoAllocs numAllocs = new NewOrderSingle.NoAllocs();
        numAllocs.set(new AllocAccount("AllocACC1"));
        numAllocs.setField(new StringField(AllocShares.FIELD, "1010.10"));
        message.addGroup(numAllocs);
        numAllocs.setField(new AllocAccount("AllocACC2"));
        numAllocs.setField(new StringField(AllocShares.FIELD, "2020.20"));
        message.addGroup(numAllocs);
        return numAllocs;
    }
    
    */

}