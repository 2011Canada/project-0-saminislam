package com.project0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mainprogram {

	public static void main(String[] args) {
		
		List <Transaction> TL = new ArrayList<Transaction>();
		Transaction T = new Transaction("SAMIN", "BABA", 1000.23, "Chequing");
		TL.add(T);
		//System.out.println(TL.toString());
		//System.out.println("XXXXXX-----TRANSACTION STUFF ------XXXXXX" + '\n');
				
		Customer c1 = new Customer("BDS", "123x");
		//System.out.println(c1.toString());
		c1.Transaction_list.add(T);
		//System.out.println(c1);
		//System.out.println("XXXXXX-----CUSTOMER STUFF ------XXXXXX" + '\n');
		
		
		Account a1 = new Account("Chequing Account", 2000);
		//System.out.println(a1.toString());
		c1.Account_list.add(a1);
		//System.out.println(c1);
		//System.out.println("XXXXXX-----ACCOUNT STUFF ------XXXXXX" + '\n');
		
		Customer.Customer_list.add(c1);
		//System.out.println(Customer.Customer_list.get(0));
		//System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		//System.out.println((Customer.Customer_list.get(0)).password);
		// need to firgure out a way to verify if customer is in this list
		//System.out.println("XXXXXXXXXXXXX-----VERIFICATION ------XXXXXXXXXXXXXXXXXXXXXXXX");
		//Customer.verifyCustomer("BDS","123x");
		
		// This proves that withdraw works!!!!
		System.out.println(c1);
		c1.withdraw(200.0,a1);
		System.out.println(c1);
		
		
		
		
	}

}
