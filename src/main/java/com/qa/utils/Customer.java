package com.qa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	
	private PreparedStatement ps;
	private Connection con;
	private ResultSet rs;
	

	public Customer() throws SQLException {
		con = DriverManager.getConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSW);
	}
	
	
	public void addCustomer(String name) throws SQLException {
		ps = con.prepareStatement("INSERT INTO customers (cust_name) VALUES (?)");
		ps.setString(1, name);
		ps.execute();
		
	}
	public void deleteCustomer(int id) throws SQLException {
		ps = con.prepareStatement("DELETE FROM customers WHERE cust_id = ?");
		ps.setInt(1, id);
		ps.execute();
		
	}
	public void updateCustomer(int askId, String name) throws SQLException {
		ps = con.prepareStatement("UPDATE customers SET cust_name = ? WHERE cust_id = ?");
		ps.setInt(2, askId);
		ps.setString(1, name);
		ps.execute();
	}
	public void viewAllCust() throws SQLException {
		ps = con.prepareStatement("SELECT * FROM customers");
		rs = ps.executeQuery();
		if(!rs.next()) {
			System.out.println("No customers in database.");
		} else {
			do {
				System.out.println(String.format("ID : %d , Customer name: %s",rs.getInt("cust_id"), rs.getString("cust_name")));
			} while(rs.next());
		}
	}
	
	public void closeDB() throws SQLException {
		con.close();
	}
	

}
