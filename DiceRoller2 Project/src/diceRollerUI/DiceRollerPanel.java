package diceRollerUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import diceRollerPD.*;

/**
 * Defines all the components to display to the user.
 * 
 * @package diceRollerUI
 * @author Peter
 */
public class DiceRollerPanel extends JPanel {
	
	private JButton rollButton;
	private JButton settingsButton;
	private JLabel numDiceLabel;
	private JLabel numFacesLabel;
	private JTextArea diceBagString;
	private int numFaces = 6;
	private int numDice = 4;
	private DiceBag diceBag;
	
	/**
	 * Create the panel for the Dice Roller
	 */
	public DiceRollerPanel() {
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(400,300));

		CreateDiceBag(numDice, numFaces);

		// Make and add the Roll button to the panel
		rollButton = new JButton("Roll"); // instantiate the button to add to the panel
		rollButton.addActionListener(new RollButtonListener());  // to allow the button to trigger events
		this.add(rollButton); // Add the rollButton to the panel so the user can interact with it

		// Make and add the Settings button to the panel
		settingsButton = new JButton("Settings"); // instantiate the button to add to the panel
		settingsButton.addActionListener(new SettingsButtonListener()); // to allow the button to trigger events
		this.add(settingsButton); // Add the rollButton to the panel so the user can interact with it

		// Make and add the numDice label to the panel
		numDiceLabel = new JLabel("No. Dice: " + diceBag.getNumDice());
		this.add(numDiceLabel); // Add the numDiceLabel to the panel so the user can see how many dice are in the bag
		
		// Make and add the numFaces label to the panel
		numFacesLabel = new JLabel("No. Faces: " + diceBag.getNumFaces());
		this.add(numFacesLabel); // Add the numFacesLabel to the panel so the user can view how many faces are on the dice
		
		//
		diceBagString = new JTextArea("Roll the dice to display the results or click \nSettings to change the dice in the bag.");
		diceBagString.setEditable(false);
		diceBagString.setFont(new Font("", Font.PLAIN, 16));
		this.add(diceBagString);
		
		
	} // Default Constuctor
	
	/**
	 * Create the DiceBag for the user to interact with, but make sure 
	 * that the number of dice in the bag makes sense and the number 
	 * of faces on the dice make sense
	 */
	private void CreateDiceBag(int numDice, int numFaces) {

		String errorMessage = "";
		Boolean noError = true;
		
		try {
		diceBag = new DiceBag(numDice, numFaces);
		}
		catch (NumberOfFacesRangeException exception) {
			noError = false;
			errorMessage += exception.getMessage();
		}
		catch (NumberOfDiceRangeException exception) {
			noError = false;
			errorMessage += exception.getMessage();
		}
		finally {
			if (noError) {
				errorMessage = "Dice Bag Generated Successfully";
			}
			JOptionPane.showMessageDialog(new JFrame(), errorMessage);	
		}		
		
	} // CreateDiceBag
	
	/**
	 * Create the listener for the Roll button to know when the user wants the dice to be rolled
	 */
	private class RollButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			diceBag.roll();
			diceBagString.setText(diceBag.toString());
			
		} // actionPerformed
		
	} // RollButtonListener

	/**
	 * Create the listener for the Settings button to know when the user wants to change the
	 * number of dice in the bag or the number of faces on the dice.
	 */	
	private class SettingsButtonListener implements ActionListener {
		
		private String enteredFaces, enteredDice;
		public void actionPerformed(ActionEvent event) {
			
			// Allow the user to change the number of faces on the dice in the bag
			enteredFaces = JOptionPane.showInputDialog("Enter the number of faces on the dice: ");
			numFaces = Integer.parseInt(enteredFaces);
			
			// Allow the user to change the number of dice in the bag
			enteredDice = JOptionPane.showInputDialog("Enter the number of dice: ");
			numDice = Integer.parseInt(enteredDice);
			
			CreateDiceBag(numDice, numFaces);

			// Reset the text in the labels on the panel to show the correct information
			numDiceLabel.setText("No. Dice: " + diceBag.getNumDice());
			numFacesLabel.setText("No. Faces: " + diceBag.getNumFaces());
			diceBagString.setText("Roll the dice to display the results.");

		} // actionPerformed
	} // SettingsButtonListener
} // DiceRollerPanel
