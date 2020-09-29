
public class Test {

	public static void main(String[] args) {
		
		Dealer dealer;
		
		dealer = new Dealer("Moore, OK", "Moore Car Deals", "405-555-5555");
		
		Car car1 = new Car("ID194583923", "GMC", "Envoy", 2005, "Silver", 215029, 3500);
		dealer.addCar(car1);
		
		Car car2 = new Car("DU602968264", "Toyota", "Corolla", 2017, "Blue", 78083, 7800);
		dealer.addCar(car2);
		
		Car car3 = new Car("HR289673643", "Chevrolet", "Malibu", 1998, "Gold", 238493, 2400);
		dealer.addCar(car3);
		
		Car car4 = new Car("KF96714489", "Chevrolet", "Suburban", 2006, "White", 254827, 3700);
		dealer.addCar(car4);

		System.out.println(dealer);
		for(int i = 0; i < dealer.getCarCount(); i++)
			System.out.println(dealer.getCars()[i]);
				
		dealer.removeCar(car3);

		System.out.println();

		System.out.println(dealer);
		for(int i = 0; i < dealer.getCarCount(); i++)
			System.out.println(dealer.getCars()[i]);

	}

}
