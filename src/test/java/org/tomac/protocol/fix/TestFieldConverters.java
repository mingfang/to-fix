/*******************************************************************************
 * Copyright (c) quickfixengine.org  All rights reserved. 
 * 
 * This file is part of the QuickFIX FIX Engine 
 * 
 * This file may be distributed under the terms of the quickfixengine.org 
 * license as defined by quickfixengine.org and appearing in the file 
 * LICENSE included in the packaging of this file. 
 * 
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING 
 * THE WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A 
 * PARTICULAR PURPOSE. 
 * 
 * See http://www.quickfixengine.org/LICENSE for licensing information. 
 * 
 * Contact ask@quickfixengine.org if any conditions of this licensing 
 * are not clear to you.
 ******************************************************************************/

package org.tomac.protocol.fix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;

public class TestFieldConverters {

	@Test
    public void testIntegerConversion() throws Exception {
    	byte[] out = new byte[3];
    	FixUtils.longToNumeric(out, 0, 123, out.length);
        assertTrue(FixUtils.equals("123".getBytes(), out));
        assertEquals(123L, FixUtils.longValueOf("123".getBytes(), 0 , 3));
    	FixUtils.longToNumeric(out, 0, -1, out.length);
        assertTrue(FixUtils.equals("-1".getBytes(), out));
        try {
        	FixUtils.longValueOf("abc".getBytes(), 0 , 3);
        	fail();
        } catch (Exception e) {}
        try {
        	long val = FixUtils.longValueOf("123.4".getBytes(), 0 , 3);
            assertEquals(123L, val);
        } catch (Exception e) { fail();}
        try {
        	FixUtils.longValueOf("+200".getBytes(), 0 , 3);
        	fail();
        } catch (Exception e) {}
    }

	@Test
    public void testDoubleConversion() throws Exception {
        assertEquals("45.32", FixUtils.FixFloatConverter.convert(4532));
        assertEquals("0.45", FixUtils.FixFloatConverter.convert(45));
        assertEquals("-0.1", FixUtils.FixFloatConverter.convert(-10));
        assertEquals("-0.01", FixUtils.FixFloatConverter.convert(-1));
        assertEquals("0.0", FixUtils.FixFloatConverter.convert(0));
        assertEquals(4532L, FixUtils.FixFloatConverter.convert("45.32".getBytes()), 0);
        assertEquals(4532L, FixUtils.FixFloatConverter.convert("45.3200".getBytes()), 0);
        assertEquals(340244000L, FixUtils.FixFloatConverter.convert("0003402440.00".getBytes()), 0);
        assertEquals(4532L, FixUtils.FixFloatConverter.convert("45.32".getBytes()), 0);
        assertEquals(120100L, FixUtils.FixFloatConverter.convert("1201".getBytes()), 0);
        assertEquals(0L, FixUtils.FixFloatConverter.convert("0.0".getBytes()), 0);
        assertEquals(4532L, FixUtils.FixFloatConverter.convert("0045.32".getBytes()), 0);
        assertEquals(0L, FixUtils.FixFloatConverter.convert("0.".getBytes()), 0);
        assertEquals(0L, FixUtils.FixFloatConverter.convert(".0".getBytes()), 0);
        assertEquals(6L, FixUtils.FixFloatConverter.convert("000.06".getBytes()), 0);
        assertEquals(6L, FixUtils.FixFloatConverter.convert("0.0600".getBytes()), 0);

        try {
        	FixUtils.FixFloatConverter.convert("abc".getBytes());
        	fail();
        } catch (Exception e) { }
        try {
        	FixUtils.FixFloatConverter.convert("123.A".getBytes());
        	fail();
        } catch (Exception e) {};
        long val = FixUtils.FixFloatConverter.convert(".".getBytes());
        assertEquals(0L,val);
        
        assertEquals("1.5", FixUtils.FixFloatConverter.convert(1500, 3));
        assertEquals("45.0", FixUtils.FixFloatConverter.convert(4500000, 5));
        assertEquals("5.0", FixUtils.FixFloatConverter.convert(500, 2));
        assertEquals("-5.0", FixUtils.FixFloatConverter.convert(-500, 2));
        assertEquals("-122.345", FixUtils.FixFloatConverter.convert(-122345, 3));
        assertEquals("0.0", FixUtils.FixFloatConverter.convert(0, 1));

    }

