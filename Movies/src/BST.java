/**
 * Class that allows you to create, modify, access data members, and
 * search through a binary search tree that takes in Movie objects.
 * @author Caren Briones <carenpbriones@gmail.com>
 *
 */
public class BST {

	//Data members
	/** Root node of the binary search tree */
	private Node root;

	/**
	 * Constructs a binary search tree with a null root node
	 */
	public BST() {
		root = null;
	}

	/**
	 * Returns whether the binary search tree is empty or not
	 * @return boolean whether the binary search tree is empty or not
	 */
	public boolean isEmpty(){
		return root == null;
	}
	
	public Node getRoot(){
		return root;
	}

	/**
	 * Adds a new node to the tree
	 * @param m Movie of the node to add
	 */
	public void add(Movie m) {
		root = add(m, root);
	}
	/**
	 * Helper function that determines where to add the node to
	 * @param m Movie of the node
	 * @param tree binary search tree
	 * @return the altered tree
	 */
	private Node add(Movie m, Node tree) {
		if(tree == null){
			return new Node(m);
		}else{
			if( tree.getMovie().compareTo(m) < 0){
				tree.setLeft(add(m, tree.getLeft()));
			}else{
				tree.setRight(add(m, tree.getRight()));
			}
			return tree;
		}
	}

	/**
	 * Returns a node with the title equal to the movie in the parameters
	 * if present in the bst, returns null otherwise
	 * @param m Movie being searched for
	 * @return node with equal movie title or null
	 */
	public Node search(Movie m){
		if (root == null){
			System.out.println("No items to search");
			return null;
		} else{
			return search(m, root);
		}
	}
	/**
	 * Helper function that searches for the movie with the equal title,
	 * and prints out "Item not found" if not present in the bst
	 * @param m movie being searched for
	 * @param n node being evaluated
	 * @return null or movie that is found
	 */
	private Node search(Movie m, Node n){
		if (n.getMovie().compareTo(m) == 0){
			return n; 
		}
		if (n.getMovie().compareTo(m) < 0){
			if(n.getLeft() == null){
				System.out.println("Item not found");
				return null;
			} else{
				return search(m, n.getLeft());
			}
		} else{
			if (n.getRight() == null){
				System.out.println("Item not found");
				return null;
			} else{
				return search(m, n.getRight());
			}
		}
	}
	
	/**
	 * Prints out the movies with the same rating as the string
	 * in the parameters, or "No items to search" if the bst is empty
	 * @param s rating being searched for
	 */
	public void searchRating(String s){
		if (root == null){
			System.out.println("No items to search");
		} else{
			searchRating(s, root);
		}
	}
	/**
	 * Helper function that prints out all movies with the same movie
	 * rating as the string in the parameters
	 * @param s rating being searched for
	 * @param n node being evaluated
	 */
	private void searchRating(String s, Node n){
		if(s.equals(n.getMovie().getMovieRating())){
			System.out.println(n.getMovie());
		}
		if(n.getLeft() != null){
			searchRating(s, n.getLeft());
		}
		if(n.getRight() != null){
			searchRating(s, n.getRight());
		}
	}
	
	/**
	 * Prints out the movies in the same decade as the year
	 * in the parameters, or "No items to search" if the bst is empty
	 * @param s decade being searched for
	 */
	public void searchYear(int y){
		if (root == null){
			System.out.println("No items to search");
		} else{
			searchYear(y, root);
		}
	}
	/**
	 * Helper function that prints out all movies in the same decade
	 * as the year in the parameters
	 * @param y decade being searched for
	 * @param n node being evaluated
	 */
	private void searchYear(int y, Node n){
		if(n.getMovie().getYear() >= y && n.getMovie().getYear() < y + 10){
			System.out.println(n.getMovie());
		}
		if(n.getLeft() != null){
			searchYear(y, n.getLeft());
		}
		if(n.getRight() != null){
			searchYear(y, n.getRight());
		}
	}
	
