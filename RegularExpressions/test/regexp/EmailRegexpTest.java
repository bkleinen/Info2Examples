package regexp;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EmailRegexpTest {
	Pattern pattern;
	String email;
	boolean matches;
	int startIndex;
	int endIndex;

	public EmailRegexpTest(String email, boolean matches, int startIndex,
			int endIndex) {
		this.email = email;
		this.matches = matches;
		this.startIndex = startIndex;
		this.endIndex = endIndex;

	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { "a@x.de", true, 0, 6 } });

	}

	@Before
	public void setUp() throws Exception {
		pattern = Pattern
				.compile(RegExp.EMAIL_REGEXP, Pattern.CASE_INSENSITIVE);

	}

	@Test
	public void test() {
		Matcher matcher = pattern.matcher(email);
		assertEquals(matches,matcher.find());
		assertEquals(email, matcher.group());
		assertEquals(startIndex, matcher.start());
		assertEquals(endIndex, matcher.end());
		assertFalse(matcher.find());
	}

}
