package com.fashion.service.impl;

import java.util.List;

import com.fashion.dao.ProductDao;
import com.fashion.dao.impl.ProductDaoImpl;
import com.fashion.model.Product;
import com.fashion.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao = new ProductDaoImpl();
	@Override
	public void insert(Product product) {
		productDao.insert(product);
	}

	@Override
	public void edit(Product product) {
		productDao.edit(product);
	}

	@Override
	public void delete(int id) {
		productDao.delete(id);
	}

	@Override
	public Product get(String username) {
		return productDao.get(username);
	}

	@Override
	public Product get(int id) {
		return productDao.get(id);
	}

	@Override
	public List<Product> getAll() {
		return productDao.getAll();
	}

	@Override
	public List<Product> search(String username) {
		return productDao.search(username);
	}
}
