package com.banksimulation.model;

public class User {

	private int id;
	private String username;
	private String email;
	private String type;
	private String password;
	
	
	public User(int id, String username, String email, String type) {
		this.username = username;
		this.email = email;
		this.type = type;
	}
	
	public User(String username, String email, String type,String password) {
		this.username = username;
		this.email = email;
		this.type = type;
		this.password = password;
	}
	
	public User(int id, String username, String email, String type,String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.type = type;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", type=" + type + ", password="
				+ password + "]";
	}

}
