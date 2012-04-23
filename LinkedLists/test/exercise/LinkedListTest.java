package exercise;

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

@RunWith(Parameterized.class)
public class LinkedListTest<E> {

	static abstract class LLFactory {
		abstract LinkedList<String> list();
	}

	LLFactory factory;
	LinkedList<String> list;

	public LinkedListTest(LLFactory factory) {
		this.factory = factory;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { new LLFactory() {
			LinkedList<String> list() {
				return new LinkedListSimple<String>();
			}
		} }, { new LLFactory() {
			LinkedList<String> list() {
				return new LinkedListDummyNode<String>();
			}
		} } };
		return Arrays.asList(data);
	}

	@Before
	public void setUp() {
		list = factory.list();

	}

	@Test
	public void aNewListIsEmpty() {
		assertTrue("empty list is empty", list.isEmpty());
	}

	@Test
	public void listWithOneElementIsNotEmpty() {
		list.append("hallo");
		assertFalse("listWithOneElementIsNotEmpty", list.isEmpty());
	}

	@Test
	public void testAppend1() {
		list.append("hallo");
		assertEquals("hallo", list.pop());
		assertTrue("after pop the list should be empty", list.isEmpty());
	}

	@Test
	public void testAppend2() {
		list.append("a");
		list.append("b");
		assertEquals("a", list.pop());
		assertEquals("b", list.pop());
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
		list.append("a");
		String[] one = { "a" };
		assertTrue(list.equals(one));
	}

	@Test
	public void testInsert() {
		list.append("a");
		list.append("b");
		list.append("d");
		list.append("e");
		list.insert("c");

		assertEquals("a", list.pop());
		assertEquals("b", list.pop());
		assertEquals("c", list.pop());
		assertEquals("d", list.pop());
		assertEquals("e", list.pop());

	}

	@Test
	public void testInsertFirst() {
		list.append("b");
		list.append("c");
		list.append("d");

		list.insert("a");

		assertEquals("a", list.pop());
		assertEquals("b", list.pop());
		assertEquals("c", list.pop());
		assertEquals("d", list.pop());
		assertTrue(list.isEmpty());

	}

	@Test
	public void testInsertEnd() {
		list.append("a");
		list.append("b");
		list.append("c");
		list.append("d");
		list.insert("e");

		assertEquals("a", list.pop());
		assertEquals("b", list.pop());
		assertEquals("c", list.pop());
		assertEquals("d", list.pop());
		assertEquals("e", list.pop());

	}

	@Test
	public void testRemove() {
		list.append("a");
		list.append("b");
		list.append("c");
		list.append("d");

		list.remove("b");

		assertEquals("a", list.pop());
		assertEquals("c", list.pop());
		assertEquals("d", list.pop());
		assertTrue(list.isEmpty());
	}

	@Test
	public void testRemoveFirst() {
		list.append("a");
		list.append("b");
		list.append("c");
		list.append("d");

		list.remove("a");

		assertEquals("b", list.pop());
		assertEquals("c", list.pop());
		assertEquals("d", list.pop());
		assertTrue(list.isEmpty());
	}

	@Test
	public void testRemoveLast() {
		list.append("a");
		list.append("b");
		list.append("c");
		list.append("d");

		list.remove("d");

		assertEquals("a", list.pop());
		assertEquals("b", list.pop());
		assertEquals("c", list.pop());
		assertTrue(list.isEmpty());
	}

	@Test
	public void testToString() {
		list.append("a");
		list.append("b");
		list.append("c");
		list.append("d");
		list.append("e");
		assertEquals("(a, b, c, d, e)", list.toString());
	}
}
