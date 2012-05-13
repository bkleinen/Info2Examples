package linkedlists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LinkedListTest<E> {
	// a factory is needed such that each test run gets it's own instance.
	static abstract class Factory {
		abstract LinkedList<String> createList();
	}

	public Factory factory;
	LinkedList<String> list;

	public LinkedListTest(Factory factory) {
		this.factory = factory;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { new Factory() {
			LinkedList<String> createList() {
				return new LinkedListSimple<String>();
			}
		} }, { new Factory() {
			LinkedList<String> createList() {
				return new LinkedListDummyNode<String>();
			}
		} } };
		return Arrays.asList(data);
	}

	@Before
	public void setUp() {
		list = factory.createList();

	}

	@Test
	public void aNewListIsEmpty() {
		assertTrue("empty list is empty", list.isEmpty());
	}

	@Test
	public void listWithOneElementIsNotEmpty() {
		list.appendFirst("hallo");
		assertFalse("listWithOneElementIsNotEmpty", list.isEmpty());
	}

	@Test
	public void testAppend1() {
		list.appendFirst("hallo");
		assertEquals("hallo", list.removeLast());
		assertTrue("after pop the list should be empty", list.isEmpty());
	}

	@Test
	public void testAppend2() {
		list.appendFirst("a");
		list.appendFirst("b");
		assertEquals("b", list.removeFirst());
		assertEquals("a", list.removeLast());
		assertTrue(list.isEmpty());
	}

	@Test
	public void testAppendFirst() {
		list.appendFirst("x");
		list.appendFirst("first");
		assertEquals("(first, x)", list.toString());
	}

	@Test
	public void testAppendLast() {
		list.appendFirst("x");
		list.appendLast("last");
		assertEquals("(x, last)", list.toString());
	}

	@Test
	public void testInsert() {
		list.appendLast("a");
		list.appendLast("b");
		list.appendLast("d");
		list.appendLast("e");
		list.insert("c");
		assertEquals("(a, b, c, d, e)", list.toString());
	}

	@Test
	public void testRemoveFirst() {
		list.appendLast("a");
		list.appendLast("b");
		list.appendLast("c");
		list.appendLast("d");
		list.appendLast("e");
		assertEquals("(a, b, c, d, e)", list.toString());
		assertEquals("a", list.removeFirst());
		assertEquals("b", list.removeFirst());
		assertEquals("c", list.removeFirst());
		assertEquals("d", list.removeFirst());
		assertEquals("e", list.removeFirst());
	}

	@Test
	public void testRemoveLast() {
		list.appendFirst("a");
		list.appendLast("b");
		list.appendLast("c");
		list.appendLast("d");

		list.remove("d");

		assertEquals("a", list.removeLast());
		assertEquals("b", list.removeLast());
		assertEquals("c", list.removeLast());
		assertTrue(list.isEmpty());
	}

	@Test
	public void testRemove() {
		list.appendFirst("a");
		list.appendLast("b");
		list.appendLast("c");
		list.appendLast("d");

		list.remove("b");

		assertEquals("a", list.removeFirst());
		assertEquals("c", list.removeFirst());
		assertEquals("d", list.removeFirst());
		assertTrue(list.isEmpty());
	}

	@Test
	public void testToString() {
		list.appendFirst("a");
		list.appendFirst("b");
		list.appendFirst("c");
		list.appendFirst("d");
		list.appendFirst("e");
		assertEquals("(e, d, c, b, a)", list.toString());
	}
	@Test
	public void testPeek(){
		list.appendFirst("b");
		list.appendFirst("a");
		assertEquals("a",list.peek());
		assertEquals("a",list.removeFirst());	
	}
}
