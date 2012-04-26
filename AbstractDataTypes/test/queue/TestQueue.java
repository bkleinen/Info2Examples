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

public class TestQueue {
 public static void main (String [] args){

 // Queue q = new ArrayQueue();           q.printAll();
 Queue<String> q = new LinkedQueue<String>();                q.printAll();

 try {
       // Put something in the queue
       q.enqueue ("Berlin");                 q.printAll();
       q.enqueue ("Brandenburg");            q.printAll();
       q.enqueue ("Sachsen");                q.printAll();
       q.enqueue ("Sachsen-Anhalt");         q.printAll();
       q.enqueue ("Mecklenburg-Vorpommern"); q.printAll();

       // Remove two
       q.dequeue();                          q.printAll();
       q.dequeue();                          q.printAll();

       // Add another
       q.enqueue("Bayern");                  q.printAll();

       // Who's on first?
       Object first = q.peek();
       System.out.println("First is: "+first.toString());
       // Queue is unchanged!
       q.printAll();

       // delete them all by forcing an exception
       for (;;) {
           q.dequeue();
           q.printAll();
       }

  }
  catch (Underflow e){System.out.println("Error in "+ e.whoCausedException());}

 }
}