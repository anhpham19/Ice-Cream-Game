import javax.swing.Box;

/**
 * This class represents an ice cream shop line. It maintain a queue of ice
 * cream cone orders. Each order is an ice cream cone with between 1 and 4
 * random scoop flavors.
 * 
 * @author Anh Pham
 * @version Nov 20
 *
 */
public class IceCreamLine extends Box {
	// create a queue of ice cream cones
	public Queue<IceCreamCone> orderLine = new QueueLL<IceCreamCone>();

	/**
	 * Constructor for an ice cream line
	 */
	public IceCreamLine() {
		// set the x-axis order for the Box where the items lines up vertically
		super(1);
	}

	/**
	 * Check if there is any order from the customers
	 * 
	 * @return true if there is any ice cream cone in the line
	 */
	public boolean hasOrder() {
		return !orderLine.isEmpty();
	}

	/**
	 * Add a specific ice cream cone order
	 * 
	 * @param cone
	 *            the cone want to add
	 */
	public void addOrder(IceCreamCone cone) {
		// enqueue a new item in the queue
		orderLine.enqueue(cone);

		// add the cone in the panel
		add(cone);

		// added a component
		validate();

		// repaint for any changed state
		repaint();

	}

	/**
	 * Add a random ice cream cone order
	 */
	public void addRandomOrder() {
		// create a random cone
		IceCreamCone randomCone = IceCreamCone.createRandom();

		// add the random cone in the order
		addOrder(randomCone);
	}

	/**
	 * Get the order which is going to be served next Or in other words the
	 * first item in the ice cream cone queue
	 * 
	 * @return the first item in the queue
	 */
	public IceCreamCone getNextOrder() {
		// dequeue the item from the queue
		IceCreamCone nextOrder = orderLine.dequeue();

		// if there is any next order
		if (nextOrder != null) {
			// remove it from the box
			remove(nextOrder);

			// removed a component
			validate();

			// repaint for any changed state
			repaint();
		}

		return nextOrder;
	}
}
