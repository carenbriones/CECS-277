import java.util.Random;

/**
 * This class constructs, modifies, and obtains the information within a Zip
 * object, which consists of a zip code, and its barcode equivalent.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Zip {
	//Data members
	/** 5 digit value representing the zip code */
	private int zipcode;
	/** String representation of the bar code */
	private String barcode;
	
	/**
	 * Default constructor that creates a zip object with the the default
	 * zipcode of 11111
	 */
	public Zip(){
		zipcode = 11111;
		barcode = convertToBarcode(11111);
	}
	
	/**
	 * Constructor that creates a zip object with the zipcode value in the
	 * parameters
	 * @param zip zipcode of the object
	 */
	public Zip(int zip){
		zipcode = zip;
		barcode = convertToBarcode(zip);
	}
	
	/**
	 * Creates and returns a random five digit zipcode whose first digit is non-zero.
	 * @return random five digit zipcode
	 */
	public int createZipcode(){
		Random randNum = new Random();

		//Ensures that the first number will not be a zero
		int zip = randNum.nextInt(9) + 1;

		//Obtains the other last four digits
		for (int i = 0; i < 4; i++){
			zip = zip * 10 + randNum.nextInt(10);
		}
		
		this.zipcode = zip;
		this.barcode = convertToBarcode(zip);
		
		return zip;
	}
	
	/**
	 * Determines and returns the value of the correction digit of the zipcode
	 * within the parameters
	 * @param zipcode zipcode to obtain the correction digit of
	 * @return correction digit of the zipcode in the parameters
	 */
	public int correctionDigitOf(int zipcode){
		int correct = addDigits(zipcode) % 10;
		correct = 10 - correct;
		if (correct == 10){
			correct = 0;
		}
		return correct;
	}
	
	/**Finds the sum of the digits in the zip code, helper function
	 * to obtain the correction digit
	 * @param num zip code to find the sum of
	 * @return the sum of the digits
	 */
	public static int addDigits(int num){
		//Gets last digit of the value
		int last = num % 10;

		//Gets remaining first digits
		int next = num / 10;

		//Stops the recursion at the last digit
		if (next == 0) {
			return 0;
		}

		//Adds last digit and calls method again
		else{
			return last + addDigits(next);
		}
	}
	
	/**
	 * Returns the barcode associated with a single digit
	 * @param digit to be returned as a barcode
	 * @return barcode version of a digit
	 */
	public String convertBars(int digit){
		String b = "";
		if (digit == 1){
			b = ":::||";
		} else if(digit == 2){
			b = "::|:|";
		} else if(digit == 3){
			b = "::||:";
		} else if(digit == 4){
			b = ":|::|";
		} else if(digit == 5){
			b = ":|:|:";
		} else if(digit == 6){
			b = ":||::";
		} else if(digit == 7){
			b = "|:::|";
		} else if(digit == 8){
			b = "|::|:";
		} else if(digit == 9){
			b = "|:|::";
		} else if(digit == 0){
			b = "||:::";
		}
		return b;
	}
	
	/**
	 * Converts a zipcode to a barcode
	 * @param zip zipcode to be converted
	 * @return barcode version of the zipcode
	 */
	public String convertToBarcode(int zip){

		//Obtains the correction digit
		int correct = correctionDigitOf(zip);

		//Creates zip code including the correction digit
		zip = zip * 10 + correct;

		//Starts from the end of the zip code using the modulus function
		int last;
		String s = "";
		for (int i = 0; i < 6; i++){
			last = zip % 10;
			zip = zip / 10;
			s = convertBars(last) + s;
		}
		
		//Adds in the frame bars
		s = "|" + s + "|";
		setBarcode(s);
		return s;
	}
	
	/**
	 * Displays the bar code associated with the zip code and correction digit
	 * @param digit zipcode to be displayed
	 */
	public void displayBarcode(int digit){
		System.out.println("The barcode is: " + barcode);
	}
	
	/**
	 * Sets the zipcode data member to the value within the parameters
	 * @param zip zipcode of the object
	 */
	public void setZipcode(int zip){
		zipcode = zip;
	}
	
	/**
	 * Sets the barcode data member to the String within the parameters
	 * @param bars barcode of the object
	 */
	public void setBarcode(String bars){
		barcode = bars;
	}
	
	/**
	 * Returns the zipcode data member of the object
	 * @return zipcode data member
	 */
	public int getZipcode(){
		return zipcode;
	}
	
	/**
	 * Returns the barcode data member of the object
	 * @return barcode data member
	 */
	public String getBarcode(){
		return barcode;
	}
	
	@Override
	public String toString(){
		String s = "The zipcode is: " + zipcode + "\n";
		s += "The barcode is: " + barcode + "\n";
		return s;
	}
}
