package examples;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DecimalTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDecimal() {
		assertEquals("1369", (new Decimal()).decimal(1369));
	}

	@Test
	public void testPrintDecimal() {
		(new Decimal()).printDecimal(1369);
	}

}
