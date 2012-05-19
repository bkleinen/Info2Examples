package tree;

import java.util.List;

public class AVLTree<K extends Comparable<K>, V> extends Tree<K, V> {

	@Override
	public Node insert(K key) {
		return insert(key, null);
	}

	@Override
	public Node insert(K key, V value) {
		computeAllBalanceFactors();
		Node avln = new Node(key, value);
		super.insert(avln);
		rebalanceAfterInsert(avln.parent);
		return avln;
	}

	@Override
	public List<Node> delete(K key) {
		computeAllBalanceFactors();
		List<Node> checkOn = super.delete(key);
		for (Node n: checkOn)
		if (n != null)
			rebalanceAfterDelete(n);
		return checkOn;
	}

	public void rebalanceAfterInsert(Node n) {
		if (n == null)
			return;
		int balanceBefore = n.balanceFactor;
		n.computeBalanceFactor();
		if (n.balanceFactor == -2) { // right subtree outweights left
			if (n.rightChild.computeBalanceFactor() == 1) {
				rotateRight(n.rightChild);
				rotateLeft(n);
			} else if (n.rightChild.computeBalanceFactor() == -1)
				rotateLeft(n);
		} else if (n.balanceFactor == 2) {
			if (n.leftChild.computeBalanceFactor() == -1) {
				rotateLeft(n.leftChild);
				rotateRight(n);
			} else if (n.leftChild.computeBalanceFactor() == 1)
				rotateRight(n);
		}
		n.computeBalanceFactor();
		if (balanceBefore != n.balanceFactor)
			rebalanceAfterInsert(n.parent);
	}

	public void rebalanceAfterDelete(Node n) {
		if (n == null)
			return;
		int balanceBefore = n.balanceFactor;
		n.computeBalanceFactor();
		if (n.balanceFactor == -2) { // right subtree outweights left
			if (n.rightChild.computeBalanceFactor() == 1) {
				rotateRight(n.rightChild);
				rotateLeft(n);
			} else
				rotateLeft(n);
		} else if (n.balanceFactor == 2) {
			if (n.leftChild.computeBalanceFactor() == -1) {
				rotateLeft(n.leftChild);
				rotateRight(n);
			} else
				rotateRight(n);
		}
		n.computeBalanceFactor();
		rebalanceAfterDelete(n.parent);

	}

	/**
	 * adapted from CLR P. 313
	 * 
	 * @param node
	 */
	public void rotateLeft(Node node) {
		Node right = node.rightChild;
		// turn right's left subtree into node's right subtree
		node.rightChild = right.leftChild;
		if (right.leftChild != null)
			right.leftChild.parent = node;
		// links node's parent to right
		right.parent = node.parent;
		if (node.parent == null)
			root = right;
		else {
			if (node == node.parent.leftChild)
				node.parent.leftChild = right;
			else
				node.parent.rightChild = right;
		}
		// node is now a child of right
		right.leftChild = node;
		node.parent = right;

	}

	/**
	 * adapted from CLR P. 313
	 * 
	 * @param node
	 */
	public void rotateRight(Node node) {
		Node left = node.leftChild;
		// turn left's right subtree into node's left subtree
		node.leftChild = left.rightChild;
		if (left.rightChild != null)
			left.rightChild.parent = node;
		// links node's parent to left
		left.parent = node.parent;
		if (left.parent == null)
			root = left;
		else {
			if (node == node.parent.leftChild)
				node.parent.leftChild = left;
			else
				node.parent.rightChild = left;
		}
		// node is now a child of left
		left.rightChild = node;
		node.parent = left;

	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	public boolean isBalanced(Node node) {

		if (node == null)
			return true;
		node.computeBalanceFactor();
		if (Math.abs(node.balanceFactor) > 1)
			return false;
		return isBalanced(node.leftChild) && isBalanced(node.rightChild);

	}

	public void computeAllBalanceFactors() {
		computeAllBalanceFactors(root);
	}

	public void computeAllBalanceFactors(Node node) {
		if (node == null)
			return;
		computeAllBalanceFactors(node.leftChild);
		computeAllBalanceFactors(node.rightChild);
		node.computeBalanceFactor();
	}
}
