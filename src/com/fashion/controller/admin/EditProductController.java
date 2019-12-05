package com.fashion.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.model.Category;
import com.fashion.model.Product;
import com.fashion.service.CategoryService;
import com.fashion.service.ProductService;
import com.fashion.service.impl.CategoryServiceImpl;
import com.fashion.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns= {"/admin/product/edit"})
public class EditProductController extends HttpServlet {

	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idcate = req.getParameter("id");
		
		Product product = productService.get(Integer.parseInt(idcate));
		req.setAttribute("product", product);
		
		List <Category> categories = categoryService.getAll();
		req.setAttribute("categories", categories);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/product/edit-product.jsp");
		dispatcher.forward(req, resp);
	}
}
