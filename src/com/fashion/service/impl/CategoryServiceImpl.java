package com.fashion.service.impl;

import java.util.List;

import com.fashion.dao.CategoryDao;
import com.fashion.dao.impl.CategoryDaoImpl;
import com.fashion.model.Category;
import com.fashion.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao catDao = new CategoryDaoImpl();
	@Override
	public void insert(Category category) {
		catDao.insert(category);
	}

	@Override
	public void edit(Category category) {
		catDao.edit(category);
	}

	@Override
	public void delete(int id) {
		catDao.delete(id);
	}

	@Override
	public Category get(String username) {
		return catDao.get(username);
	}

	@Override
	public Category get(int id) {
		return catDao.get(id);
	}

	@Override
	public List<Category> getAll() {
		return catDao.getAll();
	}

	@Override
	public List<Category> search(String username) {
		return catDao.search(username);
	}
}
