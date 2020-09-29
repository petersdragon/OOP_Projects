package diceRollerPD;

/**
 * The NumberOfFacesRangeException is thrown when a die is set to have less than 2 faces.
 * It returns an error message as a string that can be displayed to the user.
 * 
 * @package diceRollerPD
 * @author Peter
 *
 */
public class NumberOfFacesRangeException extends Exception{

	public NumberOfFacesRangeException(String message){
		super(message);
	}
}
