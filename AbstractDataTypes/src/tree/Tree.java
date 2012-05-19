package tree;

/**
 * Simple Binary Search Tree Implementation. Algorithms are adaptations of those
 * in Cormen, Leiserson, and Rivest's <em>Introduction to Algorithms.
 * 
 * @author kleinen
 * 
 * @param <K>
 * @param <V>
 */
public class Tree<K extends Comparable<K>, V> {
	private static final String DELIM = ", ";
	private Node root;

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

	public void insert(K key) {
		insert(key, null);
	}

	public void insert(K key, V value) {
		insert(new Node(key, value));
	}

	public void insert(Node node) {
		if (root == null) {
			root = node;
			return;
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

	public Node delete(K key) {
		Node node = find(key);
		if (node == null)
			return null;
		if (node.leftChild == null) {
			if (node.parent.leftChild == node)
				node.parent.leftChild = node.rightChild;
			else
				node.parent.rightChild = node.rightChild;
			return node;
		}
		if (node.rightChild == null) {
			if (node.parent.leftChild == node)
				node.parent.leftChild = node.leftChild;
			else
				node.parent.rightChild = node.leftChild;
			return node;
		}
		// node has 2 childs.
		Node succ = successor(node);
		if (succ == node.rightChild) {
			transplant(node, succ);
			succ.leftChild = node.leftChild;
		} else {
			transplant(succ, succ.rightChild);
			replace(node, succ);
		}
		return node;
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
		if (a.parent == null)
			root = b;
		else {
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
		b.rightChild = a.rightChild;
	}

}
