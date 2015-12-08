package com.itclass.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends AbstractController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String view = null;

		switch (request.getMethod()) {
		case "POST":
			view = post(request, response);
			break;
		default:
			view = get(request, response);
			break;
		}

		return view;
	}

	private String get(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

	private String post(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// User user = userDAO.find(username, password);
		if (username.equals("igor") && password.equals("123")) {
			String user = username;
			request.getSession().setAttribute("user", user); // Put user in
																// session.
			return "redirect:/home";

		} else {
			request.setAttribute("error", "Unknown login, try again");
			return "login";
		}
	}
}
