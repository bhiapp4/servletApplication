package org.jnit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jnit.domain.Customer;

public class CustomerDao {

	public int insertCustomer(Customer customer){
		int noOfRowsEffected = 0;
		try {
			Connection conn = getMeAConnection();
			String query = "insert into customer(name, street,city,state,country,zipcode) values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, customer.getName());
			pst.setString(2, customer.getStreet());
			pst.setString(3, customer.getCity());
			pst.setString(4, customer.getState());
			pst.setString(5, customer.getCountry());
			pst.setString(6, customer.getZipCode());
			
			noOfRowsEffected = pst.executeUpdate();
			//System.out.println(noOfRowsEffected);
			pst.close();
			conn.close();			
		}catch(Exception se){
			se.printStackTrace();
		}
		
		return noOfRowsEffected;
		
	}

	private Connection getMeAConnection() throws SQLException, ClassNotFoundException {
		Class.forName(com.mysql.jdbc.Driver.class.getName());
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatraining", "root", "");
		return conn;
	}

	public List<Customer> fetchCustomersByCity(String city) {
		List<Customer>customers = new ArrayList<>();
		try {
			Connection conn = getMeAConnection();
			String query = "select * from customer where city = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, city);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				Customer cust = new Customer();
				cust.setName(rs.getString("name"));
				cust.setCity(rs.getString("city"));
				cust.setCustomerId(rs.getInt("customerId"));
				cust.setState(rs.getString("state"));
				cust.setCountry(rs.getString("country"));
				customers.add(cust);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return customers;

	}
	
	
	public List<Customer> fetchCustomersByState(String state) {
		List<Customer>customers = new ArrayList<>();
		try {
			Connection conn = getMeAConnection();
			String query = "select * from customer where state = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, state);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				Customer cust = new Customer();
				cust.setName(rs.getString("name"));
				cust.setCity(rs.getString("city"));
				cust.setCustomerId(rs.getInt("customerId"));
				cust.setState(rs.getString("state"));
				cust.setCountry(rs.getString("country"));
				customers.add(cust);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return customers;

	}


}
