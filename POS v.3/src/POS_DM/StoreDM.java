package POS_DM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import POS_Problem_Domain.*;

public class StoreDM {
	
	/**
	 * Get all of the information regarding the store from the csv file are load it into the Store
	 * @param store
	 */
	public static void loadStore(Store store) {
		
		String fileName ="StoreData_v2020.csv";
		String line = null;
		String dataType; 
	    try {
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = new FileReader(fileName);

	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        // Hold the most recent Session to add more Sales to
	        Session currentSession = null;
	        // Hold the most recent Sale to add more SaleLineItems to
        	Sale currentSale = null;
        	
	        while((line = bufferedReader.readLine()) != null) {
	        	//<  do stuff to line>
	        	String[] splitLine = line.split(",");
	        	
	        	dataType = splitLine[0];
	        	
	        	if (dataType.equals("Store"))
	        		store.setName(splitLine[1]);
	        	
	        	else if (dataType.equals("TaxCategory")) {
	        		TaxCategory taxCategory = new TaxCategory(splitLine[1], splitLine[3], splitLine[2]);
	        		store.addTaxCategory(taxCategory);
	        	}
	        	
	        	else if (dataType.equals("Cashier")) {
	        		Person person = new Person(splitLine[2], splitLine[4], splitLine[5], splitLine[6], splitLine[7], splitLine[8], splitLine[3]);
	        		Cashier cashier = new Cashier(splitLine[1], person, splitLine[9]);
	        		store.addCashier(cashier);
	        	}
	        	
	        	else if (dataType.equals("Item")) {
	        		Item item = new Item(splitLine[1], splitLine[3]);
	        		item.setTaxCategory(store.findTaxCategoryByName(splitLine[4]));
    				new Price(splitLine[5], splitLine[6], item);
    				if (splitLine.length > 7 ) {
        				new PromoPrice(splitLine[7], splitLine[8], splitLine[9], item);
	        		}
	        		new UPC(splitLine[2], item);
	        		store.addItem(item);
	        	}
	        	
	        	else if (dataType.equals("Register")) {
	        		Register register = new Register(splitLine[1]);
	        		store.addRegister(register);
	        	}
	        	
	        	else if (dataType.equals("Session")) {
	        		currentSession = new Session(store.findCashierByNumber(splitLine[1]),store.findRegisterByNumber(splitLine[2]));
	        		store.addSession(currentSession);
	        		store.findCashierByNumber(splitLine[1]).addSession(currentSession);
	        	}
	        		        	
	        	else if (dataType.equals("Sale")) {
	        		if (currentSession != null) {
	        			currentSale = new Sale(splitLine[1]);
	        			currentSession.addSale(currentSale);
	        		}
	        	}

	        	else if (dataType.equals("SaleLineItem")) {
	        		if (currentSale != null) {
	        			new SaleLineItem(currentSale, store.findItemByNumber(splitLine[1]),splitLine[2]);
	        		}
	        	}

	        	else if (dataType.equals("Payment")) {
	        		if (splitLine[1].equals("Cash")) {
		        		currentSale.addPayment(new Cash(splitLine[2], splitLine[3]));
	        		}
	        		else if (splitLine[1].equals("Credit")) {
	        			currentSale.addPayment(new Credit(splitLine[2], splitLine[3], splitLine[4], splitLine[5], splitLine[6]));
	        		}
	        		else if (splitLine[1].equals("Check")) {
		        		currentSale.addPayment(new Check(splitLine[2], splitLine[3], splitLine[4], splitLine[5], splitLine[6]));
	        		}
	        	}
	        } // end while    
	    
	        // Always close files.
	        bufferedReader.close();            
	    } // end Try
	    catch(FileNotFoundException exception) {
	    	System.out.println("Unable to open file '" +  fileName + "'");
	    } // end catch
	    catch(IOException exception) {
	    	System.out.println ("Error reading file '" + fileName + "'");
	    } // end catch
		
	} // end loadStore
	
} // end StoreDM
