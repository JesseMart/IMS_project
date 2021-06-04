package com.qa.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Orders {

	private PreparedStatement ps;
	private Connection con;
	private ResultSet rs;
	
	
	public Orders() throws SQLException {
		con = DriverManager.getConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSW);
	}
	
	public void createOrder(int custId, int itemId) throws SQLException {
		ps = con.prepareStatement("INSERT INTO order_items (fk_cust_id, fk_item_id) VALUES (?, ?)");
		ps.setInt(1, custId);
		ps.setInt(2, itemId);
		ps.execute();
		
	}
	public void deleteOrder(int orderId) throws SQLException {
		ps = con.prepareStatement("DELETE FROM order_items WHERE order_id = ?");
		ps.setInt(1, orderId);
		ps.execute();
	}
	public void viewOrders() throws SQLException {
		ps = con.prepareStatement("SELECT o.order_id, c.cust_id, c.cust_name, i.item_id,"
				+ " i.item_name, i.price "
				+ "FROM customers c "
				+ "JOIN order_items o ON fk_cust_id = c.cust_id "
				+ "JOIN items i ON fk_item_id = i.item_id ");
		rs = ps.executeQuery();
		if(!rs.next()) {
			System.out.println("No active orders found!");
		} else {
			do {
				System.out.println(String.format("CustomerName: %s , ItemOrdered: %s", rs.getString("cust_name"), rs.getString("item_name")));
				
			} while(rs.next());
		}	
	}
	
	public void getOrderCost(int cId) throws SQLException { 
		ps = con.prepareStatement("SELECT o.order_id, c.cust_name, i.item_name, i.price"
				+ " FROM customers c "
				+ "JOIN order_items o ON fk_cust_id = c.cust_id "
				+ "JOIN items i ON fk_item_id = i.item_id "
				+ "WHERE c.cust_id = ?");
		ps.setInt(1, cId);
		rs = ps.executeQuery();
		if(!rs.next()) {
			System.out.println("No orders for this customer found.");
		} else {
			do {
				System.out.println(String.format("OrderID: %d, Name: %s, Item Name: %s, Price: %.2f", rs.getInt("order_id"), rs.getString("cust_name"),rs.getString("item_name"), rs.getDouble("price")));
			} while(rs.next());
		}
		
		
	}
	public void closeDB() throws SQLException {
		con.close();
	}
	
	
	
}
