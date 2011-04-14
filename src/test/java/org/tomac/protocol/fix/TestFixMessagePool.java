package org.tomac.protocol.fix;

import static org.junit.Assert.*;

import org.junit.Test;
import org.tomac.protocol.fix.messaging.FixAdvertisement;
import org.tomac.protocol.fix.messaging.FixMessageInfo;
import org.tomac.protocol.fix.messaging.FixMessagePool;
import org.tomac.protocol.fix.messaging.FixNews;

public class TestFixMessagePool {

    @Test
    public void testMessageCreate() throws Exception {
        assertMessage(new FixAdvertisement().getClass(), FixMessagePool.pool.getFixAdvertisement());
    }
    
    @Test
    public void testGroupCreate() throws Exception {

    	FixNews news = FixMessagePool.pool.getFixNews();

    	news.linesOfTextGrp[0].setText("test");
        assertEquals(news.linesOfTextGrp[0].hasGroup(), true);
        assertTrue(FixUtils.equals(news.linesOfTextGrp[0].getText(), "test".getBytes()));
    }
    
    private static void assertMessage(Class<?> expectedMessageClass, FixInMessage message) throws Exception {
        assertEquals(expectedMessageClass, message.getClass());
    }
}
