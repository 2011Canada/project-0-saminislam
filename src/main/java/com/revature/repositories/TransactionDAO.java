package com.revature.repositories;

import com.revature.project0.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class TransactionDAO {

	ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public static Logger bankapp = LogManager.getLogger("com.revature.project0");

	public void addTransaction(Transaction T, Customer C){

		Connection conn = cf.getConnection();
		
		try {
			
			String sql = "insert into \"transaction\" (\"transaction_log\", \"customer_id\") values (?,?);";
			
			PreparedStatement addTransfer = conn.prepareStatement(sql);
			
			addTransfer.setString(1, T.transaction_text);
			addTransfer.setInt(2, C.customerID);
			addTransfer.executeUpdate();
			
			bankapp.debug("Executed in TransactionDAO: Transaction has been inserted into DB");
			
			
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void CustomerTransactions(Customer C) {
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "select \"account_name\",\"amount\" from \"account\" where\n" + 
					"\"customer_id\" = '" + C.customerID + "' ;";
			PreparedStatement all = conn.prepareStatement(sql);
			ResultSet res = all.executeQuery();
			
			while(res.next()) {
				System.out.println("Transaction ID: " + res.getInt("transaction_id") + "    Transaction: " + res.getString("transaction_log"));
				
			}
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		
		bankapp.debug("Executed in TransactionDAO: Transaction has been returned from DB");
		
		
	}
	
	public void allTransactions() {
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "select * from \"transaction\";";
			
			PreparedStatement all = conn.prepareStatement(sql);
			ResultSet res = all.executeQuery();
			
			while(res.next()) {
				System.out.println("Transaction ID: " + res.getInt("transaction_id") + "    Transaction: " + res.getString("transaction_log"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		bankapp.debug("Executed in TransactionDAO: All transactions have been returned from DB");
	}
}