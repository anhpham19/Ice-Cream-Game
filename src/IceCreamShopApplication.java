import javax.swing.JFrame;

/**
 * This program run an IceCreamShop. It builds off of the queue-based
 * IceCreamLine as well as the stack-based IceCreamMaker. It has an order queue;
 * the player should build the next random order, then be able to "serve" it to
 * the next in line. At this point, the order should be checked if it is
 * correct. If the serve is correct, the user gets 10 points, if the serve is
 * incorrect, the user loses 5 points.
 */
public class IceCreamShopApplication {

	/**
	 * Run the program
	 * 
	 * @param args
	 *            the string argument
	 */
	public static void main(String[] args) {
		// create a new JFrame
		JFrame iceCreamFrame = new JFrame("Anh's Luxury Ice-cream shop");

		// set size for frame
		iceCreamFrame.setSize(800, 800);

		// add the ice-cream shop in
		iceCreamFrame.add(new IceCreamShop());

		// set normal exit upon closing the window
		iceCreamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set visible
		iceCreamFrame.setVisible(true);
	}
}
