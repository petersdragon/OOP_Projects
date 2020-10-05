package POS_Problem_Domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The information regarding the cost to purchase an Item in the store.
 */
public class Price implements Comparable<Price> {

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
		System.out.println("There is no default constructor for Price.\n");
	}

	/**
	 * Constructor initializes the price of the item and the date the price will go into effect, and the 
	 * @param price
	 * @param effectiveDate
	 */
	public Price(String price, String effectiveDate, Item item) {
		this.setPrice(new BigDecimal(price));
		this.setEffectiveDate(LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("M/d/yy")));
		this.setItem(item);
		this.getItem().addPrice(this);
	}

	/**
	 * Determine whether the price has gone into effect
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) {
		return this.getEffectiveDate().equals(date);
	}

	/**
	 * Determine the cost when there is more than one of the item in question.
	 * @param quantity
	 */
	public BigDecimal calcAmountForQty(int quantity) {
		return this.getPrice().multiply(new BigDecimal(quantity));
	}

	/**
	 * Compare the price to another to determine which is lower
	 * @param price
	 */
	public int compareTo(Price price) {
		return this.getEffectiveDate().compareTo(price.getEffectiveDate());
	}

	/**
	 * Format the relevant information regarding Price into a single string that can be printed to a display.
	 */
	public String toString() {
		return "$" + this.getPrice().toString();
	}

}