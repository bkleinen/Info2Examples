package permutations;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PermutationsTest {
	Permutations perms;

	@Before
	public void setUp() throws Exception {
		perms = new Permutations();
	}

	@Test
	public void testWithout() {
		assertEquals("acd", perms.without("abcd", 1));
	}

	public void output(List<String> permutations) {
		/*
		 * for (String s : permutations) System.out.println(s);
		 */
	}

	@Test
	public void test1() {
		List<String> permutations = perms.compute("a");
		assertEquals(1, permutations.size());
		assertEquals("a", permutations.get(0));
		output(permutations);

	}

	@Test
	public void test2() {
		List<String> permutations = perms.compute("ab");
		assertEquals(2, permutations.size());
		assertTrue(permutations.contains("ba"));
		assertTrue(permutations.contains("ab"));
		output(permutations);
	}

	@Test
	public void test3() {
		List<String> permutations = perms.compute("abc");
		assertEquals(6, permutations.size());
		assertTrue(permutations.contains("abc"));
		assertTrue(permutations.contains("acb"));
		assertTrue(permutations.contains("bac"));
		assertTrue(permutations.contains("bca"));
		assertTrue(permutations.contains("cab"));
		assertTrue(permutations.contains("cba"));
		output(permutations);
	}

	@Test
	public void test4() {
		List<String> permutations = perms.compute("abcd");
		assertEquals(24, permutations.size());
		output(permutations);
	}

	@Test
	public void testMate() {
		List<String> permutations = perms.compute("mate");
		assertEquals(24, permutations.size());
		assertTrue(permutations.contains("atem"));
		assertTrue(permutations.contains("meta"));
		assertTrue(permutations.contains("team"));
		assertTrue(permutations.contains("meat"));
		assertTrue(permutations.contains("tame"));
		output(permutations);
	}

}
