import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) throws FileNotFoundException {

		//creates scanner to read the file
		Scanner choiceScanner = new Scanner(System.in);
		int input = 0;
		File gradesList = new File("grades.txt");
		Scanner fileScanner = new Scanner(gradesList);

		//creates ArrayList of all grades combined
		ArrayList <Integer> allGrades = new ArrayList <Integer> ();
		while (fileScanner.hasNextLine()){
			int num = Integer.parseInt(fileScanner.nextLine());
			allGrades.add(num);
		}

		//creates first class's grades
		ArrayList <Integer> class1 = new ArrayList <Integer> ();
		for (int i = 0; i < allGrades.size() / 2; i++){
			class1.add(allGrades.get(i));
		}

		//creates second class's grades
		ArrayList <Integer> class2 = new ArrayList <Integer> ();
		for (int i = allGrades.size() / 2; i < allGrades.size(); i++){
			class2. add(allGrades.get(i));
		}

		//creates copies of grades to use for sorting
		ArrayList <Integer> allGradesCopy = Stats.copyArray(allGrades);
		ArrayList <Integer> class1Copy = Stats.copyArray(class1);
		ArrayList <Integer> class2Copy = Stats.copyArray(class2);

		boolean flag = true;
		do{
			//menu
			System.out.println("What would you like to do?");
			System.out.println("1.  Display the grades");
			System.out.println("2.  Display the sorted grades");
			System.out.println("3.  Display the average");
			System.out.println("4.  Display the median");
			System.out.println("5.  Display the mode");
			System.out.println("6.  Display the range");
			System.out.println("7.  Display the standard deviation");
			System.out.println("8.  Quit the program");

			//checks user input
			boolean testInput = true;
			while(testInput){
				try
				{
					input = choiceScanner.nextInt();
					testInput = false;
				}
				catch (InputMismatchException im){
					choiceScanner.next();
					System.out.println("Invalid Input");
				}
			}

			System.out.println();
			switch(input){
			case 1:
				displayGrades(allGrades, 0);
				System.out.println();
				displayGrades(class1, class2, 0);
				System.out.println();
				break;

			case 2:
				displayGrades(Stats.quickSort(allGradesCopy, 0, allGradesCopy.size() - 1), 0);
				System.out.println();
				displayGrades(Stats.quickSort(class1Copy, 0, class1Copy.size() - 1), Stats.quickSort(class2Copy, 0, class2Copy.size() - 1), 0);
				System.out.println();
				break;

			case 3:
				System.out.println("Class 1's average grade is " + Stats.average(class1));
				System.out.println("Class 2's average grade is " + Stats.average(class2));
				System.out.println("The overall average grade is " + Stats.average(allGrades));
				System.out.println();
				break;

			case 4:
				System.out.println("Class 1's median grade is " + Stats.median(class1Copy));
				System.out.println("Class 2's median grade is " + Stats.median(class2Copy));
				System.out.println("The overall median grade is " + Stats.median(allGrades));
				System.out.println();
				break;

			case 5:
				System.out.println("Class 1's mode is " + Stats.mode(class1));
				System.out.println("Class 2's mode is " + Stats.mode(class2));
				System.out.println("The overall mode is " + Stats.mode(allGrades));
				break;

			case 6:
				System.out.println("Class 1's range is " + Stats.range(class1Copy));
				System.out.println("Class 2's range is " + Stats.range(class2Copy));
				System.out.println("The overall range is " + Stats.range(allGrades));
				System.out.println();
				break;

			case 7:
				System.out.println("Class 1's standard deviation is " + Stats.stdDev(class1));
				System.out.println("Class 2's standard deviation is " + Stats.stdDev(class2));
				System.out.println("The overall standard deviation is " + Stats.stdDev(allGrades));
				System.out.println();
				break;

			case 8:
				flag = false;
				break;

			default:
				System.out.println("Invalid Input");
			}
		}while (flag != false);
	}

	/**
	 * Displays two sets of grades in two columns, side by side
	 * @param grades1 first set of grades
	 * @param grades2 second set of grades
	 * @param counter iterator
	 */
	public static void displayGrades(ArrayList <Integer> grades1, ArrayList <Integer> grades2, int counter){
		System.out.println(grades1.get(counter) + "\t" + grades2.get(counter));
		if (counter < grades1.size() - 1){
			displayGrades(grades1, grades2, counter + 1);
		}
	}

	/**
	 * Displays a single set of grade in one column
	 * @param grades set of grades
	 * @param counter iterator
	 */
	public static void displayGrades(ArrayList <Integer> grades, int counter){
		System.out.println(grades.get(counter));
		if (counter < grades.size() - 1){
			displayGrades(grades, counter + 1);
		}
	}
}
