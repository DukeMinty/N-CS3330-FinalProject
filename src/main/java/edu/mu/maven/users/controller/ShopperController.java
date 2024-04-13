package edu.mu.maven.users.controller;

import java.util.ArrayList;
import edu.mu.maven.users.Shopper;
import edu.mu.maven.users.view.ShopperView;

//Created by Aaron Trebus
//Class is the controller for Shopper objects

//Feel free to add more as necessary for the project's growth

public class ShopperController {
	
	private Shopper model;
	private ShopperView view;
	
	public ShopperController(Shopper model, ShopperView view) {
		this.model=model;
		this.view=view;
	}
	
	public String getShopperUsername() {
		return model.getUsername();
	}
	
	public void setShopperUsername(String username) {
		model.setUsername(username);
	}
	
	public String getShopperPassword() {
		return model.getPassword();
	}
	
	public double getShopperBalance() {
		return model.getAccountBalance();
	}
	
	public void addToShopperBalance(double addition) {
		model.setAccountBalance(model.getAccountBalance() + addition);
	}
	
	//Change to type of Item when it is made
	public ArrayList<String> getShopperCart() {
		return model.getShoppingCart();
	}
	
	public void updateView() {
		view.printShopperDetails(model);
	}

}
