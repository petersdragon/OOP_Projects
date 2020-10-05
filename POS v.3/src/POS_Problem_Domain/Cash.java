package POS_Problem_Domain;

import java.math.BigDecimal;

/**
 * Classic payment method with paper money and coins
 */
public class Cash extends Payment {

	/**
	 * Default Constructor
	 */
	public Cash() {
		// TODO - implement Cash.Cash
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructor initializes the total cost for the sale and the amount tendered for the sale
	 * @param amount
	 * @param amountTendered
	 */
	public Cash(String amount, String amountTendered) {
		this.setAmount(new BigDecimal(amount));
		this.setAmountTendered(new BigDecimal(amountTendered));
	}

	/**
	 * Determine whether the payment method is Cash or Non-Cash
	 */
	public Boolean countsAsCash() {
		return true;
	}

	/**
	 * Format the relevant information regarding the Cash into a single string to print to a display.
	 */
	public String toString() {
		return "Total: " + this.getAmount() + " Tendered: " + this.getAmountTendered();
	}


}