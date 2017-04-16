package poker;

import java.util.List;

public class DefineCombination {
	
	public static int defineCombanation(List<Card> passedList) { // defines your combiantion
		Combination combination = new Combination();
		List<Card> list = passedList;
		if (combination.ifFlushRoyal(list)) {
			return 10;
		} else if (combination.ifStreetFlush(list)) {
			return 9;
		} else if (combination.ifStreetFlush(list)) {
			return 8;
		} else if (combination.ifCare(list)) {
			return 7;
		} else if (combination.ifFullHouse(list)) {
			return 6;
		} else if (combination.ifFlush(list)) {
			return 5;
		} else if (combination.ifStreet(list)) {
			return 4;
		} else if (combination.ifSet(list)) {
			return 3;
		} else if (combination.ifPairOrTwoPairs(list)) {
			return 2;
		} else if (combination.HighestCard(list)) {
			return 1;
		} else {
			return 0;
		}
		
	}
}
