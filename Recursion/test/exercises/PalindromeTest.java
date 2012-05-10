package exercises;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class PalindromeTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
				{"anna",true},{"lagerregal",true},{"lagerregale",false},
				{"23532",true},{"3532",false},{"a",true},{"bb",true},
				{"",true},{"ja",false},{"gestaltung",false} });
	}
	String candidate;boolean isPalindrome;
	Exercises e = new Exercises();
	public PalindromeTest(String candidate,boolean isPalindrome){
		this.candidate = candidate;
		this.isPalindrome = isPalindrome;
	}
	@Test
	public void testIsPalindromeReverse() {
		assertEquals(candidate,isPalindrome,e.isPalindromeUsingReverse(candidate));
	}

	@Test
	public void testIsPalindromeRecursive() {
		assertEquals(candidate,isPalindrome,e.isPalindromeRecursive(candidate));
	}

	@Test
	public void testIsPalindromeStack() {
		assertEquals(candidate,isPalindrome,e.isPalindromeStack(candidate));
	}

	@Test
	public void testIsPalindromeLoop() {
		assertEquals(candidate,isPalindrome,e.isPalindromeLoop(candidate));
	}

}
