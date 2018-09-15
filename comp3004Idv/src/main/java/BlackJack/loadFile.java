package BlackJack;

import java.io.File;
import java.util.Scanner;

import javax.swing.tree.ExpandVetoException;

public class loadFile {
	private Scanner x;
	public loadFile()
	{
	
	}
	public void openFile()
	{
		Scanner console = new Scanner(System.in);
		System.out.println("type file name you want to load");
		String file = console.next();
		try {
			x = new Scanner(new File(file));
		}
		catch(Exception e) {
			System.out.println("No file found");
		}
	}
	
	public void readFile()
	{
		while(x.hasNext())
		{
			String a = x.next();
			String b = x.next();
			String c = x.next();
			
			System.out.printf("%s,%s,%s",a,b,c );
		}
	}
	
	public void closeFile()
	{
		x.close();
	}
	
	public void fPro()
	{
		openFile();
		readFile();
		
	}
}
