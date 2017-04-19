package poker;

import java.util.LinkedList;
import java.util.List;

public class HartsList {
	public List<Card> harts = new LinkedList<Card>();

	public HartsList() {
		harts.add(new Card(Suit.HARTS, 2, "Two", "2"));
		harts.add(new Card(Suit.HARTS, 3, "Three", "3"));
		harts.add(new Card(Suit.HARTS, 4, "Four", "4"));
		harts.add(new Card(Suit.HARTS, 5, "Five", "5"));
		harts.add(new Card(Suit.HARTS, 6, "Six", "6"));
		harts.add(new Card(Suit.HARTS, 7, "Seven", "7"));
		harts.add(new Card(Suit.HARTS, 8, "Eight", "8"));
		harts.add(new Card(Suit.HARTS, 9, "Nine", "9"));
		harts.add(new Card(Suit.HARTS, 10, "Ten", "10"));
		harts.add(new Card(Suit.HARTS, 11, "Jack", "J"));
		harts.add(new Card(Suit.HARTS, 12, "Queen", "Q"));
		harts.add(new Card(Suit.HARTS, 13, "King", "K"));
		harts.add(new Card(Suit.HARTS, 14, "Ace", "A"));
	}

	public List<Card> getHarts() {
		return harts;
	}

	@Override
	public String toString() {
		return "HartsList [harts=" + harts + "]";
	}
	
	
}
