package edu.mu.maven.model;

import java.util.ArrayList;

public class ShopperArraylistModel {
	
	private ArrayList<ShopperModel> shopperList;
	
	public ShopperArraylistModel() {
		shopperList = new ArrayList<>();
	}
	
	public void addShopper(ShopperModel shopper) {
		shopperList.add(shopper);
	}
	
	public void removeShopper(ShopperModel shopper) {
		shopperList.remove(shopper);
	}
	
	public ArrayList<ShopperModel> getList() {
		return shopperList;
	}

}
