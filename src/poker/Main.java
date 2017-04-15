package poker;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void defineCombanation(List<Card> list) { // defines your combiantion
		Combination combination = new Combination();
		if (combination.ifFlushRoyal(list)) {
			return;
		} else if (combination.ifStreetFlush(list)) {
			return;
		} else if (combination.ifStreetFlush(list)) {
			return;
		} else if (combination.ifCare(list)) {
			return;
		} else if (combination.ifFullHouse(list)) {
			return;
		} else if (combination.ifFlush(list)) {
			return;
		} else if (combination.ifStreet(list)) {
			return;
		} else if (combination.ifSet(list)) {
			return;
		} else if (combination.ifPairOrTwoPairs(list)) {
			return;
		} else if (combination.HighestCard(list)) {
		}

	}

	public static void main(String[] args) {
		// System.out.println("♥♦♣♠");
		
		Deck deck = new Deck();
		
		//List<Card> cards = deck.getDeck();
		
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
		// System.out.print("┌─────────┐\n");
		// System.out.print("│ " + deck.getDeck().get(0) + " │\n");
		// System.out.print("│ │\n");
		// System.out.print("│ │\n");
		// System.out.print("│ │\n");
		// System.out.print("└─────────┘\n");
		//
		// System.out.print("┌─────────┐\n");
		// System.out.print("│ " + deck.getDeck().get(1) + " │\n");
		// System.out.print("│ │\n");
		// System.out.print("│ │\n");
		// System.out.print("│ │\n");
		// System.out.print("└─────────┘\n");

		System.out.print("┌───────┐");
		System.out.print("┌──────┐");
		System.out.print("┌──────┐");
		System.out.print("┌──────┐");
		System.out.print("┌──────┐\n");
		System.out.print("│ " + deck.getDeck().get(0) + "\t│");
		System.out.print("│ " + deck.getDeck().get(1) + "\t│");
		System.out.print("│ " + deck.getDeck().get(2) + "\t│");
		System.out.print("│ " + deck.getDeck().get(3) + "\t│");
		System.out.print("│ " + deck.getDeck().get(4) + "\t│\n");
		System.out.print("│\t│");
		System.out.print("│\t│");
		System.out.print("│\t│");
		System.out.print("│\t│");
		System.out.print("│\t│\n");
		System.out.print("│\t│");
		System.out.print("│\t│");
		System.out.print("│\t│");
		System.out.print("│\t│");
		System.out.print("│\t│\n");
		System.out.print("│\t│");
		System.out.print("│\t│");
		System.out.print("│\t│");
		System.out.print("│\t│");
		System.out.print("│\t│\n");
		System.out.print("└───────┘");
		System.out.print("└──────┘");
		System.out.print("└──────┘");
		System.out.print("└──────┘");
		System.out.print("└──────┘\n");

		System.out.println("");

		List<Card> testList = new ArrayList<>();
		
		testList.add(new Card(Suit.CLUBS, 5, "Five", "5"));
		testList.add(new Card(Suit.SPADES, 8, "Eight", "8"));
		testList.add(new Card(Suit.SPADES, 6, "Six", "6"));
		testList.add(new Card(Suit.CLUBS, 12, "Queen", "Q"));
		testList.add(new Card(Suit.HARTS, 10, "Ten", "10"));
		
		 testList.clear();
		 testList.add(deck.getDeck().get(0));
		 testList.add(deck.getDeck().get(1));
		 testList.add(deck.getDeck().get(2));
		 testList.add(deck.getDeck().get(3));
		 testList.add(deck.getDeck().get(4));
		 
		 
		 
		 defineCombanation(testList);
		 
		 for (Card card : testList) {
			System.out.print(card);
		}

//		Combination combination = new Combination();
		
		// combination.ifPairOrTwoPairs(testList);
		// combination.HighestCard(testList);
		// combination.ifSet(testList);
		// combination.ifStreet(testList);
		// combination.ifFlush(testList);
		// combination.ifFullHouse(testList);
		// combination.ifCare(testList);
		// combination.ifStreetFlush(testList);
		// combination.ifFlushRoyal(testList);

//		System.out.println("HighestCard " + combination.HighestCard(testList));
//		System.out.println("ifPairOrTwoPairs " + combination.ifPairOrTwoPairs(testList));
//		System.out.println("ifSet " + combination.ifSet(testList));
//		System.out.println("ifStreet " + combination.ifStreet(testList));
//		System.out.println("ifFlush " + combination.ifFlush(testList));
//		System.out.println("ifFullHouse " + combination.ifFullHouse(testList));
//		System.out.println("ifCare " + combination.ifCare(testList));
//		System.out.println("ifStreetFlush " + combination.ifStreetFlush(testList));
//		System.out.println("ifFlushRoyal " + combination.ifFlushRoyal(testList));

	}

}
