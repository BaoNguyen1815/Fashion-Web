package com.fashion.controller.admin;

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

@WebServlet(urlPatterns= {"/admin/category/edit"})
public class EditCategoryController extends HttpServlet {
	CategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idcate = req.getParameter("id");
		
		Category category = categoryService.get(Integer.parseInt(idcate));
		req.setAttribute("category", category);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/category/edit-category.jsp");
		dispatcher.forward(req, resp);
	}
}
