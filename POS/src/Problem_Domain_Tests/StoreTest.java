package Problem_Domain_Tests;

import java.math.BigDecimal;

import POS_Problem_Domain.*;

public class StoreTest {

	public void storeTest(Store store) {
		
		// Define People
		Person person1 = new Person("Jeff", "8492 NE 84th St", "Northrop", "NY", "39827", "738-726-1523", "637-362-3725");
		Person person2 = new Person("Martha", "4627 SE 63rd Place", "Bellay", "NY", "73827", "738-824-8123", "383-482-8632");
		Person person3 = new Person("Ferb", "9272 W 22nd Avenue", "Somewhere", "NY", "23423", "983-382-3726", "937-234-3234");
		
		// Define Cashiers
		Cashier cashier1 = new Cashier("1", person1, "1This is a password!");
		Cashier cashier2 = new Cashier("2", person2, "Hw93@u39$!ikr");
		Cashier cashier3 = new Cashier("3", person3, "IPromiseIWork@theStore333");
		
		// Define Registers and fill the drawers with cash
		Register register1 = new Register("1");
		register1.getCashDrawer().setCashAmount(new BigDecimal(100));
		Register register2 = new Register("2");
		register2.getCashDrawer().setCashAmount(new BigDecimal(240));
		
		// Define TaxRates
		TaxRate rate1 = new TaxRate("0.03", "11-Aug-2020");
		TaxRate rate2 = new TaxRate("0.05", "11-Aug-2020");
		TaxRate rate3 = new TaxRate("0.01", "11-Aug-2020");

		// Define TaxCategories and add rates
		TaxCategory taxCategory1 = new TaxCategory("Food");
		taxCategory1.addTaxRate(rate1);
		TaxCategory taxCategory2 = new TaxCategory("Home Goods");
		taxCategory2.addTaxRate(rate2);
		TaxCategory taxCategory3 = new TaxCategory("Decals");
		taxCategory3.addTaxRate(rate3);
				
		// Define Items and add TaxCategories
		Item item1 = new Item("1001", "Honey Cubes");
		item1.setTaxCategory(taxCategory1);
		Item item2 = new Item("2001", "Woven Basket");
		item2.setTaxCategory(taxCategory2);
		Item item3 = new Item("3001", "Jim's Icicles");
		item3.setTaxCategory(taxCategory3);

		// Define UPCs and link to Items
		UPC upc1 = new UPC("1938294918", item1);
		UPC upc2 = new UPC("7584625172", item2);
		UPC upc3 = new UPC("8492726424", item3);

		// Define Prices and link to Items
		Price price1 = new Price("1.00", "11-Aug-2020", item1);
		Price price2 = new Price("3.30", "11-Aug-2020", item2);
		Price price3 = new Price("1.80", "11-Aug-2020", item3);
		
		// Define Sales
		Sale sale1 = new Sale("False");
		Sale sale2 = new Sale("False");
		
		// Define SaleLineItems and add to the Sale
		SaleLineItem saleItem1 = new SaleLineItem(sale1, item1, "2");
		SaleLineItem saleItem2 = new SaleLineItem(sale1, item3, "1");
		SaleLineItem saleItem3 = new SaleLineItem(sale2, item1, "5");
		SaleLineItem saleItem4 = new SaleLineItem(sale2, item2, "2");
		
		// Define Session and add Sale
		Session session1 = new Session(cashier2, register1);
		session1.addSale(sale1);	
		session1.addSale(sale2);
		
		// Add everything to the Store
		store.addCashier(cashier1);
		store.addCashier(cashier2);
		store.addCashier(cashier3);
		store.addItem(item1);
		store.addItem(item2);
		store.addItem(item3);
		store.addRegister(register1);
		store.addRegister(register2);
		store.addTaxCategory(taxCategory1);
		store.addTaxCategory(taxCategory2);
		store.addTaxCategory(taxCategory3);
		store.addUPC(upc1);
		store.addUPC(upc2);
		store.addUPC(upc3);
		store.addSession(session1);
		
	}
	
	public void storePrint(Store store) {
		// Print out the information relevant to the Store
		System.out.println(store.toString());
	}
}
