package regexp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegExpTester {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLiteral() {
		String patternString = "car";
		Pattern pattern = Pattern.compile(patternString);
		String stringToMatch = "carbla";
		Matcher matcher = pattern.matcher(stringToMatch);
		assertTrue(matcher.find());
		assertEquals("car", matcher.group());
		assertEquals(0, matcher.start());
		assertEquals(3, matcher.end());
		assertFalse(matcher.find());
	}

	@Test
	public void testEndOfPreviousMatch() {
		String patternString = "car";
		Pattern pattern = Pattern.compile(patternString);
		String stringToMatch = "carbla";
		Matcher matcher = pattern.matcher(stringToMatch);
		assertTrue(matcher.find());
		assertEquals("car", matcher.group());
		assertEquals(0, matcher.start());
		assertEquals(3, matcher.end());
	}

	@Test
	public void testGroups() {
		String patternString = "A((A)(B(C)))";
		Pattern pattern = Pattern.compile(patternString);
		String stringToMatch = "AABC";
		Matcher matcher = pattern.matcher(stringToMatch);
		assertTrue(matcher.find());
		assertEquals("AABC", matcher.group());
		assertEquals("AABC", matcher.group(0));
		assertEquals("ABC", matcher.group(1));
		assertEquals("A", matcher.group(2));
		assertEquals("BC", matcher.group(3));
		assertEquals("C", matcher.group(4));
	}

}
