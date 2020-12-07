package com.project0;

public class Transaction extends Account {
	
	public void withdrawal(float w_amount) {
		super.amount = super.amount - w_amount;
	}
	
	public void deposit(float d_amount) {
		super.amount = super.amount + d_amount;
	}
}

