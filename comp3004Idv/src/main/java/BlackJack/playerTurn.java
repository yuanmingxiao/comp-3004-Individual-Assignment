package BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

import BlackJack.Option.Options;

public class playerTurn {
	private Deck deck;
	private Option option;
	private int playerTotal;
	private ArrayList<Card> playersCards; 
	private Scanner console;
	int countAce;
	public playerTurn(int pt, ArrayList<Card> pc, Deck d, Scanner c, Option o)
	{
		playersCards = new ArrayList<Card>();
		//console = new Scanner(System.in);
		playerTotal = pt;
		playersCards = pc;
		deck = d;
		console = c;
		option = o;
	}
	public void drawInitialCard4Console()
	{
		System.out.print("First card: ");
		playerTotal += deck.drawCard(playersCards).getCardValue();
		playersCards.get(playersCards.size()-1).printCard(); //show
		
		System.out.print("Second card: ");
		playerTotal += deck.drawCard(playersCards).getCardValue();	
		playersCards.get(playersCards.size()-1).printCard(); //show
		System.out.println();
		countAce = 0;
		for(int i = 0; i < playersCards.size(); i++)
		{
			if (playersCards.get(i).isAce() && playerTotal > 21&& countAce < 2) 
			{
				playersCards.get(i).setAce21(playersCards.get(i));
				playerTotal -= 10;
				countAce++;
				//has ace, ace = 1;
			}
		}
	}
	
	public void drawInitialCard4File()
	{
		System.out.print("Player draw card: ");
		playerTotal += deck.drawSpeCard(playersCards, console.nextLine()).getCardValue();
		playersCards.get(playersCards.size()-1).printCard();
		
		System.out.print("Player draw card: ");
		playerTotal += deck.drawSpeCard(playersCards, console.nextLine()).getCardValue();
		playersCards.get(playersCards.size()-1).printCard();
		
		countAce = 0;
		for(int i = 0; i < playersCards.size(); i++)
		{
			if (playersCards.get(i).isAce() && playerTotal > 21 && countAce<2) 
			{
				playersCards.get(i).setAce21(playersCards.get(i));
				playerTotal -= 10;
				countAce++;
				//has ace, ace = 1;
			}
		}
		
		System.out.println("player has total: " + playerTotal);
		System.out.println();
	}
	
	public void player_turn()
	{
		while(playerTotal < 21)
		{
			option.opt(playersCards,playerTotal, console);
			
			if(option.getType() == Options.Hit)
			{
				System.out.print("player draw card: ");
				playerTotal += deck.drawCard(playersCards).getCardValue();
				playersCards.get(playersCards.size()-1).printCard(); //show
			}
			else if(option.getType() == Options.Stand)
			{
				break;
			}
			else
			{
				
			}
			//countAce = 0;
			for(int i = 0; i < playersCards.size(); i++)
			{
				if (playersCards.get(i).isAce() && playerTotal > 21&& countAce < 2) 
				{
					playersCards.get(i).setAce21(playersCards.get(i));
					playerTotal -= 10;
					countAce++;
					//has ace, ace = 1;
				}
			}
			System.out.println("You have: " + playerTotal);
		}
	}
	
	public void player_turn4File()
	{
		System.out.println("Player hit ");
		System.out.print("Player draw card: ");
		playerTotal += deck.drawSpeCard(playersCards, console.nextLine()).getCardValue();
		playersCards.get(playersCards.size()-1).printCard();	
		
		//countAce = 0;
		for(int i = 0; i < playersCards.size(); i++)
		{
			if (playersCards.get(i).isAce() && playerTotal > 21 && countAce<2) 
			{
				playersCards.get(i).setAce21(playersCards.get(i));
				playerTotal -= 10;
				countAce++;
				//has ace, ace = 1;
			}
		}
		
		System.out.println("\n player has: " + playerTotal);
	}
	
	public int getPT()
	{
		return playerTotal;
	}
}
