package edu.mu.maven.users;

import java.util.ArrayList;

//Created by Aaron Trebus

//Class lays out the paramaters for Shopper objects

//Includes the username and password fields (will change if I can find a better way to format)
//Also includes the shopping cart that can have items added to it

public class Shopper extends Users {
    private double accountBalance;
    
    //Change to Item type when it is made
    //
    private ArrayList<String> shoppingCart;
    //
    //
    
    public Shopper(String username, String password, double accountBalance) {
    	super(username, password);
    	this.accountBalance = accountBalance;
    	shoppingCart = new ArrayList<>();
    }

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public ArrayList<String> getShoppingCart() {
		return shoppingCart;
	}

	@Override
	public String toString() {
		return "Shopper [accountBalance=" + accountBalance + ", shoppingCart=" + shoppingCart + "]";
	}


    
}