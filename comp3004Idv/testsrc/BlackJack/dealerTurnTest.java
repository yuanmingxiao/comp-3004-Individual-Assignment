package BlackJack;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class dealerTurnTest {
	private Deck deck;
	private int dealerTotal;
	private ArrayList<Card> dealersCards; 
	private int dealerShowing;
	private Scanner console;
	private dealerTurn dTest;
	@Before
	public void setUp() throws Exception {
		dealersCards = new ArrayList<Card>();
		dealerTotal = 0;
		deck = new Deck();
		dealerShowing = 0;
		console = new Scanner(System.in);
		dTest = new dealerTurn(dealerTotal,dealersCards,deck, dealerShowing,null);
	}

	@Test
	public void test_initial() {
		dTest.drawInitialCard4Console();
	}
	
	@Test
	public void test_initial4File() throws FileNotFoundException {
		console = new Scanner(new File("src/main/java/BlackJack/20-25.txt"));
		dTest = new dealerTurn(dealerTotal,dealersCards,deck, 0, console);
		dTest.drawInitialCard4File();
	}
	
	@Test
	public void testc_soft17()
	{
	    dealerTotal = 17;
	    String suite= Deck.suites[0];
		String name = Deck.cards[0];
		Card card = new Card(name,suite);
		dealersCards.add(card);
	    dTest = new dealerTurn(dealerTotal, dealersCards, deck, dealerTotal, console);
	    dTest.dealer_turn();
	}
}
