package POS_Problem_Domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The information regarding a set tax rate, including whether it is in effect or not.
 */
public class TaxRate implements Comparable<TaxRate>{

	/**
	 * The value of the tax rate
	 */
	private BigDecimal taxRate;
	/**
	 * The date on which the tax rate goes into effect
	 */
	private LocalDate effectiveDate;

	public BigDecimal getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public LocalDate getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Default Constructor
	 */
	public TaxRate() {
		// TODO - implement TaxRate.TaxRate
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructor initializes the tax rate value and the date it is to go into effect
	 * @param effectiveDate
	 * @param rate
	 */
	public TaxRate(String rate, String effectiveDate) {
		this.setTaxRate(new BigDecimal(rate));

		this.setEffectiveDate(LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
	}

	/**
	 * Determines whether the tax rate is in effect
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) {
		return this.getEffectiveDate().equals(date);
	}

	/**
	 * Compares the tax rate to another tax rate to determine which one is higher
	 * For the statement date1.compareTo(date2), a positive value means that date1 is more recent,
	 * a negative value means date1 is less recent.
	 * @param taxRate
	 */
	public int compareTo(TaxRate taxRate) {
		return this.getEffectiveDate().compareTo(taxRate.getEffectiveDate());
	}

	/**
	 * Format the relevant information about a tax rate into a single string which can be printed to a display
	 */
	public String toString() {
		return this.taxRate + ", " + this.effectiveDate;
	}


}