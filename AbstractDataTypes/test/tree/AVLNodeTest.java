package tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AVLNodeTest {
	AVLTree<Integer, Object> tree = new AVLTree<Integer, Object>();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void computeHeightAndBalanceFactorLeaf() {
		AVLTree<Integer, Object>.Node node = tree.new Node(4, null);
		assertEquals(-1, node.height());
	}

	@Test
	public void computeHeightAndBalanceFactorOneChild() {
		AVLTree<Integer, Object>.Node a = tree.new Node(4, null);
		AVLTree<Integer, Object>.Node b = tree.new Node(5, null);
		a.rightChild = b;
		assertEquals(0, a.height());
		a.computeBalanceFactor();
		assertEquals(-1, a.balanceFactor);
	}

	@Test
	public void computeHeightAndBalanceFactorTwoChilds() {
		AVLTree<Integer, Object>.Node a = tree.new Node(4, null);
		AVLTree<Integer, Object>.Node b = tree.new Node(5, null);
		AVLTree<Integer, Object>.Node c = tree.new Node(3, null);
		a.leftChild = b;
		a.rightChild = c;
		assertEquals(0, a.height());
		a.computeBalanceFactor();
		assertEquals(0, a.balanceFactor);
	}

	@Test
	public void computeHeightAndBalanceFactorTwo() {
		AVLTree<Integer, Object>.Node a = tree.new Node(4, null);
		AVLTree<Integer, Object>.Node b = tree.new Node(5, null);
		AVLTree<Integer, Object>.Node c = tree.new Node(3, null);
		AVLTree<Integer, Object>.Node d = tree.new Node(2, null);
		a.leftChild = b;
		a.rightChild = c;
		c.leftChild = d;
		assertEquals(1, a.height());
		a.computeBalanceFactor();
		assertEquals(-1, a.balanceFactor);
	}

	@Test
	public void computeHeightAndBalanceFactorThree() {
		AVLTree<Integer, Object>.Node a = tree.new Node(4, null);
		AVLTree<Integer, Object>.Node b = tree.new Node(5, null);
		AVLTree<Integer, Object>.Node c = tree.new Node(3, null);
		AVLTree<Integer, Object>.Node d = tree.new Node(6, null);
		AVLTree<Integer, Object>.Node e = tree.new Node(7, null);
		a.leftChild = b;
		a.rightChild = c;
		c.rightChild = d;
		d.rightChild = e;
		assertEquals(2, a.height());
		a.computeBalanceFactor();
		assertEquals(-2, a.balanceFactor);
	}
	@Test
	public void computeHeightAndBalanceFactorThree2() {
		AVLTree<Integer, Object>.Node a = tree.new Node(4, null);
		AVLTree<Integer, Object>.Node b = tree.new Node(5, null);
		AVLTree<Integer, Object>.Node c = tree.new Node(3, null);
		AVLTree<Integer, Object>.Node d = tree.new Node(6, null);
		AVLTree<Integer, Object>.Node e = tree.new Node(7, null);
		a.leftChild = b;
		b.leftChild = c;
		c.leftChild = d;
		d.leftChild = e;
		assertEquals(3, a.height());
		a.computeBalanceFactor();
		assertEquals(4, a.balanceFactor);
	}

}
