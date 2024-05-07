package edu.mu.maven.shopping;

import java.util.List;
import java.util.Scanner;
import edu.mu.maven.Main;
import edu.mu.maven.controller.ShopperController;
import edu.mu.maven.inventory.Item;
import edu.mu.maven.model.ShopperModel;

public class ShoppingMenu{
	
	public static boolean Menu(Scanner scanner,List<Item> item, ShopperModel shopperModel) {
		boolean check = true;
		System.out.println("Hello! What region will you be shopping today\n1. American\n2. Japanese \n3. Korean\n4. Go Back\n5. End Shopping Spree");
		while(check) {
			try{
				int shopperInput = Integer.parseInt(scanner.nextLine());
				if(shopperInput == 1) {
                	ShoppingAmerican.ShopAmerican(scanner,  item, shopperModel);
                	return true;
				}else if(shopperInput == 2) {
                	ShoppingJapanese.ShopJapanese(scanner,  item, shopperModel);
                	return true;
				}else if(shopperInput == 3) {
                	ShoppingKorean.ShopKorean(scanner, item, shopperModel);
                	return true;
				}else if(shopperInput == 4) {
					Main.callMain();
					return true;
				}else if(shopperInput == 5) {
					//need call for checkout
					return true;
				}else {
                	System.err.println("Invalid choice. Choose a integer corresponding to a choice above.");
                	check = true;
                }
			}catch(NumberFormatException e){
				System.err.println("Choose a integer corresponding to a choice above.");
				check = true;
			}
		}	
		return false;
	}
	public static void addItemtoCart(ShopperModel shopperModel, Object item) {
		try {
			shopperModel.getShoppingCart().add((Item) item);
		}catch(Exception e){
			System.out.println("Something went wrong.Add to cart unsuccessful");
		}
		
	}
	public static int stockDecrement(Item item) {
		try {
		    int Stock = item.getStock();
		    if(Stock > 0) {
		        item.setStock(Stock - 1);
		        return item.getStock();
		    }
		}catch(Exception e) {
			System.out.println("Stock is 0.");
		    return 0;
		}
		return 0;
	}
}
