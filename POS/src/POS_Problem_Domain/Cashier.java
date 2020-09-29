package POS_Problem_Domain;

import java.util.*;

/**
 * The Person who is in charge of conducting sales to customers.
 */
public class Cashier {

	/**
	 * The identification number for the Cashier
	 */
	private String number;
	/**
	 * The Person filling the role of the Cashier
	 */
	private Person person;
	/**
	 * The session conducted by the cashier
	 */
	private ArrayList<Session> sessions;
	/**
	 * The authorization password associated with the cashier
	 */
	private String password;

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public ArrayList<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Default Constructor
	 */
	public Cashier() {
		// TODO - implement Cashier.Cashier
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructor initializes the identification number for the Cashier, the person filling the role, and the authorization password associated with that Cashier
	 * @param number
	 * @param person
	 * @param password
	 */
	public Cashier(String number, Person person, String password) {
		this();
		this.setNumber(number);
		this.setPerson(person);
		this.setPassword(password);
	}

	/**
	 * Add a session to the list of the sessions conducted by this Cashier
	 * @param session
	 */
	public void addSession(Session session) {
		this.sessions.add(session);
	}

	/**
	 * Remove a session conducted by this Cashier
	 * @param session
	 */
	public void removeSession(Session session) {
		this.sessions.remove(session);
	}

	/**
	 * Determine whether the Cashier is authorized to access the system and conduct the sales
	 * @param password
	 */
	public Boolean isAuthorized(String password) {
		return password.equals(this.getPassword());
	}

	/**
	 * Organize the relevant data related to the Cashier into a single string to print to a screen
	 */
	public String toString() {
		return this.person + " " + this.getNumber();
	}


}