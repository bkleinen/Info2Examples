package linkedlists;

public interface LinkedList<E extends Comparable<E>> {
	public void appendFirst(E s) ;
	public boolean isEmpty() ;
	public E removeLast();
	public void insert(E data);
	public E remove(E data);
}
