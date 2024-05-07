package edu.mu.maven.model;

//Created by Aaron Trebus

//Class lays out the paramaters for Admin objects

//Carbon copy of Users objects; I went ahead with this still because
//I figured having Shoppers extend off of Admins would cause privacy issues

//Includes the username and password fields (will change if I can find a better way to format)

public class AdminModel extends UserModel{
	public AdminModel(String username, String password) {
		super(username,password);
	}
}
