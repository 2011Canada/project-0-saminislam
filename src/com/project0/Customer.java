package com.project0;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.HashMap;
import java.util.List;

public class Customer  {
	
	protected String customer_name;
	protected String password;
	protected List <Transaction> transaction_list = new ArrayList<Transaction>();
	protected List <Account> account_list = new ArrayList<Account>();
	protected static List <Customer> customer_list = new ArrayList<Customer>();
	
	public Customer() {
	}
	
	public Customer(String customer_name, String password, List<Account> List_of_accounts, List <Transaction> Transaction_list) {
		this.customer_name = customer_name;
		this.password = password;
		this.account_list = List_of_accounts;
		this.transaction_list = Transaction_list;
		
		
	}
	
	public Customer(String customer_name, String password) {
		this.customer_name = customer_name;
		this.password = password;
	}
	
	public String toString() {
		return ("Customer: " + this.customer_name +'\n'
				+ "Password: " + this.password + '\n' + 
				"List of Accounts: " + this.account_list + '\n' +
				"Transaction List: " + this.transaction_list);
	}

	public static void verifyCustomer(String name, String password) {
		
		for (Customer item : customer_list) {
			if ((item.customer_name == name) && (item.password == password)) {
				System.out.println("Account Verified!");
				} else {
					System.out.println("Account Not Verified!");
					}
			}
		}
	
	// method to make sure that transaction object can actually be made
	// to access this method, you have to do T.VerifyAccount(T,MS)
	// so clean this code up where you only have one T
	
	// This works but come back and clean up
	public boolean VerifyTransaction(Transaction T, Account money_spender) {
		// first verification to see if person you are sending the money to is in DB
		for ( Customer item : customer_list) {
			if (item.customer_name == T.receiver) {
				// second verification to check if person isn't sending negative money
				if (T.amount_to_send > 0 ) {
					// third verification to check if person has enough money to send 
					if (money_spender.amount > T.amount_to_send) {
						return true;
					} else {
						System.out.println("This account does not have enough money for a transaction");
						return false;
					}
				} else {
					System.out.println("Negative Number is rejected by the system");
					return false;
				}
			}
		}
		
		System.out.println("Sender was not found in our database. Please input the correct name");
		return false;
	}
	
	
	
	public void AcceptTransaction(Transaction T, Account money_getter, Account money_spender, boolean accept, Customer money_getter_customer, Customer money_spender_customer) {
		
		if (T.amount_deposited == null) {
			if (accept == true) {
				T.amount_deposited = true;
				money_getter.amount = money_getter.amount + T.amount_to_send;
				money_spender.amount = money_spender.amount - money_spender.amount;
				money_getter_customer.transaction_list.add(T);
				money_spender_customer.transaction_list.add(T);
			} else if (accept == false) {
				System.out.println("You have rejected the Transaction");
				money_getter_customer.transaction_list.add(T);
				money_spender_customer.transaction_list.add(T);
				T.amount_deposited = false;
				}
		} else if (T.amount_deposited == true ) {
			System.out.println("Transaction has been deposited already");
		} else {
			System.out.println("Transaction has been rejected by user");
		}
	}
	

	// you never checked the case to see if the Account exists for withdraw and deposit
	// but not sure if that will be necessary though
	public void withdraw(double w_amount, Account A ) {
		if (w_amount > 0) {
			if (A.amount > w_amount) {
				A.amount = A.amount - w_amount;
				System.out.println("$" + w_amount + " has been withdrawn.");
				System.out.println("$" + A.amount + " is remaining in your " + A.AccountName + " account.");
			}	else {
				System.out.println("Not enough money to withdraw");
			}
		}	else {
			System.out.println("Not able to withdraw a negative amount");
		}
	}
	
	public void deposit(double d_amount, Account A) {
		if (d_amount > 0) {
			A.amount = A.amount + d_amount;
			System.out.println("$" + d_amount + " has been depositted.");
			System.out.println("$" + A.amount + " is remaining in your " + A.AccountName + " account.");
		}	else {
			System.out.println("Not able to withdraw a negative amount");
		}
		
	}
	
	
	}
