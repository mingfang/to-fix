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
