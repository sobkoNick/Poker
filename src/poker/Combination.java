package poker;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Combination {

	public void ifPairOrTwoPairs(List<Card> list){
		
		List<Card> list1 = new LinkedList<>(list);
//		for (Card card : list1) {
//			System.out.println(card);
//		}
		boolean end = false;
		boolean onePair = false;
		boolean twoPair = false;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					if (list.get(i).equals(list.get(j))) {
						list1.remove(i);
						list1.remove(j-1);
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
//		for (Card card : list1) {
//			System.out.println(card);
//		}
		
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list1.size(); j++) {
				if (i != j) {
					if (list1.get(i).equals(list1.get(j))) {
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
//		
//		list1.remove(0);
//		list2.remove(1);
//		list3.remove(2);
//		list4.remove(3);
//		list5.remove(4);
//		
//		boolean pairOne = false;
//		boolean pairTwo = false;
//		
//		Card pairedCard = new  Card(null, 0, null, null);
//		Card pairedCard2 = new  Card(null, 0, null, null);
//		
//		for (int i = 0; i < list.size(); i++) {
//			for (Card card : list) {
//				
//			}
//			
//			if (list.get(i).equals(obj)) {
//				
//			}
//		}
//		
//		for (Card card : list1) {
//			if (list.get(0).equals(card)) {
//				System.out.println("pair of " + card + " detected");
//				pairedCard = card;
//			}
//		}
//		for (Card card : list2) {
//			if (list.get(1).equals(card)) {
//				if (pairedCard.equals(card)) {
//					System.out.println("pair of " + card + " detected");
//				} else {
//					pairedCard2 = card;
//				}
//			}
//		}
//		for (Card card : list3) {
//			if (list.get(2).equals(card)) {
//				System.out.println("pair of " + card + " detected");
//			}
//		}
//		for (Card card : list4) {
//			if (list.get(3).equals(card)) {
//				System.out.println("pair of " + card + " detected");
//			}
//		}
//		for (Card card : list5) {
//			if (list.get(4).equals(card)) {
//				System.out.println("pair of " + card + " detected");
//			}
//		}
		
		
//		for (Card card : list5) {
//			System.out.println(card);
//		}
		
		
		
		
		
//		for (Card card : list) {
//			List<Card> withOutThatCard = new LinkedList<>(list);
//			list.remove(card);
//			Iterator<Card> iterator = withOutThatCard.iterator();
//			Card cardToCheck = card;
//			
//			while (iterator.hasNext()) {
//				Card card2 = (Card) iterator.next();
//				if (card2.equals(card)) {
//					iterator.remove();
//				}
//				
//			}
//			for (Card card1 : withOutThatCard) {
//				System.out.println(card);
//			}
//		}
		
		
		
		
//		for (Card card : withOutThatCard) {
//			Card cardToCheck = card;
//			withOutThatCard.remove(card);
//		}
		
		
//		for (Card card : list) {
//			Iterator<Card> iterator = withOutThatCard.iterator();
//			while (iterator.hasNext()) {
//				Card cardToDefine = (Card) iterator.next();
//				if (cardToDefine.equals(card)) {
//					iterator.remove();
//				}
//			}
//			for (Card card2 : withOutThatCard) {
//				System.out.println(card2);
//			}
//			
//		}
		
		
		
	}
	
}
