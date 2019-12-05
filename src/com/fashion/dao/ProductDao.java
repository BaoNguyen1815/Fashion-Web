package com.fashion.dao;

import java.util.List;

import com.fashion.model.Product;

public interface ProductDao {
	void insert(Product product);

	void edit(Product Product);

	void delete(int id);

	public Product get(String username);
	
	public Product get(int id);

	public List<Product> getAll();

	public List<Product> search(String username);
}
