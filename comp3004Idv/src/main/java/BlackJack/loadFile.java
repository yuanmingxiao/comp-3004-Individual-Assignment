package BlackJack;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.tree.ExpandVetoException;

public class loadFile {
	private Deck deck;
	private checkWinner checkWin;
	private int playerTotal;
	private int dealerTotal;
	private playerTurn pTurn;
	private dealerTurn dTurn;
	private Scanner x;
	public loadFile()
	{
		deck = new Deck();
	}
	public void openFile()
	{
		@SuppressWarnings("resource")
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
            System.out.print(x.nextLine()+"");
    }
	}
	
	public void closeFile()
	{
		x.close();
	}
	
	public void fPro()
	{
		openFile();
		
		playerTotal = 0;
		dealerTotal = 0;
		deck = new Deck();
		
		ArrayList<Card> playersCards = new ArrayList<Card>(); 
		ArrayList<Card> dealersCards = new ArrayList<Card>();
			
		pTurn = new playerTurn(playerTotal,playersCards,deck,x, null);
		dTurn = new dealerTurn(dealerTotal,dealersCards,deck, 0, x);
		pTurn.drawInitialCard4File();
		dTurn.drawInitialCard4File();
			
		boolean playerTurn = false;
		if(x.hasNextLine())
			playerTurn = true;
		
		//player turn
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
				pTurn.player_turn4File();
			}
			if(pTurn.getPT() > 21)
			{
				break;
			}
		}
		
		//dealer turn
		boolean dealerTurn = false;
		if(x.hasNextLine() && pTurn.getPT()<=21)
			dealerTurn = true;
		
		if(dealerTurn)
			dTurn.dealer_turn4File();
		
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
		closeFile();
	}
}
