package gameCard;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Deck {
	private List<Card> listCard ;
	
	public Deck() {
		listCard = new ArrayList<Card>();
		
		for (int i = 1; i <= 13; i++) {
			for (int j = 1; j <= 4; j++) {
				Card card = new Card(i, j);
				listCard.add(card);
			}
		}
	}
	
	public void printDeck() {
		for (int i = 0; i < listCard.size(); i++) {
			System.out.println(listCard.get(i).toString() + "");
		System.out.println();	
		}
	}
	
	public void shuffDeck() {
		Collections.shuffle(listCard);
	}
	
	public void sortDeck(){
		Collections.sort(listCard);
	}
	
	public List<Card> getDeck() {
		return listCard;
	}
}
