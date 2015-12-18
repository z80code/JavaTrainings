package com.itclass.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/")
public class EncodingFilter implements Filter {

	public void destroy() { }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		String path = req.getRequestURI().substring(req.getContextPath().length());

		// String path = req.getRequestURI();
		// System.out.println(">>>>"+path+" "+req.getRequestURI());
		if (path.startsWith("/resources/")) {
			// Just let container's default servlet do its job.
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/" + path).forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}