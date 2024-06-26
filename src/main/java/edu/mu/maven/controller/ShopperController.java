package edu.mu.maven.controller;

import java.util.ArrayList;

import edu.mu.maven.inventory.Item;
import edu.mu.maven.model.ShopperModel;
import edu.mu.maven.view.ShopperView;

//Created by Aaron Trebus
//Class is the controller for Shopper objects

//Feel free to add more as necessary for the project's growth

public class ShopperController {
	
	private ShopperModel model;
	private ShopperView view;
	
	public ShopperController(ShopperModel model, ShopperView view) {
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
	public ArrayList<Item> getShopperCart() {
		return (ArrayList<Item>) model.getShoppingCart();
	}
	
	public boolean updateView() {
		view.printShopperDetails(model);
		return true;
	}

}

