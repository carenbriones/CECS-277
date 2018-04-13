import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that allows a user to add or delete a movie, add or delete
 * an actor from a movie, display movies in sorted order by title,
 * find movie(s) by title, rating, decade, stars, and actors, and
 * write the movies back to a file.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */

public class MovieDatabase {

	public static void main(String[] args) {

		File file = new File("movies.txt");
		BST tree = new BST();
		ArrayList <Movie> movies = new ArrayList <Movie>();
		try{
			Scanner fileScan = new Scanner(file);
			while (fileScan.hasNextLine()){
				String line = fileScan.nextLine();
				String [] parts = new String [6];
				parts = line.split("/");
				String title = parts[0];
				int year = Integer.parseInt(parts[1]);
				String rating = parts[2];
				int length = Integer.parseInt(parts[3]);
				double audRating = Double.parseDouble(parts[4]);
				ArrayList <String> actors = new ArrayList <String> ();
				if (parts.length > 5){
					String [] act = parts[5].split(",");
					for (int i = 0; i < act.length; i++){
						actors.add(act[i]);
					}
				} 
				Movie mov = new Movie(title, year, rating, length, audRating, actors);
				movies.add(mov);
			}
			while(movies.size() > 0){
				int index = (int)(Math.random() * movies.size());
				tree.add(movies.remove(index));
			}
			fileScan.close();
		} catch (FileNotFoundException fnf){
			System.out.println("File was not found.");
		}
		Scanner input = new Scanner(System.in);
		int choice = 0;
		boolean flag = true;
		do{
			System.out.println("1.  Add a new movie");
			System.out.println("2.  Delete a movie");
			System.out.println("3.  Add an actor to a movie");
			System.out.println("4.  Delete an actor from a movie");
			System.out.println("5.  Display all movies in sorted order by title");
			System.out.println("6.  Find movie(s)");
			System.out.println("7.  Quit.");

			choice = checkInt(1, 7);

			switch(choice){
			case 1:
				tree.add(getMovie());
				System.out.println("The movie has been added to the tree.");
				break;
			case 2:
				System.out.println("Enter the name of the movie you would like to delete: ");
				Movie moo = new Movie(input.nextLine());
				if (tree.search(moo) == null){
					System.out.println("The movie you tried to delete does not exist in this list.");
				} else{
					tree.remove(moo.getTitle());
					System.out.println("The movie has been deleted.");
				}
				break;
			case 3:
				System.out.println("Enter the name of the movie you want to add an actor to: ");
				Movie mov = new Movie(input.nextLine());
				if (tree.search(mov) == null){
					System.out.println("The movie you are trying to access does not exist in this list.");
				} else{
					System.out.println("Enter the name of the actor you would like to add: ");
					String ac = input.nextLine();
					tree.search(mov).getMovie().addActor(ac);
					System.out.println("The actor has been added to the movie.");
				}
				break;
			case 4:
				System.out.println("Enter the name of the movie you want to delete an actor from: ");
				Movie mo = new Movie(input.nextLine());
				if (tree.search(mo) == null){
					System.out.println("The movie you are trying to access does not exist in this list.");
				} else{
					System.out.println("Enter the name of the actor you would like to remove: ");
					String ac = input.nextLine();
					tree.search(mo).getMovie().deleteActor(ac);
				}
				break;
			case 5:
				tree.printBST();
				System.out.println();
				break;
			case 6:
				System.out.println("How would you like to find your movie?");
				System.out.println("1.  By title");
				System.out.println("2.  By rating");
				System.out.println("3.  By decade");
				System.out.println("4.  By stars");
				System.out.println("5.  By actor");
				int find = checkInt(1, 5);
				if (find == 1){
					System.out.println("Enter the title of the movie you are searching for: ");
					Movie move = new Movie(input.nextLine());
					Node n = tree.search(move);
					System.out.println();
					if(n != null){
						System.out.println(n.getMovie());
						System.out.println();
					}
				} else if(find == 2){
					System.out.println("Enter the rating type you are searching for: ");
					String rate = input.nextLine();
					tree.searchRating(rate);
					System.out.println();
				} else if(find == 3){
					System.out.println("Enter the decade of the movies you are searching for: ");
					int decade = checkInt(1, 2015);
					if (decade % 10 != 0){
						decade = decade - (decade % 10);
					}
					tree.searchYear(decade);
					System.out.println();
				} else if(find == 4){
					System.out.println("Enter the number of stars of the movies you are searching for: ");
					double stars = checkDouble(1, 10);
					tree.searchRating(stars);
					System.out.println();
				} else{
					System.out.println("Enter the actor of the movie(s) you are searching for: ");
					String actor = input.nextLine();
					tree.searchActor(actor);
					System.out.println();
				}
				break;
			case 7:
				try {
					PrintWriter writer = new PrintWriter("movies.txt");
					while(!tree.isEmpty()){
						Movie min = new Movie(tree.findMin());
						Movie q = tree.search(min).getMovie();
						String f = q.getTitle() + "/" + q.getYear() + "/" + q.getMovieRating() + "/"
								+ q.getLength() + "/" + q.getAudienceRating() + "/" + q.printActors();
						writer.println(f);
						tree.remove(tree.findMin());
					}
					writer.close();
				}catch(FileNotFoundException fnf){
					System.out.println("File was not found");
				}
				flag = false;
				break;
			}

		}while (flag != false);
	}

