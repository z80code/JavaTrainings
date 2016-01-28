package com.itclass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
    	
    }
    
    // TODO следует использовать фабрику или DI
    private UserService service= new UserService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request
			.getRequestDispatcher("WEB-INF/views/login.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(service.checkUser(userName, password)) {
			System.out.println("enter");
			
			User user = service.getUserByName(userName);
			
			if(user!=null) {
				request.getSession().setAttribute("user", user);
			}
			
			response.sendRedirect( request.getContextPath() );	
		
		} else {
			System.out.println("error");
			request.setAttribute("error", "Invalid user name or password");
			doGet(request, response);	
		}	
	}

}
