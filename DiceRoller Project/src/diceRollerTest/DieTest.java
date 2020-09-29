package diceRollerTest;

import diceRollerPD.Die;

public class DieTest {

	// Range test 1 <= x <= numFaces
	public void dieRangeTest(int numRolls, int numFaces) {
		
		System.out.println("\nStart Range Test for d" + numFaces + ", " + numRolls + " times");
		Boolean inRange = true;
		Die die = new Die(numFaces);
		
		for (int i = 0; i < numRolls; i++) {
			die.roll();
			if (die.getCurValue() < 1 || die.getCurValue() > numFaces) {
				
				System.out.println("Range Error " + die.getCurValue());
				inRange = false;
			}
				
		}
		if (inRange)
			System.out.println("All values are in the range.");

		System.out.println("End Range Test\n");
	}
	
	// Determine if the distribution of  values of the die is balanced
	public void dieFrequencyTest(int numRolls, int numFaces) {
		
		System.out.println("\nStart Frequency Test for d" + numFaces + ", " + numRolls + " times");

		Die die = new Die(numFaces);
		int sideValue = 0; // The summed value of the faces of the die for determining the expected value
		float expectedValue;
		int total = 0; // The summed value rolled by the die for determining the average
		float average;
		int[] valueDistribution = new int[numFaces];
		
		// Determine the expected value of the die
		for (int i = 0; i < numFaces; i++) {
			sideValue += (i + 1); // Determine the sum of the faces on the die
		}
		expectedValue = (float)sideValue / numFaces;
		
		int index;
		for (int i = 0; i < numRolls; i++) {
			index = die.roll() - 1;
			total += die.getCurValue();
			valueDistribution[index]++;
		}
		average = (float)total / numRolls; // Determine the average result of the die rolls

		// Output information about the die to the user
		System.out.println("Expected Average   = " + expectedValue);
		System.out.println("Calculated Average = " + average);
		System.out.println("Val #Roll %Roll");
		for (int i = 0; i < numFaces; i++) {

			System.out.println((i+1) + " - " + valueDistribution[i] + " - " + String.format("%.1f", (float)valueDistribution[i] / numRolls * 100) + "%");
		}
		System.out.println("End Frequency Test\n");
		
	}
	
}
