package com.itclass.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itclass.model.Post;
import com.itclass.services.BlogService;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BlogService service;

	@Override
	public void init() throws ServletException {
		service = new BlogService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
		.getRequestDispatcher("/WEB-INF/views/edit_post.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("post.title");
		String content = request.getParameter("post.content");
		String tags = request.getParameter("post.tag");
		
		Date date = new Date();
		Post post = new Post(null,title, date, date,content, tags);
		service.save(post);
		
		response.sendRedirect(request.getContextPath());
	}

}
