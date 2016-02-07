package com.itclass.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itclass.model.Article;
import com.itclass.services.ArticleService;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request
			.getRequestDispatcher("WEB-INF/views/create.jsp")
			.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String title = req.getParameter("title");
		 String author = req.getParameter("author");
		 String text = req.getParameter("text");
		 
		 Article article = new Article(-1,title, author, text, new Date());
		 
		 // if
		 // setAttribute article
		 // setAttribute errormessage
		 
		 try(ArticleService service = new ArticleService()) {
			
			 service.save(article);			 
			 resp.sendRedirect("home");
			 
		 } catch (Exception e) {
			
			 // doget
			e.printStackTrace();
		}

	}
}