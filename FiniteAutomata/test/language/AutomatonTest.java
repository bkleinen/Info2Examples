package language;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AutomatonTest {

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { { "ab", true }, { "aab", true },
				{ "aaaaaab", true }, { "ath", true }, { "aath", true },
				{ "athab", true },

				{ "abb", false }, { "aabb", false }, { "aaaabaat", false },
				{ "aht", false }, { "aabth", false }, { "athaabah",false } });
	}

	Automaton a;
	String input;
	boolean accepted = false;

	public AutomatonTest(String input, boolean accepted) {
		this.input = input;
		this.accepted = accepted;
	}

	@Before
	public void setUp() {
		a = new Automaton(true);
	}

	@Test
	public void testReadAccepts() {
		if (accepted)
			assertTrue(input + " should be accepted: ", a.read(input));
		else
			assertFalse(input + " should not be accepted: ", a.read(input));
	}
}
