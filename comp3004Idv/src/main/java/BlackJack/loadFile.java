package BlackJack;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.tree.ExpandVetoException;

public class loadFile {
	private Scanner x;
	private Deck deck;
	private CheckWinnner checkWin;
	public loadFile()
	{
		deck = new Deck();
	}
	public void openFile()
	{
		Scanner console = new Scanner(System.in);
		System.out.println("type file name you want to load");
		String file = console.next();
		try {
			x = new Scanner(new File("src/main/java/BlackJack/" + file + ".txt"));
			//src/main/java/BlackJack/file1.txt
		}
		catch(Exception e) {
			System.out.println("No file found");
		}
	}
	
	public void readFile()
	{
		while(x.hasNext()){
            System.out.print(x.nextLine()+"\n");
    }
	}
	
	public void closeFile()
	{
		x.close();
	}
	
	public void fPro()
	{
		openFile();
		
		int playerTotal = 0;
		int dealerTotal = 0;
		int dealerShowing = 0;
			
		ArrayList<Card> playersCards = new ArrayList<Card>(); 
		ArrayList<Card> dealersCards = new ArrayList<Card>();
			
		System.out.print("Player draw card: ");
		playerTotal += deck.drawSpeCard(playersCards, x.nextLine()).getCardValue();
		playersCards.get(playersCards.size()-1).printCard();
		System.out.println("\n player has: " + playerTotal);
		
		System.out.print("Player draw card: ");
		playerTotal += deck.drawSpeCard(playersCards, x.nextLine()).getCardValue();
		playersCards.get(playersCards.size()-1).printCard();
		System.out.println("\n player has: " + playerTotal);
			
		System.out.print("Dealer draw card: ");
		dealerTotal += deck.drawSpeCard(dealersCards, x.nextLine()).getCardValue();
		dealersCards.get(dealersCards.size()-1).printCard();
		System.out.println("\n dealer has: " + dealerTotal);	
		
		System.out.print("Dealer draw card: ");
		dealerTotal += deck.drawSpeCard(dealersCards, x.nextLine()).getCardValue();
		dealersCards.get(dealersCards.size()-1).printCard();
		System.out.println("\n dealer has: " + dealerTotal);	
			
		boolean playerTurn = false;
		if(x.hasNextLine())
			playerTurn = true;
		
		while(playerTurn)
		{
			if(x.nextLine().equals("S"))
			{
				System.out.println("Player stand");
				playerTurn = false;
				break;
			}
			else
			{
				System.out.println("Player hit ");
				System.out.print("Player draw card: ");
				playerTotal += deck.drawSpeCard(playersCards, x.nextLine()).getCardValue();
				playersCards.get(playersCards.size()-1).printCard();			
			}
			for(int i = 0; i < playersCards.size(); i++)
			{
				if (playersCards.get(i).isAce() && playerTotal > 21) 
				{
					playerTotal -= 10;
					//has ace, ace = 1;
				}
			}
			System.out.println("\n player has: " + playerTotal);
		}
		
		boolean dealerTurn = false;
		if(x.hasNextLine())
			dealerTurn = true;
		
		while (dealerTotal <=17 && dealerTurn)
		{
			if(dealerTotal <= 16)
			{
				System.out.println("Dealer has <17, hit");
				System.out.print("Dealer draw card: ");
				dealerTotal += deck.drawSpeCard(dealersCards, x.nextLine()).getCardValue();
				dealersCards.get(dealersCards.size()-1).printCard();
				System.out.println("\n dealer has: " + dealerTotal);	
			}
			else if(dealerTotal == 17)
			{
				for(int i = 0; i < dealersCards.size(); i++)
				{
					//if soft 17
					if (dealersCards.get(i).isAce()) 
					{
						System.out.print("Dealer has 17, hit: ");
						dealerTotal += deck.drawSpeCard(dealersCards, x.nextLine()).getCardValue();
						dealersCards.get(dealersCards.size()-1).printCard();
						System.out.println("\n dealer has: " + dealerTotal);	
					}
				}	
			}
			else
			{
				System.out.println("Dealer stand");
				break;
			}
			for(int i = 0; i < dealersCards.size(); i++)
			{
				if (dealersCards.get(i).isAce() && dealerTotal >21) 
				{
					dealerTotal -= 10;
				}
			}
				
		}
		checkWin = new CheckWinnner();
		checkWin.checkWin(playerTotal,dealerTotal);

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
		closeFile();
	}
}
