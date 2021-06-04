package com.qa.utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Items {
	
	private PreparedStatement ps;
	private Connection con;
	private ResultSet rs;
	
	
	public Items() throws SQLException {
		con = DriverManager.getConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSW);
	}
	
	public void addItem(String name, BigDecimal price) throws SQLException {
		ps = con.prepareStatement("INSERT INTO items (item_name, price) VALUES (?, ?)");
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
		ps = con.prepareStatement("UPDATE items SET item_name = ?, price = ? WHERE item_id = ?");
		ps.setInt(2, uId);
		ps.setString(1, name);
		ps.execute();
	}
	public void viewAllItem() throws SQLException {
		ps = con.prepareStatement("SELECT * FROM items");
		rs = ps.executeQuery();
		if(!rs.next()) {
			System.out.println("No items in database.");
		} else {
			do {
				System.out.println(String.format("Item ID: %d, Item name: %s ,Price: %d",rs.getInt("item_id"), rs.getString("item_name"), rs.getBigDecimal("price")));
			} while(rs.next());
		}
	}
	
	public void closeDB() throws SQLException {
		con.close();
	}
	
	

}
