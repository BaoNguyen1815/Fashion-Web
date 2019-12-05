package com.fashion.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.model.User;
import com.fashion.service.UserService;
import com.fashion.service.impl.UserServiceImpl;
@WebServlet(urlPatterns= {"/admin/product/list"})
public class ProductListController extends HttpServlet {
	UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 List<User> userList = userService.getAll(); req.setAttribute("userList",
		  userList);
		 */
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/product/list-product.jsp");
		dispatcher.forward(req, resp);
	}
	
}
		