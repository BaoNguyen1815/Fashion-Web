package com.fashion.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.model.Category;
import com.fashion.model.User;
import com.fashion.service.CategoryService;
import com.fashion.service.UserService;
import com.fashion.service.impl.CategoryServiceImpl;
import com.fashion.service.impl.UserServiceImpl;

@WebServlet(urlPatterns= {"/admin/user/edit"})
public class EditUserController extends HttpServlet {
	UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String iduser = req.getParameter("id");
				
		User user = userService.get(Integer.parseInt(iduser));		
		req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/user/edit-user.jsp");
		dispatcher.forward(req, resp);
	}
}
