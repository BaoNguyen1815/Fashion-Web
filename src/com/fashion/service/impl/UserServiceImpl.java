package com.fashion.service.impl;

import java.io.File;
import java.util.List;

import com.fashion.dao.UserDao;
import com.fashion.dao.impl.UserDaoImpl;
import com.fashion.model.User;
import com.fashion.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public void edit(User newUser) {
		userDao.edit(newUser);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public User get(String username) {
		return userDao.get(username);
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public List<User> search(String username) {
		return userDao.search(username);
	}

	@Override
	public User login(String username, String password) {
		User user = this.get(username);

		if (user != null && password.equals(user.getPassword())) {
			return user;
		}

		return null;
	}

}
