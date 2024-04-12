package edu.mu.maven.users.model;

import edu.mu.maven.users.Shopper;
import edu.mu.maven.users.view.ShopperView;

public class ShopperController {
	
	private Shopper model;
	private ShopperView view;
	
	public ShopperController(Shopper model, ShopperView view) {
		this.model=model;
		this.view=view;
	}
	
	public void setShopperUsername(String username) {
		model.setUsername(username);
	}
	
	public String getShopperUsername() {
		return model.getUsername();
	}
	
	public void updateView() {
		view.printShopperDetails(model);
	}

}
