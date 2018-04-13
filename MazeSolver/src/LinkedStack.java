import java.awt.Point;

/**
 * Class that allows the user to create, modify, and access the nodes in a stack
 * that take in Point objects.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 *
 */
public class LinkedStack {
	
	//data member
	/** Node at the end of the stack */
	private Node top;

	/**
	 * Creates the stack object with a null first Node
	 */
	public LinkedStack(){
		top = null;
	}

	/**
	 * Returns whether or not the stack is empty
	 * @return boolean whether the stack is empty or not
	 */
	public boolean isEmpty(){
		return top == null;
	}

	/**
	 * Pushes a new Point to the end of the stack
	 * @param p Point to push to the end
	 */
	public void push(Point p){
		top = new Node(p, top);
	}

	/**
	 * Returns and removes the last Node from the stack
	 * @return the last Node from the stack
	 */
	public Point pop(){
		Point retVal = null;
		if(isEmpty()){
			System.out.println("Nothing to Remove");
		} else{
			retVal = top.getValue();
			top = top.getNext();
		}
		return retVal;
	}
	
	/**
	 * Returns the last Node from the stack without removing it
	 * @return the last Node from the stack
	 */
	public Point peek(){
		Point retVal = null;
		if(isEmpty()){
			System.out.println("Stack is Empty");
		} else{
			retVal = top.getValue();
		}
		return retVal;
	}
	
	/**
	 * Converts the stack to a string object and returns the string
	 * @return the stack converted to a string object
	 */
	@Override
	public String toString(){
		String s = "";
		Node n = top;
		while(n != null){
			s =  s + n.getValue() + " ";
			n = n.getNext();
		}
		return s;
	}
}
