package POS_Problem_Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * The information regarding an instance of a customer purchasing items from the store
 */
public class Sale {

	/**
	 * The methods of payment used for purchasing the items
	 */
	private Collection<Payment> payments;
	/**
	 * The information regarding the items being sold
	 */
	private Collection<SaleLineItem> saleLineItems;
	/**
	 * The date and time at which the purchase took place
	 */
	private LocalDateTime dateTime;
	/**
	 * Determine whether tax should be factored into the final price
	 */
	private Boolean taxFree;

	public Collection<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(Collection<Payment> payments) {
		this.payments = payments;
	}

	public Collection<SaleLineItem> getSaleLineItems() {
		return this.saleLineItems;
	}

	public void setSaleLineItems(Collection<SaleLineItem> saleLineItems) {
		this.saleLineItems = saleLineItems;
	}

	public LocalDateTime getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Boolean getTaxFree() {
		return this.taxFree;
	}

	public void setTaxFree(Boolean taxFree) {
		this.taxFree = taxFree;
	}

	/**
	 * Default Constructor
	 */
	public Sale() {
		// TODO - implement Sale.Sale
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructor sets the string to determine whether the sale should be tax free
	 * @param taxFree
	 */
	public Sale(String taxFree) {
		// TODO - implement Sale.Sale
		throw new UnsupportedOperationException();
	}

	/**
	 * Add a valid method of payment to purchase the items
	 * @param payment
	 */
	public void addPayment(Payment payment) {
		// TODO - implement Sale.addPayment
		throw new UnsupportedOperationException();
	}

	/**
	 * Remove a method of payment from the sale
	 * @param payment
	 */
	public void removePayment(Payment payment) {
		// TODO - implement Sale.removePayment
		throw new UnsupportedOperationException();
	}

	/**
	 * Add a SaleLineItem describing what item is being sold in what quantity
	 * @param saleItem
	 */
	public void addSaleLineItem(SaleLineItem saleItem) {
		// TODO - implement Sale.addSaleLineItem
		throw new UnsupportedOperationException();
	}

	/**
	 * Remove a SaleLineItem from the sale
	 * @param saleItem
	 */
	public void removeSaleLineItem(SaleLineItem saleItem) {
		// TODO - implement Sale.removeSaleLineItem
		throw new UnsupportedOperationException();
	}

	/**
	 * Calculate the total price of all items in the transaction including tax
	 */
	public BigDecimal calcTotal() {
		// TODO - implement Sale.calcTotal
		throw new UnsupportedOperationException();
	}

	/**
	 * Calculate the total price of all items in the transaction (not including tax)
	 */
	public BigDecimal calcSubTotal() {
		// TODO - implement Sale.calcSubTotal
		throw new UnsupportedOperationException();
	}

	/**
	 * Calculate the amount that need to be added to the subtotal due to tax
	 */
	public BigDecimal calcTax() {
		// TODO - implement Sale.calcTax
		throw new UnsupportedOperationException();
	}

	/**
	 * Determine how much money the customer has tendered towards their purchase
	 */
	public BigDecimal getTotalPayments() {
		// TODO - implement Sale.getTotalPayments
		throw new UnsupportedOperationException();
	}

	/**
	 * Determine whether the customer has provided enough money to purchase all of the items
	 */
	public Boolean isPaymentEnough() {
		// TODO - implement Sale.isPaymentEnough
		throw new UnsupportedOperationException();
	}

	/**
	 * Determine how much the customer must pay to purchase the selected items
	 * @param amountTendered
	 */
	public void calcAmountForPayment(BigDecimal amountTendered) {
		// TODO - implement Sale.calcAmountForPayment
		throw new UnsupportedOperationException();
	}

	/**
	 * Determine how much change the customer should get for their purchase
	 */
	public BigDecimal calcChange() {
		// TODO - implement Sale.calcChange
		throw new UnsupportedOperationException();
	}

	/**
	 * Total the amount of money the customer has tendered from all of their payment methods
	 */
	public BigDecimal calcAmountTendered() {
		// TODO - implement Sale.calcAmountTendered
		throw new UnsupportedOperationException();
	}

	/**
	 * Format the relevant information regarding a Sale into a single string that can be printed to a display
	 */
	public String toString() {
		// TODO - implement Sale.toString
		throw new UnsupportedOperationException();
	}


}