package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


import com.revature.project0.Account;
import com.revature.project0.ConnectionFactory;
import com.revature.project0.Customer;
import com.revature.project0.Transaction;


public class TransactionDAO {

	ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	public void addTransaction(Transaction T, Customer C){

		Connection conn = cf.getConnection();
		
		try {
			
			String sql = "insert into \"transaction\" (\"transaction_log\", \"customer_id\") values (?,?);";
			
			PreparedStatement addTransfer = conn.prepareStatement(sql);
			
			addTransfer.setString(1, T.transaction_text);
			addTransfer.setInt(2, C.customerID);
			addTransfer.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void allTransactions() {
		
		Connection conn = cf.getConnection();
		
		try {
			String sql = "select * from \"transaction\";";
			
			PreparedStatement all = conn.prepareStatement(sql);
			ResultSet res = all.executeQuery();
			
			while(res.next()) {
				System.out.println("Transaction ID: " + res.getInt("transactionId") + "    Transaction: " + res.getString("transactionText"));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}