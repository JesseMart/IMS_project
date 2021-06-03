package com.qa.utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Items {
	
	private PreparedStatement ps;
	private Connection con;
	private ResultSet rs;
	
	
	public void addItem(String name, BigDecimal price) throws SQLException {
		ps = con.prepareStatement("INSERT INTO items (name, price) VALUES (?)");
		ps.setString(1, name);
		ps.setBigDecimal(2, price);
		ps.execute();
		
	}
	public void deleteItem(int id) throws SQLException {
		ps = con.prepareStatement("DELETE FROM items WHERE item_id = ?");
		ps.setInt(1, id);
		ps.execute();
		
	}
	public void updateItem(int uId, String name, BigDecimal price) throws SQLException {
		ps = con.prepareStatement("UPDATE items SET name = ?, price = ? WHERE item_id = ?");
		ps.setInt(2, uId);
		ps.setString(1, name);
		ps.execute();
	}
	public void viewAllItem(String name) throws SQLException {
		ps = con.prepareStatement("SELECT * FROM items");
		rs = ps.executeQuery();
		if(!rs.next()) {
			System.out.println("No items in database.");
		} else {
			do {
				System.out.println(String.format("Customer name: %s", rs.getString("name")));
			} while(rs.next());
		}
	}
	
	
	

}
