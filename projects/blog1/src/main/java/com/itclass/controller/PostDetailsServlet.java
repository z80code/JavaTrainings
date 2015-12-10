package com.itclass.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itclass.model.Post;
import com.itclass.services.BlogService;

@WebServlet("/post")
public class PostDetailsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private BlogService service;
	
	
	@Override
	public void init() throws ServletException {
		service = new BlogService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idStr = request.getParameter("id");
		
		try {
		
			int id = Integer.parseInt(idStr);
			Post post = service.getPostById(id);
			request.setAttribute("post", post);
			
			request
				.getRequestDispatcher("/WEB-INF/views/post.jsp")
				.forward(request, response);
				
		
		} catch(Exception e) {
			// TODO need redirect to error page
			e.printStackTrace();
		}
		
		
		
	}
}
