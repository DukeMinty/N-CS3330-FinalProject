package edu.mu.maven.controller;

import edu.mu.maven.model.AdminModel;
import edu.mu.maven.view.AdminView;

//Created by Aaron Trebus
//Class is the controller for Admin objects

//Feel free to add more as necessary for the project's growth

public class AdminController {
	
	private AdminModel model;
	private AdminView view;
	
	public AdminController(AdminModel model, AdminView view) {
		this.model=model;
		this.view=view;
	}
	
	public String getAdminUsername() {
		return model.getUsername();
	}
	
	public String getAdminPassword() {
		return model.getPassword();
	}
	
	public boolean updateView() {
		view.printAdminDetails(model);
		return true;
	}

}
