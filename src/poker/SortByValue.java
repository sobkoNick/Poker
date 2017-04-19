package poker;

import java.util.Comparator;

public class SortByValue implements Comparator<Card> {

	@Override
	public int compare(Card arg0, Card arg1) {
		return arg0.getValue() - arg1.getValue();
	}

}
