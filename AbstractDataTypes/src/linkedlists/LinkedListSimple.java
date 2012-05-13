package linkedlists;

import java.util.Iterator;

public class LinkedListSimple<E extends Comparable<E>> implements LinkedList<E> {
	int size = 0;
	Node<E> first = null;

	public LinkedListSimple() {
	}

	@Override
	public void appendFirst(E s) {
		Node<E> node = new Node<E>(s);
		if (first == null)
			first = node;
		else {
			node.next = first;
			first = node;
		}
	}

	@Override
	public void appendLast(E e) {
		appendLast(new Node<E>(e));
	}

	public void appendLast(Node<E> node) {
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
		if (first.data.compareTo(node.data) >= 0) {
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

	public E remove(E data) {
		if (first == null)
			return null;
		if (first.data.compareTo(data) == 0) {
			Node<E> result = first;
			first = first.next;
			return result.data;
		}
		Node<E> n = first;

		while ((n.next != null) && (n.next.data.compareTo(data) != 0))
			n = n.next;
		if (n.next == null)
			return null;
		return removeNext(n);
	}

	@Override
	public E remove(Node<E> node) {
		if (first == null)
			return null;
		if (first == node) {
			Node<E> result = first;
			first = first.next;
			return result.data;
		}
		Node<E> n = first;

		while ((n.next != null) && (n.next != node))
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
		return first;
	}

	@Override
	public boolean isLastNodeReached(Node<? extends E> node) {
		return node == null;
	}

	public E removeNext(Node<E> n) {
		Node<E> result = n.next;
		n.next = n.next.next;
		return result.data;

	}
	
	@Override
	public E removeFirst() {
		Node<E> node = first;
		first = first.next;
		return node.getData();
	}

	@Override
	public E peek() {
		return first.getData();
	}

}
