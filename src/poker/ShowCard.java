package poker;

import java.util.List;

public class ShowCard {
	public static void showOneCard(Card card) {
		System.out.println();
		System.out.println("┌───────┐");
		System.out.println("│ " + card + "\t│");
		System.out.println("│\t│");
		System.out.println("│\t│");
		System.out.println("│\t│");
		System.out.println("└───────┘");
//		System.out.println();
	}

	public static void showFiveCards(List<Card> deck) {
		System.out.println();
		System.out.print("┌───────┐");
		System.out.print("┌──────┐");
		System.out.print("┌──────┐");
		System.out.print("┌──────┐");
		System.out.print("┌──────┐\n");
		System.out.print("│ " + deck.get(0) + "\t│");
		System.out.print("│ " + deck.get(1) + "\t│");
		System.out.print("│ " + deck.get(2) + "\t│");
		System.out.print("│ " + deck.get(3) + "\t│");
		System.out.print("│ " + deck.get(4) + "\t│\n");
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
	}
}
