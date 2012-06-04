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

public class AVLTreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRotateLeftRight() {

		AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(21);
		it.insert(19);
		String initialOrder = it.toString();
		// given
		assertTrue(it.isBalanced());
		assertEquals("(5-12-(19-20-21))", it.toStringTree());
		// when
		it.rotateLeft(it.find(20));
		// then
		assertEquals("I - initial Order must not be destroyed", initialOrder,
				it.toString());
		assertEquals("(5-12-((19-20-)-21-))", it.toStringTree());
		assertFalse(it.isBalanced());
		// when
		it.rotateRight(it.find(21));
		// then
		assertEquals("II - initial Order must not be destroyed", initialOrder,
				it.toString());
		assertEquals("(5-12-(19-20-21))", it.toStringTree());
		assertTrue(it.isBalanced());
	}

	@Test
	public void testRotateRightLeft() {

		AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
		it.insert(12);
		it.insert(5);
		it.insert(20);
		it.insert(21);
		it.insert(19);
		String initialOrder = it.toString();
		assertEquals("(5-12-(19-20-21))", it.toStringTree());
		it.rotateRight(it.find(20));

		assertEquals("I - initial Order must not be destroyed", initialOrder,
				it.toString());
		assertEquals("(5-12-(-19-(-20-21)))", it.toStringTree());
		it.rotateLeft(it.find(19));
		assertEquals("II - initial Order must not be destroyed", initialOrder,
				it.toString());
		assertEquals("(5-12-(19-20-21))", it.toStringTree());
	}

	@Test
	public void testIsBalanced() {
		AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
		it.insert(12);
		AVLTree<Integer, Object>.Node root = it.root;
		assertTrue(it.isBalanced());
		root.rightChild = it.new Node(5, null);
		assertTrue(it.isBalanced());
		root.rightChild.rightChild = it.new Node(5, null);
		assertFalse(it.isBalanced());
		root.leftChild = it.new Node(5, null);
		assertTrue(it.isBalanced());

	}

	@Test
	public void testIsBalancedInsert() {
		AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
		it.insert(12);
		assertTrue(it.isBalanced());
		it.insert(5);
		assertTrue(it.isBalanced());
		it.insert(2);
		assertTrue(it.isBalanced());
		it.insert(24);
		assertTrue(it.isBalanced());

	}

	@Test
	public void randomTest() {
		for (int j = 0; j < 1000; j++) {
			// int number = (int) (Math.random() * j) + 1;
			int number = j;
			SortedSet<Integer> list = new TreeSet<Integer>();
			AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
			List<Integer> insertionOrder = new ArrayList<Integer>();
			for (int i = 0; i < number; i++) {
				int randomNumber = (int) (Math.random() * 100);
				if (list.add(randomNumber)) {
					insertionOrder.add(randomNumber);
					it.insert(randomNumber);
					assertTrue(
							"tree size: " + j + " " + insertionOrder.toString()
									+ "\n" + it.toStringTree(), it.isBalanced());
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
			assertTrue(
					"pre-check: " + j + " " + originalInsertionOrder.toString()
							+ "\n"

							+ it.toStringTree(), it.isBalanced());

			// now remove random elements
			String removed = "";
			for (int i = 0; (i < (number + 1) / 2) && insertionOrder.size() > 0; i++) {
				int randomIndex = (int) (Math.random() * insertionOrder.size());
				int numberToRemove = insertionOrder.remove(randomIndex);
				removed += ", " + numberToRemove;
				list.remove(numberToRemove);
				assertTrue(it.isBalanced());
				// when
				it.delete(numberToRemove);
				assertTrue(
						"tree size: " + j + " "
								+ originalInsertionOrder.toString() + "\n"
								+ "after removal of" + removed + "\n"
								+ it.toStringTree(), it.isBalanced());

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
	public void manualTest() {
		Integer[] values = { 61, 93, 53, 64, 37 };
		AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
		for (int i = 0; i < values.length; i++) {
			it.insert(values[i]);
			assertTrue("after inserting " + i + " " + values[i],
					it.isBalanced());
		}
		it.insert(66);
		// assertEquals("((37-53-)-61-(-64-(66-93-)))",it.toStringTree());
		assertTrue(it.isBalanced());
	}

	@Test
	public void testDeleteRoot() {
		Integer[] values = { 71, 90, 27, 61 };
		AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
		for (int i = 0; i < values.length; i++)
			it.insert(values[i]);
		assertTrue(it.isBalanced());
		assertEquals("((-27-61)-71-90)", it.toStringTree());

		// when
		it.delete(71);
		// then
		assertEquals("(27-61-90)", it.toStringTree());
		assertTrue(it.isBalanced());

	}

	@Test
	public void testDeleteInner() {
		Integer[] values = { 43, 47, 61, 48, 65, 81, 66, 84 };
		AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
		for (int i = 0; i < values.length; i++)
			it.insert(values[i]);
		assertTrue(it.isBalanced());
		assertEquals("((43-47-48)-61-(65-66-(-81-84)))", it.toStringTree());

		// when
		it.delete(61);
		// then
		// assertEquals("((43-47-48)-61-(65-66-(-81-84)))", it.toStringTree());
		assertTrue(it.isBalanced());

	}

	@Test
	public void testDelete22() {
		Integer[] values = { 28, 20, 2, 72, 57, 9, 81, 17, 95, 23, 33, 96, 87,
				5, 52, 45, 47, 73, 30 };
		AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
		for (int i = 0; i < values.length; i++)
			it.insert(values[i]);
		assertTrue(it.isBalanced());
		// assertEquals("((43-47-48)-61-(65-66-(-81-84)))", it.toStringTree());

		// when
		it.delete(52);
		// then
		// assertEquals("((43-47-48)-61-(65-66-(-81-84)))", it.toStringTree());
		assertTrue(it.isBalanced());

	}

	/**
	 * java.lang.AssertionError: tree size: 28 [92, 12, 3, 38, 54, 1, 47, 95,
	 * 23, 73, 93, 69, 89, 11, 55, 35, 96, 32, 9, 33, 21, 45, 17, 88] after
	 * removal of, 47, 93, 55, 92
	 * (((1-3-(9-11-))-12-(((17-21-23)-32-33)-35-(38-45
	 * -)))-54-((69-73-88)-89-(-95-96)))
	 */
	@Test
	public void testDelete28() {
		Integer[] values = { 92, 12, 3, 38, 54, 1, 47, 95, 23, 73, 93, 69, 89,
				11, 55, 35, 96, 32, 9, 33, 21, 45, 17, 88 };
		AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
		for (int i = 0; i < values.length; i++)
			it.insert(values[i]);
		assertTrue(it.isBalanced());
		it.delete(47);
		it.delete(93);
		it.delete(55);
		assertTrue(it.isBalanced());

		// when
		it.delete(92);
		// then
		it.computeAllBalanceFactors();
		assertTrue(it.isBalanced());

	}

	/**
	 * java.lang.AssertionError: tree size: 22 [73, 30, 78, 34, 16, 65, 46, 22,
	 * 67, 15, 71, 47, 24, 89, 55, 84, 77, 27, 99, 51, 29] after removal of, 34
	 * (((15-16-)-22-(24-27-(29-30-)))-46-((-47-(51-55-65))-67-((71-73-77)-78-(
	 * 84-89-99))))
	 */
	@Test
	public void testDelete22b() {
		Integer[] values = { 73, 30, 78, 34, 16, 65, 46, 22, 67, 15, 71, 47,
				24, 89, 55, 84, 77, 27, 99, 51, 29 };
		AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
		for (int i = 0; i < values.length; i++)
			it.insert(values[i]);
		it.computeAllBalanceFactors();
		// when
		it.delete(34);
		// then
		it.computeAllBalanceFactors();
		assertTrue(it.isBalanced());

	}

	@Test
public void classRoomExample(){
	
	Integer[] values = {10, 40, 35, 25, 60, 30, 80, 50, 27, 28, 38};
	AVLTree<Integer, Object> it = new AVLTree<Integer, Object>();
	for (int i = 0; i < values.length; i++)
		it.insert(values[i]);
	assertEquals("((10-25-(27-28-30))-35-((38-40-50)-60-80))",it.toStringTree());

}
}