	/**
	 * Checks the user's input and ensures that it is the correct
	 * data type and is within the correct bounds
	 * @param low lower bounds of the integer
	 * @param high upper bounds of the integer
	 * @return the integer entered by the user
	 */
	public static int checkInt(int low, int high){
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		int validNum = 0;

		while(!valid){
			if(in.hasNextInt()){
				validNum = in.nextInt();
				if(validNum >= low && validNum <= high){
					valid = true;
				} else{
					System.out.print("The number has to be between " + low + " and " + high + " Retry: ");
				}
			} else{
				//clear buffer of junk input
				in.next();
				System.out.print("Invalid input- Retry: ");
			}
		}
		return validNum;
	}

	/**
	 * Checks the user's input and ensures that it is an input
	 * @return the integer entered by the user
	 */
	public static int checkInt(){
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		int validNum = 0;

		while(!valid){
			if(in.hasNextInt()){
				validNum = in.nextInt();
				valid = true;
			} else{
				//clear buffer of junk input
				in.next();
				System.out.print("Invalid input- Retry: ");
			}
		}
		return validNum;
	}

	/**
	 * Checks the user's input and ensures that it is a double within
	 * the correct bounds
	 * @param low lower bounds of the double
	 * @param high upper bounds of the double
	 * @return the double entered by the user
	 */
	public static double checkDouble(double low, double high){
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		double validNum = 0;

		while (!valid){
			if(in.hasNextDouble()){
				validNum = in.nextDouble();
				if(validNum >= low && validNum <= high){
					valid = true;
				} else{
					System.out.print("The number has to be between " + low + " and " + high + " Retry: ");
				}
			} else{
				//clear buffer of junk input
				in.next();
				System.out.print("Invalid input- Retry.");
			}
		}
		return validNum;
	}

	/**
	 * Checks the user's input and ensures that it is a double
	 * @return the double entered by the user
	 */
	public static double checkDouble(){
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		double validNum = 0;

		while(!valid){
			if(in.hasNextDouble()){
				validNum = in.nextDouble();
				valid = true;
			} else{
				//clear buffer of junk input
				in.next();
				System.out.print("Invalid input- Retry:");
			}
		}
		return validNum;
	}

	/**
	 * Returns a movie object as long as a title is entered,
	 * regardless of whether any other information is entered or not
	 * @return movie object
	 */
	public static Movie getMovie(){
		Scanner in = new Scanner(System.in);
		System.out.println("What is the movie title?");
		String t = in.nextLine();

		System.out.println("Do you know the release year of the movie? Enter 'Y' or 'N');");
		boolean valid = true;
		int year = 0;
		do{
			String choice1 = in.nextLine();
			if(choice1.compareToIgnoreCase("N") == 0){
				valid = false;
			} else if(choice1.compareToIgnoreCase("Y") == 0){
				System.out.println("What year was the movie released?");
				year = checkInt(1, 2015);
				valid = false;
			} else{
				System.out.println("Please enter Y or N.");
			}
		} while(valid);

		System.out.println("Do you know the movie rating of the movie? Enter 'Y' or 'N');");
		valid = true;
		String movRating = "";
		do{
			String choice1 = in.nextLine();
			if(choice1.compareToIgnoreCase("N") == 0){
				valid = false;
			} else if(choice1.compareToIgnoreCase("Y") == 0){
				System.out.println("What is the movie rating of the movie?");
				movRating = in.nextLine();
				valid = false;
			} else{
				System.out.println("Please enter Y or N.");
			}
		} while(valid);

		System.out.println("Do you know the length of the movie? Enter 'Y' or 'N');");
		valid = true;
		int length = 0;
		do{
			String choice1 = in.nextLine();
			if(choice1.compareToIgnoreCase("N") == 0){
				valid = false;
			} else if(choice1.compareToIgnoreCase("Y") == 0){
				System.out.println("What year was the movie released?");
				length = checkInt();
				valid = false;
			} else{
				System.out.println("Please enter Y or N.");
			}
		} while(valid);

		System.out.println("Do you know the audience rating of the movie? Enter 'Y' or 'N');");
		valid = true;
		int audRating = 0;
		do{
			String choice1 = in.nextLine();
			if(choice1.compareToIgnoreCase("N") == 0){
				valid = false;
			} else if(choice1.compareToIgnoreCase("Y") == 0){
				System.out.println("What year was the movie released?");
				audRating = checkInt(1, 10);
				valid = false;
			} else{
				System.out.println("Please enter Y or N.");
			}
		} while(valid);

		System.out.println("Would you like to add any actors? Enter 'Y' or 'N'");
		valid = true;
		ArrayList<String> actors = new ArrayList <String>();
		do{
			String choice1 = in.nextLine();
			if(choice1.compareToIgnoreCase("N") == 0){
				valid = false;
			} else if(choice1.compareToIgnoreCase("Y") == 0){
				System.out.println("How many actors are you going to add?");
				int num = checkInt();
				for(int i = 0; i < num; i++){
					System.out.println("What is the name of actor?");
					String name = in.nextLine();
					actors.add(name);
				}
				valid = false;
			} else{
				System.out.println("Please enter Y or N.");
			}
		} while(valid);
		
		Movie mov = new Movie(t, year, movRating, length, audRating, actors );
		return mov;
	}
}

