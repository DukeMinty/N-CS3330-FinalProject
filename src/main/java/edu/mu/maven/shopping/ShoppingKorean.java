package edu.mu.maven.shopping;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.mu.maven.controller.ShopperController;
import edu.mu.maven.inventory.Item;
import edu.mu.maven.model.ShopperModel;

public class ShoppingKorean {
	public static void ShopKorean(Scanner scanner, List<Item> item, ShopperModel shopperModel) {
	    final String Region = "KOREAN";
	    System.out.println("Please pick what item you'd like!");
	    boolean check = true;
	    while(check) {
	    	int count = 1;
	    	List<Item> tempItems = new ArrayList<>();
	        try {
	            for(Item items: item) {
	                if(items.getRegion().toString().toUpperCase().equals(Region)) {
	                    System.out.println(count +"."+items.getName()+"-$" +items.getPrice()+" - "+items.getStock()+" left in stock");
	                    tempItems.add(items);
	                    count++;
	                }
	            }
	        }catch(NumberFormatException error){
	            System.err.println("Invalid Input. Please try again");
	        }
	        int numItems = tempItems.size();
	        System.out.println(count + ".Go back");
	        try {
	            int choice = scanner.nextInt();
	            if(choice > 0 && choice <= numItems) {
	                Item chosenItem = tempItems.get(choice - 1);
	                if (ShoppingMenu.stockDecrement(chosenItem) > 0) {
	                    ShoppingMenu.addItemtoCart(shopperModel, chosenItem);
	                }
	                check = true;
	            } else if(choice == numItems + 1) {
	                ShoppingMenu.Menu(scanner, tempItems, shopperModel);
	            }
	            else {
	            	System.err.println("Invalid Input. Please enter a Integer corresponding to a food option.");
	                check = true;
	           }
	        } catch (InputMismatchException e) {
	            System.err.println("Invalid input. Please enter a Integer.");
	            scanner.next();	        
	         }
	        
        }
    }
}
