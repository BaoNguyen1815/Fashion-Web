package com.fashion.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home" })
public class HomeController extends HttpServlet {
	/*
	 * ProductService productService = new ProductServiceImpl(); CategoryService
	 * cateService = new CategoryServiceImpl();
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * List<Category> categories = cateService.getAll();
		 * req.setAttribute("categories", categories); List<Product> products =
		 * productService.getAll(); req.setAttribute("products", products);
		 */
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/home.jsp");
		dispatcher.forward(req, resp);
	}

}
