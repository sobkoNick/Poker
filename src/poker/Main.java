package poker;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// System.out.println("♥♦♣♠");
		Deck deck = new Deck();

		for (Card card : deck.getDeck()) {
			System.out.print(card.toString());
		}
		System.out.println();
		System.out.println("---------------");

		deck.shuffle();

		for (Card card : deck.getDeck()) {
			System.out.print(card.toString());
		}
		System.out.println();
//		System.out.print("┌─────────┐\n");
//		System.out.print("│ " + deck.getDeck().get(0) + "      │\n");
//		System.out.print("│         │\n");
//		System.out.print("│         │\n");
//		System.out.print("│         │\n");
//		System.out.print("└─────────┘\n");
//		
//		System.out.print("┌─────────┐\n");
//		System.out.print("│ " + deck.getDeck().get(1) + "      │\n");
//		System.out.print("│         │\n");
//		System.out.print("│         │\n");
//		System.out.print("│         │\n");
//		System.out.print("└─────────┘\n");
		
		
		System.out.print("┌───────┐"); System.out.print("┌──────┐"); System.out.print("┌──────┐"); System.out.print("┌──────┐"); System.out.print("┌──────┐\n");
		System.out.print("│ " + deck.getDeck().get(0) + "\t│"); System.out.print("│ " + deck.getDeck().get(1) + "\t│"); System.out.print("│ " + deck.getDeck().get(2) + "\t│"); System.out.print("│ " + deck.getDeck().get(3) + "\t│"); System.out.print("│ " + deck.getDeck().get(4) + "\t│\n");
		System.out.print("│\t│"); System.out.print("│\t│"); System.out.print("│\t│"); System.out.print("│\t│"); System.out.print("│\t│\n");
		System.out.print("│\t│"); System.out.print("│\t│"); System.out.print("│\t│"); System.out.print("│\t│"); System.out.print("│\t│\n");
		System.out.print("│\t│"); System.out.print("│\t│"); System.out.print("│\t│"); System.out.print("│\t│"); System.out.print("│\t│\n");
		System.out.print("└───────┘"); System.out.print("└──────┘"); System.out.print("└──────┘"); System.out.print("└──────┘"); System.out.print("└──────┘\n");
		
		
		System.out.println("");
		
		List<Card> testList = new ArrayList<>();
		testList.add(new Card(Suit.CLUBS, 5, "Five", "5"));
		testList.add(new Card(Suit.DIAMONDS, 7, "Seven", "7"));
		testList.add(new Card(Suit.CLUBS, 7, "Seven", "7"));
		testList.add(new Card(Suit.CLUBS, 8, "Eight", "8"));
		testList.add(new Card(Suit.DIAMONDS, 8, "Eight", "8"));
		
		Combination combination = new Combination();
		combination.ifPairOrTwoPairs(testList);
		combination.HighestCard(testList);
		combination.ifSet(testList);
		combination.ifStreet(testList);
		combination.ifFlush(testList);
		
	}

}
