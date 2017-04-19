package poker;

import java.util.List;

public class DefineCombination {
	
	public static double defineCombanation(List<Card> passedList, boolean showResult) {
		
		Combination combination = new Combination();
		List<Card> list = passedList;
		
		double combiPower = 0;
		if (combination.ifFlushRoyal(list, showResult)) {
			return 10.0;
		} else if ((combiPower = combination.ifStreetFlush(list, showResult)) > 0) {
			return combiPower;
		} else if ((combiPower = combination.ifStreetFlush(list, showResult)) > 0) {
			return combiPower;
		} else if ((combiPower = combination.ifCare(list, showResult)) > 0) {
			return combiPower;
		} else if ((combiPower = combination.ifFullHouse(list, showResult)) > 0) {
			return combiPower;
		} else if ((combiPower = combination.ifFlush(list, showResult)) > 0) {
			return combiPower;
		} else if ((combiPower = combination.ifStreet(list, showResult)) > 0) {
			return combiPower;
		} else if ((combiPower = combination.ifSet(list, showResult)) > 0) {
			return combiPower;
		} else if (( combiPower = combination.ifPairOrTwoPairs(list, showResult)) > 0) {
			return combiPower;
		} else if ((combiPower = combination.HighestCard(list, showResult)) > 0) {
			return combiPower;
		} else {
			return 0;
		}
		
	}
}
