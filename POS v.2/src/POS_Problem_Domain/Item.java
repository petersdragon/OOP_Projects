package POS_Problem_Domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * Information regarding a given item for sale in the store
 */
public class Item {

	/**
	 * The identification number of the item available on the shelf
	 */
	private String number;
	/**
	 * A description providing information about the item available for sale.
	 */
	private String description;
	/**
	 * Information about the item selected for sale
	 */
	private ArrayList<SaleLineItem> saleLineItems;
	/**
	 * Universal Product Codes for the item
	 */
	private TreeMap<String, UPC> upcs;
	/**
	 * The different prices for the item. This is dependent on date, such as when there is a sale price in effect for a short time.
	 */
	private TreeSet<Price> prices;
	/**
	 * The tax category of the item being sold
	 */
	private TaxCategory taxCategory;

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<SaleLineItem> getSaleLineItems() {
		return this.saleLineItems;
	}

	public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems) {
		this.saleLineItems = saleLineItems;
	}

	public TreeMap<String, UPC> getUpcs() {
		return this.upcs;
	}

	public void setUpcs(TreeMap<String, UPC> upcs) {
		this.upcs = upcs;
	}

	public TreeSet<Price> getPrices() {
		return this.prices;
	}

	public void setPrices(TreeSet<Price> prices) {
		this.prices = prices;
	}

	public TaxCategory getTaxCategory() {
		return this.taxCategory;
	}

	public void setTaxCategory(TaxCategory taxCategory) {
		this.taxCategory = taxCategory;
	}

	/**
	 * Default Constructor
	 */
	public Item() {
		//Add UPC to Item?
		this.saleLineItems = new ArrayList<SaleLineItem>();
		this.upcs = new TreeMap<String, UPC>();
		this.prices = new TreeSet<Price>();
	}

	/**
	 * Constructor initializes the ID number of the item on the shelf and a description for that item
	 * @param number
	 * @param description
	 */
	public Item(String number, String description) {
		this(); // Call default constructor
		this.setNumber(number);
		this.setDescription(description);
	}

	/**
	 * Add a regular or sale price to the item
	 * @param price
	 */
	public void addPrice(Price price) {
		this.prices.add(price);
	}

	/**
	 * Remove a regular or sale price from the item
	 * @param price
	 */
	public void removePrice(Price price) {
		this.prices.remove(price);
	}

	/**
	 * Add a valid UPC to the item
	 * @param upc
	 */
	public void addUPC(UPC upc) {
		this.upcs.put(upc.getUpc(), upc);
	}

	/**
	 * Remove a UPC from the item
	 * @param upc
	 */
	public void removeUPC(UPC upc) {
		this.upcs.remove(upc.getUpc(), upc);
	}

	/**
	 * Determine the most recent price of the item for a given date
	 * @param date
	 */
	public Price getPriceForDate(LocalDate date) {
		Price mostRecentPrice = this.getPrices().first(); // Initalize with a valid value
		
		for (Price price : this.prices)
			if (price.compareTo(mostRecentPrice) > 0)
				mostRecentPrice = price; // if price is more recent than mostRecentPrice

		if (mostRecentPrice == null)
			// TODO - implement null error checking
			throw new NullPointerException();
		
		else
			return mostRecentPrice;
	}

	/**
	 * Determine the tax rate for an item on a given date
	 * @param date
	 */
	public TaxRate getTaxRateForDate(LocalDate date) {
		return this.getTaxCategory().getTaxRateForDate(date);
	}

	/**
	 * Determine the total cost of the item multiplied by the quantity being sold for a given date
	 * @param date
	 * @param quantity
	 */
	public BigDecimal calcAmountForDateQty(LocalDate date, int quantity) {
		return this.getPriceForDate(date).calcAmountForQty(quantity);
	}

	/**
	 * Format the relevant information regarding an Item into a single string that can be printed to a display
	 */
	public String toString() {
		// Format UPCs for the item
		String upcString = "";
		for (UPC upc : this.getUpcs().values())
			upcString += upc.toString() + " ";
		
		return this.getNumber() + " " + this.getDescription() + " Price: " + this.getPriceForDate(LocalDate.now()).toString() + " Tax Rate: " + this.getTaxRateForDate(LocalDate.now()) + " " + upcString;
	}


}