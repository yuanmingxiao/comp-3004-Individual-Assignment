package BlackJack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	private Card cardTest; 
	@Before
	public void setUp() throws Exception {
		String name = null;
		String suite = null;
		cardTest =new Card();
	}

	@Test
	public void test_determineCardValue() {
		int value = 10;
		String name = "10";
		assertEquals(value, cardTest.determineCardValue(name));
		
		value = 5;
		name = "5";
		assertEquals(value, cardTest.determineCardValue(name));
		
		value = 11;
		name = "Ace";
		assertEquals(value, cardTest.determineCardValue(name));
		
		value = 10;
		name = "Jack";
		assertEquals(value, cardTest.determineCardValue(name));
		
		name = "Queen";
		assertEquals(value, cardTest.determineCardValue(name));
		
		name = "King";
		assertEquals(value, cardTest.determineCardValue(name));
	}
	
	@Test
	public void test_getCardValue()
	{
		int value = 5;
		String name = "5";
		String suite = "Hearts";
		cardTest =new Card(name,suite);
		assertEquals(value, cardTest.getCardValue());
		
		value = 10;
		name = "10";
		cardTest =new Card(name,suite);
		assertEquals(value, cardTest.getCardValue());
		
		value = 11;
		name = "Ace";
		cardTest =new Card(name,suite);
		assertEquals(value, cardTest.getCardValue());
		
		value = 10;
		name = "Jack";
		cardTest =new Card(name,suite);
		assertEquals(value, cardTest.getCardValue());
	}
	
	@Test
	public void test_isAce()
	{
		String name = "Ace";
		String suite = "Hearts";
		cardTest =new Card(name,suite);
		assertTrue(cardTest.isAce());
		
		name = "10";
		suite = "Hearts";
		cardTest =new Card(name,suite);
		assertFalse(cardTest.isAce());
	}
	
	@Test
	public void test_getSuites()
	{
		String name = "Ace";
		String suite = "Hearts";
		cardTest =new Card(name,suite);
		assertEquals(suite, cardTest.getSuites());
	}
	
	@Test
	public void test_getName()
	{
		String name = "Ace";
		String suite = "Hearts";
		cardTest =new Card(name,suite);
		assertEquals(name,cardTest.getName());
	}
}
