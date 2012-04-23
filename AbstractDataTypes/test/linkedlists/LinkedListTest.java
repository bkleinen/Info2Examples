package linkedlists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import linkedlists.LinkedList;
import linkedlists.LinkedListDummyNode;
import linkedlists.LinkedListSimple;

@RunWith(Parameterized.class)
public class LinkedListTest<E> {
	// a factory is needed such that each test run gets it's own instance.
	static abstract class Factory {
		abstract LinkedList<String> createList();
	}

	Factory factory;
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
		assertEquals("a", list.removeLast());
		assertEquals("b", list.removeLast());
		assertTrue(list.isEmpty());
	}

	@Ignore
	public void testEqualsStringArrayEmpty() {
		LinkedListSimple<String> list = new LinkedListSimple<String>();
		String[] empty = {};
		assertTrue(list.equals(empty));
	}

	@Ignore
	public void testEqualsStringArrayOne() {
		list.appendFirst("a");
		String[] one = { "a" };
		assertTrue(list.equals(one));
	}

	@Test
	public void testInsert() {
		list.appendFirst("a");
		list.appendFirst("b");
		list.appendFirst("d");
		list.appendFirst("e");
		list.insert("c");

		assertEquals("a", list.removeLast());
		assertEquals("b", list.removeLast());
		assertEquals("c", list.removeLast());
		assertEquals("d", list.removeLast());
		assertEquals("e", list.removeLast());

	}

	@Test
	public void testInsertFirst() {
		list.appendFirst("b");
		list.appendFirst("c");
		list.appendFirst("d");

		list.insert("a");

		assertEquals("a", list.removeLast());
		assertEquals("b", list.removeLast());
		assertEquals("c", list.removeLast());
		assertEquals("d", list.removeLast());
		assertTrue(list.isEmpty());

	}

	@Test
	public void testInsertEnd() {
		list.appendFirst("a");
		list.appendFirst("b");
		list.appendFirst("c");
		list.appendFirst("d");
		list.insert("e");

		assertEquals("a", list.removeLast());
		assertEquals("b", list.removeLast());
		assertEquals("c", list.removeLast());
		assertEquals("d", list.removeLast());
		assertEquals("e", list.removeLast());

	}

	@Test
	public void testRemove() {
		list.appendFirst("a");
		list.appendFirst("b");
		list.appendFirst("c");
		list.appendFirst("d");

		list.remove("b");

		assertEquals("a", list.removeLast());
		assertEquals("c", list.removeLast());
		assertEquals("d", list.removeLast());
		assertTrue(list.isEmpty());
	}

	@Test
	public void testRemoveFirst() {
		list.appendFirst("a");
		list.appendFirst("b");
		list.appendFirst("c");
		list.appendFirst("d");

		list.remove("a");

		assertEquals("b", list.removeLast());
		assertEquals("c", list.removeLast());
		assertEquals("d", list.removeLast());
		assertTrue(list.isEmpty());
	}

	@Test
	public void testRemoveLast() {
		list.appendFirst("a");
		list.appendFirst("b");
		list.appendFirst("c");
		list.appendFirst("d");

		list.remove("d");

		assertEquals("a", list.removeLast());
		assertEquals("b", list.removeLast());
		assertEquals("c", list.removeLast());
		assertTrue(list.isEmpty());
	}

	@Test
	public void testToString() {
		list.appendFirst("a");
		list.appendFirst("b");
		list.appendFirst("c");
		list.appendFirst("d");
		list.appendFirst("e");
		assertEquals("(a, b, c, d, e)", list.toString());
	}
}
