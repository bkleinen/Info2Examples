import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import examples.Factorial;

@RunWith(Parameterized.class)
public class FactorialTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { {0,1},{1,1},{2,2},{3,6},{4,24},{5,120},{6,720},{20,2432902008176640000L} });
	}

	private int input;
	private long expected;
	Factorial factorial;

	public FactorialTest(int input, long expected) {
		this.input = input;
		this.expected = expected;
	}

	@Before
	public void setUp() throws Exception {
		factorial = new Factorial();
	}

	@Test
	public void testFactorial() {
		assertEquals(expected, factorial.factorial(input));
	}

 
	
}
