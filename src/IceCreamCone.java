import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

/**
 * This class creates an ice-cream cone that maintain a stack of ice cream scoop
 * flavors using the class you just created. The class should offer two versions
 * of a method addScoop for adding a scoop to the top of the cone: one that
 * takes a String indicating the flavor to be added, and one that takes no
 * arguments and adds a scoop of a random flavor.
 *
 * @author Anh Pham
 * @version Nov 12
 *
 */
public class IceCreamCone extends JPanel {
	// the string array of all flavor names
	public static final String[] FLAVORS = { "vanilla", "strawberry",
			"green tea", "caramel" };

	// the color for each flavor
	public static final Color[] PAINT_COLORS = { Color.YELLOW, Color.PINK,
			Color.GREEN, Color.ORANGE };

	// the width of cone
	private static final int CONE_WIDTH = 40;

	// the height of cone
	private static final int CONE_HEIGHT = 70;

	// diameter of each scoop
	private static final int SCOOP_DIAMETER = 50;

	// the overlap of the scoops
	private static final int SCOOP_OVERLAP = 15;

	//
	private static final int MAX_SCOOPS = 4;

	//
	private static final int MIN_SCOOPS = 1;

	// the stack of ice-cream scoops consisting of integers
	private Stack<Integer> scoopFlavorStack;

	// the size scale of the cone
	private double sizeScale;

	/**
	 * Constructor
	 */
	public IceCreamCone() {
		// create a new stack for the scoops
		scoopFlavorStack = new StackLL<Integer>();

		sizeScale = 1;
	}

	/**
	 * Set the scale for the cone in the serve area or line IMPORTANT: I know
	 * how to set it but encounter some double - integer problems and cannot fix it
	 * before the deadline. Generally, I will multiply the scale to the size of
	 * each element in the cone such as scoop, diameter of scoop or the
	 * triangle. The scale of the cones in line is 0.5 and of the cones in the
	 * serving area is 1.
	 * 
	 * @param scale
	 *            the scale want to set.
	 */
	public void setScale(double scale) {
		sizeScale = scale;
	}

	/**
	 * Add a new scoop to the stack knowing the flavor
	 * 
	 * @param flavor
	 *            the flavor you want to add
	 */
	public void addScoop(String flavor) {
		// get the index of the flavor
		Integer flavorIndex = (Integer) findFlavorIndex(flavor);

		// push that index into the stack
		scoopFlavorStack.push(flavorIndex);
	}

	/**
	 * Add a new scoop to the stack randomly
	 */
	public void addScoop() {
		// create a new random index for the flavors
		int flavorIndex = ((int) (Math.random() * FLAVORS.length));

		// add the scoop to the stack
		addScoop(FLAVORS[flavorIndex]);
	}

	/**
	 * Check to see if the ice cream cone has any scoops
	 * @return true if cone has scoop
	 */
	public boolean hasScoop() {
		
		// check if the flavor stack if empty
		return !scoopFlavorStack.isEmpty();
	}

	/**
	 * Remove the top scoop from the stack
	 * 
	 * @return the scoop flavor being removed
	 */
	public String popTopScoop() {
		// if the stack is empty then there is nothing to pop
		if (scoopFlavorStack.isEmpty()) {
			return "There is nothing to pop!";
		}

		// return the scoop flavor being removed
		return FLAVORS[((Integer) scoopFlavorStack.pop()).intValue()];

	}

	/**
	 * Find the integer index for the flavor
	 * 
	 * @param flavor
	 *            the flavor
	 * @return index for the flavor
	 */
	public int findFlavorIndex(String flavor) {
		// loop through each flavor and return the index for the flavor: 0, 1,
		// 2, 3
		for (int i = 0; i < FLAVORS.length; i++) {
			if (flavor.equals(FLAVORS[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Paint the whole program
	 */
	public void paint(Graphics g)

	{
		// paint the cone
		paintCone(g);

		// paint the scoops
		paintScoops(g);
	}

	/**
	 * Paint the scoops in the stack
	 * 
	 * @param g
	 *            the graphics
	 */
	public void paintScoops(Graphics g) {
		// the x and y coordinate of each scoop in the stack
		int xCoordScoop = getWidth() / 2 - SCOOP_DIAMETER / 2;
		int yCoordScoop = getHeight() - CONE_HEIGHT - SCOOP_DIAMETER
				+ SCOOP_OVERLAP;

		// create a temporary stack
		Stack<Integer> temporaryStack = new StackLL<Integer>();

		// move the items from the scoop flavor stack to the temporary stack
		// hence creating a "upside-down" scoop flavor stack
		while (!scoopFlavorStack.isEmpty()) {
			temporaryStack.push((Integer) scoopFlavorStack.pop());
		}

		// move the items from the temporary stack back into the scoop flavor
		// stack
		while (!temporaryStack.isEmpty()) {
			// pop each items from the temporary stack
			Integer tempFlavorIndex = (Integer) temporaryStack.pop();

			// paint the scoop according to the flavor index
			paintScoop(g, tempFlavorIndex.intValue(), xCoordScoop, yCoordScoop);

			// push the items back to scoop flavor stack
			scoopFlavorStack.push(tempFlavorIndex);

			// update y-coordiante for each next scoop
			yCoordScoop = yCoordScoop - SCOOP_DIAMETER + SCOOP_OVERLAP;
		}
	}

	/**
	 * Paint the cone
	 * 
	 * @param g
	 *            the graphics
	 */
	public void paintCone(Graphics g) {
		// create an array of x and y coordinates for 3 points
		int[] xCoords = new int[3];
		int[] yCoords = new int[3];

		// each x-coordinate of each point of the cone
		xCoords[0] = getWidth() / 2;
		xCoords[1] = xCoords[0] - (CONE_WIDTH / 2);
		xCoords[2] = xCoords[0] + (CONE_WIDTH / 2);

		// each y-coordinate of each point of the cone
		yCoords[0] = getHeight();
		yCoords[1] = yCoords[0] - CONE_HEIGHT;
		yCoords[2] = yCoords[0] - CONE_HEIGHT;

		// set color for the cone
		g.setColor(new Color(180, 125, 50));

		// number of points making up the cone
		int pointNumbers = 3;

		// draw the cone based on those 3 points
		g.fillPolygon(xCoords, yCoords, pointNumbers);
	}

	/**
	 * Paint 1 scoop according to its unique features
	 * 
	 * @param g
	 *            the graphics
	 * @param flavorIndex
	 *            the index of the flavors
	 * @param x
	 *            the x-coordinate
	 * @param y
	 *            the y-coordinate
	 */
	public void paintScoop(Graphics g, int flavorIndex, int x, int y) {
		// set color for each flavor
		g.setColor(PAINT_COLORS[flavorIndex]);

		// paint the fill oval representing the scoop
		g.fillOval(x, y, SCOOP_DIAMETER, SCOOP_DIAMETER);
	}

	/**
	 * Create a random ice cream cone which random number of scoops 
	 * @return the random ice cream cone
	 */
	public static IceCreamCone createRandom() {
		
		// create a new random ice cream cone
		IceCreamCone randomCone = new IceCreamCone();

		// the random number of scoops will range from MIN_SCOOPS to MAX_SCOOPS
		int randomNumScoops = MIN_SCOOPS
				+ (int) (Math.random() * ((MAX_SCOOPS - MIN_SCOOPS) + 1));

		// add the number of scoops in the cone
		for (int i = 0; i < randomNumScoops; i++) {
			randomCone.addScoop();
		}

		return randomCone;

	}
}
