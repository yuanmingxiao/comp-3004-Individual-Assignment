package BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class Option {
	//public static final String[] suites = {"Hit", "Stand"};
	protected Options type;
	public Option()
	{
		
	}
	
	public enum Options
	{
		Hit,Stand;
	}
	
	public void opt(ArrayList<Card> cardList, int total, Scanner console)
	{
		System.out.println();
		System.out.println("Players have: " + total); 
		Deck.showHandCards(cardList);
		System.out.println("Do you want to hit(h)/stand(s)?");
		String answer = console.next();
		if(answer.indexOf("h",0) == 0 || answer.indexOf("H",0) == 0)
		{
			type = Options.Hit;
		}
		else if (answer.indexOf("s",0) == 0 || answer.indexOf("S",0) == 0)
		{
			type = Options.Stand;
		}
		else 
		{
			System.out.println();
			opt(cardList,total,console);
		}
	}
	
	public Options getType() {return type;}
	public Options HitType() {return Options.Hit;}
	public Options StandType() {return Options.Stand;}
}
