/**
 * Class that creates a die object that can be rolled and the value can be set.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Die 
{
	/** Number of sides on the die */
	private int sides;
	
	/** The value of the die */
	private int dieValue;
	
	/**
	 * Creates a die using the number of sides in the parameter
	 * 
	 * @param s - number of sides on the die
	 */
	public Die( int s )
	{
		sides = s;
		roll();
	}
	
	/**
	 * Simulates rolling a die and obtaining the value
	 * 
	 * @return value of the die
	 */
	public int roll()
	{
		dieValue = (int)(Math.random() * sides) + 1;
		return dieValue;
	}
	
	/**
	 * Gets the value of the die
	 * 
	 * @return value of the die
	 */
	public int getDieValue()
	{
		return dieValue;
	}
	
	/**
	 * Sets the die value to the value inputed into the parameter if the value
	 * is within the bounds of the number of sides.
	 * 
	 * @param value - value to set the die to
	 * @return boolean stating whether or not the value is within bounds
	 */
	public boolean setDieValue( int value )
	{
		if( value > 0 && value <= sides )
		{
			dieValue = value;
			return true;
		}
		else
		{
			return false;
		}
	}
}
