package com.qa.utils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class ItemController {
	static Scanner scan = ConsoleController.getScanner();
	
	public static void ItemMenu() throws SQLException {
		Items dbCon = new Items();
		
		Integer action = getMenu();
		
		try {
			do {
				switch(action) {
				case 1:
					System.out.println("Enter new Item name: ");
					String name = scan.next();
					scan.nextLine();
					System.out.println("Enter new Item price: ");
					BigDecimal price = scan.nextBigDecimal();
					dbCon.addItem(name, price);
					break;
				case 2:
					System.out.println("Enter Item ID you wish to delete: ");
					int id = scan.nextInt();
					dbCon.deleteItem(id);
					break;
				case 3: 
					System.out.println("Enter Item ID to update: ");
					int uId = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter new Item name: ");
					String uName = scan.next();
					scan.nextLine();
					System.out.println("Enter new Item price: ");
					BigDecimal uPrice = scan.nextBigDecimal();
					dbCon.updateItem(uId, uName, uPrice);
					break;
				case 4:
					System.out.println("Here are all the Items available...");
					dbCon.viewAllItem();
					break;
					default:
						System.out.println("WRONG NuMBER ENTERED");
						break;
				}
				action = getMenu();
				
			} while(!action.equals(5));
			System.out.println("App is closing...");
		} finally {
			scan.close();
			dbCon.closeDB();
			
		}
		
	}
	
	private static int getMenu() {
		// TODO Auto-generated method stub
		String startMenu = "==================== IMS Items System ====================\n"
	
				+ "\n\t \t1. Add New Item \t" + "\n"
				+ "\t \t2. Delete Existing Item \t" + "\n"
				+ "\t \t3. Update Existing Item \t" + "\n"
				+ "\t \t4. View All Existing Items \t" + "\n"
				+ "\t \t5. Exit App \t" + "\n"
				;
		System.out.println(startMenu + "\nENTER A NUMBER TO DO AN ACTION" );
		return scan.nextInt();
	}
	
}
