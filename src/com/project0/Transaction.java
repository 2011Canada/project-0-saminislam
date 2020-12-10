package com.project0;

import java.util.ArrayList;

public class Transaction extends Account {
	
	public String sender;
	public String receiver;
	public double amount_to_send;
	public boolean amount_deposited = false; 
	public String accountName;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Transaction(String sender, String receiver, double amount_to_send, String accountName) {
		
		this.sender = sender;
		this.receiver = receiver;
		this.amount_to_send = amount_to_send;
		this.accountName = accountName;

		
	}
	
	public String toString() {
		return ("Receiver: " + this.receiver +'\n'
				+ "Amount Sent: " + this.amount_to_send + 
				'\n' + "Has Amount been deposited: " + this.amount_deposited);
	}
	

	

	public void withdraw(double w_amount, Account A ) {
		A.amount = A.amount - w_amount;
		
	}
	
	public void deposit(double d_amount, Account A) {
		A.amount = A.amount + d_amount;
	}
}

