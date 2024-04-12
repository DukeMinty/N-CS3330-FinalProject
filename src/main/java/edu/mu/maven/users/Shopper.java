package edu.mu.maven.users;

import java.util.ArrayList;

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

	public void setShoppingCart(ArrayList<String> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Override
	public String toString() {
		return "Shopper [accountBalance=" + accountBalance + ", shoppingCart=" + shoppingCart + "]";
	}
    
}