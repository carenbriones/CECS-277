/**
 * Program that simulates a dice game where two players will roll a die, and
 * whichever player gets the higher value will win.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class DiceGame 
{
	public static void main ( String[] args )
	{
		//Constant for a 6-sided die
		final int MAX_SIDES = 6;
		
		//Creates two dice with 6 sides
		Die dice1 = new Die( MAX_SIDES );
		Die dice2 = new Die( MAX_SIDES );
		
		//Rolls both dice and stores value into a variable
		int d1 = dice1.roll();
		int d2 = dice2.roll();
		
		//Changes dice2 value to 6 every time to win each game
		cheat(dice2, 6);
		d2 = dice2.getDieValue();
		
		//Prints out the value of the dice 
		System.out.println( "Die1 = " + d1 );
		System.out.println( "Die2 = " + d2 );
		
		//Determines and displays which player wins
		if( dice1.getDieValue() > dice2.getDieValue() )
		{
			System.out.println("Player 1 Wins");
		}
		else if( dice2.getDieValue() > dice1.getDieValue())
		{
			System.out.println("Player 2 Wins");
		}
		else
		{
			System.out.println("Tied");
		}
	}
	/**
	 * Changes the value of a specified die to win the game
	 * 
	 * @param cheaterDie die that will change values
	 * @param value designated value to change the die to
	 */
	public static void cheat(Die cheaterDie, int value)
	{
		cheaterDie.setDieValue(value);
	}
}
