package com.project0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mainprogram {

	public static void main(String[] args) {
		
		
		
		Customer c1 = new Customer("SAMIN", "123x");
		Customer.customer_list.add(c1);
		Account a1 = new Account("Chequing", 2000);
		c1.account_list.add(a1);
		
		Customer c2 = new Customer("RAKIN", "321a");
		Customer.customer_list.add(c2);
		Account a2 = new Account("Chequing",1500);
		c2.account_list.add(a2);
		
		Transaction T = new Transaction("SAMIN", "RAKIN", 100, a1);
		T.VerifyTransaction(T, a1);
		System.out.println("T=" + T);
		System.out.println("c2=" + c2);
		T.AcceptTransaction(T, a2, a1, true,c1,c2);
		System.out.println("T=" + T);
		System.out.println("c2=" + c2);
		System.out.println("XXXXXXXXXXXXXXXXXXXXX " + '\n');
		//System.out.println(c1.transaction_list);
		c1.toString();
		
		//System.out.println("amount deposited = " + T.amount_deposited);
		
		
		
		//boolean flag = T.VerifyTransaction(T,a1);
		//System.out.println(flag);
		
		/*
		for (Customer item : Customer.customer_list) {
			System.out.println(item);
		}
		
		c1.withdraw(200, a1);
		c2.deposit(200000, a2);
		
		System.out.println("XXXXXXX" + '\n');
		
		for (Customer item : Customer.customer_list) {
			System.out.println(item);
		}		
		
		*/
		
		/*
		
		
		List <Transaction> TL = new ArrayList<Transaction>();
		Transaction T = new Transaction("SAMIN", "BABA", 1000.23, "Chequing");
		TL.add(T);
		//System.out.println(TL.toString());
		//System.out.println("XXXXXX-----TRANSACTION STUFF ------XXXXXX" + '\n');
				

		
		
		
		Transaction T = new Transaction("SAMIN", "BABA", 1000.23, "Chequing");
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
		
		
		
		// This proves that withdraw and deposit works!!!!
		System.out.println(c1);
		c1.withdraw(200,a1);
		System.out.println(c1);
		c1.deposit(100, a1);
		System.out.println(c1);
		
		*/
		
		
	}

}
