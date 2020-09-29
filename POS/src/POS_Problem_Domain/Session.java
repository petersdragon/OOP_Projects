package POS_Problem_Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * In instance of a cashier conducting a sale to a customer
 */
public class Session {

	/**
	 * The register being used to conduct the sale
	 */
	private Register register;
	/**
	 * The cashier conducting the sale
	 */
	private Cashier cashier;
	/**
	 * The information regarding the sale for the session
	 */
	private Collection<Sale> sales;
	/**
	 * The time at which the session began
	 */
	private LocalDateTime startDateTime;
	/**
	 * The time at which the session ended
	 */
	private LocalDateTime endDateTime;

	public Register getRegister() {
		return this.register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public Cashier getCashier() {
		return this.cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	public Collection<Sale> getSales() {
		return this.sales;
	}

	public void setSales(Collection<Sale> sales) {
		this.sales = sales;
	}

	public LocalDateTime getStartDateTime() {
		return this.startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return this.endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	/**
	 * Default Constructor
	 */
	public Session() {
		// TODO - implement Session.Session
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructor initializes the cashier and register in use
	 * @param cashier
	 * @param register
	 */
	public Session(Cashier cashier, Register register) {
		// TODO - implement Session.Session
		throw new UnsupportedOperationException();
	}

	/**
	 * Add a sale object to the session
	 * @param sale
	 */
	public void addSale(Sale sale) {
		// TODO - implement Session.addSale
		throw new UnsupportedOperationException();
	}

	/**
	 * Remove a sale from the session
	 * @param sale
	 */
	public void removeSale(Sale sale) {
		// TODO - implement Session.removeSale
		throw new UnsupportedOperationException();
	}

	/**
	 * Calculate the difference between the amount of money that is being tendered and the total price of the sale.
	 * @param cash
	 */
	public BigDecimal calcCashCountDiff(BigDecimal cash) {
		// TODO - implement Session.calcCashCountDiff
		throw new UnsupportedOperationException();
	}

	/**
	 * Format the relevant information regarding a single session into a single string to print to a display.
	 */
	public String toString() {
		// TODO - implement Session.toString
		throw new UnsupportedOperationException();
	}


}