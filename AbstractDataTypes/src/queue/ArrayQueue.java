package queue;

import errorhandling.Underflow;

/**
 * public class ArrayQueue {
 * 
 * @author dww, kleinen
 * http://people.f4.htw-berlin.de/~weberwu/info2/Handouts/ArrayQueue.java
 *         
 */

public class ArrayQueue<E> implements Queue<E> {

	protected Object[] objects;
	protected int front = 0;
	protected int back = 0;
	protected int capacity = 16;

	// Invariants:
	// objects [i] == null for 0 <= i < front
	// objects [i] != null for front <= i < back
	// objects [i] == null for back <= i < capacity

	public ArrayQueue() {
		// @SuppressWarnings({"unchecked"})

		objects = new Object[capacity];
	}

	public void enqueue(Object x) {

		if (back >= capacity) {
			Object[] temp = objects;

			// make a new one, twice as big
			capacity = capacity * 2;
			objects = new Object[capacity];

			// copy everything
			for (int i = 0; i < back - front; i++) {
				objects[i] = temp[i + front];
			}
			back = back - front;
			front = 0;
		}
		objects[back++] = x;

	};

	@SuppressWarnings("unchecked")
	public E peek() throws Underflow {
		if (isEmpty())
			throw new Underflow("getFront");
		return (E)objects[front];
	};

	public E dequeue() throws Underflow {
		if (isEmpty())
			throw new Underflow("dequeue");
		@SuppressWarnings("unchecked")
		E result = (E) objects[front];
		front = front + 1;

		// shift left if past midpoint
		if (2 * front >= capacity) {
			for (int i = 0; i < back - front; i++) {
				objects[i] = objects[i + front];
			}
			back = back - front;
			front = 0;
		}
		return result;
	};

	public boolean isEmpty() {
		return front == back;
	};

	public void makeEmpty() {

		front = back = 0;
	};

	public void printAll() {
		System.out.print("[");
		for (int i = 0; i < back - front; i++) {
			System.out.print(objects[i + front].toString());
			// if we are not at the end, print a comma
			System.out.print((i < back - front - 1) ? ", " : "");
		}

		System.out.println("]");

	}

}