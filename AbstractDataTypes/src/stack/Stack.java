package stack;

import errorhandling.Underflow;

/**
 * †berschrift: Beschreibung: A trivial interface for a stack adapted from
 * http://people.f4.htw-berlin.de/~weberwu/info2/Handouts/Stack.java Copyright:
 * Copyright (c) 2006 Organisation: HTW:
 * 
 * @author Debora Weber-Wulff; B. Kleinen
 * @version 1.0
 */

public interface Stack<E> {
	public void push(E o);

	public E pop() throws Underflow;

	public E peek() throws Underflow;

	public boolean isEmpty();

	public void Empty();

	public String print();

}