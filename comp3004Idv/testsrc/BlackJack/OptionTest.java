package BlackJack;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class OptionTest {
	private Option optest;
	private Scanner console;
	private int total;
	@Before
	public void setUp() throws Exception {
		 optest = new Option();
		 console = new Scanner(System.in);
	}

	@Test
	public void test_opt() {
		total = 0;
		ArrayList<Card> cardList = new ArrayList<Card>();
		optest.opt( cardList, total,console);
	}

}
