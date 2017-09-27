import javax.swing.JFrame;

/**
 * Run the IceCreamLine program. It will represent a line of orders from the
 * customers. The user can click on the add random order to add a new order or
 * the serve the next order button to remove the current order and serve it to
 * the customer.
 */
public class IceCreamLineManagerApplication {

	/**
	 * Run the program
	 * 
	 * @param args
	 *            the string argument
	 */
	public static void main(String[] args) {
		// create a new JFrame
		JFrame iceCreamFrame = new JFrame("Ice-cream line");

		// set size for frame
		iceCreamFrame.setSize(600, 1000);

		// add the ice-cream maker in
		iceCreamFrame.add(new IceCreamLineManager());

		// set normal exit upon closing the window
		iceCreamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set visible
		iceCreamFrame.setVisible(true);
	}
}
