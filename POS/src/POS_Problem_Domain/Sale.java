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
	private ArrayList<Payment> payments;
	/**
	 * The information regarding the items being sold
	 */
	private ArrayList<SaleLineItem> saleLineItems;
	/**
	 * The date and time at which the purchase took place
	 */
	private LocalDateTime dateTime;
	/**
	 * Determine whether tax should be factored into the final price
	 */
	private Boolean taxFree;

	public ArrayList<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}

	public ArrayList<SaleLineItem> getSaleLineItems() {
		return this.saleLineItems;
	}

	public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems) {
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
		this.payments = new ArrayList<Payment>();
		this.saleLineItems = new ArrayList<SaleLineItem>();
	}

	/**
	 * Constructor sets the string to determine whether the sale should be tax free
	 * @param taxFree
	 */
	public Sale(String taxFree) {
		this();
		this.setTaxFree(Boolean.parseBoolean(taxFree));
	}

	/**
	 * Add a valid method of payment to purchase the items
	 * @param payment
	 */
	public void addPayment(Payment payment) {
		this.getPayments().add(payment);
	}

	/**
	 * Remove a method of payment from the sale
	 * @param payment
	 */
	public void removePayment(Payment payment) {
		this.getPayments().remove(payment);
	}

	/**
	 * Add a SaleLineItem describing what item is being sold in what quantity
	 * @param saleItem
	 */
	public void addSaleLineItem(SaleLineItem saleItem) {
		this.getSaleLineItems().add(saleItem);
	}

	/**
	 * Remove a SaleLineItem from the sale
	 * @param saleItem
	 */
	public void removeSaleLineItem(SaleLineItem saleItem) {
		this.getSaleLineItems().remove(saleItem);
	}

	/**
	 * Calculate the total price of all items in the transaction including tax
	 */
	public BigDecimal calcTotal() {
		return this.calcSubTotal().add(this.calcTax());
	}

	/**
	 * Calculate the total price of all items in the transaction (not including tax)
	 */
	public BigDecimal calcSubTotal() {
		BigDecimal subTotal = new BigDecimal(0);
		for (SaleLineItem saleItem : this.getSaleLineItems())
			subTotal.add(saleItem.calcSubTotal());
		return subTotal;
	}

	/**
	 * Calculate the amount that need to be added to the subtotal due to tax
	 */
	public BigDecimal calcTax() {
		BigDecimal taxTotal = new BigDecimal(0);
		for (SaleLineItem saleItem : this.getSaleLineItems())
			taxTotal.add(saleItem.calcTax());
		return taxTotal;
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
	 * Returns a value greater than 0 if the payment is enough
	 */
	public Boolean isPaymentEnough() {
		Boolean isEnough = (this.calcAmountTendered().compareTo(this.calcTotal()) >= 0);
		return isEnough;
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
		return this.calcAmountTendered().subtract(this.calcTotal());
	}

	/**
	 * Total the amount of money the customer has tendered from all of their payment methods
	 */
	public BigDecimal calcAmountTendered() {
		BigDecimal totalPaid = new BigDecimal(0);
		for (Payment payment : this.getPayments())
			totalPaid.add(payment.getAmountTendered());
		return totalPaid;
	}

	/**
	 * Format the relevant information regarding a Sale into a single string that can be printed to a display
	 */
	public String toString() {
		// Format the SaleLineItems into a single string
		String saleItemsString = "";
		for (SaleLineItem saleItem : this.getSaleLineItems())
			saleItemsString += saleItem.toString() + "\n";

		return "Sale: Subtotal: " + this.calcSubTotal() + " Tax: " + this.calcTax() + " Total: " + this.calcTotal() + " Payment: " + this.calcAmountTendered() + " Change: " + this.calcChange() + "\n" + saleItemsString;
	}


}