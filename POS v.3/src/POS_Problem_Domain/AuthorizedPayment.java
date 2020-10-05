package POS_Problem_Domain;

/**
 * Lays out alternative forms of payment besides cash
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
	 * Determine whether the payment method is Cash or Non-Cash	
	 */
	public Boolean countsAsCash() {
		return this.isAuthorized();
	}


}