package POS_UI;

import POS_Problem_Domain.Store;
import Problem_Domain_Tests.StoreTest;

public class POS_Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store1 = new Store("1", "Peter's Hut In the Woods");

		
		store1.openStore();
		
		StoreTest storeTest = new StoreTest();		
		//storeTest.storeTest(store1); // POS v.1 hardcoded load
		storeTest.storePrint(store1);
		
	}

}
