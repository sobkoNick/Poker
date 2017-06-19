package poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CombinationRoyalFlushTest {

	@Test
	public void testFlushRojal() {
		Combination testCombination = new Combination();
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.HARTS, 10, "Ten", "10"));
		cards.add(new Card(Suit.HARTS, 11, "Jack", "J"));
		cards.add(new Card(Suit.HARTS, 12, "Queen", "Q"));
		cards.add(new Card(Suit.HARTS, 13, "King", "K"));
		cards.add(new Card(Suit.HARTS, 14, "Ace", "A"));
		assertTrue(testCombination.ifFlushRoyal(cards, false));
		
	}

}
