package edu.mu.maven.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.mu.maven.model.AdminArraylistModel;
import edu.mu.maven.model.AdminModel;
import edu.mu.maven.view.AdminArraylistView;
import edu.mu.maven.view.AdminView;

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
	
	public void loadAdminsFromFile(){
		try (BufferedReader reader = new BufferedReader(new FileReader(adminInfoPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length >= 3) {
                	try {
                        String username = parts[0];
                        String password = parts[1];

                        AdminModel model = new AdminModel(username, password);
                        addAdminToList(model);
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
	
	public AdminModel checkAdminExistence(String logUsername, String logPassword) {
		for(AdminModel admin : model.getList()) {
			AdminController adminController = new AdminController(admin, new AdminView());
			if(logUsername.equals(adminController.getAdminUsername()) && logPassword.equals(adminController.getAdminPassword())) {
				return admin;
			}
		}
		return null;
	}
	
	public void UpdateView() {
		view.printAllAdmins(model);
	}

}
