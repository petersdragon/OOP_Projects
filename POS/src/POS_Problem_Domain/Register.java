package POS_Problem_Domain;

/**
 * The cash register used during a session to hold cash payments and dispense change.
 */
public class Register {

	/**
	 * The identification number for the register
	 */
	private String number;
	/**
	 * The contents of the drawer, such as how much cash is in the register
	 */
	private CashDrawer cashDrawer;

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public CashDrawer getCashDrawer() {
		return this.cashDrawer;
	}

	public void setCashDrawer(CashDrawer cashDrawer) {
		this.cashDrawer = cashDrawer;
	}

	/**
	 * Default Constructor
	 */
	public Register() {
		// TODO - implement Register.Register
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructor initializes the identification number for the register
	 * @param number
	 */
	public Register(String number) {
		// TODO - implement Register.Register
		throw new UnsupportedOperationException();
	}

	/**
	 * Formats the relevant information regarding a Register and returns it in a single string to print to a display
	 */
	public String toString() {
		// TODO - implement Register.toString
		throw new UnsupportedOperationException();
	}


}