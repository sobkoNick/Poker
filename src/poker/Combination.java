package poker;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Combination {
	
	public boolean ifFlushRoyal(List<Card> list, boolean showResult) {
		Card card = list.get(0);
		for (Card cardFromList : list) {
			if (!card.getSuit().equals(cardFromList.getSuit())) {
				return false;
			}
		}

		Collections.sort(list, new SortByValue());

		if (list.get(0).getValue() == 10) {
			int cardValueCounter = list.get(0).getValue();
			for (int i = 1; i < list.size(); i++) {
				cardValueCounter++;
				if (list.get(i).getValue() == cardValueCounter) {
				} else {
					return false;
				}
			}
			if (showResult) {
				System.out.println("You have got Royal Flush from " + list.get(0) + " to " + list.get(4));
			}
			return true;
		} else {
			return false;
		}
	}

	public double ifStreetFlush(List<Card> list, boolean showResult) {

		Card card = list.get(0);

		for (Card cardFromList : list) {
			if (!card.getSuit().equals(cardFromList.getSuit())) {
				return 0.0;
			}
		}
		Collections.sort(list, new SortByValue());
		int cardValueCounter = list.get(0).getValue();

		for (int i = 1; i < list.size(); i++) {
			cardValueCounter++;
			if (list.get(i).getValue() == cardValueCounter) {
			} else {
				return 0.0;
			}
		}

		if (cardValueCounter == list.get(list.size() - 1).getValue()) {
			if (showResult) {
				System.out.println("You have got street flush from " + list.get(0) + " to " + list.get(4));
			}
			return 8.0 + (list.get(4).getValue() / 100); 
		} else {
			return 0.0;
		}
	}

	public double ifCare(List<Card> list, boolean showResult) {
		Collections.sort(list, new SortByValue());
		Card cardOne = list.get(0);
		int careCounter = 0;

		if (list.get(0).getValue() == list.get(1).getValue()) {
			for (Card card : list) {
				if (cardOne.getValue() == card.getValue()) {
					careCounter++;
				}
			}
			if (careCounter == 4) {
				if (showResult) {
					System.out.println("You have got care of " + list.get(1) + list.get(2) + list.get(3) + list.get(0));
				}
				return 7.0 + (list.get(1).getValue() / 100); // care of aces = 8.14
			}

		} else {
			careCounter = 0;
			cardOne = list.get(1);
			for (Card card : list) {
				if (cardOne.getValue() == card.getValue()) {
					careCounter++;
				}
			}
			if (careCounter == 4) {
				if (showResult) {
					System.out.println("You have got care of " + list.get(1) + list.get(2) + list.get(3) + list.get(4));
				}
				return 7.0 + (list.get(4).getValue() / 100);
			}
		}
		return 0.0;
	}

	public double ifFullHouse(List<Card> list, boolean showResult) {
		Collections.sort(list, new SortByValue());
		if ((list.get(0).getValue() == list.get(1).getValue()) && (list.get(2).getValue() == list.get(3).getValue())
				&& (list.get(3).getValue() == list.get(4).getValue())) {
			
			if (showResult) {
				System.out.println("You have got full house of 3 " + list.get(4) + list.get(3) + list.get(2) + " and 2 "
						+ list.get(0) + list.get(1));
			}
			return 6.0 + (list.get(4).getValue() / 100);
		} else if ((list.get(0).getValue() == list.get(1).getValue()
				&& (list.get(1).getValue() == list.get(2).getValue())
				&& (list.get(3).getValue() == list.get(4).getValue()))) {
			if (showResult) {
				System.out.println("You have got full house of 3 " + list.get(0) + list.get(1) + list.get(2) + " and 2 "
						+ list.get(4) + list.get(3));
			}
			return 6.0 + (list.get(0).getValue() / 100);
		} else {
			return 0.0;
		}
	}

	public double ifFlush(List<Card> list, boolean showResult) {
		int ifFlushCounter = 0;
		Card card = list.get(0);
		for (Card cardFromList : list) {
			if (card.getSuit().equals(cardFromList.getSuit())) {
				ifFlushCounter++;
			} else {
				return 0.0;
			}
		}
		if (ifFlushCounter == 5) {
			if (showResult) {
				System.out.println("You have got flush up to " + list.get(list.size() - 1));	
			}
			return 5.0 + (list.get(list.size() - 1).getValue() / 100);
		} else {
			return 0.0;
		}
	}

	public double ifStreet(List<Card> list, boolean showResult) {
		Collections.sort(list, new SortByValue());
		int ifStreetCounter = 0;
		int cardValue = list.get(0).getValue();
		for (int i = 1; i < list.size(); i++) {
			cardValue++;
			if (list.get(i).getValue() == cardValue) {
				ifStreetCounter++;
			} else {
				return 0.0;
			}
		}
		if (ifStreetCounter == 4) {
			if (showResult) {
				System.out.println("You have got street from " + list.get(0) + " to " + list.get(list.size() - 1));
			}
			return (4.0 + (list.get(list.size() - 1).getValue() / 100));
		} else {
			return 0.0;
		}

	}

	public double ifSet(List<Card> list, boolean showResult) {
		Collections.sort(list, new SortByValue());
		for (int i = 0; i < 3; i++) {
			if ((list.get(i).getValue() == (list.get(i + 1).getValue()))
					&& (list.get(i + 1).getValue() == (list.get(i + 2).getValue()))) {
				
				if (showResult) {
					System.out.println("you have got set of " + list.get(i));
				}
				return (3.0 + (list.get(i).getValue() / 100));
			}
		}
		return 0.0;
	}

	public double ifPairOrTwoPairs(List<Card> list, boolean showResult) {

		List<Card> list1 = new LinkedList<>(list);
		Card onePairCard = null;
		Card secondPairCard = null;
		
		boolean end = false;
		boolean onePair = false;
		boolean twoPair = false;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					if (list.get(i).getValue() == list.get(j).getValue()) {
						if (showResult) {
							System.out.println("One pair " + list.get(i) + "" + list.get(j));
						}
						onePairCard = list.get(i);
						list1.remove(i);
						list1.remove(j - 1);
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

		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list1.size(); j++) {
				if (i != j) {
					if (list1.get(i).getValue() == list1.get(j).getValue()) {
						if (showResult) {
							System.out.println("One pair " + list1.get(i) + "" + list1.get(j));
						}
						secondPairCard = list1.get(i);
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
			if (showResult) {
				System.out.println("You've got two pairs");	
			}
			
			if (onePairCard.getValue() > secondPairCard.getValue()) {
				return 2.5 + (onePairCard.getValue() / 100);
			}  
			else if (onePairCard.getValue() < secondPairCard.getValue()){
				return 2.5 + (secondPairCard.getValue() / 100);
			}
		} else if (onePair || twoPair) {
			if (onePair) {
				return  2.0 + (onePairCard.getValue() / 100);
			}
			if (twoPair) {
				return  2.0 + (secondPairCard.getValue() / 100);
			}
		} else {
			return 0;
		}
		return 0;
	}

	public double HighestCard(List<Card> list, boolean showResult) {
		Collections.sort(list, new SortByValue());
		if (showResult) {
			System.out.println("Highest card is " + list.get(list.size() - 1));
		}
		return 1.0 + (list.get(list.size() - 1).getValue() / 100); // has to defide by 100. 1.14 - ace high card
	}

}
