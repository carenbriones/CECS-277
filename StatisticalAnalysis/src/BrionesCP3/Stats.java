import java.util.ArrayList;

/**
 * Calculates different values for an ArrayList of grades, such as the range, median, mode,
 * and standard deviation.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */

public class Stats{
	/**
	 * Returns the sum of all of the grades
	 * @param grades ArrayList that contains a list of grades
	 * @return sum of all of the grades
	 */
	public static int sum(ArrayList <Integer> grades, int i){
		if (i == grades.size()){
			return 0;
		}
		else {
			return grades.get(i) + sum(grades, i + 1);
		}
	}

	/**
	 * Calculates the average of a list of grades
	 * @param grades ArrayList that contains the grades
	 * @return average grade
	 */
	public static int average(ArrayList <Integer> grades){
		int avg = sum(grades, 0) / grades.size();
		return avg;
	}

	/**
	 * Uses a value in the ArrayList and creates a partition by placing all of the
	 * smaller values to the left of the selected values, and places all of the larger
	 * values to the right of the selected values
	 * @param values ArrayList to be sorted
	 * @param left initial value used to serve as the partition point
	 * @param right number to be moved to the correct side of the partition point
	 * @return partition value
	 */
	public static int partition(ArrayList<Integer> values, int left, int right){
		int pivot = values.get(left);
		while (left <= right){
			while (values.get(left) < pivot)
				left++;
			while (values.get(right) > pivot)
				right--;
			if (left <= right){
				int temp = values.get(right);
				values.set(right, values.get(left));
				values.set(left, temp);
				left++;
				right--;
			}
		}
		return left;
	}

	/**
	 * Works with the partition method to completely sort an ArrayList from
	 * smallest to largest values
	 * @param values ArrayList to be sorted
	 * @param start starting index
	 * @param end ending index
	 */
	public static ArrayList <Integer> quickSort(ArrayList <Integer> values, int start, int end){
		if(start < end){
			int pivot = partition(values, start, end);
			if(start < pivot - 1)
				quickSort(values, start, pivot - 1);
			if(end > pivot)
				quickSort(values, pivot, end);
		}
		return values;
	}

	/**
	 * Obtains the median of a list of grades
	 * @param grades ArrayList of grades
	 * @return median number of all grades
	 */
	public static int median(ArrayList <Integer> grades){
		int size = grades.size();
		if (grades.size() % 2 == 0){
			int med = (quickSort(grades, 0, grades.size() - 1).get((size / 2) - 1) + (quickSort(grades, 0, grades.size() - 1).get(size / 2))) / 2;
			return med;
		} else{
			int med = quickSort(grades, 0, grades.size() - 1).get(size / 2);
			return med;
		}
	}

	/**
	 * Returns an ArrayList of the numbers of times each grade occurs in the class
	 * @param values ArrayList of grades
	 * @return ArrayList of occurrences of each grade
	 */
	public static ArrayList <Integer> occurrences(ArrayList <Integer> values){
		ArrayList <Integer> numbers = new ArrayList <Integer> ();
		for (int i = 0; i < 101; i++){
			numbers.add(0);
		}
		for (int i = 0; i < values.size(); i++){
			numbers.set(values.get(i), numbers.get(values.get(i)) + 1);
		}
		return numbers;
	}

	/**
	 * Returns the mode of each class
	 * @param values ArrayList of grades
	 * @param i iterator
	 * @param max highest number of occurrences
	 * @return the mode of the class
	 */
	public static ArrayList <Integer> mode(ArrayList <Integer> values){
		int max = 0;
		ArrayList <Integer> modes = new ArrayList <Integer> ();
		for (int i = 0; i <= occurrences(values).size() - 1; i++){
			if (occurrences(values).get(i) > max){
				max = occurrences(values).get(i);
			}
		}
		for (int j = 0; j <= occurrences(values).size() - 1; j++){
			if (occurrences(values).get(j) == max){
				modes.add(j);
			}
		}
		return modes;
	}

	/**
	 * Calculates the range of grades in an ArrayList
	 * @param values ArrayList of grades
	 * @return range of the grades
	 */
	public static int range(ArrayList <Integer> grades){
		quickSort(grades, 0, grades.size() - 1);
		return (grades.get(grades.size() - 1)) - grades.get(0);
	}

	/**
	 * Calculates the sum of the squares of the differences between each grade and the
	 * average as a helper function to calculate the standard deviation
	 * @param grades the ArrayList of grades
	 * @param i iterator
	 * @return the sum of the squares of the differences between each grade and the average
	 */
	private static int squareSum(ArrayList<Integer> grades, int i) {
		if (i < grades.size()) {
			return (int) Math.pow((grades.get(i) - average(grades)), 2) + squareSum(grades, i + 1);
		}
		return 0;
	}

	/**
	 * Calculates the standard deviation of an ArrayList of grades
	 * @param grades ArrayList that will be used to calculate standard deviation
	 * @return standard deviation
	 */
	public static int stdDev(ArrayList<Integer> grades) {
		return (int) Math.sqrt(squareSum(grades, 0) / (grades.size() - 1));
	}

	/**
	 * Returns a copy of the original ArrayList to use for sorting methods
	 * @param grades original ArrayList
	 * @return copy of the ArrayList
	 */
	public static ArrayList <Integer> copyArray(ArrayList<Integer> grades){
		ArrayList <Integer> copy = new ArrayList <Integer> ();
		for (int i = 0; i < grades.size(); i++){
			copy.add(grades.get(i));
		}
		return copy;
	}
}