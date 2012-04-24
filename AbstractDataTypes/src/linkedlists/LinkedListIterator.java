package linkedlists;

import java.util.Iterator;

public class LinkedListIterator<E extends Comparable<E>> implements Iterator<E> {
	LinkedList<E> list;
	
	Node<E> current,last = null;
	public LinkedListIterator(LinkedList<E> linkedList) {
		list = linkedList;
		current = linkedList.getFirstNode();
	}

	@Override
	public boolean hasNext() {
		return !list.isLastNodeReached(current);
	}

	@Override
	public E next() {
		E result = current.data;
		last = current;
		current = current.next;
		return result;
	}

	@Override
	public void remove() {
		if (last == null) return;
		list.remove(last);	
	}

}
