/**
 * This class create a Queue Linked List based on a linked list and has only one
 * instance variable and implements the interface Queue.
 * 
 * @author Anh Pham
 * @version Nov 20
 * 
 */
public class QueueLL<T> implements Queue<T> {
	// The implemented linked list
	private LinkedList<T> linkedList = new LinkedList<T>();

	/**
	 * Tests if the queue is empty.
	 * 
	 * @return true if the queue is empty
	 */
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	/**
	 * Gets the element at the top of the queue without removing it.
	 * 
	 * @return the peeked data
	 */
	public T peek() {
		return linkedList.getFirst();
	}

	/**
	 * Removes the top of the queue and returns it.
	 * 
	 * @return the dequeued data
	 */
	public T dequeue() {
		T data = linkedList.getFirst();
		if (!linkedList.isEmpty()) {
			linkedList.deleteFirst();
		}

		return data;
	}

	/**
	 * Pushes an element onto the tail (the end) of the queue.
	 * 
	 * @param data
	 *            the data you want to push in
	 */
	public void enqueue(T data) {
		linkedList.insertLast(data);
	}

	/**
	 * Returns a String representation of the queue.
	 * 
	 * @return queue as String
	 */
	public String toString() {
		return linkedList.toString();
	}
}
