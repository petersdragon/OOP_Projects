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
		this.setCashAmount(new BigDecimal(0));
	}

	/**
	 * Remove cash from the drawer
	 * @param cash
	 */
	public void removeCash(BigDecimal cash) {
		this.setCashAmount(this.getCashAmount().subtract(cash));
	}

	/**
	 * Add to cash stored in the drawer
	 * @param cash
	 */
	public void addCash(BigDecimal cash) {
		this.setCashAmount(this.getCashAmount().add(cash));
	}

	public String toString() {
		return this.getCashAmount().toString();
	}


}