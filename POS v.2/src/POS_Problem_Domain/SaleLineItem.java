package POS_Problem_Domain;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * An item that is being sold.
 */
public class SaleLineItem {

	/**
	 * Specify the item being sold.
	 */
	private Item item;
	/**
	 * Specify the quantity of the item being sold.
	 */
	private int quantity;
	/**
	 * Information about the sale of which the SaleLineItem is a part
	 */
	private Sale sale;

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	/**
	 * Default Constructor
	 */
	public SaleLineItem() {
		// TODO - implement SaleLineItem.SaleLineItem
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructor initializing the sale  of which the SaleLineItem is a part, the item being sold, and how many of them are being sold.
	 * @param sale
	 * @param item
	 * @param quantity
	 * @param String
	 */
	public SaleLineItem(Sale sale, Item item, String quantity) {
		this.setSale(sale);
		this.setItem(item);
		this.setQuantity(new Integer(quantity));
		this.getSale().addSaleLineItem(this);
	}

	/**
	 * Calculate the total price of the Items in the SaleLineItem
	 */
	public BigDecimal calcSubTotal() {
		return this.getItem().calcAmountForDateQty(LocalDate.now(), this.getQuantity());
	}

	/**
	 * Calculate the tax for the SaleLineItem from the subtotal
	 */
	public BigDecimal calcTax() {
		return this.getItem().getTaxRateForDate(LocalDate.now()).getTaxRate().multiply(new BigDecimal(this.getQuantity()));
	}

	/**
	 * Format the relevant information regarding a SaleLineItem into a single string that can be printed to a display.
	 */
	public String toString() {
		return this.getItem().getNumber() + " " + this.getItem().getDescription() + " " + new Integer(this.getQuantity()).toString() + "@" + this.getItem().getPriceForDate(LocalDate.now()) + " " + this.getItem().getPriceForDate(LocalDate.now()).getEffectiveDate().toString() + " $" + this.calcSubTotal().toString();
	}


}