package com.qa.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	
	private PreparedStatement ps;
	private Connection con;
	private ResultSet rs;
	
	
	public void addCustomer(String name) throws SQLException {
		ps = con.prepareStatement("INSERT INTO customers (name) VALUES (?)");
		ps.setString(1, name);
		ps.execute();
		
	}
	public void deleteCustomer(int id) throws SQLException {
		ps = con.prepareStatement("DELETE FROM customers WHERE id = ?");
		ps.setInt(1, id);
		ps.execute();
		
	}
	public void updateCustomer(int askId, String name) throws SQLException {
		ps = con.prepareStatement("UPDATE customers SET name = ? WHERE id = ?");
		ps.setInt(2, askId);
		ps.setString(1, name);
		ps.execute();
	}
	public void viewAllCust(String name) throws SQLException {
		ps = con.prepareStatement("SELECT * FROM customers");
		rs = ps.executeQuery();
		if(!rs.next()) {
			System.out.println("No customers in database.");
		} else {
			do {
				System.out.println(String.format("Customer name: %s", rs.getString("name")));
			} while(rs.next());
		}
	}
	
	
	

}
