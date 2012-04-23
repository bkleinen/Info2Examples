package exercise;

public class LinkedListDummyNode<E extends Comparable<E>> implements
		LinkedList<E> {
	int size = 0;
	Node<E> first = new Node<E>(null);

	public LinkedListDummyNode() {
		first.next = first;
	}

	@Override
	public void append(E s) {
		append(new Node<E>(s));
	}

	public void append(Node<E> node) {
		Node<E> n = first;
		while (n.next != first) {
			n = n.next;
		}
		n.next = node;
		node.next = first;

	}

	public void insert(E data) {
		insert(new Node<E>(data));
	}

	public void insert(Node<E> node) {
	
		Node<E> n = first;
		while ((n.next != first) && (n.next.data.compareTo(node.data) < 0))
			n = n.next;
		node.next = n.next;
		n.next = node;
	}

	public String toString() {
		String result = "(";
		for (Node<E> node = first.next; node != first; node = node.next) {
			result += node.data;
			if (node.next != first)
				result += ", ";
		}
		return result + ")";
	}

	public boolean isEmpty() {
		return (first.next == first);
	}

	public E pop() {
		Node<E> result = first.next;
		first.next = first.next.next;
		return result.data;
	}

	public E remove(E data) {
		Node<E> n = first;
		while ((n.next != first) && (n.next.data.compareTo(data) != 0))
			n = n.next;
		if (n.next == null)
			return null;
		Node<E> result = n.next;
		n.next = n.next.next;
		return result.data;
	}

}
