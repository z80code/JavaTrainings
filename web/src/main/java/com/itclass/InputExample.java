package com.itclass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input")
public class InputExample extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String text = null;
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) { 
			for(Cookie cookie : cookies ) {
				if(cookie.getName().equals("text")) {
					text = cookie.getValue();
				}
			}
		}
		
		String page = getPage(text);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		response.getWriter().append(page);
	}
	
	private String getPage(String text) {
		
		StringBuilder page = new StringBuilder();
		page.append("<html>");
		page.append("<body>");
		
		
		if(text!=null) {
			page.append(text);
		}
	
		page.append("<form method='post' action='input' >");
		page.append("Введите текст: <br>");
		page.append("<input type='text' name='text' ><br>");
		page.append("<input type='submit' value='Отправить'><br>");
		page.append("</form>");
		
		page.append("</body>");
		page.append("</html>");
		
		return page.toString();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String text = request.getParameter("text");
		
		Cookie cookie = new Cookie("text", text);
		cookie.setMaxAge(30);
		
		
		response.addCookie(cookie);
		
		String page = getPage(text);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		response.getWriter().append(page);
	}
	
	
	
	

}
