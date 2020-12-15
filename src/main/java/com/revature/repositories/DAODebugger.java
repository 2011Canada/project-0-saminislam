package com.revature.repositories;


import com.revature.project0.*;


public class DAODebugger {

	public DAODebugger() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/*
		
		CustomerDAO cDAO = new CustomerDAO();
		
		Customer c1 = new Customer("SAMIN","Password90",1);
		
		//Account a1 = new Account("TSA",5000,1);
		
		Account a2 = new Account("SFX", 3200,1);
		
		//a1.deposit(400, a1);
		
		//cDAO.DAOcreateAccount(a1);
		
		//cDAO.DAOcreateAccount(a2);
		
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
		
		LoginDAO lDAO = new LoginDAO();
		
		//lDAO.DAOcustomerLogin("SAMIN", "Password90");
		
		
		//System.out.println(Customer.customer_list.get(0));
		
		
		
		Customer c1 = lDAO.DAOcustomerLogin("SAMIN" , "Password");
		lDAO.DAOAccountRetrieve(c1);
		for (Account item : c1.account_list) {
			System.out.println(item.AccountName);
		}
		
		

	}

}
