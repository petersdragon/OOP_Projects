package POS_Problem_Domain;

import java.time.LocalDate;

/**
 * Using a Credit card as a payment method
 */
public class Credit extends AuthorizedPayment {

	/**
	 * The type of card being used in the transaction
	 */
	private String cardType;
	/**
	 * The account number associated with the card being used
	 */
	private String accountNumber;
	/**
	 * The card's expiration date
	 */
	private LocalDate expireDate;

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LocalDate getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 * Default Constructor
	 */
	public Credit() {
		// TODO - implement Credit.Credit
		throw new UnsupportedOperationException();
	}

	/**
	 * Constructor initializes the card type, account number, and the card's expiration date.
	 * @param cardType
	 * @param accountNumber
	 * @param expireDate
	 */
	public Credit(String cardType, String accountNumber, String expireDate) {
		// TODO - implement Credit.Credit
		throw new UnsupportedOperationException();
	}

	/**
	 * Determine whether the method of payment is valid
	 */
	public Boolean isAuthorized() {
		// TODO - implement Credit.isAuthorized
		throw new UnsupportedOperationException();
	}

	/**
	 * Format the relevant information into a single string that can be printed to a display
	 */
	public String toString() {
		// TODO - implement Credit.toString
		throw new UnsupportedOperationException();
	}


}