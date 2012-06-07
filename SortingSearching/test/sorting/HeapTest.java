package sorting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {
	Heap<Integer> h;

	@Before
	public void setUp() throws Exception {
		h = new Heap<Integer>(new Integer[] { 3, 4, 2, 9, 3, 2, 1 });
	}

	@Test
	public void testLeft() {
		assertEquals(1, h.left(0));
		assertEquals(3, h.left(1));
	}

	@Test
	public void testRight() {
		assertEquals(2, h.right(0));
		assertEquals(6, h.right(2));
	}

	@Test
	public void isMaxHeap() {
		assertTrue("isMaxHeap", h.isMaxHeap());
	}

	@Test
	public void testHeapify() {
		h.maxHeapify();
		assertTrue("testHeapify", h.isMaxHeap());
	}
	/*
	 * @Test public void testHeapifyOnFourElements() { Heap<Integer> h = new
	 * Heap<Integer>(new Integer[] { 62, 94, 16, 18 }); h.maxHeapify(0);
	 * assertTrue("four ", h.isMaxHeap()); }
	 */
}
