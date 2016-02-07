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

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(ArticleService service = new ArticleService() ) {
			
			String strId = request.getParameter("id");		
			int id = Integer.parseInt(strId);
			Article article = service.getById(id);
			request.setAttribute("article", article);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		request
			.getRequestDispatcher("WEB-INF/views/article.jsp")
			.forward(request, response);
		
	}
}
