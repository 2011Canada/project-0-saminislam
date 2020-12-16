package com.revature.repositories;

import com.revature.project0.Account;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.revature.project0.ConnectionFactory;
import com.revature.project0.Customer;

import java.sql.*;


public class CustomerDAO {

	public static Logger bankapp = LogManager.getLogger("com.revature.project0");
	
	ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public void DAOcreateCustomer (Customer c) {
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "insert into \"customer\" (\"user_name\",\"password\") "
					+ "values (?, ?) "
					+ "returning \"customer_id\";";
			
			PreparedStatement customer_insert = conn.prepareStatement(sql);
			
			customer_insert.setString(1, c.customer_name);
			customer_insert.setString(2,c.password);
			
			ResultSet res = customer_insert.executeQuery();
			
			if (res.next()) {
				c.customerID = res.getInt("customer_id");
			}	else {
				throw new SQLException();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		bankapp.debug("Executed in CustomerDAO: Customer has been inserted into DB");
		
	}
	
	public void DAOcreateAccount (Account a) {
		Connection conn = cf.getConnection();
	
	
	try {
		String sql = "insert into \"account\" (\"account_name\",\"amount\",\"customer_id\") " 
				+ "values (?, ?, ?);";
	
		PreparedStatement account_insert = conn.prepareStatement(sql);
		
		account_insert.setString(1, a.AccountName);
		account_insert.setDouble(2, a.amount);
		account_insert.setInt(3, a.customerID);
		
		account_insert.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	
	bankapp.debug("Executed in LoginDAO: Account has been inserted into DB");
	
	}
	
	
public void DAOviewAccount(Customer c) {
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "select \"account_name\", \"amount\" from \"account\" where \"customer_id\" = '" + c.customerID + "';";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet res = ps.executeQuery();
			
			
			while (res.next()) {
				System.out.println("Account name: " + res.getString("account_name") + "		Amount: " + res.getDouble("amount"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		bankapp.debug("Executed in LoginDAO: Account has been recovered from DB");
		
	}

public void DAOdeposit(double d_amount, Account a) {
	
	//A.deposit(d_amount, A);
	Connection conn = cf.getConnection();
	
	try {
		String sql = "update \"account\" set \"amount\" = " + a.amount + " where \"account_name\" = '" + a.AccountName + "';";
		
		Statement depositFunds = conn.createStatement();
		depositFunds.executeUpdate(sql);
		
	} catch (SQLException ex) {
		ex.printStackTrace();
		}
	
	bankapp.debug("Executed in LoginDAO: Deposit has been updated in DB");
	
	}

public double DAObalance(Account a) {
	
	double balance = 0;
	
	Connection conn = cf.getConnection();
	
	try {
		String sql = "select \"amount\" from \"account\" where \"account_name\" = '" + a.AccountName + "';";
		
		PreparedStatement getBalance = conn.prepareStatement(sql);
		ResultSet res = getBalance.executeQuery();
		
		while (res.next()) {
			balance = res.getDouble("amount");
			//System.out.println(balance);
		}
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	
	bankapp.debug("Executed in LoginDAO: Balance has been recovered from DB");
	
	return balance;
}

public void DAOwithdraw( double amount, Account a) {
	
	Connection conn = cf.getConnection();
	
	
	try {
		String sql = "update \"account\" set \"amount\" = " + a.amount + " where \"account_name\" = '" + a.AccountName + "';";
		
		Statement withdrawFunds = conn.createStatement();
		withdrawFunds.executeUpdate(sql);
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	
	bankapp.debug("Executed in LoginDAO: Withdraw has been updated in DB");
	
}


public void DAOallBalance(Customer c) {
	
	Connection conn = cf.getConnection();
	
	try {
		String sql = "select \"account_name\", \"amount\" from \"account\" where \"customer_id\" = " + c.customerID + ";";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet res = ps.executeQuery();
		
		while (res.next()) {
			System.out.println("Account name: " + res.getString("account_name") + "		Amount: " + res.getDouble("amount"));
		}
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	
	bankapp.debug("Executed in LoginDAO: All Balance has been recovered from DB");
	
}

	
}

	
	
	

	
	
	
	
	
	
	
	
	

