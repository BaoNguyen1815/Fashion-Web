package com.fashion.controller.admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.model.Product;
import com.fashion.model.User;
import com.fashion.service.ProductService;
import com.fashion.service.UserService;
import com.fashion.service.impl.ProductServiceImpl;
import com.fashion.service.impl.UserServiceImpl;
import com.google.gson.Gson;
@WebServlet(urlPatterns= {"/getListProduct/api/*"})
public class ProductApi extends HttpServlet {
	
	ProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	setAccessControlHeaders(resp);
		List<Product> products = productService.getAll();
		
		Gson gson= new Gson();
		PrintWriter out= resp.getWriter();
		out.print(gson.toJson(products));		
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
		productService.delete(Integer.parseInt(modelId));
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
		Gson gson= new Gson();
		Map map= req.getParameterMap();
		
		//String name= String.valueOf(req.getParameter("name"));
		//String username= String.valueOf(req.getParameter("username"));
			StringBuilder buffer = new StringBuilder();
		    BufferedReader reader = req.getReader();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        buffer.append(line);
		    }
		    
		    String payload = buffer.toString();
		    product = gson.fromJson(payload, Product.class);
		    
		    productService.insert(product);
		//resp.sendRedirect("/Fashion/admin/user/list");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
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
		
		
		//String name= String.valueOf(req.getParameter("name"));
		//String username= String.valueOf(req.getParameter("username"));
			StringBuilder buffer = new StringBuilder();
		    BufferedReader reader = req.getReader();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        buffer.append(line);
		    }
		    
		    String payload = buffer.toString();
		    product = gson.fromJson(payload, Product.class);
		    product.setId(Integer.parseInt(modelId));
		    productService.edit(product);  
	}
}