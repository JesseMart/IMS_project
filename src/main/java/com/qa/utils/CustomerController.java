package com.qa.utils;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerController {

	static Scanner scan = ConsoleController.getScanner();
	
	public static void CustomerMenu() throws SQLException {
		
		Customer dbCon = new Customer();
		
		Integer action;
		action = getMenu();
		
		try {
			do {
				switch(action) {
				case 1:
					System.out.println("Enter new customer name: ");
					String cust_name = scan.next();
					dbCon.addCustomer(cust_name);
					break;
				case 2:
					System.out.println("Please enter ID number of of Customer desired to be deleted: ");
					int id = scan.nextInt();
					dbCon.deleteCustomer(id);
					break;
				case 3:
					System.out.println("Enter customer ID to update: ");
					int askId = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter new Customer name: ");
					String uName = scan.nextLine();
					dbCon.updateCustomer(askId, uName);
					break;
				case 4: 
					System.out.println("ALL CUSTOMER DATA...");
					dbCon.viewAllCust();
					break;
					default:
						System.out.println("TYPE A NUMBER");
						break;
				}
				action = getMenu();
			} while(!action.equals(5));
			System.out.println("App is closing...");
		} finally {
		
			scan.close();
			dbCon.closeDB();
			System.exit(0);
		}
		
		
	}

	private static int getMenu() {
		// TODO Auto-generated method stub
		String startMenu = "==================== IMS Customer System ====================\n"
	
				+ "\n\t \t1. Add New Customer \t" + "\n"
				+ "\t \t2. Delete Existing Customer \t" + "\n"
				+ "\t \t3. Update Existing Customer \t" + "\n"
				+ "\t \t4. View All Existing Customers \t" + "\n"
				+ "\t \t5. Exit App \t" + "\n"
				;
		System.out.println(startMenu + "\nENTER A NUMBER TO DO AN ACTION" );
		return scan.nextInt();
	}
		
}
	
	
	

