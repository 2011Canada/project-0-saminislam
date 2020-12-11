package com.project0;

public class Employee extends Account{
	
	public String username = "Employee";
	public String password = "Password123";

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	// make sure all these work!!!!
	
	public static void View_Customer_List() {
		System.out.println(customer_list);
	}
	
	public void View_Transaction_Log(Customer c1) {
		System.out.println(c1.transaction_list);
	}
	
	public void View_Customer_Bank_Accounts(Customer c1) {
		System.out.println(c1.account_list);
	}
	
	public void Account_Rejector(Customer c1, Account a1) {
		c1.account_list.remove(a1);
		
	}
}
