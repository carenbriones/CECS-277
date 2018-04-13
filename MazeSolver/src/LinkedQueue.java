import java.awt.Point;

/**
 * Class that allows the user to create, modify, and access the nodes in a queue
 * that take in Point objects.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class LinkedQueue {

	//data members
	/** First node in the queue */
	private Node first;
	/** Last node in the queue */
	private Node last;

	/**
	 * Constructs a LinkedQueue object with a null first and
	 * last node
	 */
	public LinkedQueue(){
		first = null;
		last = null;
	}

	/**
	 * Returns whether a linked queue is empty or not
	 * @return whether the linked queue is empty or not
	 */
	public boolean isEmpty(){
		return first == null;
	}

	/**
	 * Adds a point to the linked queue
	 * @param p point to be added to the queue
	 */
	public void add(Point p){
		if(isEmpty()){
			first = new Node(p);
			last = first;
		} else{
			Node n = new Node(p);
			last.setNext(n);
			last = n;
		}
	}

	/**
	 * Returns, but does not remove, the point at the front
	 * of the queue
	 * @return the point at the front of the queue
	 */
	public Point peek(){
		Point ret = null;
		if(isEmpty()){
			System.out.println("Queue is empty.");
		} else{
			ret = first.getValue();
		}
		return ret;
	}

	/**
	 * Removes and returns the point at the front of the queue
	 * @return point at the front of the queue
	 */
	public Point remove() {
		Point ret = null;
		if( isEmpty() ) {
			System.out.println("Nothing to Remove");
		} else {
			ret = first.getValue();
			first = first.getNext();
			if( first == null ) {
				last = null;
			}
		}
		return ret;
	}

	/**
	 * Returns the size of the queue
	 * @return size of the queue
	 */
	public int size(){
		int count = 0;
		Node n = first;
		while (n != null)
		{
			count++;
			n = n.getNext();
		}
		return count;
	}

	/**
	 * Converts the queue to a string and returns the string
	 * @return the queue converted to a string object
	 */
	@Override
	public String toString(){
		String s = "";
		Node n = first;
		while (n != null){
			s = s + n.getValue();
			n = n.getNext();
		}
		return s;
	}
}
