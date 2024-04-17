package edu.mu.maven.loginWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import edu.mu.maven.controller.AdminController;
import edu.mu.maven.controller.ShopperController;
import edu.mu.maven.model.AdminModel;
import edu.mu.maven.model.ShopperModel;
import edu.mu.maven.view.AdminView;
import edu.mu.maven.view.ShopperView;

public class UserSourceManager {
	
	final String shopperInfoPath = "files/shoppers.txt";
	final String adminInfoPath = "files/admins.txt";
	
	private ArrayList<ShopperModel> shoppers = new ArrayList<>();
	private ArrayList<AdminModel> admins = new ArrayList<>();
	
	ShopperController shopperController;
	ShopperView shopperView;
	
	AdminController adminController;
	AdminView adminView;
	
	public void LoadShoppersFromFile(){
		try (BufferedReader reader = new BufferedReader(new FileReader(shopperInfoPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 3) {
                	try {
                        String username = parts[0];
                        String password = parts[1];
                        double accountBalance = Double.parseDouble(parts[2]);

                        ShopperModel shopper = new ShopperModel(username, password, accountBalance);
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
		for(ShopperModel shopper : shoppers) {
			System.out.println(shopper.toString());
		}
	}
	
	public void LoadAdminsFromFile(){
		try (BufferedReader reader = new BufferedReader(new FileReader(adminInfoPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 2) {
                	try {
                        String username = parts[0];
                        String password = parts[1];

                        AdminModel admin = new AdminModel(username, password);
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
	
	public void RefreshFile() {
		try {
			FileWriter accountInfoWriter = new FileWriter(shopperInfoPath);
            BufferedWriter bufferedWriter = new BufferedWriter(accountInfoWriter);
            for (ShopperModel shopper : shoppers) {
                shopperController = new ShopperController(shopper, shopperView);
                bufferedWriter.write(shopperController.getShopperUsername()+","+shopperController.getShopperPassword()+","+shopperController.getShopperBalance());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
		}catch(Exception e) {
			System.out.println("So sorry! Something went wrong adding your account!\n");
		}
	}
	
	public void AddToShopperList(ShopperModel shopper) {
		shoppers.add(shopper);
	}
	
	public boolean CheckUsernameRepeat(String regUsername) {
		for(ShopperModel shopper : shoppers) {
			shopperController = new ShopperController(shopper, shopperView);
			if(regUsername.equals(shopperController.getShopperUsername())) {
				return true;
			}
		}
		return false;
	}
	
	public ShopperModel CheckShopperExistence(String logUsername, String logPassword) {
		
		for(ShopperModel shopper : shoppers) {
			shopperController = new ShopperController(shopper, shopperView);
			if(logUsername.equals(shopperController.getShopperUsername()) && logPassword.equals(shopperController.getShopperPassword())) {
				return shopper;
			}
		}
		return null;
	}
	
	public AdminModel CheckAdminExistence(String logUsername, String logPassword) {
		for(AdminModel admin : admins) {
			adminController = new AdminController(admin, adminView);
			if(logUsername.equals(adminController.getAdminUsername()) && logPassword.equals(adminController.getAdminPassword())) {
				return admin;
			}
		}
		return null;
	}

}
