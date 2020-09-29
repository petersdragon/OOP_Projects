package diceRollerUI;

import javax.swing.JFrame;

/**
 * Defines the frame for the DiceRoller to display the UI to the user.
 * 
 * @package diceRollerUI
 * @author Peter
 */
public class DiceRollerFrame extends JFrame {
	
	/**
	 * Create the frame and populate it with the DiceRollerPanel components.
	 */
	public DiceRollerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Dice Roller v.2");
		getContentPane().add(new DiceRollerPanel());
	}

}
