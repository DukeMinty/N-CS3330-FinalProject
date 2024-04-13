package edu.mu.maven.loginWindow;

import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.maven.userOptions.AdminOptions;
import edu.mu.maven.userOptions.ShopperOptions;
import edu.mu.maven.users.Admin;
import edu.mu.maven.users.Shopper;
import edu.mu.maven.users.controller.AdminController;
import edu.mu.maven.users.controller.ShopperController;
import edu.mu.maven.users.view.AdminView;
import edu.mu.maven.users.view.ShopperView;

public class Login {
	
	ShopperController shopperController;
	ShopperView shopperView;
	
	AdminController adminController;
	AdminView adminView;
	
	public Login(ArrayList<Shopper> shopperList, ArrayList<Admin> adminList) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			String logUsername = "";
			String logPassword = "";
			
			System.out.println("Enter username:\n");
			logUsername = scanner.nextLine();
			
			System.out.println("Enter password:\n");
			logPassword = scanner.nextLine();
			
			scanner.close();
			
			Shopper loggedInShopper = checkShopperExistence(logUsername, logPassword, shopperList);
			if(loggedInShopper != null) {
				new ShopperOptions(loggedInShopper);
				break;
			}
			
			Admin loggedInAdmin = checkAdminExistence(logUsername, logPassword, adminList);
			if(loggedInAdmin != null) {
				new AdminOptions(loggedInAdmin);
				break;
			}
			
			System.out.println("User not found, would you like to try again? Y or N\n");
			
			Scanner repeatScanner = new Scanner(System.in);
			String userChoice = repeatScanner.nextLine().toUpperCase();
			if(userChoice == "Y") {
				repeatScanner.close();
				continue;
			}
			else {
				repeatScanner.close();
				break;
			}
			

		}	
	}
	
	//Checks for an existing shopper in the database, returns null if non existant
	public Shopper checkShopperExistence(String logUsername, String logPassword, ArrayList<Shopper> shopperList) {
		
		for(Shopper shopper : shopperList) {
			shopperController = new ShopperController(shopper, shopperView);
			if(logUsername.equals(shopperController.getShopperUsername()) && logPassword.equals(shopperController.getShopperPassword())) {
				return shopper;
			}
		}
		return null;
	}
	
	public Admin checkAdminExistence(String logUsername, String logPassword, ArrayList<Admin> adminList) {
		for(Admin admin : adminList) {
			adminController = new AdminController(admin, adminView);
			if(logUsername.equals(adminController.getAdminUsername()) && logPassword.equals(adminController.getAdminPassword())) {
				return admin;
			}
		}
		return null;
	}

}
