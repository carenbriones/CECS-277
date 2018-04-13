import java.util.Scanner;

/**
 * This class allows a user to translate/obtain zipcodes or barcodes by
 * inputting their own information or choosing to obtain a randomized
 * barcode/zipcode.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Menu {

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
			choice = checkInt();
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
				System.out.println("3.  Extract a single number from a zip code");
				choice = checkInt();

				while (choice < 1 || choice > 3){
					System.out.println("Please enter \"1\", \"2\", or \"3\".");
					choice = choiceScanner.nextInt();
				}

				if (choice == 1){
					//If the user wants to enter their own bar code
					System.out.println("Enter the bar code you would like to read as a zip code:  ");
					String barCode = choiceScanner.nextLine();

					//Obtains a bar code of the correct length
					while(barCode.length() != 32){
						System.out.println("The bar code you have entered is invalid.");
						System.out.println("Please enter a valid bar code:  ");
						barCode = choiceScanner.nextLine();
					}

					System.out.println("The zip code is:  " + convertToZipcode(barCode));
					System.out.println();

				} else if(choice == 2){
					//If the user wants to generate a random zip code
					Zip randZip = new Zip();
					randZip.createZipcode();
					randZip.convertToBarcode(randZip.getZipcode());
					System.out.println(randZip);
					System.out.println();
				} else{
					//If the user wants to extract a number from a zip code
					System.out.println("Enter the zip code you would like to extract from: ");
					int zipExtract = checkInt();

					//Makes sure the zip code is of the desired length
					String zip = Integer.toString(zipExtract);
					while(zip.length() != 5){
						System.out.println("The zip code you have entered is invalid.");
						System.out.println("Please enter another zip code:  ");
						zipExtract = choiceScanner.nextInt();
						zip = Integer.toString(zipExtract);
					}
					
					System.out.println("Enter the location of the number you would like to extract: ");
					int location = checkInt();
					
					// Makes sure the location is not out of bounds
					while(location > 5 || location < 1){
						System.out.println("The location you have entered is invalid.");
						System.out.println("Please enter a value from 1-5:  ");
						location = checkInt();
					}
					System.out.println("The number you wanted to extract is: " + extract(zipExtract, location));
				}
				break;

			case 2:

				// If the user wants to generate a bar code
				System.out.println("Would you like to:  ");
				System.out.println("1.  Enter a zip code to be translated");
				System.out.println("2.  Enter a single number to be translated");
				System.out.println("3.  Get a randomly generated bar code");
				choice = checkInt();

				while (choice < 1 || choice > 3){
					System.out.println("Please enter \"1\", \"2\", or \"3\".");
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
					
					Zip zip2 = new Zip(zipCode);
					
					System.out.println("The barcode is:  " + zip2.convertToBarcode(zipCode));
					System.out.println();
				}else if(choice == 2){
					//To display a barcode for a single digit
					System.out.println("Enter the digit you would like to see the barcode for: ");
					int digit = checkInt();
					
					while(digit > 9 || digit < 0){
						System.out.println("Invalid entry; please enter a number from 0-9:  ");
						digit = checkInt();
					}
					
					displayCode(digit);
				}
				else{
					//If the user wants a randomly generated bar code
					Zip zip3 = new Zip();
					zip3.createZipcode();
					zip3.displayBarcode(zip3.getZipcode());
					System.out.println("The zipcode is: " + zip3.getZipcode());
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
				System.out.print("Invalid input.  Please enter an integer: ");
			}
		}
		return validNum;
	}
	
	/**
	 * Obtains a single digit of a zipcode at a given location
	 * @param zip zipcode the digit will be taken from
	 * @param location location of the digit desired
	 * @return individual digit within the zipcode at the indicated location
	 */
	public static int extract(int zip, int location){
		int digit = 0;
		for (int i = 0; i < 6 - location; i++){
			digit = zip % 10;
			zip = zip / 10;
		}
		return digit;
	}
	
	/**
	 * Converts a barcode to a zipcode
	 * @param bars barcode to be converted
	 * @return zipcode equivalent of the barcode
	 */
	public static int convertToZipcode(String bars){
		// Gets rid of the unwanted frame bars
		bars = bars.substring(1, 32);
		int zip = 0;

		//Converts a bar code to its corresponding number value
		for (int i = 0; i <= 4; i++){
			String bar = bars.substring(0, 5);
			zip *= 10;
			if (bar.equals(":::||")){
				zip += 1;
			} else if(bar.equals("::|:|")){
				zip += 2;
			} else if(bar.equals("::||:")){
				zip += 3;
			} else if(bar.equals(":|::|")){
				zip += 4;
			} else if(bar.equals(":|:|:")){
				zip += 5;
			} else if(bar.equals(":||::")){
				zip += 6;
			} else if(bar.equals("|:::|")){
				zip += 7;
			} else if(bar.equals("|::|:")){
				zip += 8;
			} else if(bar.equals("|:|::")){
				zip += 9;
			} else if(bar.equals("||:::")){
				zip += 0;
			} else{
				// Used to determine whether the bar code is valid
				zip *= 0;
			}
			bars = bars.substring(5, bars.length());
		}
		return zip;
	}
	
	/**
	 * Prints out the bar code associated with a single digit
	 * @param digit digit to be displayed as a barcode
	 */
	public static void displayCode(int digit){
		String b;
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
		} else {
			b = "||:::";
		}
		System.out.println("The bar code associated with this digit is: " + b);
		System.out.println();
	}
}

