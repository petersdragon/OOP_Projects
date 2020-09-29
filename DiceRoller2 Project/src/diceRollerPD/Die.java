package diceRollerPD;

import java.util.Random;

/**
 * A Die knows the number of faces it has and the most 
 * recently rolled value from 1 to the number of faces 
 * it has.
 * 
 * @package diceRollerPD
 * @author Peter
 *
 */
public class Die {
	
	private int numFaces;
	private int curValue;
	private Random randomGen;
	
	
	/**
	 * Always create the Random variable whenever a Die is instantiated.
	 */
	public Die() {
		randomGen = new Random();
	}
	
	/**
	 * Instantiates an instance of a die with a certain 
	 * number of faces.then initialized its value by 
	 * rolling the die.
	 * 
	 * @param numFaces
	 * @throws NumberOfFacesRangeException
	 */
	public Die(int numFaces) throws NumberOfFacesRangeException {
		this(); // Call default constructor
		
		if (numFaces < 2) {
			NumberOfFacesRangeException exception = new NumberOfFacesRangeException("A die with less than two faces is deterministic and you don't need me to roll it. Try a die with at least two sides.");
			throw exception;
		}
		else {
			this.numFaces = numFaces;
			this.roll();
		}
	}
	
	/**
	 * Rolls the die and returns a random value from 1 
	 * to the number of faces.
	 * 
	 * @return int the current value of the die
	 */
	public int roll() {
		this.curValue = randomGen.nextInt(this.numFaces) + 1;
		return this.curValue;
	}

	/**
	 * Returns the number of faces that the die has.
	 * 
	 * @return int the number of faces on the die
	 */
	public int getNumFaces() {
		return this.numFaces;
	}
	
	/**
	 * Returns the current value of the die
	 * 
	 * @return int current value of the die
	 */
	public int getCurValue() {
		return this.curValue;
	}
	
	/**
	 * Returns the number of faces on the die and the 
	 * current value of the die in a displayable format
	 * 
	 * @return String that contains the number of faces and the value of the die
	 */
	public String toString() {
		return "d" + Integer.valueOf(this.numFaces).toString() + " = " + Integer.valueOf(this.curValue).toString();
	}
}
