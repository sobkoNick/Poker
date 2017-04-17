package poker;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AIPlayer {
	public void aiChangeCards(List<Card> aiCards) {
		int aiCombinationPower = DefineCombination.defineCombanation(aiCards, false);
		Random random = new Random();
		double randomDecision = random.nextDouble(); // this will make ai play spontaneous
		if (aiCombinationPower >= 4) {
			System.out.println("AI will not change any card");
		} else if (aiCombinationPower == 3) {
			
			if (randomDecision < 0.7) {
				Card setCard = new Card(null, 0, null, null);
				for (int i = 0; i < aiCards.size() - 1; i++) {
					if (aiCards.get(i).getValue() == aiCards.get(i+1).getValue()) {
						setCard = aiCards.get(i);
					}
				}
				Iterator<Card> iterator = aiCards.iterator();
				while (iterator.hasNext()) {
					Card card = (Card) iterator.next();
					if (card.getValue() != setCard.getValue()) {
						iterator.remove();
					}
				}
				
				aiCards.add(Game.playingDeck.get(0));
				aiCards.add(Game.playingDeck.get(1));
				
				Game.playingDeck.remove(1);
				Game.playingDeck.remove(0);
				System.out.println("AI changed 2 cards");
			} else {
				System.out.println("AI will not change any card");
			}
			
		} else if (aiCombinationPower == 2) {
			
			if (randomDecision < 0.8) {
				Card cardFromPair = null;
				Card cardFromSecondPair = null;
				boolean twoPairs = false;
				
				for (int i = 0; i < 4; i++) {
					if (aiCards.get(i).getValue() == aiCards.get(i+1).getValue()) {
						cardFromPair = aiCards.get(i);
					}
				}
				
				for (int i = 0; i < 4; i++) {
					if (aiCards.get(i).getValue() == aiCards.get(i+1).getValue()) {
						if (aiCards.get(i).getValue() != cardFromPair.getValue()) {
							twoPairs = true;
							cardFromSecondPair = aiCards.get(i);
						}
					}
				}
				
				if (twoPairs) {
					Iterator<Card> iterator = aiCards.iterator();
					while (iterator.hasNext()) {
						Card card = (Card) iterator.next();
						if (card.getValue() != cardFromPair.getValue() && card.getValue() != cardFromSecondPair.getValue()) {
							iterator.remove();
						}
					}
					aiCards.add(Game.playingDeck.get(0));
					Game.playingDeck.remove(0);
					System.out.println("AI changed 1 card");
				} else {
					Iterator<Card> iterator = aiCards.iterator();
					while (iterator.hasNext()) {
						Card card = (Card) iterator.next();
						if (card.getValue() != cardFromPair.getValue()) {
							iterator.remove();
						}
					}
					aiCards.add(Game.playingDeck.get(0));
					aiCards.add(Game.playingDeck.get(1));
					aiCards.add(Game.playingDeck.get(2));
					
					Game.playingDeck.remove(2);
					Game.playingDeck.remove(1);
					Game.playingDeck.remove(0);
					System.out.println("AI changed 3 cards");
				}
			} else {
				System.out.println("AI will not change any card");
			}		
			
		} else if (aiCombinationPower < 2) {
//			Card hiCard = aiCards.get(4);
			
			aiCards.remove(3);
			aiCards.remove(2);
			aiCards.remove(1);
			aiCards.remove(0);
			
			aiCards.add(Game.playingDeck.get(0));
			aiCards.add(Game.playingDeck.get(1));
			aiCards.add(Game.playingDeck.get(2));
			aiCards.add(Game.playingDeck.get(3));
			
			Game.playingDeck.remove(3);
			Game.playingDeck.remove(2);
			Game.playingDeck.remove(1);
			Game.playingDeck.remove(0);
			
			System.out.println("AI changed 4 cards");
			
		}
	}
	
	public int aiDesicionCheckBetFold(List<Card> aiCards, int playerMove, int bigBlindValue){
		// return 0 - check
		// return +int - bet/call
		// return -int - fold
		
		int aiCombinationPower = DefineCombination.defineCombanation(aiCards, false);
		
		Random random = new Random();
		double randomDecision = random.nextDouble(); // this will make ai play spontaneous
		
		if (aiCombinationPower >=4) {
			if (playerMove == 0) { // player made check or didnt act
				System.out.println("AI bets 3 BB = " + (bigBlindValue * 3));
				return (bigBlindValue * 3);
			} else {
				System.out.println("AI bets 3x = " + (playerMove * 3));
				return (playerMove * 3);
			}
		} else if (aiCombinationPower == 3){
			if (playerMove == 0) { // player made check or didnt act
				System.out.println("AI bets 2 BB = " + (bigBlindValue * 2));
				return (bigBlindValue * 2);
			} else {
				System.out.println("AI calls = " + playerMove);
				return playerMove;
			}
		} else if (aiCombinationPower == 2) {
			if (playerMove == 0) {
				System.out.println("AI bets 2 BB = " + (bigBlindValue * 2));
				return (bigBlindValue * 2);
			} else {
				if (playerMove > (bigBlindValue * 2)) {
					if (randomDecision < 0.7) {
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
		} else if (aiCombinationPower < 2) { // high card
			if (playerMove == 0) {
				if (randomDecision < 0.5) {
					System.out.println("AI bets 2 BB = " + (bigBlindValue * 2));
					return (bigBlindValue * 2);
				} else {
					System.out.println("AI checks");
					return 0;
				}
			} else {
				if (randomDecision < 0.5) {
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
