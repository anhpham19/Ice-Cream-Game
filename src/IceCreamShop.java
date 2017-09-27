import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * This programs creates an IceCreamShop object which is a game where the user
 * can generate random order, serve the order and get the score. If the serve is
 * correct, the user gets 10 points, if the serve is incorrect, the user loses 5
 * points.
 * 
 * @author Anh Chau Pham
 * @version Nov 20
 */
public class IceCreamShop extends JPanel implements ActionListener {
	// The score user get for correct serve
	private static final int CORRECT_SCORE = 10;

	// The score user get for wrong serve
	private static final int INCORRECT_SCORE = 5;

	// The user's score
	private int score = 0;

	// the score label
	private JLabel scoreLabel = new JLabel();

	// the instruction label
	private JLabel instructionLabel = new JLabel();

	// the new order and remove next buttons
	private JButton newOrderButton, removeNextButton;

	// ice-cream line
	private IceCreamLine line;

	// ice-cream maker
	private IceCreamMaker maker;

	/**
	 * Constructor for an ice-cream shop
	 */
	public IceCreamShop() {

		// the ice-cream line object
		line = new IceCreamLine();

		// the ice cream maker object
		maker = new IceCreamMaker();

		// set border layout for the entire panel
		setLayout(new BorderLayout());

		// set the smaller areas
		addOrderArea();
		addServeArea();
		addControlArea();
	}

	/**
	 * Add an order area, this area will include the new order button, remove
	 * next button and the ice cream line of the customers.
	 */
	public void addOrderArea() {

		// create a new panel and set border layout
		JPanel orderPanel = new JPanel();
		orderPanel.setLayout(new BorderLayout());

		// add new order button in the south
		orderPanel.add(createNewOrderButton(), BorderLayout.SOUTH);

		// add remove next button in the north
		orderPanel.add(createRemoveNextButton(), BorderLayout.NORTH);

		// add the ice cream line in the center
		orderPanel.add(line, BorderLayout.CENTER);

		// add the entire order panel in the west
		add(orderPanel, BorderLayout.WEST);
	}

	/**
	 * The create new order button This button will generate a random ice cream
	 * cone of the customer
	 * 
	 * @return the create new order button
	 */
	public JButton createNewOrderButton() {

		// create the button
		newOrderButton = new JButton("Add a random order");

		// add listener so that user can interact with it
		newOrderButton.addActionListener(this);
		return newOrderButton;
	}

	/**
	 * Create the remove next button This button will play a role of serving the
	 * ice cream to the customer
	 * 
	 * @return the remove next button
	 */
	public JButton createRemoveNextButton() {
		// create the button
		removeNextButton = new JButton("Serve the next order");

		// add listener so that user can interact with it
		removeNextButton.addActionListener(this);
		return removeNextButton;
	}

	/**
	 * Add the serving area, this area will be the serving area where the player
	 * construct an ice cream cone based on 4 flavors.
	 */
	public void addServeArea() {
		// add the ice cream maker in the center of this area
		add(maker, BorderLayout.CENTER);
	}

	/**
	 * Add the control area This area will display the instructions and keep
	 * track of the score of the player
	 */
	public void addControlArea() {

		// create a new panel and set grid layout
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(2, 1));

		// create the instruction label, several lines technique is from Stack
		// OverFlow
		instructionLabel = new JLabel(
				"<html>Make ice-cream cones to match next order at the top<br>Every correct order earns 10 points.<br>Every wrong order takes away 5 points.</html>");

		// set the initial score (which is 0)
		scoreLabel.setText("Score: 0");

		// add the instruction label into the control panel
		controlPanel.add(instructionLabel);

		// add the score label into control panel
		controlPanel.add(scoreLabel);

		// add the control pane into in the north
		add(controlPanel, BorderLayout.NORTH);

	}

	/**
	 * Allows the programs to interact according to user actions
	 * 
	 * @param e
	 *            the action event
	 */
	public void actionPerformed(ActionEvent e) {

		// if user click on new order button then new random ice cream cone is
		// created in the line
		if (e.getSource().equals(newOrderButton)) {
			line.addRandomOrder();
		}

		// if user click on remove next button then we serve the ice cream and
		// update the score
		else if (e.getSource().equals(removeNextButton)) {

			// only update score if the line is not empty (or there is customer
			// ordered)
			if (!line.orderLine.isEmpty()) {
				serveAndUpdateScore();
			}
		}
	}

	/**
	 * Serve the ice cream and update the score.
	 */
	public void serveAndUpdateScore() {

		// the ice cream cone user is making in her shop
		IceCreamCone shopCone = maker.getCone();

		// the ice cream cone of the customer which is in the line
		IceCreamCone customerCone = line.getNextOrder();

		// if user serves correctly then she gets 10 points
		if (correctServe(shopCone, customerCone)) {
			score += CORRECT_SCORE;
		}

		// else, she'll lose 5 points
		else {
			score -= INCORRECT_SCORE;
		}

		// update the score in the score label
		scoreLabel.setText("Score: " + Integer.toString(score));

		// reset the ice cream cone in the shop after the serving
		maker.reset();

	}

	/**
	 * Check if the ice cream served and the ice cream ordered match
	 * 
	 * @param shopCone
	 *            ice cream served in the serve area
	 * @param customerCone
	 *            ice cream ordered in the line
	 * @return true if the two ice cream cone match
	 */
	public boolean correctServe(IceCreamCone shopCone, IceCreamCone customerCone) {
		// if there is customer order
		if (customerCone != null) {
			// then loop through each scoop of the customer's cone
			while (customerCone.hasScoop()) {

				// if the shop cone has less scoops then it must be wrong order
				if (!shopCone.hasScoop()) {
					return false;
				}

				// else if each scoop of the customer cone is not equal to each
				// scoop of customer, then they don't match
				else {

					// do the comparing by poping each scoops of the 2 cones
					if (!(customerCone.popTopScoop().equals(shopCone
							.popTopScoop()))) {
						return false;
					}
				}
			}
		}

		// return true if all the scoop of the customer has been compared (pop)
		return !customerCone.hasScoop();

	}

}
