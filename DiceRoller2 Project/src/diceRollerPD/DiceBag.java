package diceRollerPD;

/**
 * DiceBag holds the number of dice with the number of 
 * faces specified by the user when the DiceBag is 
 * created.
 * 
 * @package diceRollerPD
 * @author Peter
 */
public class DiceBag {

	private int numDice; // number of dice in the bag
	private int numFaces; // for each die in the bag
	private int curTotal; // the sum of the curValue of all the dice in the bag
	private Die[] dice; // to hold up to a fixed number of dice in the bag

	public DiceBag() {
		/*
		 *  The Default constructor should never be 
		 *  called because we always want the number 
		 *  of dice and faces to be specified
		*/
	} // Default Constructor
	
	/**
	 * Instantiates a DiceBag with a specified number
	 * of Dice with a specified number of faces.
	 * All the dice in the bag will have the same number of faces (ALL are d6 or ALL are d20)
	 * @param numDice for the number of dice that will be in the DiceBag
	 * @param numFaces for the number of faces that each die in the DiceBag will have
	 * @throws NumberOfFacesRangeException propagates from Die
	 * @throws NumberOfDiceRangeExecption if the number of dice in not greater than 0
	 */
	public DiceBag(int numDice, int numFaces) throws NumberOfFacesRangeException, NumberOfDiceRangeException {
		
		this.setNumDice(numDice);
		this.setNumFaces(numFaces);
		
		this.dice = new Die[numDice];
		
		for (int i = 0; i < numDice; i++) {
			Die die = new Die(numFaces);
			dice[i] = die;
		}
		
	} // Constructor
	
	/**
	 *  Roll the dice and return a random value between 
	 *  1 and the number of faces for each die, then 
	 *  calculate the sum of the dice
	 *  
	 *  @return int sum of the values of the dice
	 */
	public int roll() {

		int total = 0;
		
		// roll each die and add the curValue of that die to the total
		for (Die die : dice)
			total += die.roll();

		this.curTotal = total;
		return total;
	} // roll
	
	/**
	 * Determines how many dice have each face value from 1 to the number of faces.
	 * 
	 * @return int[] that contains the number of dice with each face value.
	 */
	public int[] getDieValueDistribution() {
		
		int[] valueDistribution = new int[this.numFaces];

		// For each die in the dice bag, determine its value, subtract 1 to get the index associated with that value, then add 1 to the distribution at that index
		for (int i = 0; i < this.numDice; i++)
			valueDistribution[this.dice[i].getCurValue() - 1]++;
		
		return valueDistribution;
	} // getDieValueDistribution
	
	/**
	 * Set the number of dice in the bag and validate the input
	 * 
	 * @param numDice
	 * @throws NumberOfDiceRangeException
	 */
	public void setNumDice(int numDice) throws NumberOfDiceRangeException {
		if (numDice < 1) {
			NumberOfDiceRangeException exception = new NumberOfDiceRangeException("The number of dice in the bag must be greater than 0 if you expect anything useful to happen.\nThank you for visiting this exception. Do it right and you won't have to see me again.\n");
			throw exception;
		}
		else
			this.numDice = numDice;
	}

	/**
	 * Returns the number of dice in the dice bag
	 * 
	 * @return int number of dice
	 */
	public int getNumDice() {
		return this.numDice;
	}
	
	/**
	 * Set the number of faces on the dice in the bag and validate the input
	 * 
	 * @param numFaces
	 * @throws NumberOfFacesRangeException
	 */
	public void setNumFaces(int numFaces) throws NumberOfFacesRangeException {
		if (numFaces < 2) {
			NumberOfFacesRangeException exception = new NumberOfFacesRangeException("A die with less than two faces is deterministic and you don't need me to roll it.\nTry again with a die with at least two sides.\n");
			throw exception;
		}
		else
			this.numFaces = numFaces;
	
	}
	
	/**
	 * Returns the number of faces on the dice in the dice bag
	 * 
	 * @return int number of faces
	 */
	public int getNumFaces() {
		return this.numFaces;
	}

	/**
	 * Returns the sum of values of the dice in the bag
	 * 
	 * @return int the sum of the dice
	 */
	public int getTotal() {
		return curTotal;
	}
	
	/**
	 * Convert the data of the DiceBag into readable lines in a String
	 * 
	 * @return String to print out.
	 */
	public String toString() {
		
		// print out the total and the curValue of each die rolled 
		String concatLines;
		String line1 = "Dice Bag with " + Integer.valueOf(this.numDice).toString() + " d"+ Integer.valueOf(this.numFaces).toString() + "\n";
		String line2 = "Total = " + Integer.valueOf(this.curTotal).toString() + "\n";
		String line3 = "#Dice Val\n";
		int[] valueDistribution = new int[this.numFaces];
		
		valueDistribution = this.getDieValueDistribution();
		
		for (int i = 0; i < this.numFaces; i++)
			line3 += ("   x" + Integer.valueOf(valueDistribution[i]).toString() + "     " + (i+1) +  "'s\n");			
		
		concatLines = line1 + line2 + line3;
		return concatLines;
	} // toString
} // public class DiceBag
