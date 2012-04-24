package linkedlists;

public interface LinkedList<E extends Comparable<E>> extends Iterable<E> {
	public Node<E> getFirstNode();
	public boolean isLastNodeReached(Node<? extends E> current);
	public void appendFirst(E s) ;
	public boolean isEmpty() ;
	public E removeLast();
	public void insert(E data);
	public E remove(E data);
	public E remove(Node<E> data);
}
