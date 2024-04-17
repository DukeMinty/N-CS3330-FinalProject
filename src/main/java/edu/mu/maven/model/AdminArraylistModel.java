package edu.mu.maven.model;

import java.util.ArrayList;

public class AdminArraylistModel {
	
	private ArrayList<AdminModel> adminList;
	
	public AdminArraylistModel() {
		adminList = new ArrayList<>();
	}
	
	public void addAdmin(AdminModel admin) {
		adminList.add(admin);
	}
	
//	public void removeAdmin(AdminModel admin) {
//		adminList.remove(admin);
//	}
	
	public ArrayList<AdminModel> getList() {
		return adminList;
	}

}
