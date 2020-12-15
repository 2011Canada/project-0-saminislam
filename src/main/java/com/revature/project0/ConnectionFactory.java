package com.revature.project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	private static ConnectionFactory cf = new ConnectionFactory(1);
	
	public static ConnectionFactory getConnectionFactory() {
		return cf;
	}
	
	private Connection [] conn;

	private ConnectionFactory(int numberofConnections) {
		String url = System.getenv("DB_URL");
		String user = System.getenv("DB_USER");
		String password = System.getenv("DB_PASSWORD");
		
		
		try {
			this.conn = new Connection[numberofConnections];
			for (int i = 0;i < this.conn.length; i++) {
				Connection conn = DriverManager.getConnection(url,user,password);
				this.conn[i] = conn;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		return this.conn[0];
	}
	
	public void releaseConnection(Connection conn) {
		// do nothing
	}
	
	
	
	
	
	
	
	

}
