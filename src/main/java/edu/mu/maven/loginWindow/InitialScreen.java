package edu.mu.maven.loginWindow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.maven.users.Admin;
import edu.mu.maven.users.Shopper;

public class InitialScreen {
	
	final String shopperInfoPath = "files/shoppers.txt";
	final String adminInfoPath = "files/admins.txt";
	
	private ArrayList<Shopper> shoppers = new ArrayList<>();
	private ArrayList<Admin> admins = new ArrayList<>();
	private int initializerLoopCheckFlag = 0;
	
	public InitialScreen(Scanner scanner) {
		//Loads all users from their files, will only run once to save memory
		if(initializerLoopCheckFlag == 0) {
			loadShoppersFromFile();
			loadAdminsFromFile();
			initializerLoopCheckFlag++;
		}
		//Displays menu and gets user input
		menu(scanner);
	}
	
	public void menu(Scanner scanner) {
		
		boolean menuLoop = true;
		int userMenuInput = 0;
		
		System.out.println("WORLD MARKET!!!!\n");
		System.out.println("1. Register\n2. Login\n3. Exit");
        while (menuLoop) {
            try {
                userMenuInput = Integer.parseInt(scanner.nextLine());
                if(userMenuInput >= 1 && userMenuInput <=3) {
                	menuLoop = false;
                }else {
                	System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input");
            }
        }
        
        //Interpreting user input to move them to another class, or end the program
        switch(userMenuInput) {
        case 1:
        	new Register(shoppers, shopperInfoPath, scanner);
        	menu(scanner);
        case 2:
        	new Login(shoppers, admins, scanner);
        case 3:
        	System.exit(0);
        }
	}
	
	public void loadShoppersFromFile(){
		try (BufferedReader reader = new BufferedReader(new FileReader(shopperInfoPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 3) {
                	try {
                        String username = parts[0];
                        String password = parts[1];
                        double accountBalance = Double.parseDouble(parts[2]);

                        Shopper shopper = new Shopper(username, password, accountBalance);
                        shoppers.add(shopper);
                	} catch (NumberFormatException e) {
                		e.printStackTrace();
                	}

                } else {
                    System.out.println("Skipping line due to incorrect format");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void loadAdminsFromFile(){
		try (BufferedReader reader = new BufferedReader(new FileReader(adminInfoPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 2) {
                	try {
                        String username = parts[0];
                        String password = parts[1];

                        Admin admin = new Admin(username, password);
                        admins.add(admin);
                	} catch (NumberFormatException e) {
                		e.printStackTrace();
                	}

                } else {
                    System.out.println("Skipping line due to incorrect format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
