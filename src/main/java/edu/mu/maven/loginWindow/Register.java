package edu.mu.maven.loginWindow;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
	
	public Register(ArrayList<Shopper> shopperList, String filePath, Scanner scanner) {
		
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
			else if(regPassword.length() <= 6) {
				System.out.println("Password choice is not safe\n");
				continue;
			}
			else if(CheckUsernameRepeat(shopperList, regUsername) == true) {
				System.out.println("Username is already taken.\n");
				continue;
			}
			else {
				try {
					FileWriter accountInfoWriter = new FileWriter(filePath);
		            BufferedWriter bufferedWriter = new BufferedWriter(accountInfoWriter);
					shopperList.add(new Shopper(regUsername, regPassword, 20));
		            for (Shopper shopper : shopperList) {
		                bufferedWriter.write(shopper.getUsername()+","+shopper.getPassword()+","+shopper.getAccountBalance());
		                bufferedWriter.newLine(); // Write a new line after each object
		            }
		            bufferedWriter.close();
				}catch(Exception e) {
					System.out.println("So sorry! Something went wrong adding your account!\n");
				}
				break;
			}

		}
	}
	
	public boolean CheckUsernameRepeat(ArrayList<Shopper> shopperList, String regUsername) {
		for(Shopper shopper : shopperList) {
			controller = new ShopperController(shopper, view);
			if(regUsername.equals(controller.getShopperUsername())) {
				return true;
			}
		}
		return false;
	}

}
