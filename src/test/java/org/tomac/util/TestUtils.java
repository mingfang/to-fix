/**
 * Copyright (c) 2011 Sebastian Tomac (tomac.org)
 * Licensed under LGPL licenses.
 * You may obtain a copy of the License at http://www.gnu.org/copyleft/lgpl.html
 **/
package org.tomac.util;


import static org.junit.Assert.*;

import java.nio.ByteBuffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.tomac.utils.Utils;

/**
 * @author seto
 *
 */
public class TestUtils {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testLongToNumericPadding() {
		byte[] buf = new byte[6];
		long val = 1234;
		
		try {
			Utils.fill(buf, (byte) ' ');
			Utils.longToNumeric(buf, 0, val, buf.length);
			int i = 0;
			byte[] expected = "001234".getBytes();
			assertArrayEquals(expected, buf);
		} catch (NumberFormatException n) {
			fail();
		}

		try {
			Utils.fill(buf, (byte) 0);
			Utils.longToNumeric(buf, 0, val, buf.length);
			int i = 0;
			byte[] expected = "001234".getBytes();
			assertArrayEquals(expected, buf);
			for (byte b : expected) {
				assertEquals(b, buf[i]);
				i++;
			}
		} catch (NumberFormatException n) {
			fail();
		}
	
	}
	
	@Test
	public void testLongValueOfPadding() {

		try {
			byte[] buf = "1234  ".getBytes();
			long val = Utils.longValueOf(buf, 0, buf.length);
			long expected = 1234;
			fail();
		} catch (NumberFormatException n) {
			assertTrue(true);
		}

		try {
			byte[] buf = "  1234".getBytes();
			long val = Utils.longValueOf(buf, 0, buf.length);
			long expected = 1234;
			assertEquals(expected, val);
		} catch (NumberFormatException n) {
			fail();
		}

		try {
			byte[] buf = "1234\0\0".getBytes();
			long val = Utils.longValueOf(buf, 0, buf.length);
			long expected = 1234;
			fail();
		} catch (NumberFormatException n) {
			assertTrue(true);
		}

		try {
			byte[] buf = "  1234".getBytes();
			buf[0] = (byte) 0;
			buf[1] = (byte) 0;
			long val = Utils.longValueOf(buf, 0, buf.length);
			long expected = 1234;
			assertEquals(expected, val);
		} catch (NumberFormatException n) {
			fail();
		}
		
	}	
	
	@Test
	public void testIntValueOfPadding() {

		try {
			byte[] buf = "1234  ".getBytes();
			int val = Utils.intValueOf(buf, 0, buf.length);
			int expected = 1234;
		} catch (NumberFormatException n) {
			assertTrue(true);
		}

		try {
			byte[] buf = "  1234".getBytes();
			int val = Utils.intValueOf(buf, 0, buf.length);
			int expected = 1234;
			assertEquals(expected, val);
		} catch (NumberFormatException n) {
			fail();
		}

		try {
			byte[] buf = "1234\0\0".getBytes();
			int val = Utils.intValueOf(buf, 0, buf.length);
			int expected = 1234;
		} catch (NumberFormatException n) {
			assertTrue(true);
		}

		try {
			byte[] buf = "  1234".getBytes();
			buf[0] = (byte) 0;
			buf[1] = (byte) 0;
			int val = Utils.intValueOf(buf, 0, buf.length);
			int expected = 1234;
			assertEquals(expected, val);
		} catch (NumberFormatException n) {
			fail();
		}
		
	}		
	
	@Test
	public void testLongToNumeric() {
		byte[] buf = new byte[4];
		long l = 1234;
		Utils.longToNumeric(buf, 0, l, 4);
		
		int i = 0;
		byte[] expected = "1234".getBytes();
		for (byte b : expected) {
			assertEquals(b, buf[i]);
			i++;
		}
	}
	
	@Test
	public void testTagValue() {
		// valid
		ByteBuffer buf = ByteBuffer.wrap("10".getBytes());
		int val =  Utils.intTagValueOf(buf, "10".length());
		assertEquals(10, val);
		
		// invalid signed
		buf = ByteBuffer.wrap("+10".getBytes());
		val =  Utils.intTagValueOf(buf, "+10".length());
		assertEquals(0, val);
		
		// invalid empty
		buf = ByteBuffer.wrap("".getBytes());
		val =  Utils.intTagValueOf(buf, "".length());
		assertEquals(0, val);

		// valid 0
		buf = ByteBuffer.wrap("0".getBytes());
		val =  Utils.intTagValueOf(buf, "0".length());
		assertEquals(0, val);

		// valid 0 paeede
		buf = ByteBuffer.wrap("010".getBytes());
		val =  Utils.intTagValueOf(buf, "010".length());
		assertEquals(10, val);
		
		
	}

}
