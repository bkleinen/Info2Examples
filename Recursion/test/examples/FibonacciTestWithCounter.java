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
public class FibonacciTestWithCounter {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] { { 0, 0, 1 }, { 1, 1, 1 }, { 2, 1, 3 },
						{ 3, 2, 5 }, { 4, 3, 9 }, { 5, 5, 15 }, { 6, 8, 25 }, { 7, 13, 41 }, { 8, 21, 67 } });
	}

	private int fInput;

	private int fExpected;
	private int calls;
	private Fibonacci fib = new Fibonacci();;

	public FibonacciTestWithCounter(int input, int expected, int calls) {
		fInput = input;
		fExpected = expected;
		this.calls = calls;
	}

	@Test
	public void test() {
		Fibonacci.Counter c = fib.new Counter();
		long f = fib.fibCount(fInput, c);
		assertEquals(fExpected, f);
		assertEquals("calls", calls, c.getCounter());
	}
}