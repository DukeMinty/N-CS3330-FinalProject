package edu.mu.maven.userOptions;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.mu.maven.loginWindow.InitialScreen;
import edu.mu.maven.loginWindow.UserSourceManager;
import edu.mu.maven.users.Shopper;
import edu.mu.maven.users.controller.ShopperController;
import edu.mu.maven.users.view.ShopperView;

public class ShopperOptions {
	
	public ShopperOptions(Shopper shopper, Scanner scanner, UserSourceManager manager) {
		
		ShopperController controller = new ShopperController(shopper, new ShopperView());
		
		boolean menuLoop = true;
		int userMenuInput = 0;
		
		System.out.println("Hello " + controller.getShopperUsername() + "! What would you like to do today?\n");
		System.out.println("1. Shop\n2. Change Username\n3. Add to balance\n4. Logout");

        while (menuLoop) {
            try {
                userMenuInput = Integer.parseInt(scanner.nextLine());
                if(userMenuInput >= 1 && userMenuInput <=4) {
                	menuLoop = false;
                }else {
                	System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input");
            }
        }
        switch(userMenuInput) {
        case 1:
//        	new Shop(shopper, scanner);
        case 2:
        	ChangeUsername(controller,scanner,manager);
        	new ShopperOptions(shopper, scanner, manager);
        case 3:
        	AddToBalance(controller, scanner);
        	new ShopperOptions(shopper,scanner,manager);
        case 4:
        	InitialScreen goBack = new InitialScreen(scanner);
        	goBack.UserMenu(scanner);
        }
	}
	public void ChangeUsername(ShopperController controller, Scanner scanner, UserSourceManager manager) {
		System.out.println("Enter new username:");
		String newUsername = scanner.nextLine();
		controller.setShopperUsername(newUsername);
		manager.RefreshFile();
		System.out.println("Got it " + controller.getShopperUsername() + "!");
	}
	
	public void AddToBalance(ShopperController controller, Scanner scanner) {
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
    		System.out.println("Success! Current balance is: $" + controller.getShopperBalance());
    	}
	}

}
