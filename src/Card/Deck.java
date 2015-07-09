package Card;

import java.util.ArrayList;

public class Deck <T extends Card> {
	private ArrayList<T> cards;
	private int dealtIndex = 0;
	public void setDeckofCard(ArrayList<T> deckOfCards) {
		
	}
	 
	 public void shuffle() {
		 
	 }
	 
	 public int remainingCard() {
		 return cards.size() - dealtIndex;
	 }
	 
	 public T[] dealHead(int number) {
		 return null;
	 }
	 
	 public T dealCard() {
		 return null;
	 }
}

