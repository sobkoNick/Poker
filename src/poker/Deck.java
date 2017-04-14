package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {

	private List<Card> deck = new ArrayList<>();

	public Deck() {
		super();
		addClubs();
		addDiamonds();
		addHarts();
		addSpades();
	}
	public List<Card> getDeck() {
		return deck;
	}

	public void addClubs() {
		ClubList clubList = new ClubList();
		deck.addAll(clubList.getClubs());
	}

	public void addDiamonds() {
		DiamondsList diamondsList = new DiamondsList();
		deck.addAll(diamondsList.getDiamonds());
	}

	public void addHarts() {
		HartsList hartsList = new HartsList();
		deck.addAll(hartsList.getHarts());
	}
	
	public void addSpades() {
		SpadesList spadesList = new SpadesList();
		deck.addAll(spadesList.getSpades());
	}

	public void shuffle(){
		long seed = System.nanoTime();
		Collections.shuffle(deck, new Random(seed));
	}
	

}
