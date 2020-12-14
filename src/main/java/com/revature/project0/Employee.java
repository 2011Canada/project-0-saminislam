package com.revature.project0;



public class Employee extends Account{
	
	public String username = "Employee";
	public String password = "Password123";

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	// make sure all these work!!!!
	
	public static void View_Customer_List() {
		for (int i = 0; i < customer_list.size(); i++) {
			System.out.println("Customer " + (i+1) + ": " + customer_list.get(i).customer_name + '\n');
		}
	}
	
	public void View_Transaction_Log(Customer c1) {
		for (int i = 0; i < c1.transaction_list.size(); i ++) {
			
			System.out.println("Transaction " + (i+1) + "-> " + "Sender: " + c1.transaction_list.get(i).sender + '\n' +
					"                Recipient: " + c1.transaction_list.get(i).receiver + '\n' +
					"                Amount Sent: " + c1.transaction_list.get(i).amount_to_send  + '\n' +
					"                Deposited: " + c1.transaction_list.get(i).amount_deposited + '\n');
		}
	}
	
	public void View_Customer_Bank_Accounts(Customer c1) {
		System.out.println("Customer " + c1.customer_name + " has the following accounts "  + '\n');
		for (int i = 0; i < c1.account_list.size(); i ++) {
			System.out.println(c1.account_list.get(i).AccountName + ": $" + c1.account_list.get(i).amount);
			System.out.println("\n");
			
			
		}
	}
	
	public void Account_Rejector(Customer c1, Account a1) {
		System.out.println("Account " + a1.AccountName + " has been removed from " + c1.customer_name);
		c1.account_list.remove(a1);
		
	}
}