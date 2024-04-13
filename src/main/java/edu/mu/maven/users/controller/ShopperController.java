package edu.mu.maven.users.controller;

import edu.mu.maven.users.Shopper;
import edu.mu.maven.users.view.ShopperView;

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
	
	public void updateView() {
		view.printShopperDetails(model);
	}

}
