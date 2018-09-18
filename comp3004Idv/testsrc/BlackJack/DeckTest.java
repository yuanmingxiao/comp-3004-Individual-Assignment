package BlackJack;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {
	private Deck deckTest;
	@Before
	public void setUp() throws Exception {
		deckTest = new Deck();
	}

	@Test
	public void test_InitDeck() {
		int numberCardOnDeck = 52;
		assertEquals(numberCardOnDeck, deckTest.initDeck().size());
	}

	@Test
	public void test_shuffle()
	{
		Card orgCard = deckTest.getCard(0);
		deckTest.shuffle();
		assertNotEquals(orgCard,deckTest.getCard(0));
	}
	
	@Test
	public void test_DrawCard() {
		deckTest.initDeck();
		ArrayList<Card> cardList = new ArrayList<Card>();
		assertNotNull(deckTest.drawCard(cardList));
	}

	@Test
	public void test_DrawSpeCard() {
		deckTest.initDeck();
		ArrayList<Card> cardList = new ArrayList<Card>();
		String card = "HA";
		assertEquals("Ace",deckTest.drawSpeCard(cardList, card).getName());
		
		deckTest.initDeck();
		card = "HA";
		assertEquals("Hearts",deckTest.drawSpeCard(cardList, card).getSuites());
		
		card = "C10";
		assertEquals("10",deckTest.drawSpeCard(cardList, card).getName());
		
		card = "DK";
		assertEquals("King",deckTest.drawSpeCard(cardList, card).getName());
	}

}
