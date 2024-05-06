package edu.mu.maven.view;

import edu.mu.maven.model.ShopperArraylistModel;
import edu.mu.maven.model.ShopperModel;

//Created by Aaron Trebus

public class ShopperArraylistView {
	
	public void printAllShoppers(ShopperArraylistModel model) {
		for(ShopperModel shoppers : model.getList()) {
			System.out.println(shoppers.toString());
		}
	}

}
