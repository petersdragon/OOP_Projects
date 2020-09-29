package diceRollerPD;

public class DiceBag {

	private int numDice; // number of dice in the bag
	private int numFaces; // for each die in the bag
	private int curTotal; // the sum of the curValue of all the dice in the bag
	private Die[] dice; // to hold up to a fixed number of dice in the bag
	
	public DiceBag() {
		
	} // Default Constructor
	
	// In this case, all the dice in this bag will have the same number of faces (ALL are d6 or ALL are d20)
	public DiceBag(int numDice, int numFaces) {
		
		this.numDice = numDice;
		this.numFaces = numFaces;
		
		this.dice = new Die[numDice];
		
		for (int i = 0; i < numDice; i++) {
			Die die = new Die(numFaces);
			dice[i] = die;
		}
		
	} // Constructor
	
	public int roll() {

		int total = 0;
		
		// roll each die and add the curValue of that die to the total
		for (Die die : dice)
			total += die.roll();

		this.curTotal = total;
		return total;
	} // roll
	
	public int[] getDieValueDistribution() {
		
		int[] valueDistribution = new int[this.numFaces];

		// For each die in the dice bag, determine its value, subtract 1 to get the index associated with that value, then add 1 to the distribution at that index
		for (int i = 0; i < this.numDice; i++)
			valueDistribution[this.dice[i].getCurValue() - 1]++;
		
		return valueDistribution;
	} // getDieValueDistribution
	
	public String toString() {
		
		// print out the total and the curValue of each die rolled 
		String concatLines;
		String line1 = "Dice Bag with " + Integer.valueOf(this.numDice).toString() + " d"+ Integer.valueOf(this.numFaces).toString() + "\n";
		String line2 = "Total = " + Integer.valueOf(this.curTotal).toString() + "\n";
		String line3 = "Val #Die\n";
		int[] valueDistribution = new int[this.numFaces];
		
		valueDistribution = this.getDieValueDistribution();
		
		for (int i = 0; i < this.numFaces; i++)
			line3 += ((i+1) + "   " + Integer.valueOf(valueDistribution[i]).toString() + "\n");			
		
		concatLines = line1 + line2 + line3;
		return concatLines;
	} // toString
} // public class DiceBag
