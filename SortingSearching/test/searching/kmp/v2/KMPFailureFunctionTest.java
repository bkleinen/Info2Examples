package searching.kmp.v2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author kleinen
 * 
 */
@RunWith(Parameterized.class)
public class KMPFailureFunctionTest {
	KnuthMorrisPratt kmp = new KnuthMorrisPratt();
	String pattern;
	Integer[] expectedTable;

	public KMPFailureFunctionTest(String pattern, Integer[] expectedTable) {
		this.pattern = pattern;
		this.expectedTable = expectedTable;
	}

	@Before
	public void setUp() throws Exception {
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] {
						{ "ABAB", new Integer[] { 0, 0, 1, 2 } },
						{ "ABCDABD", new Integer[] { 0, 0, 0, 0, 1, 2, 0 } },
						{
								"PARTICIPATE IN PARACHUTE",
								new Integer[] { 0, 0, 0, 0, 0, 0, 0, 1, 2, 0,
										0, 0, 0, 0, 0, 1, 2, 3, 0, 0, 0, 0, 0,
										0 } },
						{ "ABCABCABCB",
			//			   000123456				 
								new Integer[] { 0, 0, 0, 1, 2, 3, 4, 5, 6, 0 } },
						{ "AB", new Integer[] { 0, 0 } } });
	}

	@Test
	public void testCreateFailureFunction() {
		int[] ff = kmp.createFailureFunction(pattern);
		assertEqualsArray(expectedTable, ff);
	}

	private void assertEqualsArray(Integer[] expected, int[] actual) {
		assertEquals("length ", expected.length, actual.length);
		for (int i = 0; i < expected.length; i++) {
			assertEquals("index " + i, (int) expected[i], actual[i]);
		}

	}

}
