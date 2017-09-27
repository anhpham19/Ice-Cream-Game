import javax.swing.JFrame;

/**
 * This program creates an Ice-cream maker. The user can creates an ice-cream by
 * pressing on the buttons and a stack of ice-cream scoops will appear on the
 * cone. The user can also eat the top scoop by pressing the trash button, the
 * top scoop will be removed from the cone.
 * 
 * @author Anh Chau Pham
 * @version Nov 12
 *
 */
public class IceCreamMakerApplication {

	/**
	 * Run the program
	 * 
	 * @param args
	 *            the string argument
	 */
	public static void main(String[] args) {
		// create a new JFrame
		JFrame iceCreamFrame = new JFrame("Ice-cream maker");

		// set size for frame
		iceCreamFrame.setSize(600, 700);

		// add the ice-cream maker in
		iceCreamFrame.add(new IceCreamMaker());

		// set normal exit upon closing the window
		iceCreamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set visible
		iceCreamFrame.setVisible(true);
	}
}
