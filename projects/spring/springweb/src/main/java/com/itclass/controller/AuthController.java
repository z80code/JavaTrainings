package com.itclass.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	UserService service;

	@RequestMapping("/login")
	public ModelAndView getLogin() {
		String message = "hi from controller";
		return new ModelAndView("login", "message", message);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST )
	public ModelAndView postLogin(String username, String password) {
		
		if(service.checkUser(username, password)) {
			request.getSession().setAttribute("user", username);
		}
		
		return new ModelAndView("redirect:welcome");
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST )
	public ModelAndView logout() {
		
		request.getSession().removeAttribute("user");
		
		
		return new ModelAndView("redirect:welcome");
	}
	
}
