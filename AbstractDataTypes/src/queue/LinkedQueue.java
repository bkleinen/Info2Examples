package queue;

import errorhandling.Underflow;

/**
 * †berschrift:
 * Beschreibung:
 * Copyright:     Copyright (c) 2002
 * Organisation:
 * @author
 * @version 1.0
 */

public class LinkedQueue<E> implements Queue<E>{

private Node<E> front;
private Node<E> back;

private class Node<E1> {
  E1 obj;
  Node<E1> next;
  Node (E1 obj){
   this.obj = obj;
   this.next = null;
  }

}


public LinkedQueue() {

  makeEmpty();
  }
@Override
public void enqueue (E x){
  if (isEmpty())
     // Make a queue of one element
    back = front = new Node<E>(x);
  else
    back = back.next = new Node<E>(x);
};

public E peek() throws Underflow{
  if (isEmpty())
      throw new Underflow ("peek");
  return front.obj;
};

public E dequeue() throws Underflow{

  if (isEmpty())
      throw new Underflow ("dequeue");
  E result = front.obj;
  front = front.next;
  return result;
};

public boolean isEmpty(){
  return front == null;
};

public void makeEmpty(){
  front = back = null;
};

public void printAll(){

  System.out.print("[");
  for (Node<E> i = front; i!=null; i=i.next){
       System.out.print(i.obj.toString());
       // if we are not at the end, print a comma
       if (i.next != null)
           System.out.print(", ");
  }
  System.out.println("]");
}
}