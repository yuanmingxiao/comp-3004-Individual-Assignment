package BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Card {
	private int value;
	private String name;
	private String suite;
	private boolean Ace;
	
	public Card(String name,String suite)
	{
		this.name = name;
		this.suite = suite;
		this.value = determineCardValue(name);
	}
	
	public Card()
	{
		
	}
	
	public int determineCardValue(String name)
	{
		int value = 0;
		if (name.charAt(0) == 'K' || name.charAt(0) == 'J' || name.charAt(0) == 'Q' || name.equals("10")){
			value = 10;
		} else if (name.charAt(0) =='A'){
			value = 11;
			this.Ace = true;
		} else {
			value = Integer.parseInt(name.substring(0, 1)); 
		}
		return value;
	}	
	public int getCardValue()
	{
		return value;
	}
	
	public boolean isAce()
	{
		return Ace;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getSuites()
	{
		return suite;
	}

	public void setAce21(Card card1)
	{
		card1.Ace = false;
		card1.value = 1;
	}
	
	public void printCard()
	{
		System.out.println(this.name + " of " + this.suite);
	}
	
	public String toString()
	{
		return this.name + " of " + this.suite;
	}
}

