package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.qa.utils.ConsoleController;
import com.qa.utils.CustomerController;
import com.qa.utils.ItemController;
import com.qa.utils.OrderController;

public class Runner {
	
	static Scanner scan = ConsoleController.getScanner();

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		
		
		Integer action;
		action = getMenu();
		
		try {
			do {
				switch(action) {
				case 1:
					CustomerController.CustomerMenu();
					break;
				case 2:
					ItemController.ItemMenu();
					break;
				case 3:
					OrderController.OrderMenu();
					break;
					default:
						System.out.println("Number was not an option.");
						break;
				}
				action = getMenu();
			} while(!action.equals(4));
			System.out.println("App is closing...");
		} finally {
			scan.close();
			System.exit(0);
		}
		
		
	}

	private static int getMenu() {
		// TODO Auto-generated method stub
		String startMenu = "==================== IMS System ====================\n"
	
				+ "\n\t \t1. Customer Information \t" + "\n"
				+ "\t \t2. Items Information \t" + "\n"
				+ "\t \t3. Orders Information \t" + "\n"
				+ "\t \t4. Exit Application \t" + "\n"
				;
		System.out.println(startMenu + "\nENTER A NUMBER TO SEE MORE INFO" );
		return scan.nextInt();
	}

}
