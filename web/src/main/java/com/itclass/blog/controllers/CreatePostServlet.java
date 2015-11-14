package com.itclass.blog.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itclass.blog.dao.PostDAO;
import com.itclass.blog.model.Post;

@WebServlet("/create")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PostDAO postDAO = new PostDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/blog/createpost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String tags = request.getParameter("tags");
		
		Post post = new Post(
				PostDAO.nextId(),
				title,
				new Date(),
				new Date(),
				content,
				(tags!=null)?Arrays.asList(tags.split(" ")):Arrays.asList()
				);
		
		postDAO.add(post);
		
		response.sendRedirect("blog");
	}

}
