package edu.mu.maven.loginRegister;

import java.util.Scanner;

import edu.mu.maven.Main;
import edu.mu.maven.controller.AdminArraylistController;
import edu.mu.maven.model.AdminModel;

public class AdminLogin {
	
public static AdminModel login(Scanner scanner, AdminArraylistController adminArrayController) {
		
		while(true) {
			
			String logUsername = "";
			String logPassword = "";
			
			System.out.println("Enter username:");
			logUsername = scanner.nextLine();
			
			System.out.println("Enter password:");
			logPassword = scanner.nextLine();
			
			AdminModel loggedInAdmin = adminArrayController.checkAdminExistence(logUsername, logPassword);
			if(loggedInAdmin != null) {
				return loggedInAdmin;
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
