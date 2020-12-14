package com.project0;
import java.util.Scanner;

public class Menu {
	boolean exit1;
	boolean exit2;
	
	public void runMenu() {
		printHeader();
		while(!exit1) {
			printMenu0();
			int choice = getInput();
			performAction(choice);
			
		}
	}
		
		
	private int getInput() {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		while(choice < 1 || choice > 4) {
			try {
				System.out.print("Enter your choice: ");
				choice = Integer.parseInt(scan.nextLine());
			}
			
			catch(NumberFormatException e) {
				System.out.println("Invalid Selection. Please try again.");
			}
		}
		
		//scan.close();
		return choice;
	}
	
	private void performAction(int choice) {
		//int choice_for_2nd_action;
		Scanner scan = new Scanner(System.in);
		switch(choice) {
		case 1:
			
			System.out.println('\n' + "You have two tries to sign into your Account or you will be sent back to the main menu");
			System.out.print("Please enter your Name: ");
			String name = scan.nextLine();
			System.out.print("Please enter your Password: ");
			String password = scan.nextLine();
			//System.out.println(Customer.customer_list);
			Customer account_found = Customer.verifyCustomer(name,password);
			if (account_found!= null) {
				printMenu1(account_found);
			} else {
				System.out.println('\n'+ "Could not find your account");
				System.out.println("You have one more try before you get sent back to main menu"  + '\n');
				System.out.print("Please enter your Name: ");
				name = scan.nextLine();
				System.out.print("Please enter your Password: ");
				password = scan.nextLine();
				account_found = Customer.verifyCustomer(name,password);
				if (account_found != null) {
					printMenu1(account_found);
				} else {
					System.out.println('\n' + "Could not find your account!" + '\n' +"You will be sent back to the main menu" );
					enterKeyHit();
					
					break;
				}
			}
			break;
			
		case 2:
			
			System.out.println("Creating a new user account");
			
			System.out.print("Please enter your Name: ");
			name = scan.nextLine();
			System.out.print("Please enter your Password: ");
			password = scan.nextLine();
			Customer c1 = new Customer(name,password);
			Customer.customer_list.add(c1);
			System.out.println("Your name is :" + name);
			System.out.println("Your password is :" + password);
			enterKeyHit();
			System.out.println("Redirecting you to User Page");
			enterKeyHit();
			printMenu1(c1);
			break;
			
		case 3:
			Employee emp = new Employee();
			printMenu3(emp);
			break;
			
		case 4:
			boolean exit = true;
			System.out.println("GoodBye! We hope to see you again soon");
			break;
		default: 
			System.out.println("An unknown error has occured");
		}
	}
		
	

	private void printHeader() {
		System.out.println("+------------------------------------------+");
		System.out.println("|----------Welcome to Samin's--------------|");
		System.out.println("|----------Banking Application-------------|");
		System.out.println("+------------------------------------------+");
	}
	
	private void printMenu0() {
		System.out.println("What would you like to do?");
		System.out.println("1) Sign in to your existing account");
		System.out.println("2) Create a new account");
		System.out.println("3) Employee Login");
		System.out.println("4) Exit Program");
	}
	
