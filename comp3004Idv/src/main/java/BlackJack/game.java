package BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

import BlackJack.Option.Options;

public class game {
	private static Console cMod;
	private static loadFile loadFile;
	public static void main(String[] arg)
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Console (c) or File (f) model");
		String mod = console.next();
	
		//boolean play = true;
		
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
	}
	
}
