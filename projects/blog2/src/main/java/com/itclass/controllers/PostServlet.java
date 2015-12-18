package com.itclass.controllers;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itclass.model.Post;
import com.itclass.services.BlogService;

@WebServlet("/post")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BlogService service;

	@Override
	public void init() throws ServletException {
		service = new BlogService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idString = request.getParameter("id");
		
		Post post = null;
		
		try {
			int id = Integer.parseInt(idString);
			post = service.get(id);
			
		} catch(NumberFormatException e) {
			System.out.println("Not valid ID: "+ idString);
		}
		
		request.setAttribute("post", post);

		request
		.getRequestDispatcher("/WEB-INF/views/details.jsp")
		.forward(request, response);
	}

}