	private boolean printMenu1(Customer c1) {
		Scanner scan = new Scanner(System.in);
		boolean exit = false;
		int choice = 0;
		while (!exit) {
		choice = 0;
		System.out.println("What would you like to do today?");
		System.out.println("1) Create a new bank account");
		System.out.println("2) Check Balance of each Account");
		System.out.println("3) Create a Transaction");
		System.out.println("4) Check Pending Transactions");
		System.out.println("5) Deposit or Withdraw Money");
		System.out.println("6) Exit Program");
		while(choice < 1 || choice > 6) {
			try {
				System.out.print("Enter your choice: ");
				
				choice = Integer.parseInt(scan.nextLine());
				System.out.println("");
				
				if (choice < 1 || choice > 6) {
					System.out.println("Your choice was out of bounds!! ");
				}
			}
			
			catch(NumberFormatException e) {
				System.out.println("Invalid Selection. Please try again.");

			}
		}
		
		switch (choice) {
		case 1:
			System.out.print("Enter Bank Account Name :" );
			String Name = scan.nextLine();
			System.out.print("Enter Amount :");
			double amount = scan.nextDouble();
			scan.nextLine();
			System.out.println("You have created the following bank account: ");
			System.out.println(Name + " which has $" + amount);
			Account a1 = new Account(Name,amount);
			c1.account_list.add(a1);
			enterKeyHit();
			choice = 0;
			
			
			break;
		case 2:
			System.out.println("Balance of each Account" + '\n');
			for (Account item : c1.account_list) {
				System.out.println(item.toString());
				System.out.println();
			}
			enterKeyHit();
			choice = 0;
			break;
		case 3:
			if (c1.account_list.isEmpty()) {
				System.out.println("You do not have any accounts to send money from.");
				System.out.println("Please create an account before creating a transaction");
				enterKeyHit();
				break;
			}
			//System.out.println(Customer.customer_list);
			int choice1 = 0;
			System.out.println("Creating Transaction");
			System.out.print("Enter the Person's name you want to send the money to :" + '\n');
			String Person_to_send = scan.nextLine();
			System.out.print("How much money do you want to send? :" + '\n');
			double amount_to_send = scan.nextDouble();
			scan.nextLine();
			System.out.print("Which account do you want to send it from? :" + '\n');
			int num = 1;
			for (Account item : c1.account_list) {
				System.out.println(num + ") " + item.AccountName + ": " + item.amount);
				num++;
			}
			
			while(choice1 < 1 || choice1 > c1.account_list.size()) {
				try {
					System.out.print("Enter your choice: ");
					choice1 = Integer.parseInt(scan.nextLine());

				}
				
				catch(NumberFormatException e) {
					System.out.println("Invalid Selection. ");
					break;
				}
			}
			Transaction T = new Transaction(c1.customer_name,Person_to_send, amount_to_send, c1.account_list.get(choice1 - 1));
			boolean flag = T.VerifyTransaction(T, c1.account_list.get(choice1 - 1));
			if (flag) {
				c1.transaction_list.add(T);
				for ( Customer item : Customer.customer_list) {
					if (item.customer_name.equals(T.receiver)) {
						item.transaction_list.add(T);
						}
					}
				}
			enterKeyHit();
			choice = 0;
			break;
			
		case 4: 
			System.out.println("Checking Outgoing Pending Transactions..." + '\n');
			boolean outgoingflag = false;
			//System.out.println(c1.transaction_list.get(0));
			//System.out.println(c1.transaction_list.get(0).amount_deposited);
			for (int i = 0; i < c1.transaction_list.size(); i ++) {
				
				if (c1.transaction_list.get(i).amount_deposited == null && (!c1.transaction_list.get(i).receiver.equals(c1.customer_name))) {
				System.out.println("Transaction " + (i+1) + "-> " + "Sender: " + c1.transaction_list.get(i).sender + '\n' +
						"                Recipient: " + c1.transaction_list.get(i).receiver + '\n' +
						"                Amount Sent: " + c1.transaction_list.get(i).amount_to_send  + '\n' +
						"                Deposited: " + "Not Yet Accepted or Declined by Recipient" + '\n');
				outgoingflag = true;
				}	
				}
			
			
			if (!outgoingflag) {
				System.out.println("You have no Outgoing Pending Transactions" + '\n');
			}
			System.out.println("Checking Incoming Pending Transactions..." + '\n');
			
			boolean incoming_flag = false;
			for (int i = 0; i < c1.transaction_list.size(); i ++) {
				
				if (c1.transaction_list.get(i).amount_deposited == null && c1.transaction_list.get(i).receiver.equals(c1.customer_name)) {
				System.out.println("Transaction " + (i+1) + "-> " + "Sender: " + c1.transaction_list.get(i).sender + '\n' +
						"                Recipient: " + c1.transaction_list.get(i).receiver + '\n' +
						"                Amount Sent: " + c1.transaction_list.get(i).amount_to_send  + '\n' +
						"                Deposited: " + "Not Yet Accepted or Declined by Recipient" + '\n');
				incoming_flag= true;
				}
			}
			
			if (!incoming_flag) {
				System.out.println("You have no Incoming Pending Transactions" + '\n');
				
			}
			
			if (incoming_flag && c1.transaction_list.get(i).amount_deposited == null) {
				System.out.println("Would you like to accept any incoming transactions?");
				System.out.println("Input '1' to accept or '2' to try again later");
				int choice3 = Integer.parseInt(scan.nextLine());
				if (choice3 == 1) {
					for (int i = 0; i < c1.transaction_list.size(); i ++) {
					
						if (c1.transaction_list.get(i).amount_deposited == null && c1.transaction_list.get(i).receiver.equals(c1.customer_name)) {
							System.out.println("Transaction " + (i+1) + "-> " + "Sender: " + c1.transaction_list.get(i).sender + '\n' +
									"                Recipient: " + c1.transaction_list.get(i).receiver + '\n' +
									"                Amount Sent: " + c1.transaction_list.get(i).amount_to_send  + '\n' +
									"                Deposited: " + "Not Yet Accepted or Declined by Recipient" + '\n');
					
							try {
								System.out.println("Would you like to accept or decline this transaction");
								System.out.println("Input '1' to accept or '2' to decline this transaction");
								choice3 = Integer.parseInt(scan.nextLine());
								if (choice3 == 1) {
									System.out.println("Which account do you want to deposit this Transaction?");
									int counter = 1;
									for (Account item : c1.account_list) {
										System.out.println(counter + ")" + item.toString());
										System.out.println();
										counter++;
										}
									choice3 = Integer.parseInt(scan.nextLine());
							
									c1.transaction_list.get(i).AcceptTransaction(c1.transaction_list.get(i), c1.account_list.get(choice3 - 1), c1.transaction_list.get(i).account, true);
									}
								if (choice3 == 2) {
									c1.transaction_list.get(i).AcceptTransaction(c1.transaction_list.get(i), c1.account_list.get(choice3 - 1), c1.transaction_list.get(i).account, false);
									System.out.println("This Transaction has been rejected");
								}

							}
							catch(NumberFormatException e) {
								System.out.println("Invalid Selection. ");
								break;
								}

							}
					}	
				}
			}
			
			
			enterKeyHit();
			choice = 0;
			break;
		
			
		case 5:
			int choice2 = 0;
			System.out.println("Would you like to Deposit or Withdraw Money?");
			System.out.println("Select 1 for Deposit or 2 for Withdrawal");
			choice2 = Integer.parseInt(scan.nextLine());
			if (choice2 == 1) {
				System.out.println("How much would you like to deposit?");
				double amount_depositted = scan.nextDouble();
				System.out.print(" Which account do you want to deposit to? :" + '\n');
				
				for (Account item : c1.account_list) {
					int i = 1;
					System.out.println(i + ") " + item.AccountName + ": " + item.amount);
					i++;
				}
				while(choice2 < 1 || choice > c1.account_list.size()) {
					try {
						System.out.print("Enter your choice: ");
						choice2 = Integer.parseInt(scan.nextLine());
					}
					
					catch(NumberFormatException e) {
						System.out.println("Invalid Selection. ");
						break;
					}
				}
				c1.deposit(amount_depositted, c1.account_list.get(choice2));
			}
			if (choice2 == 2) {
				System.out.println("How much would you like to withdraw?");
				int amount_withdrawn = Integer.parseInt(scan.nextLine());
				System.out.print(" Which account do you want to withdraw from? :" + '\n');
				for (Account item : c1.account_list) {
					int i = 1;
					System.out.println(i + ") " + item.AccountName + ": " + item.amount);
					i++;
				}
				while(choice2 < 1 || choice > c1.account_list.size()) {
					try {
						System.out.print("Enter your choice: ");
						choice2 = Integer.parseInt(scan.nextLine());
					}
					
					catch(NumberFormatException e) {
						System.out.println("Invalid Selection. ");
						break;
					}
				}
				c1.withdraw(amount_withdrawn,c1.account_list.get(choice2));
				enterKeyHit();
				choice = 0;
			}
			break;
		case 6:
			System.out.println("You will be returning to the main menu");
			exit = true;
			choice = 0;
			enterKeyHit();
			
			
			}
		}
		return exit;
		
	}
	
