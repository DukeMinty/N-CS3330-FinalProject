package edu.mu.maven.userOptions;
import edu.mu.maven.model.AdminModel;
import edu.mu.maven.model.ShopperModel;
import edu.mu.maven.model.ShopperArraylistModel;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import edu.mu.maven.inventory.Item;
import edu.mu.maven.inventory.InventoryLoader;
import edu.mu.maven.inventory.Region;
import edu.mu.maven.controller.ShopperArraylistController;
import edu.mu.maven.controller.AdminController;

import java.util.List;

import edu.mu.maven.Main;
 

// created by Jacob York

public class AdminOptions {
	
	 private Scanner scanner;
	 private ShopperArraylistController shopperController;
	 private List<Item> items;
	 
	public AdminOptions(Scanner scanner, AdminModel loggedInAdmin, ShopperArraylistController shopperarrayControllers) {
		
		this.scanner = scanner;
		this.shopperController = shopperarrayControllers;
		
		InventoryLoader inventoryLoader = new InventoryLoader();
        try {
            this.items = inventoryLoader.loadItemsFromFile("files/inventory.txt"); // Use InventoryLoader to get the items
        } catch (IOException e) {
            System.err.println("Failed to load inventory items: ");
        }
        
        displayMenu(); //call the method to display the admin menu
	}


	public void displayMenu() {
		int choice;
		do {
			System.out.println("Hello! What would you like to do?");
            System.out.println("1. Add stock to inventory");
            System.out.println("2. Delete shopper accounts");
            System.out.println("3. Change price of inventory");
            System.out.println("4. Logout");
            
            System.out.print("Enter choice: ");
            choice = safeIntegerInput(); //use safe input method
            
            switch(choice) {
                case 1:
                    addStockToInventory();
                    break;
                case 2:
                    deleteShopperAccounts();
                    break;
                case 3:
                    changePriceOfInventory();
                    break;
                case 4:
                    Main.callMain(); // return to main
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
		} while (choice != 4);
	}
	
	private int safeIntegerInput(){
		while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
	}
	
	private void addStockToInventory() {
		System.out.print("Enter the ID of the item to add stock to: ");
	    String id = scanner.nextLine();
	    System.out.print("Enter the amount of stock to add: ");
	    int amountToAdd = safeIntegerInput();

	    Item item = findItemById(items, id);
	    if (item != null) {
	        item.setStock(item.getStock() + amountToAdd);
	        System.out.println("Stock added. New stock for " + item.getName() + ": " + item.getStock());
	    } else {
	        System.out.println("Item not found.");
	    }
	}
	
	private Item findItemById(List<Item> items, String id) {
	    for (Item item : items) {
	        if (item.getId().equals(id)) {
	            return item;
	        }
	    }
	    return null;
	}
	
	private void deleteShopperAccounts() {
		System.out.println("Enter the username of the shopper to delete: ");
		String username = scanner.nextLine();
		System.out.println("Enter the password of the shopper to delete: ");
		String password = scanner.nextLine();
		
		//check for the existence of the shopper
		if (shopperController != null) {
			ShopperModel foundShopper = shopperController.checkShopperExistence(username, password);
			if (shopperController != null && foundShopper != null) {
				shopperController.removeShopperFromList(foundShopper);
				shopperController.refreshSourceFile();
				System.out.println("Shopper account deleted successfully.");
			} else {
				System.out.println("Shopper account not found.");
			}
		} else {
				System.out.println("Shopper controller is not initialized.");
		}
	}

	
	private void changePriceOfInventory() {
		System.out.print("Enter the ID of the item to change its price: ");
	    String id = scanner.nextLine();
	    System.out.print("Enter the new price for the item: ");
	    double newPrice = scanner.nextDouble(); 
	    scanner.nextLine();

	    Item item = findItemById(items, id);
	    if (item != null) {
	        item.setPrice(newPrice);
	        try{
	        	new InventoryLoader().saveItemsToFile(items, "files/inventory.txt"); //update price in inventory.txt
		        System.out.println("Price changed. New price for " + item.getName() + ": " + item.getPrice());
	        } catch (IOException e) {
	        	System.err.println("Error while updating the file: " + e.getMessage());
	        }

	    } else {
	        System.out.println("Item not found.");
	    }
	}
	
}