	/**
	 * Prints out the movies with the same star rating as the double
	 * in the parameters, or "No items to search" if the bst is empty
	 * @param s rating being searched for
	 */
	public void searchRating(double s){
		if (root == null){
			System.out.println("No items to search");
		} else{
			searchRating(s, root);
		}
	}
	/**
	 * Helper function that prints out all movies that have the same
	 * star rating as the double in the parameters
	 * @param s rating being searched for
	 * @param n node being evaluated
	 */
	private void searchRating(double s, Node n){
		if(s == n.getMovie().getAudienceRating()){
			System.out.println(n.getMovie());
		}
		if(n.getLeft() != null){
			searchRating(s, n.getLeft());
		}
		if(n.getRight() != null){
			searchRating(s, n.getRight());
		}
	}
	
	/**
	 * Prints out the movies with the same rating as the string
	 * in the parameters, or "No items to search" if the bst is empty
	 * @param s rating being searched for
	 */
	public void searchActor(String s){
		if (root == null){
			System.out.println("No items to search");
		} else{
			searchActor(s, root);
		}
	}
	/**
	 * Helper function that prints out all movies with the same movie
	 * rating as the string in the parameters
	 * @param s rating being searched for
	 * @param n node being evaluated
	 */
	private void searchActor(String s, Node n){
		if(n.getMovie().getActors().remove(s)){
			n.getMovie().addActor(s);
			System.out.println(n.getMovie());
		}
		if(n.getLeft() != null){
			searchActor(s, n.getLeft());
		}
		if(n.getRight() != null){
			searchActor(s, n.getRight());
		}
	}
	
	
	/**
	 * Prints the tree in order
	 */
	public void printBST() {
		if (isEmpty()) {
			System.out.println("No items to print");
		} else {
			printBST(root);
		}
	}
	/**
	 * Helper function that prints the tree out in the correct order
	 * @param n node being printed
	 */
	private void printBST(Node n) {
		//go down left tree
		if (n.getLeft() != null) {
			printBST(n.getLeft());
		}
		//go down right tree
		System.out.print(n.getMovie() + " ");
		System.out.println();
		if (n.getRight() != null) {
			printBST(n.getRight());
		}
	}
	
	/**
	 * Returns the first movie lexicographically by title
	 * @return first movie by title
	 */
	public String findMin(){
		return findMin(root).getMovie().getTitle();
	}
	/**
	 * Helper function that finds the min
	 * @param n node being evaluated
	 * @return the node of the movie that comes first lexicographically
	 */
	private Node findMin(Node n){
		if(n == null){
			return null;
		}else if(n.getLeft() == null){
			return n;
		}
		return findMin(n.getLeft());
	}
	
	/**
	 * Returns the movie that comes last lexicographically
	 * @return last movie by title
	 */
	public String findMax(){
		return findMax(root).getMovie().getTitle();
	}
	/**
	 * Helper function that finds the max
	 * @param n node being evaluated
	 * @return the node of the movie that comes last lexicographically
	 */
	private Node findMax(Node n){
		if(n == null){
			return null;
		}else if(n.getRight() == null){
			return n;
		}
		return findMax(n.getRight());
	}

	/**
	 * Removes a movie from the bst with the same title as the
	 * string in the parameter
	 * @param t title of the movie to be removed
	 */
	public void remove(String t) {
		if (root == null) {
			System.out.println("No items to remove");
		} else {
			root = remove(t, root);
		}
	}
	/**
	 * Helper function that removes the node being removed, or null
	 * if the movie was not found
	 * @param t title of the movie to be removed
	 * @param n node being evaluated
	 * @return the node being removed or null if movie was not found
	 */
	private Node remove(String t, Node n) {
		if(n == null){
			return n;
		} //traverse to node to be removed
		if(n.getMovie().getTitle().compareToIgnoreCase(t) > 0){
			n.setLeft(remove(t, n.getLeft()));
		}else if(n.getMovie().getTitle().compareToIgnoreCase(t) < 0){
			n.setRight(remove(t, n.getRight()));
		} //two children
		else if(n.getLeft() !=null && n.getRight() != null){
			if((int)(Math.random()*2) == 0){
				n.setMovie(findMin(n.getRight()).getMovie());
				n.setRight(remove(n.getMovie().getTitle(), n.getRight()));
			}else{
				n.setMovie(findMax(n.getLeft()).getMovie());
				n.setLeft(remove(n.getMovie().getTitle(), n.getLeft()));
			}
		}else{ //one child
			if(n.getLeft() != null){
				n = n.getLeft();
			}else{
				n = n.getRight();
			}
		}
		return n;
	}
}

