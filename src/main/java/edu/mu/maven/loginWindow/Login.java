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

//Created by Aaron Trebus

//Class displays the Login window after the user choses it on InitialScreen

public class Login {
	
	ShopperController shopperController;
	ShopperView shopperView;
	
	AdminController adminController;
	AdminView adminView;
	
	public Login(ArrayList<Shopper> shopperList, ArrayList<Admin> adminList, Scanner scanner) {
		
		while(true) {
			
			String logUsername = "";
			String logPassword = "";
			
			System.out.println("Enter username:");
			logUsername = scanner.nextLine();
			
			System.out.println("Enter password:");
			logPassword = scanner.nextLine();
			
			Shopper loggedInShopper = CheckShopperExistence(logUsername, logPassword, shopperList);
			if(loggedInShopper != null) {
				new ShopperOptions(loggedInShopper, scanner);
				break;
			}
			
			Admin loggedInAdmin = CheckAdminExistence(logUsername, logPassword, adminList);
			if(loggedInAdmin != null) {
				new AdminOptions(loggedInAdmin, scanner);
				break;
			}
			
			System.out.println("User not found, would you like to try again? Y or N");

			String userChoice = scanner.nextLine().toUpperCase();
			if(userChoice.equals("Y")) {
				continue;
			}
			else {
				break;
			}
			

		}
	}
	
	//Checks for an existing shopper in the database, returns null if non existant
	public Shopper CheckShopperExistence(String logUsername, String logPassword, ArrayList<Shopper> shopperList) {
		
		for(Shopper shopper : shopperList) {
			shopperController = new ShopperController(shopper, shopperView);
			if(logUsername.equals(shopperController.getShopperUsername()) && logPassword.equals(shopperController.getShopperPassword())) {
				return shopper;
			}
		}
		return null;
	}
	
	public Admin CheckAdminExistence(String logUsername, String logPassword, ArrayList<Admin> adminList) {
		for(Admin admin : adminList) {
			adminController = new AdminController(admin, adminView);
			if(logUsername.equals(adminController.getAdminUsername()) && logPassword.equals(adminController.getAdminPassword())) {
				return admin;
			}
		}
		return null;
	}

}
