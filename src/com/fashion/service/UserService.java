package com.fashion.service;

import java.util.List;

import com.fashion.model.User;

public interface UserService {
	void insert(User user);

	void edit(User user);

	void delete(int id);

	public User get(String username);
	
	public User get(int id);
	
	public User login(String username, String password);

	public List<User> getAll();

	public List<User> search(String keyword);
}
