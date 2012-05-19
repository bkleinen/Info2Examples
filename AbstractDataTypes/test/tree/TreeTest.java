package tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class TreeTest {
	Tree<String, Object> tree;

	@Before
	public void setUp() throws Exception {
		tree = new Tree<String, Object>();
	}

	@Test
	public void testInsertSimple() {
		tree.insert("hallo");
		assertEquals("hallo", tree.getRoot().key);
	}

	@Test
	public void testToStringSimple() {
		tree.insert("a");
		assertEquals("a", tree.toString());
	}

	@Test
	public void testInsertAndToString() {
		tree.insert("b");
		tree.insert("c");
		tree.insert("a");

		assertEquals("a, b, c", tree.toString());
		Tree<String, Object>.Node a = tree.find("a");
		Tree<String, Object>.Node b = tree.find("b");
		Tree<String, Object>.Node c = tree.find("c");
		assertEquals(b, a.parent);
		assertEquals(b, c.parent);
		assertEquals(null, b.parent);
	}

	@Test
	public void testMinimum() {
		tree.insert("b");
		tree.insert("c");
		tree.insert("a");

		assertEquals("a", tree.minimum().key);
	}

	@Test
	public void testInsertAndToStringInteger() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(11);
		it.insert(23);
		it.insert(28);
		it.insert(1);
		assertEquals("1, 5, 11, 12, 20, 23, 28", it.toString());
		assertEquals("((1-5-11)-12-(-20-(-23-28)))", it.toStringTree());
	}

	@Test
	public void testSuccessor() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(11);
		it.insert(23);
		it.insert(28);
		it.insert(1);
		assertEquals("1, 5, 11, 12, 20, 23, 28", it.toString());
		assertEquals("((1-5-11)-12-(-20-(-23-28)))", it.toStringTree());
		assertEquals(Integer.valueOf(11), it.successor(5).key);
		assertEquals(Integer.valueOf(5), it.successor(1).key);
		assertEquals(Integer.valueOf(12), it.successor(11).key);
		assertEquals(Integer.valueOf(20), it.successor(12).key);
		assertEquals(Integer.valueOf(23), it.successor(20).key);
		assertEquals(Integer.valueOf(28), it.successor(23).key);
	}

	@Test
	public void testDeleteLeaf() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.delete(20);
		assertEquals("5, 12", it.toString());
		Iterator<Integer> i = it.iterator();
		assertEquals(5, i.next().intValue());
		assertEquals(12, i.next().intValue());
		assertFalse(i.hasNext());
	}

	@Test
	public void testToStringTree1() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(2);
		it.insert(1);
		it.insert(3);
		assertEquals("(1-2-3)", it.toStringTree());

	}

	@Test
	public void testToStringTree2() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(5);
		it.insert(2);
		it.insert(1);
		it.insert(3);
		it.insert(7);
		it.insert(6);
		it.insert(8);
		assertEquals("((1-2-3)-5-(6-7-8))", it.toStringTree());

	}

	@Test
	public void testDeleteWithRightChild() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(21);
		assertEquals("(5-12-(-20-21))", it.toStringTree());
		it.delete(20);
		assertEquals("(5-12-21)", it.toStringTree());
		Iterator<Integer> i = it.iterator();
		assertEquals(5, i.next().intValue());
		assertEquals(12, i.next().intValue());
		assertEquals(21, i.next().intValue());
		assertFalse(i.hasNext());

	}

	@Test
	public void testDeleteWithTwoChilds1() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(21);
		it.insert(19);
		assertEquals("(5-12-(19-20-21))", it.toStringTree());
		it.delete(20);
		assertEquals("after deletion", "(5-12-(19-21-))", it.toStringTree());
		Iterator<Integer> i = it.iterator();
		assertEquals(5, i.next().intValue());
		assertEquals(12, i.next().intValue());
		assertEquals(19, i.next().intValue());
		assertEquals(21, i.next().intValue());
		assertFalse(i.hasNext());

	}

	@Test
	public void testDeleteWithTwoChilds2() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(21);
		it.insert(19);
		assertEquals("(5-12-(19-20-21))", it.toStringTree());
		it.delete(12);
		assertEquals("after deletion", "(5-19-(-20-21))", it.toStringTree());
		Iterator<Integer> i = it.iterator();
		assertEquals(5, i.next().intValue());
		assertEquals(19, i.next().intValue());
		assertEquals(20, i.next().intValue());
		assertEquals(21, i.next().intValue());
		assertFalse(i.hasNext());

	}

	@Test
	public void testDeleteWithTwoChilds3() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(19);
		it.insert(23);
		it.insert(21);
		it.insert(22);
		it.insert(24);

		assertEquals("(5-12-(19-20-((-21-22)-23-24)))", it.toStringTree());
		// (5-12-(19-21-(22-23-24)))
		it.delete(20);
		assertEquals("after deletion", "(5-12-(19-21-(22-23-24)))",
				it.toStringTree());
		Iterator<Integer> i = it.iterator();
		assertEquals(5, i.next().intValue());
		assertEquals(12, i.next().intValue());
		assertEquals(19, i.next().intValue());
		assertEquals(21, i.next().intValue());
		assertEquals(22, i.next().intValue());
		assertEquals(23, i.next().intValue());
		assertEquals(24, i.next().intValue());
		assertFalse(i.hasNext());

	}

	@Test
	public void testTransplant1() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(2);
		it.insert(1);
		it.insert(3);
		assertEquals("(1-2-3)", it.toStringTree());
		Tree<Integer, Object>.Node a = it.find(3);
		Tree<Integer, Object>.Node b = it.find(1);
		it.transplant(a, b);
		assertEquals("(-2-1)", it.toStringTree());
	}

	@Test
	public void testTransplant2() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(2);
		it.insert(1);
		it.insert(3);
		assertEquals("(1-2-3)", it.toStringTree());
		Tree<Integer, Object>.Node a = it.find(2);
		Tree<Integer, Object>.Node b = it.find(1);
		it.transplant(a, b);
		assertEquals("1", it.toStringTree());
	}

	@Test
	public void testReplaceRoot() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(2);
		it.insert(1);
		it.insert(3);
		// given
		assertEquals("(1-2-3)", it.toStringTree());
		Tree<Integer, Object>.Node a = it.find(2);
		Tree<Integer, Object>.Node b = it.new Node(10, null);
		Tree<Integer, Object>.Node l = it.find(1);
		Tree<Integer, Object>.Node r = it.find(3);
		// when
		it.replace(a, b);
		// then
		assertEquals("(1-10-3)", it.toStringTree());
		assertEquals(b, it.root);
		assertEquals(null, b.parent);
		assertEquals(l, b.leftChild);
		assertEquals(r, b.rightChild);
		assertEquals(b, l.parent);
		assertEquals(b, r.parent);
	}

	@Test
	public void testReplaceInner() {

		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(21);
		it.insert(19);
		assertEquals("(5-12-(19-20-21))", it.toStringTree());
		Tree<Integer, Object>.Node a = it.find(20);
		Tree<Integer, Object>.Node l = a.leftChild;
		Tree<Integer, Object>.Node r = a.rightChild;
		Tree<Integer, Object>.Node p = a.parent;

		Tree<Integer, Object>.Node b = it.new Node(10, null);
		// when
		it.replace(a, b);
		assertEquals("(5-12-(19-10-21))", it.toStringTree());

		// then
		assertEquals(b, p.rightChild);
		assertEquals(p, b.parent);
		assertEquals(l, b.leftChild);
		assertEquals(r, b.rightChild);
		assertEquals(b, l.parent);
		assertEquals(b, r.parent);

	}

	@Test
	public void testTransplant() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(2);
		it.insert(1);
		it.insert(4);
		it.insert(3);
		it.insert(5);
		assertEquals("(1-2-(3-4-5))", it.toStringTree());
		Tree<Integer, Object>.Node four = it.find(4);
		Tree<Integer, Object>.Node one = it.find(1);
		it.transplant(one, four);
		assertEquals("((3-4-5)-2-)", it.toStringTree());
	}

	@Test
	public void testIteratorSimple() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(2);
		Iterator<Integer> i = it.iterator();
		assertTrue(i.hasNext());
		assertEquals(2, i.next().intValue());
		assertFalse(i.hasNext());
	}

	@Test
	public void testIteratorMixed() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(2);
		it.insert(1);
		it.insert(4);
		it.insert(3);
		it.insert(5);
		Iterator<Integer> i = it.iterator();
		assertTrue(i.hasNext());
		assertEquals(1, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(2, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(3, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(4, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(5, i.next().intValue());
		assertFalse(i.hasNext());
	}

	@Test
	public void testIteratorDegenerated() {
		Tree<Integer, Object> it = new Tree<Integer, Object>();
		it.insert(1);
		it.insert(2);
		it.insert(3);
		it.insert(4);
		it.insert(5);
		Iterator<Integer> i = it.iterator();
		assertTrue(i.hasNext());
		assertEquals(1, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(2, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(3, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(4, i.next().intValue());
		assertTrue(i.hasNext());
		assertEquals(5, i.next().intValue());
		assertFalse(i.hasNext());
	}

	@Test
	public void randomBSTPropertyTest() {
		for (int j = 0; j < 100; j++) {
			int number = (int) (Math.random() * 100) + 1;
			SortedSet<Integer> list = new TreeSet<Integer>();
			AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
			for (int i = 0; i < number; i++) {
				int randomNumber = (int) (Math.random() * 100);
				if (list.add(randomNumber)) {
					it.insert(randomNumber);
				}
			}
			assertEquals("size", list.size(), it.size());
			Iterator<Integer> avlTreeIterator = it.iterator();
			for (int n : list) {
				assertEquals("x " + n, n, avlTreeIterator.next().intValue());

			}
		}

	}

	@Test
	public void testDelete() {
		AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
		it.insert(59);
		it.insert(55);
		it.insert(49);
		it.delete(55);
		it.delete(59);
		assertEquals(1, it.size());

	}

	@Test
	public void randomTestDeletion() {
		for (int j = 0; j < 1000; j++) {
			int number = j;
			SortedSet<Integer> list = new TreeSet<Integer>();
			AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
			List<Integer> insertionOrder = new ArrayList<Integer>();
			for (int i = 0; i < number; i++) {
				int randomNumber = (int) (Math.random() * 100);
				if (list.add(randomNumber)) {
					insertionOrder.add(randomNumber);
					it.insert(randomNumber);
				}
			}
			List<Integer> originalInsertionOrder = new ArrayList<Integer>(
					insertionOrder);

			// now remove random elements
			for (int i = 0; (i < (number + 1) / 2) && insertionOrder.size() > 0; i++) {
				int randomIndex = (int) (Math.random() * insertionOrder.size());
				int numberToRemove = insertionOrder.remove(randomIndex);
				list.remove(numberToRemove);
				it.delete(numberToRemove);

			}

			assertEquals("size \nlist:" + list + "\ntree: " + it.toStringTree()
					+ "\nh:" + originalInsertionOrder + "\n", list.size(),
					it.size());
			Iterator<Integer> avlTreeIterator = it.iterator();
			for (int n : list) {
				assertEquals("x " + list + "\n tree: " + it.toStringTree()
						+ "\n" + originalInsertionOrder, n, avlTreeIterator
						.next().intValue());
			}

		}
	}

	@Test
	public void testInsert22() {
		Integer[] values = { 28, 20, 2, 72, 57, 9, 81, 17, 95, 23, 33, 96, 87,
				5, 52, 45, 47, 73, 30 };
		AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
		for (int i = 0; i < values.length; i++) {
			if (values[i] ==5)
				System.out.println(5);
			it.insert(values[i]);
			/*
			 * assertTrue( "unbalanced after insertion of " + values[i] + "\n" +
			 * it.toString(), it.isBalanced());
			 */
		}
		assertTrue(it.isBalanced());

	
	}

}
