package poker;

import java.util.Iterator;
import java.util.List;

public class AIPlayer {
	public void aiChangeCards(List<Card> aiCards) {
		int aiCombinationPower = DefineCombination.defineCombanation(aiCards, false);
		if (aiCombinationPower >= 4) {
			System.out.println("AI will not change any card");
		} else if (aiCombinationPower == 3) {
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
			
		} else if (aiCombinationPower == 2) {
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
			
		}
	}
}
