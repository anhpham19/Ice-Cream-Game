/**
 * This class create a Stack Linked List based on a linked list and has only one
 * instance variable and implements the interface Stack.
 * 
 * @author Anh Chau Pham
 * @version Nov 12
 */
public class StackLL<T> implements Stack<T> {
	// The implemented linked list
	private LinkedList<T> linkedList = new LinkedList<T>();

	/**
	 * Pushes an element onto the top of the stack.
	 * 
	 * @param data
	 *            the data you want to push in
	 */
	public void push(T data) {
		linkedList.insertFirst(data);
	}

	/**
	 * Removes the top of the stack and returns it.
	 * 
	 * @return the popped data
	 */
	public T pop() {
		T data = linkedList.getFirst();
		if (!linkedList.isEmpty()) {
			linkedList.deleteFirst();
		}

		return data;
	}

	/**
	 * Gets the element at the top of the stack without removing it.
	 * 
	 * @return the peeked data
	 */
	public T peek() {
		return linkedList.getFirst();
	}

	/**
	 * Tests if the stack is empty.
	 * 
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	/**
	 * Returns a String representation of the stack.
	 * 
	 * @return stack as String
	 */
	public String toString() {
		return linkedList.toString();
	}

}
