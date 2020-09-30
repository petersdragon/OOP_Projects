package POS_Problem_Domain;

/**
 * A human being who has common personal information associated with them.
 */
public class Person {

	/**
	 * The name of the individual
	 */
	private String name;
	/**
	 * The address of the individual's place of residence
	 */
	private String address;
	/**
	 * The city of the individual's place of residence
	 */
	private String city;
	/**
	 * The state in which the individual resides
	 */
	private String state;
	/**
	 * The zip code of the individual's place of residence
	 */
	private String zip;
	/**
	 * The Phone Number of the individual
	 */
	private String phone;
	/**
	 * The Social Security Number of the individual
	 */
	private String ssn;
	/**
	 * The information associated with a Cashier interacting with the system
	 */
	private Cashier cashier;
	/**
	 * Return the name of the person
	 * 
	 * @return the name of the person
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Set the name of the person
	 * 
	 * @param name of the person as a string
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Return the address of the person
	 * 
	 * @return the address of the person
	 */
	public String getAddress() {
		return this.address;
	}
	/**
	 * Set the address of the person
	 * 
	 * @param address of the person as a string
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Return the city the person lives in
	 * 
	 * @return the city the person lives in
	 */
	public String getCity() {
		return this.city;
	}
	/**
	 * Set the city the person lives in
	 * 
	 * @param city the person lives in as a string
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * Get the state the person lives in
	 * 
	 * @param state the person lives in as a string
	 */
	public String getState() {
		return this.state;
	}
	/**
	 * Set the state the person lives in
	 * 
	 * @param state the person lives in as a string
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * Get the zip code of the person
	 * 
	 * @param zip code of the person
	 */
	public String getZip() {
		return this.zip;
	}
	/**
	 * Set the zip code of the person
	 * 
	 * @param zip code of the person
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return this.phone;
	}
	/**
	 * Set the SSN of the person
	 * 
	 * @param SSN of the person
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSSN() {
		return this.ssn;
	}
	/**
	 * Set the SSN of the person
	 * 
	 * @param SSN of the person
	 */
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	/**
	 * Get the information of the person filling the role of Cashier
	 * 
	 * @param Cashier information associated with the Person
	 */
	public Cashier getCashier() {
		return this.cashier;
	}
	/**
	 * Set the information of the person filling the role of Cashier
	 * 
	 * @param Cashier information associated with the Person
	 */
	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	/**
	 * Default Constructor for a Person
	 */
	public Person() {
		// TODO - implement Person.Person
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructor which sets the personal identification information for a specific Person
	 * @param name
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param ssn
	 */
	public Person(String name, String address, String city, String state, String zip, String phone, String ssn) {
		this.setName(name);
		this.setAddress(address);
		this.setCity(city);
		this.setState(state);
		this.setZip(zip);
		this.setPhone(phone);
		this.setSSN(ssn);
	}

	/**
	 * Format the relevant information about a Person into a single string to print out.
	 */
	public String toString() {
		return this.getName() + " " + this.getAddress() + " " + this.getCity() + ", " + this.getState() + ", " + this.getZip() + " Phone: " + this.getPhone() + " SSN: " + this.getSSN();
	}


}