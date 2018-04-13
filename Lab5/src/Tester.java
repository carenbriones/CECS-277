import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the size of the table: ");
		int n = input.nextInt();
		
		if (n < 1){
			System.out.println("Please enter a number greater than 0");
		}
		
		System.out.println("Enter the number of items in the hash table");
		int m = input.nextInt();
		
		if (m > 100 || m < 1){
			System.out.println("Please enter a number from 1-100");
		}
		
		System.out.println();
		
		ArrayList <Integer> numbers = new ArrayList<Integer> ();
		for (int i = 1; i <= 100; i++){
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		//Gets the wanted number of items
		for (int i = 99; i >= m; i--){
			numbers.remove(i);
		}
		
		ArrayList <Node> hashTable = new ArrayList <Node>(n);
		
		for (int i = 0; i < n; i++){
			hashTable.add(null);
		}
		
		for (int i = 0; i < m; i++){
			int value = numbers.get(i);
			int index = value % n;
			if (hashTable.get(index) == null){
				hashTable.add(index, new Node(value));
			} 
			else{
				Node current = hashTable.get(index);
				Node previous = current;
				while (current != null){
					previous = current;
					current = current.getNext();
				}
				previous.setNext(new Node(value, null));
			}
		}
		
		printTable(hashTable);
		System.out.println();
		
		double average = 0.0;
		double counter = 0.0;
		for (int i = 0; i < n; i++){
			if (getLength(hashTable.get(i)) != 0){
				average += getLength(hashTable.get(i));
				counter++;
			}
		}
		average = average / counter;
		System.out.println("The average size of the chain cells is " + average);
		double loadFactor = (double) m / n;
		System.out.println("The load factor is " + loadFactor);
	}
	
	public static void printTable(ArrayList <Node> table){
		for (int i = 0; i < table.size(); i++){
			if(table.get(i) == null){
				System.out.println("null");
			} else{
				Node current = table.get(i);
				while (current.getNext() != null){
					System.out.print(current + " ");
					current = current.getNext();
				}
				System.out.print(current);
				System.out.println();
			}
		}
	}
	
	
	public static int getLength(Node n){
		int length = 0;
		if (n == null){
			return length;
		} else{
			length++;
			while (n.getNext() != null){
				n = n.getNext();
				length++;
			}
			return length;
		}
	}
	
	public static void search(int value, int size, ArrayList <Node> table){
		int index = value / size;
		if (table.get(index) != null){
			while (table.get(index) )
		} else{
			System.out.println("The value was not found.");
		}
	}
}

