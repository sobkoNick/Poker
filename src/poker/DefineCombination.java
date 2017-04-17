package poker;

import java.util.List;

public class DefineCombination {
	
	public static int defineCombanation(List<Card> passedList, boolean showResult) { // defines your combiantion
		Combination combination = new Combination();
		List<Card> list = passedList;
		if (combination.ifFlushRoyal(list, showResult)) {
			return 10;
		} else if (combination.ifStreetFlush(list, showResult)) {
			return 9;
		} else if (combination.ifStreetFlush(list, showResult)) {
			return 8;
		} else if (combination.ifCare(list, showResult)) {
			return 7;
		} else if (combination.ifFullHouse(list, showResult)) {
			return 6;
		} else if (combination.ifFlush(list, showResult)) {
			return 5;
		} else if (combination.ifStreet(list, showResult)) {
			return 4;
		} else if (combination.ifSet(list, showResult)) {
			return 3;
		} else if (combination.ifPairOrTwoPairs(list, showResult)) {
			return 2;
		} else if (combination.HighestCard(list, showResult)) {
			return 1;
		} else {
			return 0;
		}
		
	}
}
