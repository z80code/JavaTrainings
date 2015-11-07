package com.itclass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		StringBuilder page = new StringBuilder();
		
		page.append("<html>");
		page.append("<body>");
		page.append("<form method='post' action='Test' >");
		
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = (String)request.getParameter("login");
		String password = (String)request.getParameter("password");
		
		if(password.equals("123")) {
			
			StringBuilder page = new StringBuilder();
			
			page.append("<html>");
			page.append("<body>");
			page.append("Добро пожаловать ");
			page.append(login);
			page.append("</body>");
			page.append("</html>");
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(page);
			
		} else {
			doGet(request, response);
		}
	}

}
