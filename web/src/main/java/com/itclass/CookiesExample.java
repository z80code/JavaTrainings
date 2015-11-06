package com.itclass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test2")
public class CookiesExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookiesExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		
		
		boolean isUserLoggined = false;
		for(Cookie cookie : cookies) {
			//System.out.println(cookie.getName()+" : "+cookie.getValue());
			if(cookie.getName().equals("auth") 
					&& cookie.getValue().equals("logined")) {
				
				isUserLoggined = true;
				break;
			}
		}
		
		if(isUserLoggined) {
			loginedPage(response);
		} else {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			StringBuilder page = new StringBuilder();
			
			page.append("<html>");
			page.append("<body>");
			page.append("<form method='post' action='Test2' >");
			
			page.append("Введите логин:<br>");
			page.append("<input type='text' name='login' ><br>");
			page.append("Введите пароль: <br>");
			page.append("<input type='password' name='password' ><br>");
			
			page.append("<input type='submit' value='Войти' >");
			
			page.append("</form>");
			page.append("</body>");
			page.append("</html>");
			
			
			response.getWriter().append(page);
		
		}
		
	}
	
	private void loginedPage(HttpServletResponse response) throws IOException {
		StringBuilder page = new StringBuilder();
		
		page.append("<html>");
		page.append("<body>");
		page.append("Добро пожаловать ");
		page.append("</body>");
		page.append("</html>");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = (String)request.getParameter("login");
		String password = (String)request.getParameter("password");
		
		if(password.equals("123")) {
			
			Cookie cookie = new Cookie("auth", "logined");
			cookie.setMaxAge(100);
			response.addCookie(cookie);
		}
		
		doGet(request, response);
		
	}

}
