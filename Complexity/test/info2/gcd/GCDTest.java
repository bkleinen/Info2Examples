package info2.gcd;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GCDTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 12, 6, 6 },{ 1, 2, 1 },
				{ 8, 12, 4 }, { 1, 1, 1 }, { 48, 36, 12 }, { 36, 48, 12 }
				,{884, 3009,17}});

	}

	GCD gcd = new GCD();
	int a, b, expected;

	public GCDTest(int a, int b, int gcd) {
		this.a = a;
		this.b = b;
		this.expected = gcd;
	}

	@Test
	public void testEuclid1() {
		assertEquals(expected, gcd.euclid1(a, b));
	}

	@Test
	public void testEuclid2() {
		assertEquals(expected, gcd.euclid2(a, b));
	}

	@Test
	public void testGcd() {
		assertEquals(expected, gcd.gcd(a, b));
	}

	@Test
	public void testStrange() {
		assertEquals(expected, gcd.strange(a, b));
	}

	@Test
	public void testStranger() {
		assertEquals(expected, gcd.stranger(a, b));
	}
}
