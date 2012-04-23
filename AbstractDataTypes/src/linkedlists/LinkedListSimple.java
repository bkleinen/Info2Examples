package linkedlists;

public class LinkedListSimple<E extends Comparable<E>> implements LinkedList<E> {
	int size = 0;
	Node<E> first = null;

	public LinkedListSimple() {
	}

	@Override
	public void appendFirst(E s) {
		append(new Node<E>(s));
	}

	public void append(Node<E> node) {
		if (first == null)
			first = node;
		else {
			Node<E> n = first;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}

	public void insert(E data) {
		insert(new Node<E>(data));
	}

	public void insert(Node<E> node) {
		if (first == null)
			first = node;
		if (first.data.compareTo(node.data) >= 0)
		{
			node.next = first;
			first = node;
			return;
		}
		Node<E> n = first;
		while ((n.next != null) && (n.next.data.compareTo(node.data) < 0))
			n = n.next;
		node.next = n.next;
		n.next = node;
	}

	public String toString() {
		String result = "(";
		for (Node<E> node = first; node != null; node = node.next) {
			result += node.data;
			if (node.next != null)
				result += ", ";
		}
		return result + ")";
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public E removeLast() {
		if (first == null)
			return null;
		Node<E> result = first;
		first = first.next;
		return result.data;
	}
	public E remove(E data){
		if (first == null)
			return null;
		if (first.data.compareTo(data) == 0){
			Node<E> result = first;
			first = first.next;
			return result.data;
		}
		Node<E> n = first;
			
		while ((n.next != null) && (n.next.data.compareTo(data) != 0))
			n = n.next;
		if (n.next == null) return null;
		Node<E> result = n.next;
		n.next = n.next.next;
		return result.data;
	}
}
