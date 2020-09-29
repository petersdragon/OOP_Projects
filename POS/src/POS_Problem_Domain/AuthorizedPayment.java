package POS_Problem_Domain;

/**
 * Lays out alternative forms of payment beside cash
 */
public abstract class AuthorizedPayment extends Payment {

	/**
	 * The valid code to allow this payment method
	 */
	private String authorizationCode;

	public String getAuthorizationCode() {
		return this.authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	/**
	 * Determine whether the payment method is valid
	 */
	public Boolean isAuthorized() {
		// TODO - implement AuthorizedPayment.isAuthorized
		throw new UnsupportedOperationException();
	}

	/**
	 * Determine whether the payment method is a valid payment method
	 */
	public Boolean countsAsCash() {
		// TODO - implement AuthorizedPayment.countsAsCash
		throw new UnsupportedOperationException();
	}


}