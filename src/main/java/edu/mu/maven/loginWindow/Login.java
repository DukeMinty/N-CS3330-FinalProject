package edu.mu.maven.loginWindow;

import java.util.Scanner;
import edu.mu.maven.userOptions.AdminOptions;
import edu.mu.maven.userOptions.ShopperOptions;
import edu.mu.maven.users.Admin;
import edu.mu.maven.users.Shopper;

//Created by Aaron Trebus

//Class displays the Login window after the user choses it on InitialScreen

public class Login {
	
	public Login(Scanner scanner, UserSourceManager manager) {
		
		while(true) {
			
			String logUsername = "";
			String logPassword = "";
			
			System.out.println("Enter username:");
			logUsername = scanner.nextLine();
			
			System.out.println("Enter password:");
			logPassword = scanner.nextLine();
			
			Shopper loggedInShopper = manager.CheckShopperExistence(logUsername, logPassword);
			if(loggedInShopper != null) {
				new ShopperOptions(loggedInShopper, scanner, manager);
				break;
			}
			
			Admin loggedInAdmin = manager.CheckAdminExistence(logUsername, logPassword);
			if(loggedInAdmin != null) {
				new AdminOptions(loggedInAdmin, scanner, manager);
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

}
