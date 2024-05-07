package edu.mu.maven.view;

import edu.mu.maven.model.AdminArraylistModel;
import edu.mu.maven.model.AdminModel;

//Created by Aaron Trebus

public class AdminArraylistView {
	
	public void printAllAdmins(AdminArraylistModel model) {
		for(AdminModel admins : model.getList()) {
			System.out.println(admins.toString());
		}
	}

}
