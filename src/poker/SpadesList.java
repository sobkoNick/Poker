package poker;

import java.util.LinkedList;
import java.util.List;

public class SpadesList {
	public List<Card> spades = new LinkedList<Card>();

	public SpadesList() {
		spades.add(new Card(Suit.SPADES, 2, "Two", "2"));
		spades.add(new Card(Suit.SPADES, 3, "Three", "3"));
		spades.add(new Card(Suit.SPADES, 4, "Four", "4"));
		spades.add(new Card(Suit.SPADES, 5, "Five", "5"));
		spades.add(new Card(Suit.SPADES, 6, "Six", "6"));
		spades.add(new Card(Suit.SPADES, 7, "Seven", "7"));
		spades.add(new Card(Suit.SPADES, 8, "Eight", "8"));
		spades.add(new Card(Suit.SPADES, 9, "Nine", "9"));
		spades.add(new Card(Suit.SPADES, 10, "Ten", "10"));
		spades.add(new Card(Suit.SPADES, 11, "Jack", "J"));
		spades.add(new Card(Suit.SPADES, 12, "Queen", "Q"));
		spades.add(new Card(Suit.SPADES, 13, "King", "K"));
		spades.add(new Card(Suit.SPADES, 14, "Ace", "A"));
	}

	public List<Card> getSpades() {
		return spades;
	}
	
}
