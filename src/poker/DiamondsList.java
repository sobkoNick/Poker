package poker;

import java.util.LinkedList;
import java.util.List;

public class DiamondsList {
	public List<Card> diamonds = new LinkedList<Card>();

	public DiamondsList() {
		// TODO Auto-generated constructor stub
		diamonds.add(new Card(Suit.DIAMONDS, 2, "Two", "2"));
		diamonds.add(new Card(Suit.DIAMONDS, 3, "Three", "3"));
		diamonds.add(new Card(Suit.DIAMONDS, 4, "Four", "4"));
		diamonds.add(new Card(Suit.DIAMONDS, 5, "Five", "5"));
		diamonds.add(new Card(Suit.DIAMONDS, 6, "Six", "6"));
		diamonds.add(new Card(Suit.DIAMONDS, 7, "Seven", "7"));
		diamonds.add(new Card(Suit.DIAMONDS, 8, "Eight", "8"));
		diamonds.add(new Card(Suit.DIAMONDS, 9, "Nine", "9"));
		diamonds.add(new Card(Suit.DIAMONDS, 10, "Ten", "10"));
		diamonds.add(new Card(Suit.DIAMONDS, 11, "Jack", "J"));
		diamonds.add(new Card(Suit.DIAMONDS, 12, "Queen", "Q"));
		diamonds.add(new Card(Suit.DIAMONDS, 13, "King", "K"));
		diamonds.add(new Card(Suit.DIAMONDS, 14, "Ace", "A"));
	}

	public List<Card> getDiamonds() {
		return diamonds;
	}

	@Override
	public String toString() {
		return "DiamondsList [diamonds=" + diamonds + "]";
	}

}
