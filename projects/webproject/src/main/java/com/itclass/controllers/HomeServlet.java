package com.itclass.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itclass.services.ArticleService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO
		
		try( ArticleService service = new ArticleService() ) {
			
			
			request.setAttribute("articles", service.getAll());
		
			request
				.getRequestDispatcher("WEB-INF/views/index.jsp")
				.forward(request, response);
			
			
		} catch ( Exception e) {
			// TODO return error page
			e.printStackTrace();
			
			response.getWriter().println(e.getMessage());
		}
		
		
	}

}
