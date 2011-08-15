package org.tomac.util;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.tomac.utils.Utils;

public class TestFieldMap {

	@Test
    public void testSetUtcTimeStampField() throws Exception {
        Date aDate = new Date();
        byte[] utcTimeStampField = Utils.utcTimestampConverter.convert(aDate).getBytes();
        Date tm = Utils.utcTimestampConverter.convert(utcTimeStampField);
        assertEquals(aDate.getTime(), tm.getTime());
        
    }

	@Test
	public void testSetUtcTimeOnlyField() throws Exception {
        Date aDate = new Date();
        byte[] utcTimeOnlyField = Utils.utcTimeOnlyConverter.convert(aDate).getBytes();
        Date tm = Utils.utcTimeOnlyConverter.convert(utcTimeOnlyField);
        assertEquals(aDate.getTime(), tm.getTime() );
    }

}
