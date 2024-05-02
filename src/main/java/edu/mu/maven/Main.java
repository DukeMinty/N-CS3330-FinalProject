package edu.mu.maven;

import java.util.Scanner;

import edu.mu.maven.controller.AdminArraylistController;
import edu.mu.maven.controller.ShopperArraylistController;
import edu.mu.maven.controller.ShopperController;
import edu.mu.maven.loginRegister.ShopperLogin;
import edu.mu.maven.loginRegister.AdminLogin;
import edu.mu.maven.loginRegister.Register;
import edu.mu.maven.model.AdminArraylistModel;
import edu.mu.maven.model.AdminModel;
import edu.mu.maven.model.ShopperArraylistModel;
import edu.mu.maven.model.ShopperModel;
import edu.mu.maven.userOptions.AdminOptions;
import edu.mu.maven.userOptions.ShopperOptions;
import edu.mu.maven.view.AdminArraylistView;
import edu.mu.maven.view.ShopperArraylistView;
import edu.mu.maven.view.ShopperView;

public class Main {
	
	private static boolean initialized = false;
	static Scanner scanner = new Scanner(System.in);
	
	static ShopperArraylistController shopperArrayController = null;
	static AdminArraylistController adminArrayController = null;

	public static void main(String[] args) {
		
		if(!initialized) {
			shopperArrayController = initializeShopperArraylistController();
			adminArrayController = initializeAdminArraylistController();
			initialized = true;
		}
		
		ShopperModel shopperModel = null;
		AdminModel adminModel = null;
		
		while(true) {
			int menuChoice = initialMenuChoice();
			
	        switch(menuChoice) {
	        case 1:
	        	new Register(scanner, shopperArrayController);
	        	continue;
	        case 2:
	        	shopperModel = ShopperLogin.login(scanner, shopperArrayController);
	        	break;
	        case 3:
	        	adminModel = AdminLogin.login(scanner, adminArrayController);
	        	//This 
	        	new AdminOptions(scanner, adminModel, shopperArrayController);
	        case 4:
	        	System.exit(0);
	        default:
	        	System.out.println("Error detected in menu choice");
	        	System.exit(0);
	        }
	        break;
		}
		
		ShopperController shopperController = new ShopperController(shopperModel, new ShopperView());
		
		new ShopperOptions(scanner, shopperController, shopperArrayController);
		
		//This is where the call for the Shop itself will start
		//new nameofshop(<whatever you need to pass in>)

	}
	
	public static ShopperArraylistController initializeShopperArraylistController() {
		ShopperArraylistModel shopperArrayModel = new ShopperArraylistModel();
		ShopperArraylistView shopperArrayView = new ShopperArraylistView();
		ShopperArraylistController shopperArrayController = new ShopperArraylistController(shopperArrayModel, shopperArrayView);
		
		shopperArrayController.loadShoppersFromFile();
		
		return shopperArrayController;
	}
	public static AdminArraylistController initializeAdminArraylistController() {
		AdminArraylistModel adminArrayModel = new AdminArraylistModel();
		AdminArraylistView adminArrayView = new AdminArraylistView();
		AdminArraylistController adminArrayController = new AdminArraylistController(adminArrayModel, adminArrayView);
		
		adminArrayController.loadAdminsFromFile();
		
		return adminArrayController;
	}
	
	public static int initialMenuChoice(){
		
		int userMenuInput = 0;
		
		System.out.println("WORLD MARKET!!!!\n");
		System.out.println("1. Register\n2. Shopper Login\n3. Admin Login\n4. Exit");
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
	
    public static void callMain() {
        String[] args = {};
        main(args);
    }

}
