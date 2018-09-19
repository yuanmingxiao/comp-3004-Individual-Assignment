package BlackJack;

public class checkWinner {
	public checkWinner()
	{
		
	}
	public void checkWin(int playerTotal, int dealerTotal)
	{
		if(dealerTotal > 21)
		{
			System.out.println("You have: " + playerTotal);
			System.out.println("Dealer has: " + dealerTotal);
			System.out.println("Dealer busts.  You win!");
		}
		else if(playerTotal > 21)
		{
			System.out.println("You have: " + playerTotal);
			//System.out.println("Dealer has: " + dealerTotal);
			System.out.println("You busts!");
		}
		else if(playerTotal > dealerTotal)
		{
			System.out.println("You have: " + playerTotal);
			System.out.println("Dealer has: " + dealerTotal);
			System.out.println("You win!");
		}
		else if(playerTotal <= dealerTotal)
		{
			System.out.println("You have: " + playerTotal);
			System.out.println("Dealer has: " + dealerTotal);
			System.out.println("Dealer win!");
		}
	}
}
