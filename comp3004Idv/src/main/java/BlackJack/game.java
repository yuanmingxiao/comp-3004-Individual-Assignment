package BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class game {
	private static Console cMod;
	private static loadFile loadFile;
	private static Scanner console;
	public static void main(String[] arg)
	{
		gameStart();
	}
	
	public static void gameStart()
	{
		console = new Scanner(System.in);
		System.out.println("Console (c) or File (f) model");
		String mod = console.next();
		if(mod.equals("c"))
		{
			cMod = new Console();
			cMod.cpro();	
		}
		else if(mod.equals("f"))
		{
			loadFile = new loadFile();
			loadFile.fPro();
		}	
		else
		{
			System.out.println();
			System.out.println("-----incorrect input-----");
			gameStart();
		}
	}
	
}
