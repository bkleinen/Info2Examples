/*
 * Copyright Joshua Bloch
 * from http://java.sun.com/developer/Books/shiftintojava/page1.html#replaceenums
 * apparently under the BSD ("Berkeley License")
 */
package enumerations.typesafepattern;

/**
 * The typesafe enum pattern
 * from http://java.sun.com/developer/Books/shiftintojava/page1.html#replaceenums
 * @author Joshua Bloch
 *
 */
public class Suit {
 private final String name;

 private Suit(String name) { this.name = name; }

 public String toString()  { return name; }

 public static final Suit CLUBS =
     new Suit("clubs");
 public static final Suit DIAMONDS =
     new Suit("diamonds");
 public static final Suit HEARTS =
     new Suit("hearts");
 public static final Suit SPADES =
     new Suit("spades");
}