package linkedlists;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import linkedlists.LinkedListTest.Factory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LinkedListIteratorTest {
	public Factory factory;
	LinkedList<String> list;
	Iterator<String> iterator;

	public LinkedListIteratorTest(Factory factory) {
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
		list.appendFirst("a");
		list.appendFirst("b");
		list.appendFirst("c");
		list.appendFirst("d");
		list.appendFirst("e");
		iterator = list.iterator();

	}

	@Test
	public void testHasNext_next() {
	
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertEquals("c", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("d", iterator.next());
		assertEquals("e", iterator.next());
		assertFalse("end reached",iterator.hasNext());
	}

	@Test
	public void testRemove() {
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertEquals("c", iterator.next());
		iterator.remove();
		assertEquals("a", list.removeLast());
		assertEquals("b", list.removeLast());
		assertEquals("d", list.removeLast());
		assertEquals("e", list.removeLast());
		
	}

}
