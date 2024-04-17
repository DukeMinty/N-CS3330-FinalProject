package edu.mu.maven.view;

import edu.mu.maven.model.AdminArraylistModel;
import edu.mu.maven.model.AdminModel;

public class AdminArraylistView {
	
	public void printAllAdmins(AdminArraylistModel model) {
		for(AdminModel admins : model.getList()) {
			System.out.println(admins.toString());
		}
	}

}
