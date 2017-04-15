package poker;

import java.util.LinkedList;
import java.util.List;

public class ClubList {

	public List<Card> clubs = new LinkedList<Card>();
	
	public ClubList() {
		clubs.add(new Card(Suit.CLUBS, 2, "Two", "2"));
		clubs.add(new Card(Suit.CLUBS, 3, "Three", "3"));
		clubs.add(new Card(Suit.CLUBS, 4, "Four", "4"));
		clubs.add(new Card(Suit.CLUBS, 5, "Five", "5"));
		clubs.add(new Card(Suit.CLUBS, 6, "Six", "6"));
		clubs.add(new Card(Suit.CLUBS, 7, "Seven", "7"));
		clubs.add(new Card(Suit.CLUBS, 8, "Eight", "8"));
		clubs.add(new Card(Suit.CLUBS, 9, "Nine", "9"));
		clubs.add(new Card(Suit.CLUBS, 10, "Ten", "10"));
		clubs.add(new Card(Suit.CLUBS, 11, "Jack", "J"));
		clubs.add(new Card(Suit.CLUBS, 12, "Queen", "Q"));
		clubs.add(new Card(Suit.CLUBS, 13, "King", "K"));
		clubs.add(new Card(Suit.CLUBS, 14, "Ace", "A"));
	}

	public List<Card> getClubs() {
		return clubs;
	}

	@Override
	public String toString() {
		return "ClubList [clubs=" + clubs + "]";
	}

}
