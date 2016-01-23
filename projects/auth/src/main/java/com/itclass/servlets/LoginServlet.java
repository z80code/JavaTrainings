package com.itclass.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itclass.model.User;
import com.itclass.services.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	// TODO 
	private UserService service = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toView(request, response, "login");
	}
	
	private void toView(HttpServletRequest request,HttpServletResponse response,  String view) throws ServletException, IOException {
		request
			.getRequestDispatcher("/WEB-INF/views/"+view+".jsp")
			.forward(request, response);
	}
	
	private final static String ERROR_MESSAGE = "don't valid email or password";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email==null || password == null) {
			request.setAttribute("error", ERROR_MESSAGE);
			toView(request, response, "login");
		}
		
		if(service.checkUserPassword(email, password)) {
			User user = service.getUserByEmail(email);
			request.getSession().setAttribute("user", user );
			
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("error", ERROR_MESSAGE);
			toView(request, response, "login");
		}
		
		
	}

}
