package POS_Problem_Domain;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The information regarding the cost to purchase an Item in the store.
 */
public class Price {

	/**
	 * The price of the item in question
	 */
	private BigDecimal price;
	/**
	 * The date on which this price goes into effect.
	 */
	private LocalDate effectiveDate;
	/**
	 * The item that the price corresponds to.
	 */
	private Item item;

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * Default Constructor
	 */
	public Price() {
		// TODO - implement Price.Price
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructor initializes the price of the item and the date the price will go into effect
	 * @param price
	 * @param effectiveDate
	 */
	public Price(String price, String effectiveDate) {
		
		this.setPrice(new BigDecimal(price));
		// TODO - implement Price.Price
		throw new UnsupportedOperationException();
	}

	/**
	 * Determine whether the price has gone into effect
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) {
		// TODO - implement Price.isEffective
		throw new UnsupportedOperationException();
	}

	/**
	 * Determine the cost when there is more than one of the item in question.
	 * @param quantity
	 */
	public BigDecimal calcAmountForQty(int quantity) {
		// TODO - implement Price.calcAmountForQty
		throw new UnsupportedOperationException();
	}

	/**
	 * Compare the price to another to determine which is lower
	 * @param price
	 */
	public int compareTo(Price price) {
		// TODO - implement Price.compareTo
		throw new UnsupportedOperationException();
	}

	/**
	 * Format the relevant information regarding Price into a single string that can be printed to a display.
	 */
	public String toString() {
		return "Price toString has not been set up yet.\n";
	}


}