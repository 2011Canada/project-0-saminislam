package com.revature.project0;



public class Transaction extends Account {
	
	public String transaction_text;
	public String sender;
	public String receiver;
	public double amount_to_send;
	public Boolean amount_deposited; 
	public Account account;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Transaction(String sender, String receiver, double amount_to_send, Account account,
			Boolean amount_depositted, String transaction_text) {
		
		
		
		this.sender = sender;
		this.receiver = receiver;
		this.amount_to_send = amount_to_send;
		this.account = account;
		this.amount_deposited = amount_depositted;
		

		if (amount_deposited == null) {
			this.transaction_text = ("Sender: " + sender + 
			" sent money from his " + account.AccountName + 
			" account" +
			" to the recipient: " + receiver +
			". The amount sent was " + amount_to_send + 
			" .Is amount depositted? " + "Not yet decided");
		} else {
			this.transaction_text = ("Sender: " + sender + 
			" sent money from his " + account.AccountName + 
			" account" +
			" to the recipient: " + receiver +
			". The amount sent was: " + amount_to_send + 
			" .Is amount depositted? " + amount_deposited);
		}
		

		
	}
	
	public Transaction(String sender, String receiver, double amount_to_send, Account account) {
		
		this.sender = sender;
		this.receiver = receiver;
		this.amount_to_send = amount_to_send;
		this.account = account;
		
		if (this.amount_deposited == null) {
			this.transaction_text = ("Sender: " + sender + 
			" sent money from his " + account.AccountName + 
			" account" +
			" to the recipient: " + receiver +
			". The amount sent was " + amount_to_send + 
			" .Is amount depositted? " + "Not yet decided");
		} else {
			this.transaction_text = ("Sender: " + sender + 
			" sent money from his " + account.AccountName + 
			" account" +
			" to the recipient: " + receiver +
			". The amount sent was " + amount_to_send + 
			" .Is amount depositted? " + this.amount_deposited);
		}
	}
	
	
	
	
	public String toString() {
		return ("Sender: " + this.sender +'\n' + 
				"Recipient: " + this.receiver + '\n'
				+ "Amount Sent: " + this.amount_to_send + 
				'\n' + "Has Amount been deposited: " + this.amount_deposited);
	}
	

	


}