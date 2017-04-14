package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
		
		
//		List<Card> testList = Arrays.asList(new Card(Suit.CLUBS, 2, "Two", "2"), new Card(Suit.CLUBS, 4, "Four", "4"), new Card(Suit.CLUBS, 2, "Two", "2"), new Card(Suit.CLUBS, 11, "Jack", "J"), new Card(Suit.CLUBS, 11, "Jack", "J"));
		List<Card> testList = new ArrayList<>();
		testList.add(new Card(Suit.CLUBS, 14, "Ace", "A"));
		testList.add(new Card(Suit.CLUBS, 14, "Ace", "A"));
		testList.add(new Card(Suit.CLUBS, 2, "Two", "2"));
		testList.add(new Card(Suit.CLUBS, 11, "Jack", "J"));
		testList.add(new Card(Suit.CLUBS, 11, "Jack", "J"));
		
		Combination combination = new Combination();
		combination.ifPairOrTwoPairs(testList);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
