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

package org.tomac.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;
import org.tomac.utils.Utils;

public class TestFieldConverters {

	@Test
    public void testIntegerConversion() throws Exception {
    	byte[] out = new byte[3];
    	Utils.longToNumeric(out, 0, 123, out.length);
        assertTrue(Utils.equals("123".getBytes(), out));
        assertEquals(123L, Utils.longValueOf("123".getBytes(), 0 , 3));
        Utils.fill(out, (byte) ' ');
    	Utils.longToNumeric(out, 0, -1, out.length);
        assertTrue(new String(out), Utils.equals("-01".getBytes(), out));
        try {
        	Utils.longValueOf("abc".getBytes(), 0 , 3);
        	fail();
        } catch (Exception e) {}
        try {
        	long val = Utils.longValueOf("123.4".getBytes(), 0 , 3);
            assertEquals(123L, val);
        } catch (Exception e) { fail();}
        try {
        	Utils.longValueOf("+200".getBytes(), 0 , 3);
        	fail();
        } catch (Exception e) {}
    }

	@Test
    public void testDoubleConversion() throws Exception {
        assertEquals("45.32", Utils.FixFloatConverter.convert(453200));
        assertEquals("0.45", Utils.FixFloatConverter.convert(4500));
        assertEquals("-0.1", Utils.FixFloatConverter.convert(-1000));
        assertEquals("-0.01", Utils.FixFloatConverter.convert(-100));
        assertEquals("0.0", Utils.FixFloatConverter.convert(0));
        assertEquals(453200L, Utils.FixFloatConverter.convert("45.32".getBytes()), 0);
        assertEquals(453200L, Utils.FixFloatConverter.convert("45.3200".getBytes()), 0);
        assertEquals(34024400000L, Utils.FixFloatConverter.convert("0003402440.00".getBytes()), 0);
        assertEquals(453200L, Utils.FixFloatConverter.convert("45.32".getBytes()), 0);
        assertEquals(12010000L, Utils.FixFloatConverter.convert("1201".getBytes()), 0);
        assertEquals(0L, Utils.FixFloatConverter.convert("0.0".getBytes()), 0);
        assertEquals(453200L, Utils.FixFloatConverter.convert("0045.32".getBytes()), 0);
        assertEquals(0L, Utils.FixFloatConverter.convert("0.".getBytes()), 0);
        assertEquals(0L, Utils.FixFloatConverter.convert(".0".getBytes()), 0);
        assertEquals(600L, Utils.FixFloatConverter.convert("000.06".getBytes()), 0);
        assertEquals(600L, Utils.FixFloatConverter.convert("0.0600".getBytes()), 0);

        try {
        	Utils.FixFloatConverter.convert("abc".getBytes());
        	fail();
        } catch (Exception e) { }
        try {
        	Utils.FixFloatConverter.convert("123.A".getBytes());
        	fail();
        } catch (Exception e) {};
        long val = Utils.FixFloatConverter.convert(".".getBytes());
        assertEquals(0L,val);
        
        assertEquals("1.5", Utils.FixFloatConverter.convert(1500, 3));
        assertEquals("45.0", Utils.FixFloatConverter.convert(4500000, 5));
        assertEquals("5.0", Utils.FixFloatConverter.convert(500, 2));
        assertEquals("-5.0", Utils.FixFloatConverter.convert(-500, 2));
        assertEquals("-122.345", Utils.FixFloatConverter.convert(-122345, 3));
        assertEquals("0.0", Utils.FixFloatConverter.convert(0, 1));

    }

	@Test
    public void testCharConversion() throws Exception {
        assertEquals("a", Utils.CharConverter.convert('a'));
        assertEquals("1", Utils.CharConverter.convert('1'));
        assertEquals("F", Utils.CharConverter.convert('F'));
        assertEquals((byte)'a', Utils.CharConverter.convert("a"));
        assertEquals((byte)'1', Utils.CharConverter.convert("1"));
        assertEquals((byte)'F', Utils.CharConverter.convert("F"));
        try {
            Utils.CharConverter.convert("a1");
            fail();
        } catch (Exception e) {
            // expected
        }
    }

	@Test
    public void testBooleanConversion() throws Exception {
        assertEquals("Y", Utils.BooleanConverter.convert(true));
        assertEquals("N", Utils.BooleanConverter.convert(false));
        assertEquals(true, Utils.BooleanConverter.convert("Y"));
        assertEquals(false, Utils.BooleanConverter.convert("N"));
        try {
            Utils.BooleanConverter.convert("D");
            fail();
        } catch (Exception e) {
            // expected
        }
        try {
            Utils.BooleanConverter.convert("true");
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
        assertEquals("20000426-12:05:06.555", Utils.utcTimestampConverter.convert(c.getTime()));

        Date date = Utils.utcTimestampConverter.convert("20000426-12:05:06.555".getBytes());
        c.setTime(date);
        assertEquals(12, c.get(Calendar.HOUR_OF_DAY));
        assertEquals(5, c.get(Calendar.MINUTE));
        assertEquals(6, c.get(Calendar.SECOND));
        assertEquals(555, c.get(Calendar.MILLISECOND));
        assertEquals(2000, c.get(Calendar.YEAR));
        assertEquals(3, c.get(Calendar.MONTH));
        assertEquals(26, c.get(Calendar.DAY_OF_MONTH));
        try {
            Utils.utcTimestampConverter.convert("2000042x-12:05:06.555".getBytes());
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
        assertEquals("12:05:06.555", Utils.utcTimeOnlyConverter.convert(c.getTime()));

        Date date = Utils.utcTimeOnlyConverter.convert("12:05:06.555".getBytes());
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
            Utils.utcTimeOnlyConverter.convert("I2:05:06.555".getBytes());
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
        assertEquals("20000426", Utils.utcDateOnlyConverter.convert(c.getTime()));

        Date date = Utils.utcDateOnlyConverter.convert("20000426".getBytes());
        c.setTime(date);
        assertEquals(0, c.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, c.get(Calendar.MINUTE));
        assertEquals(0, c.get(Calendar.SECOND));
        assertEquals(0, c.get(Calendar.MILLISECOND));
        assertEquals(2000, c.get(Calendar.YEAR));
        assertEquals(3, c.get(Calendar.MONTH));
        assertEquals(26, c.get(Calendar.DAY_OF_MONTH));
        try {
        	Date d = Utils.utcDateOnlyConverter.convert("2000042b".getBytes());
        	fail();
        } catch(Exception e) {};
    }

}