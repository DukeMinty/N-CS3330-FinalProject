package edu.mu.maven.loginWindow;

import java.util.Scanner;

public class InitialScreen {
	
	UserSourceManager manager = new UserSourceManager();
	private int initializerLoopCheckFlag = 0;
	
	public InitialScreen(Scanner scanner) {
		//Loads all users from their files, will only run once to save memory
		if(initializerLoopCheckFlag == 0) {
			manager.LoadShoppersFromFile();
			manager.LoadAdminsFromFile();
			initializerLoopCheckFlag++;
		}
		//Displays menu and gets user input
		UserMenu(scanner);
	}
	
	public void UserMenu(Scanner scanner) {
		
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
        	new Register(scanner, manager);
        	UserMenu(scanner);
        case 2:
        	new Login(scanner, manager);
        case 3:
        	System.exit(0);
        }
	}

}
