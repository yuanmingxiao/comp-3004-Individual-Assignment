package BlackJack;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class playerTurnTest {
	private playerTurn pTurnTest ;
	private Deck deck;
	private ArrayList<Card> playersCards;
	private Scanner console;
	private int playerTotal;
	@Before
	public void setUp() throws Exception {
		playerTotal = 0;
		deck = new Deck();
		console = new Scanner(System.in);
		playersCards = new ArrayList<Card>(); 
		Option option = new Option();
		pTurnTest = new playerTurn(playerTotal,playersCards,deck,console, option);
	}

	@Test
	public void test_initial() {
		pTurnTest.drawInitialCard4Console();
	}
	
	@Test
	public void test_initial4File() throws FileNotFoundException {
		console = new Scanner(new File("src/main/java/BlackJack/file1.txt"));
		pTurnTest = new playerTurn(playerTotal,playersCards,deck,console, null);
		pTurnTest.drawInitialCard4File();
	}

}
