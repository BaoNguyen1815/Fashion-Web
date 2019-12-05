package com.fashion.controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.UserDao;
import com.fashion.model.User;
import com.fashion.service.UserService;
import com.fashion.service.impl.UserServiceImpl;


@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	UserService uImpl = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/login/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String pass = req.getParameter("password");
		
		User user = uImpl.get(uname);
		
		if (user != null && user.getPassword().equals(pass)) {
			//System.out.println("Thanh cong");		
			resp.sendRedirect("/Fashion/view/login/log.jsp");
		} else {
			resp.sendRedirect("/Fashion/view/login/error.jsp");
		}
	}
}
