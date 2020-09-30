package POS_Problem_Domain;

import java.util.*;

/**
 * The information regarding a store at a single location
 */
public class Store {

	/**
	 * The number of the store for a chain
	 */
	private String number;
	/**
	 * The name of the store chain
	 */
	private String name;
	/**
	 * The tax categories that the store deals with
	 */
	private TreeMap<String, TaxCategory> taxCategories;
	/**
	 * The items that are available for purchase in the store
	 */
	private TreeMap<String, Item> items;
	/**
	 * The cashiers who work at the store
	 */
	private TreeMap<String, Cashier> cashiers;
	/**
	 * The registers that are used in the store
	 */
	private TreeMap<String, Register> registers;
	/**
	 * The sale sessions that occur in the store
	 */
	private ArrayList<Session> sessions;
	/**
	 * The UPCs of the items in the store
	 */
	private TreeMap<String, UPC> upcs;

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeMap<String, TaxCategory> getTaxCategories() {
		return this.taxCategories;
	}

	public void setTaxCategories(TreeMap<String, TaxCategory> taxCategories) {
		this.taxCategories = taxCategories;
	}

	public TreeMap<String, Item> getItems() {
		return this.items;
	}

	public void setItems(TreeMap<String, Item> items) {
		this.items = items;
	}

	public TreeMap<String, Cashier> getCashiers() {
		return this.cashiers;
	}

	public void setCashiers(TreeMap<String, Cashier> cashiers) {
		this.cashiers = cashiers;
	}

	public TreeMap<String, Register> getRegisters() {
		return this.registers;
	}

	public void setRegisters(TreeMap<String, Register> registers) {
		this.registers = registers;
	}

	public ArrayList<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

	public TreeMap<String, UPC> getUpcs() {
		return this.upcs;
	}

	public void setUpcs(TreeMap<String, UPC> upcs) {
		this.upcs = upcs;
	}

	/**
	 * Default Constructor
	 */
	public Store() {
		this.taxCategories = new TreeMap<String, TaxCategory>();
		this.items = new TreeMap<String, Item>();
		this.cashiers = new TreeMap<String, Cashier>();
		this.registers = new TreeMap<String, Register>();
		this.sessions = new ArrayList<Session>();
		this.upcs = new TreeMap<String, UPC>();
	}

	/**
	 * Constructor initializes the store number and the name of the store
	 * @param number
	 * @param name
	 */
	public Store(String number, String name) {
		this();
		this.setNumber(number); // Set the store's number
		this.setName(name); // Set the store's name
	}

	/**
	 * Add an item to the shelf in the store
	 * @param item
	 */
	public void addItem(Item item) {
		this.items.put(item.getNumber(), item);
	}

	/**
	 * Remove an item from the shelf in the store
	 * @param item
	 */
	public void removeItem(Item item) {
		this.items.remove(item.getNumber(), item);
	}

	/**
	 * Add the UPC of an item in the store
	 * @param upc
	 */
	public void addUPC(UPC upc) {
		this.upcs.put(upc.getUpc(), upc);
	}

	/**
	 * Remove the UPC of an item from the store
	 * @param upc
	 */
	public void removeUPC(UPC upc) {
		this.upcs.remove(upc.getUpc(), upc);
	}

	/**
	 * Add a register to the store
	 * @param register
	 */
	public void addRegister(Register register) {
		this.registers.put(register.getNumber(), register);
	}

	/**
	 * Remove a register from the store
	 * @param register
	 */
	public void removeRegister(Register register) {
		this.registers.remove(register.getNumber(), register);
	}

	/**
	 * Add a new cashier to the store
	 * @param cashier
	 */
	public void addCashier(Cashier cashier) {
		this.cashiers.put(cashier.getNumber(), cashier);
	}

	/**
	 * Remove a cashier from the store
	 * @param cashier
	 */
	public void removeCashier(Cashier cashier) {
		this.cashiers.remove(cashier.getNumber(), cashier);
	}

	/**
	 * Add a tax category the store deals with
	 * @param taxCategory
	 */
	public void addTaxCategory(TaxCategory taxCategory) {
		this.taxCategories.put(taxCategory.getCategory(), taxCategory);
	}

	/**
	 * Remove a tax category from the store
	 * @param taxCategory
	 */
	public void removeTaxCategory(TaxCategory taxCategory) {
		this.taxCategories.remove(taxCategory.getCategory(), taxCategory);
	}

	/**
	 * Add a new session to the store
	 * @param session
	 */
	public void addSession(Session session) {
		this.sessions.add(session);
	}

	/**
	 * Remove a session from the store
	 * @param session
	 */
	public void removeSession(Session session) {
		this.sessions.remove(session);
	}

	/**
	 * Find a register based on its identifying number
	 * @param number
	 */
	public Register findRegisterByNumber(String number) {		
		return this.registers.get(number);
	}

	/**
	 * Find an item in the store based on its UPC
	 * @param upc
	 */
	public Item findItemByUPC(String upc) {
		return this.items.get(upc);
	}

	/**
	 * Find an item based on its identifying number
	 * @param number
	 */
	public Item findItemByNumber(String number) {
		return this.items.get(number);
	}

	/**
	 * Find a cashier based on their employee number
	 * @param number
	 */
	public Cashier findCashierByNumber(String number) {
		return this.cashiers.get(number);
	}

	/**
	 * Find a tax category based on its name
	 * @param category
	 */
	public TaxCategory findTaxCategoryByName(String category) {
		return this.taxCategories.get(category);
	}

	/**
	 * Format the relevant information regarding a store into a single string that can be printed to a display.
	 */
	public String toString() {		
		return this.getName() + "\n==========\nCashiers\n==========\\n" + this.getCashiers().toString() + "\n==========\nRegisters\n==========\\n" + this.getRegisters().toString() + "\n==========\nItems\n==========\\n" + this.getItems().toString() + "\n==========\nSessions\n==========\\n" + this.getSessions().toString() + "\n==========\n";
	}


}