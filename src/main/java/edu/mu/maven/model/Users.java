package edu.mu.maven.model;

//Created by Aaron Trebus

//Class is the default abstract Users type that Admin and Shopper will extend

public abstract class Users {
	
	private String username;
	private String password;
	
	public Users(String username, String password) {
		this.username=username;
		this.password=password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
