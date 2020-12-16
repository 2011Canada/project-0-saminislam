package com.revature.project0;




import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

class Mainprogram {
	
	public static Logger bankapp = LogManager.getLogger("com.revature.project0");

	public static void main(String[] args) {
		
		
		bankapp.info("Server has Started");
		
		Menu menu = new Menu();
		menu.runMenu();
		
		bankapp.info("Server has Ended");
		
		

		
		
	}
}
