/**
 * This is the interface for the Stack abstract data type with isEmpty, peek,
 * pop, push and toString methods. This interface supports generics (Type T).
 * 
 * @author Anh Pham
 * @version Nov 12
 *
 */
public interface Stack<T> {
	/**
	 * Check if the stack is empty
	 * 
	 * @return true if stack is empty
	 */
	public boolean isEmpty();

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return the object at the top of this stack
	 */
	public T peek();

	/**
	 * Removes the object at the top of this stack and returns that object as
	 * the value of this function.
	 * 
	 * @return The object at the top of this stack
	 */
	public T pop();

	/**
	 * Pushes an data onto the top of this stack.
	 * 
	 * @param data
	 *            the data to be pushed onto this stack
	 */
	public void push(T data);

	/**
	 * Convert the stack to string version.
	 * 
	 * @return the String version of the stack
	 */
	public String toString();
}