	@Test
    public void testCharConversion() throws Exception {
        assertEquals("a", FixUtils.CharConverter.convert('a'));
        assertEquals("1", FixUtils.CharConverter.convert('1'));
        assertEquals("F", FixUtils.CharConverter.convert('F'));
        assertEquals((byte)'a', FixUtils.CharConverter.convert("a"));
        assertEquals((byte)'1', FixUtils.CharConverter.convert("1"));
        assertEquals((byte)'F', FixUtils.CharConverter.convert("F"));
        try {
            FixUtils.CharConverter.convert("a1");
            fail();
        } catch (Exception e) {
            // expected
        }
    }

	@Test
    public void testBooleanConversion() throws Exception {
        assertEquals("Y", FixUtils.BooleanConverter.convert(true));
        assertEquals("N", FixUtils.BooleanConverter.convert(false));
        assertEquals(true, FixUtils.BooleanConverter.convert("Y"));
        assertEquals(false, FixUtils.BooleanConverter.convert("N"));
        try {
            FixUtils.BooleanConverter.convert("D");
            fail();
        } catch (Exception e) {
            // expected
        }
        try {
            FixUtils.BooleanConverter.convert("true");
            fail();
        } catch (Exception e) {
            // expected
        }
    }

	@Test
    public void testUtcTimeStampConversion() throws Exception {
        Calendar c = new GregorianCalendar(2000, 3, 26, 12, 5, 6);
        c.setTimeZone(TimeZone.getTimeZone("UTC"));
        c.set(Calendar.MILLISECOND, 555);
        assertEquals("20000426-12:05:06.555", FixUtils.utcTimestampConverter.convert(c.getTime()));

        Date date = FixUtils.utcTimestampConverter.convert("20000426-12:05:06.555".getBytes());
        c.setTime(date);
        assertEquals(12, c.get(Calendar.HOUR_OF_DAY));
        assertEquals(5, c.get(Calendar.MINUTE));
        assertEquals(6, c.get(Calendar.SECOND));
        assertEquals(555, c.get(Calendar.MILLISECOND));
        assertEquals(2000, c.get(Calendar.YEAR));
        assertEquals(3, c.get(Calendar.MONTH));
        assertEquals(26, c.get(Calendar.DAY_OF_MONTH));
        try {
            FixUtils.utcTimestampConverter.convert("2000042x-12:05:06.555".getBytes());
            fail();
        } catch (Exception e) {
            // expected
        }
    }

	@Test
    public void testUtcTimeOnlyConversion() throws Exception {
        Calendar c = new GregorianCalendar(0, 0, 0, 12, 5, 6);
        c.setTimeZone(TimeZone.getTimeZone("UTC"));
        c.set(Calendar.MILLISECOND, 555);
        assertEquals("12:05:06.555", FixUtils.utcTimeOnlyConverter.convert(c.getTime()));

        Date date = FixUtils.utcTimeOnlyConverter.convert("12:05:06.555".getBytes());
        c.setTime(date);
        assertEquals(12, c.get(Calendar.HOUR_OF_DAY));
        assertEquals(5, c.get(Calendar.MINUTE));
        assertEquals(6, c.get(Calendar.SECOND));
        assertEquals(555, c.get(Calendar.MILLISECOND));
        // oh yeah now we are testing!!
        assertEquals(c.get(Calendar.YEAR), c.get(Calendar.YEAR));
        assertEquals(c.get(Calendar.MONTH), c.get(Calendar.MONTH));
        assertEquals(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.DAY_OF_MONTH));
        try {
            FixUtils.utcTimeOnlyConverter.convert("I2:05:06.555".getBytes());
            fail();
        } catch (Exception e) {
            // expected
        }
    }

	@Test
    public void testUtcDateOnlyConversion() throws Exception {
        Calendar c = new GregorianCalendar(2000, 3, 26, 0, 0, 0);
        c.setTimeZone(TimeZone.getTimeZone("UTC"));
        c.set(Calendar.MILLISECOND, 555);
        assertEquals("20000426", FixUtils.utcDateOnlyConverter.convert(c.getTime()));

        Date date = FixUtils.utcDateOnlyConverter.convert("20000426".getBytes());
        c.setTime(date);
        assertEquals(0, c.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, c.get(Calendar.MINUTE));
        assertEquals(0, c.get(Calendar.SECOND));
        assertEquals(0, c.get(Calendar.MILLISECOND));
        assertEquals(2000, c.get(Calendar.YEAR));
        assertEquals(3, c.get(Calendar.MONTH));
        assertEquals(26, c.get(Calendar.DAY_OF_MONTH));
        try {
        	Date d = FixUtils.utcDateOnlyConverter.convert("2000042b".getBytes());
        	fail();
        } catch(Exception e) {};
    }

}