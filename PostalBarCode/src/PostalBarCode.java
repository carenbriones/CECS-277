import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * This class allows a user to translate a bar code into a zip code,
 * or a zip code into a bar code until the user decides to quit.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class PostalBarCode {

	public static void main(String[] args) {

		//Creates scanner to take in user's input
		Scanner choiceScanner = new Scanner(System.in);
		int choice = 0;
		boolean flag = true;
		System.out.println("Welcome! Select an option:  ");

		do{

			// Menu options
			System.out.println("1.  Obtain a zip code");
			System.out.println("2.  Obtain a bar code");
			System.out.println("3.  Quit.");

			// Checks whether the user's input matches is of the desired type
			boolean testInput = true;
			while(testInput){
				try
				{
					choice = choiceScanner.nextInt();
					testInput = false;
				}
				catch (InputMismatchException im){
					choiceScanner.next();
					System.out.println("Invalid Input");
				}
			}

			System.out.println();

			// Checks if the user's input is from the choices 1-3
			while (choice < 1 || choice > 3){
				System.out.println("Please enter \"1\", \"2\", or \"3\".);");
				choice = choiceScanner.nextInt();
			}

			switch(choice){

			case 1:

				//If the user wants to obtain a zip code
				System.out.println("Would you like to:  ");
				System.out.println("1.  Enter a bar code to be translated");
				System.out.println("2.  Get a randomly generated zip code");
				choice = checkInt();

				while (choice < 1 || choice > 2){
					System.out.println("Please enter \"1\" or \"2\".");
					choice = choiceScanner.nextInt();
				}

				if (choice == 1){
					// If the user wants to enter their own bar code
					System.out.println("Enter the bar code you would like to read as a zip code:  ");
					choiceScanner.nextLine();
					String barCode = choiceScanner.nextLine();

					// Obtains a bar code of the correct length
					while(barCode.length() != 32){
						System.out.println("The bar code you have entered is invalid.");
						System.out.println("Please enter a valid bar code:  ");
						barCode = choiceScanner.nextLine();
					}

					printDigit(barCode);
					System.out.println();

				} else{
					//If the user wants to generate a random zip code
					int zip = randZipCode();
					System.out.println("Your randomly generated zip code is: " + zip);
					System.out.print("The bar code is: ");
					printBarCode(zip);
					System.out.println();
				}

				break;

			case 2:

				// If the user wants to generate a bar code
				System.out.println("Would you like to:  ");
				System.out.println("1.  Enter a zip code to be translated");
				System.out.println("2.  Get a randomly generated bar code");
				choice = checkInt();

				while (choice < 1 || choice > 2){
					System.out.println("Please enter \"1\" or \"2\".");
					choice = choiceScanner.nextInt();
				}

				if (choice == 1){
					// If the user wants to translate a zip code into a bar code
					System.out.println("Enter the zip code you would like to read:  ");
					int zipCode = checkInt();

					// Makes sure the zip code is of the desired length
					String zip = Integer.toString(zipCode);
					while(zip.length() != 5){
						System.out.println("The zip code you have entered is invalid.");
						System.out.println("Please enter another zip code:  ");
						zipCode = choiceScanner.nextInt();
						zip = Integer.toString(zipCode);
					}

					printBarCode(zipCode);
					System.out.println();
				} else{
					//If the user wants a randomly generated bar code
					int zip = randZipCode();
					System.out.print("Your randomly generated bar code is: ");
					printBarCode(zip);
					System.out.print("The zip code is: " + zip);
					System.out.println();
				}

				break;

			case 3:
				//If the user decides to quit
				System.out.println("Goodbye.");
				flag = false;
				break;

			default:
				System.out.println("Input is invalid.");
			}
		}while (flag != false);
	}

	/**
	 * Prints out the zip code as a bar code
	 * @param d zip code being printed out
	 */
	public static void printBarCode(int zipCode){

		// Obtains the correction digit
		int correct = addDigits(zipCode) % 10;
		correct = 10 - correct;
		if (correct == 10){
			correct = 0;
		}

		// Creates zip code including the correction digit
		zipCode = zipCode * 10 + correct;

		// Starts from the end of the zip code using the modulus function
		int last;
		String s = "";
		for (int i = 0; i < 6; i++){
			last = zipCode % 10;
			zipCode = zipCode / 10;
			s = convertBars(last) + s;
		}

		// Adds the frame bars to the bar code
		System.out.println("|" + s + "|");
	}

	/**
	 * Prints a bar code as a zip code
	 * @param barCode bar code being converted to a zip code
	 */
	public static void printDigit(String barCode){

		// Gets rid of the unwanted frame bars
		barCode = barCode.substring(1, 32);
		String zip = "";

		Scanner in = new Scanner(System.in);

		//Converts a bar code to its corresponding number value
		for (int i = 0; i <= 5; i++){
			String bars = barCode.substring(0, 5);
			if (bars.equals(":::||")){
				zip = zip + "1";
			} else if(bars.equals("::|:|")){
				zip = zip + "2";
			} else if(bars.equals("::||:")){
				zip = zip + "3";
			} else if(bars.equals(":|::|")){
				zip = zip + "4";
			} else if(bars.equals(":|:|:")){
				zip = zip + "5";
			} else if(bars.equals(":||::")){
				zip = zip + "6";
			} else if(bars.equals("|:::|")){
				zip = zip + "7";
			} else if(bars.equals("|::|:")){
				zip = zip + "8";
			} else if(bars.equals("|:|::")){
				zip = zip + "9";
			} else if(bars.equals("||:::")){
				zip = zip + "0";
			} else{
				// Used to determine whether the bar code is valid
				zip = zip + "     ";
			}
			barCode = barCode.substring(5, barCode.length());
		}

		if (zip.length() > 6){
			// If the bar code is invalid
			System.out.println("The bar code you have entered is invalid.");
			System.out.println("Please enter a valid bar code.");
			printDigit(in.nextLine());
		} else{
			// Prints and gets rid of the check digit
			System.out.println(zip.substring(0, 5));
		}

	}

	/**Finds the sum of the digits in the zip code
	 * @param num zip code to find the sum of
	 * @return the sum of the digits
	 */
	public static int addDigits(int num){
		//gets last digit of the value
		int last = num % 10;

		//gets remaining first digits
		int next = num / 10;

		//stops the recursion at the last digit
		if (next == 0) {
			return 0;
		}

		//adds last digit and calls method again
		else{
			return last + addDigits(next);
		}
	}

	/**
	 * Converts a number into its bar code equivalent
	 * @param d number being converted into a bar code
	 * @return the bar code version of the number
	 */
	public static String convertBars(int d){
		String b = "";

		// Converts a number to its corresponding bar code
		if (d == 1){
			b = ":::||";
		} else if(d == 2){
			b = "::|:|";
		} else if(d == 3){
			b = "::||:";
		} else if(d == 4){
			b = ":|::|";
		} else if(d == 5){
			b = ":|:|:";
		} else if(d == 6){
			b = ":||::";
		} else if(d == 7){
			b = "|:::|";
		} else if(d == 8){
			b = "|::|:";
		} else if(d == 9){
			b = "|:|::";
		} else{
			b = "||:::";
		}

		return b;
	}

	/**
	 * Returns a valid integer value from the input
	 * @return an integer value for the zip code method
	 */
	public static int checkInt(){
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		int validNum = 0;

		while(!valid){
			if(in.hasNextInt()){
				// Ensures that the user's input is an integer
				validNum = in.nextInt();
				valid = true;
			} else{
				// Clear buffer of junk input
				in.next();
				System.out.print("Invalid input- Retry: ");
			}
		}
		return validNum;
	}

	/**
	 * Returns a randomly generated zip code
	 * @return randomly generated zip code
	 */
	public static int randZipCode(){
		Random randNum = new Random();

		// Ensures that the first number will not be a zero
		int zip = randNum.nextInt(9) + 1;

		//Obtains the other last four digits
		for (int i = 0; i < 4; i++){
			zip = zip * 10 + randNum.nextInt(10);
		}

		return zip;
	}
}