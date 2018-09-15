package BlackJack;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Deck {
	public static final String[] suites = {"Hearts", "Spades", "Clubs", "Diamonds"};
	public static final String[] cards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	
	public ArrayList<Card> deck;
	
	public Deck()
	{
		deck = initDeck();
	}
	
	public  ArrayList<Card> initDeck()
	{
		deck = new ArrayList<Card>();
		for(int i=0; i<suites.length;i++)
		{
			for(int j=0; j<cards.length;j++)
			{
				Card card = new Card(cards[j],suites[i]);
				deck.add(card);
			}
		}
		return deck;
	}
	
	public void shuffle(){
		SecureRandom randomNumber = new SecureRandom();
		//for each card in the deck, pick another random card and swap them
		for(int first = 0; first < deck.size(); first++)
		{
			int second = randomNumber.nextInt(deck.size());
			
			//swap the card
			Card temp = deck.get(first);
			deck.set(first, deck.get(second));
			deck.set(second, temp);
		}
	}
	
	public Card drawCard(ArrayList<Card> cardList) {
		Card card = null;
		if(deck.size() == 0)
		{
			initDeck();
		}
		if(deck.size() != 0) 
		{
			int index = (int)(Math.random()*deck.size());
			card = deck.get(index);
			deck.remove(index);
		}
		cardList.add(card);
		return card;
	}
	
	public void getDeck(int i)
	{
		deck.get(i).printCard();
	}
	/*public static void main(String[] arg)
	{
		initDeck();
		deck.get(0).printCard();
	}*/
}
