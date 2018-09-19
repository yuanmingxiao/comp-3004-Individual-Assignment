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
	
	public Card drawSpeCard(ArrayList<Card> cardList, String a)
	{
		//System.out.println(a.charAt(0) + " " + a.charAt(1));
		Card card = null;
		String s = null;
		String c = null;
		
		if(a.length()<2)
		{
			System.out.println();
			System.out.println("-----missing input-----");
			System.exit(0);
		}
		
		if(a.charAt(0) == 'H')
			s = suites[0];
		else if(a.charAt(0) == 'S')
			s = suites[1];
		else if (a.charAt(0) == 'C')
			s = suites[2];
		else if (a.charAt(0) == 'D')
			s = suites[3];
		else
		{
			System.out.println("Incorrect suit: -- " + a.charAt(0));
			System.exit(0);
		}
		
		if(a.charAt(1) == 'A')
			c = cards[0];
		else if(a.charAt(1) == '2')
			c = cards[1];
		else if(a.charAt(1) == '3')
			c = cards[2];
		else if(a.charAt(1) == '4')
			c = cards[3];
		else if(a.charAt(1) == '5')
			c = cards[4];
		else if(a.charAt(1) == '6')
			c = cards[5];
		else if(a.charAt(1) == '7')
			c = cards[6];
		else if(a.charAt(1) == '8')
			c = cards[7];
		else if(a.charAt(1) == '9')
			c = cards[8];
		else if(a.charAt(1) == '1')
			c = cards[9];
		else if(a.charAt(1) == 'J')
			c = cards[10];
		else if(a.charAt(1) == 'Q')
			c = cards[11];
		else if(a.charAt(1) == 'K')
			c = cards[12];
		else
		{
			System.out.println("Incorrect rank: -- " + a.charAt(1));
			System.exit(0);
		}
		
		boolean hasCardinDeck = false;
	 for(int i=0; i<deck.size();i++)
	 {
		 if(deck.get(i).getName().equals(c) && deck.get(i).getSuites().equals(s))
		 {
			 card = deck.get(i);
			 deck.remove(i);
			 hasCardinDeck = true;
			 break;
		 }
	 }
	 
	 if(!hasCardinDeck)
	 {
		System.out.println("card already played");
		System.exit(0);
	 }
	 cardList.add(card);
		return card;
	}
	
	public ArrayList<Card> getDeck()
	{
		return deck;
	}
	
	public Card getCard(int i)
	{
		return deck.get(i);
	}
	
	public static void showHandCards(ArrayList<Card> cardList)
	{
		for(Card card : cardList)
		{
			System.out.println("you have: " + card.toString() + " | value: " + card.getCardValue());
		}
	}
	/*public static void main(String[] arg)
	{
		initDeck();
		deck.get(0).printCard();
	}*/
}
