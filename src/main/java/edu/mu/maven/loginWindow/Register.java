package edu.mu.maven.loginWindow;

import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.maven.users.Shopper;

public class Register {
	
	Scanner scanner = new Scanner(System.in);
	String regUsername;
	String regPassword;
	String conPassword;
	
	public Register(ArrayList<Shopper> shopperList) {
		System.out.println("Thank you for choosing to make an account with World Market!\n");
		System.out.println("All users start with a $20 gratuity account balance, on us!\n\n");
		
		while(true) {
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
			else {
				break;
			}

		}
		try {
			shopperList.add(new Shopper(regUsername, regPassword, 20));
		}catch(Exception e) {
			System.out.println("So sorry! Something went wrong adding your account!");
		}

	}

}
