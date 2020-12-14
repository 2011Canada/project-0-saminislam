package com.revature.project0;



public class Transaction extends Account {
	
	public String sender;
	public String receiver;
	public double amount_to_send;
	public Boolean amount_deposited; 
	public Account account;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Transaction(String sender, String receiver, double amount_to_send, Account account) {
		
		this.sender = sender;
		this.receiver = receiver;
		this.amount_to_send = amount_to_send;
		this.account = account;

		
	}
	
	
	
	
	public String toString() {
		return ("Sender: " + this.sender +'\n' + 
				"Recipient: " + this.receiver + '\n'
				+ "Amount Sent: " + this.amount_to_send + 
				'\n' + "Has Amount been deposited: " + this.amount_deposited);
	}
	

	


}