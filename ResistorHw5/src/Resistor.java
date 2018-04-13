import java.util.ArrayList;
import java.util.Random;

/**
 * This class allows a user to create a 4-band resistor object, as well
 * as calculating the minimum and maximum values of the resistor, and 
 * getting the normal resistance, tolerance, and actual resistance.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */

public class Resistor{
	/** Nominal resistance of the band */
	private int nominalResistance;
	/** Tolerance percentage for the band */
	private double tolerance;
	/** Actual, randomly generated value for the resistance */
	private int actualResistance;
	
	/**
	 * Constructs a Resistor object, and sets the actual resistance
	 * value using the nominal resistance and tolerance values
	 * given in the parameters
	 * @param resist nominal resistance
	 * @param tol tolerance
	 */
	public Resistor(int resist, double tol){
		nominalResistance = resist;
		tolerance = tol;
		actualResistance = calculateActualResistance(resist, tol);
	}
	
	/**
	 * Calculates an actual resistance value by using the nominal
	 * resistance and tolerance values
	 * @param resist nominal resistance
	 * @param tol tolerance
	 * @return actual resistance
	 */
	public int calculateActualResistance(int resist, double tol){
		Random rand = new Random();
		int bounds = (int) (resist * tol);
		return rand.nextInt(bounds * 2) + resist - bounds;
	}
	
	/**
	 * Calculates the minimum value for the resistor
	 * @return minimum resistor value
	 */
	public int calculateMinValue(){
		return nominalResistance - (int) (nominalResistance * tolerance);
	}
	
	/**
	 * Calculates the maximum value for the resistor
	 * @return maximum resistor value
	 */
	public int calculateMaxValue(){
		return nominalResistance + (int) (nominalResistance * tolerance);
	}
	
	/**
	 * Returns the nominal resistance value
	 * @return nominal resistance
	 */
	public int getNominalResistance(){
		return nominalResistance;
	}
	
	/**
	 * Returns the tolerance value
	 * @return tolerance
	 */
	public double getTolerance(){
		return tolerance;
	}
	
	/**
	 * Returns the actual resistance value
	 * @return actual resistance
	 */
	public int getActualResistance(){
		return actualResistance;
	}
	
	/**
	 * Converts a digit to its corresponding band color
	 * @param digit digit to be converted to a color
	 * @return color of the band
	 */
	public String convertToColor(int digit){
		String color = "";
		if (digit == 1){
			color = "brown";
		}else if(digit == 2){
			color = "red";
		}else if(digit == 3){
			color = "orange";
		}else if(digit == 4){
			color = "yellow";
		}else if(digit == 5){
			color = "green";
		}else if(digit == 6){
			color = "blue";
		}else if(digit == 7){
			color = "violet";
		}else if(digit == 8){
			color = "gray";
		}else if(digit == 9){
			color = "white";
		}else{
			color = "black";
		}
		return color;
	}
	
	/**
	 * Returns an arrayList containing the colors of each band of the resistor
	 * @return arrayList of colors of each band
	 */
	public ArrayList<String> convertBandColors(){
		ArrayList <String> colors = new ArrayList<String>();
		int length = String.valueOf(nominalResistance).length();
		int tempResistance = nominalResistance;
		
		//Removes least significant digits from the resistance value
		for (int i = 0; i < length - 2; i++){
			tempResistance /= 10;
		}
		
		//Obtains the digit of the second band
		String secondBand = (convertToColor(tempResistance % 10));
		tempResistance /= 10;
		
		//Obtains the first digit, converts to a color, adds to arrayList
		colors.add(convertToColor(tempResistance));
		
		//Adds second and third band colors to the arrayList
		colors.add(secondBand);
		colors.add(convertToColor(length - 2));
		
		//Obtains the color of the fourth band, adds it to arrayList
		if(tolerance == 0.1){
			colors.add("silver");
		} else if(tolerance == 0.05){
			colors.add("gold");
		}
		
		return colors;
	}
	
	@Override
	public String toString(){
		String s = "";
		s += "Nominal resistance:  " + nominalResistance;
		s += "\nActual resistance:  " + actualResistance;
		s += "\nTolerance:  " + tolerance + "\n";
		s += convertBandColors();
		return s;
	}
}
