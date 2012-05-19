package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Simple Binary Search Tree Implementation. Algorithms are adaptations of those
 * in Cormen, Leiserson, and Rivest's <em>Introduction to Algorithms.
 * 
 * @author kleinen
 * 
 * @param <K>
 * @param <V>
 */
public class Tree<K extends Comparable<K>, V> implements Iterable<K> {
	private static final String DELIM = ", ";
	protected Node root;

	/**
	 * 
	 * Entry/Node in the Tree. Could be extended to implement Map.Entry<K,V>
	 * 
	 * @see java.util.Map.Entry
	 */
	public class Node {
		K key;
		V value;
		Node parent;
		Node leftChild;
		Node rightChild;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public String toString() {
			return "(" + key.toString() + ","
					+ ((leftChild == null) ? "" : leftChild.toString()) + ","
					+ ((rightChild == null) ? "" : rightChild.toString()) + ")";
		}

		public String toStringBalanceFactor() {
			return "("
					+ key.toString()
					+ "["
					+ balanceFactor
					+ "],"
					+ ((leftChild == null) ? "" : leftChild
							.toStringBalanceFactor())
					+ ","
					+ ((rightChild == null) ? "" : rightChild
							.toStringBalanceFactor()) + ")";
		}

		public int size() {
			int l = 0, r = 0;
			if (leftChild != null)
				l = leftChild.size();
			if (rightChild != null)
				r = rightChild.size();
			return l + 1 + r;

		}

		public int height() {
			int lh = -1, rh = -1;
			if (leftChild != null)
				lh = 1 + leftChild.height();
			if (rightChild != null)
				rh = 1 + rightChild.height();
			return Math.max(lh, rh);
		}

		int balanceFactor;

		public int computeBalanceFactor() {
			int lh = -1, rh = -1;
			if (leftChild != null)
				lh = 1 + leftChild.height();
			if (rightChild != null)
				rh = 1 + rightChild.height();
			return balanceFactor = lh - rh;
		}
	}

	public Node find(K key) {
		Node currentNode = root;
		while (currentNode != null) {
			int c = key.compareTo(currentNode.key);
			if (c == 0)
				return currentNode;
			else {
				if (c < 0)
					currentNode = currentNode.leftChild;
				else
					currentNode = currentNode.rightChild;
			}
		}
		// didn't find it
		return null;
	}

	public Node findRecursive(K key) throws Exception {
		return findRecursive(key, root);
	}

	public Node findRecursive(K key, Node currentNode) {
		if (currentNode == null)
			return null;
		int c = key.compareTo(currentNode.key);
		if (c == 0)
			return currentNode;
		else {
			if (c < 0)
				return findRecursive(key, root.leftChild);
			else
				return findRecursive(key, root.rightChild);
		}
	}

	public Node insert(K key) {
		return insert(key, null);
	}

	public Node insert(K key, V value) {
		return insert(new Node(key, value));
	}

