package edu.mu.maven.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.mu.maven.model.AdminArraylistModel;
import edu.mu.maven.model.AdminModel;
import edu.mu.maven.view.AdminArraylistView;
import edu.mu.maven.view.AdminView;

//Made by Aaron Trebus

//Class defines the boundaries and capabilties of the controller for the admin arraylist

public class AdminArraylistController {
	
	private AdminArraylistModel model;
	private AdminArraylistView view;
	
	private final String adminInfoPath = "files/admins.txt";
	
	public AdminArraylistController(AdminArraylistModel model, AdminArraylistView view) {
		this.model = model;
		this.view = view;
	}
	
	public void addAdminToList(AdminModel admin) {
		model.addAdmin(admin);
	}
	
	public boolean loadAdminsFromFile(){
		try (BufferedReader reader = new BufferedReader(new FileReader(adminInfoPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 2) {
                	try {
                        String username = parts[0];
                        String password = parts[1];

                        AdminModel model = new AdminModel(username, password);
                        addAdminToList(model);
                	} catch (NumberFormatException e) {
                		e.printStackTrace();
                		return false;
                	}

                } else {
                    System.out.println("Skipping admin line due to incorrect format");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
		return true;
	}
	
	public AdminModel checkAdminExistence(String logUsername, String logPassword) {
		for(AdminModel admin : model.getList()) {
			AdminController adminController = new AdminController(admin, new AdminView());
			if(logUsername.equals(adminController.getAdminUsername()) && logPassword.equals(adminController.getAdminPassword())) {
				return admin;
			}
		}
		return null;
	}
	
	public boolean UpdateView() {
		view.printAllAdmins(model);
		return true;
	}

}
