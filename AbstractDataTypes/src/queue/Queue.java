package queue;

import errorhandling.Underflow;

public interface Queue<E> {
	public void enqueue(E x);

	public E dequeue() throws Underflow;

	public E peek() throws Underflow;

	public boolean isEmpty();

	public void makeEmpty();
	/*
	 * having a method that prints to System.out in a library class is not really useful.
	 * (except for pre-Junit-testing)
	 * @todo: change to toString()
	 */
	public void printAll();
}
