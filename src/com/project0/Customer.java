package com.project0;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.HashMap;
import java.util.List;

public class Customer  {
	
	protected String customer_name;
	protected String password;
	//hashmap might not be a good idea
	//protected HashMap <Account, Double> List_of_accounts = new HashMap <Account, Double>();
	protected List <Transaction> Transaction_list = new ArrayList<Transaction>();
	protected List <Account> Account_list = new ArrayList<Account>();
	protected static List <Customer> Customer_list = new ArrayList<Customer>();
	
	public Customer() {
	}
	
	public Customer(String customer_name, String password, List<Account> List_of_accounts, List <Transaction> Transaction_list) {
		this.customer_name = customer_name;
		this.password = password;
		this.Account_list = List_of_accounts;
		this.Transaction_list = Transaction_list;
		
		
	}
	
	public Customer(String customer_name, String password) {
		this.customer_name = customer_name;
		this.password = password;
	}
	
	public String toString() {
		return ("Customer: " + this.customer_name +'\n'
				+ "Password: " + this.password + '\n' + 
				"List of Accounts: " + this.Account_list + '\n' +
				"Transaction List: " + this.Transaction_list);
	}

	public static void verifyCustomer(String name, String password) {
		
		for (Customer item : Customer_list) {
			if ((item.customer_name == name) && (item.password == password)) {
				System.out.println("Account Verified!");
				} else {
					System.out.println("Account Not Verified!");
					}
			}
		}
	
	public void withdraw(double w_amount, Account A ) {
		A.amount = A.amount - w_amount;
		
	}
	
	
	}
