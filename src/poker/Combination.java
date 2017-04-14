package poker;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Combination {

	public void ifFlush(List<Card> list) {
		int ifFlushCounter = 0;
		Card card = list.get(0);
		for (Card cardFromList : list) {
			if (card.getSuit().equals(cardFromList.getSuit())) {
				ifFlushCounter++;
			}
		}
		if (ifFlushCounter == 5) {
			System.out.println("You have got flush up to " + list.get(list.size()-1));
		}
	}
	
	public void ifStreet(List<Card> list) {
		Collections.sort(list, new SortByValue());
		int ifStreetCounter = 0;
		int cardValue = list.get(0).getValue();
		for (int i = 1; i < list.size(); i++) {
			cardValue++;
			if (list.get(i).getValue() == cardValue) {
				ifStreetCounter++;
			}
		}
		if (ifStreetCounter == 4) {
			System.out.println("You have got street from " + list.get(0) + " to " + list.get(list.size()-1));
		}
		
	}
	
	public void ifSet(List<Card> list) {
		Collections.sort(list, new SortByValue());
		for (int i = 0; i < 3; i++) {
			if ((list.get(i).equals(list.get(i+1))) && (list.get(i+1).equals(list.get(i+2)))) {
				System.out.println("you have got set of " + list.get(i));
			}
		}
	}

	public void ifPairOrTwoPairs(List<Card> list) {

		List<Card> list1 = new LinkedList<>(list);

		boolean end = false;
		boolean onePair = false;
		boolean twoPair = false;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					if (list.get(i).getValue() == list.get(j).getValue()) {
						list1.remove(i);
						list1.remove(j - 1);
						System.out.println("Pair of " + list.get(i));
						onePair = true;
						end = true;
						break;
					}
				}
			}
			if (end) {
				break;
			}
		}
		end = false;
		// for (Card card : list1) {
		// System.out.println(card);
		// }

		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list1.size(); j++) {
				if (i != j) {
					if (list1.get(i).getValue() == list1.get(j).getValue()) {
						System.out.println("Pair of " + list1.get(i));
						end = true;
						twoPair = true;
						break;
					}
				}
			}
			if (end) {
				break;
			}
		}

		if (twoPair && onePair) {
			System.out.println("You've got two pairs");
		}

		// Card pairedCard = new Card(null, 0, null, null);
		// Card pairedCard2 = new Card(null, 0, null, null);
		//
		// for (int i = 0; i < list.size(); i++) {
		// for (Card card : list) {
		//
		// }
		//
		// if (list.get(i).equals(obj)) {
		//
		// }
		// }
		//
		// for (Card card : list1) {
		// if (list.get(0).equals(card)) {
		// System.out.println("pair of " + card + " detected");
		// pairedCard = card;
		// }
		// }
		// for (Card card : list2) {
		// if (list.get(1).equals(card)) {
		// if (pairedCard.equals(card)) {
		// System.out.println("pair of " + card + " detected");
		// } else {
		// pairedCard2 = card;
		// }
		// }
		// }
		// for (Card card : list3) {
		// if (list.get(2).equals(card)) {
		// System.out.println("pair of " + card + " detected");
		// }
		// }
		// for (Card card : list4) {
		// if (list.get(3).equals(card)) {
		// System.out.println("pair of " + card + " detected");
		// }
		// }
		// for (Card card : list5) {
		// if (list.get(4).equals(card)) {
		// System.out.println("pair of " + card + " detected");
		// }
		// }

		// for (Card card : list5) {
		// System.out.println(card);
		// }

		// for (Card card : list) {
		// List<Card> withOutThatCard = new LinkedList<>(list);
		// list.remove(card);
		// Iterator<Card> iterator = withOutThatCard.iterator();
		// Card cardToCheck = card;
		//
		// while (iterator.hasNext()) {
		// Card card2 = (Card) iterator.next();
		// if (card2.equals(card)) {
		// iterator.remove();
		// }
		//
		// }
		// for (Card card1 : withOutThatCard) {
		// System.out.println(card);
		// }
		// }

		// for (Card card : withOutThatCard) {
		// Card cardToCheck = card;
		// withOutThatCard.remove(card);
		// }

		// for (Card card : list) {
		// Iterator<Card> iterator = withOutThatCard.iterator();
		// while (iterator.hasNext()) {
		// Card cardToDefine = (Card) iterator.next();
		// if (cardToDefine.equals(card)) {
		// iterator.remove();
		// }
		// }
		// for (Card card2 : withOutThatCard) {
		// System.out.println(card2);
		// }
		//
		// }
	}

	public void HighestCard(List<Card> list) {
		Collections.sort(list, new SortByValue());
		for (Card card : list) {
			System.out.println(card);
		}
		System.out.println("Highest card is " + list.get(list.size() - 1));
	}

}
