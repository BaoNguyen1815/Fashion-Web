package com.fashion.service;

import java.util.List;

import com.fashion.model.Category;

public interface CategoryService {
	void insert(Category category);

	void edit(Category category);

	void delete(int id);

	public Category get(String username);
	
	public Category get(int id);
	
	public List<Category> getAll();

	public List<Category> search(String keyword);
}
