package examples;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import examples.Fibonacci;

@RunWith(Parameterized.class)
public class FibonacciTestSimple {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 },
				{ 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
	}

	private int fInput;

	private int fExpected;
	private Fibonacci fib = new Fibonacci();;
	

	public FibonacciTestSimple(int input, int expected) {
		fInput = input;
		fExpected = expected;
	}

	@Test
	public void test() {

		assertEquals(fExpected, fib.fib(fInput));
	}
}