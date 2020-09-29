package POS_Problem_Domain;

/**
 * The UPC code for a particular item in the store
 */
public class UPC {

	/**
	 * The UPC code value
	 */
	private String upc;
	/**
	 * The item that the UPC corresponds to
	 */
	private Item item;

	public String getUpc() {
		return this.upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * Default Constructor
	 */
	public UPC() {
		this.getItem().addUPC(this);
	}

	/**
	 * Constructor initializes the value of the UPC code
	 * @param upc
	 */
	public UPC(String upc) {
		this();
		this.setUpc(upc);
	}

	/**
	 * Format the relevant information regarding a UPC into a single string to print to a display
	 */
	public String toString() {
		return upc;
	}

}