package edu.mu.maven.users.controller;

import edu.mu.maven.users.Admin;
import edu.mu.maven.users.view.AdminView;

//Created by Aaron Trebus
//Class is the controller for Admin objects

//Feel free to add more as necessary for the project's growth

public class AdminController {
	
	private Admin model;
	private AdminView view;
	
	public AdminController(Admin model, AdminView view) {
		this.model=model;
		this.view=view;
	}
	
	public String getAdminUsername() {
		return model.getUsername();
	}
	
	public String getAdminPassword() {
		return model.getPassword();
	}
	
	public void updateView() {
		view.printAdminDetails(model);
	}

}
