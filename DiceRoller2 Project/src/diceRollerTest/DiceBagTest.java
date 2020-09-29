package diceRollerTest;

import diceRollerPD.*;

/**
 * This test was designed to ensure that the DiceBag can be rolled and display the correct total
 * 
 * @author Peter
 *
 */
public class DiceBagTest {

	public void diceBagTest (int numRolls, int numFaces, int numDice) throws NumberOfFacesRangeException, NumberOfDiceRangeException {

		DiceBag diceBag;
		diceBag = new DiceBag(numDice, numFaces);

		for (int i = 0; i < numRolls; i++) {
			diceBag.roll();
			System.out.println("\nRoll " + (i+1) + ":\n" + diceBag.toString());
			
			// Confirm diceBag's total
			int total = 0; // To check the total provided by the diceBag
			int[] valueDistribution = diceBag.getDieValueDistribution();
			for (int k = 0; k < numFaces; k++)
			{
				total += valueDistribution[k]*(k+1);
			}
			System.out.println("Confirm total = " + total);
		}
	} // diceBagTest
	
} // DiceBagTest
