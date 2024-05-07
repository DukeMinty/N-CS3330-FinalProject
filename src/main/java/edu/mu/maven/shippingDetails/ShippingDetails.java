package edu.mu.maven.shippingDetails;

import java.util.Scanner;

import edu.mu.maven.address.Address;

public class ShippingDetails {
	public static Address readShippingDetails(Scanner scanner) {
		Address userAddress = new Address();
		
		System.out.println("Please prove the shipping address below.");
		
		userAddress.setStreet(promptInfo("street address", scanner));
		userAddress.setCity(promptInfo("city", scanner));
		userAddress.setRegion(promptInfo("region/state/province", scanner));
		userAddress.setZipcode(promptInfo("zipcode", scanner));
		userAddress.setCountry(promptInfo("country", scanner));
		
		return userAddress;
	}
	
	public static void readBankingDetails(Scanner scanner) {
		System.out.println("Please prove the billing information below.");
		promptInfo("routing number", scanner);
		promptInfo("account number", scanner);
	}
	
	private static String promptInfo(String info, Scanner scanner) {
		// Prompts the user to "Please enter the (info):" and returns the answer
		String ans = "";
		while (ans.equals("")) {
			System.out.printf("Please enter the %s:\n", info);
			ans = scanner.nextLine();
		}
		
		return ans;
	}
}
