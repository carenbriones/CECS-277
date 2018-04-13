/**
 * Class that creates, accesses, and modifies information in a node,
 * which consists of a Movie object and the node after it.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */

public class Node {

	//data members
	/** String stored in the Node */
	private Movie m;
	/** Node object to the left */
	private Node left;
	/** Node object to the right */
	private Node right;
	
	/**
	 * Constructs a Node with the word object in the parameters
	 * and a null left and right node
	 * @param wo Word object to set the Node's data member to
	 */
	public Node(Movie mo){
		m = mo;
		left = null;
		right = null;
	}
	
	/**
	 * Changes the Movie data member of a node to the Movie object
	 * in the parameters
	 * @param mo Movie object to be changed to
	 */
	public void setMovie(Movie mo){
		m = mo;
	}
	
	/**
	 * Returns the Word object inside of a node
	 * @return
	 */
	public Movie getMovie(){
		return m;
	}
	
	/**
	 * Changes the value of the node to the left of this node
	 * @param l Node value the left node will be set to
	 */
	public void setLeft(Node l){
		left = l;
	}
	
	/**
	 * Returns the Node value to the left of this node
	 * @return Node value to the left of this node
	 */
	public Node getLeft(){
		return left;
	}
	
	/**
	 * Changes the value of the node to the right of this node
	 * @param r Node value the right node will be set to
	 */
	public void setRight(Node r){
		right = r;
	}
	
	/**
	 * Returns the Node value to the right of this node
	 * @return Node value to the right of this node
	 */
	public Node getRight(){
		return right;
	}
	
}