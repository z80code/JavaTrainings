package com.itclass;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.itclass.services.BlogService;

@Singleton
@WebFilter // ("/*")
public class UrlFilter implements Filter {

	public UrlFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Inject
	private Injector injector;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI().substring(req.getContextPath().length());

		// String path = req.getRequestURI();
		// System.out.println(">>>>"+path+" "+req.getRequestURI());
		if (path.startsWith("/resources/")) {
			// Just let container's default servlet do its job.
			chain.doFilter(request, response);
		} else {
			request.setAttribute("injector", injector);

			if (path.startsWith("/secured/")) {
				if (((HttpServletRequest) request).getSession().getAttribute("user") == null) {
					request.getRequestDispatcher("/dispatcher/login").forward(request, response);
				} else {
					request.getRequestDispatcher("/dispatcher" + path).forward(request, response);
				}
			} else {
				request.getRequestDispatcher("/dispatcher" + path).forward(request, response);
			}

		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
