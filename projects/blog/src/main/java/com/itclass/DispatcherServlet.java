package com.itclass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itclass.controllers.*;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private final static String BASE_VIEW_PATH = "/WEB-INF/views/";
	private final static String VIEW_POSTFIX = ".jsp";
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, AbstractController> dispatcher;
	
    public DispatcherServlet() {
    	dispatcher = new HashMap<>();
    	dispatcher.put("/home", new HomeController());
    	dispatcher.put("/", new HomeController());
    }
        
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		AbstractController controller = dispatcher.get(path);
		
		try {
			String view = controller.execute(request, response);
			request.getRequestDispatcher(BASE_VIEW_PATH + view + VIEW_POSTFIX)
				.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("fff");
		}
		
	}
	
}
