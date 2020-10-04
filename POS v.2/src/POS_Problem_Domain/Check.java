package POS_Problem_Domain;

import java.math.BigDecimal;

/**
 * Handles the payment option of using a Check
 */
public class Check extends AuthorizedPayment {

	/**
	 * The routing number to the appropriate Bank
	 */
	private String routingNumber;
	/**
	 * The account number from which the payment will come
	 */
	private String accountNumber;
	/**
	 * The check's identification number
	 */
	private String checkNumber;

	public String getRoutingNumber() {
		return this.routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCheckNumber() {
		return this.checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	/**
	 * Default Constructor initializes the cost for the sale and the amount tendered
	 */
	public Check() {
		// TODO - implement Check.Check
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructor initializes the routing number, account number, and check number used for payment.
	 * @param amount
	 * @param accountNumber
	 * @param checkNumber
	 */
	public Check(String amount, String amountTendered, String rountingNumber, String accountNumber, String checkNumber) {
		this.setAmount(new BigDecimal(amount));
		this.setAmountTendered(new BigDecimal(amountTendered));
		this.setRoutingNumber(routingNumber);
		this.setAccountNumber(accountNumber);
		this.setCheckNumber(checkNumber);
	}

	/**
	 * Determine whether the payment method is valid
	 */
	public Boolean isAuthorized() {
		return true;
	}

	/**
	 * Format the relevant information into a single string to be printed to a display
	 */
	public String toString() {
		return this.getAccountNumber() + " " + this.getAmountTendered();
	}
	
}