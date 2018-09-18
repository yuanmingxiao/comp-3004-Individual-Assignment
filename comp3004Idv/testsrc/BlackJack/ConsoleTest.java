package BlackJack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConsoleTest {
	private Deck deckTest;
	private Console consoleTest;
	@Before
	public void setUp() throws Exception {
		consoleTest = new Console();
	}

	@Test
	public void testc_cPro() {
		consoleTest.cpro();
	}

}
