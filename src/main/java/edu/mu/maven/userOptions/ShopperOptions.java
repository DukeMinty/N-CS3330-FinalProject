package edu.mu.maven.userOptions;

import java.util.Scanner;

import edu.mu.maven.loginWindow.InitialScreen;
import edu.mu.maven.loginWindow.Login;
import edu.mu.maven.loginWindow.Register;
import edu.mu.maven.users.Shopper;
import edu.mu.maven.users.controller.ShopperController;
import edu.mu.maven.users.view.ShopperView;

public class ShopperOptions {
	
	ShopperController controller;
	ShopperView view;
	
	public ShopperOptions(Shopper shopper, Scanner scanner) {
		controller = new ShopperController(shopper, view);
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
    
        case 2:
   
        case 3:
        	
        case 4:
        	InitialScreen goBack = new InitialScreen(scanner);
        	goBack.UserMenu(scanner);
        }
	}

}
