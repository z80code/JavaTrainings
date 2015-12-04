package com.itclass.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itclass.model.Post;
import com.itclass.services.BlogService;


@WebServlet("/createpost")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BlogService service;
	
	@Override
	public void init() throws ServletException {
		service = new BlogService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
		   .getRequestDispatcher("/WEB-INF/views/new_post.jsp")
		   .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String tags = request.getParameter("tags");
		
		Date date = new Date();
		Post post = new Post(null,title, date, date,content, tags);
		
		System.out.println(post);
		
		
		try {
			service.savePost(post);
		} catch (Exception e) {
			// TODO Error handling
			e.printStackTrace();
		}
		
		response.sendRedirect("home");
	}

}
