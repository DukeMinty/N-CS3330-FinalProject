package edu.mu.maven.shopping;

import java.util.List;
import java.util.Scanner;
import edu.mu.maven.Main;
import edu.mu.maven.controller.ShopperController;
import edu.mu.maven.inventory.Item;
import edu.mu.maven.model.ShopperModel;

public class ShoppingMenu{
	
	public static void Menu(Scanner scanner,List<Item> item, ShopperModel shopperModel) {
		boolean check = true;
		System.out.println("Hello! What region will you be shopping today\n1. American\n2. Japanese \n3. Korean\n4. Go Back\n5. End Shopping Spree");
		while(check) {
			try{
				int shopperInput = Integer.parseInt(scanner.nextLine());
				if(shopperInput == 1) {
                	ShoppingAmerican.ShopAmerican(scanner,  item, shopperModel);
				}else if(shopperInput == 2) {
                	ShoppingJapanese.ShopJapanese(scanner,  item, shopperModel);
				}else if(shopperInput == 3) {
                	ShoppingKorean.ShopKorean(scanner, item, shopperModel);
				}else if(shopperInput == 4) {
					Main.callMain();
				}else if(shopperInput == 5) {
					
				}else {
                	System.out.println("Invalid choice");
                	check = true;
                }
			}catch(NumberFormatException e){
				check = true;
			}
		}	
	}
	public static void addItemtoCart(ShopperModel shopperModel, Object item) {
		try {
			shopperModel.getShoppingCart().add((Item) item);
		}catch(Exception e){
			System.out.println("Something went wrong.Add to cart unseccessful");
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
