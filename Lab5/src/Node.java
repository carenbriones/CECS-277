

/**
 * Class that creates, accesses, and modifies information in a node,
 * which consists of a Point object and the node after it.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Node {
	
	//data members
	/** String stored in the Node */
	private int value;
	/** Next Node object */
	private Node next;
	
	/**
	 * Constructs a node consisting of the string value in the parameter
	 * and a null next node
	 * @param a integer value of the node
	 */
	public Node(int a){
		value = a;
		next = null;
	}
	
	/**
	 * Constructs a node consisting of the string value and the
	 * node in the parameter
	 * @param a integer value of the node
	 * @param n the following node
	 */
	public Node(int a, Node n){
		value = a;
		next = n;
	}
	
	/**
	 * Returns the next node
	 * @return next node
	 */
	public Node getNext(){
		return next;
	}
	
	/**
	 * Changes the next node to the node in the parameters
	 * @param n next node
	 */
	public void setNext(Node n){
		next = n;
	}
	
	/**
	 * Returns the integer value of the node
	 * @return integer value of the node
	 */
	public int getValue(){
		return value;
	}
	
	/**
	 * Changes the value of the implicit parameter to the explicit parameter
	 * @param a value to change to
	 */
	public void setValue(int a){
		value = a;
	}
	
	@Override
	public String toString(){
		String s = Integer.toString(value);
		return s;
	}
}