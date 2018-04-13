import java.awt.Point;

/**
 * Class that creates, accesses, and modifies information in a node,
 * which consists of a Point object and the node after it.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Node {
	
	//data members
	/** String stored in the Node */
	private Point p;
	/** Next Node object */
	private Node next;
	
	/**
	 * Constructs a node consisting of the string value in the parameter
	 * and a null next node
	 * @param a Point object data member of the node
	 */
	public Node(Point a){
		p = a;
		next = null;
	}
	
	/**
	 * Constructs a node consisting of the string value and the
	 * node in the parameter
	 * @param a Point object data member of the node
	 * @param n the following node
	 */
	public Node(Point a, Node n){
		p = a;
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
	 * Returns the Point object in the node
	 * @return Point object
	 */
	public Point getValue(){
		return p;
	}
	
	/**
	 * Changes the Point object in a node to the Point in the parameters
	 * @param a Point object
	 */
	public void setValue(Point a){
		p = a;
	}
}