package com.fashion.service;

import java.util.List;

import com.fashion.model.Product;

public interface ProductService {
	void insert(Product product);

	void edit(Product product);

	void delete(int id);

	public Product get(String username);
	
	public Product get(int id);
	
	public List<Product> getAll();

	public List<Product> search(String keyword);
}
