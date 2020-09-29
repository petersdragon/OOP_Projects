package diceRollerPD;

/**
 * The NumberOfDiceRangeException is thrown a DiceBag's number of dice in the bag is set to be less than 1.
 * It returns an error message as a string that can be displayed to the user.
 * 
 * @package diceRollerPD
 * @author Peter
 *
 */
public class NumberOfDiceRangeException extends Exception{

	NumberOfDiceRangeException(String message){
		super(message);
	}
}
