import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class War {

	public static void main(String[] args) {
		ArrayList <Integer> originalDeck = new ArrayList <Integer> ();
		originalDeck = shuffleDeck(createDeck());

		//adds second half of deck to computer's deck
		ArrayList <Integer> computer = new ArrayList <Integer> ();
		for (int i = 26; i < 52; i++){
			computer.add(originalDeck.get(i));
		}

		//adds first half of deck to player's deck
		ArrayList <Integer> player = new ArrayList <Integer> ();
		player = splitDeck(originalDeck);

		System.out.println("Welcome to WAR!");

		Scanner choiceScanner = new Scanner(System.in);

		double rounds = 0;
		double wins = 0;
		boolean flag = true;
		do{
			//Creates menu for the user
			displayMenu();
			int choice = 0;

			//Tests user input
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
				System.out.println("Please enter \"1\", \"2\", \"3\", \"4\", or \"5\".);");
				choice = choiceScanner.nextInt();
			}
			switch(choice){
			case 1:
				int cards = player.size();
				battle(player, computer);
				rounds++;

				//determines whether player won last round
				if (player.size() > cards){
					wins++;
				}

				//terminates program if no more cards are available
				if (player.size() == 0){
					System.out.println("You have no more cards!");
					System.out.println("Computer wins :-(");
					flag = false;
				}
				else if (computer.size() == 0){
					System.out.println("The computer has no more cards!");
					System.out.println("You win! :-)");
					flag = false;
				}
				break;

			case 2:
				System.out.println("Comp = " + computer.size());
				System.out.println("Player = " + player.size());
				break;

			case 3:
				for (int i = 0; i < sortDeck(player).size(); i++){
					System.out.print(sortDeck(player).get(i) + " ");
				}
				System.out.println();
				break;

			case 4:
				displayStats(calcPercentage(wins, rounds));
				break;

			case 5:
				flag = false;
				break;
			default:
				System.out.println("Input is invalid.");
			}
		}while (flag != false);
	}
	/**
	 * Creates a standard deck of 52 cards in an ArrayList
	 */
	public static ArrayList <Integer> createDeck(){
		ArrayList <Integer> deck = new ArrayList <Integer> (52);
		for (int i = 1; i <= 4; i++){
			for (int j = 1; j <= 13; j++){
				deck.add(j);
			}
		}
		return deck;
	}

	/**
	 * Shuffles a deck by switching the locations (indexes) of multiple
	 * cards in the deck
	 * 
	 * @param deck deck of cards that will be shuffled
	 */
	public static ArrayList <Integer> shuffleDeck(ArrayList <Integer> deck){
		Random randomGenerator = new Random();
		for (int i = 0; i <= 30; i++){
			int index = randomGenerator.nextInt(52);
			int card = deck.get(index);
			deck.remove(index);
			deck.add(randomGenerator.nextInt(52), card);
		}
		return deck;
	}

	/**
	 * Splits a deck of cards into half
	 * 
	 * @param deck deck of cards that will be split in half
	 */
	public static ArrayList <Integer> splitDeck(ArrayList <Integer> deck){
		ArrayList <Integer> playerDeck = new ArrayList <Integer> ();
		for (int i = 0; i <= 25; i++){
			playerDeck.add(deck.get(i));
			deck.remove(i);
		}
		return playerDeck;
	}

	/**
	 * Displays the menu options to the user
	 */
	public static void displayMenu(){
		System.out.println();
		System.out.println("Enter a command:");
		System.out.println("1. Play");
		System.out.println("2. Show Score");
		System.out.println("3. Peek at Cards");
		System.out.println("4. Show Percentage");
		System.out.println("5. Quit");
	}

	/**
	 * Plays a round of cards.  Whichever player has the higher card
	 * on the top of their deck wins their opponent's card and places
	 * it at the bottom of their deck.  If there is a tie, war will
	 * occur.
	 * 
	 * @param player the user's deck of cards
	 * @param computer the computer's deck of cards
	 */
	public static void battle(ArrayList <Integer> player, ArrayList <Integer> computer){
		System.out.println("Computer plays a " + computer.get(0));
		System.out.println("Player plays a " + player.get(0));
		if (computer.get(0) > player.get(0)){
			System.out.println("Computer won a card");
			computer.add(player.get(0));
			player.remove(0);
			//moves top card to end of deck
			computer.add(computer.get(0));
			computer.remove(0);
		}
		else if (computer.get(0) < player.get(0)){
			System.out.println("Player won a card");
			player.add(computer.get(0));
			computer.remove(0);
			//moves top card to end of deck
			player.add(player.get(0));
			player.remove(0);
		}
		else{
			war(player, computer);
		}
	}

	/**
	 * Will be played when both players cards are of the same value.
	 * If both players have enough cards, their fourth card in their deck
	 * will be compared, and whoever has the highest value will win
	 * all of the cards played in the process.
	 * 
	 * @param player the user's deck of cards
	 * @param computer the computer's deck of cards
	 */
	public static void war(ArrayList <Integer> player, ArrayList <Integer> computer){
		if (player.size() > 4 && computer.size() > 4){
			System.out.println("War!");
			System.out.println("1...2...3...");
			System.out.println("Computer plays a " + computer.get(3));
			System.out.println("Player plays a " + player.get(3));
			if (computer.get(3) > player.get(3)){
				System.out.println("Computer won!");
				//adds all cards that were won to computer's deck
				for(int i = 0; i < 4; i++){
					computer.add(computer.get(i));
					computer.add(player.get(i));
				}
				//moves computer's cards to end and removes cards that were lost
				for(int i = 0; i < 4; i++){
					computer.remove(i);
					player.remove(i);
				}
			}
			else if (computer.get(3) < player.get(3)){
				System.out.println("Player won!");
				//adds all cards that were won to player's deck
				for(int i = 0; i < 4; i++){
					player.add(player.get(i));
					player.add(computer.get(i));
				}
				//moves player's cards to end and removes cards that were lost
				for(int i = 0; i < 4; i++){
					player.remove(i);
					computer.remove(i);
				}
			}
			else{
				if(player.size() > 4 && computer.size() > 4)
				war(player, computer);
				else if (player.size() < 4){
					System.out.println();
					System.out.println("Player does not have enough cards!");
					System.out.println("Computer wins :-(");
				}
				else{
					System.out.println();
					System.out.println("Computer does not have enough cards!");
					System.out.println("Player wins!!! :-)");
				}
			}
		}
		else if (player.size() < 4){
			System.out.println();
			System.out.println("Player does not have enough cards!");
			System.out.println("Computer wins :-(");
		}
		else{
			System.out.println();
			System.out.println("Computer does not have enough cards!");
			System.out.println("Player wins!!! :-)");
		}
	}

	/**
	 * Displays the amount of cards in each players' deck
	 * 
	 * @param player1 deck of Player 1
	 * @param player2 deck of Player 2
	 */
	public static void displayScore(ArrayList <Integer> player1, ArrayList <Integer> player2){
		System.out.println("Player 1 has " + player1.size() +"cards.");
		System.out.println("Player 2 has " + player2.size() +"cards.");
	}

	/**
	 * Passes a deck through and rearranges it with its values from
	 * lowest to highest
	 * 
	 * @param deck deck of cards that is passed through
	 * @return the deck that is passed through in increasing order
	 */
	public static ArrayList <Integer> sortDeck(ArrayList<Integer> deck){
		ArrayList <Integer> sortedDeck = new ArrayList<Integer> ();
		sortedDeck = deck;
		for (int i = 0; i < sortedDeck.size(); i++){
			int lowest = i;
			for (int j = i + 1; j < sortedDeck.size(); j++){
				if (sortedDeck.get(j) < sortedDeck.get(lowest)){
					lowest = j;
				}
			}
			int swap = sortedDeck.get(i);
			sortedDeck.set(i, sortedDeck.get(lowest));
			sortedDeck.set(lowest, swap);
		}
		return sortedDeck;
	}

	/**
	 * Prints out the values in a set of cards
	 * 
	 * @param deck deck of cards that will be printed out
	 */
	public static void displayDeck(ArrayList <Integer> deck){
		System.out.println(deck);
	}

	/**
	 * Calculates the percentage of games the player has won
	 * 
	 * @param wins number of rounds the player won
	 * @param rounds number of rounds played
	 * @return
	 */
	public static double calcPercentage(double wins, double rounds){
		double percentage = (wins/rounds) * 100;
		return percentage;
	}

	/**
	 * Displays the percentage of how many games the player won
	 * 
	 * @param percentage percentage of how many games the player won
	 */
	public static void displayStats(double percentage){
		System.out.printf("Win Percentage = %.1f%n", percentage);
	}

	/**
	 * Checks if input from user is valid
	 * 
	 * @return boolean to decide whether input is valid
	 */
	public static boolean checkInput(){
		Scanner inputScanner = new Scanner(System.in);
		boolean testInput = true;
		while(testInput){
			try
			{
				int input = inputScanner.nextInt();
				testInput = false;
			}
			catch (InputMismatchException im){
				inputScanner.next();
				System.out.println("Invalid Input");
			}
		}
		return testInput;
	}
}
