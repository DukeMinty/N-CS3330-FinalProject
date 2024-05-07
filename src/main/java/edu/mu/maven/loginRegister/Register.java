package edu.mu.maven.loginRegister;

import java.util.Scanner;

import edu.mu.maven.controller.ShopperArraylistController;
import edu.mu.maven.model.ShopperModel;

//Created by Aaron Trebus

//Class is the window that allows the input for creation of a new Shopper if the user chose it on InitialScreen

//Prompt the user for their desired username, the password they want, and to repeat the password

//Accounts for issues such as:
//Having a necessary password length
//Ensuring a Shopper with the same name as another cannot be made
//Ensuring error handling if some part of object creation and list addition went wrong

public class Register {
	
	public Register(Scanner scanner, ShopperArraylistController shopperArrayController) {
		
		System.out.println("Thank you for choosing to make an account with World Market!\n");
		System.out.println("All users start with a $20 gratuity account balance, on us!\n\n");
		
		while(true) {
			
			String regUsername = "";
			String regPassword = "";
			String conPassword = "";

			System.out.println("Enter username:");
			regUsername = scanner.nextLine();

			System.out.println("Enter password (must be at least 6 characters long):");
			regPassword = scanner.nextLine();

			System.out.println("Confirm password:");
			conPassword = scanner.nextLine();

			if(!regPassword.equals(conPassword)) {
				System.out.println("Passwords do not match.\n");
				continue;
			}
			if(regPassword.length() < 6) {
				System.out.println("Password choice is not safe\n");
				continue;
			}
			if(shopperArrayController.checkUsernameRepeat(regUsername) == true) {
				System.out.println("Username is already taken.\n");
				continue;
			}
			shopperArrayController.addShopperToList(new ShopperModel(regUsername, regPassword, 20));
			shopperArrayController.refreshSourceFile();
			break;

		}
	}
}
