package linkedlists;

public interface LinkedList<E extends Comparable<E>> extends Iterable<E> {
	public Node<E> getFirstNode();
	public boolean isLastNodeReached(Node<? extends E> current);
	public void appendFirst(E s) ;
	public void appendLast(E s);
	public boolean isEmpty() ;
	public E peek();
	public E removeLast();
	public E removeFirst();
	public void insert(E data);
	public E remove(E data);
	public E remove(Node<E> data);
}
