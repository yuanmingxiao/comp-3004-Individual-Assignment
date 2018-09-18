package BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

import BlackJack.Option.Options;

public class Console {
	private Deck deck;
	private Option option;
	private checkWinner checkWin;
	private int playerTotal;
	private int dealerTotal;
	private int dealerShowing;
	private playerTurn pTurn;
	private dealerTurn dTurn ;
	public Console()
	{
		deck = new Deck();
	}
	
	public void cpro()
	{
		
		boolean play = true;
		while(play == true)
		{
			playerTotal = 0;
			dealerTotal = 0;
			dealerShowing = 0;
			deck = new Deck();
			Scanner console = new Scanner(System.in);
			ArrayList<Card> playersCards = new ArrayList<Card>(); 
			ArrayList<Card> dealersCards = new ArrayList<Card>();
			option = new Option();
			pTurn = new playerTurn(playerTotal,playersCards,deck,console, option);
			dTurn = new dealerTurn(dealerTotal,dealersCards,deck, dealerShowing,null);
			pTurn.drawInitialCard4Console();
			dTurn.drawInitialCard4Console();
			
			//Player turn
			pTurn.player_turn();
			
			//Dealer turn
			if(pTurn.getPT() <= 21)
			{
				dTurn.dealer_turn();
			}
			checkWin = new checkWinner();
			checkWin.checkWin(pTurn.getPT(),dTurn.getPT());
			System.out.println();
			System.out.println("Player has: ");
			for(Card card : playersCards)
			{
				System.out.println(card.toString() + " | value: " + card.getCardValue());
			}
			
			System.out.println();
			System.out.println("Dealer has: ");
			for(Card card : dealersCards)
			{
				System.out.println(card.toString() + " | value: " + card.getCardValue());
			}
			System.out.println("--------------------");
			System.out.println("Do you wang to play again? y/n");
			String replay = console.next();
			if(replay.equals("y"))
				play = true;
			else
				play = false;
		}
	}
}
