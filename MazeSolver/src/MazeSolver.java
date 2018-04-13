import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MazeSolver {

	public static void main(String[] args) {
		Scanner choiceScanner = new Scanner(System.in);
		int choice = 0;
		boolean flag = true;
		do{
			System.out.println("Choose a level to complete or choose quit: ");
			System.out.println("1.  Maze Level 0");
			System.out.println("2.  Maze Level 1");
			System.out.println("3.  Maze Level 2");
			System.out.println("4.  Maze Level 3");
			System.out.println("5.  Quit");
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

			while (choice < 1 || choice > 5){
				System.out.println("Please enter \"1\", \"2\", \"3\", \"4\", or \"5\".");
				choice = choiceScanner.nextInt();
			}
			switch(choice){
			case 1:
				File file0 = new File("Level0.txt");
				try{
					Scanner fileScan = new Scanner(file0);
					fileScan.nextLine();
					int rows = 5;
					int columns = 5;
					int lineCount = 0;
					char[][] maze = new char[rows][columns];
					while (fileScan.hasNextLine()){
						String line = fileScan.nextLine();
						char[] l = line.toCharArray();
						for (int i = 0; i < columns; i++){
							maze[lineCount][i] = l[i];
						}
						lineCount++;
					}

					Point start = findStart(maze);

					System.out.println("Choose a search method: ");
					System.out.println("1.  Depth First Search");
					System.out.println("2.  Breadth First Search");
					try
					{
						choice = choiceScanner.nextInt();
					}
					catch (InputMismatchException im){
						choiceScanner.next();
						System.out.println("Invalid Input");
					}
					if (choice != 1 && choice != 2){
						System.out.println("Enter \"1\" or \"2\".");
					}else if(choice == 1){
						LinkedStack stack = new LinkedStack();
						stack.push(start);
						printArray(maze, rows, columns);
					}else if(choice == 2){
						LinkedQueue queue = new LinkedQueue();
						queue.add(start);
						evaluate(maze, rows, columns, queue);
						printArray(maze, rows, columns);
					}

					System.out.println();
					fileScan.close();
				} catch (FileNotFoundException fnf){
					System.out.println("File was not found.");
				}


				break;

			case 2:
				File file1 = new File("Level1.txt");
				try{
					Scanner fileScan = new Scanner(file1);
					fileScan.nextLine();
					int rows = 9;
					int columns = 15;
					int lineCount = 0;
					char[][] maze = new char[rows][columns];
					while (fileScan.hasNextLine()){
						String line = fileScan.nextLine();
						char[] l = line.toCharArray();
						for (int i = 0; i < columns; i++){
							maze[lineCount][i] = l[i];
						}
						lineCount++;
					}

					Point start = findStart(maze);

					System.out.println("Choose a search method: ");
					System.out.println("1.  Depth First Search");
					System.out.println("2.  Breadth First Search");
					try
					{
						choice = choiceScanner.nextInt();
					}
					catch (InputMismatchException im){
						choiceScanner.next();
						System.out.println("Invalid Input");
					}
					if (choice != 1 && choice != 2){
						System.out.println("Enter \"1\" or \"2\".");
					}else if(choice == 1){
						LinkedStack stack = new LinkedStack();
						stack.push(start);
						printArray(maze, rows, columns);
					}else if(choice == 2){
						LinkedQueue queue = new LinkedQueue();
						queue.add(start);
						evaluate(maze, rows, columns, queue);
						printArray(maze, rows, columns);
					}
					System.out.println();
					fileScan.close();
				} catch (FileNotFoundException fnf){
					System.out.println("File was not found.");
				}
				break;

			case 3:
				File file2 = new File("Level2.txt");
				try{
					Scanner fileScan = new Scanner(file2);
					fileScan.nextLine();
					int rows = 11;
					int columns = 21;
					int lineCount = 0;
					char[][] maze = new char[rows][columns];
					while (fileScan.hasNextLine()){
						String line = fileScan.nextLine();
						char[] l = line.toCharArray();
						for (int i = 0; i < columns; i++){
							maze[lineCount][i] = l[i];
						}
						lineCount++;
					}

					Point start = findStart(maze);

					System.out.println("Choose a search method: ");
					System.out.println("1.  Depth First Search");
					System.out.println("2.  Breadth First Search");
					try
					{
						choice = choiceScanner.nextInt();
					}
					catch (InputMismatchException im){
						choiceScanner.next();
						System.out.println("Invalid Input");
					}
					if (choice != 1 && choice != 2){
						System.out.println("Enter \"1\" or \"2\".");
					}else if(choice == 1){
						LinkedStack stack = new LinkedStack();
						stack.push(start);
						printArray(maze, rows, columns);
					}else if(choice == 2){
						LinkedQueue queue = new LinkedQueue();
						queue.add(start);
						evaluate(maze, rows, columns, queue);
						printArray(maze, rows, columns);
					}
					System.out.println();
					fileScan.close();
				} catch (FileNotFoundException fnf){
					System.out.println("File was not found.");
				}

				break;
			case 4:
				File file3 = new File("Level3.txt");
				try{
					Scanner fileScan = new Scanner(file3);
					fileScan.nextLine();
					int rows = 41;
					int columns = 81;
					int lineCount = 0;
					char[][] maze = new char[rows][columns];
					while (fileScan.hasNextLine()){
						String line = fileScan.nextLine();
						char[] l = line.toCharArray();
						for (int i = 0; i < columns; i++){
							maze[lineCount][i] = l[i];
						}
						lineCount++;
					}

					Point start = findStart(maze);

					System.out.println("Choose a search method: ");
					System.out.println("1.  Depth First Search");
					System.out.println("2.  Breadth First Search");
					try
					{
						choice = choiceScanner.nextInt();
					}
					catch (InputMismatchException im){
						choiceScanner.next();
						System.out.println("Invalid Input");
					}
					if (choice != 1 && choice != 2){
						System.out.println("Enter \"1\" or \"2\".");
					}else if(choice == 1){
						LinkedStack stack = new LinkedStack();
						stack.push(start);
						printArray(maze, rows, columns);
					}else if(choice == 2){
						LinkedQueue queue = new LinkedQueue();
						queue.add(start);
						evaluate(maze, rows, columns, queue);
						printArray(maze, rows, columns);
					}
					System.out.println();
					fileScan.close();
				} catch (FileNotFoundException fnf){
					System.out.println("File was not found.");
				}

				break;
			case 5:
				flag = false;
				break;

			}
		}while (flag != false);
	}

	/**
	 * Prints a 2D array of characters
	 * @param array array to print
	 * @param rows number of rows in the array
	 * @param columns number of columns in the array
	 */
	public static void printArray(char[][] array, int rows, int columns){
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < columns; j++){ 
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Locates the start of the maze and returns the starting position as a Point object
	 * @param array array of characters that represents the maze
	 * @param rows number of rows in the maze
	 * @param columns number of columns in the array
	 * @return the starting point of the maze
	 */
	public static Point findStart(char[][] array){
		Point start = null;
		for (int i = 0; i < array.length; i++){
			for (int j = 0; j < array[i].length; j++){
				if (array[i][j] == 's'){
					start = new Point(j, i);
				}
			}
		}
		return start;
	}

	/**
	 * Removes the first point off of a LinkedQueue and determines whether it is
	 * an empty space or not.  If it is, it will be changed to a '.' and the spaces
	 * next to it will be checked for an empty space as well.  If the neighboring space
	 * is empty, it will be added to the stack and the method will continue to call
	 * itself until there are no more points in the queue
	 * @param array maze being evaluated
	 * @param rows number of rows
	 * @param columns number of columns
	 * @param queue queue of empty points
	 */
	public static void evaluate(char[][] array, int rows, int columns, LinkedQueue queue){
		Point p = queue.remove().getLocation();
		int y = (int) p.getY();
		int x = (int) p.getX();
		if (array[y][x] != 's' && array[y][x] != 'f'){
			array[y][x] = '.';
		}
		do{
			if (x > 0){
				if (array[y][x - 1] == ' '){
					Point a = new Point(x - 1, y);
					queue.add(a);
				}
			}
			if (x < columns - 1){
				if (array[y][x + 1] == ' '){
					Point b = new Point(x + 1, y);
					queue.add(b);
				}
			}
			if (y > 0){
				if (array[y - 1][x] == ' '){
					Point c = new Point(x, y - 1);
					queue.add(c);
				}
			}
			if (y < rows - 1){
				if (array[y + 1][x] == ' '){
					Point d = new Point(x, y + 1);
					queue.add(d);
				}
			}
			if (queue.size() > 0){
				evaluate(array, rows, columns, queue);
			}
		}while (array[y][x] != 'f' && queue.size() > 0);
	}
}
