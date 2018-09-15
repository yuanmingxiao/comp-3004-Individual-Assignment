package BlackJack;

public class CheckWinnner {
	public CheckWinnner()
	{
		
	}
	public void checkWin(int playerTotal, int dealerTotal)
	{
		if(dealerTotal > 21)
		{
			System.out.println("Dealer has: " + dealerTotal);
			System.out.println("Dealer busts.  You win!");
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
