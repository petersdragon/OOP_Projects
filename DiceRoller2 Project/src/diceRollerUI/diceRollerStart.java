package diceRollerUI;

/**
 * This program sets up a frame where the user can 
 * select the number of dice they want to roll and how 
 * many faces each die has. They are then able to roll 
 * those dice and see the result of each die and the 
 * total.
 * 
 * @author Peter
 *
 */
public class diceRollerStart {
	public static void main(String[] args) {

		DiceRollerFrame rollerFrame = new DiceRollerFrame();
		rollerFrame.pack(); // Set the size of the frame based on its content
		rollerFrame.setVisible(true); // Set the frame to visible so that the user can see it
		
	} // main

} // diceRollerStart
