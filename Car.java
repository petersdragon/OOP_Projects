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
	private char gear;

	public Car() {
		// TODO - implement Car.Car
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param vin
	 * @param make
	 * @param model
	 * @param year
	 * @param color
	 */
	public Car(String vin, String make, String model, int year, String color) {
		// TODO - implement Car.Car
		throw new UnsupportedOperationException();
	}

	public void go() {
		// TODO - implement Car.go
		throw new UnsupportedOperationException();
	}

	public void stop() {
		// TODO - implement Car.stop
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param direction
	 */
	public void turn(int direction) {
		// TODO - implement Car.turn
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO - implement Car.toString
		throw new UnsupportedOperationException();
	}

	public String getVIN() {
		// TODO - implement Car.getVIN
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param VIN
	 */
	public void setVIN(String VIN) {
		// TODO - implement Car.setVIN
		throw new UnsupportedOperationException();
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