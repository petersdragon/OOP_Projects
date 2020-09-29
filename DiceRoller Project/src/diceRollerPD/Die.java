package diceRollerPD;

import java.util.Random;

public class Die {
	
	private int numFaces;
	private int curValue;
	private Random randomGen;
	
	public Die() {
		randomGen = new Random();
	}
	
	public Die(int numFaces) {
		this(); // Call default constructor
		this.numFaces = numFaces;
		this.roll();
	}
	
	public int roll() {
		this.curValue = randomGen.nextInt(this.numFaces) + 1;
		return this.curValue;
	}
	
	public int getNumFaces() {
		return this.numFaces;
	}
	
	public int getCurValue() {
		return this.curValue;
	}
	
	public String toString() {
		return "d" + Integer.valueOf(this.numFaces).toString() + " = " + Integer.valueOf(this.curValue).toString();
	}
}
