package poker;

public enum Suit {
	SPADES("♠"), DIAMONDS("♦"), CLUBS("♣"), HARTS("♥");
	
	String symbol;

	private Suit(String symbol) {
		this.symbol = symbol;
	}
	
	
}
