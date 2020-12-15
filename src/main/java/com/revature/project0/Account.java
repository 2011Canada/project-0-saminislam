package com.revature.project0;


public class Account extends Customer {

	public String AccountName;
	public double amount;
	public Customer customer;
	public int customerID;
	
	
	public Account() {
		super();
	}
	
	
	public Account(String AccountName, double amount, int customerID) {
		this.AccountName = AccountName;
		this.amount = amount;
		this.customerID = customerID;
	}
	
	public String toString() {
		return ("Account Name: " + this.AccountName + '\n' + "Amount: $" + this.amount);
		
	}
}