	private void printMenu2() {
		System.out.println("1) What is your name?");
		System.out.println("2) What is your password?");
		System.out.println("3) Go Back");

	}
	
	private void enterKeyHit() {
		String input;
		Scanner enter = new Scanner(System.in);
		System.out.println("Please hit enter to continue");
		input = enter.nextLine();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
	}
	
	
	private void printMenu3(Employee emp) {
		System.out.println("Employee Login");
		System.out.println("Only 1 chance is granted or else you will be taken back to main menu");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your Name");
		String name = scan.nextLine();
		System.out.println("Please enter your Password");
		String password = scan.nextLine();
		if (name == emp.username && password == emp.password) {
			System.out.println("Employee Login Successful");
			System.out.println("What would you like to do next?");
			System.out.println("1) Check a customer's Bank Accounts");
			System.out.println("2) Check a customer's transaction logs");
			System.out.println("3) Reject a customer's bank account");
			System.out.println("4) Exit");
			int choice_m3 = Integer.parseInt(scan.nextLine());
			while (choice_m3 < 1 && choice_m3 > 4) {
				System.out.println("Please Enter Again:");
			}
			if (choice_m3 == 1) {
				System.out.println("These are all the Customer users in your database");
				Employee.View_Customer_List();
				System.out.println("Which customer's bank account would you like to see?");
				int cust_num = Integer.parseInt(scan.nextLine()) - 1;
				emp.View_Customer_Bank_Accounts(Customer.customer_list.get(cust_num));
				}
			if (choice_m3 == 2 ) {
				System.out.println("These are all the Customer users in your database");
				Employee.View_Customer_List();
				System.out.println("Which Customer's transaction logs do you want to see?");
				int cust_num = Integer.parseInt(scan.nextLine()) - 1;
				emp.View_Transaction_Log(Customer.customer_list.get(cust_num));
			}
			if (choice_m3 == 3 ) {
				System.out.println("These are all the Customer users in your database");
				Employee.View_Customer_List();
				System.out.println("Which Customer's bank account would you like to see?");
				int cust_num = Integer.parseInt(scan.nextLine()) - 1;
				emp.View_Customer_Bank_Accounts(Customer.customer_list.get(cust_num));
				System.out.println("Which Customer's bank account would you like to reject?");
				int bank_id = Integer.parseInt(scan.nextLine()) - 1;
				emp.Account_Rejector(Customer.customer_list.get(cust_num), Customer.customer_list.get(cust_num).account_list.get(bank_id));
			}
			if (choice_m3 == 4) {
				System.out.println("You have chosen to exit");
			}
		}
	}
	
	
	// You need to fix the indices
	// You need to be able to properly get out of the loops
	// You need to make sure everything works as intended
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
