package POS_Problem_Domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Information regarding a temporary reduction of the regular sale price
 */
public class PromoPrice extends Price {

	/**
	 * The date on which the reduction in price will end
	 */
	private LocalDate endDate;

	public LocalDate getEndDate() {
		return this.endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * Default Constructor
	 */
	public PromoPrice() {
		System.out.println("There is no default constructor for PromoPrice.\n");
	}

	/**
	 * Constructor sets the price, start date for the sale, and end date for the sale.
	 * @param price
	 * @param effectiveDate
	 * @param endDate
	 */
	public PromoPrice(String price, String effectiveDate, String endDate, Item item) {
		super(price, effectiveDate, item);
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yy");
		this.setEndDate(LocalDate.parse(effectiveDate, dateFormat));
	}

	/**
	 * Determine whether the price reduction is in effect
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) {
		return this.getEffectiveDate().equals(date);
	}

	/**
	 * Compare this price to another to determine which is lower
	 * @param price
	 */
	public int compareTo(Price price) {
		return this.getEffectiveDate().compareTo(price.getEffectiveDate());
	}

	/**
	 * Format the relevant information regarding a PromoPrice into a single string that can be printed to a display.
	 */
	public String toString() {
		return this.getPrice().toString();
	}


}