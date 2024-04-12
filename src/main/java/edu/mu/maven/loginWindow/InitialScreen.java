package edu.mu.maven.loginWindow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.mu.maven.users.Shopper;

public class InitialScreen {
	
	final String accountInfoPath = "files/shoppers.txt";
	
	private ArrayList<Shopper> shoppers;
	
	public InitialScreen() {
		loadShoppersFromFile();
	}
	
	public void loadShoppersFromFile(){
		try (BufferedReader reader = new BufferedReader(new FileReader(accountInfoPath))) {
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
                    // Handle incorrect format or incomplete data
                    System.out.println("Skipping line due to incorrect format: " + line);
                }
            }
        } catch (IOException e) {
            // Handle file reading errors
            e.printStackTrace();
        }
	}

}
