package com.itclass.cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookies")
public class CookiesExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String htmlForm = "<html> <body> "
			+ "<form action='cookies' method='post'> <input type='text' name='text' > </input> <input type='submit' />  </form>" 
			+ " </body> </html>";
	
	// NOTE если нужно работать без поддержки cookies можно использовать URL Rewriting 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			System.out.println(cookie.getName()+" : "+cookie.getValue());
		}
		
		response.setContentType("text/html");
		
		response.getWriter().append(htmlForm);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie = new Cookie("my", "value");
		// keep cookies one day
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		doGet(request, response);
	}

}
