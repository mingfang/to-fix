package org.tomac.protocol.fix;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.tomac.protocol.fix.messaging.FixNewOrderSingle;

public class TestBigDecimalField {

	@Test
	public void testBigDecimalRoundTripping() throws Exception {
		// check to see if we have a BigDecimal constructor
		BigDecimal originalPrice = new BigDecimal("10.3000");
		assertEquals(4, originalPrice.scale());
		FixNewOrderSingle message = new FixNewOrderSingle();
		message.setPrice(10300); // 10.30
		byte[] out = "00.000".getBytes();
		FixUtils.longToFixFloat(out, 0, message.getPrice(), out.length);
		BigDecimal extractedPrice = new BigDecimal(new String(out));
		assertEquals(3, extractedPrice.scale());
		assertEquals(new BigDecimal("10.300"), extractedPrice);
	}
}