	public Node insert(Node node) {
		if (root == null) {
			root = node;
			return node;
		}
		Node current = root, parent = null;
		while (current != null) {
			parent = current;
			if (node.key.compareTo(current.key) < 0) {
				current = current.leftChild;
				if (current == null) {
					parent.leftChild = node;
					node.parent = parent;
				}
			} else {
				current = current.rightChild;
				if (current == null) {
					parent.rightChild = node;
					node.parent = parent;
				}
			}
		}
		return node;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public Node getRoot() {
		return root;
	}

	public String toString() {
		return traverseInOrderToString(root)
				.replaceAll("(" + DELIM + ")+", DELIM)
				.replaceAll("^" + DELIM, "").replaceAll(DELIM + "$", "");
	}

	private String traverseInOrderToString(Node node) {
		if (node == null)
			return "";
		else
			return traverseInOrderToString(node.leftChild) + DELIM
					+ node.key.toString() + DELIM
					+ traverseInOrderToString(node.rightChild);
	}

	public List<Node> delete(K key) {
		List<Node> rebalance = new ArrayList<Node>();

		Node node = find(key);
		if (node == null)
			return null;
		if (node.leftChild == null) {
			if (node.parent == null)
				root = node.rightChild;
			else if (node.parent.leftChild == node)
				node.parent.leftChild = node.rightChild;
			else
				node.parent.rightChild = node.rightChild;
			if (node.rightChild != null)
				node.rightChild.parent = node.parent;
			rebalance.add(node.rightChild == null ? node.parent
					: node.rightChild);
			return rebalance;
		}
		if (node.rightChild == null) {
			if (node.parent == null)
				root = node.leftChild;
			else if (node.parent.leftChild == node)
				node.parent.leftChild = node.leftChild;
			else
				node.parent.rightChild = node.leftChild;
			if (node.leftChild != null)
				node.leftChild.parent = node.parent;
			rebalance.add(node.leftChild);
			return rebalance;
		}
		// node has 2 childs.
		Node succ = successor(node);
		if (succ == node.rightChild) {
			transplant(node, succ);
			succ.leftChild = node.leftChild;
			succ.leftChild.parent = succ;
		} else {
			if (succ.rightChild == null)
				rebalance.add(succ.parent);
			else
				rebalance.add(succ.rightChild);
			transplant(succ, succ.rightChild);
			replace(node, succ);
		}
		rebalance.add(succ);
		return rebalance;
	}

	public Node successor(K key) {
		return successor(find(key));
	}

	public Node successor(Node node) {
		if (node.rightChild != null)
			return minimum(node.rightChild);
		Node up = node.parent;
		Node succ = node;
		while ((up != null) && succ == up.rightChild) {
			succ = up;
			up = up.parent;
		}
		return up;
	}

	public String toStringTree() {
		if (root == null)
			return "()";
		return toStringTree(root);
	}

	public String toStringTree(Node node) {
		String left = "(", right = ")", middle = "-";
		if ((node.leftChild == null) && (node.rightChild == null)) {
			left = right = middle = "";
		}
		String result = left;
		if (node.leftChild != null) {
			result += toStringTree(node.leftChild);
		}
		result += middle;
		result += node.key.toString();
		result += middle;
		if (node.rightChild != null) {
			result += toStringTree(node.rightChild);
		}
		result += right;
		return result;
	}

	public Node minimum() {
		return minimum(root);
	}

	public Node minimum(Node node) {
		while (node.leftChild != null)
			node = node.leftChild;
		return node;
	}

	/**
	 * moves subtree starting at b to a's position.
	 * 
	 * @param a
	 * @param b
	 */
	public void transplant(Node a, Node b) {
		if (a.parent == null) {
			root = b;
			if (b != null)
				b.parent = null;
		} else {
			if (b != null) {
				if (b == b.parent.leftChild)
					b.parent.leftChild = null;
				else
					b.parent.rightChild = null;

				b.parent = a.parent;
			}
			if (a == a.parent.leftChild)
				a.parent.leftChild = b;
			else
				a.parent.rightChild = b;
			a.parent = null;
		}

	}

	/**
	 * replaces node a with node b.
	 * 
	 * @param a
	 * @param b
	 */
	public void replace(Node a, Node b) {
		if (a.parent == null)
			root = b;
		else {
			if (a.parent.leftChild == a)
				a.parent.leftChild = b;
			else
				a.parent.rightChild = b;
		}
		b.parent = a.parent;
		a.parent = null;
		b.leftChild = a.leftChild;
		if (b.leftChild != null)
			b.leftChild.parent = b;
		b.leftChild.parent = b;
		b.rightChild = a.rightChild;
		if (b.rightChild != null)
			b.rightChild.parent = b;
	}

	public int size() {
		if (root == null)
			return 0;
		return root.size();
	}

	public enum Cursor {
		LEFT, THIS, RIGHT, DONE
	};

	public class Iterator implements java.util.Iterator<K> {
		private Cursor c;
		private Node node;
		private Node max;

		public Iterator(Node node) {
			if (node == null)
				c = Cursor.RIGHT;
			else {
				this.node = node;
				this.c = Cursor.LEFT;
				max = node;
				while (max.rightChild != null)
					max = max.rightChild;
			}

		}

		@Override
		public boolean hasNext() {
			return !((node == max) && c == Cursor.RIGHT);
		}

		@Override
		public K next() {
			switch (c) {
			case LEFT:
				if (node.leftChild == null) {
					c = Cursor.THIS;
					return next();
				} else {
					node = node.leftChild;
					return next();
				}
			case THIS:
				c = Cursor.RIGHT;
				return node.key;

			case RIGHT:
				if (node.rightChild == null) {
					c = Cursor.DONE;
					return next();
				} else {
					c = Cursor.LEFT;
					node = node.rightChild;
					return next();
				}
			case DONE:
				if (node.parent == null)
					throw new NoSuchElementException();
				else {
					if (node.parent.leftChild == node)
						c = Cursor.THIS;
					else
						c = Cursor.DONE;
				}
				node = node.parent;
				return next();
			}
			// should never reach this;
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	}

	@Override
	public java.util.Iterator<K> iterator() {
		return this.new Iterator(root);
	}

}
