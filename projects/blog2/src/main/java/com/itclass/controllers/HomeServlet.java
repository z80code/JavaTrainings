package com.itclass.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itclass.services.BlogService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BlogService service;
	
	@Override
	public void init() throws ServletException {
		service = new BlogService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("posts",service.getAll() );
		
		request
			.getRequestDispatcher("/WEB-INF/views/index.jsp")
			.forward(request, response);
	}
}