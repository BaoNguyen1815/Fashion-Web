package com.fashion.controller.admin;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.model.Category;
import com.fashion.service.CategoryService;
import com.fashion.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns= {"/admin/product/add"})
public class AddProductController extends HttpServlet {
	CategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/product/add-product.jsp");
			
		List <Category> categories = categoryService.getAll();
		req.setAttribute("categories", categories);
		dispatcher.forward(req, resp);
	}
	
}
