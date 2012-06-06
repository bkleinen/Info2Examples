package searching;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SearchTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBinarySearch() {
		Search<Integer> s = new Search<Integer>();
		Integer[] a = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7 };
		for (int i = 0; i < a.length; i++) {
			assertEquals("i: " + i, i, s.binarySearch(a, i));

		}
		assertEquals(-1, s.binarySearch(a, 8));

	}
	@Test
	public void testBinarySearchRec() {
		Search<Integer> s = new Search<Integer>();
		Integer[] a = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7 };
		for (int i = 0; i < a.length; i++) {
			assertEquals("i: " + i, i, s.binarySearchRec(a, i));
		}
		assertEquals(-1, s.binarySearch(a, 8));

	}
	@Test
	public void testBinarySearchRec2() {
		Search<Integer> s = new Search<Integer>();
		Integer[] a = new Integer[] { 10, 11, 12, 13, 14, 15, 16, 17 };
		for (int i = 0; i < a.length; i++) {
			assertEquals("i: " + i, i, s.binarySearchRec(a, i+10));
		}
		assertEquals(-1, s.binarySearch(a, 8));

	}

}
