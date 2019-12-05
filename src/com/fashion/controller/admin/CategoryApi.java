package com.fashion.controller.admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

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
import com.google.gson.Gson;
@WebServlet(urlPatterns= {"/getListCategory/api/*"})
public class CategoryApi extends HttpServlet {

	CategoryService categoryService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	setAccessControlHeaders(resp);
		List<Category> categories = categoryService.getAll();
		
		Gson gson= new Gson();
		PrintWriter out= resp.getWriter();
		out.print(gson.toJson(categories));
		
	}
	
//	private void setAccessControlHeaders(HttpServletResponse resp) {
//	      resp.addHeader("Access-Control-Allow-Origin", "*");
//	      resp.addHeader("Access-Control-Allow-Methods", "GET");
////	      resp.addHeader("Access-Control-Allow-Methods", "POST");
//	      resp.addHeader("Access-Control-Allow-Methods", "PUT");
//	      resp.addHeader("Access-Control-Allow-Methods", "DELETE");
//	  }
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	setAccessControlHeaders(resp);
		String pathInfo = req.getPathInfo();

		if(resp == null || pathInfo.equals("/")){

			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String modelId = splits[1];
		categoryService.delete(Integer.parseInt(modelId));
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Category category = new Category();
		Gson gson= new Gson();
		Map map= req.getParameterMap();
		
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
		        buffer.append(line);
		    }
		    
		    String payload = buffer.toString();
		    category = gson.fromJson(payload, Category.class);
		    
		    categoryService.insert(category);
		//resp.sendRedirect("/Fashion/admin/user/list");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Category category = new Category();
		Gson gson= new Gson();
		
		String pathInfo = req.getPathInfo();

		if(resp == null || pathInfo.equals("/")){

			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String modelId = splits[1];
			StringBuilder buffer = new StringBuilder();
		    BufferedReader reader = req.getReader();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        buffer.append(line);
		    }
		    
		    String payload = buffer.toString();
		    category = gson.fromJson(payload, Category.class);
		    //category.setId(Integer.parseInt(modelId));
		    categoryService.edit(category); 
	}
}