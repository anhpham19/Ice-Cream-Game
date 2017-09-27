import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class is a GUI application offering buttons to add a random order to the
 * line or remove the first order.
 * 
 * @author Anh Chau Pham
 * @version Nov 20
 *
 */
public class IceCreamLineManager extends JPanel implements ActionListener {
	// create an ice cream line
	private IceCreamLine line;

	// new order button and remove next order button
	private JButton newOrderButton, removeNextButton;

	/**
	 * Constructor of an ice cream manager
	 */
	public IceCreamLineManager() {
		// set the border layout for the whole panel
		setLayout(new BorderLayout());

		// create a new ice cream line object
		line = new IceCreamLine();

		// add the line to the center of the panel
		add(line, BorderLayout.CENTER);

		// add control which are the two buttons
		addControls();
	}

	/**
	 * Add the create new order button and remove next button into the panel
	 */
	public void addControls() {
		// create a new button panel
		JPanel buttonPanel = new JPanel();

		// set grid layout for the button panel
		buttonPanel.setLayout(new GridLayout(2, 1));

		// add the new order button and remove next button
		buttonPanel.add(createNewOrderButton());
		buttonPanel.add(createRemoveNextButton());

		// add the button panel in the north
		add(buttonPanel, BorderLayout.NORTH);
	}

	/**
	 * Create a new order button
	 * 
	 * @return new order button
	 */
	public JButton createNewOrderButton() {
		// create the button
		newOrderButton = new JButton("Add a random order");

		// add listener to the button
		newOrderButton.addActionListener(this);
		return newOrderButton;
	}

	/**
	 * Create a remove next button
	 * 
	 * @return remove next buttom
	 */
	public JButton createRemoveNextButton() {
		// create the button
		removeNextButton = new JButton("Serve the next order");

		// add the listener to the button
		removeNextButton.addActionListener(this);
		return removeNextButton;
	}

	/**
	 * Allows the programs to interact according to user actions
	 * 
	 * @param e
	 *            the action event
	 */
	public void actionPerformed(ActionEvent e) {
		// if user click on new order button then add a new random order in the
		// line
		if (e.getSource().equals(newOrderButton)) {
			line.addRandomOrder();
		}

		// else if the user click on the remove next button then that order will
		// be removed from the line
		else if (e.getSource().equals(removeNextButton)) {
			line.getNextOrder();
		}
	}
}
