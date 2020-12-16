package com.revature.repositories;


import com.revature.project0.*;


class DAODebugger {

	public DAODebugger() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		TransactionDAO TDAO = new TransactionDAO();
	
		
		Customer c1 = new Customer("Samin","123",1);
		
		Account a1 = new Account("savings",1200,1);
		
		Customer c2 = new Customer("Rakin","123",2);
		
		Account a2 = new Account("savings",2500,1);
		
		c1.account_list.add(a1);
		
		c2.account_list.add(a2);
		
		Customer.customer_list.add(c1);
		
		Customer.customer_list.add(c2);
		
		Transaction T = new Transaction(c1.customer_name,"Rakin", 300, a1);
		
		System.out.println(T.VerifyTransaction(T, a1));
		
		c1.transaction_list.add(T);
		
		for ( Customer item : Customer.customer_list) {
			if (item.customer_name.equals(T.receiver)) {
				item.transaction_list.add(T);
				TDAO.addTransaction(T, item);
			}
		}
		
		System.out.println("Checking Outgoing Pending Transactions..." + '\n');

		for (int i = 0; i < c1.transaction_list.size(); i ++) {
			
			if (c1.transaction_list.get(i).amount_deposited == null && (!c1.transaction_list.get(i).receiver.equals(c1.customer_name))) {
			System.out.println("Transaction " + (i+1) + "-> " + "Sender: " + c1.transaction_list.get(i).sender + '\n' +
					"                Recipient: " + c1.transaction_list.get(i).receiver + '\n' +
					"                Amount Sent: " + c1.transaction_list.get(i).amount_to_send  + '\n' +
					"                Deposited: " + "Not Yet Accepted or Declined by Recipient" + '\n');
			}	
			}
		
		System.out.println("Checking Incoming Pending Transactions..." + '\n');	
		for (int i = 0; i < c1.transaction_list.size(); i ++) {
			

			
			if (c1.transaction_list.get(i).amount_deposited == null && (c1.transaction_list.get(i).receiver.equals(c1.customer_name))) {
			System.out.println("Transaction " + (i+1) + "-> " + "Sender: " + c1.transaction_list.get(i).sender + '\n' +
					"                Recipient: " + c1.transaction_list.get(i).receiver + '\n' +
					"                Amount Sent: " + c1.transaction_list.get(i).amount_to_send  + '\n' +
					"                Deposited: " + "Not Yet Accepted or Declined by Recipient" + '\n');

			}
		}
		
		Transaction T2 = new Transaction(c2.customer_name,"Samin", 500, a2);
		
		System.out.println(T2.VerifyTransaction(T2, a1));
		
		c2.transaction_list.add(T2);
		
		for ( Customer item : Customer.customer_list) {
			if (item.customer_name.equals(T2.receiver)) {
				item.transaction_list.add(T2);
				TDAO.addTransaction(T2, item);
			}
		}
		
		System.out.println("Checking Outgoing Pending Transactions..." + '\n');

		for (int i = 0; i < c2.transaction_list.size(); i ++) {
			
			if (c2.transaction_list.get(i).amount_deposited == null && (!c2.transaction_list.get(i).receiver.equals(c2.customer_name))) {
			System.out.println("Transaction " + (i+1) + "-> " + "Sender: " + c2.transaction_list.get(i).sender + '\n' +
					"                Recipient: " + c2.transaction_list.get(i).receiver + '\n' +
					"                Amount Sent: " + c2.transaction_list.get(i).amount_to_send  + '\n' +
					"                Deposited: " + "Not Yet Accepted or Declined by Recipient" + '\n');
			}	
			}
		
		System.out.println("Checking Incoming Pending Transactions..." + '\n');	
		for (int i = 0; i < c2.transaction_list.size(); i ++) {
			

			
			if (c2.transaction_list.get(i).amount_deposited == null && (c2.transaction_list.get(i).receiver.equals(c2.customer_name))) {
			System.out.println("Transaction " + (i+1) + "-> " + "Sender: " + c2.transaction_list.get(i).sender + '\n' +
					"                Recipient: " + c2.transaction_list.get(i).receiver + '\n' +
					"                Amount Sent: " + c2.transaction_list.get(i).amount_to_send  + '\n' +
					"                Deposited: " + "Not Yet Accepted or Declined by Recipient" + '\n');

			}
		}
		
		
		
		
		
		
		
		/*
		CustomerDAO cDAO = new CustomerDAO();
		TransactionDAO TDAO = new TransactionDAO();
		LoginDAO LDAO = new LoginDAO();	
		
		Customer c = LDAO.DAOcustomerLogin("sam", "123");
		
		TDAO.CustomerTransactions(c);
		*/
		
		//TDAO.allTransactions();
		
		//cDAO.DAOallBalance(c);
	
		/*
		
		a2.withdraw(300, a2);
		
		cDAO.DAObalance(a2);
		
		cDAO.DAOwithdraw(300, a2);
		
		cDAO.DAObalance(a2);
		
		cDAO.DAOallBalance(c1);
		
		
		//cDAO.createAccount(a1);
		//cDAO.DAOdeposit(400, a1);
		 
		 */
		/*
		
		Customer c1 = new Customer("SAMIN","Password90",1);
		Customer.customer_list.add(c1);
		
		Account a1 = new Account("TSA",5000,1);
		
		Transaction T = new Transaction("sam","raks",200,a1);
		
		TransactionDAO tDAO = new TransactionDAO();
		tDAO.addTransaction(T, c1);
		*/
		/*
		
		LoginDAO lDAO = new LoginDAO();
		
		CustomerDAO cDAO = new CustomerDAO();
		
		Customer c = new Customer("sam","123");
		
		cDAO.DAOviewAccount(c);
		
		Customer c1 = new Customer("SAMIN","Password90");
		
		//Account a1 = new Account("TSA",5000,1);
		
		Account a2 = new Account("SFX", 3200,1);
		
		//a1.deposit(400, a1);
		
		cDAO.DAOcreateCustomer(c1);
		
		//Customer c = lDAO.DAOcustomerLogin("sam", "123");
		
		//System.out.println(c);
		
		
		//System.out.println(Customer.customer_list.get(0));
		
		
		/*
		
		Customer c1 = lDAO.DAOcustomerLogin("SAMIN" , "Password");
		lDAO.DAOAccountRetrieve(c1);
		for (Account item : c1.account_list) {
			System.out.println(item.AccountName);
		}
		
		*/

	}
	

}
