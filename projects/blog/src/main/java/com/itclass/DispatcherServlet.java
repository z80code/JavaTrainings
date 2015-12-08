package com.itclass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.servlet.RequestScoped;
import com.itclass.controllers.*;
import com.itclass.services.BlogService;

@Singleton
@WebServlet("/dispatcher/*")
public class DispatcherServlet extends HttpServlet {
	private final static String BASE_VIEW_PATH = "/WEB-INF/views/";
	private final static String VIEW_POSTFIX = ".jsp";
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, Class<? extends Controller>> dispatcher;
	
	@Override
	public void init() throws ServletException {
		dispatcher = new HashMap<>();
    	dispatcher.put("/home", HomeController.class);
    	dispatcher.put("/", HomeController.class);
    	dispatcher.put("/login", LoginController.class);
    	dispatcher.put("/secured/page", SecuredController.class);
    }
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getRequestURI().substring(request.getContextPath().length()+"/dispatcher".length());
	
		Class<? extends Controller> controllerClass = dispatcher.get(path);
		Injector injector = (Injector) request.getAttribute("injector");
		
		Controller controller = null;
		if(controllerClass!=null) {
			controller = injector.getInstance(controllerClass);
		} else {
			controller = injector.getInstance(NotFoundController.class);
		}
		
		try {
			//System.out.println(controller);
			String view = controller.execute(request, response);
			
			if(view.contains(":")) {
				response.sendRedirect( request.getContextPath() +  view.split(":")[1]);
			} else {
				request.getRequestDispatcher(BASE_VIEW_PATH + view + VIEW_POSTFIX)
				.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			//response.sendRedirect("fff");
		}
		
	}
	
}
