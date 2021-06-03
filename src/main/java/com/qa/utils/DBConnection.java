package com.qa.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;





public class DBConnection {
	
	private static String URL;
	private static String USERNAME;
	private static String PASSW;
	
	
	private static Connection aConnection;
	
	public static void initialConnect () {
		askLogin();
		
		try {
			aConnection = DriverManager.getConnection(URL, USERNAME, PASSW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void askLogin() {
		
		Scanner scanner = ConsoleController.getScanner();
		
		System.out.println("Enter url server address: ");
		URL = scanner.nextLine();
		System.out.println("Enter username: ");
		USERNAME = scanner.nextLine();
		System.out.println("Enter password: ");
		PASSW = scanner.nextLine();
	}
	
}
