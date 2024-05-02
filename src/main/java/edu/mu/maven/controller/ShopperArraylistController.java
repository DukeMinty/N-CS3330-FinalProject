package edu.mu.maven.controller;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import edu.mu.maven.model.ShopperArraylistModel;
import edu.mu.maven.model.ShopperModel;
import edu.mu.maven.view.ShopperArraylistView;
import edu.mu.maven.view.ShopperView;

public class ShopperArraylistController {
	
	private ShopperArraylistModel model;
	private ShopperArraylistView view;
	
	
	private final String shopperInfoPath = "files/shoppers.txt";
	
	public ShopperArraylistController(ShopperArraylistModel model, ShopperArraylistView view) {
		this.model = model;
		this.view = view;
	}
	
	public void addShopperToList(ShopperModel shopper) {
		model.addShopper(shopper);
	}
	
	public void removeShopperFromList(ShopperModel shopper) {
		model.removeShopper(shopper);
	}
	
	public boolean loadShoppersFromFile(){
		try (BufferedReader reader = new BufferedReader(new FileReader(shopperInfoPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 3) {
                	try {
                        String username = parts[0];
                        String password = parts[1];
                        double accountBalance = Double.parseDouble(parts[2]);

                        ShopperModel shopper = new ShopperModel(username, password, accountBalance);
                        addShopperToList(shopper);
                	} catch (NumberFormatException e) {
                		e.printStackTrace();
                		return false;
                	}

                } else {
                    System.out.println("Skipping shopper line due to incorrect format");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
		return true;
	}
	
	public boolean refreshSourceFile() {
		try {
			FileWriter accountInfoWriter = new FileWriter(shopperInfoPath);
            BufferedWriter bufferedWriter = new BufferedWriter(accountInfoWriter);
            for (ShopperModel shopper : model.getList()) {
                ShopperController shopperController = new ShopperController(shopper, new ShopperView());
                bufferedWriter.write(shopperController.getShopperUsername()+","+shopperController.getShopperPassword()+","+shopperController.getShopperBalance());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
		}catch(Exception e) {
			System.out.println("So sorry! Something went wrong refreshing an account!\n");
			return false;
		}
		return true;
	}
	
	public boolean checkUsernameRepeat(String regUsername) {
		for(ShopperModel shopper : model.getList()) {
			ShopperController shopperController = new ShopperController(shopper, new ShopperView());
			if(regUsername.equals(shopperController.getShopperUsername())) {
				return true;
			}
		}
		return false;
	}
	
	public ShopperModel checkShopperExistence(String logUsername, String logPassword) {
		for(ShopperModel shopper : model.getList()) {
			ShopperController shopperController = new ShopperController(shopper, new ShopperView());
			if(logUsername.equals(shopperController.getShopperUsername()) && logPassword.equals(shopperController.getShopperPassword())) {
				return shopper;
			}
		}
		return null;
	}
	
	public boolean updateView() {
		view.printAllShoppers(model);
		return true;
	}

}
