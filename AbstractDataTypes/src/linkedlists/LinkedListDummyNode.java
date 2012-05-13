package linkedlists;

import java.util.Iterator;

public class LinkedListDummyNode<E extends Comparable<E>> implements
		LinkedList<E> {
	Node<E> first = null;

	public LinkedListDummyNode() {
		first = new Node<E>(null);
		first.next = first;
	}

	@Override
	public void appendFirst(E s) {
		appendFirst(new Node<E>(s));
	}

	private void appendFirst(Node<E> node) {
		Node<E> second = first.next;
		first.next = node;
		node.next = second;
	}

	@Override
	public void appendLast(E s) {
		appendLast(new Node<E>(s));

	}

	public void appendLast(Node<E> node) {
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

	public E removeLast() {
		Node<E> result = first.next;
		first.next = first.next.next;
		return result.data;
	}

	@Override
	public E remove(Node<E> node) {
		Node<E> n = first;
		while ((n.next != first) && (n.next != node))
			n = n.next;
		if (n.next == null)
			return null;
		return removeNext(n);
	}

	public E remove(E data) {
		Node<E> n = first;
		while ((n.next != first) && (n.next.data.compareTo(data) != 0))
			n = n.next;
		if (n.next == null)
			return null;
		return removeNext(n);
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator<E>(this);
	}

	@Override
	public Node<E> getFirstNode() {
		return first.next;
	}

	@Override
	public boolean isLastNodeReached(Node<? extends E> node) {
		return node == first;
	}

	public E removeNext(Node<E> n) {

		Node<E> result = n.next;
		n.next = n.next.next;
		return result.data;

	}

	@Override
	public E removeFirst() {
		return removeNext(first);

	}

	@Override
	public E peek() {
		return first.next.getData();
	}

}
