package edu.mu.maven.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.mu.maven.model.AdminArraylistModel;
import edu.mu.maven.model.AdminModel;
import edu.mu.maven.view.AdminArraylistView;

public class AdminArraylistController {
	
	private AdminArraylistModel model;
	private AdminArraylistView view;
	
	private final String adminInfoPath = "files/admins.txt";
	
	public AdminArraylistController(AdminArraylistModel model, AdminArraylistView view) {
		this.model = model;
		this.view = view;
	}
	
	public void AddAdminToList(AdminModel admin) {
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
                        AddAdminToList(model);
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
	
	public void UpdateView() {
		view.printAllAdmins(model);
	}

}
