package com.qa.utils;

import java.util.Scanner;

public class ConsoleController {
		
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static Scanner getScanner() {
		return scanner;
	}
	
	public static void close() {
		scanner.close();
	}
}
