package edu.mu.maven.loginWindow;

import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.maven.users.Shopper;
import edu.mu.maven.users.controller.ShopperController;
import edu.mu.maven.users.view.ShopperView;

//Created by Aaron Trebus

//Class is the window that allows the input for creation of a new Shopper if the user chose it on InitialScreen

//Prompt the user for their desired username, the password they want, and to repeat the password

//Accounts for issues such as:
//Having a necessary password length
//Ensuring a Shopper with the same name as another cannot be made
//Ensuring error handling if some part of object creation and list addition went wrong

public class Register {
	
	ShopperController controller;
	ShopperView view;
	
	public Register(ArrayList<Shopper> shopperList) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Thank you for choosing to make an account with World Market!\n");
		System.out.println("All users start with a $20 gratuity account balance, on us!\n\n");
		
		while(true) {
			
			String regUsername = "";
			String regPassword = "";
			String conPassword = "";
			
			System.out.println("Enter username:\n");
			regUsername = scanner.nextLine();
			
			System.out.println("Enter password (must be at least 6 characters long):\n");
			regPassword = scanner.nextLine();
			
			System.out.println("Confirm password:\n");
			conPassword = scanner.nextLine();

			if(!regPassword.equals(conPassword)) {
				System.out.println("Passwords do not match.\n");
				continue;
			}
			else if(regPassword.length() <= 6) {
				System.out.println("Password choice is not safe");
				continue;
			}
			else if(checkUsernameRepeat(shopperList, regUsername) == true) {
				System.out.println("Username is already taken.\n");
				continue;
			}
			else {
				try {
					shopperList.add(new Shopper(regUsername, regPassword, 20));
				}catch(Exception e) {
					System.out.println("So sorry! Something went wrong adding your account!");
				}
				break;
			}

		}
		//Close the scanner
		scanner.close();
	}
	
	public boolean checkUsernameRepeat(ArrayList<Shopper> shopperList, String regUsername) {
		for(Shopper shopper : shopperList) {
			controller = new ShopperController(shopper, view);
			if(regUsername.equals(controller.getShopperUsername())) {
				return true;
			}
		}
		return false;
	}

}
