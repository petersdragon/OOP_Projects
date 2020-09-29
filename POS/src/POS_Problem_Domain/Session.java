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
	private ArrayList<Sale> sales;
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

	public ArrayList<Sale> getSales() {
		return this.sales;
	}

	public void setSales(ArrayList<Sale> sales) {
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
	 * Constructor initializes the cashier, register in use, and start time of the session.
	 * @param cashier
	 * @param register
	 */
	public Session(Cashier cashier, Register register) {
		this.setCashier(cashier);
		this.setRegister(register);
		this.setStartDateTime(LocalDateTime.now());
	}

	/**
	 * Add a sale object to the session
	 * @param sale
	 */
	public void addSale(Sale sale) {
		this.getSales().add(sale);
	}

	/**
	 * Remove a sale from the session
	 * @param sale
	 */
	public void removeSale(Sale sale) {
		this.getSales().remove(sale);
	}

	/**
	 * Calculate the difference between the amount of money that is being tendered and the total price of the sale session.
	 * @param cash
	 */
	public BigDecimal calcCashCountDiff(BigDecimal cash) {
		return cash.subtract(this.getTotal());
	}

	/**
	 * Calculate the total cost of all the sales in the session
	 */
	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);
		for (Sale sale : this.getSales())
			total.add(sale.calcTotal());
		return total;
	}
	
	/**
	 * Format the relevant information regarding a single session into a single string to print to a display.
	 */
	public String toString() {
		return "Session: Cashier: " + this.getCashier().getPerson().getName() + " Register: " + this.getRegister().getNumber() + " Date: " + LocalDateTime.now() + " Total: " + this.getTotal().toString() + "\n" + this.getSales().toString();
	}


}