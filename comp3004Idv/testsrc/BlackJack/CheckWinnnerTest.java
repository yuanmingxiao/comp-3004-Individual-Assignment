package BlackJack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CheckWinnnerTest {
	private int playerTotal;
	private int dealerTotal;
	private checkWinner checkTest;
	@Before
	public void setUp() throws Exception {
		checkTest = new checkWinner();
	}

	@Test
	public void test_checkWin() {
		playerTotal = 10;
		dealerTotal = 20;
		checkTest.checkWin(playerTotal,dealerTotal);
		
		playerTotal = 20;
		dealerTotal = 20;
		checkTest.checkWin(playerTotal,dealerTotal);
		
		playerTotal = 21;
		dealerTotal = 20;
		checkTest.checkWin(playerTotal,dealerTotal);
		
		playerTotal = 22;
		dealerTotal = 17;
		checkTest.checkWin(playerTotal,dealerTotal);
		
		playerTotal = 2;
		dealerTotal = 22;
		checkTest.checkWin(playerTotal,dealerTotal);
	}
	
}
