package edu.mu.maven.userOptions;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.mu.maven.Main;
import edu.mu.maven.controller.ShopperArraylistController;
import edu.mu.maven.controller.ShopperController;
import edu.mu.maven.model.ShopperModel;
import edu.mu.maven.view.ShopperView;

//Created by Aaron Trebus

//This is the screen a logged in shopper will be passed to 
//Gives options for their account or lets them pass straight to shopping

public class ShopperOptions {
	
	public ShopperOptions(Scanner scanner, ShopperController shopperController, ShopperArraylistController shopperArrayController) {

		while(true) {
			
			int userMenuInput = menuChoice(scanner, shopperController);

			switch(userMenuInput) {
			case 1:
				break;
			case 2:
				changeUsername(scanner, shopperController, shopperArrayController);
				continue;
			case 3:
				addToBalance(shopperController, scanner,shopperArrayController);
				continue;
			case 4:
				Main.callMain();
			}
			break;
		}
	}
	
	public int menuChoice(Scanner scanner, ShopperController controller) {

		System.out.println("Hello " + controller.getShopperUsername() + "! What would you like to do today?\n");
		System.out.println("1. Shop\n2. Change Username\n3. Add to balance\n4. Logout");
		
		int userMenuInput = 0;
		
        while (userMenuInput == 0) {
            try {
                userMenuInput = Integer.parseInt(scanner.nextLine());
                if(userMenuInput >= 1 && userMenuInput <=4) {
                	break;
                }else {
                	System.out.println("Invalid choice");
                	userMenuInput = 0;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input");
                userMenuInput = 0;
            }
        }
        return userMenuInput;
	}
	public void changeUsername(Scanner scanner, ShopperController controller, ShopperArraylistController shopperArrayController) {
		System.out.println("Enter new username:");
		String newUsername = scanner.nextLine();
		controller.setShopperUsername(newUsername);
		shopperArrayController.refreshSourceFile();
		System.out.println("Got it " + controller.getShopperUsername() + "!");
	}
	
	public void addToBalance(ShopperController controller, Scanner scanner, ShopperArraylistController shopperArrayController) {
    	System.out.println("How much would you like to add?");
    	System.out.print("$");
    	double amountAddition = 0;
    	while(true) {
    		try {
    			amountAddition = scanner.nextDouble();
    		}catch (InputMismatchException e) {
    			System.out.println("Invalid input.");
    			continue;
    		}
    		controller.addToShopperBalance(amountAddition);
    		shopperArrayController.refreshSourceFile();
    		System.out.println("Success! Current balance is: $" + controller.getShopperBalance());
    	}
	}

}
