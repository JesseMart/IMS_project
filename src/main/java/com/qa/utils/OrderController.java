package com.qa.utils;

import java.sql.SQLException;
import java.util.Scanner;

public class OrderController {

	
	static Scanner scan = ConsoleController.getScanner();
	
	public static void OrderMenu() throws SQLException {
		
		Orders dbCon = new Orders();
		
		Integer action;
		action = getMenu();
		
		try {
			do {
				switch(action) {
				case 1:
					System.out.println("Enter new customer ID for order: ");
					int custID = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter new Item ID for order: ");
					int itemID = scan.nextInt();
					dbCon.createOrder(custID, itemID);
					System.out.println("Order Was Created!");
					break;
				case 2:
					System.out.println("Enter Order ID to delete: ");
					int ordID = scan.nextInt();
					dbCon.deleteOrder(ordID);
					System.out.println("Order Was DELETED");
					break;
				case 3:
					System.out.println("Enter Customer ID to view Price Order: ");
					int cId = scan.nextInt();
					scan.nextLine();
					dbCon.getOrderCost(cId);
					break;
				case 4: 
					System.out.println("ALL ACTIVE ORDERS...");
					dbCon.viewOrders();
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
		String startMenu = "==================== IMS ORDER System ====================\n"
	
				+ "\n\t \t1. Add New Order \t" + "\n"
				+ "\t \t2. Delete Existing Order \t" + "\n"
				+ "\t \t3. Price Of Existing Order \t" + "\n"
				+ "\t \t4. View All Existing Customers \t" + "\n"
				+ "\t \t5. Exit App \t" + "\n"
				;
		System.out.println(startMenu + "\nENTER A NUMBER TO DO AN ACTION" );
		return scan.nextInt();
	}
}
