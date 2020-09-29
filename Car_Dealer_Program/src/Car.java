import java.util.*;

public class Car {

	Collection<Dealer> cars;
	private String vin;
	private String make;
	private String model;
	private int year;
	private String color;
	private int mileage;
	private int speed;
	private int retailPrice;
	private char gear;

	public Car() {
		this.mileage = 0;
		this.gear = 'P';
		this.speed = 0;
	}

	/**
	 * 
	 * @param vin
	 * @param make
	 * @param model
	 * @param year
	 * @param color
	 */
	public Car(String vin, String make, String model, int year, String color, int mileage, int retailPrice) {
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.mileage = mileage;
		this.gear = 'P';
		this.speed = 0;
		this.retailPrice = retailPrice;
	}

	public String toString() {
		return year + " " + make + " " + model + " " + mileage + " VIN: " + vin + " Retail: $" + retailPrice;
	}

	public String getVIN() {
		return vin;
	}

	/**
	 * 
	 * @param VIN
	 */
	public void setVIN(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return this.make;
	}

	/**
	 * 
	 * @param make
	 */
	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return this.model;
	}

	/**
	 * 
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return this.color;
	}

	/**
	 * 
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	public int getMileage() {
		return this.mileage;
	}

	/**
	 * 
	 * @param mileage
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getSpeed() {
		return this.speed;
	}

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRetailPrice() {
		return this.retailPrice;
	}

	public void setRetailPrice(int retailPrice) {
		this.retailPrice = retailPrice;
	}
	
	public char getGear() {
		return this.gear;
	}

	/**
	 * 
	 * @param gear
	 */
	public void setGear(char gear) {
		this.gear = gear;
	}

	
}