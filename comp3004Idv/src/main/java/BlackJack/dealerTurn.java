package BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class dealerTurn {
	private Deck deck;
	private int dealerTotal;
	private ArrayList<Card> dealersCards; 
	private int dealerShowing;
	private Scanner console;
	private int countAce;
	public dealerTurn(int pt, ArrayList<Card> pc, Deck d, int ds, Scanner c)
	{
		dealersCards = new ArrayList<Card>();
		dealerTotal = pt;
		dealersCards = pc;
		deck = d;
		dealerShowing = ds;
		console = c;
	}
	public void drawInitialCard4Console()
	{
		System.out.print("Dealer draw: ");
		dealerTotal += deck.drawCard(dealersCards).getCardValue();
		dealersCards.get(dealersCards.size()-1).printCard(); //show
		System.out.println("Dealer draw: XXX(hiden)");
		dealerTotal += deck.drawCard(dealersCards).getCardValue();
		dealerShowing = dealerTotal - dealersCards.get(1).getCardValue();
		countAce = 0;
		for(int i = 0; i < dealersCards.size(); i++)
		{
			if (dealersCards.get(i).isAce() && dealerTotal >21 && countAce <2) 
			{
				dealersCards.get(i).setAce21(dealersCards.get(i));
				dealerTotal -= 10;
				countAce++;
			}
		}
		System.out.println("Dealer showing: " + dealerShowing);
		System.out.println();
	}
	
	public void drawInitialCard4File()
	{
		countAce = 0;	
		System.out.print("Dealer draw card: ");
		dealerTotal += deck.drawSpeCard(dealersCards, console.nextLine()).getCardValue();
		dealersCards.get(dealersCards.size()-1).printCard();
		
		System.out.print("Dealer draw card: ");
		dealerTotal += deck.drawSpeCard(dealersCards, console.nextLine()).getCardValue();
		dealersCards.get(dealersCards.size()-1).printCard();
		
		for(int i = 0; i < dealersCards.size(); i++)
		{
			if (dealersCards.get(i).isAce() && dealerTotal >21 && countAce<2) 
			{
				dealersCards.get(i).setAce21(dealersCards.get(i));
				dealerTotal -= 10;
				countAce++;
			}
		}
		
		System.out.println("dealer has total: " + dealerTotal);	
		System.out.println();
	}
	
	public void dealer_turn()
	{
		while (dealerTotal <=17)
		{
			boolean soft17 = false;
			if(dealerTotal <= 16)
			{
				System.out.print("Dealer draw card: ");
				dealerTotal += deck.drawCard(dealersCards).getCardValue();
				dealersCards.get(dealersCards.size()-1).printCard(); //show
				dealerShowing = dealerTotal - dealersCards.get(1).getCardValue();
				System.out.println("\nDealer showing: " + dealerShowing);
			}
			else
			{
				for(int i = 0; i < dealersCards.size(); i++)
				{
					//if soft 17,hit
					if (dealersCards.get(i).isAce()) 
					{
						soft17 = true;					
					}
					
				}
			}
			
			if(soft17)
			{
				System.out.println("soft 17");
				System.out.println("Dealer draw card: ");
				dealerTotal += deck.drawCard(dealersCards).getCardValue();
				dealersCards.get(dealersCards.size()-1).printCard(); //show
				dealerShowing = dealerTotal - dealersCards.get(1).getCardValue();
			}
			else
				break;
			
			//countAce = 0;
			for(int i = 0; i < dealersCards.size(); i++)
			{
				if (dealersCards.get(i).isAce() && dealerTotal >21 && countAce <2) 
				{
					dealersCards.get(i).setAce21(dealersCards.get(i));
					dealerTotal -= 10;
					countAce++;
				}
			}
			System.out.println("Dealer showing: " + dealerShowing);
		}
	}
	
	public void dealer_turn4File()
	{
		boolean soft17 = false;
		while (dealerTotal <=17)
		{
			if(dealerTotal <= 16)
			{
				System.out.println("Dealer has <17, hit");
				System.out.print("Dealer draw card: ");
				dealerTotal += deck.drawSpeCard(dealersCards, console.nextLine()).getCardValue();
				dealersCards.get(dealersCards.size()-1).printCard();
				System.out.println("dealer has: " + dealerTotal);	
			}
			else if(dealerTotal == 17)
			{
				for(int i = 0; i < dealersCards.size(); i++)
				{
					//if soft 17
					if (dealersCards.get(i).isAce()) 
					{
						soft17 = true;
						
					}
				}
			}

			if(soft17)
			{
				System.out.println("soft 17");
				System.out.print("Dealer has soft 17, hit: ");
				dealerTotal += deck.drawSpeCard(dealersCards, console.nextLine()).getCardValue();
				dealersCards.get(dealersCards.size()-1).printCard();
			}
			else
			{
				break;
			}
			
			//countAce = 0;
			for(int i = 0; i < dealersCards.size(); i++)
			{
				if (dealersCards.get(i).isAce() && dealerTotal >21 && countAce<2) 
				{
					dealersCards.get(i).setAce21(dealersCards.get(i));
					dealerTotal -= 10;
					countAce++;
				}
			}
			System.out.println("dealer has: " + dealerTotal);	
		}
	}
	public int getPT()
	{
		return dealerTotal;
	}
}
