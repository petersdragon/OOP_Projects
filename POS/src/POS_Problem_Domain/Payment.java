package POS_Problem_Domain;

import java.math.BigDecimal;

/**
 * The method by which payment for the sale is to be conducted
 */
public abstract class Payment {

	/**
	 * Total price charged for the sale
	 */
	private BigDecimal amount;
	/**
	 * Total amount of money tendered for the sale
	 */
	private BigDecimal amountTendered;

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmountTendered() {
		return this.amountTendered;
	}

	public void setAmountTendered(BigDecimal amountTendered) {
		this.amountTendered = amountTendered;
	}

	/**
	 * Determine whether the payment method is valid
	 */
	public Boolean countsAsCash() {
		// TODO - implement Payment.countsAsCash
		throw new UnsupportedOperationException();
	}


}