package com.itclass.tasks;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Task1
 */
@WebServlet("/task1")
public class Task1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String page = "";
		
		Cookie[] cookies = request.getCookies();
		
		boolean isHasText = false;
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("text")) {
					page = getInfo(cookie.getValue());
					isHasText = true;
				}
			}
		}
		
		if(!isHasText) {
			page = getMainPage();
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().append(page);
	}
	
	private String getMainPage() {
		StringBuilder page = new StringBuilder();
		page.append("<form action='task1' method='post' >");
		page.append("<input type='text' name='text'> ");
		page.append("<input type='submit' value='Сохранить в Cookie'> ");
		page.append("</form>");
		return page.toString();
	}
	
	private String getInfo(String value) {
		StringBuilder page = new StringBuilder();
		page.append("Сохраненное значение: ");
		page.append(value);
		page.append("<br>");
		page.append("<form action='task1?deleteCookie' method='post' >");
		page.append("<input type='submit' value='Удалить cookie'> ");
		page.append("</form>");
		
		return page.toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String isDeleteCookie = request.getParameter("deleteCookie");
		
		if(isDeleteCookie!=null) {
			Cookie cookie = new Cookie("text", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			response.getWriter().append(getMainPage());
		} else {
			String text = request.getParameter("text");
			Cookie cookie = new Cookie("text", text);
			response.addCookie(cookie);
			
			response.getWriter().append(getInfo(text));
		}
		
	}

}
