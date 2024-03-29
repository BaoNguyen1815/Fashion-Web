package com.fashion.model;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String name;
	private String username;
	private String password;
	private String rollAdmin;
	private String avatar;
	//private String activeYN;
	

	public String getRollAdmin() {
		return rollAdmin;
	}

	public void setRollAdmin(String rollAdmin) {
		this.rollAdmin = rollAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
