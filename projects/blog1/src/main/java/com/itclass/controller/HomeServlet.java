package com.itclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itclass.model.Post;
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
		
		try {
			List<Post> posts = service.getAllPosts();
			request.setAttribute("posts", posts);
		} catch (Exception e) {
			// TODO return 404 
			e.printStackTrace();
		}
		
		request
		   .getRequestDispatcher("/WEB-INF/views/home.jsp")
		   .forward(request, response);
	}

}
