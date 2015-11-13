package com.itclass.tasks;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Task2
 */
@WebServlet("/task2")
public class Task2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("text")) {
					request.setAttribute("savedText", cookie.getValue());
					request.getRequestDispatcher("WEB-INF/task2/info.jsp")
						.forward(request, response);
				}
			}
		}
		
		request.getRequestDispatcher("WEB-INF/task2/index.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isDeleteCookie = request.getParameter("deleteCookie");
		
		if(isDeleteCookie!=null) {
			
			Cookie cookie = new Cookie("text", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			request.getRequestDispatcher("WEB-INF/task2/index.jsp").forward(request, response);;
		
		} else {
			String text = request.getParameter("text");
			Cookie cookie = new Cookie("text", text);
			response.addCookie(cookie);
			
			request.setAttribute("savedText", cookie.getValue());
			request.getRequestDispatcher("WEB-INF/task2/info.jsp").forward(request, response);;
		}
		
	}

}
