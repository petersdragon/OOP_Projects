public class Dealer {

	private String name;
	private String address;
	private String phoneNumber;
	private Car[] cars;
	private int numCars;

	public Dealer() {
		cars = new Car[10];
		numCars = 0;
	}

	/**
	 * 
	 * @param address
	 * @param name
	 */
	public Dealer(String address, String name, String phoneNumber) {
		cars = new Car[10];
		numCars = 0;
		this.address = address;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 
	 * @param Car
	 */
	public void removeCar(Car car) {
		int carLocation = -1;
		
		for (int i=0; i < numCars; i++)
			if (cars[i]==car)
				carLocation = i;
		
		if (carLocation!= -1){
			for (int j=carLocation;j<numCars;j++)
				cars[j] = cars[j+1];
			
			numCars--;
		}

	}

	/**
	 * 
	 * @param Car
	 */
	public void addCar(Car car) {
		cars[numCars] = car;
		numCars++;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCarCount() {
		return numCars;
	}

	public Car[] getCars() {
		return cars;
	}

	public String toString() {
		return name + ", " + address + ". " + phoneNumber + " Total Value: $" + this.getRetailTotal();
	}

	public int getRetailTotal() {
		
		int retailTotal = 0;
		
		for (int i=0; i < numCars; i++)
			retailTotal += cars[i].getRetailPrice();
		
		return retailTotal;
		
	}
	
}