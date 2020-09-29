package diceRollerUI;

import java.util.Scanner;

import diceRollerTest.DiceBagTest;
import diceRollerTest.DieTest;

public class diceRollerStart {

	public static void main(String[] args) {
	
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter the number of faces on the dice: ");
		int numFaces = userInput.nextInt();
		System.out.print("Enter the number of dice in the dice bag: ");
		int numDice = userInput.nextInt();
		System.out.print("Enter the number of rolls to perform: ");
		int numRolls = userInput.nextInt();

		// Run the DiceBag test
		DiceBagTest diceBagTest = new DiceBagTest();
		diceBagTest.diceBagTest(numRolls, numFaces, numDice);

		// Run the Die tests
		DieTest dieTest = new DieTest();
		dieTest.dieRangeTest(100, numFaces);
		dieTest.dieFrequencyTest(100, numFaces);
		
		userInput.close();
	} // main

} // diceRollerStart

