package edu.mu.maven.loginRegister;

import java.util.Scanner;

import edu.mu.maven.Main;
import edu.mu.maven.controller.ShopperArraylistController;
import edu.mu.maven.model.ShopperModel;

//Created by Aaron Trebus

//Class displays the Login window after the user choses it on InitialScreen

public class ShopperLogin {
	
	public static ShopperModel login(Scanner scanner, ShopperArraylistController shopperArrayController) {
		
		while(true) {
			
			String logUsername = "";
			String logPassword = "";
			
			System.out.println("Enter username:");
			logUsername = scanner.nextLine();
			
			System.out.println("Enter password:");
			logPassword = scanner.nextLine();
			
			ShopperModel loggedInShopper = shopperArrayController.checkShopperExistence(logUsername, logPassword);
			if(loggedInShopper != null) {
				return loggedInShopper;
			}
			else {
				System.out.println("User not found, would you like to try again? Y or N");
				String userChoice = scanner.nextLine().toUpperCase();
				if(userChoice.equals("Y")) {
					continue;
				}
				else {
					Main.callMain();
				}
			}
		}
	}

}
