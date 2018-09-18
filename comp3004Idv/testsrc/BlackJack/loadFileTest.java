package BlackJack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class loadFileTest {
	private loadFile lfileTest;
	@Before
	public void setUp() throws Exception {
		lfileTest = new loadFile();
	}

	@Test
	public void test_fPro() {
		lfileTest.fPro();
	}

}
