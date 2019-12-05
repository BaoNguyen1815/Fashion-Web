package com.fashion.dao;

import java.util.List;

import com.fashion.model.User;

public interface UserDao {
	void insert(User user);

	void edit(User user);

	void delete(int id);

	public User get(String username);
	
	public User get(int id);

	public List<User> getAll();

	public List<User> search(String username);
}
