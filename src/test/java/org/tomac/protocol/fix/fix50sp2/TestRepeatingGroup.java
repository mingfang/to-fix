package org.tomac.protocol.fix.fix50sp2;

import java.nio.ByteBuffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixMessageInfo;
import org.tomac.protocol.fix.messaging.FixMessagePool;
import org.tomac.protocol.fix.messaging.FixQuote;
import junit.framework.TestCase;

public class TestRepeatingGroup extends TestCase {
	
	FixValidationError err;
	
	@Before
	public void setUp() throws Exception {
		err = new FixValidationError();
		FixUtils.validateSession = false;
	}
	
	@After
	public void tearDown() throws Exception {
	}


    private void buildGroupWithStandardFields(FixQuote quote, int i, String settingValue) {
        quote.legQuotGrp[i].setLegBidPx(settingValue);
    }

    @Test
    public void testSettingGettingGroupWithStandardFields() {
        final String settingValue = "100";

        FixQuote quote = new FixQuote();
        buildGroupWithStandardFields(quote, 0, settingValue);

        final long gotField = quote.legQuotGrp[0].getLegBidPx();

        assertEquals(FixUtils.longValueOf(settingValue.getBytes(), 0, settingValue.getBytes().length), gotField);
    }

    @Test
    public void testOutOfOrderGroupMembersDelimeterField() throws Exception {
    	String data = "8=FIXT.1.19=11935=D34=249=TW52=<TIME>56=ISLD11=ID21=140=154=138=200.0055=INTC78=280=5079=acct180=15079=acct260=<TIME>10=000";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        
        FixMessagePool.pool.getFixMessage(buf, err);
        assertTrue(err.hasError());
        assertEquals(80, err.refTagID);
        assertEquals(FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, err.sessionRejectReason);

    }

    @Test
    public void testIgnoreOutOfOrderGroupMembersDelimeterField() throws Exception {
        String data = "8=FIXT.1.19=11935=D34=249=TW52=<TIME>56=ISLD11=ID21=140=154=138=200.0055=INTC78=280=5079=acct180=15079=acct260=<TIME>10=000";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        
        FixMessagePool.pool.getFixMessage(buf, err);
        assertTrue(err.hasError());
        assertEquals(80, err.refTagID);
        assertEquals(FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, err.sessionRejectReason);

    }

    @Test
    public void testOutOfOrderGroupMembers() throws Exception {
        String data = "8=FIXT.1.19=16135=D34=249=TW52=20080203-00:29:51.45356=ISLD11=ID21=140=154=138=200.0055=INTC78=279=acct180=50661=X79=acct280=150661=X60=20080203-00:29:51.45310=000";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        
        FixMessagePool.pool.getFixMessage(buf, err);
        assertFalse(err.hasError()); // QuickFix thinks this should be an error. Don't agree only key tag must be first.
        //assertEquals(661, err.refTagID);
        //assertEquals(FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, err.sessionRejectReason);
    }

    @Test
    public void testIgnoreOutOfOrderGroupMembers() throws Exception {
    	String data = "8=FIXT.1.19=16335=D34=249=TW52=20080203-00:29:51.45356=ISLD11=ID21=140=154=138=200.0055=INTC78=279=acct180=50661=1079=acct280=150661=1160=20080203-00:29:51.45310=000";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        
        FixMessagePool.pool.getFixMessage(buf, err);
        assertFalse(err.hasError());
    }

    @Test
    public void testRequiredGroupMembers() throws Exception {
    	String data = "8=FIXT.1.19=6835=i34=249=TW52=20080203-00:29:51.45356=ISLD117=ID296=1302=X10=000";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        
        FixMessagePool.pool.getFixMessage(buf, err);
        assertTrue(err.hasError()); 
        assertEquals(304, err.refTagID);
        assertEquals(FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, err.sessionRejectReason);
    }

    @Test
    public void testWrongGroupCount() throws Exception {
    	String data = "8=FIXT.1.19=8935=i34=249=TW52=20080203-00:29:51.45356=ISLD117=ID296=1302=X304=5295=50299=QID10=085";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        
        FixMessagePool.pool.getFixMessage(buf, err);
        assertTrue(err.hasError());
        assertEquals(295, err.refTagID);
        assertEquals(FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, err.sessionRejectReason);
    }

    @Test
    public void testInvalidEnumFieldInGroup() throws Exception {
    	String data = "8=FIXT.1.19=7935=A34=252=20080203-00:29:51.45356=ISLD49=TW108=10384=1372=D385=X98=010=129";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        
        FixMessagePool.pool.getFixMessage(buf, err);
        assertTrue(err.hasError());
        assertEquals(1137, err.refTagID);
    }

    @Test
    public void testSettingGettingGroupWithStandardFieldsInHeader() throws Exception {
        String data = "8=FIXT.1.19=13135=034=252=20080203-00:29:51.45356=ISLD49=TW627=2628=_TED02A629=20090717-13:25:31.896628=_GWSURV629=20090717-13:25:31.92810=012";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        
        FixMessagePool.pool.getFixMessage(buf, err);
        assertFalse(err.hasError());
    }

}
