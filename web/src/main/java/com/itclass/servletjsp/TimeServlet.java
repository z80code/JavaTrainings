package com.itclass.servletjsp;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/timeaction")
public class TimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GregorianCalendar calendar = new GregorianCalendar();
		String startTime = request.getParameter("time");
		long delta;
		if(startTime!=null) {
			delta = calendar.getTimeInMillis() - Long.parseLong(startTime);
		} else {
			delta = -1;
		}
		
		request.setAttribute("result", delta);
		request.getRequestDispatcher("WEB-INF/jsp/result.jsp").forward(request, response);
		
		// Для вызова перенаправления
		//response.sendRedirect("http:");
	}
}
