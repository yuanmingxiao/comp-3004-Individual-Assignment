package BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

import BlackJack.Option.Options;

public class Console {
	private Deck deck;
	private Option option;
	private CheckWinnner checkWin;
	public Console()
	{
		deck = new Deck();
	}
	
	public void cpro()
	{
		Scanner console = new Scanner(System.in);
		boolean play = true;
		while(play == true)
		{
			int playerTotal = 0;
			int dealerTotal = 0;
			int dealerShowing = 0;
			
			ArrayList<Card> playersCards = new ArrayList<Card>(); 
			ArrayList<Card> dealersCards = new ArrayList<Card>();
			
			deck.shuffle();
			System.out.print("First card: ");
			playerTotal += deck.drawCard(playersCards).getCardValue();
			playersCards.get(playersCards.size()-1).printCard(); //show
			
			System.out.print("Second card: ");
			playerTotal += deck.drawCard(playersCards).getCardValue();	
			playersCards.get(playersCards.size()-1).printCard(); //show
			System.out.println();

			System.out.print("Dealer draw: ");
			dealerTotal += deck.drawCard(dealersCards).getCardValue();
			dealerTotal += deck.drawCard(dealersCards).getCardValue();
			dealersCards.get(dealersCards.size()-1).printCard(); //show
			dealerShowing = dealerTotal - dealersCards.get(0).getCardValue();
			System.out.println("Dealer showing: " + dealerShowing);
			System.out.println("Dealer total: " + dealerTotal);
			
			option = new Option();
			
			//Player turn
			while(playerTotal < 21)
			{
				option.opt(playerTotal, console);
				
				if(option.getType() == Options.Hit)
				{
					System.out.print("player draw card: ");
					playerTotal += deck.drawCard(playersCards).getCardValue();
					playersCards.get(playersCards.size()-1).printCard(); //show
					System.out.println("You have: " + playerTotal);
				}
				else if(option.getType() == Options.Stand)
				{
					break;
				}
				else
				{
					
				}
				for(int i = 0; i < playersCards.size(); i++)
				{
					if (playersCards.get(i).isAce() && playerTotal > 21) 
					{
						playerTotal -= 10;
						//has ace, ace = 1;
					}
				}
			}
			
			if(playerTotal > 21)
			{
				System.out.println("you busts!");
				play = false;
				break;
			}
			
			//Dealer turn
			while (dealerTotal <=17)
			{
				if(dealerTotal <= 16)
				{
					System.out.print("Dealer draw card: ");
					dealerTotal += deck.drawCard(dealersCards).getCardValue();
					dealersCards.get(dealersCards.size()-1).printCard(); //show
					dealerShowing = dealerTotal - dealersCards.get(0).getCardValue();
					System.out.println("\nDealer showing: " + dealerShowing);
				}
				else
				{
					for(int i = 0; i < dealersCards.size(); i++)
					{
						//if soft 17
						if (dealersCards.get(i).isAce() && dealerTotal == 17) 
						{
							dealerTotal += deck.drawCard(dealersCards).getCardValue();
							dealersCards.get(dealersCards.size()-1).printCard(); //show
							dealerShowing = dealerTotal - dealersCards.get(0).getCardValue();
							System.out.println("\nDealer has: " + dealerShowing);
						}
					}
				}
			}
			checkWin = new CheckWinnner();
			checkWin.checkWin(playerTotal,dealerTotal);
			System.out.println("Do you wang to play again? y/n");
			String replay = console.next();
			if(replay.equals("y"))
				play = true;
			else
				play = false;
		}
	}
}
