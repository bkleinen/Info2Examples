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
public class KnuthMorrisPrattTest {
	KnuthMorrisPratt kmp = new KnuthMorrisPratt();
	String stringToSearch;
	String pattern;
	int expectedMatchIndex;

	public KnuthMorrisPrattTest(String stringToSearch, String pattern,
			int expectedMatchIndex) {
		this.stringToSearch = stringToSearch;
		this.pattern = pattern;
		this.expectedMatchIndex = expectedMatchIndex;
	}

	@Before
	public void setUp() throws Exception {
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { "AB", "AB", 0 },
				{ "A", "BC", -1 }, { "ABC", "BC", 1 }, { "ABCD", "BC", 1 },
				{ "ABC ABCDAB ABCDABCDABDE", "ABCDABD", 15 },
				{ "ABC ABCDAB ABCDABCABDE", "ABCDABD", -1 } });
	}

	@Test
	public void testSearch() {
		int actualIndex = kmp.search(pattern, stringToSearch);
		assertEquals(pattern, expectedMatchIndex, actualIndex);
	}

}
