package enumerations;

import java.util.ArrayList;
import java.util.List;

public class Card {
	public enum Rank {
		DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	};

	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES
	};

	private final Rank rank;
	private final Suit suit;

	private Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public String toString() {
		return rank + " " + suit;
	}

	private static final List<Card> protoDeck = new ArrayList<Card>();
	// Initialize prototype deck
	static {
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				protoDeck.add(new Card(rank, suit));
	}

	public static ArrayList<Card> newDeck() {
		return new ArrayList<Card>(protoDeck);
		// Return copy of prototype deck
	}
	public static void main(String[] args){
		for (Card card : protoDeck)
			System.out.println(card);
	}

}
