package exercise;

public interface LinkedList<E extends Comparable<E>> {
	public void append(E s) ;
	public boolean isEmpty() ;
	public E pop();
	public void insert(E data);
	public E remove(E data);
}
