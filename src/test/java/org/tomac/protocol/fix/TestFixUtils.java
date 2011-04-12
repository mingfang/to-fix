/**
 * Copyright (c) 2011 Sebastian Tomac (tomac.org)
 * Licensed under LGPL licenses.
 * You may obtain a copy of the License at http://www.gnu.org/copyleft/lgpl.html
 **/
package org.tomac.protocol.fix;


import static org.junit.Assert.*;

import java.nio.ByteBuffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author seto
 *
 */
public class TestFixUtils {

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
			FixUtils.fill(buf, (byte) ' ');
			FixUtils.longToNumeric(buf, 0, val, buf.length);
			int i = 0;
			byte[] expected = "  1234".getBytes();
			for (byte b : expected) {
				assertEquals(b, buf[i]);
				i++;
			}
		} catch (NumberFormatException n) {
			fail();
		}

		try {
			FixUtils.fill(buf, (byte) 0);
			FixUtils.longToNumeric(buf, 0, val, buf.length);
			int i = 0;
			byte[] expected = "  1234".getBytes();
			expected[0] = (byte) 0;
			expected[1] = (byte) 0;
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
			long val = FixUtils.longValueOf(buf, 0, buf.length);
			long expected = 1234;
			fail();
		} catch (NumberFormatException n) {
			assertTrue(true);
		}

		try {
			byte[] buf = "  1234".getBytes();
			long val = FixUtils.longValueOf(buf, 0, buf.length);
			long expected = 1234;
			assertEquals(expected, val);
		} catch (NumberFormatException n) {
			fail();
		}

		try {
			byte[] buf = "1234\0\0".getBytes();
			long val = FixUtils.longValueOf(buf, 0, buf.length);
			long expected = 1234;
			fail();
		} catch (NumberFormatException n) {
			assertTrue(true);
		}

		try {
			byte[] buf = "  1234".getBytes();
			buf[0] = (byte) 0;
			buf[1] = (byte) 0;
			long val = FixUtils.longValueOf(buf, 0, buf.length);
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
			int val = FixUtils.intValueOf(buf, 0, buf.length);
			int expected = 1234;
		} catch (NumberFormatException n) {
			assertTrue(true);
		}

		try {
			byte[] buf = "  1234".getBytes();
			int val = FixUtils.intValueOf(buf, 0, buf.length);
			int expected = 1234;
			assertEquals(expected, val);
		} catch (NumberFormatException n) {
			fail();
		}

		try {
			byte[] buf = "1234\0\0".getBytes();
			int val = FixUtils.intValueOf(buf, 0, buf.length);
			int expected = 1234;
		} catch (NumberFormatException n) {
			assertTrue(true);
		}

		try {
			byte[] buf = "  1234".getBytes();
			buf[0] = (byte) 0;
			buf[1] = (byte) 0;
			int val = FixUtils.intValueOf(buf, 0, buf.length);
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
		FixUtils.longToNumeric(buf, 0, l, 4);
		
		int i = 0;
		byte[] expected = "1234".getBytes();
		for (byte b : expected) {
			assertEquals(b, buf[i]);
			i++;
		}
	}

	@Test
	public void testPutLongToByteBuffer() {
		byte[] b;
		ByteBuffer out = ByteBuffer.wrap(new byte[24]);

		FixUtils.put(out, 0);
		b = new byte[1];
		out.position(0);
		out.get(b);
		assertTrue("0".equals(new String(b)));

		out.position(0);
		FixUtils.put(out, 100);
		b = new byte[3];
		out.position(0);
		out.get(b);
		assertTrue("100".equals(new String(b)));

		out.position(0);
		FixUtils.put(out, 1000);
		b = new byte[4];
		out.position(0);
		out.get(b);
		assertTrue("1000".equals(new String(b)));
		

		out.position(0);
		FixUtils.put(out, 1234567890);
		b = new byte[10];
		out.position(0);
		out.get(b);
		assertTrue("1234567890".equals(new String(b)));
		
		out.position(0);
		FixUtils.put(out, -1234567890);
		b = new byte[11];
		out.position(0);
		out.get(b);
		assertTrue("-1234567890".equals(new String(b)));

	}
	
}
