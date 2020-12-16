package com.revature.repositories;

import java.sql.Connection;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.project0.Account;
import com.revature.project0.ConnectionFactory;
import com.revature.project0.Customer;

public class LoginDAO {

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public static Logger bankapp = LogManager.getLogger("com.revature.project0");
	
	public Customer DAOcustomerLogin(String username, String password) {
		
		Connection conn = this.cf.getConnection();
		
		try {
			String sql = "select * from customer where \"user_name\" = '" + username + "' and \"password\" = '" + password + "';";
			

			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			Customer c;
			
			
			
			while (res.next()) {
				
				
				c = new Customer();
				c.customerID = (res.getInt("customer_id"));
				c.customer_name = (res.getString("user_name"));
				c.password = (res.getString("password"));
				
				// make sure this works
				//Customer.customer_list.add(c);
				
				return c;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		bankapp.debug("Executed in LoginDAO: Customer has been returned from DB");
		
		return null;
	}

	public void DAOAccountRetrieve(Customer c) {
		
		Connection conn = this.cf.getConnection();
		
		
		
		try {
			String sql = "select \"account_name\", \"amount\" from \"account\" where \"customer_id\" = '" + c.customerID + "';";
			
			PreparedStatement getAccount = conn.prepareStatement(sql);
			ResultSet res = getAccount.executeQuery();
			
			while (res.next()) {
				Account a = new Account();
				a.AccountName = res.getString("account_name");
				a.amount = res.getDouble("amount");
				c.account_list.add(a);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			}
		
		bankapp.debug("Executed in LoginDAO: Account has been returned from DB");	
		
		}
		
		
		
		
		
	}

