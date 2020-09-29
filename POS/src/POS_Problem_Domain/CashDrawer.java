package POS_Problem_Domain;

import java.math.BigDecimal;

/**
 * The information associated with the contents of a particular cash register.
 */
public class CashDrawer {

	/**
	 * The amount of cash stored in the drawer of the register
	 */
	private BigDecimal cashAmount;
	/**
	 * To store whether the drawer is open or closed
	 */
	private int position;

	public BigDecimal getCashAmount() {
		return this.cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * Default Constructor
	 */
	public CashDrawer() {
		// TODO - implement CashDrawer.CashDrawer
		throw new UnsupportedOperationException();
	}

	/**
	 * Remove cash from the drawer
	 * @param cash
	 */
	public void removeCash(BigDecimal cash) {
		// TODO - implement CashDrawer.removeCash
		throw new UnsupportedOperationException();
	}

	/**
	 * Add to cash stored in the drawer
	 * @param cash
	 */
	public void addCash(BigDecimal cash) {
		// TODO - implement CashDrawer.addCash
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO - implement CashDrawer.toString
		throw new UnsupportedOperationException();
	}


}