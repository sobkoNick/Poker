package poker;

public class Card {
	private Suit suit;
	private int value;
	private String name;
	private String symbol;
	
	public Card(Suit suit, int value, String name, String symbol) {
		super();
		this.suit = suit;
		this.value = value;
		this.name = name;
		this.symbol = symbol;
	}
	

	public Suit getSuit() {
		return suit;
	}



	public int getValue() {
		return value;
	}



	public String getName() {
		return name;
	}



	public String getSymbol() {
		return symbol;
	}



	@Override
	public String toString() {
		//return "Card [suit=" + suit + " "+ suit.symbol +", value=" + value + ", name=" + name + "]";
		//return "" + name + " of " + suit.symbol;
		return suit.symbol + "" + symbol;
 	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (suit != other.suit)
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
	
}
