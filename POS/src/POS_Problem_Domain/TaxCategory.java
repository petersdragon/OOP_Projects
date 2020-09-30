package POS_Problem_Domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * The valid Tax categories that the store must use.
 */
public class TaxCategory {

	/**
	 * The name of the tax category
	 */
	private String taxCategory;
	/**
	 * The rates for this particular tax category
	 */
	private TreeSet<TaxRate> taxRates;

	public String getCategory() {
		return this.taxCategory;
	}

	public void setCategory(String taxCategory) {
		this.taxCategory = taxCategory;
	}

	private TreeSet<TaxRate> getTaxRates(){
		return this.taxRates;
	}
	
	/**
	 * Default Constructor
	 */
	public TaxCategory() {
		taxRates = new TreeSet<TaxRate>();
	}

	/**
	 * Constructor initializes the name of the tax category
	 * @param category
	 */
	public TaxCategory(String taxCategory) {
		this();
		this.setCategory(taxCategory);
	}

	/**
	 * For a given date, return the valid tax rates
	 * @param date
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) {
		TaxRate mostRecentRate = this.getTaxRates().first();
		
		for (TaxRate rate : this.getTaxRates()) {
			if (rate.compareTo(mostRecentRate) > 0)
				mostRecentRate = rate; // if rate is more recent than mostRecentRate
		}
		if (mostRecentRate == null)
			throw new NullPointerException(); // TODO - implement null error checking
		
		else
			return mostRecentRate.getTaxRate();
	}

	/**
	 * Add a new valid tax rate to the category
	 * @param taxRate
	 */
	public void addTaxRate(TaxRate taxRate) {
		this.taxRates.add(taxRate);
	}

	/**
	 * Remove a tax rate from the list of valid tax rates in this category
	 * @param taxRate
	 */
	public void removeTaxRate(TaxRate taxRate) {
		this.taxRates.remove(taxRate);
	}

	/**
	 * Format the relevant information regarding this Tax Category into a single string to be printed to a display
	 */
	public String toString() {
		String ratesString = "";
		
		for(TaxRate rate : this.taxRates) {
			ratesString += rate; // Add all the rates in the tax category to a single string.
		}
		
		return this.taxCategory + ": " + ratesString + " ";
	}


}