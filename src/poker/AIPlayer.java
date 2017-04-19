package poker;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AIPlayer {
	public void aiChangeCards(List<Card> aiCards) {
		Game game = new Game();
		game.aiChangeCards(aiCards);
	}
	
	public int aiDesicionCheckBetFold(List<Card> aiCards, int playerMove, int bigBlindValue){
		// return 0 - check
		// return +int - bet/call
		// return -int - fold
		
		double aiCombinationPower = DefineCombination.defineCombanation(aiCards, false);
		
		Random random = new Random();
		double randomDecision = random.nextDouble(); // this will make ai play spontaneous
		
		if (aiCombinationPower >= 4.0) {
			if (playerMove == 0) { // player made check or didnt act
				System.out.println("AI bets 3 BB = " + (bigBlindValue * 3));
				return (bigBlindValue * 3);
			} else {
				System.out.println("AI bets 3x = " + (playerMove * 3));
				return (playerMove * 3);
			}
		} else if (aiCombinationPower == 3.0){
			if (playerMove == 0) { // player made check or didnt act
				System.out.println("AI bets 2 BB = " + (bigBlindValue * 2));
				return (bigBlindValue * 2);
			} else {
				System.out.println("AI calls = " + playerMove);
				return playerMove;
			}
		} else if (aiCombinationPower == 2.0) {
			if (playerMove == 0) {
				System.out.println("AI bets 2 BB = " + (bigBlindValue * 2));
				return (bigBlindValue * 2);
			} else {
				if (playerMove > (bigBlindValue * 2)) {
					if (randomDecision < 0.6) {
						System.out.println("AI calls = " + playerMove);
						return playerMove;
					} else {
						System.out.println("AI folds");
						return -1;
					}
				} else {
					System.out.println("AI folds");
					return -1;
				}
				
			}
		} else if (aiCombinationPower < 2.0) { // high card
			if (playerMove == 0) {
				if (randomDecision < 0.5) {
					System.out.println("AI bets 2 BB = " + (bigBlindValue * 2));
					return (bigBlindValue * 2);
				} else {
					System.out.println("AI checks");
					return 0;
				}
			} else {
				if (randomDecision < 0.7) {
					System.out.println("AI calls = " + playerMove);
					return playerMove;
				} else {
					System.out.println("AI folds");
					return -1;
				}
			}
		}
		return 0;
		
		
	}
	
}
