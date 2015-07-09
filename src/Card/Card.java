package Card;

public abstract class Card {
	private Suit suit;
	private int value;
	private boolean available = true;;
	
	public Card(Suit s, int v) {
		this.suit = s;
		this.value = v;
	}
	
	public abstract int value();
	
	public Suit suit() {
		return suit;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void markUnavailable() {
		available = false;
	}
	
	public void markAvailabe() {
		available = true;
	}
}
