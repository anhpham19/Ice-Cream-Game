import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class uses ice-cream cone class to add and remove scoops from the cone.
 * The user can clicks the buttons and the program will reacts accordingly.
 * 
 * @author Anh Chau Pham
 * @version Nov 12
 *
 */
public class IceCreamMaker extends JPanel implements ActionListener {
	// the ice cream cone
	private IceCreamCone cone;

	// the array of buttons of 4 flavors
	private JButton[] flavorButtons;

	// the trash button
	private JButton trashButton;

	// the number of flavors
	private static final int FLAVORS = 4;

	/**
	 * Constructor
	 */
	public IceCreamMaker() {
		// set Border Layout
		setLayout(new BorderLayout());

		// the ice cream cone object
		cone = new IceCreamCone();

		// add the cone to the center
		add(cone, BorderLayout.CENTER);

		// add the flavor buttons and trash button
		addMenu();
	}

	/**
	 * Add the flavor buttons and trash button
	 */
	public void addMenu() {
		// button panel contain flavor buttons and trash button
		JPanel buttonPanel = new JPanel();

		// set grid layout
		buttonPanel.setLayout(new GridLayout(2, 1));

		// add flavor buttons
		buttonPanel.add(createFlavorMenu());

		// add trash button
		buttonPanel.add(createTrashButton());

		// add the button panel to the north
		add(buttonPanel, BorderLayout.NORTH);
	}

	/**
	 * Create flavor buttons contains 4 flavors
	 * 
	 * @return the flavor button panel
	 */
	public JPanel createFlavorMenu() {
		// flavor button panel
		JPanel flavorPanel = new JPanel();

		// set grid layout
		flavorPanel.setLayout(new GridLayout(1, FLAVORS));

		// array of buttons of 4 flavors
		flavorButtons = new JButton[FLAVORS];

		// loop through each button and assign the name, color, actionlistener
		// to each button
		for (int i = 0; i < FLAVORS; i++) {
			// name of button
			flavorButtons[i] = new JButton(IceCreamCone.FLAVORS[i]);

			// color of button
			flavorButtons[i].setBackground(IceCreamCone.PAINT_COLORS[i]);

			// set opaque to be true so the color shows up on Mac OX
			flavorButtons[i].setOpaque(true);

			// paint the color for the entire buttons
			flavorButtons[i].setBorderPainted(false);

			// add action listener
			flavorButtons[i].addActionListener(this);

			// add the buttons to the flavor panel
			flavorPanel.add(flavorButtons[i]);

		}

		// return the flavor panel
		return flavorPanel;
	}

	/**
	 * Create the trash button
	 * 
	 * @return the trash button
	 */
	public JButton createTrashButton() {
		// create the trash button
		trashButton = new JButton("Eat the top scoop!");

		// add action listener
		trashButton.addActionListener(this);

		// return trash button
		return trashButton;
	}

	/**
	 * Get the ice cream cone
	 * @return the cone
	 */
	public IceCreamCone getCone() {
		return cone;
	}

	/**
	 * Reset the serving cone after serving 
	 */
	public void reset() {
		
		// pop every single scoop in the cone
		while (cone.hasScoop()) {
			cone.popTopScoop();
		}

		// repaint the ice cream cone
		cone.repaint();
	}

	/**
	 * Allows the programs to interact according to user actions
	 * 
	 * @param e
	 *            the action event
	 */
	public void actionPerformed(ActionEvent e) {
		// loop through each flavor buttons and add the according scoop
		for (int i = 0; i < FLAVORS; i++) {
			if (e.getSource() == flavorButtons[i]) {
				cone.addScoop(IceCreamCone.FLAVORS[i]);
			}
		}

		// delete the top scoop
		if (e.getSource() == trashButton) {
			cone.popTopScoop();
		}
		// repaint
		repaint();
	}
}
