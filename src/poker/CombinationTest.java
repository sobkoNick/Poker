package poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CombinationTest {

	Combination testCombination = new Combination();
	List<Card> cards = new ArrayList<>();
	
	@Test
	public void testStraightFlush() {
		cards.add(new Card(Suit.HARTS, 2, "Two", "2"));
		cards.add(new Card(Suit.HARTS, 3, "Three", "3"));
		cards.add(new Card(Suit.HARTS, 4, "Four", "4"));
		cards.add(new Card(Suit.HARTS, 5, "Five", "5"));
		cards.add(new Card(Suit.HARTS, 6, "Six", "6"));
		double result = testCombination.ifStreetFlush(cards, false);
		assertEquals(8.0, result, 0.01);
	}
	
	@Test
	public void testSet() {
		cards.add(new Card(Suit.SPADES, 2, "Two", "2"));
		cards.add(new Card(Suit.HARTS, 2, "Two", "2"));
		cards.add(new Card(Suit.CLUBS, 2, "Two", "2"));
		cards.add(new Card(Suit.HARTS, 5, "Five", "5"));
		cards.add(new Card(Suit.HARTS, 6, "Six", "6"));
		double result = testCombination.ifSet(cards, false);
		assertEquals(3.0, result, 0.01);
	}
	
	@Test
	public void testStraight() {
		cards.add(new Card(Suit.SPADES, 6, "Six", "6"));
		cards.add(new Card(Suit.HARTS, 7, "Seven", "7"));
		cards.add(new Card(Suit.CLUBS, 8, "Eight", "8"));
		cards.add(new Card(Suit.HARTS, 9, "Nine", "9"));
		cards.add(new Card(Suit.HARTS, 10, "Ten", "10"));
		double result = testCombination.ifStreet(cards, false);
		assertEquals(4.0, result, 0.01);
	}

}
