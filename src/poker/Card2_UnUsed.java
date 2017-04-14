package poker;

public enum Card2_UnUsed {
	C2(Suit.CLUBS, 2,"♣"), C3(Suit.CLUBS, 3,"♣"), C4(Suit.CLUBS, 4,"♣"), C5(Suit.CLUBS, 5,"♣"), C6(Suit.CLUBS, 6,"♣"), 
	C7(Suit.CLUBS, 7,"♣"), C8(Suit.CLUBS, 8,"♣"), C9(Suit.CLUBS, 9,"♣"), C10(Suit.CLUBS,10,"♣"), 
	CJ(Suit.CLUBS, 11,"♣"), CQ(Suit.CLUBS, 12,"♣"), CK(Suit.CLUBS, 13,"♣"), CA(Suit.CLUBS, 14,"♣"),
	
	D2(Suit.DIAMONDS, 2, "♦"), D3(Suit.DIAMONDS, 3, "♦"), D4(Suit.DIAMONDS, 4, "♦"), D5(Suit.DIAMONDS, 5, "♦"), D6(Suit.DIAMONDS, 6, "♦"), 
	D7(Suit.DIAMONDS, 7, "♦"), D8(Suit.DIAMONDS, 8, "♦"), D9(Suit.DIAMONDS, 9, "♦"), D10(Suit.DIAMONDS,10, "♦"), 
	DJ(Suit.DIAMONDS, 11, "♦"), DQ(Suit.DIAMONDS, 12, "♦"), DK(Suit.DIAMONDS, 13, "♦"), DA(Suit.DIAMONDS, 14, "♦"),

	H2(Suit.DIAMONDS, 2, "♥"), H3(Suit.DIAMONDS, 3, "♥"), H4(Suit.DIAMONDS, 4, "♥"), H5(Suit.DIAMONDS, 5, "♥"), H6(Suit.DIAMONDS, 6, "♥"), 
	H7(Suit.DIAMONDS, 7, "♥"), H8(Suit.DIAMONDS, 8, "♥"), H9(Suit.DIAMONDS, 9, "♥"), H10(Suit.DIAMONDS,10, "♥"), 
	HJ(Suit.DIAMONDS, 11, "♥"), HQ(Suit.DIAMONDS, 12, "♥"), HK(Suit.DIAMONDS, 13, "♥"), HA(Suit.DIAMONDS, 14, "♥"),
	
	S2(Suit.DIAMONDS, 2, "♠"), S3(Suit.DIAMONDS, 3, "♠"), S4(Suit.DIAMONDS, 4, "♠"), S5(Suit.DIAMONDS, 5, "♠"), S6(Suit.DIAMONDS, 6, "♠"), 
	S7(Suit.DIAMONDS, 7, "♠"), S8(Suit.DIAMONDS, 8, "♠"), S9(Suit.DIAMONDS, 9, "♠"), S10(Suit.DIAMONDS,10, "♠"), 
	SJ(Suit.DIAMONDS, 11, "♠"), SQ(Suit.DIAMONDS, 12, "♠"), SK(Suit.DIAMONDS, 13, "♠"), SA(Suit.DIAMONDS, 14, "♠");
	
	private Suit suit;
	private int value;
	private String suitSymbol;
	private Card2_UnUsed(Suit suit, int value, String suitSymbol) {
		this.suit = suit;
		this.value = value;
		this.suitSymbol = suitSymbol;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public String getSuitSymbol() {
		return suitSymbol;
	}
	public String show() {
		return "" + value + "" + suitSymbol;
	}
	
}
