/**
 * This is the interface for the Queue abstract data type with isEmpty, peek,
 * dequeue, enqueue and toString methods. This interface supports generics (Type
 * T).
 * 
 * @author Anh Pham
 * @version Nov 20
 */
public interface Queue<T> {
	/**
	 * Tests if the queue is empty.
	 * 
	 * @return true if the queue is empty
	 **/
	public boolean isEmpty();

	/**
	 * Gets the element at the front of the queue without removing it.
	 * 
	 * @return the peeked data
	 **/
	public T peek();

	/**
	 * Removes the front element of the queue and returns it.
	 * 
	 * @return the dequeued data
	 **/
	public T dequeue();

	/**
	 * Adds an element to the end of the queue.
	 * @param data the data want to enqueue
	 **/
	public void enqueue(T data);

	/**
	 * Returns a String representation of the queue.
	 * 
	 * @return queue as String
	 **/
	public String toString();

}
